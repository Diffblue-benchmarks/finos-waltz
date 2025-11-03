package org.finos.waltz.data.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import org.finos.waltz.model.attestation.AttestationInstance;
import org.finos.waltz.model.attestation.ImmutableSyncRecipientsResponse;
import org.finos.waltz.model.attestation.SyncRecipientsResponse;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AttestationInstanceDaoDiffblueTest {
  /**
   * Test {@link AttestationInstanceDao#getById(long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttestationInstanceDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); given ResultSet next() return 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttestationInstance AttestationInstanceDao.getById(long)"})
  void testGetById_givenResultSetNextReturnFalse_thenReturnNull() throws SQLException {
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
    AttestationInstanceDao attestationInstanceDao = new AttestationInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    AttestationInstance actualById = attestationInstanceDao.getById(1L);

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
    assertEquals(0, attestationInstanceDao.cleanupOrphans());
  }

  /**
   * Test {@link AttestationInstanceDao#reassignRecipients()}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} return one.</li>
   *   <li>Then calls {@link PreparedStatement#setLong(int, long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttestationInstanceDao#reassignRecipients()}
   */
  @Test
  @DisplayName("Test reassignRecipients(); given ResultSet getLong(int) return one; then calls setLong(int, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SyncRecipientsResponse AttestationInstanceDao.reassignRecipients()"})
  void testReassignRecipients_givenResultSetGetLongReturnOne_thenCallsSetLong() throws SQLException {
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
   * Test {@link AttestationInstanceDao#reassignRecipients()}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#wasNull()} return {@code false}.</li>
   *   <li>Then calls {@link PreparedStatement#setLong(int, long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttestationInstanceDao#reassignRecipients()}
   */
  @Test
  @DisplayName("Test reassignRecipients(); given ResultSet wasNull() return 'false'; then calls setLong(int, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SyncRecipientsResponse AttestationInstanceDao.reassignRecipients()"})
  void testReassignRecipients_givenResultSetWasNullReturnFalse_thenCallsSetLong() throws SQLException {
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
   * Test {@link AttestationInstanceDao#reassignRecipients()}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#wasNull()} return {@code true}.</li>
   *   <li>Then calls {@link PreparedStatement#setObject(int, Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttestationInstanceDao#reassignRecipients()}
   */
  @Test
  @DisplayName("Test reassignRecipients(); given ResultSet wasNull() return 'true'; then calls setObject(int, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SyncRecipientsResponse AttestationInstanceDao.reassignRecipients()"})
  void testReassignRecipients_givenResultSetWasNullReturnTrue_thenCallsSetObject() throws SQLException {
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
   * Test {@link AttestationInstanceDao#getCountsOfRecipientsToReassign()}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttestationInstanceDao#getCountsOfRecipientsToReassign()}
   */
  @Test
  @DisplayName("Test getCountsOfRecipientsToReassign(); given ResultSet getLong(int) return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SyncRecipientsResponse AttestationInstanceDao.getCountsOfRecipientsToReassign()"})
  void testGetCountsOfRecipientsToReassign_givenResultSetGetLongReturnOne() throws SQLException {
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
   * Test {@link AttestationInstanceDao#getCountsOfRecipientsToReassign()}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#wasNull()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttestationInstanceDao#getCountsOfRecipientsToReassign()}
   */
  @Test
  @DisplayName("Test getCountsOfRecipientsToReassign(); given ResultSet wasNull() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SyncRecipientsResponse AttestationInstanceDao.getCountsOfRecipientsToReassign()"})
  void testGetCountsOfRecipientsToReassign_givenResultSetWasNullReturnFalse() throws SQLException {
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

  /**
   * Test {@link AttestationInstanceDao#getCountsOfRecipientsToReassign()}.
   * <ul>
   *   <li>Then calls {@link PreparedStatement#setObject(int, Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttestationInstanceDao#getCountsOfRecipientsToReassign()}
   */
  @Test
  @DisplayName("Test getCountsOfRecipientsToReassign(); then calls setObject(int, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SyncRecipientsResponse AttestationInstanceDao.getCountsOfRecipientsToReassign()"})
  void testGetCountsOfRecipientsToReassign_thenCallsSetObject() throws SQLException {
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
}
