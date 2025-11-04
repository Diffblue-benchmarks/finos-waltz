package org.finos.waltz.data.entity_named_note;

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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.List;
import org.finos.waltz.model.entity_named_note.EntityNamedNodeType;
import org.finos.waltz.model.entity_named_note.ImmutableEntityNamedNodeType;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityNamedNoteTypeDaoDiffblueTest {
  /**
   * Method under test: {@link EntityNamedNoteTypeDao#findAll()}
   */
  @Test
  void testFindAll() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn(";");
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
    List<EntityNamedNodeType> actualFindAllResult = (new EntityNamedNoteTypeDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"entity_named_note_type\".\"id\", \"entity_named_note_type\".\"applicable_entity_kinds\", \"entity_named_note_type\".\"name\", \"entity_named_note_type\".\"description\", \"entity_named_note_type\".\"is_readonly\", \"entity_named_note_type\".\"position\", \"entity_named_note_type\".\"external_id\" from \"entity_named_note_type\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(5));
    verify(resultSet, atLeast(1)).getInt(eq(6));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindAllResult.size());
    EntityNamedNodeType getResult = actualFindAllResult.get(0);
    assertTrue(getResult instanceof ImmutableEntityNamedNodeType);
    EntityNamedNodeType getResult2 = actualFindAllResult.get(1);
    assertTrue(getResult2 instanceof ImmutableEntityNamedNodeType);
    assertEquals(";", getResult.description());
    assertEquals(";", getResult.name());
    assertEquals(1, getResult.position());
    assertTrue(getResult.applicableEntityKinds().isEmpty());
    assertTrue(getResult.isReadOnly());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link EntityNamedNoteTypeDao#findAll()}
   */
  @Test
  void testFindAll2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("");
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
    List<EntityNamedNodeType> actualFindAllResult = (new EntityNamedNoteTypeDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"entity_named_note_type\".\"id\", \"entity_named_note_type\".\"applicable_entity_kinds\", \"entity_named_note_type\".\"name\", \"entity_named_note_type\".\"description\", \"entity_named_note_type\".\"is_readonly\", \"entity_named_note_type\".\"position\", \"entity_named_note_type\".\"external_id\" from \"entity_named_note_type\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(5));
    verify(resultSet, atLeast(1)).getInt(eq(6));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindAllResult.size());
    EntityNamedNodeType getResult = actualFindAllResult.get(0);
    assertTrue(getResult instanceof ImmutableEntityNamedNodeType);
    EntityNamedNodeType getResult2 = actualFindAllResult.get(1);
    assertTrue(getResult2 instanceof ImmutableEntityNamedNodeType);
    assertEquals("", getResult.description());
    assertEquals("", getResult.name());
    assertEquals(1, getResult.position());
    assertTrue(getResult.applicableEntityKinds().isEmpty());
    assertTrue(getResult.isReadOnly());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link EntityNamedNoteTypeDao#removeById(Long)}
   */
  @Test
  void testRemoveById() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualRemoveByIdResult = (new EntityNamedNoteTypeDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .removeById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"entity_named_note_type\" where (\"entity_named_note_type\".\"id\" = ? and not exists (select \"entity_named_note\".\"entity_id\" from \"entity_named_note\" where \"entity_named_note\".\"named_note_type_id\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveByIdResult);
  }

  /**
   * Method under test: {@link EntityNamedNoteTypeDao#removeById(Long)}
   */
  @Test
  void testRemoveById2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualRemoveByIdResult = (new EntityNamedNoteTypeDao(new DefaultDSLContext(connection, SQLDialect.MARIADB)))
        .removeById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from `entity_named_note_type` where (`entity_named_note_type`.`id` = ? and not exists (select `entity_named_note`.`entity_id` from `entity_named_note` where `entity_named_note`.`named_note_type_id` = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveByIdResult);
  }

  /**
   * Method under test: {@link EntityNamedNoteTypeDao#removeById(Long)}
   */
  @Test
  void testRemoveById3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualRemoveByIdResult = (new EntityNamedNoteTypeDao(
        new DefaultDSLContext(connection, SQLDialect.POSTGRES))).removeById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"entity_named_note_type\" where (\"entity_named_note_type\".\"id\" = ? and not exists (select \"entity_named_note\".\"entity_id\" from \"entity_named_note\" where \"entity_named_note\".\"named_note_type_id\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveByIdResult);
  }

  /**
   * Method under test: {@link EntityNamedNoteTypeDao#removeById(Long)}
   */
  @Test
  void testRemoveById4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualRemoveByIdResult = (new EntityNamedNoteTypeDao(new DefaultDSLContext(connection, SQLDialect.SQLITE)))
        .removeById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from entity_named_note_type where (entity_named_note_type.id = ? and not exists (select entity_named_note.entity_id from entity_named_note where entity_named_note.named_note_type_id = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveByIdResult);
  }

  /**
   * Method under test: {@link EntityNamedNoteTypeDao#getById(long)}
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
    EntityNamedNodeType actualById = (new EntityNamedNoteTypeDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"entity_named_note_type\".\"id\", \"entity_named_note_type\".\"applicable_entity_kinds\", \"entity_named_note_type\".\"name\", \"entity_named_note_type\".\"description\", \"entity_named_note_type\".\"is_readonly\", \"entity_named_note_type\".\"position\", \"entity_named_note_type\".\"external_id\" from \"entity_named_note_type\" where \"entity_named_note_type\".\"id\" = ?"));
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

  /**
   * Method under test: {@link EntityNamedNoteTypeDao#getByExternalId(String)}
   */
  @Test
  void testGetByExternalId() throws SQLException {
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
    EntityNamedNodeType actualByExternalId = (new EntityNamedNoteTypeDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getByExternalId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"entity_named_note_type\".\"id\", \"entity_named_note_type\".\"applicable_entity_kinds\", \"entity_named_note_type\".\"name\", \"entity_named_note_type\".\"description\", \"entity_named_note_type\".\"is_readonly\", \"entity_named_note_type\".\"position\", \"entity_named_note_type\".\"external_id\" from \"entity_named_note_type\" where \"entity_named_note_type\".\"external_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualByExternalId);
  }
}
