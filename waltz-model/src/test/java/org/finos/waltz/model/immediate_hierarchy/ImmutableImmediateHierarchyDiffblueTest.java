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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.immediate_hierarchy.ImmutableImmediateHierarchy.Builder;
import org.finos.waltz.model.immediate_hierarchy.ImmutableImmediateHierarchy.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableImmediateHierarchyDiffblueTest {
  /**
   * Test {@link ImmutableImmediateHierarchy#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableImmediateHierarchy#builder()}
   *   <li>{@link ImmutableImmediateHierarchy#parent(Object)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableImmediateHierarchy Builder.build()", "Builder Builder.parent(Object)"})
  void testBuilder() {
    // Arrange and Act
    Builder<Object> actualBuilderResult = ImmutableImmediateHierarchy.builder();
    Builder<Object> actualParentResult = actualBuilderResult.parent("Parent");
    Optional<?> parent = Optional.of("42");

    // Assert
    assertSame(actualParentResult, actualParentResult.parent(parent));
  }

  /**
   * Test Builder {@link Builder#addAllChildren(Iterable)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllChildren(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllChildren(Iterable); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllChildren(Iterable)"})
  void testBuilderAddAllChildren_given42_whenArrayListAdd42() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    ArrayList<Object> elements = new ArrayList<>();
    elements.add("42");

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChildren(elements));
  }

  /**
   * Test Builder {@link Builder#addAllChildren(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllChildren(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllChildren(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllChildren(Iterable)"})
  void testBuilderAddAllChildren_whenArrayList() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChildren(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addChildren(Object)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addChildren(Object)}
   */
  @Test
  @DisplayName("Test Builder addChildren(Object) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addChildren(Object)"})
  void testBuilderAddChildrenWithElement() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChildren("Element"));
  }

  /**
   * Test Builder {@link Builder#addChildren(Object[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addChildren(Object[])}
   */
  @Test
  @DisplayName("Test Builder addChildren(Object[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addChildren(Object[])"})
  void testBuilderAddChildrenWithElements() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChildren("Elements"));
  }

  /**
   * Test Builder {@link Builder#children(Iterable)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#children(Iterable)}
   */
  @Test
  @DisplayName("Test Builder children(Iterable); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.children(Iterable)"})
  void testBuilderChildren_given42_whenArrayListAdd42() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    ArrayList<Object> elements = new ArrayList<>();
    elements.add("42");

    // Act and Assert
    assertSame(builderResult, builderResult.children(elements));
  }

  /**
   * Test Builder {@link Builder#children(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#children(Iterable)}
   */
  @Test
  @DisplayName("Test Builder children(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.children(Iterable)"})
  void testBuilderChildren_whenArrayList() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.children(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(ImmediateHierarchy)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then builder build children size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ImmediateHierarchy)}
   */
  @Test
  @DisplayName("Test Builder from(ImmediateHierarchy); given ArrayList() add '42'; then builder build children size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ImmediateHierarchy)"})
  void testBuilderFrom_givenArrayListAdd42_thenBuilderBuildChildrenSizeIsOne() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    ImmediateHierarchy<Object> instance = mock(ImmediateHierarchy.class);
    when(instance.children()).thenReturn(objectList);
    Optional<Object> ofResult = Optional.of("42");
    when(instance.parent()).thenReturn(ofResult);
    when(instance.self()).thenReturn("Self");

    // Act
    builderResult.from(instance);

    // Assert
    verify(instance).children();
    verify(instance).parent();
    verify(instance).self();
    List<Object> childrenResult = builderResult.build().children();
    assertEquals(1, childrenResult.size());
    assertEquals("42", childrenResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(ImmediateHierarchy)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then builder build self is {@code Self}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ImmediateHierarchy)}
   */
  @Test
  @DisplayName("Test Builder from(ImmediateHierarchy); given ArrayList(); then builder build self is 'Self'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ImmediateHierarchy)"})
  void testBuilderFrom_givenArrayList_thenBuilderBuildSelfIsSelf() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();
    ImmediateHierarchy<Object> instance = mock(ImmediateHierarchy.class);
    when(instance.children()).thenReturn(new ArrayList<>());
    Optional<Object> ofResult = Optional.of("42");
    when(instance.parent()).thenReturn(ofResult);
    when(instance.self()).thenReturn("Self");

    // Act
    Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).children();
    verify(instance).parent();
    verify(instance).self();
    assertEquals("Self", builderResult.build().self());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ImmediateHierarchy)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link ImmediateHierarchy} {@link ImmediateHierarchy#parent()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ImmediateHierarchy)}
   */
  @Test
  @DisplayName("Test Builder from(ImmediateHierarchy); given empty; when ImmediateHierarchy parent() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ImmediateHierarchy)"})
  void testBuilderFrom_givenEmpty_whenImmediateHierarchyParentReturnEmpty() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();
    ImmediateHierarchy<Object> instance = mock(ImmediateHierarchy.class);
    when(instance.children()).thenReturn(new ArrayList<>());
    Optional<Object> emptyResult = Optional.empty();
    when(instance.parent()).thenReturn(emptyResult);
    when(instance.self()).thenReturn("Self");

    // Act
    Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).children();
    verify(instance).parent();
    verify(instance).self();
    assertEquals("Self", builderResult.build().self());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ImmediateHierarchy)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ImmediateHierarchy)}
   */
  @Test
  @DisplayName("Test Builder from(ImmediateHierarchy); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ImmediateHierarchy)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();
    ImmediateHierarchy<Object> instance = mock(ImmediateHierarchy.class);
    when(instance.parent()).thenThrow(new IllegalStateException("instance"));
    when(instance.self()).thenReturn("Self");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).parent();
    verify(instance).self();
  }

  /**
   * Test Builder {@link Builder#parent(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#parent(Optional)}
   */
  @Test
  @DisplayName("Test Builder parent(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parent(Optional)"})
  void testBuilderParentWithOptional() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();
    Optional<?> parent = Optional.of("42");

    // Act and Assert
    assertSame(builderResult, builderResult.parent(parent));
  }

  /**
   * Test Builder {@link Builder#self(Object)}.
   * <p>
   * Method under test: {@link Builder#self(Object)}
   */
  @Test
  @DisplayName("Test Builder self(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.self(Object)"})
  void testBuilderSelf() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    // Act
    Builder<Object> actualSelfResult = builderResult.self("Self");

    // Assert
    assertEquals("Self", builderResult.build().self());
    assertSame(builderResult, actualSelfResult);
  }

  /**
   * Test Json {@link Json#children()}.
   * <p>
   * Method under test: {@link Json#children()}
   */
  @Test
  @DisplayName("Test Json children()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.children()"})
  void testJsonChildren() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.children());
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
    Json<Object> actualJson = new Json<>();

    // Assert
    assertNull(actualJson.self);
    assertFalse(actualJson.parent.isPresent());
    assertTrue(actualJson.children.isEmpty());
  }

  /**
   * Test Json {@link Json#parent()}.
   * <p>
   * Method under test: {@link Json#parent()}
   */
  @Test
  @DisplayName("Test Json parent()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.parent()"})
  void testJsonParent() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.parent());
  }

  /**
   * Test Json {@link Json#self()}.
   * <p>
   * Method under test: {@link Json#self()}
   */
  @Test
  @DisplayName("Test Json self()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Json.self()"})
  void testJsonSelf() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.self());
  }
}
