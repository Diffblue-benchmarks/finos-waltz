package org.finos.waltz.data.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
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
import org.jooq.Field;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
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
import org.jooq.impl.DefaultDSLContext;
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

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<AggregateOverlayDiagramCallout> actualFindByDiagramInstanceIdResult =
        new AggregateOverlayDiagramCalloutDao(dsl).findByDiagramInstanceId(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
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

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<AggregateOverlayDiagramCalloutRecord>>any()))
        .thenReturn(insertSetStep);
    when(dsl.newRecord(Mockito.<Table<AggregateOverlayDiagramCalloutRecord>>any()))
        .thenReturn(aggregateOverlayDiagramCalloutRecord);
    AggregateOverlayDiagramCalloutDao aggregateOverlayDiagramCalloutDao =
        new AggregateOverlayDiagramCalloutDao(dsl);

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
    verify(dsl).insertInto(isA(Table.class));
    verify(dsl).newRecord(isA(Table.class));
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

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<AggregateOverlayDiagramCalloutRecord>>any()))
        .thenReturn(insertSetStep);
    when(dsl.newRecord(Mockito.<Table<AggregateOverlayDiagramCalloutRecord>>any()))
        .thenReturn(new AggregateOverlayDiagramCalloutRecord());
    AggregateOverlayDiagramCalloutDao aggregateOverlayDiagramCalloutDao =
        new AggregateOverlayDiagramCalloutDao(dsl);

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
    verify(dsl).insertInto(isA(Table.class));
    verify(dsl).newRecord(isA(Table.class));
    verify(insertSetStep).set(isA(Record.class));
    verify(insertSetMoreStep).execute();
    assertEquals(1, actualCreateResult);
  }

  /**
   * Test {@link AggregateOverlayDiagramCalloutDao#update(AggregateOverlayDiagramCallout)}.
   *
   * <ul>
   *   <li>Given of one.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramCalloutDao#update(AggregateOverlayDiagramCallout)}
   */
  @Test
  @DisplayName(
      "Test update(AggregateOverlayDiagramCallout); given of one; then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer AggregateOverlayDiagramCalloutDao.update(AggregateOverlayDiagramCallout)"
  })
  void testUpdate_givenOfOne_thenReturnIntValueIsOne() throws DataAccessException {
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
   * Test {@link AggregateOverlayDiagramCalloutDao#update(AggregateOverlayDiagramCallout)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramCalloutDao#update(AggregateOverlayDiagramCallout)}
   */
  @Test
  @DisplayName(
      "Test update(AggregateOverlayDiagramCallout); given PreparedStatement execute() return 'true'; then return intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer AggregateOverlayDiagramCalloutDao.update(AggregateOverlayDiagramCallout)"
  })
  void testUpdate_givenPreparedStatementExecuteReturnTrue_thenReturnIntValueIsZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AggregateOverlayDiagramCalloutDao aggregateOverlayDiagramCalloutDao =
        new AggregateOverlayDiagramCalloutDao(dsl);

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
    verify(connection)
        .prepareStatement(
            "update \"aggregate_overlay_diagram_callout\" set \"aggregate_overlay_diagram_callout\".\"title\" = ?, \"aggregate_overlay_diagram_callout\".\"content\" = ?, \"aggregate_overlay_diagram_callout\".\"start_color\" = ?, \"aggregate_overlay_diagram_callout\".\"end_color\" = ? where \"aggregate_overlay_diagram_callout\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(5, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateResult.intValue());
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
  void testDelete() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    Integer actualDeleteResult = new AggregateOverlayDiagramCalloutDao(dsl).delete(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"aggregate_overlay_diagram_callout\" where \"aggregate_overlay_diagram_callout\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteResult.intValue());
  }
}
