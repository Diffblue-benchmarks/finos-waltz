package org.finos.waltz.data.physical_specification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.physical_specification.DataFormatKindValue;
import org.finos.waltz.model.physical_specification.PhysicalSpecification;
import org.finos.waltz.schema.tables.records.PhysicalSpecificationRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.SQLDialect;
import org.jooq.SelectField;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TransactionalCallable;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PhysicalSpecificationDaoDiffblueTest {
  /**
   * Method under test: {@link PhysicalSpecificationDao#findByIds(Collection)}
   */
  @Test
  void testFindByIds() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
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
    PhysicalSpecificationDao physicalSpecificationDao = new PhysicalSpecificationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Collection<PhysicalSpecification> actualFindByIdsResult = physicalSpecificationDao.findByIds(new ArrayList<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"physical_specification\".\"id\", \"physical_specification\".\"owning_entity_id\", \"physical_specification\".\"external_id\", \"physical_specification\".\"name\", \"physical_specification\".\"format\", \"physical_specification\".\"description\", \"physical_specification\".\"provenance\", \"physical_specification\".\"owning_entity_kind\", \"physical_specification\".\"last_updated_at\", \"physical_specification\".\"last_updated_by\", \"physical_specification\".\"is_removed\", \"physical_specification\".\"created_at\", \"physical_specification\".\"created_by\", \"physical_specification\".\"is_readonly\", case when \"physical_specification\".\"owning_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"physical_specification\".\"owning_entity_id\") when \"physical_specification\".\"owning_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"physical_specification\".\"owning_entity_id\") end \"owning_name_field\" from \"physical_specification\" where \"physical_specification\".\"id\" in ()"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByIdsResult instanceof List);
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Method under test: {@link PhysicalSpecificationDao#getById(long)}
   */
  @Test
  void testGetById() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    PhysicalSpecification actualById = (new PhysicalSpecificationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"physical_specification\".\"id\", \"physical_specification\".\"owning_entity_id\", \"physical_specification\".\"external_id\", \"physical_specification\".\"name\", \"physical_specification\".\"format\", \"physical_specification\".\"description\", \"physical_specification\".\"provenance\", \"physical_specification\".\"owning_entity_kind\", \"physical_specification\".\"last_updated_at\", \"physical_specification\".\"last_updated_by\", \"physical_specification\".\"is_removed\", \"physical_specification\".\"created_at\", \"physical_specification\".\"created_by\", \"physical_specification\".\"is_readonly\", case when \"physical_specification\".\"owning_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"physical_specification\".\"owning_entity_id\") when \"physical_specification\".\"owning_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"physical_specification\".\"owning_entity_id\") end \"owning_name_field\" from \"physical_specification\" where \"physical_specification\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualById);
  }

  /**
   * Method under test: {@link PhysicalSpecificationDao#findByExternalId(String)}
   */
  @Test
  void testFindByExternalId() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
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
    Collection<PhysicalSpecification> actualFindByExternalIdResult = (new PhysicalSpecificationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByExternalId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"physical_specification\".\"id\", \"physical_specification\".\"owning_entity_id\", \"physical_specification\".\"external_id\", \"physical_specification\".\"name\", \"physical_specification\".\"format\", \"physical_specification\".\"description\", \"physical_specification\".\"provenance\", \"physical_specification\".\"owning_entity_kind\", \"physical_specification\".\"last_updated_at\", \"physical_specification\".\"last_updated_by\", \"physical_specification\".\"is_removed\", \"physical_specification\".\"created_at\", \"physical_specification\".\"created_by\", \"physical_specification\".\"is_readonly\", case when \"physical_specification\".\"owning_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"physical_specification\".\"owning_entity_id\") when \"physical_specification\".\"owning_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"physical_specification\".\"owning_entity_id\") end \"owning_name_field\" from \"physical_specification\" where \"physical_specification\".\"external_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByExternalIdResult instanceof Set);
    assertTrue(actualFindByExternalIdResult.isEmpty());
  }

  /**
   * Method under test: {@link PhysicalSpecificationDao#isUsed(long)}
   */
  @Test
  void testIsUsed() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualIsUsedResult = (new PhysicalSpecificationDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .isUsed(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select case when exists (select \"physical_flow\".\"id\" from \"physical_flow\" where (\"physical_flow\".\"specification_id\" = ? and \"physical_flow\".\"is_removed\" = false and \"physical_flow\".\"entity_lifecycle_status\" <> ?)) then ? else ? end \"spec_used\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("REMOVED"));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualIsUsedResult);
  }

  /**
   * Method under test: {@link PhysicalSpecificationDao#isUsed(long)}
   */
  @Test
  void testIsUsed2() throws DataAccessException {
    // Arrange
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.fetchOne(Mockito.<Field<Object>>any())).thenReturn(true);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    boolean actualIsUsedResult = (new PhysicalSpecificationDao(dsl)).isUsed(1L);

    // Assert
    verify(selectSelectStep).fetchOne(isA(Field.class));
    verify(dsl).select(isA(SelectField.class));
    assertTrue(actualIsUsedResult);
  }

  /**
   * Method under test: {@link PhysicalSpecificationDao#isUsed(long)}
   */
  @Test
  void testIsUsed3() throws DataAccessException {
    // Arrange
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.fetchOne(Mockito.<Field<Object>>any())).thenReturn(false);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    boolean actualIsUsedResult = (new PhysicalSpecificationDao(dsl)).isUsed(1L);

    // Assert
    verify(selectSelectStep).fetchOne(isA(Field.class));
    verify(dsl).select(isA(SelectField.class));
    assertFalse(actualIsUsedResult);
  }

  /**
   * Method under test: {@link PhysicalSpecificationDao#markRemovedIfUnused(long)}
   */
  @Test
  void testMarkRemovedIfUnused() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualMarkRemovedIfUnusedResult = (new PhysicalSpecificationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).markRemovedIfUnused(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"physical_specification\" set \"physical_specification\".\"is_removed\" = ? where (\"physical_specification\".\"id\" = ? and not exists (select \"physical_flow\".\"id\" from \"physical_flow\" where (\"physical_flow\".\"specification_id\" = ? and \"physical_flow\".\"is_removed\" = false and \"physical_flow\".\"entity_lifecycle_status\" <> ?)))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(true));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(eq(4), eq("REMOVED"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualMarkRemovedIfUnusedResult);
  }

  /**
   * Method under test: {@link PhysicalSpecificationDao#markRemovedIfUnused(long)}
   */
  @Test
  void testMarkRemovedIfUnused2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalSpecificationRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateConditionStep<PhysicalSpecificationRecord> updateConditionStep2 = mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<PhysicalSpecificationRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);
    UpdateSetFirstStep<PhysicalSpecificationRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalSpecificationRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualMarkRemovedIfUnusedResult = (new PhysicalSpecificationDao(dsl)).markRemovedIfUnused(1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualMarkRemovedIfUnusedResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationDao#updateExternalId(long, String)}
   */
  @Test
  void testUpdateExternalId() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualUpdateExternalIdResult = (new PhysicalSpecificationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).updateExternalId(1L, "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"physical_specification\" set \"physical_specification\".\"external_id\" = ? where (\"physical_specification\".\"id\" = ? and \"physical_specification\".\"is_readonly\" = false)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateExternalIdResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationDao#updateExternalId(long, String)}
   */
  @Test
  void testUpdateExternalId2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalSpecificationRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<PhysicalSpecificationRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<PhysicalSpecificationRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalSpecificationRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateExternalIdResult = (new PhysicalSpecificationDao(dsl)).updateExternalId(1L, "42");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateExternalIdResult);
  }

  /**
   * Method under test: {@link PhysicalSpecificationDao#makeActive(Long)}
   */
  @Test
  void testMakeActive() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualMakeActiveResult = (new PhysicalSpecificationDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .makeActive(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"physical_specification\" set \"physical_specification\".\"is_removed\" = ? where (\"physical_specification\".\"id\" = ? and \"physical_specification\".\"is_readonly\" = false)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(false));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualMakeActiveResult);
  }

  /**
   * Method under test: {@link PhysicalSpecificationDao#makeActive(Long)}
   */
  @Test
  void testMakeActive2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalSpecificationRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<PhysicalSpecificationRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<PhysicalSpecificationRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalSpecificationRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualMakeActiveResult = (new PhysicalSpecificationDao(dsl)).makeActive(1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualMakeActiveResult);
  }

  /**
   * Method under test: {@link PhysicalSpecificationDao#makeActive(Long)}
   */
  @Test
  void testMakeActive3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualMakeActiveResult = (new PhysicalSpecificationDao(new DefaultDSLContext(connection, SQLDialect.POSTGRES)))
        .makeActive(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"physical_specification\" set \"is_removed\" = ? where (\"physical_specification\".\"id\" = ? and \"physical_specification\".\"is_readonly\" = false)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(false));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualMakeActiveResult);
  }

  /**
   * Method under test: {@link PhysicalSpecificationDao#makeActive(Long)}
   */
  @Test
  void testMakeActive4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualMakeActiveResult = (new PhysicalSpecificationDao(new DefaultDSLContext(connection, SQLDialect.SQLITE)))
        .makeActive(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "update physical_specification set is_removed = ? where (physical_specification.id = ? and physical_specification.is_readonly = 0)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(false));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualMakeActiveResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationDao#propagateDataTypesToLogicalFlows(String, long)}
   */
  @Test
  void testPropagateDataTypesToLogicalFlows() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualPropagateDataTypesToLogicalFlowsResult = (new PhysicalSpecificationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).propagateDataTypesToLogicalFlows("janedoe", 1L);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(0));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualPropagateDataTypesToLogicalFlowsResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationDao#propagateDataTypesToLogicalFlows(String, long)}
   */
  @Test
  void testPropagateDataTypesToLogicalFlows2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualPropagateDataTypesToLogicalFlowsResult = (new PhysicalSpecificationDao(
        new DefaultDSLContext(connection, SQLDialect.CUBRID))).propagateDataTypesToLogicalFlows("janedoe", 1L);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(0));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualPropagateDataTypesToLogicalFlowsResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationDao#propagateDataTypesToLogicalFlows(String, long)}
   */
  @Test
  void testPropagateDataTypesToLogicalFlows3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualPropagateDataTypesToLogicalFlowsResult = (new PhysicalSpecificationDao(
        new DefaultDSLContext(connection, SQLDialect.DERBY))).propagateDataTypesToLogicalFlows("janedoe", 1L);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(0));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualPropagateDataTypesToLogicalFlowsResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationDao#propagateDataTypesToLogicalFlows(String, long)}
   */
  @Test
  void testPropagateDataTypesToLogicalFlows4() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.transactionResult(Mockito.<TransactionalCallable<Object>>any())).thenReturn(1);

    // Act
    int actualPropagateDataTypesToLogicalFlowsResult = (new PhysicalSpecificationDao(dsl))
        .propagateDataTypesToLogicalFlows("janedoe", 1L);

    // Assert
    verify(dsl).transactionResult(isA(TransactionalCallable.class));
    assertEquals(1, actualPropagateDataTypesToLogicalFlowsResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationDao#updateFormat(long, DataFormatKindValue)}
   */
  @Test
  void testUpdateFormat() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    PhysicalSpecificationDao physicalSpecificationDao = new PhysicalSpecificationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualUpdateFormatResult = physicalSpecificationDao.updateFormat(1L, DataFormatKindValue.of("42"));

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"physical_specification\" set \"physical_specification\".\"format\" = ? where (\"physical_specification\".\"id\" = ? and \"physical_specification\".\"is_readonly\" = false)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateFormatResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationDao#updateFormat(long, DataFormatKindValue)}
   */
  @Test
  void testUpdateFormat2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalSpecificationRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<PhysicalSpecificationRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<PhysicalSpecificationRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalSpecificationRecord>>any())).thenReturn(updateSetFirstStep);
    PhysicalSpecificationDao physicalSpecificationDao = new PhysicalSpecificationDao(dsl);

    // Act
    int actualUpdateFormatResult = physicalSpecificationDao.updateFormat(1L, DataFormatKindValue.of("42"));

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateFormatResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationDao#updateDescription(long, String)}
   */
  @Test
  void testUpdateDescription() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualUpdateDescriptionResult = (new PhysicalSpecificationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).updateDescription(1L,
            "The characteristics of someone or something");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"physical_specification\" set \"physical_specification\".\"description\" = ? where (\"physical_specification\".\"id\" = ? and \"physical_specification\".\"is_readonly\" = false)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("The characteristics of someone or something"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateDescriptionResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationDao#updateDescription(long, String)}
   */
  @Test
  void testUpdateDescription2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalSpecificationRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<PhysicalSpecificationRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<PhysicalSpecificationRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalSpecificationRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateDescriptionResult = (new PhysicalSpecificationDao(dsl)).updateDescription(1L,
        "The characteristics of someone or something");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateDescriptionResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationDao#calculateAmendedSpecOperations(Set, String)}
   */
  @Test
  void testCalculateAmendedSpecOperations() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
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
    PhysicalSpecificationDao physicalSpecificationDao = new PhysicalSpecificationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));
    HashSet<Operation> operationsForEntity = new HashSet<>();

    // Act
    Set<Operation> actualCalculateAmendedSpecOperationsResult = physicalSpecificationDao
        .calculateAmendedSpecOperations(operationsForEntity, "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"user_role\".\"role\" from \"user_role\" where (\"user_role\".\"role\" = ? and \"user_role\".\"user_name\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualCalculateAmendedSpecOperationsResult.isEmpty());
    assertSame(operationsForEntity, actualCalculateAmendedSpecOperationsResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationDao#calculateAmendedSpecOperations(Set, String)}
   */
  @Test
  void testCalculateAmendedSpecOperations2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
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
    PhysicalSpecificationDao physicalSpecificationDao = new PhysicalSpecificationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Set<Operation> actualCalculateAmendedSpecOperationsResult = physicalSpecificationDao
        .calculateAmendedSpecOperations(new HashSet<>(), "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"user_role\".\"role\" from \"user_role\" where (\"user_role\".\"role\" = ? and \"user_role\".\"user_name\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getInt(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualCalculateAmendedSpecOperationsResult.size());
    assertTrue(actualCalculateAmendedSpecOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedSpecOperationsResult.contains(Operation.REMOVE));
    assertTrue(actualCalculateAmendedSpecOperationsResult.contains(Operation.UPDATE));
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationDao#calculateAmendedSpecOperations(Set, String)}
   */
  @Test
  void testCalculateAmendedSpecOperations3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    PhysicalSpecificationDao physicalSpecificationDao = new PhysicalSpecificationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Set<Operation> actualCalculateAmendedSpecOperationsResult = physicalSpecificationDao
        .calculateAmendedSpecOperations(new HashSet<>(), "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select \"user_role\".\"role\" from \"user_role\" where (\"user_role\".\"role\" = ? and \"user_role\".\"user_name\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualCalculateAmendedSpecOperationsResult.size());
    assertTrue(actualCalculateAmendedSpecOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedSpecOperationsResult.contains(Operation.REMOVE));
    assertTrue(actualCalculateAmendedSpecOperationsResult.contains(Operation.UPDATE));
  }
}
