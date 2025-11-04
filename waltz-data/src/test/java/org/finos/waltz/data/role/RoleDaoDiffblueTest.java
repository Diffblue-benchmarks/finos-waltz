package org.finos.waltz.data.role;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import java.util.Set;
import org.finos.waltz.model.role.ImmutableRole;
import org.finos.waltz.model.role.Role;
import org.finos.waltz.schema.tables.records.RoleRecord;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RoleDaoDiffblueTest {
  /**
   * Method under test: {@link RoleDao#create(RoleRecord)}
   */
  @Test
  void testCreate() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement);
    RoleDao roleDao = new RoleDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Long actualCreateResult = roleDao.create(new RoleRecord());

    // Assert
    verify(connection).prepareStatement(eq("insert into \"role\" values ()"), isA(String[].class));
    verify(preparedStatement).executeUpdate();
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getGeneratedKeys();
    verify(preparedStatement).getWarnings();
    assertEquals(1L, actualCreateResult.longValue());
  }

  /**
   * Method under test: {@link RoleDao#findAllRoles()}
   */
  @Test
  void testFindAllRoles() throws SQLException {
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Set<Role> actualFindAllRolesResult = (new RoleDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findAllRoles();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"role\".\"key\", \"role\".\"is_custom\", \"role\".\"name\", \"role\".\"description\", \"role\".\"user_selectable\", \"role\".\"id\" from \"role\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(anyInt());
    verify(resultSet, atLeast(1)).getLong(eq(6));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindAllRolesResult.size());
  }

  /**
   * Method under test: {@link RoleDao#findAllRoles()}
   */
  @Test
  void testFindAllRoles2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Set<Role> actualFindAllRolesResult = (new RoleDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findAllRoles();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"role\".\"key\", \"role\".\"is_custom\", \"role\".\"name\", \"role\".\"description\", \"role\".\"user_selectable\", \"role\".\"id\" from \"role\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindAllRolesResult.isEmpty());
  }

  /**
   * Method under test: {@link RoleDao#getRoleById(Long)}
   */
  @Test
  void testGetRoleById() throws SQLException {
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
    Role actualRoleById = (new RoleDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getRoleById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"role\".\"key\", \"role\".\"is_custom\", \"role\".\"name\", \"role\".\"description\", \"role\".\"user_selectable\", \"role\".\"id\" from \"role\" where \"role\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualRoleById);
  }

  /**
   * Method under test: {@link RoleDao#getRoleById(Long)}
   */
  @Test
  void testGetRoleById2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
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
    Role actualRoleById = (new RoleDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getRoleById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"role\".\"key\", \"role\".\"is_custom\", \"role\".\"name\", \"role\".\"description\", \"role\".\"user_selectable\", \"role\".\"id\" from \"role\" where \"role\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(anyInt());
    verify(resultSet).getLong(eq(6));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualRoleById instanceof ImmutableRole);
    assertEquals("String", actualRoleById.description());
    assertEquals("String", actualRoleById.key());
    assertEquals("String", actualRoleById.name());
    assertTrue(actualRoleById.isCustom());
    assertTrue(actualRoleById.userSelectable());
  }
}
