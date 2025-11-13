package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ComplexityWidgetDatumDiffblueTest {
  /**
   * Test {@link ComplexityWidgetDatum#totalComplexity()}.
   *
   * <ul>
   *   <li>Given builder cellExternalId {@code 42} build.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityWidgetDatum#totalComplexity()}
   */
  @Test
  @DisplayName(
      "Test totalComplexity(); given builder cellExternalId '42' build; then return BigDecimal(String) with '0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ComplexityWidgetDatum.totalComplexity()"})
  void testTotalComplexity_givenBuilderCellExternalId42Build_thenReturnBigDecimalWith0() {
    // Arrange
    ImmutableComplexityWidgetDatum immutableComplexityWidgetDatum =
        ImmutableComplexityWidgetDatum.builder().cellExternalId("42").build();

    // Act
    BigDecimal actualTotalComplexityResult = immutableComplexityWidgetDatum.totalComplexity();

    // Assert
    assertEquals(new BigDecimal("0"), actualTotalComplexityResult);
    BigDecimal bigDecimal = BigDecimal.ZERO;
    assertSame(bigDecimal, immutableComplexityWidgetDatum.averageComplexity());
    assertSame(bigDecimal, immutableComplexityWidgetDatum.totalComplexity());
  }

  /**
   * Test {@link ComplexityWidgetDatum#averageComplexity()}.
   *
   * <ul>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityWidgetDatum#averageComplexity()}
   */
  @Test
  @DisplayName("Test averageComplexity(); then return BigDecimal(String) with '0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ComplexityWidgetDatum.averageComplexity()"})
  void testAverageComplexity_thenReturnBigDecimalWith0() {
    // Arrange
    ImmutableComplexityWidgetDatum immutableComplexityWidgetDatum =
        ImmutableComplexityWidgetDatum.builder().cellExternalId("42").build();

    // Act
    BigDecimal actualAverageComplexityResult = immutableComplexityWidgetDatum.averageComplexity();

    // Assert
    assertEquals(new BigDecimal("0"), actualAverageComplexityResult);
    BigDecimal bigDecimal = BigDecimal.ZERO;
    assertSame(bigDecimal, immutableComplexityWidgetDatum.averageComplexity());
    assertSame(bigDecimal, immutableComplexityWidgetDatum.totalComplexity());
  }
}
