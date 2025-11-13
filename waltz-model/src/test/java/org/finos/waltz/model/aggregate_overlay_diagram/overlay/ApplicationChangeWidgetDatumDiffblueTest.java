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
   * <ul>
   *   <li>Given builder cellExternalId {@code 42} build.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationChangeWidgetDatum#inboundCounts()}
   */
  @Test
  @DisplayName("Test inboundCounts(); given builder cellExternalId '42' build; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set ApplicationChangeWidgetDatum.inboundCounts()"})
  void testInboundCounts_givenBuilderCellExternalId42Build_thenReturnEmpty() {
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
   * <ul>
   *   <li>Given builder cellExternalId {@code 42} build.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationChangeWidgetDatum#outboundCounts()}
   */
  @Test
  @DisplayName("Test outboundCounts(); given builder cellExternalId '42' build; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set ApplicationChangeWidgetDatum.outboundCounts()"})
  void testOutboundCounts_givenBuilderCellExternalId42Build_thenReturnEmpty() {
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
   * <ul>
   *   <li>Given builder cellExternalId {@code 42} build.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationChangeWidgetDatum#totalOutboundCount()}
   */
  @Test
  @DisplayName(
      "Test totalOutboundCount(); given builder cellExternalId '42' build; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ApplicationChangeWidgetDatum.totalOutboundCount()"})
  void testTotalOutboundCount_givenBuilderCellExternalId42Build_thenReturnZero() {
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
   * <ul>
   *   <li>Given builder cellExternalId {@code 42} build.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationChangeWidgetDatum#totalInboundCount()}
   */
  @Test
  @DisplayName(
      "Test totalInboundCount(); given builder cellExternalId '42' build; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ApplicationChangeWidgetDatum.totalInboundCount()"})
  void testTotalInboundCount_givenBuilderCellExternalId42Build_thenReturnZero() {
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
   * <ul>
   *   <li>Given builder cellExternalId {@code 42} build.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationChangeWidgetDatum#currentAppCount()}
   */
  @Test
  @DisplayName("Test currentAppCount(); given builder cellExternalId '42' build; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ApplicationChangeWidgetDatum.currentAppCount()"})
  void testCurrentAppCount_givenBuilderCellExternalId42Build_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        ImmutableApplicationChangeWidgetDatum.builder()
            .cellExternalId("42")
            .build()
            .currentAppCount());
  }
}
