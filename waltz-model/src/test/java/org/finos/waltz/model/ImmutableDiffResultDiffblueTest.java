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
import org.finos.waltz.model.ImmutableDiffResult.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDiffResultDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDiffResult Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder<Object> actualBuilderResult = ImmutableDiffResult.builder();
    ArrayList<Object> differingIntersection = new ArrayList<>();
    Builder<Object> actualDifferingIntersectionResult =
        actualBuilderResult.differingIntersection(differingIntersection);
    ArrayList<Object> intersection = new ArrayList<>();
    Builder<Object> actualIntersectionResult =
        actualDifferingIntersectionResult.intersection(intersection);
    ArrayList<Object> otherOnly = new ArrayList<>();
    Builder<Object> actualOtherOnlyResult = actualIntersectionResult.otherOnly(otherOnly);
    ArrayList<Object> waltzOnly = new ArrayList<>();
    ImmutableDiffResult<Object> actualImmutableDiffResult =
        actualOtherOnlyResult.waltzOnly(waltzOnly).build();

    // Assert
    Collection<Object> differingIntersectionResult =
        actualImmutableDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof List);
    Collection<Object> intersectionResult = actualImmutableDiffResult.intersection();
    assertTrue(intersectionResult instanceof List);
    Collection<Object> otherOnlyResult = actualImmutableDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof List);
    Collection<Object> waltzOnlyResult = actualImmutableDiffResult.waltzOnly();
    assertTrue(waltzOnlyResult instanceof List);
    assertSame(differingIntersection, differingIntersectionResult);
    assertSame(intersection, intersectionResult);
    assertSame(otherOnly, otherOnlyResult);
    assertSame(waltzOnly, waltzOnlyResult);
  }

  /**
   * Test Builder {@link Builder#differingIntersection(Collection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#differingIntersection(Collection)}
   */
  @Test
  @DisplayName(
      "Test Builder differingIntersection(Collection); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.differingIntersection(Collection)"})
  void testBuilderDifferingIntersection_given42_whenArrayListAdd42() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    ArrayList<Object> differingIntersection = new ArrayList<>();
    differingIntersection.add("42");

    // Act
    Builder<Object> actualDifferingIntersectionResult =
        builderResult.differingIntersection(differingIntersection);

    // Assert
    assertSame(builderResult, actualDifferingIntersectionResult);
  }

  /**
   * Test Builder {@link Builder#differingIntersection(Collection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#differingIntersection(Collection)}
   */
  @Test
  @DisplayName(
      "Test Builder differingIntersection(Collection); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.differingIntersection(Collection)"})
  void testBuilderDifferingIntersection_given42_whenArrayListAdd422() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    ArrayList<Object> differingIntersection = new ArrayList<>();
    differingIntersection.add("42");
    differingIntersection.add("42");

    // Act
    Builder<Object> actualDifferingIntersectionResult =
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
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    // Act
    Builder<Object> actualDifferingIntersectionResult =
        builderResult.differingIntersection(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualDifferingIntersectionResult);
  }

  /**
   * Test Builder {@link Builder#from(DiffResult)}.
   *
   * <p>Method under test: {@link Builder#from(DiffResult)}
   */
  @Test
  @DisplayName("Test Builder from(DiffResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DiffResult)"})
  void testBuilderFrom() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    Builder<Object> builderResult2 = ImmutableDiffResult.builder();

    Builder<Object> differingIntersectionResult =
        builderResult2.differingIntersection(new ArrayList<>());

    Builder<Object> intersectionResult =
        differingIntersectionResult.intersection(new ArrayList<>());

    Builder<Object> otherOnlyResult = intersectionResult.otherOnly(new ArrayList<>());
    ImmutableDiffResult<Object> instance = otherOnlyResult.waltzOnly(new ArrayList<>()).build();

    // Act
    Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableDiffResult<Object> actualImmutableDiffResult = builderResult.build();
    assertEquals(instance, actualImmutableDiffResult);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#intersection(Collection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#intersection(Collection)}
   */
  @Test
  @DisplayName("Test Builder intersection(Collection); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.intersection(Collection)"})
  void testBuilderIntersection_given42_whenArrayListAdd42() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    ArrayList<Object> intersection = new ArrayList<>();
    intersection.add("42");

    // Act
    Builder<Object> actualIntersectionResult = builderResult.intersection(intersection);

    // Assert
    assertSame(builderResult, actualIntersectionResult);
  }

  /**
   * Test Builder {@link Builder#intersection(Collection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#intersection(Collection)}
   */
  @Test
  @DisplayName("Test Builder intersection(Collection); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.intersection(Collection)"})
  void testBuilderIntersection_given42_whenArrayListAdd422() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    ArrayList<Object> intersection = new ArrayList<>();
    intersection.add("42");
    intersection.add("42");

    // Act
    Builder<Object> actualIntersectionResult = builderResult.intersection(intersection);

    // Assert
    assertSame(builderResult, actualIntersectionResult);
  }

  /**
   * Test Builder {@link Builder#intersection(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#intersection(Collection)}
   */
  @Test
  @DisplayName("Test Builder intersection(Collection); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.intersection(Collection)"})
  void testBuilderIntersection_whenArrayList() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    // Act
    Builder<Object> actualIntersectionResult = builderResult.intersection(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualIntersectionResult);
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
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    ArrayList<Object> otherOnly = new ArrayList<>();
    otherOnly.add("42");

    // Act
    Builder<Object> actualOtherOnlyResult = builderResult.otherOnly(otherOnly);

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
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    ArrayList<Object> otherOnly = new ArrayList<>();
    otherOnly.add("42");
    otherOnly.add("42");

    // Act
    Builder<Object> actualOtherOnlyResult = builderResult.otherOnly(otherOnly);

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
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    // Act
    Builder<Object> actualOtherOnlyResult = builderResult.otherOnly(new ArrayList<>());

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
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    ArrayList<Object> waltzOnly = new ArrayList<>();
    waltzOnly.add("42");

    // Act
    Builder<Object> actualWaltzOnlyResult = builderResult.waltzOnly(waltzOnly);

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
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    ArrayList<Object> waltzOnly = new ArrayList<>();
    waltzOnly.add("42");
    waltzOnly.add("42");

    // Act
    Builder<Object> actualWaltzOnlyResult = builderResult.waltzOnly(waltzOnly);

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
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    // Act
    Builder<Object> actualWaltzOnlyResult = builderResult.waltzOnly(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualWaltzOnlyResult);
  }

  /**
   * Test {@link ImmutableDiffResult#copyOf(DiffResult)}.
   *
   * <ul>
   *   <li>Then differingIntersection return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiffResult#copyOf(DiffResult)}
   */
  @Test
  @DisplayName("Test copyOf(DiffResult); then differingIntersection return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDiffResult ImmutableDiffResult.copyOf(DiffResult)"})
  void testCopyOf_thenDifferingIntersectionReturnList() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();
    ArrayList<Object> differingIntersection = new ArrayList<>();

    Builder<Object> differingIntersectionResult =
        builderResult.differingIntersection(differingIntersection);
    ArrayList<Object> intersection = new ArrayList<>();

    Builder<Object> intersectionResult = differingIntersectionResult.intersection(intersection);
    ArrayList<Object> otherOnly = new ArrayList<>();

    Builder<Object> otherOnlyResult = intersectionResult.otherOnly(otherOnly);
    ArrayList<Object> waltzOnly = new ArrayList<>();
    ImmutableDiffResult<Object> instance = otherOnlyResult.waltzOnly(waltzOnly).build();

    // Act
    ImmutableDiffResult<Object> actualCopyOfResult = ImmutableDiffResult.copyOf(instance);

    // Assert
    Collection<Object> differingIntersectionResult2 = actualCopyOfResult.differingIntersection();
    assertTrue(differingIntersectionResult2 instanceof List);
    assertTrue(differingIntersectionResult2.isEmpty());
    assertSame(differingIntersection, differingIntersectionResult2);
    assertSame(intersection, actualCopyOfResult.intersection());
    assertSame(otherOnly, actualCopyOfResult.otherOnly());
    assertSame(waltzOnly, actualCopyOfResult.waltzOnly());
  }

  /**
   * Test {@link ImmutableDiffResult#equals(Object)}, and {@link ImmutableDiffResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDiffResult#equals(Object)}
   *   <li>{@link ImmutableDiffResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDiffResult.equals(Object)",
    "int ImmutableDiffResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    Builder<Object> differingIntersectionResult =
        builderResult.differingIntersection(new ArrayList<>());

    Builder<Object> intersectionResult =
        differingIntersectionResult.intersection(new ArrayList<>());

    Builder<Object> otherOnlyResult = intersectionResult.otherOnly(new ArrayList<>());
    ImmutableDiffResult<Object> immutableDiffResult =
        otherOnlyResult.waltzOnly(new ArrayList<>()).build();

    Builder<Object> builderResult2 = ImmutableDiffResult.builder();

    Builder<Object> differingIntersectionResult2 =
        builderResult2.differingIntersection(new ArrayList<>());

    Builder<Object> intersectionResult2 =
        differingIntersectionResult2.intersection(new ArrayList<>());

    Builder<Object> otherOnlyResult2 = intersectionResult2.otherOnly(new ArrayList<>());
    ImmutableDiffResult<Object> immutableDiffResult2 =
        otherOnlyResult2.waltzOnly(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(immutableDiffResult, immutableDiffResult2);
    assertEquals(immutableDiffResult.hashCode(), immutableDiffResult2.hashCode());
  }

  /**
   * Test {@link ImmutableDiffResult#equals(Object)}, and {@link ImmutableDiffResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDiffResult#equals(Object)}
   *   <li>{@link ImmutableDiffResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDiffResult.equals(Object)",
    "int ImmutableDiffResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    Builder<Object> differingIntersectionResult =
        builderResult.differingIntersection(new ArrayList<>());

    Builder<Object> intersectionResult =
        differingIntersectionResult.intersection(new ArrayList<>());

    Builder<Object> otherOnlyResult = intersectionResult.otherOnly(new ArrayList<>());
    ImmutableDiffResult<Object> immutableDiffResult =
        otherOnlyResult.waltzOnly(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(immutableDiffResult, immutableDiffResult);
    int expectedHashCodeResult = immutableDiffResult.hashCode();
    assertEquals(expectedHashCodeResult, immutableDiffResult.hashCode());
  }

  /**
   * Test {@link ImmutableDiffResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiffResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDiffResult.equals(Object)",
    "int ImmutableDiffResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<Object> differingIntersection = new ArrayList<>();
    differingIntersection.add("42");

    Builder<Object> builderResult = ImmutableDiffResult.builder();

    Builder<Object> differingIntersectionResult =
        builderResult.differingIntersection(differingIntersection);

    Builder<Object> intersectionResult =
        differingIntersectionResult.intersection(new ArrayList<>());

    Builder<Object> otherOnlyResult = intersectionResult.otherOnly(new ArrayList<>());
    ImmutableDiffResult<Object> immutableDiffResult =
        otherOnlyResult.waltzOnly(new ArrayList<>()).build();

    Builder<Object> builderResult2 = ImmutableDiffResult.builder();

    Builder<Object> differingIntersectionResult2 =
        builderResult2.differingIntersection(new ArrayList<>());

    Builder<Object> intersectionResult2 =
        differingIntersectionResult2.intersection(new ArrayList<>());

    Builder<Object> otherOnlyResult2 = intersectionResult2.otherOnly(new ArrayList<>());

    // Act and Assert
    assertNotEquals(immutableDiffResult, otherOnlyResult2.waltzOnly(new ArrayList<>()).build());
  }

  /**
   * Test {@link ImmutableDiffResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiffResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDiffResult.equals(Object)",
    "int ImmutableDiffResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<Object> intersection = new ArrayList<>();
    intersection.add("42");

    Builder<Object> builderResult = ImmutableDiffResult.builder();

    Builder<Object> intersectionResult =
        builderResult.differingIntersection(new ArrayList<>()).intersection(intersection);

    Builder<Object> otherOnlyResult = intersectionResult.otherOnly(new ArrayList<>());
    ImmutableDiffResult<Object> immutableDiffResult =
        otherOnlyResult.waltzOnly(new ArrayList<>()).build();

    Builder<Object> builderResult2 = ImmutableDiffResult.builder();

    Builder<Object> differingIntersectionResult =
        builderResult2.differingIntersection(new ArrayList<>());

    Builder<Object> intersectionResult2 =
        differingIntersectionResult.intersection(new ArrayList<>());

    Builder<Object> otherOnlyResult2 = intersectionResult2.otherOnly(new ArrayList<>());

    // Act and Assert
    assertNotEquals(immutableDiffResult, otherOnlyResult2.waltzOnly(new ArrayList<>()).build());
  }

  /**
   * Test {@link ImmutableDiffResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiffResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDiffResult.equals(Object)",
    "int ImmutableDiffResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ArrayList<Object> otherOnly = new ArrayList<>();
    otherOnly.add("42");

    Builder<Object> builderResult = ImmutableDiffResult.builder();

    Builder<Object> differingIntersectionResult =
        builderResult.differingIntersection(new ArrayList<>());

    Builder<Object> otherOnlyResult =
        differingIntersectionResult.intersection(new ArrayList<>()).otherOnly(otherOnly);
    ImmutableDiffResult<Object> immutableDiffResult =
        otherOnlyResult.waltzOnly(new ArrayList<>()).build();

    Builder<Object> builderResult2 = ImmutableDiffResult.builder();

    Builder<Object> differingIntersectionResult2 =
        builderResult2.differingIntersection(new ArrayList<>());

    Builder<Object> intersectionResult =
        differingIntersectionResult2.intersection(new ArrayList<>());

    Builder<Object> otherOnlyResult2 = intersectionResult.otherOnly(new ArrayList<>());

    // Act and Assert
    assertNotEquals(immutableDiffResult, otherOnlyResult2.waltzOnly(new ArrayList<>()).build());
  }

  /**
   * Test {@link ImmutableDiffResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiffResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDiffResult.equals(Object)",
    "int ImmutableDiffResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ArrayList<Object> waltzOnly = new ArrayList<>();
    waltzOnly.add("42");

    Builder<Object> builderResult = ImmutableDiffResult.builder();

    Builder<Object> differingIntersectionResult =
        builderResult.differingIntersection(new ArrayList<>());

    Builder<Object> intersectionResult =
        differingIntersectionResult.intersection(new ArrayList<>());
    ImmutableDiffResult<Object> immutableDiffResult =
        intersectionResult.otherOnly(new ArrayList<>()).waltzOnly(waltzOnly).build();

    Builder<Object> builderResult2 = ImmutableDiffResult.builder();

    Builder<Object> differingIntersectionResult2 =
        builderResult2.differingIntersection(new ArrayList<>());

    Builder<Object> intersectionResult2 =
        differingIntersectionResult2.intersection(new ArrayList<>());

    Builder<Object> otherOnlyResult = intersectionResult2.otherOnly(new ArrayList<>());

    // Act and Assert
    assertNotEquals(immutableDiffResult, otherOnlyResult.waltzOnly(new ArrayList<>()).build());
  }

  /**
   * Test {@link ImmutableDiffResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiffResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDiffResult.equals(Object)",
    "int ImmutableDiffResult.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    Builder<Object> differingIntersectionResult =
        builderResult.differingIntersection(new ArrayList<>());

    Builder<Object> intersectionResult =
        differingIntersectionResult.intersection(new ArrayList<>());

    Builder<Object> otherOnlyResult = intersectionResult.otherOnly(new ArrayList<>());

    // Act and Assert
    assertNotEquals(otherOnlyResult.waltzOnly(new ArrayList<>()).build(), null);
  }

  /**
   * Test {@link ImmutableDiffResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiffResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDiffResult.equals(Object)",
    "int ImmutableDiffResult.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    Builder<Object> differingIntersectionResult =
        builderResult.differingIntersection(new ArrayList<>());

    Builder<Object> intersectionResult =
        differingIntersectionResult.intersection(new ArrayList<>());

    Builder<Object> otherOnlyResult = intersectionResult.otherOnly(new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        otherOnlyResult.waltzOnly(new ArrayList<>()).build(),
        "Different type to ImmutableDiffResult");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDiffResult#differingIntersection()}
   *   <li>{@link ImmutableDiffResult#intersection()}
   *   <li>{@link ImmutableDiffResult#otherOnly()}
   *   <li>{@link ImmutableDiffResult#waltzOnly()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection ImmutableDiffResult.differingIntersection()",
    "Collection ImmutableDiffResult.intersection()",
    "Collection ImmutableDiffResult.otherOnly()",
    "Collection ImmutableDiffResult.waltzOnly()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();
    ArrayList<Object> differingIntersection = new ArrayList<>();

    Builder<Object> differingIntersectionResult =
        builderResult.differingIntersection(differingIntersection);
    ArrayList<Object> intersection = new ArrayList<>();

    Builder<Object> intersectionResult = differingIntersectionResult.intersection(intersection);
    ArrayList<Object> otherOnly = new ArrayList<>();

    Builder<Object> otherOnlyResult = intersectionResult.otherOnly(otherOnly);
    ArrayList<Object> waltzOnly = new ArrayList<>();
    ImmutableDiffResult<Object> immutableDiffResult = otherOnlyResult.waltzOnly(waltzOnly).build();

    // Act
    Collection<Object> actualDifferingIntersectionResult =
        immutableDiffResult.differingIntersection();
    Collection<Object> actualIntersectionResult = immutableDiffResult.intersection();
    Collection<Object> actualOtherOnlyResult = immutableDiffResult.otherOnly();
    Collection<Object> actualWaltzOnlyResult = immutableDiffResult.waltzOnly();

    // Assert
    assertTrue(actualDifferingIntersectionResult instanceof List);
    assertTrue(actualIntersectionResult instanceof List);
    assertTrue(actualOtherOnlyResult instanceof List);
    assertTrue(actualWaltzOnlyResult instanceof List);
    assertSame(differingIntersection, actualDifferingIntersectionResult);
    assertSame(intersection, actualIntersectionResult);
    assertSame(otherOnly, actualOtherOnlyResult);
    assertSame(waltzOnly, actualWaltzOnlyResult);
  }

  /**
   * Test {@link ImmutableDiffResult#withDifferingIntersection(Collection)}.
   *
   * <p>Method under test: {@link ImmutableDiffResult#withDifferingIntersection(Collection)}
   */
  @Test
  @DisplayName("Test withDifferingIntersection(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDiffResult ImmutableDiffResult.withDifferingIntersection(Collection)"
  })
  void testWithDifferingIntersection() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    Builder<Object> differingIntersectionResult =
        builderResult.differingIntersection(new ArrayList<>());

    Builder<Object> intersectionResult =
        differingIntersectionResult.intersection(new ArrayList<>());

    Builder<Object> otherOnlyResult = intersectionResult.otherOnly(new ArrayList<>());
    ImmutableDiffResult<Object> immutableDiffResult =
        otherOnlyResult.waltzOnly(new ArrayList<>()).build();

    // Act
    ImmutableDiffResult<Object> actualWithDifferingIntersectionResult =
        immutableDiffResult.withDifferingIntersection(new ArrayList<>());

    // Assert
    assertEquals(immutableDiffResult, actualWithDifferingIntersectionResult);
  }

  /**
   * Test {@link ImmutableDiffResult#withIntersection(Collection)}.
   *
   * <p>Method under test: {@link ImmutableDiffResult#withIntersection(Collection)}
   */
  @Test
  @DisplayName("Test withIntersection(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDiffResult ImmutableDiffResult.withIntersection(Collection)"})
  void testWithIntersection() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    Builder<Object> differingIntersectionResult =
        builderResult.differingIntersection(new ArrayList<>());

    Builder<Object> intersectionResult =
        differingIntersectionResult.intersection(new ArrayList<>());

    Builder<Object> otherOnlyResult = intersectionResult.otherOnly(new ArrayList<>());
    ImmutableDiffResult<Object> immutableDiffResult =
        otherOnlyResult.waltzOnly(new ArrayList<>()).build();

    // Act
    ImmutableDiffResult<Object> actualWithIntersectionResult =
        immutableDiffResult.withIntersection(new ArrayList<>());

    // Assert
    assertEquals(immutableDiffResult, actualWithIntersectionResult);
  }

  /**
   * Test {@link ImmutableDiffResult#withOtherOnly(Collection)}.
   *
   * <p>Method under test: {@link ImmutableDiffResult#withOtherOnly(Collection)}
   */
  @Test
  @DisplayName("Test withOtherOnly(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDiffResult ImmutableDiffResult.withOtherOnly(Collection)"})
  void testWithOtherOnly() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    Builder<Object> differingIntersectionResult =
        builderResult.differingIntersection(new ArrayList<>());

    Builder<Object> intersectionResult =
        differingIntersectionResult.intersection(new ArrayList<>());

    Builder<Object> otherOnlyResult = intersectionResult.otherOnly(new ArrayList<>());
    ImmutableDiffResult<Object> immutableDiffResult =
        otherOnlyResult.waltzOnly(new ArrayList<>()).build();

    // Act
    ImmutableDiffResult<Object> actualWithOtherOnlyResult =
        immutableDiffResult.withOtherOnly(new ArrayList<>());

    // Assert
    assertEquals(immutableDiffResult, actualWithOtherOnlyResult);
  }

  /**
   * Test {@link ImmutableDiffResult#withWaltzOnly(Collection)}.
   *
   * <p>Method under test: {@link ImmutableDiffResult#withWaltzOnly(Collection)}
   */
  @Test
  @DisplayName("Test withWaltzOnly(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDiffResult ImmutableDiffResult.withWaltzOnly(Collection)"})
  void testWithWaltzOnly() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    Builder<Object> differingIntersectionResult =
        builderResult.differingIntersection(new ArrayList<>());

    Builder<Object> intersectionResult =
        differingIntersectionResult.intersection(new ArrayList<>());

    Builder<Object> otherOnlyResult = intersectionResult.otherOnly(new ArrayList<>());
    ImmutableDiffResult<Object> immutableDiffResult =
        otherOnlyResult.waltzOnly(new ArrayList<>()).build();

    // Act
    ImmutableDiffResult<Object> actualWithWaltzOnlyResult =
        immutableDiffResult.withWaltzOnly(new ArrayList<>());

    // Assert
    assertEquals(immutableDiffResult, actualWithWaltzOnlyResult);
  }
}
