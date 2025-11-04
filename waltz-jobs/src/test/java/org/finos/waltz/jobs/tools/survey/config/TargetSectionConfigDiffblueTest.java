package org.finos.waltz.jobs.tools.survey.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TargetSectionConfigDiffblueTest {
  /**
   * Method under test:
   * {@link TargetSectionConfig#mkTargetSection(String, String)}
   */
  @Test
  void testMkTargetSection() {
    // Arrange and Act
    TargetSectionConfig actualMkTargetSectionResult = TargetSectionConfig.mkTargetSection("42", "Name");

    // Assert
    assertTrue(actualMkTargetSectionResult instanceof ImmutableTargetSectionConfig);
    assertEquals("42", actualMkTargetSectionResult.extIdPrefix());
    assertEquals("Name", actualMkTargetSectionResult.name());
  }
}
