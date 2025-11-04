package org.finos.waltz.model.assessment_rating.bulk_upload;

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

class ImmutableAssessmentRatingParsedResultDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedResult.Builder#addAllParsedItems(Iterable)}
   */
  @Test
  void testBuilderAddAllParsedItems() {
    // Arrange
    ImmutableAssessmentRatingParsedResult.Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllParsedItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedResult.Builder#addParsedItems(AssessmentRatingParsedItem)}
   */
  @Test
  void testBuilderAddParsedItems() {
    // Arrange
    ImmutableAssessmentRatingParsedResult.Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedItem.Json element = new ImmutableAssessmentRatingParsedItem.Json();

    // Act
    ImmutableAssessmentRatingParsedResult.Builder actualAddParsedItemsResult = builderResult.addParsedItems(element);

    // Assert
    List<AssessmentRatingParsedItem> parsedItemsResult = builderResult.build().parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(element, parsedItemsResult.get(0));
    assertSame(builderResult, actualAddParsedItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedResult.Builder#addParsedItems(AssessmentRatingParsedItem[])}
   */
  @Test
  void testBuilderAddParsedItems2() {
    // Arrange
    ImmutableAssessmentRatingParsedResult.Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedItem.Json json = new ImmutableAssessmentRatingParsedItem.Json();

    // Act
    ImmutableAssessmentRatingParsedResult.Builder actualAddParsedItemsResult = builderResult.addParsedItems(json);

    // Assert
    List<AssessmentRatingParsedItem> parsedItemsResult = builderResult.build().parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(json, parsedItemsResult.get(0));
    assertSame(builderResult, actualAddParsedItemsResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingParsedResult.Builder#build()}
   *   <li>
   * {@link ImmutableAssessmentRatingParsedResult.Builder#error(AssessmentRatingParsedResult.AssessmentRatingParseError)}
   *   <li>{@link ImmutableAssessmentRatingParsedResult.Builder#input(String)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange
    ImmutableAssessmentRatingParsedResult.Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParseError.Json error = new ImmutableAssessmentRatingParseError.Json();

    // Act
    ImmutableAssessmentRatingParsedResult actualBuildResult = builderResult.error(error).input("Input").build();

    // Assert
    assertEquals("Input", actualBuildResult.input());
    assertTrue(actualBuildResult.parsedItems().isEmpty());
    assertSame(error, actualBuildResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedResult.Builder#from(AssessmentRatingParsedResult)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentRatingParsedResult.Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    AssessmentRatingParsedResult instance = mock(AssessmentRatingParsedResult.class);
    when(instance.input()).thenReturn("Input");
    when(instance.parsedItems()).thenReturn(new ArrayList<>());
    ImmutableAssessmentRatingParseError.Json json = new ImmutableAssessmentRatingParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableAssessmentRatingParsedResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    ImmutableAssessmentRatingParsedResult buildResult = builderResult.build();
    assertEquals("Input", buildResult.input());
    assertSame(json, buildResult.error());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedResult.Builder#from(AssessmentRatingParsedResult)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssessmentRatingParsedResult.Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    AssessmentRatingParsedResult instance = mock(AssessmentRatingParsedResult.class);
    when(instance.input()).thenReturn(null);
    when(instance.parsedItems()).thenReturn(new ArrayList<>());
    ImmutableAssessmentRatingParseError.Json json = new ImmutableAssessmentRatingParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableAssessmentRatingParsedResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    ImmutableAssessmentRatingParsedResult buildResult = builderResult.build();
    assertNull(buildResult.input());
    assertSame(json, buildResult.error());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedResult.Builder#from(AssessmentRatingParsedResult)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAssessmentRatingParsedResult.Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();

    ArrayList<AssessmentRatingParsedItem> assessmentRatingParsedItemList = new ArrayList<>();
    ImmutableAssessmentRatingParsedItem.Json json = new ImmutableAssessmentRatingParsedItem.Json();
    assessmentRatingParsedItemList.add(json);
    AssessmentRatingParsedResult instance = mock(AssessmentRatingParsedResult.class);
    when(instance.input()).thenReturn("Input");
    when(instance.parsedItems()).thenReturn(assessmentRatingParsedItemList);
    ImmutableAssessmentRatingParseError.Json json2 = new ImmutableAssessmentRatingParseError.Json();
    when(instance.error()).thenReturn(json2);

    // Act
    ImmutableAssessmentRatingParsedResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    ImmutableAssessmentRatingParsedResult buildResult = builderResult.build();
    assertEquals("Input", buildResult.input());
    List<AssessmentRatingParsedItem> parsedItemsResult = buildResult.parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(json2, buildResult.error());
    assertSame(json, parsedItemsResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedResult.Builder#from(AssessmentRatingParsedResult)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAssessmentRatingParsedResult.Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    AssessmentRatingParsedResult instance = mock(AssessmentRatingParsedResult.class);
    when(instance.input()).thenReturn("Input");
    when(instance.parsedItems()).thenReturn(new ArrayList<>());
    when(instance.error()).thenReturn(null);

    // Act
    ImmutableAssessmentRatingParsedResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    ImmutableAssessmentRatingParsedResult buildResult = builderResult.build();
    assertEquals("Input", buildResult.input());
    assertNull(buildResult.error());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedResult.Builder#parsedItems(Iterable)}
   */
  @Test
  void testBuilderParsedItems() {
    // Arrange
    ImmutableAssessmentRatingParsedResult.Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parsedItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedResult#copyOf(AssessmentRatingParsedResult)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentRatingParsedResult instance = mock(AssessmentRatingParsedResult.class);
    when(instance.input()).thenReturn("Input");
    when(instance.parsedItems()).thenReturn(new ArrayList<>());
    ImmutableAssessmentRatingParseError.Json json = new ImmutableAssessmentRatingParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableAssessmentRatingParsedResult actualCopyOfResult = ImmutableAssessmentRatingParsedResult.copyOf(instance);

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
   * {@link ImmutableAssessmentRatingParsedResult#copyOf(AssessmentRatingParsedResult)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<AssessmentRatingParsedItem> assessmentRatingParsedItemList = new ArrayList<>();
    assessmentRatingParsedItemList.add(new ImmutableAssessmentRatingParsedItem.Json());
    AssessmentRatingParsedResult instance = mock(AssessmentRatingParsedResult.class);
    when(instance.input()).thenReturn("Input");
    when(instance.parsedItems()).thenReturn(assessmentRatingParsedItemList);
    ImmutableAssessmentRatingParseError.Json json = new ImmutableAssessmentRatingParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableAssessmentRatingParsedResult actualCopyOfResult = ImmutableAssessmentRatingParsedResult.copyOf(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    assertEquals("Input", actualCopyOfResult.input());
    assertEquals(assessmentRatingParsedItemList, actualCopyOfResult.parsedItems());
    assertSame(json, actualCopyOfResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedResult#copyOf(AssessmentRatingParsedResult)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<AssessmentRatingParsedItem> assessmentRatingParsedItemList = new ArrayList<>();
    assessmentRatingParsedItemList.add(new ImmutableAssessmentRatingParsedItem.Json());
    assessmentRatingParsedItemList.add(new ImmutableAssessmentRatingParsedItem.Json());
    AssessmentRatingParsedResult instance = mock(AssessmentRatingParsedResult.class);
    when(instance.input()).thenReturn("Input");
    when(instance.parsedItems()).thenReturn(assessmentRatingParsedItemList);
    ImmutableAssessmentRatingParseError.Json json = new ImmutableAssessmentRatingParseError.Json();
    when(instance.error()).thenReturn(json);

    // Act
    ImmutableAssessmentRatingParsedResult actualCopyOfResult = ImmutableAssessmentRatingParsedResult.copyOf(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    assertEquals("Input", actualCopyOfResult.input());
    assertEquals(assessmentRatingParsedItemList, actualCopyOfResult.parsedItems());
    assertSame(json, actualCopyOfResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedResult#copyOf(AssessmentRatingParsedResult)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    AssessmentRatingParsedResult instance = mock(AssessmentRatingParsedResult.class);
    when(instance.input()).thenReturn("Input");
    when(instance.parsedItems()).thenReturn(new ArrayList<>());
    when(instance.error()).thenReturn(null);

    // Act
    ImmutableAssessmentRatingParsedResult actualCopyOfResult = ImmutableAssessmentRatingParsedResult.copyOf(instance);

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
   * {@link ImmutableAssessmentRatingParsedResult#fromJson(ImmutableAssessmentRatingParsedResult.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAssessmentRatingParsedResult.Json json = new ImmutableAssessmentRatingParsedResult.Json();

    // Act
    ImmutableAssessmentRatingParsedResult actualFromJsonResult = ImmutableAssessmentRatingParsedResult.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    List<AssessmentRatingParsedItem> parsedItemsResult = actualFromJsonResult.parsedItems();
    assertTrue(parsedItemsResult.isEmpty());
    assertSame(json.parsedItems, parsedItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedResult#fromJson(ImmutableAssessmentRatingParsedResult.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableAssessmentRatingParsedResult.Json json = new ImmutableAssessmentRatingParsedResult.Json();
    json.setParsedItems(null);
    json.setInput(null);
    json.setError(null);

    // Act
    ImmutableAssessmentRatingParsedResult actualFromJsonResult = ImmutableAssessmentRatingParsedResult.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertTrue(actualFromJsonResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedResult#fromJson(ImmutableAssessmentRatingParsedResult.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ImmutableAssessmentRatingParsedResult.Json json = new ImmutableAssessmentRatingParsedResult.Json();
    json.setParsedItems(null);
    json.setInput(null);
    ImmutableAssessmentRatingParseError.Json error = new ImmutableAssessmentRatingParseError.Json();
    json.setError(error);

    // Act
    ImmutableAssessmentRatingParsedResult actualFromJsonResult = ImmutableAssessmentRatingParsedResult.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.input());
    assertTrue(actualFromJsonResult.parsedItems().isEmpty());
    assertSame(error, actualFromJsonResult.error());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedResult#fromJson(ImmutableAssessmentRatingParsedResult.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    ImmutableAssessmentRatingParsedResult.Json json = new ImmutableAssessmentRatingParsedResult.Json();
    json.setParsedItems(null);
    json.setInput("Json");
    json.setError(null);

    // Act
    ImmutableAssessmentRatingParsedResult actualFromJsonResult = ImmutableAssessmentRatingParsedResult.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertTrue(actualFromJsonResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedResult#fromJson(ImmutableAssessmentRatingParsedResult.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    ArrayList<AssessmentRatingParsedItem> parsedItems = new ArrayList<>();
    parsedItems.add(new ImmutableAssessmentRatingParsedItem.Json());

    ImmutableAssessmentRatingParsedResult.Json json = new ImmutableAssessmentRatingParsedResult.Json();
    json.setParsedItems(parsedItems);
    json.setInput(null);
    json.setError(null);

    // Act
    ImmutableAssessmentRatingParsedResult actualFromJsonResult = ImmutableAssessmentRatingParsedResult.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertEquals(parsedItems, actualFromJsonResult.parsedItems());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedResult#fromJson(ImmutableAssessmentRatingParsedResult.Json)}
   */
  @Test
  void testFromJson6() {
    // Arrange
    COWArrayList<AssessmentRatingParsedItem> parsedItems = mock(COWArrayList.class);

    ArrayList<AssessmentRatingParsedItem> assessmentRatingParsedItemList = new ArrayList<>();
    when(parsedItems.iterator()).thenReturn(assessmentRatingParsedItemList.iterator());

    ImmutableAssessmentRatingParsedResult.Json json = new ImmutableAssessmentRatingParsedResult.Json();
    json.setParsedItems(parsedItems);
    json.setInput(null);
    json.setError(null);

    // Act
    ImmutableAssessmentRatingParsedResult actualFromJsonResult = ImmutableAssessmentRatingParsedResult.fromJson(json);

    // Assert
    verify(parsedItems).iterator();
    assertNull(actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertTrue(actualFromJsonResult.parsedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedResult#fromJson(ImmutableAssessmentRatingParsedResult.Json)}
   */
  @Test
  void testFromJson7() {
    // Arrange
    ArrayList<AssessmentRatingParsedItem> assessmentRatingParsedItemList = new ArrayList<>();
    assessmentRatingParsedItemList.add(new ImmutableAssessmentRatingParsedItem.Json());
    assessmentRatingParsedItemList.add(new ImmutableAssessmentRatingParsedItem.Json());
    COWArrayList<AssessmentRatingParsedItem> parsedItems = mock(COWArrayList.class);
    when(parsedItems.iterator()).thenReturn(assessmentRatingParsedItemList.iterator());

    ImmutableAssessmentRatingParsedResult.Json json = new ImmutableAssessmentRatingParsedResult.Json();
    json.setParsedItems(parsedItems);
    json.setInput(null);
    json.setError(null);

    // Act
    ImmutableAssessmentRatingParsedResult actualFromJsonResult = ImmutableAssessmentRatingParsedResult.fromJson(json);

    // Assert
    verify(parsedItems).iterator();
    assertNull(actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertEquals(assessmentRatingParsedItemList, actualFromJsonResult.parsedItems());
  }

  /**
   * Method under test: {@link ImmutableAssessmentRatingParsedResult.Json#error()}
   */
  @Test
  void testJsonError() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentRatingParsedResult.Json()).error());
  }

  /**
   * Method under test: {@link ImmutableAssessmentRatingParsedResult.Json#input()}
   */
  @Test
  void testJsonInput() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentRatingParsedResult.Json()).input());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAssessmentRatingParsedResult.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAssessmentRatingParsedResult.Json actualJson = new ImmutableAssessmentRatingParsedResult.Json();

    // Assert
    assertNull(actualJson.input);
    assertNull(actualJson.error);
    assertTrue(actualJson.parsedItems.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParsedResult.Json#parsedItems()}
   */
  @Test
  void testJsonParsedItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingParsedResult.Json()).parsedItems());
  }
}
