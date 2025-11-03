package org.finos.waltz.data.physical_specification;

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
import org.finos.waltz.model.physical_specification.PhysicalSpecification;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PhysicalSpecificationDaoDiffblueTest {
  /**
   * Test {@link PhysicalSpecificationDao#getById(long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhysicalSpecificationDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); given ResultSet next() return 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PhysicalSpecification PhysicalSpecificationDao.getById(long)"})
  void testGetById_givenResultSetNextReturnFalse_thenReturnNull() throws SQLException {
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
    PhysicalSpecification actualById = (new PhysicalSpecificationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"physical_specification\".\"id\", \"physical_specification\".\"owning_entity_id\", \"physical_specification\".\"external_id\", \"physical_specification\".\"name\", \"physical_specification\".\"format\", \"physical_specification\".\"description\", \"physical_specification\".\"provenance\", \"physical_specification\".\"owning_entity_kind\", \"physical_specification\".\"last_updated_at\", \"physical_specification\".\"last_updated_by\", \"physical_specification\".\"is_removed\", \"physical_specification\".\"created_at\", \"physical_specification\".\"created_by\", \"physical_specification\".\"is_readonly\", case when \"physical_specification\".\"owning_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"physical_specification\".\"owning_entity_id\") when \"physical_specification\".\"owning_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"physical_specification\".\"owning_entity_id\") end \"owning_name_field\" from \"physical_specification\" where \"physical_specification\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualById);
  }
}
