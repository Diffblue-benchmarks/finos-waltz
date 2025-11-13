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
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmentRatingValidatedItem.Builder;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmentRatingValidatedItem.Json;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingValidatedItemDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllChangedFields(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code ENTITY}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code ENTITY}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllChangedFields(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllChangedFields(Iterable); given 'ENTITY'; when LinkedHashSet() add 'ENTITY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllChangedFields(Iterable)"})
  void testBuilderAddAllChangedFields_givenEntity_whenLinkedHashSetAddEntity() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    LinkedHashSet<ChangedFieldType> elements = new LinkedHashSet<>();
    elements.add(ChangedFieldType.ENTITY);

    // Act
    Builder actualAddAllChangedFieldsResult = builderResult.addAllChangedFields(elements);

    // Assert
    assertSame(builderResult, actualAddAllChangedFieldsResult);
  }

  /**
   * Test Builder {@link Builder#addAllChangedFields(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllChangedFields(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllChangedFields(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllChangedFields(Iterable)"})
  void testBuilderAddAllChangedFields_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act
    Builder actualAddAllChangedFieldsResult = builderResult.addAllChangedFields(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllChangedFieldsResult);
  }

  /**
   * Test Builder {@link Builder#addAllErrors(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code ENTITY_KIND_NOT_FOUND}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllErrors(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllErrors(Iterable); given 'ENTITY_KIND_NOT_FOUND'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllErrors(Iterable)"})
  void testBuilderAddAllErrors_givenEntityKindNotFound() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.ENTITY_KIND_NOT_FOUND);

    // Act
    Builder actualAddAllErrorsResult = builderResult.addAllErrors(elements);

    // Assert
    assertSame(builderResult, actualAddAllErrorsResult);
  }

  /**
   * Test Builder {@link Builder#addAllErrors(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllErrors(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllErrors(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllErrors(Iterable)"})
  void testBuilderAddAllErrors_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act
    Builder actualAddAllErrorsResult = builderResult.addAllErrors(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllErrorsResult);
  }

  /**
   * Test Builder {@link Builder#addChangedFields(ChangedFieldType)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addChangedFields(ChangedFieldType)}
   */
  @Test
  @DisplayName("Test Builder addChangedFields(ChangedFieldType) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addChangedFields(ChangedFieldType)"})
  void testBuilderAddChangedFieldsWithElement() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act
    Builder actualAddChangedFieldsResult = builderResult.addChangedFields(ChangedFieldType.ENTITY);

    // Assert
    assertSame(builderResult, actualAddChangedFieldsResult);
  }

  /**
   * Test Builder {@link Builder#addChangedFields(ChangedFieldType[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addChangedFields(ChangedFieldType[])}
   */
  @Test
  @DisplayName("Test Builder addChangedFields(ChangedFieldType[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addChangedFields(ChangedFieldType[])"})
  void testBuilderAddChangedFieldsWithElements() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act
    Builder actualAddChangedFieldsResult = builderResult.addChangedFields(ChangedFieldType.ENTITY);

    // Assert
    assertSame(builderResult, actualAddChangedFieldsResult);
  }

  /**
   * Test Builder {@link Builder#addErrors(ValidationError)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addErrors(ValidationError)}
   */
  @Test
  @DisplayName("Test Builder addErrors(ValidationError) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addErrors(ValidationError)"})
  void testBuilderAddErrorsWithElement() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act
    Builder actualAddErrorsResult = builderResult.addErrors(ValidationError.ENTITY_KIND_NOT_FOUND);

    // Assert
    assertSame(builderResult, actualAddErrorsResult);
  }

  /**
   * Test Builder {@link Builder#addErrors(ValidationError[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addErrors(ValidationError[])}
   */
  @Test
  @DisplayName("Test Builder addErrors(ValidationError[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addErrors(ValidationError[])"})
  void testBuilderAddErrorsWithElements() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act
    Builder actualAddErrorsResult = builderResult.addErrors(ValidationError.ENTITY_KIND_NOT_FOUND);

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
   *   <li>{@link Builder#entityKindReference(EntityReference)}
   *   <li>{@link Builder#ratingSchemeItem(RatingSchemeItem)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidatedItem Builder.build()",
    "Builder Builder.entityKindReference(EntityReference)",
    "Builder Builder.ratingSchemeItem(RatingSchemeItem)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualChangeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);
    ImmutableEntityReference entityKindReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualEntityKindReferenceResult =
        actualChangeOperationResult.entityKindReference(entityKindReference);
    ImmutableAssessmentRatingParsedItem parsedItem =
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("Rating Code")
            .build();
    Builder actualParsedItemResult = actualEntityKindReferenceResult.parsedItem(parsedItem);
    ImmutableRatingSchemeItem ratingSchemeItem =
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
    ImmutableAssessmentRatingValidatedItem actualImmutableAssessmentRatingValidatedItem =
        actualParsedItemResult.ratingSchemeItem(ratingSchemeItem).build();

    // Assert
    assertEquals(
        ChangeOperation.ADD, actualImmutableAssessmentRatingValidatedItem.changeOperation());
    assertTrue(actualImmutableAssessmentRatingValidatedItem.changedFields().isEmpty());
    assertTrue(actualImmutableAssessmentRatingValidatedItem.errors().isEmpty());
    assertSame(
        entityKindReference, actualImmutableAssessmentRatingValidatedItem.entityKindReference());
    assertSame(parsedItem, actualImmutableAssessmentRatingValidatedItem.parsedItem());
    assertSame(ratingSchemeItem, actualImmutableAssessmentRatingValidatedItem.ratingSchemeItem());
  }

  /**
   * Test Builder {@link Builder#changeOperation(ChangeOperation)}.
   *
   * <p>Method under test: {@link Builder#changeOperation(ChangeOperation)}
   */
  @Test
  @DisplayName("Test Builder changeOperation(ChangeOperation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.changeOperation(ChangeOperation)"})
  void testBuilderChangeOperation() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act
    Builder actualChangeOperationResult = builderResult.changeOperation(ChangeOperation.ADD);

    // Assert
    assertSame(builderResult, actualChangeOperationResult);
  }

  /**
   * Test Builder {@link Builder#changedFields(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code ENTITY}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code ENTITY}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#changedFields(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder changedFields(Iterable); given 'ENTITY'; when LinkedHashSet() add 'ENTITY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.changedFields(Iterable)"})
  void testBuilderChangedFields_givenEntity_whenLinkedHashSetAddEntity() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    LinkedHashSet<ChangedFieldType> elements = new LinkedHashSet<>();
    elements.add(ChangedFieldType.ENTITY);

    // Act
    Builder actualChangedFieldsResult = builderResult.changedFields(elements);

    // Assert
    assertSame(builderResult, actualChangedFieldsResult);
  }

  /**
   * Test Builder {@link Builder#changedFields(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#changedFields(Iterable)}
   */
  @Test
  @DisplayName("Test Builder changedFields(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.changedFields(Iterable)"})
  void testBuilderChangedFields_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act
    Builder actualChangedFieldsResult = builderResult.changedFields(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualChangedFieldsResult);
  }

  /**
   * Test Builder {@link Builder#errors(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code ENTITY_KIND_NOT_FOUND}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code ENTITY_KIND_NOT_FOUND}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#errors(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder errors(Iterable); given 'ENTITY_KIND_NOT_FOUND'; when LinkedHashSet() add 'ENTITY_KIND_NOT_FOUND'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.errors(Iterable)"})
  void testBuilderErrors_givenEntityKindNotFound_whenLinkedHashSetAddEntityKindNotFound() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.ENTITY_KIND_NOT_FOUND);

    // Act
    Builder actualErrorsResult = builderResult.errors(elements);

    // Assert
    assertSame(builderResult, actualErrorsResult);
  }

  /**
   * Test Builder {@link Builder#errors(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#errors(Iterable)}
   */
  @Test
  @DisplayName("Test Builder errors(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.errors(Iterable)"})
  void testBuilderErrors_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act
    Builder actualErrorsResult = builderResult.errors(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualErrorsResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingValidatedItem)}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingValidatedItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingValidatedItem)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    Builder changeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());
    ImmutableAssessmentRatingValidatedItem instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentRatingValidatedItem actualImmutableAssessmentRatingValidatedItem =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRatingValidatedItem);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingValidatedItem)}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingValidatedItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingValidatedItem)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    Builder builderResult2 = ImmutableAssessmentRatingValidatedItem.builder();
    builderResult2.addChangedFields(ChangedFieldType.ENTITY);

    Builder changeOperationResult = builderResult2.changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());
    ImmutableAssessmentRatingValidatedItem instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentRatingValidatedItem actualImmutableAssessmentRatingValidatedItem =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRatingValidatedItem);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingValidatedItem)}.
   *
   * <ul>
   *   <li>Given {@code RATING_NOT_FOUND}.
   *   <li>Then return build changedFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingValidatedItem)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AssessmentRatingValidatedItem); given 'RATING_NOT_FOUND'; then return build changedFields size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingValidatedItem)"})
  void testBuilderFrom_givenRatingNotFound_thenReturnBuildChangedFieldsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    Builder builderResult2 = ImmutableAssessmentRatingValidatedItem.builder();
    builderResult2.addErrors(ValidationError.RATING_NOT_FOUND);
    builderResult2.addChangedFields(ChangedFieldType.ENTITY);

    Builder changeOperationResult = builderResult2.changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());

    // Act and Assert
    ImmutableAssessmentRatingValidatedItem immutableAssessmentRatingValidatedItem =
        builderResult
            .from(
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
                    .build())
            .build();
    Set<ChangedFieldType> changedFieldsResult =
        immutableAssessmentRatingValidatedItem.changedFields();
    assertEquals(1, changedFieldsResult.size());
    Set<ValidationError> errorsResult = immutableAssessmentRatingValidatedItem.errors();
    assertEquals(1, errorsResult.size());
    assertTrue(changedFieldsResult.contains(ChangedFieldType.ENTITY));
    assertTrue(errorsResult.contains(ValidationError.RATING_NOT_FOUND));
  }

  /**
   * Test Builder {@link Builder#parsedItem(AssessmentRatingParsedItem)}.
   *
   * <ul>
   *   <li>When {@link ImmutableAssessmentRatingParsedItem.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#parsedItem(AssessmentRatingParsedItem)}
   */
  @Test
  @DisplayName(
      "Test Builder parsedItem(AssessmentRatingParsedItem); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parsedItem(AssessmentRatingParsedItem)"})
  void testBuilderParsedItem_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();

    // Act
    Builder actualParsedItemResult =
        builderResult.parsedItem(new ImmutableAssessmentRatingParsedItem.Json());

    // Assert
    assertSame(builderResult, actualParsedItemResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidatedItem#copyOf(AssessmentRatingValidatedItem)}.
   *
   * <ul>
   *   <li>Then entityKindReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingValidatedItem#copyOf(AssessmentRatingValidatedItem)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AssessmentRatingValidatedItem); then entityKindReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidatedItem ImmutableAssessmentRatingValidatedItem.copyOf(AssessmentRatingValidatedItem)"
  })
  void testCopyOf_thenEntityKindReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder changeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());
    ImmutableAssessmentRatingValidatedItem instance =
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
            .build();

    // Act
    ImmutableAssessmentRatingValidatedItem actualCopyOfResult =
        ImmutableAssessmentRatingValidatedItem.copyOf(instance);

    // Assert
    assertTrue(actualCopyOfResult.entityKindReference() instanceof ImmutableEntityReference);
    assertTrue(actualCopyOfResult.parsedItem() instanceof ImmutableAssessmentRatingParsedItem);
    assertTrue(actualCopyOfResult.ratingSchemeItem() instanceof ImmutableRatingSchemeItem);
    assertEquals(ChangeOperation.ADD, actualCopyOfResult.changeOperation());
    assertTrue(actualCopyOfResult.changedFields().isEmpty());
    assertTrue(actualCopyOfResult.errors().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidatedItem#equals(Object)}, and {@link
   * ImmutableAssessmentRatingValidatedItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingValidatedItem#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingValidatedItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingValidatedItem.equals(Object)",
    "int ImmutableAssessmentRatingValidatedItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder changeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());
    ImmutableAssessmentRatingValidatedItem immutableAssessmentRatingValidatedItem =
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
            .build();

    Builder changeOperationResult2 =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult2 =
        changeOperationResult2.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult2 =
        entityKindReferenceResult2.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());
    ImmutableAssessmentRatingValidatedItem immutableAssessmentRatingValidatedItem2 =
        parsedItemResult2
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
            .build();

    // Act and Assert
    assertEquals(immutableAssessmentRatingValidatedItem, immutableAssessmentRatingValidatedItem2);
    assertEquals(
        immutableAssessmentRatingValidatedItem.hashCode(),
        immutableAssessmentRatingValidatedItem2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidatedItem#equals(Object)}, and {@link
   * ImmutableAssessmentRatingValidatedItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingValidatedItem#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingValidatedItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingValidatedItem.equals(Object)",
    "int ImmutableAssessmentRatingValidatedItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder changeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());
    ImmutableAssessmentRatingValidatedItem immutableAssessmentRatingValidatedItem =
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
            .build();

    // Act and Assert
    assertEquals(immutableAssessmentRatingValidatedItem, immutableAssessmentRatingValidatedItem);
    int expectedHashCodeResult = immutableAssessmentRatingValidatedItem.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssessmentRatingValidatedItem.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingValidatedItem.equals(Object)",
    "int ImmutableAssessmentRatingValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();
    builderResult.addChangedFields(ChangedFieldType.ENTITY);

    Builder changeOperationResult = builderResult.changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());
    ImmutableAssessmentRatingValidatedItem immutableAssessmentRatingValidatedItem =
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
            .build();

    Builder changeOperationResult2 =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult2 =
        changeOperationResult2.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult2 =
        entityKindReferenceResult2.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingValidatedItem,
        parsedItemResult2
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
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingValidatedItem.equals(Object)",
    "int ImmutableAssessmentRatingValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingValidatedItem.builder();
    builderResult.addErrors(ValidationError.ENTITY_KIND_NOT_FOUND);

    Builder changeOperationResult = builderResult.changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());
    ImmutableAssessmentRatingValidatedItem immutableAssessmentRatingValidatedItem =
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
            .build();

    Builder changeOperationResult2 =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult2 =
        changeOperationResult2.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult2 =
        entityKindReferenceResult2.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingValidatedItem,
        parsedItemResult2
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
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingValidatedItem.equals(Object)",
    "int ImmutableAssessmentRatingValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder changeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.REMOVE);

    Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());
    ImmutableAssessmentRatingValidatedItem immutableAssessmentRatingValidatedItem =
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
            .build();

    Builder changeOperationResult2 =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult2 =
        changeOperationResult2.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult2 =
        entityKindReferenceResult2.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingValidatedItem,
        parsedItemResult2
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
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingValidatedItem.equals(Object)",
    "int ImmutableAssessmentRatingValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder changeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());
    ImmutableAssessmentRatingValidatedItem immutableAssessmentRatingValidatedItem =
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
            .build();

    Builder changeOperationResult2 =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult2 =
        changeOperationResult2.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult2 =
        entityKindReferenceResult2.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingValidatedItem,
        parsedItemResult2
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
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingValidatedItem.equals(Object)",
    "int ImmutableAssessmentRatingValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder changeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("42")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());
    ImmutableAssessmentRatingValidatedItem immutableAssessmentRatingValidatedItem =
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
            .build();

    Builder changeOperationResult2 =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult2 =
        changeOperationResult2.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult2 =
        entityKindReferenceResult2.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingValidatedItem,
        parsedItemResult2
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
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingValidatedItem.equals(Object)",
    "int ImmutableAssessmentRatingValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder changeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());
    ImmutableAssessmentRatingValidatedItem immutableAssessmentRatingValidatedItem =
        parsedItemResult
            .ratingSchemeItem(
                ImmutableRatingSchemeItem.builder()
                    .color("42")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    Builder changeOperationResult2 =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult2 =
        changeOperationResult2.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult2 =
        entityKindReferenceResult2.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingValidatedItem,
        parsedItemResult2
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
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingValidatedItem.equals(Object)",
    "int ImmutableAssessmentRatingValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder changeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());

    // Act and Assert
    assertNotEquals(
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
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingValidatedItem.equals(Object)",
    "int ImmutableAssessmentRatingValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder changeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());

    // Act and Assert
    assertNotEquals(
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
            .build(),
        "Different type to ImmutableAssessmentRatingValidatedItem");
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidatedItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code ENTITY}.
   *   <li>Then return changedFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingValidatedItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add 'ENTITY'; then return changedFields size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidatedItem ImmutableAssessmentRatingValidatedItem.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddEntity_thenReturnChangedFieldsSizeIsOne() {
    // Arrange
    LinkedHashSet<ChangedFieldType> changedFields = new LinkedHashSet<>();
    changedFields.add(ChangedFieldType.ENTITY);

    LinkedHashSet<ValidationError> errors = new LinkedHashSet<>();
    errors.add(ValidationError.ENTITY_KIND_NOT_FOUND);

    Json json = new Json();
    json.setParsedItem(new ImmutableAssessmentRatingParsedItem.Json());
    json.setChangeOperation(ChangeOperation.ADD);
    json.setChangedFields(changedFields);
    json.setErrors(errors);
    json.setRatingSchemeItem(null);
    json.setEntityKindReference(null);

    // Act
    ImmutableAssessmentRatingValidatedItem actualFromJsonResult =
        ImmutableAssessmentRatingValidatedItem.fromJson(json);

    // Assert
    Set<ChangedFieldType> changedFieldsResult = actualFromJsonResult.changedFields();
    assertEquals(1, changedFieldsResult.size());
    Set<ValidationError> errorsResult = actualFromJsonResult.errors();
    assertEquals(1, errorsResult.size());
    assertTrue(changedFieldsResult.contains(ChangedFieldType.ENTITY));
    assertTrue(errorsResult.contains(ValidationError.ENTITY_KIND_NOT_FOUND));
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidatedItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then entityKindReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingValidatedItem#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then entityKindReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidatedItem ImmutableAssessmentRatingValidatedItem.fromJson(Json)"
  })
  void testFromJson_thenEntityKindReferenceReturnImmutableEntityReference() {
    // Arrange
    LinkedHashSet<ChangedFieldType> changedFields = new LinkedHashSet<>();
    changedFields.add(ChangedFieldType.ENTITY);

    LinkedHashSet<ValidationError> errors = new LinkedHashSet<>();
    errors.add(ValidationError.ENTITY_KIND_NOT_FOUND);

    Json json = new Json();
    json.setParsedItem(
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("Rating Code")
            .build());
    json.setChangeOperation(ChangeOperation.ADD);
    json.setChangedFields(changedFields);
    json.setErrors(errors);
    json.setRatingSchemeItem(
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
    json.setEntityKindReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutableAssessmentRatingValidatedItem actualFromJsonResult =
        ImmutableAssessmentRatingValidatedItem.fromJson(json);

    // Assert
    EntityReference entityKindReferenceResult = actualFromJsonResult.entityKindReference();
    assertTrue(entityKindReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualFromJsonResult.parsedItem() instanceof ImmutableAssessmentRatingParsedItem);
    RatingSchemeItem ratingSchemeItemResult = actualFromJsonResult.ratingSchemeItem();
    assertTrue(ratingSchemeItemResult instanceof ImmutableRatingSchemeItem);
    assertSame(json.entityKindReference, entityKindReferenceResult);
    assertSame(json.ratingSchemeItem, ratingSchemeItemResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidatedItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) ChangedFields is {@code null}.
   *   <li>Then return changedFields Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingValidatedItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) ChangedFields is 'null'; then return changedFields Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidatedItem ImmutableAssessmentRatingValidatedItem.fromJson(Json)"
  })
  void testFromJson_whenJsonChangedFieldsIsNull_thenReturnChangedFieldsEmpty() {
    // Arrange
    LinkedHashSet<ValidationError> errors = new LinkedHashSet<>();
    errors.add(ValidationError.ENTITY_KIND_NOT_FOUND);

    Json json = new Json();
    json.setParsedItem(new ImmutableAssessmentRatingParsedItem.Json());
    json.setChangeOperation(ChangeOperation.ADD);
    json.setChangedFields(null);
    json.setErrors(errors);
    json.setRatingSchemeItem(null);
    json.setEntityKindReference(null);

    // Act
    ImmutableAssessmentRatingValidatedItem actualFromJsonResult =
        ImmutableAssessmentRatingValidatedItem.fromJson(json);

    // Assert
    Set<ValidationError> errorsResult = actualFromJsonResult.errors();
    assertEquals(1, errorsResult.size());
    assertTrue(errorsResult.contains(ValidationError.ENTITY_KIND_NOT_FOUND));
    assertTrue(actualFromJsonResult.changedFields().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidatedItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Errors is {@code null}.
   *   <li>Then return errors Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingValidatedItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Errors is 'null'; then return errors Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidatedItem ImmutableAssessmentRatingValidatedItem.fromJson(Json)"
  })
  void testFromJson_whenJsonErrorsIsNull_thenReturnErrorsEmpty() {
    // Arrange
    LinkedHashSet<ChangedFieldType> changedFields = new LinkedHashSet<>();
    changedFields.add(ChangedFieldType.ENTITY);

    Json json = new Json();
    json.setParsedItem(new ImmutableAssessmentRatingParsedItem.Json());
    json.setChangeOperation(ChangeOperation.ADD);
    json.setChangedFields(changedFields);
    json.setErrors(null);
    json.setRatingSchemeItem(null);
    json.setEntityKindReference(null);

    // Act
    ImmutableAssessmentRatingValidatedItem actualFromJsonResult =
        ImmutableAssessmentRatingValidatedItem.fromJson(json);

    // Assert
    Set<ChangedFieldType> changedFieldsResult = actualFromJsonResult.changedFields();
    assertEquals(1, changedFieldsResult.size());
    assertTrue(changedFieldsResult.contains(ChangedFieldType.ENTITY));
    assertTrue(actualFromJsonResult.errors().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingValidatedItem#toString()}
   *   <li>{@link ImmutableAssessmentRatingValidatedItem#changeOperation()}
   *   <li>{@link ImmutableAssessmentRatingValidatedItem#changedFields()}
   *   <li>{@link ImmutableAssessmentRatingValidatedItem#entityKindReference()}
   *   <li>{@link ImmutableAssessmentRatingValidatedItem#errors()}
   *   <li>{@link ImmutableAssessmentRatingValidatedItem#parsedItem()}
   *   <li>{@link ImmutableAssessmentRatingValidatedItem#ratingSchemeItem()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChangeOperation ImmutableAssessmentRatingValidatedItem.changeOperation()",
    "Set ImmutableAssessmentRatingValidatedItem.changedFields()",
    "EntityReference ImmutableAssessmentRatingValidatedItem.entityKindReference()",
    "Set ImmutableAssessmentRatingValidatedItem.errors()",
    "AssessmentRatingParsedItem ImmutableAssessmentRatingValidatedItem.parsedItem()",
    "RatingSchemeItem ImmutableAssessmentRatingValidatedItem.ratingSchemeItem()",
    "String ImmutableAssessmentRatingValidatedItem.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder changeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());
    ImmutableAssessmentRatingValidatedItem immutableAssessmentRatingValidatedItem =
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
            .build();

    // Act
    String actualToStringResult = immutableAssessmentRatingValidatedItem.toString();
    ChangeOperation actualChangeOperationResult =
        immutableAssessmentRatingValidatedItem.changeOperation();
    Set<ChangedFieldType> actualChangedFieldsResult =
        immutableAssessmentRatingValidatedItem.changedFields();
    EntityReference actualEntityKindReferenceResult =
        immutableAssessmentRatingValidatedItem.entityKindReference();
    Set<ValidationError> actualErrorsResult = immutableAssessmentRatingValidatedItem.errors();
    AssessmentRatingParsedItem actualParsedItemResult =
        immutableAssessmentRatingValidatedItem.parsedItem();

    // Assert
    assertTrue(actualEntityKindReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualParsedItemResult instanceof ImmutableAssessmentRatingParsedItem);
    assertTrue(
        immutableAssessmentRatingValidatedItem.ratingSchemeItem()
            instanceof ImmutableRatingSchemeItem);
    assertEquals(
        "AssessmentRatingValidatedItem{parsedItem=AssessmentRatingParsedItem{externalId=42, ratingCode=Rating"
            + " Code, isReadOnly=false, comment=Comment}, changeOperation=ADD, changedFields=[], errors=[],"
            + " ratingSchemeItem=RatingSchemeItem{id=1, name=Name, position=0, externalId=42, rating=Rating, color=Color,"
            + " ratingSchemeId=1, userSelectable=true, isRestricted=false, ratingGroup=Rating Group, requiresComment=false},"
            + " entityKindReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}}",
        actualToStringResult);
    assertEquals(ChangeOperation.ADD, actualChangeOperationResult);
    assertTrue(actualChangedFieldsResult.isEmpty());
    assertTrue(actualErrorsResult.isEmpty());
  }

  /**
   * Test Json {@link Json#changeOperation()}.
   *
   * <p>Method under test: {@link Json#changeOperation()}
   */
  @Test
  @DisplayName("Test Json changeOperation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChangeOperation Json.changeOperation()"})
  void testJsonChangeOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().changeOperation());
  }

  /**
   * Test Json {@link Json#changedFields()}.
   *
   * <p>Method under test: {@link Json#changedFields()}
   */
  @Test
  @DisplayName("Test Json changedFields()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.changedFields()"})
  void testJsonChangedFields() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().changedFields());
  }

  /**
   * Test Json {@link Json#entityKindReference()}.
   *
   * <p>Method under test: {@link Json#entityKindReference()}
   */
  @Test
  @DisplayName("Test Json entityKindReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.entityKindReference()"})
  void testJsonEntityKindReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityKindReference());
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
    assertNull(actualJson.entityKindReference);
    assertNull(actualJson.parsedItem);
    assertNull(actualJson.changeOperation);
    assertNull(actualJson.ratingSchemeItem);
    assertTrue(actualJson.changedFields.isEmpty());
    assertTrue(actualJson.errors.isEmpty());
  }

  /**
   * Test Json {@link Json#parsedItem()}.
   *
   * <p>Method under test: {@link Json#parsedItem()}
   */
  @Test
  @DisplayName("Test Json parsedItem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentRatingParsedItem Json.parsedItem()"})
  void testJsonParsedItem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parsedItem());
  }

  /**
   * Test Json {@link Json#ratingSchemeItem()}.
   *
   * <p>Method under test: {@link Json#ratingSchemeItem()}
   */
  @Test
  @DisplayName("Test Json ratingSchemeItem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RatingSchemeItem Json.ratingSchemeItem()"})
  void testJsonRatingSchemeItem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingSchemeItem());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidatedItem#withChangeOperation(ChangeOperation)}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingValidatedItem#withChangeOperation(ChangeOperation)}
   */
  @Test
  @DisplayName("Test withChangeOperation(ChangeOperation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidatedItem ImmutableAssessmentRatingValidatedItem.withChangeOperation(ChangeOperation)"
  })
  void testWithChangeOperation() {
    // Arrange
    Builder changeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());
    ImmutableAssessmentRatingValidatedItem immutableAssessmentRatingValidatedItem =
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
            .build();

    // Act
    ImmutableAssessmentRatingValidatedItem actualWithChangeOperationResult =
        immutableAssessmentRatingValidatedItem.withChangeOperation(ChangeOperation.ADD);

    // Assert
    assertSame(immutableAssessmentRatingValidatedItem, actualWithChangeOperationResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidatedItem#withChangeOperation(ChangeOperation)}.
   *
   * <ul>
   *   <li>Then entityKindReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingValidatedItem#withChangeOperation(ChangeOperation)}
   */
  @Test
  @DisplayName(
      "Test withChangeOperation(ChangeOperation); then entityKindReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidatedItem ImmutableAssessmentRatingValidatedItem.withChangeOperation(ChangeOperation)"
  })
  void testWithChangeOperation_thenEntityKindReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder changeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.REMOVE);

    Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());

    // Act
    ImmutableAssessmentRatingValidatedItem actualWithChangeOperationResult =
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
            .build()
            .withChangeOperation(ChangeOperation.ADD);

    // Assert
    assertTrue(
        actualWithChangeOperationResult.entityKindReference() instanceof ImmutableEntityReference);
    assertTrue(
        actualWithChangeOperationResult.parsedItem()
            instanceof ImmutableAssessmentRatingParsedItem);
    assertTrue(
        actualWithChangeOperationResult.ratingSchemeItem() instanceof ImmutableRatingSchemeItem);
    assertEquals(ChangeOperation.ADD, actualWithChangeOperationResult.changeOperation());
    assertTrue(actualWithChangeOperationResult.changedFields().isEmpty());
    assertTrue(actualWithChangeOperationResult.errors().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidatedItem#withChangedFields(ChangedFieldType[])} with
   * {@code ChangedFieldType[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingValidatedItem#withChangedFields(ChangedFieldType[])}
   */
  @Test
  @DisplayName("Test withChangedFields(ChangedFieldType[]) with 'ChangedFieldType[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidatedItem ImmutableAssessmentRatingValidatedItem.withChangedFields(ChangedFieldType[])"
  })
  void testWithChangedFieldsWithChangedFieldType() {
    // Arrange
    Builder changeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());

    // Act
    ImmutableAssessmentRatingValidatedItem actualWithChangedFieldsResult =
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
            .build()
            .withChangedFields(ChangedFieldType.ENTITY);

    // Assert
    assertTrue(
        actualWithChangedFieldsResult.entityKindReference() instanceof ImmutableEntityReference);
    assertTrue(
        actualWithChangedFieldsResult.parsedItem() instanceof ImmutableAssessmentRatingParsedItem);
    assertTrue(
        actualWithChangedFieldsResult.ratingSchemeItem() instanceof ImmutableRatingSchemeItem);
    assertEquals(1, actualWithChangedFieldsResult.changedFields().size());
    assertEquals(ChangeOperation.ADD, actualWithChangedFieldsResult.changeOperation());
    assertTrue(actualWithChangedFieldsResult.errors().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidatedItem#withChangedFields(Iterable)} with {@code
   * Iterable}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingValidatedItem#withChangedFields(Iterable)}
   */
  @Test
  @DisplayName("Test withChangedFields(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidatedItem ImmutableAssessmentRatingValidatedItem.withChangedFields(Iterable)"
  })
  void testWithChangedFieldsWithIterable() {
    // Arrange
    Builder changeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());
    ImmutableAssessmentRatingValidatedItem immutableAssessmentRatingValidatedItem =
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
            .build();

    LinkedHashSet<ChangedFieldType> elements = new LinkedHashSet<>();
    elements.add(ChangedFieldType.ENTITY);

    // Act
    ImmutableAssessmentRatingValidatedItem actualWithChangedFieldsResult =
        immutableAssessmentRatingValidatedItem.withChangedFields(elements);

    // Assert
    assertTrue(
        actualWithChangedFieldsResult.entityKindReference() instanceof ImmutableEntityReference);
    assertTrue(
        actualWithChangedFieldsResult.parsedItem() instanceof ImmutableAssessmentRatingParsedItem);
    assertTrue(
        actualWithChangedFieldsResult.ratingSchemeItem() instanceof ImmutableRatingSchemeItem);
    assertEquals(ChangeOperation.ADD, actualWithChangedFieldsResult.changeOperation());
    assertTrue(actualWithChangedFieldsResult.errors().isEmpty());
    assertEquals(elements, actualWithChangedFieldsResult.changedFields());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidatedItem#withEntityKindReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingValidatedItem#withEntityKindReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityKindReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidatedItem ImmutableAssessmentRatingValidatedItem.withEntityKindReference(EntityReference)"
  })
  void testWithEntityKindReference() {
    // Arrange
    Builder changeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());
    ImmutableAssessmentRatingValidatedItem immutableAssessmentRatingValidatedItem =
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
            .build();

    // Act
    ImmutableAssessmentRatingValidatedItem actualWithEntityKindReferenceResult =
        immutableAssessmentRatingValidatedItem.withEntityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableAssessmentRatingValidatedItem, actualWithEntityKindReferenceResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidatedItem#withErrors(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Then entityKindReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingValidatedItem#withErrors(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withErrors(Iterable) with 'Iterable'; then entityKindReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidatedItem ImmutableAssessmentRatingValidatedItem.withErrors(Iterable)"
  })
  void testWithErrorsWithIterable_thenEntityKindReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder changeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());
    ImmutableAssessmentRatingValidatedItem immutableAssessmentRatingValidatedItem =
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
            .build();

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.ENTITY_KIND_NOT_FOUND);

    // Act
    ImmutableAssessmentRatingValidatedItem actualWithErrorsResult =
        immutableAssessmentRatingValidatedItem.withErrors(elements);

    // Assert
    assertTrue(actualWithErrorsResult.entityKindReference() instanceof ImmutableEntityReference);
    assertTrue(actualWithErrorsResult.parsedItem() instanceof ImmutableAssessmentRatingParsedItem);
    assertTrue(actualWithErrorsResult.ratingSchemeItem() instanceof ImmutableRatingSchemeItem);
    assertEquals(ChangeOperation.ADD, actualWithErrorsResult.changeOperation());
    assertTrue(actualWithErrorsResult.changedFields().isEmpty());
    assertEquals(elements, actualWithErrorsResult.errors());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidatedItem#withErrors(ValidationError[])} with {@code
   * ValidationError[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingValidatedItem#withErrors(ValidationError[])}
   */
  @Test
  @DisplayName("Test withErrors(ValidationError[]) with 'ValidationError[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidatedItem ImmutableAssessmentRatingValidatedItem.withErrors(ValidationError[])"
  })
  void testWithErrorsWithValidationError() {
    // Arrange
    Builder changeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());

    // Act
    ImmutableAssessmentRatingValidatedItem actualWithErrorsResult =
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
            .build()
            .withErrors(ValidationError.ENTITY_KIND_NOT_FOUND);

    // Assert
    assertTrue(actualWithErrorsResult.entityKindReference() instanceof ImmutableEntityReference);
    assertTrue(actualWithErrorsResult.parsedItem() instanceof ImmutableAssessmentRatingParsedItem);
    assertTrue(actualWithErrorsResult.ratingSchemeItem() instanceof ImmutableRatingSchemeItem);
    assertEquals(1, actualWithErrorsResult.errors().size());
    assertEquals(ChangeOperation.ADD, actualWithErrorsResult.changeOperation());
    assertTrue(actualWithErrorsResult.changedFields().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidatedItem#withParsedItem(AssessmentRatingParsedItem)}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingValidatedItem#withParsedItem(AssessmentRatingParsedItem)}
   */
  @Test
  @DisplayName("Test withParsedItem(AssessmentRatingParsedItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidatedItem ImmutableAssessmentRatingValidatedItem.withParsedItem(AssessmentRatingParsedItem)"
  })
  void testWithParsedItem() {
    // Arrange
    Builder changeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());
    ImmutableAssessmentRatingValidatedItem immutableAssessmentRatingValidatedItem =
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
            .build();

    // Act
    ImmutableAssessmentRatingValidatedItem actualWithParsedItemResult =
        immutableAssessmentRatingValidatedItem.withParsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());

    // Assert
    assertEquals(immutableAssessmentRatingValidatedItem, actualWithParsedItemResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingValidatedItem#withRatingSchemeItem(RatingSchemeItem)}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingValidatedItem#withRatingSchemeItem(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test withRatingSchemeItem(RatingSchemeItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingValidatedItem ImmutableAssessmentRatingValidatedItem.withRatingSchemeItem(RatingSchemeItem)"
  })
  void testWithRatingSchemeItem() {
    // Arrange
    Builder changeOperationResult =
        ImmutableAssessmentRatingValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder entityKindReferenceResult =
        changeOperationResult.entityKindReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder parsedItemResult =
        entityKindReferenceResult.parsedItem(
            ImmutableAssessmentRatingParsedItem.builder()
                .comment("Comment")
                .externalId("42")
                .ratingCode("Rating Code")
                .build());
    ImmutableAssessmentRatingValidatedItem immutableAssessmentRatingValidatedItem =
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
            .build();

    // Act
    ImmutableAssessmentRatingValidatedItem actualWithRatingSchemeItemResult =
        immutableAssessmentRatingValidatedItem.withRatingSchemeItem(
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
    assertEquals(immutableAssessmentRatingValidatedItem, actualWithRatingSchemeItemResult);
  }
}
