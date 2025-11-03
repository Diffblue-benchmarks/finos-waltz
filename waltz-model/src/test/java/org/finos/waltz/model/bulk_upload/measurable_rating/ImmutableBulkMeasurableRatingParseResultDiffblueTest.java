package org.finos.waltz.model.bulk_upload.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.bulk_upload.measurable_rating.BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingParseError.Json;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingParseResult.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkMeasurableRatingParseResultDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllParsedItems(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllParsedItems(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllParsedItems(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllParsedItems(Iterable)"})
  void testBuilderAddAllParsedItems_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllParsedItems(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addParsedItems(BulkMeasurableRatingItem)} with {@code element}.
   * <ul>
   *   <li>Then builder build parsedItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addParsedItems(BulkMeasurableRatingItem)}
   */
  @Test
  @DisplayName("Test Builder addParsedItems(BulkMeasurableRatingItem) with 'element'; then builder build parsedItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addParsedItems(BulkMeasurableRatingItem)"})
  void testBuilderAddParsedItemsWithElement_thenBuilderBuildParsedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingItem.Json element = new ImmutableBulkMeasurableRatingItem.Json();

    // Act
    Builder actualAddParsedItemsResult = builderResult.addParsedItems(element);

    // Assert
    List<BulkMeasurableRatingItem> parsedItemsResult = builderResult.build().parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(element, parsedItemsResult.get(0));
    assertSame(builderResult, actualAddParsedItemsResult);
  }

  /**
   * Test Builder {@link Builder#addParsedItems(BulkMeasurableRatingItem[])} with {@code elements}.
   * <ul>
   *   <li>Then builder build parsedItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addParsedItems(BulkMeasurableRatingItem[])}
   */
  @Test
  @DisplayName("Test Builder addParsedItems(BulkMeasurableRatingItem[]) with 'elements'; then builder build parsedItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addParsedItems(BulkMeasurableRatingItem[])"})
  void testBuilderAddParsedItemsWithElements_thenBuilderBuildParsedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingItem.Json json = new ImmutableBulkMeasurableRatingItem.Json();

    // Act
    Builder actualAddParsedItemsResult = builderResult.addParsedItems(json);

    // Assert
    List<BulkMeasurableRatingItem> parsedItemsResult = builderResult.build().parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(json, parsedItemsResult.get(0));
    assertSame(builderResult, actualAddParsedItemsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#error(BulkMeasurableRatingParseError)}
   *   <li>{@link Builder#input(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkMeasurableRatingParseResult Builder.build()",
      "Builder Builder.error(BulkMeasurableRatingParseError)", "Builder Builder.input(String)"})
  void testBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    Json error = new Json();

    // Act
    ImmutableBulkMeasurableRatingParseResult actualBuildResult = builderResult.error(error).input("Input").build();

    // Assert
    assertEquals("Input", actualBuildResult.input());
    assertTrue(actualBuildResult.parsedItems().isEmpty());
    assertSame(error, actualBuildResult.error());
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingParseResult)}.
   * <ul>
   *   <li>Given {@link ImmutableBulkMeasurableRatingItem.Json} (default constructor).</li>
   *   <li>Then return build parsedItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkMeasurableRatingParseResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingParseResult); given Json (default constructor); then return build parsedItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingParseResult)"})
  void testBuilderFrom_givenJson_thenReturnBuildParsedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    Builder builderResult2 = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingItem.Json element = new ImmutableBulkMeasurableRatingItem.Json();
    builderResult2.addParsedItems(element);
    ImmutableBulkMeasurableRatingParseResult instance = builderResult2.error(new Json()).input("Input").build();

    // Act and Assert
    List<BulkMeasurableRatingItem> parsedItemsResult = builderResult.from(instance).build().parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(element, parsedItemsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingParseResult)}.
   * <ul>
   *   <li>Then return build is builder error {@link Json} (default constructor) input {@code Input} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkMeasurableRatingParseResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingParseResult); then return build is builder error Json (default constructor) input 'Input' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingParseResult)"})
  void testBuilderFrom_thenReturnBuildIsBuilderErrorJsonInputInputBuild() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    Builder builderResult2 = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseResult instance = builderResult2.error(new Json()).input("Input").build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingParseResult)}.
   * <ul>
   *   <li>Then return build is builder error {@link Json} (default constructor) input {@code null} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkMeasurableRatingParseResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingParseResult); then return build is builder error Json (default constructor) input 'null' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingParseResult)"})
  void testBuilderFrom_thenReturnBuildIsBuilderErrorJsonInputNullBuild() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    Builder builderResult2 = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseResult instance = builderResult2.error(new Json()).input(null).build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingParseResult)}.
   * <ul>
   *   <li>Then return build is builder error {@code null} input {@code Input} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkMeasurableRatingParseResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingParseResult); then return build is builder error 'null' input 'Input' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingParseResult)"})
  void testBuilderFrom_thenReturnBuildIsBuilderErrorNullInputInputBuild() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseResult instance = ImmutableBulkMeasurableRatingParseResult.builder()
        .error(null)
        .input("Input")
        .build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#parsedItems(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#parsedItems(Iterable)}
   */
  @Test
  @DisplayName("Test Builder parsedItems(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parsedItems(Iterable)"})
  void testBuilderParsedItems_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parsedItems(new ArrayList<>()));
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#copyOf(BulkMeasurableRatingParseResult)}.
   * <ul>
   *   <li>When builder error {@link Json} (default constructor) input {@code Input} build.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkMeasurableRatingParseResult#copyOf(BulkMeasurableRatingParseResult)}
   */
  @Test
  @DisplayName("Test copyOf(BulkMeasurableRatingParseResult); when builder error Json (default constructor) input 'Input' build; then return 'Input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkMeasurableRatingParseResult ImmutableBulkMeasurableRatingParseResult.copyOf(BulkMeasurableRatingParseResult)"})
  void testCopyOf_whenBuilderErrorJsonInputInputBuild_thenReturnInput() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    Json error = new Json();
    ImmutableBulkMeasurableRatingParseResult instance = builderResult.error(error).input("Input").build();

    // Act
    ImmutableBulkMeasurableRatingParseResult actualCopyOfResult = ImmutableBulkMeasurableRatingParseResult
        .copyOf(instance);

    // Assert
    assertEquals("Input", actualCopyOfResult.input());
    assertTrue(actualCopyOfResult.parsedItems().isEmpty());
    assertSame(error, actualCopyOfResult.error());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}, and {@link ImmutableBulkMeasurableRatingParseResult#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}
   *   <li>{@link ImmutableBulkMeasurableRatingParseResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkMeasurableRatingParseResult.equals(Object)",
      "int ImmutableBulkMeasurableRatingParseResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseResult buildResult = builderResult.error(new Json()).input("Input").build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkMeasurableRatingParseResult.equals(Object)",
      "int ImmutableBulkMeasurableRatingParseResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseResult buildResult = builderResult.error(new Json()).input("Input").build();
    Builder builderResult2 = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseResult buildResult2 = builderResult2.error(new Json()).input("Input").build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkMeasurableRatingParseResult.equals(Object)",
      "int ImmutableBulkMeasurableRatingParseResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    builderResult.addParsedItems(new ImmutableBulkMeasurableRatingItem.Json());
    ImmutableBulkMeasurableRatingParseResult buildResult = builderResult.error(new Json()).input("Input").build();
    Builder builderResult2 = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseResult buildResult2 = builderResult2.error(new Json()).input("Input").build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkMeasurableRatingParseResult.equals(Object)",
      "int ImmutableBulkMeasurableRatingParseResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseResult buildResult = builderResult.error(new Json())
        .input("org.finos.waltz.model.bulk_upload.measurable_rating.BulkMeasurableRatingItem")
        .build();
    Builder builderResult2 = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseResult buildResult2 = builderResult2.error(new Json()).input("Input").build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkMeasurableRatingParseResult.equals(Object)",
      "int ImmutableBulkMeasurableRatingParseResult.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseResult buildResult = builderResult.error(new Json()).input("Input").build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkMeasurableRatingParseResult.equals(Object)",
      "int ImmutableBulkMeasurableRatingParseResult.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseResult buildResult = builderResult.error(new Json()).input("Input").build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableBulkMeasurableRatingParseResult");
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableBulkMeasurableRatingItem.Json} (default constructor).</li>
   *   <li>Then return parsedItems is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkMeasurableRatingParseResult#fromJson(ImmutableBulkMeasurableRatingParseResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add Json (default constructor); then return parsedItems is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkMeasurableRatingParseResult ImmutableBulkMeasurableRatingParseResult.fromJson(ImmutableBulkMeasurableRatingParseResult.Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnParsedItemsIsArrayList() {
    // Arrange
    ArrayList<BulkMeasurableRatingItem> parsedItems = new ArrayList<>();
    parsedItems.add(new ImmutableBulkMeasurableRatingItem.Json());

    ImmutableBulkMeasurableRatingParseResult.Json json = new ImmutableBulkMeasurableRatingParseResult.Json();
    json.setParsedItems(parsedItems);
    json.setInput(null);
    json.setError(null);

    // Act and Assert
    assertEquals(parsedItems, ImmutableBulkMeasurableRatingParseResult.fromJson(json).parsedItems());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableBulkMeasurableRatingItem.Json} (default constructor).</li>
   *   <li>Then return parsedItems size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkMeasurableRatingParseResult#fromJson(ImmutableBulkMeasurableRatingParseResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add Json (default constructor); then return parsedItems size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkMeasurableRatingParseResult ImmutableBulkMeasurableRatingParseResult.fromJson(ImmutableBulkMeasurableRatingParseResult.Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnParsedItemsSizeIsTwo() {
    // Arrange
    ArrayList<BulkMeasurableRatingItem> parsedItems = new ArrayList<>();
    parsedItems.add(new ImmutableBulkMeasurableRatingItem.Json());
    ImmutableBulkMeasurableRatingItem.Json json = new ImmutableBulkMeasurableRatingItem.Json();
    parsedItems.add(json);

    ImmutableBulkMeasurableRatingParseResult.Json json2 = new ImmutableBulkMeasurableRatingParseResult.Json();
    json2.setParsedItems(parsedItems);
    json2.setInput(null);
    json2.setError(null);

    // Act and Assert
    List<BulkMeasurableRatingItem> parsedItemsResult = ImmutableBulkMeasurableRatingParseResult.fromJson(json2)
        .parsedItems();
    assertEquals(2, parsedItemsResult.size());
    assertSame(json, parsedItemsResult.get(1));
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link Json} (default constructor).</li>
   *   <li>When {@link ImmutableBulkMeasurableRatingParseResult.Json} (default constructor) Error is {@link Json} (default constructor).</li>
   *   <li>Then return error is {@link Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkMeasurableRatingParseResult#fromJson(ImmutableBulkMeasurableRatingParseResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given Json (default constructor); when Json (default constructor) Error is Json (default constructor); then return error is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkMeasurableRatingParseResult ImmutableBulkMeasurableRatingParseResult.fromJson(ImmutableBulkMeasurableRatingParseResult.Json)"})
  void testFromJson_givenJson_whenJsonErrorIsJson_thenReturnErrorIsJson() {
    // Arrange
    ImmutableBulkMeasurableRatingParseResult.Json json = new ImmutableBulkMeasurableRatingParseResult.Json();
    json.setParsedItems(null);
    json.setInput(null);
    Json error = new Json();
    json.setError(error);

    // Act and Assert
    assertSame(error, ImmutableBulkMeasurableRatingParseResult.fromJson(json).error());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code Json}.</li>
   *   <li>When {@link ImmutableBulkMeasurableRatingParseResult.Json} (default constructor) Input is {@code Json}.</li>
   *   <li>Then return input is {@code Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkMeasurableRatingParseResult#fromJson(ImmutableBulkMeasurableRatingParseResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'Json'; when Json (default constructor) Input is 'Json'; then return input is 'Json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkMeasurableRatingParseResult ImmutableBulkMeasurableRatingParseResult.fromJson(ImmutableBulkMeasurableRatingParseResult.Json)"})
  void testFromJson_givenJson_whenJsonInputIsJson_thenReturnInputIsJson() {
    // Arrange
    ImmutableBulkMeasurableRatingParseResult.Json json = new ImmutableBulkMeasurableRatingParseResult.Json();
    json.setParsedItems(null);
    json.setInput("Json");
    json.setError(null);

    // Act
    ImmutableBulkMeasurableRatingParseResult actualFromJsonResult = ImmutableBulkMeasurableRatingParseResult
        .fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertTrue(actualFromJsonResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ImmutableBulkMeasurableRatingParseResult.Json} (default constructor) ParsedItems is {@code null}.</li>
   *   <li>Then return input is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkMeasurableRatingParseResult#fromJson(ImmutableBulkMeasurableRatingParseResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) ParsedItems is 'null'; then return input is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkMeasurableRatingParseResult ImmutableBulkMeasurableRatingParseResult.fromJson(ImmutableBulkMeasurableRatingParseResult.Json)"})
  void testFromJson_givenNull_whenJsonParsedItemsIsNull_thenReturnInputIsNull() {
    // Arrange
    ImmutableBulkMeasurableRatingParseResult.Json json = new ImmutableBulkMeasurableRatingParseResult.Json();
    json.setParsedItems(null);
    json.setInput(null);
    json.setError(null);

    // Act
    ImmutableBulkMeasurableRatingParseResult actualFromJsonResult = ImmutableBulkMeasurableRatingParseResult
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertTrue(actualFromJsonResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#fromJson(Json)}.
   * <ul>
   *   <li>When {@link ImmutableBulkMeasurableRatingParseResult.Json} (default constructor).</li>
   *   <li>Then return input is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkMeasurableRatingParseResult#fromJson(ImmutableBulkMeasurableRatingParseResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return input is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkMeasurableRatingParseResult ImmutableBulkMeasurableRatingParseResult.fromJson(ImmutableBulkMeasurableRatingParseResult.Json)"})
  void testFromJson_whenJson_thenReturnInputIsNull() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingParseResult actualFromJsonResult = ImmutableBulkMeasurableRatingParseResult
        .fromJson(new ImmutableBulkMeasurableRatingParseResult.Json());

    // Assert
    assertNull(actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertTrue(actualFromJsonResult.parsedItems().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkMeasurableRatingParseResult#toString()}
   *   <li>{@link ImmutableBulkMeasurableRatingParseResult#error()}
   *   <li>{@link ImmutableBulkMeasurableRatingParseResult#input()}
   *   <li>{@link ImmutableBulkMeasurableRatingParseResult#parsedItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkMeasurableRatingParseError ImmutableBulkMeasurableRatingParseResult.error()",
      "String ImmutableBulkMeasurableRatingParseResult.input()",
      "List ImmutableBulkMeasurableRatingParseResult.parsedItems()",
      "String ImmutableBulkMeasurableRatingParseResult.toString()"})
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    Json error = new Json();
    ImmutableBulkMeasurableRatingParseResult buildResult = builderResult.error(error).input("Input").build();

    // Act
    buildResult.toString();
    BulkMeasurableRatingParseError actualErrorResult = buildResult.error();
    String actualInputResult = buildResult.input();

    // Assert
    assertEquals("Input", actualInputResult);
    assertTrue(buildResult.parsedItems().isEmpty());
    assertSame(error, actualErrorResult);
  }

  /**
   * Test Json {@link ImmutableBulkMeasurableRatingParseResult.Json#error()}.
   * <p>
   * Method under test: {@link ImmutableBulkMeasurableRatingParseResult.Json#error()}
   */
  @Test
  @DisplayName("Test Json error()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkMeasurableRatingParseError ImmutableBulkMeasurableRatingParseResult.Json.error()"})
  void testJsonError() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingParseResult.Json()).error());
  }

  /**
   * Test Json {@link ImmutableBulkMeasurableRatingParseResult.Json#input()}.
   * <p>
   * Method under test: {@link ImmutableBulkMeasurableRatingParseResult.Json#input()}
   */
  @Test
  @DisplayName("Test Json input()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ImmutableBulkMeasurableRatingParseResult.Json.input()"})
  void testJsonInput() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingParseResult.Json()).input());
  }

  /**
   * Test Json new {@link ImmutableBulkMeasurableRatingParseResult.Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ImmutableBulkMeasurableRatingParseResult.Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImmutableBulkMeasurableRatingParseResult.Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingParseResult.Json actualJson = new ImmutableBulkMeasurableRatingParseResult.Json();

    // Assert
    assertNull(actualJson.input);
    assertNull(actualJson.error);
    assertTrue(actualJson.parsedItems.isEmpty());
  }

  /**
   * Test Json {@link ImmutableBulkMeasurableRatingParseResult.Json#parsedItems()}.
   * <p>
   * Method under test: {@link ImmutableBulkMeasurableRatingParseResult.Json#parsedItems()}
   */
  @Test
  @DisplayName("Test Json parsedItems()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ImmutableBulkMeasurableRatingParseResult.Json.parsedItems()"})
  void testJsonParsedItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingParseResult.Json()).parsedItems());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#withError(BulkMeasurableRatingParseError)}.
   * <p>
   * Method under test: {@link ImmutableBulkMeasurableRatingParseResult#withError(BulkMeasurableRatingParseError)}
   */
  @Test
  @DisplayName("Test withError(BulkMeasurableRatingParseError)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkMeasurableRatingParseResult ImmutableBulkMeasurableRatingParseResult.withError(BulkMeasurableRatingParseError)"})
  void testWithError() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseResult buildResult = builderResult.error(new Json()).input("Input").build();
    Json value = new Json();

    // Act
    ImmutableBulkMeasurableRatingParseResult actualWithErrorResult = buildResult.withError(value);

    // Assert
    assertEquals("Input", actualWithErrorResult.input());
    assertTrue(actualWithErrorResult.parsedItems().isEmpty());
    assertSame(value, actualWithErrorResult.error());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#withInput(String)}.
   * <ul>
   *   <li>Given builder error {@link Json} (default constructor) input {@code Input} build.</li>
   *   <li>Then return input is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkMeasurableRatingParseResult#withInput(String)}
   */
  @Test
  @DisplayName("Test withInput(String); given builder error Json (default constructor) input 'Input' build; then return input is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkMeasurableRatingParseResult ImmutableBulkMeasurableRatingParseResult.withInput(String)"})
  void testWithInput_givenBuilderErrorJsonInputInputBuild_thenReturnInputIs42() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    Json error = new Json();
    ImmutableBulkMeasurableRatingParseResult buildResult = builderResult.error(error).input("Input").build();

    // Act
    ImmutableBulkMeasurableRatingParseResult actualWithInputResult = buildResult.withInput("42");

    // Assert
    assertEquals("42", actualWithInputResult.input());
    assertTrue(actualWithInputResult.parsedItems().isEmpty());
    assertSame(error, actualWithInputResult.error());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#withInput(String)}.
   * <ul>
   *   <li>Then return builder error {@link Json} (default constructor) input {@code 42} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkMeasurableRatingParseResult#withInput(String)}
   */
  @Test
  @DisplayName("Test withInput(String); then return builder error Json (default constructor) input '42' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkMeasurableRatingParseResult ImmutableBulkMeasurableRatingParseResult.withInput(String)"})
  void testWithInput_thenReturnBuilderErrorJsonInput42Build() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseResult buildResult = builderResult.error(new Json()).input("42").build();

    // Act and Assert
    assertSame(buildResult, buildResult.withInput("42"));
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#withParsedItems(BulkMeasurableRatingItem[])} with {@code BulkMeasurableRatingItem[]}.
   * <ul>
   *   <li>When {@link ImmutableBulkMeasurableRatingItem.Json} (default constructor).</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkMeasurableRatingParseResult#withParsedItems(BulkMeasurableRatingItem[])}
   */
  @Test
  @DisplayName("Test withParsedItems(BulkMeasurableRatingItem[]) with 'BulkMeasurableRatingItem[]'; when Json (default constructor); then return 'Input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkMeasurableRatingParseResult ImmutableBulkMeasurableRatingParseResult.withParsedItems(BulkMeasurableRatingItem[])"})
  void testWithParsedItemsWithBulkMeasurableRatingItem_whenJson_thenReturnInput() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    Json error = new Json();
    ImmutableBulkMeasurableRatingParseResult buildResult = builderResult.error(error).input("Input").build();
    ImmutableBulkMeasurableRatingItem.Json json = new ImmutableBulkMeasurableRatingItem.Json();

    // Act
    ImmutableBulkMeasurableRatingParseResult actualWithParsedItemsResult = buildResult.withParsedItems(json);

    // Assert
    assertEquals("Input", actualWithParsedItemsResult.input());
    List<BulkMeasurableRatingItem> parsedItemsResult = actualWithParsedItemsResult.parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(json, parsedItemsResult.get(0));
    assertSame(error, actualWithParsedItemsResult.error());
  }
}
