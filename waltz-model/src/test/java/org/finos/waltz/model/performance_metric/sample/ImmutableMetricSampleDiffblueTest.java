package org.finos.waltz.model.performance_metric.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.performance_metric.sample.ImmutableMetricSample.Builder;
import org.finos.waltz.model.performance_metric.sample.ImmutableMetricSample.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMetricSampleDiffblueTest {
  /**
   * Test Builder {@link Builder#collectionDate(LocalDate)}.
   * <ul>
   *   <li>When {@link LocalDate} with {@code 1970} and one and one.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#collectionDate(LocalDate)}
   */
  @Test
  @DisplayName("Test Builder collectionDate(LocalDate); when LocalDate with '1970' and one and one; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.collectionDate(LocalDate)"})
  void testBuilderCollectionDate_whenLocalDateWith1970AndOneAndOne_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricSample.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.collectionDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Test Builder {@link Builder#createdBy(String)}.
   * <p>
   * Method under test: {@link Builder#createdBy(String)}
   */
  @Test
  @DisplayName("Test Builder createdBy(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.createdBy(String)"})
  void testBuilderCreatedBy() {
    // Arrange
    Builder builderResult = ImmutableMetricSample.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.createdBy("Jan 1, 2020 8:00am GMT+0100"));
  }

  /**
   * Test Builder {@link Builder#effectiveDate(LocalDate)}.
   * <ul>
   *   <li>When {@link LocalDate} with {@code 1970} and one and one.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#effectiveDate(LocalDate)}
   */
  @Test
  @DisplayName("Test Builder effectiveDate(LocalDate); when LocalDate with '1970' and one and one; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.effectiveDate(LocalDate)"})
  void testBuilderEffectiveDate_whenLocalDateWith1970AndOneAndOne_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricSample.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.effectiveDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Test Builder {@link Builder#from(MetricSample)}.
   * <ul>
   *   <li>Given {@code Provenance}.</li>
   *   <li>Then builder build createdBy is {@code Jan 1, 2020 8:00am GMT+0100}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MetricSample)}
   */
  @Test
  @DisplayName("Test Builder from(MetricSample); given 'Provenance'; then builder build createdBy is 'Jan 1, 2020 8:00am GMT+0100'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MetricSample)"})
  void testBuilderFrom_givenProvenance_thenBuilderBuildCreatedByIsJan12020800amGmt0100() {
    // Arrange
    Builder builderResult = ImmutableMetricSample.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(MetricSample)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MetricSample)}
   */
  @Test
  @DisplayName("Test Builder from(MetricSample); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MetricSample)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMetricSample.builder();
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
   * Test Builder {@link Builder#metricId(long)}.
   * <p>
   * Method under test: {@link Builder#metricId(long)}
   */
  @Test
  @DisplayName("Test Builder metricId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.metricId(long)"})
  void testBuilderMetricId() {
    // Arrange
    Builder builderResult = ImmutableMetricSample.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.metricId(1L));
  }

  /**
   * Test Builder {@link Builder#provenance(String)}.
   * <p>
   * Method under test: {@link Builder#provenance(String)}
   */
  @Test
  @DisplayName("Test Builder provenance(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.provenance(String)"})
  void testBuilderProvenance() {
    // Arrange
    Builder builderResult = ImmutableMetricSample.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.provenance("Provenance"));
  }

  /**
   * Test Builder {@link Builder#sampleType(SampleType)}.
   * <p>
   * Method under test: {@link Builder#sampleType(SampleType)}
   */
  @Test
  @DisplayName("Test Builder sampleType(SampleType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.sampleType(SampleType)"})
  void testBuilderSampleType() {
    // Arrange
    Builder builderResult = ImmutableMetricSample.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.sampleType(SampleType.MANUAL));
  }

  /**
   * Test Json {@link Json#collectionDate()}.
   * <p>
   * Method under test: {@link Json#collectionDate()}
   */
  @Test
  @DisplayName("Test Json collectionDate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDate Json.collectionDate()"})
  void testJsonCollectionDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).collectionDate());
  }

  /**
   * Test Json {@link Json#createdBy()}.
   * <p>
   * Method under test: {@link Json#createdBy()}
   */
  @Test
  @DisplayName("Test Json createdBy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.createdBy()"})
  void testJsonCreatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).createdBy());
  }

  /**
   * Test Json {@link Json#effectiveDate()}.
   * <p>
   * Method under test: {@link Json#effectiveDate()}
   */
  @Test
  @DisplayName("Test Json effectiveDate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDate Json.effectiveDate()"})
  void testJsonEffectiveDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).effectiveDate());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCollectionDate(LocalDate)}
   *   <li>{@link Json#setCreatedBy(String)}
   *   <li>{@link Json#setEffectiveDate(LocalDate)}
   *   <li>{@link Json#setProvenance(String)}
   *   <li>{@link Json#setSampleType(SampleType)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setCollectionDate(LocalDate)", "void Json.setCreatedBy(String)",
      "void Json.setEffectiveDate(LocalDate)", "void Json.setProvenance(String)",
      "void Json.setSampleType(SampleType)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
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
   * Test Json {@link Json#metricId()}.
   * <p>
   * Method under test: {@link Json#metricId()}
   */
  @Test
  @DisplayName("Test Json metricId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.metricId()"})
  void testJsonMetricId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).metricId());
  }

  /**
   * Test Json {@link Json#provenance()}.
   * <p>
   * Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).provenance());
  }

  /**
   * Test Json {@link Json#sampleType()}.
   * <p>
   * Method under test: {@link Json#sampleType()}
   */
  @Test
  @DisplayName("Test Json sampleType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SampleType Json.sampleType()"})
  void testJsonSampleType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).sampleType());
  }

  /**
   * Test Json {@link Json#setMetricId(long)}.
   * <p>
   * Method under test: {@link Json#setMetricId(long)}
   */
  @Test
  @DisplayName("Test Json setMetricId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setMetricId(long)"})
  void testJsonSetMetricId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setMetricId(1L);

    // Assert
    assertEquals(1L, json.metricId);
    assertTrue(json.metricIdIsSet);
  }
}
