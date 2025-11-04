package org.finos.waltz.jobs.generators;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import org.finos.waltz.schema.tables.records.DataTypeRecord;
import org.jooq.DSLContext;
import org.jooq.DeleteUsingStep;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class DataTypeGeneratorDiffblueTest {
  /**
   * Method under test: {@link DataTypeGenerator#remove(ApplicationContext)}
   */
  @Test
  void testRemove() throws SQLException, BeansException {
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

  /**
   * Method under test: {@link DataTypeGenerator#remove(ApplicationContext)}
   */
  @Test
  void testRemove2() throws DataAccessException, BeansException {
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
}
