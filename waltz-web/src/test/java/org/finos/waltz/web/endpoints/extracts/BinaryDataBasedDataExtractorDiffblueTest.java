package org.finos.waltz.web.endpoints.extracts;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.finos.waltz.service.measurable.MeasurableService;
import org.finos.waltz.service.svg.SvgDiagramService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import spark.Request;
import spark.Response;

@ExtendWith(MockitoExtension.class)
class BinaryDataBasedDataExtractorDiffblueTest {
  @Mock
  private MeasurableService measurableService;

  @InjectMocks
  private NavAidExtractor navAidExtractor;

  @InjectMocks
  private String string;

  @Mock
  private SvgDiagramService svgDiagramService;

  /**
   * Method under test:
   * {@link BinaryDataBasedDataExtractor#writeExtract(String, byte[], Request, Response)}
   */
  @Test
  void testWriteExtract() throws IOException {
    // Arrange
    byte[] dataBytes = "AXAXAXAX".getBytes("UTF-8");
    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenReturn("Query Params");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> navAidExtractor.writeExtract("foo.txt", dataBytes, request, null));
    verify(request).queryParams(eq("format"));
  }
}
