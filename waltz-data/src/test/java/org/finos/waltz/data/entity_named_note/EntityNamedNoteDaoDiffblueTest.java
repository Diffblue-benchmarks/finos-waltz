package org.finos.waltz.data.entity_named_note;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.entity_named_note.EntityNamedNote;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityNamedNoteDaoDiffblueTest {
  /**
   * Method under test:
   * {@link EntityNamedNoteDao#save(EntityReference, long, String, UserTimestamp)}
   */
  @Test
  void testSave() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    EntityNamedNoteDao entityNamedNoteDao = new EntityNamedNoteDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);
    UserTimestamp lastUpdate = mock(UserTimestamp.class);
    when(lastUpdate.by()).thenReturn("By");
    when(lastUpdate.at()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    boolean actualSaveResult = entityNamedNoteDao.save(ref, 1L, "Note Text", lastUpdate);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).setTimestamp(eq(6), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ref).id();
    verify(ref).kind();
    verify(lastUpdate).at();
    verify(lastUpdate).by();
    assertFalse(actualSaveResult);
  }

  /**
   * Method under test: {@link EntityNamedNoteDao#remove(EntityReference)}
   */
  @Test
  void testRemove() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    EntityNamedNoteDao entityNamedNoteDao = new EntityNamedNoteDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualRemoveResult = entityNamedNoteDao.remove(ref);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"entity_named_note\" where (\"entity_named_note\".\"entity_kind\" = ? and \"entity_named_note\".\"entity_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("ALL"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(ref).id();
    verify(ref).kind();
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test: {@link EntityNamedNoteDao#remove(EntityReference)}
   */
  @Test
  void testRemove2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    EntityNamedNoteDao entityNamedNoteDao = new EntityNamedNoteDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualRemoveResult = entityNamedNoteDao.remove(ref);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"entity_named_note\" where (\"entity_named_note\".\"entity_kind\" = ? and \"entity_named_note\".\"entity_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("ALL"));
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    verify(ref).id();
    verify(ref).kind();
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test: {@link EntityNamedNoteDao#remove(EntityReference, long)}
   */
  @Test
  void testRemove3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    EntityNamedNoteDao entityNamedNoteDao = new EntityNamedNoteDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualRemoveResult = entityNamedNoteDao.remove(ref, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"entity_named_note\" where (\"entity_named_note\".\"entity_kind\" = ? and \"entity_named_note\".\"entity_id\" = ? and \"entity_named_note\".\"named_note_type_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("ALL"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(ref).id();
    verify(ref).kind();
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test: {@link EntityNamedNoteDao#findByNoteTypeExtId(String)}
   */
  @Test
  void testFindByNoteTypeExtId() throws SQLException {
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
    Set<EntityNamedNote> actualFindByNoteTypeExtIdResult = (new EntityNamedNoteDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByNoteTypeExtId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"entity_named_note\".\"entity_id\", \"entity_named_note\".\"entity_kind\", \"entity_named_note\".\"named_note_type_id\", \"entity_named_note\".\"note_text\", \"entity_named_note\".\"provenance\", \"entity_named_note\".\"last_updated_at\", \"entity_named_note\".\"last_updated_by\" from \"entity_named_note\" join \"entity_named_note_type\" on \"entity_named_note\".\"named_note_type_id\" = \"entity_named_note_type\".\"id\" where \"entity_named_note_type\".\"external_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByNoteTypeExtIdResult.isEmpty());
  }
}
