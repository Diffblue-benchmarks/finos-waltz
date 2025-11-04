package org.finos.waltz.model.bulk_upload.measurable_rating;

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

class ImmutableBulkMeasurableRatingValidationResultDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult.Builder#addAllRemovals(Iterable)}
   */
  @Test
  void testBuilderAddAllRemovals() {
    // Arrange
    ImmutableBulkMeasurableRatingValidationResult.Builder builderResult = ImmutableBulkMeasurableRatingValidationResult
        .builder();

    // Act
    ImmutableBulkMeasurableRatingValidationResult.Builder actualAddAllRemovalsResult = builderResult
        .addAllRemovals(new ArrayList<>());

    // Assert
    assertEquals(0, builderResult.build().removalCount());
    assertSame(builderResult, actualAddAllRemovalsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult.Builder#addAllValidatedItems(Iterable)}
   */
  @Test
  void testBuilderAddAllValidatedItems() {
    // Arrange
    ImmutableBulkMeasurableRatingValidationResult.Builder builderResult = ImmutableBulkMeasurableRatingValidationResult
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllValidatedItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult.Builder#addAllValidatedItems(Iterable)}
   */
  @Test
  void testBuilderAddAllValidatedItems2() {
    // Arrange
    ImmutableBulkMeasurableRatingValidationResult.Builder builderResult = ImmutableBulkMeasurableRatingValidationResult
        .builder();
    builderResult.addRemovals(new Tuple2<>(mock(EntityReference.class), 1L));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllValidatedItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult.Builder#addRemovals(Tuple2)}
   */
  @Test
  void testBuilderAddRemovals() {
    // Arrange
    ImmutableBulkMeasurableRatingValidationResult.Builder builderResult = ImmutableBulkMeasurableRatingValidationResult
        .builder();

    // Act
    ImmutableBulkMeasurableRatingValidationResult.Builder actualAddRemovalsResult = builderResult
        .addRemovals(new Tuple2<>(mock(EntityReference.class), 1L));

    // Assert
    ImmutableBulkMeasurableRatingValidationResult buildResult = builderResult.build();
    assertEquals(1, buildResult.removals().size());
    assertEquals(1, buildResult.removalCount());
    assertSame(builderResult, actualAddRemovalsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult.Builder#addRemovals(Tuple2[])}
   */
  @Test
  void testBuilderAddRemovals2() {
    // Arrange
    ImmutableBulkMeasurableRatingValidationResult.Builder builderResult = ImmutableBulkMeasurableRatingValidationResult
        .builder();

    // Act
    ImmutableBulkMeasurableRatingValidationResult.Builder actualAddRemovalsResult = builderResult
        .addRemovals(new Tuple2<>(mock(EntityReference.class), 1L));

    // Assert
    ImmutableBulkMeasurableRatingValidationResult buildResult = builderResult.build();
    assertEquals(1, buildResult.removals().size());
    assertEquals(1, buildResult.removalCount());
    assertSame(builderResult, actualAddRemovalsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult.Builder#addValidatedItems(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  void testBuilderAddValidatedItems() {
    // Arrange
    ImmutableBulkMeasurableRatingValidationResult.Builder builderResult = ImmutableBulkMeasurableRatingValidationResult
        .builder();
    ImmutableBulkMeasurableRatingValidatedItem.Json element = new ImmutableBulkMeasurableRatingValidatedItem.Json();

    // Act
    ImmutableBulkMeasurableRatingValidationResult.Builder actualAddValidatedItemsResult = builderResult
        .addValidatedItems(element);

    // Assert
    List<BulkMeasurableRatingValidatedItem> validatedItemsResult = builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(element, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult.Builder#addValidatedItems(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  void testBuilderAddValidatedItems2() {
    // Arrange
    ImmutableBulkMeasurableRatingValidationResult.Builder builderResult = ImmutableBulkMeasurableRatingValidationResult
        .builder();
    builderResult.addRemovals(new Tuple2<>(mock(EntityReference.class), 1L));
    ImmutableBulkMeasurableRatingValidatedItem.Json element = new ImmutableBulkMeasurableRatingValidatedItem.Json();

    // Act
    ImmutableBulkMeasurableRatingValidationResult.Builder actualAddValidatedItemsResult = builderResult
        .addValidatedItems(element);

    // Assert
    List<BulkMeasurableRatingValidatedItem> validatedItemsResult = builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(element, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult.Builder#addValidatedItems(BulkMeasurableRatingValidatedItem[])}
   */
  @Test
  void testBuilderAddValidatedItems3() {
    // Arrange
    ImmutableBulkMeasurableRatingValidationResult.Builder builderResult = ImmutableBulkMeasurableRatingValidationResult
        .builder();
    ImmutableBulkMeasurableRatingValidatedItem.Json json = new ImmutableBulkMeasurableRatingValidatedItem.Json();

    // Act
    ImmutableBulkMeasurableRatingValidationResult.Builder actualAddValidatedItemsResult = builderResult
        .addValidatedItems(json);

    // Assert
    List<BulkMeasurableRatingValidatedItem> validatedItemsResult = builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(json, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult.Builder#addValidatedItems(BulkMeasurableRatingValidatedItem[])}
   */
  @Test
  void testBuilderAddValidatedItems4() {
    // Arrange
    ImmutableBulkMeasurableRatingValidationResult.Builder builderResult = ImmutableBulkMeasurableRatingValidationResult
        .builder();
    builderResult.addRemovals(new Tuple2<>(mock(EntityReference.class), 1L));
    ImmutableBulkMeasurableRatingValidatedItem.Json json = new ImmutableBulkMeasurableRatingValidatedItem.Json();

    // Act
    ImmutableBulkMeasurableRatingValidationResult.Builder actualAddValidatedItemsResult = builderResult
        .addValidatedItems(json);

    // Assert
    List<BulkMeasurableRatingValidatedItem> validatedItemsResult = builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(json, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkMeasurableRatingValidationResult.Builder#build()}
   *   <li>
   * {@link ImmutableBulkMeasurableRatingValidationResult.Builder#error(BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange
    ImmutableBulkMeasurableRatingValidationResult.Builder builderResult = ImmutableBulkMeasurableRatingValidationResult
        .builder();
    ImmutableBulkMeasurableRatingParseError.Json error = new ImmutableBulkMeasurableRatingParseError.Json();

    // Act
    ImmutableBulkMeasurableRatingValidationResult actualBuildResult = builderResult.error(error).build();

    // Assert
    assertEquals(0, actualBuildResult.removalCount());
    assertTrue(actualBuildResult.validatedItems().isEmpty());
    assertTrue(actualBuildResult.removals().isEmpty());
    assertSame(error, actualBuildResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult.Builder#from(BulkMeasurableRatingValidationResult)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBulkMeasurableRatingValidationResult.Builder builderResult = ImmutableBulkMeasurableRatingValidationResult
        .builder();
    BulkMeasurableRatingValidationResult instance = mock(BulkMeasurableRatingValidationResult.class);
    when(instance.validatedItems()).thenReturn(new ArrayList<>());
    when(instance.removals()).thenReturn(new HashSet<>());
    ImmutableBulkMeasurableRatingParseError.Json json = new ImmutableBulkMeasurableRatingParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableBulkMeasurableRatingValidationResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).removals();
    verify(instance).validatedItems();
    ImmutableBulkMeasurableRatingValidationResult buildResult = builderResult.build();
    assertEquals(0, buildResult.removalCount());
    assertSame(json, buildResult.error());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult.Builder#from(BulkMeasurableRatingValidationResult)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBulkMeasurableRatingValidationResult.Builder builderResult = ImmutableBulkMeasurableRatingValidationResult
        .builder();

    ArrayList<BulkMeasurableRatingValidatedItem> bulkMeasurableRatingValidatedItemList = new ArrayList<>();
    ImmutableBulkMeasurableRatingValidatedItem.Json json = new ImmutableBulkMeasurableRatingValidatedItem.Json();
    bulkMeasurableRatingValidatedItemList.add(json);
    BulkMeasurableRatingValidationResult instance = mock(BulkMeasurableRatingValidationResult.class);
    when(instance.validatedItems()).thenReturn(bulkMeasurableRatingValidatedItemList);
    when(instance.removals()).thenReturn(new HashSet<>());
    ImmutableBulkMeasurableRatingParseError.Json json2 = new ImmutableBulkMeasurableRatingParseError.Json();
    when(instance.error()).thenReturn(json2);

    // Act
    ImmutableBulkMeasurableRatingValidationResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).removals();
    verify(instance).validatedItems();
    ImmutableBulkMeasurableRatingValidationResult buildResult = builderResult.build();
    assertEquals(0, buildResult.removalCount());
    List<BulkMeasurableRatingValidatedItem> validatedItemsResult = buildResult.validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(json2, buildResult.error());
    assertSame(json, validatedItemsResult.get(0));
    assertSame(builderResult, actualFromResult);
    Set<ValidationError> expectedRemovalsResult = json.errors;
    assertSame(expectedRemovalsResult, buildResult.removals());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult.Builder#from(BulkMeasurableRatingValidationResult)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableBulkMeasurableRatingValidationResult.Builder builderResult = ImmutableBulkMeasurableRatingValidationResult
        .builder();

    HashSet<Tuple2<EntityReference, Long>> tuple2Set = new HashSet<>();
    tuple2Set.add(new Tuple2<>(null, 1L));
    BulkMeasurableRatingValidationResult instance = mock(BulkMeasurableRatingValidationResult.class);
    when(instance.validatedItems()).thenReturn(new ArrayList<>());
    when(instance.removals()).thenReturn(tuple2Set);
    ImmutableBulkMeasurableRatingParseError.Json json = new ImmutableBulkMeasurableRatingParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableBulkMeasurableRatingValidationResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).removals();
    verify(instance).validatedItems();
    ImmutableBulkMeasurableRatingValidationResult buildResult = builderResult.build();
    assertEquals(1, buildResult.removals().size());
    assertEquals(1, buildResult.removalCount());
    assertSame(json, buildResult.error());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult.Builder#from(BulkMeasurableRatingValidationResult)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableBulkMeasurableRatingValidationResult.Builder builderResult = ImmutableBulkMeasurableRatingValidationResult
        .builder();
    BulkMeasurableRatingValidationResult instance = mock(BulkMeasurableRatingValidationResult.class);
    when(instance.validatedItems()).thenReturn(new ArrayList<>());
    when(instance.removals()).thenReturn(new HashSet<>());
    when(instance.error()).thenReturn(null);

    // Act
    ImmutableBulkMeasurableRatingValidationResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).removals();
    verify(instance).validatedItems();
    ImmutableBulkMeasurableRatingValidationResult buildResult = builderResult.build();
    assertNull(buildResult.error());
    assertEquals(0, buildResult.removalCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult.Builder#removals(Iterable)}
   */
  @Test
  void testBuilderRemovals() {
    // Arrange
    ImmutableBulkMeasurableRatingValidationResult.Builder builderResult = ImmutableBulkMeasurableRatingValidationResult
        .builder();

    // Act
    ImmutableBulkMeasurableRatingValidationResult.Builder actualRemovalsResult = builderResult
        .removals(new ArrayList<>());

    // Assert
    assertEquals(0, builderResult.build().removalCount());
    assertSame(builderResult, actualRemovalsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult.Builder#validatedItems(Iterable)}
   */
  @Test
  void testBuilderValidatedItems() {
    // Arrange
    ImmutableBulkMeasurableRatingValidationResult.Builder builderResult = ImmutableBulkMeasurableRatingValidationResult
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.validatedItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult.Builder#validatedItems(Iterable)}
   */
  @Test
  void testBuilderValidatedItems2() {
    // Arrange
    ImmutableBulkMeasurableRatingValidationResult.Builder builderResult = ImmutableBulkMeasurableRatingValidationResult
        .builder();
    builderResult.addRemovals(new Tuple2<>(mock(EntityReference.class), 1L));

    // Act and Assert
    assertSame(builderResult, builderResult.validatedItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult#copyOf(BulkMeasurableRatingValidationResult)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BulkMeasurableRatingValidationResult instance = mock(BulkMeasurableRatingValidationResult.class);
    when(instance.validatedItems()).thenReturn(new ArrayList<>());
    when(instance.removals()).thenReturn(new HashSet<>());
    ImmutableBulkMeasurableRatingParseError.Json json = new ImmutableBulkMeasurableRatingParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableBulkMeasurableRatingValidationResult actualCopyOfResult = ImmutableBulkMeasurableRatingValidationResult
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
   * {@link ImmutableBulkMeasurableRatingValidationResult#copyOf(BulkMeasurableRatingValidationResult)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<BulkMeasurableRatingValidatedItem> bulkMeasurableRatingValidatedItemList = new ArrayList<>();
    ImmutableBulkMeasurableRatingValidatedItem.Json json = new ImmutableBulkMeasurableRatingValidatedItem.Json();
    bulkMeasurableRatingValidatedItemList.add(json);
    BulkMeasurableRatingValidationResult instance = mock(BulkMeasurableRatingValidationResult.class);
    when(instance.validatedItems()).thenReturn(bulkMeasurableRatingValidatedItemList);
    when(instance.removals()).thenReturn(new HashSet<>());
    ImmutableBulkMeasurableRatingParseError.Json json2 = new ImmutableBulkMeasurableRatingParseError.Json();
    when(instance.error()).thenReturn(json2);

    // Act
    ImmutableBulkMeasurableRatingValidationResult actualCopyOfResult = ImmutableBulkMeasurableRatingValidationResult
        .copyOf(instance);

    // Assert
    verify(instance).error();
    verify(instance).removals();
    verify(instance).validatedItems();
    assertEquals(0, actualCopyOfResult.removalCount());
    Set<Tuple2<EntityReference, Long>> removalsResult = actualCopyOfResult.removals();
    assertTrue(removalsResult.isEmpty());
    assertEquals(bulkMeasurableRatingValidatedItemList, actualCopyOfResult.validatedItems());
    assertSame(json2, actualCopyOfResult.error());
    assertSame(json.errors, removalsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult#copyOf(BulkMeasurableRatingValidationResult)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<BulkMeasurableRatingValidatedItem> bulkMeasurableRatingValidatedItemList = new ArrayList<>();
    bulkMeasurableRatingValidatedItemList.add(new ImmutableBulkMeasurableRatingValidatedItem.Json());
    ImmutableBulkMeasurableRatingValidatedItem.Json json = new ImmutableBulkMeasurableRatingValidatedItem.Json();
    bulkMeasurableRatingValidatedItemList.add(json);
    BulkMeasurableRatingValidationResult instance = mock(BulkMeasurableRatingValidationResult.class);
    when(instance.validatedItems()).thenReturn(bulkMeasurableRatingValidatedItemList);
    when(instance.removals()).thenReturn(new HashSet<>());
    ImmutableBulkMeasurableRatingParseError.Json json2 = new ImmutableBulkMeasurableRatingParseError.Json();
    when(instance.error()).thenReturn(json2);

    // Act
    ImmutableBulkMeasurableRatingValidationResult actualCopyOfResult = ImmutableBulkMeasurableRatingValidationResult
        .copyOf(instance);

    // Assert
    verify(instance).error();
    verify(instance).removals();
    verify(instance).validatedItems();
    assertEquals(0, actualCopyOfResult.removalCount());
    Set<Tuple2<EntityReference, Long>> removalsResult = actualCopyOfResult.removals();
    assertTrue(removalsResult.isEmpty());
    assertEquals(bulkMeasurableRatingValidatedItemList, actualCopyOfResult.validatedItems());
    assertSame(json2, actualCopyOfResult.error());
    assertSame(json.errors, removalsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult#copyOf(BulkMeasurableRatingValidationResult)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<Tuple2<EntityReference, Long>> tuple2Set = new HashSet<>();
    tuple2Set.add(new Tuple2<>(null, 1L));
    BulkMeasurableRatingValidationResult instance = mock(BulkMeasurableRatingValidationResult.class);
    when(instance.validatedItems()).thenReturn(new ArrayList<>());
    when(instance.removals()).thenReturn(tuple2Set);
    ImmutableBulkMeasurableRatingParseError.Json json = new ImmutableBulkMeasurableRatingParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableBulkMeasurableRatingValidationResult actualCopyOfResult = ImmutableBulkMeasurableRatingValidationResult
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
   * {@link ImmutableBulkMeasurableRatingValidationResult#copyOf(BulkMeasurableRatingValidationResult)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    BulkMeasurableRatingValidationResult instance = mock(BulkMeasurableRatingValidationResult.class);
    when(instance.validatedItems()).thenReturn(new ArrayList<>());
    when(instance.removals()).thenReturn(new HashSet<>());
    when(instance.error()).thenReturn(null);

    // Act
    ImmutableBulkMeasurableRatingValidationResult actualCopyOfResult = ImmutableBulkMeasurableRatingValidationResult
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
   * {@link ImmutableBulkMeasurableRatingValidationResult#copyOf(BulkMeasurableRatingValidationResult)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    HashSet<Tuple2<EntityReference, Long>> tuple2Set = new HashSet<>();
    tuple2Set.add(mock(Tuple2.class));
    tuple2Set.add(new Tuple2<>(null, 1L));
    BulkMeasurableRatingValidationResult instance = mock(BulkMeasurableRatingValidationResult.class);
    when(instance.validatedItems()).thenReturn(new ArrayList<>());
    when(instance.removals()).thenReturn(tuple2Set);
    ImmutableBulkMeasurableRatingParseError.Json json = new ImmutableBulkMeasurableRatingParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableBulkMeasurableRatingValidationResult actualCopyOfResult = ImmutableBulkMeasurableRatingValidationResult
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
   * {@link ImmutableBulkMeasurableRatingValidationResult#fromJson(ImmutableBulkMeasurableRatingValidationResult.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableBulkMeasurableRatingValidationResult.Json json = new ImmutableBulkMeasurableRatingValidationResult.Json();

    // Act
    ImmutableBulkMeasurableRatingValidationResult actualFromJsonResult = ImmutableBulkMeasurableRatingValidationResult
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.error());
    assertEquals(0, actualFromJsonResult.removalCount());
    List<BulkMeasurableRatingValidatedItem> validatedItemsResult = actualFromJsonResult.validatedItems();
    assertTrue(validatedItemsResult.isEmpty());
    Set<Tuple2<EntityReference, Long>> removalsResult = actualFromJsonResult.removals();
    assertTrue(removalsResult.isEmpty());
    assertSame(json.removals, removalsResult);
    assertSame(json.validatedItems, validatedItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult#fromJson(ImmutableBulkMeasurableRatingValidationResult.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableBulkMeasurableRatingValidationResult.Json json = new ImmutableBulkMeasurableRatingValidationResult.Json();
    json.setValidatedItems(null);
    json.setError(null);
    json.setRemovals(null);

    // Act
    ImmutableBulkMeasurableRatingValidationResult actualFromJsonResult = ImmutableBulkMeasurableRatingValidationResult
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.error());
    assertEquals(0, actualFromJsonResult.removalCount());
    assertTrue(actualFromJsonResult.validatedItems().isEmpty());
    assertTrue(actualFromJsonResult.removals().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult#fromJson(ImmutableBulkMeasurableRatingValidationResult.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<Tuple2<EntityReference, Long>> removals = new LinkedHashSet<>();
    removals.add(new Tuple2<>(mock(EntityReference.class), 1L));

    ImmutableBulkMeasurableRatingValidationResult.Json json = new ImmutableBulkMeasurableRatingValidationResult.Json();
    json.setValidatedItems(null);
    json.setError(null);
    json.setRemovals(removals);

    // Act
    ImmutableBulkMeasurableRatingValidationResult actualFromJsonResult = ImmutableBulkMeasurableRatingValidationResult
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.error());
    assertEquals(1, actualFromJsonResult.removals().size());
    assertEquals(1, actualFromJsonResult.removalCount());
    assertTrue(actualFromJsonResult.validatedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult#fromJson(ImmutableBulkMeasurableRatingValidationResult.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    ImmutableBulkMeasurableRatingValidationResult.Json json = new ImmutableBulkMeasurableRatingValidationResult.Json();
    json.setValidatedItems(null);
    ImmutableBulkMeasurableRatingParseError.Json error = new ImmutableBulkMeasurableRatingParseError.Json();
    json.setError(error);
    json.setRemovals(null);

    // Act
    ImmutableBulkMeasurableRatingValidationResult actualFromJsonResult = ImmutableBulkMeasurableRatingValidationResult
        .fromJson(json);

    // Assert
    assertEquals(0, actualFromJsonResult.removalCount());
    assertTrue(actualFromJsonResult.validatedItems().isEmpty());
    assertTrue(actualFromJsonResult.removals().isEmpty());
    assertSame(error, actualFromJsonResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult#fromJson(ImmutableBulkMeasurableRatingValidationResult.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    ArrayList<BulkMeasurableRatingValidatedItem> validatedItems = new ArrayList<>();
    ImmutableBulkMeasurableRatingValidatedItem.Json json = new ImmutableBulkMeasurableRatingValidatedItem.Json();
    validatedItems.add(json);

    ImmutableBulkMeasurableRatingValidationResult.Json json2 = new ImmutableBulkMeasurableRatingValidationResult.Json();
    json2.setValidatedItems(validatedItems);
    json2.setError(null);
    json2.setRemovals(null);

    // Act
    ImmutableBulkMeasurableRatingValidationResult actualFromJsonResult = ImmutableBulkMeasurableRatingValidationResult
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
   * {@link ImmutableBulkMeasurableRatingValidationResult#fromJson(ImmutableBulkMeasurableRatingValidationResult.Json)}
   */
  @Test
  void testFromJson6() {
    // Arrange
    LinkedHashSet<Tuple2<EntityReference, Long>> removals = new LinkedHashSet<>();
    removals.add(new Tuple2<>(mock(EntityReference.class), 1L));
    removals.add(new Tuple2<>(mock(EntityReference.class), 1L));

    ImmutableBulkMeasurableRatingValidationResult.Json json = new ImmutableBulkMeasurableRatingValidationResult.Json();
    json.setValidatedItems(null);
    json.setError(null);
    json.setRemovals(removals);

    // Act
    ImmutableBulkMeasurableRatingValidationResult actualFromJsonResult = ImmutableBulkMeasurableRatingValidationResult
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.error());
    assertEquals(2, actualFromJsonResult.removalCount());
    assertTrue(actualFromJsonResult.validatedItems().isEmpty());
    assertEquals(removals, actualFromJsonResult.removals());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult#fromJson(ImmutableBulkMeasurableRatingValidationResult.Json)}
   */
  @Test
  void testFromJson7() {
    // Arrange
    ArrayList<BulkMeasurableRatingValidatedItem> validatedItems = new ArrayList<>();
    validatedItems.add(new ImmutableBulkMeasurableRatingValidatedItem.Json());
    ImmutableBulkMeasurableRatingValidatedItem.Json json = new ImmutableBulkMeasurableRatingValidatedItem.Json();
    validatedItems.add(json);

    ImmutableBulkMeasurableRatingValidationResult.Json json2 = new ImmutableBulkMeasurableRatingValidationResult.Json();
    json2.setValidatedItems(validatedItems);
    json2.setError(null);
    json2.setRemovals(null);

    // Act
    ImmutableBulkMeasurableRatingValidationResult actualFromJsonResult = ImmutableBulkMeasurableRatingValidationResult
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
   * {@link ImmutableBulkMeasurableRatingValidationResult.Json#error()}
   */
  @Test
  void testJsonError() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingValidationResult.Json()).error());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableBulkMeasurableRatingValidationResult.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingValidationResult.Json actualJson = new ImmutableBulkMeasurableRatingValidationResult.Json();

    // Assert
    assertNull(actualJson.error);
    assertTrue(actualJson.validatedItems.isEmpty());
    assertTrue(actualJson.removals.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult.Json#removalCount()}
   */
  @Test
  void testJsonRemovalCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingValidationResult.Json()).removalCount());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult.Json#removals()}
   */
  @Test
  void testJsonRemovals() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingValidationResult.Json()).removals());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingValidationResult.Json#validatedItems()}
   */
  @Test
  void testJsonValidatedItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingValidationResult.Json()).validatedItems());
  }
}
