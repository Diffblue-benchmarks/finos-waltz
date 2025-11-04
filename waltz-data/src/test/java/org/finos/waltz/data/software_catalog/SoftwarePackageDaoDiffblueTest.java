package org.finos.waltz.data.software_catalog;

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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.software_catalog.ImmutableSoftwarePackage;
import org.finos.waltz.model.software_catalog.SoftwarePackage;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SoftwarePackageDaoDiffblueTest {
  /**
   * Method under test: {@link SoftwarePackageDao#findByIds(Collection)}
   */
  @Test
  void testFindByIds() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    SoftwarePackageDao softwarePackageDao = new SoftwarePackageDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    List<SoftwarePackage> actualFindByIdsResult = softwarePackageDao.findByIds(new ArrayList<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"software_package\".\"id\", \"software_package\".\"vendor\", \"software_package\".\"name\", \"software_package\".\"notable\", \"software_package\".\"description\", \"software_package\".\"external_id\", \"software_package\".\"provenance\", \"software_package\".\"created_by\", \"software_package\".\"created_at\", \"software_package\".\"group\" from \"software_package\" where \"software_package\".\"id\" in ()"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(4));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(9));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertEquals(2, actualFindByIdsResult.size());
    SoftwarePackage getResult = actualFindByIdsResult.get(0);
    assertTrue(getResult instanceof ImmutableSoftwarePackage);
    SoftwarePackage getResult2 = actualFindByIdsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableSoftwarePackage);
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertEquals("String", getResult.provenance());
    assertEquals("String", getResult.group());
    assertEquals("String", getResult.vendor());
    assertEquals(EntityKind.SOFTWARE, getResult.kind());
    assertTrue(getResult.isNotable());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link SoftwarePackageDao#findByIds(Long[])}
   */
  @Test
  void testFindByIds2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
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
    List<SoftwarePackage> actualFindByIdsResult = (new SoftwarePackageDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByIds(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"software_package\".\"id\", \"software_package\".\"vendor\", \"software_package\".\"name\", \"software_package\".\"notable\", \"software_package\".\"description\", \"software_package\".\"external_id\", \"software_package\".\"provenance\", \"software_package\".\"created_by\", \"software_package\".\"created_at\", \"software_package\".\"group\" from \"software_package\" where \"software_package\".\"id\" in (?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(4));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(9));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertEquals(2, actualFindByIdsResult.size());
    SoftwarePackage getResult = actualFindByIdsResult.get(0);
    assertTrue(getResult instanceof ImmutableSoftwarePackage);
    SoftwarePackage getResult2 = actualFindByIdsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableSoftwarePackage);
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertEquals("String", getResult.provenance());
    assertEquals("String", getResult.group());
    assertEquals("String", getResult.vendor());
    assertEquals(EntityKind.SOFTWARE, getResult.kind());
    assertTrue(getResult.isNotable());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link SoftwarePackageDao#getById(long)}
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
    SoftwarePackage actualById = (new SoftwarePackageDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"software_package\".\"id\", \"software_package\".\"vendor\", \"software_package\".\"name\", \"software_package\".\"notable\", \"software_package\".\"description\", \"software_package\".\"external_id\", \"software_package\".\"provenance\", \"software_package\".\"created_by\", \"software_package\".\"created_at\", \"software_package\".\"group\" from \"software_package\" where \"software_package\".\"id\" = ?"));
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
   * Method under test: {@link SoftwarePackageDao#getById(long)}
   */
  @Test
  void testGetById2() throws SQLException {
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    SoftwarePackage actualById = (new SoftwarePackageDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"software_package\".\"id\", \"software_package\".\"vendor\", \"software_package\".\"name\", \"software_package\".\"notable\", \"software_package\".\"description\", \"software_package\".\"external_id\", \"software_package\".\"provenance\", \"software_package\".\"created_by\", \"software_package\".\"created_at\", \"software_package\".\"group\" from \"software_package\" where \"software_package\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(4));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet).getTimestamp(eq(9));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp).toLocalDateTime();
    assertTrue(actualById instanceof ImmutableSoftwarePackage);
    assertEquals("String", actualById.description());
    assertEquals("String", actualById.name());
    assertEquals("String", actualById.provenance());
    assertEquals("String", actualById.group());
    assertEquals("String", actualById.vendor());
    assertEquals(EntityKind.SOFTWARE, actualById.kind());
    assertTrue(actualById.isNotable());
  }

  /**
   * Method under test: {@link SoftwarePackageDao#findAll()}
   */
  @Test
  void testFindAll() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<SoftwarePackage> actualFindAllResult = (new SoftwarePackageDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"software_package\".\"id\", \"software_package\".\"vendor\", \"software_package\".\"name\", \"software_package\".\"notable\", \"software_package\".\"description\", \"software_package\".\"external_id\", \"software_package\".\"provenance\", \"software_package\".\"created_by\", \"software_package\".\"created_at\", \"software_package\".\"group\" from \"software_package\" where 1 = 1"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(4));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(9));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertEquals(2, actualFindAllResult.size());
    SoftwarePackage getResult = actualFindAllResult.get(0);
    assertTrue(getResult instanceof ImmutableSoftwarePackage);
    SoftwarePackage getResult2 = actualFindAllResult.get(1);
    assertTrue(getResult2 instanceof ImmutableSoftwarePackage);
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertEquals("String", getResult.provenance());
    assertEquals("String", getResult.group());
    assertEquals("String", getResult.vendor());
    assertEquals(EntityKind.SOFTWARE, getResult.kind());
    assertTrue(getResult.isNotable());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link SoftwarePackageDao#search(EntitySearchOptions)}
   */
  @Test
  void testSearch() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    SoftwarePackageDao softwarePackageDao = new SoftwarePackageDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<SoftwarePackage> actualSearchResult = softwarePackageDao.search(options);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(eq(3), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(4));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(9));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    verify(options, atLeast(1)).limit();
    verify(options).searchQuery();
    assertEquals(1, actualSearchResult.size());
    SoftwarePackage getResult = actualSearchResult.get(0);
    assertTrue(getResult instanceof ImmutableSoftwarePackage);
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertEquals("String", getResult.provenance());
    assertEquals("String", getResult.group());
    assertEquals("String", getResult.vendor());
    assertEquals(EntityKind.SOFTWARE, getResult.kind());
    assertTrue(getResult.isNotable());
  }

  /**
   * Method under test: {@link SoftwarePackageDao#search(EntitySearchOptions)}
   */
  @Test
  void testSearch2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
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
    SoftwarePackageDao softwarePackageDao = new SoftwarePackageDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<SoftwarePackage> actualSearchResult = softwarePackageDao.search(options);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(eq(3), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet).getBoolean(eq(4));
    verify(resultSet).getLong(eq(1));
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet).getTimestamp(eq(9));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(timestamp).toLocalDateTime();
    verify(options, atLeast(1)).limit();
    verify(options).searchQuery();
    assertEquals(1, actualSearchResult.size());
    SoftwarePackage getResult = actualSearchResult.get(0);
    assertTrue(getResult instanceof ImmutableSoftwarePackage);
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertEquals("String", getResult.provenance());
    assertEquals("String", getResult.group());
    assertEquals("String", getResult.vendor());
    assertEquals(EntityKind.SOFTWARE, getResult.kind());
    assertTrue(getResult.isNotable());
  }
}
