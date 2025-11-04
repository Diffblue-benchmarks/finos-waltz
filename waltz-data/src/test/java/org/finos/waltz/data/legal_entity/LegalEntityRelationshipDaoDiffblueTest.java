package org.finos.waltz.data.legal_entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.legal_entity.LegalEntityRelationship;
import org.finos.waltz.schema.tables.records.LegalEntityRelationshipRecord;
import org.jooq.Batch;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Query;
import org.jooq.QueryPart;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LegalEntityRelationshipDaoDiffblueTest {
  /**
   * Method under test: {@link LegalEntityRelationshipDao#getById(Long)}
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    LegalEntityRelationship actualById = (new LegalEntityRelationshipDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"legal_entity_relationship\".\"id\", \"legal_entity_relationship\".\"legal_entity_id\", \"legal_entity_relationship\".\"relationship_kind_id\", \"legal_entity_relationship\".\"target_kind\", \"legal_entity_relationship\".\"target_id\", \"legal_entity_relationship\".\"description\", \"legal_entity_relationship\".\"external_id\", \"legal_entity_relationship\".\"last_updated_at\", \"legal_entity_relationship\".\"last_updated_by\", \"legal_entity_relationship\".\"provenance\", \"legal_entity_relationship\".\"is_readonly\", \"legal_entity\".\"name\", \"legal_entity\".\"external_id\", case when \"legal_entity_relationship\".\"target_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"legal_entity_relationship\".\"target_id\") end \"entity_name\", case when \"legal_entity_relationship\".\"target_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"legal_entity_relationship\".\"target_id\") end \"entity_ext_id\" from \"legal_entity_relationship\" join \"legal_entity\" on \"legal_entity_relationship\".\"legal_entity_id\" = \"legal_entity\".\"id\" where \"legal_entity_relationship\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("APPLICATION"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualById);
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipDao#findByLegalEntityId(Long)}
   */
  @Test
  void testFindByLegalEntityId() throws SQLException {
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
    Set<LegalEntityRelationship> actualFindByLegalEntityIdResult = (new LegalEntityRelationshipDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByLegalEntityId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"legal_entity_relationship\".\"id\", \"legal_entity_relationship\".\"legal_entity_id\", \"legal_entity_relationship\".\"relationship_kind_id\", \"legal_entity_relationship\".\"target_kind\", \"legal_entity_relationship\".\"target_id\", \"legal_entity_relationship\".\"description\", \"legal_entity_relationship\".\"external_id\", \"legal_entity_relationship\".\"last_updated_at\", \"legal_entity_relationship\".\"last_updated_by\", \"legal_entity_relationship\".\"provenance\", \"legal_entity_relationship\".\"is_readonly\", \"legal_entity\".\"name\", \"legal_entity\".\"external_id\", case when \"legal_entity_relationship\".\"target_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"legal_entity_relationship\".\"target_id\") end \"entity_name\", case when \"legal_entity_relationship\".\"target_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"legal_entity_relationship\".\"target_id\") end \"entity_ext_id\" from \"legal_entity_relationship\" join \"legal_entity\" on \"legal_entity_relationship\".\"legal_entity_id\" = \"legal_entity\".\"id\" where (\"legal_entity_relationship\".\"legal_entity_id\" = 1)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("APPLICATION"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByLegalEntityIdResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipDao#findByRelationshipKind(DSLContext, long)}
   */
  @Test
  void testFindByRelationshipKind() throws SQLException {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    LegalEntityRelationshipDao legalEntityRelationshipDao = new LegalEntityRelationshipDao(dsl);
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
    Set<LegalEntityRelationship> actualFindByRelationshipKindResult = legalEntityRelationshipDao
        .findByRelationshipKind(new DefaultDSLContext(connection, SQLDialect.SQL99), 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"legal_entity_relationship\".\"id\", \"legal_entity_relationship\".\"legal_entity_id\", \"legal_entity_relationship\".\"relationship_kind_id\", \"legal_entity_relationship\".\"target_kind\", \"legal_entity_relationship\".\"target_id\", \"legal_entity_relationship\".\"description\", \"legal_entity_relationship\".\"external_id\", \"legal_entity_relationship\".\"last_updated_at\", \"legal_entity_relationship\".\"last_updated_by\", \"legal_entity_relationship\".\"provenance\", \"legal_entity_relationship\".\"is_readonly\", \"legal_entity\".\"name\", \"legal_entity\".\"external_id\", case when \"legal_entity_relationship\".\"target_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"legal_entity_relationship\".\"target_id\") end \"entity_name\", case when \"legal_entity_relationship\".\"target_kind\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"legal_entity_relationship\".\"target_id\") end \"entity_ext_id\" from \"legal_entity_relationship\" join \"legal_entity\" on \"legal_entity_relationship\".\"legal_entity_id\" = \"legal_entity\".\"id\" where (Render Inlined)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("APPLICATION"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(dsl).renderInlined(isA(QueryPart.class));
    assertTrue(actualFindByRelationshipKindResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipDao#bulkAdd(DSLContext, Set)}
   */
  @Test
  void testBulkAdd() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = new LegalEntityRelationshipDao(
        new DefaultDSLContext(SQLDialect.SQL99));
    DefaultDSLContext tx = new DefaultDSLContext(SQLDialect.SQL99);

    // Act and Assert
    assertEquals(0, legalEntityRelationshipDao.bulkAdd(tx, new HashSet<>()));
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipDao#bulkAdd(DSLContext, Set)}
   */
  @Test
  void testBulkAdd2() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = new LegalEntityRelationshipDao(
        new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99));
    DefaultDSLContext tx = new DefaultDSLContext(SQLDialect.SQL99);

    // Act and Assert
    assertEquals(0, legalEntityRelationshipDao.bulkAdd(tx, new HashSet<>()));
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipDao#bulkUpdate(DSLContext, Set)}
   */
  @Test
  void testBulkUpdate() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = new LegalEntityRelationshipDao(
        new DefaultDSLContext(SQLDialect.SQL99));
    DefaultDSLContext tx = new DefaultDSLContext(SQLDialect.SQL99);

    // Act and Assert
    assertEquals(0, legalEntityRelationshipDao.bulkUpdate(tx, new HashSet<>()));
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipDao#bulkUpdate(DSLContext, Set)}
   */
  @Test
  void testBulkUpdate2() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = new LegalEntityRelationshipDao(
        new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99));
    DefaultDSLContext tx = new DefaultDSLContext(SQLDialect.SQL99);

    // Act and Assert
    assertEquals(0, legalEntityRelationshipDao.bulkUpdate(tx, new HashSet<>()));
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipDao#bulkRemove(DSLContext, Set)}
   */
  @Test
  void testBulkRemove() throws SQLException {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = new LegalEntityRelationshipDao(
        new DefaultDSLContext(SQLDialect.SQL99));
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualBulkRemoveResult = legalEntityRelationshipDao.bulkRemove(tx, new HashSet<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertEquals(0, actualBulkRemoveResult);
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipDao#bulkRemove(DSLContext, Set)}
   */
  @Test
  void testBulkRemove2() throws DataAccessException {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = new LegalEntityRelationshipDao(
        new DefaultDSLContext(SQLDialect.SQL99));
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DSLContext tx = mock(DSLContext.class);
    when(tx.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    // Act
    int actualBulkRemoveResult = legalEntityRelationshipDao.bulkRemove(tx, new HashSet<>());

    // Assert
    verify(batch).execute();
    verify(tx).batch(isA(Collection.class));
    assertEquals(0, actualBulkRemoveResult);
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipDao#bulkRemove(DSLContext, Set)}
   */
  @Test
  void testBulkRemove3() throws DataAccessException {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = new LegalEntityRelationshipDao(
        new DefaultDSLContext(SQLDialect.SQL99));
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DeleteUsingStep<LegalEntityRelationshipRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(mock(DeleteConditionStep.class));
    DSLContext tx = mock(DSLContext.class);
    when(tx.deleteFrom(Mockito.<Table<LegalEntityRelationshipRecord>>any())).thenReturn(deleteUsingStep);
    when(tx.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    LegalEntityRelationship legalEntityRelationship = mock(LegalEntityRelationship.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(legalEntityRelationship.id()).thenReturn(ofResult);

    HashSet<LegalEntityRelationship> relationships = new HashSet<>();
    relationships.add(legalEntityRelationship);

    // Act
    int actualBulkRemoveResult = legalEntityRelationshipDao.bulkRemove(tx, relationships);

    // Assert
    verify(legalEntityRelationship).id();
    verify(batch).execute();
    verify(tx).batch(isA(Collection.class));
    verify(tx).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    assertEquals(0, actualBulkRemoveResult);
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipDao#bulkRemove(DSLContext, Set)}
   */
  @Test
  void testBulkRemove4() throws DataAccessException {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = new LegalEntityRelationshipDao(
        new DefaultDSLContext(SQLDialect.SQL99));
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DeleteUsingStep<LegalEntityRelationshipRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(mock(DeleteConditionStep.class));
    DSLContext tx = mock(DSLContext.class);
    when(tx.deleteFrom(Mockito.<Table<LegalEntityRelationshipRecord>>any())).thenReturn(deleteUsingStep);
    when(tx.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    LegalEntityRelationship legalEntityRelationship = mock(LegalEntityRelationship.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(legalEntityRelationship.id()).thenReturn(ofResult);
    LegalEntityRelationship legalEntityRelationship2 = mock(LegalEntityRelationship.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(legalEntityRelationship2.id()).thenReturn(ofResult2);

    HashSet<LegalEntityRelationship> relationships = new HashSet<>();
    relationships.add(legalEntityRelationship2);
    relationships.add(legalEntityRelationship);

    // Act
    int actualBulkRemoveResult = legalEntityRelationshipDao.bulkRemove(tx, relationships);

    // Assert
    verify(legalEntityRelationship2).id();
    verify(legalEntityRelationship).id();
    verify(batch).execute();
    verify(tx).batch(isA(Collection.class));
    verify(tx, atLeast(1)).deleteFrom(isA(Table.class));
    verify(deleteUsingStep, atLeast(1)).where(isA(Condition.class));
    assertEquals(0, actualBulkRemoveResult);
  }
}
