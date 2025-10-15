package org.finos.waltz.model.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.Optional;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRatingDetail.Builder;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRatingDetail.Json;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingDetailDiffblueTest {
  /**
   * Test {@link ImmutableAssessmentRatingDetail#assessmentDefinition()}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingDetail#assessmentDefinition()}
   */
  @Test
  @DisplayName("Test assessmentDefinition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAssessmentRatingDetail.assessmentDefinition()"})
  void testAssessmentDefinition() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();

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
    Optional<? extends AssessmentDefinition> assessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder assessmentDefinitionResult = builderResult.assessmentDefinition(assessmentDefinition);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    Builder assessmentRatingResult =
        assessmentDefinitionResult.assessmentRating(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    // Act and Assert
    assertEquals(
        assessmentDefinition,
        assessmentRatingResult
            .ratingDefinition(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build()
            .assessmentDefinition());
  }

  /**
   * Test Builder {@link Builder#assessmentDefinition(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#assessmentDefinition(Optional)}
   */
  @Test
  @DisplayName("Test Builder assessmentDefinition(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.assessmentDefinition(Optional)"})
  void testBuilderAssessmentDefinitionWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();

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
    Optional<? extends AssessmentDefinition> assessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    // Act
    Builder actualAssessmentDefinitionResult =
        builderResult.assessmentDefinition(assessmentDefinition);

    // Assert
    assertSame(builderResult, actualAssessmentDefinitionResult);
  }

  /**
   * Test Builder {@link Builder#assessmentRating(AssessmentRating)}.
   *
   * <ul>
   *   <li>When {@link ImmutableAssessmentRating.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#assessmentRating(AssessmentRating)}
   */
  @Test
  @DisplayName(
      "Test Builder assessmentRating(AssessmentRating); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.assessmentRating(AssessmentRating)"})
  void testBuilderAssessmentRating_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();

    // Act
    Builder actualAssessmentRatingResult =
        builderResult.assessmentRating(new ImmutableAssessmentRating.Json());

    // Assert
    assertSame(builderResult, actualAssessmentRatingResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#assessmentDefinition(AssessmentDefinition)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.assessmentDefinition(AssessmentDefinition)",
    "ImmutableAssessmentRatingDetail Builder.build()"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableAssessmentRatingDetail.builder();
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
    Optional<? extends AssessmentDefinition> assessmentDefinition =
        Optional.of(immutableAssessmentDefinition);
    Builder actualAssessmentDefinitionResult =
        actualBuilderResult.assessmentDefinition(assessmentDefinition);
    ImmutableAssessmentDefinition.Builder provenanceResult2 =
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
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference2 =
        Optional.of(immutableEntityReference2);
    Builder actualAssessmentDefinitionResult2 =
        actualAssessmentDefinitionResult.assessmentDefinition(
            provenanceResult2
                .qualifierReference(qualifierReference2)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());
    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating assessmentRating =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();
    Builder actualAssessmentRatingResult =
        actualAssessmentDefinitionResult2.assessmentRating(assessmentRating);
    ImmutableRatingSchemeItem ratingDefinition =
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
    ImmutableAssessmentRatingDetail actualImmutableAssessmentRatingDetail =
        actualAssessmentRatingResult.ratingDefinition(ratingDefinition).build();

    // Assert
    assertSame(assessmentRating, actualImmutableAssessmentRatingDetail.assessmentRating());
    assertSame(ratingDefinition, actualImmutableAssessmentRatingDetail.ratingDefinition());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingDetail)}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingDetail)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingDetail)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingDetail)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();

    Builder builderResult2 = ImmutableAssessmentRatingDetail.builder();

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
    Optional<? extends AssessmentDefinition> assessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder assessmentDefinitionResult = builderResult2.assessmentDefinition(assessmentDefinition);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    Builder assessmentRatingResult =
        assessmentDefinitionResult.assessmentRating(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());
    ImmutableAssessmentRatingDetail instance =
        assessmentRatingResult
            .ratingDefinition(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentRatingDetail actualImmutableAssessmentRatingDetail = builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRatingDetail);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingDetail)}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingDetail)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingDetail)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingDetail)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();

    Builder builderResult2 = ImmutableAssessmentRatingDetail.builder();
    Optional<? extends AssessmentDefinition> assessmentDefinition = Optional.empty();

    Builder assessmentDefinitionResult = builderResult2.assessmentDefinition(assessmentDefinition);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    Builder assessmentRatingResult =
        assessmentDefinitionResult.assessmentRating(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());
    ImmutableAssessmentRatingDetail instance =
        assessmentRatingResult
            .ratingDefinition(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentRatingDetail actualImmutableAssessmentRatingDetail = builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRatingDetail);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#ratingDefinition(RatingSchemeItem)}.
   *
   * <ul>
   *   <li>When {@link RatingSchemeItem}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ratingDefinition(RatingSchemeItem)}
   */
  @Test
  @DisplayName(
      "Test Builder ratingDefinition(RatingSchemeItem); when RatingSchemeItem; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingDefinition(RatingSchemeItem)"})
  void testBuilderRatingDefinition_whenRatingSchemeItem_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();

    // Act
    Builder actualRatingDefinitionResult =
        builderResult.ratingDefinition(mock(RatingSchemeItem.class));

    // Assert
    assertSame(builderResult, actualRatingDefinitionResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingDetail#copyOf(AssessmentRatingDetail)}.
   *
   * <ul>
   *   <li>Then assessmentRating entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingDetail#copyOf(AssessmentRatingDetail)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AssessmentRatingDetail); then assessmentRating entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingDetail ImmutableAssessmentRatingDetail.copyOf(AssessmentRatingDetail)"
  })
  void testCopyOf_thenAssessmentRatingEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();

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
    Optional<? extends AssessmentDefinition> assessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder assessmentDefinitionResult = builderResult.assessmentDefinition(assessmentDefinition);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    Builder assessmentRatingResult =
        assessmentDefinitionResult.assessmentRating(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());
    ImmutableAssessmentRatingDetail instance =
        assessmentRatingResult
            .ratingDefinition(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    // Act
    ImmutableAssessmentRatingDetail actualCopyOfResult =
        ImmutableAssessmentRatingDetail.copyOf(instance);

    // Assert
    AssessmentRating assessmentRatingResult2 = actualCopyOfResult.assessmentRating();
    assertTrue(assessmentRatingResult2.entityReference() instanceof ImmutableEntityReference);
    assertTrue(assessmentRatingResult2 instanceof ImmutableAssessmentRating);
    RatingSchemeItem ratingDefinitionResult = actualCopyOfResult.ratingDefinition();
    assertTrue(ratingDefinitionResult instanceof ImmutableRatingSchemeItem);
    assertEquals("2020-03-01", assessmentRatingResult2.lastUpdatedBy());
    assertEquals("Color", ratingDefinitionResult.color());
    assertEquals("Comment", assessmentRatingResult2.comment());
    assertEquals("Name", ratingDefinitionResult.name());
    assertEquals("Provenance", assessmentRatingResult2.provenance());
    assertEquals("Rating Group", ratingDefinitionResult.ratingGroup());
    assertEquals("Rating", ratingDefinitionResult.rating());
    assertEquals(
        "The characteristics of someone or something", ratingDefinitionResult.description());
    assertEquals(0, ratingDefinitionResult.position());
    assertEquals(1L, assessmentRatingResult2.assessmentDefinitionId());
    assertEquals(1L, assessmentRatingResult2.ratingId());
    assertEquals(1L, ratingDefinitionResult.ratingSchemeId());
    assertFalse(assessmentRatingResult2.isReadOnly());
    assertFalse(ratingDefinitionResult.isRestricted());
    assertFalse(ratingDefinitionResult.requiresComment());
    assertTrue(ratingDefinitionResult.userSelectable());
  }

  /**
   * Test {@link ImmutableAssessmentRatingDetail#equals(Object)}, and {@link
   * ImmutableAssessmentRatingDetail#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingDetail#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingDetail#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingDetail.equals(Object)",
    "int ImmutableAssessmentRatingDetail.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();

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
    Optional<? extends AssessmentDefinition> assessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder assessmentDefinitionResult = builderResult.assessmentDefinition(assessmentDefinition);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    Builder assessmentRatingResult =
        assessmentDefinitionResult.assessmentRating(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());
    ImmutableAssessmentRatingDetail immutableAssessmentRatingDetail =
        assessmentRatingResult
            .ratingDefinition(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    Builder builderResult2 = ImmutableAssessmentRatingDetail.builder();

    ImmutableAssessmentDefinition.Builder provenanceResult2 =
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
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference2 =
        Optional.of(immutableEntityReference2);
    ImmutableAssessmentDefinition immutableAssessmentDefinition2 =
        provenanceResult2
            .qualifierReference(qualifierReference2)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> assessmentDefinition2 =
        Optional.of(immutableAssessmentDefinition2);

    Builder assessmentDefinitionResult2 =
        builderResult2.assessmentDefinition(assessmentDefinition2);

    ImmutableAssessmentRating.Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    Builder assessmentRatingResult2 =
        assessmentDefinitionResult2.assessmentRating(
            commentResult2
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());
    ImmutableAssessmentRatingDetail immutableAssessmentRatingDetail2 =
        assessmentRatingResult2
            .ratingDefinition(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableAssessmentRatingDetail, immutableAssessmentRatingDetail2);
    assertEquals(
        immutableAssessmentRatingDetail.hashCode(), immutableAssessmentRatingDetail2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingDetail#equals(Object)}, and {@link
   * ImmutableAssessmentRatingDetail#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingDetail#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingDetail#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingDetail.equals(Object)",
    "int ImmutableAssessmentRatingDetail.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();

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
    Optional<? extends AssessmentDefinition> assessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder assessmentDefinitionResult = builderResult.assessmentDefinition(assessmentDefinition);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    Builder assessmentRatingResult =
        assessmentDefinitionResult.assessmentRating(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());
    ImmutableAssessmentRatingDetail immutableAssessmentRatingDetail =
        assessmentRatingResult
            .ratingDefinition(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableAssessmentRatingDetail, immutableAssessmentRatingDetail);
    int expectedHashCodeResult = immutableAssessmentRatingDetail.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssessmentRatingDetail.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingDetail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingDetail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingDetail.equals(Object)",
    "int ImmutableAssessmentRatingDetail.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_MANY)
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
    Optional<? extends AssessmentDefinition> assessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder assessmentDefinitionResult = builderResult.assessmentDefinition(assessmentDefinition);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    Builder assessmentRatingResult =
        assessmentDefinitionResult.assessmentRating(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());
    ImmutableAssessmentRatingDetail immutableAssessmentRatingDetail =
        assessmentRatingResult
            .ratingDefinition(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    Builder builderResult2 = ImmutableAssessmentRatingDetail.builder();

    ImmutableAssessmentDefinition.Builder provenanceResult2 =
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
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference2 =
        Optional.of(immutableEntityReference2);
    ImmutableAssessmentDefinition immutableAssessmentDefinition2 =
        provenanceResult2
            .qualifierReference(qualifierReference2)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> assessmentDefinition2 =
        Optional.of(immutableAssessmentDefinition2);

    Builder assessmentDefinitionResult2 =
        builderResult2.assessmentDefinition(assessmentDefinition2);

    ImmutableAssessmentRating.Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    Builder assessmentRatingResult2 =
        assessmentDefinitionResult2.assessmentRating(
            commentResult2
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingDetail,
        assessmentRatingResult2
            .ratingDefinition(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingDetail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingDetail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingDetail.equals(Object)",
    "int ImmutableAssessmentRatingDetail.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();

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
    Optional<? extends AssessmentDefinition> assessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder assessmentDefinitionResult = builderResult.assessmentDefinition(assessmentDefinition);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(2L).comment("Comment");

    Builder assessmentRatingResult =
        assessmentDefinitionResult.assessmentRating(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());
    ImmutableAssessmentRatingDetail immutableAssessmentRatingDetail =
        assessmentRatingResult
            .ratingDefinition(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    Builder builderResult2 = ImmutableAssessmentRatingDetail.builder();

    ImmutableAssessmentDefinition.Builder provenanceResult2 =
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
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference2 =
        Optional.of(immutableEntityReference2);
    ImmutableAssessmentDefinition immutableAssessmentDefinition2 =
        provenanceResult2
            .qualifierReference(qualifierReference2)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> assessmentDefinition2 =
        Optional.of(immutableAssessmentDefinition2);

    Builder assessmentDefinitionResult2 =
        builderResult2.assessmentDefinition(assessmentDefinition2);

    ImmutableAssessmentRating.Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    Builder assessmentRatingResult2 =
        assessmentDefinitionResult2.assessmentRating(
            commentResult2
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingDetail,
        assessmentRatingResult2
            .ratingDefinition(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingDetail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingDetail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingDetail.equals(Object)",
    "int ImmutableAssessmentRatingDetail.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();

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
    Optional<? extends AssessmentDefinition> assessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder assessmentDefinitionResult = builderResult.assessmentDefinition(assessmentDefinition);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    Builder assessmentRatingResult =
        assessmentDefinitionResult.assessmentRating(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());
    ImmutableAssessmentRatingDetail immutableAssessmentRatingDetail =
        assessmentRatingResult
            .ratingDefinition(
                ImmutableRatingSchemeItem.builder()
                    .color("2020-03-01")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    Builder builderResult2 = ImmutableAssessmentRatingDetail.builder();

    ImmutableAssessmentDefinition.Builder provenanceResult2 =
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
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference2 =
        Optional.of(immutableEntityReference2);
    ImmutableAssessmentDefinition immutableAssessmentDefinition2 =
        provenanceResult2
            .qualifierReference(qualifierReference2)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> assessmentDefinition2 =
        Optional.of(immutableAssessmentDefinition2);

    Builder assessmentDefinitionResult2 =
        builderResult2.assessmentDefinition(assessmentDefinition2);

    ImmutableAssessmentRating.Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    Builder assessmentRatingResult2 =
        assessmentDefinitionResult2.assessmentRating(
            commentResult2
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingDetail,
        assessmentRatingResult2
            .ratingDefinition(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingDetail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingDetail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingDetail.equals(Object)",
    "int ImmutableAssessmentRatingDetail.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();

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
    Optional<? extends AssessmentDefinition> assessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder assessmentDefinitionResult = builderResult.assessmentDefinition(assessmentDefinition);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    Builder assessmentRatingResult =
        assessmentDefinitionResult.assessmentRating(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    // Act and Assert
    assertNotEquals(
        assessmentRatingResult
            .ratingDefinition(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAssessmentRatingDetail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingDetail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingDetail.equals(Object)",
    "int ImmutableAssessmentRatingDetail.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();

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
    Optional<? extends AssessmentDefinition> assessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder assessmentDefinitionResult = builderResult.assessmentDefinition(assessmentDefinition);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    Builder assessmentRatingResult =
        assessmentDefinitionResult.assessmentRating(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    // Act and Assert
    assertNotEquals(
        assessmentRatingResult
            .ratingDefinition(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build(),
        "Different type to ImmutableAssessmentRatingDetail");
  }

  /**
   * Test {@link ImmutableAssessmentRatingDetail#fromJson(Json)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingDetail#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingDetail ImmutableAssessmentRatingDetail.fromJson(Json)"
  })
  void testFromJson() {
    // Arrange
    Json json = new Json();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    json.setAssessmentRating(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());
    json.setRatingDefinition(
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
    Optional<AssessmentDefinition> assessmentDefinition =
        Optional.of(immutableAssessmentDefinition);
    json.setAssessmentDefinition(assessmentDefinition);

    // Act
    ImmutableAssessmentRatingDetail actualFromJsonResult =
        ImmutableAssessmentRatingDetail.fromJson(json);

    // Assert
    AssessmentRating expectedAssessmentRatingResult = json.assessmentRating;
    assertSame(expectedAssessmentRatingResult, actualFromJsonResult.assessmentRating());
    RatingSchemeItem expectedRatingDefinitionResult = json.ratingDefinition;
    assertSame(expectedRatingDefinitionResult, actualFromJsonResult.ratingDefinition());
  }

  /**
   * Test {@link ImmutableAssessmentRatingDetail#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentRating is {@link Json} (default constructor) {@link
   *       Json#assessmentRating}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingDetail#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return assessmentRating is Json (default constructor) assessmentRating")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingDetail ImmutableAssessmentRatingDetail.fromJson(Json)"
  })
  void testFromJson_thenReturnAssessmentRatingIsJsonAssessmentRating() {
    // Arrange
    Json json = new Json();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    json.setAssessmentRating(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());
    json.setRatingDefinition(
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
    json.setAssessmentDefinition(null);

    // Act
    ImmutableAssessmentRatingDetail actualFromJsonResult =
        ImmutableAssessmentRatingDetail.fromJson(json);

    // Assert
    AssessmentRating expectedAssessmentRatingResult = json.assessmentRating;
    assertSame(expectedAssessmentRatingResult, actualFromJsonResult.assessmentRating());
    RatingSchemeItem expectedRatingDefinitionResult = json.ratingDefinition;
    assertSame(expectedRatingDefinitionResult, actualFromJsonResult.ratingDefinition());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingDetail#assessmentRating()}
   *   <li>{@link ImmutableAssessmentRatingDetail#ratingDefinition()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRating ImmutableAssessmentRatingDetail.assessmentRating()",
    "RatingSchemeItem ImmutableAssessmentRatingDetail.ratingDefinition()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();

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
    Optional<? extends AssessmentDefinition> assessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder assessmentDefinitionResult = builderResult.assessmentDefinition(assessmentDefinition);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    Builder assessmentRatingResult =
        assessmentDefinitionResult.assessmentRating(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());
    ImmutableAssessmentRatingDetail immutableAssessmentRatingDetail =
        assessmentRatingResult
            .ratingDefinition(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    // Act
    AssessmentRating actualAssessmentRatingResult =
        immutableAssessmentRatingDetail.assessmentRating();

    // Assert
    assertTrue(actualAssessmentRatingResult instanceof ImmutableAssessmentRating);
    assertTrue(
        immutableAssessmentRatingDetail.ratingDefinition() instanceof ImmutableRatingSchemeItem);
  }

  /**
   * Test Json {@link Json#assessmentDefinition()}.
   *
   * <p>Method under test: {@link Json#assessmentDefinition()}
   */
  @Test
  @DisplayName("Test Json assessmentDefinition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.assessmentDefinition()"})
  void testJsonAssessmentDefinition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().assessmentDefinition());
  }

  /**
   * Test Json {@link Json#assessmentRating()}.
   *
   * <p>Method under test: {@link Json#assessmentRating()}
   */
  @Test
  @DisplayName("Test Json assessmentRating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentRating Json.assessmentRating()"})
  void testJsonAssessmentRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().assessmentRating());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.assessmentRating);
    assertNull(actualJson.ratingDefinition);
    assertFalse(actualJson.assessmentDefinition.isPresent());
  }

  /**
   * Test Json {@link Json#ratingDefinition()}.
   *
   * <p>Method under test: {@link Json#ratingDefinition()}
   */
  @Test
  @DisplayName("Test Json ratingDefinition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RatingSchemeItem Json.ratingDefinition()"})
  void testJsonRatingDefinition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingDefinition());
  }

  /**
   * Test {@link ImmutableAssessmentRatingDetail#toString()}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingDetail#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableAssessmentRatingDetail.toString()"})
  void testToString() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();

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
    Optional<? extends AssessmentDefinition> assessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder assessmentDefinitionResult = builderResult.assessmentDefinition(assessmentDefinition);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    Builder assessmentRatingResult =
        assessmentDefinitionResult.assessmentRating(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    // Act and Assert
    assertEquals(
        "AssessmentRatingDetail{assessmentRating=AssessmentRating{lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy"
            + "=2020-03-01, provenance=Provenance, isReadOnly=false, id=1, entityReference=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, assessmentDefinitionId=1, ratingId=1}, ratingDefinition"
            + "=RatingSchemeItem{id=1, name=Name, position=0, externalId=42, rating=Rating, color=Color, ratingSchemeId=1,"
            + " userSelectable=true, isRestricted=false, ratingGroup=Rating Group, requiresComment=false},"
            + " assessmentDefinition=AssessmentDefinition{id=1, externalId=42, name=Name, lastUpdatedAt=1970-01-01T00:00,"
            + " lastUpdatedBy=2020-03-01, provenance=Provenance, entityKind=ALL, ratingSchemeId=1, permittedRole=Permitted"
            + " Role, isReadOnly=true, visibility=PRIMARY, definitionGroup=Definition Group, kind=ALL, cardinality"
            + "=ZERO_ONE}}",
        assessmentRatingResult
            .ratingDefinition(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAssessmentRatingDetail#toString()}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingDetail#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableAssessmentRatingDetail.toString()"})
  void testToString2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();
    Optional<? extends AssessmentDefinition> assessmentDefinition = Optional.empty();

    Builder assessmentDefinitionResult = builderResult.assessmentDefinition(assessmentDefinition);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    Builder assessmentRatingResult =
        assessmentDefinitionResult.assessmentRating(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    // Act and Assert
    assertEquals(
        "AssessmentRatingDetail{assessmentRating=AssessmentRating{lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy"
            + "=2020-03-01, provenance=Provenance, isReadOnly=false, id=1, entityReference=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, assessmentDefinitionId=1, ratingId=1}, ratingDefinition"
            + "=RatingSchemeItem{id=1, name=Name, position=0, externalId=42, rating=Rating, color=Color, ratingSchemeId=1,"
            + " userSelectable=true, isRestricted=false, ratingGroup=Rating Group, requiresComment=false}}",
        assessmentRatingResult
            .ratingDefinition(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAssessmentRatingDetail#withAssessmentDefinition(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingDetail#withAssessmentDefinition(Optional)}
   */
  @Test
  @DisplayName("Test withAssessmentDefinition(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingDetail ImmutableAssessmentRatingDetail.withAssessmentDefinition(Optional)"
  })
  void testWithAssessmentDefinitionWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();

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
    Optional<? extends AssessmentDefinition> assessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder assessmentDefinitionResult = builderResult.assessmentDefinition(assessmentDefinition);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    Builder assessmentRatingResult =
        assessmentDefinitionResult.assessmentRating(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());
    ImmutableAssessmentRatingDetail immutableAssessmentRatingDetail =
        assessmentRatingResult
            .ratingDefinition(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    ImmutableAssessmentDefinition.Builder provenanceResult2 =
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
    Optional<? extends EntityReference> qualifierReference2 = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition2 =
        provenanceResult2
            .qualifierReference(qualifierReference2)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> optional = Optional.of(immutableAssessmentDefinition2);

    // Act
    ImmutableAssessmentRatingDetail actualWithAssessmentDefinitionResult =
        immutableAssessmentRatingDetail.withAssessmentDefinition(optional);

    // Assert
    AssessmentRating assessmentRatingResult2 =
        actualWithAssessmentDefinitionResult.assessmentRating();
    assertTrue(assessmentRatingResult2.entityReference() instanceof ImmutableEntityReference);
    assertTrue(assessmentRatingResult2 instanceof ImmutableAssessmentRating);
    RatingSchemeItem ratingDefinitionResult =
        actualWithAssessmentDefinitionResult.ratingDefinition();
    assertTrue(ratingDefinitionResult instanceof ImmutableRatingSchemeItem);
    assertEquals("2020-03-01", assessmentRatingResult2.lastUpdatedBy());
    assertEquals("Color", ratingDefinitionResult.color());
    assertEquals("Comment", assessmentRatingResult2.comment());
    assertEquals("Name", ratingDefinitionResult.name());
    assertEquals("Provenance", assessmentRatingResult2.provenance());
    assertEquals("Rating Group", ratingDefinitionResult.ratingGroup());
    assertEquals("Rating", ratingDefinitionResult.rating());
    assertEquals(
        "The characteristics of someone or something", ratingDefinitionResult.description());
    assertEquals(0, ratingDefinitionResult.position());
    assertEquals(1L, assessmentRatingResult2.assessmentDefinitionId());
    assertEquals(1L, assessmentRatingResult2.ratingId());
    assertEquals(1L, ratingDefinitionResult.ratingSchemeId());
    assertFalse(assessmentRatingResult2.isReadOnly());
    assertFalse(ratingDefinitionResult.isRestricted());
    assertFalse(ratingDefinitionResult.requiresComment());
    assertTrue(ratingDefinitionResult.userSelectable());
  }

  /**
   * Test {@link ImmutableAssessmentRatingDetail#withAssessmentDefinition(AssessmentDefinition)}
   * with {@code value}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingDetail#withAssessmentDefinition(AssessmentDefinition)}
   */
  @Test
  @DisplayName("Test withAssessmentDefinition(AssessmentDefinition) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingDetail ImmutableAssessmentRatingDetail.withAssessmentDefinition(AssessmentDefinition)"
  })
  void testWithAssessmentDefinitionWithValue() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();

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
    Optional<? extends AssessmentDefinition> assessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder assessmentDefinitionResult = builderResult.assessmentDefinition(assessmentDefinition);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    Builder assessmentRatingResult =
        assessmentDefinitionResult.assessmentRating(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());
    ImmutableAssessmentRatingDetail immutableAssessmentRatingDetail =
        assessmentRatingResult
            .ratingDefinition(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    ImmutableAssessmentDefinition.Builder provenanceResult2 =
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
    Optional<? extends EntityReference> qualifierReference2 = Optional.of(immutableEntityReference);

    // Act
    ImmutableAssessmentRatingDetail actualWithAssessmentDefinitionResult =
        immutableAssessmentRatingDetail.withAssessmentDefinition(
            provenanceResult2
                .qualifierReference(qualifierReference2)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    // Assert
    AssessmentRating assessmentRatingResult2 =
        actualWithAssessmentDefinitionResult.assessmentRating();
    assertTrue(assessmentRatingResult2.entityReference() instanceof ImmutableEntityReference);
    assertTrue(assessmentRatingResult2 instanceof ImmutableAssessmentRating);
    RatingSchemeItem ratingDefinitionResult =
        actualWithAssessmentDefinitionResult.ratingDefinition();
    assertTrue(ratingDefinitionResult instanceof ImmutableRatingSchemeItem);
    assertEquals("2020-03-01", assessmentRatingResult2.lastUpdatedBy());
    assertEquals("Color", ratingDefinitionResult.color());
    assertEquals("Comment", assessmentRatingResult2.comment());
    assertEquals("Name", ratingDefinitionResult.name());
    assertEquals("Provenance", assessmentRatingResult2.provenance());
    assertEquals("Rating Group", ratingDefinitionResult.ratingGroup());
    assertEquals("Rating", ratingDefinitionResult.rating());
    assertEquals(
        "The characteristics of someone or something", ratingDefinitionResult.description());
    assertEquals(0, ratingDefinitionResult.position());
    assertEquals(1L, assessmentRatingResult2.assessmentDefinitionId());
    assertEquals(1L, assessmentRatingResult2.ratingId());
    assertEquals(1L, ratingDefinitionResult.ratingSchemeId());
    assertFalse(assessmentRatingResult2.isReadOnly());
    assertFalse(ratingDefinitionResult.isRestricted());
    assertFalse(ratingDefinitionResult.requiresComment());
    assertTrue(ratingDefinitionResult.userSelectable());
  }

  /**
   * Test {@link ImmutableAssessmentRatingDetail#withAssessmentRating(AssessmentRating)}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingDetail#withAssessmentRating(AssessmentRating)}
   */
  @Test
  @DisplayName("Test withAssessmentRating(AssessmentRating)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingDetail ImmutableAssessmentRatingDetail.withAssessmentRating(AssessmentRating)"
  })
  void testWithAssessmentRating() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();

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
    Optional<? extends AssessmentDefinition> assessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder assessmentDefinitionResult = builderResult.assessmentDefinition(assessmentDefinition);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    Builder assessmentRatingResult =
        assessmentDefinitionResult.assessmentRating(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());
    ImmutableAssessmentRatingDetail immutableAssessmentRatingDetail =
        assessmentRatingResult
            .ratingDefinition(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    ImmutableAssessmentRating.Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act
    ImmutableAssessmentRatingDetail actualWithAssessmentRatingResult =
        immutableAssessmentRatingDetail.withAssessmentRating(
            commentResult2
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    // Assert
    assertEquals(immutableAssessmentRatingDetail, actualWithAssessmentRatingResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingDetail#withRatingDefinition(RatingSchemeItem)}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingDetail#withRatingDefinition(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test withRatingDefinition(RatingSchemeItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingDetail ImmutableAssessmentRatingDetail.withRatingDefinition(RatingSchemeItem)"
  })
  void testWithRatingDefinition() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();

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
    Optional<? extends AssessmentDefinition> assessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder assessmentDefinitionResult = builderResult.assessmentDefinition(assessmentDefinition);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    Builder assessmentRatingResult =
        assessmentDefinitionResult.assessmentRating(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());
    ImmutableAssessmentRatingDetail immutableAssessmentRatingDetail =
        assessmentRatingResult
            .ratingDefinition(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    // Act
    ImmutableAssessmentRatingDetail actualWithRatingDefinitionResult =
        immutableAssessmentRatingDetail.withRatingDefinition(
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

    // Assert
    assertEquals(immutableAssessmentRatingDetail, actualWithRatingDefinitionResult);
  }
}
