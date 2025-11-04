package org.finos.waltz.model.bulk_upload.taxonomy;

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
import org.finos.waltz.model.measurable.Measurable;
import org.junit.jupiter.api.Test;

class ImmutableBulkTaxonomyValidationResultDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult.Builder#addAllPlannedRemovals(Iterable)}
   */
  @Test
  void testBuilderAddAllPlannedRemovals() {
    // Arrange
    ImmutableBulkTaxonomyValidationResult.Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllPlannedRemovals(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult.Builder#addAllValidatedItems(Iterable)}
   */
  @Test
  void testBuilderAddAllValidatedItems() {
    // Arrange
    ImmutableBulkTaxonomyValidationResult.Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllValidatedItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult.Builder#addAllValidatedItems(Iterable)}
   */
  @Test
  void testBuilderAddAllValidatedItems2() {
    // Arrange
    ImmutableBulkTaxonomyValidationResult.Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    builderResult.addPlannedRemovals(mock(Measurable.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllValidatedItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult.Builder#addPlannedRemovals(Measurable)}
   */
  @Test
  void testBuilderAddPlannedRemovals() {
    // Arrange
    ImmutableBulkTaxonomyValidationResult.Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    // Act
    ImmutableBulkTaxonomyValidationResult.Builder actualAddPlannedRemovalsResult = builderResult
        .addPlannedRemovals(mock(Measurable.class));

    // Assert
    assertEquals(1, builderResult.build().plannedRemovals().size());
    assertSame(builderResult, actualAddPlannedRemovalsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult.Builder#addPlannedRemovals(Measurable[])}
   */
  @Test
  void testBuilderAddPlannedRemovals2() {
    // Arrange
    ImmutableBulkTaxonomyValidationResult.Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    // Act
    ImmutableBulkTaxonomyValidationResult.Builder actualAddPlannedRemovalsResult = builderResult
        .addPlannedRemovals(mock(Measurable.class));

    // Assert
    assertEquals(1, builderResult.build().plannedRemovals().size());
    assertSame(builderResult, actualAddPlannedRemovalsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult.Builder#addValidatedItems(BulkTaxonomyValidatedItem)}
   */
  @Test
  void testBuilderAddValidatedItems() {
    // Arrange
    ImmutableBulkTaxonomyValidationResult.Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidatedItem.Json element = new ImmutableBulkTaxonomyValidatedItem.Json();

    // Act
    ImmutableBulkTaxonomyValidationResult.Builder actualAddValidatedItemsResult = builderResult
        .addValidatedItems(element);

    // Assert
    List<BulkTaxonomyValidatedItem> validatedItemsResult = builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(element, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult.Builder#addValidatedItems(BulkTaxonomyValidatedItem)}
   */
  @Test
  void testBuilderAddValidatedItems2() {
    // Arrange
    ImmutableBulkTaxonomyValidationResult.Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    builderResult.addPlannedRemovals(mock(Measurable.class));
    ImmutableBulkTaxonomyValidatedItem.Json element = new ImmutableBulkTaxonomyValidatedItem.Json();

    // Act
    ImmutableBulkTaxonomyValidationResult.Builder actualAddValidatedItemsResult = builderResult
        .addValidatedItems(element);

    // Assert
    List<BulkTaxonomyValidatedItem> validatedItemsResult = builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(element, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult.Builder#addValidatedItems(BulkTaxonomyValidatedItem[])}
   */
  @Test
  void testBuilderAddValidatedItems3() {
    // Arrange
    ImmutableBulkTaxonomyValidationResult.Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidatedItem.Json json = new ImmutableBulkTaxonomyValidatedItem.Json();

    // Act
    ImmutableBulkTaxonomyValidationResult.Builder actualAddValidatedItemsResult = builderResult.addValidatedItems(json);

    // Assert
    List<BulkTaxonomyValidatedItem> validatedItemsResult = builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(json, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult.Builder#addValidatedItems(BulkTaxonomyValidatedItem[])}
   */
  @Test
  void testBuilderAddValidatedItems4() {
    // Arrange
    ImmutableBulkTaxonomyValidationResult.Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    builderResult.addPlannedRemovals(mock(Measurable.class));
    ImmutableBulkTaxonomyValidatedItem.Json json = new ImmutableBulkTaxonomyValidatedItem.Json();

    // Act
    ImmutableBulkTaxonomyValidationResult.Builder actualAddValidatedItemsResult = builderResult.addValidatedItems(json);

    // Assert
    List<BulkTaxonomyValidatedItem> validatedItemsResult = builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(json, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyValidationResult.Builder#build()}
   *   <li>
   * {@link ImmutableBulkTaxonomyValidationResult.Builder#error(BulkTaxonomyParseResult.BulkTaxonomyParseError)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange
    ImmutableBulkTaxonomyValidationResult.Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyParseError.Json error = new ImmutableBulkTaxonomyParseError.Json();

    // Act
    ImmutableBulkTaxonomyValidationResult actualBuildResult = builderResult.error(error).build();

    // Assert
    assertTrue(actualBuildResult.validatedItems().isEmpty());
    assertTrue(actualBuildResult.plannedRemovals().isEmpty());
    assertSame(error, actualBuildResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult.Builder#from(BulkTaxonomyValidationResult)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBulkTaxonomyValidationResult.Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    BulkTaxonomyValidationResult instance = mock(BulkTaxonomyValidationResult.class);
    when(instance.validatedItems()).thenReturn(new ArrayList<>());
    when(instance.plannedRemovals()).thenReturn(new HashSet<>());
    ImmutableBulkTaxonomyParseError.Json json = new ImmutableBulkTaxonomyParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableBulkTaxonomyValidationResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).plannedRemovals();
    verify(instance).validatedItems();
    assertSame(json, builderResult.build().error());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult.Builder#from(BulkTaxonomyValidationResult)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBulkTaxonomyValidationResult.Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    ArrayList<BulkTaxonomyValidatedItem> bulkTaxonomyValidatedItemList = new ArrayList<>();
    ImmutableBulkTaxonomyValidatedItem.Json json = new ImmutableBulkTaxonomyValidatedItem.Json();
    bulkTaxonomyValidatedItemList.add(json);
    BulkTaxonomyValidationResult instance = mock(BulkTaxonomyValidationResult.class);
    when(instance.validatedItems()).thenReturn(bulkTaxonomyValidatedItemList);
    when(instance.plannedRemovals()).thenReturn(new HashSet<>());
    ImmutableBulkTaxonomyParseError.Json json2 = new ImmutableBulkTaxonomyParseError.Json();
    when(instance.error()).thenReturn(json2);

    // Act
    ImmutableBulkTaxonomyValidationResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).plannedRemovals();
    verify(instance).validatedItems();
    ImmutableBulkTaxonomyValidationResult buildResult = builderResult.build();
    List<BulkTaxonomyValidatedItem> validatedItemsResult = buildResult.validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(json2, buildResult.error());
    assertSame(json, validatedItemsResult.get(0));
    assertSame(builderResult, actualFromResult);
    Set<ValidationError> expectedPlannedRemovalsResult = json.errors;
    assertSame(expectedPlannedRemovalsResult, buildResult.plannedRemovals());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult.Builder#from(BulkTaxonomyValidationResult)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableBulkTaxonomyValidationResult.Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    HashSet<Measurable> measurableSet = new HashSet<>();
    measurableSet.add(mock(Measurable.class));
    BulkTaxonomyValidationResult instance = mock(BulkTaxonomyValidationResult.class);
    when(instance.validatedItems()).thenReturn(new ArrayList<>());
    when(instance.plannedRemovals()).thenReturn(measurableSet);
    ImmutableBulkTaxonomyParseError.Json json = new ImmutableBulkTaxonomyParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableBulkTaxonomyValidationResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).plannedRemovals();
    verify(instance).validatedItems();
    ImmutableBulkTaxonomyValidationResult buildResult = builderResult.build();
    assertEquals(1, buildResult.plannedRemovals().size());
    assertSame(json, buildResult.error());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult.Builder#from(BulkTaxonomyValidationResult)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableBulkTaxonomyValidationResult.Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    BulkTaxonomyValidationResult instance = mock(BulkTaxonomyValidationResult.class);
    when(instance.validatedItems()).thenReturn(new ArrayList<>());
    when(instance.plannedRemovals()).thenReturn(new HashSet<>());
    when(instance.error()).thenReturn(null);

    // Act
    ImmutableBulkTaxonomyValidationResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).plannedRemovals();
    verify(instance).validatedItems();
    assertNull(builderResult.build().error());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult.Builder#plannedRemovals(Iterable)}
   */
  @Test
  void testBuilderPlannedRemovals() {
    // Arrange
    ImmutableBulkTaxonomyValidationResult.Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.plannedRemovals(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult.Builder#validatedItems(Iterable)}
   */
  @Test
  void testBuilderValidatedItems() {
    // Arrange
    ImmutableBulkTaxonomyValidationResult.Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.validatedItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult.Builder#validatedItems(Iterable)}
   */
  @Test
  void testBuilderValidatedItems2() {
    // Arrange
    ImmutableBulkTaxonomyValidationResult.Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    builderResult.addPlannedRemovals(mock(Measurable.class));

    // Act and Assert
    assertSame(builderResult, builderResult.validatedItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult#copyOf(BulkTaxonomyValidationResult)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BulkTaxonomyValidationResult instance = mock(BulkTaxonomyValidationResult.class);
    when(instance.validatedItems()).thenReturn(new ArrayList<>());
    when(instance.plannedRemovals()).thenReturn(new HashSet<>());
    ImmutableBulkTaxonomyParseError.Json json = new ImmutableBulkTaxonomyParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableBulkTaxonomyValidationResult actualCopyOfResult = ImmutableBulkTaxonomyValidationResult.copyOf(instance);

    // Assert
    verify(instance).error();
    verify(instance).plannedRemovals();
    verify(instance).validatedItems();
    assertTrue(actualCopyOfResult.validatedItems().isEmpty());
    assertTrue(actualCopyOfResult.plannedRemovals().isEmpty());
    assertSame(json, actualCopyOfResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult#copyOf(BulkTaxonomyValidationResult)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<BulkTaxonomyValidatedItem> bulkTaxonomyValidatedItemList = new ArrayList<>();
    ImmutableBulkTaxonomyValidatedItem.Json json = new ImmutableBulkTaxonomyValidatedItem.Json();
    bulkTaxonomyValidatedItemList.add(json);
    BulkTaxonomyValidationResult instance = mock(BulkTaxonomyValidationResult.class);
    when(instance.validatedItems()).thenReturn(bulkTaxonomyValidatedItemList);
    when(instance.plannedRemovals()).thenReturn(new HashSet<>());
    ImmutableBulkTaxonomyParseError.Json json2 = new ImmutableBulkTaxonomyParseError.Json();
    when(instance.error()).thenReturn(json2);

    // Act
    ImmutableBulkTaxonomyValidationResult actualCopyOfResult = ImmutableBulkTaxonomyValidationResult.copyOf(instance);

    // Assert
    verify(instance).error();
    verify(instance).plannedRemovals();
    verify(instance).validatedItems();
    Set<Measurable> plannedRemovalsResult = actualCopyOfResult.plannedRemovals();
    assertTrue(plannedRemovalsResult.isEmpty());
    assertEquals(bulkTaxonomyValidatedItemList, actualCopyOfResult.validatedItems());
    assertSame(json2, actualCopyOfResult.error());
    assertSame(json.errors, plannedRemovalsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult#copyOf(BulkTaxonomyValidationResult)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<BulkTaxonomyValidatedItem> bulkTaxonomyValidatedItemList = new ArrayList<>();
    bulkTaxonomyValidatedItemList.add(new ImmutableBulkTaxonomyValidatedItem.Json());
    ImmutableBulkTaxonomyValidatedItem.Json json = new ImmutableBulkTaxonomyValidatedItem.Json();
    bulkTaxonomyValidatedItemList.add(json);
    BulkTaxonomyValidationResult instance = mock(BulkTaxonomyValidationResult.class);
    when(instance.validatedItems()).thenReturn(bulkTaxonomyValidatedItemList);
    when(instance.plannedRemovals()).thenReturn(new HashSet<>());
    ImmutableBulkTaxonomyParseError.Json json2 = new ImmutableBulkTaxonomyParseError.Json();
    when(instance.error()).thenReturn(json2);

    // Act
    ImmutableBulkTaxonomyValidationResult actualCopyOfResult = ImmutableBulkTaxonomyValidationResult.copyOf(instance);

    // Assert
    verify(instance).error();
    verify(instance).plannedRemovals();
    verify(instance).validatedItems();
    Set<Measurable> plannedRemovalsResult = actualCopyOfResult.plannedRemovals();
    assertTrue(plannedRemovalsResult.isEmpty());
    assertEquals(bulkTaxonomyValidatedItemList, actualCopyOfResult.validatedItems());
    assertSame(json2, actualCopyOfResult.error());
    assertSame(json.errors, plannedRemovalsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult#copyOf(BulkTaxonomyValidationResult)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<Measurable> measurableSet = new HashSet<>();
    measurableSet.add(mock(Measurable.class));
    BulkTaxonomyValidationResult instance = mock(BulkTaxonomyValidationResult.class);
    when(instance.validatedItems()).thenReturn(new ArrayList<>());
    when(instance.plannedRemovals()).thenReturn(measurableSet);
    ImmutableBulkTaxonomyParseError.Json json = new ImmutableBulkTaxonomyParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableBulkTaxonomyValidationResult actualCopyOfResult = ImmutableBulkTaxonomyValidationResult.copyOf(instance);

    // Assert
    verify(instance).error();
    verify(instance).plannedRemovals();
    verify(instance).validatedItems();
    assertEquals(1, actualCopyOfResult.plannedRemovals().size());
    assertTrue(actualCopyOfResult.validatedItems().isEmpty());
    assertSame(json, actualCopyOfResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult#copyOf(BulkTaxonomyValidationResult)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    HashSet<Measurable> measurableSet = new HashSet<>();
    measurableSet.add(mock(Measurable.class));
    measurableSet.add(mock(Measurable.class));
    BulkTaxonomyValidationResult instance = mock(BulkTaxonomyValidationResult.class);
    when(instance.validatedItems()).thenReturn(new ArrayList<>());
    when(instance.plannedRemovals()).thenReturn(measurableSet);
    ImmutableBulkTaxonomyParseError.Json json = new ImmutableBulkTaxonomyParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableBulkTaxonomyValidationResult actualCopyOfResult = ImmutableBulkTaxonomyValidationResult.copyOf(instance);

    // Assert
    verify(instance).error();
    verify(instance).plannedRemovals();
    verify(instance).validatedItems();
    assertTrue(actualCopyOfResult.validatedItems().isEmpty());
    assertEquals(measurableSet, actualCopyOfResult.plannedRemovals());
    assertSame(json, actualCopyOfResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult#copyOf(BulkTaxonomyValidationResult)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    BulkTaxonomyValidationResult instance = mock(BulkTaxonomyValidationResult.class);
    when(instance.validatedItems()).thenReturn(new ArrayList<>());
    when(instance.plannedRemovals()).thenReturn(new HashSet<>());
    when(instance.error()).thenReturn(null);

    // Act
    ImmutableBulkTaxonomyValidationResult actualCopyOfResult = ImmutableBulkTaxonomyValidationResult.copyOf(instance);

    // Assert
    verify(instance).error();
    verify(instance).plannedRemovals();
    verify(instance).validatedItems();
    assertNull(actualCopyOfResult.error());
    assertTrue(actualCopyOfResult.validatedItems().isEmpty());
    assertTrue(actualCopyOfResult.plannedRemovals().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult#fromJson(ImmutableBulkTaxonomyValidationResult.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableBulkTaxonomyValidationResult.Json json = new ImmutableBulkTaxonomyValidationResult.Json();

    // Act
    ImmutableBulkTaxonomyValidationResult actualFromJsonResult = ImmutableBulkTaxonomyValidationResult.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.error());
    List<BulkTaxonomyValidatedItem> validatedItemsResult = actualFromJsonResult.validatedItems();
    assertTrue(validatedItemsResult.isEmpty());
    Set<Measurable> plannedRemovalsResult = actualFromJsonResult.plannedRemovals();
    assertTrue(plannedRemovalsResult.isEmpty());
    assertSame(json.plannedRemovals, plannedRemovalsResult);
    assertSame(json.validatedItems, validatedItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult#fromJson(ImmutableBulkTaxonomyValidationResult.Json)}
   */
  @Test
  void testFromJson2() {
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
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult#fromJson(ImmutableBulkTaxonomyValidationResult.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ImmutableBulkTaxonomyValidationResult.Json json = new ImmutableBulkTaxonomyValidationResult.Json();
    json.setValidatedItems(null);
    json.setPlannedRemovals(null);
    ImmutableBulkTaxonomyParseError.Json error = new ImmutableBulkTaxonomyParseError.Json();
    json.setError(error);

    // Act
    ImmutableBulkTaxonomyValidationResult actualFromJsonResult = ImmutableBulkTaxonomyValidationResult.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.validatedItems().isEmpty());
    assertTrue(actualFromJsonResult.plannedRemovals().isEmpty());
    assertSame(error, actualFromJsonResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult#fromJson(ImmutableBulkTaxonomyValidationResult.Json)}
   */
  @Test
  void testFromJson4() {
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
    assertNull(actualFromJsonResult.error());
    assertEquals(1, actualFromJsonResult.plannedRemovals().size());
    assertTrue(actualFromJsonResult.validatedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult#fromJson(ImmutableBulkTaxonomyValidationResult.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    ArrayList<BulkTaxonomyValidatedItem> validatedItems = new ArrayList<>();
    ImmutableBulkTaxonomyValidatedItem.Json json = new ImmutableBulkTaxonomyValidatedItem.Json();
    validatedItems.add(json);

    ImmutableBulkTaxonomyValidationResult.Json json2 = new ImmutableBulkTaxonomyValidationResult.Json();
    json2.setValidatedItems(validatedItems);
    json2.setPlannedRemovals(null);
    json2.setError(null);

    // Act
    ImmutableBulkTaxonomyValidationResult actualFromJsonResult = ImmutableBulkTaxonomyValidationResult.fromJson(json2);

    // Assert
    assertNull(actualFromJsonResult.error());
    Set<Measurable> plannedRemovalsResult = actualFromJsonResult.plannedRemovals();
    assertTrue(plannedRemovalsResult.isEmpty());
    assertEquals(validatedItems, actualFromJsonResult.validatedItems());
    assertSame(json.errors, plannedRemovalsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult#fromJson(ImmutableBulkTaxonomyValidationResult.Json)}
   */
  @Test
  void testFromJson6() {
    // Arrange
    ArrayList<BulkTaxonomyValidatedItem> validatedItems = new ArrayList<>();
    validatedItems.add(new ImmutableBulkTaxonomyValidatedItem.Json());
    ImmutableBulkTaxonomyValidatedItem.Json json = new ImmutableBulkTaxonomyValidatedItem.Json();
    validatedItems.add(json);

    ImmutableBulkTaxonomyValidationResult.Json json2 = new ImmutableBulkTaxonomyValidationResult.Json();
    json2.setValidatedItems(validatedItems);
    json2.setPlannedRemovals(null);
    json2.setError(null);

    // Act
    ImmutableBulkTaxonomyValidationResult actualFromJsonResult = ImmutableBulkTaxonomyValidationResult.fromJson(json2);

    // Assert
    assertNull(actualFromJsonResult.error());
    Set<Measurable> plannedRemovalsResult = actualFromJsonResult.plannedRemovals();
    assertTrue(plannedRemovalsResult.isEmpty());
    assertEquals(validatedItems, actualFromJsonResult.validatedItems());
    assertSame(json.errors, plannedRemovalsResult);
  }

  /**
   * Method under test: {@link ImmutableBulkTaxonomyValidationResult.Json#error()}
   */
  @Test
  void testJsonError() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkTaxonomyValidationResult.Json()).error());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableBulkTaxonomyValidationResult.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableBulkTaxonomyValidationResult.Json actualJson = new ImmutableBulkTaxonomyValidationResult.Json();

    // Assert
    assertNull(actualJson.error);
    assertTrue(actualJson.validatedItems.isEmpty());
    assertTrue(actualJson.plannedRemovals.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult.Json#plannedRemovals()}
   */
  @Test
  void testJsonPlannedRemovals() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkTaxonomyValidationResult.Json()).plannedRemovals());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyValidationResult.Json#validatedItems()}
   */
  @Test
  void testJsonValidatedItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkTaxonomyValidationResult.Json()).validatedItems());
  }
}
