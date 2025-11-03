package org.finos.waltz.model.assessment_rating.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.assessment_rating.bulk_upload.AssessmentRatingParsedResult.AssessmentRatingParseError;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmentRatingParseError.Json;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmentRatingParsedResult.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingParsedResultDiffblueTest {
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
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllParsedItems(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addParsedItems(AssessmentRatingParsedItem)} with {@code element}.
   * <ul>
   *   <li>Then builder build parsedItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addParsedItems(AssessmentRatingParsedItem)}
   */
  @Test
  @DisplayName("Test Builder addParsedItems(AssessmentRatingParsedItem) with 'element'; then builder build parsedItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addParsedItems(AssessmentRatingParsedItem)"})
  void testBuilderAddParsedItemsWithElement_thenBuilderBuildParsedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedItem.Json element = new ImmutableAssessmentRatingParsedItem.Json();

    // Act
    Builder actualAddParsedItemsResult = builderResult.addParsedItems(element);

    // Assert
    List<AssessmentRatingParsedItem> parsedItemsResult = builderResult.build().parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(element, parsedItemsResult.get(0));
    assertSame(builderResult, actualAddParsedItemsResult);
  }

  /**
   * Test Builder {@link Builder#addParsedItems(AssessmentRatingParsedItem[])} with {@code elements}.
   * <ul>
   *   <li>Then builder build parsedItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addParsedItems(AssessmentRatingParsedItem[])}
   */
  @Test
  @DisplayName("Test Builder addParsedItems(AssessmentRatingParsedItem[]) with 'elements'; then builder build parsedItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addParsedItems(AssessmentRatingParsedItem[])"})
  void testBuilderAddParsedItemsWithElements_thenBuilderBuildParsedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedItem.Json json = new ImmutableAssessmentRatingParsedItem.Json();

    // Act
    Builder actualAddParsedItemsResult = builderResult.addParsedItems(json);

    // Assert
    List<AssessmentRatingParsedItem> parsedItemsResult = builderResult.build().parsedItems();
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
   *   <li>{@link Builder#error(AssessmentRatingParseError)}
   *   <li>{@link Builder#input(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAssessmentRatingParsedResult Builder.build()",
      "Builder Builder.error(AssessmentRatingParseError)", "Builder Builder.input(String)"})
  void testBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    Json error = new Json();

    // Act
    ImmutableAssessmentRatingParsedResult actualBuildResult = builderResult.error(error).input("Input").build();

    // Assert
    assertEquals("Input", actualBuildResult.input());
    assertTrue(actualBuildResult.parsedItems().isEmpty());
    assertSame(error, actualBuildResult.error());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingParsedResult)}.
   * <ul>
   *   <li>Given {@link ImmutableAssessmentRatingParsedItem.Json} (default constructor).</li>
   *   <li>Then return build parsedItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingParsedResult)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingParsedResult); given Json (default constructor); then return build parsedItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingParsedResult)"})
  void testBuilderFrom_givenJson_thenReturnBuildParsedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    Builder builderResult2 = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedItem.Json element = new ImmutableAssessmentRatingParsedItem.Json();
    builderResult2.addParsedItems(element);
    ImmutableAssessmentRatingParsedResult instance = builderResult2.error(new Json()).input("Input").build();

    // Act and Assert
    List<AssessmentRatingParsedItem> parsedItemsResult = builderResult.from(instance).build().parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(element, parsedItemsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingParsedResult)}.
   * <ul>
   *   <li>Then return build is builder error {@link Json} (default constructor) input {@code Input} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingParsedResult)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingParsedResult); then return build is builder error Json (default constructor) input 'Input' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingParsedResult)"})
  void testBuilderFrom_thenReturnBuildIsBuilderErrorJsonInputInputBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    Builder builderResult2 = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedResult instance = builderResult2.error(new Json()).input("Input").build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingParsedResult)}.
   * <ul>
   *   <li>Then return build is builder error {@link Json} (default constructor) input {@code null} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingParsedResult)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingParsedResult); then return build is builder error Json (default constructor) input 'null' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingParsedResult)"})
  void testBuilderFrom_thenReturnBuildIsBuilderErrorJsonInputNullBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    Builder builderResult2 = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedResult instance = builderResult2.error(new Json()).input(null).build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingParsedResult)}.
   * <ul>
   *   <li>Then return build is builder error {@code null} input {@code Input} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingParsedResult)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingParsedResult); then return build is builder error 'null' input 'Input' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingParsedResult)"})
  void testBuilderFrom_thenReturnBuildIsBuilderErrorNullInputInputBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedResult instance = ImmutableAssessmentRatingParsedResult.builder()
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
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parsedItems(new ArrayList<>()));
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#copyOf(AssessmentRatingParsedResult)}.
   * <ul>
   *   <li>When builder error {@link Json} (default constructor) input {@code Input} build.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingParsedResult#copyOf(AssessmentRatingParsedResult)}
   */
  @Test
  @DisplayName("Test copyOf(AssessmentRatingParsedResult); when builder error Json (default constructor) input 'Input' build; then return 'Input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentRatingParsedResult ImmutableAssessmentRatingParsedResult.copyOf(AssessmentRatingParsedResult)"})
  void testCopyOf_whenBuilderErrorJsonInputInputBuild_thenReturnInput() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    Json error = new Json();
    ImmutableAssessmentRatingParsedResult instance = builderResult.error(error).input("Input").build();

    // Act
    ImmutableAssessmentRatingParsedResult actualCopyOfResult = ImmutableAssessmentRatingParsedResult.copyOf(instance);

    // Assert
    assertEquals("Input", actualCopyOfResult.input());
    assertTrue(actualCopyOfResult.parsedItems().isEmpty());
    assertSame(error, actualCopyOfResult.error());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#equals(Object)}, and {@link ImmutableAssessmentRatingParsedResult#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingParsedResult#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingParsedResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAssessmentRatingParsedResult.equals(Object)",
      "int ImmutableAssessmentRatingParsedResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedResult buildResult = builderResult.error(new Json()).input("Input").build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingParsedResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAssessmentRatingParsedResult.equals(Object)",
      "int ImmutableAssessmentRatingParsedResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedResult buildResult = builderResult.error(new Json()).input("Input").build();
    Builder builderResult2 = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedResult buildResult2 = builderResult2.error(new Json()).input("Input").build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingParsedResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAssessmentRatingParsedResult.equals(Object)",
      "int ImmutableAssessmentRatingParsedResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    builderResult.addParsedItems(new ImmutableAssessmentRatingParsedItem.Json());
    ImmutableAssessmentRatingParsedResult buildResult = builderResult.error(new Json()).input("Input").build();
    Builder builderResult2 = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedResult buildResult2 = builderResult2.error(new Json()).input("Input").build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingParsedResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAssessmentRatingParsedResult.equals(Object)",
      "int ImmutableAssessmentRatingParsedResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedResult buildResult = builderResult.error(new Json())
        .input("org.finos.waltz.model.assessment_rating.bulk_upload.AssessmentRatingParsedItem")
        .build();
    Builder builderResult2 = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedResult buildResult2 = builderResult2.error(new Json()).input("Input").build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingParsedResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAssessmentRatingParsedResult.equals(Object)",
      "int ImmutableAssessmentRatingParsedResult.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedResult buildResult = builderResult.error(new Json()).input("Input").build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingParsedResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAssessmentRatingParsedResult.equals(Object)",
      "int ImmutableAssessmentRatingParsedResult.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedResult buildResult = builderResult.error(new Json()).input("Input").build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableAssessmentRatingParsedResult");
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableAssessmentRatingParsedItem.Json} (default constructor).</li>
   *   <li>Then return parsedItems is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingParsedResult#fromJson(ImmutableAssessmentRatingParsedResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add Json (default constructor); then return parsedItems is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentRatingParsedResult ImmutableAssessmentRatingParsedResult.fromJson(ImmutableAssessmentRatingParsedResult.Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnParsedItemsIsArrayList() {
    // Arrange
    ArrayList<AssessmentRatingParsedItem> parsedItems = new ArrayList<>();
    parsedItems.add(new ImmutableAssessmentRatingParsedItem.Json());

    ImmutableAssessmentRatingParsedResult.Json json = new ImmutableAssessmentRatingParsedResult.Json();
    json.setParsedItems(parsedItems);
    json.setInput(null);
    json.setError(null);

    // Act and Assert
    assertEquals(parsedItems, ImmutableAssessmentRatingParsedResult.fromJson(json).parsedItems());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableAssessmentRatingParsedItem.Json} (default constructor).</li>
   *   <li>Then return parsedItems size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingParsedResult#fromJson(ImmutableAssessmentRatingParsedResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add Json (default constructor); then return parsedItems size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentRatingParsedResult ImmutableAssessmentRatingParsedResult.fromJson(ImmutableAssessmentRatingParsedResult.Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnParsedItemsSizeIsTwo() {
    // Arrange
    ArrayList<AssessmentRatingParsedItem> parsedItems = new ArrayList<>();
    parsedItems.add(new ImmutableAssessmentRatingParsedItem.Json());
    ImmutableAssessmentRatingParsedItem.Json json = new ImmutableAssessmentRatingParsedItem.Json();
    parsedItems.add(json);

    ImmutableAssessmentRatingParsedResult.Json json2 = new ImmutableAssessmentRatingParsedResult.Json();
    json2.setParsedItems(parsedItems);
    json2.setInput(null);
    json2.setError(null);

    // Act and Assert
    List<AssessmentRatingParsedItem> parsedItemsResult = ImmutableAssessmentRatingParsedResult.fromJson(json2)
        .parsedItems();
    assertEquals(2, parsedItemsResult.size());
    assertSame(json, parsedItemsResult.get(1));
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link Json} (default constructor).</li>
   *   <li>When {@link ImmutableAssessmentRatingParsedResult.Json} (default constructor) Error is {@link Json} (default constructor).</li>
   *   <li>Then return error is {@link Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingParsedResult#fromJson(ImmutableAssessmentRatingParsedResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given Json (default constructor); when Json (default constructor) Error is Json (default constructor); then return error is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentRatingParsedResult ImmutableAssessmentRatingParsedResult.fromJson(ImmutableAssessmentRatingParsedResult.Json)"})
  void testFromJson_givenJson_whenJsonErrorIsJson_thenReturnErrorIsJson() {
    // Arrange
    ImmutableAssessmentRatingParsedResult.Json json = new ImmutableAssessmentRatingParsedResult.Json();
    json.setParsedItems(null);
    json.setInput(null);
    Json error = new Json();
    json.setError(error);

    // Act and Assert
    assertSame(error, ImmutableAssessmentRatingParsedResult.fromJson(json).error());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code Json}.</li>
   *   <li>When {@link ImmutableAssessmentRatingParsedResult.Json} (default constructor) Input is {@code Json}.</li>
   *   <li>Then return input is {@code Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingParsedResult#fromJson(ImmutableAssessmentRatingParsedResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'Json'; when Json (default constructor) Input is 'Json'; then return input is 'Json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentRatingParsedResult ImmutableAssessmentRatingParsedResult.fromJson(ImmutableAssessmentRatingParsedResult.Json)"})
  void testFromJson_givenJson_whenJsonInputIsJson_thenReturnInputIsJson() {
    // Arrange
    ImmutableAssessmentRatingParsedResult.Json json = new ImmutableAssessmentRatingParsedResult.Json();
    json.setParsedItems(null);
    json.setInput("Json");
    json.setError(null);

    // Act
    ImmutableAssessmentRatingParsedResult actualFromJsonResult = ImmutableAssessmentRatingParsedResult.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertTrue(actualFromJsonResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ImmutableAssessmentRatingParsedResult.Json} (default constructor) ParsedItems is {@code null}.</li>
   *   <li>Then return input is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingParsedResult#fromJson(ImmutableAssessmentRatingParsedResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) ParsedItems is 'null'; then return input is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentRatingParsedResult ImmutableAssessmentRatingParsedResult.fromJson(ImmutableAssessmentRatingParsedResult.Json)"})
  void testFromJson_givenNull_whenJsonParsedItemsIsNull_thenReturnInputIsNull() {
    // Arrange
    ImmutableAssessmentRatingParsedResult.Json json = new ImmutableAssessmentRatingParsedResult.Json();
    json.setParsedItems(null);
    json.setInput(null);
    json.setError(null);

    // Act
    ImmutableAssessmentRatingParsedResult actualFromJsonResult = ImmutableAssessmentRatingParsedResult.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertTrue(actualFromJsonResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#fromJson(Json)}.
   * <ul>
   *   <li>When {@link ImmutableAssessmentRatingParsedResult.Json} (default constructor).</li>
   *   <li>Then return input is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingParsedResult#fromJson(ImmutableAssessmentRatingParsedResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return input is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentRatingParsedResult ImmutableAssessmentRatingParsedResult.fromJson(ImmutableAssessmentRatingParsedResult.Json)"})
  void testFromJson_whenJson_thenReturnInputIsNull() {
    // Arrange and Act
    ImmutableAssessmentRatingParsedResult actualFromJsonResult = ImmutableAssessmentRatingParsedResult
        .fromJson(new ImmutableAssessmentRatingParsedResult.Json());

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
   *   <li>{@link ImmutableAssessmentRatingParsedResult#toString()}
   *   <li>{@link ImmutableAssessmentRatingParsedResult#error()}
   *   <li>{@link ImmutableAssessmentRatingParsedResult#input()}
   *   <li>{@link ImmutableAssessmentRatingParsedResult#parsedItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssessmentRatingParseError ImmutableAssessmentRatingParsedResult.error()",
      "String ImmutableAssessmentRatingParsedResult.input()",
      "List ImmutableAssessmentRatingParsedResult.parsedItems()",
      "String ImmutableAssessmentRatingParsedResult.toString()"})
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    Json error = new Json();
    ImmutableAssessmentRatingParsedResult buildResult = builderResult.error(error).input("Input").build();

    // Act
    buildResult.toString();
    AssessmentRatingParseError actualErrorResult = buildResult.error();
    String actualInputResult = buildResult.input();

    // Assert
    assertEquals("Input", actualInputResult);
    assertTrue(buildResult.parsedItems().isEmpty());
    assertSame(error, actualErrorResult);
  }

  /**
   * Test Json {@link ImmutableAssessmentRatingParsedResult.Json#error()}.
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingParsedResult.Json#error()}
   */
  @Test
  @DisplayName("Test Json error()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssessmentRatingParseError ImmutableAssessmentRatingParsedResult.Json.error()"})
  void testJsonError() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentRatingParsedResult.Json()).error());
  }

  /**
   * Test Json {@link ImmutableAssessmentRatingParsedResult.Json#input()}.
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingParsedResult.Json#input()}
   */
  @Test
  @DisplayName("Test Json input()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ImmutableAssessmentRatingParsedResult.Json.input()"})
  void testJsonInput() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentRatingParsedResult.Json()).input());
  }

  /**
   * Test Json new {@link ImmutableAssessmentRatingParsedResult.Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ImmutableAssessmentRatingParsedResult.Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImmutableAssessmentRatingParsedResult.Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAssessmentRatingParsedResult.Json actualJson = new ImmutableAssessmentRatingParsedResult.Json();

    // Assert
    assertNull(actualJson.input);
    assertNull(actualJson.error);
    assertTrue(actualJson.parsedItems.isEmpty());
  }

  /**
   * Test Json {@link ImmutableAssessmentRatingParsedResult.Json#parsedItems()}.
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingParsedResult.Json#parsedItems()}
   */
  @Test
  @DisplayName("Test Json parsedItems()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ImmutableAssessmentRatingParsedResult.Json.parsedItems()"})
  void testJsonParsedItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingParsedResult.Json()).parsedItems());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#withError(AssessmentRatingParseError)}.
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingParsedResult#withError(AssessmentRatingParseError)}
   */
  @Test
  @DisplayName("Test withError(AssessmentRatingParseError)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentRatingParsedResult ImmutableAssessmentRatingParsedResult.withError(AssessmentRatingParseError)"})
  void testWithError() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedResult buildResult = builderResult.error(new Json()).input("Input").build();
    Json value = new Json();

    // Act
    ImmutableAssessmentRatingParsedResult actualWithErrorResult = buildResult.withError(value);

    // Assert
    assertEquals("Input", actualWithErrorResult.input());
    assertTrue(actualWithErrorResult.parsedItems().isEmpty());
    assertSame(value, actualWithErrorResult.error());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#withInput(String)}.
   * <ul>
   *   <li>Given builder error {@link Json} (default constructor) input {@code Input} build.</li>
   *   <li>Then return input is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingParsedResult#withInput(String)}
   */
  @Test
  @DisplayName("Test withInput(String); given builder error Json (default constructor) input 'Input' build; then return input is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAssessmentRatingParsedResult ImmutableAssessmentRatingParsedResult.withInput(String)"})
  void testWithInput_givenBuilderErrorJsonInputInputBuild_thenReturnInputIs42() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    Json error = new Json();
    ImmutableAssessmentRatingParsedResult buildResult = builderResult.error(error).input("Input").build();

    // Act
    ImmutableAssessmentRatingParsedResult actualWithInputResult = buildResult.withInput("42");

    // Assert
    assertEquals("42", actualWithInputResult.input());
    assertTrue(actualWithInputResult.parsedItems().isEmpty());
    assertSame(error, actualWithInputResult.error());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#withInput(String)}.
   * <ul>
   *   <li>Then return builder error {@link Json} (default constructor) input {@code 42} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingParsedResult#withInput(String)}
   */
  @Test
  @DisplayName("Test withInput(String); then return builder error Json (default constructor) input '42' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAssessmentRatingParsedResult ImmutableAssessmentRatingParsedResult.withInput(String)"})
  void testWithInput_thenReturnBuilderErrorJsonInput42Build() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedResult buildResult = builderResult.error(new Json()).input("42").build();

    // Act and Assert
    assertSame(buildResult, buildResult.withInput("42"));
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#withParsedItems(AssessmentRatingParsedItem[])} with {@code AssessmentRatingParsedItem[]}.
   * <ul>
   *   <li>When {@link ImmutableAssessmentRatingParsedItem.Json} (default constructor).</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingParsedResult#withParsedItems(AssessmentRatingParsedItem[])}
   */
  @Test
  @DisplayName("Test withParsedItems(AssessmentRatingParsedItem[]) with 'AssessmentRatingParsedItem[]'; when Json (default constructor); then return 'Input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentRatingParsedResult ImmutableAssessmentRatingParsedResult.withParsedItems(AssessmentRatingParsedItem[])"})
  void testWithParsedItemsWithAssessmentRatingParsedItem_whenJson_thenReturnInput() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    Json error = new Json();
    ImmutableAssessmentRatingParsedResult buildResult = builderResult.error(error).input("Input").build();
    ImmutableAssessmentRatingParsedItem.Json json = new ImmutableAssessmentRatingParsedItem.Json();

    // Act
    ImmutableAssessmentRatingParsedResult actualWithParsedItemsResult = buildResult.withParsedItems(json);

    // Assert
    assertEquals("Input", actualWithParsedItemsResult.input());
    List<AssessmentRatingParsedItem> parsedItemsResult = actualWithParsedItemsResult.parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(error, actualWithParsedItemsResult.error());
    assertSame(json, parsedItemsResult.get(0));
  }
}
