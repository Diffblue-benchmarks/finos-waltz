package org.finos.waltz.model.performance_metric.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.performance_metric.sample.ImmutableMetricSample.Builder;
import org.finos.waltz.model.performance_metric.sample.ImmutableMetricSample.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMetricSampleDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricSample Builder.build()"})
  void testBuilderBuild() {
    // Arrange
    LocalDate collectionDate = LocalDate.of(1970, 1, 1);
    LocalDate effectiveDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMetricSample actualImmutableMetricSample =
        ImmutableMetricSample.builder()
            .collectionDate(collectionDate)
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(effectiveDate)
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build();

    // Assert
    LocalDate collectionDateResult = actualImmutableMetricSample.collectionDate();
    assertEquals("1970-01-01", collectionDateResult.toString());
    LocalDate effectiveDateResult = actualImmutableMetricSample.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualImmutableMetricSample.createdBy());
    assertEquals("Provenance", actualImmutableMetricSample.provenance());
    assertEquals(1L, actualImmutableMetricSample.metricId());
    assertEquals(SampleType.MANUAL, actualImmutableMetricSample.sampleType());
    assertSame(collectionDate, collectionDateResult);
    assertSame(effectiveDate, effectiveDateResult);
  }

  /**
   * Test Builder {@link Builder#collectionDate(LocalDate)}.
   *
   * <ul>
   *   <li>When {@link LocalDate} with {@code 1970} and one and one.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#collectionDate(LocalDate)}
   */
  @Test
  @DisplayName(
      "Test Builder collectionDate(LocalDate); when LocalDate with '1970' and one and one; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.collectionDate(LocalDate)"})
  void testBuilderCollectionDate_whenLocalDateWith1970AndOneAndOne_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricSample.builder();

    // Act
    Builder actualCollectionDateResult = builderResult.collectionDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertSame(builderResult, actualCollectionDateResult);
  }

  /**
   * Test Builder {@link Builder#createdBy(String)}.
   *
   * <ul>
   *   <li>When {@code Jan 1, 2020 8:00am GMT+0100}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#createdBy(String)}
   */
  @Test
  @DisplayName(
      "Test Builder createdBy(String); when 'Jan 1, 2020 8:00am GMT+0100'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.createdBy(String)"})
  void testBuilderCreatedBy_whenJan12020800amGmt0100_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricSample.builder();

    // Act
    Builder actualCreatedByResult = builderResult.createdBy("Jan 1, 2020 8:00am GMT+0100");

    // Assert
    assertSame(builderResult, actualCreatedByResult);
  }

  /**
   * Test Builder {@link Builder#effectiveDate(LocalDate)}.
   *
   * <ul>
   *   <li>When {@link LocalDate} with {@code 1970} and one and one.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#effectiveDate(LocalDate)}
   */
  @Test
  @DisplayName(
      "Test Builder effectiveDate(LocalDate); when LocalDate with '1970' and one and one; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.effectiveDate(LocalDate)"})
  void testBuilderEffectiveDate_whenLocalDateWith1970AndOneAndOne_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricSample.builder();

    // Act
    Builder actualEffectiveDateResult = builderResult.effectiveDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertSame(builderResult, actualEffectiveDateResult);
  }

  /**
   * Test Builder {@link Builder#from(MetricSample)}.
   *
   * <p>Method under test: {@link Builder#from(MetricSample)}
   */
  @Test
  @DisplayName("Test Builder from(MetricSample)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MetricSample)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableMetricSample.builder();
    ImmutableMetricSample instance =
        ImmutableMetricSample.builder()
            .collectionDate(LocalDate.of(1970, 1, 1))
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableMetricSample actualImmutableMetricSample = builderResult.build();
    assertEquals(instance, actualImmutableMetricSample);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#metricId(long)}.
   *
   * <p>Method under test: {@link Builder#metricId(long)}
   */
  @Test
  @DisplayName("Test Builder metricId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.metricId(long)"})
  void testBuilderMetricId() {
    // Arrange
    Builder builderResult = ImmutableMetricSample.builder();

    // Act
    Builder actualMetricIdResult = builderResult.metricId(1L);

    // Assert
    assertSame(builderResult, actualMetricIdResult);
  }

  /**
   * Test Builder {@link Builder#provenance(String)}.
   *
   * <ul>
   *   <li>When {@code Provenance}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#provenance(String)}
   */
  @Test
  @DisplayName("Test Builder provenance(String); when 'Provenance'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.provenance(String)"})
  void testBuilderProvenance_whenProvenance_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricSample.builder();

    // Act
    Builder actualProvenanceResult = builderResult.provenance("Provenance");

    // Assert
    assertSame(builderResult, actualProvenanceResult);
  }

  /**
   * Test Builder {@link Builder#sampleType(SampleType)}.
   *
   * <p>Method under test: {@link Builder#sampleType(SampleType)}
   */
  @Test
  @DisplayName("Test Builder sampleType(SampleType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.sampleType(SampleType)"})
  void testBuilderSampleType() {
    // Arrange
    Builder builderResult = ImmutableMetricSample.builder();

    // Act
    Builder actualSampleTypeResult = builderResult.sampleType(SampleType.MANUAL);

    // Assert
    assertSame(builderResult, actualSampleTypeResult);
  }

  /**
   * Test {@link ImmutableMetricSample#copyOf(MetricSample)}.
   *
   * <ul>
   *   <li>Then return collectionDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricSample#copyOf(MetricSample)}
   */
  @Test
  @DisplayName("Test copyOf(MetricSample); then return collectionDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricSample ImmutableMetricSample.copyOf(MetricSample)"})
  void testCopyOf_thenReturnCollectionDateToStringIs19700101() {
    // Arrange
    LocalDate collectionDate = LocalDate.of(1970, 1, 1);
    LocalDate effectiveDate = LocalDate.of(1970, 1, 1);
    ImmutableMetricSample instance =
        ImmutableMetricSample.builder()
            .collectionDate(collectionDate)
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(effectiveDate)
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build();

    // Act
    ImmutableMetricSample actualCopyOfResult = ImmutableMetricSample.copyOf(instance);

    // Assert
    LocalDate collectionDateResult = actualCopyOfResult.collectionDate();
    assertEquals("1970-01-01", collectionDateResult.toString());
    LocalDate effectiveDateResult = actualCopyOfResult.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCopyOfResult.createdBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.metricId());
    assertEquals(SampleType.MANUAL, actualCopyOfResult.sampleType());
    assertSame(collectionDate, collectionDateResult);
    assertSame(effectiveDate, effectiveDateResult);
  }

  /**
   * Test {@link ImmutableMetricSample#equals(Object)}, and {@link
   * ImmutableMetricSample#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMetricSample#equals(Object)}
   *   <li>{@link ImmutableMetricSample#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricSample.equals(Object)",
    "int ImmutableMetricSample.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableMetricSample immutableMetricSample =
        ImmutableMetricSample.builder()
            .collectionDate(LocalDate.of(1970, 1, 1))
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build();
    ImmutableMetricSample immutableMetricSample2 =
        ImmutableMetricSample.builder()
            .collectionDate(LocalDate.of(1970, 1, 1))
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build();

    // Act and Assert
    assertEquals(immutableMetricSample, immutableMetricSample2);
    assertEquals(immutableMetricSample.hashCode(), immutableMetricSample2.hashCode());
  }

  /**
   * Test {@link ImmutableMetricSample#equals(Object)}, and {@link
   * ImmutableMetricSample#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMetricSample#equals(Object)}
   *   <li>{@link ImmutableMetricSample#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricSample.equals(Object)",
    "int ImmutableMetricSample.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableMetricSample immutableMetricSample =
        ImmutableMetricSample.builder()
            .collectionDate(LocalDate.of(1970, 1, 1))
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build();

    // Act and Assert
    assertEquals(immutableMetricSample, immutableMetricSample);
    int expectedHashCodeResult = immutableMetricSample.hashCode();
    assertEquals(expectedHashCodeResult, immutableMetricSample.hashCode());
  }

  /**
   * Test {@link ImmutableMetricSample#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricSample#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricSample.equals(Object)",
    "int ImmutableMetricSample.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableMetricSample immutableMetricSample =
        ImmutableMetricSample.builder()
            .collectionDate(LocalDate.now())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMetricSample,
        ImmutableMetricSample.builder()
            .collectionDate(LocalDate.of(1970, 1, 1))
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build());
  }

  /**
   * Test {@link ImmutableMetricSample#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricSample#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricSample.equals(Object)",
    "int ImmutableMetricSample.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableMetricSample immutableMetricSample =
        ImmutableMetricSample.builder()
            .collectionDate(LocalDate.of(1970, 1, 1))
            .createdBy("Provenance")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMetricSample,
        ImmutableMetricSample.builder()
            .collectionDate(LocalDate.of(1970, 1, 1))
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build());
  }

  /**
   * Test {@link ImmutableMetricSample#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricSample#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricSample.equals(Object)",
    "int ImmutableMetricSample.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableMetricSample immutableMetricSample =
        ImmutableMetricSample.builder()
            .collectionDate(LocalDate.of(1970, 1, 1))
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(LocalDate.now())
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMetricSample,
        ImmutableMetricSample.builder()
            .collectionDate(LocalDate.of(1970, 1, 1))
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build());
  }

  /**
   * Test {@link ImmutableMetricSample#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricSample#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricSample.equals(Object)",
    "int ImmutableMetricSample.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableMetricSample immutableMetricSample =
        ImmutableMetricSample.builder()
            .collectionDate(LocalDate.of(1970, 1, 1))
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .metricId(2L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMetricSample,
        ImmutableMetricSample.builder()
            .collectionDate(LocalDate.of(1970, 1, 1))
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build());
  }

  /**
   * Test {@link ImmutableMetricSample#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricSample#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricSample.equals(Object)",
    "int ImmutableMetricSample.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableMetricSample immutableMetricSample =
        ImmutableMetricSample.builder()
            .collectionDate(LocalDate.of(1970, 1, 1))
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .metricId(1L)
            .provenance("Jan 1, 2020 8:00am GMT+0100")
            .sampleType(SampleType.MANUAL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMetricSample,
        ImmutableMetricSample.builder()
            .collectionDate(LocalDate.of(1970, 1, 1))
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build());
  }

  /**
   * Test {@link ImmutableMetricSample#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricSample#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricSample.equals(Object)",
    "int ImmutableMetricSample.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableMetricSample immutableMetricSample =
        ImmutableMetricSample.builder()
            .collectionDate(LocalDate.of(1970, 1, 1))
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.AUTOMATED)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMetricSample,
        ImmutableMetricSample.builder()
            .collectionDate(LocalDate.of(1970, 1, 1))
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build());
  }

  /**
   * Test {@link ImmutableMetricSample#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricSample#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricSample.equals(Object)",
    "int ImmutableMetricSample.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMetricSample.builder()
            .collectionDate(LocalDate.of(1970, 1, 1))
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableMetricSample#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricSample#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricSample.equals(Object)",
    "int ImmutableMetricSample.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMetricSample.builder()
            .collectionDate(LocalDate.of(1970, 1, 1))
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build(),
        "Different type to ImmutableMetricSample");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMetricSample#toString()}
   *   <li>{@link ImmutableMetricSample#collectionDate()}
   *   <li>{@link ImmutableMetricSample#createdBy()}
   *   <li>{@link ImmutableMetricSample#effectiveDate()}
   *   <li>{@link ImmutableMetricSample#metricId()}
   *   <li>{@link ImmutableMetricSample#provenance()}
   *   <li>{@link ImmutableMetricSample#sampleType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalDate ImmutableMetricSample.collectionDate()",
    "String ImmutableMetricSample.createdBy()",
    "LocalDate ImmutableMetricSample.effectiveDate()",
    "long ImmutableMetricSample.metricId()",
    "String ImmutableMetricSample.provenance()",
    "SampleType ImmutableMetricSample.sampleType()",
    "String ImmutableMetricSample.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    LocalDate collectionDate = LocalDate.of(1970, 1, 1);
    LocalDate effectiveDate = LocalDate.of(1970, 1, 1);
    ImmutableMetricSample immutableMetricSample =
        ImmutableMetricSample.builder()
            .collectionDate(collectionDate)
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(effectiveDate)
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build();

    // Act
    String actualToStringResult = immutableMetricSample.toString();
    LocalDate actualCollectionDateResult = immutableMetricSample.collectionDate();
    String actualCreatedByResult = immutableMetricSample.createdBy();
    LocalDate actualEffectiveDateResult = immutableMetricSample.effectiveDate();
    long actualMetricIdResult = immutableMetricSample.metricId();
    String actualProvenanceResult = immutableMetricSample.provenance();

    // Assert
    assertEquals("1970-01-01", actualCollectionDateResult.toString());
    assertEquals("1970-01-01", actualEffectiveDateResult.toString());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedByResult);
    assertEquals(
        "MetricSample{metricId=1, collectionDate=1970-01-01, effectiveDate=1970-01-01, sampleType=MANUAL,"
            + " createdBy=Jan 1, 2020 8:00am GMT+0100, provenance=Provenance}",
        actualToStringResult);
    assertEquals("Provenance", actualProvenanceResult);
    assertEquals(1L, actualMetricIdResult);
    assertEquals(SampleType.MANUAL, immutableMetricSample.sampleType());
    assertSame(collectionDate, actualCollectionDateResult);
    assertSame(effectiveDate, actualEffectiveDateResult);
  }

  /**
   * Test Json {@link Json#collectionDate()}.
   *
   * <p>Method under test: {@link Json#collectionDate()}
   */
  @Test
  @DisplayName("Test Json collectionDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDate Json.collectionDate()"})
  void testJsonCollectionDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().collectionDate());
  }

  /**
   * Test Json {@link Json#createdBy()}.
   *
   * <p>Method under test: {@link Json#createdBy()}
   */
  @Test
  @DisplayName("Test Json createdBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.createdBy()"})
  void testJsonCreatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().createdBy());
  }

  /**
   * Test Json {@link Json#effectiveDate()}.
   *
   * <p>Method under test: {@link Json#effectiveDate()}
   */
  @Test
  @DisplayName("Test Json effectiveDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDate Json.effectiveDate()"})
  void testJsonEffectiveDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().effectiveDate());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setCollectionDate(LocalDate)",
    "void Json.setCreatedBy(String)",
    "void Json.setEffectiveDate(LocalDate)",
    "void Json.setProvenance(String)",
    "void Json.setSampleType(SampleType)"
  })
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
   *
   * <p>Method under test: {@link Json#metricId()}
   */
  @Test
  @DisplayName("Test Json metricId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.metricId()"})
  void testJsonMetricId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().metricId());
  }

  /**
   * Test Json {@link Json#provenance()}.
   *
   * <p>Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().provenance());
  }

  /**
   * Test Json {@link Json#sampleType()}.
   *
   * <p>Method under test: {@link Json#sampleType()}
   */
  @Test
  @DisplayName("Test Json sampleType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SampleType Json.sampleType()"})
  void testJsonSampleType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().sampleType());
  }

  /**
   * Test Json {@link Json#setMetricId(long)}.
   *
   * <p>Method under test: {@link Json#setMetricId(long)}
   */
  @Test
  @DisplayName("Test Json setMetricId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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

  /**
   * Test {@link ImmutableMetricSample#withCollectionDate(LocalDate)}.
   *
   * <p>Method under test: {@link ImmutableMetricSample#withCollectionDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withCollectionDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricSample ImmutableMetricSample.withCollectionDate(LocalDate)"})
  void testWithCollectionDate() {
    // Arrange
    ImmutableMetricSample immutableMetricSample =
        ImmutableMetricSample.builder()
            .collectionDate(LocalDate.of(1970, 1, 1))
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build();

    // Act
    ImmutableMetricSample actualWithCollectionDateResult =
        immutableMetricSample.withCollectionDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableMetricSample, actualWithCollectionDateResult);
  }

  /**
   * Test {@link ImmutableMetricSample#withCreatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableMetricSample#withCreatedBy(String)}
   */
  @Test
  @DisplayName("Test withCreatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricSample ImmutableMetricSample.withCreatedBy(String)"})
  void testWithCreatedBy() {
    // Arrange
    ImmutableMetricSample immutableMetricSample =
        ImmutableMetricSample.builder()
            .collectionDate(LocalDate.of(1970, 1, 1))
            .createdBy("42")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build();

    // Act
    ImmutableMetricSample actualWithCreatedByResult = immutableMetricSample.withCreatedBy("42");

    // Assert
    assertSame(immutableMetricSample, actualWithCreatedByResult);
  }

  /**
   * Test {@link ImmutableMetricSample#withCreatedBy(String)}.
   *
   * <ul>
   *   <li>Then return collectionDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricSample#withCreatedBy(String)}
   */
  @Test
  @DisplayName("Test withCreatedBy(String); then return collectionDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricSample ImmutableMetricSample.withCreatedBy(String)"})
  void testWithCreatedBy_thenReturnCollectionDateToStringIs19700101() {
    // Arrange
    LocalDate collectionDate = LocalDate.of(1970, 1, 1);
    LocalDate effectiveDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMetricSample actualWithCreatedByResult =
        ImmutableMetricSample.builder()
            .collectionDate(collectionDate)
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(effectiveDate)
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build()
            .withCreatedBy("42");

    // Assert
    LocalDate collectionDateResult = actualWithCreatedByResult.collectionDate();
    assertEquals("1970-01-01", collectionDateResult.toString());
    LocalDate effectiveDateResult = actualWithCreatedByResult.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("42", actualWithCreatedByResult.createdBy());
    assertEquals("Provenance", actualWithCreatedByResult.provenance());
    assertEquals(1L, actualWithCreatedByResult.metricId());
    assertEquals(SampleType.MANUAL, actualWithCreatedByResult.sampleType());
    assertSame(collectionDate, collectionDateResult);
    assertSame(effectiveDate, effectiveDateResult);
  }

  /**
   * Test {@link ImmutableMetricSample#withEffectiveDate(LocalDate)}.
   *
   * <p>Method under test: {@link ImmutableMetricSample#withEffectiveDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withEffectiveDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricSample ImmutableMetricSample.withEffectiveDate(LocalDate)"})
  void testWithEffectiveDate() {
    // Arrange
    ImmutableMetricSample immutableMetricSample =
        ImmutableMetricSample.builder()
            .collectionDate(LocalDate.of(1970, 1, 1))
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build();

    // Act
    ImmutableMetricSample actualWithEffectiveDateResult =
        immutableMetricSample.withEffectiveDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableMetricSample, actualWithEffectiveDateResult);
  }

  /**
   * Test {@link ImmutableMetricSample#withMetricId(long)}.
   *
   * <p>Method under test: {@link ImmutableMetricSample#withMetricId(long)}
   */
  @Test
  @DisplayName("Test withMetricId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricSample ImmutableMetricSample.withMetricId(long)"})
  void testWithMetricId() {
    // Arrange
    ImmutableMetricSample immutableMetricSample =
        ImmutableMetricSample.builder()
            .collectionDate(LocalDate.of(1970, 1, 1))
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .metricId(42L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build();

    // Act
    ImmutableMetricSample actualWithMetricIdResult = immutableMetricSample.withMetricId(42L);

    // Assert
    assertSame(immutableMetricSample, actualWithMetricIdResult);
  }

  /**
   * Test {@link ImmutableMetricSample#withMetricId(long)}.
   *
   * <ul>
   *   <li>Then return collectionDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricSample#withMetricId(long)}
   */
  @Test
  @DisplayName("Test withMetricId(long); then return collectionDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricSample ImmutableMetricSample.withMetricId(long)"})
  void testWithMetricId_thenReturnCollectionDateToStringIs19700101() {
    // Arrange
    LocalDate collectionDate = LocalDate.of(1970, 1, 1);
    LocalDate effectiveDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMetricSample actualWithMetricIdResult =
        ImmutableMetricSample.builder()
            .collectionDate(collectionDate)
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(effectiveDate)
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build()
            .withMetricId(42L);

    // Assert
    LocalDate collectionDateResult = actualWithMetricIdResult.collectionDate();
    assertEquals("1970-01-01", collectionDateResult.toString());
    LocalDate effectiveDateResult = actualWithMetricIdResult.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualWithMetricIdResult.createdBy());
    assertEquals("Provenance", actualWithMetricIdResult.provenance());
    assertEquals(42L, actualWithMetricIdResult.metricId());
    assertEquals(SampleType.MANUAL, actualWithMetricIdResult.sampleType());
    assertSame(collectionDate, collectionDateResult);
    assertSame(effectiveDate, effectiveDateResult);
  }

  /**
   * Test {@link ImmutableMetricSample#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableMetricSample#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricSample ImmutableMetricSample.withProvenance(String)"})
  void testWithProvenance() {
    // Arrange
    ImmutableMetricSample immutableMetricSample =
        ImmutableMetricSample.builder()
            .collectionDate(LocalDate.of(1970, 1, 1))
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .metricId(1L)
            .provenance("42")
            .sampleType(SampleType.MANUAL)
            .build();

    // Act
    ImmutableMetricSample actualWithProvenanceResult = immutableMetricSample.withProvenance("42");

    // Assert
    assertSame(immutableMetricSample, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableMetricSample#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return collectionDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricSample#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then return collectionDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricSample ImmutableMetricSample.withProvenance(String)"})
  void testWithProvenance_thenReturnCollectionDateToStringIs19700101() {
    // Arrange
    LocalDate collectionDate = LocalDate.of(1970, 1, 1);
    LocalDate effectiveDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMetricSample actualWithProvenanceResult =
        ImmutableMetricSample.builder()
            .collectionDate(collectionDate)
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(effectiveDate)
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build()
            .withProvenance("42");

    // Assert
    LocalDate collectionDateResult = actualWithProvenanceResult.collectionDate();
    assertEquals("1970-01-01", collectionDateResult.toString());
    LocalDate effectiveDateResult = actualWithProvenanceResult.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualWithProvenanceResult.createdBy());
    assertEquals(1L, actualWithProvenanceResult.metricId());
    assertEquals(SampleType.MANUAL, actualWithProvenanceResult.sampleType());
    assertSame(collectionDate, collectionDateResult);
    assertSame(effectiveDate, effectiveDateResult);
  }

  /**
   * Test {@link ImmutableMetricSample#withSampleType(SampleType)}.
   *
   * <p>Method under test: {@link ImmutableMetricSample#withSampleType(SampleType)}
   */
  @Test
  @DisplayName("Test withSampleType(SampleType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricSample ImmutableMetricSample.withSampleType(SampleType)"})
  void testWithSampleType() {
    // Arrange
    ImmutableMetricSample immutableMetricSample =
        ImmutableMetricSample.builder()
            .collectionDate(LocalDate.of(1970, 1, 1))
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.MANUAL)
            .build();

    // Act
    ImmutableMetricSample actualWithSampleTypeResult =
        immutableMetricSample.withSampleType(SampleType.MANUAL);

    // Assert
    assertSame(immutableMetricSample, actualWithSampleTypeResult);
  }

  /**
   * Test {@link ImmutableMetricSample#withSampleType(SampleType)}.
   *
   * <ul>
   *   <li>Then return collectionDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricSample#withSampleType(SampleType)}
   */
  @Test
  @DisplayName(
      "Test withSampleType(SampleType); then return collectionDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricSample ImmutableMetricSample.withSampleType(SampleType)"})
  void testWithSampleType_thenReturnCollectionDateToStringIs19700101() {
    // Arrange
    LocalDate collectionDate = LocalDate.of(1970, 1, 1);
    LocalDate effectiveDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMetricSample actualWithSampleTypeResult =
        ImmutableMetricSample.builder()
            .collectionDate(collectionDate)
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .effectiveDate(effectiveDate)
            .metricId(1L)
            .provenance("Provenance")
            .sampleType(SampleType.AUTOMATED)
            .build()
            .withSampleType(SampleType.MANUAL);

    // Assert
    LocalDate collectionDateResult = actualWithSampleTypeResult.collectionDate();
    assertEquals("1970-01-01", collectionDateResult.toString());
    LocalDate effectiveDateResult = actualWithSampleTypeResult.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualWithSampleTypeResult.createdBy());
    assertEquals("Provenance", actualWithSampleTypeResult.provenance());
    assertEquals(1L, actualWithSampleTypeResult.metricId());
    assertEquals(SampleType.MANUAL, actualWithSampleTypeResult.sampleType());
    assertSame(collectionDate, collectionDateResult);
    assertSame(effectiveDate, effectiveDateResult);
  }
}
