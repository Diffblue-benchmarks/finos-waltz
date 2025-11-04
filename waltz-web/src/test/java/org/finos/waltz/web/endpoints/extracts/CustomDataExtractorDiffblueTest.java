package org.finos.waltz.web.endpoints.extracts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.lambda.tuple.Tuple3;
import org.junit.jupiter.api.Test;

class CustomDataExtractorDiffblueTest {
  /**
   * Method under test:
   * {@link CustomDataExtractor#formatReport(ExtractFormat, String, List, List)}
   */
  @Test
  void testFormatReport() throws IOException {
    // Arrange
    LogicalFlowExtractor logicalFlowExtractor = new LogicalFlowExtractor(new DefaultDSLContext(SQLDialect.SQL99));
    ArrayList<List<Object>> reportRows = new ArrayList<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> logicalFlowExtractor.formatReport(ExtractFormat.SVG, "Report Name", reportRows, new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link CustomDataExtractor#formatReport(ExtractFormat, String, List, List)}
   */
  @Test
  void testFormatReport2() throws IOException {
    // Arrange
    LogicalFlowExtractor logicalFlowExtractor = new LogicalFlowExtractor(new DefaultDSLContext(SQLDialect.SQL99));
    ArrayList<List<Object>> reportRows = new ArrayList<>();

    ArrayList<String> headers = new ArrayList<>();
    headers.add("42");

    // Act
    Tuple3<ExtractFormat, String, byte[]> actualFormatReportResult = logicalFlowExtractor
        .formatReport(ExtractFormat.CSV, "Report Name", reportRows, headers);

    // Assert
    List<?> toListResult = actualFormatReportResult.toList();
    assertEquals(3, toListResult.size());
    Object getResult = toListResult.get(0);
    assertTrue(getResult instanceof ExtractFormat);
    Object getResult2 = toListResult.get(1);
    assertEquals("Report Name", getResult2);
    assertEquals(ExtractFormat.CSV, getResult);
    assertSame(actualFormatReportResult.v1, getResult);
    assertSame(actualFormatReportResult.v2, getResult2);
    assertSame(actualFormatReportResult.v3, toListResult.get(2));
  }

  /**
   * Method under test:
   * {@link CustomDataExtractor#formatReport(ExtractFormat, String, List, List)}
   */
  @Test
  void testFormatReport3() throws IOException {
    // Arrange
    LogicalFlowExtractor logicalFlowExtractor = new LogicalFlowExtractor(new DefaultDSLContext(SQLDialect.SQL99));
    ArrayList<List<Object>> reportRows = new ArrayList<>();

    ArrayList<String> headers = new ArrayList<>();
    headers.add("");
    headers.add("42");

    // Act
    Tuple3<ExtractFormat, String, byte[]> actualFormatReportResult = logicalFlowExtractor
        .formatReport(ExtractFormat.CSV, "Report Name", reportRows, headers);

    // Assert
    List<?> toListResult = actualFormatReportResult.toList();
    assertEquals(3, toListResult.size());
    Object getResult = toListResult.get(0);
    assertTrue(getResult instanceof ExtractFormat);
    Object getResult2 = toListResult.get(1);
    assertEquals("Report Name", getResult2);
    assertEquals(ExtractFormat.CSV, getResult);
    assertSame(actualFormatReportResult.v1, getResult);
    assertSame(actualFormatReportResult.v2, getResult2);
    assertSame(actualFormatReportResult.v3, toListResult.get(2));
  }
}
