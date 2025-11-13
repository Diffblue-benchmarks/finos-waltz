package org.finos.waltz.service.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <ul>
   *   <li>When {@code CSV}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BulkAssessmentRatingItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when 'CSV'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingParsedResult BulkAssessmentRatingItemParser.parse(String, InputFormat)"
  })
  void testParse_whenCsv_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new BulkAssessmentRatingItemParser().parse("Input", InputFormat.CSV));
  }

  /**
   * Test {@link BulkAssessmentRatingItemParser#parse(String, InputFormat)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return input is empty string.
   * </ul>
   *
   * <p>Method under test: {@link BulkAssessmentRatingItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName(
      "Test parse(String, InputFormat); when empty string; then return input is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingParsedResult BulkAssessmentRatingItemParser.parse(String, InputFormat)"
  })
  void testParse_whenEmptyString_thenReturnInputIsEmptyString() {
    // Arrange and Act
    AssessmentRatingParsedResult actualParseResult =
        new BulkAssessmentRatingItemParser().parse("", InputFormat.TSV);

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
   *
   * <ul>
   *   <li>When {@code foo( | | )bar( | | )baz}.
   *   <li>Then return input is {@code foo( | | )bar( | | )baz}.
   * </ul>
   *
   * <p>Method under test: {@link BulkAssessmentRatingItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName(
      "Test parse(String, InputFormat); when 'foo( | | )bar( | | )baz'; then return input is 'foo( | | )bar( | | )baz'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingParsedResult BulkAssessmentRatingItemParser.parse(String, InputFormat)"
  })
  void testParse_whenFooBarBaz_thenReturnInputIsFooBarBaz() {
    // Arrange and Act
    AssessmentRatingParsedResult actualParseResult =
        new BulkAssessmentRatingItemParser()
            .parse("foo(\n|\r|\r\n)bar(\n|\r|\r\n)baz", InputFormat.TSV);

    // Assert
    AssessmentRatingParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableAssessmentRatingParseError);
    assertTrue(actualParseResult instanceof ImmutableAssessmentRatingParsedResult);
    assertEquals(
        "Cannot construct instance of `org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmen"
            + "tRatingParsedItem`, problem: Cannot build AssessmentRatingParsedItem, some of required attributes are"
            + " not set [externalId, ratingCode]\n"
            + " at [Source: (StringReader); line: 2, column: 1]",
        errorResult.message());
    assertEquals("foo(\n|\r|\r\n)bar(\n|\r|\r\n)baz", actualParseResult.input());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
  }

  /**
   * Test {@link BulkAssessmentRatingItemParser#parse(String, InputFormat)}.
   *
   * <ul>
   *   <li>When {@code foo( | | )bar}.
   *   <li>Then return input is {@code foo( | | )bar}.
   * </ul>
   *
   * <p>Method under test: {@link BulkAssessmentRatingItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName(
      "Test parse(String, InputFormat); when 'foo( | | )bar'; then return input is 'foo( | | )bar'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingParsedResult BulkAssessmentRatingItemParser.parse(String, InputFormat)"
  })
  void testParse_whenFooBar_thenReturnInputIsFooBar() {
    // Arrange and Act
    AssessmentRatingParsedResult actualParseResult =
        new BulkAssessmentRatingItemParser().parse("foo(\n|\r|\r\n)bar", InputFormat.TSV);

    // Assert
    AssessmentRatingParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableAssessmentRatingParseError);
    assertTrue(actualParseResult instanceof ImmutableAssessmentRatingParsedResult);
    assertEquals(
        "Cannot construct instance of `org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmen"
            + "tRatingParsedItem`, problem: Cannot build AssessmentRatingParsedItem, some of required attributes are"
            + " not set [externalId, ratingCode]\n"
            + " at [Source: (StringReader); line: 2, column: 1]",
        errorResult.message());
    assertEquals("foo(\n|\r|\r\n)bar", actualParseResult.input());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
  }

  /**
   * Test {@link BulkAssessmentRatingItemParser#parse(String, InputFormat)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@code Input}.
   * </ul>
   *
   * <p>Method under test: {@link BulkAssessmentRatingItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when 'Input'; then return 'Input'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingParsedResult BulkAssessmentRatingItemParser.parse(String, InputFormat)"
  })
  void testParse_whenInput_thenReturnInput() {
    // Arrange and Act
    AssessmentRatingParsedResult actualParseResult =
        new BulkAssessmentRatingItemParser().parse("Input", InputFormat.TSV);

    // Assert
    assertTrue(actualParseResult instanceof ImmutableAssessmentRatingParsedResult);
    assertEquals("Input", actualParseResult.input());
    assertNull(actualParseResult.error());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link BulkAssessmentRatingItemParser#parse(String, InputFormat)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return input is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BulkAssessmentRatingItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when 'null'; then return input is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingParsedResult BulkAssessmentRatingItemParser.parse(String, InputFormat)"
  })
  void testParse_whenNull_thenReturnInputIsNull() {
    // Arrange and Act
    AssessmentRatingParsedResult actualParseResult =
        new BulkAssessmentRatingItemParser().parse(null, InputFormat.TSV);

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
   *
   * <ul>
   *   <li>When {@code #}.
   *   <li>Then return input is {@code #}.
   * </ul>
   *
   * <p>Method under test: {@link BulkAssessmentRatingItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when '#'; then return input is '#'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingParsedResult BulkAssessmentRatingItemParser.parse(String, InputFormat)"
  })
  void testParse_whenNumberSign_thenReturnInputIsNumberSign() {
    // Arrange and Act
    AssessmentRatingParsedResult actualParseResult =
        new BulkAssessmentRatingItemParser().parse("#", InputFormat.TSV);

    // Assert
    AssessmentRatingParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableAssessmentRatingParseError);
    assertTrue(actualParseResult instanceof ImmutableAssessmentRatingParsedResult);
    assertEquals("#", actualParseResult.input());
    assertEquals(
        "Empty header line: can not bind data\n at [Source: (StringReader); line: UNKNOWN, column: UNKNOWN]",
        errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
  }
}
