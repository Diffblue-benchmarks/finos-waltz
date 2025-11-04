package org.finos.waltz.service.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.waltz.model.assessment_rating.bulk_upload.AssessmentRatingParsedResult;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmentRatingParseError;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmentRatingParsedResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BulkAssessmentRatingItemParser.class})
@ExtendWith(SpringExtension.class)
class BulkAssessmentRatingItemParserDiffblueTest {
  @Autowired
  private BulkAssessmentRatingItemParser bulkAssessmentRatingItemParser;

  /**
   * Method under test:
   * {@link BulkAssessmentRatingItemParser#parse(String, BulkAssessmentRatingItemParser.InputFormat)}
   */
  @Test
  void testParse() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> bulkAssessmentRatingItemParser.parse("Input", BulkAssessmentRatingItemParser.InputFormat.CSV));
  }

  /**
   * Method under test:
   * {@link BulkAssessmentRatingItemParser#parse(String, BulkAssessmentRatingItemParser.InputFormat)}
   */
  @Test
  void testParse2() {
    // Arrange and Act
    AssessmentRatingParsedResult actualParseResult = bulkAssessmentRatingItemParser.parse("",
        BulkAssessmentRatingItemParser.InputFormat.CSV);

    // Assert
    AssessmentRatingParsedResult.AssessmentRatingParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableAssessmentRatingParseError);
    assertTrue(actualParseResult instanceof ImmutableAssessmentRatingParsedResult);
    assertEquals("", actualParseResult.input());
    assertEquals("Cannot parse an empty string", errorResult.message());
    assertEquals(0, errorResult.column().intValue());
    assertEquals(0, errorResult.line().intValue());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkAssessmentRatingItemParser#parse(String, BulkAssessmentRatingItemParser.InputFormat)}
   */
  @Test
  void testParse3() {
    // Arrange and Act
    AssessmentRatingParsedResult actualParseResult = bulkAssessmentRatingItemParser.parse("Input",
        BulkAssessmentRatingItemParser.InputFormat.TSV);

    // Assert
    assertTrue(actualParseResult instanceof ImmutableAssessmentRatingParsedResult);
    assertEquals("Input", actualParseResult.input());
    assertNull(actualParseResult.error());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkAssessmentRatingItemParser#parse(String, BulkAssessmentRatingItemParser.InputFormat)}
   */
  @Test
  void testParse4() {
    // Arrange and Act
    AssessmentRatingParsedResult actualParseResult = bulkAssessmentRatingItemParser.parse("(\n|\r|\r\n)",
        BulkAssessmentRatingItemParser.InputFormat.TSV);

    // Assert
    AssessmentRatingParsedResult.AssessmentRatingParseError errorResult = actualParseResult.error();
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
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkAssessmentRatingItemParser#parse(String, BulkAssessmentRatingItemParser.InputFormat)}
   */
  @Test
  void testParse5() {
    // Arrange and Act
    AssessmentRatingParsedResult actualParseResult = bulkAssessmentRatingItemParser.parse("#",
        BulkAssessmentRatingItemParser.InputFormat.TSV);

    // Assert
    AssessmentRatingParsedResult.AssessmentRatingParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableAssessmentRatingParseError);
    assertTrue(actualParseResult instanceof ImmutableAssessmentRatingParsedResult);
    assertEquals("#", actualParseResult.input());
    assertEquals("Empty header line: can not bind data\n at [Source: (StringReader); line: UNKNOWN, column: UNKNOWN]",
        errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }
}
