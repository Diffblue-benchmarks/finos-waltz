package org.finos.waltz.data.database_information;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Optional;
import org.finos.waltz.model.LifecycleStatus;
import org.finos.waltz.model.database_information.DatabaseInformation;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DatabaseInformationDaoDiffblueTest {
  /**
   * Test {@link DatabaseInformationDao#createDatabase(DatabaseInformation)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} return one.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseInformationDao#createDatabase(DatabaseInformation)}
   */
  @Test
  @DisplayName("Test createDatabase(DatabaseInformation); given ResultSet getLong(int) return one; then return longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DatabaseInformationDao.createDatabase(DatabaseInformation)"})
  void testCreateDatabase_givenResultSetGetLongReturnOne_thenReturnLongValueIsOne() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement);
    DatabaseInformationDao databaseInformationDao = new DatabaseInformationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));
    DatabaseInformation info = mock(DatabaseInformation.class);
    when(info.databaseName()).thenReturn("Database Name");
    when(info.dbmsName()).thenReturn("Dbms Name");
    when(info.dbmsVendor()).thenReturn("Dbms Vendor");
    when(info.dbmsVersion()).thenReturn("1.0.2");
    when(info.instanceName()).thenReturn("Instance Name");
    when(info.endOfLifeDate())
        .thenReturn(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Optional<String> ofResult = Optional.of("foo");
    when(info.externalId()).thenReturn(ofResult);
    when(info.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(info.provenance()).thenReturn("Provenance");

    // Act
    Long actualCreateDatabaseResult = databaseInformationDao.createDatabase(info);

    // Assert
    verify(connection).prepareStatement(eq(
        "insert into \"database_information\" (\"database_name\", \"instance_name\", \"dbms_vendor\", \"dbms_name\", \"dbms_version\", \"external_id\", \"end_of_life_date\", \"lifecycle_status\", \"provenance\") values (?, ?, ?, ?, ?, ?, ?, ?, ?)"),
        isA(String[].class));
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement).setDate(eq(7), isA(Date.class));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getGeneratedKeys();
    verify(preparedStatement).getWarnings();
    verify(info).externalId();
    verify(info).provenance();
    verify(info).databaseName();
    verify(info).dbmsName();
    verify(info).dbmsVendor();
    verify(info).dbmsVersion();
    verify(info).endOfLifeDate();
    verify(info).instanceName();
    verify(info).lifecycleStatus();
    assertEquals(1L, actualCreateDatabaseResult.longValue());
  }

  /**
   * Test {@link DatabaseInformationDao#createDatabase(DatabaseInformation)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#wasNull()} return {@code true}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseInformationDao#createDatabase(DatabaseInformation)}
   */
  @Test
  @DisplayName("Test createDatabase(DatabaseInformation); given ResultSet wasNull() return 'true'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long DatabaseInformationDao.createDatabase(DatabaseInformation)"})
  void testCreateDatabase_givenResultSetWasNullReturnTrue_thenReturnNull() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getLong(anyInt())).thenReturn(0L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement);
    DatabaseInformationDao databaseInformationDao = new DatabaseInformationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));
    DatabaseInformation info = mock(DatabaseInformation.class);
    when(info.databaseName()).thenReturn("Database Name");
    when(info.dbmsName()).thenReturn("Dbms Name");
    when(info.dbmsVendor()).thenReturn("Dbms Vendor");
    when(info.dbmsVersion()).thenReturn("1.0.2");
    when(info.instanceName()).thenReturn("Instance Name");
    when(info.endOfLifeDate())
        .thenReturn(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Optional<String> ofResult = Optional.of("foo");
    when(info.externalId()).thenReturn(ofResult);
    when(info.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(info.provenance()).thenReturn("Provenance");

    // Act
    Long actualCreateDatabaseResult = databaseInformationDao.createDatabase(info);

    // Assert
    verify(connection).prepareStatement(eq(
        "insert into \"database_information\" (\"database_name\", \"instance_name\", \"dbms_vendor\", \"dbms_name\", \"dbms_version\", \"external_id\", \"end_of_life_date\", \"lifecycle_status\", \"provenance\") values (?, ?, ?, ?, ?, ?, ?, ?, ?)"),
        isA(String[].class));
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement).setDate(eq(7), isA(Date.class));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement).close();
    verify(preparedStatement).getGeneratedKeys();
    verify(preparedStatement).getWarnings();
    verify(info).externalId();
    verify(info).provenance();
    verify(info).databaseName();
    verify(info).dbmsName();
    verify(info).dbmsVendor();
    verify(info).dbmsVersion();
    verify(info).endOfLifeDate();
    verify(info).instanceName();
    verify(info).lifecycleStatus();
    assertNull(actualCreateDatabaseResult);
  }
}
