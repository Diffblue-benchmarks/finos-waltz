package org.finos.waltz.model.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentGroupedEntities.Builder;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentGroupedEntities.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentGroupedEntitiesDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllRatingEntityLists(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRatingEntityLists(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllRatingEntityLists(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRatingEntityLists(Iterable)"})
  void testBuilderAddAllRatingEntityLists_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

    // Act
    Builder actualAddAllRatingEntityListsResult =
        builderResult.addAllRatingEntityLists(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllRatingEntityListsResult);
  }

  /**
   * Test Builder {@link Builder#addRatingEntityLists(RatingEntityList)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableRatingEntityList.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addRatingEntityLists(RatingEntityList)}
   */
  @Test
  @DisplayName(
      "Test Builder addRatingEntityLists(RatingEntityList) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatingEntityLists(RatingEntityList)"})
  void testBuilderAddRatingEntityListsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

    // Act
    Builder actualAddRatingEntityListsResult =
        builderResult.addRatingEntityLists(new ImmutableRatingEntityList.Json());

    // Assert
    assertSame(builderResult, actualAddRatingEntityListsResult);
  }

  /**
   * Test Builder {@link Builder#addRatingEntityLists(RatingEntityList[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableRatingEntityList.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addRatingEntityLists(RatingEntityList[])}
   */
  @Test
  @DisplayName(
      "Test Builder addRatingEntityLists(RatingEntityList[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatingEntityLists(RatingEntityList[])"})
  void testBuilderAddRatingEntityListsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

    // Act
    Builder actualAddRatingEntityListsResult =
        builderResult.addRatingEntityLists(new ImmutableRatingEntityList.Json());

    // Assert
    assertSame(builderResult, actualAddRatingEntityListsResult);
  }

  /**
   * Test Builder {@link Builder#assessmentDefinition(AssessmentDefinition)}.
   *
   * <p>Method under test: {@link Builder#assessmentDefinition(AssessmentDefinition)}
   */
  @Test
  @DisplayName("Test Builder assessmentDefinition(AssessmentDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.assessmentDefinition(AssessmentDefinition)"})
  void testBuilderAssessmentDefinition() {
    // Arrange
    Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

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
    ImmutableAssessmentDefinition assessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();

    // Act
    Builder actualAssessmentDefinitionResult =
        builderResult.assessmentDefinition(assessmentDefinition);

    // Assert
    assertSame(assessmentDefinition, builderResult.build().assessmentDefinition());
    assertSame(builderResult, actualAssessmentDefinitionResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentGroupedEntities Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableAssessmentGroupedEntities.builder();
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
    ImmutableAssessmentDefinition assessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    ImmutableAssessmentGroupedEntities actualImmutableAssessmentGroupedEntities =
        actualBuilderResult.assessmentDefinition(assessmentDefinition).build();

    // Assert
    assertTrue(actualImmutableAssessmentGroupedEntities.ratingEntityLists().isEmpty());
    assertSame(
        assessmentDefinition, actualImmutableAssessmentGroupedEntities.assessmentDefinition());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentGroupedEntities)}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentGroupedEntities)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentGroupedEntities)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentGroupedEntities)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

    Builder builderResult2 = ImmutableAssessmentGroupedEntities.builder();

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
    ImmutableAssessmentGroupedEntities instance =
        builderResult2
            .assessmentDefinition(
                provenanceResult
                    .qualifierReference(qualifierReference)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentGroupedEntities actualImmutableAssessmentGroupedEntities =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentGroupedEntities);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentGroupedEntities)}.
   *
   * <ul>
   *   <li>Given builder rating {@code Rating} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AssessmentGroupedEntities)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentGroupedEntities); given builder rating 'Rating' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentGroupedEntities)"})
  void testBuilderFrom_givenBuilderRatingRatingBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

    Builder builderResult2 = ImmutableAssessmentGroupedEntities.builder();
    builderResult2.addRatingEntityLists(
        ImmutableRatingEntityList.builder().rating("Rating").build());

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
    ImmutableAssessmentGroupedEntities instance =
        builderResult2
            .assessmentDefinition(
                provenanceResult
                    .qualifierReference(qualifierReference)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentGroupedEntities actualImmutableAssessmentGroupedEntities =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentGroupedEntities);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#ratingEntityLists(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ratingEntityLists(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratingEntityLists(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingEntityLists(Iterable)"})
  void testBuilderRatingEntityLists_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

    // Act
    Builder actualRatingEntityListsResult = builderResult.ratingEntityLists(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualRatingEntityListsResult);
  }

  /**
   * Test {@link ImmutableAssessmentGroupedEntities#copyOf(AssessmentGroupedEntities)}.
   *
   * <ul>
   *   <li>Then assessmentDefinition return {@link ImmutableAssessmentDefinition}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentGroupedEntities#copyOf(AssessmentGroupedEntities)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AssessmentGroupedEntities); then assessmentDefinition return ImmutableAssessmentDefinition")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentGroupedEntities ImmutableAssessmentGroupedEntities.copyOf(AssessmentGroupedEntities)"
  })
  void testCopyOf_thenAssessmentDefinitionReturnImmutableAssessmentDefinition() {
    // Arrange
    Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

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
    ImmutableAssessmentGroupedEntities instance =
        builderResult
            .assessmentDefinition(
                provenanceResult
                    .qualifierReference(qualifierReference)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build();

    // Act
    ImmutableAssessmentGroupedEntities actualCopyOfResult =
        ImmutableAssessmentGroupedEntities.copyOf(instance);

    // Assert
    AssessmentDefinition assessmentDefinitionResult = actualCopyOfResult.assessmentDefinition();
    assertTrue(assessmentDefinitionResult instanceof ImmutableAssessmentDefinition);
    assertEquals("2020-03-01", assessmentDefinitionResult.lastUpdatedBy());
    assertEquals("Definition Group", assessmentDefinitionResult.definitionGroup());
    assertEquals("Name", assessmentDefinitionResult.name());
    assertEquals("Provenance", assessmentDefinitionResult.provenance());
    assertEquals(
        "The characteristics of someone or something", assessmentDefinitionResult.description());
    assertEquals(1L, assessmentDefinitionResult.ratingSchemeId());
    assertEquals(Cardinality.ZERO_ONE, assessmentDefinitionResult.cardinality());
    assertEquals(EntityKind.ALL, assessmentDefinitionResult.entityKind());
    assertEquals(EntityKind.ALL, assessmentDefinitionResult.kind());
    assertEquals(AssessmentVisibility.PRIMARY, assessmentDefinitionResult.visibility());
    assertTrue(actualCopyOfResult.ratingEntityLists().isEmpty());
    assertTrue(assessmentDefinitionResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableAssessmentGroupedEntities#equals(Object)}, and {@link
   * ImmutableAssessmentGroupedEntities#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentGroupedEntities#equals(Object)}
   *   <li>{@link ImmutableAssessmentGroupedEntities#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentGroupedEntities.equals(Object)",
    "int ImmutableAssessmentGroupedEntities.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

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
    ImmutableAssessmentGroupedEntities immutableAssessmentGroupedEntities =
        builderResult
            .assessmentDefinition(
                provenanceResult
                    .qualifierReference(qualifierReference)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build();

    Builder builderResult2 = ImmutableAssessmentGroupedEntities.builder();

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
    ImmutableAssessmentGroupedEntities immutableAssessmentGroupedEntities2 =
        builderResult2
            .assessmentDefinition(
                provenanceResult2
                    .qualifierReference(qualifierReference2)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableAssessmentGroupedEntities, immutableAssessmentGroupedEntities2);
    assertEquals(
        immutableAssessmentGroupedEntities.hashCode(),
        immutableAssessmentGroupedEntities2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentGroupedEntities#equals(Object)}, and {@link
   * ImmutableAssessmentGroupedEntities#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentGroupedEntities#equals(Object)}
   *   <li>{@link ImmutableAssessmentGroupedEntities#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentGroupedEntities.equals(Object)",
    "int ImmutableAssessmentGroupedEntities.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

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
    ImmutableAssessmentGroupedEntities immutableAssessmentGroupedEntities =
        builderResult
            .assessmentDefinition(
                provenanceResult
                    .qualifierReference(qualifierReference)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableAssessmentGroupedEntities, immutableAssessmentGroupedEntities);
    int expectedHashCodeResult = immutableAssessmentGroupedEntities.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssessmentGroupedEntities.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentGroupedEntities#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentGroupedEntities#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentGroupedEntities.equals(Object)",
    "int ImmutableAssessmentGroupedEntities.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentGroupedEntities.builder();
    builderResult.addRatingEntityLists(
        ImmutableRatingEntityList.builder().rating("Rating").build());

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
    ImmutableAssessmentGroupedEntities immutableAssessmentGroupedEntities =
        builderResult
            .assessmentDefinition(
                provenanceResult
                    .qualifierReference(qualifierReference)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build();

    Builder builderResult2 = ImmutableAssessmentGroupedEntities.builder();

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

    // Act and Assert
    assertNotEquals(
        immutableAssessmentGroupedEntities,
        builderResult2
            .assessmentDefinition(
                provenanceResult2
                    .qualifierReference(qualifierReference2)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentGroupedEntities#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentGroupedEntities#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentGroupedEntities.equals(Object)",
    "int ImmutableAssessmentGroupedEntities.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

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
    ImmutableAssessmentGroupedEntities immutableAssessmentGroupedEntities =
        builderResult
            .assessmentDefinition(
                provenanceResult
                    .qualifierReference(qualifierReference)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build();

    Builder builderResult2 = ImmutableAssessmentGroupedEntities.builder();

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

    // Act and Assert
    assertNotEquals(
        immutableAssessmentGroupedEntities,
        builderResult2
            .assessmentDefinition(
                provenanceResult2
                    .qualifierReference(qualifierReference2)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentGroupedEntities#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentGroupedEntities#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentGroupedEntities.equals(Object)",
    "int ImmutableAssessmentGroupedEntities.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

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

    // Act and Assert
    assertNotEquals(
        builderResult
            .assessmentDefinition(
                provenanceResult
                    .qualifierReference(qualifierReference)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAssessmentGroupedEntities#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentGroupedEntities#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentGroupedEntities.equals(Object)",
    "int ImmutableAssessmentGroupedEntities.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

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

    // Act and Assert
    assertNotEquals(
        builderResult
            .assessmentDefinition(
                provenanceResult
                    .qualifierReference(qualifierReference)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build(),
        "Different type to ImmutableAssessmentGroupedEntities");
  }

  /**
   * Test {@link ImmutableAssessmentGroupedEntities#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) RatingEntityLists is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentGroupedEntities#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) RatingEntityLists is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentGroupedEntities ImmutableAssessmentGroupedEntities.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonRatingEntityListsIsHashSet() {
    // Arrange
    Json json = new Json();

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
    json.setAssessmentDefinition(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());
    json.setRatingEntityLists(new HashSet<>());

    // Act
    ImmutableAssessmentGroupedEntities actualFromJsonResult =
        ImmutableAssessmentGroupedEntities.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.ratingEntityLists().isEmpty());
    AssessmentDefinition expectedAssessmentDefinitionResult = json.assessmentDefinition;
    assertSame(expectedAssessmentDefinitionResult, actualFromJsonResult.assessmentDefinition());
  }

  /**
   * Test {@link ImmutableAssessmentGroupedEntities#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return ratingEntityLists is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentGroupedEntities#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return ratingEntityLists is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentGroupedEntities ImmutableAssessmentGroupedEntities.fromJson(Json)"
  })
  void testFromJson_thenReturnRatingEntityListsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<RatingEntityList> ratingEntityLists = new LinkedHashSet<>();
    ratingEntityLists.add(ImmutableRatingEntityList.builder().rating("java.lang.String").build());
    ratingEntityLists.add(ImmutableRatingEntityList.builder().rating("Rating").build());

    Json json = new Json();

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
    json.setAssessmentDefinition(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());
    json.setRatingEntityLists(ratingEntityLists);

    // Act
    ImmutableAssessmentGroupedEntities actualFromJsonResult =
        ImmutableAssessmentGroupedEntities.fromJson(json);

    // Assert
    assertEquals(ratingEntityLists, actualFromJsonResult.ratingEntityLists());
    AssessmentDefinition expectedAssessmentDefinitionResult = json.assessmentDefinition;
    assertSame(expectedAssessmentDefinitionResult, actualFromJsonResult.assessmentDefinition());
  }

  /**
   * Test {@link ImmutableAssessmentGroupedEntities#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return ratingEntityLists size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentGroupedEntities#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return ratingEntityLists size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentGroupedEntities ImmutableAssessmentGroupedEntities.fromJson(Json)"
  })
  void testFromJson_thenReturnRatingEntityListsSizeIsOne() {
    // Arrange
    LinkedHashSet<RatingEntityList> ratingEntityLists = new LinkedHashSet<>();
    ratingEntityLists.add(ImmutableRatingEntityList.builder().rating("Rating").build());

    Json json = new Json();

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
    json.setAssessmentDefinition(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());
    json.setRatingEntityLists(ratingEntityLists);

    // Act
    ImmutableAssessmentGroupedEntities actualFromJsonResult =
        ImmutableAssessmentGroupedEntities.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.ratingEntityLists().size());
    AssessmentDefinition expectedAssessmentDefinitionResult = json.assessmentDefinition;
    assertSame(expectedAssessmentDefinitionResult, actualFromJsonResult.assessmentDefinition());
  }

  /**
   * Test {@link ImmutableAssessmentGroupedEntities#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) RatingEntityLists is {@code null}.
   *   <li>Then return ratingEntityLists Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentGroupedEntities#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) RatingEntityLists is 'null'; then return ratingEntityLists Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentGroupedEntities ImmutableAssessmentGroupedEntities.fromJson(Json)"
  })
  void testFromJson_whenJsonRatingEntityListsIsNull_thenReturnRatingEntityListsEmpty() {
    // Arrange
    Json json = new Json();

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
    json.setAssessmentDefinition(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());
    json.setRatingEntityLists(null);

    // Act
    ImmutableAssessmentGroupedEntities actualFromJsonResult =
        ImmutableAssessmentGroupedEntities.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.ratingEntityLists().isEmpty());
    AssessmentDefinition expectedAssessmentDefinitionResult = json.assessmentDefinition;
    assertSame(expectedAssessmentDefinitionResult, actualFromJsonResult.assessmentDefinition());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentGroupedEntities#toString()}
   *   <li>{@link ImmutableAssessmentGroupedEntities#assessmentDefinition()}
   *   <li>{@link ImmutableAssessmentGroupedEntities#ratingEntityLists()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentDefinition ImmutableAssessmentGroupedEntities.assessmentDefinition()",
    "java.util.Set ImmutableAssessmentGroupedEntities.ratingEntityLists()",
    "String ImmutableAssessmentGroupedEntities.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

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
    ImmutableAssessmentGroupedEntities immutableAssessmentGroupedEntities =
        builderResult
            .assessmentDefinition(
                provenanceResult
                    .qualifierReference(qualifierReference)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableAssessmentGroupedEntities.toString();
    AssessmentDefinition actualAssessmentDefinitionResult =
        immutableAssessmentGroupedEntities.assessmentDefinition();

    // Assert
    assertTrue(actualAssessmentDefinitionResult instanceof ImmutableAssessmentDefinition);
    assertEquals(
        "AssessmentGroupedEntities{assessmentDefinition=AssessmentDefinition{id=1, externalId=42, name=Name,"
            + " lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, provenance=Provenance, entityKind=ALL,"
            + " ratingSchemeId=1, permittedRole=Permitted Role, isReadOnly=true, visibility=PRIMARY, definitionGroup"
            + "=Definition Group, kind=ALL, qualifierReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}, cardinality=ZERO_ONE}, ratingEntityLists=[]}",
        actualToStringResult);
    assertTrue(immutableAssessmentGroupedEntities.ratingEntityLists().isEmpty());
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
  @MethodsUnderTest({"AssessmentDefinition Json.assessmentDefinition()"})
  void testJsonAssessmentDefinition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().assessmentDefinition());
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
    assertNull(actualJson.assessmentDefinition);
    assertTrue(actualJson.ratingEntityLists.isEmpty());
  }

  /**
   * Test Json {@link Json#ratingEntityLists()}.
   *
   * <p>Method under test: {@link Json#ratingEntityLists()}
   */
  @Test
  @DisplayName("Test Json ratingEntityLists()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set Json.ratingEntityLists()"})
  void testJsonRatingEntityLists() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingEntityLists());
  }

  /**
   * Test {@link ImmutableAssessmentGroupedEntities#withAssessmentDefinition(AssessmentDefinition)}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentGroupedEntities#withAssessmentDefinition(AssessmentDefinition)}
   */
  @Test
  @DisplayName("Test withAssessmentDefinition(AssessmentDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentGroupedEntities ImmutableAssessmentGroupedEntities.withAssessmentDefinition(AssessmentDefinition)"
  })
  void testWithAssessmentDefinition() {
    // Arrange
    Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

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
    ImmutableAssessmentGroupedEntities immutableAssessmentGroupedEntities =
        builderResult
            .assessmentDefinition(
                provenanceResult
                    .qualifierReference(qualifierReference)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
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

    // Act
    ImmutableAssessmentGroupedEntities actualWithAssessmentDefinitionResult =
        immutableAssessmentGroupedEntities.withAssessmentDefinition(
            provenanceResult2
                .qualifierReference(qualifierReference2)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    // Assert
    assertEquals(immutableAssessmentGroupedEntities, actualWithAssessmentDefinitionResult);
  }

  /**
   * Test {@link ImmutableAssessmentGroupedEntities#withRatingEntityLists(RatingEntityList[])} with
   * {@code RatingEntityList[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentGroupedEntities#withRatingEntityLists(RatingEntityList[])}
   */
  @Test
  @DisplayName("Test withRatingEntityLists(RatingEntityList[]) with 'RatingEntityList[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentGroupedEntities ImmutableAssessmentGroupedEntities.withRatingEntityLists(RatingEntityList[])"
  })
  void testWithRatingEntityListsWithRatingEntityList() {
    // Arrange
    Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

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
    ImmutableAssessmentGroupedEntities immutableAssessmentGroupedEntities =
        builderResult
            .assessmentDefinition(
                provenanceResult
                    .qualifierReference(qualifierReference)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build();

    // Act
    ImmutableAssessmentGroupedEntities actualWithRatingEntityListsResult =
        immutableAssessmentGroupedEntities.withRatingEntityLists(
            ImmutableRatingEntityList.builder().rating("Rating").build());

    // Assert
    AssessmentDefinition assessmentDefinitionResult =
        actualWithRatingEntityListsResult.assessmentDefinition();
    assertTrue(assessmentDefinitionResult instanceof ImmutableAssessmentDefinition);
    assertEquals("2020-03-01", assessmentDefinitionResult.lastUpdatedBy());
    assertEquals("Definition Group", assessmentDefinitionResult.definitionGroup());
    assertEquals("Name", assessmentDefinitionResult.name());
    assertEquals("Provenance", assessmentDefinitionResult.provenance());
    assertEquals(
        "The characteristics of someone or something", assessmentDefinitionResult.description());
    assertEquals(1, actualWithRatingEntityListsResult.ratingEntityLists().size());
    assertEquals(1L, assessmentDefinitionResult.ratingSchemeId());
    assertEquals(Cardinality.ZERO_ONE, assessmentDefinitionResult.cardinality());
    assertEquals(EntityKind.ALL, assessmentDefinitionResult.entityKind());
    assertEquals(EntityKind.ALL, assessmentDefinitionResult.kind());
    assertEquals(AssessmentVisibility.PRIMARY, assessmentDefinitionResult.visibility());
    assertTrue(assessmentDefinitionResult.isReadOnly());
  }
}
