package org.finos.waltz.data.end_user_app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
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
import java.util.List;
import org.finos.waltz.model.enduserapp.EndUserApplication;
import org.finos.waltz.model.tally.ImmutableTally;
import org.finos.waltz.model.tally.Tally;
import org.finos.waltz.schema.tables.records.EndUserApplicationRecord;
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

class EndUserAppDaoDiffblueTest {
  /**
   * Method under test: {@link EndUserAppDao#countByOrganisationalUnit()}
   */
  @Test
  void testCountByOrganisationalUnit() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
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
    List<Tally<Long>> actualCountByOrganisationalUnitResult = (new EndUserAppDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).countByOrganisationalUnit();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"end_user_application\".\"organisational_unit_id\", count(\"end_user_application\".\"organisational_unit_id\") \"count\" from \"end_user_application\" where ((\"end_user_application\".\"is_promoted\" = false and \"end_user_application\".\"lifecycle_phase\" in ('PRODUCTION', 'DEVELOPMENT'))) group by \"end_user_application\".\"organisational_unit_id\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(2));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualCountByOrganisationalUnitResult.size());
    Tally<Long> getResult = actualCountByOrganisationalUnitResult.get(0);
    assertTrue(getResult instanceof ImmutableTally);
    Tally<Long> getResult2 = actualCountByOrganisationalUnitResult.get(1);
    assertTrue(getResult2 instanceof ImmutableTally);
    assertEquals(1.0d, getResult.count());
    assertEquals(1L, getResult.id().longValue());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link EndUserAppDao#updateIsPromotedFlag(long)}
   */
  @Test
  void testUpdateIsPromotedFlag() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualUpdateIsPromotedFlagResult = (new EndUserAppDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .updateIsPromotedFlag(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"end_user_application\" set \"end_user_application\".\"is_promoted\" = ? where \"end_user_application\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(true));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateIsPromotedFlagResult);
  }

  /**
   * Method under test: {@link EndUserAppDao#updateIsPromotedFlag(long)}
   */
  @Test
  void testUpdateIsPromotedFlag2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<EndUserApplicationRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<EndUserApplicationRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<EndUserApplicationRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<EndUserApplicationRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateIsPromotedFlagResult = (new EndUserAppDao(dsl)).updateIsPromotedFlag(1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateIsPromotedFlagResult);
  }

  /**
   * Method under test: {@link EndUserAppDao#getById(Long)}
   */
  @Test
  void testGetById() throws SQLException {
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
    EndUserApplication actualById = (new EndUserAppDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"end_user_application\".\"id\", \"end_user_application\".\"name\", \"end_user_application\".\"description\", \"end_user_application\".\"kind\", \"end_user_application\".\"lifecycle_phase\", \"end_user_application\".\"risk_rating\", \"end_user_application\".\"organisational_unit_id\", \"end_user_application\".\"provenance\", \"end_user_application\".\"external_id\", \"end_user_application\".\"is_promoted\" from \"end_user_application\" where \"end_user_application\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualById);
  }

  /**
   * Method under test: {@link EndUserAppDao#findAll()}
   */
  @Test
  void testFindAll() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<EndUserApplication> actualFindAllResult = (new EndUserAppDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"end_user_application\".\"id\", \"end_user_application\".\"name\", \"end_user_application\".\"description\", \"end_user_application\".\"kind\", \"end_user_application\".\"lifecycle_phase\", \"end_user_application\".\"risk_rating\", \"end_user_application\".\"organisational_unit_id\", \"end_user_application\".\"provenance\", \"end_user_application\".\"external_id\", \"end_user_application\".\"is_promoted\" from \"end_user_application\" where (\"end_user_application\".\"is_promoted\" = false and \"end_user_application\".\"lifecycle_phase\" in (?, ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindAllResult.isEmpty());
  }
}
