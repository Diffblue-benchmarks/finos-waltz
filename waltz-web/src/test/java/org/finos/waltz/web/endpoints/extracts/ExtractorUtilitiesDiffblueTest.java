package org.finos.waltz.web.endpoints.extracts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.ZipPackage;
import org.apache.poi.openxml4j.opc.internal.MemoryPackagePart;
import org.apache.poi.poifs.crypt.temp.SXSSFWorkbookWithCustomZipEntrySource;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spark.Request;

class ExtractorUtilitiesDiffblueTest {
  /**
   * Test {@link ExtractorUtilities#convertExcelToByteArray(SXSSFWorkbook)}.
   * <p>
   * Method under test: {@link ExtractorUtilities#convertExcelToByteArray(SXSSFWorkbook)}
   */
  @Test
  @DisplayName("Test convertExcelToByteArray(SXSSFWorkbook)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ExtractorUtilities.convertExcelToByteArray(SXSSFWorkbook)"})
  void testConvertExcelToByteArray() throws IOException, InvalidFormatException {
    // Arrange
    SXSSFWorkbookWithCustomZipEntrySource workbook = new SXSSFWorkbookWithCustomZipEntrySource();

    // Act
    ExtractorUtilities.convertExcelToByteArray(workbook);

    // Assert
    XSSFWorkbook xSSFWorkbook = workbook.getXSSFWorkbook();
    PackagePart packagePart = xSSFWorkbook.getPackagePart();
    OPCPackage resultPackage = packagePart.getPackage();
    assertTrue(resultPackage instanceof ZipPackage);
    assertTrue(packagePart instanceof MemoryPackagePart);
    PackagePart packagePart2 = xSSFWorkbook.getSharedStringSource().getPackagePart();
    assertTrue(packagePart2 instanceof MemoryPackagePart);
    PackagePart packagePart3 = xSSFWorkbook.getStylesSource().getPackagePart();
    assertTrue(packagePart3 instanceof MemoryPackagePart);
    assertEquals(5, resultPackage.getParts().size());
    assertSame(resultPackage, packagePart2.getPackage());
    assertSame(resultPackage, packagePart3.getPackage());
  }

  /**
   * Test {@link ExtractorUtilities#parseExtractFormat(Request)}.
   * <ul>
   *   <li>Given {@code Query Params}.</li>
   *   <li>Then return {@code CSV}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#parseExtractFormat(Request)}
   */
  @Test
  @DisplayName("Test parseExtractFormat(Request); given 'Query Params'; then return 'CSV'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExtractFormat ExtractorUtilities.parseExtractFormat(Request)"})
  void testParseExtractFormat_givenQueryParams_thenReturnCsv() {
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
   * Test {@link ExtractorUtilities#parseExtractFormat(Request)}.
   * <ul>
   *   <li>Given {@code XLSX}.</li>
   *   <li>When {@link Request} {@link Request#queryParams(String)} return {@code XLSX}.</li>
   *   <li>Then return {@code XLSX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#parseExtractFormat(Request)}
   */
  @Test
  @DisplayName("Test parseExtractFormat(Request); given 'XLSX'; when Request queryParams(String) return 'XLSX'; then return 'XLSX'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExtractFormat ExtractorUtilities.parseExtractFormat(Request)"})
  void testParseExtractFormat_givenXlsx_whenRequestQueryParamsReturnXlsx_thenReturnXlsx() {
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
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName() {
    // Arrange, Act and Assert
    assertEquals("[]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName2() {
    // Arrange, Act and Assert
    assertEquals("[]", ExtractorUtilities.sanitizeSheetName(";[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName3() {
    // Arrange, Act and Assert
    assertEquals("[]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\];"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName4() {
    // Arrange, Act and Assert
    assertEquals("[][]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\][:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName5() {
    // Arrange, Act and Assert
    assertEquals("[]", ExtractorUtilities.sanitizeSheetName(";;[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName6() {
    // Arrange, Act and Assert
    assertEquals("[]", ExtractorUtilities.sanitizeSheetName(";[:;*?/\\\\];"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName7() {
    // Arrange, Act and Assert
    assertEquals("[][]", ExtractorUtilities.sanitizeSheetName(";[:;*?/\\\\][:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName8() {
    // Arrange, Act and Assert
    assertEquals("[]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\];;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName9() {
    // Arrange, Act and Assert
    assertEquals("[][]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\];[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName10() {
    // Arrange, Act and Assert
    assertEquals("[][]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\][:;*?/\\\\];"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName11() {
    // Arrange, Act and Assert
    assertEquals("[][][]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\][:;*?/\\\\][:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code ;42Name}.</li>
   *   <li>Then return {@code 42Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';42Name'; then return '42Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42Name_thenReturn42Name() {
    // Arrange, Act and Assert
    assertEquals("42Name", ExtractorUtilities.sanitizeSheetName(";42Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code [:;*?/\\]42Name}.</li>
   *   <li>Then return {@code []42Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '[:;*?/\\\\]42Name'; then return '[]42Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42Name_thenReturn42Name2() {
    // Arrange, Act and Assert
    assertEquals("[]42Name", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]42Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code 42;Name}.</li>
   *   <li>Then return {@code 42Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '42;Name'; then return '42Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42Name_thenReturn42Name3() {
    // Arrange, Act and Assert
    assertEquals("42Name", ExtractorUtilities.sanitizeSheetName("42;Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code 42[:;*?/\\]Name}.</li>
   *   <li>Then return {@code 42[]Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '42[:;*?/\\\\]Name'; then return '42[]Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42Name_thenReturn42Name4() {
    // Arrange, Act and Assert
    assertEquals("42[]Name", ExtractorUtilities.sanitizeSheetName("42[:;*?/\\\\]Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code 42Name;}.</li>
   *   <li>Then return {@code 42Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '42Name;'; then return '42Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42Name_thenReturn42Name5() {
    // Arrange, Act and Assert
    assertEquals("42Name", ExtractorUtilities.sanitizeSheetName("42Name;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code 42Name[:;*?/\\]}.</li>
   *   <li>Then return {@code 42Name[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '42Name[:;*?/\\\\]'; then return '42Name[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42Name_thenReturn42Name6() {
    // Arrange, Act and Assert
    assertEquals("42Name[]", ExtractorUtilities.sanitizeSheetName("42Name[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code ;42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", ExtractorUtilities.sanitizeSheetName(";42"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code [:;*?/\\]42}.</li>
   *   <li>Then return {@code []42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '[:;*?/\\\\]42'; then return '[]42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals("[]42", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]42"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code 42;}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '42;'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn423() {
    // Arrange, Act and Assert
    assertEquals("42", ExtractorUtilities.sanitizeSheetName("42;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code 42[:;*?/\\]}.</li>
   *   <li>Then return {@code 42[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '42[:;*?/\\\\]'; then return '42[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn424() {
    // Arrange, Act and Assert
    assertEquals("42[]", ExtractorUtilities.sanitizeSheetName("42[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code ;;42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';;42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn425() {
    // Arrange, Act and Assert
    assertEquals("42", ExtractorUtilities.sanitizeSheetName(";;42"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code ;[:;*?/\\]42}.</li>
   *   <li>Then return {@code []42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';[:;*?/\\\\]42'; then return '[]42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn426() {
    // Arrange, Act and Assert
    assertEquals("[]42", ExtractorUtilities.sanitizeSheetName(";[:;*?/\\\\]42"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code ;42;}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';42;'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn427() {
    // Arrange, Act and Assert
    assertEquals("42", ExtractorUtilities.sanitizeSheetName(";42;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code ;42[:;*?/\\]}.</li>
   *   <li>Then return {@code 42[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';42[:;*?/\\\\]'; then return '42[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn428() {
    // Arrange, Act and Assert
    assertEquals("42[]", ExtractorUtilities.sanitizeSheetName(";42[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code [:;*?/\\];42}.</li>
   *   <li>Then return {@code []42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '[:;*?/\\\\];42'; then return '[]42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn429() {
    // Arrange, Act and Assert
    assertEquals("[]42", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\];42"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code [:;*?/\\][:;*?/\\]42}.</li>
   *   <li>Then return {@code [][]42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '[:;*?/\\\\][:;*?/\\\\]42'; then return '[][]42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn4210() {
    // Arrange, Act and Assert
    assertEquals("[][]42", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\][:;*?/\\\\]42"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code [:;*?/\\]42;}.</li>
   *   <li>Then return {@code []42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '[:;*?/\\\\]42;'; then return '[]42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn4211() {
    // Arrange, Act and Assert
    assertEquals("[]42", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]42;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code [:;*?/\\]42[:;*?/\\]}.</li>
   *   <li>Then return {@code []42[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '[:;*?/\\\\]42[:;*?/\\\\]'; then return '[]42[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn4212() {
    // Arrange, Act and Assert
    assertEquals("[]42[]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]42[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code 42;;}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '42;;'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn4213() {
    // Arrange, Act and Assert
    assertEquals("42", ExtractorUtilities.sanitizeSheetName("42;;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code 42;[:;*?/\\]}.</li>
   *   <li>Then return {@code 42[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '42;[:;*?/\\\\]'; then return '42[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn4214() {
    // Arrange, Act and Assert
    assertEquals("42[]", ExtractorUtilities.sanitizeSheetName("42;[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code 42[:;*?/\\];}.</li>
   *   <li>Then return {@code 42[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '42[:;*?/\\\\];'; then return '42[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn4215() {
    // Arrange, Act and Assert
    assertEquals("42[]", ExtractorUtilities.sanitizeSheetName("42[:;*?/\\\\];"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code 42[:;*?/\\][:;*?/\\]}.</li>
   *   <li>Then return {@code 42[][]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '42[:;*?/\\\\][:;*?/\\\\]'; then return '42[][]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when42_thenReturn4216() {
    // Arrange, Act and Assert
    assertEquals("42[][]", ExtractorUtilities.sanitizeSheetName("42[:;*?/\\\\][:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code ;4242}.</li>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';4242'; then return '4242'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when4242_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242", ExtractorUtilities.sanitizeSheetName(";4242"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code [:;*?/\\]4242}.</li>
   *   <li>Then return {@code []4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '[:;*?/\\\\]4242'; then return '[]4242'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when4242_thenReturn42422() {
    // Arrange, Act and Assert
    assertEquals("[]4242", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]4242"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code 42;42}.</li>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '42;42'; then return '4242'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when4242_thenReturn42423() {
    // Arrange, Act and Assert
    assertEquals("4242", ExtractorUtilities.sanitizeSheetName("42;42"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code 42[:;*?/\\]42}.</li>
   *   <li>Then return {@code 42[]42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '42[:;*?/\\\\]42'; then return '42[]42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when4242_thenReturn42424() {
    // Arrange, Act and Assert
    assertEquals("42[]42", ExtractorUtilities.sanitizeSheetName("42[:;*?/\\\\]42"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code 4242;}.</li>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '4242;'; then return '4242'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when4242_thenReturn42425() {
    // Arrange, Act and Assert
    assertEquals("4242", ExtractorUtilities.sanitizeSheetName("4242;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code 4242[:;*?/\\]}.</li>
   *   <li>Then return {@code 4242[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '4242[:;*?/\\\\]'; then return '4242[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_when4242_thenReturn42426() {
    // Arrange, Act and Assert
    assertEquals("4242[]", ExtractorUtilities.sanitizeSheetName("4242[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code ;Name42}.</li>
   *   <li>Then return {@code Name42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';Name42'; then return 'Name42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName42_thenReturnName42() {
    // Arrange, Act and Assert
    assertEquals("Name42", ExtractorUtilities.sanitizeSheetName(";Name42"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code [:;*?/\\]Name42}.</li>
   *   <li>Then return {@code []Name42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '[:;*?/\\\\]Name42'; then return '[]Name42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName42_thenReturnName422() {
    // Arrange, Act and Assert
    assertEquals("[]Name42", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]Name42"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code Name;42}.</li>
   *   <li>Then return {@code Name42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'Name;42'; then return 'Name42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName42_thenReturnName423() {
    // Arrange, Act and Assert
    assertEquals("Name42", ExtractorUtilities.sanitizeSheetName("Name;42"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code Name[:;*?/\\]42}.</li>
   *   <li>Then return {@code Name[]42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'Name[:;*?/\\\\]42'; then return 'Name[]42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName42_thenReturnName424() {
    // Arrange, Act and Assert
    assertEquals("Name[]42", ExtractorUtilities.sanitizeSheetName("Name[:;*?/\\\\]42"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code Name42;}.</li>
   *   <li>Then return {@code Name42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'Name42;'; then return 'Name42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName42_thenReturnName425() {
    // Arrange, Act and Assert
    assertEquals("Name42", ExtractorUtilities.sanitizeSheetName("Name42;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code Name42[:;*?/\\]}.</li>
   *   <li>Then return {@code Name42[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'Name42[:;*?/\\\\]'; then return 'Name42[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName42_thenReturnName426() {
    // Arrange, Act and Assert
    assertEquals("Name42[]", ExtractorUtilities.sanitizeSheetName("Name42[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code ;NameName}.</li>
   *   <li>Then return {@code NameName}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';NameName'; then return 'NameName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenNameName_thenReturnNameName() {
    // Arrange, Act and Assert
    assertEquals("NameName", ExtractorUtilities.sanitizeSheetName(";NameName"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code [:;*?/\\]NameName}.</li>
   *   <li>Then return {@code []NameName}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '[:;*?/\\\\]NameName'; then return '[]NameName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenNameName_thenReturnNameName2() {
    // Arrange, Act and Assert
    assertEquals("[]NameName", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]NameName"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code Name;Name}.</li>
   *   <li>Then return {@code NameName}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'Name;Name'; then return 'NameName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenNameName_thenReturnNameName3() {
    // Arrange, Act and Assert
    assertEquals("NameName", ExtractorUtilities.sanitizeSheetName("Name;Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code Name[:;*?/\\]Name}.</li>
   *   <li>Then return {@code Name[]Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'Name[:;*?/\\\\]Name'; then return 'Name[]Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenNameName_thenReturnNameName4() {
    // Arrange, Act and Assert
    assertEquals("Name[]Name", ExtractorUtilities.sanitizeSheetName("Name[:;*?/\\\\]Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code NameName;}.</li>
   *   <li>Then return {@code NameName}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'NameName;'; then return 'NameName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenNameName_thenReturnNameName5() {
    // Arrange, Act and Assert
    assertEquals("NameName", ExtractorUtilities.sanitizeSheetName("NameName;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code NameName[:;*?/\\]}.</li>
   *   <li>Then return {@code NameName[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'NameName[:;*?/\\\\]'; then return 'NameName[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenNameName_thenReturnNameName6() {
    // Arrange, Act and Assert
    assertEquals("NameName[]", ExtractorUtilities.sanitizeSheetName("NameName[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'Name'; then return 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName() {
    // Arrange, Act and Assert
    assertEquals("Name", ExtractorUtilities.sanitizeSheetName("Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code ;Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';Name'; then return 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName2() {
    // Arrange, Act and Assert
    assertEquals("Name", ExtractorUtilities.sanitizeSheetName(";Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code [:;*?/\\]Name}.</li>
   *   <li>Then return {@code []Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '[:;*?/\\\\]Name'; then return '[]Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName3() {
    // Arrange, Act and Assert
    assertEquals("[]Name", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code Name;}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'Name;'; then return 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName4() {
    // Arrange, Act and Assert
    assertEquals("Name", ExtractorUtilities.sanitizeSheetName("Name;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code Name[:;*?/\\]}.</li>
   *   <li>Then return {@code Name[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'Name[:;*?/\\\\]'; then return 'Name[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName5() {
    // Arrange, Act and Assert
    assertEquals("Name[]", ExtractorUtilities.sanitizeSheetName("Name[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code ;;Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';;Name'; then return 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName6() {
    // Arrange, Act and Assert
    assertEquals("Name", ExtractorUtilities.sanitizeSheetName(";;Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code ;[:;*?/\\]Name}.</li>
   *   <li>Then return {@code []Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';[:;*?/\\\\]Name'; then return '[]Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName7() {
    // Arrange, Act and Assert
    assertEquals("[]Name", ExtractorUtilities.sanitizeSheetName(";[:;*?/\\\\]Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code ;Name;}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';Name;'; then return 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName8() {
    // Arrange, Act and Assert
    assertEquals("Name", ExtractorUtilities.sanitizeSheetName(";Name;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code ;Name[:;*?/\\]}.</li>
   *   <li>Then return {@code Name[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';Name[:;*?/\\\\]'; then return 'Name[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName9() {
    // Arrange, Act and Assert
    assertEquals("Name[]", ExtractorUtilities.sanitizeSheetName(";Name[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code [:;*?/\\];Name}.</li>
   *   <li>Then return {@code []Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '[:;*?/\\\\];Name'; then return '[]Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName10() {
    // Arrange, Act and Assert
    assertEquals("[]Name", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\];Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code [:;*?/\\][:;*?/\\]Name}.</li>
   *   <li>Then return {@code [][]Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '[:;*?/\\\\][:;*?/\\\\]Name'; then return '[][]Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName11() {
    // Arrange, Act and Assert
    assertEquals("[][]Name", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\][:;*?/\\\\]Name"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code [:;*?/\\]Name;}.</li>
   *   <li>Then return {@code []Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '[:;*?/\\\\]Name;'; then return '[]Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName12() {
    // Arrange, Act and Assert
    assertEquals("[]Name", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]Name;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code [:;*?/\\]Name[:;*?/\\]}.</li>
   *   <li>Then return {@code []Name[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when '[:;*?/\\\\]Name[:;*?/\\\\]'; then return '[]Name[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName13() {
    // Arrange, Act and Assert
    assertEquals("[]Name[]", ExtractorUtilities.sanitizeSheetName("[:;*?/\\\\]Name[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code Name;;}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'Name;;'; then return 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName14() {
    // Arrange, Act and Assert
    assertEquals("Name", ExtractorUtilities.sanitizeSheetName("Name;;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code Name;[:;*?/\\]}.</li>
   *   <li>Then return {@code Name[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'Name;[:;*?/\\\\]'; then return 'Name[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName15() {
    // Arrange, Act and Assert
    assertEquals("Name[]", ExtractorUtilities.sanitizeSheetName("Name;[:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code Name[:;*?/\\];}.</li>
   *   <li>Then return {@code Name[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'Name[:;*?/\\\\];'; then return 'Name[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName16() {
    // Arrange, Act and Assert
    assertEquals("Name[]", ExtractorUtilities.sanitizeSheetName("Name[:;*?/\\\\];"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code Name[:;*?/\\][:;*?/\\]}.</li>
   *   <li>Then return {@code Name[][]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'Name[:;*?/\\\\][:;*?/\\\\]'; then return 'Name[][]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenName_thenReturnName17() {
    // Arrange, Act and Assert
    assertEquals("Name[][]", ExtractorUtilities.sanitizeSheetName("Name[:;*?/\\\\][:;*?/\\\\]"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when 'null'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ExtractorUtilities.sanitizeSheetName(null));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code ;;;}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';;;'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenSemicolonSemicolonSemicolon_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ExtractorUtilities.sanitizeSheetName(";;;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code ;;}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';;'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenSemicolonSemicolon_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ExtractorUtilities.sanitizeSheetName(";;"));
  }

  /**
   * Test {@link ExtractorUtilities#sanitizeSheetName(String)}.
   * <ul>
   *   <li>When {@code ;}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtractorUtilities#sanitizeSheetName(String)}
   */
  @Test
  @DisplayName("Test sanitizeSheetName(String); when ';'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExtractorUtilities.sanitizeSheetName(String)"})
  void testSanitizeSheetName_whenSemicolon_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ExtractorUtilities.sanitizeSheetName(";"));
  }
}
