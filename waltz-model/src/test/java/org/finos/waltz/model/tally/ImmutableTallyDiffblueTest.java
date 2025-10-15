package org.finos.waltz.model.tally;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.tally.ImmutableTally.Builder;
import org.finos.waltz.model.tally.ImmutableTally.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableTallyDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTally Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder<Object> actualBuilderResult = ImmutableTally.builder();
    ImmutableTally<Object> actualImmutableTally = actualBuilderResult.count(10.0d).id("Id").build();

    // Assert
    assertEquals("Id", actualImmutableTally.id());
    assertEquals(10.0d, actualImmutableTally.count());
  }

  /**
   * Test Builder {@link Builder#count(double)}.
   *
   * <p>Method under test: {@link Builder#count(double)}
   */
  @Test
  @DisplayName("Test Builder count(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.count(double)"})
  void testBuilderCount() {
    // Arrange
    Builder<Object> builderResult = ImmutableTally.builder();

    // Act
    Builder<Object> actualCountResult = builderResult.count(10.0d);

    // Assert
    assertSame(builderResult, actualCountResult);
  }

  /**
   * Test Builder {@link Builder#from(Tally)}.
   *
   * <ul>
   *   <li>When builder count ten id {@code Id} index one build.
   *   <li>Then builder build id is {@code Id}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(Tally)}
   */
  @Test
  @DisplayName(
      "Test Builder from(Tally); when builder count ten id 'Id' index one build; then builder build id is 'Id'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Tally)"})
  void testBuilderFrom_whenBuilderCountTenIdIdIndexOneBuild_thenBuilderBuildIdIsId() {
    // Arrange
    Builder<Object> builderResult = ImmutableTally.builder();

    ImmutableOrderedTally.Builder<Object> builderResult2 = ImmutableOrderedTally.builder();

    // Act
    Builder<Object> actualFromResult =
        builderResult.from(builderResult2.count(10.0d).id("Id").index(1).build());

    // Assert
    ImmutableTally<Object> immutableTally = builderResult.build();
    assertEquals("Id", immutableTally.id());
    assertEquals(10.0d, immutableTally.count());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(Object)}.
   *
   * <ul>
   *   <li>When {@code Id}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#id(Object)}
   */
  @Test
  @DisplayName("Test Builder id(Object); when 'Id'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Object)"})
  void testBuilderId_whenId_thenReturnBuilder() {
    // Arrange
    Builder<Object> builderResult = ImmutableTally.builder();

    // Act
    Builder<Object> actualIdResult = builderResult.id("Id");

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test {@link ImmutableTally#copyOf(Tally)}.
   *
   * <ul>
   *   <li>When builder count ten id {@code Id} build.
   *   <li>Then return {@code Id}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTally#copyOf(Tally)}
   */
  @Test
  @DisplayName("Test copyOf(Tally); when builder count ten id 'Id' build; then return 'Id'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTally ImmutableTally.copyOf(Tally)"})
  void testCopyOf_whenBuilderCountTenIdIdBuild_thenReturnId() {
    // Arrange
    Builder<Object> builderResult = ImmutableTally.builder();
    ImmutableTally<Object> instance = builderResult.count(10.0d).id("Id").build();

    // Act
    ImmutableTally<Object> actualCopyOfResult = ImmutableTally.copyOf(instance);

    // Assert
    assertEquals("Id", actualCopyOfResult.id());
    assertEquals(10.0d, actualCopyOfResult.count());
  }

  /**
   * Test {@link ImmutableTally#copyOf(Tally)}.
   *
   * <ul>
   *   <li>When builder count ten id {@code Id} index one build.
   *   <li>Then return {@code Id}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTally#copyOf(Tally)}
   */
  @Test
  @DisplayName(
      "Test copyOf(Tally); when builder count ten id 'Id' index one build; then return 'Id'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTally ImmutableTally.copyOf(Tally)"})
  void testCopyOf_whenBuilderCountTenIdIdIndexOneBuild_thenReturnId() {
    // Arrange
    ImmutableOrderedTally.Builder<Object> builderResult = ImmutableOrderedTally.builder();
    ImmutableOrderedTally<Object> instance = builderResult.count(10.0d).id("Id").index(1).build();

    // Act
    ImmutableTally<Object> actualCopyOfResult = ImmutableTally.copyOf(instance);

    // Assert
    assertEquals("Id", actualCopyOfResult.id());
    assertEquals(10.0d, actualCopyOfResult.count());
  }

  /**
   * Test {@link ImmutableTally#equals(Object)}, and {@link ImmutableTally#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTally#equals(Object)}
   *   <li>{@link ImmutableTally#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableTally.equals(Object)", "int ImmutableTally.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableTally.builder();
    ImmutableTally<Object> immutableTally = builderResult.count(10.0d).id("Id").build();

    Builder<Object> builderResult2 = ImmutableTally.builder();
    ImmutableTally<Object> immutableTally2 = builderResult2.count(10.0d).id("Id").build();

    // Act and Assert
    assertEquals(immutableTally, immutableTally2);
    assertEquals(immutableTally.hashCode(), immutableTally2.hashCode());
  }

  /**
   * Test {@link ImmutableTally#equals(Object)}, and {@link ImmutableTally#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTally#equals(Object)}
   *   <li>{@link ImmutableTally#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableTally.equals(Object)", "int ImmutableTally.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableTally.builder();
    ImmutableTally<Object> immutableTally = builderResult.count(10.0d).id("Id").build();

    // Act and Assert
    assertEquals(immutableTally, immutableTally);
    int expectedHashCodeResult = immutableTally.hashCode();
    assertEquals(expectedHashCodeResult, immutableTally.hashCode());
  }

  /**
   * Test {@link ImmutableTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableTally.equals(Object)", "int ImmutableTally.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableTally.builder();
    ImmutableTally<Object> immutableTally = builderResult.count(0.5d).id("Id").build();

    Builder<Object> builderResult2 = ImmutableTally.builder();

    // Act and Assert
    assertNotEquals(immutableTally, builderResult2.count(10.0d).id("Id").build());
  }

  /**
   * Test {@link ImmutableTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableTally.equals(Object)", "int ImmutableTally.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder<Object> builderResult = ImmutableTally.builder();
    ImmutableTally<Object> immutableTally = builderResult.count(10.0d).id(1).build();

    Builder<Object> builderResult2 = ImmutableTally.builder();

    // Act and Assert
    assertNotEquals(immutableTally, builderResult2.count(10.0d).id("Id").build());
  }

  /**
   * Test {@link ImmutableTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableTally.equals(Object)", "int ImmutableTally.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder<Object> builderResult = ImmutableTally.builder();

    Builder<Object> countResult = builderResult.count(10.0d);

    Builder<Object> builderResult2 = ImmutableTally.builder();
    ImmutableTally<Object> immutableTally =
        countResult.id(builderResult2.count(10.0d).id("Id").build()).build();

    Builder<Object> builderResult3 = ImmutableTally.builder();

    // Act and Assert
    assertNotEquals(immutableTally, builderResult3.count(10.0d).id("Id").build());
  }

  /**
   * Test {@link ImmutableTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableTally.equals(Object)", "int ImmutableTally.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableTally.builder();

    // Act and Assert
    assertNotEquals(builderResult.count(10.0d).id("Id").build(), null);
  }

  /**
   * Test {@link ImmutableTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableTally.equals(Object)", "int ImmutableTally.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableTally.builder();

    // Act and Assert
    assertNotEquals(
        builderResult.count(10.0d).id("Id").build(), "Different type to ImmutableTally");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTally#toString()}
   *   <li>{@link ImmutableTally#count()}
   *   <li>{@link ImmutableTally#id()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double ImmutableTally.count()",
    "Object ImmutableTally.id()",
    "String ImmutableTally.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder<Object> builderResult = ImmutableTally.builder();
    ImmutableTally<Object> immutableTally = builderResult.count(10.0d).id("Id").build();

    // Act
    String actualToStringResult = immutableTally.toString();
    double actualCountResult = immutableTally.count();

    // Assert
    assertEquals("Id", immutableTally.id());
    assertEquals("Tally{id=Id, count=10.0}", actualToStringResult);
    assertEquals(10.0d, actualCountResult);
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
  @MethodsUnderTest({"double Json.count()"})
  void testJsonCount() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.count());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setId(Object)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()", "void Json.setId(Object)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json<Object> actualJson = new Json<>();
    actualJson.setId("Id");

    // Assert
    assertEquals("Id", actualJson.id);
    assertEquals(0.0d, actualJson.count);
    assertFalse(actualJson.countIsSet);
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
  @MethodsUnderTest({"Object Json.id()"})
  void testJsonId() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.id());
  }

  /**
   * Test Json {@link Json#setCount(double)}.
   *
   * <p>Method under test: {@link Json#setCount(double)}
   */
  @Test
  @DisplayName("Test Json setCount(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setCount(double)"})
  void testJsonSetCount() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act
    json.setCount(10.0d);

    // Assert
    assertEquals(10.0d, json.count);
    assertTrue(json.countIsSet);
  }

  /**
   * Test {@link ImmutableTally#withCount(double)}.
   *
   * <ul>
   *   <li>Given builder count {@code 0.5} id {@code Id} build.
   *   <li>Then return {@code Id}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTally#withCount(double)}
   */
  @Test
  @DisplayName("Test withCount(double); given builder count '0.5' id 'Id' build; then return 'Id'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTally ImmutableTally.withCount(double)"})
  void testWithCount_givenBuilderCount05IdIdBuild_thenReturnId() {
    // Arrange
    Builder<Object> builderResult = ImmutableTally.builder();

    // Act
    ImmutableTally<Object> actualWithCountResult =
        builderResult.count(0.5d).id("Id").build().withCount(10.0d);

    // Assert
    assertEquals("Id", actualWithCountResult.id());
    assertEquals(10.0d, actualWithCountResult.count());
  }

  /**
   * Test {@link ImmutableTally#withCount(double)}.
   *
   * <ul>
   *   <li>Given builder count ten id {@code Id} build.
   *   <li>Then return builder count ten id {@code Id} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTally#withCount(double)}
   */
  @Test
  @DisplayName(
      "Test withCount(double); given builder count ten id 'Id' build; then return builder count ten id 'Id' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTally ImmutableTally.withCount(double)"})
  void testWithCount_givenBuilderCountTenIdIdBuild_thenReturnBuilderCountTenIdIdBuild() {
    // Arrange
    Builder<Object> builderResult = ImmutableTally.builder();
    ImmutableTally<Object> immutableTally = builderResult.count(10.0d).id("Id").build();

    // Act
    ImmutableTally<Object> actualWithCountResult = immutableTally.withCount(10.0d);

    // Assert
    assertSame(immutableTally, actualWithCountResult);
  }

  /**
   * Test {@link ImmutableTally#withId(Object)}.
   *
   * <ul>
   *   <li>Given builder count ten id {@code Id} build.
   *   <li>When {@code Value}.
   *   <li>Then return id is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTally#withId(Object)}
   */
  @Test
  @DisplayName(
      "Test withId(Object); given builder count ten id 'Id' build; when 'Value'; then return id is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTally ImmutableTally.withId(Object)"})
  void testWithId_givenBuilderCountTenIdIdBuild_whenValue_thenReturnIdIsValue() {
    // Arrange
    Builder<Object> builderResult = ImmutableTally.builder();

    // Act
    ImmutableTally<Object> actualWithIdResult =
        builderResult.count(10.0d).id("Id").build().withId("Value");

    // Assert
    assertEquals("Value", actualWithIdResult.id());
    assertEquals(10.0d, actualWithIdResult.count());
  }

  /**
   * Test {@link ImmutableTally#withId(Object)}.
   *
   * <ul>
   *   <li>Given builder count ten id one build.
   *   <li>Then return builder count ten id one build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTally#withId(Object)}
   */
  @Test
  @DisplayName(
      "Test withId(Object); given builder count ten id one build; then return builder count ten id one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTally ImmutableTally.withId(Object)"})
  void testWithId_givenBuilderCountTenIdOneBuild_thenReturnBuilderCountTenIdOneBuild() {
    // Arrange
    Builder<Object> builderResult = ImmutableTally.builder();
    ImmutableTally<Object> immutableTally = builderResult.count(10.0d).id(1).build();

    // Act
    ImmutableTally<Object> actualWithIdResult = immutableTally.withId(1);

    // Assert
    assertSame(immutableTally, actualWithIdResult);
  }
}
