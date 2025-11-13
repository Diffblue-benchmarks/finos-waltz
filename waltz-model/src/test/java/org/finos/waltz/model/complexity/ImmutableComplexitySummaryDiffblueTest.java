package org.finos.waltz.model.complexity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.complexity.ImmutableComplexitySummary.Builder;
import org.finos.waltz.model.complexity.ImmutableComplexitySummary.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableComplexitySummaryDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllTopComplexityScores(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllTopComplexityScores(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllTopComplexityScores(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllTopComplexityScores(Iterable)"})
  void testBuilderAddAllTopComplexityScores_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    // Act
    Builder actualAddAllTopComplexityScoresResult =
        builderResult.addAllTopComplexityScores(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllTopComplexityScoresResult);
  }

  /**
   * Test Builder {@link Builder#addTopComplexityScores(Complexity)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableComplexity.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addTopComplexityScores(Complexity)}
   */
  @Test
  @DisplayName(
      "Test Builder addTopComplexityScores(Complexity) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addTopComplexityScores(Complexity)"})
  void testBuilderAddTopComplexityScoresWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    // Act
    Builder actualAddTopComplexityScoresResult =
        builderResult.addTopComplexityScores(new ImmutableComplexity.Json());

    // Assert
    assertSame(builderResult, actualAddTopComplexityScoresResult);
  }

  /**
   * Test Builder {@link Builder#addTopComplexityScores(Complexity[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableComplexity.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addTopComplexityScores(Complexity[])}
   */
  @Test
  @DisplayName(
      "Test Builder addTopComplexityScores(Complexity[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addTopComplexityScores(Complexity[])"})
  void testBuilderAddTopComplexityScoresWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    // Act
    Builder actualAddTopComplexityScoresResult =
        builderResult.addTopComplexityScores(new ImmutableComplexity.Json());

    // Assert
    assertSame(builderResult, actualAddTopComplexityScoresResult);
  }

  /**
   * Test Builder {@link Builder#average(BigDecimal)}.
   *
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#average(BigDecimal)}
   */
  @Test
  @DisplayName(
      "Test Builder average(BigDecimal); when BigDecimal(String) with '2.3'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.average(BigDecimal)"})
  void testBuilderAverage_whenBigDecimalWith23_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    // Act
    Builder actualAverageResult = builderResult.average(new BigDecimal("2.3"));

    // Assert
    assertSame(builderResult, actualAverageResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexitySummary Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableComplexitySummary.builder();
    BigDecimal average = new BigDecimal("2.3");
    Builder actualAverageResult = actualBuilderResult.average(average);
    ImmutableComplexityKind complexityKind =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualMappedCountResult =
        actualAverageResult.complexityKind(complexityKind).mappedCount(3);
    BigDecimal median = new BigDecimal("2.3");
    Builder actualMissingCountResult = actualMappedCountResult.median(median).missingCount(3);
    BigDecimal standardDeviation = new BigDecimal("2.3");
    Builder actualStandardDeviationResult =
        actualMissingCountResult.standardDeviation(standardDeviation);
    BigDecimal total = new BigDecimal("2.3");
    Builder actualTotalResult = actualStandardDeviationResult.total(total);
    BigDecimal variance = new BigDecimal("2.3");
    ImmutableComplexitySummary actualImmutableComplexitySummary =
        actualTotalResult.variance(variance).build();

    // Assert
    assertEquals(3, actualImmutableComplexitySummary.mappedCount());
    assertEquals(3, actualImmutableComplexitySummary.missingCount());
    assertTrue(actualImmutableComplexitySummary.topComplexityScores().isEmpty());
    BigDecimal expectedAverageResult = new BigDecimal("2.3");
    BigDecimal averageResult = actualImmutableComplexitySummary.average();
    assertEquals(expectedAverageResult, averageResult);
    BigDecimal expectedMedianResult = new BigDecimal("2.3");
    BigDecimal medianResult = actualImmutableComplexitySummary.median();
    assertEquals(expectedMedianResult, medianResult);
    BigDecimal expectedStandardDeviationResult = new BigDecimal("2.3");
    BigDecimal standardDeviationResult = actualImmutableComplexitySummary.standardDeviation();
    assertEquals(expectedStandardDeviationResult, standardDeviationResult);
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    BigDecimal totalResult = actualImmutableComplexitySummary.total();
    assertEquals(expectedTotalResult, totalResult);
    BigDecimal expectedVarianceResult = new BigDecimal("2.3");
    BigDecimal varianceResult = actualImmutableComplexitySummary.variance();
    assertEquals(expectedVarianceResult, varianceResult);
    assertSame(average, averageResult);
    assertSame(median, medianResult);
    assertSame(standardDeviation, standardDeviationResult);
    assertSame(total, totalResult);
    assertSame(variance, varianceResult);
    assertSame(complexityKind, actualImmutableComplexitySummary.complexityKind());
  }

  /**
   * Test Builder {@link Builder#complexityKind(ComplexityKind)}.
   *
   * <ul>
   *   <li>When {@link ImmutableComplexityKind.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#complexityKind(ComplexityKind)}
   */
  @Test
  @DisplayName(
      "Test Builder complexityKind(ComplexityKind); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.complexityKind(ComplexityKind)"})
  void testBuilderComplexityKind_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    // Act
    Builder actualComplexityKindResult =
        builderResult.complexityKind(new ImmutableComplexityKind.Json());

    // Assert
    assertSame(builderResult, actualComplexityKindResult);
  }

  /**
   * Test Builder {@link Builder#from(ComplexitySummary)}.
   *
   * <p>Method under test: {@link Builder#from(ComplexitySummary)}
   */
  @Test
  @DisplayName("Test Builder from(ComplexitySummary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ComplexitySummary)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder builderResult2 = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult2.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary instance = totalResult.variance(new BigDecimal("2.3")).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableComplexitySummary actualImmutableComplexitySummary = builderResult.build();
    assertEquals(instance, actualImmutableComplexitySummary);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ComplexitySummary)}.
   *
   * <ul>
   *   <li>Then return build topComplexityScores size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ComplexitySummary)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ComplexitySummary); then return build topComplexityScores size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ComplexitySummary)"})
  void testBuilderFrom_thenReturnBuildTopComplexityScoresSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder builderResult2 = ImmutableComplexitySummary.builder();

    ImmutableComplexity.Builder complexityKindIdResult =
        ImmutableComplexity.builder().complexityKindId(1L);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    ImmutableComplexity.Builder provenanceResult =
        complexityKindIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    builderResult2.addTopComplexityScores(provenanceResult.score(new BigDecimal("2.3")).build());

    Builder averageResult = builderResult2.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));

    // Act and Assert
    List<Complexity> topComplexityScoresResult =
        builderResult
            .from(totalResult.variance(new BigDecimal("2.3")).build())
            .build()
            .topComplexityScores();
    assertEquals(1, topComplexityScoresResult.size());
    Complexity getResult = topComplexityScoresResult.get(0);
    EntityReference entityReferenceResult = getResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableComplexity);
    assertEquals("2020-03-01", getResult.lastUpdatedBy());
    assertEquals("Provenance", getResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, getResult.complexityKindId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityKind.ALL, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    BigDecimal expectedScoreResult = new BigDecimal("2.3");
    assertEquals(expectedScoreResult, getResult.score());
    assertSame(ofResult, getResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test Builder {@link Builder#mappedCount(int)}.
   *
   * <p>Method under test: {@link Builder#mappedCount(int)}
   */
  @Test
  @DisplayName("Test Builder mappedCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.mappedCount(int)"})
  void testBuilderMappedCount() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    // Act
    Builder actualMappedCountResult = builderResult.mappedCount(3);

    // Assert
    assertSame(builderResult, actualMappedCountResult);
  }

  /**
   * Test Builder {@link Builder#median(BigDecimal)}.
   *
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#median(BigDecimal)}
   */
  @Test
  @DisplayName(
      "Test Builder median(BigDecimal); when BigDecimal(String) with '2.3'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.median(BigDecimal)"})
  void testBuilderMedian_whenBigDecimalWith23_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    // Act
    Builder actualMedianResult = builderResult.median(new BigDecimal("2.3"));

    // Assert
    assertSame(builderResult, actualMedianResult);
  }

  /**
   * Test Builder {@link Builder#missingCount(int)}.
   *
   * <p>Method under test: {@link Builder#missingCount(int)}
   */
  @Test
  @DisplayName("Test Builder missingCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.missingCount(int)"})
  void testBuilderMissingCount() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    // Act
    Builder actualMissingCountResult = builderResult.missingCount(3);

    // Assert
    assertSame(builderResult, actualMissingCountResult);
  }

  /**
   * Test Builder {@link Builder#standardDeviation(BigDecimal)}.
   *
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#standardDeviation(BigDecimal)}
   */
  @Test
  @DisplayName(
      "Test Builder standardDeviation(BigDecimal); when BigDecimal(String) with '2.3'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.standardDeviation(BigDecimal)"})
  void testBuilderStandardDeviation_whenBigDecimalWith23_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    // Act
    Builder actualStandardDeviationResult = builderResult.standardDeviation(new BigDecimal("2.3"));

    // Assert
    assertSame(builderResult, actualStandardDeviationResult);
  }

  /**
   * Test Builder {@link Builder#topComplexityScores(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#topComplexityScores(Iterable)}
   */
  @Test
  @DisplayName("Test Builder topComplexityScores(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.topComplexityScores(Iterable)"})
  void testBuilderTopComplexityScores_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    // Act
    Builder actualTopComplexityScoresResult = builderResult.topComplexityScores(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualTopComplexityScoresResult);
  }

  /**
   * Test Builder {@link Builder#total(BigDecimal)}.
   *
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#total(BigDecimal)}
   */
  @Test
  @DisplayName(
      "Test Builder total(BigDecimal); when BigDecimal(String) with '2.3'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.total(BigDecimal)"})
  void testBuilderTotal_whenBigDecimalWith23_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    // Act
    Builder actualTotalResult = builderResult.total(new BigDecimal("2.3"));

    // Assert
    assertSame(builderResult, actualTotalResult);
  }

  /**
   * Test Builder {@link Builder#variance(BigDecimal)}.
   *
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#variance(BigDecimal)}
   */
  @Test
  @DisplayName(
      "Test Builder variance(BigDecimal); when BigDecimal(String) with '2.3'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.variance(BigDecimal)"})
  void testBuilderVariance_whenBigDecimalWith23_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    // Act
    Builder actualVarianceResult = builderResult.variance(new BigDecimal("2.3"));

    // Assert
    assertSame(builderResult, actualVarianceResult);
  }

  /**
   * Test {@link ImmutableComplexitySummary#copyOf(ComplexitySummary)}.
   *
   * <ul>
   *   <li>Then complexityKind return {@link ImmutableComplexityKind}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#copyOf(ComplexitySummary)}
   */
  @Test
  @DisplayName("Test copyOf(ComplexitySummary); then complexityKind return ImmutableComplexityKind")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexitySummary ImmutableComplexitySummary.copyOf(ComplexitySummary)"
  })
  void testCopyOf_thenComplexityKindReturnImmutableComplexityKind() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary instance = totalResult.variance(new BigDecimal("2.3")).build();

    // Act
    ImmutableComplexitySummary actualCopyOfResult = ImmutableComplexitySummary.copyOf(instance);

    // Assert
    ComplexityKind complexityKindResult = actualCopyOfResult.complexityKind();
    assertTrue(complexityKindResult instanceof ImmutableComplexityKind);
    assertEquals("Name", complexityKindResult.name());
    assertEquals("The characteristics of someone or something", complexityKindResult.description());
    assertEquals(3, actualCopyOfResult.mappedCount());
    assertEquals(3, actualCopyOfResult.missingCount());
    assertEquals(EntityKind.ALL, complexityKindResult.kind());
    assertTrue(actualCopyOfResult.topComplexityScores().isEmpty());
    assertTrue(complexityKindResult.isDefault());
    BigDecimal expectedAverageResult = new BigDecimal("2.3");
    assertEquals(expectedAverageResult, actualCopyOfResult.average());
    BigDecimal expectedMedianResult = new BigDecimal("2.3");
    assertEquals(expectedMedianResult, actualCopyOfResult.median());
    BigDecimal expectedStandardDeviationResult = new BigDecimal("2.3");
    assertEquals(expectedStandardDeviationResult, actualCopyOfResult.standardDeviation());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualCopyOfResult.total());
    BigDecimal expectedVarianceResult = new BigDecimal("2.3");
    assertEquals(expectedVarianceResult, actualCopyOfResult.variance());
  }

  /**
   * Test {@link ImmutableComplexitySummary#equals(Object)}, and {@link
   * ImmutableComplexitySummary#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableComplexitySummary#equals(Object)}
   *   <li>{@link ImmutableComplexitySummary#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexitySummary.equals(Object)",
    "int ImmutableComplexitySummary.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary immutableComplexitySummary =
        totalResult.variance(new BigDecimal("2.3")).build();

    Builder builderResult2 = ImmutableComplexitySummary.builder();

    Builder averageResult2 = builderResult2.average(new BigDecimal("2.3"));

    Builder mappedCountResult2 =
        averageResult2
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult2 = mappedCountResult2.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult2 = missingCountResult2.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult2 = standardDeviationResult2.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary immutableComplexitySummary2 =
        totalResult2.variance(new BigDecimal("2.3")).build();

    // Act and Assert
    assertEquals(immutableComplexitySummary, immutableComplexitySummary2);
    assertEquals(immutableComplexitySummary.hashCode(), immutableComplexitySummary2.hashCode());
  }

  /**
   * Test {@link ImmutableComplexitySummary#equals(Object)}, and {@link
   * ImmutableComplexitySummary#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableComplexitySummary#equals(Object)}
   *   <li>{@link ImmutableComplexitySummary#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexitySummary.equals(Object)",
    "int ImmutableComplexitySummary.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary immutableComplexitySummary =
        totalResult.variance(new BigDecimal("2.3")).build();

    // Act and Assert
    assertEquals(immutableComplexitySummary, immutableComplexitySummary);
    int expectedHashCodeResult = immutableComplexitySummary.hashCode();
    assertEquals(expectedHashCodeResult, immutableComplexitySummary.hashCode());
  }

  /**
   * Test {@link ImmutableComplexitySummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexitySummary.equals(Object)",
    "int ImmutableComplexitySummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    ImmutableComplexity.Builder complexityKindIdResult =
        ImmutableComplexity.builder().complexityKindId(1L);

    ImmutableComplexity.Builder provenanceResult =
        complexityKindIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    builderResult.addTopComplexityScores(provenanceResult.score(new BigDecimal("2.3")).build());

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary immutableComplexitySummary =
        totalResult.variance(new BigDecimal("2.3")).build();

    Builder builderResult2 = ImmutableComplexitySummary.builder();

    Builder averageResult2 = builderResult2.average(new BigDecimal("2.3"));

    Builder mappedCountResult2 =
        averageResult2
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult2 = mappedCountResult2.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult2 = missingCountResult2.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult2 = standardDeviationResult2.total(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableComplexitySummary, totalResult2.variance(new BigDecimal("2.3")).build());
  }

  /**
   * Test {@link ImmutableComplexitySummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexitySummary.equals(Object)",
    "int ImmutableComplexitySummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("4.5"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary immutableComplexitySummary =
        totalResult.variance(new BigDecimal("2.3")).build();

    Builder builderResult2 = ImmutableComplexitySummary.builder();

    Builder averageResult2 = builderResult2.average(new BigDecimal("2.3"));

    Builder mappedCountResult2 =
        averageResult2
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult2 = mappedCountResult2.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult2 = missingCountResult2.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult2 = standardDeviationResult2.total(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableComplexitySummary, totalResult2.variance(new BigDecimal("2.3")).build());
  }

  /**
   * Test {@link ImmutableComplexitySummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexitySummary.equals(Object)",
    "int ImmutableComplexitySummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("Name")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary immutableComplexitySummary =
        totalResult.variance(new BigDecimal("2.3")).build();

    Builder builderResult2 = ImmutableComplexitySummary.builder();

    Builder averageResult2 = builderResult2.average(new BigDecimal("2.3"));

    Builder mappedCountResult2 =
        averageResult2
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult2 = mappedCountResult2.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult2 = missingCountResult2.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult2 = standardDeviationResult2.total(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableComplexitySummary, totalResult2.variance(new BigDecimal("2.3")).build());
  }

  /**
   * Test {@link ImmutableComplexitySummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexitySummary.equals(Object)",
    "int ImmutableComplexitySummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(1);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary immutableComplexitySummary =
        totalResult.variance(new BigDecimal("2.3")).build();

    Builder builderResult2 = ImmutableComplexitySummary.builder();

    Builder averageResult2 = builderResult2.average(new BigDecimal("2.3"));

    Builder mappedCountResult2 =
        averageResult2
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult2 = mappedCountResult2.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult2 = missingCountResult2.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult2 = standardDeviationResult2.total(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableComplexitySummary, totalResult2.variance(new BigDecimal("2.3")).build());
  }

  /**
   * Test {@link ImmutableComplexitySummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexitySummary.equals(Object)",
    "int ImmutableComplexitySummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("4.5")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary immutableComplexitySummary =
        totalResult.variance(new BigDecimal("2.3")).build();

    Builder builderResult2 = ImmutableComplexitySummary.builder();

    Builder averageResult2 = builderResult2.average(new BigDecimal("2.3"));

    Builder mappedCountResult2 =
        averageResult2
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult2 = mappedCountResult2.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult2 = missingCountResult2.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult2 = standardDeviationResult2.total(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableComplexitySummary, totalResult2.variance(new BigDecimal("2.3")).build());
  }

  /**
   * Test {@link ImmutableComplexitySummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexitySummary.equals(Object)",
    "int ImmutableComplexitySummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(1);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary immutableComplexitySummary =
        totalResult.variance(new BigDecimal("2.3")).build();

    Builder builderResult2 = ImmutableComplexitySummary.builder();

    Builder averageResult2 = builderResult2.average(new BigDecimal("2.3"));

    Builder mappedCountResult2 =
        averageResult2
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult2 = mappedCountResult2.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult2 = missingCountResult2.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult2 = standardDeviationResult2.total(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableComplexitySummary, totalResult2.variance(new BigDecimal("2.3")).build());
  }

  /**
   * Test {@link ImmutableComplexitySummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexitySummary.equals(Object)",
    "int ImmutableComplexitySummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("4.5"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary immutableComplexitySummary =
        totalResult.variance(new BigDecimal("2.3")).build();

    Builder builderResult2 = ImmutableComplexitySummary.builder();

    Builder averageResult2 = builderResult2.average(new BigDecimal("2.3"));

    Builder mappedCountResult2 =
        averageResult2
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult2 = mappedCountResult2.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult2 = missingCountResult2.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult2 = standardDeviationResult2.total(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableComplexitySummary, totalResult2.variance(new BigDecimal("2.3")).build());
  }

  /**
   * Test {@link ImmutableComplexitySummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexitySummary.equals(Object)",
    "int ImmutableComplexitySummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("4.5"));
    ImmutableComplexitySummary immutableComplexitySummary =
        totalResult.variance(new BigDecimal("2.3")).build();

    Builder builderResult2 = ImmutableComplexitySummary.builder();

    Builder averageResult2 = builderResult2.average(new BigDecimal("2.3"));

    Builder mappedCountResult2 =
        averageResult2
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult2 = mappedCountResult2.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult2 = missingCountResult2.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult2 = standardDeviationResult2.total(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableComplexitySummary, totalResult2.variance(new BigDecimal("2.3")).build());
  }

  /**
   * Test {@link ImmutableComplexitySummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexitySummary.equals(Object)",
    "int ImmutableComplexitySummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary immutableComplexitySummary =
        totalResult.variance(new BigDecimal("4.5")).build();

    Builder builderResult2 = ImmutableComplexitySummary.builder();

    Builder averageResult2 = builderResult2.average(new BigDecimal("2.3"));

    Builder mappedCountResult2 =
        averageResult2
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult2 = mappedCountResult2.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult2 = missingCountResult2.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult2 = standardDeviationResult2.total(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableComplexitySummary, totalResult2.variance(new BigDecimal("2.3")).build());
  }

  /**
   * Test {@link ImmutableComplexitySummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexitySummary.equals(Object)",
    "int ImmutableComplexitySummary.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(totalResult.variance(new BigDecimal("2.3")).build(), null);
  }

  /**
   * Test {@link ImmutableComplexitySummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexitySummary.equals(Object)",
    "int ImmutableComplexitySummary.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        totalResult.variance(new BigDecimal("2.3")).build(),
        "Different type to ImmutableComplexitySummary");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableComplexitySummary#toString()}
   *   <li>{@link ImmutableComplexitySummary#average()}
   *   <li>{@link ImmutableComplexitySummary#complexityKind()}
   *   <li>{@link ImmutableComplexitySummary#mappedCount()}
   *   <li>{@link ImmutableComplexitySummary#median()}
   *   <li>{@link ImmutableComplexitySummary#missingCount()}
   *   <li>{@link ImmutableComplexitySummary#standardDeviation()}
   *   <li>{@link ImmutableComplexitySummary#topComplexityScores()}
   *   <li>{@link ImmutableComplexitySummary#total()}
   *   <li>{@link ImmutableComplexitySummary#variance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal ImmutableComplexitySummary.average()",
    "ComplexityKind ImmutableComplexitySummary.complexityKind()",
    "int ImmutableComplexitySummary.mappedCount()",
    "BigDecimal ImmutableComplexitySummary.median()",
    "int ImmutableComplexitySummary.missingCount()",
    "BigDecimal ImmutableComplexitySummary.standardDeviation()",
    "String ImmutableComplexitySummary.toString()",
    "List ImmutableComplexitySummary.topComplexityScores()",
    "BigDecimal ImmutableComplexitySummary.total()",
    "BigDecimal ImmutableComplexitySummary.variance()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();
    BigDecimal average = new BigDecimal("2.3");

    Builder averageResult = builderResult.average(average);

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);
    BigDecimal median = new BigDecimal("2.3");

    Builder missingCountResult = mappedCountResult.median(median).missingCount(3);
    BigDecimal standardDeviation = new BigDecimal("2.3");

    Builder standardDeviationResult = missingCountResult.standardDeviation(standardDeviation);
    BigDecimal total = new BigDecimal("2.3");

    Builder totalResult = standardDeviationResult.total(total);
    BigDecimal variance = new BigDecimal("2.3");
    ImmutableComplexitySummary immutableComplexitySummary = totalResult.variance(variance).build();

    // Act
    String actualToStringResult = immutableComplexitySummary.toString();
    BigDecimal actualAverageResult = immutableComplexitySummary.average();
    ComplexityKind actualComplexityKindResult = immutableComplexitySummary.complexityKind();
    int actualMappedCountResult = immutableComplexitySummary.mappedCount();
    BigDecimal actualMedianResult = immutableComplexitySummary.median();
    int actualMissingCountResult = immutableComplexitySummary.missingCount();
    BigDecimal actualStandardDeviationResult = immutableComplexitySummary.standardDeviation();
    List<Complexity> actualTopComplexityScoresResult =
        immutableComplexitySummary.topComplexityScores();
    BigDecimal actualTotalResult = immutableComplexitySummary.total();
    BigDecimal actualVarianceResult = immutableComplexitySummary.variance();

    // Assert
    assertTrue(actualComplexityKindResult instanceof ImmutableComplexityKind);
    assertEquals(
        "ComplexitySummary{mappedCount=3, missingCount=3, average=2.3, median=2.3, variance=2.3, standardDeviation"
            + "=2.3, total=2.3, topComplexityScores=[], complexityKind=ComplexityKind{id=1, name=Name, externalId=42,"
            + " isDefault=true, kind=ALL}}",
        actualToStringResult);
    assertEquals(3, actualMappedCountResult);
    assertEquals(3, actualMissingCountResult);
    assertTrue(actualTopComplexityScoresResult.isEmpty());
    assertEquals(new BigDecimal("2.3"), actualAverageResult);
    assertEquals(new BigDecimal("2.3"), actualMedianResult);
    assertEquals(new BigDecimal("2.3"), actualStandardDeviationResult);
    assertEquals(new BigDecimal("2.3"), actualTotalResult);
    assertEquals(new BigDecimal("2.3"), actualVarianceResult);
    assertSame(average, actualAverageResult);
    assertSame(median, actualMedianResult);
    assertSame(standardDeviation, actualStandardDeviationResult);
    assertSame(total, actualTotalResult);
    assertSame(variance, actualVarianceResult);
  }

  /**
   * Test Json {@link Json#average()}.
   *
   * <p>Method under test: {@link Json#average()}
   */
  @Test
  @DisplayName("Test Json average()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal Json.average()"})
  void testJsonAverage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().average());
  }

  /**
   * Test Json {@link Json#complexityKind()}.
   *
   * <p>Method under test: {@link Json#complexityKind()}
   */
  @Test
  @DisplayName("Test Json complexityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ComplexityKind Json.complexityKind()"})
  void testJsonComplexityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().complexityKind());
  }

  /**
   * Test Json {@link Json#mappedCount()}.
   *
   * <p>Method under test: {@link Json#mappedCount()}
   */
  @Test
  @DisplayName("Test Json mappedCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.mappedCount()"})
  void testJsonMappedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().mappedCount());
  }

  /**
   * Test Json {@link Json#median()}.
   *
   * <p>Method under test: {@link Json#median()}
   */
  @Test
  @DisplayName("Test Json median()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal Json.median()"})
  void testJsonMedian() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().median());
  }

  /**
   * Test Json {@link Json#missingCount()}.
   *
   * <p>Method under test: {@link Json#missingCount()}
   */
  @Test
  @DisplayName("Test Json missingCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.missingCount()"})
  void testJsonMissingCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().missingCount());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

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
   * Test Json {@link Json#setMappedCount(int)}.
   *
   * <p>Method under test: {@link Json#setMappedCount(int)}
   */
  @Test
  @DisplayName("Test Json setMappedCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setMappedCount(int)"})
  void testJsonSetMappedCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setMappedCount(3);

    // Assert
    assertEquals(3, json.mappedCount);
    assertTrue(json.mappedCountIsSet);
  }

  /**
   * Test Json {@link Json#setMissingCount(int)}.
   *
   * <p>Method under test: {@link Json#setMissingCount(int)}
   */
  @Test
  @DisplayName("Test Json setMissingCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setMissingCount(int)"})
  void testJsonSetMissingCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setMissingCount(3);

    // Assert
    assertEquals(3, json.missingCount);
    assertTrue(json.missingCountIsSet);
  }

  /**
   * Test Json {@link Json#standardDeviation()}.
   *
   * <p>Method under test: {@link Json#standardDeviation()}
   */
  @Test
  @DisplayName("Test Json standardDeviation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal Json.standardDeviation()"})
  void testJsonStandardDeviation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().standardDeviation());
  }

  /**
   * Test Json {@link Json#topComplexityScores()}.
   *
   * <p>Method under test: {@link Json#topComplexityScores()}
   */
  @Test
  @DisplayName("Test Json topComplexityScores()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.topComplexityScores()"})
  void testJsonTopComplexityScores() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().topComplexityScores());
  }

  /**
   * Test Json {@link Json#total()}.
   *
   * <p>Method under test: {@link Json#total()}
   */
  @Test
  @DisplayName("Test Json total()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal Json.total()"})
  void testJsonTotal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().total());
  }

  /**
   * Test Json {@link Json#variance()}.
   *
   * <p>Method under test: {@link Json#variance()}
   */
  @Test
  @DisplayName("Test Json variance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal Json.variance()"})
  void testJsonVariance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().variance());
  }

  /**
   * Test {@link ImmutableComplexitySummary#withAverage(BigDecimal)}.
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#withAverage(BigDecimal)}
   */
  @Test
  @DisplayName("Test withAverage(BigDecimal)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexitySummary ImmutableComplexitySummary.withAverage(BigDecimal)"
  })
  void testWithAverage() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary immutableComplexitySummary =
        totalResult.variance(new BigDecimal("2.3")).build();

    // Act
    ImmutableComplexitySummary actualWithAverageResult =
        immutableComplexitySummary.withAverage(new BigDecimal("2.3"));

    // Assert
    assertSame(immutableComplexitySummary, actualWithAverageResult);
  }

  /**
   * Test {@link ImmutableComplexitySummary#withAverage(BigDecimal)}.
   *
   * <ul>
   *   <li>Then complexityKind return {@link ImmutableComplexityKind}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#withAverage(BigDecimal)}
   */
  @Test
  @DisplayName("Test withAverage(BigDecimal); then complexityKind return ImmutableComplexityKind")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexitySummary ImmutableComplexitySummary.withAverage(BigDecimal)"
  })
  void testWithAverage_thenComplexityKindReturnImmutableComplexityKind() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("4.5"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary immutableComplexitySummary =
        totalResult.variance(new BigDecimal("2.3")).build();

    // Act and Assert
    ComplexityKind complexityKindResult =
        immutableComplexitySummary.withAverage(new BigDecimal("2.3")).complexityKind();
    assertTrue(complexityKindResult instanceof ImmutableComplexityKind);
    assertEquals("Name", complexityKindResult.name());
    assertEquals("The characteristics of someone or something", complexityKindResult.description());
    assertEquals(EntityKind.ALL, complexityKindResult.kind());
    assertTrue(complexityKindResult.isDefault());
  }

  /**
   * Test {@link ImmutableComplexitySummary#withComplexityKind(ComplexityKind)}.
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#withComplexityKind(ComplexityKind)}
   */
  @Test
  @DisplayName("Test withComplexityKind(ComplexityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexitySummary ImmutableComplexitySummary.withComplexityKind(ComplexityKind)"
  })
  void testWithComplexityKind() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary immutableComplexitySummary =
        totalResult.variance(new BigDecimal("2.3")).build();

    // Act
    ImmutableComplexitySummary actualWithComplexityKindResult =
        immutableComplexitySummary.withComplexityKind(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableComplexitySummary, actualWithComplexityKindResult);
  }

  /**
   * Test {@link ImmutableComplexitySummary#withMappedCount(int)}.
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#withMappedCount(int)}
   */
  @Test
  @DisplayName("Test withMappedCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexitySummary ImmutableComplexitySummary.withMappedCount(int)"})
  void testWithMappedCount() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(42);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary immutableComplexitySummary =
        totalResult.variance(new BigDecimal("2.3")).build();

    // Act
    ImmutableComplexitySummary actualWithMappedCountResult =
        immutableComplexitySummary.withMappedCount(42);

    // Assert
    assertSame(immutableComplexitySummary, actualWithMappedCountResult);
  }

  /**
   * Test {@link ImmutableComplexitySummary#withMappedCount(int)}.
   *
   * <ul>
   *   <li>Then complexityKind return {@link ImmutableComplexityKind}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#withMappedCount(int)}
   */
  @Test
  @DisplayName("Test withMappedCount(int); then complexityKind return ImmutableComplexityKind")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexitySummary ImmutableComplexitySummary.withMappedCount(int)"})
  void testWithMappedCount_thenComplexityKindReturnImmutableComplexityKind() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));

    // Act and Assert
    ComplexityKind complexityKindResult =
        totalResult.variance(new BigDecimal("2.3")).build().withMappedCount(42).complexityKind();
    assertTrue(complexityKindResult instanceof ImmutableComplexityKind);
    assertEquals("Name", complexityKindResult.name());
    assertEquals("The characteristics of someone or something", complexityKindResult.description());
    assertEquals(EntityKind.ALL, complexityKindResult.kind());
    assertTrue(complexityKindResult.isDefault());
  }

  /**
   * Test {@link ImmutableComplexitySummary#withMedian(BigDecimal)}.
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#withMedian(BigDecimal)}
   */
  @Test
  @DisplayName("Test withMedian(BigDecimal)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexitySummary ImmutableComplexitySummary.withMedian(BigDecimal)"
  })
  void testWithMedian() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary immutableComplexitySummary =
        totalResult.variance(new BigDecimal("2.3")).build();

    // Act
    ImmutableComplexitySummary actualWithMedianResult =
        immutableComplexitySummary.withMedian(new BigDecimal("2.3"));

    // Assert
    assertSame(immutableComplexitySummary, actualWithMedianResult);
  }

  /**
   * Test {@link ImmutableComplexitySummary#withMedian(BigDecimal)}.
   *
   * <ul>
   *   <li>Then complexityKind return {@link ImmutableComplexityKind}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#withMedian(BigDecimal)}
   */
  @Test
  @DisplayName("Test withMedian(BigDecimal); then complexityKind return ImmutableComplexityKind")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexitySummary ImmutableComplexitySummary.withMedian(BigDecimal)"
  })
  void testWithMedian_thenComplexityKindReturnImmutableComplexityKind() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("4.5")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary immutableComplexitySummary =
        totalResult.variance(new BigDecimal("2.3")).build();

    // Act and Assert
    ComplexityKind complexityKindResult =
        immutableComplexitySummary.withMedian(new BigDecimal("2.3")).complexityKind();
    assertTrue(complexityKindResult instanceof ImmutableComplexityKind);
    assertEquals("Name", complexityKindResult.name());
    assertEquals("The characteristics of someone or something", complexityKindResult.description());
    assertEquals(EntityKind.ALL, complexityKindResult.kind());
    assertTrue(complexityKindResult.isDefault());
  }

  /**
   * Test {@link ImmutableComplexitySummary#withMissingCount(int)}.
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#withMissingCount(int)}
   */
  @Test
  @DisplayName("Test withMissingCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexitySummary ImmutableComplexitySummary.withMissingCount(int)"})
  void testWithMissingCount() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(42);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary immutableComplexitySummary =
        totalResult.variance(new BigDecimal("2.3")).build();

    // Act
    ImmutableComplexitySummary actualWithMissingCountResult =
        immutableComplexitySummary.withMissingCount(42);

    // Assert
    assertSame(immutableComplexitySummary, actualWithMissingCountResult);
  }

  /**
   * Test {@link ImmutableComplexitySummary#withMissingCount(int)}.
   *
   * <ul>
   *   <li>Then complexityKind return {@link ImmutableComplexityKind}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#withMissingCount(int)}
   */
  @Test
  @DisplayName("Test withMissingCount(int); then complexityKind return ImmutableComplexityKind")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexitySummary ImmutableComplexitySummary.withMissingCount(int)"})
  void testWithMissingCount_thenComplexityKindReturnImmutableComplexityKind() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));

    // Act and Assert
    ComplexityKind complexityKindResult =
        totalResult.variance(new BigDecimal("2.3")).build().withMissingCount(42).complexityKind();
    assertTrue(complexityKindResult instanceof ImmutableComplexityKind);
    assertEquals("Name", complexityKindResult.name());
    assertEquals("The characteristics of someone or something", complexityKindResult.description());
    assertEquals(EntityKind.ALL, complexityKindResult.kind());
    assertTrue(complexityKindResult.isDefault());
  }

  /**
   * Test {@link ImmutableComplexitySummary#withStandardDeviation(BigDecimal)}.
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#withStandardDeviation(BigDecimal)}
   */
  @Test
  @DisplayName("Test withStandardDeviation(BigDecimal)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexitySummary ImmutableComplexitySummary.withStandardDeviation(BigDecimal)"
  })
  void testWithStandardDeviation() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary immutableComplexitySummary =
        totalResult.variance(new BigDecimal("2.3")).build();

    // Act
    ImmutableComplexitySummary actualWithStandardDeviationResult =
        immutableComplexitySummary.withStandardDeviation(new BigDecimal("2.3"));

    // Assert
    assertSame(immutableComplexitySummary, actualWithStandardDeviationResult);
  }

  /**
   * Test {@link ImmutableComplexitySummary#withStandardDeviation(BigDecimal)}.
   *
   * <ul>
   *   <li>Then complexityKind return {@link ImmutableComplexityKind}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#withStandardDeviation(BigDecimal)}
   */
  @Test
  @DisplayName(
      "Test withStandardDeviation(BigDecimal); then complexityKind return ImmutableComplexityKind")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexitySummary ImmutableComplexitySummary.withStandardDeviation(BigDecimal)"
  })
  void testWithStandardDeviation_thenComplexityKindReturnImmutableComplexityKind() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("4.5"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary immutableComplexitySummary =
        totalResult.variance(new BigDecimal("2.3")).build();

    // Act and Assert
    ComplexityKind complexityKindResult =
        immutableComplexitySummary.withStandardDeviation(new BigDecimal("2.3")).complexityKind();
    assertTrue(complexityKindResult instanceof ImmutableComplexityKind);
    assertEquals("Name", complexityKindResult.name());
    assertEquals("The characteristics of someone or something", complexityKindResult.description());
    assertEquals(EntityKind.ALL, complexityKindResult.kind());
    assertTrue(complexityKindResult.isDefault());
  }

  /**
   * Test {@link ImmutableComplexitySummary#withTopComplexityScores(Complexity[])} with {@code
   * Complexity[]}.
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#withTopComplexityScores(Complexity[])}
   */
  @Test
  @DisplayName("Test withTopComplexityScores(Complexity[]) with 'Complexity[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexitySummary ImmutableComplexitySummary.withTopComplexityScores(Complexity[])"
  })
  void testWithTopComplexityScoresWithComplexity() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary immutableComplexitySummary =
        totalResult.variance(new BigDecimal("2.3")).build();

    ImmutableComplexity.Builder complexityKindIdResult =
        ImmutableComplexity.builder().complexityKindId(1L);

    ImmutableComplexity.Builder provenanceResult =
        complexityKindIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    // Act
    ImmutableComplexitySummary actualWithTopComplexityScoresResult =
        immutableComplexitySummary.withTopComplexityScores(
            provenanceResult.score(new BigDecimal("2.3")).build());

    // Assert
    List<Complexity> topComplexityScoresResult =
        actualWithTopComplexityScoresResult.topComplexityScores();
    assertEquals(1, topComplexityScoresResult.size());
    assertTrue(topComplexityScoresResult.get(0) instanceof ImmutableComplexity);
    ComplexityKind complexityKindResult = actualWithTopComplexityScoresResult.complexityKind();
    assertTrue(complexityKindResult instanceof ImmutableComplexityKind);
    assertEquals("Name", complexityKindResult.name());
    assertEquals("The characteristics of someone or something", complexityKindResult.description());
    assertEquals(3, actualWithTopComplexityScoresResult.mappedCount());
    assertEquals(3, actualWithTopComplexityScoresResult.missingCount());
    assertEquals(EntityKind.ALL, complexityKindResult.kind());
    assertTrue(complexityKindResult.isDefault());
    BigDecimal expectedAverageResult = new BigDecimal("2.3");
    assertEquals(expectedAverageResult, actualWithTopComplexityScoresResult.average());
    BigDecimal expectedMedianResult = new BigDecimal("2.3");
    assertEquals(expectedMedianResult, actualWithTopComplexityScoresResult.median());
    BigDecimal expectedStandardDeviationResult = new BigDecimal("2.3");
    assertEquals(
        expectedStandardDeviationResult, actualWithTopComplexityScoresResult.standardDeviation());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualWithTopComplexityScoresResult.total());
    BigDecimal expectedVarianceResult = new BigDecimal("2.3");
    assertEquals(expectedVarianceResult, actualWithTopComplexityScoresResult.variance());
  }

  /**
   * Test {@link ImmutableComplexitySummary#withTotal(BigDecimal)}.
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#withTotal(BigDecimal)}
   */
  @Test
  @DisplayName("Test withTotal(BigDecimal)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexitySummary ImmutableComplexitySummary.withTotal(BigDecimal)"})
  void testWithTotal() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary immutableComplexitySummary =
        totalResult.variance(new BigDecimal("2.3")).build();

    // Act
    ImmutableComplexitySummary actualWithTotalResult =
        immutableComplexitySummary.withTotal(new BigDecimal("2.3"));

    // Assert
    assertSame(immutableComplexitySummary, actualWithTotalResult);
  }

  /**
   * Test {@link ImmutableComplexitySummary#withTotal(BigDecimal)}.
   *
   * <ul>
   *   <li>Then complexityKind return {@link ImmutableComplexityKind}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#withTotal(BigDecimal)}
   */
  @Test
  @DisplayName("Test withTotal(BigDecimal); then complexityKind return ImmutableComplexityKind")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexitySummary ImmutableComplexitySummary.withTotal(BigDecimal)"})
  void testWithTotal_thenComplexityKindReturnImmutableComplexityKind() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("4.5"));
    ImmutableComplexitySummary immutableComplexitySummary =
        totalResult.variance(new BigDecimal("2.3")).build();

    // Act and Assert
    ComplexityKind complexityKindResult =
        immutableComplexitySummary.withTotal(new BigDecimal("2.3")).complexityKind();
    assertTrue(complexityKindResult instanceof ImmutableComplexityKind);
    assertEquals("Name", complexityKindResult.name());
    assertEquals("The characteristics of someone or something", complexityKindResult.description());
    assertEquals(EntityKind.ALL, complexityKindResult.kind());
    assertTrue(complexityKindResult.isDefault());
  }

  /**
   * Test {@link ImmutableComplexitySummary#withVariance(BigDecimal)}.
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#withVariance(BigDecimal)}
   */
  @Test
  @DisplayName("Test withVariance(BigDecimal)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexitySummary ImmutableComplexitySummary.withVariance(BigDecimal)"
  })
  void testWithVariance() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary immutableComplexitySummary =
        totalResult.variance(new BigDecimal("2.3")).build();

    // Act
    ImmutableComplexitySummary actualWithVarianceResult =
        immutableComplexitySummary.withVariance(new BigDecimal("2.3"));

    // Assert
    assertSame(immutableComplexitySummary, actualWithVarianceResult);
  }

  /**
   * Test {@link ImmutableComplexitySummary#withVariance(BigDecimal)}.
   *
   * <ul>
   *   <li>Then complexityKind return {@link ImmutableComplexityKind}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexitySummary#withVariance(BigDecimal)}
   */
  @Test
  @DisplayName("Test withVariance(BigDecimal); then complexityKind return ImmutableComplexityKind")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexitySummary ImmutableComplexitySummary.withVariance(BigDecimal)"
  })
  void testWithVariance_thenComplexityKindReturnImmutableComplexityKind() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder mappedCountResult =
        averageResult
            .complexityKind(
                ImmutableComplexityKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .mappedCount(3);

    Builder missingCountResult = mappedCountResult.median(new BigDecimal("2.3")).missingCount(3);

    Builder standardDeviationResult = missingCountResult.standardDeviation(new BigDecimal("2.3"));

    Builder totalResult = standardDeviationResult.total(new BigDecimal("2.3"));
    ImmutableComplexitySummary immutableComplexitySummary =
        totalResult.variance(new BigDecimal("4.5")).build();

    // Act and Assert
    ComplexityKind complexityKindResult =
        immutableComplexitySummary.withVariance(new BigDecimal("2.3")).complexityKind();
    assertTrue(complexityKindResult instanceof ImmutableComplexityKind);
    assertEquals("Name", complexityKindResult.name());
    assertEquals("The characteristics of someone or something", complexityKindResult.description());
    assertEquals(EntityKind.ALL, complexityKindResult.kind());
    assertTrue(complexityKindResult.isDefault());
  }
}
