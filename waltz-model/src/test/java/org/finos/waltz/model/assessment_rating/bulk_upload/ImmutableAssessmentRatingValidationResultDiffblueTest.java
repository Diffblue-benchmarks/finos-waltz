package org.finos.waltz.model.assessment_rating.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.EntityReference;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingValidationResultDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult.Builder#addAllRemovals(Iterable)}
   */
  @Test
  void testBuilderAddAllRemovals() {
    // Arrange
    ImmutableAssessmentRatingValidationResult.Builder builderResult = ImmutableAssessmentRatingValidationResult
        .builder();

    // Act
    ImmutableAssessmentRatingValidationResult.Builder actualAddAllRemovalsResult = builderResult
        .addAllRemovals(new ArrayList<>());

    // Assert
    assertEquals(0, builderResult.build().removalCount());
    assertSame(builderResult, actualAddAllRemovalsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult.Builder#addAllValidatedItems(Iterable)}
   */
  @Test
  void testBuilderAddAllValidatedItems() {
    // Arrange
    ImmutableAssessmentRatingValidationResult.Builder builderResult = ImmutableAssessmentRatingValidationResult
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllValidatedItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult.Builder#addAllValidatedItems(Iterable)}
   */
  @Test
  void testBuilderAddAllValidatedItems2() {
    // Arrange
    ImmutableAssessmentRatingValidationResult.Builder builderResult = ImmutableAssessmentRatingValidationResult
        .builder();
    builderResult.addRemovals(new Tuple2<>(mock(EntityReference.class), 1L));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllValidatedItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult.Builder#addRemovals(Tuple2)}
   */
  @Test
  void testBuilderAddRemovals() {
    // Arrange
    ImmutableAssessmentRatingValidationResult.Builder builderResult = ImmutableAssessmentRatingValidationResult
        .builder();

    // Act
    ImmutableAssessmentRatingValidationResult.Builder actualAddRemovalsResult = builderResult
        .addRemovals(new Tuple2<>(mock(EntityReference.class), 1L));

    // Assert
    ImmutableAssessmentRatingValidationResult buildResult = builderResult.build();
    assertEquals(1, buildResult.removals().size());
    assertEquals(1, buildResult.removalCount());
    assertSame(builderResult, actualAddRemovalsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult.Builder#addRemovals(Tuple2[])}
   */
  @Test
  void testBuilderAddRemovals2() {
    // Arrange
    ImmutableAssessmentRatingValidationResult.Builder builderResult = ImmutableAssessmentRatingValidationResult
        .builder();

    // Act
    ImmutableAssessmentRatingValidationResult.Builder actualAddRemovalsResult = builderResult
        .addRemovals(new Tuple2<>(mock(EntityReference.class), 1L));

    // Assert
    ImmutableAssessmentRatingValidationResult buildResult = builderResult.build();
    assertEquals(1, buildResult.removals().size());
    assertEquals(1, buildResult.removalCount());
    assertSame(builderResult, actualAddRemovalsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult.Builder#addValidatedItems(AssessmentRatingValidatedItem)}
   */
  @Test
  void testBuilderAddValidatedItems() {
    // Arrange
    ImmutableAssessmentRatingValidationResult.Builder builderResult = ImmutableAssessmentRatingValidationResult
        .builder();
    ImmutableAssessmentRatingValidatedItem.Json element = new ImmutableAssessmentRatingValidatedItem.Json();

    // Act
    ImmutableAssessmentRatingValidationResult.Builder actualAddValidatedItemsResult = builderResult
        .addValidatedItems(element);

    // Assert
    List<AssessmentRatingValidatedItem> validatedItemsResult = builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(element, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult.Builder#addValidatedItems(AssessmentRatingValidatedItem)}
   */
  @Test
  void testBuilderAddValidatedItems2() {
    // Arrange
    ImmutableAssessmentRatingValidationResult.Builder builderResult = ImmutableAssessmentRatingValidationResult
        .builder();
    builderResult.addRemovals(new Tuple2<>(mock(EntityReference.class), 1L));
    ImmutableAssessmentRatingValidatedItem.Json element = new ImmutableAssessmentRatingValidatedItem.Json();

    // Act
    ImmutableAssessmentRatingValidationResult.Builder actualAddValidatedItemsResult = builderResult
        .addValidatedItems(element);

    // Assert
    List<AssessmentRatingValidatedItem> validatedItemsResult = builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(element, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult.Builder#addValidatedItems(AssessmentRatingValidatedItem[])}
   */
  @Test
  void testBuilderAddValidatedItems3() {
    // Arrange
    ImmutableAssessmentRatingValidationResult.Builder builderResult = ImmutableAssessmentRatingValidationResult
        .builder();
    ImmutableAssessmentRatingValidatedItem.Json json = new ImmutableAssessmentRatingValidatedItem.Json();

    // Act
    ImmutableAssessmentRatingValidationResult.Builder actualAddValidatedItemsResult = builderResult
        .addValidatedItems(json);

    // Assert
    List<AssessmentRatingValidatedItem> validatedItemsResult = builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(json, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult.Builder#addValidatedItems(AssessmentRatingValidatedItem[])}
   */
  @Test
  void testBuilderAddValidatedItems4() {
    // Arrange
    ImmutableAssessmentRatingValidationResult.Builder builderResult = ImmutableAssessmentRatingValidationResult
        .builder();
    builderResult.addRemovals(new Tuple2<>(mock(EntityReference.class), 1L));
    ImmutableAssessmentRatingValidatedItem.Json json = new ImmutableAssessmentRatingValidatedItem.Json();

    // Act
    ImmutableAssessmentRatingValidationResult.Builder actualAddValidatedItemsResult = builderResult
        .addValidatedItems(json);

    // Assert
    List<AssessmentRatingValidatedItem> validatedItemsResult = builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(json, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingValidationResult.Builder#build()}
   *   <li>
   * {@link ImmutableAssessmentRatingValidationResult.Builder#error(AssessmentRatingParsedResult.AssessmentRatingParseError)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange
    ImmutableAssessmentRatingValidationResult.Builder builderResult = ImmutableAssessmentRatingValidationResult
        .builder();
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
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult.Builder#from(AssessmentRatingValidationResult)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentRatingValidationResult.Builder builderResult = ImmutableAssessmentRatingValidationResult
        .builder();
    AssessmentRatingValidationResult instance = mock(AssessmentRatingValidationResult.class);
    when(instance.validatedItems()).thenReturn(new ArrayList<>());
    when(instance.removals()).thenReturn(new HashSet<>());
    ImmutableAssessmentRatingParseError.Json json = new ImmutableAssessmentRatingParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableAssessmentRatingValidationResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).removals();
    verify(instance).validatedItems();
    ImmutableAssessmentRatingValidationResult buildResult = builderResult.build();
    assertEquals(0, buildResult.removalCount());
    assertSame(json, buildResult.error());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult.Builder#from(AssessmentRatingValidationResult)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssessmentRatingValidationResult.Builder builderResult = ImmutableAssessmentRatingValidationResult
        .builder();

    ArrayList<AssessmentRatingValidatedItem> assessmentRatingValidatedItemList = new ArrayList<>();
    ImmutableAssessmentRatingValidatedItem.Json json = new ImmutableAssessmentRatingValidatedItem.Json();
    assessmentRatingValidatedItemList.add(json);
    AssessmentRatingValidationResult instance = mock(AssessmentRatingValidationResult.class);
    when(instance.validatedItems()).thenReturn(assessmentRatingValidatedItemList);
    when(instance.removals()).thenReturn(new HashSet<>());
    ImmutableAssessmentRatingParseError.Json json2 = new ImmutableAssessmentRatingParseError.Json();
    when(instance.error()).thenReturn(json2);

    // Act
    ImmutableAssessmentRatingValidationResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).removals();
    verify(instance).validatedItems();
    ImmutableAssessmentRatingValidationResult buildResult = builderResult.build();
    assertEquals(0, buildResult.removalCount());
    List<AssessmentRatingValidatedItem> validatedItemsResult = buildResult.validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(json2, buildResult.error());
    assertSame(json, validatedItemsResult.get(0));
    assertSame(builderResult, actualFromResult);
    Set<ValidationError> expectedRemovalsResult = json.errors;
    assertSame(expectedRemovalsResult, buildResult.removals());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult.Builder#from(AssessmentRatingValidationResult)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAssessmentRatingValidationResult.Builder builderResult = ImmutableAssessmentRatingValidationResult
        .builder();

    HashSet<Tuple2<EntityReference, Long>> tuple2Set = new HashSet<>();
    tuple2Set.add(new Tuple2<>(null, 1L));
    AssessmentRatingValidationResult instance = mock(AssessmentRatingValidationResult.class);
    when(instance.validatedItems()).thenReturn(new ArrayList<>());
    when(instance.removals()).thenReturn(tuple2Set);
    ImmutableAssessmentRatingParseError.Json json = new ImmutableAssessmentRatingParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableAssessmentRatingValidationResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).removals();
    verify(instance).validatedItems();
    ImmutableAssessmentRatingValidationResult buildResult = builderResult.build();
    assertEquals(1, buildResult.removals().size());
    assertEquals(1, buildResult.removalCount());
    assertSame(json, buildResult.error());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult.Builder#from(AssessmentRatingValidationResult)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAssessmentRatingValidationResult.Builder builderResult = ImmutableAssessmentRatingValidationResult
        .builder();
    AssessmentRatingValidationResult instance = mock(AssessmentRatingValidationResult.class);
    when(instance.validatedItems()).thenReturn(new ArrayList<>());
    when(instance.removals()).thenReturn(new HashSet<>());
    when(instance.error()).thenReturn(null);

    // Act
    ImmutableAssessmentRatingValidationResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).removals();
    verify(instance).validatedItems();
    ImmutableAssessmentRatingValidationResult buildResult = builderResult.build();
    assertNull(buildResult.error());
    assertEquals(0, buildResult.removalCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult.Builder#removals(Iterable)}
   */
  @Test
  void testBuilderRemovals() {
    // Arrange
    ImmutableAssessmentRatingValidationResult.Builder builderResult = ImmutableAssessmentRatingValidationResult
        .builder();

    // Act
    ImmutableAssessmentRatingValidationResult.Builder actualRemovalsResult = builderResult.removals(new ArrayList<>());

    // Assert
    assertEquals(0, builderResult.build().removalCount());
    assertSame(builderResult, actualRemovalsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult.Builder#validatedItems(Iterable)}
   */
  @Test
  void testBuilderValidatedItems() {
    // Arrange
    ImmutableAssessmentRatingValidationResult.Builder builderResult = ImmutableAssessmentRatingValidationResult
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.validatedItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult.Builder#validatedItems(Iterable)}
   */
  @Test
  void testBuilderValidatedItems2() {
    // Arrange
    ImmutableAssessmentRatingValidationResult.Builder builderResult = ImmutableAssessmentRatingValidationResult
        .builder();
    builderResult.addRemovals(new Tuple2<>(mock(EntityReference.class), 1L));

    // Act and Assert
    assertSame(builderResult, builderResult.validatedItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult#copyOf(AssessmentRatingValidationResult)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentRatingValidationResult instance = mock(AssessmentRatingValidationResult.class);
    when(instance.validatedItems()).thenReturn(new ArrayList<>());
    when(instance.removals()).thenReturn(new HashSet<>());
    ImmutableAssessmentRatingParseError.Json json = new ImmutableAssessmentRatingParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableAssessmentRatingValidationResult actualCopyOfResult = ImmutableAssessmentRatingValidationResult
        .copyOf(instance);

    // Assert
    verify(instance).error();
    verify(instance).removals();
    verify(instance).validatedItems();
    assertEquals(0, actualCopyOfResult.removalCount());
    assertTrue(actualCopyOfResult.validatedItems().isEmpty());
    assertTrue(actualCopyOfResult.removals().isEmpty());
    assertSame(json, actualCopyOfResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult#copyOf(AssessmentRatingValidationResult)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<AssessmentRatingValidatedItem> assessmentRatingValidatedItemList = new ArrayList<>();
    ImmutableAssessmentRatingValidatedItem.Json json = new ImmutableAssessmentRatingValidatedItem.Json();
    assessmentRatingValidatedItemList.add(json);
    AssessmentRatingValidationResult instance = mock(AssessmentRatingValidationResult.class);
    when(instance.validatedItems()).thenReturn(assessmentRatingValidatedItemList);
    when(instance.removals()).thenReturn(new HashSet<>());
    ImmutableAssessmentRatingParseError.Json json2 = new ImmutableAssessmentRatingParseError.Json();
    when(instance.error()).thenReturn(json2);

    // Act
    ImmutableAssessmentRatingValidationResult actualCopyOfResult = ImmutableAssessmentRatingValidationResult
        .copyOf(instance);

    // Assert
    verify(instance).error();
    verify(instance).removals();
    verify(instance).validatedItems();
    assertEquals(0, actualCopyOfResult.removalCount());
    Set<Tuple2<EntityReference, Long>> removalsResult = actualCopyOfResult.removals();
    assertTrue(removalsResult.isEmpty());
    assertEquals(assessmentRatingValidatedItemList, actualCopyOfResult.validatedItems());
    assertSame(json2, actualCopyOfResult.error());
    assertSame(json.errors, removalsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult#copyOf(AssessmentRatingValidationResult)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<AssessmentRatingValidatedItem> assessmentRatingValidatedItemList = new ArrayList<>();
    assessmentRatingValidatedItemList.add(new ImmutableAssessmentRatingValidatedItem.Json());
    ImmutableAssessmentRatingValidatedItem.Json json = new ImmutableAssessmentRatingValidatedItem.Json();
    assessmentRatingValidatedItemList.add(json);
    AssessmentRatingValidationResult instance = mock(AssessmentRatingValidationResult.class);
    when(instance.validatedItems()).thenReturn(assessmentRatingValidatedItemList);
    when(instance.removals()).thenReturn(new HashSet<>());
    ImmutableAssessmentRatingParseError.Json json2 = new ImmutableAssessmentRatingParseError.Json();
    when(instance.error()).thenReturn(json2);

    // Act
    ImmutableAssessmentRatingValidationResult actualCopyOfResult = ImmutableAssessmentRatingValidationResult
        .copyOf(instance);

    // Assert
    verify(instance).error();
    verify(instance).removals();
    verify(instance).validatedItems();
    assertEquals(0, actualCopyOfResult.removalCount());
    Set<Tuple2<EntityReference, Long>> removalsResult = actualCopyOfResult.removals();
    assertTrue(removalsResult.isEmpty());
    assertEquals(assessmentRatingValidatedItemList, actualCopyOfResult.validatedItems());
    assertSame(json2, actualCopyOfResult.error());
    assertSame(json.errors, removalsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult#copyOf(AssessmentRatingValidationResult)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<Tuple2<EntityReference, Long>> tuple2Set = new HashSet<>();
    tuple2Set.add(new Tuple2<>(null, 1L));
    AssessmentRatingValidationResult instance = mock(AssessmentRatingValidationResult.class);
    when(instance.validatedItems()).thenReturn(new ArrayList<>());
    when(instance.removals()).thenReturn(tuple2Set);
    ImmutableAssessmentRatingParseError.Json json = new ImmutableAssessmentRatingParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableAssessmentRatingValidationResult actualCopyOfResult = ImmutableAssessmentRatingValidationResult
        .copyOf(instance);

    // Assert
    verify(instance).error();
    verify(instance).removals();
    verify(instance).validatedItems();
    assertEquals(1, actualCopyOfResult.removals().size());
    assertEquals(1, actualCopyOfResult.removalCount());
    assertTrue(actualCopyOfResult.validatedItems().isEmpty());
    assertSame(json, actualCopyOfResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult#copyOf(AssessmentRatingValidationResult)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    AssessmentRatingValidationResult instance = mock(AssessmentRatingValidationResult.class);
    when(instance.validatedItems()).thenReturn(new ArrayList<>());
    when(instance.removals()).thenReturn(new HashSet<>());
    when(instance.error()).thenReturn(null);

    // Act
    ImmutableAssessmentRatingValidationResult actualCopyOfResult = ImmutableAssessmentRatingValidationResult
        .copyOf(instance);

    // Assert
    verify(instance).error();
    verify(instance).removals();
    verify(instance).validatedItems();
    assertNull(actualCopyOfResult.error());
    assertEquals(0, actualCopyOfResult.removalCount());
    assertTrue(actualCopyOfResult.validatedItems().isEmpty());
    assertTrue(actualCopyOfResult.removals().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult#copyOf(AssessmentRatingValidationResult)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    HashSet<Tuple2<EntityReference, Long>> tuple2Set = new HashSet<>();
    tuple2Set.add(mock(Tuple2.class));
    tuple2Set.add(new Tuple2<>(null, 1L));
    AssessmentRatingValidationResult instance = mock(AssessmentRatingValidationResult.class);
    when(instance.validatedItems()).thenReturn(new ArrayList<>());
    when(instance.removals()).thenReturn(tuple2Set);
    ImmutableAssessmentRatingParseError.Json json = new ImmutableAssessmentRatingParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableAssessmentRatingValidationResult actualCopyOfResult = ImmutableAssessmentRatingValidationResult
        .copyOf(instance);

    // Assert
    verify(instance).error();
    verify(instance).removals();
    verify(instance).validatedItems();
    assertEquals(2, actualCopyOfResult.removalCount());
    assertTrue(actualCopyOfResult.validatedItems().isEmpty());
    assertEquals(tuple2Set, actualCopyOfResult.removals());
    assertSame(json, actualCopyOfResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult#fromJson(ImmutableAssessmentRatingValidationResult.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAssessmentRatingValidationResult.Json json = new ImmutableAssessmentRatingValidationResult.Json();

    // Act
    ImmutableAssessmentRatingValidationResult actualFromJsonResult = ImmutableAssessmentRatingValidationResult
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.error());
    assertEquals(0, actualFromJsonResult.removalCount());
    List<AssessmentRatingValidatedItem> validatedItemsResult = actualFromJsonResult.validatedItems();
    assertTrue(validatedItemsResult.isEmpty());
    Set<Tuple2<EntityReference, Long>> removalsResult = actualFromJsonResult.removals();
    assertTrue(removalsResult.isEmpty());
    assertSame(json.removals, removalsResult);
    assertSame(json.validatedItems, validatedItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult#fromJson(ImmutableAssessmentRatingValidationResult.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableAssessmentRatingValidationResult.Json json = new ImmutableAssessmentRatingValidationResult.Json();
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
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult#fromJson(ImmutableAssessmentRatingValidationResult.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<Tuple2<EntityReference, Long>> removals = new LinkedHashSet<>();
    removals.add(new Tuple2<>(mock(EntityReference.class), 1L));

    ImmutableAssessmentRatingValidationResult.Json json = new ImmutableAssessmentRatingValidationResult.Json();
    json.setValidatedItems(null);
    json.setError(null);
    json.setRemovals(removals);

    // Act
    ImmutableAssessmentRatingValidationResult actualFromJsonResult = ImmutableAssessmentRatingValidationResult
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.error());
    assertEquals(1, actualFromJsonResult.removals().size());
    assertEquals(1, actualFromJsonResult.removalCount());
    assertTrue(actualFromJsonResult.validatedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult#fromJson(ImmutableAssessmentRatingValidationResult.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    ImmutableAssessmentRatingValidationResult.Json json = new ImmutableAssessmentRatingValidationResult.Json();
    json.setValidatedItems(null);
    ImmutableAssessmentRatingParseError.Json error = new ImmutableAssessmentRatingParseError.Json();
    json.setError(error);
    json.setRemovals(null);

    // Act
    ImmutableAssessmentRatingValidationResult actualFromJsonResult = ImmutableAssessmentRatingValidationResult
        .fromJson(json);

    // Assert
    assertEquals(0, actualFromJsonResult.removalCount());
    assertTrue(actualFromJsonResult.validatedItems().isEmpty());
    assertTrue(actualFromJsonResult.removals().isEmpty());
    assertSame(error, actualFromJsonResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult#fromJson(ImmutableAssessmentRatingValidationResult.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    ArrayList<AssessmentRatingValidatedItem> validatedItems = new ArrayList<>();
    ImmutableAssessmentRatingValidatedItem.Json json = new ImmutableAssessmentRatingValidatedItem.Json();
    validatedItems.add(json);

    ImmutableAssessmentRatingValidationResult.Json json2 = new ImmutableAssessmentRatingValidationResult.Json();
    json2.setValidatedItems(validatedItems);
    json2.setError(null);
    json2.setRemovals(null);

    // Act
    ImmutableAssessmentRatingValidationResult actualFromJsonResult = ImmutableAssessmentRatingValidationResult
        .fromJson(json2);

    // Assert
    assertNull(actualFromJsonResult.error());
    assertEquals(0, actualFromJsonResult.removalCount());
    Set<Tuple2<EntityReference, Long>> removalsResult = actualFromJsonResult.removals();
    assertTrue(removalsResult.isEmpty());
    assertEquals(validatedItems, actualFromJsonResult.validatedItems());
    assertSame(json.errors, removalsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult#fromJson(ImmutableAssessmentRatingValidationResult.Json)}
   */
  @Test
  void testFromJson6() {
    // Arrange
    LinkedHashSet<Tuple2<EntityReference, Long>> removals = new LinkedHashSet<>();
    removals.add(new Tuple2<>(mock(EntityReference.class), 1L));
    removals.add(new Tuple2<>(mock(EntityReference.class), 1L));

    ImmutableAssessmentRatingValidationResult.Json json = new ImmutableAssessmentRatingValidationResult.Json();
    json.setValidatedItems(null);
    json.setError(null);
    json.setRemovals(removals);

    // Act
    ImmutableAssessmentRatingValidationResult actualFromJsonResult = ImmutableAssessmentRatingValidationResult
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.error());
    assertEquals(2, actualFromJsonResult.removalCount());
    assertTrue(actualFromJsonResult.validatedItems().isEmpty());
    assertEquals(removals, actualFromJsonResult.removals());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult#fromJson(ImmutableAssessmentRatingValidationResult.Json)}
   */
  @Test
  void testFromJson7() {
    // Arrange
    ArrayList<AssessmentRatingValidatedItem> validatedItems = new ArrayList<>();
    validatedItems.add(new ImmutableAssessmentRatingValidatedItem.Json());
    ImmutableAssessmentRatingValidatedItem.Json json = new ImmutableAssessmentRatingValidatedItem.Json();
    validatedItems.add(json);

    ImmutableAssessmentRatingValidationResult.Json json2 = new ImmutableAssessmentRatingValidationResult.Json();
    json2.setValidatedItems(validatedItems);
    json2.setError(null);
    json2.setRemovals(null);

    // Act
    ImmutableAssessmentRatingValidationResult actualFromJsonResult = ImmutableAssessmentRatingValidationResult
        .fromJson(json2);

    // Assert
    assertNull(actualFromJsonResult.error());
    assertEquals(0, actualFromJsonResult.removalCount());
    Set<Tuple2<EntityReference, Long>> removalsResult = actualFromJsonResult.removals();
    assertTrue(removalsResult.isEmpty());
    assertEquals(validatedItems, actualFromJsonResult.validatedItems());
    assertSame(json.errors, removalsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult.Json#error()}
   */
  @Test
  void testJsonError() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingValidationResult.Json()).error());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAssessmentRatingValidationResult.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAssessmentRatingValidationResult.Json actualJson = new ImmutableAssessmentRatingValidationResult.Json();

    // Assert
    assertNull(actualJson.error);
    assertTrue(actualJson.validatedItems.isEmpty());
    assertTrue(actualJson.removals.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult.Json#removalCount()}
   */
  @Test
  void testJsonRemovalCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingValidationResult.Json()).removalCount());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult.Json#removals()}
   */
  @Test
  void testJsonRemovals() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingValidationResult.Json()).removals());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingValidationResult.Json#validatedItems()}
   */
  @Test
  void testJsonValidatedItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingValidationResult.Json()).validatedItems());
  }
}
