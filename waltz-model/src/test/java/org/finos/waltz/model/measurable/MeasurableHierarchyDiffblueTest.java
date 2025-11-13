package org.finos.waltz.model.measurable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MeasurableHierarchyDiffblueTest {
  /**
   * Test {@link MeasurableHierarchy#maxDepth()}.
   *
   * <ul>
   *   <li>Given builder measurableId one build.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableHierarchy#maxDepth()}
   */
  @Test
  @DisplayName("Test maxDepth(); given builder measurableId one build; then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer MeasurableHierarchy.maxDepth()"})
  void testMaxDepth_givenBuilderMeasurableIdOneBuild_thenReturnIntValueIsOne() {
    // Arrange, Act and Assert
    assertEquals(
        1, ImmutableMeasurableHierarchy.builder().measurableId(1L).build().maxDepth().intValue());
  }
}
