package org.finos.waltz.data.attribute_change;

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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import org.finos.waltz.model.attribute_change.AttributeChange;
import org.finos.waltz.model.attribute_change.ImmutableAttributeChange;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AttributeChangeDaoDiffblueTest {
  /**
   * Method under test: {@link AttributeChangeDao#getById(long)}
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    AttributeChange actualById = (new AttributeChangeDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"attribute_change\".\"id\", \"attribute_change\".\"change_unit_id\", \"attribute_change\".\"type\", \"attribute_change\".\"new_value\", \"attribute_change\".\"old_value\", \"attribute_change\".\"name\", \"attribute_change\".\"last_updated_at\", \"attribute_change\".\"last_updated_by\", \"attribute_change\".\"provenance\" from \"attribute_change\" where \"attribute_change\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualById);
  }

  /**
   * Method under test: {@link AttributeChangeDao#getById(long)}
   */
  @Test
  void testGetById2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    AttributeChange actualById = (new AttributeChangeDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"attribute_change\".\"id\", \"attribute_change\".\"change_unit_id\", \"attribute_change\".\"type\", \"attribute_change\".\"new_value\", \"attribute_change\".\"old_value\", \"attribute_change\".\"name\", \"attribute_change\".\"last_updated_at\", \"attribute_change\".\"last_updated_by\", \"attribute_change\".\"provenance\" from \"attribute_change\" where \"attribute_change\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet).getTimestamp(eq(7));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp).getTime();
    assertTrue(actualById instanceof ImmutableAttributeChange);
    LocalDateTime lastUpdatedAtResult = actualById.lastUpdatedAt();
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("String", actualById.lastUpdatedBy());
    assertEquals("String", actualById.name());
    assertEquals("String", actualById.provenance());
    assertEquals("String", actualById.newValue());
    assertEquals("String", actualById.oldValue());
    assertEquals("String", actualById.type());
    assertEquals(1L, actualById.changeUnitId());
  }

  /**
   * Method under test: {@link AttributeChangeDao#findByChangeUnitId(long)}
   */
  @Test
  void testFindByChangeUnitId() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<AttributeChange> actualFindByChangeUnitIdResult = (new AttributeChangeDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByChangeUnitId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"attribute_change\".\"id\", \"attribute_change\".\"change_unit_id\", \"attribute_change\".\"type\", \"attribute_change\".\"new_value\", \"attribute_change\".\"old_value\", \"attribute_change\".\"name\", \"attribute_change\".\"last_updated_at\", \"attribute_change\".\"last_updated_by\", \"attribute_change\".\"provenance\" from \"attribute_change\" where \"attribute_change\".\"change_unit_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(7));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    assertEquals(2, actualFindByChangeUnitIdResult.size());
    AttributeChange getResult = actualFindByChangeUnitIdResult.get(0);
    assertTrue(getResult instanceof ImmutableAttributeChange);
    AttributeChange getResult2 = actualFindByChangeUnitIdResult.get(1);
    assertTrue(getResult2 instanceof ImmutableAttributeChange);
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("String", getResult.lastUpdatedBy());
    assertEquals("String", getResult.name());
    assertEquals("String", getResult.provenance());
    assertEquals("String", getResult.newValue());
    assertEquals("String", getResult.oldValue());
    assertEquals("String", getResult.type());
    assertEquals(1L, getResult.changeUnitId());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link AttributeChangeDao#findByChangeUnitId(long)}
   */
  @Test
  void testFindByChangeUnitId2() throws SQLException {
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<AttributeChange> actualFindByChangeUnitIdResult = (new AttributeChangeDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByChangeUnitId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"attribute_change\".\"id\", \"attribute_change\".\"change_unit_id\", \"attribute_change\".\"type\", \"attribute_change\".\"new_value\", \"attribute_change\".\"old_value\", \"attribute_change\".\"name\", \"attribute_change\".\"last_updated_at\", \"attribute_change\".\"last_updated_by\", \"attribute_change\".\"provenance\" from \"attribute_change\" where \"attribute_change\".\"change_unit_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByChangeUnitIdResult.isEmpty());
  }
}
