package org.finos.waltz.model.scenario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityLifecycleStatusProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableEnumValue;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.PositionProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.measurable.ImmutableMeasurable;
import org.finos.waltz.model.rating.RagRating;
import org.finos.waltz.model.scenario.ImmutableScenario.Builder;
import org.finos.waltz.model.scenario.ImmutableScenario.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableScenarioDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#entityLifecycleStatus(EntityLifecycleStatus)}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableScenario Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.entityLifecycleStatus(EntityLifecycleStatus)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)"
  })
  void testBuilderBuild() {
    // Arrange
    LocalDate effectiveDate = LocalDate.of(1970, 1, 1);

    // Act
    Builder actualIdResult =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(effectiveDate)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L);
    Optional<Long> id = Optional.of(42L);
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    ImmutableScenario actualImmutableScenario =
        actualIdResult
            .id(id)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Assert
    LocalDate effectiveDateResult = actualImmutableScenario.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("2020-03-01", actualImmutableScenario.lastUpdatedBy());
    assertEquals("Name", actualImmutableScenario.name());
    assertEquals(
        "The characteristics of someone or something", actualImmutableScenario.description());
    assertEquals(0, actualImmutableScenario.position());
    assertEquals(1L, actualImmutableScenario.roadmapId());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualImmutableScenario.entityLifecycleStatus());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualImmutableScenario.releaseStatus());
    assertEquals(ScenarioType.TARGET, actualImmutableScenario.scenarioType());
    assertSame(lastUpdatedAt, actualImmutableScenario.lastUpdatedAt());
    assertSame(effectiveDate, effectiveDateResult);
  }

  /**
   * Test Builder {@link Builder#effectiveDate(LocalDate)}.
   *
   * <ul>
   *   <li>When {@link LocalDate} with {@code 1970} and one and one.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#effectiveDate(LocalDate)}
   */
  @Test
  @DisplayName(
      "Test Builder effectiveDate(LocalDate); when LocalDate with '1970' and one and one; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.effectiveDate(LocalDate)"})
  void testBuilderEffectiveDate_whenLocalDateWith1970AndOneAndOne_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();

    // Act
    Builder actualEffectiveDateResult = builderResult.effectiveDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertSame(builderResult, actualEffectiveDateResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();
    ImmutableScenario instance =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act and Assert
    ImmutableScenario actualImmutableScenario =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableScenario);
    ImmutableScenario actualImmutableScenario2 = builderResult.build();
    assertEquals(instance, actualImmutableScenario2);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider2() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code
   * EntityLifecycleStatusProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (EntityLifecycleStatusProvider)
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code
   * EntityLifecycleStatusProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider2() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();
    ImmutableScenario instance =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act and Assert
    ImmutableScenario actualImmutableScenario =
        builderResult.from((EntityLifecycleStatusProvider) instance).build();
    assertEquals(instance, actualImmutableScenario);
    ImmutableScenario actualImmutableScenario2 = builderResult.build();
    assertEquals(instance, actualImmutableScenario2);
  }

  /**
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code
   * EntityLifecycleStatusProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider3() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (EntityLifecycleStatusProvider)
                ImmutableAppGroupEntry.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code
   * EntityLifecycleStatusProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider4() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();

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
    Builder actualFromResult =
        builderResult.from(
            (EntityLifecycleStatusProvider)
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code
   * EntityLifecycleStatusProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider5() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (EntityLifecycleStatusProvider)
                ImmutableAppGroupEntry.builder()
                    .description(null)
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();
    ImmutableScenario instance =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act and Assert
    ImmutableScenario actualImmutableScenario = builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableScenario);
    ImmutableScenario actualImmutableScenario2 = builderResult.build();
    assertEquals(instance, actualImmutableScenario2);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();
    ImmutableScenario instance =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act and Assert
    ImmutableScenario actualImmutableScenario =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableScenario);
    ImmutableScenario actualImmutableScenario2 = builderResult.build();
    assertEquals(instance, actualImmutableScenario2);
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider2() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedBy()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider3() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();
    ImmutableScenario instance =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act and Assert
    ImmutableScenario actualImmutableScenario = builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableScenario);
    ImmutableScenario actualImmutableScenario2 = builderResult.build();
    assertEquals(instance, actualImmutableScenario2);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider2() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();
    ImmutableScenario instance =
        ImmutableScenario.builder()
            .description(null)
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act and Assert
    ImmutableScenario actualImmutableScenario = builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableScenario);
    ImmutableScenario actualImmutableScenario2 = builderResult.build();
    assertEquals(instance, actualImmutableScenario2);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   *
   * <p>Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (PositionProvider)
                ImmutableEnumValue.builder()
                    .description("The characteristics of someone or something")
                    .icon("Icon")
                    .iconColor("Icon Color")
                    .key("Key")
                    .name("Name")
                    .type("Type")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   *
   * <p>Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider2() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();
    ImmutableScenario instance =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act and Assert
    ImmutableScenario actualImmutableScenario =
        builderResult.from((PositionProvider) instance).build();
    assertEquals(instance, actualImmutableScenario);
    ImmutableScenario actualImmutableScenario2 = builderResult.build();
    assertEquals(instance, actualImmutableScenario2);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   *
   * <p>Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider3() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (PositionProvider)
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
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   *
   * <p>Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider4() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (PositionProvider)
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description(null)
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
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Scenario)} with {@code Scenario}.
   *
   * <p>Method under test: {@link Builder#from(Scenario)}
   */
  @Test
  @DisplayName("Test Builder from(Scenario) with 'Scenario'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Scenario)"})
  void testBuilderFromWithScenario() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();
    ImmutableScenario instance =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableScenario actualImmutableScenario = builderResult.build();
    assertEquals(instance, actualImmutableScenario);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Scenario)} with {@code Scenario}.
   *
   * <p>Method under test: {@link Builder#from(Scenario)}
   */
  @Test
  @DisplayName("Test Builder from(Scenario) with 'Scenario'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Scenario)"})
  void testBuilderFromWithScenario2() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();
    ImmutableScenario instance =
        ImmutableScenario.builder()
            .description(null)
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableScenario actualImmutableScenario = builderResult.build();
    assertEquals(instance, actualImmutableScenario);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#lastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>When {@code 2020-03-01}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#lastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test Builder lastUpdatedBy(String); when '2020-03-01'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lastUpdatedBy(String)"})
  void testBuilderLastUpdatedBy_when20200301_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#position(int)}.
   *
   * <p>Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPosition() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();

    // Act
    Builder actualPositionResult = builderResult.position(1);

    // Assert
    assertSame(builderResult, actualPositionResult);
  }

  /**
   * Test Builder {@link Builder#releaseStatus(ReleaseLifecycleStatus)}.
   *
   * <p>Method under test: {@link Builder#releaseStatus(ReleaseLifecycleStatus)}
   */
  @Test
  @DisplayName("Test Builder releaseStatus(ReleaseLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.releaseStatus(ReleaseLifecycleStatus)"})
  void testBuilderReleaseStatus() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();

    // Act
    Builder actualReleaseStatusResult = builderResult.releaseStatus(ReleaseLifecycleStatus.DRAFT);

    // Assert
    assertSame(builderResult, actualReleaseStatusResult);
  }

  /**
   * Test Builder {@link Builder#roadmapId(long)}.
   *
   * <p>Method under test: {@link Builder#roadmapId(long)}
   */
  @Test
  @DisplayName("Test Builder roadmapId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.roadmapId(long)"})
  void testBuilderRoadmapId() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();

    // Act
    Builder actualRoadmapIdResult = builderResult.roadmapId(1L);

    // Assert
    assertSame(builderResult, actualRoadmapIdResult);
  }

  /**
   * Test Builder {@link Builder#scenarioType(ScenarioType)}.
   *
   * <p>Method under test: {@link Builder#scenarioType(ScenarioType)}
   */
  @Test
  @DisplayName("Test Builder scenarioType(ScenarioType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.scenarioType(ScenarioType)"})
  void testBuilderScenarioType() {
    // Arrange
    Builder builderResult = ImmutableScenario.builder();

    // Act
    Builder actualScenarioTypeResult = builderResult.scenarioType(ScenarioType.TARGET);

    // Assert
    assertSame(builderResult, actualScenarioTypeResult);
  }

  /**
   * Test {@link ImmutableScenario#copyOf(Scenario)}.
   *
   * <ul>
   *   <li>Then return effectiveDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenario#copyOf(Scenario)}
   */
  @Test
  @DisplayName("Test copyOf(Scenario); then return effectiveDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenario ImmutableScenario.copyOf(Scenario)"})
  void testCopyOf_thenReturnEffectiveDateToStringIs19700101() {
    // Arrange
    LocalDate effectiveDate = LocalDate.of(1970, 1, 1);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableScenario instance =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(effectiveDate)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act
    ImmutableScenario actualCopyOfResult = ImmutableScenario.copyOf(instance);

    // Assert
    LocalDate effectiveDateResult = actualCopyOfResult.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(0, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.roadmapId());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualCopyOfResult.releaseStatus());
    assertEquals(ScenarioType.TARGET, actualCopyOfResult.scenarioType());
    assertSame(ofResult, actualCopyOfResult.lastUpdatedAt().toLocalDate());
    assertSame(effectiveDate, effectiveDateResult);
  }

  /**
   * Test {@link ImmutableScenario#entityLifecycleStatus()}.
   *
   * <p>Method under test: {@link ImmutableScenario#entityLifecycleStatus()}
   */
  @Test
  @DisplayName("Test entityLifecycleStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus ImmutableScenario.entityLifecycleStatus()"})
  void testEntityLifecycleStatus() {
    // Arrange, Act and Assert
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build()
            .entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableScenario#equals(Object)}, and {@link ImmutableScenario#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableScenario#equals(Object)}
   *   <li>{@link ImmutableScenario#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenario.equals(Object)",
    "int ImmutableScenario.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();
    ImmutableScenario immutableScenario2 =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act and Assert
    assertEquals(immutableScenario, immutableScenario2);
    assertEquals(immutableScenario.hashCode(), immutableScenario2.hashCode());
  }

  /**
   * Test {@link ImmutableScenario#equals(Object)}, and {@link ImmutableScenario#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableScenario#equals(Object)}
   *   <li>{@link ImmutableScenario#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenario.equals(Object)",
    "int ImmutableScenario.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act and Assert
    assertEquals(immutableScenario, immutableScenario);
    int expectedHashCodeResult = immutableScenario.hashCode();
    assertEquals(expectedHashCodeResult, immutableScenario.hashCode());
  }

  /**
   * Test {@link ImmutableScenario#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenario#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenario.equals(Object)",
    "int ImmutableScenario.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.now())
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableScenario,
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build());
  }

  /**
   * Test {@link ImmutableScenario#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenario#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenario.equals(Object)",
    "int ImmutableScenario.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableScenario,
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build());
  }

  /**
   * Test {@link ImmutableScenario#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenario#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenario.equals(Object)",
    "int ImmutableScenario.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(2L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableScenario,
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build());
  }

  /**
   * Test {@link ImmutableScenario#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenario#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenario.equals(Object)",
    "int ImmutableScenario.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableScenario,
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build());
  }

  /**
   * Test {@link ImmutableScenario#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenario#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenario.equals(Object)",
    "int ImmutableScenario.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableScenario,
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build());
  }

  /**
   * Test {@link ImmutableScenario#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenario#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenario.equals(Object)",
    "int ImmutableScenario.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("2020-03-01")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableScenario,
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build());
  }

  /**
   * Test {@link ImmutableScenario#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenario#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenario.equals(Object)",
    "int ImmutableScenario.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.ACTIVE)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableScenario,
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build());
  }

  /**
   * Test {@link ImmutableScenario#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenario#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenario.equals(Object)",
    "int ImmutableScenario.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(2L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableScenario,
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build());
  }

  /**
   * Test {@link ImmutableScenario#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenario#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenario.equals(Object)",
    "int ImmutableScenario.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.CURRENT)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableScenario,
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build());
  }

  /**
   * Test {@link ImmutableScenario#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenario#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenario.equals(Object)",
    "int ImmutableScenario.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableScenario#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenario#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenario.equals(Object)",
    "int ImmutableScenario.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build(),
        "Different type to ImmutableScenario");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableScenario#description()}
   *   <li>{@link ImmutableScenario#effectiveDate()}
   *   <li>{@link ImmutableScenario#lastUpdatedBy()}
   *   <li>{@link ImmutableScenario#name()}
   *   <li>{@link ImmutableScenario#releaseStatus()}
   *   <li>{@link ImmutableScenario#roadmapId()}
   *   <li>{@link ImmutableScenario#scenarioType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableScenario.description()",
    "LocalDate ImmutableScenario.effectiveDate()",
    "String ImmutableScenario.lastUpdatedBy()",
    "String ImmutableScenario.name()",
    "ReleaseLifecycleStatus ImmutableScenario.releaseStatus()",
    "long ImmutableScenario.roadmapId()",
    "ScenarioType ImmutableScenario.scenarioType()"
  })
  void testGettersAndSetters() {
    // Arrange
    LocalDate effectiveDate = LocalDate.of(1970, 1, 1);
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(effectiveDate)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act
    String actualDescriptionResult = immutableScenario.description();
    LocalDate actualEffectiveDateResult = immutableScenario.effectiveDate();
    String actualLastUpdatedByResult = immutableScenario.lastUpdatedBy();
    String actualNameResult = immutableScenario.name();
    ReleaseLifecycleStatus actualReleaseStatusResult = immutableScenario.releaseStatus();
    long actualRoadmapIdResult = immutableScenario.roadmapId();

    // Assert
    assertEquals("1970-01-01", actualEffectiveDateResult.toString());
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, actualRoadmapIdResult);
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualReleaseStatusResult);
    assertEquals(ScenarioType.TARGET, immutableScenario.scenarioType());
    assertSame(effectiveDate, actualEffectiveDateResult);
  }

  /**
   * Test {@link ImmutableScenario#id()}.
   *
   * <p>Method under test: {@link ImmutableScenario#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableScenario.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
  }

  /**
   * Test Json {@link Json#effectiveDate()}.
   *
   * <p>Method under test: {@link Json#effectiveDate()}
   */
  @Test
  @DisplayName("Test Json effectiveDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDate Json.effectiveDate()"})
  void testJsonEffectiveDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().effectiveDate());
  }

  /**
   * Test Json {@link Json#entityLifecycleStatus()}.
   *
   * <p>Method under test: {@link Json#entityLifecycleStatus()}
   */
  @Test
  @DisplayName("Test Json entityLifecycleStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus Json.entityLifecycleStatus()"})
  void testJsonEntityLifecycleStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityLifecycleStatus());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
  }

  /**
   * Test Json {@link Json#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdatedAt());
  }

  /**
   * Test Json {@link Json#lastUpdatedBy()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedBy()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.lastUpdatedBy()"})
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdatedBy());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
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
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.effectiveDate);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.entityLifecycleStatus);
    assertNull(actualJson.releaseStatus);
    assertNull(actualJson.scenarioType);
    assertEquals(0, actualJson.position);
    assertEquals(0L, actualJson.roadmapId);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.positionIsSet);
    assertFalse(actualJson.roadmapIdIsSet);
  }

  /**
   * Test Json {@link Json#position()}.
   *
   * <p>Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().position());
  }

  /**
   * Test Json {@link Json#releaseStatus()}.
   *
   * <p>Method under test: {@link Json#releaseStatus()}
   */
  @Test
  @DisplayName("Test Json releaseStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReleaseLifecycleStatus Json.releaseStatus()"})
  void testJsonReleaseStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().releaseStatus());
  }

  /**
   * Test Json {@link Json#roadmapId()}.
   *
   * <p>Method under test: {@link Json#roadmapId()}
   */
  @Test
  @DisplayName("Test Json roadmapId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.roadmapId()"})
  void testJsonRoadmapId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().roadmapId());
  }

  /**
   * Test Json {@link Json#scenarioType()}.
   *
   * <p>Method under test: {@link Json#scenarioType()}
   */
  @Test
  @DisplayName("Test Json scenarioType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ScenarioType Json.scenarioType()"})
  void testJsonScenarioType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().scenarioType());
  }

  /**
   * Test Json {@link Json#setPosition(int)}.
   *
   * <p>Method under test: {@link Json#setPosition(int)}
   */
  @Test
  @DisplayName("Test Json setPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setPosition(int)"})
  void testJsonSetPosition() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Test Json {@link Json#setRoadmapId(long)}.
   *
   * <p>Method under test: {@link Json#setRoadmapId(long)}
   */
  @Test
  @DisplayName("Test Json setRoadmapId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setRoadmapId(long)"})
  void testJsonSetRoadmapId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRoadmapId(1L);

    // Assert
    assertEquals(1L, json.roadmapId);
    assertTrue(json.roadmapIdIsSet);
  }

  /**
   * Test {@link ImmutableScenario#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableScenario#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableScenario.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build()
            .lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableScenario#position()}.
   *
   * <p>Method under test: {@link ImmutableScenario#position()}
   */
  @Test
  @DisplayName("Test position()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ImmutableScenario.position()"})
  void testPosition() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build()
            .position());
  }

  /**
   * Test {@link ImmutableScenario#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableScenario#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenario ImmutableScenario.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act
    ImmutableScenario actualWithDescriptionResult = immutableScenario.withDescription("42");

    // Assert
    assertEquals(immutableScenario, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableScenario#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableScenario#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenario ImmutableScenario.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("42")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act
    ImmutableScenario actualWithDescriptionResult = immutableScenario.withDescription("42");

    // Assert
    assertSame(immutableScenario, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableScenario#withEffectiveDate(LocalDate)}.
   *
   * <p>Method under test: {@link ImmutableScenario#withEffectiveDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withEffectiveDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenario ImmutableScenario.withEffectiveDate(LocalDate)"})
  void testWithEffectiveDate() {
    // Arrange
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act
    ImmutableScenario actualWithEffectiveDateResult =
        immutableScenario.withEffectiveDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableScenario, actualWithEffectiveDateResult);
  }

  /**
   * Test {@link ImmutableScenario#withEntityLifecycleStatus(EntityLifecycleStatus)}.
   *
   * <p>Method under test: {@link
   * ImmutableScenario#withEntityLifecycleStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withEntityLifecycleStatus(EntityLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableScenario ImmutableScenario.withEntityLifecycleStatus(EntityLifecycleStatus)"
  })
  void testWithEntityLifecycleStatus() {
    // Arrange
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act
    ImmutableScenario actualWithEntityLifecycleStatusResult =
        immutableScenario.withEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertSame(immutableScenario, actualWithEntityLifecycleStatusResult);
  }

  /**
   * Test {@link ImmutableScenario#withEntityLifecycleStatus(EntityLifecycleStatus)}.
   *
   * <ul>
   *   <li>Then return effectiveDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableScenario#withEntityLifecycleStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName(
      "Test withEntityLifecycleStatus(EntityLifecycleStatus); then return effectiveDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableScenario ImmutableScenario.withEntityLifecycleStatus(EntityLifecycleStatus)"
  })
  void testWithEntityLifecycleStatus_thenReturnEffectiveDateToStringIs19700101() {
    // Arrange
    LocalDate effectiveDate = LocalDate.of(1970, 1, 1);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableScenario actualWithEntityLifecycleStatusResult =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(effectiveDate)
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build()
            .withEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    LocalDate effectiveDateResult = actualWithEntityLifecycleStatusResult.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("2020-03-01", actualWithEntityLifecycleStatusResult.lastUpdatedBy());
    assertEquals("Name", actualWithEntityLifecycleStatusResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithEntityLifecycleStatusResult.description());
    assertEquals(0, actualWithEntityLifecycleStatusResult.position());
    assertEquals(1L, actualWithEntityLifecycleStatusResult.roadmapId());
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        actualWithEntityLifecycleStatusResult.entityLifecycleStatus());
    assertEquals(
        ReleaseLifecycleStatus.DRAFT, actualWithEntityLifecycleStatusResult.releaseStatus());
    assertEquals(ScenarioType.TARGET, actualWithEntityLifecycleStatusResult.scenarioType());
    assertSame(ofResult, actualWithEntityLifecycleStatusResult.lastUpdatedAt().toLocalDate());
    assertSame(effectiveDate, effectiveDateResult);
  }

  /**
   * Test {@link ImmutableScenario#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableScenario#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenario ImmutableScenario.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableScenario actualWithIdResult = immutableScenario.withId(optional);

    // Assert
    assertSame(immutableScenario, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableScenario#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return effectiveDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenario#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; when of forty-two; then return effectiveDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenario ImmutableScenario.withId(Optional)"})
  void testWithIdWithOptional_whenOfFortyTwo_thenReturnEffectiveDateToStringIs19700101() {
    // Arrange
    LocalDate effectiveDate = LocalDate.of(1970, 1, 1);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(effectiveDate)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableScenario actualWithIdResult = immutableScenario.withId(optional);

    // Assert
    LocalDate effectiveDateResult = actualWithIdResult.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(0, actualWithIdResult.position());
    assertEquals(1L, actualWithIdResult.roadmapId());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithIdResult.entityLifecycleStatus());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithIdResult.releaseStatus());
    assertEquals(ScenarioType.TARGET, actualWithIdResult.scenarioType());
    assertSame(ofResult, actualWithIdResult.lastUpdatedAt().toLocalDate());
    assertSame(effectiveDate, effectiveDateResult);
  }

  /**
   * Test {@link ImmutableScenario#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableScenario#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenario ImmutableScenario.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act
    ImmutableScenario actualWithIdResult = immutableScenario.withId(1L);

    // Assert
    assertSame(immutableScenario, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableScenario#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return effectiveDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenario#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; when forty-two; then return effectiveDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenario ImmutableScenario.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnEffectiveDateToStringIs19700101() {
    // Arrange
    LocalDate effectiveDate = LocalDate.of(1970, 1, 1);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableScenario actualWithIdResult =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(effectiveDate)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build()
            .withId(42L);

    // Assert
    LocalDate effectiveDateResult = actualWithIdResult.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(0, actualWithIdResult.position());
    assertEquals(1L, actualWithIdResult.roadmapId());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithIdResult.entityLifecycleStatus());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithIdResult.releaseStatus());
    assertEquals(ScenarioType.TARGET, actualWithIdResult.scenarioType());
    assertSame(ofResult, actualWithIdResult.lastUpdatedAt().toLocalDate());
    assertSame(effectiveDate, effectiveDateResult);
  }

  /**
   * Test {@link ImmutableScenario#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableScenario#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenario ImmutableScenario.withLastUpdatedAt(LocalDateTime)"})
  void testWithLastUpdatedAt() {
    // Arrange
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act
    ImmutableScenario actualWithLastUpdatedAtResult =
        immutableScenario.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableScenario, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableScenario#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableScenario#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenario ImmutableScenario.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy() {
    // Arrange
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act
    ImmutableScenario actualWithLastUpdatedByResult = immutableScenario.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableScenario, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableScenario#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then return effectiveDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenario#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String); then return effectiveDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenario ImmutableScenario.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy_thenReturnEffectiveDateToStringIs19700101() {
    // Arrange
    LocalDate effectiveDate = LocalDate.of(1970, 1, 1);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableScenario actualWithLastUpdatedByResult =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(effectiveDate)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build()
            .withLastUpdatedBy("42");

    // Assert
    LocalDate effectiveDateResult = actualWithLastUpdatedByResult.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("Name", actualWithLastUpdatedByResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithLastUpdatedByResult.description());
    assertEquals(0, actualWithLastUpdatedByResult.position());
    assertEquals(1L, actualWithLastUpdatedByResult.roadmapId());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualWithLastUpdatedByResult.entityLifecycleStatus());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithLastUpdatedByResult.releaseStatus());
    assertEquals(ScenarioType.TARGET, actualWithLastUpdatedByResult.scenarioType());
    assertSame(ofResult, actualWithLastUpdatedByResult.lastUpdatedAt().toLocalDate());
    assertSame(effectiveDate, effectiveDateResult);
  }

  /**
   * Test {@link ImmutableScenario#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableScenario#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenario ImmutableScenario.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("42")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act
    ImmutableScenario actualWithNameResult = immutableScenario.withName("42");

    // Assert
    assertSame(immutableScenario, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableScenario#withName(String)}.
   *
   * <ul>
   *   <li>Then return effectiveDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenario#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return effectiveDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenario ImmutableScenario.withName(String)"})
  void testWithName_thenReturnEffectiveDateToStringIs19700101() {
    // Arrange
    LocalDate effectiveDate = LocalDate.of(1970, 1, 1);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableScenario actualWithNameResult =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(effectiveDate)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build()
            .withName("42");

    // Assert
    LocalDate effectiveDateResult = actualWithNameResult.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("2020-03-01", actualWithNameResult.lastUpdatedBy());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(0, actualWithNameResult.position());
    assertEquals(1L, actualWithNameResult.roadmapId());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithNameResult.entityLifecycleStatus());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithNameResult.releaseStatus());
    assertEquals(ScenarioType.TARGET, actualWithNameResult.scenarioType());
    assertSame(ofResult, actualWithNameResult.lastUpdatedAt().toLocalDate());
    assertSame(effectiveDate, effectiveDateResult);
  }

  /**
   * Test {@link ImmutableScenario#withPosition(int)}.
   *
   * <p>Method under test: {@link ImmutableScenario#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenario ImmutableScenario.withPosition(int)"})
  void testWithPosition() {
    // Arrange
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act
    ImmutableScenario actualWithPositionResult = immutableScenario.withPosition(0);

    // Assert
    assertSame(immutableScenario, actualWithPositionResult);
  }

  /**
   * Test {@link ImmutableScenario#withPosition(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return effectiveDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenario#withPosition(int)}
   */
  @Test
  @DisplayName(
      "Test withPosition(int); when forty-two; then return effectiveDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenario ImmutableScenario.withPosition(int)"})
  void testWithPosition_whenFortyTwo_thenReturnEffectiveDateToStringIs19700101() {
    // Arrange
    LocalDate effectiveDate = LocalDate.of(1970, 1, 1);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableScenario actualWithPositionResult =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(effectiveDate)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build()
            .withPosition(42);

    // Assert
    LocalDate effectiveDateResult = actualWithPositionResult.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("2020-03-01", actualWithPositionResult.lastUpdatedBy());
    assertEquals("Name", actualWithPositionResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithPositionResult.description());
    assertEquals(1L, actualWithPositionResult.roadmapId());
    assertEquals(42, actualWithPositionResult.position());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithPositionResult.entityLifecycleStatus());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithPositionResult.releaseStatus());
    assertEquals(ScenarioType.TARGET, actualWithPositionResult.scenarioType());
    assertSame(ofResult, actualWithPositionResult.lastUpdatedAt().toLocalDate());
    assertSame(effectiveDate, effectiveDateResult);
  }

  /**
   * Test {@link ImmutableScenario#withReleaseStatus(ReleaseLifecycleStatus)}.
   *
   * <p>Method under test: {@link ImmutableScenario#withReleaseStatus(ReleaseLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withReleaseStatus(ReleaseLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableScenario ImmutableScenario.withReleaseStatus(ReleaseLifecycleStatus)"
  })
  void testWithReleaseStatus() {
    // Arrange
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act
    ImmutableScenario actualWithReleaseStatusResult =
        immutableScenario.withReleaseStatus(ReleaseLifecycleStatus.DRAFT);

    // Assert
    assertSame(immutableScenario, actualWithReleaseStatusResult);
  }

  /**
   * Test {@link ImmutableScenario#withReleaseStatus(ReleaseLifecycleStatus)}.
   *
   * <ul>
   *   <li>Then return effectiveDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenario#withReleaseStatus(ReleaseLifecycleStatus)}
   */
  @Test
  @DisplayName(
      "Test withReleaseStatus(ReleaseLifecycleStatus); then return effectiveDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableScenario ImmutableScenario.withReleaseStatus(ReleaseLifecycleStatus)"
  })
  void testWithReleaseStatus_thenReturnEffectiveDateToStringIs19700101() {
    // Arrange
    LocalDate effectiveDate = LocalDate.of(1970, 1, 1);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableScenario actualWithReleaseStatusResult =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(effectiveDate)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.ACTIVE)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build()
            .withReleaseStatus(ReleaseLifecycleStatus.DRAFT);

    // Assert
    LocalDate effectiveDateResult = actualWithReleaseStatusResult.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("2020-03-01", actualWithReleaseStatusResult.lastUpdatedBy());
    assertEquals("Name", actualWithReleaseStatusResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithReleaseStatusResult.description());
    assertEquals(0, actualWithReleaseStatusResult.position());
    assertEquals(1L, actualWithReleaseStatusResult.roadmapId());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualWithReleaseStatusResult.entityLifecycleStatus());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithReleaseStatusResult.releaseStatus());
    assertEquals(ScenarioType.TARGET, actualWithReleaseStatusResult.scenarioType());
    assertSame(ofResult, actualWithReleaseStatusResult.lastUpdatedAt().toLocalDate());
    assertSame(effectiveDate, effectiveDateResult);
  }

  /**
   * Test {@link ImmutableScenario#withRoadmapId(long)}.
   *
   * <p>Method under test: {@link ImmutableScenario#withRoadmapId(long)}
   */
  @Test
  @DisplayName("Test withRoadmapId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenario ImmutableScenario.withRoadmapId(long)"})
  void testWithRoadmapId() {
    // Arrange
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(42L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act
    ImmutableScenario actualWithRoadmapIdResult = immutableScenario.withRoadmapId(42L);

    // Assert
    assertSame(immutableScenario, actualWithRoadmapIdResult);
  }

  /**
   * Test {@link ImmutableScenario#withRoadmapId(long)}.
   *
   * <ul>
   *   <li>Then return effectiveDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenario#withRoadmapId(long)}
   */
  @Test
  @DisplayName("Test withRoadmapId(long); then return effectiveDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenario ImmutableScenario.withRoadmapId(long)"})
  void testWithRoadmapId_thenReturnEffectiveDateToStringIs19700101() {
    // Arrange
    LocalDate effectiveDate = LocalDate.of(1970, 1, 1);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableScenario actualWithRoadmapIdResult =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(effectiveDate)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build()
            .withRoadmapId(42L);

    // Assert
    LocalDate effectiveDateResult = actualWithRoadmapIdResult.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("2020-03-01", actualWithRoadmapIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithRoadmapIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithRoadmapIdResult.description());
    assertEquals(0, actualWithRoadmapIdResult.position());
    assertEquals(42L, actualWithRoadmapIdResult.roadmapId());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithRoadmapIdResult.entityLifecycleStatus());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithRoadmapIdResult.releaseStatus());
    assertEquals(ScenarioType.TARGET, actualWithRoadmapIdResult.scenarioType());
    assertSame(ofResult, actualWithRoadmapIdResult.lastUpdatedAt().toLocalDate());
    assertSame(effectiveDate, effectiveDateResult);
  }

  /**
   * Test {@link ImmutableScenario#withScenarioType(ScenarioType)}.
   *
   * <p>Method under test: {@link ImmutableScenario#withScenarioType(ScenarioType)}
   */
  @Test
  @DisplayName("Test withScenarioType(ScenarioType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenario ImmutableScenario.withScenarioType(ScenarioType)"})
  void testWithScenarioType() {
    // Arrange
    ImmutableScenario immutableScenario =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build();

    // Act
    ImmutableScenario actualWithScenarioTypeResult =
        immutableScenario.withScenarioType(ScenarioType.TARGET);

    // Assert
    assertSame(immutableScenario, actualWithScenarioTypeResult);
  }

  /**
   * Test {@link ImmutableScenario#withScenarioType(ScenarioType)}.
   *
   * <ul>
   *   <li>Then return effectiveDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenario#withScenarioType(ScenarioType)}
   */
  @Test
  @DisplayName(
      "Test withScenarioType(ScenarioType); then return effectiveDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenario ImmutableScenario.withScenarioType(ScenarioType)"})
  void testWithScenarioType_thenReturnEffectiveDateToStringIs19700101() {
    // Arrange
    LocalDate effectiveDate = LocalDate.of(1970, 1, 1);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableScenario actualWithScenarioTypeResult =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(effectiveDate)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.CURRENT)
            .build()
            .withScenarioType(ScenarioType.TARGET);

    // Assert
    LocalDate effectiveDateResult = actualWithScenarioTypeResult.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("2020-03-01", actualWithScenarioTypeResult.lastUpdatedBy());
    assertEquals("Name", actualWithScenarioTypeResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithScenarioTypeResult.description());
    assertEquals(0, actualWithScenarioTypeResult.position());
    assertEquals(1L, actualWithScenarioTypeResult.roadmapId());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualWithScenarioTypeResult.entityLifecycleStatus());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithScenarioTypeResult.releaseStatus());
    assertEquals(ScenarioType.TARGET, actualWithScenarioTypeResult.scenarioType());
    assertSame(ofResult, actualWithScenarioTypeResult.lastUpdatedAt().toLocalDate());
    assertSame(effectiveDate, effectiveDateResult);
  }
}
