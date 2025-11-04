package org.finos.waltz.data.entity_statistic;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.entity_statistic.EntityStatisticValue;
import org.finos.waltz.model.entity_statistic.StatisticValueState;
import org.jooq.Batch;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.InsertValuesStep10;
import org.jooq.Query;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityStatisticValueDaoDiffblueTest {
  /**
   * Method under test: {@link EntityStatisticValueDao#bulkSaveValues(List)}
   */
  @Test
  void testBulkSaveValues() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    EntityStatisticValueDao entityStatisticValueDao = new EntityStatisticValueDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int[] actualBulkSaveValuesResult = entityStatisticValueDao.bulkSaveValues(new ArrayList<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualBulkSaveValuesResult);
  }

  /**
   * Method under test: {@link EntityStatisticValueDao#bulkSaveValues(List)}
   */
  @Test
  void testBulkSaveValues2() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    EntityStatisticValueDao entityStatisticValueDao = new EntityStatisticValueDao(dsl);

    // Act
    int[] actualBulkSaveValuesResult = entityStatisticValueDao.bulkSaveValues(new ArrayList<>());

    // Assert
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualBulkSaveValuesResult);
  }

  /**
   * Method under test: {@link EntityStatisticValueDao#bulkSaveValues(List)}
   */
  @Test
  void testBulkSaveValues3() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    InsertValuesStep10<Record, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object> insertValuesStep10 = mock(
        InsertValuesStep10.class);
    when(insertValuesStep10.values(Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Object>any(),
        Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Object>any(),
        Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Object>any()))
            .thenReturn(mock(InsertValuesStep10.class));
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<Record>>any(), Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(),
        Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(),
        Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(),
        Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any())).thenReturn(insertValuesStep10);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    EntityStatisticValueDao entityStatisticValueDao = new EntityStatisticValueDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    EntityStatisticValue entityStatisticValue = mock(EntityStatisticValue.class);
    when(entityStatisticValue.current()).thenReturn(true);
    when(entityStatisticValue.provenance()).thenReturn("Provenance");
    when(entityStatisticValue.reason()).thenReturn("Just cause");
    when(entityStatisticValue.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(entityStatisticValue.outcome()).thenReturn("Outcome");
    when(entityStatisticValue.value()).thenReturn("42");
    when(entityStatisticValue.state()).thenReturn(StatisticValueState.EXEMPT);
    when(entityStatisticValue.statisticId()).thenReturn(1L);
    when(entityStatisticValue.entity()).thenReturn(entityReference);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    EntityStatisticValue entityStatisticValue2 = mock(EntityStatisticValue.class);
    when(entityStatisticValue2.current()).thenReturn(true);
    when(entityStatisticValue2.provenance()).thenReturn("Provenance");
    when(entityStatisticValue2.reason()).thenReturn("Just cause");
    when(entityStatisticValue2.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(entityStatisticValue2.outcome()).thenReturn("Outcome");
    when(entityStatisticValue2.value()).thenReturn("42");
    when(entityStatisticValue2.state()).thenReturn(StatisticValueState.EXEMPT);
    when(entityStatisticValue2.statisticId()).thenReturn(1L);
    when(entityStatisticValue2.entity()).thenReturn(entityReference2);

    ArrayList<EntityStatisticValue> values = new ArrayList<>();
    values.add(entityStatisticValue2);
    values.add(entityStatisticValue);

    // Act
    int[] actualBulkSaveValuesResult = entityStatisticValueDao.bulkSaveValues(values);

    // Assert
    verify(entityReference2).id();
    verify(entityReference).id();
    verify(entityReference2).kind();
    verify(entityReference).kind();
    verify(entityStatisticValue2).provenance();
    verify(entityStatisticValue).provenance();
    verify(entityStatisticValue2).createdAt();
    verify(entityStatisticValue).createdAt();
    verify(entityStatisticValue2).current();
    verify(entityStatisticValue).current();
    verify(entityStatisticValue2, atLeast(1)).entity();
    verify(entityStatisticValue, atLeast(1)).entity();
    verify(entityStatisticValue2).outcome();
    verify(entityStatisticValue).outcome();
    verify(entityStatisticValue2).reason();
    verify(entityStatisticValue).reason();
    verify(entityStatisticValue2).state();
    verify(entityStatisticValue).state();
    verify(entityStatisticValue2).statisticId();
    verify(entityStatisticValue).statisticId();
    verify(entityStatisticValue2).value();
    verify(entityStatisticValue).value();
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    verify(dsl, atLeast(1)).insertInto(isA(Table.class), isA(Field.class), isA(Field.class), isA(Field.class),
        isA(Field.class), isA(Field.class), isA(Field.class), isA(Field.class), isA(Field.class), isA(Field.class),
        isA(Field.class));
    verify(insertValuesStep10, atLeast(1)).values(isA(Object.class), isA(Object.class), isA(Object.class),
        isA(Object.class), isA(Object.class), isA(Object.class), isA(Object.class), isA(Object.class),
        isA(Object.class), isA(Object.class));
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualBulkSaveValuesResult);
  }
}
