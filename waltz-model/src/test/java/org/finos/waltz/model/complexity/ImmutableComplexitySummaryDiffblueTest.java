package org.finos.waltz.model.complexity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableComplexitySummaryDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Builder#addAllTopComplexityScores(Iterable)}
   */
  @Test
  void testBuilderAddAllTopComplexityScores() {
    // Arrange
    ImmutableComplexitySummary.Builder builderResult = ImmutableComplexitySummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllTopComplexityScores(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Builder#addTopComplexityScores(Complexity)}
   */
  @Test
  void testBuilderAddTopComplexityScores() {
    // Arrange
    ImmutableComplexitySummary.Builder builderResult = ImmutableComplexitySummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addTopComplexityScores(new ImmutableComplexity.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Builder#addTopComplexityScores(Complexity)}
   */
  @Test
  void testBuilderAddTopComplexityScores2() {
    // Arrange
    ImmutableComplexitySummary.Builder builderResult = ImmutableComplexitySummary.builder();

    ImmutableComplexity.Json element = new ImmutableComplexity.Json();
    element.setEntityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addTopComplexityScores(element));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Builder#addTopComplexityScores(Complexity[])}
   */
  @Test
  void testBuilderAddTopComplexityScores3() {
    // Arrange
    ImmutableComplexitySummary.Builder builderResult = ImmutableComplexitySummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addTopComplexityScores(new ImmutableComplexity.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Builder#addTopComplexityScores(Complexity[])}
   */
  @Test
  void testBuilderAddTopComplexityScores4() {
    // Arrange
    ImmutableComplexitySummary.Builder builderResult = ImmutableComplexitySummary.builder();

    ImmutableComplexity.Json json = new ImmutableComplexity.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addTopComplexityScores(json));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Builder#average(BigDecimal)}
   */
  @Test
  void testBuilderAverage() {
    // Arrange
    ImmutableComplexitySummary.Builder builderResult = ImmutableComplexitySummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.average(new BigDecimal("2.3")));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Builder#average(BigDecimal)}
   */
  @Test
  void testBuilderAverage2() {
    // Arrange
    ImmutableComplexity.Json element = new ImmutableComplexity.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableComplexitySummary.Builder builderResult = ImmutableComplexitySummary.builder();
    builderResult.addTopComplexityScores(element);

    // Act and Assert
    assertSame(builderResult, builderResult.average(new BigDecimal("2.3")));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Builder#complexityKind(ComplexityKind)}
   */
  @Test
  void testBuilderComplexityKind() {
    // Arrange
    ImmutableComplexitySummary.Builder builderResult = ImmutableComplexitySummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.complexityKind(new ImmutableComplexityKind.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Builder#complexityKind(ComplexityKind)}
   */
  @Test
  void testBuilderComplexityKind2() {
    // Arrange
    ImmutableComplexity.Json element = new ImmutableComplexity.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableComplexitySummary.Builder builderResult = ImmutableComplexitySummary.builder();
    builderResult.addTopComplexityScores(element);

    // Act and Assert
    assertSame(builderResult, builderResult.complexityKind(new ImmutableComplexityKind.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Builder#from(ComplexitySummary)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableComplexitySummary.Builder builderResult = ImmutableComplexitySummary.builder();
    ComplexitySummary instance = mock(ComplexitySummary.class);
    when(instance.topComplexityScores()).thenReturn(new ArrayList<>());
    ImmutableComplexityKind.Json json = new ImmutableComplexityKind.Json();
    when(instance.complexityKind()).thenReturn(json);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.total()).thenReturn(bigDecimal);
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    when(instance.standardDeviation()).thenReturn(bigDecimal2);
    BigDecimal bigDecimal3 = new BigDecimal("2.3");
    when(instance.variance()).thenReturn(bigDecimal3);
    BigDecimal bigDecimal4 = new BigDecimal("2.3");
    when(instance.median()).thenReturn(bigDecimal4);
    when(instance.mappedCount()).thenReturn(3);
    when(instance.missingCount()).thenReturn(3);
    BigDecimal bigDecimal5 = new BigDecimal("2.3");
    when(instance.average()).thenReturn(bigDecimal5);

    // Act
    ImmutableComplexitySummary.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).average();
    verify(instance).complexityKind();
    verify(instance).mappedCount();
    verify(instance).median();
    verify(instance).missingCount();
    verify(instance).standardDeviation();
    verify(instance).topComplexityScores();
    verify(instance).total();
    verify(instance).variance();
    ImmutableComplexitySummary buildResult = builderResult.build();
    assertEquals(3, buildResult.mappedCount());
    assertEquals(3, buildResult.missingCount());
    assertSame(bigDecimal5, buildResult.average());
    assertSame(bigDecimal4, buildResult.median());
    assertSame(bigDecimal2, buildResult.standardDeviation());
    assertSame(bigDecimal, buildResult.total());
    assertSame(bigDecimal3, buildResult.variance());
    assertSame(json, buildResult.complexityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Builder#from(ComplexitySummary)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableComplexitySummary.Builder builderResult = ImmutableComplexitySummary.builder();
    ComplexitySummary instance = mock(ComplexitySummary.class);
    when(instance.topComplexityScores()).thenThrow(new IllegalStateException("instance"));
    when(instance.total()).thenReturn(new BigDecimal("2.3"));
    when(instance.standardDeviation()).thenReturn(new BigDecimal("2.3"));
    when(instance.variance()).thenReturn(new BigDecimal("2.3"));
    when(instance.median()).thenReturn(new BigDecimal("2.3"));
    when(instance.mappedCount()).thenReturn(3);
    when(instance.missingCount()).thenReturn(3);
    when(instance.average()).thenReturn(new BigDecimal("2.3"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).average();
    verify(instance).mappedCount();
    verify(instance).median();
    verify(instance).missingCount();
    verify(instance).standardDeviation();
    verify(instance).topComplexityScores();
    verify(instance).total();
    verify(instance).variance();
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Builder#from(ComplexitySummary)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableComplexitySummary.Builder builderResult = ImmutableComplexitySummary.builder();

    ArrayList<Complexity> complexityList = new ArrayList<>();
    ImmutableComplexity.Json json = new ImmutableComplexity.Json();
    complexityList.add(json);
    ComplexitySummary instance = mock(ComplexitySummary.class);
    when(instance.topComplexityScores()).thenReturn(complexityList);
    ImmutableComplexityKind.Json json2 = new ImmutableComplexityKind.Json();
    when(instance.complexityKind()).thenReturn(json2);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.total()).thenReturn(bigDecimal);
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    when(instance.standardDeviation()).thenReturn(bigDecimal2);
    BigDecimal bigDecimal3 = new BigDecimal("2.3");
    when(instance.variance()).thenReturn(bigDecimal3);
    BigDecimal bigDecimal4 = new BigDecimal("2.3");
    when(instance.median()).thenReturn(bigDecimal4);
    when(instance.mappedCount()).thenReturn(3);
    when(instance.missingCount()).thenReturn(3);
    BigDecimal bigDecimal5 = new BigDecimal("2.3");
    when(instance.average()).thenReturn(bigDecimal5);

    // Act
    ImmutableComplexitySummary.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).average();
    verify(instance).complexityKind();
    verify(instance).mappedCount();
    verify(instance).median();
    verify(instance).missingCount();
    verify(instance).standardDeviation();
    verify(instance).topComplexityScores();
    verify(instance).total();
    verify(instance).variance();
    ImmutableComplexitySummary buildResult = builderResult.build();
    List<Complexity> topComplexityScoresResult = buildResult.topComplexityScores();
    assertEquals(1, topComplexityScoresResult.size());
    assertEquals(3, buildResult.mappedCount());
    assertEquals(3, buildResult.missingCount());
    assertSame(bigDecimal5, buildResult.average());
    assertSame(bigDecimal4, buildResult.median());
    assertSame(bigDecimal2, buildResult.standardDeviation());
    assertSame(bigDecimal, buildResult.total());
    assertSame(bigDecimal3, buildResult.variance());
    assertSame(json, topComplexityScoresResult.get(0));
    assertSame(json2, buildResult.complexityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Builder#mappedCount(int)}
   */
  @Test
  void testBuilderMappedCount() {
    // Arrange
    ImmutableComplexitySummary.Builder builderResult = ImmutableComplexitySummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.mappedCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Builder#mappedCount(int)}
   */
  @Test
  void testBuilderMappedCount2() {
    // Arrange
    ImmutableComplexity.Json element = new ImmutableComplexity.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableComplexitySummary.Builder builderResult = ImmutableComplexitySummary.builder();
    builderResult.addTopComplexityScores(element);

    // Act and Assert
    assertSame(builderResult, builderResult.mappedCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Builder#median(BigDecimal)}
   */
  @Test
  void testBuilderMedian() {
    // Arrange
    ImmutableComplexitySummary.Builder builderResult = ImmutableComplexitySummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.median(new BigDecimal("2.3")));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Builder#median(BigDecimal)}
   */
  @Test
  void testBuilderMedian2() {
    // Arrange
    ImmutableComplexity.Json element = new ImmutableComplexity.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableComplexitySummary.Builder builderResult = ImmutableComplexitySummary.builder();
    builderResult.addTopComplexityScores(element);

    // Act and Assert
    assertSame(builderResult, builderResult.median(new BigDecimal("2.3")));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Builder#missingCount(int)}
   */
  @Test
  void testBuilderMissingCount() {
    // Arrange
    ImmutableComplexitySummary.Builder builderResult = ImmutableComplexitySummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.missingCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Builder#missingCount(int)}
   */
  @Test
  void testBuilderMissingCount2() {
    // Arrange
    ImmutableComplexity.Json element = new ImmutableComplexity.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableComplexitySummary.Builder builderResult = ImmutableComplexitySummary.builder();
    builderResult.addTopComplexityScores(element);

    // Act and Assert
    assertSame(builderResult, builderResult.missingCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Builder#standardDeviation(BigDecimal)}
   */
  @Test
  void testBuilderStandardDeviation() {
    // Arrange
    ImmutableComplexitySummary.Builder builderResult = ImmutableComplexitySummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.standardDeviation(new BigDecimal("2.3")));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Builder#standardDeviation(BigDecimal)}
   */
  @Test
  void testBuilderStandardDeviation2() {
    // Arrange
    ImmutableComplexity.Json element = new ImmutableComplexity.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableComplexitySummary.Builder builderResult = ImmutableComplexitySummary.builder();
    builderResult.addTopComplexityScores(element);

    // Act and Assert
    assertSame(builderResult, builderResult.standardDeviation(new BigDecimal("2.3")));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Builder#topComplexityScores(Iterable)}
   */
  @Test
  void testBuilderTopComplexityScores() {
    // Arrange
    ImmutableComplexitySummary.Builder builderResult = ImmutableComplexitySummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.topComplexityScores(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Builder#total(BigDecimal)}
   */
  @Test
  void testBuilderTotal() {
    // Arrange
    ImmutableComplexitySummary.Builder builderResult = ImmutableComplexitySummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.total(new BigDecimal("2.3")));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Builder#total(BigDecimal)}
   */
  @Test
  void testBuilderTotal2() {
    // Arrange
    ImmutableComplexity.Json element = new ImmutableComplexity.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableComplexitySummary.Builder builderResult = ImmutableComplexitySummary.builder();
    builderResult.addTopComplexityScores(element);

    // Act and Assert
    assertSame(builderResult, builderResult.total(new BigDecimal("2.3")));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Builder#variance(BigDecimal)}
   */
  @Test
  void testBuilderVariance() {
    // Arrange
    ImmutableComplexitySummary.Builder builderResult = ImmutableComplexitySummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.variance(new BigDecimal("2.3")));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Builder#variance(BigDecimal)}
   */
  @Test
  void testBuilderVariance2() {
    // Arrange
    ImmutableComplexity.Json element = new ImmutableComplexity.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableComplexitySummary.Builder builderResult = ImmutableComplexitySummary.builder();
    builderResult.addTopComplexityScores(element);

    // Act and Assert
    assertSame(builderResult, builderResult.variance(new BigDecimal("2.3")));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary#copyOf(ComplexitySummary)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ComplexitySummary instance = mock(ComplexitySummary.class);
    when(instance.topComplexityScores()).thenReturn(new ArrayList<>());
    ImmutableComplexityKind.Json json = new ImmutableComplexityKind.Json();
    when(instance.complexityKind()).thenReturn(json);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.total()).thenReturn(bigDecimal);
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    when(instance.standardDeviation()).thenReturn(bigDecimal2);
    BigDecimal bigDecimal3 = new BigDecimal("2.3");
    when(instance.variance()).thenReturn(bigDecimal3);
    BigDecimal bigDecimal4 = new BigDecimal("2.3");
    when(instance.median()).thenReturn(bigDecimal4);
    when(instance.mappedCount()).thenReturn(3);
    when(instance.missingCount()).thenReturn(3);
    BigDecimal bigDecimal5 = new BigDecimal("2.3");
    when(instance.average()).thenReturn(bigDecimal5);

    // Act
    ImmutableComplexitySummary actualCopyOfResult = ImmutableComplexitySummary.copyOf(instance);

    // Assert
    verify(instance).average();
    verify(instance).complexityKind();
    verify(instance).mappedCount();
    verify(instance).median();
    verify(instance).missingCount();
    verify(instance).standardDeviation();
    verify(instance).topComplexityScores();
    verify(instance).total();
    verify(instance).variance();
    assertEquals(3, actualCopyOfResult.mappedCount());
    assertEquals(3, actualCopyOfResult.missingCount());
    assertTrue(actualCopyOfResult.topComplexityScores().isEmpty());
    BigDecimal expectedAverageResult = new BigDecimal("2.3");
    BigDecimal averageResult = actualCopyOfResult.average();
    assertEquals(expectedAverageResult, averageResult);
    BigDecimal expectedMedianResult = new BigDecimal("2.3");
    BigDecimal medianResult = actualCopyOfResult.median();
    assertEquals(expectedMedianResult, medianResult);
    BigDecimal expectedStandardDeviationResult = new BigDecimal("2.3");
    BigDecimal standardDeviationResult = actualCopyOfResult.standardDeviation();
    assertEquals(expectedStandardDeviationResult, standardDeviationResult);
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    BigDecimal totalResult = actualCopyOfResult.total();
    assertEquals(expectedTotalResult, totalResult);
    BigDecimal expectedVarianceResult = new BigDecimal("2.3");
    BigDecimal varianceResult = actualCopyOfResult.variance();
    assertEquals(expectedVarianceResult, varianceResult);
    assertSame(bigDecimal5, averageResult);
    assertSame(bigDecimal4, medianResult);
    assertSame(bigDecimal2, standardDeviationResult);
    assertSame(bigDecimal, totalResult);
    assertSame(bigDecimal3, varianceResult);
    assertSame(json, actualCopyOfResult.complexityKind());
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary#copyOf(ComplexitySummary)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<Complexity> complexityList = new ArrayList<>();
    complexityList.add(new ImmutableComplexity.Json());
    ComplexitySummary instance = mock(ComplexitySummary.class);
    when(instance.topComplexityScores()).thenReturn(complexityList);
    ImmutableComplexityKind.Json json = new ImmutableComplexityKind.Json();
    when(instance.complexityKind()).thenReturn(json);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.total()).thenReturn(bigDecimal);
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    when(instance.standardDeviation()).thenReturn(bigDecimal2);
    BigDecimal bigDecimal3 = new BigDecimal("2.3");
    when(instance.variance()).thenReturn(bigDecimal3);
    BigDecimal bigDecimal4 = new BigDecimal("2.3");
    when(instance.median()).thenReturn(bigDecimal4);
    when(instance.mappedCount()).thenReturn(3);
    when(instance.missingCount()).thenReturn(3);
    BigDecimal bigDecimal5 = new BigDecimal("2.3");
    when(instance.average()).thenReturn(bigDecimal5);

    // Act
    ImmutableComplexitySummary actualCopyOfResult = ImmutableComplexitySummary.copyOf(instance);

    // Assert
    verify(instance).average();
    verify(instance).complexityKind();
    verify(instance).mappedCount();
    verify(instance).median();
    verify(instance).missingCount();
    verify(instance).standardDeviation();
    verify(instance).topComplexityScores();
    verify(instance).total();
    verify(instance).variance();
    assertEquals(3, actualCopyOfResult.mappedCount());
    assertEquals(3, actualCopyOfResult.missingCount());
    BigDecimal expectedAverageResult = new BigDecimal("2.3");
    BigDecimal averageResult = actualCopyOfResult.average();
    assertEquals(expectedAverageResult, averageResult);
    BigDecimal expectedMedianResult = new BigDecimal("2.3");
    BigDecimal medianResult = actualCopyOfResult.median();
    assertEquals(expectedMedianResult, medianResult);
    BigDecimal expectedStandardDeviationResult = new BigDecimal("2.3");
    BigDecimal standardDeviationResult = actualCopyOfResult.standardDeviation();
    assertEquals(expectedStandardDeviationResult, standardDeviationResult);
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    BigDecimal totalResult = actualCopyOfResult.total();
    assertEquals(expectedTotalResult, totalResult);
    BigDecimal expectedVarianceResult = new BigDecimal("2.3");
    BigDecimal varianceResult = actualCopyOfResult.variance();
    assertEquals(expectedVarianceResult, varianceResult);
    assertEquals(complexityList, actualCopyOfResult.topComplexityScores());
    assertSame(bigDecimal5, averageResult);
    assertSame(bigDecimal4, medianResult);
    assertSame(bigDecimal2, standardDeviationResult);
    assertSame(bigDecimal, totalResult);
    assertSame(bigDecimal3, varianceResult);
    assertSame(json, actualCopyOfResult.complexityKind());
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary#copyOf(ComplexitySummary)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<Complexity> complexityList = new ArrayList<>();
    complexityList.add(new ImmutableComplexity.Json());
    complexityList.add(new ImmutableComplexity.Json());
    ComplexitySummary instance = mock(ComplexitySummary.class);
    when(instance.topComplexityScores()).thenReturn(complexityList);
    ImmutableComplexityKind.Json json = new ImmutableComplexityKind.Json();
    when(instance.complexityKind()).thenReturn(json);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.total()).thenReturn(bigDecimal);
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    when(instance.standardDeviation()).thenReturn(bigDecimal2);
    BigDecimal bigDecimal3 = new BigDecimal("2.3");
    when(instance.variance()).thenReturn(bigDecimal3);
    BigDecimal bigDecimal4 = new BigDecimal("2.3");
    when(instance.median()).thenReturn(bigDecimal4);
    when(instance.mappedCount()).thenReturn(3);
    when(instance.missingCount()).thenReturn(3);
    BigDecimal bigDecimal5 = new BigDecimal("2.3");
    when(instance.average()).thenReturn(bigDecimal5);

    // Act
    ImmutableComplexitySummary actualCopyOfResult = ImmutableComplexitySummary.copyOf(instance);

    // Assert
    verify(instance).average();
    verify(instance).complexityKind();
    verify(instance).mappedCount();
    verify(instance).median();
    verify(instance).missingCount();
    verify(instance).standardDeviation();
    verify(instance).topComplexityScores();
    verify(instance).total();
    verify(instance).variance();
    assertEquals(3, actualCopyOfResult.mappedCount());
    assertEquals(3, actualCopyOfResult.missingCount());
    BigDecimal expectedAverageResult = new BigDecimal("2.3");
    BigDecimal averageResult = actualCopyOfResult.average();
    assertEquals(expectedAverageResult, averageResult);
    BigDecimal expectedMedianResult = new BigDecimal("2.3");
    BigDecimal medianResult = actualCopyOfResult.median();
    assertEquals(expectedMedianResult, medianResult);
    BigDecimal expectedStandardDeviationResult = new BigDecimal("2.3");
    BigDecimal standardDeviationResult = actualCopyOfResult.standardDeviation();
    assertEquals(expectedStandardDeviationResult, standardDeviationResult);
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    BigDecimal totalResult = actualCopyOfResult.total();
    assertEquals(expectedTotalResult, totalResult);
    BigDecimal expectedVarianceResult = new BigDecimal("2.3");
    BigDecimal varianceResult = actualCopyOfResult.variance();
    assertEquals(expectedVarianceResult, varianceResult);
    assertEquals(complexityList, actualCopyOfResult.topComplexityScores());
    assertSame(bigDecimal5, averageResult);
    assertSame(bigDecimal4, medianResult);
    assertSame(bigDecimal2, standardDeviationResult);
    assertSame(bigDecimal, totalResult);
    assertSame(bigDecimal3, varianceResult);
    assertSame(json, actualCopyOfResult.complexityKind());
  }

  /**
   * Method under test: {@link ImmutableComplexitySummary.Json#average()}
   */
  @Test
  void testJsonAverage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexitySummary.Json()).average());
  }

  /**
   * Method under test: {@link ImmutableComplexitySummary.Json#complexityKind()}
   */
  @Test
  void testJsonComplexityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexitySummary.Json()).complexityKind());
  }

  /**
   * Method under test: {@link ImmutableComplexitySummary.Json#mappedCount()}
   */
  @Test
  void testJsonMappedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexitySummary.Json()).mappedCount());
  }

  /**
   * Method under test: {@link ImmutableComplexitySummary.Json#median()}
   */
  @Test
  void testJsonMedian() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexitySummary.Json()).median());
  }

  /**
   * Method under test: {@link ImmutableComplexitySummary.Json#missingCount()}
   */
  @Test
  void testJsonMissingCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexitySummary.Json()).missingCount());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableComplexitySummary.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableComplexitySummary.Json actualJson = new ImmutableComplexitySummary.Json();

    // Assert
    assertNull(actualJson.average);
    assertNull(actualJson.median);
    assertNull(actualJson.standardDeviation);
    assertNull(actualJson.total);
    assertNull(actualJson.variance);
    assertNull(actualJson.complexityKind);
    assertEquals(0, actualJson.mappedCount);
    assertEquals(0, actualJson.missingCount);
    assertFalse(actualJson.mappedCountIsSet);
    assertFalse(actualJson.missingCountIsSet);
    assertTrue(actualJson.topComplexityScores.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Json#setMappedCount(int)}
   */
  @Test
  void testJsonSetMappedCount() {
    // Arrange
    ImmutableComplexitySummary.Json json = new ImmutableComplexitySummary.Json();

    // Act
    json.setMappedCount(3);

    // Assert
    assertEquals(3, json.mappedCount);
    assertTrue(json.mappedCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Json#setMissingCount(int)}
   */
  @Test
  void testJsonSetMissingCount() {
    // Arrange
    ImmutableComplexitySummary.Json json = new ImmutableComplexitySummary.Json();

    // Act
    json.setMissingCount(3);

    // Assert
    assertEquals(3, json.missingCount);
    assertTrue(json.missingCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Json#standardDeviation()}
   */
  @Test
  void testJsonStandardDeviation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableComplexitySummary.Json()).standardDeviation());
  }

  /**
   * Method under test:
   * {@link ImmutableComplexitySummary.Json#topComplexityScores()}
   */
  @Test
  void testJsonTopComplexityScores() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableComplexitySummary.Json()).topComplexityScores());
  }

  /**
   * Method under test: {@link ImmutableComplexitySummary.Json#total()}
   */
  @Test
  void testJsonTotal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexitySummary.Json()).total());
  }

  /**
   * Method under test: {@link ImmutableComplexitySummary.Json#variance()}
   */
  @Test
  void testJsonVariance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexitySummary.Json()).variance());
  }
}
