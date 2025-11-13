package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.BulkChangeStatistics;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableBulkChangeStatistics;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableSaveBulkUploadAssessmentStats.Builder;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableSaveBulkUploadAssessmentStats.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSaveBulkUploadAssessmentStatsDiffblueTest {
  /**
   * Test Builder {@link Builder#assessmentStatistics(BulkChangeStatistics)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#assessmentStatistics(BulkChangeStatistics)}
   */
  @Test
  @DisplayName("Test Builder assessmentStatistics(BulkChangeStatistics); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.assessmentStatistics(BulkChangeStatistics)"})
  void testBuilderAssessmentStatistics_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadAssessmentStats.builder();

    // Act
    Builder actualAssessmentStatisticsResult =
        builderResult.assessmentStatistics(
            ImmutableBulkChangeStatistics.builder()
                .addedCount(3)
                .removedCount(3)
                .updatedCount(3)
                .build());

    // Assert
    assertSame(builderResult, actualAssessmentStatisticsResult);
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
  @MethodsUnderTest({"ImmutableSaveBulkUploadAssessmentStats Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableSaveBulkUploadAssessmentStats.builder();
    ImmutableBulkChangeStatistics assessmentStatistics =
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(3)
            .updatedCount(3)
            .build();
    Builder actualAssessmentStatisticsResult =
        actualBuilderResult.assessmentStatistics(assessmentStatistics);
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
    ImmutableAssessmentDefinition definition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    ImmutableSaveBulkUploadAssessmentStats actualImmutableSaveBulkUploadAssessmentStats =
        actualAssessmentStatisticsResult.definition(definition).build();

    // Assert
    assertSame(
        assessmentStatistics, actualImmutableSaveBulkUploadAssessmentStats.assessmentStatistics());
    assertSame(definition, actualImmutableSaveBulkUploadAssessmentStats.definition());
  }

  /**
   * Test Builder {@link Builder#definition(AssessmentDefinition)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#definition(AssessmentDefinition)}
   */
  @Test
  @DisplayName("Test Builder definition(AssessmentDefinition); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.definition(AssessmentDefinition)"})
  void testBuilderDefinition_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadAssessmentStats.builder();

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

    // Act
    Builder actualDefinitionResult =
        builderResult.definition(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    // Assert
    assertSame(builderResult, actualDefinitionResult);
  }

  /**
   * Test Builder {@link Builder#from(SaveBulkUploadAssessmentStats)}.
   *
   * <p>Method under test: {@link Builder#from(SaveBulkUploadAssessmentStats)}
   */
  @Test
  @DisplayName("Test Builder from(SaveBulkUploadAssessmentStats)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SaveBulkUploadAssessmentStats)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadAssessmentStats.builder();

    Builder builderResult2 = ImmutableSaveBulkUploadAssessmentStats.builder();

    Builder assessmentStatisticsResult =
        builderResult2.assessmentStatistics(
            ImmutableBulkChangeStatistics.builder()
                .addedCount(3)
                .removedCount(3)
                .updatedCount(3)
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
    ImmutableSaveBulkUploadAssessmentStats instance =
        assessmentStatisticsResult
            .definition(
                provenanceResult
                    .qualifierReference(qualifierReference)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSaveBulkUploadAssessmentStats actualImmutableSaveBulkUploadAssessmentStats =
        builderResult.build();
    assertEquals(instance, actualImmutableSaveBulkUploadAssessmentStats);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableSaveBulkUploadAssessmentStats#copyOf(SaveBulkUploadAssessmentStats)}.
   *
   * <ul>
   *   <li>Then assessmentStatistics return {@link ImmutableBulkChangeStatistics}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSaveBulkUploadAssessmentStats#copyOf(SaveBulkUploadAssessmentStats)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SaveBulkUploadAssessmentStats); then assessmentStatistics return ImmutableBulkChangeStatistics")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveBulkUploadAssessmentStats ImmutableSaveBulkUploadAssessmentStats.copyOf(SaveBulkUploadAssessmentStats)"
  })
  void testCopyOf_thenAssessmentStatisticsReturnImmutableBulkChangeStatistics() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadAssessmentStats.builder();

    Builder assessmentStatisticsResult =
        builderResult.assessmentStatistics(
            ImmutableBulkChangeStatistics.builder()
                .addedCount(3)
                .removedCount(3)
                .updatedCount(3)
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
    ImmutableSaveBulkUploadAssessmentStats instance =
        assessmentStatisticsResult
            .definition(
                provenanceResult
                    .qualifierReference(qualifierReference)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build();

    // Act
    ImmutableSaveBulkUploadAssessmentStats actualCopyOfResult =
        ImmutableSaveBulkUploadAssessmentStats.copyOf(instance);

    // Assert
    BulkChangeStatistics assessmentStatisticsResult2 = actualCopyOfResult.assessmentStatistics();
    assertTrue(assessmentStatisticsResult2 instanceof ImmutableBulkChangeStatistics);
    AssessmentDefinition definitionResult = actualCopyOfResult.definition();
    assertTrue(definitionResult instanceof ImmutableAssessmentDefinition);
    assertEquals("2020-03-01", definitionResult.lastUpdatedBy());
    assertEquals("Definition Group", definitionResult.definitionGroup());
    assertEquals("Name", definitionResult.name());
    assertEquals("Provenance", definitionResult.provenance());
    assertEquals("The characteristics of someone or something", definitionResult.description());
    assertEquals(1L, definitionResult.ratingSchemeId());
    assertEquals(3, assessmentStatisticsResult2.addedCount());
    assertEquals(3, assessmentStatisticsResult2.removedCount());
    assertEquals(3, assessmentStatisticsResult2.updatedCount());
    assertEquals(Cardinality.ZERO_ONE, definitionResult.cardinality());
    assertEquals(EntityKind.ALL, definitionResult.entityKind());
    assertEquals(EntityKind.ALL, definitionResult.kind());
    assertEquals(AssessmentVisibility.PRIMARY, definitionResult.visibility());
    assertTrue(definitionResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableSaveBulkUploadAssessmentStats#equals(Object)}, and {@link
   * ImmutableSaveBulkUploadAssessmentStats#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSaveBulkUploadAssessmentStats#equals(Object)}
   *   <li>{@link ImmutableSaveBulkUploadAssessmentStats#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveBulkUploadAssessmentStats.equals(Object)",
    "int ImmutableSaveBulkUploadAssessmentStats.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadAssessmentStats.builder();

    Builder assessmentStatisticsResult =
        builderResult.assessmentStatistics(
            ImmutableBulkChangeStatistics.builder()
                .addedCount(3)
                .removedCount(3)
                .updatedCount(3)
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
    ImmutableSaveBulkUploadAssessmentStats immutableSaveBulkUploadAssessmentStats =
        assessmentStatisticsResult
            .definition(
                provenanceResult
                    .qualifierReference(qualifierReference)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build();

    Builder builderResult2 = ImmutableSaveBulkUploadAssessmentStats.builder();

    Builder assessmentStatisticsResult2 =
        builderResult2.assessmentStatistics(
            ImmutableBulkChangeStatistics.builder()
                .addedCount(3)
                .removedCount(3)
                .updatedCount(3)
                .build());

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
    ImmutableSaveBulkUploadAssessmentStats immutableSaveBulkUploadAssessmentStats2 =
        assessmentStatisticsResult2
            .definition(
                provenanceResult2
                    .qualifierReference(qualifierReference2)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableSaveBulkUploadAssessmentStats, immutableSaveBulkUploadAssessmentStats2);
    assertEquals(
        immutableSaveBulkUploadAssessmentStats.hashCode(),
        immutableSaveBulkUploadAssessmentStats2.hashCode());
  }

  /**
   * Test {@link ImmutableSaveBulkUploadAssessmentStats#equals(Object)}, and {@link
   * ImmutableSaveBulkUploadAssessmentStats#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSaveBulkUploadAssessmentStats#equals(Object)}
   *   <li>{@link ImmutableSaveBulkUploadAssessmentStats#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveBulkUploadAssessmentStats.equals(Object)",
    "int ImmutableSaveBulkUploadAssessmentStats.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadAssessmentStats.builder();

    Builder assessmentStatisticsResult =
        builderResult.assessmentStatistics(
            ImmutableBulkChangeStatistics.builder()
                .addedCount(3)
                .removedCount(3)
                .updatedCount(3)
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
    ImmutableSaveBulkUploadAssessmentStats immutableSaveBulkUploadAssessmentStats =
        assessmentStatisticsResult
            .definition(
                provenanceResult
                    .qualifierReference(qualifierReference)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableSaveBulkUploadAssessmentStats, immutableSaveBulkUploadAssessmentStats);
    int expectedHashCodeResult = immutableSaveBulkUploadAssessmentStats.hashCode();
    assertEquals(expectedHashCodeResult, immutableSaveBulkUploadAssessmentStats.hashCode());
  }

  /**
   * Test {@link ImmutableSaveBulkUploadAssessmentStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveBulkUploadAssessmentStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveBulkUploadAssessmentStats.equals(Object)",
    "int ImmutableSaveBulkUploadAssessmentStats.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadAssessmentStats.builder();

    Builder assessmentStatisticsResult =
        builderResult.assessmentStatistics(
            ImmutableBulkChangeStatistics.builder()
                .addedCount(2)
                .removedCount(3)
                .updatedCount(3)
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
    ImmutableSaveBulkUploadAssessmentStats immutableSaveBulkUploadAssessmentStats =
        assessmentStatisticsResult
            .definition(
                provenanceResult
                    .qualifierReference(qualifierReference)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build();

    Builder builderResult2 = ImmutableSaveBulkUploadAssessmentStats.builder();

    Builder assessmentStatisticsResult2 =
        builderResult2.assessmentStatistics(
            ImmutableBulkChangeStatistics.builder()
                .addedCount(3)
                .removedCount(3)
                .updatedCount(3)
                .build());

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
        immutableSaveBulkUploadAssessmentStats,
        assessmentStatisticsResult2
            .definition(
                provenanceResult2
                    .qualifierReference(qualifierReference2)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableSaveBulkUploadAssessmentStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveBulkUploadAssessmentStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveBulkUploadAssessmentStats.equals(Object)",
    "int ImmutableSaveBulkUploadAssessmentStats.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadAssessmentStats.builder();

    Builder assessmentStatisticsResult =
        builderResult.assessmentStatistics(
            ImmutableBulkChangeStatistics.builder()
                .addedCount(3)
                .removedCount(3)
                .updatedCount(3)
                .build());

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
    ImmutableSaveBulkUploadAssessmentStats immutableSaveBulkUploadAssessmentStats =
        assessmentStatisticsResult
            .definition(
                provenanceResult
                    .qualifierReference(qualifierReference)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build();

    Builder builderResult2 = ImmutableSaveBulkUploadAssessmentStats.builder();

    Builder assessmentStatisticsResult2 =
        builderResult2.assessmentStatistics(
            ImmutableBulkChangeStatistics.builder()
                .addedCount(3)
                .removedCount(3)
                .updatedCount(3)
                .build());

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
        immutableSaveBulkUploadAssessmentStats,
        assessmentStatisticsResult2
            .definition(
                provenanceResult2
                    .qualifierReference(qualifierReference2)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableSaveBulkUploadAssessmentStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveBulkUploadAssessmentStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveBulkUploadAssessmentStats.equals(Object)",
    "int ImmutableSaveBulkUploadAssessmentStats.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadAssessmentStats.builder();

    Builder assessmentStatisticsResult =
        builderResult.assessmentStatistics(
            ImmutableBulkChangeStatistics.builder()
                .addedCount(3)
                .removedCount(3)
                .updatedCount(3)
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

    // Act and Assert
    assertNotEquals(
        assessmentStatisticsResult
            .definition(
                provenanceResult
                    .qualifierReference(qualifierReference)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSaveBulkUploadAssessmentStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveBulkUploadAssessmentStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveBulkUploadAssessmentStats.equals(Object)",
    "int ImmutableSaveBulkUploadAssessmentStats.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadAssessmentStats.builder();

    Builder assessmentStatisticsResult =
        builderResult.assessmentStatistics(
            ImmutableBulkChangeStatistics.builder()
                .addedCount(3)
                .removedCount(3)
                .updatedCount(3)
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

    // Act and Assert
    assertNotEquals(
        assessmentStatisticsResult
            .definition(
                provenanceResult
                    .qualifierReference(qualifierReference)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build(),
        "Different type to ImmutableSaveBulkUploadAssessmentStats");
  }

  /**
   * Test {@link ImmutableSaveBulkUploadAssessmentStats#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentStatistics is {@link Json} (default constructor) {@link
   *       Json#assessmentStatistics}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveBulkUploadAssessmentStats#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return assessmentStatistics is Json (default constructor) assessmentStatistics")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveBulkUploadAssessmentStats ImmutableSaveBulkUploadAssessmentStats.fromJson(Json)"
  })
  void testFromJson_thenReturnAssessmentStatisticsIsJsonAssessmentStatistics() {
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
    json.setDefinition(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());
    json.setAssessmentStatistics(
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(3)
            .updatedCount(3)
            .build());

    // Act
    ImmutableSaveBulkUploadAssessmentStats actualFromJsonResult =
        ImmutableSaveBulkUploadAssessmentStats.fromJson(json);

    // Assert
    BulkChangeStatistics expectedAssessmentStatisticsResult = json.assessmentStatistics;
    assertSame(expectedAssessmentStatisticsResult, actualFromJsonResult.assessmentStatistics());
    AssessmentDefinition expectedDefinitionResult = json.definition;
    assertSame(expectedDefinitionResult, actualFromJsonResult.definition());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSaveBulkUploadAssessmentStats#toString()}
   *   <li>{@link ImmutableSaveBulkUploadAssessmentStats#assessmentStatistics()}
   *   <li>{@link ImmutableSaveBulkUploadAssessmentStats#definition()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkChangeStatistics ImmutableSaveBulkUploadAssessmentStats.assessmentStatistics()",
    "AssessmentDefinition ImmutableSaveBulkUploadAssessmentStats.definition()",
    "String ImmutableSaveBulkUploadAssessmentStats.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadAssessmentStats.builder();

    Builder assessmentStatisticsResult =
        builderResult.assessmentStatistics(
            ImmutableBulkChangeStatistics.builder()
                .addedCount(3)
                .removedCount(3)
                .updatedCount(3)
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
    ImmutableSaveBulkUploadAssessmentStats immutableSaveBulkUploadAssessmentStats =
        assessmentStatisticsResult
            .definition(
                provenanceResult
                    .qualifierReference(qualifierReference)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableSaveBulkUploadAssessmentStats.toString();
    BulkChangeStatistics actualAssessmentStatisticsResult =
        immutableSaveBulkUploadAssessmentStats.assessmentStatistics();

    // Assert
    assertTrue(actualAssessmentStatisticsResult instanceof ImmutableBulkChangeStatistics);
    assertTrue(
        immutableSaveBulkUploadAssessmentStats.definition()
            instanceof ImmutableAssessmentDefinition);
    assertEquals(
        "SaveBulkUploadAssessmentStats{definition=AssessmentDefinition{id=1, externalId=42, name=Name,"
            + " lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, provenance=Provenance, entityKind=ALL,"
            + " ratingSchemeId=1, permittedRole=Permitted Role, isReadOnly=true, visibility=PRIMARY, definitionGroup"
            + "=Definition Group, kind=ALL, qualifierReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}, cardinality=ZERO_ONE}, assessmentStatistics=BulkChangeStatistics{addedCount=3, updatedCount=3,"
            + " removedCount=3}}",
        actualToStringResult);
  }

  /**
   * Test Json {@link Json#assessmentStatistics()}.
   *
   * <p>Method under test: {@link Json#assessmentStatistics()}
   */
  @Test
  @DisplayName("Test Json assessmentStatistics()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BulkChangeStatistics Json.assessmentStatistics()"})
  void testJsonAssessmentStatistics() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().assessmentStatistics());
  }

  /**
   * Test Json {@link Json#definition()}.
   *
   * <p>Method under test: {@link Json#definition()}
   */
  @Test
  @DisplayName("Test Json definition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentDefinition Json.definition()"})
  void testJsonDefinition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().definition());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAssessmentStatistics(BulkChangeStatistics)}
   *   <li>{@link Json#setDefinition(AssessmentDefinition)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setAssessmentStatistics(BulkChangeStatistics)",
    "void Json.setDefinition(AssessmentDefinition)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setAssessmentStatistics(
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(3)
            .updatedCount(3)
            .build());
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
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
            .lastUpdatedAt(ofResult.atStartOfDay())
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
    actualJson.setDefinition(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());

    // Assert
    BulkChangeStatistics bulkChangeStatistics = actualJson.assessmentStatistics;
    assertTrue(bulkChangeStatistics instanceof ImmutableBulkChangeStatistics);
    AssessmentDefinition assessmentDefinition = actualJson.definition;
    assertTrue(assessmentDefinition instanceof ImmutableAssessmentDefinition);
    LocalDateTime lastUpdatedAtResult = assessmentDefinition.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", assessmentDefinition.lastUpdatedBy());
    assertEquals("Definition Group", assessmentDefinition.definitionGroup());
    assertEquals("Name", assessmentDefinition.name());
    assertEquals("Provenance", assessmentDefinition.provenance());
    assertEquals("The characteristics of someone or something", assessmentDefinition.description());
    assertEquals(1L, assessmentDefinition.ratingSchemeId());
    assertEquals(3, bulkChangeStatistics.addedCount());
    assertEquals(3, bulkChangeStatistics.removedCount());
    assertEquals(3, bulkChangeStatistics.updatedCount());
    assertEquals(Cardinality.ZERO_ONE, assessmentDefinition.cardinality());
    assertEquals(EntityKind.ALL, assessmentDefinition.entityKind());
    assertEquals(EntityKind.ALL, assessmentDefinition.kind());
    assertEquals(AssessmentVisibility.PRIMARY, assessmentDefinition.visibility());
    assertTrue(assessmentDefinition.isReadOnly());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link
   * ImmutableSaveBulkUploadAssessmentStats#withAssessmentStatistics(BulkChangeStatistics)}.
   *
   * <p>Method under test: {@link
   * ImmutableSaveBulkUploadAssessmentStats#withAssessmentStatistics(BulkChangeStatistics)}
   */
  @Test
  @DisplayName("Test withAssessmentStatistics(BulkChangeStatistics)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveBulkUploadAssessmentStats ImmutableSaveBulkUploadAssessmentStats.withAssessmentStatistics(BulkChangeStatistics)"
  })
  void testWithAssessmentStatistics() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadAssessmentStats.builder();

    Builder assessmentStatisticsResult =
        builderResult.assessmentStatistics(
            ImmutableBulkChangeStatistics.builder()
                .addedCount(3)
                .removedCount(3)
                .updatedCount(3)
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
    ImmutableSaveBulkUploadAssessmentStats immutableSaveBulkUploadAssessmentStats =
        assessmentStatisticsResult
            .definition(
                provenanceResult
                    .qualifierReference(qualifierReference)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build();

    // Act
    ImmutableSaveBulkUploadAssessmentStats actualWithAssessmentStatisticsResult =
        immutableSaveBulkUploadAssessmentStats.withAssessmentStatistics(
            ImmutableBulkChangeStatistics.builder()
                .addedCount(3)
                .removedCount(3)
                .updatedCount(3)
                .build());

    // Assert
    assertEquals(immutableSaveBulkUploadAssessmentStats, actualWithAssessmentStatisticsResult);
  }

  /**
   * Test {@link ImmutableSaveBulkUploadAssessmentStats#withDefinition(AssessmentDefinition)}.
   *
   * <p>Method under test: {@link
   * ImmutableSaveBulkUploadAssessmentStats#withDefinition(AssessmentDefinition)}
   */
  @Test
  @DisplayName("Test withDefinition(AssessmentDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveBulkUploadAssessmentStats ImmutableSaveBulkUploadAssessmentStats.withDefinition(AssessmentDefinition)"
  })
  void testWithDefinition() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadAssessmentStats.builder();

    Builder assessmentStatisticsResult =
        builderResult.assessmentStatistics(
            ImmutableBulkChangeStatistics.builder()
                .addedCount(3)
                .removedCount(3)
                .updatedCount(3)
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
    ImmutableSaveBulkUploadAssessmentStats immutableSaveBulkUploadAssessmentStats =
        assessmentStatisticsResult
            .definition(
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
    ImmutableSaveBulkUploadAssessmentStats actualWithDefinitionResult =
        immutableSaveBulkUploadAssessmentStats.withDefinition(
            provenanceResult2
                .qualifierReference(qualifierReference2)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    // Assert
    assertEquals(immutableSaveBulkUploadAssessmentStats, actualWithDefinitionResult);
  }
}
