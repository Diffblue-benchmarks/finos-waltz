package org.finos.waltz.web.endpoints.extracts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.jooq.DSLContext;
import org.jooq.lambda.tuple.Tuple3;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import spark.Request;
import spark.Response;

@ExtendWith(MockitoExtension.class)
class DataExtractorDiffblueTest {
  @InjectMocks
  private ActorExtractor actorExtractor;

  @Mock
  private DSLContext dSLContext;

  /**
   * Method under test: {@link DataExtractor#parseExtractFormat(Request)}
   */
  @Test
  void testParseExtractFormat() {
    // Arrange
    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenReturn("Query Params");

    // Act
    ExtractFormat actualParseExtractFormatResult = actorExtractor.parseExtractFormat(request);

    // Assert
    verify(request).queryParams(eq("format"));
    assertEquals(ExtractFormat.CSV, actualParseExtractFormatResult);
  }

  /**
   * Method under test: {@link DataExtractor#parseExtractFormat(Request)}
   */
  @Test
  void testParseExtractFormat2() {
    // Arrange
    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenReturn("XLSX");

    // Act
    ExtractFormat actualParseExtractFormatResult = actorExtractor.parseExtractFormat(request);

    // Assert
    verify(request).queryParams(eq("format"));
    assertEquals(ExtractFormat.XLSX, actualParseExtractFormatResult);
  }

  /**
   * Method under test: {@link DataExtractor#writeReportResults(Response, Tuple3)}
   */
  @Test
  void testWriteReportResults() throws IOException {
    // Arrange
    DataExtractor dataExtractor = mock(DataExtractor.class);
    when(
        dataExtractor.writeReportResults(Mockito.<Response>any(), Mockito.<Tuple3<ExtractFormat, String, byte[]>>any()))
            .thenReturn("Report Results");

    // Act
    dataExtractor.writeReportResults(null, new Tuple3<>(ExtractFormat.XLSX, "V2", "AXAXAXAX".getBytes("UTF-8")));

    // Assert
    verify(dataExtractor).writeReportResults(isNull(), isA(Tuple3.class));
  }
}
