package org.finos.waltz.data.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.aggregate_overlay_diagram.AggregateOverlayDiagramCallout;
import org.finos.waltz.model.aggregate_overlay_diagram.DiagramCalloutCreateCommand;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagramCallout;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableDiagramCalloutCreateCommand;
import org.finos.waltz.schema.tables.records.AggregateOverlayDiagramCalloutRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
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
class AggregateOverlayDiagramCalloutDaoDiffblueTest {
  @InjectMocks private AggregateOverlayDiagramCalloutDao aggregateOverlayDiagramCalloutDao;

  @Mock private DSLContext dSLContext;

  /**
   * Test {@link AggregateOverlayDiagramCalloutDao#findByDiagramInstanceId(Long)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramCalloutDao#findByDiagramInstanceId(Long)}
   */
  @Test
  @DisplayName("Test findByDiagramInstanceId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AggregateOverlayDiagramCalloutDao.findByDiagramInstanceId(Long)"})
  void testFindByDiagramInstanceId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<AggregateOverlayDiagramCallout> actualFindByDiagramInstanceIdResult =
        aggregateOverlayDiagramCalloutDao.findByDiagramInstanceId(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByDiagramInstanceIdResult.isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramCalloutDao#create(DiagramCalloutCreateCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link AggregateOverlayDiagramCalloutRecord#setCellExternalId(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramCalloutDao#create(DiagramCalloutCreateCommand)}
   */
  @Test
  @DisplayName("Test create(DiagramCalloutCreateCommand); then calls setCellExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AggregateOverlayDiagramCalloutDao.create(DiagramCalloutCreateCommand)"})
  void testCreate_thenCallsSetCellExternalId() throws DataAccessException {
    // Arrange
    AggregateOverlayDiagramCalloutRecord aggregateOverlayDiagramCalloutRecord =
        mock(AggregateOverlayDiagramCalloutRecord.class);
    doNothing().when(aggregateOverlayDiagramCalloutRecord).setCellExternalId(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramCalloutRecord).setContent(Mockito.<String>any());
    doNothing()
        .when(aggregateOverlayDiagramCalloutRecord)
        .setDiagramInstanceId(Mockito.<Long>any());
    doNothing().when(aggregateOverlayDiagramCalloutRecord).setEndColor(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramCalloutRecord).setStartColor(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramCalloutRecord).setTitle(Mockito.<String>any());

    InsertSetMoreStep<AggregateOverlayDiagramCalloutRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);

    InsertSetStep<AggregateOverlayDiagramCalloutRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<AggregateOverlayDiagramCalloutRecord>>any()))
        .thenReturn(insertSetStep);
    when(dSLContext.newRecord(Mockito.<Table<AggregateOverlayDiagramCalloutRecord>>any()))
        .thenReturn(aggregateOverlayDiagramCalloutRecord);

    // Act
    int actualCreateResult =
        aggregateOverlayDiagramCalloutDao.create(
            ImmutableDiagramCalloutCreateCommand.builder()
                .cellExternalId("42")
                .content("Not all who wander are lost")
                .endColor("End Color")
                .instanceId(1L)
                .startColor("Start Color")
                .title("Dr")
                .build());

    // Assert
    verify(aggregateOverlayDiagramCalloutRecord).setCellExternalId("42");
    verify(aggregateOverlayDiagramCalloutRecord).setContent("Not all who wander are lost");
    verify(aggregateOverlayDiagramCalloutRecord).setDiagramInstanceId(1L);
    verify(aggregateOverlayDiagramCalloutRecord).setEndColor("End Color");
    verify(aggregateOverlayDiagramCalloutRecord).setStartColor("Start Color");
    verify(aggregateOverlayDiagramCalloutRecord).setTitle("Dr");
    verify(dSLContext).insertInto(isA(Table.class));
    verify(dSLContext).newRecord(isA(Table.class));
    verify(insertSetStep).set(isA(Record.class));
    verify(insertSetMoreStep).execute();
    assertEquals(1, actualCreateResult);
  }

  /**
   * Test {@link AggregateOverlayDiagramCalloutDao#create(DiagramCalloutCreateCommand)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramCalloutDao#create(DiagramCalloutCreateCommand)}
   */
  @Test
  @DisplayName("Test create(DiagramCalloutCreateCommand); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AggregateOverlayDiagramCalloutDao.create(DiagramCalloutCreateCommand)"})
  void testCreate_thenReturnOne() throws DataAccessException {
    // Arrange
    InsertSetMoreStep<AggregateOverlayDiagramCalloutRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);

    InsertSetStep<AggregateOverlayDiagramCalloutRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<AggregateOverlayDiagramCalloutRecord>>any()))
        .thenReturn(insertSetStep);
    when(dSLContext.newRecord(Mockito.<Table<AggregateOverlayDiagramCalloutRecord>>any()))
        .thenReturn(new AggregateOverlayDiagramCalloutRecord());

    // Act
    int actualCreateResult =
        aggregateOverlayDiagramCalloutDao.create(
            ImmutableDiagramCalloutCreateCommand.builder()
                .cellExternalId("42")
                .content("Not all who wander are lost")
                .endColor("End Color")
                .instanceId(1L)
                .startColor("Start Color")
                .title("Dr")
                .build());

    // Assert
    verify(dSLContext).insertInto(isA(Table.class));
    verify(dSLContext).newRecord(isA(Table.class));
    verify(insertSetStep).set(isA(Record.class));
    verify(insertSetMoreStep).execute();
    assertEquals(1, actualCreateResult);
  }

  /**
   * Test {@link AggregateOverlayDiagramCalloutDao#update(AggregateOverlayDiagramCallout)}.
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramCalloutDao#update(AggregateOverlayDiagramCallout)}
   */
  @Test
  @DisplayName("Test update(AggregateOverlayDiagramCallout)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer AggregateOverlayDiagramCalloutDao.update(AggregateOverlayDiagramCallout)"
  })
  void testUpdate() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AggregateOverlayDiagramCalloutRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<AggregateOverlayDiagramCalloutRecord> updateSetMoreStep =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<AggregateOverlayDiagramCalloutRecord> updateSetMoreStep2 =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AggregateOverlayDiagramCalloutRecord> updateSetMoreStep3 =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<AggregateOverlayDiagramCalloutRecord> updateSetMoreStep4 =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetFirstStep<AggregateOverlayDiagramCalloutRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);
    when(dSLContext.update(Mockito.<Table<AggregateOverlayDiagramCalloutRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    Integer actualUpdateResult =
        aggregateOverlayDiagramCalloutDao.update(
            ImmutableAggregateOverlayDiagramCallout.builder()
                .cellExternalId("42")
                .content("Not all who wander are lost")
                .diagramInstanceId(1L)
                .endColor("End Color")
                .id(1L)
                .startColor("Start Color")
                .title("Dr")
                .build());

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateResult.intValue());
  }

  /**
   * Test {@link AggregateOverlayDiagramCalloutDao#update(AggregateOverlayDiagramCallout)}.
   *
   * <ul>
   *   <li>Given of one.
   *   <li>Then calls {@link AggregateOverlayDiagramCallout#id()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramCalloutDao#update(AggregateOverlayDiagramCallout)}
   */
  @Test
  @DisplayName("Test update(AggregateOverlayDiagramCallout); given of one; then calls id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer AggregateOverlayDiagramCalloutDao.update(AggregateOverlayDiagramCallout)"
  })
  void testUpdate_givenOfOne_thenCallsId() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AggregateOverlayDiagramCalloutRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<AggregateOverlayDiagramCalloutRecord> updateSetMoreStep =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<AggregateOverlayDiagramCalloutRecord> updateSetMoreStep2 =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AggregateOverlayDiagramCalloutRecord> updateSetMoreStep3 =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<AggregateOverlayDiagramCalloutRecord> updateSetMoreStep4 =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetFirstStep<AggregateOverlayDiagramCalloutRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);
    when(dSLContext.update(Mockito.<Table<AggregateOverlayDiagramCalloutRecord>>any()))
        .thenReturn(updateSetFirstStep);

    AggregateOverlayDiagramCallout callout = mock(AggregateOverlayDiagramCallout.class);
    when(callout.content()).thenReturn("Not all who wander are lost");
    when(callout.endColor()).thenReturn("End Color");
    when(callout.startColor()).thenReturn("Start Color");
    when(callout.title()).thenReturn("Dr");
    Optional<Long> ofResult = Optional.of(1L);
    when(callout.id()).thenReturn(ofResult);

    // Act
    Integer actualUpdateResult = aggregateOverlayDiagramCalloutDao.update(callout);

    // Assert
    verify(callout).id();
    verify(callout).content();
    verify(callout).endColor();
    verify(callout).startColor();
    verify(callout).title();
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateResult.intValue());
  }

  /**
   * Test {@link AggregateOverlayDiagramCalloutDao#delete(long)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramCalloutDao#delete(long)}
   */
  @Test
  @DisplayName("Test delete(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AggregateOverlayDiagramCalloutDao.delete(long)"})
  void testDelete() throws DataAccessException {
    // Arrange
    DeleteConditionStep<AggregateOverlayDiagramCalloutRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<AggregateOverlayDiagramCalloutRecord> deleteUsingStep =
        mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<AggregateOverlayDiagramCalloutRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    Integer actualDeleteResult = aggregateOverlayDiagramCalloutDao.delete(1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualDeleteResult.intValue());
  }
}
