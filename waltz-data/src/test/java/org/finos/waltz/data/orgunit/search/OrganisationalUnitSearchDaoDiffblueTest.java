package org.finos.waltz.data.orgunit.search;

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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.orgunit.ImmutableOrganisationalUnit;
import org.finos.waltz.model.orgunit.OrganisationalUnit;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OrganisationalUnitSearchDaoDiffblueTest {
  /**
   * Test {@link OrganisationalUnitSearchDao#search(EntitySearchOptions)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getString(int)} return {@code String}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrganisationalUnitSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions); given ResultSet getString(int) return 'String'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List OrganisationalUnitSearchDao.search(EntitySearchOptions)"})
  void testSearch_givenResultSetGetStringReturnString_thenReturnSizeIsOne() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(mock(Timestamp.class));
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
    OrganisationalUnitSearchDao organisationalUnitSearchDao = new OrganisationalUnitSearchDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));
    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<OrganisationalUnit> actualSearchResult = organisationalUnitSearchDao.search(options);

    // Assert
    verify(connection).prepareStatement(eq(
        "select distinct \"organisational_unit\".\"id\", \"organisational_unit\".\"name\", \"organisational_unit\".\"description\", \"organisational_unit\".\"parent_id\", \"organisational_unit\".\"created_at\", \"organisational_unit\".\"last_updated_at\", \"organisational_unit\".\"external_id\", \"organisational_unit\".\"created_by\", \"organisational_unit\".\"last_updated_by\", \"organisational_unit\".\"provenance\" from \"organisational_unit\" where (1 = 1 and lower(\"organisational_unit\".\"name\") like lower(('%' || replace(replace(replace(?, '!', '!!'), '%', '!%'), '_', '!_') || '%')) escape '!' and lower(\"organisational_unit\".\"name\") like lower(('%' || replace(replace(replace(?, '!', '!!'), '%', '!%'), '_', '!_') || '%')) escape '!') order by \"organisational_unit\".\"name\" limit ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(options).limit();
    verify(options).searchQuery();
    assertEquals(1, actualSearchResult.size());
    OrganisationalUnit getResult = actualSearchResult.get(0);
    assertTrue(getResult instanceof ImmutableOrganisationalUnit);
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertEquals(EntityKind.ORG_UNIT, getResult.kind());
  }
}
