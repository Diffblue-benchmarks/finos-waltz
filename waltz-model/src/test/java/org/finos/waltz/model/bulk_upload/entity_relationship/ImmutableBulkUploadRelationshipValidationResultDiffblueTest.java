package org.finos.waltz.model.bulk_upload.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.bulk_upload.entity_relationship.BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipParseError.Json;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipValidationResult.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkUploadRelationshipValidationResultDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllValidatedItems(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllValidatedItems(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllValidatedItems(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllValidatedItems(Iterable)"})
  void testBuilderAddAllValidatedItems_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllValidatedItems(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addValidatedItems(BulkUploadRelationshipValidatedItem)} with {@code element}.
   * <ul>
   *   <li>Then builder build validatedItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addValidatedItems(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder addValidatedItems(BulkUploadRelationshipValidatedItem) with 'element'; then builder build validatedItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addValidatedItems(BulkUploadRelationshipValidatedItem)"})
  void testBuilderAddValidatedItemsWithElement_thenBuilderBuildValidatedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();
    ImmutableBulkUploadRelationshipValidatedItem.Json element = new ImmutableBulkUploadRelationshipValidatedItem.Json();

    // Act
    Builder actualAddValidatedItemsResult = builderResult.addValidatedItems(element);

    // Assert
    List<BulkUploadRelationshipValidatedItem> validatedItemsResult = builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(element, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Test Builder {@link Builder#addValidatedItems(BulkUploadRelationshipValidatedItem[])} with {@code elements}.
   * <ul>
   *   <li>Then builder build validatedItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addValidatedItems(BulkUploadRelationshipValidatedItem[])}
   */
  @Test
  @DisplayName("Test Builder addValidatedItems(BulkUploadRelationshipValidatedItem[]) with 'elements'; then builder build validatedItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addValidatedItems(BulkUploadRelationshipValidatedItem[])"})
  void testBuilderAddValidatedItemsWithElements_thenBuilderBuildValidatedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();
    ImmutableBulkUploadRelationshipValidatedItem.Json json = new ImmutableBulkUploadRelationshipValidatedItem.Json();

    // Act
    Builder actualAddValidatedItemsResult = builderResult.addValidatedItems(json);

    // Assert
    List<BulkUploadRelationshipValidatedItem> validatedItemsResult = builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(json, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#parseError(BulkUploadRelationshipParseError)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUploadRelationshipValidationResult Builder.build()",
      "Builder Builder.parseError(BulkUploadRelationshipParseError)"})
  void testBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();
    Json parseError = new Json();

    // Act
    ImmutableBulkUploadRelationshipValidationResult actualBuildResult = builderResult.parseError(parseError).build();

    // Assert
    assertTrue(actualBuildResult.validatedItems().isEmpty());
    assertSame(parseError, actualBuildResult.parseError());
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipValidationResult)}.
   * <ul>
   *   <li>Given {@link ImmutableBulkUploadRelationshipValidatedItem.Json} (default constructor).</li>
   *   <li>Then return build validatedItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkUploadRelationshipValidationResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipValidationResult); given Json (default constructor); then return build validatedItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipValidationResult)"})
  void testBuilderFrom_givenJson_thenReturnBuildValidatedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();
    Builder builderResult2 = ImmutableBulkUploadRelationshipValidationResult.builder();
    ImmutableBulkUploadRelationshipValidatedItem.Json element = new ImmutableBulkUploadRelationshipValidatedItem.Json();
    builderResult2.addValidatedItems(element);
    ImmutableBulkUploadRelationshipValidationResult instance = builderResult2.parseError(new Json()).build();

    // Act and Assert
    List<BulkUploadRelationshipValidatedItem> validatedItemsResult = builderResult.from(instance)
        .build()
        .validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(element, validatedItemsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipValidationResult)}.
   * <ul>
   *   <li>Then return build is builder parseError {@link Json} (default constructor) build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkUploadRelationshipValidationResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipValidationResult); then return build is builder parseError Json (default constructor) build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipValidationResult)"})
  void testBuilderFrom_thenReturnBuildIsBuilderParseErrorJsonBuild() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();
    Builder builderResult2 = ImmutableBulkUploadRelationshipValidationResult.builder();
    ImmutableBulkUploadRelationshipValidationResult instance = builderResult2.parseError(new Json()).build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipValidationResult)}.
   * <ul>
   *   <li>Then return build is builder parseError {@code null} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkUploadRelationshipValidationResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipValidationResult); then return build is builder parseError 'null' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipValidationResult)"})
  void testBuilderFrom_thenReturnBuildIsBuilderParseErrorNullBuild() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();
    ImmutableBulkUploadRelationshipValidationResult instance = ImmutableBulkUploadRelationshipValidationResult.builder()
        .parseError(null)
        .build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#validatedItems(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#validatedItems(Iterable)}
   */
  @Test
  @DisplayName("Test Builder validatedItems(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.validatedItems(Iterable)"})
  void testBuilderValidatedItems_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.validatedItems(new ArrayList<>()));
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidationResult#copyOf(BulkUploadRelationshipValidationResult)}.
   * <ul>
   *   <li>When builder parseError {@link Json} (default constructor) build.</li>
   *   <li>Then return validatedItems Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUploadRelationshipValidationResult#copyOf(BulkUploadRelationshipValidationResult)}
   */
  @Test
  @DisplayName("Test copyOf(BulkUploadRelationshipValidationResult); when builder parseError Json (default constructor) build; then return validatedItems Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUploadRelationshipValidationResult ImmutableBulkUploadRelationshipValidationResult.copyOf(BulkUploadRelationshipValidationResult)"})
  void testCopyOf_whenBuilderParseErrorJsonBuild_thenReturnValidatedItemsEmpty() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();
    Json parseError = new Json();
    ImmutableBulkUploadRelationshipValidationResult instance = builderResult.parseError(parseError).build();

    // Act
    ImmutableBulkUploadRelationshipValidationResult actualCopyOfResult = ImmutableBulkUploadRelationshipValidationResult
        .copyOf(instance);

    // Assert
    assertTrue(actualCopyOfResult.validatedItems().isEmpty());
    assertSame(parseError, actualCopyOfResult.parseError());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidationResult#equals(Object)}, and {@link ImmutableBulkUploadRelationshipValidationResult#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipValidationResult#equals(Object)}
   *   <li>{@link ImmutableBulkUploadRelationshipValidationResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkUploadRelationshipValidationResult.equals(Object)",
      "int ImmutableBulkUploadRelationshipValidationResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableBulkUploadRelationshipValidationResult buildResult = ImmutableBulkUploadRelationshipValidationResult
        .builder()
        .parseError(null)
        .build();
    ImmutableBulkUploadRelationshipValidationResult buildResult2 = ImmutableBulkUploadRelationshipValidationResult
        .builder()
        .parseError(null)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidationResult#equals(Object)}, and {@link ImmutableBulkUploadRelationshipValidationResult#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipValidationResult#equals(Object)}
   *   <li>{@link ImmutableBulkUploadRelationshipValidationResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkUploadRelationshipValidationResult.equals(Object)",
      "int ImmutableBulkUploadRelationshipValidationResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();
    ImmutableBulkUploadRelationshipValidationResult buildResult = builderResult.parseError(new Json()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidationResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUploadRelationshipValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkUploadRelationshipValidationResult.equals(Object)",
      "int ImmutableBulkUploadRelationshipValidationResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();
    ImmutableBulkUploadRelationshipValidationResult buildResult = builderResult.parseError(new Json()).build();
    Builder builderResult2 = ImmutableBulkUploadRelationshipValidationResult.builder();
    ImmutableBulkUploadRelationshipValidationResult buildResult2 = builderResult2.parseError(new Json()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidationResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUploadRelationshipValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkUploadRelationshipValidationResult.equals(Object)",
      "int ImmutableBulkUploadRelationshipValidationResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();
    builderResult.addValidatedItems(new ImmutableBulkUploadRelationshipValidatedItem.Json());
    ImmutableBulkUploadRelationshipValidationResult buildResult = builderResult.parseError(new Json()).build();
    Builder builderResult2 = ImmutableBulkUploadRelationshipValidationResult.builder();
    ImmutableBulkUploadRelationshipValidationResult buildResult2 = builderResult2.parseError(new Json()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidationResult#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUploadRelationshipValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkUploadRelationshipValidationResult.equals(Object)",
      "int ImmutableBulkUploadRelationshipValidationResult.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();
    ImmutableBulkUploadRelationshipValidationResult buildResult = builderResult.parseError(new Json()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidationResult#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUploadRelationshipValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkUploadRelationshipValidationResult.equals(Object)",
      "int ImmutableBulkUploadRelationshipValidationResult.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();
    ImmutableBulkUploadRelationshipValidationResult buildResult = builderResult.parseError(new Json()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableBulkUploadRelationshipValidationResult");
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableBulkUploadRelationshipValidatedItem.Json} (default constructor).</li>
   *   <li>Then return validatedItems is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(ImmutableBulkUploadRelationshipValidationResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add Json (default constructor); then return validatedItems is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUploadRelationshipValidationResult ImmutableBulkUploadRelationshipValidationResult.fromJson(ImmutableBulkUploadRelationshipValidationResult.Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnValidatedItemsIsArrayList() {
    // Arrange
    ArrayList<BulkUploadRelationshipValidatedItem> validatedItems = new ArrayList<>();
    validatedItems.add(new ImmutableBulkUploadRelationshipValidatedItem.Json());

    ImmutableBulkUploadRelationshipValidationResult.Json json = new ImmutableBulkUploadRelationshipValidationResult.Json();
    json.setValidatedItems(validatedItems);
    json.setParseError(null);

    // Act and Assert
    assertEquals(validatedItems, ImmutableBulkUploadRelationshipValidationResult.fromJson(json).validatedItems());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableBulkUploadRelationshipValidatedItem.Json} (default constructor).</li>
   *   <li>Then return validatedItems size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(ImmutableBulkUploadRelationshipValidationResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add Json (default constructor); then return validatedItems size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUploadRelationshipValidationResult ImmutableBulkUploadRelationshipValidationResult.fromJson(ImmutableBulkUploadRelationshipValidationResult.Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnValidatedItemsSizeIsTwo() {
    // Arrange
    ArrayList<BulkUploadRelationshipValidatedItem> validatedItems = new ArrayList<>();
    validatedItems.add(new ImmutableBulkUploadRelationshipValidatedItem.Json());
    ImmutableBulkUploadRelationshipValidatedItem.Json json = new ImmutableBulkUploadRelationshipValidatedItem.Json();
    validatedItems.add(json);

    ImmutableBulkUploadRelationshipValidationResult.Json json2 = new ImmutableBulkUploadRelationshipValidationResult.Json();
    json2.setValidatedItems(validatedItems);
    json2.setParseError(null);

    // Act and Assert
    List<BulkUploadRelationshipValidatedItem> validatedItemsResult = ImmutableBulkUploadRelationshipValidationResult
        .fromJson(json2)
        .validatedItems();
    assertEquals(2, validatedItemsResult.size());
    assertSame(json, validatedItemsResult.get(1));
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link Json} (default constructor).</li>
   *   <li>When {@link ImmutableBulkUploadRelationshipValidationResult.Json} (default constructor) ParseError is {@link Json} (default constructor).</li>
   *   <li>Then return parseError is {@link Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(ImmutableBulkUploadRelationshipValidationResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given Json (default constructor); when Json (default constructor) ParseError is Json (default constructor); then return parseError is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUploadRelationshipValidationResult ImmutableBulkUploadRelationshipValidationResult.fromJson(ImmutableBulkUploadRelationshipValidationResult.Json)"})
  void testFromJson_givenJson_whenJsonParseErrorIsJson_thenReturnParseErrorIsJson() {
    // Arrange
    ImmutableBulkUploadRelationshipValidationResult.Json json = new ImmutableBulkUploadRelationshipValidationResult.Json();
    json.setValidatedItems(null);
    Json parseError = new Json();
    json.setParseError(parseError);

    // Act and Assert
    assertSame(parseError, ImmutableBulkUploadRelationshipValidationResult.fromJson(json).parseError());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ImmutableBulkUploadRelationshipValidationResult.Json} (default constructor) ValidatedItems is {@code null}.</li>
   *   <li>Then return parseError is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(ImmutableBulkUploadRelationshipValidationResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) ValidatedItems is 'null'; then return parseError is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUploadRelationshipValidationResult ImmutableBulkUploadRelationshipValidationResult.fromJson(ImmutableBulkUploadRelationshipValidationResult.Json)"})
  void testFromJson_givenNull_whenJsonValidatedItemsIsNull_thenReturnParseErrorIsNull() {
    // Arrange
    ImmutableBulkUploadRelationshipValidationResult.Json json = new ImmutableBulkUploadRelationshipValidationResult.Json();
    json.setValidatedItems(null);
    json.setParseError(null);

    // Act
    ImmutableBulkUploadRelationshipValidationResult actualFromJsonResult = ImmutableBulkUploadRelationshipValidationResult
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.parseError());
    assertTrue(actualFromJsonResult.validatedItems().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(Json)}.
   * <ul>
   *   <li>When {@link ImmutableBulkUploadRelationshipValidationResult.Json} (default constructor).</li>
   *   <li>Then return parseError is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(ImmutableBulkUploadRelationshipValidationResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return parseError is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUploadRelationshipValidationResult ImmutableBulkUploadRelationshipValidationResult.fromJson(ImmutableBulkUploadRelationshipValidationResult.Json)"})
  void testFromJson_whenJson_thenReturnParseErrorIsNull() {
    // Arrange and Act
    ImmutableBulkUploadRelationshipValidationResult actualFromJsonResult = ImmutableBulkUploadRelationshipValidationResult
        .fromJson(new ImmutableBulkUploadRelationshipValidationResult.Json());

    // Assert
    assertNull(actualFromJsonResult.parseError());
    assertTrue(actualFromJsonResult.validatedItems().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipValidationResult#toString()}
   *   <li>{@link ImmutableBulkUploadRelationshipValidationResult#parseError()}
   *   <li>{@link ImmutableBulkUploadRelationshipValidationResult#validatedItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkUploadRelationshipParseError ImmutableBulkUploadRelationshipValidationResult.parseError()",
      "java.lang.String ImmutableBulkUploadRelationshipValidationResult.toString()",
      "List ImmutableBulkUploadRelationshipValidationResult.validatedItems()"})
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();
    Json parseError = new Json();
    ImmutableBulkUploadRelationshipValidationResult buildResult = builderResult.parseError(parseError).build();

    // Act
    buildResult.toString();
    BulkUploadRelationshipParseError actualParseErrorResult = buildResult.parseError();

    // Assert
    assertTrue(buildResult.validatedItems().isEmpty());
    assertSame(parseError, actualParseErrorResult);
  }

  /**
   * Test Json new {@link ImmutableBulkUploadRelationshipValidationResult.Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ImmutableBulkUploadRelationshipValidationResult.Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImmutableBulkUploadRelationshipValidationResult.Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableBulkUploadRelationshipValidationResult.Json actualJson = new ImmutableBulkUploadRelationshipValidationResult.Json();

    // Assert
    assertNull(actualJson.parseError);
    assertTrue(actualJson.validatedItems.isEmpty());
  }

  /**
   * Test Json {@link ImmutableBulkUploadRelationshipValidationResult.Json#parseError()}.
   * <p>
   * Method under test: {@link ImmutableBulkUploadRelationshipValidationResult.Json#parseError()}
   */
  @Test
  @DisplayName("Test Json parseError()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "BulkUploadRelationshipParseError ImmutableBulkUploadRelationshipValidationResult.Json.parseError()"})
  void testJsonParseError() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadRelationshipValidationResult.Json()).parseError());
  }

  /**
   * Test Json {@link ImmutableBulkUploadRelationshipValidationResult.Json#validatedItems()}.
   * <p>
   * Method under test: {@link ImmutableBulkUploadRelationshipValidationResult.Json#validatedItems()}
   */
  @Test
  @DisplayName("Test Json validatedItems()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ImmutableBulkUploadRelationshipValidationResult.Json.validatedItems()"})
  void testJsonValidatedItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadRelationshipValidationResult.Json()).validatedItems());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidationResult#withParseError(BulkUploadRelationshipParseError)}.
   * <p>
   * Method under test: {@link ImmutableBulkUploadRelationshipValidationResult#withParseError(BulkUploadRelationshipParseError)}
   */
  @Test
  @DisplayName("Test withParseError(BulkUploadRelationshipParseError)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUploadRelationshipValidationResult ImmutableBulkUploadRelationshipValidationResult.withParseError(BulkUploadRelationshipParseError)"})
  void testWithParseError() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();
    ImmutableBulkUploadRelationshipValidationResult buildResult = builderResult.parseError(new Json()).build();
    Json value = new Json();

    // Act
    ImmutableBulkUploadRelationshipValidationResult actualWithParseErrorResult = buildResult.withParseError(value);

    // Assert
    assertTrue(actualWithParseErrorResult.validatedItems().isEmpty());
    assertSame(value, actualWithParseErrorResult.parseError());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidationResult#withValidatedItems(BulkUploadRelationshipValidatedItem[])} with {@code BulkUploadRelationshipValidatedItem[]}.
   * <p>
   * Method under test: {@link ImmutableBulkUploadRelationshipValidationResult#withValidatedItems(BulkUploadRelationshipValidatedItem[])}
   */
  @Test
  @DisplayName("Test withValidatedItems(BulkUploadRelationshipValidatedItem[]) with 'BulkUploadRelationshipValidatedItem[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkUploadRelationshipValidationResult ImmutableBulkUploadRelationshipValidationResult.withValidatedItems(BulkUploadRelationshipValidatedItem[])"})
  void testWithValidatedItemsWithBulkUploadRelationshipValidatedItem() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();
    Json parseError = new Json();
    ImmutableBulkUploadRelationshipValidationResult buildResult = builderResult.parseError(parseError).build();
    ImmutableBulkUploadRelationshipValidatedItem.Json json = new ImmutableBulkUploadRelationshipValidatedItem.Json();

    // Act
    ImmutableBulkUploadRelationshipValidationResult actualWithValidatedItemsResult = buildResult
        .withValidatedItems(json);

    // Assert
    List<BulkUploadRelationshipValidatedItem> validatedItemsResult = actualWithValidatedItemsResult.validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(parseError, actualWithValidatedItemsResult.parseError());
    assertSame(json, validatedItemsResult.get(0));
  }
}
