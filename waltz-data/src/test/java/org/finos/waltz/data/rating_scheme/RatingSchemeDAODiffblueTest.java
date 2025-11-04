package org.finos.waltz.data.rating_scheme;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.model.rating.ImmutableRatingScheme;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingScheme;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItemUsageCount;
import org.finos.waltz.schema.tables.records.RatingSchemeItemRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.TransactionalCallable;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RatingSchemeDAODiffblueTest {
  /**
   * Method under test: {@link RatingSchemeDAO#findAll()}
   */
  @Test
  void testFindAll() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Collection<RatingScheme> actualFindAllResult = (new RatingSchemeDAO(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getBoolean(anyInt());
    verify(resultSet, atLeast(1)).getInt(eq(7));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualFindAllResult instanceof List);
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Method under test: {@link RatingSchemeDAO#findAll()}
   */
  @Test
  void testFindAll2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Collection<RatingScheme> actualFindAllResult = (new RatingSchemeDAO(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(resultSet, atLeast(1)).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualFindAllResult instanceof List);
    assertEquals(1, actualFindAllResult.size());
    RatingScheme getResult = ((List<RatingScheme>) actualFindAllResult).get(0);
    assertTrue(getResult instanceof ImmutableRatingScheme);
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertTrue(getResult.ratings().isEmpty());
  }

  /**
   * Method under test: {@link RatingSchemeDAO#fetchItems(Condition)}
   */
  @Test
  void testFetchItems() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
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
    List<RatingSchemeItem> actualFetchItemsResult = (new RatingSchemeDAO(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).fetchItems(ApplicationDao.IS_ACTIVE);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"rating_scheme_item\".\"id\", \"rating_scheme_item\".\"scheme_id\", \"rating_scheme_item\".\"name\", \"rating_scheme_item\".\"description\", \"rating_scheme_item\".\"code\", \"rating_scheme_item\".\"color\", \"rating_scheme_item\".\"position\", \"rating_scheme_item\".\"user_selectable\", \"rating_scheme_item\".\"external_id\", \"rating_scheme_item\".\"rating_group\", \"rating_scheme_item\".\"requires_comment\" from \"rating_scheme_item\" where \"application\".\"entity_lifecycle_status\" = ? order by \"rating_scheme_item\".\"position\" asc"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("ACTIVE"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(anyInt());
    verify(resultSet, atLeast(1)).getInt(eq(7));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFetchItemsResult.size());
    RatingSchemeItem getResult = actualFetchItemsResult.get(0);
    assertTrue(getResult instanceof ImmutableRatingSchemeItem);
    RatingSchemeItem getResult2 = actualFetchItemsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableRatingSchemeItem);
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertEquals("String", getResult.color());
    assertEquals("String", getResult.rating());
    assertEquals("String", getResult.ratingGroup());
    assertEquals(1, getResult.position());
    assertEquals(1L, getResult.ratingSchemeId());
    assertFalse(getResult.isRestricted());
    assertTrue(getResult.requiresComment());
    assertTrue(getResult.userSelectable());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test:
   * {@link RatingSchemeDAO#findRatingSchemeItemsForAssessmentDefinition(Long)}
   */
  @Test
  void testFindRatingSchemeItemsForAssessmentDefinition() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
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
    List<RatingSchemeItem> actualFindRatingSchemeItemsForAssessmentDefinitionResult = (new RatingSchemeDAO(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findRatingSchemeItemsForAssessmentDefinition(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"rating_scheme_item\".\"id\", \"rating_scheme_item\".\"scheme_id\", \"rating_scheme_item\".\"name\", \"rating_scheme_item\".\"description\", \"rating_scheme_item\".\"code\", \"rating_scheme_item\".\"color\", \"rating_scheme_item\".\"position\", \"rating_scheme_item\".\"user_selectable\", \"rating_scheme_item\".\"external_id\", \"rating_scheme_item\".\"rating_group\", \"rating_scheme_item\".\"requires_comment\" from \"rating_scheme_item\" join \"rating_scheme\" on \"rating_scheme\".\"id\" = \"rating_scheme_item\".\"scheme_id\" join \"assessment_definition\" on \"assessment_definition\".\"rating_scheme_id\" = \"rating_scheme\".\"id\" where \"assessment_definition\".\"id\" = ? order by \"rating_scheme_item\".\"position\" asc"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(anyInt());
    verify(resultSet, atLeast(1)).getInt(eq(7));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindRatingSchemeItemsForAssessmentDefinitionResult.size());
    RatingSchemeItem getResult = actualFindRatingSchemeItemsForAssessmentDefinitionResult.get(0);
    assertTrue(getResult instanceof ImmutableRatingSchemeItem);
    RatingSchemeItem getResult2 = actualFindRatingSchemeItemsForAssessmentDefinitionResult.get(1);
    assertTrue(getResult2 instanceof ImmutableRatingSchemeItem);
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertEquals("String", getResult.color());
    assertEquals("String", getResult.rating());
    assertEquals("String", getResult.ratingGroup());
    assertEquals(1, getResult.position());
    assertEquals(1L, getResult.ratingSchemeId());
    assertFalse(getResult.isRestricted());
    assertTrue(getResult.requiresComment());
    assertTrue(getResult.userSelectable());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link RatingSchemeDAO#getRatingSchemeItemById(long)}
   */
  @Test
  void testGetRatingSchemeItemById() throws SQLException {
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
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getRatingSchemeItemById(1L);

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
   * Method under test: {@link RatingSchemeDAO#getRatingSchemeItemById(long)}
   */
  @Test
  void testGetRatingSchemeItemById2() throws SQLException {
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
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getRatingSchemeItemById(1L);

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

  /**
   * Method under test: {@link RatingSchemeDAO#getRatingSchemeItemById(Long)}
   */
  @Test
  void testGetRatingSchemeItemById3() throws SQLException {
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
   * Method under test: {@link RatingSchemeDAO#getRatingSchemeItemById(Long)}
   */
  @Test
  void testGetRatingSchemeItemById4() throws SQLException {
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

  /**
   * Method under test: {@link RatingSchemeDAO#findRatingSchemeItemsByIds(Set)}
   */
  @Test
  void testFindRatingSchemeItemsByIds() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    RatingSchemeDAO ratingSchemeDAO = new RatingSchemeDAO(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Set<RatingSchemeItem> actualFindRatingSchemeItemsByIdsResult = ratingSchemeDAO
        .findRatingSchemeItemsByIds(new HashSet<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"rating_scheme_item\".\"id\", \"rating_scheme_item\".\"scheme_id\", \"rating_scheme_item\".\"name\", \"rating_scheme_item\".\"description\", \"rating_scheme_item\".\"code\", \"rating_scheme_item\".\"color\", \"rating_scheme_item\".\"position\", \"rating_scheme_item\".\"user_selectable\", \"rating_scheme_item\".\"external_id\", \"rating_scheme_item\".\"rating_group\", \"rating_scheme_item\".\"requires_comment\" from \"rating_scheme_item\" where \"rating_scheme_item\".\"id\" in ()"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(anyInt());
    verify(resultSet, atLeast(1)).getInt(eq(7));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindRatingSchemeItemsByIdsResult.size());
  }

  /**
   * Method under test:
   * {@link RatingSchemeDAO#findRatingSchemeItemsForSchemeIds(Set)}
   */
  @Test
  void testFindRatingSchemeItemsForSchemeIds() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    RatingSchemeDAO ratingSchemeDAO = new RatingSchemeDAO(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Set<RatingSchemeItem> actualFindRatingSchemeItemsForSchemeIdsResult = ratingSchemeDAO
        .findRatingSchemeItemsForSchemeIds(new HashSet<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"rating_scheme_item\".\"id\", \"rating_scheme_item\".\"scheme_id\", \"rating_scheme_item\".\"name\", \"rating_scheme_item\".\"description\", \"rating_scheme_item\".\"code\", \"rating_scheme_item\".\"color\", \"rating_scheme_item\".\"position\", \"rating_scheme_item\".\"user_selectable\", \"rating_scheme_item\".\"external_id\", \"rating_scheme_item\".\"rating_group\", \"rating_scheme_item\".\"requires_comment\" from \"rating_scheme_item\" where \"rating_scheme_item\".\"scheme_id\" in ()"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(anyInt());
    verify(resultSet, atLeast(1)).getInt(eq(7));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindRatingSchemeItemsForSchemeIdsResult.size());
  }

  /**
   * Method under test: {@link RatingSchemeDAO#removeRatingItem(long)}
   */
  @Test
  void testRemoveRatingItem() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Boolean actualRemoveRatingItemResult = (new RatingSchemeDAO(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .removeRatingItem(1L);

    // Assert
    verify(connection)
        .prepareStatement(eq("delete from \"rating_scheme_item\" where \"rating_scheme_item\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveRatingItemResult);
  }

  /**
   * Method under test: {@link RatingSchemeDAO#removeRatingItem(long)}
   */
  @Test
  void testRemoveRatingItem2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<RatingSchemeItemRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteUsingStep<RatingSchemeItemRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<RatingSchemeItemRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    Boolean actualRemoveRatingItemResult = (new RatingSchemeDAO(dsl)).removeRatingItem(1L);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertTrue(actualRemoveRatingItemResult);
  }

  /**
   * Method under test: {@link RatingSchemeDAO#removeRatingItem(long)}
   */
  @Test
  void testRemoveRatingItem3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Boolean actualRemoveRatingItemResult = (new RatingSchemeDAO(new DefaultDSLContext(connection, SQLDialect.POSTGRES)))
        .removeRatingItem(1L);

    // Assert
    verify(connection)
        .prepareStatement(eq("delete from \"rating_scheme_item\" where \"rating_scheme_item\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveRatingItemResult);
  }

  /**
   * Method under test: {@link RatingSchemeDAO#removeRatingItem(long)}
   */
  @Test
  void testRemoveRatingItem4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Boolean actualRemoveRatingItemResult = (new RatingSchemeDAO(new DefaultDSLContext(connection, SQLDialect.SQLITE)))
        .removeRatingItem(1L);

    // Assert
    verify(connection).prepareStatement(eq("delete from rating_scheme_item where rating_scheme_item.id = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveRatingItemResult);
  }

  /**
   * Method under test: {@link RatingSchemeDAO#removeRatingScheme(long)}
   */
  @Test
  void testRemoveRatingScheme() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Boolean actualRemoveRatingSchemeResult = (new RatingSchemeDAO(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .removeRatingScheme(1L);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(eq(1), eq(1L));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertFalse(actualRemoveRatingSchemeResult);
  }

  /**
   * Method under test: {@link RatingSchemeDAO#removeRatingScheme(long)}
   */
  @Test
  void testRemoveRatingScheme2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Boolean actualRemoveRatingSchemeResult = (new RatingSchemeDAO(new DefaultDSLContext(connection, SQLDialect.CUBRID)))
        .removeRatingScheme(1L);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(eq(1), eq(1L));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertFalse(actualRemoveRatingSchemeResult);
  }

  /**
   * Method under test: {@link RatingSchemeDAO#removeRatingScheme(long)}
   */
  @Test
  void testRemoveRatingScheme3() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.transactionResult(Mockito.<TransactionalCallable<Object>>any())).thenReturn(true);

    // Act
    Boolean actualRemoveRatingSchemeResult = (new RatingSchemeDAO(dsl)).removeRatingScheme(1L);

    // Assert
    verify(dsl).transactionResult(isA(TransactionalCallable.class));
    assertTrue(actualRemoveRatingSchemeResult);
  }

  /**
   * Method under test: {@link RatingSchemeDAO#removeRatingScheme(long)}
   */
  @Test
  void testRemoveRatingScheme4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Boolean actualRemoveRatingSchemeResult = (new RatingSchemeDAO(
        new DefaultDSLContext(connection, SQLDialect.POSTGRES))).removeRatingScheme(1L);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(eq(1), eq(1L));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertFalse(actualRemoveRatingSchemeResult);
  }

  /**
   * Method under test: {@link RatingSchemeDAO#removeRatingScheme(long)}
   */
  @Test
  void testRemoveRatingScheme5() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Boolean actualRemoveRatingSchemeResult = (new RatingSchemeDAO(new DefaultDSLContext(connection, SQLDialect.SQLITE)))
        .removeRatingScheme(1L);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(eq(1), eq(1L));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertFalse(actualRemoveRatingSchemeResult);
  }

  /**
   * Method under test: {@link RatingSchemeDAO#calcRatingUsageStats()}
   */
  @Test
  void testCalcRatingUsageStats() throws SQLException {
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
    List<RatingSchemeItemUsageCount> actualCalcRatingUsageStatsResult = (new RatingSchemeDAO(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).calcRatingUsageStats();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"rsi\".\"scheme_id\", \"rsi\".\"id\", ?, count(*) from \"assessment_rating\" \"ar\" join \"rating_scheme_item\" \"rsi\" on \"rsi\".\"id\" = \"ar\".\"rating_id\" group by \"rsi\".\"scheme_id\", \"rsi\".\"id\" union select \"rsi\".\"scheme_id\", \"rsi\".\"id\", ?, count(*) from \"measurable_rating\" \"mr\" join \"measurable\" \"m\" on \"m\".\"id\" = \"mr\".\"measurable_id\" join \"measurable_category\" \"mc\" on \"mc\".\"id\" = \"m\".\"measurable_category_id\" join \"rating_scheme\" \"rs\" on \"rs\".\"id\" = \"mc\".\"rating_scheme_id\" join \"rating_scheme_item\" \"rsi\" on (\"rsi\".\"code\" = \"mr\".\"rating\" and \"rsi\".\"scheme_id\" = \"rs\".\"id\") group by \"rsi\".\"scheme_id\", \"rsi\".\"id\" union select \"rsi\".\"scheme_id\", \"rsi\".\"id\", ?, count(*) from \"scenario_rating_item\" \"sri\" join \"scenario\" \"s\" on \"s\".\"id\" = \"sri\".\"scenario_id\" join \"roadmap\" \"r\" on \"r\".\"id\" = \"s\".\"roadmap_id\" join \"rating_scheme\" \"rs\" on \"rs\".\"id\" = \"r\".\"rating_scheme_id\" join \"rating_scheme_item\" \"rsi\" on (\"rsi\".\"code\" = \"sri\".\"rating\" and \"rsi\".\"scheme_id\" = \"rs\".\"id\") group by \"rsi\".\"scheme_id\", \"rsi\".\"id\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualCalcRatingUsageStatsResult.isEmpty());
  }
}
