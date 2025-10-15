package org.finos.waltz.web.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.web.action.ImmutableFieldChange.Builder;
import org.finos.waltz.web.action.ImmutableFieldChange.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFieldChangeDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#current(String)}
   *   <li>{@link Builder#original(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFieldChange Builder.build()",
    "Builder Builder.current(String)",
    "Builder Builder.original(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualCurrentResult = ImmutableFieldChange.builder().current("Current");
    Optional<String> current = Optional.of("foo");
    Builder actualOriginalResult =
        actualCurrentResult
            .current(current)
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original");
    Optional<String> original = Optional.of("foo");
    ImmutableFieldChange actualImmutableFieldChange =
        actualOriginalResult.original(original).build();

    // Assert
    assertEquals("Key", actualImmutableFieldChange.key());
    assertEquals("Name", actualImmutableFieldChange.name());
    assertTrue(actualImmutableFieldChange.dirty());
  }

  /**
   * Test Builder {@link Builder#current(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#current(Optional)}
   */
  @Test
  @DisplayName("Test Builder current(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.current(Optional)"})
  void testBuilderCurrentWithOptional() {
    // Arrange
    Builder builderResult = ImmutableFieldChange.builder();
    Optional<String> current = Optional.of("foo");

    // Act
    Builder actualCurrentResult = builderResult.current(current);

    // Assert
    assertSame(builderResult, actualCurrentResult);
  }

  /**
   * Test Builder {@link Builder#dirty(boolean)}.
   *
   * <p>Method under test: {@link Builder#dirty(boolean)}
   */
  @Test
  @DisplayName("Test Builder dirty(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dirty(boolean)"})
  void testBuilderDirty() {
    // Arrange
    Builder builderResult = ImmutableFieldChange.builder();

    // Act
    Builder actualDirtyResult = builderResult.dirty(true);

    // Assert
    assertSame(builderResult, actualDirtyResult);
  }

  /**
   * Test Builder {@link Builder#from(FieldChange)}.
   *
   * <p>Method under test: {@link Builder#from(FieldChange)}
   */
  @Test
  @DisplayName("Test Builder from(FieldChange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FieldChange)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableFieldChange.builder();
    ImmutableFieldChange instance =
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableFieldChange actualImmutableFieldChange = builderResult.build();
    assertEquals(instance, actualImmutableFieldChange);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#key(String)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#key(String)}
   */
  @Test
  @DisplayName("Test Builder key(String); when 'Key'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.key(String)"})
  void testBuilderKey_whenKey_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFieldChange.builder();

    // Act
    Builder actualKeyResult = builderResult.key("Key");

    // Assert
    assertSame(builderResult, actualKeyResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFieldChange.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#original(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#original(Optional)}
   */
  @Test
  @DisplayName("Test Builder original(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.original(Optional)"})
  void testBuilderOriginalWithOptional() {
    // Arrange
    Builder builderResult = ImmutableFieldChange.builder();
    Optional<String> original = Optional.of("foo");

    // Act
    Builder actualOriginalResult = builderResult.original(original);

    // Assert
    assertSame(builderResult, actualOriginalResult);
  }

  /**
   * Test {@link ImmutableFieldChange#copyOf(FieldChange)}.
   *
   * <ul>
   *   <li>Then return {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#copyOf(FieldChange)}
   */
  @Test
  @DisplayName("Test copyOf(FieldChange); then return 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.copyOf(FieldChange)"})
  void testCopyOf_thenReturnKey() {
    // Arrange
    ImmutableFieldChange instance =
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build();

    // Act
    ImmutableFieldChange actualCopyOfResult = ImmutableFieldChange.copyOf(instance);

    // Assert
    assertEquals("Key", actualCopyOfResult.key());
    assertEquals("Name", actualCopyOfResult.name());
    assertTrue(actualCopyOfResult.dirty());
  }

  /**
   * Test {@link ImmutableFieldChange#current()}.
   *
   * <p>Method under test: {@link ImmutableFieldChange#current()}
   */
  @Test
  @DisplayName("Test current()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableFieldChange.current()"})
  void testCurrent() {
    // Arrange and Act
    Optional<String> actualCurrentResult =
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build()
            .current();

    // Assert
    assertEquals("Current", actualCurrentResult.get());
    assertTrue(actualCurrentResult.isPresent());
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}, and {@link ImmutableFieldChange#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFieldChange#equals(Object)}
   *   <li>{@link ImmutableFieldChange#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFieldChange.equals(Object)",
    "int ImmutableFieldChange.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableFieldChange immutableFieldChange =
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build();
    ImmutableFieldChange immutableFieldChange2 =
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build();

    // Act and Assert
    assertEquals(immutableFieldChange, immutableFieldChange2);
    assertEquals(immutableFieldChange.hashCode(), immutableFieldChange2.hashCode());
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}, and {@link ImmutableFieldChange#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFieldChange#equals(Object)}
   *   <li>{@link ImmutableFieldChange#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFieldChange.equals(Object)",
    "int ImmutableFieldChange.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableFieldChange immutableFieldChange =
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build();

    // Act and Assert
    assertEquals(immutableFieldChange, immutableFieldChange);
    int expectedHashCodeResult = immutableFieldChange.hashCode();
    assertEquals(expectedHashCodeResult, immutableFieldChange.hashCode());
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFieldChange.equals(Object)",
    "int ImmutableFieldChange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableFieldChange immutableFieldChange =
        ImmutableFieldChange.builder()
            .current("Name")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFieldChange,
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build());
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFieldChange.equals(Object)",
    "int ImmutableFieldChange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableFieldChange immutableFieldChange =
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(false)
            .key("Key")
            .name("Name")
            .original("Original")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFieldChange,
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build());
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFieldChange.equals(Object)",
    "int ImmutableFieldChange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableFieldChange immutableFieldChange =
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Name")
            .name("Name")
            .original("Original")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFieldChange,
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build());
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFieldChange.equals(Object)",
    "int ImmutableFieldChange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableFieldChange immutableFieldChange =
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Key")
            .original("Original")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFieldChange,
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build());
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFieldChange.equals(Object)",
    "int ImmutableFieldChange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableFieldChange immutableFieldChange =
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFieldChange,
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build());
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFieldChange.equals(Object)",
    "int ImmutableFieldChange.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableFieldChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFieldChange.equals(Object)",
    "int ImmutableFieldChange.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build(),
        "Different type to ImmutableFieldChange");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFieldChange#dirty()}
   *   <li>{@link ImmutableFieldChange#key()}
   *   <li>{@link ImmutableFieldChange#name()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFieldChange.dirty()",
    "String ImmutableFieldChange.key()",
    "String ImmutableFieldChange.name()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableFieldChange immutableFieldChange =
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build();

    // Act
    boolean actualDirtyResult = immutableFieldChange.dirty();
    String actualKeyResult = immutableFieldChange.key();

    // Assert
    assertEquals("Key", actualKeyResult);
    assertEquals("Name", immutableFieldChange.name());
    assertTrue(actualDirtyResult);
  }

  /**
   * Test Json {@link Json#current()}.
   *
   * <p>Method under test: {@link Json#current()}
   */
  @Test
  @DisplayName("Test Json current()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.current()"})
  void testJsonCurrent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().current());
  }

  /**
   * Test Json {@link Json#dirty()}.
   *
   * <p>Method under test: {@link Json#dirty()}
   */
  @Test
  @DisplayName("Test Json dirty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.dirty()"})
  void testJsonDirty() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dirty());
  }

  /**
   * Test Json {@link Json#key()}.
   *
   * <p>Method under test: {@link Json#key()}
   */
  @Test
  @DisplayName("Test Json key()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.key()"})
  void testJsonKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().key());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
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
    assertNull(actualJson.key);
    assertNull(actualJson.name);
    assertFalse(actualJson.current.isPresent());
    assertFalse(actualJson.original.isPresent());
    assertFalse(actualJson.dirty);
    assertFalse(actualJson.dirtyIsSet);
  }

  /**
   * Test Json {@link Json#original()}.
   *
   * <p>Method under test: {@link Json#original()}
   */
  @Test
  @DisplayName("Test Json original()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.original()"})
  void testJsonOriginal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().original());
  }

  /**
   * Test Json {@link Json#setDirty(boolean)}.
   *
   * <p>Method under test: {@link Json#setDirty(boolean)}
   */
  @Test
  @DisplayName("Test Json setDirty(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setDirty(boolean)"})
  void testJsonSetDirty() {
    // Arrange
    Json json = new Json();

    // Act
    json.setDirty(true);

    // Assert
    assertTrue(json.dirty);
    assertTrue(json.dirtyIsSet);
  }

  /**
   * Test {@link ImmutableFieldChange#original()}.
   *
   * <p>Method under test: {@link ImmutableFieldChange#original()}
   */
  @Test
  @DisplayName("Test original()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableFieldChange.original()"})
  void testOriginal() {
    // Arrange and Act
    Optional<String> actualOriginalResult =
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build()
            .original();

    // Assert
    assertEquals("Original", actualOriginalResult.get());
    assertTrue(actualOriginalResult.isPresent());
  }

  /**
   * Test {@link ImmutableFieldChange#toString()}.
   *
   * <p>Method under test: {@link ImmutableFieldChange#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableFieldChange.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "FieldChange{name=Name, key=Key, dirty=true, original=Original, current=Current}",
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableFieldChange#withCurrent(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableFieldChange#withCurrent(Optional)}
   */
  @Test
  @DisplayName("Test withCurrent(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withCurrent(Optional)"})
  void testWithCurrentWithOptional() {
    // Arrange
    ImmutableFieldChange immutableFieldChange =
        ImmutableFieldChange.builder()
            .current("42")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableFieldChange actualWithCurrentResult = immutableFieldChange.withCurrent(optional);

    // Assert
    assertSame(immutableFieldChange, actualWithCurrentResult);
  }

  /**
   * Test {@link ImmutableFieldChange#withCurrent(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#withCurrent(Optional)}
   */
  @Test
  @DisplayName("Test withCurrent(Optional) with 'optional'; then return 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withCurrent(Optional)"})
  void testWithCurrentWithOptional_thenReturnKey() {
    // Arrange
    ImmutableFieldChange immutableFieldChange =
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableFieldChange actualWithCurrentResult = immutableFieldChange.withCurrent(optional);

    // Assert
    assertEquals("Key", actualWithCurrentResult.key());
    assertEquals("Name", actualWithCurrentResult.name());
    assertTrue(actualWithCurrentResult.dirty());
  }

  /**
   * Test {@link ImmutableFieldChange#withCurrent(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableFieldChange#withCurrent(String)}
   */
  @Test
  @DisplayName("Test withCurrent(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withCurrent(String)"})
  void testWithCurrentWithValue() {
    // Arrange
    ImmutableFieldChange immutableFieldChange =
        ImmutableFieldChange.builder()
            .current("42")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build();

    // Act
    ImmutableFieldChange actualWithCurrentResult = immutableFieldChange.withCurrent("42");

    // Assert
    assertSame(immutableFieldChange, actualWithCurrentResult);
  }

  /**
   * Test {@link ImmutableFieldChange#withCurrent(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#withCurrent(String)}
   */
  @Test
  @DisplayName("Test withCurrent(String) with 'value'; then return 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withCurrent(String)"})
  void testWithCurrentWithValue_thenReturnKey() {
    // Arrange and Act
    ImmutableFieldChange actualWithCurrentResult =
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build()
            .withCurrent("42");

    // Assert
    assertEquals("Key", actualWithCurrentResult.key());
    assertEquals("Name", actualWithCurrentResult.name());
    assertTrue(actualWithCurrentResult.dirty());
  }

  /**
   * Test {@link ImmutableFieldChange#withDirty(boolean)}.
   *
   * <p>Method under test: {@link ImmutableFieldChange#withDirty(boolean)}
   */
  @Test
  @DisplayName("Test withDirty(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withDirty(boolean)"})
  void testWithDirty() {
    // Arrange
    ImmutableFieldChange immutableFieldChange =
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build();

    // Act
    ImmutableFieldChange actualWithDirtyResult = immutableFieldChange.withDirty(true);

    // Assert
    assertSame(immutableFieldChange, actualWithDirtyResult);
  }

  /**
   * Test {@link ImmutableFieldChange#withDirty(boolean)}.
   *
   * <ul>
   *   <li>Then return {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#withDirty(boolean)}
   */
  @Test
  @DisplayName("Test withDirty(boolean); then return 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withDirty(boolean)"})
  void testWithDirty_thenReturnKey() {
    // Arrange and Act
    ImmutableFieldChange actualWithDirtyResult =
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(false)
            .key("Key")
            .name("Name")
            .original("Original")
            .build()
            .withDirty(true);

    // Assert
    assertEquals("Key", actualWithDirtyResult.key());
    assertEquals("Name", actualWithDirtyResult.name());
    assertTrue(actualWithDirtyResult.dirty());
  }

  /**
   * Test {@link ImmutableFieldChange#withKey(String)}.
   *
   * <p>Method under test: {@link ImmutableFieldChange#withKey(String)}
   */
  @Test
  @DisplayName("Test withKey(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withKey(String)"})
  void testWithKey() {
    // Arrange
    ImmutableFieldChange immutableFieldChange =
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("42")
            .name("Name")
            .original("Original")
            .build();

    // Act
    ImmutableFieldChange actualWithKeyResult = immutableFieldChange.withKey("42");

    // Assert
    assertSame(immutableFieldChange, actualWithKeyResult);
  }

  /**
   * Test {@link ImmutableFieldChange#withKey(String)}.
   *
   * <ul>
   *   <li>Then return key is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#withKey(String)}
   */
  @Test
  @DisplayName("Test withKey(String); then return key is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withKey(String)"})
  void testWithKey_thenReturnKeyIs42() {
    // Arrange and Act
    ImmutableFieldChange actualWithKeyResult =
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build()
            .withKey("42");

    // Assert
    assertEquals("42", actualWithKeyResult.key());
    assertEquals("Name", actualWithKeyResult.name());
    assertTrue(actualWithKeyResult.dirty());
  }

  /**
   * Test {@link ImmutableFieldChange#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableFieldChange#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableFieldChange immutableFieldChange =
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("42")
            .original("Original")
            .build();

    // Act
    ImmutableFieldChange actualWithNameResult = immutableFieldChange.withName("42");

    // Assert
    assertSame(immutableFieldChange, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableFieldChange#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableFieldChange actualWithNameResult =
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Key", actualWithNameResult.key());
    assertTrue(actualWithNameResult.dirty());
  }

  /**
   * Test {@link ImmutableFieldChange#withOriginal(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableFieldChange#withOriginal(Optional)}
   */
  @Test
  @DisplayName("Test withOriginal(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withOriginal(Optional)"})
  void testWithOriginalWithOptional() {
    // Arrange
    ImmutableFieldChange immutableFieldChange =
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("42")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableFieldChange actualWithOriginalResult = immutableFieldChange.withOriginal(optional);

    // Assert
    assertSame(immutableFieldChange, actualWithOriginalResult);
  }

  /**
   * Test {@link ImmutableFieldChange#withOriginal(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#withOriginal(Optional)}
   */
  @Test
  @DisplayName("Test withOriginal(Optional) with 'optional'; then return 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withOriginal(Optional)"})
  void testWithOriginalWithOptional_thenReturnKey() {
    // Arrange
    ImmutableFieldChange immutableFieldChange =
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableFieldChange actualWithOriginalResult = immutableFieldChange.withOriginal(optional);

    // Assert
    assertEquals("Key", actualWithOriginalResult.key());
    assertEquals("Name", actualWithOriginalResult.name());
    assertTrue(actualWithOriginalResult.dirty());
  }

  /**
   * Test {@link ImmutableFieldChange#withOriginal(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableFieldChange#withOriginal(String)}
   */
  @Test
  @DisplayName("Test withOriginal(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withOriginal(String)"})
  void testWithOriginalWithValue() {
    // Arrange
    ImmutableFieldChange immutableFieldChange =
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("42")
            .build();

    // Act
    ImmutableFieldChange actualWithOriginalResult = immutableFieldChange.withOriginal("42");

    // Assert
    assertSame(immutableFieldChange, actualWithOriginalResult);
  }

  /**
   * Test {@link ImmutableFieldChange#withOriginal(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFieldChange#withOriginal(String)}
   */
  @Test
  @DisplayName("Test withOriginal(String) with 'value'; then return 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFieldChange ImmutableFieldChange.withOriginal(String)"})
  void testWithOriginalWithValue_thenReturnKey() {
    // Arrange and Act
    ImmutableFieldChange actualWithOriginalResult =
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build()
            .withOriginal("42");

    // Assert
    assertEquals("Key", actualWithOriginalResult.key());
    assertEquals("Name", actualWithOriginalResult.name());
    assertTrue(actualWithOriginalResult.dirty());
  }
}
