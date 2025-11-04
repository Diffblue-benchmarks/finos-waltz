package org.finos.waltz.data.tag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.tag.Tag;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TagDaoDiffblueTest {
  /**
   * Method under test: {@link TagDao#findTagsForEntityKind(EntityKind)}
   */
  @Test
  void testFindTagsForEntityKind() throws SQLException {
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
    List<Tag> actualFindTagsForEntityKindResult = (new TagDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findTagsForEntityKind(EntityKind.ALL);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"tag\".\"id\", \"tag\".\"name\", \"tag\".\"target_kind\" from \"tag\" join (select \"tag_usage\".\"tag_id\" \"tagId\", count(\"tag_usage\".\"entity_id\") \"usageCount\" from \"tag_usage\" group by \"tag_usage\".\"tag_id\") \"alias_65523446\" on \"alias_65523446\".\"tagId\" = \"tag\".\"id\" where \"tag\".\"target_kind\" = ? order by \"alias_65523446\".\"usageCount\" desc"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("ALL"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindTagsForEntityKindResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link TagDao#getTagByNameAndTargetKind(EntityKind, String)}
   */
  @Test
  void testGetTagByNameAndTargetKind() throws SQLException {
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
    Tag actualTagByNameAndTargetKind = (new TagDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getTagByNameAndTargetKind(EntityKind.ALL, "Tag Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"tag\".\"id\", \"tag\".\"name\", \"tag\".\"target_kind\" from \"tag\" where (\"tag\".\"target_kind\" = ? and \"tag\".\"name\" in (?)) order by \"tag\".\"name\" asc"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualTagByNameAndTargetKind);
  }

  /**
   * Method under test: {@link TagDao#createTag(EntityKind, String)}
   */
  @Test
  void testCreateTag() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement);

    // Act
    Long actualCreateTagResult = (new TagDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .createTag(EntityKind.ALL, "Tag");

    // Assert
    verify(connection).prepareStatement(eq("insert into \"tag\" (\"name\", \"target_kind\") values (?, ?)"),
        isA(String[].class));
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getGeneratedKeys();
    verify(preparedStatement).getWarnings();
    assertEquals(1L, actualCreateTagResult.longValue());
  }

  /**
   * Method under test: {@link TagDao#getById(long)}
   */
  @Test
  void testGetById() throws SQLException {
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
    Tag actualById = (new TagDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(
        eq("select \"tag\".\"id\", \"tag\".\"name\", \"tag\".\"target_kind\" from \"tag\" where \"tag\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualById);
  }
}
