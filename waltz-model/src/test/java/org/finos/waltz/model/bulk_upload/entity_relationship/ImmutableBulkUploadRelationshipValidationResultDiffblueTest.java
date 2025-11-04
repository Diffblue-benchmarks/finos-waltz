package org.finos.waltz.model.bulk_upload.entity_relationship;

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
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableBulkUploadRelationshipValidationResultDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidationResult.Builder#addAllValidatedItems(Iterable)}
   */
  @Test
  void testBuilderAddAllValidatedItems() {
    // Arrange
    ImmutableBulkUploadRelationshipValidationResult.Builder builderResult = ImmutableBulkUploadRelationshipValidationResult
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllValidatedItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidationResult.Builder#addValidatedItems(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  void testBuilderAddValidatedItems() {
    // Arrange
    ImmutableBulkUploadRelationshipValidationResult.Builder builderResult = ImmutableBulkUploadRelationshipValidationResult
        .builder();
    ImmutableBulkUploadRelationshipValidatedItem.Json element = new ImmutableBulkUploadRelationshipValidatedItem.Json();

    // Act
    ImmutableBulkUploadRelationshipValidationResult.Builder actualAddValidatedItemsResult = builderResult
        .addValidatedItems(element);

    // Assert
    List<BulkUploadRelationshipValidatedItem> validatedItemsResult = builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(element, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidationResult.Builder#addValidatedItems(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  void testBuilderAddValidatedItems2() {
    // Arrange
    ImmutableBulkUploadRelationshipValidationResult.Builder builderResult = ImmutableBulkUploadRelationshipValidationResult
        .builder();

    ImmutableBulkUploadRelationshipValidatedItem.Json element = new ImmutableBulkUploadRelationshipValidatedItem.Json();
    element.setSourceEntityRef(mock(EntityReference.class));

    // Act
    ImmutableBulkUploadRelationshipValidationResult.Builder actualAddValidatedItemsResult = builderResult
        .addValidatedItems(element);

    // Assert
    List<BulkUploadRelationshipValidatedItem> validatedItemsResult = builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(element, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidationResult.Builder#addValidatedItems(BulkUploadRelationshipValidatedItem[])}
   */
  @Test
  void testBuilderAddValidatedItems3() {
    // Arrange
    ImmutableBulkUploadRelationshipValidationResult.Builder builderResult = ImmutableBulkUploadRelationshipValidationResult
        .builder();
    ImmutableBulkUploadRelationshipValidatedItem.Json json = new ImmutableBulkUploadRelationshipValidatedItem.Json();

    // Act
    ImmutableBulkUploadRelationshipValidationResult.Builder actualAddValidatedItemsResult = builderResult
        .addValidatedItems(json);

    // Assert
    List<BulkUploadRelationshipValidatedItem> validatedItemsResult = builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(json, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidationResult.Builder#addValidatedItems(BulkUploadRelationshipValidatedItem[])}
   */
  @Test
  void testBuilderAddValidatedItems4() {
    // Arrange
    ImmutableBulkUploadRelationshipValidationResult.Builder builderResult = ImmutableBulkUploadRelationshipValidationResult
        .builder();

    ImmutableBulkUploadRelationshipValidatedItem.Json json = new ImmutableBulkUploadRelationshipValidatedItem.Json();
    json.setSourceEntityRef(mock(EntityReference.class));

    // Act
    ImmutableBulkUploadRelationshipValidationResult.Builder actualAddValidatedItemsResult = builderResult
        .addValidatedItems(json);

    // Assert
    List<BulkUploadRelationshipValidatedItem> validatedItemsResult = builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(json, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipValidationResult.Builder#build()}
   *   <li>
   * {@link ImmutableBulkUploadRelationshipValidationResult.Builder#parseError(BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange
    ImmutableBulkUploadRelationshipValidationResult.Builder builderResult = ImmutableBulkUploadRelationshipValidationResult
        .builder();
    ImmutableBulkUploadRelationshipParseError.Json parseError = new ImmutableBulkUploadRelationshipParseError.Json();

    // Act
    ImmutableBulkUploadRelationshipValidationResult actualBuildResult = builderResult.parseError(parseError).build();

    // Assert
    assertTrue(actualBuildResult.validatedItems().isEmpty());
    assertSame(parseError, actualBuildResult.parseError());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidationResult.Builder#from(BulkUploadRelationshipValidationResult)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBulkUploadRelationshipValidationResult.Builder builderResult = ImmutableBulkUploadRelationshipValidationResult
        .builder();
    BulkUploadRelationshipValidationResult instance = mock(BulkUploadRelationshipValidationResult.class);
    when(instance.validatedItems()).thenReturn(new ArrayList<>());
    ImmutableBulkUploadRelationshipParseError.Json json = new ImmutableBulkUploadRelationshipParseError.Json();
    when(instance.parseError()).thenReturn(json);

    // Act
    ImmutableBulkUploadRelationshipValidationResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parseError();
    verify(instance).validatedItems();
    assertSame(json, builderResult.build().parseError());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidationResult.Builder#from(BulkUploadRelationshipValidationResult)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBulkUploadRelationshipValidationResult.Builder builderResult = ImmutableBulkUploadRelationshipValidationResult
        .builder();

    ArrayList<BulkUploadRelationshipValidatedItem> bulkUploadRelationshipValidatedItemList = new ArrayList<>();
    ImmutableBulkUploadRelationshipValidatedItem.Json json = new ImmutableBulkUploadRelationshipValidatedItem.Json();
    bulkUploadRelationshipValidatedItemList.add(json);
    BulkUploadRelationshipValidationResult instance = mock(BulkUploadRelationshipValidationResult.class);
    when(instance.validatedItems()).thenReturn(bulkUploadRelationshipValidatedItemList);
    ImmutableBulkUploadRelationshipParseError.Json json2 = new ImmutableBulkUploadRelationshipParseError.Json();
    when(instance.parseError()).thenReturn(json2);

    // Act
    ImmutableBulkUploadRelationshipValidationResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parseError();
    verify(instance).validatedItems();
    ImmutableBulkUploadRelationshipValidationResult buildResult = builderResult.build();
    List<BulkUploadRelationshipValidatedItem> validatedItemsResult = buildResult.validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(json2, buildResult.parseError());
    assertSame(json, validatedItemsResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidationResult.Builder#from(BulkUploadRelationshipValidationResult)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableBulkUploadRelationshipValidationResult.Builder builderResult = ImmutableBulkUploadRelationshipValidationResult
        .builder();
    BulkUploadRelationshipValidationResult instance = mock(BulkUploadRelationshipValidationResult.class);
    when(instance.validatedItems()).thenReturn(new ArrayList<>());
    when(instance.parseError()).thenReturn(null);

    // Act
    ImmutableBulkUploadRelationshipValidationResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parseError();
    verify(instance).validatedItems();
    assertNull(builderResult.build().parseError());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidationResult.Builder#validatedItems(Iterable)}
   */
  @Test
  void testBuilderValidatedItems() {
    // Arrange
    ImmutableBulkUploadRelationshipValidationResult.Builder builderResult = ImmutableBulkUploadRelationshipValidationResult
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.validatedItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidationResult#copyOf(BulkUploadRelationshipValidationResult)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BulkUploadRelationshipValidationResult instance = mock(BulkUploadRelationshipValidationResult.class);
    when(instance.validatedItems()).thenReturn(new ArrayList<>());
    ImmutableBulkUploadRelationshipParseError.Json json = new ImmutableBulkUploadRelationshipParseError.Json();
    when(instance.parseError()).thenReturn(json);

    // Act
    ImmutableBulkUploadRelationshipValidationResult actualCopyOfResult = ImmutableBulkUploadRelationshipValidationResult
        .copyOf(instance);

    // Assert
    verify(instance).parseError();
    verify(instance).validatedItems();
    assertTrue(actualCopyOfResult.validatedItems().isEmpty());
    assertSame(json, actualCopyOfResult.parseError());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidationResult#copyOf(BulkUploadRelationshipValidationResult)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<BulkUploadRelationshipValidatedItem> bulkUploadRelationshipValidatedItemList = new ArrayList<>();
    bulkUploadRelationshipValidatedItemList.add(new ImmutableBulkUploadRelationshipValidatedItem.Json());
    BulkUploadRelationshipValidationResult instance = mock(BulkUploadRelationshipValidationResult.class);
    when(instance.validatedItems()).thenReturn(bulkUploadRelationshipValidatedItemList);
    ImmutableBulkUploadRelationshipParseError.Json json = new ImmutableBulkUploadRelationshipParseError.Json();
    when(instance.parseError()).thenReturn(json);

    // Act
    ImmutableBulkUploadRelationshipValidationResult actualCopyOfResult = ImmutableBulkUploadRelationshipValidationResult
        .copyOf(instance);

    // Assert
    verify(instance).parseError();
    verify(instance).validatedItems();
    assertEquals(bulkUploadRelationshipValidatedItemList, actualCopyOfResult.validatedItems());
    assertSame(json, actualCopyOfResult.parseError());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidationResult#copyOf(BulkUploadRelationshipValidationResult)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<BulkUploadRelationshipValidatedItem> bulkUploadRelationshipValidatedItemList = new ArrayList<>();
    bulkUploadRelationshipValidatedItemList.add(new ImmutableBulkUploadRelationshipValidatedItem.Json());
    bulkUploadRelationshipValidatedItemList.add(new ImmutableBulkUploadRelationshipValidatedItem.Json());
    BulkUploadRelationshipValidationResult instance = mock(BulkUploadRelationshipValidationResult.class);
    when(instance.validatedItems()).thenReturn(bulkUploadRelationshipValidatedItemList);
    ImmutableBulkUploadRelationshipParseError.Json json = new ImmutableBulkUploadRelationshipParseError.Json();
    when(instance.parseError()).thenReturn(json);

    // Act
    ImmutableBulkUploadRelationshipValidationResult actualCopyOfResult = ImmutableBulkUploadRelationshipValidationResult
        .copyOf(instance);

    // Assert
    verify(instance).parseError();
    verify(instance).validatedItems();
    assertEquals(bulkUploadRelationshipValidatedItemList, actualCopyOfResult.validatedItems());
    assertSame(json, actualCopyOfResult.parseError());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidationResult#copyOf(BulkUploadRelationshipValidationResult)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    BulkUploadRelationshipValidationResult instance = mock(BulkUploadRelationshipValidationResult.class);
    when(instance.validatedItems()).thenReturn(new ArrayList<>());
    when(instance.parseError()).thenReturn(null);

    // Act
    ImmutableBulkUploadRelationshipValidationResult actualCopyOfResult = ImmutableBulkUploadRelationshipValidationResult
        .copyOf(instance);

    // Assert
    verify(instance).parseError();
    verify(instance).validatedItems();
    assertNull(actualCopyOfResult.parseError());
    assertTrue(actualCopyOfResult.validatedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(ImmutableBulkUploadRelationshipValidationResult.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableBulkUploadRelationshipValidationResult.Json json = new ImmutableBulkUploadRelationshipValidationResult.Json();

    // Act
    ImmutableBulkUploadRelationshipValidationResult actualFromJsonResult = ImmutableBulkUploadRelationshipValidationResult
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.parseError());
    List<BulkUploadRelationshipValidatedItem> validatedItemsResult = actualFromJsonResult.validatedItems();
    assertTrue(validatedItemsResult.isEmpty());
    assertSame(json.validatedItems, validatedItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(ImmutableBulkUploadRelationshipValidationResult.Json)}
   */
  @Test
  void testFromJson2() {
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
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(ImmutableBulkUploadRelationshipValidationResult.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ImmutableBulkUploadRelationshipValidationResult.Json json = new ImmutableBulkUploadRelationshipValidationResult.Json();
    json.setValidatedItems(null);
    ImmutableBulkUploadRelationshipParseError.Json parseError = new ImmutableBulkUploadRelationshipParseError.Json();
    json.setParseError(parseError);

    // Act
    ImmutableBulkUploadRelationshipValidationResult actualFromJsonResult = ImmutableBulkUploadRelationshipValidationResult
        .fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.validatedItems().isEmpty());
    assertSame(parseError, actualFromJsonResult.parseError());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(ImmutableBulkUploadRelationshipValidationResult.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    ArrayList<BulkUploadRelationshipValidatedItem> validatedItems = new ArrayList<>();
    validatedItems.add(new ImmutableBulkUploadRelationshipValidatedItem.Json());

    ImmutableBulkUploadRelationshipValidationResult.Json json = new ImmutableBulkUploadRelationshipValidationResult.Json();
    json.setValidatedItems(validatedItems);
    json.setParseError(null);

    // Act
    ImmutableBulkUploadRelationshipValidationResult actualFromJsonResult = ImmutableBulkUploadRelationshipValidationResult
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.parseError());
    assertEquals(validatedItems, actualFromJsonResult.validatedItems());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(ImmutableBulkUploadRelationshipValidationResult.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    COWArrayList<BulkUploadRelationshipValidatedItem> validatedItems = mock(COWArrayList.class);

    ArrayList<BulkUploadRelationshipValidatedItem> bulkUploadRelationshipValidatedItemList = new ArrayList<>();
    when(validatedItems.iterator()).thenReturn(bulkUploadRelationshipValidatedItemList.iterator());

    ImmutableBulkUploadRelationshipValidationResult.Json json = new ImmutableBulkUploadRelationshipValidationResult.Json();
    json.setValidatedItems(validatedItems);
    json.setParseError(null);

    // Act
    ImmutableBulkUploadRelationshipValidationResult actualFromJsonResult = ImmutableBulkUploadRelationshipValidationResult
        .fromJson(json);

    // Assert
    verify(validatedItems).iterator();
    assertNull(actualFromJsonResult.parseError());
    assertTrue(actualFromJsonResult.validatedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(ImmutableBulkUploadRelationshipValidationResult.Json)}
   */
  @Test
  void testFromJson6() {
    // Arrange
    ArrayList<BulkUploadRelationshipValidatedItem> bulkUploadRelationshipValidatedItemList = new ArrayList<>();
    bulkUploadRelationshipValidatedItemList.add(new ImmutableBulkUploadRelationshipValidatedItem.Json());
    bulkUploadRelationshipValidatedItemList.add(new ImmutableBulkUploadRelationshipValidatedItem.Json());
    COWArrayList<BulkUploadRelationshipValidatedItem> validatedItems = mock(COWArrayList.class);
    when(validatedItems.iterator()).thenReturn(bulkUploadRelationshipValidatedItemList.iterator());

    ImmutableBulkUploadRelationshipValidationResult.Json json = new ImmutableBulkUploadRelationshipValidationResult.Json();
    json.setValidatedItems(validatedItems);
    json.setParseError(null);

    // Act
    ImmutableBulkUploadRelationshipValidationResult actualFromJsonResult = ImmutableBulkUploadRelationshipValidationResult
        .fromJson(json);

    // Assert
    verify(validatedItems).iterator();
    assertNull(actualFromJsonResult.parseError());
    assertEquals(bulkUploadRelationshipValidatedItemList, actualFromJsonResult.validatedItems());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableBulkUploadRelationshipValidationResult.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableBulkUploadRelationshipValidationResult.Json actualJson = new ImmutableBulkUploadRelationshipValidationResult.Json();

    // Assert
    assertNull(actualJson.parseError);
    assertTrue(actualJson.validatedItems.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidationResult.Json#parseError()}
   */
  @Test
  void testJsonParseError() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadRelationshipValidationResult.Json()).parseError());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipValidationResult.Json#validatedItems()}
   */
  @Test
  void testJsonValidatedItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadRelationshipValidationResult.Json()).validatedItems());
  }
}
