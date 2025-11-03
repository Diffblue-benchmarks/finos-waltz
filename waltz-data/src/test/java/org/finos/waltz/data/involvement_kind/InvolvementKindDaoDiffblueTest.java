package org.finos.waltz.data.involvement_kind;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
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
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.involvement_kind.InvolvementKind;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class InvolvementKindDaoDiffblueTest {
  /**
   * Test {@link InvolvementKindDao#findKeyInvolvementKindsByEntityKind(EntityKind)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link InvolvementKindDao#findKeyInvolvementKindsByEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test findKeyInvolvementKindsByEntityKind(EntityKind); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List InvolvementKindDao.findKeyInvolvementKindsByEntityKind(EntityKind)"})
  void testFindKeyInvolvementKindsByEntityKind_thenReturnEmpty() throws SQLException {
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
    List<InvolvementKind> actualFindKeyInvolvementKindsByEntityKindResult = (new InvolvementKindDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findKeyInvolvementKindsByEntityKind(EntityKind.ALL);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"inv_kind\".\"id\", \"inv_kind\".\"description\", \"inv_kind\".\"last_updated_at\", \"inv_kind\".\"last_updated_by\", \"inv_kind\".\"external_id\", \"inv_kind\".\"user_selectable\", \"inv_kind\".\"subject_kind\", \"inv_kind\".\"name\", \"inv_kind\".\"permitted_role\", \"inv_kind\".\"transitive\" from \"involvement_kind\" \"inv_kind\" where \"inv_kind\".\"id\" in (select distinct \"key_involvement_kind\".\"involvement_kind_id\" from \"key_involvement_kind\" where \"key_involvement_kind\".\"entity_kind\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("ALL"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindKeyInvolvementKindsByEntityKindResult.isEmpty());
  }
}
