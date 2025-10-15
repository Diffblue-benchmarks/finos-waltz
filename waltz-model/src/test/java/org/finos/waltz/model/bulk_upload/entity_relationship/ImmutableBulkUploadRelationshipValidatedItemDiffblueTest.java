package org.finos.waltz.model.bulk_upload.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipValidatedItem.Builder;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipValidatedItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkUploadRelationshipValidatedItemDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllError(Iterable)}.
   *
   * <ul>
   *   <li>Given builder.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllError(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllError(Iterable); given builder; when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllError(Iterable)"})
  void testBuilderAddAllError_givenBuilder_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();

    // Act
    Builder actualAddAllErrorResult = builderResult.addAllError(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllErrorResult);
  }

  /**
   * Test Builder {@link Builder#addAllError(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code SOURCE_INVALID}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code SOURCE_INVALID}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllError(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllError(Iterable); given 'SOURCE_INVALID'; when LinkedHashSet() add 'SOURCE_INVALID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllError(Iterable)"})
  void testBuilderAddAllError_givenSourceInvalid_whenLinkedHashSetAddSourceInvalid() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();
    builderResult.addError(ValidationError.SOURCE_INVALID);

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.SOURCE_INVALID);

    // Act
    Builder actualAddAllErrorResult = builderResult.addAllError(elements);

    // Assert
    assertSame(builderResult, actualAddAllErrorResult);
  }

  /**
   * Test Builder {@link Builder#addError(ValidationError)} with {@code element}.
   *
   * <ul>
   *   <li>Given builder addError {@code SOURCE_INVALID}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addError(ValidationError)}
   */
  @Test
  @DisplayName(
      "Test Builder addError(ValidationError) with 'element'; given builder addError 'SOURCE_INVALID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addError(ValidationError)"})
  void testBuilderAddErrorWithElement_givenBuilderAddErrorSourceInvalid() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();
    builderResult.addError(ValidationError.SOURCE_INVALID);

    // Act
    Builder actualAddErrorResult = builderResult.addError(ValidationError.SOURCE_INVALID);

    // Assert
    assertSame(builderResult, actualAddErrorResult);
  }

  /**
   * Test Builder {@link Builder#addError(ValidationError)} with {@code element}.
   *
   * <ul>
   *   <li>Given builder.
   *   <li>When {@code SOURCE_INVALID}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addError(ValidationError)}
   */
  @Test
  @DisplayName(
      "Test Builder addError(ValidationError) with 'element'; given builder; when 'SOURCE_INVALID'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addError(ValidationError)"})
  void testBuilderAddErrorWithElement_givenBuilder_whenSourceInvalid_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();

    // Act
    Builder actualAddErrorResult = builderResult.addError(ValidationError.SOURCE_INVALID);

    // Assert
    assertSame(builderResult, actualAddErrorResult);
  }

  /**
   * Test Builder {@link Builder#addError(ValidationError[])} with {@code elements}.
   *
   * <ul>
   *   <li>Given builder addError {@code SOURCE_INVALID}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addError(ValidationError[])}
   */
  @Test
  @DisplayName(
      "Test Builder addError(ValidationError[]) with 'elements'; given builder addError 'SOURCE_INVALID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addError(ValidationError[])"})
  void testBuilderAddErrorWithElements_givenBuilderAddErrorSourceInvalid() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();
    builderResult.addError(ValidationError.SOURCE_INVALID);

    // Act
    Builder actualAddErrorResult = builderResult.addError(ValidationError.SOURCE_INVALID);

    // Assert
    assertSame(builderResult, actualAddErrorResult);
  }

  /**
   * Test Builder {@link Builder#addError(ValidationError[])} with {@code elements}.
   *
   * <ul>
   *   <li>Given builder.
   *   <li>When {@code SOURCE_INVALID}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addError(ValidationError[])}
   */
  @Test
  @DisplayName(
      "Test Builder addError(ValidationError[]) with 'elements'; given builder; when 'SOURCE_INVALID'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addError(ValidationError[])"})
  void testBuilderAddErrorWithElements_givenBuilder_whenSourceInvalid_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();

    // Act
    Builder actualAddErrorResult = builderResult.addError(ValidationError.SOURCE_INVALID);

    // Assert
    assertSame(builderResult, actualAddErrorResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#sourceEntityRef(EntityReference)}
   *   <li>{@link Builder#targetEntityRef(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidatedItem Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.sourceEntityRef(EntityReference)",
    "Builder Builder.targetEntityRef(EntityReference)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();
    Builder actualDescriptionResult =
        actualBuilderResult
            .addAllError(new ArrayList<>())
            .addError(ValidationError.SOURCE_INVALID)
            .addError(ValidationError.SOURCE_INVALID)
            .description("The characteristics of someone or something");
    Builder actualErrorResult = actualDescriptionResult.error(new ArrayList<>());
    ImmutableBulkUploadRelationshipItem parsedItem =
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("42")
            .targetExternalId("42")
            .build();
    Builder actualParsedItemResult = actualErrorResult.parsedItem(parsedItem);
    ImmutableEntityReference sourceEntityRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualSourceEntityRefResult = actualParsedItemResult.sourceEntityRef(sourceEntityRef);
    ImmutableEntityReference targetEntityRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableBulkUploadRelationshipValidatedItem
        actualImmutableBulkUploadRelationshipValidatedItem =
            actualSourceEntityRefResult
                .targetEntityRef(targetEntityRef)
                .uploadOperation(UploadOperation.ADD)
                .build();

    // Assert
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableBulkUploadRelationshipValidatedItem.description());
    assertEquals(
        UploadOperation.ADD, actualImmutableBulkUploadRelationshipValidatedItem.uploadOperation());
    assertTrue(actualImmutableBulkUploadRelationshipValidatedItem.error().isEmpty());
    assertSame(
        sourceEntityRef, actualImmutableBulkUploadRelationshipValidatedItem.sourceEntityRef());
    assertSame(
        targetEntityRef, actualImmutableBulkUploadRelationshipValidatedItem.targetEntityRef());
    assertSame(parsedItem, actualImmutableBulkUploadRelationshipValidatedItem.parsedItem());
  }

  /**
   * Test Builder {@link Builder#error(Iterable)}.
   *
   * <ul>
   *   <li>Given builder addError {@code SOURCE_INVALID}.
   *   <li>When {@code null}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#error(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder error(Iterable); given builder addError 'SOURCE_INVALID'; when 'null'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.error(Iterable)"})
  void testBuilderError_givenBuilderAddErrorSourceInvalid_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();
    builderResult.addError(ValidationError.SOURCE_INVALID);

    // Act
    Builder actualErrorResult = builderResult.error(null);

    // Assert
    assertSame(builderResult, actualErrorResult);
  }

  /**
   * Test Builder {@link Builder#error(Iterable)}.
   *
   * <ul>
   *   <li>Given builder.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#error(Iterable)}
   */
  @Test
  @DisplayName("Test Builder error(Iterable); given builder; when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.error(Iterable)"})
  void testBuilderError_givenBuilder_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();

    // Act
    Builder actualErrorResult = builderResult.error(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualErrorResult);
  }

  /**
   * Test Builder {@link Builder#error(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code SOURCE_INVALID}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code SOURCE_INVALID}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#error(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder error(Iterable); given 'SOURCE_INVALID'; when LinkedHashSet() add 'SOURCE_INVALID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.error(Iterable)"})
  void testBuilderError_givenSourceInvalid_whenLinkedHashSetAddSourceInvalid() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();
    builderResult.addError(ValidationError.SOURCE_INVALID);

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.SOURCE_INVALID);

    // Act
    Builder actualErrorResult = builderResult.error(elements);

    // Assert
    assertSame(builderResult, actualErrorResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipValidatedItem)}.
   *
   * <p>Method under test: {@link Builder#from(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipValidatedItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipValidatedItem)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();

    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkUploadRelationshipValidatedItem instance =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build();

    // Act and Assert
    ImmutableBulkUploadRelationshipValidatedItem
        actualImmutableBulkUploadRelationshipValidatedItem = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableBulkUploadRelationshipValidatedItem);
    ImmutableBulkUploadRelationshipValidatedItem
        actualImmutableBulkUploadRelationshipValidatedItem2 = builderResult.build();
    assertEquals(instance, actualImmutableBulkUploadRelationshipValidatedItem2);
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipValidatedItem)}.
   *
   * <p>Method under test: {@link Builder#from(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipValidatedItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipValidatedItem)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();
    builderResult.addError(ValidationError.SOURCE_INVALID);

    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    builderResult.from(
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build());

    // Assert
    ImmutableBulkUploadRelationshipValidatedItem immutableBulkUploadRelationshipValidatedItem =
        builderResult.build();
    assertEquals(
        "The characteristics of someone or something",
        immutableBulkUploadRelationshipValidatedItem.description());
    Set<ValidationError> errorResult = immutableBulkUploadRelationshipValidatedItem.error();
    assertEquals(1, errorResult.size());
    assertEquals(
        UploadOperation.ADD, immutableBulkUploadRelationshipValidatedItem.uploadOperation());
    assertTrue(errorResult.contains(ValidationError.SOURCE_INVALID));
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipValidatedItem)}.
   *
   * <p>Method under test: {@link Builder#from(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipValidatedItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipValidatedItem)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();

    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder().description(null);

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkUploadRelationshipValidatedItem instance =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build();

    // Act and Assert
    ImmutableBulkUploadRelationshipValidatedItem
        actualImmutableBulkUploadRelationshipValidatedItem = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableBulkUploadRelationshipValidatedItem);
    ImmutableBulkUploadRelationshipValidatedItem
        actualImmutableBulkUploadRelationshipValidatedItem2 = builderResult.build();
    assertEquals(instance, actualImmutableBulkUploadRelationshipValidatedItem2);
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipValidatedItem)}.
   *
   * <ul>
   *   <li>Given {@code SOURCE_INVALID}.
   *   <li>Then return build error size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  @DisplayName(
      "Test Builder from(BulkUploadRelationshipValidatedItem); given 'SOURCE_INVALID'; then return build error size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipValidatedItem)"})
  void testBuilderFrom_givenSourceInvalid_thenReturnBuildErrorSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();

    Builder builderResult2 = ImmutableBulkUploadRelationshipValidatedItem.builder();
    builderResult2.addError(ValidationError.SOURCE_INVALID);

    Builder descriptionResult =
        builderResult2.description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkUploadRelationshipValidatedItem instance =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build();

    // Act and Assert
    Set<ValidationError> errorResult = builderResult.from(instance).build().error();
    assertEquals(1, errorResult.size());
    assertTrue(errorResult.contains(ValidationError.SOURCE_INVALID));
    ImmutableBulkUploadRelationshipValidatedItem
        actualImmutableBulkUploadRelationshipValidatedItem = builderResult.build();
    assertEquals(instance, actualImmutableBulkUploadRelationshipValidatedItem);
  }

  /**
   * Test Builder {@link Builder#parsedItem(BulkUploadRelationshipItem)}.
   *
   * <ul>
   *   <li>When {@link ImmutableBulkUploadRelationshipItem.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#parsedItem(BulkUploadRelationshipItem)}
   */
  @Test
  @DisplayName(
      "Test Builder parsedItem(BulkUploadRelationshipItem); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parsedItem(BulkUploadRelationshipItem)"})
  void testBuilderParsedItem_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();

    // Act
    Builder actualParsedItemResult =
        builderResult.parsedItem(new ImmutableBulkUploadRelationshipItem.Json());

    // Assert
    assertSame(builderResult, actualParsedItemResult);
  }

  /**
   * Test Builder {@link Builder#uploadOperation(UploadOperation)}.
   *
   * <p>Method under test: {@link Builder#uploadOperation(UploadOperation)}
   */
  @Test
  @DisplayName("Test Builder uploadOperation(UploadOperation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.uploadOperation(UploadOperation)"})
  void testBuilderUploadOperation() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();

    // Act
    Builder actualUploadOperationResult = builderResult.uploadOperation(UploadOperation.ADD);

    // Assert
    assertSame(builderResult, actualUploadOperationResult);
  }

  /**
   * Test {@link
   * ImmutableBulkUploadRelationshipValidatedItem#copyOf(BulkUploadRelationshipValidatedItem)}.
   *
   * <ul>
   *   <li>Then sourceEntityRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadRelationshipValidatedItem#copyOf(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  @DisplayName(
      "Test copyOf(BulkUploadRelationshipValidatedItem); then sourceEntityRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidatedItem ImmutableBulkUploadRelationshipValidatedItem.copyOf(BulkUploadRelationshipValidatedItem)"
  })
  void testCopyOf_thenSourceEntityRefReturnImmutableEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkUploadRelationshipValidatedItem instance =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build();

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualCopyOfResult =
        ImmutableBulkUploadRelationshipValidatedItem.copyOf(instance);

    // Assert
    EntityReference sourceEntityRefResult2 = actualCopyOfResult.sourceEntityRef();
    assertTrue(sourceEntityRefResult2 instanceof ImmutableEntityReference);
    EntityReference targetEntityRefResult = actualCopyOfResult.targetEntityRef();
    assertTrue(targetEntityRefResult instanceof ImmutableEntityReference);
    BulkUploadRelationshipItem parsedItemResult2 = actualCopyOfResult.parsedItem();
    assertTrue(parsedItemResult2 instanceof ImmutableBulkUploadRelationshipItem);
    assertEquals("42", parsedItemResult2.sourceExternalId());
    assertEquals("42", parsedItemResult2.targetExternalId());
    assertEquals(
        "The characteristics of someone or something", sourceEntityRefResult2.description());
    assertEquals("The characteristics of someone or something", parsedItemResult2.description());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, sourceEntityRefResult2.id());
    assertEquals(EntityKind.ALL, sourceEntityRefResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceEntityRefResult2.entityLifecycleStatus());
    assertEquals(UploadOperation.ADD, actualCopyOfResult.uploadOperation());
    assertTrue(actualCopyOfResult.error().isEmpty());
    assertEquals(sourceEntityRefResult2, targetEntityRefResult);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#equals(Object)}, and {@link
   * ImmutableBulkUploadRelationshipValidatedItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipValidatedItem#equals(Object)}
   *   <li>{@link ImmutableBulkUploadRelationshipValidatedItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipValidatedItem.equals(Object)",
    "int ImmutableBulkUploadRelationshipValidatedItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkUploadRelationshipValidatedItem immutableBulkUploadRelationshipValidatedItem =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build();

    Builder descriptionResult2 =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult2 = descriptionResult2.addAllError(new ArrayList<>());

    Builder parsedItemResult2 =
        addAllErrorResult2.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult2 =
        parsedItemResult2.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkUploadRelationshipValidatedItem immutableBulkUploadRelationshipValidatedItem2 =
        sourceEntityRefResult2
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build();

    // Act and Assert
    assertEquals(
        immutableBulkUploadRelationshipValidatedItem,
        immutableBulkUploadRelationshipValidatedItem2);
    assertEquals(
        immutableBulkUploadRelationshipValidatedItem.hashCode(),
        immutableBulkUploadRelationshipValidatedItem2.hashCode());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#equals(Object)}, and {@link
   * ImmutableBulkUploadRelationshipValidatedItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipValidatedItem#equals(Object)}
   *   <li>{@link ImmutableBulkUploadRelationshipValidatedItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipValidatedItem.equals(Object)",
    "int ImmutableBulkUploadRelationshipValidatedItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkUploadRelationshipValidatedItem immutableBulkUploadRelationshipValidatedItem =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build();

    // Act and Assert
    assertEquals(
        immutableBulkUploadRelationshipValidatedItem, immutableBulkUploadRelationshipValidatedItem);
    int expectedHashCodeResult = immutableBulkUploadRelationshipValidatedItem.hashCode();
    assertEquals(expectedHashCodeResult, immutableBulkUploadRelationshipValidatedItem.hashCode());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipValidatedItem.equals(Object)",
    "int ImmutableBulkUploadRelationshipValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();
    builderResult.addError(ValidationError.SOURCE_INVALID);

    Builder descriptionResult =
        builderResult.description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkUploadRelationshipValidatedItem immutableBulkUploadRelationshipValidatedItem =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build();

    Builder descriptionResult2 =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult2 = descriptionResult2.addAllError(new ArrayList<>());

    Builder parsedItemResult2 =
        addAllErrorResult2.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult2 =
        parsedItemResult2.sourceEntityRef(
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
        immutableBulkUploadRelationshipValidatedItem,
        sourceEntityRefResult2
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipValidatedItem.equals(Object)",
    "int ImmutableBulkUploadRelationshipValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder().description("42");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkUploadRelationshipValidatedItem immutableBulkUploadRelationshipValidatedItem =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build();

    Builder descriptionResult2 =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult2 = descriptionResult2.addAllError(new ArrayList<>());

    Builder parsedItemResult2 =
        addAllErrorResult2.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult2 =
        parsedItemResult2.sourceEntityRef(
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
        immutableBulkUploadRelationshipValidatedItem,
        sourceEntityRefResult2
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipValidatedItem.equals(Object)",
    "int ImmutableBulkUploadRelationshipValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("42")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkUploadRelationshipValidatedItem immutableBulkUploadRelationshipValidatedItem =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build();

    Builder descriptionResult2 =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult2 = descriptionResult2.addAllError(new ArrayList<>());

    Builder parsedItemResult2 =
        addAllErrorResult2.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult2 =
        parsedItemResult2.sourceEntityRef(
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
        immutableBulkUploadRelationshipValidatedItem,
        sourceEntityRefResult2
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipValidatedItem.equals(Object)",
    "int ImmutableBulkUploadRelationshipValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkUploadRelationshipValidatedItem immutableBulkUploadRelationshipValidatedItem =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build();

    Builder descriptionResult2 =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult2 = descriptionResult2.addAllError(new ArrayList<>());

    Builder parsedItemResult2 =
        addAllErrorResult2.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult2 =
        parsedItemResult2.sourceEntityRef(
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
        immutableBulkUploadRelationshipValidatedItem,
        sourceEntityRefResult2
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipValidatedItem.equals(Object)",
    "int ImmutableBulkUploadRelationshipValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkUploadRelationshipValidatedItem immutableBulkUploadRelationshipValidatedItem =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build();

    Builder descriptionResult2 =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult2 = descriptionResult2.addAllError(new ArrayList<>());

    Builder parsedItemResult2 =
        addAllErrorResult2.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult2 =
        parsedItemResult2.sourceEntityRef(
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
        immutableBulkUploadRelationshipValidatedItem,
        sourceEntityRefResult2
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipValidatedItem.equals(Object)",
    "int ImmutableBulkUploadRelationshipValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkUploadRelationshipValidatedItem immutableBulkUploadRelationshipValidatedItem =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.UPDATE)
            .build();

    Builder descriptionResult2 =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult2 = descriptionResult2.addAllError(new ArrayList<>());

    Builder parsedItemResult2 =
        addAllErrorResult2.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult2 =
        parsedItemResult2.sourceEntityRef(
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
        immutableBulkUploadRelationshipValidatedItem,
        sourceEntityRefResult2
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipValidatedItem.equals(Object)",
    "int ImmutableBulkUploadRelationshipValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
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
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipValidatedItem.equals(Object)",
    "int ImmutableBulkUploadRelationshipValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
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
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build(),
        "Different type to ImmutableBulkUploadRelationshipValidatedItem");
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code SOURCE_INVALID}.
   *   <li>Then return error size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidatedItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet() add 'SOURCE_INVALID'; then return error size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidatedItem ImmutableBulkUploadRelationshipValidatedItem.fromJson(Json)"
  })
  void testFromJson_givenHashSetAddSourceInvalid_thenReturnErrorSizeIsOne() {
    // Arrange
    HashSet<ValidationError> error = new HashSet<>();
    error.add(ValidationError.SOURCE_INVALID);

    Json json = new Json();
    json.setParsedItem(new ImmutableBulkUploadRelationshipItem.Json());
    json.setSourceEntityRef(null);
    json.setTargetEntityRef(null);
    json.setDescription(null);
    json.setError(error);
    json.setUploadOperation(UploadOperation.ADD);

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualFromJsonResult =
        ImmutableBulkUploadRelationshipValidatedItem.fromJson(json);

    // Assert
    Set<ValidationError> errorResult = actualFromJsonResult.error();
    assertEquals(1, errorResult.size());
    assertTrue(errorResult.contains(ValidationError.SOURCE_INVALID));
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) Error is {@link HashSet#HashSet()}.
   *   <li>Then return error Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidatedItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) Error is HashSet(); then return error Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidatedItem ImmutableBulkUploadRelationshipValidatedItem.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonErrorIsHashSet_thenReturnErrorEmpty() {
    // Arrange
    Json json = new Json();
    json.setParsedItem(new ImmutableBulkUploadRelationshipItem.Json());
    json.setSourceEntityRef(null);
    json.setTargetEntityRef(null);
    json.setDescription(null);
    json.setError(new HashSet<>());
    json.setUploadOperation(UploadOperation.ADD);

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualFromJsonResult =
        ImmutableBulkUploadRelationshipValidatedItem.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.description());
    assertNull(actualFromJsonResult.sourceEntityRef());
    assertNull(actualFromJsonResult.targetEntityRef());
    assertTrue(actualFromJsonResult.error().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ImmutableBulkUploadRelationshipItem.Json} (default constructor).
   *   <li>When {@link Json} (default constructor) ParsedItem is {@link
   *       ImmutableBulkUploadRelationshipItem.Json} (default constructor).
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidatedItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given Json (default constructor); when Json (default constructor) ParsedItem is Json (default constructor); then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidatedItem ImmutableBulkUploadRelationshipValidatedItem.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonParsedItemIsJson_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setParsedItem(new ImmutableBulkUploadRelationshipItem.Json());
    json.setSourceEntityRef(null);
    json.setTargetEntityRef(null);
    json.setDescription(null);
    json.setError(null);
    json.setUploadOperation(UploadOperation.ADD);

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualFromJsonResult =
        ImmutableBulkUploadRelationshipValidatedItem.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.description());
    assertNull(actualFromJsonResult.error());
    assertNull(actualFromJsonResult.sourceEntityRef());
    assertNull(actualFromJsonResult.targetEntityRef());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return description is {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidatedItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return description is 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidatedItem ImmutableBulkUploadRelationshipValidatedItem.fromJson(Json)"
  })
  void testFromJson_thenReturnDescriptionIsTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange
    Json json = new Json();
    json.setParsedItem(new ImmutableBulkUploadRelationshipItem.Json());
    json.setSourceEntityRef(null);
    json.setTargetEntityRef(null);
    json.setDescription("The characteristics of someone or something");
    json.setError(null);
    json.setUploadOperation(UploadOperation.ADD);

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualFromJsonResult =
        ImmutableBulkUploadRelationshipValidatedItem.fromJson(json);

    // Assert
    assertEquals("The characteristics of someone or something", actualFromJsonResult.description());
    assertNull(actualFromJsonResult.error());
    assertNull(actualFromJsonResult.sourceEntityRef());
    assertNull(actualFromJsonResult.targetEntityRef());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return sourceEntityRef is {@link Json} (default constructor) {@link
   *       Json#sourceEntityRef}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidatedItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return sourceEntityRef is Json (default constructor) sourceEntityRef")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidatedItem ImmutableBulkUploadRelationshipValidatedItem.fromJson(Json)"
  })
  void testFromJson_thenReturnSourceEntityRefIsJsonSourceEntityRef() {
    // Arrange
    Json json = new Json();
    json.setParsedItem(new ImmutableBulkUploadRelationshipItem.Json());
    json.setSourceEntityRef(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setTargetEntityRef(null);
    json.setDescription(null);
    json.setError(null);
    json.setUploadOperation(UploadOperation.ADD);

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualFromJsonResult =
        ImmutableBulkUploadRelationshipValidatedItem.fromJson(json);

    // Assert
    EntityReference expectedSourceEntityRefResult = json.sourceEntityRef;
    assertSame(expectedSourceEntityRefResult, actualFromJsonResult.sourceEntityRef());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return targetEntityRef is {@link Json} (default constructor) {@link
   *       Json#targetEntityRef}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidatedItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return targetEntityRef is Json (default constructor) targetEntityRef")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidatedItem ImmutableBulkUploadRelationshipValidatedItem.fromJson(Json)"
  })
  void testFromJson_thenReturnTargetEntityRefIsJsonTargetEntityRef() {
    // Arrange
    Json json = new Json();
    json.setParsedItem(new ImmutableBulkUploadRelationshipItem.Json());
    json.setSourceEntityRef(null);
    json.setTargetEntityRef(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setDescription(null);
    json.setError(null);
    json.setUploadOperation(UploadOperation.ADD);

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualFromJsonResult =
        ImmutableBulkUploadRelationshipValidatedItem.fromJson(json);

    // Assert
    EntityReference expectedTargetEntityRefResult = json.targetEntityRef;
    assertSame(expectedTargetEntityRefResult, actualFromJsonResult.targetEntityRef());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipValidatedItem#toString()}
   *   <li>{@link ImmutableBulkUploadRelationshipValidatedItem#description()}
   *   <li>{@link ImmutableBulkUploadRelationshipValidatedItem#error()}
   *   <li>{@link ImmutableBulkUploadRelationshipValidatedItem#parsedItem()}
   *   <li>{@link ImmutableBulkUploadRelationshipValidatedItem#sourceEntityRef()}
   *   <li>{@link ImmutableBulkUploadRelationshipValidatedItem#targetEntityRef()}
   *   <li>{@link ImmutableBulkUploadRelationshipValidatedItem#uploadOperation()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableBulkUploadRelationshipValidatedItem.description()",
    "Set ImmutableBulkUploadRelationshipValidatedItem.error()",
    "BulkUploadRelationshipItem ImmutableBulkUploadRelationshipValidatedItem.parsedItem()",
    "EntityReference ImmutableBulkUploadRelationshipValidatedItem.sourceEntityRef()",
    "EntityReference ImmutableBulkUploadRelationshipValidatedItem.targetEntityRef()",
    "String ImmutableBulkUploadRelationshipValidatedItem.toString()",
    "UploadOperation ImmutableBulkUploadRelationshipValidatedItem.uploadOperation()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkUploadRelationshipValidatedItem immutableBulkUploadRelationshipValidatedItem =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build();

    // Act
    String actualToStringResult = immutableBulkUploadRelationshipValidatedItem.toString();
    String actualDescriptionResult = immutableBulkUploadRelationshipValidatedItem.description();
    Set<ValidationError> actualErrorResult = immutableBulkUploadRelationshipValidatedItem.error();
    BulkUploadRelationshipItem actualParsedItemResult =
        immutableBulkUploadRelationshipValidatedItem.parsedItem();
    EntityReference actualSourceEntityRefResult =
        immutableBulkUploadRelationshipValidatedItem.sourceEntityRef();
    EntityReference actualTargetEntityRefResult =
        immutableBulkUploadRelationshipValidatedItem.targetEntityRef();

    // Assert
    assertTrue(actualSourceEntityRefResult instanceof ImmutableEntityReference);
    assertTrue(actualTargetEntityRefResult instanceof ImmutableEntityReference);
    assertTrue(actualParsedItemResult instanceof ImmutableBulkUploadRelationshipItem);
    assertEquals(
        "BulkUploadRelationshipValidatedItem{parsedItem=BulkUploadRelationshipItem{sourceExternalId=42,"
            + " targetExternalId=42, description=The characteristics of someone or something}, sourceEntityRef"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, targetEntityRef=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, description=The characteristics of someone or something, error=[],"
            + " uploadOperation=ADD}",
        actualToStringResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(
        UploadOperation.ADD, immutableBulkUploadRelationshipValidatedItem.uploadOperation());
    assertTrue(actualErrorResult.isEmpty());
    assertEquals(actualSourceEntityRefResult, actualTargetEntityRefResult);
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
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
  @MethodsUnderTest({"Set Json.error()"})
  void testJsonError() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().error());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setError(Set)}
   *   <li>{@link Json#setParsedItem(BulkUploadRelationshipItem)}
   *   <li>{@link Json#setSourceEntityRef(EntityReference)}
   *   <li>{@link Json#setTargetEntityRef(EntityReference)}
   *   <li>{@link Json#setUploadOperation(UploadOperation)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setDescription(String)",
    "void Json.setError(Set)",
    "void Json.setParsedItem(BulkUploadRelationshipItem)",
    "void Json.setSourceEntityRef(EntityReference)",
    "void Json.setTargetEntityRef(EntityReference)",
    "void Json.setUploadOperation(UploadOperation)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setError(new HashSet<>());
    actualJson.setParsedItem(
        ImmutableBulkUploadRelationshipItem.builder()
            .description("The characteristics of someone or something")
            .sourceExternalId("42")
            .targetExternalId("42")
            .build());
    actualJson.setSourceEntityRef(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setTargetEntityRef(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setUploadOperation(UploadOperation.ADD);

    // Assert
    assertTrue(actualJson.error.isEmpty());
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
  @MethodsUnderTest({"BulkUploadRelationshipItem Json.parsedItem()"})
  void testJsonParsedItem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parsedItem());
  }

  /**
   * Test Json {@link Json#sourceEntityRef()}.
   *
   * <p>Method under test: {@link Json#sourceEntityRef()}
   */
  @Test
  @DisplayName("Test Json sourceEntityRef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.sourceEntityRef()"})
  void testJsonSourceEntityRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().sourceEntityRef());
  }

  /**
   * Test Json {@link Json#targetEntityRef()}.
   *
   * <p>Method under test: {@link Json#targetEntityRef()}
   */
  @Test
  @DisplayName("Test Json targetEntityRef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.targetEntityRef()"})
  void testJsonTargetEntityRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().targetEntityRef());
  }

  /**
   * Test Json {@link Json#uploadOperation()}.
   *
   * <p>Method under test: {@link Json#uploadOperation()}
   */
  @Test
  @DisplayName("Test Json uploadOperation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UploadOperation Json.uploadOperation()"})
  void testJsonUploadOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().uploadOperation());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#withDescription(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadRelationshipValidatedItem#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidatedItem ImmutableBulkUploadRelationshipValidatedItem.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder().description("42");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkUploadRelationshipValidatedItem immutableBulkUploadRelationshipValidatedItem =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build();

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualWithDescriptionResult =
        immutableBulkUploadRelationshipValidatedItem.withDescription("42");

    // Assert
    assertSame(immutableBulkUploadRelationshipValidatedItem, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#withDescription(String)}.
   *
   * <ul>
   *   <li>Then sourceEntityRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadRelationshipValidatedItem#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String); then sourceEntityRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidatedItem ImmutableBulkUploadRelationshipValidatedItem.withDescription(String)"
  })
  void testWithDescription_thenSourceEntityRefReturnImmutableEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualWithDescriptionResult =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build()
            .withDescription("42");

    // Assert
    EntityReference sourceEntityRefResult2 = actualWithDescriptionResult.sourceEntityRef();
    assertTrue(sourceEntityRefResult2 instanceof ImmutableEntityReference);
    EntityReference targetEntityRefResult = actualWithDescriptionResult.targetEntityRef();
    assertTrue(targetEntityRefResult instanceof ImmutableEntityReference);
    BulkUploadRelationshipItem parsedItemResult2 = actualWithDescriptionResult.parsedItem();
    assertTrue(parsedItemResult2 instanceof ImmutableBulkUploadRelationshipItem);
    assertEquals("42", parsedItemResult2.sourceExternalId());
    assertEquals("42", parsedItemResult2.targetExternalId());
    assertEquals("42", actualWithDescriptionResult.description());
    assertEquals(
        "The characteristics of someone or something", sourceEntityRefResult2.description());
    assertEquals("The characteristics of someone or something", parsedItemResult2.description());
    assertEquals(1L, sourceEntityRefResult2.id());
    assertEquals(EntityKind.ALL, sourceEntityRefResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceEntityRefResult2.entityLifecycleStatus());
    assertEquals(UploadOperation.ADD, actualWithDescriptionResult.uploadOperation());
    assertTrue(actualWithDescriptionResult.error().isEmpty());
    assertEquals(sourceEntityRefResult2, targetEntityRefResult);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#withError(Iterable)} with {@code
   * Iterable}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.
   *   <li>Then calls {@link Iterable#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidatedItem#withError(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withError(Iterable) with 'Iterable'; given ArrayList() iterator; then calls iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidatedItem ImmutableBulkUploadRelationshipValidatedItem.withError(Iterable)"
  })
  void testWithErrorWithIterable_givenArrayListIterator_thenCallsIterator() {
    // Arrange
    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkUploadRelationshipValidatedItem immutableBulkUploadRelationshipValidatedItem =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build();

    Iterable<ValidationError> elements = mock(Iterable.class);

    ArrayList<ValidationError> validationErrorList = new ArrayList<>();
    when(elements.iterator()).thenReturn(validationErrorList.iterator());

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualWithErrorResult =
        immutableBulkUploadRelationshipValidatedItem.withError(elements);

    // Assert
    verify(elements).iterator();
    assertEquals(immutableBulkUploadRelationshipValidatedItem, actualWithErrorResult);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#withError(Iterable)} with {@code
   * Iterable}.
   *
   * <ul>
   *   <li>Given {@code SOURCE_INVALID}.
   *   <li>Then return error is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidatedItem#withError(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withError(Iterable) with 'Iterable'; given 'SOURCE_INVALID'; then return error is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidatedItem ImmutableBulkUploadRelationshipValidatedItem.withError(Iterable)"
  })
  void testWithErrorWithIterable_givenSourceInvalid_thenReturnErrorIsLinkedHashSet() {
    // Arrange
    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkUploadRelationshipValidatedItem immutableBulkUploadRelationshipValidatedItem =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build();

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.SOURCE_INVALID);

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualWithErrorResult =
        immutableBulkUploadRelationshipValidatedItem.withError(elements);

    // Assert
    EntityReference sourceEntityRefResult2 = actualWithErrorResult.sourceEntityRef();
    assertTrue(sourceEntityRefResult2 instanceof ImmutableEntityReference);
    EntityReference targetEntityRefResult = actualWithErrorResult.targetEntityRef();
    assertTrue(targetEntityRefResult instanceof ImmutableEntityReference);
    BulkUploadRelationshipItem parsedItemResult2 = actualWithErrorResult.parsedItem();
    assertTrue(parsedItemResult2 instanceof ImmutableBulkUploadRelationshipItem);
    assertEquals("42", parsedItemResult2.sourceExternalId());
    assertEquals("42", parsedItemResult2.targetExternalId());
    assertEquals(
        "The characteristics of someone or something", sourceEntityRefResult2.description());
    assertEquals("The characteristics of someone or something", parsedItemResult2.description());
    assertEquals(
        "The characteristics of someone or something", actualWithErrorResult.description());
    assertEquals(1L, sourceEntityRefResult2.id());
    assertEquals(EntityKind.ALL, sourceEntityRefResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceEntityRefResult2.entityLifecycleStatus());
    assertEquals(UploadOperation.ADD, actualWithErrorResult.uploadOperation());
    assertEquals(elements, actualWithErrorResult.error());
    assertEquals(sourceEntityRefResult2, targetEntityRefResult);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#withError(Iterable)} with {@code
   * Iterable}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidatedItem#withError(Iterable)}
   */
  @Test
  @DisplayName("Test withError(Iterable) with 'Iterable'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidatedItem ImmutableBulkUploadRelationshipValidatedItem.withError(Iterable)"
  })
  void testWithErrorWithIterable_whenArrayList() {
    // Arrange
    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkUploadRelationshipValidatedItem immutableBulkUploadRelationshipValidatedItem =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build();

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualWithErrorResult =
        immutableBulkUploadRelationshipValidatedItem.withError(new ArrayList<>());

    // Assert
    assertEquals(immutableBulkUploadRelationshipValidatedItem, actualWithErrorResult);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#withError(Iterable)} with {@code
   * Iterable}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return error is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidatedItem#withError(Iterable)}
   */
  @Test
  @DisplayName("Test withError(Iterable) with 'Iterable'; when 'null'; then return error is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidatedItem ImmutableBulkUploadRelationshipValidatedItem.withError(Iterable)"
  })
  void testWithErrorWithIterable_whenNull_thenReturnErrorIsNull() {
    // Arrange
    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualWithErrorResult =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build()
            .withError((Iterable<ValidationError>) null);

    // Assert
    EntityReference sourceEntityRefResult2 = actualWithErrorResult.sourceEntityRef();
    assertTrue(sourceEntityRefResult2 instanceof ImmutableEntityReference);
    EntityReference targetEntityRefResult = actualWithErrorResult.targetEntityRef();
    assertTrue(targetEntityRefResult instanceof ImmutableEntityReference);
    BulkUploadRelationshipItem parsedItemResult2 = actualWithErrorResult.parsedItem();
    assertTrue(parsedItemResult2 instanceof ImmutableBulkUploadRelationshipItem);
    assertEquals("42", parsedItemResult2.sourceExternalId());
    assertEquals("42", parsedItemResult2.targetExternalId());
    assertEquals(
        "The characteristics of someone or something", sourceEntityRefResult2.description());
    assertEquals("The characteristics of someone or something", parsedItemResult2.description());
    assertEquals(
        "The characteristics of someone or something", actualWithErrorResult.description());
    assertNull(actualWithErrorResult.error());
    assertEquals(1L, sourceEntityRefResult2.id());
    assertEquals(EntityKind.ALL, sourceEntityRefResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceEntityRefResult2.entityLifecycleStatus());
    assertEquals(UploadOperation.ADD, actualWithErrorResult.uploadOperation());
    assertEquals(sourceEntityRefResult2, targetEntityRefResult);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#withError(ValidationError[])} with
   * {@code ValidationError[]}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadRelationshipValidatedItem#withError(ValidationError[])}
   */
  @Test
  @DisplayName("Test withError(ValidationError[]) with 'ValidationError[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidatedItem ImmutableBulkUploadRelationshipValidatedItem.withError(ValidationError[])"
  })
  void testWithErrorWithValidationError() {
    // Arrange
    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkUploadRelationshipValidatedItem immutableBulkUploadRelationshipValidatedItem =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build();

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualWithErrorResult =
        immutableBulkUploadRelationshipValidatedItem.withError();

    // Assert
    assertEquals(immutableBulkUploadRelationshipValidatedItem, actualWithErrorResult);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#withError(ValidationError[])} with
   * {@code ValidationError[]}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return error is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadRelationshipValidatedItem#withError(ValidationError[])}
   */
  @Test
  @DisplayName(
      "Test withError(ValidationError[]) with 'ValidationError[]'; when 'null'; then return error is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidatedItem ImmutableBulkUploadRelationshipValidatedItem.withError(ValidationError[])"
  })
  void testWithErrorWithValidationError_whenNull_thenReturnErrorIsNull() {
    // Arrange
    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualWithErrorResult =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build()
            .withError((ValidationError[]) null);

    // Assert
    EntityReference sourceEntityRefResult2 = actualWithErrorResult.sourceEntityRef();
    assertTrue(sourceEntityRefResult2 instanceof ImmutableEntityReference);
    EntityReference targetEntityRefResult = actualWithErrorResult.targetEntityRef();
    assertTrue(targetEntityRefResult instanceof ImmutableEntityReference);
    BulkUploadRelationshipItem parsedItemResult2 = actualWithErrorResult.parsedItem();
    assertTrue(parsedItemResult2 instanceof ImmutableBulkUploadRelationshipItem);
    assertEquals("42", parsedItemResult2.sourceExternalId());
    assertEquals("42", parsedItemResult2.targetExternalId());
    assertEquals(
        "The characteristics of someone or something", sourceEntityRefResult2.description());
    assertEquals("The characteristics of someone or something", parsedItemResult2.description());
    assertEquals(
        "The characteristics of someone or something", actualWithErrorResult.description());
    assertNull(actualWithErrorResult.error());
    assertEquals(1L, sourceEntityRefResult2.id());
    assertEquals(EntityKind.ALL, sourceEntityRefResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceEntityRefResult2.entityLifecycleStatus());
    assertEquals(UploadOperation.ADD, actualWithErrorResult.uploadOperation());
    assertEquals(sourceEntityRefResult2, targetEntityRefResult);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#withError(ValidationError[])} with
   * {@code ValidationError[]}.
   *
   * <ul>
   *   <li>When {@code SOURCE_INVALID}.
   *   <li>Then return error size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadRelationshipValidatedItem#withError(ValidationError[])}
   */
  @Test
  @DisplayName(
      "Test withError(ValidationError[]) with 'ValidationError[]'; when 'SOURCE_INVALID'; then return error size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidatedItem ImmutableBulkUploadRelationshipValidatedItem.withError(ValidationError[])"
  })
  void testWithErrorWithValidationError_whenSourceInvalid_thenReturnErrorSizeIsOne() {
    // Arrange
    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualWithErrorResult =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build()
            .withError(ValidationError.SOURCE_INVALID);

    // Assert
    EntityReference sourceEntityRefResult2 = actualWithErrorResult.sourceEntityRef();
    assertTrue(sourceEntityRefResult2 instanceof ImmutableEntityReference);
    EntityReference targetEntityRefResult = actualWithErrorResult.targetEntityRef();
    assertTrue(targetEntityRefResult instanceof ImmutableEntityReference);
    BulkUploadRelationshipItem parsedItemResult2 = actualWithErrorResult.parsedItem();
    assertTrue(parsedItemResult2 instanceof ImmutableBulkUploadRelationshipItem);
    assertEquals("42", parsedItemResult2.sourceExternalId());
    assertEquals("42", parsedItemResult2.targetExternalId());
    assertEquals(
        "The characteristics of someone or something", sourceEntityRefResult2.description());
    assertEquals("The characteristics of someone or something", parsedItemResult2.description());
    assertEquals(
        "The characteristics of someone or something", actualWithErrorResult.description());
    Set<ValidationError> errorResult = actualWithErrorResult.error();
    assertEquals(1, errorResult.size());
    assertEquals(1L, sourceEntityRefResult2.id());
    assertEquals(EntityKind.ALL, sourceEntityRefResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceEntityRefResult2.entityLifecycleStatus());
    assertEquals(UploadOperation.ADD, actualWithErrorResult.uploadOperation());
    assertTrue(errorResult.contains(ValidationError.SOURCE_INVALID));
    assertEquals(sourceEntityRefResult2, targetEntityRefResult);
  }

  /**
   * Test {@link
   * ImmutableBulkUploadRelationshipValidatedItem#withParsedItem(BulkUploadRelationshipItem)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadRelationshipValidatedItem#withParsedItem(BulkUploadRelationshipItem)}
   */
  @Test
  @DisplayName("Test withParsedItem(BulkUploadRelationshipItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidatedItem ImmutableBulkUploadRelationshipValidatedItem.withParsedItem(BulkUploadRelationshipItem)"
  })
  void testWithParsedItem() {
    // Arrange
    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkUploadRelationshipValidatedItem immutableBulkUploadRelationshipValidatedItem =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build();

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualWithParsedItemResult =
        immutableBulkUploadRelationshipValidatedItem.withParsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    // Assert
    assertEquals(immutableBulkUploadRelationshipValidatedItem, actualWithParsedItemResult);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#withSourceEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadRelationshipValidatedItem#withSourceEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test withSourceEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidatedItem ImmutableBulkUploadRelationshipValidatedItem.withSourceEntityRef(EntityReference)"
  })
  void testWithSourceEntityRef() {
    // Arrange
    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkUploadRelationshipValidatedItem immutableBulkUploadRelationshipValidatedItem =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build();

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualWithSourceEntityRefResult =
        immutableBulkUploadRelationshipValidatedItem.withSourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableBulkUploadRelationshipValidatedItem, actualWithSourceEntityRefResult);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#withTargetEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadRelationshipValidatedItem#withTargetEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test withTargetEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidatedItem ImmutableBulkUploadRelationshipValidatedItem.withTargetEntityRef(EntityReference)"
  })
  void testWithTargetEntityRef() {
    // Arrange
    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkUploadRelationshipValidatedItem immutableBulkUploadRelationshipValidatedItem =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build();

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualWithTargetEntityRefResult =
        immutableBulkUploadRelationshipValidatedItem.withTargetEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableBulkUploadRelationshipValidatedItem, actualWithTargetEntityRefResult);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#withUploadOperation(UploadOperation)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadRelationshipValidatedItem#withUploadOperation(UploadOperation)}
   */
  @Test
  @DisplayName("Test withUploadOperation(UploadOperation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidatedItem ImmutableBulkUploadRelationshipValidatedItem.withUploadOperation(UploadOperation)"
  })
  void testWithUploadOperation() {
    // Arrange
    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkUploadRelationshipValidatedItem immutableBulkUploadRelationshipValidatedItem =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build();

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualWithUploadOperationResult =
        immutableBulkUploadRelationshipValidatedItem.withUploadOperation(UploadOperation.ADD);

    // Assert
    assertSame(immutableBulkUploadRelationshipValidatedItem, actualWithUploadOperationResult);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidatedItem#withUploadOperation(UploadOperation)}.
   *
   * <ul>
   *   <li>Then sourceEntityRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadRelationshipValidatedItem#withUploadOperation(UploadOperation)}
   */
  @Test
  @DisplayName(
      "Test withUploadOperation(UploadOperation); then sourceEntityRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidatedItem ImmutableBulkUploadRelationshipValidatedItem.withUploadOperation(UploadOperation)"
  })
  void testWithUploadOperation_thenSourceEntityRefReturnImmutableEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableBulkUploadRelationshipValidatedItem actualWithUploadOperationResult =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.UPDATE)
            .build()
            .withUploadOperation(UploadOperation.ADD);

    // Assert
    EntityReference sourceEntityRefResult2 = actualWithUploadOperationResult.sourceEntityRef();
    assertTrue(sourceEntityRefResult2 instanceof ImmutableEntityReference);
    EntityReference targetEntityRefResult = actualWithUploadOperationResult.targetEntityRef();
    assertTrue(targetEntityRefResult instanceof ImmutableEntityReference);
    BulkUploadRelationshipItem parsedItemResult2 = actualWithUploadOperationResult.parsedItem();
    assertTrue(parsedItemResult2 instanceof ImmutableBulkUploadRelationshipItem);
    assertEquals("42", parsedItemResult2.sourceExternalId());
    assertEquals("42", parsedItemResult2.targetExternalId());
    assertEquals(
        "The characteristics of someone or something", sourceEntityRefResult2.description());
    assertEquals("The characteristics of someone or something", parsedItemResult2.description());
    assertEquals(
        "The characteristics of someone or something",
        actualWithUploadOperationResult.description());
    assertEquals(1L, sourceEntityRefResult2.id());
    assertEquals(EntityKind.ALL, sourceEntityRefResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceEntityRefResult2.entityLifecycleStatus());
    assertEquals(UploadOperation.ADD, actualWithUploadOperationResult.uploadOperation());
    assertTrue(actualWithUploadOperationResult.error().isEmpty());
    assertEquals(sourceEntityRefResult2, targetEntityRefResult);
  }
}
