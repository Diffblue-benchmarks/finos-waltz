package org.finos.waltz.model.entity_statistic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ParentIdProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.entity_statistic.ImmutableEntityStatisticDefinition.Builder;
import org.finos.waltz.model.entity_statistic.ImmutableEntityStatisticDefinition.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityStatisticDefinitionDiffblueTest {
  /**
   * Test {@link ImmutableEntityStatisticDefinition#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableEntityStatisticDefinition#builder()}
   *   <li>{@link ImmutableEntityStatisticDefinition#description(String)}
   *   <li>{@link ImmutableEntityStatisticDefinition#kind(EntityKind)}
   *   <li>{@link ImmutableEntityStatisticDefinition#provenance(String)}
   *   <li>{@link ImmutableEntityStatisticDefinition#rollupKind(RollupKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableEntityStatisticDefinition Builder.build()", "Builder Builder.description(String)",
      "Builder Builder.kind(EntityKind)", "Builder Builder.provenance(String)",
      "Builder Builder.rollupKind(RollupKind)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualIdResult = ImmutableEntityStatisticDefinition.builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualParentIdResult = actualIdResult.id(id).kind(EntityKind.ALL).parentId(1L);
    Optional<Long> parentId = Optional.<Long>of(1L);
    Builder actualProvenanceResult = actualParentIdResult.parentId(parentId).provenance("Provenance");

    // Assert
    assertSame(actualProvenanceResult, actualProvenanceResult.rollupKind(RollupKind.COUNT_BY_ENTITY));
  }

  /**
   * Test Builder {@link Builder#active(boolean)}.
   * <p>
   * Method under test: {@link Builder#active(boolean)}
   */
  @Test
  @DisplayName("Test Builder active(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.active(boolean)"})
  void testBuilderActive() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.active(true));
  }

  /**
   * Test Builder {@link Builder#category(StatisticCategory)}.
   * <p>
   * Method under test: {@link Builder#category(StatisticCategory)}
   */
  @Test
  @DisplayName("Test Builder category(StatisticCategory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.category(StatisticCategory)"})
  void testBuilderCategory() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.category(StatisticCategory.COMPLIANCE));
  }

  /**
   * Test Builder {@link Builder#entityVisibility(Boolean)}.
   * <p>
   * Method under test: {@link Builder#entityVisibility(Boolean)}
   */
  @Test
  @DisplayName("Test Builder entityVisibility(Boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityVisibility(Boolean)"})
  void testBuilderEntityVisibility() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityVisibility(true));
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
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
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   * <ul>
   *   <li>Given {@code ALL}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'; given 'ALL'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_givenAll_thenReturnBuilder() {
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
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Test Builder {@link Builder#from(EntityStatisticDefinition)} with {@code EntityStatisticDefinition}.
   * <p>
   * Method under test: {@link Builder#from(EntityStatisticDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(EntityStatisticDefinition) with 'EntityStatisticDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityStatisticDefinition)"})
  void testBuilderFromWithEntityStatisticDefinition() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    EntityStatisticDefinition instance = mock(EntityStatisticDefinition.class);
    when(instance.rollupVisibility()).thenReturn(true);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.category()).thenReturn(StatisticCategory.COMPLIANCE);
    when(instance.rollupKind()).thenReturn(RollupKind.COUNT_BY_ENTITY);
    when(instance.historicRenderer()).thenReturn("Historic Renderer");
    when(instance.active()).thenReturn(true);
    when(instance.entityVisibility()).thenReturn(true);
    when(instance.type()).thenReturn(StatisticType.BOOLEAN);
    when(instance.renderer()).thenReturn("Renderer");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).provenance();
    verify(instance).active();
    verify(instance).category();
    verify(instance).entityVisibility();
    verify(instance).historicRenderer();
    verify(instance).kind();
    verify(instance).renderer();
    verify(instance).rollupKind();
    verify(instance).rollupVisibility();
    verify(instance).type();
    ImmutableEntityStatisticDefinition buildResult = builderResult.build();
    assertEquals("Historic Renderer", buildResult.historicRenderer());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("Renderer", buildResult.renderer());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, buildResult.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, buildResult.category());
    assertEquals(StatisticType.BOOLEAN, buildResult.type());
    assertTrue(buildResult.active());
    assertTrue(buildResult.entityVisibility());
    assertTrue(buildResult.rollupVisibility());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityStatisticDefinition)} with {@code EntityStatisticDefinition}.
   * <p>
   * Method under test: {@link Builder#from(EntityStatisticDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(EntityStatisticDefinition) with 'EntityStatisticDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityStatisticDefinition)"})
  void testBuilderFromWithEntityStatisticDefinition2() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    EntityStatisticDefinition instance = mock(EntityStatisticDefinition.class);
    when(instance.rollupVisibility()).thenReturn(true);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.category()).thenReturn(StatisticCategory.COMPLIANCE);
    when(instance.rollupKind()).thenReturn(RollupKind.COUNT_BY_ENTITY);
    when(instance.historicRenderer()).thenReturn("Historic Renderer");
    when(instance.active()).thenReturn(true);
    when(instance.entityVisibility()).thenReturn(true);
    when(instance.type()).thenReturn(StatisticType.BOOLEAN);
    when(instance.renderer()).thenReturn("Renderer");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).provenance();
    verify(instance).active();
    verify(instance).category();
    verify(instance).entityVisibility();
    verify(instance).historicRenderer();
    verify(instance).kind();
    verify(instance).renderer();
    verify(instance).rollupKind();
    verify(instance).rollupVisibility();
    verify(instance).type();
    ImmutableEntityStatisticDefinition buildResult = builderResult.build();
    assertEquals("Historic Renderer", buildResult.historicRenderer());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("Renderer", buildResult.renderer());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, buildResult.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, buildResult.category());
    assertEquals(StatisticType.BOOLEAN, buildResult.type());
    assertTrue(buildResult.active());
    assertTrue(buildResult.entityVisibility());
    assertTrue(buildResult.rollupVisibility());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityStatisticDefinition)} with {@code EntityStatisticDefinition}.
   * <p>
   * Method under test: {@link Builder#from(EntityStatisticDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(EntityStatisticDefinition) with 'EntityStatisticDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityStatisticDefinition)"})
  void testBuilderFromWithEntityStatisticDefinition3() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    EntityStatisticDefinition instance = mock(EntityStatisticDefinition.class);
    when(instance.rollupVisibility()).thenReturn(true);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.category()).thenReturn(StatisticCategory.COMPLIANCE);
    when(instance.rollupKind()).thenReturn(RollupKind.COUNT_BY_ENTITY);
    when(instance.historicRenderer()).thenReturn("Historic Renderer");
    when(instance.active()).thenReturn(true);
    when(instance.entityVisibility()).thenReturn(true);
    when(instance.type()).thenReturn(StatisticType.BOOLEAN);
    when(instance.renderer()).thenReturn("Renderer");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentId()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).provenance();
    verify(instance).active();
    verify(instance).category();
    verify(instance).entityVisibility();
    verify(instance).historicRenderer();
    verify(instance).kind();
    verify(instance).renderer();
    verify(instance).rollupKind();
    verify(instance).rollupVisibility();
    verify(instance).type();
    ImmutableEntityStatisticDefinition buildResult = builderResult.build();
    assertEquals("Historic Renderer", buildResult.historicRenderer());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("Renderer", buildResult.renderer());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, buildResult.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, buildResult.category());
    assertEquals(StatisticType.BOOLEAN, buildResult.type());
    assertTrue(buildResult.active());
    assertTrue(buildResult.entityVisibility());
    assertTrue(buildResult.rollupVisibility());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityStatisticDefinition)} with {@code EntityStatisticDefinition}.
   * <ul>
   *   <li>Then builder build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityStatisticDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(EntityStatisticDefinition) with 'EntityStatisticDefinition'; then builder build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityStatisticDefinition)"})
  void testBuilderFromWithEntityStatisticDefinition_thenBuilderBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    EntityStatisticDefinition instance = mock(EntityStatisticDefinition.class);
    when(instance.rollupVisibility()).thenReturn(true);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.category()).thenReturn(StatisticCategory.COMPLIANCE);
    when(instance.rollupKind()).thenReturn(RollupKind.COUNT_BY_ENTITY);
    when(instance.historicRenderer()).thenReturn("Historic Renderer");
    when(instance.active()).thenReturn(true);
    when(instance.entityVisibility()).thenReturn(true);
    when(instance.type()).thenReturn(StatisticType.BOOLEAN);
    when(instance.renderer()).thenReturn("Renderer");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).provenance();
    verify(instance).active();
    verify(instance).category();
    verify(instance).entityVisibility();
    verify(instance).historicRenderer();
    verify(instance).kind();
    verify(instance).renderer();
    verify(instance).rollupKind();
    verify(instance).rollupVisibility();
    verify(instance).type();
    ImmutableEntityStatisticDefinition buildResult = builderResult.build();
    assertEquals("Historic Renderer", buildResult.historicRenderer());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("Renderer", buildResult.renderer());
    assertNull(buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, buildResult.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, buildResult.category());
    assertEquals(StatisticType.BOOLEAN, buildResult.type());
    assertTrue(buildResult.active());
    assertTrue(buildResult.entityVisibility());
    assertTrue(buildResult.rollupVisibility());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityStatisticDefinition)} with {@code EntityStatisticDefinition}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityStatisticDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(EntityStatisticDefinition) with 'EntityStatisticDefinition'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityStatisticDefinition)"})
  void testBuilderFromWithEntityStatisticDefinition_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    EntityStatisticDefinition instance = mock(EntityStatisticDefinition.class);
    when(instance.rollupVisibility()).thenThrow(new IllegalStateException("instance"));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.category()).thenReturn(StatisticCategory.COMPLIANCE);
    when(instance.rollupKind()).thenReturn(RollupKind.COUNT_BY_ENTITY);
    when(instance.historicRenderer()).thenReturn("Historic Renderer");
    when(instance.active()).thenReturn(true);
    when(instance.entityVisibility()).thenReturn(true);
    when(instance.type()).thenReturn(StatisticType.BOOLEAN);
    when(instance.renderer()).thenReturn("Renderer");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).provenance();
    verify(instance).active();
    verify(instance).category();
    verify(instance).entityVisibility();
    verify(instance).historicRenderer();
    verify(instance).kind();
    verify(instance).renderer();
    verify(instance).rollupKind();
    verify(instance).rollupVisibility();
    verify(instance).type();
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
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
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'; given empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    when(instance.parentId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).parentId();
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   * <ul>
   *   <li>Given {@code Provenance}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'; given 'Provenance'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider_givenProvenance_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#historicRenderer(String)}.
   * <p>
   * Method under test: {@link Builder#historicRenderer(String)}
   */
  @Test
  @DisplayName("Test Builder historicRenderer(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.historicRenderer(String)"})
  void testBuilderHistoricRenderer() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.historicRenderer("Historic Renderer"));
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#parentId(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#parentId(long)}
   */
  @Test
  @DisplayName("Test Builder parentId(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentId(long)"})
  void testBuilderParentIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentId(1L));
  }

  /**
   * Test Builder {@link Builder#parentId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#parentId(Optional)}
   */
  @Test
  @DisplayName("Test Builder parentId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentId(Optional)"})
  void testBuilderParentIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    Optional<Long> parentId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.parentId(parentId));
  }

  /**
   * Test Builder {@link Builder#renderer(String)}.
   * <p>
   * Method under test: {@link Builder#renderer(String)}
   */
  @Test
  @DisplayName("Test Builder renderer(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.renderer(String)"})
  void testBuilderRenderer() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.renderer("Renderer"));
  }

  /**
   * Test Builder {@link Builder#rollupVisibility(Boolean)}.
   * <p>
   * Method under test: {@link Builder#rollupVisibility(Boolean)}
   */
  @Test
  @DisplayName("Test Builder rollupVisibility(Boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.rollupVisibility(Boolean)"})
  void testBuilderRollupVisibility() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rollupVisibility(true));
  }

  /**
   * Test Builder {@link Builder#type(StatisticType)}.
   * <p>
   * Method under test: {@link Builder#type(StatisticType)}
   */
  @Test
  @DisplayName("Test Builder type(StatisticType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.type(StatisticType)"})
  void testBuilderType() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.type(StatisticType.BOOLEAN));
  }

  /**
   * Test Json {@link Json#active()}.
   * <p>
   * Method under test: {@link Json#active()}
   */
  @Test
  @DisplayName("Test Json active()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.active()"})
  void testJsonActive() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).active());
  }

  /**
   * Test Json {@link Json#category()}.
   * <p>
   * Method under test: {@link Json#category()}
   */
  @Test
  @DisplayName("Test Json category()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StatisticCategory Json.category()"})
  void testJsonCategory() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).category());
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
  }

  /**
   * Test Json {@link Json#entityVisibility()}.
   * <p>
   * Method under test: {@link Json#entityVisibility()}
   */
  @Test
  @DisplayName("Test Json entityVisibility()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Boolean Json.entityVisibility()"})
  void testJsonEntityVisibility() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityVisibility());
  }

  /**
   * Test Json {@link Json#historicRenderer()}.
   * <p>
   * Method under test: {@link Json#historicRenderer()}
   */
  @Test
  @DisplayName("Test Json historicRenderer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.historicRenderer()"})
  void testJsonHistoricRenderer() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).historicRenderer());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json {@link Json#kind()}.
   * <p>
   * Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).kind());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#parentId()}
   */
  @Test
  @DisplayName("Test Json parentId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.parentId()"})
  void testJsonParentId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).parentId());
  }

  /**
   * Test Json {@link Json#provenance()}.
   * <p>
   * Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).provenance());
  }

  /**
   * Test Json {@link Json#renderer()}.
   * <p>
   * Method under test: {@link Json#renderer()}
   */
  @Test
  @DisplayName("Test Json renderer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.renderer()"})
  void testJsonRenderer() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).renderer());
  }

  /**
   * Test Json {@link Json#rollupKind()}.
   * <p>
   * Method under test: {@link Json#rollupKind()}
   */
  @Test
  @DisplayName("Test Json rollupKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RollupKind Json.rollupKind()"})
  void testJsonRollupKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).rollupKind());
  }

  /**
   * Test Json {@link Json#rollupVisibility()}.
   * <p>
   * Method under test: {@link Json#rollupVisibility()}
   */
  @Test
  @DisplayName("Test Json rollupVisibility()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Boolean Json.rollupVisibility()"})
  void testJsonRollupVisibility() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).rollupVisibility());
  }

  /**
   * Test Json {@link Json#setActive(boolean)}.
   * <p>
   * Method under test: {@link Json#setActive(boolean)}
   */
  @Test
  @DisplayName("Test Json setActive(boolean)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#type()}
   */
  @Test
  @DisplayName("Test Json type()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"StatisticType Json.type()"})
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).type());
  }
}
