package org.finos.waltz.jobs.generators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.List;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class SampleDataGeneratorDiffblueTest {
  /**
   * Test {@link SampleDataGenerator#getDsl(ApplicationContext)}.
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(SQLDialect)} with dialect is {@code SQL99}.</li>
   *   <li>Then return {@link DefaultDSLContext}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampleDataGenerator#getDsl(ApplicationContext)}
   */
  @Test
  @DisplayName("Test getDsl(ApplicationContext); given DefaultDSLContext(SQLDialect) with dialect is 'SQL99'; then return DefaultDSLContext")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DSLContext SampleDataGenerator.getDsl(ApplicationContext)"})
  void testGetDsl_givenDefaultDSLContextWithDialectIsSql99_thenReturnDefaultDSLContext() throws BeansException {
    // Arrange
    AppGenerator appGenerator = new AppGenerator();
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(SQLDialect.SQL99);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any())).thenReturn(defaultDSLContext);

    // Act
    DSLContext actualDsl = appGenerator.getDsl(ctx);

    // Assert
    verify(ctx).getBean(isA(Class.class));
    assertTrue(actualDsl instanceof DefaultDSLContext);
    assertSame(defaultDSLContext, actualDsl);
  }

  /**
   * Test {@link SampleDataGenerator#getAppIds(DSLContext)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} return one.</li>
   *   <li>Then return first longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampleDataGenerator#getAppIds(DSLContext)}
   */
  @Test
  @DisplayName("Test getAppIds(DSLContext); given ResultSet getLong(int) return one; then return first longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SampleDataGenerator.getAppIds(DSLContext)"})
  void testGetAppIds_givenResultSetGetLongReturnOne_thenReturnFirstLongValueIsOne() throws SQLException {
    // Arrange
    AppGenerator appGenerator = new AppGenerator();
    ResultSet resultSet = mock(ResultSet.class);
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
    List<Long> actualAppIds = appGenerator.getAppIds(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Assert
    verify(connection).prepareStatement(eq("select \"application\".\"id\" from \"application\" where 1 = 1"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualAppIds.size());
    assertEquals(1L, actualAppIds.get(0).longValue());
    assertEquals(1L, actualAppIds.get(1).longValue());
  }

  /**
   * Test {@link SampleDataGenerator#getAppIds(DSLContext)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#wasNull()} return {@code true}.</li>
   *   <li>Then return first is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampleDataGenerator#getAppIds(DSLContext)}
   */
  @Test
  @DisplayName("Test getAppIds(DSLContext); given ResultSet wasNull() return 'true'; then return first is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SampleDataGenerator.getAppIds(DSLContext)"})
  void testGetAppIds_givenResultSetWasNullReturnTrue_thenReturnFirstIsNull() throws SQLException {
    // Arrange
    AppGenerator appGenerator = new AppGenerator();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
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
    List<Long> actualAppIds = appGenerator.getAppIds(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Assert
    verify(connection).prepareStatement(eq("select \"application\".\"id\" from \"application\" where 1 = 1"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualAppIds.size());
    assertNull(actualAppIds.get(0));
    assertNull(actualAppIds.get(1));
  }

  /**
   * Test {@link SampleDataGenerator#deleteRatingsForCategory(DSLContext, long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} return one.</li>
   *   <li>Then calls {@link ResultSet#getLong(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampleDataGenerator#deleteRatingsForCategory(DSLContext, long)}
   */
  @Test
  @DisplayName("Test deleteRatingsForCategory(DSLContext, long); given ResultSet getLong(int) return one; then calls getLong(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SampleDataGenerator.deleteRatingsForCategory(DSLContext, long)"})
  void testDeleteRatingsForCategory_givenResultSetGetLongReturnOne_thenCallsGetLong() throws SQLException {
    // Arrange
    AppGenerator appGenerator = new AppGenerator();
    ResultSet resultSet = mock(ResultSet.class);
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

    // Act
    boolean actualDeleteRatingsForCategoryResult = appGenerator
        .deleteRatingsForCategory(new DefaultDSLContext(connection, SQLDialect.SQL99), 1L);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(eq(1), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(eq(2), eq("waltz-sample"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualDeleteRatingsForCategoryResult);
  }

  /**
   * Test {@link SampleDataGenerator#deleteRatingsForCategory(DSLContext, long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampleDataGenerator#deleteRatingsForCategory(DSLContext, long)}
   */
  @Test
  @DisplayName("Test deleteRatingsForCategory(DSLContext, long); given ResultSet next() return 'false'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SampleDataGenerator.deleteRatingsForCategory(DSLContext, long)"})
  void testDeleteRatingsForCategory_givenResultSetNextReturnFalse_thenReturnTrue() throws SQLException {
    // Arrange
    AppGenerator appGenerator = new AppGenerator();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
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

    // Act
    boolean actualDeleteRatingsForCategoryResult = appGenerator
        .deleteRatingsForCategory(new DefaultDSLContext(connection, SQLDialect.SQL99), 1L);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(eq(1), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(eq(2), eq("waltz-sample"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualDeleteRatingsForCategoryResult);
  }

  /**
   * Test {@link SampleDataGenerator#deleteRatingsForCategory(DSLContext, long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#wasNull()} return {@code true}.</li>
   *   <li>Then calls {@link ResultSet#wasNull()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampleDataGenerator#deleteRatingsForCategory(DSLContext, long)}
   */
  @Test
  @DisplayName("Test deleteRatingsForCategory(DSLContext, long); given ResultSet wasNull() return 'true'; then calls wasNull()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SampleDataGenerator.deleteRatingsForCategory(DSLContext, long)"})
  void testDeleteRatingsForCategory_givenResultSetWasNullReturnTrue_thenCallsWasNull() throws SQLException {
    // Arrange
    AppGenerator appGenerator = new AppGenerator();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getLong(anyInt())).thenReturn(0L);
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

    // Act
    boolean actualDeleteRatingsForCategoryResult = appGenerator
        .deleteRatingsForCategory(new DefaultDSLContext(connection, SQLDialect.SQL99), 1L);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(eq(1), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(eq(2), eq("waltz-sample"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualDeleteRatingsForCategoryResult);
  }
}
