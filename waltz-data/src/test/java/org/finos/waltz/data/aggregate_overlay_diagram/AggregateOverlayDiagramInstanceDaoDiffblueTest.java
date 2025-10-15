package org.finos.waltz.data.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
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
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.aggregate_overlay_diagram.AggregateOverlayDiagramInstance;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableOverlayDiagramInstanceCreateCommand;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableOverlayDiagramInstanceCreateCommand.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramInstanceCreateCommand;
import org.finos.waltz.schema.tables.records.AggregateOverlayDiagramInstanceRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
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
class AggregateOverlayDiagramInstanceDaoDiffblueTest {
  @InjectMocks private AggregateOverlayDiagramInstanceDao aggregateOverlayDiagramInstanceDao;

  @Mock private DSLContext dSLContext;

  /**
   * Test {@link AggregateOverlayDiagramInstanceDao#findAll()}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramInstanceDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AggregateOverlayDiagramInstanceDao.findAll()"})
  void testFindAll() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act
    Set<AggregateOverlayDiagramInstance> actualFindAllResult =
        aggregateOverlayDiagramInstanceDao.findAll();

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramInstanceDao#findByDiagramId(Long)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramInstanceDao#findByDiagramId(Long)}
   */
  @Test
  @DisplayName("Test findByDiagramId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AggregateOverlayDiagramInstanceDao.findByDiagramId(Long)"})
  void testFindByDiagramId() throws DataAccessException {
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
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act
    Set<AggregateOverlayDiagramInstance> actualFindByDiagramIdResult =
        aggregateOverlayDiagramInstanceDao.findByDiagramId(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByDiagramIdResult.isEmpty());
  }

  /**
   * Test {@link
   * AggregateOverlayDiagramInstanceDao#createInstance(OverlayDiagramInstanceCreateCommand,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramInstanceDao#createInstance(OverlayDiagramInstanceCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test createInstance(OverlayDiagramInstanceCreateCommand, String); given PreparedStatement execute() return 'true'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AggregateOverlayDiagramInstanceDao.createInstance(OverlayDiagramInstanceCreateCommand, String)"
  })
  void testCreateInstance_givenPreparedStatementExecuteReturnTrue_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AggregateOverlayDiagramInstanceDao aggregateOverlayDiagramInstanceDao =
        new AggregateOverlayDiagramInstanceDao(dsl);

    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");

    // Act
    int actualCreateInstanceResult =
        aggregateOverlayDiagramInstanceDao.createInstance(
            nameResult
                .parentEntityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .svg("Svg")
                .build(),
            "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"aggregate_overlay_diagram_instance\" (\"diagram_id\", \"name\", \"description\", \"parent_entity_kind\", \"parent_entity_id\", \"svg\", \"last_updated_at\", \"last_updated_by\", \"provenance\") values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(7), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualCreateInstanceResult);
  }

  /**
   * Test {@link
   * AggregateOverlayDiagramInstanceDao#createInstance(OverlayDiagramInstanceCreateCommand,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#setNull(int, int)} does nothing.
   *   <li>Then calls {@link PreparedStatement#setNull(int, int)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramInstanceDao#createInstance(OverlayDiagramInstanceCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test createInstance(OverlayDiagramInstanceCreateCommand, String); given PreparedStatement setNull(int, int) does nothing; then calls setNull(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AggregateOverlayDiagramInstanceDao.createInstance(OverlayDiagramInstanceCreateCommand, String)"
  })
  void testCreateInstance_givenPreparedStatementSetNullDoesNothing_thenCallsSetNull()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AggregateOverlayDiagramInstanceDao aggregateOverlayDiagramInstanceDao =
        new AggregateOverlayDiagramInstanceDao(dsl);

    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description(null)
            .diagramId(1L)
            .name("Name");

    // Act
    int actualCreateInstanceResult =
        aggregateOverlayDiagramInstanceDao.createInstance(
            nameResult
                .parentEntityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .svg("Svg")
                .build(),
            "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"aggregate_overlay_diagram_instance\" (\"diagram_id\", \"name\", \"description\", \"parent_entity_kind\", \"parent_entity_id\", \"svg\", \"last_updated_at\", \"last_updated_by\", \"provenance\") values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setNull(3, 12);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(7), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualCreateInstanceResult);
  }

  /**
   * Test {@link
   * AggregateOverlayDiagramInstanceDao#createInstance(OverlayDiagramInstanceCreateCommand,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link AggregateOverlayDiagramInstanceRecord#setDescription(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramInstanceDao#createInstance(OverlayDiagramInstanceCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test createInstance(OverlayDiagramInstanceCreateCommand, String); then calls setDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AggregateOverlayDiagramInstanceDao.createInstance(OverlayDiagramInstanceCreateCommand, String)"
  })
  void testCreateInstance_thenCallsSetDescription() throws DataAccessException {
    // Arrange
    AggregateOverlayDiagramInstanceRecord aggregateOverlayDiagramInstanceRecord =
        mock(AggregateOverlayDiagramInstanceRecord.class);
    doNothing().when(aggregateOverlayDiagramInstanceRecord).setDescription(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramInstanceRecord).setDiagramId(Mockito.<Long>any());
    doNothing()
        .when(aggregateOverlayDiagramInstanceRecord)
        .setLastUpdatedAt(Mockito.<Timestamp>any());
    doNothing().when(aggregateOverlayDiagramInstanceRecord).setLastUpdatedBy(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramInstanceRecord).setName(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramInstanceRecord).setParentEntityId(Mockito.<Long>any());
    doNothing()
        .when(aggregateOverlayDiagramInstanceRecord)
        .setParentEntityKind(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramInstanceRecord).setProvenance(Mockito.<String>any());
    doNothing().when(aggregateOverlayDiagramInstanceRecord).setSvg(Mockito.<String>any());

    InsertSetMoreStep<AggregateOverlayDiagramInstanceRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);

    InsertSetStep<AggregateOverlayDiagramInstanceRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<AggregateOverlayDiagramInstanceRecord>>any()))
        .thenReturn(insertSetStep);
    when(dSLContext.newRecord(Mockito.<Table<AggregateOverlayDiagramInstanceRecord>>any()))
        .thenReturn(aggregateOverlayDiagramInstanceRecord);

    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");

    // Act
    int actualCreateInstanceResult =
        aggregateOverlayDiagramInstanceDao.createInstance(
            nameResult
                .parentEntityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .svg("Svg")
                .build(),
            "janedoe");

    // Assert
    verify(aggregateOverlayDiagramInstanceRecord)
        .setDescription("The characteristics of someone or something");
    verify(aggregateOverlayDiagramInstanceRecord).setDiagramId(1L);
    verify(aggregateOverlayDiagramInstanceRecord).setLastUpdatedAt(isA(Timestamp.class));
    verify(aggregateOverlayDiagramInstanceRecord).setLastUpdatedBy("janedoe");
    verify(aggregateOverlayDiagramInstanceRecord).setName("Name");
    verify(aggregateOverlayDiagramInstanceRecord).setParentEntityId(1L);
    verify(aggregateOverlayDiagramInstanceRecord).setParentEntityKind("ALL");
    verify(aggregateOverlayDiagramInstanceRecord).setProvenance("waltz");
    verify(aggregateOverlayDiagramInstanceRecord).setSvg("Svg");
    verify(dSLContext).insertInto(isA(Table.class));
    verify(dSLContext).newRecord(isA(Table.class));
    verify(insertSetStep).set(isA(Record.class));
    verify(insertSetMoreStep).execute();
    assertEquals(1, actualCreateInstanceResult);
  }

  /**
   * Test {@link
   * AggregateOverlayDiagramInstanceDao#createInstance(OverlayDiagramInstanceCreateCommand,
   * String)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramInstanceDao#createInstance(OverlayDiagramInstanceCreateCommand, String)}
   */
  @Test
  @DisplayName("Test createInstance(OverlayDiagramInstanceCreateCommand, String); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AggregateOverlayDiagramInstanceDao.createInstance(OverlayDiagramInstanceCreateCommand, String)"
  })
  void testCreateInstance_thenReturnOne() throws DataAccessException {
    // Arrange
    InsertSetMoreStep<AggregateOverlayDiagramInstanceRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);

    InsertSetStep<AggregateOverlayDiagramInstanceRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<AggregateOverlayDiagramInstanceRecord>>any()))
        .thenReturn(insertSetStep);
    when(dSLContext.newRecord(Mockito.<Table<AggregateOverlayDiagramInstanceRecord>>any()))
        .thenReturn(new AggregateOverlayDiagramInstanceRecord());

    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");

    // Act
    int actualCreateInstanceResult =
        aggregateOverlayDiagramInstanceDao.createInstance(
            nameResult
                .parentEntityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .svg("Svg")
                .build(),
            "janedoe");

    // Assert
    verify(dSLContext).insertInto(isA(Table.class));
    verify(dSLContext).newRecord(isA(Table.class));
    verify(insertSetStep).set(isA(Record.class));
    verify(insertSetMoreStep).execute();
    assertEquals(1, actualCreateInstanceResult);
  }
}
