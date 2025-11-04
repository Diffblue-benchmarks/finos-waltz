package org.finos.waltz.model.entity_hierarchy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ImmutableEntityHierarchyDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableEntityHierarchy.Builder#addAllHierarchyItems(Iterable)}
   */
  @Test
  void testBuilderAddAllHierarchyItems() {
    // Arrange
    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllHierarchyItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityHierarchy.Builder#addHierarchyItems(EntityHierarchyItem)}
   */
  @Test
  void testBuilderAddHierarchyItems() {
    // Arrange
    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    ImmutableEntityHierarchyItem.Json element = new ImmutableEntityHierarchyItem.Json();

    // Act
    ImmutableEntityHierarchy.Builder actualAddHierarchyItemsResult = builderResult.addHierarchyItems(element);

    // Assert
    List<EntityHierarchyItem> hierarchyItemsResult = builderResult.build().hierarchyItems();
    assertEquals(1, hierarchyItemsResult.size());
    assertSame(element, hierarchyItemsResult.get(0));
    assertSame(builderResult, actualAddHierarchyItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityHierarchy.Builder#addHierarchyItems(EntityHierarchyItem[])}
   */
  @Test
  void testBuilderAddHierarchyItems2() {
    // Arrange
    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    ImmutableEntityHierarchyItem.Json json = new ImmutableEntityHierarchyItem.Json();

    // Act
    ImmutableEntityHierarchy.Builder actualAddHierarchyItemsResult = builderResult.addHierarchyItems(json);

    // Assert
    List<EntityHierarchyItem> hierarchyItemsResult = builderResult.build().hierarchyItems();
    assertEquals(1, hierarchyItemsResult.size());
    assertSame(json, hierarchyItemsResult.get(0));
    assertSame(builderResult, actualAddHierarchyItemsResult);
  }

  /**
   * Method under test: {@link ImmutableEntityHierarchy.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableEntityHierarchy.builder().build().hierarchyItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityHierarchy.Builder#from(EntityHierarchy)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    EntityHierarchy instance = mock(EntityHierarchy.class);
    when(instance.hierarchyItems()).thenReturn(new ArrayList<>());

    // Act
    ImmutableEntityHierarchy.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).hierarchyItems();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityHierarchy.Builder#from(EntityHierarchy)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();

    ArrayList<EntityHierarchyItem> entityHierarchyItemList = new ArrayList<>();
    ImmutableEntityHierarchyItem.Json json = new ImmutableEntityHierarchyItem.Json();
    entityHierarchyItemList.add(json);
    EntityHierarchy instance = mock(EntityHierarchy.class);
    when(instance.hierarchyItems()).thenReturn(entityHierarchyItemList);

    // Act
    ImmutableEntityHierarchy.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).hierarchyItems();
    List<EntityHierarchyItem> hierarchyItemsResult = builderResult.build().hierarchyItems();
    assertEquals(1, hierarchyItemsResult.size());
    assertSame(json, hierarchyItemsResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityHierarchy.Builder#hierarchyItems(Iterable)}
   */
  @Test
  void testBuilderHierarchyItems() {
    // Arrange
    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.hierarchyItems(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableEntityHierarchy#copyOf(EntityHierarchy)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntityHierarchy instance = mock(EntityHierarchy.class);
    when(instance.hierarchyItems()).thenReturn(new ArrayList<>());

    // Act
    ImmutableEntityHierarchy actualCopyOfResult = ImmutableEntityHierarchy.copyOf(instance);

    // Assert
    verify(instance).hierarchyItems();
    assertTrue(actualCopyOfResult.hierarchyItems().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableEntityHierarchy#copyOf(EntityHierarchy)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<EntityHierarchyItem> entityHierarchyItemList = new ArrayList<>();
    entityHierarchyItemList.add(new ImmutableEntityHierarchyItem.Json());
    EntityHierarchy instance = mock(EntityHierarchy.class);
    when(instance.hierarchyItems()).thenReturn(entityHierarchyItemList);

    // Act
    ImmutableEntityHierarchy actualCopyOfResult = ImmutableEntityHierarchy.copyOf(instance);

    // Assert
    verify(instance).hierarchyItems();
    assertEquals(entityHierarchyItemList, actualCopyOfResult.hierarchyItems());
  }

  /**
   * Method under test: {@link ImmutableEntityHierarchy#copyOf(EntityHierarchy)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<EntityHierarchyItem> entityHierarchyItemList = new ArrayList<>();
    entityHierarchyItemList.add(new ImmutableEntityHierarchyItem.Json());
    entityHierarchyItemList.add(new ImmutableEntityHierarchyItem.Json());
    EntityHierarchy instance = mock(EntityHierarchy.class);
    when(instance.hierarchyItems()).thenReturn(entityHierarchyItemList);

    // Act
    ImmutableEntityHierarchy actualCopyOfResult = ImmutableEntityHierarchy.copyOf(instance);

    // Assert
    verify(instance).hierarchyItems();
    assertEquals(entityHierarchyItemList, actualCopyOfResult.hierarchyItems());
  }
}
