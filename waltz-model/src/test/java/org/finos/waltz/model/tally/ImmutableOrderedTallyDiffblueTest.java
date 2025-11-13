package org.finos.waltz.model.tally;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.tally.ImmutableOrderedTally.Builder;
import org.finos.waltz.model.tally.ImmutableOrderedTally.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableOrderedTallyDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableOrderedTally Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder<Object> actualBuilderResult = ImmutableOrderedTally.builder();
    ImmutableOrderedTally<Object> actualImmutableOrderedTally =
        actualBuilderResult.count(10.0d).id("Id").index(1).build();

    // Assert
    assertEquals("Id", actualImmutableOrderedTally.id());
    assertEquals(1, actualImmutableOrderedTally.index());
    assertEquals(10.0d, actualImmutableOrderedTally.count());
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
    Builder<Object> builderResult = ImmutableOrderedTally.builder();

    // Act
    Builder<Object> actualCountResult = builderResult.count(10.0d);

    // Assert
    assertSame(builderResult, actualCountResult);
  }

  /**
   * Test Builder {@link Builder#from(OrderedTally)} with {@code OrderedTally}.
   *
   * <p>Method under test: {@link Builder#from(OrderedTally)}
   */
  @Test
  @DisplayName("Test Builder from(OrderedTally) with 'OrderedTally'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(OrderedTally)"})
  void testBuilderFromWithOrderedTally() {
    // Arrange
    Builder<Object> builderResult = ImmutableOrderedTally.builder();

    Builder<Object> builderResult2 = ImmutableOrderedTally.builder();
    ImmutableOrderedTally<Object> instance = builderResult2.count(10.0d).id("Id").index(1).build();

    // Act
    Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableOrderedTally<Object> actualImmutableOrderedTally = builderResult.build();
    assertEquals(instance, actualImmutableOrderedTally);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Tally)} with {@code Tally}.
   *
   * <ul>
   *   <li>Then builder build is builder count ten id {@code Id} index one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(Tally)}
   */
  @Test
  @DisplayName(
      "Test Builder from(Tally) with 'Tally'; then builder build is builder count ten id 'Id' index one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Tally)"})
  void testBuilderFromWithTally_thenBuilderBuildIsBuilderCountTenIdIdIndexOneBuild() {
    // Arrange
    Builder<Object> builderResult = ImmutableOrderedTally.builder();

    Builder<Object> builderResult2 = ImmutableOrderedTally.builder();
    ImmutableOrderedTally<Object> instance = builderResult2.count(10.0d).id("Id").index(1).build();

    // Act
    Builder<Object> actualFromResult = builderResult.from((Tally<Object>) instance);

    // Assert
    ImmutableOrderedTally<Object> actualImmutableOrderedTally = builderResult.build();
    assertEquals(instance, actualImmutableOrderedTally);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Tally)} with {@code Tally}.
   *
   * <ul>
   *   <li>When builder count ten id {@code Id} build.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(Tally)}
   */
  @Test
  @DisplayName(
      "Test Builder from(Tally) with 'Tally'; when builder count ten id 'Id' build; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Tally)"})
  void testBuilderFromWithTally_whenBuilderCountTenIdIdBuild_thenReturnBuilder() {
    // Arrange
    Builder<Object> builderResult = ImmutableOrderedTally.builder();

    ImmutableTally.Builder<Object> builderResult2 = ImmutableTally.builder();

    // Act
    Builder<Object> actualFromResult =
        builderResult.from(builderResult2.count(10.0d).id("Id").build());

    // Assert
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
    Builder<Object> builderResult = ImmutableOrderedTally.builder();

    // Act
    Builder<Object> actualIdResult = builderResult.id("Id");

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#index(int)}.
   *
   * <p>Method under test: {@link Builder#index(int)}
   */
  @Test
  @DisplayName("Test Builder index(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.index(int)"})
  void testBuilderIndex() {
    // Arrange
    Builder<Object> builderResult = ImmutableOrderedTally.builder();

    // Act
    Builder<Object> actualIndexResult = builderResult.index(1);

    // Assert
    assertSame(builderResult, actualIndexResult);
  }

  /**
   * Test {@link ImmutableOrderedTally#copyOf(OrderedTally)}.
   *
   * <ul>
   *   <li>When builder count ten id {@code Id} index one build.
   *   <li>Then return {@code Id}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrderedTally#copyOf(OrderedTally)}
   */
  @Test
  @DisplayName(
      "Test copyOf(OrderedTally); when builder count ten id 'Id' index one build; then return 'Id'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableOrderedTally ImmutableOrderedTally.copyOf(OrderedTally)"})
  void testCopyOf_whenBuilderCountTenIdIdIndexOneBuild_thenReturnId() {
    // Arrange
    Builder<Object> builderResult = ImmutableOrderedTally.builder();
    ImmutableOrderedTally<Object> instance = builderResult.count(10.0d).id("Id").index(1).build();

    // Act
    ImmutableOrderedTally<Object> actualCopyOfResult = ImmutableOrderedTally.copyOf(instance);

    // Assert
    assertEquals("Id", actualCopyOfResult.id());
    assertEquals(1, actualCopyOfResult.index());
    assertEquals(10.0d, actualCopyOfResult.count());
  }

  /**
   * Test {@link ImmutableOrderedTally#equals(Object)}, and {@link
   * ImmutableOrderedTally#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOrderedTally#equals(Object)}
   *   <li>{@link ImmutableOrderedTally#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrderedTally.equals(Object)",
    "int ImmutableOrderedTally.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableOrderedTally.builder();
    ImmutableOrderedTally<Object> immutableOrderedTally =
        builderResult.count(10.0d).id("Id").index(1).build();

    Builder<Object> builderResult2 = ImmutableOrderedTally.builder();
    ImmutableOrderedTally<Object> immutableOrderedTally2 =
        builderResult2.count(10.0d).id("Id").index(1).build();

    // Act and Assert
    assertEquals(immutableOrderedTally, immutableOrderedTally2);
    assertEquals(immutableOrderedTally.hashCode(), immutableOrderedTally2.hashCode());
  }

  /**
   * Test {@link ImmutableOrderedTally#equals(Object)}, and {@link
   * ImmutableOrderedTally#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOrderedTally#equals(Object)}
   *   <li>{@link ImmutableOrderedTally#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrderedTally.equals(Object)",
    "int ImmutableOrderedTally.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableOrderedTally.builder();
    ImmutableOrderedTally<Object> immutableOrderedTally =
        builderResult.count(10.0d).id("Id").index(1).build();

    // Act and Assert
    assertEquals(immutableOrderedTally, immutableOrderedTally);
    int expectedHashCodeResult = immutableOrderedTally.hashCode();
    assertEquals(expectedHashCodeResult, immutableOrderedTally.hashCode());
  }

  /**
   * Test {@link ImmutableOrderedTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrderedTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrderedTally.equals(Object)",
    "int ImmutableOrderedTally.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableOrderedTally.builder();
    ImmutableOrderedTally<Object> immutableOrderedTally =
        builderResult.count(0.5d).id("Id").index(1).build();

    Builder<Object> builderResult2 = ImmutableOrderedTally.builder();

    // Act and Assert
    assertNotEquals(immutableOrderedTally, builderResult2.count(10.0d).id("Id").index(1).build());
  }

  /**
   * Test {@link ImmutableOrderedTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrderedTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrderedTally.equals(Object)",
    "int ImmutableOrderedTally.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder<Object> builderResult = ImmutableOrderedTally.builder();
    ImmutableOrderedTally<Object> immutableOrderedTally =
        builderResult.count(10.0d).id(1).index(1).build();

    Builder<Object> builderResult2 = ImmutableOrderedTally.builder();

    // Act and Assert
    assertNotEquals(immutableOrderedTally, builderResult2.count(10.0d).id("Id").index(1).build());
  }

  /**
   * Test {@link ImmutableOrderedTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrderedTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrderedTally.equals(Object)",
    "int ImmutableOrderedTally.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder<Object> builderResult = ImmutableOrderedTally.builder();

    Builder<Object> countResult = builderResult.count(10.0d);

    Builder<Object> builderResult2 = ImmutableOrderedTally.builder();
    ImmutableOrderedTally<Object> immutableOrderedTally =
        countResult.id(builderResult2.count(10.0d).id("Id").index(1).build()).index(1).build();

    Builder<Object> builderResult3 = ImmutableOrderedTally.builder();

    // Act and Assert
    assertNotEquals(immutableOrderedTally, builderResult3.count(10.0d).id("Id").index(1).build());
  }

  /**
   * Test {@link ImmutableOrderedTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrderedTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrderedTally.equals(Object)",
    "int ImmutableOrderedTally.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder<Object> builderResult = ImmutableOrderedTally.builder();
    ImmutableOrderedTally<Object> immutableOrderedTally =
        builderResult.count(10.0d).id("Id").index(0).build();

    Builder<Object> builderResult2 = ImmutableOrderedTally.builder();

    // Act and Assert
    assertNotEquals(immutableOrderedTally, builderResult2.count(10.0d).id("Id").index(1).build());
  }

  /**
   * Test {@link ImmutableOrderedTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrderedTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrderedTally.equals(Object)",
    "int ImmutableOrderedTally.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableOrderedTally.builder();

    // Act and Assert
    assertNotEquals(builderResult.count(10.0d).id("Id").index(1).build(), null);
  }

  /**
   * Test {@link ImmutableOrderedTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrderedTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrderedTally.equals(Object)",
    "int ImmutableOrderedTally.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableOrderedTally.builder();

    // Act and Assert
    assertNotEquals(
        builderResult.count(10.0d).id("Id").index(1).build(),
        "Different type to ImmutableOrderedTally");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOrderedTally#toString()}
   *   <li>{@link ImmutableOrderedTally#count()}
   *   <li>{@link ImmutableOrderedTally#id()}
   *   <li>{@link ImmutableOrderedTally#index()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double ImmutableOrderedTally.count()",
    "Object ImmutableOrderedTally.id()",
    "int ImmutableOrderedTally.index()",
    "String ImmutableOrderedTally.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder<Object> builderResult = ImmutableOrderedTally.builder();
    ImmutableOrderedTally<Object> immutableOrderedTally =
        builderResult.count(10.0d).id("Id").index(1).build();

    // Act
    String actualToStringResult = immutableOrderedTally.toString();
    double actualCountResult = immutableOrderedTally.count();
    Object actualIdResult = immutableOrderedTally.id();

    // Assert
    assertEquals("Id", actualIdResult);
    assertEquals("OrderedTally{id=Id, count=10.0, index=1}", actualToStringResult);
    assertEquals(1, immutableOrderedTally.index());
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
    assertEquals(0, actualJson.index);
    assertEquals(0.0d, actualJson.count);
    assertFalse(actualJson.countIsSet);
    assertFalse(actualJson.indexIsSet);
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
   * Test Json {@link Json#index()}.
   *
   * <p>Method under test: {@link Json#index()}
   */
  @Test
  @DisplayName("Test Json index()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.index()"})
  void testJsonIndex() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.index());
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
   * Test Json {@link Json#setIndex(int)}.
   *
   * <p>Method under test: {@link Json#setIndex(int)}
   */
  @Test
  @DisplayName("Test Json setIndex(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIndex(int)"})
  void testJsonSetIndex() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act
    json.setIndex(1);

    // Assert
    assertEquals(1, json.index);
    assertTrue(json.indexIsSet);
  }

  /**
   * Test {@link ImmutableOrderedTally#withCount(double)}.
   *
   * <ul>
   *   <li>Given builder count {@code 0.5} id {@code Id} index one build.
   *   <li>Then return {@code Id}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrderedTally#withCount(double)}
   */
  @Test
  @DisplayName(
      "Test withCount(double); given builder count '0.5' id 'Id' index one build; then return 'Id'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableOrderedTally ImmutableOrderedTally.withCount(double)"})
  void testWithCount_givenBuilderCount05IdIdIndexOneBuild_thenReturnId() {
    // Arrange
    Builder<Object> builderResult = ImmutableOrderedTally.builder();

    // Act
    ImmutableOrderedTally<Object> actualWithCountResult =
        builderResult.count(0.5d).id("Id").index(1).build().withCount(10.0d);

    // Assert
    assertEquals("Id", actualWithCountResult.id());
    assertEquals(1, actualWithCountResult.index());
    assertEquals(10.0d, actualWithCountResult.count());
  }

  /**
   * Test {@link ImmutableOrderedTally#withCount(double)}.
   *
   * <ul>
   *   <li>Then return builder count ten id {@code Id} index one build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrderedTally#withCount(double)}
   */
  @Test
  @DisplayName("Test withCount(double); then return builder count ten id 'Id' index one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableOrderedTally ImmutableOrderedTally.withCount(double)"})
  void testWithCount_thenReturnBuilderCountTenIdIdIndexOneBuild() {
    // Arrange
    Builder<Object> builderResult = ImmutableOrderedTally.builder();
    ImmutableOrderedTally<Object> immutableOrderedTally =
        builderResult.count(10.0d).id("Id").index(1).build();

    // Act
    ImmutableOrderedTally<Object> actualWithCountResult = immutableOrderedTally.withCount(10.0d);

    // Assert
    assertSame(immutableOrderedTally, actualWithCountResult);
  }

  /**
   * Test {@link ImmutableOrderedTally#withId(Object)}.
   *
   * <ul>
   *   <li>Given builder count ten id {@code Id} index one build.
   *   <li>When {@code Value}.
   *   <li>Then return id is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrderedTally#withId(Object)}
   */
  @Test
  @DisplayName(
      "Test withId(Object); given builder count ten id 'Id' index one build; when 'Value'; then return id is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableOrderedTally ImmutableOrderedTally.withId(Object)"})
  void testWithId_givenBuilderCountTenIdIdIndexOneBuild_whenValue_thenReturnIdIsValue() {
    // Arrange
    Builder<Object> builderResult = ImmutableOrderedTally.builder();

    // Act
    ImmutableOrderedTally<Object> actualWithIdResult =
        builderResult.count(10.0d).id("Id").index(1).build().withId("Value");

    // Assert
    assertEquals("Value", actualWithIdResult.id());
    assertEquals(1, actualWithIdResult.index());
    assertEquals(10.0d, actualWithIdResult.count());
  }

  /**
   * Test {@link ImmutableOrderedTally#withId(Object)}.
   *
   * <ul>
   *   <li>Then return builder count ten id one index one build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrderedTally#withId(Object)}
   */
  @Test
  @DisplayName("Test withId(Object); then return builder count ten id one index one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableOrderedTally ImmutableOrderedTally.withId(Object)"})
  void testWithId_thenReturnBuilderCountTenIdOneIndexOneBuild() {
    // Arrange
    Builder<Object> builderResult = ImmutableOrderedTally.builder();
    ImmutableOrderedTally<Object> immutableOrderedTally =
        builderResult.count(10.0d).id(1).index(1).build();

    // Act
    ImmutableOrderedTally<Object> actualWithIdResult = immutableOrderedTally.withId(1);

    // Assert
    assertSame(immutableOrderedTally, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableOrderedTally#withIndex(int)}.
   *
   * <ul>
   *   <li>Given builder count ten id {@code Id} index one build.
   *   <li>Then return {@code Id}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrderedTally#withIndex(int)}
   */
  @Test
  @DisplayName(
      "Test withIndex(int); given builder count ten id 'Id' index one build; then return 'Id'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableOrderedTally ImmutableOrderedTally.withIndex(int)"})
  void testWithIndex_givenBuilderCountTenIdIdIndexOneBuild_thenReturnId() {
    // Arrange
    Builder<Object> builderResult = ImmutableOrderedTally.builder();

    // Act
    ImmutableOrderedTally<Object> actualWithIndexResult =
        builderResult.count(10.0d).id("Id").index(1).build().withIndex(42);

    // Assert
    assertEquals("Id", actualWithIndexResult.id());
    assertEquals(10.0d, actualWithIndexResult.count());
    assertEquals(42, actualWithIndexResult.index());
  }

  /**
   * Test {@link ImmutableOrderedTally#withIndex(int)}.
   *
   * <ul>
   *   <li>Then return builder count ten id {@code Id} index forty-two build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrderedTally#withIndex(int)}
   */
  @Test
  @DisplayName("Test withIndex(int); then return builder count ten id 'Id' index forty-two build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableOrderedTally ImmutableOrderedTally.withIndex(int)"})
  void testWithIndex_thenReturnBuilderCountTenIdIdIndexFortyTwoBuild() {
    // Arrange
    Builder<Object> builderResult = ImmutableOrderedTally.builder();
    ImmutableOrderedTally<Object> immutableOrderedTally =
        builderResult.count(10.0d).id("Id").index(42).build();

    // Act
    ImmutableOrderedTally<Object> actualWithIndexResult = immutableOrderedTally.withIndex(42);

    // Assert
    assertSame(immutableOrderedTally, actualWithIndexResult);
  }
}
