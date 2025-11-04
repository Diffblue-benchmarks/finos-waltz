package org.finos.waltz.data.allocation_scheme;

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
import java.util.List;
import org.finos.waltz.model.allocation_scheme.AllocationScheme;
import org.finos.waltz.model.allocation_scheme.ImmutableAllocationScheme;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AllocationSchemeDaoDiffblueTest {
  /**
   * Method under test: {@link AllocationSchemeDao#getById(long)}
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
    AllocationScheme actualById = (new AllocationSchemeDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"allocation_scheme\".\"id\", \"allocation_scheme\".\"name\", \"allocation_scheme\".\"description\", \"allocation_scheme\".\"measurable_category_id\", \"allocation_scheme\".\"external_id\" from \"allocation_scheme\" where \"allocation_scheme\".\"id\" = ?"));
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
   * Method under test: {@link AllocationSchemeDao#getById(long)}
   */
  @Test
  void testGetById2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
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
    AllocationScheme actualById = (new AllocationSchemeDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"allocation_scheme\".\"id\", \"allocation_scheme\".\"name\", \"allocation_scheme\".\"description\", \"allocation_scheme\".\"measurable_category_id\", \"allocation_scheme\".\"external_id\" from \"allocation_scheme\" where \"allocation_scheme\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualById instanceof ImmutableAllocationScheme);
    assertEquals("String", actualById.description());
    assertEquals("String", actualById.name());
    assertEquals(1L, actualById.measurableCategoryId());
  }

  /**
   * Method under test: {@link AllocationSchemeDao#getByExternalId(String)}
   */
  @Test
  void testGetByExternalId() throws SQLException {
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
    AllocationScheme actualByExternalId = (new AllocationSchemeDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getByExternalId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"allocation_scheme\".\"id\", \"allocation_scheme\".\"name\", \"allocation_scheme\".\"description\", \"allocation_scheme\".\"measurable_category_id\", \"allocation_scheme\".\"external_id\" from \"allocation_scheme\" where \"allocation_scheme\".\"external_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualByExternalId);
  }

  /**
   * Method under test: {@link AllocationSchemeDao#getByExternalId(String)}
   */
  @Test
  void testGetByExternalId2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
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
    AllocationScheme actualByExternalId = (new AllocationSchemeDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getByExternalId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"allocation_scheme\".\"id\", \"allocation_scheme\".\"name\", \"allocation_scheme\".\"description\", \"allocation_scheme\".\"measurable_category_id\", \"allocation_scheme\".\"external_id\" from \"allocation_scheme\" where \"allocation_scheme\".\"external_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualByExternalId instanceof ImmutableAllocationScheme);
    assertEquals("String", actualByExternalId.description());
    assertEquals("String", actualByExternalId.name());
    assertEquals(1L, actualByExternalId.measurableCategoryId());
  }

  /**
   * Method under test: {@link AllocationSchemeDao#findAll()}
   */
  @Test
  void testFindAll() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
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
    List<AllocationScheme> actualFindAllResult = (new AllocationSchemeDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"allocation_scheme\".\"id\", \"allocation_scheme\".\"name\", \"allocation_scheme\".\"description\", \"allocation_scheme\".\"measurable_category_id\", \"allocation_scheme\".\"external_id\" from \"allocation_scheme\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindAllResult.size());
    AllocationScheme getResult = actualFindAllResult.get(0);
    assertTrue(getResult instanceof ImmutableAllocationScheme);
    AllocationScheme getResult2 = actualFindAllResult.get(1);
    assertTrue(getResult2 instanceof ImmutableAllocationScheme);
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertEquals(1L, getResult.measurableCategoryId());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link AllocationSchemeDao#findAll()}
   */
  @Test
  void testFindAll2() throws SQLException {
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
    List<AllocationScheme> actualFindAllResult = (new AllocationSchemeDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"allocation_scheme\".\"id\", \"allocation_scheme\".\"name\", \"allocation_scheme\".\"description\", \"allocation_scheme\".\"measurable_category_id\", \"allocation_scheme\".\"external_id\" from \"allocation_scheme\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Method under test: {@link AllocationSchemeDao#findByCategoryId(long)}
   */
  @Test
  void testFindByCategoryId() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
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
    List<AllocationScheme> actualFindByCategoryIdResult = (new AllocationSchemeDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByCategoryId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"allocation_scheme\".\"id\", \"allocation_scheme\".\"name\", \"allocation_scheme\".\"description\", \"allocation_scheme\".\"measurable_category_id\", \"allocation_scheme\".\"external_id\" from \"allocation_scheme\" where \"allocation_scheme\".\"measurable_category_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindByCategoryIdResult.size());
    AllocationScheme getResult = actualFindByCategoryIdResult.get(0);
    assertTrue(getResult instanceof ImmutableAllocationScheme);
    AllocationScheme getResult2 = actualFindByCategoryIdResult.get(1);
    assertTrue(getResult2 instanceof ImmutableAllocationScheme);
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertEquals(1L, getResult.measurableCategoryId());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link AllocationSchemeDao#findByCategoryId(long)}
   */
  @Test
  void testFindByCategoryId2() throws SQLException {
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
    List<AllocationScheme> actualFindByCategoryIdResult = (new AllocationSchemeDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByCategoryId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"allocation_scheme\".\"id\", \"allocation_scheme\".\"name\", \"allocation_scheme\".\"description\", \"allocation_scheme\".\"measurable_category_id\", \"allocation_scheme\".\"external_id\" from \"allocation_scheme\" where \"allocation_scheme\".\"measurable_category_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByCategoryIdResult.isEmpty());
  }
}
