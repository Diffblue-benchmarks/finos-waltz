package org.finos.waltz.service.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReportGridColumnCalculatorDiffblueTest {
  /**
   * Test {@link ReportGridColumnCalculator#calculate(ReportGridInstance, ReportGridDefinition)}.
   * <ul>
   *   <li>Given {@link ASTAddNode#ASTAddNode(int)} with id is one.</li>
   *   <li>Then throw {@link JexlException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridColumnCalculator#calculate(ReportGridInstance, ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test calculate(ReportGridInstance, ReportGridDefinition); given ASTAddNode(int) with id is one; then throw JexlException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReportGridColumnCalculator.calculate(ReportGridInstance, ReportGridDefinition)"})
  void testCalculate_givenASTAddNodeWithIdIsOne_thenThrowJexlException() {
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
   * Test {@link ReportGridColumnCalculator#calculate(ReportGridInstance, ReportGridDefinition)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridColumnCalculator#calculate(ReportGridInstance, ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test calculate(ReportGridInstance, ReportGridDefinition); given ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReportGridColumnCalculator.calculate(ReportGridInstance, ReportGridDefinition)"})
  void testCalculate_givenArrayList_thenReturnEmpty() {
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
   * Test {@link ReportGridColumnCalculator#colToExtId(ReportGridDerivedColumnDefinition)} with {@code ReportGridDerivedColumnDefinition}.
   * <ul>
   *   <li>Given space.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridColumnCalculator#colToExtId(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName("Test colToExtId(ReportGridDerivedColumnDefinition) with 'ReportGridDerivedColumnDefinition'; given space")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridColumnCalculator.colToExtId(ReportGridDerivedColumnDefinition)"})
  void testColToExtIdWithReportGridDerivedColumnDefinition_givenSpace() {
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
   * Test {@link ReportGridColumnCalculator#colToExtId(ReportGridDerivedColumnDefinition)} with {@code ReportGridDerivedColumnDefinition}.
   * <ul>
   *   <li>Given {@code _}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridColumnCalculator#colToExtId(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName("Test colToExtId(ReportGridDerivedColumnDefinition) with 'ReportGridDerivedColumnDefinition'; given '_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridColumnCalculator.colToExtId(ReportGridDerivedColumnDefinition)"})
  void testColToExtIdWithReportGridDerivedColumnDefinition_givenUnderscore() {
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
   * Test {@link ReportGridColumnCalculator#colToExtId(ReportGridDerivedColumnDefinition)} with {@code ReportGridDerivedColumnDefinition}.
   * <ul>
   *   <li>Then return {@code DISPLAY_NAME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridColumnCalculator#colToExtId(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName("Test colToExtId(ReportGridDerivedColumnDefinition) with 'ReportGridDerivedColumnDefinition'; then return 'DISPLAY_NAME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridColumnCalculator.colToExtId(ReportGridDerivedColumnDefinition)"})
  void testColToExtIdWithReportGridDerivedColumnDefinition_thenReturnDisplayName() {
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
   * Test {@link ReportGridColumnCalculator#colToExtId(ReportGridDerivedColumnDefinition)} with {@code ReportGridDerivedColumnDefinition}.
   * <ul>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridColumnCalculator#colToExtId(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName("Test colToExtId(ReportGridDerivedColumnDefinition) with 'ReportGridDerivedColumnDefinition'; then return 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridColumnCalculator.colToExtId(ReportGridDerivedColumnDefinition)"})
  void testColToExtIdWithReportGridDerivedColumnDefinition_thenReturnFoo() {
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
   * Test {@link ReportGridColumnCalculator#colToExtId(ReportGridDerivedColumnDefinition)} with {@code ReportGridDerivedColumnDefinition}.
   * <ul>
   *   <li>Then throw {@link JexlException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridColumnCalculator#colToExtId(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName("Test colToExtId(ReportGridDerivedColumnDefinition) with 'ReportGridDerivedColumnDefinition'; then throw JexlException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridColumnCalculator.colToExtId(ReportGridDerivedColumnDefinition)"})
  void testColToExtIdWithReportGridDerivedColumnDefinition_thenThrowJexlException() {
    // Arrange
    ReportGridDerivedColumnDefinition col = mock(ReportGridDerivedColumnDefinition.class);
    when(col.externalId()).thenThrow(new JexlException(new ASTAddNode(1), "Msg"));

    // Act and Assert
    assertThrows(JexlException.class, () -> ReportGridColumnCalculator.colToExtId(col));
    verify(col).externalId();
  }

  /**
   * Test {@link ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)} with {@code ReportGridFixedColumnDefinition}.
   * <ul>
   *   <li>Given {@code _}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName("Test colToExtId(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'; given '_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridColumnCalculator.colToExtId(ReportGridFixedColumnDefinition)"})
  void testColToExtIdWithReportGridFixedColumnDefinition_givenUnderscore() {
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
   * Test {@link ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)} with {@code ReportGridFixedColumnDefinition}.
   * <ul>
   *   <li>Then return {@code COLUMN_NAME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName("Test colToExtId(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'; then return 'COLUMN_NAME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridColumnCalculator.colToExtId(ReportGridFixedColumnDefinition)"})
  void testColToExtIdWithReportGridFixedColumnDefinition_thenReturnColumnName() {
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

  /**
   * Test {@link ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)} with {@code ReportGridFixedColumnDefinition}.
   * <ul>
   *   <li>Then return {@code DISPLAY_NAME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName("Test colToExtId(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'; then return 'DISPLAY_NAME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridColumnCalculator.colToExtId(ReportGridFixedColumnDefinition)"})
  void testColToExtIdWithReportGridFixedColumnDefinition_thenReturnDisplayName() {
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
   * Test {@link ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)} with {@code ReportGridFixedColumnDefinition}.
   * <ul>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName("Test colToExtId(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'; then return 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridColumnCalculator.colToExtId(ReportGridFixedColumnDefinition)"})
  void testColToExtIdWithReportGridFixedColumnDefinition_thenReturnFoo() {
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
   * Test {@link ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)} with {@code ReportGridFixedColumnDefinition}.
   * <ul>
   *   <li>Then return {@code _}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName("Test colToExtId(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'; then return '_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridColumnCalculator.colToExtId(ReportGridFixedColumnDefinition)"})
  void testColToExtIdWithReportGridFixedColumnDefinition_thenReturnUnderscore() {
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
   * Test {@link ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)} with {@code ReportGridFixedColumnDefinition}.
   * <ul>
   *   <li>Then throw {@link JexlException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName("Test colToExtId(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'; then throw JexlException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridColumnCalculator.colToExtId(ReportGridFixedColumnDefinition)"})
  void testColToExtIdWithReportGridFixedColumnDefinition_thenThrowJexlException() {
    // Arrange
    ReportGridFixedColumnDefinition col = mock(ReportGridFixedColumnDefinition.class);
    when(col.externalId()).thenThrow(new JexlException(new ASTAddNode(1), "Msg"));

    // Act and Assert
    assertThrows(JexlException.class, () -> ReportGridColumnCalculator.colToExtId(col));
    verify(col).externalId();
  }
}
