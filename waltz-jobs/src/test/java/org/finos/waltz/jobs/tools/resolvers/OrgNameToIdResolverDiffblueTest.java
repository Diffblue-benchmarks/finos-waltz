package org.finos.waltz.jobs.tools.resolvers;

import static org.mockito.ArgumentMatchers.eq;
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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OrgNameToIdResolverDiffblueTest {
  /**
   * Test {@link OrgNameToIdResolver#OrgNameToIdResolver(DSLContext)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} return one.</li>
   *   <li>Then calls {@link ResultSet#getLong(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrgNameToIdResolver#OrgNameToIdResolver(DSLContext)}
   */
  @Test
  @DisplayName("Test new OrgNameToIdResolver(DSLContext); given ResultSet getLong(int) return one; then calls getLong(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OrgNameToIdResolver.<init>(DSLContext)"})
  void testNewOrgNameToIdResolver_givenResultSetGetLongReturnOne_thenCallsGetLong() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
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
    new OrgNameToIdResolver(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Assert
    verify(connection).prepareStatement(eq(
        "select trim(lower(\"organisational_unit\".\"name\")), \"organisational_unit\".\"id\" from \"organisational_unit\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(2));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Test {@link OrgNameToIdResolver#OrgNameToIdResolver(DSLContext)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrgNameToIdResolver#OrgNameToIdResolver(DSLContext)}
   */
  @Test
  @DisplayName("Test new OrgNameToIdResolver(DSLContext); given ResultSet next() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OrgNameToIdResolver.<init>(DSLContext)"})
  void testNewOrgNameToIdResolver_givenResultSetNextReturnFalse() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
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
    new OrgNameToIdResolver(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Assert
    verify(connection).prepareStatement(eq(
        "select trim(lower(\"organisational_unit\".\"name\")), \"organisational_unit\".\"id\" from \"organisational_unit\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Test {@link OrgNameToIdResolver#OrgNameToIdResolver(DSLContext)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#wasNull()} return {@code true}.</li>
   *   <li>Then calls {@link ResultSet#wasNull()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrgNameToIdResolver#OrgNameToIdResolver(DSLContext)}
   */
  @Test
  @DisplayName("Test new OrgNameToIdResolver(DSLContext); given ResultSet wasNull() return 'true'; then calls wasNull()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OrgNameToIdResolver.<init>(DSLContext)"})
  void testNewOrgNameToIdResolver_givenResultSetWasNullReturnTrue_thenCallsWasNull() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(0L);
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
    new OrgNameToIdResolver(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Assert
    verify(connection).prepareStatement(eq(
        "select trim(lower(\"organisational_unit\".\"name\")), \"organisational_unit\".\"id\" from \"organisational_unit\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(2));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
  }
}
