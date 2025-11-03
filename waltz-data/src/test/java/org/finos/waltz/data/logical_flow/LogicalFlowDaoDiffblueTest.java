package org.finos.waltz.data.logical_flow;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
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
import org.finos.waltz.model.logical_flow.LogicalFlow;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LogicalFlowDaoDiffblueTest {
  /**
   * Test {@link LogicalFlowDao#getByFlowExternalId(String)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalFlowDao#getByFlowExternalId(String)}
   */
  @Test
  @DisplayName("Test getByFlowExternalId(String); given ResultSet next() return 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicalFlow LogicalFlowDao.getByFlowExternalId(String)"})
  void testGetByFlowExternalId_givenResultSetNextReturnFalse_thenReturnNull() throws SQLException {
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
    LogicalFlow actualByFlowExternalId = (new LogicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getByFlowExternalId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow\".\"source_entity_kind\", \"logical_flow\".\"source_entity_id\", \"logical_flow\".\"target_entity_kind\", \"logical_flow\".\"target_entity_id\", \"logical_flow\".\"provenance\", \"logical_flow\".\"id\", \"logical_flow\".\"last_updated_at\", \"logical_flow\".\"last_updated_by\", \"logical_flow\".\"last_attested_at\", \"logical_flow\".\"last_attested_by\", \"logical_flow\".\"entity_lifecycle_status\", \"logical_flow\".\"is_removed\", \"logical_flow\".\"created_at\", \"logical_flow\".\"created_by\", \"logical_flow\".\"is_readonly\", \"logical_flow\".\"external_id\", case when \"logical_flow\".\"source_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"source_entity_id\") end, case when \"logical_flow\".\"target_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"target_entity_id\") end, case when \"logical_flow\".\"source_entity_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"end_user_application\".\"external_id\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"source_entity_id\") end, case when \"logical_flow\".\"target_entity_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"end_user_application\".\"external_id\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"target_entity_id\") end from \"logical_flow\" where \"logical_flow\".\"external_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualByFlowExternalId);
  }

  /**
   * Test {@link LogicalFlowDao#getByFlowId(long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalFlowDao#getByFlowId(long)}
   */
  @Test
  @DisplayName("Test getByFlowId(long); given ResultSet next() return 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicalFlow LogicalFlowDao.getByFlowId(long)"})
  void testGetByFlowId_givenResultSetNextReturnFalse_thenReturnNull() throws SQLException {
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
    LogicalFlow actualByFlowId = (new LogicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getByFlowId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow\".\"source_entity_kind\", \"logical_flow\".\"source_entity_id\", \"logical_flow\".\"target_entity_kind\", \"logical_flow\".\"target_entity_id\", \"logical_flow\".\"provenance\", \"logical_flow\".\"id\", \"logical_flow\".\"last_updated_at\", \"logical_flow\".\"last_updated_by\", \"logical_flow\".\"last_attested_at\", \"logical_flow\".\"last_attested_by\", \"logical_flow\".\"entity_lifecycle_status\", \"logical_flow\".\"is_removed\", \"logical_flow\".\"created_at\", \"logical_flow\".\"created_by\", \"logical_flow\".\"is_readonly\", \"logical_flow\".\"external_id\", case when \"logical_flow\".\"source_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"source_entity_id\") end, case when \"logical_flow\".\"target_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"target_entity_id\") end, case when \"logical_flow\".\"source_entity_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"source_entity_id\") when \"logical_flow\".\"source_entity_kind\" = ? then (select \"end_user_application\".\"external_id\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"source_entity_id\") end, case when \"logical_flow\".\"target_entity_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"logical_flow\".\"target_entity_id\") when \"logical_flow\".\"target_entity_kind\" = ? then (select \"end_user_application\".\"external_id\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"logical_flow\".\"target_entity_id\") end from \"logical_flow\" where \"logical_flow\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(13), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualByFlowId);
  }
}
