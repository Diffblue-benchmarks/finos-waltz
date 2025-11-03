package org.finos.waltz.service.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.measurable_rating.BulkMeasurableRatingParseResult;
import org.finos.waltz.model.bulk_upload.measurable_rating.BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingParseError;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingParseResult;
import org.finos.waltz.service.measurable_rating.BulkMeasurableItemParser.InputFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BulkMeasurableItemParserDiffblueTest {
  /**
   * Test {@link BulkMeasurableItemParser#parse(String, InputFormat)}.
   * <p>
   * Method under test: {@link BulkMeasurableItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkMeasurableRatingParseResult BulkMeasurableItemParser.parse(String, InputFormat)"})
  void testParse() {
    // Arrange and Act
    BulkMeasurableRatingParseResult actualParseResult = (new BulkMeasurableItemParser()).parse("(\n|\r|\r\n)",
        InputFormat.CSV);

    // Assert
    BulkMeasurableRatingParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkMeasurableRatingParseResult);
    assertEquals("(\n|\r|\r\n)", actualParseResult.input());
    assertEquals("Cannot construct instance of `org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasu"
        + "rableRatingItem`, problem: Cannot build BulkMeasurableRatingItem, some of required attributes are not"
        + " set [assetCode, taxonomyExternalId, ratingCode, scheme]\n"
        + " at [Source: (StringReader); line: 2, column: 1]", errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
  }

  /**
   * Test {@link BulkMeasurableItemParser#parse(String, InputFormat)}.
   * <p>
   * Method under test: {@link BulkMeasurableItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkMeasurableRatingParseResult BulkMeasurableItemParser.parse(String, InputFormat)"})
  void testParse2() {
    // Arrange and Act
    BulkMeasurableRatingParseResult actualParseResult = (new BulkMeasurableItemParser()).parse("(\n|\r|\r\n)",
        InputFormat.TSV);

    // Assert
    BulkMeasurableRatingParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkMeasurableRatingParseResult);
    assertEquals("(\n|\r|\r\n)", actualParseResult.input());
    assertEquals("Cannot construct instance of `org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasu"
        + "rableRatingItem`, problem: Cannot build BulkMeasurableRatingItem, some of required attributes are not"
        + " set [assetCode, taxonomyExternalId, ratingCode, scheme]\n"
        + " at [Source: (StringReader); line: 2, column: 1]", errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
  }

  /**
   * Test {@link BulkMeasurableItemParser#parse(String, InputFormat)}.
   * <p>
   * Method under test: {@link BulkMeasurableItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkMeasurableRatingParseResult BulkMeasurableItemParser.parse(String, InputFormat)"})
  void testParse3() {
    // Arrange and Act
    BulkMeasurableRatingParseResult actualParseResult = (new BulkMeasurableItemParser())
        .parse("Cannot build BulkMeasurableRatingItem, some of required attributes are not set ", InputFormat.CSV);

    // Assert
    assertTrue(actualParseResult instanceof ImmutableBulkMeasurableRatingParseResult);
    assertEquals("Cannot build BulkMeasurableRatingItem, some of required attributes are not set ",
        actualParseResult.input());
    assertNull(actualParseResult.error());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link BulkMeasurableItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return input is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkMeasurableItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when '42'; then return input is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkMeasurableRatingParseResult BulkMeasurableItemParser.parse(String, InputFormat)"})
  void testParse_when42_thenReturnInputIs42() {
    // Arrange and Act
    BulkMeasurableRatingParseResult actualParseResult = (new BulkMeasurableItemParser()).parse("42", InputFormat.JSON);

    // Assert
    BulkMeasurableRatingParseError errorResult = actualParseResult.error();
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
  }

  /**
   * Test {@link BulkMeasurableItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When {@code Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkMeasurableItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when 'Input'; then return 'Input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkMeasurableRatingParseResult BulkMeasurableItemParser.parse(String, InputFormat)"})
  void testParse_whenInput_thenReturnInput() {
    // Arrange and Act
    BulkMeasurableRatingParseResult actualParseResult = (new BulkMeasurableItemParser()).parse("Input",
        InputFormat.CSV);

    // Assert
    assertTrue(actualParseResult instanceof ImmutableBulkMeasurableRatingParseResult);
    assertEquals("Input", actualParseResult.input());
    assertNull(actualParseResult.error());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link BulkMeasurableItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When {@code Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkMeasurableItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when 'Input'; then return 'Input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkMeasurableRatingParseResult BulkMeasurableItemParser.parse(String, InputFormat)"})
  void testParse_whenInput_thenReturnInput2() {
    // Arrange and Act
    BulkMeasurableRatingParseResult actualParseResult = (new BulkMeasurableItemParser()).parse("Input",
        InputFormat.JSON);

    // Assert
    BulkMeasurableRatingParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkMeasurableRatingParseResult);
    assertEquals("Input", actualParseResult.input());
    assertEquals("Unrecognized token 'Input': was expecting (JSON String, Number, Array, Object or token 'null', 'true'"
        + " or 'false')\n" + " at [Source: (String)\"Input\"; line: 1, column: 6]", errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
  }

  /**
   * Test {@link BulkMeasurableItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then return input is lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkMeasurableItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when lf; then return input is lf")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkMeasurableRatingParseResult BulkMeasurableItemParser.parse(String, InputFormat)"})
  void testParse_whenLf_thenReturnInputIsLf() {
    // Arrange and Act
    BulkMeasurableRatingParseResult actualParseResult = (new BulkMeasurableItemParser()).parse("\n", InputFormat.CSV);

    // Assert
    BulkMeasurableRatingParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkMeasurableRatingParseResult);
    assertEquals("Cannot parse an empty string", errorResult.message());
    assertEquals("\n", actualParseResult.input());
    assertEquals(0, errorResult.column().intValue());
    assertEquals(0, errorResult.line().intValue());
  }

  /**
   * Test {@link BulkMeasurableItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return input is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkMeasurableItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when 'null'; then return input is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkMeasurableRatingParseResult BulkMeasurableItemParser.parse(String, InputFormat)"})
  void testParse_whenNull_thenReturnInputIsNull() {
    // Arrange and Act
    BulkMeasurableRatingParseResult actualParseResult = (new BulkMeasurableItemParser()).parse(null, InputFormat.CSV);

    // Assert
    BulkMeasurableRatingParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkMeasurableRatingParseResult);
    assertEquals("Cannot parse an empty string", errorResult.message());
    assertNull(actualParseResult.input());
    assertEquals(0, errorResult.column().intValue());
    assertEquals(0, errorResult.line().intValue());
  }

  /**
   * Test {@link BulkMeasurableItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When {@code #}.</li>
   *   <li>Then return input is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkMeasurableItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when '#'; then return input is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkMeasurableRatingParseResult BulkMeasurableItemParser.parse(String, InputFormat)"})
  void testParse_whenNumberSign_thenReturnInputIsEmptyString() {
    // Arrange and Act
    BulkMeasurableRatingParseResult actualParseResult = (new BulkMeasurableItemParser()).parse("#", InputFormat.JSON);

    // Assert
    assertTrue(actualParseResult instanceof ImmutableBulkMeasurableRatingParseResult);
    assertEquals("", actualParseResult.input());
    assertNull(actualParseResult.error());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link BulkMeasurableItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When {@code #}.</li>
   *   <li>Then return input is {@code #}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkMeasurableItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when '#'; then return input is '#'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkMeasurableRatingParseResult BulkMeasurableItemParser.parse(String, InputFormat)"})
  void testParse_whenNumberSign_thenReturnInputIsNumberSign() {
    // Arrange and Act
    BulkMeasurableRatingParseResult actualParseResult = (new BulkMeasurableItemParser()).parse("#", InputFormat.CSV);

    // Assert
    BulkMeasurableRatingParseError errorResult = actualParseResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertTrue(actualParseResult instanceof ImmutableBulkMeasurableRatingParseResult);
    assertEquals("#", actualParseResult.input());
    assertEquals("Empty header line: can not bind data\n at [Source: (StringReader); line: UNKNOWN, column: UNKNOWN]",
        errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
  }

  /**
   * Test {@link BulkMeasurableItemParser#parse(String, InputFormat)}.
   * <ul>
   *   <li>When {@code TSV}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkMeasurableItemParser#parse(String, InputFormat)}
   */
  @Test
  @DisplayName("Test parse(String, InputFormat); when 'TSV'; then return 'Input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkMeasurableRatingParseResult BulkMeasurableItemParser.parse(String, InputFormat)"})
  void testParse_whenTsv_thenReturnInput() {
    // Arrange and Act
    BulkMeasurableRatingParseResult actualParseResult = (new BulkMeasurableItemParser()).parse("Input",
        InputFormat.TSV);

    // Assert
    assertTrue(actualParseResult instanceof ImmutableBulkMeasurableRatingParseResult);
    assertEquals("Input", actualParseResult.input());
    assertNull(actualParseResult.error());
    assertTrue(actualParseResult.parsedItems().isEmpty());
  }
}
