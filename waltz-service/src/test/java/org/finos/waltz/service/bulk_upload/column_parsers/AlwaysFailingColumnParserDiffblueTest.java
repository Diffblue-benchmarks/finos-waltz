package org.finos.waltz.service.bulk_upload.column_parsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.finos.waltz.model.EntityReference;
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
class AlwaysFailingColumnParserDiffblueTest {
  @InjectMocks private AlwaysFailingColumnParser alwaysFailingColumnParser;

  @Mock private AssessmentHeaderCell assessmentHeaderCell;

  /**
   * Test {@link AlwaysFailingColumnParser#apply(String, Collection)} with {@code String}, {@code
   * Collection}.
   *
   * <p>Method under test: {@link AlwaysFailingColumnParser#apply(String, Collection)}
   */
  @Test
  @DisplayName("Test apply(String, Collection) with 'String', 'Collection'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentCell AlwaysFailingColumnParser.apply(String, Collection)"})
  void testApplyWithStringCollection() {
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
    AlwaysFailingColumnParser alwaysFailingColumnParser = new AlwaysFailingColumnParser(headerCell);

    // Act
    AssessmentCell actualApplyResult = alwaysFailingColumnParser.apply("42", new ArrayList<>());

    // Assert
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("42", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.ratings().size());
    Set<ResolutionStatus> statusesResult = actualApplyResult.statuses();
    assertEquals(1, statusesResult.size());
    assertTrue(statusesResult.contains(ResolutionStatus.ERROR));
  }

  /**
   * Test {@link AlwaysFailingColumnParser#apply(String, Collection)} with {@code String}, {@code
   * Collection}.
   *
   * <ul>
   *   <li>Given {@link Tuple2#Tuple2(Object, Object)} with v1 is three and v2 is three.
   * </ul>
   *
   * <p>Method under test: {@link AlwaysFailingColumnParser#apply(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test apply(String, Collection) with 'String', 'Collection'; given Tuple2(Object, Object) with v1 is three and v2 is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentCell AlwaysFailingColumnParser.apply(String, Collection)"})
  void testApplyWithStringCollection_givenTuple2WithV1IsThreeAndV2IsThree() {
    // Arrange
    when(assessmentHeaderCell.columnId()).thenReturn(1);

    ArrayList<Tuple2<Long, Long>> existingRatings = new ArrayList<>();
    existingRatings.add(new Tuple2<>(3L, 3L));

    // Act
    AssessmentCell actualApplyResult = alwaysFailingColumnParser.apply("42", existingRatings);

    // Assert
    verify(assessmentHeaderCell).columnId();
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("42", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.ratings().size());
    Set<ResolutionStatus> statusesResult = actualApplyResult.statuses();
    assertEquals(1, statusesResult.size());
    assertTrue(statusesResult.contains(ResolutionStatus.ERROR));
  }

  /**
   * Test {@link AlwaysFailingColumnParser#apply(String, Collection)} with {@code String}, {@code
   * Collection}.
   *
   * <ul>
   *   <li>Given {@link Tuple2#Tuple2(Object, Object)} with v1 is three and v2 is three.
   * </ul>
   *
   * <p>Method under test: {@link AlwaysFailingColumnParser#apply(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test apply(String, Collection) with 'String', 'Collection'; given Tuple2(Object, Object) with v1 is three and v2 is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentCell AlwaysFailingColumnParser.apply(String, Collection)"})
  void testApplyWithStringCollection_givenTuple2WithV1IsThreeAndV2IsThree2() {
    // Arrange
    when(assessmentHeaderCell.columnId()).thenReturn(1);

    ArrayList<Tuple2<Long, Long>> existingRatings = new ArrayList<>();
    existingRatings.add(new Tuple2<>(3L, 3L));
    existingRatings.add(new Tuple2<>(3L, 3L));

    // Act
    AssessmentCell actualApplyResult = alwaysFailingColumnParser.apply("42", existingRatings);

    // Assert
    verify(assessmentHeaderCell).columnId();
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("42", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.ratings().size());
    Set<ResolutionStatus> statusesResult = actualApplyResult.statuses();
    assertEquals(1, statusesResult.size());
    assertTrue(statusesResult.contains(ResolutionStatus.ERROR));
  }

  /**
   * Test {@link AlwaysFailingColumnParser#apply(String, Collection)} with {@code String}, {@code
   * Collection}.
   *
   * <ul>
   *   <li>Then return inputString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AlwaysFailingColumnParser#apply(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test apply(String, Collection) with 'String', 'Collection'; then return inputString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentCell AlwaysFailingColumnParser.apply(String, Collection)"})
  void testApplyWithStringCollection_thenReturnInputStringIsEmptyString() {
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
    AlwaysFailingColumnParser alwaysFailingColumnParser = new AlwaysFailingColumnParser(headerCell);

    // Act
    AssessmentCell actualApplyResult = alwaysFailingColumnParser.apply("", new ArrayList<>());

    // Assert
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.columnId());
    assertTrue(actualApplyResult.ratings().isEmpty());
    assertTrue(actualApplyResult.statuses().isEmpty());
  }

  /**
   * Test {@link AlwaysFailingColumnParser#apply(String, Collection)} with {@code String}, {@code
   * Collection}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return inputString is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AlwaysFailingColumnParser#apply(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test apply(String, Collection) with 'String', 'Collection'; when '42'; then return inputString is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentCell AlwaysFailingColumnParser.apply(String, Collection)"})
  void testApplyWithStringCollection_when42_thenReturnInputStringIs42() {
    // Arrange
    when(assessmentHeaderCell.columnId()).thenReturn(1);

    // Act
    AssessmentCell actualApplyResult = alwaysFailingColumnParser.apply("42", new ArrayList<>());

    // Assert
    verify(assessmentHeaderCell).columnId();
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("42", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.ratings().size());
    Set<ResolutionStatus> statusesResult = actualApplyResult.statuses();
    assertEquals(1, statusesResult.size());
    assertTrue(statusesResult.contains(ResolutionStatus.ERROR));
  }

  /**
   * Test {@link AlwaysFailingColumnParser#apply(String, Collection)} with {@code String}, {@code
   * Collection}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return inputString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AlwaysFailingColumnParser#apply(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test apply(String, Collection) with 'String', 'Collection'; when empty string; then return inputString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentCell AlwaysFailingColumnParser.apply(String, Collection)"})
  void testApplyWithStringCollection_whenEmptyString_thenReturnInputStringIsEmptyString() {
    // Arrange
    when(assessmentHeaderCell.columnId()).thenReturn(1);

    // Act
    AssessmentCell actualApplyResult = alwaysFailingColumnParser.apply("", new ArrayList<>());

    // Assert
    verify(assessmentHeaderCell).columnId();
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.columnId());
    assertTrue(actualApplyResult.ratings().isEmpty());
    assertTrue(actualApplyResult.statuses().isEmpty());
  }
}
