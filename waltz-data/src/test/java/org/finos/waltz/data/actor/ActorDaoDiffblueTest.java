package org.finos.waltz.data.actor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.util.Optional;
import org.finos.waltz.model.actor.ActorCreateCommand;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ActorDaoDiffblueTest {
  /**
   * Test {@link ActorDao#create(ActorCreateCommand, String)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} return one.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ActorDao#create(ActorCreateCommand, String)}
   */
  @Test
  @DisplayName("Test create(ActorCreateCommand, String); given ResultSet getLong(int) return one; then return longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ActorDao.create(ActorCreateCommand, String)"})
  void testCreate_givenResultSetGetLongReturnOne_thenReturnLongValueIsOne() throws SQLException {
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement);
    ActorDao actorDao = new ActorDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    ActorCreateCommand command = mock(ActorCreateCommand.class);
    when(command.isExternal()).thenReturn(true);
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.name()).thenReturn("Name");
    Optional<String> ofResult = Optional.of("foo");
    when(command.externalId()).thenReturn(ofResult);

    // Act
    Long actualCreateResult = actorDao.create(command, "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "insert into \"actor\" (\"name\", \"description\", \"last_updated_at\", \"last_updated_by\", \"is_external\", \"provenance\", \"external_id\") values (?, ?, ?, ?, ?, ?, ?)"),
        isA(String[].class));
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement).setBoolean(eq(5), eq(true));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getGeneratedKeys();
    verify(preparedStatement).getWarnings();
    verify(command).description();
    verify(command).externalId();
    verify(command).name();
    verify(command).isExternal();
    assertEquals(1L, actualCreateResult.longValue());
  }

  /**
   * Test {@link ActorDao#create(ActorCreateCommand, String)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#wasNull()} return {@code true}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ActorDao#create(ActorCreateCommand, String)}
   */
  @Test
  @DisplayName("Test create(ActorCreateCommand, String); given ResultSet wasNull() return 'true'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long ActorDao.create(ActorCreateCommand, String)"})
  void testCreate_givenResultSetWasNullReturnTrue_thenReturnNull() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getLong(anyInt())).thenReturn(0L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement);
    ActorDao actorDao = new ActorDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    ActorCreateCommand command = mock(ActorCreateCommand.class);
    when(command.isExternal()).thenReturn(true);
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.name()).thenReturn("Name");
    Optional<String> ofResult = Optional.of("foo");
    when(command.externalId()).thenReturn(ofResult);

    // Act
    Long actualCreateResult = actorDao.create(command, "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "insert into \"actor\" (\"name\", \"description\", \"last_updated_at\", \"last_updated_by\", \"is_external\", \"provenance\", \"external_id\") values (?, ?, ?, ?, ?, ?, ?)"),
        isA(String[].class));
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement).setBoolean(eq(5), eq(true));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement).close();
    verify(preparedStatement).getGeneratedKeys();
    verify(preparedStatement).getWarnings();
    verify(command).description();
    verify(command).externalId();
    verify(command).name();
    verify(command).isExternal();
    assertNull(actualCreateResult);
  }
}
