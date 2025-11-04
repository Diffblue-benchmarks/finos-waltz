package org.finos.waltz.service.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.finos.waltz.model.report_grid.ReportGridDefinition;
import org.junit.jupiter.api.Test;

class ReportGridEvaluatorNamespaceDiffblueTest {
  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#addContext(String, Object)}
   */
  @Test
  void testAddContext() {
    // Arrange
    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace = new ReportGridEvaluatorNamespace(
        mock(ReportGridDefinition.class));

    // Act
    reportGridEvaluatorNamespace.addContext("Key", "Value");

    // Assert
    Map<String, Object> context = reportGridEvaluatorNamespace.getContext();
    assertEquals(1, context.size());
    assertEquals("Value", context.get("Key"));
  }

  /**
   * Method under test: {@link ReportGridEvaluatorNamespace#cell(String)}
   */
  @Test
  void testCell() {
    // Arrange, Act and Assert
    assertNull((new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).cell("42"));
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#coalesceCells(String[])}
   */
  @Test
  void testCoalesceCells() {
    // Arrange
    ReportGridDefinition definition = mock(ReportGridDefinition.class);
    when(definition.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(definition.fixedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    String actualCoalesceCellsResult = (new ReportGridEvaluatorNamespace(definition)).coalesceCells();

    // Assert
    verify(definition).derivedColumnDefinitions();
    verify(definition).fixedColumnDefinitions();
    assertNull(actualCoalesceCellsResult);
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#anyCellsProvided(String[])}
   */
  @Test
  void testAnyCellsProvided() {
    // Arrange
    ReportGridDefinition definition = mock(ReportGridDefinition.class);
    when(definition.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(definition.fixedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    boolean actualAnyCellsProvidedResult = (new ReportGridEvaluatorNamespace(definition)).anyCellsProvided();

    // Assert
    verify(definition).derivedColumnDefinitions();
    verify(definition).fixedColumnDefinitions();
    assertFalse(actualAnyCellsProvidedResult);
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#allCellsProvided(String[])}
   */
  @Test
  void testAllCellsProvided() {
    // Arrange
    ReportGridDefinition definition = mock(ReportGridDefinition.class);
    when(definition.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(definition.fixedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    boolean actualAllCellsProvidedResult = (new ReportGridEvaluatorNamespace(definition)).allCellsProvided();

    // Assert
    verify(definition).derivedColumnDefinitions();
    verify(definition).fixedColumnDefinitions();
    assertTrue(actualAllCellsProvidedResult);
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#hasLifecyclePhase(String[])}
   */
  @Test
  void testHasLifecyclePhase() {
    // Arrange
    HashMap<String, Object> ctx = new HashMap<>();
    ctx.put("subjectLifecyclePhase", "foo");

    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace = new ReportGridEvaluatorNamespace(
        mock(ReportGridDefinition.class));
    reportGridEvaluatorNamespace.setContext(ctx);

    // Act and Assert
    assertFalse(reportGridEvaluatorNamespace.hasLifecyclePhase("Lifecycle Phases"));
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#hasLifecyclePhase(String[])}
   */
  @Test
  void testHasLifecyclePhase2() {
    // Arrange, Act and Assert
    assertFalse((new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).hasLifecyclePhase());
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#hasLifecyclePhase(String[])}
   */
  @Test
  void testHasLifecyclePhase3() {
    // Arrange
    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace = new ReportGridEvaluatorNamespace(
        mock(ReportGridDefinition.class));
    reportGridEvaluatorNamespace.addContext("subjectLifecyclePhase", "Value");

    // Act and Assert
    assertFalse(reportGridEvaluatorNamespace.hasLifecyclePhase("subjectLifecyclePhase", "value cannot be null"));
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#hasLifecyclePhase(String[])}
   */
  @Test
  void testHasLifecyclePhase4() {
    // Arrange
    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace = new ReportGridEvaluatorNamespace(
        mock(ReportGridDefinition.class));
    reportGridEvaluatorNamespace.addContext("subjectLifecyclePhase", "subjectLifecyclePhase");

    // Act and Assert
    assertTrue(reportGridEvaluatorNamespace.hasLifecyclePhase("subjectLifecyclePhase", "value cannot be null"));
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#hasExternalId(String[])}
   */
  @Test
  void testHasExternalId() {
    // Arrange
    HashMap<String, Object> ctx = new HashMap<>();
    ctx.put("subjectExternalId", "foo");

    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace = new ReportGridEvaluatorNamespace(
        mock(ReportGridDefinition.class));
    reportGridEvaluatorNamespace.setContext(ctx);

    // Act and Assert
    assertFalse(reportGridEvaluatorNamespace.hasExternalId("External Ids"));
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#hasExternalId(String[])}
   */
  @Test
  void testHasExternalId2() {
    // Arrange, Act and Assert
    assertFalse((new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).hasExternalId());
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#hasExternalId(String[])}
   */
  @Test
  void testHasExternalId3() {
    // Arrange
    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace = new ReportGridEvaluatorNamespace(
        mock(ReportGridDefinition.class));
    reportGridEvaluatorNamespace.addContext("subjectExternalId", "Value");

    // Act and Assert
    assertFalse(reportGridEvaluatorNamespace.hasExternalId("subjectExternalId", "value cannot be null"));
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#hasExternalId(String[])}
   */
  @Test
  void testHasExternalId4() {
    // Arrange
    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace = new ReportGridEvaluatorNamespace(
        mock(ReportGridDefinition.class));
    reportGridEvaluatorNamespace.addContext("subjectExternalId", "subjectExternalId");

    // Act and Assert
    assertTrue(reportGridEvaluatorNamespace.hasExternalId("subjectExternalId", "value cannot be null"));
  }

  /**
   * Method under test: {@link ReportGridEvaluatorNamespace#hasName(String[])}
   */
  @Test
  void testHasName() {
    // Arrange
    HashMap<String, Object> ctx = new HashMap<>();
    ctx.put("subjectName", "foo");

    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace = new ReportGridEvaluatorNamespace(
        mock(ReportGridDefinition.class));
    reportGridEvaluatorNamespace.setContext(ctx);

    // Act and Assert
    assertFalse(reportGridEvaluatorNamespace.hasName("Names"));
  }

  /**
   * Method under test: {@link ReportGridEvaluatorNamespace#hasName(String[])}
   */
  @Test
  void testHasName2() {
    // Arrange, Act and Assert
    assertFalse((new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).hasName());
  }

  /**
   * Method under test: {@link ReportGridEvaluatorNamespace#hasName(String[])}
   */
  @Test
  void testHasName3() {
    // Arrange
    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace = new ReportGridEvaluatorNamespace(
        mock(ReportGridDefinition.class));
    reportGridEvaluatorNamespace.addContext("subjectName", "Value");

    // Act and Assert
    assertFalse(reportGridEvaluatorNamespace.hasName("subjectName", "value cannot be null"));
  }

  /**
   * Method under test: {@link ReportGridEvaluatorNamespace#hasName(String[])}
   */
  @Test
  void testHasName4() {
    // Arrange
    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace = new ReportGridEvaluatorNamespace(
        mock(ReportGridDefinition.class));
    reportGridEvaluatorNamespace.addContext("subjectName", "subjectName");

    // Act and Assert
    assertTrue(reportGridEvaluatorNamespace.hasName("subjectName", "value cannot be null"));
  }

  /**
   * Method under test: {@link ReportGridEvaluatorNamespace#hasId(Long[])}
   */
  @Test
  void testHasId() {
    // Arrange, Act and Assert
    assertFalse((new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).hasId(1L));
  }

  /**
   * Method under test: {@link ReportGridEvaluatorNamespace#hasId(Long[])}
   */
  @Test
  void testHasId2() {
    // Arrange
    HashMap<String, Object> ctx = new HashMap<>();
    ctx.put("subjectId", 1L);

    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace = new ReportGridEvaluatorNamespace(
        mock(ReportGridDefinition.class));
    reportGridEvaluatorNamespace.setContext(ctx);

    // Act and Assert
    assertTrue(reportGridEvaluatorNamespace.hasId(1L));
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#ratioProvided(String[])}
   */
  @Test
  void testRatioProvided() {
    // Arrange, Act and Assert
    assertNull((new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).ratioProvided());
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#percentageProvided(String[])}
   */
  @Test
  void testPercentageProvided() {
    // Arrange, Act and Assert
    assertNull((new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).percentageProvided());
  }

  /**
   * Method under test: {@link ReportGridEvaluatorNamespace#isAfterToday(String)}
   */
  @Test
  void testIsAfterToday() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).isAfterToday("42"));
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#after(String, String, String, String)}
   */
  @Test
  void testAfter() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class)))
        .after("42", "2020-03-01", "Pass", "Fail"));
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#before(String, String, String, String)}
   */
  @Test
  void testBefore() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class)))
        .before("42", "2020-03-01", "Pass", "Fail"));
  }

  /**
   * Method under test: {@link ReportGridEvaluatorNamespace#isBeforeToday(String)}
   */
  @Test
  void testIsBeforeToday() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).isBeforeToday("42"));
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#compareDateCells(String, String)}
   */
  @Test
  void testCompareDateCells() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class)))
        .compareDateCells("Cell Ext Id A", "Cell Ext Id B"));
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#compareToToday(String)}
   */
  @Test
  void testCompareToToday() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).compareToToday("42"));
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#compareToDate(String, String)}
   */
  @Test
  void testCompareToDate() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).compareToDate("42", "2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#dateCompare(String, String, String, String, String)}
   */
  @Test
  void testDateCompare() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class)))
        .dateCompare("42", "2020-03-01", "Before", "Equal", "After"));
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#isBetweenDates(String, String, String)}
   */
  @Test
  void testIsBetweenDates() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class)))
        .isBetweenDates("42", "2020-03-01", "2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#betweenDates(String, String, String, String, String)}
   */
  @Test
  void testBetweenDates() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class)))
        .betweenDates("42", "2020-03-01", "2020-03-01", "Pass", "Fail"));
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#parseLocalDatefromString(String)}
   */
  @Test
  void testParseLocalDatefromString() {
    // Arrange, Act and Assert
    assertEquals("2020-03-01", ReportGridEvaluatorNamespace.parseLocalDatefromString("2020-03-01").toString());
    assertThrows(IllegalArgumentException.class,
        () -> ReportGridEvaluatorNamespace.parseLocalDatefromString("2020/03/01"));
  }

  /**
   * Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String)}
   */
  @Test
  void testMkResult() {
    // Arrange and Act
    CellResult actualMkResultResult = (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class)))
        .mkResult("42");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableCellResult);
    assertEquals("42", actualMkResultResult.optionCode());
    assertEquals("42", actualMkResultResult.optionText());
    assertEquals("42", actualMkResultResult.value());
  }

  /**
   * Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String)}
   */
  @Test
  void testMkResult2() {
    // Arrange, Act and Assert
    assertNull((new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).mkResult(null));
  }

  /**
   * Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String)}
   */
  @Test
  void testMkResult3() {
    // Arrange and Act
    CellResult actualMkResultResult = (new ReportGridEvaluatorNamespace(null)).mkResult("42");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableCellResult);
    assertEquals("42", actualMkResultResult.optionCode());
    assertEquals("42", actualMkResultResult.optionText());
    assertEquals("42", actualMkResultResult.value());
  }

  /**
   * Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String)}
   */
  @Test
  void testMkResult4() {
    // Arrange and Act
    CellResult actualMkResultResult = (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class)))
        .mkResult(";");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableCellResult);
    assertEquals("", actualMkResultResult.optionCode());
    assertEquals(";", actualMkResultResult.optionText());
    assertEquals(";", actualMkResultResult.value());
  }

  /**
   * Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String)}
   */
  @Test
  void testMkResult5() {
    // Arrange and Act
    CellResult actualMkResultResult = (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class)))
        .mkResult(" ");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableCellResult);
    assertEquals(" ", actualMkResultResult.optionText());
    assertEquals(" ", actualMkResultResult.value());
    assertEquals("_", actualMkResultResult.optionCode());
  }

  /**
   * Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String)}
   */
  @Test
  void testMkResult6() {
    // Arrange and Act
    CellResult actualMkResultResult = (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class)))
        .mkResult("[:;*?!/\\\\]");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableCellResult);
    assertEquals("[:;*?!/\\\\]", actualMkResultResult.optionText());
    assertEquals("[:;*?!/\\\\]", actualMkResultResult.value());
    assertEquals("[]", actualMkResultResult.optionCode());
  }

  /**
   * Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String)}
   */
  @Test
  void testMkResult7() {
    // Arrange and Act
    CellResult actualMkResultResult = (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class)))
        .mkResult("\\s+");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableCellResult);
    assertEquals("S+", actualMkResultResult.optionCode());
    assertEquals("\\s+", actualMkResultResult.optionText());
    assertEquals("\\s+", actualMkResultResult.value());
  }

  /**
   * Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String)}
   */
  @Test
  void testMkResult8() {
    // Arrange and Act
    CellResult actualMkResultResult = (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class)))
        .mkResult("42;");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableCellResult);
    assertEquals("42", actualMkResultResult.optionCode());
    assertEquals("42;", actualMkResultResult.optionText());
    assertEquals("42;", actualMkResultResult.value());
  }

  /**
   * Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String)}
   */
  @Test
  void testMkResult9() {
    // Arrange and Act
    CellResult actualMkResultResult = (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class)))
        .mkResult("42 ");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableCellResult);
    assertEquals("42 ", actualMkResultResult.optionText());
    assertEquals("42 ", actualMkResultResult.value());
    assertEquals("42_", actualMkResultResult.optionCode());
  }

  /**
   * Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String)}
   */
  @Test
  void testMkResult10() {
    // Arrange and Act
    CellResult actualMkResultResult = (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class)))
        .mkResult("42[:;*?!/\\\\]");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableCellResult);
    assertEquals("42[:;*?!/\\\\]", actualMkResultResult.optionText());
    assertEquals("42[:;*?!/\\\\]", actualMkResultResult.value());
    assertEquals("42[]", actualMkResultResult.optionCode());
  }

  /**
   * Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String)}
   */
  @Test
  void testMkResult11() {
    // Arrange and Act
    CellResult actualMkResultResult = (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class)))
        .mkResult("42\\s+");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableCellResult);
    assertEquals("42S+", actualMkResultResult.optionCode());
    assertEquals("42\\s+", actualMkResultResult.optionText());
    assertEquals("42\\s+", actualMkResultResult.value());
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#mkResult(String, String, String)}
   */
  @Test
  void testMkResult12() {
    // Arrange and Act
    CellResult actualMkResultResult = (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class)))
        .mkResult("42", "Option Text", "Option Code");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableCellResult);
    assertEquals("42", actualMkResultResult.value());
    assertEquals("Option Code", actualMkResultResult.optionCode());
    assertEquals("Option Text", actualMkResultResult.optionText());
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#numToOutcome(Byte, Object[])}
   */
  @Test
  void testNumToOutcome() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class)))
        .numToOutcome((byte) 'A', new Object[]{"Outcomes"}));
    assertNull((new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).numToOutcome((Byte) null,
        new Object[]{"Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes",
            "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes",
            "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes",
            "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes",
            "Outcomes"}));
    assertNull(
        (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).numToOutcome((byte) 'A', new Object[]{}));
    assertNull((new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).numToOutcome((Number) null,
        new Object[]{"Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes",
            "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes",
            "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes",
            "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes",
            "Outcomes"}));
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#numToOutcome(Number, Object[])}
   */
  @Test
  void testNumToOutcome2() {
    // Arrange
    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace = new ReportGridEvaluatorNamespace(
        mock(ReportGridDefinition.class));

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> reportGridEvaluatorNamespace.numToOutcome(Integer.valueOf(1), new Object[]{"Outcomes"}));
  }

  /**
   * Method under test:
   * {@link ReportGridEvaluatorNamespace#numToOutcome(Number, Object[])}
   */
  @Test
  void testNumToOutcome3() {
    // Arrange
    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace = new ReportGridEvaluatorNamespace(
        mock(ReportGridDefinition.class));

    // Act and Assert
    assertNull(reportGridEvaluatorNamespace.numToOutcome(Integer.valueOf(1), new Object[]{}));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ReportGridEvaluatorNamespace#ReportGridEvaluatorNamespace(ReportGridDefinition)}
   *   <li>{@link ReportGridEvaluatorNamespace#setContext(Map)}
   *   <li>{@link ReportGridEvaluatorNamespace#getContext()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ReportGridEvaluatorNamespace actualReportGridEvaluatorNamespace = new ReportGridEvaluatorNamespace(null);
    HashMap<String, Object> ctx = new HashMap<>();
    actualReportGridEvaluatorNamespace.setContext(ctx);
    Map<String, Object> actualContext = actualReportGridEvaluatorNamespace.getContext();

    // Assert that nothing has changed
    assertTrue(actualContext.isEmpty());
    assertSame(ctx, actualContext);
  }
}
