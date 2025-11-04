package org.finos.waltz.data.external_identifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.external_identifier.ExternalIdentifier;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ExternalIdentifierDaoDiffblueTest {
  /**
   * Method under test: {@link ExternalIdentifierDao#create(Set)}
   */
  @Test
  void testCreate() {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = new ExternalIdentifierDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, externalIdentifierDao.create(new HashSet<>()).length);
  }

  /**
   * Method under test: {@link ExternalIdentifierDao#create(Set)}
   */
  @Test
  void testCreate2() {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = new ExternalIdentifierDao(
        new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, externalIdentifierDao.create(new HashSet<>()).length);
  }

  /**
   * Method under test:
   * {@link ExternalIdentifierDao#findByKind(EntityKind, String)}
   */
  @Test
  void testFindByKind() throws SQLException {
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
    Set<ExternalIdentifier> actualFindByKindResult = (new ExternalIdentifierDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByKind(EntityKind.ALL, "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"external_identifier\".\"entity_kind\", \"external_identifier\".\"entity_id\", \"external_identifier\".\"system\", \"external_identifier\".\"external_id\" from \"external_identifier\" where (\"external_identifier\".\"entity_kind\" = ? and \"external_identifier\".\"external_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByKindResult.isEmpty());
  }

  /**
   * Method under test: {@link ExternalIdentifierDao#delete(Collection)}
   */
  @Test
  void testDelete() {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = new ExternalIdentifierDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, externalIdentifierDao.delete(new ArrayList<>()).length);
  }

  /**
   * Method under test: {@link ExternalIdentifierDao#delete(Collection)}
   */
  @Test
  void testDelete2() {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = new ExternalIdentifierDao(
        new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, externalIdentifierDao.delete(new ArrayList<>()).length);
  }
}
