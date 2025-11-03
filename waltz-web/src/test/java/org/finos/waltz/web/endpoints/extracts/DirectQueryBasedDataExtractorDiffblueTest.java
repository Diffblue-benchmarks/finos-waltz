package org.finos.waltz.web.endpoints.extracts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.DeferredSXSSFSheet;
import org.apache.poi.xssf.streaming.DeferredSXSSFWorkbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.Select;
import org.jooq.exception.DataAccessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import spark.Request;
import spark.Response;

@ExtendWith(MockitoExtension.class)
class DirectQueryBasedDataExtractorDiffblueTest {
  @InjectMocks
  private ActorExtractor actorExtractor;

  @Mock
  private DSLContext dSLContext;

  /**
   * Test {@link DirectQueryBasedDataExtractor#writeExtract(String, Select, Request, Response)}.
   * <ul>
   *   <li>Given {@code JSON}.</li>
   *   <li>When {@link Request} {@link Request#queryParams(String)} return {@code JSON}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectQueryBasedDataExtractor#writeExtract(String, Select, Request, Response)}
   */
  @Test
  @DisplayName("Test writeExtract(String, Select, Request, Response); given 'JSON'; when Request queryParams(String) return 'JSON'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object DirectQueryBasedDataExtractor.writeExtract(String, Select, Request, Response)"})
  void testWriteExtract_givenJson_whenRequestQueryParamsReturnJson() throws IOException {
    // Arrange
    Select<Record> qry = mock(Select.class);
    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenReturn("JSON");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> actorExtractor.writeExtract("foo.txt", qry, request, null));
    verify(request).queryParams(eq("format"));
  }

  /**
   * Test {@link DirectQueryBasedDataExtractor#writeExtract(String, Select, Request, Response)}.
   * <ul>
   *   <li>Given {@code SVG}.</li>
   *   <li>When {@link Request} {@link Request#queryParams(String)} return {@code SVG}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectQueryBasedDataExtractor#writeExtract(String, Select, Request, Response)}
   */
  @Test
  @DisplayName("Test writeExtract(String, Select, Request, Response); given 'SVG'; when Request queryParams(String) return 'SVG'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object DirectQueryBasedDataExtractor.writeExtract(String, Select, Request, Response)"})
  void testWriteExtract_givenSvg_whenRequestQueryParamsReturnSvg() throws IOException {
    // Arrange
    Select<Record> qry = mock(Select.class);
    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenReturn("SVG");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> actorExtractor.writeExtract("foo.txt", qry, request, null));
    verify(request).queryParams(eq("format"));
  }

  /**
   * Test {@link DirectQueryBasedDataExtractor#writeExtract(String, Select, Request, Response)}.
   * <ul>
   *   <li>When {@link Response} {@link Response#header(String, String)} does nothing.</li>
   *   <li>Then return {@code Format CSV}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectQueryBasedDataExtractor#writeExtract(String, Select, Request, Response)}
   */
  @Test
  @DisplayName("Test writeExtract(String, Select, Request, Response); when Response header(String, String) does nothing; then return 'Format CSV'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object DirectQueryBasedDataExtractor.writeExtract(String, Select, Request, Response)"})
  void testWriteExtract_whenResponseHeaderDoesNothing_thenReturnFormatCsv() throws IOException, DataAccessException {
    // Arrange
    Result<Record> resultRecordList = mock(Result.class);
    when(resultRecordList.formatCSV()).thenReturn("Format CSV");
    Select<Record> qry = mock(Select.class);
    when(qry.fetch()).thenReturn(resultRecordList);
    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenReturn("Query Params");
    Response response = mock(Response.class);
    doNothing().when(response).header(Mockito.<String>any(), Mockito.<String>any());
    doNothing().when(response).type(Mockito.<String>any());

    // Act
    Object actualWriteExtractResult = actorExtractor.writeExtract("foo.txt", qry, request, response);

    // Assert
    verify(resultRecordList).formatCSV();
    verify(qry).fetch();
    verify(request).queryParams(eq("format"));
    verify(response).header(eq("Content-disposition"), eq("attachment; filename=foo.txt.csv"));
    verify(response).type(eq("text/plain"));
    assertEquals("Format CSV", actualWriteExtractResult);
  }

  /**
   * Test {@link DirectQueryBasedDataExtractor#writeExcelHeader(Select, SXSSFSheet)}.
   * <p>
   * Method under test: {@link DirectQueryBasedDataExtractor#writeExcelHeader(Select, SXSSFSheet)}
   */
  @Test
  @DisplayName("Test writeExcelHeader(Select, SXSSFSheet)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DirectQueryBasedDataExtractor.writeExcelHeader(Select, SXSSFSheet)"})
  void testWriteExcelHeader() throws IOException {
    // Arrange
    Select<Record> qry = mock(Select.class);

    ArrayList<Field<?>> fieldList = new ArrayList<>();
    Stream<Field<?>> streamResult = fieldList.stream();
    Mockito.<Stream<Field<?>>>when(qry.fieldStream()).thenReturn(streamResult);
    XSSFSheet xSheet = mock(XSSFSheet.class);
    when(xSheet.getLastRowNum()).thenReturn(-1);
    when(xSheet.getPhysicalNumberOfRows()).thenReturn(10);

    ArrayList<Row> rowList = new ArrayList<>();
    when(xSheet.iterator()).thenReturn(rowList.iterator());
    DeferredSXSSFSheet sheet = new DeferredSXSSFSheet(new DeferredSXSSFWorkbook(), xSheet);

    // Act
    DirectQueryBasedDataExtractor.writeExcelHeader(qry, sheet);

    // Assert
    verify(xSheet).iterator();
    verify(xSheet).getLastRowNum();
    verify(xSheet).getPhysicalNumberOfRows();
    verify(qry).fieldStream();
    assertEquals(0, sheet.getLastRowNum());
  }

  /**
   * Test {@link DirectQueryBasedDataExtractor#writeExcelHeader(Select, SXSSFSheet)}.
   * <p>
   * Method under test: {@link DirectQueryBasedDataExtractor#writeExcelHeader(Select, SXSSFSheet)}
   */
  @Test
  @DisplayName("Test writeExcelHeader(Select, SXSSFSheet)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DirectQueryBasedDataExtractor.writeExcelHeader(Select, SXSSFSheet)"})
  void testWriteExcelHeader2() throws IOException {
    // Arrange
    Field<Object> field = mock(Field.class);
    when(field.getName()).thenReturn("Name");

    ArrayList<Field<?>> fieldList = new ArrayList<>();
    fieldList.add(field);
    Stream<Field<?>> streamResult = fieldList.stream();
    Select<Record> qry = mock(Select.class);
    Mockito.<Stream<Field<?>>>when(qry.fieldStream()).thenReturn(streamResult);
    XSSFSheet xSheet = mock(XSSFSheet.class);
    when(xSheet.getLastRowNum()).thenReturn(-1);
    when(xSheet.getPhysicalNumberOfRows()).thenReturn(10);

    ArrayList<Row> rowList = new ArrayList<>();
    when(xSheet.iterator()).thenReturn(rowList.iterator());
    DeferredSXSSFSheet sheet = new DeferredSXSSFSheet(new DeferredSXSSFWorkbook(), xSheet);

    // Act
    DirectQueryBasedDataExtractor.writeExcelHeader(qry, sheet);

    // Assert
    verify(xSheet).iterator();
    verify(xSheet).getLastRowNum();
    verify(xSheet).getPhysicalNumberOfRows();
    verify(field).getName();
    verify(qry).fieldStream();
    assertEquals(0, sheet.getLastRowNum());
  }

  /**
   * Test {@link DirectQueryBasedDataExtractor#writeExcelHeader(Select, SXSSFSheet)}.
   * <p>
   * Method under test: {@link DirectQueryBasedDataExtractor#writeExcelHeader(Select, SXSSFSheet)}
   */
  @Test
  @DisplayName("Test writeExcelHeader(Select, SXSSFSheet)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DirectQueryBasedDataExtractor.writeExcelHeader(Select, SXSSFSheet)"})
  void testWriteExcelHeader3() throws IOException {
    // Arrange
    Field<Object> field = mock(Field.class);
    when(field.getName()).thenReturn("Name");
    Field<Object> field2 = mock(Field.class);
    when(field2.getName()).thenReturn("Name");

    ArrayList<Field<?>> fieldList = new ArrayList<>();
    fieldList.add(field2);
    fieldList.add(field);
    Stream<Field<?>> streamResult = fieldList.stream();
    Select<Record> qry = mock(Select.class);
    Mockito.<Stream<Field<?>>>when(qry.fieldStream()).thenReturn(streamResult);
    XSSFSheet xSheet = mock(XSSFSheet.class);
    when(xSheet.getLastRowNum()).thenReturn(-1);
    when(xSheet.getPhysicalNumberOfRows()).thenReturn(10);

    ArrayList<Row> rowList = new ArrayList<>();
    when(xSheet.iterator()).thenReturn(rowList.iterator());
    DeferredSXSSFSheet sheet = new DeferredSXSSFSheet(new DeferredSXSSFWorkbook(), xSheet);

    // Act
    DirectQueryBasedDataExtractor.writeExcelHeader(qry, sheet);

    // Assert
    verify(xSheet).iterator();
    verify(xSheet).getLastRowNum();
    verify(xSheet).getPhysicalNumberOfRows();
    verify(field2).getName();
    verify(field).getName();
    verify(qry).fieldStream();
    assertEquals(0, sheet.getLastRowNum());
  }

  /**
   * Test {@link DirectQueryBasedDataExtractor#writeExcelHeader(Select, SXSSFSheet)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DirectQueryBasedDataExtractor#writeExcelHeader(Select, SXSSFSheet)}
   */
  @Test
  @DisplayName("Test writeExcelHeader(Select, SXSSFSheet); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DirectQueryBasedDataExtractor.writeExcelHeader(Select, SXSSFSheet)"})
  void testWriteExcelHeader_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    Field<Object> field = mock(Field.class);
    when(field.getName()).thenReturn("Name");
    Field<Object> field2 = mock(Field.class);
    when(field2.getName()).thenReturn("Name");
    Field<Object> field3 = mock(Field.class);
    when(field3.getName()).thenThrow(new IllegalArgumentException("foo"));

    ArrayList<Field<?>> fieldList = new ArrayList<>();
    fieldList.add(field3);
    fieldList.add(field2);
    fieldList.add(field);
    Stream<Field<?>> streamResult = fieldList.stream();
    Select<Record> qry = mock(Select.class);
    Mockito.<Stream<Field<?>>>when(qry.fieldStream()).thenReturn(streamResult);
    XSSFSheet xSheet = mock(XSSFSheet.class);
    when(xSheet.getLastRowNum()).thenReturn(-1);
    when(xSheet.getPhysicalNumberOfRows()).thenReturn(10);

    ArrayList<Row> rowList = new ArrayList<>();
    when(xSheet.iterator()).thenReturn(rowList.iterator());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> DirectQueryBasedDataExtractor.writeExcelHeader(qry,
        new DeferredSXSSFSheet(new DeferredSXSSFWorkbook(), xSheet)));
    verify(xSheet).iterator();
    verify(xSheet).getLastRowNum();
    verify(xSheet).getPhysicalNumberOfRows();
    verify(field3).getName();
    verify(qry).fieldStream();
  }
}
