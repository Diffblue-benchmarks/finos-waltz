package org.finos.waltz.data.entity_named_note;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.entity_named_note.EntityNamedNodeType;
import org.finos.waltz.model.entity_named_note.EntityNamedNoteTypeChangeCommand;
import org.finos.waltz.model.entity_named_note.ImmutableEntityNamedNoteTypeChangeCommand;
import org.finos.waltz.model.entity_named_note.ImmutableEntityNamedNoteTypeChangeCommand.Builder;
import org.finos.waltz.schema.tables.records.EntityNamedNoteTypeRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.UpdatableRecord;
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
class EntityNamedNoteTypeDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private EntityNamedNoteTypeDao entityNamedNoteTypeDao;

  /**
   * Test {@link EntityNamedNoteTypeDao#findAll()}.
   *
   * <p>Method under test: {@link EntityNamedNoteTypeDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityNamedNoteTypeDao.findAll()"})
  void testFindAll() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<EntityNamedNodeType> actualFindAllResult = entityNamedNoteTypeDao.findAll();

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link EntityNamedNoteTypeDao#removeById(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteTypeDao#removeById(Long)}
   */
  @Test
  @DisplayName(
      "Test removeById(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityNamedNoteTypeDao.removeById(Long)"})
  void testRemoveById_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
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
    boolean actualRemoveByIdResult = new EntityNamedNoteTypeDao(dsl).removeById(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"entity_named_note_type\" where (\"entity_named_note_type\".\"id\" = cast(? as bigint) and not exists (select \"entity_named_note\".\"entity_id\" from \"entity_named_note\" where \"entity_named_note\".\"named_note_type_id\" = cast(? as bigint)))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveByIdResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeDao#removeById(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code MARIADB}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteTypeDao#removeById(Long)}
   */
  @Test
  @DisplayName(
      "Test removeById(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'MARIADB'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityNamedNoteTypeDao.removeById(Long)"})
  void testRemoveById_givenDefaultDSLContextWithConnectionAndDialectIsMariadb()
      throws SQLException {
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
    boolean actualRemoveByIdResult = new EntityNamedNoteTypeDao(dsl).removeById(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from `entity_named_note_type` where (`entity_named_note_type`.`id` = ? and not exists (select `entity_named_note`.`entity_id` from `entity_named_note` where `entity_named_note`.`named_note_type_id` = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveByIdResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeDao#removeById(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code POSTGRES}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteTypeDao#removeById(Long)}
   */
  @Test
  @DisplayName(
      "Test removeById(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'POSTGRES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityNamedNoteTypeDao.removeById(Long)"})
  void testRemoveById_givenDefaultDSLContextWithConnectionAndDialectIsPostgres()
      throws SQLException {
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
    boolean actualRemoveByIdResult = new EntityNamedNoteTypeDao(dsl).removeById(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"entity_named_note_type\" where (\"entity_named_note_type\".\"id\" = ? and not exists (select \"entity_named_note\".\"entity_id\" from \"entity_named_note\" where \"entity_named_note\".\"named_note_type_id\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveByIdResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeDao#removeById(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteTypeDao#removeById(Long)}
   */
  @Test
  @DisplayName(
      "Test removeById(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityNamedNoteTypeDao.removeById(Long)"})
  void testRemoveById_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
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
    boolean actualRemoveByIdResult = new EntityNamedNoteTypeDao(dsl).removeById(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"entity_named_note_type\" where (\"entity_named_note_type\".\"id\" = ? and not exists (select \"entity_named_note\".\"entity_id\" from \"entity_named_note\" where \"entity_named_note\".\"named_note_type_id\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveByIdResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeDao#removeById(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQLITE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteTypeDao#removeById(Long)}
   */
  @Test
  @DisplayName(
      "Test removeById(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQLITE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityNamedNoteTypeDao.removeById(Long)"})
  void testRemoveById_givenDefaultDSLContextWithConnectionAndDialectIsSqlite() throws SQLException {
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
    boolean actualRemoveByIdResult = new EntityNamedNoteTypeDao(dsl).removeById(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from entity_named_note_type where (entity_named_note_type.id = ? and not exists (select entity_named_note.entity_id from entity_named_note where entity_named_note.named_note_type_id = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveByIdResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeDao#removeById(Long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteTypeDao#removeById(Long)}
   */
  @Test
  @DisplayName(
      "Test removeById(Long); given DeleteConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityNamedNoteTypeDao.removeById(Long)"})
  void testRemoveById_givenDeleteConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<EntityNamedNoteTypeRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<EntityNamedNoteTypeRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.andNotExists(Mockito.<Select<?>>any()))
        .thenReturn(deleteConditionStep);

    DeleteUsingStep<EntityNamedNoteTypeRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<EntityNamedNoteTypeRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    boolean actualRemoveByIdResult = entityNamedNoteTypeDao.removeById(1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep2).andNotExists(isA(Select.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertTrue(actualRemoveByIdResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeDao#removeById(Long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return zero.
   *   <li>Then calls {@link DSLContext#deleteFrom(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteTypeDao#removeById(Long)}
   */
  @Test
  @DisplayName(
      "Test removeById(Long); given DeleteConditionStep execute() return zero; then calls deleteFrom(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityNamedNoteTypeDao.removeById(Long)"})
  void testRemoveById_givenDeleteConditionStepExecuteReturnZero_thenCallsDeleteFrom()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<EntityNamedNoteTypeRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);

    DeleteConditionStep<EntityNamedNoteTypeRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.andNotExists(Mockito.<Select<?>>any()))
        .thenReturn(deleteConditionStep);

    DeleteUsingStep<EntityNamedNoteTypeRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<EntityNamedNoteTypeRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    boolean actualRemoveByIdResult = entityNamedNoteTypeDao.removeById(1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep2).andNotExists(isA(Select.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertFalse(actualRemoveByIdResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeDao#update(long, EntityNamedNoteTypeChangeCommand)}.
   *
   * <p>Method under test: {@link EntityNamedNoteTypeDao#update(long,
   * EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  @DisplayName("Test update(long, EntityNamedNoteTypeChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityNamedNoteTypeDao.update(long, EntityNamedNoteTypeChangeCommand)"
  })
  void testUpdate() throws DataAccessException {
    // Arrange
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);

    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act
    boolean actualUpdateResult =
        entityNamedNoteTypeDao.update(
            1L, externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build());

    // Assert
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeDao#update(long, EntityNamedNoteTypeChangeCommand)}.
   *
   * <p>Method under test: {@link EntityNamedNoteTypeDao#update(long,
   * EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  @DisplayName("Test update(long, EntityNamedNoteTypeChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityNamedNoteTypeDao.update(long, EntityNamedNoteTypeChangeCommand)"
  })
  void testUpdate2() throws DataAccessException {
    // Arrange
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);

    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.empty();

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act
    boolean actualUpdateResult =
        entityNamedNoteTypeDao.update(
            1L, externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build());

    // Assert
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeDao#update(long, EntityNamedNoteTypeChangeCommand)}.
   *
   * <p>Method under test: {@link EntityNamedNoteTypeDao#update(long,
   * EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  @DisplayName("Test update(long, EntityNamedNoteTypeChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityNamedNoteTypeDao.update(long, EntityNamedNoteTypeChangeCommand)"
  })
  void testUpdate3() throws DataAccessException {
    // Arrange
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);

    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.empty();

    // Act
    boolean actualUpdateResult =
        entityNamedNoteTypeDao.update(
            1L, externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build());

    // Assert
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeDao#update(long, EntityNamedNoteTypeChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#executeUpdate(UpdatableRecord)} return two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteTypeDao#update(long,
   * EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(long, EntityNamedNoteTypeChangeCommand); given DSLContext executeUpdate(UpdatableRecord) return two; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityNamedNoteTypeDao.update(long, EntityNamedNoteTypeChangeCommand)"
  })
  void testUpdate_givenDSLContextExecuteUpdateReturnTwo_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(2);

    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act
    boolean actualUpdateResult =
        entityNamedNoteTypeDao.update(
            1L, externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build());

    // Assert
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    assertFalse(actualUpdateResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeDao#update(long, EntityNamedNoteTypeChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteTypeDao#update(long,
   * EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(long, EntityNamedNoteTypeChangeCommand); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityNamedNoteTypeDao.update(long, EntityNamedNoteTypeChangeCommand)"
  })
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    EntityNamedNoteTypeDao entityNamedNoteTypeDao = new EntityNamedNoteTypeDao(dsl);

    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act
    boolean actualUpdateResult =
        entityNamedNoteTypeDao.update(
            1L, externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"entity_named_note_type\" set \"entity_named_note_type\".\"applicable_entity_kinds\" = cast(? as varchar), \"entity_named_note_type\".\"name\" = cast(? as varchar), \"entity_named_note_type\".\"description\" = cast(? as varchar), \"entity_named_note_type\".\"is_readonly\" = cast(? as bit(1)), \"entity_named_note_type\".\"position\" = cast(? as int), \"entity_named_note_type\".\"external_id\" = cast(? as varchar) where \"entity_named_note_type\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(4, true);
    verify(preparedStatement).setInt(5, 1);
    verify(preparedStatement).setLong(7, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeDao#update(long, EntityNamedNoteTypeChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteTypeDao#update(long,
   * EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(long, EntityNamedNoteTypeChangeCommand); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityNamedNoteTypeDao.update(long, EntityNamedNoteTypeChangeCommand)"
  })
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsFirebird() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    EntityNamedNoteTypeDao entityNamedNoteTypeDao = new EntityNamedNoteTypeDao(dsl);

    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act
    boolean actualUpdateResult =
        entityNamedNoteTypeDao.update(
            1L, externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"entity_named_note_type\" set \"entity_named_note_type\".\"applicable_entity_kinds\" = cast(? as varchar(4000)), \"entity_named_note_type\".\"name\" = cast(? as varchar(4)), \"entity_named_note_type\".\"description\" = cast(? as varchar(43)), \"entity_named_note_type\".\"is_readonly\" = cast(? as boolean), \"entity_named_note_type\".\"position\" = cast(? as integer), \"entity_named_note_type\".\"external_id\" = cast(? as varchar(2)) where \"entity_named_note_type\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(4, true);
    verify(preparedStatement).setInt(5, 1);
    verify(preparedStatement).setLong(7, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeDao#update(long, EntityNamedNoteTypeChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteTypeDao#update(long,
   * EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(long, EntityNamedNoteTypeChangeCommand); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityNamedNoteTypeDao.update(long, EntityNamedNoteTypeChangeCommand)"
  })
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    EntityNamedNoteTypeDao entityNamedNoteTypeDao = new EntityNamedNoteTypeDao(dsl);

    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act
    boolean actualUpdateResult =
        entityNamedNoteTypeDao.update(
            1L, externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"entity_named_note_type\" set \"entity_named_note_type\".\"applicable_entity_kinds\" = ?, \"entity_named_note_type\".\"name\" = ?, \"entity_named_note_type\".\"description\" = ?, \"entity_named_note_type\".\"is_readonly\" = ?, \"entity_named_note_type\".\"position\" = ?, \"entity_named_note_type\".\"external_id\" = ? where \"entity_named_note_type\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(4, true);
    verify(preparedStatement).setInt(5, 1);
    verify(preparedStatement).setLong(7, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeDao#update(long, EntityNamedNoteTypeChangeCommand)}.
   *
   * <ul>
   *   <li>Given of one.
   *   <li>When {@link EntityNamedNoteTypeChangeCommand} {@link
   *       EntityNamedNoteTypeChangeCommand#externalId()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteTypeDao#update(long,
   * EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(long, EntityNamedNoteTypeChangeCommand); given of one; when EntityNamedNoteTypeChangeCommand externalId() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityNamedNoteTypeDao.update(long, EntityNamedNoteTypeChangeCommand)"
  })
  void testUpdate_givenOfOne_whenEntityNamedNoteTypeChangeCommandExternalIdReturnEmpty()
      throws DataAccessException {
    // Arrange
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);

    EntityNamedNoteTypeChangeCommand command = mock(EntityNamedNoteTypeChangeCommand.class);
    Optional<Set<EntityKind>> ofResult = Optional.of(new HashSet<>());
    when(command.applicableEntityKinds()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(command.description()).thenReturn(emptyResult);
    Optional<String> emptyResult2 = Optional.empty();
    when(command.externalId()).thenReturn(emptyResult2);
    Optional<Boolean> ofResult2 = Optional.of(true);
    when(command.isReadOnly()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(command.name()).thenReturn(ofResult3);
    Optional<Integer> ofResult4 = Optional.of(1);
    when(command.position()).thenReturn(ofResult4);

    // Act
    boolean actualUpdateResult = entityNamedNoteTypeDao.update(1L, command);

    // Assert
    verify(command).applicableEntityKinds();
    verify(command).description();
    verify(command).externalId();
    verify(command).isReadOnly();
    verify(command).name();
    verify(command).position();
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeDao#update(long, EntityNamedNoteTypeChangeCommand)}.
   *
   * <ul>
   *   <li>Given of one.
   *   <li>When {@link EntityNamedNoteTypeChangeCommand} {@link
   *       EntityNamedNoteTypeChangeCommand#externalId()} return of {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteTypeDao#update(long,
   * EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(long, EntityNamedNoteTypeChangeCommand); given of one; when EntityNamedNoteTypeChangeCommand externalId() return of 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityNamedNoteTypeDao.update(long, EntityNamedNoteTypeChangeCommand)"
  })
  void testUpdate_givenOfOne_whenEntityNamedNoteTypeChangeCommandExternalIdReturnOfFoo()
      throws DataAccessException {
    // Arrange
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);

    EntityNamedNoteTypeChangeCommand command = mock(EntityNamedNoteTypeChangeCommand.class);
    Optional<Set<EntityKind>> ofResult = Optional.of(new HashSet<>());
    when(command.applicableEntityKinds()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(command.description()).thenReturn(emptyResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(command.externalId()).thenReturn(ofResult2);
    Optional<Boolean> ofResult3 = Optional.of(true);
    when(command.isReadOnly()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(command.name()).thenReturn(ofResult4);
    Optional<Integer> ofResult5 = Optional.of(1);
    when(command.position()).thenReturn(ofResult5);

    // Act
    boolean actualUpdateResult = entityNamedNoteTypeDao.update(1L, command);

    // Assert
    verify(command).applicableEntityKinds();
    verify(command).description();
    verify(command).externalId();
    verify(command).isReadOnly();
    verify(command).name();
    verify(command).position();
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeDao#update(long, EntityNamedNoteTypeChangeCommand)}.
   *
   * <ul>
   *   <li>Given of one.
   *   <li>When {@link EntityNamedNoteTypeChangeCommand} {@link
   *       EntityNamedNoteTypeChangeCommand#name()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteTypeDao#update(long,
   * EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(long, EntityNamedNoteTypeChangeCommand); given of one; when EntityNamedNoteTypeChangeCommand name() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityNamedNoteTypeDao.update(long, EntityNamedNoteTypeChangeCommand)"
  })
  void testUpdate_givenOfOne_whenEntityNamedNoteTypeChangeCommandNameReturnEmpty()
      throws DataAccessException {
    // Arrange
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);

    EntityNamedNoteTypeChangeCommand command = mock(EntityNamedNoteTypeChangeCommand.class);
    Optional<Set<EntityKind>> ofResult = Optional.of(new HashSet<>());
    when(command.applicableEntityKinds()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(command.description()).thenReturn(emptyResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(command.externalId()).thenReturn(ofResult2);
    Optional<Boolean> ofResult3 = Optional.of(true);
    when(command.isReadOnly()).thenReturn(ofResult3);
    Optional<String> emptyResult2 = Optional.empty();
    when(command.name()).thenReturn(emptyResult2);
    Optional<Integer> ofResult4 = Optional.of(1);
    when(command.position()).thenReturn(ofResult4);

    // Act
    boolean actualUpdateResult = entityNamedNoteTypeDao.update(1L, command);

    // Assert
    verify(command).applicableEntityKinds();
    verify(command).description();
    verify(command).externalId();
    verify(command).isReadOnly();
    verify(command).name();
    verify(command).position();
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeDao#update(long, EntityNamedNoteTypeChangeCommand)}.
   *
   * <ul>
   *   <li>When {@link EntityNamedNoteTypeChangeCommand} {@link
   *       EntityNamedNoteTypeChangeCommand#position()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteTypeDao#update(long,
   * EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(long, EntityNamedNoteTypeChangeCommand); when EntityNamedNoteTypeChangeCommand position() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityNamedNoteTypeDao.update(long, EntityNamedNoteTypeChangeCommand)"
  })
  void testUpdate_whenEntityNamedNoteTypeChangeCommandPositionReturnEmpty()
      throws DataAccessException {
    // Arrange
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);

    EntityNamedNoteTypeChangeCommand command = mock(EntityNamedNoteTypeChangeCommand.class);
    Optional<Set<EntityKind>> ofResult = Optional.of(new HashSet<>());
    when(command.applicableEntityKinds()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(command.description()).thenReturn(emptyResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(command.externalId()).thenReturn(ofResult2);
    Optional<Boolean> ofResult3 = Optional.of(true);
    when(command.isReadOnly()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(command.name()).thenReturn(ofResult4);
    Optional<Integer> emptyResult2 = Optional.empty();
    when(command.position()).thenReturn(emptyResult2);

    // Act
    boolean actualUpdateResult = entityNamedNoteTypeDao.update(1L, command);

    // Assert
    verify(command).applicableEntityKinds();
    verify(command).description();
    verify(command).externalId();
    verify(command).isReadOnly();
    verify(command).name();
    verify(command).position();
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    assertTrue(actualUpdateResult);
  }
}
