package org.finos.waltz.web.endpoints.extracts;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.xssf.streaming.DeferredSXSSFWorkbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spark.Request;

class ExtractorUtilitiesDiffblueTest {
  /**
   * Test {@link ExtractorUtilities#convertExcelToByteArray(SXSSFWorkbook)}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#convertExcelToByteArray(SXSSFWorkbook)}
   */
  @Test
  @DisplayName("Test convertExcelToByteArray(SXSSFWorkbook); then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ExtractorUtilities.convertExcelToByteArray(SXSSFWorkbook)"})
  void testConvertExcelToByteArray_thenReturnEmptyArrayOfByte() throws IOException {
    // Arrange
    DeferredSXSSFWorkbook workbook = mock(DeferredSXSSFWorkbook.class);
    doNothing().when(workbook).close();
    doNothing().when(workbook).write(Mockito.<OutputStream>any());

    // Act
    byte[] actualConvertExcelToByteArrayResult =
        ExtractorUtilities.convertExcelToByteArray(workbook);

    // Assert
    verify(workbook).close();
    verify(workbook).write(isA(OutputStream.class));
    assertArrayEquals(new byte[] {}, actualConvertExcelToByteArrayResult);
  }

  /**
   * Test {@link ExtractorUtilities#parseExtractFormat(Request)}.
   *
   * <ul>
   *   <li>Given {@code Query Params}.
   *   <li>Then return {@code CSV}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#parseExtractFormat(Request)}
   */
  @Test
  @DisplayName("Test parseExtractFormat(Request); given 'Query Params'; then return 'CSV'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExtractFormat ExtractorUtilities.parseExtractFormat(Request)"})
  void testParseExtractFormat_givenQueryParams_thenReturnCsv() {
    // Arrange
    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenReturn("Query Params");

    // Act
    ExtractFormat actualParseExtractFormatResult = ExtractorUtilities.parseExtractFormat(request);

    // Assert
    verify(request).queryParams("format");
    assertEquals(ExtractFormat.CSV, actualParseExtractFormatResult);
  }

  /**
   * Test {@link ExtractorUtilities#parseExtractFormat(Request)}.
   *
   * <ul>
   *   <li>Given {@code XLSX}.
   *   <li>When {@link Request} {@link Request#queryParams(String)} return {@code XLSX}.
   *   <li>Then return {@code XLSX}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#parseExtractFormat(Request)}
   */
  @Test
  @DisplayName(
      "Test parseExtractFormat(Request); given 'XLSX'; when Request queryParams(String) return 'XLSX'; then return 'XLSX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExtractFormat ExtractorUtilities.parseExtractFormat(Request)"})
  void testParseExtractFormat_givenXlsx_whenRequestQueryParamsReturnXlsx_thenReturnXlsx() {
    // Arrange
    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenReturn("XLSX");

    // Act
    ExtractFormat actualParseExtractFormatResult = ExtractorUtilities.parseExtractFormat(request);

    // Assert
    verify(request).queryParams("format");
    assertEquals(ExtractFormat.XLSX, actualParseExtractFormatResult);
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName() {
    // Arrange, Act and Assert
    assertEquals("[]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName2() {
    // Arrange, Act and Assert
    assertEquals("[]", ExtractorUtilities.sanitizeSheetName(";[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName3() {
    // Arrange, Act and Assert
    assertEquals("[]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\];"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName4() {
    // Arrange, Act and Assert
    assertEquals("[][]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\][:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName5() {
    // Arrange, Act and Assert
    assertEquals("[]", ExtractorUtilities.sanitizeSheetName(";;[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName6() {
    // Arrange, Act and Assert
    assertEquals("[]", ExtractorUtilities.sanitizeSheetName(";[:;*?/\\\\];"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName7() {
    // Arrange, Act and Assert
    assertEquals("[][]", ExtractorUtilities.sanitizeSheetName(";[:;*?/\\\\][:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName8() {
    // Arrange, Act and Assert
    assertEquals("[]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\];;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName9() {
    // Arrange, Act and Assert
    assertEquals("[][]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\];[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName10() {
    // Arrange, Act and Assert
    assertEquals("[][]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\][:;*?/\\\\];"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName11() {
    // Arrange, Act and Assert
    assertEquals(
        "[][][]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\][:;*?/\\\\][:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code ;42Name}.
   *   <li>Then return {@code 42Name}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';42Name'; then return '42Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42Name_thenReturn42Name() {
    // Arrange, Act and Assert
    assertEquals("42Name", ExtractorUtilities.sanitizeSheetName(";42Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code [:;*?/\\]42Name}.
   *   <li>Then return {@code []42Name}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '[:;*?/\\\\]42Name'; then return '[]42Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42Name_thenReturn42Name2() {
    // Arrange, Act and Assert
    assertEquals("[]42Name", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]42Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code 42;Name}.
   *   <li>Then return {@code 42Name}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '42;Name'; then return '42Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42Name_thenReturn42Name3() {
    // Arrange, Act and Assert
    assertEquals("42Name", ExtractorUtilities.sanitizeSheetName("42;Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code 42[:;*?/\\]Name}.
   *   <li>Then return {@code 42[]Name}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '42[:;*?/\\\\]Name'; then return '42[]Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42Name_thenReturn42Name4() {
    // Arrange, Act and Assert
    assertEquals("42[]Name", ExtractorUtilities.sanitizeSheetName("42[:;*?/\\\\]Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code 42Name;}.
   *   <li>Then return {@code 42Name}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '42Name;'; then return '42Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42Name_thenReturn42Name5() {
    // Arrange, Act and Assert
    assertEquals("42Name", ExtractorUtilities.sanitizeSheetName("42Name;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code 42Name[:;*?/\\]}.
   *   <li>Then return {@code 42Name[]}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '42Name[:;*?/\\\\]'; then return '42Name[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42Name_thenReturn42Name6() {
    // Arrange, Act and Assert
    assertEquals("42Name[]", ExtractorUtilities.sanitizeSheetName("42Name[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code ;42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", ExtractorUtilities.sanitizeSheetName(";42"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code [:;*?/\\]42}.
   *   <li>Then return {@code []42}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '[:;*?/\\\\]42'; then return '[]42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals("[]42", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]42"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code 42;}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '42;'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn423() {
    // Arrange, Act and Assert
    assertEquals("42", ExtractorUtilities.sanitizeSheetName("42;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code 42[:;*?/\\]}.
   *   <li>Then return {@code 42[]}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '42[:;*?/\\\\]'; then return '42[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn424() {
    // Arrange, Act and Assert
    assertEquals("42[]", ExtractorUtilities.sanitizeSheetName("42[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code ;;42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';;42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn425() {
    // Arrange, Act and Assert
    assertEquals("42", ExtractorUtilities.sanitizeSheetName(";;42"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code ;[:;*?/\\]42}.
   *   <li>Then return {@code []42}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';[:;*?/\\\\]42'; then return '[]42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn426() {
    // Arrange, Act and Assert
    assertEquals("[]42", ExtractorUtilities.sanitizeSheetName(";[:;*?/\\\\]42"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code ;42;}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';42;'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn427() {
    // Arrange, Act and Assert
    assertEquals("42", ExtractorUtilities.sanitizeSheetName(";42;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code ;42[:;*?/\\]}.
   *   <li>Then return {@code 42[]}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';42[:;*?/\\\\]'; then return '42[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn428() {
    // Arrange, Act and Assert
    assertEquals("42[]", ExtractorUtilities.sanitizeSheetName(";42[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code [:;*?/\\];42}.
   *   <li>Then return {@code []42}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '[:;*?/\\\\];42'; then return '[]42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn429() {
    // Arrange, Act and Assert
    assertEquals("[]42", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\];42"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code [:;*?/\\][:;*?/\\]42}.
   *   <li>Then return {@code [][]42}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName(
      "Test sanitizeSheetName(String); when '[:;*?/\\\\][:;*?/\\\\]42'; then return '[][]42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn4210() {
    // Arrange, Act and Assert
    assertEquals("[][]42", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\][:;*?/\\\\]42"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code [:;*?/\\]42;}.
   *   <li>Then return {@code []42}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '[:;*?/\\\\]42;'; then return '[]42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn4211() {
    // Arrange, Act and Assert
    assertEquals("[]42", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]42;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code [:;*?/\\]42[:;*?/\\]}.
   *   <li>Then return {@code []42[]}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName(
      "Test sanitizeSheetName(String); when '[:;*?/\\\\]42[:;*?/\\\\]'; then return '[]42[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn4212() {
    // Arrange, Act and Assert
    assertEquals("[]42[]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]42[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code 42;;}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '42;;'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn4213() {
    // Arrange, Act and Assert
    assertEquals("42", ExtractorUtilities.sanitizeSheetName("42;;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code 42;[:;*?/\\]}.
   *   <li>Then return {@code 42[]}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '42;[:;*?/\\\\]'; then return '42[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn4214() {
    // Arrange, Act and Assert
    assertEquals("42[]", ExtractorUtilities.sanitizeSheetName("42;[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code 42[:;*?/\\];}.
   *   <li>Then return {@code 42[]}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '42[:;*?/\\\\];'; then return '42[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn4215() {
    // Arrange, Act and Assert
    assertEquals("42[]", ExtractorUtilities.sanitizeSheetName("42[:;*?/\\\\];"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code 42[:;*?/\\][:;*?/\\]}.
   *   <li>Then return {@code 42[][]}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName(
      "Test sanitizeSheetName(String); when '42[:;*?/\\\\][:;*?/\\\\]'; then return '42[][]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn4216() {
    // Arrange, Act and Assert
    assertEquals("42[][]", ExtractorUtilities.sanitizeSheetName("42[:;*?/\\\\][:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code ;4242}.
   *   <li>Then return {@code 4242}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';4242'; then return '4242'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when4242_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242", ExtractorUtilities.sanitizeSheetName(";4242"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code [:;*?/\\]4242}.
   *   <li>Then return {@code []4242}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '[:;*?/\\\\]4242'; then return '[]4242'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when4242_thenReturn42422() {
    // Arrange, Act and Assert
    assertEquals("[]4242", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]4242"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code 42;42}.
   *   <li>Then return {@code 4242}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '42;42'; then return '4242'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when4242_thenReturn42423() {
    // Arrange, Act and Assert
    assertEquals("4242", ExtractorUtilities.sanitizeSheetName("42;42"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code 42[:;*?/\\]42}.
   *   <li>Then return {@code 42[]42}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '42[:;*?/\\\\]42'; then return '42[]42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when4242_thenReturn42424() {
    // Arrange, Act and Assert
    assertEquals("42[]42", ExtractorUtilities.sanitizeSheetName("42[:;*?/\\\\]42"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code 4242;}.
   *   <li>Then return {@code 4242}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '4242;'; then return '4242'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when4242_thenReturn42425() {
    // Arrange, Act and Assert
    assertEquals("4242", ExtractorUtilities.sanitizeSheetName("4242;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code 4242[:;*?/\\]}.
   *   <li>Then return {@code 4242[]}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '4242[:;*?/\\\\]'; then return '4242[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when4242_thenReturn42426() {
    // Arrange, Act and Assert
    assertEquals("4242[]", ExtractorUtilities.sanitizeSheetName("4242[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code ;Name42}.
   *   <li>Then return {@code Name42}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';Name42'; then return 'Name42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName42_thenReturnName42() {
    // Arrange, Act and Assert
    assertEquals("Name42", ExtractorUtilities.sanitizeSheetName(";Name42"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code [:;*?/\\]Name42}.
   *   <li>Then return {@code []Name42}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '[:;*?/\\\\]Name42'; then return '[]Name42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName42_thenReturnName422() {
    // Arrange, Act and Assert
    assertEquals("[]Name42", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]Name42"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code Name;42}.
   *   <li>Then return {@code Name42}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'Name;42'; then return 'Name42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName42_thenReturnName423() {
    // Arrange, Act and Assert
    assertEquals("Name42", ExtractorUtilities.sanitizeSheetName("Name;42"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code Name[:;*?/\\]42}.
   *   <li>Then return {@code Name[]42}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'Name[:;*?/\\\\]42'; then return 'Name[]42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName42_thenReturnName424() {
    // Arrange, Act and Assert
    assertEquals("Name[]42", ExtractorUtilities.sanitizeSheetName("Name[:;*?/\\\\]42"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code Name42;}.
   *   <li>Then return {@code Name42}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'Name42;'; then return 'Name42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName42_thenReturnName425() {
    // Arrange, Act and Assert
    assertEquals("Name42", ExtractorUtilities.sanitizeSheetName("Name42;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code Name42[:;*?/\\]}.
   *   <li>Then return {@code Name42[]}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'Name42[:;*?/\\\\]'; then return 'Name42[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName42_thenReturnName426() {
    // Arrange, Act and Assert
    assertEquals("Name42[]", ExtractorUtilities.sanitizeSheetName("Name42[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code ;NameName}.
   *   <li>Then return {@code NameName}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';NameName'; then return 'NameName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenNameName_thenReturnNameName() {
    // Arrange, Act and Assert
    assertEquals("NameName", ExtractorUtilities.sanitizeSheetName(";NameName"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code [:;*?/\\]NameName}.
   *   <li>Then return {@code []NameName}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName(
      "Test sanitizeSheetName(String); when '[:;*?/\\\\]NameName'; then return '[]NameName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenNameName_thenReturnNameName2() {
    // Arrange, Act and Assert
    assertEquals("[]NameName", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]NameName"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code Name;Name}.
   *   <li>Then return {@code NameName}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'Name;Name'; then return 'NameName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenNameName_thenReturnNameName3() {
    // Arrange, Act and Assert
    assertEquals("NameName", ExtractorUtilities.sanitizeSheetName("Name;Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code Name[:;*?/\\]Name}.
   *   <li>Then return {@code Name[]Name}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName(
      "Test sanitizeSheetName(String); when 'Name[:;*?/\\\\]Name'; then return 'Name[]Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenNameName_thenReturnNameName4() {
    // Arrange, Act and Assert
    assertEquals("Name[]Name", ExtractorUtilities.sanitizeSheetName("Name[:;*?/\\\\]Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code NameName;}.
   *   <li>Then return {@code NameName}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'NameName;'; then return 'NameName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenNameName_thenReturnNameName5() {
    // Arrange, Act and Assert
    assertEquals("NameName", ExtractorUtilities.sanitizeSheetName("NameName;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code NameName[:;*?/\\]}.
   *   <li>Then return {@code NameName[]}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName(
      "Test sanitizeSheetName(String); when 'NameName[:;*?/\\\\]'; then return 'NameName[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenNameName_thenReturnNameName6() {
    // Arrange, Act and Assert
    assertEquals("NameName[]", ExtractorUtilities.sanitizeSheetName("NameName[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'Name'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName() {
    // Arrange, Act and Assert
    assertEquals("Name", ExtractorUtilities.sanitizeSheetName("Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code ;Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';Name'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName2() {
    // Arrange, Act and Assert
    assertEquals("Name", ExtractorUtilities.sanitizeSheetName(";Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code [:;*?/\\]Name}.
   *   <li>Then return {@code []Name}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '[:;*?/\\\\]Name'; then return '[]Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName3() {
    // Arrange, Act and Assert
    assertEquals("[]Name", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code Name;}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'Name;'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName4() {
    // Arrange, Act and Assert
    assertEquals("Name", ExtractorUtilities.sanitizeSheetName("Name;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code Name[:;*?/\\]}.
   *   <li>Then return {@code Name[]}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'Name[:;*?/\\\\]'; then return 'Name[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName5() {
    // Arrange, Act and Assert
    assertEquals("Name[]", ExtractorUtilities.sanitizeSheetName("Name[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code ;;Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';;Name'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName6() {
    // Arrange, Act and Assert
    assertEquals("Name", ExtractorUtilities.sanitizeSheetName(";;Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code ;[:;*?/\\]Name}.
   *   <li>Then return {@code []Name}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';[:;*?/\\\\]Name'; then return '[]Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName7() {
    // Arrange, Act and Assert
    assertEquals("[]Name", ExtractorUtilities.sanitizeSheetName(";[:;*?/\\\\]Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code ;Name;}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';Name;'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName8() {
    // Arrange, Act and Assert
    assertEquals("Name", ExtractorUtilities.sanitizeSheetName(";Name;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code ;Name[:;*?/\\]}.
   *   <li>Then return {@code Name[]}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';Name[:;*?/\\\\]'; then return 'Name[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName9() {
    // Arrange, Act and Assert
    assertEquals("Name[]", ExtractorUtilities.sanitizeSheetName(";Name[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code [:;*?/\\];Name}.
   *   <li>Then return {@code []Name}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '[:;*?/\\\\];Name'; then return '[]Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName10() {
    // Arrange, Act and Assert
    assertEquals("[]Name", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\];Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code [:;*?/\\][:;*?/\\]Name}.
   *   <li>Then return {@code [][]Name}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName(
      "Test sanitizeSheetName(String); when '[:;*?/\\\\][:;*?/\\\\]Name'; then return '[][]Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName11() {
    // Arrange, Act and Assert
    assertEquals("[][]Name", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\][:;*?/\\\\]Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code [:;*?/\\]Name;}.
   *   <li>Then return {@code []Name}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '[:;*?/\\\\]Name;'; then return '[]Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName12() {
    // Arrange, Act and Assert
    assertEquals("[]Name", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]Name;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code [:;*?/\\]Name[:;*?/\\]}.
   *   <li>Then return {@code []Name[]}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName(
      "Test sanitizeSheetName(String); when '[:;*?/\\\\]Name[:;*?/\\\\]'; then return '[]Name[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName13() {
    // Arrange, Act and Assert
    assertEquals("[]Name[]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]Name[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code Name;;}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'Name;;'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName14() {
    // Arrange, Act and Assert
    assertEquals("Name", ExtractorUtilities.sanitizeSheetName("Name;;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code Name;[:;*?/\\]}.
   *   <li>Then return {@code Name[]}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'Name;[:;*?/\\\\]'; then return 'Name[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName15() {
    // Arrange, Act and Assert
    assertEquals("Name[]", ExtractorUtilities.sanitizeSheetName("Name;[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code Name[:;*?/\\];}.
   *   <li>Then return {@code Name[]}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'Name[:;*?/\\\\];'; then return 'Name[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName16() {
    // Arrange, Act and Assert
    assertEquals("Name[]", ExtractorUtilities.sanitizeSheetName("Name[:;*?/\\\\];"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code Name[:;*?/\\][:;*?/\\]}.
   *   <li>Then return {@code Name[][]}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName(
      "Test sanitizeSheetName(String); when 'Name[:;*?/\\\\][:;*?/\\\\]'; then return 'Name[][]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName17() {
    // Arrange, Act and Assert
    assertEquals("Name[][]", ExtractorUtilities.sanitizeSheetName("Name[:;*?/\\\\][:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'null'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ExtractorUtilities.sanitizeSheetName(null));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code ;;;}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';;;'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenSemicolonSemicolonSemicolon_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ExtractorUtilities.sanitizeSheetName(";;;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code ;;}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';;'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenSemicolonSemicolon_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ExtractorUtilities.sanitizeSheetName(";;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   *
   * <ul>
   *   <li>When {@code ;}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenSemicolon_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ExtractorUtilities.sanitizeSheetName(";"));
  }
}
