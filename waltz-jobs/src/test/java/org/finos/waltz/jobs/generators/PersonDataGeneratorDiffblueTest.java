package org.finos.waltz.jobs.generators;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import org.finos.waltz.schema.tables.records.InvolvementRecord;
import org.jooq.DSLContext;
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

class PersonDataGeneratorDiffblueTest {
  /**
   * Method under test: {@link PersonDataGenerator#remove(ApplicationContext)}
   */
  @Test
  void testRemove() throws SQLException, BeansException {
    // Arrange
    PersonDataGenerator personDataGenerator = new PersonDataGenerator();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any())).thenReturn(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    boolean actualRemoveResult = personDataGenerator.remove(ctx);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ctx, atLeast(1)).getBean(isA(Class.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test: {@link PersonDataGenerator#remove(ApplicationContext)}
   */
  @Test
  void testRemove2() throws DataAccessException, BeansException {
    // Arrange
    PersonDataGenerator personDataGenerator = new PersonDataGenerator();
    DeleteUsingStep<InvolvementRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.execute()).thenReturn(1);
    DefaultDSLContext defaultDSLContext = mock(DefaultDSLContext.class);
    when(defaultDSLContext.deleteFrom(Mockito.<Table<InvolvementRecord>>any())).thenReturn(deleteUsingStep);
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any())).thenReturn(defaultDSLContext);

    // Act
    boolean actualRemoveResult = personDataGenerator.remove(ctx);

    // Assert
    verify(deleteUsingStep, atLeast(1)).execute();
    verify(defaultDSLContext, atLeast(1)).deleteFrom(Mockito.<Table<Record>>any());
    verify(ctx, atLeast(1)).getBean(isA(Class.class));
    assertTrue(actualRemoveResult);
  }
}
