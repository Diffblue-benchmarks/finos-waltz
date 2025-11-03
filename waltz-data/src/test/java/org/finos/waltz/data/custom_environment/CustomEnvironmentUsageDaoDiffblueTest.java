package org.finos.waltz.data.custom_environment;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import org.finos.waltz.model.custom_environment.CustomEnvironmentUsageInfo;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CustomEnvironmentUsageDaoDiffblueTest {
  /**
   * Test {@link CustomEnvironmentUsageDao#getUsageInfoById(Long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomEnvironmentUsageDao#getUsageInfoById(Long)}
   */
  @Test
  @DisplayName("Test getUsageInfoById(Long); given ResultSet next() return 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CustomEnvironmentUsageInfo CustomEnvironmentUsageDao.getUsageInfoById(Long)"})
  void testGetUsageInfoById_givenResultSetNextReturnFalse_thenReturnNull() throws SQLException {
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
    CustomEnvironmentUsageInfo actualUsageInfoById = (new CustomEnvironmentUsageDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getUsageInfoById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"custom_environment_usage\".\"id\", \"custom_environment_usage\".\"custom_environment_id\", \"custom_environment_usage\".\"entity_id\", \"custom_environment_usage\".\"entity_kind\", \"custom_environment_usage\".\"created_at\", \"custom_environment_usage\".\"created_by\", \"custom_environment_usage\".\"provenance\", \"server_information\".\"id\", \"server_information\".\"hostname\", \"server_information\".\"operating_system\", \"server_information\".\"location\", \"server_information\".\"operating_system_version\", \"server_information\".\"country\", \"server_information\".\"is_virtual\", \"server_information\".\"provenance\", \"server_information\".\"os_end_of_life_date\", \"server_information\".\"hw_end_of_life_date\", \"server_information\".\"lifecycle_status\", \"server_information\".\"external_id\", \"server_owning_app\".\"id\", \"server_owning_app\".\"name\", \"server_owning_app\".\"description\", \"server_owning_app\".\"asset_code\", \"server_owning_app\".\"created_at\", \"server_owning_app\".\"updated_at\", \"server_owning_app\".\"organisational_unit_id\", \"server_owning_app\".\"kind\", \"server_owning_app\".\"lifecycle_phase\", \"server_owning_app\".\"parent_asset_code\", \"server_owning_app\".\"overall_rating\", \"server_owning_app\".\"provenance\", \"server_owning_app\".\"business_criticality\", \"server_owning_app\".\"is_removed\", \"server_owning_app\".\"entity_lifecycle_status\", \"server_owning_app\".\"planned_retirement_date\", \"server_owning_app\".\"actual_retirement_date\", \"server_owning_app\".\"commission_date\", \"database_information\".\"id\", \"database_information\".\"database_name\", \"database_information\".\"instance_name\", \"database_information\".\"dbms_vendor\", \"database_information\".\"dbms_name\", \"database_information\".\"dbms_version\", \"database_information\".\"external_id\", \"database_information\".\"end_of_life_date\", \"database_information\".\"lifecycle_status\", \"database_information\".\"provenance\", \"database_owning_app\".\"id\", \"database_owning_app\".\"name\", \"database_owning_app\".\"description\", \"database_owning_app\".\"asset_code\", \"database_owning_app\".\"created_at\", \"database_owning_app\".\"updated_at\", \"database_owning_app\".\"organisational_unit_id\", \"database_owning_app\".\"kind\", \"database_owning_app\".\"lifecycle_phase\", \"database_owning_app\".\"parent_asset_code\", \"database_owning_app\".\"overall_rating\", \"database_owning_app\".\"provenance\", \"database_owning_app\".\"business_criticality\", \"database_owning_app\".\"is_removed\", \"database_owning_app\".\"entity_lifecycle_status\", \"database_owning_app\".\"planned_retirement_date\", \"database_owning_app\".\"actual_retirement_date\", \"database_owning_app\".\"commission_date\" from \"custom_environment_usage\" join \"custom_environment\" on \"custom_environment_usage\".\"custom_environment_id\" = \"custom_environment\".\"id\" left outer join \"server_usage\" on (\"custom_environment_usage\".\"entity_id\" = \"server_usage\".\"id\" and \"custom_environment_usage\".\"entity_kind\" = ?) left outer join \"server_information\" on \"server_usage\".\"server_id\" = \"server_information\".\"id\" left outer join \"application\" \"server_owning_app\" on (\"server_usage\".\"entity_id\" = \"server_owning_app\".\"id\" and \"server_usage\".\"entity_kind\" = ?) left outer join \"database_usage\" on (\"custom_environment_usage\".\"entity_id\" = \"database_usage\".\"id\" and \"custom_environment_usage\".\"entity_kind\" = ?) left outer join \"database_information\" on \"database_usage\".\"database_id\" = \"database_information\".\"id\" left outer join \"application\" \"database_owning_app\" on (\"database_usage\".\"entity_id\" = \"database_owning_app\".\"id\" and \"database_usage\".\"entity_kind\" = ?) where (\"custom_environment_usage\".\"id\" = ? and (\"database_information\".\"id\" is not null or \"server_information\".\"id\" is not null))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(5), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualUsageInfoById);
  }
}
