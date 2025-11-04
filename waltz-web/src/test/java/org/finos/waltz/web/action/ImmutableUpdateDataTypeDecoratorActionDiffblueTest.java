package org.finos.waltz.web.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import freemarker.core._SortedArraySet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableUpdateDataTypeDecoratorActionDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction.Builder#addAddedDataTypeIds(long)}
   */
  @Test
  void testBuilderAddAddedDataTypeIds() {
    // Arrange
    ImmutableUpdateDataTypeDecoratorAction.Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAddedDataTypeIds(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction.Builder#addAddedDataTypeIds(long[])}
   */
  @Test
  void testBuilderAddAddedDataTypeIds2() {
    // Arrange
    ImmutableUpdateDataTypeDecoratorAction.Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAddedDataTypeIds(1L, -2L, 1L, -2L));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction.Builder#addAllAddedDataTypeIds(Iterable)}
   */
  @Test
  void testBuilderAddAllAddedDataTypeIds() {
    // Arrange
    ImmutableUpdateDataTypeDecoratorAction.Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAddedDataTypeIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction.Builder#addAllAddedDataTypeIds(Iterable)}
   */
  @Test
  void testBuilderAddAllAddedDataTypeIds2() {
    // Arrange
    ImmutableUpdateDataTypeDecoratorAction.Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAddedDataTypeIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction.Builder#addAllRemovedDataTypeIds(Iterable)}
   */
  @Test
  void testBuilderAddAllRemovedDataTypeIds() {
    // Arrange
    ImmutableUpdateDataTypeDecoratorAction.Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRemovedDataTypeIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction.Builder#addAllRemovedDataTypeIds(Iterable)}
   */
  @Test
  void testBuilderAddAllRemovedDataTypeIds2() {
    // Arrange
    ImmutableUpdateDataTypeDecoratorAction.Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRemovedDataTypeIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction.Builder#addRemovedDataTypeIds(long)}
   */
  @Test
  void testBuilderAddRemovedDataTypeIds() {
    // Arrange
    ImmutableUpdateDataTypeDecoratorAction.Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRemovedDataTypeIds(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction.Builder#addRemovedDataTypeIds(long[])}
   */
  @Test
  void testBuilderAddRemovedDataTypeIds2() {
    // Arrange
    ImmutableUpdateDataTypeDecoratorAction.Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRemovedDataTypeIds(1L, -2L, 1L, -2L));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction.Builder#addedDataTypeIds(Iterable)}
   */
  @Test
  void testBuilderAddedDataTypeIds() {
    // Arrange
    ImmutableUpdateDataTypeDecoratorAction.Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addedDataTypeIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction.Builder#addedDataTypeIds(Iterable)}
   */
  @Test
  void testBuilderAddedDataTypeIds2() {
    // Arrange
    ImmutableUpdateDataTypeDecoratorAction.Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addedDataTypeIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableUpdateDataTypeDecoratorAction.Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();
    EntityReference entityReference = mock(EntityReference.class);

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(entityReference));
    assertSame(entityReference, builderResult.build().entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction.Builder#from(UpdateDataTypeDecoratorAction)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableUpdateDataTypeDecoratorAction.Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();
    UpdateDataTypeDecoratorAction instance = mock(UpdateDataTypeDecoratorAction.class);
    when(instance.addedDataTypeIds()).thenReturn(new HashSet<>());
    when(instance.removedDataTypeIds()).thenReturn(new HashSet<>());
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableUpdateDataTypeDecoratorAction.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).addedDataTypeIds();
    verify(instance).entityReference();
    verify(instance).removedDataTypeIds();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction.Builder#from(UpdateDataTypeDecoratorAction)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableUpdateDataTypeDecoratorAction.Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    UpdateDataTypeDecoratorAction instance = mock(UpdateDataTypeDecoratorAction.class);
    when(instance.addedDataTypeIds()).thenReturn(resultLongSet);
    when(instance.removedDataTypeIds()).thenReturn(new HashSet<>());
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableUpdateDataTypeDecoratorAction.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).addedDataTypeIds();
    verify(instance).entityReference();
    verify(instance).removedDataTypeIds();
    Set<Long> addedDataTypeIdsResult = builderResult.build().addedDataTypeIds();
    assertEquals(1, addedDataTypeIdsResult.size());
    assertTrue(addedDataTypeIdsResult.contains(-2L));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction.Builder#from(UpdateDataTypeDecoratorAction)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableUpdateDataTypeDecoratorAction.Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    UpdateDataTypeDecoratorAction instance = mock(UpdateDataTypeDecoratorAction.class);
    when(instance.addedDataTypeIds()).thenReturn(new HashSet<>());
    when(instance.removedDataTypeIds()).thenReturn(resultLongSet);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableUpdateDataTypeDecoratorAction.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).addedDataTypeIds();
    verify(instance).entityReference();
    verify(instance).removedDataTypeIds();
    Set<Long> removedDataTypeIdsResult = builderResult.build().removedDataTypeIds();
    assertEquals(1, removedDataTypeIdsResult.size());
    assertTrue(removedDataTypeIdsResult.contains(-2L));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction.Builder#from(UpdateDataTypeDecoratorAction)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableUpdateDataTypeDecoratorAction.Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();
    UpdateDataTypeDecoratorAction instance = mock(UpdateDataTypeDecoratorAction.class);
    when(instance.addedDataTypeIds()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).addedDataTypeIds();
    verify(instance).entityReference();
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction.Builder#removedDataTypeIds(Iterable)}
   */
  @Test
  void testBuilderRemovedDataTypeIds() {
    // Arrange
    ImmutableUpdateDataTypeDecoratorAction.Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.removedDataTypeIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction.Builder#removedDataTypeIds(Iterable)}
   */
  @Test
  void testBuilderRemovedDataTypeIds2() {
    // Arrange
    ImmutableUpdateDataTypeDecoratorAction.Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.removedDataTypeIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction#copyOf(UpdateDataTypeDecoratorAction)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    UpdateDataTypeDecoratorAction instance = mock(UpdateDataTypeDecoratorAction.class);
    when(instance.addedDataTypeIds()).thenReturn(new HashSet<>());
    when(instance.removedDataTypeIds()).thenReturn(new HashSet<>());
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableUpdateDataTypeDecoratorAction actualCopyOfResult = ImmutableUpdateDataTypeDecoratorAction.copyOf(instance);

    // Assert
    verify(instance).addedDataTypeIds();
    verify(instance).entityReference();
    verify(instance).removedDataTypeIds();
    Set<Long> addedDataTypeIdsResult = actualCopyOfResult.addedDataTypeIds();
    assertTrue(addedDataTypeIdsResult.isEmpty());
    assertSame(addedDataTypeIdsResult, actualCopyOfResult.removedDataTypeIds());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction#copyOf(UpdateDataTypeDecoratorAction)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    UpdateDataTypeDecoratorAction instance = mock(UpdateDataTypeDecoratorAction.class);
    when(instance.addedDataTypeIds()).thenReturn(resultLongSet);
    when(instance.removedDataTypeIds()).thenReturn(new HashSet<>());
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableUpdateDataTypeDecoratorAction actualCopyOfResult = ImmutableUpdateDataTypeDecoratorAction.copyOf(instance);

    // Assert
    verify(instance).addedDataTypeIds();
    verify(instance).entityReference();
    verify(instance).removedDataTypeIds();
    Set<Long> addedDataTypeIdsResult = actualCopyOfResult.addedDataTypeIds();
    assertEquals(1, addedDataTypeIdsResult.size());
    assertTrue(addedDataTypeIdsResult.contains(1L));
    assertTrue(actualCopyOfResult.removedDataTypeIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction#copyOf(UpdateDataTypeDecoratorAction)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    resultLongSet.add(1L);
    UpdateDataTypeDecoratorAction instance = mock(UpdateDataTypeDecoratorAction.class);
    when(instance.addedDataTypeIds()).thenReturn(resultLongSet);
    when(instance.removedDataTypeIds()).thenReturn(new HashSet<>());
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableUpdateDataTypeDecoratorAction actualCopyOfResult = ImmutableUpdateDataTypeDecoratorAction.copyOf(instance);

    // Assert
    verify(instance).addedDataTypeIds();
    verify(instance).entityReference();
    verify(instance).removedDataTypeIds();
    assertTrue(actualCopyOfResult.removedDataTypeIds().isEmpty());
    assertEquals(resultLongSet, actualCopyOfResult.addedDataTypeIds());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction#copyOf(UpdateDataTypeDecoratorAction)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    UpdateDataTypeDecoratorAction instance = mock(UpdateDataTypeDecoratorAction.class);
    when(instance.addedDataTypeIds()).thenReturn(new HashSet<>());
    when(instance.removedDataTypeIds()).thenReturn(resultLongSet);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableUpdateDataTypeDecoratorAction actualCopyOfResult = ImmutableUpdateDataTypeDecoratorAction.copyOf(instance);

    // Assert
    verify(instance).addedDataTypeIds();
    verify(instance).entityReference();
    verify(instance).removedDataTypeIds();
    Set<Long> removedDataTypeIdsResult = actualCopyOfResult.removedDataTypeIds();
    assertEquals(1, removedDataTypeIdsResult.size());
    assertTrue(removedDataTypeIdsResult.contains(1L));
    assertTrue(actualCopyOfResult.addedDataTypeIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction#fromJson(ImmutableUpdateDataTypeDecoratorAction.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableUpdateDataTypeDecoratorAction.Json json = new ImmutableUpdateDataTypeDecoratorAction.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    ImmutableUpdateDataTypeDecoratorAction actualFromJsonResult = ImmutableUpdateDataTypeDecoratorAction.fromJson(json);

    // Assert
    Set<Long> addedDataTypeIdsResult = actualFromJsonResult.addedDataTypeIds();
    assertTrue(addedDataTypeIdsResult.isEmpty());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
    Set<Long> resultLongSet = json.removedDataTypeIds;
    assertSame(resultLongSet, addedDataTypeIdsResult);
    assertSame(resultLongSet, actualFromJsonResult.removedDataTypeIds());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction#fromJson(ImmutableUpdateDataTypeDecoratorAction.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(1L);
    _SortedArraySet<Long> addedDataTypeIds = mock(_SortedArraySet.class);
    when(addedDataTypeIds.iterator()).thenReturn(resultLongList.iterator());
    _SortedArraySet<Long> removedDataTypeIds = mock(_SortedArraySet.class);

    ArrayList<Long> resultLongList2 = new ArrayList<>();
    when(removedDataTypeIds.iterator()).thenReturn(resultLongList2.iterator());

    ImmutableUpdateDataTypeDecoratorAction.Json json = new ImmutableUpdateDataTypeDecoratorAction.Json();
    json.setEntityReference(mock(EntityReference.class));
    json.setAddedDataTypeIds(addedDataTypeIds);
    json.setRemovedDataTypeIds(removedDataTypeIds);

    // Act
    ImmutableUpdateDataTypeDecoratorAction actualFromJsonResult = ImmutableUpdateDataTypeDecoratorAction.fromJson(json);

    // Assert
    verify(addedDataTypeIds).iterator();
    verify(removedDataTypeIds).iterator();
    Set<Long> addedDataTypeIdsResult = actualFromJsonResult.addedDataTypeIds();
    assertEquals(1, addedDataTypeIdsResult.size());
    assertTrue(addedDataTypeIdsResult.contains(1L));
    assertTrue(actualFromJsonResult.removedDataTypeIds().isEmpty());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction#fromJson(ImmutableUpdateDataTypeDecoratorAction.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(0L);
    resultLongList.add(1L);
    _SortedArraySet<Long> addedDataTypeIds = mock(_SortedArraySet.class);
    when(addedDataTypeIds.iterator()).thenReturn(resultLongList.iterator());
    _SortedArraySet<Long> removedDataTypeIds = mock(_SortedArraySet.class);

    ArrayList<Long> resultLongList2 = new ArrayList<>();
    when(removedDataTypeIds.iterator()).thenReturn(resultLongList2.iterator());

    ImmutableUpdateDataTypeDecoratorAction.Json json = new ImmutableUpdateDataTypeDecoratorAction.Json();
    json.setEntityReference(mock(EntityReference.class));
    json.setAddedDataTypeIds(addedDataTypeIds);
    json.setRemovedDataTypeIds(removedDataTypeIds);

    // Act
    ImmutableUpdateDataTypeDecoratorAction actualFromJsonResult = ImmutableUpdateDataTypeDecoratorAction.fromJson(json);

    // Assert
    verify(addedDataTypeIds).iterator();
    verify(removedDataTypeIds).iterator();
    Set<Long> addedDataTypeIdsResult = actualFromJsonResult.addedDataTypeIds();
    assertEquals(2, addedDataTypeIdsResult.size());
    assertTrue(addedDataTypeIdsResult.contains(0L));
    assertTrue(addedDataTypeIdsResult.contains(1L));
    assertTrue(actualFromJsonResult.removedDataTypeIds().isEmpty());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction.Json#addedDataTypeIds()}
   */
  @Test
  void testJsonAddedDataTypeIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableUpdateDataTypeDecoratorAction.Json()).addedDataTypeIds());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableUpdateDataTypeDecoratorAction.Json()).entityReference());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableUpdateDataTypeDecoratorAction.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableUpdateDataTypeDecoratorAction.Json actualJson = new ImmutableUpdateDataTypeDecoratorAction.Json();

    // Assert
    assertNull(actualJson.entityReference);
    assertTrue(actualJson.addedDataTypeIds.isEmpty());
    assertTrue(actualJson.removedDataTypeIds.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataTypeDecoratorAction.Json#removedDataTypeIds()}
   */
  @Test
  void testJsonRemovedDataTypeIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableUpdateDataTypeDecoratorAction.Json()).removedDataTypeIds());
  }
}
