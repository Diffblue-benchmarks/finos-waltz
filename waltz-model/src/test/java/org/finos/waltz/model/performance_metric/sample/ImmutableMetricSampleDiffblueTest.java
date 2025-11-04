package org.finos.waltz.model.performance_metric.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class ImmutableMetricSampleDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableMetricSample.Builder#collectionDate(LocalDate)}
   */
  @Test
  void testBuilderCollectionDate() {
    // Arrange
    ImmutableMetricSample.Builder builderResult = ImmutableMetricSample.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.collectionDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Method under test: {@link ImmutableMetricSample.Builder#createdBy(String)}
   */
  @Test
  void testBuilderCreatedBy() {
    // Arrange
    ImmutableMetricSample.Builder builderResult = ImmutableMetricSample.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.createdBy("Jan 1, 2020 8:00am GMT+0100"));
  }

  /**
   * Method under test:
   * {@link ImmutableMetricSample.Builder#effectiveDate(LocalDate)}
   */
  @Test
  void testBuilderEffectiveDate() {
    // Arrange
    ImmutableMetricSample.Builder builderResult = ImmutableMetricSample.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.effectiveDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Method under test: {@link ImmutableMetricSample.Builder#from(MetricSample)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMetricSample.Builder builderResult = ImmutableMetricSample.builder();
    MetricSample instance = mock(MetricSample.class);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.sampleType()).thenReturn(SampleType.MANUAL);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.effectiveDate()).thenReturn(ofResult);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.collectionDate()).thenReturn(ofResult2);
    when(instance.metricId()).thenReturn(1L);

    // Act
    ImmutableMetricSample.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).collectionDate();
    verify(instance).createdBy();
    verify(instance).effectiveDate();
    verify(instance).metricId();
    verify(instance).provenance();
    verify(instance).sampleType();
    ImmutableMetricSample buildResult = builderResult.build();
    assertEquals("Jan 1, 2020 8:00am GMT+0100", buildResult.createdBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.metricId());
    assertEquals(SampleType.MANUAL, buildResult.sampleType());
    assertSame(ofResult2, buildResult.collectionDate());
    assertSame(ofResult, buildResult.effectiveDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMetricSample.Builder#from(MetricSample)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMetricSample.Builder builderResult = ImmutableMetricSample.builder();
    MetricSample instance = mock(MetricSample.class);
    when(instance.provenance()).thenThrow(new IllegalStateException("instance"));
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.sampleType()).thenReturn(SampleType.MANUAL);
    when(instance.effectiveDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.collectionDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.metricId()).thenReturn(1L);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).collectionDate();
    verify(instance).createdBy();
    verify(instance).effectiveDate();
    verify(instance).metricId();
    verify(instance).provenance();
    verify(instance).sampleType();
  }

  /**
   * Method under test: {@link ImmutableMetricSample.Builder#metricId(long)}
   */
  @Test
  void testBuilderMetricId() {
    // Arrange
    ImmutableMetricSample.Builder builderResult = ImmutableMetricSample.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.metricId(1L));
  }

  /**
   * Method under test: {@link ImmutableMetricSample.Builder#provenance(String)}
   */
  @Test
  void testBuilderProvenance() {
    // Arrange
    ImmutableMetricSample.Builder builderResult = ImmutableMetricSample.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutableMetricSample.Builder#sampleType(SampleType)}
   */
  @Test
  void testBuilderSampleType() {
    // Arrange
    ImmutableMetricSample.Builder builderResult = ImmutableMetricSample.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.sampleType(SampleType.MANUAL));
  }

  /**
   * Method under test: {@link ImmutableMetricSample#copyOf(MetricSample)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MetricSample instance = mock(MetricSample.class);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.sampleType()).thenReturn(SampleType.MANUAL);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.effectiveDate()).thenReturn(ofResult);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.collectionDate()).thenReturn(ofResult2);
    when(instance.metricId()).thenReturn(1L);

    // Act
    ImmutableMetricSample actualCopyOfResult = ImmutableMetricSample.copyOf(instance);

    // Assert
    verify(instance).collectionDate();
    verify(instance).createdBy();
    verify(instance).effectiveDate();
    verify(instance).metricId();
    verify(instance).provenance();
    verify(instance).sampleType();
    LocalDate collectionDateResult = actualCopyOfResult.collectionDate();
    assertEquals("1970-01-01", collectionDateResult.toString());
    LocalDate effectiveDateResult = actualCopyOfResult.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCopyOfResult.createdBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.metricId());
    assertEquals(SampleType.MANUAL, actualCopyOfResult.sampleType());
    assertSame(ofResult2, collectionDateResult);
    assertSame(ofResult, effectiveDateResult);
  }

  /**
   * Method under test: {@link ImmutableMetricSample.Json#collectionDate()}
   */
  @Test
  void testJsonCollectionDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMetricSample.Json()).collectionDate());
  }

  /**
   * Method under test: {@link ImmutableMetricSample.Json#createdBy()}
   */
  @Test
  void testJsonCreatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMetricSample.Json()).createdBy());
  }

  /**
   * Method under test: {@link ImmutableMetricSample.Json#effectiveDate()}
   */
  @Test
  void testJsonEffectiveDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMetricSample.Json()).effectiveDate());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableMetricSample.Json}
   *   <li>{@link ImmutableMetricSample.Json#setCollectionDate(LocalDate)}
   *   <li>{@link ImmutableMetricSample.Json#setCreatedBy(String)}
   *   <li>{@link ImmutableMetricSample.Json#setEffectiveDate(LocalDate)}
   *   <li>{@link ImmutableMetricSample.Json#setProvenance(String)}
   *   <li>{@link ImmutableMetricSample.Json#setSampleType(SampleType)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableMetricSample.Json actualJson = new ImmutableMetricSample.Json();
    actualJson.setCollectionDate(LocalDate.of(1970, 1, 1));
    actualJson.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    actualJson.setEffectiveDate(LocalDate.of(1970, 1, 1));
    actualJson.setProvenance("Provenance");
    actualJson.setSampleType(SampleType.MANUAL);

    // Assert
    assertEquals("1970-01-01", actualJson.collectionDate.toString());
    assertEquals("1970-01-01", actualJson.effectiveDate.toString());
  }

  /**
   * Method under test: {@link ImmutableMetricSample.Json#metricId()}
   */
  @Test
  void testJsonMetricId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMetricSample.Json()).metricId());
  }

  /**
   * Method under test: {@link ImmutableMetricSample.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMetricSample.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableMetricSample.Json#sampleType()}
   */
  @Test
  void testJsonSampleType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMetricSample.Json()).sampleType());
  }

  /**
   * Method under test: {@link ImmutableMetricSample.Json#setMetricId(long)}
   */
  @Test
  void testJsonSetMetricId() {
    // Arrange
    ImmutableMetricSample.Json json = new ImmutableMetricSample.Json();

    // Act
    json.setMetricId(1L);

    // Assert
    assertEquals(1L, json.metricId);
    assertTrue(json.metricIdIsSet);
  }
}
