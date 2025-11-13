package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AdditionalColumnOptionsDiffblueTest {
  /**
   * Test {@link AdditionalColumnOptions#allowedKinds()}.
   *
   * <p>Method under test: {@link AdditionalColumnOptions#allowedKinds()}
   */
  @Test
  @DisplayName("Test allowedKinds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AdditionalColumnOptions.allowedKinds()"})
  void testAllowedKinds() {
    // Arrange and Act
    Set<EntityKind> actualAllowedKindsResult =
        AdditionalColumnOptions.valueOf("NONE").allowedKinds();

    // Assert
    assertEquals(86, actualAllowedKindsResult.size());
    assertTrue(actualAllowedKindsResult.contains(EntityKind.AGGREGATE_OVERLAY_DIAGRAM));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.COST));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.ENTITY_FIELD_REFERENCE));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.FLOW_ANNOTATION));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.FLOW_CLASSIFICATION));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.INVOLVEMENT_KIND));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.LEGAL_ENTITY_RELATIONSHIP));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.REPORT_GRID));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.ROADMAP));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.SERVER));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.SURVEY_TEMPLATE));
  }

  /**
   * Test {@link AdditionalColumnOptions#parseColumnOptions(String)}.
   *
   * <ul>
   *   <li>When {@code Column Options}.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalColumnOptions#parseColumnOptions(String)}
   */
  @Test
  @DisplayName("Test parseColumnOptions(String); when 'Column Options'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AdditionalColumnOptions AdditionalColumnOptions.parseColumnOptions(String)"})
  void testParseColumnOptions_whenColumnOptions() {
    // Arrange, Act and Assert
    assertEquals(
        AdditionalColumnOptions.NONE, AdditionalColumnOptions.parseColumnOptions("Column Options"));
  }

  /**
   * Test {@link AdditionalColumnOptions#parseColumnOptions(String)}.
   *
   * <ul>
   *   <li>When {@code NONE}.
   * </ul>
   *
   * <p>Method under test: {@link AdditionalColumnOptions#parseColumnOptions(String)}
   */
  @Test
  @DisplayName("Test parseColumnOptions(String); when 'NONE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AdditionalColumnOptions AdditionalColumnOptions.parseColumnOptions(String)"})
  void testParseColumnOptions_whenNone() {
    // Arrange, Act and Assert
    assertEquals(AdditionalColumnOptions.NONE, AdditionalColumnOptions.parseColumnOptions("NONE"));
  }

  /**
   * Test {@link AdditionalColumnOptions#findAllowedKinds(EntityKind)}.
   *
   * <p>Method under test: {@link AdditionalColumnOptions#findAllowedKinds(EntityKind)}
   */
  @Test
  @DisplayName("Test findAllowedKinds(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AdditionalColumnOptions.findAllowedKinds(EntityKind)"})
  void testFindAllowedKinds() {
    // Arrange and Act
    Set<AdditionalColumnOptions> actualFindAllowedKindsResult =
        AdditionalColumnOptions.findAllowedKinds(EntityKind.ALL);

    // Assert
    assertEquals(1, actualFindAllowedKindsResult.size());
    assertTrue(actualFindAllowedKindsResult.contains(AdditionalColumnOptions.NONE));
  }
}
