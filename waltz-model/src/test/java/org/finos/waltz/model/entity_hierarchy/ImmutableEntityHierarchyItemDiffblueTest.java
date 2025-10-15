package org.finos.waltz.model.entity_hierarchy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ParentIdProvider;
import org.finos.waltz.model.entity_hierarchy.ImmutableEntityHierarchyItem.Builder;
import org.finos.waltz.model.entity_hierarchy.ImmutableEntityHierarchyItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityHierarchyItemDiffblueTest {
  /**
   * Test Builder {@link Builder#ancestorLevel(int)}.
   *
   * <p>Method under test: {@link Builder#ancestorLevel(int)}
   */
  @Test
  @DisplayName("Test Builder ancestorLevel(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ancestorLevel(int)"})
  void testBuilderAncestorLevel() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();

    // Act
    Builder actualAncestorLevelResult = builderResult.ancestorLevel(1);

    // Assert
    assertSame(builderResult, actualAncestorLevelResult);
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
  @MethodsUnderTest({"ImmutableEntityHierarchyItem Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutableEntityHierarchyItem.builder().ancestorLevel(1).descendantLevel(3).id(1L);
    Optional<Long> id = Optional.of(1L);
    Builder actualParentIdResult = actualIdResult.id(id).kind(EntityKind.ALL).parentId(1L);
    Optional<Long> parentId = Optional.of(1L);
    ImmutableEntityHierarchyItem actualImmutableEntityHierarchyItem =
        actualParentIdResult.parentId(parentId).build();

    // Assert
    assertEquals(1, actualImmutableEntityHierarchyItem.ancestorLevel());
    assertEquals(3, actualImmutableEntityHierarchyItem.descendantLevel());
    assertEquals(EntityKind.ALL, actualImmutableEntityHierarchyItem.kind());
  }

  /**
   * Test Builder {@link Builder#descendantLevel(int)}.
   *
   * <p>Method under test: {@link Builder#descendantLevel(int)}
   */
  @Test
  @DisplayName("Test Builder descendantLevel(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.descendantLevel(int)"})
  void testBuilderDescendantLevel() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();

    // Act
    Builder actualDescendantLevelResult = builderResult.descendantLevel(3);

    // Assert
    assertSame(builderResult, actualDescendantLevelResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityHierarchyItem)} with {@code EntityHierarchyItem}.
   *
   * <p>Method under test: {@link Builder#from(EntityHierarchyItem)}
   */
  @Test
  @DisplayName("Test Builder from(EntityHierarchyItem) with 'EntityHierarchyItem'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityHierarchyItem)"})
  void testBuilderFromWithEntityHierarchyItem() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();
    ImmutableEntityHierarchyItem instance =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityHierarchyItem actualImmutableEntityHierarchyItem = builderResult.build();
    assertEquals(instance, actualImmutableEntityHierarchyItem);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();
    ImmutableEntityHierarchyItem instance =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableEntityHierarchyItem actualImmutableEntityHierarchyItem = builderResult.build();
    assertEquals(instance, actualImmutableEntityHierarchyItem);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given of one.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of one; when IdProvider id() return of one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfOne_whenIdProviderIdReturnOfOne() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();
    ImmutableEntityHierarchyItem instance =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ParentIdProvider) instance);

    // Assert
    ImmutableEntityHierarchyItem actualImmutableEntityHierarchyItem = builderResult.build();
    assertEquals(instance, actualImmutableEntityHierarchyItem);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'; given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();

    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentId()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   *
   * <ul>
   *   <li>Given of one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'; given of one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider_givenOfOne() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();

    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(instance.parentId()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ParentIdProvider) with 'ParentIdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();

    ParentIdProvider instance = mock(ParentIdProvider.class);
    when(instance.parentId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).parentId();
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#kind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#kind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder kind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.kind(EntityKind)"})
  void testBuilderKind() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();

    // Act
    Builder actualKindResult = builderResult.kind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualKindResult);
  }

  /**
   * Test Builder {@link Builder#parentId(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#parentId(long)}
   */
  @Test
  @DisplayName("Test Builder parentId(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentId(long)"})
  void testBuilderParentIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();

    // Act
    Builder actualParentIdResult = builderResult.parentId(1L);

    // Assert
    assertSame(builderResult, actualParentIdResult);
  }

  /**
   * Test Builder {@link Builder#parentId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#parentId(Optional)}
   */
  @Test
  @DisplayName("Test Builder parentId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentId(Optional)"})
  void testBuilderParentIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();
    Optional<Long> parentId = Optional.of(1L);

    // Act
    Builder actualParentIdResult = builderResult.parentId(parentId);

    // Assert
    assertSame(builderResult, actualParentIdResult);
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#copyOf(EntityHierarchyItem)}.
   *
   * <ul>
   *   <li>Then return ancestorLevel is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityHierarchyItem#copyOf(EntityHierarchyItem)}
   */
  @Test
  @DisplayName("Test copyOf(EntityHierarchyItem); then return ancestorLevel is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityHierarchyItem ImmutableEntityHierarchyItem.copyOf(EntityHierarchyItem)"
  })
  void testCopyOf_thenReturnAncestorLevelIsOne() {
    // Arrange
    ImmutableEntityHierarchyItem instance =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build();

    // Act
    ImmutableEntityHierarchyItem actualCopyOfResult = ImmutableEntityHierarchyItem.copyOf(instance);

    // Assert
    assertEquals(1, actualCopyOfResult.ancestorLevel());
    assertEquals(3, actualCopyOfResult.descendantLevel());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#equals(Object)}, and {@link
   * ImmutableEntityHierarchyItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityHierarchyItem#equals(Object)}
   *   <li>{@link ImmutableEntityHierarchyItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityHierarchyItem.equals(Object)",
    "int ImmutableEntityHierarchyItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableEntityHierarchyItem immutableEntityHierarchyItem =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build();
    ImmutableEntityHierarchyItem immutableEntityHierarchyItem2 =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableEntityHierarchyItem, immutableEntityHierarchyItem2);
    assertEquals(immutableEntityHierarchyItem.hashCode(), immutableEntityHierarchyItem2.hashCode());
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#equals(Object)}, and {@link
   * ImmutableEntityHierarchyItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityHierarchyItem#equals(Object)}
   *   <li>{@link ImmutableEntityHierarchyItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityHierarchyItem.equals(Object)",
    "int ImmutableEntityHierarchyItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableEntityHierarchyItem immutableEntityHierarchyItem =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableEntityHierarchyItem, immutableEntityHierarchyItem);
    int expectedHashCodeResult = immutableEntityHierarchyItem.hashCode();
    assertEquals(expectedHashCodeResult, immutableEntityHierarchyItem.hashCode());
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityHierarchyItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityHierarchyItem.equals(Object)",
    "int ImmutableEntityHierarchyItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableEntityHierarchyItem immutableEntityHierarchyItem =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(3)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityHierarchyItem,
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityHierarchyItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityHierarchyItem.equals(Object)",
    "int ImmutableEntityHierarchyItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableEntityHierarchyItem immutableEntityHierarchyItem =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(1)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityHierarchyItem,
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityHierarchyItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityHierarchyItem.equals(Object)",
    "int ImmutableEntityHierarchyItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableEntityHierarchyItem immutableEntityHierarchyItem =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(2L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityHierarchyItem,
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityHierarchyItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityHierarchyItem.equals(Object)",
    "int ImmutableEntityHierarchyItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableEntityHierarchyItem immutableEntityHierarchyItem =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ACTOR)
            .parentId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityHierarchyItem,
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityHierarchyItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityHierarchyItem.equals(Object)",
    "int ImmutableEntityHierarchyItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableEntityHierarchyItem immutableEntityHierarchyItem =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(2L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityHierarchyItem,
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityHierarchyItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityHierarchyItem.equals(Object)",
    "int ImmutableEntityHierarchyItem.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityHierarchyItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityHierarchyItem.equals(Object)",
    "int ImmutableEntityHierarchyItem.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build(),
        "Different type to ImmutableEntityHierarchyItem");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityHierarchyItem#ancestorLevel()}
   *   <li>{@link ImmutableEntityHierarchyItem#descendantLevel()}
   *   <li>{@link ImmutableEntityHierarchyItem#kind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ImmutableEntityHierarchyItem.ancestorLevel()",
    "int ImmutableEntityHierarchyItem.descendantLevel()",
    "EntityKind ImmutableEntityHierarchyItem.kind()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableEntityHierarchyItem immutableEntityHierarchyItem =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build();

    // Act
    int actualAncestorLevelResult = immutableEntityHierarchyItem.ancestorLevel();
    int actualDescendantLevelResult = immutableEntityHierarchyItem.descendantLevel();

    // Assert
    assertEquals(1, actualAncestorLevelResult);
    assertEquals(3, actualDescendantLevelResult);
    assertEquals(EntityKind.ALL, immutableEntityHierarchyItem.kind());
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#id()}.
   *
   * <p>Method under test: {@link ImmutableEntityHierarchyItem#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableEntityHierarchyItem.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#ancestorLevel()}.
   *
   * <p>Method under test: {@link Json#ancestorLevel()}
   */
  @Test
  @DisplayName("Test Json ancestorLevel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.ancestorLevel()"})
  void testJsonAncestorLevel() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ancestorLevel());
  }

  /**
   * Test Json {@link Json#descendantLevel()}.
   *
   * <p>Method under test: {@link Json#descendantLevel()}
   */
  @Test
  @DisplayName("Test Json descendantLevel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.descendantLevel()"})
  void testJsonDescendantLevel() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().descendantLevel());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
  }

  /**
   * Test Json {@link Json#kind()}.
   *
   * <p>Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().kind());
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
    Json actualJson = new Json();

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
   * Test Json {@link Json#parentId()}.
   *
   * <p>Method under test: {@link Json#parentId()}
   */
  @Test
  @DisplayName("Test Json parentId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.parentId()"})
  void testJsonParentId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parentId());
  }

  /**
   * Test Json {@link Json#setAncestorLevel(int)}.
   *
   * <p>Method under test: {@link Json#setAncestorLevel(int)}
   */
  @Test
  @DisplayName("Test Json setAncestorLevel(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setAncestorLevel(int)"})
  void testJsonSetAncestorLevel() {
    // Arrange
    Json json = new Json();

    // Act
    json.setAncestorLevel(1);

    // Assert
    assertEquals(1, json.ancestorLevel);
    assertTrue(json.ancestorLevelIsSet);
  }

  /**
   * Test Json {@link Json#setDescendantLevel(int)}.
   *
   * <p>Method under test: {@link Json#setDescendantLevel(int)}
   */
  @Test
  @DisplayName("Test Json setDescendantLevel(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setDescendantLevel(int)"})
  void testJsonSetDescendantLevel() {
    // Arrange
    Json json = new Json();

    // Act
    json.setDescendantLevel(3);

    // Assert
    assertEquals(3, json.descendantLevel);
    assertTrue(json.descendantLevelIsSet);
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#parentId()}.
   *
   * <p>Method under test: {@link ImmutableEntityHierarchyItem#parentId()}
   */
  @Test
  @DisplayName("Test parentId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableEntityHierarchyItem.parentId()"})
  void testParentId() {
    // Arrange and Act
    Optional<Long> actualParentIdResult =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build()
            .parentId();

    // Assert
    assertEquals(1L, actualParentIdResult.get().longValue());
    assertTrue(actualParentIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#toString()}.
   *
   * <p>Method under test: {@link ImmutableEntityHierarchyItem#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableEntityHierarchyItem.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "EntityHierarchyItem{id=1, parentId=1, kind=ALL, descendantLevel=3, ancestorLevel=1}",
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#withAncestorLevel(int)}.
   *
   * <p>Method under test: {@link ImmutableEntityHierarchyItem#withAncestorLevel(int)}
   */
  @Test
  @DisplayName("Test withAncestorLevel(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityHierarchyItem ImmutableEntityHierarchyItem.withAncestorLevel(int)"
  })
  void testWithAncestorLevel() {
    // Arrange
    ImmutableEntityHierarchyItem immutableEntityHierarchyItem =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(42)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build();

    // Act
    ImmutableEntityHierarchyItem actualWithAncestorLevelResult =
        immutableEntityHierarchyItem.withAncestorLevel(42);

    // Assert
    assertSame(immutableEntityHierarchyItem, actualWithAncestorLevelResult);
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#withAncestorLevel(int)}.
   *
   * <ul>
   *   <li>Then return descendantLevel is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityHierarchyItem#withAncestorLevel(int)}
   */
  @Test
  @DisplayName("Test withAncestorLevel(int); then return descendantLevel is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityHierarchyItem ImmutableEntityHierarchyItem.withAncestorLevel(int)"
  })
  void testWithAncestorLevel_thenReturnDescendantLevelIsThree() {
    // Arrange and Act
    ImmutableEntityHierarchyItem actualWithAncestorLevelResult =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build()
            .withAncestorLevel(42);

    // Assert
    assertEquals(3, actualWithAncestorLevelResult.descendantLevel());
    assertEquals(42, actualWithAncestorLevelResult.ancestorLevel());
    assertEquals(EntityKind.ALL, actualWithAncestorLevelResult.kind());
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#withDescendantLevel(int)}.
   *
   * <p>Method under test: {@link ImmutableEntityHierarchyItem#withDescendantLevel(int)}
   */
  @Test
  @DisplayName("Test withDescendantLevel(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityHierarchyItem ImmutableEntityHierarchyItem.withDescendantLevel(int)"
  })
  void testWithDescendantLevel() {
    // Arrange
    ImmutableEntityHierarchyItem immutableEntityHierarchyItem =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(42)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build();

    // Act
    ImmutableEntityHierarchyItem actualWithDescendantLevelResult =
        immutableEntityHierarchyItem.withDescendantLevel(42);

    // Assert
    assertSame(immutableEntityHierarchyItem, actualWithDescendantLevelResult);
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#withDescendantLevel(int)}.
   *
   * <ul>
   *   <li>Then return ancestorLevel is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityHierarchyItem#withDescendantLevel(int)}
   */
  @Test
  @DisplayName("Test withDescendantLevel(int); then return ancestorLevel is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityHierarchyItem ImmutableEntityHierarchyItem.withDescendantLevel(int)"
  })
  void testWithDescendantLevel_thenReturnAncestorLevelIsOne() {
    // Arrange and Act
    ImmutableEntityHierarchyItem actualWithDescendantLevelResult =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build()
            .withDescendantLevel(42);

    // Assert
    assertEquals(1, actualWithDescendantLevelResult.ancestorLevel());
    assertEquals(42, actualWithDescendantLevelResult.descendantLevel());
    assertEquals(EntityKind.ALL, actualWithDescendantLevelResult.kind());
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableEntityHierarchyItem#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityHierarchyItem ImmutableEntityHierarchyItem.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableEntityHierarchyItem immutableEntityHierarchyItem =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableEntityHierarchyItem actualWithIdResult = immutableEntityHierarchyItem.withId(optional);

    // Assert
    assertSame(immutableEntityHierarchyItem, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return ancestorLevel is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityHierarchyItem#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return ancestorLevel is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityHierarchyItem ImmutableEntityHierarchyItem.withId(Optional)"})
  void testWithIdWithOptional_thenReturnAncestorLevelIsOne() {
    // Arrange
    ImmutableEntityHierarchyItem immutableEntityHierarchyItem =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(2L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableEntityHierarchyItem actualWithIdResult = immutableEntityHierarchyItem.withId(optional);

    // Assert
    assertEquals(1, actualWithIdResult.ancestorLevel());
    assertEquals(3, actualWithIdResult.descendantLevel());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableEntityHierarchyItem#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityHierarchyItem ImmutableEntityHierarchyItem.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableEntityHierarchyItem immutableEntityHierarchyItem =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build();

    // Act
    ImmutableEntityHierarchyItem actualWithIdResult = immutableEntityHierarchyItem.withId(1L);

    // Assert
    assertSame(immutableEntityHierarchyItem, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return ancestorLevel is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityHierarchyItem#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return ancestorLevel is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityHierarchyItem ImmutableEntityHierarchyItem.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnAncestorLevelIsOne() {
    // Arrange and Act
    ImmutableEntityHierarchyItem actualWithIdResult =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build()
            .withId(42L);

    // Assert
    assertEquals(1, actualWithIdResult.ancestorLevel());
    assertEquals(3, actualWithIdResult.descendantLevel());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableEntityHierarchyItem#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityHierarchyItem ImmutableEntityHierarchyItem.withKind(EntityKind)"
  })
  void testWithKind() {
    // Arrange
    ImmutableEntityHierarchyItem immutableEntityHierarchyItem =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build();

    // Act
    ImmutableEntityHierarchyItem actualWithKindResult =
        immutableEntityHierarchyItem.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableEntityHierarchyItem, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return ancestorLevel is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityHierarchyItem#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return ancestorLevel is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityHierarchyItem ImmutableEntityHierarchyItem.withKind(EntityKind)"
  })
  void testWithKind_thenReturnAncestorLevelIsOne() {
    // Arrange and Act
    ImmutableEntityHierarchyItem actualWithKindResult =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ACTOR)
            .parentId(1L)
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals(1, actualWithKindResult.ancestorLevel());
    assertEquals(3, actualWithKindResult.descendantLevel());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#withParentId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableEntityHierarchyItem#withParentId(Optional)}
   */
  @Test
  @DisplayName("Test withParentId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityHierarchyItem ImmutableEntityHierarchyItem.withParentId(Optional)"
  })
  void testWithParentIdWithOptional() {
    // Arrange
    ImmutableEntityHierarchyItem immutableEntityHierarchyItem =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableEntityHierarchyItem actualWithParentIdResult =
        immutableEntityHierarchyItem.withParentId(optional);

    // Assert
    assertSame(immutableEntityHierarchyItem, actualWithParentIdResult);
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#withParentId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return ancestorLevel is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityHierarchyItem#withParentId(Optional)}
   */
  @Test
  @DisplayName("Test withParentId(Optional) with 'optional'; then return ancestorLevel is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityHierarchyItem ImmutableEntityHierarchyItem.withParentId(Optional)"
  })
  void testWithParentIdWithOptional_thenReturnAncestorLevelIsOne() {
    // Arrange
    ImmutableEntityHierarchyItem immutableEntityHierarchyItem =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(2L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableEntityHierarchyItem actualWithParentIdResult =
        immutableEntityHierarchyItem.withParentId(optional);

    // Assert
    assertEquals(1, actualWithParentIdResult.ancestorLevel());
    assertEquals(3, actualWithParentIdResult.descendantLevel());
    assertEquals(EntityKind.ALL, actualWithParentIdResult.kind());
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#withParentId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableEntityHierarchyItem#withParentId(long)}
   */
  @Test
  @DisplayName("Test withParentId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityHierarchyItem ImmutableEntityHierarchyItem.withParentId(long)"
  })
  void testWithParentIdWithValue() {
    // Arrange
    ImmutableEntityHierarchyItem immutableEntityHierarchyItem =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build();

    // Act
    ImmutableEntityHierarchyItem actualWithParentIdResult =
        immutableEntityHierarchyItem.withParentId(1L);

    // Assert
    assertSame(immutableEntityHierarchyItem, actualWithParentIdResult);
  }

  /**
   * Test {@link ImmutableEntityHierarchyItem#withParentId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return ancestorLevel is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityHierarchyItem#withParentId(long)}
   */
  @Test
  @DisplayName(
      "Test withParentId(long) with 'value'; when forty-two; then return ancestorLevel is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityHierarchyItem ImmutableEntityHierarchyItem.withParentId(long)"
  })
  void testWithParentIdWithValue_whenFortyTwo_thenReturnAncestorLevelIsOne() {
    // Arrange and Act
    ImmutableEntityHierarchyItem actualWithParentIdResult =
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build()
            .withParentId(42L);

    // Assert
    assertEquals(1, actualWithParentIdResult.ancestorLevel());
    assertEquals(3, actualWithParentIdResult.descendantLevel());
    assertEquals(EntityKind.ALL, actualWithParentIdResult.kind());
  }
}
