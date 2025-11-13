package org.finos.waltz.model.logical_data_element;

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
import java.util.Optional;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityLifecycleStatusProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.FieldDataType;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.logical_data_element.ImmutableLogicalDataElement.Builder;
import org.finos.waltz.model.logical_data_element.ImmutableLogicalDataElement.Json;
import org.finos.waltz.model.rating.RagRating;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLogicalDataElementDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#entityLifecycleStatus(EntityLifecycleStatus)}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#kind(EntityKind)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalDataElement Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.entityLifecycleStatus(EntityLifecycleStatus)",
    "Builder Builder.externalId(String)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    Optional<String> externalId = Optional.of("42");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.of(42L);
    ImmutableLogicalDataElement actualImmutableLogicalDataElement =
        actualIdResult
            .id(id)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Assert
    assertEquals("Name", actualImmutableLogicalDataElement.name());
    assertEquals("Provenance", actualImmutableLogicalDataElement.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableLogicalDataElement.description());
    assertEquals(1L, actualImmutableLogicalDataElement.parentDataTypeId());
    assertEquals(EntityKind.ALL, actualImmutableLogicalDataElement.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualImmutableLogicalDataElement.entityLifecycleStatus());
    assertEquals(FieldDataType.DATE, actualImmutableLogicalDataElement.type());
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElement.builder();
    Optional<String> externalId = Optional.of("42");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
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
    Builder builderResult = ImmutableLogicalDataElement.builder();
    ImmutableLogicalDataElement instance =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableLogicalDataElement actualImmutableLogicalDataElement = builderResult.build();
    assertEquals(instance, actualImmutableLogicalDataElement);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableLogicalDataElement.builder();

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
    Builder builderResult = ImmutableLogicalDataElement.builder();

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
    Builder builderResult = ImmutableLogicalDataElement.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElement.builder();
    ImmutableLogicalDataElement instance =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((EntityKindProvider) instance);

    // Assert
    ImmutableLogicalDataElement actualImmutableLogicalDataElement = builderResult.build();
    assertEquals(instance, actualImmutableLogicalDataElement);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'; given 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_givenAll() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElement.builder();

    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityKindProvider) with 'EntityKindProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElement.builder();

    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
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
    Builder builderResult = ImmutableLogicalDataElement.builder();

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
    Builder builderResult = ImmutableLogicalDataElement.builder();
    ImmutableLogicalDataElement instance =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((EntityLifecycleStatusProvider) instance);

    // Assert
    ImmutableLogicalDataElement actualImmutableLogicalDataElement = builderResult.build();
    assertEquals(instance, actualImmutableLogicalDataElement);
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
  void testBuilderFromWithEntityLifecycleStatusProvider3() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElement.builder();

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
    Builder builderResult = ImmutableLogicalDataElement.builder();

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
    Builder builderResult = ImmutableLogicalDataElement.builder();

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
  void testBuilderFromWithEntityLifecycleStatusProvider6() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElement.builder();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.empty();

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
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElement.builder();
    ImmutableLogicalDataElement instance =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableLogicalDataElement actualImmutableLogicalDataElement = builderResult.build();
    assertEquals(instance, actualImmutableLogicalDataElement);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElement.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElement.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
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
    Builder builderResult = ImmutableLogicalDataElement.builder();
    ImmutableLogicalDataElement instance =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableLogicalDataElement actualImmutableLogicalDataElement = builderResult.build();
    assertEquals(instance, actualImmutableLogicalDataElement);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElement.builder();

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
   *   <li>Given of forty-two.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of forty-two; when IdProvider id() return of forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfFortyTwo_whenIdProviderIdReturnOfFortyTwo() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElement.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(42L);
    when(instance.id()).thenReturn(ofResult);

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
    Builder builderResult = ImmutableLogicalDataElement.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(LogicalDataElement)} with {@code LogicalDataElement}.
   *
   * <p>Method under test: {@link Builder#from(LogicalDataElement)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalDataElement) with 'LogicalDataElement'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LogicalDataElement)"})
  void testBuilderFromWithLogicalDataElement() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElement.builder();
    ImmutableLogicalDataElement instance =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLogicalDataElement actualImmutableLogicalDataElement = builderResult.build();
    assertEquals(instance, actualImmutableLogicalDataElement);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LogicalDataElement)} with {@code LogicalDataElement}.
   *
   * <p>Method under test: {@link Builder#from(LogicalDataElement)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalDataElement) with 'LogicalDataElement'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LogicalDataElement)"})
  void testBuilderFromWithLogicalDataElement2() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElement.builder();
    ImmutableLogicalDataElement instance =
        ImmutableLogicalDataElement.builder()
            .description(null)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLogicalDataElement actualImmutableLogicalDataElement = builderResult.build();
    assertEquals(instance, actualImmutableLogicalDataElement);
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
    Builder builderResult = ImmutableLogicalDataElement.builder();
    ImmutableLogicalDataElement instance =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableLogicalDataElement actualImmutableLogicalDataElement = builderResult.build();
    assertEquals(instance, actualImmutableLogicalDataElement);
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
  void testBuilderFromWithNameProvider2() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElement.builder();
    ImmutableLogicalDataElement instance =
        ImmutableLogicalDataElement.builder()
            .description(null)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableLogicalDataElement actualImmutableLogicalDataElement = builderResult.build();
    assertEquals(instance, actualImmutableLogicalDataElement);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then calls {@link NameProvider#name()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then calls name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenCallsName() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElement.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElement.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableActor.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isExternal(true)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider2() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElement.builder();
    ImmutableLogicalDataElement instance =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ProvenanceProvider) instance);

    // Assert
    ImmutableLogicalDataElement actualImmutableLogicalDataElement = builderResult.build();
    assertEquals(instance, actualImmutableLogicalDataElement);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider3() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElement.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableAggregateOverlayDiagram.builder()
                    .aggregatedEntityKind(EntityKind.ALL)
                    .description("The characteristics of someone or something")
                    .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .status(ReleaseLifecycleStatus.DRAFT)
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider4() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElement.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableAggregateOverlayDiagram.builder()
                    .aggregatedEntityKind(EntityKind.ALL)
                    .description(null)
                    .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .status(ReleaseLifecycleStatus.DRAFT)
                    .build());

    // Assert
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
    Builder builderResult = ImmutableLogicalDataElement.builder();

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
    Builder builderResult = ImmutableLogicalDataElement.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
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
    Builder builderResult = ImmutableLogicalDataElement.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#parentDataTypeId(long)}.
   *
   * <p>Method under test: {@link Builder#parentDataTypeId(long)}
   */
  @Test
  @DisplayName("Test Builder parentDataTypeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentDataTypeId(long)"})
  void testBuilderParentDataTypeId() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElement.builder();

    // Act
    Builder actualParentDataTypeIdResult = builderResult.parentDataTypeId(1L);

    // Assert
    assertSame(builderResult, actualParentDataTypeIdResult);
  }

  /**
   * Test Builder {@link Builder#type(FieldDataType)}.
   *
   * <p>Method under test: {@link Builder#type(FieldDataType)}
   */
  @Test
  @DisplayName("Test Builder type(FieldDataType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.type(FieldDataType)"})
  void testBuilderType() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElement.builder();

    // Act
    Builder actualTypeResult = builderResult.type(FieldDataType.DATE);

    // Assert
    assertSame(builderResult, actualTypeResult);
  }

  /**
   * Test {@link ImmutableLogicalDataElement#copyOf(LogicalDataElement)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#copyOf(LogicalDataElement)}
   */
  @Test
  @DisplayName("Test copyOf(LogicalDataElement); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalDataElement ImmutableLogicalDataElement.copyOf(LogicalDataElement)"
  })
  void testCopyOf_thenReturnName() {
    // Arrange
    ImmutableLogicalDataElement instance =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act
    ImmutableLogicalDataElement actualCopyOfResult = ImmutableLogicalDataElement.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.parentDataTypeId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(FieldDataType.DATE, actualCopyOfResult.type());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#entityLifecycleStatus()}.
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#entityLifecycleStatus()}
   */
  @Test
  @DisplayName("Test entityLifecycleStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus ImmutableLogicalDataElement.entityLifecycleStatus()"})
  void testEntityLifecycleStatus() {
    // Arrange, Act and Assert
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build()
            .entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#equals(Object)}, and {@link
   * ImmutableLogicalDataElement#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalDataElement#equals(Object)}
   *   <li>{@link ImmutableLogicalDataElement#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalDataElement.equals(Object)",
    "int ImmutableLogicalDataElement.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableLogicalDataElement immutableLogicalDataElement =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();
    ImmutableLogicalDataElement immutableLogicalDataElement2 =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act and Assert
    assertEquals(immutableLogicalDataElement, immutableLogicalDataElement2);
    assertEquals(immutableLogicalDataElement.hashCode(), immutableLogicalDataElement2.hashCode());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#equals(Object)}, and {@link
   * ImmutableLogicalDataElement#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalDataElement#equals(Object)}
   *   <li>{@link ImmutableLogicalDataElement#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalDataElement.equals(Object)",
    "int ImmutableLogicalDataElement.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableLogicalDataElement immutableLogicalDataElement =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act and Assert
    assertEquals(immutableLogicalDataElement, immutableLogicalDataElement);
    int expectedHashCodeResult = immutableLogicalDataElement.hashCode();
    assertEquals(expectedHashCodeResult, immutableLogicalDataElement.hashCode());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalDataElement.equals(Object)",
    "int ImmutableLogicalDataElement.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableLogicalDataElement immutableLogicalDataElement =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLogicalDataElement,
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalDataElement.equals(Object)",
    "int ImmutableLogicalDataElement.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableLogicalDataElement immutableLogicalDataElement =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLogicalDataElement,
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalDataElement.equals(Object)",
    "int ImmutableLogicalDataElement.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableLogicalDataElement immutableLogicalDataElement =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(2L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLogicalDataElement,
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalDataElement.equals(Object)",
    "int ImmutableLogicalDataElement.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableLogicalDataElement immutableLogicalDataElement =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLogicalDataElement,
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalDataElement.equals(Object)",
    "int ImmutableLogicalDataElement.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableLogicalDataElement immutableLogicalDataElement =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Provenance")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLogicalDataElement,
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalDataElement.equals(Object)",
    "int ImmutableLogicalDataElement.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableLogicalDataElement immutableLogicalDataElement =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(2L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLogicalDataElement,
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalDataElement.equals(Object)",
    "int ImmutableLogicalDataElement.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableLogicalDataElement immutableLogicalDataElement =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Name")
            .type(FieldDataType.DATE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLogicalDataElement,
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalDataElement.equals(Object)",
    "int ImmutableLogicalDataElement.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableLogicalDataElement immutableLogicalDataElement =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATETIME)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLogicalDataElement,
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalDataElement.equals(Object)",
    "int ImmutableLogicalDataElement.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableLogicalDataElement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalDataElement.equals(Object)",
    "int ImmutableLogicalDataElement.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build(),
        "Different type to ImmutableLogicalDataElement");
  }

  /**
   * Test {@link ImmutableLogicalDataElement#externalId()}.
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableLogicalDataElement.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalDataElement#description()}
   *   <li>{@link ImmutableLogicalDataElement#name()}
   *   <li>{@link ImmutableLogicalDataElement#parentDataTypeId()}
   *   <li>{@link ImmutableLogicalDataElement#type()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableLogicalDataElement.description()",
    "String ImmutableLogicalDataElement.name()",
    "long ImmutableLogicalDataElement.parentDataTypeId()",
    "FieldDataType ImmutableLogicalDataElement.type()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableLogicalDataElement immutableLogicalDataElement =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act
    String actualDescriptionResult = immutableLogicalDataElement.description();
    String actualNameResult = immutableLogicalDataElement.name();
    long actualParentDataTypeIdResult = immutableLogicalDataElement.parentDataTypeId();

    // Assert
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, actualParentDataTypeIdResult);
    assertEquals(FieldDataType.DATE, immutableLogicalDataElement.type());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#id()}.
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableLogicalDataElement.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
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
   * Test Json {@link Json#externalId()}.
   *
   * <p>Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().externalId());
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
   * Test Json {@link Json#kind()}.
   *
   * <p>Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().kind());
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
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.kind);
    assertNull(actualJson.entityLifecycleStatus);
    assertNull(actualJson.type);
    assertEquals(0L, actualJson.parentDataTypeId);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.parentDataTypeIdIsSet);
  }

  /**
   * Test Json {@link Json#parentDataTypeId()}.
   *
   * <p>Method under test: {@link Json#parentDataTypeId()}
   */
  @Test
  @DisplayName("Test Json parentDataTypeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.parentDataTypeId()"})
  void testJsonParentDataTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parentDataTypeId());
  }

  /**
   * Test Json {@link Json#provenance()}.
   *
   * <p>Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().provenance());
  }

  /**
   * Test Json {@link Json#setParentDataTypeId(long)}.
   *
   * <p>Method under test: {@link Json#setParentDataTypeId(long)}
   */
  @Test
  @DisplayName("Test Json setParentDataTypeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setParentDataTypeId(long)"})
  void testJsonSetParentDataTypeId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setParentDataTypeId(1L);

    // Assert
    assertEquals(1L, json.parentDataTypeId);
    assertTrue(json.parentDataTypeIdIsSet);
  }

  /**
   * Test Json {@link Json#type()}.
   *
   * <p>Method under test: {@link Json#type()}
   */
  @Test
  @DisplayName("Test Json type()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldDataType Json.type()"})
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().type());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#kind()}.
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableLogicalDataElement.kind()"})
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#provenance()}.
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableLogicalDataElement.provenance()"})
  void testProvenance() {
    // Arrange, Act and Assert
    assertEquals(
        "Provenance",
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#toString()}.
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableLogicalDataElement.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "LogicalDataElement{id=1, entityLifecycleStatus=ACTIVE, externalId=42, name=Name, kind=ALL, type=DATE,"
            + " parentDataTypeId=1, provenance=Provenance}",
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalDataElement ImmutableLogicalDataElement.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableLogicalDataElement immutableLogicalDataElement =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act
    ImmutableLogicalDataElement actualWithDescriptionResult =
        immutableLogicalDataElement.withDescription("42");

    // Assert
    assertEquals(immutableLogicalDataElement, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableLogicalDataElement#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalDataElement ImmutableLogicalDataElement.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutableLogicalDataElement immutableLogicalDataElement =
        ImmutableLogicalDataElement.builder()
            .description("42")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act
    ImmutableLogicalDataElement actualWithDescriptionResult =
        immutableLogicalDataElement.withDescription("42");

    // Assert
    assertSame(immutableLogicalDataElement, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableLogicalDataElement#withEntityLifecycleStatus(EntityLifecycleStatus)}.
   *
   * <p>Method under test: {@link
   * ImmutableLogicalDataElement#withEntityLifecycleStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withEntityLifecycleStatus(EntityLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalDataElement ImmutableLogicalDataElement.withEntityLifecycleStatus(EntityLifecycleStatus)"
  })
  void testWithEntityLifecycleStatus() {
    // Arrange
    ImmutableLogicalDataElement immutableLogicalDataElement =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act
    ImmutableLogicalDataElement actualWithEntityLifecycleStatusResult =
        immutableLogicalDataElement.withEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertSame(immutableLogicalDataElement, actualWithEntityLifecycleStatusResult);
  }

  /**
   * Test {@link ImmutableLogicalDataElement#withEntityLifecycleStatus(EntityLifecycleStatus)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableLogicalDataElement#withEntityLifecycleStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withEntityLifecycleStatus(EntityLifecycleStatus); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalDataElement ImmutableLogicalDataElement.withEntityLifecycleStatus(EntityLifecycleStatus)"
  })
  void testWithEntityLifecycleStatus_thenReturnName() {
    // Arrange and Act
    ImmutableLogicalDataElement actualWithEntityLifecycleStatusResult =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build()
            .withEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertEquals("Name", actualWithEntityLifecycleStatusResult.name());
    assertEquals("Provenance", actualWithEntityLifecycleStatusResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithEntityLifecycleStatusResult.description());
    assertEquals(1L, actualWithEntityLifecycleStatusResult.parentDataTypeId());
    assertEquals(EntityKind.ALL, actualWithEntityLifecycleStatusResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        actualWithEntityLifecycleStatusResult.entityLifecycleStatus());
    assertEquals(FieldDataType.DATE, actualWithEntityLifecycleStatusResult.type());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalDataElement ImmutableLogicalDataElement.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    ImmutableLogicalDataElement immutableLogicalDataElement =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableLogicalDataElement actualWithExternalIdResult =
        immutableLogicalDataElement.withExternalId(optional);

    // Assert
    assertSame(immutableLogicalDataElement, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableLogicalDataElement#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalDataElement ImmutableLogicalDataElement.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional_thenReturnName() {
    // Arrange
    ImmutableLogicalDataElement immutableLogicalDataElement =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("External Id")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableLogicalDataElement actualWithExternalIdResult =
        immutableLogicalDataElement.withExternalId(optional);

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1L, actualWithExternalIdResult.parentDataTypeId());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithExternalIdResult.entityLifecycleStatus());
    assertEquals(FieldDataType.DATE, actualWithExternalIdResult.type());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalDataElement ImmutableLogicalDataElement.withExternalId(String)"
  })
  void testWithExternalIdWithValue() {
    // Arrange
    ImmutableLogicalDataElement immutableLogicalDataElement =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act
    ImmutableLogicalDataElement actualWithExternalIdResult =
        immutableLogicalDataElement.withExternalId("42");

    // Assert
    assertSame(immutableLogicalDataElement, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableLogicalDataElement#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; when '0123456789ABCDEF'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalDataElement ImmutableLogicalDataElement.withExternalId(String)"
  })
  void testWithExternalIdWithValue_when0123456789abcdef_thenReturnName() {
    // Arrange and Act
    ImmutableLogicalDataElement actualWithExternalIdResult =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1L, actualWithExternalIdResult.parentDataTypeId());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithExternalIdResult.entityLifecycleStatus());
    assertEquals(FieldDataType.DATE, actualWithExternalIdResult.type());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLogicalDataElement ImmutableLogicalDataElement.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableLogicalDataElement immutableLogicalDataElement =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableLogicalDataElement actualWithIdResult = immutableLogicalDataElement.withId(optional);

    // Assert
    assertSame(immutableLogicalDataElement, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableLogicalDataElement#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; when of forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLogicalDataElement ImmutableLogicalDataElement.withId(Optional)"})
  void testWithIdWithOptional_whenOfFortyTwo_thenReturnName() {
    // Arrange
    ImmutableLogicalDataElement immutableLogicalDataElement =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableLogicalDataElement actualWithIdResult = immutableLogicalDataElement.withId(optional);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, actualWithIdResult.parentDataTypeId());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithIdResult.entityLifecycleStatus());
    assertEquals(FieldDataType.DATE, actualWithIdResult.type());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLogicalDataElement ImmutableLogicalDataElement.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableLogicalDataElement immutableLogicalDataElement =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act
    ImmutableLogicalDataElement actualWithIdResult = immutableLogicalDataElement.withId(1L);

    // Assert
    assertSame(immutableLogicalDataElement, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableLogicalDataElement#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLogicalDataElement ImmutableLogicalDataElement.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnName() {
    // Arrange and Act
    ImmutableLogicalDataElement actualWithIdResult =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build()
            .withId(42L);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, actualWithIdResult.parentDataTypeId());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithIdResult.entityLifecycleStatus());
    assertEquals(FieldDataType.DATE, actualWithIdResult.type());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalDataElement ImmutableLogicalDataElement.withKind(EntityKind)"
  })
  void testWithKind() {
    // Arrange
    ImmutableLogicalDataElement immutableLogicalDataElement =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act
    ImmutableLogicalDataElement actualWithKindResult =
        immutableLogicalDataElement.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableLogicalDataElement, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableLogicalDataElement#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalDataElement ImmutableLogicalDataElement.withKind(EntityKind)"
  })
  void testWithKind_thenReturnName() {
    // Arrange and Act
    ImmutableLogicalDataElement actualWithKindResult =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("Provenance", actualWithKindResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(1L, actualWithKindResult.parentDataTypeId());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithKindResult.entityLifecycleStatus());
    assertEquals(FieldDataType.DATE, actualWithKindResult.type());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLogicalDataElement ImmutableLogicalDataElement.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableLogicalDataElement immutableLogicalDataElement =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("42")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act
    ImmutableLogicalDataElement actualWithNameResult = immutableLogicalDataElement.withName("42");

    // Assert
    assertSame(immutableLogicalDataElement, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableLogicalDataElement#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLogicalDataElement ImmutableLogicalDataElement.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableLogicalDataElement actualWithNameResult =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Provenance", actualWithNameResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1L, actualWithNameResult.parentDataTypeId());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithNameResult.entityLifecycleStatus());
    assertEquals(FieldDataType.DATE, actualWithNameResult.type());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#withParentDataTypeId(long)}.
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#withParentDataTypeId(long)}
   */
  @Test
  @DisplayName("Test withParentDataTypeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalDataElement ImmutableLogicalDataElement.withParentDataTypeId(long)"
  })
  void testWithParentDataTypeId() {
    // Arrange
    ImmutableLogicalDataElement immutableLogicalDataElement =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(42L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act
    ImmutableLogicalDataElement actualWithParentDataTypeIdResult =
        immutableLogicalDataElement.withParentDataTypeId(42L);

    // Assert
    assertSame(immutableLogicalDataElement, actualWithParentDataTypeIdResult);
  }

  /**
   * Test {@link ImmutableLogicalDataElement#withParentDataTypeId(long)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#withParentDataTypeId(long)}
   */
  @Test
  @DisplayName("Test withParentDataTypeId(long); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalDataElement ImmutableLogicalDataElement.withParentDataTypeId(long)"
  })
  void testWithParentDataTypeId_thenReturnName() {
    // Arrange and Act
    ImmutableLogicalDataElement actualWithParentDataTypeIdResult =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build()
            .withParentDataTypeId(42L);

    // Assert
    assertEquals("Name", actualWithParentDataTypeIdResult.name());
    assertEquals("Provenance", actualWithParentDataTypeIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithParentDataTypeIdResult.description());
    assertEquals(42L, actualWithParentDataTypeIdResult.parentDataTypeId());
    assertEquals(EntityKind.ALL, actualWithParentDataTypeIdResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualWithParentDataTypeIdResult.entityLifecycleStatus());
    assertEquals(FieldDataType.DATE, actualWithParentDataTypeIdResult.type());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalDataElement ImmutableLogicalDataElement.withProvenance(String)"
  })
  void testWithProvenance() {
    // Arrange
    ImmutableLogicalDataElement immutableLogicalDataElement =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("42")
            .type(FieldDataType.DATE)
            .build();

    // Act
    ImmutableLogicalDataElement actualWithProvenanceResult =
        immutableLogicalDataElement.withProvenance("42");

    // Assert
    assertSame(immutableLogicalDataElement, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableLogicalDataElement#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return provenance is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then return provenance is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalDataElement ImmutableLogicalDataElement.withProvenance(String)"
  })
  void testWithProvenance_thenReturnProvenanceIs42() {
    // Arrange and Act
    ImmutableLogicalDataElement actualWithProvenanceResult =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build()
            .withProvenance("42");

    // Assert
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Name", actualWithProvenanceResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
    assertEquals(1L, actualWithProvenanceResult.parentDataTypeId());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithProvenanceResult.entityLifecycleStatus());
    assertEquals(FieldDataType.DATE, actualWithProvenanceResult.type());
  }

  /**
   * Test {@link ImmutableLogicalDataElement#withType(FieldDataType)}.
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#withType(FieldDataType)}
   */
  @Test
  @DisplayName("Test withType(FieldDataType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalDataElement ImmutableLogicalDataElement.withType(FieldDataType)"
  })
  void testWithType() {
    // Arrange
    ImmutableLogicalDataElement immutableLogicalDataElement =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATE)
            .build();

    // Act
    ImmutableLogicalDataElement actualWithTypeResult =
        immutableLogicalDataElement.withType(FieldDataType.DATE);

    // Assert
    assertSame(immutableLogicalDataElement, actualWithTypeResult);
  }

  /**
   * Test {@link ImmutableLogicalDataElement#withType(FieldDataType)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalDataElement#withType(FieldDataType)}
   */
  @Test
  @DisplayName("Test withType(FieldDataType); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalDataElement ImmutableLogicalDataElement.withType(FieldDataType)"
  })
  void testWithType_thenReturnName() {
    // Arrange and Act
    ImmutableLogicalDataElement actualWithTypeResult =
        ImmutableLogicalDataElement.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentDataTypeId(1L)
            .provenance("Provenance")
            .type(FieldDataType.DATETIME)
            .build()
            .withType(FieldDataType.DATE);

    // Assert
    assertEquals("Name", actualWithTypeResult.name());
    assertEquals("Provenance", actualWithTypeResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithTypeResult.description());
    assertEquals(1L, actualWithTypeResult.parentDataTypeId());
    assertEquals(EntityKind.ALL, actualWithTypeResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithTypeResult.entityLifecycleStatus());
    assertEquals(FieldDataType.DATE, actualWithTypeResult.type());
  }
}
