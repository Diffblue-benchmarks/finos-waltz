package org.finos.waltz.data.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.schema.tables.records.AssessmentRatingRecord;
import org.jooq.Batch;
import org.jooq.Condition;
import org.jooq.DSLContext;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AssessmentRatingDaoDiffblueTest {
  /**
   * Test {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}.
   * <p>
   * Method under test: {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateMultiValuedAssessments(Set)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateMultiValuedAssessments(Set)"})
  void testBulkUpdateMultiValuedAssessments() {
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
   * Test {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}.
   * <p>
   * Method under test: {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateMultiValuedAssessments(Set)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateMultiValuedAssessments(Set)"})
  void testBulkUpdateMultiValuedAssessments2() {
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

  /**
   * Test {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}.
   * <ul>
   *   <li>Then calls {@link Connection#createStatement()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateMultiValuedAssessments(Set); then calls createStatement()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateMultiValuedAssessments(Set)"})
  void testBulkUpdateMultiValuedAssessments_thenCallsCreateStatement() throws SQLException {
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
   * Test {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}.
   * <ul>
   *   <li>Then calls {@link AssessmentRating#ratingId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateMultiValuedAssessments(Set); then calls ratingId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateMultiValuedAssessments(Set)"})
  void testBulkUpdateMultiValuedAssessments_thenCallsRatingId() throws DataAccessException {
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
   * Test {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then calls {@link Batch#execute()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateMultiValuedAssessments(Set); when HashSet(); then calls execute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateMultiValuedAssessments(Set)"})
  void testBulkUpdateMultiValuedAssessments_whenHashSet_thenCallsExecute() throws DataAccessException {
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
}
