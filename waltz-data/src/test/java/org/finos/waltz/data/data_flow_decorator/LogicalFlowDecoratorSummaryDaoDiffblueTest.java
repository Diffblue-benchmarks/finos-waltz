package org.finos.waltz.data.data_flow_decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.List;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.model.data_flow_decorator.DecoratorRatingSummary;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.finos.waltz.schema.tables.records.LogicalFlowDecoratorRecord;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LogicalFlowDecoratorSummaryDaoDiffblueTest {
  /**
   * Method under test: {@link LogicalFlowDecoratorSummaryDao#summarizeForAll()}
   */
  @Test
  void testSummarizeForAll() throws SQLException {
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
    List<DecoratorRatingSummary> actualSummarizeForAllResult = (new LogicalFlowDecoratorSummaryDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).summarizeForAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow_decorator\".\"decorator_entity_kind\", \"logical_flow_decorator\".\"decorator_entity_id\", \"logical_flow_decorator\".\"rating\", count(\"logical_flow_decorator\".\"decorator_entity_id\") \"count\" from \"logical_flow_decorator\" join \"logical_flow\" on (\"logical_flow\".\"id\" = \"logical_flow_decorator\".\"logical_flow_id\") where ((\"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> 'REMOVED')) group by \"logical_flow_decorator\".\"decorator_entity_kind\", \"logical_flow_decorator\".\"decorator_entity_id\", \"logical_flow_decorator\".\"rating\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualSummarizeForAllResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorSummaryDao#updateRatingsByCondition(AuthoritativenessRatingValue, Condition)}
   */
  @Test
  void testUpdateRatingsByCondition() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    LogicalFlowDecoratorSummaryDao logicalFlowDecoratorSummaryDao = new LogicalFlowDecoratorSummaryDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualUpdateRatingsByConditionResult = logicalFlowDecoratorSummaryDao
        .updateRatingsByCondition(AuthoritativenessRatingValue.of("42"), ApplicationDao.IS_ACTIVE);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"logical_flow_decorator\" set \"logical_flow_decorator\".\"rating\" = ? where \"application\".\"entity_lifecycle_status\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateRatingsByConditionResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorSummaryDao#updateRatingsByCondition(AuthoritativenessRatingValue, Condition)}
   */
  @Test
  void testUpdateRatingsByCondition2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<LogicalFlowDecoratorRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<LogicalFlowDecoratorRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<LogicalFlowDecoratorRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<LogicalFlowDecoratorRecord>>any())).thenReturn(updateSetFirstStep);
    LogicalFlowDecoratorSummaryDao logicalFlowDecoratorSummaryDao = new LogicalFlowDecoratorSummaryDao(dsl);

    // Act
    int actualUpdateRatingsByConditionResult = logicalFlowDecoratorSummaryDao
        .updateRatingsByCondition(AuthoritativenessRatingValue.of("42"), ApplicationDao.IS_ACTIVE);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateRatingsByConditionResult);
  }
}
