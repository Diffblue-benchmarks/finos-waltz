package org.finos.waltz.jobs.generators;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import org.finos.waltz.schema.tables.records.LogicalFlowRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.DeleteWhereStep;
import org.jooq.Query;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class LogicalFlowGeneratorDiffblueTest {
  /**
   * Test {@link LogicalFlowGenerator#remove(ApplicationContext)}.
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link Query#execute()} return one.</li>
   *   <li>Then calls {@link DeleteWhereStep#where(Condition)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalFlowGenerator#remove(ApplicationContext)}
   */
  @Test
  @DisplayName("Test remove(ApplicationContext); given DeleteConditionStep execute() return one; then calls where(Condition)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LogicalFlowGenerator.remove(ApplicationContext)"})
  void testRemove_givenDeleteConditionStepExecuteReturnOne_thenCallsWhere() throws DataAccessException, BeansException {
    // Arrange
    LogicalFlowGenerator logicalFlowGenerator = new LogicalFlowGenerator();
    DeleteConditionStep<LogicalFlowRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteUsingStep<LogicalFlowRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DefaultDSLContext defaultDSLContext = mock(DefaultDSLContext.class);
    when(defaultDSLContext.deleteFrom(Mockito.<Table<LogicalFlowRecord>>any())).thenReturn(deleteUsingStep);
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any())).thenReturn(defaultDSLContext);

    // Act
    boolean actualRemoveResult = logicalFlowGenerator.remove(ctx);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(defaultDSLContext).deleteFrom(isA(Table.class));
    verify(ctx).getBean(isA(Class.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link LogicalFlowGenerator#remove(ApplicationContext)}.
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.</li>
   *   <li>Then calls {@link Connection#prepareStatement(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalFlowGenerator#remove(ApplicationContext)}
   */
  @Test
  @DisplayName("Test remove(ApplicationContext); given PreparedStatement execute() return 'true'; then calls prepareStatement(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LogicalFlowGenerator.remove(ApplicationContext)"})
  void testRemove_givenPreparedStatementExecuteReturnTrue_thenCallsPrepareStatement()
      throws SQLException, BeansException {
    // Arrange
    LogicalFlowGenerator logicalFlowGenerator = new LogicalFlowGenerator();
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
    boolean actualRemoveResult = logicalFlowGenerator.remove(ctx);

    // Assert
    verify(connection).prepareStatement(eq("delete from \"logical_flow\" where \"logical_flow\".\"provenance\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("waltz-sample"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(ctx).getBean(isA(Class.class));
    assertTrue(actualRemoveResult);
  }
}
