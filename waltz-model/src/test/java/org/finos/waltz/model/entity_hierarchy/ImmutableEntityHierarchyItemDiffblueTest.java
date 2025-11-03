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
   * <p>
   * Method under test: {@link Builder#ancestorLevel(int)}
   */
  @Test
  @DisplayName("Test Builder ancestorLevel(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ancestorLevel(int)"})
  void testBuilderAncestorLevel() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ancestorLevel(1));
  }

  /**
   * Test Builder {@link Builder#descendantLevel(int)}.
   * <p>
   * Method under test: {@link Builder#descendantLevel(int)}
   */
  @Test
  @DisplayName("Test Builder descendantLevel(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.descendantLevel(int)"})
  void testBuilderDescendantLevel() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.descendantLevel(3));
  }

  /**
   * Test Builder {@link Builder#from(EntityHierarchyItem)} with {@code EntityHierarchyItem}.
   * <p>
   * Method under test: {@link Builder#from(EntityHierarchyItem)}
   */
  @Test
  @DisplayName("Test Builder from(EntityHierarchyItem) with 'EntityHierarchyItem'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityHierarchyItem)"})
  void testBuilderFromWithEntityHierarchyItem() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();
    EntityHierarchyItem instance = mock(EntityHierarchyItem.class);
    when(instance.ancestorLevel()).thenReturn(1);
    when(instance.descendantLevel()).thenReturn(3);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(EntityHierarchyItem)} with {@code EntityHierarchyItem}.
   * <p>
   * Method under test: {@link Builder#from(EntityHierarchyItem)}
   */
  @Test
  @DisplayName("Test Builder from(EntityHierarchyItem) with 'EntityHierarchyItem'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityHierarchyItem)"})
  void testBuilderFromWithEntityHierarchyItem2() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();
    EntityHierarchyItem instance = mock(EntityHierarchyItem.class);
    when(instance.ancestorLevel()).thenReturn(1);
    when(instance.descendantLevel()).thenReturn(3);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(EntityHierarchyItem)} with {@code EntityHierarchyItem}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityHierarchyItem)}
   */
  @Test
  @DisplayName("Test Builder from(EntityHierarchyItem) with 'EntityHierarchyItem'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityHierarchyItem)"})
  void testBuilderFromWithEntityHierarchyItem_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();
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
   * Test Builder {@link Builder#from(EntityHierarchyItem)} with {@code EntityHierarchyItem}.
   * <ul>
   *   <li>When {@link EntityHierarchyItem} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityHierarchyItem)}
   */
  @Test
  @DisplayName("Test Builder from(EntityHierarchyItem) with 'EntityHierarchyItem'; when EntityHierarchyItem id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityHierarchyItem)"})
  void testBuilderFromWithEntityHierarchyItem_whenEntityHierarchyItemIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();
    EntityHierarchyItem instance = mock(EntityHierarchyItem.class);
    when(instance.ancestorLevel()).thenReturn(1);
    when(instance.descendantLevel()).thenReturn(3);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'; given empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    when(instance.parentId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).parentId();
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#kind(EntityKind)}.
   * <p>
   * Method under test: {@link Builder#kind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder kind(EntityKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.kind(EntityKind)"})
  void testBuilderKind() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kind(EntityKind.ALL));
  }

  /**
   * Test Builder {@link Builder#parentId(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#parentId(long)}
   */
  @Test
  @DisplayName("Test Builder parentId(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentId(long)"})
  void testBuilderParentIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentId(1L));
  }

  /**
   * Test Builder {@link Builder#parentId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#parentId(Optional)}
   */
  @Test
  @DisplayName("Test Builder parentId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentId(Optional)"})
  void testBuilderParentIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchyItem.builder();
    Optional<Long> parentId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.parentId(parentId));
  }

  /**
   * Test Json {@link Json#ancestorLevel()}.
   * <p>
   * Method under test: {@link Json#ancestorLevel()}
   */
  @Test
  @DisplayName("Test Json ancestorLevel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.ancestorLevel()"})
  void testJsonAncestorLevel() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ancestorLevel());
  }

  /**
   * Test Json {@link Json#descendantLevel()}.
   * <p>
   * Method under test: {@link Json#descendantLevel()}
   */
  @Test
  @DisplayName("Test Json descendantLevel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.descendantLevel()"})
  void testJsonDescendantLevel() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).descendantLevel());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json {@link Json#kind()}.
   * <p>
   * Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).kind());
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
   * <p>
   * Method under test: {@link Json#parentId()}
   */
  @Test
  @DisplayName("Test Json parentId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.parentId()"})
  void testJsonParentId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).parentId());
  }

  /**
   * Test Json {@link Json#setAncestorLevel(int)}.
   * <p>
   * Method under test: {@link Json#setAncestorLevel(int)}
   */
  @Test
  @DisplayName("Test Json setAncestorLevel(int)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#setDescendantLevel(int)}
   */
  @Test
  @DisplayName("Test Json setDescendantLevel(int)")
  @Tag("MaintainedByDiffblue")
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
}
