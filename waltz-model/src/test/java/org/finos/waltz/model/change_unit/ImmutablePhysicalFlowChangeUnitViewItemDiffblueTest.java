package org.finos.waltz.model.change_unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition;
import org.finos.waltz.model.assessment_rating.AssessmentRatingDetail;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRating;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRatingDetail;
import org.finos.waltz.model.change_unit.ImmutablePhysicalFlowChangeUnitViewItem.Builder;
import org.finos.waltz.model.change_unit.ImmutablePhysicalFlowChangeUnitViewItem.Json;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlow;
import org.finos.waltz.model.logical_flow.LogicalFlow;
import org.finos.waltz.model.physical_specification.DataFormatKindValue;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecification;
import org.finos.waltz.model.physical_specification.PhysicalSpecification;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowChangeUnitViewItemDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAssessments(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllAssessments(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAssessments(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllAssessments(Iterable)"})
  void testBuilderAddAllAssessments_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    // Act
    Builder actualAddAllAssessmentsResult = builderResult.addAllAssessments(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAssessmentsResult);
  }

  /**
   * Test Builder {@link Builder#addAssessments(AssessmentRatingDetail)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addAssessments(AssessmentRatingDetail)}
   */
  @Test
  @DisplayName("Test Builder addAssessments(AssessmentRatingDetail) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAssessments(AssessmentRatingDetail)"})
  void testBuilderAddAssessmentsWithElement() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    // Act
    Builder actualAddAssessmentsResult =
        builderResult.addAssessments(mock(AssessmentRatingDetail.class));

    // Assert
    assertSame(builderResult, actualAddAssessmentsResult);
  }

  /**
   * Test Builder {@link Builder#addAssessments(AssessmentRatingDetail[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addAssessments(AssessmentRatingDetail[])}
   */
  @Test
  @DisplayName("Test Builder addAssessments(AssessmentRatingDetail[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAssessments(AssessmentRatingDetail[])"})
  void testBuilderAddAssessmentsWithElements() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    // Act
    Builder actualAddAssessmentsResult =
        builderResult.addAssessments(mock(AssessmentRatingDetail.class));

    // Assert
    assertSame(builderResult, actualAddAssessmentsResult);
  }

  /**
   * Test Builder {@link Builder#assessments(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#assessments(Iterable)}
   */
  @Test
  @DisplayName("Test Builder assessments(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.assessments(Iterable)"})
  void testBuilderAssessments_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    // Act
    Builder actualAssessmentsResult = builderResult.assessments(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAssessmentsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#physicalSpecification(PhysicalSpecification)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowChangeUnitViewItem Builder.build()",
    "Builder Builder.physicalSpecification(PhysicalSpecification)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();
    ImmutableChangeUnit.Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit changeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();
    Builder actualChangeUnitResult = actualBuilderResult.changeUnit(changeUnit);
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableLogicalFlow.Builder provenanceResult2 =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableLogicalFlow logicalFlow =
        sourceResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();
    Builder actualLogicalFlowResult = actualChangeUnitResult.logicalFlow(logicalFlow);
    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);
    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");
    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalSpecification immutablePhysicalSpecification =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();
    Optional<? extends PhysicalSpecification> physicalSpecification =
        Optional.of(immutablePhysicalSpecification);
    Builder actualPhysicalSpecificationResult =
        actualLogicalFlowResult.physicalSpecification(physicalSpecification);
    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp3 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created3 = Optional.of(immutableUserTimestamp3);
    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult3
            .created(created3)
            .description("The characteristics of someone or something")
            .externalId("42");
    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowChangeUnitViewItem actualImmutablePhysicalFlowChangeUnitViewItem =
        actualPhysicalSpecificationResult
            .physicalSpecification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build();

    // Assert
    assertTrue(actualImmutablePhysicalFlowChangeUnitViewItem.assessments().isEmpty());
    assertSame(changeUnit, actualImmutablePhysicalFlowChangeUnitViewItem.changeUnit());
    assertSame(logicalFlow, actualImmutablePhysicalFlowChangeUnitViewItem.logicalFlow());
  }

  /**
   * Test Builder {@link Builder#changeUnit(ChangeUnit)}.
   *
   * <p>Method under test: {@link Builder#changeUnit(ChangeUnit)}
   */
  @Test
  @DisplayName("Test Builder changeUnit(ChangeUnit)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.changeUnit(ChangeUnit)"})
  void testBuilderChangeUnit() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    // Act
    Builder actualChangeUnitResult = builderResult.changeUnit(new ImmutableChangeUnit.Json());

    // Assert
    assertSame(builderResult, actualChangeUnitResult);
  }

  /**
   * Test Builder {@link Builder#logicalFlow(LogicalFlow)}.
   *
   * <p>Method under test: {@link Builder#logicalFlow(LogicalFlow)}
   */
  @Test
  @DisplayName("Test Builder logicalFlow(LogicalFlow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.logicalFlow(LogicalFlow)"})
  void testBuilderLogicalFlow() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    // Act
    Builder actualLogicalFlowResult = builderResult.logicalFlow(mock(LogicalFlow.class));

    // Assert
    assertSame(builderResult, actualLogicalFlowResult);
  }

  /**
   * Test Builder {@link Builder#physicalSpecification(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#physicalSpecification(Optional)}
   */
  @Test
  @DisplayName("Test Builder physicalSpecification(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.physicalSpecification(Optional)"})
  void testBuilderPhysicalSpecificationWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalSpecification immutablePhysicalSpecification =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();
    Optional<? extends PhysicalSpecification> physicalSpecification =
        Optional.of(immutablePhysicalSpecification);

    // Act
    Builder actualPhysicalSpecificationResult =
        builderResult.physicalSpecification(physicalSpecification);

    // Assert
    assertSame(builderResult, actualPhysicalSpecificationResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowChangeUnitViewItem#copyOf(PhysicalFlowChangeUnitViewItem)}.
   *
   * <ul>
   *   <li>Then changeUnit subjectEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowChangeUnitViewItem#copyOf(PhysicalFlowChangeUnitViewItem)}
   */
  @Test
  @DisplayName(
      "Test copyOf(PhysicalFlowChangeUnitViewItem); then changeUnit subjectEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowChangeUnitViewItem ImmutablePhysicalFlowChangeUnitViewItem.copyOf(PhysicalFlowChangeUnitViewItem)"
  })
  void testCopyOf_thenChangeUnitSubjectEntityReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    ImmutableChangeUnit.Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    Builder changeUnitResult =
        builderResult.changeUnit(
            provenanceResult
                .subjectEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
                .build());

    ImmutableLogicalFlow.Builder builderResult2 = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult2 =
        builderResult2
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder logicalFlowResult =
        changeUnitResult.logicalFlow(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult3
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalSpecification immutablePhysicalSpecification =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();
    Optional<? extends PhysicalSpecification> physicalSpecification =
        Optional.of(immutablePhysicalSpecification);
    ImmutablePhysicalFlowChangeUnitViewItem instance =
        logicalFlowResult.physicalSpecification(physicalSpecification).build();

    // Act
    ImmutablePhysicalFlowChangeUnitViewItem actualCopyOfResult =
        ImmutablePhysicalFlowChangeUnitViewItem.copyOf(instance);

    // Assert
    ChangeUnit changeUnitResult2 = actualCopyOfResult.changeUnit();
    EntityReference subjectEntityResult = changeUnitResult2.subjectEntity();
    assertTrue(subjectEntityResult instanceof ImmutableEntityReference);
    LogicalFlow logicalFlowResult2 = actualCopyOfResult.logicalFlow();
    EntityReference sourceResult2 = logicalFlowResult2.source();
    assertTrue(sourceResult2 instanceof ImmutableEntityReference);
    EntityReference targetResult = logicalFlowResult2.target();
    assertTrue(targetResult instanceof ImmutableEntityReference);
    assertTrue(changeUnitResult2 instanceof ImmutableChangeUnit);
    assertTrue(logicalFlowResult2 instanceof ImmutableLogicalFlow);
    assertEquals("2020-03-01", changeUnitResult2.lastUpdatedBy());
    assertEquals("2020-03-01", logicalFlowResult2.lastUpdatedBy());
    assertEquals("Name", changeUnitResult2.name());
    assertEquals("Provenance", changeUnitResult2.provenance());
    assertEquals("Provenance", logicalFlowResult2.provenance());
    assertEquals("The characteristics of someone or something", changeUnitResult2.description());
    assertEquals(EntityKind.ALL, changeUnitResult2.kind());
    assertEquals(EntityKind.ALL, logicalFlowResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, logicalFlowResult2.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, changeUnitResult2.subjectInitialStatus());
    assertEquals(ChangeAction.ACTIVATE, changeUnitResult2.action());
    assertEquals(ExecutionStatus.PENDING, changeUnitResult2.executionStatus());
    assertFalse(logicalFlowResult2.isReadOnly());
    assertFalse(logicalFlowResult2.isRemoved());
    assertTrue(actualCopyOfResult.assessments().isEmpty());
    assertEquals(subjectEntityResult, sourceResult2);
    assertEquals(subjectEntityResult, targetResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowChangeUnitViewItem#equals(Object)}, and {@link
   * ImmutablePhysicalFlowChangeUnitViewItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowChangeUnitViewItem#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlowChangeUnitViewItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowChangeUnitViewItem.equals(Object)",
    "int ImmutablePhysicalFlowChangeUnitViewItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    ImmutableChangeUnit.Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    Builder changeUnitResult =
        builderResult.changeUnit(
            provenanceResult
                .subjectEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
                .build());

    ImmutableLogicalFlow.Builder builderResult2 = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult2 =
        builderResult2
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder logicalFlowResult =
        changeUnitResult.logicalFlow(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult3
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalSpecification immutablePhysicalSpecification =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();
    Optional<? extends PhysicalSpecification> physicalSpecification =
        Optional.of(immutablePhysicalSpecification);
    ImmutablePhysicalFlowChangeUnitViewItem immutablePhysicalFlowChangeUnitViewItem =
        logicalFlowResult.physicalSpecification(physicalSpecification).build();

    Builder builderResult4 = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    ImmutableChangeUnit.Builder provenanceResult3 =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    Builder changeUnitResult2 =
        builderResult4.changeUnit(
            provenanceResult3
                .subjectEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
                .build());

    ImmutableLogicalFlow.Builder builderResult5 = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp3 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created3 = Optional.of(immutableUserTimestamp3);

    ImmutableLogicalFlow.Builder provenanceResult4 =
        builderResult5
            .created(created3)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult2 =
        provenanceResult4.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder logicalFlowResult2 =
        changeUnitResult2.logicalFlow(
            sourceResult2
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    ImmutablePhysicalSpecification.Builder builderResult6 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp4 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created4 = Optional.of(immutableUserTimestamp4);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult6
            .created(created4)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalSpecification immutablePhysicalSpecification2 =
        nameResult2
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();
    Optional<? extends PhysicalSpecification> physicalSpecification2 =
        Optional.of(immutablePhysicalSpecification2);
    ImmutablePhysicalFlowChangeUnitViewItem immutablePhysicalFlowChangeUnitViewItem2 =
        logicalFlowResult2.physicalSpecification(physicalSpecification2).build();

    // Act and Assert
    assertEquals(immutablePhysicalFlowChangeUnitViewItem, immutablePhysicalFlowChangeUnitViewItem2);
    assertEquals(
        immutablePhysicalFlowChangeUnitViewItem.hashCode(),
        immutablePhysicalFlowChangeUnitViewItem2.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlowChangeUnitViewItem#equals(Object)}, and {@link
   * ImmutablePhysicalFlowChangeUnitViewItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowChangeUnitViewItem#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlowChangeUnitViewItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowChangeUnitViewItem.equals(Object)",
    "int ImmutablePhysicalFlowChangeUnitViewItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    ImmutableChangeUnit.Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    Builder changeUnitResult =
        builderResult.changeUnit(
            provenanceResult
                .subjectEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
                .build());

    ImmutableLogicalFlow.Builder builderResult2 = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult2 =
        builderResult2
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder logicalFlowResult =
        changeUnitResult.logicalFlow(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult3
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalSpecification immutablePhysicalSpecification =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();
    Optional<? extends PhysicalSpecification> physicalSpecification =
        Optional.of(immutablePhysicalSpecification);
    ImmutablePhysicalFlowChangeUnitViewItem immutablePhysicalFlowChangeUnitViewItem =
        logicalFlowResult.physicalSpecification(physicalSpecification).build();

    // Act and Assert
    assertEquals(immutablePhysicalFlowChangeUnitViewItem, immutablePhysicalFlowChangeUnitViewItem);
    int expectedHashCodeResult = immutablePhysicalFlowChangeUnitViewItem.hashCode();
    assertEquals(expectedHashCodeResult, immutablePhysicalFlowChangeUnitViewItem.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlowChangeUnitViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowChangeUnitViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowChangeUnitViewItem.equals(Object)",
    "int ImmutablePhysicalFlowChangeUnitViewItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    ImmutableAssessmentRatingDetail.Builder builderResult2 =
        ImmutableAssessmentRatingDetail.builder();

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    Optional<? extends EntityReference> qualifierReference = Optional.empty();
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> assessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    ImmutableAssessmentRatingDetail.Builder assessmentDefinitionResult =
        builderResult2.assessmentDefinition(assessmentDefinition);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    ImmutableAssessmentRatingDetail.Builder assessmentRatingResult =
        assessmentDefinitionResult.assessmentRating(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());
    builderResult.addAssessments(
        assessmentRatingResult
            .ratingDefinition(
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

    ImmutableChangeUnit.Builder provenanceResult2 =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    Builder changeUnitResult =
        builderResult.changeUnit(
            provenanceResult2
                .subjectEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
                .build());

    ImmutableLogicalFlow.Builder builderResult3 = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult3 =
        builderResult3
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult3.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder logicalFlowResult =
        changeUnitResult.logicalFlow(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    ImmutablePhysicalSpecification.Builder builderResult4 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult4
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalSpecification immutablePhysicalSpecification =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();
    Optional<? extends PhysicalSpecification> physicalSpecification =
        Optional.of(immutablePhysicalSpecification);
    ImmutablePhysicalFlowChangeUnitViewItem immutablePhysicalFlowChangeUnitViewItem =
        logicalFlowResult.physicalSpecification(physicalSpecification).build();

    Builder builderResult5 = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    ImmutableChangeUnit.Builder provenanceResult4 =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    Builder changeUnitResult2 =
        builderResult5.changeUnit(
            provenanceResult4
                .subjectEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
                .build());

    ImmutableLogicalFlow.Builder builderResult6 = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp3 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created3 = Optional.of(immutableUserTimestamp3);

    ImmutableLogicalFlow.Builder provenanceResult5 =
        builderResult6
            .created(created3)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult2 =
        provenanceResult5.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder logicalFlowResult2 =
        changeUnitResult2.logicalFlow(
            sourceResult2
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    ImmutablePhysicalSpecification.Builder builderResult7 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp4 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created4 = Optional.of(immutableUserTimestamp4);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult7
            .created(created4)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalSpecification immutablePhysicalSpecification2 =
        nameResult2
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();
    Optional<? extends PhysicalSpecification> physicalSpecification2 =
        Optional.of(immutablePhysicalSpecification2);

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowChangeUnitViewItem,
        logicalFlowResult2.physicalSpecification(physicalSpecification2).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowChangeUnitViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowChangeUnitViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowChangeUnitViewItem.equals(Object)",
    "int ImmutablePhysicalFlowChangeUnitViewItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    ImmutableChangeUnit.Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.RETIRE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    Builder changeUnitResult =
        builderResult.changeUnit(
            provenanceResult
                .subjectEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
                .build());

    ImmutableLogicalFlow.Builder builderResult2 = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult2 =
        builderResult2
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder logicalFlowResult =
        changeUnitResult.logicalFlow(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult3
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalSpecification immutablePhysicalSpecification =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();
    Optional<? extends PhysicalSpecification> physicalSpecification =
        Optional.of(immutablePhysicalSpecification);
    ImmutablePhysicalFlowChangeUnitViewItem immutablePhysicalFlowChangeUnitViewItem =
        logicalFlowResult.physicalSpecification(physicalSpecification).build();

    Builder builderResult4 = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    ImmutableChangeUnit.Builder provenanceResult3 =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    Builder changeUnitResult2 =
        builderResult4.changeUnit(
            provenanceResult3
                .subjectEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
                .build());

    ImmutableLogicalFlow.Builder builderResult5 = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp3 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created3 = Optional.of(immutableUserTimestamp3);

    ImmutableLogicalFlow.Builder provenanceResult4 =
        builderResult5
            .created(created3)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult2 =
        provenanceResult4.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder logicalFlowResult2 =
        changeUnitResult2.logicalFlow(
            sourceResult2
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    ImmutablePhysicalSpecification.Builder builderResult6 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp4 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created4 = Optional.of(immutableUserTimestamp4);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult6
            .created(created4)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalSpecification immutablePhysicalSpecification2 =
        nameResult2
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();
    Optional<? extends PhysicalSpecification> physicalSpecification2 =
        Optional.of(immutablePhysicalSpecification2);

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowChangeUnitViewItem,
        logicalFlowResult2.physicalSpecification(physicalSpecification2).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowChangeUnitViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowChangeUnitViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowChangeUnitViewItem.equals(Object)",
    "int ImmutablePhysicalFlowChangeUnitViewItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    ImmutableChangeUnit.Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    Builder changeUnitResult =
        builderResult.changeUnit(
            provenanceResult
                .subjectEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
                .build());

    ImmutableLogicalFlow.Builder builderResult2 = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder().at(LocalDate.now().atStartOfDay()).by("By").build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult2 =
        builderResult2
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder logicalFlowResult =
        changeUnitResult.logicalFlow(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult3
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalSpecification immutablePhysicalSpecification =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();
    Optional<? extends PhysicalSpecification> physicalSpecification =
        Optional.of(immutablePhysicalSpecification);
    ImmutablePhysicalFlowChangeUnitViewItem immutablePhysicalFlowChangeUnitViewItem =
        logicalFlowResult.physicalSpecification(physicalSpecification).build();

    Builder builderResult4 = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    ImmutableChangeUnit.Builder provenanceResult3 =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    Builder changeUnitResult2 =
        builderResult4.changeUnit(
            provenanceResult3
                .subjectEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
                .build());

    ImmutableLogicalFlow.Builder builderResult5 = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp3 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created3 = Optional.of(immutableUserTimestamp3);

    ImmutableLogicalFlow.Builder provenanceResult4 =
        builderResult5
            .created(created3)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult2 =
        provenanceResult4.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder logicalFlowResult2 =
        changeUnitResult2.logicalFlow(
            sourceResult2
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    ImmutablePhysicalSpecification.Builder builderResult6 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp4 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created4 = Optional.of(immutableUserTimestamp4);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult6
            .created(created4)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalSpecification immutablePhysicalSpecification2 =
        nameResult2
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();
    Optional<? extends PhysicalSpecification> physicalSpecification2 =
        Optional.of(immutablePhysicalSpecification2);

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowChangeUnitViewItem,
        logicalFlowResult2.physicalSpecification(physicalSpecification2).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowChangeUnitViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowChangeUnitViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowChangeUnitViewItem.equals(Object)",
    "int ImmutablePhysicalFlowChangeUnitViewItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    ImmutableChangeUnit.Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    Builder changeUnitResult =
        builderResult.changeUnit(
            provenanceResult
                .subjectEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
                .build());

    ImmutableLogicalFlow.Builder builderResult2 = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult2 =
        builderResult2
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder logicalFlowResult =
        changeUnitResult.logicalFlow(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder().at(LocalDate.now().atStartOfDay()).by("By").build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult3
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalSpecification immutablePhysicalSpecification =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();
    Optional<? extends PhysicalSpecification> physicalSpecification =
        Optional.of(immutablePhysicalSpecification);
    ImmutablePhysicalFlowChangeUnitViewItem immutablePhysicalFlowChangeUnitViewItem =
        logicalFlowResult.physicalSpecification(physicalSpecification).build();

    Builder builderResult4 = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    ImmutableChangeUnit.Builder provenanceResult3 =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    Builder changeUnitResult2 =
        builderResult4.changeUnit(
            provenanceResult3
                .subjectEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
                .build());

    ImmutableLogicalFlow.Builder builderResult5 = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp3 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created3 = Optional.of(immutableUserTimestamp3);

    ImmutableLogicalFlow.Builder provenanceResult4 =
        builderResult5
            .created(created3)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult2 =
        provenanceResult4.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder logicalFlowResult2 =
        changeUnitResult2.logicalFlow(
            sourceResult2
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    ImmutablePhysicalSpecification.Builder builderResult6 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp4 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created4 = Optional.of(immutableUserTimestamp4);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult6
            .created(created4)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalSpecification immutablePhysicalSpecification2 =
        nameResult2
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();
    Optional<? extends PhysicalSpecification> physicalSpecification2 =
        Optional.of(immutablePhysicalSpecification2);

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowChangeUnitViewItem,
        logicalFlowResult2.physicalSpecification(physicalSpecification2).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowChangeUnitViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowChangeUnitViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowChangeUnitViewItem.equals(Object)",
    "int ImmutablePhysicalFlowChangeUnitViewItem.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    ImmutableChangeUnit.Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    Builder changeUnitResult =
        builderResult.changeUnit(
            provenanceResult
                .subjectEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
                .build());

    ImmutableLogicalFlow.Builder builderResult2 = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult2 =
        builderResult2
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder logicalFlowResult =
        changeUnitResult.logicalFlow(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult3
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalSpecification immutablePhysicalSpecification =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();
    Optional<? extends PhysicalSpecification> physicalSpecification =
        Optional.of(immutablePhysicalSpecification);

    // Act and Assert
    assertNotEquals(logicalFlowResult.physicalSpecification(physicalSpecification).build(), null);
  }

  /**
   * Test {@link ImmutablePhysicalFlowChangeUnitViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowChangeUnitViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowChangeUnitViewItem.equals(Object)",
    "int ImmutablePhysicalFlowChangeUnitViewItem.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    ImmutableChangeUnit.Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    Builder changeUnitResult =
        builderResult.changeUnit(
            provenanceResult
                .subjectEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
                .build());

    ImmutableLogicalFlow.Builder builderResult2 = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult2 =
        builderResult2
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder logicalFlowResult =
        changeUnitResult.logicalFlow(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult3
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalSpecification immutablePhysicalSpecification =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();
    Optional<? extends PhysicalSpecification> physicalSpecification =
        Optional.of(immutablePhysicalSpecification);

    // Act and Assert
    assertNotEquals(
        logicalFlowResult.physicalSpecification(physicalSpecification).build(),
        "Different type to ImmutablePhysicalFlowChangeUnitViewItem");
  }

  /**
   * Test {@link ImmutablePhysicalFlowChangeUnitViewItem#fromJson(Json)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowChangeUnitViewItem#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowChangeUnitViewItem ImmutablePhysicalFlowChangeUnitViewItem.fromJson(Json)"
  })
  void testFromJson() {
    // Arrange
    Json json = new Json();

    ImmutableChangeUnit.Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    json.setChangeUnit(
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build());
    json.setAssessments(null);

    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalSpecification immutablePhysicalSpecification =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();
    Optional<PhysicalSpecification> physicalSpecification =
        Optional.of(immutablePhysicalSpecification);
    json.setPhysicalSpecification(physicalSpecification);

    ImmutableLogicalFlow.Builder builderResult2 = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutableLogicalFlow.Builder provenanceResult2 =
        builderResult2
            .created(created2)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    json.setLogicalFlow(
        sourceResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    // Act
    ImmutablePhysicalFlowChangeUnitViewItem actualFromJsonResult =
        ImmutablePhysicalFlowChangeUnitViewItem.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.assessments().isEmpty());
    ChangeUnit expectedChangeUnitResult = json.changeUnit;
    assertSame(expectedChangeUnitResult, actualFromJsonResult.changeUnit());
    LogicalFlow expectedLogicalFlowResult = json.logicalFlow;
    assertSame(expectedLogicalFlowResult, actualFromJsonResult.logicalFlow());
  }

  /**
   * Test {@link ImmutablePhysicalFlowChangeUnitViewItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) Assessments is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowChangeUnitViewItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) Assessments is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowChangeUnitViewItem ImmutablePhysicalFlowChangeUnitViewItem.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonAssessmentsIsHashSet() {
    // Arrange
    Json json = new Json();

    ImmutableChangeUnit.Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    json.setChangeUnit(
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build());
    json.setAssessments(new HashSet<>());
    json.setPhysicalSpecification(null);

    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult2 =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    json.setLogicalFlow(
        sourceResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    // Act
    ImmutablePhysicalFlowChangeUnitViewItem actualFromJsonResult =
        ImmutablePhysicalFlowChangeUnitViewItem.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.assessments().isEmpty());
    ChangeUnit expectedChangeUnitResult = json.changeUnit;
    assertSame(expectedChangeUnitResult, actualFromJsonResult.changeUnit());
    LogicalFlow expectedLogicalFlowResult = json.logicalFlow;
    assertSame(expectedLogicalFlowResult, actualFromJsonResult.logicalFlow());
  }

  /**
   * Test {@link ImmutablePhysicalFlowChangeUnitViewItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return assessments Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowChangeUnitViewItem#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessments Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowChangeUnitViewItem ImmutablePhysicalFlowChangeUnitViewItem.fromJson(Json)"
  })
  void testFromJson_thenReturnAssessmentsEmpty() {
    // Arrange
    Json json = new Json();

    ImmutableChangeUnit.Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    json.setChangeUnit(
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build());
    json.setAssessments(null);
    json.setPhysicalSpecification(null);

    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult2 =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    json.setLogicalFlow(
        sourceResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    // Act
    ImmutablePhysicalFlowChangeUnitViewItem actualFromJsonResult =
        ImmutablePhysicalFlowChangeUnitViewItem.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.assessments().isEmpty());
    ChangeUnit expectedChangeUnitResult = json.changeUnit;
    assertSame(expectedChangeUnitResult, actualFromJsonResult.changeUnit());
    LogicalFlow expectedLogicalFlowResult = json.logicalFlow;
    assertSame(expectedLogicalFlowResult, actualFromJsonResult.logicalFlow());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowChangeUnitViewItem#assessments()}
   *   <li>{@link ImmutablePhysicalFlowChangeUnitViewItem#changeUnit()}
   *   <li>{@link ImmutablePhysicalFlowChangeUnitViewItem#logicalFlow()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutablePhysicalFlowChangeUnitViewItem.assessments()",
    "ChangeUnit ImmutablePhysicalFlowChangeUnitViewItem.changeUnit()",
    "LogicalFlow ImmutablePhysicalFlowChangeUnitViewItem.logicalFlow()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    ImmutableChangeUnit.Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    Builder changeUnitResult =
        builderResult.changeUnit(
            provenanceResult
                .subjectEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
                .build());

    ImmutableLogicalFlow.Builder builderResult2 = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult2 =
        builderResult2
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder logicalFlowResult =
        changeUnitResult.logicalFlow(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult3
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalSpecification immutablePhysicalSpecification =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();
    Optional<? extends PhysicalSpecification> physicalSpecification =
        Optional.of(immutablePhysicalSpecification);
    ImmutablePhysicalFlowChangeUnitViewItem immutablePhysicalFlowChangeUnitViewItem =
        logicalFlowResult.physicalSpecification(physicalSpecification).build();

    // Act
    Set<AssessmentRatingDetail> actualAssessmentsResult =
        immutablePhysicalFlowChangeUnitViewItem.assessments();
    ChangeUnit actualChangeUnitResult = immutablePhysicalFlowChangeUnitViewItem.changeUnit();

    // Assert
    assertTrue(actualChangeUnitResult instanceof ImmutableChangeUnit);
    assertTrue(
        immutablePhysicalFlowChangeUnitViewItem.logicalFlow() instanceof ImmutableLogicalFlow);
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
   * Test Json {@link Json#changeUnit()}.
   *
   * <p>Method under test: {@link Json#changeUnit()}
   */
  @Test
  @DisplayName("Test Json changeUnit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChangeUnit Json.changeUnit()"})
  void testJsonChangeUnit() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().changeUnit());
  }

  /**
   * Test Json {@link Json#logicalFlow()}.
   *
   * <p>Method under test: {@link Json#logicalFlow()}
   */
  @Test
  @DisplayName("Test Json logicalFlow()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlow Json.logicalFlow()"})
  void testJsonLogicalFlow() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().logicalFlow());
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
    assertNull(actualJson.changeUnit);
    assertNull(actualJson.logicalFlow);
    assertFalse(actualJson.physicalSpecification.isPresent());
    assertTrue(actualJson.assessments.isEmpty());
  }

  /**
   * Test Json {@link Json#physicalSpecification()}.
   *
   * <p>Method under test: {@link Json#physicalSpecification()}
   */
  @Test
  @DisplayName("Test Json physicalSpecification()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.physicalSpecification()"})
  void testJsonPhysicalSpecification() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().physicalSpecification());
  }
}
