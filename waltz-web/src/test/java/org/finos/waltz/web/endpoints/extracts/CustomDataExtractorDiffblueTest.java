package org.finos.waltz.web.endpoints.extracts;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CustomDataExtractorDiffblueTest {
  @InjectMocks
  private LogicalFlowExtractor logicalFlowExtractor;

  /**
   * Test {@link CustomDataExtractor#formatReport(ExtractFormat, String, List, List)}.
   * <ul>
   *   <li>When {@code SVG}.</li>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomDataExtractor#formatReport(ExtractFormat, String, List, List)}
   */
  @Test
  @DisplayName("Test formatReport(ExtractFormat, String, List, List); when 'SVG'; then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.jooq.lambda.tuple.Tuple3 CustomDataExtractor.formatReport(ExtractFormat, String, List, List)"})
  void testFormatReport_whenSvg_thenThrowUnsupportedOperationException() throws IOException {
    // Arrange
    ArrayList<List<Object>> reportRows = new ArrayList<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> logicalFlowExtractor.formatReport(ExtractFormat.SVG, "Report Name", reportRows, new ArrayList<>()));
  }
}
