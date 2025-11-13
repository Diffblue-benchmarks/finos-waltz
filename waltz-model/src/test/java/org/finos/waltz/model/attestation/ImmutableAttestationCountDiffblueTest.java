package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.attestation.ImmutableAttestationCount.Builder;
import org.finos.waltz.model.attestation.ImmutableAttestationCount.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttestationCountDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationCount Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAttestationCount actualImmutableAttestationCount =
        ImmutableAttestationCount.builder().count(3).key("Key").build();

    // Assert
    assertEquals("Key", actualImmutableAttestationCount.key());
    assertEquals(3, actualImmutableAttestationCount.count().intValue());
  }

  /**
   * Test Builder {@link Builder#count(Integer)}.
   *
   * <p>Method under test: {@link Builder#count(Integer)}
   */
  @Test
  @DisplayName("Test Builder count(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.count(Integer)"})
  void testBuilderCount() {
    // Arrange
    Builder builderResult = ImmutableAttestationCount.builder();

    // Act
    Builder actualCountResult = builderResult.count(3);

    // Assert
    assertSame(builderResult, actualCountResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationCount)}.
   *
   * <ul>
   *   <li>Then builder build is builder count three key {@code Key} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AttestationCount)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AttestationCount); then builder build is builder count three key 'Key' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AttestationCount)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderCountThreeKeyKeyBuild() {
    // Arrange
    Builder builderResult = ImmutableAttestationCount.builder();
    ImmutableAttestationCount instance =
        ImmutableAttestationCount.builder().count(3).key("Key").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAttestationCount actualImmutableAttestationCount = builderResult.build();
    assertEquals(instance, actualImmutableAttestationCount);
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
    Builder builderResult = ImmutableAttestationCount.builder();

    // Act
    Builder actualKeyResult = builderResult.key("Key");

    // Assert
    assertSame(builderResult, actualKeyResult);
  }

  /**
   * Test {@link ImmutableAttestationCount#copyOf(AttestationCount)}.
   *
   * <ul>
   *   <li>When builder count three key {@code Key} build.
   *   <li>Then return {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationCount#copyOf(AttestationCount)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AttestationCount); when builder count three key 'Key' build; then return 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationCount ImmutableAttestationCount.copyOf(AttestationCount)"
  })
  void testCopyOf_whenBuilderCountThreeKeyKeyBuild_thenReturnKey() {
    // Arrange
    ImmutableAttestationCount instance =
        ImmutableAttestationCount.builder().count(3).key("Key").build();

    // Act
    ImmutableAttestationCount actualCopyOfResult = ImmutableAttestationCount.copyOf(instance);

    // Assert
    assertEquals("Key", actualCopyOfResult.key());
    assertEquals(3, actualCopyOfResult.count().intValue());
  }

  /**
   * Test {@link ImmutableAttestationCount#equals(Object)}, and {@link
   * ImmutableAttestationCount#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationCount#equals(Object)}
   *   <li>{@link ImmutableAttestationCount#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationCount.equals(Object)",
    "int ImmutableAttestationCount.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAttestationCount immutableAttestationCount =
        ImmutableAttestationCount.builder().count(3).key("Key").build();
    ImmutableAttestationCount immutableAttestationCount2 =
        ImmutableAttestationCount.builder().count(3).key("Key").build();

    // Act and Assert
    assertEquals(immutableAttestationCount, immutableAttestationCount2);
    assertEquals(immutableAttestationCount.hashCode(), immutableAttestationCount2.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationCount#equals(Object)}, and {@link
   * ImmutableAttestationCount#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationCount#equals(Object)}
   *   <li>{@link ImmutableAttestationCount#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationCount.equals(Object)",
    "int ImmutableAttestationCount.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAttestationCount immutableAttestationCount =
        ImmutableAttestationCount.builder().count(3).key("Key").build();

    // Act and Assert
    assertEquals(immutableAttestationCount, immutableAttestationCount);
    int expectedHashCodeResult = immutableAttestationCount.hashCode();
    assertEquals(expectedHashCodeResult, immutableAttestationCount.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationCount#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationCount#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationCount.equals(Object)",
    "int ImmutableAttestationCount.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAttestationCount immutableAttestationCount =
        ImmutableAttestationCount.builder().count(1).key("Key").build();

    // Act and Assert
    assertNotEquals(
        immutableAttestationCount, ImmutableAttestationCount.builder().count(3).key("Key").build());
  }

  /**
   * Test {@link ImmutableAttestationCount#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationCount#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationCount.equals(Object)",
    "int ImmutableAttestationCount.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAttestationCount immutableAttestationCount =
        ImmutableAttestationCount.builder().count(3).key("count").build();

    // Act and Assert
    assertNotEquals(
        immutableAttestationCount, ImmutableAttestationCount.builder().count(3).key("Key").build());
  }

  /**
   * Test {@link ImmutableAttestationCount#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationCount#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationCount.equals(Object)",
    "int ImmutableAttestationCount.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableAttestationCount.builder().count(3).key("Key").build(), null);
  }

  /**
   * Test {@link ImmutableAttestationCount#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationCount#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationCount.equals(Object)",
    "int ImmutableAttestationCount.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAttestationCount.builder().count(3).key("Key").build(),
        "Different type to ImmutableAttestationCount");
  }

  /**
   * Test {@link ImmutableAttestationCount#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Key is {@code Json}.
   *   <li>Then return key is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationCount#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Key is 'Json'; then return key is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationCount ImmutableAttestationCount.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonKeyIsJson_thenReturnKeyIsJson() {
    // Arrange
    Json json = new Json();
    json.setKey("Json");
    json.setCount(1);

    // Act
    ImmutableAttestationCount actualFromJsonResult = ImmutableAttestationCount.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.key());
    assertEquals(1, actualFromJsonResult.count().intValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationCount#toString()}
   *   <li>{@link ImmutableAttestationCount#count()}
   *   <li>{@link ImmutableAttestationCount#key()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer ImmutableAttestationCount.count()",
    "String ImmutableAttestationCount.key()",
    "String ImmutableAttestationCount.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAttestationCount immutableAttestationCount =
        ImmutableAttestationCount.builder().count(3).key("Key").build();

    // Act
    String actualToStringResult = immutableAttestationCount.toString();
    Integer actualCountResult = immutableAttestationCount.count();

    // Assert
    assertEquals("AttestationCount{key=Key, count=3}", actualToStringResult);
    assertEquals("Key", immutableAttestationCount.key());
    assertEquals(3, actualCountResult.intValue());
  }

  /**
   * Test Json {@link Json#count()}.
   *
   * <p>Method under test: {@link Json#count()}
   */
  @Test
  @DisplayName("Test Json count()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer Json.count()"})
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().count());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCount(Integer)}
   *   <li>{@link Json#setKey(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setCount(Integer)",
    "void Json.setKey(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCount(3);
    actualJson.setKey("Key");

    // Assert
    assertEquals(3, actualJson.count.intValue());
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
   * Test {@link ImmutableAttestationCount#withCount(Integer)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationCount#withCount(Integer)}
   */
  @Test
  @DisplayName("Test withCount(Integer); when forty-two; then return 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationCount ImmutableAttestationCount.withCount(Integer)"})
  void testWithCount_whenFortyTwo_thenReturnKey() {
    // Arrange and Act
    ImmutableAttestationCount actualWithCountResult =
        ImmutableAttestationCount.builder().count(3).key("Key").build().withCount(42);

    // Assert
    assertEquals("Key", actualWithCountResult.key());
    assertEquals(42, actualWithCountResult.count().intValue());
  }

  /**
   * Test {@link ImmutableAttestationCount#withCount(Integer)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return builder count three key {@code Key} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationCount#withCount(Integer)}
   */
  @Test
  @DisplayName(
      "Test withCount(Integer); when three; then return builder count three key 'Key' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationCount ImmutableAttestationCount.withCount(Integer)"})
  void testWithCount_whenThree_thenReturnBuilderCountThreeKeyKeyBuild() {
    // Arrange
    ImmutableAttestationCount immutableAttestationCount =
        ImmutableAttestationCount.builder().count(3).key("Key").build();

    // Act
    ImmutableAttestationCount actualWithCountResult = immutableAttestationCount.withCount(3);

    // Assert
    assertSame(immutableAttestationCount, actualWithCountResult);
  }

  /**
   * Test {@link ImmutableAttestationCount#withKey(String)}.
   *
   * <ul>
   *   <li>Given builder count three key {@code Key} build.
   *   <li>Then return key is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationCount#withKey(String)}
   */
  @Test
  @DisplayName(
      "Test withKey(String); given builder count three key 'Key' build; then return key is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationCount ImmutableAttestationCount.withKey(String)"})
  void testWithKey_givenBuilderCountThreeKeyKeyBuild_thenReturnKeyIs42() {
    // Arrange and Act
    ImmutableAttestationCount actualWithKeyResult =
        ImmutableAttestationCount.builder().count(3).key("Key").build().withKey("42");

    // Assert
    assertEquals("42", actualWithKeyResult.key());
    assertEquals(3, actualWithKeyResult.count().intValue());
  }

  /**
   * Test {@link ImmutableAttestationCount#withKey(String)}.
   *
   * <ul>
   *   <li>Then return builder count three key {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationCount#withKey(String)}
   */
  @Test
  @DisplayName("Test withKey(String); then return builder count three key '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationCount ImmutableAttestationCount.withKey(String)"})
  void testWithKey_thenReturnBuilderCountThreeKey42Build() {
    // Arrange
    ImmutableAttestationCount immutableAttestationCount =
        ImmutableAttestationCount.builder().count(3).key("42").build();

    // Act
    ImmutableAttestationCount actualWithKeyResult = immutableAttestationCount.withKey("42");

    // Assert
    assertSame(immutableAttestationCount, actualWithKeyResult);
  }
}
