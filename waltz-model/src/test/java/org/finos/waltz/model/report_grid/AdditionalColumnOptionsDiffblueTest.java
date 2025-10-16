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
    assertTrue(actualAllowedKindsResult.contains(EntityKind.ASSET_COST));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.CHANGE_UNIT));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.COMPLEXITY_KIND));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.ENTITY_NAMED_NOTE_TYPE));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.EXTERNAL_IDENTIFIER));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.INVOLVEMENT));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.MEASURABLE_CATEGORY));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.PROCESS_DIAGRAM));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.RELATIONSHIP_KIND));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.ROLE));
    assertTrue(actualAllowedKindsResult.contains(EntityKind.SERVER_USAGE));
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
