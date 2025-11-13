package org.finos.waltz.model.tally;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Date;
import org.finos.waltz.model.tally.ImmutableDateTally.Builder;
import org.finos.waltz.model.tally.ImmutableDateTally.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDateTallyDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDateTally Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualCountResult = ImmutableDateTally.builder().count(3L);
    Date date = new Date(1L);
    ImmutableDateTally actualImmutableDateTally = actualCountResult.date(date).build();

    // Assert
    assertEquals(3L, actualImmutableDateTally.count());
    assertSame(date, actualImmutableDateTally.date());
  }

  /**
   * Test Builder {@link Builder#count(long)}.
   *
   * <p>Method under test: {@link Builder#count(long)}
   */
  @Test
  @DisplayName("Test Builder count(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.count(long)"})
  void testBuilderCount() {
    // Arrange
    Builder builderResult = ImmutableDateTally.builder();

    // Act
    Builder actualCountResult = builderResult.count(3L);

    // Assert
    assertSame(builderResult, actualCountResult);
  }

  /**
   * Test Builder {@link Builder#date(Date)}.
   *
   * <ul>
   *   <li>When {@link Date#Date(long)} with date is one.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#date(Date)}
   */
  @Test
  @DisplayName("Test Builder date(Date); when Date(long) with date is one; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.date(Date)"})
  void testBuilderDate_whenDateWithDateIsOne_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDateTally.builder();

    // Act
    Builder actualDateResult = builderResult.date(new Date(1L));

    // Assert
    assertSame(builderResult, actualDateResult);
  }

  /**
   * Test Builder {@link Builder#from(DateTally)}.
   *
   * <ul>
   *   <li>Then builder build is builder count three date {@link Date#Date(long)} with date is one
   *       build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DateTally)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DateTally); then builder build is builder count three date Date(long) with date is one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DateTally)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderCountThreeDateDateWithDateIsOneBuild() {
    // Arrange
    Builder builderResult = ImmutableDateTally.builder();

    Builder countResult = ImmutableDateTally.builder().count(3L);
    ImmutableDateTally instance = countResult.date(new Date(1L)).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableDateTally actualImmutableDateTally = builderResult.build();
    assertEquals(instance, actualImmutableDateTally);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableDateTally#copyOf(DateTally)}.
   *
   * <ul>
   *   <li>Then return count is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateTally#copyOf(DateTally)}
   */
  @Test
  @DisplayName("Test copyOf(DateTally); then return count is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDateTally ImmutableDateTally.copyOf(DateTally)"})
  void testCopyOf_thenReturnCountIsThree() {
    // Arrange
    Builder countResult = ImmutableDateTally.builder().count(3L);
    ImmutableDateTally instance = countResult.date(new Date(1L)).build();

    // Act and Assert
    assertEquals(3L, ImmutableDateTally.copyOf(instance).count());
  }

  /**
   * Test {@link ImmutableDateTally#equals(Object)}, and {@link ImmutableDateTally#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDateTally#equals(Object)}
   *   <li>{@link ImmutableDateTally#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDateTally.equals(Object)",
    "int ImmutableDateTally.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder countResult = ImmutableDateTally.builder().count(3L);
    ImmutableDateTally immutableDateTally = countResult.date(new Date(1L)).build();

    Builder countResult2 = ImmutableDateTally.builder().count(3L);
    ImmutableDateTally immutableDateTally2 = countResult2.date(new Date(1L)).build();

    // Act and Assert
    assertEquals(immutableDateTally, immutableDateTally2);
    assertEquals(immutableDateTally.hashCode(), immutableDateTally2.hashCode());
  }

  /**
   * Test {@link ImmutableDateTally#equals(Object)}, and {@link ImmutableDateTally#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDateTally#equals(Object)}
   *   <li>{@link ImmutableDateTally#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDateTally.equals(Object)",
    "int ImmutableDateTally.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder countResult = ImmutableDateTally.builder().count(3L);
    ImmutableDateTally immutableDateTally = countResult.date(new Date(1L)).build();

    // Act and Assert
    assertEquals(immutableDateTally, immutableDateTally);
    int expectedHashCodeResult = immutableDateTally.hashCode();
    assertEquals(expectedHashCodeResult, immutableDateTally.hashCode());
  }

  /**
   * Test {@link ImmutableDateTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDateTally.equals(Object)",
    "int ImmutableDateTally.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder countResult = ImmutableDateTally.builder().count(1L);
    ImmutableDateTally immutableDateTally = countResult.date(new Date(1L)).build();

    Builder countResult2 = ImmutableDateTally.builder().count(3L);

    // Act and Assert
    assertNotEquals(immutableDateTally, countResult2.date(new Date(1L)).build());
  }

  /**
   * Test {@link ImmutableDateTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDateTally.equals(Object)",
    "int ImmutableDateTally.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder countResult = ImmutableDateTally.builder().count(3L);
    ImmutableDateTally immutableDateTally = countResult.date(new Date(3L)).build();

    Builder countResult2 = ImmutableDateTally.builder().count(3L);

    // Act and Assert
    assertNotEquals(immutableDateTally, countResult2.date(new Date(1L)).build());
  }

  /**
   * Test {@link ImmutableDateTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDateTally.equals(Object)",
    "int ImmutableDateTally.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder countResult = ImmutableDateTally.builder().count(3L);

    // Act and Assert
    assertNotEquals(countResult.date(new Date(1L)).build(), null);
  }

  /**
   * Test {@link ImmutableDateTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDateTally.equals(Object)",
    "int ImmutableDateTally.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder countResult = ImmutableDateTally.builder().count(3L);

    // Act and Assert
    assertNotEquals(countResult.date(new Date(1L)).build(), "Different type to ImmutableDateTally");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDateTally#toString()}
   *   <li>{@link ImmutableDateTally#count()}
   *   <li>{@link ImmutableDateTally#date()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableDateTally.count()",
    "Date ImmutableDateTally.date()",
    "java.lang.String ImmutableDateTally.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder countResult = ImmutableDateTally.builder().count(3L);
    Date date = new Date(1L);
    ImmutableDateTally immutableDateTally = countResult.date(date).build();

    // Act
    immutableDateTally.toString();
    long actualCountResult = immutableDateTally.count();

    // Assert
    assertEquals(3L, actualCountResult);
    assertSame(date, immutableDateTally.date());
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
  @MethodsUnderTest({"long Json.count()"})
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().count());
  }

  /**
   * Test Json {@link Json#date()}.
   *
   * <p>Method under test: {@link Json#date()}
   */
  @Test
  @DisplayName("Test Json date()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Date Json.date()"})
  void testJsonDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().date());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDate(Date)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()", "void Json.setDate(Date)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDate(new Date(1L));

    // Assert
    assertEquals(0L, actualJson.count);
    assertFalse(actualJson.countIsSet);
  }

  /**
   * Test Json {@link Json#setCount(long)}.
   *
   * <p>Method under test: {@link Json#setCount(long)}
   */
  @Test
  @DisplayName("Test Json setCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setCount(long)"})
  void testJsonSetCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setCount(3L);

    // Assert
    assertEquals(3L, json.count);
    assertTrue(json.countIsSet);
  }

  /**
   * Test {@link ImmutableDateTally#withCount(long)}.
   *
   * <ul>
   *   <li>Then return builder count forty-two date {@link Date#Date(long)} with date is one build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateTally#withCount(long)}
   */
  @Test
  @DisplayName(
      "Test withCount(long); then return builder count forty-two date Date(long) with date is one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDateTally ImmutableDateTally.withCount(long)"})
  void testWithCount_thenReturnBuilderCountFortyTwoDateDateWithDateIsOneBuild() {
    // Arrange
    Builder countResult = ImmutableDateTally.builder().count(42L);
    ImmutableDateTally immutableDateTally = countResult.date(new Date(1L)).build();

    // Act
    ImmutableDateTally actualWithCountResult = immutableDateTally.withCount(42L);

    // Assert
    assertSame(immutableDateTally, actualWithCountResult);
  }

  /**
   * Test {@link ImmutableDateTally#withCount(long)}.
   *
   * <ul>
   *   <li>Then return count is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateTally#withCount(long)}
   */
  @Test
  @DisplayName("Test withCount(long); then return count is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDateTally ImmutableDateTally.withCount(long)"})
  void testWithCount_thenReturnCountIsFortyTwo() {
    // Arrange
    Builder countResult = ImmutableDateTally.builder().count(3L);

    // Act and Assert
    assertEquals(42L, countResult.date(new Date(1L)).build().withCount(42L).count());
  }

  /**
   * Test {@link ImmutableDateTally#withDate(Date)}.
   *
   * <p>Method under test: {@link ImmutableDateTally#withDate(Date)}
   */
  @Test
  @DisplayName("Test withDate(Date)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDateTally ImmutableDateTally.withDate(Date)"})
  void testWithDate() {
    // Arrange
    Builder countResult = ImmutableDateTally.builder().count(3L);
    ImmutableDateTally immutableDateTally = countResult.date(new Date(1L)).build();

    // Act
    ImmutableDateTally actualWithDateResult = immutableDateTally.withDate(new Date(1L));

    // Assert
    assertEquals(immutableDateTally, actualWithDateResult);
  }
}
