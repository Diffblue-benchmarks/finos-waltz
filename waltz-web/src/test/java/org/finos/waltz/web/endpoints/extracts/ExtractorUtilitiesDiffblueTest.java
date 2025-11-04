package org.finos.waltz.web.endpoints.extracts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spark.Request;

class ExtractorUtilitiesDiffblueTest {
  /**
   * Method under test: {@link ExtractorUtilities#parseExtractFormat(Request)}
   */
  @Test
  void testParseExtractFormat() {
    // Arrange
    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenReturn("Query Params");

    // Act
    ExtractFormat actualParseExtractFormatResult = ExtractorUtilities.parseExtractFormat(request);

    // Assert
    verify(request).queryParams(eq("format"));
    assertEquals(ExtractFormat.CSV, actualParseExtractFormatResult);
  }

  /**
   * Method under test: {@link ExtractorUtilities#parseExtractFormat(Request)}
   */
  @Test
  void testParseExtractFormat2() {
    // Arrange
    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenReturn("XLSX");

    // Act
    ExtractFormat actualParseExtractFormatResult = ExtractorUtilities.parseExtractFormat(request);

    // Assert
    verify(request).queryParams(eq("format"));
    assertEquals(ExtractFormat.XLSX, actualParseExtractFormatResult);
  }

