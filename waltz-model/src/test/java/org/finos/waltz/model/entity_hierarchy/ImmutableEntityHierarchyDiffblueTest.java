package org.finos.waltz.model.entity_hierarchy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.entity_hierarchy.ImmutableEntityHierarchy.Builder;
import org.finos.waltz.model.entity_hierarchy.ImmutableEntityHierarchyItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityHierarchyDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllHierarchyItems(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return build hierarchyItems Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllHierarchyItems(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllHierarchyItems(Iterable); when ArrayList(); then return build hierarchyItems Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllHierarchyItems(Iterable)"})
  void testBuilderAddAllHierarchyItems_whenArrayList_thenReturnBuildHierarchyItemsEmpty() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchy.builder();

    // Act
    Builder actualAddAllHierarchyItemsResult =
        builderResult.addAllHierarchyItems(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllHierarchyItemsResult.build().hierarchyItems().isEmpty());
    assertSame(builderResult, actualAddAllHierarchyItemsResult);
  }

  /**
   * Test Builder {@link Builder#addHierarchyItems(EntityHierarchyItem)} with {@code element}.
   *
   * <ul>
   *   <li>Then builder build hierarchyItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addHierarchyItems(EntityHierarchyItem)}
   */
  @Test
  @DisplayName(
      "Test Builder addHierarchyItems(EntityHierarchyItem) with 'element'; then builder build hierarchyItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addHierarchyItems(EntityHierarchyItem)"})
  void testBuilderAddHierarchyItemsWithElement_thenBuilderBuildHierarchyItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchy.builder();
    Json element = new Json();

    // Act
    Builder actualAddHierarchyItemsResult = builderResult.addHierarchyItems(element);

    // Assert
    List<EntityHierarchyItem> hierarchyItemsResult = builderResult.build().hierarchyItems();
    assertEquals(1, hierarchyItemsResult.size());
    assertSame(element, hierarchyItemsResult.get(0));
    assertSame(builderResult, actualAddHierarchyItemsResult);
  }

  /**
   * Test Builder {@link Builder#addHierarchyItems(EntityHierarchyItem[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then builder build hierarchyItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addHierarchyItems(EntityHierarchyItem[])}
   */
  @Test
  @DisplayName(
      "Test Builder addHierarchyItems(EntityHierarchyItem[]) with 'elements'; then builder build hierarchyItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addHierarchyItems(EntityHierarchyItem[])"})
  void testBuilderAddHierarchyItemsWithElements_thenBuilderBuildHierarchyItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchy.builder();
    Json json = new Json();

    // Act
    Builder actualAddHierarchyItemsResult = builderResult.addHierarchyItems(json);

    // Assert
    List<EntityHierarchyItem> hierarchyItemsResult = builderResult.build().hierarchyItems();
    assertEquals(1, hierarchyItemsResult.size());
    assertSame(json, hierarchyItemsResult.get(0));
    assertSame(builderResult, actualAddHierarchyItemsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityHierarchy Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableEntityHierarchy.builder().build().hierarchyItems().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(EntityHierarchy)}.
   *
   * <ul>
   *   <li>Then return build hierarchyItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityHierarchy)}
   */
  @Test
  @DisplayName("Test Builder from(EntityHierarchy); then return build hierarchyItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityHierarchy)"})
  void testBuilderFrom_thenReturnBuildHierarchyItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchy.builder();

    Builder builderResult2 = ImmutableEntityHierarchy.builder();
    builderResult2.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    ImmutableEntityHierarchy instance = builderResult2.build();

    // Act and Assert
    List<EntityHierarchyItem> hierarchyItemsResult =
        builderResult.from(instance).build().hierarchyItems();
    assertEquals(1, hierarchyItemsResult.size());
    EntityHierarchyItem getResult = hierarchyItemsResult.get(0);
    assertTrue(getResult instanceof ImmutableEntityHierarchyItem);
    assertEquals(1, getResult.ancestorLevel());
    assertEquals(3, getResult.descendantLevel());
    assertEquals(EntityKind.ALL, getResult.kind());
    ImmutableEntityHierarchy actualImmutableEntityHierarchy = builderResult.build();
    assertEquals(instance, actualImmutableEntityHierarchy);
  }

  /**
   * Test Builder {@link Builder#from(EntityHierarchy)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityHierarchy)}
   */
  @Test
  @DisplayName("Test Builder from(EntityHierarchy); when builder build; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityHierarchy)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchy.builder();
    ImmutableEntityHierarchy instance = ImmutableEntityHierarchy.builder().build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityHierarchy actualImmutableEntityHierarchy = builderResult.build();
    assertEquals(instance, actualImmutableEntityHierarchy);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#hierarchyItems(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return build hierarchyItems Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#hierarchyItems(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder hierarchyItems(Iterable); when ArrayList(); then return build hierarchyItems Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.hierarchyItems(Iterable)"})
  void testBuilderHierarchyItems_whenArrayList_thenReturnBuildHierarchyItemsEmpty() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchy.builder();

    // Act
    Builder actualHierarchyItemsResult = builderResult.hierarchyItems(new ArrayList<>());

    // Assert
    assertTrue(actualHierarchyItemsResult.build().hierarchyItems().isEmpty());
    assertSame(builderResult, actualHierarchyItemsResult);
  }

  /**
   * Test {@link ImmutableEntityHierarchy#copyOf(EntityHierarchy)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return hierarchyItems Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityHierarchy#copyOf(EntityHierarchy)}
   */
  @Test
  @DisplayName("Test copyOf(EntityHierarchy); when builder build; then return hierarchyItems Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityHierarchy ImmutableEntityHierarchy.copyOf(EntityHierarchy)"})
  void testCopyOf_whenBuilderBuild_thenReturnHierarchyItemsEmpty() {
    // Arrange
    ImmutableEntityHierarchy instance = ImmutableEntityHierarchy.builder().build();

    // Act and Assert
    assertTrue(ImmutableEntityHierarchy.copyOf(instance).hierarchyItems().isEmpty());
  }

  /**
   * Test {@link ImmutableEntityHierarchy#equals(Object)}, and {@link
   * ImmutableEntityHierarchy#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityHierarchy#equals(Object)}
   *   <li>{@link ImmutableEntityHierarchy#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityHierarchy.equals(Object)",
    "int ImmutableEntityHierarchy.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableEntityHierarchy immutableEntityHierarchy = ImmutableEntityHierarchy.builder().build();
    ImmutableEntityHierarchy immutableEntityHierarchy2 = ImmutableEntityHierarchy.builder().build();

    // Act and Assert
    assertEquals(immutableEntityHierarchy, immutableEntityHierarchy2);
    assertEquals(immutableEntityHierarchy.hashCode(), immutableEntityHierarchy2.hashCode());
  }

  /**
   * Test {@link ImmutableEntityHierarchy#equals(Object)}, and {@link
   * ImmutableEntityHierarchy#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityHierarchy#equals(Object)}
   *   <li>{@link ImmutableEntityHierarchy#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityHierarchy.equals(Object)",
    "int ImmutableEntityHierarchy.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableEntityHierarchy immutableEntityHierarchy = ImmutableEntityHierarchy.builder().build();

    // Act and Assert
    assertEquals(immutableEntityHierarchy, immutableEntityHierarchy);
    int expectedHashCodeResult = immutableEntityHierarchy.hashCode();
    assertEquals(expectedHashCodeResult, immutableEntityHierarchy.hashCode());
  }

  /**
   * Test {@link ImmutableEntityHierarchy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityHierarchy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityHierarchy.equals(Object)",
    "int ImmutableEntityHierarchy.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableEntityHierarchy.builder().build());
  }

  /**
   * Test {@link ImmutableEntityHierarchy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityHierarchy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityHierarchy.equals(Object)",
    "int ImmutableEntityHierarchy.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableEntityHierarchy.builder().build(), null);
  }

  /**
   * Test {@link ImmutableEntityHierarchy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityHierarchy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityHierarchy.equals(Object)",
    "int ImmutableEntityHierarchy.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableEntityHierarchy.builder().build(), "Different type to ImmutableEntityHierarchy");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityHierarchy#toString()}
   *   <li>{@link ImmutableEntityHierarchy#hierarchyItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ImmutableEntityHierarchy.hierarchyItems()",
    "String ImmutableEntityHierarchy.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableEntityHierarchy immutableEntityHierarchy = ImmutableEntityHierarchy.builder().build();

    // Act
    String actualToStringResult = immutableEntityHierarchy.toString();

    // Assert
    assertEquals("EntityHierarchy{hierarchyItems=[]}", actualToStringResult);
    assertTrue(immutableEntityHierarchy.hierarchyItems().isEmpty());
  }

  /**
   * Test {@link ImmutableEntityHierarchy#withHierarchyItems(EntityHierarchyItem[])} with {@code
   * EntityHierarchyItem[]}.
   *
   * <p>Method under test: {@link
   * ImmutableEntityHierarchy#withHierarchyItems(EntityHierarchyItem[])}
   */
  @Test
  @DisplayName("Test withHierarchyItems(EntityHierarchyItem[]) with 'EntityHierarchyItem[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityHierarchy ImmutableEntityHierarchy.withHierarchyItems(EntityHierarchyItem[])"
  })
  void testWithHierarchyItemsWithEntityHierarchyItem() {
    // Arrange
    ImmutableEntityHierarchy immutableEntityHierarchy = ImmutableEntityHierarchy.builder().build();

    // Act and Assert
    List<EntityHierarchyItem> hierarchyItemsResult =
        immutableEntityHierarchy
            .withHierarchyItems(
                ImmutableEntityHierarchyItem.builder()
                    .ancestorLevel(1)
                    .descendantLevel(3)
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .parentId(1L)
                    .build())
            .hierarchyItems();
    assertEquals(1, hierarchyItemsResult.size());
    EntityHierarchyItem getResult = hierarchyItemsResult.get(0);
    assertTrue(getResult instanceof ImmutableEntityHierarchyItem);
    assertEquals(1, getResult.ancestorLevel());
    assertEquals(3, getResult.descendantLevel());
    assertEquals(EntityKind.ALL, getResult.kind());
  }
}
