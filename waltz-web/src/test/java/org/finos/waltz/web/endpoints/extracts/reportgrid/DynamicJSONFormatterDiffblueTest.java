package org.finos.waltz.web.endpoints.extracts.reportgrid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.entity_field_reference.ImmutableEntityFieldReference;
import org.finos.waltz.model.report_grid.AdditionalColumnOptions;
import org.finos.waltz.model.report_grid.ImmutableReportGrid;
import org.finos.waltz.model.report_grid.ImmutableReportGrid.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridDefinition;
import org.finos.waltz.model.report_grid.ImmutableReportGridFixedColumnDefinition;
import org.finos.waltz.model.report_grid.ImmutableReportGridInstance;
import org.finos.waltz.model.report_grid.ImmutableReportSubject;
import org.finos.waltz.model.report_grid.ReportGrid;
import org.finos.waltz.model.report_grid.ReportGridDerivedColumnDefinition;
import org.finos.waltz.model.report_grid.ReportGridFixedColumnDefinition;
import org.finos.waltz.model.report_grid.ReportGridKind;
import org.finos.waltz.model.report_grid.ReportGridMemberRole;
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
class DynamicJSONFormatterDiffblueTest {
  @InjectMocks private DynamicJSONFormatter dynamicJSONFormatter;

  @Mock private FormatterUtils formatterUtils;

