package org.finos.waltz.model.entity_statistic;

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
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ParentIdProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.entity_statistic.ImmutableEntityStatisticDefinition.Builder;
import org.finos.waltz.model.entity_statistic.ImmutableEntityStatisticDefinition.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityStatisticDefinitionDiffblueTest {
  /**
   * Test Builder {@link Builder#active(boolean)}.
   *
   * <p>Method under test: {@link Builder#active(boolean)}
   */
  @Test
  @DisplayName("Test Builder active(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.active(boolean)"})
  void testBuilderActive() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act
    Builder actualActiveResult = builderResult.active(true);

    // Assert
    assertSame(builderResult, actualActiveResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#kind(EntityKind)}
   *   <li>{@link Builder#provenance(String)}
   *   <li>{@link Builder#rollupKind(RollupKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.provenance(String)",
    "Builder Builder.rollupKind(RollupKind)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L);
    Optional<Long> id = Optional.of(1L);
    Builder actualParentIdResult =
        actualIdResult.id(id).kind(EntityKind.ALL).name("Name").parentId(1L);
    Optional<Long> parentId = Optional.of(1L);
    ImmutableEntityStatisticDefinition actualImmutableEntityStatisticDefinition =
        actualParentIdResult
            .parentId(parentId)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Assert
    assertEquals("Historic Renderer", actualImmutableEntityStatisticDefinition.historicRenderer());
    assertEquals("Name", actualImmutableEntityStatisticDefinition.name());
    assertEquals("Provenance", actualImmutableEntityStatisticDefinition.provenance());
    assertEquals("Renderer", actualImmutableEntityStatisticDefinition.renderer());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableEntityStatisticDefinition.description());
    assertEquals(EntityKind.ALL, actualImmutableEntityStatisticDefinition.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, actualImmutableEntityStatisticDefinition.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, actualImmutableEntityStatisticDefinition.category());
    assertEquals(StatisticType.BOOLEAN, actualImmutableEntityStatisticDefinition.type());
    assertTrue(actualImmutableEntityStatisticDefinition.active());
    assertTrue(actualImmutableEntityStatisticDefinition.entityVisibility());
    assertTrue(actualImmutableEntityStatisticDefinition.rollupVisibility());
  }

  /**
   * Test Builder {@link Builder#category(StatisticCategory)}.
   *
   * <p>Method under test: {@link Builder#category(StatisticCategory)}
   */
  @Test
  @DisplayName("Test Builder category(StatisticCategory)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.category(StatisticCategory)"})
  void testBuilderCategory() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act
    Builder actualCategoryResult = builderResult.category(StatisticCategory.COMPLIANCE);

    // Assert
    assertSame(builderResult, actualCategoryResult);
  }

  /**
   * Test Builder {@link Builder#entityVisibility(Boolean)}.
   *
   * <p>Method under test: {@link Builder#entityVisibility(Boolean)}
   */
  @Test
  @DisplayName("Test Builder entityVisibility(Boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityVisibility(Boolean)"})
  void testBuilderEntityVisibility() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act
    Builder actualEntityVisibilityResult = builderResult.entityVisibility(true);

    // Assert
    assertSame(builderResult, actualEntityVisibilityResult);
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
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    ImmutableEntityStatisticDefinition instance =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableEntityStatisticDefinition actualImmutableEntityStatisticDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityStatisticDefinition);
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
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

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
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

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
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    ImmutableEntityStatisticDefinition instance =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((EntityKindProvider) instance);

    // Assert
    ImmutableEntityStatisticDefinition actualImmutableEntityStatisticDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityStatisticDefinition);
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
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

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
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Test Builder {@link Builder#from(EntityStatisticDefinition)} with {@code
   * EntityStatisticDefinition}.
   *
   * <p>Method under test: {@link Builder#from(EntityStatisticDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(EntityStatisticDefinition) with 'EntityStatisticDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityStatisticDefinition)"})
  void testBuilderFromWithEntityStatisticDefinition() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    ImmutableEntityStatisticDefinition instance =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityStatisticDefinition actualImmutableEntityStatisticDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityStatisticDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityStatisticDefinition)} with {@code
   * EntityStatisticDefinition}.
   *
   * <p>Method under test: {@link Builder#from(EntityStatisticDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(EntityStatisticDefinition) with 'EntityStatisticDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityStatisticDefinition)"})
  void testBuilderFromWithEntityStatisticDefinition2() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    ImmutableEntityStatisticDefinition instance =
        ImmutableEntityStatisticDefinition.builder()
            .active(false)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityStatisticDefinition actualImmutableEntityStatisticDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityStatisticDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityStatisticDefinition)} with {@code
   * EntityStatisticDefinition}.
   *
   * <p>Method under test: {@link Builder#from(EntityStatisticDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(EntityStatisticDefinition) with 'EntityStatisticDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityStatisticDefinition)"})
  void testBuilderFromWithEntityStatisticDefinition3() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    ImmutableEntityStatisticDefinition instance =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description(null)
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityStatisticDefinition actualImmutableEntityStatisticDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityStatisticDefinition);
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
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    ImmutableEntityStatisticDefinition instance =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableEntityStatisticDefinition actualImmutableEntityStatisticDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityStatisticDefinition);
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
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

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
   *   <li>Given of one.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of one; when IdProvider id() return of one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfOne_whenIdProviderIdReturnOfOne() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(1L);
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
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
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
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    ImmutableEntityStatisticDefinition instance =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableEntityStatisticDefinition actualImmutableEntityStatisticDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityStatisticDefinition);
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
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    ImmutableEntityStatisticDefinition instance =
        ImmutableEntityStatisticDefinition.builder()
            .active(false)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableEntityStatisticDefinition actualImmutableEntityStatisticDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityStatisticDefinition);
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
  void testBuilderFromWithNameProvider3() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    ImmutableEntityStatisticDefinition instance =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description(null)
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableEntityStatisticDefinition actualImmutableEntityStatisticDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityStatisticDefinition);
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
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    ImmutableEntityStatisticDefinition instance =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ParentIdProvider) instance);

    // Assert
    ImmutableEntityStatisticDefinition actualImmutableEntityStatisticDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityStatisticDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'; given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentId()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ParentIdProvider) with 'ParentIdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    ParentIdProvider instance = mock(ParentIdProvider.class);
    when(instance.parentId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).parentId();
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
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

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
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    ImmutableEntityStatisticDefinition instance =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ProvenanceProvider) instance);

    // Assert
    ImmutableEntityStatisticDefinition actualImmutableEntityStatisticDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityStatisticDefinition);
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
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

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
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

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
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider5() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    ImmutableEntityStatisticValue.Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                currentResult
                    .entity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .outcome("Outcome")
                    .provenance("Provenance")
                    .reason("Just cause")
                    .state(StatisticValueState.EXEMPT)
                    .statisticId(1L)
                    .value("42")
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
  void testBuilderFromWithProvenanceProvider6() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    ImmutableEntityStatisticDefinition instance =
        ImmutableEntityStatisticDefinition.builder()
            .active(false)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ProvenanceProvider) instance);

    // Assert
    ImmutableEntityStatisticDefinition actualImmutableEntityStatisticDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityStatisticDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#historicRenderer(String)}.
   *
   * <ul>
   *   <li>When {@code Historic Renderer}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#historicRenderer(String)}
   */
  @Test
  @DisplayName(
      "Test Builder historicRenderer(String); when 'Historic Renderer'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.historicRenderer(String)"})
  void testBuilderHistoricRenderer_whenHistoricRenderer_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act
    Builder actualHistoricRendererResult = builderResult.historicRenderer("Historic Renderer");

    // Assert
    assertSame(builderResult, actualHistoricRendererResult);
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
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

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
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    Optional<Long> id = Optional.of(1L);

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
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#parentId(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#parentId(long)}
   */
  @Test
  @DisplayName("Test Builder parentId(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentId(long)"})
  void testBuilderParentIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act
    Builder actualParentIdResult = builderResult.parentId(1L);

    // Assert
    assertSame(builderResult, actualParentIdResult);
  }

  /**
   * Test Builder {@link Builder#parentId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#parentId(Optional)}
   */
  @Test
  @DisplayName("Test Builder parentId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentId(Optional)"})
  void testBuilderParentIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    Optional<Long> parentId = Optional.of(1L);

    // Act
    Builder actualParentIdResult = builderResult.parentId(parentId);

    // Assert
    assertSame(builderResult, actualParentIdResult);
  }

  /**
   * Test Builder {@link Builder#renderer(String)}.
   *
   * <ul>
   *   <li>When {@code Renderer}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#renderer(String)}
   */
  @Test
  @DisplayName("Test Builder renderer(String); when 'Renderer'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.renderer(String)"})
  void testBuilderRenderer_whenRenderer_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act
    Builder actualRendererResult = builderResult.renderer("Renderer");

    // Assert
    assertSame(builderResult, actualRendererResult);
  }

  /**
   * Test Builder {@link Builder#rollupVisibility(Boolean)}.
   *
   * <p>Method under test: {@link Builder#rollupVisibility(Boolean)}
   */
  @Test
  @DisplayName("Test Builder rollupVisibility(Boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.rollupVisibility(Boolean)"})
  void testBuilderRollupVisibility() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act
    Builder actualRollupVisibilityResult = builderResult.rollupVisibility(true);

    // Assert
    assertSame(builderResult, actualRollupVisibilityResult);
  }

  /**
   * Test Builder {@link Builder#type(StatisticType)}.
   *
   * <p>Method under test: {@link Builder#type(StatisticType)}
   */
  @Test
  @DisplayName("Test Builder type(StatisticType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.type(StatisticType)"})
  void testBuilderType() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act
    Builder actualTypeResult = builderResult.type(StatisticType.BOOLEAN);

    // Assert
    assertSame(builderResult, actualTypeResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#copyOf(EntityStatisticDefinition)}.
   *
   * <ul>
   *   <li>Then return {@code Historic Renderer}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableEntityStatisticDefinition#copyOf(EntityStatisticDefinition)}
   */
  @Test
  @DisplayName("Test copyOf(EntityStatisticDefinition); then return 'Historic Renderer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.copyOf(EntityStatisticDefinition)"
  })
  void testCopyOf_thenReturnHistoricRenderer() {
    // Arrange
    ImmutableEntityStatisticDefinition instance =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    ImmutableEntityStatisticDefinition actualCopyOfResult =
        ImmutableEntityStatisticDefinition.copyOf(instance);

    // Assert
    assertEquals("Historic Renderer", actualCopyOfResult.historicRenderer());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("Renderer", actualCopyOfResult.renderer());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, actualCopyOfResult.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, actualCopyOfResult.category());
    assertEquals(StatisticType.BOOLEAN, actualCopyOfResult.type());
    assertTrue(actualCopyOfResult.active());
    assertTrue(actualCopyOfResult.entityVisibility());
    assertTrue(actualCopyOfResult.rollupVisibility());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#equals(Object)}, and {@link
   * ImmutableEntityStatisticDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityStatisticDefinition#equals(Object)}
   *   <li>{@link ImmutableEntityStatisticDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticDefinition.equals(Object)",
    "int ImmutableEntityStatisticDefinition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition2 =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act and Assert
    assertEquals(immutableEntityStatisticDefinition, immutableEntityStatisticDefinition2);
    assertEquals(
        immutableEntityStatisticDefinition.hashCode(),
        immutableEntityStatisticDefinition2.hashCode());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#equals(Object)}, and {@link
   * ImmutableEntityStatisticDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityStatisticDefinition#equals(Object)}
   *   <li>{@link ImmutableEntityStatisticDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticDefinition.equals(Object)",
    "int ImmutableEntityStatisticDefinition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act and Assert
    assertEquals(immutableEntityStatisticDefinition, immutableEntityStatisticDefinition);
    int expectedHashCodeResult = immutableEntityStatisticDefinition.hashCode();
    assertEquals(expectedHashCodeResult, immutableEntityStatisticDefinition.hashCode());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticDefinition.equals(Object)",
    "int ImmutableEntityStatisticDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(false)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityStatisticDefinition,
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticDefinition.equals(Object)",
    "int ImmutableEntityStatisticDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.DATA_QUALITY)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityStatisticDefinition,
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticDefinition.equals(Object)",
    "int ImmutableEntityStatisticDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(false)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityStatisticDefinition,
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticDefinition.equals(Object)",
    "int ImmutableEntityStatisticDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityStatisticDefinition,
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticDefinition.equals(Object)",
    "int ImmutableEntityStatisticDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(2L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityStatisticDefinition,
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticDefinition.equals(Object)",
    "int ImmutableEntityStatisticDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityStatisticDefinition,
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticDefinition.equals(Object)",
    "int ImmutableEntityStatisticDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Provenance")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityStatisticDefinition,
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticDefinition.equals(Object)",
    "int ImmutableEntityStatisticDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(2L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityStatisticDefinition,
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticDefinition.equals(Object)",
    "int ImmutableEntityStatisticDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Name")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityStatisticDefinition,
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticDefinition.equals(Object)",
    "int ImmutableEntityStatisticDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Name")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityStatisticDefinition,
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticDefinition.equals(Object)",
    "int ImmutableEntityStatisticDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.SUM_BY_VALUE)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityStatisticDefinition,
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticDefinition.equals(Object)",
    "int ImmutableEntityStatisticDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(false)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityStatisticDefinition,
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticDefinition.equals(Object)",
    "int ImmutableEntityStatisticDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.DATE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityStatisticDefinition,
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticDefinition.equals(Object)",
    "int ImmutableEntityStatisticDefinition.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticDefinition.equals(Object)",
    "int ImmutableEntityStatisticDefinition.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build(),
        "Different type to ImmutableEntityStatisticDefinition");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityStatisticDefinition#active()}
   *   <li>{@link ImmutableEntityStatisticDefinition#category()}
   *   <li>{@link ImmutableEntityStatisticDefinition#description()}
   *   <li>{@link ImmutableEntityStatisticDefinition#entityVisibility()}
   *   <li>{@link ImmutableEntityStatisticDefinition#historicRenderer()}
   *   <li>{@link ImmutableEntityStatisticDefinition#name()}
   *   <li>{@link ImmutableEntityStatisticDefinition#renderer()}
   *   <li>{@link ImmutableEntityStatisticDefinition#rollupVisibility()}
   *   <li>{@link ImmutableEntityStatisticDefinition#type()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticDefinition.active()",
    "StatisticCategory ImmutableEntityStatisticDefinition.category()",
    "String ImmutableEntityStatisticDefinition.description()",
    "Boolean ImmutableEntityStatisticDefinition.entityVisibility()",
    "String ImmutableEntityStatisticDefinition.historicRenderer()",
    "String ImmutableEntityStatisticDefinition.name()",
    "String ImmutableEntityStatisticDefinition.renderer()",
    "Boolean ImmutableEntityStatisticDefinition.rollupVisibility()",
    "StatisticType ImmutableEntityStatisticDefinition.type()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    boolean actualActiveResult = immutableEntityStatisticDefinition.active();
    StatisticCategory actualCategoryResult = immutableEntityStatisticDefinition.category();
    String actualDescriptionResult = immutableEntityStatisticDefinition.description();
    Boolean actualEntityVisibilityResult = immutableEntityStatisticDefinition.entityVisibility();
    String actualHistoricRendererResult = immutableEntityStatisticDefinition.historicRenderer();
    String actualNameResult = immutableEntityStatisticDefinition.name();
    String actualRendererResult = immutableEntityStatisticDefinition.renderer();
    Boolean actualRollupVisibilityResult = immutableEntityStatisticDefinition.rollupVisibility();

    // Assert
    assertEquals("Historic Renderer", actualHistoricRendererResult);
    assertEquals("Name", actualNameResult);
    assertEquals("Renderer", actualRendererResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(StatisticCategory.COMPLIANCE, actualCategoryResult);
    assertEquals(StatisticType.BOOLEAN, immutableEntityStatisticDefinition.type());
    assertTrue(actualActiveResult);
    assertTrue(actualEntityVisibilityResult);
    assertTrue(actualRollupVisibilityResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#id()}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableEntityStatisticDefinition.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#active()}.
   *
   * <p>Method under test: {@link Json#active()}
   */
  @Test
  @DisplayName("Test Json active()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.active()"})
  void testJsonActive() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().active());
  }

  /**
   * Test Json {@link Json#category()}.
   *
   * <p>Method under test: {@link Json#category()}
   */
  @Test
  @DisplayName("Test Json category()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StatisticCategory Json.category()"})
  void testJsonCategory() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().category());
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
   * Test Json {@link Json#entityVisibility()}.
   *
   * <p>Method under test: {@link Json#entityVisibility()}
   */
  @Test
  @DisplayName("Test Json entityVisibility()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean Json.entityVisibility()"})
  void testJsonEntityVisibility() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityVisibility());
  }

  /**
   * Test Json {@link Json#historicRenderer()}.
   *
   * <p>Method under test: {@link Json#historicRenderer()}
   */
  @Test
  @DisplayName("Test Json historicRenderer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.historicRenderer()"})
  void testJsonHistoricRenderer() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().historicRenderer());
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
    assertNull(actualJson.entityVisibility);
    assertNull(actualJson.rollupVisibility);
    assertNull(actualJson.description);
    assertNull(actualJson.historicRenderer);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.renderer);
    assertNull(actualJson.kind);
    assertNull(actualJson.rollupKind);
    assertNull(actualJson.category);
    assertNull(actualJson.type);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.parentId.isPresent());
    assertFalse(actualJson.active);
    assertFalse(actualJson.activeIsSet);
  }

  /**
   * Test Json {@link Json#parentId()}.
   *
   * <p>Method under test: {@link Json#parentId()}
   */
  @Test
  @DisplayName("Test Json parentId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.parentId()"})
  void testJsonParentId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parentId());
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
   * Test Json {@link Json#renderer()}.
   *
   * <p>Method under test: {@link Json#renderer()}
   */
  @Test
  @DisplayName("Test Json renderer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.renderer()"})
  void testJsonRenderer() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().renderer());
  }

  /**
   * Test Json {@link Json#rollupKind()}.
   *
   * <p>Method under test: {@link Json#rollupKind()}
   */
  @Test
  @DisplayName("Test Json rollupKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RollupKind Json.rollupKind()"})
  void testJsonRollupKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().rollupKind());
  }

  /**
   * Test Json {@link Json#rollupVisibility()}.
   *
   * <p>Method under test: {@link Json#rollupVisibility()}
   */
  @Test
  @DisplayName("Test Json rollupVisibility()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean Json.rollupVisibility()"})
  void testJsonRollupVisibility() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().rollupVisibility());
  }

  /**
   * Test Json {@link Json#setActive(boolean)}.
   *
   * <p>Method under test: {@link Json#setActive(boolean)}
   */
  @Test
  @DisplayName("Test Json setActive(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setActive(boolean)"})
  void testJsonSetActive() {
    // Arrange
    Json json = new Json();

    // Act
    json.setActive(true);

    // Assert
    assertTrue(json.active);
    assertTrue(json.activeIsSet);
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
  @MethodsUnderTest({"StatisticType Json.type()"})
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().type());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#kind()}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableEntityStatisticDefinition.kind()"})
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#parentId()}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#parentId()}
   */
  @Test
  @DisplayName("Test parentId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableEntityStatisticDefinition.parentId()"})
  void testParentId() {
    // Arrange and Act
    Optional<Long> actualParentIdResult =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build()
            .parentId();

    // Assert
    assertEquals(1L, actualParentIdResult.get().longValue());
    assertTrue(actualParentIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#provenance()}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableEntityStatisticDefinition.provenance()"})
  void testProvenance() {
    // Arrange, Act and Assert
    assertEquals(
        "Provenance",
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#rollupKind()}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#rollupKind()}
   */
  @Test
  @DisplayName("Test rollupKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RollupKind ImmutableEntityStatisticDefinition.rollupKind()"})
  void testRollupKind() {
    // Arrange, Act and Assert
    assertEquals(
        RollupKind.COUNT_BY_ENTITY,
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build()
            .rollupKind());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#toString()}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableEntityStatisticDefinition.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "EntityStatisticDefinition{id=1, name=Name, provenance=Provenance, parentId=1, type=BOOLEAN,"
            + " category=COMPLIANCE, active=true, rollupKind=COUNT_BY_ENTITY, renderer=Renderer, historicRenderer=Historic"
            + " Renderer, entityVisibility=true, rollupVisibility=true, kind=ALL}",
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withActive(boolean)}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withActive(boolean)}
   */
  @Test
  @DisplayName("Test withActive(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withActive(boolean)"
  })
  void testWithActive() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    ImmutableEntityStatisticDefinition actualWithActiveResult =
        immutableEntityStatisticDefinition.withActive(true);

    // Assert
    assertSame(immutableEntityStatisticDefinition, actualWithActiveResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withActive(boolean)}.
   *
   * <ul>
   *   <li>Then return {@code Historic Renderer}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withActive(boolean)}
   */
  @Test
  @DisplayName("Test withActive(boolean); then return 'Historic Renderer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withActive(boolean)"
  })
  void testWithActive_thenReturnHistoricRenderer() {
    // Arrange and Act
    ImmutableEntityStatisticDefinition actualWithActiveResult =
        ImmutableEntityStatisticDefinition.builder()
            .active(false)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build()
            .withActive(true);

    // Assert
    assertEquals("Historic Renderer", actualWithActiveResult.historicRenderer());
    assertEquals("Name", actualWithActiveResult.name());
    assertEquals("Provenance", actualWithActiveResult.provenance());
    assertEquals("Renderer", actualWithActiveResult.renderer());
    assertEquals(
        "The characteristics of someone or something", actualWithActiveResult.description());
    assertEquals(EntityKind.ALL, actualWithActiveResult.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, actualWithActiveResult.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, actualWithActiveResult.category());
    assertEquals(StatisticType.BOOLEAN, actualWithActiveResult.type());
    assertTrue(actualWithActiveResult.active());
    assertTrue(actualWithActiveResult.entityVisibility());
    assertTrue(actualWithActiveResult.rollupVisibility());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withCategory(StatisticCategory)}.
   *
   * <p>Method under test: {@link
   * ImmutableEntityStatisticDefinition#withCategory(StatisticCategory)}
   */
  @Test
  @DisplayName("Test withCategory(StatisticCategory)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withCategory(StatisticCategory)"
  })
  void testWithCategory() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    ImmutableEntityStatisticDefinition actualWithCategoryResult =
        immutableEntityStatisticDefinition.withCategory(StatisticCategory.COMPLIANCE);

    // Assert
    assertSame(immutableEntityStatisticDefinition, actualWithCategoryResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withCategory(StatisticCategory)}.
   *
   * <ul>
   *   <li>Then return {@code Historic Renderer}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableEntityStatisticDefinition#withCategory(StatisticCategory)}
   */
  @Test
  @DisplayName("Test withCategory(StatisticCategory); then return 'Historic Renderer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withCategory(StatisticCategory)"
  })
  void testWithCategory_thenReturnHistoricRenderer() {
    // Arrange and Act
    ImmutableEntityStatisticDefinition actualWithCategoryResult =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.DATA_QUALITY)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build()
            .withCategory(StatisticCategory.COMPLIANCE);

    // Assert
    assertEquals("Historic Renderer", actualWithCategoryResult.historicRenderer());
    assertEquals("Name", actualWithCategoryResult.name());
    assertEquals("Provenance", actualWithCategoryResult.provenance());
    assertEquals("Renderer", actualWithCategoryResult.renderer());
    assertEquals(
        "The characteristics of someone or something", actualWithCategoryResult.description());
    assertEquals(EntityKind.ALL, actualWithCategoryResult.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, actualWithCategoryResult.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, actualWithCategoryResult.category());
    assertEquals(StatisticType.BOOLEAN, actualWithCategoryResult.type());
    assertTrue(actualWithCategoryResult.active());
    assertTrue(actualWithCategoryResult.entityVisibility());
    assertTrue(actualWithCategoryResult.rollupVisibility());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    ImmutableEntityStatisticDefinition actualWithDescriptionResult =
        immutableEntityStatisticDefinition.withDescription("42");

    // Assert
    assertEquals(immutableEntityStatisticDefinition, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("42")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    ImmutableEntityStatisticDefinition actualWithDescriptionResult =
        immutableEntityStatisticDefinition.withDescription("42");

    // Assert
    assertSame(immutableEntityStatisticDefinition, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withEntityVisibility(Boolean)}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withEntityVisibility(Boolean)}
   */
  @Test
  @DisplayName("Test withEntityVisibility(Boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withEntityVisibility(Boolean)"
  })
  void testWithEntityVisibility() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    ImmutableEntityStatisticDefinition actualWithEntityVisibilityResult =
        immutableEntityStatisticDefinition.withEntityVisibility(true);

    // Assert
    assertSame(immutableEntityStatisticDefinition, actualWithEntityVisibilityResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withEntityVisibility(Boolean)}.
   *
   * <ul>
   *   <li>Then return {@code Historic Renderer}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withEntityVisibility(Boolean)}
   */
  @Test
  @DisplayName("Test withEntityVisibility(Boolean); then return 'Historic Renderer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withEntityVisibility(Boolean)"
  })
  void testWithEntityVisibility_thenReturnHistoricRenderer() {
    // Arrange and Act
    ImmutableEntityStatisticDefinition actualWithEntityVisibilityResult =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(false)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build()
            .withEntityVisibility(true);

    // Assert
    assertEquals("Historic Renderer", actualWithEntityVisibilityResult.historicRenderer());
    assertEquals("Name", actualWithEntityVisibilityResult.name());
    assertEquals("Provenance", actualWithEntityVisibilityResult.provenance());
    assertEquals("Renderer", actualWithEntityVisibilityResult.renderer());
    assertEquals(
        "The characteristics of someone or something",
        actualWithEntityVisibilityResult.description());
    assertEquals(EntityKind.ALL, actualWithEntityVisibilityResult.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, actualWithEntityVisibilityResult.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, actualWithEntityVisibilityResult.category());
    assertEquals(StatisticType.BOOLEAN, actualWithEntityVisibilityResult.type());
    assertTrue(actualWithEntityVisibilityResult.active());
    assertTrue(actualWithEntityVisibilityResult.entityVisibility());
    assertTrue(actualWithEntityVisibilityResult.rollupVisibility());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withHistoricRenderer(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withHistoricRenderer(String)}
   */
  @Test
  @DisplayName("Test withHistoricRenderer(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withHistoricRenderer(String)"
  })
  void testWithHistoricRenderer() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    ImmutableEntityStatisticDefinition actualWithHistoricRendererResult =
        immutableEntityStatisticDefinition.withHistoricRenderer("42");

    // Assert
    assertSame(immutableEntityStatisticDefinition, actualWithHistoricRendererResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withHistoricRenderer(String)}.
   *
   * <ul>
   *   <li>Then return historicRenderer is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withHistoricRenderer(String)}
   */
  @Test
  @DisplayName("Test withHistoricRenderer(String); then return historicRenderer is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withHistoricRenderer(String)"
  })
  void testWithHistoricRenderer_thenReturnHistoricRendererIs42() {
    // Arrange and Act
    ImmutableEntityStatisticDefinition actualWithHistoricRendererResult =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build()
            .withHistoricRenderer("42");

    // Assert
    assertEquals("42", actualWithHistoricRendererResult.historicRenderer());
    assertEquals("Name", actualWithHistoricRendererResult.name());
    assertEquals("Provenance", actualWithHistoricRendererResult.provenance());
    assertEquals("Renderer", actualWithHistoricRendererResult.renderer());
    assertEquals(
        "The characteristics of someone or something",
        actualWithHistoricRendererResult.description());
    assertEquals(EntityKind.ALL, actualWithHistoricRendererResult.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, actualWithHistoricRendererResult.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, actualWithHistoricRendererResult.category());
    assertEquals(StatisticType.BOOLEAN, actualWithHistoricRendererResult.type());
    assertTrue(actualWithHistoricRendererResult.active());
    assertTrue(actualWithHistoricRendererResult.entityVisibility());
    assertTrue(actualWithHistoricRendererResult.rollupVisibility());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableEntityStatisticDefinition actualWithIdResult =
        immutableEntityStatisticDefinition.withId(optional);

    // Assert
    assertSame(immutableEntityStatisticDefinition, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Historic Renderer}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return 'Historic Renderer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withId(Optional)"
  })
  void testWithIdWithOptional_thenReturnHistoricRenderer() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(2L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableEntityStatisticDefinition actualWithIdResult =
        immutableEntityStatisticDefinition.withId(optional);

    // Assert
    assertEquals("Historic Renderer", actualWithIdResult.historicRenderer());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("Renderer", actualWithIdResult.renderer());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, actualWithIdResult.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, actualWithIdResult.category());
    assertEquals(StatisticType.BOOLEAN, actualWithIdResult.type());
    assertTrue(actualWithIdResult.active());
    assertTrue(actualWithIdResult.entityVisibility());
    assertTrue(actualWithIdResult.rollupVisibility());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    ImmutableEntityStatisticDefinition actualWithIdResult =
        immutableEntityStatisticDefinition.withId(1L);

    // Assert
    assertSame(immutableEntityStatisticDefinition, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Historic Renderer}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Historic Renderer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withId(long)"
  })
  void testWithIdWithValue_whenFortyTwo_thenReturnHistoricRenderer() {
    // Arrange and Act
    ImmutableEntityStatisticDefinition actualWithIdResult =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build()
            .withId(42L);

    // Assert
    assertEquals("Historic Renderer", actualWithIdResult.historicRenderer());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("Renderer", actualWithIdResult.renderer());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, actualWithIdResult.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, actualWithIdResult.category());
    assertEquals(StatisticType.BOOLEAN, actualWithIdResult.type());
    assertTrue(actualWithIdResult.active());
    assertTrue(actualWithIdResult.entityVisibility());
    assertTrue(actualWithIdResult.rollupVisibility());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withKind(EntityKind)"
  })
  void testWithKind() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    ImmutableEntityStatisticDefinition actualWithKindResult =
        immutableEntityStatisticDefinition.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableEntityStatisticDefinition, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return {@code Historic Renderer}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return 'Historic Renderer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withKind(EntityKind)"
  })
  void testWithKind_thenReturnHistoricRenderer() {
    // Arrange and Act
    ImmutableEntityStatisticDefinition actualWithKindResult =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("Historic Renderer", actualWithKindResult.historicRenderer());
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("Provenance", actualWithKindResult.provenance());
    assertEquals("Renderer", actualWithKindResult.renderer());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, actualWithKindResult.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, actualWithKindResult.category());
    assertEquals(StatisticType.BOOLEAN, actualWithKindResult.type());
    assertTrue(actualWithKindResult.active());
    assertTrue(actualWithKindResult.entityVisibility());
    assertTrue(actualWithKindResult.rollupVisibility());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("42")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    ImmutableEntityStatisticDefinition actualWithNameResult =
        immutableEntityStatisticDefinition.withName("42");

    // Assert
    assertSame(immutableEntityStatisticDefinition, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withName(String)"
  })
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableEntityStatisticDefinition actualWithNameResult =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Historic Renderer", actualWithNameResult.historicRenderer());
    assertEquals("Provenance", actualWithNameResult.provenance());
    assertEquals("Renderer", actualWithNameResult.renderer());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, actualWithNameResult.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, actualWithNameResult.category());
    assertEquals(StatisticType.BOOLEAN, actualWithNameResult.type());
    assertTrue(actualWithNameResult.active());
    assertTrue(actualWithNameResult.entityVisibility());
    assertTrue(actualWithNameResult.rollupVisibility());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withParentId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withParentId(Optional)}
   */
  @Test
  @DisplayName("Test withParentId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withParentId(Optional)"
  })
  void testWithParentIdWithOptional() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableEntityStatisticDefinition actualWithParentIdResult =
        immutableEntityStatisticDefinition.withParentId(optional);

    // Assert
    assertSame(immutableEntityStatisticDefinition, actualWithParentIdResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withParentId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Historic Renderer}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withParentId(Optional)}
   */
  @Test
  @DisplayName("Test withParentId(Optional) with 'optional'; then return 'Historic Renderer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withParentId(Optional)"
  })
  void testWithParentIdWithOptional_thenReturnHistoricRenderer() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(2L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableEntityStatisticDefinition actualWithParentIdResult =
        immutableEntityStatisticDefinition.withParentId(optional);

    // Assert
    assertEquals("Historic Renderer", actualWithParentIdResult.historicRenderer());
    assertEquals("Name", actualWithParentIdResult.name());
    assertEquals("Provenance", actualWithParentIdResult.provenance());
    assertEquals("Renderer", actualWithParentIdResult.renderer());
    assertEquals(
        "The characteristics of someone or something", actualWithParentIdResult.description());
    assertEquals(EntityKind.ALL, actualWithParentIdResult.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, actualWithParentIdResult.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, actualWithParentIdResult.category());
    assertEquals(StatisticType.BOOLEAN, actualWithParentIdResult.type());
    assertTrue(actualWithParentIdResult.active());
    assertTrue(actualWithParentIdResult.entityVisibility());
    assertTrue(actualWithParentIdResult.rollupVisibility());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withParentId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withParentId(long)}
   */
  @Test
  @DisplayName("Test withParentId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withParentId(long)"
  })
  void testWithParentIdWithValue() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    ImmutableEntityStatisticDefinition actualWithParentIdResult =
        immutableEntityStatisticDefinition.withParentId(1L);

    // Assert
    assertSame(immutableEntityStatisticDefinition, actualWithParentIdResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withParentId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Historic Renderer}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withParentId(long)}
   */
  @Test
  @DisplayName(
      "Test withParentId(long) with 'value'; when forty-two; then return 'Historic Renderer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withParentId(long)"
  })
  void testWithParentIdWithValue_whenFortyTwo_thenReturnHistoricRenderer() {
    // Arrange and Act
    ImmutableEntityStatisticDefinition actualWithParentIdResult =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build()
            .withParentId(42L);

    // Assert
    assertEquals("Historic Renderer", actualWithParentIdResult.historicRenderer());
    assertEquals("Name", actualWithParentIdResult.name());
    assertEquals("Provenance", actualWithParentIdResult.provenance());
    assertEquals("Renderer", actualWithParentIdResult.renderer());
    assertEquals(
        "The characteristics of someone or something", actualWithParentIdResult.description());
    assertEquals(EntityKind.ALL, actualWithParentIdResult.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, actualWithParentIdResult.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, actualWithParentIdResult.category());
    assertEquals(StatisticType.BOOLEAN, actualWithParentIdResult.type());
    assertTrue(actualWithParentIdResult.active());
    assertTrue(actualWithParentIdResult.entityVisibility());
    assertTrue(actualWithParentIdResult.rollupVisibility());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withProvenance(String)"
  })
  void testWithProvenance() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("42")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    ImmutableEntityStatisticDefinition actualWithProvenanceResult =
        immutableEntityStatisticDefinition.withProvenance("42");

    // Assert
    assertSame(immutableEntityStatisticDefinition, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return provenance is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then return provenance is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withProvenance(String)"
  })
  void testWithProvenance_thenReturnProvenanceIs42() {
    // Arrange and Act
    ImmutableEntityStatisticDefinition actualWithProvenanceResult =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build()
            .withProvenance("42");

    // Assert
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Historic Renderer", actualWithProvenanceResult.historicRenderer());
    assertEquals("Name", actualWithProvenanceResult.name());
    assertEquals("Renderer", actualWithProvenanceResult.renderer());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, actualWithProvenanceResult.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, actualWithProvenanceResult.category());
    assertEquals(StatisticType.BOOLEAN, actualWithProvenanceResult.type());
    assertTrue(actualWithProvenanceResult.active());
    assertTrue(actualWithProvenanceResult.entityVisibility());
    assertTrue(actualWithProvenanceResult.rollupVisibility());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withRenderer(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withRenderer(String)}
   */
  @Test
  @DisplayName("Test withRenderer(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withRenderer(String)"
  })
  void testWithRenderer() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("42")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    ImmutableEntityStatisticDefinition actualWithRendererResult =
        immutableEntityStatisticDefinition.withRenderer("42");

    // Assert
    assertSame(immutableEntityStatisticDefinition, actualWithRendererResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withRenderer(String)}.
   *
   * <ul>
   *   <li>Then return renderer is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withRenderer(String)}
   */
  @Test
  @DisplayName("Test withRenderer(String); then return renderer is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withRenderer(String)"
  })
  void testWithRenderer_thenReturnRendererIs42() {
    // Arrange and Act
    ImmutableEntityStatisticDefinition actualWithRendererResult =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build()
            .withRenderer("42");

    // Assert
    assertEquals("42", actualWithRendererResult.renderer());
    assertEquals("Historic Renderer", actualWithRendererResult.historicRenderer());
    assertEquals("Name", actualWithRendererResult.name());
    assertEquals("Provenance", actualWithRendererResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithRendererResult.description());
    assertEquals(EntityKind.ALL, actualWithRendererResult.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, actualWithRendererResult.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, actualWithRendererResult.category());
    assertEquals(StatisticType.BOOLEAN, actualWithRendererResult.type());
    assertTrue(actualWithRendererResult.active());
    assertTrue(actualWithRendererResult.entityVisibility());
    assertTrue(actualWithRendererResult.rollupVisibility());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withRollupKind(RollupKind)}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withRollupKind(RollupKind)}
   */
  @Test
  @DisplayName("Test withRollupKind(RollupKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withRollupKind(RollupKind)"
  })
  void testWithRollupKind() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    ImmutableEntityStatisticDefinition actualWithRollupKindResult =
        immutableEntityStatisticDefinition.withRollupKind(RollupKind.COUNT_BY_ENTITY);

    // Assert
    assertSame(immutableEntityStatisticDefinition, actualWithRollupKindResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withRollupKind(RollupKind)}.
   *
   * <ul>
   *   <li>Then return {@code Historic Renderer}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withRollupKind(RollupKind)}
   */
  @Test
  @DisplayName("Test withRollupKind(RollupKind); then return 'Historic Renderer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withRollupKind(RollupKind)"
  })
  void testWithRollupKind_thenReturnHistoricRenderer() {
    // Arrange and Act
    ImmutableEntityStatisticDefinition actualWithRollupKindResult =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.SUM_BY_VALUE)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build()
            .withRollupKind(RollupKind.COUNT_BY_ENTITY);

    // Assert
    assertEquals("Historic Renderer", actualWithRollupKindResult.historicRenderer());
    assertEquals("Name", actualWithRollupKindResult.name());
    assertEquals("Provenance", actualWithRollupKindResult.provenance());
    assertEquals("Renderer", actualWithRollupKindResult.renderer());
    assertEquals(
        "The characteristics of someone or something", actualWithRollupKindResult.description());
    assertEquals(EntityKind.ALL, actualWithRollupKindResult.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, actualWithRollupKindResult.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, actualWithRollupKindResult.category());
    assertEquals(StatisticType.BOOLEAN, actualWithRollupKindResult.type());
    assertTrue(actualWithRollupKindResult.active());
    assertTrue(actualWithRollupKindResult.entityVisibility());
    assertTrue(actualWithRollupKindResult.rollupVisibility());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withRollupVisibility(Boolean)}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withRollupVisibility(Boolean)}
   */
  @Test
  @DisplayName("Test withRollupVisibility(Boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withRollupVisibility(Boolean)"
  })
  void testWithRollupVisibility() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    ImmutableEntityStatisticDefinition actualWithRollupVisibilityResult =
        immutableEntityStatisticDefinition.withRollupVisibility(true);

    // Assert
    assertSame(immutableEntityStatisticDefinition, actualWithRollupVisibilityResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withRollupVisibility(Boolean)}.
   *
   * <ul>
   *   <li>Then return {@code Historic Renderer}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withRollupVisibility(Boolean)}
   */
  @Test
  @DisplayName("Test withRollupVisibility(Boolean); then return 'Historic Renderer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withRollupVisibility(Boolean)"
  })
  void testWithRollupVisibility_thenReturnHistoricRenderer() {
    // Arrange and Act
    ImmutableEntityStatisticDefinition actualWithRollupVisibilityResult =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(false)
            .type(StatisticType.BOOLEAN)
            .build()
            .withRollupVisibility(true);

    // Assert
    assertEquals("Historic Renderer", actualWithRollupVisibilityResult.historicRenderer());
    assertEquals("Name", actualWithRollupVisibilityResult.name());
    assertEquals("Provenance", actualWithRollupVisibilityResult.provenance());
    assertEquals("Renderer", actualWithRollupVisibilityResult.renderer());
    assertEquals(
        "The characteristics of someone or something",
        actualWithRollupVisibilityResult.description());
    assertEquals(EntityKind.ALL, actualWithRollupVisibilityResult.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, actualWithRollupVisibilityResult.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, actualWithRollupVisibilityResult.category());
    assertEquals(StatisticType.BOOLEAN, actualWithRollupVisibilityResult.type());
    assertTrue(actualWithRollupVisibilityResult.active());
    assertTrue(actualWithRollupVisibilityResult.entityVisibility());
    assertTrue(actualWithRollupVisibilityResult.rollupVisibility());
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withType(StatisticType)}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withType(StatisticType)}
   */
  @Test
  @DisplayName("Test withType(StatisticType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withType(StatisticType)"
  })
  void testWithType() {
    // Arrange
    ImmutableEntityStatisticDefinition immutableEntityStatisticDefinition =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build();

    // Act
    ImmutableEntityStatisticDefinition actualWithTypeResult =
        immutableEntityStatisticDefinition.withType(StatisticType.BOOLEAN);

    // Assert
    assertSame(immutableEntityStatisticDefinition, actualWithTypeResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticDefinition#withType(StatisticType)}.
   *
   * <ul>
   *   <li>Then return {@code Historic Renderer}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticDefinition#withType(StatisticType)}
   */
  @Test
  @DisplayName("Test withType(StatisticType); then return 'Historic Renderer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticDefinition ImmutableEntityStatisticDefinition.withType(StatisticType)"
  })
  void testWithType_thenReturnHistoricRenderer() {
    // Arrange and Act
    ImmutableEntityStatisticDefinition actualWithTypeResult =
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.DATE)
            .build()
            .withType(StatisticType.BOOLEAN);

    // Assert
    assertEquals("Historic Renderer", actualWithTypeResult.historicRenderer());
    assertEquals("Name", actualWithTypeResult.name());
    assertEquals("Provenance", actualWithTypeResult.provenance());
    assertEquals("Renderer", actualWithTypeResult.renderer());
    assertEquals("The characteristics of someone or something", actualWithTypeResult.description());
    assertEquals(EntityKind.ALL, actualWithTypeResult.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, actualWithTypeResult.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, actualWithTypeResult.category());
    assertEquals(StatisticType.BOOLEAN, actualWithTypeResult.type());
    assertTrue(actualWithTypeResult.active());
    assertTrue(actualWithTypeResult.entityVisibility());
    assertTrue(actualWithTypeResult.rollupVisibility());
  }
}
