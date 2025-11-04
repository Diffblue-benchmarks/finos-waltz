package org.finos.waltz.data.scenario;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.model.scenario.ChangeScenarioCommand;
import org.finos.waltz.model.scenario.ScenarioRatingItem;
import org.finos.waltz.schema.tables.records.ScenarioRatingItemRecord;
import org.finos.waltz.schema.tables.records.ScenarioRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ScenarioRatingItemDaoDiffblueTest {
  /**
   * Method under test: {@link ScenarioRatingItemDao#findForScenarioId(long)}
   */
  @Test
  void testFindForScenarioId() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Collection<ScenarioRatingItem> actualFindForScenarioIdResult = (new ScenarioRatingItemDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findForScenarioId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"scenario_rating_item\".\"id\", \"scenario_rating_item\".\"scenario_id\", \"scenario_rating_item\".\"rating\", \"scenario_rating_item\".\"domain_item_kind\", \"scenario_rating_item\".\"domain_item_id\", \"scenario_rating_item\".\"row_kind\", \"scenario_rating_item\".\"row_id\", \"scenario_rating_item\".\"column_kind\", \"scenario_rating_item\".\"column_id\", \"scenario_rating_item\".\"last_updated_at\", \"scenario_rating_item\".\"last_updated_by\", \"scenario_rating_item\".\"description\" from \"scenario_rating_item\" where \"scenario_rating_item\".\"scenario_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindForScenarioIdResult instanceof List);
    assertTrue(actualFindForScenarioIdResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ScenarioRatingItemDao#remove(ChangeScenarioCommand, String)}
   */
  @Test
  void testRemove() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ScenarioRatingItemRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteUsingStep<ScenarioRatingItemRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    UpdateConditionStep<ScenarioRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetFirstStep<ScenarioRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<ScenarioRecord>>any())).thenReturn(updateSetFirstStep);
    when(dsl.deleteFrom(Mockito.<Table<ScenarioRatingItemRecord>>any())).thenReturn(deleteUsingStep);
    ScenarioRatingItemDao scenarioRatingItemDao = new ScenarioRatingItemDao(dsl);
    ChangeScenarioCommand command = mock(ChangeScenarioCommand.class);
    when(command.appId()).thenReturn(1L);
    when(command.columnId()).thenReturn(1L);
    when(command.rowId()).thenReturn(1L);
    when(command.scenarioId()).thenReturn(1L);

    // Act
    boolean actualRemoveResult = scenarioRatingItemDao.remove(command, "42");

    // Assert
    verify(command).appId();
    verify(command).columnId();
    verify(command).rowId();
    verify(command, atLeast(1)).scenarioId();
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).deleteFrom(isA(Table.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link ScenarioRatingItemDao#add(ChangeScenarioCommand, String)}
   */
  @Test
  void testAdd() throws DataAccessException {
    // Arrange
    InsertSetMoreStep<ScenarioRatingItemRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);
    InsertSetMoreStep<ScenarioRatingItemRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep);
    InsertSetMoreStep<ScenarioRatingItemRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep2);
    InsertSetMoreStep<ScenarioRatingItemRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep3);
    InsertSetMoreStep<ScenarioRatingItemRecord> insertSetMoreStep5 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep4);
    InsertSetMoreStep<ScenarioRatingItemRecord> insertSetMoreStep6 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep5);
    InsertSetMoreStep<ScenarioRatingItemRecord> insertSetMoreStep7 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep6);
    InsertSetMoreStep<ScenarioRatingItemRecord> insertSetMoreStep8 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep7);
    InsertSetMoreStep<ScenarioRatingItemRecord> insertSetMoreStep9 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep9.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep8);
    InsertSetMoreStep<ScenarioRatingItemRecord> insertSetMoreStep10 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep10.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep9);
    InsertSetMoreStep<ScenarioRatingItemRecord> insertSetMoreStep11 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep11.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep10);
    InsertSetStep<ScenarioRatingItemRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep11);
    UpdateConditionStep<ScenarioRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetFirstStep<ScenarioRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.update(Mockito.<Table<ScenarioRecord>>any())).thenReturn(updateSetFirstStep);
    when(dsl.insertInto(Mockito.<Table<ScenarioRatingItemRecord>>any())).thenReturn(insertSetStep);
    ScenarioRatingItemDao scenarioRatingItemDao = new ScenarioRatingItemDao(dsl);
    ChangeScenarioCommand command = mock(ChangeScenarioCommand.class);
    when(command.rating()).thenReturn("Rating");
    when(command.appId()).thenReturn(1L);
    when(command.columnId()).thenReturn(1L);
    when(command.rowId()).thenReturn(1L);
    when(command.scenarioId()).thenReturn(1L);

    // Act
    boolean actualAddResult = scenarioRatingItemDao.add(command, "42");

    // Assert
    verify(command).appId();
    verify(command).columnId();
    verify(command).rating();
    verify(command).rowId();
    verify(command, atLeast(1)).scenarioId();
    verify(dsl).insertInto(isA(Table.class));
    verify(dsl).update(isA(Table.class));
    verify(insertSetMoreStep11).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep10).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep9).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep8).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep7).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).execute();
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertTrue(actualAddResult);
  }

  /**
   * Method under test:
   * {@link ScenarioRatingItemDao#updateRating(ChangeScenarioCommand, String)}
   */
  @Test
  void testUpdateRating() throws DataAccessException {
    // Arrange
    UpdateConditionStep<ScenarioRatingItemRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<ScenarioRatingItemRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<ScenarioRatingItemRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateConditionStep<ScenarioRatingItemRecord> updateConditionStep2 = mock(UpdateConditionStep.class);
    when(updateConditionStep2.execute()).thenReturn(1);
    UpdateSetMoreStep<ScenarioRatingItemRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetMoreStep<ScenarioRatingItemRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    UpdateSetFirstStep<ScenarioRatingItemRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep4);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<ScenarioRatingItemRecord>>any())).thenReturn(updateSetFirstStep);
    ScenarioRatingItemDao scenarioRatingItemDao = new ScenarioRatingItemDao(dsl);
    ChangeScenarioCommand command = mock(ChangeScenarioCommand.class);
    when(command.comment()).thenReturn("Comment");
    when(command.rating()).thenReturn("Rating");
    when(command.appId()).thenReturn(1L);
    when(command.columnId()).thenReturn(1L);
    when(command.rowId()).thenReturn(1L);
    when(command.scenarioId()).thenReturn(1L);

    // Act
    boolean actualUpdateRatingResult = scenarioRatingItemDao.updateRating(command, "42");

    // Assert
    verify(command).appId();
    verify(command).columnId();
    verify(command).comment();
    verify(command).rating();
    verify(command).rowId();
    verify(command, atLeast(1)).scenarioId();
    verify(updateConditionStep2).execute();
    verify(updateConditionStep).execute();
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetFirstStep, atLeast(1)).set(Mockito.<Field<Object>>any(), Mockito.<Object>any());
    verify(updateSetMoreStep4, atLeast(1)).set(Mockito.<Field<Object>>any(), Mockito.<Object>any());
    verify(updateSetMoreStep3).where(isA(Condition.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl, atLeast(1)).update(Mockito.<Table<Record>>any());
    assertTrue(actualUpdateRatingResult);
  }

  /**
   * Method under test:
   * {@link ScenarioRatingItemDao#updateRating(ChangeScenarioCommand, String)}
   */
  @Test
  void testUpdateRating2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<ScenarioRatingItemRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(0);
    UpdateSetMoreStep<ScenarioRatingItemRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<ScenarioRatingItemRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateConditionStep<ScenarioRatingItemRecord> updateConditionStep2 = mock(UpdateConditionStep.class);
    when(updateConditionStep2.execute()).thenReturn(1);
    UpdateSetMoreStep<ScenarioRatingItemRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetMoreStep<ScenarioRatingItemRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    UpdateSetFirstStep<ScenarioRatingItemRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep4);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<ScenarioRatingItemRecord>>any())).thenReturn(updateSetFirstStep);
    ScenarioRatingItemDao scenarioRatingItemDao = new ScenarioRatingItemDao(dsl);
    ChangeScenarioCommand command = mock(ChangeScenarioCommand.class);
    when(command.comment()).thenReturn("Comment");
    when(command.rating()).thenReturn("Rating");
    when(command.appId()).thenReturn(1L);
    when(command.columnId()).thenReturn(1L);
    when(command.rowId()).thenReturn(1L);
    when(command.scenarioId()).thenReturn(1L);

    // Act
    boolean actualUpdateRatingResult = scenarioRatingItemDao.updateRating(command, "42");

    // Assert
    verify(command).appId();
    verify(command).columnId();
    verify(command).comment();
    verify(command).rating();
    verify(command).rowId();
    verify(command).scenarioId();
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertFalse(actualUpdateRatingResult);
  }
}
