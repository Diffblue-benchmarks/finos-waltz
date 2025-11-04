package org.finos.waltz.data.scenario;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.time.LocalDate;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.scenario.ScenarioType;
import org.finos.waltz.schema.tables.records.ScenarioRecord;
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

class ScenarioDaoDiffblueTest {
  /**
   * Method under test: {@link ScenarioDao#updateName(long, String, String)}
   */
  @Test
  void testUpdateName() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Boolean actualUpdateNameResult = (new ScenarioDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .updateName(1L, "42", "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"scenario\" set \"scenario\".\"name\" = ?, \"scenario\".\"last_updated_at\" = ?, \"scenario\".\"last_updated_by\" = ? where \"scenario\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("42"));
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateNameResult);
  }

  /**
   * Method under test:
   * {@link ScenarioDao#updateDescription(long, String, String)}
   */
  @Test
  void testUpdateDescription() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Boolean actualUpdateDescriptionResult = (new ScenarioDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .updateDescription(1L, "42", "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"scenario\" set \"scenario\".\"description\" = ?, \"scenario\".\"last_updated_at\" = ?, \"scenario\".\"last_updated_by\" = ? where \"scenario\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("42"));
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateDescriptionResult);
  }

  /**
   * Method under test:
   * {@link ScenarioDao#updateEffectiveDate(long, LocalDate, String)}
   */
  @Test
  void testUpdateEffectiveDate() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    ScenarioDao scenarioDao = new ScenarioDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Boolean actualUpdateEffectiveDateResult = scenarioDao.updateEffectiveDate(1L, LocalDate.of(1970, 1, 1), "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"scenario\" set \"scenario\".\"effective_date\" = ?, \"scenario\".\"last_updated_at\" = ?, \"scenario\".\"last_updated_by\" = ? where \"scenario\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setDate(eq(1), isA(Date.class));
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement).setString(eq(3), eq("42"));
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateEffectiveDateResult);
  }

  /**
   * Method under test:
   * {@link ScenarioDao#updateEffectiveDate(long, LocalDate, String)}
   */
  @Test
  void testUpdateEffectiveDate2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<ScenarioRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<ScenarioRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<ScenarioRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    Boolean actualUpdateEffectiveDateResult = (new ScenarioDao(dsl)).updateEffectiveDate(1L, null, "42");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualUpdateEffectiveDateResult);
  }

  /**
   * Method under test:
   * {@link ScenarioDao#updateEntityLifecycleStatus(long, EntityLifecycleStatus, String)}
   */
  @Test
  void testUpdateEntityLifecycleStatus() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Boolean actualUpdateEntityLifecycleStatusResult = (new ScenarioDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).updateEntityLifecycleStatus(1L,
            EntityLifecycleStatus.ACTIVE, "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"scenario\" set \"scenario\".\"lifecycle_status\" = ?, \"scenario\".\"last_updated_at\" = ?, \"scenario\".\"last_updated_by\" = ? where \"scenario\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateEntityLifecycleStatusResult);
  }

  /**
   * Method under test:
   * {@link ScenarioDao#updateScenarioType(long, ScenarioType, String)}
   */
  @Test
  void testUpdateScenarioType() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Boolean actualUpdateScenarioTypeResult = (new ScenarioDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .updateScenarioType(1L, ScenarioType.TARGET, "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"scenario\" set \"scenario\".\"scenario_type\" = ?, \"scenario\".\"last_updated_at\" = ?, \"scenario\".\"last_updated_by\" = ? where \"scenario\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateScenarioTypeResult);
  }
}
