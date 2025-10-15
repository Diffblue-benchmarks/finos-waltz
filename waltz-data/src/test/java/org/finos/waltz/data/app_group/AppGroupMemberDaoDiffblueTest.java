package org.finos.waltz.data.app_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.app_group.AppGroupMember;
import org.finos.waltz.model.app_group.AppGroupMemberRole;
import org.finos.waltz.schema.tables.records.ApplicationGroupMemberRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.InsertOnDuplicateSetMoreStep;
import org.jooq.InsertOnDuplicateSetStep;
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
class AppGroupMemberDaoDiffblueTest {
  @InjectMocks private AppGroupMemberDao appGroupMemberDao;

  @Mock private DSLContext dSLContext;

  /**
   * Test {@link AppGroupMemberDao#getMembers(long)}.
   *
   * <p>Method under test: {@link AppGroupMemberDao#getMembers(long)}
   */
  @Test
  @DisplayName("Test getMembers(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AppGroupMemberDao.getMembers(long)"})
  void testGetMembers() throws DataAccessException {
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
    Set<AppGroupMember> actualMembers = appGroupMemberDao.getMembers(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualMembers.isEmpty());
  }

  /**
   * Test {@link AppGroupMemberDao#register(long, String)} with {@code groupId}, {@code userId}.
   *
   * <p>Method under test: {@link AppGroupMemberDao#register(long, String)}
   */
  @Test
  @DisplayName("Test register(long, String) with 'groupId', 'userId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupMemberDao.register(long, String)"})
  void testRegisterWithGroupIdUserId() throws DataAccessException {
    // Arrange
    InsertOnDuplicateSetMoreStep<ApplicationGroupMemberRecord> insertOnDuplicateSetMoreStep =
        mock(InsertOnDuplicateSetMoreStep.class);
    when(insertOnDuplicateSetMoreStep.execute()).thenReturn(1);

    InsertOnDuplicateSetStep<ApplicationGroupMemberRecord> insertOnDuplicateSetStep =
        mock(InsertOnDuplicateSetStep.class);
    when(insertOnDuplicateSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertOnDuplicateSetMoreStep);

    InsertSetMoreStep<ApplicationGroupMemberRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyUpdate()).thenReturn(insertOnDuplicateSetStep);

    InsertSetMoreStep<ApplicationGroupMemberRecord> insertSetMoreStep2 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<ApplicationGroupMemberRecord> insertSetMoreStep3 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetStep<ApplicationGroupMemberRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);
    when(dSLContext.insertInto(Mockito.<Table<ApplicationGroupMemberRecord>>any()))
        .thenReturn(insertSetStep);

    // Act
    int actualRegisterResult = appGroupMemberDao.register(1L, "42");

    // Assert
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertOnDuplicateSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).onDuplicateKeyUpdate();
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertOnDuplicateSetMoreStep).execute();
    assertEquals(1, actualRegisterResult);
  }

  /**
   * Test {@link AppGroupMemberDao#register(long, String, AppGroupMemberRole)} with {@code groupId},
   * {@code userId}, {@code role}.
   *
   * <p>Method under test: {@link AppGroupMemberDao#register(long, String, AppGroupMemberRole)}
   */
  @Test
  @DisplayName("Test register(long, String, AppGroupMemberRole) with 'groupId', 'userId', 'role'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupMemberDao.register(long, String, AppGroupMemberRole)"})
  void testRegisterWithGroupIdUserIdRole() throws DataAccessException {
    // Arrange
    InsertOnDuplicateSetMoreStep<ApplicationGroupMemberRecord> insertOnDuplicateSetMoreStep =
        mock(InsertOnDuplicateSetMoreStep.class);
    when(insertOnDuplicateSetMoreStep.execute()).thenReturn(1);

    InsertOnDuplicateSetStep<ApplicationGroupMemberRecord> insertOnDuplicateSetStep =
        mock(InsertOnDuplicateSetStep.class);
    when(insertOnDuplicateSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertOnDuplicateSetMoreStep);

    InsertSetMoreStep<ApplicationGroupMemberRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyUpdate()).thenReturn(insertOnDuplicateSetStep);

    InsertSetMoreStep<ApplicationGroupMemberRecord> insertSetMoreStep2 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<ApplicationGroupMemberRecord> insertSetMoreStep3 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetStep<ApplicationGroupMemberRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);
    when(dSLContext.insertInto(Mockito.<Table<ApplicationGroupMemberRecord>>any()))
        .thenReturn(insertSetStep);

    // Act
    int actualRegisterResult = appGroupMemberDao.register(1L, "42", AppGroupMemberRole.VIEWER);

    // Assert
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertOnDuplicateSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).onDuplicateKeyUpdate();
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertOnDuplicateSetMoreStep).execute();
    assertEquals(1, actualRegisterResult);
  }

  /**
   * Test {@link AppGroupMemberDao#getSubscriptions(String)}.
   *
   * <p>Method under test: {@link AppGroupMemberDao#getSubscriptions(String)}
   */
  @Test
  @DisplayName("Test getSubscriptions(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AppGroupMemberDao.getSubscriptions(String)"})
  void testGetSubscriptions() throws DataAccessException {
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
    Set<AppGroupMember> actualSubscriptions = appGroupMemberDao.getSubscriptions("42");

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualSubscriptions.isEmpty());
  }

  /**
   * Test {@link AppGroupMemberDao#unregister(long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupMemberDao#unregister(long, String)}
   */
  @Test
  @DisplayName(
      "Test unregister(long, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AppGroupMemberDao.unregister(long, String)"})
  void testUnregister_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    boolean actualUnregisterResult = new AppGroupMemberDao(dsl).unregister(1L, "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"application_group_member\" where (\"application_group_member\".\"user_id\" = cast(? as varchar) and \"application_group_member\".\"group_id\" = cast(? as bigint))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "42");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUnregisterResult);
  }

  /**
   * Test {@link AppGroupMemberDao#unregister(long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupMemberDao#unregister(long, String)}
   */
  @Test
  @DisplayName(
      "Test unregister(long, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AppGroupMemberDao.unregister(long, String)"})
  void testUnregister_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
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

    // Act
    boolean actualUnregisterResult = new AppGroupMemberDao(dsl).unregister(1L, "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"application_group_member\" where (\"application_group_member\".\"user_id\" = ? and \"application_group_member\".\"group_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "42");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUnregisterResult);
  }

  /**
   * Test {@link AppGroupMemberDao#unregister(long, String)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupMemberDao#unregister(long, String)}
   */
  @Test
  @DisplayName(
      "Test unregister(long, String); given DeleteConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AppGroupMemberDao.unregister(long, String)"})
  void testUnregister_givenDeleteConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupMemberRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<ApplicationGroupMemberRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<ApplicationGroupMemberRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<ApplicationGroupMemberRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    boolean actualUnregisterResult = appGroupMemberDao.unregister(1L, "42");

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertTrue(actualUnregisterResult);
  }

  /**
   * Test {@link AppGroupMemberDao#unregister(long, String)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return zero.
   *   <li>Then calls {@link DSLContext#deleteFrom(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupMemberDao#unregister(long, String)}
   */
  @Test
  @DisplayName(
      "Test unregister(long, String); given DeleteConditionStep execute() return zero; then calls deleteFrom(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AppGroupMemberDao.unregister(long, String)"})
  void testUnregister_givenDeleteConditionStepExecuteReturnZero_thenCallsDeleteFrom()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupMemberRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);

    DeleteConditionStep<ApplicationGroupMemberRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<ApplicationGroupMemberRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<ApplicationGroupMemberRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    boolean actualUnregisterResult = appGroupMemberDao.unregister(1L, "42");

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertFalse(actualUnregisterResult);
  }

  /**
   * Test {@link AppGroupMemberDao#canUpdate(long, String)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetchOne()} return {@link
   *       Record1}.
   *   <li>Then calls {@link DSLContext#select(SelectField)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupMemberDao#canUpdate(long, String)}
   */
  @Test
  @DisplayName(
      "Test canUpdate(long, String); given SelectConditionStep fetchOne() return Record1; then calls select(SelectField)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AppGroupMemberDao.canUpdate(long, String)"})
  void testCanUpdate_givenSelectConditionStepFetchOneReturnRecord1_thenCallsSelect()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne()).thenReturn(mock(Record1.class));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record1<Object>> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    boolean actualCanUpdateResult = appGroupMemberDao.canUpdate(1L, "42");

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep).fetchOne();
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualCanUpdateResult);
  }

  /**
   * Test {@link AppGroupMemberDao#canUpdate(long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupMemberDao#canUpdate(long, String)}
   */
  @Test
  @DisplayName("Test canUpdate(long, String); then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AppGroupMemberDao.canUpdate(long, String)"})
  void testCanUpdate_thenCallsPrepareStatement() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualCanUpdateResult = new AppGroupMemberDao(dsl).canUpdate(1L, "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "select ? from \"application_group_member\" where (\"application_group_member\".\"user_id\" = ? and \"application_group_member\".\"group_id\" = ? and \"application_group_member\".\"role\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, true);
    verify(preparedStatement).setLong(3, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualCanUpdateResult);
  }

  /**
   * Test {@link AppGroupMemberDao#canUpdate(long, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then calls {@link DSLContext#select(SelectField)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupMemberDao#canUpdate(long, String)}
   */
  @Test
  @DisplayName("Test canUpdate(long, String); when 'null'; then calls select(SelectField)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AppGroupMemberDao.canUpdate(long, String)"})
  void testCanUpdate_whenNull_thenCallsSelect() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne()).thenReturn(mock(Record1.class));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record1<Object>> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    boolean actualCanUpdateResult = appGroupMemberDao.canUpdate(1L, null);

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep).fetchOne();
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualCanUpdateResult);
  }
}
