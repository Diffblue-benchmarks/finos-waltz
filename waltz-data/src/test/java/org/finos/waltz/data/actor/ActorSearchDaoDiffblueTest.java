package org.finos.waltz.data.actor;

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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.actor.Actor;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ActorSearchDaoDiffblueTest {
  /**
   * Method under test: {@link ActorSearchDao#search(EntitySearchOptions)}
   */
  @Test
  void testSearch() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.findAll()).thenReturn(new ArrayList<>());
    ActorSearchDao actorSearchDao = new ActorSearchDao(dsl, actorDao);
    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<Actor> actualSearchResult = actorSearchDao.search(options);

    // Assert
    verify(connection).prepareStatement(eq(
        "select distinct \"actor\".\"id\", \"actor\".\"name\", \"actor\".\"description\", \"actor\".\"last_updated_at\", \"actor\".\"last_updated_by\", \"actor\".\"is_external\", \"actor\".\"provenance\", \"actor\".\"external_id\" from \"actor\" join \"entity_alias\" on (\"entity_alias\".\"id\" = \"actor\".\"id\" and \"entity_alias\".\"kind\" = ?) where (\"entity_alias\".\"kind\" = ? and 1 = 1 and lower(\"entity_alias\".\"alias\") like lower(('%' || replace(replace(replace(?, '!', '!!'), '%', '!%'), '_', '!_') || '%')) escape '!' and lower(\"entity_alias\".\"alias\") like lower(('%' || replace(replace(replace(?, '!', '!!'), '%', '!%'), '_', '!_') || '%')) escape '!') order by \"actor\".\"name\" limit ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(5), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(6));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(4));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    verify(actorDao).findAll();
    verify(options, atLeast(1)).limit();
    verify(options).searchQuery();
    assertEquals(2, actualSearchResult.size());
    Actor getResult = actualSearchResult.get(0);
    assertTrue(getResult instanceof ImmutableActor);
    Actor getResult2 = actualSearchResult.get(1);
    assertTrue(getResult2 instanceof ImmutableActor);
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.lastUpdatedBy());
    assertEquals("String", getResult.name());
    assertEquals("String", getResult.provenance());
    assertEquals(EntityKind.ACTOR, getResult.kind());
    assertTrue(getResult.isExternal());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link ActorSearchDao#search(EntitySearchOptions)}
   */
  @Test
  void testSearch2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("“");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.findAll()).thenReturn(new ArrayList<>());
    ActorSearchDao actorSearchDao = new ActorSearchDao(dsl, actorDao);
    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<Actor> actualSearchResult = actorSearchDao.search(options);

    // Assert
    verify(connection).prepareStatement(eq(
        "select distinct \"actor\".\"id\", \"actor\".\"name\", \"actor\".\"description\", \"actor\".\"last_updated_at\", \"actor\".\"last_updated_by\", \"actor\".\"is_external\", \"actor\".\"provenance\", \"actor\".\"external_id\" from \"actor\" join \"entity_alias\" on (\"entity_alias\".\"id\" = \"actor\".\"id\" and \"entity_alias\".\"kind\" = ?) where (\"entity_alias\".\"kind\" = ? and 1 = 1 and lower(\"entity_alias\".\"alias\") like lower(('%' || replace(replace(replace(?, '!', '!!'), '%', '!%'), '_', '!_') || '%')) escape '!' and lower(\"entity_alias\".\"alias\") like lower(('%' || replace(replace(replace(?, '!', '!!'), '%', '!%'), '_', '!_') || '%')) escape '!') order by \"actor\".\"name\" limit ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(5), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(6));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(4));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    verify(actorDao).findAll();
    verify(options, atLeast(1)).limit();
    verify(options).searchQuery();
    assertEquals(2, actualSearchResult.size());
    Actor getResult = actualSearchResult.get(0);
    assertTrue(getResult instanceof ImmutableActor);
    Actor getResult2 = actualSearchResult.get(1);
    assertTrue(getResult2 instanceof ImmutableActor);
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("\"", getResult.description());
    assertEquals("\"", getResult.name());
    assertEquals("“", getResult.lastUpdatedBy());
    assertEquals("“", getResult.provenance());
    assertEquals(EntityKind.ACTOR, getResult.kind());
    assertTrue(getResult.isExternal());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link ActorSearchDao#search(EntitySearchOptions)}
   */
  @Test
  void testSearch3() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("‘");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.findAll()).thenReturn(new ArrayList<>());
    ActorSearchDao actorSearchDao = new ActorSearchDao(dsl, actorDao);
    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<Actor> actualSearchResult = actorSearchDao.search(options);

    // Assert
    verify(connection).prepareStatement(eq(
        "select distinct \"actor\".\"id\", \"actor\".\"name\", \"actor\".\"description\", \"actor\".\"last_updated_at\", \"actor\".\"last_updated_by\", \"actor\".\"is_external\", \"actor\".\"provenance\", \"actor\".\"external_id\" from \"actor\" join \"entity_alias\" on (\"entity_alias\".\"id\" = \"actor\".\"id\" and \"entity_alias\".\"kind\" = ?) where (\"entity_alias\".\"kind\" = ? and 1 = 1 and lower(\"entity_alias\".\"alias\") like lower(('%' || replace(replace(replace(?, '!', '!!'), '%', '!%'), '_', '!_') || '%')) escape '!' and lower(\"entity_alias\".\"alias\") like lower(('%' || replace(replace(replace(?, '!', '!!'), '%', '!%'), '_', '!_') || '%')) escape '!') order by \"actor\".\"name\" limit ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(5), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(6));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(4));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    verify(actorDao).findAll();
    verify(options, atLeast(1)).limit();
    verify(options).searchQuery();
    assertEquals(2, actualSearchResult.size());
    Actor getResult = actualSearchResult.get(0);
    assertTrue(getResult instanceof ImmutableActor);
    Actor getResult2 = actualSearchResult.get(1);
    assertTrue(getResult2 instanceof ImmutableActor);
    assertEquals("'", getResult.description());
    assertEquals("'", getResult.name());
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("‘", getResult.lastUpdatedBy());
    assertEquals("‘", getResult.provenance());
    assertEquals(EntityKind.ACTOR, getResult.kind());
    assertTrue(getResult.isExternal());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link ActorSearchDao#search(EntitySearchOptions)}
   */
  @Test
  void testSearch4() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("​");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.findAll()).thenReturn(new ArrayList<>());
    ActorSearchDao actorSearchDao = new ActorSearchDao(dsl, actorDao);
    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<Actor> actualSearchResult = actorSearchDao.search(options);

    // Assert
    verify(connection).prepareStatement(eq(
        "select distinct \"actor\".\"id\", \"actor\".\"name\", \"actor\".\"description\", \"actor\".\"last_updated_at\", \"actor\".\"last_updated_by\", \"actor\".\"is_external\", \"actor\".\"provenance\", \"actor\".\"external_id\" from \"actor\" join \"entity_alias\" on (\"entity_alias\".\"id\" = \"actor\".\"id\" and \"entity_alias\".\"kind\" = ?) where (\"entity_alias\".\"kind\" = ? and 1 = 1 and lower(\"entity_alias\".\"alias\") like lower(('%' || replace(replace(replace(?, '!', '!!'), '%', '!%'), '_', '!_') || '%')) escape '!' and lower(\"entity_alias\".\"alias\") like lower(('%' || replace(replace(replace(?, '!', '!!'), '%', '!%'), '_', '!_') || '%')) escape '!') order by \"actor\".\"name\" limit ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(5), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(6));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(4));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    verify(actorDao).findAll();
    verify(options, atLeast(1)).limit();
    verify(options).searchQuery();
    assertEquals(2, actualSearchResult.size());
    Actor getResult = actualSearchResult.get(0);
    assertTrue(getResult instanceof ImmutableActor);
    Actor getResult2 = actualSearchResult.get(1);
    assertTrue(getResult2 instanceof ImmutableActor);
    assertEquals("", getResult.description());
    assertEquals("", getResult.name());
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("​", getResult.lastUpdatedBy());
    assertEquals("​", getResult.provenance());
    assertEquals(EntityKind.ACTOR, getResult.kind());
    assertTrue(getResult.isExternal());
    assertEquals(getResult, getResult2);
  }
}
