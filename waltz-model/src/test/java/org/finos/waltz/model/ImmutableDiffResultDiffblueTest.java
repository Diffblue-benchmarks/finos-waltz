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
import org.junit.jupiter.api.Test;

class ImmutableDiffResultDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableDiffResult.Builder#differingIntersection(Collection)}
   */
  @Test
  void testBuilderDifferingIntersection() {
    // Arrange
    ImmutableDiffResult.Builder<Object> builderResult = ImmutableDiffResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.differingIntersection(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableDiffResult.Builder#differingIntersection(Collection)}
   */
  @Test
  void testBuilderDifferingIntersection2() {
    // Arrange
    ImmutableDiffResult.Builder<Object> builderResult = ImmutableDiffResult.builder();

    ArrayList<Object> differingIntersection = new ArrayList<>();
    differingIntersection.add("42");

    // Act and Assert
    assertSame(builderResult, builderResult.differingIntersection(differingIntersection));
  }

  /**
   * Method under test:
   * {@link ImmutableDiffResult.Builder#differingIntersection(Collection)}
   */
  @Test
  void testBuilderDifferingIntersection3() {
    // Arrange
    ImmutableDiffResult.Builder<Object> builderResult = ImmutableDiffResult.builder();

    ArrayList<Object> differingIntersection = new ArrayList<>();
    differingIntersection.add("42");
    differingIntersection.add("42");

    // Act and Assert
    assertSame(builderResult, builderResult.differingIntersection(differingIntersection));
  }

  /**
   * Method under test: {@link ImmutableDiffResult.Builder#from(DiffResult)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableDiffResult.Builder<Object> builderResult = ImmutableDiffResult.builder();
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
    ImmutableDiffResult.Builder<Object> actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableDiffResult.Builder#from(DiffResult)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableDiffResult.Builder<Object> builderResult = ImmutableDiffResult.builder();
    DiffResult<Object> instance = mock(DiffResult.class);
    when(instance.intersection()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).intersection();
  }

  /**
   * Method under test:
   * {@link ImmutableDiffResult.Builder#intersection(Collection)}
   */
  @Test
  void testBuilderIntersection() {
    // Arrange
    ImmutableDiffResult.Builder<Object> builderResult = ImmutableDiffResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.intersection(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableDiffResult.Builder#intersection(Collection)}
   */
  @Test
  void testBuilderIntersection2() {
    // Arrange
    ImmutableDiffResult.Builder<Object> builderResult = ImmutableDiffResult.builder();

    ArrayList<Object> intersection = new ArrayList<>();
    intersection.add("42");

    // Act and Assert
    assertSame(builderResult, builderResult.intersection(intersection));
  }

  /**
   * Method under test:
   * {@link ImmutableDiffResult.Builder#intersection(Collection)}
   */
  @Test
  void testBuilderIntersection3() {
    // Arrange
    ImmutableDiffResult.Builder<Object> builderResult = ImmutableDiffResult.builder();

    ArrayList<Object> intersection = new ArrayList<>();
    intersection.add("42");
    intersection.add("42");

    // Act and Assert
    assertSame(builderResult, builderResult.intersection(intersection));
  }

  /**
   * Method under test: {@link ImmutableDiffResult.Builder#otherOnly(Collection)}
   */
  @Test
  void testBuilderOtherOnly() {
    // Arrange
    ImmutableDiffResult.Builder<Object> builderResult = ImmutableDiffResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.otherOnly(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableDiffResult.Builder#otherOnly(Collection)}
   */
  @Test
  void testBuilderOtherOnly2() {
    // Arrange
    ImmutableDiffResult.Builder<Object> builderResult = ImmutableDiffResult.builder();

    ArrayList<Object> otherOnly = new ArrayList<>();
    otherOnly.add("42");

    // Act and Assert
    assertSame(builderResult, builderResult.otherOnly(otherOnly));
  }

  /**
   * Method under test: {@link ImmutableDiffResult.Builder#otherOnly(Collection)}
   */
  @Test
  void testBuilderOtherOnly3() {
    // Arrange
    ImmutableDiffResult.Builder<Object> builderResult = ImmutableDiffResult.builder();

    ArrayList<Object> otherOnly = new ArrayList<>();
    otherOnly.add("42");
    otherOnly.add("42");

    // Act and Assert
    assertSame(builderResult, builderResult.otherOnly(otherOnly));
  }

  /**
   * Method under test: {@link ImmutableDiffResult.Builder#waltzOnly(Collection)}
   */
  @Test
  void testBuilderWaltzOnly() {
    // Arrange
    ImmutableDiffResult.Builder<Object> builderResult = ImmutableDiffResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.waltzOnly(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableDiffResult.Builder#waltzOnly(Collection)}
   */
  @Test
  void testBuilderWaltzOnly2() {
    // Arrange
    ImmutableDiffResult.Builder<Object> builderResult = ImmutableDiffResult.builder();

    ArrayList<Object> waltzOnly = new ArrayList<>();
    waltzOnly.add("42");

    // Act and Assert
    assertSame(builderResult, builderResult.waltzOnly(waltzOnly));
  }

  /**
   * Method under test: {@link ImmutableDiffResult.Builder#waltzOnly(Collection)}
   */
  @Test
  void testBuilderWaltzOnly3() {
    // Arrange
    ImmutableDiffResult.Builder<Object> builderResult = ImmutableDiffResult.builder();

    ArrayList<Object> waltzOnly = new ArrayList<>();
    waltzOnly.add("42");
    waltzOnly.add("42");

    // Act and Assert
    assertSame(builderResult, builderResult.waltzOnly(waltzOnly));
  }

  /**
   * Method under test: {@link ImmutableDiffResult#copyOf(DiffResult)}
   */
  @Test
  void testCopyOf() {
    // Arrange
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
    ImmutableDiffResult<Object> actualCopyOfResult = ImmutableDiffResult.copyOf(instance);

    // Assert
    verify(instance).differingIntersection();
    verify(instance).intersection();
    verify(instance).otherOnly();
    verify(instance).waltzOnly();
    Collection<Object> differingIntersectionResult = actualCopyOfResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof List);
    Collection<Object> intersectionResult = actualCopyOfResult.intersection();
    assertTrue(intersectionResult instanceof List);
    Collection<Object> otherOnlyResult = actualCopyOfResult.otherOnly();
    assertTrue(otherOnlyResult instanceof List);
    Collection<Object> waltzOnlyResult = actualCopyOfResult.waltzOnly();
    assertTrue(waltzOnlyResult instanceof List);
    assertTrue(differingIntersectionResult.isEmpty());
    assertTrue(intersectionResult.isEmpty());
    assertTrue(otherOnlyResult.isEmpty());
    assertTrue(waltzOnlyResult.isEmpty());
    assertSame(objectList, differingIntersectionResult);
    assertSame(objectList2, intersectionResult);
    assertSame(objectList3, otherOnlyResult);
    assertSame(objectList4, waltzOnlyResult);
  }
}
