package org.finos.waltz.data.involvement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.involvement.Involvement;
import org.finos.waltz.schema.tables.records.InvolvementRecord;
import org.jooq.Batch;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Query;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class InvolvementDaoDiffblueTest {
  /**
   * Method under test:
   * {@link InvolvementDao#countOrphanInvolvementsForKind(EntityKind)}
   */
  @Test
  void testCountOrphanInvolvementsForKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new InvolvementDao(new DefaultDSLContext(SQLDialect.SQL99)))
            .countOrphanInvolvementsForKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link InvolvementDao#cleanupInvolvementsForKind(EntityKind)}
   */
  @Test
  void testCleanupInvolvementsForKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new InvolvementDao(new DefaultDSLContext(SQLDialect.SQL99))).cleanupInvolvementsForKind(EntityKind.ALL));
    assertThrows(UnsupportedOperationException.class,
        () -> (new InvolvementDao(new DefaultDSLContext(SQLDialect.DEFAULT)))
            .cleanupInvolvementsForKind(EntityKind.ALL));
  }

  /**
   * Method under test: {@link InvolvementDao#bulkStoreInvolvements(Set)}
   */
  @Test
  void testBulkStoreInvolvements() {
    // Arrange
    InvolvementDao involvementDao = new InvolvementDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, involvementDao.bulkStoreInvolvements(new HashSet<>()));
  }

  /**
   * Method under test: {@link InvolvementDao#bulkStoreInvolvements(Set)}
   */
  @Test
  void testBulkStoreInvolvements2() {
    // Arrange
    InvolvementDao involvementDao = new InvolvementDao(new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, involvementDao.bulkStoreInvolvements(new HashSet<>()));
  }

  /**
   * Method under test: {@link InvolvementDao#bulkStoreInvolvements(Set)}
   */
  @Test
  void testBulkStoreInvolvements3() {
    // Arrange
    InvolvementDao involvementDao = new InvolvementDao(mock(DefaultDSLContext.class));
    Involvement involvement = mock(Involvement.class);
    when(involvement.entityReference()).thenThrow(new UnsupportedOperationException("foo"));

    HashSet<Involvement> involvements = new HashSet<>();
    involvements.add(involvement);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> involvementDao.bulkStoreInvolvements(involvements));
    verify(involvement).entityReference();
  }

  /**
   * Method under test: {@link InvolvementDao#bulkStoreInvolvements(Set)}
   */
  @Test
  void testBulkStoreInvolvements4() {
    // Arrange
    InvolvementDao involvementDao = new InvolvementDao(mock(DefaultDSLContext.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenThrow(new UnsupportedOperationException("foo"));
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Involvement involvement = mock(Involvement.class);
    when(involvement.entityReference()).thenReturn(entityReference);

    HashSet<Involvement> involvements = new HashSet<>();
    involvements.add(involvement);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> involvementDao.bulkStoreInvolvements(involvements));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(involvement, atLeast(1)).entityReference();
  }

  /**
   * Method under test: {@link InvolvementDao#bulkDeleteInvolvements(Set)}
   */
  @Test
  void testBulkDeleteInvolvements() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    InvolvementDao involvementDao = new InvolvementDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualBulkDeleteInvolvementsResult = involvementDao.bulkDeleteInvolvements(new HashSet<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertEquals(0, actualBulkDeleteInvolvementsResult);
  }

  /**
   * Method under test: {@link InvolvementDao#bulkDeleteInvolvements(Set)}
   */
  @Test
  void testBulkDeleteInvolvements2() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    InvolvementDao involvementDao = new InvolvementDao(dsl);

    // Act
    int actualBulkDeleteInvolvementsResult = involvementDao.bulkDeleteInvolvements(new HashSet<>());

    // Assert
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    assertEquals(0, actualBulkDeleteInvolvementsResult);
  }

  /**
   * Method under test: {@link InvolvementDao#bulkDeleteInvolvements(Set)}
   */
  @Test
  void testBulkDeleteInvolvements3() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<InvolvementRecord>>any())).thenReturn(mock(DeleteUsingStep.class));
    InvolvementDao involvementDao = new InvolvementDao(dsl);
    Involvement involvement = mock(Involvement.class);
    when(involvement.entityReference()).thenThrow(new UnsupportedOperationException("foo"));

    HashSet<Involvement> involvements = new HashSet<>();
    involvements.add(involvement);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> involvementDao.bulkDeleteInvolvements(involvements));
    verify(involvement).entityReference();
    verify(dsl).deleteFrom(isA(Table.class));
  }

  /**
   * Method under test: {@link InvolvementDao#bulkDeleteInvolvements(Set)}
   */
  @Test
  void testBulkDeleteInvolvements4() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DeleteUsingStep<InvolvementRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(mock(DeleteConditionStep.class));
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<InvolvementRecord>>any())).thenReturn(deleteUsingStep);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    InvolvementDao involvementDao = new InvolvementDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Involvement involvement = mock(Involvement.class);
    when(involvement.employeeId()).thenReturn("42");
    when(involvement.kindId()).thenReturn(1L);
    when(involvement.entityReference()).thenReturn(entityReference);

    HashSet<Involvement> involvements = new HashSet<>();
    involvements.add(involvement);

    // Act
    int actualBulkDeleteInvolvementsResult = involvementDao.bulkDeleteInvolvements(involvements);

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(involvement).employeeId();
    verify(involvement, atLeast(1)).entityReference();
    verify(involvement).kindId();
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    verify(dsl).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    assertEquals(0, actualBulkDeleteInvolvementsResult);
  }

  /**
   * Method under test: {@link InvolvementDao#bulkDeleteInvolvements(Set)}
   */
  @Test
  void testBulkDeleteInvolvements5() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<InvolvementRecord>>any())).thenReturn(mock(DeleteUsingStep.class));
    InvolvementDao involvementDao = new InvolvementDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenThrow(new UnsupportedOperationException("foo"));
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Involvement involvement = mock(Involvement.class);
    when(involvement.entityReference()).thenReturn(entityReference);

    HashSet<Involvement> involvements = new HashSet<>();
    involvements.add(involvement);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> involvementDao.bulkDeleteInvolvements(involvements));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(involvement, atLeast(1)).entityReference();
    verify(dsl).deleteFrom(isA(Table.class));
  }
}
