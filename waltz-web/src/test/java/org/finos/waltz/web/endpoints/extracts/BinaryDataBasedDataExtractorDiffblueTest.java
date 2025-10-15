package org.finos.waltz.web.endpoints.extracts;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.finos.waltz.service.measurable.MeasurableService;
import org.finos.waltz.service.svg.SvgDiagramService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import spark.Request;
import spark.Response;

@ExtendWith(MockitoExtension.class)
class BinaryDataBasedDataExtractorDiffblueTest {
  @Mock private MeasurableService measurableService;

  @Mock private SvgDiagramService svgDiagramService;

  /**
   * Test {@link BinaryDataBasedDataExtractor#writeExtract(String, byte[], Request, Response)}.
   *
   * <ul>
   *   <li>Given {@code Query Params}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BinaryDataBasedDataExtractor#writeExtract(String, byte[], Request,
   * Response)}
   */
  @Test
  @DisplayName(
      "Test writeExtract(String, byte[], Request, Response); given 'Query Params'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Object BinaryDataBasedDataExtractor.writeExtract(String, byte[], Request, Response)"
  })
  void testWriteExtract_givenQueryParams_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    NavAidExtractor navAidExtractor = new NavAidExtractor(measurableService, svgDiagramService);
    byte[] dataBytes = "AXAXAXAX".getBytes("UTF-8");

    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenReturn("Query Params");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> navAidExtractor.writeExtract("foo.txt", dataBytes, request, null));
    verify(request).queryParams("format");
  }
}
