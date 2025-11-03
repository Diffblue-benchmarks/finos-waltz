package org.finos.waltz.web.endpoints.extracts.reportgrid;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.report_grid.ReportGrid;
import org.finos.waltz.model.report_grid.ReportGridDefinition;
import org.finos.waltz.model.report_grid.ReportGridDerivedColumnDefinition;
import org.finos.waltz.model.report_grid.ReportGridFixedColumnDefinition;
import org.finos.waltz.model.report_grid.ReportSubject;
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
class DynamicCommaSeperatedValueFormatterDiffblueTest {
  @InjectMocks
  private DynamicCommaSeperatedValueFormatter dynamicCommaSeperatedValueFormatter;

  @Mock
  private FormatterUtils formatterUtils;

  /**
   * Test {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid, List, List)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then return {@code foo,Generating CSV report {}} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid, List, List)}
   */
  @Test
  @DisplayName("Test format(String, ReportGrid, List, List); given ArrayList() add 'foo'; then return 'foo,Generating CSV report {}' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] DynamicCommaSeperatedValueFormatter.format(String, ReportGrid, List, List)"})
  void testFormat_givenArrayListAddFoo_thenReturnFooGeneratingCsvReportBytesIsUtf8() throws IOException {
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

  /**
   * Test {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid, List, List)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return {@code 1,foo,foo,PRODUCTION} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid, List, List)}
   */
  @Test
  @DisplayName("Test format(String, ReportGrid, List, List); given ArrayList() add 'null'; then return '1,foo,foo,PRODUCTION' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] DynamicCommaSeperatedValueFormatter.format(String, ReportGrid, List, List)"})
  void testFormat_givenArrayListAddNull_thenReturn1FooFooProductionBytesIsUtf8() throws IOException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(null);
    when(formatterUtils.mkHeaderStrings(Mockito.<List<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>>>any(),
        Mockito.<List<ReportGridDerivedColumnDefinition>>any())).thenReturn(stringList);
    ReportGridDefinition reportGridDefinition = mock(ReportGridDefinition.class);
    when(reportGridDefinition.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    ReportGrid reportGrid = mock(ReportGrid.class);
    when(reportGrid.definition()).thenReturn(reportGridDefinition);
    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> columnDefinitions = new ArrayList<>();
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.externalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult2);
    when(entityReference.id()).thenReturn(1L);
    ReportSubject reportSubject = mock(ReportSubject.class);
    when(reportSubject.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(reportSubject.entityReference()).thenReturn(entityReference);
    Tuple2<ReportSubject, ArrayList<Object>> tuple2 = new Tuple2<>(reportSubject, new ArrayList<>());

    ArrayList<Tuple2<ReportSubject, ArrayList<Object>>> reportRows = new ArrayList<>();
    reportRows.add(tuple2);

    // Act
    byte[] actualFormatResult = dynamicCommaSeperatedValueFormatter.format("42", reportGrid, columnDefinitions,
        reportRows);

    // Assert
    verify(entityReference).externalId();
    verify(entityReference).id();
    verify(entityReference).name();
    verify(reportGrid).definition();
    verify(reportGridDefinition).derivedColumnDefinitions();
    verify(reportSubject, atLeast(1)).entityReference();
    verify(reportSubject).lifecyclePhase();
    verify(formatterUtils).mkHeaderStrings(isA(List.class), isA(List.class));
    assertArrayEquals("\n1,foo,foo,PRODUCTION\n".getBytes("UTF-8"), actualFormatResult);
  }

  /**
   * Test {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid, List, List)}.
   * <ul>
   *   <li>Then return {@code Generating CSV report {} 1,foo,foo,PRODUCTION} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid, List, List)}
   */
  @Test
  @DisplayName("Test format(String, ReportGrid, List, List); then return 'Generating CSV report {} 1,foo,foo,PRODUCTION' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] DynamicCommaSeperatedValueFormatter.format(String, ReportGrid, List, List)"})
  void testFormat_thenReturnGeneratingCsvReport1FooFooProductionBytesIsUtf8() throws IOException {
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
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.externalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult2);
    when(entityReference.id()).thenReturn(1L);
    ReportSubject reportSubject = mock(ReportSubject.class);
    when(reportSubject.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(reportSubject.entityReference()).thenReturn(entityReference);
    Tuple2<ReportSubject, ArrayList<Object>> tuple2 = new Tuple2<>(reportSubject, new ArrayList<>());

    ArrayList<Tuple2<ReportSubject, ArrayList<Object>>> reportRows = new ArrayList<>();
    reportRows.add(tuple2);

    // Act
    byte[] actualFormatResult = dynamicCommaSeperatedValueFormatter.format("42", reportGrid, columnDefinitions,
        reportRows);

    // Assert
    verify(entityReference).externalId();
    verify(entityReference).id();
    verify(entityReference).name();
    verify(reportGrid).definition();
    verify(reportGridDefinition).derivedColumnDefinitions();
    verify(reportSubject, atLeast(1)).entityReference();
    verify(reportSubject).lifecyclePhase();
    verify(formatterUtils).mkHeaderStrings(isA(List.class), isA(List.class));
    assertArrayEquals("Generating CSV report {}\n1,foo,foo,PRODUCTION\n".getBytes("UTF-8"), actualFormatResult);
  }

  /**
   * Test {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid, List, List)}.
   * <ul>
   *   <li>Then return {@code Generating CSV report {}} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid, List, List)}
   */
  @Test
  @DisplayName("Test format(String, ReportGrid, List, List); then return 'Generating CSV report {}' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] DynamicCommaSeperatedValueFormatter.format(String, ReportGrid, List, List)"})
  void testFormat_thenReturnGeneratingCsvReportBytesIsUtf8() throws IOException {
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
}
