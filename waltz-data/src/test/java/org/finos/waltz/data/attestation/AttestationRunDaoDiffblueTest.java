package org.finos.waltz.data.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.attestation.AttestationRun;
import org.finos.waltz.model.attestation.AttestationRunRecipient;
import org.finos.waltz.model.attestation.AttestationRunResponseSummary;
import org.finos.waltz.model.attestation.AttestationStatus;
import org.finos.waltz.model.attestation.ImmutableAttestationRunResponseSummary;
import org.finos.waltz.schema.tables.records.AttestationRunRecord;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.Table;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.TableImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AttestationRunDaoDiffblueTest {
  /**
   * Method under test: {@link AttestationRunDao#getById(long)}
   */
  @Test
  void testGetById() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    AttestationRun actualById = (new AttestationRunDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getById(1L);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setLong(eq(65), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertNull(actualById);
  }

  /**
   * Method under test: {@link AttestationRunDao#getById(long)}
   */
  @Test
  void testGetById2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getLong(anyInt())).thenReturn(0L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    AttestationRun actualById = (new AttestationRunDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getById(1L);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setLong(eq(65), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertNull(actualById);
  }

  /**
   * Method under test: {@link AttestationRunDao#findAll()}
   */
  @Test
  void testFindAll() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<AttestationRun> actualFindAllResult = (new AttestationRunDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Method under test: {@link AttestationRunDao#findAll()}
   */
  @Test
  void testFindAll2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getLong(anyInt())).thenReturn(0L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<AttestationRun> actualFindAllResult = (new AttestationRunDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Method under test: {@link AttestationRunDao#findByRecipient(String)}
   */
  @Test
  void testFindByRecipient() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<AttestationRun> actualFindByRecipientResult = (new AttestationRunDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByRecipient("42");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualFindByRecipientResult.isEmpty());
  }

  /**
   * Method under test: {@link AttestationRunDao#findByRecipient(String)}
   */
  @Test
  void testFindByRecipient2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getLong(anyInt())).thenReturn(0L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<AttestationRun> actualFindByRecipientResult = (new AttestationRunDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByRecipient("42");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualFindByRecipientResult.isEmpty());
  }

  /**
   * Method under test: {@link AttestationRunDao#findResponseSummaries()}
   */
  @Test
  void testFindResponseSummaries() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBigDecimal(anyInt())).thenReturn(new BigDecimal("2.3"));
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<AttestationRunResponseSummary> actualFindResponseSummariesResult = (new AttestationRunDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findResponseSummaries();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"attestation_run\".\"id\", sum(case when \"attestation_instance\".\"attested_by\" is not null then ? else ? end) \"Complete\", sum(case when \"attestation_instance\".\"attested_by\" is null then ? else ? end) \"Pending\" from \"attestation_run\" join \"attestation_instance\" on \"attestation_instance\".\"attestation_run_id\" = \"attestation_run\".\"id\" group by \"attestation_run\".\"id\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBigDecimal(anyInt());
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindResponseSummariesResult.size());
    AttestationRunResponseSummary getResult = actualFindResponseSummariesResult.get(0);
    assertTrue(getResult instanceof ImmutableAttestationRunResponseSummary);
    AttestationRunResponseSummary getResult2 = actualFindResponseSummariesResult.get(1);
    assertTrue(getResult2 instanceof ImmutableAttestationRunResponseSummary);
    assertEquals(1L, getResult.runId());
    assertEquals(2L, getResult.completeCount());
    assertEquals(2L, getResult.pendingCount());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link AttestationRunDao#getEntityCount(Select)}
   */
  @Test
  void testGetEntityCount() throws SQLException {
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    AttestationRunDao attestationRunDao = new AttestationRunDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    Select<Record1<Long>> idSelector = mock(Select.class);
    when(idSelector.asTable()).thenReturn(new TableImpl<>("Name"));

    // Act
    int actualEntityCount = attestationRunDao.getEntityCount(idSelector);

    // Assert
    verify(connection).prepareStatement(eq("select count(*) \"entity_count\" from \"Name\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getInt(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(idSelector).asTable();
    assertEquals(1, actualEntityCount);
  }

  /**
   * Method under test: {@link AttestationRunDao#getEntityCount(Select)}
   */
  @Test
  void testGetEntityCount2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    AttestationRunDao attestationRunDao = new AttestationRunDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    Select<Record1<Long>> idSelector = mock(Select.class);
    when(idSelector.asTable()).thenReturn(new TableImpl<>("Name"));

    // Act
    int actualEntityCount = attestationRunDao.getEntityCount(idSelector);

    // Assert
    verify(connection).prepareStatement(eq("select count(*) \"entity_count\" from \"Name\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    verify(idSelector).asTable();
    assertEquals(3, actualEntityCount);
  }

  /**
   * Method under test: {@link AttestationRunDao#findPendingRuns()}
   */
  @Test
  void testFindPendingRuns() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Set<AttestationRun> actualFindPendingRunsResult = (new AttestationRunDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findPendingRuns();

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualFindPendingRunsResult.isEmpty());
  }

  /**
   * Method under test: {@link AttestationRunDao#findPendingRuns()}
   */
  @Test
  void testFindPendingRuns2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getLong(anyInt())).thenReturn(0L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Set<AttestationRun> actualFindPendingRunsResult = (new AttestationRunDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findPendingRuns();

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualFindPendingRunsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AttestationRunDao#updateStatusForRunIds(Set, AttestationStatus)}
   */
  @Test
  void testUpdateStatusForRunIds() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    AttestationRunDao attestationRunDao = new AttestationRunDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualUpdateStatusForRunIdsResult = attestationRunDao.updateStatusForRunIds(new HashSet<>(),
        AttestationStatus.DRAFT);

    // Assert
    verify(connection).prepareStatement(
        eq("update \"attestation_run\" set \"attestation_run\".\"status\" = ? where \"attestation_run\".\"id\" in ()"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("DRAFT"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateStatusForRunIdsResult);
  }

  /**
   * Method under test:
   * {@link AttestationRunDao#updateStatusForRunIds(Set, AttestationStatus)}
   */
  @Test
  void testUpdateStatusForRunIds2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AttestationRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<AttestationRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<AttestationRunRecord>>any())).thenReturn(updateSetFirstStep);
    AttestationRunDao attestationRunDao = new AttestationRunDao(dsl);

    // Act
    int actualUpdateStatusForRunIdsResult = attestationRunDao.updateStatusForRunIds(new HashSet<>(),
        AttestationStatus.DRAFT);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateStatusForRunIdsResult);
  }

  /**
   * Method under test:
   * {@link AttestationRunDao#updateStatusForRunIds(Set, AttestationStatus)}
   */
  @Test
  void testUpdateStatusForRunIds3() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AttestationRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<AttestationRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<AttestationRunRecord>>any())).thenReturn(updateSetFirstStep);
    AttestationRunDao attestationRunDao = new AttestationRunDao(dsl);

    HashSet<Long> runIds = new HashSet<>();
    runIds.add(1L);

    // Act
    int actualUpdateStatusForRunIdsResult = attestationRunDao.updateStatusForRunIds(runIds, AttestationStatus.DRAFT);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateStatusForRunIdsResult);
  }

  /**
   * Method under test:
   * {@link AttestationRunDao#updateStatusForRunIds(Set, AttestationStatus)}
   */
  @Test
  void testUpdateStatusForRunIds4() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AttestationRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<AttestationRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<AttestationRunRecord>>any())).thenReturn(updateSetFirstStep);
    AttestationRunDao attestationRunDao = new AttestationRunDao(dsl);

    HashSet<Long> runIds = new HashSet<>();
    runIds.add(0L);
    runIds.add(1L);

    // Act
    int actualUpdateStatusForRunIdsResult = attestationRunDao.updateStatusForRunIds(runIds, AttestationStatus.DRAFT);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateStatusForRunIdsResult);
  }

  /**
   * Method under test:
   * {@link AttestationRunDao#updateStatusForRunIds(Set, AttestationStatus)}
   */
  @Test
  void testUpdateStatusForRunIds5() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AttestationRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateConditionStep<AttestationRunRecord> updateConditionStep2 = mock(UpdateConditionStep.class);
    when(updateConditionStep2.execute()).thenReturn(1);
    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);
    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    when(updateSetMoreStep3.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<AttestationRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<AttestationRunRecord>>any())).thenReturn(updateSetFirstStep);
    AttestationRunDao attestationRunDao = new AttestationRunDao(dsl);

    // Act
    int actualUpdateStatusForRunIdsResult = attestationRunDao.updateStatusForRunIds(new HashSet<>(),
        AttestationStatus.ISSUED);

    // Assert
    verify(updateConditionStep2).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateStatusForRunIdsResult);
  }

  /**
   * Method under test:
   * {@link AttestationRunDao#updateStatusForRunIds(Set, AttestationStatus)}
   */
  @Test
  void testUpdateStatusForRunIds6() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AttestationRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateConditionStep<AttestationRunRecord> updateConditionStep2 = mock(UpdateConditionStep.class);
    when(updateConditionStep2.execute()).thenReturn(1);
    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);
    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    when(updateSetMoreStep3.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<AttestationRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<AttestationRunRecord>>any())).thenReturn(updateSetFirstStep);
    AttestationRunDao attestationRunDao = new AttestationRunDao(dsl);

    HashSet<Long> runIds = new HashSet<>();
    runIds.add(-1L);

    // Act
    int actualUpdateStatusForRunIdsResult = attestationRunDao.updateStatusForRunIds(runIds, AttestationStatus.ISSUED);

    // Assert
    verify(updateConditionStep2).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateStatusForRunIdsResult);
  }

  /**
   * Method under test:
   * {@link AttestationRunDao#updateRecipientInvolvementGroupId(long, Long)}
   */
  @Test
  void testUpdateRecipientInvolvementGroupId() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualUpdateRecipientInvolvementGroupIdResult = (new AttestationRunDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).updateRecipientInvolvementGroupId(1L, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"attestation_run\" set \"attestation_run\".\"recipient_involvement_group_id\" = ? where \"attestation_run\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateRecipientInvolvementGroupIdResult);
  }

  /**
   * Method under test:
   * {@link AttestationRunDao#updateRecipientInvolvementGroupId(long, Long)}
   */
  @Test
  void testUpdateRecipientInvolvementGroupId2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AttestationRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);
    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<AttestationRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<AttestationRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateRecipientInvolvementGroupIdResult = (new AttestationRunDao(dsl))
        .updateRecipientInvolvementGroupId(1L, 1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateRecipientInvolvementGroupIdResult);
  }

  /**
   * Method under test:
   * {@link AttestationRunDao#updateRecipientInvolvementGroupId(long, Long)}
   */
  @Test
  void testUpdateRecipientInvolvementGroupId3() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AttestationRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);
    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<AttestationRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<AttestationRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateRecipientInvolvementGroupIdResult = (new AttestationRunDao(dsl))
        .updateRecipientInvolvementGroupId(2L, 1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateRecipientInvolvementGroupIdResult);
  }

  /**
   * Method under test:
   * {@link AttestationRunDao#updateRecipientInvolvementGroupId(long, Long)}
   */
  @Test
  void testUpdateRecipientInvolvementGroupId4() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AttestationRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);
    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<AttestationRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<AttestationRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateRecipientInvolvementGroupIdResult = (new AttestationRunDao(dsl))
        .updateRecipientInvolvementGroupId(3L, 1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateRecipientInvolvementGroupIdResult);
  }

  /**
   * Method under test:
   * {@link AttestationRunDao#updateRecipientInvolvementGroupId(long, Long)}
   */
  @Test
  void testUpdateRecipientInvolvementGroupId5() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AttestationRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);
    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<AttestationRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<AttestationRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateRecipientInvolvementGroupIdResult = (new AttestationRunDao(dsl))
        .updateRecipientInvolvementGroupId(4L, 1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateRecipientInvolvementGroupIdResult);
  }

  /**
   * Method under test: {@link AttestationRunDao#findRunRecipients(long)}
   */
  @Test
  void testFindRunRecipients() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Set<AttestationRunRecipient> actualFindRunRecipientsResult = (new AttestationRunDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findRunRecipients(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"attestation_instance_recipient\".\"user_id\", case when \"attestation_instance\".\"attested_at\" is null then ? else ? end \"is_pending_field\", \"attestation_instance\".\"id\" from \"attestation_run\" join \"attestation_instance\" on \"attestation_instance\".\"attestation_run_id\" = \"attestation_run\".\"id\" join \"attestation_instance_recipient\" on \"attestation_instance_recipient\".\"attestation_instance_id\" = \"attestation_instance\".\"id\" where \"attestation_run\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(2));
    verify(resultSet, atLeast(1)).getLong(eq(3));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindRunRecipientsResult.size());
  }

  /**
   * Method under test: {@link AttestationRunDao#findRunRecipients(long)}
   */
  @Test
  void testFindRunRecipients2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(0L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Set<AttestationRunRecipient> actualFindRunRecipientsResult = (new AttestationRunDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findRunRecipients(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"attestation_instance_recipient\".\"user_id\", case when \"attestation_instance\".\"attested_at\" is null then ? else ? end \"is_pending_field\", \"attestation_instance\".\"id\" from \"attestation_run\" join \"attestation_instance\" on \"attestation_instance\".\"attestation_run_id\" = \"attestation_run\".\"id\" join \"attestation_instance_recipient\" on \"attestation_instance_recipient\".\"attestation_instance_id\" = \"attestation_instance\".\"id\" where \"attestation_run\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(2));
    verify(resultSet, atLeast(1)).getLong(eq(3));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindRunRecipientsResult.size());
  }

  /**
   * Method under test: {@link AttestationRunDao#findRunRecipients(long)}
   */
  @Test
  void testFindRunRecipients3() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Set<AttestationRunRecipient> actualFindRunRecipientsResult = (new AttestationRunDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findRunRecipients(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"attestation_instance_recipient\".\"user_id\", case when \"attestation_instance\".\"attested_at\" is null then ? else ? end \"is_pending_field\", \"attestation_instance\".\"id\" from \"attestation_run\" join \"attestation_instance\" on \"attestation_instance\".\"attestation_run_id\" = \"attestation_run\".\"id\" join \"attestation_instance_recipient\" on \"attestation_instance_recipient\".\"attestation_instance_id\" = \"attestation_instance\".\"id\" where \"attestation_run\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindRunRecipientsResult.isEmpty());
  }
}
