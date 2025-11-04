package org.finos.waltz.model.bulk_upload.taxonomy;

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

class ImmutableBulkTaxonomyParseResultDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyParseResult.Builder#addAllParsedItems(Iterable)}
   */
  @Test
  void testBuilderAddAllParsedItems() {
    // Arrange
    ImmutableBulkTaxonomyParseResult.Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllParsedItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyParseResult.Builder#addParsedItems(BulkTaxonomyItem)}
   */
  @Test
  void testBuilderAddParsedItems() {
    // Arrange
    ImmutableBulkTaxonomyParseResult.Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyItem.Json element = new ImmutableBulkTaxonomyItem.Json();

    // Act
    ImmutableBulkTaxonomyParseResult.Builder actualAddParsedItemsResult = builderResult.addParsedItems(element);

    // Assert
    List<BulkTaxonomyItem> parsedItemsResult = builderResult.build().parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(element, parsedItemsResult.get(0));
    assertSame(builderResult, actualAddParsedItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyParseResult.Builder#addParsedItems(BulkTaxonomyItem[])}
   */
  @Test
  void testBuilderAddParsedItems2() {
    // Arrange
    ImmutableBulkTaxonomyParseResult.Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyItem.Json json = new ImmutableBulkTaxonomyItem.Json();

    // Act
    ImmutableBulkTaxonomyParseResult.Builder actualAddParsedItemsResult = builderResult.addParsedItems(json);

    // Assert
    List<BulkTaxonomyItem> parsedItemsResult = builderResult.build().parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(json, parsedItemsResult.get(0));
    assertSame(builderResult, actualAddParsedItemsResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyParseResult.Builder#build()}
   *   <li>
   * {@link ImmutableBulkTaxonomyParseResult.Builder#error(BulkTaxonomyParseResult.BulkTaxonomyParseError)}
   *   <li>{@link ImmutableBulkTaxonomyParseResult.Builder#input(String)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange
    ImmutableBulkTaxonomyParseResult.Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseError.Json error = new ImmutableBulkTaxonomyParseError.Json();

    // Act
    ImmutableBulkTaxonomyParseResult actualBuildResult = builderResult.error(error).input("Input").build();

    // Assert
    assertEquals("Input", actualBuildResult.input());
    assertTrue(actualBuildResult.parsedItems().isEmpty());
    assertSame(error, actualBuildResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyParseResult.Builder#from(BulkTaxonomyParseResult)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBulkTaxonomyParseResult.Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    BulkTaxonomyParseResult instance = mock(BulkTaxonomyParseResult.class);
    when(instance.input()).thenReturn("Input");
    when(instance.parsedItems()).thenReturn(new ArrayList<>());
    ImmutableBulkTaxonomyParseError.Json json = new ImmutableBulkTaxonomyParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableBulkTaxonomyParseResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    ImmutableBulkTaxonomyParseResult buildResult = builderResult.build();
    assertEquals("Input", buildResult.input());
    assertSame(json, buildResult.error());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyParseResult.Builder#from(BulkTaxonomyParseResult)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBulkTaxonomyParseResult.Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    BulkTaxonomyParseResult instance = mock(BulkTaxonomyParseResult.class);
    when(instance.input()).thenReturn(null);
    when(instance.parsedItems()).thenReturn(new ArrayList<>());
    ImmutableBulkTaxonomyParseError.Json json = new ImmutableBulkTaxonomyParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableBulkTaxonomyParseResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    ImmutableBulkTaxonomyParseResult buildResult = builderResult.build();
    assertNull(buildResult.input());
    assertSame(json, buildResult.error());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyParseResult.Builder#from(BulkTaxonomyParseResult)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableBulkTaxonomyParseResult.Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();

    ArrayList<BulkTaxonomyItem> bulkTaxonomyItemList = new ArrayList<>();
    ImmutableBulkTaxonomyItem.Json json = new ImmutableBulkTaxonomyItem.Json();
    bulkTaxonomyItemList.add(json);
    BulkTaxonomyParseResult instance = mock(BulkTaxonomyParseResult.class);
    when(instance.input()).thenReturn("Input");
    when(instance.parsedItems()).thenReturn(bulkTaxonomyItemList);
    ImmutableBulkTaxonomyParseError.Json json2 = new ImmutableBulkTaxonomyParseError.Json();
    when(instance.error()).thenReturn(json2);

    // Act
    ImmutableBulkTaxonomyParseResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    ImmutableBulkTaxonomyParseResult buildResult = builderResult.build();
    assertEquals("Input", buildResult.input());
    List<BulkTaxonomyItem> parsedItemsResult = buildResult.parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(json, parsedItemsResult.get(0));
    assertSame(json2, buildResult.error());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyParseResult.Builder#from(BulkTaxonomyParseResult)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableBulkTaxonomyParseResult.Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    BulkTaxonomyParseResult instance = mock(BulkTaxonomyParseResult.class);
    when(instance.input()).thenReturn("Input");
    when(instance.parsedItems()).thenReturn(new ArrayList<>());
    when(instance.error()).thenReturn(null);

    // Act
    ImmutableBulkTaxonomyParseResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    ImmutableBulkTaxonomyParseResult buildResult = builderResult.build();
    assertEquals("Input", buildResult.input());
    assertNull(buildResult.error());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyParseResult.Builder#parsedItems(Iterable)}
   */
  @Test
  void testBuilderParsedItems() {
    // Arrange
    ImmutableBulkTaxonomyParseResult.Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parsedItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyParseResult#copyOf(BulkTaxonomyParseResult)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BulkTaxonomyParseResult instance = mock(BulkTaxonomyParseResult.class);
    when(instance.input()).thenReturn("Input");
    when(instance.parsedItems()).thenReturn(new ArrayList<>());
    ImmutableBulkTaxonomyParseError.Json json = new ImmutableBulkTaxonomyParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableBulkTaxonomyParseResult actualCopyOfResult = ImmutableBulkTaxonomyParseResult.copyOf(instance);

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
   * {@link ImmutableBulkTaxonomyParseResult#copyOf(BulkTaxonomyParseResult)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<BulkTaxonomyItem> bulkTaxonomyItemList = new ArrayList<>();
    bulkTaxonomyItemList.add(new ImmutableBulkTaxonomyItem.Json());
    BulkTaxonomyParseResult instance = mock(BulkTaxonomyParseResult.class);
    when(instance.input()).thenReturn("Input");
    when(instance.parsedItems()).thenReturn(bulkTaxonomyItemList);
    ImmutableBulkTaxonomyParseError.Json json = new ImmutableBulkTaxonomyParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableBulkTaxonomyParseResult actualCopyOfResult = ImmutableBulkTaxonomyParseResult.copyOf(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    assertEquals("Input", actualCopyOfResult.input());
    assertEquals(bulkTaxonomyItemList, actualCopyOfResult.parsedItems());
    assertSame(json, actualCopyOfResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyParseResult#copyOf(BulkTaxonomyParseResult)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<BulkTaxonomyItem> bulkTaxonomyItemList = new ArrayList<>();
    bulkTaxonomyItemList.add(new ImmutableBulkTaxonomyItem.Json());
    bulkTaxonomyItemList.add(new ImmutableBulkTaxonomyItem.Json());
    BulkTaxonomyParseResult instance = mock(BulkTaxonomyParseResult.class);
    when(instance.input()).thenReturn("Input");
    when(instance.parsedItems()).thenReturn(bulkTaxonomyItemList);
    ImmutableBulkTaxonomyParseError.Json json = new ImmutableBulkTaxonomyParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableBulkTaxonomyParseResult actualCopyOfResult = ImmutableBulkTaxonomyParseResult.copyOf(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    assertEquals("Input", actualCopyOfResult.input());
    assertEquals(bulkTaxonomyItemList, actualCopyOfResult.parsedItems());
    assertSame(json, actualCopyOfResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyParseResult#copyOf(BulkTaxonomyParseResult)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    BulkTaxonomyParseResult instance = mock(BulkTaxonomyParseResult.class);
    when(instance.input()).thenReturn("Input");
    when(instance.parsedItems()).thenReturn(new ArrayList<>());
    when(instance.error()).thenReturn(null);

    // Act
    ImmutableBulkTaxonomyParseResult actualCopyOfResult = ImmutableBulkTaxonomyParseResult.copyOf(instance);

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
   * {@link ImmutableBulkTaxonomyParseResult#fromJson(ImmutableBulkTaxonomyParseResult.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableBulkTaxonomyParseResult.Json json = new ImmutableBulkTaxonomyParseResult.Json();

    // Act
    ImmutableBulkTaxonomyParseResult actualFromJsonResult = ImmutableBulkTaxonomyParseResult.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    List<BulkTaxonomyItem> parsedItemsResult = actualFromJsonResult.parsedItems();
    assertTrue(parsedItemsResult.isEmpty());
    assertSame(json.parsedItems, parsedItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyParseResult#fromJson(ImmutableBulkTaxonomyParseResult.Json)}
   */
  @Test
  void testFromJson2() {
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
   * Method under test:
   * {@link ImmutableBulkTaxonomyParseResult#fromJson(ImmutableBulkTaxonomyParseResult.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ImmutableBulkTaxonomyParseResult.Json json = new ImmutableBulkTaxonomyParseResult.Json();
    json.setParsedItems(null);
    json.setInput(null);
    ImmutableBulkTaxonomyParseError.Json error = new ImmutableBulkTaxonomyParseError.Json();
    json.setError(error);

    // Act
    ImmutableBulkTaxonomyParseResult actualFromJsonResult = ImmutableBulkTaxonomyParseResult.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.input());
    assertTrue(actualFromJsonResult.parsedItems().isEmpty());
    assertSame(error, actualFromJsonResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyParseResult#fromJson(ImmutableBulkTaxonomyParseResult.Json)}
   */
  @Test
  void testFromJson4() {
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
   * Method under test:
   * {@link ImmutableBulkTaxonomyParseResult#fromJson(ImmutableBulkTaxonomyParseResult.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    ArrayList<BulkTaxonomyItem> parsedItems = new ArrayList<>();
    parsedItems.add(new ImmutableBulkTaxonomyItem.Json());

    ImmutableBulkTaxonomyParseResult.Json json = new ImmutableBulkTaxonomyParseResult.Json();
    json.setParsedItems(parsedItems);
    json.setInput(null);
    json.setError(null);

    // Act
    ImmutableBulkTaxonomyParseResult actualFromJsonResult = ImmutableBulkTaxonomyParseResult.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertEquals(parsedItems, actualFromJsonResult.parsedItems());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyParseResult#fromJson(ImmutableBulkTaxonomyParseResult.Json)}
   */
  @Test
  void testFromJson6() {
    // Arrange
    COWArrayList<BulkTaxonomyItem> parsedItems = mock(COWArrayList.class);

    ArrayList<BulkTaxonomyItem> bulkTaxonomyItemList = new ArrayList<>();
    when(parsedItems.iterator()).thenReturn(bulkTaxonomyItemList.iterator());

    ImmutableBulkTaxonomyParseResult.Json json = new ImmutableBulkTaxonomyParseResult.Json();
    json.setParsedItems(parsedItems);
    json.setInput(null);
    json.setError(null);

    // Act
    ImmutableBulkTaxonomyParseResult actualFromJsonResult = ImmutableBulkTaxonomyParseResult.fromJson(json);

    // Assert
    verify(parsedItems).iterator();
    assertNull(actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertTrue(actualFromJsonResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyParseResult#fromJson(ImmutableBulkTaxonomyParseResult.Json)}
   */
  @Test
  void testFromJson7() {
    // Arrange
    ArrayList<BulkTaxonomyItem> bulkTaxonomyItemList = new ArrayList<>();
    bulkTaxonomyItemList.add(new ImmutableBulkTaxonomyItem.Json());
    bulkTaxonomyItemList.add(new ImmutableBulkTaxonomyItem.Json());
    COWArrayList<BulkTaxonomyItem> parsedItems = mock(COWArrayList.class);
    when(parsedItems.iterator()).thenReturn(bulkTaxonomyItemList.iterator());

    ImmutableBulkTaxonomyParseResult.Json json = new ImmutableBulkTaxonomyParseResult.Json();
    json.setParsedItems(parsedItems);
    json.setInput(null);
    json.setError(null);

    // Act
    ImmutableBulkTaxonomyParseResult actualFromJsonResult = ImmutableBulkTaxonomyParseResult.fromJson(json);

    // Assert
    verify(parsedItems).iterator();
    assertNull(actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertEquals(bulkTaxonomyItemList, actualFromJsonResult.parsedItems());
  }

  /**
   * Method under test: {@link ImmutableBulkTaxonomyParseResult.Json#error()}
   */
  @Test
  void testJsonError() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkTaxonomyParseResult.Json()).error());
  }

  /**
   * Method under test: {@link ImmutableBulkTaxonomyParseResult.Json#input()}
   */
  @Test
  void testJsonInput() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkTaxonomyParseResult.Json()).input());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableBulkTaxonomyParseResult.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableBulkTaxonomyParseResult.Json actualJson = new ImmutableBulkTaxonomyParseResult.Json();

    // Assert
    assertNull(actualJson.input);
    assertNull(actualJson.error);
    assertTrue(actualJson.parsedItems.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyParseResult.Json#parsedItems()}
   */
  @Test
  void testJsonParsedItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkTaxonomyParseResult.Json()).parsedItems());
  }
}
