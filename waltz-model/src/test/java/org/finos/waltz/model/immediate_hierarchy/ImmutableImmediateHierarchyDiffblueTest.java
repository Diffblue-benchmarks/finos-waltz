package org.finos.waltz.model.immediate_hierarchy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   * Test Builder {@link Builder#addAllChildren(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllChildren(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllChildren(Iterable); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllChildren(Iterable)"})
  void testBuilderAddAllChildren_given42_whenArrayListAdd42() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    ArrayList<Object> elements = new ArrayList<>();
    elements.add("42");

    // Act
    Builder<Object> actualAddAllChildrenResult = builderResult.addAllChildren(elements);

    // Assert
    assertSame(builderResult, actualAddAllChildrenResult);
  }

  /**
   * Test Builder {@link Builder#addAllChildren(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllChildren(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllChildren(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllChildren(Iterable)"})
  void testBuilderAddAllChildren_whenArrayList() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    // Act
    Builder<Object> actualAddAllChildrenResult = builderResult.addAllChildren(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllChildrenResult);
  }

  /**
   * Test Builder {@link Builder#addChildren(Object)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addChildren(Object)}
   */
  @Test
  @DisplayName("Test Builder addChildren(Object) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addChildren(Object)"})
  void testBuilderAddChildrenWithElement() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    // Act
    Builder<Object> actualAddChildrenResult = builderResult.addChildren("Element");

    // Assert
    assertSame(builderResult, actualAddChildrenResult);
  }

  /**
   * Test Builder {@link Builder#addChildren(Object[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addChildren(Object[])}
   */
  @Test
  @DisplayName("Test Builder addChildren(Object[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addChildren(Object[])"})
  void testBuilderAddChildrenWithElements() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    // Act
    Builder<Object> actualAddChildrenResult = builderResult.addChildren("Elements");

    // Assert
    assertSame(builderResult, actualAddChildrenResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#parent(Object)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableImmediateHierarchy Builder.build()",
    "Builder Builder.parent(Object)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder<Object> actualBuilderResult = ImmutableImmediateHierarchy.builder();
    Builder<Object> actualParentResult = actualBuilderResult.parent("Parent");
    Optional<?> parent = Optional.of("Value");
    ImmutableImmediateHierarchy<Object> actualImmutableImmediateHierarchy =
        actualParentResult.parent(parent).self("Self").build();

    // Assert
    assertEquals("Self", actualImmutableImmediateHierarchy.self());
    assertTrue(actualImmutableImmediateHierarchy.children().isEmpty());
  }

  /**
   * Test Builder {@link Builder#children(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#children(Iterable)}
   */
  @Test
  @DisplayName("Test Builder children(Iterable); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.children(Iterable)"})
  void testBuilderChildren_given42_whenArrayListAdd42() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    ArrayList<Object> elements = new ArrayList<>();
    elements.add("42");

    // Act
    Builder<Object> actualChildrenResult = builderResult.children(elements);

    // Assert
    assertSame(builderResult, actualChildrenResult);
  }

  /**
   * Test Builder {@link Builder#children(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#children(Iterable)}
   */
  @Test
  @DisplayName("Test Builder children(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.children(Iterable)"})
  void testBuilderChildren_whenArrayList() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    // Act
    Builder<Object> actualChildrenResult = builderResult.children(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualChildrenResult);
  }

  /**
   * Test Builder {@link Builder#from(ImmediateHierarchy)}.
   *
   * <ul>
   *   <li>Given {@code Element}.
   *   <li>Then builder build is builder parent {@code Parent} self {@code Self} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ImmediateHierarchy)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ImmediateHierarchy); given 'Element'; then builder build is builder parent 'Parent' self 'Self' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ImmediateHierarchy)"})
  void testBuilderFrom_givenElement_thenBuilderBuildIsBuilderParentParentSelfSelfBuild() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    Builder<Object> builderResult2 = ImmutableImmediateHierarchy.builder();
    builderResult2.addChildren("Element");
    ImmutableImmediateHierarchy<Object> instance =
        builderResult2.parent("Parent").self("Self").build();

    // Act
    Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableImmediateHierarchy<Object> actualImmutableImmediateHierarchy = builderResult.build();
    assertEquals(instance, actualImmutableImmediateHierarchy);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ImmediateHierarchy)}.
   *
   * <ul>
   *   <li>Then return build is builder parent {@code Parent} self {@code Self} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ImmediateHierarchy)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ImmediateHierarchy); then return build is builder parent 'Parent' self 'Self' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ImmediateHierarchy)"})
  void testBuilderFrom_thenReturnBuildIsBuilderParentParentSelfSelfBuild() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    Builder<Object> builderResult2 = ImmutableImmediateHierarchy.builder();
    ImmutableImmediateHierarchy<Object> instance =
        builderResult2.parent("Parent").self("Self").build();

    // Act and Assert
    ImmutableImmediateHierarchy<Object> actualImmutableImmediateHierarchy =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableImmediateHierarchy);
  }

  /**
   * Test Builder {@link Builder#parent(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#parent(Optional)}
   */
  @Test
  @DisplayName("Test Builder parent(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parent(Optional)"})
  void testBuilderParentWithOptional() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();
    Optional<?> parent = Optional.of("Value");

    // Act
    Builder<Object> actualParentResult = builderResult.parent(parent);

    // Assert
    assertSame(builderResult, actualParentResult);
  }

  /**
   * Test Builder {@link Builder#self(Object)}.
   *
   * <ul>
   *   <li>When {@code Self}.
   *   <li>Then builder build self is {@code Self}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#self(Object)}
   */
  @Test
  @DisplayName("Test Builder self(Object); when 'Self'; then builder build self is 'Self'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.self(Object)"})
  void testBuilderSelf_whenSelf_thenBuilderBuildSelfIsSelf() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    // Act
    Builder<Object> actualSelfResult = builderResult.self("Self");

    // Assert
    assertEquals("Self", builderResult.build().self());
    assertSame(builderResult, actualSelfResult);
  }

  /**
   * Test {@link ImmutableImmediateHierarchy#copyOf(ImmediateHierarchy)}.
   *
   * <ul>
   *   <li>When builder parent {@code Parent} self {@code Self} build.
   *   <li>Then return {@code Self}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableImmediateHierarchy#copyOf(ImmediateHierarchy)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ImmediateHierarchy); when builder parent 'Parent' self 'Self' build; then return 'Self'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableImmediateHierarchy ImmutableImmediateHierarchy.copyOf(ImmediateHierarchy)"
  })
  void testCopyOf_whenBuilderParentParentSelfSelfBuild_thenReturnSelf() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();
    ImmutableImmediateHierarchy<Object> instance =
        builderResult.parent("Parent").self("Self").build();

    // Act
    ImmutableImmediateHierarchy<Object> actualCopyOfResult =
        ImmutableImmediateHierarchy.copyOf(instance);

    // Assert
    assertEquals("Self", actualCopyOfResult.self());
    assertTrue(actualCopyOfResult.children().isEmpty());
  }

  /**
   * Test {@link ImmutableImmediateHierarchy#equals(Object)}, and {@link
   * ImmutableImmediateHierarchy#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableImmediateHierarchy#equals(Object)}
   *   <li>{@link ImmutableImmediateHierarchy#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableImmediateHierarchy.equals(Object)",
    "int ImmutableImmediateHierarchy.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();
    ImmutableImmediateHierarchy<Object> immutableImmediateHierarchy =
        builderResult.parent("Parent").self("Self").build();

    Builder<Object> builderResult2 = ImmutableImmediateHierarchy.builder();
    ImmutableImmediateHierarchy<Object> immutableImmediateHierarchy2 =
        builderResult2.parent("Parent").self("Self").build();

    // Act and Assert
    assertEquals(immutableImmediateHierarchy, immutableImmediateHierarchy2);
    assertEquals(immutableImmediateHierarchy.hashCode(), immutableImmediateHierarchy2.hashCode());
  }

  /**
   * Test {@link ImmutableImmediateHierarchy#equals(Object)}, and {@link
   * ImmutableImmediateHierarchy#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableImmediateHierarchy#equals(Object)}
   *   <li>{@link ImmutableImmediateHierarchy#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableImmediateHierarchy.equals(Object)",
    "int ImmutableImmediateHierarchy.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();
    ImmutableImmediateHierarchy<Object> immutableImmediateHierarchy =
        builderResult.parent("Parent").self("Self").build();

    // Act and Assert
    assertEquals(immutableImmediateHierarchy, immutableImmediateHierarchy);
    int expectedHashCodeResult = immutableImmediateHierarchy.hashCode();
    assertEquals(expectedHashCodeResult, immutableImmediateHierarchy.hashCode());
  }

  /**
   * Test {@link ImmutableImmediateHierarchy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableImmediateHierarchy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableImmediateHierarchy.equals(Object)",
    "int ImmutableImmediateHierarchy.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();
    builderResult.addChildren("Element");
    ImmutableImmediateHierarchy<Object> immutableImmediateHierarchy =
        builderResult.parent("Parent").self("Self").build();

    Builder<Object> builderResult2 = ImmutableImmediateHierarchy.builder();

    // Act and Assert
    assertNotEquals(
        immutableImmediateHierarchy, builderResult2.parent("Parent").self("Self").build());
  }

  /**
   * Test {@link ImmutableImmediateHierarchy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableImmediateHierarchy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableImmediateHierarchy.equals(Object)",
    "int ImmutableImmediateHierarchy.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();
    ImmutableImmediateHierarchy<Object> immutableImmediateHierarchy =
        builderResult.parent(1).self("Self").build();

    Builder<Object> builderResult2 = ImmutableImmediateHierarchy.builder();

    // Act and Assert
    assertNotEquals(
        immutableImmediateHierarchy, builderResult2.parent("Parent").self("Self").build());
  }

  /**
   * Test {@link ImmutableImmediateHierarchy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableImmediateHierarchy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableImmediateHierarchy.equals(Object)",
    "int ImmutableImmediateHierarchy.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    Builder<Object> builderResult2 = ImmutableImmediateHierarchy.builder();
    ImmutableImmediateHierarchy<Object> immutableImmediateHierarchy =
        builderResult
            .parent(builderResult2.parent("Parent").self("Self").build())
            .self("Self")
            .build();

    Builder<Object> builderResult3 = ImmutableImmediateHierarchy.builder();

    // Act and Assert
    assertNotEquals(
        immutableImmediateHierarchy, builderResult3.parent("Parent").self("Self").build());
  }

  /**
   * Test {@link ImmutableImmediateHierarchy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableImmediateHierarchy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableImmediateHierarchy.equals(Object)",
    "int ImmutableImmediateHierarchy.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();
    ImmutableImmediateHierarchy<Object> immutableImmediateHierarchy =
        builderResult.parent("Parent").self(1).build();

    Builder<Object> builderResult2 = ImmutableImmediateHierarchy.builder();

    // Act and Assert
    assertNotEquals(
        immutableImmediateHierarchy, builderResult2.parent("Parent").self("Self").build());
  }

  /**
   * Test {@link ImmutableImmediateHierarchy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableImmediateHierarchy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableImmediateHierarchy.equals(Object)",
    "int ImmutableImmediateHierarchy.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    Builder<Object> parentResult = builderResult.parent("Parent");

    Builder<Object> builderResult2 = ImmutableImmediateHierarchy.builder();
    ImmutableImmediateHierarchy<Object> immutableImmediateHierarchy =
        parentResult.self(builderResult2.parent("Parent").self("Self").build()).build();

    Builder<Object> builderResult3 = ImmutableImmediateHierarchy.builder();

    // Act and Assert
    assertNotEquals(
        immutableImmediateHierarchy, builderResult3.parent("Parent").self("Self").build());
  }

  /**
   * Test {@link ImmutableImmediateHierarchy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableImmediateHierarchy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableImmediateHierarchy.equals(Object)",
    "int ImmutableImmediateHierarchy.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    // Act and Assert
    assertNotEquals(builderResult.parent("Parent").self("Self").build(), null);
  }

  /**
   * Test {@link ImmutableImmediateHierarchy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableImmediateHierarchy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableImmediateHierarchy.equals(Object)",
    "int ImmutableImmediateHierarchy.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    // Act and Assert
    assertNotEquals(
        builderResult.parent("Parent").self("Self").build(),
        "Different type to ImmutableImmediateHierarchy");
  }

  /**
   * Test {@link ImmutableImmediateHierarchy#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return children is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableImmediateHierarchy#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add '42'; then return children is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableImmediateHierarchy ImmutableImmediateHierarchy.fromJson(Json)"})
  void testFromJson_givenArrayListAdd42_thenReturnChildrenIsArrayList() {
    // Arrange
    ArrayList<Object> children = new ArrayList<>();
    children.add("42");
    children.add("42");

    Json<Object> json = new Json<>();
    json.setSelf("Json");
    Optional<Object> parent = Optional.of("Value");
    json.setParent(parent);
    json.setChildren(children);

    // Act
    ImmutableImmediateHierarchy<Object> actualFromJsonResult =
        ImmutableImmediateHierarchy.fromJson(json);

    // Assert
    assertEquals(children, actualFromJsonResult.children());
  }

  /**
   * Test {@link ImmutableImmediateHierarchy#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return children size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableImmediateHierarchy#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add '42'; then return children size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableImmediateHierarchy ImmutableImmediateHierarchy.fromJson(Json)"})
  void testFromJson_givenArrayListAdd42_thenReturnChildrenSizeIsOne() {
    // Arrange
    ArrayList<Object> children = new ArrayList<>();
    children.add("42");

    Json<Object> json = new Json<>();
    json.setSelf("Json");
    Optional<Object> parent = Optional.of("Value");
    json.setParent(parent);
    json.setChildren(children);

    // Act
    ImmutableImmediateHierarchy<Object> actualFromJsonResult =
        ImmutableImmediateHierarchy.fromJson(json);

    // Assert
    List<Object> childrenResult = actualFromJsonResult.children();
    assertEquals(1, childrenResult.size());
    assertEquals("42", childrenResult.get(0));
  }

  /**
   * Test {@link ImmutableImmediateHierarchy#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return self is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableImmediateHierarchy#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList(); then return self is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableImmediateHierarchy ImmutableImmediateHierarchy.fromJson(Json)"})
  void testFromJson_givenArrayList_thenReturnSelfIsJson() {
    // Arrange
    Json<Object> json = new Json<>();
    json.setSelf("Json");
    Optional<Object> parent = Optional.of("Value");
    json.setParent(parent);
    json.setChildren(new ArrayList<>());

    // Act
    ImmutableImmediateHierarchy<Object> actualFromJsonResult =
        ImmutableImmediateHierarchy.fromJson(json);

    // Assert
    Object selfResult = actualFromJsonResult.self();
    assertEquals("Json", selfResult);
    assertTrue(actualFromJsonResult.children().isEmpty());
    assertSame(json.self, selfResult);
  }

  /**
   * Test {@link ImmutableImmediateHierarchy#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Children is {@code null}.
   *   <li>Then return self is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableImmediateHierarchy#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Children is 'null'; then return self is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableImmediateHierarchy ImmutableImmediateHierarchy.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonChildrenIsNull_thenReturnSelfIsJson() {
    // Arrange
    Json<Object> json = new Json<>();
    json.setSelf("Json");
    Optional<Object> parent = Optional.of("Value");
    json.setParent(parent);
    json.setChildren(null);

    // Act
    ImmutableImmediateHierarchy<Object> actualFromJsonResult =
        ImmutableImmediateHierarchy.fromJson(json);

    // Assert
    Object selfResult = actualFromJsonResult.self();
    assertEquals("Json", selfResult);
    assertTrue(actualFromJsonResult.children().isEmpty());
    assertSame(json.self, selfResult);
  }

  /**
   * Test {@link ImmutableImmediateHierarchy#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Parent is {@code null}.
   *   <li>Then return self is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableImmediateHierarchy#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Parent is 'null'; then return self is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableImmediateHierarchy ImmutableImmediateHierarchy.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonParentIsNull_thenReturnSelfIsJson() {
    // Arrange
    Json<Object> json = new Json<>();
    json.setSelf("Json");
    json.setParent(null);
    json.setChildren(new ArrayList<>());

    // Act
    ImmutableImmediateHierarchy<Object> actualFromJsonResult =
        ImmutableImmediateHierarchy.fromJson(json);

    // Assert
    Object selfResult = actualFromJsonResult.self();
    assertEquals("Json", selfResult);
    assertTrue(actualFromJsonResult.children().isEmpty());
    assertSame(json.self, selfResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableImmediateHierarchy#children()}
   *   <li>{@link ImmutableImmediateHierarchy#self()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ImmutableImmediateHierarchy.children()",
    "Object ImmutableImmediateHierarchy.self()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();
    ImmutableImmediateHierarchy<Object> immutableImmediateHierarchy =
        builderResult.parent("Parent").self("Self").build();

    // Act
    List<Object> actualChildrenResult = immutableImmediateHierarchy.children();

    // Assert
    assertEquals("Self", immutableImmediateHierarchy.self());
    assertTrue(actualChildrenResult.isEmpty());
  }

  /**
   * Test Json {@link Json#children()}.
   *
   * <p>Method under test: {@link Json#children()}
   */
  @Test
  @DisplayName("Test Json children()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.children()"})
  void testJsonChildren() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.children());
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
    Json<Object> actualJson = new Json<>();

    // Assert
    assertNull(actualJson.self);
    assertFalse(actualJson.parent.isPresent());
    assertTrue(actualJson.children.isEmpty());
  }

  /**
   * Test Json {@link Json#parent()}.
   *
   * <p>Method under test: {@link Json#parent()}
   */
  @Test
  @DisplayName("Test Json parent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.parent()"})
  void testJsonParent() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.parent());
  }

  /**
   * Test Json {@link Json#self()}.
   *
   * <p>Method under test: {@link Json#self()}
   */
  @Test
  @DisplayName("Test Json self()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Json.self()"})
  void testJsonSelf() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.self());
  }

  /**
   * Test {@link ImmutableImmediateHierarchy#parent()}.
   *
   * <p>Method under test: {@link ImmutableImmediateHierarchy#parent()}
   */
  @Test
  @DisplayName("Test parent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableImmediateHierarchy.parent()"})
  void testParent() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    // Act
    Optional<Object> actualParentResult =
        builderResult.parent("Parent").self("Self").build().parent();

    // Assert
    assertEquals("Parent", actualParentResult.get());
    assertTrue(actualParentResult.isPresent());
  }

  /**
   * Test {@link ImmutableImmediateHierarchy#toString()}.
   *
   * <p>Method under test: {@link ImmutableImmediateHierarchy#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableImmediateHierarchy.toString()"})
  void testToString() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    // Act and Assert
    assertEquals(
        "ImmediateHierarchy{self=Self, parent=Parent, children=[]}",
        builderResult.parent("Parent").self("Self").build().toString());
  }

  /**
   * Test {@link ImmutableImmediateHierarchy#withChildren(Object[])} with {@code Object[]}.
   *
   * <ul>
   *   <li>When {@code Elements}.
   *   <li>Then return children size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableImmediateHierarchy#withChildren(Object[])}
   */
  @Test
  @DisplayName(
      "Test withChildren(Object[]) with 'Object[]'; when 'Elements'; then return children size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableImmediateHierarchy ImmutableImmediateHierarchy.withChildren(Object[])"
  })
  void testWithChildrenWithObject_whenElements_thenReturnChildrenSizeIsOne() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    // Act
    ImmutableImmediateHierarchy<Object> actualWithChildrenResult =
        builderResult.parent("Parent").self("Self").build().withChildren("Elements");

    // Assert
    List<Object> childrenResult = actualWithChildrenResult.children();
    assertEquals(1, childrenResult.size());
    assertEquals("Elements", childrenResult.get(0));
    assertEquals("Self", actualWithChildrenResult.self());
  }

  /**
   * Test {@link ImmutableImmediateHierarchy#withParent(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Given builder parent {@code Parent} self {@code Self} build.
   *   <li>Then return {@code Self}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableImmediateHierarchy#withParent(Optional)}
   */
  @Test
  @DisplayName(
      "Test withParent(Optional) with 'optional'; given builder parent 'Parent' self 'Self' build; then return 'Self'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableImmediateHierarchy ImmutableImmediateHierarchy.withParent(Optional)"
  })
  void testWithParentWithOptional_givenBuilderParentParentSelfSelfBuild_thenReturnSelf() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();
    ImmutableImmediateHierarchy<Object> immutableImmediateHierarchy =
        builderResult.parent("Parent").self("Self").build();
    Optional<?> optional = Optional.of("Value");

    // Act
    ImmutableImmediateHierarchy<Object> actualWithParentResult =
        immutableImmediateHierarchy.withParent(optional);

    // Assert
    assertEquals("Self", actualWithParentResult.self());
    assertTrue(actualWithParentResult.children().isEmpty());
  }

  /**
   * Test {@link ImmutableImmediateHierarchy#withParent(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return builder parent forty-two self {@code Self} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableImmediateHierarchy#withParent(Optional)}
   */
  @Test
  @DisplayName(
      "Test withParent(Optional) with 'optional'; then return builder parent forty-two self 'Self' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableImmediateHierarchy ImmutableImmediateHierarchy.withParent(Optional)"
  })
  void testWithParentWithOptional_thenReturnBuilderParentFortyTwoSelfSelfBuild() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();
    ImmutableImmediateHierarchy<Object> immutableImmediateHierarchy =
        builderResult.parent(42).self("Self").build();
    Optional<?> optional = Optional.of(42);

    // Act
    ImmutableImmediateHierarchy<Object> actualWithParentResult =
        immutableImmediateHierarchy.withParent(optional);

    // Assert
    assertSame(immutableImmediateHierarchy, actualWithParentResult);
  }

  /**
   * Test {@link ImmutableImmediateHierarchy#withParent(Object)} with {@code value}.
   *
   * <ul>
   *   <li>Given builder parent {@code Parent} self {@code Self} build.
   *   <li>Then return {@code Self}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableImmediateHierarchy#withParent(Object)}
   */
  @Test
  @DisplayName(
      "Test withParent(Object) with 'value'; given builder parent 'Parent' self 'Self' build; then return 'Self'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableImmediateHierarchy ImmutableImmediateHierarchy.withParent(Object)"})
  void testWithParentWithValue_givenBuilderParentParentSelfSelfBuild_thenReturnSelf() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    // Act
    ImmutableImmediateHierarchy<Object> actualWithParentResult =
        builderResult.parent("Parent").self("Self").build().withParent("Value");

    // Assert
    assertEquals("Self", actualWithParentResult.self());
    assertTrue(actualWithParentResult.children().isEmpty());
  }

  /**
   * Test {@link ImmutableImmediateHierarchy#withParent(Object)} with {@code value}.
   *
   * <ul>
   *   <li>Then return builder parent forty-two self {@code Self} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableImmediateHierarchy#withParent(Object)}
   */
  @Test
  @DisplayName(
      "Test withParent(Object) with 'value'; then return builder parent forty-two self 'Self' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableImmediateHierarchy ImmutableImmediateHierarchy.withParent(Object)"})
  void testWithParentWithValue_thenReturnBuilderParentFortyTwoSelfSelfBuild() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();
    ImmutableImmediateHierarchy<Object> immutableImmediateHierarchy =
        builderResult.parent(42).self("Self").build();

    // Act
    ImmutableImmediateHierarchy<Object> actualWithParentResult =
        immutableImmediateHierarchy.withParent(42);

    // Assert
    assertSame(immutableImmediateHierarchy, actualWithParentResult);
  }

  /**
   * Test {@link ImmutableImmediateHierarchy#withSelf(Object)}.
   *
   * <ul>
   *   <li>Given builder parent {@code Parent} self {@code Self} build.
   *   <li>Then return self is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableImmediateHierarchy#withSelf(Object)}
   */
  @Test
  @DisplayName(
      "Test withSelf(Object); given builder parent 'Parent' self 'Self' build; then return self is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableImmediateHierarchy ImmutableImmediateHierarchy.withSelf(Object)"})
  void testWithSelf_givenBuilderParentParentSelfSelfBuild_thenReturnSelfIsValue() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();

    // Act
    ImmutableImmediateHierarchy<Object> actualWithSelfResult =
        builderResult.parent("Parent").self("Self").build().withSelf("Value");

    // Assert
    assertEquals("Value", actualWithSelfResult.self());
    assertTrue(actualWithSelfResult.children().isEmpty());
  }

  /**
   * Test {@link ImmutableImmediateHierarchy#withSelf(Object)}.
   *
   * <ul>
   *   <li>Then return builder parent {@code Parent} self forty-two build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableImmediateHierarchy#withSelf(Object)}
   */
  @Test
  @DisplayName("Test withSelf(Object); then return builder parent 'Parent' self forty-two build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableImmediateHierarchy ImmutableImmediateHierarchy.withSelf(Object)"})
  void testWithSelf_thenReturnBuilderParentParentSelfFortyTwoBuild() {
    // Arrange
    Builder<Object> builderResult = ImmutableImmediateHierarchy.builder();
    ImmutableImmediateHierarchy<Object> immutableImmediateHierarchy =
        builderResult.parent("Parent").self(42).build();

    // Act
    ImmutableImmediateHierarchy<Object> actualWithSelfResult =
        immutableImmediateHierarchy.withSelf(42);

    // Assert
    assertSame(immutableImmediateHierarchy, actualWithSelfResult);
  }
}
