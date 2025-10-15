package org.finos.waltz.model.bulk_upload.measurable_rating;

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
import org.finos.waltz.model.bulk_upload.measurable_rating.BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingParseResult.Builder;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingParseResult.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkMeasurableRatingParseResultDiffblueTest {
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
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();

    // Act
    Builder actualAddAllParsedItemsResult = builderResult.addAllParsedItems(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllParsedItemsResult);
  }

  /**
   * Test Builder {@link Builder#addParsedItems(BulkMeasurableRatingItem)} with {@code element}.
   *
   * <ul>
   *   <li>Then builder build parsedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addParsedItems(BulkMeasurableRatingItem)}
   */
  @Test
  @DisplayName(
      "Test Builder addParsedItems(BulkMeasurableRatingItem) with 'element'; then builder build parsedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addParsedItems(BulkMeasurableRatingItem)"})
  void testBuilderAddParsedItemsWithElement_thenBuilderBuildParsedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingItem.Json element = new ImmutableBulkMeasurableRatingItem.Json();

    // Act
    Builder actualAddParsedItemsResult = builderResult.addParsedItems(element);

    // Assert
    List<BulkMeasurableRatingItem> parsedItemsResult = builderResult.build().parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(element, parsedItemsResult.get(0));
    assertSame(builderResult, actualAddParsedItemsResult);
  }

  /**
   * Test Builder {@link Builder#addParsedItems(BulkMeasurableRatingItem[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then builder build parsedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addParsedItems(BulkMeasurableRatingItem[])}
   */
  @Test
  @DisplayName(
      "Test Builder addParsedItems(BulkMeasurableRatingItem[]) with 'elements'; then builder build parsedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addParsedItems(BulkMeasurableRatingItem[])"})
  void testBuilderAddParsedItemsWithElements_thenBuilderBuildParsedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingItem.Json json = new ImmutableBulkMeasurableRatingItem.Json();

    // Act
    Builder actualAddParsedItemsResult = builderResult.addParsedItems(json);

    // Assert
    List<BulkMeasurableRatingItem> parsedItemsResult = builderResult.build().parsedItems();
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
   *   <li>{@link Builder#error(BulkMeasurableRatingParseError)}
   *   <li>{@link Builder#input(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingParseResult Builder.build()",
    "Builder Builder.error(BulkMeasurableRatingParseError)",
    "Builder Builder.input(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseError error =
        ImmutableBulkMeasurableRatingParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build();
    ImmutableBulkMeasurableRatingParseResult actualImmutableBulkMeasurableRatingParseResult =
        actualBuilderResult.error(error).input("Input").build();

    // Assert
    assertEquals("Input", actualImmutableBulkMeasurableRatingParseResult.input());
    assertTrue(actualImmutableBulkMeasurableRatingParseResult.parsedItems().isEmpty());
    assertSame(error, actualImmutableBulkMeasurableRatingParseResult.error());
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingParseResult)}.
   *
   * <p>Method under test: {@link Builder#from(BulkMeasurableRatingParseResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingParseResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingParseResult)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();

    Builder builderResult2 = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseResult instance =
        builderResult2
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act and Assert
    ImmutableBulkMeasurableRatingParseResult actualImmutableBulkMeasurableRatingParseResult =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableBulkMeasurableRatingParseResult);
    ImmutableBulkMeasurableRatingParseResult actualImmutableBulkMeasurableRatingParseResult2 =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkMeasurableRatingParseResult2);
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingParseResult)}.
   *
   * <p>Method under test: {@link Builder#from(BulkMeasurableRatingParseResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingParseResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingParseResult)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();

    Builder builderResult2 = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseResult instance =
        builderResult2
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input(null)
            .build();

    // Act and Assert
    ImmutableBulkMeasurableRatingParseResult actualImmutableBulkMeasurableRatingParseResult =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableBulkMeasurableRatingParseResult);
    ImmutableBulkMeasurableRatingParseResult actualImmutableBulkMeasurableRatingParseResult2 =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkMeasurableRatingParseResult2);
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingParseResult)}.
   *
   * <ul>
   *   <li>Then return build parsedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(BulkMeasurableRatingParseResult)}
   */
  @Test
  @DisplayName(
      "Test Builder from(BulkMeasurableRatingParseResult); then return build parsedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingParseResult)"})
  void testBuilderFrom_thenReturnBuildParsedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();

    Builder builderResult2 = ImmutableBulkMeasurableRatingParseResult.builder();
    builderResult2.addParsedItems(
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build());

    // Act and Assert
    List<BulkMeasurableRatingItem> parsedItemsResult =
        builderResult
            .from(
                builderResult2
                    .error(
                        ImmutableBulkMeasurableRatingParseError.builder()
                            .column(1)
                            .line(2)
                            .message("Not all who wander are lost")
                            .build())
                    .input("Input")
                    .build())
            .build()
            .parsedItems();
    assertEquals(1, parsedItemsResult.size());
    BulkMeasurableRatingItem getResult = parsedItemsResult.get(0);
    assertTrue(getResult instanceof ImmutableBulkMeasurableRatingItem);
    assertEquals("42", getResult.taxonomyExternalId());
    assertEquals("Asset Code", getResult.assetCode());
    assertEquals("Comment", getResult.comment());
    assertEquals("Scheme", getResult.scheme());
    assertEquals('A', getResult.ratingCode());
    assertEquals(1, getResult.allocation().intValue());
    assertFalse(getResult.isPrimary());
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
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();

    // Act
    Builder actualParsedItemsResult = builderResult.parsedItems(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualParsedItemsResult);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#copyOf(BulkMeasurableRatingParseResult)}.
   *
   * <ul>
   *   <li>Then error return {@link ImmutableBulkMeasurableRatingParseError}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkMeasurableRatingParseResult#copyOf(BulkMeasurableRatingParseResult)}
   */
  @Test
  @DisplayName(
      "Test copyOf(BulkMeasurableRatingParseResult); then error return ImmutableBulkMeasurableRatingParseError")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingParseResult ImmutableBulkMeasurableRatingParseResult.copyOf(BulkMeasurableRatingParseResult)"
  })
  void testCopyOf_thenErrorReturnImmutableBulkMeasurableRatingParseError() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseResult instance =
        builderResult
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act
    ImmutableBulkMeasurableRatingParseResult actualCopyOfResult =
        ImmutableBulkMeasurableRatingParseResult.copyOf(instance);

    // Assert
    BulkMeasurableRatingParseError errorResult = actualCopyOfResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertEquals("Input", actualCopyOfResult.input());
    assertEquals("Not all who wander are lost", errorResult.message());
    assertEquals(1, errorResult.column().intValue());
    assertEquals(2, errorResult.line().intValue());
    assertTrue(actualCopyOfResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}, and {@link
   * ImmutableBulkMeasurableRatingParseResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}
   *   <li>{@link ImmutableBulkMeasurableRatingParseResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingParseResult.equals(Object)",
    "int ImmutableBulkMeasurableRatingParseResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseResult immutableBulkMeasurableRatingParseResult =
        builderResult
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    Builder builderResult2 = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseResult immutableBulkMeasurableRatingParseResult2 =
        builderResult2
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act and Assert
    assertEquals(
        immutableBulkMeasurableRatingParseResult, immutableBulkMeasurableRatingParseResult2);
    assertEquals(
        immutableBulkMeasurableRatingParseResult.hashCode(),
        immutableBulkMeasurableRatingParseResult2.hashCode());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}, and {@link
   * ImmutableBulkMeasurableRatingParseResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}
   *   <li>{@link ImmutableBulkMeasurableRatingParseResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingParseResult.equals(Object)",
    "int ImmutableBulkMeasurableRatingParseResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseResult immutableBulkMeasurableRatingParseResult =
        builderResult
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act and Assert
    assertEquals(
        immutableBulkMeasurableRatingParseResult, immutableBulkMeasurableRatingParseResult);
    int expectedHashCodeResult = immutableBulkMeasurableRatingParseResult.hashCode();
    assertEquals(expectedHashCodeResult, immutableBulkMeasurableRatingParseResult.hashCode());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingParseResult.equals(Object)",
    "int ImmutableBulkMeasurableRatingParseResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    builderResult.addParsedItems(
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build());
    ImmutableBulkMeasurableRatingParseResult immutableBulkMeasurableRatingParseResult =
        builderResult
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    Builder builderResult2 = ImmutableBulkMeasurableRatingParseResult.builder();

    // Act and Assert
    assertNotEquals(
        immutableBulkMeasurableRatingParseResult,
        builderResult2
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingParseResult.equals(Object)",
    "int ImmutableBulkMeasurableRatingParseResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseResult immutableBulkMeasurableRatingParseResult =
        builderResult
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(0)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    Builder builderResult2 = ImmutableBulkMeasurableRatingParseResult.builder();

    // Act and Assert
    assertNotEquals(
        immutableBulkMeasurableRatingParseResult,
        builderResult2
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingParseResult.equals(Object)",
    "int ImmutableBulkMeasurableRatingParseResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseResult immutableBulkMeasurableRatingParseResult =
        builderResult
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Not all who wander are lost")
            .build();

    Builder builderResult2 = ImmutableBulkMeasurableRatingParseResult.builder();

    // Act and Assert
    assertNotEquals(
        immutableBulkMeasurableRatingParseResult,
        builderResult2
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingParseResult.equals(Object)",
    "int ImmutableBulkMeasurableRatingParseResult.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingParseResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingParseResult.equals(Object)",
    "int ImmutableBulkMeasurableRatingParseResult.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build(),
        "Different type to ImmutableBulkMeasurableRatingParseResult");
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableBulkMeasurableRatingItem.Json}
   *       (default constructor).
   *   <li>Then return parsedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingParseResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add Json (default constructor); then return parsedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingParseResult ImmutableBulkMeasurableRatingParseResult.fromJson(Json)"
  })
  void testFromJson_givenArrayListAddJson_thenReturnParsedItemsSizeIsOne() {
    // Arrange
    ArrayList<BulkMeasurableRatingItem> parsedItems = new ArrayList<>();
    ImmutableBulkMeasurableRatingItem.Json json = new ImmutableBulkMeasurableRatingItem.Json();
    parsedItems.add(json);

    Json json2 = new Json();
    json2.setParsedItems(parsedItems);
    json2.setInput(null);
    json2.setError(null);

    // Act
    ImmutableBulkMeasurableRatingParseResult actualFromJsonResult =
        ImmutableBulkMeasurableRatingParseResult.fromJson(json2);

    // Assert
    List<BulkMeasurableRatingItem> parsedItemsResult = actualFromJsonResult.parsedItems();
    assertEquals(1, parsedItemsResult.size());
    assertSame(json, parsedItemsResult.get(0));
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ImmutableBulkMeasurableRatingParseError.Json} (default constructor).
   *   <li>When {@link Json} (default constructor) Error is {@link
   *       ImmutableBulkMeasurableRatingParseError.Json} (default constructor).
   *   <li>Then return error is {@link ImmutableBulkMeasurableRatingParseError.Json} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingParseResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given Json (default constructor); when Json (default constructor) Error is Json (default constructor); then return error is Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingParseResult ImmutableBulkMeasurableRatingParseResult.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonErrorIsJson_thenReturnErrorIsJson() {
    // Arrange
    Json json = new Json();
    json.setParsedItems(null);
    json.setInput(null);
    ImmutableBulkMeasurableRatingParseError.Json error =
        new ImmutableBulkMeasurableRatingParseError.Json();
    json.setError(error);

    // Act
    ImmutableBulkMeasurableRatingParseResult actualFromJsonResult =
        ImmutableBulkMeasurableRatingParseResult.fromJson(json);

    // Assert
    assertSame(error, actualFromJsonResult.error());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Input is {@code Json}.
   *   <li>Then return input is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingParseResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Input is 'Json'; then return input is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingParseResult ImmutableBulkMeasurableRatingParseResult.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonInputIsJson_thenReturnInputIsJson() {
    // Arrange
    Json json = new Json();
    json.setParsedItems(null);
    json.setInput("Json");
    json.setError(null);

    // Act
    ImmutableBulkMeasurableRatingParseResult actualFromJsonResult =
        ImmutableBulkMeasurableRatingParseResult.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertTrue(actualFromJsonResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) ParsedItems is {@code null}.
   *   <li>Then return input is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingParseResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) ParsedItems is 'null'; then return input is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingParseResult ImmutableBulkMeasurableRatingParseResult.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonParsedItemsIsNull_thenReturnInputIsNull() {
    // Arrange
    Json json = new Json();
    json.setParsedItems(null);
    json.setInput(null);
    json.setError(null);

    // Act
    ImmutableBulkMeasurableRatingParseResult actualFromJsonResult =
        ImmutableBulkMeasurableRatingParseResult.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.input());
    assertNull(actualFromJsonResult.error());
    assertTrue(actualFromJsonResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return parsedItems size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingParseResult#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return parsedItems size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingParseResult ImmutableBulkMeasurableRatingParseResult.fromJson(Json)"
  })
  void testFromJson_thenReturnParsedItemsSizeIsTwo() {
    // Arrange
    ArrayList<BulkMeasurableRatingItem> parsedItems = new ArrayList<>();
    parsedItems.add(
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build());
    ImmutableBulkMeasurableRatingItem.Json json = new ImmutableBulkMeasurableRatingItem.Json();
    parsedItems.add(json);

    Json json2 = new Json();
    json2.setParsedItems(parsedItems);
    json2.setInput(null);
    json2.setError(null);

    // Act
    ImmutableBulkMeasurableRatingParseResult actualFromJsonResult =
        ImmutableBulkMeasurableRatingParseResult.fromJson(json2);

    // Assert
    List<BulkMeasurableRatingItem> parsedItemsResult = actualFromJsonResult.parsedItems();
    assertEquals(2, parsedItemsResult.size());
    BulkMeasurableRatingItem getResult = parsedItemsResult.get(0);
    assertTrue(getResult instanceof ImmutableBulkMeasurableRatingItem);
    assertEquals("42", getResult.taxonomyExternalId());
    assertEquals("Asset Code", getResult.assetCode());
    assertEquals("Comment", getResult.comment());
    assertEquals("Scheme", getResult.scheme());
    assertEquals('A', getResult.ratingCode());
    assertEquals(1, getResult.allocation().intValue());
    assertFalse(getResult.isPrimary());
    assertSame(json, parsedItemsResult.get(1));
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return input is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingParseResult#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return input is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingParseResult ImmutableBulkMeasurableRatingParseResult.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnInputIsNull() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingParseResult actualFromJsonResult =
        ImmutableBulkMeasurableRatingParseResult.fromJson(new Json());

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
   *   <li>{@link ImmutableBulkMeasurableRatingParseResult#toString()}
   *   <li>{@link ImmutableBulkMeasurableRatingParseResult#error()}
   *   <li>{@link ImmutableBulkMeasurableRatingParseResult#input()}
   *   <li>{@link ImmutableBulkMeasurableRatingParseResult#parsedItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkMeasurableRatingParseError ImmutableBulkMeasurableRatingParseResult.error()",
    "String ImmutableBulkMeasurableRatingParseResult.input()",
    "List ImmutableBulkMeasurableRatingParseResult.parsedItems()",
    "String ImmutableBulkMeasurableRatingParseResult.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseResult immutableBulkMeasurableRatingParseResult =
        builderResult
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act
    String actualToStringResult = immutableBulkMeasurableRatingParseResult.toString();
    BulkMeasurableRatingParseError actualErrorResult =
        immutableBulkMeasurableRatingParseResult.error();
    String actualInputResult = immutableBulkMeasurableRatingParseResult.input();

    // Assert
    assertTrue(actualErrorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertEquals(
        "BulkMeasurableRatingParseResult{parsedItems=[], input=Input, error=BulkMeasurableRatingParseError{message=Not"
            + " all who wander are lost, line=2, column=1}}",
        actualToStringResult);
    assertEquals("Input", actualInputResult);
    assertTrue(immutableBulkMeasurableRatingParseResult.parsedItems().isEmpty());
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
  @MethodsUnderTest({"BulkMeasurableRatingParseError Json.error()"})
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
   * ImmutableBulkMeasurableRatingParseResult#withError(BulkMeasurableRatingParseError)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkMeasurableRatingParseResult#withError(BulkMeasurableRatingParseError)}
   */
  @Test
  @DisplayName("Test withError(BulkMeasurableRatingParseError)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingParseResult ImmutableBulkMeasurableRatingParseResult.withError(BulkMeasurableRatingParseError)"
  })
  void testWithError() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseResult immutableBulkMeasurableRatingParseResult =
        builderResult
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act
    ImmutableBulkMeasurableRatingParseResult actualWithErrorResult =
        immutableBulkMeasurableRatingParseResult.withError(
            ImmutableBulkMeasurableRatingParseError.builder()
                .column(1)
                .line(2)
                .message("Not all who wander are lost")
                .build());

    // Assert
    assertEquals(immutableBulkMeasurableRatingParseResult, actualWithErrorResult);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#withInput(String)}.
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingParseResult#withInput(String)}
   */
  @Test
  @DisplayName("Test withInput(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingParseResult ImmutableBulkMeasurableRatingParseResult.withInput(String)"
  })
  void testWithInput() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseResult immutableBulkMeasurableRatingParseResult =
        builderResult
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("42")
            .build();

    // Act
    ImmutableBulkMeasurableRatingParseResult actualWithInputResult =
        immutableBulkMeasurableRatingParseResult.withInput("42");

    // Assert
    assertSame(immutableBulkMeasurableRatingParseResult, actualWithInputResult);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingParseResult#withInput(String)}.
   *
   * <ul>
   *   <li>Then error return {@link ImmutableBulkMeasurableRatingParseError}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingParseResult#withInput(String)}
   */
  @Test
  @DisplayName("Test withInput(String); then error return ImmutableBulkMeasurableRatingParseError")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingParseResult ImmutableBulkMeasurableRatingParseResult.withInput(String)"
  })
  void testWithInput_thenErrorReturnImmutableBulkMeasurableRatingParseError() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();

    // Act
    ImmutableBulkMeasurableRatingParseResult actualWithInputResult =
        builderResult
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build()
            .withInput("42");

    // Assert
    BulkMeasurableRatingParseError errorResult = actualWithInputResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertEquals("42", actualWithInputResult.input());
    assertEquals("Not all who wander are lost", errorResult.message());
    assertEquals(1, errorResult.column().intValue());
    assertEquals(2, errorResult.line().intValue());
    assertTrue(actualWithInputResult.parsedItems().isEmpty());
  }

  /**
   * Test {@link
   * ImmutableBulkMeasurableRatingParseResult#withParsedItems(BulkMeasurableRatingItem[])} with
   * {@code BulkMeasurableRatingItem[]}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkMeasurableRatingParseResult#withParsedItems(BulkMeasurableRatingItem[])}
   */
  @Test
  @DisplayName("Test withParsedItems(BulkMeasurableRatingItem[]) with 'BulkMeasurableRatingItem[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingParseResult ImmutableBulkMeasurableRatingParseResult.withParsedItems(BulkMeasurableRatingItem[])"
  })
  void testWithParsedItemsWithBulkMeasurableRatingItem() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseResult.builder();
    ImmutableBulkMeasurableRatingParseResult immutableBulkMeasurableRatingParseResult =
        builderResult
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .input("Input")
            .build();

    // Act
    ImmutableBulkMeasurableRatingParseResult actualWithParsedItemsResult =
        immutableBulkMeasurableRatingParseResult.withParsedItems(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());

    // Assert
    List<BulkMeasurableRatingItem> parsedItemsResult = actualWithParsedItemsResult.parsedItems();
    assertEquals(1, parsedItemsResult.size());
    BulkMeasurableRatingItem getResult = parsedItemsResult.get(0);
    assertTrue(getResult instanceof ImmutableBulkMeasurableRatingItem);
    BulkMeasurableRatingParseError errorResult = actualWithParsedItemsResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertEquals("42", getResult.taxonomyExternalId());
    assertEquals("Asset Code", getResult.assetCode());
    assertEquals("Comment", getResult.comment());
    assertEquals("Input", actualWithParsedItemsResult.input());
    assertEquals("Not all who wander are lost", errorResult.message());
    assertEquals("Scheme", getResult.scheme());
    assertEquals('A', getResult.ratingCode());
    assertEquals(1, getResult.allocation().intValue());
    assertEquals(1, errorResult.column().intValue());
    assertEquals(2, errorResult.line().intValue());
    assertFalse(getResult.isPrimary());
  }
}
