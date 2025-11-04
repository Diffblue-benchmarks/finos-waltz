package org.finos.waltz.service.taxonomy_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.waltz.model.bulk_upload.taxonomy.BulkTaxonomyParseResult;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyParseError;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyParseResult;
import org.junit.jupiter.api.Test;

class BulkTaxonomyItemParserDiffblueTest {
  /**
   * Method under test:
   * {@link BulkTaxonomyItemParser#parse(String, BulkTaxonomyItemParser.InputFormat)}
   */
  @Test
  void testParse() {
    // Arrange and Act
    BulkTaxonomyParseResult actualParseResult = (new BulkTaxonomyItemParser()).parse("Input",
        BulkTaxonomyItemParser.InputFormat.CSV);

    // Assert
    assertTrue(actualParseResult instanceof ImmutableBulkTaxonomyParseResult);
    assertEquals("Input", actualParseResult.input());
    assertNull(actualParseResult.error());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkTaxonomyItemParser#parse(String, BulkTaxonomyItemParser.InputFormat)}
   */
  @Test
  void testParse2() {
    // Arrange and Act
    BulkTaxonomyParseResult actualParseResult = (new BulkTaxonomyItemParser()).parse(null,
        BulkTaxonomyItemParser.InputFormat.CSV);

    // Assert
    BulkTaxonomyParseResult.BulkTaxonomyParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkTaxonomyParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkTaxonomyParseResult);
    assertEquals("Cannot parse an empty string", errorResult.message());
    assertNull(actualParseResult.input());
    assertEquals(0, errorResult.column().intValue());
    assertEquals(0, errorResult.line().intValue());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkTaxonomyItemParser#parse(String, BulkTaxonomyItemParser.InputFormat)}
   */
  @Test
  void testParse3() {
    // Arrange and Act
    BulkTaxonomyParseResult actualParseResult = (new BulkTaxonomyItemParser()).parse("Input",
        BulkTaxonomyItemParser.InputFormat.TSV);

    // Assert
    assertTrue(actualParseResult instanceof ImmutableBulkTaxonomyParseResult);
    assertEquals("Input", actualParseResult.input());
    assertNull(actualParseResult.error());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkTaxonomyItemParser#parse(String, BulkTaxonomyItemParser.InputFormat)}
   */
  @Test
  void testParse4() {
    // Arrange and Act
    BulkTaxonomyParseResult actualParseResult = (new BulkTaxonomyItemParser()).parse("Input",
        BulkTaxonomyItemParser.InputFormat.JSON);

    // Assert
    BulkTaxonomyParseResult.BulkTaxonomyParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkTaxonomyParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkTaxonomyParseResult);
    assertEquals("Input", actualParseResult.input());
    assertEquals("Unrecognized token 'Input': was expecting (JSON String, Number, Array, Object or token 'null', 'true'"
        + " or 'false')\n" + " at [Source: (String)\"Input\"; line: 1, column: 6]", errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkTaxonomyItemParser#parse(String, BulkTaxonomyItemParser.InputFormat)}
   */
  @Test
  void testParse5() {
    // Arrange and Act
    BulkTaxonomyParseResult actualParseResult = (new BulkTaxonomyItemParser()).parse("(\n|\r|\r\n)",
        BulkTaxonomyItemParser.InputFormat.CSV);

    // Assert
    BulkTaxonomyParseResult.BulkTaxonomyParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkTaxonomyParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkTaxonomyParseResult);
    assertEquals("(\n|\r|\r\n)", actualParseResult.input());
    assertEquals("Cannot construct instance of `org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyItem`,"
        + " problem: Cannot build BulkTaxonomyItem, some of required attributes are not set [name, externalId]" + "\n"
        + " at [Source: (StringReader); line: 2, column: 1]", errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkTaxonomyItemParser#parse(String, BulkTaxonomyItemParser.InputFormat)}
   */
  @Test
  void testParse6() {
    // Arrange and Act
    BulkTaxonomyParseResult actualParseResult = (new BulkTaxonomyItemParser()).parse("\n",
        BulkTaxonomyItemParser.InputFormat.CSV);

    // Assert
    BulkTaxonomyParseResult.BulkTaxonomyParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkTaxonomyParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkTaxonomyParseResult);
    assertEquals("Cannot parse an empty string", errorResult.message());
    assertEquals("\n", actualParseResult.input());
    assertEquals(0, errorResult.column().intValue());
    assertEquals(0, errorResult.line().intValue());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkTaxonomyItemParser#parse(String, BulkTaxonomyItemParser.InputFormat)}
   */
  @Test
  void testParse7() {
    // Arrange and Act
    BulkTaxonomyParseResult actualParseResult = (new BulkTaxonomyItemParser()).parse("#",
        BulkTaxonomyItemParser.InputFormat.CSV);

    // Assert
    BulkTaxonomyParseResult.BulkTaxonomyParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkTaxonomyParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkTaxonomyParseResult);
    assertEquals("#", actualParseResult.input());
    assertEquals("Empty header line: can not bind data\n at [Source: (StringReader); line: UNKNOWN, column: UNKNOWN]",
        errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkTaxonomyItemParser#parse(String, BulkTaxonomyItemParser.InputFormat)}
   */
  @Test
  void testParse8() {
    // Arrange and Act
    BulkTaxonomyParseResult actualParseResult = (new BulkTaxonomyItemParser()).parse("(\n|\r|\r\n)",
        BulkTaxonomyItemParser.InputFormat.TSV);

    // Assert
    BulkTaxonomyParseResult.BulkTaxonomyParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkTaxonomyParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkTaxonomyParseResult);
    assertEquals("(\n|\r|\r\n)", actualParseResult.input());
    assertEquals("Cannot construct instance of `org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyItem`,"
        + " problem: Cannot build BulkTaxonomyItem, some of required attributes are not set [name, externalId]" + "\n"
        + " at [Source: (StringReader); line: 2, column: 1]", errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkTaxonomyItemParser#parse(String, BulkTaxonomyItemParser.InputFormat)}
   */
  @Test
  void testParse9() {
    // Arrange and Act
    BulkTaxonomyParseResult actualParseResult = (new BulkTaxonomyItemParser()).parse("42",
        BulkTaxonomyItemParser.InputFormat.JSON);

    // Assert
    BulkTaxonomyParseResult.BulkTaxonomyParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkTaxonomyParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkTaxonomyParseResult);
    assertEquals("42", actualParseResult.input());
    assertEquals(
        "Cannot construct instance of `org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyItem$Json`"
            + " (although at least one Creator exists): no int/Int-argument constructor/factory method to deserialize"
            + " from Number value (42)\n" + " at [Source: (String)\"42\"; line: 1, column: 1]",
        errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkTaxonomyItemParser#parse(String, BulkTaxonomyItemParser.InputFormat)}
   */
  @Test
  void testParse10() {
    // Arrange and Act
    BulkTaxonomyParseResult actualParseResult = (new BulkTaxonomyItemParser()).parse(
        "Cannot build BulkTaxonomyItem, some of required attributes are not set ",
        BulkTaxonomyItemParser.InputFormat.CSV);

    // Assert
    assertTrue(actualParseResult instanceof ImmutableBulkTaxonomyParseResult);
    assertEquals("Cannot build BulkTaxonomyItem, some of required attributes are not set ", actualParseResult.input());
    assertNull(actualParseResult.error());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }
}
