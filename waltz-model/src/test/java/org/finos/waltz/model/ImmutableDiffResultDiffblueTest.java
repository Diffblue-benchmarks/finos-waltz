package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import org.finos.waltz.model.ImmutableDiffResult.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDiffResultDiffblueTest {
  /**
   * Test Builder {@link Builder#differingIntersection(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#differingIntersection(Collection)}
   */
  @Test
  @DisplayName("Test Builder differingIntersection(Collection); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.differingIntersection(Collection)"})
  void testBuilderDifferingIntersection_given42_whenArrayListAdd42() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    ArrayList<Object> differingIntersection = new ArrayList<>();
    differingIntersection.add("42");

    // Act and Assert
    assertSame(builderResult, builderResult.differingIntersection(differingIntersection));
  }

  /**
   * Test Builder {@link Builder#differingIntersection(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#differingIntersection(Collection)}
   */
  @Test
  @DisplayName("Test Builder differingIntersection(Collection); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.differingIntersection(Collection)"})
  void testBuilderDifferingIntersection_given42_whenArrayListAdd422() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    ArrayList<Object> differingIntersection = new ArrayList<>();
    differingIntersection.add("42");
    differingIntersection.add("42");

    // Act and Assert
    assertSame(builderResult, builderResult.differingIntersection(differingIntersection));
  }

  /**
   * Test Builder {@link Builder#differingIntersection(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#differingIntersection(Collection)}
   */
  @Test
  @DisplayName("Test Builder differingIntersection(Collection); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.differingIntersection(Collection)"})
  void testBuilderDifferingIntersection_whenArrayList() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.differingIntersection(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(DiffResult)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then builder build differingIntersection is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DiffResult)}
   */
  @Test
  @DisplayName("Test Builder from(DiffResult); given ArrayList(); then builder build differingIntersection is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DiffResult)"})
  void testBuilderFrom_givenArrayList_thenBuilderBuildDifferingIntersectionIsArrayList() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();
    DiffResult<Object> instance = mock(DiffResult.class);
    ArrayList<Object> objectList = new ArrayList<>();
    when(instance.differingIntersection()).thenReturn(objectList);
    ArrayList<Object> objectList2 = new ArrayList<>();
    when(instance.intersection()).thenReturn(objectList2);
    ArrayList<Object> objectList3 = new ArrayList<>();
    when(instance.otherOnly()).thenReturn(objectList3);
    ArrayList<Object> objectList4 = new ArrayList<>();
    when(instance.waltzOnly()).thenReturn(objectList4);

    // Act
    Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).differingIntersection();
    verify(instance).intersection();
    verify(instance).otherOnly();
    verify(instance).waltzOnly();
    ImmutableDiffResult<Object> buildResult = builderResult.build();
    assertSame(objectList, buildResult.differingIntersection());
    assertSame(objectList2, buildResult.intersection());
    assertSame(objectList3, buildResult.otherOnly());
    assertSame(objectList4, buildResult.waltzOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DiffResult)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DiffResult)}
   */
  @Test
  @DisplayName("Test Builder from(DiffResult); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DiffResult)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();
    DiffResult<Object> instance = mock(DiffResult.class);
    when(instance.intersection()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).intersection();
  }

  /**
   * Test Builder {@link Builder#intersection(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#intersection(Collection)}
   */
  @Test
  @DisplayName("Test Builder intersection(Collection); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.intersection(Collection)"})
  void testBuilderIntersection_given42_whenArrayListAdd42() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    ArrayList<Object> intersection = new ArrayList<>();
    intersection.add("42");

    // Act and Assert
    assertSame(builderResult, builderResult.intersection(intersection));
  }

  /**
   * Test Builder {@link Builder#intersection(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#intersection(Collection)}
   */
  @Test
  @DisplayName("Test Builder intersection(Collection); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.intersection(Collection)"})
  void testBuilderIntersection_given42_whenArrayListAdd422() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    ArrayList<Object> intersection = new ArrayList<>();
    intersection.add("42");
    intersection.add("42");

    // Act and Assert
    assertSame(builderResult, builderResult.intersection(intersection));
  }

  /**
   * Test Builder {@link Builder#intersection(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#intersection(Collection)}
   */
  @Test
  @DisplayName("Test Builder intersection(Collection); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.intersection(Collection)"})
  void testBuilderIntersection_whenArrayList() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.intersection(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#otherOnly(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#otherOnly(Collection)}
   */
  @Test
  @DisplayName("Test Builder otherOnly(Collection); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.otherOnly(Collection)"})
  void testBuilderOtherOnly_given42_whenArrayListAdd42() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    ArrayList<Object> otherOnly = new ArrayList<>();
    otherOnly.add("42");

    // Act and Assert
    assertSame(builderResult, builderResult.otherOnly(otherOnly));
  }

  /**
   * Test Builder {@link Builder#otherOnly(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#otherOnly(Collection)}
   */
  @Test
  @DisplayName("Test Builder otherOnly(Collection); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.otherOnly(Collection)"})
  void testBuilderOtherOnly_given42_whenArrayListAdd422() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    ArrayList<Object> otherOnly = new ArrayList<>();
    otherOnly.add("42");
    otherOnly.add("42");

    // Act and Assert
    assertSame(builderResult, builderResult.otherOnly(otherOnly));
  }

  /**
   * Test Builder {@link Builder#otherOnly(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#otherOnly(Collection)}
   */
  @Test
  @DisplayName("Test Builder otherOnly(Collection); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.otherOnly(Collection)"})
  void testBuilderOtherOnly_whenArrayList() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.otherOnly(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#waltzOnly(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#waltzOnly(Collection)}
   */
  @Test
  @DisplayName("Test Builder waltzOnly(Collection); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.waltzOnly(Collection)"})
  void testBuilderWaltzOnly_given42_whenArrayListAdd42() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    ArrayList<Object> waltzOnly = new ArrayList<>();
    waltzOnly.add("42");

    // Act and Assert
    assertSame(builderResult, builderResult.waltzOnly(waltzOnly));
  }

  /**
   * Test Builder {@link Builder#waltzOnly(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#waltzOnly(Collection)}
   */
  @Test
  @DisplayName("Test Builder waltzOnly(Collection); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.waltzOnly(Collection)"})
  void testBuilderWaltzOnly_given42_whenArrayListAdd422() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    ArrayList<Object> waltzOnly = new ArrayList<>();
    waltzOnly.add("42");
    waltzOnly.add("42");

    // Act and Assert
    assertSame(builderResult, builderResult.waltzOnly(waltzOnly));
  }

  /**
   * Test Builder {@link Builder#waltzOnly(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#waltzOnly(Collection)}
   */
  @Test
  @DisplayName("Test Builder waltzOnly(Collection); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.waltzOnly(Collection)"})
  void testBuilderWaltzOnly_whenArrayList() {
    // Arrange
    Builder<Object> builderResult = ImmutableDiffResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.waltzOnly(new ArrayList<>()));
  }
}
