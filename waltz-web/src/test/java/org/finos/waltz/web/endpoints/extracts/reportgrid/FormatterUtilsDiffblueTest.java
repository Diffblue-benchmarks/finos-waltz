package org.finos.waltz.web.endpoints.extracts.reportgrid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.entity_field_reference.ImmutableEntityFieldReference;
import org.finos.waltz.model.report_grid.AdditionalColumnOptions;
import org.finos.waltz.model.report_grid.ImmutableReportGridDerivedColumnDefinition;
import org.finos.waltz.model.report_grid.ImmutableReportGridFixedColumnDefinition;
import org.finos.waltz.model.report_grid.ImmutableReportGridFixedColumnDefinition.Builder;
import org.finos.waltz.model.report_grid.ReportGridDerivedColumnDefinition;
import org.finos.waltz.model.report_grid.ReportGridFixedColumnDefinition;
import org.finos.waltz.web.endpoints.extracts.ColumnCommentary;
import org.jooq.lambda.tuple.Tuple2;
import org.jooq.lambda.tuple.Tuple3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FormatterUtilsDiffblueTest {
  /**
   * Test {@link FormatterUtils#mkHeaderStrings(List, List)}.
   *
   * <p>Method under test: {@link FormatterUtils#mkHeaderStrings(List, List)}
   */
  @Test
  @DisplayName("Test mkHeaderStrings(List, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkHeaderStrings(List, List)"})
  void testMkHeaderStrings() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions =
        new ArrayList<>();

    Builder displayNameResult =
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
    Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary> tuple2 =
        new Tuple2<>(immutableReportGridFixedColumnDefinition, null);
    fixedColumnDefinitions.add(tuple2);

    // Act
    List<String> actualMkHeaderStringsResult =
        formatterUtils.mkHeaderStrings(fixedColumnDefinitions, new ArrayList<>());

    // Assert
    assertEquals(5, actualMkHeaderStringsResult.size());
    assertEquals("Display Name", actualMkHeaderStringsResult.get(4));
    assertEquals("Subject External Id", actualMkHeaderStringsResult.get(2));
    assertEquals("Subject Id", actualMkHeaderStringsResult.get(0));
    assertEquals("Subject Lifecycle Phase", actualMkHeaderStringsResult.get(3));
    assertEquals("Subject Name", actualMkHeaderStringsResult.get(1));
  }

  /**
   * Test {@link FormatterUtils#mkHeaderStrings(List, List)}.
   *
   * <p>Method under test: {@link FormatterUtils#mkHeaderStrings(List, List)}
   */
  @Test
  @DisplayName("Test mkHeaderStrings(List, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkHeaderStrings(List, List)"})
  void testMkHeaderStrings2() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions =
        new ArrayList<>();

    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName(null);
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
    fixedColumnDefinitions.add(
        new Tuple2<>(immutableReportGridFixedColumnDefinition, ColumnCommentary.HAS_COMMENTARY));

    // Act
    List<String> actualMkHeaderStringsResult =
        formatterUtils.mkHeaderStrings(fixedColumnDefinitions, new ArrayList<>());

    // Assert
    assertEquals(6, actualMkHeaderStringsResult.size());
    assertEquals("Display Name / Column Name", actualMkHeaderStringsResult.get(4));
    assertEquals("Display Name / Column Name: comment", actualMkHeaderStringsResult.get(5));
    assertEquals("Subject External Id", actualMkHeaderStringsResult.get(2));
    assertEquals("Subject Id", actualMkHeaderStringsResult.get(0));
    assertEquals("Subject Lifecycle Phase", actualMkHeaderStringsResult.get(3));
    assertEquals("Subject Name", actualMkHeaderStringsResult.get(1));
  }

  /**
   * Test {@link FormatterUtils#mkHeaderStrings(List, List)}.
   *
   * <p>Method under test: {@link FormatterUtils#mkHeaderStrings(List, List)}
   */
  @Test
  @DisplayName("Test mkHeaderStrings(List, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkHeaderStrings(List, List)"})
  void testMkHeaderStrings3() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions =
        new ArrayList<>();

    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("");
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
    fixedColumnDefinitions.add(
        new Tuple2<>(immutableReportGridFixedColumnDefinition, ColumnCommentary.HAS_COMMENTARY));

    // Act
    List<String> actualMkHeaderStringsResult =
        formatterUtils.mkHeaderStrings(fixedColumnDefinitions, new ArrayList<>());

    // Assert
    assertEquals(6, actualMkHeaderStringsResult.size());
    assertEquals("Display Name / Column Name", actualMkHeaderStringsResult.get(4));
    assertEquals("Display Name / Column Name: comment", actualMkHeaderStringsResult.get(5));
    assertEquals("Subject External Id", actualMkHeaderStringsResult.get(2));
    assertEquals("Subject Id", actualMkHeaderStringsResult.get(0));
    assertEquals("Subject Lifecycle Phase", actualMkHeaderStringsResult.get(3));
    assertEquals("Subject Name", actualMkHeaderStringsResult.get(1));
  }

  /**
   * Test {@link FormatterUtils#mkHeaderStrings(List, List)}.
   *
   * <ul>
   *   <li>Then return sixth is {@code Display Name}.
   * </ul>
   *
   * <p>Method under test: {@link FormatterUtils#mkHeaderStrings(List, List)}
   */
  @Test
  @DisplayName("Test mkHeaderStrings(List, List); then return sixth is 'Display Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkHeaderStrings(List, List)"})
  void testMkHeaderStrings_thenReturnSixthIsDisplayName() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions =
        new ArrayList<>();

    ArrayList<ReportGridDerivedColumnDefinition> derivedColumnDefinitions = new ArrayList<>();
    derivedColumnDefinitions.add(
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
    derivedColumnDefinitions.add(
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());

    // Act
    List<String> actualMkHeaderStringsResult =
        formatterUtils.mkHeaderStrings(fixedColumnDefinitions, derivedColumnDefinitions);

    // Assert
    assertEquals(6, actualMkHeaderStringsResult.size());
    assertEquals("Display Name", actualMkHeaderStringsResult.get(4));
    assertEquals("Display Name", actualMkHeaderStringsResult.get(5));
    assertEquals("Subject External Id", actualMkHeaderStringsResult.get(2));
    assertEquals("Subject Id", actualMkHeaderStringsResult.get(0));
    assertEquals("Subject Lifecycle Phase", actualMkHeaderStringsResult.get(3));
    assertEquals("Subject Name", actualMkHeaderStringsResult.get(1));
  }

  /**
   * Test {@link FormatterUtils#mkHeaderStrings(List, List)}.
   *
   * <ul>
   *   <li>Then return sixth is {@code Display Name: comment}.
   * </ul>
   *
   * <p>Method under test: {@link FormatterUtils#mkHeaderStrings(List, List)}
   */
  @Test
  @DisplayName("Test mkHeaderStrings(List, List); then return sixth is 'Display Name: comment'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkHeaderStrings(List, List)"})
  void testMkHeaderStrings_thenReturnSixthIsDisplayNameComment() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions =
        new ArrayList<>();

    Builder displayNameResult =
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
    fixedColumnDefinitions.add(
        new Tuple2<>(immutableReportGridFixedColumnDefinition, ColumnCommentary.HAS_COMMENTARY));

    // Act
    List<String> actualMkHeaderStringsResult =
        formatterUtils.mkHeaderStrings(fixedColumnDefinitions, new ArrayList<>());

    // Assert
    assertEquals(6, actualMkHeaderStringsResult.size());
    assertEquals("Display Name", actualMkHeaderStringsResult.get(4));
    assertEquals("Display Name: comment", actualMkHeaderStringsResult.get(5));
    assertEquals("Subject External Id", actualMkHeaderStringsResult.get(2));
    assertEquals("Subject Id", actualMkHeaderStringsResult.get(0));
    assertEquals("Subject Lifecycle Phase", actualMkHeaderStringsResult.get(3));
    assertEquals("Subject Name", actualMkHeaderStringsResult.get(1));
  }

  /**
   * Test {@link FormatterUtils#mkHeaderStrings(List, List)}.
   *
   * <ul>
   *   <li>Then return size is eight.
   * </ul>
   *
   * <p>Method under test: {@link FormatterUtils#mkHeaderStrings(List, List)}
   */
  @Test
  @DisplayName("Test mkHeaderStrings(List, List); then return size is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkHeaderStrings(List, List)"})
  void testMkHeaderStrings_thenReturnSizeIsEight() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions =
        new ArrayList<>();

    Builder displayNameResult =
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
    fixedColumnDefinitions.add(
        new Tuple2<>(immutableReportGridFixedColumnDefinition, ColumnCommentary.HAS_COMMENTARY));

    Builder displayNameResult2 =
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
    fixedColumnDefinitions.add(
        new Tuple2<>(immutableReportGridFixedColumnDefinition2, ColumnCommentary.HAS_COMMENTARY));

    // Act
    List<String> actualMkHeaderStringsResult =
        formatterUtils.mkHeaderStrings(fixedColumnDefinitions, new ArrayList<>());

    // Assert
    assertEquals(8, actualMkHeaderStringsResult.size());
    assertEquals("Display Name", actualMkHeaderStringsResult.get(6));
    assertEquals("Display Name: comment", actualMkHeaderStringsResult.get(5));
    assertEquals("Display Name: comment", actualMkHeaderStringsResult.get(7));
  }

  /**
   * Test {@link FormatterUtils#mkHeaderStrings(List, List)}.
   *
   * <ul>
   *   <li>Then return size is five.
   * </ul>
   *
   * <p>Method under test: {@link FormatterUtils#mkHeaderStrings(List, List)}
   */
  @Test
  @DisplayName("Test mkHeaderStrings(List, List); then return size is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkHeaderStrings(List, List)"})
  void testMkHeaderStrings_thenReturnSizeIsFive() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions =
        new ArrayList<>();

    ArrayList<ReportGridDerivedColumnDefinition> derivedColumnDefinitions = new ArrayList<>();
    derivedColumnDefinitions.add(
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());

    // Act
    List<String> actualMkHeaderStringsResult =
        formatterUtils.mkHeaderStrings(fixedColumnDefinitions, derivedColumnDefinitions);

    // Assert
    assertEquals(5, actualMkHeaderStringsResult.size());
    assertEquals("Display Name", actualMkHeaderStringsResult.get(4));
    assertEquals("Subject External Id", actualMkHeaderStringsResult.get(2));
    assertEquals("Subject Id", actualMkHeaderStringsResult.get(0));
    assertEquals("Subject Lifecycle Phase", actualMkHeaderStringsResult.get(3));
    assertEquals("Subject Name", actualMkHeaderStringsResult.get(1));
  }

  /**
   * Test {@link FormatterUtils#mkHeaderStrings(List, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return size is four.
   * </ul>
   *
   * <p>Method under test: {@link FormatterUtils#mkHeaderStrings(List, List)}
   */
  @Test
  @DisplayName("Test mkHeaderStrings(List, List); when ArrayList(); then return size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkHeaderStrings(List, List)"})
  void testMkHeaderStrings_whenArrayList_thenReturnSizeIsFour() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions =
        new ArrayList<>();

    // Act
    List<String> actualMkHeaderStringsResult =
        formatterUtils.mkHeaderStrings(fixedColumnDefinitions, new ArrayList<>());

    // Assert
    assertEquals(4, actualMkHeaderStringsResult.size());
    assertEquals("Subject External Id", actualMkHeaderStringsResult.get(2));
    assertEquals("Subject Id", actualMkHeaderStringsResult.get(0));
    assertEquals("Subject Lifecycle Phase", actualMkHeaderStringsResult.get(3));
    assertEquals("Subject Name", actualMkHeaderStringsResult.get(1));
  }

  /**
   * Test {@link FormatterUtils#mkColumnHeaders(List, List)}.
   *
   * <p>Method under test: {@link FormatterUtils#mkColumnHeaders(List, List)}
   */
  @Test
  @DisplayName("Test mkColumnHeaders(List, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkColumnHeaders(List, List)"})
  void testMkColumnHeaders() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions =
        new ArrayList<>();

    Builder displayNameResult =
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
    Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary> tuple2 =
        new Tuple2<>(immutableReportGridFixedColumnDefinition, null);
    fixedColumnDefinitions.add(tuple2);

    // Act
    List<String> actualMkColumnHeadersResult =
        formatterUtils.mkColumnHeaders(fixedColumnDefinitions, new ArrayList<>());

    // Assert
    assertEquals(1, actualMkColumnHeadersResult.size());
    assertEquals("Display Name", actualMkColumnHeadersResult.get(0));
  }

  /**
   * Test {@link FormatterUtils#mkColumnHeaders(List, List)}.
   *
   * <p>Method under test: {@link FormatterUtils#mkColumnHeaders(List, List)}
   */
  @Test
  @DisplayName("Test mkColumnHeaders(List, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkColumnHeaders(List, List)"})
  void testMkColumnHeaders2() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions =
        new ArrayList<>();

    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName(null);
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
    fixedColumnDefinitions.add(
        new Tuple2<>(immutableReportGridFixedColumnDefinition, ColumnCommentary.HAS_COMMENTARY));

    // Act
    List<String> actualMkColumnHeadersResult =
        formatterUtils.mkColumnHeaders(fixedColumnDefinitions, new ArrayList<>());

    // Assert
    assertEquals(2, actualMkColumnHeadersResult.size());
    assertEquals("Display Name / Column Name", actualMkColumnHeadersResult.get(0));
    assertEquals("Display Name / Column Name: comment", actualMkColumnHeadersResult.get(1));
  }

  /**
   * Test {@link FormatterUtils#mkColumnHeaders(List, List)}.
   *
   * <p>Method under test: {@link FormatterUtils#mkColumnHeaders(List, List)}
   */
  @Test
  @DisplayName("Test mkColumnHeaders(List, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkColumnHeaders(List, List)"})
  void testMkColumnHeaders3() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions =
        new ArrayList<>();

    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("");
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
    fixedColumnDefinitions.add(
        new Tuple2<>(immutableReportGridFixedColumnDefinition, ColumnCommentary.HAS_COMMENTARY));

    // Act
    List<String> actualMkColumnHeadersResult =
        formatterUtils.mkColumnHeaders(fixedColumnDefinitions, new ArrayList<>());

    // Assert
    assertEquals(2, actualMkColumnHeadersResult.size());
    assertEquals("Display Name / Column Name", actualMkColumnHeadersResult.get(0));
    assertEquals("Display Name / Column Name: comment", actualMkColumnHeadersResult.get(1));
  }

  /**
   * Test {@link FormatterUtils#mkColumnHeaders(List, List)}.
   *
   * <ul>
   *   <li>Then return second is {@code Display Name}.
   * </ul>
   *
   * <p>Method under test: {@link FormatterUtils#mkColumnHeaders(List, List)}
   */
  @Test
  @DisplayName("Test mkColumnHeaders(List, List); then return second is 'Display Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkColumnHeaders(List, List)"})
  void testMkColumnHeaders_thenReturnSecondIsDisplayName() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions =
        new ArrayList<>();

    ArrayList<ReportGridDerivedColumnDefinition> derivedColumnDefinitions = new ArrayList<>();
    derivedColumnDefinitions.add(
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
    derivedColumnDefinitions.add(
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());

    // Act
    List<String> actualMkColumnHeadersResult =
        formatterUtils.mkColumnHeaders(fixedColumnDefinitions, derivedColumnDefinitions);

    // Assert
    assertEquals(2, actualMkColumnHeadersResult.size());
    assertEquals("Display Name", actualMkColumnHeadersResult.get(0));
    assertEquals("Display Name", actualMkColumnHeadersResult.get(1));
  }

  /**
   * Test {@link FormatterUtils#mkColumnHeaders(List, List)}.
   *
   * <ul>
   *   <li>Then return second is {@code Display Name: comment}.
   * </ul>
   *
   * <p>Method under test: {@link FormatterUtils#mkColumnHeaders(List, List)}
   */
  @Test
  @DisplayName("Test mkColumnHeaders(List, List); then return second is 'Display Name: comment'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkColumnHeaders(List, List)"})
  void testMkColumnHeaders_thenReturnSecondIsDisplayNameComment() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions =
        new ArrayList<>();

    Builder displayNameResult =
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
    fixedColumnDefinitions.add(
        new Tuple2<>(immutableReportGridFixedColumnDefinition, ColumnCommentary.HAS_COMMENTARY));

    // Act
    List<String> actualMkColumnHeadersResult =
        formatterUtils.mkColumnHeaders(fixedColumnDefinitions, new ArrayList<>());

    // Assert
    assertEquals(2, actualMkColumnHeadersResult.size());
    assertEquals("Display Name", actualMkColumnHeadersResult.get(0));
    assertEquals("Display Name: comment", actualMkColumnHeadersResult.get(1));
  }

  /**
   * Test {@link FormatterUtils#mkColumnHeaders(List, List)}.
   *
   * <ul>
   *   <li>Then return size is four.
   * </ul>
   *
   * <p>Method under test: {@link FormatterUtils#mkColumnHeaders(List, List)}
   */
  @Test
  @DisplayName("Test mkColumnHeaders(List, List); then return size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkColumnHeaders(List, List)"})
  void testMkColumnHeaders_thenReturnSizeIsFour() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions =
        new ArrayList<>();

    Builder displayNameResult =
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
    fixedColumnDefinitions.add(
        new Tuple2<>(immutableReportGridFixedColumnDefinition, ColumnCommentary.HAS_COMMENTARY));

    Builder displayNameResult2 =
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
    fixedColumnDefinitions.add(
        new Tuple2<>(immutableReportGridFixedColumnDefinition2, ColumnCommentary.HAS_COMMENTARY));

    // Act
    List<String> actualMkColumnHeadersResult =
        formatterUtils.mkColumnHeaders(fixedColumnDefinitions, new ArrayList<>());

    // Assert
    assertEquals(4, actualMkColumnHeadersResult.size());
    assertEquals("Display Name", actualMkColumnHeadersResult.get(2));
    assertEquals("Display Name: comment", actualMkColumnHeadersResult.get(1));
    assertEquals("Display Name: comment", actualMkColumnHeadersResult.get(3));
  }

  /**
   * Test {@link FormatterUtils#mkColumnHeaders(List, List)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link FormatterUtils#mkColumnHeaders(List, List)}
   */
  @Test
  @DisplayName("Test mkColumnHeaders(List, List); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkColumnHeaders(List, List)"})
  void testMkColumnHeaders_thenReturnSizeIsOne() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions =
        new ArrayList<>();

    ArrayList<ReportGridDerivedColumnDefinition> derivedColumnDefinitions = new ArrayList<>();
    derivedColumnDefinitions.add(
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());

    // Act
    List<String> actualMkColumnHeadersResult =
        formatterUtils.mkColumnHeaders(fixedColumnDefinitions, derivedColumnDefinitions);

    // Assert
    assertEquals(1, actualMkColumnHeadersResult.size());
    assertEquals("Display Name", actualMkColumnHeadersResult.get(0));
  }

  /**
   * Test {@link FormatterUtils#mkColumnHeaders(List, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FormatterUtils#mkColumnHeaders(List, List)}
   */
  @Test
  @DisplayName("Test mkColumnHeaders(List, List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkColumnHeaders(List, List)"})
  void testMkColumnHeaders_whenArrayList_thenReturnEmpty() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions =
        new ArrayList<>();

    // Act and Assert
    assertTrue(formatterUtils.mkColumnHeaders(fixedColumnDefinitions, new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link FormatterUtils#mkFixedColumnHeaders(List)}.
   *
   * <p>Method under test: {@link FormatterUtils#mkFixedColumnHeaders(List)}
   */
  @Test
  @DisplayName("Test mkFixedColumnHeaders(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkFixedColumnHeaders(List)"})
  void testMkFixedColumnHeaders() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> columnDefinitions =
        new ArrayList<>();

    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName(null);
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
    List<Tuple3<String, String, Integer>> actualMkFixedColumnHeadersResult =
        formatterUtils.mkFixedColumnHeaders(columnDefinitions);

    // Assert
    assertEquals(1, actualMkFixedColumnHeadersResult.size());
    List<?> toListResult = actualMkFixedColumnHeadersResult.get(0).toList();
    assertEquals(3, toListResult.size());
    assertEquals("Display Name / Column Name", toListResult.get(0));
    assertEquals("Display Name / Column Name: comment", toListResult.get(1));
  }

  /**
   * Test {@link FormatterUtils#mkFixedColumnHeaders(List)}.
   *
   * <p>Method under test: {@link FormatterUtils#mkFixedColumnHeaders(List)}
   */
  @Test
  @DisplayName("Test mkFixedColumnHeaders(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkFixedColumnHeaders(List)"})
  void testMkFixedColumnHeaders2() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> columnDefinitions =
        new ArrayList<>();

    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("");
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
    List<Tuple3<String, String, Integer>> actualMkFixedColumnHeadersResult =
        formatterUtils.mkFixedColumnHeaders(columnDefinitions);

    // Assert
    assertEquals(1, actualMkFixedColumnHeadersResult.size());
    List<?> toListResult = actualMkFixedColumnHeadersResult.get(0).toList();
    assertEquals(3, toListResult.size());
    assertEquals("Display Name / Column Name", toListResult.get(0));
    assertEquals("Display Name / Column Name: comment", toListResult.get(1));
  }

  /**
   * Test {@link FormatterUtils#mkFixedColumnHeaders(List)}.
   *
   * <ul>
   *   <li>Then return first toList second is {@code Display Name: comment}.
   * </ul>
   *
   * <p>Method under test: {@link FormatterUtils#mkFixedColumnHeaders(List)}
   */
  @Test
  @DisplayName(
      "Test mkFixedColumnHeaders(List); then return first toList second is 'Display Name: comment'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkFixedColumnHeaders(List)"})
  void testMkFixedColumnHeaders_thenReturnFirstToListSecondIsDisplayNameComment() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> columnDefinitions =
        new ArrayList<>();

    Builder displayNameResult =
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
    List<Tuple3<String, String, Integer>> actualMkFixedColumnHeadersResult =
        formatterUtils.mkFixedColumnHeaders(columnDefinitions);

    // Assert
    assertEquals(1, actualMkFixedColumnHeadersResult.size());
    List<?> toListResult = actualMkFixedColumnHeadersResult.get(0).toList();
    assertEquals(3, toListResult.size());
    assertEquals("Display Name", toListResult.get(0));
    assertEquals("Display Name: comment", toListResult.get(1));
  }

  /**
   * Test {@link FormatterUtils#mkFixedColumnHeaders(List)}.
   *
   * <ul>
   *   <li>Then return first toList second is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FormatterUtils#mkFixedColumnHeaders(List)}
   */
  @Test
  @DisplayName("Test mkFixedColumnHeaders(List); then return first toList second is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkFixedColumnHeaders(List)"})
  void testMkFixedColumnHeaders_thenReturnFirstToListSecondIsNull() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> columnDefinitions =
        new ArrayList<>();

    Builder displayNameResult =
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
    Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary> tuple2 =
        new Tuple2<>(immutableReportGridFixedColumnDefinition, null);
    columnDefinitions.add(tuple2);

    // Act
    List<Tuple3<String, String, Integer>> actualMkFixedColumnHeadersResult =
        formatterUtils.mkFixedColumnHeaders(columnDefinitions);

    // Assert
    assertEquals(1, actualMkFixedColumnHeadersResult.size());
    List<?> toListResult = actualMkFixedColumnHeadersResult.get(0).toList();
    assertEquals(3, toListResult.size());
    assertEquals("Display Name", toListResult.get(0));
    assertNull(toListResult.get(1));
    assertEquals(1, ((Integer) toListResult.get(2)).intValue());
  }

  /**
   * Test {@link FormatterUtils#mkFixedColumnHeaders(List)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link FormatterUtils#mkFixedColumnHeaders(List)}
   */
  @Test
  @DisplayName("Test mkFixedColumnHeaders(List); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkFixedColumnHeaders(List)"})
  void testMkFixedColumnHeaders_thenReturnSizeIsTwo() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> columnDefinitions =
        new ArrayList<>();

    Builder displayNameResult =
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

    Builder displayNameResult2 =
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
    List<Tuple3<String, String, Integer>> actualMkFixedColumnHeadersResult =
        formatterUtils.mkFixedColumnHeaders(columnDefinitions);

    // Assert
    assertEquals(2, actualMkFixedColumnHeadersResult.size());
    Tuple3<String, String, Integer> getResult = actualMkFixedColumnHeadersResult.get(0);
    List<?> toListResult = getResult.toList();
    assertEquals(3, toListResult.size());
    assertEquals("Display Name", toListResult.get(0));
    assertEquals("Display Name: comment", toListResult.get(1));
    assertEquals(getResult, actualMkFixedColumnHeadersResult.get(1));
  }

  /**
   * Test {@link FormatterUtils#mkFixedColumnHeaders(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FormatterUtils#mkFixedColumnHeaders(List)}
   */
  @Test
  @DisplayName("Test mkFixedColumnHeaders(List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkFixedColumnHeaders(List)"})
  void testMkFixedColumnHeaders_whenArrayList_thenReturnEmpty() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();

    // Act and Assert
    assertTrue(formatterUtils.mkFixedColumnHeaders(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link FormatterUtils#mkFixedColumnHeaders(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FormatterUtils#mkFixedColumnHeaders(List)}
   */
  @Test
  @DisplayName("Test mkFixedColumnHeaders(List); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkFixedColumnHeaders(List)"})
  void testMkFixedColumnHeaders_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new FormatterUtils().mkFixedColumnHeaders(null).isEmpty());
  }

  /**
   * Test {@link FormatterUtils#mkDerivedColumnHeaders(List)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link FormatterUtils#mkDerivedColumnHeaders(List)}
   */
  @Test
  @DisplayName("Test mkDerivedColumnHeaders(List); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkDerivedColumnHeaders(List)"})
  void testMkDerivedColumnHeaders_thenReturnSizeIsOne() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();

    ArrayList<ReportGridDerivedColumnDefinition> columnDefinitions = new ArrayList<>();
    columnDefinitions.add(
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());

    // Act
    List<Tuple3<String, String, Integer>> actualMkDerivedColumnHeadersResult =
        formatterUtils.mkDerivedColumnHeaders(columnDefinitions);

    // Assert
    assertEquals(1, actualMkDerivedColumnHeadersResult.size());
    List<?> toListResult = actualMkDerivedColumnHeadersResult.get(0).toList();
    assertEquals(3, toListResult.size());
    assertEquals("Display Name", toListResult.get(0));
    assertNull(toListResult.get(1));
    assertEquals(1, ((Integer) toListResult.get(2)).intValue());
  }

  /**
   * Test {@link FormatterUtils#mkDerivedColumnHeaders(List)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link FormatterUtils#mkDerivedColumnHeaders(List)}
   */
  @Test
  @DisplayName("Test mkDerivedColumnHeaders(List); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkDerivedColumnHeaders(List)"})
  void testMkDerivedColumnHeaders_thenReturnSizeIsTwo() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();

    ArrayList<ReportGridDerivedColumnDefinition> columnDefinitions = new ArrayList<>();
    columnDefinitions.add(
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
    columnDefinitions.add(
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());

    // Act
    List<Tuple3<String, String, Integer>> actualMkDerivedColumnHeadersResult =
        formatterUtils.mkDerivedColumnHeaders(columnDefinitions);

    // Assert
    assertEquals(2, actualMkDerivedColumnHeadersResult.size());
    Tuple3<String, String, Integer> getResult = actualMkDerivedColumnHeadersResult.get(0);
    List<?> toListResult = getResult.toList();
    assertEquals(3, toListResult.size());
    assertEquals("Display Name", toListResult.get(0));
    assertNull(toListResult.get(1));
    assertEquals(1, ((Integer) toListResult.get(2)).intValue());
    assertEquals(getResult, actualMkDerivedColumnHeadersResult.get(1));
  }

  /**
   * Test {@link FormatterUtils#mkDerivedColumnHeaders(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FormatterUtils#mkDerivedColumnHeaders(List)}
   */
  @Test
  @DisplayName("Test mkDerivedColumnHeaders(List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkDerivedColumnHeaders(List)"})
  void testMkDerivedColumnHeaders_whenArrayList_thenReturnEmpty() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();

    // Act and Assert
    assertTrue(formatterUtils.mkDerivedColumnHeaders(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link FormatterUtils#mkDerivedColumnHeaders(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FormatterUtils#mkDerivedColumnHeaders(List)}
   */
  @Test
  @DisplayName("Test mkDerivedColumnHeaders(List); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FormatterUtils.mkDerivedColumnHeaders(List)"})
  void testMkDerivedColumnHeaders_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new FormatterUtils().mkDerivedColumnHeaders(null).isEmpty());
  }

  /**
   * Test {@link FormatterUtils#getColumnName(ReportGridFixedColumnDefinition)}.
   *
   * <p>Method under test: {@link FormatterUtils#getColumnName(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName("Test getColumnName(ReportGridFixedColumnDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FormatterUtils.getColumnName(ReportGridFixedColumnDefinition)"})
  void testGetColumnName() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();

    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("");

    // Act
    String actualColumnName =
        formatterUtils.getColumnName(
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
                .build());

    // Assert
    assertEquals("Display Name / Column Name", actualColumnName);
  }

  /**
   * Test {@link FormatterUtils#getColumnName(ReportGridFixedColumnDefinition)}.
   *
   * <p>Method under test: {@link FormatterUtils#getColumnName(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName("Test getColumnName(ReportGridFixedColumnDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FormatterUtils.getColumnName(ReportGridFixedColumnDefinition)"})
  void testGetColumnName2() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();

    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName(null);

    // Act
    String actualColumnName =
        formatterUtils.getColumnName(
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
                .build());

    // Assert
    assertEquals("Display Name / Column Name", actualColumnName);
  }

  /**
   * Test {@link FormatterUtils#getColumnName(ReportGridFixedColumnDefinition)}.
   *
   * <ul>
   *   <li>Then return {@code Display Name}.
   * </ul>
   *
   * <p>Method under test: {@link FormatterUtils#getColumnName(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName("Test getColumnName(ReportGridFixedColumnDefinition); then return 'Display Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FormatterUtils.getColumnName(ReportGridFixedColumnDefinition)"})
  void testGetColumnName_thenReturnDisplayName() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();

    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act
    String actualColumnName =
        formatterUtils.getColumnName(
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
                .build());

    // Assert
    assertEquals("Display Name", actualColumnName);
  }
}
