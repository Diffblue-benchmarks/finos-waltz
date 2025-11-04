package org.finos.waltz.jobs.generators;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
import org.finos.waltz.schema.tables.records.SurveyQuestionResponseRecord;
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

class SurveyRunGeneratorDiffblueTest {
  /**
   * Method under test: {@link SurveyRunGenerator#remove(ApplicationContext)}
   */
  @Test
  void testRemove() throws SQLException, BeansException {
    // Arrange
    SurveyRunGenerator surveyRunGenerator = new SurveyRunGenerator();
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
    boolean actualRemoveResult = surveyRunGenerator.remove(ctx);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(eq(1), eq("% (GENERATOR)"));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ctx).getBean(isA(Class.class));
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test: {@link SurveyRunGenerator#remove(ApplicationContext)}
   */
  @Test
  void testRemove2() throws DataAccessException, BeansException {
    // Arrange
    SurveyRunGenerator surveyRunGenerator = new SurveyRunGenerator();
    DeleteConditionStep<SurveyQuestionResponseRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteUsingStep<SurveyQuestionResponseRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DefaultDSLContext defaultDSLContext = mock(DefaultDSLContext.class);
    when(defaultDSLContext.deleteFrom(Mockito.<Table<SurveyQuestionResponseRecord>>any())).thenReturn(deleteUsingStep);
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any())).thenReturn(defaultDSLContext);

    // Act
    boolean actualRemoveResult = surveyRunGenerator.remove(ctx);

    // Assert
    verify(deleteUsingStep, atLeast(1)).where(Mockito.<Condition>any());
    verify(deleteConditionStep, atLeast(1)).execute();
    verify(defaultDSLContext, atLeast(1)).deleteFrom(Mockito.<Table<Record>>any());
    verify(ctx).getBean(isA(Class.class));
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test: {@link SurveyRunGenerator#remove(ApplicationContext)}
   */
  @Test
  void testRemove3() throws SQLException, BeansException {
    // Arrange
    SurveyRunGenerator surveyRunGenerator = new SurveyRunGenerator();
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
    boolean actualRemoveResult = surveyRunGenerator.remove(ctx);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(eq(1), eq("% (GENERATOR)"));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ctx).getBean(isA(Class.class));
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test: {@link SurveyRunGenerator#remove(ApplicationContext)}
   */
  @Test
  void testRemove4() throws SQLException, BeansException {
    // Arrange
    SurveyRunGenerator surveyRunGenerator = new SurveyRunGenerator();
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
    boolean actualRemoveResult = surveyRunGenerator.remove(ctx);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(eq(1), eq("% (GENERATOR)"));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ctx).getBean(isA(Class.class));
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test: {@link SurveyRunGenerator#remove(ApplicationContext)}
   */
  @Test
  void testRemove5() throws SQLException, BeansException {
    // Arrange
    SurveyRunGenerator surveyRunGenerator = new SurveyRunGenerator();
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
    boolean actualRemoveResult = surveyRunGenerator.remove(ctx);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(eq(1), eq("% (GENERATOR)"));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ctx).getBean(isA(Class.class));
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test: {@link SurveyRunGenerator#remove(ApplicationContext)}
   */
  @Test
  void testRemove6() throws SQLException, BeansException {
    // Arrange
    SurveyRunGenerator surveyRunGenerator = new SurveyRunGenerator();
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
    boolean actualRemoveResult = surveyRunGenerator.remove(ctx);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(eq(1), eq("% (GENERATOR)"));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ctx).getBean(isA(Class.class));
    assertFalse(actualRemoveResult);
  }
}
