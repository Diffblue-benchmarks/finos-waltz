package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import org.finos.waltz.model.Quarter;
import org.junit.jupiter.api.Test;

class QuarterDetailDiffblueTest {
  /**
   * Method under test: {@link QuarterDetail#lookupQuarter(int)}
   */
  @Test
  void testLookupQuarter() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> QuarterDetail.lookupQuarter(42));
    assertEquals(1, QuarterDetail.lookupQuarter(1).intValue());
    assertEquals(2, QuarterDetail.lookupQuarter(4).intValue());
    assertEquals(3, QuarterDetail.lookupQuarter(7).intValue());
    assertEquals(4, QuarterDetail.lookupQuarter(10).intValue());
  }

  /**
   * Method under test: {@link QuarterDetail#mkQuarterDetail(LocalDate)}
   */
  @Test
  void testMkQuarterDetail() {
    // Arrange and Act
    QuarterDetail actualMkQuarterDetailResult = QuarterDetail.mkQuarterDetail(LocalDate.of(1970, 1, 1));

    // Assert
    assertTrue(actualMkQuarterDetailResult instanceof ImmutableQuarterDetail);
    assertEquals(1, actualMkQuarterDetailResult.quarter());
    assertEquals(1970, actualMkQuarterDetailResult.year());
    assertEquals(Quarter.Q1, actualMkQuarterDetailResult.quarterName());
  }

  /**
   * Method under test: {@link QuarterDetail#mkQuarterDetail(LocalDate)}
   */
  @Test
  void testMkQuarterDetail2() {
    // Arrange, Act and Assert
    assertTrue(QuarterDetail.mkQuarterDetail(LocalDate.now()) instanceof ImmutableQuarterDetail);
  }
}
