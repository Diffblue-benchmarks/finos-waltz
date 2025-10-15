package org.finos.waltz.web.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FieldChangeDiffblueTest {
  /**
   * Test {@link FieldChange#toDescription()}.
   *
   * <ul>
   *   <li>Then return {@code Updated: Name, from: 'Original' to: 'Current'}.
   * </ul>
   *
   * <p>Method under test: {@link FieldChange#toDescription()}
   */
  @Test
  @DisplayName("Test toDescription(); then return 'Updated: Name, from: 'Original' to: 'Current''")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String FieldChange.toDescription()"})
  void testToDescription_thenReturnUpdatedNameFromOriginalToCurrent() {
    // Arrange, Act and Assert
    assertEquals(
        "Updated: Name, from: 'Original' to: 'Current'",
        ImmutableFieldChange.builder()
            .current("Current")
            .dirty(true)
            .key("Key")
            .name("Name")
            .original("Original")
            .build()
            .toDescription());
  }
}
