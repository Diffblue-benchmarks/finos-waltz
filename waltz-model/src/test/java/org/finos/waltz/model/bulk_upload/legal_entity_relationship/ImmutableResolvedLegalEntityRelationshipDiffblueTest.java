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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableResolvedLegalEntityRelationship.Builder;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableResolvedLegalEntityRelationship.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableResolvedLegalEntityRelationshipDiffblueTest {
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
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

    // Act
    Builder actualAddAllErrorsResult = builderResult.addAllErrors(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllErrorsResult);
  }

  /**
   * Test Builder {@link Builder#addErrors(LegalEntityRelationshipResolutionError)} with {@code
   * element}.
   *
   * <ul>
   *   <li>When {@link ImmutableLegalEntityRelationshipResolutionError.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addErrors(LegalEntityRelationshipResolutionError)}
   */
  @Test
  @DisplayName(
      "Test Builder addErrors(LegalEntityRelationshipResolutionError) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addErrors(LegalEntityRelationshipResolutionError)"})
  void testBuilderAddErrorsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

    // Act
    Builder actualAddErrorsResult =
        builderResult.addErrors(new ImmutableLegalEntityRelationshipResolutionError.Json());

    // Assert
    assertSame(builderResult, actualAddErrorsResult);
  }

  /**
   * Test Builder {@link Builder#addErrors(LegalEntityRelationshipResolutionError[])} with {@code
   * elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableLegalEntityRelationshipResolutionError.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addErrors(LegalEntityRelationshipResolutionError[])}
   */
  @Test
  @DisplayName(
      "Test Builder addErrors(LegalEntityRelationshipResolutionError[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addErrors(LegalEntityRelationshipResolutionError[])"})
  void testBuilderAddErrorsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

    // Act
    Builder actualAddErrorsResult =
        builderResult.addErrors(new ImmutableLegalEntityRelationshipResolutionError.Json());

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
   *   <li>{@link Builder#existingRelationshipReference(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedLegalEntityRelationship Builder.build()",
    "Builder Builder.comment(String)",
    "Builder Builder.existingRelationshipReference(EntityReference)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualCommentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    Optional<String> comment = Optional.of("42");
    Builder actualCommentResult2 = actualCommentResult.comment(comment);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);
    Builder actualExistingRelationshipReferenceResult =
        actualCommentResult2.existingRelationshipReference(existingRelationshipReference);
    Builder actualExistingRelationshipReferenceResult2 =
        actualExistingRelationshipReferenceResult.existingRelationshipReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);
    ImmutableResolvedReference legalEntityReference =
        inputStringResult.resolvedEntityReference(resolvedEntityReference).build();
    Builder actualOperationResult =
        actualExistingRelationshipReferenceResult2
            .legalEntityReference(legalEntityReference)
            .operation(UploadOperation.ADD);
    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);
    ImmutableResolvedReference targetEntityReference =
        inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build();
    ImmutableResolvedLegalEntityRelationship actualImmutableResolvedLegalEntityRelationship =
        actualOperationResult.targetEntityReference(targetEntityReference).build();

    // Assert
    ResolvedReference legalEntityReferenceResult =
        actualImmutableResolvedLegalEntityRelationship.legalEntityReference();
    assertTrue(legalEntityReferenceResult instanceof ImmutableResolvedReference);
    assertEquals(UploadOperation.ADD, actualImmutableResolvedLegalEntityRelationship.operation());
    assertTrue(actualImmutableResolvedLegalEntityRelationship.errors().isEmpty());
    assertSame(legalEntityReference, legalEntityReferenceResult);
    assertSame(
        targetEntityReference,
        actualImmutableResolvedLegalEntityRelationship.targetEntityReference());
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
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();
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
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

    // Act
    Builder actualErrorsResult = builderResult.errors(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualErrorsResult);
  }

  /**
   * Test Builder {@link Builder#existingRelationshipReference(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#existingRelationshipReference(Optional)}
   */
  @Test
  @DisplayName("Test Builder existingRelationshipReference(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.existingRelationshipReference(Optional)"})
  void testBuilderExistingRelationshipReferenceWithOptional() {
    // Arrange
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    // Act
    Builder actualExistingRelationshipReferenceResult =
        builderResult.existingRelationshipReference(existingRelationshipReference);

    // Assert
    assertSame(builderResult, actualExistingRelationshipReferenceResult);
  }

  /**
   * Test Builder {@link Builder#from(ResolvedLegalEntityRelationship)}.
   *
   * <p>Method under test: {@link Builder#from(ResolvedLegalEntityRelationship)}
   */
  @Test
  @DisplayName("Test Builder from(ResolvedLegalEntityRelationship)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ResolvedLegalEntityRelationship)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);
    ImmutableResolvedLegalEntityRelationship instance =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build();

    // Act and Assert
    ImmutableResolvedLegalEntityRelationship actualImmutableResolvedLegalEntityRelationship =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableResolvedLegalEntityRelationship);
    ImmutableResolvedLegalEntityRelationship actualImmutableResolvedLegalEntityRelationship2 =
        builderResult.build();
    assertEquals(instance, actualImmutableResolvedLegalEntityRelationship2);
  }

  /**
   * Test Builder {@link Builder#from(ResolvedLegalEntityRelationship)}.
   *
   * <p>Method under test: {@link Builder#from(ResolvedLegalEntityRelationship)}
   */
  @Test
  @DisplayName("Test Builder from(ResolvedLegalEntityRelationship)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ResolvedLegalEntityRelationship)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

    Builder builderResult2 = ImmutableResolvedLegalEntityRelationship.builder();
    builderResult2.addErrors(
        ImmutableLegalEntityRelationshipResolutionError.builder()
            .errorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND)
            .errorMessage("An error occurred")
            .build());

    Builder commentResult = builderResult2.comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);
    ImmutableResolvedLegalEntityRelationship instance =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build();

    // Act and Assert
    ImmutableResolvedLegalEntityRelationship actualImmutableResolvedLegalEntityRelationship =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableResolvedLegalEntityRelationship);
    ImmutableResolvedLegalEntityRelationship actualImmutableResolvedLegalEntityRelationship2 =
        builderResult.build();
    assertEquals(instance, actualImmutableResolvedLegalEntityRelationship2);
  }

  /**
   * Test Builder {@link Builder#from(ResolvedLegalEntityRelationship)}.
   *
   * <p>Method under test: {@link Builder#from(ResolvedLegalEntityRelationship)}
   */
  @Test
  @DisplayName("Test Builder from(ResolvedLegalEntityRelationship)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ResolvedLegalEntityRelationship)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    Optional<? extends EntityReference> existingRelationshipReference = Optional.empty();

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference2);
    ImmutableResolvedLegalEntityRelationship instance =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build();

    // Act and Assert
    ImmutableResolvedLegalEntityRelationship actualImmutableResolvedLegalEntityRelationship =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableResolvedLegalEntityRelationship);
    ImmutableResolvedLegalEntityRelationship actualImmutableResolvedLegalEntityRelationship2 =
        builderResult.build();
    assertEquals(instance, actualImmutableResolvedLegalEntityRelationship2);
  }

  /**
   * Test Builder {@link Builder#legalEntityReference(ResolvedReference)}.
   *
   * <ul>
   *   <li>When {@link ImmutableResolvedReference.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#legalEntityReference(ResolvedReference)}
   */
  @Test
  @DisplayName(
      "Test Builder legalEntityReference(ResolvedReference); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.legalEntityReference(ResolvedReference)"})
  void testBuilderLegalEntityReference_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

    // Act
    Builder actualLegalEntityReferenceResult =
        builderResult.legalEntityReference(new ImmutableResolvedReference.Json());

    // Assert
    assertSame(builderResult, actualLegalEntityReferenceResult);
  }

  /**
   * Test Builder {@link Builder#operation(UploadOperation)}.
   *
   * <p>Method under test: {@link Builder#operation(UploadOperation)}
   */
  @Test
  @DisplayName("Test Builder operation(UploadOperation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operation(UploadOperation)"})
  void testBuilderOperation() {
    // Arrange
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

    // Act
    Builder actualOperationResult = builderResult.operation(UploadOperation.ADD);

    // Assert
    assertSame(builderResult, actualOperationResult);
  }

  /**
   * Test Builder {@link Builder#targetEntityReference(ResolvedReference)}.
   *
   * <ul>
   *   <li>When {@link ImmutableResolvedReference.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#targetEntityReference(ResolvedReference)}
   */
  @Test
  @DisplayName(
      "Test Builder targetEntityReference(ResolvedReference); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targetEntityReference(ResolvedReference)"})
  void testBuilderTargetEntityReference_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();

    // Act
    Builder actualTargetEntityReferenceResult =
        builderResult.targetEntityReference(new ImmutableResolvedReference.Json());

    // Assert
    assertSame(builderResult, actualTargetEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#comment()}.
   *
   * <p>Method under test: {@link ImmutableResolvedLegalEntityRelationship#comment()}
   */
  @Test
  @DisplayName("Test comment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableResolvedLegalEntityRelationship.comment()"})
  void testComment() {
    // Arrange
    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);

    // Act
    Optional<String> actualCommentResult =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build()
            .comment();

    // Assert
    assertTrue(actualCommentResult.isPresent());
    assertEquals(LegalEntityBulkUploadFixedColumns.COMMENT, actualCommentResult.get());
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#copyOf(ResolvedLegalEntityRelationship)}.
   *
   * <ul>
   *   <li>Then legalEntityReference return {@link ImmutableResolvedReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableResolvedLegalEntityRelationship#copyOf(ResolvedLegalEntityRelationship)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ResolvedLegalEntityRelationship); then legalEntityReference return ImmutableResolvedReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedLegalEntityRelationship ImmutableResolvedLegalEntityRelationship.copyOf(ResolvedLegalEntityRelationship)"
  })
  void testCopyOf_thenLegalEntityReferenceReturnImmutableResolvedReference() {
    // Arrange
    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);
    ImmutableResolvedLegalEntityRelationship instance =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build();

    // Act
    ImmutableResolvedLegalEntityRelationship actualCopyOfResult =
        ImmutableResolvedLegalEntityRelationship.copyOf(instance);

    // Assert
    ResolvedReference legalEntityReferenceResult = actualCopyOfResult.legalEntityReference();
    assertTrue(legalEntityReferenceResult instanceof ImmutableResolvedReference);
    ResolvedReference targetEntityReferenceResult = actualCopyOfResult.targetEntityReference();
    assertTrue(targetEntityReferenceResult instanceof ImmutableResolvedReference);
    assertEquals("Input String", legalEntityReferenceResult.inputString());
    assertEquals(UploadOperation.ADD, actualCopyOfResult.operation());
    assertTrue(actualCopyOfResult.errors().isEmpty());
    assertEquals(legalEntityReferenceResult, targetEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#equals(Object)}, and {@link
   * ImmutableResolvedLegalEntityRelationship#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableResolvedLegalEntityRelationship#equals(Object)}
   *   <li>{@link ImmutableResolvedLegalEntityRelationship#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolvedLegalEntityRelationship.equals(Object)",
    "int ImmutableResolvedLegalEntityRelationship.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);
    ImmutableResolvedLegalEntityRelationship immutableResolvedLegalEntityRelationship =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build();

    Builder commentResult2 =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference4 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference2 =
        Optional.of(immutableEntityReference4);

    Builder existingRelationshipReferenceResult2 =
        commentResult2.existingRelationshipReference(existingRelationshipReference2);

    ImmutableResolvedReference.Builder inputStringResult3 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference5 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference3 =
        Optional.of(immutableEntityReference5);

    Builder operationResult2 =
        existingRelationshipReferenceResult2
            .legalEntityReference(
                inputStringResult3.resolvedEntityReference(resolvedEntityReference3).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult4 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference6 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference4 =
        Optional.of(immutableEntityReference6);
    ImmutableResolvedLegalEntityRelationship immutableResolvedLegalEntityRelationship2 =
        operationResult2
            .targetEntityReference(
                inputStringResult4.resolvedEntityReference(resolvedEntityReference4).build())
            .build();

    // Act and Assert
    assertEquals(
        immutableResolvedLegalEntityRelationship, immutableResolvedLegalEntityRelationship2);
    assertEquals(
        immutableResolvedLegalEntityRelationship.hashCode(),
        immutableResolvedLegalEntityRelationship2.hashCode());
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#equals(Object)}, and {@link
   * ImmutableResolvedLegalEntityRelationship#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableResolvedLegalEntityRelationship#equals(Object)}
   *   <li>{@link ImmutableResolvedLegalEntityRelationship#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolvedLegalEntityRelationship.equals(Object)",
    "int ImmutableResolvedLegalEntityRelationship.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);
    ImmutableResolvedLegalEntityRelationship immutableResolvedLegalEntityRelationship =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build();

    // Act and Assert
    assertEquals(
        immutableResolvedLegalEntityRelationship, immutableResolvedLegalEntityRelationship);
    int expectedHashCodeResult = immutableResolvedLegalEntityRelationship.hashCode();
    assertEquals(expectedHashCodeResult, immutableResolvedLegalEntityRelationship.hashCode());
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedLegalEntityRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolvedLegalEntityRelationship.equals(Object)",
    "int ImmutableResolvedLegalEntityRelationship.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableResolvedLegalEntityRelationship.builder();
    builderResult.addErrors(
        ImmutableLegalEntityRelationshipResolutionError.builder()
            .errorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND)
            .errorMessage("An error occurred")
            .build());

    Builder commentResult = builderResult.comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);
    ImmutableResolvedLegalEntityRelationship immutableResolvedLegalEntityRelationship =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build();

    Builder commentResult2 =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference4 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference2 =
        Optional.of(immutableEntityReference4);

    Builder existingRelationshipReferenceResult2 =
        commentResult2.existingRelationshipReference(existingRelationshipReference2);

    ImmutableResolvedReference.Builder inputStringResult3 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference5 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference3 =
        Optional.of(immutableEntityReference5);

    Builder operationResult2 =
        existingRelationshipReferenceResult2
            .legalEntityReference(
                inputStringResult3.resolvedEntityReference(resolvedEntityReference3).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult4 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference6 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference4 =
        Optional.of(immutableEntityReference6);

    // Act and Assert
    assertNotEquals(
        immutableResolvedLegalEntityRelationship,
        operationResult2
            .targetEntityReference(
                inputStringResult4.resolvedEntityReference(resolvedEntityReference4).build())
            .build());
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedLegalEntityRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolvedLegalEntityRelationship.equals(Object)",
    "int ImmutableResolvedLegalEntityRelationship.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder().comment("Input String");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);
    ImmutableResolvedLegalEntityRelationship immutableResolvedLegalEntityRelationship =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build();

    Builder commentResult2 =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference4 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference2 =
        Optional.of(immutableEntityReference4);

    Builder existingRelationshipReferenceResult2 =
        commentResult2.existingRelationshipReference(existingRelationshipReference2);

    ImmutableResolvedReference.Builder inputStringResult3 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference5 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference3 =
        Optional.of(immutableEntityReference5);

    Builder operationResult2 =
        existingRelationshipReferenceResult2
            .legalEntityReference(
                inputStringResult3.resolvedEntityReference(resolvedEntityReference3).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult4 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference6 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference4 =
        Optional.of(immutableEntityReference6);

    // Act and Assert
    assertNotEquals(
        immutableResolvedLegalEntityRelationship,
        operationResult2
            .targetEntityReference(
                inputStringResult4.resolvedEntityReference(resolvedEntityReference4).build())
            .build());
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedLegalEntityRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolvedLegalEntityRelationship.equals(Object)",
    "int ImmutableResolvedLegalEntityRelationship.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);
    ImmutableResolvedLegalEntityRelationship immutableResolvedLegalEntityRelationship =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build();

    Builder commentResult2 =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference4 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference2 =
        Optional.of(immutableEntityReference4);

    Builder existingRelationshipReferenceResult2 =
        commentResult2.existingRelationshipReference(existingRelationshipReference2);

    ImmutableResolvedReference.Builder inputStringResult3 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference5 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference3 =
        Optional.of(immutableEntityReference5);

    Builder operationResult2 =
        existingRelationshipReferenceResult2
            .legalEntityReference(
                inputStringResult3.resolvedEntityReference(resolvedEntityReference3).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult4 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference6 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference4 =
        Optional.of(immutableEntityReference6);

    // Act and Assert
    assertNotEquals(
        immutableResolvedLegalEntityRelationship,
        operationResult2
            .targetEntityReference(
                inputStringResult4.resolvedEntityReference(resolvedEntityReference4).build())
            .build());
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedLegalEntityRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolvedLegalEntityRelationship.equals(Object)",
    "int ImmutableResolvedLegalEntityRelationship.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("inputString");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);
    ImmutableResolvedLegalEntityRelationship immutableResolvedLegalEntityRelationship =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build();

    Builder commentResult2 =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference4 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference2 =
        Optional.of(immutableEntityReference4);

    Builder existingRelationshipReferenceResult2 =
        commentResult2.existingRelationshipReference(existingRelationshipReference2);

    ImmutableResolvedReference.Builder inputStringResult3 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference5 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference3 =
        Optional.of(immutableEntityReference5);

    Builder operationResult2 =
        existingRelationshipReferenceResult2
            .legalEntityReference(
                inputStringResult3.resolvedEntityReference(resolvedEntityReference3).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult4 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference6 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference4 =
        Optional.of(immutableEntityReference6);

    // Act and Assert
    assertNotEquals(
        immutableResolvedLegalEntityRelationship,
        operationResult2
            .targetEntityReference(
                inputStringResult4.resolvedEntityReference(resolvedEntityReference4).build())
            .build());
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedLegalEntityRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolvedLegalEntityRelationship.equals(Object)",
    "int ImmutableResolvedLegalEntityRelationship.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.UPDATE);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);
    ImmutableResolvedLegalEntityRelationship immutableResolvedLegalEntityRelationship =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build();

    Builder commentResult2 =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference4 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference2 =
        Optional.of(immutableEntityReference4);

    Builder existingRelationshipReferenceResult2 =
        commentResult2.existingRelationshipReference(existingRelationshipReference2);

    ImmutableResolvedReference.Builder inputStringResult3 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference5 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference3 =
        Optional.of(immutableEntityReference5);

    Builder operationResult2 =
        existingRelationshipReferenceResult2
            .legalEntityReference(
                inputStringResult3.resolvedEntityReference(resolvedEntityReference3).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult4 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference6 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference4 =
        Optional.of(immutableEntityReference6);

    // Act and Assert
    assertNotEquals(
        immutableResolvedLegalEntityRelationship,
        operationResult2
            .targetEntityReference(
                inputStringResult4.resolvedEntityReference(resolvedEntityReference4).build())
            .build());
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedLegalEntityRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolvedLegalEntityRelationship.equals(Object)",
    "int ImmutableResolvedLegalEntityRelationship.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("inputString");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);
    ImmutableResolvedLegalEntityRelationship immutableResolvedLegalEntityRelationship =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build();

    Builder commentResult2 =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference4 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference2 =
        Optional.of(immutableEntityReference4);

    Builder existingRelationshipReferenceResult2 =
        commentResult2.existingRelationshipReference(existingRelationshipReference2);

    ImmutableResolvedReference.Builder inputStringResult3 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference5 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference3 =
        Optional.of(immutableEntityReference5);

    Builder operationResult2 =
        existingRelationshipReferenceResult2
            .legalEntityReference(
                inputStringResult3.resolvedEntityReference(resolvedEntityReference3).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult4 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference6 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference4 =
        Optional.of(immutableEntityReference6);

    // Act and Assert
    assertNotEquals(
        immutableResolvedLegalEntityRelationship,
        operationResult2
            .targetEntityReference(
                inputStringResult4.resolvedEntityReference(resolvedEntityReference4).build())
            .build());
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedLegalEntityRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolvedLegalEntityRelationship.equals(Object)",
    "int ImmutableResolvedLegalEntityRelationship.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);

    // Act and Assert
    assertNotEquals(
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedLegalEntityRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolvedLegalEntityRelationship.equals(Object)",
    "int ImmutableResolvedLegalEntityRelationship.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);

    // Act and Assert
    assertNotEquals(
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build(),
        "Different type to ImmutableResolvedLegalEntityRelationship");
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#existingRelationshipReference()}.
   *
   * <p>Method under test: {@link
   * ImmutableResolvedLegalEntityRelationship#existingRelationshipReference()}
   */
  @Test
  @DisplayName("Test existingRelationshipReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ImmutableResolvedLegalEntityRelationship.existingRelationshipReference()"
  })
  void testExistingRelationshipReference() {
    // Arrange
    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);

    // Act and Assert
    assertEquals(
        existingRelationshipReference,
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build()
            .existingRelationshipReference());
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) Errors is {@link HashSet#HashSet()}.
   *   <li>Then return errors Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedLegalEntityRelationship#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) Errors is HashSet(); then return errors Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedLegalEntityRelationship ImmutableResolvedLegalEntityRelationship.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonErrorsIsHashSet_thenReturnErrorsEmpty() {
    // Arrange
    Json json = new Json();
    ImmutableResolvedReference.Json targetEntityReference = new ImmutableResolvedReference.Json();
    json.setTargetEntityReference(targetEntityReference);
    ImmutableResolvedReference.Json legalEntityReference = new ImmutableResolvedReference.Json();
    json.setLegalEntityReference(legalEntityReference);
    Optional<String> comment = Optional.of("42");
    json.setComment(comment);
    json.setErrors(new HashSet<>());
    json.setOperation(UploadOperation.ADD);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> existingRelationshipReference = Optional.of(immutableEntityReference);
    json.setExistingRelationshipReference(existingRelationshipReference);

    // Act
    ImmutableResolvedLegalEntityRelationship actualFromJsonResult =
        ImmutableResolvedLegalEntityRelationship.fromJson(json);

    // Assert
    assertEquals(UploadOperation.ADD, actualFromJsonResult.operation());
    assertTrue(actualFromJsonResult.errors().isEmpty());
    assertSame(legalEntityReference, actualFromJsonResult.legalEntityReference());
    assertSame(targetEntityReference, actualFromJsonResult.targetEntityReference());
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link
   *       ImmutableLegalEntityRelationshipResolutionError.Json} (default constructor).
   *   <li>Then return errors size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedLegalEntityRelationship#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return errors size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedLegalEntityRelationship ImmutableResolvedLegalEntityRelationship.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddJson_thenReturnErrorsSizeIsOne() {
    // Arrange
    LinkedHashSet<LegalEntityRelationshipResolutionError> errors = new LinkedHashSet<>();
    errors.add(new ImmutableLegalEntityRelationshipResolutionError.Json());

    Json json = new Json();
    ImmutableResolvedReference.Json targetEntityReference = new ImmutableResolvedReference.Json();
    json.setTargetEntityReference(targetEntityReference);
    ImmutableResolvedReference.Json legalEntityReference = new ImmutableResolvedReference.Json();
    json.setLegalEntityReference(legalEntityReference);
    Optional<String> comment = Optional.of("42");
    json.setComment(comment);
    json.setErrors(errors);
    json.setOperation(UploadOperation.ADD);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> existingRelationshipReference = Optional.of(immutableEntityReference);
    json.setExistingRelationshipReference(existingRelationshipReference);

    // Act
    ImmutableResolvedLegalEntityRelationship actualFromJsonResult =
        ImmutableResolvedLegalEntityRelationship.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.errors().size());
    assertEquals(UploadOperation.ADD, actualFromJsonResult.operation());
    assertSame(legalEntityReference, actualFromJsonResult.legalEntityReference());
    assertSame(targetEntityReference, actualFromJsonResult.targetEntityReference());
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Comment is {@code null}.
   *   <li>Then return errors size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedLegalEntityRelationship#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Comment is 'null'; then return errors size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedLegalEntityRelationship ImmutableResolvedLegalEntityRelationship.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonCommentIsNull_thenReturnErrorsSizeIsOne() {
    // Arrange
    LinkedHashSet<LegalEntityRelationshipResolutionError> errors = new LinkedHashSet<>();
    errors.add(new ImmutableLegalEntityRelationshipResolutionError.Json());

    Json json = new Json();
    ImmutableResolvedReference.Json targetEntityReference = new ImmutableResolvedReference.Json();
    json.setTargetEntityReference(targetEntityReference);
    ImmutableResolvedReference.Json legalEntityReference = new ImmutableResolvedReference.Json();
    json.setLegalEntityReference(legalEntityReference);
    json.setComment(null);
    json.setErrors(errors);
    json.setOperation(UploadOperation.ADD);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> existingRelationshipReference = Optional.of(immutableEntityReference);
    json.setExistingRelationshipReference(existingRelationshipReference);

    // Act
    ImmutableResolvedLegalEntityRelationship actualFromJsonResult =
        ImmutableResolvedLegalEntityRelationship.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.errors().size());
    assertEquals(UploadOperation.ADD, actualFromJsonResult.operation());
    assertSame(legalEntityReference, actualFromJsonResult.legalEntityReference());
    assertSame(targetEntityReference, actualFromJsonResult.targetEntityReference());
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Errors is {@code null}.
   *   <li>Then return errors Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedLegalEntityRelationship#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Errors is 'null'; then return errors Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedLegalEntityRelationship ImmutableResolvedLegalEntityRelationship.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonErrorsIsNull_thenReturnErrorsEmpty() {
    // Arrange
    Json json = new Json();
    ImmutableResolvedReference.Json targetEntityReference = new ImmutableResolvedReference.Json();
    json.setTargetEntityReference(targetEntityReference);
    ImmutableResolvedReference.Json legalEntityReference = new ImmutableResolvedReference.Json();
    json.setLegalEntityReference(legalEntityReference);
    Optional<String> comment = Optional.of("42");
    json.setComment(comment);
    json.setErrors(null);
    json.setOperation(UploadOperation.ADD);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> existingRelationshipReference = Optional.of(immutableEntityReference);
    json.setExistingRelationshipReference(existingRelationshipReference);

    // Act
    ImmutableResolvedLegalEntityRelationship actualFromJsonResult =
        ImmutableResolvedLegalEntityRelationship.fromJson(json);

    // Assert
    assertEquals(UploadOperation.ADD, actualFromJsonResult.operation());
    assertTrue(actualFromJsonResult.errors().isEmpty());
    assertSame(legalEntityReference, actualFromJsonResult.legalEntityReference());
    assertSame(targetEntityReference, actualFromJsonResult.targetEntityReference());
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return errors is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedLegalEntityRelationship#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return errors is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedLegalEntityRelationship ImmutableResolvedLegalEntityRelationship.fromJson(Json)"
  })
  void testFromJson_thenReturnErrorsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<LegalEntityRelationshipResolutionError> errors = new LinkedHashSet<>();
    errors.add(
        ImmutableLegalEntityRelationshipResolutionError.builder()
            .errorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND)
            .errorMessage("An error occurred")
            .build());
    errors.add(new ImmutableLegalEntityRelationshipResolutionError.Json());

    Json json = new Json();
    ImmutableResolvedReference.Json targetEntityReference = new ImmutableResolvedReference.Json();
    json.setTargetEntityReference(targetEntityReference);
    ImmutableResolvedReference.Json legalEntityReference = new ImmutableResolvedReference.Json();
    json.setLegalEntityReference(legalEntityReference);
    Optional<String> comment = Optional.of("42");
    json.setComment(comment);
    json.setErrors(errors);
    json.setOperation(UploadOperation.ADD);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> existingRelationshipReference = Optional.of(immutableEntityReference);
    json.setExistingRelationshipReference(existingRelationshipReference);

    // Act
    ImmutableResolvedLegalEntityRelationship actualFromJsonResult =
        ImmutableResolvedLegalEntityRelationship.fromJson(json);

    // Assert
    assertEquals(UploadOperation.ADD, actualFromJsonResult.operation());
    assertEquals(errors, actualFromJsonResult.errors());
    assertSame(legalEntityReference, actualFromJsonResult.legalEntityReference());
    assertSame(targetEntityReference, actualFromJsonResult.targetEntityReference());
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) ExistingRelationshipReference is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedLegalEntityRelationship#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) ExistingRelationshipReference is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedLegalEntityRelationship ImmutableResolvedLegalEntityRelationship.fromJson(Json)"
  })
  void testFromJson_whenJsonExistingRelationshipReferenceIsNull() {
    // Arrange
    LinkedHashSet<LegalEntityRelationshipResolutionError> errors = new LinkedHashSet<>();
    errors.add(new ImmutableLegalEntityRelationshipResolutionError.Json());

    Json json = new Json();
    ImmutableResolvedReference.Json targetEntityReference = new ImmutableResolvedReference.Json();
    json.setTargetEntityReference(targetEntityReference);
    ImmutableResolvedReference.Json legalEntityReference = new ImmutableResolvedReference.Json();
    json.setLegalEntityReference(legalEntityReference);
    Optional<String> comment = Optional.of("42");
    json.setComment(comment);
    json.setErrors(errors);
    json.setOperation(UploadOperation.ADD);
    json.setExistingRelationshipReference(null);

    // Act
    ImmutableResolvedLegalEntityRelationship actualFromJsonResult =
        ImmutableResolvedLegalEntityRelationship.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.errors().size());
    assertEquals(UploadOperation.ADD, actualFromJsonResult.operation());
    assertSame(legalEntityReference, actualFromJsonResult.legalEntityReference());
    assertSame(targetEntityReference, actualFromJsonResult.targetEntityReference());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableResolvedLegalEntityRelationship#errors()}
   *   <li>{@link ImmutableResolvedLegalEntityRelationship#legalEntityReference()}
   *   <li>{@link ImmutableResolvedLegalEntityRelationship#operation()}
   *   <li>{@link ImmutableResolvedLegalEntityRelationship#targetEntityReference()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableResolvedLegalEntityRelationship.errors()",
    "ResolvedReference ImmutableResolvedLegalEntityRelationship.legalEntityReference()",
    "UploadOperation ImmutableResolvedLegalEntityRelationship.operation()",
    "ResolvedReference ImmutableResolvedLegalEntityRelationship.targetEntityReference()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);
    ImmutableResolvedLegalEntityRelationship immutableResolvedLegalEntityRelationship =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build();

    // Act
    Set<LegalEntityRelationshipResolutionError> actualErrorsResult =
        immutableResolvedLegalEntityRelationship.errors();
    ResolvedReference actualLegalEntityReferenceResult =
        immutableResolvedLegalEntityRelationship.legalEntityReference();
    UploadOperation actualOperationResult = immutableResolvedLegalEntityRelationship.operation();

    // Assert
    assertTrue(actualLegalEntityReferenceResult instanceof ImmutableResolvedReference);
    assertTrue(
        immutableResolvedLegalEntityRelationship.targetEntityReference()
            instanceof ImmutableResolvedReference);
    assertEquals(UploadOperation.ADD, actualOperationResult);
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
   * Test Json {@link Json#existingRelationshipReference()}.
   *
   * <p>Method under test: {@link Json#existingRelationshipReference()}
   */
  @Test
  @DisplayName("Test Json existingRelationshipReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.existingRelationshipReference()"})
  void testJsonExistingRelationshipReference() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new Json().existingRelationshipReference());
  }

  /**
   * Test Json {@link Json#legalEntityReference()}.
   *
   * <p>Method under test: {@link Json#legalEntityReference()}
   */
  @Test
  @DisplayName("Test Json legalEntityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResolvedReference Json.legalEntityReference()"})
  void testJsonLegalEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().legalEntityReference());
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
    assertNull(actualJson.legalEntityReference);
    assertNull(actualJson.targetEntityReference);
    assertNull(actualJson.operation);
    assertFalse(actualJson.comment.isPresent());
    assertFalse(actualJson.existingRelationshipReference.isPresent());
    assertTrue(actualJson.errors.isEmpty());
  }

  /**
   * Test Json {@link Json#operation()}.
   *
   * <p>Method under test: {@link Json#operation()}
   */
  @Test
  @DisplayName("Test Json operation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UploadOperation Json.operation()"})
  void testJsonOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().operation());
  }

  /**
   * Test Json {@link Json#targetEntityReference()}.
   *
   * <p>Method under test: {@link Json#targetEntityReference()}
   */
  @Test
  @DisplayName("Test Json targetEntityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResolvedReference Json.targetEntityReference()"})
  void testJsonTargetEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().targetEntityReference());
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#toString()}.
   *
   * <p>Method under test: {@link ImmutableResolvedLegalEntityRelationship#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableResolvedLegalEntityRelationship.toString()"})
  void testToString() {
    // Arrange
    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);

    // Act and Assert
    assertEquals(
        "ResolvedLegalEntityRelationship{targetEntityReference=ResolvedReference{inputString=Input String,"
            + " resolvedEntityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}}, legalEntityReference"
            + "=ResolvedReference{inputString=Input String, resolvedEntityReference=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}}, comment=Comment, errors=[], operation=ADD, existingRelationshipReference"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}}",
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#toString()}.
   *
   * <p>Method under test: {@link ImmutableResolvedLegalEntityRelationship#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableResolvedLegalEntityRelationship.toString()"})
  void testToString2() {
    // Arrange
    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    Optional<? extends EntityReference> existingRelationshipReference = Optional.empty();

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference2);

    // Act and Assert
    assertEquals(
        "ResolvedLegalEntityRelationship{targetEntityReference=ResolvedReference{inputString=Input String,"
            + " resolvedEntityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}}, legalEntityReference"
            + "=ResolvedReference{inputString=Input String, resolvedEntityReference=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}}, comment=Comment, errors=[], operation=ADD}",
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#withComment(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableResolvedLegalEntityRelationship#withComment(Optional)}
   */
  @Test
  @DisplayName("Test withComment(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedLegalEntityRelationship ImmutableResolvedLegalEntityRelationship.withComment(Optional)"
  })
  void testWithCommentWithOptional() {
    // Arrange
    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);
    ImmutableResolvedLegalEntityRelationship immutableResolvedLegalEntityRelationship =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableResolvedLegalEntityRelationship actualWithCommentResult =
        immutableResolvedLegalEntityRelationship.withComment(optional);

    // Assert
    ResolvedReference legalEntityReferenceResult = actualWithCommentResult.legalEntityReference();
    assertTrue(legalEntityReferenceResult instanceof ImmutableResolvedReference);
    ResolvedReference targetEntityReferenceResult = actualWithCommentResult.targetEntityReference();
    assertTrue(targetEntityReferenceResult instanceof ImmutableResolvedReference);
    assertEquals("Input String", legalEntityReferenceResult.inputString());
    assertEquals(UploadOperation.ADD, actualWithCommentResult.operation());
    assertTrue(actualWithCommentResult.errors().isEmpty());
    assertEquals(legalEntityReferenceResult, targetEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#withComment(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableResolvedLegalEntityRelationship#withComment(Optional)}
   */
  @Test
  @DisplayName("Test withComment(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedLegalEntityRelationship ImmutableResolvedLegalEntityRelationship.withComment(Optional)"
  })
  void testWithCommentWithOptional2() {
    // Arrange
    Builder commentResult = ImmutableResolvedLegalEntityRelationship.builder().comment("42");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);
    ImmutableResolvedLegalEntityRelationship immutableResolvedLegalEntityRelationship =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableResolvedLegalEntityRelationship actualWithCommentResult =
        immutableResolvedLegalEntityRelationship.withComment(optional);

    // Assert
    assertSame(immutableResolvedLegalEntityRelationship, actualWithCommentResult);
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#withComment(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableResolvedLegalEntityRelationship#withComment(String)}
   */
  @Test
  @DisplayName("Test withComment(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedLegalEntityRelationship ImmutableResolvedLegalEntityRelationship.withComment(String)"
  })
  void testWithCommentWithValue() {
    // Arrange
    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);

    // Act
    ImmutableResolvedLegalEntityRelationship actualWithCommentResult =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build()
            .withComment("42");

    // Assert
    ResolvedReference legalEntityReferenceResult = actualWithCommentResult.legalEntityReference();
    assertTrue(legalEntityReferenceResult instanceof ImmutableResolvedReference);
    ResolvedReference targetEntityReferenceResult = actualWithCommentResult.targetEntityReference();
    assertTrue(targetEntityReferenceResult instanceof ImmutableResolvedReference);
    assertEquals("Input String", legalEntityReferenceResult.inputString());
    assertEquals(UploadOperation.ADD, actualWithCommentResult.operation());
    assertTrue(actualWithCommentResult.errors().isEmpty());
    assertEquals(legalEntityReferenceResult, targetEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#withComment(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableResolvedLegalEntityRelationship#withComment(String)}
   */
  @Test
  @DisplayName("Test withComment(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedLegalEntityRelationship ImmutableResolvedLegalEntityRelationship.withComment(String)"
  })
  void testWithCommentWithValue2() {
    // Arrange
    Builder commentResult = ImmutableResolvedLegalEntityRelationship.builder().comment("42");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);
    ImmutableResolvedLegalEntityRelationship immutableResolvedLegalEntityRelationship =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build();

    // Act
    ImmutableResolvedLegalEntityRelationship actualWithCommentResult =
        immutableResolvedLegalEntityRelationship.withComment("42");

    // Assert
    assertSame(immutableResolvedLegalEntityRelationship, actualWithCommentResult);
  }

  /**
   * Test {@link
   * ImmutableResolvedLegalEntityRelationship#withErrors(LegalEntityRelationshipResolutionError[])}
   * with {@code LegalEntityRelationshipResolutionError[]}.
   *
   * <p>Method under test: {@link
   * ImmutableResolvedLegalEntityRelationship#withErrors(LegalEntityRelationshipResolutionError[])}
   */
  @Test
  @DisplayName(
      "Test withErrors(LegalEntityRelationshipResolutionError[]) with 'LegalEntityRelationshipResolutionError[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedLegalEntityRelationship ImmutableResolvedLegalEntityRelationship.withErrors(LegalEntityRelationshipResolutionError[])"
  })
  void testWithErrorsWithLegalEntityRelationshipResolutionError() {
    // Arrange
    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);
    ImmutableResolvedLegalEntityRelationship immutableResolvedLegalEntityRelationship =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build();

    // Act
    ImmutableResolvedLegalEntityRelationship actualWithErrorsResult =
        immutableResolvedLegalEntityRelationship.withErrors(
            ImmutableLegalEntityRelationshipResolutionError.builder()
                .errorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND)
                .errorMessage("An error occurred")
                .build());

    // Assert
    ResolvedReference legalEntityReferenceResult = actualWithErrorsResult.legalEntityReference();
    assertTrue(legalEntityReferenceResult instanceof ImmutableResolvedReference);
    ResolvedReference targetEntityReferenceResult = actualWithErrorsResult.targetEntityReference();
    assertTrue(targetEntityReferenceResult instanceof ImmutableResolvedReference);
    assertEquals("Input String", legalEntityReferenceResult.inputString());
    assertEquals(1, actualWithErrorsResult.errors().size());
    assertEquals(UploadOperation.ADD, actualWithErrorsResult.operation());
    assertEquals(legalEntityReferenceResult, targetEntityReferenceResult);
  }

  /**
   * Test {@link
   * ImmutableResolvedLegalEntityRelationship#withExistingRelationshipReference(Optional)} with
   * {@code optional}.
   *
   * <p>Method under test: {@link
   * ImmutableResolvedLegalEntityRelationship#withExistingRelationshipReference(Optional)}
   */
  @Test
  @DisplayName("Test withExistingRelationshipReference(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedLegalEntityRelationship ImmutableResolvedLegalEntityRelationship.withExistingRelationshipReference(Optional)"
  })
  void testWithExistingRelationshipReferenceWithOptional() {
    // Arrange
    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);
    ImmutableResolvedLegalEntityRelationship immutableResolvedLegalEntityRelationship =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build();
    ImmutableEntityReference immutableEntityReference4 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> optional = Optional.of(immutableEntityReference4);

    // Act
    ImmutableResolvedLegalEntityRelationship actualWithExistingRelationshipReferenceResult =
        immutableResolvedLegalEntityRelationship.withExistingRelationshipReference(optional);

    // Assert
    assertEquals(
        immutableResolvedLegalEntityRelationship, actualWithExistingRelationshipReferenceResult);
  }

  /**
   * Test {@link
   * ImmutableResolvedLegalEntityRelationship#withExistingRelationshipReference(EntityReference)}
   * with {@code value}.
   *
   * <p>Method under test: {@link
   * ImmutableResolvedLegalEntityRelationship#withExistingRelationshipReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withExistingRelationshipReference(EntityReference) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedLegalEntityRelationship ImmutableResolvedLegalEntityRelationship.withExistingRelationshipReference(EntityReference)"
  })
  void testWithExistingRelationshipReferenceWithValue() {
    // Arrange
    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);
    ImmutableResolvedLegalEntityRelationship immutableResolvedLegalEntityRelationship =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build();

    // Act
    ImmutableResolvedLegalEntityRelationship actualWithExistingRelationshipReferenceResult =
        immutableResolvedLegalEntityRelationship.withExistingRelationshipReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(
        immutableResolvedLegalEntityRelationship, actualWithExistingRelationshipReferenceResult);
  }

  /**
   * Test {@link
   * ImmutableResolvedLegalEntityRelationship#withLegalEntityReference(ResolvedReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableResolvedLegalEntityRelationship#withLegalEntityReference(ResolvedReference)}
   */
  @Test
  @DisplayName("Test withLegalEntityReference(ResolvedReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedLegalEntityRelationship ImmutableResolvedLegalEntityRelationship.withLegalEntityReference(ResolvedReference)"
  })
  void testWithLegalEntityReference() {
    // Arrange
    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);
    ImmutableResolvedLegalEntityRelationship immutableResolvedLegalEntityRelationship =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build();

    ImmutableResolvedReference.Builder inputStringResult3 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference4 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference3 =
        Optional.of(immutableEntityReference4);

    // Act
    ImmutableResolvedLegalEntityRelationship actualWithLegalEntityReferenceResult =
        immutableResolvedLegalEntityRelationship.withLegalEntityReference(
            inputStringResult3.resolvedEntityReference(resolvedEntityReference3).build());

    // Assert
    assertEquals(immutableResolvedLegalEntityRelationship, actualWithLegalEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#withOperation(UploadOperation)}.
   *
   * <p>Method under test: {@link
   * ImmutableResolvedLegalEntityRelationship#withOperation(UploadOperation)}
   */
  @Test
  @DisplayName("Test withOperation(UploadOperation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedLegalEntityRelationship ImmutableResolvedLegalEntityRelationship.withOperation(UploadOperation)"
  })
  void testWithOperation() {
    // Arrange
    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);
    ImmutableResolvedLegalEntityRelationship immutableResolvedLegalEntityRelationship =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build();

    // Act
    ImmutableResolvedLegalEntityRelationship actualWithOperationResult =
        immutableResolvedLegalEntityRelationship.withOperation(UploadOperation.ADD);

    // Assert
    assertSame(immutableResolvedLegalEntityRelationship, actualWithOperationResult);
  }

  /**
   * Test {@link ImmutableResolvedLegalEntityRelationship#withOperation(UploadOperation)}.
   *
   * <ul>
   *   <li>Then legalEntityReference return {@link ImmutableResolvedReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableResolvedLegalEntityRelationship#withOperation(UploadOperation)}
   */
  @Test
  @DisplayName(
      "Test withOperation(UploadOperation); then legalEntityReference return ImmutableResolvedReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedLegalEntityRelationship ImmutableResolvedLegalEntityRelationship.withOperation(UploadOperation)"
  })
  void testWithOperation_thenLegalEntityReferenceReturnImmutableResolvedReference() {
    // Arrange
    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.UPDATE);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);

    // Act
    ImmutableResolvedLegalEntityRelationship actualWithOperationResult =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build()
            .withOperation(UploadOperation.ADD);

    // Assert
    ResolvedReference legalEntityReferenceResult = actualWithOperationResult.legalEntityReference();
    assertTrue(legalEntityReferenceResult instanceof ImmutableResolvedReference);
    ResolvedReference targetEntityReferenceResult =
        actualWithOperationResult.targetEntityReference();
    assertTrue(targetEntityReferenceResult instanceof ImmutableResolvedReference);
    assertEquals("Input String", legalEntityReferenceResult.inputString());
    assertEquals(UploadOperation.ADD, actualWithOperationResult.operation());
    assertTrue(actualWithOperationResult.errors().isEmpty());
    assertEquals(legalEntityReferenceResult, targetEntityReferenceResult);
  }

  /**
   * Test {@link
   * ImmutableResolvedLegalEntityRelationship#withTargetEntityReference(ResolvedReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableResolvedLegalEntityRelationship#withTargetEntityReference(ResolvedReference)}
   */
  @Test
  @DisplayName("Test withTargetEntityReference(ResolvedReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedLegalEntityRelationship ImmutableResolvedLegalEntityRelationship.withTargetEntityReference(ResolvedReference)"
  })
  void testWithTargetEntityReference() {
    // Arrange
    Builder commentResult =
        ImmutableResolvedLegalEntityRelationship.builder()
            .comment(LegalEntityBulkUploadFixedColumns.COMMENT);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> existingRelationshipReference =
        Optional.of(immutableEntityReference);

    Builder existingRelationshipReferenceResult =
        commentResult.existingRelationshipReference(existingRelationshipReference);

    ImmutableResolvedReference.Builder inputStringResult =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference =
        Optional.of(immutableEntityReference2);

    Builder operationResult =
        existingRelationshipReferenceResult
            .legalEntityReference(
                inputStringResult.resolvedEntityReference(resolvedEntityReference).build())
            .operation(UploadOperation.ADD);

    ImmutableResolvedReference.Builder inputStringResult2 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference2 =
        Optional.of(immutableEntityReference3);
    ImmutableResolvedLegalEntityRelationship immutableResolvedLegalEntityRelationship =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build();

    ImmutableResolvedReference.Builder inputStringResult3 =
        ImmutableResolvedReference.builder().inputString("Input String");
    ImmutableEntityReference immutableEntityReference4 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> resolvedEntityReference3 =
        Optional.of(immutableEntityReference4);

    // Act
    ImmutableResolvedLegalEntityRelationship actualWithTargetEntityReferenceResult =
        immutableResolvedLegalEntityRelationship.withTargetEntityReference(
            inputStringResult3.resolvedEntityReference(resolvedEntityReference3).build());

    // Assert
    assertEquals(immutableResolvedLegalEntityRelationship, actualWithTargetEntityReferenceResult);
  }
}
