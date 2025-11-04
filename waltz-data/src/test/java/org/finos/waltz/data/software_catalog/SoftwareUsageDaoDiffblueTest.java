package org.finos.waltz.data.software_catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.software_catalog.ImmutableSoftwareUsage;
import org.finos.waltz.model.software_catalog.SoftwareUsage;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SoftwareUsageDaoDiffblueTest {
  /**
   * Method under test: {@link SoftwareUsageDao#findByAppIds(List)}
   */
  @Test
  void testFindByAppIds() throws SQLException {
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
    SoftwareUsageDao softwareUsageDao = new SoftwareUsageDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    List<SoftwareUsage> actualFindByAppIdsResult = softwareUsageDao.findByAppIds(new ArrayList<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"software_usage\".\"application_id\", \"software_usage\".\"software_version_id\", \"software_usage\".\"provenance\", \"software_version\".\"software_package_id\", \"software_version_licence\".\"licence_id\" from \"software_usage\" join \"software_version\" on \"software_version\".\"id\" = \"software_usage\".\"software_version_id\" left outer join \"software_version_licence\" on \"software_version_licence\".\"software_version_id\" = \"software_version\".\"id\" where \"software_usage\".\"application_id\" in ()"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindByAppIdsResult.size());
    SoftwareUsage getResult = actualFindByAppIdsResult.get(0);
    assertTrue(getResult instanceof ImmutableSoftwareUsage);
    SoftwareUsage getResult2 = actualFindByAppIdsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableSoftwareUsage);
    assertEquals("String", getResult.provenance());
    assertEquals(1L, getResult.licenceId().longValue());
    assertEquals(1L, getResult.applicationId());
    assertEquals(1L, getResult.softwarePackageId());
    assertEquals(1L, getResult.softwareVersionId());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link SoftwareUsageDao#findByAppIds(List)}
   */
  @Test
  void testFindByAppIds2() throws SQLException {
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
    SoftwareUsageDao softwareUsageDao = new SoftwareUsageDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    List<SoftwareUsage> actualFindByAppIdsResult = softwareUsageDao.findByAppIds(new ArrayList<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"software_usage\".\"application_id\", \"software_usage\".\"software_version_id\", \"software_usage\".\"provenance\", \"software_version\".\"software_package_id\", \"software_version_licence\".\"licence_id\" from \"software_usage\" join \"software_version\" on \"software_version\".\"id\" = \"software_usage\".\"software_version_id\" left outer join \"software_version_licence\" on \"software_version_licence\".\"software_version_id\" = \"software_version\".\"id\" where \"software_usage\".\"application_id\" in ()"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByAppIdsResult.isEmpty());
  }

  /**
   * Method under test: {@link SoftwareUsageDao#findByAppIds(Long[])}
   */
  @Test
  void testFindByAppIds3() throws SQLException {
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
    List<SoftwareUsage> actualFindByAppIdsResult = (new SoftwareUsageDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByAppIds(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"software_usage\".\"application_id\", \"software_usage\".\"software_version_id\", \"software_usage\".\"provenance\", \"software_version\".\"software_package_id\", \"software_version_licence\".\"licence_id\" from \"software_usage\" join \"software_version\" on \"software_version\".\"id\" = \"software_usage\".\"software_version_id\" left outer join \"software_version_licence\" on \"software_version_licence\".\"software_version_id\" = \"software_version\".\"id\" where \"software_usage\".\"application_id\" in (?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindByAppIdsResult.size());
    SoftwareUsage getResult = actualFindByAppIdsResult.get(0);
    assertTrue(getResult instanceof ImmutableSoftwareUsage);
    SoftwareUsage getResult2 = actualFindByAppIdsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableSoftwareUsage);
    assertEquals("String", getResult.provenance());
    assertEquals(1L, getResult.licenceId().longValue());
    assertEquals(1L, getResult.applicationId());
    assertEquals(1L, getResult.softwarePackageId());
    assertEquals(1L, getResult.softwareVersionId());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link SoftwareUsageDao#findByAppIds(Long[])}
   */
  @Test
  void testFindByAppIds4() throws SQLException {
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
    List<SoftwareUsage> actualFindByAppIdsResult = (new SoftwareUsageDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByAppIds(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"software_usage\".\"application_id\", \"software_usage\".\"software_version_id\", \"software_usage\".\"provenance\", \"software_version\".\"software_package_id\", \"software_version_licence\".\"licence_id\" from \"software_usage\" join \"software_version\" on \"software_version\".\"id\" = \"software_usage\".\"software_version_id\" left outer join \"software_version_licence\" on \"software_version_licence\".\"software_version_id\" = \"software_version\".\"id\" where \"software_usage\".\"application_id\" in (?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByAppIdsResult.isEmpty());
  }

  /**
   * Method under test: {@link SoftwareUsageDao#findBySoftwarePackageIds(Long[])}
   */
  @Test
  void testFindBySoftwarePackageIds() throws SQLException {
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
    List<SoftwareUsage> actualFindBySoftwarePackageIdsResult = (new SoftwareUsageDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findBySoftwarePackageIds(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"software_usage\".\"application_id\", \"software_usage\".\"software_version_id\", \"software_usage\".\"provenance\", \"software_version\".\"software_package_id\", \"software_version_licence\".\"licence_id\" from \"software_usage\" join \"software_version\" on \"software_version\".\"id\" = \"software_usage\".\"software_version_id\" left outer join \"software_version_licence\" on \"software_version_licence\".\"software_version_id\" = \"software_version\".\"id\" where \"software_version\".\"software_package_id\" in (?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindBySoftwarePackageIdsResult.size());
    SoftwareUsage getResult = actualFindBySoftwarePackageIdsResult.get(0);
    assertTrue(getResult instanceof ImmutableSoftwareUsage);
    SoftwareUsage getResult2 = actualFindBySoftwarePackageIdsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableSoftwareUsage);
    assertEquals("String", getResult.provenance());
    assertEquals(1L, getResult.licenceId().longValue());
    assertEquals(1L, getResult.applicationId());
    assertEquals(1L, getResult.softwarePackageId());
    assertEquals(1L, getResult.softwareVersionId());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link SoftwareUsageDao#findBySoftwarePackageIds(Long[])}
   */
  @Test
  void testFindBySoftwarePackageIds2() throws SQLException {
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
    List<SoftwareUsage> actualFindBySoftwarePackageIdsResult = (new SoftwareUsageDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findBySoftwarePackageIds(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"software_usage\".\"application_id\", \"software_usage\".\"software_version_id\", \"software_usage\".\"provenance\", \"software_version\".\"software_package_id\", \"software_version_licence\".\"licence_id\" from \"software_usage\" join \"software_version\" on \"software_version\".\"id\" = \"software_usage\".\"software_version_id\" left outer join \"software_version_licence\" on \"software_version_licence\".\"software_version_id\" = \"software_version\".\"id\" where \"software_version\".\"software_package_id\" in (?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindBySoftwarePackageIdsResult.isEmpty());
  }

  /**
   * Method under test: {@link SoftwareUsageDao#findBySoftwareVersionId(long)}
   */
  @Test
  void testFindBySoftwareVersionId() throws SQLException {
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
    List<SoftwareUsage> actualFindBySoftwareVersionIdResult = (new SoftwareUsageDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findBySoftwareVersionId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"software_usage\".\"application_id\", \"software_usage\".\"software_version_id\", \"software_usage\".\"provenance\", \"software_version\".\"software_package_id\", \"software_version_licence\".\"licence_id\" from \"software_usage\" join \"software_version\" on \"software_version\".\"id\" = \"software_usage\".\"software_version_id\" left outer join \"software_version_licence\" on \"software_version_licence\".\"software_version_id\" = \"software_version\".\"id\" where \"software_version\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindBySoftwareVersionIdResult.size());
    SoftwareUsage getResult = actualFindBySoftwareVersionIdResult.get(0);
    assertTrue(getResult instanceof ImmutableSoftwareUsage);
    SoftwareUsage getResult2 = actualFindBySoftwareVersionIdResult.get(1);
    assertTrue(getResult2 instanceof ImmutableSoftwareUsage);
    assertEquals("String", getResult.provenance());
    assertEquals(1L, getResult.licenceId().longValue());
    assertEquals(1L, getResult.applicationId());
    assertEquals(1L, getResult.softwarePackageId());
    assertEquals(1L, getResult.softwareVersionId());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link SoftwareUsageDao#findBySoftwareVersionId(long)}
   */
  @Test
  void testFindBySoftwareVersionId2() throws SQLException {
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
    List<SoftwareUsage> actualFindBySoftwareVersionIdResult = (new SoftwareUsageDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findBySoftwareVersionId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"software_usage\".\"application_id\", \"software_usage\".\"software_version_id\", \"software_usage\".\"provenance\", \"software_version\".\"software_package_id\", \"software_version_licence\".\"licence_id\" from \"software_usage\" join \"software_version\" on \"software_version\".\"id\" = \"software_usage\".\"software_version_id\" left outer join \"software_version_licence\" on \"software_version_licence\".\"software_version_id\" = \"software_version\".\"id\" where \"software_version\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindBySoftwareVersionIdResult.isEmpty());
  }

  /**
   * Method under test: {@link SoftwareUsageDao#findByLicenceId(long)}
   */
  @Test
  void testFindByLicenceId() throws SQLException {
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
    List<SoftwareUsage> actualFindByLicenceIdResult = (new SoftwareUsageDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByLicenceId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"software_usage\".\"application_id\", \"software_usage\".\"software_version_id\", \"software_usage\".\"provenance\", \"software_version\".\"software_package_id\", \"software_version_licence\".\"licence_id\" from \"software_usage\" join \"software_version\" on \"software_version\".\"id\" = \"software_usage\".\"software_version_id\" left outer join \"software_version_licence\" on \"software_version_licence\".\"software_version_id\" = \"software_version\".\"id\" where \"software_version_licence\".\"licence_id\" in (?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindByLicenceIdResult.size());
    SoftwareUsage getResult = actualFindByLicenceIdResult.get(0);
    assertTrue(getResult instanceof ImmutableSoftwareUsage);
    SoftwareUsage getResult2 = actualFindByLicenceIdResult.get(1);
    assertTrue(getResult2 instanceof ImmutableSoftwareUsage);
    assertEquals("String", getResult.provenance());
    assertEquals(1L, getResult.licenceId().longValue());
    assertEquals(1L, getResult.applicationId());
    assertEquals(1L, getResult.softwarePackageId());
    assertEquals(1L, getResult.softwareVersionId());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link SoftwareUsageDao#findByLicenceId(long)}
   */
  @Test
  void testFindByLicenceId2() throws SQLException {
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
    List<SoftwareUsage> actualFindByLicenceIdResult = (new SoftwareUsageDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByLicenceId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"software_usage\".\"application_id\", \"software_usage\".\"software_version_id\", \"software_usage\".\"provenance\", \"software_version\".\"software_package_id\", \"software_version_licence\".\"licence_id\" from \"software_usage\" join \"software_version\" on \"software_version\".\"id\" = \"software_usage\".\"software_version_id\" left outer join \"software_version_licence\" on \"software_version_licence\".\"software_version_id\" = \"software_version\".\"id\" where \"software_version_licence\".\"licence_id\" in (?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByLicenceIdResult.isEmpty());
  }
}
