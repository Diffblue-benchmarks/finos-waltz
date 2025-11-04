package org.finos.waltz.web.endpoints.extracts.reportgrid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.report_grid.ReportGridDerivedColumnDefinition;
import org.finos.waltz.model.report_grid.ReportGridFixedColumnDefinition;
import org.finos.waltz.web.endpoints.extracts.ColumnCommentary;
import org.jooq.lambda.tuple.Tuple2;
import org.jooq.lambda.tuple.Tuple3;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FormatterUtils.class})
@ExtendWith(SpringExtension.class)
class FormatterUtilsDiffblueTest {
  @Autowired
  private FormatterUtils formatterUtils;

  /**
   * Method under test: {@link FormatterUtils#mkHeaderStrings(List, List)}
   */
  @Test
  void testMkHeaderStrings() {
    // Arrange
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
   * Method under test: {@link FormatterUtils#mkHeaderStrings(List, List)}
   */
  @Test
  void testMkHeaderStrings2() {
    // Arrange
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
   * Method under test: {@link FormatterUtils#mkHeaderStrings(List, List)}
   */
  @Test
  void testMkHeaderStrings3() {
    // Arrange
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
   * Method under test: {@link FormatterUtils#mkHeaderStrings(List, List)}
   */
  @Test
  void testMkHeaderStrings4() {
    // Arrange
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
    assertEquals("Display Name", actualMkHeaderStringsResult.get(4));
    assertEquals("Display Name", actualMkHeaderStringsResult.get(6));
    assertEquals("Display Name", actualMkHeaderStringsResult.get(7));
    assertEquals("Display Name: comment", actualMkHeaderStringsResult.get(5));
    assertEquals("Subject External Id", actualMkHeaderStringsResult.get(2));
    assertEquals("Subject Id", actualMkHeaderStringsResult.get(0));
    assertEquals("Subject Lifecycle Phase", actualMkHeaderStringsResult.get(3));
    assertEquals("Subject Name", actualMkHeaderStringsResult.get(1));
  }

  /**
   * Method under test: {@link FormatterUtils#mkHeaderStrings(List, List)}
   */
  @Test
  void testMkHeaderStrings5() {
    // Arrange
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
    assertEquals("Display Name", actualMkHeaderStringsResult.get(6));
    assertEquals("Display Name", actualMkHeaderStringsResult.get(7));
    assertEquals("Subject External Id", actualMkHeaderStringsResult.get(2));
    assertEquals("Subject Id", actualMkHeaderStringsResult.get(0));
    assertEquals("Subject Lifecycle Phase", actualMkHeaderStringsResult.get(3));
    assertEquals("Subject Name", actualMkHeaderStringsResult.get(1));
  }

  /**
   * Method under test: {@link FormatterUtils#mkHeaderStrings(List, List)}
   */
  @Test
  void testMkHeaderStrings6() {
    // Arrange
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
    assertEquals("Display Name", actualMkHeaderStringsResult.get(6));
    assertEquals("Display Name", actualMkHeaderStringsResult.get(7));
    assertEquals("Subject External Id", actualMkHeaderStringsResult.get(2));
    assertEquals("Subject Id", actualMkHeaderStringsResult.get(0));
    assertEquals("Subject Lifecycle Phase", actualMkHeaderStringsResult.get(3));
    assertEquals("Subject Name", actualMkHeaderStringsResult.get(1));
  }

  /**
   * Method under test: {@link FormatterUtils#mkHeaderStrings(List, List)}
   */
  @Test
  void testMkHeaderStrings7() {
    // Arrange
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
   * Method under test: {@link FormatterUtils#mkHeaderStrings(List, List)}
   */
  @Test
  void testMkHeaderStrings8() {
    // Arrange
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
    assertEquals("Display Name", actualMkHeaderStringsResult.get(4));
    assertEquals("Display Name", actualMkHeaderStringsResult.get(6));
    assertEquals("Display Name", actualMkHeaderStringsResult.get(8));
    assertEquals("Display Name", actualMkHeaderStringsResult.get(9));
    assertEquals("Display Name: comment", actualMkHeaderStringsResult.get(5));
    assertEquals("Display Name: comment", actualMkHeaderStringsResult.get(7));
    assertEquals("Subject External Id", actualMkHeaderStringsResult.get(2));
    assertEquals("Subject Id", actualMkHeaderStringsResult.get(0));
    assertEquals("Subject Lifecycle Phase", actualMkHeaderStringsResult.get(3));
    assertEquals("Subject Name", actualMkHeaderStringsResult.get(1));
  }

  /**
   * Method under test: {@link FormatterUtils#mkColumnHeaders(List, List)}
   */
  @Test
  void testMkColumnHeaders() {
    // Arrange
    ArrayList<Tuple2<ReportGridFixedColumnDefinition, ColumnCommentary>> fixedColumnDefinitions = new ArrayList<>();

    // Act and Assert
    assertTrue(formatterUtils.mkColumnHeaders(fixedColumnDefinitions, new ArrayList<>()).isEmpty());
  }

  /**
   * Method under test: {@link FormatterUtils#mkColumnHeaders(List, List)}
   */
  @Test
  void testMkColumnHeaders2() {
    // Arrange
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
   * Method under test: {@link FormatterUtils#mkColumnHeaders(List, List)}
   */
  @Test
  void testMkColumnHeaders3() {
    // Arrange
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
   * Method under test: {@link FormatterUtils#mkColumnHeaders(List, List)}
   */
  @Test
  void testMkColumnHeaders4() {
    // Arrange
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
    assertEquals("Display Name", actualMkColumnHeadersResult.get(0));
    assertEquals("Display Name", actualMkColumnHeadersResult.get(2));
    assertEquals("Display Name", actualMkColumnHeadersResult.get(3));
    assertEquals("Display Name: comment", actualMkColumnHeadersResult.get(1));
  }

  /**
   * Method under test: {@link FormatterUtils#mkColumnHeaders(List, List)}
   */
  @Test
  void testMkColumnHeaders5() {
    // Arrange
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
    assertEquals("Display Name", actualMkColumnHeadersResult.get(2));
    assertEquals("Display Name", actualMkColumnHeadersResult.get(3));
  }

  /**
   * Method under test: {@link FormatterUtils#mkColumnHeaders(List, List)}
   */
  @Test
  void testMkColumnHeaders6() {
    // Arrange
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
    assertEquals("Display Name", actualMkColumnHeadersResult.get(2));
    assertEquals("Display Name", actualMkColumnHeadersResult.get(3));
  }

  /**
   * Method under test: {@link FormatterUtils#mkColumnHeaders(List, List)}
   */
  @Test
  void testMkColumnHeaders7() {
    // Arrange
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
   * Method under test: {@link FormatterUtils#mkColumnHeaders(List, List)}
   */
  @Test
  void testMkColumnHeaders8() {
    // Arrange
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
    assertEquals("Display Name", actualMkColumnHeadersResult.get(0));
    assertEquals("Display Name", actualMkColumnHeadersResult.get(2));
    assertEquals("Display Name", actualMkColumnHeadersResult.get(4));
    assertEquals("Display Name", actualMkColumnHeadersResult.get(5));
    assertEquals("Display Name: comment", actualMkColumnHeadersResult.get(1));
    assertEquals("Display Name: comment", actualMkColumnHeadersResult.get(3));
  }

  /**
   * Method under test: {@link FormatterUtils#mkFixedColumnHeaders(List)}
   */
  @Test
  void testMkFixedColumnHeaders() {
    // Arrange, Act and Assert
    assertTrue(formatterUtils.mkFixedColumnHeaders(new ArrayList<>()).isEmpty());
  }

  /**
   * Method under test: {@link FormatterUtils#mkFixedColumnHeaders(List)}
   */
  @Test
  void testMkFixedColumnHeaders2() {
    // Arrange
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
   * Method under test: {@link FormatterUtils#mkFixedColumnHeaders(List)}
   */
  @Test
  void testMkFixedColumnHeaders3() {
    // Arrange
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
   * Method under test: {@link FormatterUtils#mkFixedColumnHeaders(List)}
   */
  @Test
  void testMkFixedColumnHeaders4() {
    // Arrange
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
   * Method under test: {@link FormatterUtils#mkFixedColumnHeaders(List)}
   */
  @Test
  void testMkFixedColumnHeaders5() {
    // Arrange
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
  }

  /**
   * Method under test: {@link FormatterUtils#mkFixedColumnHeaders(List)}
   */
  @Test
  void testMkFixedColumnHeaders6() {
    // Arrange
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
   * Method under test: {@link FormatterUtils#mkDerivedColumnHeaders(List)}
   */
  @Test
  void testMkDerivedColumnHeaders() {
    // Arrange, Act and Assert
    assertTrue(formatterUtils.mkDerivedColumnHeaders(new ArrayList<>()).isEmpty());
  }

  /**
   * Method under test: {@link FormatterUtils#mkDerivedColumnHeaders(List)}
   */
  @Test
  void testMkDerivedColumnHeaders2() {
    // Arrange
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
  }

  /**
   * Method under test: {@link FormatterUtils#mkDerivedColumnHeaders(List)}
   */
  @Test
  void testMkDerivedColumnHeaders3() {
    // Arrange
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
    assertEquals(getResult, actualMkDerivedColumnHeadersResult.get(1));
  }

  /**
   * Method under test:
   * {@link FormatterUtils#getColumnName(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testGetColumnName() {
    // Arrange
    ReportGridFixedColumnDefinition column = mock(ReportGridFixedColumnDefinition.class);
    when(column.displayName()).thenReturn("Display Name");

    // Act
    String actualColumnName = formatterUtils.getColumnName(column);

    // Assert
    verify(column, atLeast(1)).displayName();
    assertEquals("Display Name", actualColumnName);
  }

  /**
   * Method under test:
   * {@link FormatterUtils#getColumnName(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testGetColumnName2() {
    // Arrange
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
}
