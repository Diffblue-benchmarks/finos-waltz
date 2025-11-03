package org.finos.waltz.service.taxonomy_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.taxonomy.BulkTaxonomyParseResult;
import org.finos.waltz.model.bulk_upload.taxonomy.BulkTaxonomyParseResult.BulkTaxonomyParseError;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyParseError;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyParseResult;
import org.finos.waltz.service.taxonomy_management.BulkTaxonomyItemParser.InputFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BulkTaxonomyItemParserDiffblueTest {
  /**
   * Test {@link BulkTaxonomyItemParser#parse(String, InputFormat)}.
   * <p>
   * Method under test: {@link BulkTaxonomyItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkTaxonomyParseResult BulkTaxonomyItemParser.parse(String, InputFormat)"})
  void testParse() {
    // Arrange and Act
    BulkTaxonomyParseResult actualParseResult = (new BulkTaxonomyItemParser()).parse("(\n|\r|\r\n)", InputFormat.CSV);

    // Assert
    BulkTaxonomyParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkTaxonomyParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkTaxonomyParseResult);
    assertEquals("(\n|\r|\r\n)", actualParseResult.input());
    assertEquals("Cannot construct instance of `org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyItem`,"
        + " problem: Cannot build BulkTaxonomyItem, some of required attributes are not set [name, externalId]" + "\n"
        + " at [Source: (StringReader); line: 2, column: 1]", errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
  }

  /**
   * Test {@link BulkTaxonomyItemParser#parse(String, InputFormat)}.
   * <p>
   * Method under test: {@link BulkTaxonomyItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkTaxonomyParseResult BulkTaxonomyItemParser.parse(String, InputFormat)"})
  void testParse2() {
    // Arrange and Act
    BulkTaxonomyParseResult actualParseResult = (new BulkTaxonomyItemParser()).parse("(\n|\r|\r\n)", InputFormat.TSV);

    // Assert
    BulkTaxonomyParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkTaxonomyParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkTaxonomyParseResult);
    assertEquals("(\n|\r|\r\n)", actualParseResult.input());
    assertEquals("Cannot construct instance of `org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyItem`,"
        + " problem: Cannot build BulkTaxonomyItem, some of required attributes are not set [name, externalId]" + "\n"
        + " at [Source: (StringReader); line: 2, column: 1]", errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
  }

  /**
   * Test {@link BulkTaxonomyItemParser#parse(String, InputFormat)}.
   * <p>
   * Method under test: {@link BulkTaxonomyItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkTaxonomyParseResult BulkTaxonomyItemParser.parse(String, InputFormat)"})
  void testParse3() {
    // Arrange and Act
    BulkTaxonomyParseResult actualParseResult = (new BulkTaxonomyItemParser())
        .parse("Cannot build BulkTaxonomyItem, some of required attributes are not set ", InputFormat.CSV);

    // Assert
    assertTrue(actualParseResult instanceof ImmutableBulkTaxonomyParseResult);
    assertEquals("Cannot build BulkTaxonomyItem, some of required attributes are not set ", actualParseResult.input());
    assertNull(actualParseResult.error());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link BulkTaxonomyItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return input is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkTaxonomyItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when '42'; then return input is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkTaxonomyParseResult BulkTaxonomyItemParser.parse(String, InputFormat)"})
  void testParse_when42_thenReturnInputIs42() {
    // Arrange and Act
    BulkTaxonomyParseResult actualParseResult = (new BulkTaxonomyItemParser()).parse("42", InputFormat.JSON);

    // Assert
    BulkTaxonomyParseError errorResult = actualParseResult.error();
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
  }

  /**
   * Test {@link BulkTaxonomyItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When {@code Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkTaxonomyItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when 'Input'; then return 'Input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkTaxonomyParseResult BulkTaxonomyItemParser.parse(String, InputFormat)"})
  void testParse_whenInput_thenReturnInput() {
    // Arrange and Act
    BulkTaxonomyParseResult actualParseResult = (new BulkTaxonomyItemParser()).parse("Input", InputFormat.CSV);

    // Assert
    assertTrue(actualParseResult instanceof ImmutableBulkTaxonomyParseResult);
    assertEquals("Input", actualParseResult.input());
    assertNull(actualParseResult.error());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link BulkTaxonomyItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When {@code JSON}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkTaxonomyItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when 'JSON'; then return 'Input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkTaxonomyParseResult BulkTaxonomyItemParser.parse(String, InputFormat)"})
  void testParse_whenJson_thenReturnInput() {
    // Arrange and Act
    BulkTaxonomyParseResult actualParseResult = (new BulkTaxonomyItemParser()).parse("Input", InputFormat.JSON);

    // Assert
    BulkTaxonomyParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkTaxonomyParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkTaxonomyParseResult);
    assertEquals("Input", actualParseResult.input());
    assertEquals("Unrecognized token 'Input': was expecting (JSON String, Number, Array, Object or token 'null', 'true'"
        + " or 'false')\n" + " at [Source: (String)\"Input\"; line: 1, column: 6]", errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
  }

  /**
   * Test {@link BulkTaxonomyItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then return input is lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkTaxonomyItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when lf; then return input is lf")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkTaxonomyParseResult BulkTaxonomyItemParser.parse(String, InputFormat)"})
  void testParse_whenLf_thenReturnInputIsLf() {
    // Arrange and Act
    BulkTaxonomyParseResult actualParseResult = (new BulkTaxonomyItemParser()).parse("\n", InputFormat.CSV);

    // Assert
    BulkTaxonomyParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkTaxonomyParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkTaxonomyParseResult);
    assertEquals("Cannot parse an empty string", errorResult.message());
    assertEquals("\n", actualParseResult.input());
    assertEquals(0, errorResult.column().intValue());
    assertEquals(0, errorResult.line().intValue());
  }

  /**
   * Test {@link BulkTaxonomyItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return input is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkTaxonomyItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when 'null'; then return input is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkTaxonomyParseResult BulkTaxonomyItemParser.parse(String, InputFormat)"})
  void testParse_whenNull_thenReturnInputIsNull() {
    // Arrange and Act
    BulkTaxonomyParseResult actualParseResult = (new BulkTaxonomyItemParser()).parse(null, InputFormat.CSV);

    // Assert
    BulkTaxonomyParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkTaxonomyParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkTaxonomyParseResult);
    assertEquals("Cannot parse an empty string", errorResult.message());
    assertNull(actualParseResult.input());
    assertEquals(0, errorResult.column().intValue());
    assertEquals(0, errorResult.line().intValue());
  }

  /**
   * Test {@link BulkTaxonomyItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When {@code #}.</li>
   *   <li>Then return input is {@code #}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkTaxonomyItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when '#'; then return input is '#'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkTaxonomyParseResult BulkTaxonomyItemParser.parse(String, InputFormat)"})
  void testParse_whenNumberSign_thenReturnInputIsNumberSign() {
    // Arrange and Act
    BulkTaxonomyParseResult actualParseResult = (new BulkTaxonomyItemParser()).parse("#", InputFormat.CSV);

    // Assert
    BulkTaxonomyParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkTaxonomyParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkTaxonomyParseResult);
    assertEquals("#", actualParseResult.input());
    assertEquals("Empty header line: can not bind data\n at [Source: (StringReader); line: UNKNOWN, column: UNKNOWN]",
        errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
  }

  /**
   * Test {@link BulkTaxonomyItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When {@code TSV}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkTaxonomyItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when 'TSV'; then return 'Input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkTaxonomyParseResult BulkTaxonomyItemParser.parse(String, InputFormat)"})
  void testParse_whenTsv_thenReturnInput() {
    // Arrange and Act
    BulkTaxonomyParseResult actualParseResult = (new BulkTaxonomyItemParser()).parse("Input", InputFormat.TSV);

    // Assert
    assertTrue(actualParseResult instanceof ImmutableBulkTaxonomyParseResult);
    assertEquals("Input", actualParseResult.input());
    assertNull(actualParseResult.error());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }
}
