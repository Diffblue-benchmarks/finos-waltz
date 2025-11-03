package org.finos.waltz.data.entity_relationship;

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
import org.finos.waltz.model.entity_relationship.EntityRelationship;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityRelationshipDaoDiffblueTest {
  /**
   * Test {@link EntityRelationshipDao#getById(Long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityRelationshipDao#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long); given ResultSet next() return 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityRelationship EntityRelationshipDao.getById(Long)"})
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
    EntityRelationship actualById = (new EntityRelationshipDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"entity_relationship\".\"kind_a\", \"entity_relationship\".\"id_a\", \"entity_relationship\".\"kind_b\", \"entity_relationship\".\"id_b\", \"entity_relationship\".\"relationship\", \"entity_relationship\".\"provenance\", \"entity_relationship\".\"description\", \"entity_relationship\".\"last_updated_at\", \"entity_relationship\".\"last_updated_by\", \"entity_relationship\".\"id\", case when \"entity_relationship\".\"kind_a\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"entity_relationship\".\"id_a\") when \"entity_relationship\".\"kind_a\" = ? then (select \"application_group\".\"name\" from \"application_group\" where \"application_group\".\"id\" = \"entity_relationship\".\"id_a\") when \"entity_relationship\".\"kind_a\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"entity_relationship\".\"id_a\") when \"entity_relationship\".\"kind_a\" = ? then (select \"measurable\".\"name\" from \"measurable\" where \"measurable\".\"id\" = \"entity_relationship\".\"id_a\") when \"entity_relationship\".\"kind_a\" = ? then (select \"change_initiative\".\"name\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"entity_relationship\".\"id_a\") end, case when \"entity_relationship\".\"kind_b\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"entity_relationship\".\"id_b\") when \"entity_relationship\".\"kind_b\" = ? then (select \"application_group\".\"name\" from \"application_group\" where \"application_group\".\"id\" = \"entity_relationship\".\"id_b\") when \"entity_relationship\".\"kind_b\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"entity_relationship\".\"id_b\") when \"entity_relationship\".\"kind_b\" = ? then (select \"measurable\".\"name\" from \"measurable\" where \"measurable\".\"id\" = \"entity_relationship\".\"id_b\") when \"entity_relationship\".\"kind_b\" = ? then (select \"change_initiative\".\"name\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"entity_relationship\".\"id_b\") end, case when \"entity_relationship\".\"kind_a\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"entity_relationship\".\"id_a\") when \"entity_relationship\".\"kind_a\" = ? then (select \"application_group\".\"external_id\" from \"application_group\" where \"application_group\".\"id\" = \"entity_relationship\".\"id_a\") when \"entity_relationship\".\"kind_a\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"entity_relationship\".\"id_a\") when \"entity_relationship\".\"kind_a\" = ? then (select \"measurable\".\"external_id\" from \"measurable\" where \"measurable\".\"id\" = \"entity_relationship\".\"id_a\") when \"entity_relationship\".\"kind_a\" = ? then (select \"change_initiative\".\"external_id\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"entity_relationship\".\"id_a\") end, case when \"entity_relationship\".\"kind_b\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"entity_relationship\".\"id_b\") when \"entity_relationship\".\"kind_b\" = ? then (select \"application_group\".\"external_id\" from \"application_group\" where \"application_group\".\"id\" = \"entity_relationship\".\"id_b\") when \"entity_relationship\".\"kind_b\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"entity_relationship\".\"id_b\") when \"entity_relationship\".\"kind_b\" = ? then (select \"measurable\".\"external_id\" from \"measurable\" where \"measurable\".\"id\" = \"entity_relationship\".\"id_b\") when \"entity_relationship\".\"kind_b\" = ? then (select \"change_initiative\".\"external_id\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"entity_relationship\".\"id_b\") end from \"entity_relationship\" where \"entity_relationship\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(21), eq(1L));
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
