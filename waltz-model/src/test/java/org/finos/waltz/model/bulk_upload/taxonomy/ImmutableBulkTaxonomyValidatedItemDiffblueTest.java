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
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.bulk_upload.ChangeOperation;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyValidatedItem.Builder;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyValidatedItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkTaxonomyValidatedItemDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllChangedFields(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code NAME}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code NAME}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllChangedFields(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllChangedFields(Iterable); given 'NAME'; when LinkedHashSet() add 'NAME'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllChangedFields(Iterable)"})
  void testBuilderAddAllChangedFields_givenName_whenLinkedHashSetAddName() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    LinkedHashSet<ChangedFieldType> elements = new LinkedHashSet<>();
    elements.add(ChangedFieldType.NAME);

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
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act
    Builder actualAddAllChangedFieldsResult = builderResult.addAllChangedFields(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllChangedFieldsResult);
  }

  /**
   * Test Builder {@link Builder#addAllErrors(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code PARENT_NOT_FOUND}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code PARENT_NOT_FOUND}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllErrors(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllErrors(Iterable); given 'PARENT_NOT_FOUND'; when LinkedHashSet() add 'PARENT_NOT_FOUND'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllErrors(Iterable)"})
  void testBuilderAddAllErrors_givenParentNotFound_whenLinkedHashSetAddParentNotFound() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.PARENT_NOT_FOUND);

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
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

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
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act
    Builder actualAddChangedFieldsResult = builderResult.addChangedFields(ChangedFieldType.NAME);

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
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act
    Builder actualAddChangedFieldsResult = builderResult.addChangedFields(ChangedFieldType.NAME);

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
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act
    Builder actualAddErrorsResult = builderResult.addErrors(ValidationError.PARENT_NOT_FOUND);

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
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act
    Builder actualAddErrorsResult = builderResult.addErrors(ValidationError.PARENT_NOT_FOUND);

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
   *   <li>{@link Builder#existingItemReference(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidatedItem Builder.build()",
    "Builder Builder.existingItemReference(EntityReference)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualChangeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);
    ImmutableEntityReference existingItemReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualExistingItemReferenceResult =
        actualChangeOperationResult.existingItemReference(existingItemReference);
    ImmutableBulkTaxonomyItem parsedItem =
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build();
    ImmutableBulkTaxonomyValidatedItem actualImmutableBulkTaxonomyValidatedItem =
        actualExistingItemReferenceResult.parsedItem(parsedItem).build();

    // Assert
    assertEquals(ChangeOperation.ADD, actualImmutableBulkTaxonomyValidatedItem.changeOperation());
    assertTrue(actualImmutableBulkTaxonomyValidatedItem.changedFields().isEmpty());
    assertTrue(actualImmutableBulkTaxonomyValidatedItem.errors().isEmpty());
    assertSame(
        existingItemReference, actualImmutableBulkTaxonomyValidatedItem.existingItemReference());
    assertSame(parsedItem, actualImmutableBulkTaxonomyValidatedItem.parsedItem());
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
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act
    Builder actualChangeOperationResult = builderResult.changeOperation(ChangeOperation.ADD);

    // Assert
    assertSame(builderResult, actualChangeOperationResult);
  }

  /**
   * Test Builder {@link Builder#changedFields(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code NAME}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code NAME}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#changedFields(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder changedFields(Iterable); given 'NAME'; when LinkedHashSet() add 'NAME'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.changedFields(Iterable)"})
  void testBuilderChangedFields_givenName_whenLinkedHashSetAddName() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    LinkedHashSet<ChangedFieldType> elements = new LinkedHashSet<>();
    elements.add(ChangedFieldType.NAME);

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
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act
    Builder actualChangedFieldsResult = builderResult.changedFields(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualChangedFieldsResult);
  }

  /**
   * Test Builder {@link Builder#errors(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code PARENT_NOT_FOUND}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code PARENT_NOT_FOUND}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#errors(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder errors(Iterable); given 'PARENT_NOT_FOUND'; when LinkedHashSet() add 'PARENT_NOT_FOUND'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.errors(Iterable)"})
  void testBuilderErrors_givenParentNotFound_whenLinkedHashSetAddParentNotFound() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.PARENT_NOT_FOUND);

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
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act
    Builder actualErrorsResult = builderResult.errors(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualErrorsResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyValidatedItem)}.
   *
   * <p>Method under test: {@link Builder#from(BulkTaxonomyValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyValidatedItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyValidatedItem)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkTaxonomyValidatedItem instance =
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkTaxonomyValidatedItem actualImmutableBulkTaxonomyValidatedItem =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkTaxonomyValidatedItem);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyValidatedItem)}.
   *
   * <p>Method under test: {@link Builder#from(BulkTaxonomyValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyValidatedItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyValidatedItem)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    Builder builderResult2 = ImmutableBulkTaxonomyValidatedItem.builder();
    builderResult2.addChangedFields(ChangedFieldType.NAME);

    Builder changeOperationResult = builderResult2.changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkTaxonomyValidatedItem instance =
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkTaxonomyValidatedItem actualImmutableBulkTaxonomyValidatedItem =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkTaxonomyValidatedItem);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyValidatedItem)}.
   *
   * <ul>
   *   <li>Given {@code DUPLICATE_EXT_ID}.
   *   <li>Then return build changedFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(BulkTaxonomyValidatedItem)}
   */
  @Test
  @DisplayName(
      "Test Builder from(BulkTaxonomyValidatedItem); given 'DUPLICATE_EXT_ID'; then return build changedFields size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyValidatedItem)"})
  void testBuilderFrom_givenDuplicateExtId_thenReturnBuildChangedFieldsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    Builder builderResult2 = ImmutableBulkTaxonomyValidatedItem.builder();
    builderResult2.addErrors(ValidationError.DUPLICATE_EXT_ID);
    builderResult2.addChangedFields(ChangedFieldType.NAME);

    Builder changeOperationResult = builderResult2.changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    ImmutableBulkTaxonomyValidatedItem immutableBulkTaxonomyValidatedItem =
        builderResult
            .from(
                existingItemReferenceResult
                    .parsedItem(
                        ImmutableBulkTaxonomyItem.builder()
                            .description("The characteristics of someone or something")
                            .externalId("42")
                            .name("Name")
                            .parentExternalId("42")
                            .build())
                    .build())
            .build();
    Set<ChangedFieldType> changedFieldsResult = immutableBulkTaxonomyValidatedItem.changedFields();
    assertEquals(1, changedFieldsResult.size());
    Set<ValidationError> errorsResult = immutableBulkTaxonomyValidatedItem.errors();
    assertEquals(1, errorsResult.size());
    assertTrue(changedFieldsResult.contains(ChangedFieldType.NAME));
    assertTrue(errorsResult.contains(ValidationError.DUPLICATE_EXT_ID));
  }

  /**
   * Test Builder {@link Builder#parsedItem(BulkTaxonomyItem)}.
   *
   * <ul>
   *   <li>When {@link ImmutableBulkTaxonomyItem.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#parsedItem(BulkTaxonomyItem)}
   */
  @Test
  @DisplayName(
      "Test Builder parsedItem(BulkTaxonomyItem); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parsedItem(BulkTaxonomyItem)"})
  void testBuilderParsedItem_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();

    // Act
    Builder actualParsedItemResult = builderResult.parsedItem(new ImmutableBulkTaxonomyItem.Json());

    // Assert
    assertSame(builderResult, actualParsedItemResult);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidatedItem#copyOf(BulkTaxonomyValidatedItem)}.
   *
   * <ul>
   *   <li>Then existingItemReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkTaxonomyValidatedItem#copyOf(BulkTaxonomyValidatedItem)}
   */
  @Test
  @DisplayName(
      "Test copyOf(BulkTaxonomyValidatedItem); then existingItemReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidatedItem ImmutableBulkTaxonomyValidatedItem.copyOf(BulkTaxonomyValidatedItem)"
  })
  void testCopyOf_thenExistingItemReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkTaxonomyValidatedItem instance =
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build();

    // Act
    ImmutableBulkTaxonomyValidatedItem actualCopyOfResult =
        ImmutableBulkTaxonomyValidatedItem.copyOf(instance);

    // Assert
    EntityReference existingItemReferenceResult2 = actualCopyOfResult.existingItemReference();
    assertTrue(existingItemReferenceResult2 instanceof ImmutableEntityReference);
    BulkTaxonomyItem parsedItemResult = actualCopyOfResult.parsedItem();
    assertTrue(parsedItemResult instanceof ImmutableBulkTaxonomyItem);
    assertEquals("42", parsedItemResult.externalId());
    assertEquals("42", parsedItemResult.parentExternalId());
    assertEquals("Name", parsedItemResult.name());
    assertEquals(
        "The characteristics of someone or something", existingItemReferenceResult2.description());
    assertEquals("The characteristics of someone or something", parsedItemResult.description());
    assertEquals(1L, existingItemReferenceResult2.id());
    assertEquals(EntityKind.ALL, existingItemReferenceResult2.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, existingItemReferenceResult2.entityLifecycleStatus());
    assertEquals(ChangeOperation.ADD, actualCopyOfResult.changeOperation());
    assertTrue(actualCopyOfResult.changedFields().isEmpty());
    assertTrue(actualCopyOfResult.errors().isEmpty());
    assertTrue(parsedItemResult.concrete());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidatedItem#equals(Object)}, and {@link
   * ImmutableBulkTaxonomyValidatedItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyValidatedItem#equals(Object)}
   *   <li>{@link ImmutableBulkTaxonomyValidatedItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyValidatedItem.equals(Object)",
    "int ImmutableBulkTaxonomyValidatedItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkTaxonomyValidatedItem immutableBulkTaxonomyValidatedItem =
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build();

    Builder changeOperationResult2 =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult2 =
        changeOperationResult2.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkTaxonomyValidatedItem immutableBulkTaxonomyValidatedItem2 =
        existingItemReferenceResult2
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableBulkTaxonomyValidatedItem, immutableBulkTaxonomyValidatedItem2);
    assertEquals(
        immutableBulkTaxonomyValidatedItem.hashCode(),
        immutableBulkTaxonomyValidatedItem2.hashCode());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidatedItem#equals(Object)}, and {@link
   * ImmutableBulkTaxonomyValidatedItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyValidatedItem#equals(Object)}
   *   <li>{@link ImmutableBulkTaxonomyValidatedItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyValidatedItem.equals(Object)",
    "int ImmutableBulkTaxonomyValidatedItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkTaxonomyValidatedItem immutableBulkTaxonomyValidatedItem =
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableBulkTaxonomyValidatedItem, immutableBulkTaxonomyValidatedItem);
    int expectedHashCodeResult = immutableBulkTaxonomyValidatedItem.hashCode();
    assertEquals(expectedHashCodeResult, immutableBulkTaxonomyValidatedItem.hashCode());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyValidatedItem.equals(Object)",
    "int ImmutableBulkTaxonomyValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();
    builderResult.addChangedFields(ChangedFieldType.NAME);

    Builder changeOperationResult = builderResult.changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkTaxonomyValidatedItem immutableBulkTaxonomyValidatedItem =
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build();

    Builder changeOperationResult2 =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult2 =
        changeOperationResult2.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableBulkTaxonomyValidatedItem,
        existingItemReferenceResult2
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyValidatedItem.equals(Object)",
    "int ImmutableBulkTaxonomyValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();
    builderResult.addErrors(ValidationError.PARENT_NOT_FOUND);

    Builder changeOperationResult = builderResult.changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkTaxonomyValidatedItem immutableBulkTaxonomyValidatedItem =
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build();

    Builder changeOperationResult2 =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult2 =
        changeOperationResult2.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableBulkTaxonomyValidatedItem,
        existingItemReferenceResult2
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyValidatedItem.equals(Object)",
    "int ImmutableBulkTaxonomyValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.REMOVE);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkTaxonomyValidatedItem immutableBulkTaxonomyValidatedItem =
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build();

    Builder changeOperationResult2 =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult2 =
        changeOperationResult2.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableBulkTaxonomyValidatedItem,
        existingItemReferenceResult2
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyValidatedItem.equals(Object)",
    "int ImmutableBulkTaxonomyValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkTaxonomyValidatedItem immutableBulkTaxonomyValidatedItem =
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build();

    Builder changeOperationResult2 =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult2 =
        changeOperationResult2.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableBulkTaxonomyValidatedItem,
        existingItemReferenceResult2
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyValidatedItem.equals(Object)",
    "int ImmutableBulkTaxonomyValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkTaxonomyValidatedItem immutableBulkTaxonomyValidatedItem =
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("Name")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build();

    Builder changeOperationResult2 =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult2 =
        changeOperationResult2.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableBulkTaxonomyValidatedItem,
        existingItemReferenceResult2
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyValidatedItem.equals(Object)",
    "int ImmutableBulkTaxonomyValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyValidatedItem.equals(Object)",
    "int ImmutableBulkTaxonomyValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build(),
        "Different type to ImmutableBulkTaxonomyValidatedItem");
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidatedItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code NAME}.
   *   <li>Then return changedFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyValidatedItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add 'NAME'; then return changedFields size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidatedItem ImmutableBulkTaxonomyValidatedItem.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddName_thenReturnChangedFieldsSizeIsOne() {
    // Arrange
    LinkedHashSet<ChangedFieldType> changedFields = new LinkedHashSet<>();
    changedFields.add(ChangedFieldType.NAME);

    LinkedHashSet<ValidationError> errors = new LinkedHashSet<>();
    errors.add(ValidationError.PARENT_NOT_FOUND);

    Json json = new Json();
    json.setParsedItem(new ImmutableBulkTaxonomyItem.Json());
    json.setChangeOperation(ChangeOperation.ADD);
    json.setChangedFields(changedFields);
    json.setErrors(errors);
    json.setExistingItemReference(null);

    // Act
    ImmutableBulkTaxonomyValidatedItem actualFromJsonResult =
        ImmutableBulkTaxonomyValidatedItem.fromJson(json);

    // Assert
    Set<ChangedFieldType> changedFieldsResult = actualFromJsonResult.changedFields();
    assertEquals(1, changedFieldsResult.size());
    Set<ValidationError> errorsResult = actualFromJsonResult.errors();
    assertEquals(1, errorsResult.size());
    assertTrue(changedFieldsResult.contains(ChangedFieldType.NAME));
    assertTrue(errorsResult.contains(ValidationError.PARENT_NOT_FOUND));
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidatedItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then parsedItem return {@link ImmutableBulkTaxonomyItem}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyValidatedItem#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then parsedItem return ImmutableBulkTaxonomyItem")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidatedItem ImmutableBulkTaxonomyValidatedItem.fromJson(Json)"
  })
  void testFromJson_thenParsedItemReturnImmutableBulkTaxonomyItem() {
    // Arrange
    LinkedHashSet<ChangedFieldType> changedFields = new LinkedHashSet<>();
    changedFields.add(ChangedFieldType.NAME);

    LinkedHashSet<ValidationError> errors = new LinkedHashSet<>();
    errors.add(ValidationError.PARENT_NOT_FOUND);

    Json json = new Json();
    json.setParsedItem(
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build());
    json.setChangeOperation(ChangeOperation.ADD);
    json.setChangedFields(changedFields);
    json.setErrors(errors);
    json.setExistingItemReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutableBulkTaxonomyValidatedItem actualFromJsonResult =
        ImmutableBulkTaxonomyValidatedItem.fromJson(json);

    // Assert
    BulkTaxonomyItem parsedItemResult = actualFromJsonResult.parsedItem();
    assertTrue(parsedItemResult instanceof ImmutableBulkTaxonomyItem);
    assertEquals("42", parsedItemResult.externalId());
    assertEquals("42", parsedItemResult.parentExternalId());
    assertEquals("Name", parsedItemResult.name());
    assertEquals("The characteristics of someone or something", parsedItemResult.description());
    assertTrue(parsedItemResult.concrete());
    EntityReference expectedExistingItemReferenceResult = json.existingItemReference;
    assertSame(expectedExistingItemReferenceResult, actualFromJsonResult.existingItemReference());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidatedItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) ChangedFields is {@code null}.
   *   <li>Then return changedFields Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyValidatedItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) ChangedFields is 'null'; then return changedFields Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidatedItem ImmutableBulkTaxonomyValidatedItem.fromJson(Json)"
  })
  void testFromJson_whenJsonChangedFieldsIsNull_thenReturnChangedFieldsEmpty() {
    // Arrange
    LinkedHashSet<ValidationError> errors = new LinkedHashSet<>();
    errors.add(ValidationError.PARENT_NOT_FOUND);

    Json json = new Json();
    json.setParsedItem(new ImmutableBulkTaxonomyItem.Json());
    json.setChangeOperation(ChangeOperation.ADD);
    json.setChangedFields(null);
    json.setErrors(errors);
    json.setExistingItemReference(null);

    // Act
    ImmutableBulkTaxonomyValidatedItem actualFromJsonResult =
        ImmutableBulkTaxonomyValidatedItem.fromJson(json);

    // Assert
    Set<ValidationError> errorsResult = actualFromJsonResult.errors();
    assertEquals(1, errorsResult.size());
    assertTrue(errorsResult.contains(ValidationError.PARENT_NOT_FOUND));
    assertTrue(actualFromJsonResult.changedFields().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidatedItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Errors is {@code null}.
   *   <li>Then return errors Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyValidatedItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Errors is 'null'; then return errors Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidatedItem ImmutableBulkTaxonomyValidatedItem.fromJson(Json)"
  })
  void testFromJson_whenJsonErrorsIsNull_thenReturnErrorsEmpty() {
    // Arrange
    LinkedHashSet<ChangedFieldType> changedFields = new LinkedHashSet<>();
    changedFields.add(ChangedFieldType.NAME);

    Json json = new Json();
    json.setParsedItem(new ImmutableBulkTaxonomyItem.Json());
    json.setChangeOperation(ChangeOperation.ADD);
    json.setChangedFields(changedFields);
    json.setErrors(null);
    json.setExistingItemReference(null);

    // Act
    ImmutableBulkTaxonomyValidatedItem actualFromJsonResult =
        ImmutableBulkTaxonomyValidatedItem.fromJson(json);

    // Assert
    Set<ChangedFieldType> changedFieldsResult = actualFromJsonResult.changedFields();
    assertEquals(1, changedFieldsResult.size());
    assertTrue(changedFieldsResult.contains(ChangedFieldType.NAME));
    assertTrue(actualFromJsonResult.errors().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyValidatedItem#toString()}
   *   <li>{@link ImmutableBulkTaxonomyValidatedItem#changeOperation()}
   *   <li>{@link ImmutableBulkTaxonomyValidatedItem#changedFields()}
   *   <li>{@link ImmutableBulkTaxonomyValidatedItem#errors()}
   *   <li>{@link ImmutableBulkTaxonomyValidatedItem#existingItemReference()}
   *   <li>{@link ImmutableBulkTaxonomyValidatedItem#parsedItem()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChangeOperation ImmutableBulkTaxonomyValidatedItem.changeOperation()",
    "Set ImmutableBulkTaxonomyValidatedItem.changedFields()",
    "Set ImmutableBulkTaxonomyValidatedItem.errors()",
    "EntityReference ImmutableBulkTaxonomyValidatedItem.existingItemReference()",
    "BulkTaxonomyItem ImmutableBulkTaxonomyValidatedItem.parsedItem()",
    "String ImmutableBulkTaxonomyValidatedItem.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkTaxonomyValidatedItem immutableBulkTaxonomyValidatedItem =
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableBulkTaxonomyValidatedItem.toString();
    ChangeOperation actualChangeOperationResult =
        immutableBulkTaxonomyValidatedItem.changeOperation();
    Set<ChangedFieldType> actualChangedFieldsResult =
        immutableBulkTaxonomyValidatedItem.changedFields();
    Set<ValidationError> actualErrorsResult = immutableBulkTaxonomyValidatedItem.errors();
    EntityReference actualExistingItemReferenceResult =
        immutableBulkTaxonomyValidatedItem.existingItemReference();

    // Assert
    assertTrue(actualExistingItemReferenceResult instanceof ImmutableEntityReference);
    assertTrue(
        immutableBulkTaxonomyValidatedItem.parsedItem() instanceof ImmutableBulkTaxonomyItem);
    assertEquals(
        "BulkTaxonomyValidatedItem{parsedItem=BulkTaxonomyItem{name=Name, externalId=42, parentExternalId=42,"
            + " description=The characteristics of someone or something, concrete=true}, changeOperation=ADD,"
            + " changedFields=[], errors=[], existingItemReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}}",
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
   * Test Json {@link Json#existingItemReference()}.
   *
   * <p>Method under test: {@link Json#existingItemReference()}
   */
  @Test
  @DisplayName("Test Json existingItemReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.existingItemReference()"})
  void testJsonExistingItemReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().existingItemReference());
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
    assertNull(actualJson.existingItemReference);
    assertNull(actualJson.changeOperation);
    assertNull(actualJson.parsedItem);
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
  @MethodsUnderTest({"BulkTaxonomyItem Json.parsedItem()"})
  void testJsonParsedItem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parsedItem());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidatedItem#withChangeOperation(ChangeOperation)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkTaxonomyValidatedItem#withChangeOperation(ChangeOperation)}
   */
  @Test
  @DisplayName("Test withChangeOperation(ChangeOperation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidatedItem ImmutableBulkTaxonomyValidatedItem.withChangeOperation(ChangeOperation)"
  })
  void testWithChangeOperation() {
    // Arrange
    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkTaxonomyValidatedItem immutableBulkTaxonomyValidatedItem =
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build();

    // Act
    ImmutableBulkTaxonomyValidatedItem actualWithChangeOperationResult =
        immutableBulkTaxonomyValidatedItem.withChangeOperation(ChangeOperation.ADD);

    // Assert
    assertSame(immutableBulkTaxonomyValidatedItem, actualWithChangeOperationResult);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidatedItem#withChangeOperation(ChangeOperation)}.
   *
   * <ul>
   *   <li>Then existingItemReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkTaxonomyValidatedItem#withChangeOperation(ChangeOperation)}
   */
  @Test
  @DisplayName(
      "Test withChangeOperation(ChangeOperation); then existingItemReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidatedItem ImmutableBulkTaxonomyValidatedItem.withChangeOperation(ChangeOperation)"
  })
  void testWithChangeOperation_thenExistingItemReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.REMOVE);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableBulkTaxonomyValidatedItem actualWithChangeOperationResult =
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build()
            .withChangeOperation(ChangeOperation.ADD);

    // Assert
    EntityReference existingItemReferenceResult2 =
        actualWithChangeOperationResult.existingItemReference();
    assertTrue(existingItemReferenceResult2 instanceof ImmutableEntityReference);
    BulkTaxonomyItem parsedItemResult = actualWithChangeOperationResult.parsedItem();
    assertTrue(parsedItemResult instanceof ImmutableBulkTaxonomyItem);
    assertEquals("42", parsedItemResult.externalId());
    assertEquals("42", parsedItemResult.parentExternalId());
    assertEquals("Name", parsedItemResult.name());
    assertEquals(
        "The characteristics of someone or something", existingItemReferenceResult2.description());
    assertEquals("The characteristics of someone or something", parsedItemResult.description());
    assertEquals(1L, existingItemReferenceResult2.id());
    assertEquals(EntityKind.ALL, existingItemReferenceResult2.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, existingItemReferenceResult2.entityLifecycleStatus());
    assertEquals(ChangeOperation.ADD, actualWithChangeOperationResult.changeOperation());
    assertTrue(actualWithChangeOperationResult.changedFields().isEmpty());
    assertTrue(actualWithChangeOperationResult.errors().isEmpty());
    assertTrue(parsedItemResult.concrete());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidatedItem#withChangedFields(ChangedFieldType[])} with
   * {@code ChangedFieldType[]}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkTaxonomyValidatedItem#withChangedFields(ChangedFieldType[])}
   */
  @Test
  @DisplayName("Test withChangedFields(ChangedFieldType[]) with 'ChangedFieldType[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidatedItem ImmutableBulkTaxonomyValidatedItem.withChangedFields(ChangedFieldType[])"
  })
  void testWithChangedFieldsWithChangedFieldType() {
    // Arrange
    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableBulkTaxonomyValidatedItem actualWithChangedFieldsResult =
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build()
            .withChangedFields(ChangedFieldType.NAME);

    // Assert
    EntityReference existingItemReferenceResult2 =
        actualWithChangedFieldsResult.existingItemReference();
    assertTrue(existingItemReferenceResult2 instanceof ImmutableEntityReference);
    BulkTaxonomyItem parsedItemResult = actualWithChangedFieldsResult.parsedItem();
    assertTrue(parsedItemResult instanceof ImmutableBulkTaxonomyItem);
    assertEquals("42", parsedItemResult.externalId());
    assertEquals("42", parsedItemResult.parentExternalId());
    assertEquals("Name", parsedItemResult.name());
    assertEquals(
        "The characteristics of someone or something", existingItemReferenceResult2.description());
    assertEquals("The characteristics of someone or something", parsedItemResult.description());
    Set<ChangedFieldType> changedFieldsResult = actualWithChangedFieldsResult.changedFields();
    assertEquals(1, changedFieldsResult.size());
    assertEquals(1L, existingItemReferenceResult2.id());
    assertEquals(EntityKind.ALL, existingItemReferenceResult2.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, existingItemReferenceResult2.entityLifecycleStatus());
    assertEquals(ChangeOperation.ADD, actualWithChangedFieldsResult.changeOperation());
    assertTrue(changedFieldsResult.contains(ChangedFieldType.NAME));
    assertTrue(actualWithChangedFieldsResult.errors().isEmpty());
    assertTrue(parsedItemResult.concrete());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidatedItem#withChangedFields(Iterable)} with {@code
   * Iterable}.
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyValidatedItem#withChangedFields(Iterable)}
   */
  @Test
  @DisplayName("Test withChangedFields(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidatedItem ImmutableBulkTaxonomyValidatedItem.withChangedFields(Iterable)"
  })
  void testWithChangedFieldsWithIterable() {
    // Arrange
    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkTaxonomyValidatedItem immutableBulkTaxonomyValidatedItem =
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build();

    LinkedHashSet<ChangedFieldType> elements = new LinkedHashSet<>();
    elements.add(ChangedFieldType.NAME);

    // Act
    ImmutableBulkTaxonomyValidatedItem actualWithChangedFieldsResult =
        immutableBulkTaxonomyValidatedItem.withChangedFields(elements);

    // Assert
    EntityReference existingItemReferenceResult2 =
        actualWithChangedFieldsResult.existingItemReference();
    assertTrue(existingItemReferenceResult2 instanceof ImmutableEntityReference);
    BulkTaxonomyItem parsedItemResult = actualWithChangedFieldsResult.parsedItem();
    assertTrue(parsedItemResult instanceof ImmutableBulkTaxonomyItem);
    assertEquals("42", parsedItemResult.externalId());
    assertEquals("42", parsedItemResult.parentExternalId());
    assertEquals("Name", parsedItemResult.name());
    assertEquals(
        "The characteristics of someone or something", existingItemReferenceResult2.description());
    assertEquals("The characteristics of someone or something", parsedItemResult.description());
    assertEquals(1L, existingItemReferenceResult2.id());
    assertEquals(EntityKind.ALL, existingItemReferenceResult2.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, existingItemReferenceResult2.entityLifecycleStatus());
    assertEquals(ChangeOperation.ADD, actualWithChangedFieldsResult.changeOperation());
    assertTrue(actualWithChangedFieldsResult.errors().isEmpty());
    assertTrue(parsedItemResult.concrete());
    assertEquals(elements, actualWithChangedFieldsResult.changedFields());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidatedItem#withErrors(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyValidatedItem#withErrors(Iterable)}
   */
  @Test
  @DisplayName("Test withErrors(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidatedItem ImmutableBulkTaxonomyValidatedItem.withErrors(Iterable)"
  })
  void testWithErrorsWithIterable() {
    // Arrange
    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkTaxonomyValidatedItem immutableBulkTaxonomyValidatedItem =
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build();

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.PARENT_NOT_FOUND);

    // Act
    ImmutableBulkTaxonomyValidatedItem actualWithErrorsResult =
        immutableBulkTaxonomyValidatedItem.withErrors(elements);

    // Assert
    EntityReference existingItemReferenceResult2 = actualWithErrorsResult.existingItemReference();
    assertTrue(existingItemReferenceResult2 instanceof ImmutableEntityReference);
    BulkTaxonomyItem parsedItemResult = actualWithErrorsResult.parsedItem();
    assertTrue(parsedItemResult instanceof ImmutableBulkTaxonomyItem);
    assertEquals("42", parsedItemResult.externalId());
    assertEquals("42", parsedItemResult.parentExternalId());
    assertEquals("Name", parsedItemResult.name());
    assertEquals(
        "The characteristics of someone or something", existingItemReferenceResult2.description());
    assertEquals("The characteristics of someone or something", parsedItemResult.description());
    assertEquals(1L, existingItemReferenceResult2.id());
    assertEquals(EntityKind.ALL, existingItemReferenceResult2.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, existingItemReferenceResult2.entityLifecycleStatus());
    assertEquals(ChangeOperation.ADD, actualWithErrorsResult.changeOperation());
    assertTrue(actualWithErrorsResult.changedFields().isEmpty());
    assertTrue(parsedItemResult.concrete());
    assertEquals(elements, actualWithErrorsResult.errors());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidatedItem#withErrors(ValidationError[])} with {@code
   * ValidationError[]}.
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyValidatedItem#withErrors(ValidationError[])}
   */
  @Test
  @DisplayName("Test withErrors(ValidationError[]) with 'ValidationError[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidatedItem ImmutableBulkTaxonomyValidatedItem.withErrors(ValidationError[])"
  })
  void testWithErrorsWithValidationError() {
    // Arrange
    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableBulkTaxonomyValidatedItem actualWithErrorsResult =
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build()
            .withErrors(ValidationError.PARENT_NOT_FOUND);

    // Assert
    EntityReference existingItemReferenceResult2 = actualWithErrorsResult.existingItemReference();
    assertTrue(existingItemReferenceResult2 instanceof ImmutableEntityReference);
    BulkTaxonomyItem parsedItemResult = actualWithErrorsResult.parsedItem();
    assertTrue(parsedItemResult instanceof ImmutableBulkTaxonomyItem);
    assertEquals("42", parsedItemResult.externalId());
    assertEquals("42", parsedItemResult.parentExternalId());
    assertEquals("Name", parsedItemResult.name());
    assertEquals(
        "The characteristics of someone or something", existingItemReferenceResult2.description());
    assertEquals("The characteristics of someone or something", parsedItemResult.description());
    Set<ValidationError> errorsResult = actualWithErrorsResult.errors();
    assertEquals(1, errorsResult.size());
    assertEquals(1L, existingItemReferenceResult2.id());
    assertEquals(EntityKind.ALL, existingItemReferenceResult2.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, existingItemReferenceResult2.entityLifecycleStatus());
    assertEquals(ChangeOperation.ADD, actualWithErrorsResult.changeOperation());
    assertTrue(errorsResult.contains(ValidationError.PARENT_NOT_FOUND));
    assertTrue(actualWithErrorsResult.changedFields().isEmpty());
    assertTrue(parsedItemResult.concrete());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidatedItem#withExistingItemReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkTaxonomyValidatedItem#withExistingItemReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withExistingItemReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidatedItem ImmutableBulkTaxonomyValidatedItem.withExistingItemReference(EntityReference)"
  })
  void testWithExistingItemReference() {
    // Arrange
    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkTaxonomyValidatedItem immutableBulkTaxonomyValidatedItem =
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build();

    // Act
    ImmutableBulkTaxonomyValidatedItem actualWithExistingItemReferenceResult =
        immutableBulkTaxonomyValidatedItem.withExistingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableBulkTaxonomyValidatedItem, actualWithExistingItemReferenceResult);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidatedItem#withParsedItem(BulkTaxonomyItem)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkTaxonomyValidatedItem#withParsedItem(BulkTaxonomyItem)}
   */
  @Test
  @DisplayName("Test withParsedItem(BulkTaxonomyItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidatedItem ImmutableBulkTaxonomyValidatedItem.withParsedItem(BulkTaxonomyItem)"
  })
  void testWithParsedItem() {
    // Arrange
    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkTaxonomyValidatedItem immutableBulkTaxonomyValidatedItem =
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build();

    // Act
    ImmutableBulkTaxonomyValidatedItem actualWithParsedItemResult =
        immutableBulkTaxonomyValidatedItem.withParsedItem(
            ImmutableBulkTaxonomyItem.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .name("Name")
                .parentExternalId("42")
                .build());

    // Assert
    assertEquals(immutableBulkTaxonomyValidatedItem, actualWithParsedItemResult);
  }
}
