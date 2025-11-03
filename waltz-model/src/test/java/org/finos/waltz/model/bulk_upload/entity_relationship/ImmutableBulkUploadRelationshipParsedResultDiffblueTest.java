package org.finos.waltz.model.bulk_upload.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.bulk_upload.entity_relationship.BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipParsedResult.Builder;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipParsedResult.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkUploadRelationshipParsedResultDiffblueTest {
  /**
   * Test {@link ImmutableBulkUploadRelationshipParsedResult#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipParsedResult#builder()}
   *   <li>{@link ImmutableBulkUploadRelationshipParsedResult#error(BulkUploadRelationshipParseError)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkUploadRelationshipParsedResult Builder.build()",
      "Builder Builder.error(BulkUploadRelationshipParseError)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableBulkUploadRelationshipParsedResult.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.error(new ImmutableBulkUploadRelationshipParseError.Json()));
  }

  /**
   * Test Builder {@link Builder#addAllParsedItems(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllParsedItems(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllParsedItems(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllParsedItems(Iterable)"})
  void testBuilderAddAllParsedItems_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllParsedItems(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addParsedItems(BulkUploadRelationshipItem)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableBulkUploadRelationshipItem.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addParsedItems(BulkUploadRelationshipItem)}
   */
  @Test
  @DisplayName("Test Builder addParsedItems(BulkUploadRelationshipItem) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addParsedItems(BulkUploadRelationshipItem)"})
  void testBuilderAddParsedItemsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addParsedItems(new ImmutableBulkUploadRelationshipItem.Json()));
  }

  /**
   * Test Builder {@link Builder#addParsedItems(BulkUploadRelationshipItem[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableBulkUploadRelationshipItem.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addParsedItems(BulkUploadRelationshipItem[])}
   */
  @Test
  @DisplayName("Test Builder addParsedItems(BulkUploadRelationshipItem[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addParsedItems(BulkUploadRelationshipItem[])"})
  void testBuilderAddParsedItemsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addParsedItems(new ImmutableBulkUploadRelationshipItem.Json()));
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipParsedResult)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableBulkUploadRelationshipItem.Json} (default constructor).</li>
   *   <li>Then builder build parsedItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkUploadRelationshipParsedResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipParsedResult); given ArrayList() add Json (default constructor); then builder build parsedItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipParsedResult)"})
  void testBuilderFrom_givenArrayListAddJson_thenBuilderBuildParsedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();

    ArrayList<BulkUploadRelationshipItem> bulkUploadRelationshipItemList = new ArrayList<>();
    ImmutableBulkUploadRelationshipItem.Json json = new ImmutableBulkUploadRelationshipItem.Json();
    bulkUploadRelationshipItemList.add(json);
    BulkUploadRelationshipParsedResult instance = mock(BulkUploadRelationshipParsedResult.class);
    when(instance.parsedItems()).thenReturn(bulkUploadRelationshipItemList);
    when(instance.error()).thenReturn(new ImmutableBulkUploadRelationshipParseError.Json());
    when(instance.input()).thenReturn("Input");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    List<BulkUploadRelationshipItem> parsedItemsResult = builderResult.build().parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertEquals(bulkUploadRelationshipItemList, actualFromResult.build().parsedItems());
    assertSame(json, parsedItemsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipParsedResult)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return build error is {@link ImmutableBulkUploadRelationshipParseError.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkUploadRelationshipParsedResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipParsedResult); given ArrayList(); then return build error is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipParsedResult)"})
  void testBuilderFrom_givenArrayList_thenReturnBuildErrorIsJson() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();
    BulkUploadRelationshipParsedResult instance = mock(BulkUploadRelationshipParsedResult.class);
    when(instance.parsedItems()).thenReturn(new ArrayList<>());
    ImmutableBulkUploadRelationshipParseError.Json json = new ImmutableBulkUploadRelationshipParseError.Json();
    when(instance.error()).thenReturn(json);
    when(instance.input()).thenReturn("Input");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).error();
    verify(instance).input();
    verify(instance).parsedItems();
    assertSame(json, actualFromResult.build().error());
    assertSame(json, builderResult.build().error());
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipParsedResult)}.
   * <ul>
   *   <li>Then builder build input is {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkUploadRelationshipParsedResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipParsedResult); then builder build input is 'Input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipParsedResult)"})
  void testBuilderFrom_thenBuilderBuildInputIsInput() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();
    BulkUploadRelationshipParsedResult instance = mock(BulkUploadRelationshipParsedResult.class);
    when(instance.parsedItems()).thenReturn(new ArrayList<>());
    when(instance.error()).thenReturn(null);
    when(instance.input()).thenReturn("Input");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(BulkUploadRelationshipParsedResult)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkUploadRelationshipParsedResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipParsedResult); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipParsedResult)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();
    BulkUploadRelationshipParsedResult instance = mock(BulkUploadRelationshipParsedResult.class);
    when(instance.parsedItems()).thenThrow(new IllegalStateException("instance"));
    when(instance.input()).thenReturn("Input");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).input();
    verify(instance).parsedItems();
  }

  /**
   * Test Builder {@link Builder#input(String)}.
   * <p>
   * Method under test: {@link Builder#input(String)}
   */
  @Test
  @DisplayName("Test Builder input(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.input(String)"})
  void testBuilderInput() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();

    // Act
    Builder actualInputResult = builderResult.input("Input");

    // Assert
    ImmutableBulkUploadRelationshipParsedResult buildResult = builderResult.build();
    assertEquals("Input", buildResult.input());
    assertNull(buildResult.error());
    assertSame(builderResult, actualInputResult);
  }

  /**
   * Test Builder {@link Builder#parsedItems(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#parsedItems(Iterable)}
   */
  @Test
  @DisplayName("Test Builder parsedItems(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parsedItems(Iterable)"})
  void testBuilderParsedItems_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parsedItems(new ArrayList<>()));
  }

  /**
   * Test Json {@link Json#error()}.
   * <p>
   * Method under test: {@link Json#error()}
   */
  @Test
  @DisplayName("Test Json error()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkUploadRelationshipParseError Json.error()"})
  void testJsonError() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).error());
  }

  /**
   * Test Json {@link Json#input()}.
   * <p>
   * Method under test: {@link Json#input()}
   */
  @Test
  @DisplayName("Test Json input()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.input()"})
  void testJsonInput() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).input());
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
    assertNull(actualJson.input);
    assertNull(actualJson.error);
    assertTrue(actualJson.parsedItems.isEmpty());
  }

  /**
   * Test Json {@link Json#parsedItems()}.
   * <p>
   * Method under test: {@link Json#parsedItems()}
   */
  @Test
  @DisplayName("Test Json parsedItems()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.parsedItems()"})
  void testJsonParsedItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).parsedItems());
  }
}
