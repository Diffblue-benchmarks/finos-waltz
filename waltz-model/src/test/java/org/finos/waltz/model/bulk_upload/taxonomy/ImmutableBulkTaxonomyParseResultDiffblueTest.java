package org.finos.waltz.model.bulk_upload.taxonomy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.bulk_upload.taxonomy.BulkTaxonomyParseResult.BulkTaxonomyParseError;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyParseResult.Builder;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyParseResult.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkTaxonomyParseResultDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllParsedItems(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllParsedItems(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllParsedItems(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllParsedItems(Iterable)"})
  void testBuilderAddAllParsedItems_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();

    // Act
    Builder actualAddAllParsedItemsResult = builderResult.addAllParsedItems(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllParsedItemsResult);
  }

  /**
   * Test Builder {@link Builder#addParsedItems(BulkTaxonomyItem)} with {@code element}.
   *
   * <ul>
   *   <li>Then builder build parsedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addParsedItems(BulkTaxonomyItem)}
   */
  @Test
  @DisplayName(
      "Test Builder addParsedItems(BulkTaxonomyItem) with 'element'; then builder build parsedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addParsedItems(BulkTaxonomyItem)"})
  void testBuilderAddParsedItemsWithElement_thenBuilderBuildParsedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyItem.Json element = new ImmutableBulkTaxonomyItem.Json();

    // Act
    Builder actualAddParsedItemsResult = builderResult.addParsedItems(element);

    // Assert
    List<BulkTaxonomyItem> parsedItemsResult = builderResult.build().parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(element, parsedItemsResult.get(0));
    assertSame(builderResult, actualAddParsedItemsResult);
  }

  /**
   * Test Builder {@link Builder#addParsedItems(BulkTaxonomyItem[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then builder build parsedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addParsedItems(BulkTaxonomyItem[])}
   */
  @Test
  @DisplayName(
      "Test Builder addParsedItems(BulkTaxonomyItem[]) with 'elements'; then builder build parsedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addParsedItems(BulkTaxonomyItem[])"})
  void testBuilderAddParsedItemsWithElements_thenBuilderBuildParsedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyItem.Json json = new ImmutableBulkTaxonomyItem.Json();

    // Act
    Builder actualAddParsedItemsResult = builderResult.addParsedItems(json);

    // Assert
    List<BulkTaxonomyItem> parsedItemsResult = builderResult.build().parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(json, parsedItemsResult.get(0));
    assertSame(builderResult, actualAddParsedItemsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#error(BulkTaxonomyParseError)}
   *   <li>{@link Builder#input(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyParseResult Builder.build()",
    "Builder Builder.error(BulkTaxonomyParseError)",
    "Builder Builder.input(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseError error =
        ImmutableBulkTaxonomyParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build();
    ImmutableBulkTaxonomyParseResult actualImmutableBulkTaxonomyParseResult =
        actualBuilderResult.error(error).input("Input").build();

    // Assert
    assertEquals("Input", actualImmutableBulkTaxonomyParseResult.input());
    assertTrue(actualImmutableBulkTaxonomyParseResult.parsedItems().isEmpty());
    assertSame(error, actualImmutableBulkTaxonomyParseResult.error());
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyParseResult)}.
   *
   * <p>Method under test: {@link Builder#from(BulkTaxonomyParseResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyParseResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyParseResult)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();

    Builder builderResult2 = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseResult instance =
        builderResult2
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act and Assert
    ImmutableBulkTaxonomyParseResult actualImmutableBulkTaxonomyParseResult =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableBulkTaxonomyParseResult);
    ImmutableBulkTaxonomyParseResult actualImmutableBulkTaxonomyParseResult2 =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkTaxonomyParseResult2);
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyParseResult)}.
   *
   * <p>Method under test: {@link Builder#from(BulkTaxonomyParseResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyParseResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyParseResult)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();

    Builder builderResult2 = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseResult instance =
        builderResult2
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input(null)
            .build();

    // Act and Assert
    ImmutableBulkTaxonomyParseResult actualImmutableBulkTaxonomyParseResult =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableBulkTaxonomyParseResult);
    ImmutableBulkTaxonomyParseResult actualImmutableBulkTaxonomyParseResult2 =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkTaxonomyParseResult2);
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyParseResult)}.
   *
   * <ul>
   *   <li>Then return build parsedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(BulkTaxonomyParseResult)}
   */
  @Test
  @DisplayName(
      "Test Builder from(BulkTaxonomyParseResult); then return build parsedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyParseResult)"})
  void testBuilderFrom_thenReturnBuildParsedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();

    Builder builderResult2 = ImmutableBulkTaxonomyParseResult.builder();
    builderResult2.addParsedItems(
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build());

    // Act and Assert
    List<BulkTaxonomyItem> parsedItemsResult =
        builderResult
            .from(
                builderResult2
                    .error(
                        ImmutableBulkTaxonomyParseError.builder()
                            .column(1)
                            .line(2)
                            .message("Not all who wander are lost")
                            .build())
                    .input("Input")
                    .build())
            .build()
            .parsedItems();
    assertEquals(1, parsedItemsResult.size());
    BulkTaxonomyItem getResult = parsedItemsResult.get(0);
    assertTrue(getResult instanceof ImmutableBulkTaxonomyItem);
    assertEquals("42", getResult.externalId());
    assertEquals("42", getResult.parentExternalId());
    assertEquals("Name", getResult.name());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertTrue(getResult.concrete());
  }

  /**
   * Test Builder {@link Builder#parsedItems(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#parsedItems(Iterable)}
   */
  @Test
  @DisplayName("Test Builder parsedItems(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parsedItems(Iterable)"})
  void testBuilderParsedItems_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();

    // Act
    Builder actualParsedItemsResult = builderResult.parsedItems(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualParsedItemsResult);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#copyOf(BulkTaxonomyParseResult)}.
   *
   * <ul>
   *   <li>Then error return {@link ImmutableBulkTaxonomyParseError}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseResult#copyOf(BulkTaxonomyParseResult)}
   */
  @Test
  @DisplayName(
      "Test copyOf(BulkTaxonomyParseResult); then error return ImmutableBulkTaxonomyParseError")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyParseResult ImmutableBulkTaxonomyParseResult.copyOf(BulkTaxonomyParseResult)"
  })
  void testCopyOf_thenErrorReturnImmutableBulkTaxonomyParseError() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseResult instance =
        builderResult
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act
    ImmutableBulkTaxonomyParseResult actualCopyOfResult =
        ImmutableBulkTaxonomyParseResult.copyOf(instance);

    // Assert
    BulkTaxonomyParseError errorResult = actualCopyOfResult.error();
    assertTrue(errorResult instanceof ImmutableBulkTaxonomyParseError);
    assertEquals("Input", actualCopyOfResult.input());
    assertEquals("Not all who wander are lost", errorResult.message());
    assertEquals(1, errorResult.column().intValue());
    assertEquals(2, errorResult.line().intValue());
    assertTrue(actualCopyOfResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#equals(Object)}, and {@link
   * ImmutableBulkTaxonomyParseResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyParseResult#equals(Object)}
   *   <li>{@link ImmutableBulkTaxonomyParseResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyParseResult.equals(Object)",
    "int ImmutableBulkTaxonomyParseResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseResult immutableBulkTaxonomyParseResult =
        builderResult
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    Builder builderResult2 = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseResult immutableBulkTaxonomyParseResult2 =
        builderResult2
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act and Assert
    assertEquals(immutableBulkTaxonomyParseResult, immutableBulkTaxonomyParseResult2);
    assertEquals(
        immutableBulkTaxonomyParseResult.hashCode(), immutableBulkTaxonomyParseResult2.hashCode());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#equals(Object)}, and {@link
   * ImmutableBulkTaxonomyParseResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyParseResult#equals(Object)}
   *   <li>{@link ImmutableBulkTaxonomyParseResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyParseResult.equals(Object)",
    "int ImmutableBulkTaxonomyParseResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseResult immutableBulkTaxonomyParseResult =
        builderResult
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act and Assert
    assertEquals(immutableBulkTaxonomyParseResult, immutableBulkTaxonomyParseResult);
    int expectedHashCodeResult = immutableBulkTaxonomyParseResult.hashCode();
    assertEquals(expectedHashCodeResult, immutableBulkTaxonomyParseResult.hashCode());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyParseResult.equals(Object)",
    "int ImmutableBulkTaxonomyParseResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    builderResult.addParsedItems(
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build());
    ImmutableBulkTaxonomyParseResult immutableBulkTaxonomyParseResult =
        builderResult
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    Builder builderResult2 = ImmutableBulkTaxonomyParseResult.builder();

    // Act and Assert
    assertNotEquals(
        immutableBulkTaxonomyParseResult,
        builderResult2
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyParseResult.equals(Object)",
    "int ImmutableBulkTaxonomyParseResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseResult immutableBulkTaxonomyParseResult =
        builderResult
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(0)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    Builder builderResult2 = ImmutableBulkTaxonomyParseResult.builder();

    // Act and Assert
    assertNotEquals(
        immutableBulkTaxonomyParseResult,
        builderResult2
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyParseResult.equals(Object)",
    "int ImmutableBulkTaxonomyParseResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseResult immutableBulkTaxonomyParseResult =
        builderResult
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Not all who wander are lost")
            .build();

    Builder builderResult2 = ImmutableBulkTaxonomyParseResult.builder();

    // Act and Assert
    assertNotEquals(
        immutableBulkTaxonomyParseResult,
        builderResult2
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyParseResult.equals(Object)",
    "int ImmutableBulkTaxonomyParseResult.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyParseResult.equals(Object)",
    "int ImmutableBulkTaxonomyParseResult.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build(),
        "Different type to ImmutableBulkTaxonomyParseResult");
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableBulkTaxonomyItem.Json} (default
   *       constructor).
   *   <li>Then return parsedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add Json (default constructor); then return parsedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyParseResult ImmutableBulkTaxonomyParseResult.fromJson(Json)"
  })
  void testFromJson_givenArrayListAddJson_thenReturnParsedItemsSizeIsOne() {
    // Arrange
    ArrayList<BulkTaxonomyItem> parsedItems = new ArrayList<>();
    ImmutableBulkTaxonomyItem.Json json = new ImmutableBulkTaxonomyItem.Json();
    parsedItems.add(json);

    Json json2 = new Json();
    json2.setParsedItems(parsedItems);
    json2.setInput(null);
    json2.setError(null);

    // Act
    ImmutableBulkTaxonomyParseResult actualFromJsonResult =
        ImmutableBulkTaxonomyParseResult.fromJson(json2);

    // Assert
    List<BulkTaxonomyItem> parsedItemsResult = actualFromJsonResult.parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(json, parsedItemsResult.get(0));
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ImmutableBulkTaxonomyParseError.Json} (default constructor).
   *   <li>When {@link Json} (default constructor) Error is {@link
   *       ImmutableBulkTaxonomyParseError.Json} (default constructor).
   *   <li>Then return error is {@link ImmutableBulkTaxonomyParseError.Json} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given Json (default constructor); when Json (default constructor) Error is Json (default constructor); then return error is Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyParseResult ImmutableBulkTaxonomyParseResult.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonErrorIsJson_thenReturnErrorIsJson() {
    // Arrange
    Json json = new Json();
    json.setParsedItems(null);
    json.setInput(null);
    ImmutableBulkTaxonomyParseError.Json error = new ImmutableBulkTaxonomyParseError.Json();
    json.setError(error);

    // Act
    ImmutableBulkTaxonomyParseResult actualFromJsonResult =
        ImmutableBulkTaxonomyParseResult.fromJson(json);

    // Assert
    assertSame(error, actualFromJsonResult.error());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Input is {@code Json}.
   *   <li>Then return input is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Input is 'Json'; then return input is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyParseResult ImmutableBulkTaxonomyParseResult.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonInputIsJson_thenReturnInputIsJson() {
    // Arrange
    Json json = new Json();
    json.setParsedItems(null);
    json.setInput("Json");
    json.setError(null);

    // Act
    ImmutableBulkTaxonomyParseResult actualFromJsonResult =
        ImmutableBulkTaxonomyParseResult.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertTrue(actualFromJsonResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) ParsedItems is {@code null}.
   *   <li>Then return input is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) ParsedItems is 'null'; then return input is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyParseResult ImmutableBulkTaxonomyParseResult.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonParsedItemsIsNull_thenReturnInputIsNull() {
    // Arrange
    Json json = new Json();
    json.setParsedItems(null);
    json.setInput(null);
    json.setError(null);

    // Act
    ImmutableBulkTaxonomyParseResult actualFromJsonResult =
        ImmutableBulkTaxonomyParseResult.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertTrue(actualFromJsonResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return parsedItems size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseResult#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return parsedItems size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyParseResult ImmutableBulkTaxonomyParseResult.fromJson(Json)"
  })
  void testFromJson_thenReturnParsedItemsSizeIsTwo() {
    // Arrange
    ArrayList<BulkTaxonomyItem> parsedItems = new ArrayList<>();
    parsedItems.add(
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build());
    ImmutableBulkTaxonomyItem.Json json = new ImmutableBulkTaxonomyItem.Json();
    parsedItems.add(json);

    Json json2 = new Json();
    json2.setParsedItems(parsedItems);
    json2.setInput(null);
    json2.setError(null);

    // Act
    ImmutableBulkTaxonomyParseResult actualFromJsonResult =
        ImmutableBulkTaxonomyParseResult.fromJson(json2);

    // Assert
    List<BulkTaxonomyItem> parsedItemsResult = actualFromJsonResult.parsedItems();
    assertEquals(2, parsedItemsResult.size());
    BulkTaxonomyItem getResult = parsedItemsResult.get(0);
    assertTrue(getResult instanceof ImmutableBulkTaxonomyItem);
    assertEquals("42", getResult.externalId());
    assertEquals("42", getResult.parentExternalId());
    assertEquals("Name", getResult.name());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertTrue(getResult.concrete());
    assertSame(json, parsedItemsResult.get(1));
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return input is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseResult#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return input is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyParseResult ImmutableBulkTaxonomyParseResult.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnInputIsNull() {
    // Arrange and Act
    ImmutableBulkTaxonomyParseResult actualFromJsonResult =
        ImmutableBulkTaxonomyParseResult.fromJson(new Json());

    // Assert
    assertNull(actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertTrue(actualFromJsonResult.parsedItems().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyParseResult#toString()}
   *   <li>{@link ImmutableBulkTaxonomyParseResult#error()}
   *   <li>{@link ImmutableBulkTaxonomyParseResult#input()}
   *   <li>{@link ImmutableBulkTaxonomyParseResult#parsedItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkTaxonomyParseError ImmutableBulkTaxonomyParseResult.error()",
    "String ImmutableBulkTaxonomyParseResult.input()",
    "List ImmutableBulkTaxonomyParseResult.parsedItems()",
    "String ImmutableBulkTaxonomyParseResult.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseResult immutableBulkTaxonomyParseResult =
        builderResult
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act
    String actualToStringResult = immutableBulkTaxonomyParseResult.toString();
    BulkTaxonomyParseError actualErrorResult = immutableBulkTaxonomyParseResult.error();
    String actualInputResult = immutableBulkTaxonomyParseResult.input();

    // Assert
    assertTrue(actualErrorResult instanceof ImmutableBulkTaxonomyParseError);
    assertEquals(
        "BulkTaxonomyParseResult{parsedItems=[], input=Input, error=BulkTaxonomyParseError{message=Not all who"
            + " wander are lost, line=2, column=1}}",
        actualToStringResult);
    assertEquals("Input", actualInputResult);
    assertTrue(immutableBulkTaxonomyParseResult.parsedItems().isEmpty());
  }

  /**
   * Test Json {@link Json#error()}.
   *
   * <p>Method under test: {@link Json#error()}
   */
  @Test
  @DisplayName("Test Json error()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BulkTaxonomyParseError Json.error()"})
  void testJsonError() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().error());
  }

  /**
   * Test Json {@link Json#input()}.
   *
   * <p>Method under test: {@link Json#input()}
   */
  @Test
  @DisplayName("Test Json input()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.input()"})
  void testJsonInput() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().input());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#parsedItems()}
   */
  @Test
  @DisplayName("Test Json parsedItems()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.parsedItems()"})
  void testJsonParsedItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parsedItems());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#withError(BulkTaxonomyParseError)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkTaxonomyParseResult#withError(BulkTaxonomyParseError)}
   */
  @Test
  @DisplayName("Test withError(BulkTaxonomyParseError)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyParseResult ImmutableBulkTaxonomyParseResult.withError(BulkTaxonomyParseError)"
  })
  void testWithError() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseResult immutableBulkTaxonomyParseResult =
        builderResult
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act
    ImmutableBulkTaxonomyParseResult actualWithErrorResult =
        immutableBulkTaxonomyParseResult.withError(
            ImmutableBulkTaxonomyParseError.builder()
                .column(1)
                .line(2)
                .message("Not all who wander are lost")
                .build());

    // Assert
    assertEquals(immutableBulkTaxonomyParseResult, actualWithErrorResult);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#withInput(String)}.
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseResult#withInput(String)}
   */
  @Test
  @DisplayName("Test withInput(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyParseResult ImmutableBulkTaxonomyParseResult.withInput(String)"
  })
  void testWithInput() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseResult immutableBulkTaxonomyParseResult =
        builderResult
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("42")
            .build();

    // Act
    ImmutableBulkTaxonomyParseResult actualWithInputResult =
        immutableBulkTaxonomyParseResult.withInput("42");

    // Assert
    assertSame(immutableBulkTaxonomyParseResult, actualWithInputResult);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#withInput(String)}.
   *
   * <ul>
   *   <li>Then error return {@link ImmutableBulkTaxonomyParseError}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseResult#withInput(String)}
   */
  @Test
  @DisplayName("Test withInput(String); then error return ImmutableBulkTaxonomyParseError")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyParseResult ImmutableBulkTaxonomyParseResult.withInput(String)"
  })
  void testWithInput_thenErrorReturnImmutableBulkTaxonomyParseError() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();

    // Act
    ImmutableBulkTaxonomyParseResult actualWithInputResult =
        builderResult
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build()
            .withInput("42");

    // Assert
    BulkTaxonomyParseError errorResult = actualWithInputResult.error();
    assertTrue(errorResult instanceof ImmutableBulkTaxonomyParseError);
    assertEquals("42", actualWithInputResult.input());
    assertEquals("Not all who wander are lost", errorResult.message());
    assertEquals(1, errorResult.column().intValue());
    assertEquals(2, errorResult.line().intValue());
    assertTrue(actualWithInputResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseResult#withParsedItems(BulkTaxonomyItem[])} with {@code
   * BulkTaxonomyItem[]}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkTaxonomyParseResult#withParsedItems(BulkTaxonomyItem[])}
   */
  @Test
  @DisplayName("Test withParsedItems(BulkTaxonomyItem[]) with 'BulkTaxonomyItem[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyParseResult ImmutableBulkTaxonomyParseResult.withParsedItems(BulkTaxonomyItem[])"
  })
  void testWithParsedItemsWithBulkTaxonomyItem() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseResult.builder();
    ImmutableBulkTaxonomyParseResult immutableBulkTaxonomyParseResult =
        builderResult
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act
    ImmutableBulkTaxonomyParseResult actualWithParsedItemsResult =
        immutableBulkTaxonomyParseResult.withParsedItems(
            ImmutableBulkTaxonomyItem.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .name("Name")
                .parentExternalId("42")
                .build());

    // Assert
    List<BulkTaxonomyItem> parsedItemsResult = actualWithParsedItemsResult.parsedItems();
    assertEquals(1, parsedItemsResult.size());
    BulkTaxonomyItem getResult = parsedItemsResult.get(0);
    assertTrue(getResult instanceof ImmutableBulkTaxonomyItem);
    BulkTaxonomyParseError errorResult = actualWithParsedItemsResult.error();
    assertTrue(errorResult instanceof ImmutableBulkTaxonomyParseError);
    assertEquals("42", getResult.externalId());
    assertEquals("42", getResult.parentExternalId());
    assertEquals("Input", actualWithParsedItemsResult.input());
    assertEquals("Name", getResult.name());
    assertEquals("Not all who wander are lost", errorResult.message());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(1, errorResult.column().intValue());
    assertEquals(2, errorResult.line().intValue());
    assertTrue(getResult.concrete());
  }
}
