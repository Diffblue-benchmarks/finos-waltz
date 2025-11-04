package org.finos.waltz.web.endpoints.extracts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
   * Method under test:
   * {@link DirectQueryBasedDataExtractor#writeExtract(String, Select, Request, Response)}
   */
  @Test
  void testWriteExtract() throws IOException {
    // Arrange
    Select<Record> qry = mock(Select.class);
    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenReturn("SVG");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> actorExtractor.writeExtract("foo.txt", qry, request, null));
    verify(request).queryParams(eq("format"));
  }

  /**
   * Method under test:
   * {@link DirectQueryBasedDataExtractor#writeExtract(String, Select, Request, Response)}
   */
  @Test
  void testWriteExtract2() throws IOException {
    // Arrange
    Select<Record> qry = mock(Select.class);
    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenReturn("JSON");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> actorExtractor.writeExtract("foo.txt", qry, request, null));
    verify(request).queryParams(eq("format"));
  }

  /**
   * Method under test:
   * {@link DirectQueryBasedDataExtractor#writeExtract(String, Select, Request, Response)}
   */
  @Test
  void testWriteExtract3() throws IOException, DataAccessException {
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
   * Method under test:
   * {@link DirectQueryBasedDataExtractor#writeExcelHeader(Select, SXSSFSheet)}
   */
  @Test
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
   * Method under test:
   * {@link DirectQueryBasedDataExtractor#writeExcelHeader(Select, SXSSFSheet)}
   */
  @Test
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
   * Method under test:
   * {@link DirectQueryBasedDataExtractor#writeExcelHeader(Select, SXSSFSheet)}
   */
  @Test
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
}
