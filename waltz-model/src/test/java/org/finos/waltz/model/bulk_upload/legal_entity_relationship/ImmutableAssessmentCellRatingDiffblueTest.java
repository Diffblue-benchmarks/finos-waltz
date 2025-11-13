package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

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
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.bulk_upload.ResolutionStatus;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableAssessmentCellRating.Builder;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableAssessmentCellRating.Json;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentCellRatingDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllErrors(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllErrors(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllErrors(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllErrors(Iterable)"})
  void testBuilderAddAllErrors_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCellRating.builder();

    // Act
    Builder actualAddAllErrorsResult = builderResult.addAllErrors(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllErrorsResult);
  }

  /**
   * Test Builder {@link Builder#addErrors(RatingResolutionError)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableRatingResolutionError.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addErrors(RatingResolutionError)}
   */
  @Test
  @DisplayName(
      "Test Builder addErrors(RatingResolutionError) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addErrors(RatingResolutionError)"})
  void testBuilderAddErrorsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCellRating.builder();

    // Act
    Builder actualAddErrorsResult =
        builderResult.addErrors(new ImmutableRatingResolutionError.Json());

    // Assert
    assertSame(builderResult, actualAddErrorsResult);
  }

  /**
   * Test Builder {@link Builder#addErrors(RatingResolutionError[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableRatingResolutionError.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addErrors(RatingResolutionError[])}
   */
  @Test
  @DisplayName(
      "Test Builder addErrors(RatingResolutionError[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addErrors(RatingResolutionError[])"})
  void testBuilderAddErrorsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCellRating.builder();

    // Act
    Builder actualAddErrorsResult =
        builderResult.addErrors(new ImmutableRatingResolutionError.Json());

    // Assert
    assertSame(builderResult, actualAddErrorsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#comment(String)}
   *   <li>{@link Builder#resolvedRating(RatingSchemeItem)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentCellRating Builder.build()",
    "Builder Builder.comment(String)",
    "Builder Builder.resolvedRating(RatingSchemeItem)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualCommentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    Optional<String> comment = Optional.of("42");
    Builder actualCommentResult2 = actualCommentResult.comment(comment);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    Builder actualResolvedRatingResult = actualCommentResult2.resolvedRating(resolvedRating);
    ImmutableAssessmentCellRating actualImmutableAssessmentCellRating =
        actualResolvedRatingResult
            .resolvedRating(
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
            .status(ResolutionStatus.NEW)
            .build();

    // Assert
    assertEquals(ResolutionStatus.NEW, actualImmutableAssessmentCellRating.status());
    assertTrue(actualImmutableAssessmentCellRating.errors().isEmpty());
  }

  /**
   * Test Builder {@link Builder#comment(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#comment(Optional)}
   */
  @Test
  @DisplayName("Test Builder comment(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.comment(Optional)"})
  void testBuilderCommentWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCellRating.builder();
    Optional<String> comment = Optional.of("42");

    // Act
    Builder actualCommentResult = builderResult.comment(comment);

    // Assert
    assertSame(builderResult, actualCommentResult);
  }

  /**
   * Test Builder {@link Builder#errors(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#errors(Iterable)}
   */
  @Test
  @DisplayName("Test Builder errors(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.errors(Iterable)"})
  void testBuilderErrors_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCellRating.builder();

    // Act
    Builder actualErrorsResult = builderResult.errors(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualErrorsResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentCellRating)}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentCellRating)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentCellRating)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentCellRating)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCellRating.builder();

    Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentCellRating instance =
        commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.NEW).build();

    // Act and Assert
    ImmutableAssessmentCellRating actualImmutableAssessmentCellRating =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableAssessmentCellRating);
    ImmutableAssessmentCellRating actualImmutableAssessmentCellRating2 = builderResult.build();
    assertEquals(instance, actualImmutableAssessmentCellRating2);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentCellRating)}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentCellRating)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentCellRating)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentCellRating)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCellRating.builder();

    Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.empty();
    ImmutableAssessmentCellRating instance =
        commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.NEW).build();

    // Act and Assert
    ImmutableAssessmentCellRating actualImmutableAssessmentCellRating =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableAssessmentCellRating);
    ImmutableAssessmentCellRating actualImmutableAssessmentCellRating2 = builderResult.build();
    assertEquals(instance, actualImmutableAssessmentCellRating2);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentCellRating)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AssessmentCellRating)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentCellRating); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentCellRating)"})
  void testBuilderFrom_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCellRating.builder();

    Builder builderResult2 = ImmutableAssessmentCellRating.builder();
    builderResult2.addErrors(
        ImmutableRatingResolutionError.builder()
            .errorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED)
            .errorMessage("An error occurred")
            .build());

    Builder commentResult = builderResult2.comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentCellRating instance =
        commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.NEW).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentCellRating actualImmutableAssessmentCellRating = builderResult.build();
    assertEquals(instance, actualImmutableAssessmentCellRating);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#resolvedRating(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#resolvedRating(Optional)}
   */
  @Test
  @DisplayName("Test Builder resolvedRating(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.resolvedRating(Optional)"})
  void testBuilderResolvedRatingWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCellRating.builder();
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);

    // Act
    Builder actualResolvedRatingResult = builderResult.resolvedRating(resolvedRating);

    // Assert
    assertSame(builderResult, actualResolvedRatingResult);
  }

  /**
   * Test Builder {@link Builder#status(ResolutionStatus)}.
   *
   * <p>Method under test: {@link Builder#status(ResolutionStatus)}
   */
  @Test
  @DisplayName("Test Builder status(ResolutionStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.status(ResolutionStatus)"})
  void testBuilderStatus() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCellRating.builder();

    // Act
    Builder actualStatusResult = builderResult.status(ResolutionStatus.NEW);

    // Assert
    assertEquals(ResolutionStatus.NEW, builderResult.build().status());
    assertSame(builderResult, actualStatusResult);
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#comment()}.
   *
   * <p>Method under test: {@link ImmutableAssessmentCellRating#comment()}
   */
  @Test
  @DisplayName("Test comment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAssessmentCellRating.comment()"})
  void testComment() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);

    // Act
    Optional<String> actualCommentResult =
        commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.NEW).build().comment();

    // Assert
    assertTrue(actualCommentResult.isPresent());
    assertEquals(LegalEntityBulkUploadFixedColumns.COMMENT, actualCommentResult.get());
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#copyOf(AssessmentCellRating)}.
   *
   * <ul>
   *   <li>Then return status is {@code NEW}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCellRating#copyOf(AssessmentCellRating)}
   */
  @Test
  @DisplayName("Test copyOf(AssessmentCellRating); then return status is 'NEW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentCellRating ImmutableAssessmentCellRating.copyOf(AssessmentCellRating)"
  })
  void testCopyOf_thenReturnStatusIsNew() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentCellRating instance =
        commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.NEW).build();

    // Act
    ImmutableAssessmentCellRating actualCopyOfResult =
        ImmutableAssessmentCellRating.copyOf(instance);

    // Assert
    assertEquals(ResolutionStatus.NEW, actualCopyOfResult.status());
    assertTrue(actualCopyOfResult.errors().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#equals(Object)}, and {@link
   * ImmutableAssessmentCellRating#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentCellRating#equals(Object)}
   *   <li>{@link ImmutableAssessmentCellRating#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentCellRating.equals(Object)",
    "int ImmutableAssessmentCellRating.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentCellRating immutableAssessmentCellRating =
        commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.NEW).build();

    Builder commentResult2 =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem2 =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating2 = Optional.of(immutableRatingSchemeItem2);
    ImmutableAssessmentCellRating immutableAssessmentCellRating2 =
        commentResult2.resolvedRating(resolvedRating2).status(ResolutionStatus.NEW).build();

    // Act and Assert
    assertEquals(immutableAssessmentCellRating, immutableAssessmentCellRating2);
    assertEquals(
        immutableAssessmentCellRating.hashCode(), immutableAssessmentCellRating2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#equals(Object)}, and {@link
   * ImmutableAssessmentCellRating#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentCellRating#equals(Object)}
   *   <li>{@link ImmutableAssessmentCellRating#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentCellRating.equals(Object)",
    "int ImmutableAssessmentCellRating.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentCellRating immutableAssessmentCellRating =
        commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.NEW).build();

    // Act and Assert
    assertEquals(immutableAssessmentCellRating, immutableAssessmentCellRating);
    int expectedHashCodeResult = immutableAssessmentCellRating.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssessmentCellRating.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCellRating#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentCellRating.equals(Object)",
    "int ImmutableAssessmentCellRating.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCellRating.builder();
    builderResult.addErrors(
        ImmutableRatingResolutionError.builder()
            .errorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED)
            .errorMessage("An error occurred")
            .build());

    Builder commentResult = builderResult.comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentCellRating immutableAssessmentCellRating =
        commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.NEW).build();

    Builder commentResult2 =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem2 =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating2 = Optional.of(immutableRatingSchemeItem2);

    // Act and Assert
    assertNotEquals(
        immutableAssessmentCellRating,
        commentResult2.resolvedRating(resolvedRating2).status(ResolutionStatus.NEW).build());
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCellRating#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentCellRating.equals(Object)",
    "int ImmutableAssessmentCellRating.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder commentResult = ImmutableAssessmentCellRating.builder().comment("Name");
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentCellRating immutableAssessmentCellRating =
        commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.NEW).build();

    Builder commentResult2 =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem2 =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating2 = Optional.of(immutableRatingSchemeItem2);

    // Act and Assert
    assertNotEquals(
        immutableAssessmentCellRating,
        commentResult2.resolvedRating(resolvedRating2).status(ResolutionStatus.NEW).build());
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCellRating#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentCellRating.equals(Object)",
    "int ImmutableAssessmentCellRating.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Name")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentCellRating immutableAssessmentCellRating =
        commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.NEW).build();

    Builder commentResult2 =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem2 =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating2 = Optional.of(immutableRatingSchemeItem2);

    // Act and Assert
    assertNotEquals(
        immutableAssessmentCellRating,
        commentResult2.resolvedRating(resolvedRating2).status(ResolutionStatus.NEW).build());
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCellRating#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentCellRating.equals(Object)",
    "int ImmutableAssessmentCellRating.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentCellRating immutableAssessmentCellRating =
        commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.EXISTING).build();

    Builder commentResult2 =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem2 =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating2 = Optional.of(immutableRatingSchemeItem2);

    // Act and Assert
    assertNotEquals(
        immutableAssessmentCellRating,
        commentResult2.resolvedRating(resolvedRating2).status(ResolutionStatus.NEW).build());
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCellRating#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentCellRating.equals(Object)",
    "int ImmutableAssessmentCellRating.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);

    // Act and Assert
    assertNotEquals(
        commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.NEW).build(), null);
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCellRating#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentCellRating.equals(Object)",
    "int ImmutableAssessmentCellRating.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);

    // Act and Assert
    assertNotEquals(
        commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.NEW).build(),
        "Different type to ImmutableAssessmentCellRating");
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) Errors is {@link HashSet#HashSet()}.
   *   <li>Then return errors Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCellRating#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) Errors is HashSet(); then return errors Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentCellRating ImmutableAssessmentCellRating.fromJson(Json)"})
  void testFromJson_givenHashSet_whenJsonErrorsIsHashSet_thenReturnErrorsEmpty() {
    // Arrange
    Json json = new Json();
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    json.setResolvedRating(resolvedRating);
    Optional<String> comment = Optional.of("42");
    json.setComment(comment);
    json.setStatus(ResolutionStatus.NEW);
    json.setErrors(new HashSet<>());

    // Act
    ImmutableAssessmentCellRating actualFromJsonResult =
        ImmutableAssessmentCellRating.fromJson(json);

    // Assert
    assertEquals(ResolutionStatus.NEW, actualFromJsonResult.status());
    assertTrue(actualFromJsonResult.errors().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link
   *       ImmutableRatingResolutionError.Json} (default constructor).
   *   <li>Then return errors size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCellRating#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return errors size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentCellRating ImmutableAssessmentCellRating.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddJson_thenReturnErrorsSizeIsOne() {
    // Arrange
    LinkedHashSet<RatingResolutionError> errors = new LinkedHashSet<>();
    errors.add(new ImmutableRatingResolutionError.Json());

    Json json = new Json();
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    json.setResolvedRating(resolvedRating);
    Optional<String> comment = Optional.of("42");
    json.setComment(comment);
    json.setStatus(ResolutionStatus.NEW);
    json.setErrors(errors);

    // Act
    ImmutableAssessmentCellRating actualFromJsonResult =
        ImmutableAssessmentCellRating.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.errors().size());
    assertEquals(ResolutionStatus.NEW, actualFromJsonResult.status());
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Errors is {@code null}.
   *   <li>Then return errors Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCellRating#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Errors is 'null'; then return errors Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentCellRating ImmutableAssessmentCellRating.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonErrorsIsNull_thenReturnErrorsEmpty() {
    // Arrange
    Json json = new Json();
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    json.setResolvedRating(resolvedRating);
    Optional<String> comment = Optional.of("42");
    json.setComment(comment);
    json.setStatus(ResolutionStatus.NEW);
    json.setErrors(null);

    // Act
    ImmutableAssessmentCellRating actualFromJsonResult =
        ImmutableAssessmentCellRating.fromJson(json);

    // Assert
    assertEquals(ResolutionStatus.NEW, actualFromJsonResult.status());
    assertTrue(actualFromJsonResult.errors().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return errors is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCellRating#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return errors is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentCellRating ImmutableAssessmentCellRating.fromJson(Json)"})
  void testFromJson_thenReturnErrorsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<RatingResolutionError> errors = new LinkedHashSet<>();
    errors.add(
        ImmutableRatingResolutionError.builder()
            .errorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED)
            .errorMessage("An error occurred")
            .build());
    errors.add(new ImmutableRatingResolutionError.Json());

    Json json = new Json();
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    json.setResolvedRating(resolvedRating);
    Optional<String> comment = Optional.of("42");
    json.setComment(comment);
    json.setStatus(ResolutionStatus.NEW);
    json.setErrors(errors);

    // Act
    ImmutableAssessmentCellRating actualFromJsonResult =
        ImmutableAssessmentCellRating.fromJson(json);

    // Assert
    assertEquals(ResolutionStatus.NEW, actualFromJsonResult.status());
    assertEquals(errors, actualFromJsonResult.errors());
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Comment is {@code null}.
   *   <li>Then return errors size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCellRating#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Comment is 'null'; then return errors size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentCellRating ImmutableAssessmentCellRating.fromJson(Json)"})
  void testFromJson_whenJsonCommentIsNull_thenReturnErrorsSizeIsOne() {
    // Arrange
    LinkedHashSet<RatingResolutionError> errors = new LinkedHashSet<>();
    errors.add(new ImmutableRatingResolutionError.Json());

    Json json = new Json();
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    json.setResolvedRating(resolvedRating);
    json.setComment(null);
    json.setStatus(ResolutionStatus.NEW);
    json.setErrors(errors);

    // Act
    ImmutableAssessmentCellRating actualFromJsonResult =
        ImmutableAssessmentCellRating.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.errors().size());
    assertEquals(ResolutionStatus.NEW, actualFromJsonResult.status());
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) ResolvedRating is {@code null}.
   *   <li>Then return errors size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCellRating#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) ResolvedRating is 'null'; then return errors size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentCellRating ImmutableAssessmentCellRating.fromJson(Json)"})
  void testFromJson_whenJsonResolvedRatingIsNull_thenReturnErrorsSizeIsOne() {
    // Arrange
    LinkedHashSet<RatingResolutionError> errors = new LinkedHashSet<>();
    errors.add(new ImmutableRatingResolutionError.Json());

    Json json = new Json();
    json.setResolvedRating(null);
    Optional<String> comment = Optional.of("42");
    json.setComment(comment);
    json.setStatus(ResolutionStatus.NEW);
    json.setErrors(errors);

    // Act
    ImmutableAssessmentCellRating actualFromJsonResult =
        ImmutableAssessmentCellRating.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.errors().size());
    assertEquals(ResolutionStatus.NEW, actualFromJsonResult.status());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentCellRating#errors()}
   *   <li>{@link ImmutableAssessmentCellRating#status()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableAssessmentCellRating.errors()",
    "ResolutionStatus ImmutableAssessmentCellRating.status()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentCellRating immutableAssessmentCellRating =
        commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.NEW).build();

    // Act
    Set<RatingResolutionError> actualErrorsResult = immutableAssessmentCellRating.errors();

    // Assert
    assertEquals(ResolutionStatus.NEW, immutableAssessmentCellRating.status());
    assertTrue(actualErrorsResult.isEmpty());
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
  @MethodsUnderTest({"Optional Json.comment()"})
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().comment());
  }

  /**
   * Test Json {@link Json#errors()}.
   *
   * <p>Method under test: {@link Json#errors()}
   */
  @Test
  @DisplayName("Test Json errors()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.errors()"})
  void testJsonErrors() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().errors());
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
    assertNull(actualJson.status);
    assertFalse(actualJson.comment.isPresent());
    assertFalse(actualJson.resolvedRating.isPresent());
    assertTrue(actualJson.errors.isEmpty());
  }

  /**
   * Test Json {@link Json#resolvedRating()}.
   *
   * <p>Method under test: {@link Json#resolvedRating()}
   */
  @Test
  @DisplayName("Test Json resolvedRating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.resolvedRating()"})
  void testJsonResolvedRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().resolvedRating());
  }

  /**
   * Test Json {@link Json#status()}.
   *
   * <p>Method under test: {@link Json#status()}
   */
  @Test
  @DisplayName("Test Json status()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResolutionStatus Json.status()"})
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().status());
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#resolvedRating()}.
   *
   * <p>Method under test: {@link ImmutableAssessmentCellRating#resolvedRating()}
   */
  @Test
  @DisplayName("Test resolvedRating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAssessmentCellRating.resolvedRating()"})
  void testResolvedRating() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);

    // Act and Assert
    assertEquals(
        resolvedRating,
        commentResult
            .resolvedRating(resolvedRating)
            .status(ResolutionStatus.NEW)
            .build()
            .resolvedRating());
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#toString()}.
   *
   * <ul>
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCellRating#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAssessmentCellRating.toString()"})
  void testToString_thenReturnAString() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);

    // Act and Assert
    assertEquals(
        "AssessmentCellRating{resolvedRating=RatingSchemeItem{id=1, name=Name, position=0, externalId=42,"
            + " rating=Rating, color=Color, ratingSchemeId=1, userSelectable=true, isRestricted=false, ratingGroup=Rating"
            + " Group, requiresComment=false}, comment=Comment, status=NEW, errors=[]}",
        commentResult
            .resolvedRating(resolvedRating)
            .status(ResolutionStatus.NEW)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#toString()}.
   *
   * <ul>
   *   <li>Then return {@code AssessmentCellRating{comment=Comment, status=NEW, errors=[]}}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCellRating#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return 'AssessmentCellRating{comment=Comment, status=NEW, errors=[]}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAssessmentCellRating.toString()"})
  void testToString_thenReturnAssessmentCellRatingCommentCommentStatusNewErrors() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.empty();

    // Act and Assert
    assertEquals(
        "AssessmentCellRating{comment=Comment, status=NEW, errors=[]}",
        commentResult
            .resolvedRating(resolvedRating)
            .status(ResolutionStatus.NEW)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#withComment(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAssessmentCellRating#withComment(Optional)}
   */
  @Test
  @DisplayName("Test withComment(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentCellRating ImmutableAssessmentCellRating.withComment(Optional)"
  })
  void testWithCommentWithOptional() {
    // Arrange
    Builder commentResult = ImmutableAssessmentCellRating.builder().comment("42");
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentCellRating immutableAssessmentCellRating =
        commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.NEW).build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableAssessmentCellRating actualWithCommentResult =
        immutableAssessmentCellRating.withComment(optional);

    // Assert
    assertSame(immutableAssessmentCellRating, actualWithCommentResult);
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#withComment(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return status is {@code NEW}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCellRating#withComment(Optional)}
   */
  @Test
  @DisplayName("Test withComment(Optional) with 'optional'; then return status is 'NEW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentCellRating ImmutableAssessmentCellRating.withComment(Optional)"
  })
  void testWithCommentWithOptional_thenReturnStatusIsNew() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentCellRating immutableAssessmentCellRating =
        commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.NEW).build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableAssessmentCellRating actualWithCommentResult =
        immutableAssessmentCellRating.withComment(optional);

    // Assert
    assertEquals(ResolutionStatus.NEW, actualWithCommentResult.status());
    assertTrue(actualWithCommentResult.errors().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#withComment(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAssessmentCellRating#withComment(String)}
   */
  @Test
  @DisplayName("Test withComment(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentCellRating ImmutableAssessmentCellRating.withComment(String)"
  })
  void testWithCommentWithValue() {
    // Arrange
    Builder commentResult = ImmutableAssessmentCellRating.builder().comment("42");
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentCellRating immutableAssessmentCellRating =
        commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.NEW).build();

    // Act
    ImmutableAssessmentCellRating actualWithCommentResult =
        immutableAssessmentCellRating.withComment("42");

    // Assert
    assertSame(immutableAssessmentCellRating, actualWithCommentResult);
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#withComment(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return status is {@code NEW}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCellRating#withComment(String)}
   */
  @Test
  @DisplayName("Test withComment(String) with 'value'; then return status is 'NEW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentCellRating ImmutableAssessmentCellRating.withComment(String)"
  })
  void testWithCommentWithValue_thenReturnStatusIsNew() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);

    // Act
    ImmutableAssessmentCellRating actualWithCommentResult =
        commentResult
            .resolvedRating(resolvedRating)
            .status(ResolutionStatus.NEW)
            .build()
            .withComment("42");

    // Assert
    assertEquals(ResolutionStatus.NEW, actualWithCommentResult.status());
    assertTrue(actualWithCommentResult.errors().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#withErrors(RatingResolutionError[])} with {@code
   * RatingResolutionError[]}.
   *
   * <p>Method under test: {@link ImmutableAssessmentCellRating#withErrors(RatingResolutionError[])}
   */
  @Test
  @DisplayName("Test withErrors(RatingResolutionError[]) with 'RatingResolutionError[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentCellRating ImmutableAssessmentCellRating.withErrors(RatingResolutionError[])"
  })
  void testWithErrorsWithRatingResolutionError() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentCellRating immutableAssessmentCellRating =
        commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.NEW).build();

    // Act
    ImmutableAssessmentCellRating actualWithErrorsResult =
        immutableAssessmentCellRating.withErrors(
            ImmutableRatingResolutionError.builder()
                .errorCode(RatingResolutionErrorCode.MULTIPLE_RATINGS_DISALLOWED)
                .errorMessage("An error occurred")
                .build());

    // Assert
    assertEquals(1, actualWithErrorsResult.errors().size());
    assertEquals(ResolutionStatus.NEW, actualWithErrorsResult.status());
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#withResolvedRating(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAssessmentCellRating#withResolvedRating(Optional)}
   */
  @Test
  @DisplayName("Test withResolvedRating(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentCellRating ImmutableAssessmentCellRating.withResolvedRating(Optional)"
  })
  void testWithResolvedRatingWithOptional() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentCellRating immutableAssessmentCellRating =
        commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.NEW).build();
    ImmutableRatingSchemeItem immutableRatingSchemeItem2 =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> optional = Optional.of(immutableRatingSchemeItem2);

    // Act
    ImmutableAssessmentCellRating actualWithResolvedRatingResult =
        immutableAssessmentCellRating.withResolvedRating(optional);

    // Assert
    assertEquals(immutableAssessmentCellRating, actualWithResolvedRatingResult);
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#withResolvedRating(RatingSchemeItem)} with {@code
   * value}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentCellRating#withResolvedRating(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test withResolvedRating(RatingSchemeItem) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentCellRating ImmutableAssessmentCellRating.withResolvedRating(RatingSchemeItem)"
  })
  void testWithResolvedRatingWithValue() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentCellRating immutableAssessmentCellRating =
        commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.NEW).build();

    // Act
    ImmutableAssessmentCellRating actualWithResolvedRatingResult =
        immutableAssessmentCellRating.withResolvedRating(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    // Assert
    assertEquals(immutableAssessmentCellRating, actualWithResolvedRatingResult);
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#withStatus(ResolutionStatus)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentCellRating#withStatus(ResolutionStatus)}
   */
  @Test
  @DisplayName("Test withStatus(ResolutionStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentCellRating ImmutableAssessmentCellRating.withStatus(ResolutionStatus)"
  })
  void testWithStatus() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentCellRating immutableAssessmentCellRating =
        commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.NEW).build();

    // Act
    ImmutableAssessmentCellRating actualWithStatusResult =
        immutableAssessmentCellRating.withStatus(ResolutionStatus.NEW);

    // Assert
    assertSame(immutableAssessmentCellRating, actualWithStatusResult);
  }

  /**
   * Test {@link ImmutableAssessmentCellRating#withStatus(ResolutionStatus)}.
   *
   * <ul>
   *   <li>Then return status is {@code NEW}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCellRating#withStatus(ResolutionStatus)}
   */
  @Test
  @DisplayName("Test withStatus(ResolutionStatus); then return status is 'NEW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentCellRating ImmutableAssessmentCellRating.withStatus(ResolutionStatus)"
  })
  void testWithStatus_thenReturnStatusIsNew() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);

    // Act
    ImmutableAssessmentCellRating actualWithStatusResult =
        commentResult
            .resolvedRating(resolvedRating)
            .status(ResolutionStatus.EXISTING)
            .build()
            .withStatus(ResolutionStatus.NEW);

    // Assert
    assertEquals(ResolutionStatus.NEW, actualWithStatusResult.status());
    assertTrue(actualWithStatusResult.errors().isEmpty());
  }
}
