package org.finos.waltz.data.app_group;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
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
import java.util.List;
import org.finos.waltz.model.app_group.AppGroup;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AppGroupDaoDiffblueTest {
  /**
   * Test {@link AppGroupDao#getGroup(long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppGroupDao#getGroup(long)}
   */
  @Test
  @DisplayName("Test getGroup(long); given ResultSet next() return 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AppGroup AppGroupDao.getGroup(long)"})
  void testGetGroup_givenResultSetNextReturnFalse_thenReturnNull() throws SQLException {
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
    AppGroup actualGroup = (new AppGroupDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getGroup(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application_group\".\"id\", \"application_group\".\"name\", \"application_group\".\"kind\", \"application_group\".\"description\", \"application_group\".\"external_id\", \"application_group\".\"is_removed\", \"application_group\".\"is_favourite_group\" from \"application_group\" where \"application_group\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualGroup);
  }

  /**
   * Test {@link AppGroupDao#getFavouritesGroupForOwner(String)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppGroupDao#getFavouritesGroupForOwner(String)}
   */
  @Test
  @DisplayName("Test getFavouritesGroupForOwner(String); given ResultSet next() return 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AppGroup AppGroupDao.getFavouritesGroupForOwner(String)"})
  void testGetFavouritesGroupForOwner_givenResultSetNextReturnFalse_thenReturnNull() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    AppGroup actualFavouritesGroupForOwner = (new AppGroupDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getFavouritesGroupForOwner("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application_group\".\"id\", \"application_group\".\"name\", \"application_group\".\"kind\", \"application_group\".\"description\", \"application_group\".\"external_id\", \"application_group\".\"is_removed\", \"application_group\".\"is_favourite_group\" from \"application_group\" where (\"application_group\".\"id\" in (select \"application_group_member\".\"group_id\" from \"application_group_member\" join \"application_group\" on \"application_group_member\".\"group_id\" = \"application_group\".\"id\" where (\"application_group_member\".\"user_id\" = ? and \"application_group_member\".\"role\" = ?)) and \"application_group\".\"kind\" = ? and \"application_group\".\"is_removed\" = ? and \"application_group\".\"is_favourite_group\" = true)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(4), eq(false));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualFavouritesGroupForOwner);
  }

  /**
   * Test {@link AppGroupDao#findRelatedByApplicationId(long, String)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppGroupDao#findRelatedByApplicationId(long, String)}
   */
  @Test
  @DisplayName("Test findRelatedByApplicationId(long, String); given ResultSet next() return 'false'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List AppGroupDao.findRelatedByApplicationId(long, String)"})
  void testFindRelatedByApplicationId_givenResultSetNextReturnFalse_thenReturnEmpty() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<AppGroup> actualFindRelatedByApplicationIdResult = (new AppGroupDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findRelatedByApplicationId(1L, "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application_group\".\"id\", \"application_group\".\"name\", \"application_group\".\"kind\", \"application_group\".\"description\", \"application_group\".\"external_id\", \"application_group\".\"is_removed\", \"application_group\".\"is_favourite_group\" from \"application_group\" where (\"application_group\".\"id\" in (select \"application_group_entry\".\"group_id\" from \"application_group_entry\" where \"application_group_entry\".\"application_id\" = ? union select \"application_group_ou_entry\".\"group_id\" from \"application_group_ou_entry\" where \"application_group_ou_entry\".\"org_unit_id\" in (select \"entity_hierarchy\".\"ancestor_id\" from \"entity_hierarchy\" join \"organisational_unit\" on \"entity_hierarchy\".\"id\" = \"organisational_unit\".\"id\" join \"application\" on \"application\".\"organisational_unit_id\" = \"organisational_unit\".\"id\" where \"application\".\"id\" = ?)) and (\"application_group\".\"kind\" = ? or \"application_group\".\"id\" in (select \"application_group_member\".\"group_id\" from \"application_group_member\" join \"application_group\" on \"application_group_member\".\"group_id\" = \"application_group\".\"id\" where (\"application_group_member\".\"user_id\" = ? and \"application_group_member\".\"role\" = ?))) and \"application_group\".\"is_removed\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(6), eq(false));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindRelatedByApplicationIdResult.isEmpty());
  }
}
