package org.finos.waltz.service.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.report_grid.GridFilter;
import org.finos.waltz.model.report_grid.ReportGridDefinition;
import org.finos.waltz.model.report_grid.ReportGridDerivedColumnDefinition;
import org.finos.waltz.model.report_grid.ReportGridFixedColumnDefinition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReportGridUtilitiesDiffblueTest {
  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities
        .parseGridFilterNoteText("| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id |"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText2() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities
        .parseGridFilterNoteText("| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id |;"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText3() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities
        .parseGridFilterNoteText("| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id | "));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText4() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities
        .parseGridFilterNoteText("| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id |Note Text"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText5() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities
        .parseGridFilterNoteText("| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id |\\r?\\n"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText6() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText(
        "| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id |[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText7() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText(
        "| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id |java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText8() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities
        .parseGridFilterNoteText("| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id |42"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText9() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities
        .parseGridFilterNoteText("| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id |\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText10() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText(
        "| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id |java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText11() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities
        .parseGridFilterNoteText("| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id ||"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText12() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities
        .parseGridFilterNoteText("| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id ||--"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText13() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities
        .parseGridFilterNoteText("|| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id |"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText14() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText("|[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText15() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText(
        "|Incorrect number of header rows found [%d], ensure there are blank rows between tables"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText16() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText(
        "| Filter Column | Filter Operator | Value/s |org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText17() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText(
        "| Filter Column | Filter Operator | Value/s || Filter Column | Filter Operator | Value/s |"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenAString() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText(
            "| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id || Grid Name | Grid Identifier"
                + " | Vantage Point Kind | Vantage Point Id |"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenAString2() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText(
            "| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id |org.finos.waltz.service.report"
                + "_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenAString3() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText(
            "| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id || Filter Column | Filter Operator"
                + " | Value/s |"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenAString4() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText(
            "| Grid Name | Grid Identifier | Vantage Point Kind | Vantage Point Id |Incorrect number of header rows"
                + " found [%d], ensure there are blank rows between tables"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenAString5() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText(
            "| Filter Column | Filter Operator | Value/s || Grid Name | Grid Identifier | Vantage Point Kind |"
                + " Vantage Point Id |"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenAString6() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText(
            "| Filter Column | Filter Operator | Value/s |Incorrect number of header rows found [%d], ensure there"
                + " are blank rows between tables"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When {@code |Cannot parse empty note}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when '|Cannot parse empty note'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenCannotParseEmptyNote() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText("|Cannot parse empty note"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When {@code || Filter Column | Filter Operator | Value/s |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when '|| Filter Column | Filter Operator | Value/s |'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenFilterColumnFilterOperatorValueS() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText("|| Filter Column | Filter Operator | Value/s |"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When {@code | Filter Column | Filter Operator | Value/s |;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when '| Filter Column | Filter Operator | Value/s |;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenFilterColumnFilterOperatorValueS2() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText("| Filter Column | Filter Operator | Value/s |;"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When {@code | Filter Column | Filter Operator | Value/s |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when '| Filter Column | Filter Operator | Value/s |'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenFilterColumnFilterOperatorValueS3() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText("| Filter Column | Filter Operator | Value/s | "));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When {@code | Filter Column | Filter Operator | Value/s |[:;*?!/\\]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when '| Filter Column | Filter Operator | Value/s |[:;*?!/\\\\]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenFilterColumnFilterOperatorValueS4() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText("| Filter Column | Filter Operator | Value/s |[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When {@code | Filter Column | Filter Operator | Value/s ||}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when '| Filter Column | Filter Operator | Value/s ||'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenFilterColumnFilterOperatorValueS5() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText("| Filter Column | Filter Operator | Value/s ||"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When {@code | Filter Column | Filter Operator | Value/s ||--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when '| Filter Column | Filter Operator | Value/s ||--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenFilterColumnFilterOperatorValueS6() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText("| Filter Column | Filter Operator | Value/s ||--"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When {@code | Filter Column | Filter Operator | Value/s |42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when '| Filter Column | Filter Operator | Value/s |42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenFilterColumnFilterOperatorValueS42() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText("| Filter Column | Filter Operator | Value/s |42"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When {@code | Filter Column | Filter Operator | Value/s |List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when '| Filter Column | Filter Operator | Value/s |java.util.List'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenFilterColumnFilterOperatorValueSJavaUtilList() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities
        .parseGridFilterNoteText("| Filter Column | Filter Operator | Value/s |java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When {@code | Filter Column | Filter Operator | Value/s |Optional}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when '| Filter Column | Filter Operator | Value/s |java.util.Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenFilterColumnFilterOperatorValueSJavaUtilOptional() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities
        .parseGridFilterNoteText("| Filter Column | Filter Operator | Value/s |java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When {@code | Filter Column | Filter Operator | Value/s |Note Text}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when '| Filter Column | Filter Operator | Value/s |Note Text'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenFilterColumnFilterOperatorValueSNoteText() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText("| Filter Column | Filter Operator | Value/s |Note Text"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When {@code | Filter Column | Filter Operator | Value/s |\r?\n}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when '| Filter Column | Filter Operator | Value/s |\\r?\\n'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenFilterColumnFilterOperatorValueSRN() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText("| Filter Column | Filter Operator | Value/s |\\r?\\n"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When {@code | Filter Column | Filter Operator | Value/s |\s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when '| Filter Column | Filter Operator | Value/s |\\s+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenFilterColumnFilterOperatorValueSS() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.parseGridFilterNoteText("| Filter Column | Filter Operator | Value/s |\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When {@code Note Text}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when 'Note Text'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenNoteText() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText("Note Text"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When {@code |Note Text}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when '|Note Text'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenNoteText2() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText("|Note Text"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenNull() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText(null));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When {@code |\r?\n}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when '|\\r?\\n'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenRN() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText("|\\r?\\n"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When {@code |\s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when '|\\s+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenS() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText("|\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When space.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when space")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenSpace() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText(" "));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When {@code |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when '|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenVerticalLine() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText("| "));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When {@code |--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when '|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenVerticalLineDashDash() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText("|--"));
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilterNoteText(String)}.
   * <ul>
   *   <li>When {@code |;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilterNoteText(String)}
   */
  @Test
  @DisplayName("Test parseGridFilterNoteText(String); when '|;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.lambda.tuple.Tuple2 ReportGridUtilities.parseGridFilterNoteText(String)"})
  void testParseGridFilterNoteText_whenVerticalLineSemicolon() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> ReportGridUtilities.parseGridFilterNoteText("|;"));
  }

  /**
   * Test {@link ReportGridUtilities#getFilterValues(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#getFilterValues(String)}
   */
  @Test
  @DisplayName("Test getFilterValues(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReportGridUtilities.getFilterValues(String)"})
  void testGetFilterValues() {
    // Arrange and Act
    Set<String> actualFilterValues = ReportGridUtilities.getFilterValues("String");

    // Assert
    assertEquals(1, actualFilterValues.size());
    assertTrue(actualFilterValues.contains("String"));
  }

  /**
   * Test {@link ReportGridUtilities#parseTableData(String[], String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  @DisplayName("Test parseTableData(String[], String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ReportGridUtilities.parseTableData(String[], String)"})
  void testParseTableData() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{"Lines"},
        "[:;*?!/\\\\]");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseTableData(String[], String)}.
   * <ul>
   *   <li>When array of {@link String} with {@code ;} and space.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  @DisplayName("Test parseTableData(String[], String); when array of String with ';' and space")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ReportGridUtilities.parseTableData(String[], String)"})
  void testParseTableData_whenArrayOfStringWithSemicolonAndSpace() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{";", " "},
        "Table Header");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseTableData(String[], String)}.
   * <ul>
   *   <li>When array of {@link String} with space.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  @DisplayName("Test parseTableData(String[], String); when array of String with space")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ReportGridUtilities.parseTableData(String[], String)"})
  void testParseTableData_whenArrayOfStringWithSpace() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{" "},
        "Table Header");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseTableData(String[], String)}.
   * <ul>
   *   <li>When array of {@link String} with {@code |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  @DisplayName("Test parseTableData(String[], String); when array of String with '|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ReportGridUtilities.parseTableData(String[], String)"})
  void testParseTableData_whenArrayOfStringWithVerticalLine() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{"|"},
        "Table Header");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseTableData(String[], String)}.
   * <ul>
   *   <li>When array of {@link String} with {@code |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  @DisplayName("Test parseTableData(String[], String); when array of String with '|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ReportGridUtilities.parseTableData(String[], String)"})
  void testParseTableData_whenArrayOfStringWithVerticalLine2() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{"|"}, ";");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseTableData(String[], String)}.
   * <ul>
   *   <li>When array of {@link String} with {@code |--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  @DisplayName("Test parseTableData(String[], String); when array of String with '|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ReportGridUtilities.parseTableData(String[], String)"})
  void testParseTableData_whenArrayOfStringWithVerticalLineDashDash() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{"|--"}, ";");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseTableData(String[], String)}.
   * <ul>
   *   <li>When array of {@link String} with {@code | --}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  @DisplayName("Test parseTableData(String[], String); when array of String with '| --'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ReportGridUtilities.parseTableData(String[], String)"})
  void testParseTableData_whenArrayOfStringWithVerticalLineSpaceDashDash() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{"| --"}, ";");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseTableData(String[], String)}.
   * <ul>
   *   <li>When empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  @DisplayName("Test parseTableData(String[], String); when empty array of String")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ReportGridUtilities.parseTableData(String[], String)"})
  void testParseTableData_whenEmptyArrayOfString() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{}, "Table Header");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseTableData(String[], String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  @DisplayName("Test parseTableData(String[], String); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ReportGridUtilities.parseTableData(String[], String)"})
  void testParseTableData_whenNull() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(null, null);

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseTableData(String[], String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  @DisplayName("Test parseTableData(String[], String); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ReportGridUtilities.parseTableData(String[], String)"})
  void testParseTableData_whenNull2() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{"Lines"}, null);

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseTableData(String[], String)}.
   * <ul>
   *   <li>When {@code \s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  @DisplayName("Test parseTableData(String[], String); when '\\s+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ReportGridUtilities.parseTableData(String[], String)"})
  void testParseTableData_whenS() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{"Lines"}, "\\s+");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseTableData(String[], String)}.
   * <ul>
   *   <li>When {@code ;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  @DisplayName("Test parseTableData(String[], String); when ';'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ReportGridUtilities.parseTableData(String[], String)"})
  void testParseTableData_whenSemicolon() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{"Lines"}, ";");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseTableData(String[], String)}.
   * <ul>
   *   <li>When space.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  @DisplayName("Test parseTableData(String[], String); when space")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ReportGridUtilities.parseTableData(String[], String)"})
  void testParseTableData_whenSpace() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{"Lines"}, " ");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseTableData(String[], String)}.
   * <ul>
   *   <li>When {@code Table Header}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  @DisplayName("Test parseTableData(String[], String); when 'Table Header'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ReportGridUtilities.parseTableData(String[], String)"})
  void testParseTableData_whenTableHeader() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{"Lines"},
        "Table Header");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseTableData(String[], String)}.
   * <ul>
   *   <li>When {@code | --}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseTableData(String[], String)}
   */
  @Test
  @DisplayName("Test parseTableData(String[], String); when '| --'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ReportGridUtilities.parseTableData(String[], String)"})
  void testParseTableData_whenVerticalLineSpaceDashDash() {
    // Arrange and Act
    List<List<String>> actualParseTableDataResult = ReportGridUtilities.parseTableData(new String[]{"|"}, "| --");

    // Assert
    assertTrue(actualParseTableDataResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test parseGridFilters(List, ReportGridDefinition)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReportGridUtilities.parseGridFilters(List, ReportGridDefinition)"})
  void testParseGridFilters() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("[:;*?!/\\\\]");
    stringList.add("Filter Rows");
    stringList.add("Filter Rows");

    ArrayList<List<String>> filterRows = new ArrayList<>();
    filterRows.add(stringList);
    ReportGridDefinition grid = mock(ReportGridDefinition.class);
    when(grid.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(grid.fixedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(filterRows, grid);

    // Assert
    verify(grid).derivedColumnDefinitions();
    verify(grid).fixedColumnDefinitions();
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test parseGridFilters(List, ReportGridDefinition)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReportGridUtilities.parseGridFilters(List, ReportGridDefinition)"})
  void testParseGridFilters2() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(null);
    stringList.add("Filter Rows");
    stringList.add("Filter Rows");

    ArrayList<List<String>> filterRows = new ArrayList<>();
    filterRows.add(stringList);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.gridColumnId()).thenThrow(new IllegalStateException("foo"));

    ArrayList<ReportGridDerivedColumnDefinition> reportGridDerivedColumnDefinitionList = new ArrayList<>();
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition);
    ReportGridDefinition grid = mock(ReportGridDefinition.class);
    when(grid.derivedColumnDefinitions()).thenReturn(reportGridDerivedColumnDefinitionList);
    when(grid.fixedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(filterRows, grid);

    // Assert
    verify(grid).derivedColumnDefinitions();
    verify(grid).fixedColumnDefinitions();
    verify(reportGridDerivedColumnDefinition).gridColumnId();
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test parseGridFilters(List, ReportGridDefinition)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReportGridUtilities.parseGridFilters(List, ReportGridDefinition)"})
  void testParseGridFilters3() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(null);
    stringList.add("Filter Rows");
    stringList.add("Filter Rows");

    ArrayList<List<String>> filterRows = new ArrayList<>();
    filterRows.add(stringList);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.gridColumnId()).thenThrow(new IllegalStateException("foo"));
    when(reportGridDerivedColumnDefinition.externalId()).thenThrow(new IllegalStateException("foo"));

    ArrayList<ReportGridDerivedColumnDefinition> reportGridDerivedColumnDefinitionList = new ArrayList<>();
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition);
    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(reportGridFixedColumnDefinition.externalId()).thenReturn(ofResult);
    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition2 = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition2.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult2 = Optional
        .of("Could not fetch grid filters, grid cannot have multiple columns with the same name");
    when(reportGridFixedColumnDefinition2.externalId()).thenReturn(ofResult2);

    ArrayList<ReportGridFixedColumnDefinition> reportGridFixedColumnDefinitionList = new ArrayList<>();
    reportGridFixedColumnDefinitionList.add(reportGridFixedColumnDefinition2);
    reportGridFixedColumnDefinitionList.add(reportGridFixedColumnDefinition);
    ReportGridDefinition grid = mock(ReportGridDefinition.class);
    when(grid.derivedColumnDefinitions()).thenReturn(reportGridDerivedColumnDefinitionList);
    when(grid.fixedColumnDefinitions()).thenReturn(reportGridFixedColumnDefinitionList);

    // Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(filterRows, grid);

    // Assert
    verify(reportGridFixedColumnDefinition2).externalId();
    verify(reportGridFixedColumnDefinition).externalId();
    verify(grid).derivedColumnDefinitions();
    verify(grid).fixedColumnDefinitions();
    verify(reportGridDerivedColumnDefinition).gridColumnId();
    verify(reportGridFixedColumnDefinition2).gridColumnId();
    verify(reportGridFixedColumnDefinition).gridColumnId();
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code Cannot find column '%s' on grid. Skipping this filter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test parseGridFilters(List, ReportGridDefinition); given ArrayList() add 'Cannot find column '%s' on grid. Skipping this filter'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReportGridUtilities.parseGridFilters(List, ReportGridDefinition)"})
  void testParseGridFilters_givenArrayListAddCannotFindColumnSOnGridSkippingThisFilter() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("Cannot find column '%s' on grid. Skipping this filter");
    stringList.add("Filter Rows");
    stringList.add("Filter Rows");

    ArrayList<List<String>> filterRows = new ArrayList<>();
    filterRows.add(stringList);
    ReportGridDefinition grid = mock(ReportGridDefinition.class);
    when(grid.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(grid.fixedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(filterRows, grid);

    // Assert
    verify(grid).derivedColumnDefinitions();
    verify(grid).fixedColumnDefinitions();
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test parseGridFilters(List, ReportGridDefinition); given ArrayList() add 'null'; when ArrayList() add ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReportGridUtilities.parseGridFilters(List, ReportGridDefinition)"})
  void testParseGridFilters_givenArrayListAddNull_whenArrayListAddArrayList() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(null);
    stringList.add("Filter Rows");
    stringList.add("Filter Rows");

    ArrayList<List<String>> filterRows = new ArrayList<>();
    filterRows.add(stringList);
    ReportGridDefinition grid = mock(ReportGridDefinition.class);
    when(grid.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(grid.fixedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(filterRows, grid);

    // Assert
    verify(grid).derivedColumnDefinitions();
    verify(grid).fixedColumnDefinitions();
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test parseGridFilters(List, ReportGridDefinition); given ArrayList() add 'null'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReportGridUtilities.parseGridFilters(List, ReportGridDefinition)"})
  void testParseGridFilters_givenArrayListAddNull_whenNull() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(null);
    stringList.add("Filter Rows");
    stringList.add("Filter Rows");

    ArrayList<List<String>> filterRows = new ArrayList<>();
    filterRows.add(stringList);

    // Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(filterRows, null);

    // Assert
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code \s+}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test parseGridFilters(List, ReportGridDefinition); given ArrayList() add '\\s+'; when ArrayList() add ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReportGridUtilities.parseGridFilters(List, ReportGridDefinition)"})
  void testParseGridFilters_givenArrayListAddS_whenArrayListAddArrayList() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("\\s+");
    stringList.add("Filter Rows");
    stringList.add("Filter Rows");

    ArrayList<List<String>> filterRows = new ArrayList<>();
    filterRows.add(stringList);
    ReportGridDefinition grid = mock(ReportGridDefinition.class);
    when(grid.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(grid.fixedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(filterRows, grid);

    // Assert
    verify(grid).derivedColumnDefinitions();
    verify(grid).fixedColumnDefinitions();
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code ;}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test parseGridFilters(List, ReportGridDefinition); given ArrayList() add ';'; when ArrayList() add ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReportGridUtilities.parseGridFilters(List, ReportGridDefinition)"})
  void testParseGridFilters_givenArrayListAddSemicolon_whenArrayListAddArrayList() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(";");
    stringList.add(null);
    stringList.add("Filter Rows");
    stringList.add("Filter Rows");

    ArrayList<List<String>> filterRows = new ArrayList<>();
    filterRows.add(stringList);
    ReportGridDefinition grid = mock(ReportGridDefinition.class);
    when(grid.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(grid.fixedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(filterRows, grid);

    // Assert
    verify(grid).derivedColumnDefinitions();
    verify(grid).fixedColumnDefinitions();
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add space.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test parseGridFilters(List, ReportGridDefinition); given ArrayList() add space; when ArrayList() add ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReportGridUtilities.parseGridFilters(List, ReportGridDefinition)"})
  void testParseGridFilters_givenArrayListAddSpace_whenArrayListAddArrayList() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(" ");
    stringList.add("Filter Rows");
    stringList.add("Filter Rows");

    ArrayList<List<String>> filterRows = new ArrayList<>();
    filterRows.add(stringList);
    ReportGridDefinition grid = mock(ReportGridDefinition.class);
    when(grid.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(grid.fixedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(filterRows, grid);

    // Assert
    verify(grid).derivedColumnDefinitions();
    verify(grid).fixedColumnDefinitions();
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test parseGridFilters(List, ReportGridDefinition); given ArrayList(); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReportGridUtilities.parseGridFilters(List, ReportGridDefinition)"})
  void testParseGridFilters_givenArrayList_whenArrayList() {
    // Arrange
    ArrayList<List<String>> filterRows = new ArrayList<>();
    ReportGridDefinition grid = mock(ReportGridDefinition.class);
    when(grid.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(grid.fixedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(filterRows, grid);

    // Assert
    verify(grid).derivedColumnDefinitions();
    verify(grid).fixedColumnDefinitions();
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test parseGridFilters(List, ReportGridDefinition); given ArrayList(); when ArrayList() add ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReportGridUtilities.parseGridFilters(List, ReportGridDefinition)"})
  void testParseGridFilters_givenArrayList_whenArrayListAddArrayList() {
    // Arrange
    ArrayList<List<String>> filterRows = new ArrayList<>();
    filterRows.add(new ArrayList<>());
    ReportGridDefinition grid = mock(ReportGridDefinition.class);
    when(grid.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(grid.fixedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(filterRows, grid);

    // Assert
    verify(grid).derivedColumnDefinitions();
    verify(grid).fixedColumnDefinitions();
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test parseGridFilters(List, ReportGridDefinition); given ArrayList(); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReportGridUtilities.parseGridFilters(List, ReportGridDefinition)"})
  void testParseGridFilters_givenArrayList_whenNull() {
    // Arrange
    ArrayList<List<String>> filterRows = new ArrayList<>();
    filterRows.add(new ArrayList<>());
    filterRows.add(new ArrayList<>());

    // Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(filterRows, null);

    // Assert
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}.
   * <ul>
   *   <li>Given {@link ReportGridDerivedColumnDefinition} {@link ExternalIdProvider#externalId()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test parseGridFilters(List, ReportGridDefinition); given ReportGridDerivedColumnDefinition externalId() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReportGridUtilities.parseGridFilters(List, ReportGridDefinition)"})
  void testParseGridFilters_givenReportGridDerivedColumnDefinitionExternalIdReturnEmpty() {
    // Arrange
    ArrayList<List<String>> filterRows = new ArrayList<>();
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(reportGridDerivedColumnDefinition.externalId()).thenReturn(ofResult);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition2 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition2.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult2 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition2.externalId()).thenReturn(ofResult2);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition3 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition3.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult3 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition3.externalId()).thenReturn(ofResult3);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition4 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition4.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult4 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition4.externalId()).thenReturn(ofResult4);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition5 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition5.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult5 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition5.externalId()).thenReturn(ofResult5);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition6 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition6.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult6 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition6.externalId()).thenReturn(ofResult6);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition7 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition7.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult7 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition7.externalId()).thenReturn(ofResult7);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition8 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition8.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult8 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition8.externalId()).thenReturn(ofResult8);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition9 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition9.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult9 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition9.externalId()).thenReturn(ofResult9);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition10 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition10.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult10 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition10.externalId()).thenReturn(ofResult10);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition11 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition11.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult11 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition11.externalId()).thenReturn(ofResult11);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition12 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition12.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult12 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition12.externalId()).thenReturn(ofResult12);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition13 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition13.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult13 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition13.externalId()).thenReturn(ofResult13);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition14 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition14.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult14 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition14.externalId()).thenReturn(ofResult14);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition15 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition15.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult15 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition15.externalId()).thenReturn(ofResult15);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition16 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition16.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult16 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition16.externalId()).thenReturn(ofResult16);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition17 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition17.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult17 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition17.externalId()).thenReturn(ofResult17);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition18 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition18.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult18 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition18.externalId()).thenReturn(ofResult18);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition19 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition19.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult19 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition19.externalId()).thenReturn(ofResult19);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition20 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition20.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult20 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition20.externalId()).thenReturn(ofResult20);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition21 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition21.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult21 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition21.externalId()).thenReturn(ofResult21);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition22 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition22.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult22 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition22.externalId()).thenReturn(ofResult22);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition23 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition23.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult23 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition23.externalId()).thenReturn(ofResult23);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition24 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition24.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult24 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition24.externalId()).thenReturn(ofResult24);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition25 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition25.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult25 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition25.externalId()).thenReturn(ofResult25);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition26 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition26.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult26 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition26.externalId()).thenReturn(ofResult26);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition27 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition27.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult27 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition27.externalId()).thenReturn(ofResult27);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition28 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition28.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult28 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition28.externalId()).thenReturn(ofResult28);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition29 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition29.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult29 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition29.externalId()).thenReturn(ofResult29);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition30 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition30.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult30 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition30.externalId()).thenReturn(ofResult30);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition31 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition31.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult31 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition31.externalId()).thenReturn(ofResult31);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition32 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition32.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult32 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition32.externalId()).thenReturn(ofResult32);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition33 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition33.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult33 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition33.externalId()).thenReturn(ofResult33);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition34 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition34.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult34 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition34.externalId()).thenReturn(ofResult34);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition35 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition35.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult35 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition35.externalId()).thenReturn(ofResult35);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition36 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition36.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult36 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition36.externalId()).thenReturn(ofResult36);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition37 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition37.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult37 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition37.externalId()).thenReturn(ofResult37);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition38 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition38.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult38 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition38.externalId()).thenReturn(ofResult38);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition39 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition39.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult39 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition39.externalId()).thenReturn(ofResult39);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition40 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition40.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult40 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition40.externalId()).thenReturn(ofResult40);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition41 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition41.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult41 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition41.externalId()).thenReturn(ofResult41);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition42 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition42.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult42 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition42.externalId()).thenReturn(ofResult42);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition43 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition43.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult43 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition43.externalId()).thenReturn(ofResult43);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition44 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition44.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult44 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition44.externalId()).thenReturn(ofResult44);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition45 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition45.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult45 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition45.externalId()).thenReturn(ofResult45);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition46 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition46.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult46 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition46.externalId()).thenReturn(ofResult46);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition47 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition47.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult47 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition47.externalId()).thenReturn(ofResult47);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition48 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition48.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult48 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition48.externalId()).thenReturn(ofResult48);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition49 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition49.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult49 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition49.externalId()).thenReturn(ofResult49);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition50 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition50.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult50 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition50.externalId()).thenReturn(ofResult50);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition51 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition51.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult51 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition51.externalId()).thenReturn(ofResult51);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition52 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition52.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult52 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition52.externalId()).thenReturn(ofResult52);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition53 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition53.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult53 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition53.externalId()).thenReturn(ofResult53);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition54 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition54.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult54 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition54.externalId()).thenReturn(ofResult54);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition55 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition55.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult55 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition55.externalId()).thenReturn(ofResult55);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition56 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition56.gridColumnId()).thenReturn(1L);
    Optional<String> emptyResult = Optional.empty();
    when(reportGridDerivedColumnDefinition56.externalId()).thenReturn(emptyResult);

    ArrayList<ReportGridDerivedColumnDefinition> reportGridDerivedColumnDefinitionList = new ArrayList<>();
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition56);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition55);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition54);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition53);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition52);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition51);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition50);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition49);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition48);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition47);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition46);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition45);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition44);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition43);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition42);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition41);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition40);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition39);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition38);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition37);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition36);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition35);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition34);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition33);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition32);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition31);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition30);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition29);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition28);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition27);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition26);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition25);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition24);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition23);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition22);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition21);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition20);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition19);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition18);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition17);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition16);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition15);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition14);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition13);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition12);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition11);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition10);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition9);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition8);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition7);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition6);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition5);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition4);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition3);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition2);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition);
    ReportGridDefinition grid = mock(ReportGridDefinition.class);
    when(grid.derivedColumnDefinitions()).thenReturn(reportGridDerivedColumnDefinitionList);
    when(grid.fixedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(filterRows, grid);

    // Assert
    verify(reportGridDerivedColumnDefinition56).externalId();
    verify(reportGridDerivedColumnDefinition55).externalId();
    verify(reportGridDerivedColumnDefinition54).externalId();
    verify(grid).derivedColumnDefinitions();
    verify(grid).fixedColumnDefinitions();
    verify(reportGridDerivedColumnDefinition56).gridColumnId();
    verify(reportGridDerivedColumnDefinition55).gridColumnId();
    verify(reportGridDerivedColumnDefinition54).gridColumnId();
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}.
   * <ul>
   *   <li>Given {@link ReportGridDerivedColumnDefinition} {@link ReportGridDerivedColumnDefinition#gridColumnId()} return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test parseGridFilters(List, ReportGridDefinition); given ReportGridDerivedColumnDefinition gridColumnId() return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReportGridUtilities.parseGridFilters(List, ReportGridDefinition)"})
  void testParseGridFilters_givenReportGridDerivedColumnDefinitionGridColumnIdReturnOne() {
    // Arrange
    ArrayList<List<String>> filterRows = new ArrayList<>();
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(reportGridDerivedColumnDefinition.externalId()).thenReturn(ofResult);

    ArrayList<ReportGridDerivedColumnDefinition> reportGridDerivedColumnDefinitionList = new ArrayList<>();
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition);
    ReportGridDefinition grid = mock(ReportGridDefinition.class);
    when(grid.derivedColumnDefinitions()).thenReturn(reportGridDerivedColumnDefinitionList);
    when(grid.fixedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(filterRows, grid);

    // Assert
    verify(reportGridDerivedColumnDefinition).externalId();
    verify(grid).derivedColumnDefinitions();
    verify(grid).fixedColumnDefinitions();
    verify(reportGridDerivedColumnDefinition).gridColumnId();
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}.
   * <ul>
   *   <li>Given {@link ReportGridDerivedColumnDefinition} {@link ReportGridDerivedColumnDefinition#gridColumnId()} return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test parseGridFilters(List, ReportGridDefinition); given ReportGridDerivedColumnDefinition gridColumnId() return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReportGridUtilities.parseGridFilters(List, ReportGridDefinition)"})
  void testParseGridFilters_givenReportGridDerivedColumnDefinitionGridColumnIdReturnOne2() {
    // Arrange
    ArrayList<List<String>> filterRows = new ArrayList<>();
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(reportGridDerivedColumnDefinition.externalId()).thenReturn(ofResult);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition2 = mock(
        ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition2.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult2 = Optional.of("foo");
    when(reportGridDerivedColumnDefinition2.externalId()).thenReturn(ofResult2);

    ArrayList<ReportGridDerivedColumnDefinition> reportGridDerivedColumnDefinitionList = new ArrayList<>();
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition2);
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition);
    ReportGridDefinition grid = mock(ReportGridDefinition.class);
    when(grid.derivedColumnDefinitions()).thenReturn(reportGridDerivedColumnDefinitionList);
    when(grid.fixedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(filterRows, grid);

    // Assert
    verify(reportGridDerivedColumnDefinition2).externalId();
    verify(reportGridDerivedColumnDefinition).externalId();
    verify(grid).derivedColumnDefinitions();
    verify(grid).fixedColumnDefinitions();
    verify(reportGridDerivedColumnDefinition2).gridColumnId();
    verify(reportGridDerivedColumnDefinition).gridColumnId();
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}.
   * <ul>
   *   <li>Then calls {@link ReportGridFixedColumnDefinition#gridColumnId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test parseGridFilters(List, ReportGridDefinition); then calls gridColumnId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReportGridUtilities.parseGridFilters(List, ReportGridDefinition)"})
  void testParseGridFilters_thenCallsGridColumnId() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(null);
    stringList.add("Filter Rows");
    stringList.add("Filter Rows");

    ArrayList<List<String>> filterRows = new ArrayList<>();
    filterRows.add(stringList);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.gridColumnId()).thenThrow(new IllegalStateException("foo"));
    when(reportGridDerivedColumnDefinition.externalId()).thenThrow(new IllegalStateException("foo"));

    ArrayList<ReportGridDerivedColumnDefinition> reportGridDerivedColumnDefinitionList = new ArrayList<>();
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition);
    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(reportGridFixedColumnDefinition.externalId()).thenReturn(ofResult);

    ArrayList<ReportGridFixedColumnDefinition> reportGridFixedColumnDefinitionList = new ArrayList<>();
    reportGridFixedColumnDefinitionList.add(reportGridFixedColumnDefinition);
    ReportGridDefinition grid = mock(ReportGridDefinition.class);
    when(grid.derivedColumnDefinitions()).thenReturn(reportGridDerivedColumnDefinitionList);
    when(grid.fixedColumnDefinitions()).thenReturn(reportGridFixedColumnDefinitionList);

    // Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(filterRows, grid);

    // Assert
    verify(reportGridFixedColumnDefinition).externalId();
    verify(grid).derivedColumnDefinitions();
    verify(grid).fixedColumnDefinitions();
    verify(reportGridDerivedColumnDefinition).gridColumnId();
    verify(reportGridFixedColumnDefinition).gridColumnId();
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}.
   * <ul>
   *   <li>Then calls {@link ReportGridFixedColumnDefinition#gridColumnId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test parseGridFilters(List, ReportGridDefinition); then calls gridColumnId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReportGridUtilities.parseGridFilters(List, ReportGridDefinition)"})
  void testParseGridFilters_thenCallsGridColumnId2() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(null);
    stringList.add("Filter Rows");
    stringList.add("Filter Rows");

    ArrayList<List<String>> filterRows = new ArrayList<>();
    filterRows.add(stringList);
    ReportGridDerivedColumnDefinition reportGridDerivedColumnDefinition = mock(ReportGridDerivedColumnDefinition.class);
    when(reportGridDerivedColumnDefinition.externalId()).thenThrow(new IllegalStateException("foo"));

    ArrayList<ReportGridDerivedColumnDefinition> reportGridDerivedColumnDefinitionList = new ArrayList<>();
    reportGridDerivedColumnDefinitionList.add(reportGridDerivedColumnDefinition);
    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(reportGridFixedColumnDefinition.externalId()).thenReturn(ofResult);
    ReportGridFixedColumnDefinition reportGridFixedColumnDefinition2 = mock(ReportGridFixedColumnDefinition.class);
    when(reportGridFixedColumnDefinition2.gridColumnId()).thenReturn(1L);
    Optional<String> ofResult2 = Optional.of("foo");
    when(reportGridFixedColumnDefinition2.externalId()).thenReturn(ofResult2);

    ArrayList<ReportGridFixedColumnDefinition> reportGridFixedColumnDefinitionList = new ArrayList<>();
    reportGridFixedColumnDefinitionList.add(reportGridFixedColumnDefinition2);
    reportGridFixedColumnDefinitionList.add(reportGridFixedColumnDefinition);
    ReportGridDefinition grid = mock(ReportGridDefinition.class);
    when(grid.derivedColumnDefinitions()).thenReturn(reportGridDerivedColumnDefinitionList);
    when(grid.fixedColumnDefinitions()).thenReturn(reportGridFixedColumnDefinitionList);

    // Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(filterRows, grid);

    // Assert
    verify(reportGridFixedColumnDefinition2).externalId();
    verify(reportGridFixedColumnDefinition).externalId();
    verify(grid).derivedColumnDefinitions();
    verify(grid).fixedColumnDefinitions();
    verify(reportGridFixedColumnDefinition2).gridColumnId();
    verify(reportGridFixedColumnDefinition).gridColumnId();
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#parseGridFilters(List, ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test parseGridFilters(List, ReportGridDefinition); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReportGridUtilities.parseGridFilters(List, ReportGridDefinition)"})
  void testParseGridFilters_whenNull() {
    // Arrange and Act
    Set<GridFilter> actualParseGridFiltersResult = ReportGridUtilities.parseGridFilters(new ArrayList<>(), null);

    // Assert
    assertTrue(actualParseGridFiltersResult.isEmpty());
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString() {
    // Arrange, Act and Assert
    assertEquals("[]", ReportGridUtilities.sanitizeString("[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString2() {
    // Arrange, Act and Assert
    assertEquals("[]", ReportGridUtilities.sanitizeString(";[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString3() {
    // Arrange, Act and Assert
    assertEquals("[]", ReportGridUtilities.sanitizeString(" [:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString4() {
    // Arrange, Act and Assert
    assertEquals("[]", ReportGridUtilities.sanitizeString("[:;*?!/\\\\];"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString5() {
    // Arrange, Act and Assert
    assertEquals("[]", ReportGridUtilities.sanitizeString("[:;*?!/\\\\] "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString6() {
    // Arrange, Act and Assert
    assertEquals("[][]", ReportGridUtilities.sanitizeString("[:;*?!/\\\\][:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString7() {
    // Arrange, Act and Assert
    assertEquals("[]|", ReportGridUtilities.sanitizeString("[:;*?!/\\\\]|"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString8() {
    // Arrange, Act and Assert
    assertEquals("[]|--", ReportGridUtilities.sanitizeString("[:;*?!/\\\\]|--"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString9() {
    // Arrange, Act and Assert
    assertEquals("|[]", ReportGridUtilities.sanitizeString("|[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString10() {
    // Arrange, Act and Assert
    assertEquals("|--[]", ReportGridUtilities.sanitizeString("|--[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString11() {
    // Arrange, Act and Assert
    assertEquals("[]", ReportGridUtilities.sanitizeString(";;[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString12() {
    // Arrange, Act and Assert
    assertEquals("[]", ReportGridUtilities.sanitizeString("; [:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString13() {
    // Arrange, Act and Assert
    assertEquals("[]", ReportGridUtilities.sanitizeString(";[:;*?!/\\\\];"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString14() {
    // Arrange, Act and Assert
    assertEquals("[]", ReportGridUtilities.sanitizeString(";[:;*?!/\\\\] "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString15() {
    // Arrange, Act and Assert
    assertEquals("[][]", ReportGridUtilities.sanitizeString(";[:;*?!/\\\\][:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString16() {
    // Arrange, Act and Assert
    assertEquals("[]|", ReportGridUtilities.sanitizeString(";[:;*?!/\\\\]|"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString17() {
    // Arrange, Act and Assert
    assertEquals("[]|--", ReportGridUtilities.sanitizeString(";[:;*?!/\\\\]|--"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString18() {
    // Arrange, Act and Assert
    assertEquals("java.util.listorg.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(";java.util.Listorg.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString19() {
    // Arrange, Act and Assert
    assertEquals("java.util.optionalorg.finos.waltz.service.report_grid.reportgridutilities", ReportGridUtilities
        .sanitizeString(";java.util.Optionalorg.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString20() {
    // Arrange, Act and Assert
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilitiesname",
        ReportGridUtilities.sanitizeString(";org.finos.waltz.service.report_grid.ReportGridUtilitiesName"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString21() {
    // Arrange, Act and Assert
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilitiesjava.util.list",
        ReportGridUtilities.sanitizeString(";org.finos.waltz.service.report_grid.ReportGridUtilitiesjava.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString22() {
    // Arrange, Act and Assert
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilitiesjava.util.optional", ReportGridUtilities
        .sanitizeString(";org.finos.waltz.service.report_grid.ReportGridUtilitiesjava.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString23() {
    // Arrange, Act and Assert
    assertEquals("|[]", ReportGridUtilities.sanitizeString(";|[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString24() {
    // Arrange, Act and Assert
    assertEquals("|--[]", ReportGridUtilities.sanitizeString(";|--[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString25() {
    // Arrange, Act and Assert
    assertEquals("[]", ReportGridUtilities.sanitizeString(" ;[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString26() {
    // Arrange, Act and Assert
    assertEquals("[]", ReportGridUtilities.sanitizeString("  [:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString27() {
    // Arrange, Act and Assert
    assertEquals("[]", ReportGridUtilities.sanitizeString(" [:;*?!/\\\\];"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString28() {
    // Arrange, Act and Assert
    assertEquals("[]", ReportGridUtilities.sanitizeString(" [:;*?!/\\\\] "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString29() {
    // Arrange, Act and Assert
    assertEquals("[][]", ReportGridUtilities.sanitizeString(" [:;*?!/\\\\][:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString30() {
    // Arrange, Act and Assert
    assertEquals("[]|", ReportGridUtilities.sanitizeString(" [:;*?!/\\\\]|"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString31() {
    // Arrange, Act and Assert
    assertEquals("[]|--", ReportGridUtilities.sanitizeString(" [:;*?!/\\\\]|--"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>Then return {@code 42org.finos.waltz.service.report_grid.reportgridutilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); then return '42org.finos.waltz.service.report_grid.reportgridutilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_thenReturn42orgFinosWaltzServiceReportGridReportgridutilities() {
    // Arrange, Act and Assert
    assertEquals("42org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(";42org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>Then return {@code java.util.listjava.util.list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); then return 'java.util.listjava.util.list'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_thenReturnJavaUtilListjavaUtilList() {
    // Arrange, Act and Assert
    assertEquals("java.util.listjava.util.list", ReportGridUtilities.sanitizeString(";java.util.Listjava.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>Then return {@code java.util.listjava.util.optional}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); then return 'java.util.listjava.util.optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_thenReturnJavaUtilListjavaUtilOptional() {
    // Arrange, Act and Assert
    assertEquals("java.util.listjava.util.optional",
        ReportGridUtilities.sanitizeString(";java.util.Listjava.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>Then return {@code java.util.optionaljava.util.list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); then return 'java.util.optionaljava.util.list'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_thenReturnJavaUtilOptionaljavaUtilList() {
    // Arrange, Act and Assert
    assertEquals("java.util.optionaljava.util.list",
        ReportGridUtilities.sanitizeString(";java.util.Optionaljava.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>Then return {@code java.util.optionaljava.util.optional}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); then return 'java.util.optionaljava.util.optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_thenReturnJavaUtilOptionaljavaUtilOptional() {
    // Arrange, Act and Assert
    assertEquals("java.util.optionaljava.util.optional",
        ReportGridUtilities.sanitizeString(";java.util.Optionaljava.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>Then return {@code org.finos.waltz.service.report_grid.reportgridutilities|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); then return 'org.finos.waltz.service.report_grid.reportgridutilities|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_thenReturnOrgFinosWaltzServiceReportGridReportgridutilities() {
    // Arrange, Act and Assert
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities|",
        ReportGridUtilities.sanitizeString(";org.finos.waltz.service.report_grid.ReportGridUtilities|"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>Then return {@code org.finos.waltz.service.report_grid.reportgridutilities|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); then return 'org.finos.waltz.service.report_grid.reportgridutilities|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_thenReturnOrgFinosWaltzServiceReportGridReportgridutilities2() {
    // Arrange, Act and Assert
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities|--",
        ReportGridUtilities.sanitizeString(";org.finos.waltz.service.report_grid.ReportGridUtilities|--"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>Then return {@code |org.finos.waltz.service.report_grid.reportgridutilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); then return '|org.finos.waltz.service.report_grid.reportgridutilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_thenReturnOrgFinosWaltzServiceReportGridReportgridutilities3() {
    // Arrange, Act and Assert
    assertEquals("|org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(";|org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>Then return {@code |--org.finos.waltz.service.report_grid.reportgridutilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); then return '|--org.finos.waltz.service.report_grid.reportgridutilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_thenReturnOrgFinosWaltzServiceReportGridReportgridutilities4() {
    // Arrange, Act and Assert
    assertEquals("|--org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(";|--org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>Then return {@code org.finos.waltz.service.report_grid.reportgridutilities42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); then return 'org.finos.waltz.service.report_grid.reportgridutilities42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_thenReturnOrgFinosWaltzServiceReportGridReportgridutilities42() {
    // Arrange, Act and Assert
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities42",
        ReportGridUtilities.sanitizeString(";org.finos.waltz.service.report_grid.ReportGridUtilities42"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>Then return {@code |--|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); then return '|--|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_thenReturnVerticalLineDashDashVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("|--|", ReportGridUtilities.sanitizeString(";|--|"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>Then return {@code |--|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); then return '|--|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_thenReturnVerticalLineDashDashVerticalLineDashDash() {
    // Arrange, Act and Assert
    assertEquals("|--|--", ReportGridUtilities.sanitizeString(";|--|--"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>Then return {@code ||}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); then return '||'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_thenReturnVerticalLineVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("||", ReportGridUtilities.sanitizeString(";||"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>Then return {@code ||--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); then return '||--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_thenReturnVerticalLineVerticalLineDashDash() {
    // Arrange, Act and Assert
    assertEquals("||--", ReportGridUtilities.sanitizeString(";||--"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;42Name}.</li>
   *   <li>Then return {@code 42name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';42Name'; then return '42name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_when42Name_thenReturn42name() {
    // Arrange, Act and Assert
    assertEquals("42name", ReportGridUtilities.sanitizeString(";42Name"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code 42\s+}.</li>
   *   <li>Then return {@code 42s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '42\\s+'; then return '42s+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_when42S_thenReturn42s() {
    // Arrange, Act and Assert
    assertEquals("42s+", ReportGridUtilities.sanitizeString("42\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;42\s+}.</li>
   *   <li>Then return {@code 42s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';42\\s+'; then return '42s+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_when42S_thenReturn42s2() {
    // Arrange, Act and Assert
    assertEquals("42s+", ReportGridUtilities.sanitizeString(";42\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", ReportGridUtilities.sanitizeString(";42"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_when42_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals("42", ReportGridUtilities.sanitizeString(" 42"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code [:;*?!/\\]42}.</li>
   *   <li>Then return {@code []42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '[:;*?!/\\\\]42'; then return '[]42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_when42_thenReturn423() {
    // Arrange, Act and Assert
    assertEquals("[]42", ReportGridUtilities.sanitizeString("[:;*?!/\\\\]42"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code 42;}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '42;'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_when42_thenReturn424() {
    // Arrange, Act and Assert
    assertEquals("42", ReportGridUtilities.sanitizeString("42;"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_when42_thenReturn425() {
    // Arrange, Act and Assert
    assertEquals("42", ReportGridUtilities.sanitizeString("42 "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code 42[:;*?!/\\]}.</li>
   *   <li>Then return {@code 42[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '42[:;*?!/\\\\]'; then return '42[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_when42_thenReturn426() {
    // Arrange, Act and Assert
    assertEquals("42[]", ReportGridUtilities.sanitizeString("42[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;;42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';;42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_when42_thenReturn427() {
    // Arrange, Act and Assert
    assertEquals("42", ReportGridUtilities.sanitizeString(";;42"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ; 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '; 42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_when42_thenReturn428() {
    // Arrange, Act and Assert
    assertEquals("42", ReportGridUtilities.sanitizeString("; 42"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;[:;*?!/\\]42}.</li>
   *   <li>Then return {@code []42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';[:;*?!/\\\\]42'; then return '[]42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_when42_thenReturn429() {
    // Arrange, Act and Assert
    assertEquals("[]42", ReportGridUtilities.sanitizeString(";[:;*?!/\\\\]42"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;42;}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';42;'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_when42_thenReturn4210() {
    // Arrange, Act and Assert
    assertEquals("42", ReportGridUtilities.sanitizeString(";42;"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_when42_thenReturn4211() {
    // Arrange, Act and Assert
    assertEquals("42", ReportGridUtilities.sanitizeString(";42 "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;42[:;*?!/\\]}.</li>
   *   <li>Then return {@code 42[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';42[:;*?!/\\\\]'; then return '42[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_when42_thenReturn4212() {
    // Arrange, Act and Assert
    assertEquals("42[]", ReportGridUtilities.sanitizeString(";42[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;42|}.</li>
   *   <li>Then return {@code 42|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';42|'; then return '42|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_when42_thenReturn4213() {
    // Arrange, Act and Assert
    assertEquals("42|", ReportGridUtilities.sanitizeString(";42|"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;42|--}.</li>
   *   <li>Then return {@code 42|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';42|--'; then return '42|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_when42_thenReturn4214() {
    // Arrange, Act and Assert
    assertEquals("42|--", ReportGridUtilities.sanitizeString(";42|--"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;|42}.</li>
   *   <li>Then return {@code |42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';|42'; then return '|42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_when42_thenReturn4215() {
    // Arrange, Act and Assert
    assertEquals("|42", ReportGridUtilities.sanitizeString(";|42"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;|--42}.</li>
   *   <li>Then return {@code |--42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';|--42'; then return '|--42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_when42_thenReturn4216() {
    // Arrange, Act and Assert
    assertEquals("|--42", ReportGridUtilities.sanitizeString(";|--42"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_when42_thenReturn4217() {
    // Arrange, Act and Assert
    assertEquals("42", ReportGridUtilities.sanitizeString(" ;42"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_when42_thenReturn4218() {
    // Arrange, Act and Assert
    assertEquals("42", ReportGridUtilities.sanitizeString("  42"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code [:;*?!/\\]42}.</li>
   *   <li>Then return {@code []42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '[:;*?!/\\\\]42'; then return '[]42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_when42_thenReturn4219() {
    // Arrange, Act and Assert
    assertEquals("[]42", ReportGridUtilities.sanitizeString(" [:;*?!/\\\\]42"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;42List}.</li>
   *   <li>Then return {@code 42java.util.list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';42java.util.List'; then return '42java.util.list'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_when42javaUtilList_thenReturn42javaUtilList() {
    // Arrange, Act and Assert
    assertEquals("42java.util.list", ReportGridUtilities.sanitizeString(";42java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;42Optional}.</li>
   *   <li>Then return {@code 42java.util.optional}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';42java.util.Optional'; then return '42java.util.optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_when42javaUtilOptional_thenReturn42javaUtilOptional() {
    // Arrange, Act and Assert
    assertEquals("42java.util.optional", ReportGridUtilities.sanitizeString(";42java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;4242}.</li>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';4242'; then return '4242'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_when4242_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242", ReportGridUtilities.sanitizeString(";4242"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When a string.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when a string; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenAString_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "org.finos.waltz.service.report_grid.reportgridutilitiesorg.finos.waltz.service.report_grid.reportgri"
            + "dutilities",
        ReportGridUtilities.sanitizeString(
            ";org.finos.waltz.service.report_grid.ReportGridUtilitiesorg.finos.waltz.service.report_grid"
                + ".ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;List42}.</li>
   *   <li>Then return {@code java.util.list42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';java.util.List42'; then return 'java.util.list42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilList42_thenReturnJavaUtilList42() {
    // Arrange, Act and Assert
    assertEquals("java.util.list42", ReportGridUtilities.sanitizeString(";java.util.List42"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;ListName}.</li>
   *   <li>Then return {@code java.util.listname}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';java.util.ListName'; then return 'java.util.listname'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilListName_thenReturnJavaUtilListname() {
    // Arrange, Act and Assert
    assertEquals("java.util.listname", ReportGridUtilities.sanitizeString(";java.util.ListName"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code List\s+}.</li>
   *   <li>Then return {@code java.util.lists+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'java.util.List\\s+'; then return 'java.util.lists+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilListS_thenReturnJavaUtilLists() {
    // Arrange, Act and Assert
    assertEquals("java.util.lists+", ReportGridUtilities.sanitizeString("java.util.List\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;List\s+}.</li>
   *   <li>Then return {@code java.util.lists+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';java.util.List\\s+'; then return 'java.util.lists+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilListS_thenReturnJavaUtilLists2() {
    // Arrange, Act and Assert
    assertEquals("java.util.lists+", ReportGridUtilities.sanitizeString(";java.util.List\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;List}.</li>
   *   <li>Then return {@code java.util.list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';java.util.List'; then return 'java.util.list'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilList_thenReturnJavaUtilList() {
    // Arrange, Act and Assert
    assertEquals("java.util.list", ReportGridUtilities.sanitizeString(";java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code List}.</li>
   *   <li>Then return {@code java.util.list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'java.util.List'; then return 'java.util.list'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilList_thenReturnJavaUtilList2() {
    // Arrange, Act and Assert
    assertEquals("java.util.list", ReportGridUtilities.sanitizeString(" java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code [:;*?!/\\]List}.</li>
   *   <li>Then return {@code []java.util.list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '[:;*?!/\\\\]java.util.List'; then return '[]java.util.list'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilList_thenReturnJavaUtilList3() {
    // Arrange, Act and Assert
    assertEquals("[]java.util.list", ReportGridUtilities.sanitizeString("[:;*?!/\\\\]java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code List;}.</li>
   *   <li>Then return {@code java.util.list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'java.util.List;'; then return 'java.util.list'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilList_thenReturnJavaUtilList4() {
    // Arrange, Act and Assert
    assertEquals("java.util.list", ReportGridUtilities.sanitizeString("java.util.List;"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code List}.</li>
   *   <li>Then return {@code java.util.list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'java.util.List'; then return 'java.util.list'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilList_thenReturnJavaUtilList5() {
    // Arrange, Act and Assert
    assertEquals("java.util.list", ReportGridUtilities.sanitizeString("java.util.List "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code List[:;*?!/\\]}.</li>
   *   <li>Then return {@code java.util.list[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'java.util.List[:;*?!/\\\\]'; then return 'java.util.list[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilList_thenReturnJavaUtilList6() {
    // Arrange, Act and Assert
    assertEquals("java.util.list[]", ReportGridUtilities.sanitizeString("java.util.List[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;;List}.</li>
   *   <li>Then return {@code java.util.list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';;java.util.List'; then return 'java.util.list'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilList_thenReturnJavaUtilList7() {
    // Arrange, Act and Assert
    assertEquals("java.util.list", ReportGridUtilities.sanitizeString(";;java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ; List}.</li>
   *   <li>Then return {@code java.util.list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '; java.util.List'; then return 'java.util.list'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilList_thenReturnJavaUtilList8() {
    // Arrange, Act and Assert
    assertEquals("java.util.list", ReportGridUtilities.sanitizeString("; java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;[:;*?!/\\]List}.</li>
   *   <li>Then return {@code []java.util.list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';[:;*?!/\\\\]java.util.List'; then return '[]java.util.list'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilList_thenReturnJavaUtilList9() {
    // Arrange, Act and Assert
    assertEquals("[]java.util.list", ReportGridUtilities.sanitizeString(";[:;*?!/\\\\]java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;List;}.</li>
   *   <li>Then return {@code java.util.list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';java.util.List;'; then return 'java.util.list'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilList_thenReturnJavaUtilList10() {
    // Arrange, Act and Assert
    assertEquals("java.util.list", ReportGridUtilities.sanitizeString(";java.util.List;"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;List}.</li>
   *   <li>Then return {@code java.util.list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';java.util.List'; then return 'java.util.list'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilList_thenReturnJavaUtilList11() {
    // Arrange, Act and Assert
    assertEquals("java.util.list", ReportGridUtilities.sanitizeString(";java.util.List "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;List[:;*?!/\\]}.</li>
   *   <li>Then return {@code java.util.list[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';java.util.List[:;*?!/\\\\]'; then return 'java.util.list[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilList_thenReturnJavaUtilList12() {
    // Arrange, Act and Assert
    assertEquals("java.util.list[]", ReportGridUtilities.sanitizeString(";java.util.List[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;List|}.</li>
   *   <li>Then return {@code java.util.list|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';java.util.List|'; then return 'java.util.list|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilList_thenReturnJavaUtilList13() {
    // Arrange, Act and Assert
    assertEquals("java.util.list|", ReportGridUtilities.sanitizeString(";java.util.List|"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;List|--}.</li>
   *   <li>Then return {@code java.util.list|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';java.util.List|--'; then return 'java.util.list|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilList_thenReturnJavaUtilList14() {
    // Arrange, Act and Assert
    assertEquals("java.util.list|--", ReportGridUtilities.sanitizeString(";java.util.List|--"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;|List}.</li>
   *   <li>Then return {@code |java.util.list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';|java.util.List'; then return '|java.util.list'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilList_thenReturnJavaUtilList15() {
    // Arrange, Act and Assert
    assertEquals("|java.util.list", ReportGridUtilities.sanitizeString(";|java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;|--List}.</li>
   *   <li>Then return {@code |--java.util.list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';|--java.util.List'; then return '|--java.util.list'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilList_thenReturnJavaUtilList16() {
    // Arrange, Act and Assert
    assertEquals("|--java.util.list", ReportGridUtilities.sanitizeString(";|--java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;List}.</li>
   *   <li>Then return {@code java.util.list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';java.util.List'; then return 'java.util.list'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilList_thenReturnJavaUtilList17() {
    // Arrange, Act and Assert
    assertEquals("java.util.list", ReportGridUtilities.sanitizeString(" ;java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code List}.</li>
   *   <li>Then return {@code java.util.list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'java.util.List'; then return 'java.util.list'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilList_thenReturnJavaUtilList18() {
    // Arrange, Act and Assert
    assertEquals("java.util.list", ReportGridUtilities.sanitizeString("  java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code [:;*?!/\\]List}.</li>
   *   <li>Then return {@code []java.util.list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '[:;*?!/\\\\]java.util.List'; then return '[]java.util.list'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilList_thenReturnJavaUtilList19() {
    // Arrange, Act and Assert
    assertEquals("[]java.util.list", ReportGridUtilities.sanitizeString(" [:;*?!/\\\\]java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code List;}.</li>
   *   <li>Then return {@code java.util.list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'java.util.List;'; then return 'java.util.list'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilList_thenReturnJavaUtilList20() {
    // Arrange, Act and Assert
    assertEquals("java.util.list", ReportGridUtilities.sanitizeString(" java.util.List;"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code List}.</li>
   *   <li>Then return {@code java.util.list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'java.util.List'; then return 'java.util.list'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilList_thenReturnJavaUtilList21() {
    // Arrange, Act and Assert
    assertEquals("java.util.list", ReportGridUtilities.sanitizeString(" java.util.List "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code List[:;*?!/\\]}.</li>
   *   <li>Then return {@code java.util.list[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'java.util.List[:;*?!/\\\\]'; then return 'java.util.list[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilList_thenReturnJavaUtilList22() {
    // Arrange, Act and Assert
    assertEquals("java.util.list[]", ReportGridUtilities.sanitizeString(" java.util.List[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;Optional42}.</li>
   *   <li>Then return {@code java.util.optional42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';java.util.Optional42'; then return 'java.util.optional42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilOptional42_thenReturnJavaUtilOptional42() {
    // Arrange, Act and Assert
    assertEquals("java.util.optional42", ReportGridUtilities.sanitizeString(";java.util.Optional42"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;OptionalName}.</li>
   *   <li>Then return {@code java.util.optionalname}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';java.util.OptionalName'; then return 'java.util.optionalname'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilOptionalName_thenReturnJavaUtilOptionalname() {
    // Arrange, Act and Assert
    assertEquals("java.util.optionalname", ReportGridUtilities.sanitizeString(";java.util.OptionalName"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code Optional\s+}.</li>
   *   <li>Then return {@code java.util.optionals+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'java.util.Optional\\s+'; then return 'java.util.optionals+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilOptionalS_thenReturnJavaUtilOptionals() {
    // Arrange, Act and Assert
    assertEquals("java.util.optionals+", ReportGridUtilities.sanitizeString("java.util.Optional\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;Optional\s+}.</li>
   *   <li>Then return {@code java.util.optionals+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';java.util.Optional\\s+'; then return 'java.util.optionals+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilOptionalS_thenReturnJavaUtilOptionals2() {
    // Arrange, Act and Assert
    assertEquals("java.util.optionals+", ReportGridUtilities.sanitizeString(";java.util.Optional\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;Optional}.</li>
   *   <li>Then return {@code java.util.optional}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';java.util.Optional'; then return 'java.util.optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilOptional_thenReturnJavaUtilOptional() {
    // Arrange, Act and Assert
    assertEquals("java.util.optional", ReportGridUtilities.sanitizeString(";java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code Optional}.</li>
   *   <li>Then return {@code java.util.optional}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'java.util.Optional'; then return 'java.util.optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilOptional_thenReturnJavaUtilOptional2() {
    // Arrange, Act and Assert
    assertEquals("java.util.optional", ReportGridUtilities.sanitizeString(" java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code [:;*?!/\\]Optional}.</li>
   *   <li>Then return {@code []java.util.optional}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '[:;*?!/\\\\]java.util.Optional'; then return '[]java.util.optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilOptional_thenReturnJavaUtilOptional3() {
    // Arrange, Act and Assert
    assertEquals("[]java.util.optional", ReportGridUtilities.sanitizeString("[:;*?!/\\\\]java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code Optional;}.</li>
   *   <li>Then return {@code java.util.optional}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'java.util.Optional;'; then return 'java.util.optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilOptional_thenReturnJavaUtilOptional4() {
    // Arrange, Act and Assert
    assertEquals("java.util.optional", ReportGridUtilities.sanitizeString("java.util.Optional;"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code Optional}.</li>
   *   <li>Then return {@code java.util.optional}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'java.util.Optional'; then return 'java.util.optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilOptional_thenReturnJavaUtilOptional5() {
    // Arrange, Act and Assert
    assertEquals("java.util.optional", ReportGridUtilities.sanitizeString("java.util.Optional "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code Optional[:;*?!/\\]}.</li>
   *   <li>Then return {@code java.util.optional[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'java.util.Optional[:;*?!/\\\\]'; then return 'java.util.optional[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilOptional_thenReturnJavaUtilOptional6() {
    // Arrange, Act and Assert
    assertEquals("java.util.optional[]", ReportGridUtilities.sanitizeString("java.util.Optional[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;;Optional}.</li>
   *   <li>Then return {@code java.util.optional}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';;java.util.Optional'; then return 'java.util.optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilOptional_thenReturnJavaUtilOptional7() {
    // Arrange, Act and Assert
    assertEquals("java.util.optional", ReportGridUtilities.sanitizeString(";;java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ; Optional}.</li>
   *   <li>Then return {@code java.util.optional}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '; java.util.Optional'; then return 'java.util.optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilOptional_thenReturnJavaUtilOptional8() {
    // Arrange, Act and Assert
    assertEquals("java.util.optional", ReportGridUtilities.sanitizeString("; java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;[:;*?!/\\]Optional}.</li>
   *   <li>Then return {@code []java.util.optional}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';[:;*?!/\\\\]java.util.Optional'; then return '[]java.util.optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilOptional_thenReturnJavaUtilOptional9() {
    // Arrange, Act and Assert
    assertEquals("[]java.util.optional", ReportGridUtilities.sanitizeString(";[:;*?!/\\\\]java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;Optional;}.</li>
   *   <li>Then return {@code java.util.optional}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';java.util.Optional;'; then return 'java.util.optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilOptional_thenReturnJavaUtilOptional10() {
    // Arrange, Act and Assert
    assertEquals("java.util.optional", ReportGridUtilities.sanitizeString(";java.util.Optional;"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;Optional}.</li>
   *   <li>Then return {@code java.util.optional}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';java.util.Optional'; then return 'java.util.optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilOptional_thenReturnJavaUtilOptional11() {
    // Arrange, Act and Assert
    assertEquals("java.util.optional", ReportGridUtilities.sanitizeString(";java.util.Optional "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;Optional[:;*?!/\\]}.</li>
   *   <li>Then return {@code java.util.optional[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';java.util.Optional[:;*?!/\\\\]'; then return 'java.util.optional[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilOptional_thenReturnJavaUtilOptional12() {
    // Arrange, Act and Assert
    assertEquals("java.util.optional[]", ReportGridUtilities.sanitizeString(";java.util.Optional[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;Optional|}.</li>
   *   <li>Then return {@code java.util.optional|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';java.util.Optional|'; then return 'java.util.optional|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilOptional_thenReturnJavaUtilOptional13() {
    // Arrange, Act and Assert
    assertEquals("java.util.optional|", ReportGridUtilities.sanitizeString(";java.util.Optional|"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;Optional|--}.</li>
   *   <li>Then return {@code java.util.optional|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';java.util.Optional|--'; then return 'java.util.optional|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilOptional_thenReturnJavaUtilOptional14() {
    // Arrange, Act and Assert
    assertEquals("java.util.optional|--", ReportGridUtilities.sanitizeString(";java.util.Optional|--"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;|Optional}.</li>
   *   <li>Then return {@code |java.util.optional}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';|java.util.Optional'; then return '|java.util.optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilOptional_thenReturnJavaUtilOptional15() {
    // Arrange, Act and Assert
    assertEquals("|java.util.optional", ReportGridUtilities.sanitizeString(";|java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;|--Optional}.</li>
   *   <li>Then return {@code |--java.util.optional}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';|--java.util.Optional'; then return '|--java.util.optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilOptional_thenReturnJavaUtilOptional16() {
    // Arrange, Act and Assert
    assertEquals("|--java.util.optional", ReportGridUtilities.sanitizeString(";|--java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;Optional}.</li>
   *   <li>Then return {@code java.util.optional}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';java.util.Optional'; then return 'java.util.optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilOptional_thenReturnJavaUtilOptional17() {
    // Arrange, Act and Assert
    assertEquals("java.util.optional", ReportGridUtilities.sanitizeString(" ;java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code Optional}.</li>
   *   <li>Then return {@code java.util.optional}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'java.util.Optional'; then return 'java.util.optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilOptional_thenReturnJavaUtilOptional18() {
    // Arrange, Act and Assert
    assertEquals("java.util.optional", ReportGridUtilities.sanitizeString("  java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code [:;*?!/\\]Optional}.</li>
   *   <li>Then return {@code []java.util.optional}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '[:;*?!/\\\\]java.util.Optional'; then return '[]java.util.optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenJavaUtilOptional_thenReturnJavaUtilOptional19() {
    // Arrange, Act and Assert
    assertEquals("[]java.util.optional", ReportGridUtilities.sanitizeString(" [:;*?!/\\\\]java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;Name42}.</li>
   *   <li>Then return {@code name42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';Name42'; then return 'name42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName42_thenReturnName42() {
    // Arrange, Act and Assert
    assertEquals("name42", ReportGridUtilities.sanitizeString(";Name42"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code Name42}.</li>
   *   <li>Then return {@code name42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'Name42'; then return 'name42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName42_thenReturnName422() {
    // Arrange, Act and Assert
    assertEquals("name42", ReportGridUtilities.sanitizeString(" Name42"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;NameName}.</li>
   *   <li>Then return {@code namename}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';NameName'; then return 'namename'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenNameName_thenReturnNamename() {
    // Arrange, Act and Assert
    assertEquals("namename", ReportGridUtilities.sanitizeString(";NameName"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code NameName}.</li>
   *   <li>Then return {@code namename}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'NameName'; then return 'namename'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenNameName_thenReturnNamename2() {
    // Arrange, Act and Assert
    assertEquals("namename", ReportGridUtilities.sanitizeString(" NameName"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code Name\s+}.</li>
   *   <li>Then return {@code names+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'Name\\s+'; then return 'names+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenNameS_thenReturnNames() {
    // Arrange, Act and Assert
    assertEquals("names+", ReportGridUtilities.sanitizeString("Name\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;Name\s+}.</li>
   *   <li>Then return {@code names+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';Name\\s+'; then return 'names+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenNameS_thenReturnNames2() {
    // Arrange, Act and Assert
    assertEquals("names+", ReportGridUtilities.sanitizeString(";Name\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code Name\s+}.</li>
   *   <li>Then return {@code names+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'Name\\s+'; then return 'names+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenNameS_thenReturnNames3() {
    // Arrange, Act and Assert
    assertEquals("names+", ReportGridUtilities.sanitizeString(" Name\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'Name'; then return 'name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName_thenReturnName() {
    // Arrange, Act and Assert
    assertEquals("name", ReportGridUtilities.sanitizeString("Name"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;Name}.</li>
   *   <li>Then return {@code name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';Name'; then return 'name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName_thenReturnName2() {
    // Arrange, Act and Assert
    assertEquals("name", ReportGridUtilities.sanitizeString(";Name"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'Name'; then return 'name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName_thenReturnName3() {
    // Arrange, Act and Assert
    assertEquals("name", ReportGridUtilities.sanitizeString(" Name"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code [:;*?!/\\]Name}.</li>
   *   <li>Then return {@code []name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '[:;*?!/\\\\]Name'; then return '[]name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName_thenReturnName4() {
    // Arrange, Act and Assert
    assertEquals("[]name", ReportGridUtilities.sanitizeString("[:;*?!/\\\\]Name"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code Name;}.</li>
   *   <li>Then return {@code name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'Name;'; then return 'name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName_thenReturnName5() {
    // Arrange, Act and Assert
    assertEquals("name", ReportGridUtilities.sanitizeString("Name;"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'Name'; then return 'name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName_thenReturnName6() {
    // Arrange, Act and Assert
    assertEquals("name", ReportGridUtilities.sanitizeString("Name "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code Name[:;*?!/\\]}.</li>
   *   <li>Then return {@code name[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'Name[:;*?!/\\\\]'; then return 'name[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName_thenReturnName7() {
    // Arrange, Act and Assert
    assertEquals("name[]", ReportGridUtilities.sanitizeString("Name[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;;Name}.</li>
   *   <li>Then return {@code name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';;Name'; then return 'name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName_thenReturnName8() {
    // Arrange, Act and Assert
    assertEquals("name", ReportGridUtilities.sanitizeString(";;Name"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ; Name}.</li>
   *   <li>Then return {@code name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '; Name'; then return 'name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName_thenReturnName9() {
    // Arrange, Act and Assert
    assertEquals("name", ReportGridUtilities.sanitizeString("; Name"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;[:;*?!/\\]Name}.</li>
   *   <li>Then return {@code []name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';[:;*?!/\\\\]Name'; then return '[]name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName_thenReturnName10() {
    // Arrange, Act and Assert
    assertEquals("[]name", ReportGridUtilities.sanitizeString(";[:;*?!/\\\\]Name"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;Name;}.</li>
   *   <li>Then return {@code name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';Name;'; then return 'name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName_thenReturnName11() {
    // Arrange, Act and Assert
    assertEquals("name", ReportGridUtilities.sanitizeString(";Name;"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;Name}.</li>
   *   <li>Then return {@code name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';Name'; then return 'name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName_thenReturnName12() {
    // Arrange, Act and Assert
    assertEquals("name", ReportGridUtilities.sanitizeString(";Name "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;Name[:;*?!/\\]}.</li>
   *   <li>Then return {@code name[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';Name[:;*?!/\\\\]'; then return 'name[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName_thenReturnName13() {
    // Arrange, Act and Assert
    assertEquals("name[]", ReportGridUtilities.sanitizeString(";Name[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;Name|}.</li>
   *   <li>Then return {@code name|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';Name|'; then return 'name|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName_thenReturnName14() {
    // Arrange, Act and Assert
    assertEquals("name|", ReportGridUtilities.sanitizeString(";Name|"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;Name|--}.</li>
   *   <li>Then return {@code name|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';Name|--'; then return 'name|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName_thenReturnName15() {
    // Arrange, Act and Assert
    assertEquals("name|--", ReportGridUtilities.sanitizeString(";Name|--"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;|Name}.</li>
   *   <li>Then return {@code |name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';|Name'; then return '|name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName_thenReturnName16() {
    // Arrange, Act and Assert
    assertEquals("|name", ReportGridUtilities.sanitizeString(";|Name"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;|--Name}.</li>
   *   <li>Then return {@code |--name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';|--Name'; then return '|--name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName_thenReturnName17() {
    // Arrange, Act and Assert
    assertEquals("|--name", ReportGridUtilities.sanitizeString(";|--Name"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;Name}.</li>
   *   <li>Then return {@code name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';Name'; then return 'name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName_thenReturnName18() {
    // Arrange, Act and Assert
    assertEquals("name", ReportGridUtilities.sanitizeString(" ;Name"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'Name'; then return 'name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName_thenReturnName19() {
    // Arrange, Act and Assert
    assertEquals("name", ReportGridUtilities.sanitizeString("  Name"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code [:;*?!/\\]Name}.</li>
   *   <li>Then return {@code []name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '[:;*?!/\\\\]Name'; then return '[]name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName_thenReturnName20() {
    // Arrange, Act and Assert
    assertEquals("[]name", ReportGridUtilities.sanitizeString(" [:;*?!/\\\\]Name"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code Name;}.</li>
   *   <li>Then return {@code name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'Name;'; then return 'name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName_thenReturnName21() {
    // Arrange, Act and Assert
    assertEquals("name", ReportGridUtilities.sanitizeString(" Name;"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'Name'; then return 'name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName_thenReturnName22() {
    // Arrange, Act and Assert
    assertEquals("name", ReportGridUtilities.sanitizeString(" Name "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code Name[:;*?!/\\]}.</li>
   *   <li>Then return {@code name[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'Name[:;*?!/\\\\]'; then return 'name[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName_thenReturnName23() {
    // Arrange, Act and Assert
    assertEquals("name[]", ReportGridUtilities.sanitizeString(" Name[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code Name|}.</li>
   *   <li>Then return {@code name|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'Name|'; then return 'name|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName_thenReturnName24() {
    // Arrange, Act and Assert
    assertEquals("name|", ReportGridUtilities.sanitizeString(" Name|"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code Name|--}.</li>
   *   <li>Then return {@code name|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'Name|--'; then return 'name|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenName_thenReturnName25() {
    // Arrange, Act and Assert
    assertEquals("name|--", ReportGridUtilities.sanitizeString(" Name|--"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;NameList}.</li>
   *   <li>Then return {@code namejava.util.list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';Namejava.util.List'; then return 'namejava.util.list'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenNamejavaUtilList_thenReturnNamejavaUtilList() {
    // Arrange, Act and Assert
    assertEquals("namejava.util.list", ReportGridUtilities.sanitizeString(";Namejava.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code NameList}.</li>
   *   <li>Then return {@code namejava.util.list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'Namejava.util.List'; then return 'namejava.util.list'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenNamejavaUtilList_thenReturnNamejavaUtilList2() {
    // Arrange, Act and Assert
    assertEquals("namejava.util.list", ReportGridUtilities.sanitizeString(" Namejava.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;NameOptional}.</li>
   *   <li>Then return {@code namejava.util.optional}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';Namejava.util.Optional'; then return 'namejava.util.optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenNamejavaUtilOptional_thenReturnNamejavaUtilOptional() {
    // Arrange, Act and Assert
    assertEquals("namejava.util.optional", ReportGridUtilities.sanitizeString(";Namejava.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code NameOptional}.</li>
   *   <li>Then return {@code namejava.util.optional}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'Namejava.util.Optional'; then return 'namejava.util.optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenNamejavaUtilOptional_thenReturnNamejavaUtilOptional2() {
    // Arrange, Act and Assert
    assertEquals("namejava.util.optional", ReportGridUtilities.sanitizeString(" Namejava.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;NameReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';Nameorg.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenNameorgFinosWaltzServiceReportGridReportGridUtilities() {
    // Arrange, Act and Assert
    assertEquals("nameorg.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(";Nameorg.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code NameReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'Nameorg.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenNameorgFinosWaltzServiceReportGridReportGridUtilities2() {
    // Arrange, Act and Assert
    assertEquals("nameorg.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(" Nameorg.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'null'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ReportGridUtilities.sanitizeString(null));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;ReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';org.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenOrgFinosWaltzServiceReportGridReportGridUtilities() {
    // Arrange, Act and Assert
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(";org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'org.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenOrgFinosWaltzServiceReportGridReportGridUtilities2() {
    // Arrange, Act and Assert
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(" org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code [:;*?!/\\]ReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '[:;*?!/\\\\]org.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenOrgFinosWaltzServiceReportGridReportGridUtilities3() {
    // Arrange, Act and Assert
    assertEquals("[]org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString("[:;*?!/\\\\]org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ReportGridUtilities;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'org.finos.waltz.service.report_grid.ReportGridUtilities;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenOrgFinosWaltzServiceReportGridReportGridUtilities4() {
    // Arrange, Act and Assert
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString("org.finos.waltz.service.report_grid.ReportGridUtilities;"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'org.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenOrgFinosWaltzServiceReportGridReportGridUtilities5() {
    // Arrange, Act and Assert
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString("org.finos.waltz.service.report_grid.ReportGridUtilities "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ReportGridUtilities[:;*?!/\\]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'org.finos.waltz.service.report_grid.ReportGridUtilities[:;*?!/\\\\]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenOrgFinosWaltzServiceReportGridReportGridUtilities6() {
    // Arrange, Act and Assert
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities[]",
        ReportGridUtilities.sanitizeString("org.finos.waltz.service.report_grid.ReportGridUtilities[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;;ReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';;org.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenOrgFinosWaltzServiceReportGridReportGridUtilities7() {
    // Arrange, Act and Assert
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(";;org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ; ReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '; org.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenOrgFinosWaltzServiceReportGridReportGridUtilities8() {
    // Arrange, Act and Assert
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString("; org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;[:;*?!/\\]ReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';[:;*?!/\\\\]org.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenOrgFinosWaltzServiceReportGridReportGridUtilities9() {
    // Arrange, Act and Assert
    assertEquals("[]org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(";[:;*?!/\\\\]org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;ReportGridUtilities;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';org.finos.waltz.service.report_grid.ReportGridUtilities;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenOrgFinosWaltzServiceReportGridReportGridUtilities10() {
    // Arrange, Act and Assert
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(";org.finos.waltz.service.report_grid.ReportGridUtilities;"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;ReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';org.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenOrgFinosWaltzServiceReportGridReportGridUtilities11() {
    // Arrange, Act and Assert
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(";org.finos.waltz.service.report_grid.ReportGridUtilities "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;ReportGridUtilities[:;*?!/\\]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';org.finos.waltz.service.report_grid.ReportGridUtilities[:;*?!/\\\\]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenOrgFinosWaltzServiceReportGridReportGridUtilities12() {
    // Arrange, Act and Assert
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities[]",
        ReportGridUtilities.sanitizeString(";org.finos.waltz.service.report_grid.ReportGridUtilities[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;ReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';org.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenOrgFinosWaltzServiceReportGridReportGridUtilities13() {
    // Arrange, Act and Assert
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(" ;org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'org.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenOrgFinosWaltzServiceReportGridReportGridUtilities14() {
    // Arrange, Act and Assert
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString("  org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code [:;*?!/\\]ReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '[:;*?!/\\\\]org.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenOrgFinosWaltzServiceReportGridReportGridUtilities15() {
    // Arrange, Act and Assert
    assertEquals("[]org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(" [:;*?!/\\\\]org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ReportGridUtilities\s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when 'org.finos.waltz.service.report_grid.ReportGridUtilities\\s+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenOrgFinosWaltzServiceReportGridReportGridUtilitiesS() {
    // Arrange, Act and Assert
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilitiess+",
        ReportGridUtilities.sanitizeString("org.finos.waltz.service.report_grid.ReportGridUtilities\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;ReportGridUtilities\s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';org.finos.waltz.service.report_grid.ReportGridUtilities\\s+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenOrgFinosWaltzServiceReportGridReportGridUtilitiesS2() {
    // Arrange, Act and Assert
    assertEquals("org.finos.waltz.service.report_grid.reportgridutilitiess+",
        ReportGridUtilities.sanitizeString(";org.finos.waltz.service.report_grid.ReportGridUtilities\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code \s+42}.</li>
   *   <li>Then return {@code s+42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '\\s+42'; then return 's+42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS42_thenReturnS42() {
    // Arrange, Act and Assert
    assertEquals("s+42", ReportGridUtilities.sanitizeString("\\s+42"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;\s+42}.</li>
   *   <li>Then return {@code s+42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';\\s+42'; then return 's+42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS42_thenReturnS422() {
    // Arrange, Act and Assert
    assertEquals("s+42", ReportGridUtilities.sanitizeString(";\\s+42"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code \s+42}.</li>
   *   <li>Then return {@code s+42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '\\s+42'; then return 's+42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS42_thenReturnS423() {
    // Arrange, Act and Assert
    assertEquals("s+42", ReportGridUtilities.sanitizeString(" \\s+42"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code \s+List}.</li>
   *   <li>Then return {@code s+java.util.list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '\\s+java.util.List'; then return 's+java.util.list'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSJavaUtilList_thenReturnSJavaUtilList() {
    // Arrange, Act and Assert
    assertEquals("s+java.util.list", ReportGridUtilities.sanitizeString("\\s+java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;\s+List}.</li>
   *   <li>Then return {@code s+java.util.list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';\\s+java.util.List'; then return 's+java.util.list'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSJavaUtilList_thenReturnSJavaUtilList2() {
    // Arrange, Act and Assert
    assertEquals("s+java.util.list", ReportGridUtilities.sanitizeString(";\\s+java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code \s+List}.</li>
   *   <li>Then return {@code s+java.util.list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '\\s+java.util.List'; then return 's+java.util.list'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSJavaUtilList_thenReturnSJavaUtilList3() {
    // Arrange, Act and Assert
    assertEquals("s+java.util.list", ReportGridUtilities.sanitizeString(" \\s+java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code \s+Optional}.</li>
   *   <li>Then return {@code s+java.util.optional}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '\\s+java.util.Optional'; then return 's+java.util.optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSJavaUtilOptional_thenReturnSJavaUtilOptional() {
    // Arrange, Act and Assert
    assertEquals("s+java.util.optional", ReportGridUtilities.sanitizeString("\\s+java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;\s+Optional}.</li>
   *   <li>Then return {@code s+java.util.optional}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';\\s+java.util.Optional'; then return 's+java.util.optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSJavaUtilOptional_thenReturnSJavaUtilOptional2() {
    // Arrange, Act and Assert
    assertEquals("s+java.util.optional", ReportGridUtilities.sanitizeString(";\\s+java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code \s+Optional}.</li>
   *   <li>Then return {@code s+java.util.optional}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '\\s+java.util.Optional'; then return 's+java.util.optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSJavaUtilOptional_thenReturnSJavaUtilOptional3() {
    // Arrange, Act and Assert
    assertEquals("s+java.util.optional", ReportGridUtilities.sanitizeString(" \\s+java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code \s+Name}.</li>
   *   <li>Then return {@code s+name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '\\s+Name'; then return 's+name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSName_thenReturnSName() {
    // Arrange, Act and Assert
    assertEquals("s+name", ReportGridUtilities.sanitizeString("\\s+Name"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;\s+Name}.</li>
   *   <li>Then return {@code s+name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';\\s+Name'; then return 's+name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSName_thenReturnSName2() {
    // Arrange, Act and Assert
    assertEquals("s+name", ReportGridUtilities.sanitizeString(";\\s+Name"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code \s+Name}.</li>
   *   <li>Then return {@code s+name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '\\s+Name'; then return 's+name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSName_thenReturnSName3() {
    // Arrange, Act and Assert
    assertEquals("s+name", ReportGridUtilities.sanitizeString(" \\s+Name"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code \s+ReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '\\s+org.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSOrgFinosWaltzServiceReportGridReportGridUtilities() {
    // Arrange, Act and Assert
    assertEquals("s+org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString("\\s+org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;\s+ReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';\\s+org.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSOrgFinosWaltzServiceReportGridReportGridUtilities2() {
    // Arrange, Act and Assert
    assertEquals("s+org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(";\\s+org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code \s+ReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '\\s+org.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSOrgFinosWaltzServiceReportGridReportGridUtilities3() {
    // Arrange, Act and Assert
    assertEquals("s+org.finos.waltz.service.report_grid.reportgridutilities",
        ReportGridUtilities.sanitizeString(" \\s+org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code \s+\s+}.</li>
   *   <li>Then return {@code s+s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '\\s+\\s+'; then return 's+s+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSS_thenReturnSS() {
    // Arrange, Act and Assert
    assertEquals("s+s+", ReportGridUtilities.sanitizeString("\\s+\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;\s+\s+}.</li>
   *   <li>Then return {@code s+s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';\\s+\\s+'; then return 's+s+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSS_thenReturnSS2() {
    // Arrange, Act and Assert
    assertEquals("s+s+", ReportGridUtilities.sanitizeString(";\\s+\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code \s+\s+}.</li>
   *   <li>Then return {@code s+s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '\\s+\\s+'; then return 's+s+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSS_thenReturnSS3() {
    // Arrange, Act and Assert
    assertEquals("s+s+", ReportGridUtilities.sanitizeString(" \\s+\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code \s+}.</li>
   *   <li>Then return {@code s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '\\s+'; then return 's+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS() {
    // Arrange, Act and Assert
    assertEquals("s+", ReportGridUtilities.sanitizeString("\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;\s+}.</li>
   *   <li>Then return {@code s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';\\s+'; then return 's+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS2() {
    // Arrange, Act and Assert
    assertEquals("s+", ReportGridUtilities.sanitizeString(";\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code \s+}.</li>
   *   <li>Then return {@code s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '\\s+'; then return 's+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS3() {
    // Arrange, Act and Assert
    assertEquals("s+", ReportGridUtilities.sanitizeString(" \\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code [:;*?!/\\]\s+}.</li>
   *   <li>Then return {@code []s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '[:;*?!/\\\\]\\s+'; then return '[]s+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS4() {
    // Arrange, Act and Assert
    assertEquals("[]s+", ReportGridUtilities.sanitizeString("[:;*?!/\\\\]\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code \s+;}.</li>
   *   <li>Then return {@code s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '\\s+;'; then return 's+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS5() {
    // Arrange, Act and Assert
    assertEquals("s+", ReportGridUtilities.sanitizeString("\\s+;"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code \s+}.</li>
   *   <li>Then return {@code s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '\\s+'; then return 's+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS6() {
    // Arrange, Act and Assert
    assertEquals("s+", ReportGridUtilities.sanitizeString("\\s+ "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code \s+[:;*?!/\\]}.</li>
   *   <li>Then return {@code s+[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '\\s+[:;*?!/\\\\]'; then return 's+[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS7() {
    // Arrange, Act and Assert
    assertEquals("s+[]", ReportGridUtilities.sanitizeString("\\s+[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code \s+|}.</li>
   *   <li>Then return {@code s+|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '\\s+|'; then return 's+|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS8() {
    // Arrange, Act and Assert
    assertEquals("s+|", ReportGridUtilities.sanitizeString("\\s+|"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code \s+|--}.</li>
   *   <li>Then return {@code s+|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '\\s+|--'; then return 's+|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS9() {
    // Arrange, Act and Assert
    assertEquals("s+|--", ReportGridUtilities.sanitizeString("\\s+|--"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code |\s+}.</li>
   *   <li>Then return {@code |s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '|\\s+'; then return '|s+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS10() {
    // Arrange, Act and Assert
    assertEquals("|s+", ReportGridUtilities.sanitizeString("|\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code |--\s+}.</li>
   *   <li>Then return {@code |--s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '|--\\s+'; then return '|--s+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS11() {
    // Arrange, Act and Assert
    assertEquals("|--s+", ReportGridUtilities.sanitizeString("|--\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;;\s+}.</li>
   *   <li>Then return {@code s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';;\\s+'; then return 's+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS12() {
    // Arrange, Act and Assert
    assertEquals("s+", ReportGridUtilities.sanitizeString(";;\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ; \s+}.</li>
   *   <li>Then return {@code s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '; \\s+'; then return 's+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS13() {
    // Arrange, Act and Assert
    assertEquals("s+", ReportGridUtilities.sanitizeString("; \\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;[:;*?!/\\]\s+}.</li>
   *   <li>Then return {@code []s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';[:;*?!/\\\\]\\s+'; then return '[]s+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS14() {
    // Arrange, Act and Assert
    assertEquals("[]s+", ReportGridUtilities.sanitizeString(";[:;*?!/\\\\]\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;\s+;}.</li>
   *   <li>Then return {@code s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';\\s+;'; then return 's+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS15() {
    // Arrange, Act and Assert
    assertEquals("s+", ReportGridUtilities.sanitizeString(";\\s+;"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;\s+}.</li>
   *   <li>Then return {@code s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';\\s+'; then return 's+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS16() {
    // Arrange, Act and Assert
    assertEquals("s+", ReportGridUtilities.sanitizeString(";\\s+ "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;\s+[:;*?!/\\]}.</li>
   *   <li>Then return {@code s+[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';\\s+[:;*?!/\\\\]'; then return 's+[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS17() {
    // Arrange, Act and Assert
    assertEquals("s+[]", ReportGridUtilities.sanitizeString(";\\s+[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;\s+|}.</li>
   *   <li>Then return {@code s+|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';\\s+|'; then return 's+|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS18() {
    // Arrange, Act and Assert
    assertEquals("s+|", ReportGridUtilities.sanitizeString(";\\s+|"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;\s+|--}.</li>
   *   <li>Then return {@code s+|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';\\s+|--'; then return 's+|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS19() {
    // Arrange, Act and Assert
    assertEquals("s+|--", ReportGridUtilities.sanitizeString(";\\s+|--"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;|\s+}.</li>
   *   <li>Then return {@code |s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';|\\s+'; then return '|s+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS20() {
    // Arrange, Act and Assert
    assertEquals("|s+", ReportGridUtilities.sanitizeString(";|\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;|--\s+}.</li>
   *   <li>Then return {@code |--s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';|--\\s+'; then return '|--s+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS21() {
    // Arrange, Act and Assert
    assertEquals("|--s+", ReportGridUtilities.sanitizeString(";|--\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;\s+}.</li>
   *   <li>Then return {@code s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';\\s+'; then return 's+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS22() {
    // Arrange, Act and Assert
    assertEquals("s+", ReportGridUtilities.sanitizeString(" ;\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code \s+}.</li>
   *   <li>Then return {@code s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '\\s+'; then return 's+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS23() {
    // Arrange, Act and Assert
    assertEquals("s+", ReportGridUtilities.sanitizeString("  \\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code [:;*?!/\\]\s+}.</li>
   *   <li>Then return {@code []s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '[:;*?!/\\\\]\\s+'; then return '[]s+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS24() {
    // Arrange, Act and Assert
    assertEquals("[]s+", ReportGridUtilities.sanitizeString(" [:;*?!/\\\\]\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code \s+;}.</li>
   *   <li>Then return {@code s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '\\s+;'; then return 's+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS25() {
    // Arrange, Act and Assert
    assertEquals("s+", ReportGridUtilities.sanitizeString(" \\s+;"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code \s+}.</li>
   *   <li>Then return {@code s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '\\s+'; then return 's+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS26() {
    // Arrange, Act and Assert
    assertEquals("s+", ReportGridUtilities.sanitizeString(" \\s+ "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code \s+[:;*?!/\\]}.</li>
   *   <li>Then return {@code s+[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '\\s+[:;*?!/\\\\]'; then return 's+[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS27() {
    // Arrange, Act and Assert
    assertEquals("s+[]", ReportGridUtilities.sanitizeString(" \\s+[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code \s+|}.</li>
   *   <li>Then return {@code s+|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '\\s+|'; then return 's+|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS28() {
    // Arrange, Act and Assert
    assertEquals("s+|", ReportGridUtilities.sanitizeString(" \\s+|"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code \s+|--}.</li>
   *   <li>Then return {@code s+|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '\\s+|--'; then return 's+|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenS_thenReturnS29() {
    // Arrange, Act and Assert
    assertEquals("s+|--", ReportGridUtilities.sanitizeString(" \\s+|--"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;;;}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';;;'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSemicolonSemicolonSemicolon_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ReportGridUtilities.sanitizeString(";;;"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;;|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';;|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSemicolonSemicolonVerticalLineDashDash() {
    // Arrange, Act and Assert
    assertEquals("|--", ReportGridUtilities.sanitizeString(";;|--"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;;|}.</li>
   *   <li>Then return {@code |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';;|'; then return '|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSemicolonSemicolonVerticalLine_thenReturnVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("|", ReportGridUtilities.sanitizeString(";;|"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;;}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';;'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSemicolonSemicolon_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ReportGridUtilities.sanitizeString(";;"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;;}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';;'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSemicolonSemicolon_thenReturnEmptyString2() {
    // Arrange, Act and Assert
    assertEquals("", ReportGridUtilities.sanitizeString(";; "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;;}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';;'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSemicolonSemicolon_thenReturnEmptyString3() {
    // Arrange, Act and Assert
    assertEquals("", ReportGridUtilities.sanitizeString(" ;;"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ; ;}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '; ;'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSemicolonSpaceSemicolon_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ReportGridUtilities.sanitizeString("; ;"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ; |--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '; |--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSemicolonSpaceVerticalLineDashDash() {
    // Arrange, Act and Assert
    assertEquals("|--", ReportGridUtilities.sanitizeString("; |--"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ; |}.</li>
   *   <li>Then return {@code |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '; |'; then return '|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSemicolonSpaceVerticalLine_thenReturnVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("|", ReportGridUtilities.sanitizeString("; |"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSemicolonVerticalLineDashDash() {
    // Arrange, Act and Assert
    assertEquals("|--", ReportGridUtilities.sanitizeString(";|--"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSemicolonVerticalLineDashDash2() {
    // Arrange, Act and Assert
    assertEquals("|--", ReportGridUtilities.sanitizeString(";|-- "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSemicolonVerticalLineDashDash3() {
    // Arrange, Act and Assert
    assertEquals("|--", ReportGridUtilities.sanitizeString(" ;|--"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;|--;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';|--;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSemicolonVerticalLineDashDashSemicolon() {
    // Arrange, Act and Assert
    assertEquals("|--", ReportGridUtilities.sanitizeString(";|--;"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;|;}.</li>
   *   <li>Then return {@code |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';|;'; then return '|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSemicolonVerticalLineSemicolon_thenReturnVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("|", ReportGridUtilities.sanitizeString(";|;"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;|}.</li>
   *   <li>Then return {@code |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';|'; then return '|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSemicolonVerticalLine_thenReturnVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("|", ReportGridUtilities.sanitizeString(";|"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;|}.</li>
   *   <li>Then return {@code |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';|'; then return '|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSemicolonVerticalLine_thenReturnVerticalLine2() {
    // Arrange, Act and Assert
    assertEquals("|", ReportGridUtilities.sanitizeString(";| "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;|}.</li>
   *   <li>Then return {@code |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';|'; then return '|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSemicolonVerticalLine_thenReturnVerticalLine3() {
    // Arrange, Act and Assert
    assertEquals("|", ReportGridUtilities.sanitizeString(" ;|"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSemicolon_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ReportGridUtilities.sanitizeString(";"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSemicolon_thenReturnEmptyString2() {
    // Arrange, Act and Assert
    assertEquals("", ReportGridUtilities.sanitizeString("; "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSemicolon_thenReturnEmptyString3() {
    // Arrange, Act and Assert
    assertEquals("", ReportGridUtilities.sanitizeString(" ;"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSemicolon_thenReturnEmptyString4() {
    // Arrange, Act and Assert
    assertEquals("", ReportGridUtilities.sanitizeString(";  "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSemicolon_thenReturnEmptyString5() {
    // Arrange, Act and Assert
    assertEquals("", ReportGridUtilities.sanitizeString(" ; "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code ;}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when ';'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSemicolon_thenReturnEmptyString6() {
    // Arrange, Act and Assert
    assertEquals("", ReportGridUtilities.sanitizeString("  ;"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When space space space.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when space space space; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSpaceSpaceSpace_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ReportGridUtilities.sanitizeString("   "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When space space.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when space space; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSpaceSpace_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ReportGridUtilities.sanitizeString("  "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When space.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when space; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenSpace_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ReportGridUtilities.sanitizeString(" "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code |--;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '|--;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenVerticalLineDashDashSemicolon() {
    // Arrange, Act and Assert
    assertEquals("|--", ReportGridUtilities.sanitizeString("|--;"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code |--}.</li>
   *   <li>Then return {@code |--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '|--'; then return '|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenVerticalLineDashDash_thenReturnVerticalLineDashDash() {
    // Arrange, Act and Assert
    assertEquals("|--", ReportGridUtilities.sanitizeString(" |--"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code |--}.</li>
   *   <li>Then return {@code |--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '|--'; then return '|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenVerticalLineDashDash_thenReturnVerticalLineDashDash2() {
    // Arrange, Act and Assert
    assertEquals("|--", ReportGridUtilities.sanitizeString("|-- "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code |--}.</li>
   *   <li>Then return {@code |--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '|--'; then return '|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenVerticalLineDashDash_thenReturnVerticalLineDashDash3() {
    // Arrange, Act and Assert
    assertEquals("|--", ReportGridUtilities.sanitizeString("  |--"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code |;}.</li>
   *   <li>Then return {@code |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '|;'; then return '|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenVerticalLineSemicolon_thenReturnVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("|", ReportGridUtilities.sanitizeString("|;"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code |}.</li>
   *   <li>Then return {@code |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '|'; then return '|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenVerticalLine_thenReturnVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("|", ReportGridUtilities.sanitizeString(" |"));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code |}.</li>
   *   <li>Then return {@code |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '|'; then return '|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenVerticalLine_thenReturnVerticalLine2() {
    // Arrange, Act and Assert
    assertEquals("|", ReportGridUtilities.sanitizeString("| "));
  }

  /**
   * Test {@link ReportGridUtilities#sanitizeString(String)}.
   * <ul>
   *   <li>When {@code |}.</li>
   *   <li>Then return {@code |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#sanitizeString(String)}
   */
  @Test
  @DisplayName("Test sanitizeString(String); when '|'; then return '|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.sanitizeString(String)"})
  void testSanitizeString_whenVerticalLine_thenReturnVerticalLine3() {
    // Arrange, Act and Assert
    assertEquals("|", ReportGridUtilities.sanitizeString("  |"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode() {
    // Arrange, Act and Assert
    assertEquals("[]", ReportGridUtilities.mkOptionCode("[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode2() {
    // Arrange, Act and Assert
    assertEquals("[]", ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode3() {
    // Arrange, Act and Assert
    assertEquals("_[]", ReportGridUtilities.mkOptionCode(" [:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode4() {
    // Arrange, Act and Assert
    assertEquals("[]", ReportGridUtilities.mkOptionCode("[:;*?!/\\\\];"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode5() {
    // Arrange, Act and Assert
    assertEquals("[]_", ReportGridUtilities.mkOptionCode("[:;*?!/\\\\] "));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode6() {
    // Arrange, Act and Assert
    assertEquals("[][]", ReportGridUtilities.mkOptionCode("[:;*?!/\\\\][:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode7() {
    // Arrange, Act and Assert
    assertEquals("[]_", ReportGridUtilities.mkOptionCode("[:;*?!/\\\\]_"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode8() {
    // Arrange, Act and Assert
    assertEquals("[]|", ReportGridUtilities.mkOptionCode("[:;*?!/\\\\]|"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode9() {
    // Arrange, Act and Assert
    assertEquals("[]|--", ReportGridUtilities.mkOptionCode("[:;*?!/\\\\]|--"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode10() {
    // Arrange, Act and Assert
    assertEquals("_[]", ReportGridUtilities.mkOptionCode("_[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode11() {
    // Arrange, Act and Assert
    assertEquals("|[]", ReportGridUtilities.mkOptionCode("|[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode12() {
    // Arrange, Act and Assert
    assertEquals("|--[]", ReportGridUtilities.mkOptionCode("|--[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode13() {
    // Arrange, Act and Assert
    assertEquals("[]", ReportGridUtilities.mkOptionCode(";;[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode14() {
    // Arrange, Act and Assert
    assertEquals("_[]", ReportGridUtilities.mkOptionCode("; [:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode15() {
    // Arrange, Act and Assert
    assertEquals("[]", ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\];"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode16() {
    // Arrange, Act and Assert
    assertEquals("[]_", ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\] "));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode17() {
    // Arrange, Act and Assert
    assertEquals("[][]", ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\][:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode18() {
    // Arrange, Act and Assert
    assertEquals("[]_", ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\]_"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode19() {
    // Arrange, Act and Assert
    assertEquals("[]|", ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\]|"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode20() {
    // Arrange, Act and Assert
    assertEquals("[]|--", ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\]|--"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode21() {
    // Arrange, Act and Assert
    assertEquals("_[]", ReportGridUtilities.mkOptionCode(";_[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode22() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.LISTORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(";java.util.Listorg.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode23() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.OPTIONALORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(";java.util.Optionalorg.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode24() {
    // Arrange, Act and Assert
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIESJAVA.UTIL.LIST",
        ReportGridUtilities.mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilitiesjava.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode25() {
    // Arrange, Act and Assert
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIESJAVA.UTIL.OPTIONAL",
        ReportGridUtilities.mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilitiesjava.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode26() {
    // Arrange, Act and Assert
    assertEquals("|[]", ReportGridUtilities.mkOptionCode(";|[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode27() {
    // Arrange, Act and Assert
    assertEquals("|--[]", ReportGridUtilities.mkOptionCode(";|--[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode28() {
    // Arrange, Act and Assert
    assertEquals("_[]", ReportGridUtilities.mkOptionCode(" ;[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>Then return {@code 42ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); then return '42ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_thenReturn42orgFinosWaltzServiceReportGridReportgridutilities() {
    // Arrange, Act and Assert
    assertEquals("42ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(";42org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>Then return {@code JAVA.UTIL.LISTJAVA.UTIL.OPTIONAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); then return 'JAVA.UTIL.LISTJAVA.UTIL.OPTIONAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_thenReturnJavaUtilListjavaUtilOptional() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.LISTJAVA.UTIL.OPTIONAL",
        ReportGridUtilities.mkOptionCode(";java.util.Listjava.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>Then return {@code JAVA.UTIL.OPTIONALJAVA.UTIL.LIST}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); then return 'JAVA.UTIL.OPTIONALJAVA.UTIL.LIST'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_thenReturnJavaUtilOptionaljavaUtilList() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.OPTIONALJAVA.UTIL.LIST",
        ReportGridUtilities.mkOptionCode(";java.util.Optionaljava.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>Then return {@code JAVA.UTIL.OPTIONALJAVA.UTIL.OPTIONAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); then return 'JAVA.UTIL.OPTIONALJAVA.UTIL.OPTIONAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_thenReturnJavaUtilOptionaljavaUtilOptional() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.OPTIONALJAVA.UTIL.OPTIONAL",
        ReportGridUtilities.mkOptionCode(";java.util.Optionaljava.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>Then return {@code NAMEORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); then return 'NAMEORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_thenReturnNameorgFinosWaltzServiceReportGridReportgridutilities() {
    // Arrange, Act and Assert
    assertEquals("NAMEORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(";Nameorg.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>Then return {@code ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); then return 'ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_thenReturnOrgFinosWaltzServiceReportGridReportgridutilities() {
    // Arrange, Act and Assert
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES_",
        ReportGridUtilities.mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilities "));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>Then return {@code ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); then return 'ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_thenReturnOrgFinosWaltzServiceReportGridReportgridutilities2() {
    // Arrange, Act and Assert
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES|",
        ReportGridUtilities.mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilities|"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>Then return {@code ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); then return 'ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_thenReturnOrgFinosWaltzServiceReportGridReportgridutilities3() {
    // Arrange, Act and Assert
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES|--",
        ReportGridUtilities.mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilities|--"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>Then return {@code |ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); then return '|ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_thenReturnOrgFinosWaltzServiceReportGridReportgridutilities4() {
    // Arrange, Act and Assert
    assertEquals("|ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(";|org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>Then return {@code |--ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); then return '|--ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_thenReturnOrgFinosWaltzServiceReportGridReportgridutilities5() {
    // Arrange, Act and Assert
    assertEquals("|--ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(";|--org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>Then return {@code ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); then return 'ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_thenReturnOrgFinosWaltzServiceReportGridReportgridutilities42() {
    // Arrange, Act and Assert
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES42",
        ReportGridUtilities.mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilities42"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>Then return {@code ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIESNAME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); then return 'ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIESNAME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_thenReturnOrgFinosWaltzServiceReportGridReportgridutilitiesname() {
    // Arrange, Act and Assert
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIESNAME",
        ReportGridUtilities.mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilitiesName"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>Then return {@code |--_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); then return '|--_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_thenReturnVerticalLineDashDashUnderscore() {
    // Arrange, Act and Assert
    assertEquals("|--_", ReportGridUtilities.mkOptionCode(";|-- "));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>Then return {@code |--|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); then return '|--|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_thenReturnVerticalLineDashDashVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("|--|", ReportGridUtilities.mkOptionCode(";|--|"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>Then return {@code |--|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); then return '|--|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_thenReturnVerticalLineDashDashVerticalLineDashDash() {
    // Arrange, Act and Assert
    assertEquals("|--|--", ReportGridUtilities.mkOptionCode(";|--|--"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>Then return {@code ||}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); then return '||'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_thenReturnVerticalLineVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("||", ReportGridUtilities.mkOptionCode(";||"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>Then return {@code ||--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); then return '||--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_thenReturnVerticalLineVerticalLineDashDash() {
    // Arrange, Act and Assert
    assertEquals("||--", ReportGridUtilities.mkOptionCode(";||--"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;42Name}.</li>
   *   <li>Then return {@code 42NAME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';42Name'; then return '42NAME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_when42Name_thenReturn42name() {
    // Arrange, Act and Assert
    assertEquals("42NAME", ReportGridUtilities.mkOptionCode(";42Name"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code 42\s+}.</li>
   *   <li>Then return {@code 42S+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '42\\s+'; then return '42S+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_when42S_thenReturn42s() {
    // Arrange, Act and Assert
    assertEquals("42S+", ReportGridUtilities.mkOptionCode("42\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;42\s+}.</li>
   *   <li>Then return {@code 42S+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';42\\s+'; then return '42S+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_when42S_thenReturn42s2() {
    // Arrange, Act and Assert
    assertEquals("42S+", ReportGridUtilities.mkOptionCode(";42\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", ReportGridUtilities.mkOptionCode(";42"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code _42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '42'; then return '_42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_when42_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals("_42", ReportGridUtilities.mkOptionCode(" 42"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code [:;*?!/\\]42}.</li>
   *   <li>Then return {@code []42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '[:;*?!/\\\\]42'; then return '[]42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_when42_thenReturn423() {
    // Arrange, Act and Assert
    assertEquals("[]42", ReportGridUtilities.mkOptionCode("[:;*?!/\\\\]42"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code 42;}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '42;'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_when42_thenReturn424() {
    // Arrange, Act and Assert
    assertEquals("42", ReportGridUtilities.mkOptionCode("42;"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '42'; then return '42_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_when42_thenReturn425() {
    // Arrange, Act and Assert
    assertEquals("42_", ReportGridUtilities.mkOptionCode("42 "));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code 42[:;*?!/\\]}.</li>
   *   <li>Then return {@code 42[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '42[:;*?!/\\\\]'; then return '42[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_when42_thenReturn426() {
    // Arrange, Act and Assert
    assertEquals("42[]", ReportGridUtilities.mkOptionCode("42[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;;42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';;42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_when42_thenReturn427() {
    // Arrange, Act and Assert
    assertEquals("42", ReportGridUtilities.mkOptionCode(";;42"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ; 42}.</li>
   *   <li>Then return {@code _42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '; 42'; then return '_42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_when42_thenReturn428() {
    // Arrange, Act and Assert
    assertEquals("_42", ReportGridUtilities.mkOptionCode("; 42"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;[:;*?!/\\]42}.</li>
   *   <li>Then return {@code []42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';[:;*?!/\\\\]42'; then return '[]42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_when42_thenReturn429() {
    // Arrange, Act and Assert
    assertEquals("[]42", ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\]42"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;_42}.</li>
   *   <li>Then return {@code _42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';_42'; then return '_42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_when42_thenReturn4210() {
    // Arrange, Act and Assert
    assertEquals("_42", ReportGridUtilities.mkOptionCode(";_42"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;42;}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';42;'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_when42_thenReturn4211() {
    // Arrange, Act and Assert
    assertEquals("42", ReportGridUtilities.mkOptionCode(";42;"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;42}.</li>
   *   <li>Then return {@code 42_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';42'; then return '42_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_when42_thenReturn4212() {
    // Arrange, Act and Assert
    assertEquals("42_", ReportGridUtilities.mkOptionCode(";42 "));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;42[:;*?!/\\]}.</li>
   *   <li>Then return {@code 42[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';42[:;*?!/\\\\]'; then return '42[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_when42_thenReturn4213() {
    // Arrange, Act and Assert
    assertEquals("42[]", ReportGridUtilities.mkOptionCode(";42[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;42_}.</li>
   *   <li>Then return {@code 42_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';42_'; then return '42_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_when42_thenReturn4214() {
    // Arrange, Act and Assert
    assertEquals("42_", ReportGridUtilities.mkOptionCode(";42_"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;42|}.</li>
   *   <li>Then return {@code 42|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';42|'; then return '42|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_when42_thenReturn4215() {
    // Arrange, Act and Assert
    assertEquals("42|", ReportGridUtilities.mkOptionCode(";42|"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;42|--}.</li>
   *   <li>Then return {@code 42|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';42|--'; then return '42|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_when42_thenReturn4216() {
    // Arrange, Act and Assert
    assertEquals("42|--", ReportGridUtilities.mkOptionCode(";42|--"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;|42}.</li>
   *   <li>Then return {@code |42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';|42'; then return '|42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_when42_thenReturn4217() {
    // Arrange, Act and Assert
    assertEquals("|42", ReportGridUtilities.mkOptionCode(";|42"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;|--42}.</li>
   *   <li>Then return {@code |--42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';|--42'; then return '|--42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_when42_thenReturn4218() {
    // Arrange, Act and Assert
    assertEquals("|--42", ReportGridUtilities.mkOptionCode(";|--42"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;42}.</li>
   *   <li>Then return {@code _42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';42'; then return '_42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_when42_thenReturn4219() {
    // Arrange, Act and Assert
    assertEquals("_42", ReportGridUtilities.mkOptionCode(" ;42"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;42List}.</li>
   *   <li>Then return {@code 42JAVA.UTIL.LIST}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';42java.util.List'; then return '42JAVA.UTIL.LIST'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_when42javaUtilList_thenReturn42javaUtilList() {
    // Arrange, Act and Assert
    assertEquals("42JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(";42java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;42Optional}.</li>
   *   <li>Then return {@code 42JAVA.UTIL.OPTIONAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';42java.util.Optional'; then return '42JAVA.UTIL.OPTIONAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_when42javaUtilOptional_thenReturn42javaUtilOptional() {
    // Arrange, Act and Assert
    assertEquals("42JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode(";42java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;4242}.</li>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';4242'; then return '4242'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_when4242_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242", ReportGridUtilities.mkOptionCode(";4242"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When a string.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when a string; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenAString_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIESORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRI"
            + "DUTILITIES",
        ReportGridUtilities
            .mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilitiesorg.finos.waltz.service.report_grid"
                + ".ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;List42}.</li>
   *   <li>Then return {@code JAVA.UTIL.LIST42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';java.util.List42'; then return 'JAVA.UTIL.LIST42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilList42_thenReturnJavaUtilList42() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.LIST42", ReportGridUtilities.mkOptionCode(";java.util.List42"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;ListName}.</li>
   *   <li>Then return {@code JAVA.UTIL.LISTNAME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';java.util.ListName'; then return 'JAVA.UTIL.LISTNAME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilListName_thenReturnJavaUtilListname() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.LISTNAME", ReportGridUtilities.mkOptionCode(";java.util.ListName"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code List\s+}.</li>
   *   <li>Then return {@code JAVA.UTIL.LISTS+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when 'java.util.List\\s+'; then return 'JAVA.UTIL.LISTS+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilListS_thenReturnJavaUtilLists() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.LISTS+", ReportGridUtilities.mkOptionCode("java.util.List\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;List\s+}.</li>
   *   <li>Then return {@code JAVA.UTIL.LISTS+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';java.util.List\\s+'; then return 'JAVA.UTIL.LISTS+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilListS_thenReturnJavaUtilLists2() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.LISTS+", ReportGridUtilities.mkOptionCode(";java.util.List\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;List}.</li>
   *   <li>Then return {@code JAVA.UTIL.LIST}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';java.util.List'; then return 'JAVA.UTIL.LIST'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilList_thenReturnJavaUtilList() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(";java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code List}.</li>
   *   <li>Then return {@code _JAVA.UTIL.LIST}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when 'java.util.List'; then return '_JAVA.UTIL.LIST'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilList_thenReturnJavaUtilList2() {
    // Arrange, Act and Assert
    assertEquals("_JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(" java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code [:;*?!/\\]List}.</li>
   *   <li>Then return {@code []JAVA.UTIL.LIST}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '[:;*?!/\\\\]java.util.List'; then return '[]JAVA.UTIL.LIST'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilList_thenReturnJavaUtilList3() {
    // Arrange, Act and Assert
    assertEquals("[]JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode("[:;*?!/\\\\]java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code List;}.</li>
   *   <li>Then return {@code JAVA.UTIL.LIST}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when 'java.util.List;'; then return 'JAVA.UTIL.LIST'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilList_thenReturnJavaUtilList4() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode("java.util.List;"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code List}.</li>
   *   <li>Then return {@code JAVA.UTIL.LIST_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when 'java.util.List'; then return 'JAVA.UTIL.LIST_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilList_thenReturnJavaUtilList5() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.LIST_", ReportGridUtilities.mkOptionCode("java.util.List "));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code List[:;*?!/\\]}.</li>
   *   <li>Then return {@code JAVA.UTIL.LIST[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when 'java.util.List[:;*?!/\\\\]'; then return 'JAVA.UTIL.LIST[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilList_thenReturnJavaUtilList6() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.LIST[]", ReportGridUtilities.mkOptionCode("java.util.List[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;;List}.</li>
   *   <li>Then return {@code JAVA.UTIL.LIST}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';;java.util.List'; then return 'JAVA.UTIL.LIST'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilList_thenReturnJavaUtilList7() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(";;java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ; List}.</li>
   *   <li>Then return {@code _JAVA.UTIL.LIST}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '; java.util.List'; then return '_JAVA.UTIL.LIST'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilList_thenReturnJavaUtilList8() {
    // Arrange, Act and Assert
    assertEquals("_JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode("; java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;[:;*?!/\\]List}.</li>
   *   <li>Then return {@code []JAVA.UTIL.LIST}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';[:;*?!/\\\\]java.util.List'; then return '[]JAVA.UTIL.LIST'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilList_thenReturnJavaUtilList9() {
    // Arrange, Act and Assert
    assertEquals("[]JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\]java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;_List}.</li>
   *   <li>Then return {@code _JAVA.UTIL.LIST}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';_java.util.List'; then return '_JAVA.UTIL.LIST'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilList_thenReturnJavaUtilList10() {
    // Arrange, Act and Assert
    assertEquals("_JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(";_java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;List;}.</li>
   *   <li>Then return {@code JAVA.UTIL.LIST}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';java.util.List;'; then return 'JAVA.UTIL.LIST'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilList_thenReturnJavaUtilList11() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(";java.util.List;"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;List}.</li>
   *   <li>Then return {@code JAVA.UTIL.LIST_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';java.util.List'; then return 'JAVA.UTIL.LIST_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilList_thenReturnJavaUtilList12() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.LIST_", ReportGridUtilities.mkOptionCode(";java.util.List "));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;List[:;*?!/\\]}.</li>
   *   <li>Then return {@code JAVA.UTIL.LIST[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';java.util.List[:;*?!/\\\\]'; then return 'JAVA.UTIL.LIST[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilList_thenReturnJavaUtilList13() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.LIST[]", ReportGridUtilities.mkOptionCode(";java.util.List[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;List_}.</li>
   *   <li>Then return {@code JAVA.UTIL.LIST_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';java.util.List_'; then return 'JAVA.UTIL.LIST_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilList_thenReturnJavaUtilList14() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.LIST_", ReportGridUtilities.mkOptionCode(";java.util.List_"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;List|}.</li>
   *   <li>Then return {@code JAVA.UTIL.LIST|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';java.util.List|'; then return 'JAVA.UTIL.LIST|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilList_thenReturnJavaUtilList15() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.LIST|", ReportGridUtilities.mkOptionCode(";java.util.List|"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;List|--}.</li>
   *   <li>Then return {@code JAVA.UTIL.LIST|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';java.util.List|--'; then return 'JAVA.UTIL.LIST|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilList_thenReturnJavaUtilList16() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.LIST|--", ReportGridUtilities.mkOptionCode(";java.util.List|--"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;|List}.</li>
   *   <li>Then return {@code |JAVA.UTIL.LIST}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';|java.util.List'; then return '|JAVA.UTIL.LIST'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilList_thenReturnJavaUtilList17() {
    // Arrange, Act and Assert
    assertEquals("|JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(";|java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;|--List}.</li>
   *   <li>Then return {@code |--JAVA.UTIL.LIST}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';|--java.util.List'; then return '|--JAVA.UTIL.LIST'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilList_thenReturnJavaUtilList18() {
    // Arrange, Act and Assert
    assertEquals("|--JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(";|--java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;List}.</li>
   *   <li>Then return {@code _JAVA.UTIL.LIST}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';java.util.List'; then return '_JAVA.UTIL.LIST'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilList_thenReturnJavaUtilList19() {
    // Arrange, Act and Assert
    assertEquals("_JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(" ;java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;ListList}.</li>
   *   <li>Then return {@code JAVA.UTIL.LISTJAVA.UTIL.LIST}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';java.util.Listjava.util.List'; then return 'JAVA.UTIL.LISTJAVA.UTIL.LIST'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilListjavaUtilList_thenReturnJavaUtilListjavaUtilList() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.LISTJAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(";java.util.Listjava.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;Optional42}.</li>
   *   <li>Then return {@code JAVA.UTIL.OPTIONAL42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';java.util.Optional42'; then return 'JAVA.UTIL.OPTIONAL42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilOptional42_thenReturnJavaUtilOptional42() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.OPTIONAL42", ReportGridUtilities.mkOptionCode(";java.util.Optional42"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;OptionalName}.</li>
   *   <li>Then return {@code JAVA.UTIL.OPTIONALNAME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';java.util.OptionalName'; then return 'JAVA.UTIL.OPTIONALNAME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilOptionalName_thenReturnJavaUtilOptionalname() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.OPTIONALNAME", ReportGridUtilities.mkOptionCode(";java.util.OptionalName"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code Optional\s+}.</li>
   *   <li>Then return {@code JAVA.UTIL.OPTIONALS+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when 'java.util.Optional\\s+'; then return 'JAVA.UTIL.OPTIONALS+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilOptionalS_thenReturnJavaUtilOptionals() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.OPTIONALS+", ReportGridUtilities.mkOptionCode("java.util.Optional\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;Optional\s+}.</li>
   *   <li>Then return {@code JAVA.UTIL.OPTIONALS+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';java.util.Optional\\s+'; then return 'JAVA.UTIL.OPTIONALS+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilOptionalS_thenReturnJavaUtilOptionals2() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.OPTIONALS+", ReportGridUtilities.mkOptionCode(";java.util.Optional\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;Optional}.</li>
   *   <li>Then return {@code JAVA.UTIL.OPTIONAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';java.util.Optional'; then return 'JAVA.UTIL.OPTIONAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilOptional_thenReturnJavaUtilOptional() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode(";java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code Optional}.</li>
   *   <li>Then return {@code _JAVA.UTIL.OPTIONAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when 'java.util.Optional'; then return '_JAVA.UTIL.OPTIONAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilOptional_thenReturnJavaUtilOptional2() {
    // Arrange, Act and Assert
    assertEquals("_JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode(" java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code [:;*?!/\\]Optional}.</li>
   *   <li>Then return {@code []JAVA.UTIL.OPTIONAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '[:;*?!/\\\\]java.util.Optional'; then return '[]JAVA.UTIL.OPTIONAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilOptional_thenReturnJavaUtilOptional3() {
    // Arrange, Act and Assert
    assertEquals("[]JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode("[:;*?!/\\\\]java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code Optional;}.</li>
   *   <li>Then return {@code JAVA.UTIL.OPTIONAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when 'java.util.Optional;'; then return 'JAVA.UTIL.OPTIONAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilOptional_thenReturnJavaUtilOptional4() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode("java.util.Optional;"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code Optional}.</li>
   *   <li>Then return {@code JAVA.UTIL.OPTIONAL_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when 'java.util.Optional'; then return 'JAVA.UTIL.OPTIONAL_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilOptional_thenReturnJavaUtilOptional5() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.OPTIONAL_", ReportGridUtilities.mkOptionCode("java.util.Optional "));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code Optional[:;*?!/\\]}.</li>
   *   <li>Then return {@code JAVA.UTIL.OPTIONAL[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when 'java.util.Optional[:;*?!/\\\\]'; then return 'JAVA.UTIL.OPTIONAL[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilOptional_thenReturnJavaUtilOptional6() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.OPTIONAL[]", ReportGridUtilities.mkOptionCode("java.util.Optional[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;;Optional}.</li>
   *   <li>Then return {@code JAVA.UTIL.OPTIONAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';;java.util.Optional'; then return 'JAVA.UTIL.OPTIONAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilOptional_thenReturnJavaUtilOptional7() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode(";;java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ; Optional}.</li>
   *   <li>Then return {@code _JAVA.UTIL.OPTIONAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '; java.util.Optional'; then return '_JAVA.UTIL.OPTIONAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilOptional_thenReturnJavaUtilOptional8() {
    // Arrange, Act and Assert
    assertEquals("_JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode("; java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;[:;*?!/\\]Optional}.</li>
   *   <li>Then return {@code []JAVA.UTIL.OPTIONAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';[:;*?!/\\\\]java.util.Optional'; then return '[]JAVA.UTIL.OPTIONAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilOptional_thenReturnJavaUtilOptional9() {
    // Arrange, Act and Assert
    assertEquals("[]JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\]java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;_Optional}.</li>
   *   <li>Then return {@code _JAVA.UTIL.OPTIONAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';_java.util.Optional'; then return '_JAVA.UTIL.OPTIONAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilOptional_thenReturnJavaUtilOptional10() {
    // Arrange, Act and Assert
    assertEquals("_JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode(";_java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;Optional;}.</li>
   *   <li>Then return {@code JAVA.UTIL.OPTIONAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';java.util.Optional;'; then return 'JAVA.UTIL.OPTIONAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilOptional_thenReturnJavaUtilOptional11() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode(";java.util.Optional;"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;Optional}.</li>
   *   <li>Then return {@code JAVA.UTIL.OPTIONAL_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';java.util.Optional'; then return 'JAVA.UTIL.OPTIONAL_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilOptional_thenReturnJavaUtilOptional12() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.OPTIONAL_", ReportGridUtilities.mkOptionCode(";java.util.Optional "));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;Optional[:;*?!/\\]}.</li>
   *   <li>Then return {@code JAVA.UTIL.OPTIONAL[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';java.util.Optional[:;*?!/\\\\]'; then return 'JAVA.UTIL.OPTIONAL[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilOptional_thenReturnJavaUtilOptional13() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.OPTIONAL[]", ReportGridUtilities.mkOptionCode(";java.util.Optional[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;Optional_}.</li>
   *   <li>Then return {@code JAVA.UTIL.OPTIONAL_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';java.util.Optional_'; then return 'JAVA.UTIL.OPTIONAL_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilOptional_thenReturnJavaUtilOptional14() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.OPTIONAL_", ReportGridUtilities.mkOptionCode(";java.util.Optional_"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;Optional|}.</li>
   *   <li>Then return {@code JAVA.UTIL.OPTIONAL|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';java.util.Optional|'; then return 'JAVA.UTIL.OPTIONAL|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilOptional_thenReturnJavaUtilOptional15() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.OPTIONAL|", ReportGridUtilities.mkOptionCode(";java.util.Optional|"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;Optional|--}.</li>
   *   <li>Then return {@code JAVA.UTIL.OPTIONAL|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';java.util.Optional|--'; then return 'JAVA.UTIL.OPTIONAL|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilOptional_thenReturnJavaUtilOptional16() {
    // Arrange, Act and Assert
    assertEquals("JAVA.UTIL.OPTIONAL|--", ReportGridUtilities.mkOptionCode(";java.util.Optional|--"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;|Optional}.</li>
   *   <li>Then return {@code |JAVA.UTIL.OPTIONAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';|java.util.Optional'; then return '|JAVA.UTIL.OPTIONAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilOptional_thenReturnJavaUtilOptional17() {
    // Arrange, Act and Assert
    assertEquals("|JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode(";|java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;|--Optional}.</li>
   *   <li>Then return {@code |--JAVA.UTIL.OPTIONAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';|--java.util.Optional'; then return '|--JAVA.UTIL.OPTIONAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilOptional_thenReturnJavaUtilOptional18() {
    // Arrange, Act and Assert
    assertEquals("|--JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode(";|--java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;Optional}.</li>
   *   <li>Then return {@code _JAVA.UTIL.OPTIONAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';java.util.Optional'; then return '_JAVA.UTIL.OPTIONAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenJavaUtilOptional_thenReturnJavaUtilOptional19() {
    // Arrange, Act and Assert
    assertEquals("_JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode(" ;java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;Name42}.</li>
   *   <li>Then return {@code NAME42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';Name42'; then return 'NAME42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenName42_thenReturnName42() {
    // Arrange, Act and Assert
    assertEquals("NAME42", ReportGridUtilities.mkOptionCode(";Name42"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;NameName}.</li>
   *   <li>Then return {@code NAMENAME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';NameName'; then return 'NAMENAME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenNameName_thenReturnNamename() {
    // Arrange, Act and Assert
    assertEquals("NAMENAME", ReportGridUtilities.mkOptionCode(";NameName"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code Name\s+}.</li>
   *   <li>Then return {@code NAMES+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when 'Name\\s+'; then return 'NAMES+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenNameS_thenReturnNames() {
    // Arrange, Act and Assert
    assertEquals("NAMES+", ReportGridUtilities.mkOptionCode("Name\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;Name\s+}.</li>
   *   <li>Then return {@code NAMES+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';Name\\s+'; then return 'NAMES+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenNameS_thenReturnNames2() {
    // Arrange, Act and Assert
    assertEquals("NAMES+", ReportGridUtilities.mkOptionCode(";Name\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code NAME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when 'Name'; then return 'NAME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenName_thenReturnName() {
    // Arrange, Act and Assert
    assertEquals("NAME", ReportGridUtilities.mkOptionCode("Name"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;Name}.</li>
   *   <li>Then return {@code NAME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';Name'; then return 'NAME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenName_thenReturnName2() {
    // Arrange, Act and Assert
    assertEquals("NAME", ReportGridUtilities.mkOptionCode(";Name"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code _NAME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when 'Name'; then return '_NAME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenName_thenReturnName3() {
    // Arrange, Act and Assert
    assertEquals("_NAME", ReportGridUtilities.mkOptionCode(" Name"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code [:;*?!/\\]Name}.</li>
   *   <li>Then return {@code []NAME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '[:;*?!/\\\\]Name'; then return '[]NAME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenName_thenReturnName4() {
    // Arrange, Act and Assert
    assertEquals("[]NAME", ReportGridUtilities.mkOptionCode("[:;*?!/\\\\]Name"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code Name;}.</li>
   *   <li>Then return {@code NAME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when 'Name;'; then return 'NAME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenName_thenReturnName5() {
    // Arrange, Act and Assert
    assertEquals("NAME", ReportGridUtilities.mkOptionCode("Name;"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code NAME_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when 'Name'; then return 'NAME_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenName_thenReturnName6() {
    // Arrange, Act and Assert
    assertEquals("NAME_", ReportGridUtilities.mkOptionCode("Name "));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code Name[:;*?!/\\]}.</li>
   *   <li>Then return {@code NAME[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when 'Name[:;*?!/\\\\]'; then return 'NAME[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenName_thenReturnName7() {
    // Arrange, Act and Assert
    assertEquals("NAME[]", ReportGridUtilities.mkOptionCode("Name[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;;Name}.</li>
   *   <li>Then return {@code NAME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';;Name'; then return 'NAME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenName_thenReturnName8() {
    // Arrange, Act and Assert
    assertEquals("NAME", ReportGridUtilities.mkOptionCode(";;Name"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ; Name}.</li>
   *   <li>Then return {@code _NAME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '; Name'; then return '_NAME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenName_thenReturnName9() {
    // Arrange, Act and Assert
    assertEquals("_NAME", ReportGridUtilities.mkOptionCode("; Name"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;[:;*?!/\\]Name}.</li>
   *   <li>Then return {@code []NAME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';[:;*?!/\\\\]Name'; then return '[]NAME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenName_thenReturnName10() {
    // Arrange, Act and Assert
    assertEquals("[]NAME", ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\]Name"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;_Name}.</li>
   *   <li>Then return {@code _NAME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';_Name'; then return '_NAME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenName_thenReturnName11() {
    // Arrange, Act and Assert
    assertEquals("_NAME", ReportGridUtilities.mkOptionCode(";_Name"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;Name;}.</li>
   *   <li>Then return {@code NAME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';Name;'; then return 'NAME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenName_thenReturnName12() {
    // Arrange, Act and Assert
    assertEquals("NAME", ReportGridUtilities.mkOptionCode(";Name;"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;Name}.</li>
   *   <li>Then return {@code NAME_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';Name'; then return 'NAME_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenName_thenReturnName13() {
    // Arrange, Act and Assert
    assertEquals("NAME_", ReportGridUtilities.mkOptionCode(";Name "));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;Name[:;*?!/\\]}.</li>
   *   <li>Then return {@code NAME[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';Name[:;*?!/\\\\]'; then return 'NAME[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenName_thenReturnName14() {
    // Arrange, Act and Assert
    assertEquals("NAME[]", ReportGridUtilities.mkOptionCode(";Name[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;Name_}.</li>
   *   <li>Then return {@code NAME_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';Name_'; then return 'NAME_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenName_thenReturnName15() {
    // Arrange, Act and Assert
    assertEquals("NAME_", ReportGridUtilities.mkOptionCode(";Name_"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;Name|}.</li>
   *   <li>Then return {@code NAME|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';Name|'; then return 'NAME|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenName_thenReturnName16() {
    // Arrange, Act and Assert
    assertEquals("NAME|", ReportGridUtilities.mkOptionCode(";Name|"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;Name|--}.</li>
   *   <li>Then return {@code NAME|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';Name|--'; then return 'NAME|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenName_thenReturnName17() {
    // Arrange, Act and Assert
    assertEquals("NAME|--", ReportGridUtilities.mkOptionCode(";Name|--"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;|Name}.</li>
   *   <li>Then return {@code |NAME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';|Name'; then return '|NAME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenName_thenReturnName18() {
    // Arrange, Act and Assert
    assertEquals("|NAME", ReportGridUtilities.mkOptionCode(";|Name"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;|--Name}.</li>
   *   <li>Then return {@code |--NAME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';|--Name'; then return '|--NAME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenName_thenReturnName19() {
    // Arrange, Act and Assert
    assertEquals("|--NAME", ReportGridUtilities.mkOptionCode(";|--Name"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;Name}.</li>
   *   <li>Then return {@code _NAME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';Name'; then return '_NAME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenName_thenReturnName20() {
    // Arrange, Act and Assert
    assertEquals("_NAME", ReportGridUtilities.mkOptionCode(" ;Name"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;NameList}.</li>
   *   <li>Then return {@code NAMEJAVA.UTIL.LIST}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';Namejava.util.List'; then return 'NAMEJAVA.UTIL.LIST'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenNamejavaUtilList_thenReturnNamejavaUtilList() {
    // Arrange, Act and Assert
    assertEquals("NAMEJAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(";Namejava.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;NameOptional}.</li>
   *   <li>Then return {@code NAMEJAVA.UTIL.OPTIONAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';Namejava.util.Optional'; then return 'NAMEJAVA.UTIL.OPTIONAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenNamejavaUtilOptional_thenReturnNamejavaUtilOptional() {
    // Arrange, Act and Assert
    assertEquals("NAMEJAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode(";Namejava.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when 'null'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ReportGridUtilities.mkOptionCode(null));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;ReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';org.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenOrgFinosWaltzServiceReportGridReportGridUtilities() {
    // Arrange, Act and Assert
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when 'org.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenOrgFinosWaltzServiceReportGridReportGridUtilities2() {
    // Arrange, Act and Assert
    assertEquals("_ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(" org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code [:;*?!/\\]ReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '[:;*?!/\\\\]org.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenOrgFinosWaltzServiceReportGridReportGridUtilities3() {
    // Arrange, Act and Assert
    assertEquals("[]ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode("[:;*?!/\\\\]org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ReportGridUtilities;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when 'org.finos.waltz.service.report_grid.ReportGridUtilities;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenOrgFinosWaltzServiceReportGridReportGridUtilities4() {
    // Arrange, Act and Assert
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode("org.finos.waltz.service.report_grid.ReportGridUtilities;"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when 'org.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenOrgFinosWaltzServiceReportGridReportGridUtilities5() {
    // Arrange, Act and Assert
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES_",
        ReportGridUtilities.mkOptionCode("org.finos.waltz.service.report_grid.ReportGridUtilities "));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ReportGridUtilities[:;*?!/\\]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when 'org.finos.waltz.service.report_grid.ReportGridUtilities[:;*?!/\\\\]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenOrgFinosWaltzServiceReportGridReportGridUtilities6() {
    // Arrange, Act and Assert
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES[]",
        ReportGridUtilities.mkOptionCode("org.finos.waltz.service.report_grid.ReportGridUtilities[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;;ReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';;org.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenOrgFinosWaltzServiceReportGridReportGridUtilities7() {
    // Arrange, Act and Assert
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(";;org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ; ReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '; org.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenOrgFinosWaltzServiceReportGridReportGridUtilities8() {
    // Arrange, Act and Assert
    assertEquals("_ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode("; org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;[:;*?!/\\]ReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';[:;*?!/\\\\]org.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenOrgFinosWaltzServiceReportGridReportGridUtilities9() {
    // Arrange, Act and Assert
    assertEquals("[]ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\]org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;_ReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';_org.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenOrgFinosWaltzServiceReportGridReportGridUtilities10() {
    // Arrange, Act and Assert
    assertEquals("_ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(";_org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;ReportGridUtilities;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';org.finos.waltz.service.report_grid.ReportGridUtilities;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenOrgFinosWaltzServiceReportGridReportGridUtilities11() {
    // Arrange, Act and Assert
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilities;"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;ReportGridUtilities[:;*?!/\\]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';org.finos.waltz.service.report_grid.ReportGridUtilities[:;*?!/\\\\]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenOrgFinosWaltzServiceReportGridReportGridUtilities12() {
    // Arrange, Act and Assert
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES[]",
        ReportGridUtilities.mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilities[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;ReportGridUtilities_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';org.finos.waltz.service.report_grid.ReportGridUtilities_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenOrgFinosWaltzServiceReportGridReportGridUtilities13() {
    // Arrange, Act and Assert
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES_",
        ReportGridUtilities.mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilities_"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;ReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';org.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenOrgFinosWaltzServiceReportGridReportGridUtilities14() {
    // Arrange, Act and Assert
    assertEquals("_ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(" ;org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ReportGridUtilities\s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when 'org.finos.waltz.service.report_grid.ReportGridUtilities\\s+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenOrgFinosWaltzServiceReportGridReportGridUtilitiesS() {
    // Arrange, Act and Assert
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIESS+",
        ReportGridUtilities.mkOptionCode("org.finos.waltz.service.report_grid.ReportGridUtilities\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;ReportGridUtilities\s+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';org.finos.waltz.service.report_grid.ReportGridUtilities\\s+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenOrgFinosWaltzServiceReportGridReportGridUtilitiesS2() {
    // Arrange, Act and Assert
    assertEquals("ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIESS+",
        ReportGridUtilities.mkOptionCode(";org.finos.waltz.service.report_grid.ReportGridUtilities\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code \s+42}.</li>
   *   <li>Then return {@code S+42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '\\s+42'; then return 'S+42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS42_thenReturnS42() {
    // Arrange, Act and Assert
    assertEquals("S+42", ReportGridUtilities.mkOptionCode("\\s+42"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;\s+42}.</li>
   *   <li>Then return {@code S+42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';\\s+42'; then return 'S+42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS42_thenReturnS422() {
    // Arrange, Act and Assert
    assertEquals("S+42", ReportGridUtilities.mkOptionCode(";\\s+42"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code \s+List}.</li>
   *   <li>Then return {@code S+JAVA.UTIL.LIST}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '\\s+java.util.List'; then return 'S+JAVA.UTIL.LIST'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSJavaUtilList_thenReturnSJavaUtilList() {
    // Arrange, Act and Assert
    assertEquals("S+JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode("\\s+java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;\s+List}.</li>
   *   <li>Then return {@code S+JAVA.UTIL.LIST}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';\\s+java.util.List'; then return 'S+JAVA.UTIL.LIST'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSJavaUtilList_thenReturnSJavaUtilList2() {
    // Arrange, Act and Assert
    assertEquals("S+JAVA.UTIL.LIST", ReportGridUtilities.mkOptionCode(";\\s+java.util.List"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code \s+Optional}.</li>
   *   <li>Then return {@code S+JAVA.UTIL.OPTIONAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '\\s+java.util.Optional'; then return 'S+JAVA.UTIL.OPTIONAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSJavaUtilOptional_thenReturnSJavaUtilOptional() {
    // Arrange, Act and Assert
    assertEquals("S+JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode("\\s+java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;\s+Optional}.</li>
   *   <li>Then return {@code S+JAVA.UTIL.OPTIONAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';\\s+java.util.Optional'; then return 'S+JAVA.UTIL.OPTIONAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSJavaUtilOptional_thenReturnSJavaUtilOptional2() {
    // Arrange, Act and Assert
    assertEquals("S+JAVA.UTIL.OPTIONAL", ReportGridUtilities.mkOptionCode(";\\s+java.util.Optional"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code \s+Name}.</li>
   *   <li>Then return {@code S+NAME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '\\s+Name'; then return 'S+NAME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSName_thenReturnSName() {
    // Arrange, Act and Assert
    assertEquals("S+NAME", ReportGridUtilities.mkOptionCode("\\s+Name"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;\s+Name}.</li>
   *   <li>Then return {@code S+NAME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';\\s+Name'; then return 'S+NAME'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSName_thenReturnSName2() {
    // Arrange, Act and Assert
    assertEquals("S+NAME", ReportGridUtilities.mkOptionCode(";\\s+Name"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code \s+ReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '\\s+org.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSOrgFinosWaltzServiceReportGridReportGridUtilities() {
    // Arrange, Act and Assert
    assertEquals("S+ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode("\\s+org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;\s+ReportGridUtilities}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';\\s+org.finos.waltz.service.report_grid.ReportGridUtilities'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSOrgFinosWaltzServiceReportGridReportGridUtilities2() {
    // Arrange, Act and Assert
    assertEquals("S+ORG.FINOS.WALTZ.SERVICE.REPORT_GRID.REPORTGRIDUTILITIES",
        ReportGridUtilities.mkOptionCode(";\\s+org.finos.waltz.service.report_grid.ReportGridUtilities"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code \s+\s+}.</li>
   *   <li>Then return {@code S+S+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '\\s+\\s+'; then return 'S+S+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSS_thenReturnSS() {
    // Arrange, Act and Assert
    assertEquals("S+S+", ReportGridUtilities.mkOptionCode("\\s+\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;\s+\s+}.</li>
   *   <li>Then return {@code S+S+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';\\s+\\s+'; then return 'S+S+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSS_thenReturnSS2() {
    // Arrange, Act and Assert
    assertEquals("S+S+", ReportGridUtilities.mkOptionCode(";\\s+\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code \s+}.</li>
   *   <li>Then return {@code S+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '\\s+'; then return 'S+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS() {
    // Arrange, Act and Assert
    assertEquals("S+", ReportGridUtilities.mkOptionCode("\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;\s+}.</li>
   *   <li>Then return {@code S+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';\\s+'; then return 'S+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS2() {
    // Arrange, Act and Assert
    assertEquals("S+", ReportGridUtilities.mkOptionCode(";\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code \s+}.</li>
   *   <li>Then return {@code _S+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '\\s+'; then return '_S+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS3() {
    // Arrange, Act and Assert
    assertEquals("_S+", ReportGridUtilities.mkOptionCode(" \\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code [:;*?!/\\]\s+}.</li>
   *   <li>Then return {@code []S+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '[:;*?!/\\\\]\\s+'; then return '[]S+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS4() {
    // Arrange, Act and Assert
    assertEquals("[]S+", ReportGridUtilities.mkOptionCode("[:;*?!/\\\\]\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code \s+;}.</li>
   *   <li>Then return {@code S+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '\\s+;'; then return 'S+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS5() {
    // Arrange, Act and Assert
    assertEquals("S+", ReportGridUtilities.mkOptionCode("\\s+;"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code \s+}.</li>
   *   <li>Then return {@code S+_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '\\s+'; then return 'S+_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS6() {
    // Arrange, Act and Assert
    assertEquals("S+_", ReportGridUtilities.mkOptionCode("\\s+ "));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code \s+[:;*?!/\\]}.</li>
   *   <li>Then return {@code S+[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '\\s+[:;*?!/\\\\]'; then return 'S+[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS7() {
    // Arrange, Act and Assert
    assertEquals("S+[]", ReportGridUtilities.mkOptionCode("\\s+[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code \s+_}.</li>
   *   <li>Then return {@code S+_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '\\s+_'; then return 'S+_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS8() {
    // Arrange, Act and Assert
    assertEquals("S+_", ReportGridUtilities.mkOptionCode("\\s+_"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code \s+|}.</li>
   *   <li>Then return {@code S+|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '\\s+|'; then return 'S+|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS9() {
    // Arrange, Act and Assert
    assertEquals("S+|", ReportGridUtilities.mkOptionCode("\\s+|"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code \s+|--}.</li>
   *   <li>Then return {@code S+|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '\\s+|--'; then return 'S+|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS10() {
    // Arrange, Act and Assert
    assertEquals("S+|--", ReportGridUtilities.mkOptionCode("\\s+|--"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code _\s+}.</li>
   *   <li>Then return {@code _S+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '_\\s+'; then return '_S+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS11() {
    // Arrange, Act and Assert
    assertEquals("_S+", ReportGridUtilities.mkOptionCode("_\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code |\s+}.</li>
   *   <li>Then return {@code |S+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '|\\s+'; then return '|S+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS12() {
    // Arrange, Act and Assert
    assertEquals("|S+", ReportGridUtilities.mkOptionCode("|\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code |--\s+}.</li>
   *   <li>Then return {@code |--S+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '|--\\s+'; then return '|--S+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS13() {
    // Arrange, Act and Assert
    assertEquals("|--S+", ReportGridUtilities.mkOptionCode("|--\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;;\s+}.</li>
   *   <li>Then return {@code S+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';;\\s+'; then return 'S+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS14() {
    // Arrange, Act and Assert
    assertEquals("S+", ReportGridUtilities.mkOptionCode(";;\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ; \s+}.</li>
   *   <li>Then return {@code _S+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '; \\s+'; then return '_S+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS15() {
    // Arrange, Act and Assert
    assertEquals("_S+", ReportGridUtilities.mkOptionCode("; \\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;[:;*?!/\\]\s+}.</li>
   *   <li>Then return {@code []S+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';[:;*?!/\\\\]\\s+'; then return '[]S+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS16() {
    // Arrange, Act and Assert
    assertEquals("[]S+", ReportGridUtilities.mkOptionCode(";[:;*?!/\\\\]\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;\s+;}.</li>
   *   <li>Then return {@code S+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';\\s+;'; then return 'S+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS17() {
    // Arrange, Act and Assert
    assertEquals("S+", ReportGridUtilities.mkOptionCode(";\\s+;"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;\s+}.</li>
   *   <li>Then return {@code S+_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';\\s+'; then return 'S+_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS18() {
    // Arrange, Act and Assert
    assertEquals("S+_", ReportGridUtilities.mkOptionCode(";\\s+ "));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;\s+[:;*?!/\\]}.</li>
   *   <li>Then return {@code S+[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';\\s+[:;*?!/\\\\]'; then return 'S+[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS19() {
    // Arrange, Act and Assert
    assertEquals("S+[]", ReportGridUtilities.mkOptionCode(";\\s+[:;*?!/\\\\]"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;\s+_}.</li>
   *   <li>Then return {@code S+_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';\\s+_'; then return 'S+_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS20() {
    // Arrange, Act and Assert
    assertEquals("S+_", ReportGridUtilities.mkOptionCode(";\\s+_"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;\s+|}.</li>
   *   <li>Then return {@code S+|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';\\s+|'; then return 'S+|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS21() {
    // Arrange, Act and Assert
    assertEquals("S+|", ReportGridUtilities.mkOptionCode(";\\s+|"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;\s+|--}.</li>
   *   <li>Then return {@code S+|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';\\s+|--'; then return 'S+|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS22() {
    // Arrange, Act and Assert
    assertEquals("S+|--", ReportGridUtilities.mkOptionCode(";\\s+|--"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;_\s+}.</li>
   *   <li>Then return {@code _S+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';_\\s+'; then return '_S+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS23() {
    // Arrange, Act and Assert
    assertEquals("_S+", ReportGridUtilities.mkOptionCode(";_\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;|\s+}.</li>
   *   <li>Then return {@code |S+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';|\\s+'; then return '|S+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS24() {
    // Arrange, Act and Assert
    assertEquals("|S+", ReportGridUtilities.mkOptionCode(";|\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;|--\s+}.</li>
   *   <li>Then return {@code |--S+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';|--\\s+'; then return '|--S+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS25() {
    // Arrange, Act and Assert
    assertEquals("|--S+", ReportGridUtilities.mkOptionCode(";|--\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;\s+}.</li>
   *   <li>Then return {@code _S+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';\\s+'; then return '_S+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenS_thenReturnS26() {
    // Arrange, Act and Assert
    assertEquals("_S+", ReportGridUtilities.mkOptionCode(" ;\\s+"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;;;}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';;;'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonSemicolonSemicolon_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ReportGridUtilities.mkOptionCode(";;;"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;;_}.</li>
   *   <li>Then return {@code _}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';;_'; then return '_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonSemicolonUnderscore_thenReturnUnderscore() {
    // Arrange, Act and Assert
    assertEquals("_", ReportGridUtilities.mkOptionCode(";;_"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;;|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';;|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonSemicolonVerticalLineDashDash() {
    // Arrange, Act and Assert
    assertEquals("|--", ReportGridUtilities.mkOptionCode(";;|--"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;;|}.</li>
   *   <li>Then return {@code |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';;|'; then return '|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonSemicolonVerticalLine_thenReturnVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("|", ReportGridUtilities.mkOptionCode(";;|"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;;}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';;'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonSemicolon_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ReportGridUtilities.mkOptionCode(";;"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;;}.</li>
   *   <li>Then return {@code _}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';;'; then return '_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonSemicolon_thenReturnUnderscore() {
    // Arrange, Act and Assert
    assertEquals("_", ReportGridUtilities.mkOptionCode(";; "));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;;}.</li>
   *   <li>Then return {@code _}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';;'; then return '_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonSemicolon_thenReturnUnderscore2() {
    // Arrange, Act and Assert
    assertEquals("_", ReportGridUtilities.mkOptionCode(" ;;"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ; ;}.</li>
   *   <li>Then return {@code _}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '; ;'; then return '_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonSpaceSemicolon_thenReturnUnderscore() {
    // Arrange, Act and Assert
    assertEquals("_", ReportGridUtilities.mkOptionCode("; ;"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ; _}.</li>
   *   <li>Then return {@code __}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '; _'; then return '__'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonSpaceUnderscore_thenReturnUnderscoreUnderscore() {
    // Arrange, Act and Assert
    assertEquals("__", ReportGridUtilities.mkOptionCode("; _"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ; |--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '; |--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonSpaceVerticalLineDashDash() {
    // Arrange, Act and Assert
    assertEquals("_|--", ReportGridUtilities.mkOptionCode("; |--"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ; |}.</li>
   *   <li>Then return {@code _|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '; |'; then return '_|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonSpaceVerticalLine_thenReturnUnderscoreVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("_|", ReportGridUtilities.mkOptionCode("; |"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;_;}.</li>
   *   <li>Then return {@code _}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';_;'; then return '_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonUnderscoreSemicolon_thenReturnUnderscore() {
    // Arrange, Act and Assert
    assertEquals("_", ReportGridUtilities.mkOptionCode(";_;"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;__}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';__'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonUnderscoreUnderscore() {
    // Arrange, Act and Assert
    assertEquals("__", ReportGridUtilities.mkOptionCode(";__"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;_|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';_|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonUnderscoreVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("_|", ReportGridUtilities.mkOptionCode(";_|"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;_|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';_|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonUnderscoreVerticalLineDashDash() {
    // Arrange, Act and Assert
    assertEquals("_|--", ReportGridUtilities.mkOptionCode(";_|--"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;_}.</li>
   *   <li>Then return {@code _}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';_'; then return '_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonUnderscore_thenReturnUnderscore() {
    // Arrange, Act and Assert
    assertEquals("_", ReportGridUtilities.mkOptionCode(";_"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;_}.</li>
   *   <li>Then return {@code __}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';_'; then return '__'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonUnderscore_thenReturnUnderscoreUnderscore() {
    // Arrange, Act and Assert
    assertEquals("__", ReportGridUtilities.mkOptionCode(";_ "));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;_}.</li>
   *   <li>Then return {@code __}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';_'; then return '__'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonUnderscore_thenReturnUnderscoreUnderscore2() {
    // Arrange, Act and Assert
    assertEquals("__", ReportGridUtilities.mkOptionCode(" ;_"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonVerticalLineDashDash() {
    // Arrange, Act and Assert
    assertEquals("|--", ReportGridUtilities.mkOptionCode(";|--"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;|--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonVerticalLineDashDash2() {
    // Arrange, Act and Assert
    assertEquals("_|--", ReportGridUtilities.mkOptionCode(" ;|--"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;|--;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';|--;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonVerticalLineDashDashSemicolon() {
    // Arrange, Act and Assert
    assertEquals("|--", ReportGridUtilities.mkOptionCode(";|--;"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;|--_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';|--_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonVerticalLineDashDashUnderscore() {
    // Arrange, Act and Assert
    assertEquals("|--_", ReportGridUtilities.mkOptionCode(";|--_"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;|;}.</li>
   *   <li>Then return {@code |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';|;'; then return '|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonVerticalLineSemicolon_thenReturnVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("|", ReportGridUtilities.mkOptionCode(";|;"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;|_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';|_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonVerticalLineUnderscore() {
    // Arrange, Act and Assert
    assertEquals("|_", ReportGridUtilities.mkOptionCode(";|_"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;|}.</li>
   *   <li>Then return {@code _|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';|'; then return '_|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonVerticalLine_thenReturnUnderscoreVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("_|", ReportGridUtilities.mkOptionCode(" ;|"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;|}.</li>
   *   <li>Then return {@code |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';|'; then return '|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonVerticalLine_thenReturnVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("|", ReportGridUtilities.mkOptionCode(";|"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;|}.</li>
   *   <li>Then return {@code |_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';|'; then return '|_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolonVerticalLine_thenReturnVerticalLineUnderscore() {
    // Arrange, Act and Assert
    assertEquals("|_", ReportGridUtilities.mkOptionCode(";| "));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolon_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ReportGridUtilities.mkOptionCode(";"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;}.</li>
   *   <li>Then return {@code _}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';'; then return '_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolon_thenReturnUnderscore() {
    // Arrange, Act and Assert
    assertEquals("_", ReportGridUtilities.mkOptionCode("; "));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;}.</li>
   *   <li>Then return {@code _}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';'; then return '_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolon_thenReturnUnderscore2() {
    // Arrange, Act and Assert
    assertEquals("_", ReportGridUtilities.mkOptionCode(" ;"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;}.</li>
   *   <li>Then return {@code _}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';'; then return '_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolon_thenReturnUnderscore3() {
    // Arrange, Act and Assert
    assertEquals("_", ReportGridUtilities.mkOptionCode(";  "));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code ;}.</li>
   *   <li>Then return {@code _}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when ';'; then return '_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSemicolon_thenReturnUnderscore4() {
    // Arrange, Act and Assert
    assertEquals("_", ReportGridUtilities.mkOptionCode(" ; "));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When space space.</li>
   *   <li>Then return {@code _}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when space space; then return '_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSpaceSpace_thenReturnUnderscore() {
    // Arrange, Act and Assert
    assertEquals("_", ReportGridUtilities.mkOptionCode("  "));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When space.</li>
   *   <li>Then return {@code _}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when space; then return '_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenSpace_thenReturnUnderscore() {
    // Arrange, Act and Assert
    assertEquals("_", ReportGridUtilities.mkOptionCode(" "));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code _;}.</li>
   *   <li>Then return {@code _}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '_;'; then return '_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenUnderscoreSemicolon_thenReturnUnderscore() {
    // Arrange, Act and Assert
    assertEquals("_", ReportGridUtilities.mkOptionCode("_;"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code _}.</li>
   *   <li>Then return {@code __}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '_'; then return '__'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenUnderscore_thenReturnUnderscoreUnderscore() {
    // Arrange, Act and Assert
    assertEquals("__", ReportGridUtilities.mkOptionCode(" _"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code _}.</li>
   *   <li>Then return {@code __}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '_'; then return '__'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenUnderscore_thenReturnUnderscoreUnderscore2() {
    // Arrange, Act and Assert
    assertEquals("__", ReportGridUtilities.mkOptionCode("_ "));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code |--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenVerticalLineDashDash() {
    // Arrange, Act and Assert
    assertEquals("_|--", ReportGridUtilities.mkOptionCode(" |--"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code |--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '|--'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenVerticalLineDashDash2() {
    // Arrange, Act and Assert
    assertEquals("|--_", ReportGridUtilities.mkOptionCode("|-- "));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code |--;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '|--;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenVerticalLineDashDashSemicolon() {
    // Arrange, Act and Assert
    assertEquals("|--", ReportGridUtilities.mkOptionCode("|--;"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code |;}.</li>
   *   <li>Then return {@code |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '|;'; then return '|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenVerticalLineSemicolon_thenReturnVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("|", ReportGridUtilities.mkOptionCode("|;"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code |}.</li>
   *   <li>Then return {@code _|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '|'; then return '_|'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenVerticalLine_thenReturnUnderscoreVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("_|", ReportGridUtilities.mkOptionCode(" |"));
  }

  /**
   * Test {@link ReportGridUtilities#mkOptionCode(String)}.
   * <ul>
   *   <li>When {@code |}.</li>
   *   <li>Then return {@code |_}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#mkOptionCode(String)}
   */
  @Test
  @DisplayName("Test mkOptionCode(String); when '|'; then return '|_'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ReportGridUtilities.mkOptionCode(String)"})
  void testMkOptionCode_whenVerticalLine_thenReturnVerticalLineUnderscore() {
    // Arrange, Act and Assert
    assertEquals("|_", ReportGridUtilities.mkOptionCode("| "));
  }

  /**
   * Test {@link ReportGridUtilities#modifySelectionOptionsForGrid(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#kind()} return {@code ALL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#modifySelectionOptionsForGrid(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test modifySelectionOptionsForGrid(IdSelectionOptions); given EntityReference kind() return 'ALL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IdSelectionOptions ReportGridUtilities.modifySelectionOptionsForGrid(IdSelectionOptions)"})
  void testModifySelectionOptionsForGrid_givenEntityReferenceKindReturnAll() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    ReportGridUtilities.modifySelectionOptionsForGrid(idSelectionOptions);

    // Assert
    verify(entityReference).kind();
    verify(idSelectionOptions).entityReference();
  }

  /**
   * Test {@link ReportGridUtilities#modifySelectionOptionsForGrid(IdSelectionOptions)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridUtilities#modifySelectionOptionsForGrid(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test modifySelectionOptionsForGrid(IdSelectionOptions); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IdSelectionOptions ReportGridUtilities.modifySelectionOptionsForGrid(IdSelectionOptions)"})
  void testModifySelectionOptionsForGrid_thenThrowIllegalStateException() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenThrow(new IllegalStateException("foo"));
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> ReportGridUtilities.modifySelectionOptionsForGrid(idSelectionOptions));
    verify(entityReference).kind();
    verify(idSelectionOptions).entityReference();
  }
}
