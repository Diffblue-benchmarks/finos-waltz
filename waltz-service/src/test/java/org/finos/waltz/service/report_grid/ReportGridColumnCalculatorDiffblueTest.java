package org.finos.waltz.service.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.apache.commons.jexl3.JexlException;
import org.apache.commons.jexl3.parser.ASTAddNode;
import org.finos.waltz.model.report_grid.ReportGridCell;
import org.finos.waltz.model.report_grid.ReportGridDefinition;
import org.finos.waltz.model.report_grid.ReportGridDerivedColumnDefinition;
import org.finos.waltz.model.report_grid.ReportGridFixedColumnDefinition;
import org.finos.waltz.model.report_grid.ReportGridInstance;
import org.junit.jupiter.api.Test;

class ReportGridColumnCalculatorDiffblueTest {
  /**
   * Method under test:
   * {@link ReportGridColumnCalculator#calculate(ReportGridInstance, ReportGridDefinition)}
   */
  @Test
  void testCalculate() {
    // Arrange
    ReportGridInstance instance = mock(ReportGridInstance.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.subjects()).thenReturn(new HashSet<>());
    ReportGridDefinition definition = mock(ReportGridDefinition.class);
    when(definition.derivedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    Set<ReportGridCell> actualCalculateResult = ReportGridColumnCalculator.calculate(instance, definition);

    // Assert
    verify(definition).derivedColumnDefinitions();
    verify(instance).cellData();
    verify(instance).ratingSchemeItems();
    verify(instance).subjects();
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReportGridColumnCalculator#calculate(ReportGridInstance, ReportGridDefinition)}
   */
  @Test
  void testCalculate2() {
    // Arrange
    ReportGridInstance instance = mock(ReportGridInstance.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    ReportGridDefinition definition = mock(ReportGridDefinition.class);
    when(definition.derivedColumnDefinitions()).thenThrow(new JexlException(new ASTAddNode(1), "xs cannot be null"));

    // Act and Assert
    assertThrows(JexlException.class, () -> ReportGridColumnCalculator.calculate(instance, definition));
    verify(definition).derivedColumnDefinitions();
    verify(instance).cellData();
    verify(instance).ratingSchemeItems();
  }

  /**
   * Method under test:
   * {@link ReportGridColumnCalculator#colToExtId(ReportGridDerivedColumnDefinition)}
   */
  @Test
  void testColToExtId() {
    // Arrange
    ReportGridDerivedColumnDefinition col = mock(ReportGridDerivedColumnDefinition.class);
    Optional<String> ofResult = Optional.of("foo");
    when(col.externalId()).thenReturn(ofResult);

    // Act
    String actualColToExtIdResult = ReportGridColumnCalculator.colToExtId(col);

    // Assert
    verify(col).externalId();
    assertEquals("foo", actualColToExtIdResult);
  }

  /**
   * Method under test:
   * {@link ReportGridColumnCalculator#colToExtId(ReportGridDerivedColumnDefinition)}
   */
  @Test
  void testColToExtId2() {
    // Arrange
    ReportGridDerivedColumnDefinition col = mock(ReportGridDerivedColumnDefinition.class);
    when(col.displayName()).thenReturn("Display Name");
    Optional<String> emptyResult = Optional.empty();
    when(col.externalId()).thenReturn(emptyResult);

    // Act
    String actualColToExtIdResult = ReportGridColumnCalculator.colToExtId(col);

    // Assert
    verify(col).externalId();
    verify(col).displayName();
    assertEquals("DISPLAY_NAME", actualColToExtIdResult);
  }

  /**
   * Method under test:
   * {@link ReportGridColumnCalculator#colToExtId(ReportGridDerivedColumnDefinition)}
   */
  @Test
  void testColToExtId3() {
    // Arrange
    ReportGridDerivedColumnDefinition col = mock(ReportGridDerivedColumnDefinition.class);
    when(col.externalId()).thenThrow(new JexlException(new ASTAddNode(1), "Msg"));

    // Act and Assert
    assertThrows(JexlException.class, () -> ReportGridColumnCalculator.colToExtId(col));
    verify(col).externalId();
  }

  /**
   * Method under test:
   * {@link ReportGridColumnCalculator#colToExtId(ReportGridDerivedColumnDefinition)}
   */
  @Test
  void testColToExtId4() {
    // Arrange
    ReportGridDerivedColumnDefinition col = mock(ReportGridDerivedColumnDefinition.class);
    when(col.displayName()).thenReturn(" ");
    Optional<String> emptyResult = Optional.empty();
    when(col.externalId()).thenReturn(emptyResult);

    // Act
    String actualColToExtIdResult = ReportGridColumnCalculator.colToExtId(col);

    // Assert
    verify(col).externalId();
    verify(col).displayName();
    assertEquals("_", actualColToExtIdResult);
  }

  /**
   * Method under test:
   * {@link ReportGridColumnCalculator#colToExtId(ReportGridDerivedColumnDefinition)}
   */
  @Test
  void testColToExtId5() {
    // Arrange
    ReportGridDerivedColumnDefinition col = mock(ReportGridDerivedColumnDefinition.class);
    when(col.displayName()).thenReturn("_");
    Optional<String> emptyResult = Optional.empty();
    when(col.externalId()).thenReturn(emptyResult);

    // Act
    String actualColToExtIdResult = ReportGridColumnCalculator.colToExtId(col);

    // Assert
    verify(col).externalId();
    verify(col).displayName();
    assertEquals("_", actualColToExtIdResult);
  }

  /**
   * Method under test:
   * {@link ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testColToExtId6() {
    // Arrange
    ReportGridFixedColumnDefinition col = mock(ReportGridFixedColumnDefinition.class);
    Optional<String> ofResult = Optional.of("foo");
    when(col.externalId()).thenReturn(ofResult);

    // Act
    String actualColToExtIdResult = ReportGridColumnCalculator.colToExtId(col);

    // Assert
    verify(col).externalId();
    assertEquals("foo", actualColToExtIdResult);
  }

  /**
   * Method under test:
   * {@link ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testColToExtId7() {
    // Arrange
    ReportGridFixedColumnDefinition col = mock(ReportGridFixedColumnDefinition.class);
    when(col.displayName()).thenReturn("Display Name");
    Optional<String> emptyResult = Optional.empty();
    when(col.externalId()).thenReturn(emptyResult);

    // Act
    String actualColToExtIdResult = ReportGridColumnCalculator.colToExtId(col);

    // Assert
    verify(col).externalId();
    verify(col, atLeast(1)).displayName();
    assertEquals("DISPLAY_NAME", actualColToExtIdResult);
  }

  /**
   * Method under test:
   * {@link ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testColToExtId8() {
    // Arrange
    ReportGridFixedColumnDefinition col = mock(ReportGridFixedColumnDefinition.class);
    when(col.externalId()).thenThrow(new JexlException(new ASTAddNode(1), "Msg"));

    // Act and Assert
    assertThrows(JexlException.class, () -> ReportGridColumnCalculator.colToExtId(col));
    verify(col).externalId();
  }

  /**
   * Method under test:
   * {@link ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testColToExtId9() {
    // Arrange
    ReportGridFixedColumnDefinition col = mock(ReportGridFixedColumnDefinition.class);
    when(col.displayName()).thenReturn(" ");
    Optional<String> emptyResult = Optional.empty();
    when(col.externalId()).thenReturn(emptyResult);

    // Act
    String actualColToExtIdResult = ReportGridColumnCalculator.colToExtId(col);

    // Assert
    verify(col).externalId();
    verify(col, atLeast(1)).displayName();
    assertEquals("_", actualColToExtIdResult);
  }

  /**
   * Method under test:
   * {@link ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testColToExtId10() {
    // Arrange
    ReportGridFixedColumnDefinition col = mock(ReportGridFixedColumnDefinition.class);
    when(col.displayName()).thenReturn("_");
    Optional<String> emptyResult = Optional.empty();
    when(col.externalId()).thenReturn(emptyResult);

    // Act
    String actualColToExtIdResult = ReportGridColumnCalculator.colToExtId(col);

    // Assert
    verify(col).externalId();
    verify(col, atLeast(1)).displayName();
    assertEquals("_", actualColToExtIdResult);
  }

  /**
   * Method under test:
   * {@link ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testColToExtId11() {
    // Arrange
    ReportGridFixedColumnDefinition col = mock(ReportGridFixedColumnDefinition.class);
    when(col.columnName()).thenReturn("Column Name");
    when(col.displayName()).thenReturn(null);
    Optional<String> emptyResult = Optional.empty();
    when(col.externalId()).thenReturn(emptyResult);

    // Act
    String actualColToExtIdResult = ReportGridColumnCalculator.colToExtId(col);

    // Assert
    verify(col).externalId();
    verify(col).columnName();
    verify(col).displayName();
    assertEquals("COLUMN_NAME", actualColToExtIdResult);
  }
}
