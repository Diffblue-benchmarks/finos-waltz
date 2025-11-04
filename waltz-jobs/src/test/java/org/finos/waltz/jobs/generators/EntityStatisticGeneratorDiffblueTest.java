package org.finos.waltz.jobs.generators;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import org.finos.waltz.schema.tables.records.EntityStatisticDefinitionRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
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

class EntityStatisticGeneratorDiffblueTest {
  /**
   * Method under test:
   * {@link EntityStatisticGenerator#remove(ApplicationContext)}
   */
  @Test
  void testRemove() throws SQLException, BeansException {
    // Arrange
    EntityStatisticGenerator entityStatisticGenerator = new EntityStatisticGenerator();
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
    boolean actualRemoveResult = entityStatisticGenerator.remove(ctx);

    // Assert
    verify(connection).prepareStatement(
        eq("delete from \"entity_statistic_definition\" where \"entity_statistic_definition\".\"provenance\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("waltz-sample"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(ctx).getBean(isA(Class.class));
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link EntityStatisticGenerator#remove(ApplicationContext)}
   */
  @Test
  void testRemove2() throws DataAccessException, BeansException {
    // Arrange
    EntityStatisticGenerator entityStatisticGenerator = new EntityStatisticGenerator();
    DeleteConditionStep<EntityStatisticDefinitionRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteUsingStep<EntityStatisticDefinitionRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DefaultDSLContext defaultDSLContext = mock(DefaultDSLContext.class);
    when(defaultDSLContext.deleteFrom(Mockito.<Table<EntityStatisticDefinitionRecord>>any()))
        .thenReturn(deleteUsingStep);
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any())).thenReturn(defaultDSLContext);

    // Act
    boolean actualRemoveResult = entityStatisticGenerator.remove(ctx);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(defaultDSLContext).deleteFrom(isA(Table.class));
    verify(ctx).getBean(isA(Class.class));
    assertFalse(actualRemoveResult);
  }
}
