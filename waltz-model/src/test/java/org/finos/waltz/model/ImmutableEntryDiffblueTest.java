package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.ImmutableEntry.Builder;
import org.finos.waltz.model.ImmutableEntry.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntryDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntry Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder<Object, Object> actualBuilderResult = ImmutableEntry.builder();
    ImmutableEntry<Object, Object> actualImmutableEntry =
        actualBuilderResult.key("Key").value("Value").build();

    // Assert
    assertEquals("Key", actualImmutableEntry.key());
    assertEquals("Value", actualImmutableEntry.value());
  }

  /**
   * Test Builder {@link Builder#from(Entry)}.
   *
   * <ul>
   *   <li>Then builder build is builder key {@code Key} value {@code Value} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(Entry)}
   */
  @Test
  @DisplayName(
      "Test Builder from(Entry); then builder build is builder key 'Key' value 'Value' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Entry)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderKeyKeyValueValueBuild() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableEntry.builder();

    Builder<Object, Object> builderResult2 = ImmutableEntry.builder();
    ImmutableEntry<Object, Object> instance = builderResult2.key("Key").value("Value").build();

    // Act
    Builder<Object, Object> actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntry<Object, Object> actualImmutableEntry = builderResult.build();
    assertEquals(instance, actualImmutableEntry);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#key(Object)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#key(Object)}
   */
  @Test
  @DisplayName("Test Builder key(Object); when 'Key'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.key(Object)"})
  void testBuilderKey_whenKey_thenReturnBuilder() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableEntry.builder();

    // Act
    Builder<Object, Object> actualKeyResult = builderResult.key("Key");

    // Assert
    assertSame(builderResult, actualKeyResult);
  }

  /**
   * Test Builder {@link Builder#value(Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#value(Object)}
   */
  @Test
  @DisplayName("Test Builder value(Object); when 'Value'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.value(Object)"})
  void testBuilderValue_whenValue_thenReturnBuilder() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableEntry.builder();

    // Act
    Builder<Object, Object> actualValueResult = builderResult.value("Value");

    // Assert
    assertSame(builderResult, actualValueResult);
  }

  /**
   * Test {@link ImmutableEntry#copyOf(Entry)}.
   *
   * <ul>
   *   <li>When builder key {@code Key} value {@code Value} build.
   *   <li>Then return {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntry#copyOf(Entry)}
   */
  @Test
  @DisplayName("Test copyOf(Entry); when builder key 'Key' value 'Value' build; then return 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntry ImmutableEntry.copyOf(Entry)"})
  void testCopyOf_whenBuilderKeyKeyValueValueBuild_thenReturnKey() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableEntry.builder();
    ImmutableEntry<Object, Object> instance = builderResult.key("Key").value("Value").build();

    // Act
    ImmutableEntry<Object, Object> actualCopyOfResult = ImmutableEntry.copyOf(instance);

    // Assert
    assertEquals("Key", actualCopyOfResult.key());
    assertEquals("Value", actualCopyOfResult.value());
  }

  /**
   * Test {@link ImmutableEntry#equals(Object)}, and {@link ImmutableEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntry#equals(Object)}
   *   <li>{@link ImmutableEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableEntry.equals(Object)", "int ImmutableEntry.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableEntry.builder();
    ImmutableEntry<Object, Object> immutableEntry = builderResult.key("Key").value("Value").build();

    Builder<Object, Object> builderResult2 = ImmutableEntry.builder();
    ImmutableEntry<Object, Object> immutableEntry2 =
        builderResult2.key("Key").value("Value").build();

    // Act and Assert
    assertEquals(immutableEntry, immutableEntry2);
    assertEquals(immutableEntry.hashCode(), immutableEntry2.hashCode());
  }

  /**
   * Test {@link ImmutableEntry#equals(Object)}, and {@link ImmutableEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntry#equals(Object)}
   *   <li>{@link ImmutableEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableEntry.equals(Object)", "int ImmutableEntry.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableEntry.builder();
    ImmutableEntry<Object, Object> immutableEntry = builderResult.key("Key").value("Value").build();

    // Act and Assert
    assertEquals(immutableEntry, immutableEntry);
    int expectedHashCodeResult = immutableEntry.hashCode();
    assertEquals(expectedHashCodeResult, immutableEntry.hashCode());
  }

  /**
   * Test {@link ImmutableEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableEntry.equals(Object)", "int ImmutableEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableEntry.builder();
    ImmutableEntry<Object, Object> immutableEntry = builderResult.key(1).value("Value").build();

    Builder<Object, Object> builderResult2 = ImmutableEntry.builder();

    // Act and Assert
    assertNotEquals(immutableEntry, builderResult2.key("Key").value("Value").build());
  }

  /**
   * Test {@link ImmutableEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableEntry.equals(Object)", "int ImmutableEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableEntry.builder();

    Builder<Object, Object> builderResult2 = ImmutableEntry.builder();
    ImmutableEntry<Object, Object> immutableEntry =
        builderResult.key(builderResult2.key("Key").value("Value").build()).value("Value").build();

    Builder<Object, Object> builderResult3 = ImmutableEntry.builder();

    // Act and Assert
    assertNotEquals(immutableEntry, builderResult3.key("Key").value("Value").build());
  }

  /**
   * Test {@link ImmutableEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableEntry.equals(Object)", "int ImmutableEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableEntry.builder();
    ImmutableEntry<Object, Object> immutableEntry = builderResult.key("Key").value(42).build();

    Builder<Object, Object> builderResult2 = ImmutableEntry.builder();

    // Act and Assert
    assertNotEquals(immutableEntry, builderResult2.key("Key").value("Value").build());
  }

  /**
   * Test {@link ImmutableEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableEntry.equals(Object)", "int ImmutableEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableEntry.builder();

    Builder<Object, Object> keyResult = builderResult.key("Key");

    Builder<Object, Object> builderResult2 = ImmutableEntry.builder();
    ImmutableEntry<Object, Object> immutableEntry =
        keyResult.value(builderResult2.key("Key").value("Value").build()).build();

    Builder<Object, Object> builderResult3 = ImmutableEntry.builder();

    // Act and Assert
    assertNotEquals(immutableEntry, builderResult3.key("Key").value("Value").build());
  }

  /**
   * Test {@link ImmutableEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableEntry.equals(Object)", "int ImmutableEntry.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableEntry.builder();

    // Act and Assert
    assertNotEquals(builderResult.key("Key").value("Value").build(), null);
  }

  /**
   * Test {@link ImmutableEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableEntry.equals(Object)", "int ImmutableEntry.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableEntry.builder();

    // Act and Assert
    assertNotEquals(
        builderResult.key("Key").value("Value").build(), "Different type to ImmutableEntry");
  }

  /**
   * Test {@link ImmutableEntry#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Key is {@code Json}.
   *   <li>Then return key is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntry#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Key is 'Json'; then return key is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntry ImmutableEntry.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonKeyIsJson_thenReturnKeyIsJson() {
    // Arrange
    Json<Object, Object> json = new Json<>();
    json.setKey("Json");
    json.setValue("Json");

    // Act
    ImmutableEntry<Object, Object> actualFromJsonResult = ImmutableEntry.fromJson(json);

    // Assert
    Object keyResult = actualFromJsonResult.key();
    assertEquals("Json", keyResult);
    Object object = json.value;
    assertSame(object, keyResult);
    assertSame(object, actualFromJsonResult.value());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntry#toString()}
   *   <li>{@link ImmutableEntry#key()}
   *   <li>{@link ImmutableEntry#value()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ImmutableEntry.key()",
    "String ImmutableEntry.toString()",
    "Object ImmutableEntry.value()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableEntry.builder();
    ImmutableEntry<Object, Object> immutableEntry = builderResult.key("Key").value("Value").build();

    // Act
    String actualToStringResult = immutableEntry.toString();
    Object actualKeyResult = immutableEntry.key();

    // Assert
    assertEquals("Entry{key=Key, value=Value}", actualToStringResult);
    assertEquals("Key", actualKeyResult);
    assertEquals("Value", immutableEntry.value());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setKey(Object)}
   *   <li>{@link Json#setValue(Object)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setKey(Object)",
    "void Json.setValue(Object)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json<Object, Object> actualJson = new Json<>();
    actualJson.setKey("Key");
    actualJson.setValue("Value");

    // Assert
    assertEquals("Key", actualJson.key);
    assertEquals("Value", actualJson.value);
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
  @MethodsUnderTest({"Object Json.key()"})
  void testJsonKey() {
    // Arrange
    Json<Object, Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.key());
  }

  /**
   * Test Json {@link Json#value()}.
   *
   * <p>Method under test: {@link Json#value()}
   */
  @Test
  @DisplayName("Test Json value()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Json.value()"})
  void testJsonValue() {
    // Arrange
    Json<Object, Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.value());
  }

  /**
   * Test {@link ImmutableEntry#withKey(Object)}.
   *
   * <ul>
   *   <li>Given builder key {@code Key} value {@code Value} build.
   *   <li>When {@code Value}.
   *   <li>Then return key is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntry#withKey(Object)}
   */
  @Test
  @DisplayName(
      "Test withKey(Object); given builder key 'Key' value 'Value' build; when 'Value'; then return key is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntry ImmutableEntry.withKey(Object)"})
  void testWithKey_givenBuilderKeyKeyValueValueBuild_whenValue_thenReturnKeyIsValue() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableEntry.builder();

    // Act
    ImmutableEntry<Object, Object> actualWithKeyResult =
        builderResult.key("Key").value("Value").build().withKey("Value");

    // Assert
    assertEquals("Value", actualWithKeyResult.key());
    assertEquals("Value", actualWithKeyResult.value());
  }

  /**
   * Test {@link ImmutableEntry#withKey(Object)}.
   *
   * <ul>
   *   <li>Then return builder key {@code key} value {@code Value} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntry#withKey(Object)}
   */
  @Test
  @DisplayName("Test withKey(Object); then return builder key 'key' value 'Value' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntry ImmutableEntry.withKey(Object)"})
  void testWithKey_thenReturnBuilderKeyKeyValueValueBuild() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableEntry.builder();
    ImmutableEntry<Object, Object> immutableEntry = builderResult.key("key").value("Value").build();

    // Act
    ImmutableEntry<Object, Object> actualWithKeyResult = immutableEntry.withKey("key");

    // Assert
    assertSame(immutableEntry, actualWithKeyResult);
  }

  /**
   * Test {@link ImmutableEntry#withValue(Object)}.
   *
   * <ul>
   *   <li>Given builder key {@code Key} value forty-two build.
   *   <li>Then return {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntry#withValue(Object)}
   */
  @Test
  @DisplayName(
      "Test withValue(Object); given builder key 'Key' value forty-two build; then return 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntry ImmutableEntry.withValue(Object)"})
  void testWithValue_givenBuilderKeyKeyValueFortyTwoBuild_thenReturnKey() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableEntry.builder();

    // Act
    ImmutableEntry<Object, Object> actualWithValueResult =
        builderResult.key("Key").value(42).build().withValue("Value");

    // Assert
    assertEquals("Key", actualWithValueResult.key());
    assertEquals("Value", actualWithValueResult.value());
  }

  /**
   * Test {@link ImmutableEntry#withValue(Object)}.
   *
   * <ul>
   *   <li>Then return builder key {@code Key} value {@code Value} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntry#withValue(Object)}
   */
  @Test
  @DisplayName("Test withValue(Object); then return builder key 'Key' value 'Value' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntry ImmutableEntry.withValue(Object)"})
  void testWithValue_thenReturnBuilderKeyKeyValueValueBuild() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableEntry.builder();
    ImmutableEntry<Object, Object> immutableEntry = builderResult.key("Key").value("Value").build();

    // Act
    ImmutableEntry<Object, Object> actualWithValueResult = immutableEntry.withValue("Value");

    // Assert
    assertSame(immutableEntry, actualWithValueResult);
  }
}
