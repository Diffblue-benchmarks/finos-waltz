package org.finos.waltz.model.legal_entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelationshipViewRow.Builder;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelationshipViewRow.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLegalEntityRelationshipViewRowDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAssessments(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllAssessments(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAssessments(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllAssessments(Iterable)"})
  void testBuilderAddAllAssessments_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    // Act
    Builder actualAddAllAssessmentsResult = builderResult.addAllAssessments(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAssessmentsResult);
  }

  /**
   * Test Builder {@link Builder#addAssessments(LegalEntityRelationshipViewAssessment)} with {@code
   * element}.
   *
   * <ul>
   *   <li>When {@link ImmutableLegalEntityRelationshipViewAssessment.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAssessments(LegalEntityRelationshipViewAssessment)}
   */
  @Test
  @DisplayName(
      "Test Builder addAssessments(LegalEntityRelationshipViewAssessment) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAssessments(LegalEntityRelationshipViewAssessment)"})
  void testBuilderAddAssessmentsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    // Act
    Builder actualAddAssessmentsResult =
        builderResult.addAssessments(new ImmutableLegalEntityRelationshipViewAssessment.Json());

    // Assert
    assertSame(builderResult, actualAddAssessmentsResult);
  }

  /**
   * Test Builder {@link Builder#addAssessments(LegalEntityRelationshipViewAssessment[])} with
   * {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableLegalEntityRelationshipViewAssessment.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAssessments(LegalEntityRelationshipViewAssessment[])}
   */
  @Test
  @DisplayName(
      "Test Builder addAssessments(LegalEntityRelationshipViewAssessment[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAssessments(LegalEntityRelationshipViewAssessment[])"})
  void testBuilderAddAssessmentsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    // Act
    Builder actualAddAssessmentsResult =
        builderResult.addAssessments(new ImmutableLegalEntityRelationshipViewAssessment.Json());

    // Assert
    assertSame(builderResult, actualAddAssessmentsResult);
  }

  /**
   * Test Builder {@link Builder#assessments(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#assessments(Iterable)}
   */
  @Test
  @DisplayName("Test Builder assessments(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.assessments(Iterable)"})
  void testBuilderAssessments_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    // Act
    Builder actualAssessmentsResult = builderResult.assessments(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAssessmentsResult);
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
  @MethodsUnderTest({"ImmutableLegalEntityRelationshipViewRow Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableLegalEntityRelationshipViewRow.builder();
    ImmutableLegalEntityRelationship.Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableLegalEntityRelationship.Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship relationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();
    ImmutableLegalEntityRelationshipViewRow actualImmutableLegalEntityRelationshipViewRow =
        actualBuilderResult.relationship(relationship).build();

    // Assert
    assertTrue(actualImmutableLegalEntityRelationshipViewRow.assessments().isEmpty());
    assertSame(relationship, actualImmutableLegalEntityRelationshipViewRow.relationship());
  }

  /**
   * Test Builder {@link Builder#from(LegalEntityRelationshipViewRow)}.
   *
   * <p>Method under test: {@link Builder#from(LegalEntityRelationshipViewRow)}
   */
  @Test
  @DisplayName("Test Builder from(LegalEntityRelationshipViewRow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LegalEntityRelationshipViewRow)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    Builder builderResult2 = ImmutableLegalEntityRelationshipViewRow.builder();

    ImmutableLegalEntityRelationship.Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    ImmutableLegalEntityRelationship.Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationshipViewRow instance =
        builderResult2
            .relationship(
                relationshipKindIdResult
                    .targetEntityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLegalEntityRelationshipViewRow actualImmutableLegalEntityRelationshipViewRow =
        builderResult.build();
    assertEquals(instance, actualImmutableLegalEntityRelationshipViewRow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LegalEntityRelationshipViewRow)}.
   *
   * <ul>
   *   <li>Given builder assessmentDefinitionId one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LegalEntityRelationshipViewRow)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LegalEntityRelationshipViewRow); given builder assessmentDefinitionId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LegalEntityRelationshipViewRow)"})
  void testBuilderFrom_givenBuilderAssessmentDefinitionIdOneBuild() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    Builder builderResult2 = ImmutableLegalEntityRelationshipViewRow.builder();
    builderResult2.addAssessments(
        ImmutableLegalEntityRelationshipViewAssessment.builder()
            .assessmentDefinitionId(1L)
            .build());

    ImmutableLegalEntityRelationship.Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    ImmutableLegalEntityRelationship.Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationshipViewRow instance =
        builderResult2
            .relationship(
                relationshipKindIdResult
                    .targetEntityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLegalEntityRelationshipViewRow actualImmutableLegalEntityRelationshipViewRow =
        builderResult.build();
    assertEquals(instance, actualImmutableLegalEntityRelationshipViewRow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#relationship(LegalEntityRelationship)}.
   *
   * <ul>
   *   <li>When {@link ImmutableLegalEntityRelationship.Json} (default constructor).
   *   <li>Then builder build relationship is {@link ImmutableLegalEntityRelationship.Json} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#relationship(LegalEntityRelationship)}
   */
  @Test
  @DisplayName(
      "Test Builder relationship(LegalEntityRelationship); when Json (default constructor); then builder build relationship is Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.relationship(LegalEntityRelationship)"})
  void testBuilderRelationship_whenJson_thenBuilderBuildRelationshipIsJson() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();
    ImmutableLegalEntityRelationship.Json relationship =
        new ImmutableLegalEntityRelationship.Json();

    // Act
    Builder actualRelationshipResult = builderResult.relationship(relationship);

    // Assert
    assertSame(relationship, builderResult.build().relationship());
    assertSame(builderResult, actualRelationshipResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipViewRow#copyOf(LegalEntityRelationshipViewRow)}.
   *
   * <ul>
   *   <li>Then relationship legalEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableLegalEntityRelationshipViewRow#copyOf(LegalEntityRelationshipViewRow)}
   */
  @Test
  @DisplayName(
      "Test copyOf(LegalEntityRelationshipViewRow); then relationship legalEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipViewRow ImmutableLegalEntityRelationshipViewRow.copyOf(LegalEntityRelationshipViewRow)"
  })
  void testCopyOf_thenRelationshipLegalEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    ImmutableLegalEntityRelationship.Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    ImmutableLegalEntityRelationship.Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationshipViewRow instance =
        builderResult
            .relationship(
                relationshipKindIdResult
                    .targetEntityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .build())
            .build();

    // Act
    ImmutableLegalEntityRelationshipViewRow actualCopyOfResult =
        ImmutableLegalEntityRelationshipViewRow.copyOf(instance);

    // Assert
    LegalEntityRelationship relationshipResult = actualCopyOfResult.relationship();
    EntityReference legalEntityReferenceResult = relationshipResult.legalEntityReference();
    assertTrue(legalEntityReferenceResult instanceof ImmutableEntityReference);
    EntityReference targetEntityReferenceResult = relationshipResult.targetEntityReference();
    assertTrue(targetEntityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(relationshipResult instanceof ImmutableLegalEntityRelationship);
    assertEquals("2020-03-01", relationshipResult.lastUpdatedBy());
    assertEquals("Provenance", relationshipResult.provenance());
    assertEquals("The characteristics of someone or something", relationshipResult.description());
    assertEquals(1L, relationshipResult.relationshipKindId().longValue());
    assertEquals(EntityKind.ALL, relationshipResult.kind());
    assertFalse(relationshipResult.isReadOnly());
    assertTrue(actualCopyOfResult.assessments().isEmpty());
    assertEquals(legalEntityReferenceResult, targetEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipViewRow#equals(Object)}, and {@link
   * ImmutableLegalEntityRelationshipViewRow#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLegalEntityRelationshipViewRow#equals(Object)}
   *   <li>{@link ImmutableLegalEntityRelationshipViewRow#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipViewRow.equals(Object)",
    "int ImmutableLegalEntityRelationshipViewRow.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    ImmutableLegalEntityRelationship.Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    ImmutableLegalEntityRelationship.Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationshipViewRow immutableLegalEntityRelationshipViewRow =
        builderResult
            .relationship(
                relationshipKindIdResult
                    .targetEntityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .build())
            .build();

    Builder builderResult2 = ImmutableLegalEntityRelationshipViewRow.builder();

    ImmutableLegalEntityRelationship.Builder lastUpdatedByResult2 =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    ImmutableLegalEntityRelationship.Builder relationshipKindIdResult2 =
        lastUpdatedByResult2
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationshipViewRow immutableLegalEntityRelationshipViewRow2 =
        builderResult2
            .relationship(
                relationshipKindIdResult2
                    .targetEntityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableLegalEntityRelationshipViewRow, immutableLegalEntityRelationshipViewRow2);
    assertEquals(
        immutableLegalEntityRelationshipViewRow.hashCode(),
        immutableLegalEntityRelationshipViewRow2.hashCode());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipViewRow#equals(Object)}, and {@link
   * ImmutableLegalEntityRelationshipViewRow#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLegalEntityRelationshipViewRow#equals(Object)}
   *   <li>{@link ImmutableLegalEntityRelationshipViewRow#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipViewRow.equals(Object)",
    "int ImmutableLegalEntityRelationshipViewRow.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    ImmutableLegalEntityRelationship.Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    ImmutableLegalEntityRelationship.Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationshipViewRow immutableLegalEntityRelationshipViewRow =
        builderResult
            .relationship(
                relationshipKindIdResult
                    .targetEntityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableLegalEntityRelationshipViewRow, immutableLegalEntityRelationshipViewRow);
    int expectedHashCodeResult = immutableLegalEntityRelationshipViewRow.hashCode();
    assertEquals(expectedHashCodeResult, immutableLegalEntityRelationshipViewRow.hashCode());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipViewRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipViewRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipViewRow.equals(Object)",
    "int ImmutableLegalEntityRelationshipViewRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();
    builderResult.addAssessments(
        ImmutableLegalEntityRelationshipViewAssessment.builder()
            .assessmentDefinitionId(1L)
            .build());

    ImmutableLegalEntityRelationship.Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    ImmutableLegalEntityRelationship.Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationshipViewRow immutableLegalEntityRelationshipViewRow =
        builderResult
            .relationship(
                relationshipKindIdResult
                    .targetEntityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .build())
            .build();

    Builder builderResult2 = ImmutableLegalEntityRelationshipViewRow.builder();

    ImmutableLegalEntityRelationship.Builder lastUpdatedByResult2 =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    ImmutableLegalEntityRelationship.Builder relationshipKindIdResult2 =
        lastUpdatedByResult2
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationshipViewRow,
        builderResult2
            .relationship(
                relationshipKindIdResult2
                    .targetEntityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipViewRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipViewRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipViewRow.equals(Object)",
    "int ImmutableLegalEntityRelationshipViewRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    ImmutableLegalEntityRelationship.Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("Provenance")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    ImmutableLegalEntityRelationship.Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationshipViewRow immutableLegalEntityRelationshipViewRow =
        builderResult
            .relationship(
                relationshipKindIdResult
                    .targetEntityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .build())
            .build();

    Builder builderResult2 = ImmutableLegalEntityRelationshipViewRow.builder();

    ImmutableLegalEntityRelationship.Builder lastUpdatedByResult2 =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    ImmutableLegalEntityRelationship.Builder relationshipKindIdResult2 =
        lastUpdatedByResult2
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationshipViewRow,
        builderResult2
            .relationship(
                relationshipKindIdResult2
                    .targetEntityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipViewRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipViewRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipViewRow.equals(Object)",
    "int ImmutableLegalEntityRelationshipViewRow.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    ImmutableLegalEntityRelationship.Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    ImmutableLegalEntityRelationship.Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act and Assert
    assertNotEquals(
        builderResult
            .relationship(
                relationshipKindIdResult
                    .targetEntityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipViewRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipViewRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipViewRow.equals(Object)",
    "int ImmutableLegalEntityRelationshipViewRow.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    ImmutableLegalEntityRelationship.Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    ImmutableLegalEntityRelationship.Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act and Assert
    assertNotEquals(
        builderResult
            .relationship(
                relationshipKindIdResult
                    .targetEntityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .build())
            .build(),
        "Different type to ImmutableLegalEntityRelationshipViewRow");
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipViewRow#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) Assessments is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipViewRow#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) Assessments is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipViewRow ImmutableLegalEntityRelationshipViewRow.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonAssessmentsIsHashSet() {
    // Arrange
    Json json = new Json();
    ImmutableLegalEntityRelationship.Json relationship =
        new ImmutableLegalEntityRelationship.Json();
    json.setRelationship(relationship);
    json.setAssessments(new HashSet<>());

    // Act
    ImmutableLegalEntityRelationshipViewRow actualFromJsonResult =
        ImmutableLegalEntityRelationshipViewRow.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.assessments().isEmpty());
    assertSame(relationship, actualFromJsonResult.relationship());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipViewRow#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link
   *       ImmutableLegalEntityRelationshipViewAssessment.Json} (default constructor).
   *   <li>Then return assessments size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipViewRow#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return assessments size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipViewRow ImmutableLegalEntityRelationshipViewRow.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddJson_thenReturnAssessmentsSizeIsOne() {
    // Arrange
    LinkedHashSet<LegalEntityRelationshipViewAssessment> assessments = new LinkedHashSet<>();
    assessments.add(new ImmutableLegalEntityRelationshipViewAssessment.Json());

    Json json = new Json();
    ImmutableLegalEntityRelationship.Json relationship =
        new ImmutableLegalEntityRelationship.Json();
    json.setRelationship(relationship);
    json.setAssessments(assessments);

    // Act
    ImmutableLegalEntityRelationshipViewRow actualFromJsonResult =
        ImmutableLegalEntityRelationshipViewRow.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.assessments().size());
    assertSame(relationship, actualFromJsonResult.relationship());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipViewRow#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Assessments is {@code null}.
   *   <li>Then return assessments Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipViewRow#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Assessments is 'null'; then return assessments Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipViewRow ImmutableLegalEntityRelationshipViewRow.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonAssessmentsIsNull_thenReturnAssessmentsEmpty() {
    // Arrange
    Json json = new Json();
    ImmutableLegalEntityRelationship.Json relationship =
        new ImmutableLegalEntityRelationship.Json();
    json.setRelationship(relationship);
    json.setAssessments(null);

    // Act
    ImmutableLegalEntityRelationshipViewRow actualFromJsonResult =
        ImmutableLegalEntityRelationshipViewRow.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.assessments().isEmpty());
    assertSame(relationship, actualFromJsonResult.relationship());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipViewRow#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessments is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipViewRow#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessments is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipViewRow ImmutableLegalEntityRelationshipViewRow.fromJson(Json)"
  })
  void testFromJson_thenReturnAssessmentsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<LegalEntityRelationshipViewAssessment> assessments = new LinkedHashSet<>();
    assessments.add(
        ImmutableLegalEntityRelationshipViewAssessment.builder()
            .assessmentDefinitionId(1L)
            .build());
    assessments.add(new ImmutableLegalEntityRelationshipViewAssessment.Json());

    Json json = new Json();
    ImmutableLegalEntityRelationship.Json relationship =
        new ImmutableLegalEntityRelationship.Json();
    json.setRelationship(relationship);
    json.setAssessments(assessments);

    // Act
    ImmutableLegalEntityRelationshipViewRow actualFromJsonResult =
        ImmutableLegalEntityRelationshipViewRow.fromJson(json);

    // Assert
    assertEquals(assessments, actualFromJsonResult.assessments());
    assertSame(relationship, actualFromJsonResult.relationship());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLegalEntityRelationshipViewRow#toString()}
   *   <li>{@link ImmutableLegalEntityRelationshipViewRow#assessments()}
   *   <li>{@link ImmutableLegalEntityRelationshipViewRow#relationship()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableLegalEntityRelationshipViewRow.assessments()",
    "LegalEntityRelationship ImmutableLegalEntityRelationshipViewRow.relationship()",
    "String ImmutableLegalEntityRelationshipViewRow.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    ImmutableLegalEntityRelationship.Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    ImmutableLegalEntityRelationship.Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationshipViewRow immutableLegalEntityRelationshipViewRow =
        builderResult
            .relationship(
                relationshipKindIdResult
                    .targetEntityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableLegalEntityRelationshipViewRow.toString();
    Set<LegalEntityRelationshipViewAssessment> actualAssessmentsResult =
        immutableLegalEntityRelationshipViewRow.assessments();

    // Assert
    assertTrue(
        immutableLegalEntityRelationshipViewRow.relationship()
            instanceof ImmutableLegalEntityRelationship);
    assertEquals(
        "LegalEntityRelationshipViewRow{relationship=LegalEntityRelationship{id=1, provenance=Provenance,"
            + " lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, externalId=42, isReadOnly=false,"
            + " legalEntityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, relationshipKindId=1,"
            + " targetEntityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, kind=ALL},"
            + " assessments=[]}",
        actualToStringResult);
    assertTrue(actualAssessmentsResult.isEmpty());
  }

  /**
   * Test Json {@link Json#assessments()}.
   *
   * <p>Method under test: {@link Json#assessments()}
   */
  @Test
  @DisplayName("Test Json assessments()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.assessments()"})
  void testJsonAssessments() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().assessments());
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
    assertNull(actualJson.relationship);
    assertTrue(actualJson.assessments.isEmpty());
  }

  /**
   * Test Json {@link Json#relationship()}.
   *
   * <p>Method under test: {@link Json#relationship()}
   */
  @Test
  @DisplayName("Test Json relationship()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LegalEntityRelationship Json.relationship()"})
  void testJsonRelationship() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().relationship());
  }

  /**
   * Test {@link
   * ImmutableLegalEntityRelationshipViewRow#withAssessments(LegalEntityRelationshipViewAssessment[])}
   * with {@code LegalEntityRelationshipViewAssessment[]}.
   *
   * <p>Method under test: {@link
   * ImmutableLegalEntityRelationshipViewRow#withAssessments(LegalEntityRelationshipViewAssessment[])}
   */
  @Test
  @DisplayName(
      "Test withAssessments(LegalEntityRelationshipViewAssessment[]) with 'LegalEntityRelationshipViewAssessment[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipViewRow ImmutableLegalEntityRelationshipViewRow.withAssessments(LegalEntityRelationshipViewAssessment[])"
  })
  void testWithAssessmentsWithLegalEntityRelationshipViewAssessment() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    ImmutableLegalEntityRelationship.Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    ImmutableLegalEntityRelationship.Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationshipViewRow immutableLegalEntityRelationshipViewRow =
        builderResult
            .relationship(
                relationshipKindIdResult
                    .targetEntityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .build())
            .build();

    // Act
    ImmutableLegalEntityRelationshipViewRow actualWithAssessmentsResult =
        immutableLegalEntityRelationshipViewRow.withAssessments(
            ImmutableLegalEntityRelationshipViewAssessment.builder()
                .assessmentDefinitionId(1L)
                .build());

    // Assert
    LegalEntityRelationship relationshipResult = actualWithAssessmentsResult.relationship();
    EntityReference legalEntityReferenceResult = relationshipResult.legalEntityReference();
    assertTrue(legalEntityReferenceResult instanceof ImmutableEntityReference);
    EntityReference targetEntityReferenceResult = relationshipResult.targetEntityReference();
    assertTrue(targetEntityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(relationshipResult instanceof ImmutableLegalEntityRelationship);
    assertEquals("2020-03-01", relationshipResult.lastUpdatedBy());
    assertEquals("Provenance", relationshipResult.provenance());
    assertEquals("The characteristics of someone or something", relationshipResult.description());
    assertEquals(1, actualWithAssessmentsResult.assessments().size());
    assertEquals(1L, relationshipResult.relationshipKindId().longValue());
    assertEquals(EntityKind.ALL, relationshipResult.kind());
    assertFalse(relationshipResult.isReadOnly());
    assertEquals(legalEntityReferenceResult, targetEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipViewRow#withRelationship(LegalEntityRelationship)}.
   *
   * <p>Method under test: {@link
   * ImmutableLegalEntityRelationshipViewRow#withRelationship(LegalEntityRelationship)}
   */
  @Test
  @DisplayName("Test withRelationship(LegalEntityRelationship)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipViewRow ImmutableLegalEntityRelationshipViewRow.withRelationship(LegalEntityRelationship)"
  })
  void testWithRelationship() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewRow.builder();

    ImmutableLegalEntityRelationship.Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    ImmutableLegalEntityRelationship.Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationshipViewRow immutableLegalEntityRelationshipViewRow =
        builderResult
            .relationship(
                relationshipKindIdResult
                    .targetEntityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .build())
            .build();

    ImmutableLegalEntityRelationship.Builder lastUpdatedByResult2 =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    ImmutableLegalEntityRelationship.Builder relationshipKindIdResult2 =
        lastUpdatedByResult2
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act
    ImmutableLegalEntityRelationshipViewRow actualWithRelationshipResult =
        immutableLegalEntityRelationshipViewRow.withRelationship(
            relationshipKindIdResult2
                .targetEntityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    // Assert
    assertEquals(immutableLegalEntityRelationshipViewRow, actualWithRelationshipResult);
  }
}
