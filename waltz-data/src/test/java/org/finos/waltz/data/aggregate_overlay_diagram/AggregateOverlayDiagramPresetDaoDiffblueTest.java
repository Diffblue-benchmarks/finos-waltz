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
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.aggregate_overlay_diagram.AggregateOverlayDiagramPreset;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableOverlayDiagramPresetCreateCommand;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramPresetCreateCommand;
import org.finos.waltz.schema.tables.records.AggregateOverlayDiagramPresetRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
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
import org.jooq.exception.DataAccessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AggregateOverlayDiagramPresetDaoDiffblueTest {
  /**
   * Test {@link AggregateOverlayDiagramPresetDao#findPresetsForDiagram(Long)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramPresetDao#findPresetsForDiagram(Long)}
   */
  @Test
  @DisplayName("Test findPresetsForDiagram(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AggregateOverlayDiagramPresetDao.findPresetsForDiagram(Long)"})
  void testFindPresetsForDiagram() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<AggregateOverlayDiagramPreset> actualFindPresetsForDiagramResult =
        new AggregateOverlayDiagramPresetDao(dsl).findPresetsForDiagram(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindPresetsForDiagramResult.isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramPresetDao#create(OverlayDiagramPresetCreateCommand,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link AggregateOverlayDiagramPresetRecord#setDescription(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramPresetDao#create(OverlayDiagramPresetCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test create(OverlayDiagramPresetCreateCommand, String); then calls setDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AggregateOverlayDiagramPresetDao.create(OverlayDiagramPresetCreateCommand, String)"
  })
  void testCreate_thenCallsSetDescription() throws DataAccessException {
    // Arrange
    AggregateOverlayDiagramPresetRecord aggregateOverlayDiagramPresetRecord =
        mock(AggregateOverlayDiagramPresetRecord.class);
    doNothing().when(aggregateOverlayDiagramPresetRecord).setDescription(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramPresetRecord).setDiagramId(Mockito.<Long>any());
    doNothing().when(aggregateOverlayDiagramPresetRecord).setExternalId(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramPresetRecord).setFilterConfig(Mockito.<String>any());
    doNothing()
        .when(aggregateOverlayDiagramPresetRecord)
        .setLastUpdatedAt(Mockito.<Timestamp>any());
    doNothing().when(aggregateOverlayDiagramPresetRecord).setLastUpdatedBy(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramPresetRecord).setName(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramPresetRecord).setOverlayConfig(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramPresetRecord).setProvenance(Mockito.<String>any());

    InsertSetMoreStep<AggregateOverlayDiagramPresetRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);

    InsertSetStep<AggregateOverlayDiagramPresetRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<AggregateOverlayDiagramPresetRecord>>any()))
        .thenReturn(insertSetStep);
    when(dsl.newRecord(Mockito.<Table<AggregateOverlayDiagramPresetRecord>>any()))
        .thenReturn(aggregateOverlayDiagramPresetRecord);
    AggregateOverlayDiagramPresetDao aggregateOverlayDiagramPresetDao =
        new AggregateOverlayDiagramPresetDao(dsl);

    // Act
    int actualCreateResult =
        aggregateOverlayDiagramPresetDao.create(
            ImmutableOverlayDiagramPresetCreateCommand.builder()
                .description("The characteristics of someone or something")
                .diagramId(1L)
                .externalId("42")
                .filterConfig("Filter Config")
                .name("Name")
                .overlayConfig("Overlay Config")
                .build(),
            "janedoe");

    // Assert
    verify(aggregateOverlayDiagramPresetRecord)
        .setDescription("The characteristics of someone or something");
    verify(aggregateOverlayDiagramPresetRecord).setDiagramId(1L);
    verify(aggregateOverlayDiagramPresetRecord).setExternalId("42");
    verify(aggregateOverlayDiagramPresetRecord).setFilterConfig("Filter Config");
    verify(aggregateOverlayDiagramPresetRecord).setLastUpdatedAt(isA(Timestamp.class));
    verify(aggregateOverlayDiagramPresetRecord).setLastUpdatedBy("janedoe");
    verify(aggregateOverlayDiagramPresetRecord).setName("Name");
    verify(aggregateOverlayDiagramPresetRecord).setOverlayConfig("Overlay Config");
    verify(aggregateOverlayDiagramPresetRecord).setProvenance("waltz");
    verify(dsl).insertInto(isA(Table.class));
    verify(dsl).newRecord(isA(Table.class));
    verify(insertSetStep).set(isA(Record.class));
    verify(insertSetMoreStep).execute();
    assertEquals(1, actualCreateResult);
  }

  /**
   * Test {@link AggregateOverlayDiagramPresetDao#create(OverlayDiagramPresetCreateCommand,
   * String)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramPresetDao#create(OverlayDiagramPresetCreateCommand, String)}
   */
  @Test
  @DisplayName("Test create(OverlayDiagramPresetCreateCommand, String); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AggregateOverlayDiagramPresetDao.create(OverlayDiagramPresetCreateCommand, String)"
  })
  void testCreate_thenReturnOne() throws DataAccessException {
    // Arrange
    InsertSetMoreStep<AggregateOverlayDiagramPresetRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);

    InsertSetStep<AggregateOverlayDiagramPresetRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<AggregateOverlayDiagramPresetRecord>>any()))
        .thenReturn(insertSetStep);
    when(dsl.newRecord(Mockito.<Table<AggregateOverlayDiagramPresetRecord>>any()))
        .thenReturn(new AggregateOverlayDiagramPresetRecord());
    AggregateOverlayDiagramPresetDao aggregateOverlayDiagramPresetDao =
        new AggregateOverlayDiagramPresetDao(dsl);

    // Act
    int actualCreateResult =
        aggregateOverlayDiagramPresetDao.create(
            ImmutableOverlayDiagramPresetCreateCommand.builder()
                .description("The characteristics of someone or something")
                .diagramId(1L)
                .externalId("42")
                .filterConfig("Filter Config")
                .name("Name")
                .overlayConfig("Overlay Config")
                .build(),
            "janedoe");

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(dsl).newRecord(isA(Table.class));
    verify(insertSetStep).set(isA(Record.class));
    verify(insertSetMoreStep).execute();
    assertEquals(1, actualCreateResult);
  }
}
