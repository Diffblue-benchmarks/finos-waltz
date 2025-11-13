package org.finos.waltz.model.aggregate_overlay_diagram;

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
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagramInstance.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagramInstance.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAggregateOverlayDiagramInstanceDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#kind(EntityKind)}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L);
    Optional<Long> id = Optional.of(42L);
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    Builder actualNameResult =
        actualIdResult
            .id(id)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference parentEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableAggregateOverlayDiagramInstance actualImmutableAggregateOverlayDiagramInstance =
        actualNameResult
            .parentEntityReference(parentEntityReference)
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableAggregateOverlayDiagramInstance.lastUpdatedBy());
    assertEquals("Name", actualImmutableAggregateOverlayDiagramInstance.name());
    assertEquals("Provenance", actualImmutableAggregateOverlayDiagramInstance.provenance());
    assertEquals("Svg", actualImmutableAggregateOverlayDiagramInstance.svg());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableAggregateOverlayDiagramInstance.description());
    assertEquals(1L, actualImmutableAggregateOverlayDiagramInstance.diagramId().longValue());
    assertEquals(EntityKind.ALL, actualImmutableAggregateOverlayDiagramInstance.kind());
    assertSame(lastUpdatedAt, actualImmutableAggregateOverlayDiagramInstance.lastUpdatedAt());
    assertSame(
        parentEntityReference,
        actualImmutableAggregateOverlayDiagramInstance.parentEntityReference());
  }

  /**
   * Test Builder {@link Builder#diagramId(Long)}.
   *
   * <p>Method under test: {@link Builder#diagramId(Long)}
   */
  @Test
  @DisplayName("Test Builder diagramId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.diagramId(Long)"})
  void testBuilderDiagramId() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

    // Act
    Builder actualDiagramIdResult = builderResult.diagramId(1L);

    // Assert
    assertSame(builderResult, actualDiagramIdResult);
  }

  /**
   * Test Builder {@link Builder#from(AggregateOverlayDiagramInstance)} with {@code
   * AggregateOverlayDiagramInstance}.
   *
   * <p>Method under test: {@link Builder#from(AggregateOverlayDiagramInstance)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AggregateOverlayDiagramInstance) with 'AggregateOverlayDiagramInstance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AggregateOverlayDiagramInstance)"})
  void testBuilderFromWithAggregateOverlayDiagramInstance() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance instance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAggregateOverlayDiagramInstance actualImmutableAggregateOverlayDiagramInstance =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramInstance);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AggregateOverlayDiagramInstance)} with {@code
   * AggregateOverlayDiagramInstance}.
   *
   * <p>Method under test: {@link Builder#from(AggregateOverlayDiagramInstance)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AggregateOverlayDiagramInstance) with 'AggregateOverlayDiagramInstance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AggregateOverlayDiagramInstance)"})
  void testBuilderFromWithAggregateOverlayDiagramInstance2() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description(null)
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance instance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAggregateOverlayDiagramInstance actualImmutableAggregateOverlayDiagramInstance =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramInstance);
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
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance instance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act and Assert
    ImmutableAggregateOverlayDiagramInstance actualImmutableAggregateOverlayDiagramInstance =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramInstance);
    ImmutableAggregateOverlayDiagramInstance actualImmutableAggregateOverlayDiagramInstance2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramInstance2);
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
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
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
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance instance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act and Assert
    ImmutableAggregateOverlayDiagramInstance actualImmutableAggregateOverlayDiagramInstance =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramInstance);
    ImmutableAggregateOverlayDiagramInstance actualImmutableAggregateOverlayDiagramInstance2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramInstance2);
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
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance instance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act and Assert
    ImmutableAggregateOverlayDiagramInstance actualImmutableAggregateOverlayDiagramInstance =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramInstance);
    ImmutableAggregateOverlayDiagramInstance actualImmutableAggregateOverlayDiagramInstance2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramInstance2);
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
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance instance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act and Assert
    ImmutableAggregateOverlayDiagramInstance actualImmutableAggregateOverlayDiagramInstance =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramInstance);
    ImmutableAggregateOverlayDiagramInstance actualImmutableAggregateOverlayDiagramInstance2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramInstance2);
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
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description(null)
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance instance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act and Assert
    ImmutableAggregateOverlayDiagramInstance actualImmutableAggregateOverlayDiagramInstance =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramInstance);
    ImmutableAggregateOverlayDiagramInstance actualImmutableAggregateOverlayDiagramInstance2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramInstance2);
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
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance instance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act and Assert
    ImmutableAggregateOverlayDiagramInstance actualImmutableAggregateOverlayDiagramInstance =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramInstance);
    ImmutableAggregateOverlayDiagramInstance actualImmutableAggregateOverlayDiagramInstance2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramInstance2);
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
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableActor.builder()
                    .description(null)
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
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();
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
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#parentEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#parentEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder parentEntityReference(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentEntityReference(EntityReference)"})
  void testBuilderParentEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

    // Act
    Builder actualParentEntityReferenceResult =
        builderResult.parentEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualParentEntityReferenceResult);
  }

  /**
   * Test Builder {@link Builder#svg(String)}.
   *
   * <ul>
   *   <li>When {@code Svg}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#svg(String)}
   */
  @Test
  @DisplayName("Test Builder svg(String); when 'Svg'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.svg(String)"})
  void testBuilderSvg_whenSvg_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInstance.builder();

    // Act
    Builder actualSvgResult = builderResult.svg("Svg");

    // Assert
    assertSame(builderResult, actualSvgResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#copyOf(AggregateOverlayDiagramInstance)}.
   *
   * <ul>
   *   <li>Then parentEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAggregateOverlayDiagramInstance#copyOf(AggregateOverlayDiagramInstance)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AggregateOverlayDiagramInstance); then parentEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.copyOf(AggregateOverlayDiagramInstance)"
  })
  void testCopyOf_thenParentEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance instance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramInstance actualCopyOfResult =
        ImmutableAggregateOverlayDiagramInstance.copyOf(instance);

    // Assert
    EntityReference parentEntityReferenceResult = actualCopyOfResult.parentEntityReference();
    assertTrue(parentEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("Svg", actualCopyOfResult.svg());
    assertEquals(
        "The characteristics of someone or something", parentEntityReferenceResult.description());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.diagramId().longValue());
    assertEquals(1L, parentEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, parentEntityReferenceResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualCopyOfResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}, and {@link
   * ImmutableAggregateOverlayDiagramInstance#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}
   *   <li>{@link ImmutableAggregateOverlayDiagramInstance#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramInstance.equals(Object)",
    "int ImmutableAggregateOverlayDiagramInstance.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    Builder nameResult2 =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance2 =
        nameResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act and Assert
    assertEquals(
        immutableAggregateOverlayDiagramInstance, immutableAggregateOverlayDiagramInstance2);
    assertEquals(
        immutableAggregateOverlayDiagramInstance.hashCode(),
        immutableAggregateOverlayDiagramInstance2.hashCode());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}, and {@link
   * ImmutableAggregateOverlayDiagramInstance#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}
   *   <li>{@link ImmutableAggregateOverlayDiagramInstance#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramInstance.equals(Object)",
    "int ImmutableAggregateOverlayDiagramInstance.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act and Assert
    assertEquals(
        immutableAggregateOverlayDiagramInstance, immutableAggregateOverlayDiagramInstance);
    int expectedHashCodeResult = immutableAggregateOverlayDiagramInstance.hashCode();
    assertEquals(expectedHashCodeResult, immutableAggregateOverlayDiagramInstance.hashCode());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramInstance.equals(Object)",
    "int ImmutableAggregateOverlayDiagramInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(2L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    Builder nameResult2 =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramInstance,
        nameResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramInstance.equals(Object)",
    "int ImmutableAggregateOverlayDiagramInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(2L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    Builder nameResult2 =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramInstance,
        nameResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramInstance.equals(Object)",
    "int ImmutableAggregateOverlayDiagramInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    Builder nameResult2 =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramInstance,
        nameResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramInstance.equals(Object)",
    "int ImmutableAggregateOverlayDiagramInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    Builder nameResult2 =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramInstance,
        nameResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramInstance.equals(Object)",
    "int ImmutableAggregateOverlayDiagramInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    Builder nameResult2 =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramInstance,
        nameResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramInstance.equals(Object)",
    "int ImmutableAggregateOverlayDiagramInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("2020-03-01");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    Builder nameResult2 =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramInstance,
        nameResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramInstance.equals(Object)",
    "int ImmutableAggregateOverlayDiagramInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    Builder nameResult2 =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramInstance,
        nameResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramInstance.equals(Object)",
    "int ImmutableAggregateOverlayDiagramInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Name")
            .svg("Svg")
            .build();

    Builder nameResult2 =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramInstance,
        nameResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramInstance.equals(Object)",
    "int ImmutableAggregateOverlayDiagramInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Name")
            .build();

    Builder nameResult2 =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramInstance,
        nameResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramInstance.equals(Object)",
    "int ImmutableAggregateOverlayDiagramInstance.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramInstance.equals(Object)",
    "int ImmutableAggregateOverlayDiagramInstance.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build(),
        "Different type to ImmutableAggregateOverlayDiagramInstance");
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link Json} (default constructor) Id is of forty-two.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of forty-two; when Json (default constructor) Id is of forty-two; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.fromJson(Json)"
  })
  void testFromJson_givenOfFortyTwo_whenJsonIdIsOfFortyTwo_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setDescription("Json");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    json.setLastUpdatedAt(ofResult.atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setProvenance("Json");
    json.setDiagramId(1L);
    json.setParentEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSvg("Json");
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableAggregateOverlayDiagramInstance actualFromJsonResult =
        ImmutableAggregateOverlayDiagramInstance.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals("Json", actualFromJsonResult.svg());
    assertEquals(1L, actualFromJsonResult.diagramId().longValue());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    LocalDateTime lastUpdatedAtResult = actualFromJsonResult.lastUpdatedAt();
    assertSame(ofResult, lastUpdatedAtResult.toLocalDate());
    assertSame(json.lastUpdatedAt, lastUpdatedAtResult);
    EntityReference expectedParentEntityReferenceResult = json.parentEntityReference;
    assertSame(expectedParentEntityReferenceResult, actualFromJsonResult.parentEntityReference());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Description is {@code null}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Description is 'null'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.fromJson(Json)"
  })
  void testFromJson_whenJsonDescriptionIsNull_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setDescription(null);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    json.setLastUpdatedAt(ofResult.atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setProvenance("Json");
    json.setDiagramId(1L);
    json.setParentEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSvg("Json");
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableAggregateOverlayDiagramInstance actualFromJsonResult =
        ImmutableAggregateOverlayDiagramInstance.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals("Json", actualFromJsonResult.svg());
    assertNull(actualFromJsonResult.description());
    assertEquals(1L, actualFromJsonResult.diagramId().longValue());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    LocalDateTime lastUpdatedAtResult = actualFromJsonResult.lastUpdatedAt();
    assertSame(ofResult, lastUpdatedAtResult.toLocalDate());
    assertSame(json.lastUpdatedAt, lastUpdatedAtResult);
    EntityReference expectedParentEntityReferenceResult = json.parentEntityReference;
    assertSame(expectedParentEntityReferenceResult, actualFromJsonResult.parentEntityReference());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Id is {@code null}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Id is 'null'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.fromJson(Json)"
  })
  void testFromJson_whenJsonIdIsNull_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription("Json");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    json.setLastUpdatedAt(ofResult.atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setProvenance("Json");
    json.setDiagramId(1L);
    json.setParentEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSvg("Json");
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableAggregateOverlayDiagramInstance actualFromJsonResult =
        ImmutableAggregateOverlayDiagramInstance.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals("Json", actualFromJsonResult.svg());
    assertEquals(1L, actualFromJsonResult.diagramId().longValue());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    LocalDateTime lastUpdatedAtResult = actualFromJsonResult.lastUpdatedAt();
    assertSame(ofResult, lastUpdatedAtResult.toLocalDate());
    assertSame(json.lastUpdatedAt, lastUpdatedAtResult);
    EntityReference expectedParentEntityReferenceResult = json.parentEntityReference;
    assertSame(expectedParentEntityReferenceResult, actualFromJsonResult.parentEntityReference());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Kind is {@code null}.
   *   <li>Then return kind is {@code AGGREGATE_OVERLAY_DIAGRAM_INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Kind is 'null'; then return kind is 'AGGREGATE_OVERLAY_DIAGRAM_INSTANCE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.fromJson(Json)"
  })
  void testFromJson_whenJsonKindIsNull_thenReturnKindIsAggregateOverlayDiagramInstance() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setDescription("Json");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    json.setLastUpdatedAt(ofResult.atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setProvenance("Json");
    json.setDiagramId(1L);
    json.setParentEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSvg("Json");
    json.setKind(null);

    // Act
    ImmutableAggregateOverlayDiagramInstance actualFromJsonResult =
        ImmutableAggregateOverlayDiagramInstance.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals("Json", actualFromJsonResult.svg());
    assertEquals(1L, actualFromJsonResult.diagramId().longValue());
    assertEquals(EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, actualFromJsonResult.kind());
    LocalDateTime lastUpdatedAtResult = actualFromJsonResult.lastUpdatedAt();
    assertSame(ofResult, lastUpdatedAtResult.toLocalDate());
    assertSame(json.lastUpdatedAt, lastUpdatedAtResult);
    EntityReference expectedParentEntityReferenceResult = json.parentEntityReference;
    assertSame(expectedParentEntityReferenceResult, actualFromJsonResult.parentEntityReference());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Provenance is {@code null}.
   *   <li>Then return provenance is {@code waltz}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Provenance is 'null'; then return provenance is 'waltz'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.fromJson(Json)"
  })
  void testFromJson_whenJsonProvenanceIsNull_thenReturnProvenanceIsWaltz() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setDescription("Json");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    json.setLastUpdatedAt(ofResult.atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setProvenance(null);
    json.setDiagramId(1L);
    json.setParentEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSvg("Json");
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableAggregateOverlayDiagramInstance actualFromJsonResult =
        ImmutableAggregateOverlayDiagramInstance.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.svg());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertEquals(1L, actualFromJsonResult.diagramId().longValue());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    LocalDateTime lastUpdatedAtResult = actualFromJsonResult.lastUpdatedAt();
    assertSame(ofResult, lastUpdatedAtResult.toLocalDate());
    assertSame(json.lastUpdatedAt, lastUpdatedAtResult);
    EntityReference expectedParentEntityReferenceResult = json.parentEntityReference;
    assertSame(expectedParentEntityReferenceResult, actualFromJsonResult.parentEntityReference());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAggregateOverlayDiagramInstance#description()}
   *   <li>{@link ImmutableAggregateOverlayDiagramInstance#diagramId()}
   *   <li>{@link ImmutableAggregateOverlayDiagramInstance#lastUpdatedBy()}
   *   <li>{@link ImmutableAggregateOverlayDiagramInstance#name()}
   *   <li>{@link ImmutableAggregateOverlayDiagramInstance#parentEntityReference()}
   *   <li>{@link ImmutableAggregateOverlayDiagramInstance#svg()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableAggregateOverlayDiagramInstance.description()",
    "Long ImmutableAggregateOverlayDiagramInstance.diagramId()",
    "String ImmutableAggregateOverlayDiagramInstance.lastUpdatedBy()",
    "String ImmutableAggregateOverlayDiagramInstance.name()",
    "EntityReference ImmutableAggregateOverlayDiagramInstance.parentEntityReference()",
    "String ImmutableAggregateOverlayDiagramInstance.svg()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act
    String actualDescriptionResult = immutableAggregateOverlayDiagramInstance.description();
    Long actualDiagramIdResult = immutableAggregateOverlayDiagramInstance.diagramId();
    String actualLastUpdatedByResult = immutableAggregateOverlayDiagramInstance.lastUpdatedBy();
    String actualNameResult = immutableAggregateOverlayDiagramInstance.name();
    EntityReference actualParentEntityReferenceResult =
        immutableAggregateOverlayDiagramInstance.parentEntityReference();

    // Assert
    assertTrue(actualParentEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("Name", actualNameResult);
    assertEquals("Svg", immutableAggregateOverlayDiagramInstance.svg());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, actualDiagramIdResult.longValue());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#id()}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAggregateOverlayDiagramInstance.id()"})
  void testId() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act
    Optional<Long> actualIdResult =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
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
   * Test Json {@link Json#diagramId()}.
   *
   * <p>Method under test: {@link Json#diagramId()}
   */
  @Test
  @DisplayName("Test Json diagramId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.diagramId()"})
  void testJsonDiagramId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().diagramId());
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
    assertNull(actualJson.diagramId);
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.svg);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.parentEntityReference);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test Json {@link Json#parentEntityReference()}.
   *
   * <p>Method under test: {@link Json#parentEntityReference()}
   */
  @Test
  @DisplayName("Test Json parentEntityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.parentEntityReference()"})
  void testJsonParentEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parentEntityReference());
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
   * Test Json {@link Json#svg()}.
   *
   * <p>Method under test: {@link Json#svg()}
   */
  @Test
  @DisplayName("Test Json svg()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.svg()"})
  void testJsonSvg() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().svg());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#kind()}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableAggregateOverlayDiagramInstance.kind()"})
  void testKind() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertEquals(
        EntityKind.ALL,
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableAggregateOverlayDiagramInstance.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build()
            .lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#provenance()}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAggregateOverlayDiagramInstance.provenance()"})
  void testProvenance() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertEquals(
        "Provenance",
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#toString()}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAggregateOverlayDiagramInstance.toString()"})
  void testToString() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertEquals(
        "AggregateOverlayDiagramInstance{id=1, name=Name, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01,"
            + " provenance=Provenance, diagramId=1, parentEntityReference=EntityReference{kind=ALL, id=1, entityLif"
            + "ecycleStatus=ACTIVE}, svg=Svg, kind=ALL}",
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramInstance actualWithDescriptionResult =
        immutableAggregateOverlayDiagramInstance.withDescription("42");

    // Assert
    assertEquals(immutableAggregateOverlayDiagramInstance, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("42")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramInstance actualWithDescriptionResult =
        immutableAggregateOverlayDiagramInstance.withDescription("42");

    // Assert
    assertSame(immutableAggregateOverlayDiagramInstance, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#withDiagramId(Long)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#withDiagramId(Long)}
   */
  @Test
  @DisplayName("Test withDiagramId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.withDiagramId(Long)"
  })
  void testWithDiagramId() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramInstance actualWithDiagramIdResult =
        immutableAggregateOverlayDiagramInstance.withDiagramId(1L);

    // Assert
    assertSame(immutableAggregateOverlayDiagramInstance, actualWithDiagramIdResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#withDiagramId(Long)}.
   *
   * <ul>
   *   <li>Then parentEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#withDiagramId(Long)}
   */
  @Test
  @DisplayName(
      "Test withDiagramId(Long); then parentEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.withDiagramId(Long)"
  })
  void testWithDiagramId_thenParentEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act
    ImmutableAggregateOverlayDiagramInstance actualWithDiagramIdResult =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build()
            .withDiagramId(42L);

    // Assert
    EntityReference parentEntityReferenceResult = actualWithDiagramIdResult.parentEntityReference();
    assertTrue(parentEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithDiagramIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithDiagramIdResult.name());
    assertEquals("Provenance", actualWithDiagramIdResult.provenance());
    assertEquals("Svg", actualWithDiagramIdResult.svg());
    assertEquals(
        "The characteristics of someone or something", parentEntityReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithDiagramIdResult.description());
    assertEquals(1L, parentEntityReferenceResult.id());
    assertEquals(42L, actualWithDiagramIdResult.diagramId().longValue());
    assertEquals(EntityKind.ALL, parentEntityReferenceResult.kind());
    assertEquals(EntityKind.ALL, actualWithDiagramIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithDiagramIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableAggregateOverlayDiagramInstance actualWithIdResult =
        immutableAggregateOverlayDiagramInstance.withId(optional);

    // Assert
    assertSame(immutableAggregateOverlayDiagramInstance, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then parentEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then parentEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.withId(Optional)"
  })
  void testWithIdWithOptional_thenParentEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableAggregateOverlayDiagramInstance actualWithIdResult =
        immutableAggregateOverlayDiagramInstance.withId(optional);

    // Assert
    EntityReference parentEntityReferenceResult = actualWithIdResult.parentEntityReference();
    assertTrue(parentEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("Svg", actualWithIdResult.svg());
    assertEquals(
        "The characteristics of someone or something", parentEntityReferenceResult.description());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, actualWithIdResult.diagramId().longValue());
    assertEquals(1L, parentEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, parentEntityReferenceResult.kind());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramInstance actualWithIdResult =
        immutableAggregateOverlayDiagramInstance.withId(1L);

    // Assert
    assertSame(immutableAggregateOverlayDiagramInstance, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then parentEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; then parentEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.withId(long)"
  })
  void testWithIdWithValue_thenParentEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act
    ImmutableAggregateOverlayDiagramInstance actualWithIdResult =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build()
            .withId(42L);

    // Assert
    EntityReference parentEntityReferenceResult = actualWithIdResult.parentEntityReference();
    assertTrue(parentEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("Svg", actualWithIdResult.svg());
    assertEquals(
        "The characteristics of someone or something", parentEntityReferenceResult.description());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, actualWithIdResult.diagramId().longValue());
    assertEquals(1L, parentEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, parentEntityReferenceResult.kind());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.withKind(EntityKind)"
  })
  void testWithKind() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramInstance actualWithKindResult =
        immutableAggregateOverlayDiagramInstance.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableAggregateOverlayDiagramInstance, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then parentEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#withKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withKind(EntityKind); then parentEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.withKind(EntityKind)"
  })
  void testWithKind_thenParentEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act
    ImmutableAggregateOverlayDiagramInstance actualWithKindResult =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    EntityReference parentEntityReferenceResult = actualWithKindResult.parentEntityReference();
    assertTrue(parentEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithKindResult.lastUpdatedBy());
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("Provenance", actualWithKindResult.provenance());
    assertEquals("Svg", actualWithKindResult.svg());
    assertEquals(
        "The characteristics of someone or something", parentEntityReferenceResult.description());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(1L, actualWithKindResult.diagramId().longValue());
    assertEquals(1L, parentEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, parentEntityReferenceResult.kind());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithKindResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link
   * ImmutableAggregateOverlayDiagramInstance#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramInstance actualWithLastUpdatedAtResult =
        immutableAggregateOverlayDiagramInstance.withLastUpdatedAt(
            LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableAggregateOverlayDiagramInstance, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableAggregateOverlayDiagramInstance#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramInstance actualWithLastUpdatedByResult =
        immutableAggregateOverlayDiagramInstance.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableAggregateOverlayDiagramInstance, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then parentEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAggregateOverlayDiagramInstance#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then parentEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy_thenParentEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act
    ImmutableAggregateOverlayDiagramInstance actualWithLastUpdatedByResult =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build()
            .withLastUpdatedBy("42");

    // Assert
    EntityReference parentEntityReferenceResult =
        actualWithLastUpdatedByResult.parentEntityReference();
    assertTrue(parentEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("Name", actualWithLastUpdatedByResult.name());
    assertEquals("Provenance", actualWithLastUpdatedByResult.provenance());
    assertEquals("Svg", actualWithLastUpdatedByResult.svg());
    assertEquals(
        "The characteristics of someone or something", parentEntityReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithLastUpdatedByResult.description());
    assertEquals(1L, actualWithLastUpdatedByResult.diagramId().longValue());
    assertEquals(1L, parentEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, parentEntityReferenceResult.kind());
    assertEquals(EntityKind.ALL, actualWithLastUpdatedByResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithLastUpdatedByResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.withName(String)"
  })
  void testWithName() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("42");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramInstance actualWithNameResult =
        immutableAggregateOverlayDiagramInstance.withName("42");

    // Assert
    assertSame(immutableAggregateOverlayDiagramInstance, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#withName(String)}.
   *
   * <ul>
   *   <li>Then parentEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then parentEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.withName(String)"
  })
  void testWithName_thenParentEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act
    ImmutableAggregateOverlayDiagramInstance actualWithNameResult =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build()
            .withName("42");

    // Assert
    EntityReference parentEntityReferenceResult = actualWithNameResult.parentEntityReference();
    assertTrue(parentEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithNameResult.lastUpdatedBy());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Provenance", actualWithNameResult.provenance());
    assertEquals("Svg", actualWithNameResult.svg());
    assertEquals(
        "The characteristics of someone or something", parentEntityReferenceResult.description());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1L, actualWithNameResult.diagramId().longValue());
    assertEquals(1L, parentEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, parentEntityReferenceResult.kind());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithNameResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link
   * ImmutableAggregateOverlayDiagramInstance#withParentEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableAggregateOverlayDiagramInstance#withParentEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withParentEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.withParentEntityReference(EntityReference)"
  })
  void testWithParentEntityReference() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramInstance actualWithParentEntityReferenceResult =
        immutableAggregateOverlayDiagramInstance.withParentEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableAggregateOverlayDiagramInstance, actualWithParentEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.withProvenance(String)"
  })
  void testWithProvenance() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("42")
            .svg("Svg")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramInstance actualWithProvenanceResult =
        immutableAggregateOverlayDiagramInstance.withProvenance("42");

    // Assert
    assertSame(immutableAggregateOverlayDiagramInstance, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then parentEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#withProvenance(String)}
   */
  @Test
  @DisplayName(
      "Test withProvenance(String); then parentEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.withProvenance(String)"
  })
  void testWithProvenance_thenParentEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act
    ImmutableAggregateOverlayDiagramInstance actualWithProvenanceResult =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build()
            .withProvenance("42");

    // Assert
    EntityReference parentEntityReferenceResult =
        actualWithProvenanceResult.parentEntityReference();
    assertTrue(parentEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithProvenanceResult.lastUpdatedBy());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Name", actualWithProvenanceResult.name());
    assertEquals("Svg", actualWithProvenanceResult.svg());
    assertEquals(
        "The characteristics of someone or something", parentEntityReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
    assertEquals(1L, actualWithProvenanceResult.diagramId().longValue());
    assertEquals(1L, parentEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, parentEntityReferenceResult.kind());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithProvenanceResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#withSvg(String)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#withSvg(String)}
   */
  @Test
  @DisplayName("Test withSvg(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.withSvg(String)"
  })
  void testWithSvg() {
    // Arrange
    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableAggregateOverlayDiagramInstance immutableAggregateOverlayDiagramInstance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("42")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramInstance actualWithSvgResult =
        immutableAggregateOverlayDiagramInstance.withSvg("42");

    // Assert
    assertSame(immutableAggregateOverlayDiagramInstance, actualWithSvgResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramInstance#withSvg(String)}.
   *
   * <ul>
   *   <li>Then parentEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramInstance#withSvg(String)}
   */
  @Test
  @DisplayName("Test withSvg(String); then parentEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramInstance ImmutableAggregateOverlayDiagramInstance.withSvg(String)"
  })
  void testWithSvg_thenParentEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableAggregateOverlayDiagramInstance.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act
    ImmutableAggregateOverlayDiagramInstance actualWithSvgResult =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .svg("Svg")
            .build()
            .withSvg("42");

    // Assert
    EntityReference parentEntityReferenceResult = actualWithSvgResult.parentEntityReference();
    assertTrue(parentEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithSvgResult.lastUpdatedBy());
    assertEquals("42", actualWithSvgResult.svg());
    assertEquals("Name", actualWithSvgResult.name());
    assertEquals("Provenance", actualWithSvgResult.provenance());
    assertEquals(
        "The characteristics of someone or something", parentEntityReferenceResult.description());
    assertEquals("The characteristics of someone or something", actualWithSvgResult.description());
    assertEquals(1L, actualWithSvgResult.diagramId().longValue());
    assertEquals(1L, parentEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, parentEntityReferenceResult.kind());
    assertEquals(EntityKind.ALL, actualWithSvgResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithSvgResult.lastUpdatedAt().toLocalDate());
  }
}
