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
   * <p>Method under test: {@link MeasurableHierarchy#maxDepth()}
   */
  @Test
  @DisplayName("Test maxDepth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer MeasurableHierarchy.maxDepth()"})
  void testMaxDepth() {
    // Arrange, Act and Assert
    assertEquals(
        1, ImmutableMeasurableHierarchy.builder().measurableId(1L).build().maxDepth().intValue());
  }
}
