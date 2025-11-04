package org.finos.waltz.model.complexity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ImmutableComplexityTotalDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableComplexityTotal.Builder#average(BigDecimal)}
   */
  @Test
  void testBuilderAverage() {
    // Arrange
    ImmutableComplexityTotal.Builder builderResult = ImmutableComplexityTotal.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.average(new BigDecimal("2.3")));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityTotal.Builder#complexityKind(ComplexityKind)}
   */
  @Test
  void testBuilderComplexityKind() {
    // Arrange
    ImmutableComplexityTotal.Builder builderResult = ImmutableComplexityTotal.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.complexityKind(new ImmutableComplexityKind.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityTotal.Builder#from(ComplexityTotal)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableComplexityTotal.Builder builderResult = ImmutableComplexityTotal.builder();
    ComplexityTotal instance = mock(ComplexityTotal.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.standardDeviation()).thenReturn(bigDecimal);
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    when(instance.average()).thenReturn(bigDecimal2);
    BigDecimal bigDecimal3 = new BigDecimal("2.3");
    when(instance.total()).thenReturn(bigDecimal3);
    ImmutableComplexityKind.Json json = new ImmutableComplexityKind.Json();
    when(instance.complexityKind()).thenReturn(json);

    // Act
    ImmutableComplexityTotal.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).average();
    verify(instance).complexityKind();
    verify(instance).standardDeviation();
    verify(instance).total();
    ImmutableComplexityTotal buildResult = builderResult.build();
    assertSame(bigDecimal2, buildResult.average());
    assertSame(bigDecimal, buildResult.standardDeviation());
    assertSame(bigDecimal3, buildResult.total());
    assertSame(json, buildResult.complexityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityTotal.Builder#from(ComplexityTotal)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableComplexityTotal.Builder builderResult = ImmutableComplexityTotal.builder();
    ComplexityTotal instance = mock(ComplexityTotal.class);
    when(instance.standardDeviation()).thenThrow(new IllegalStateException("instance"));
    when(instance.average()).thenReturn(new BigDecimal("2.3"));
    when(instance.total()).thenReturn(new BigDecimal("2.3"));
    when(instance.complexityKind()).thenReturn(new ImmutableComplexityKind.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).average();
    verify(instance).complexityKind();
    verify(instance).standardDeviation();
    verify(instance).total();
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityTotal.Builder#standardDeviation(BigDecimal)}
   */
  @Test
  void testBuilderStandardDeviation() {
    // Arrange
    ImmutableComplexityTotal.Builder builderResult = ImmutableComplexityTotal.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.standardDeviation(new BigDecimal("2.3")));
  }

  /**
   * Method under test: {@link ImmutableComplexityTotal.Builder#total(BigDecimal)}
   */
  @Test
  void testBuilderTotal() {
    // Arrange
    ImmutableComplexityTotal.Builder builderResult = ImmutableComplexityTotal.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.total(new BigDecimal("2.3")));
  }

  /**
   * Method under test: {@link ImmutableComplexityTotal#copyOf(ComplexityTotal)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ComplexityTotal instance = mock(ComplexityTotal.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.standardDeviation()).thenReturn(bigDecimal);
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    when(instance.average()).thenReturn(bigDecimal2);
    BigDecimal bigDecimal3 = new BigDecimal("2.3");
    when(instance.total()).thenReturn(bigDecimal3);
    ImmutableComplexityKind.Json json = new ImmutableComplexityKind.Json();
    when(instance.complexityKind()).thenReturn(json);

    // Act
    ImmutableComplexityTotal actualCopyOfResult = ImmutableComplexityTotal.copyOf(instance);

    // Assert
    verify(instance).average();
    verify(instance).complexityKind();
    verify(instance).standardDeviation();
    verify(instance).total();
    BigDecimal expectedAverageResult = new BigDecimal("2.3");
    BigDecimal averageResult = actualCopyOfResult.average();
    assertEquals(expectedAverageResult, averageResult);
    BigDecimal expectedStandardDeviationResult = new BigDecimal("2.3");
    BigDecimal standardDeviationResult = actualCopyOfResult.standardDeviation();
    assertEquals(expectedStandardDeviationResult, standardDeviationResult);
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    BigDecimal totalResult = actualCopyOfResult.total();
    assertEquals(expectedTotalResult, totalResult);
    assertSame(bigDecimal2, averageResult);
    assertSame(bigDecimal, standardDeviationResult);
    assertSame(bigDecimal3, totalResult);
    assertSame(json, actualCopyOfResult.complexityKind());
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityTotal#fromJson(ImmutableComplexityTotal.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableComplexityTotal.Json json = new ImmutableComplexityTotal.Json();
    ImmutableComplexityKind.Json complexityKind = new ImmutableComplexityKind.Json();
    json.setComplexityKind(complexityKind);
    BigDecimal total = new BigDecimal("2.3");
    json.setTotal(total);
    BigDecimal average = new BigDecimal("2.3");
    json.setAverage(average);
    BigDecimal standardDeviation = new BigDecimal("2.3");
    json.setStandardDeviation(standardDeviation);

    // Act
    ImmutableComplexityTotal actualFromJsonResult = ImmutableComplexityTotal.fromJson(json);

    // Assert
    BigDecimal expectedAverageResult = new BigDecimal("2.3");
    BigDecimal averageResult = actualFromJsonResult.average();
    assertEquals(expectedAverageResult, averageResult);
    BigDecimal expectedStandardDeviationResult = new BigDecimal("2.3");
    BigDecimal standardDeviationResult = actualFromJsonResult.standardDeviation();
    assertEquals(expectedStandardDeviationResult, standardDeviationResult);
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    BigDecimal totalResult = actualFromJsonResult.total();
    assertEquals(expectedTotalResult, totalResult);
    assertSame(average, averageResult);
    assertSame(standardDeviation, standardDeviationResult);
    assertSame(total, totalResult);
    assertSame(complexityKind, actualFromJsonResult.complexityKind());
  }

  /**
   * Method under test: {@link ImmutableComplexityTotal.Json#average()}
   */
  @Test
  void testJsonAverage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexityTotal.Json()).average());
  }

  /**
   * Method under test: {@link ImmutableComplexityTotal.Json#complexityKind()}
   */
  @Test
  void testJsonComplexityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexityTotal.Json()).complexityKind());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableComplexityTotal.Json}
   *   <li>{@link ImmutableComplexityTotal.Json#setAverage(BigDecimal)}
   *   <li>{@link ImmutableComplexityTotal.Json#setComplexityKind(ComplexityKind)}
   *   <li>{@link ImmutableComplexityTotal.Json#setStandardDeviation(BigDecimal)}
   *   <li>{@link ImmutableComplexityTotal.Json#setTotal(BigDecimal)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableComplexityTotal.Json actualJson = new ImmutableComplexityTotal.Json();
    actualJson.setAverage(new BigDecimal("2.3"));
    actualJson.setComplexityKind(new ImmutableComplexityKind.Json());
    actualJson.setStandardDeviation(new BigDecimal("2.3"));
    actualJson.setTotal(new BigDecimal("2.3"));

    // Assert
    assertFalse(((ImmutableComplexityKind.Json) actualJson.complexityKind).externalId.isPresent());
  }

  /**
   * Method under test: {@link ImmutableComplexityTotal.Json#standardDeviation()}
   */
  @Test
  void testJsonStandardDeviation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexityTotal.Json()).standardDeviation());
  }

  /**
   * Method under test: {@link ImmutableComplexityTotal.Json#total()}
   */
  @Test
  void testJsonTotal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexityTotal.Json()).total());
  }
}
