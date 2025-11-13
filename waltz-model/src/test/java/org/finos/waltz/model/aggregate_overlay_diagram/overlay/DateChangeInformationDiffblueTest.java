package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableDateChangeInformation.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DateChangeInformationDiffblueTest {
  /**
   * Test {@link DateChangeInformation#count()}.
   *
   * <ul>
   *   <li>Given builder quarter builder quarter one year one build build.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DateChangeInformation#count()}
   */
  @Test
  @DisplayName(
      "Test count(); given builder quarter builder quarter one year one build build; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DateChangeInformation.count()"})
  void testCount_givenBuilderQuarterBuilderQuarterOneYearOneBuildBuild_thenReturnZero() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();

    // Act and Assert
    assertEquals(
        0,
        builderResult
            .quarter(ImmutableQuarterDetail.builder().quarter(1).year(1).build())
            .build()
            .count());
  }
}
