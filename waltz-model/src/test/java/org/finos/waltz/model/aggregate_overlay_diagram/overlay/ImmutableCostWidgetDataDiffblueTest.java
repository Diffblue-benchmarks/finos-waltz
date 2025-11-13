package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
import java.util.Set;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableCostWidgetData.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableCostWidgetData.Json;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.cost.EntityCostKind;
import org.finos.waltz.model.cost.ImmutableEntityCostKind;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.measurable.ImmutableMeasurable;
import org.finos.waltz.model.measurable.Measurable;
import org.finos.waltz.model.rating.RagRating;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCostWidgetDataDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllApplications(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return build applications Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllApplications(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllApplications(Iterable); when ArrayList(); then return build applications Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllApplications(Iterable)"})
  void testBuilderAddAllApplications_whenArrayList_thenReturnBuildApplicationsEmpty() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act and Assert
    ImmutableCostWidgetData immutableCostWidgetData =
        builderResult.addAllApplications(new ArrayList<>()).build();
    Set<Application> applicationsResult = immutableCostWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, immutableCostWidgetData.cellData());
    assertSame(applicationsResult, immutableCostWidgetData.costKinds());
    assertSame(applicationsResult, immutableCostWidgetData.measurables());
  }

  /**
   * Test Builder {@link Builder#addAllCellData(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllCellData(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllCellData(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllCellData(Iterable)"})
  void testBuilderAddAllCellData_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    Builder actualAddAllCellDataResult = builderResult.addAllCellData(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllCellDataResult);
  }

  /**
   * Test Builder {@link Builder#addAllCostKinds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllCostKinds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllCostKinds(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllCostKinds(Iterable)"})
  void testBuilderAddAllCostKinds_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    Builder actualAddAllCostKindsResult = builderResult.addAllCostKinds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllCostKindsResult);
  }

  /**
   * Test Builder {@link Builder#addAllMeasurables(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllMeasurables(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllMeasurables(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllMeasurables(Iterable)"})
  void testBuilderAddAllMeasurables_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    Builder actualAddAllMeasurablesResult = builderResult.addAllMeasurables(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllMeasurablesResult);
  }

  /**
   * Test Builder {@link Builder#addApplications(Application)} with {@code element}.
   *
   * <ul>
   *   <li>Then builder build applications size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addApplications(Application)}
   */
  @Test
  @DisplayName(
      "Test Builder addApplications(Application) with 'element'; then builder build applications size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addApplications(Application)"})
  void testBuilderAddApplicationsWithElement_thenBuilderBuildApplicationsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act
    Builder actualAddApplicationsResult =
        builderResult.addApplications(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    // Assert
    assertEquals(1, builderResult.build().applications().size());
    assertSame(builderResult, actualAddApplicationsResult);
  }

  /**
   * Test Builder {@link Builder#addApplications(Application[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then builder build applications size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addApplications(Application[])}
   */
  @Test
  @DisplayName(
      "Test Builder addApplications(Application[]) with 'elements'; then builder build applications size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addApplications(Application[])"})
  void testBuilderAddApplicationsWithElements_thenBuilderBuildApplicationsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act
    Builder actualAddApplicationsResult =
        builderResult.addApplications(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    // Assert
    assertEquals(1, builderResult.build().applications().size());
    assertSame(builderResult, actualAddApplicationsResult);
  }

  /**
   * Test Builder {@link Builder#addCellData(CostWidgetDatum)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addCellData(CostWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder addCellData(CostWidgetDatum) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCellData(CostWidgetDatum)"})
  void testBuilderAddCellDataWithElement() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    Builder actualAddCellDataResult =
        builderResult.addCellData(new ImmutableCostWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Test Builder {@link Builder#addCellData(CostWidgetDatum[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addCellData(CostWidgetDatum[])}
   */
  @Test
  @DisplayName("Test Builder addCellData(CostWidgetDatum[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCellData(CostWidgetDatum[])"})
  void testBuilderAddCellDataWithElements() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    Builder actualAddCellDataResult =
        builderResult.addCellData(new ImmutableCostWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Test Builder {@link Builder#addCostKinds(EntityCostKind)} with {@code element}.
   *
   * <ul>
   *   <li>Then builder build costKinds size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addCostKinds(EntityCostKind)}
   */
  @Test
  @DisplayName(
      "Test Builder addCostKinds(EntityCostKind) with 'element'; then builder build costKinds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCostKinds(EntityCostKind)"})
  void testBuilderAddCostKindsWithElement_thenBuilderBuildCostKindsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    Builder actualAddCostKindsResult =
        builderResult.addCostKinds(
            ImmutableEntityCostKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .subjectKind(EntityKind.ALL)
                .build());

    // Assert
    assertEquals(1, builderResult.build().costKinds().size());
    assertSame(builderResult, actualAddCostKindsResult);
  }

  /**
   * Test Builder {@link Builder#addCostKinds(EntityCostKind[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then builder build costKinds size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addCostKinds(EntityCostKind[])}
   */
  @Test
  @DisplayName(
      "Test Builder addCostKinds(EntityCostKind[]) with 'elements'; then builder build costKinds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCostKinds(EntityCostKind[])"})
  void testBuilderAddCostKindsWithElements_thenBuilderBuildCostKindsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    Builder actualAddCostKindsResult =
        builderResult.addCostKinds(
            ImmutableEntityCostKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .subjectKind(EntityKind.ALL)
                .build());

    // Assert
    assertEquals(1, builderResult.build().costKinds().size());
    assertSame(builderResult, actualAddCostKindsResult);
  }

  /**
   * Test Builder {@link Builder#addMeasurables(Measurable)} with {@code element}.
   *
   * <ul>
   *   <li>Then builder build measurables size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addMeasurables(Measurable)}
   */
  @Test
  @DisplayName(
      "Test Builder addMeasurables(Measurable) with 'element'; then builder build measurables size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addMeasurables(Measurable)"})
  void testBuilderAddMeasurablesWithElement_thenBuilderBuildMeasurablesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    Builder actualAddMeasurablesResult =
        builderResult.addMeasurables(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    // Assert
    assertEquals(1, builderResult.build().measurables().size());
    assertSame(builderResult, actualAddMeasurablesResult);
  }

  /**
   * Test Builder {@link Builder#addMeasurables(Measurable[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then builder build measurables size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addMeasurables(Measurable[])}
   */
  @Test
  @DisplayName(
      "Test Builder addMeasurables(Measurable[]) with 'elements'; then builder build measurables size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addMeasurables(Measurable[])"})
  void testBuilderAddMeasurablesWithElements_thenBuilderBuildMeasurablesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    Builder actualAddMeasurablesResult =
        builderResult.addMeasurables(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    // Assert
    assertEquals(1, builderResult.build().measurables().size());
    assertSame(builderResult, actualAddMeasurablesResult);
  }

  /**
   * Test Builder {@link Builder#applications(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return build applications Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#applications(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder applications(Iterable); when ArrayList(); then return build applications Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.applications(Iterable)"})
  void testBuilderApplications_whenArrayList_thenReturnBuildApplicationsEmpty() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act and Assert
    ImmutableCostWidgetData immutableCostWidgetData =
        builderResult.applications(new ArrayList<>()).build();
    Set<Application> applicationsResult = immutableCostWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, immutableCostWidgetData.cellData());
    assertSame(applicationsResult, immutableCostWidgetData.costKinds());
    assertSame(applicationsResult, immutableCostWidgetData.measurables());
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
  @MethodsUnderTest({"ImmutableCostWidgetData Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableCostWidgetData.builder().build().applications().isEmpty());
  }

  /**
   * Test Builder {@link Builder#cellData(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#cellData(Iterable)}
   */
  @Test
  @DisplayName("Test Builder cellData(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.cellData(Iterable)"})
  void testBuilderCellData_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    Builder actualCellDataResult = builderResult.cellData(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualCellDataResult);
  }

  /**
   * Test Builder {@link Builder#costKinds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#costKinds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder costKinds(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.costKinds(Iterable)"})
  void testBuilderCostKinds_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    Builder actualCostKindsResult = builderResult.costKinds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualCostKindsResult);
  }

  /**
   * Test Builder {@link Builder#from(CostWidgetData)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CostWidgetData)}
   */
  @Test
  @DisplayName("Test Builder from(CostWidgetData); when builder build; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CostWidgetData)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    Builder actualFromResult = builderResult.from(ImmutableCostWidgetData.builder().build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#measurables(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#measurables(Iterable)}
   */
  @Test
  @DisplayName("Test Builder measurables(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.measurables(Iterable)"})
  void testBuilderMeasurables_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    Builder actualMeasurablesResult = builderResult.measurables(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualMeasurablesResult);
  }

  /**
   * Test {@link ImmutableCostWidgetData#copyOf(CostWidgetData)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return applications Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetData#copyOf(CostWidgetData)}
   */
  @Test
  @DisplayName("Test copyOf(CostWidgetData); when builder build; then return applications Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCostWidgetData ImmutableCostWidgetData.copyOf(CostWidgetData)"})
  void testCopyOf_whenBuilderBuild_thenReturnApplicationsEmpty() {
    // Arrange
    ImmutableCostWidgetData instance = ImmutableCostWidgetData.builder().build();

    // Act
    ImmutableCostWidgetData actualCopyOfResult = ImmutableCostWidgetData.copyOf(instance);

    // Assert
    Set<Application> applicationsResult = actualCopyOfResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualCopyOfResult.cellData());
    assertSame(applicationsResult, actualCopyOfResult.costKinds());
    assertSame(applicationsResult, actualCopyOfResult.measurables());
  }

  /**
   * Test {@link ImmutableCostWidgetData#equals(Object)}, and {@link
   * ImmutableCostWidgetData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCostWidgetData#equals(Object)}
   *   <li>{@link ImmutableCostWidgetData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCostWidgetData.equals(Object)",
    "int ImmutableCostWidgetData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableCostWidgetData immutableCostWidgetData = ImmutableCostWidgetData.builder().build();
    ImmutableCostWidgetData immutableCostWidgetData2 = ImmutableCostWidgetData.builder().build();

    // Act and Assert
    assertEquals(immutableCostWidgetData, immutableCostWidgetData2);
    assertEquals(immutableCostWidgetData.hashCode(), immutableCostWidgetData2.hashCode());
  }

  /**
   * Test {@link ImmutableCostWidgetData#equals(Object)}, and {@link
   * ImmutableCostWidgetData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCostWidgetData#equals(Object)}
   *   <li>{@link ImmutableCostWidgetData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCostWidgetData.equals(Object)",
    "int ImmutableCostWidgetData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableCostWidgetData immutableCostWidgetData = ImmutableCostWidgetData.builder().build();

    // Act and Assert
    assertEquals(immutableCostWidgetData, immutableCostWidgetData);
    int expectedHashCodeResult = immutableCostWidgetData.hashCode();
    assertEquals(expectedHashCodeResult, immutableCostWidgetData.hashCode());
  }

  /**
   * Test {@link ImmutableCostWidgetData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCostWidgetData.equals(Object)",
    "int ImmutableCostWidgetData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();
    builderResult.addCellData(ImmutableCostWidgetDatum.builder().cellExternalId("42").build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableCostWidgetData.builder().build());
  }

  /**
   * Test {@link ImmutableCostWidgetData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCostWidgetData.equals(Object)",
    "int ImmutableCostWidgetData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    builderResult.addApplications(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableCostWidgetData.builder().build());
  }

  /**
   * Test {@link ImmutableCostWidgetData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCostWidgetData.equals(Object)",
    "int ImmutableCostWidgetData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();
    builderResult.addMeasurables(
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableCostWidgetData.builder().build());
  }

  /**
   * Test {@link ImmutableCostWidgetData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCostWidgetData.equals(Object)",
    "int ImmutableCostWidgetData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();
    builderResult.addCostKinds(
        ImmutableEntityCostKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableCostWidgetData.builder().build());
  }

  /**
   * Test {@link ImmutableCostWidgetData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCostWidgetData.equals(Object)",
    "int ImmutableCostWidgetData.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableCostWidgetData.builder().build(), null);
  }

  /**
   * Test {@link ImmutableCostWidgetData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCostWidgetData.equals(Object)",
    "int ImmutableCostWidgetData.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableCostWidgetData.builder().build(), "Different type to ImmutableCostWidgetData");
  }

  /**
   * Test {@link ImmutableCostWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) CostKinds is {@link HashSet#HashSet()}.
   *   <li>Then return cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) CostKinds is HashSet(); then return cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCostWidgetData ImmutableCostWidgetData.fromJson(Json)"})
  void testFromJson_givenHashSet_whenJsonCostKindsIsHashSet_thenReturnCellDataSizeIsOne() {
    // Arrange
    LinkedHashSet<CostWidgetDatum> cellData = new LinkedHashSet<>();
    ImmutableCostWidgetDatum.Json json = new ImmutableCostWidgetDatum.Json();
    cellData.add(json);

    Json json2 = new Json();
    json2.setCellData(cellData);
    json2.setApplications(new HashSet<>());
    json2.setMeasurables(new HashSet<>());
    json2.setCostKinds(new HashSet<>());

    // Act
    ImmutableCostWidgetData actualFromJsonResult = ImmutableCostWidgetData.fromJson(json2);

    // Assert
    assertEquals(1, actualFromJsonResult.cellData().size());
    assertTrue(actualFromJsonResult.applications().isEmpty());
    Set<MeasurableCostEntry> measurableCostEntrySet = json.measurableCosts;
    assertSame(measurableCostEntrySet, actualFromJsonResult.costKinds());
    assertSame(measurableCostEntrySet, actualFromJsonResult.measurables());
  }

  /**
   * Test {@link ImmutableCostWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Applications is {@code null}.
   *   <li>Then return cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Applications is 'null'; then return cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCostWidgetData ImmutableCostWidgetData.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonApplicationsIsNull_thenReturnCellDataSizeIsOne() {
    // Arrange
    LinkedHashSet<CostWidgetDatum> cellData = new LinkedHashSet<>();
    ImmutableCostWidgetDatum.Json json = new ImmutableCostWidgetDatum.Json();
    cellData.add(json);

    Json json2 = new Json();
    json2.setCellData(cellData);
    json2.setApplications(null);
    json2.setMeasurables(new HashSet<>());
    json2.setCostKinds(new HashSet<>());

    // Act
    ImmutableCostWidgetData actualFromJsonResult = ImmutableCostWidgetData.fromJson(json2);

    // Assert
    assertEquals(1, actualFromJsonResult.cellData().size());
    assertTrue(actualFromJsonResult.applications().isEmpty());
    Set<MeasurableCostEntry> measurableCostEntrySet = json.measurableCosts;
    assertSame(measurableCostEntrySet, actualFromJsonResult.costKinds());
    assertSame(measurableCostEntrySet, actualFromJsonResult.measurables());
  }

  /**
   * Test {@link ImmutableCostWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) CostKinds is {@code null}.
   *   <li>Then return cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) CostKinds is 'null'; then return cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCostWidgetData ImmutableCostWidgetData.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonCostKindsIsNull_thenReturnCellDataSizeIsOne() {
    // Arrange
    LinkedHashSet<CostWidgetDatum> cellData = new LinkedHashSet<>();
    ImmutableCostWidgetDatum.Json json = new ImmutableCostWidgetDatum.Json();
    cellData.add(json);

    Json json2 = new Json();
    json2.setCellData(cellData);
    json2.setApplications(new HashSet<>());
    json2.setMeasurables(new HashSet<>());
    json2.setCostKinds(null);

    // Act
    ImmutableCostWidgetData actualFromJsonResult = ImmutableCostWidgetData.fromJson(json2);

    // Assert
    assertEquals(1, actualFromJsonResult.cellData().size());
    assertTrue(actualFromJsonResult.applications().isEmpty());
    Set<MeasurableCostEntry> measurableCostEntrySet = json.measurableCosts;
    assertSame(measurableCostEntrySet, actualFromJsonResult.costKinds());
    assertSame(measurableCostEntrySet, actualFromJsonResult.measurables());
  }

  /**
   * Test {@link ImmutableCostWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Measurables is {@code null}.
   *   <li>Then return cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Measurables is 'null'; then return cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCostWidgetData ImmutableCostWidgetData.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonMeasurablesIsNull_thenReturnCellDataSizeIsOne() {
    // Arrange
    LinkedHashSet<CostWidgetDatum> cellData = new LinkedHashSet<>();
    ImmutableCostWidgetDatum.Json json = new ImmutableCostWidgetDatum.Json();
    cellData.add(json);

    Json json2 = new Json();
    json2.setCellData(cellData);
    json2.setApplications(new HashSet<>());
    json2.setMeasurables(null);
    json2.setCostKinds(new HashSet<>());

    // Act
    ImmutableCostWidgetData actualFromJsonResult = ImmutableCostWidgetData.fromJson(json2);

    // Assert
    assertEquals(1, actualFromJsonResult.cellData().size());
    assertTrue(actualFromJsonResult.applications().isEmpty());
    Set<MeasurableCostEntry> measurableCostEntrySet = json.measurableCosts;
    assertSame(measurableCostEntrySet, actualFromJsonResult.costKinds());
    assertSame(measurableCostEntrySet, actualFromJsonResult.measurables());
  }

  /**
   * Test {@link ImmutableCostWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return applications size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return applications size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCostWidgetData ImmutableCostWidgetData.fromJson(Json)"})
  void testFromJson_thenReturnApplicationsSizeIsOne() {
    // Arrange
    LinkedHashSet<CostWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(ImmutableCostWidgetDatum.builder().cellExternalId("42").build());

    LinkedHashSet<Application> applications = new LinkedHashSet<>();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    applications.add(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());

    LinkedHashSet<Measurable> measurables = new LinkedHashSet<>();
    measurables.add(
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());

    LinkedHashSet<EntityCostKind> costKinds = new LinkedHashSet<>();
    costKinds.add(
        ImmutableEntityCostKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build());

    Json json = new Json();
    json.setCellData(cellData);
    json.setApplications(applications);
    json.setMeasurables(measurables);
    json.setCostKinds(costKinds);

    // Act
    ImmutableCostWidgetData actualFromJsonResult = ImmutableCostWidgetData.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.applications().size());
    assertEquals(1, actualFromJsonResult.costKinds().size());
    assertEquals(1, actualFromJsonResult.measurables().size());
  }

  /**
   * Test {@link ImmutableCostWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return cellData is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return cellData is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCostWidgetData ImmutableCostWidgetData.fromJson(Json)"})
  void testFromJson_thenReturnCellDataIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<CostWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(ImmutableCostWidgetDatum.builder().cellExternalId("42").build());
    ImmutableCostWidgetDatum.Json json = new ImmutableCostWidgetDatum.Json();
    cellData.add(json);

    Json json2 = new Json();
    json2.setCellData(cellData);
    json2.setApplications(new HashSet<>());
    json2.setMeasurables(new HashSet<>());
    json2.setCostKinds(new HashSet<>());

    // Act
    ImmutableCostWidgetData actualFromJsonResult = ImmutableCostWidgetData.fromJson(json2);

    // Assert
    assertTrue(actualFromJsonResult.applications().isEmpty());
    assertEquals(cellData, actualFromJsonResult.cellData());
    Set<MeasurableCostEntry> measurableCostEntrySet = json.measurableCosts;
    assertSame(measurableCostEntrySet, actualFromJsonResult.costKinds());
    assertSame(measurableCostEntrySet, actualFromJsonResult.measurables());
  }

  /**
   * Test {@link ImmutableCostWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return cellData is {@link Json} (default constructor) {@link Json#measurables}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return cellData is Json (default constructor) measurables")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCostWidgetData ImmutableCostWidgetData.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnCellDataIsJsonMeasurables() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableCostWidgetData actualFromJsonResult = ImmutableCostWidgetData.fromJson(json);

    // Assert
    Set<Measurable> measurableSet = json.measurables;
    assertSame(measurableSet, actualFromJsonResult.cellData());
    assertSame(measurableSet, actualFromJsonResult.costKinds());
    assertSame(measurableSet, actualFromJsonResult.measurables());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCostWidgetData#toString()}
   *   <li>{@link ImmutableCostWidgetData#applications()}
   *   <li>{@link ImmutableCostWidgetData#cellData()}
   *   <li>{@link ImmutableCostWidgetData#costKinds()}
   *   <li>{@link ImmutableCostWidgetData#measurables()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableCostWidgetData.applications()",
    "Set ImmutableCostWidgetData.cellData()",
    "Set ImmutableCostWidgetData.costKinds()",
    "Set ImmutableCostWidgetData.measurables()",
    "String ImmutableCostWidgetData.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableCostWidgetData immutableCostWidgetData = ImmutableCostWidgetData.builder().build();

    // Act
    String actualToStringResult = immutableCostWidgetData.toString();
    Set<Application> actualApplicationsResult = immutableCostWidgetData.applications();
    Set<CostWidgetDatum> actualCellDataResult = immutableCostWidgetData.cellData();
    Set<EntityCostKind> actualCostKindsResult = immutableCostWidgetData.costKinds();
    Set<Measurable> actualMeasurablesResult = immutableCostWidgetData.measurables();

    // Assert
    assertEquals(
        "CostWidgetData{cellData=[], applications=[], measurables=[], costKinds=[]}",
        actualToStringResult);
    assertTrue(actualApplicationsResult.isEmpty());
    assertSame(actualApplicationsResult, actualCellDataResult);
    assertSame(actualApplicationsResult, actualCostKindsResult);
    assertSame(actualApplicationsResult, actualMeasurablesResult);
  }

  /**
   * Test Json {@link Json#applications()}.
   *
   * <p>Method under test: {@link Json#applications()}
   */
  @Test
  @DisplayName("Test Json applications()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.applications()"})
  void testJsonApplications() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().applications());
  }

  /**
   * Test Json {@link Json#cellData()}.
   *
   * <p>Method under test: {@link Json#cellData()}
   */
  @Test
  @DisplayName("Test Json cellData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.cellData()"})
  void testJsonCellData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().cellData());
  }

  /**
   * Test Json {@link Json#costKinds()}.
   *
   * <p>Method under test: {@link Json#costKinds()}
   */
  @Test
  @DisplayName("Test Json costKinds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.costKinds()"})
  void testJsonCostKinds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().costKinds());
  }

  /**
   * Test Json {@link Json#measurables()}.
   *
   * <p>Method under test: {@link Json#measurables()}
   */
  @Test
  @DisplayName("Test Json measurables()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.measurables()"})
  void testJsonMeasurables() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurables());
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
    assertTrue(actualJson.applications.isEmpty());
    assertTrue(actualJson.cellData.isEmpty());
    assertTrue(actualJson.costKinds.isEmpty());
    assertTrue(actualJson.measurables.isEmpty());
  }

  /**
   * Test {@link ImmutableCostWidgetData#withApplications(Application[])} with {@code
   * Application[]}.
   *
   * <p>Method under test: {@link ImmutableCostWidgetData#withApplications(Application[])}
   */
  @Test
  @DisplayName("Test withApplications(Application[]) with 'Application[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCostWidgetData ImmutableCostWidgetData.withApplications(Application[])"
  })
  void testWithApplicationsWithApplication() {
    // Arrange
    ImmutableCostWidgetData immutableCostWidgetData = ImmutableCostWidgetData.builder().build();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act
    ImmutableCostWidgetData actualWithApplicationsResult =
        immutableCostWidgetData.withApplications(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    // Assert
    assertEquals(1, actualWithApplicationsResult.applications().size());
    Set<CostWidgetDatum> cellDataResult = actualWithApplicationsResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualWithApplicationsResult.costKinds());
    assertSame(cellDataResult, actualWithApplicationsResult.measurables());
  }

  /**
   * Test {@link ImmutableCostWidgetData#withCellData(CostWidgetDatum[])} with {@code
   * CostWidgetDatum[]}.
   *
   * <p>Method under test: {@link ImmutableCostWidgetData#withCellData(CostWidgetDatum[])}
   */
  @Test
  @DisplayName("Test withCellData(CostWidgetDatum[]) with 'CostWidgetDatum[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCostWidgetData ImmutableCostWidgetData.withCellData(CostWidgetDatum[])"
  })
  void testWithCellDataWithCostWidgetDatum() {
    // Arrange
    ImmutableCostWidgetData immutableCostWidgetData = ImmutableCostWidgetData.builder().build();

    // Act
    ImmutableCostWidgetData actualWithCellDataResult =
        immutableCostWidgetData.withCellData(
            ImmutableCostWidgetDatum.builder().cellExternalId("42").build());

    // Assert
    assertEquals(1, actualWithCellDataResult.cellData().size());
    Set<Application> applicationsResult = actualWithCellDataResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualWithCellDataResult.costKinds());
    assertSame(applicationsResult, actualWithCellDataResult.measurables());
  }

  /**
   * Test {@link ImmutableCostWidgetData#withCostKinds(EntityCostKind[])} with {@code
   * EntityCostKind[]}.
   *
   * <p>Method under test: {@link ImmutableCostWidgetData#withCostKinds(EntityCostKind[])}
   */
  @Test
  @DisplayName("Test withCostKinds(EntityCostKind[]) with 'EntityCostKind[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCostWidgetData ImmutableCostWidgetData.withCostKinds(EntityCostKind[])"
  })
  void testWithCostKindsWithEntityCostKind() {
    // Arrange
    ImmutableCostWidgetData immutableCostWidgetData = ImmutableCostWidgetData.builder().build();

    // Act
    ImmutableCostWidgetData actualWithCostKindsResult =
        immutableCostWidgetData.withCostKinds(
            ImmutableEntityCostKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .subjectKind(EntityKind.ALL)
                .build());

    // Assert
    assertEquals(1, actualWithCostKindsResult.costKinds().size());
    Set<Application> applicationsResult = actualWithCostKindsResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualWithCostKindsResult.cellData());
    assertSame(applicationsResult, actualWithCostKindsResult.measurables());
  }

  /**
   * Test {@link ImmutableCostWidgetData#withMeasurables(Measurable[])} with {@code Measurable[]}.
   *
   * <p>Method under test: {@link ImmutableCostWidgetData#withMeasurables(Measurable[])}
   */
  @Test
  @DisplayName("Test withMeasurables(Measurable[]) with 'Measurable[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCostWidgetData ImmutableCostWidgetData.withMeasurables(Measurable[])"
  })
  void testWithMeasurablesWithMeasurable() {
    // Arrange
    ImmutableCostWidgetData immutableCostWidgetData = ImmutableCostWidgetData.builder().build();

    // Act
    ImmutableCostWidgetData actualWithMeasurablesResult =
        immutableCostWidgetData.withMeasurables(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    // Assert
    assertEquals(1, actualWithMeasurablesResult.measurables().size());
    Set<Application> applicationsResult = actualWithMeasurablesResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualWithMeasurablesResult.cellData());
    assertSame(applicationsResult, actualWithMeasurablesResult.costKinds());
  }
}
