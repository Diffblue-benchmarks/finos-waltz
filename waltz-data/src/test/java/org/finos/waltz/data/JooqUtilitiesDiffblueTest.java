package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.finos.waltz.data.actor.ActorDao;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.flow_classification_rule.FlowClassificationRuleDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.model.CommonTableFields;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableCommonTableFields;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.tally.ImmutableTally;
import org.finos.waltz.model.tally.Tally;
import org.finos.waltz.schema.DefaultSchema;
import org.finos.waltz.schema.tables.AccessLog;
import org.finos.waltz.schema.tables.Actor;
import org.finos.waltz.schema.tables.AllocationScheme;
import org.finos.waltz.schema.tables.Application;
import org.finos.waltz.schema.tables.ApplicationGroup;
import org.finos.waltz.schema.tables.AssessmentDefinition;
import org.finos.waltz.schema.tables.ChangeInitiative;
import org.finos.waltz.schema.tables.ChangeSet;
import org.finos.waltz.schema.tables.ChangeUnit;
import org.finos.waltz.schema.tables.CostKind;
import org.finos.waltz.schema.tables.records.ActorRecord;
import org.finos.waltz.schema.tables.records.AllocationSchemeRecord;
import org.finos.waltz.schema.tables.records.ApplicationGroupRecord;
import org.finos.waltz.schema.tables.records.ApplicationRecord;
import org.finos.waltz.schema.tables.records.AssessmentDefinitionRecord;
import org.finos.waltz.schema.tables.records.ChangeInitiativeRecord;
import org.finos.waltz.schema.tables.records.ChangeLogRecord;
import org.finos.waltz.schema.tables.records.ChangeSetRecord;
import org.finos.waltz.schema.tables.records.ChangeUnitRecord;
import org.finos.waltz.schema.tables.records.CostKindRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.Typed;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultDataType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JooqUtilitiesDiffblueTest {
  /**
   * Test {@link JooqUtilities#calculateStringTallies(DSLContext, Table, Field, Condition)} with {@code dsl}, {@code table}, {@code fieldToTally}, {@code recordsInScopeCondition}.
   * <p>
   * Method under test: {@link JooqUtilities#calculateStringTallies(DSLContext, Table, Field, Condition)}
   */
  @Test
  @DisplayName("Test calculateStringTallies(DSLContext, Table, Field, Condition) with 'dsl', 'table', 'fieldToTally', 'recordsInScopeCondition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List JooqUtilities.calculateStringTallies(DSLContext, Table, Field, Condition)"})
  void testCalculateStringTalliesWithDslTableFieldToTallyRecordsInScopeCondition() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<Tally<String>> actualCalculateStringTalliesResult = JooqUtilities.calculateStringTallies(
        new DefaultDSLContext(connection, SQLDialect.SQL99), ActorDao.actor,
        PhysicalSpecificationDao.owningEntityNameField, ApplicationDao.IS_ACTIVE);

    // Assert
    verify(connection).prepareStatement(eq(
        "select case when \"physical_specification\".\"owning_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"physical_specification\".\"owning_entity_id\") when \"physical_specification\".\"owning_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"physical_specification\".\"owning_entity_id\") end \"owning_name_field\", count(\"owning_name_field\") \"count\" from \"actor\" \"actor\" where (\"application\".\"entity_lifecycle_status\" = 'ACTIVE') group by \"owning_name_field\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(2));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualCalculateStringTalliesResult.size());
    Tally<String> getResult = actualCalculateStringTalliesResult.get(0);
    assertTrue(getResult instanceof ImmutableTally);
    Tally<String> getResult2 = actualCalculateStringTalliesResult.get(1);
    assertTrue(getResult2 instanceof ImmutableTally);
    assertEquals("String", getResult.id());
    assertEquals(1.0d, getResult.count());
    assertEquals(getResult, getResult2);
  }

  /**
   * Test {@link JooqUtilities#calculateStringTallies(Collection, Field)} with {@code records}, {@code fieldToTally}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#calculateStringTallies(Collection, Field)}
   */
  @Test
  @DisplayName("Test calculateStringTallies(Collection, Field) with 'records', 'fieldToTally'; when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List JooqUtilities.calculateStringTallies(Collection, Field)"})
  void testCalculateStringTalliesWithRecordsFieldToTally_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Tally<String>> actualCalculateStringTalliesResult = JooqUtilities.calculateStringTallies(new ArrayList<>(),
        PhysicalSpecificationDao.owningEntityNameField);

    // Assert
    assertTrue(actualCalculateStringTalliesResult.isEmpty());
  }

  /**
   * Test {@link JooqUtilities#calculateLongTallies(DSLContext, Table, Field, Condition)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getInt(int)} return one.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#calculateLongTallies(DSLContext, Table, Field, Condition)}
   */
  @Test
  @DisplayName("Test calculateLongTallies(DSLContext, Table, Field, Condition); given ResultSet getInt(int) return one; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List JooqUtilities.calculateLongTallies(DSLContext, Table, Field, Condition)"})
  void testCalculateLongTallies_givenResultSetGetIntReturnOne_thenReturnSizeIsTwo() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<Tally<Long>> actualCalculateLongTalliesResult = JooqUtilities.calculateLongTallies(
        new DefaultDSLContext(connection, SQLDialect.SQL99), ActorDao.actor, FlowClassificationRuleDao.vantagePointId,
        ApplicationDao.IS_ACTIVE);

    // Assert
    verify(connection).prepareStatement(eq(
        "select coalesce(\"ehOrgUnit\".\"id\", \"flow_classification_rule\".\"parent_id\"), count(coalesce(\"ehOrgUnit\".\"id\", \"flow_classification_rule\".\"parent_id\")) \"count\" from \"actor\" \"actor\" where (\"application\".\"entity_lifecycle_status\" = 'ACTIVE') group by coalesce(\"ehOrgUnit\".\"id\", \"flow_classification_rule\".\"parent_id\")"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(2));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualCalculateLongTalliesResult.size());
    Tally<Long> getResult = actualCalculateLongTalliesResult.get(0);
    assertTrue(getResult instanceof ImmutableTally);
    Tally<Long> getResult2 = actualCalculateLongTalliesResult.get(1);
    assertTrue(getResult2 instanceof ImmutableTally);
    assertEquals(1.0d, getResult.count());
    assertEquals(1L, getResult.id().longValue());
    assertEquals(getResult, getResult2);
  }

  /**
   * Test {@link JooqUtilities#safeGet(Record, Field, Object)}.
   * <p>
   * Method under test: {@link JooqUtilities#safeGet(Record, Field, Object)}
   */
  @Test
  @DisplayName("Test safeGet(Record, Field, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JooqUtilities.safeGet(Record, Field, Object)"})
  void testSafeGet() throws IllegalArgumentException {
    // Arrange
    Record r = mock(Record.class);
    when(r.getValue(Mockito.<Field<Object>>any())).thenReturn("Value");

    // Act
    Object actualSafeGetResult = JooqUtilities.safeGet(r, mock(Field.class), "Dflt");

    // Assert
    verify(r).getValue(isA(Field.class));
    assertEquals("Value", actualSafeGetResult);
  }

  /**
   * Test {@link JooqUtilities#isPostgres(SQLDialect)}.
   * <ul>
   *   <li>When {@link SQLDialect#POSTGRES}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#isPostgres(SQLDialect)}
   */
  @Test
  @DisplayName("Test isPostgres(SQLDialect); when POSTGRES; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JooqUtilities.isPostgres(SQLDialect)"})
  void testIsPostgres_whenPostgres_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JooqUtilities.isPostgres(SQLDialect.POSTGRES));
  }

  /**
   * Test {@link JooqUtilities#isPostgres(SQLDialect)}.
   * <ul>
   *   <li>When {@code SQL99}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#isPostgres(SQLDialect)}
   */
  @Test
  @DisplayName("Test isPostgres(SQLDialect); when 'SQL99'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JooqUtilities.isPostgres(SQLDialect)"})
  void testIsPostgres_whenSql99_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(JooqUtilities.isPostgres(SQLDialect.SQL99));
  }

  /**
   * Test {@link JooqUtilities#isMariaDB(SQLDialect)}.
   * <ul>
   *   <li>When {@link SQLDialect#MARIADB}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#isMariaDB(SQLDialect)}
   */
  @Test
  @DisplayName("Test isMariaDB(SQLDialect); when MARIADB; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JooqUtilities.isMariaDB(SQLDialect)"})
  void testIsMariaDB_whenMariadb_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JooqUtilities.isMariaDB(SQLDialect.MARIADB));
  }

  /**
   * Test {@link JooqUtilities#isMariaDB(SQLDialect)}.
   * <ul>
   *   <li>When {@code SQL99}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#isMariaDB(SQLDialect)}
   */
  @Test
  @DisplayName("Test isMariaDB(SQLDialect); when 'SQL99'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JooqUtilities.isMariaDB(SQLDialect)"})
  void testIsMariaDB_whenSql99_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(JooqUtilities.isMariaDB(SQLDialect.SQL99));
  }

  /**
   * Test {@link JooqUtilities#isSQLServer(SQLDialect)}.
   * <p>
   * Method under test: {@link JooqUtilities#isSQLServer(SQLDialect)}
   */
  @Test
  @DisplayName("Test isSQLServer(SQLDialect)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JooqUtilities.isSQLServer(SQLDialect)"})
  void testIsSQLServer() {
    // Arrange, Act and Assert
    assertFalse(JooqUtilities.isSQLServer(SQLDialect.SQL99));
  }

  /**
   * Test {@link JooqUtilities#mkEndOfLifeStatusDerivedField(Field)}.
   * <p>
   * Method under test: {@link JooqUtilities#mkEndOfLifeStatusDerivedField(Field)}
   */
  @Test
  @DisplayName("Test mkEndOfLifeStatusDerivedField(Field)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Field JooqUtilities.mkEndOfLifeStatusDerivedField(Field)"})
  void testMkEndOfLifeStatusDerivedField() {
    // Arrange
    Field<Date> endOfLifeDateField = mock(Field.class);
    when(endOfLifeDateField.lt(Mockito.<Field<Date>>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    // Act
    JooqUtilities.mkEndOfLifeStatusDerivedField(endOfLifeDateField);

    // Assert
    verify(endOfLifeDateField).lt(isA(Field.class));
  }

  /**
   * Test {@link JooqUtilities#mkBasicTermSearch(Field, List)}.
   * <ul>
   *   <li>Given {@link ApplicationDao#IS_ACTIVE}.</li>
   *   <li>Then calls {@link Field#containsIgnoreCase(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#mkBasicTermSearch(Field, List)}
   */
  @Test
  @DisplayName("Test mkBasicTermSearch(Field, List); given IS_ACTIVE; then calls containsIgnoreCase(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition JooqUtilities.mkBasicTermSearch(Field, List)"})
  void testMkBasicTermSearch_givenIs_active_thenCallsContainsIgnoreCase() {
    // Arrange
    Field<String> field = mock(Field.class);
    when(field.containsIgnoreCase(Mockito.<String>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    ArrayList<String> terms = new ArrayList<>();
    terms.add("foo");

    // Act
    JooqUtilities.mkBasicTermSearch(field, terms);

    // Assert
    verify(field).containsIgnoreCase(eq("foo"));
  }

  /**
   * Test {@link JooqUtilities#mkStartsWithTermSearch(Field, List)}.
   * <ul>
   *   <li>Given {@link ApplicationDao#IS_ACTIVE}.</li>
   *   <li>Then calls {@link Field#startsWithIgnoreCase(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#mkStartsWithTermSearch(Field, List)}
   */
  @Test
  @DisplayName("Test mkStartsWithTermSearch(Field, List); given IS_ACTIVE; then calls startsWithIgnoreCase(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition JooqUtilities.mkStartsWithTermSearch(Field, List)"})
  void testMkStartsWithTermSearch_givenIs_active_thenCallsStartsWithIgnoreCase() {
    // Arrange
    Field<String> field = mock(Field.class);
    when(field.startsWithIgnoreCase(Mockito.<String>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    ArrayList<String> terms = new ArrayList<>();
    terms.add("foo");

    // Act
    JooqUtilities.mkStartsWithTermSearch(field, terms);

    // Assert
    verify(field).startsWithIgnoreCase(eq("foo"));
  }

  /**
   * Test {@link JooqUtilities#mkDateRangeCondition(TableField, Date)}.
   * <ul>
   *   <li>Given {@link Condition} {@link Condition#and(Condition)} return {@link ApplicationDao#IS_ACTIVE}.</li>
   *   <li>Then calls {@link Condition#and(Condition)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#mkDateRangeCondition(TableField, Date)}
   */
  @Test
  @DisplayName("Test mkDateRangeCondition(TableField, Date); given Condition and(Condition) return IS_ACTIVE; then calls and(Condition)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition JooqUtilities.mkDateRangeCondition(TableField, Date)"})
  void testMkDateRangeCondition_givenConditionAndReturnIs_active_thenCallsAnd() {
    // Arrange
    Condition condition = mock(Condition.class);
    when(condition.and(Mockito.<Condition>any())).thenReturn(ApplicationDao.IS_ACTIVE);
    TableField<ChangeLogRecord, Timestamp> field = mock(TableField.class);
    when(field.ge(Mockito.<Timestamp>any())).thenReturn(condition);
    when(field.lt(Mockito.<Timestamp>any())).thenReturn(ApplicationDao.IS_ACTIVE);
    Date date = mock(Date.class);
    when(date.getTime()).thenReturn(10L);

    // Act
    JooqUtilities.mkDateRangeCondition(field, date);

    // Assert
    verify(date, atLeast(1)).getTime();
    verify(condition).and(isA(Condition.class));
    verify(field).ge(isA(Timestamp.class));
    verify(field).lt(isA(Timestamp.class));
  }

  /**
   * Test {@link JooqUtilities#mkDateRangeCondition(TableField, Date, Date)}.
   * <ul>
   *   <li>Given {@link Condition} {@link Condition#and(Condition)} return {@link ApplicationDao#IS_ACTIVE}.</li>
   *   <li>Then calls {@link Condition#and(Condition)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#mkDateRangeCondition(TableField, Date, Date)}
   */
  @Test
  @DisplayName("Test mkDateRangeCondition(TableField, Date, Date); given Condition and(Condition) return IS_ACTIVE; then calls and(Condition)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition JooqUtilities.mkDateRangeCondition(TableField, Date, Date)"})
  void testMkDateRangeCondition_givenConditionAndReturnIs_active_thenCallsAnd2() {
    // Arrange
    Condition condition = mock(Condition.class);
    when(condition.and(Mockito.<Condition>any())).thenReturn(ApplicationDao.IS_ACTIVE);
    TableField<ChangeLogRecord, Timestamp> field = mock(TableField.class);
    when(field.ge(Mockito.<Timestamp>any())).thenReturn(condition);
    when(field.lt(Mockito.<Timestamp>any())).thenReturn(ApplicationDao.IS_ACTIVE);
    Date startDate = mock(Date.class);
    when(startDate.getTime()).thenReturn(10L);
    Date endDate = mock(Date.class);
    when(endDate.getTime()).thenReturn(10L);

    // Act
    JooqUtilities.mkDateRangeCondition(field, startDate, endDate);

    // Assert
    verify(startDate).getTime();
    verify(endDate).getTime();
    verify(condition).and(isA(Condition.class));
    verify(field).ge(isA(Timestamp.class));
    verify(field).lt(isA(Timestamp.class));
  }

  /**
   * Test {@link JooqUtilities#mkDateRangeCondition(TableField, Date)}.
   * <ul>
   *   <li>Given {@link Condition} {@link Condition#and(Condition)} return {@link ApplicationDao#IS_ACTIVE}.</li>
   *   <li>Then calls {@link Condition#and(Condition)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#mkDateRangeCondition(TableField, java.util.Date)}
   */
  @Test
  @DisplayName("Test mkDateRangeCondition(TableField, Date); given Condition and(Condition) return IS_ACTIVE; then calls and(Condition)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition JooqUtilities.mkDateRangeCondition(TableField, java.util.Date)"})
  void testMkDateRangeCondition_givenConditionAndReturnIs_active_thenCallsAnd3() {
    // Arrange
    Condition condition = mock(Condition.class);
    when(condition.and(Mockito.<Condition>any())).thenReturn(ApplicationDao.IS_ACTIVE);
    TableField<ChangeLogRecord, Timestamp> field = mock(TableField.class);
    when(field.ge(Mockito.<Timestamp>any())).thenReturn(condition);
    when(field.lt(Mockito.<Timestamp>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    // Act
    JooqUtilities.mkDateRangeCondition(field,
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    verify(condition).and(isA(Condition.class));
    verify(field).ge(isA(Timestamp.class));
    verify(field).lt(isA(Timestamp.class));
  }

  /**
   * Test {@link JooqUtilities#mkDateRangeCondition(TableField, Date)}.
   * <ul>
   *   <li>When {@link TableField} {@link Field#ge(Object)} return {@link ApplicationDao#IS_ACTIVE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#mkDateRangeCondition(TableField, Date)}
   */
  @Test
  @DisplayName("Test mkDateRangeCondition(TableField, Date); when TableField ge(Object) return IS_ACTIVE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition JooqUtilities.mkDateRangeCondition(TableField, Date)"})
  void testMkDateRangeCondition_whenTableFieldGeReturnIs_active() {
    // Arrange
    TableField<ChangeLogRecord, Timestamp> field = mock(TableField.class);
    when(field.ge(Mockito.<Timestamp>any())).thenReturn(ApplicationDao.IS_ACTIVE);
    when(field.lt(Mockito.<Timestamp>any())).thenReturn(ApplicationDao.IS_ACTIVE);
    Date date = mock(Date.class);
    when(date.getTime()).thenReturn(10L);

    // Act
    JooqUtilities.mkDateRangeCondition(field, date);

    // Assert
    verify(date, atLeast(1)).getTime();
    verify(field).ge(isA(Timestamp.class));
    verify(field).lt(isA(Timestamp.class));
  }

  /**
   * Test {@link JooqUtilities#mkDateRangeCondition(TableField, Date, Date)}.
   * <ul>
   *   <li>When {@link TableField} {@link Field#ge(Object)} return {@link ApplicationDao#IS_ACTIVE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#mkDateRangeCondition(TableField, Date, Date)}
   */
  @Test
  @DisplayName("Test mkDateRangeCondition(TableField, Date, Date); when TableField ge(Object) return IS_ACTIVE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition JooqUtilities.mkDateRangeCondition(TableField, Date, Date)"})
  void testMkDateRangeCondition_whenTableFieldGeReturnIs_active2() {
    // Arrange
    TableField<ChangeLogRecord, Timestamp> field = mock(TableField.class);
    when(field.ge(Mockito.<Timestamp>any())).thenReturn(ApplicationDao.IS_ACTIVE);
    when(field.lt(Mockito.<Timestamp>any())).thenReturn(ApplicationDao.IS_ACTIVE);
    Date startDate = mock(Date.class);
    when(startDate.getTime()).thenReturn(10L);
    Date endDate = mock(Date.class);
    when(endDate.getTime()).thenReturn(10L);

    // Act
    JooqUtilities.mkDateRangeCondition(field, startDate, endDate);

    // Assert
    verify(startDate).getTime();
    verify(endDate).getTime();
    verify(field).ge(isA(Timestamp.class));
    verify(field).lt(isA(Timestamp.class));
  }

  /**
   * Test {@link JooqUtilities#mkDateRangeCondition(TableField, Date)}.
   * <ul>
   *   <li>When {@link TableField} {@link Field#ge(Object)} return {@link ApplicationDao#IS_ACTIVE}.</li>
   *   <li>Then calls {@link Field#ge(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#mkDateRangeCondition(TableField, java.util.Date)}
   */
  @Test
  @DisplayName("Test mkDateRangeCondition(TableField, Date); when TableField ge(Object) return IS_ACTIVE; then calls ge(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Condition JooqUtilities.mkDateRangeCondition(TableField, java.util.Date)"})
  void testMkDateRangeCondition_whenTableFieldGeReturnIs_active_thenCallsGe() {
    // Arrange
    TableField<ChangeLogRecord, Timestamp> field = mock(TableField.class);
    when(field.ge(Mockito.<Timestamp>any())).thenReturn(ApplicationDao.IS_ACTIVE);
    when(field.lt(Mockito.<Timestamp>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    // Act
    JooqUtilities.mkDateRangeCondition(field,
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    verify(field).ge(isA(Timestamp.class));
    verify(field).lt(isA(Timestamp.class));
  }

  /**
   * Test {@link JooqUtilities#selectorToCTE(String, GenericSelector)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>Then calls {@link Typed#getDataType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#selectorToCTE(String, GenericSelector)}
   */
  @Test
  @DisplayName("Test selectorToCTE(String, GenericSelector); given 'java.lang.Object'; then calls getDataType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.CommonTableExpression JooqUtilities.selectorToCTE(String, GenericSelector)"})
  void testSelectorToCTE_givenJavaLangObject_thenCallsGetDataType() {
    // Arrange
    Field<Object> field = mock(Field.class);
    Class<Object> type = Object.class;
    when(field.getDataType()).thenReturn(new DefaultDataType<>(SQLDialect.SQL99, type, "Type Name"));

    ArrayList<Field<?>> fieldList = new ArrayList<>();
    fieldList.add(field);
    Select<Record1<Long>> select = mock(Select.class);
    Mockito.<List<Field<?>>>when(select.getSelect()).thenReturn(fieldList);
    GenericSelector genericSelector = mock(GenericSelector.class);
    when(genericSelector.selector()).thenReturn(select);

    // Act
    JooqUtilities.selectorToCTE("Name", genericSelector);

    // Assert
    verify(genericSelector).selector();
    verify(select).getSelect();
    verify(field).getDataType();
  }

  /**
   * Test {@link JooqUtilities#selectorToCTE(String, GenericSelector)}.
   * <ul>
   *   <li>Given {@link Select} {@link Select#getSelect()} return {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link GenericSelector#selector()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#selectorToCTE(String, GenericSelector)}
   */
  @Test
  @DisplayName("Test selectorToCTE(String, GenericSelector); given Select getSelect() return ArrayList(); then calls selector()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.CommonTableExpression JooqUtilities.selectorToCTE(String, GenericSelector)"})
  void testSelectorToCTE_givenSelectGetSelectReturnArrayList_thenCallsSelector() {
    // Arrange
    Select<Record1<Long>> select = mock(Select.class);
    Mockito.<List<Field<?>>>when(select.getSelect()).thenReturn(new ArrayList<>());
    GenericSelector genericSelector = mock(GenericSelector.class);
    when(genericSelector.selector()).thenReturn(select);

    // Act
    JooqUtilities.selectorToCTE("Name", genericSelector);

    // Assert
    verify(genericSelector).selector();
    verify(select).getSelect();
  }

  /**
   * Test {@link JooqUtilities#fieldsWithout(Table, Field[])}.
   * <ul>
   *   <li>Given {@link Name} {@link Name#last()} return {@code Last}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#fieldsWithout(Table, Field[])}
   */
  @Test
  @DisplayName("Test fieldsWithout(Table, Field[]); given Name last() return 'Last'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection JooqUtilities.fieldsWithout(Table, Field[])"})
  void testFieldsWithout_givenNameLastReturnLast_thenReturnSizeIsOne() {
    // Arrange
    Name name = mock(Name.class);
    when(name.last()).thenReturn("Last");
    Name alias = mock(Name.class);
    when(alias.append(Mockito.<Name>any())).thenReturn(name);

    // Act
    Collection<? extends Field<?>> actualFieldsWithoutResult = JooqUtilities.fieldsWithout(new AccessLog(alias),
        mock(Field.class));

    // Assert
    verify(alias, atLeast(1)).append(Mockito.<Name>any());
    verify(name, atLeast(1)).last();
    assertTrue(actualFieldsWithoutResult instanceof Set);
    assertEquals(1, actualFieldsWithoutResult.size());
  }

  /**
   * Test {@link JooqUtilities#fieldsWithout(Table, Field[])}.
   * <ul>
   *   <li>Given {@link Name} {@link Name#last()} return {@code Last}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#fieldsWithout(Table, Field[])}
   */
  @Test
  @DisplayName("Test fieldsWithout(Table, Field[]); given Name last() return 'Last'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection JooqUtilities.fieldsWithout(Table, Field[])"})
  void testFieldsWithout_givenNameLastReturnLast_thenReturnSizeIsOne2() {
    // Arrange
    Name name = mock(Name.class);
    when(name.last()).thenReturn("Last");
    Name alias = mock(Name.class);
    when(alias.append(Mockito.<Name>any())).thenReturn(name);

    // Act
    Collection<? extends Field<?>> actualFieldsWithoutResult = JooqUtilities.fieldsWithout(new AccessLog(alias));

    // Assert
    verify(alias, atLeast(1)).append(Mockito.<Name>any());
    verify(name, atLeast(1)).last();
    assertTrue(actualFieldsWithoutResult instanceof Set);
    assertEquals(1, actualFieldsWithoutResult.size());
  }

  /**
   * Test {@link JooqUtilities#fieldsWithout(Table, Field[])}.
   * <ul>
   *   <li>When {@link AccessLog#AccessLog()}.</li>
   *   <li>Then return size is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#fieldsWithout(Table, Field[])}
   */
  @Test
  @DisplayName("Test fieldsWithout(Table, Field[]); when AccessLog(); then return size is five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection JooqUtilities.fieldsWithout(Table, Field[])"})
  void testFieldsWithout_whenAccessLog_thenReturnSizeIsFive() {
    // Arrange and Act
    Collection<? extends Field<?>> actualFieldsWithoutResult = JooqUtilities.fieldsWithout(new AccessLog(),
        mock(Field.class));

    // Assert
    assertTrue(actualFieldsWithoutResult instanceof Set);
    assertEquals(5, actualFieldsWithoutResult.size());
  }

  /**
   * Test {@link JooqUtilities#fieldsWithout(Table, Field[])}.
   * <ul>
   *   <li>When {@link AccessLog#AccessLog()}.</li>
   *   <li>Then return size is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#fieldsWithout(Table, Field[])}
   */
  @Test
  @DisplayName("Test fieldsWithout(Table, Field[]); when AccessLog(); then return size is five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection JooqUtilities.fieldsWithout(Table, Field[])"})
  void testFieldsWithout_whenAccessLog_thenReturnSizeIsFive2() {
    // Arrange and Act
    Collection<? extends Field<?>> actualFieldsWithoutResult = JooqUtilities.fieldsWithout(new AccessLog(), null);

    // Assert
    assertTrue(actualFieldsWithoutResult instanceof Set);
    assertEquals(5, actualFieldsWithoutResult.size());
  }

  /**
   * Test {@link JooqUtilities#fieldsWithout(Table, Field[])}.
   * <ul>
   *   <li>When {@link Actor#Actor()}.</li>
   *   <li>Then return size is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#fieldsWithout(Table, Field[])}
   */
  @Test
  @DisplayName("Test fieldsWithout(Table, Field[]); when Actor(); then return size is eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection JooqUtilities.fieldsWithout(Table, Field[])"})
  void testFieldsWithout_whenActor_thenReturnSizeIsEight() {
    // Arrange and Act
    Collection<? extends Field<?>> actualFieldsWithoutResult = JooqUtilities.fieldsWithout(new Actor(),
        mock(Field.class));

    // Assert
    assertTrue(actualFieldsWithoutResult instanceof Set);
    assertEquals(8, actualFieldsWithoutResult.size());
  }

  /**
   * Test {@link JooqUtilities#fieldsWithout(Table, Field[])}.
   * <ul>
   *   <li>When {@link AllocationScheme#AllocationScheme()}.</li>
   *   <li>Then return size is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#fieldsWithout(Table, Field[])}
   */
  @Test
  @DisplayName("Test fieldsWithout(Table, Field[]); when AllocationScheme(); then return size is five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection JooqUtilities.fieldsWithout(Table, Field[])"})
  void testFieldsWithout_whenAllocationScheme_thenReturnSizeIsFive() {
    // Arrange and Act
    Collection<? extends Field<?>> actualFieldsWithoutResult = JooqUtilities.fieldsWithout(new AllocationScheme(),
        mock(Field.class));

    // Assert
    assertTrue(actualFieldsWithoutResult instanceof Set);
    assertEquals(5, actualFieldsWithoutResult.size());
  }

  /**
   * Test {@link JooqUtilities#fieldsWithout(Table, Field[])}.
   * <ul>
   *   <li>When {@link ApplicationGroup#ApplicationGroup()}.</li>
   *   <li>Then return size is seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#fieldsWithout(Table, Field[])}
   */
  @Test
  @DisplayName("Test fieldsWithout(Table, Field[]); when ApplicationGroup(); then return size is seven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection JooqUtilities.fieldsWithout(Table, Field[])"})
  void testFieldsWithout_whenApplicationGroup_thenReturnSizeIsSeven() {
    // Arrange and Act
    Collection<? extends Field<?>> actualFieldsWithoutResult = JooqUtilities.fieldsWithout(new ApplicationGroup(),
        mock(Field.class));

    // Assert
    assertTrue(actualFieldsWithoutResult instanceof Set);
    assertEquals(7, actualFieldsWithoutResult.size());
  }

  /**
   * Test {@link JooqUtilities#fieldsWithout(Table, Field[])}.
   * <ul>
   *   <li>When {@link Application#Application()}.</li>
   *   <li>Then return size is eighteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#fieldsWithout(Table, Field[])}
   */
  @Test
  @DisplayName("Test fieldsWithout(Table, Field[]); when Application(); then return size is eighteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection JooqUtilities.fieldsWithout(Table, Field[])"})
  void testFieldsWithout_whenApplication_thenReturnSizeIsEighteen() {
    // Arrange and Act
    Collection<? extends Field<?>> actualFieldsWithoutResult = JooqUtilities.fieldsWithout(new Application(),
        mock(Field.class));

    // Assert
    assertTrue(actualFieldsWithoutResult instanceof Set);
    assertEquals(18, actualFieldsWithoutResult.size());
  }

  /**
   * Test {@link JooqUtilities#fieldsWithout(Table, Field[])}.
   * <ul>
   *   <li>When {@link AssessmentDefinition#AssessmentDefinition()}.</li>
   *   <li>Then return {@link Short#SIZE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#fieldsWithout(Table, Field[])}
   */
  @Test
  @DisplayName("Test fieldsWithout(Table, Field[]); when AssessmentDefinition(); then return SIZE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection JooqUtilities.fieldsWithout(Table, Field[])"})
  void testFieldsWithout_whenAssessmentDefinition_thenReturnSize() {
    // Arrange and Act
    Collection<? extends Field<?>> actualFieldsWithoutResult = JooqUtilities.fieldsWithout(new AssessmentDefinition(),
        mock(Field.class));

    // Assert
    assertTrue(actualFieldsWithoutResult instanceof Set);
    assertEquals(Short.SIZE, actualFieldsWithoutResult.size());
  }

  /**
   * Test {@link JooqUtilities#summarizeResults(int[])}.
   * <p>
   * Method under test: {@link JooqUtilities#summarizeResults(int[])}
   */
  @Test
  @DisplayName("Test summarizeResults(int[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JooqUtilities.summarizeResults(int[])"})
  void testSummarizeResults() {
    // Arrange, Act and Assert
    assertEquals(0, JooqUtilities.summarizeResults(new int[]{1, -1, 1, -1}));
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind, String)} with {@code kind}, {@code alias}.
   * <ul>
   *   <li>Then table return {@link AllocationScheme}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind, String) with 'kind', 'alias'; then table return AllocationScheme")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind, String)"})
  void testDetermineCommonTableFieldsWithKindAlias_thenTableReturnAllocationScheme() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = JooqUtilities
        .determineCommonTableFields(EntityKind.ALLOCATION_SCHEME, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof AllocationScheme);
    assertEquals(1, tableResult.getIndexes().size());
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(1, tableResult.getReferences().size());
    assertEquals(EntityKind.ALLOCATION_SCHEME, actualDetermineCommonTableFieldsResult.entityKind());
    Class<AllocationSchemeRecord> expectedRecordType = AllocationSchemeRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind, String)} with {@code kind}, {@code alias}.
   * <ul>
   *   <li>Then table return {@link Application}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind, String) with 'kind', 'alias'; then table return Application")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind, String)"})
  void testDetermineCommonTableFieldsWithKindAlias_thenTableReturnApplication() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = JooqUtilities
        .determineCommonTableFields(EntityKind.APPLICATION, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof Application);
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(3, tableResult.getIndexes().size());
    assertEquals(EntityKind.APPLICATION, actualDetermineCommonTableFieldsResult.entityKind());
    Class<ApplicationRecord> expectedRecordType = ApplicationRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind, String)} with {@code kind}, {@code alias}.
   * <ul>
   *   <li>Then table return {@link ApplicationGroup}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind, String) with 'kind', 'alias'; then table return ApplicationGroup")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind, String)"})
  void testDetermineCommonTableFieldsWithKindAlias_thenTableReturnApplicationGroup() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = JooqUtilities
        .determineCommonTableFields(EntityKind.APP_GROUP, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof ApplicationGroup);
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(EntityKind.APP_GROUP, actualDetermineCommonTableFieldsResult.entityKind());
    Class<ApplicationGroupRecord> expectedRecordType = ApplicationGroupRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind, String)} with {@code kind}, {@code alias}.
   * <ul>
   *   <li>Then table return {@link AssessmentDefinition}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind, String) with 'kind', 'alias'; then table return AssessmentDefinition")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind, String)"})
  void testDetermineCommonTableFieldsWithKindAlias_thenTableReturnAssessmentDefinition() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = JooqUtilities
        .determineCommonTableFields(EntityKind.ASSESSMENT_DEFINITION, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof AssessmentDefinition);
    assertEquals(1, tableResult.getIndexes().size());
    assertEquals(1, tableResult.getReferences().size());
    assertEquals(2, tableResult.getKeys().size());
    assertEquals(EntityKind.ASSESSMENT_DEFINITION, actualDetermineCommonTableFieldsResult.entityKind());
    Class<AssessmentDefinitionRecord> expectedRecordType = AssessmentDefinitionRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind, String)} with {@code kind}, {@code alias}.
   * <ul>
   *   <li>Then table return {@link ChangeInitiative}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind, String) with 'kind', 'alias'; then table return ChangeInitiative")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind, String)"})
  void testDetermineCommonTableFieldsWithKindAlias_thenTableReturnChangeInitiative() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = JooqUtilities
        .determineCommonTableFields(EntityKind.CHANGE_INITIATIVE, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof ChangeInitiative);
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(EntityKind.CHANGE_INITIATIVE, actualDetermineCommonTableFieldsResult.entityKind());
    Class<ChangeInitiativeRecord> expectedRecordType = ChangeInitiativeRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind, String)} with {@code kind}, {@code alias}.
   * <ul>
   *   <li>When {@code ACTOR}.</li>
   *   <li>Then table return {@link Actor}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind, String) with 'kind', 'alias'; when 'ACTOR'; then table return Actor")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind, String)"})
  void testDetermineCommonTableFieldsWithKindAlias_whenActor_thenTableReturnActor() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = JooqUtilities
        .determineCommonTableFields(EntityKind.ACTOR, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof Actor);
    assertEquals(3, tableResult.getKeys().size());
    assertEquals(EntityKind.ACTOR, actualDetermineCommonTableFieldsResult.entityKind());
    Class<ActorRecord> expectedRecordType = ActorRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind)} with {@code kind}.
   * <ul>
   *   <li>Then table return {@link AllocationScheme}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind) with 'kind'; then table return AllocationScheme")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind)"})
  void testDetermineCommonTableFieldsWithKind_thenTableReturnAllocationScheme() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = JooqUtilities
        .determineCommonTableFields(EntityKind.ALLOCATION_SCHEME);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof AllocationScheme);
    assertEquals(1, tableResult.getIndexes().size());
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(1, tableResult.getReferences().size());
    assertEquals(EntityKind.ALLOCATION_SCHEME, actualDetermineCommonTableFieldsResult.entityKind());
    Class<AllocationSchemeRecord> expectedRecordType = AllocationSchemeRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind)} with {@code kind}.
   * <ul>
   *   <li>Then table return {@link Application}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind) with 'kind'; then table return Application")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind)"})
  void testDetermineCommonTableFieldsWithKind_thenTableReturnApplication() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = JooqUtilities
        .determineCommonTableFields(EntityKind.APPLICATION);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof Application);
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(3, tableResult.getIndexes().size());
    assertEquals(EntityKind.APPLICATION, actualDetermineCommonTableFieldsResult.entityKind());
    Class<ApplicationRecord> expectedRecordType = ApplicationRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind)} with {@code kind}.
   * <ul>
   *   <li>Then table return {@link ApplicationGroup}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind) with 'kind'; then table return ApplicationGroup")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind)"})
  void testDetermineCommonTableFieldsWithKind_thenTableReturnApplicationGroup() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = JooqUtilities
        .determineCommonTableFields(EntityKind.APP_GROUP);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof ApplicationGroup);
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(EntityKind.APP_GROUP, actualDetermineCommonTableFieldsResult.entityKind());
    Class<ApplicationGroupRecord> expectedRecordType = ApplicationGroupRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind)} with {@code kind}.
   * <ul>
   *   <li>Then table return {@link AssessmentDefinition}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind) with 'kind'; then table return AssessmentDefinition")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind)"})
  void testDetermineCommonTableFieldsWithKind_thenTableReturnAssessmentDefinition() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = JooqUtilities
        .determineCommonTableFields(EntityKind.ASSESSMENT_DEFINITION);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof AssessmentDefinition);
    assertEquals(1, tableResult.getIndexes().size());
    assertEquals(1, tableResult.getReferences().size());
    assertEquals(2, tableResult.getKeys().size());
    assertEquals(EntityKind.ASSESSMENT_DEFINITION, actualDetermineCommonTableFieldsResult.entityKind());
    Class<AssessmentDefinitionRecord> expectedRecordType = AssessmentDefinitionRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind)} with {@code kind}.
   * <ul>
   *   <li>Then table return {@link ChangeInitiative}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind) with 'kind'; then table return ChangeInitiative")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind)"})
  void testDetermineCommonTableFieldsWithKind_thenTableReturnChangeInitiative() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = JooqUtilities
        .determineCommonTableFields(EntityKind.CHANGE_INITIATIVE);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof ChangeInitiative);
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(EntityKind.CHANGE_INITIATIVE, actualDetermineCommonTableFieldsResult.entityKind());
    Class<ChangeInitiativeRecord> expectedRecordType = ChangeInitiativeRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind)} with {@code kind}.
   * <ul>
   *   <li>When {@code ACTOR}.</li>
   *   <li>Then table return {@link Actor}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind) with 'kind'; when 'ACTOR'; then table return Actor")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind)"})
  void testDetermineCommonTableFieldsWithKind_whenActor_thenTableReturnActor() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = JooqUtilities
        .determineCommonTableFields(EntityKind.ACTOR);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof Actor);
    assertEquals(3, tableResult.getKeys().size());
    assertEquals(EntityKind.ACTOR, actualDetermineCommonTableFieldsResult.entityKind());
    Class<ActorRecord> expectedRecordType = ActorRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind)} with {@code kind}.
   * <ul>
   *   <li>When {@code CHANGE_SET}.</li>
   *   <li>Then table return {@link ChangeSet}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind) with 'kind'; when 'CHANGE_SET'; then table return ChangeSet")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind)"})
  void testDetermineCommonTableFieldsWithKind_whenChangeSet_thenTableReturnChangeSet() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = JooqUtilities
        .determineCommonTableFields(EntityKind.CHANGE_SET);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof ChangeSet);
    assertEquals(1, tableResult.getIndexes().size());
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(EntityKind.CHANGE_SET, actualDetermineCommonTableFieldsResult.entityKind());
    Class<ChangeSetRecord> expectedRecordType = ChangeSetRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind)} with {@code kind}.
   * <ul>
   *   <li>When {@code CHANGE_UNIT}.</li>
   *   <li>Then table return {@link ChangeUnit}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind) with 'kind'; when 'CHANGE_UNIT'; then table return ChangeUnit")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind)"})
  void testDetermineCommonTableFieldsWithKind_whenChangeUnit_thenTableReturnChangeUnit() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = JooqUtilities
        .determineCommonTableFields(EntityKind.CHANGE_UNIT);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof ChangeUnit);
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(2, tableResult.getIndexes().size());
    assertEquals(EntityKind.CHANGE_UNIT, actualDetermineCommonTableFieldsResult.entityKind());
    Class<ChangeUnitRecord> expectedRecordType = ChangeUnitRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind)} with {@code kind}.
   * <ul>
   *   <li>When {@code COST_KIND}.</li>
   *   <li>Then table return {@link CostKind}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind)}
   */
  @Test
  @DisplayName("Test determineCommonTableFields(EntityKind) with 'kind'; when 'COST_KIND'; then table return CostKind")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind)"})
  void testDetermineCommonTableFieldsWithKind_whenCostKind_thenTableReturnCostKind() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult = JooqUtilities
        .determineCommonTableFields(EntityKind.COST_KIND);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof CostKind);
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(EntityKind.COST_KIND, actualDetermineCommonTableFieldsResult.entityKind());
    Class<CostKindRecord> expectedRecordType = CostKindRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
  }

  /**
   * Test {@link JooqUtilities#loadExternalIdToEntityRefMap(DSLContext, EntityKind, EntityKind)} with {@code dsl}, {@code entityKind}, {@code qualifierKind}.
   * <p>
   * Method under test: {@link JooqUtilities#loadExternalIdToEntityRefMap(DSLContext, EntityKind, EntityKind)}
   */
  @Test
  @DisplayName("Test loadExternalIdToEntityRefMap(DSLContext, EntityKind, EntityKind) with 'dsl', 'entityKind', 'qualifierKind'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JooqUtilities.loadExternalIdToEntityRefMap(DSLContext, EntityKind, EntityKind)"})
  void testLoadExternalIdToEntityRefMapWithDslEntityKindQualifierKind() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Map<String, EntityReference> actualLoadExternalIdToEntityRefMapResult = JooqUtilities.loadExternalIdToEntityRefMap(
        new DefaultDSLContext(connection, SQLDialect.SQL99), EntityKind.ACTOR, EntityKind.ALL);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"actor\".\"external_id\", \"actor\".\"id\", \"actor\".\"name\", \"actor\".\"description\" from \"actor\" where (1 = 1 and \"actor\".\"external_id\" is not null and 1 = 1)"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(2));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualLoadExternalIdToEntityRefMapResult.size());
    EntityReference getResult = actualLoadExternalIdToEntityRefMapResult.get("String");
    assertTrue(getResult instanceof ImmutableEntityReference);
    assertEquals("String", getResult.description());
    assertEquals(1L, getResult.id());
    assertEquals(EntityKind.ACTOR, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
  }

  /**
   * Test {@link JooqUtilities#loadExternalIdToEntityRefMap(DSLContext, EntityKind, EntityKind)} with {@code dsl}, {@code entityKind}, {@code qualifierKind}.
   * <p>
   * Method under test: {@link JooqUtilities#loadExternalIdToEntityRefMap(DSLContext, EntityKind, EntityKind)}
   */
  @Test
  @DisplayName("Test loadExternalIdToEntityRefMap(DSLContext, EntityKind, EntityKind) with 'dsl', 'entityKind', 'qualifierKind'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JooqUtilities.loadExternalIdToEntityRefMap(DSLContext, EntityKind, EntityKind)"})
  void testLoadExternalIdToEntityRefMapWithDslEntityKindQualifierKind2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn(null);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Map<String, EntityReference> actualLoadExternalIdToEntityRefMapResult = JooqUtilities.loadExternalIdToEntityRefMap(
        new DefaultDSLContext(connection, SQLDialect.SQL99), EntityKind.ACTOR, EntityKind.ALL);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"actor\".\"external_id\", \"actor\".\"id\", \"actor\".\"name\", \"actor\".\"description\" from \"actor\" where (1 = 1 and \"actor\".\"external_id\" is not null and 1 = 1)"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(2));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualLoadExternalIdToEntityRefMapResult.isEmpty());
  }

  /**
   * Test {@link JooqUtilities#loadExternalIdToEntityRefMap(DSLContext, EntityKind, EntityKind)} with {@code dsl}, {@code entityKind}, {@code qualifierKind}.
   * <p>
   * Method under test: {@link JooqUtilities#loadExternalIdToEntityRefMap(DSLContext, EntityKind, EntityKind)}
   */
  @Test
  @DisplayName("Test loadExternalIdToEntityRefMap(DSLContext, EntityKind, EntityKind) with 'dsl', 'entityKind', 'qualifierKind'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JooqUtilities.loadExternalIdToEntityRefMap(DSLContext, EntityKind, EntityKind)"})
  void testLoadExternalIdToEntityRefMapWithDslEntityKindQualifierKind3() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Map<String, EntityReference> actualLoadExternalIdToEntityRefMapResult = JooqUtilities.loadExternalIdToEntityRefMap(
        new DefaultDSLContext(connection, SQLDialect.SQL99), EntityKind.ACTOR, EntityKind.ALL);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"actor\".\"external_id\", \"actor\".\"id\", \"actor\".\"name\", \"actor\".\"description\" from \"actor\" where (1 = 1 and \"actor\".\"external_id\" is not null and 1 = 1)"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualLoadExternalIdToEntityRefMapResult.isEmpty());
  }

  /**
   * Test {@link JooqUtilities#loadExternalIdToEntityRefMap(DSLContext, EntityKind, EntityReference)} with {@code dsl}, {@code entityKind}, {@code qualifierReference}.
   * <p>
   * Method under test: {@link JooqUtilities#loadExternalIdToEntityRefMap(DSLContext, EntityKind, EntityReference)}
   */
  @Test
  @DisplayName("Test loadExternalIdToEntityRefMap(DSLContext, EntityKind, EntityReference) with 'dsl', 'entityKind', 'qualifierReference'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JooqUtilities.loadExternalIdToEntityRefMap(DSLContext, EntityKind, EntityReference)"})
  void testLoadExternalIdToEntityRefMapWithDslEntityKindQualifierReference() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Map<String, EntityReference> actualLoadExternalIdToEntityRefMapResult = JooqUtilities.loadExternalIdToEntityRefMap(
        new DefaultDSLContext(connection, SQLDialect.SQL99), EntityKind.ACTOR, mock(EntityReference.class));

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"actor\".\"external_id\", \"actor\".\"id\", \"actor\".\"name\", \"actor\".\"description\" from \"actor\" where (1 = 1 and \"actor\".\"external_id\" is not null and 1 = 1)"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(2));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualLoadExternalIdToEntityRefMapResult.size());
    EntityReference getResult = actualLoadExternalIdToEntityRefMapResult.get("String");
    assertTrue(getResult instanceof ImmutableEntityReference);
    assertEquals("String", getResult.description());
    assertEquals(1L, getResult.id());
    assertEquals(EntityKind.ACTOR, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
  }

  /**
   * Test {@link JooqUtilities#loadExternalIdToEntityRefMap(DSLContext, EntityKind, EntityReference)} with {@code dsl}, {@code entityKind}, {@code qualifierReference}.
   * <p>
   * Method under test: {@link JooqUtilities#loadExternalIdToEntityRefMap(DSLContext, EntityKind, EntityReference)}
   */
  @Test
  @DisplayName("Test loadExternalIdToEntityRefMap(DSLContext, EntityKind, EntityReference) with 'dsl', 'entityKind', 'qualifierReference'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JooqUtilities.loadExternalIdToEntityRefMap(DSLContext, EntityKind, EntityReference)"})
  void testLoadExternalIdToEntityRefMapWithDslEntityKindQualifierReference2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn(null);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Map<String, EntityReference> actualLoadExternalIdToEntityRefMapResult = JooqUtilities.loadExternalIdToEntityRefMap(
        new DefaultDSLContext(connection, SQLDialect.SQL99), EntityKind.ACTOR, mock(EntityReference.class));

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"actor\".\"external_id\", \"actor\".\"id\", \"actor\".\"name\", \"actor\".\"description\" from \"actor\" where (1 = 1 and \"actor\".\"external_id\" is not null and 1 = 1)"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(2));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualLoadExternalIdToEntityRefMapResult.isEmpty());
  }

  /**
   * Test {@link JooqUtilities#loadExternalIdToEntityRefMap(DSLContext, EntityKind, EntityReference)} with {@code dsl}, {@code entityKind}, {@code qualifierReference}.
   * <p>
   * Method under test: {@link JooqUtilities#loadExternalIdToEntityRefMap(DSLContext, EntityKind, EntityReference)}
   */
  @Test
  @DisplayName("Test loadExternalIdToEntityRefMap(DSLContext, EntityKind, EntityReference) with 'dsl', 'entityKind', 'qualifierReference'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JooqUtilities.loadExternalIdToEntityRefMap(DSLContext, EntityKind, EntityReference)"})
  void testLoadExternalIdToEntityRefMapWithDslEntityKindQualifierReference3() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Map<String, EntityReference> actualLoadExternalIdToEntityRefMapResult = JooqUtilities.loadExternalIdToEntityRefMap(
        new DefaultDSLContext(connection, SQLDialect.SQL99), EntityKind.ACTOR, mock(EntityReference.class));

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"actor\".\"external_id\", \"actor\".\"id\", \"actor\".\"name\", \"actor\".\"description\" from \"actor\" where (1 = 1 and \"actor\".\"external_id\" is not null and 1 = 1)"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualLoadExternalIdToEntityRefMapResult.isEmpty());
  }

  /**
   * Test {@link JooqUtilities#loadExternalIdToEntityRefMap(DSLContext, EntityKind)} with {@code dsl}, {@code entityKind}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#loadExternalIdToEntityRefMap(DSLContext, EntityKind)}
   */
  @Test
  @DisplayName("Test loadExternalIdToEntityRefMap(DSLContext, EntityKind) with 'dsl', 'entityKind'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JooqUtilities.loadExternalIdToEntityRefMap(DSLContext, EntityKind)"})
  void testLoadExternalIdToEntityRefMapWithDslEntityKind_thenReturnEmpty() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Map<String, EntityReference> actualLoadExternalIdToEntityRefMapResult = JooqUtilities
        .loadExternalIdToEntityRefMap(new DefaultDSLContext(connection, SQLDialect.SQL99), EntityKind.ACTOR);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"actor\".\"external_id\", \"actor\".\"id\", \"actor\".\"name\", \"actor\".\"description\" from \"actor\" where (1 = 1 and \"actor\".\"external_id\" is not null and 1 = 1)"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualLoadExternalIdToEntityRefMapResult.isEmpty());
  }

  /**
   * Test {@link JooqUtilities#loadExternalIdToEntityRefMap(DSLContext, EntityKind)} with {@code dsl}, {@code entityKind}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JooqUtilities#loadExternalIdToEntityRefMap(DSLContext, EntityKind)}
   */
  @Test
  @DisplayName("Test loadExternalIdToEntityRefMap(DSLContext, EntityKind) with 'dsl', 'entityKind'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JooqUtilities.loadExternalIdToEntityRefMap(DSLContext, EntityKind)"})
  void testLoadExternalIdToEntityRefMapWithDslEntityKind_thenReturnSizeIsOne() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Map<String, EntityReference> actualLoadExternalIdToEntityRefMapResult = JooqUtilities
        .loadExternalIdToEntityRefMap(new DefaultDSLContext(connection, SQLDialect.SQL99), EntityKind.ACTOR);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"actor\".\"external_id\", \"actor\".\"id\", \"actor\".\"name\", \"actor\".\"description\" from \"actor\" where (1 = 1 and \"actor\".\"external_id\" is not null and 1 = 1)"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(2));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualLoadExternalIdToEntityRefMapResult.size());
    EntityReference getResult = actualLoadExternalIdToEntityRefMapResult.get("String");
    assertTrue(getResult instanceof ImmutableEntityReference);
    assertEquals("String", getResult.description());
    assertEquals(1L, getResult.id());
    assertEquals(EntityKind.ACTOR, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
  }
}
