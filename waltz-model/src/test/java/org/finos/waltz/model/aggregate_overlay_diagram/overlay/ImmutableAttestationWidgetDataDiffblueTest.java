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
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAttestationWidgetData.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAttestationWidgetData.Json;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.rating.RagRating;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttestationWidgetDataDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllApplications(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllApplications(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllApplications(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllApplications(Iterable)"})
  void testBuilderAddAllApplications_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetData.builder();

    // Act
    Builder actualAddAllApplicationsResult = builderResult.addAllApplications(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllApplicationsResult);
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
    Builder builderResult = ImmutableAttestationWidgetData.builder();

    // Act
    Builder actualAddAllCellDataResult = builderResult.addAllCellData(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllCellDataResult);
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
    Builder builderResult = ImmutableAttestationWidgetData.builder();

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
    Builder builderResult = ImmutableAttestationWidgetData.builder();

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
   * Test Builder {@link Builder#addCellData(AttestationWidgetDatum)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableAttestationWidgetDatum.Json} (default constructor).
   *   <li>Then builder build cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addCellData(AttestationWidgetDatum)}
   */
  @Test
  @DisplayName(
      "Test Builder addCellData(AttestationWidgetDatum) with 'element'; when Json (default constructor); then builder build cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCellData(AttestationWidgetDatum)"})
  void testBuilderAddCellDataWithElement_whenJson_thenBuilderBuildCellDataSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetData.builder();

    // Act
    Builder actualAddCellDataResult =
        builderResult.addCellData(new ImmutableAttestationWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Test Builder {@link Builder#addCellData(AttestationWidgetDatum[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableAttestationWidgetDatum.Json} (default constructor).
   *   <li>Then builder build cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addCellData(AttestationWidgetDatum[])}
   */
  @Test
  @DisplayName(
      "Test Builder addCellData(AttestationWidgetDatum[]) with 'elements'; when Json (default constructor); then builder build cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCellData(AttestationWidgetDatum[])"})
  void testBuilderAddCellDataWithElements_whenJson_thenBuilderBuildCellDataSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetData.builder();

    // Act
    Builder actualAddCellDataResult =
        builderResult.addCellData(new ImmutableAttestationWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Test Builder {@link Builder#applications(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#applications(Iterable)}
   */
  @Test
  @DisplayName("Test Builder applications(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.applications(Iterable)"})
  void testBuilderApplications_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetData.builder();

    // Act
    Builder actualApplicationsResult = builderResult.applications(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualApplicationsResult);
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
  @MethodsUnderTest({"ImmutableAttestationWidgetData Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableAttestationWidgetData.builder().build().applications().isEmpty());
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
    Builder builderResult = ImmutableAttestationWidgetData.builder();

    // Act
    Builder actualCellDataResult = builderResult.cellData(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualCellDataResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationWidgetData)}.
   *
   * <ul>
   *   <li>Given builder cellExternalId {@code 42} build.
   *   <li>Then return build is builder build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AttestationWidgetData)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AttestationWidgetData); given builder cellExternalId '42' build; then return build is builder build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AttestationWidgetData)"})
  void testBuilderFrom_givenBuilderCellExternalId42Build_thenReturnBuildIsBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetData.builder();

    Builder builderResult2 = ImmutableAttestationWidgetData.builder();
    builderResult2.addCellData(
        ImmutableAttestationWidgetDatum.builder().cellExternalId("42").build());
    ImmutableAttestationWidgetData instance = builderResult2.build();

    // Act and Assert
    ImmutableAttestationWidgetData actualImmutableAttestationWidgetData =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableAttestationWidgetData);
    ImmutableAttestationWidgetData actualImmutableAttestationWidgetData2 = builderResult.build();
    assertEquals(instance, actualImmutableAttestationWidgetData2);
  }

  /**
   * Test Builder {@link Builder#from(AttestationWidgetData)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AttestationWidgetData)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationWidgetData); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AttestationWidgetData)"})
  void testBuilderFrom_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetData.builder();

    Builder builderResult2 = ImmutableAttestationWidgetData.builder();

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
    builderResult2.addApplications(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    builderResult2.addCellData(
        ImmutableAttestationWidgetDatum.builder().cellExternalId("42").build());
    ImmutableAttestationWidgetData instance = builderResult2.build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAttestationWidgetData actualImmutableAttestationWidgetData = builderResult.build();
    assertEquals(instance, actualImmutableAttestationWidgetData);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationWidgetData)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return build is builder build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AttestationWidgetData)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AttestationWidgetData); when builder build; then return build is builder build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AttestationWidgetData)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuildIsBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetData.builder();
    ImmutableAttestationWidgetData instance = ImmutableAttestationWidgetData.builder().build();

    // Act and Assert
    ImmutableAttestationWidgetData actualImmutableAttestationWidgetData =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableAttestationWidgetData);
    ImmutableAttestationWidgetData actualImmutableAttestationWidgetData2 = builderResult.build();
    assertEquals(instance, actualImmutableAttestationWidgetData2);
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#copyOf(AttestationWidgetData)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return applications Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetData#copyOf(AttestationWidgetData)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AttestationWidgetData); when builder build; then return applications Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationWidgetData ImmutableAttestationWidgetData.copyOf(AttestationWidgetData)"
  })
  void testCopyOf_whenBuilderBuild_thenReturnApplicationsEmpty() {
    // Arrange
    ImmutableAttestationWidgetData instance = ImmutableAttestationWidgetData.builder().build();

    // Act
    ImmutableAttestationWidgetData actualCopyOfResult =
        ImmutableAttestationWidgetData.copyOf(instance);

    // Assert
    Set<Application> applicationsResult = actualCopyOfResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualCopyOfResult.cellData());
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#equals(Object)}, and {@link
   * ImmutableAttestationWidgetData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationWidgetData#equals(Object)}
   *   <li>{@link ImmutableAttestationWidgetData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationWidgetData.equals(Object)",
    "int ImmutableAttestationWidgetData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAttestationWidgetData immutableAttestationWidgetData =
        ImmutableAttestationWidgetData.builder().build();
    ImmutableAttestationWidgetData immutableAttestationWidgetData2 =
        ImmutableAttestationWidgetData.builder().build();

    // Act and Assert
    assertEquals(immutableAttestationWidgetData, immutableAttestationWidgetData2);
    assertEquals(
        immutableAttestationWidgetData.hashCode(), immutableAttestationWidgetData2.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#equals(Object)}, and {@link
   * ImmutableAttestationWidgetData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationWidgetData#equals(Object)}
   *   <li>{@link ImmutableAttestationWidgetData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationWidgetData.equals(Object)",
    "int ImmutableAttestationWidgetData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAttestationWidgetData immutableAttestationWidgetData =
        ImmutableAttestationWidgetData.builder().build();

    // Act and Assert
    assertEquals(immutableAttestationWidgetData, immutableAttestationWidgetData);
    int expectedHashCodeResult = immutableAttestationWidgetData.hashCode();
    assertEquals(expectedHashCodeResult, immutableAttestationWidgetData.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationWidgetData.equals(Object)",
    "int ImmutableAttestationWidgetData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetData.builder();
    builderResult.addCellData(
        ImmutableAttestationWidgetDatum.builder().cellExternalId("42").build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableAttestationWidgetData.builder().build());
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationWidgetData.equals(Object)",
    "int ImmutableAttestationWidgetData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetData.builder();

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
    assertNotEquals(builderResult.build(), ImmutableAttestationWidgetData.builder().build());
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationWidgetData.equals(Object)",
    "int ImmutableAttestationWidgetData.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableAttestationWidgetData.builder().build(), null);
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationWidgetData.equals(Object)",
    "int ImmutableAttestationWidgetData.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAttestationWidgetData.builder().build(),
        "Different type to ImmutableAttestationWidgetData");
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>Then return cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given HashSet(); then return cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationWidgetData ImmutableAttestationWidgetData.fromJson(Json)"
  })
  void testFromJson_givenHashSet_thenReturnCellDataSizeIsOne() {
    // Arrange
    LinkedHashSet<AttestationWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableAttestationWidgetDatum.Json());

    Json json = new Json();
    json.setCellData(cellData);
    json.setApplications(new HashSet<>());

    // Act
    ImmutableAttestationWidgetData actualFromJsonResult =
        ImmutableAttestationWidgetData.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.cellData().size());
    assertTrue(actualFromJsonResult.applications().isEmpty());
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Applications is {@code null}.
   *   <li>Then return cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Applications is 'null'; then return cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationWidgetData ImmutableAttestationWidgetData.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonApplicationsIsNull_thenReturnCellDataSizeIsOne() {
    // Arrange
    LinkedHashSet<AttestationWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableAttestationWidgetDatum.Json());

    Json json = new Json();
    json.setCellData(cellData);
    json.setApplications(null);

    // Act
    ImmutableAttestationWidgetData actualFromJsonResult =
        ImmutableAttestationWidgetData.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.cellData().size());
    assertTrue(actualFromJsonResult.applications().isEmpty());
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) CellData is {@code null}.
   *   <li>Then return cellData is applications.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) CellData is 'null'; then return cellData is applications")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationWidgetData ImmutableAttestationWidgetData.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonCellDataIsNull_thenReturnCellDataIsApplications() {
    // Arrange
    Json json = new Json();
    json.setCellData(null);
    json.setApplications(new HashSet<>());

    // Act
    ImmutableAttestationWidgetData actualFromJsonResult =
        ImmutableAttestationWidgetData.fromJson(json);

    // Assert
    Set<Application> applicationsResult = actualFromJsonResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualFromJsonResult.cellData());
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return applications size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return applications size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationWidgetData ImmutableAttestationWidgetData.fromJson(Json)"
  })
  void testFromJson_thenReturnApplicationsSizeIsOne() {
    // Arrange
    LinkedHashSet<AttestationWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(ImmutableAttestationWidgetDatum.builder().cellExternalId("42").build());

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

    Json json = new Json();
    json.setCellData(cellData);
    json.setApplications(applications);

    // Act
    ImmutableAttestationWidgetData actualFromJsonResult =
        ImmutableAttestationWidgetData.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.applications().size());
    assertEquals(1, actualFromJsonResult.cellData().size());
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return cellData is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return cellData is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationWidgetData ImmutableAttestationWidgetData.fromJson(Json)"
  })
  void testFromJson_thenReturnCellDataIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<AttestationWidgetDatum> cellData = new LinkedHashSet<>();
    cellData.add(ImmutableAttestationWidgetDatum.builder().cellExternalId("42").build());
    cellData.add(new ImmutableAttestationWidgetDatum.Json());

    Json json = new Json();
    json.setCellData(cellData);
    json.setApplications(new HashSet<>());

    // Act
    ImmutableAttestationWidgetData actualFromJsonResult =
        ImmutableAttestationWidgetData.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.applications().isEmpty());
    assertEquals(cellData, actualFromJsonResult.cellData());
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return cellData is {@link Json} (default constructor) {@link Json#cellData}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return cellData is Json (default constructor) cellData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationWidgetData ImmutableAttestationWidgetData.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnCellDataIsJsonCellData() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableAttestationWidgetData actualFromJsonResult =
        ImmutableAttestationWidgetData.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.applications().isEmpty());
    Set<AttestationWidgetDatum> expectedCellDataResult = json.cellData;
    assertSame(expectedCellDataResult, actualFromJsonResult.cellData());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationWidgetData#toString()}
   *   <li>{@link ImmutableAttestationWidgetData#applications()}
   *   <li>{@link ImmutableAttestationWidgetData#cellData()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableAttestationWidgetData.applications()",
    "Set ImmutableAttestationWidgetData.cellData()",
    "String ImmutableAttestationWidgetData.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAttestationWidgetData immutableAttestationWidgetData =
        ImmutableAttestationWidgetData.builder().build();

    // Act
    String actualToStringResult = immutableAttestationWidgetData.toString();
    Set<Application> actualApplicationsResult = immutableAttestationWidgetData.applications();
    Set<AttestationWidgetDatum> actualCellDataResult = immutableAttestationWidgetData.cellData();

    // Assert
    assertEquals("AttestationWidgetData{cellData=[], applications=[]}", actualToStringResult);
    assertTrue(actualApplicationsResult.isEmpty());
    assertSame(actualApplicationsResult, actualCellDataResult);
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
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#withApplications(Application[])} with {@code
   * Application[]}.
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetData#withApplications(Application[])}
   */
  @Test
  @DisplayName("Test withApplications(Application[]) with 'Application[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationWidgetData ImmutableAttestationWidgetData.withApplications(Application[])"
  })
  void testWithApplicationsWithApplication() {
    // Arrange
    ImmutableAttestationWidgetData immutableAttestationWidgetData =
        ImmutableAttestationWidgetData.builder().build();

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
    ImmutableAttestationWidgetData actualWithApplicationsResult =
        immutableAttestationWidgetData.withApplications(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    // Assert
    assertEquals(1, actualWithApplicationsResult.applications().size());
    assertTrue(actualWithApplicationsResult.cellData().isEmpty());
  }

  /**
   * Test {@link ImmutableAttestationWidgetData#withCellData(AttestationWidgetDatum[])} with {@code
   * AttestationWidgetDatum[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAttestationWidgetData#withCellData(AttestationWidgetDatum[])}
   */
  @Test
  @DisplayName("Test withCellData(AttestationWidgetDatum[]) with 'AttestationWidgetDatum[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationWidgetData ImmutableAttestationWidgetData.withCellData(AttestationWidgetDatum[])"
  })
  void testWithCellDataWithAttestationWidgetDatum() {
    // Arrange
    ImmutableAttestationWidgetData immutableAttestationWidgetData =
        ImmutableAttestationWidgetData.builder().build();

    // Act
    ImmutableAttestationWidgetData actualWithCellDataResult =
        immutableAttestationWidgetData.withCellData(
            ImmutableAttestationWidgetDatum.builder().cellExternalId("42").build());

    // Assert
    assertEquals(1, actualWithCellDataResult.cellData().size());
    assertTrue(actualWithCellDataResult.applications().isEmpty());
  }
}
