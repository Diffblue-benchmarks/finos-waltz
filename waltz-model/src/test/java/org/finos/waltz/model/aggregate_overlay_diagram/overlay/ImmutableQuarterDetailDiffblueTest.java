package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.Quarter;
import org.junit.jupiter.api.Test;

class ImmutableQuarterDetailDiffblueTest {
  /**
   * Method under test: {@link ImmutableQuarterDetail.Builder#from(QuarterDetail)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableQuarterDetail.Builder builderResult = ImmutableQuarterDetail.builder();
    QuarterDetail instance = mock(QuarterDetail.class);
    when(instance.quarter()).thenReturn(1);
    when(instance.year()).thenReturn(1);

    // Act
    ImmutableQuarterDetail.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).quarter();
    verify(instance).year();
    ImmutableQuarterDetail buildResult = builderResult.build();
    assertEquals(1, buildResult.quarter());
    assertEquals(1, buildResult.year());
    assertEquals(Quarter.Q1, buildResult.quarterName());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableQuarterDetail.Builder#quarter(int)}
   */
  @Test
  void testBuilderQuarter() {
    // Arrange
    ImmutableQuarterDetail.Builder builderResult = ImmutableQuarterDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.quarter(1));
  }

  /**
   * Method under test: {@link ImmutableQuarterDetail.Builder#year(int)}
   */
  @Test
  void testBuilderYear() {
    // Arrange
    ImmutableQuarterDetail.Builder builderResult = ImmutableQuarterDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.year(1));
  }

  /**
   * Method under test: {@link ImmutableQuarterDetail#copyOf(QuarterDetail)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    QuarterDetail instance = mock(QuarterDetail.class);
    when(instance.quarter()).thenReturn(1);
    when(instance.year()).thenReturn(1);

    // Act
    ImmutableQuarterDetail actualCopyOfResult = ImmutableQuarterDetail.copyOf(instance);

    // Assert
    verify(instance).quarter();
    verify(instance).year();
    assertEquals(1, actualCopyOfResult.quarter());
    assertEquals(1, actualCopyOfResult.year());
    assertEquals(Quarter.Q1, actualCopyOfResult.quarterName());
  }

  /**
   * Method under test: {@link ImmutableQuarterDetail#copyOf(QuarterDetail)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    QuarterDetail instance = mock(QuarterDetail.class);
    when(instance.quarter()).thenReturn(3);
    when(instance.year()).thenReturn(1);

    // Act
    ImmutableQuarterDetail actualCopyOfResult = ImmutableQuarterDetail.copyOf(instance);

    // Assert
    verify(instance).quarter();
    verify(instance).year();
    assertEquals(1, actualCopyOfResult.year());
    assertEquals(3, actualCopyOfResult.quarter());
    assertEquals(Quarter.Q3, actualCopyOfResult.quarterName());
  }

  /**
   * Method under test: {@link ImmutableQuarterDetail#copyOf(QuarterDetail)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    QuarterDetail instance = mock(QuarterDetail.class);
    when(instance.quarter()).thenReturn(2);
    when(instance.year()).thenReturn(1);

    // Act
    ImmutableQuarterDetail actualCopyOfResult = ImmutableQuarterDetail.copyOf(instance);

    // Assert
    verify(instance).quarter();
    verify(instance).year();
    assertEquals(1, actualCopyOfResult.year());
    assertEquals(2, actualCopyOfResult.quarter());
    assertEquals(Quarter.Q2, actualCopyOfResult.quarterName());
  }

  /**
   * Method under test: {@link ImmutableQuarterDetail#copyOf(QuarterDetail)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    QuarterDetail instance = mock(QuarterDetail.class);
    when(instance.quarter()).thenReturn(4);
    when(instance.year()).thenReturn(1);

    // Act
    ImmutableQuarterDetail actualCopyOfResult = ImmutableQuarterDetail.copyOf(instance);

    // Assert
    verify(instance).quarter();
    verify(instance).year();
    assertEquals(1, actualCopyOfResult.year());
    assertEquals(4, actualCopyOfResult.quarter());
    assertEquals(Quarter.Q4, actualCopyOfResult.quarterName());
  }

  /**
   * Method under test: {@link ImmutableQuarterDetail.Json#additionalQuarters()}
   */
  @Test
  void testJsonAdditionalQuarters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableQuarterDetail.Json()).additionalQuarters());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableQuarterDetail.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableQuarterDetail.Json actualJson = new ImmutableQuarterDetail.Json();

    // Assert
    assertEquals(0, actualJson.quarter);
    assertEquals(0, actualJson.year);
    assertFalse(actualJson.quarterIsSet);
    assertFalse(actualJson.yearIsSet);
  }

  /**
   * Method under test: {@link ImmutableQuarterDetail.Json#quarter()}
   */
  @Test
  void testJsonQuarter() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableQuarterDetail.Json()).quarter());
  }

  /**
   * Method under test: {@link ImmutableQuarterDetail.Json#quarterName()}
   */
  @Test
  void testJsonQuarterName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableQuarterDetail.Json()).quarterName());
  }

  /**
   * Method under test: {@link ImmutableQuarterDetail.Json#setQuarter(int)}
   */
  @Test
  void testJsonSetQuarter() {
    // Arrange
    ImmutableQuarterDetail.Json json = new ImmutableQuarterDetail.Json();

    // Act
    json.setQuarter(1);

    // Assert
    assertEquals(1, json.quarter);
    assertTrue(json.quarterIsSet);
  }

  /**
   * Method under test: {@link ImmutableQuarterDetail.Json#setYear(int)}
   */
  @Test
  void testJsonSetYear() {
    // Arrange
    ImmutableQuarterDetail.Json json = new ImmutableQuarterDetail.Json();

    // Act
    json.setYear(1);

    // Assert
    assertEquals(1, json.year);
    assertTrue(json.yearIsSet);
  }

  /**
   * Method under test: {@link ImmutableQuarterDetail.Json#year()}
   */
  @Test
  void testJsonYear() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableQuarterDetail.Json()).year());
  }
}
