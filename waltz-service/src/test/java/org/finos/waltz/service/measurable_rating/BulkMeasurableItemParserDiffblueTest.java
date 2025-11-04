package org.finos.waltz.service.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.waltz.model.bulk_upload.measurable_rating.BulkMeasurableRatingParseResult;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingParseError;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingParseResult;
import org.junit.jupiter.api.Test;

class BulkMeasurableItemParserDiffblueTest {
  /**
   * Method under test:
   * {@link BulkMeasurableItemParser#parse(String, BulkMeasurableItemParser.InputFormat)}
   */
  @Test
  void testParse() {
    // Arrange and Act
    BulkMeasurableRatingParseResult actualParseResult = (new BulkMeasurableItemParser()).parse("Input",
        BulkMeasurableItemParser.InputFormat.CSV);

    // Assert
    assertTrue(actualParseResult instanceof ImmutableBulkMeasurableRatingParseResult);
    assertEquals("Input", actualParseResult.input());
    assertNull(actualParseResult.error());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkMeasurableItemParser#parse(String, BulkMeasurableItemParser.InputFormat)}
   */
  @Test
  void testParse2() {
    // Arrange and Act
    BulkMeasurableRatingParseResult actualParseResult = (new BulkMeasurableItemParser()).parse(null,
        BulkMeasurableItemParser.InputFormat.CSV);

    // Assert
    BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkMeasurableRatingParseResult);
    assertEquals("Cannot parse an empty string", errorResult.message());
    assertNull(actualParseResult.input());
    assertEquals(0, errorResult.column().intValue());
    assertEquals(0, errorResult.line().intValue());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkMeasurableItemParser#parse(String, BulkMeasurableItemParser.InputFormat)}
   */
  @Test
  void testParse3() {
    // Arrange and Act
    BulkMeasurableRatingParseResult actualParseResult = (new BulkMeasurableItemParser()).parse("Input",
        BulkMeasurableItemParser.InputFormat.TSV);

    // Assert
    assertTrue(actualParseResult instanceof ImmutableBulkMeasurableRatingParseResult);
    assertEquals("Input", actualParseResult.input());
    assertNull(actualParseResult.error());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkMeasurableItemParser#parse(String, BulkMeasurableItemParser.InputFormat)}
   */
  @Test
  void testParse4() {
    // Arrange and Act
    BulkMeasurableRatingParseResult actualParseResult = (new BulkMeasurableItemParser()).parse("Input",
        BulkMeasurableItemParser.InputFormat.JSON);

    // Assert
    BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkMeasurableRatingParseResult);
    assertEquals("Input", actualParseResult.input());
    assertEquals("Unrecognized token 'Input': was expecting (JSON String, Number, Array, Object or token 'null', 'true'"
        + " or 'false')\n" + " at [Source: (String)\"Input\"; line: 1, column: 6]", errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkMeasurableItemParser#parse(String, BulkMeasurableItemParser.InputFormat)}
   */
  @Test
  void testParse5() {
    // Arrange and Act
    BulkMeasurableRatingParseResult actualParseResult = (new BulkMeasurableItemParser()).parse("(\n|\r|\r\n)",
        BulkMeasurableItemParser.InputFormat.CSV);

    // Assert
    BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkMeasurableRatingParseResult);
    assertEquals("(\n|\r|\r\n)", actualParseResult.input());
    assertEquals("Cannot construct instance of `org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasu"
        + "rableRatingItem`, problem: Cannot build BulkMeasurableRatingItem, some of required attributes are not"
        + " set [assetCode, taxonomyExternalId, ratingCode, scheme]\n"
        + " at [Source: (StringReader); line: 2, column: 1]", errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkMeasurableItemParser#parse(String, BulkMeasurableItemParser.InputFormat)}
   */
  @Test
  void testParse6() {
    // Arrange and Act
    BulkMeasurableRatingParseResult actualParseResult = (new BulkMeasurableItemParser()).parse("\n",
        BulkMeasurableItemParser.InputFormat.CSV);

    // Assert
    BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkMeasurableRatingParseResult);
    assertEquals("Cannot parse an empty string", errorResult.message());
    assertEquals("\n", actualParseResult.input());
    assertEquals(0, errorResult.column().intValue());
    assertEquals(0, errorResult.line().intValue());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkMeasurableItemParser#parse(String, BulkMeasurableItemParser.InputFormat)}
   */
  @Test
  void testParse7() {
    // Arrange and Act
    BulkMeasurableRatingParseResult actualParseResult = (new BulkMeasurableItemParser()).parse("#",
        BulkMeasurableItemParser.InputFormat.CSV);

    // Assert
    BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkMeasurableRatingParseResult);
    assertEquals("#", actualParseResult.input());
    assertEquals("Empty header line: can not bind data\n at [Source: (StringReader); line: UNKNOWN, column: UNKNOWN]",
        errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkMeasurableItemParser#parse(String, BulkMeasurableItemParser.InputFormat)}
   */
  @Test
  void testParse8() {
    // Arrange and Act
    BulkMeasurableRatingParseResult actualParseResult = (new BulkMeasurableItemParser()).parse("(\n|\r|\r\n)",
        BulkMeasurableItemParser.InputFormat.TSV);

    // Assert
    BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkMeasurableRatingParseResult);
    assertEquals("(\n|\r|\r\n)", actualParseResult.input());
    assertEquals("Cannot construct instance of `org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasu"
        + "rableRatingItem`, problem: Cannot build BulkMeasurableRatingItem, some of required attributes are not"
        + " set [assetCode, taxonomyExternalId, ratingCode, scheme]\n"
        + " at [Source: (StringReader); line: 2, column: 1]", errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkMeasurableItemParser#parse(String, BulkMeasurableItemParser.InputFormat)}
   */
  @Test
  void testParse9() {
    // Arrange and Act
    BulkMeasurableRatingParseResult actualParseResult = (new BulkMeasurableItemParser()).parse("#",
        BulkMeasurableItemParser.InputFormat.JSON);

    // Assert
    assertTrue(actualParseResult instanceof ImmutableBulkMeasurableRatingParseResult);
    assertEquals("", actualParseResult.input());
    assertNull(actualParseResult.error());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkMeasurableItemParser#parse(String, BulkMeasurableItemParser.InputFormat)}
   */
  @Test
  void testParse10() {
    // Arrange and Act
    BulkMeasurableRatingParseResult actualParseResult = (new BulkMeasurableItemParser()).parse("42",
        BulkMeasurableItemParser.InputFormat.JSON);

    // Assert
    BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkMeasurableRatingParseResult);
    assertEquals("42", actualParseResult.input());
    assertEquals(
        "Cannot construct instance of `org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasu"
            + "rableRatingItem$Json` (although at least one Creator exists): no int/Int-argument constructor/factory"
            + " method to deserialize from Number value (42)\n" + " at [Source: (String)\"42\"; line: 1, column: 1]",
        errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkMeasurableItemParser#parse(String, BulkMeasurableItemParser.InputFormat)}
   */
  @Test
  void testParse11() {
    // Arrange and Act
    BulkMeasurableRatingParseResult actualParseResult = (new BulkMeasurableItemParser()).parse(
        "Cannot build BulkMeasurableRatingItem, some of required attributes are not set ",
        BulkMeasurableItemParser.InputFormat.CSV);

    // Assert
    assertTrue(actualParseResult instanceof ImmutableBulkMeasurableRatingParseResult);
    assertEquals("Cannot build BulkMeasurableRatingItem, some of required attributes are not set ",
        actualParseResult.input());
    assertNull(actualParseResult.error());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }
}
