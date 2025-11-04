package org.finos.waltz.model.bulk_upload.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ImmutableBulkUploadRelationshipParsedResultDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipParsedResult#builder()}
   *   <li>
   * {@link ImmutableBulkUploadRelationshipParsedResult#error(BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableBulkUploadRelationshipParsedResult.Builder actualBuilderResult = ImmutableBulkUploadRelationshipParsedResult
        .builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.error(new ImmutableBulkUploadRelationshipParseError.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParsedResult.Builder#addAllParsedItems(Iterable)}
   */
  @Test
  void testBuilderAddAllParsedItems() {
    // Arrange
    ImmutableBulkUploadRelationshipParsedResult.Builder builderResult = ImmutableBulkUploadRelationshipParsedResult
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllParsedItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParsedResult.Builder#addParsedItems(BulkUploadRelationshipItem)}
   */
  @Test
  void testBuilderAddParsedItems() {
    // Arrange
    ImmutableBulkUploadRelationshipParsedResult.Builder builderResult = ImmutableBulkUploadRelationshipParsedResult
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addParsedItems(new ImmutableBulkUploadRelationshipItem.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParsedResult.Builder#addParsedItems(BulkUploadRelationshipItem[])}
   */
  @Test
  void testBuilderAddParsedItems2() {
    // Arrange
    ImmutableBulkUploadRelationshipParsedResult.Builder builderResult = ImmutableBulkUploadRelationshipParsedResult
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addParsedItems(new ImmutableBulkUploadRelationshipItem.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParsedResult.Builder#from(BulkUploadRelationshipParsedResult)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBulkUploadRelationshipParsedResult.Builder builderResult = ImmutableBulkUploadRelationshipParsedResult
        .builder();
    BulkUploadRelationshipParsedResult instance = mock(BulkUploadRelationshipParsedResult.class);
    when(instance.parsedItems()).thenReturn(new ArrayList<>());
    ImmutableBulkUploadRelationshipParseError.Json json = new ImmutableBulkUploadRelationshipParseError.Json();
    when(instance.error()).thenReturn(json);
    when(instance.input()).thenReturn("Input");

    // Act
    ImmutableBulkUploadRelationshipParsedResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    ImmutableBulkUploadRelationshipParsedResult buildResult = builderResult.build();
    assertEquals("Input", buildResult.input());
    assertSame(json, buildResult.error());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParsedResult.Builder#from(BulkUploadRelationshipParsedResult)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBulkUploadRelationshipParsedResult.Builder builderResult = ImmutableBulkUploadRelationshipParsedResult
        .builder();
    BulkUploadRelationshipParsedResult instance = mock(BulkUploadRelationshipParsedResult.class);
    when(instance.parsedItems()).thenThrow(new IllegalStateException("instance"));
    when(instance.input()).thenReturn("Input");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).input();
    verify(instance).parsedItems();
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParsedResult.Builder#from(BulkUploadRelationshipParsedResult)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableBulkUploadRelationshipParsedResult.Builder builderResult = ImmutableBulkUploadRelationshipParsedResult
        .builder();

    ArrayList<BulkUploadRelationshipItem> bulkUploadRelationshipItemList = new ArrayList<>();
    ImmutableBulkUploadRelationshipItem.Json json = new ImmutableBulkUploadRelationshipItem.Json();
    bulkUploadRelationshipItemList.add(json);
    BulkUploadRelationshipParsedResult instance = mock(BulkUploadRelationshipParsedResult.class);
    when(instance.parsedItems()).thenReturn(bulkUploadRelationshipItemList);
    ImmutableBulkUploadRelationshipParseError.Json json2 = new ImmutableBulkUploadRelationshipParseError.Json();
    when(instance.error()).thenReturn(json2);
    when(instance.input()).thenReturn("Input");

    // Act
    ImmutableBulkUploadRelationshipParsedResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    ImmutableBulkUploadRelationshipParsedResult buildResult = builderResult.build();
    assertEquals("Input", buildResult.input());
    List<BulkUploadRelationshipItem> parsedItemsResult = buildResult.parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(json, parsedItemsResult.get(0));
    assertSame(json2, buildResult.error());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParsedResult.Builder#from(BulkUploadRelationshipParsedResult)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableBulkUploadRelationshipParsedResult.Builder builderResult = ImmutableBulkUploadRelationshipParsedResult
        .builder();
    BulkUploadRelationshipParsedResult instance = mock(BulkUploadRelationshipParsedResult.class);
    when(instance.parsedItems()).thenReturn(new ArrayList<>());
    when(instance.error()).thenReturn(null);
    when(instance.input()).thenReturn("Input");

    // Act
    ImmutableBulkUploadRelationshipParsedResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    ImmutableBulkUploadRelationshipParsedResult buildResult = builderResult.build();
    assertEquals("Input", buildResult.input());
    assertNull(buildResult.error());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParsedResult.Builder#input(String)}
   */
  @Test
  void testBuilderInput() {
    // Arrange
    ImmutableBulkUploadRelationshipParsedResult.Builder builderResult = ImmutableBulkUploadRelationshipParsedResult
        .builder();

    // Act
    ImmutableBulkUploadRelationshipParsedResult.Builder actualInputResult = builderResult.input("Input");

    // Assert
    ImmutableBulkUploadRelationshipParsedResult buildResult = builderResult.build();
    assertEquals("Input", buildResult.input());
    assertNull(buildResult.error());
    assertSame(builderResult, actualInputResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParsedResult.Builder#parsedItems(Iterable)}
   */
  @Test
  void testBuilderParsedItems() {
    // Arrange
    ImmutableBulkUploadRelationshipParsedResult.Builder builderResult = ImmutableBulkUploadRelationshipParsedResult
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parsedItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParsedResult#copyOf(BulkUploadRelationshipParsedResult)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BulkUploadRelationshipParsedResult instance = mock(BulkUploadRelationshipParsedResult.class);
    when(instance.parsedItems()).thenReturn(new ArrayList<>());
    ImmutableBulkUploadRelationshipParseError.Json json = new ImmutableBulkUploadRelationshipParseError.Json();
    when(instance.error()).thenReturn(json);
    when(instance.input()).thenReturn("Input");

    // Act
    ImmutableBulkUploadRelationshipParsedResult actualCopyOfResult = ImmutableBulkUploadRelationshipParsedResult
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
   * {@link ImmutableBulkUploadRelationshipParsedResult#copyOf(BulkUploadRelationshipParsedResult)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<BulkUploadRelationshipItem> bulkUploadRelationshipItemList = new ArrayList<>();
    bulkUploadRelationshipItemList.add(new ImmutableBulkUploadRelationshipItem.Json());
    BulkUploadRelationshipParsedResult instance = mock(BulkUploadRelationshipParsedResult.class);
    when(instance.parsedItems()).thenReturn(bulkUploadRelationshipItemList);
    ImmutableBulkUploadRelationshipParseError.Json json = new ImmutableBulkUploadRelationshipParseError.Json();
    when(instance.error()).thenReturn(json);
    when(instance.input()).thenReturn("Input");

    // Act
    ImmutableBulkUploadRelationshipParsedResult actualCopyOfResult = ImmutableBulkUploadRelationshipParsedResult
        .copyOf(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    assertEquals("Input", actualCopyOfResult.input());
    assertEquals(bulkUploadRelationshipItemList, actualCopyOfResult.parsedItems());
    assertSame(json, actualCopyOfResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParsedResult#copyOf(BulkUploadRelationshipParsedResult)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<BulkUploadRelationshipItem> bulkUploadRelationshipItemList = new ArrayList<>();
    bulkUploadRelationshipItemList.add(new ImmutableBulkUploadRelationshipItem.Json());
    bulkUploadRelationshipItemList.add(new ImmutableBulkUploadRelationshipItem.Json());
    BulkUploadRelationshipParsedResult instance = mock(BulkUploadRelationshipParsedResult.class);
    when(instance.parsedItems()).thenReturn(bulkUploadRelationshipItemList);
    ImmutableBulkUploadRelationshipParseError.Json json = new ImmutableBulkUploadRelationshipParseError.Json();
    when(instance.error()).thenReturn(json);
    when(instance.input()).thenReturn("Input");

    // Act
    ImmutableBulkUploadRelationshipParsedResult actualCopyOfResult = ImmutableBulkUploadRelationshipParsedResult
        .copyOf(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    assertEquals("Input", actualCopyOfResult.input());
    assertEquals(bulkUploadRelationshipItemList, actualCopyOfResult.parsedItems());
    assertSame(json, actualCopyOfResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParsedResult#copyOf(BulkUploadRelationshipParsedResult)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    BulkUploadRelationshipParsedResult instance = mock(BulkUploadRelationshipParsedResult.class);
    when(instance.parsedItems()).thenReturn(new ArrayList<>());
    when(instance.error()).thenReturn(null);
    when(instance.input()).thenReturn("Input");

    // Act
    ImmutableBulkUploadRelationshipParsedResult actualCopyOfResult = ImmutableBulkUploadRelationshipParsedResult
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
   * {@link ImmutableBulkUploadRelationshipParsedResult#fromJson(ImmutableBulkUploadRelationshipParsedResult.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableBulkUploadRelationshipParsedResult.Json json = new ImmutableBulkUploadRelationshipParsedResult.Json();
    json.setInput("Json");
    json.setParsedItems(null);
    json.setError(null);

    // Act
    ImmutableBulkUploadRelationshipParsedResult actualFromJsonResult = ImmutableBulkUploadRelationshipParsedResult
        .fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertTrue(actualFromJsonResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParsedResult#fromJson(ImmutableBulkUploadRelationshipParsedResult.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ArrayList<BulkUploadRelationshipItem> parsedItems = new ArrayList<>();
    parsedItems.add(new ImmutableBulkUploadRelationshipItem.Json());

    ImmutableBulkUploadRelationshipParsedResult.Json json = new ImmutableBulkUploadRelationshipParsedResult.Json();
    json.setInput("Json");
    json.setParsedItems(parsedItems);
    json.setError(null);

    // Act
    ImmutableBulkUploadRelationshipParsedResult actualFromJsonResult = ImmutableBulkUploadRelationshipParsedResult
        .fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertEquals(parsedItems, actualFromJsonResult.parsedItems());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParsedResult#fromJson(ImmutableBulkUploadRelationshipParsedResult.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<BulkUploadRelationshipItem> parsedItems = new ArrayList<>();
    parsedItems.add(new ImmutableBulkUploadRelationshipItem.Json());
    parsedItems.add(new ImmutableBulkUploadRelationshipItem.Json());

    ImmutableBulkUploadRelationshipParsedResult.Json json = new ImmutableBulkUploadRelationshipParsedResult.Json();
    json.setInput("Json");
    json.setParsedItems(parsedItems);
    json.setError(null);

    // Act
    ImmutableBulkUploadRelationshipParsedResult actualFromJsonResult = ImmutableBulkUploadRelationshipParsedResult
        .fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertEquals(parsedItems, actualFromJsonResult.parsedItems());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParsedResult.Json#error()}
   */
  @Test
  void testJsonError() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadRelationshipParsedResult.Json()).error());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParsedResult.Json#input()}
   */
  @Test
  void testJsonInput() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadRelationshipParsedResult.Json()).input());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableBulkUploadRelationshipParsedResult.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableBulkUploadRelationshipParsedResult.Json actualJson = new ImmutableBulkUploadRelationshipParsedResult.Json();

    // Assert
    assertNull(actualJson.input);
    assertNull(actualJson.error);
    assertTrue(actualJson.parsedItems.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParsedResult.Json#parsedItems()}
   */
  @Test
  void testJsonParsedItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadRelationshipParsedResult.Json()).parsedItems());
  }
}
