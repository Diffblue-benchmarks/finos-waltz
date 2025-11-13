package org.finos.waltz.web.endpoints.extracts.reportgrid;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
import org.finos.waltz.model.report_grid.ImmutableReportGridDerivedColumnDefinition;
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
import org.mockito.Mockito;

class DynamicCommaSeperatedValueFormatterDiffblueTest {
  /**
   * Test {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid, List, List)}.
   *
   * <p>Method under test: {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid,
   * List, List)}
   */
  @Test
  @DisplayName("Test format(String, ReportGrid, List, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] DynamicCommaSeperatedValueFormatter.format(String, ReportGrid, List, List)"
  })
  void testFormat() throws IOException {
    // Arrange
    DynamicCommaSeperatedValueFormatter dynamicCommaSeperatedValueFormatter =
        new DynamicCommaSeperatedValueFormatter(new FormatterUtils());

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
        dynamicCommaSeperatedValueFormatter.format(
            "42", reportGrid, columnDefinitions, new ArrayList<>());

    // Assert
    assertEquals(81, actualFormatResult.length);
    assertEquals(' ', actualFormatResult[75]);
    assertEquals(',', actualFormatResult[67]);
    assertEquals('D', actualFormatResult[68]);
    assertEquals('N', actualFormatResult[76]);
    assertEquals('\n', actualFormatResult[80]);
    assertEquals('a', actualFormatResult[73]);
    assertEquals('a', actualFormatResult[77]);
    assertEquals('i', actualFormatResult[69]);
    assertEquals('l', actualFormatResult[72]);
    assertEquals('p', actualFormatResult[71]);
    assertEquals('s', actualFormatResult[70]);
    assertEquals('y', actualFormatResult[74]);
  }

  /**
   * Test {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid, List, List)}.
   *
   * <p>Method under test: {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid,
   * List, List)}
   */
  @Test
  @DisplayName("Test format(String, ReportGrid, List, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] DynamicCommaSeperatedValueFormatter.format(String, ReportGrid, List, List)"
  })
  void testFormat2() throws IOException {
    // Arrange
    DynamicCommaSeperatedValueFormatter dynamicCommaSeperatedValueFormatter =
        new DynamicCommaSeperatedValueFormatter(new FormatterUtils());

    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
    builderResult.addDerivedColumnDefinitions(
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
    ImmutableReportGrid reportGrid =
        ImmutableReportGrid.builder()
            .definition(
                builderResult
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

    // Act
    byte[] actualFormatResult =
        dynamicCommaSeperatedValueFormatter.format("42", reportGrid, null, new ArrayList<>());

    // Assert
    assertEquals(81, actualFormatResult.length);
    assertEquals(' ', actualFormatResult[75]);
    assertEquals(',', actualFormatResult[67]);
    assertEquals('D', actualFormatResult[68]);
    assertEquals('N', actualFormatResult[76]);
    assertEquals('\n', actualFormatResult[80]);
    assertEquals('a', actualFormatResult[73]);
    assertEquals('a', actualFormatResult[77]);
    assertEquals('i', actualFormatResult[69]);
    assertEquals('l', actualFormatResult[72]);
    assertEquals('p', actualFormatResult[71]);
    assertEquals('s', actualFormatResult[70]);
    assertEquals('y', actualFormatResult[74]);
  }

  /**
   * Test {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid, List, List)}.
   *
   * <ul>
   *   <li>Then return array length is eighty-nine.
   * </ul>
   *
   * <p>Method under test: {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid,
   * List, List)}
   */
  @Test
  @DisplayName(
      "Test format(String, ReportGrid, List, List); then return array length is eighty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] DynamicCommaSeperatedValueFormatter.format(String, ReportGrid, List, List)"
  })
  void testFormat_thenReturnArrayLengthIsEightyNine() throws IOException {
    // Arrange
    DynamicCommaSeperatedValueFormatter dynamicCommaSeperatedValueFormatter =
        new DynamicCommaSeperatedValueFormatter(new FormatterUtils());

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
        dynamicCommaSeperatedValueFormatter.format("42", reportGrid, columnDefinitions, reportRows);

    // Assert
    assertEquals(89, actualFormatResult.length);
    assertEquals(',', actualFormatResult[69]);
    assertEquals(',', actualFormatResult[74]);
    assertEquals(',', actualFormatResult[77]);
    assertEquals('1', actualFormatResult[68]);
    assertEquals('2', actualFormatResult[76]);
    assertEquals('4', actualFormatResult[75]);
    assertEquals('C', actualFormatResult[83]);
    assertEquals('N', actualFormatResult[70]);
    assertEquals('O', actualFormatResult[80]);
    assertEquals('P', actualFormatResult[78]);
    assertEquals('R', actualFormatResult[79]);
    assertEquals('T', actualFormatResult[84]);
    assertEquals('U', actualFormatResult[82]);
    assertEquals('a', actualFormatResult[71]);
    assertEquals('e', actualFormatResult[73]);
    assertEquals('m', actualFormatResult[72]);
  }

  /**
   * Test {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid, List, List)}.
   *
   * <ul>
   *   <li>Then return array length is one hundred ten.
   * </ul>
   *
   * <p>Method under test: {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid,
   * List, List)}
   */
  @Test
  @DisplayName(
      "Test format(String, ReportGrid, List, List); then return array length is one hundred ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] DynamicCommaSeperatedValueFormatter.format(String, ReportGrid, List, List)"
  })
  void testFormat_thenReturnArrayLengthIsOneHundredTen() throws IOException {
    // Arrange
    DynamicCommaSeperatedValueFormatter dynamicCommaSeperatedValueFormatter =
        new DynamicCommaSeperatedValueFormatter(new FormatterUtils());

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
        dynamicCommaSeperatedValueFormatter.format("42", reportGrid, columnDefinitions, reportRows);

    // Assert
    assertEquals(110, actualFormatResult.length);
    assertEquals(',', actualFormatResult[90]);
    assertEquals(',', actualFormatResult[95]);
    assertEquals(',', actualFormatResult[98]);
    assertEquals('1', actualFormatResult[89]);
    assertEquals('2', actualFormatResult[97]);
    assertEquals('4', actualFormatResult[96]);
    assertEquals('C', actualFormatResult[104]);
    assertEquals('D', actualFormatResult[102]);
    assertEquals('I', actualFormatResult[106]);
    assertEquals('N', actualFormatResult[108]);
    assertEquals('N', actualFormatResult[91]);
    assertEquals('O', actualFormatResult[101]);
    assertEquals('O', actualFormatResult[107]);
    assertEquals('P', actualFormatResult[99]);
    assertEquals('R', actualFormatResult[100]);
    assertEquals('T', actualFormatResult[105]);
    assertEquals('U', actualFormatResult[103]);
    assertEquals('\n', actualFormatResult[109]);
    assertEquals('a', actualFormatResult[92]);
    assertEquals('e', actualFormatResult[94]);
    assertEquals('m', actualFormatResult[93]);
  }

  /**
   * Test {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid, List, List)}.
   *
   * <ul>
   *   <li>Then return array length is one hundred thirty-eight.
   * </ul>
   *
   * <p>Method under test: {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid,
   * List, List)}
   */
  @Test
  @DisplayName(
      "Test format(String, ReportGrid, List, List); then return array length is one hundred thirty-eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] DynamicCommaSeperatedValueFormatter.format(String, ReportGrid, List, List)"
  })
  void testFormat_thenReturnArrayLengthIsOneHundredThirtyEight() throws IOException {
    // Arrange
    DynamicCommaSeperatedValueFormatter dynamicCommaSeperatedValueFormatter =
        new DynamicCommaSeperatedValueFormatter(new FormatterUtils());

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
        dynamicCommaSeperatedValueFormatter.format(
            "42", reportGrid, columnDefinitions, new ArrayList<>());

    // Assert
    assertEquals(138, actualFormatResult.length);
    assertEquals(' ', actualFormatResult[123]);
    assertEquals(' ', actualFormatResult[129]);
    assertEquals(',', actualFormatResult[115]);
    assertEquals(':', actualFormatResult[128]);
    assertEquals('D', actualFormatResult[116]);
    assertEquals('N', actualFormatResult[124]);
    assertEquals('\n', actualFormatResult[137]);
    assertEquals('a', actualFormatResult[121]);
    assertEquals('a', actualFormatResult[125]);
    assertEquals('c', actualFormatResult[130]);
    assertEquals('e', actualFormatResult[114]);
    assertEquals('e', actualFormatResult[134]);
    assertEquals('e', actualFormatResult[Float.MAX_EXPONENT]);
    assertEquals('i', actualFormatResult[117]);
    assertEquals('l', actualFormatResult[120]);
    assertEquals('m', actualFormatResult[113]);
    assertEquals('m', actualFormatResult[126]);
    assertEquals('m', actualFormatResult[132]);
    assertEquals('m', actualFormatResult[133]);
    assertEquals('n', actualFormatResult[135]);
    assertEquals('o', actualFormatResult[131]);
    assertEquals('p', actualFormatResult[119]);
    assertEquals('s', actualFormatResult[118]);
    assertEquals('t', actualFormatResult[136]);
    assertEquals('y', actualFormatResult[122]);
  }

  /**
   * Test {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid, List, List)}.
   *
   * <ul>
   *   <li>Then return array length is one hundred three.
   * </ul>
   *
   * <p>Method under test: {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid,
   * List, List)}
   */
  @Test
  @DisplayName(
      "Test format(String, ReportGrid, List, List); then return array length is one hundred three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] DynamicCommaSeperatedValueFormatter.format(String, ReportGrid, List, List)"
  })
  void testFormat_thenReturnArrayLengthIsOneHundredThree() throws IOException {
    // Arrange
    DynamicCommaSeperatedValueFormatter dynamicCommaSeperatedValueFormatter =
        new DynamicCommaSeperatedValueFormatter(new FormatterUtils());

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
        dynamicCommaSeperatedValueFormatter.format(
            "42", reportGrid, columnDefinitions, new ArrayList<>());

    // Assert
    assertEquals(103, actualFormatResult.length);
    assertEquals(' ', actualFormatResult[88]);
    assertEquals(' ', actualFormatResult[94]);
    assertEquals(',', actualFormatResult[80]);
    assertEquals(':', actualFormatResult[93]);
    assertEquals('N', actualFormatResult[89]);
    assertEquals('\n', actualFormatResult[102]);
    assertEquals('a', actualFormatResult[86]);
    assertEquals('a', actualFormatResult[90]);
    assertEquals('c', actualFormatResult[95]);
    assertEquals('e', actualFormatResult[92]);
    assertEquals('e', actualFormatResult[99]);
    assertEquals('i', actualFormatResult[82]);
    assertEquals('l', actualFormatResult[85]);
    assertEquals('m', actualFormatResult[91]);
    assertEquals('m', actualFormatResult[97]);
    assertEquals('m', actualFormatResult[98]);
    assertEquals('n', actualFormatResult[100]);
    assertEquals('o', actualFormatResult[96]);
    assertEquals('p', actualFormatResult[84]);
    assertEquals('s', actualFormatResult[83]);
    assertEquals('t', actualFormatResult[101]);
    assertEquals('y', actualFormatResult[87]);
  }

  /**
   * Test {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid, List, List)}.
   *
   * <ul>
   *   <li>Then return array length is sixty-eight.
   * </ul>
   *
   * <p>Method under test: {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid,
   * List, List)}
   */
  @Test
  @DisplayName(
      "Test format(String, ReportGrid, List, List); then return array length is sixty-eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] DynamicCommaSeperatedValueFormatter.format(String, ReportGrid, List, List)"
  })
  void testFormat_thenReturnArrayLengthIsSixtyEight() throws IOException {
    // Arrange
    DynamicCommaSeperatedValueFormatter dynamicCommaSeperatedValueFormatter =
        new DynamicCommaSeperatedValueFormatter(new FormatterUtils());

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
        dynamicCommaSeperatedValueFormatter.format(
            "42", reportGrid, columnDefinitions, new ArrayList<>());

    // Assert
    assertEquals(68, actualFormatResult.length);
    assertEquals(' ', actualFormatResult[51]);
    assertEquals(',', actualFormatResult[43]);
    assertEquals('L', actualFormatResult[52]);
    assertEquals('S', actualFormatResult[44]);
    assertEquals('b', actualFormatResult[46]);
    assertEquals('c', actualFormatResult[49]);
    assertEquals('e', actualFormatResult[48]);
    assertEquals('e', actualFormatResult[55]);
    assertEquals('f', actualFormatResult[54]);
    assertEquals('i', actualFormatResult[53]);
    assertEquals('j', actualFormatResult[47]);
    assertEquals('t', actualFormatResult[50]);
    assertEquals('u', actualFormatResult[45]);
  }

  /**
   * Test {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid, List, List)}.
   *
   * <ul>
   *   <li>Then return {@code Generating CSV report {}} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid,
   * List, List)}
   */
  @Test
  @DisplayName(
      "Test format(String, ReportGrid, List, List); then return 'Generating CSV report {}' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] DynamicCommaSeperatedValueFormatter.format(String, ReportGrid, List, List)"
  })
  void testFormat_thenReturnGeneratingCsvReportBytesIsUtf8() throws IOException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("Generating CSV report {}");

    FormatterUtils formatterUtils = mock(FormatterUtils.class);
    when(formatterUtils.mkHeaderStrings(
            Mockito.<List<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>>>any(),
            Mockito.<List<ReportGridDerivedColumnDefinition>>any()))
        .thenReturn(stringList);
    DynamicCommaSeperatedValueFormatter dynamicCommaSeperatedValueFormatter =
        new DynamicCommaSeperatedValueFormatter(formatterUtils);

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
        dynamicCommaSeperatedValueFormatter.format(
            "42", reportGrid, columnDefinitions, new ArrayList<>());

    // Assert
    verify(formatterUtils).mkHeaderStrings(isA(List.class), isA(List.class));
    assertArrayEquals("Generating CSV report {}\n".getBytes("UTF-8"), actualFormatResult);
  }

  /**
   * Test {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid, List, List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return array length is sixty-eight.
   * </ul>
   *
   * <p>Method under test: {@link DynamicCommaSeperatedValueFormatter#format(String, ReportGrid,
   * List, List)}
   */
  @Test
  @DisplayName(
      "Test format(String, ReportGrid, List, List); when 'null'; then return array length is sixty-eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] DynamicCommaSeperatedValueFormatter.format(String, ReportGrid, List, List)"
  })
  void testFormat_whenNull_thenReturnArrayLengthIsSixtyEight() throws IOException {
    // Arrange
    DynamicCommaSeperatedValueFormatter dynamicCommaSeperatedValueFormatter =
        new DynamicCommaSeperatedValueFormatter(new FormatterUtils());

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

    // Act
    byte[] actualFormatResult =
        dynamicCommaSeperatedValueFormatter.format("42", reportGrid, null, new ArrayList<>());

    // Assert
    assertEquals(68, actualFormatResult.length);
    assertEquals(' ', actualFormatResult[51]);
    assertEquals(',', actualFormatResult[43]);
    assertEquals('L', actualFormatResult[52]);
    assertEquals('S', actualFormatResult[44]);
    assertEquals('b', actualFormatResult[46]);
    assertEquals('c', actualFormatResult[49]);
    assertEquals('e', actualFormatResult[48]);
    assertEquals('e', actualFormatResult[55]);
    assertEquals('f', actualFormatResult[54]);
    assertEquals('i', actualFormatResult[53]);
    assertEquals('j', actualFormatResult[47]);
    assertEquals('t', actualFormatResult[50]);
    assertEquals('u', actualFormatResult[45]);
  }
}
