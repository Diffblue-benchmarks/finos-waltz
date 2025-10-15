package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.BulkChangeStatistics;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableBulkChangeStatistics;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Builder;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSaveBulkUploadLegalEntityRelationshipResponseDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAssessmentStats(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllAssessmentStats(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAssessmentStats(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllAssessmentStats(Iterable)"})
  void testBuilderAddAllAssessmentStats_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();

    // Act
    Builder actualAddAllAssessmentStatsResult =
        builderResult.addAllAssessmentStats(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAssessmentStatsResult);
  }

  /**
   * Test Builder {@link Builder#addAssessmentStats(SaveBulkUploadAssessmentStats)} with {@code
   * element}.
   *
   * <ul>
   *   <li>When {@link ImmutableSaveBulkUploadAssessmentStats.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAssessmentStats(SaveBulkUploadAssessmentStats)}
   */
  @Test
  @DisplayName(
      "Test Builder addAssessmentStats(SaveBulkUploadAssessmentStats) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAssessmentStats(SaveBulkUploadAssessmentStats)"})
  void testBuilderAddAssessmentStatsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();

    // Act
    Builder actualAddAssessmentStatsResult =
        builderResult.addAssessmentStats(new ImmutableSaveBulkUploadAssessmentStats.Json());

    // Assert
    assertSame(builderResult, actualAddAssessmentStatsResult);
  }

  /**
   * Test Builder {@link Builder#addAssessmentStats(SaveBulkUploadAssessmentStats[])} with {@code
   * elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableSaveBulkUploadAssessmentStats.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAssessmentStats(SaveBulkUploadAssessmentStats[])}
   */
  @Test
  @DisplayName(
      "Test Builder addAssessmentStats(SaveBulkUploadAssessmentStats[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAssessmentStats(SaveBulkUploadAssessmentStats[])"})
  void testBuilderAddAssessmentStatsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();

    // Act
    Builder actualAddAssessmentStatsResult =
        builderResult.addAssessmentStats(new ImmutableSaveBulkUploadAssessmentStats.Json());

    // Assert
    assertSame(builderResult, actualAddAssessmentStatsResult);
  }

  /**
   * Test Builder {@link Builder#assessmentStats(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#assessmentStats(Iterable)}
   */
  @Test
  @DisplayName("Test Builder assessmentStats(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.assessmentStats(Iterable)"})
  void testBuilderAssessmentStats_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();

    // Act
    Builder actualAssessmentStatsResult = builderResult.assessmentStats(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAssessmentStatsResult);
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
  @MethodsUnderTest({"ImmutableSaveBulkUploadLegalEntityRelationshipResponse Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();
    ImmutableBulkChangeStatistics relationshipStats =
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(3)
            .updatedCount(3)
            .build();
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse
        actualImmutableSaveBulkUploadLegalEntityRelationshipResponse =
            actualBuilderResult.relationshipStats(relationshipStats).build();

    // Assert
    assertTrue(
        actualImmutableSaveBulkUploadLegalEntityRelationshipResponse.assessmentStats().isEmpty());
    assertSame(
        relationshipStats,
        actualImmutableSaveBulkUploadLegalEntityRelationshipResponse.relationshipStats());
  }

  /**
   * Test Builder {@link Builder#from(SaveBulkUploadLegalEntityRelationshipResponse)}.
   *
   * <p>Method under test: {@link Builder#from(SaveBulkUploadLegalEntityRelationshipResponse)}
   */
  @Test
  @DisplayName("Test Builder from(SaveBulkUploadLegalEntityRelationshipResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SaveBulkUploadLegalEntityRelationshipResponse)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();

    Builder builderResult2 = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse instance =
        builderResult2
            .relationshipStats(
                ImmutableBulkChangeStatistics.builder()
                    .addedCount(3)
                    .removedCount(3)
                    .updatedCount(3)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse
        actualImmutableSaveBulkUploadLegalEntityRelationshipResponse = builderResult.build();
    assertEquals(instance, actualImmutableSaveBulkUploadLegalEntityRelationshipResponse);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#relationshipStats(BulkChangeStatistics)}.
   *
   * <ul>
   *   <li>When {@link BulkChangeStatistics}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#relationshipStats(BulkChangeStatistics)}
   */
  @Test
  @DisplayName(
      "Test Builder relationshipStats(BulkChangeStatistics); when BulkChangeStatistics; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.relationshipStats(BulkChangeStatistics)"})
  void testBuilderRelationshipStats_whenBulkChangeStatistics_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();
    BulkChangeStatistics relationshipStats = mock(BulkChangeStatistics.class);

    // Act
    Builder actualRelationshipStatsResult = builderResult.relationshipStats(relationshipStats);

    // Assert
    assertSame(builderResult, actualRelationshipStatsResult);
    assertSame(relationshipStats, builderResult.build().relationshipStats());
  }

  /**
   * Test {@link
   * ImmutableSaveBulkUploadLegalEntityRelationshipResponse#copyOf(SaveBulkUploadLegalEntityRelationshipResponse)}.
   *
   * <ul>
   *   <li>Then relationshipStats return {@link ImmutableBulkChangeStatistics}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSaveBulkUploadLegalEntityRelationshipResponse#copyOf(SaveBulkUploadLegalEntityRelationshipResponse)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SaveBulkUploadLegalEntityRelationshipResponse); then relationshipStats return ImmutableBulkChangeStatistics")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveBulkUploadLegalEntityRelationshipResponse ImmutableSaveBulkUploadLegalEntityRelationshipResponse.copyOf(SaveBulkUploadLegalEntityRelationshipResponse)"
  })
  void testCopyOf_thenRelationshipStatsReturnImmutableBulkChangeStatistics() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse instance =
        builderResult
            .relationshipStats(
                ImmutableBulkChangeStatistics.builder()
                    .addedCount(3)
                    .removedCount(3)
                    .updatedCount(3)
                    .build())
            .build();

    // Act
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse actualCopyOfResult =
        ImmutableSaveBulkUploadLegalEntityRelationshipResponse.copyOf(instance);

    // Assert
    BulkChangeStatistics relationshipStatsResult = actualCopyOfResult.relationshipStats();
    assertTrue(relationshipStatsResult instanceof ImmutableBulkChangeStatistics);
    assertEquals(3, relationshipStatsResult.addedCount());
    assertEquals(3, relationshipStatsResult.removedCount());
    assertEquals(3, relationshipStatsResult.updatedCount());
    assertTrue(actualCopyOfResult.assessmentStats().isEmpty());
  }

  /**
   * Test {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse#equals(Object)}, and {@link
   * ImmutableSaveBulkUploadLegalEntityRelationshipResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse#equals(Object)}
   *   <li>{@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveBulkUploadLegalEntityRelationshipResponse.equals(Object)",
    "int ImmutableSaveBulkUploadLegalEntityRelationshipResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse
        immutableSaveBulkUploadLegalEntityRelationshipResponse =
            builderResult
                .relationshipStats(
                    ImmutableBulkChangeStatistics.builder()
                        .addedCount(3)
                        .removedCount(3)
                        .updatedCount(3)
                        .build())
                .build();

    Builder builderResult2 = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse
        immutableSaveBulkUploadLegalEntityRelationshipResponse2 =
            builderResult2
                .relationshipStats(
                    ImmutableBulkChangeStatistics.builder()
                        .addedCount(3)
                        .removedCount(3)
                        .updatedCount(3)
                        .build())
                .build();

    // Act and Assert
    assertEquals(
        immutableSaveBulkUploadLegalEntityRelationshipResponse,
        immutableSaveBulkUploadLegalEntityRelationshipResponse2);
    assertEquals(
        immutableSaveBulkUploadLegalEntityRelationshipResponse.hashCode(),
        immutableSaveBulkUploadLegalEntityRelationshipResponse2.hashCode());
  }

  /**
   * Test {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse#equals(Object)}, and {@link
   * ImmutableSaveBulkUploadLegalEntityRelationshipResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse#equals(Object)}
   *   <li>{@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveBulkUploadLegalEntityRelationshipResponse.equals(Object)",
    "int ImmutableSaveBulkUploadLegalEntityRelationshipResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse
        immutableSaveBulkUploadLegalEntityRelationshipResponse =
            builderResult
                .relationshipStats(
                    ImmutableBulkChangeStatistics.builder()
                        .addedCount(3)
                        .removedCount(3)
                        .updatedCount(3)
                        .build())
                .build();

    // Act and Assert
    assertEquals(
        immutableSaveBulkUploadLegalEntityRelationshipResponse,
        immutableSaveBulkUploadLegalEntityRelationshipResponse);
    int expectedHashCodeResult = immutableSaveBulkUploadLegalEntityRelationshipResponse.hashCode();
    assertEquals(
        expectedHashCodeResult, immutableSaveBulkUploadLegalEntityRelationshipResponse.hashCode());
  }

  /**
   * Test {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSaveBulkUploadLegalEntityRelationshipResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveBulkUploadLegalEntityRelationshipResponse.equals(Object)",
    "int ImmutableSaveBulkUploadLegalEntityRelationshipResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();

    ImmutableSaveBulkUploadAssessmentStats.Builder builderResult2 =
        ImmutableSaveBulkUploadAssessmentStats.builder();

    ImmutableSaveBulkUploadAssessmentStats.Builder assessmentStatisticsResult =
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
    builderResult.addAssessmentStats(
        assessmentStatisticsResult
            .definition(
                provenanceResult
                    .qualifierReference(qualifierReference)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build());
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse
        immutableSaveBulkUploadLegalEntityRelationshipResponse =
            builderResult
                .relationshipStats(
                    ImmutableBulkChangeStatistics.builder()
                        .addedCount(3)
                        .removedCount(3)
                        .updatedCount(3)
                        .build())
                .build();

    Builder builderResult3 = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();

    // Act and Assert
    assertNotEquals(
        immutableSaveBulkUploadLegalEntityRelationshipResponse,
        builderResult3
            .relationshipStats(
                ImmutableBulkChangeStatistics.builder()
                    .addedCount(3)
                    .removedCount(3)
                    .updatedCount(3)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSaveBulkUploadLegalEntityRelationshipResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveBulkUploadLegalEntityRelationshipResponse.equals(Object)",
    "int ImmutableSaveBulkUploadLegalEntityRelationshipResponse.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .relationshipStats(
                ImmutableBulkChangeStatistics.builder()
                    .addedCount(3)
                    .removedCount(3)
                    .updatedCount(3)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSaveBulkUploadLegalEntityRelationshipResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveBulkUploadLegalEntityRelationshipResponse.equals(Object)",
    "int ImmutableSaveBulkUploadLegalEntityRelationshipResponse.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .relationshipStats(
                ImmutableBulkChangeStatistics.builder()
                    .addedCount(3)
                    .removedCount(3)
                    .updatedCount(3)
                    .build())
            .build(),
        "Different type to ImmutableSaveBulkUploadLegalEntityRelationshipResponse");
  }

  /**
   * Test {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) AssessmentStats is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSaveBulkUploadLegalEntityRelationshipResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) AssessmentStats is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveBulkUploadLegalEntityRelationshipResponse ImmutableSaveBulkUploadLegalEntityRelationshipResponse.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonAssessmentStatsIsHashSet() {
    // Arrange
    Json json = new Json();
    json.setRelationshipStats(
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(3)
            .updatedCount(3)
            .build());
    json.setAssessmentStats(new HashSet<>());

    // Act
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse actualFromJsonResult =
        ImmutableSaveBulkUploadLegalEntityRelationshipResponse.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.assessmentStats().isEmpty());
    BulkChangeStatistics expectedRelationshipStatsResult = json.relationshipStats;
    assertSame(expectedRelationshipStatsResult, actualFromJsonResult.relationshipStats());
  }

  /**
   * Test {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentStats is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSaveBulkUploadLegalEntityRelationshipResponse#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessmentStats is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveBulkUploadLegalEntityRelationshipResponse ImmutableSaveBulkUploadLegalEntityRelationshipResponse.fromJson(Json)"
  })
  void testFromJson_thenReturnAssessmentStatsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<SaveBulkUploadAssessmentStats> assessmentStats = new LinkedHashSet<>();

    ImmutableSaveBulkUploadAssessmentStats.Builder builderResult =
        ImmutableSaveBulkUploadAssessmentStats.builder();

    ImmutableSaveBulkUploadAssessmentStats.Builder assessmentStatisticsResult =
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
    assessmentStats.add(
        assessmentStatisticsResult
            .definition(
                provenanceResult
                    .qualifierReference(qualifierReference)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build());

    ImmutableSaveBulkUploadAssessmentStats.Builder builderResult2 =
        ImmutableSaveBulkUploadAssessmentStats.builder();

    ImmutableSaveBulkUploadAssessmentStats.Builder assessmentStatisticsResult2 =
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
    assessmentStats.add(
        assessmentStatisticsResult2
            .definition(
                provenanceResult2
                    .qualifierReference(qualifierReference2)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build());

    Json json = new Json();
    json.setRelationshipStats(
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(3)
            .updatedCount(3)
            .build());
    json.setAssessmentStats(assessmentStats);

    // Act
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse actualFromJsonResult =
        ImmutableSaveBulkUploadLegalEntityRelationshipResponse.fromJson(json);

    // Assert
    assertEquals(assessmentStats, actualFromJsonResult.assessmentStats());
    BulkChangeStatistics expectedRelationshipStatsResult = json.relationshipStats;
    assertSame(expectedRelationshipStatsResult, actualFromJsonResult.relationshipStats());
  }

  /**
   * Test {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessmentStats size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSaveBulkUploadLegalEntityRelationshipResponse#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessmentStats size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveBulkUploadLegalEntityRelationshipResponse ImmutableSaveBulkUploadLegalEntityRelationshipResponse.fromJson(Json)"
  })
  void testFromJson_thenReturnAssessmentStatsSizeIsOne() {
    // Arrange
    LinkedHashSet<SaveBulkUploadAssessmentStats> assessmentStats = new LinkedHashSet<>();

    ImmutableSaveBulkUploadAssessmentStats.Builder builderResult =
        ImmutableSaveBulkUploadAssessmentStats.builder();

    ImmutableSaveBulkUploadAssessmentStats.Builder assessmentStatisticsResult =
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
    assessmentStats.add(
        assessmentStatisticsResult
            .definition(
                provenanceResult
                    .qualifierReference(qualifierReference)
                    .ratingSchemeId(1L)
                    .visibility(AssessmentVisibility.PRIMARY)
                    .build())
            .build());

    Json json = new Json();
    json.setRelationshipStats(
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(3)
            .updatedCount(3)
            .build());
    json.setAssessmentStats(assessmentStats);

    // Act
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse actualFromJsonResult =
        ImmutableSaveBulkUploadLegalEntityRelationshipResponse.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.assessmentStats().size());
    BulkChangeStatistics expectedRelationshipStatsResult = json.relationshipStats;
    assertSame(expectedRelationshipStatsResult, actualFromJsonResult.relationshipStats());
  }

  /**
   * Test {@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) AssessmentStats is {@code null}.
   *   <li>Then return assessmentStats Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSaveBulkUploadLegalEntityRelationshipResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) AssessmentStats is 'null'; then return assessmentStats Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveBulkUploadLegalEntityRelationshipResponse ImmutableSaveBulkUploadLegalEntityRelationshipResponse.fromJson(Json)"
  })
  void testFromJson_whenJsonAssessmentStatsIsNull_thenReturnAssessmentStatsEmpty() {
    // Arrange
    Json json = new Json();
    json.setRelationshipStats(
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(3)
            .updatedCount(3)
            .build());
    json.setAssessmentStats(null);

    // Act
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse actualFromJsonResult =
        ImmutableSaveBulkUploadLegalEntityRelationshipResponse.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.assessmentStats().isEmpty());
    BulkChangeStatistics expectedRelationshipStatsResult = json.relationshipStats;
    assertSame(expectedRelationshipStatsResult, actualFromJsonResult.relationshipStats());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse#toString()}
   *   <li>{@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse#assessmentStats()}
   *   <li>{@link ImmutableSaveBulkUploadLegalEntityRelationshipResponse#relationshipStats()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableSaveBulkUploadLegalEntityRelationshipResponse.assessmentStats()",
    "BulkChangeStatistics ImmutableSaveBulkUploadLegalEntityRelationshipResponse.relationshipStats()",
    "String ImmutableSaveBulkUploadLegalEntityRelationshipResponse.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse
        immutableSaveBulkUploadLegalEntityRelationshipResponse =
            builderResult
                .relationshipStats(
                    ImmutableBulkChangeStatistics.builder()
                        .addedCount(3)
                        .removedCount(3)
                        .updatedCount(3)
                        .build())
                .build();

    // Act
    String actualToStringResult = immutableSaveBulkUploadLegalEntityRelationshipResponse.toString();
    Set<SaveBulkUploadAssessmentStats> actualAssessmentStatsResult =
        immutableSaveBulkUploadLegalEntityRelationshipResponse.assessmentStats();

    // Assert
    assertTrue(
        immutableSaveBulkUploadLegalEntityRelationshipResponse.relationshipStats()
            instanceof ImmutableBulkChangeStatistics);
    assertEquals(
        "SaveBulkUploadLegalEntityRelationshipResponse{relationshipStats=BulkChangeStatistics{addedCount=3,"
            + " updatedCount=3, removedCount=3}, assessmentStats=[]}",
        actualToStringResult);
    assertTrue(actualAssessmentStatsResult.isEmpty());
  }

  /**
   * Test Json {@link Json#assessmentStats()}.
   *
   * <p>Method under test: {@link Json#assessmentStats()}
   */
  @Test
  @DisplayName("Test Json assessmentStats()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.assessmentStats()"})
  void testJsonAssessmentStats() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().assessmentStats());
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
    assertNull(actualJson.relationshipStats);
    assertTrue(actualJson.assessmentStats.isEmpty());
  }

  /**
   * Test Json {@link Json#relationshipStats()}.
   *
   * <p>Method under test: {@link Json#relationshipStats()}
   */
  @Test
  @DisplayName("Test Json relationshipStats()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BulkChangeStatistics Json.relationshipStats()"})
  void testJsonRelationshipStats() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().relationshipStats());
  }

  /**
   * Test {@link
   * ImmutableSaveBulkUploadLegalEntityRelationshipResponse#withAssessmentStats(SaveBulkUploadAssessmentStats[])}
   * with {@code SaveBulkUploadAssessmentStats[]}.
   *
   * <p>Method under test: {@link
   * ImmutableSaveBulkUploadLegalEntityRelationshipResponse#withAssessmentStats(SaveBulkUploadAssessmentStats[])}
   */
  @Test
  @DisplayName(
      "Test withAssessmentStats(SaveBulkUploadAssessmentStats[]) with 'SaveBulkUploadAssessmentStats[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveBulkUploadLegalEntityRelationshipResponse ImmutableSaveBulkUploadLegalEntityRelationshipResponse.withAssessmentStats(SaveBulkUploadAssessmentStats[])"
  })
  void testWithAssessmentStatsWithSaveBulkUploadAssessmentStats() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse
        immutableSaveBulkUploadLegalEntityRelationshipResponse =
            builderResult
                .relationshipStats(
                    ImmutableBulkChangeStatistics.builder()
                        .addedCount(3)
                        .removedCount(3)
                        .updatedCount(3)
                        .build())
                .build();

    ImmutableSaveBulkUploadAssessmentStats.Builder builderResult2 =
        ImmutableSaveBulkUploadAssessmentStats.builder();

    ImmutableSaveBulkUploadAssessmentStats.Builder assessmentStatisticsResult =
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
    Optional<? extends EntityReference> qualifierReference = Optional.empty();

    // Act
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse actualWithAssessmentStatsResult =
        immutableSaveBulkUploadLegalEntityRelationshipResponse.withAssessmentStats(
            assessmentStatisticsResult
                .definition(
                    provenanceResult
                        .qualifierReference(qualifierReference)
                        .ratingSchemeId(1L)
                        .visibility(AssessmentVisibility.PRIMARY)
                        .build())
                .build());

    // Assert
    BulkChangeStatistics relationshipStatsResult =
        actualWithAssessmentStatsResult.relationshipStats();
    assertTrue(relationshipStatsResult instanceof ImmutableBulkChangeStatistics);
    assertEquals(1, actualWithAssessmentStatsResult.assessmentStats().size());
    assertEquals(3, relationshipStatsResult.addedCount());
    assertEquals(3, relationshipStatsResult.removedCount());
    assertEquals(3, relationshipStatsResult.updatedCount());
  }

  /**
   * Test {@link
   * ImmutableSaveBulkUploadLegalEntityRelationshipResponse#withRelationshipStats(BulkChangeStatistics)}.
   *
   * <p>Method under test: {@link
   * ImmutableSaveBulkUploadLegalEntityRelationshipResponse#withRelationshipStats(BulkChangeStatistics)}
   */
  @Test
  @DisplayName("Test withRelationshipStats(BulkChangeStatistics)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveBulkUploadLegalEntityRelationshipResponse ImmutableSaveBulkUploadLegalEntityRelationshipResponse.withRelationshipStats(BulkChangeStatistics)"
  })
  void testWithRelationshipStats() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse
        immutableSaveBulkUploadLegalEntityRelationshipResponse =
            builderResult
                .relationshipStats(
                    ImmutableBulkChangeStatistics.builder()
                        .addedCount(3)
                        .removedCount(3)
                        .updatedCount(3)
                        .build())
                .build();

    // Act
    ImmutableSaveBulkUploadLegalEntityRelationshipResponse actualWithRelationshipStatsResult =
        immutableSaveBulkUploadLegalEntityRelationshipResponse.withRelationshipStats(
            ImmutableBulkChangeStatistics.builder()
                .addedCount(3)
                .removedCount(3)
                .updatedCount(3)
                .build());

    // Assert
    assertEquals(
        immutableSaveBulkUploadLegalEntityRelationshipResponse, actualWithRelationshipStatsResult);
  }
}
