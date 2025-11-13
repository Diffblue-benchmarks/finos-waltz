package org.finos.waltz.model.bulk_upload.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.allocation_scheme.ImmutableAllocationScheme;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.bulk_upload.measurable_rating.BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingValidationResult.Builder;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingValidationResult.Json;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.measurable.ImmutableMeasurable;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RagRating;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkMeasurableRatingValidationResultDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllRemovals(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then builder build removalCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRemovals(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllRemovals(Iterable); when ArrayList(); then builder build removalCount is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRemovals(Iterable)"})
  void testBuilderAddAllRemovals_whenArrayList_thenBuilderBuildRemovalCountIsZero() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidationResult.builder();

    // Act
    Builder actualAddAllRemovalsResult = builderResult.addAllRemovals(new ArrayList<>());

    // Assert
    assertEquals(0, builderResult.build().removalCount());
    assertSame(builderResult, actualAddAllRemovalsResult);
  }

  /**
   * Test Builder {@link Builder#addAllValidatedItems(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllValidatedItems(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllValidatedItems(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllValidatedItems(Iterable)"})
  void testBuilderAddAllValidatedItems_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidationResult.builder();

    // Act
    Builder actualAddAllValidatedItemsResult =
        builderResult.addAllValidatedItems(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllValidatedItemsResult);
  }

  /**
   * Test Builder {@link Builder#addRemovals(Tuple2)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addRemovals(Tuple2)}
   */
  @Test
  @DisplayName("Test Builder addRemovals(Tuple2) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRemovals(Tuple2)"})
  void testBuilderAddRemovalsWithElement() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidationResult.builder();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualAddRemovalsResult =
        builderResult.addRemovals(new Tuple2<>(immutableEntityReference, 1L));

    // Assert
    ImmutableBulkMeasurableRatingValidationResult immutableBulkMeasurableRatingValidationResult =
        builderResult.build();
    assertEquals(1, immutableBulkMeasurableRatingValidationResult.removals().size());
    assertEquals(1, immutableBulkMeasurableRatingValidationResult.removalCount());
    assertSame(builderResult, actualAddRemovalsResult);
  }

  /**
   * Test Builder {@link Builder#addRemovals(Tuple2[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addRemovals(Tuple2[])}
   */
  @Test
  @DisplayName("Test Builder addRemovals(Tuple2[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRemovals(Tuple2[])"})
  void testBuilderAddRemovalsWithElements() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidationResult.builder();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualAddRemovalsResult =
        builderResult.addRemovals(new Tuple2<>(immutableEntityReference, 1L));

    // Assert
    ImmutableBulkMeasurableRatingValidationResult immutableBulkMeasurableRatingValidationResult =
        builderResult.build();
    assertEquals(1, immutableBulkMeasurableRatingValidationResult.removals().size());
    assertEquals(1, immutableBulkMeasurableRatingValidationResult.removalCount());
    assertSame(builderResult, actualAddRemovalsResult);
  }

  /**
   * Test Builder {@link Builder#addValidatedItems(BulkMeasurableRatingValidatedItem)} with {@code
   * element}.
   *
   * <p>Method under test: {@link Builder#addValidatedItems(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder addValidatedItems(BulkMeasurableRatingValidatedItem) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addValidatedItems(BulkMeasurableRatingValidatedItem)"})
  void testBuilderAddValidatedItemsWithElement() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidationResult.builder();
    ImmutableBulkMeasurableRatingValidatedItem.Json element =
        new ImmutableBulkMeasurableRatingValidatedItem.Json();

    // Act
    Builder actualAddValidatedItemsResult = builderResult.addValidatedItems(element);

    // Assert
    List<BulkMeasurableRatingValidatedItem> validatedItemsResult =
        builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(element, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Test Builder {@link Builder#addValidatedItems(BulkMeasurableRatingValidatedItem[])} with {@code
   * elements}.
   *
   * <p>Method under test: {@link Builder#addValidatedItems(BulkMeasurableRatingValidatedItem[])}
   */
  @Test
  @DisplayName(
      "Test Builder addValidatedItems(BulkMeasurableRatingValidatedItem[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addValidatedItems(BulkMeasurableRatingValidatedItem[])"})
  void testBuilderAddValidatedItemsWithElements() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidationResult.builder();
    ImmutableBulkMeasurableRatingValidatedItem.Json json =
        new ImmutableBulkMeasurableRatingValidatedItem.Json();

    // Act
    Builder actualAddValidatedItemsResult = builderResult.addValidatedItems(json);

    // Assert
    List<BulkMeasurableRatingValidatedItem> validatedItemsResult =
        builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(json, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#error(BulkMeasurableRatingParseError)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidationResult Builder.build()",
    "Builder Builder.error(BulkMeasurableRatingParseError)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableBulkMeasurableRatingValidationResult.builder();
    ImmutableBulkMeasurableRatingParseError error =
        ImmutableBulkMeasurableRatingParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build();
    ImmutableBulkMeasurableRatingValidationResult
        actualImmutableBulkMeasurableRatingValidationResult =
            actualBuilderResult.error(error).build();

    // Assert
    assertEquals(0, actualImmutableBulkMeasurableRatingValidationResult.removalCount());
    assertTrue(actualImmutableBulkMeasurableRatingValidationResult.validatedItems().isEmpty());
    assertTrue(actualImmutableBulkMeasurableRatingValidationResult.removals().isEmpty());
    assertSame(error, actualImmutableBulkMeasurableRatingValidationResult.error());
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingValidationResult)}.
   *
   * <p>Method under test: {@link Builder#from(BulkMeasurableRatingValidationResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingValidationResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingValidationResult)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidationResult.builder();

    Builder builderResult2 = ImmutableBulkMeasurableRatingValidationResult.builder();
    ImmutableBulkMeasurableRatingValidationResult instance =
        builderResult2
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkMeasurableRatingValidationResult
        actualImmutableBulkMeasurableRatingValidationResult = builderResult.build();
    assertEquals(instance, actualImmutableBulkMeasurableRatingValidationResult);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#removals(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then builder build removalCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link Builder#removals(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder removals(Iterable); when ArrayList(); then builder build removalCount is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.removals(Iterable)"})
  void testBuilderRemovals_whenArrayList_thenBuilderBuildRemovalCountIsZero() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidationResult.builder();

    // Act
    Builder actualRemovalsResult = builderResult.removals(new ArrayList<>());

    // Assert
    assertEquals(0, builderResult.build().removalCount());
    assertSame(builderResult, actualRemovalsResult);
  }

  /**
   * Test Builder {@link Builder#validatedItems(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#validatedItems(Iterable)}
   */
  @Test
  @DisplayName("Test Builder validatedItems(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.validatedItems(Iterable)"})
  void testBuilderValidatedItems_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidationResult.builder();

    // Act
    Builder actualValidatedItemsResult = builderResult.validatedItems(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualValidatedItemsResult);
  }

  /**
   * Test {@link
   * ImmutableBulkMeasurableRatingValidationResult#copyOf(BulkMeasurableRatingValidationResult)}.
   *
   * <ul>
   *   <li>Then error return {@link ImmutableBulkMeasurableRatingParseError}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkMeasurableRatingValidationResult#copyOf(BulkMeasurableRatingValidationResult)}
   */
  @Test
  @DisplayName(
      "Test copyOf(BulkMeasurableRatingValidationResult); then error return ImmutableBulkMeasurableRatingParseError")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidationResult ImmutableBulkMeasurableRatingValidationResult.copyOf(BulkMeasurableRatingValidationResult)"
  })
  void testCopyOf_thenErrorReturnImmutableBulkMeasurableRatingParseError() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidationResult.builder();
    ImmutableBulkMeasurableRatingValidationResult instance =
        builderResult
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    // Act
    ImmutableBulkMeasurableRatingValidationResult actualCopyOfResult =
        ImmutableBulkMeasurableRatingValidationResult.copyOf(instance);

    // Assert
    BulkMeasurableRatingParseError errorResult = actualCopyOfResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertEquals("Not all who wander are lost", errorResult.message());
    assertEquals(0, actualCopyOfResult.removalCount());
    assertEquals(1, errorResult.column().intValue());
    assertEquals(2, errorResult.line().intValue());
    assertTrue(actualCopyOfResult.validatedItems().isEmpty());
    assertTrue(actualCopyOfResult.removals().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidationResult#equals(Object)}, and {@link
   * ImmutableBulkMeasurableRatingValidationResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkMeasurableRatingValidationResult#equals(Object)}
   *   <li>{@link ImmutableBulkMeasurableRatingValidationResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingValidationResult.equals(Object)",
    "int ImmutableBulkMeasurableRatingValidationResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidationResult.builder();
    ImmutableBulkMeasurableRatingValidationResult immutableBulkMeasurableRatingValidationResult =
        builderResult
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    Builder builderResult2 = ImmutableBulkMeasurableRatingValidationResult.builder();
    ImmutableBulkMeasurableRatingValidationResult immutableBulkMeasurableRatingValidationResult2 =
        builderResult2
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    // Act and Assert
    assertEquals(
        immutableBulkMeasurableRatingValidationResult,
        immutableBulkMeasurableRatingValidationResult2);
    assertEquals(
        immutableBulkMeasurableRatingValidationResult.hashCode(),
        immutableBulkMeasurableRatingValidationResult2.hashCode());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidationResult#equals(Object)}, and {@link
   * ImmutableBulkMeasurableRatingValidationResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkMeasurableRatingValidationResult#equals(Object)}
   *   <li>{@link ImmutableBulkMeasurableRatingValidationResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingValidationResult.equals(Object)",
    "int ImmutableBulkMeasurableRatingValidationResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidationResult.builder();
    ImmutableBulkMeasurableRatingValidationResult immutableBulkMeasurableRatingValidationResult =
        builderResult
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    // Act and Assert
    assertEquals(
        immutableBulkMeasurableRatingValidationResult,
        immutableBulkMeasurableRatingValidationResult);
    int expectedHashCodeResult = immutableBulkMeasurableRatingValidationResult.hashCode();
    assertEquals(expectedHashCodeResult, immutableBulkMeasurableRatingValidationResult.hashCode());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingValidationResult.equals(Object)",
    "int ImmutableBulkMeasurableRatingValidationResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidationResult.builder();

    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult2 =
        ImmutableBulkMeasurableRatingValidatedItem.builder();

    ImmutableBulkMeasurableRatingValidatedItem.Builder allocationSchemeResult =
        builderResult2.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableBulkMeasurableRatingValidatedItem.Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    ImmutableBulkMeasurableRatingValidatedItem.Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    ImmutableBulkMeasurableRatingValidatedItem.Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());
    builderResult.addValidatedItems(
        parsedItemResult
            .ratingSchemeItem(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build());
    ImmutableBulkMeasurableRatingValidationResult immutableBulkMeasurableRatingValidationResult =
        builderResult
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    Builder builderResult3 = ImmutableBulkMeasurableRatingValidationResult.builder();

    // Act and Assert
    assertNotEquals(
        immutableBulkMeasurableRatingValidationResult,
        builderResult3
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingValidationResult.equals(Object)",
    "int ImmutableBulkMeasurableRatingValidationResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidationResult.builder();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    builderResult.addRemovals(new Tuple2<>(immutableEntityReference, 1L));
    ImmutableBulkMeasurableRatingValidationResult immutableBulkMeasurableRatingValidationResult =
        builderResult
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    Builder builderResult2 = ImmutableBulkMeasurableRatingValidationResult.builder();

    // Act and Assert
    assertNotEquals(
        immutableBulkMeasurableRatingValidationResult,
        builderResult2
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingValidationResult.equals(Object)",
    "int ImmutableBulkMeasurableRatingValidationResult.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidationResult.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingValidationResult.equals(Object)",
    "int ImmutableBulkMeasurableRatingValidationResult.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidationResult.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build(),
        "Different type to ImmutableBulkMeasurableRatingValidationResult");
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidationResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       ImmutableBulkMeasurableRatingValidatedItem.Json} (default constructor).
   *   <li>Then return validatedItems first is {@link
   *       ImmutableBulkMeasurableRatingValidatedItem.Json} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add Json (default constructor); then return validatedItems first is Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidationResult ImmutableBulkMeasurableRatingValidationResult.fromJson(Json)"
  })
  void testFromJson_givenArrayListAddJson_thenReturnValidatedItemsFirstIsJson() {
    // Arrange
    ArrayList<BulkMeasurableRatingValidatedItem> validatedItems = new ArrayList<>();
    ImmutableBulkMeasurableRatingValidatedItem.Json json =
        new ImmutableBulkMeasurableRatingValidatedItem.Json();
    validatedItems.add(json);

    LinkedHashSet<Tuple2<EntityReference, Long>> removals = new LinkedHashSet<>();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    removals.add(new Tuple2<>(immutableEntityReference, 1L));

    Json json2 = new Json();
    json2.setValidatedItems(validatedItems);
    json2.setError(new ImmutableBulkMeasurableRatingParseError.Json());
    json2.setRemovals(removals);

    // Act
    ImmutableBulkMeasurableRatingValidationResult actualFromJsonResult =
        ImmutableBulkMeasurableRatingValidationResult.fromJson(json2);

    // Assert
    List<BulkMeasurableRatingValidatedItem> validatedItemsResult =
        actualFromJsonResult.validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(json, validatedItemsResult.get(0));
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidationResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) ValidatedItems is {@code null}.
   *   <li>Then return removals size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) ValidatedItems is 'null'; then return removals size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidationResult ImmutableBulkMeasurableRatingValidationResult.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonValidatedItemsIsNull_thenReturnRemovalsSizeIsOne() {
    // Arrange
    LinkedHashSet<Tuple2<EntityReference, Long>> removals = new LinkedHashSet<>();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    removals.add(new Tuple2<>(immutableEntityReference, 1L));

    Json json = new Json();
    json.setValidatedItems(null);
    json.setError(new ImmutableBulkMeasurableRatingParseError.Json());
    json.setRemovals(removals);

    // Act
    ImmutableBulkMeasurableRatingValidationResult actualFromJsonResult =
        ImmutableBulkMeasurableRatingValidationResult.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.removals().size());
    assertEquals(1, actualFromJsonResult.removalCount());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidationResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return removalCount is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return removalCount is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidationResult ImmutableBulkMeasurableRatingValidationResult.fromJson(Json)"
  })
  void testFromJson_thenReturnRemovalCountIsTwo() {
    // Arrange
    LinkedHashSet<Tuple2<EntityReference, Long>> removals = new LinkedHashSet<>();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    removals.add(new Tuple2<>(immutableEntityReference, 1L));
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    removals.add(new Tuple2<>(immutableEntityReference2, 1L));

    Json json = new Json();
    json.setValidatedItems(null);
    json.setError(new ImmutableBulkMeasurableRatingParseError.Json());
    json.setRemovals(removals);

    // Act
    ImmutableBulkMeasurableRatingValidationResult actualFromJsonResult =
        ImmutableBulkMeasurableRatingValidationResult.fromJson(json);

    // Assert
    assertEquals(2, actualFromJsonResult.removalCount());
    assertEquals(removals, actualFromJsonResult.removals());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidationResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return validatedItems size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return validatedItems size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidationResult ImmutableBulkMeasurableRatingValidationResult.fromJson(Json)"
  })
  void testFromJson_thenReturnValidatedItemsSizeIsTwo() {
    // Arrange
    ArrayList<BulkMeasurableRatingValidatedItem> validatedItems = new ArrayList<>();

    ImmutableBulkMeasurableRatingValidatedItem.Builder builderResult =
        ImmutableBulkMeasurableRatingValidatedItem.builder();

    ImmutableBulkMeasurableRatingValidatedItem.Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableBulkMeasurableRatingValidatedItem.Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    ImmutableBulkMeasurableRatingValidatedItem.Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    ImmutableBulkMeasurableRatingValidatedItem.Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());
    validatedItems.add(
        parsedItemResult
            .ratingSchemeItem(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build());
    ImmutableBulkMeasurableRatingValidatedItem.Json json =
        new ImmutableBulkMeasurableRatingValidatedItem.Json();
    validatedItems.add(json);

    LinkedHashSet<Tuple2<EntityReference, Long>> removals = new LinkedHashSet<>();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    removals.add(new Tuple2<>(immutableEntityReference, 1L));

    Json json2 = new Json();
    json2.setValidatedItems(validatedItems);
    json2.setError(new ImmutableBulkMeasurableRatingParseError.Json());
    json2.setRemovals(removals);

    // Act
    ImmutableBulkMeasurableRatingValidationResult actualFromJsonResult =
        ImmutableBulkMeasurableRatingValidationResult.fromJson(json2);

    // Assert
    List<BulkMeasurableRatingValidatedItem> validatedItemsResult =
        actualFromJsonResult.validatedItems();
    assertEquals(2, validatedItemsResult.size());
    BulkMeasurableRatingValidatedItem getResult = validatedItemsResult.get(0);
    assertTrue(getResult.allocationScheme() instanceof ImmutableAllocationScheme);
    assertTrue(getResult.application() instanceof ImmutableApplication);
    assertTrue(getResult.parsedItem() instanceof ImmutableBulkMeasurableRatingItem);
    assertTrue(getResult instanceof ImmutableBulkMeasurableRatingValidatedItem);
    assertTrue(getResult.measurable() instanceof ImmutableMeasurable);
    assertTrue(getResult.ratingSchemeItem() instanceof ImmutableRatingSchemeItem);
    assertEquals(ChangeOperation.ADD, getResult.changeOperation());
    assertTrue(getResult.changedFields().isEmpty());
    assertTrue(getResult.errors().isEmpty());
    assertSame(json, validatedItemsResult.get(1));
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidationResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Removals is {@code null}.
   *   <li>Then validatedItems first return {@link ImmutableBulkMeasurableRatingValidatedItem.Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Removals is 'null'; then validatedItems first return Json")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidationResult ImmutableBulkMeasurableRatingValidationResult.fromJson(Json)"
  })
  void testFromJson_whenJsonRemovalsIsNull_thenValidatedItemsFirstReturnJson() {
    // Arrange
    ArrayList<BulkMeasurableRatingValidatedItem> validatedItems = new ArrayList<>();
    ImmutableBulkMeasurableRatingValidatedItem.Json json =
        new ImmutableBulkMeasurableRatingValidatedItem.Json();
    validatedItems.add(json);

    Json json2 = new Json();
    json2.setValidatedItems(validatedItems);
    json2.setError(new ImmutableBulkMeasurableRatingParseError.Json());
    json2.setRemovals(null);

    // Act
    ImmutableBulkMeasurableRatingValidationResult actualFromJsonResult =
        ImmutableBulkMeasurableRatingValidationResult.fromJson(json2);

    // Assert
    List<BulkMeasurableRatingValidatedItem> validatedItemsResult =
        actualFromJsonResult.validatedItems();
    assertEquals(1, validatedItemsResult.size());
    BulkMeasurableRatingValidatedItem getResult = validatedItemsResult.get(0);
    assertTrue(getResult instanceof ImmutableBulkMeasurableRatingValidatedItem.Json);
    assertSame(
        json.errors, ((ImmutableBulkMeasurableRatingValidatedItem.Json) getResult).changedFields);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidationResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return error is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return error is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidationResult ImmutableBulkMeasurableRatingValidationResult.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnErrorIsNull() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingValidationResult actualFromJsonResult =
        ImmutableBulkMeasurableRatingValidationResult.fromJson(new Json());

    // Assert
    assertNull(actualFromJsonResult.error());
    assertEquals(0, actualFromJsonResult.removalCount());
    assertTrue(actualFromJsonResult.validatedItems().isEmpty());
    assertTrue(actualFromJsonResult.removals().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkMeasurableRatingValidationResult#toString()}
   *   <li>{@link ImmutableBulkMeasurableRatingValidationResult#error()}
   *   <li>{@link ImmutableBulkMeasurableRatingValidationResult#removalCount()}
   *   <li>{@link ImmutableBulkMeasurableRatingValidationResult#removals()}
   *   <li>{@link ImmutableBulkMeasurableRatingValidationResult#validatedItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkMeasurableRatingParseError ImmutableBulkMeasurableRatingValidationResult.error()",
    "int ImmutableBulkMeasurableRatingValidationResult.removalCount()",
    "Set ImmutableBulkMeasurableRatingValidationResult.removals()",
    "String ImmutableBulkMeasurableRatingValidationResult.toString()",
    "List ImmutableBulkMeasurableRatingValidationResult.validatedItems()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidationResult.builder();
    ImmutableBulkMeasurableRatingValidationResult immutableBulkMeasurableRatingValidationResult =
        builderResult
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableBulkMeasurableRatingValidationResult.toString();
    BulkMeasurableRatingParseError actualErrorResult =
        immutableBulkMeasurableRatingValidationResult.error();
    int actualRemovalCountResult = immutableBulkMeasurableRatingValidationResult.removalCount();
    Set<Tuple2<EntityReference, Long>> actualRemovalsResult =
        immutableBulkMeasurableRatingValidationResult.removals();

    // Assert
    assertTrue(actualErrorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertEquals(
        "BulkMeasurableRatingValidationResult{validatedItems=[], error=BulkMeasurableRatingParseError{message=Not"
            + " all who wander are lost, line=2, column=1}, removalCount=0, removals=[]}",
        actualToStringResult);
    assertEquals(0, actualRemovalCountResult);
    assertTrue(immutableBulkMeasurableRatingValidationResult.validatedItems().isEmpty());
    assertTrue(actualRemovalsResult.isEmpty());
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
    assertNull(actualJson.error);
    assertTrue(actualJson.validatedItems.isEmpty());
    assertTrue(actualJson.removals.isEmpty());
  }

  /**
   * Test Json {@link Json#removalCount()}.
   *
   * <p>Method under test: {@link Json#removalCount()}
   */
  @Test
  @DisplayName("Test Json removalCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.removalCount()"})
  void testJsonRemovalCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().removalCount());
  }

  /**
   * Test Json {@link Json#removals()}.
   *
   * <p>Method under test: {@link Json#removals()}
   */
  @Test
  @DisplayName("Test Json removals()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.removals()"})
  void testJsonRemovals() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().removals());
  }

  /**
   * Test Json {@link Json#validatedItems()}.
   *
   * <p>Method under test: {@link Json#validatedItems()}
   */
  @Test
  @DisplayName("Test Json validatedItems()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.validatedItems()"})
  void testJsonValidatedItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().validatedItems());
  }

  /**
   * Test {@link
   * ImmutableBulkMeasurableRatingValidationResult#withError(BulkMeasurableRatingParseError)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkMeasurableRatingValidationResult#withError(BulkMeasurableRatingParseError)}
   */
  @Test
  @DisplayName("Test withError(BulkMeasurableRatingParseError)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidationResult ImmutableBulkMeasurableRatingValidationResult.withError(BulkMeasurableRatingParseError)"
  })
  void testWithError() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidationResult.builder();
    ImmutableBulkMeasurableRatingValidationResult immutableBulkMeasurableRatingValidationResult =
        builderResult
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    // Act
    ImmutableBulkMeasurableRatingValidationResult actualWithErrorResult =
        immutableBulkMeasurableRatingValidationResult.withError(
            ImmutableBulkMeasurableRatingParseError.builder()
                .column(1)
                .line(2)
                .message("Not all who wander are lost")
                .build());

    // Assert
    assertEquals(immutableBulkMeasurableRatingValidationResult, actualWithErrorResult);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidationResult#withRemovals(Tuple2[])} with {@code
   * Tuple2[]}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkMeasurableRatingValidationResult#withRemovals(Tuple2[])}
   */
  @Test
  @DisplayName("Test withRemovals(Tuple2[]) with 'Tuple2[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidationResult ImmutableBulkMeasurableRatingValidationResult.withRemovals(Tuple2[])"
  })
  void testWithRemovalsWithTuple2() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidationResult.builder();
    ImmutableBulkMeasurableRatingValidationResult immutableBulkMeasurableRatingValidationResult =
        builderResult
            .error(
                ImmutableBulkMeasurableRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableBulkMeasurableRatingValidationResult actualWithRemovalsResult =
        immutableBulkMeasurableRatingValidationResult.withRemovals(
            new Tuple2<>(immutableEntityReference, 1L));

    // Assert
    BulkMeasurableRatingParseError errorResult = actualWithRemovalsResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertEquals("Not all who wander are lost", errorResult.message());
    assertEquals(1, errorResult.column().intValue());
    assertEquals(1, actualWithRemovalsResult.removals().size());
    assertEquals(1, actualWithRemovalsResult.removalCount());
    assertEquals(2, errorResult.line().intValue());
    assertTrue(actualWithRemovalsResult.validatedItems().isEmpty());
  }
}
