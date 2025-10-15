package org.finos.waltz.service.bulk_upload.column_parsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition.Builder;
import org.finos.waltz.model.bulk_upload.ResolutionStatus;
import org.finos.waltz.model.bulk_upload.ResolvedAssessmentHeaderStatus;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.AssessmentCell;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.AssessmentHeaderCell;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableAssessmentCell;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableAssessmentHeaderCell;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GenericRatingColumnParserDiffblueTest {
  @Mock private AssessmentHeaderCell assessmentHeaderCell;

  @InjectMocks private GenericRatingColumnParser genericRatingColumnParser;

  /**
   * Test {@link GenericRatingColumnParser#apply(String, Collection)} with {@code String}, {@code
   * Collection}.
   *
   * <p>Method under test: {@link GenericRatingColumnParser#apply(String, Collection)}
   */
  @Test
  @DisplayName("Test apply(String, Collection) with 'String', 'Collection'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentCell GenericRatingColumnParser.apply(String, Collection)"})
  void testApplyWithStringCollection() {
    // Arrange
    HashMap<String, RatingSchemeItem> stringRatingSchemeItemMap = new HashMap<>();
    stringRatingSchemeItemMap.put(
        "42",
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
    when(assessmentHeaderCell.columnId()).thenReturn(1);
    when(assessmentHeaderCell.ratingLookupMap()).thenReturn(stringRatingSchemeItemMap);

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<AssessmentDefinition> ofResult = Optional.of(immutableAssessmentDefinition);
    when(assessmentHeaderCell.resolvedAssessmentDefinition()).thenReturn(ofResult);

    ArrayList<Tuple2<Long, Long>> existingRatingInfo = new ArrayList<>();
    existingRatingInfo.add(new Tuple2<>(1L, 1L));
    existingRatingInfo.add(new Tuple2<>(1L, 1L));

    // Act
    AssessmentCell actualApplyResult = genericRatingColumnParser.apply("42", existingRatingInfo);

    // Assert
    verify(assessmentHeaderCell).columnId();
    verify(assessmentHeaderCell).ratingLookupMap();
    verify(assessmentHeaderCell).resolvedAssessmentDefinition();
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("42", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.ratings().size());
    Set<ResolutionStatus> statusesResult = actualApplyResult.statuses();
    assertEquals(1, statusesResult.size());
    assertTrue(statusesResult.contains(ResolutionStatus.NEW));
  }

  /**
   * Test {@link GenericRatingColumnParser#apply(String, Collection)} with {@code String}, {@code
   * Collection}.
   *
   * <p>Method under test: {@link GenericRatingColumnParser#apply(String, Collection)}
   */
  @Test
  @DisplayName("Test apply(String, Collection) with 'String', 'Collection'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentCell GenericRatingColumnParser.apply(String, Collection)"})
  void testApplyWithStringCollection2() {
    // Arrange
    ImmutableAssessmentHeaderCell.Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    Optional<? extends EntityReference> qualifierReference = Optional.empty();
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    ImmutableAssessmentHeaderCell.Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentHeaderCell headerCell =
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build();
    GenericRatingColumnParser genericRatingColumnParser = new GenericRatingColumnParser(headerCell);

    // Act
    AssessmentCell actualApplyResult = genericRatingColumnParser.apply("42", new ArrayList<>());

    // Assert
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("42", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.ratings().size());
    Set<ResolutionStatus> statusesResult = actualApplyResult.statuses();
    assertEquals(1, statusesResult.size());
    assertTrue(statusesResult.contains(ResolutionStatus.ERROR));
  }

  /**
   * Test {@link GenericRatingColumnParser#apply(String, Collection)} with {@code String}, {@code
   * Collection}.
   *
   * <ul>
   *   <li>Given {@link Tuple2#Tuple2(Object, Object)} with v1 is one and v2 is one.
   * </ul>
   *
   * <p>Method under test: {@link GenericRatingColumnParser#apply(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test apply(String, Collection) with 'String', 'Collection'; given Tuple2(Object, Object) with v1 is one and v2 is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentCell GenericRatingColumnParser.apply(String, Collection)"})
  void testApplyWithStringCollection_givenTuple2WithV1IsOneAndV2IsOne() {
    // Arrange
    when(assessmentHeaderCell.columnId()).thenReturn(1);
    when(assessmentHeaderCell.ratingLookupMap()).thenReturn(new HashMap<>());

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<AssessmentDefinition> ofResult = Optional.of(immutableAssessmentDefinition);
    when(assessmentHeaderCell.resolvedAssessmentDefinition()).thenReturn(ofResult);

    ArrayList<Tuple2<Long, Long>> existingRatingInfo = new ArrayList<>();
    existingRatingInfo.add(new Tuple2<>(1L, 1L));

    // Act
    AssessmentCell actualApplyResult = genericRatingColumnParser.apply("42", existingRatingInfo);

    // Assert
    verify(assessmentHeaderCell).columnId();
    verify(assessmentHeaderCell).ratingLookupMap();
    verify(assessmentHeaderCell).resolvedAssessmentDefinition();
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("42", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.ratings().size());
    Set<ResolutionStatus> statusesResult = actualApplyResult.statuses();
    assertEquals(1, statusesResult.size());
    assertTrue(statusesResult.contains(ResolutionStatus.ERROR));
  }

  /**
   * Test {@link GenericRatingColumnParser#apply(String, Collection)} with {@code String}, {@code
   * Collection}.
   *
   * <ul>
   *   <li>Given {@link Tuple2#Tuple2(Object, Object)} with v1 is one and v2 is one.
   * </ul>
   *
   * <p>Method under test: {@link GenericRatingColumnParser#apply(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test apply(String, Collection) with 'String', 'Collection'; given Tuple2(Object, Object) with v1 is one and v2 is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentCell GenericRatingColumnParser.apply(String, Collection)"})
  void testApplyWithStringCollection_givenTuple2WithV1IsOneAndV2IsOne2() {
    // Arrange
    when(assessmentHeaderCell.columnId()).thenReturn(1);
    when(assessmentHeaderCell.ratingLookupMap()).thenReturn(new HashMap<>());

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<AssessmentDefinition> ofResult = Optional.of(immutableAssessmentDefinition);
    when(assessmentHeaderCell.resolvedAssessmentDefinition()).thenReturn(ofResult);

    ArrayList<Tuple2<Long, Long>> existingRatingInfo = new ArrayList<>();
    existingRatingInfo.add(new Tuple2<>(1L, 1L));
    existingRatingInfo.add(new Tuple2<>(1L, 1L));

    // Act
    AssessmentCell actualApplyResult = genericRatingColumnParser.apply("42", existingRatingInfo);

    // Assert
    verify(assessmentHeaderCell).columnId();
    verify(assessmentHeaderCell).ratingLookupMap();
    verify(assessmentHeaderCell).resolvedAssessmentDefinition();
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("42", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.ratings().size());
    Set<ResolutionStatus> statusesResult = actualApplyResult.statuses();
    assertEquals(1, statusesResult.size());
    assertTrue(statusesResult.contains(ResolutionStatus.ERROR));
  }

  /**
   * Test {@link GenericRatingColumnParser#apply(String, Collection)} with {@code String}, {@code
   * Collection}.
   *
   * <ul>
   *   <li>Then return inputString is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GenericRatingColumnParser#apply(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test apply(String, Collection) with 'String', 'Collection'; then return inputString is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentCell GenericRatingColumnParser.apply(String, Collection)"})
  void testApplyWithStringCollection_thenReturnInputStringIs42() {
    // Arrange
    when(assessmentHeaderCell.columnId()).thenReturn(1);
    when(assessmentHeaderCell.ratingLookupMap()).thenReturn(new HashMap<>());

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<AssessmentDefinition> ofResult = Optional.of(immutableAssessmentDefinition);
    when(assessmentHeaderCell.resolvedAssessmentDefinition()).thenReturn(ofResult);

    // Act
    AssessmentCell actualApplyResult = genericRatingColumnParser.apply("42", new ArrayList<>());

    // Assert
    verify(assessmentHeaderCell).columnId();
    verify(assessmentHeaderCell).ratingLookupMap();
    verify(assessmentHeaderCell).resolvedAssessmentDefinition();
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("42", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.ratings().size());
    Set<ResolutionStatus> statusesResult = actualApplyResult.statuses();
    assertEquals(1, statusesResult.size());
    assertTrue(statusesResult.contains(ResolutionStatus.ERROR));
  }

  /**
   * Test {@link GenericRatingColumnParser#apply(String, Collection)} with {@code String}, {@code
   * Collection}.
   *
   * <ul>
   *   <li>Then return statuses size is two.
   * </ul>
   *
   * <p>Method under test: {@link GenericRatingColumnParser#apply(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test apply(String, Collection) with 'String', 'Collection'; then return statuses size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentCell GenericRatingColumnParser.apply(String, Collection)"})
  void testApplyWithStringCollection_thenReturnStatusesSizeIsTwo() {
    // Arrange
    ImmutableAssessmentHeaderCell.Builder builderResult = ImmutableAssessmentHeaderCell.builder();
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    SimpleEntry<String, RatingSchemeItem> entry =
        new SimpleEntry<>("foo", immutableRatingSchemeItem);
    builderResult.putRatingLookupMap(entry);

    ImmutableAssessmentHeaderCell.Builder inputStringResult =
        builderResult.columnId(1).inputString("Input String");

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    Optional<? extends EntityReference> qualifierReference = Optional.empty();
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    ImmutableAssessmentHeaderCell.Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem2 =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem2);
    ImmutableAssessmentHeaderCell headerCell =
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build();
    GenericRatingColumnParser genericRatingColumnParser = new GenericRatingColumnParser(headerCell);

    // Act
    AssessmentCell actualApplyResult =
        genericRatingColumnParser.apply("foo;bar", new ArrayList<>());

    // Assert
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("foo;bar", actualApplyResult.inputString());
    assertEquals(2, actualApplyResult.ratings().size());
    Set<ResolutionStatus> statusesResult = actualApplyResult.statuses();
    assertEquals(2, statusesResult.size());
    assertTrue(statusesResult.contains(ResolutionStatus.NEW));
  }

  /**
   * Test {@link GenericRatingColumnParser#apply(String, Collection)} with {@code String}, {@code
   * Collection}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return inputString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link GenericRatingColumnParser#apply(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test apply(String, Collection) with 'String', 'Collection'; when empty string; then return inputString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentCell GenericRatingColumnParser.apply(String, Collection)"})
  void testApplyWithStringCollection_whenEmptyString_thenReturnInputStringIsEmptyString() {
    // Arrange
    when(assessmentHeaderCell.columnId()).thenReturn(1);

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<AssessmentDefinition> ofResult = Optional.of(immutableAssessmentDefinition);
    when(assessmentHeaderCell.resolvedAssessmentDefinition()).thenReturn(ofResult);

    // Act
    AssessmentCell actualApplyResult = genericRatingColumnParser.apply("", new ArrayList<>());

    // Assert
    verify(assessmentHeaderCell).columnId();
    verify(assessmentHeaderCell).resolvedAssessmentDefinition();
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.columnId());
    assertTrue(actualApplyResult.ratings().isEmpty());
    assertTrue(actualApplyResult.statuses().isEmpty());
  }

  /**
   * Test {@link GenericRatingColumnParser#apply(String, Collection)} with {@code String}, {@code
   * Collection}.
   *
   * <ul>
   *   <li>When {@code foo;bar}.
   *   <li>Then return inputString is {@code foo;bar}.
   * </ul>
   *
   * <p>Method under test: {@link GenericRatingColumnParser#apply(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test apply(String, Collection) with 'String', 'Collection'; when 'foo;bar'; then return inputString is 'foo;bar'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentCell GenericRatingColumnParser.apply(String, Collection)"})
  void testApplyWithStringCollection_whenFooBar_thenReturnInputStringIsFooBar() {
    // Arrange
    when(assessmentHeaderCell.columnId()).thenReturn(1);
    when(assessmentHeaderCell.ratingLookupMap()).thenReturn(new HashMap<>());

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<AssessmentDefinition> ofResult = Optional.of(immutableAssessmentDefinition);
    when(assessmentHeaderCell.resolvedAssessmentDefinition()).thenReturn(ofResult);

    // Act
    AssessmentCell actualApplyResult =
        genericRatingColumnParser.apply("foo;bar", new ArrayList<>());

    // Assert
    verify(assessmentHeaderCell).columnId();
    verify(assessmentHeaderCell, atLeast(1)).ratingLookupMap();
    verify(assessmentHeaderCell).resolvedAssessmentDefinition();
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("foo;bar", actualApplyResult.inputString());
    Set<ResolutionStatus> statusesResult = actualApplyResult.statuses();
    assertEquals(1, statusesResult.size());
    assertEquals(2, actualApplyResult.ratings().size());
    assertTrue(statusesResult.contains(ResolutionStatus.ERROR));
  }

  /**
   * Test {@link GenericRatingColumnParser#apply(String, Collection)} with {@code String}, {@code
   * Collection}.
   *
   * <ul>
   *   <li>When {@code ;}.
   *   <li>Then return inputString is {@code ;}.
   * </ul>
   *
   * <p>Method under test: {@link GenericRatingColumnParser#apply(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test apply(String, Collection) with 'String', 'Collection'; when ';'; then return inputString is ';'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentCell GenericRatingColumnParser.apply(String, Collection)"})
  void testApplyWithStringCollection_whenSemicolon_thenReturnInputStringIsSemicolon() {
    // Arrange
    when(assessmentHeaderCell.columnId()).thenReturn(1);

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<AssessmentDefinition> ofResult = Optional.of(immutableAssessmentDefinition);
    when(assessmentHeaderCell.resolvedAssessmentDefinition()).thenReturn(ofResult);

    // Act
    AssessmentCell actualApplyResult = genericRatingColumnParser.apply(";", new ArrayList<>());

    // Assert
    verify(assessmentHeaderCell).columnId();
    verify(assessmentHeaderCell).resolvedAssessmentDefinition();
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals(";", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.columnId());
    assertTrue(actualApplyResult.ratings().isEmpty());
    assertTrue(actualApplyResult.statuses().isEmpty());
  }
}
