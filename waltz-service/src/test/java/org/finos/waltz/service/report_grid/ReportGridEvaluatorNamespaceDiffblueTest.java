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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.finos.waltz.model.report_grid.ReportGridDefinition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReportGridEvaluatorNamespaceDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReportGridEvaluatorNamespace#ReportGridEvaluatorNamespace(ReportGridDefinition)}
   *   <li>{@link ReportGridEvaluatorNamespace#setContext(Map)}
   *   <li>{@link ReportGridEvaluatorNamespace#getContext()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ReportGridEvaluatorNamespace.<init>(ReportGridDefinition)",
      "Map ReportGridEvaluatorNamespace.getContext()", "void ReportGridEvaluatorNamespace.setContext(Map)"})
  void testGettersAndSetters() {
    // Arrange and Act
    ReportGridEvaluatorNamespace actualReportGridEvaluatorNamespace = new ReportGridEvaluatorNamespace(null);
    HashMap<String, Object> ctx = new HashMap<>();
    actualReportGridEvaluatorNamespace.setContext(ctx);
    Map<String, Object> actualContext = actualReportGridEvaluatorNamespace.getContext();

    // Assert
    assertTrue(actualContext.isEmpty());
    assertSame(ctx, actualContext);
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#addContext(String, Object)}.
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#addContext(String, Object)}
   */
  @Test
  @DisplayName("Test addContext(String, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ReportGridEvaluatorNamespace.addContext(String, Object)"})
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
   * Test {@link ReportGridEvaluatorNamespace#cell(String)}.
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#cell(String)}
   */
  @Test
  @DisplayName("Test cell(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ReportGridEvaluatorNamespace.cell(String)"})
  void testCell() {
    // Arrange, Act and Assert
    assertNull((new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).cell("42"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#coalesceCells(String[])}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#coalesceCells(String[])}
   */
  @Test
  @DisplayName("Test coalesceCells(String[]); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridEvaluatorNamespace.coalesceCells(String[])"})
  void testCoalesceCells_thenReturnNull() {
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
   * Test {@link ReportGridEvaluatorNamespace#anyCellsProvided(String[])}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#anyCellsProvided(String[])}
   */
  @Test
  @DisplayName("Test anyCellsProvided(String[]); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.anyCellsProvided(String[])"})
  void testAnyCellsProvided_thenReturnFalse() {
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
   * Test {@link ReportGridEvaluatorNamespace#allCellsProvided(String[])}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#allCellsProvided(String[])}
   */
  @Test
  @DisplayName("Test allCellsProvided(String[]); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.allCellsProvided(String[])"})
  void testAllCellsProvided_thenReturnTrue() {
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
   * Test {@link ReportGridEvaluatorNamespace#hasLifecyclePhase(String[])}.
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#hasLifecyclePhase(String[])}
   */
  @Test
  @DisplayName("Test hasLifecyclePhase(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.hasLifecyclePhase(String[])"})
  void testHasLifecyclePhase() {
    // Arrange, Act and Assert
    assertFalse((new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).hasLifecyclePhase());
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#hasLifecyclePhase(String[])}.
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#hasLifecyclePhase(String[])}
   */
  @Test
  @DisplayName("Test hasLifecyclePhase(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.hasLifecyclePhase(String[])"})
  void testHasLifecyclePhase2() {
    // Arrange
    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace = new ReportGridEvaluatorNamespace(
        mock(ReportGridDefinition.class));
    reportGridEvaluatorNamespace.addContext("subjectLifecyclePhase", "Value");

    // Act and Assert
    assertFalse(reportGridEvaluatorNamespace.hasLifecyclePhase("subjectLifecyclePhase", "value cannot be null"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#hasLifecyclePhase(String[])}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code subjectLifecyclePhase} is {@code foo}.</li>
   *   <li>When {@code Lifecycle Phases}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#hasLifecyclePhase(String[])}
   */
  @Test
  @DisplayName("Test hasLifecyclePhase(String[]); given HashMap() 'subjectLifecyclePhase' is 'foo'; when 'Lifecycle Phases'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.hasLifecyclePhase(String[])"})
  void testHasLifecyclePhase_givenHashMapSubjectLifecyclePhaseIsFoo_whenLifecyclePhases() {
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
   * Test {@link ReportGridEvaluatorNamespace#hasLifecyclePhase(String[])}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#hasLifecyclePhase(String[])}
   */
  @Test
  @DisplayName("Test hasLifecyclePhase(String[]); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.hasLifecyclePhase(String[])"})
  void testHasLifecyclePhase_thenReturnTrue() {
    // Arrange
    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace = new ReportGridEvaluatorNamespace(
        mock(ReportGridDefinition.class));
    reportGridEvaluatorNamespace.addContext("subjectLifecyclePhase", "subjectLifecyclePhase");

    // Act and Assert
    assertTrue(reportGridEvaluatorNamespace.hasLifecyclePhase("subjectLifecyclePhase", "value cannot be null"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#hasExternalId(String[])}.
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#hasExternalId(String[])}
   */
  @Test
  @DisplayName("Test hasExternalId(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.hasExternalId(String[])"})
  void testHasExternalId() {
    // Arrange, Act and Assert
    assertFalse((new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).hasExternalId());
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#hasExternalId(String[])}.
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#hasExternalId(String[])}
   */
  @Test
  @DisplayName("Test hasExternalId(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.hasExternalId(String[])"})
  void testHasExternalId2() {
    // Arrange
    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace = new ReportGridEvaluatorNamespace(
        mock(ReportGridDefinition.class));
    reportGridEvaluatorNamespace.addContext("subjectExternalId", "Value");

    // Act and Assert
    assertFalse(reportGridEvaluatorNamespace.hasExternalId("subjectExternalId", "value cannot be null"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#hasExternalId(String[])}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code subjectExternalId} is {@code foo}.</li>
   *   <li>When {@code External Ids}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#hasExternalId(String[])}
   */
  @Test
  @DisplayName("Test hasExternalId(String[]); given HashMap() 'subjectExternalId' is 'foo'; when 'External Ids'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.hasExternalId(String[])"})
  void testHasExternalId_givenHashMapSubjectExternalIdIsFoo_whenExternalIds() {
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
   * Test {@link ReportGridEvaluatorNamespace#hasExternalId(String[])}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#hasExternalId(String[])}
   */
  @Test
  @DisplayName("Test hasExternalId(String[]); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.hasExternalId(String[])"})
  void testHasExternalId_thenReturnTrue() {
    // Arrange
    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace = new ReportGridEvaluatorNamespace(
        mock(ReportGridDefinition.class));
    reportGridEvaluatorNamespace.addContext("subjectExternalId", "subjectExternalId");

    // Act and Assert
    assertTrue(reportGridEvaluatorNamespace.hasExternalId("subjectExternalId", "value cannot be null"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#hasName(String[])}.
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#hasName(String[])}
   */
  @Test
  @DisplayName("Test hasName(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.hasName(String[])"})
  void testHasName() {
    // Arrange, Act and Assert
    assertFalse((new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).hasName());
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#hasName(String[])}.
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#hasName(String[])}
   */
  @Test
  @DisplayName("Test hasName(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.hasName(String[])"})
  void testHasName2() {
    // Arrange
    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace = new ReportGridEvaluatorNamespace(
        mock(ReportGridDefinition.class));
    reportGridEvaluatorNamespace.addContext("subjectName", "Value");

    // Act and Assert
    assertFalse(reportGridEvaluatorNamespace.hasName("subjectName", "value cannot be null"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#hasName(String[])}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code subjectName} is {@code foo}.</li>
   *   <li>When {@code Names}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#hasName(String[])}
   */
  @Test
  @DisplayName("Test hasName(String[]); given HashMap() 'subjectName' is 'foo'; when 'Names'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.hasName(String[])"})
  void testHasName_givenHashMapSubjectNameIsFoo_whenNames_thenReturnFalse() {
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
   * Test {@link ReportGridEvaluatorNamespace#hasName(String[])}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#hasName(String[])}
   */
  @Test
  @DisplayName("Test hasName(String[]); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.hasName(String[])"})
  void testHasName_thenReturnTrue() {
    // Arrange
    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace = new ReportGridEvaluatorNamespace(
        mock(ReportGridDefinition.class));
    reportGridEvaluatorNamespace.addContext("subjectName", "subjectName");

    // Act and Assert
    assertTrue(reportGridEvaluatorNamespace.hasName("subjectName", "value cannot be null"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#hasId(Long[])}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code subjectId} is one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#hasId(Long[])}
   */
  @Test
  @DisplayName("Test hasId(Long[]); given HashMap() 'subjectId' is one; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.hasId(Long[])"})
  void testHasId_givenHashMapSubjectIdIsOne_thenReturnTrue() {
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
   * Test {@link ReportGridEvaluatorNamespace#hasId(Long[])}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#hasId(Long[])}
   */
  @Test
  @DisplayName("Test hasId(Long[]); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.hasId(Long[])"})
  void testHasId_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).hasId(1L));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#ratioProvided(String[])}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#ratioProvided(String[])}
   */
  @Test
  @DisplayName("Test ratioProvided(String[]); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.math.BigDecimal ReportGridEvaluatorNamespace.ratioProvided(String[])"})
  void testRatioProvided_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).ratioProvided());
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#percentageProvided(String[])}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#percentageProvided(String[])}
   */
  @Test
  @DisplayName("Test percentageProvided(String[]); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.math.BigDecimal ReportGridEvaluatorNamespace.percentageProvided(String[])"})
  void testPercentageProvided_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).percentageProvided());
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#isAfterToday(String)}.
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#isAfterToday(String)}
   */
  @Test
  @DisplayName("Test isAfterToday(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.isAfterToday(String)"})
  void testIsAfterToday() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).isAfterToday("42"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#after(String, String, String, String)}.
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#after(String, String, String, String)}
   */
  @Test
  @DisplayName("Test after(String, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CellResult ReportGridEvaluatorNamespace.after(String, String, String, String)"})
  void testAfter() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class)))
        .after("42", "2020-03-01", "Pass", "Fail"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#before(String, String, String, String)}.
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#before(String, String, String, String)}
   */
  @Test
  @DisplayName("Test before(String, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CellResult ReportGridEvaluatorNamespace.before(String, String, String, String)"})
  void testBefore() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class)))
        .before("42", "2020-03-01", "Pass", "Fail"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#isBeforeToday(String)}.
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#isBeforeToday(String)}
   */
  @Test
  @DisplayName("Test isBeforeToday(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.isBeforeToday(String)"})
  void testIsBeforeToday() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).isBeforeToday("42"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#compareDateCells(String, String)}.
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#compareDateCells(String, String)}
   */
  @Test
  @DisplayName("Test compareDateCells(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ReportGridEvaluatorNamespace.compareDateCells(String, String)"})
  void testCompareDateCells() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class)))
        .compareDateCells("Cell Ext Id A", "Cell Ext Id B"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#compareToToday(String)}.
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#compareToToday(String)}
   */
  @Test
  @DisplayName("Test compareToToday(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ReportGridEvaluatorNamespace.compareToToday(String)"})
  void testCompareToToday() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).compareToToday("42"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#compareToDate(String, String)}.
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#compareToDate(String, String)}
   */
  @Test
  @DisplayName("Test compareToDate(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ReportGridEvaluatorNamespace.compareToDate(String, String)"})
  void testCompareToDate() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).compareToDate("42", "2020-03-01"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#dateCompare(String, String, String, String, String)}.
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#dateCompare(String, String, String, String, String)}
   */
  @Test
  @DisplayName("Test dateCompare(String, String, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CellResult ReportGridEvaluatorNamespace.dateCompare(String, String, String, String, String)"})
  void testDateCompare() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class)))
        .dateCompare("42", "2020-03-01", "Before", "Equal", "After"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#isBetweenDates(String, String, String)}.
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#isBetweenDates(String, String, String)}
   */
  @Test
  @DisplayName("Test isBetweenDates(String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.isBetweenDates(String, String, String)"})
  void testIsBetweenDates() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class)))
        .isBetweenDates("42", "2020-03-01", "2020-03-01"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#betweenDates(String, String, String, String, String)}.
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#betweenDates(String, String, String, String, String)}
   */
  @Test
  @DisplayName("Test betweenDates(String, String, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CellResult ReportGridEvaluatorNamespace.betweenDates(String, String, String, String, String)"})
  void testBetweenDates() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class)))
        .betweenDates("42", "2020-03-01", "2020-03-01", "Pass", "Fail"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#parseLocalDatefromString(String)}.
   * <ul>
   *   <li>When {@code 2020-03-01}.</li>
   *   <li>Then return toString is {@code 2020-03-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#parseLocalDatefromString(String)}
   */
  @Test
  @DisplayName("Test parseLocalDatefromString(String); when '2020-03-01'; then return toString is '2020-03-01'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.time.LocalDate ReportGridEvaluatorNamespace.parseLocalDatefromString(String)"})
  void testParseLocalDatefromString_when20200301_thenReturnToStringIs20200301() {
    // Arrange, Act and Assert
    assertEquals("2020-03-01", ReportGridEvaluatorNamespace.parseLocalDatefromString("2020-03-01").toString());
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#parseLocalDatefromString(String)}.
   * <ul>
   *   <li>When {@code 2020/03/01}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#parseLocalDatefromString(String)}
   */
  @Test
  @DisplayName("Test parseLocalDatefromString(String); when '2020/03/01'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.time.LocalDate ReportGridEvaluatorNamespace.parseLocalDatefromString(String)"})
  void testParseLocalDatefromString_when20200301_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ReportGridEvaluatorNamespace.parseLocalDatefromString("2020/03/01"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#mkResult(String)} with {@code value}.
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String)}
   */
  @Test
  @DisplayName("Test mkResult(String) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CellResult ReportGridEvaluatorNamespace.mkResult(String)"})
  void testMkResultWithValue() {
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
   * Test {@link ReportGridEvaluatorNamespace#mkResult(String, String, String)} with {@code value}, {@code optionText}, {@code optionCode}.
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String, String, String)}
   */
  @Test
  @DisplayName("Test mkResult(String, String, String) with 'value', 'optionText', 'optionCode'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CellResult ReportGridEvaluatorNamespace.mkResult(String, String, String)"})
  void testMkResultWithValueOptionTextOptionCode() {
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
   * Test {@link ReportGridEvaluatorNamespace#mkResult(String)} with {@code value}.
   * <ul>
   *   <li>Given {@link ReportGridEvaluatorNamespace#ReportGridEvaluatorNamespace(ReportGridDefinition)} with definition is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String)}
   */
  @Test
  @DisplayName("Test mkResult(String) with 'value'; given ReportGridEvaluatorNamespace(ReportGridDefinition) with definition is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CellResult ReportGridEvaluatorNamespace.mkResult(String)"})
  void testMkResultWithValue_givenReportGridEvaluatorNamespaceWithDefinitionIsNull() {
    // Arrange and Act
    CellResult actualMkResultResult = (new ReportGridEvaluatorNamespace(null)).mkResult("42");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableCellResult);
    assertEquals("42", actualMkResultResult.optionCode());
    assertEquals("42", actualMkResultResult.optionText());
    assertEquals("42", actualMkResultResult.value());
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#mkResult(String)} with {@code value}.
   * <ul>
   *   <li>When {@code 42\s+}.</li>
   *   <li>Then return optionCode is {@code 42S+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String)}
   */
  @Test
  @DisplayName("Test mkResult(String) with 'value'; when '42\\s+'; then return optionCode is '42S+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CellResult ReportGridEvaluatorNamespace.mkResult(String)"})
  void testMkResultWithValue_when42S_thenReturnOptionCodeIs42s() {
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
   * Test {@link ReportGridEvaluatorNamespace#mkResult(String)} with {@code value}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return optionCode is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String)}
   */
  @Test
  @DisplayName("Test mkResult(String) with 'value'; when '42'; then return optionCode is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CellResult ReportGridEvaluatorNamespace.mkResult(String)"})
  void testMkResultWithValue_when42_thenReturnOptionCodeIs42() {
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
   * Test {@link ReportGridEvaluatorNamespace#mkResult(String)} with {@code value}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return optionCode is {@code 42_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String)}
   */
  @Test
  @DisplayName("Test mkResult(String) with 'value'; when '42'; then return optionCode is '42_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CellResult ReportGridEvaluatorNamespace.mkResult(String)"})
  void testMkResultWithValue_when42_thenReturnOptionCodeIs422() {
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
   * Test {@link ReportGridEvaluatorNamespace#mkResult(String)} with {@code value}.
   * <ul>
   *   <li>When {@code 42;}.</li>
   *   <li>Then return optionText is {@code 42;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String)}
   */
  @Test
  @DisplayName("Test mkResult(String) with 'value'; when '42;'; then return optionText is '42;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CellResult ReportGridEvaluatorNamespace.mkResult(String)"})
  void testMkResultWithValue_when42_thenReturnOptionTextIs42() {
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
   * Test {@link ReportGridEvaluatorNamespace#mkResult(String)} with {@code value}.
   * <ul>
   *   <li>When {@code 42[:;*?!/\\]}.</li>
   *   <li>Then return optionText is {@code 42[:;*?!/\\]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String)}
   */
  @Test
  @DisplayName("Test mkResult(String) with 'value'; when '42[:;*?!/\\\\]'; then return optionText is '42[:;*?!/\\\\]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CellResult ReportGridEvaluatorNamespace.mkResult(String)"})
  void testMkResultWithValue_when42_thenReturnOptionTextIs422() {
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
   * Test {@link ReportGridEvaluatorNamespace#mkResult(String)} with {@code value}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String)}
   */
  @Test
  @DisplayName("Test mkResult(String) with 'value'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CellResult ReportGridEvaluatorNamespace.mkResult(String)"})
  void testMkResultWithValue_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).mkResult(null));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#mkResult(String)} with {@code value}.
   * <ul>
   *   <li>When {@code \s+}.</li>
   *   <li>Then return optionCode is {@code S+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String)}
   */
  @Test
  @DisplayName("Test mkResult(String) with 'value'; when '\\s+'; then return optionCode is 'S+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CellResult ReportGridEvaluatorNamespace.mkResult(String)"})
  void testMkResultWithValue_whenS_thenReturnOptionCodeIsS() {
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
   * Test {@link ReportGridEvaluatorNamespace#mkResult(String)} with {@code value}.
   * <ul>
   *   <li>When {@code ;}.</li>
   *   <li>Then return optionCode is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String)}
   */
  @Test
  @DisplayName("Test mkResult(String) with 'value'; when ';'; then return optionCode is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CellResult ReportGridEvaluatorNamespace.mkResult(String)"})
  void testMkResultWithValue_whenSemicolon_thenReturnOptionCodeIsEmptyString() {
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
   * Test {@link ReportGridEvaluatorNamespace#mkResult(String)} with {@code value}.
   * <ul>
   *   <li>When space.</li>
   *   <li>Then return optionText is space.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String)}
   */
  @Test
  @DisplayName("Test mkResult(String) with 'value'; when space; then return optionText is space")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CellResult ReportGridEvaluatorNamespace.mkResult(String)"})
  void testMkResultWithValue_whenSpace_thenReturnOptionTextIsSpace() {
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
   * Test {@link ReportGridEvaluatorNamespace#numToOutcome(Byte, Object[])} with {@code Byte}, {@code Object[]}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#numToOutcome(Byte, Object[])}
   */
  @Test
  @DisplayName("Test numToOutcome(Byte, Object[]) with 'Byte', 'Object[]'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridEvaluatorNamespace.numToOutcome(Byte, Object[])"})
  void testNumToOutcomeWithByteObject_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class)))
        .numToOutcome((byte) 'A', new Object[]{"Outcomes"}));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#numToOutcome(Byte, Object[])} with {@code Byte}, {@code Object[]}.
   * <ul>
   *   <li>When empty array of {@link Object}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#numToOutcome(Byte, Object[])}
   */
  @Test
  @DisplayName("Test numToOutcome(Byte, Object[]) with 'Byte', 'Object[]'; when empty array of Object; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridEvaluatorNamespace.numToOutcome(Byte, Object[])"})
  void testNumToOutcomeWithByteObject_whenEmptyArrayOfObject_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        (new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).numToOutcome((byte) 'A', new Object[]{}));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#numToOutcome(Byte, Object[])} with {@code Byte}, {@code Object[]}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#numToOutcome(Byte, Object[])}
   */
  @Test
  @DisplayName("Test numToOutcome(Byte, Object[]) with 'Byte', 'Object[]'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridEvaluatorNamespace.numToOutcome(Byte, Object[])"})
  void testNumToOutcomeWithByteObject_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).numToOutcome((Byte) null,
        new Object[]{"Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes",
            "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes",
            "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes",
            "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes",
            "Outcomes"}));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#numToOutcome(Number, Object[])} with {@code Number}, {@code Object[]}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#numToOutcome(Number, Object[])}
   */
  @Test
  @DisplayName("Test numToOutcome(Number, Object[]) with 'Number', 'Object[]'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridEvaluatorNamespace.numToOutcome(Number, Object[])"})
  void testNumToOutcomeWithNumberObject_thenThrowIllegalStateException() {
    // Arrange
    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace = new ReportGridEvaluatorNamespace(
        mock(ReportGridDefinition.class));

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> reportGridEvaluatorNamespace.numToOutcome(Integer.valueOf(1), new Object[]{"Outcomes"}));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#numToOutcome(Number, Object[])} with {@code Number}, {@code Object[]}.
   * <ul>
   *   <li>When empty array of {@link Object}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#numToOutcome(Number, Object[])}
   */
  @Test
  @DisplayName("Test numToOutcome(Number, Object[]) with 'Number', 'Object[]'; when empty array of Object; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridEvaluatorNamespace.numToOutcome(Number, Object[])"})
  void testNumToOutcomeWithNumberObject_whenEmptyArrayOfObject_thenReturnNull() {
    // Arrange
    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace = new ReportGridEvaluatorNamespace(
        mock(ReportGridDefinition.class));

    // Act and Assert
    assertNull(reportGridEvaluatorNamespace.numToOutcome(Integer.valueOf(1), new Object[]{}));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#numToOutcome(Number, Object[])} with {@code Number}, {@code Object[]}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEvaluatorNamespace#numToOutcome(Number, Object[])}
   */
  @Test
  @DisplayName("Test numToOutcome(Number, Object[]) with 'Number', 'Object[]'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridEvaluatorNamespace.numToOutcome(Number, Object[])"})
  void testNumToOutcomeWithNumberObject_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ReportGridEvaluatorNamespace(mock(ReportGridDefinition.class))).numToOutcome((Number) null,
        new Object[]{"Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes",
            "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes",
            "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes",
            "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes", "Outcomes",
            "Outcomes"}));
  }
}
