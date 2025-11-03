package org.finos.waltz.data.taxonomy_management;

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
import org.finos.waltz.model.taxonomy_management.TaxonomyChangeCommand;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TaxonomyChangeDaoDiffblueTest {
  /**
   * Test {@link TaxonomyChangeDao#getDraftCommandById(long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxonomyChangeDao#getDraftCommandById(long)}
   */
  @Test
  @DisplayName("Test getDraftCommandById(long); given ResultSet next() return 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TaxonomyChangeCommand TaxonomyChangeDao.getDraftCommandById(long)"})
  void testGetDraftCommandById_givenResultSetNextReturnFalse_thenReturnNull() throws SQLException {
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
    TaxonomyChangeCommand actualDraftCommandById = (new TaxonomyChangeDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getDraftCommandById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"taxonomy_change\".\"id\", \"taxonomy_change\".\"change_type\", \"taxonomy_change\".\"description\", \"taxonomy_change\".\"domain_kind\", \"taxonomy_change\".\"domain_id\", \"taxonomy_change\".\"primary_reference_kind\", \"taxonomy_change\".\"primary_reference_id\", \"taxonomy_change\".\"status\", \"taxonomy_change\".\"params\", \"taxonomy_change\".\"created_at\", \"taxonomy_change\".\"created_by\", \"taxonomy_change\".\"last_updated_at\", \"taxonomy_change\".\"last_updated_by\", case when \"taxonomy_change\".\"primary_reference_kind\" = ? then (select \"measurable\".\"name\" from \"measurable\" where \"measurable\".\"id\" = \"taxonomy_change\".\"primary_reference_id\") end \"primaryRefName\", case when \"taxonomy_change\".\"domain_kind\" = ? then (select \"measurable_category\".\"name\" from \"measurable_category\" where \"measurable_category\".\"id\" = \"taxonomy_change\".\"domain_id\") end \"changeDomainName\" from \"taxonomy_change\" where (\"taxonomy_change\".\"id\" = ? and \"taxonomy_change\".\"status\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualDraftCommandById);
  }
}
