package org.finos.waltz.data.enum_value;

import static org.mockito.ArgumentMatchers.eq;
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
import java.util.function.Function;
import org.finos.waltz.model.enum_value.EnumValueKind;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EnumValueAliasDaoDiffblueTest {
  /**
   * Method under test:
   * {@link EnumValueAliasDao#mkAliases(EnumValueKind, Function)}
   */
  @Test
  void testMkAliases() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
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
    EnumValueAliasDao enumValueAliasDao = new EnumValueAliasDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    Function<String, Object> mapper = mock(Function.class);
    when(mapper.apply(Mockito.<String>any())).thenReturn("Apply");

    // Act
    enumValueAliasDao.mkAliases(EnumValueKind.TRANSPORT_KIND, mapper);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"enum_value\".\"key\", coalesce(\"enum_value_alias\".\"alias\", \"enum_value\".\"key\") from \"enum_value\" left outer join \"enum_value_alias\" on \"enum_value\".\"key\" = \"enum_value_alias\".\"enum_key\" where \"enum_value\".\"type\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("TransportKind"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(mapper, atLeast(1)).apply(eq("String"));
  }

  /**
   * Method under test:
   * {@link EnumValueAliasDao#mkAliases(EnumValueKind, Function)}
   */
  @Test
  void testMkAliases2() throws SQLException {
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
    (new EnumValueAliasDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .<Object>mkAliases(EnumValueKind.TRANSPORT_KIND, mock(Function.class));

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"enum_value\".\"key\", coalesce(\"enum_value_alias\".\"alias\", \"enum_value\".\"key\") from \"enum_value\" left outer join \"enum_value_alias\" on \"enum_value\".\"key\" = \"enum_value_alias\".\"enum_key\" where \"enum_value\".\"type\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("TransportKind"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
  }
}
