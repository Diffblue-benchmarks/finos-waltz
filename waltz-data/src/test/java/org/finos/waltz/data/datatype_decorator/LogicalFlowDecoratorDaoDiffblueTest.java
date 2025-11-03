package org.finos.waltz.data.datatype_decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import java.sql.Timestamp;
import java.time.LocalDate;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.datatype.DataTypeDecorator;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecorator;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LogicalFlowDecoratorDaoDiffblueTest {
  /**
   * Test {@link LogicalFlowDecoratorDao#getByEntityIdAndDataTypeId(long, long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalFlowDecoratorDao#getByEntityIdAndDataTypeId(long, long)}
   */
  @Test
  @DisplayName("Test getByEntityIdAndDataTypeId(long, long); given ResultSet next() return 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataTypeDecorator LogicalFlowDecoratorDao.getByEntityIdAndDataTypeId(long, long)"})
  void testGetByEntityIdAndDataTypeId_givenResultSetNextReturnFalse_thenReturnNull() throws SQLException {
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
    DataTypeDecorator actualByEntityIdAndDataTypeId = (new LogicalFlowDecoratorDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getByEntityIdAndDataTypeId(1L, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow_decorator\".\"logical_flow_id\", \"logical_flow_decorator\".\"decorator_entity_kind\", \"logical_flow_decorator\".\"decorator_entity_id\", \"logical_flow_decorator\".\"rating\", \"logical_flow_decorator\".\"provenance\", \"logical_flow_decorator\".\"last_updated_at\", \"logical_flow_decorator\".\"last_updated_by\", \"logical_flow_decorator\".\"id\", \"logical_flow_decorator\".\"is_readonly\", \"logical_flow_decorator\".\"flow_classification_rule_id\", \"logical_flow_decorator\".\"inbound_flow_classification_rule_id\", \"logical_flow_decorator\".\"target_inbound_rating\", case when \"logical_flow_decorator\".\"decorator_entity_kind\" = ? then (select \"data_type\".\"name\" from \"data_type\" where \"data_type\".\"id\" = \"logical_flow_decorator\".\"decorator_entity_id\") end from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" = ? and \"logical_flow_decorator\".\"decorator_entity_kind\" = ? and \"logical_flow_decorator\".\"decorator_entity_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DATA_TYPE"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualByEntityIdAndDataTypeId);
  }

  /**
   * Test {@link LogicalFlowDecoratorDao#getByEntityIdAndDataTypeId(long, long)}.
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalFlowDecoratorDao#getByEntityIdAndDataTypeId(long, long)}
   */
  @Test
  @DisplayName("Test getByEntityIdAndDataTypeId(long, long); then entityReference return ImmutableEntityReference")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataTypeDecorator LogicalFlowDecoratorDao.getByEntityIdAndDataTypeId(long, long)"})
  void testGetByEntityIdAndDataTypeId_thenEntityReferenceReturnImmutableEntityReference() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
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
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    DataTypeDecorator actualByEntityIdAndDataTypeId = logicalFlowDecoratorDao.getByEntityIdAndDataTypeId(1L, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow_decorator\".\"logical_flow_id\", \"logical_flow_decorator\".\"decorator_entity_kind\", \"logical_flow_decorator\".\"decorator_entity_id\", \"logical_flow_decorator\".\"rating\", \"logical_flow_decorator\".\"provenance\", \"logical_flow_decorator\".\"last_updated_at\", \"logical_flow_decorator\".\"last_updated_by\", \"logical_flow_decorator\".\"id\", \"logical_flow_decorator\".\"is_readonly\", \"logical_flow_decorator\".\"flow_classification_rule_id\", \"logical_flow_decorator\".\"inbound_flow_classification_rule_id\", \"logical_flow_decorator\".\"target_inbound_rating\", case when \"logical_flow_decorator\".\"decorator_entity_kind\" = ? then (select \"data_type\".\"name\" from \"data_type\" where \"data_type\".\"id\" = \"logical_flow_decorator\".\"decorator_entity_id\") end from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" = ? and \"logical_flow_decorator\".\"decorator_entity_kind\" = ? and \"logical_flow_decorator\".\"decorator_entity_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DATA_TYPE"));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(9));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet).getTimestamp(eq(6));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp).toLocalDateTime();
    assertTrue(actualByEntityIdAndDataTypeId.entityReference() instanceof ImmutableEntityReference);
    assertTrue(actualByEntityIdAndDataTypeId.decoratorEntity() instanceof ImmutableEntityReference);
    assertTrue(actualByEntityIdAndDataTypeId instanceof ImmutableDataTypeDecorator);
    assertEquals("String", actualByEntityIdAndDataTypeId.lastUpdatedBy());
    assertEquals("String", actualByEntityIdAndDataTypeId.provenance());
    assertEquals(1L, actualByEntityIdAndDataTypeId.dataFlowId());
    assertEquals(1L, actualByEntityIdAndDataTypeId.dataTypeId());
    assertTrue(logicalFlowDecoratorDao.findAll().isEmpty());
    assertTrue(actualByEntityIdAndDataTypeId.isReadonly());
  }
}
