package org.finos.waltz.data.physical_specification_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.util.List;
import org.finos.waltz.model.physical_specification_definition.PhysicalSpecDefinitionField;
import org.finos.waltz.schema.tables.records.PhysicalSpecDefnFieldRecord;
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

class PhysicalSpecDefinitionFieldDaoDiffblueTest {
  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionFieldDao#findForSpecDefinition(long)}
   */
  @Test
  void testFindForSpecDefinition() throws SQLException {
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
    List<PhysicalSpecDefinitionField> actualFindForSpecDefinitionResult = (new PhysicalSpecDefinitionFieldDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findForSpecDefinition(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"physical_spec_defn_field\".\"id\", \"physical_spec_defn_field\".\"spec_defn_id\", \"physical_spec_defn_field\".\"name\", \"physical_spec_defn_field\".\"position\", \"physical_spec_defn_field\".\"type\", \"physical_spec_defn_field\".\"description\", \"physical_spec_defn_field\".\"last_updated_at\", \"physical_spec_defn_field\".\"last_updated_by\", \"physical_spec_defn_field\".\"logical_data_element_id\" from \"physical_spec_defn_field\" where \"physical_spec_defn_field\".\"spec_defn_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindForSpecDefinitionResult.isEmpty());
  }

  /**
   * Method under test: {@link PhysicalSpecDefinitionFieldDao#delete(long)}
   */
  @Test
  void testDelete() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualDeleteResult = (new PhysicalSpecDefinitionFieldDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .delete(1L);

    // Assert
    verify(connection)
        .prepareStatement(eq("delete from \"physical_spec_defn_field\" where \"physical_spec_defn_field\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionFieldDao#deleteForSpecDefinition(long)}
   */
  @Test
  void testDeleteForSpecDefinition() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualDeleteForSpecDefinitionResult = (new PhysicalSpecDefinitionFieldDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).deleteForSpecDefinition(1L);

    // Assert
    verify(connection).prepareStatement(
        eq("delete from \"physical_spec_defn_field\" where \"physical_spec_defn_field\".\"spec_defn_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForSpecDefinitionResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionFieldDao#updateDescription(long, String)}
   */
  @Test
  void testUpdateDescription() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualUpdateDescriptionResult = (new PhysicalSpecDefinitionFieldDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).updateDescription(1L,
            "The characteristics of someone or something");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"physical_spec_defn_field\" set \"physical_spec_defn_field\".\"description\" = ? where \"physical_spec_defn_field\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("The characteristics of someone or something"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateDescriptionResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionFieldDao#updateLogicalDataElement(long, Long)}
   */
  @Test
  void testUpdateLogicalDataElement() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualUpdateLogicalDataElementResult = (new PhysicalSpecDefinitionFieldDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).updateLogicalDataElement(1L, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"physical_spec_defn_field\" set \"physical_spec_defn_field\".\"logical_data_element_id\" = ? where \"physical_spec_defn_field\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateLogicalDataElementResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionFieldDao#updateLogicalDataElement(long, Long)}
   */
  @Test
  void testUpdateLogicalDataElement2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalSpecDefnFieldRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);
    UpdateSetMoreStep<PhysicalSpecDefnFieldRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<PhysicalSpecDefnFieldRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalSpecDefnFieldRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateLogicalDataElementResult = (new PhysicalSpecDefinitionFieldDao(dsl)).updateLogicalDataElement(2L,
        1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateLogicalDataElementResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionFieldDao#updateLogicalDataElement(long, Long)}
   */
  @Test
  void testUpdateLogicalDataElement3() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalSpecDefnFieldRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);
    UpdateSetMoreStep<PhysicalSpecDefnFieldRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<PhysicalSpecDefnFieldRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalSpecDefnFieldRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateLogicalDataElementResult = (new PhysicalSpecDefinitionFieldDao(dsl)).updateLogicalDataElement(3L,
        1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateLogicalDataElementResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionFieldDao#updateLogicalDataElement(long, Long)}
   */
  @Test
  void testUpdateLogicalDataElement4() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalSpecDefnFieldRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);
    UpdateSetMoreStep<PhysicalSpecDefnFieldRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<PhysicalSpecDefnFieldRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalSpecDefnFieldRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateLogicalDataElementResult = (new PhysicalSpecDefinitionFieldDao(dsl)).updateLogicalDataElement(4L,
        1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateLogicalDataElementResult);
  }
}
