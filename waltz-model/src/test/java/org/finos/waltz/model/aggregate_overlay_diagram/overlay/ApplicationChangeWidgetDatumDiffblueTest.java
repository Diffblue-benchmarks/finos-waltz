package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ApplicationChangeWidgetDatumDiffblueTest {
  /**
   * Test {@link ApplicationChangeWidgetDatum#inboundCounts()}.
   *
   * <p>Method under test: {@link ApplicationChangeWidgetDatum#inboundCounts()}
   */
  @Test
  @DisplayName("Test inboundCounts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set ApplicationChangeWidgetDatum.inboundCounts()"})
  void testInboundCounts() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableApplicationChangeWidgetDatum.builder()
            .cellExternalId("42")
            .build()
            .inboundCounts()
            .isEmpty());
  }

  /**
   * Test {@link ApplicationChangeWidgetDatum#outboundCounts()}.
   *
   * <p>Method under test: {@link ApplicationChangeWidgetDatum#outboundCounts()}
   */
  @Test
  @DisplayName("Test outboundCounts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set ApplicationChangeWidgetDatum.outboundCounts()"})
  void testOutboundCounts() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableApplicationChangeWidgetDatum.builder()
            .cellExternalId("42")
            .build()
            .outboundCounts()
            .isEmpty());
  }

  /**
   * Test {@link ApplicationChangeWidgetDatum#totalOutboundCount()}.
   *
   * <p>Method under test: {@link ApplicationChangeWidgetDatum#totalOutboundCount()}
   */
  @Test
  @DisplayName("Test totalOutboundCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ApplicationChangeWidgetDatum.totalOutboundCount()"})
  void testTotalOutboundCount() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        ImmutableApplicationChangeWidgetDatum.builder()
            .cellExternalId("42")
            .build()
            .totalOutboundCount());
  }

  /**
   * Test {@link ApplicationChangeWidgetDatum#totalInboundCount()}.
   *
   * <p>Method under test: {@link ApplicationChangeWidgetDatum#totalInboundCount()}
   */
  @Test
  @DisplayName("Test totalInboundCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ApplicationChangeWidgetDatum.totalInboundCount()"})
  void testTotalInboundCount() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        ImmutableApplicationChangeWidgetDatum.builder()
            .cellExternalId("42")
            .build()
            .totalInboundCount());
  }

  /**
   * Test {@link ApplicationChangeWidgetDatum#currentAppCount()}.
   *
   * <p>Method under test: {@link ApplicationChangeWidgetDatum#currentAppCount()}
   */
  @Test
  @DisplayName("Test currentAppCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ApplicationChangeWidgetDatum.currentAppCount()"})
  void testCurrentAppCount() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        ImmutableApplicationChangeWidgetDatum.builder()
            .cellExternalId("42")
            .build()
            .currentAppCount());
  }
}
