package org.finos.waltz.data.entity_enum;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
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
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.entity_enum.EntityEnumDefinition;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityEnumDefinitionDaoDiffblueTest {
  /**
   * Method under test:
   * {@link EntityEnumDefinitionDao#findByEntityKind(EntityKind)}
   */
  @Test
  void testFindByEntityKind() throws SQLException {
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
    List<EntityEnumDefinition> actualFindByEntityKindResult = (new EntityEnumDefinitionDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByEntityKind(EntityKind.ALL);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"entity_enum_definition\".\"id\", \"entity_enum_definition\".\"name\", \"entity_enum_definition\".\"description\", \"entity_enum_definition\".\"icon_name\", \"entity_enum_definition\".\"entity_kind\", \"entity_enum_definition\".\"enum_value_type\", \"entity_enum_definition\".\"position\", \"entity_enum_definition\".\"is_editable\" from \"entity_enum_definition\" where \"entity_enum_definition\".\"entity_kind\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("ALL"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByEntityKindResult.isEmpty());
  }
}
