package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import org.finos.waltz.model.ImmutablePairDiffResult.Builder;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePairDiffResultDiffblueTest {
  /**
   * Test Builder {@link Builder#allIntersection(Collection)}.
   * <ul>
   *   <li>Given {@link Tuple2#Tuple2(Object, Object)} with {@code V1} and {@code V2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#allIntersection(Collection)}
   */
  @Test
  @DisplayName("Test Builder allIntersection(Collection); given Tuple2(Object, Object) with 'V1' and 'V2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.allIntersection(Collection)"})
  void testBuilderAllIntersection_givenTuple2WithV1AndV2() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    ArrayList<Tuple2<Object, Object>> allIntersection = new ArrayList<>();
    allIntersection.add(new Tuple2<>("V1", "V2"));

    // Act and Assert
    assertSame(builderResult, builderResult.allIntersection(allIntersection));
  }

  /**
   * Test Builder {@link Builder#allIntersection(Collection)}.
   * <ul>
   *   <li>Given {@link Tuple2#Tuple2(Object, Object)} with {@code V1} and {@code V2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#allIntersection(Collection)}
   */
  @Test
  @DisplayName("Test Builder allIntersection(Collection); given Tuple2(Object, Object) with 'V1' and 'V2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.allIntersection(Collection)"})
  void testBuilderAllIntersection_givenTuple2WithV1AndV22() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    ArrayList<Tuple2<Object, Object>> allIntersection = new ArrayList<>();
    allIntersection.add(new Tuple2<>("V1", "V2"));
    allIntersection.add(new Tuple2<>("V1", "V2"));

    // Act and Assert
    assertSame(builderResult, builderResult.allIntersection(allIntersection));
  }

  /**
   * Test Builder {@link Builder#allIntersection(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#allIntersection(Collection)}
   */
  @Test
  @DisplayName("Test Builder allIntersection(Collection); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.allIntersection(Collection)"})
  void testBuilderAllIntersection_whenArrayList() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.allIntersection(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#differingIntersection(Collection)}.
   * <ul>
   *   <li>Given {@link Tuple2#Tuple2(Object, Object)} with {@code V1} and {@code V2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#differingIntersection(Collection)}
   */
  @Test
  @DisplayName("Test Builder differingIntersection(Collection); given Tuple2(Object, Object) with 'V1' and 'V2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.differingIntersection(Collection)"})
  void testBuilderDifferingIntersection_givenTuple2WithV1AndV2() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    ArrayList<Tuple2<Object, Object>> differingIntersection = new ArrayList<>();
    differingIntersection.add(new Tuple2<>("V1", "V2"));

    // Act and Assert
    assertSame(builderResult, builderResult.differingIntersection(differingIntersection));
  }

  /**
   * Test Builder {@link Builder#differingIntersection(Collection)}.
   * <ul>
   *   <li>Given {@link Tuple2#Tuple2(Object, Object)} with {@code V1} and {@code V2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#differingIntersection(Collection)}
   */
  @Test
  @DisplayName("Test Builder differingIntersection(Collection); given Tuple2(Object, Object) with 'V1' and 'V2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.differingIntersection(Collection)"})
  void testBuilderDifferingIntersection_givenTuple2WithV1AndV22() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    ArrayList<Tuple2<Object, Object>> differingIntersection = new ArrayList<>();
    differingIntersection.add(new Tuple2<>("V1", "V2"));
    differingIntersection.add(new Tuple2<>("V1", "V2"));

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
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.differingIntersection(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(PairDiffResult)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then builder build allIntersection is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PairDiffResult)}
   */
  @Test
  @DisplayName("Test Builder from(PairDiffResult); given ArrayList(); then builder build allIntersection is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PairDiffResult)"})
  void testBuilderFrom_givenArrayList_thenBuilderBuildAllIntersectionIsArrayList() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();
    PairDiffResult<Object, Object> instance = mock(PairDiffResult.class);
    ArrayList<Tuple2<Object, Object>> tuple2List = new ArrayList<>();
    when(instance.allIntersection()).thenReturn(tuple2List);
    ArrayList<Tuple2<Object, Object>> tuple2List2 = new ArrayList<>();
    when(instance.differingIntersection()).thenReturn(tuple2List2);
    ArrayList<Object> objectList = new ArrayList<>();
    when(instance.otherOnly()).thenReturn(objectList);
    ArrayList<Object> objectList2 = new ArrayList<>();
    when(instance.waltzOnly()).thenReturn(objectList2);

    // Act
    Builder<Object, Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allIntersection();
    verify(instance).differingIntersection();
    verify(instance).otherOnly();
    verify(instance).waltzOnly();
    ImmutablePairDiffResult<Object, Object> buildResult = builderResult.build();
    assertSame(tuple2List, buildResult.allIntersection());
    assertSame(tuple2List2, buildResult.differingIntersection());
    assertSame(objectList, buildResult.otherOnly());
    assertSame(objectList2, buildResult.waltzOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PairDiffResult)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PairDiffResult)}
   */
  @Test
  @DisplayName("Test Builder from(PairDiffResult); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PairDiffResult)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();
    PairDiffResult<Object, Object> instance = mock(PairDiffResult.class);
    when(instance.allIntersection()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).allIntersection();
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
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

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
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

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
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

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
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

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
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

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
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.waltzOnly(new ArrayList<>()));
  }
}
