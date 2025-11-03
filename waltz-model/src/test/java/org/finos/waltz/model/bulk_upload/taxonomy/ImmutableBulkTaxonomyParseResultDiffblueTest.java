package org.finos.waltz.model.bulk_upload.taxonomy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.bulk_upload.taxonomy.BulkTaxonomyParseResult.BulkTaxonomyParseError;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyParseError.Json;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyParseResult.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkTaxonomyParseResultDiffblueTest {
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
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllParsedItems(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addParsedItems(BulkTaxonomyItem)} with {@code element}.
   * <ul>
   *   <li>Then builder build parsedItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addParsedItems(BulkTaxonomyItem)}
   */
  @Test
  @DisplayName("Test Builder addParsedItems(BulkTaxonomyItem) with 'element'; then builder build parsedItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addParsedItems(BulkTaxonomyItem)"})
  void testBuilderAddParsedItemsWithElement_thenBuilderBuildParsedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyItem.Json element = new ImmutableBulkTaxonomyItem.Json();

    // Act
    Builder actualAddParsedItemsResult = builderResult.addParsedItems(element);

    // Assert
    List<BulkTaxonomyItem> parsedItemsResult = builderResult.build().parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(element, parsedItemsResult.get(0));
    assertSame(builderResult, actualAddParsedItemsResult);
  }

  /**
   * Test Builder {@link Builder#addParsedItems(BulkTaxonomyItem[])} with {@code elements}.
   * <ul>
   *   <li>Then builder build parsedItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addParsedItems(BulkTaxonomyItem[])}
   */
  @Test
  @DisplayName("Test Builder addParsedItems(BulkTaxonomyItem[]) with 'elements'; then builder build parsedItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addParsedItems(BulkTaxonomyItem[])"})
  void testBuilderAddParsedItemsWithElements_thenBuilderBuildParsedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyItem.Json json = new ImmutableBulkTaxonomyItem.Json();

    // Act
    Builder actualAddParsedItemsResult = builderResult.addParsedItems(json);

    // Assert
    List<BulkTaxonomyItem> parsedItemsResult = builderResult.build().parsedItems();
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
   *   <li>{@link Builder#error(BulkTaxonomyParseError)}
   *   <li>{@link Builder#input(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkTaxonomyParseResult Builder.build()",
      "Builder Builder.error(BulkTaxonomyParseError)", "Builder Builder.input(String)"})
  void testBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    Json error = new Json();

    // Act
    ImmutableBulkTaxonomyParseResult actualBuildResult = builderResult.error(error).input("Input").build();

    // Assert
    assertEquals("Input", actualBuildResult.input());
    assertTrue(actualBuildResult.parsedItems().isEmpty());
    assertSame(error, actualBuildResult.error());
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyParseResult)}.
   * <ul>
   *   <li>Given {@link ImmutableBulkTaxonomyItem.Json} (default constructor).</li>
   *   <li>Then return build parsedItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkTaxonomyParseResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyParseResult); given Json (default constructor); then return build parsedItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyParseResult)"})
  void testBuilderFrom_givenJson_thenReturnBuildParsedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    Builder builderResult2 = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyItem.Json element = new ImmutableBulkTaxonomyItem.Json();
    builderResult2.addParsedItems(element);
    ImmutableBulkTaxonomyParseResult instance = builderResult2.error(new Json()).input("Input").build();

    // Act and Assert
    List<BulkTaxonomyItem> parsedItemsResult = builderResult.from(instance).build().parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(element, parsedItemsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyParseResult)}.
   * <ul>
   *   <li>Then return build is builder error {@link Json} (default constructor) input {@code Input} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkTaxonomyParseResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyParseResult); then return build is builder error Json (default constructor) input 'Input' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyParseResult)"})
  void testBuilderFrom_thenReturnBuildIsBuilderErrorJsonInputInputBuild() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    Builder builderResult2 = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseResult instance = builderResult2.error(new Json()).input("Input").build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyParseResult)}.
   * <ul>
   *   <li>Then return build is builder error {@link Json} (default constructor) input {@code null} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkTaxonomyParseResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyParseResult); then return build is builder error Json (default constructor) input 'null' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyParseResult)"})
  void testBuilderFrom_thenReturnBuildIsBuilderErrorJsonInputNullBuild() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    Builder builderResult2 = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseResult instance = builderResult2.error(new Json()).input(null).build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyParseResult)}.
   * <ul>
   *   <li>Then return build is builder error {@code null} input {@code Input} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkTaxonomyParseResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyParseResult); then return build is builder error 'null' input 'Input' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyParseResult)"})
  void testBuilderFrom_thenReturnBuildIsBuilderErrorNullInputInputBuild() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseResult instance = ImmutableBulkTaxonomyParseResult.builder()
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
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parsedItems(new ArrayList<>()));
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#copyOf(BulkTaxonomyParseResult)}.
   * <ul>
   *   <li>When builder error {@link Json} (default constructor) input {@code Input} build.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyParseResult#copyOf(BulkTaxonomyParseResult)}
   */
  @Test
  @DisplayName("Test copyOf(BulkTaxonomyParseResult); when builder error Json (default constructor) input 'Input' build; then return 'Input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkTaxonomyParseResult ImmutableBulkTaxonomyParseResult.copyOf(BulkTaxonomyParseResult)"})
  void testCopyOf_whenBuilderErrorJsonInputInputBuild_thenReturnInput() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    Json error = new Json();
    ImmutableBulkTaxonomyParseResult instance = builderResult.error(error).input("Input").build();

    // Act
    ImmutableBulkTaxonomyParseResult actualCopyOfResult = ImmutableBulkTaxonomyParseResult.copyOf(instance);

    // Assert
    assertEquals("Input", actualCopyOfResult.input());
    assertTrue(actualCopyOfResult.parsedItems().isEmpty());
    assertSame(error, actualCopyOfResult.error());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#equals(Object)}, and {@link ImmutableBulkTaxonomyParseResult#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyParseResult#equals(Object)}
   *   <li>{@link ImmutableBulkTaxonomyParseResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkTaxonomyParseResult.equals(Object)",
      "int ImmutableBulkTaxonomyParseResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseResult buildResult = builderResult.error(new Json()).input("Input").build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyParseResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkTaxonomyParseResult.equals(Object)",
      "int ImmutableBulkTaxonomyParseResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseResult buildResult = builderResult.error(new Json()).input("Input").build();
    Builder builderResult2 = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseResult buildResult2 = builderResult2.error(new Json()).input("Input").build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyParseResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkTaxonomyParseResult.equals(Object)",
      "int ImmutableBulkTaxonomyParseResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    builderResult.addParsedItems(new ImmutableBulkTaxonomyItem.Json());
    ImmutableBulkTaxonomyParseResult buildResult = builderResult.error(new Json()).input("Input").build();
    Builder builderResult2 = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseResult buildResult2 = builderResult2.error(new Json()).input("Input").build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyParseResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkTaxonomyParseResult.equals(Object)",
      "int ImmutableBulkTaxonomyParseResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseResult buildResult = builderResult.error(new Json())
        .input("org.finos.waltz.model.bulk_upload.taxonomy.BulkTaxonomyItem")
        .build();
    Builder builderResult2 = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseResult buildResult2 = builderResult2.error(new Json()).input("Input").build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyParseResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkTaxonomyParseResult.equals(Object)",
      "int ImmutableBulkTaxonomyParseResult.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseResult buildResult = builderResult.error(new Json()).input("Input").build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyParseResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkTaxonomyParseResult.equals(Object)",
      "int ImmutableBulkTaxonomyParseResult.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseResult buildResult = builderResult.error(new Json()).input("Input").build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableBulkTaxonomyParseResult");
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableBulkTaxonomyItem.Json} (default constructor).</li>
   *   <li>Then return parsedItems is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyParseResult#fromJson(ImmutableBulkTaxonomyParseResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add Json (default constructor); then return parsedItems is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkTaxonomyParseResult ImmutableBulkTaxonomyParseResult.fromJson(ImmutableBulkTaxonomyParseResult.Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnParsedItemsIsArrayList() {
    // Arrange
    ArrayList<BulkTaxonomyItem> parsedItems = new ArrayList<>();
    parsedItems.add(new ImmutableBulkTaxonomyItem.Json());

    ImmutableBulkTaxonomyParseResult.Json json = new ImmutableBulkTaxonomyParseResult.Json();
    json.setParsedItems(parsedItems);
    json.setInput(null);
    json.setError(null);

    // Act and Assert
    assertEquals(parsedItems, ImmutableBulkTaxonomyParseResult.fromJson(json).parsedItems());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableBulkTaxonomyItem.Json} (default constructor).</li>
   *   <li>Then return parsedItems size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyParseResult#fromJson(ImmutableBulkTaxonomyParseResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add Json (default constructor); then return parsedItems size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkTaxonomyParseResult ImmutableBulkTaxonomyParseResult.fromJson(ImmutableBulkTaxonomyParseResult.Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnParsedItemsSizeIsTwo() {
    // Arrange
    ArrayList<BulkTaxonomyItem> parsedItems = new ArrayList<>();
    parsedItems.add(new ImmutableBulkTaxonomyItem.Json());
    ImmutableBulkTaxonomyItem.Json json = new ImmutableBulkTaxonomyItem.Json();
    parsedItems.add(json);

    ImmutableBulkTaxonomyParseResult.Json json2 = new ImmutableBulkTaxonomyParseResult.Json();
    json2.setParsedItems(parsedItems);
    json2.setInput(null);
    json2.setError(null);

    // Act and Assert
    List<BulkTaxonomyItem> parsedItemsResult = ImmutableBulkTaxonomyParseResult.fromJson(json2).parsedItems();
    assertEquals(2, parsedItemsResult.size());
    assertSame(json, parsedItemsResult.get(1));
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link Json} (default constructor).</li>
   *   <li>When {@link ImmutableBulkTaxonomyParseResult.Json} (default constructor) Error is {@link Json} (default constructor).</li>
   *   <li>Then return error is {@link Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyParseResult#fromJson(ImmutableBulkTaxonomyParseResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given Json (default constructor); when Json (default constructor) Error is Json (default constructor); then return error is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkTaxonomyParseResult ImmutableBulkTaxonomyParseResult.fromJson(ImmutableBulkTaxonomyParseResult.Json)"})
  void testFromJson_givenJson_whenJsonErrorIsJson_thenReturnErrorIsJson() {
    // Arrange
    ImmutableBulkTaxonomyParseResult.Json json = new ImmutableBulkTaxonomyParseResult.Json();
    json.setParsedItems(null);
    json.setInput(null);
    Json error = new Json();
    json.setError(error);

    // Act and Assert
    assertSame(error, ImmutableBulkTaxonomyParseResult.fromJson(json).error());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code Json}.</li>
   *   <li>When {@link ImmutableBulkTaxonomyParseResult.Json} (default constructor) Input is {@code Json}.</li>
   *   <li>Then return input is {@code Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyParseResult#fromJson(ImmutableBulkTaxonomyParseResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'Json'; when Json (default constructor) Input is 'Json'; then return input is 'Json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkTaxonomyParseResult ImmutableBulkTaxonomyParseResult.fromJson(ImmutableBulkTaxonomyParseResult.Json)"})
  void testFromJson_givenJson_whenJsonInputIsJson_thenReturnInputIsJson() {
    // Arrange
    ImmutableBulkTaxonomyParseResult.Json json = new ImmutableBulkTaxonomyParseResult.Json();
    json.setParsedItems(null);
    json.setInput("Json");
    json.setError(null);

    // Act
    ImmutableBulkTaxonomyParseResult actualFromJsonResult = ImmutableBulkTaxonomyParseResult.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertTrue(actualFromJsonResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ImmutableBulkTaxonomyParseResult.Json} (default constructor) ParsedItems is {@code null}.</li>
   *   <li>Then return input is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyParseResult#fromJson(ImmutableBulkTaxonomyParseResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) ParsedItems is 'null'; then return input is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkTaxonomyParseResult ImmutableBulkTaxonomyParseResult.fromJson(ImmutableBulkTaxonomyParseResult.Json)"})
  void testFromJson_givenNull_whenJsonParsedItemsIsNull_thenReturnInputIsNull() {
    // Arrange
    ImmutableBulkTaxonomyParseResult.Json json = new ImmutableBulkTaxonomyParseResult.Json();
    json.setParsedItems(null);
    json.setInput(null);
    json.setError(null);

    // Act
    ImmutableBulkTaxonomyParseResult actualFromJsonResult = ImmutableBulkTaxonomyParseResult.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertTrue(actualFromJsonResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#fromJson(Json)}.
   * <ul>
   *   <li>When {@link ImmutableBulkTaxonomyParseResult.Json} (default constructor).</li>
   *   <li>Then return input is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyParseResult#fromJson(ImmutableBulkTaxonomyParseResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return input is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkTaxonomyParseResult ImmutableBulkTaxonomyParseResult.fromJson(ImmutableBulkTaxonomyParseResult.Json)"})
  void testFromJson_whenJson_thenReturnInputIsNull() {
    // Arrange and Act
    ImmutableBulkTaxonomyParseResult actualFromJsonResult = ImmutableBulkTaxonomyParseResult
        .fromJson(new ImmutableBulkTaxonomyParseResult.Json());

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
   *   <li>{@link ImmutableBulkTaxonomyParseResult#toString()}
   *   <li>{@link ImmutableBulkTaxonomyParseResult#error()}
   *   <li>{@link ImmutableBulkTaxonomyParseResult#input()}
   *   <li>{@link ImmutableBulkTaxonomyParseResult#parsedItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkTaxonomyParseError ImmutableBulkTaxonomyParseResult.error()",
      "String ImmutableBulkTaxonomyParseResult.input()", "List ImmutableBulkTaxonomyParseResult.parsedItems()",
      "String ImmutableBulkTaxonomyParseResult.toString()"})
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    Json error = new Json();
    ImmutableBulkTaxonomyParseResult buildResult = builderResult.error(error).input("Input").build();

    // Act
    buildResult.toString();
    BulkTaxonomyParseError actualErrorResult = buildResult.error();
    String actualInputResult = buildResult.input();

    // Assert
    assertEquals("Input", actualInputResult);
    assertTrue(buildResult.parsedItems().isEmpty());
    assertSame(error, actualErrorResult);
  }

  /**
   * Test Json {@link ImmutableBulkTaxonomyParseResult.Json#error()}.
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyParseResult.Json#error()}
   */
  @Test
  @DisplayName("Test Json error()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkTaxonomyParseError ImmutableBulkTaxonomyParseResult.Json.error()"})
  void testJsonError() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkTaxonomyParseResult.Json()).error());
  }

  /**
   * Test Json {@link ImmutableBulkTaxonomyParseResult.Json#input()}.
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyParseResult.Json#input()}
   */
  @Test
  @DisplayName("Test Json input()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ImmutableBulkTaxonomyParseResult.Json.input()"})
  void testJsonInput() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkTaxonomyParseResult.Json()).input());
  }

  /**
   * Test Json new {@link ImmutableBulkTaxonomyParseResult.Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ImmutableBulkTaxonomyParseResult.Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImmutableBulkTaxonomyParseResult.Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableBulkTaxonomyParseResult.Json actualJson = new ImmutableBulkTaxonomyParseResult.Json();

    // Assert
    assertNull(actualJson.input);
    assertNull(actualJson.error);
    assertTrue(actualJson.parsedItems.isEmpty());
  }

  /**
   * Test Json {@link ImmutableBulkTaxonomyParseResult.Json#parsedItems()}.
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyParseResult.Json#parsedItems()}
   */
  @Test
  @DisplayName("Test Json parsedItems()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ImmutableBulkTaxonomyParseResult.Json.parsedItems()"})
  void testJsonParsedItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkTaxonomyParseResult.Json()).parsedItems());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#withError(BulkTaxonomyParseError)}.
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyParseResult#withError(BulkTaxonomyParseError)}
   */
  @Test
  @DisplayName("Test withError(BulkTaxonomyParseError)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkTaxonomyParseResult ImmutableBulkTaxonomyParseResult.withError(BulkTaxonomyParseError)"})
  void testWithError() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseResult buildResult = builderResult.error(new Json()).input("Input").build();
    Json value = new Json();

    // Act
    ImmutableBulkTaxonomyParseResult actualWithErrorResult = buildResult.withError(value);

    // Assert
    assertEquals("Input", actualWithErrorResult.input());
    assertTrue(actualWithErrorResult.parsedItems().isEmpty());
    assertSame(value, actualWithErrorResult.error());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#withInput(String)}.
   * <ul>
   *   <li>Given builder error {@link Json} (default constructor) input {@code Input} build.</li>
   *   <li>Then return input is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyParseResult#withInput(String)}
   */
  @Test
  @DisplayName("Test withInput(String); given builder error Json (default constructor) input 'Input' build; then return input is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkTaxonomyParseResult ImmutableBulkTaxonomyParseResult.withInput(String)"})
  void testWithInput_givenBuilderErrorJsonInputInputBuild_thenReturnInputIs42() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    Json error = new Json();
    ImmutableBulkTaxonomyParseResult buildResult = builderResult.error(error).input("Input").build();

    // Act
    ImmutableBulkTaxonomyParseResult actualWithInputResult = buildResult.withInput("42");

    // Assert
    assertEquals("42", actualWithInputResult.input());
    assertTrue(actualWithInputResult.parsedItems().isEmpty());
    assertSame(error, actualWithInputResult.error());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#withInput(String)}.
   * <ul>
   *   <li>Then return builder error {@link Json} (default constructor) input {@code 42} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyParseResult#withInput(String)}
   */
  @Test
  @DisplayName("Test withInput(String); then return builder error Json (default constructor) input '42' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkTaxonomyParseResult ImmutableBulkTaxonomyParseResult.withInput(String)"})
  void testWithInput_thenReturnBuilderErrorJsonInput42Build() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseResult buildResult = builderResult.error(new Json()).input("42").build();

    // Act and Assert
    assertSame(buildResult, buildResult.withInput("42"));
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#withParsedItems(BulkTaxonomyItem[])} with {@code BulkTaxonomyItem[]}.
   * <ul>
   *   <li>When {@link ImmutableBulkTaxonomyItem.Json} (default constructor).</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyParseResult#withParsedItems(BulkTaxonomyItem[])}
   */
  @Test
  @DisplayName("Test withParsedItems(BulkTaxonomyItem[]) with 'BulkTaxonomyItem[]'; when Json (default constructor); then return 'Input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkTaxonomyParseResult ImmutableBulkTaxonomyParseResult.withParsedItems(BulkTaxonomyItem[])"})
  void testWithParsedItemsWithBulkTaxonomyItem_whenJson_thenReturnInput() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    Json error = new Json();
    ImmutableBulkTaxonomyParseResult buildResult = builderResult.error(error).input("Input").build();
    ImmutableBulkTaxonomyItem.Json json = new ImmutableBulkTaxonomyItem.Json();

    // Act
    ImmutableBulkTaxonomyParseResult actualWithParsedItemsResult = buildResult.withParsedItems(json);

    // Assert
    assertEquals("Input", actualWithParsedItemsResult.input());
    List<BulkTaxonomyItem> parsedItemsResult = actualWithParsedItemsResult.parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(json, parsedItemsResult.get(0));
    assertSame(error, actualWithParsedItemsResult.error());
  }
}