  /**
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  void testSanitizeSheetName() {
    // Arrange, Act and Assert
    assertEquals("Name", ExtractorUtilities.sanitizeSheetName("Name"));
    assertEquals("", ExtractorUtilities.sanitizeSheetName(null));
    assertEquals("", ExtractorUtilities.sanitizeSheetName(";"));
    assertEquals("[]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]"));
    assertEquals("", ExtractorUtilities.sanitizeSheetName(";;"));
    assertEquals("[]", ExtractorUtilities.sanitizeSheetName(";[:;*?/\\\\]"));
    assertEquals("Name", ExtractorUtilities.sanitizeSheetName(";Name"));
    assertEquals("42", ExtractorUtilities.sanitizeSheetName(";42"));
    assertEquals("[]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\];"));
    assertEquals("[][]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\][:;*?/\\\\]"));
    assertEquals("[]Name", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]Name"));
    assertEquals("[]42", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]42"));
    assertEquals("Name", ExtractorUtilities.sanitizeSheetName("Name;"));
    assertEquals("Name[]", ExtractorUtilities.sanitizeSheetName("Name[:;*?/\\\\]"));
    assertEquals("42", ExtractorUtilities.sanitizeSheetName("42;"));
    assertEquals("42[]", ExtractorUtilities.sanitizeSheetName("42[:;*?/\\\\]"));
    assertEquals("", ExtractorUtilities.sanitizeSheetName(";;;"));
    assertEquals("[]", ExtractorUtilities.sanitizeSheetName(";;[:;*?/\\\\]"));
    assertEquals("Name", ExtractorUtilities.sanitizeSheetName(";;Name"));
    assertEquals("42", ExtractorUtilities.sanitizeSheetName(";;42"));
    assertEquals("[]", ExtractorUtilities.sanitizeSheetName(";[:;*?/\\\\];"));
    assertEquals("[][]", ExtractorUtilities.sanitizeSheetName(";[:;*?/\\\\][:;*?/\\\\]"));
    assertEquals("[]Name", ExtractorUtilities.sanitizeSheetName(";[:;*?/\\\\]Name"));
    assertEquals("[]42", ExtractorUtilities.sanitizeSheetName(";[:;*?/\\\\]42"));
    assertEquals("Name", ExtractorUtilities.sanitizeSheetName(";Name;"));
    assertEquals("Name[]", ExtractorUtilities.sanitizeSheetName(";Name[:;*?/\\\\]"));
    assertEquals("NameName", ExtractorUtilities.sanitizeSheetName(";NameName"));
    assertEquals("Name42", ExtractorUtilities.sanitizeSheetName(";Name42"));
    assertEquals("42", ExtractorUtilities.sanitizeSheetName(";42;"));
    assertEquals("42[]", ExtractorUtilities.sanitizeSheetName(";42[:;*?/\\\\]"));
    assertEquals("42Name", ExtractorUtilities.sanitizeSheetName(";42Name"));
    assertEquals("4242", ExtractorUtilities.sanitizeSheetName(";4242"));
    assertEquals("[]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\];;"));
    assertEquals("[][]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\];[:;*?/\\\\]"));
    assertEquals("[]Name", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\];Name"));
    assertEquals("[]42", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\];42"));
    assertEquals("[][]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\][:;*?/\\\\];"));
    assertEquals("[][][]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\][:;*?/\\\\][:;*?/\\\\]"));
    assertEquals("[][]Name", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\][:;*?/\\\\]Name"));
    assertEquals("[][]42", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\][:;*?/\\\\]42"));
    assertEquals("[]Name", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]Name;"));
    assertEquals("[]Name[]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]Name[:;*?/\\\\]"));
    assertEquals("[]NameName", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]NameName"));
    assertEquals("[]Name42", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]Name42"));
    assertEquals("[]42", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]42;"));
    assertEquals("[]42[]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]42[:;*?/\\\\]"));
    assertEquals("[]42Name", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]42Name"));
    assertEquals("[]4242", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]4242"));
    assertEquals("Name", ExtractorUtilities.sanitizeSheetName("Name;;"));
    assertEquals("Name[]", ExtractorUtilities.sanitizeSheetName("Name;[:;*?/\\\\]"));
    assertEquals("NameName", ExtractorUtilities.sanitizeSheetName("Name;Name"));
    assertEquals("Name42", ExtractorUtilities.sanitizeSheetName("Name;42"));
    assertEquals("Name[]", ExtractorUtilities.sanitizeSheetName("Name[:;*?/\\\\];"));
    assertEquals("Name[][]", ExtractorUtilities.sanitizeSheetName("Name[:;*?/\\\\][:;*?/\\\\]"));
    assertEquals("Name[]Name", ExtractorUtilities.sanitizeSheetName("Name[:;*?/\\\\]Name"));
    assertEquals("Name[]42", ExtractorUtilities.sanitizeSheetName("Name[:;*?/\\\\]42"));
    assertEquals("NameName", ExtractorUtilities.sanitizeSheetName("NameName;"));
    assertEquals("NameName[]", ExtractorUtilities.sanitizeSheetName("NameName[:;*?/\\\\]"));
    assertEquals("Name42", ExtractorUtilities.sanitizeSheetName("Name42;"));
    assertEquals("Name42[]", ExtractorUtilities.sanitizeSheetName("Name42[:;*?/\\\\]"));
    assertEquals("42", ExtractorUtilities.sanitizeSheetName("42;;"));
    assertEquals("42[]", ExtractorUtilities.sanitizeSheetName("42;[:;*?/\\\\]"));
    assertEquals("42Name", ExtractorUtilities.sanitizeSheetName("42;Name"));
    assertEquals("4242", ExtractorUtilities.sanitizeSheetName("42;42"));
    assertEquals("42[]", ExtractorUtilities.sanitizeSheetName("42[:;*?/\\\\];"));
    assertEquals("42[][]", ExtractorUtilities.sanitizeSheetName("42[:;*?/\\\\][:;*?/\\\\]"));
    assertEquals("42[]Name", ExtractorUtilities.sanitizeSheetName("42[:;*?/\\\\]Name"));
    assertEquals("42[]42", ExtractorUtilities.sanitizeSheetName("42[:;*?/\\\\]42"));
    assertEquals("42Name", ExtractorUtilities.sanitizeSheetName("42Name;"));
    assertEquals("42Name[]", ExtractorUtilities.sanitizeSheetName("42Name[:;*?/\\\\]"));
    assertEquals("4242", ExtractorUtilities.sanitizeSheetName("4242;"));
    assertEquals("4242[]", ExtractorUtilities.sanitizeSheetName("4242[:;*?/\\\\]"));
  }
}
