package org.finos.waltz.model.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.IsRemovedProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableFlowDiagramDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFlowDiagram#builder()}
   *   <li>{@link ImmutableFlowDiagram#description(String)}
   *   <li>{@link ImmutableFlowDiagram#editorRole(String)}
   *   <li>{@link ImmutableFlowDiagram#kind(EntityKind)}
   *   <li>{@link ImmutableFlowDiagram#lastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableFlowDiagram.Builder actualEditorRoleResult = ImmutableFlowDiagram.builder()
        .description("The characteristics of someone or something")
        .editorRole("Editor Role");
    Optional<String> editorRole = Optional.of("foo");
    ImmutableFlowDiagram.Builder actualIdResult = actualEditorRoleResult.editorRole(editorRole).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableFlowDiagram.Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);

    // Assert
    assertSame(actualKindResult, actualKindResult.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Builder#editorRole(Optional)}
   */
  @Test
  void testBuilderEditorRole() {
    // Arrange
    ImmutableFlowDiagram.Builder builderResult = ImmutableFlowDiagram.builder();
    Optional<String> editorRole = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.editorRole(editorRole));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagram.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableFlowDiagram.Builder builderResult = ImmutableFlowDiagram.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableFlowDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagram.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableFlowDiagram.Builder builderResult = ImmutableFlowDiagram.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableFlowDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagram.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableFlowDiagram.Builder builderResult = ImmutableFlowDiagram.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagram.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableFlowDiagram.Builder builderResult = ImmutableFlowDiagram.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableFlowDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagram.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableFlowDiagram.Builder builderResult = ImmutableFlowDiagram.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableFlowDiagram.Builder builderResult = ImmutableFlowDiagram.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableFlowDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableFlowDiagram.Builder builderResult = ImmutableFlowDiagram.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableFlowDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableFlowDiagram.Builder builderResult = ImmutableFlowDiagram.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagram.Builder#from(IsRemovedProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableFlowDiagram.Builder builderResult = ImmutableFlowDiagram.builder();
    IsRemovedProvider instance = mock(IsRemovedProvider.class);
    when(instance.isRemoved()).thenReturn(true);

    // Act
    ImmutableFlowDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).isRemoved();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagram.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableFlowDiagram.Builder builderResult = ImmutableFlowDiagram.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableFlowDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDiagram.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableFlowDiagram.Builder builderResult = ImmutableFlowDiagram.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableFlowDiagram.Builder builderResult = ImmutableFlowDiagram.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Builder#from(FlowDiagram)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableFlowDiagram.Builder builderResult = ImmutableFlowDiagram.builder();
    FlowDiagram instance = mock(FlowDiagram.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.editorRole()).thenReturn(ofResult2);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.isRemoved()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).editorRole();
    verify(instance).kind();
    verify(instance).layoutData();
    ImmutableFlowDiagram buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Layout Data", buildResult.layoutData());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Builder#from(FlowDiagram)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableFlowDiagram.Builder builderResult = ImmutableFlowDiagram.builder();
    FlowDiagram instance = mock(FlowDiagram.class);
    when(instance.editorRole()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.isRemoved()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).isRemoved();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).editorRole();
    verify(instance).kind();
    verify(instance).layoutData();
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Builder#from(FlowDiagram)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableFlowDiagram.Builder builderResult = ImmutableFlowDiagram.builder();
    FlowDiagram instance = mock(FlowDiagram.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.editorRole()).thenReturn(ofResult);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.isRemoved()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).editorRole();
    verify(instance).kind();
    verify(instance).layoutData();
    ImmutableFlowDiagram buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Layout Data", buildResult.layoutData());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Builder#from(FlowDiagram)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableFlowDiagram.Builder builderResult = ImmutableFlowDiagram.builder();
    FlowDiagram instance = mock(FlowDiagram.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.editorRole()).thenReturn(emptyResult);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.isRemoved()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).editorRole();
    verify(instance).kind();
    verify(instance).layoutData();
    ImmutableFlowDiagram buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Layout Data", buildResult.layoutData());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Builder#from(FlowDiagram)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableFlowDiagram.Builder builderResult = ImmutableFlowDiagram.builder();
    FlowDiagram instance = mock(FlowDiagram.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.editorRole()).thenReturn(ofResult2);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn(null);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).editorRole();
    verify(instance).kind();
    verify(instance).layoutData();
    ImmutableFlowDiagram buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Layout Data", buildResult.layoutData());
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableFlowDiagram.Builder builderResult = ImmutableFlowDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableFlowDiagram.Builder builderResult = ImmutableFlowDiagram.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Builder#isRemoved(boolean)}
   */
  @Test
  void testBuilderIsRemoved() {
    // Arrange
    ImmutableFlowDiagram.Builder builderResult = ImmutableFlowDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isRemoved(true));
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableFlowDiagram.Builder builderResult = ImmutableFlowDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Builder#layoutData(String)}
   */
  @Test
  void testBuilderLayoutData() {
    // Arrange
    ImmutableFlowDiagram.Builder builderResult = ImmutableFlowDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.layoutData("Layout Data"));
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableFlowDiagram.Builder builderResult = ImmutableFlowDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram#copyOf(FlowDiagram)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    FlowDiagram instance = mock(FlowDiagram.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.editorRole()).thenReturn(ofResult2);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.isRemoved()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowDiagram actualCopyOfResult = ImmutableFlowDiagram.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).editorRole();
    verify(instance).kind();
    verify(instance).layoutData();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Layout Data", actualCopyOfResult.layoutData());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isRemoved());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram#copyOf(FlowDiagram)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    FlowDiagram instance = mock(FlowDiagram.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.editorRole()).thenReturn(ofResult);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.isRemoved()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowDiagram actualCopyOfResult = ImmutableFlowDiagram.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).editorRole();
    verify(instance).kind();
    verify(instance).layoutData();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Layout Data", actualCopyOfResult.layoutData());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isRemoved());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram#copyOf(FlowDiagram)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    FlowDiagram instance = mock(FlowDiagram.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.editorRole()).thenReturn(emptyResult);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.isRemoved()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowDiagram actualCopyOfResult = ImmutableFlowDiagram.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).editorRole();
    verify(instance).kind();
    verify(instance).layoutData();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Layout Data", actualCopyOfResult.layoutData());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isRemoved());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram#copyOf(FlowDiagram)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    FlowDiagram instance = mock(FlowDiagram.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.editorRole()).thenReturn(ofResult2);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn(null);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowDiagram actualCopyOfResult = ImmutableFlowDiagram.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).editorRole();
    verify(instance).kind();
    verify(instance).layoutData();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Layout Data", actualCopyOfResult.layoutData());
    assertEquals("Name", actualCopyOfResult.name());
    assertNull(actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isRemoved());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram#copyOf(FlowDiagram)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    FlowDiagram instance = mock(FlowDiagram.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.editorRole()).thenReturn(ofResult2);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.isRemoved()).thenReturn(false);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableFlowDiagram actualCopyOfResult = ImmutableFlowDiagram.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).editorRole();
    verify(instance).kind();
    verify(instance).layoutData();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Layout Data", actualCopyOfResult.layoutData());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertFalse(actualCopyOfResult.isRemoved());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowDiagram.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Json#editorRole()}
   */
  @Test
  void testJsonEditorRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowDiagram.Json()).editorRole());
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowDiagram.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Json#isRemoved()}
   */
  @Test
  void testJsonIsRemoved() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowDiagram.Json()).isRemoved());
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowDiagram.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowDiagram.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowDiagram.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Json#layoutData()}
   */
  @Test
  void testJsonLayoutData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowDiagram.Json()).layoutData());
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowDiagram.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableFlowDiagram.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableFlowDiagram.Json actualJson = new ImmutableFlowDiagram.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.layoutData);
    assertNull(actualJson.name);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertFalse(actualJson.editorRole.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isRemoved);
    assertFalse(actualJson.isRemovedIsSet);
  }

  /**
   * Method under test: {@link ImmutableFlowDiagram.Json#setIsRemoved(boolean)}
   */
  @Test
  void testJsonSetIsRemoved() {
    // Arrange
    ImmutableFlowDiagram.Json json = new ImmutableFlowDiagram.Json();

    // Act
    json.setIsRemoved(true);

    // Assert
    assertTrue(json.isRemoved);
    assertTrue(json.isRemovedIsSet);
  }
}
