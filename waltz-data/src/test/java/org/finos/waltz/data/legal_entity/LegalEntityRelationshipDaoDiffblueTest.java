package org.finos.waltz.data.legal_entity;

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
import org.finos.waltz.model.legal_entity.LegalEntityRelationship;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LegalEntityRelationshipDaoDiffblueTest {
  /**
   * Test {@link LegalEntityRelationshipDao#getById(Long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegalEntityRelationshipDao#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long); given ResultSet next() return 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LegalEntityRelationship LegalEntityRelationshipDao.getById(Long)"})
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
    LegalEntityRelationship actualById = (new LegalEntityRelationshipDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"legal_entity_relationship\".\"id\", \"legal_entity_relationship\".\"legal_entity_id\", \"legal_entity_relationship\".\"relationship_kind_id\", \"legal_entity_relationship\".\"target_kind\", \"legal_entity_relationship\".\"target_id\", \"legal_entity_relationship\".\"description\", \"legal_entity_relationship\".\"external_id\", \"legal_entity_relationship\".\"last_updated_at\", \"legal_entity_relationship\".\"last_updated_by\", \"legal_entity_relationship\".\"provenance\", \"legal_entity_relationship\".\"is_readonly\", \"legal_entity\".\"name\", \"legal_entity\".\"external_id\", case when \"legal_entity_relationship\".\"target_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"legal_entity_relationship\".\"target_id\") end \"entity_name\", case when \"legal_entity_relationship\".\"target_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"legal_entity_relationship\".\"target_id\") end \"entity_ext_id\" from \"legal_entity_relationship\" join \"legal_entity\" on \"legal_entity_relationship\".\"legal_entity_id\" = \"legal_entity\".\"id\" where \"legal_entity_relationship\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("APPLICATION"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualById);
  }
}
