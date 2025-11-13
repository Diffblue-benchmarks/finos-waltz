package org.finos.waltz.model.assessment_rating.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.assessment_rating.bulk_upload.AssessmentRatingParsedResult.AssessmentRatingParseError;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmentRatingValidationResult.Builder;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmentRatingValidationResult.Json;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingValidationResultDiffblueTest {
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
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();

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
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();

    // Act
    Builder actualAddAllValidatedItemsResult =
        builderResult.addAllValidatedItems(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllValidatedItemsResult);
  }

  /**
   * Test Builder {@link Builder#addRemovals(Tuple2)} with {@code element}.
   *
   * <ul>
   *   <li>Then builder build removals size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addRemovals(Tuple2)}
   */
  @Test
  @DisplayName(
      "Test Builder addRemovals(Tuple2) with 'element'; then builder build removals size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRemovals(Tuple2)"})
  void testBuilderAddRemovalsWithElement_thenBuilderBuildRemovalsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
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
    ImmutableAssessmentRatingValidationResult immutableAssessmentRatingValidationResult =
        builderResult.build();
    assertEquals(1, immutableAssessmentRatingValidationResult.removals().size());
    assertEquals(1, immutableAssessmentRatingValidationResult.removalCount());
    assertSame(builderResult, actualAddRemovalsResult);
  }

  /**
   * Test Builder {@link Builder#addRemovals(Tuple2[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then builder build removals size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addRemovals(Tuple2[])}
   */
  @Test
  @DisplayName(
      "Test Builder addRemovals(Tuple2[]) with 'elements'; then builder build removals size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRemovals(Tuple2[])"})
  void testBuilderAddRemovalsWithElements_thenBuilderBuildRemovalsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
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
    ImmutableAssessmentRatingValidationResult immutableAssessmentRatingValidationResult =
        builderResult.build();
    assertEquals(1, immutableAssessmentRatingValidationResult.removals().size());
    assertEquals(1, immutableAssessmentRatingValidationResult.removalCount());
    assertSame(builderResult, actualAddRemovalsResult);
  }

  /**
   * Test Builder {@link Builder#addValidatedItems(AssessmentRatingValidatedItem)} with {@code
   * element}.
   *
   * <ul>
   *   <li>Then builder build validatedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addValidatedItems(AssessmentRatingValidatedItem)}
   */
  @Test
  @DisplayName(
      "Test Builder addValidatedItems(AssessmentRatingValidatedItem) with 'element'; then builder build validatedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addValidatedItems(AssessmentRatingValidatedItem)"})
  void testBuilderAddValidatedItemsWithElement_thenBuilderBuildValidatedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingValidatedItem.Json element =
        new ImmutableAssessmentRatingValidatedItem.Json();

    // Act
    Builder actualAddValidatedItemsResult = builderResult.addValidatedItems(element);

    // Assert
    List<AssessmentRatingValidatedItem> validatedItemsResult =
        builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(element, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Test Builder {@link Builder#addValidatedItems(AssessmentRatingValidatedItem[])} with {@code
   * elements}.
   *
   * <ul>
   *   <li>Then builder build validatedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addValidatedItems(AssessmentRatingValidatedItem[])}
   */
  @Test
  @DisplayName(
      "Test Builder addValidatedItems(AssessmentRatingValidatedItem[]) with 'elements'; then builder build validatedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addValidatedItems(AssessmentRatingValidatedItem[])"})
  void testBuilderAddValidatedItemsWithElements_thenBuilderBuildValidatedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingValidatedItem.Json json =
        new ImmutableAssessmentRatingValidatedItem.Json();

    // Act
    Builder actualAddValidatedItemsResult = builderResult.addValidatedItems(json);

    // Assert
    List<AssessmentRatingValidatedItem> validatedItemsResult =
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
   *   <li>{@link Builder#error(AssessmentRatingParseError)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidationResult Builder.build()",
    "Builder Builder.error(AssessmentRatingParseError)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingParseError error =
        ImmutableAssessmentRatingParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build();
    ImmutableAssessmentRatingValidationResult actualImmutableAssessmentRatingValidationResult =
        actualBuilderResult.error(error).build();

    // Assert
    assertEquals(0, actualImmutableAssessmentRatingValidationResult.removalCount());
    assertTrue(actualImmutableAssessmentRatingValidationResult.validatedItems().isEmpty());
    assertTrue(actualImmutableAssessmentRatingValidationResult.removals().isEmpty());
    assertSame(error, actualImmutableAssessmentRatingValidationResult.error());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingValidationResult)}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingValidationResult)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingValidationResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingValidationResult)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();

    Builder builderResult2 = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingValidationResult instance =
        builderResult2
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentRatingValidationResult actualImmutableAssessmentRatingValidationResult =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRatingValidationResult);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingValidationResult)}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingValidationResult)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingValidationResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingValidationResult)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();

    Builder builderResult2 = ImmutableAssessmentRatingValidationResult.builder();

    ImmutableAssessmentRatingValidatedItem.Builder changeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    ImmutableAssessmentRatingValidatedItem.Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableAssessmentRatingValidatedItem.Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());
    builderResult2.addValidatedItems(
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

    // Act and Assert
    List<AssessmentRatingValidatedItem> validatedItemsResult =
        builderResult
            .from(
                builderResult2
                    .error(
                        ImmutableAssessmentRatingParseError.builder()
                            .column(1)
                            .line(2)
                            .message("Not all who wander are lost")
                            .build())
                    .build())
            .build()
            .validatedItems();
    assertEquals(1, validatedItemsResult.size());
    AssessmentRatingValidatedItem getResult = validatedItemsResult.get(0);
    assertTrue(getResult.parsedItem() instanceof ImmutableAssessmentRatingParsedItem);
    assertTrue(getResult instanceof ImmutableAssessmentRatingValidatedItem);
    assertEquals(ChangeOperation.ADD, getResult.changeOperation());
    assertTrue(getResult.changedFields().isEmpty());
    assertTrue(getResult.errors().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingValidationResult)}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingValidationResult)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingValidationResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingValidationResult)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();

    Builder builderResult2 = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Tuple2<EntityReference, Long> element = new Tuple2<>(immutableEntityReference, 1L);
    builderResult2.addRemovals(element);

    ImmutableAssessmentRatingValidatedItem.Builder changeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    ImmutableAssessmentRatingValidatedItem.Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableAssessmentRatingValidatedItem.Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());
    builderResult2.addValidatedItems(
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

    // Act and Assert
    ImmutableAssessmentRatingValidationResult immutableAssessmentRatingValidationResult =
        builderResult
            .from(
                builderResult2
                    .error(
                        ImmutableAssessmentRatingParseError.builder()
                            .column(1)
                            .line(2)
                            .message("Not all who wander are lost")
                            .build())
                    .build())
            .build();
    List<AssessmentRatingValidatedItem> validatedItemsResult =
        immutableAssessmentRatingValidationResult.validatedItems();
    assertEquals(1, validatedItemsResult.size());
    AssessmentRatingValidatedItem getResult = validatedItemsResult.get(0);
    EntityReference entityKindReferenceResult2 = getResult.entityKindReference();
    assertTrue(entityKindReferenceResult2 instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableAssessmentRatingValidatedItem);
    RatingSchemeItem ratingSchemeItemResult = getResult.ratingSchemeItem();
    assertTrue(ratingSchemeItemResult instanceof ImmutableRatingSchemeItem);
    assertEquals(1, immutableAssessmentRatingValidationResult.removals().size());
    assertEquals(1, immutableAssessmentRatingValidationResult.removalCount());
    assertEquals(element.v1, entityKindReferenceResult2);
    Long expectedRatingSchemeIdResult = element.v2;
    assertSame(expectedRatingSchemeIdResult, ratingSchemeItemResult.ratingSchemeId());
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
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();

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
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();

    // Act
    Builder actualValidatedItemsResult = builderResult.validatedItems(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualValidatedItemsResult);
  }

  /**
   * Test {@link
   * ImmutableAssessmentRatingValidationResult#copyOf(AssessmentRatingValidationResult)}.
   *
   * <ul>
   *   <li>Then error return {@link ImmutableAssessmentRatingParseError}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingValidationResult#copyOf(AssessmentRatingValidationResult)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AssessmentRatingValidationResult); then error return ImmutableAssessmentRatingParseError")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidationResult ImmutableAssessmentRatingValidationResult.copyOf(AssessmentRatingValidationResult)"
  })
  void testCopyOf_thenErrorReturnImmutableAssessmentRatingParseError() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingValidationResult instance =
        builderResult
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    // Act
    ImmutableAssessmentRatingValidationResult actualCopyOfResult =
        ImmutableAssessmentRatingValidationResult.copyOf(instance);

    // Assert
    AssessmentRatingParseError errorResult = actualCopyOfResult.error();
    assertTrue(errorResult instanceof ImmutableAssessmentRatingParseError);
    assertEquals("Not all who wander are lost", errorResult.message());
    assertEquals(0, actualCopyOfResult.removalCount());
    assertEquals(1, errorResult.column().intValue());
    assertEquals(2, errorResult.line().intValue());
    assertTrue(actualCopyOfResult.validatedItems().isEmpty());
    assertTrue(actualCopyOfResult.removals().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#equals(Object)}, and {@link
   * ImmutableAssessmentRatingValidationResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingValidationResult#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingValidationResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingValidationResult.equals(Object)",
    "int ImmutableAssessmentRatingValidationResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingValidationResult immutableAssessmentRatingValidationResult =
        builderResult
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    Builder builderResult2 = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingValidationResult immutableAssessmentRatingValidationResult2 =
        builderResult2
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    // Act and Assert
    assertEquals(
        immutableAssessmentRatingValidationResult, immutableAssessmentRatingValidationResult2);
    assertEquals(
        immutableAssessmentRatingValidationResult.hashCode(),
        immutableAssessmentRatingValidationResult2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#equals(Object)}, and {@link
   * ImmutableAssessmentRatingValidationResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingValidationResult#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingValidationResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingValidationResult.equals(Object)",
    "int ImmutableAssessmentRatingValidationResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingValidationResult immutableAssessmentRatingValidationResult =
        builderResult
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    // Act and Assert
    assertEquals(
        immutableAssessmentRatingValidationResult, immutableAssessmentRatingValidationResult);
    int expectedHashCodeResult = immutableAssessmentRatingValidationResult.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssessmentRatingValidationResult.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingValidationResult.equals(Object)",
    "int ImmutableAssessmentRatingValidationResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();

    ImmutableAssessmentRatingValidatedItem.Builder changeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    ImmutableAssessmentRatingValidatedItem.Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableAssessmentRatingValidatedItem.Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
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
    ImmutableAssessmentRatingValidationResult immutableAssessmentRatingValidationResult =
        builderResult
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    Builder builderResult2 = ImmutableAssessmentRatingValidationResult.builder();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingValidationResult,
        builderResult2
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingValidationResult.equals(Object)",
    "int ImmutableAssessmentRatingValidationResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
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
    ImmutableAssessmentRatingValidationResult immutableAssessmentRatingValidationResult =
        builderResult
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    Builder builderResult2 = ImmutableAssessmentRatingValidationResult.builder();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingValidationResult,
        builderResult2
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingValidationResult.equals(Object)",
    "int ImmutableAssessmentRatingValidationResult.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingValidationResult.equals(Object)",
    "int ImmutableAssessmentRatingValidationResult.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build(),
        "Different type to ImmutableAssessmentRatingValidationResult");
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       ImmutableAssessmentRatingValidatedItem.Json} (default constructor).
   *   <li>Then return validatedItems first is {@link ImmutableAssessmentRatingValidatedItem.Json}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add Json (default constructor); then return validatedItems first is Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidationResult ImmutableAssessmentRatingValidationResult.fromJson(Json)"
  })
  void testFromJson_givenArrayListAddJson_thenReturnValidatedItemsFirstIsJson() {
    // Arrange
    ArrayList<AssessmentRatingValidatedItem> validatedItems = new ArrayList<>();
    ImmutableAssessmentRatingValidatedItem.Json json =
        new ImmutableAssessmentRatingValidatedItem.Json();
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
    json2.setError(new ImmutableAssessmentRatingParseError.Json());
    json2.setRemovals(removals);

    // Act
    ImmutableAssessmentRatingValidationResult actualFromJsonResult =
        ImmutableAssessmentRatingValidationResult.fromJson(json2);

    // Assert
    List<AssessmentRatingValidatedItem> validatedItemsResult =
        actualFromJsonResult.validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(json, validatedItemsResult.get(0));
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) ValidatedItems is {@code null}.
   *   <li>Then return removals size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) ValidatedItems is 'null'; then return removals size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidationResult ImmutableAssessmentRatingValidationResult.fromJson(Json)"
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
    json.setError(new ImmutableAssessmentRatingParseError.Json());
    json.setRemovals(removals);

    // Act
    ImmutableAssessmentRatingValidationResult actualFromJsonResult =
        ImmutableAssessmentRatingValidationResult.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.removals().size());
    assertEquals(1, actualFromJsonResult.removalCount());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return removalCount is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return removalCount is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidationResult ImmutableAssessmentRatingValidationResult.fromJson(Json)"
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
    json.setError(new ImmutableAssessmentRatingParseError.Json());
    json.setRemovals(removals);

    // Act
    ImmutableAssessmentRatingValidationResult actualFromJsonResult =
        ImmutableAssessmentRatingValidationResult.fromJson(json);

    // Assert
    assertEquals(2, actualFromJsonResult.removalCount());
    assertEquals(removals, actualFromJsonResult.removals());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return validatedItems size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return validatedItems size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidationResult ImmutableAssessmentRatingValidationResult.fromJson(Json)"
  })
  void testFromJson_thenReturnValidatedItemsSizeIsTwo() {
    // Arrange
    ArrayList<AssessmentRatingValidatedItem> validatedItems = new ArrayList<>();

    ImmutableAssessmentRatingValidatedItem.Builder changeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    ImmutableAssessmentRatingValidatedItem.Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableAssessmentRatingValidatedItem.Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
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
    ImmutableAssessmentRatingValidatedItem.Json json =
        new ImmutableAssessmentRatingValidatedItem.Json();
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
    Tuple2<EntityReference, Long> tuple2 = new Tuple2<>(immutableEntityReference, 1L);
    removals.add(tuple2);

    Json json2 = new Json();
    json2.setValidatedItems(validatedItems);
    json2.setError(new ImmutableAssessmentRatingParseError.Json());
    json2.setRemovals(removals);

    // Act
    ImmutableAssessmentRatingValidationResult actualFromJsonResult =
        ImmutableAssessmentRatingValidationResult.fromJson(json2);

    // Assert
    List<AssessmentRatingValidatedItem> validatedItemsResult =
        actualFromJsonResult.validatedItems();
    assertEquals(2, validatedItemsResult.size());
    AssessmentRatingValidatedItem getResult = validatedItemsResult.get(0);
    EntityReference entityKindReferenceResult2 = getResult.entityKindReference();
    assertTrue(entityKindReferenceResult2 instanceof ImmutableEntityReference);
    assertTrue(getResult.parsedItem() instanceof ImmutableAssessmentRatingParsedItem);
    assertTrue(getResult instanceof ImmutableAssessmentRatingValidatedItem);
    assertTrue(getResult.ratingSchemeItem() instanceof ImmutableRatingSchemeItem);
    assertEquals(ChangeOperation.ADD, getResult.changeOperation());
    assertTrue(getResult.changedFields().isEmpty());
    assertTrue(getResult.errors().isEmpty());
    assertEquals(tuple2.v1, entityKindReferenceResult2);
    assertSame(json, validatedItemsResult.get(1));
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Removals is {@code null}.
   *   <li>Then validatedItems first return {@link ImmutableAssessmentRatingValidatedItem.Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Removals is 'null'; then validatedItems first return Json")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidationResult ImmutableAssessmentRatingValidationResult.fromJson(Json)"
  })
  void testFromJson_whenJsonRemovalsIsNull_thenValidatedItemsFirstReturnJson() {
    // Arrange
    ArrayList<AssessmentRatingValidatedItem> validatedItems = new ArrayList<>();
    ImmutableAssessmentRatingValidatedItem.Json json =
        new ImmutableAssessmentRatingValidatedItem.Json();
    validatedItems.add(json);

    Json json2 = new Json();
    json2.setValidatedItems(validatedItems);
    json2.setError(new ImmutableAssessmentRatingParseError.Json());
    json2.setRemovals(null);

    // Act
    ImmutableAssessmentRatingValidationResult actualFromJsonResult =
        ImmutableAssessmentRatingValidationResult.fromJson(json2);

    // Assert
    List<AssessmentRatingValidatedItem> validatedItemsResult =
        actualFromJsonResult.validatedItems();
    assertEquals(1, validatedItemsResult.size());
    AssessmentRatingValidatedItem getResult = validatedItemsResult.get(0);
    assertTrue(getResult instanceof ImmutableAssessmentRatingValidatedItem.Json);
    assertSame(
        json.errors, ((ImmutableAssessmentRatingValidatedItem.Json) getResult).changedFields);
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return error is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return error is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidationResult ImmutableAssessmentRatingValidationResult.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnErrorIsNull() {
    // Arrange and Act
    ImmutableAssessmentRatingValidationResult actualFromJsonResult =
        ImmutableAssessmentRatingValidationResult.fromJson(new Json());

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
   *   <li>{@link ImmutableAssessmentRatingValidationResult#toString()}
   *   <li>{@link ImmutableAssessmentRatingValidationResult#error()}
   *   <li>{@link ImmutableAssessmentRatingValidationResult#removalCount()}
   *   <li>{@link ImmutableAssessmentRatingValidationResult#removals()}
   *   <li>{@link ImmutableAssessmentRatingValidationResult#validatedItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingParseError ImmutableAssessmentRatingValidationResult.error()",
    "int ImmutableAssessmentRatingValidationResult.removalCount()",
    "Set ImmutableAssessmentRatingValidationResult.removals()",
    "String ImmutableAssessmentRatingValidationResult.toString()",
    "List ImmutableAssessmentRatingValidationResult.validatedItems()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingValidationResult immutableAssessmentRatingValidationResult =
        builderResult
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableAssessmentRatingValidationResult.toString();
    AssessmentRatingParseError actualErrorResult =
        immutableAssessmentRatingValidationResult.error();
    int actualRemovalCountResult = immutableAssessmentRatingValidationResult.removalCount();
    Set<Tuple2<EntityReference, Long>> actualRemovalsResult =
        immutableAssessmentRatingValidationResult.removals();

    // Assert
    assertTrue(actualErrorResult instanceof ImmutableAssessmentRatingParseError);
    assertEquals(
        "AssessmentRatingValidationResult{validatedItems=[], error=AssessmentRatingParseError{message=Not all"
            + " who wander are lost, line=2, column=1}, removalCount=0, removals=[]}",
        actualToStringResult);
    assertEquals(0, actualRemovalCountResult);
    assertTrue(immutableAssessmentRatingValidationResult.validatedItems().isEmpty());
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
  @MethodsUnderTest({"AssessmentRatingParseError Json.error()"})
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
   * Test {@link ImmutableAssessmentRatingValidationResult#withError(AssessmentRatingParseError)}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingValidationResult#withError(AssessmentRatingParseError)}
   */
  @Test
  @DisplayName("Test withError(AssessmentRatingParseError)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidationResult ImmutableAssessmentRatingValidationResult.withError(AssessmentRatingParseError)"
  })
  void testWithError() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingValidationResult immutableAssessmentRatingValidationResult =
        builderResult
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    // Act
    ImmutableAssessmentRatingValidationResult actualWithErrorResult =
        immutableAssessmentRatingValidationResult.withError(
            ImmutableAssessmentRatingParseError.builder()
                .column(1)
                .line(2)
                .message("Not all who wander are lost")
                .build());

    // Assert
    assertEquals(immutableAssessmentRatingValidationResult, actualWithErrorResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidationResult#withRemovals(Tuple2[])} with {@code
   * Tuple2[]}.
   *
   * <ul>
   *   <li>Then error return {@link ImmutableAssessmentRatingParseError}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingValidationResult#withRemovals(Tuple2[])}
   */
  @Test
  @DisplayName(
      "Test withRemovals(Tuple2[]) with 'Tuple2[]'; then error return ImmutableAssessmentRatingParseError")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidationResult ImmutableAssessmentRatingValidationResult.withRemovals(Tuple2[])"
  })
  void testWithRemovalsWithTuple2_thenErrorReturnImmutableAssessmentRatingParseError() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingValidationResult immutableAssessmentRatingValidationResult =
        builderResult
            .error(
                ImmutableAssessmentRatingParseError.builder()
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
    ImmutableAssessmentRatingValidationResult actualWithRemovalsResult =
        immutableAssessmentRatingValidationResult.withRemovals(
            new Tuple2<>(immutableEntityReference, 1L));

    // Assert
    AssessmentRatingParseError errorResult = actualWithRemovalsResult.error();
    assertTrue(errorResult instanceof ImmutableAssessmentRatingParseError);
    assertEquals("Not all who wander are lost", errorResult.message());
    assertEquals(1, errorResult.column().intValue());
    assertEquals(1, actualWithRemovalsResult.removals().size());
    assertEquals(1, actualWithRemovalsResult.removalCount());
    assertEquals(2, errorResult.line().intValue());
    assertTrue(actualWithRemovalsResult.validatedItems().isEmpty());
  }

  /**
   * Test {@link
   * ImmutableAssessmentRatingValidationResult#withValidatedItems(AssessmentRatingValidatedItem[])}
   * with {@code AssessmentRatingValidatedItem[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingValidationResult#withValidatedItems(AssessmentRatingValidatedItem[])}
   */
  @Test
  @DisplayName(
      "Test withValidatedItems(AssessmentRatingValidatedItem[]) with 'AssessmentRatingValidatedItem[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidationResult ImmutableAssessmentRatingValidationResult.withValidatedItems(AssessmentRatingValidatedItem[])"
  })
  void testWithValidatedItemsWithAssessmentRatingValidatedItem() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidationResult.builder();
    ImmutableAssessmentRatingValidationResult immutableAssessmentRatingValidationResult =
        builderResult
            .error(
                ImmutableAssessmentRatingParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    ImmutableAssessmentRatingValidatedItem.Builder changeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    ImmutableAssessmentRatingValidatedItem.Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableAssessmentRatingValidatedItem.Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());

    // Act
    ImmutableAssessmentRatingValidationResult actualWithValidatedItemsResult =
        immutableAssessmentRatingValidationResult.withValidatedItems(
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

    // Assert
    List<AssessmentRatingValidatedItem> validatedItemsResult =
        actualWithValidatedItemsResult.validatedItems();
    assertEquals(1, validatedItemsResult.size());
    AssessmentRatingValidatedItem getResult = validatedItemsResult.get(0);
    assertTrue(getResult.entityKindReference() instanceof ImmutableEntityReference);
    AssessmentRatingParseError errorResult = actualWithValidatedItemsResult.error();
    assertTrue(errorResult instanceof ImmutableAssessmentRatingParseError);
    assertTrue(getResult.parsedItem() instanceof ImmutableAssessmentRatingParsedItem);
    assertTrue(getResult instanceof ImmutableAssessmentRatingValidatedItem);
    assertTrue(getResult.ratingSchemeItem() instanceof ImmutableRatingSchemeItem);
    assertEquals("Not all who wander are lost", errorResult.message());
    assertEquals(0, actualWithValidatedItemsResult.removalCount());
    assertEquals(1, errorResult.column().intValue());
    assertEquals(2, errorResult.line().intValue());
    assertEquals(ChangeOperation.ADD, getResult.changeOperation());
    assertTrue(getResult.changedFields().isEmpty());
    assertTrue(getResult.errors().isEmpty());
    assertTrue(actualWithValidatedItemsResult.removals().isEmpty());
  }
}
