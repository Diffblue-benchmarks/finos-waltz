package org.finos.waltz.jobs.generators;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.Map;
import org.finos.waltz.schema.tables.records.ApplicationGroupEntryRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class AppGroupGeneratorDiffblueTest {
  /**
   * Method under test: {@link AppGroupGenerator#create(ApplicationContext)}
   */
  @Test
  void testCreate() throws SQLException, BeansException {
    // Arrange
    AppGroupGenerator appGroupGenerator = new AppGroupGenerator();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any())).thenReturn(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Map<String, Integer> actualCreateResult = appGroupGenerator.create(ctx);

    // Assert
    verify(connection).prepareStatement(
        eq("insert into \"application_group\" (\"name\", \"kind\", \"description\") values (?, ?, ?)"));
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement).getWarnings();
    verify(ctx).getBean(isA(Class.class));
    assertNull(actualCreateResult);
  }

  /**
   * Method under test: {@link AppGroupGenerator#create(ApplicationContext)}
   */
  @Test
  void testCreate2() throws SQLException, BeansException {
    // Arrange
    AppGroupGenerator appGroupGenerator = new AppGroupGenerator();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any()))
        .thenReturn(new DefaultDSLContext(connection, SQLDialect.CUBRID));

    // Act
    Map<String, Integer> actualCreateResult = appGroupGenerator.create(ctx);

    // Assert
    verify(connection).prepareStatement(eq(
        "insert into \"application_group\" (\"name\", \"kind\", \"description\") values (cast(? as varchar), cast(? as varchar), cast(? as varchar))"));
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement).getWarnings();
    verify(ctx).getBean(isA(Class.class));
    assertNull(actualCreateResult);
  }

  /**
   * Method under test: {@link AppGroupGenerator#remove(ApplicationContext)}
   */
  @Test
  void testRemove() throws SQLException, BeansException {
    // Arrange
    AppGroupGenerator appGroupGenerator = new AppGroupGenerator();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any())).thenReturn(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    boolean actualRemoveResult = appGroupGenerator.remove(ctx);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(eq(1), eq("waltz-sample"));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ctx).getBean(isA(Class.class));
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test: {@link AppGroupGenerator#remove(ApplicationContext)}
   */
  @Test
  void testRemove2() throws DataAccessException, BeansException {
    // Arrange
    AppGroupGenerator appGroupGenerator = new AppGroupGenerator();
    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteUsingStep<ApplicationGroupEntryRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DefaultDSLContext defaultDSLContext = mock(DefaultDSLContext.class);
    when(defaultDSLContext.deleteFrom(Mockito.<Table<ApplicationGroupEntryRecord>>any())).thenReturn(deleteUsingStep);
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any())).thenReturn(defaultDSLContext);

    // Act
    boolean actualRemoveResult = appGroupGenerator.remove(ctx);

    // Assert
    verify(deleteUsingStep, atLeast(1)).where(Mockito.<Condition>any());
    verify(deleteConditionStep, atLeast(1)).execute();
    verify(defaultDSLContext, atLeast(1)).deleteFrom(Mockito.<Table<Record>>any());
    verify(ctx).getBean(isA(Class.class));
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test: {@link AppGroupGenerator#remove(ApplicationContext)}
   */
  @Test
  void testRemove3() throws SQLException, BeansException {
    // Arrange
    AppGroupGenerator appGroupGenerator = new AppGroupGenerator();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any()))
        .thenReturn(new DefaultDSLContext(connection, SQLDialect.FIREBIRD));

    // Act
    boolean actualRemoveResult = appGroupGenerator.remove(ctx);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(eq(1), eq("waltz-sample"));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ctx).getBean(isA(Class.class));
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test: {@link AppGroupGenerator#remove(ApplicationContext)}
   */
  @Test
  void testRemove4() throws SQLException, BeansException {
    // Arrange
    AppGroupGenerator appGroupGenerator = new AppGroupGenerator();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any()))
        .thenReturn(new DefaultDSLContext(connection, SQLDialect.MARIADB));

    // Act
    boolean actualRemoveResult = appGroupGenerator.remove(ctx);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(eq(1), eq("waltz-sample"));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ctx).getBean(isA(Class.class));
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test: {@link AppGroupGenerator#remove(ApplicationContext)}
   */
  @Test
  void testRemove5() throws SQLException, BeansException {
    // Arrange
    AppGroupGenerator appGroupGenerator = new AppGroupGenerator();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any()))
        .thenReturn(new DefaultDSLContext(connection, SQLDialect.POSTGRES));

    // Act
    boolean actualRemoveResult = appGroupGenerator.remove(ctx);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(eq(1), eq("waltz-sample"));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ctx).getBean(isA(Class.class));
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test: {@link AppGroupGenerator#remove(ApplicationContext)}
   */
  @Test
  void testRemove6() throws SQLException, BeansException {
    // Arrange
    AppGroupGenerator appGroupGenerator = new AppGroupGenerator();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any()))
        .thenReturn(new DefaultDSLContext(connection, SQLDialect.SQLITE));

    // Act
    boolean actualRemoveResult = appGroupGenerator.remove(ctx);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(eq(1), eq("waltz-sample"));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ctx).getBean(isA(Class.class));
    assertFalse(actualRemoveResult);
  }
}
