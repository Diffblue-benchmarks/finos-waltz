package org.finos.waltz.data.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.assessment_rating.RemoveAssessmentRatingCommand;
import org.finos.waltz.model.assessment_rating.UpdateRatingCommand;
import org.finos.waltz.schema.tables.records.AssessmentRatingRecord;
import org.jooq.Batch;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.Query;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.exception.MappingException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AssessmentRatingDaoDiffblueTest {
  /**
   * Method under test: {@link AssessmentRatingDao#findForEntity(EntityReference)}
   */
  @Test
  void testFindForEntity() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(new DefaultDSLContext(SQLDialect.SQL99));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenThrow(new MappingException("An error occurred"));
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.findForEntity(ref));
    verify(ref).id();
    verify(ref).kind();
  }

  /**
   * Method under test: {@link AssessmentRatingDao#findForEntity(EntityReference)}
   */
  @Test
  void testFindForEntity2() throws SQLException {
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
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    List<AssessmentRating> actualFindForEntityResult = assessmentRatingDao.findForEntity(ref);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"assessment_rating\".\"entity_id\", \"assessment_rating\".\"entity_kind\", \"assessment_rating\".\"assessment_definition_id\", \"assessment_rating\".\"rating_id\", \"assessment_rating\".\"description\", \"assessment_rating\".\"last_updated_at\", \"assessment_rating\".\"last_updated_by\", \"assessment_rating\".\"provenance\", \"assessment_rating\".\"is_readonly\", \"assessment_rating\".\"id\" from \"assessment_rating\" where (\"assessment_rating\".\"entity_kind\" = ? and \"assessment_rating\".\"entity_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("ALL"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(ref).id();
    verify(ref).kind();
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Method under test: {@link AssessmentRatingDao#getById(long)}
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
    AssessmentRating actualById = (new AssessmentRatingDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"assessment_rating\".\"entity_id\", \"assessment_rating\".\"entity_kind\", \"assessment_rating\".\"assessment_definition_id\", \"assessment_rating\".\"rating_id\", \"assessment_rating\".\"description\", \"assessment_rating\".\"last_updated_at\", \"assessment_rating\".\"last_updated_by\", \"assessment_rating\".\"provenance\", \"assessment_rating\".\"is_readonly\", \"assessment_rating\".\"id\" from \"assessment_rating\" where \"assessment_rating\".\"id\" = ?"));
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
   * Method under test: {@link AssessmentRatingDao#bulkRemove(Set)}
   */
  @Test
  void testBulkRemove() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualBulkRemoveResult = assessmentRatingDao.bulkRemove(new HashSet<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertEquals(4, actualBulkRemoveResult);
  }

  /**
   * Method under test: {@link AssessmentRatingDao#bulkRemove(Set)}
   */
  @Test
  void testBulkRemove2() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);

    // Act
    int actualBulkRemoveResult = assessmentRatingDao.bulkRemove(new HashSet<>());

    // Assert
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    assertEquals(4, actualBulkRemoveResult);
  }

  /**
   * Method under test: {@link AssessmentRatingDao#bulkRemove(Set)}
   */
  @Test
  void testBulkRemove3() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(mock(DeleteUsingStep.class));
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);
    AssessmentRating assessmentRating = mock(AssessmentRating.class);
    when(assessmentRating.assessmentDefinitionId()).thenThrow(new MappingException("An error occurred"));

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();
    assessmentRatings.add(assessmentRating);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.bulkRemove(assessmentRatings));
    verify(assessmentRating).assessmentDefinitionId();
    verify(dsl).deleteFrom(isA(Table.class));
  }

  /**
   * Method under test: {@link AssessmentRatingDao#bulkRemove(Set)}
   */
  @Test
  void testBulkRemove4() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DeleteUsingStep<AssessmentRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(mock(DeleteConditionStep.class));
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(deleteUsingStep);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    AssessmentRating assessmentRating = mock(AssessmentRating.class);
    when(assessmentRating.ratingId()).thenReturn(1L);
    when(assessmentRating.assessmentDefinitionId()).thenReturn(1L);
    when(assessmentRating.entityReference()).thenReturn(entityReference);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    AssessmentRating assessmentRating2 = mock(AssessmentRating.class);
    when(assessmentRating2.ratingId()).thenReturn(1L);
    when(assessmentRating2.assessmentDefinitionId()).thenReturn(1L);
    when(assessmentRating2.entityReference()).thenReturn(entityReference2);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();
    assessmentRatings.add(assessmentRating2);
    assessmentRatings.add(assessmentRating);

    // Act
    int actualBulkRemoveResult = assessmentRatingDao.bulkRemove(assessmentRatings);

    // Assert
    verify(entityReference2).id();
    verify(entityReference).id();
    verify(entityReference2).kind();
    verify(entityReference).kind();
    verify(assessmentRating2).assessmentDefinitionId();
    verify(assessmentRating).assessmentDefinitionId();
    verify(assessmentRating2, atLeast(1)).entityReference();
    verify(assessmentRating, atLeast(1)).entityReference();
    verify(assessmentRating2).ratingId();
    verify(assessmentRating).ratingId();
    verify(batch).execute();
    verify(deleteUsingStep, atLeast(1)).where(isA(Condition.class));
    verify(dsl).batch(isA(Collection.class));
    verify(dsl, atLeast(1)).deleteFrom(isA(Table.class));
    assertEquals(4, actualBulkRemoveResult);
  }

  /**
   * Method under test: {@link AssessmentRatingDao#bulkRemove(Set)}
   */
  @Test
  void testBulkRemove5() {
    // Arrange
    DeleteUsingStep<AssessmentRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(mock(DeleteConditionStep.class));
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(deleteUsingStep);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();
    AssessmentRating assessmentRating = mock(AssessmentRating.class);
    when(assessmentRating.ratingId()).thenReturn(1L);
    when(assessmentRating.assessmentDefinitionId()).thenReturn(1L);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    when(assessmentRating.entityReference()).thenReturn(entityReference);
    assessmentRatings.add(assessmentRating);
    AssessmentRating assessmentRating2 = mock(AssessmentRating.class);
    when(assessmentRating2.ratingId()).thenReturn(1L);
    when(assessmentRating2.assessmentDefinitionId()).thenReturn(1L);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenThrow(new MappingException("An error occurred"));
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    when(assessmentRating2.entityReference()).thenReturn(entityReference2);
    assessmentRatings.add(assessmentRating2);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.bulkRemove(assessmentRatings));
    verify(entityReference).id();
    verify(entityReference2).id();
    verify(entityReference).kind();
    verify(entityReference2).kind();
    verify(assessmentRating).assessmentDefinitionId();
    verify(assessmentRating2).assessmentDefinitionId();
    verify(assessmentRating, atLeast(1)).entityReference();
    verify(assessmentRating2, atLeast(1)).entityReference();
    verify(assessmentRating).ratingId();
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(dsl, atLeast(1)).deleteFrom(isA(Table.class));
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#bulkRemove(RemoveAssessmentRatingCommand)}
   */
  @Test
  void testBulkRemove6() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenThrow(new MappingException("An error occurred"));

    // Act and Assert
    assertThrows(MappingException.class,
        () -> (new AssessmentRatingDao(dsl)).bulkRemove((RemoveAssessmentRatingCommand) null));
    verify(dsl).deleteFrom(isA(Table.class));
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#bulkRemove(RemoveAssessmentRatingCommand)}
   */
  @Test
  void testBulkRemove7() throws DataAccessException {
    // Arrange
    DeleteConditionStep<AssessmentRatingRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<AssessmentRatingRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteConditionStep<AssessmentRatingRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DeleteUsingStep<AssessmentRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(deleteUsingStep);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    RemoveAssessmentRatingCommand rating = mock(RemoveAssessmentRatingCommand.class);
    when(rating.assessmentDefinitionId()).thenReturn(1L);
    when(rating.ratingId()).thenReturn(1L);
    when(rating.entityReference()).thenReturn(entityReference);

    // Act
    boolean actualBulkRemoveResult = assessmentRatingDao.bulkRemove(rating);

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(rating).assessmentDefinitionId();
    verify(rating, atLeast(1)).entityReference();
    verify(rating).ratingId();
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertTrue(actualBulkRemoveResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#bulkRemove(RemoveAssessmentRatingCommand)}
   */
  @Test
  void testBulkRemove8() {
    // Arrange
    DeleteUsingStep<AssessmentRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(mock(DeleteConditionStep.class));
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(deleteUsingStep);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenThrow(new MappingException("An error occurred"));
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    RemoveAssessmentRatingCommand rating = mock(RemoveAssessmentRatingCommand.class);
    when(rating.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.bulkRemove(rating));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(rating, atLeast(1)).entityReference();
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(dsl).deleteFrom(isA(Table.class));
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#bulkRemove(RemoveAssessmentRatingCommand)}
   */
  @Test
  void testBulkRemove9() throws DataAccessException {
    // Arrange
    DeleteConditionStep<AssessmentRatingRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);
    DeleteConditionStep<AssessmentRatingRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteConditionStep<AssessmentRatingRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DeleteUsingStep<AssessmentRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(deleteUsingStep);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    RemoveAssessmentRatingCommand rating = mock(RemoveAssessmentRatingCommand.class);
    when(rating.assessmentDefinitionId()).thenReturn(1L);
    when(rating.ratingId()).thenReturn(1L);
    when(rating.entityReference()).thenReturn(entityReference);

    // Act
    boolean actualBulkRemoveResult = assessmentRatingDao.bulkRemove(rating);

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(rating).assessmentDefinitionId();
    verify(rating, atLeast(1)).entityReference();
    verify(rating).ratingId();
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertFalse(actualBulkRemoveResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}
   */
  @Test
  void testLock() {
    // Arrange
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new MappingException("An error occurred"));
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(MappingException.class, () -> (new AssessmentRatingDao(dsl)).lock(null, 1L, 1L, "janedoe"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}
   */
  @Test
  void testLock2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep2 = mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep3 = mock(UpdateConditionStep.class);
    when(updateConditionStep3.and(Mockito.<Condition>any())).thenReturn(updateConditionStep2);
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep4 = mock(UpdateConditionStep.class);
    when(updateConditionStep4.and(Mockito.<Condition>any())).thenReturn(updateConditionStep3);
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep4);
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(updateSetFirstStep);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualLockResult = assessmentRatingDao.lock(entityReference, 1L, 1L, "janedoe");

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(updateConditionStep).execute();
    verify(updateConditionStep4).and(isA(Condition.class));
    verify(updateConditionStep3).and(isA(Condition.class));
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualLockResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}
   */
  @Test
  void testLock3() {
    // Arrange
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(mock(UpdateConditionStep.class));
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(updateSetFirstStep);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenThrow(new MappingException("An error occurred"));
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.lock(entityReference, 1L, 1L, "janedoe"));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}
   */
  @Test
  void testLock4() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(8);
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep2 = mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep3 = mock(UpdateConditionStep.class);
    when(updateConditionStep3.and(Mockito.<Condition>any())).thenReturn(updateConditionStep2);
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep4 = mock(UpdateConditionStep.class);
    when(updateConditionStep4.and(Mockito.<Condition>any())).thenReturn(updateConditionStep3);
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep4);
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(updateSetFirstStep);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualLockResult = assessmentRatingDao.lock(entityReference, 1L, 1L, "janedoe");

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(updateConditionStep).execute();
    verify(updateConditionStep4).and(isA(Condition.class));
    verify(updateConditionStep3).and(isA(Condition.class));
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertFalse(actualLockResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}
   */
  @Test
  void testUnlock() {
    // Arrange
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new MappingException("An error occurred"));
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(MappingException.class, () -> (new AssessmentRatingDao(dsl)).unlock(null, 1L, 1L, "janedoe"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}
   */
  @Test
  void testUnlock2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep2 = mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep3 = mock(UpdateConditionStep.class);
    when(updateConditionStep3.and(Mockito.<Condition>any())).thenReturn(updateConditionStep2);
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep4 = mock(UpdateConditionStep.class);
    when(updateConditionStep4.and(Mockito.<Condition>any())).thenReturn(updateConditionStep3);
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep4);
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(updateSetFirstStep);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualUnlockResult = assessmentRatingDao.unlock(entityReference, 1L, 1L, "janedoe");

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(updateConditionStep).execute();
    verify(updateConditionStep4).and(isA(Condition.class));
    verify(updateConditionStep3).and(isA(Condition.class));
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualUnlockResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}
   */
  @Test
  void testUnlock3() {
    // Arrange
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(mock(UpdateConditionStep.class));
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(updateSetFirstStep);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenThrow(new MappingException("An error occurred"));
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.unlock(entityReference, 1L, 1L, "janedoe"));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}
   */
  @Test
  void testUnlock4() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(8);
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep2 = mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep3 = mock(UpdateConditionStep.class);
    when(updateConditionStep3.and(Mockito.<Condition>any())).thenReturn(updateConditionStep2);
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep4 = mock(UpdateConditionStep.class);
    when(updateConditionStep4.and(Mockito.<Condition>any())).thenReturn(updateConditionStep3);
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep4);
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(updateSetFirstStep);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualUnlockResult = assessmentRatingDao.unlock(entityReference, 1L, 1L, "janedoe");

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(updateConditionStep).execute();
    verify(updateConditionStep4).and(isA(Condition.class));
    verify(updateConditionStep3).and(isA(Condition.class));
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertFalse(actualUnlockResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#updateComment(long, String, String)}
   */
  @Test
  void testUpdateComment() throws SQLException {
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
    boolean actualUpdateCommentResult = (new AssessmentRatingDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .updateComment(1L, "Comment", "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"assessment_rating\" set \"assessment_rating\".\"description\" = ?, \"assessment_rating\".\"last_updated_at\" = ?, \"assessment_rating\".\"last_updated_by\" = ? where \"assessment_rating\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateCommentResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#updateComment(long, String, String)}
   */
  @Test
  void testUpdateComment2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    boolean actualUpdateCommentResult = (new AssessmentRatingDao(dsl)).updateComment(1L, "Comment", "janedoe");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualUpdateCommentResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#updateRating(long, UpdateRatingCommand, String)}
   */
  @Test
  void testUpdateRating() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<AssessmentRatingRecord>>any())).thenThrow(new MappingException("An error occurred"));

    // Act and Assert
    assertThrows(MappingException.class, () -> (new AssessmentRatingDao(dsl)).updateRating(1L, null, "janedoe"));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#updateRating(long, UpdateRatingCommand, String)}
   */
  @Test
  void testUpdateRating2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(updateSetFirstStep);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);
    UpdateRatingCommand ratingCommand = mock(UpdateRatingCommand.class);
    when(ratingCommand.newRatingId()).thenReturn(1L);

    // Act
    boolean actualUpdateRatingResult = assessmentRatingDao.updateRating(1L, ratingCommand, "janedoe");

    // Assert
    verify(ratingCommand).newRatingId();
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualUpdateRatingResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#updateRating(long, UpdateRatingCommand, String)}
   */
  @Test
  void testUpdateRating3() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(0);
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(updateSetFirstStep);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);
    UpdateRatingCommand ratingCommand = mock(UpdateRatingCommand.class);
    when(ratingCommand.newRatingId()).thenReturn(1L);

    // Act
    boolean actualUpdateRatingResult = assessmentRatingDao.updateRating(1L, ratingCommand, "janedoe");

    // Assert
    verify(ratingCommand).newRatingId();
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertFalse(actualUpdateRatingResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#hasMultiValuedAssessments(long)}
   */
  @Test
  void testHasMultiValuedAssessments() throws SQLException {
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
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualHasMultiValuedAssessmentsResult = (new AssessmentRatingDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).hasMultiValuedAssessments(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"assessment_rating\".\"entity_id\", count(\"assessment_rating\".\"rating_id\") from \"assessment_rating\" where \"assessment_rating\".\"assessment_definition_id\" = ? group by \"assessment_rating\".\"entity_id\" having count(\"assessment_rating\".\"rating_id\") > ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(eq(2), eq(1));
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(2));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualHasMultiValuedAssessmentsResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#hasMultiValuedAssessments(long)}
   */
  @Test
  void testHasMultiValuedAssessments2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(0);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualHasMultiValuedAssessmentsResult = (new AssessmentRatingDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).hasMultiValuedAssessments(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"assessment_rating\".\"entity_id\", count(\"assessment_rating\".\"rating_id\") from \"assessment_rating\" where \"assessment_rating\".\"assessment_definition_id\" = ? group by \"assessment_rating\".\"entity_id\" having count(\"assessment_rating\".\"rating_id\") > ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(eq(2), eq(1));
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(2));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualHasMultiValuedAssessmentsResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#hasMultiValuedAssessments(long)}
   */
  @Test
  void testHasMultiValuedAssessments3() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualHasMultiValuedAssessmentsResult = (new AssessmentRatingDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).hasMultiValuedAssessments(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"assessment_rating\".\"entity_id\", count(\"assessment_rating\".\"rating_id\") from \"assessment_rating\" where \"assessment_rating\".\"assessment_definition_id\" = ? group by \"assessment_rating\".\"entity_id\" having count(\"assessment_rating\".\"rating_id\") > ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(eq(2), eq(1));
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertFalse(actualHasMultiValuedAssessmentsResult);
  }

  /**
   * Method under test: {@link AssessmentRatingDao#add(Set)}
   */
  @Test
  void testAdd() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, assessmentRatingDao.add(new HashSet<>()));
  }

  /**
   * Method under test: {@link AssessmentRatingDao#add(Set)}
   */
  @Test
  void testAdd2() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(
        new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, assessmentRatingDao.add(new HashSet<>()));
  }

  /**
   * Method under test: {@link AssessmentRatingDao#add(Set)}
   */
  @Test
  void testAdd3() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(mock(DSLContext.class));
    AssessmentRating assessmentRating = mock(AssessmentRating.class);
    when(assessmentRating.assessmentDefinitionId()).thenThrow(new MappingException("An error occurred"));

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();
    assessmentRatings.add(assessmentRating);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.add(assessmentRatings));
    verify(assessmentRating).assessmentDefinitionId();
  }

  /**
   * Method under test: {@link AssessmentRatingDao#add(Set)}
   */
  @Test
  void testAdd4() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(mock(DSLContext.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenThrow(new MappingException("An error occurred"));
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    AssessmentRating assessmentRating = mock(AssessmentRating.class);
    when(assessmentRating.assessmentDefinitionId()).thenReturn(1L);
    when(assessmentRating.entityReference()).thenReturn(entityReference);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();
    assessmentRatings.add(assessmentRating);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.add(assessmentRatings));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(assessmentRating).assessmentDefinitionId();
    verify(assessmentRating, atLeast(1)).entityReference();
  }

  /**
   * Method under test: {@link AssessmentRatingDao#add(Set)}
   */
  @Test
  void testAdd5() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(mock(DSLContext.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    AssessmentRating assessmentRating = mock(AssessmentRating.class);
    when(assessmentRating.lastUpdatedBy()).thenReturn("2020-03-01");
    when(assessmentRating.comment()).thenReturn("Comment");
    when(assessmentRating.ratingId()).thenReturn(1L);
    when(assessmentRating.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(assessmentRating.assessmentDefinitionId()).thenReturn(1L);
    when(assessmentRating.entityReference()).thenReturn(entityReference);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    AssessmentRating assessmentRating2 = mock(AssessmentRating.class);
    when(assessmentRating2.lastUpdatedBy()).thenThrow(new MappingException("An error occurred"));
    when(assessmentRating2.comment()).thenReturn("Comment");
    when(assessmentRating2.ratingId()).thenReturn(1L);
    when(assessmentRating2.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(assessmentRating2.assessmentDefinitionId()).thenReturn(1L);
    when(assessmentRating2.entityReference()).thenReturn(entityReference2);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();
    assessmentRatings.add(assessmentRating2);
    assessmentRatings.add(assessmentRating);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.add(assessmentRatings));
    verify(assessmentRating2).comment();
    verify(entityReference2).id();
    verify(entityReference2).kind();
    verify(assessmentRating2).lastUpdatedAt();
    verify(assessmentRating2).lastUpdatedBy();
    verify(assessmentRating2).assessmentDefinitionId();
    verify(assessmentRating2, atLeast(1)).entityReference();
    verify(assessmentRating2).ratingId();
  }

  /**
   * Method under test: {@link AssessmentRatingDao#add(Set)}
   */
  @Test
  void testAdd6() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(mock(DSLContext.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    AssessmentRating assessmentRating = mock(AssessmentRating.class);
    when(assessmentRating.lastUpdatedBy()).thenReturn("2020-03-01");
    when(assessmentRating.comment()).thenReturn("Comment");
    when(assessmentRating.ratingId()).thenReturn(1L);
    when(assessmentRating.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(assessmentRating.assessmentDefinitionId()).thenReturn(1L);
    when(assessmentRating.entityReference()).thenReturn(entityReference);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    AssessmentRating assessmentRating2 = mock(AssessmentRating.class);
    when(assessmentRating2.lastUpdatedBy()).thenThrow(new MappingException("An error occurred"));
    when(assessmentRating2.comment()).thenReturn("‘");
    when(assessmentRating2.ratingId()).thenReturn(1L);
    when(assessmentRating2.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(assessmentRating2.assessmentDefinitionId()).thenReturn(1L);
    when(assessmentRating2.entityReference()).thenReturn(entityReference2);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();
    assessmentRatings.add(assessmentRating2);
    assessmentRatings.add(assessmentRating);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.add(assessmentRatings));
    verify(assessmentRating2).comment();
    verify(entityReference2).id();
    verify(entityReference2).kind();
    verify(assessmentRating2).lastUpdatedAt();
    verify(assessmentRating2).lastUpdatedBy();
    verify(assessmentRating2).assessmentDefinitionId();
    verify(assessmentRating2, atLeast(1)).entityReference();
    verify(assessmentRating2).ratingId();
  }

  /**
   * Method under test: {@link AssessmentRatingDao#add(Set)}
   */
  @Test
  void testAdd7() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(mock(DSLContext.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    AssessmentRating assessmentRating = mock(AssessmentRating.class);
    when(assessmentRating.lastUpdatedBy()).thenReturn("2020-03-01");
    when(assessmentRating.comment()).thenReturn("Comment");
    when(assessmentRating.ratingId()).thenReturn(1L);
    when(assessmentRating.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(assessmentRating.assessmentDefinitionId()).thenReturn(1L);
    when(assessmentRating.entityReference()).thenReturn(entityReference);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    AssessmentRating assessmentRating2 = mock(AssessmentRating.class);
    when(assessmentRating2.lastUpdatedBy()).thenThrow(new MappingException("An error occurred"));
    when(assessmentRating2.comment()).thenReturn("​");
    when(assessmentRating2.ratingId()).thenReturn(1L);
    when(assessmentRating2.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(assessmentRating2.assessmentDefinitionId()).thenReturn(1L);
    when(assessmentRating2.entityReference()).thenReturn(entityReference2);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();
    assessmentRatings.add(assessmentRating2);
    assessmentRatings.add(assessmentRating);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.add(assessmentRatings));
    verify(assessmentRating2).comment();
    verify(entityReference2).id();
    verify(entityReference2).kind();
    verify(assessmentRating2).lastUpdatedAt();
    verify(assessmentRating2).lastUpdatedBy();
    verify(assessmentRating2).assessmentDefinitionId();
    verify(assessmentRating2, atLeast(1)).entityReference();
    verify(assessmentRating2).ratingId();
  }

  /**
   * Method under test: {@link AssessmentRatingDao#add(Set)}
   */
  @Test
  void testAdd8() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(mock(DSLContext.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    AssessmentRating assessmentRating = mock(AssessmentRating.class);
    when(assessmentRating.lastUpdatedBy()).thenReturn("2020-03-01");
    when(assessmentRating.comment()).thenReturn("Comment");
    when(assessmentRating.ratingId()).thenReturn(1L);
    when(assessmentRating.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(assessmentRating.assessmentDefinitionId()).thenReturn(1L);
    when(assessmentRating.entityReference()).thenReturn(entityReference);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    AssessmentRating assessmentRating2 = mock(AssessmentRating.class);
    when(assessmentRating2.lastUpdatedBy()).thenThrow(new MappingException("An error occurred"));
    when(assessmentRating2.comment()).thenReturn("â€œ");
    when(assessmentRating2.ratingId()).thenReturn(1L);
    when(assessmentRating2.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(assessmentRating2.assessmentDefinitionId()).thenReturn(1L);
    when(assessmentRating2.entityReference()).thenReturn(entityReference2);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();
    assessmentRatings.add(assessmentRating2);
    assessmentRatings.add(assessmentRating);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.add(assessmentRatings));
    verify(assessmentRating2).comment();
    verify(entityReference2).id();
    verify(entityReference2).kind();
    verify(assessmentRating2).lastUpdatedAt();
    verify(assessmentRating2).lastUpdatedBy();
    verify(assessmentRating2).assessmentDefinitionId();
    verify(assessmentRating2, atLeast(1)).entityReference();
    verify(assessmentRating2).ratingId();
  }

  /**
   * Method under test: {@link AssessmentRatingDao#add(Set)}
   */
  @Test
  void testAdd9() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(mock(DSLContext.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    AssessmentRating assessmentRating = mock(AssessmentRating.class);
    when(assessmentRating.lastUpdatedBy()).thenReturn("2020-03-01");
    when(assessmentRating.comment()).thenReturn("Comment");
    when(assessmentRating.ratingId()).thenReturn(1L);
    when(assessmentRating.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(assessmentRating.assessmentDefinitionId()).thenReturn(1L);
    when(assessmentRating.entityReference()).thenReturn(entityReference);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    AssessmentRating assessmentRating2 = mock(AssessmentRating.class);
    when(assessmentRating2.lastUpdatedBy()).thenThrow(new MappingException("An error occurred"));
    when(assessmentRating2.comment()).thenReturn("â€");
    when(assessmentRating2.ratingId()).thenReturn(1L);
    when(assessmentRating2.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(assessmentRating2.assessmentDefinitionId()).thenReturn(1L);
    when(assessmentRating2.entityReference()).thenReturn(entityReference2);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();
    assessmentRatings.add(assessmentRating2);
    assessmentRatings.add(assessmentRating);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.add(assessmentRatings));
    verify(assessmentRating2).comment();
    verify(entityReference2).id();
    verify(entityReference2).kind();
    verify(assessmentRating2).lastUpdatedAt();
    verify(assessmentRating2).lastUpdatedBy();
    verify(assessmentRating2).assessmentDefinitionId();
    verify(assessmentRating2, atLeast(1)).entityReference();
    verify(assessmentRating2).ratingId();
  }

  /**
   * Method under test: {@link AssessmentRatingDao#add(Set)}
   */
  @Test
  void testAdd10() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(mock(DSLContext.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    AssessmentRating assessmentRating = mock(AssessmentRating.class);
    when(assessmentRating.lastUpdatedBy()).thenReturn("2020-03-01");
    when(assessmentRating.comment()).thenReturn("Comment");
    when(assessmentRating.ratingId()).thenReturn(1L);
    when(assessmentRating.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(assessmentRating.assessmentDefinitionId()).thenReturn(1L);
    when(assessmentRating.entityReference()).thenReturn(entityReference);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    AssessmentRating assessmentRating2 = mock(AssessmentRating.class);
    when(assessmentRating2.lastUpdatedBy()).thenThrow(new MappingException("An error occurred"));
    when(assessmentRating2.comment()).thenReturn("â€™");
    when(assessmentRating2.ratingId()).thenReturn(1L);
    when(assessmentRating2.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(assessmentRating2.assessmentDefinitionId()).thenReturn(1L);
    when(assessmentRating2.entityReference()).thenReturn(entityReference2);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();
    assessmentRatings.add(assessmentRating2);
    assessmentRatings.add(assessmentRating);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.add(assessmentRatings));
    verify(assessmentRating2).comment();
    verify(entityReference2).id();
    verify(entityReference2).kind();
    verify(assessmentRating2).lastUpdatedAt();
    verify(assessmentRating2).lastUpdatedBy();
    verify(assessmentRating2).assessmentDefinitionId();
    verify(assessmentRating2, atLeast(1)).entityReference();
    verify(assessmentRating2).ratingId();
  }

  /**
   * Method under test: {@link AssessmentRatingDao#add(Set)}
   */
  @Test
  void testAdd11() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(mock(DSLContext.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    AssessmentRating assessmentRating = mock(AssessmentRating.class);
    when(assessmentRating.lastUpdatedBy()).thenReturn("2020-03-01");
    when(assessmentRating.comment()).thenReturn("Comment");
    when(assessmentRating.ratingId()).thenReturn(1L);
    when(assessmentRating.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(assessmentRating.assessmentDefinitionId()).thenReturn(1L);
    when(assessmentRating.entityReference()).thenReturn(entityReference);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    AssessmentRating assessmentRating2 = mock(AssessmentRating.class);
    when(assessmentRating2.lastUpdatedBy()).thenThrow(new MappingException("An error occurred"));
    when(assessmentRating2.comment()).thenReturn("&amp;");
    when(assessmentRating2.ratingId()).thenReturn(1L);
    when(assessmentRating2.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(assessmentRating2.assessmentDefinitionId()).thenReturn(1L);
    when(assessmentRating2.entityReference()).thenReturn(entityReference2);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();
    assessmentRatings.add(assessmentRating2);
    assessmentRatings.add(assessmentRating);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.add(assessmentRatings));
    verify(assessmentRating2).comment();
    verify(entityReference2).id();
    verify(entityReference2).kind();
    verify(assessmentRating2).lastUpdatedAt();
    verify(assessmentRating2).lastUpdatedBy();
    verify(assessmentRating2).assessmentDefinitionId();
    verify(assessmentRating2, atLeast(1)).entityReference();
    verify(assessmentRating2).ratingId();
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}
   */
  @Test
  void testBulkUpdateSingleValuedAssessments() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualBulkUpdateSingleValuedAssessmentsResult = assessmentRatingDao
        .bulkUpdateSingleValuedAssessments(new HashSet<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertEquals(4, actualBulkUpdateSingleValuedAssessmentsResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}
   */
  @Test
  void testBulkUpdateSingleValuedAssessments2() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);

    // Act
    int actualBulkUpdateSingleValuedAssessmentsResult = assessmentRatingDao
        .bulkUpdateSingleValuedAssessments(new HashSet<>());

    // Assert
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    assertEquals(4, actualBulkUpdateSingleValuedAssessmentsResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}
   */
  @Test
  void testBulkUpdateSingleValuedAssessments3() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.update(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(mock(UpdateSetFirstStep.class));
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);
    AssessmentRating assessmentRating = mock(AssessmentRating.class);
    when(assessmentRating.ratingId()).thenThrow(new MappingException("An error occurred"));

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();
    assessmentRatings.add(assessmentRating);

    // Act and Assert
    assertThrows(MappingException.class,
        () -> assessmentRatingDao.bulkUpdateSingleValuedAssessments(assessmentRatings));
    verify(assessmentRating).ratingId();
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}
   */
  @Test
  void testBulkUpdateSingleValuedAssessments4() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(mock(UpdateConditionStep.class));
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.update(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(updateSetFirstStep);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    AssessmentRating assessmentRating = mock(AssessmentRating.class);
    when(assessmentRating.comment()).thenReturn("Comment");
    when(assessmentRating.assessmentDefinitionId()).thenReturn(1L);
    when(assessmentRating.ratingId()).thenReturn(1L);
    when(assessmentRating.entityReference()).thenReturn(entityReference);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();
    assessmentRatings.add(assessmentRating);

    // Act
    int actualBulkUpdateSingleValuedAssessmentsResult = assessmentRatingDao
        .bulkUpdateSingleValuedAssessments(assessmentRatings);

    // Assert
    verify(assessmentRating).comment();
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(assessmentRating).assessmentDefinitionId();
    verify(assessmentRating, atLeast(1)).entityReference();
    verify(assessmentRating).ratingId();
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    verify(dsl).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(4, actualBulkUpdateSingleValuedAssessmentsResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}
   */
  @Test
  void testBulkUpdateSingleValuedAssessments5() {
    // Arrange
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(mock(UpdateSetMoreStep.class));
    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.update(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(updateSetFirstStep);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenThrow(new MappingException("An error occurred"));
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    AssessmentRating assessmentRating = mock(AssessmentRating.class);
    when(assessmentRating.comment()).thenReturn("Comment");
    when(assessmentRating.assessmentDefinitionId()).thenReturn(1L);
    when(assessmentRating.ratingId()).thenReturn(1L);
    when(assessmentRating.entityReference()).thenReturn(entityReference);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();
    assessmentRatings.add(assessmentRating);

    // Act and Assert
    assertThrows(MappingException.class,
        () -> assessmentRatingDao.bulkUpdateSingleValuedAssessments(assessmentRatings));
    verify(assessmentRating).comment();
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(assessmentRating).assessmentDefinitionId();
    verify(assessmentRating, atLeast(1)).entityReference();
    verify(assessmentRating).ratingId();
    verify(dsl).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}
   */
  @Test
  void testBulkUpdateMultiValuedAssessments() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualBulkUpdateMultiValuedAssessmentsResult = assessmentRatingDao
        .bulkUpdateMultiValuedAssessments(new HashSet<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertEquals(4, actualBulkUpdateMultiValuedAssessmentsResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}
   */
  @Test
  void testBulkUpdateMultiValuedAssessments2() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);

    // Act
    int actualBulkUpdateMultiValuedAssessmentsResult = assessmentRatingDao
        .bulkUpdateMultiValuedAssessments(new HashSet<>());

    // Assert
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    assertEquals(4, actualBulkUpdateMultiValuedAssessmentsResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}
   */
  @Test
  void testBulkUpdateMultiValuedAssessments3() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.update(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(mock(UpdateSetFirstStep.class));
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);
    AssessmentRating assessmentRating = mock(AssessmentRating.class);
    when(assessmentRating.comment()).thenThrow(new MappingException("An error occurred"));

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();
    assessmentRatings.add(assessmentRating);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.bulkUpdateMultiValuedAssessments(assessmentRatings));
    verify(assessmentRating).comment();
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}
   */
  @Test
  void testBulkUpdateMultiValuedAssessments4() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(mock(UpdateConditionStep.class));
    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.update(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(updateSetFirstStep);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    AssessmentRating assessmentRating = mock(AssessmentRating.class);
    when(assessmentRating.ratingId()).thenReturn(1L);
    when(assessmentRating.comment()).thenReturn("Comment");
    when(assessmentRating.assessmentDefinitionId()).thenReturn(1L);
    when(assessmentRating.entityReference()).thenReturn(entityReference);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();
    assessmentRatings.add(assessmentRating);

    // Act
    int actualBulkUpdateMultiValuedAssessmentsResult = assessmentRatingDao
        .bulkUpdateMultiValuedAssessments(assessmentRatings);

    // Assert
    verify(assessmentRating).comment();
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(assessmentRating).assessmentDefinitionId();
    verify(assessmentRating, atLeast(1)).entityReference();
    verify(assessmentRating).ratingId();
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    verify(dsl).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(4, actualBulkUpdateMultiValuedAssessmentsResult);
  }

  /**
   * Method under test:
   * {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}
   */
  @Test
  void testBulkUpdateMultiValuedAssessments5() {
    // Arrange
    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(mock(UpdateSetMoreStep.class));
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.update(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(updateSetFirstStep);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenThrow(new MappingException("An error occurred"));
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    AssessmentRating assessmentRating = mock(AssessmentRating.class);
    when(assessmentRating.comment()).thenReturn("Comment");
    when(assessmentRating.assessmentDefinitionId()).thenReturn(1L);
    when(assessmentRating.entityReference()).thenReturn(entityReference);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();
    assessmentRatings.add(assessmentRating);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.bulkUpdateMultiValuedAssessments(assessmentRatings));
    verify(assessmentRating).comment();
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(assessmentRating).assessmentDefinitionId();
    verify(assessmentRating, atLeast(1)).entityReference();
    verify(dsl).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
  }
}
