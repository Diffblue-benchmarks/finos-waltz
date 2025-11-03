package org.finos.waltz.web.endpoints.extracts.reportgrid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
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
   * <p>
   * Method under test: {@link FormatterUtils#mkHeaderStrings(List, List)}
   */
  @Test
  @DisplayName("Test mkHeaderStrings(List, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkHeaderStrings(List, List)"})
  void testMkHeaderStrings() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition.position()).thenReturn(1);
    when(reportGridFixedColumnDefinition.columnName()).thenReturn("Column Name");
    when(reportGridFixedColumnDefinition.displayName()).thenReturn("");
    when(reportGridFixedColumnDefinition.entityFieldReference()).thenReturn(null);
    Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary> tuple2 = new Tuple2<>(reportGridFixedColumnDefinition,
        ColumnCommentary.HAS_COMMENTARY);

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions = new ArrayList<>();
    fixedColumnDefinitions.add(tuple2);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition.displayName()).thenReturn("Display Name");
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition2 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition2.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition2.displayName()).thenReturn("Display Name");

    ArrayList<ReportGridDerivedColumnDefinition> derivedColumnDefinitions = new ArrayList<>();
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition2);
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition);

    // Act
    List<String> actualMkHeaderStringsResult = formatterUtils.mkHeaderStrings(fixedColumnDefinitions,
        derivedColumnDefinitions);

    // Assert
    verify(reportGridDerivedColumnDefinition2).displayName();
    verify(reportGridDerivedColumnDefinition).displayName();
    verify(reportGridDerivedColumnDefinition2).position();
    verify(reportGridDerivedColumnDefinition).position();
    verify(reportGridFixedColumnDefinition).columnName();
    verify(reportGridFixedColumnDefinition).displayName();
    verify(reportGridFixedColumnDefinition).entityFieldReference();
    verify(reportGridFixedColumnDefinition).position();
    assertEquals(8, actualMkHeaderStringsResult.size());
    assertEquals("Column Name", actualMkHeaderStringsResult.get(4));
    assertEquals("Column Name: comment", actualMkHeaderStringsResult.get(5));
    assertEquals("Display Name", actualMkHeaderStringsResult.get(7));
  }

  /**
   * Test {@link FormatterUtils#mkHeaderStrings(List, List)}.
   * <p>
   * Method under test: {@link FormatterUtils#mkHeaderStrings(List, List)}
   */
  @Test
  @DisplayName("Test mkHeaderStrings(List, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkHeaderStrings(List, List)"})
  void testMkHeaderStrings2() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition.position()).thenReturn(1);
    when(reportGridFixedColumnDefinition.displayName()).thenReturn("Display Name");
    Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary> tuple2 = new Tuple2<>(reportGridFixedColumnDefinition,
        null);

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions = new ArrayList<>();
    fixedColumnDefinitions.add(tuple2);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition.displayName()).thenReturn("Display Name");
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition2 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition2.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition2.displayName()).thenReturn("Display Name");

    ArrayList<ReportGridDerivedColumnDefinition> derivedColumnDefinitions = new ArrayList<>();
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition2);
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition);

    // Act
    List<String> actualMkHeaderStringsResult = formatterUtils.mkHeaderStrings(fixedColumnDefinitions,
        derivedColumnDefinitions);

    // Assert
    verify(reportGridDerivedColumnDefinition2).displayName();
    verify(reportGridDerivedColumnDefinition).displayName();
    verify(reportGridDerivedColumnDefinition2).position();
    verify(reportGridDerivedColumnDefinition).position();
    verify(reportGridFixedColumnDefinition, atLeast(1)).displayName();
    verify(reportGridFixedColumnDefinition).position();
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
   * <ul>
   *   <li>Given {@link ReportGridFixedColumnDefinition} {@link ReportGridFixedColumnDefinition#displayName()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatterUtils#mkHeaderStrings(List, List)}
   */
  @Test
  @DisplayName("Test mkHeaderStrings(List, List); given ReportGridFixedColumnDefinition displayName() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkHeaderStrings(List, List)"})
  void testMkHeaderStrings_givenReportGridFixedColumnDefinitionDisplayNameReturnNull() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition.position()).thenReturn(1);
    when(reportGridFixedColumnDefinition.columnName()).thenReturn("Column Name");
    when(reportGridFixedColumnDefinition.displayName()).thenReturn(null);
    when(reportGridFixedColumnDefinition.entityFieldReference()).thenReturn(null);
    Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary> tuple2 = new Tuple2<>(reportGridFixedColumnDefinition,
        ColumnCommentary.HAS_COMMENTARY);

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions = new ArrayList<>();
    fixedColumnDefinitions.add(tuple2);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition.displayName()).thenReturn("Display Name");
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition2 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition2.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition2.displayName()).thenReturn("Display Name");

    ArrayList<ReportGridDerivedColumnDefinition> derivedColumnDefinitions = new ArrayList<>();
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition2);
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition);

    // Act
    List<String> actualMkHeaderStringsResult = formatterUtils.mkHeaderStrings(fixedColumnDefinitions,
        derivedColumnDefinitions);

    // Assert
    verify(reportGridDerivedColumnDefinition2).displayName();
    verify(reportGridDerivedColumnDefinition).displayName();
    verify(reportGridDerivedColumnDefinition2).position();
    verify(reportGridDerivedColumnDefinition).position();
    verify(reportGridFixedColumnDefinition).columnName();
    verify(reportGridFixedColumnDefinition).displayName();
    verify(reportGridFixedColumnDefinition).entityFieldReference();
    verify(reportGridFixedColumnDefinition).position();
    assertEquals(8, actualMkHeaderStringsResult.size());
    assertEquals("Column Name", actualMkHeaderStringsResult.get(4));
    assertEquals("Column Name: comment", actualMkHeaderStringsResult.get(5));
    assertEquals("Display Name", actualMkHeaderStringsResult.get(7));
  }

  /**
   * Test {@link FormatterUtils#mkHeaderStrings(List, List)}.
   * <ul>
   *   <li>Then return seventh is {@code Display Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatterUtils#mkHeaderStrings(List, List)}
   */
  @Test
  @DisplayName("Test mkHeaderStrings(List, List); then return seventh is 'Display Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkHeaderStrings(List, List)"})
  void testMkHeaderStrings_thenReturnSeventhIsDisplayName() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition.position()).thenReturn(1);
    when(reportGridFixedColumnDefinition.displayName()).thenReturn("Display Name");
    Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary> tuple2 = new Tuple2<>(reportGridFixedColumnDefinition,
        ColumnCommentary.HAS_COMMENTARY);

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions = new ArrayList<>();
    fixedColumnDefinitions.add(tuple2);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition.displayName()).thenReturn("Display Name");
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition2 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition2.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition2.displayName()).thenReturn("Display Name");

    ArrayList<ReportGridDerivedColumnDefinition> derivedColumnDefinitions = new ArrayList<>();
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition2);
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition);

    // Act
    List<String> actualMkHeaderStringsResult = formatterUtils.mkHeaderStrings(fixedColumnDefinitions,
        derivedColumnDefinitions);

    // Assert
    verify(reportGridDerivedColumnDefinition2).displayName();
    verify(reportGridDerivedColumnDefinition).displayName();
    verify(reportGridDerivedColumnDefinition2).position();
    verify(reportGridDerivedColumnDefinition).position();
    verify(reportGridFixedColumnDefinition, atLeast(1)).displayName();
    verify(reportGridFixedColumnDefinition).position();
    assertEquals(8, actualMkHeaderStringsResult.size());
    assertEquals("Display Name", actualMkHeaderStringsResult.get(6));
    assertEquals("Display Name", actualMkHeaderStringsResult.get(7));
    assertEquals("Display Name: comment", actualMkHeaderStringsResult.get(5));
  }

  /**
   * Test {@link FormatterUtils#mkHeaderStrings(List, List)}.
   * <ul>
   *   <li>Then return size is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatterUtils#mkHeaderStrings(List, List)}
   */
  @Test
  @DisplayName("Test mkHeaderStrings(List, List); then return size is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkHeaderStrings(List, List)"})
  void testMkHeaderStrings_thenReturnSizeIsTen() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition.position()).thenReturn(1);
    when(reportGridFixedColumnDefinition.displayName()).thenReturn("Display Name");
    Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary> tuple2 = new Tuple2<>(reportGridFixedColumnDefinition,
        ColumnCommentary.HAS_COMMENTARY);

    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition2 = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition2.position()).thenReturn(1);
    when(reportGridFixedColumnDefinition2.displayName()).thenReturn("Display Name");
    Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary> tuple22 = new Tuple2<>(reportGridFixedColumnDefinition2,
        ColumnCommentary.HAS_COMMENTARY);

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions = new ArrayList<>();
    fixedColumnDefinitions.add(tuple22);
    fixedColumnDefinitions.add(tuple2);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition.displayName()).thenReturn("Display Name");
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition2 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition2.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition2.displayName()).thenReturn("Display Name");

    ArrayList<ReportGridDerivedColumnDefinition> derivedColumnDefinitions = new ArrayList<>();
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition2);
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition);

    // Act
    List<String> actualMkHeaderStringsResult = formatterUtils.mkHeaderStrings(fixedColumnDefinitions,
        derivedColumnDefinitions);

    // Assert
    verify(reportGridDerivedColumnDefinition2).displayName();
    verify(reportGridDerivedColumnDefinition).displayName();
    verify(reportGridDerivedColumnDefinition2).position();
    verify(reportGridDerivedColumnDefinition).position();
    verify(reportGridFixedColumnDefinition2, atLeast(1)).displayName();
    verify(reportGridFixedColumnDefinition, atLeast(1)).displayName();
    verify(reportGridFixedColumnDefinition2).position();
    verify(reportGridFixedColumnDefinition).position();
    assertEquals(10, actualMkHeaderStringsResult.size());
    assertEquals("Display Name", actualMkHeaderStringsResult.get(8));
    assertEquals("Display Name", actualMkHeaderStringsResult.get(9));
    assertEquals("Display Name: comment", actualMkHeaderStringsResult.get(7));
  }

  /**
   * Test {@link FormatterUtils#mkHeaderStrings(List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return size is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatterUtils#mkHeaderStrings(List, List)}
   */
  @Test
  @DisplayName("Test mkHeaderStrings(List, List); when ArrayList(); then return size is five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkHeaderStrings(List, List)"})
  void testMkHeaderStrings_whenArrayList_thenReturnSizeIsFive() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions = new ArrayList<>();
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition.displayName()).thenReturn("Display Name");

    ArrayList<ReportGridDerivedColumnDefinition> derivedColumnDefinitions = new ArrayList<>();
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition);

    // Act
    List<String> actualMkHeaderStringsResult = formatterUtils.mkHeaderStrings(fixedColumnDefinitions,
        derivedColumnDefinitions);

    // Assert
    verify(reportGridDerivedColumnDefinition).displayName();
    verify(reportGridDerivedColumnDefinition).position();
    assertEquals(5, actualMkHeaderStringsResult.size());
    assertEquals("Display Name", actualMkHeaderStringsResult.get(4));
    assertEquals("Subject External Id", actualMkHeaderStringsResult.get(2));
    assertEquals("Subject Id", actualMkHeaderStringsResult.get(0));
    assertEquals("Subject Lifecycle Phase", actualMkHeaderStringsResult.get(3));
    assertEquals("Subject Name", actualMkHeaderStringsResult.get(1));
  }

  /**
   * Test {@link FormatterUtils#mkHeaderStrings(List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatterUtils#mkHeaderStrings(List, List)}
   */
  @Test
  @DisplayName("Test mkHeaderStrings(List, List); when ArrayList(); then return size is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkHeaderStrings(List, List)"})
  void testMkHeaderStrings_whenArrayList_thenReturnSizeIsFour() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions = new ArrayList<>();

    // Act
    List<String> actualMkHeaderStringsResult = formatterUtils.mkHeaderStrings(fixedColumnDefinitions,
        new ArrayList<>());

    // Assert
    assertEquals(4, actualMkHeaderStringsResult.size());
    assertEquals("Subject External Id", actualMkHeaderStringsResult.get(2));
    assertEquals("Subject Id", actualMkHeaderStringsResult.get(0));
    assertEquals("Subject Lifecycle Phase", actualMkHeaderStringsResult.get(3));
    assertEquals("Subject Name", actualMkHeaderStringsResult.get(1));
  }

  /**
   * Test {@link FormatterUtils#mkHeaderStrings(List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return size is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatterUtils#mkHeaderStrings(List, List)}
   */
  @Test
  @DisplayName("Test mkHeaderStrings(List, List); when ArrayList(); then return size is six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkHeaderStrings(List, List)"})
  void testMkHeaderStrings_whenArrayList_thenReturnSizeIsSix() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions = new ArrayList<>();
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition.displayName()).thenReturn("Display Name");
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition2 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition2.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition2.displayName()).thenReturn("Display Name");

    ArrayList<ReportGridDerivedColumnDefinition> derivedColumnDefinitions = new ArrayList<>();
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition2);
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition);

    // Act
    List<String> actualMkHeaderStringsResult = formatterUtils.mkHeaderStrings(fixedColumnDefinitions,
        derivedColumnDefinitions);

    // Assert
    verify(reportGridDerivedColumnDefinition2).displayName();
    verify(reportGridDerivedColumnDefinition).displayName();
    verify(reportGridDerivedColumnDefinition2).position();
    verify(reportGridDerivedColumnDefinition).position();
    assertEquals(6, actualMkHeaderStringsResult.size());
    assertEquals("Display Name", actualMkHeaderStringsResult.get(4));
    assertEquals("Display Name", actualMkHeaderStringsResult.get(5));
    assertEquals("Subject External Id", actualMkHeaderStringsResult.get(2));
    assertEquals("Subject Id", actualMkHeaderStringsResult.get(0));
    assertEquals("Subject Lifecycle Phase", actualMkHeaderStringsResult.get(3));
    assertEquals("Subject Name", actualMkHeaderStringsResult.get(1));
  }

  /**
   * Test {@link FormatterUtils#mkColumnHeaders(List, List)}.
   * <p>
   * Method under test: {@link FormatterUtils#mkColumnHeaders(List, List)}
   */
  @Test
  @DisplayName("Test mkColumnHeaders(List, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkColumnHeaders(List, List)"})
  void testMkColumnHeaders() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition.position()).thenReturn(1);
    when(reportGridFixedColumnDefinition.columnName()).thenReturn("Column Name");
    when(reportGridFixedColumnDefinition.displayName()).thenReturn("");
    when(reportGridFixedColumnDefinition.entityFieldReference()).thenReturn(null);
    Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary> tuple2 = new Tuple2<>(reportGridFixedColumnDefinition,
        ColumnCommentary.HAS_COMMENTARY);

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions = new ArrayList<>();
    fixedColumnDefinitions.add(tuple2);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition.displayName()).thenReturn("Display Name");
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition2 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition2.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition2.displayName()).thenReturn("Display Name");

    ArrayList<ReportGridDerivedColumnDefinition> derivedColumnDefinitions = new ArrayList<>();
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition2);
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition);

    // Act
    List<String> actualMkColumnHeadersResult = formatterUtils.mkColumnHeaders(fixedColumnDefinitions,
        derivedColumnDefinitions);

    // Assert
    verify(reportGridDerivedColumnDefinition2).displayName();
    verify(reportGridDerivedColumnDefinition).displayName();
    verify(reportGridDerivedColumnDefinition2).position();
    verify(reportGridDerivedColumnDefinition).position();
    verify(reportGridFixedColumnDefinition).columnName();
    verify(reportGridFixedColumnDefinition).displayName();
    verify(reportGridFixedColumnDefinition).entityFieldReference();
    verify(reportGridFixedColumnDefinition).position();
    assertEquals(4, actualMkColumnHeadersResult.size());
    assertEquals("Column Name", actualMkColumnHeadersResult.get(0));
    assertEquals("Column Name: comment", actualMkColumnHeadersResult.get(1));
    assertEquals("Display Name", actualMkColumnHeadersResult.get(3));
  }

  /**
   * Test {@link FormatterUtils#mkColumnHeaders(List, List)}.
   * <p>
   * Method under test: {@link FormatterUtils#mkColumnHeaders(List, List)}
   */
  @Test
  @DisplayName("Test mkColumnHeaders(List, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkColumnHeaders(List, List)"})
  void testMkColumnHeaders2() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition.position()).thenReturn(1);
    when(reportGridFixedColumnDefinition.displayName()).thenReturn("Display Name");
    Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary> tuple2 = new Tuple2<>(reportGridFixedColumnDefinition,
        null);

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions = new ArrayList<>();
    fixedColumnDefinitions.add(tuple2);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition.displayName()).thenReturn("Display Name");
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition2 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition2.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition2.displayName()).thenReturn("Display Name");

    ArrayList<ReportGridDerivedColumnDefinition> derivedColumnDefinitions = new ArrayList<>();
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition2);
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition);

    // Act
    List<String> actualMkColumnHeadersResult = formatterUtils.mkColumnHeaders(fixedColumnDefinitions,
        derivedColumnDefinitions);

    // Assert
    verify(reportGridDerivedColumnDefinition2).displayName();
    verify(reportGridDerivedColumnDefinition).displayName();
    verify(reportGridDerivedColumnDefinition2).position();
    verify(reportGridDerivedColumnDefinition).position();
    verify(reportGridFixedColumnDefinition, atLeast(1)).displayName();
    verify(reportGridFixedColumnDefinition).position();
    assertEquals(2, actualMkColumnHeadersResult.size());
    assertEquals("Display Name", actualMkColumnHeadersResult.get(0));
    assertEquals("Display Name", actualMkColumnHeadersResult.get(1));
  }

  /**
   * Test {@link FormatterUtils#mkColumnHeaders(List, List)}.
   * <ul>
   *   <li>Given {@link ReportGridFixedColumnDefinition} {@link ReportGridFixedColumnDefinition#displayName()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatterUtils#mkColumnHeaders(List, List)}
   */
  @Test
  @DisplayName("Test mkColumnHeaders(List, List); given ReportGridFixedColumnDefinition displayName() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkColumnHeaders(List, List)"})
  void testMkColumnHeaders_givenReportGridFixedColumnDefinitionDisplayNameReturnNull() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition.position()).thenReturn(1);
    when(reportGridFixedColumnDefinition.columnName()).thenReturn("Column Name");
    when(reportGridFixedColumnDefinition.displayName()).thenReturn(null);
    when(reportGridFixedColumnDefinition.entityFieldReference()).thenReturn(null);
    Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary> tuple2 = new Tuple2<>(reportGridFixedColumnDefinition,
        ColumnCommentary.HAS_COMMENTARY);

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions = new ArrayList<>();
    fixedColumnDefinitions.add(tuple2);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition.displayName()).thenReturn("Display Name");
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition2 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition2.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition2.displayName()).thenReturn("Display Name");

    ArrayList<ReportGridDerivedColumnDefinition> derivedColumnDefinitions = new ArrayList<>();
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition2);
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition);

    // Act
    List<String> actualMkColumnHeadersResult = formatterUtils.mkColumnHeaders(fixedColumnDefinitions,
        derivedColumnDefinitions);

    // Assert
    verify(reportGridDerivedColumnDefinition2).displayName();
    verify(reportGridDerivedColumnDefinition).displayName();
    verify(reportGridDerivedColumnDefinition2).position();
    verify(reportGridDerivedColumnDefinition).position();
    verify(reportGridFixedColumnDefinition).columnName();
    verify(reportGridFixedColumnDefinition).displayName();
    verify(reportGridFixedColumnDefinition).entityFieldReference();
    verify(reportGridFixedColumnDefinition).position();
    assertEquals(4, actualMkColumnHeadersResult.size());
    assertEquals("Column Name", actualMkColumnHeadersResult.get(0));
    assertEquals("Column Name: comment", actualMkColumnHeadersResult.get(1));
    assertEquals("Display Name", actualMkColumnHeadersResult.get(3));
  }

  /**
   * Test {@link FormatterUtils#mkColumnHeaders(List, List)}.
   * <ul>
   *   <li>Then return size is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatterUtils#mkColumnHeaders(List, List)}
   */
  @Test
  @DisplayName("Test mkColumnHeaders(List, List); then return size is six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkColumnHeaders(List, List)"})
  void testMkColumnHeaders_thenReturnSizeIsSix() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition.position()).thenReturn(1);
    when(reportGridFixedColumnDefinition.displayName()).thenReturn("Display Name");
    Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary> tuple2 = new Tuple2<>(reportGridFixedColumnDefinition,
        ColumnCommentary.HAS_COMMENTARY);

    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition2 = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition2.position()).thenReturn(1);
    when(reportGridFixedColumnDefinition2.displayName()).thenReturn("Display Name");
    Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary> tuple22 = new Tuple2<>(reportGridFixedColumnDefinition2,
        ColumnCommentary.HAS_COMMENTARY);

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions = new ArrayList<>();
    fixedColumnDefinitions.add(tuple22);
    fixedColumnDefinitions.add(tuple2);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition.displayName()).thenReturn("Display Name");
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition2 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition2.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition2.displayName()).thenReturn("Display Name");

    ArrayList<ReportGridDerivedColumnDefinition> derivedColumnDefinitions = new ArrayList<>();
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition2);
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition);

    // Act
    List<String> actualMkColumnHeadersResult = formatterUtils.mkColumnHeaders(fixedColumnDefinitions,
        derivedColumnDefinitions);

    // Assert
    verify(reportGridDerivedColumnDefinition2).displayName();
    verify(reportGridDerivedColumnDefinition).displayName();
    verify(reportGridDerivedColumnDefinition2).position();
    verify(reportGridDerivedColumnDefinition).position();
    verify(reportGridFixedColumnDefinition2, atLeast(1)).displayName();
    verify(reportGridFixedColumnDefinition, atLeast(1)).displayName();
    verify(reportGridFixedColumnDefinition2).position();
    verify(reportGridFixedColumnDefinition).position();
    assertEquals(6, actualMkColumnHeadersResult.size());
    assertEquals("Display Name", actualMkColumnHeadersResult.get(4));
    assertEquals("Display Name", actualMkColumnHeadersResult.get(5));
    assertEquals("Display Name: comment", actualMkColumnHeadersResult.get(3));
  }

  /**
   * Test {@link FormatterUtils#mkColumnHeaders(List, List)}.
   * <ul>
   *   <li>Then return third is {@code Display Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatterUtils#mkColumnHeaders(List, List)}
   */
  @Test
  @DisplayName("Test mkColumnHeaders(List, List); then return third is 'Display Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkColumnHeaders(List, List)"})
  void testMkColumnHeaders_thenReturnThirdIsDisplayName() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition.position()).thenReturn(1);
    when(reportGridFixedColumnDefinition.displayName()).thenReturn("Display Name");
    Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary> tuple2 = new Tuple2<>(reportGridFixedColumnDefinition,
        ColumnCommentary.HAS_COMMENTARY);

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions = new ArrayList<>();
    fixedColumnDefinitions.add(tuple2);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition.displayName()).thenReturn("Display Name");
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition2 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition2.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition2.displayName()).thenReturn("Display Name");

    ArrayList<ReportGridDerivedColumnDefinition> derivedColumnDefinitions = new ArrayList<>();
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition2);
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition);

    // Act
    List<String> actualMkColumnHeadersResult = formatterUtils.mkColumnHeaders(fixedColumnDefinitions,
        derivedColumnDefinitions);

    // Assert
    verify(reportGridDerivedColumnDefinition2).displayName();
    verify(reportGridDerivedColumnDefinition).displayName();
    verify(reportGridDerivedColumnDefinition2).position();
    verify(reportGridDerivedColumnDefinition).position();
    verify(reportGridFixedColumnDefinition, atLeast(1)).displayName();
    verify(reportGridFixedColumnDefinition).position();
    assertEquals(4, actualMkColumnHeadersResult.size());
    assertEquals("Display Name", actualMkColumnHeadersResult.get(2));
    assertEquals("Display Name", actualMkColumnHeadersResult.get(3));
    assertEquals("Display Name: comment", actualMkColumnHeadersResult.get(1));
  }

  /**
   * Test {@link FormatterUtils#mkColumnHeaders(List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatterUtils#mkColumnHeaders(List, List)}
   */
  @Test
  @DisplayName("Test mkColumnHeaders(List, List); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkColumnHeaders(List, List)"})
  void testMkColumnHeaders_whenArrayList_thenReturnEmpty() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions = new ArrayList<>();

    // Act and Assert
    assertTrue(formatterUtils.mkColumnHeaders(fixedColumnDefinitions, new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link FormatterUtils#mkColumnHeaders(List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatterUtils#mkColumnHeaders(List, List)}
   */
  @Test
  @DisplayName("Test mkColumnHeaders(List, List); when ArrayList(); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkColumnHeaders(List, List)"})
  void testMkColumnHeaders_whenArrayList_thenReturnSizeIsOne() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions = new ArrayList<>();
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition.displayName()).thenReturn("Display Name");

    ArrayList<ReportGridDerivedColumnDefinition> derivedColumnDefinitions = new ArrayList<>();
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition);

    // Act
    List<String> actualMkColumnHeadersResult = formatterUtils.mkColumnHeaders(fixedColumnDefinitions,
        derivedColumnDefinitions);

    // Assert
    verify(reportGridDerivedColumnDefinition).displayName();
    verify(reportGridDerivedColumnDefinition).position();
    assertEquals(1, actualMkColumnHeadersResult.size());
    assertEquals("Display Name", actualMkColumnHeadersResult.get(0));
  }

  /**
   * Test {@link FormatterUtils#mkColumnHeaders(List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatterUtils#mkColumnHeaders(List, List)}
   */
  @Test
  @DisplayName("Test mkColumnHeaders(List, List); when ArrayList(); then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkColumnHeaders(List, List)"})
  void testMkColumnHeaders_whenArrayList_thenReturnSizeIsTwo() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions = new ArrayList<>();
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition.displayName()).thenReturn("Display Name");
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition2 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition2.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition2.displayName()).thenReturn("Display Name");

    ArrayList<ReportGridDerivedColumnDefinition> derivedColumnDefinitions = new ArrayList<>();
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition2);
    derivedColumnDefinitions.add(reportGridDerivedColumnDefinition);

    // Act
    List<String> actualMkColumnHeadersResult = formatterUtils.mkColumnHeaders(fixedColumnDefinitions,
        derivedColumnDefinitions);

    // Assert
    verify(reportGridDerivedColumnDefinition2).displayName();
    verify(reportGridDerivedColumnDefinition).displayName();
    verify(reportGridDerivedColumnDefinition2).position();
    verify(reportGridDerivedColumnDefinition).position();
    assertEquals(2, actualMkColumnHeadersResult.size());
    assertEquals("Display Name", actualMkColumnHeadersResult.get(0));
    assertEquals("Display Name", actualMkColumnHeadersResult.get(1));
  }

  /**
   * Test {@link FormatterUtils#mkFixedColumnHeaders(List)}.
   * <p>
   * Method under test: {@link FormatterUtils#mkFixedColumnHeaders(List)}
   */
  @Test
  @DisplayName("Test mkFixedColumnHeaders(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkFixedColumnHeaders(List)"})
  void testMkFixedColumnHeaders() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition.position()).thenReturn(1);
    when(reportGridFixedColumnDefinition.columnName()).thenReturn("Column Name");
    when(reportGridFixedColumnDefinition.displayName()).thenReturn(null);
    when(reportGridFixedColumnDefinition.entityFieldReference()).thenReturn(null);
    Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary> tuple2 = new Tuple2<>(reportGridFixedColumnDefinition,
        ColumnCommentary.HAS_COMMENTARY);

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> columnDefinitions = new ArrayList<>();
    columnDefinitions.add(tuple2);

    // Act
    List<Tuple3<String, String, Integer>> actualMkFixedColumnHeadersResult = formatterUtils
        .mkFixedColumnHeaders(columnDefinitions);

    // Assert
    verify(reportGridFixedColumnDefinition).columnName();
    verify(reportGridFixedColumnDefinition).displayName();
    verify(reportGridFixedColumnDefinition).entityFieldReference();
    verify(reportGridFixedColumnDefinition).position();
    assertEquals(1, actualMkFixedColumnHeadersResult.size());
    List<?> toListResult = actualMkFixedColumnHeadersResult.get(0).toList();
    assertEquals(3, toListResult.size());
    assertEquals("Column Name", toListResult.get(0));
    assertEquals("Column Name: comment", toListResult.get(1));
  }

  /**
   * Test {@link FormatterUtils#mkFixedColumnHeaders(List)}.
   * <p>
   * Method under test: {@link FormatterUtils#mkFixedColumnHeaders(List)}
   */
  @Test
  @DisplayName("Test mkFixedColumnHeaders(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkFixedColumnHeaders(List)"})
  void testMkFixedColumnHeaders2() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition.position()).thenReturn(1);
    when(reportGridFixedColumnDefinition.columnName()).thenReturn("Column Name");
    when(reportGridFixedColumnDefinition.displayName()).thenReturn("");
    when(reportGridFixedColumnDefinition.entityFieldReference()).thenReturn(null);
    Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary> tuple2 = new Tuple2<>(reportGridFixedColumnDefinition,
        ColumnCommentary.HAS_COMMENTARY);

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> columnDefinitions = new ArrayList<>();
    columnDefinitions.add(tuple2);

    // Act
    List<Tuple3<String, String, Integer>> actualMkFixedColumnHeadersResult = formatterUtils
        .mkFixedColumnHeaders(columnDefinitions);

    // Assert
    verify(reportGridFixedColumnDefinition).columnName();
    verify(reportGridFixedColumnDefinition).displayName();
    verify(reportGridFixedColumnDefinition).entityFieldReference();
    verify(reportGridFixedColumnDefinition).position();
    assertEquals(1, actualMkFixedColumnHeadersResult.size());
    List<?> toListResult = actualMkFixedColumnHeadersResult.get(0).toList();
    assertEquals(3, toListResult.size());
    assertEquals("Column Name", toListResult.get(0));
    assertEquals("Column Name: comment", toListResult.get(1));
  }

  /**
   * Test {@link FormatterUtils#mkFixedColumnHeaders(List)}.
   * <ul>
   *   <li>Then return first toList second is {@code Display Name: comment}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatterUtils#mkFixedColumnHeaders(List)}
   */
  @Test
  @DisplayName("Test mkFixedColumnHeaders(List); then return first toList second is 'Display Name: comment'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkFixedColumnHeaders(List)"})
  void testMkFixedColumnHeaders_thenReturnFirstToListSecondIsDisplayNameComment() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition.position()).thenReturn(1);
    when(reportGridFixedColumnDefinition.displayName()).thenReturn("Display Name");
    Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary> tuple2 = new Tuple2<>(reportGridFixedColumnDefinition,
        ColumnCommentary.HAS_COMMENTARY);

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> columnDefinitions = new ArrayList<>();
    columnDefinitions.add(tuple2);

    // Act
    List<Tuple3<String, String, Integer>> actualMkFixedColumnHeadersResult = formatterUtils
        .mkFixedColumnHeaders(columnDefinitions);

    // Assert
    verify(reportGridFixedColumnDefinition, atLeast(1)).displayName();
    verify(reportGridFixedColumnDefinition).position();
    assertEquals(1, actualMkFixedColumnHeadersResult.size());
    List<?> toListResult = actualMkFixedColumnHeadersResult.get(0).toList();
    assertEquals(3, toListResult.size());
    assertEquals("Display Name", toListResult.get(0));
    assertEquals("Display Name: comment", toListResult.get(1));
  }

  /**
   * Test {@link FormatterUtils#mkFixedColumnHeaders(List)}.
   * <ul>
   *   <li>Then return first toList second is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatterUtils#mkFixedColumnHeaders(List)}
   */
  @Test
  @DisplayName("Test mkFixedColumnHeaders(List); then return first toList second is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkFixedColumnHeaders(List)"})
  void testMkFixedColumnHeaders_thenReturnFirstToListSecondIsNull() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition.position()).thenReturn(1);
    when(reportGridFixedColumnDefinition.displayName()).thenReturn("Display Name");
    Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary> tuple2 = new Tuple2<>(reportGridFixedColumnDefinition,
        null);

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> columnDefinitions = new ArrayList<>();
    columnDefinitions.add(tuple2);

    // Act
    List<Tuple3<String, String, Integer>> actualMkFixedColumnHeadersResult = formatterUtils
        .mkFixedColumnHeaders(columnDefinitions);

    // Assert
    verify(reportGridFixedColumnDefinition, atLeast(1)).displayName();
    verify(reportGridFixedColumnDefinition).position();
    assertEquals(1, actualMkFixedColumnHeadersResult.size());
    List<?> toListResult = actualMkFixedColumnHeadersResult.get(0).toList();
    assertEquals(3, toListResult.size());
    assertEquals("Display Name", toListResult.get(0));
    assertNull(toListResult.get(1));
    assertEquals(1, ((Integer) toListResult.get(2)).intValue());
  }

  /**
   * Test {@link FormatterUtils#mkFixedColumnHeaders(List)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatterUtils#mkFixedColumnHeaders(List)}
   */
  @Test
  @DisplayName("Test mkFixedColumnHeaders(List); then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkFixedColumnHeaders(List)"})
  void testMkFixedColumnHeaders_thenReturnSizeIsTwo() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition.position()).thenReturn(1);
    when(reportGridFixedColumnDefinition.displayName()).thenReturn("Display Name");
    Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary> tuple2 = new Tuple2<>(reportGridFixedColumnDefinition,
        ColumnCommentary.HAS_COMMENTARY);

    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition2 = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition2.position()).thenReturn(1);
    when(reportGridFixedColumnDefinition2.displayName()).thenReturn("Display Name");
    Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary> tuple22 = new Tuple2<>(reportGridFixedColumnDefinition2,
        ColumnCommentary.HAS_COMMENTARY);

    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> columnDefinitions = new ArrayList<>();
    columnDefinitions.add(tuple22);
    columnDefinitions.add(tuple2);

    // Act
    List<Tuple3<String, String, Integer>> actualMkFixedColumnHeadersResult = formatterUtils
        .mkFixedColumnHeaders(columnDefinitions);

    // Assert
    verify(reportGridFixedColumnDefinition2, atLeast(1)).displayName();
    verify(reportGridFixedColumnDefinition, atLeast(1)).displayName();
    verify(reportGridFixedColumnDefinition2).position();
    verify(reportGridFixedColumnDefinition).position();
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
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatterUtils#mkFixedColumnHeaders(List)}
   */
  @Test
  @DisplayName("Test mkFixedColumnHeaders(List); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkFixedColumnHeaders(List)"})
  void testMkFixedColumnHeaders_whenArrayList_thenReturnEmpty() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();

    // Act and Assert
    assertTrue(formatterUtils.mkFixedColumnHeaders(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link FormatterUtils#mkDerivedColumnHeaders(List)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatterUtils#mkDerivedColumnHeaders(List)}
   */
  @Test
  @DisplayName("Test mkDerivedColumnHeaders(List); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkDerivedColumnHeaders(List)"})
  void testMkDerivedColumnHeaders_thenReturnSizeIsOne() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition.displayName()).thenReturn("Display Name");

    ArrayList<ReportGridDerivedColumnDefinition> columnDefinitions = new ArrayList<>();
    columnDefinitions.add(reportGridDerivedColumnDefinition);

    // Act
    List<Tuple3<String, String, Integer>> actualMkDerivedColumnHeadersResult = formatterUtils
        .mkDerivedColumnHeaders(columnDefinitions);

    // Assert
    verify(reportGridDerivedColumnDefinition).displayName();
    verify(reportGridDerivedColumnDefinition).position();
    assertEquals(1, actualMkDerivedColumnHeadersResult.size());
    List<?> toListResult = actualMkDerivedColumnHeadersResult.get(0).toList();
    assertEquals(3, toListResult.size());
    assertEquals("Display Name", toListResult.get(0));
    assertNull(toListResult.get(1));
    assertEquals(1, ((Integer) toListResult.get(2)).intValue());
  }

  /**
   * Test {@link FormatterUtils#mkDerivedColumnHeaders(List)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatterUtils#mkDerivedColumnHeaders(List)}
   */
  @Test
  @DisplayName("Test mkDerivedColumnHeaders(List); then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkDerivedColumnHeaders(List)"})
  void testMkDerivedColumnHeaders_thenReturnSizeIsTwo() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition.displayName()).thenReturn("Display Name");
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition2 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition2.position()).thenReturn(1);
    when(reportGridDerivedColumnDefinition2.displayName()).thenReturn("Display Name");

    ArrayList<ReportGridDerivedColumnDefinition> columnDefinitions = new ArrayList<>();
    columnDefinitions.add(reportGridDerivedColumnDefinition2);
    columnDefinitions.add(reportGridDerivedColumnDefinition);

    // Act
    List<Tuple3<String, String, Integer>> actualMkDerivedColumnHeadersResult = formatterUtils
        .mkDerivedColumnHeaders(columnDefinitions);

    // Assert
    verify(reportGridDerivedColumnDefinition2).displayName();
    verify(reportGridDerivedColumnDefinition).displayName();
    verify(reportGridDerivedColumnDefinition2).position();
    verify(reportGridDerivedColumnDefinition).position();
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
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatterUtils#mkDerivedColumnHeaders(List)}
   */
  @Test
  @DisplayName("Test mkDerivedColumnHeaders(List); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkDerivedColumnHeaders(List)"})
  void testMkDerivedColumnHeaders_whenArrayList_thenReturnEmpty() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();

    // Act and Assert
    assertTrue(formatterUtils.mkDerivedColumnHeaders(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link FormatterUtils#mkDerivedColumnHeaders(List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatterUtils#mkDerivedColumnHeaders(List)}
   */
  @Test
  @DisplayName("Test mkDerivedColumnHeaders(List); when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FormatterUtils.mkDerivedColumnHeaders(List)"})
  void testMkDerivedColumnHeaders_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new FormatterUtils()).mkDerivedColumnHeaders(null).isEmpty());
  }

  /**
   * Test {@link FormatterUtils#getColumnName(ReportGridFixedColumnDefinition)}.
   * <ul>
   *   <li>Given {@code Column Name}.</li>
   *   <li>Then return {@code Column Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatterUtils#getColumnName(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName("Test getColumnName(ReportGridFixedColumnDefinition); given 'Column Name'; then return 'Column Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FormatterUtils.getColumnName(ReportGridFixedColumnDefinition)"})
  void testGetColumnName_givenColumnName_thenReturnColumnName() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ReportGridFixedColumnDefinition column = mock(ReportGridFixedColumnDefinition.class);
    when(column.columnName()).thenReturn("Column Name");
    when(column.displayName()).thenReturn("");
    when(column.entityFieldReference()).thenReturn(null);

    // Act
    String actualColumnName = formatterUtils.getColumnName(column);

    // Assert
    verify(column).columnName();
    verify(column).displayName();
    verify(column).entityFieldReference();
    assertEquals("Column Name", actualColumnName);
  }

  /**
   * Test {@link FormatterUtils#getColumnName(ReportGridFixedColumnDefinition)}.
   * <ul>
   *   <li>Given {@code Display Name}.</li>
   *   <li>Then return {@code Display Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatterUtils#getColumnName(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName("Test getColumnName(ReportGridFixedColumnDefinition); given 'Display Name'; then return 'Display Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FormatterUtils.getColumnName(ReportGridFixedColumnDefinition)"})
  void testGetColumnName_givenDisplayName_thenReturnDisplayName() {
    // Arrange
    FormatterUtils formatterUtils = new FormatterUtils();
    ReportGridFixedColumnDefinition column = mock(ReportGridFixedColumnDefinition.class);
    when(column.displayName()).thenReturn("Display Name");

    // Act
    String actualColumnName = formatterUtils.getColumnName(column);

    // Assert
    verify(column, atLeast(1)).displayName();
    assertEquals("Display Name", actualColumnName);
  }
}
