package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.model.ImmutablePairDiffResult.Builder;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePairDiffResultDiffblueTest {
  /**
   * Test Builder {@link Builder#allIntersection(Collection)}.
   *
   * <ul>
   *   <li>Given {@link Tuple2#Tuple2(Object, Object)} with {@code V1} and {@code V2}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#allIntersection(Collection)}
   */
  @Test
  @DisplayName(
      "Test Builder allIntersection(Collection); given Tuple2(Object, Object) with 'V1' and 'V2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.allIntersection(Collection)"})
  void testBuilderAllIntersection_givenTuple2WithV1AndV2() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    ArrayList<Tuple2<Object, Object>> allIntersection = new ArrayList<>();
    allIntersection.add(new Tuple2<>("V1", "V2"));

    // Act
    Builder<Object, Object> actualAllIntersectionResult =
        builderResult.allIntersection(allIntersection);

    // Assert
    assertSame(builderResult, actualAllIntersectionResult);
  }

  /**
   * Test Builder {@link Builder#allIntersection(Collection)}.
   *
   * <ul>
   *   <li>Given {@link Tuple2#Tuple2(Object, Object)} with {@code V1} and {@code V2}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#allIntersection(Collection)}
   */
  @Test
  @DisplayName(
      "Test Builder allIntersection(Collection); given Tuple2(Object, Object) with 'V1' and 'V2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.allIntersection(Collection)"})
  void testBuilderAllIntersection_givenTuple2WithV1AndV22() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    ArrayList<Tuple2<Object, Object>> allIntersection = new ArrayList<>();
    allIntersection.add(new Tuple2<>("V1", "V2"));
    allIntersection.add(new Tuple2<>("V1", "V2"));

    // Act
    Builder<Object, Object> actualAllIntersectionResult =
        builderResult.allIntersection(allIntersection);

    // Assert
    assertSame(builderResult, actualAllIntersectionResult);
  }

  /**
   * Test Builder {@link Builder#allIntersection(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#allIntersection(Collection)}
   */
  @Test
  @DisplayName("Test Builder allIntersection(Collection); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.allIntersection(Collection)"})
  void testBuilderAllIntersection_whenArrayList() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    // Act
    Builder<Object, Object> actualAllIntersectionResult =
        builderResult.allIntersection(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAllIntersectionResult);
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
  @MethodsUnderTest({"ImmutablePairDiffResult Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder<Object, Object> actualBuilderResult = ImmutablePairDiffResult.builder();
    ArrayList<Tuple2<Object, Object>> allIntersection = new ArrayList<>();
    Builder<Object, Object> actualAllIntersectionResult =
        actualBuilderResult.allIntersection(allIntersection);
    ArrayList<Tuple2<Object, Object>> differingIntersection = new ArrayList<>();
    Builder<Object, Object> actualDifferingIntersectionResult =
        actualAllIntersectionResult.differingIntersection(differingIntersection);
    ArrayList<Object> otherOnly = new ArrayList<>();
    Builder<Object, Object> actualOtherOnlyResult =
        actualDifferingIntersectionResult.otherOnly(otherOnly);
    ArrayList<Object> waltzOnly = new ArrayList<>();
    ImmutablePairDiffResult<Object, Object> actualImmutablePairDiffResult =
        actualOtherOnlyResult.waltzOnly(waltzOnly).build();

    // Assert
    Collection<Tuple2<Object, Object>> allIntersectionResult =
        actualImmutablePairDiffResult.allIntersection();
    assertTrue(allIntersectionResult instanceof List);
    Collection<Tuple2<Object, Object>> differingIntersectionResult =
        actualImmutablePairDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof List);
    Collection<Object> otherOnlyResult = actualImmutablePairDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof List);
    Collection<Object> waltzOnlyResult = actualImmutablePairDiffResult.waltzOnly();
    assertTrue(waltzOnlyResult instanceof List);
    assertSame(allIntersection, allIntersectionResult);
    assertSame(differingIntersection, differingIntersectionResult);
    assertSame(otherOnly, otherOnlyResult);
    assertSame(waltzOnly, waltzOnlyResult);
  }

  /**
   * Test Builder {@link Builder#differingIntersection(Collection)}.
   *
   * <ul>
   *   <li>Given {@link Tuple2#Tuple2(Object, Object)} with {@code V1} and {@code V2}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#differingIntersection(Collection)}
   */
  @Test
  @DisplayName(
      "Test Builder differingIntersection(Collection); given Tuple2(Object, Object) with 'V1' and 'V2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.differingIntersection(Collection)"})
  void testBuilderDifferingIntersection_givenTuple2WithV1AndV2() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    ArrayList<Tuple2<Object, Object>> differingIntersection = new ArrayList<>();
    differingIntersection.add(new Tuple2<>("V1", "V2"));

    // Act
    Builder<Object, Object> actualDifferingIntersectionResult =
        builderResult.differingIntersection(differingIntersection);

    // Assert
    assertSame(builderResult, actualDifferingIntersectionResult);
  }

  /**
   * Test Builder {@link Builder#differingIntersection(Collection)}.
   *
   * <ul>
   *   <li>Given {@link Tuple2#Tuple2(Object, Object)} with {@code V1} and {@code V2}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#differingIntersection(Collection)}
   */
  @Test
  @DisplayName(
      "Test Builder differingIntersection(Collection); given Tuple2(Object, Object) with 'V1' and 'V2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.differingIntersection(Collection)"})
  void testBuilderDifferingIntersection_givenTuple2WithV1AndV22() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    ArrayList<Tuple2<Object, Object>> differingIntersection = new ArrayList<>();
    differingIntersection.add(new Tuple2<>("V1", "V2"));
    differingIntersection.add(new Tuple2<>("V1", "V2"));

    // Act
    Builder<Object, Object> actualDifferingIntersectionResult =
        builderResult.differingIntersection(differingIntersection);

    // Assert
    assertSame(builderResult, actualDifferingIntersectionResult);
  }

  /**
   * Test Builder {@link Builder#differingIntersection(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#differingIntersection(Collection)}
   */
  @Test
  @DisplayName("Test Builder differingIntersection(Collection); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.differingIntersection(Collection)"})
  void testBuilderDifferingIntersection_whenArrayList() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    // Act
    Builder<Object, Object> actualDifferingIntersectionResult =
        builderResult.differingIntersection(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualDifferingIntersectionResult);
  }

  /**
   * Test Builder {@link Builder#from(PairDiffResult)}.
   *
   * <p>Method under test: {@link Builder#from(PairDiffResult)}
   */
  @Test
  @DisplayName("Test Builder from(PairDiffResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PairDiffResult)"})
  void testBuilderFrom() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    Builder<Object, Object> builderResult2 = ImmutablePairDiffResult.builder();

    Builder<Object, Object> allIntersectionResult =
        builderResult2.allIntersection(new ArrayList<>());

    Builder<Object, Object> differingIntersectionResult =
        allIntersectionResult.differingIntersection(new ArrayList<>());

    Builder<Object, Object> otherOnlyResult =
        differingIntersectionResult.otherOnly(new ArrayList<>());
    ImmutablePairDiffResult<Object, Object> instance =
        otherOnlyResult.waltzOnly(new ArrayList<>()).build();

    // Act
    Builder<Object, Object> actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePairDiffResult<Object, Object> actualImmutablePairDiffResult = builderResult.build();
    assertEquals(instance, actualImmutablePairDiffResult);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#otherOnly(Collection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#otherOnly(Collection)}
   */
  @Test
  @DisplayName("Test Builder otherOnly(Collection); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.otherOnly(Collection)"})
  void testBuilderOtherOnly_given42_whenArrayListAdd42() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    ArrayList<Object> otherOnly = new ArrayList<>();
    otherOnly.add("42");

    // Act
    Builder<Object, Object> actualOtherOnlyResult = builderResult.otherOnly(otherOnly);

    // Assert
    assertSame(builderResult, actualOtherOnlyResult);
  }

  /**
   * Test Builder {@link Builder#otherOnly(Collection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#otherOnly(Collection)}
   */
  @Test
  @DisplayName("Test Builder otherOnly(Collection); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.otherOnly(Collection)"})
  void testBuilderOtherOnly_given42_whenArrayListAdd422() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    ArrayList<Object> otherOnly = new ArrayList<>();
    otherOnly.add("42");
    otherOnly.add("42");

    // Act
    Builder<Object, Object> actualOtherOnlyResult = builderResult.otherOnly(otherOnly);

    // Assert
    assertSame(builderResult, actualOtherOnlyResult);
  }

  /**
   * Test Builder {@link Builder#otherOnly(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#otherOnly(Collection)}
   */
  @Test
  @DisplayName("Test Builder otherOnly(Collection); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.otherOnly(Collection)"})
  void testBuilderOtherOnly_whenArrayList() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    // Act
    Builder<Object, Object> actualOtherOnlyResult = builderResult.otherOnly(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualOtherOnlyResult);
  }

  /**
   * Test Builder {@link Builder#waltzOnly(Collection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#waltzOnly(Collection)}
   */
  @Test
  @DisplayName("Test Builder waltzOnly(Collection); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.waltzOnly(Collection)"})
  void testBuilderWaltzOnly_given42_whenArrayListAdd42() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    ArrayList<Object> waltzOnly = new ArrayList<>();
    waltzOnly.add("42");

    // Act
    Builder<Object, Object> actualWaltzOnlyResult = builderResult.waltzOnly(waltzOnly);

    // Assert
    assertSame(builderResult, actualWaltzOnlyResult);
  }

  /**
   * Test Builder {@link Builder#waltzOnly(Collection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#waltzOnly(Collection)}
   */
  @Test
  @DisplayName("Test Builder waltzOnly(Collection); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.waltzOnly(Collection)"})
  void testBuilderWaltzOnly_given42_whenArrayListAdd422() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    ArrayList<Object> waltzOnly = new ArrayList<>();
    waltzOnly.add("42");
    waltzOnly.add("42");

    // Act
    Builder<Object, Object> actualWaltzOnlyResult = builderResult.waltzOnly(waltzOnly);

    // Assert
    assertSame(builderResult, actualWaltzOnlyResult);
  }

  /**
   * Test Builder {@link Builder#waltzOnly(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#waltzOnly(Collection)}
   */
  @Test
  @DisplayName("Test Builder waltzOnly(Collection); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.waltzOnly(Collection)"})
  void testBuilderWaltzOnly_whenArrayList() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    // Act
    Builder<Object, Object> actualWaltzOnlyResult = builderResult.waltzOnly(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualWaltzOnlyResult);
  }

  /**
   * Test {@link ImmutablePairDiffResult#copyOf(PairDiffResult)}.
   *
   * <ul>
   *   <li>Then allIntersection return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePairDiffResult#copyOf(PairDiffResult)}
   */
  @Test
  @DisplayName("Test copyOf(PairDiffResult); then allIntersection return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePairDiffResult ImmutablePairDiffResult.copyOf(PairDiffResult)"})
  void testCopyOf_thenAllIntersectionReturnList() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();
    ArrayList<Tuple2<Object, Object>> allIntersection = new ArrayList<>();

    Builder<Object, Object> allIntersectionResult = builderResult.allIntersection(allIntersection);
    ArrayList<Tuple2<Object, Object>> differingIntersection = new ArrayList<>();

    Builder<Object, Object> differingIntersectionResult =
        allIntersectionResult.differingIntersection(differingIntersection);
    ArrayList<Object> otherOnly = new ArrayList<>();

    Builder<Object, Object> otherOnlyResult = differingIntersectionResult.otherOnly(otherOnly);
    ArrayList<Object> waltzOnly = new ArrayList<>();
    ImmutablePairDiffResult<Object, Object> instance = otherOnlyResult.waltzOnly(waltzOnly).build();

    // Act
    ImmutablePairDiffResult<Object, Object> actualCopyOfResult =
        ImmutablePairDiffResult.copyOf(instance);

    // Assert
    Collection<Tuple2<Object, Object>> allIntersectionResult2 =
        actualCopyOfResult.allIntersection();
    assertTrue(allIntersectionResult2 instanceof List);
    Collection<Object> otherOnlyResult2 = actualCopyOfResult.otherOnly();
    assertTrue(otherOnlyResult2 instanceof List);
    Collection<Object> waltzOnlyResult = actualCopyOfResult.waltzOnly();
    assertTrue(waltzOnlyResult instanceof List);
    assertTrue(allIntersectionResult2.isEmpty());
    assertTrue(otherOnlyResult2.isEmpty());
    assertTrue(waltzOnlyResult.isEmpty());
    assertSame(allIntersection, allIntersectionResult2);
    assertSame(differingIntersection, actualCopyOfResult.differingIntersection());
    assertSame(otherOnly, otherOnlyResult2);
    assertSame(waltzOnly, waltzOnlyResult);
  }

  /**
   * Test {@link ImmutablePairDiffResult#equals(Object)}, and {@link
   * ImmutablePairDiffResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePairDiffResult#equals(Object)}
   *   <li>{@link ImmutablePairDiffResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePairDiffResult.equals(Object)",
    "int ImmutablePairDiffResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    Builder<Object, Object> allIntersectionResult =
        builderResult.allIntersection(new ArrayList<>());

    Builder<Object, Object> differingIntersectionResult =
        allIntersectionResult.differingIntersection(new ArrayList<>());

    Builder<Object, Object> otherOnlyResult =
        differingIntersectionResult.otherOnly(new ArrayList<>());
    ImmutablePairDiffResult<Object, Object> immutablePairDiffResult =
        otherOnlyResult.waltzOnly(new ArrayList<>()).build();

    Builder<Object, Object> builderResult2 = ImmutablePairDiffResult.builder();

    Builder<Object, Object> allIntersectionResult2 =
        builderResult2.allIntersection(new ArrayList<>());

    Builder<Object, Object> differingIntersectionResult2 =
        allIntersectionResult2.differingIntersection(new ArrayList<>());

    Builder<Object, Object> otherOnlyResult2 =
        differingIntersectionResult2.otherOnly(new ArrayList<>());
    ImmutablePairDiffResult<Object, Object> immutablePairDiffResult2 =
        otherOnlyResult2.waltzOnly(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(immutablePairDiffResult, immutablePairDiffResult2);
    assertEquals(immutablePairDiffResult.hashCode(), immutablePairDiffResult2.hashCode());
  }

  /**
   * Test {@link ImmutablePairDiffResult#equals(Object)}, and {@link
   * ImmutablePairDiffResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePairDiffResult#equals(Object)}
   *   <li>{@link ImmutablePairDiffResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePairDiffResult.equals(Object)",
    "int ImmutablePairDiffResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    Builder<Object, Object> allIntersectionResult =
        builderResult.allIntersection(new ArrayList<>());

    Builder<Object, Object> differingIntersectionResult =
        allIntersectionResult.differingIntersection(new ArrayList<>());

    Builder<Object, Object> otherOnlyResult =
        differingIntersectionResult.otherOnly(new ArrayList<>());
    ImmutablePairDiffResult<Object, Object> immutablePairDiffResult =
        otherOnlyResult.waltzOnly(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(immutablePairDiffResult, immutablePairDiffResult);
    int expectedHashCodeResult = immutablePairDiffResult.hashCode();
    assertEquals(expectedHashCodeResult, immutablePairDiffResult.hashCode());
  }

  /**
   * Test {@link ImmutablePairDiffResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePairDiffResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePairDiffResult.equals(Object)",
    "int ImmutablePairDiffResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<Tuple2<Object, Object>> allIntersection = new ArrayList<>();
    allIntersection.add(new Tuple2<>("V1", "V2"));

    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    Builder<Object, Object> allIntersectionResult = builderResult.allIntersection(allIntersection);

    Builder<Object, Object> differingIntersectionResult =
        allIntersectionResult.differingIntersection(new ArrayList<>());

    Builder<Object, Object> otherOnlyResult =
        differingIntersectionResult.otherOnly(new ArrayList<>());
    ImmutablePairDiffResult<Object, Object> immutablePairDiffResult =
        otherOnlyResult.waltzOnly(new ArrayList<>()).build();

    Builder<Object, Object> builderResult2 = ImmutablePairDiffResult.builder();

    Builder<Object, Object> allIntersectionResult2 =
        builderResult2.allIntersection(new ArrayList<>());

    Builder<Object, Object> differingIntersectionResult2 =
        allIntersectionResult2.differingIntersection(new ArrayList<>());

    Builder<Object, Object> otherOnlyResult2 =
        differingIntersectionResult2.otherOnly(new ArrayList<>());

    // Act and Assert
    assertNotEquals(immutablePairDiffResult, otherOnlyResult2.waltzOnly(new ArrayList<>()).build());
  }

  /**
   * Test {@link ImmutablePairDiffResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePairDiffResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePairDiffResult.equals(Object)",
    "int ImmutablePairDiffResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<Tuple2<Object, Object>> differingIntersection = new ArrayList<>();
    differingIntersection.add(new Tuple2<>("V1", "V2"));

    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    Builder<Object, Object> differingIntersectionResult =
        builderResult
            .allIntersection(new ArrayList<>())
            .differingIntersection(differingIntersection);

    Builder<Object, Object> otherOnlyResult =
        differingIntersectionResult.otherOnly(new ArrayList<>());
    ImmutablePairDiffResult<Object, Object> immutablePairDiffResult =
        otherOnlyResult.waltzOnly(new ArrayList<>()).build();

    Builder<Object, Object> builderResult2 = ImmutablePairDiffResult.builder();

    Builder<Object, Object> allIntersectionResult =
        builderResult2.allIntersection(new ArrayList<>());

    Builder<Object, Object> differingIntersectionResult2 =
        allIntersectionResult.differingIntersection(new ArrayList<>());

    Builder<Object, Object> otherOnlyResult2 =
        differingIntersectionResult2.otherOnly(new ArrayList<>());

    // Act and Assert
    assertNotEquals(immutablePairDiffResult, otherOnlyResult2.waltzOnly(new ArrayList<>()).build());
  }

  /**
   * Test {@link ImmutablePairDiffResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePairDiffResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePairDiffResult.equals(Object)",
    "int ImmutablePairDiffResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ArrayList<Object> otherOnly = new ArrayList<>();
    otherOnly.add("42");

    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    Builder<Object, Object> allIntersectionResult =
        builderResult.allIntersection(new ArrayList<>());

    Builder<Object, Object> otherOnlyResult =
        allIntersectionResult.differingIntersection(new ArrayList<>()).otherOnly(otherOnly);
    ImmutablePairDiffResult<Object, Object> immutablePairDiffResult =
        otherOnlyResult.waltzOnly(new ArrayList<>()).build();

    Builder<Object, Object> builderResult2 = ImmutablePairDiffResult.builder();

    Builder<Object, Object> allIntersectionResult2 =
        builderResult2.allIntersection(new ArrayList<>());

    Builder<Object, Object> differingIntersectionResult =
        allIntersectionResult2.differingIntersection(new ArrayList<>());

    Builder<Object, Object> otherOnlyResult2 =
        differingIntersectionResult.otherOnly(new ArrayList<>());

    // Act and Assert
    assertNotEquals(immutablePairDiffResult, otherOnlyResult2.waltzOnly(new ArrayList<>()).build());
  }

  /**
   * Test {@link ImmutablePairDiffResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePairDiffResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePairDiffResult.equals(Object)",
    "int ImmutablePairDiffResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ArrayList<Object> waltzOnly = new ArrayList<>();
    waltzOnly.add("42");

    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    Builder<Object, Object> allIntersectionResult =
        builderResult.allIntersection(new ArrayList<>());

    Builder<Object, Object> differingIntersectionResult =
        allIntersectionResult.differingIntersection(new ArrayList<>());
    ImmutablePairDiffResult<Object, Object> immutablePairDiffResult =
        differingIntersectionResult.otherOnly(new ArrayList<>()).waltzOnly(waltzOnly).build();

    Builder<Object, Object> builderResult2 = ImmutablePairDiffResult.builder();

    Builder<Object, Object> allIntersectionResult2 =
        builderResult2.allIntersection(new ArrayList<>());

    Builder<Object, Object> differingIntersectionResult2 =
        allIntersectionResult2.differingIntersection(new ArrayList<>());

    Builder<Object, Object> otherOnlyResult =
        differingIntersectionResult2.otherOnly(new ArrayList<>());

    // Act and Assert
    assertNotEquals(immutablePairDiffResult, otherOnlyResult.waltzOnly(new ArrayList<>()).build());
  }

  /**
   * Test {@link ImmutablePairDiffResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePairDiffResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePairDiffResult.equals(Object)",
    "int ImmutablePairDiffResult.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    Builder<Object, Object> allIntersectionResult =
        builderResult.allIntersection(new ArrayList<>());

    Builder<Object, Object> differingIntersectionResult =
        allIntersectionResult.differingIntersection(new ArrayList<>());

    Builder<Object, Object> otherOnlyResult =
        differingIntersectionResult.otherOnly(new ArrayList<>());

    // Act and Assert
    assertNotEquals(otherOnlyResult.waltzOnly(new ArrayList<>()).build(), null);
  }

  /**
   * Test {@link ImmutablePairDiffResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePairDiffResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePairDiffResult.equals(Object)",
    "int ImmutablePairDiffResult.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    Builder<Object, Object> allIntersectionResult =
        builderResult.allIntersection(new ArrayList<>());

    Builder<Object, Object> differingIntersectionResult =
        allIntersectionResult.differingIntersection(new ArrayList<>());

    Builder<Object, Object> otherOnlyResult =
        differingIntersectionResult.otherOnly(new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        otherOnlyResult.waltzOnly(new ArrayList<>()).build(),
        "Different type to ImmutablePairDiffResult");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePairDiffResult#allIntersection()}
   *   <li>{@link ImmutablePairDiffResult#differingIntersection()}
   *   <li>{@link ImmutablePairDiffResult#otherOnly()}
   *   <li>{@link ImmutablePairDiffResult#waltzOnly()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection ImmutablePairDiffResult.allIntersection()",
    "Collection ImmutablePairDiffResult.differingIntersection()",
    "Collection ImmutablePairDiffResult.otherOnly()",
    "Collection ImmutablePairDiffResult.waltzOnly()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();
    ArrayList<Tuple2<Object, Object>> allIntersection = new ArrayList<>();

    Builder<Object, Object> allIntersectionResult = builderResult.allIntersection(allIntersection);
    ArrayList<Tuple2<Object, Object>> differingIntersection = new ArrayList<>();

    Builder<Object, Object> differingIntersectionResult =
        allIntersectionResult.differingIntersection(differingIntersection);
    ArrayList<Object> otherOnly = new ArrayList<>();

    Builder<Object, Object> otherOnlyResult = differingIntersectionResult.otherOnly(otherOnly);
    ArrayList<Object> waltzOnly = new ArrayList<>();
    ImmutablePairDiffResult<Object, Object> immutablePairDiffResult =
        otherOnlyResult.waltzOnly(waltzOnly).build();

    // Act
    Collection<Tuple2<Object, Object>> actualAllIntersectionResult =
        immutablePairDiffResult.allIntersection();
    Collection<Tuple2<Object, Object>> actualDifferingIntersectionResult =
        immutablePairDiffResult.differingIntersection();
    Collection<Object> actualOtherOnlyResult = immutablePairDiffResult.otherOnly();
    Collection<Object> actualWaltzOnlyResult = immutablePairDiffResult.waltzOnly();

    // Assert
    assertTrue(actualAllIntersectionResult instanceof List);
    assertTrue(actualDifferingIntersectionResult instanceof List);
    assertTrue(actualOtherOnlyResult instanceof List);
    assertTrue(actualWaltzOnlyResult instanceof List);
    assertSame(allIntersection, actualAllIntersectionResult);
    assertSame(differingIntersection, actualDifferingIntersectionResult);
    assertSame(otherOnly, actualOtherOnlyResult);
    assertSame(waltzOnly, actualWaltzOnlyResult);
  }

  /**
   * Test {@link ImmutablePairDiffResult#withAllIntersection(Collection)}.
   *
   * <p>Method under test: {@link ImmutablePairDiffResult#withAllIntersection(Collection)}
   */
  @Test
  @DisplayName("Test withAllIntersection(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePairDiffResult ImmutablePairDiffResult.withAllIntersection(Collection)"
  })
  void testWithAllIntersection() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    Builder<Object, Object> allIntersectionResult =
        builderResult.allIntersection(new ArrayList<>());

    Builder<Object, Object> differingIntersectionResult =
        allIntersectionResult.differingIntersection(new ArrayList<>());

    Builder<Object, Object> otherOnlyResult =
        differingIntersectionResult.otherOnly(new ArrayList<>());
    ImmutablePairDiffResult<Object, Object> immutablePairDiffResult =
        otherOnlyResult.waltzOnly(new ArrayList<>()).build();

    // Act
    ImmutablePairDiffResult<Object, Object> actualWithAllIntersectionResult =
        immutablePairDiffResult.withAllIntersection(new ArrayList<>());

    // Assert
    assertEquals(immutablePairDiffResult, actualWithAllIntersectionResult);
  }

  /**
   * Test {@link ImmutablePairDiffResult#withDifferingIntersection(Collection)}.
   *
   * <p>Method under test: {@link ImmutablePairDiffResult#withDifferingIntersection(Collection)}
   */
  @Test
  @DisplayName("Test withDifferingIntersection(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePairDiffResult ImmutablePairDiffResult.withDifferingIntersection(Collection)"
  })
  void testWithDifferingIntersection() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    Builder<Object, Object> allIntersectionResult =
        builderResult.allIntersection(new ArrayList<>());

    Builder<Object, Object> differingIntersectionResult =
        allIntersectionResult.differingIntersection(new ArrayList<>());

    Builder<Object, Object> otherOnlyResult =
        differingIntersectionResult.otherOnly(new ArrayList<>());
    ImmutablePairDiffResult<Object, Object> immutablePairDiffResult =
        otherOnlyResult.waltzOnly(new ArrayList<>()).build();

    // Act
    ImmutablePairDiffResult<Object, Object> actualWithDifferingIntersectionResult =
        immutablePairDiffResult.withDifferingIntersection(new ArrayList<>());

    // Assert
    assertEquals(immutablePairDiffResult, actualWithDifferingIntersectionResult);
  }

  /**
   * Test {@link ImmutablePairDiffResult#withOtherOnly(Collection)}.
   *
   * <p>Method under test: {@link ImmutablePairDiffResult#withOtherOnly(Collection)}
   */
  @Test
  @DisplayName("Test withOtherOnly(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePairDiffResult ImmutablePairDiffResult.withOtherOnly(Collection)"})
  void testWithOtherOnly() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    Builder<Object, Object> allIntersectionResult =
        builderResult.allIntersection(new ArrayList<>());

    Builder<Object, Object> differingIntersectionResult =
        allIntersectionResult.differingIntersection(new ArrayList<>());

    Builder<Object, Object> otherOnlyResult =
        differingIntersectionResult.otherOnly(new ArrayList<>());
    ImmutablePairDiffResult<Object, Object> immutablePairDiffResult =
        otherOnlyResult.waltzOnly(new ArrayList<>()).build();

    // Act
    ImmutablePairDiffResult<Object, Object> actualWithOtherOnlyResult =
        immutablePairDiffResult.withOtherOnly(new ArrayList<>());

    // Assert
    assertEquals(immutablePairDiffResult, actualWithOtherOnlyResult);
  }

  /**
   * Test {@link ImmutablePairDiffResult#withWaltzOnly(Collection)}.
   *
   * <p>Method under test: {@link ImmutablePairDiffResult#withWaltzOnly(Collection)}
   */
  @Test
  @DisplayName("Test withWaltzOnly(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePairDiffResult ImmutablePairDiffResult.withWaltzOnly(Collection)"})
  void testWithWaltzOnly() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    Builder<Object, Object> allIntersectionResult =
        builderResult.allIntersection(new ArrayList<>());

    Builder<Object, Object> differingIntersectionResult =
        allIntersectionResult.differingIntersection(new ArrayList<>());

    Builder<Object, Object> otherOnlyResult =
        differingIntersectionResult.otherOnly(new ArrayList<>());
    ImmutablePairDiffResult<Object, Object> immutablePairDiffResult =
        otherOnlyResult.waltzOnly(new ArrayList<>()).build();

    // Act
    ImmutablePairDiffResult<Object, Object> actualWithWaltzOnlyResult =
        immutablePairDiffResult.withWaltzOnly(new ArrayList<>());

    // Assert
    assertEquals(immutablePairDiffResult, actualWithWaltzOnlyResult);
  }
}
