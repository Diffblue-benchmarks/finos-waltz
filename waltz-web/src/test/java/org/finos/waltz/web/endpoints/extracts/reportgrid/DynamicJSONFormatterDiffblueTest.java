package org.finos.waltz.web.endpoints.extracts.reportgrid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.report_grid.ReportGrid;
import org.finos.waltz.model.report_grid.ReportGridDefinition;
import org.finos.waltz.model.report_grid.ReportGridDerivedColumnDefinition;
import org.finos.waltz.model.report_grid.ReportGridFixedColumnDefinition;
import org.finos.waltz.web.endpoints.extracts.ColumnCommentary;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DynamicJSONFormatterDiffblueTest {
  @InjectMocks
  private DynamicJSONFormatter dynamicJSONFormatter;

  @Mock
  private FormatterUtils formatterUtils;

  /**
   * Test {@link DynamicJSONFormatter#format(String, ReportGrid, List, List)}.
   * <ul>
   *   <li>Then return array length is two hundred eighty-three.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicJSONFormatter#format(String, ReportGrid, List, List)}
   */
  @Test
  @DisplayName("Test format(String, ReportGrid, List, List); then return array length is two hundred eighty-three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] DynamicJSONFormatter.format(String, ReportGrid, List, List)"})
  void testFormat_thenReturnArrayLengthIsTwoHundredEightyThree() throws IOException {
    // Arrange
    when(formatterUtils.mkColumnHeaders(Mockito.<List<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>>>any(),
        Mockito.<List<ReportGridDerivedColumnDefinition>>any())).thenReturn(new ArrayList<>());
    ReportGridDefinition reportGridDefinition = mock(ReportGridDefinition.class);
    when(reportGridDefinition.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(reportGridDefinition.name()).thenReturn("Name");
    Optional<String> ofResult = Optional.of("foo");
    when(reportGridDefinition.externalId()).thenReturn(ofResult);
    ReportGrid reportGrid = mock(ReportGrid.class);
    when(reportGrid.definition()).thenReturn(reportGridDefinition);
    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> columnDefinitions = new ArrayList<>();

    // Act
    byte[] actualFormatResult = dynamicJSONFormatter.format("42", reportGrid, columnDefinitions, new ArrayList<>());

    // Assert
    verify(reportGridDefinition).externalId();
    verify(reportGridDefinition).name();
    verify(reportGrid, atLeast(1)).definition();
    verify(reportGridDefinition).derivedColumnDefinitions();
    verify(formatterUtils).mkColumnHeaders(isA(List.class), isA(List.class));
    assertEquals(283, actualFormatResult.length);
    assertEquals(' ', actualFormatResult[261]);
    assertEquals(' ', actualFormatResult[262]);
    assertEquals(' ', actualFormatResult[263]);
    assertEquals(' ', actualFormatResult[264]);
    assertEquals(' ', actualFormatResult[273]);
    assertEquals(' ', actualFormatResult[275]);
    assertEquals(' ', actualFormatResult[278]);
    assertEquals(',', actualFormatResult[259]);
    assertEquals(':', actualFormatResult[272]);
    assertEquals('[', actualFormatResult[274]);
    assertEquals('"', actualFormatResult[265]);
    assertEquals('"', actualFormatResult[270]);
    assertEquals('\n', actualFormatResult[260]);
    assertEquals('\n', actualFormatResult[277]);
    assertEquals('\n', actualFormatResult[281]);
    assertEquals(']', actualFormatResult[276]);
    assertEquals('l', actualFormatResult[258]);
    assertEquals('o', actualFormatResult[267]);
    assertEquals('r', actualFormatResult[266]);
    assertEquals('s', actualFormatResult[269]);
    assertEquals('w', actualFormatResult[268]);
    assertEquals('}', actualFormatResult[280]);
    assertEquals('}', actualFormatResult[282]);
  }

  /**
   * Test {@link DynamicJSONFormatter#format(String, ReportGrid, List, List)}.
   * <ul>
   *   <li>Then return array length is two hundred ninety-one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicJSONFormatter#format(String, ReportGrid, List, List)}
   */
  @Test
  @DisplayName("Test format(String, ReportGrid, List, List); then return array length is two hundred ninety-one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] DynamicJSONFormatter.format(String, ReportGrid, List, List)"})
  void testFormat_thenReturnArrayLengthIsTwoHundredNinetyOne() throws IOException {
    // Arrange
    when(formatterUtils.mkColumnHeaders(Mockito.<List<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>>>any(),
        Mockito.<List<ReportGridDerivedColumnDefinition>>any())).thenReturn(new ArrayList<>());
    ReportGridDefinition reportGridDefinition = mock(ReportGridDefinition.class);
    when(reportGridDefinition.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(reportGridDefinition.name()).thenReturn("Name");
    Optional<String> emptyResult = Optional.empty();
    when(reportGridDefinition.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(reportGridDefinition.id()).thenReturn(ofResult);
    ReportGrid reportGrid = mock(ReportGrid.class);
    when(reportGrid.definition()).thenReturn(reportGridDefinition);
    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> columnDefinitions = new ArrayList<>();

    // Act
    byte[] actualFormatResult = dynamicJSONFormatter.format("42", reportGrid, columnDefinitions, new ArrayList<>());

    // Assert
    verify(reportGridDefinition).externalId();
    verify(reportGridDefinition).id();
    verify(reportGridDefinition).name();
    verify(reportGrid, atLeast(1)).definition();
    verify(reportGridDefinition).derivedColumnDefinitions();
    verify(formatterUtils).mkColumnHeaders(isA(List.class), isA(List.class));
    assertEquals(291, actualFormatResult.length);
    assertEquals(' ', actualFormatResult[269]);
    assertEquals(' ', actualFormatResult[270]);
    assertEquals(' ', actualFormatResult[272]);
    assertEquals(' ', actualFormatResult[281]);
    assertEquals(' ', actualFormatResult[283]);
    assertEquals(' ', actualFormatResult[286]);
    assertEquals(' ', actualFormatResult[287]);
    assertEquals(',', actualFormatResult[267]);
    assertEquals(':', actualFormatResult[280]);
    assertEquals('[', actualFormatResult[282]);
    assertEquals('"', actualFormatResult[273]);
    assertEquals('"', actualFormatResult[278]);
    assertEquals('\n', actualFormatResult[268]);
    assertEquals('\n', actualFormatResult[285]);
    assertEquals('\n', actualFormatResult[289]);
    assertEquals(']', actualFormatResult[284]);
    assertEquals('l', actualFormatResult[266]);
    assertEquals('o', actualFormatResult[275]);
    assertEquals('r', actualFormatResult[274]);
    assertEquals('s', actualFormatResult[277]);
    assertEquals('w', actualFormatResult[276]);
    assertEquals('}', actualFormatResult[288]);
    assertEquals('}', actualFormatResult[290]);
  }
}
