package org.finos.waltz.data.entity_named_note;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.entity_named_note.EntityNamedNodeType;
import org.finos.waltz.model.entity_named_note.EntityNamedNoteTypeChangeCommand;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityNamedNoteTypeDaoDiffblueTest {
  /**
   * Test {@link EntityNamedNoteTypeDao#create(EntityNamedNoteTypeChangeCommand)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} return one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityNamedNoteTypeDao#create(EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  @DisplayName("Test create(EntityNamedNoteTypeChangeCommand); given ResultSet getLong(int) return one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long EntityNamedNoteTypeDao.create(EntityNamedNoteTypeChangeCommand)"})
  void testCreate_givenResultSetGetLongReturnOne_thenReturnOne() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement);
    EntityNamedNoteTypeDao entityNamedNoteTypeDao = new EntityNamedNoteTypeDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));
    EntityNamedNoteTypeChangeCommand command = mock(EntityNamedNoteTypeChangeCommand.class);
    Optional<String> ofResult = Optional.of("foo");
    when(command.description()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(command.externalId()).thenReturn(ofResult2);
    Optional<Boolean> ofResult3 = Optional.of(true);
    when(command.isReadOnly()).thenReturn(ofResult3);
    Optional<Integer> ofResult4 = Optional.<Integer>of(1);
    when(command.position()).thenReturn(ofResult4);
    Optional<Set<EntityKind>> ofResult5 = Optional.of(new HashSet<>());
    when(command.applicableEntityKinds()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(command.name()).thenReturn(ofResult6);

    // Act
    long actualCreateResult = entityNamedNoteTypeDao.create(command);

    // Assert
    verify(connection).prepareStatement(eq(
        "insert into \"entity_named_note_type\" (\"applicable_entity_kinds\", \"name\", \"description\", \"is_readonly\", \"position\", \"external_id\") values (?, ?, ?, ?, ?, ?)"),
        isA(String[].class));
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement).setBoolean(eq(4), eq(true));
    verify(preparedStatement).setInt(eq(5), eq(1));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getGeneratedKeys();
    verify(preparedStatement).getWarnings();
    verify(command).applicableEntityKinds();
    verify(command).description();
    verify(command).externalId();
    verify(command).isReadOnly();
    verify(command).name();
    verify(command).position();
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeDao#getById(long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityNamedNoteTypeDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); given ResultSet next() return 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityNamedNodeType EntityNamedNoteTypeDao.getById(long)"})
  void testGetById_givenResultSetNextReturnFalse_thenReturnNull() throws SQLException {
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
   * Test {@link EntityNamedNoteTypeDao#getByExternalId(String)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityNamedNoteTypeDao#getByExternalId(String)}
   */
  @Test
  @DisplayName("Test getByExternalId(String); given ResultSet next() return 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityNamedNodeType EntityNamedNoteTypeDao.getByExternalId(String)"})
  void testGetByExternalId_givenResultSetNextReturnFalse_thenReturnNull() throws SQLException {
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
