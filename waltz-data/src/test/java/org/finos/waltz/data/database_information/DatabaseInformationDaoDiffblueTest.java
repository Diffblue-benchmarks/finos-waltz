package org.finos.waltz.data.database_information;

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
import org.finos.waltz.model.database_information.DatabaseInformation;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DatabaseInformationDaoDiffblueTest {
  /**
   * Method under test: {@link DatabaseInformationDao#findByApplicationId(long)}
   */
  @Test
  void testFindByApplicationId() throws SQLException {
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
    List<DatabaseInformation> actualFindByApplicationIdResult = (new DatabaseInformationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByApplicationId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"database_information\".\"id\", \"database_information\".\"database_name\", \"database_information\".\"instance_name\", \"database_information\".\"dbms_vendor\", \"database_information\".\"dbms_name\", \"database_information\".\"dbms_version\", \"database_information\".\"external_id\", \"database_information\".\"end_of_life_date\", \"database_information\".\"lifecycle_status\", \"database_information\".\"provenance\" from \"database_information\" join \"database_usage\" on (\"database_usage\".\"database_id\" = \"database_information\".\"id\" and \"database_usage\".\"entity_kind\" = ?) where \"database_usage\".\"entity_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("APPLICATION"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByApplicationIdResult.isEmpty());
  }

  /**
   * Method under test: {@link DatabaseInformationDao#getById(long)}
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
    DatabaseInformation actualById = (new DatabaseInformationDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"database_information\".\"id\", \"database_information\".\"database_name\", \"database_information\".\"instance_name\", \"database_information\".\"dbms_vendor\", \"database_information\".\"dbms_name\", \"database_information\".\"dbms_version\", \"database_information\".\"external_id\", \"database_information\".\"end_of_life_date\", \"database_information\".\"lifecycle_status\", \"database_information\".\"provenance\" from \"database_information\" where \"database_information\".\"id\" = ?"));
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
   * Method under test: {@link DatabaseInformationDao#getByExternalId(String)}
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
    DatabaseInformation actualByExternalId = (new DatabaseInformationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getByExternalId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"database_information\".\"id\", \"database_information\".\"database_name\", \"database_information\".\"instance_name\", \"database_information\".\"dbms_vendor\", \"database_information\".\"dbms_name\", \"database_information\".\"dbms_version\", \"database_information\".\"external_id\", \"database_information\".\"end_of_life_date\", \"database_information\".\"lifecycle_status\", \"database_information\".\"provenance\" from \"database_information\" where \"database_information\".\"external_id\" = ?"));
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
   * Method under test: {@link DatabaseInformationDao#search(EntitySearchOptions)}
   */
  @Test
  void testSearch() throws SQLException {
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
    DatabaseInformationDao databaseInformationDao = new DatabaseInformationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));
    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<DatabaseInformation> actualSearchResult = databaseInformationDao.search(options);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"database_information\".\"id\", \"database_information\".\"database_name\", \"database_information\".\"instance_name\", \"database_information\".\"dbms_vendor\", \"database_information\".\"dbms_name\", \"database_information\".\"dbms_version\", \"database_information\".\"external_id\", \"database_information\".\"end_of_life_date\", \"database_information\".\"lifecycle_status\", \"database_information\".\"provenance\" from \"database_information\" where (1 = 0 or lower(\"database_information\".\"external_id\") like lower((replace(replace(replace(?, '!', '!!'), '%', '!%'), '_', '!_') || '%')) escape '!' or lower(\"database_information\".\"external_id\") like lower((replace(replace(replace(?, '!', '!!'), '%', '!%'), '_', '!_') || '%')) escape '!' or (1 = 1 and lower(\"database_information\".\"database_name\") like lower(('%' || replace(replace(replace(?, '!', '!!'), '%', '!%'), '_', '!_') || '%')) escape '!' and lower(\"database_information\".\"database_name\") like lower(('%' || replace(replace(replace(?, '!', '!!'), '%', '!%'), '_', '!_') || '%')) escape '!') or (1 = 1 and lower(\"database_information\".\"instance_name\") like lower(('%' || replace(replace(replace(?, '!', '!!'), '%', '!%'), '_', '!_') || '%')) escape '!' and lower(\"database_information\".\"instance_name\") like lower(('%' || replace(replace(replace(?, '!', '!!'), '%', '!%'), '_', '!_') || '%')) escape '!')) order by \"database_information\".\"database_name\" limit ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(7), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(options).limit();
    verify(options).searchQuery();
    assertTrue(actualSearchResult.isEmpty());
  }
}
