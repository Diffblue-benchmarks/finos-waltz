package org.finos.waltz.model.assessment_rating.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.assessment_rating.bulk_upload.AssessmentRatingParsedResult.AssessmentRatingParseError;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmentRatingParsedResult.Builder;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmentRatingParsedResult.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingParsedResultDiffblueTest {
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
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();

    // Act
    Builder actualAddAllParsedItemsResult = builderResult.addAllParsedItems(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllParsedItemsResult);
  }

  /**
   * Test Builder {@link Builder#addParsedItems(AssessmentRatingParsedItem)} with {@code element}.
   *
   * <ul>
   *   <li>Then builder build parsedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addParsedItems(AssessmentRatingParsedItem)}
   */
  @Test
  @DisplayName(
      "Test Builder addParsedItems(AssessmentRatingParsedItem) with 'element'; then builder build parsedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addParsedItems(AssessmentRatingParsedItem)"})
  void testBuilderAddParsedItemsWithElement_thenBuilderBuildParsedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedItem.Json element =
        new ImmutableAssessmentRatingParsedItem.Json();

    // Act
    Builder actualAddParsedItemsResult = builderResult.addParsedItems(element);

    // Assert
    List<AssessmentRatingParsedItem> parsedItemsResult = builderResult.build().parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(element, parsedItemsResult.get(0));
    assertSame(builderResult, actualAddParsedItemsResult);
  }

  /**
   * Test Builder {@link Builder#addParsedItems(AssessmentRatingParsedItem[])} with {@code
   * elements}.
   *
   * <ul>
   *   <li>Then builder build parsedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addParsedItems(AssessmentRatingParsedItem[])}
   */
  @Test
  @DisplayName(
      "Test Builder addParsedItems(AssessmentRatingParsedItem[]) with 'elements'; then builder build parsedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addParsedItems(AssessmentRatingParsedItem[])"})
  void testBuilderAddParsedItemsWithElements_thenBuilderBuildParsedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedItem.Json json = new ImmutableAssessmentRatingParsedItem.Json();

    // Act
    Builder actualAddParsedItemsResult = builderResult.addParsedItems(json);

    // Assert
    List<AssessmentRatingParsedItem> parsedItemsResult = builderResult.build().parsedItems();
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
   *   <li>{@link Builder#error(AssessmentRatingParseError)}
   *   <li>{@link Builder#input(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingParsedResult Builder.build()",
    "Builder Builder.error(AssessmentRatingParseError)",
    "Builder Builder.input(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParseError error =
        ImmutableAssessmentRatingParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build();
    ImmutableAssessmentRatingParsedResult actualImmutableAssessmentRatingParsedResult =
        actualBuilderResult.error(error).input("Input").build();

    // Assert
    assertEquals("Input", actualImmutableAssessmentRatingParsedResult.input());
    assertTrue(actualImmutableAssessmentRatingParsedResult.parsedItems().isEmpty());
    assertSame(error, actualImmutableAssessmentRatingParsedResult.error());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingParsedResult)}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingParsedResult)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingParsedResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingParsedResult)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();

    Builder builderResult2 = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedResult instance =
        builderResult2
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act and Assert
    ImmutableAssessmentRatingParsedResult actualImmutableAssessmentRatingParsedResult =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableAssessmentRatingParsedResult);
    ImmutableAssessmentRatingParsedResult actualImmutableAssessmentRatingParsedResult2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRatingParsedResult2);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingParsedResult)}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingParsedResult)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingParsedResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingParsedResult)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();

    Builder builderResult2 = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedResult instance =
        builderResult2
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input(null)
            .build();

    // Act and Assert
    ImmutableAssessmentRatingParsedResult actualImmutableAssessmentRatingParsedResult =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableAssessmentRatingParsedResult);
    ImmutableAssessmentRatingParsedResult actualImmutableAssessmentRatingParsedResult2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRatingParsedResult2);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingParsedResult)}.
   *
   * <ul>
   *   <li>Then return build parsedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingParsedResult)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AssessmentRatingParsedResult); then return build parsedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingParsedResult)"})
  void testBuilderFrom_thenReturnBuildParsedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();

    Builder builderResult2 = ImmutableAssessmentRatingParsedResult.builder();
    builderResult2.addParsedItems(
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("Rating Code")
            .build());

    // Act and Assert
    List<AssessmentRatingParsedItem> parsedItemsResult =
        builderResult
            .from(
                builderResult2
                    .error(
                        ImmutableAssessmentRatingParseError.builder()
                            .column(1)
                            .line(2)
                            .message("Not all who wander are lost")
                            .build())
                    .input("Input")
                    .build())
            .build()
            .parsedItems();
    assertEquals(1, parsedItemsResult.size());
    AssessmentRatingParsedItem getResult = parsedItemsResult.get(0);
    assertTrue(getResult instanceof ImmutableAssessmentRatingParsedItem);
    assertEquals("42", getResult.externalId());
    assertEquals("Comment", getResult.comment());
    assertEquals("Rating Code", getResult.ratingCode());
    assertFalse(getResult.isReadOnly());
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
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();

    // Act
    Builder actualParsedItemsResult = builderResult.parsedItems(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualParsedItemsResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#copyOf(AssessmentRatingParsedResult)}.
   *
   * <ul>
   *   <li>Then error return {@link ImmutableAssessmentRatingParseError}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingParsedResult#copyOf(AssessmentRatingParsedResult)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AssessmentRatingParsedResult); then error return ImmutableAssessmentRatingParseError")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingParsedResult ImmutableAssessmentRatingParsedResult.copyOf(AssessmentRatingParsedResult)"
  })
  void testCopyOf_thenErrorReturnImmutableAssessmentRatingParseError() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedResult instance =
        builderResult
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act
    ImmutableAssessmentRatingParsedResult actualCopyOfResult =
        ImmutableAssessmentRatingParsedResult.copyOf(instance);

    // Assert
    AssessmentRatingParseError errorResult = actualCopyOfResult.error();
    assertTrue(errorResult instanceof ImmutableAssessmentRatingParseError);
    assertEquals("Input", actualCopyOfResult.input());
    assertEquals("Not all who wander are lost", errorResult.message());
    assertEquals(1, errorResult.column().intValue());
    assertEquals(2, errorResult.line().intValue());
    assertTrue(actualCopyOfResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#equals(Object)}, and {@link
   * ImmutableAssessmentRatingParsedResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingParsedResult#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingParsedResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingParsedResult.equals(Object)",
    "int ImmutableAssessmentRatingParsedResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedResult immutableAssessmentRatingParsedResult =
        builderResult
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    Builder builderResult2 = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedResult immutableAssessmentRatingParsedResult2 =
        builderResult2
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act and Assert
    assertEquals(immutableAssessmentRatingParsedResult, immutableAssessmentRatingParsedResult2);
    assertEquals(
        immutableAssessmentRatingParsedResult.hashCode(),
        immutableAssessmentRatingParsedResult2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#equals(Object)}, and {@link
   * ImmutableAssessmentRatingParsedResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingParsedResult#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingParsedResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingParsedResult.equals(Object)",
    "int ImmutableAssessmentRatingParsedResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedResult immutableAssessmentRatingParsedResult =
        builderResult
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act and Assert
    assertEquals(immutableAssessmentRatingParsedResult, immutableAssessmentRatingParsedResult);
    int expectedHashCodeResult = immutableAssessmentRatingParsedResult.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssessmentRatingParsedResult.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingParsedResult.equals(Object)",
    "int ImmutableAssessmentRatingParsedResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    builderResult.addParsedItems(
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("Rating Code")
            .build());
    ImmutableAssessmentRatingParsedResult immutableAssessmentRatingParsedResult =
        builderResult
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    Builder builderResult2 = ImmutableAssessmentRatingParsedResult.builder();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingParsedResult,
        builderResult2
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingParsedResult.equals(Object)",
    "int ImmutableAssessmentRatingParsedResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedResult immutableAssessmentRatingParsedResult =
        builderResult
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(0)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    Builder builderResult2 = ImmutableAssessmentRatingParsedResult.builder();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingParsedResult,
        builderResult2
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingParsedResult.equals(Object)",
    "int ImmutableAssessmentRatingParsedResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedResult immutableAssessmentRatingParsedResult =
        builderResult
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Not all who wander are lost")
            .build();

    Builder builderResult2 = ImmutableAssessmentRatingParsedResult.builder();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingParsedResult,
        builderResult2
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingParsedResult.equals(Object)",
    "int ImmutableAssessmentRatingParsedResult.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingParsedResult.equals(Object)",
    "int ImmutableAssessmentRatingParsedResult.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build(),
        "Different type to ImmutableAssessmentRatingParsedResult");
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableAssessmentRatingParsedItem.Json}
   *       (default constructor).
   *   <li>Then return parsedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add Json (default constructor); then return parsedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingParsedResult ImmutableAssessmentRatingParsedResult.fromJson(Json)"
  })
  void testFromJson_givenArrayListAddJson_thenReturnParsedItemsSizeIsOne() {
    // Arrange
    ArrayList<AssessmentRatingParsedItem> parsedItems = new ArrayList<>();
    ImmutableAssessmentRatingParsedItem.Json json = new ImmutableAssessmentRatingParsedItem.Json();
    parsedItems.add(json);

    Json json2 = new Json();
    json2.setParsedItems(parsedItems);
    json2.setInput("Json");
    json2.setError(new ImmutableAssessmentRatingParseError.Json());

    // Act
    ImmutableAssessmentRatingParsedResult actualFromJsonResult =
        ImmutableAssessmentRatingParsedResult.fromJson(json2);

    // Assert
    List<AssessmentRatingParsedItem> parsedItemsResult = actualFromJsonResult.parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(json, parsedItemsResult.get(0));
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) ParsedItems is {@code null}.
   *   <li>Then return input is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) ParsedItems is 'null'; then return input is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingParsedResult ImmutableAssessmentRatingParsedResult.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonParsedItemsIsNull_thenReturnInputIsJson() {
    // Arrange
    Json json = new Json();
    json.setParsedItems(null);
    json.setInput("Json");
    ImmutableAssessmentRatingParseError.Json error = new ImmutableAssessmentRatingParseError.Json();
    json.setError(error);

    // Act
    ImmutableAssessmentRatingParsedResult actualFromJsonResult =
        ImmutableAssessmentRatingParsedResult.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.input());
    assertSame(error, actualFromJsonResult.error());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return parsedItems size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedResult#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return parsedItems size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingParsedResult ImmutableAssessmentRatingParsedResult.fromJson(Json)"
  })
  void testFromJson_thenReturnParsedItemsSizeIsTwo() {
    // Arrange
    ArrayList<AssessmentRatingParsedItem> parsedItems = new ArrayList<>();
    parsedItems.add(
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("Rating Code")
            .build());
    ImmutableAssessmentRatingParsedItem.Json json = new ImmutableAssessmentRatingParsedItem.Json();
    parsedItems.add(json);

    Json json2 = new Json();
    json2.setParsedItems(parsedItems);
    json2.setInput("Json");
    json2.setError(new ImmutableAssessmentRatingParseError.Json());

    // Act
    ImmutableAssessmentRatingParsedResult actualFromJsonResult =
        ImmutableAssessmentRatingParsedResult.fromJson(json2);

    // Assert
    List<AssessmentRatingParsedItem> parsedItemsResult = actualFromJsonResult.parsedItems();
    assertEquals(2, parsedItemsResult.size());
    AssessmentRatingParsedItem getResult = parsedItemsResult.get(0);
    assertTrue(getResult instanceof ImmutableAssessmentRatingParsedItem);
    assertEquals("42", getResult.externalId());
    assertEquals("Comment", getResult.comment());
    assertEquals("Rating Code", getResult.ratingCode());
    assertFalse(getResult.isReadOnly());
    assertSame(json, parsedItemsResult.get(1));
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return input is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedResult#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return input is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingParsedResult ImmutableAssessmentRatingParsedResult.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnInputIsNull() {
    // Arrange and Act
    ImmutableAssessmentRatingParsedResult actualFromJsonResult =
        ImmutableAssessmentRatingParsedResult.fromJson(new Json());

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
   *   <li>{@link ImmutableAssessmentRatingParsedResult#toString()}
   *   <li>{@link ImmutableAssessmentRatingParsedResult#error()}
   *   <li>{@link ImmutableAssessmentRatingParsedResult#input()}
   *   <li>{@link ImmutableAssessmentRatingParsedResult#parsedItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingParseError ImmutableAssessmentRatingParsedResult.error()",
    "String ImmutableAssessmentRatingParsedResult.input()",
    "List ImmutableAssessmentRatingParsedResult.parsedItems()",
    "String ImmutableAssessmentRatingParsedResult.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedResult immutableAssessmentRatingParsedResult =
        builderResult
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act
    String actualToStringResult = immutableAssessmentRatingParsedResult.toString();
    AssessmentRatingParseError actualErrorResult = immutableAssessmentRatingParsedResult.error();
    String actualInputResult = immutableAssessmentRatingParsedResult.input();

    // Assert
    assertTrue(actualErrorResult instanceof ImmutableAssessmentRatingParseError);
    assertEquals(
        "AssessmentRatingParsedResult{parsedItems=[], input=Input, error=AssessmentRatingParseError{message=Not"
            + " all who wander are lost, line=2, column=1}}",
        actualToStringResult);
    assertEquals("Input", actualInputResult);
    assertTrue(immutableAssessmentRatingParsedResult.parsedItems().isEmpty());
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
  @MethodsUnderTest({"AssessmentRatingParseError Json.error()"})
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
   * Test {@link ImmutableAssessmentRatingParsedResult#withError(AssessmentRatingParseError)}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingParsedResult#withError(AssessmentRatingParseError)}
   */
  @Test
  @DisplayName("Test withError(AssessmentRatingParseError)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingParsedResult ImmutableAssessmentRatingParsedResult.withError(AssessmentRatingParseError)"
  })
  void testWithError() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedResult immutableAssessmentRatingParsedResult =
        builderResult
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act
    ImmutableAssessmentRatingParsedResult actualWithErrorResult =
        immutableAssessmentRatingParsedResult.withError(
            ImmutableAssessmentRatingParseError.builder()
                .column(1)
                .line(2)
                .message("Not all who wander are lost")
                .build());

    // Assert
    assertEquals(immutableAssessmentRatingParsedResult, actualWithErrorResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#withInput(String)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedResult#withInput(String)}
   */
  @Test
  @DisplayName("Test withInput(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingParsedResult ImmutableAssessmentRatingParsedResult.withInput(String)"
  })
  void testWithInput() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedResult immutableAssessmentRatingParsedResult =
        builderResult
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("42")
            .build();

    // Act
    ImmutableAssessmentRatingParsedResult actualWithInputResult =
        immutableAssessmentRatingParsedResult.withInput("42");

    // Assert
    assertSame(immutableAssessmentRatingParsedResult, actualWithInputResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedResult#withInput(String)}.
   *
   * <ul>
   *   <li>Then error return {@link ImmutableAssessmentRatingParseError}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedResult#withInput(String)}
   */
  @Test
  @DisplayName("Test withInput(String); then error return ImmutableAssessmentRatingParseError")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingParsedResult ImmutableAssessmentRatingParsedResult.withInput(String)"
  })
  void testWithInput_thenErrorReturnImmutableAssessmentRatingParseError() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();

    // Act
    ImmutableAssessmentRatingParsedResult actualWithInputResult =
        builderResult
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build()
            .withInput("42");

    // Assert
    AssessmentRatingParseError errorResult = actualWithInputResult.error();
    assertTrue(errorResult instanceof ImmutableAssessmentRatingParseError);
    assertEquals("42", actualWithInputResult.input());
    assertEquals("Not all who wander are lost", errorResult.message());
    assertEquals(1, errorResult.column().intValue());
    assertEquals(2, errorResult.line().intValue());
    assertTrue(actualWithInputResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link
   * ImmutableAssessmentRatingParsedResult#withParsedItems(AssessmentRatingParsedItem[])} with
   * {@code AssessmentRatingParsedItem[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingParsedResult#withParsedItems(AssessmentRatingParsedItem[])}
   */
  @Test
  @DisplayName(
      "Test withParsedItems(AssessmentRatingParsedItem[]) with 'AssessmentRatingParsedItem[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingParsedResult ImmutableAssessmentRatingParsedResult.withParsedItems(AssessmentRatingParsedItem[])"
  })
  void testWithParsedItemsWithAssessmentRatingParsedItem() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedResult.builder();
    ImmutableAssessmentRatingParsedResult immutableAssessmentRatingParsedResult =
        builderResult
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act
    ImmutableAssessmentRatingParsedResult actualWithParsedItemsResult =
        immutableAssessmentRatingParsedResult.withParsedItems(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());

    // Assert
    AssessmentRatingParseError errorResult = actualWithParsedItemsResult.error();
    assertTrue(errorResult instanceof ImmutableAssessmentRatingParseError);
    List<AssessmentRatingParsedItem> parsedItemsResult = actualWithParsedItemsResult.parsedItems();
    assertEquals(1, parsedItemsResult.size());
    AssessmentRatingParsedItem getResult = parsedItemsResult.get(0);
    assertTrue(getResult instanceof ImmutableAssessmentRatingParsedItem);
    assertEquals("42", getResult.externalId());
    assertEquals("Comment", getResult.comment());
    assertEquals("Input", actualWithParsedItemsResult.input());
    assertEquals("Not all who wander are lost", errorResult.message());
    assertEquals("Rating Code", getResult.ratingCode());
    assertEquals(1, errorResult.column().intValue());
    assertEquals(2, errorResult.line().intValue());
    assertFalse(getResult.isReadOnly());
  }
}
