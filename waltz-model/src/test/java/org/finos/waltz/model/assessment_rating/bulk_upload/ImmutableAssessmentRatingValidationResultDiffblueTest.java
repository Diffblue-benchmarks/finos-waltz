package org.finos.waltz.model.assessment_rating.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.assessment_rating.bulk_upload.AssessmentRatingParsedResult.AssessmentRatingParseError;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmentRatingValidationResult.Builder;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmentRatingValidationResult.Json;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingValidationResultDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllRemovals(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then builder build removalCount is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRemovals(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRemovals(Iterable); when ArrayList(); then builder build removalCount is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRemovals(Iterable)"})
  void testBuilderAddAllRemovals_whenArrayList_thenBuilderBuildRemovalCountIsZero() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();

    // Act
    Builder actualAddAllRemovalsResult = builderResult.addAllRemovals(new ArrayList<>());

    // Assert
    assertEquals(0, builderResult.build().removalCount());
    assertSame(builderResult, actualAddAllRemovalsResult);
  }

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
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllValidatedItems(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addRemovals(Tuple2)} with {@code element}.
   * <ul>
   *   <li>Then builder build removals size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRemovals(Tuple2)}
   */
  @Test
  @DisplayName("Test Builder addRemovals(Tuple2) with 'element'; then builder build removals size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRemovals(Tuple2)"})
  void testBuilderAddRemovalsWithElement_thenBuilderBuildRemovalsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();

    // Act
    Builder actualAddRemovalsResult = builderResult.addRemovals(new Tuple2<>(mock(EntityReference.class), 1L));

    // Assert
    ImmutableAssessmentRatingValidationResult buildResult = builderResult.build();
    assertEquals(1, buildResult.removals().size());
    assertEquals(1, buildResult.removalCount());
    assertSame(builderResult, actualAddRemovalsResult);
  }

  /**
   * Test Builder {@link Builder#addRemovals(Tuple2[])} with {@code elements}.
   * <ul>
   *   <li>Then builder build removals size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRemovals(Tuple2[])}
   */
  @Test
  @DisplayName("Test Builder addRemovals(Tuple2[]) with 'elements'; then builder build removals size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRemovals(Tuple2[])"})
  void testBuilderAddRemovalsWithElements_thenBuilderBuildRemovalsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();

    // Act
    Builder actualAddRemovalsResult = builderResult.addRemovals(new Tuple2<>(mock(EntityReference.class), 1L));

    // Assert
    ImmutableAssessmentRatingValidationResult buildResult = builderResult.build();
    assertEquals(1, buildResult.removals().size());
    assertEquals(1, buildResult.removalCount());
    assertSame(builderResult, actualAddRemovalsResult);
  }

  /**
   * Test Builder {@link Builder#addValidatedItems(AssessmentRatingValidatedItem)} with {@code element}.
   * <ul>
   *   <li>Then builder build validatedItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addValidatedItems(AssessmentRatingValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder addValidatedItems(AssessmentRatingValidatedItem) with 'element'; then builder build validatedItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addValidatedItems(AssessmentRatingValidatedItem)"})
  void testBuilderAddValidatedItemsWithElement_thenBuilderBuildValidatedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingValidatedItem.Json element = new ImmutableAssessmentRatingValidatedItem.Json();

    // Act
    Builder actualAddValidatedItemsResult = builderResult.addValidatedItems(element);

    // Assert
    List<AssessmentRatingValidatedItem> validatedItemsResult = builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(element, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Test Builder {@link Builder#addValidatedItems(AssessmentRatingValidatedItem[])} with {@code elements}.
   * <ul>
   *   <li>Then builder build validatedItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addValidatedItems(AssessmentRatingValidatedItem[])}
   */
  @Test
  @DisplayName("Test Builder addValidatedItems(AssessmentRatingValidatedItem[]) with 'elements'; then builder build validatedItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addValidatedItems(AssessmentRatingValidatedItem[])"})
  void testBuilderAddValidatedItemsWithElements_thenBuilderBuildValidatedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingValidatedItem.Json json = new ImmutableAssessmentRatingValidatedItem.Json();

    // Act
    Builder actualAddValidatedItemsResult = builderResult.addValidatedItems(json);

    // Assert
    List<AssessmentRatingValidatedItem> validatedItemsResult = builderResult.build().validatedItems();
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
   *   <li>{@link Builder#error(AssessmentRatingParseError)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAssessmentRatingValidationResult Builder.build()",
      "Builder Builder.error(AssessmentRatingParseError)"})
  void testBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingParseError.Json error = new ImmutableAssessmentRatingParseError.Json();

    // Act
    ImmutableAssessmentRatingValidationResult actualBuildResult = builderResult.error(error).build();

    // Assert
    assertEquals(0, actualBuildResult.removalCount());
    assertTrue(actualBuildResult.validatedItems().isEmpty());
    assertTrue(actualBuildResult.removals().isEmpty());
    assertSame(error, actualBuildResult.error());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingValidationResult)}.
   * <ul>
   *   <li>Then return build removals size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingValidationResult)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingValidationResult); then return build removals size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingValidationResult)"})
  void testBuilderFrom_thenReturnBuildRemovalsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    Builder builderResult2 = ImmutableAssessmentRatingValidationResult.builder();
    builderResult2.addRemovals(new Tuple2<>(mock(EntityReference.class), 1L));
    builderResult2.addValidatedItems(new ImmutableAssessmentRatingValidatedItem.Json());
    ImmutableAssessmentRatingValidationResult instance = builderResult2
        .error(new ImmutableAssessmentRatingParseError.Json())
        .build();

    // Act and Assert
    ImmutableAssessmentRatingValidationResult buildResult = builderResult.from(instance).build();
    List<AssessmentRatingValidatedItem> validatedItemsResult = buildResult.validatedItems();
    assertEquals(1, validatedItemsResult.size());
    AssessmentRatingValidatedItem getResult = validatedItemsResult.get(0);
    assertTrue(getResult instanceof ImmutableAssessmentRatingValidatedItem.Json);
    assertEquals(1, buildResult.removals().size());
    assertEquals(1, buildResult.removalCount());
    Set<ChangedFieldType> changedFieldTypeSet = ((ImmutableAssessmentRatingValidatedItem.Json) getResult).changedFields;
    assertTrue(changedFieldTypeSet.isEmpty());
    assertSame(changedFieldTypeSet, ((ImmutableAssessmentRatingValidatedItem.Json) getResult).errors);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingValidationResult)}.
   * <ul>
   *   <li>Then return build validatedItems first {@link ImmutableAssessmentRatingValidatedItem.Json#changedFields} is {@link ImmutableAssessmentRatingValidatedItem.Json} (default constructor) {@link ImmutableAssessmentRatingValidatedItem.Json#errors}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingValidationResult)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingValidationResult); then return build validatedItems first changedFields is Json (default constructor) errors")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingValidationResult)"})
  void testBuilderFrom_thenReturnBuildValidatedItemsFirstChangedFieldsIsJsonErrors() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    Builder builderResult2 = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingValidatedItem.Json element = new ImmutableAssessmentRatingValidatedItem.Json();
    builderResult2.addValidatedItems(element);
    ImmutableAssessmentRatingValidationResult instance = builderResult2
        .error(new ImmutableAssessmentRatingParseError.Json())
        .build();

    // Act and Assert
    List<AssessmentRatingValidatedItem> validatedItemsResult = builderResult.from(instance).build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    AssessmentRatingValidatedItem getResult = validatedItemsResult.get(0);
    assertTrue(getResult instanceof ImmutableAssessmentRatingValidatedItem.Json);
    assertSame(element.errors, ((ImmutableAssessmentRatingValidatedItem.Json) getResult).changedFields);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingValidationResult)}.
   * <ul>
   *   <li>When builder error {@link ImmutableAssessmentRatingParseError.Json} (default constructor) build.</li>
   *   <li>Then return build is builder error {@link ImmutableAssessmentRatingParseError.Json} (default constructor) build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingValidationResult)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingValidationResult); when builder error Json (default constructor) build; then return build is builder error Json (default constructor) build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingValidationResult)"})
  void testBuilderFrom_whenBuilderErrorJsonBuild_thenReturnBuildIsBuilderErrorJsonBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    Builder builderResult2 = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingValidationResult instance = builderResult2
        .error(new ImmutableAssessmentRatingParseError.Json())
        .build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingValidationResult)}.
   * <ul>
   *   <li>When builder error {@code null} build.</li>
   *   <li>Then return build is builder error {@code null} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingValidationResult)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingValidationResult); when builder error 'null' build; then return build is builder error 'null' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingValidationResult)"})
  void testBuilderFrom_whenBuilderErrorNullBuild_thenReturnBuildIsBuilderErrorNullBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingValidationResult instance = ImmutableAssessmentRatingValidationResult.builder()
        .error(null)
        .build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#removals(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then builder build removalCount is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#removals(Iterable)}
   */
  @Test
  @DisplayName("Test Builder removals(Iterable); when ArrayList(); then builder build removalCount is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.removals(Iterable)"})
  void testBuilderRemovals_whenArrayList_thenBuilderBuildRemovalCountIsZero() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();

    // Act
    Builder actualRemovalsResult = builderResult.removals(new ArrayList<>());

    // Assert
    assertEquals(0, builderResult.build().removalCount());
    assertSame(builderResult, actualRemovalsResult);
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
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.validatedItems(new ArrayList<>()));
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#copyOf(AssessmentRatingValidationResult)}.
   * <ul>
   *   <li>When builder error {@link ImmutableAssessmentRatingParseError.Json} (default constructor) build.</li>
   *   <li>Then return removalCount is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingValidationResult#copyOf(AssessmentRatingValidationResult)}
   */
  @Test
  @DisplayName("Test copyOf(AssessmentRatingValidationResult); when builder error Json (default constructor) build; then return removalCount is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentRatingValidationResult ImmutableAssessmentRatingValidationResult.copyOf(AssessmentRatingValidationResult)"})
  void testCopyOf_whenBuilderErrorJsonBuild_thenReturnRemovalCountIsZero() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingParseError.Json error = new ImmutableAssessmentRatingParseError.Json();
    ImmutableAssessmentRatingValidationResult instance = builderResult.error(error).build();

    // Act
    ImmutableAssessmentRatingValidationResult actualCopyOfResult = ImmutableAssessmentRatingValidationResult
        .copyOf(instance);

    // Assert
    assertEquals(0, actualCopyOfResult.removalCount());
    assertTrue(actualCopyOfResult.validatedItems().isEmpty());
    assertTrue(actualCopyOfResult.removals().isEmpty());
    assertSame(error, actualCopyOfResult.error());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#equals(Object)}, and {@link ImmutableAssessmentRatingValidationResult#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingValidationResult#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingValidationResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAssessmentRatingValidationResult.equals(Object)",
      "int ImmutableAssessmentRatingValidationResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingValidationResult buildResult = builderResult
        .error(new ImmutableAssessmentRatingParseError.Json())
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAssessmentRatingValidationResult.equals(Object)",
      "int ImmutableAssessmentRatingValidationResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingValidationResult buildResult = builderResult
        .error(new ImmutableAssessmentRatingParseError.Json())
        .build();
    Builder builderResult2 = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingValidationResult buildResult2 = builderResult2
        .error(new ImmutableAssessmentRatingParseError.Json())
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAssessmentRatingValidationResult.equals(Object)",
      "int ImmutableAssessmentRatingValidationResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    builderResult.addValidatedItems(new ImmutableAssessmentRatingValidatedItem.Json());
    ImmutableAssessmentRatingValidationResult buildResult = builderResult
        .error(new ImmutableAssessmentRatingParseError.Json())
        .build();
    Builder builderResult2 = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingValidationResult buildResult2 = builderResult2
        .error(new ImmutableAssessmentRatingParseError.Json())
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAssessmentRatingValidationResult.equals(Object)",
      "int ImmutableAssessmentRatingValidationResult.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingValidationResult buildResult = builderResult
        .error(new ImmutableAssessmentRatingParseError.Json())
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAssessmentRatingValidationResult.equals(Object)",
      "int ImmutableAssessmentRatingValidationResult.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingValidationResult buildResult = builderResult
        .error(new ImmutableAssessmentRatingParseError.Json())
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableAssessmentRatingValidationResult");
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableAssessmentRatingValidatedItem.Json} (default constructor).</li>
   *   <li>Then return validatedItems is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add Json (default constructor); then return validatedItems is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentRatingValidationResult ImmutableAssessmentRatingValidationResult.fromJson(Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnValidatedItemsIsArrayList() {
    // Arrange
    ArrayList<AssessmentRatingValidatedItem> validatedItems = new ArrayList<>();
    validatedItems.add(new ImmutableAssessmentRatingValidatedItem.Json());

    Json json = new Json();
    json.setValidatedItems(validatedItems);
    json.setError(null);
    json.setRemovals(null);

    // Act and Assert
    assertEquals(validatedItems, ImmutableAssessmentRatingValidationResult.fromJson(json).validatedItems());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableAssessmentRatingValidatedItem.Json} (default constructor).</li>
   *   <li>Then return validatedItems size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add Json (default constructor); then return validatedItems size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentRatingValidationResult ImmutableAssessmentRatingValidationResult.fromJson(Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnValidatedItemsSizeIsTwo() {
    // Arrange
    ArrayList<AssessmentRatingValidatedItem> validatedItems = new ArrayList<>();
    validatedItems.add(new ImmutableAssessmentRatingValidatedItem.Json());
    ImmutableAssessmentRatingValidatedItem.Json json = new ImmutableAssessmentRatingValidatedItem.Json();
    validatedItems.add(json);

    Json json2 = new Json();
    json2.setValidatedItems(validatedItems);
    json2.setError(null);
    json2.setRemovals(null);

    // Act and Assert
    List<AssessmentRatingValidatedItem> validatedItemsResult = ImmutableAssessmentRatingValidationResult.fromJson(json2)
        .validatedItems();
    assertEquals(2, validatedItemsResult.size());
    assertSame(json, validatedItemsResult.get(1));
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ImmutableAssessmentRatingParseError.Json} (default constructor).</li>
   *   <li>When {@link Json} (default constructor) Error is {@link ImmutableAssessmentRatingParseError.Json} (default constructor).</li>
   *   <li>Then return error is {@link ImmutableAssessmentRatingParseError.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given Json (default constructor); when Json (default constructor) Error is Json (default constructor); then return error is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentRatingValidationResult ImmutableAssessmentRatingValidationResult.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonErrorIsJson_thenReturnErrorIsJson() {
    // Arrange
    Json json = new Json();
    json.setValidatedItems(null);
    ImmutableAssessmentRatingParseError.Json error = new ImmutableAssessmentRatingParseError.Json();
    json.setError(error);
    json.setRemovals(null);

    // Act and Assert
    assertSame(error, ImmutableAssessmentRatingValidationResult.fromJson(json).error());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) ValidatedItems is {@code null}.</li>
   *   <li>Then return error is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) ValidatedItems is 'null'; then return error is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentRatingValidationResult ImmutableAssessmentRatingValidationResult.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonValidatedItemsIsNull_thenReturnErrorIsNull() {
    // Arrange
    Json json = new Json();
    json.setValidatedItems(null);
    json.setError(null);
    json.setRemovals(null);

    // Act
    ImmutableAssessmentRatingValidationResult actualFromJsonResult = ImmutableAssessmentRatingValidationResult
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.error());
    assertEquals(0, actualFromJsonResult.removalCount());
    assertTrue(actualFromJsonResult.validatedItems().isEmpty());
    assertTrue(actualFromJsonResult.removals().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}.
   * <ul>
   *   <li>Then return removalCount is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return removalCount is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentRatingValidationResult ImmutableAssessmentRatingValidationResult.fromJson(Json)"})
  void testFromJson_thenReturnRemovalCountIsTwo() {
    // Arrange
    LinkedHashSet<Tuple2<EntityReference, Long>> removals = new LinkedHashSet<>();
    removals.add(new Tuple2<>(mock(EntityReference.class), 1L));
    removals.add(new Tuple2<>(mock(EntityReference.class), 1L));

    Json json = new Json();
    json.setValidatedItems(null);
    json.setError(null);
    json.setRemovals(removals);

    // Act
    ImmutableAssessmentRatingValidationResult actualFromJsonResult = ImmutableAssessmentRatingValidationResult
        .fromJson(json);

    // Assert
    assertEquals(2, actualFromJsonResult.removalCount());
    assertEquals(removals, actualFromJsonResult.removals());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}.
   * <ul>
   *   <li>Then return removals size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return removals size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentRatingValidationResult ImmutableAssessmentRatingValidationResult.fromJson(Json)"})
  void testFromJson_thenReturnRemovalsSizeIsOne() {
    // Arrange
    LinkedHashSet<Tuple2<EntityReference, Long>> removals = new LinkedHashSet<>();
    removals.add(new Tuple2<>(mock(EntityReference.class), 1L));

    Json json = new Json();
    json.setValidatedItems(null);
    json.setError(null);
    json.setRemovals(removals);

    // Act
    ImmutableAssessmentRatingValidationResult actualFromJsonResult = ImmutableAssessmentRatingValidationResult
        .fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.removals().size());
    assertEquals(1, actualFromJsonResult.removalCount());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return error is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return error is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentRatingValidationResult ImmutableAssessmentRatingValidationResult.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnErrorIsNull() {
    // Arrange and Act
    ImmutableAssessmentRatingValidationResult actualFromJsonResult = ImmutableAssessmentRatingValidationResult
        .fromJson(new Json());

    // Assert
    assertNull(actualFromJsonResult.error());
    assertEquals(0, actualFromJsonResult.removalCount());
    assertTrue(actualFromJsonResult.validatedItems().isEmpty());
    assertTrue(actualFromJsonResult.removals().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingValidationResult#toString()}
   *   <li>{@link ImmutableAssessmentRatingValidationResult#error()}
   *   <li>{@link ImmutableAssessmentRatingValidationResult#removalCount()}
   *   <li>{@link ImmutableAssessmentRatingValidationResult#removals()}
   *   <li>{@link ImmutableAssessmentRatingValidationResult#validatedItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssessmentRatingParseError ImmutableAssessmentRatingValidationResult.error()",
      "int ImmutableAssessmentRatingValidationResult.removalCount()",
      "Set ImmutableAssessmentRatingValidationResult.removals()",
      "java.lang.String ImmutableAssessmentRatingValidationResult.toString()",
      "List ImmutableAssessmentRatingValidationResult.validatedItems()"})
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingParseError.Json error = new ImmutableAssessmentRatingParseError.Json();
    ImmutableAssessmentRatingValidationResult buildResult = builderResult.error(error).build();

    // Act
    buildResult.toString();
    AssessmentRatingParseError actualErrorResult = buildResult.error();
    int actualRemovalCountResult = buildResult.removalCount();
    Set<Tuple2<EntityReference, Long>> actualRemovalsResult = buildResult.removals();

    // Assert
    assertEquals(0, actualRemovalCountResult);
    assertTrue(buildResult.validatedItems().isEmpty());
    assertTrue(actualRemovalsResult.isEmpty());
    assertSame(error, actualErrorResult);
  }

  /**
   * Test Json {@link Json#error()}.
   * <p>
   * Method under test: {@link Json#error()}
   */
  @Test
  @DisplayName("Test Json error()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssessmentRatingParseError Json.error()"})
  void testJsonError() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).error());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.error);
    assertTrue(actualJson.validatedItems.isEmpty());
    assertTrue(actualJson.removals.isEmpty());
  }

  /**
   * Test Json {@link Json#removalCount()}.
   * <p>
   * Method under test: {@link Json#removalCount()}
   */
  @Test
  @DisplayName("Test Json removalCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.removalCount()"})
  void testJsonRemovalCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).removalCount());
  }

  /**
   * Test Json {@link Json#removals()}.
   * <p>
   * Method under test: {@link Json#removals()}
   */
  @Test
  @DisplayName("Test Json removals()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.removals()"})
  void testJsonRemovals() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).removals());
  }

  /**
   * Test Json {@link Json#validatedItems()}.
   * <p>
   * Method under test: {@link Json#validatedItems()}
   */
  @Test
  @DisplayName("Test Json validatedItems()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.validatedItems()"})
  void testJsonValidatedItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).validatedItems());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#withError(AssessmentRatingParseError)}.
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingValidationResult#withError(AssessmentRatingParseError)}
   */
  @Test
  @DisplayName("Test withError(AssessmentRatingParseError)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentRatingValidationResult ImmutableAssessmentRatingValidationResult.withError(AssessmentRatingParseError)"})
  void testWithError() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingValidationResult buildResult = builderResult
        .error(new ImmutableAssessmentRatingParseError.Json())
        .build();
    ImmutableAssessmentRatingParseError.Json value = new ImmutableAssessmentRatingParseError.Json();

    // Act
    ImmutableAssessmentRatingValidationResult actualWithErrorResult = buildResult.withError(value);

    // Assert
    assertEquals(0, actualWithErrorResult.removalCount());
    assertTrue(actualWithErrorResult.validatedItems().isEmpty());
    assertTrue(actualWithErrorResult.removals().isEmpty());
    assertSame(value, actualWithErrorResult.error());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#withRemovals(Tuple2[])} with {@code Tuple2[]}.
   * <ul>
   *   <li>Then return removals size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingValidationResult#withRemovals(Tuple2[])}
   */
  @Test
  @DisplayName("Test withRemovals(Tuple2[]) with 'Tuple2[]'; then return removals size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentRatingValidationResult ImmutableAssessmentRatingValidationResult.withRemovals(Tuple2[])"})
  void testWithRemovalsWithTuple2_thenReturnRemovalsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingParseError.Json error = new ImmutableAssessmentRatingParseError.Json();
    ImmutableAssessmentRatingValidationResult buildResult = builderResult.error(error).build();

    // Act
    ImmutableAssessmentRatingValidationResult actualWithRemovalsResult = buildResult
        .withRemovals(new Tuple2<>(mock(EntityReference.class), 1L));

    // Assert
    assertEquals(1, actualWithRemovalsResult.removals().size());
    assertEquals(1, actualWithRemovalsResult.removalCount());
    assertTrue(actualWithRemovalsResult.validatedItems().isEmpty());
    assertSame(error, actualWithRemovalsResult.error());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#withValidatedItems(AssessmentRatingValidatedItem[])} with {@code AssessmentRatingValidatedItem[]}.
   * <p>
   * Method under test: {@link ImmutableAssessmentRatingValidationResult#withValidatedItems(AssessmentRatingValidatedItem[])}
   */
  @Test
  @DisplayName("Test withValidatedItems(AssessmentRatingValidatedItem[]) with 'AssessmentRatingValidatedItem[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentRatingValidationResult ImmutableAssessmentRatingValidationResult.withValidatedItems(AssessmentRatingValidatedItem[])"})
  void testWithValidatedItemsWithAssessmentRatingValidatedItem() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingParseError.Json error = new ImmutableAssessmentRatingParseError.Json();
    ImmutableAssessmentRatingValidationResult buildResult = builderResult.error(error).build();
    ImmutableAssessmentRatingValidatedItem.Json json = new ImmutableAssessmentRatingValidatedItem.Json();

    // Act
    ImmutableAssessmentRatingValidationResult actualWithValidatedItemsResult = buildResult.withValidatedItems(json);

    // Assert
    assertEquals(0, actualWithValidatedItemsResult.removalCount());
    List<AssessmentRatingValidatedItem> validatedItemsResult = actualWithValidatedItemsResult.validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertTrue(actualWithValidatedItemsResult.removals().isEmpty());
    assertSame(error, actualWithValidatedItemsResult.error());
    assertSame(json, validatedItemsResult.get(0));
  }
}
