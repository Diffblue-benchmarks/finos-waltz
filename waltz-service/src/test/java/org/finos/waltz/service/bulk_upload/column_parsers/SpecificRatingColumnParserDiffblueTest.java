package org.finos.waltz.service.bulk_upload.column_parsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
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
import org.finos.waltz.model.bulk_upload.ResolutionStatus;
import org.finos.waltz.model.bulk_upload.ResolvedAssessmentHeaderStatus;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.AssessmentCell;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.AssessmentHeaderCell;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableAssessmentCell;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableAssessmentHeaderCell;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableAssessmentHeaderCell.Builder;
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
class SpecificRatingColumnParserDiffblueTest {
  @Mock private AssessmentHeaderCell assessmentHeaderCell;

  @InjectMocks private SpecificRatingColumnParser specificRatingColumnParser;

  /**
   * Test {@link SpecificRatingColumnParser#apply(String, Collection)} with {@code String}, {@code
   * Collection}.
   *
   * <ul>
   *   <li>Then calls {@link AssessmentHeaderCell#columnId()}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificRatingColumnParser#apply(String, Collection)}
   */
  @Test
  @DisplayName("Test apply(String, Collection) with 'String', 'Collection'; then calls columnId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentCell SpecificRatingColumnParser.apply(String, Collection)"})
  void testApplyWithStringCollection_thenCallsColumnId() {
    // Arrange
    when(assessmentHeaderCell.columnId()).thenReturn(1);

    ImmutableAssessmentDefinition.Builder provenanceResult =
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
    Optional<RatingSchemeItem> ofResult2 = Optional.of(immutableRatingSchemeItem);
    when(assessmentHeaderCell.resolvedRating()).thenReturn(ofResult2);

    // Act
    AssessmentCell actualApplyResult = specificRatingColumnParser.apply("42", new ArrayList<>());

    // Assert
    verify(assessmentHeaderCell).columnId();
    verify(assessmentHeaderCell).resolvedAssessmentDefinition();
    verify(assessmentHeaderCell, atLeast(1)).resolvedRating();
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("42", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.ratings().size());
    Set<ResolutionStatus> statusesResult = actualApplyResult.statuses();
    assertEquals(1, statusesResult.size());
    assertEquals(1, actualApplyResult.columnId());
    assertTrue(statusesResult.contains(ResolutionStatus.NEW));
  }

  /**
   * Test {@link SpecificRatingColumnParser#apply(String, Collection)} with {@code String}, {@code
   * Collection}.
   *
   * <ul>
   *   <li>Then return statuses contains {@code EXISTING}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificRatingColumnParser#apply(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test apply(String, Collection) with 'String', 'Collection'; then return statuses contains 'EXISTING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentCell SpecificRatingColumnParser.apply(String, Collection)"})
  void testApplyWithStringCollection_thenReturnStatusesContainsExisting() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
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

    Builder resolvedAssessmentDefinitionResult =
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
    SpecificRatingColumnParser specificRatingColumnParser =
        new SpecificRatingColumnParser(headerCell);

    ArrayList<Tuple2<Long, Long>> existingRatings = new ArrayList<>();
    existingRatings.add(new Tuple2<>(1L, 1L));

    // Act
    AssessmentCell actualApplyResult = specificRatingColumnParser.apply("42", existingRatings);

    // Assert
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("42", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.ratings().size());
    Set<ResolutionStatus> statusesResult = actualApplyResult.statuses();
    assertEquals(1, statusesResult.size());
    assertEquals(1, actualApplyResult.columnId());
    assertTrue(statusesResult.contains(ResolutionStatus.EXISTING));
  }

  /**
   * Test {@link SpecificRatingColumnParser#apply(String, Collection)} with {@code String}, {@code
   * Collection}.
   *
   * <ul>
   *   <li>Then return statuses contains {@code EXISTING}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificRatingColumnParser#apply(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test apply(String, Collection) with 'String', 'Collection'; then return statuses contains 'EXISTING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentCell SpecificRatingColumnParser.apply(String, Collection)"})
  void testApplyWithStringCollection_thenReturnStatusesContainsExisting2() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
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

    Builder resolvedAssessmentDefinitionResult =
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
    SpecificRatingColumnParser specificRatingColumnParser =
        new SpecificRatingColumnParser(headerCell);

    ArrayList<Tuple2<Long, Long>> existingRatings = new ArrayList<>();
    existingRatings.add(new Tuple2<>(1L, 1L));
    existingRatings.add(new Tuple2<>(1L, 1L));

    // Act
    AssessmentCell actualApplyResult = specificRatingColumnParser.apply("42", existingRatings);

    // Assert
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("42", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.ratings().size());
    Set<ResolutionStatus> statusesResult = actualApplyResult.statuses();
    assertEquals(1, statusesResult.size());
    assertEquals(1, actualApplyResult.columnId());
    assertTrue(statusesResult.contains(ResolutionStatus.EXISTING));
  }

  /**
   * Test {@link SpecificRatingColumnParser#apply(String, Collection)} with {@code String}, {@code
   * Collection}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return inputString is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificRatingColumnParser#apply(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test apply(String, Collection) with 'String', 'Collection'; when '42'; then return inputString is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentCell SpecificRatingColumnParser.apply(String, Collection)"})
  void testApplyWithStringCollection_when42_thenReturnInputStringIs42() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
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

    Builder resolvedAssessmentDefinitionResult =
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
    SpecificRatingColumnParser specificRatingColumnParser =
        new SpecificRatingColumnParser(headerCell);

    // Act
    AssessmentCell actualApplyResult = specificRatingColumnParser.apply("42", new ArrayList<>());

    // Assert
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("42", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.ratings().size());
    Set<ResolutionStatus> statusesResult = actualApplyResult.statuses();
    assertEquals(1, statusesResult.size());
    assertEquals(1, actualApplyResult.columnId());
    assertTrue(statusesResult.contains(ResolutionStatus.NEW));
  }

  /**
   * Test {@link SpecificRatingColumnParser#apply(String, Collection)} with {@code String}, {@code
   * Collection}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return inputString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link SpecificRatingColumnParser#apply(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test apply(String, Collection) with 'String', 'Collection'; when empty string; then return inputString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentCell SpecificRatingColumnParser.apply(String, Collection)"})
  void testApplyWithStringCollection_whenEmptyString_thenReturnInputStringIsEmptyString() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
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

    Builder resolvedAssessmentDefinitionResult =
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
    SpecificRatingColumnParser specificRatingColumnParser =
        new SpecificRatingColumnParser(headerCell);

    // Act
    AssessmentCell actualApplyResult = specificRatingColumnParser.apply("", new ArrayList<>());

    // Assert
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.ratings().size());
    Set<ResolutionStatus> statusesResult = actualApplyResult.statuses();
    assertEquals(1, statusesResult.size());
    assertEquals(1, actualApplyResult.columnId());
    assertTrue(statusesResult.contains(ResolutionStatus.NEW));
  }

  /**
   * Test {@link SpecificRatingColumnParser#apply(String, Collection)} with {@code String}, {@code
   * Collection}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then return inputString is {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificRatingColumnParser#apply(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test apply(String, Collection) with 'String', 'Collection'; when 'X'; then return inputString is 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentCell SpecificRatingColumnParser.apply(String, Collection)"})
  void testApplyWithStringCollection_whenX_thenReturnInputStringIsX() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
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

    Builder resolvedAssessmentDefinitionResult =
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
    SpecificRatingColumnParser specificRatingColumnParser =
        new SpecificRatingColumnParser(headerCell);

    // Act
    AssessmentCell actualApplyResult = specificRatingColumnParser.apply("X", new ArrayList<>());

    // Assert
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("X", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.ratings().size());
    Set<ResolutionStatus> statusesResult = actualApplyResult.statuses();
    assertEquals(1, statusesResult.size());
    assertEquals(1, actualApplyResult.columnId());
    assertTrue(statusesResult.contains(ResolutionStatus.NEW));
  }

  /**
   * Test {@link SpecificRatingColumnParser#apply(String, Collection)} with {@code String}, {@code
   * Collection}.
   *
   * <ul>
   *   <li>When {@code Y}.
   *   <li>Then return inputString is {@code Y}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificRatingColumnParser#apply(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test apply(String, Collection) with 'String', 'Collection'; when 'Y'; then return inputString is 'Y'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentCell SpecificRatingColumnParser.apply(String, Collection)"})
  void testApplyWithStringCollection_whenY_thenReturnInputStringIsY() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
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

    Builder resolvedAssessmentDefinitionResult =
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
    SpecificRatingColumnParser specificRatingColumnParser =
        new SpecificRatingColumnParser(headerCell);

    // Act
    AssessmentCell actualApplyResult = specificRatingColumnParser.apply("Y", new ArrayList<>());

    // Assert
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("Y", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.ratings().size());
    Set<ResolutionStatus> statusesResult = actualApplyResult.statuses();
    assertEquals(1, statusesResult.size());
    assertEquals(1, actualApplyResult.columnId());
    assertTrue(statusesResult.contains(ResolutionStatus.NEW));
  }
}