  /**
   * Test {@link DynamicJSONFormatter#format(String, ReportGrid, List, List)}.
   *
   * <p>Method under test: {@link DynamicJSONFormatter#format(String, ReportGrid, List, List)}
   */
  @Test
  @DisplayName("Test format(String, ReportGrid, List, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DynamicJSONFormatter.format(String, ReportGrid, List, List)"})
  void testFormat() throws IOException {
    // Arrange
    DynamicJSONFormatter dynamicJSONFormatter = new DynamicJSONFormatter(new FormatterUtils());

    Builder builderResult = ImmutableReportGrid.builder();
    ImmutableReportGrid reportGrid =
        builderResult
            .definition(
                ImmutableReportGridDefinition.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(ReportGridKind.PUBLIC)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .instance(ImmutableReportGridInstance.builder().build())
            .userRole(ReportGridMemberRole.VIEWER)
            .build();

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> columnDefinitions =
        new ArrayList<>();

    ImmutableReportGridFixedColumnDefinition.Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();
    columnDefinitions.add(
        new Tuple2<>(immutableReportGridFixedColumnDefinition, ColumnCommentary.HAS_COMMENTARY));

    // Act
    byte[] actualFormatResult =
        dynamicJSONFormatter.format("42", reportGrid, columnDefinitions, new ArrayList<>());

    // Assert
    assertEquals(282, actualFormatResult.length);
    assertEquals(' ', actualFormatResult[260]);
    assertEquals(' ', actualFormatResult[261]);
    assertEquals(' ', actualFormatResult[262]);
    assertEquals(' ', actualFormatResult[263]);
    assertEquals(' ', actualFormatResult[270]);
    assertEquals(' ', actualFormatResult[272]);
    assertEquals(' ', actualFormatResult[274]);
    assertEquals(' ', actualFormatResult[277]);
    assertEquals(' ', actualFormatResult[278]);
    assertEquals(',', actualFormatResult[258]);
    assertEquals(':', actualFormatResult[271]);
    assertEquals('[', actualFormatResult[273]);
    assertEquals('"', actualFormatResult[264]);
    assertEquals('"', actualFormatResult[269]);
    assertEquals('\n', actualFormatResult[259]);
    assertEquals('\n', actualFormatResult[276]);
    assertEquals('\n', actualFormatResult[280]);
    assertEquals(']', actualFormatResult[275]);
    assertEquals('l', actualFormatResult[257]);
    assertEquals('o', actualFormatResult[266]);
    assertEquals('r', actualFormatResult[265]);
    assertEquals('s', actualFormatResult[268]);
    assertEquals('w', actualFormatResult[267]);
    assertEquals('}', actualFormatResult[279]);
    assertEquals('}', actualFormatResult[281]);
  }

  /**
   * Test {@link DynamicJSONFormatter#format(String, ReportGrid, List, List)}.
   *
   * <p>Method under test: {@link DynamicJSONFormatter#format(String, ReportGrid, List, List)}
   */
  @Test
  @DisplayName("Test format(String, ReportGrid, List, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DynamicJSONFormatter.format(String, ReportGrid, List, List)"})
  void testFormat2() throws IOException {
    // Arrange
    DynamicJSONFormatter dynamicJSONFormatter = new DynamicJSONFormatter(new FormatterUtils());

    Builder builderResult = ImmutableReportGrid.builder();
    ImmutableReportGrid reportGrid =
        builderResult
            .definition(
                ImmutableReportGridDefinition.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(ReportGridKind.PUBLIC)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .instance(ImmutableReportGridInstance.builder().build())
            .userRole(ReportGridMemberRole.VIEWER)
            .build();

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> columnDefinitions =
        new ArrayList<>();

    ImmutableReportGridFixedColumnDefinition.Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();
    columnDefinitions.add(
        new Tuple2<>(immutableReportGridFixedColumnDefinition, ColumnCommentary.HAS_COMMENTARY));

    ImmutableReportGridFixedColumnDefinition.Builder displayNameResult2 =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition2 =
        displayNameResult2
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();
    columnDefinitions.add(
        new Tuple2<>(immutableReportGridFixedColumnDefinition2, ColumnCommentary.HAS_COMMENTARY));

    // Act
    byte[] actualFormatResult =
        dynamicJSONFormatter.format("42", reportGrid, columnDefinitions, new ArrayList<>());

    // Assert
    assertEquals(282, actualFormatResult.length);
    assertEquals(' ', actualFormatResult[260]);
    assertEquals(' ', actualFormatResult[261]);
    assertEquals(' ', actualFormatResult[262]);
    assertEquals(' ', actualFormatResult[263]);
    assertEquals(' ', actualFormatResult[270]);
    assertEquals(' ', actualFormatResult[272]);
    assertEquals(' ', actualFormatResult[274]);
    assertEquals(' ', actualFormatResult[277]);
    assertEquals(' ', actualFormatResult[278]);
    assertEquals(',', actualFormatResult[258]);
    assertEquals(':', actualFormatResult[271]);
    assertEquals('[', actualFormatResult[273]);
    assertEquals('"', actualFormatResult[264]);
    assertEquals('"', actualFormatResult[269]);
    assertEquals('\n', actualFormatResult[259]);
    assertEquals('\n', actualFormatResult[276]);
    assertEquals('\n', actualFormatResult[280]);
    assertEquals(']', actualFormatResult[275]);
    assertEquals('l', actualFormatResult[257]);
    assertEquals('o', actualFormatResult[266]);
    assertEquals('r', actualFormatResult[265]);
    assertEquals('s', actualFormatResult[268]);
    assertEquals('w', actualFormatResult[267]);
    assertEquals('}', actualFormatResult[279]);
    assertEquals('}', actualFormatResult[281]);
  }

  /**
   * Test {@link DynamicJSONFormatter#format(String, ReportGrid, List, List)}.
   *
   * <p>Method under test: {@link DynamicJSONFormatter#format(String, ReportGrid, List, List)}
   */
  @Test
  @DisplayName("Test format(String, ReportGrid, List, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DynamicJSONFormatter.format(String, ReportGrid, List, List)"})
  void testFormat3() throws IOException {
    // Arrange
    DynamicJSONFormatter dynamicJSONFormatter = new DynamicJSONFormatter(new FormatterUtils());

    Builder builderResult = ImmutableReportGrid.builder();
    ImmutableReportGrid reportGrid =
        builderResult
            .definition(
                ImmutableReportGridDefinition.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(ReportGridKind.PUBLIC)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .instance(ImmutableReportGridInstance.builder().build())
            .userRole(ReportGridMemberRole.VIEWER)
            .build();

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> columnDefinitions =
        new ArrayList<>();

    ImmutableReportGridFixedColumnDefinition.Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();
    columnDefinitions.add(
        new Tuple2<>(immutableReportGridFixedColumnDefinition, ColumnCommentary.NO_COMMENTARY));

    // Act
    byte[] actualFormatResult =
        dynamicJSONFormatter.format("42", reportGrid, columnDefinitions, new ArrayList<>());

    // Assert
    assertEquals(282, actualFormatResult.length);
    assertEquals(' ', actualFormatResult[260]);
    assertEquals(' ', actualFormatResult[261]);
    assertEquals(' ', actualFormatResult[262]);
    assertEquals(' ', actualFormatResult[263]);
    assertEquals(' ', actualFormatResult[270]);
    assertEquals(' ', actualFormatResult[272]);
    assertEquals(' ', actualFormatResult[274]);
    assertEquals(' ', actualFormatResult[277]);
    assertEquals(' ', actualFormatResult[278]);
    assertEquals(',', actualFormatResult[258]);
    assertEquals(':', actualFormatResult[271]);
    assertEquals('[', actualFormatResult[273]);
    assertEquals('"', actualFormatResult[264]);
    assertEquals('"', actualFormatResult[269]);
    assertEquals('\n', actualFormatResult[259]);
    assertEquals('\n', actualFormatResult[276]);
    assertEquals('\n', actualFormatResult[280]);
    assertEquals(']', actualFormatResult[275]);
    assertEquals('l', actualFormatResult[257]);
    assertEquals('o', actualFormatResult[266]);
    assertEquals('r', actualFormatResult[265]);
    assertEquals('s', actualFormatResult[268]);
    assertEquals('w', actualFormatResult[267]);
    assertEquals('}', actualFormatResult[279]);
    assertEquals('}', actualFormatResult[281]);
  }

  /**
   * Test {@link DynamicJSONFormatter#format(String, ReportGrid, List, List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return array length is five hundred seventy-six.
   * </ul>
   *
   * <p>Method under test: {@link DynamicJSONFormatter#format(String, ReportGrid, List, List)}
   */
  @Test
  @DisplayName(
      "Test format(String, ReportGrid, List, List); given ArrayList() add '42'; then return array length is five hundred seventy-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DynamicJSONFormatter.format(String, ReportGrid, List, List)"})
  void testFormat_givenArrayListAdd42_thenReturnArrayLengthIsFiveHundredSeventySix()
      throws IOException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("id");
    when(formatterUtils.mkColumnHeaders(
            Mockito.<List<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>>>any(),
            Mockito.<List<ReportGridDerivedColumnDefinition>>any()))
        .thenReturn(stringList);

    Builder builderResult = ImmutableReportGrid.builder();
    ImmutableReportGrid reportGrid =
        builderResult
            .definition(
                ImmutableReportGridDefinition.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(ReportGridKind.PUBLIC)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .instance(ImmutableReportGridInstance.builder().build())
            .userRole(ReportGridMemberRole.VIEWER)
            .build();
    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> columnDefinitions =
        new ArrayList<>();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");

    ImmutableReportSubject.Builder builderResult2 = ImmutableReportSubject.builder();
    ImmutableReportSubject immutableReportSubject =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .build();

    Tuple2<ReportSubject, ArrayList<Object>> tuple2 =
        new Tuple2<>(immutableReportSubject, objectList);

    ArrayList<Tuple2<ReportSubject, ArrayList<Object>>> reportRows = new ArrayList<>();
    reportRows.add(tuple2);

    // Act
    byte[] actualFormatResult =
        dynamicJSONFormatter.format("42", reportGrid, columnDefinitions, reportRows);

    // Assert
    verify(formatterUtils).mkColumnHeaders(isA(List.class), isA(List.class));
    assertEquals(576, actualFormatResult.length);
    assertEquals(' ', actualFormatResult[553]);
    assertEquals(' ', actualFormatResult[554]);
    assertEquals(' ', actualFormatResult[555]);
    assertEquals(' ', actualFormatResult[556]);
    assertEquals(' ', actualFormatResult[557]);
    assertEquals(' ', actualFormatResult[558]);
    assertEquals(' ', actualFormatResult[560]);
    assertEquals(' ', actualFormatResult[563]);
    assertEquals(' ', actualFormatResult[564]);
    assertEquals(' ', actualFormatResult[565]);
    assertEquals(' ', actualFormatResult[566]);
    assertEquals(' ', actualFormatResult[568]);
    assertEquals(' ', actualFormatResult[571]);
    assertEquals(' ', actualFormatResult[572]);
    assertEquals('"', actualFormatResult[551]);
    assertEquals('\n', actualFormatResult[552]);
    assertEquals('\n', actualFormatResult[562]);
    assertEquals('\n', actualFormatResult[570]);
    assertEquals('\n', actualFormatResult[574]);
    assertEquals(']', actualFormatResult[561]);
    assertEquals(']', actualFormatResult[569]);
    assertEquals('}', actualFormatResult[559]);
    assertEquals('}', actualFormatResult[567]);
    assertEquals('}', actualFormatResult[573]);
    assertEquals('}', actualFormatResult[575]);
  }

  /**
   * Test {@link DynamicJSONFormatter#format(String, ReportGrid, List, List)}.
   *
   * <ul>
   *   <li>Given {@link DynamicJSONFormatter#DynamicJSONFormatter(FormatterUtils)} with {@link
   *       FormatterUtils}.
   *   <li>Then calls {@link FormatterUtils#mkColumnHeaders(List, List)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicJSONFormatter#format(String, ReportGrid, List, List)}
   */
  @Test
  @DisplayName(
      "Test format(String, ReportGrid, List, List); given DynamicJSONFormatter(FormatterUtils) with FormatterUtils; then calls mkColumnHeaders(List, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DynamicJSONFormatter.format(String, ReportGrid, List, List)"})
  void testFormat_givenDynamicJSONFormatterWithFormatterUtils_thenCallsMkColumnHeaders()
      throws IOException {
    // Arrange
    FormatterUtils formatterUtils = mock(FormatterUtils.class);
    when(formatterUtils.mkColumnHeaders(
            Mockito.<List<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>>>any(),
            Mockito.<List<ReportGridDerivedColumnDefinition>>any()))
        .thenReturn(new ArrayList<>());
    DynamicJSONFormatter dynamicJSONFormatter = new DynamicJSONFormatter(formatterUtils);

    Builder builderResult = ImmutableReportGrid.builder();
    ImmutableReportGrid reportGrid =
        builderResult
            .definition(
                ImmutableReportGridDefinition.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(ReportGridKind.PUBLIC)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .instance(ImmutableReportGridInstance.builder().build())
            .userRole(ReportGridMemberRole.VIEWER)
            .build();
    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> columnDefinitions =
        new ArrayList<>();

    // Act
    byte[] actualFormatResult =
        dynamicJSONFormatter.format("42", reportGrid, columnDefinitions, new ArrayList<>());

    // Assert
    verify(formatterUtils).mkColumnHeaders(isA(List.class), isA(List.class));
    assertEquals(282, actualFormatResult.length);
    assertEquals(' ', actualFormatResult[260]);
    assertEquals(' ', actualFormatResult[261]);
    assertEquals(' ', actualFormatResult[262]);
    assertEquals(' ', actualFormatResult[263]);
    assertEquals(' ', actualFormatResult[270]);
    assertEquals(' ', actualFormatResult[272]);
    assertEquals(' ', actualFormatResult[274]);
    assertEquals(' ', actualFormatResult[277]);
    assertEquals(' ', actualFormatResult[278]);
    assertEquals(',', actualFormatResult[258]);
    assertEquals(':', actualFormatResult[271]);
    assertEquals('[', actualFormatResult[273]);
    assertEquals('"', actualFormatResult[264]);
    assertEquals('"', actualFormatResult[269]);
    assertEquals('\n', actualFormatResult[259]);
    assertEquals('\n', actualFormatResult[276]);
    assertEquals('\n', actualFormatResult[280]);
    assertEquals(']', actualFormatResult[275]);
    assertEquals('l', actualFormatResult[257]);
    assertEquals('o', actualFormatResult[266]);
    assertEquals('r', actualFormatResult[265]);
    assertEquals('s', actualFormatResult[268]);
    assertEquals('w', actualFormatResult[267]);
    assertEquals('}', actualFormatResult[279]);
    assertEquals('}', actualFormatResult[281]);
  }

  /**
   * Test {@link DynamicJSONFormatter#format(String, ReportGrid, List, List)}.
   *
   * <ul>
   *   <li>Then return array length is four hundred ninety-seven.
   * </ul>
   *
   * <p>Method under test: {@link DynamicJSONFormatter#format(String, ReportGrid, List, List)}
   */
  @Test
  @DisplayName(
      "Test format(String, ReportGrid, List, List); then return array length is four hundred ninety-seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DynamicJSONFormatter.format(String, ReportGrid, List, List)"})
  void testFormat_thenReturnArrayLengthIsFourHundredNinetySeven() throws IOException {
    // Arrange
    DynamicJSONFormatter dynamicJSONFormatter = new DynamicJSONFormatter(new FormatterUtils());

    Builder builderResult = ImmutableReportGrid.builder();
    ImmutableReportGrid reportGrid =
        builderResult
            .definition(
                ImmutableReportGridDefinition.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(ReportGridKind.PUBLIC)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .instance(ImmutableReportGridInstance.builder().build())
            .userRole(ReportGridMemberRole.VIEWER)
            .build();
    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> columnDefinitions =
        new ArrayList<>();

    ArrayList<Tuple2<ReportSubject, ArrayList<Object>>> reportRows = new ArrayList<>();

    ImmutableReportSubject.Builder builderResult2 = ImmutableReportSubject.builder();
    ImmutableReportSubject immutableReportSubject =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .build();
    Tuple2<ReportSubject, ArrayList<Object>> tuple2 =
        new Tuple2<>(immutableReportSubject, new ArrayList<>());
    reportRows.add(tuple2);

    // Act
    byte[] actualFormatResult =
        dynamicJSONFormatter.format("42", reportGrid, columnDefinitions, reportRows);

    // Assert
    assertEquals(497, actualFormatResult.length);
    assertEquals(' ', actualFormatResult[477]);
    assertEquals(' ', actualFormatResult[479]);
    assertEquals(' ', actualFormatResult[481]);
    assertEquals(' ', actualFormatResult[484]);
    assertEquals(' ', actualFormatResult[485]);
    assertEquals(' ', actualFormatResult[486]);
    assertEquals(' ', actualFormatResult[487]);
    assertEquals(' ', actualFormatResult[489]);
    assertEquals(' ', actualFormatResult[492]);
    assertEquals(' ', actualFormatResult[493]);
    assertEquals(':', actualFormatResult[478]);
    assertEquals('[', actualFormatResult[480]);
    assertEquals('"', actualFormatResult[476]);
    assertEquals('\n', actualFormatResult[483]);
    assertEquals('\n', actualFormatResult[491]);
    assertEquals('\n', actualFormatResult[495]);
    assertEquals(']', actualFormatResult[482]);
    assertEquals(']', actualFormatResult[490]);
    assertEquals('e', actualFormatResult[472]);
    assertEquals('l', actualFormatResult[473]);
    assertEquals('l', actualFormatResult[474]);
    assertEquals('s', actualFormatResult[475]);
    assertEquals('}', actualFormatResult[488]);
    assertEquals('}', actualFormatResult[494]);
    assertEquals('}', actualFormatResult[496]);
  }

  /**
   * Test {@link DynamicJSONFormatter#format(String, ReportGrid, List, List)}.
   *
   * <ul>
   *   <li>Then return array length is seven hundred thirteen.
   * </ul>
   *
   * <p>Method under test: {@link DynamicJSONFormatter#format(String, ReportGrid, List, List)}
   */
  @Test
  @DisplayName(
      "Test format(String, ReportGrid, List, List); then return array length is seven hundred thirteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DynamicJSONFormatter.format(String, ReportGrid, List, List)"})
  void testFormat_thenReturnArrayLengthIsSevenHundredThirteen() throws IOException {
    // Arrange
    DynamicJSONFormatter dynamicJSONFormatter = new DynamicJSONFormatter(new FormatterUtils());

    Builder builderResult = ImmutableReportGrid.builder();
    ImmutableReportGrid reportGrid =
        builderResult
            .definition(
                ImmutableReportGridDefinition.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(ReportGridKind.PUBLIC)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .instance(ImmutableReportGridInstance.builder().build())
            .userRole(ReportGridMemberRole.VIEWER)
            .build();
    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> columnDefinitions =
        new ArrayList<>();

    ArrayList<Tuple2<ReportSubject, ArrayList<Object>>> reportRows = new ArrayList<>();

    ImmutableReportSubject.Builder builderResult2 = ImmutableReportSubject.builder();
    ImmutableReportSubject immutableReportSubject =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .build();
    Tuple2<ReportSubject, ArrayList<Object>> tuple2 =
        new Tuple2<>(immutableReportSubject, new ArrayList<>());
    reportRows.add(tuple2);

    ImmutableReportSubject.Builder builderResult3 = ImmutableReportSubject.builder();
    ImmutableReportSubject immutableReportSubject2 =
        builderResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .build();
    Tuple2<ReportSubject, ArrayList<Object>> tuple22 =
        new Tuple2<>(immutableReportSubject2, new ArrayList<>());
    reportRows.add(tuple22);

    // Act
    byte[] actualFormatResult =
        dynamicJSONFormatter.format("42", reportGrid, columnDefinitions, reportRows);

    // Assert
    assertEquals(713, actualFormatResult.length);
    assertEquals(' ', actualFormatResult[693]);
    assertEquals(' ', actualFormatResult[695]);
    assertEquals(' ', actualFormatResult[697]);
    assertEquals(' ', actualFormatResult[700]);
    assertEquals(' ', actualFormatResult[701]);
    assertEquals(' ', actualFormatResult[702]);
    assertEquals(' ', actualFormatResult[703]);
    assertEquals(' ', actualFormatResult[705]);
    assertEquals(' ', actualFormatResult[708]);
    assertEquals(' ', actualFormatResult[709]);
    assertEquals(':', actualFormatResult[694]);
    assertEquals('[', actualFormatResult[696]);
    assertEquals('"', actualFormatResult[692]);
    assertEquals('\n', actualFormatResult[699]);
    assertEquals('\n', actualFormatResult[707]);
    assertEquals('\n', actualFormatResult[711]);
    assertEquals(']', actualFormatResult[698]);
    assertEquals(']', actualFormatResult[706]);
    assertEquals('e', actualFormatResult[688]);
    assertEquals('l', actualFormatResult[689]);
    assertEquals('l', actualFormatResult[690]);
    assertEquals('s', actualFormatResult[691]);
    assertEquals('}', actualFormatResult[704]);
    assertEquals('}', actualFormatResult[710]);
    assertEquals('}', actualFormatResult[712]);
  }

  /**
   * Test {@link DynamicJSONFormatter#format(String, ReportGrid, List, List)}.
   *
   * <ul>
   *   <li>Then return array length is two hundred eighty-two.
   * </ul>
   *
   * <p>Method under test: {@link DynamicJSONFormatter#format(String, ReportGrid, List, List)}
   */
  @Test
  @DisplayName(
      "Test format(String, ReportGrid, List, List); then return array length is two hundred eighty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DynamicJSONFormatter.format(String, ReportGrid, List, List)"})
  void testFormat_thenReturnArrayLengthIsTwoHundredEightyTwo() throws IOException {
    // Arrange
    DynamicJSONFormatter dynamicJSONFormatter = new DynamicJSONFormatter(new FormatterUtils());

    Builder builderResult = ImmutableReportGrid.builder();
    ImmutableReportGrid reportGrid =
        builderResult
            .definition(
                ImmutableReportGridDefinition.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(ReportGridKind.PUBLIC)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .instance(ImmutableReportGridInstance.builder().build())
            .userRole(ReportGridMemberRole.VIEWER)
            .build();
    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> columnDefinitions =
        new ArrayList<>();

    // Act
    byte[] actualFormatResult =
        dynamicJSONFormatter.format("42", reportGrid, columnDefinitions, new ArrayList<>());

    // Assert
    assertEquals(282, actualFormatResult.length);
    assertEquals(' ', actualFormatResult[260]);
    assertEquals(' ', actualFormatResult[261]);
    assertEquals(' ', actualFormatResult[262]);
    assertEquals(' ', actualFormatResult[263]);
    assertEquals(' ', actualFormatResult[270]);
    assertEquals(' ', actualFormatResult[272]);
    assertEquals(' ', actualFormatResult[274]);
    assertEquals(' ', actualFormatResult[277]);
    assertEquals(' ', actualFormatResult[278]);
    assertEquals(',', actualFormatResult[258]);
    assertEquals(':', actualFormatResult[271]);
    assertEquals('[', actualFormatResult[273]);
    assertEquals('"', actualFormatResult[264]);
    assertEquals('"', actualFormatResult[269]);
    assertEquals('\n', actualFormatResult[259]);
    assertEquals('\n', actualFormatResult[276]);
    assertEquals('\n', actualFormatResult[280]);
    assertEquals(']', actualFormatResult[275]);
    assertEquals('l', actualFormatResult[257]);
    assertEquals('o', actualFormatResult[266]);
    assertEquals('r', actualFormatResult[265]);
    assertEquals('s', actualFormatResult[268]);
    assertEquals('w', actualFormatResult[267]);
    assertEquals('}', actualFormatResult[279]);
    assertEquals('}', actualFormatResult[281]);
  }
}
