package org.finos.waltz.model.bulk_upload.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingItem.Builder;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkMeasurableRatingItemDiffblueTest {
  /**
   * Test Builder {@link Builder#assetCode(String)}.
   *
   * <ul>
   *   <li>When {@code Asset Code}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#assetCode(String)}
   */
  @Test
  @DisplayName("Test Builder assetCode(String); when 'Asset Code'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.assetCode(String)"})
  void testBuilderAssetCode_whenAssetCode_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();

    // Act
    Builder actualAssetCodeResult = builderResult.assetCode("Asset Code");

    // Assert
    assertSame(builderResult, actualAssetCodeResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#allocation(Integer)}
   *   <li>{@link Builder#comment(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.allocation(Integer)",
    "ImmutableBulkMeasurableRatingItem Builder.build()",
    "Builder Builder.comment(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingItem actualImmutableBulkMeasurableRatingItem =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build();

    // Assert
    assertEquals("42", actualImmutableBulkMeasurableRatingItem.taxonomyExternalId());
    assertEquals("Asset Code", actualImmutableBulkMeasurableRatingItem.assetCode());
    assertEquals("Comment", actualImmutableBulkMeasurableRatingItem.comment());
    assertEquals("Scheme", actualImmutableBulkMeasurableRatingItem.scheme());
    assertEquals('A', actualImmutableBulkMeasurableRatingItem.ratingCode());
    assertEquals(1, actualImmutableBulkMeasurableRatingItem.allocation().intValue());
    assertFalse(actualImmutableBulkMeasurableRatingItem.isPrimary());
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingItem)}.
   *
   * <p>Method under test: {@link Builder#from(BulkMeasurableRatingItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingItem)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();
    ImmutableBulkMeasurableRatingItem instance =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkMeasurableRatingItem actualImmutableBulkMeasurableRatingItem =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkMeasurableRatingItem);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingItem)}.
   *
   * <p>Method under test: {@link Builder#from(BulkMeasurableRatingItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingItem)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();
    ImmutableBulkMeasurableRatingItem instance =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(null)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkMeasurableRatingItem actualImmutableBulkMeasurableRatingItem =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkMeasurableRatingItem);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingItem)}.
   *
   * <p>Method under test: {@link Builder#from(BulkMeasurableRatingItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingItem)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();
    ImmutableBulkMeasurableRatingItem instance =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment(null)
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkMeasurableRatingItem actualImmutableBulkMeasurableRatingItem =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkMeasurableRatingItem);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#isPrimary(boolean)}.
   *
   * <p>Method under test: {@link Builder#isPrimary(boolean)}
   */
  @Test
  @DisplayName("Test Builder isPrimary(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isPrimary(boolean)"})
  void testBuilderIsPrimary() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();

    // Act
    Builder actualIsPrimaryResult = builderResult.isPrimary(true);

    // Assert
    assertSame(builderResult, actualIsPrimaryResult);
  }

  /**
   * Test Builder {@link Builder#ratingCode(char)}.
   *
   * <p>Method under test: {@link Builder#ratingCode(char)}
   */
  @Test
  @DisplayName("Test Builder ratingCode(char)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingCode(char)"})
  void testBuilderRatingCode() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();

    // Act
    Builder actualRatingCodeResult = builderResult.ratingCode('A');

    // Assert
    assertSame(builderResult, actualRatingCodeResult);
  }

  /**
   * Test Builder {@link Builder#scheme(String)}.
   *
   * <ul>
   *   <li>When {@code Scheme}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#scheme(String)}
   */
  @Test
  @DisplayName("Test Builder scheme(String); when 'Scheme'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.scheme(String)"})
  void testBuilderScheme_whenScheme_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();

    // Act
    Builder actualSchemeResult = builderResult.scheme("Scheme");

    // Assert
    assertSame(builderResult, actualSchemeResult);
  }

  /**
   * Test Builder {@link Builder#taxonomyExternalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#taxonomyExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder taxonomyExternalId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.taxonomyExternalId(String)"})
  void testBuilderTaxonomyExternalId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();

    // Act
    Builder actualTaxonomyExternalIdResult = builderResult.taxonomyExternalId("42");

    // Assert
    assertSame(builderResult, actualTaxonomyExternalIdResult);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#copyOf(BulkMeasurableRatingItem)}.
   *
   * <ul>
   *   <li>Then return taxonomyExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkMeasurableRatingItem#copyOf(BulkMeasurableRatingItem)}
   */
  @Test
  @DisplayName("Test copyOf(BulkMeasurableRatingItem); then return taxonomyExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingItem ImmutableBulkMeasurableRatingItem.copyOf(BulkMeasurableRatingItem)"
  })
  void testCopyOf_thenReturnTaxonomyExternalIdIs42() {
    // Arrange
    ImmutableBulkMeasurableRatingItem instance =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build();

    // Act
    ImmutableBulkMeasurableRatingItem actualCopyOfResult =
        ImmutableBulkMeasurableRatingItem.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.taxonomyExternalId());
    assertEquals("Asset Code", actualCopyOfResult.assetCode());
    assertEquals("Comment", actualCopyOfResult.comment());
    assertEquals("Scheme", actualCopyOfResult.scheme());
    assertEquals('A', actualCopyOfResult.ratingCode());
    assertEquals(1, actualCopyOfResult.allocation().intValue());
    assertFalse(actualCopyOfResult.isPrimary());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#equals(Object)}, and {@link
   * ImmutableBulkMeasurableRatingItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkMeasurableRatingItem#equals(Object)}
   *   <li>{@link ImmutableBulkMeasurableRatingItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingItem.equals(Object)",
    "int ImmutableBulkMeasurableRatingItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableBulkMeasurableRatingItem immutableBulkMeasurableRatingItem =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build();
    ImmutableBulkMeasurableRatingItem immutableBulkMeasurableRatingItem2 =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build();

    // Act and Assert
    assertEquals(immutableBulkMeasurableRatingItem, immutableBulkMeasurableRatingItem2);
    assertEquals(
        immutableBulkMeasurableRatingItem.hashCode(),
        immutableBulkMeasurableRatingItem2.hashCode());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#equals(Object)}, and {@link
   * ImmutableBulkMeasurableRatingItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkMeasurableRatingItem#equals(Object)}
   *   <li>{@link ImmutableBulkMeasurableRatingItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingItem.equals(Object)",
    "int ImmutableBulkMeasurableRatingItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableBulkMeasurableRatingItem immutableBulkMeasurableRatingItem =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build();

    // Act and Assert
    assertEquals(immutableBulkMeasurableRatingItem, immutableBulkMeasurableRatingItem);
    int expectedHashCodeResult = immutableBulkMeasurableRatingItem.hashCode();
    assertEquals(expectedHashCodeResult, immutableBulkMeasurableRatingItem.hashCode());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingItem.equals(Object)",
    "int ImmutableBulkMeasurableRatingItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableBulkMeasurableRatingItem immutableBulkMeasurableRatingItem =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(65)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkMeasurableRatingItem,
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingItem.equals(Object)",
    "int ImmutableBulkMeasurableRatingItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableBulkMeasurableRatingItem immutableBulkMeasurableRatingItem =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("42")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkMeasurableRatingItem,
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingItem.equals(Object)",
    "int ImmutableBulkMeasurableRatingItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableBulkMeasurableRatingItem immutableBulkMeasurableRatingItem =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Asset Code")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkMeasurableRatingItem,
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingItem.equals(Object)",
    "int ImmutableBulkMeasurableRatingItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableBulkMeasurableRatingItem immutableBulkMeasurableRatingItem =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('\u0001')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkMeasurableRatingItem,
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingItem.equals(Object)",
    "int ImmutableBulkMeasurableRatingItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableBulkMeasurableRatingItem immutableBulkMeasurableRatingItem =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Asset Code")
            .taxonomyExternalId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkMeasurableRatingItem,
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingItem.equals(Object)",
    "int ImmutableBulkMeasurableRatingItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableBulkMeasurableRatingItem immutableBulkMeasurableRatingItem =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("Asset Code")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkMeasurableRatingItem,
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingItem.equals(Object)",
    "int ImmutableBulkMeasurableRatingItem.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingItem.equals(Object)",
    "int ImmutableBulkMeasurableRatingItem.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build(),
        "Different type to ImmutableBulkMeasurableRatingItem");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkMeasurableRatingItem#toString()}
   *   <li>{@link ImmutableBulkMeasurableRatingItem#allocation()}
   *   <li>{@link ImmutableBulkMeasurableRatingItem#assetCode()}
   *   <li>{@link ImmutableBulkMeasurableRatingItem#comment()}
   *   <li>{@link ImmutableBulkMeasurableRatingItem#isPrimary()}
   *   <li>{@link ImmutableBulkMeasurableRatingItem#ratingCode()}
   *   <li>{@link ImmutableBulkMeasurableRatingItem#scheme()}
   *   <li>{@link ImmutableBulkMeasurableRatingItem#taxonomyExternalId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer ImmutableBulkMeasurableRatingItem.allocation()",
    "String ImmutableBulkMeasurableRatingItem.assetCode()",
    "String ImmutableBulkMeasurableRatingItem.comment()",
    "boolean ImmutableBulkMeasurableRatingItem.isPrimary()",
    "char ImmutableBulkMeasurableRatingItem.ratingCode()",
    "String ImmutableBulkMeasurableRatingItem.scheme()",
    "String ImmutableBulkMeasurableRatingItem.taxonomyExternalId()",
    "String ImmutableBulkMeasurableRatingItem.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableBulkMeasurableRatingItem immutableBulkMeasurableRatingItem =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build();

    // Act
    String actualToStringResult = immutableBulkMeasurableRatingItem.toString();
    Integer actualAllocationResult = immutableBulkMeasurableRatingItem.allocation();
    String actualAssetCodeResult = immutableBulkMeasurableRatingItem.assetCode();
    String actualCommentResult = immutableBulkMeasurableRatingItem.comment();
    boolean actualIsPrimaryResult = immutableBulkMeasurableRatingItem.isPrimary();
    char actualRatingCodeResult = immutableBulkMeasurableRatingItem.ratingCode();
    String actualSchemeResult = immutableBulkMeasurableRatingItem.scheme();

    // Assert
    assertEquals("42", immutableBulkMeasurableRatingItem.taxonomyExternalId());
    assertEquals("Asset Code", actualAssetCodeResult);
    assertEquals(
        "BulkMeasurableRatingItem{assetCode=Asset Code, taxonomyExternalId=42, ratingCode=A, isPrimary=false,"
            + " comment=Comment, allocation=1, scheme=Scheme}",
        actualToStringResult);
    assertEquals("Comment", actualCommentResult);
    assertEquals("Scheme", actualSchemeResult);
    assertEquals('A', actualRatingCodeResult);
    assertEquals(1, actualAllocationResult.intValue());
    assertFalse(actualIsPrimaryResult);
  }

  /**
   * Test Json {@link Json#allocation()}.
   *
   * <p>Method under test: {@link Json#allocation()}
   */
  @Test
  @DisplayName("Test Json allocation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer Json.allocation()"})
  void testJsonAllocation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().allocation());
  }

  /**
   * Test Json {@link Json#assetCode()}.
   *
   * <p>Method under test: {@link Json#assetCode()}
   */
  @Test
  @DisplayName("Test Json assetCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.assetCode()"})
  void testJsonAssetCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().assetCode());
  }

  /**
   * Test Json {@link Json#comment()}.
   *
   * <p>Method under test: {@link Json#comment()}
   */
  @Test
  @DisplayName("Test Json comment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.comment()"})
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().comment());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAllocation(Integer)}
   *   <li>{@link Json#setAssetCode(String)}
   *   <li>{@link Json#setComment(String)}
   *   <li>{@link Json#setScheme(String)}
   *   <li>{@link Json#setTaxonomyExternalId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setAllocation(Integer)",
    "void Json.setAssetCode(String)",
    "void Json.setComment(String)",
    "void Json.setScheme(String)",
    "void Json.setTaxonomyExternalId(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setAllocation(1);
    actualJson.setAssetCode("Asset Code");
    actualJson.setComment("Comment");
    actualJson.setScheme("Scheme");
    actualJson.setTaxonomyExternalId("42");

    // Assert
    assertEquals(1, actualJson.allocation.intValue());
  }

  /**
   * Test Json {@link Json#isPrimary()}.
   *
   * <p>Method under test: {@link Json#isPrimary()}
   */
  @Test
  @DisplayName("Test Json isPrimary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isPrimary()"})
  void testJsonIsPrimary() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isPrimary());
  }

  /**
   * Test Json {@link Json#ratingCode()}.
   *
   * <p>Method under test: {@link Json#ratingCode()}
   */
  @Test
  @DisplayName("Test Json ratingCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"char Json.ratingCode()"})
  void testJsonRatingCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingCode());
  }

  /**
   * Test Json {@link Json#scheme()}.
   *
   * <p>Method under test: {@link Json#scheme()}
   */
  @Test
  @DisplayName("Test Json scheme()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.scheme()"})
  void testJsonScheme() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().scheme());
  }

  /**
   * Test Json {@link Json#setIsPrimary(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsPrimary(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsPrimary(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsPrimary(boolean)"})
  void testJsonSetIsPrimary() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsPrimary(true);

    // Assert
    assertTrue(json.isPrimary);
    assertTrue(json.isPrimaryIsSet);
  }

  /**
   * Test Json {@link Json#setRatingCode(char)}.
   *
   * <p>Method under test: {@link Json#setRatingCode(char)}
   */
  @Test
  @DisplayName("Test Json setRatingCode(char)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setRatingCode(char)"})
  void testJsonSetRatingCode() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRatingCode('A');

    // Assert
    assertEquals('A', json.ratingCode);
    assertTrue(json.ratingCodeIsSet);
  }

  /**
   * Test Json {@link Json#taxonomyExternalId()}.
   *
   * <p>Method under test: {@link Json#taxonomyExternalId()}
   */
  @Test
  @DisplayName("Test Json taxonomyExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.taxonomyExternalId()"})
  void testJsonTaxonomyExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().taxonomyExternalId());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#withAllocation(Integer)}.
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingItem#withAllocation(Integer)}
   */
  @Test
  @DisplayName("Test withAllocation(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingItem ImmutableBulkMeasurableRatingItem.withAllocation(Integer)"
  })
  void testWithAllocation() {
    // Arrange
    ImmutableBulkMeasurableRatingItem immutableBulkMeasurableRatingItem =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build();

    // Act
    ImmutableBulkMeasurableRatingItem actualWithAllocationResult =
        immutableBulkMeasurableRatingItem.withAllocation(1);

    // Assert
    assertSame(immutableBulkMeasurableRatingItem, actualWithAllocationResult);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#withAllocation(Integer)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return taxonomyExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingItem#withAllocation(Integer)}
   */
  @Test
  @DisplayName(
      "Test withAllocation(Integer); when forty-two; then return taxonomyExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingItem ImmutableBulkMeasurableRatingItem.withAllocation(Integer)"
  })
  void testWithAllocation_whenFortyTwo_thenReturnTaxonomyExternalIdIs42() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingItem actualWithAllocationResult =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build()
            .withAllocation(42);

    // Assert
    assertEquals("42", actualWithAllocationResult.taxonomyExternalId());
    assertEquals("Asset Code", actualWithAllocationResult.assetCode());
    assertEquals("Comment", actualWithAllocationResult.comment());
    assertEquals("Scheme", actualWithAllocationResult.scheme());
    assertEquals('A', actualWithAllocationResult.ratingCode());
    assertEquals(42, actualWithAllocationResult.allocation().intValue());
    assertFalse(actualWithAllocationResult.isPrimary());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#withAssetCode(String)}.
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingItem#withAssetCode(String)}
   */
  @Test
  @DisplayName("Test withAssetCode(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingItem ImmutableBulkMeasurableRatingItem.withAssetCode(String)"
  })
  void testWithAssetCode() {
    // Arrange
    ImmutableBulkMeasurableRatingItem immutableBulkMeasurableRatingItem =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("42")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build();

    // Act
    ImmutableBulkMeasurableRatingItem actualWithAssetCodeResult =
        immutableBulkMeasurableRatingItem.withAssetCode("42");

    // Assert
    assertSame(immutableBulkMeasurableRatingItem, actualWithAssetCodeResult);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#withAssetCode(String)}.
   *
   * <ul>
   *   <li>Then return assetCode is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingItem#withAssetCode(String)}
   */
  @Test
  @DisplayName("Test withAssetCode(String); then return assetCode is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingItem ImmutableBulkMeasurableRatingItem.withAssetCode(String)"
  })
  void testWithAssetCode_thenReturnAssetCodeIs42() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingItem actualWithAssetCodeResult =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build()
            .withAssetCode("42");

    // Assert
    assertEquals("42", actualWithAssetCodeResult.assetCode());
    assertEquals("42", actualWithAssetCodeResult.taxonomyExternalId());
    assertEquals("Comment", actualWithAssetCodeResult.comment());
    assertEquals("Scheme", actualWithAssetCodeResult.scheme());
    assertEquals('A', actualWithAssetCodeResult.ratingCode());
    assertEquals(1, actualWithAssetCodeResult.allocation().intValue());
    assertFalse(actualWithAssetCodeResult.isPrimary());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#withComment(String)}.
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingItem#withComment(String)}
   */
  @Test
  @DisplayName("Test withComment(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingItem ImmutableBulkMeasurableRatingItem.withComment(String)"
  })
  void testWithComment() {
    // Arrange
    ImmutableBulkMeasurableRatingItem immutableBulkMeasurableRatingItem =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("42")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build();

    // Act
    ImmutableBulkMeasurableRatingItem actualWithCommentResult =
        immutableBulkMeasurableRatingItem.withComment("42");

    // Assert
    assertSame(immutableBulkMeasurableRatingItem, actualWithCommentResult);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#withComment(String)}.
   *
   * <ul>
   *   <li>Then return comment is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingItem#withComment(String)}
   */
  @Test
  @DisplayName("Test withComment(String); then return comment is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingItem ImmutableBulkMeasurableRatingItem.withComment(String)"
  })
  void testWithComment_thenReturnCommentIs42() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingItem actualWithCommentResult =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build()
            .withComment("42");

    // Assert
    assertEquals("42", actualWithCommentResult.comment());
    assertEquals("42", actualWithCommentResult.taxonomyExternalId());
    assertEquals("Asset Code", actualWithCommentResult.assetCode());
    assertEquals("Scheme", actualWithCommentResult.scheme());
    assertEquals('A', actualWithCommentResult.ratingCode());
    assertEquals(1, actualWithCommentResult.allocation().intValue());
    assertFalse(actualWithCommentResult.isPrimary());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#withIsPrimary(boolean)}.
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingItem#withIsPrimary(boolean)}
   */
  @Test
  @DisplayName("Test withIsPrimary(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingItem ImmutableBulkMeasurableRatingItem.withIsPrimary(boolean)"
  })
  void testWithIsPrimary() {
    // Arrange
    ImmutableBulkMeasurableRatingItem immutableBulkMeasurableRatingItem =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build();

    // Act
    ImmutableBulkMeasurableRatingItem actualWithIsPrimaryResult =
        immutableBulkMeasurableRatingItem.withIsPrimary(false);

    // Assert
    assertSame(immutableBulkMeasurableRatingItem, actualWithIsPrimaryResult);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#withIsPrimary(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return taxonomyExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingItem#withIsPrimary(boolean)}
   */
  @Test
  @DisplayName("Test withIsPrimary(boolean); when 'true'; then return taxonomyExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingItem ImmutableBulkMeasurableRatingItem.withIsPrimary(boolean)"
  })
  void testWithIsPrimary_whenTrue_thenReturnTaxonomyExternalIdIs42() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingItem actualWithIsPrimaryResult =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build()
            .withIsPrimary(true);

    // Assert
    assertEquals("42", actualWithIsPrimaryResult.taxonomyExternalId());
    assertEquals("Asset Code", actualWithIsPrimaryResult.assetCode());
    assertEquals("Comment", actualWithIsPrimaryResult.comment());
    assertEquals("Scheme", actualWithIsPrimaryResult.scheme());
    assertEquals('A', actualWithIsPrimaryResult.ratingCode());
    assertEquals(1, actualWithIsPrimaryResult.allocation().intValue());
    assertTrue(actualWithIsPrimaryResult.isPrimary());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#withRatingCode(char)}.
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingItem#withRatingCode(char)}
   */
  @Test
  @DisplayName("Test withRatingCode(char)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingItem ImmutableBulkMeasurableRatingItem.withRatingCode(char)"
  })
  void testWithRatingCode() {
    // Arrange
    ImmutableBulkMeasurableRatingItem immutableBulkMeasurableRatingItem =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build();

    // Act
    ImmutableBulkMeasurableRatingItem actualWithRatingCodeResult =
        immutableBulkMeasurableRatingItem.withRatingCode('A');

    // Assert
    assertSame(immutableBulkMeasurableRatingItem, actualWithRatingCodeResult);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#withRatingCode(char)}.
   *
   * <ul>
   *   <li>Then return taxonomyExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingItem#withRatingCode(char)}
   */
  @Test
  @DisplayName("Test withRatingCode(char); then return taxonomyExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingItem ImmutableBulkMeasurableRatingItem.withRatingCode(char)"
  })
  void testWithRatingCode_thenReturnTaxonomyExternalIdIs42() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingItem actualWithRatingCodeResult =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('\u0000')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build()
            .withRatingCode('A');

    // Assert
    assertEquals("42", actualWithRatingCodeResult.taxonomyExternalId());
    assertEquals("Asset Code", actualWithRatingCodeResult.assetCode());
    assertEquals("Comment", actualWithRatingCodeResult.comment());
    assertEquals("Scheme", actualWithRatingCodeResult.scheme());
    assertEquals('A', actualWithRatingCodeResult.ratingCode());
    assertEquals(1, actualWithRatingCodeResult.allocation().intValue());
    assertFalse(actualWithRatingCodeResult.isPrimary());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#withScheme(String)}.
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingItem#withScheme(String)}
   */
  @Test
  @DisplayName("Test withScheme(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingItem ImmutableBulkMeasurableRatingItem.withScheme(String)"
  })
  void testWithScheme() {
    // Arrange
    ImmutableBulkMeasurableRatingItem immutableBulkMeasurableRatingItem =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("42")
            .taxonomyExternalId("42")
            .build();

    // Act
    ImmutableBulkMeasurableRatingItem actualWithSchemeResult =
        immutableBulkMeasurableRatingItem.withScheme("42");

    // Assert
    assertSame(immutableBulkMeasurableRatingItem, actualWithSchemeResult);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#withScheme(String)}.
   *
   * <ul>
   *   <li>Then return scheme is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingItem#withScheme(String)}
   */
  @Test
  @DisplayName("Test withScheme(String); then return scheme is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingItem ImmutableBulkMeasurableRatingItem.withScheme(String)"
  })
  void testWithScheme_thenReturnSchemeIs42() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingItem actualWithSchemeResult =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build()
            .withScheme("42");

    // Assert
    assertEquals("42", actualWithSchemeResult.scheme());
    assertEquals("42", actualWithSchemeResult.taxonomyExternalId());
    assertEquals("Asset Code", actualWithSchemeResult.assetCode());
    assertEquals("Comment", actualWithSchemeResult.comment());
    assertEquals('A', actualWithSchemeResult.ratingCode());
    assertEquals(1, actualWithSchemeResult.allocation().intValue());
    assertFalse(actualWithSchemeResult.isPrimary());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#withTaxonomyExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingItem#withTaxonomyExternalId(String)}
   */
  @Test
  @DisplayName("Test withTaxonomyExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingItem ImmutableBulkMeasurableRatingItem.withTaxonomyExternalId(String)"
  })
  void testWithTaxonomyExternalId() {
    // Arrange
    ImmutableBulkMeasurableRatingItem immutableBulkMeasurableRatingItem =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build();

    // Act
    ImmutableBulkMeasurableRatingItem actualWithTaxonomyExternalIdResult =
        immutableBulkMeasurableRatingItem.withTaxonomyExternalId("42");

    // Assert
    assertSame(immutableBulkMeasurableRatingItem, actualWithTaxonomyExternalIdResult);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#withTaxonomyExternalId(String)}.
   *
   * <ul>
   *   <li>Then return taxonomyExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingItem#withTaxonomyExternalId(String)}
   */
  @Test
  @DisplayName("Test withTaxonomyExternalId(String); then return taxonomyExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingItem ImmutableBulkMeasurableRatingItem.withTaxonomyExternalId(String)"
  })
  void testWithTaxonomyExternalId_thenReturnTaxonomyExternalIdIs42() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingItem actualWithTaxonomyExternalIdResult =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("taxonomyExternalId")
            .build()
            .withTaxonomyExternalId("42");

    // Assert
    assertEquals("42", actualWithTaxonomyExternalIdResult.taxonomyExternalId());
    assertEquals("Asset Code", actualWithTaxonomyExternalIdResult.assetCode());
    assertEquals("Comment", actualWithTaxonomyExternalIdResult.comment());
    assertEquals("Scheme", actualWithTaxonomyExternalIdResult.scheme());
    assertEquals('A', actualWithTaxonomyExternalIdResult.ratingCode());
    assertEquals(1, actualWithTaxonomyExternalIdResult.allocation().intValue());
    assertFalse(actualWithTaxonomyExternalIdResult.isPrimary());
  }
}
