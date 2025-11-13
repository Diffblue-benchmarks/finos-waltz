package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReportGridUpdateCommandDiffblueTest {
  /**
   * Test {@link ReportGridUpdateCommand#kind()}.
   *
   * <ul>
   *   <li>Then return {@code PUBLIC}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridUpdateCommand#kind()}
   */
  @Test
  @DisplayName("Test kind(); then return 'PUBLIC'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridKind ReportGridUpdateCommand.kind()"})
  void testKind_thenReturnPublic() {
    // Arrange, Act and Assert
    assertEquals(
        ReportGridKind.PUBLIC,
        ImmutableReportGridUpdateCommand.builder()
            .description("The characteristics of someone or something")
            .kind(ReportGridKind.PUBLIC)
            .name("Name")
            .build()
            .kind());
  }
}
