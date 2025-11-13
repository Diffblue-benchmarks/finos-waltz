package org.finos.waltz.data.app_group;

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
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.app_group.AppGroupEntry;
import org.finos.waltz.schema.tables.records.ApplicationGroupOuEntryRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.InsertReturningStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Record;
import org.jooq.Record3;
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

class AppGroupOrganisationalUnitDaoDiffblueTest {
  /**
   * Test {@link AppGroupOrganisationalUnitDao#getEntriesForGroup(long)}.
   *
   * <p>Method under test: {@link AppGroupOrganisationalUnitDao#getEntriesForGroup(long)}
   */
  @Test
  @DisplayName("Test getEntriesForGroup(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupOrganisationalUnitDao.getEntriesForGroup(long)"})
  void testGetEntriesForGroup() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep2 =
        mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep2);

    // Act
    List<AppGroupEntry> actualEntriesForGroup =
        new AppGroupOrganisationalUnitDao(dsl).getEntriesForGroup(1L);

    // Assert
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    assertTrue(actualEntriesForGroup.isEmpty());
  }

  /**
   * Test {@link AppGroupOrganisationalUnitDao#removeOrgUnit(long, long)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>When one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupOrganisationalUnitDao#removeOrgUnit(long, long)}
   */
  @Test
  @DisplayName(
      "Test removeOrgUnit(long, long); given PreparedStatement execute() return 'true'; when one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupOrganisationalUnitDao.removeOrgUnit(long, long)"})
  void testRemoveOrgUnit_givenPreparedStatementExecuteReturnTrue_whenOne_thenReturnZero()
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
    int actualRemoveOrgUnitResult = new AppGroupOrganisationalUnitDao(dsl).removeOrgUnit(1L, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"application_group_ou_entry\" where (\"application_group_ou_entry\".\"group_id\" = ? and \"application_group_ou_entry\".\"org_unit_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveOrgUnitResult);
  }

  /**
   * Test {@link AppGroupOrganisationalUnitDao#removeOrgUnit(long, long)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupOrganisationalUnitDao#removeOrgUnit(long, long)}
   */
  @Test
  @DisplayName("Test removeOrgUnit(long, long); when four; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupOrganisationalUnitDao.removeOrgUnit(long, long)"})
  void testRemoveOrgUnit_whenFour_thenReturnThree() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupOuEntryRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(3);

    DeleteConditionStep<ApplicationGroupOuEntryRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<ApplicationGroupOuEntryRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<ApplicationGroupOuEntryRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    int actualRemoveOrgUnitResult = new AppGroupOrganisationalUnitDao(dsl).removeOrgUnit(4L, 1L);

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(3, actualRemoveOrgUnitResult);
  }

  /**
   * Test {@link AppGroupOrganisationalUnitDao#removeOrgUnit(long, long)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupOrganisationalUnitDao#removeOrgUnit(long, long)}
   */
  @Test
  @DisplayName("Test removeOrgUnit(long, long); when three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupOrganisationalUnitDao.removeOrgUnit(long, long)"})
  void testRemoveOrgUnit_whenThree_thenReturnThree() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupOuEntryRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(3);

    DeleteConditionStep<ApplicationGroupOuEntryRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<ApplicationGroupOuEntryRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<ApplicationGroupOuEntryRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    int actualRemoveOrgUnitResult = new AppGroupOrganisationalUnitDao(dsl).removeOrgUnit(3L, 1L);

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(3, actualRemoveOrgUnitResult);
  }

  /**
   * Test {@link AppGroupOrganisationalUnitDao#removeOrgUnit(long, long)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupOrganisationalUnitDao#removeOrgUnit(long, long)}
   */
  @Test
  @DisplayName("Test removeOrgUnit(long, long); when two; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupOrganisationalUnitDao.removeOrgUnit(long, long)"})
  void testRemoveOrgUnit_whenTwo_thenReturnThree() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupOuEntryRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(3);

    DeleteConditionStep<ApplicationGroupOuEntryRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<ApplicationGroupOuEntryRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<ApplicationGroupOuEntryRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    int actualRemoveOrgUnitResult = new AppGroupOrganisationalUnitDao(dsl).removeOrgUnit(2L, 1L);

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(3, actualRemoveOrgUnitResult);
  }

  /**
   * Test {@link AppGroupOrganisationalUnitDao#addOrgUnit(long, long)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>When one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupOrganisationalUnitDao#addOrgUnit(long, long)}
   */
  @Test
  @DisplayName(
      "Test addOrgUnit(long, long); given PreparedStatement execute() return 'true'; when one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupOrganisationalUnitDao.addOrgUnit(long, long)"})
  void testAddOrgUnit_givenPreparedStatementExecuteReturnTrue_whenOne_thenReturnZero()
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
    int actualAddOrgUnitResult = new AppGroupOrganisationalUnitDao(dsl).addOrgUnit(1L, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"application_group_ou_entry\" (\"group_id\", \"org_unit_id\") select \"t\".\"group_id\", \"t\".\"org_unit_id\" from (select ? \"group_id\", ? \"org_unit_id\" where not exists (select 1 \"one\" from \"application_group_ou_entry\" where (\"application_group_ou_entry\".\"group_id\" = ? and \"application_group_ou_entry\".\"org_unit_id\" = ?))) \"t\"");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualAddOrgUnitResult);
  }

  /**
   * Test {@link AppGroupOrganisationalUnitDao#addOrgUnit(long, long)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupOrganisationalUnitDao#addOrgUnit(long, long)}
   */
  @Test
  @DisplayName("Test addOrgUnit(long, long); when four; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupOrganisationalUnitDao.addOrgUnit(long, long)"})
  void testAddOrgUnit_whenFour_thenReturnThree() throws DataAccessException {
    // Arrange
    InsertReturningStep<ApplicationGroupOuEntryRecord> insertReturningStep =
        mock(InsertReturningStep.class);
    when(insertReturningStep.execute()).thenReturn(3);

    InsertSetMoreStep<ApplicationGroupOuEntryRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyIgnore()).thenReturn(insertReturningStep);

    InsertSetMoreStep<ApplicationGroupOuEntryRecord> insertSetMoreStep2 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetStep<ApplicationGroupOuEntryRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<ApplicationGroupOuEntryRecord>>any()))
        .thenReturn(insertSetStep);

    // Act
    int actualAddOrgUnitResult = new AppGroupOrganisationalUnitDao(dsl).addOrgUnit(4L, 1L);

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep).onDuplicateKeyIgnore();
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertReturningStep).execute();
    assertEquals(3, actualAddOrgUnitResult);
  }

  /**
   * Test {@link AppGroupOrganisationalUnitDao#addOrgUnit(long, long)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupOrganisationalUnitDao#addOrgUnit(long, long)}
   */
  @Test
  @DisplayName("Test addOrgUnit(long, long); when three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupOrganisationalUnitDao.addOrgUnit(long, long)"})
  void testAddOrgUnit_whenThree_thenReturnThree() throws DataAccessException {
    // Arrange
    InsertReturningStep<ApplicationGroupOuEntryRecord> insertReturningStep =
        mock(InsertReturningStep.class);
    when(insertReturningStep.execute()).thenReturn(3);

    InsertSetMoreStep<ApplicationGroupOuEntryRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyIgnore()).thenReturn(insertReturningStep);

    InsertSetMoreStep<ApplicationGroupOuEntryRecord> insertSetMoreStep2 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetStep<ApplicationGroupOuEntryRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<ApplicationGroupOuEntryRecord>>any()))
        .thenReturn(insertSetStep);

    // Act
    int actualAddOrgUnitResult = new AppGroupOrganisationalUnitDao(dsl).addOrgUnit(3L, 1L);

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep).onDuplicateKeyIgnore();
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertReturningStep).execute();
    assertEquals(3, actualAddOrgUnitResult);
  }

  /**
   * Test {@link AppGroupOrganisationalUnitDao#addOrgUnit(long, long)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupOrganisationalUnitDao#addOrgUnit(long, long)}
   */
  @Test
  @DisplayName("Test addOrgUnit(long, long); when two; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupOrganisationalUnitDao.addOrgUnit(long, long)"})
  void testAddOrgUnit_whenTwo_thenReturnThree() throws DataAccessException {
    // Arrange
    InsertReturningStep<ApplicationGroupOuEntryRecord> insertReturningStep =
        mock(InsertReturningStep.class);
    when(insertReturningStep.execute()).thenReturn(3);

    InsertSetMoreStep<ApplicationGroupOuEntryRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyIgnore()).thenReturn(insertReturningStep);

    InsertSetMoreStep<ApplicationGroupOuEntryRecord> insertSetMoreStep2 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetStep<ApplicationGroupOuEntryRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<ApplicationGroupOuEntryRecord>>any()))
        .thenReturn(insertSetStep);

    // Act
    int actualAddOrgUnitResult = new AppGroupOrganisationalUnitDao(dsl).addOrgUnit(2L, 1L);

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep).onDuplicateKeyIgnore();
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertReturningStep).execute();
    assertEquals(3, actualAddOrgUnitResult);
  }
}
