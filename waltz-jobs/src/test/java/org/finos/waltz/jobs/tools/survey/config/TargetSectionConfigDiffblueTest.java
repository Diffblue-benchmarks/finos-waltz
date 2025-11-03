package org.finos.waltz.jobs.tools.survey.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TargetSectionConfigDiffblueTest {
  /**
   * Test {@link TargetSectionConfig#mkTargetSection(String, String)}.
   * <p>
   * Method under test: {@link TargetSectionConfig#mkTargetSection(String, String)}
   */
  @Test
  @DisplayName("Test mkTargetSection(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TargetSectionConfig TargetSectionConfig.mkTargetSection(String, String)"})
  void testMkTargetSection() {
    // Arrange and Act
    TargetSectionConfig actualMkTargetSectionResult = TargetSectionConfig.mkTargetSection("42", "Name");

    // Assert
    assertTrue(actualMkTargetSectionResult instanceof ImmutableTargetSectionConfig);
    assertEquals("42", actualMkTargetSectionResult.extIdPrefix());
    assertEquals("Name", actualMkTargetSectionResult.name());
  }
}
