package org.finos.waltz.web.endpoints.extracts.reportgrid;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.report_grid.ReportGrid;
import org.finos.waltz.model.report_grid.ReportGridDefinition;
import org.finos.waltz.model.report_grid.ReportGridDerivedColumnDefinition;
import org.finos.waltz.model.report_grid.ReportGridFixedColumnDefinition;
import org.finos.waltz.web.endpoints.extracts.ColumnCommentary;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DynamicCommaSeperatedValueFormatterDiffblueTest {
  @InjectMocks
  private DynamicCommaSeperatedValueFormatter dynamicCommaSeperatedValueFormatter;

  @Mock
  private FormatterUtils formatterUtils;

  /**
   * Method under test:
   * {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid, List, List)}
   */
  @Test
  void testFormat() throws IOException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("Generating CSV report {}");
    when(formatterUtils.mkHeaderStrings(Mockito.<List<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>>>any(),
        Mockito.<List<ReportGridDerivedColumnDefinition>>any())).thenReturn(stringList);
    ReportGridDefinition reportGridDefinition = mock(ReportGridDefinition.class);
    when(reportGridDefinition.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    ReportGrid reportGrid = mock(ReportGrid.class);
    when(reportGrid.definition()).thenReturn(reportGridDefinition);
    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> columnDefinitions = new ArrayList<>();

    // Act
    byte[] actualFormatResult = dynamicCommaSeperatedValueFormatter.format("42", reportGrid, columnDefinitions,
        new ArrayList<>());

    // Assert
    verify(reportGrid).definition();
    verify(reportGridDefinition).derivedColumnDefinitions();
    verify(formatterUtils).mkHeaderStrings(isA(List.class), isA(List.class));
    assertArrayEquals("Generating CSV report {}\n".getBytes("UTF-8"), actualFormatResult);
  }

  /**
   * Method under test:
   * {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid, List, List)}
   */
  @Test
  void testFormat2() throws IOException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    stringList.add("Generating CSV report {}");
    when(formatterUtils.mkHeaderStrings(Mockito.<List<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>>>any(),
        Mockito.<List<ReportGridDerivedColumnDefinition>>any())).thenReturn(stringList);
    ReportGridDefinition reportGridDefinition = mock(ReportGridDefinition.class);
    when(reportGridDefinition.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    ReportGrid reportGrid = mock(ReportGrid.class);
    when(reportGrid.definition()).thenReturn(reportGridDefinition);
    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> columnDefinitions = new ArrayList<>();

    // Act
    byte[] actualFormatResult = dynamicCommaSeperatedValueFormatter.format("42", reportGrid, columnDefinitions,
        new ArrayList<>());

    // Assert
    verify(reportGrid).definition();
    verify(reportGridDefinition).derivedColumnDefinitions();
    verify(formatterUtils).mkHeaderStrings(isA(List.class), isA(List.class));
    assertArrayEquals("foo,Generating CSV report {}\n".getBytes("UTF-8"), actualFormatResult);
  }
}
