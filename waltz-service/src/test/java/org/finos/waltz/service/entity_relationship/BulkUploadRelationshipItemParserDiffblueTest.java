package org.finos.waltz.service.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.waltz.model.bulk_upload.entity_relationship.BulkUploadRelationshipParsedResult;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipParseError;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipParsedResult;
import org.junit.jupiter.api.Test;

class BulkUploadRelationshipItemParserDiffblueTest {
  /**
   * Method under test:
   * {@link BulkUploadRelationshipItemParser#parse(String, BulkUploadRelationshipItemParser.InputFormat)}
   */
  @Test
  void testParse() {
    // Arrange and Act
    BulkUploadRelationshipParsedResult actualParseResult = (new BulkUploadRelationshipItemParser()).parse("Input",
        BulkUploadRelationshipItemParser.InputFormat.CSV);

    // Assert
    BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    assertEquals("Cannot parse input.", errorResult.message());
    assertEquals("Input", actualParseResult.input());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkUploadRelationshipItemParser#parse(String, BulkUploadRelationshipItemParser.InputFormat)}
   */
  @Test
  void testParse2() {
    // Arrange and Act
    BulkUploadRelationshipParsedResult actualParseResult = (new BulkUploadRelationshipItemParser()).parse("Input",
        BulkUploadRelationshipItemParser.InputFormat.TSV);

    // Assert
    BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    assertEquals("Cannot parse input.", errorResult.message());
    assertEquals("Input", actualParseResult.input());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkUploadRelationshipItemParser#parse(String, BulkUploadRelationshipItemParser.InputFormat)}
   */
  @Test
  void testParse3() {
    // Arrange and Act
    BulkUploadRelationshipParsedResult actualParseResult = (new BulkUploadRelationshipItemParser()).parse("Input",
        BulkUploadRelationshipItemParser.InputFormat.JSON);

    // Assert
    BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    assertEquals("Input", actualParseResult.input());
    assertEquals("Unrecognized token 'Input': was expecting (JSON String, Number, Array, Object or token 'null', 'true'"
        + " or 'false')\n" + " at [Source: (String)\"Input\"; line: 1, column: 6]", errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkUploadRelationshipItemParser#parse(String, BulkUploadRelationshipItemParser.InputFormat)}
   */
  @Test
  void testParse4() {
    // Arrange and Act
    BulkUploadRelationshipParsedResult actualParseResult = (new BulkUploadRelationshipItemParser())
        .parse("(\n|\r|\r\n)", BulkUploadRelationshipItemParser.InputFormat.CSV);

    // Assert
    BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    assertEquals("(\n|\r|\r\n)", actualParseResult.input());
    assertEquals("Cannot construct instance of `org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUpl"
        + "oadRelationshipItem`, problem: Cannot build BulkUploadRelationshipItem, some of required attributes"
        + " are not set [sourceExternalId, targetExternalId]\n" + " at [Source: (StringReader); line: 2, column: 1]",
        errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkUploadRelationshipItemParser#parse(String, BulkUploadRelationshipItemParser.InputFormat)}
   */
  @Test
  void testParse5() {
    // Arrange and Act
    BulkUploadRelationshipParsedResult actualParseResult = (new BulkUploadRelationshipItemParser()).parse("\n",
        BulkUploadRelationshipItemParser.InputFormat.CSV);

    // Assert
    BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    assertEquals("Cannot parse input.", errorResult.message());
    assertEquals("\n", actualParseResult.input());
    assertEquals(0, errorResult.column().intValue());
    assertEquals(0, errorResult.line().intValue());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkUploadRelationshipItemParser#parse(String, BulkUploadRelationshipItemParser.InputFormat)}
   */
  @Test
  void testParse6() {
    // Arrange and Act
    BulkUploadRelationshipParsedResult actualParseResult = (new BulkUploadRelationshipItemParser()).parse("#",
        BulkUploadRelationshipItemParser.InputFormat.CSV);

    // Assert
    BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    assertEquals("#", actualParseResult.input());
    assertEquals("Empty header line: can not bind data\n at [Source: (StringReader); line: UNKNOWN, column: UNKNOWN]",
        errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkUploadRelationshipItemParser#parse(String, BulkUploadRelationshipItemParser.InputFormat)}
   */
  @Test
  void testParse7() {
    // Arrange and Act
    BulkUploadRelationshipParsedResult actualParseResult = (new BulkUploadRelationshipItemParser())
        .parse("(\n|\r|\r\n)", BulkUploadRelationshipItemParser.InputFormat.TSV);

    // Assert
    BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    assertEquals("(\n|\r|\r\n)", actualParseResult.input());
    assertEquals("Cannot construct instance of `org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUpl"
        + "oadRelationshipItem`, problem: Cannot build BulkUploadRelationshipItem, some of required attributes"
        + " are not set [sourceExternalId, targetExternalId]\n" + " at [Source: (StringReader); line: 2, column: 1]",
        errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkUploadRelationshipItemParser#parse(String, BulkUploadRelationshipItemParser.InputFormat)}
   */
  @Test
  void testParse8() {
    // Arrange and Act
    BulkUploadRelationshipParsedResult actualParseResult = (new BulkUploadRelationshipItemParser()).parse("#",
        BulkUploadRelationshipItemParser.InputFormat.JSON);

    // Assert
    BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    assertEquals("", actualParseResult.input());
    assertEquals("Cannot parse input.", errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkUploadRelationshipItemParser#parse(String, BulkUploadRelationshipItemParser.InputFormat)}
   */
  @Test
  void testParse9() {
    // Arrange and Act
    BulkUploadRelationshipParsedResult actualParseResult = (new BulkUploadRelationshipItemParser()).parse("42",
        BulkUploadRelationshipItemParser.InputFormat.JSON);

    // Assert
    BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    assertEquals("42", actualParseResult.input());
    assertEquals("Cannot construct instance of `org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUpl"
        + "oadRelationshipItem$Json` (although at least one Creator exists): no int/Int-argument constructor/factory"
        + " method to deserialize from Number value (42)\n" + " at [Source: (String)\"42\"; line: 1, column: 1]",
        errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkUploadRelationshipItemParser#parse(String, BulkUploadRelationshipItemParser.InputFormat)}
   */
  @Test
  void testParse10() {
    // Arrange and Act
    BulkUploadRelationshipParsedResult actualParseResult = (new BulkUploadRelationshipItemParser()).parse(
        "Cannot build BulkUploadRelationshipItem, some of required attributes are not set ",
        BulkUploadRelationshipItemParser.InputFormat.CSV);

    // Assert
    BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    assertEquals("Cannot build BulkUploadRelationshipItem, some of required attributes are not set ",
        actualParseResult.input());
    assertEquals("Cannot parse input.", errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }
}
