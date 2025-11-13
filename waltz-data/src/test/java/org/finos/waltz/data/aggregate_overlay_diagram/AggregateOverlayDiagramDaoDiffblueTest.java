package org.finos.waltz.data.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
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
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableReleaseLifecycleStatusChangeCommand;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.ReleaseLifecycleStatusChangeCommand;
import org.finos.waltz.model.aggregate_overlay_diagram.AggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.BackingEntity;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableBackingEntity;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableBackingEntity.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableOverlayDiagramSaveCommand;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramSaveCommand;
import org.finos.waltz.schema.tables.records.AggregateOverlayDiagramRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Record3;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.TransactionalRunnable;
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
class AggregateOverlayDiagramDaoDiffblueTest {
  @InjectMocks private AggregateOverlayDiagramDao aggregateOverlayDiagramDao;

  @Mock private DSLContext dSLContext;

  /**
   * Test {@link AggregateOverlayDiagramDao#getById(Long)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramDao#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AggregateOverlayDiagram AggregateOverlayDiagramDao.getById(Long)"})
  void testGetById() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.ALL)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    AggregateOverlayDiagram actualById = new AggregateOverlayDiagramDao(dsl).getById(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualById instanceof ImmutableAggregateOverlayDiagram);
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Layout Data", actualById.layoutData());
    assertEquals("Name", actualById.name());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(EntityKind.ALL, actualById.aggregatedEntityKind());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualById.status());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualById.diagramKind());
    assertSame(ofResult, actualById.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link AggregateOverlayDiagramDao#findAll()}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AggregateOverlayDiagramDao.findAll()"})
  void testFindAll() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<AggregateOverlayDiagram> actualFindAllResult =
        new AggregateOverlayDiagramDao(dsl).findAll();

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramDao#findByKind(OverlayDiagramKind)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramDao#findByKind(OverlayDiagramKind)}
   */
  @Test
  @DisplayName("Test findByKind(OverlayDiagramKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AggregateOverlayDiagramDao.findByKind(OverlayDiagramKind)"})
  void testFindByKind() throws DataAccessException {
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
    Set<AggregateOverlayDiagram> actualFindByKindResult =
        new AggregateOverlayDiagramDao(dsl).findByKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByKindResult.isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramDao#findBackingEntities(Long)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramDao#findBackingEntities(Long)}
   */
  @Test
  @DisplayName("Test findBackingEntities(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AggregateOverlayDiagramDao.findBackingEntities(Long)"})
  void testFindBackingEntities() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep2 =
        mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep2);

    // Act
    Set<BackingEntity> actualFindBackingEntitiesResult =
        aggregateOverlayDiagramDao.findBackingEntities(1L);

    // Assert
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindBackingEntitiesResult.isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramDao#updateBackingEntities(Long, Set)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramDao#updateBackingEntities(Long, Set)}
   */
  @Test
  @DisplayName("Test updateBackingEntities(Long, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AggregateOverlayDiagramDao.updateBackingEntities(Long, Set)"})
  void testUpdateBackingEntities() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = new AggregateOverlayDiagramDao(dsl);

    HashSet<BackingEntity> backingEntities = new HashSet<>();

    Builder cellIdResult = ImmutableBackingEntity.builder().cellId("42");
    backingEntities.add(
        cellIdResult
            .entityReference(
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
    aggregateOverlayDiagramDao.updateBackingEntities(1L, backingEntities);

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Test {@link AggregateOverlayDiagramDao#updateBackingEntities(Long, Set)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramDao#updateBackingEntities(Long, Set)}
   */
  @Test
  @DisplayName("Test updateBackingEntities(Long, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AggregateOverlayDiagramDao.updateBackingEntities(Long, Set)"})
  void testUpdateBackingEntities2() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = new AggregateOverlayDiagramDao(dsl);

    HashSet<BackingEntity> backingEntities = new HashSet<>();

    Builder cellIdResult = ImmutableBackingEntity.builder().cellId("42");
    backingEntities.add(
        cellIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    Builder cellIdResult2 = ImmutableBackingEntity.builder().cellId("Cell Id");
    backingEntities.add(
        cellIdResult2
            .entityReference(
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
    aggregateOverlayDiagramDao.updateBackingEntities(1L, backingEntities);

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Test {@link AggregateOverlayDiagramDao#updateBackingEntities(Long, Set)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#commit()}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramDao#updateBackingEntities(Long, Set)}
   */
  @Test
  @DisplayName("Test updateBackingEntities(Long, Set); then calls commit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AggregateOverlayDiagramDao.updateBackingEntities(Long, Set)"})
  void testUpdateBackingEntities_thenCallsCommit() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = new AggregateOverlayDiagramDao(dsl);

    // Act
    aggregateOverlayDiagramDao.updateBackingEntities(1L, new HashSet<>());

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection)
        .prepareStatement(
            "delete from \"aggregate_overlay_diagram_cell_data\" where \"aggregate_overlay_diagram_cell_data\".\"diagram_id\" = ?");
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Test {@link AggregateOverlayDiagramDao#updateBackingEntities(Long, Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then calls {@link DefaultDSLContext#transaction(TransactionalRunnable)}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramDao#updateBackingEntities(Long, Set)}
   */
  @Test
  @DisplayName(
      "Test updateBackingEntities(Long, Set); when HashSet(); then calls transaction(TransactionalRunnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AggregateOverlayDiagramDao.updateBackingEntities(Long, Set)"})
  void testUpdateBackingEntities_whenHashSet_thenCallsTransaction() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = new AggregateOverlayDiagramDao(dsl);

    // Act
    aggregateOverlayDiagramDao.updateBackingEntities(1L, new HashSet<>());

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Test {@link AggregateOverlayDiagramDao#save(OverlayDiagramSaveCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code false}.
   *   <li>Then calls {@link PreparedStatement#getUpdateCount()}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramDao#save(OverlayDiagramSaveCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test save(OverlayDiagramSaveCommand, String); given PreparedStatement execute() return 'false'; then calls getUpdateCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AggregateOverlayDiagramDao.save(OverlayDiagramSaveCommand, String)"})
  void testSave_givenPreparedStatementExecuteReturnFalse_thenCallsGetUpdateCount()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = new AggregateOverlayDiagramDao(dsl);

    // Act
    Long actualSaveResult =
        aggregateOverlayDiagramDao.save(
            ImmutableOverlayDiagramSaveCommand.builder()
                .aggregatedEntityKind(EntityKind.ALL)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .layoutData("Layout Data")
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"aggregate_overlay_diagram\" set \"aggregate_overlay_diagram\".\"name\" = ?, \"aggregate_overlay_diagram\".\"description\" = ?, \"aggregate_overlay_diagram\".\"layout_data\" = ?, \"aggregate_overlay_diagram\".\"last_updated_by\" = ?, \"aggregate_overlay_diagram\".\"aggregated_entity_kind\" = ?, \"aggregate_overlay_diagram\".\"diagram_kind\" = ? where \"aggregate_overlay_diagram\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(7, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(1L, actualSaveResult.longValue());
  }

  /**
   * Test {@link AggregateOverlayDiagramDao#save(OverlayDiagramSaveCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramDao#save(OverlayDiagramSaveCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test save(OverlayDiagramSaveCommand, String); given PreparedStatement execute() return 'true'; then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AggregateOverlayDiagramDao.save(OverlayDiagramSaveCommand, String)"})
  void testSave_givenPreparedStatementExecuteReturnTrue_thenReturnLongValueIsOne()
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
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = new AggregateOverlayDiagramDao(dsl);

    // Act
    Long actualSaveResult =
        aggregateOverlayDiagramDao.save(
            ImmutableOverlayDiagramSaveCommand.builder()
                .aggregatedEntityKind(EntityKind.ALL)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .layoutData("Layout Data")
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"aggregate_overlay_diagram\" set \"aggregate_overlay_diagram\".\"name\" = ?, \"aggregate_overlay_diagram\".\"description\" = ?, \"aggregate_overlay_diagram\".\"layout_data\" = ?, \"aggregate_overlay_diagram\".\"last_updated_by\" = ?, \"aggregate_overlay_diagram\".\"aggregated_entity_kind\" = ?, \"aggregate_overlay_diagram\".\"diagram_kind\" = ? where \"aggregate_overlay_diagram\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(7, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(1L, actualSaveResult.longValue());
  }

  /**
   * Test {@link AggregateOverlayDiagramDao#save(OverlayDiagramSaveCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#setNull(int, int)} does nothing.
   *   <li>Then calls {@link PreparedStatement#setNull(int, int)}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramDao#save(OverlayDiagramSaveCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test save(OverlayDiagramSaveCommand, String); given PreparedStatement setNull(int, int) does nothing; then calls setNull(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AggregateOverlayDiagramDao.save(OverlayDiagramSaveCommand, String)"})
  void testSave_givenPreparedStatementSetNullDoesNothing_thenCallsSetNull() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = new AggregateOverlayDiagramDao(dsl);

    // Act
    Long actualSaveResult =
        aggregateOverlayDiagramDao.save(
            ImmutableOverlayDiagramSaveCommand.builder()
                .aggregatedEntityKind(EntityKind.ALL)
                .description(null)
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .layoutData("Layout Data")
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"aggregate_overlay_diagram\" set \"aggregate_overlay_diagram\".\"name\" = ?, \"aggregate_overlay_diagram\".\"description\" = ?, \"aggregate_overlay_diagram\".\"layout_data\" = ?, \"aggregate_overlay_diagram\".\"last_updated_by\" = ?, \"aggregate_overlay_diagram\".\"aggregated_entity_kind\" = ?, \"aggregate_overlay_diagram\".\"diagram_kind\" = ? where \"aggregate_overlay_diagram\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(7, 1L);
    verify(preparedStatement).setNull(2, 12);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(1L, actualSaveResult.longValue());
  }

  /**
   * Test {@link AggregateOverlayDiagramDao#updateStatus(long,
   * ReleaseLifecycleStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramDao#updateStatus(long,
   * ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(long, ReleaseLifecycleStatusChangeCommand); given PreparedStatement execute() return 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AggregateOverlayDiagramDao.updateStatus(long, ReleaseLifecycleStatusChangeCommand)"
  })
  void testUpdateStatus_givenPreparedStatementExecuteReturnTrue_thenReturnFalse()
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
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = new AggregateOverlayDiagramDao(dsl);

    // Act
    Boolean actualUpdateStatusResult =
        aggregateOverlayDiagramDao.updateStatus(
            1L,
            ImmutableReleaseLifecycleStatusChangeCommand.builder()
                .newStatus(ReleaseLifecycleStatus.DRAFT)
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"aggregate_overlay_diagram\" set \"aggregate_overlay_diagram\".\"status\" = ? where \"aggregate_overlay_diagram\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "DRAFT");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateStatusResult);
  }

  /**
   * Test {@link AggregateOverlayDiagramDao#updateStatus(long,
   * ReleaseLifecycleStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramDao#updateStatus(long,
   * ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(long, ReleaseLifecycleStatusChangeCommand); given UpdateConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AggregateOverlayDiagramDao.updateStatus(long, ReleaseLifecycleStatusChangeCommand)"
  })
  void testUpdateStatus_givenUpdateConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<AggregateOverlayDiagramRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<AggregateOverlayDiagramRecord> updateSetMoreStep =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<AggregateOverlayDiagramRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<AggregateOverlayDiagramRecord>>any()))
        .thenReturn(updateSetFirstStep);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = new AggregateOverlayDiagramDao(dsl);

    // Act
    Boolean actualUpdateStatusResult =
        aggregateOverlayDiagramDao.updateStatus(
            1L,
            ImmutableReleaseLifecycleStatusChangeCommand.builder()
                .newStatus(ReleaseLifecycleStatus.DRAFT)
                .build());

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualUpdateStatusResult);
  }
}
