package org.finos.waltz.model.bulk_upload.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ch.qos.logback.core.util.COWArrayList;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ImmutableBulkMeasurableRatingParseResultDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseResult.Builder#addAllParsedItems(Iterable)}
   */
  @Test
  void testBuilderAddAllParsedItems() {
    // Arrange
    ImmutableBulkMeasurableRatingParseResult.Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllParsedItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseResult.Builder#addParsedItems(BulkMeasurableRatingItem)}
   */
  @Test
  void testBuilderAddParsedItems() {
    // Arrange
    ImmutableBulkMeasurableRatingParseResult.Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingItem.Json element = new ImmutableBulkMeasurableRatingItem.Json();

    // Act
    ImmutableBulkMeasurableRatingParseResult.Builder actualAddParsedItemsResult = builderResult.addParsedItems(element);

    // Assert
    List<BulkMeasurableRatingItem> parsedItemsResult = builderResult.build().parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(element, parsedItemsResult.get(0));
    assertSame(builderResult, actualAddParsedItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseResult.Builder#addParsedItems(BulkMeasurableRatingItem[])}
   */
  @Test
  void testBuilderAddParsedItems2() {
    // Arrange
    ImmutableBulkMeasurableRatingParseResult.Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingItem.Json json = new ImmutableBulkMeasurableRatingItem.Json();

    // Act
    ImmutableBulkMeasurableRatingParseResult.Builder actualAddParsedItemsResult = builderResult.addParsedItems(json);

    // Assert
    List<BulkMeasurableRatingItem> parsedItemsResult = builderResult.build().parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(json, parsedItemsResult.get(0));
    assertSame(builderResult, actualAddParsedItemsResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkMeasurableRatingParseResult.Builder#build()}
   *   <li>
   * {@link ImmutableBulkMeasurableRatingParseResult.Builder#error(BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError)}
   *   <li>{@link ImmutableBulkMeasurableRatingParseResult.Builder#input(String)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange
    ImmutableBulkMeasurableRatingParseResult.Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseError.Json error = new ImmutableBulkMeasurableRatingParseError.Json();

    // Act
    ImmutableBulkMeasurableRatingParseResult actualBuildResult = builderResult.error(error).input("Input").build();

    // Assert
    assertEquals("Input", actualBuildResult.input());
    assertTrue(actualBuildResult.parsedItems().isEmpty());
    assertSame(error, actualBuildResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseResult.Builder#from(BulkMeasurableRatingParseResult)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBulkMeasurableRatingParseResult.Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    BulkMeasurableRatingParseResult instance = mock(BulkMeasurableRatingParseResult.class);
    when(instance.input()).thenReturn("Input");
    when(instance.parsedItems()).thenReturn(new ArrayList<>());
    ImmutableBulkMeasurableRatingParseError.Json json = new ImmutableBulkMeasurableRatingParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableBulkMeasurableRatingParseResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    ImmutableBulkMeasurableRatingParseResult buildResult = builderResult.build();
    assertEquals("Input", buildResult.input());
    assertSame(json, buildResult.error());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseResult.Builder#from(BulkMeasurableRatingParseResult)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBulkMeasurableRatingParseResult.Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    BulkMeasurableRatingParseResult instance = mock(BulkMeasurableRatingParseResult.class);
    when(instance.input()).thenReturn(null);
    when(instance.parsedItems()).thenReturn(new ArrayList<>());
    ImmutableBulkMeasurableRatingParseError.Json json = new ImmutableBulkMeasurableRatingParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableBulkMeasurableRatingParseResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    ImmutableBulkMeasurableRatingParseResult buildResult = builderResult.build();
    assertNull(buildResult.input());
    assertSame(json, buildResult.error());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseResult.Builder#from(BulkMeasurableRatingParseResult)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableBulkMeasurableRatingParseResult.Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();

    ArrayList<BulkMeasurableRatingItem> bulkMeasurableRatingItemList = new ArrayList<>();
    ImmutableBulkMeasurableRatingItem.Json json = new ImmutableBulkMeasurableRatingItem.Json();
    bulkMeasurableRatingItemList.add(json);
    BulkMeasurableRatingParseResult instance = mock(BulkMeasurableRatingParseResult.class);
    when(instance.input()).thenReturn("Input");
    when(instance.parsedItems()).thenReturn(bulkMeasurableRatingItemList);
    ImmutableBulkMeasurableRatingParseError.Json json2 = new ImmutableBulkMeasurableRatingParseError.Json();
    when(instance.error()).thenReturn(json2);

    // Act
    ImmutableBulkMeasurableRatingParseResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    ImmutableBulkMeasurableRatingParseResult buildResult = builderResult.build();
    assertEquals("Input", buildResult.input());
    List<BulkMeasurableRatingItem> parsedItemsResult = buildResult.parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(json, parsedItemsResult.get(0));
    assertSame(json2, buildResult.error());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseResult.Builder#from(BulkMeasurableRatingParseResult)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableBulkMeasurableRatingParseResult.Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    BulkMeasurableRatingParseResult instance = mock(BulkMeasurableRatingParseResult.class);
    when(instance.input()).thenReturn("Input");
    when(instance.parsedItems()).thenReturn(new ArrayList<>());
    when(instance.error()).thenReturn(null);

    // Act
    ImmutableBulkMeasurableRatingParseResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    ImmutableBulkMeasurableRatingParseResult buildResult = builderResult.build();
    assertEquals("Input", buildResult.input());
    assertNull(buildResult.error());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseResult.Builder#parsedItems(Iterable)}
   */
  @Test
  void testBuilderParsedItems() {
    // Arrange
    ImmutableBulkMeasurableRatingParseResult.Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parsedItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseResult#copyOf(BulkMeasurableRatingParseResult)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BulkMeasurableRatingParseResult instance = mock(BulkMeasurableRatingParseResult.class);
    when(instance.input()).thenReturn("Input");
    when(instance.parsedItems()).thenReturn(new ArrayList<>());
    ImmutableBulkMeasurableRatingParseError.Json json = new ImmutableBulkMeasurableRatingParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableBulkMeasurableRatingParseResult actualCopyOfResult = ImmutableBulkMeasurableRatingParseResult
        .copyOf(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    assertEquals("Input", actualCopyOfResult.input());
    assertTrue(actualCopyOfResult.parsedItems().isEmpty());
    assertSame(json, actualCopyOfResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseResult#copyOf(BulkMeasurableRatingParseResult)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<BulkMeasurableRatingItem> bulkMeasurableRatingItemList = new ArrayList<>();
    bulkMeasurableRatingItemList.add(new ImmutableBulkMeasurableRatingItem.Json());
    BulkMeasurableRatingParseResult instance = mock(BulkMeasurableRatingParseResult.class);
    when(instance.input()).thenReturn("Input");
    when(instance.parsedItems()).thenReturn(bulkMeasurableRatingItemList);
    ImmutableBulkMeasurableRatingParseError.Json json = new ImmutableBulkMeasurableRatingParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableBulkMeasurableRatingParseResult actualCopyOfResult = ImmutableBulkMeasurableRatingParseResult
        .copyOf(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    assertEquals("Input", actualCopyOfResult.input());
    assertEquals(bulkMeasurableRatingItemList, actualCopyOfResult.parsedItems());
    assertSame(json, actualCopyOfResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseResult#copyOf(BulkMeasurableRatingParseResult)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<BulkMeasurableRatingItem> bulkMeasurableRatingItemList = new ArrayList<>();
    bulkMeasurableRatingItemList.add(new ImmutableBulkMeasurableRatingItem.Json());
    bulkMeasurableRatingItemList.add(new ImmutableBulkMeasurableRatingItem.Json());
    BulkMeasurableRatingParseResult instance = mock(BulkMeasurableRatingParseResult.class);
    when(instance.input()).thenReturn("Input");
    when(instance.parsedItems()).thenReturn(bulkMeasurableRatingItemList);
    ImmutableBulkMeasurableRatingParseError.Json json = new ImmutableBulkMeasurableRatingParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableBulkMeasurableRatingParseResult actualCopyOfResult = ImmutableBulkMeasurableRatingParseResult
        .copyOf(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    assertEquals("Input", actualCopyOfResult.input());
    assertEquals(bulkMeasurableRatingItemList, actualCopyOfResult.parsedItems());
    assertSame(json, actualCopyOfResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseResult#copyOf(BulkMeasurableRatingParseResult)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    BulkMeasurableRatingParseResult instance = mock(BulkMeasurableRatingParseResult.class);
    when(instance.input()).thenReturn("Input");
    when(instance.parsedItems()).thenReturn(new ArrayList<>());
    when(instance.error()).thenReturn(null);

    // Act
    ImmutableBulkMeasurableRatingParseResult actualCopyOfResult = ImmutableBulkMeasurableRatingParseResult
        .copyOf(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    assertEquals("Input", actualCopyOfResult.input());
    assertNull(actualCopyOfResult.error());
    assertTrue(actualCopyOfResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseResult#fromJson(ImmutableBulkMeasurableRatingParseResult.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableBulkMeasurableRatingParseResult.Json json = new ImmutableBulkMeasurableRatingParseResult.Json();

    // Act
    ImmutableBulkMeasurableRatingParseResult actualFromJsonResult = ImmutableBulkMeasurableRatingParseResult
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    List<BulkMeasurableRatingItem> parsedItemsResult = actualFromJsonResult.parsedItems();
    assertTrue(parsedItemsResult.isEmpty());
    assertSame(json.parsedItems, parsedItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseResult#fromJson(ImmutableBulkMeasurableRatingParseResult.Json)}
   */
  @Test
  void testFromJson2() {
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
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseResult#fromJson(ImmutableBulkMeasurableRatingParseResult.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ImmutableBulkMeasurableRatingParseResult.Json json = new ImmutableBulkMeasurableRatingParseResult.Json();
    json.setParsedItems(null);
    json.setInput(null);
    ImmutableBulkMeasurableRatingParseError.Json error = new ImmutableBulkMeasurableRatingParseError.Json();
    json.setError(error);

    // Act
    ImmutableBulkMeasurableRatingParseResult actualFromJsonResult = ImmutableBulkMeasurableRatingParseResult
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.input());
    assertTrue(actualFromJsonResult.parsedItems().isEmpty());
    assertSame(error, actualFromJsonResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseResult#fromJson(ImmutableBulkMeasurableRatingParseResult.Json)}
   */
  @Test
  void testFromJson4() {
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
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseResult#fromJson(ImmutableBulkMeasurableRatingParseResult.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    ArrayList<BulkMeasurableRatingItem> parsedItems = new ArrayList<>();
    parsedItems.add(new ImmutableBulkMeasurableRatingItem.Json());

    ImmutableBulkMeasurableRatingParseResult.Json json = new ImmutableBulkMeasurableRatingParseResult.Json();
    json.setParsedItems(parsedItems);
    json.setInput(null);
    json.setError(null);

    // Act
    ImmutableBulkMeasurableRatingParseResult actualFromJsonResult = ImmutableBulkMeasurableRatingParseResult
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertEquals(parsedItems, actualFromJsonResult.parsedItems());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseResult#fromJson(ImmutableBulkMeasurableRatingParseResult.Json)}
   */
  @Test
  void testFromJson6() {
    // Arrange
    COWArrayList<BulkMeasurableRatingItem> parsedItems = mock(COWArrayList.class);

    ArrayList<BulkMeasurableRatingItem> bulkMeasurableRatingItemList = new ArrayList<>();
    when(parsedItems.iterator()).thenReturn(bulkMeasurableRatingItemList.iterator());

    ImmutableBulkMeasurableRatingParseResult.Json json = new ImmutableBulkMeasurableRatingParseResult.Json();
    json.setParsedItems(parsedItems);
    json.setInput(null);
    json.setError(null);

    // Act
    ImmutableBulkMeasurableRatingParseResult actualFromJsonResult = ImmutableBulkMeasurableRatingParseResult
        .fromJson(json);

    // Assert
    verify(parsedItems).iterator();
    assertNull(actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertTrue(actualFromJsonResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseResult#fromJson(ImmutableBulkMeasurableRatingParseResult.Json)}
   */
  @Test
  void testFromJson7() {
    // Arrange
    ArrayList<BulkMeasurableRatingItem> bulkMeasurableRatingItemList = new ArrayList<>();
    bulkMeasurableRatingItemList.add(new ImmutableBulkMeasurableRatingItem.Json());
    bulkMeasurableRatingItemList.add(new ImmutableBulkMeasurableRatingItem.Json());
    COWArrayList<BulkMeasurableRatingItem> parsedItems = mock(COWArrayList.class);
    when(parsedItems.iterator()).thenReturn(bulkMeasurableRatingItemList.iterator());

    ImmutableBulkMeasurableRatingParseResult.Json json = new ImmutableBulkMeasurableRatingParseResult.Json();
    json.setParsedItems(parsedItems);
    json.setInput(null);
    json.setError(null);

    // Act
    ImmutableBulkMeasurableRatingParseResult actualFromJsonResult = ImmutableBulkMeasurableRatingParseResult
        .fromJson(json);

    // Assert
    verify(parsedItems).iterator();
    assertNull(actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertEquals(bulkMeasurableRatingItemList, actualFromJsonResult.parsedItems());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseResult.Json#error()}
   */
  @Test
  void testJsonError() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingParseResult.Json()).error());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseResult.Json#input()}
   */
  @Test
  void testJsonInput() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingParseResult.Json()).input());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableBulkMeasurableRatingParseResult.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingParseResult.Json actualJson = new ImmutableBulkMeasurableRatingParseResult.Json();

    // Assert
    assertNull(actualJson.input);
    assertNull(actualJson.error);
    assertTrue(actualJson.parsedItems.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseResult.Json#parsedItems()}
   */
  @Test
  void testJsonParsedItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingParseResult.Json()).parsedItems());
  }
}
