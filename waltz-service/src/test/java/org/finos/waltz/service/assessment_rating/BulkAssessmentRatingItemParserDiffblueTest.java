package org.finos.waltz.service.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.assessment_rating.bulk_upload.AssessmentRatingParsedResult;
import org.finos.waltz.model.assessment_rating.bulk_upload.AssessmentRatingParsedResult.AssessmentRatingParseError;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmentRatingParseError;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmentRatingParsedResult;
import org.finos.waltz.service.assessment_rating.BulkAssessmentRatingItemParser.InputFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BulkAssessmentRatingItemParserDiffblueTest {
  /**
   * Test {@link BulkAssessmentRatingItemParser#parse(String, InputFormat)}.
   * <p>
   * Method under test: {@link BulkAssessmentRatingItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssessmentRatingParsedResult BulkAssessmentRatingItemParser.parse(String, InputFormat)"})
  void testParse() {
    // Arrange and Act
    AssessmentRatingParsedResult actualParseResult = (new BulkAssessmentRatingItemParser()).parse("(\n|\r|\r\n)",
        InputFormat.TSV);

    // Assert
    AssessmentRatingParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableAssessmentRatingParseError);
    assertTrue(actualParseResult instanceof ImmutableAssessmentRatingParsedResult);
    assertEquals("(\n|\r|\r\n)", actualParseResult.input());
    assertEquals(
        "Cannot construct instance of `org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmen"
            + "tRatingParsedItem`, problem: Cannot build AssessmentRatingParsedItem, some of required attributes are"
            + " not set [externalId, ratingCode]\n" + " at [Source: (StringReader); line: 2, column: 1]",
        errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
  }

  /**
   * Test {@link BulkAssessmentRatingItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When {@code Cannot parse an empty string}.</li>
   *   <li>Then return input is {@code Cannot parse an empty string}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkAssessmentRatingItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when 'Cannot parse an empty string'; then return input is 'Cannot parse an empty string'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssessmentRatingParsedResult BulkAssessmentRatingItemParser.parse(String, InputFormat)"})
  void testParse_whenCannotParseAnEmptyString_thenReturnInputIsCannotParseAnEmptyString() {
    // Arrange and Act
    AssessmentRatingParsedResult actualParseResult = (new BulkAssessmentRatingItemParser())
        .parse("Cannot parse an empty string", InputFormat.TSV);

    // Assert
    assertTrue(actualParseResult instanceof ImmutableAssessmentRatingParsedResult);
    assertEquals("Cannot parse an empty string", actualParseResult.input());
    assertNull(actualParseResult.error());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link BulkAssessmentRatingItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return input is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkAssessmentRatingItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when empty string; then return input is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssessmentRatingParsedResult BulkAssessmentRatingItemParser.parse(String, InputFormat)"})
  void testParse_whenEmptyString_thenReturnInputIsEmptyString() {
    // Arrange and Act
    AssessmentRatingParsedResult actualParseResult = (new BulkAssessmentRatingItemParser()).parse("", InputFormat.CSV);

    // Assert
    AssessmentRatingParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableAssessmentRatingParseError);
    assertTrue(actualParseResult instanceof ImmutableAssessmentRatingParsedResult);
    assertEquals("", actualParseResult.input());
    assertEquals("Cannot parse an empty string", errorResult.message());
    assertEquals(0, errorResult.column().intValue());
    assertEquals(0, errorResult.line().intValue());
  }

  /**
   * Test {@link BulkAssessmentRatingItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When {@code Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkAssessmentRatingItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when 'Input'; then return 'Input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssessmentRatingParsedResult BulkAssessmentRatingItemParser.parse(String, InputFormat)"})
  void testParse_whenInput_thenReturnInput() {
    // Arrange and Act
    AssessmentRatingParsedResult actualParseResult = (new BulkAssessmentRatingItemParser()).parse("Input",
        InputFormat.TSV);

    // Assert
    assertTrue(actualParseResult instanceof ImmutableAssessmentRatingParsedResult);
    assertEquals("Input", actualParseResult.input());
    assertNull(actualParseResult.error());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link BulkAssessmentRatingItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When {@code Input}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkAssessmentRatingItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when 'Input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssessmentRatingParsedResult BulkAssessmentRatingItemParser.parse(String, InputFormat)"})
  void testParse_whenInput_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new BulkAssessmentRatingItemParser()).parse("Input", InputFormat.CSV));
  }

  /**
   * Test {@link BulkAssessmentRatingItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return input is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkAssessmentRatingItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when 'null'; then return input is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssessmentRatingParsedResult BulkAssessmentRatingItemParser.parse(String, InputFormat)"})
  void testParse_whenNull_thenReturnInputIsNull() {
    // Arrange and Act
    AssessmentRatingParsedResult actualParseResult = (new BulkAssessmentRatingItemParser()).parse(null,
        InputFormat.TSV);

    // Assert
    AssessmentRatingParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableAssessmentRatingParseError);
    assertTrue(actualParseResult instanceof ImmutableAssessmentRatingParsedResult);
    assertEquals("Cannot parse an empty string", errorResult.message());
    assertNull(actualParseResult.input());
    assertEquals(0, errorResult.column().intValue());
    assertEquals(0, errorResult.line().intValue());
  }

  /**
   * Test {@link BulkAssessmentRatingItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When {@code #}.</li>
   *   <li>Then return input is {@code #}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkAssessmentRatingItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when '#'; then return input is '#'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssessmentRatingParsedResult BulkAssessmentRatingItemParser.parse(String, InputFormat)"})
  void testParse_whenNumberSign_thenReturnInputIsNumberSign() {
    // Arrange and Act
    AssessmentRatingParsedResult actualParseResult = (new BulkAssessmentRatingItemParser()).parse("#", InputFormat.TSV);

    // Assert
    AssessmentRatingParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableAssessmentRatingParseError);
    assertTrue(actualParseResult instanceof ImmutableAssessmentRatingParsedResult);
    assertEquals("#", actualParseResult.input());
    assertEquals("Empty header line: can not bind data\n at [Source: (StringReader); line: UNKNOWN, column: UNKNOWN]",
        errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
  }
}
