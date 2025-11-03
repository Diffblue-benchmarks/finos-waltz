package org.finos.waltz.jobs.generators;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import org.finos.waltz.schema.tables.records.DataTypeRecord;
import org.jooq.DSLContext;
import org.jooq.DeleteUsingStep;
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

class DataTypeGeneratorDiffblueTest {
  /**
   * Test {@link DataTypeGenerator#remove(ApplicationContext)}.
   * <ul>
   *   <li>Given {@link DeleteUsingStep} {@link Query#execute()} return one.</li>
   *   <li>Then calls {@link Query#execute()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataTypeGenerator#remove(ApplicationContext)}
   */
  @Test
  @DisplayName("Test remove(ApplicationContext); given DeleteUsingStep execute() return one; then calls execute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataTypeGenerator.remove(ApplicationContext)"})
  void testRemove_givenDeleteUsingStepExecuteReturnOne_thenCallsExecute() throws DataAccessException, BeansException {
    // Arrange
    DataTypeGenerator dataTypeGenerator = new DataTypeGenerator();
    DeleteUsingStep<DataTypeRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.execute()).thenReturn(1);
    DefaultDSLContext defaultDSLContext = mock(DefaultDSLContext.class);
    when(defaultDSLContext.deleteFrom(Mockito.<Table<DataTypeRecord>>any())).thenReturn(deleteUsingStep);
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any())).thenReturn(defaultDSLContext);

    // Act
    boolean actualRemoveResult = dataTypeGenerator.remove(ctx);

    // Assert
    verify(deleteUsingStep).execute();
    verify(defaultDSLContext).deleteFrom(isA(Table.class));
    verify(ctx).getBean(isA(Class.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link DataTypeGenerator#remove(ApplicationContext)}.
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.</li>
   *   <li>Then calls {@link Connection#prepareStatement(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataTypeGenerator#remove(ApplicationContext)}
   */
  @Test
  @DisplayName("Test remove(ApplicationContext); given PreparedStatement execute() return 'true'; then calls prepareStatement(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataTypeGenerator.remove(ApplicationContext)"})
  void testRemove_givenPreparedStatementExecuteReturnTrue_thenCallsPrepareStatement()
      throws SQLException, BeansException {
    // Arrange
    DataTypeGenerator dataTypeGenerator = new DataTypeGenerator();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any())).thenReturn(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    boolean actualRemoveResult = dataTypeGenerator.remove(ctx);

    // Assert
    verify(connection).prepareStatement(eq("delete from \"data_type\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(ctx).getBean(isA(Class.class));
    assertTrue(actualRemoveResult);
  }
}
