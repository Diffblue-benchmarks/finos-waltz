package org.finos.waltz.model.bulk_upload.taxonomy;

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
import org.finos.waltz.model.bulk_upload.taxonomy.BulkTaxonomyParseResult.BulkTaxonomyParseError;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyParseError.Json;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyValidationResult.Builder;
import org.finos.waltz.model.measurable.Measurable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkTaxonomyValidationResultDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllPlannedRemovals(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllPlannedRemovals(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllPlannedRemovals(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllPlannedRemovals(Iterable)"})
  void testBuilderAddAllPlannedRemovals_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllPlannedRemovals(new ArrayList<>()));
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
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllValidatedItems(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addPlannedRemovals(Measurable)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addPlannedRemovals(Measurable)}
   */
  @Test
  @DisplayName("Test Builder addPlannedRemovals(Measurable) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addPlannedRemovals(Measurable)"})
  void testBuilderAddPlannedRemovalsWithElement() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    // Act
    Builder actualAddPlannedRemovalsResult = builderResult.addPlannedRemovals(mock(Measurable.class));

    // Assert
    assertEquals(1, builderResult.build().plannedRemovals().size());
    assertSame(builderResult, actualAddPlannedRemovalsResult);
  }

  /**
   * Test Builder {@link Builder#addPlannedRemovals(Measurable[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addPlannedRemovals(Measurable[])}
   */
  @Test
  @DisplayName("Test Builder addPlannedRemovals(Measurable[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addPlannedRemovals(Measurable[])"})
  void testBuilderAddPlannedRemovalsWithElements() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    // Act
    Builder actualAddPlannedRemovalsResult = builderResult.addPlannedRemovals(mock(Measurable.class));

    // Assert
    assertEquals(1, builderResult.build().plannedRemovals().size());
    assertSame(builderResult, actualAddPlannedRemovalsResult);
  }

  /**
   * Test Builder {@link Builder#addValidatedItems(BulkTaxonomyValidatedItem)} with {@code element}.
   * <ul>
   *   <li>Then builder build validatedItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addValidatedItems(BulkTaxonomyValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder addValidatedItems(BulkTaxonomyValidatedItem) with 'element'; then builder build validatedItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addValidatedItems(BulkTaxonomyValidatedItem)"})
  void testBuilderAddValidatedItemsWithElement_thenBuilderBuildValidatedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidatedItem.Json element = new ImmutableBulkTaxonomyValidatedItem.Json();

    // Act
    Builder actualAddValidatedItemsResult = builderResult.addValidatedItems(element);

    // Assert
    List<BulkTaxonomyValidatedItem> validatedItemsResult = builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(element, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Test Builder {@link Builder#addValidatedItems(BulkTaxonomyValidatedItem[])} with {@code elements}.
   * <ul>
   *   <li>Then builder build validatedItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addValidatedItems(BulkTaxonomyValidatedItem[])}
   */
  @Test
  @DisplayName("Test Builder addValidatedItems(BulkTaxonomyValidatedItem[]) with 'elements'; then builder build validatedItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addValidatedItems(BulkTaxonomyValidatedItem[])"})
  void testBuilderAddValidatedItemsWithElements_thenBuilderBuildValidatedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidatedItem.Json json = new ImmutableBulkTaxonomyValidatedItem.Json();

    // Act
    Builder actualAddValidatedItemsResult = builderResult.addValidatedItems(json);

    // Assert
    List<BulkTaxonomyValidatedItem> validatedItemsResult = builderResult.build().validatedItems();
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
   *   <li>{@link Builder#error(BulkTaxonomyParseError)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkTaxonomyValidationResult Builder.build()",
      "Builder Builder.error(BulkTaxonomyParseError)"})
  void testBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    Json error = new Json();

    // Act
    ImmutableBulkTaxonomyValidationResult actualBuildResult = builderResult.error(error).build();

    // Assert
    assertTrue(actualBuildResult.validatedItems().isEmpty());
    assertTrue(actualBuildResult.plannedRemovals().isEmpty());
    assertSame(error, actualBuildResult.error());
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyValidationResult)}.
   * <ul>
   *   <li>Given {@link ImmutableBulkTaxonomyValidatedItem.Json} (default constructor).</li>
   *   <li>Then build validatedItems first return {@link ImmutableBulkTaxonomyValidatedItem.Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkTaxonomyValidationResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyValidationResult); given Json (default constructor); then build validatedItems first return Json")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyValidationResult)"})
  void testBuilderFrom_givenJson_thenBuildValidatedItemsFirstReturnJson() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    Builder builderResult2 = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidatedItem.Json element = new ImmutableBulkTaxonomyValidatedItem.Json();
    builderResult2.addValidatedItems(element);
    ImmutableBulkTaxonomyValidationResult instance = builderResult2.error(new Json()).build();

    // Act and Assert
    List<BulkTaxonomyValidatedItem> validatedItemsResult = builderResult.from(instance).build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    BulkTaxonomyValidatedItem getResult = validatedItemsResult.get(0);
    assertTrue(getResult instanceof ImmutableBulkTaxonomyValidatedItem.Json);
    assertSame(element.errors, ((ImmutableBulkTaxonomyValidatedItem.Json) getResult).changedFields);
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyValidationResult)}.
   * <ul>
   *   <li>Then return build plannedRemovals size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkTaxonomyValidationResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyValidationResult); then return build plannedRemovals size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyValidationResult)"})
  void testBuilderFrom_thenReturnBuildPlannedRemovalsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    Builder builderResult2 = ImmutableBulkTaxonomyValidationResult.builder();
    builderResult2.addPlannedRemovals(mock(Measurable.class));
    ImmutableBulkTaxonomyValidatedItem.Json element = new ImmutableBulkTaxonomyValidatedItem.Json();
    builderResult2.addValidatedItems(element);
    ImmutableBulkTaxonomyValidationResult instance = builderResult2.error(new Json()).build();

    // Act and Assert
    ImmutableBulkTaxonomyValidationResult buildResult = builderResult.from(instance).build();
    List<BulkTaxonomyValidatedItem> validatedItemsResult = buildResult.validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertEquals(1, buildResult.plannedRemovals().size());
    assertSame(element, validatedItemsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyValidationResult)}.
   * <ul>
   *   <li>When builder error {@link Json} (default constructor) build.</li>
   *   <li>Then return build is builder error {@link Json} (default constructor) build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkTaxonomyValidationResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyValidationResult); when builder error Json (default constructor) build; then return build is builder error Json (default constructor) build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyValidationResult)"})
  void testBuilderFrom_whenBuilderErrorJsonBuild_thenReturnBuildIsBuilderErrorJsonBuild() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    Builder builderResult2 = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidationResult instance = builderResult2.error(new Json()).build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyValidationResult)}.
   * <ul>
   *   <li>When builder error {@code null} build.</li>
   *   <li>Then return build is builder error {@code null} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkTaxonomyValidationResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyValidationResult); when builder error 'null' build; then return build is builder error 'null' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyValidationResult)"})
  void testBuilderFrom_whenBuilderErrorNullBuild_thenReturnBuildIsBuilderErrorNullBuild() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidationResult instance = ImmutableBulkTaxonomyValidationResult.builder()
        .error(null)
        .build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#plannedRemovals(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#plannedRemovals(Iterable)}
   */
  @Test
  @DisplayName("Test Builder plannedRemovals(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.plannedRemovals(Iterable)"})
  void testBuilderPlannedRemovals_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.plannedRemovals(new ArrayList<>()));
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
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.validatedItems(new ArrayList<>()));
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#copyOf(BulkTaxonomyValidationResult)}.
   * <ul>
   *   <li>When builder error {@link Json} (default constructor) build.</li>
   *   <li>Then return validatedItems Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyValidationResult#copyOf(BulkTaxonomyValidationResult)}
   */
  @Test
  @DisplayName("Test copyOf(BulkTaxonomyValidationResult); when builder error Json (default constructor) build; then return validatedItems Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkTaxonomyValidationResult ImmutableBulkTaxonomyValidationResult.copyOf(BulkTaxonomyValidationResult)"})
  void testCopyOf_whenBuilderErrorJsonBuild_thenReturnValidatedItemsEmpty() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    Json error = new Json();
    ImmutableBulkTaxonomyValidationResult instance = builderResult.error(error).build();

    // Act
    ImmutableBulkTaxonomyValidationResult actualCopyOfResult = ImmutableBulkTaxonomyValidationResult.copyOf(instance);

    // Assert
    assertTrue(actualCopyOfResult.validatedItems().isEmpty());
    assertTrue(actualCopyOfResult.plannedRemovals().isEmpty());
    assertSame(error, actualCopyOfResult.error());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#equals(Object)}, and {@link ImmutableBulkTaxonomyValidationResult#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyValidationResult#equals(Object)}
   *   <li>{@link ImmutableBulkTaxonomyValidationResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkTaxonomyValidationResult.equals(Object)",
      "int ImmutableBulkTaxonomyValidationResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidationResult buildResult = builderResult.error(new Json()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkTaxonomyValidationResult.equals(Object)",
      "int ImmutableBulkTaxonomyValidationResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidationResult buildResult = builderResult.error(new Json()).build();
    Builder builderResult2 = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidationResult buildResult2 = builderResult2.error(new Json()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkTaxonomyValidationResult.equals(Object)",
      "int ImmutableBulkTaxonomyValidationResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    builderResult.addValidatedItems(new ImmutableBulkTaxonomyValidatedItem.Json());
    ImmutableBulkTaxonomyValidationResult buildResult = builderResult.error(new Json()).build();
    Builder builderResult2 = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidationResult buildResult2 = builderResult2.error(new Json()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkTaxonomyValidationResult.equals(Object)",
      "int ImmutableBulkTaxonomyValidationResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    builderResult.addPlannedRemovals(mock(Measurable.class));
    ImmutableBulkTaxonomyValidationResult buildResult = builderResult.error(new Json()).build();
    Builder builderResult2 = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidationResult buildResult2 = builderResult2.error(new Json()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkTaxonomyValidationResult.equals(Object)",
      "int ImmutableBulkTaxonomyValidationResult.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidationResult buildResult = builderResult.error(new Json()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableBulkTaxonomyValidationResult.equals(Object)",
      "int ImmutableBulkTaxonomyValidationResult.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidationResult buildResult = builderResult.error(new Json()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableBulkTaxonomyValidationResult");
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableBulkTaxonomyValidatedItem.Json} (default constructor).</li>
   *   <li>Then return validatedItems is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyValidationResult#fromJson(ImmutableBulkTaxonomyValidationResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add Json (default constructor); then return validatedItems is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkTaxonomyValidationResult ImmutableBulkTaxonomyValidationResult.fromJson(ImmutableBulkTaxonomyValidationResult.Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnValidatedItemsIsArrayList() {
    // Arrange
    ArrayList<BulkTaxonomyValidatedItem> validatedItems = new ArrayList<>();
    validatedItems.add(new ImmutableBulkTaxonomyValidatedItem.Json());

    ImmutableBulkTaxonomyValidationResult.Json json = new ImmutableBulkTaxonomyValidationResult.Json();
    json.setValidatedItems(validatedItems);
    json.setPlannedRemovals(null);
    json.setError(null);

    // Act and Assert
    assertEquals(validatedItems, ImmutableBulkTaxonomyValidationResult.fromJson(json).validatedItems());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableBulkTaxonomyValidatedItem.Json} (default constructor).</li>
   *   <li>Then return validatedItems size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyValidationResult#fromJson(ImmutableBulkTaxonomyValidationResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add Json (default constructor); then return validatedItems size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkTaxonomyValidationResult ImmutableBulkTaxonomyValidationResult.fromJson(ImmutableBulkTaxonomyValidationResult.Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnValidatedItemsSizeIsTwo() {
    // Arrange
    ArrayList<BulkTaxonomyValidatedItem> validatedItems = new ArrayList<>();
    validatedItems.add(new ImmutableBulkTaxonomyValidatedItem.Json());
    ImmutableBulkTaxonomyValidatedItem.Json json = new ImmutableBulkTaxonomyValidatedItem.Json();
    validatedItems.add(json);

    ImmutableBulkTaxonomyValidationResult.Json json2 = new ImmutableBulkTaxonomyValidationResult.Json();
    json2.setValidatedItems(validatedItems);
    json2.setPlannedRemovals(null);
    json2.setError(null);

    // Act and Assert
    List<BulkTaxonomyValidatedItem> validatedItemsResult = ImmutableBulkTaxonomyValidationResult.fromJson(json2)
        .validatedItems();
    assertEquals(2, validatedItemsResult.size());
    assertSame(json, validatedItemsResult.get(1));
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link Json} (default constructor).</li>
   *   <li>When {@link ImmutableBulkTaxonomyValidationResult.Json} (default constructor) Error is {@link Json} (default constructor).</li>
   *   <li>Then return error is {@link Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyValidationResult#fromJson(ImmutableBulkTaxonomyValidationResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given Json (default constructor); when Json (default constructor) Error is Json (default constructor); then return error is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkTaxonomyValidationResult ImmutableBulkTaxonomyValidationResult.fromJson(ImmutableBulkTaxonomyValidationResult.Json)"})
  void testFromJson_givenJson_whenJsonErrorIsJson_thenReturnErrorIsJson() {
    // Arrange
    ImmutableBulkTaxonomyValidationResult.Json json = new ImmutableBulkTaxonomyValidationResult.Json();
    json.setValidatedItems(null);
    json.setPlannedRemovals(null);
    Json error = new Json();
    json.setError(error);

    // Act and Assert
    assertSame(error, ImmutableBulkTaxonomyValidationResult.fromJson(json).error());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link Measurable}.</li>
   *   <li>Then return plannedRemovals size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyValidationResult#fromJson(ImmutableBulkTaxonomyValidationResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add Measurable; then return plannedRemovals size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkTaxonomyValidationResult ImmutableBulkTaxonomyValidationResult.fromJson(ImmutableBulkTaxonomyValidationResult.Json)"})
  void testFromJson_givenLinkedHashSetAddMeasurable_thenReturnPlannedRemovalsSizeIsOne() {
    // Arrange
    LinkedHashSet<Measurable> plannedRemovals = new LinkedHashSet<>();
    plannedRemovals.add(mock(Measurable.class));

    ImmutableBulkTaxonomyValidationResult.Json json = new ImmutableBulkTaxonomyValidationResult.Json();
    json.setValidatedItems(null);
    json.setPlannedRemovals(plannedRemovals);
    json.setError(null);

    // Act
    ImmutableBulkTaxonomyValidationResult actualFromJsonResult = ImmutableBulkTaxonomyValidationResult.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.plannedRemovals().size());
    assertTrue(actualFromJsonResult.validatedItems().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ImmutableBulkTaxonomyValidationResult.Json} (default constructor) ValidatedItems is {@code null}.</li>
   *   <li>Then return error is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyValidationResult#fromJson(ImmutableBulkTaxonomyValidationResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) ValidatedItems is 'null'; then return error is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkTaxonomyValidationResult ImmutableBulkTaxonomyValidationResult.fromJson(ImmutableBulkTaxonomyValidationResult.Json)"})
  void testFromJson_givenNull_whenJsonValidatedItemsIsNull_thenReturnErrorIsNull() {
    // Arrange
    ImmutableBulkTaxonomyValidationResult.Json json = new ImmutableBulkTaxonomyValidationResult.Json();
    json.setValidatedItems(null);
    json.setPlannedRemovals(null);
    json.setError(null);

    // Act
    ImmutableBulkTaxonomyValidationResult actualFromJsonResult = ImmutableBulkTaxonomyValidationResult.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.error());
    assertTrue(actualFromJsonResult.validatedItems().isEmpty());
    assertTrue(actualFromJsonResult.plannedRemovals().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#fromJson(Json)}.
   * <ul>
   *   <li>When {@link ImmutableBulkTaxonomyValidationResult.Json} (default constructor).</li>
   *   <li>Then return error is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyValidationResult#fromJson(ImmutableBulkTaxonomyValidationResult.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return error is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkTaxonomyValidationResult ImmutableBulkTaxonomyValidationResult.fromJson(ImmutableBulkTaxonomyValidationResult.Json)"})
  void testFromJson_whenJson_thenReturnErrorIsNull() {
    // Arrange and Act
    ImmutableBulkTaxonomyValidationResult actualFromJsonResult = ImmutableBulkTaxonomyValidationResult
        .fromJson(new ImmutableBulkTaxonomyValidationResult.Json());

    // Assert
    assertNull(actualFromJsonResult.error());
    assertTrue(actualFromJsonResult.validatedItems().isEmpty());
    assertTrue(actualFromJsonResult.plannedRemovals().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyValidationResult#toString()}
   *   <li>{@link ImmutableBulkTaxonomyValidationResult#error()}
   *   <li>{@link ImmutableBulkTaxonomyValidationResult#plannedRemovals()}
   *   <li>{@link ImmutableBulkTaxonomyValidationResult#validatedItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkTaxonomyParseError ImmutableBulkTaxonomyValidationResult.error()",
      "Set ImmutableBulkTaxonomyValidationResult.plannedRemovals()",
      "java.lang.String ImmutableBulkTaxonomyValidationResult.toString()",
      "List ImmutableBulkTaxonomyValidationResult.validatedItems()"})
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    Json error = new Json();
    ImmutableBulkTaxonomyValidationResult buildResult = builderResult.error(error).build();

    // Act
    buildResult.toString();
    BulkTaxonomyParseError actualErrorResult = buildResult.error();
    Set<Measurable> actualPlannedRemovalsResult = buildResult.plannedRemovals();

    // Assert
    assertTrue(buildResult.validatedItems().isEmpty());
    assertTrue(actualPlannedRemovalsResult.isEmpty());
    assertSame(error, actualErrorResult);
  }

  /**
   * Test Json {@link ImmutableBulkTaxonomyValidationResult.Json#error()}.
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyValidationResult.Json#error()}
   */
  @Test
  @DisplayName("Test Json error()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkTaxonomyParseError ImmutableBulkTaxonomyValidationResult.Json.error()"})
  void testJsonError() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkTaxonomyValidationResult.Json()).error());
  }

  /**
   * Test Json new {@link ImmutableBulkTaxonomyValidationResult.Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ImmutableBulkTaxonomyValidationResult.Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImmutableBulkTaxonomyValidationResult.Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableBulkTaxonomyValidationResult.Json actualJson = new ImmutableBulkTaxonomyValidationResult.Json();

    // Assert
    assertNull(actualJson.error);
    assertTrue(actualJson.validatedItems.isEmpty());
    assertTrue(actualJson.plannedRemovals.isEmpty());
  }

  /**
   * Test Json {@link ImmutableBulkTaxonomyValidationResult.Json#plannedRemovals()}.
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyValidationResult.Json#plannedRemovals()}
   */
  @Test
  @DisplayName("Test Json plannedRemovals()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ImmutableBulkTaxonomyValidationResult.Json.plannedRemovals()"})
  void testJsonPlannedRemovals() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkTaxonomyValidationResult.Json()).plannedRemovals());
  }

  /**
   * Test Json {@link ImmutableBulkTaxonomyValidationResult.Json#validatedItems()}.
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyValidationResult.Json#validatedItems()}
   */
  @Test
  @DisplayName("Test Json validatedItems()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ImmutableBulkTaxonomyValidationResult.Json.validatedItems()"})
  void testJsonValidatedItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkTaxonomyValidationResult.Json()).validatedItems());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#withError(BulkTaxonomyParseError)}.
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyValidationResult#withError(BulkTaxonomyParseError)}
   */
  @Test
  @DisplayName("Test withError(BulkTaxonomyParseError)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkTaxonomyValidationResult ImmutableBulkTaxonomyValidationResult.withError(BulkTaxonomyParseError)"})
  void testWithError() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidationResult buildResult = builderResult.error(new Json()).build();
    Json value = new Json();

    // Act
    ImmutableBulkTaxonomyValidationResult actualWithErrorResult = buildResult.withError(value);

    // Assert
    assertTrue(actualWithErrorResult.validatedItems().isEmpty());
    assertTrue(actualWithErrorResult.plannedRemovals().isEmpty());
    assertSame(value, actualWithErrorResult.error());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#withPlannedRemovals(Measurable[])} with {@code Measurable[]}.
   * <ul>
   *   <li>Then return plannedRemovals size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyValidationResult#withPlannedRemovals(Measurable[])}
   */
  @Test
  @DisplayName("Test withPlannedRemovals(Measurable[]) with 'Measurable[]'; then return plannedRemovals size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkTaxonomyValidationResult ImmutableBulkTaxonomyValidationResult.withPlannedRemovals(Measurable[])"})
  void testWithPlannedRemovalsWithMeasurable_thenReturnPlannedRemovalsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    Json error = new Json();
    ImmutableBulkTaxonomyValidationResult buildResult = builderResult.error(error).build();

    // Act
    ImmutableBulkTaxonomyValidationResult actualWithPlannedRemovalsResult = buildResult
        .withPlannedRemovals(mock(Measurable.class));

    // Assert
    assertEquals(1, actualWithPlannedRemovalsResult.plannedRemovals().size());
    assertTrue(actualWithPlannedRemovalsResult.validatedItems().isEmpty());
    assertSame(error, actualWithPlannedRemovalsResult.error());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#withValidatedItems(BulkTaxonomyValidatedItem[])} with {@code BulkTaxonomyValidatedItem[]}.
   * <p>
   * Method under test: {@link ImmutableBulkTaxonomyValidationResult#withValidatedItems(BulkTaxonomyValidatedItem[])}
   */
  @Test
  @DisplayName("Test withValidatedItems(BulkTaxonomyValidatedItem[]) with 'BulkTaxonomyValidatedItem[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableBulkTaxonomyValidationResult ImmutableBulkTaxonomyValidationResult.withValidatedItems(BulkTaxonomyValidatedItem[])"})
  void testWithValidatedItemsWithBulkTaxonomyValidatedItem() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    Json error = new Json();
    ImmutableBulkTaxonomyValidationResult buildResult = builderResult.error(error).build();
    ImmutableBulkTaxonomyValidatedItem.Json json = new ImmutableBulkTaxonomyValidatedItem.Json();

    // Act
    ImmutableBulkTaxonomyValidationResult actualWithValidatedItemsResult = buildResult.withValidatedItems(json);

    // Assert
    List<BulkTaxonomyValidatedItem> validatedItemsResult = actualWithValidatedItemsResult.validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertTrue(actualWithValidatedItemsResult.plannedRemovals().isEmpty());
    assertSame(error, actualWithValidatedItemsResult.error());
    assertSame(json, validatedItemsResult.get(0));
  }
}
