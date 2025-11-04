package org.finos.waltz.model.allocation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.Operation;
import org.junit.jupiter.api.Test;

class ImmutableMeasurablePercentageChangeDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableMeasurablePercentageChange.Builder#from(MeasurablePercentageChange)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurablePercentageChange.Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    MeasurablePercentageChange instance = mock(MeasurablePercentageChange.class);
    Optional<Integer> ofResult = Optional.<Integer>of(1);
    when(instance.previousPercentage()).thenReturn(ofResult);
    ImmutableMeasurableRatingPercentage.Json json = new ImmutableMeasurableRatingPercentage.Json();
    when(instance.measurablePercentage()).thenReturn(json);
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act
    ImmutableMeasurablePercentageChange.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).measurablePercentage();
    verify(instance).operation();
    verify(instance).previousPercentage();
    ImmutableMeasurablePercentageChange buildResult = builderResult.build();
    assertEquals(Operation.ADD, buildResult.operation());
    assertSame(json, buildResult.measurablePercentage());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurablePercentageChange.Builder#from(MeasurablePercentageChange)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMeasurablePercentageChange.Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    MeasurablePercentageChange instance = mock(MeasurablePercentageChange.class);
    when(instance.previousPercentage()).thenThrow(new IllegalStateException("instance"));
    when(instance.measurablePercentage()).thenReturn(new ImmutableMeasurableRatingPercentage.Json());
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).measurablePercentage();
    verify(instance).operation();
    verify(instance).previousPercentage();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurablePercentageChange.Builder#from(MeasurablePercentageChange)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableMeasurablePercentageChange.Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    MeasurablePercentageChange instance = mock(MeasurablePercentageChange.class);
    Optional<Integer> emptyResult = Optional.empty();
    when(instance.previousPercentage()).thenReturn(emptyResult);
    ImmutableMeasurableRatingPercentage.Json json = new ImmutableMeasurableRatingPercentage.Json();
    when(instance.measurablePercentage()).thenReturn(json);
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act
    ImmutableMeasurablePercentageChange.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).measurablePercentage();
    verify(instance).operation();
    verify(instance).previousPercentage();
    ImmutableMeasurablePercentageChange buildResult = builderResult.build();
    assertEquals(Operation.ADD, buildResult.operation());
    assertSame(json, buildResult.measurablePercentage());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurablePercentageChange.Builder#measurablePercentage(MeasurableRatingPercentage)}
   */
  @Test
  void testBuilderMeasurablePercentage() {
    // Arrange
    ImmutableMeasurablePercentageChange.Builder builderResult = ImmutableMeasurablePercentageChange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurablePercentage(new ImmutableMeasurableRatingPercentage.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurablePercentageChange.Builder#operation(Operation)}
   */
  @Test
  void testBuilderOperation() {
    // Arrange
    ImmutableMeasurablePercentageChange.Builder builderResult = ImmutableMeasurablePercentageChange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operation(Operation.ADD));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurablePercentageChange.Builder#previousPercentage(int)}
   */
  @Test
  void testBuilderPreviousPercentage() {
    // Arrange
    ImmutableMeasurablePercentageChange.Builder builderResult = ImmutableMeasurablePercentageChange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.previousPercentage(1));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurablePercentageChange.Builder#previousPercentage(Optional)}
   */
  @Test
  void testBuilderPreviousPercentage2() {
    // Arrange
    ImmutableMeasurablePercentageChange.Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    Optional<Integer> previousPercentage = Optional.<Integer>of(1);

    // Act and Assert
    assertSame(builderResult, builderResult.previousPercentage(previousPercentage));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurablePercentageChange#copyOf(MeasurablePercentageChange)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MeasurablePercentageChange instance = mock(MeasurablePercentageChange.class);
    Optional<Integer> ofResult = Optional.<Integer>of(1);
    when(instance.previousPercentage()).thenReturn(ofResult);
    ImmutableMeasurableRatingPercentage.Json json = new ImmutableMeasurableRatingPercentage.Json();
    when(instance.measurablePercentage()).thenReturn(json);
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act
    ImmutableMeasurablePercentageChange actualCopyOfResult = ImmutableMeasurablePercentageChange.copyOf(instance);

    // Assert
    verify(instance).measurablePercentage();
    verify(instance).operation();
    verify(instance).previousPercentage();
    assertEquals(Operation.ADD, actualCopyOfResult.operation());
    assertSame(json, actualCopyOfResult.measurablePercentage());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurablePercentageChange#copyOf(MeasurablePercentageChange)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    MeasurablePercentageChange instance = mock(MeasurablePercentageChange.class);
    Optional<Integer> emptyResult = Optional.empty();
    when(instance.previousPercentage()).thenReturn(emptyResult);
    ImmutableMeasurableRatingPercentage.Json json = new ImmutableMeasurableRatingPercentage.Json();
    when(instance.measurablePercentage()).thenReturn(json);
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act
    ImmutableMeasurablePercentageChange actualCopyOfResult = ImmutableMeasurablePercentageChange.copyOf(instance);

    // Assert
    verify(instance).measurablePercentage();
    verify(instance).operation();
    verify(instance).previousPercentage();
    assertEquals(Operation.ADD, actualCopyOfResult.operation());
    assertSame(json, actualCopyOfResult.measurablePercentage());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurablePercentageChange#fromJson(ImmutableMeasurablePercentageChange.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableMeasurablePercentageChange.Json json = new ImmutableMeasurablePercentageChange.Json();
    json.setOperation(Operation.ADD);
    ImmutableMeasurableRatingPercentage.Json measurablePercentage = new ImmutableMeasurableRatingPercentage.Json();
    json.setMeasurablePercentage(measurablePercentage);
    json.setPreviousPercentage(null);

    // Act
    ImmutableMeasurablePercentageChange actualFromJsonResult = ImmutableMeasurablePercentageChange.fromJson(json);

    // Assert
    assertEquals(Operation.ADD, actualFromJsonResult.operation());
    assertSame(measurablePercentage, actualFromJsonResult.measurablePercentage());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurablePercentageChange.Json#measurablePercentage()}
   */
  @Test
  void testJsonMeasurablePercentage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurablePercentageChange.Json()).measurablePercentage());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableMeasurablePercentageChange.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableMeasurablePercentageChange.Json actualJson = new ImmutableMeasurablePercentageChange.Json();

    // Assert
    assertNull(actualJson.operation);
    assertNull(actualJson.measurablePercentage);
    assertFalse(actualJson.previousPercentage.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurablePercentageChange.Json#operation()}
   */
  @Test
  void testJsonOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurablePercentageChange.Json()).operation());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurablePercentageChange.Json#previousPercentage()}
   */
  @Test
  void testJsonPreviousPercentage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurablePercentageChange.Json()).previousPercentage());
  }
}
