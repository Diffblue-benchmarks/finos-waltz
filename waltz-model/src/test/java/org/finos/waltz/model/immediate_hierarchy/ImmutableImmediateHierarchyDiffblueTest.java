package org.finos.waltz.model.immediate_hierarchy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ch.qos.logback.core.util.COWArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class ImmutableImmediateHierarchyDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableImmediateHierarchy.Builder#addAllChildren(Iterable)}
   */
  @Test
  void testBuilderAddAllChildren() {
    // Arrange
    ImmutableImmediateHierarchy.Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChildren(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableImmediateHierarchy.Builder#addAllChildren(Iterable)}
   */
  @Test
  void testBuilderAddAllChildren2() {
    // Arrange
    ImmutableImmediateHierarchy.Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    ArrayList<Object> elements = new ArrayList<>();
    elements.add("42");

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChildren(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableImmediateHierarchy.Builder#addChildren(Object)}
   */
  @Test
  void testBuilderAddChildren() {
    // Arrange
    ImmutableImmediateHierarchy.Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChildren("Element"));
  }

  /**
   * Method under test:
   * {@link ImmutableImmediateHierarchy.Builder#addChildren(Object[])}
   */
  @Test
  void testBuilderAddChildren2() {
    // Arrange
    ImmutableImmediateHierarchy.Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChildren("Elements"));
  }

  /**
   * Method under test:
   * {@link ImmutableImmediateHierarchy.Builder#children(Iterable)}
   */
  @Test
  void testBuilderChildren() {
    // Arrange
    ImmutableImmediateHierarchy.Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.children(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableImmediateHierarchy.Builder#children(Iterable)}
   */
  @Test
  void testBuilderChildren2() {
    // Arrange
    ImmutableImmediateHierarchy.Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    ArrayList<Object> elements = new ArrayList<>();
    elements.add("42");

    // Act and Assert
    assertSame(builderResult, builderResult.children(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableImmediateHierarchy.Builder#from(ImmediateHierarchy)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableImmediateHierarchy.Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();
    ImmediateHierarchy<Object> instance = mock(ImmediateHierarchy.class);
    when(instance.children()).thenReturn(new ArrayList<>());
    Optional<Object> ofResult = Optional.of("42");
    when(instance.parent()).thenReturn(ofResult);
    when(instance.self()).thenReturn("Self");

    // Act
    ImmutableImmediateHierarchy.Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).children();
    verify(instance).parent();
    verify(instance).self();
    assertEquals("Self", builderResult.build().self());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableImmediateHierarchy.Builder#from(ImmediateHierarchy)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableImmediateHierarchy.Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();
    ImmediateHierarchy<Object> instance = mock(ImmediateHierarchy.class);
    when(instance.parent()).thenThrow(new IllegalStateException("instance"));
    when(instance.self()).thenReturn("Self");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).parent();
    verify(instance).self();
  }

  /**
   * Method under test:
   * {@link ImmutableImmediateHierarchy.Builder#from(ImmediateHierarchy)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableImmediateHierarchy.Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    ImmediateHierarchy<Object> instance = mock(ImmediateHierarchy.class);
    when(instance.children()).thenReturn(objectList);
    Optional<Object> ofResult = Optional.of("42");
    when(instance.parent()).thenReturn(ofResult);
    when(instance.self()).thenReturn("Self");

    // Act
    ImmutableImmediateHierarchy.Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).children();
    verify(instance).parent();
    verify(instance).self();
    ImmutableImmediateHierarchy<Object> buildResult = builderResult.build();
    List<Object> childrenResult = buildResult.children();
    assertEquals(1, childrenResult.size());
    assertEquals("42", childrenResult.get(0));
    assertEquals("Self", buildResult.self());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableImmediateHierarchy.Builder#from(ImmediateHierarchy)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableImmediateHierarchy.Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();
    ImmediateHierarchy<Object> instance = mock(ImmediateHierarchy.class);
    when(instance.children()).thenReturn(new ArrayList<>());
    Optional<Object> emptyResult = Optional.empty();
    when(instance.parent()).thenReturn(emptyResult);
    when(instance.self()).thenReturn("Self");

    // Act
    ImmutableImmediateHierarchy.Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).children();
    verify(instance).parent();
    verify(instance).self();
    assertEquals("Self", builderResult.build().self());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableImmediateHierarchy.Builder#self(Object)}
   */
  @Test
  void testBuilderSelf() {
    // Arrange
    ImmutableImmediateHierarchy.Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    // Act
    ImmutableImmediateHierarchy.Builder<Object> actualSelfResult = builderResult.self("Self");

    // Assert
    assertEquals("Self", builderResult.build().self());
    assertSame(builderResult, actualSelfResult);
  }

  /**
   * Method under test:
   * {@link ImmutableImmediateHierarchy#copyOf(ImmediateHierarchy)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ImmediateHierarchy<Object> instance = mock(ImmediateHierarchy.class);
    when(instance.children()).thenReturn(new ArrayList<>());
    Optional<Object> ofResult = Optional.of("42");
    when(instance.parent()).thenReturn(ofResult);
    when(instance.self()).thenReturn("Self");

    // Act
    ImmutableImmediateHierarchy<Object> actualCopyOfResult = ImmutableImmediateHierarchy.copyOf(instance);

    // Assert
    verify(instance).children();
    verify(instance).parent();
    verify(instance).self();
    assertEquals("Self", actualCopyOfResult.self());
    assertTrue(actualCopyOfResult.children().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableImmediateHierarchy#copyOf(ImmediateHierarchy)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    ImmediateHierarchy<Object> instance = mock(ImmediateHierarchy.class);
    when(instance.children()).thenReturn(objectList);
    Optional<Object> ofResult = Optional.of("42");
    when(instance.parent()).thenReturn(ofResult);
    when(instance.self()).thenReturn("Self");

    // Act
    ImmutableImmediateHierarchy<Object> actualCopyOfResult = ImmutableImmediateHierarchy.copyOf(instance);

    // Assert
    verify(instance).children();
    verify(instance).parent();
    verify(instance).self();
    List<Object> childrenResult = actualCopyOfResult.children();
    assertEquals(1, childrenResult.size());
    assertEquals("42", childrenResult.get(0));
    assertEquals("Self", actualCopyOfResult.self());
  }

  /**
   * Method under test:
   * {@link ImmutableImmediateHierarchy#copyOf(ImmediateHierarchy)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add("42");
    ImmediateHierarchy<Object> instance = mock(ImmediateHierarchy.class);
    when(instance.children()).thenReturn(objectList);
    Optional<Object> ofResult = Optional.of("42");
    when(instance.parent()).thenReturn(ofResult);
    when(instance.self()).thenReturn("Self");

    // Act
    ImmutableImmediateHierarchy<Object> actualCopyOfResult = ImmutableImmediateHierarchy.copyOf(instance);

    // Assert
    verify(instance).children();
    verify(instance).parent();
    verify(instance).self();
    assertEquals("Self", actualCopyOfResult.self());
    assertEquals(objectList, actualCopyOfResult.children());
  }

  /**
   * Method under test:
   * {@link ImmutableImmediateHierarchy#copyOf(ImmediateHierarchy)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ImmediateHierarchy<Object> instance = mock(ImmediateHierarchy.class);
    when(instance.children()).thenReturn(new ArrayList<>());
    Optional<Object> emptyResult = Optional.empty();
    when(instance.parent()).thenReturn(emptyResult);
    when(instance.self()).thenReturn("Self");

    // Act
    ImmutableImmediateHierarchy<Object> actualCopyOfResult = ImmutableImmediateHierarchy.copyOf(instance);

    // Assert
    verify(instance).children();
    verify(instance).parent();
    verify(instance).self();
    assertEquals("Self", actualCopyOfResult.self());
    assertTrue(actualCopyOfResult.children().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableImmediateHierarchy#fromJson(ImmutableImmediateHierarchy.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableImmediateHierarchy.Json<Object> json = new ImmutableImmediateHierarchy.Json<>();
    json.setSelf("Json");
    json.setParent(null);
    json.setChildren(null);

    // Act
    ImmutableImmediateHierarchy<Object> actualFromJsonResult = ImmutableImmediateHierarchy.fromJson(json);

    // Assert
    Object selfResult = actualFromJsonResult.self();
    assertEquals("Json", selfResult);
    assertTrue(actualFromJsonResult.children().isEmpty());
    assertSame(json.self, selfResult);
  }

  /**
   * Method under test:
   * {@link ImmutableImmediateHierarchy#fromJson(ImmutableImmediateHierarchy.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    COWArrayList<Object> children = mock(COWArrayList.class);
    when(children.iterator()).thenReturn(objectList.iterator());

    ImmutableImmediateHierarchy.Json<Object> json = new ImmutableImmediateHierarchy.Json<>();
    json.setSelf(1);
    json.setParent(null);
    json.setChildren(children);

    // Act
    ImmutableImmediateHierarchy<Object> actualFromJsonResult = ImmutableImmediateHierarchy.fromJson(json);

    // Assert
    verify(children).iterator();
    List<Object> childrenResult = actualFromJsonResult.children();
    assertEquals(1, childrenResult.size());
    assertEquals("42", childrenResult.get(0));
    Object expectedSelfResult = json.self;
    assertSame(expectedSelfResult, actualFromJsonResult.self());
  }

  /**
   * Method under test:
   * {@link ImmutableImmediateHierarchy#fromJson(ImmutableImmediateHierarchy.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add("42");
    COWArrayList<Object> children = mock(COWArrayList.class);
    when(children.iterator()).thenReturn(objectList.iterator());

    ImmutableImmediateHierarchy.Json<Object> json = new ImmutableImmediateHierarchy.Json<>();
    json.setSelf(1);
    json.setParent(null);
    json.setChildren(children);

    // Act
    ImmutableImmediateHierarchy<Object> actualFromJsonResult = ImmutableImmediateHierarchy.fromJson(json);

    // Assert
    verify(children).iterator();
    assertEquals(objectList, actualFromJsonResult.children());
    Object expectedSelfResult = json.self;
    assertSame(expectedSelfResult, actualFromJsonResult.self());
  }

  /**
   * Method under test: {@link ImmutableImmediateHierarchy.Json#children()}
   */
  @Test
  void testJsonChildren() {
    // Arrange
    ImmutableImmediateHierarchy.Json<Object> json = new ImmutableImmediateHierarchy.Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.children());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableImmediateHierarchy.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableImmediateHierarchy.Json<Object> actualJson = new ImmutableImmediateHierarchy.Json<>();

    // Assert
    assertNull(actualJson.self);
    assertFalse(actualJson.parent.isPresent());
    assertTrue(actualJson.children.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableImmediateHierarchy.Json#parent()}
   */
  @Test
  void testJsonParent() {
    // Arrange
    ImmutableImmediateHierarchy.Json<Object> json = new ImmutableImmediateHierarchy.Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.parent());
  }

  /**
   * Method under test: {@link ImmutableImmediateHierarchy.Json#self()}
   */
  @Test
  void testJsonSelf() {
    // Arrange
    ImmutableImmediateHierarchy.Json<Object> json = new ImmutableImmediateHierarchy.Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.self());
  }
}
