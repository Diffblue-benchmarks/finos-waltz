package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.datatype_decorator.LogicalFlowDecoratorDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.datatype.DataTypeDecorator;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlow;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlow.Builder;
import org.finos.waltz.model.logical_flow.LogicalFlow;
import org.finos.waltz.schema.tables.records.LogicalFlowRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.Table;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LogicalFlowHelperDiffblueTest {
  @Mock private DSLContext dSLContext;

  @Mock private LogicalFlowDao logicalFlowDao;

  @Mock private LogicalFlowDecoratorDao logicalFlowDecoratorDao;

  @InjectMocks private LogicalFlowHelper logicalFlowHelper;

  /**
   * Test {@link LogicalFlowHelper#createLogicalFlow(EntityReference, EntityReference)}.
   *
   * <ul>
   *   <li>Then source return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowHelper#createLogicalFlow(EntityReference,
   * EntityReference)}
   */
  @Test
  @DisplayName(
      "Test createLogicalFlow(EntityReference, EntityReference); then source return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LogicalFlow LogicalFlowHelper.createLogicalFlow(EntityReference, EntityReference)"
  })
  void testCreateLogicalFlow_thenSourceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.addFlow(Mockito.<LogicalFlow>any()))
        .thenReturn(
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
    ImmutableEntityReference refA =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    LogicalFlow actualCreateLogicalFlowResult =
        logicalFlowHelper.createLogicalFlow(
            refA,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(logicalFlowDao).addFlow(isA(LogicalFlow.class));
    EntityReference sourceResult2 = actualCreateLogicalFlowResult.source();
    assertTrue(sourceResult2 instanceof ImmutableEntityReference);
    EntityReference targetResult = actualCreateLogicalFlowResult.target();
    assertTrue(targetResult instanceof ImmutableEntityReference);
    assertTrue(actualCreateLogicalFlowResult instanceof ImmutableLogicalFlow);
    LocalDateTime lastUpdatedAtResult = actualCreateLogicalFlowResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCreateLogicalFlowResult.lastUpdatedBy());
    assertEquals("Provenance", actualCreateLogicalFlowResult.provenance());
    assertEquals(EntityKind.ALL, actualCreateLogicalFlowResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualCreateLogicalFlowResult.entityLifecycleStatus());
    assertFalse(actualCreateLogicalFlowResult.isReadOnly());
    assertFalse(actualCreateLogicalFlowResult.isRemoved());
    assertEquals(refA, sourceResult2);
    assertEquals(refA, targetResult);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link LogicalFlowHelper#createLogicalFlowDecorators(EntityReference, Set)}.
   *
   * <p>Method under test: {@link LogicalFlowHelper#createLogicalFlowDecorators(EntityReference,
   * Set)}
   */
  @Test
  @DisplayName("Test createLogicalFlowDecorators(EntityReference, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogicalFlowHelper.createLogicalFlowDecorators(EntityReference, Set)"})
  void testCreateLogicalFlowDecorators() {
    // Arrange
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    ImmutableEntityReference flowRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    HashSet<Long> dtIds = new HashSet<>();
    dtIds.add(1L);

    // Act
    logicalFlowHelper.createLogicalFlowDecorators(flowRef, dtIds);

    // Assert
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
  }

  /**
   * Test {@link LogicalFlowHelper#createLogicalFlowDecorators(EntityReference, Set)}.
   *
   * <p>Method under test: {@link LogicalFlowHelper#createLogicalFlowDecorators(EntityReference,
   * Set)}
   */
  @Test
  @DisplayName("Test createLogicalFlowDecorators(EntityReference, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogicalFlowHelper.createLogicalFlowDecorators(EntityReference, Set)"})
  void testCreateLogicalFlowDecorators2() {
    // Arrange
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    ImmutableAppGroupEntry flowRef =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    HashSet<Long> dtIds = new HashSet<>();
    dtIds.add(1L);

    // Act
    logicalFlowHelper.createLogicalFlowDecorators(flowRef, dtIds);

    // Assert
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
  }

  /**
   * Test {@link LogicalFlowHelper#createLogicalFlowDecorators(EntityReference, Set)}.
   *
   * <ul>
   *   <li>Given minus three.
   *   <li>When {@link HashSet#HashSet()} add minus three.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowHelper#createLogicalFlowDecorators(EntityReference,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test createLogicalFlowDecorators(EntityReference, Set); given minus three; when HashSet() add minus three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogicalFlowHelper.createLogicalFlowDecorators(EntityReference, Set)"})
  void testCreateLogicalFlowDecorators_givenMinusThree_whenHashSetAddMinusThree() {
    // Arrange
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    ImmutableEntityReference flowRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    HashSet<Long> dtIds = new HashSet<>();
    dtIds.add(-3L);
    dtIds.add(1L);

    // Act
    logicalFlowHelper.createLogicalFlowDecorators(flowRef, dtIds);

    // Assert
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
  }

  /**
   * Test {@link LogicalFlowHelper#createLogicalFlowDecorators(EntityReference, Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then calls {@link LogicalFlowDecoratorDao#addDecorators(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowHelper#createLogicalFlowDecorators(EntityReference,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test createLogicalFlowDecorators(EntityReference, Set); when HashSet(); then calls addDecorators(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogicalFlowHelper.createLogicalFlowDecorators(EntityReference, Set)"})
  void testCreateLogicalFlowDecorators_whenHashSet_thenCallsAddDecorators() {
    // Arrange
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});

    // Act
    logicalFlowHelper.createLogicalFlowDecorators(null, new HashSet<>());

    // Assert
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
  }

  /**
   * Test {@link LogicalFlowHelper#fetchDecoratorsForFlow(Long)}.
   *
   * <p>Method under test: {@link LogicalFlowHelper#fetchDecoratorsForFlow(Long)}
   */
  @Test
  @DisplayName("Test fetchDecoratorsForFlow(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowHelper.fetchDecoratorsForFlow(Long)"})
  void testFetchDecoratorsForFlow() {
    // Arrange
    when(logicalFlowDecoratorDao.findByEntityId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    List<DataTypeDecorator> actualFetchDecoratorsForFlowResult =
        logicalFlowHelper.fetchDecoratorsForFlow(1L);

    // Assert
    verify(logicalFlowDecoratorDao).findByEntityId(1L);
    assertTrue(actualFetchDecoratorsForFlowResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowHelper#clearAllFlows()}.
   *
   * <p>Method under test: {@link LogicalFlowHelper#clearAllFlows()}
   */
  @Test
  @DisplayName("Test clearAllFlows()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogicalFlowHelper.clearAllFlows()"})
  void testClearAllFlows() throws DataAccessException {
    // Arrange
    DeleteUsingStep<LogicalFlowRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.execute()).thenReturn(1);
    when(dSLContext.deleteFrom(Mockito.<Table<LogicalFlowRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    logicalFlowHelper.clearAllFlows();

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).execute();
  }

  /**
   * Test {@link LogicalFlowHelper#removeFlow(Long)}.
   *
   * <p>Method under test: {@link LogicalFlowHelper#removeFlow(Long)}
   */
  @Test
  @DisplayName("Test removeFlow(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LogicalFlowHelper.removeFlow(Long)"})
  void testRemoveFlow() {
    // Arrange
    when(logicalFlowDao.removeFlow(Mockito.<Long>any(), Mockito.<String>any())).thenReturn(1);

    // Act
    int actualRemoveFlowResult = logicalFlowHelper.removeFlow(1L);

    // Assert
    verify(logicalFlowDao).removeFlow(1L, "admin");
    assertEquals(1, actualRemoveFlowResult);
  }

  /**
   * Test {@link LogicalFlowHelper#makeReadOnly(long)}.
   *
   * <p>Method under test: {@link LogicalFlowHelper#makeReadOnly(long)}
   */
  @Test
  @DisplayName("Test makeReadOnly(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LogicalFlowHelper.makeReadOnly(long)"})
  void testMakeReadOnly() throws DataAccessException {
    // Arrange
    UpdateConditionStep<LogicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<LogicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<LogicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    logicalFlowHelper.makeReadOnly(1L);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }
}
