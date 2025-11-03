package org.finos.waltz.service.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.entity_relationship.BulkUploadRelationshipParsedResult;
import org.finos.waltz.model.bulk_upload.entity_relationship.BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipParseError;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipParsedResult;
import org.finos.waltz.service.entity_relationship.BulkUploadRelationshipItemParser.InputFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BulkUploadRelationshipItemParserDiffblueTest {
  /**
   * Test {@link BulkUploadRelationshipItemParser#parse(String, InputFormat)}.
   * <p>
   * Method under test: {@link BulkUploadRelationshipItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkUploadRelationshipParsedResult BulkUploadRelationshipItemParser.parse(String, InputFormat)"})
  void testParse() {
    // Arrange and Act
    BulkUploadRelationshipParsedResult actualParseResult = (new BulkUploadRelationshipItemParser())
        .parse("(\n|\r|\r\n)", InputFormat.CSV);

    // Assert
    BulkUploadRelationshipParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    assertEquals("(\n|\r|\r\n)", actualParseResult.input());
    assertEquals("Cannot construct instance of `org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUpl"
        + "oadRelationshipItem`, problem: Cannot build BulkUploadRelationshipItem, some of required attributes"
        + " are not set [sourceExternalId, targetExternalId]\n" + " at [Source: (StringReader); line: 2, column: 1]",
        errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
  }

  /**
   * Test {@link BulkUploadRelationshipItemParser#parse(String, InputFormat)}.
   * <p>
   * Method under test: {@link BulkUploadRelationshipItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkUploadRelationshipParsedResult BulkUploadRelationshipItemParser.parse(String, InputFormat)"})
  void testParse2() {
    // Arrange and Act
    BulkUploadRelationshipParsedResult actualParseResult = (new BulkUploadRelationshipItemParser())
        .parse("(\n|\r|\r\n)", InputFormat.TSV);

    // Assert
    BulkUploadRelationshipParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    assertEquals("(\n|\r|\r\n)", actualParseResult.input());
    assertEquals("Cannot construct instance of `org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUpl"
        + "oadRelationshipItem`, problem: Cannot build BulkUploadRelationshipItem, some of required attributes"
        + " are not set [sourceExternalId, targetExternalId]\n" + " at [Source: (StringReader); line: 2, column: 1]",
        errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
  }

  /**
   * Test {@link BulkUploadRelationshipItemParser#parse(String, InputFormat)}.
   * <p>
   * Method under test: {@link BulkUploadRelationshipItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkUploadRelationshipParsedResult BulkUploadRelationshipItemParser.parse(String, InputFormat)"})
  void testParse3() {
    // Arrange and Act
    BulkUploadRelationshipParsedResult actualParseResult = (new BulkUploadRelationshipItemParser())
        .parse("Cannot build BulkUploadRelationshipItem, some of required attributes are not set ", InputFormat.CSV);

    // Assert
    BulkUploadRelationshipParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    assertEquals("Cannot build BulkUploadRelationshipItem, some of required attributes are not set ",
        actualParseResult.input());
    assertEquals("Cannot parse input.", errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
  }

  /**
   * Test {@link BulkUploadRelationshipItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return input is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkUploadRelationshipItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when '42'; then return input is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkUploadRelationshipParsedResult BulkUploadRelationshipItemParser.parse(String, InputFormat)"})
  void testParse_when42_thenReturnInputIs42() {
    // Arrange and Act
    BulkUploadRelationshipParsedResult actualParseResult = (new BulkUploadRelationshipItemParser()).parse("42",
        InputFormat.JSON);

    // Assert
    BulkUploadRelationshipParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    assertEquals("42", actualParseResult.input());
    assertEquals("Cannot construct instance of `org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUpl"
        + "oadRelationshipItem$Json` (although at least one Creator exists): no int/Int-argument constructor/factory"
        + " method to deserialize from Number value (42)\n" + " at [Source: (String)\"42\"; line: 1, column: 1]",
        errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
  }

  /**
   * Test {@link BulkUploadRelationshipItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When {@code Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkUploadRelationshipItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when 'Input'; then return 'Input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkUploadRelationshipParsedResult BulkUploadRelationshipItemParser.parse(String, InputFormat)"})
  void testParse_whenInput_thenReturnInput() {
    // Arrange and Act
    BulkUploadRelationshipParsedResult actualParseResult = (new BulkUploadRelationshipItemParser()).parse("Input",
        InputFormat.CSV);

    // Assert
    BulkUploadRelationshipParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    assertEquals("Cannot parse input.", errorResult.message());
    assertEquals("Input", actualParseResult.input());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
  }

  /**
   * Test {@link BulkUploadRelationshipItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When {@code Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkUploadRelationshipItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when 'Input'; then return 'Input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkUploadRelationshipParsedResult BulkUploadRelationshipItemParser.parse(String, InputFormat)"})
  void testParse_whenInput_thenReturnInput2() {
    // Arrange and Act
    BulkUploadRelationshipParsedResult actualParseResult = (new BulkUploadRelationshipItemParser()).parse("Input",
        InputFormat.JSON);

    // Assert
    BulkUploadRelationshipParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    assertEquals("Input", actualParseResult.input());
    assertEquals("Unrecognized token 'Input': was expecting (JSON String, Number, Array, Object or token 'null', 'true'"
        + " or 'false')\n" + " at [Source: (String)\"Input\"; line: 1, column: 6]", errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
  }

  /**
   * Test {@link BulkUploadRelationshipItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then return input is lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkUploadRelationshipItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when lf; then return input is lf")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkUploadRelationshipParsedResult BulkUploadRelationshipItemParser.parse(String, InputFormat)"})
  void testParse_whenLf_thenReturnInputIsLf() {
    // Arrange and Act
    BulkUploadRelationshipParsedResult actualParseResult = (new BulkUploadRelationshipItemParser()).parse("\n",
        InputFormat.CSV);

    // Assert
    BulkUploadRelationshipParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    assertEquals("Cannot parse input.", errorResult.message());
    assertEquals("\n", actualParseResult.input());
    assertEquals(0, errorResult.column().intValue());
    assertEquals(0, errorResult.line().intValue());
  }

  /**
   * Test {@link BulkUploadRelationshipItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When {@code #}.</li>
   *   <li>Then return input is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkUploadRelationshipItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when '#'; then return input is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkUploadRelationshipParsedResult BulkUploadRelationshipItemParser.parse(String, InputFormat)"})
  void testParse_whenNumberSign_thenReturnInputIsEmptyString() {
    // Arrange and Act
    BulkUploadRelationshipParsedResult actualParseResult = (new BulkUploadRelationshipItemParser()).parse("#",
        InputFormat.JSON);

    // Assert
    BulkUploadRelationshipParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    assertEquals("", actualParseResult.input());
    assertEquals("Cannot parse input.", errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
  }

  /**
   * Test {@link BulkUploadRelationshipItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When {@code #}.</li>
   *   <li>Then return input is {@code #}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkUploadRelationshipItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when '#'; then return input is '#'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkUploadRelationshipParsedResult BulkUploadRelationshipItemParser.parse(String, InputFormat)"})
  void testParse_whenNumberSign_thenReturnInputIsNumberSign() {
    // Arrange and Act
    BulkUploadRelationshipParsedResult actualParseResult = (new BulkUploadRelationshipItemParser()).parse("#",
        InputFormat.CSV);

    // Assert
    BulkUploadRelationshipParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    assertEquals("#", actualParseResult.input());
    assertEquals("Empty header line: can not bind data\n at [Source: (StringReader); line: UNKNOWN, column: UNKNOWN]",
        errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
  }

  /**
   * Test {@link BulkUploadRelationshipItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When {@code TSV}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkUploadRelationshipItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when 'TSV'; then return 'Input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkUploadRelationshipParsedResult BulkUploadRelationshipItemParser.parse(String, InputFormat)"})
  void testParse_whenTsv_thenReturnInput() {
    // Arrange and Act
    BulkUploadRelationshipParsedResult actualParseResult = (new BulkUploadRelationshipItemParser()).parse("Input",
        InputFormat.TSV);

    // Assert
    BulkUploadRelationshipParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkUploadRelationshipParsedResult);
    assertEquals("Cannot parse input.", errorResult.message());
    assertEquals("Input", actualParseResult.input());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
  }
}
