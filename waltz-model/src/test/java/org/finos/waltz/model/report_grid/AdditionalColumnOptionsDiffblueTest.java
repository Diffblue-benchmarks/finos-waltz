package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.Test;

class AdditionalColumnOptionsDiffblueTest {
  /**
   * Method under test: {@link AdditionalColumnOptions#allowedKinds()}
   */
  @Test
  void testAllowedKinds() {
    // Arrange and Act
    Set<EntityKind> actualAllowedKindsResult = AdditionalColumnOptions.valueOf("NONE").allowedKinds();

    // Assert
    assertEquals(86, actualAllowedKindsResult.size());
    assertTrue(actualAllowedKindsResult.contains(EntityKind.ACTOR));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.ASSESSMENT_DEFINITION));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.DATABASE_USAGE));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.ENTITY_RELATIONSHIP));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.INVOLVEMENT));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.LOGICAL_DATA_FLOW));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.MEASURABLE_CATEGORY));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.MEASURABLE_RATING_PLANNED_DECOMMISSION));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.MEASURABLE_RATING_REPLACEMENT));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.PHYSICAL_SPEC_DEFN));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.SURVEY_INSTANCE_RECIPIENT));
  }

  /**
   * Method under test:
   * {@link AdditionalColumnOptions#findAllowedKinds(EntityKind)}
   */
  @Test
  void testFindAllowedKinds() {
    // Arrange and Act
    Set<AdditionalColumnOptions> actualFindAllowedKindsResult = AdditionalColumnOptions
        .findAllowedKinds(EntityKind.ALL);

    // Assert
    assertEquals(1, actualFindAllowedKindsResult.size());
    assertTrue(actualFindAllowedKindsResult.contains(AdditionalColumnOptions.NONE));
  }

  /**
   * Method under test: {@link AdditionalColumnOptions#parseColumnOptions(String)}
   */
  @Test
  void testParseColumnOptions() {
    // Arrange, Act and Assert
    assertEquals(AdditionalColumnOptions.NONE, AdditionalColumnOptions.parseColumnOptions("Column Options"));
    assertEquals(AdditionalColumnOptions.NONE, AdditionalColumnOptions.parseColumnOptions("NONE"));
  }
}
