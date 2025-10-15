package org.finos.waltz.model.bulk_upload.entity_relationship;

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
import org.finos.waltz.model.bulk_upload.entity_relationship.BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipParsedResult.Builder;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipParsedResult.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkUploadRelationshipParsedResultDiffblueTest {
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
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();

    // Act
    Builder actualAddAllParsedItemsResult = builderResult.addAllParsedItems(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllParsedItemsResult);
  }

  /**
   * Test Builder {@link Builder#addParsedItems(BulkUploadRelationshipItem)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableBulkUploadRelationshipItem.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addParsedItems(BulkUploadRelationshipItem)}
   */
  @Test
  @DisplayName(
      "Test Builder addParsedItems(BulkUploadRelationshipItem) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addParsedItems(BulkUploadRelationshipItem)"})
  void testBuilderAddParsedItemsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();

    // Act
    Builder actualAddParsedItemsResult =
        builderResult.addParsedItems(new ImmutableBulkUploadRelationshipItem.Json());

    // Assert
    assertSame(builderResult, actualAddParsedItemsResult);
  }

  /**
   * Test Builder {@link Builder#addParsedItems(BulkUploadRelationshipItem[])} with {@code
   * elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableBulkUploadRelationshipItem.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addParsedItems(BulkUploadRelationshipItem[])}
   */
  @Test
  @DisplayName(
      "Test Builder addParsedItems(BulkUploadRelationshipItem[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addParsedItems(BulkUploadRelationshipItem[])"})
  void testBuilderAddParsedItemsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();

    // Act
    Builder actualAddParsedItemsResult =
        builderResult.addParsedItems(new ImmutableBulkUploadRelationshipItem.Json());

    // Assert
    assertSame(builderResult, actualAddParsedItemsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#error(BulkUploadRelationshipParseError)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipParsedResult Builder.build()",
    "Builder Builder.error(BulkUploadRelationshipParseError)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableBulkUploadRelationshipParsedResult.builder();
    ImmutableBulkUploadRelationshipParseError error =
        ImmutableBulkUploadRelationshipParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build();
    ImmutableBulkUploadRelationshipParsedResult actualImmutableBulkUploadRelationshipParsedResult =
        actualBuilderResult.error(error).input("Input").build();

    // Assert
    assertEquals("Input", actualImmutableBulkUploadRelationshipParsedResult.input());
    assertTrue(actualImmutableBulkUploadRelationshipParsedResult.parsedItems().isEmpty());
    assertSame(error, actualImmutableBulkUploadRelationshipParsedResult.error());
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipParsedResult)}.
   *
   * <p>Method under test: {@link Builder#from(BulkUploadRelationshipParsedResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipParsedResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipParsedResult)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();

    Builder builderResult2 = ImmutableBulkUploadRelationshipParsedResult.builder();
    ImmutableBulkUploadRelationshipParsedResult instance =
        builderResult2
            .error(
                ImmutableBulkUploadRelationshipParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkUploadRelationshipParsedResult actualImmutableBulkUploadRelationshipParsedResult =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkUploadRelationshipParsedResult);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipParsedResult)}.
   *
   * <ul>
   *   <li>Then return build parsedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(BulkUploadRelationshipParsedResult)}
   */
  @Test
  @DisplayName(
      "Test Builder from(BulkUploadRelationshipParsedResult); then return build parsedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipParsedResult)"})
  void testBuilderFrom_thenReturnBuildParsedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();

    Builder builderResult2 = ImmutableBulkUploadRelationshipParsedResult.builder();
    builderResult2.addParsedItems(
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("42")
            .targetExternalId("42")
            .build());

    // Act and Assert
    List<BulkUploadRelationshipItem> parsedItemsResult =
        builderResult
            .from(
                builderResult2
                    .error(
                        ImmutableBulkUploadRelationshipParseError.builder()
                            .column(1)
                            .line(2)
                            .message("Not all who wander are lost")
                            .build())
                    .input("Input")
                    .build())
            .build()
            .parsedItems();
    assertEquals(1, parsedItemsResult.size());
    BulkUploadRelationshipItem getResult = parsedItemsResult.get(0);
    assertTrue(getResult instanceof ImmutableBulkUploadRelationshipItem);
    assertEquals("42", getResult.sourceExternalId());
    assertEquals("42", getResult.targetExternalId());
    assertEquals("The characteristics of someone or something", getResult.description());
  }

  /**
   * Test Builder {@link Builder#input(String)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then builder build input is {@code Input}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#input(String)}
   */
  @Test
  @DisplayName("Test Builder input(String); when 'Input'; then builder build input is 'Input'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.input(String)"})
  void testBuilderInput_whenInput_thenBuilderBuildInputIsInput() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();

    // Act
    Builder actualInputResult = builderResult.input("Input");

    // Assert
    ImmutableBulkUploadRelationshipParsedResult immutableBulkUploadRelationshipParsedResult =
        builderResult.build();
    assertEquals("Input", immutableBulkUploadRelationshipParsedResult.input());
    assertNull(immutableBulkUploadRelationshipParsedResult.error());
    assertSame(builderResult, actualInputResult);
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
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();

    // Act
    Builder actualParsedItemsResult = builderResult.parsedItems(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualParsedItemsResult);
  }

  /**
   * Test {@link
   * ImmutableBulkUploadRelationshipParsedResult#copyOf(BulkUploadRelationshipParsedResult)}.
   *
   * <ul>
   *   <li>Then error return {@link ImmutableBulkUploadRelationshipParseError}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadRelationshipParsedResult#copyOf(BulkUploadRelationshipParsedResult)}
   */
  @Test
  @DisplayName(
      "Test copyOf(BulkUploadRelationshipParsedResult); then error return ImmutableBulkUploadRelationshipParseError")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipParsedResult ImmutableBulkUploadRelationshipParsedResult.copyOf(BulkUploadRelationshipParsedResult)"
  })
  void testCopyOf_thenErrorReturnImmutableBulkUploadRelationshipParseError() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();
    ImmutableBulkUploadRelationshipParsedResult instance =
        builderResult
            .error(
                ImmutableBulkUploadRelationshipParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act
    ImmutableBulkUploadRelationshipParsedResult actualCopyOfResult =
        ImmutableBulkUploadRelationshipParsedResult.copyOf(instance);

    // Assert
    BulkUploadRelationshipParseError errorResult = actualCopyOfResult.error();
    assertTrue(errorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertEquals("Input", actualCopyOfResult.input());
    assertEquals("Not all who wander are lost", errorResult.message());
    assertEquals(1, errorResult.column().intValue());
    assertEquals(2, errorResult.line().intValue());
    assertTrue(actualCopyOfResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParsedResult#equals(Object)}, and {@link
   * ImmutableBulkUploadRelationshipParsedResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipParsedResult#equals(Object)}
   *   <li>{@link ImmutableBulkUploadRelationshipParsedResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipParsedResult.equals(Object)",
    "int ImmutableBulkUploadRelationshipParsedResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();
    ImmutableBulkUploadRelationshipParsedResult immutableBulkUploadRelationshipParsedResult =
        builderResult
            .error(
                ImmutableBulkUploadRelationshipParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    Builder builderResult2 = ImmutableBulkUploadRelationshipParsedResult.builder();
    ImmutableBulkUploadRelationshipParsedResult immutableBulkUploadRelationshipParsedResult2 =
        builderResult2
            .error(
                ImmutableBulkUploadRelationshipParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act and Assert
    assertEquals(
        immutableBulkUploadRelationshipParsedResult, immutableBulkUploadRelationshipParsedResult2);
    assertEquals(
        immutableBulkUploadRelationshipParsedResult.hashCode(),
        immutableBulkUploadRelationshipParsedResult2.hashCode());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParsedResult#equals(Object)}, and {@link
   * ImmutableBulkUploadRelationshipParsedResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipParsedResult#equals(Object)}
   *   <li>{@link ImmutableBulkUploadRelationshipParsedResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipParsedResult.equals(Object)",
    "int ImmutableBulkUploadRelationshipParsedResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();
    ImmutableBulkUploadRelationshipParsedResult immutableBulkUploadRelationshipParsedResult =
        builderResult
            .error(
                ImmutableBulkUploadRelationshipParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act and Assert
    assertEquals(
        immutableBulkUploadRelationshipParsedResult, immutableBulkUploadRelationshipParsedResult);
    int expectedHashCodeResult = immutableBulkUploadRelationshipParsedResult.hashCode();
    assertEquals(expectedHashCodeResult, immutableBulkUploadRelationshipParsedResult.hashCode());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParsedResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParsedResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipParsedResult.equals(Object)",
    "int ImmutableBulkUploadRelationshipParsedResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();
    builderResult.addParsedItems(
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("42")
            .targetExternalId("42")
            .build());
    ImmutableBulkUploadRelationshipParsedResult immutableBulkUploadRelationshipParsedResult =
        builderResult
            .error(
                ImmutableBulkUploadRelationshipParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    Builder builderResult2 = ImmutableBulkUploadRelationshipParsedResult.builder();

    // Act and Assert
    assertNotEquals(
        immutableBulkUploadRelationshipParsedResult,
        builderResult2
            .error(
                ImmutableBulkUploadRelationshipParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParsedResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParsedResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipParsedResult.equals(Object)",
    "int ImmutableBulkUploadRelationshipParsedResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();
    ImmutableBulkUploadRelationshipParsedResult immutableBulkUploadRelationshipParsedResult =
        builderResult
            .error(
                ImmutableBulkUploadRelationshipParseError.builder()
                    .column(0)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    Builder builderResult2 = ImmutableBulkUploadRelationshipParsedResult.builder();

    // Act and Assert
    assertNotEquals(
        immutableBulkUploadRelationshipParsedResult,
        builderResult2
            .error(
                ImmutableBulkUploadRelationshipParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParsedResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParsedResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipParsedResult.equals(Object)",
    "int ImmutableBulkUploadRelationshipParsedResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();
    ImmutableBulkUploadRelationshipParsedResult immutableBulkUploadRelationshipParsedResult =
        builderResult
            .error(
                ImmutableBulkUploadRelationshipParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Not all who wander are lost")
            .build();

    Builder builderResult2 = ImmutableBulkUploadRelationshipParsedResult.builder();

    // Act and Assert
    assertNotEquals(
        immutableBulkUploadRelationshipParsedResult,
        builderResult2
            .error(
                ImmutableBulkUploadRelationshipParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParsedResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParsedResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipParsedResult.equals(Object)",
    "int ImmutableBulkUploadRelationshipParsedResult.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .error(
                ImmutableBulkUploadRelationshipParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParsedResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParsedResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipParsedResult.equals(Object)",
    "int ImmutableBulkUploadRelationshipParsedResult.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .error(
                ImmutableBulkUploadRelationshipParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build(),
        "Different type to ImmutableBulkUploadRelationshipParsedResult");
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParsedResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableBulkUploadRelationshipItem.Json}
   *       (default constructor).
   *   <li>Then return parsedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParsedResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add Json (default constructor); then return parsedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipParsedResult ImmutableBulkUploadRelationshipParsedResult.fromJson(Json)"
  })
  void testFromJson_givenArrayListAddJson_thenReturnParsedItemsSizeIsOne() {
    // Arrange
    ArrayList<BulkUploadRelationshipItem> parsedItems = new ArrayList<>();
    ImmutableBulkUploadRelationshipItem.Json json = new ImmutableBulkUploadRelationshipItem.Json();
    parsedItems.add(json);

    Json json2 = new Json();
    json2.setInput("Json");
    json2.setParsedItems(parsedItems);
    json2.setError(null);

    // Act
    ImmutableBulkUploadRelationshipParsedResult actualFromJsonResult =
        ImmutableBulkUploadRelationshipParsedResult.fromJson(json2);

    // Assert
    List<BulkUploadRelationshipItem> parsedItemsResult = actualFromJsonResult.parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(json, parsedItemsResult.get(0));
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParsedResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link Json} (default constructor) ParsedItems is {@link ArrayList#ArrayList()}.
   *   <li>Then return input is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParsedResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList(); when Json (default constructor) ParsedItems is ArrayList(); then return input is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipParsedResult ImmutableBulkUploadRelationshipParsedResult.fromJson(Json)"
  })
  void testFromJson_givenArrayList_whenJsonParsedItemsIsArrayList_thenReturnInputIsJson() {
    // Arrange
    Json json = new Json();
    json.setInput("Json");
    json.setParsedItems(new ArrayList<>());
    json.setError(null);

    // Act
    ImmutableBulkUploadRelationshipParsedResult actualFromJsonResult =
        ImmutableBulkUploadRelationshipParsedResult.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertTrue(actualFromJsonResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParsedResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ImmutableBulkUploadRelationshipParseError.Json} (default constructor).
   *   <li>When {@link Json} (default constructor) Error is {@link
   *       ImmutableBulkUploadRelationshipParseError.Json} (default constructor).
   *   <li>Then return error is {@link ImmutableBulkUploadRelationshipParseError.Json} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParsedResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given Json (default constructor); when Json (default constructor) Error is Json (default constructor); then return error is Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipParsedResult ImmutableBulkUploadRelationshipParsedResult.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonErrorIsJson_thenReturnErrorIsJson() {
    // Arrange
    Json json = new Json();
    json.setInput("Json");
    json.setParsedItems(null);
    ImmutableBulkUploadRelationshipParseError.Json error =
        new ImmutableBulkUploadRelationshipParseError.Json();
    json.setError(error);

    // Act
    ImmutableBulkUploadRelationshipParsedResult actualFromJsonResult =
        ImmutableBulkUploadRelationshipParsedResult.fromJson(json);

    // Assert
    assertSame(error, actualFromJsonResult.error());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParsedResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) ParsedItems is {@code null}.
   *   <li>Then return input is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParsedResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) ParsedItems is 'null'; then return input is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipParsedResult ImmutableBulkUploadRelationshipParsedResult.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonParsedItemsIsNull_thenReturnInputIsJson() {
    // Arrange
    Json json = new Json();
    json.setInput("Json");
    json.setParsedItems(null);
    json.setError(null);

    // Act
    ImmutableBulkUploadRelationshipParsedResult actualFromJsonResult =
        ImmutableBulkUploadRelationshipParsedResult.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertTrue(actualFromJsonResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParsedResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return parsedItems size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParsedResult#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return parsedItems size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipParsedResult ImmutableBulkUploadRelationshipParsedResult.fromJson(Json)"
  })
  void testFromJson_thenReturnParsedItemsSizeIsTwo() {
    // Arrange
    ArrayList<BulkUploadRelationshipItem> parsedItems = new ArrayList<>();
    parsedItems.add(
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("42")
            .targetExternalId("42")
            .build());
    ImmutableBulkUploadRelationshipItem.Json json = new ImmutableBulkUploadRelationshipItem.Json();
    parsedItems.add(json);

    Json json2 = new Json();
    json2.setInput("Json");
    json2.setParsedItems(parsedItems);
    json2.setError(null);

    // Act
    ImmutableBulkUploadRelationshipParsedResult actualFromJsonResult =
        ImmutableBulkUploadRelationshipParsedResult.fromJson(json2);

    // Assert
    List<BulkUploadRelationshipItem> parsedItemsResult = actualFromJsonResult.parsedItems();
    assertEquals(2, parsedItemsResult.size());
    BulkUploadRelationshipItem getResult = parsedItemsResult.get(0);
    assertTrue(getResult instanceof ImmutableBulkUploadRelationshipItem);
    assertEquals("42", getResult.sourceExternalId());
    assertEquals("42", getResult.targetExternalId());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertSame(json, parsedItemsResult.get(1));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipParsedResult#toString()}
   *   <li>{@link ImmutableBulkUploadRelationshipParsedResult#error()}
   *   <li>{@link ImmutableBulkUploadRelationshipParsedResult#input()}
   *   <li>{@link ImmutableBulkUploadRelationshipParsedResult#parsedItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkUploadRelationshipParseError ImmutableBulkUploadRelationshipParsedResult.error()",
    "String ImmutableBulkUploadRelationshipParsedResult.input()",
    "List ImmutableBulkUploadRelationshipParsedResult.parsedItems()",
    "String ImmutableBulkUploadRelationshipParsedResult.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();
    ImmutableBulkUploadRelationshipParsedResult immutableBulkUploadRelationshipParsedResult =
        builderResult
            .error(
                ImmutableBulkUploadRelationshipParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act
    String actualToStringResult = immutableBulkUploadRelationshipParsedResult.toString();
    BulkUploadRelationshipParseError actualErrorResult =
        immutableBulkUploadRelationshipParsedResult.error();
    String actualInputResult = immutableBulkUploadRelationshipParsedResult.input();

    // Assert
    assertTrue(actualErrorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertEquals(
        "BulkUploadRelationshipParsedResult{input=Input, parsedItems=[], error=BulkUploadRelationshipParseError"
            + "{message=Not all who wander are lost, line=2, column=1}}",
        actualToStringResult);
    assertEquals("Input", actualInputResult);
    assertTrue(immutableBulkUploadRelationshipParsedResult.parsedItems().isEmpty());
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
  @MethodsUnderTest({"BulkUploadRelationshipParseError Json.error()"})
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
   * Test {@link
   * ImmutableBulkUploadRelationshipParsedResult#withError(BulkUploadRelationshipParseError)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadRelationshipParsedResult#withError(BulkUploadRelationshipParseError)}
   */
  @Test
  @DisplayName("Test withError(BulkUploadRelationshipParseError)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipParsedResult ImmutableBulkUploadRelationshipParsedResult.withError(BulkUploadRelationshipParseError)"
  })
  void testWithError() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();
    ImmutableBulkUploadRelationshipParsedResult immutableBulkUploadRelationshipParsedResult =
        builderResult
            .error(
                ImmutableBulkUploadRelationshipParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act
    ImmutableBulkUploadRelationshipParsedResult actualWithErrorResult =
        immutableBulkUploadRelationshipParsedResult.withError(
            ImmutableBulkUploadRelationshipParseError.builder()
                .column(1)
                .line(2)
                .message("Not all who wander are lost")
                .build());

    // Assert
    assertEquals(immutableBulkUploadRelationshipParsedResult, actualWithErrorResult);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParsedResult#withInput(String)}.
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParsedResult#withInput(String)}
   */
  @Test
  @DisplayName("Test withInput(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipParsedResult ImmutableBulkUploadRelationshipParsedResult.withInput(String)"
  })
  void testWithInput() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();
    ImmutableBulkUploadRelationshipParsedResult immutableBulkUploadRelationshipParsedResult =
        builderResult
            .error(
                ImmutableBulkUploadRelationshipParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("42")
            .build();

    // Act
    ImmutableBulkUploadRelationshipParsedResult actualWithInputResult =
        immutableBulkUploadRelationshipParsedResult.withInput("42");

    // Assert
    assertSame(immutableBulkUploadRelationshipParsedResult, actualWithInputResult);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParsedResult#withInput(String)}.
   *
   * <ul>
   *   <li>Then error return {@link ImmutableBulkUploadRelationshipParseError}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParsedResult#withInput(String)}
   */
  @Test
  @DisplayName(
      "Test withInput(String); then error return ImmutableBulkUploadRelationshipParseError")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipParsedResult ImmutableBulkUploadRelationshipParsedResult.withInput(String)"
  })
  void testWithInput_thenErrorReturnImmutableBulkUploadRelationshipParseError() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();

    // Act
    ImmutableBulkUploadRelationshipParsedResult actualWithInputResult =
        builderResult
            .error(
                ImmutableBulkUploadRelationshipParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build()
            .withInput("42");

    // Assert
    BulkUploadRelationshipParseError errorResult = actualWithInputResult.error();
    assertTrue(errorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertEquals("42", actualWithInputResult.input());
    assertEquals("Not all who wander are lost", errorResult.message());
    assertEquals(1, errorResult.column().intValue());
    assertEquals(2, errorResult.line().intValue());
    assertTrue(actualWithInputResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link
   * ImmutableBulkUploadRelationshipParsedResult#withParsedItems(BulkUploadRelationshipItem[])} with
   * {@code BulkUploadRelationshipItem[]}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadRelationshipParsedResult#withParsedItems(BulkUploadRelationshipItem[])}
   */
  @Test
  @DisplayName(
      "Test withParsedItems(BulkUploadRelationshipItem[]) with 'BulkUploadRelationshipItem[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipParsedResult ImmutableBulkUploadRelationshipParsedResult.withParsedItems(BulkUploadRelationshipItem[])"
  })
  void testWithParsedItemsWithBulkUploadRelationshipItem() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParsedResult.builder();
    ImmutableBulkUploadRelationshipParsedResult immutableBulkUploadRelationshipParsedResult =
        builderResult
            .error(
                ImmutableBulkUploadRelationshipParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act
    ImmutableBulkUploadRelationshipParsedResult actualWithParsedItemsResult =
        immutableBulkUploadRelationshipParsedResult.withParsedItems(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    // Assert
    List<BulkUploadRelationshipItem> parsedItemsResult = actualWithParsedItemsResult.parsedItems();
    assertEquals(1, parsedItemsResult.size());
    BulkUploadRelationshipItem getResult = parsedItemsResult.get(0);
    assertTrue(getResult instanceof ImmutableBulkUploadRelationshipItem);
    BulkUploadRelationshipParseError errorResult = actualWithParsedItemsResult.error();
    assertTrue(errorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertEquals("42", getResult.sourceExternalId());
    assertEquals("42", getResult.targetExternalId());
    assertEquals("Input", actualWithParsedItemsResult.input());
    assertEquals("Not all who wander are lost", errorResult.message());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(1, errorResult.column().intValue());
    assertEquals(2, errorResult.line().intValue());
  }
}
