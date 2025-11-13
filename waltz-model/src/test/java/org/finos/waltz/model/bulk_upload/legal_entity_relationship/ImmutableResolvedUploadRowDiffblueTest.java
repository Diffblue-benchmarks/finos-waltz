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
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableResolvedUploadRow.Builder;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableResolvedUploadRow.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableResolvedUploadRowDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAssessmentRatings(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllAssessmentRatings(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllAssessmentRatings(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllAssessmentRatings(Iterable)"})
  void testBuilderAddAllAssessmentRatings_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableResolvedUploadRow.builder();

    // Act
    Builder actualAddAllAssessmentRatingsResult =
        builderResult.addAllAssessmentRatings(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAssessmentRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addAssessmentRatings(AssessmentCell)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableAssessmentCell.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAssessmentRatings(AssessmentCell)}
   */
  @Test
  @DisplayName(
      "Test Builder addAssessmentRatings(AssessmentCell) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAssessmentRatings(AssessmentCell)"})
  void testBuilderAddAssessmentRatingsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableResolvedUploadRow.builder();

    // Act
    Builder actualAddAssessmentRatingsResult =
        builderResult.addAssessmentRatings(new ImmutableAssessmentCell.Json());

    // Assert
    assertSame(builderResult, actualAddAssessmentRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addAssessmentRatings(AssessmentCell[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableAssessmentCell.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAssessmentRatings(AssessmentCell[])}
   */
  @Test
  @DisplayName(
      "Test Builder addAssessmentRatings(AssessmentCell[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAssessmentRatings(AssessmentCell[])"})
  void testBuilderAddAssessmentRatingsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableResolvedUploadRow.builder();

    // Act
    Builder actualAddAssessmentRatingsResult =
        builderResult.addAssessmentRatings(new ImmutableAssessmentCell.Json());

    // Assert
    assertSame(builderResult, actualAddAssessmentRatingsResult);
  }

  /**
   * Test Builder {@link Builder#assessmentRatings(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#assessmentRatings(Iterable)}
   */
  @Test
  @DisplayName("Test Builder assessmentRatings(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.assessmentRatings(Iterable)"})
  void testBuilderAssessmentRatings_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableResolvedUploadRow.builder();

    // Act
    Builder actualAssessmentRatingsResult = builderResult.assessmentRatings(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAssessmentRatingsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableResolvedUploadRow Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableResolvedUploadRow.builder();
    ImmutableResolvedLegalEntityRelationship.Builder commentResult =
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
    ImmutableResolvedLegalEntityRelationship.Builder existingRelationshipReferenceResult =
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
    ImmutableResolvedLegalEntityRelationship.Builder operationResult =
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
    ImmutableResolvedLegalEntityRelationship legalEntityRelationship =
        operationResult
            .targetEntityReference(
                inputStringResult2.resolvedEntityReference(resolvedEntityReference2).build())
            .build();
    ImmutableResolvedUploadRow actualImmutableResolvedUploadRow =
        actualBuilderResult.legalEntityRelationship(legalEntityRelationship).rowNumber(1L).build();

    // Assert
    assertEquals(1L, actualImmutableResolvedUploadRow.rowNumber());
    assertTrue(actualImmutableResolvedUploadRow.assessmentRatings().isEmpty());
    assertSame(legalEntityRelationship, actualImmutableResolvedUploadRow.legalEntityRelationship());
  }

  /**
   * Test Builder {@link Builder#from(ResolvedUploadRow)}.
   *
   * <p>Method under test: {@link Builder#from(ResolvedUploadRow)}
   */
  @Test
  @DisplayName("Test Builder from(ResolvedUploadRow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ResolvedUploadRow)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableResolvedUploadRow.builder();

    Builder builderResult2 = ImmutableResolvedUploadRow.builder();

    ImmutableResolvedLegalEntityRelationship.Builder commentResult =
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

    ImmutableResolvedLegalEntityRelationship.Builder existingRelationshipReferenceResult =
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

    ImmutableResolvedLegalEntityRelationship.Builder operationResult =
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
    ImmutableResolvedUploadRow instance =
        builderResult2
            .legalEntityRelationship(
                operationResult
                    .targetEntityReference(
                        inputStringResult2
                            .resolvedEntityReference(resolvedEntityReference2)
                            .build())
                    .build())
            .rowNumber(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableResolvedUploadRow actualImmutableResolvedUploadRow = builderResult.build();
    assertEquals(instance, actualImmutableResolvedUploadRow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ResolvedUploadRow)}.
   *
   * <ul>
   *   <li>Given builder columnId one inputString {@code Input String} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ResolvedUploadRow)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ResolvedUploadRow); given builder columnId one inputString 'Input String' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ResolvedUploadRow)"})
  void testBuilderFrom_givenBuilderColumnIdOneInputStringInputStringBuild() {
    // Arrange
    Builder builderResult = ImmutableResolvedUploadRow.builder();

    Builder builderResult2 = ImmutableResolvedUploadRow.builder();
    builderResult2.addAssessmentRatings(
        ImmutableAssessmentCell.builder().columnId(1).inputString("Input String").build());

    ImmutableResolvedLegalEntityRelationship.Builder commentResult =
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

    ImmutableResolvedLegalEntityRelationship.Builder existingRelationshipReferenceResult =
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

    ImmutableResolvedLegalEntityRelationship.Builder operationResult =
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
    ImmutableResolvedUploadRow instance =
        builderResult2
            .legalEntityRelationship(
                operationResult
                    .targetEntityReference(
                        inputStringResult2
                            .resolvedEntityReference(resolvedEntityReference2)
                            .build())
                    .build())
            .rowNumber(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableResolvedUploadRow actualImmutableResolvedUploadRow = builderResult.build();
    assertEquals(instance, actualImmutableResolvedUploadRow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#legalEntityRelationship(ResolvedLegalEntityRelationship)}.
   *
   * <ul>
   *   <li>When {@link ImmutableResolvedLegalEntityRelationship.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#legalEntityRelationship(ResolvedLegalEntityRelationship)}
   */
  @Test
  @DisplayName(
      "Test Builder legalEntityRelationship(ResolvedLegalEntityRelationship); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.legalEntityRelationship(ResolvedLegalEntityRelationship)"})
  void testBuilderLegalEntityRelationship_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableResolvedUploadRow.builder();

    // Act
    Builder actualLegalEntityRelationshipResult =
        builderResult.legalEntityRelationship(new ImmutableResolvedLegalEntityRelationship.Json());

    // Assert
    assertSame(builderResult, actualLegalEntityRelationshipResult);
  }

  /**
   * Test Builder {@link Builder#rowNumber(long)}.
   *
   * <p>Method under test: {@link Builder#rowNumber(long)}
   */
  @Test
  @DisplayName("Test Builder rowNumber(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.rowNumber(long)"})
  void testBuilderRowNumber() {
    // Arrange
    Builder builderResult = ImmutableResolvedUploadRow.builder();

    // Act
    Builder actualRowNumberResult = builderResult.rowNumber(1L);

    // Assert
    assertSame(builderResult, actualRowNumberResult);
  }

  /**
   * Test {@link ImmutableResolvedUploadRow#copyOf(ResolvedUploadRow)}.
   *
   * <p>Method under test: {@link ImmutableResolvedUploadRow#copyOf(ResolvedUploadRow)}
   */
  @Test
  @DisplayName("Test copyOf(ResolvedUploadRow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolvedUploadRow ImmutableResolvedUploadRow.copyOf(ResolvedUploadRow)"
  })
  void testCopyOf() {
    // Arrange
    Builder builderResult = ImmutableResolvedUploadRow.builder();

    ImmutableResolvedLegalEntityRelationship.Builder commentResult =
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

    ImmutableResolvedLegalEntityRelationship.Builder existingRelationshipReferenceResult =
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

    ImmutableResolvedLegalEntityRelationship.Builder operationResult =
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
    ImmutableResolvedUploadRow instance =
        builderResult
            .legalEntityRelationship(
                operationResult
                    .targetEntityReference(
                        inputStringResult2
                            .resolvedEntityReference(resolvedEntityReference2)
                            .build())
                    .build())
            .rowNumber(1L)
            .build();

    // Act
    ImmutableResolvedUploadRow actualCopyOfResult = ImmutableResolvedUploadRow.copyOf(instance);

    // Assert
    ResolvedLegalEntityRelationship legalEntityRelationshipResult =
        actualCopyOfResult.legalEntityRelationship();
    assertTrue(legalEntityRelationshipResult instanceof ImmutableResolvedLegalEntityRelationship);
    ResolvedReference legalEntityReferenceResult =
        legalEntityRelationshipResult.legalEntityReference();
    assertTrue(legalEntityReferenceResult instanceof ImmutableResolvedReference);
    ResolvedReference targetEntityReferenceResult =
        legalEntityRelationshipResult.targetEntityReference();
    assertTrue(targetEntityReferenceResult instanceof ImmutableResolvedReference);
    assertEquals("Input String", legalEntityReferenceResult.inputString());
    assertEquals(1L, actualCopyOfResult.rowNumber());
    assertEquals(UploadOperation.ADD, legalEntityRelationshipResult.operation());
    Set<AssessmentCell> assessmentRatingsResult = actualCopyOfResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertEquals(legalEntityReferenceResult, targetEntityReferenceResult);
    assertSame(assessmentRatingsResult, legalEntityRelationshipResult.errors());
  }

  /**
   * Test {@link ImmutableResolvedUploadRow#equals(Object)}, and {@link
   * ImmutableResolvedUploadRow#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableResolvedUploadRow#equals(Object)}
   *   <li>{@link ImmutableResolvedUploadRow#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolvedUploadRow.equals(Object)",
    "int ImmutableResolvedUploadRow.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableResolvedUploadRow.builder();

    ImmutableResolvedLegalEntityRelationship.Builder commentResult =
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

    ImmutableResolvedLegalEntityRelationship.Builder existingRelationshipReferenceResult =
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

    ImmutableResolvedLegalEntityRelationship.Builder operationResult =
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
    ImmutableResolvedUploadRow immutableResolvedUploadRow =
        builderResult
            .legalEntityRelationship(
                operationResult
                    .targetEntityReference(
                        inputStringResult2
                            .resolvedEntityReference(resolvedEntityReference2)
                            .build())
                    .build())
            .rowNumber(1L)
            .build();

    Builder builderResult2 = ImmutableResolvedUploadRow.builder();

    ImmutableResolvedLegalEntityRelationship.Builder commentResult2 =
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

    ImmutableResolvedLegalEntityRelationship.Builder existingRelationshipReferenceResult2 =
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

    ImmutableResolvedLegalEntityRelationship.Builder operationResult2 =
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
    ImmutableResolvedUploadRow immutableResolvedUploadRow2 =
        builderResult2
            .legalEntityRelationship(
                operationResult2
                    .targetEntityReference(
                        inputStringResult4
                            .resolvedEntityReference(resolvedEntityReference4)
                            .build())
                    .build())
            .rowNumber(1L)
            .build();

    // Act and Assert
    assertEquals(immutableResolvedUploadRow, immutableResolvedUploadRow2);
    assertEquals(immutableResolvedUploadRow.hashCode(), immutableResolvedUploadRow2.hashCode());
  }

  /**
   * Test {@link ImmutableResolvedUploadRow#equals(Object)}, and {@link
   * ImmutableResolvedUploadRow#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableResolvedUploadRow#equals(Object)}
   *   <li>{@link ImmutableResolvedUploadRow#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolvedUploadRow.equals(Object)",
    "int ImmutableResolvedUploadRow.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableResolvedUploadRow.builder();

    ImmutableResolvedLegalEntityRelationship.Builder commentResult =
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

    ImmutableResolvedLegalEntityRelationship.Builder existingRelationshipReferenceResult =
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

    ImmutableResolvedLegalEntityRelationship.Builder operationResult =
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
    ImmutableResolvedUploadRow immutableResolvedUploadRow =
        builderResult
            .legalEntityRelationship(
                operationResult
                    .targetEntityReference(
                        inputStringResult2
                            .resolvedEntityReference(resolvedEntityReference2)
                            .build())
                    .build())
            .rowNumber(1L)
            .build();

    // Act and Assert
    assertEquals(immutableResolvedUploadRow, immutableResolvedUploadRow);
    int expectedHashCodeResult = immutableResolvedUploadRow.hashCode();
    assertEquals(expectedHashCodeResult, immutableResolvedUploadRow.hashCode());
  }

  /**
   * Test {@link ImmutableResolvedUploadRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedUploadRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolvedUploadRow.equals(Object)",
    "int ImmutableResolvedUploadRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableResolvedUploadRow.builder();
    builderResult.addAssessmentRatings(
        ImmutableAssessmentCell.builder().columnId(1).inputString("Input String").build());

    ImmutableResolvedLegalEntityRelationship.Builder commentResult =
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

    ImmutableResolvedLegalEntityRelationship.Builder existingRelationshipReferenceResult =
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

    ImmutableResolvedLegalEntityRelationship.Builder operationResult =
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
    ImmutableResolvedUploadRow immutableResolvedUploadRow =
        builderResult
            .legalEntityRelationship(
                operationResult
                    .targetEntityReference(
                        inputStringResult2
                            .resolvedEntityReference(resolvedEntityReference2)
                            .build())
                    .build())
            .rowNumber(1L)
            .build();

    Builder builderResult2 = ImmutableResolvedUploadRow.builder();

    ImmutableResolvedLegalEntityRelationship.Builder commentResult2 =
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

    ImmutableResolvedLegalEntityRelationship.Builder existingRelationshipReferenceResult2 =
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

    ImmutableResolvedLegalEntityRelationship.Builder operationResult2 =
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
        immutableResolvedUploadRow,
        builderResult2
            .legalEntityRelationship(
                operationResult2
                    .targetEntityReference(
                        inputStringResult4
                            .resolvedEntityReference(resolvedEntityReference4)
                            .build())
                    .build())
            .rowNumber(1L)
            .build());
  }

  /**
   * Test {@link ImmutableResolvedUploadRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedUploadRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolvedUploadRow.equals(Object)",
    "int ImmutableResolvedUploadRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableResolvedLegalEntityRelationship.Builder builderResult =
        ImmutableResolvedLegalEntityRelationship.builder();
    builderResult.addErrors(
        ImmutableLegalEntityRelationshipResolutionError.builder()
            .errorCode(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND)
            .errorMessage("An error occurred")
            .build());

    ImmutableResolvedLegalEntityRelationship.Builder commentResult =
        builderResult.comment(LegalEntityBulkUploadFixedColumns.COMMENT);
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

    ImmutableResolvedLegalEntityRelationship.Builder existingRelationshipReferenceResult =
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

    ImmutableResolvedLegalEntityRelationship.Builder operationResult =
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
    ImmutableResolvedUploadRow immutableResolvedUploadRow =
        ImmutableResolvedUploadRow.builder()
            .legalEntityRelationship(
                operationResult
                    .targetEntityReference(
                        inputStringResult2
                            .resolvedEntityReference(resolvedEntityReference2)
                            .build())
                    .build())
            .rowNumber(1L)
            .build();

    Builder builderResult2 = ImmutableResolvedUploadRow.builder();

    ImmutableResolvedLegalEntityRelationship.Builder commentResult2 =
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

    ImmutableResolvedLegalEntityRelationship.Builder existingRelationshipReferenceResult2 =
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

    ImmutableResolvedLegalEntityRelationship.Builder operationResult2 =
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
        immutableResolvedUploadRow,
        builderResult2
            .legalEntityRelationship(
                operationResult2
                    .targetEntityReference(
                        inputStringResult4
                            .resolvedEntityReference(resolvedEntityReference4)
                            .build())
                    .build())
            .rowNumber(1L)
            .build());
  }

  /**
   * Test {@link ImmutableResolvedUploadRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedUploadRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolvedUploadRow.equals(Object)",
    "int ImmutableResolvedUploadRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableResolvedUploadRow.builder();

    ImmutableResolvedLegalEntityRelationship.Builder commentResult =
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

    ImmutableResolvedLegalEntityRelationship.Builder existingRelationshipReferenceResult =
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

    ImmutableResolvedLegalEntityRelationship.Builder operationResult =
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
    ImmutableResolvedUploadRow immutableResolvedUploadRow =
        builderResult
            .legalEntityRelationship(
                operationResult
                    .targetEntityReference(
                        inputStringResult2
                            .resolvedEntityReference(resolvedEntityReference2)
                            .build())
                    .build())
            .rowNumber(0L)
            .build();

    Builder builderResult2 = ImmutableResolvedUploadRow.builder();

    ImmutableResolvedLegalEntityRelationship.Builder commentResult2 =
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

    ImmutableResolvedLegalEntityRelationship.Builder existingRelationshipReferenceResult2 =
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

    ImmutableResolvedLegalEntityRelationship.Builder operationResult2 =
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
        immutableResolvedUploadRow,
        builderResult2
            .legalEntityRelationship(
                operationResult2
                    .targetEntityReference(
                        inputStringResult4
                            .resolvedEntityReference(resolvedEntityReference4)
                            .build())
                    .build())
            .rowNumber(1L)
            .build());
  }

  /**
   * Test {@link ImmutableResolvedUploadRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedUploadRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolvedUploadRow.equals(Object)",
    "int ImmutableResolvedUploadRow.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableResolvedUploadRow.builder();

    ImmutableResolvedLegalEntityRelationship.Builder commentResult =
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

    ImmutableResolvedLegalEntityRelationship.Builder existingRelationshipReferenceResult =
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

    ImmutableResolvedLegalEntityRelationship.Builder operationResult =
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
        builderResult
            .legalEntityRelationship(
                operationResult
                    .targetEntityReference(
                        inputStringResult2
                            .resolvedEntityReference(resolvedEntityReference2)
                            .build())
                    .build())
            .rowNumber(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableResolvedUploadRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolvedUploadRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolvedUploadRow.equals(Object)",
    "int ImmutableResolvedUploadRow.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableResolvedUploadRow.builder();

    ImmutableResolvedLegalEntityRelationship.Builder commentResult =
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

    ImmutableResolvedLegalEntityRelationship.Builder existingRelationshipReferenceResult =
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

    ImmutableResolvedLegalEntityRelationship.Builder operationResult =
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
        builderResult
            .legalEntityRelationship(
                operationResult
                    .targetEntityReference(
                        inputStringResult2
                            .resolvedEntityReference(resolvedEntityReference2)
                            .build())
                    .build())
            .rowNumber(1L)
            .build(),
        "Different type to ImmutableResolvedUploadRow");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableResolvedUploadRow#toString()}
   *   <li>{@link ImmutableResolvedUploadRow#assessmentRatings()}
   *   <li>{@link ImmutableResolvedUploadRow#legalEntityRelationship()}
   *   <li>{@link ImmutableResolvedUploadRow#rowNumber()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableResolvedUploadRow.assessmentRatings()",
    "ResolvedLegalEntityRelationship ImmutableResolvedUploadRow.legalEntityRelationship()",
    "long ImmutableResolvedUploadRow.rowNumber()",
    "String ImmutableResolvedUploadRow.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableResolvedUploadRow.builder();

    ImmutableResolvedLegalEntityRelationship.Builder commentResult =
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

    ImmutableResolvedLegalEntityRelationship.Builder existingRelationshipReferenceResult =
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

    ImmutableResolvedLegalEntityRelationship.Builder operationResult =
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
    ImmutableResolvedUploadRow immutableResolvedUploadRow =
        builderResult
            .legalEntityRelationship(
                operationResult
                    .targetEntityReference(
                        inputStringResult2
                            .resolvedEntityReference(resolvedEntityReference2)
                            .build())
                    .build())
            .rowNumber(1L)
            .build();

    // Act
    String actualToStringResult = immutableResolvedUploadRow.toString();
    Set<AssessmentCell> actualAssessmentRatingsResult =
        immutableResolvedUploadRow.assessmentRatings();
    ResolvedLegalEntityRelationship actualLegalEntityRelationshipResult =
        immutableResolvedUploadRow.legalEntityRelationship();

    // Assert
    assertTrue(
        actualLegalEntityRelationshipResult instanceof ImmutableResolvedLegalEntityRelationship);
    assertEquals(
        "ResolvedUploadRow{rowNumber=1, legalEntityRelationship=ResolvedLegalEntityRelationship{targetEntityReference"
            + "=ResolvedReference{inputString=Input String, resolvedEntityReference=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}}, legalEntityReference=ResolvedReference{inputString=Input String,"
            + " resolvedEntityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}}, comment=Comment,"
            + " errors=[], operation=ADD, existingRelationshipReference=EntityReference{kind=ALL, id=1, entityLifec"
            + "ycleStatus=ACTIVE}}, assessmentRatings=[]}",
        actualToStringResult);
    assertEquals(1L, immutableResolvedUploadRow.rowNumber());
    assertTrue(actualAssessmentRatingsResult.isEmpty());
  }

  /**
   * Test Json {@link Json#assessmentRatings()}.
   *
   * <p>Method under test: {@link Json#assessmentRatings()}
   */
  @Test
  @DisplayName("Test Json assessmentRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.assessmentRatings()"})
  void testJsonAssessmentRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().assessmentRatings());
  }

  /**
   * Test Json {@link Json#legalEntityRelationship()}.
   *
   * <p>Method under test: {@link Json#legalEntityRelationship()}
   */
  @Test
  @DisplayName("Test Json legalEntityRelationship()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResolvedLegalEntityRelationship Json.legalEntityRelationship()"})
  void testJsonLegalEntityRelationship() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().legalEntityRelationship());
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
    assertNull(actualJson.legalEntityRelationship);
    assertEquals(0L, actualJson.rowNumber);
    assertFalse(actualJson.rowNumberIsSet);
    assertTrue(actualJson.assessmentRatings.isEmpty());
  }

  /**
   * Test Json {@link Json#rowNumber()}.
   *
   * <p>Method under test: {@link Json#rowNumber()}
   */
  @Test
  @DisplayName("Test Json rowNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.rowNumber()"})
  void testJsonRowNumber() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().rowNumber());
  }

  /**
   * Test Json {@link Json#setRowNumber(long)}.
   *
   * <p>Method under test: {@link Json#setRowNumber(long)}
   */
  @Test
  @DisplayName("Test Json setRowNumber(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setRowNumber(long)"})
  void testJsonSetRowNumber() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRowNumber(1L);

    // Assert
    assertEquals(1L, json.rowNumber);
    assertTrue(json.rowNumberIsSet);
  }
}
