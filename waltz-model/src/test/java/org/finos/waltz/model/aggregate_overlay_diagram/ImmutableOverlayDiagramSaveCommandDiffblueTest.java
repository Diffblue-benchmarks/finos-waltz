package org.finos.waltz.model.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableOverlayDiagramSaveCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramSaveCommand#builder()}
   *   <li>{@link ImmutableOverlayDiagramSaveCommand#description(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableOverlayDiagramSaveCommand.Builder actualIdResult = ImmutableOverlayDiagramSaveCommand.builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#addAllBackingEntities(Iterable)}
   */
  @Test
  void testBuilderAddAllBackingEntities() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllBackingEntities(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#addBackingEntities(BackingEntity)}
   */
  @Test
  void testBuilderAddBackingEntities() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addBackingEntities(new ImmutableBackingEntity.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#addBackingEntities(BackingEntity)}
   */
  @Test
  void testBuilderAddBackingEntities2() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    ImmutableBackingEntity.Json element = new ImmutableBackingEntity.Json();
    element.setEntityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addBackingEntities(element));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#addBackingEntities(BackingEntity[])}
   */
  @Test
  void testBuilderAddBackingEntities3() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addBackingEntities(new ImmutableBackingEntity.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#addBackingEntities(BackingEntity[])}
   */
  @Test
  void testBuilderAddBackingEntities4() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    ImmutableBackingEntity.Json json = new ImmutableBackingEntity.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addBackingEntities(json));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#aggregatedEntityKind(EntityKind)}
   */
  @Test
  void testBuilderAggregatedEntityKind() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.aggregatedEntityKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#aggregatedEntityKind(EntityKind)}
   */
  @Test
  void testBuilderAggregatedEntityKind2() {
    // Arrange
    ImmutableBackingEntity.Json element = new ImmutableBackingEntity.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    builderResult.addBackingEntities(element);

    // Act and Assert
    assertSame(builderResult, builderResult.aggregatedEntityKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#backingEntities(Iterable)}
   */
  @Test
  void testBuilderBackingEntities() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.backingEntities(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#diagramKind(OverlayDiagramKind)}
   */
  @Test
  void testBuilderDiagramKind() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#diagramKind(OverlayDiagramKind)}
   */
  @Test
  void testBuilderDiagramKind2() {
    // Arrange
    ImmutableBackingEntity.Json element = new ImmutableBackingEntity.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    builderResult.addBackingEntities(element);

    // Act and Assert
    assertSame(builderResult, builderResult.diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableOverlayDiagramSaveCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableOverlayDiagramSaveCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableOverlayDiagramSaveCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableOverlayDiagramSaveCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOverlayDiagramSaveCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#from(OverlayDiagramSaveCommand)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    OverlayDiagramSaveCommand instance = mock(OverlayDiagramSaveCommand.class);
    when(instance.diagramKind()).thenReturn(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.backingEntities()).thenReturn(new HashSet<>());
    when(instance.aggregatedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOverlayDiagramSaveCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).aggregatedEntityKind();
    verify(instance).backingEntities();
    verify(instance).diagramKind();
    verify(instance).layoutData();
    ImmutableOverlayDiagramSaveCommand buildResult = builderResult.build();
    assertEquals("Layout Data", buildResult.layoutData());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.aggregatedEntityKind());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, buildResult.diagramKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#from(OverlayDiagramSaveCommand)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    OverlayDiagramSaveCommand instance = mock(OverlayDiagramSaveCommand.class);
    when(instance.diagramKind()).thenThrow(new IllegalStateException("instance"));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.backingEntities()).thenReturn(new HashSet<>());
    when(instance.aggregatedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).aggregatedEntityKind();
    verify(instance).backingEntities();
    verify(instance).diagramKind();
    verify(instance).layoutData();
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#from(OverlayDiagramSaveCommand)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    OverlayDiagramSaveCommand instance = mock(OverlayDiagramSaveCommand.class);
    when(instance.diagramKind()).thenReturn(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.backingEntities()).thenReturn(new HashSet<>());
    when(instance.aggregatedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOverlayDiagramSaveCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).aggregatedEntityKind();
    verify(instance).backingEntities();
    verify(instance).diagramKind();
    verify(instance).layoutData();
    ImmutableOverlayDiagramSaveCommand buildResult = builderResult.build();
    assertEquals("Layout Data", buildResult.layoutData());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.aggregatedEntityKind());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, buildResult.diagramKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#from(OverlayDiagramSaveCommand)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    HashSet<BackingEntity> backingEntitySet = new HashSet<>();
    backingEntitySet.add(new ImmutableBackingEntity.Json());
    OverlayDiagramSaveCommand instance = mock(OverlayDiagramSaveCommand.class);
    when(instance.diagramKind()).thenReturn(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.backingEntities()).thenReturn(backingEntitySet);
    when(instance.aggregatedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOverlayDiagramSaveCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).aggregatedEntityKind();
    verify(instance).backingEntities();
    verify(instance).diagramKind();
    verify(instance).layoutData();
    ImmutableOverlayDiagramSaveCommand buildResult = builderResult.build();
    assertEquals("Layout Data", buildResult.layoutData());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.backingEntities().size());
    assertEquals(EntityKind.ALL, buildResult.aggregatedEntityKind());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, buildResult.diagramKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#from(OverlayDiagramSaveCommand)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    OverlayDiagramSaveCommand instance = mock(OverlayDiagramSaveCommand.class);
    when(instance.diagramKind()).thenReturn(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.backingEntities()).thenReturn(new HashSet<>());
    when(instance.aggregatedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn(null);
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOverlayDiagramSaveCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).aggregatedEntityKind();
    verify(instance).backingEntities();
    verify(instance).diagramKind();
    verify(instance).layoutData();
    ImmutableOverlayDiagramSaveCommand buildResult = builderResult.build();
    assertEquals("Layout Data", buildResult.layoutData());
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.aggregatedEntityKind());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, buildResult.diagramKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#id(long)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableBackingEntity.Json element = new ImmutableBackingEntity.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    builderResult.addBackingEntities(element);

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#id(Optional)}
   */
  @Test
  void testBuilderId3() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#id(Optional)}
   */
  @Test
  void testBuilderId4() {
    // Arrange
    ImmutableBackingEntity.Json element = new ImmutableBackingEntity.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    builderResult.addBackingEntities(element);
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#layoutData(String)}
   */
  @Test
  void testBuilderLayoutData() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.layoutData("Layout Data"));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#layoutData(String)}
   */
  @Test
  void testBuilderLayoutData2() {
    // Arrange
    ImmutableBackingEntity.Json element = new ImmutableBackingEntity.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    builderResult.addBackingEntities(element);

    // Act and Assert
    assertSame(builderResult, builderResult.layoutData("Layout Data"));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Builder#name(String)}
   */
  @Test
  void testBuilderName2() {
    // Arrange
    ImmutableBackingEntity.Json element = new ImmutableBackingEntity.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableOverlayDiagramSaveCommand.Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    builderResult.addBackingEntities(element);

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand#copyOf(OverlayDiagramSaveCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    OverlayDiagramSaveCommand instance = mock(OverlayDiagramSaveCommand.class);
    when(instance.diagramKind()).thenReturn(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.backingEntities()).thenReturn(new HashSet<>());
    when(instance.aggregatedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOverlayDiagramSaveCommand actualCopyOfResult = ImmutableOverlayDiagramSaveCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).aggregatedEntityKind();
    verify(instance).backingEntities();
    verify(instance).diagramKind();
    verify(instance).layoutData();
    assertEquals("Layout Data", actualCopyOfResult.layoutData());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.aggregatedEntityKind());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualCopyOfResult.diagramKind());
    assertTrue(actualCopyOfResult.backingEntities().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand#copyOf(OverlayDiagramSaveCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    OverlayDiagramSaveCommand instance = mock(OverlayDiagramSaveCommand.class);
    when(instance.diagramKind()).thenReturn(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.backingEntities()).thenReturn(new HashSet<>());
    when(instance.aggregatedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOverlayDiagramSaveCommand actualCopyOfResult = ImmutableOverlayDiagramSaveCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).aggregatedEntityKind();
    verify(instance).backingEntities();
    verify(instance).diagramKind();
    verify(instance).layoutData();
    assertEquals("Layout Data", actualCopyOfResult.layoutData());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.aggregatedEntityKind());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualCopyOfResult.diagramKind());
    assertTrue(actualCopyOfResult.backingEntities().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand#copyOf(OverlayDiagramSaveCommand)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<BackingEntity> backingEntitySet = new HashSet<>();
    backingEntitySet.add(new ImmutableBackingEntity.Json());
    OverlayDiagramSaveCommand instance = mock(OverlayDiagramSaveCommand.class);
    when(instance.diagramKind()).thenReturn(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.backingEntities()).thenReturn(backingEntitySet);
    when(instance.aggregatedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOverlayDiagramSaveCommand actualCopyOfResult = ImmutableOverlayDiagramSaveCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).aggregatedEntityKind();
    verify(instance).backingEntities();
    verify(instance).diagramKind();
    verify(instance).layoutData();
    assertEquals("Layout Data", actualCopyOfResult.layoutData());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.backingEntities().size());
    assertEquals(EntityKind.ALL, actualCopyOfResult.aggregatedEntityKind());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualCopyOfResult.diagramKind());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand#copyOf(OverlayDiagramSaveCommand)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<BackingEntity> backingEntitySet = new HashSet<>();
    backingEntitySet.add(new ImmutableBackingEntity.Json());
    backingEntitySet.add(new ImmutableBackingEntity.Json());
    OverlayDiagramSaveCommand instance = mock(OverlayDiagramSaveCommand.class);
    when(instance.diagramKind()).thenReturn(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.backingEntities()).thenReturn(backingEntitySet);
    when(instance.aggregatedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOverlayDiagramSaveCommand actualCopyOfResult = ImmutableOverlayDiagramSaveCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).aggregatedEntityKind();
    verify(instance).backingEntities();
    verify(instance).diagramKind();
    verify(instance).layoutData();
    assertEquals("Layout Data", actualCopyOfResult.layoutData());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.aggregatedEntityKind());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualCopyOfResult.diagramKind());
    assertEquals(backingEntitySet, actualCopyOfResult.backingEntities());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Json#aggregatedEntityKind()}
   */
  @Test
  void testJsonAggregatedEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramSaveCommand.Json()).aggregatedEntityKind());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Json#backingEntities()}
   */
  @Test
  void testJsonBackingEntities() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramSaveCommand.Json()).backingEntities());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramSaveCommand.Json()).description());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Json#diagramKind()}
   */
  @Test
  void testJsonDiagramKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramSaveCommand.Json()).diagramKind());
  }

  /**
   * Method under test: {@link ImmutableOverlayDiagramSaveCommand.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableOverlayDiagramSaveCommand.Json()).id());
  }

  /**
   * Method under test:
   * {@link ImmutableOverlayDiagramSaveCommand.Json#layoutData()}
   */
  @Test
  void testJsonLayoutData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableOverlayDiagramSaveCommand.Json()).layoutData());
  }

  /**
   * Method under test: {@link ImmutableOverlayDiagramSaveCommand.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableOverlayDiagramSaveCommand.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableOverlayDiagramSaveCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableOverlayDiagramSaveCommand.Json actualJson = new ImmutableOverlayDiagramSaveCommand.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.layoutData);
    assertNull(actualJson.name);
    assertNull(actualJson.aggregatedEntityKind);
    assertNull(actualJson.diagramKind);
    assertFalse(actualJson.id.isPresent());
    assertTrue(actualJson.backingEntities.isEmpty());
  }
}
