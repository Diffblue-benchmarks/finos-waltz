package org.finos.waltz.web.endpoints.extracts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.jooq.DSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import spark.Request;

@ExtendWith(MockitoExtension.class)
class DataExtractorDiffblueTest {
  @InjectMocks
  private ActorExtractor actorExtractor;

  @Mock
  private DSLContext dSLContext;

  /**
   * Test {@link DataExtractor#parseExtractFormat(Request)}.
   * <ul>
   *   <li>Given {@code Query Params}.</li>
   *   <li>Then return {@code CSV}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataExtractor#parseExtractFormat(Request)}
   */
  @Test
  @DisplayName("Test parseExtractFormat(Request); given 'Query Params'; then return 'CSV'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExtractFormat DataExtractor.parseExtractFormat(Request)"})
  void testParseExtractFormat_givenQueryParams_thenReturnCsv() {
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
   * Test {@link DataExtractor#parseExtractFormat(Request)}.
   * <ul>
   *   <li>Given {@code XLSX}.</li>
   *   <li>When {@link Request} {@link Request#queryParams(String)} return {@code XLSX}.</li>
   *   <li>Then return {@code XLSX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataExtractor#parseExtractFormat(Request)}
   */
  @Test
  @DisplayName("Test parseExtractFormat(Request); given 'XLSX'; when Request queryParams(String) return 'XLSX'; then return 'XLSX'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExtractFormat DataExtractor.parseExtractFormat(Request)"})
  void testParseExtractFormat_givenXlsx_whenRequestQueryParamsReturnXlsx_thenReturnXlsx() {
    // Arrange
    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenReturn("XLSX");

    // Act
    ExtractFormat actualParseExtractFormatResult = actorExtractor.parseExtractFormat(request);

    // Assert
    verify(request).queryParams(eq("format"));
    assertEquals(ExtractFormat.XLSX, actualParseExtractFormatResult);
  }
}
