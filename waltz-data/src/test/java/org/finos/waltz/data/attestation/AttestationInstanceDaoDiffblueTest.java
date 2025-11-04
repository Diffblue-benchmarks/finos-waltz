package org.finos.waltz.data.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.finos.waltz.model.attestation.AttestationInstance;
import org.finos.waltz.model.attestation.ImmutableSyncRecipientsResponse;
import org.finos.waltz.model.attestation.SyncRecipientsResponse;
import org.finos.waltz.schema.tables.records.AttestationInstanceRecipientRecord;
import org.finos.waltz.schema.tables.records.AttestationInstanceRecord;
import org.jooq.Condition;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AttestationInstanceDaoDiffblueTest {
  /**
   * Method under test: {@link AttestationInstanceDao#getById(long)}
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
    AttestationInstance actualById = (new AttestationInstanceDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"attestation_instance\".\"id\", \"attestation_instance\".\"attestation_run_id\", \"attestation_instance\".\"parent_entity_id\", \"attestation_instance\".\"parent_entity_kind\", \"attestation_instance\".\"attested_at\", \"attestation_instance\".\"attested_by\", \"attestation_instance\".\"attested_entity_kind\", case when \"attestation_instance\".\"parent_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"attestation_instance\".\"parent_entity_id\") end \"entity_name\", \"attestation_run\".\"attested_entity_id\" from \"attestation_instance\" join \"attestation_run\" on \"attestation_run\".\"id\" = \"attestation_instance\".\"attestation_run_id\" where \"attestation_instance\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("APPLICATION"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualById);
  }

  /**
   * Method under test:
   * {@link AttestationInstanceDao#findByRecipient(String, boolean)}
   */
  @Test
  void testFindByRecipient() throws SQLException {
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
    List<AttestationInstance> actualFindByRecipientResult = (new AttestationInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByRecipient("42", true);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"attestation_instance\".\"id\", \"attestation_instance\".\"attestation_run_id\", \"attestation_instance\".\"parent_entity_id\", \"attestation_instance\".\"parent_entity_kind\", \"attestation_instance\".\"attested_at\", \"attestation_instance\".\"attested_by\", \"attestation_instance\".\"attested_entity_kind\", case when \"attestation_instance\".\"parent_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"attestation_instance\".\"parent_entity_id\") end \"entity_name\", \"attestation_run\".\"attested_entity_id\" from \"attestation_instance\" join \"attestation_run\" on \"attestation_run\".\"id\" = \"attestation_instance\".\"attestation_run_id\" join \"attestation_instance_recipient\" on \"attestation_instance_recipient\".\"attestation_instance_id\" = \"attestation_instance\".\"id\" where (\"attestation_instance_recipient\".\"user_id\" = ? and \"attestation_instance\".\"attested_at\" is null)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByRecipientResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AttestationInstanceDao#findHistoricalForPendingByUserId(String)}
   */
  @Test
  void testFindHistoricalForPendingByUserId() throws SQLException {
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
    List<AttestationInstance> actualFindHistoricalForPendingByUserIdResult = (new AttestationInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findHistoricalForPendingByUserId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"attestation_instance\".\"id\", \"attestation_instance\".\"attestation_run_id\", \"attestation_instance\".\"parent_entity_id\", \"attestation_instance\".\"parent_entity_kind\", \"attestation_instance\".\"attested_at\", \"attestation_instance\".\"attested_by\", \"attestation_instance\".\"attested_entity_kind\", case when \"attestation_instance\".\"parent_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"attestation_instance\".\"parent_entity_id\") end \"entity_name\", \"attestation_run\".\"attested_entity_id\" from \"attestation_instance\" join \"attestation_run\" on \"attestation_run\".\"id\" = \"attestation_instance\".\"attestation_run_id\" join (select distinct \"attestation_instance\".\"parent_entity_kind\", \"attestation_instance\".\"parent_entity_id\" from \"attestation_instance\" join \"attestation_instance_recipient\" on \"attestation_instance_recipient\".\"attestation_instance_id\" = \"attestation_instance\".\"id\" where (\"attestation_instance_recipient\".\"user_id\" = ? and \"attestation_instance\".\"attested_at\" is null)) \"alias_19900825\" on (\"alias_19900825\".\"parent_entity_kind\" = \"attestation_instance\".\"parent_entity_kind\" and \"alias_19900825\".\"parent_entity_id\" = \"attestation_instance\".\"parent_entity_id\") where \"attestation_instance\".\"attested_at\" is not null order by \"attestation_instance\".\"attested_at\" desc"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindHistoricalForPendingByUserIdResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AttestationInstanceDao#attestInstance(long, String, LocalDateTime)}
   */
  @Test
  void testAttestInstance() throws SQLException {
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
    AttestationInstanceDao attestationInstanceDao = new AttestationInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    boolean actualAttestInstanceResult = attestationInstanceDao.attestInstance(1L, "Attested By",
        LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"attestation_instance\" set \"attestation_instance\".\"attested_by\" = ?, \"attestation_instance\".\"attested_at\" = ? where (\"attestation_instance\".\"id\" = ? and \"attestation_instance\".\"attested_at\" is null)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("Attested By"));
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualAttestInstanceResult);
  }

  /**
   * Method under test:
   * {@link AttestationInstanceDao#attestInstance(long, String, LocalDateTime)}
   */
  @Test
  void testAttestInstance2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AttestationInstanceRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<AttestationInstanceRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<AttestationInstanceRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetFirstStep<AttestationInstanceRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<AttestationInstanceRecord>>any())).thenReturn(updateSetFirstStep);
    AttestationInstanceDao attestationInstanceDao = new AttestationInstanceDao(dsl);

    // Act
    boolean actualAttestInstanceResult = attestationInstanceDao.attestInstance(1L, "Attested By",
        LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualAttestInstanceResult);
  }

  /**
   * Method under test: {@link AttestationInstanceDao#findByRunId(long)}
   */
  @Test
  void testFindByRunId() throws SQLException {
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
    List<AttestationInstance> actualFindByRunIdResult = (new AttestationInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByRunId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"attestation_instance\".\"id\", \"attestation_instance\".\"attestation_run_id\", \"attestation_instance\".\"parent_entity_id\", \"attestation_instance\".\"parent_entity_kind\", \"attestation_instance\".\"attested_at\", \"attestation_instance\".\"attested_by\", \"attestation_instance\".\"attested_entity_kind\", case when \"attestation_instance\".\"parent_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"attestation_instance\".\"parent_entity_id\") end \"entity_name\", \"attestation_run\".\"attested_entity_id\" from \"attestation_instance\" join \"attestation_run\" on \"attestation_run\".\"id\" = \"attestation_instance\".\"attestation_run_id\" where \"attestation_instance\".\"attestation_run_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("APPLICATION"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByRunIdResult.isEmpty());
  }

  /**
   * Method under test: {@link AttestationInstanceDao#cleanupOrphans()}
   */
  @Test
  void testCleanupOrphans() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualCleanupOrphansResult = (new AttestationInstanceDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .cleanupOrphans();

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(eq(3), eq(true));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualCleanupOrphansResult);
  }

  /**
   * Method under test: {@link AttestationInstanceDao#cleanupOrphans()}
   */
  @Test
  void testCleanupOrphans2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<AttestationInstanceRecipientRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteUsingStep<AttestationInstanceRecipientRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<AttestationInstanceRecipientRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualCleanupOrphansResult = (new AttestationInstanceDao(dsl)).cleanupOrphans();

    // Assert
    verify(deleteUsingStep, atLeast(1)).where(Mockito.<Condition>any());
    verify(deleteConditionStep, atLeast(1)).execute();
    verify(dsl, atLeast(1)).deleteFrom(Mockito.<Table<Record>>any());
    assertEquals(1, actualCleanupOrphansResult);
  }

  /**
   * Method under test: {@link AttestationInstanceDao#cleanupOrphans()}
   */
  @Test
  void testCleanupOrphans3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualCleanupOrphansResult = (new AttestationInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.FIREBIRD))).cleanupOrphans();

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(eq(3), eq(true));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualCleanupOrphansResult);
  }

  /**
   * Method under test: {@link AttestationInstanceDao#cleanupOrphans()}
   */
  @Test
  void testCleanupOrphans4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualCleanupOrphansResult = (new AttestationInstanceDao(new DefaultDSLContext(connection, SQLDialect.MARIADB)))
        .cleanupOrphans();

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(eq(3), eq(true));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualCleanupOrphansResult);
  }

  /**
   * Method under test: {@link AttestationInstanceDao#cleanupOrphans()}
   */
  @Test
  void testCleanupOrphans5() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualCleanupOrphansResult = (new AttestationInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.POSTGRES))).cleanupOrphans();

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(eq(3), eq(true));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualCleanupOrphansResult);
  }

  /**
   * Method under test: {@link AttestationInstanceDao#cleanupOrphans()}
   */
  @Test
  void testCleanupOrphans6() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualCleanupOrphansResult = (new AttestationInstanceDao(new DefaultDSLContext(connection, SQLDialect.SQLITE)))
        .cleanupOrphans();

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(eq(3), eq(true));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualCleanupOrphansResult);
  }

  /**
   * Method under test: {@link AttestationInstanceDao#reassignRecipients()}
   */
  @Test
  void testReassignRecipients() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    SyncRecipientsResponse actualReassignRecipientsResult = (new AttestationInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).reassignRecipients();

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualReassignRecipientsResult instanceof ImmutableSyncRecipientsResponse);
    assertEquals(0L, actualReassignRecipientsResult.recipientsCreatedCount().longValue());
    assertEquals(0L, actualReassignRecipientsResult.recipientsRemovedCount().longValue());
  }

  /**
   * Method under test: {@link AttestationInstanceDao#reassignRecipients()}
   */
  @Test
  void testReassignRecipients2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getLong(anyInt())).thenReturn(0L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setObject(anyInt(), Mockito.<Object>any());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    SyncRecipientsResponse actualReassignRecipientsResult = (new AttestationInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).reassignRecipients();

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setObject(anyInt(), isNull());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualReassignRecipientsResult instanceof ImmutableSyncRecipientsResponse);
    assertEquals(0L, actualReassignRecipientsResult.recipientsCreatedCount().longValue());
    assertEquals(0L, actualReassignRecipientsResult.recipientsRemovedCount().longValue());
  }

  /**
   * Method under test: {@link AttestationInstanceDao#reassignRecipients()}
   */
  @Test
  void testReassignRecipients3() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(false);
    when(resultSet.getLong(anyInt())).thenReturn(0L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    SyncRecipientsResponse actualReassignRecipientsResult = (new AttestationInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).reassignRecipients();

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(0L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualReassignRecipientsResult instanceof ImmutableSyncRecipientsResponse);
    assertEquals(0L, actualReassignRecipientsResult.recipientsCreatedCount().longValue());
    assertEquals(0L, actualReassignRecipientsResult.recipientsRemovedCount().longValue());
  }

  /**
   * Method under test:
   * {@link AttestationInstanceDao#getCountsOfRecipientsToReassign()}
   */
  @Test
  void testGetCountsOfRecipientsToReassign() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    SyncRecipientsResponse actualCountsOfRecipientsToReassign = (new AttestationInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getCountsOfRecipientsToReassign();

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualCountsOfRecipientsToReassign instanceof ImmutableSyncRecipientsResponse);
    assertEquals(0L, actualCountsOfRecipientsToReassign.recipientsCreatedCount().longValue());
    assertEquals(0L, actualCountsOfRecipientsToReassign.recipientsRemovedCount().longValue());
  }

  /**
   * Method under test:
   * {@link AttestationInstanceDao#getCountsOfRecipientsToReassign()}
   */
  @Test
  void testGetCountsOfRecipientsToReassign2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getLong(anyInt())).thenReturn(0L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setObject(anyInt(), Mockito.<Object>any());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    SyncRecipientsResponse actualCountsOfRecipientsToReassign = (new AttestationInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getCountsOfRecipientsToReassign();

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setObject(anyInt(), isNull());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualCountsOfRecipientsToReassign instanceof ImmutableSyncRecipientsResponse);
    assertEquals(0L, actualCountsOfRecipientsToReassign.recipientsCreatedCount().longValue());
    assertEquals(0L, actualCountsOfRecipientsToReassign.recipientsRemovedCount().longValue());
  }

  /**
   * Method under test:
   * {@link AttestationInstanceDao#getCountsOfRecipientsToReassign()}
   */
  @Test
  void testGetCountsOfRecipientsToReassign3() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(false);
    when(resultSet.getLong(anyInt())).thenReturn(0L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    SyncRecipientsResponse actualCountsOfRecipientsToReassign = (new AttestationInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getCountsOfRecipientsToReassign();

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(0L));
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualCountsOfRecipientsToReassign instanceof ImmutableSyncRecipientsResponse);
    assertEquals(0L, actualCountsOfRecipientsToReassign.recipientsCreatedCount().longValue());
    assertEquals(0L, actualCountsOfRecipientsToReassign.recipientsRemovedCount().longValue());
  }
}
