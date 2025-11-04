package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.Test;

class ImmutablePairDiffResultDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutablePairDiffResult.Builder#allIntersection(Collection)}
   */
  @Test
  void testBuilderAllIntersection() {
    // Arrange
    ImmutablePairDiffResult.Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.allIntersection(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutablePairDiffResult.Builder#allIntersection(Collection)}
   */
  @Test
  void testBuilderAllIntersection2() {
    // Arrange
    ImmutablePairDiffResult.Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    ArrayList<Tuple2<Object, Object>> allIntersection = new ArrayList<>();
    allIntersection.add(new Tuple2<>("V1", "V2"));

    // Act and Assert
    assertSame(builderResult, builderResult.allIntersection(allIntersection));
  }

  /**
   * Method under test:
   * {@link ImmutablePairDiffResult.Builder#allIntersection(Collection)}
   */
  @Test
  void testBuilderAllIntersection3() {
    // Arrange
    ImmutablePairDiffResult.Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    ArrayList<Tuple2<Object, Object>> allIntersection = new ArrayList<>();
    allIntersection.add(new Tuple2<>("V1", "V2"));
    allIntersection.add(new Tuple2<>("V1", "V2"));

    // Act and Assert
    assertSame(builderResult, builderResult.allIntersection(allIntersection));
  }

  /**
   * Method under test:
   * {@link ImmutablePairDiffResult.Builder#differingIntersection(Collection)}
   */
  @Test
  void testBuilderDifferingIntersection() {
    // Arrange
    ImmutablePairDiffResult.Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.differingIntersection(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutablePairDiffResult.Builder#differingIntersection(Collection)}
   */
  @Test
  void testBuilderDifferingIntersection2() {
    // Arrange
    ImmutablePairDiffResult.Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    ArrayList<Tuple2<Object, Object>> differingIntersection = new ArrayList<>();
    differingIntersection.add(new Tuple2<>("V1", "V2"));

    // Act and Assert
    assertSame(builderResult, builderResult.differingIntersection(differingIntersection));
  }

  /**
   * Method under test:
   * {@link ImmutablePairDiffResult.Builder#differingIntersection(Collection)}
   */
  @Test
  void testBuilderDifferingIntersection3() {
    // Arrange
    ImmutablePairDiffResult.Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    ArrayList<Tuple2<Object, Object>> differingIntersection = new ArrayList<>();
    differingIntersection.add(new Tuple2<>("V1", "V2"));
    differingIntersection.add(new Tuple2<>("V1", "V2"));

    // Act and Assert
    assertSame(builderResult, builderResult.differingIntersection(differingIntersection));
  }

  /**
   * Method under test:
   * {@link ImmutablePairDiffResult.Builder#from(PairDiffResult)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePairDiffResult.Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();
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
    ImmutablePairDiffResult.Builder<Object, Object> actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutablePairDiffResult.Builder#from(PairDiffResult)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePairDiffResult.Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();
    PairDiffResult<Object, Object> instance = mock(PairDiffResult.class);
    when(instance.allIntersection()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).allIntersection();
  }

  /**
   * Method under test:
   * {@link ImmutablePairDiffResult.Builder#otherOnly(Collection)}
   */
  @Test
  void testBuilderOtherOnly() {
    // Arrange
    ImmutablePairDiffResult.Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.otherOnly(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutablePairDiffResult.Builder#otherOnly(Collection)}
   */
  @Test
  void testBuilderOtherOnly2() {
    // Arrange
    ImmutablePairDiffResult.Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    ArrayList<Object> otherOnly = new ArrayList<>();
    otherOnly.add("42");

    // Act and Assert
    assertSame(builderResult, builderResult.otherOnly(otherOnly));
  }

  /**
   * Method under test:
   * {@link ImmutablePairDiffResult.Builder#otherOnly(Collection)}
   */
  @Test
  void testBuilderOtherOnly3() {
    // Arrange
    ImmutablePairDiffResult.Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    ArrayList<Object> otherOnly = new ArrayList<>();
    otherOnly.add("42");
    otherOnly.add("42");

    // Act and Assert
    assertSame(builderResult, builderResult.otherOnly(otherOnly));
  }

  /**
   * Method under test:
   * {@link ImmutablePairDiffResult.Builder#waltzOnly(Collection)}
   */
  @Test
  void testBuilderWaltzOnly() {
    // Arrange
    ImmutablePairDiffResult.Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.waltzOnly(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutablePairDiffResult.Builder#waltzOnly(Collection)}
   */
  @Test
  void testBuilderWaltzOnly2() {
    // Arrange
    ImmutablePairDiffResult.Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    ArrayList<Object> waltzOnly = new ArrayList<>();
    waltzOnly.add("42");

    // Act and Assert
    assertSame(builderResult, builderResult.waltzOnly(waltzOnly));
  }

  /**
   * Method under test:
   * {@link ImmutablePairDiffResult.Builder#waltzOnly(Collection)}
   */
  @Test
  void testBuilderWaltzOnly3() {
    // Arrange
    ImmutablePairDiffResult.Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    ArrayList<Object> waltzOnly = new ArrayList<>();
    waltzOnly.add("42");
    waltzOnly.add("42");

    // Act and Assert
    assertSame(builderResult, builderResult.waltzOnly(waltzOnly));
  }

  /**
   * Method under test: {@link ImmutablePairDiffResult#copyOf(PairDiffResult)}
   */
  @Test
  void testCopyOf() {
    // Arrange
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
    ImmutablePairDiffResult<Object, Object> actualCopyOfResult = ImmutablePairDiffResult.copyOf(instance);

    // Assert
    verify(instance).allIntersection();
    verify(instance).differingIntersection();
    verify(instance).otherOnly();
    verify(instance).waltzOnly();
    Collection<Tuple2<Object, Object>> allIntersectionResult = actualCopyOfResult.allIntersection();
    assertTrue(allIntersectionResult instanceof List);
    Collection<Tuple2<Object, Object>> differingIntersectionResult = actualCopyOfResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof List);
    Collection<Object> otherOnlyResult = actualCopyOfResult.otherOnly();
    assertTrue(otherOnlyResult instanceof List);
    Collection<Object> waltzOnlyResult = actualCopyOfResult.waltzOnly();
    assertTrue(waltzOnlyResult instanceof List);
    assertTrue(allIntersectionResult.isEmpty());
    assertTrue(differingIntersectionResult.isEmpty());
    assertTrue(otherOnlyResult.isEmpty());
    assertTrue(waltzOnlyResult.isEmpty());
    assertSame(tuple2List, allIntersectionResult);
    assertSame(tuple2List2, differingIntersectionResult);
    assertSame(objectList, otherOnlyResult);
    assertSame(objectList2, waltzOnlyResult);
  }
}
