package org.finos.waltz.service.bulk_upload.column_parsers;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.AssessmentHeaderCell;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AlwaysFailingColumnParserDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlwaysFailingColumnParser#AlwaysFailingColumnParser(AssessmentHeaderCell)}
   *   <li>{@link AlwaysFailingColumnParser#getHeader()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlwaysFailingColumnParser.<init>(AssessmentHeaderCell)",
      "AssessmentHeaderCell AlwaysFailingColumnParser.getHeader()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull((new AlwaysFailingColumnParser(null)).getHeader());
  }
}
