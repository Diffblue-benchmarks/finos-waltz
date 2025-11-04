package org.finos.waltz.model.entity_hierarchy;

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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ParentIdProvider;
import org.junit.jupiter.api.Test;

class ImmutableEntityHierarchyItemDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableEntityHierarchyItem.Builder#ancestorLevel(int)}
   */
  @Test
  void testBuilderAncestorLevel() {
    // Arrange
    ImmutableEntityHierarchyItem.Builder builderResult = ImmutableEntityHierarchyItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ancestorLevel(1));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityHierarchyItem.Builder#descendantLevel(int)}
   */
  @Test
  void testBuilderDescendantLevel() {
    // Arrange
    ImmutableEntityHierarchyItem.Builder builderResult = ImmutableEntityHierarchyItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.descendantLevel(3));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityHierarchyItem.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityHierarchyItem.Builder builderResult = ImmutableEntityHierarchyItem.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableEntityHierarchyItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityHierarchyItem.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntityHierarchyItem.Builder builderResult = ImmutableEntityHierarchyItem.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableEntityHierarchyItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityHierarchyItem.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEntityHierarchyItem.Builder builderResult = ImmutableEntityHierarchyItem.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityHierarchyItem.Builder#from(ParentIdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableEntityHierarchyItem.Builder builderResult = ImmutableEntityHierarchyItem.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);

    // Act
    ImmutableEntityHierarchyItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityHierarchyItem.Builder#from(ParentIdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableEntityHierarchyItem.Builder builderResult = ImmutableEntityHierarchyItem.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentId()).thenReturn(emptyResult);

    // Act
    ImmutableEntityHierarchyItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityHierarchyItem.Builder#from(ParentIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableEntityHierarchyItem.Builder builderResult = ImmutableEntityHierarchyItem.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    when(instance.parentId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).parentId();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityHierarchyItem.Builder#from(EntityHierarchyItem)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableEntityHierarchyItem.Builder builderResult = ImmutableEntityHierarchyItem.builder();
    EntityHierarchyItem instance = mock(EntityHierarchyItem.class);
    when(instance.ancestorLevel()).thenReturn(1);
    when(instance.descendantLevel()).thenReturn(3);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableEntityHierarchyItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).parentId();
    verify(instance).ancestorLevel();
    verify(instance).descendantLevel();
    verify(instance).kind();
    ImmutableEntityHierarchyItem buildResult = builderResult.build();
    assertEquals(1, buildResult.ancestorLevel());
    assertEquals(3, buildResult.descendantLevel());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityHierarchyItem.Builder#from(EntityHierarchyItem)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableEntityHierarchyItem.Builder builderResult = ImmutableEntityHierarchyItem.builder();
    EntityHierarchyItem instance = mock(EntityHierarchyItem.class);
    when(instance.parentId()).thenThrow(new IllegalStateException("instance"));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).parentId();
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityHierarchyItem.Builder#from(EntityHierarchyItem)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableEntityHierarchyItem.Builder builderResult = ImmutableEntityHierarchyItem.builder();
    EntityHierarchyItem instance = mock(EntityHierarchyItem.class);
    when(instance.ancestorLevel()).thenReturn(1);
    when(instance.descendantLevel()).thenReturn(3);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableEntityHierarchyItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).parentId();
    verify(instance).ancestorLevel();
    verify(instance).descendantLevel();
    verify(instance).kind();
    ImmutableEntityHierarchyItem buildResult = builderResult.build();
    assertEquals(1, buildResult.ancestorLevel());
    assertEquals(3, buildResult.descendantLevel());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityHierarchyItem.Builder#from(EntityHierarchyItem)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableEntityHierarchyItem.Builder builderResult = ImmutableEntityHierarchyItem.builder();
    EntityHierarchyItem instance = mock(EntityHierarchyItem.class);
    when(instance.ancestorLevel()).thenReturn(1);
    when(instance.descendantLevel()).thenReturn(3);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableEntityHierarchyItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).parentId();
    verify(instance).ancestorLevel();
    verify(instance).descendantLevel();
    verify(instance).kind();
    ImmutableEntityHierarchyItem buildResult = builderResult.build();
    assertEquals(1, buildResult.ancestorLevel());
    assertEquals(3, buildResult.descendantLevel());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableEntityHierarchyItem.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableEntityHierarchyItem.Builder builderResult = ImmutableEntityHierarchyItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableEntityHierarchyItem.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableEntityHierarchyItem.Builder builderResult = ImmutableEntityHierarchyItem.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityHierarchyItem.Builder#kind(EntityKind)}
   */
  @Test
  void testBuilderKind() {
    // Arrange
    ImmutableEntityHierarchyItem.Builder builderResult = ImmutableEntityHierarchyItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityHierarchyItem.Builder#parentId(long)}
   */
  @Test
  void testBuilderParentId() {
    // Arrange
    ImmutableEntityHierarchyItem.Builder builderResult = ImmutableEntityHierarchyItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityHierarchyItem.Builder#parentId(Optional)}
   */
  @Test
  void testBuilderParentId2() {
    // Arrange
    ImmutableEntityHierarchyItem.Builder builderResult = ImmutableEntityHierarchyItem.builder();
    Optional<Long> parentId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.parentId(parentId));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityHierarchyItem#copyOf(EntityHierarchyItem)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntityHierarchyItem instance = mock(EntityHierarchyItem.class);
    when(instance.ancestorLevel()).thenReturn(1);
    when(instance.descendantLevel()).thenReturn(3);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableEntityHierarchyItem actualCopyOfResult = ImmutableEntityHierarchyItem.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).parentId();
    verify(instance).ancestorLevel();
    verify(instance).descendantLevel();
    verify(instance).kind();
    assertEquals(1, actualCopyOfResult.ancestorLevel());
    assertEquals(3, actualCopyOfResult.descendantLevel());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityHierarchyItem#copyOf(EntityHierarchyItem)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    EntityHierarchyItem instance = mock(EntityHierarchyItem.class);
    when(instance.ancestorLevel()).thenReturn(1);
    when(instance.descendantLevel()).thenReturn(3);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableEntityHierarchyItem actualCopyOfResult = ImmutableEntityHierarchyItem.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).parentId();
    verify(instance).ancestorLevel();
    verify(instance).descendantLevel();
    verify(instance).kind();
    assertEquals(1, actualCopyOfResult.ancestorLevel());
    assertEquals(3, actualCopyOfResult.descendantLevel());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityHierarchyItem#copyOf(EntityHierarchyItem)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    EntityHierarchyItem instance = mock(EntityHierarchyItem.class);
    when(instance.ancestorLevel()).thenReturn(1);
    when(instance.descendantLevel()).thenReturn(3);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableEntityHierarchyItem actualCopyOfResult = ImmutableEntityHierarchyItem.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).parentId();
    verify(instance).ancestorLevel();
    verify(instance).descendantLevel();
    verify(instance).kind();
    assertEquals(1, actualCopyOfResult.ancestorLevel());
    assertEquals(3, actualCopyOfResult.descendantLevel());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
  }

  /**
   * Method under test: {@link ImmutableEntityHierarchyItem.Json#ancestorLevel()}
   */
  @Test
  void testJsonAncestorLevel() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityHierarchyItem.Json()).ancestorLevel());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityHierarchyItem.Json#descendantLevel()}
   */
  @Test
  void testJsonDescendantLevel() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityHierarchyItem.Json()).descendantLevel());
  }

  /**
   * Method under test: {@link ImmutableEntityHierarchyItem.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityHierarchyItem.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableEntityHierarchyItem.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityHierarchyItem.Json()).kind());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableEntityHierarchyItem.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableEntityHierarchyItem.Json actualJson = new ImmutableEntityHierarchyItem.Json();

    // Assert
    assertNull(actualJson.kind);
    assertEquals(0, actualJson.ancestorLevel);
    assertEquals(0, actualJson.descendantLevel);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.parentId.isPresent());
    assertFalse(actualJson.ancestorLevelIsSet);
    assertFalse(actualJson.descendantLevelIsSet);
  }

  /**
   * Method under test: {@link ImmutableEntityHierarchyItem.Json#parentId()}
   */
  @Test
  void testJsonParentId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityHierarchyItem.Json()).parentId());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityHierarchyItem.Json#setAncestorLevel(int)}
   */
  @Test
  void testJsonSetAncestorLevel() {
    // Arrange
    ImmutableEntityHierarchyItem.Json json = new ImmutableEntityHierarchyItem.Json();

    // Act
    json.setAncestorLevel(1);

    // Assert
    assertEquals(1, json.ancestorLevel);
    assertTrue(json.ancestorLevelIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityHierarchyItem.Json#setDescendantLevel(int)}
   */
  @Test
  void testJsonSetDescendantLevel() {
    // Arrange
    ImmutableEntityHierarchyItem.Json json = new ImmutableEntityHierarchyItem.Json();

    // Act
    json.setDescendantLevel(3);

    // Assert
    assertEquals(3, json.descendantLevel);
    assertTrue(json.descendantLevelIsSet);
  }
}
