package org.finos.waltz.jobs.generators;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import org.finos.waltz.schema.tables.records.ComplexityRecord;
import org.jooq.DSLContext;
import org.jooq.DeleteUsingStep;
import org.jooq.Query;
import org.jooq.Record;
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

class ComplexityGeneratorDiffblueTest {
  /**
   * Test {@link ComplexityGenerator#remove(ApplicationContext)}.
   * <ul>
   *   <li>Given {@link DeleteUsingStep} {@link Query#execute()} return one.</li>
   *   <li>Then calls {@link DSLContext#deleteFrom(Table)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComplexityGenerator#remove(ApplicationContext)}
   */
  @Test
  @DisplayName("Test remove(ApplicationContext); given DeleteUsingStep execute() return one; then calls deleteFrom(Table)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ComplexityGenerator.remove(ApplicationContext)"})
  void testRemove_givenDeleteUsingStepExecuteReturnOne_thenCallsDeleteFrom()
      throws DataAccessException, BeansException {
    // Arrange
    ComplexityGenerator complexityGenerator = new ComplexityGenerator();
    DeleteUsingStep<ComplexityRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.execute()).thenReturn(1);
    DSLContext dslContext = mock(DSLContext.class);
    when(dslContext.deleteFrom(Mockito.<Table<ComplexityRecord>>any())).thenReturn(deleteUsingStep);
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any())).thenReturn(dslContext);

    // Act
    boolean actualRemoveResult = complexityGenerator.remove(ctx);

    // Assert
    verify(dslContext, atLeast(1)).deleteFrom(Mockito.<Table<Record>>any());
    verify(deleteUsingStep, atLeast(1)).execute();
    verify(ctx, atLeast(1)).getBean(isA(Class.class));
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link ComplexityGenerator#remove(ApplicationContext)}.
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.</li>
   *   <li>Then calls {@link Connection#prepareStatement(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComplexityGenerator#remove(ApplicationContext)}
   */
  @Test
  @DisplayName("Test remove(ApplicationContext); given PreparedStatement execute() return 'true'; then calls prepareStatement(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ComplexityGenerator.remove(ApplicationContext)"})
  void testRemove_givenPreparedStatementExecuteReturnTrue_thenCallsPrepareStatement()
      throws SQLException, BeansException {
    // Arrange
    ComplexityGenerator complexityGenerator = new ComplexityGenerator();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any())).thenReturn(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    boolean actualRemoveResult = complexityGenerator.remove(ctx);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ctx, atLeast(1)).getBean(isA(Class.class));
    assertFalse(actualRemoveResult);
  }
}
