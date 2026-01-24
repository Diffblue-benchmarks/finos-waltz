package org.finos.waltz.data.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.schema.tables.records.UserRoleRecord;
import org.jooq.Batch;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.InsertValuesStep2;
import org.jooq.Query;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.TransactionalCallable;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.lambda.tuple.Range;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserRoleDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private UserRoleDao userRoleDao;

  /**
   * Test {@link UserRoleDao#getUserRoles(String)}.
   *
   * <p>Method under test: {@link UserRoleDao#getUserRoles(String)}
   */
  @Test
  @DisplayName("Test getUserRoles(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set UserRoleDao.getUserRoles(String)"})
  void testGetUserRoles() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<Field<Object>>any())).thenReturn(new HashSet<>());

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    Set<String> actualUserRoles = userRoleDao.getUserRoles("janedoe");

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep).fetchSet(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualUserRoles.isEmpty());
  }

  /**
   * Test {@link UserRoleDao#updateRoles(String, Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleDao#updateRoles(String, Set)}
   */
  @Test
  @DisplayName("Test updateRoles(String, Set); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleDao.updateRoles(String, Set)"})
  void testUpdateRoles_whenHashSet() {
    // Arrange
    when(dSLContext.transactionResult(Mockito.<TransactionalCallable<Object>>any())).thenReturn(1);

    // Act
    int actualUpdateRolesResult = userRoleDao.updateRoles("janedoe", new HashSet<>());

    // Assert
    verify(dSLContext).transactionResult(isA(TransactionalCallable.class));
    assertEquals(1, actualUpdateRolesResult);
  }

  /**
   * Test {@link UserRoleDao#updateRoles(String, Set)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleDao#updateRoles(String, Set)}
   */
  @Test
  @DisplayName("Test updateRoles(String, Set); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleDao.updateRoles(String, Set)"})
  void testUpdateRoles_whenNull() {
    // Arrange
    when(dSLContext.transactionResult(Mockito.<TransactionalCallable<Object>>any())).thenReturn(1);

    // Act
    int actualUpdateRolesResult = userRoleDao.updateRoles("janedoe", null);

    // Assert
    verify(dSLContext).transactionResult(isA(TransactionalCallable.class));
    assertEquals(1, actualUpdateRolesResult);
  }

  /**
   * Test {@link UserRoleDao#addRoles(Set)} with {@code usersAndRolesToUpdate}.
   *
   * <p>Method under test: {@link UserRoleDao#addRoles(Set)}
   */
  @Test
  @DisplayName("Test addRoles(Set) with 'usersAndRolesToUpdate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleDao.addRoles(Set)"})
  void testAddRolesWithUsersAndRolesToUpdate() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    InsertValuesStep2<Record, Object, Object> insertValuesStep2 = mock(InsertValuesStep2.class);
    when(insertValuesStep2.values(Mockito.<Object>any(), Mockito.<Object>any()))
        .thenReturn(mock(InsertValuesStep2.class));
    when(dSLContext.insertInto(
            Mockito.<Table<Record>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any()))
        .thenReturn(insertValuesStep2);
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    HashSet<Tuple2<String, String>> usersAndRolesToUpdate = new HashSet<>();
    usersAndRolesToUpdate.add(new Tuple2<>("xs cannot be null", "xs cannot be null"));

    // Act
    int actualAddRolesResult = userRoleDao.addRoles(usersAndRolesToUpdate);

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
    verify(dSLContext).insertInto(isA(Table.class), isA(Field.class), isA(Field.class));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(insertValuesStep2).values(isA(Object.class), isA(Object.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertEquals(0, actualAddRolesResult);
  }

  /**
   * Test {@link UserRoleDao#addRoles(Set)} with {@code usersAndRolesToUpdate}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code 42}.
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleDao#addRoles(Set)}
   */
  @Test
  @DisplayName(
      "Test addRoles(Set) with 'usersAndRolesToUpdate'; given HashSet() add '42'; when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleDao.addRoles(Set)"})
  void testAddRolesWithUsersAndRolesToUpdate_givenHashSetAdd42_whenHashSet()
      throws DataAccessException {
    // Arrange
    HashSet<Object> objectSet = new HashSet<>();
    objectSet.add("42");

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(objectSet);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    int actualAddRolesResult = userRoleDao.addRoles(new HashSet<>());

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertEquals(0, actualAddRolesResult);
  }

  /**
   * Test {@link UserRoleDao#addRoles(Set)} with {@code usersAndRolesToUpdate}.
   *
   * <ul>
   *   <li>Given {@link Range} {@link Range#v1()} return {@code V1}.
   *   <li>Then calls {@link Range#v1()}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleDao#addRoles(Set)}
   */
  @Test
  @DisplayName(
      "Test addRoles(Set) with 'usersAndRolesToUpdate'; given Range v1() return 'V1'; then calls v1()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleDao.addRoles(Set)"})
  void testAddRolesWithUsersAndRolesToUpdate_givenRangeV1ReturnV1_thenCallsV1()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    InsertValuesStep2<Record, Object, Object> insertValuesStep2 = mock(InsertValuesStep2.class);
    when(insertValuesStep2.values(Mockito.<Object>any(), Mockito.<Object>any()))
        .thenReturn(mock(InsertValuesStep2.class));
    when(dSLContext.insertInto(
            Mockito.<Table<Record>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any()))
        .thenReturn(insertValuesStep2);
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    Range<String> range = mock(Range.class);
    when(range.v1()).thenReturn("V1");
    when(range.v2()).thenReturn("V2");

    HashSet<Tuple2<String, String>> usersAndRolesToUpdate = new HashSet<>();
    usersAndRolesToUpdate.add(range);

    // Act
    int actualAddRolesResult = userRoleDao.addRoles(usersAndRolesToUpdate);

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
    verify(dSLContext).insertInto(isA(Table.class), isA(Field.class), isA(Field.class));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(insertValuesStep2).values(isA(Object.class), isA(Object.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(range).v1();
    verify(range).v2();
    assertEquals(0, actualAddRolesResult);
  }

  /**
   * Test {@link UserRoleDao#addRoles(Set)} with {@code usersAndRolesToUpdate}.
   *
   * <ul>
   *   <li>Given {@link Range} {@link Range#v1()} return {@code V1}.
   *   <li>Then calls {@link Range#v1()}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleDao#addRoles(Set)}
   */
  @Test
  @DisplayName(
      "Test addRoles(Set) with 'usersAndRolesToUpdate'; given Range v1() return 'V1'; then calls v1()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleDao.addRoles(Set)"})
  void testAddRolesWithUsersAndRolesToUpdate_givenRangeV1ReturnV1_thenCallsV12()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    InsertValuesStep2<Record, Object, Object> insertValuesStep2 = mock(InsertValuesStep2.class);
    when(insertValuesStep2.values(Mockito.<Object>any(), Mockito.<Object>any()))
        .thenReturn(mock(InsertValuesStep2.class));
    when(dSLContext.insertInto(
            Mockito.<Table<Record>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any()))
        .thenReturn(insertValuesStep2);
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    Range<String> range = mock(Range.class);
    when(range.v1()).thenReturn("V1");
    when(range.v2()).thenReturn("V2");

    HashSet<Tuple2<String, String>> usersAndRolesToUpdate = new HashSet<>();
    usersAndRolesToUpdate.add(new Tuple2<>("xs cannot be null", "xs cannot be null"));
    usersAndRolesToUpdate.add(range);

    // Act
    int actualAddRolesResult = userRoleDao.addRoles(usersAndRolesToUpdate);

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
    verify(dSLContext, atLeast(1)).insertInto(isA(Table.class), isA(Field.class), isA(Field.class));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(insertValuesStep2, atLeast(1)).values(Mockito.<Object>any(), Mockito.<Object>any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(range).v1();
    verify(range).v2();
    assertEquals(0, actualAddRolesResult);
  }

  /**
   * Test {@link UserRoleDao#addRoles(Set)} with {@code usersAndRolesToUpdate}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleDao#addRoles(Set)}
   */
  @Test
  @DisplayName("Test addRoles(Set) with 'usersAndRolesToUpdate'; when HashSet(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleDao.addRoles(Set)"})
  void testAddRolesWithUsersAndRolesToUpdate_whenHashSet_thenReturnZero()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    int actualAddRolesResult = userRoleDao.addRoles(new HashSet<>());

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertEquals(0, actualAddRolesResult);
  }

  /**
   * Test {@link UserRoleDao#removeRoles(Set)} with {@code usersAndRolesToUpdate}.
   *
   * <ul>
   *   <li>Given {@link Tuple2#Tuple2(Object, Object)} with v1 is empty string and {@code V2}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleDao#removeRoles(Set)}
   */
  @Test
  @DisplayName(
      "Test removeRoles(Set) with 'usersAndRolesToUpdate'; given Tuple2(Object, Object) with v1 is empty string and 'V2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleDao.removeRoles(Set)"})
  void testRemoveRolesWithUsersAndRolesToUpdate_givenTuple2WithV1IsEmptyStringAndV2()
      throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    doNothing().when(statement).addBatch(Mockito.<String>any());
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    UserRoleDao userRoleDao = new UserRoleDao(dsl);

    HashSet<Tuple2<String, String>> usersAndRolesToUpdate = new HashSet<>();
    usersAndRolesToUpdate.add(new Tuple2<>("", "V2"));

    // Act
    int actualRemoveRolesResult = userRoleDao.removeRoles(usersAndRolesToUpdate);

    // Assert
    verify(connection).createStatement();
    verify(statement)
        .addBatch(
            "delete from \"user_role\" where (\"user_role\".\"user_name\" = '' and \"user_role\".\"role\" = 'V2')");
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertEquals(0, actualRemoveRolesResult);
  }

  /**
   * Test {@link UserRoleDao#removeRoles(Set)} with {@code usersAndRolesToUpdate}.
   *
   * <ul>
   *   <li>Then calls {@link Statement#addBatch(String)}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleDao#removeRoles(Set)}
   */
  @Test
  @DisplayName("Test removeRoles(Set) with 'usersAndRolesToUpdate'; then calls addBatch(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleDao.removeRoles(Set)"})
  void testRemoveRolesWithUsersAndRolesToUpdate_thenCallsAddBatch() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    doNothing().when(statement).addBatch(Mockito.<String>any());
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    UserRoleDao userRoleDao = new UserRoleDao(dsl);

    HashSet<Tuple2<String, String>> usersAndRolesToUpdate = new HashSet<>();
    usersAndRolesToUpdate.add(new Tuple2<>("V1", "V2"));

    // Act
    int actualRemoveRolesResult = userRoleDao.removeRoles(usersAndRolesToUpdate);

    // Assert
    verify(connection).createStatement();
    verify(statement)
        .addBatch(
            "delete from \"user_role\" where (\"user_role\".\"user_name\" = 'V1' and \"user_role\".\"role\" = 'V2')");
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertEquals(0, actualRemoveRolesResult);
  }

  /**
   * Test {@link UserRoleDao#removeRoles(Set)} with {@code usersAndRolesToUpdate}.
   *
   * <ul>
   *   <li>Then calls {@link DeleteConditionStep#and(Condition)}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleDao#removeRoles(Set)}
   */
  @Test
  @DisplayName("Test removeRoles(Set) with 'usersAndRolesToUpdate'; then calls and(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleDao.removeRoles(Set)"})
  void testRemoveRolesWithUsersAndRolesToUpdate_thenCallsAnd() throws DataAccessException {
    // Arrange
    DeleteConditionStep<UserRoleRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.and(Mockito.<Condition>any()))
        .thenReturn(mock(DeleteConditionStep.class));

    DeleteUsingStep<UserRoleRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    when(dsl.deleteFrom(Mockito.<Table<UserRoleRecord>>any())).thenReturn(deleteUsingStep);
    UserRoleDao userRoleDao = new UserRoleDao(dsl);

    Range<String> range = mock(Range.class);
    when(range.v1()).thenReturn("V1");
    when(range.v2()).thenReturn("V2");

    HashSet<Tuple2<String, String>> usersAndRolesToUpdate = new HashSet<>();
    usersAndRolesToUpdate.add(range);

    // Act
    int actualRemoveRolesResult = userRoleDao.removeRoles(usersAndRolesToUpdate);

    // Assert
    verify(batch).execute();
    verify(deleteConditionStep).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(dsl).batch(isA(Collection.class));
    verify(dsl).deleteFrom(isA(Table.class));
    verify(range).v1();
    verify(range).v2();
    assertEquals(0, actualRemoveRolesResult);
  }

  /**
   * Test {@link UserRoleDao#removeRoles(Set)} with {@code usersAndRolesToUpdate}.
   *
   * <ul>
   *   <li>Then calls {@link DeleteConditionStep#and(Condition)}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleDao#removeRoles(Set)}
   */
  @Test
  @DisplayName("Test removeRoles(Set) with 'usersAndRolesToUpdate'; then calls and(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleDao.removeRoles(Set)"})
  void testRemoveRolesWithUsersAndRolesToUpdate_thenCallsAnd2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<UserRoleRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.and(Mockito.<Condition>any()))
        .thenReturn(mock(DeleteConditionStep.class));

    DeleteUsingStep<UserRoleRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    when(dsl.deleteFrom(Mockito.<Table<UserRoleRecord>>any())).thenReturn(deleteUsingStep);
    UserRoleDao userRoleDao = new UserRoleDao(dsl);

    Range<String> range = mock(Range.class);
    when(range.v1()).thenReturn("V1");
    when(range.v2()).thenReturn("V2");

    HashSet<Tuple2<String, String>> usersAndRolesToUpdate = new HashSet<>();
    usersAndRolesToUpdate.add(new Tuple2<>("V1", "V2"));
    usersAndRolesToUpdate.add(range);

    // Act
    int actualRemoveRolesResult = userRoleDao.removeRoles(usersAndRolesToUpdate);

    // Assert
    verify(batch).execute();
    verify(deleteConditionStep, atLeast(1)).and(isA(Condition.class));
    verify(deleteUsingStep, atLeast(1)).where(isA(Condition.class));
    verify(dsl).batch(isA(Collection.class));
    verify(dsl, atLeast(1)).deleteFrom(isA(Table.class));
    verify(range).v1();
    verify(range).v2();
    assertEquals(0, actualRemoveRolesResult);
  }

  /**
   * Test {@link UserRoleDao#removeRoles(Set)} with {@code usersAndRolesToUpdate}.
   *
   * <ul>
   *   <li>Then calls {@link DSLContext#batch(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleDao#removeRoles(Set)}
   */
  @Test
  @DisplayName("Test removeRoles(Set) with 'usersAndRolesToUpdate'; then calls batch(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleDao.removeRoles(Set)"})
  void testRemoveRolesWithUsersAndRolesToUpdate_thenCallsBatch() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    // Act
    int actualRemoveRolesResult = userRoleDao.removeRoles(new HashSet<>());

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
    assertEquals(0, actualRemoveRolesResult);
  }

  /**
   * Test {@link UserRoleDao#removeRoles(Set)} with {@code usersAndRolesToUpdate}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then calls {@link Connection#createStatement()}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleDao#removeRoles(Set)}
   */
  @Test
  @DisplayName(
      "Test removeRoles(Set) with 'usersAndRolesToUpdate'; when HashSet(); then calls createStatement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleDao.removeRoles(Set)"})
  void testRemoveRolesWithUsersAndRolesToUpdate_whenHashSet_thenCallsCreateStatement()
      throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    UserRoleDao userRoleDao = new UserRoleDao(dsl);

    // Act
    int actualRemoveRolesResult = userRoleDao.removeRoles(new HashSet<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertEquals(0, actualRemoveRolesResult);
  }

  /**
   * Test {@link UserRoleDao#replaceRoles(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleDao#replaceRoles(Set)}
   */
  @Test
  @DisplayName("Test replaceRoles(Set); when HashSet(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleDao.replaceRoles(Set)"})
  void testReplaceRoles_whenHashSet_thenReturnOne() {
    // Arrange
    when(dSLContext.transactionResult(Mockito.<TransactionalCallable<Object>>any())).thenReturn(1);

    // Act
    int actualReplaceRolesResult = userRoleDao.replaceRoles(new HashSet<>());

    // Assert
    verify(dSLContext).transactionResult(isA(TransactionalCallable.class));
    assertEquals(1, actualReplaceRolesResult);
  }

  /**
   * Test {@link UserRoleDao#replaceRoles(Set)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleDao#replaceRoles(Set)}
   */
  @Test
  @DisplayName("Test replaceRoles(Set); when 'null'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleDao.replaceRoles(Set)"})
  void testReplaceRoles_whenNull_thenReturnOne() {
    // Arrange
    when(dSLContext.transactionResult(Mockito.<TransactionalCallable<Object>>any())).thenReturn(1);

    // Act
    int actualReplaceRolesResult = userRoleDao.replaceRoles(null);

    // Assert
    verify(dSLContext).transactionResult(isA(TransactionalCallable.class));
    assertEquals(1, actualReplaceRolesResult);
  }
}
