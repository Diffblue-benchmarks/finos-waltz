package org.finos.waltz.data.rating_scheme;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import java.util.Collection;
import java.util.List;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingScheme;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RatingSchemeDAODiffblueTest {
  /**
   * Test {@link RatingSchemeDAO#getRatingSchemeItemById(Long)} with {@code Long}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSchemeDAO#getRatingSchemeItemById(Long)}
   */
  @Test
  @DisplayName("Test getRatingSchemeItemById(Long) with 'Long'; given ResultSet next() return 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RatingSchemeItem RatingSchemeDAO.getRatingSchemeItemById(Long)"})
  void testGetRatingSchemeItemByIdWithLong_givenResultSetNextReturnFalse_thenReturnNull() throws SQLException {
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
    RatingSchemeItem actualRatingSchemeItemById = (new RatingSchemeDAO(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getRatingSchemeItemById((Long) 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"rating_scheme_item\".\"id\", \"rating_scheme_item\".\"scheme_id\", \"rating_scheme_item\".\"name\", \"rating_scheme_item\".\"description\", \"rating_scheme_item\".\"code\", \"rating_scheme_item\".\"color\", \"rating_scheme_item\".\"position\", \"rating_scheme_item\".\"user_selectable\", \"rating_scheme_item\".\"external_id\", \"rating_scheme_item\".\"rating_group\", \"rating_scheme_item\".\"requires_comment\" from \"rating_scheme_item\" where \"rating_scheme_item\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualRatingSchemeItemById);
  }

  /**
   * Test {@link RatingSchemeDAO#getRatingSchemeItemById(long)} with {@code long}.
   * <ul>
   *   <li>Then return {@link ImmutableRatingSchemeItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSchemeDAO#getRatingSchemeItemById(long)}
   */
  @Test
  @DisplayName("Test getRatingSchemeItemById(long) with 'long'; then return ImmutableRatingSchemeItem")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RatingSchemeItem RatingSchemeDAO.getRatingSchemeItemById(long)"})
  void testGetRatingSchemeItemByIdWithLong_thenReturnImmutableRatingSchemeItem() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
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
    RatingSchemeDAO ratingSchemeDAO = new RatingSchemeDAO(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    RatingSchemeItem actualRatingSchemeItemById = ratingSchemeDAO.getRatingSchemeItemById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"rating_scheme_item\".\"id\", \"rating_scheme_item\".\"scheme_id\", \"rating_scheme_item\".\"name\", \"rating_scheme_item\".\"description\", \"rating_scheme_item\".\"code\", \"rating_scheme_item\".\"color\", \"rating_scheme_item\".\"position\", \"rating_scheme_item\".\"user_selectable\", \"rating_scheme_item\".\"external_id\", \"rating_scheme_item\".\"rating_group\", \"rating_scheme_item\".\"requires_comment\" from \"rating_scheme_item\" where \"rating_scheme_item\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(anyInt());
    verify(resultSet).getInt(eq(7));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    Collection<RatingScheme> findAllResult = ratingSchemeDAO.findAll();
    assertTrue(findAllResult instanceof List);
    assertTrue(actualRatingSchemeItemById instanceof ImmutableRatingSchemeItem);
    assertEquals("String", actualRatingSchemeItemById.description());
    assertEquals("String", actualRatingSchemeItemById.name());
    assertEquals("String", actualRatingSchemeItemById.color());
    assertEquals("String", actualRatingSchemeItemById.rating());
    assertEquals("String", actualRatingSchemeItemById.ratingGroup());
    assertEquals(1, actualRatingSchemeItemById.position());
    assertEquals(1L, actualRatingSchemeItemById.ratingSchemeId());
    assertFalse(actualRatingSchemeItemById.isRestricted());
    assertTrue(findAllResult.isEmpty());
    assertTrue(ratingSchemeDAO.calcRatingUsageStats().isEmpty());
    assertTrue(actualRatingSchemeItemById.requiresComment());
    assertTrue(actualRatingSchemeItemById.userSelectable());
  }

  /**
   * Test {@link RatingSchemeDAO#getRatingSchemeItemById(Long)} with {@code Long}.
   * <ul>
   *   <li>Then return {@link ImmutableRatingSchemeItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSchemeDAO#getRatingSchemeItemById(Long)}
   */
  @Test
  @DisplayName("Test getRatingSchemeItemById(Long) with 'Long'; then return ImmutableRatingSchemeItem")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RatingSchemeItem RatingSchemeDAO.getRatingSchemeItemById(Long)"})
  void testGetRatingSchemeItemByIdWithLong_thenReturnImmutableRatingSchemeItem2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
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
    RatingSchemeItem actualRatingSchemeItemById = (new RatingSchemeDAO(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getRatingSchemeItemById((Long) 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"rating_scheme_item\".\"id\", \"rating_scheme_item\".\"scheme_id\", \"rating_scheme_item\".\"name\", \"rating_scheme_item\".\"description\", \"rating_scheme_item\".\"code\", \"rating_scheme_item\".\"color\", \"rating_scheme_item\".\"position\", \"rating_scheme_item\".\"user_selectable\", \"rating_scheme_item\".\"external_id\", \"rating_scheme_item\".\"rating_group\", \"rating_scheme_item\".\"requires_comment\" from \"rating_scheme_item\" where \"rating_scheme_item\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(anyInt());
    verify(resultSet).getInt(eq(7));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualRatingSchemeItemById instanceof ImmutableRatingSchemeItem);
    assertEquals("String", actualRatingSchemeItemById.description());
    assertEquals("String", actualRatingSchemeItemById.name());
    assertEquals("String", actualRatingSchemeItemById.color());
    assertEquals("String", actualRatingSchemeItemById.rating());
    assertEquals("String", actualRatingSchemeItemById.ratingGroup());
    assertEquals(1, actualRatingSchemeItemById.position());
    assertEquals(1L, actualRatingSchemeItemById.ratingSchemeId());
    assertFalse(actualRatingSchemeItemById.isRestricted());
    assertTrue(actualRatingSchemeItemById.requiresComment());
    assertTrue(actualRatingSchemeItemById.userSelectable());
  }
}
