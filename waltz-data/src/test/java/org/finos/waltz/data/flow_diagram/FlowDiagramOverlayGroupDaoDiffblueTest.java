package org.finos.waltz.data.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
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
import java.util.Set;
import org.finos.waltz.model.flow_diagram.FlowDiagramOverlayGroup;
import org.finos.waltz.model.flow_diagram.FlowDiagramOverlayGroupEntry;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagramOverlayGroup;
import org.finos.waltz.schema.tables.records.FlowDiagramOverlayGroupEntryRecord;
import org.finos.waltz.schema.tables.records.FlowDiagramOverlayGroupRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.InsertResultStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FlowDiagramOverlayGroupDaoDiffblueTest {
  /**
   * Test {@link FlowDiagramOverlayGroupDao#getById(Long)}.
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupDao#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FlowDiagramOverlayGroup FlowDiagramOverlayGroupDao.getById(Long)"})
  void testGetById() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableFlowDiagramOverlayGroup.builder()
                .description("The characteristics of someone or something")
                .diagramId(1L)
                .externalId("42")
                .id(1L)
                .name("Name")
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    FlowDiagramOverlayGroup actualById = new FlowDiagramOverlayGroupDao(dsl).getById(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualById instanceof ImmutableFlowDiagramOverlayGroup);
    assertEquals("42", actualById.externalId());
    assertEquals("Name", actualById.name());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(1L, actualById.diagramId().longValue());
    assertFalse(actualById.isDefault());
  }

  /**
   * Test {@link FlowDiagramOverlayGroupDao#findByDiagramId(long)}.
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupDao#findByDiagramId(long)}
   */
  @Test
  @DisplayName("Test findByDiagramId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowDiagramOverlayGroupDao.findByDiagramId(long)"})
  void testFindByDiagramId() throws DataAccessException {
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
    Set<FlowDiagramOverlayGroup> actualFindByDiagramIdResult =
        new FlowDiagramOverlayGroupDao(dsl).findByDiagramId(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByDiagramIdResult.isEmpty());
  }

  /**
   * Test {@link FlowDiagramOverlayGroupDao#findOverlaysByDiagramId(long)}.
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupDao#findOverlaysByDiagramId(long)}
   */
  @Test
  @DisplayName("Test findOverlaysByDiagramId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowDiagramOverlayGroupDao.findOverlaysByDiagramId(long)"})
  void testFindOverlaysByDiagramId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record1<Object>> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep2);

    // Act
    Set<FlowDiagramOverlayGroupEntry> actualFindOverlaysByDiagramIdResult =
        new FlowDiagramOverlayGroupDao(dsl).findOverlaysByDiagramId(1L);

    // Assert
    verify(dsl).select(isA(SelectField.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindOverlaysByDiagramIdResult.isEmpty());
  }

  /**
   * Test {@link FlowDiagramOverlayGroupDao#findOverlaysByGroupId(long)}.
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupDao#findOverlaysByGroupId(long)}
   */
  @Test
  @DisplayName("Test findOverlaysByGroupId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowDiagramOverlayGroupDao.findOverlaysByGroupId(long)"})
  void testFindOverlaysByGroupId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act
    Set<FlowDiagramOverlayGroupEntry> actualFindOverlaysByGroupIdResult =
        new FlowDiagramOverlayGroupDao(dsl).findOverlaysByGroupId(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindOverlaysByGroupIdResult.isEmpty());
  }

  /**
   * Test {@link FlowDiagramOverlayGroupDao#create(FlowDiagramOverlayGroup)}.
   *
   * <ul>
   *   <li>Then calls {@link FlowDiagramOverlayGroupRecord#setDescription(String)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupDao#create(FlowDiagramOverlayGroup)}
   */
  @Test
  @DisplayName("Test create(FlowDiagramOverlayGroup); then calls setDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long FlowDiagramOverlayGroupDao.create(FlowDiagramOverlayGroup)"})
  void testCreate_thenCallsSetDescription() throws DataAccessException {
    // Arrange
    FlowDiagramOverlayGroupRecord flowDiagramOverlayGroupRecord =
        mock(FlowDiagramOverlayGroupRecord.class);
    doNothing().when(flowDiagramOverlayGroupRecord).setDescription(Mockito.<String>any());
    doNothing().when(flowDiagramOverlayGroupRecord).setExternalId(Mockito.<String>any());
    doNothing().when(flowDiagramOverlayGroupRecord).setFlowDiagramId(Mockito.<Long>any());
    doNothing().when(flowDiagramOverlayGroupRecord).setIsDefault(Mockito.<Boolean>any());
    doNothing().when(flowDiagramOverlayGroupRecord).setName(Mockito.<String>any());

    FlowDiagramOverlayGroupRecord flowDiagramOverlayGroupRecord2 =
        mock(FlowDiagramOverlayGroupRecord.class);
    when(flowDiagramOverlayGroupRecord2.getId()).thenReturn(1L);

    InsertResultStep<FlowDiagramOverlayGroupRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(flowDiagramOverlayGroupRecord2);

    InsertSetMoreStep<FlowDiagramOverlayGroupRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<FlowDiagramOverlayGroupRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<FlowDiagramOverlayGroupRecord>>any()))
        .thenReturn(insertSetStep);
    when(dsl.newRecord(Mockito.<Table<FlowDiagramOverlayGroupRecord>>any()))
        .thenReturn(flowDiagramOverlayGroupRecord);
    FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao = new FlowDiagramOverlayGroupDao(dsl);

    // Act
    Long actualCreateResult =
        flowDiagramOverlayGroupDao.create(
            ImmutableFlowDiagramOverlayGroup.builder()
                .description("The characteristics of someone or something")
                .diagramId(1L)
                .externalId("42")
                .id(1L)
                .name("Name")
                .build());

    // Assert
    verify(flowDiagramOverlayGroupRecord2).getId();
    verify(flowDiagramOverlayGroupRecord)
        .setDescription("The characteristics of someone or something");
    verify(flowDiagramOverlayGroupRecord).setExternalId("42");
    verify(flowDiagramOverlayGroupRecord).setFlowDiagramId(1L);
    verify(flowDiagramOverlayGroupRecord).setIsDefault(false);
    verify(flowDiagramOverlayGroupRecord).setName("Name");
    verify(dsl).insertInto(isA(Table.class));
    verify(dsl).newRecord(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateResult.longValue());
  }

  /**
   * Test {@link FlowDiagramOverlayGroupDao#create(FlowDiagramOverlayGroup)}.
   *
   * <ul>
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupDao#create(FlowDiagramOverlayGroup)}
   */
  @Test
  @DisplayName("Test create(FlowDiagramOverlayGroup); then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long FlowDiagramOverlayGroupDao.create(FlowDiagramOverlayGroup)"})
  void testCreate_thenReturnLongValueIsOne() throws DataAccessException {
    // Arrange
    FlowDiagramOverlayGroupRecord flowDiagramOverlayGroupRecord =
        mock(FlowDiagramOverlayGroupRecord.class);
    when(flowDiagramOverlayGroupRecord.getId()).thenReturn(1L);

    InsertResultStep<FlowDiagramOverlayGroupRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(flowDiagramOverlayGroupRecord);

    InsertSetMoreStep<FlowDiagramOverlayGroupRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<FlowDiagramOverlayGroupRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<FlowDiagramOverlayGroupRecord>>any()))
        .thenReturn(insertSetStep);
    when(dsl.newRecord(Mockito.<Table<FlowDiagramOverlayGroupRecord>>any()))
        .thenReturn(new FlowDiagramOverlayGroupRecord());
    FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao = new FlowDiagramOverlayGroupDao(dsl);

    // Act
    Long actualCreateResult =
        flowDiagramOverlayGroupDao.create(
            ImmutableFlowDiagramOverlayGroup.builder()
                .description("The characteristics of someone or something")
                .diagramId(1L)
                .externalId("42")
                .id(1L)
                .name("Name")
                .build());

    // Assert
    verify(flowDiagramOverlayGroupRecord).getId();
    verify(dsl).insertInto(isA(Table.class));
    verify(dsl).newRecord(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateResult.longValue());
  }

  /**
   * Test {@link FlowDiagramOverlayGroupDao#create(FlowDiagramOverlayGroup)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupDao#create(FlowDiagramOverlayGroup)}
   */
  @Test
  @DisplayName("Test create(FlowDiagramOverlayGroup); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long FlowDiagramOverlayGroupDao.create(FlowDiagramOverlayGroup)"})
  void testCreate_thenReturnNull() throws DataAccessException {
    // Arrange
    InsertResultStep<FlowDiagramOverlayGroupRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(new FlowDiagramOverlayGroupRecord());

    InsertSetMoreStep<FlowDiagramOverlayGroupRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<FlowDiagramOverlayGroupRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<FlowDiagramOverlayGroupRecord>>any()))
        .thenReturn(insertSetStep);
    when(dsl.newRecord(Mockito.<Table<FlowDiagramOverlayGroupRecord>>any()))
        .thenReturn(new FlowDiagramOverlayGroupRecord());
    FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao = new FlowDiagramOverlayGroupDao(dsl);

    // Act
    Long actualCreateResult =
        flowDiagramOverlayGroupDao.create(
            ImmutableFlowDiagramOverlayGroup.builder()
                .description("The characteristics of someone or something")
                .diagramId(1L)
                .externalId("42")
                .id(1L)
                .name("Name")
                .build());

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(dsl).newRecord(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link FlowDiagramOverlayGroupDao#delete(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupDao#delete(Long)}
   */
  @Test
  @DisplayName(
      "Test delete(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramOverlayGroupDao.delete(Long)"})
  void testDelete_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    boolean actualDeleteResult = new FlowDiagramOverlayGroupDao(dsl).delete(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"flow_diagram_overlay_group\" where \"flow_diagram_overlay_group\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link FlowDiagramOverlayGroupDao#delete(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code MARIADB}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupDao#delete(Long)}
   */
  @Test
  @DisplayName(
      "Test delete(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'MARIADB'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramOverlayGroupDao.delete(Long)"})
  void testDelete_givenDefaultDSLContextWithConnectionAndDialectIsMariadb() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.MARIADB);

    // Act
    boolean actualDeleteResult = new FlowDiagramOverlayGroupDao(dsl).delete(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from `flow_diagram_overlay_group` where `flow_diagram_overlay_group`.`id` = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link FlowDiagramOverlayGroupDao#delete(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code POSTGRES}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupDao#delete(Long)}
   */
  @Test
  @DisplayName(
      "Test delete(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'POSTGRES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramOverlayGroupDao.delete(Long)"})
  void testDelete_givenDefaultDSLContextWithConnectionAndDialectIsPostgres() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    // Act
    boolean actualDeleteResult = new FlowDiagramOverlayGroupDao(dsl).delete(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"flow_diagram_overlay_group\" where \"flow_diagram_overlay_group\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link FlowDiagramOverlayGroupDao#delete(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupDao#delete(Long)}
   */
  @Test
  @DisplayName(
      "Test delete(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramOverlayGroupDao.delete(Long)"})
  void testDelete_givenDefaultDSLContextWithConnectionAndDialectIsSql99_thenReturnFalse()
      throws SQLException {
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
    boolean actualDeleteResult = new FlowDiagramOverlayGroupDao(dsl).delete(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"flow_diagram_overlay_group\" where \"flow_diagram_overlay_group\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link FlowDiagramOverlayGroupDao#delete(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQLITE}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupDao#delete(Long)}
   */
  @Test
  @DisplayName(
      "Test delete(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQLITE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramOverlayGroupDao.delete(Long)"})
  void testDelete_givenDefaultDSLContextWithConnectionAndDialectIsSqlite() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    // Act
    boolean actualDeleteResult = new FlowDiagramOverlayGroupDao(dsl).delete(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from flow_diagram_overlay_group where flow_diagram_overlay_group.id = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link FlowDiagramOverlayGroupDao#delete(Long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupDao#delete(Long)}
   */
  @Test
  @DisplayName(
      "Test delete(Long); given DeleteConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramOverlayGroupDao.delete(Long)"})
  void testDelete_givenDeleteConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<FlowDiagramOverlayGroupRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<FlowDiagramOverlayGroupRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<FlowDiagramOverlayGroupRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    boolean actualDeleteResult = new FlowDiagramOverlayGroupDao(dsl).delete(1L);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertTrue(actualDeleteResult);
  }

  /**
   * Test {@link FlowDiagramOverlayGroupDao#delete(Long)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getWarnings()} return {@code
   *       null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupDao#delete(Long)}
   */
  @Test
  @DisplayName(
      "Test delete(Long); given PreparedStatement getWarnings() return 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramOverlayGroupDao.delete(Long)"})
  void testDelete_givenPreparedStatementGetWarningsReturnNull_thenReturnFalse()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(null);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualDeleteResult = new FlowDiagramOverlayGroupDao(dsl).delete(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"flow_diagram_overlay_group\" where \"flow_diagram_overlay_group\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link FlowDiagramOverlayGroupDao#deleteOverlaysForDiagram(Long)}.
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupDao#deleteOverlaysForDiagram(Long)}
   */
  @Test
  @DisplayName("Test deleteOverlaysForDiagram(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowDiagramOverlayGroupDao.deleteOverlaysForDiagram(Long)"})
  void testDeleteOverlaysForDiagram() throws SQLException {
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
    int actualDeleteOverlaysForDiagramResult =
        new FlowDiagramOverlayGroupDao(dsl).deleteOverlaysForDiagram(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"flow_diagram_overlay_group_entry\" where \"flow_diagram_overlay_group_entry\".\"overlay_group_id\" in (select \"flow_diagram_overlay_group\".\"id\" from \"flow_diagram_overlay_group\" where \"flow_diagram_overlay_group\".\"flow_diagram_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteOverlaysForDiagramResult);
  }

  /**
   * Test {@link FlowDiagramOverlayGroupDao#deleteOverlaysForDiagram(Long)}.
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupDao#deleteOverlaysForDiagram(Long)}
   */
  @Test
  @DisplayName("Test deleteOverlaysForDiagram(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowDiagramOverlayGroupDao.deleteOverlaysForDiagram(Long)"})
  void testDeleteOverlaysForDiagram2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualDeleteOverlaysForDiagramResult =
        new FlowDiagramOverlayGroupDao(dsl).deleteOverlaysForDiagram(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"flow_diagram_overlay_group_entry\" where \"flow_diagram_overlay_group_entry\".\"overlay_group_id\" in (select \"flow_diagram_overlay_group\".\"id\" from \"flow_diagram_overlay_group\" where \"flow_diagram_overlay_group\".\"flow_diagram_id\" = cast(? as bigint))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteOverlaysForDiagramResult);
  }

  /**
   * Test {@link FlowDiagramOverlayGroupDao#deleteOverlaysForDiagram(Long)}.
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupDao#deleteOverlaysForDiagram(Long)}
   */
  @Test
  @DisplayName("Test deleteOverlaysForDiagram(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowDiagramOverlayGroupDao.deleteOverlaysForDiagram(Long)"})
  void testDeleteOverlaysForDiagram3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.MARIADB);

    // Act
    int actualDeleteOverlaysForDiagramResult =
        new FlowDiagramOverlayGroupDao(dsl).deleteOverlaysForDiagram(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from `flow_diagram_overlay_group_entry` where `flow_diagram_overlay_group_entry`.`overlay_group_id` in (select `flow_diagram_overlay_group`.`id` from `flow_diagram_overlay_group` where `flow_diagram_overlay_group`.`flow_diagram_id` = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteOverlaysForDiagramResult);
  }

  /**
   * Test {@link FlowDiagramOverlayGroupDao#deleteOverlaysForDiagram(Long)}.
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupDao#deleteOverlaysForDiagram(Long)}
   */
  @Test
  @DisplayName("Test deleteOverlaysForDiagram(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowDiagramOverlayGroupDao.deleteOverlaysForDiagram(Long)"})
  void testDeleteOverlaysForDiagram4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    // Act
    int actualDeleteOverlaysForDiagramResult =
        new FlowDiagramOverlayGroupDao(dsl).deleteOverlaysForDiagram(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"flow_diagram_overlay_group_entry\" where \"flow_diagram_overlay_group_entry\".\"overlay_group_id\" in (select \"flow_diagram_overlay_group\".\"id\" from \"flow_diagram_overlay_group\" where \"flow_diagram_overlay_group\".\"flow_diagram_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteOverlaysForDiagramResult);
  }

  /**
   * Test {@link FlowDiagramOverlayGroupDao#deleteOverlaysForDiagram(Long)}.
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupDao#deleteOverlaysForDiagram(Long)}
   */
  @Test
  @DisplayName("Test deleteOverlaysForDiagram(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowDiagramOverlayGroupDao.deleteOverlaysForDiagram(Long)"})
  void testDeleteOverlaysForDiagram5() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    // Act
    int actualDeleteOverlaysForDiagramResult =
        new FlowDiagramOverlayGroupDao(dsl).deleteOverlaysForDiagram(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from flow_diagram_overlay_group_entry where flow_diagram_overlay_group_entry.overlay_group_id in (select flow_diagram_overlay_group.id from flow_diagram_overlay_group where flow_diagram_overlay_group.flow_diagram_id = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteOverlaysForDiagramResult);
  }

  /**
   * Test {@link FlowDiagramOverlayGroupDao#deleteOverlaysForDiagram(Long)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getWarnings()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupDao#deleteOverlaysForDiagram(Long)}
   */
  @Test
  @DisplayName(
      "Test deleteOverlaysForDiagram(Long); given PreparedStatement getWarnings() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowDiagramOverlayGroupDao.deleteOverlaysForDiagram(Long)"})
  void testDeleteOverlaysForDiagram_givenPreparedStatementGetWarningsReturnNull()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(null);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualDeleteOverlaysForDiagramResult =
        new FlowDiagramOverlayGroupDao(dsl).deleteOverlaysForDiagram(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"flow_diagram_overlay_group_entry\" where \"flow_diagram_overlay_group_entry\".\"overlay_group_id\" in (select \"flow_diagram_overlay_group\".\"id\" from \"flow_diagram_overlay_group\" where \"flow_diagram_overlay_group\".\"flow_diagram_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteOverlaysForDiagramResult);
  }

  /**
   * Test {@link FlowDiagramOverlayGroupDao#deleteOverlaysForDiagram(Long)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupDao#deleteOverlaysForDiagram(Long)}
   */
  @Test
  @DisplayName("Test deleteOverlaysForDiagram(Long); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowDiagramOverlayGroupDao.deleteOverlaysForDiagram(Long)"})
  void testDeleteOverlaysForDiagram_thenReturnOne() throws DataAccessException {
    // Arrange
    DeleteConditionStep<FlowDiagramOverlayGroupEntryRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<FlowDiagramOverlayGroupEntryRecord> deleteUsingStep =
        mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<FlowDiagramOverlayGroupEntryRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    int actualDeleteOverlaysForDiagramResult =
        new FlowDiagramOverlayGroupDao(dsl).deleteOverlaysForDiagram(1L);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertEquals(1, actualDeleteOverlaysForDiagramResult);
  }

  /**
   * Test {@link FlowDiagramOverlayGroupDao#createOverlays(Set)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(SQLDialect)} with dialect is {@code
   *       SQL99}.
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroupDao#createOverlays(Set)}
   */
  @Test
  @DisplayName(
      "Test createOverlays(Set); given DefaultDSLContext(SQLDialect) with dialect is 'SQL99'; when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowDiagramOverlayGroupDao.createOverlays(Set)"})
  void testCreateOverlays_givenDefaultDSLContextWithDialectIsSql99_whenHashSet() {
    // Arrange
    FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao =
        new FlowDiagramOverlayGroupDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, flowDiagramOverlayGroupDao.createOverlays(new HashSet<>()));
  }
}
