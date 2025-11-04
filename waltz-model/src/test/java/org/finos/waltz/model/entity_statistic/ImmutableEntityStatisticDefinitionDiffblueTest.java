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
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ParentIdProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableEntityStatisticDefinitionDiffblueTest {
  /**
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
  void testBuilder() {
    // Arrange and Act
    ImmutableEntityStatisticDefinition.Builder actualIdResult = ImmutableEntityStatisticDefinition.builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableEntityStatisticDefinition.Builder actualParentIdResult = actualIdResult.id(id)
        .kind(EntityKind.ALL)
        .parentId(1L);
    Optional<Long> parentId = Optional.<Long>of(1L);
    ImmutableEntityStatisticDefinition.Builder actualProvenanceResult = actualParentIdResult.parentId(parentId)
        .provenance("Provenance");

    // Assert
    assertSame(actualProvenanceResult, actualProvenanceResult.rollupKind(RollupKind.COUNT_BY_ENTITY));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#active(boolean)}
   */
  @Test
  void testBuilderActive() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.active(true));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#category(StatisticCategory)}
   */
  @Test
  void testBuilderCategory() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.category(StatisticCategory.COMPLIANCE));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#entityVisibility(Boolean)}
   */
  @Test
  void testBuilderEntityVisibility() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityVisibility(true));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableEntityStatisticDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableEntityStatisticDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableEntityStatisticDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableEntityStatisticDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableEntityStatisticDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityStatisticDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#from(ParentIdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);

    // Act
    ImmutableEntityStatisticDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#from(ParentIdProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentId()).thenReturn(emptyResult);

    // Act
    ImmutableEntityStatisticDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#from(ParentIdProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    when(instance.parentId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).parentId();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEntityStatisticDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#from(EntityStatisticDefinition)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();
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
    ImmutableEntityStatisticDefinition.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#from(EntityStatisticDefinition)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();
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
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#from(EntityStatisticDefinition)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();
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
    ImmutableEntityStatisticDefinition.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#from(EntityStatisticDefinition)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();
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
    ImmutableEntityStatisticDefinition.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#from(EntityStatisticDefinition)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();
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
    ImmutableEntityStatisticDefinition.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#historicRenderer(String)}
   */
  @Test
  void testBuilderHistoricRenderer() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.historicRenderer("Historic Renderer"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#parentId(long)}
   */
  @Test
  void testBuilderParentId() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#parentId(Optional)}
   */
  @Test
  void testBuilderParentId2() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();
    Optional<Long> parentId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.parentId(parentId));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#renderer(String)}
   */
  @Test
  void testBuilderRenderer() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.renderer("Renderer"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#rollupVisibility(Boolean)}
   */
  @Test
  void testBuilderRollupVisibility() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rollupVisibility(true));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Builder#type(StatisticType)}
   */
  @Test
  void testBuilderType() {
    // Arrange
    ImmutableEntityStatisticDefinition.Builder builderResult = ImmutableEntityStatisticDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.type(StatisticType.BOOLEAN));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition#copyOf(EntityStatisticDefinition)}
   */
  @Test
  void testCopyOf() {
    // Arrange
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
    ImmutableEntityStatisticDefinition actualCopyOfResult = ImmutableEntityStatisticDefinition.copyOf(instance);

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
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition#copyOf(EntityStatisticDefinition)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
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
    ImmutableEntityStatisticDefinition actualCopyOfResult = ImmutableEntityStatisticDefinition.copyOf(instance);

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
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition#copyOf(EntityStatisticDefinition)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    EntityStatisticDefinition instance = mock(EntityStatisticDefinition.class);
    when(instance.rollupVisibility()).thenReturn(true);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.category()).thenReturn(StatisticCategory.COMPLIANCE);
    when(instance.rollupKind()).thenReturn(RollupKind.COUNT_BY_ENTITY);
    when(instance.historicRenderer()).thenReturn("Historic Renderer");
    when(instance.active()).thenReturn(false);
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
    ImmutableEntityStatisticDefinition actualCopyOfResult = ImmutableEntityStatisticDefinition.copyOf(instance);

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
    assertEquals("Historic Renderer", actualCopyOfResult.historicRenderer());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("Renderer", actualCopyOfResult.renderer());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, actualCopyOfResult.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, actualCopyOfResult.category());
    assertEquals(StatisticType.BOOLEAN, actualCopyOfResult.type());
    assertFalse(actualCopyOfResult.active());
    assertTrue(actualCopyOfResult.entityVisibility());
    assertTrue(actualCopyOfResult.rollupVisibility());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition#copyOf(EntityStatisticDefinition)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
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
    ImmutableEntityStatisticDefinition actualCopyOfResult = ImmutableEntityStatisticDefinition.copyOf(instance);

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
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition#copyOf(EntityStatisticDefinition)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
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
    ImmutableEntityStatisticDefinition actualCopyOfResult = ImmutableEntityStatisticDefinition.copyOf(instance);

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
    assertEquals("Historic Renderer", actualCopyOfResult.historicRenderer());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("Renderer", actualCopyOfResult.renderer());
    assertNull(actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, actualCopyOfResult.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, actualCopyOfResult.category());
    assertEquals(StatisticType.BOOLEAN, actualCopyOfResult.type());
    assertTrue(actualCopyOfResult.active());
    assertTrue(actualCopyOfResult.entityVisibility());
    assertTrue(actualCopyOfResult.rollupVisibility());
  }

  /**
   * Method under test: {@link ImmutableEntityStatisticDefinition.Json#active()}
   */
  @Test
  void testJsonActive() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityStatisticDefinition.Json()).active());
  }

  /**
   * Method under test: {@link ImmutableEntityStatisticDefinition.Json#category()}
   */
  @Test
  void testJsonCategory() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityStatisticDefinition.Json()).category());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityStatisticDefinition.Json()).description());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Json#entityVisibility()}
   */
  @Test
  void testJsonEntityVisibility() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityStatisticDefinition.Json()).entityVisibility());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Json#historicRenderer()}
   */
  @Test
  void testJsonHistoricRenderer() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityStatisticDefinition.Json()).historicRenderer());
  }

  /**
   * Method under test: {@link ImmutableEntityStatisticDefinition.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityStatisticDefinition.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableEntityStatisticDefinition.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityStatisticDefinition.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableEntityStatisticDefinition.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityStatisticDefinition.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableEntityStatisticDefinition.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableEntityStatisticDefinition.Json actualJson = new ImmutableEntityStatisticDefinition.Json();

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
   * Method under test: {@link ImmutableEntityStatisticDefinition.Json#parentId()}
   */
  @Test
  void testJsonParentId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityStatisticDefinition.Json()).parentId());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityStatisticDefinition.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableEntityStatisticDefinition.Json#renderer()}
   */
  @Test
  void testJsonRenderer() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityStatisticDefinition.Json()).renderer());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Json#rollupKind()}
   */
  @Test
  void testJsonRollupKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityStatisticDefinition.Json()).rollupKind());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Json#rollupVisibility()}
   */
  @Test
  void testJsonRollupVisibility() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityStatisticDefinition.Json()).rollupVisibility());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticDefinition.Json#setActive(boolean)}
   */
  @Test
  void testJsonSetActive() {
    // Arrange
    ImmutableEntityStatisticDefinition.Json json = new ImmutableEntityStatisticDefinition.Json();

    // Act
    json.setActive(true);

    // Assert
    assertTrue(json.active);
    assertTrue(json.activeIsSet);
  }

  /**
   * Method under test: {@link ImmutableEntityStatisticDefinition.Json#type()}
   */
  @Test
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityStatisticDefinition.Json()).type());
  }
}
