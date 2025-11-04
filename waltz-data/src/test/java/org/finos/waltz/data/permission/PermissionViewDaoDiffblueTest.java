package org.finos.waltz.data.permission;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
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
import java.util.Set;
import org.finos.waltz.model.permission.PermissionViewItem;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PermissionViewDaoDiffblueTest {
  /**
   * Method under test: {@link PermissionViewDao#findAll()}
   */
  @Test
  void testFindAll() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setObject(anyInt(), Mockito.<Object>any());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Set<PermissionViewItem> actualFindAllResult = (new PermissionViewDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"pg\".\"name\", \"pg\".\"id\", \"pg\".\"external_id\", \"pg\".\"description\", \"pgi\".\"parent_kind\", \"pgi\".\"subject_kind\", \"pgi\".\"qualifier_kind\", \"pgi\".\"qualifier_id\", coalesce(\"mc\".\"name\", \"ad\".\"name\", ?) \"qualifier_name\", \"pgi\".\"operation\", \"ig\".\"name\", \"ig\".\"id\", \"ig\".\"external_id\", \"ik\".\"name\", \"ik\".\"description\", \"ik\".\"external_id\", \"ik\".\"id\" from \"involvement_group\" \"ig\" join \"permission_group_involvement\" \"pgi\" on \"pgi\".\"involvement_group_id\" = \"ig\".\"id\" join \"involvement_group_entry\" \"ige\" on \"ig\".\"id\" = \"ige\".\"involvement_group_id\" join \"involvement_kind\" \"ik\" on \"ik\".\"id\" = \"ige\".\"involvement_kind_id\" join \"permission_group\" \"pg\" on \"pg\".\"id\" = \"pgi\".\"permission_group_id\" left outer join \"measurable_category\" \"mc\" on (\"pgi\".\"qualifier_kind\" = ? and \"mc\".\"id\" = \"pgi\".\"qualifier_id\") left outer join \"assessment_definition\" \"ad\" on (\"pgi\".\"qualifier_kind\" = ? and \"ad\".\"id\" = \"pgi\".\"qualifier_id\")"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setObject(eq(1), isNull());
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindAllResult.isEmpty());
  }
}
