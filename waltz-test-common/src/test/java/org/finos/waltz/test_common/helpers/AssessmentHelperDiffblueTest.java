package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Timestamp;
import java.util.Optional;
import org.finos.waltz.common.exception.InsufficientPrivelegeException;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_rating.SaveAssessmentRatingCommand;
import org.finos.waltz.schema.tables.records.AssessmentDefinitionRecord;
import org.finos.waltz.schema.tables.records.AssessmentRatingRecord;
import org.finos.waltz.service.assessment_definition.AssessmentDefinitionService;
import org.finos.waltz.service.assessment_rating.AssessmentRatingService;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.InsertReturningStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

class AssessmentHelperDiffblueTest {
  /**
   * Method under test:
   * {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String)}
   */
  @Test
  void testCreateDefinition() {
    // Arrange
    AssessmentHelper assessmentHelper = new AssessmentHelper();
    ReflectionTestUtils.setField(assessmentHelper, "ratingService", mock(AssessmentRatingService.class));
    ReflectionTestUtils.setField(assessmentHelper, "dsl", mock(DSLContext.class));
    AssessmentDefinitionService assessmentDefinitionService = mock(AssessmentDefinitionService.class);
    when(assessmentDefinitionService.save(Mockito.<AssessmentDefinition>any())).thenReturn(1L);
    ReflectionTestUtils.setField(assessmentHelper, "definitionService", assessmentDefinitionService);

    // Act
    long actualCreateDefinitionResult = assessmentHelper.createDefinition(1L, "Name", "Permitted Role",
        AssessmentVisibility.PRIMARY, "Definition Group");

    // Assert
    verify(assessmentDefinitionService).save(isA(AssessmentDefinition.class));
    assertEquals(1L, actualCreateDefinitionResult);
  }

  /**
   * Method under test:
   * {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String)}
   */
  @Test
  void testCreateDefinition2() {
    // Arrange
    AssessmentHelper assessmentHelper = new AssessmentHelper();
    ReflectionTestUtils.setField(assessmentHelper, "ratingService", mock(AssessmentRatingService.class));
    ReflectionTestUtils.setField(assessmentHelper, "dsl", mock(DSLContext.class));
    AssessmentDefinitionService assessmentDefinitionService = mock(AssessmentDefinitionService.class);
    when(assessmentDefinitionService.save(Mockito.<AssessmentDefinition>any())).thenReturn(1L);
    ReflectionTestUtils.setField(assessmentHelper, "definitionService", assessmentDefinitionService);

    // Act
    long actualCreateDefinitionResult = assessmentHelper.createDefinition(1L, "Name", "", AssessmentVisibility.PRIMARY,
        "Definition Group");

    // Assert
    verify(assessmentDefinitionService).save(isA(AssessmentDefinition.class));
    assertEquals(1L, actualCreateDefinitionResult);
  }

  /**
   * Method under test:
   * {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String)}
   */
  @Test
  void testCreateDefinition3() {
    // Arrange
    AssessmentHelper assessmentHelper = new AssessmentHelper();
    ReflectionTestUtils.setField(assessmentHelper, "ratingService", mock(AssessmentRatingService.class));
    ReflectionTestUtils.setField(assessmentHelper, "dsl", mock(DSLContext.class));
    AssessmentDefinitionService assessmentDefinitionService = mock(AssessmentDefinitionService.class);
    when(assessmentDefinitionService.save(Mockito.<AssessmentDefinition>any())).thenReturn(1L);
    ReflectionTestUtils.setField(assessmentHelper, "definitionService", assessmentDefinitionService);

    // Act
    long actualCreateDefinitionResult = assessmentHelper.createDefinition(1L, "Name", "Permitted Role",
        AssessmentVisibility.PRIMARY, "");

    // Assert
    verify(assessmentDefinitionService).save(isA(AssessmentDefinition.class));
    assertEquals(1L, actualCreateDefinitionResult);
  }

  /**
   * Method under test:
   * {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, Cardinality, Optional)}
   */
  @Test
  void testCreateDefinition4() {
    // Arrange
    AssessmentHelper assessmentHelper = new AssessmentHelper();
    ReflectionTestUtils.setField(assessmentHelper, "ratingService", mock(AssessmentRatingService.class));
    ReflectionTestUtils.setField(assessmentHelper, "dsl", mock(DSLContext.class));
    AssessmentDefinitionService assessmentDefinitionService = mock(AssessmentDefinitionService.class);
    when(assessmentDefinitionService.save(Mockito.<AssessmentDefinition>any())).thenReturn(1L);
    ReflectionTestUtils.setField(assessmentHelper, "definitionService", assessmentDefinitionService);
    Optional<EntityReference> qualifierRef = Optional.of(mock(EntityReference.class));

    // Act
    long actualCreateDefinitionResult = assessmentHelper.createDefinition(1L, "Name", "Permitted Role",
        AssessmentVisibility.PRIMARY, "Definition Group", EntityKind.ALL, Cardinality.ZERO_ONE, qualifierRef);

    // Assert
    verify(assessmentDefinitionService).save(isA(AssessmentDefinition.class));
    assertEquals(1L, actualCreateDefinitionResult);
  }

  /**
   * Method under test:
   * {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, Cardinality, Optional)}
   */
  @Test
  void testCreateDefinition5() {
    // Arrange
    AssessmentHelper assessmentHelper = new AssessmentHelper();
    ReflectionTestUtils.setField(assessmentHelper, "ratingService", mock(AssessmentRatingService.class));
    ReflectionTestUtils.setField(assessmentHelper, "dsl", mock(DSLContext.class));
    AssessmentDefinitionService assessmentDefinitionService = mock(AssessmentDefinitionService.class);
    when(assessmentDefinitionService.save(Mockito.<AssessmentDefinition>any())).thenReturn(1L);
    ReflectionTestUtils.setField(assessmentHelper, "definitionService", assessmentDefinitionService);
    Optional<EntityReference> qualifierRef = Optional.of(mock(EntityReference.class));

    // Act
    long actualCreateDefinitionResult = assessmentHelper.createDefinition(1L, "Name", "", AssessmentVisibility.PRIMARY,
        "Definition Group", EntityKind.ALL, Cardinality.ZERO_ONE, qualifierRef);

    // Assert
    verify(assessmentDefinitionService).save(isA(AssessmentDefinition.class));
    assertEquals(1L, actualCreateDefinitionResult);
  }

  /**
   * Method under test:
   * {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, Cardinality, Optional)}
   */
  @Test
  void testCreateDefinition6() {
    // Arrange
    AssessmentHelper assessmentHelper = new AssessmentHelper();
    ReflectionTestUtils.setField(assessmentHelper, "ratingService", mock(AssessmentRatingService.class));
    ReflectionTestUtils.setField(assessmentHelper, "dsl", mock(DSLContext.class));
    AssessmentDefinitionService assessmentDefinitionService = mock(AssessmentDefinitionService.class);
    when(assessmentDefinitionService.save(Mockito.<AssessmentDefinition>any())).thenReturn(1L);
    ReflectionTestUtils.setField(assessmentHelper, "definitionService", assessmentDefinitionService);
    Optional<EntityReference> qualifierRef = Optional.of(mock(EntityReference.class));

    // Act
    long actualCreateDefinitionResult = assessmentHelper.createDefinition(1L, "Name", "Permitted Role",
        AssessmentVisibility.PRIMARY, "", EntityKind.ALL, Cardinality.ZERO_ONE, qualifierRef);

    // Assert
    verify(assessmentDefinitionService).save(isA(AssessmentDefinition.class));
    assertEquals(1L, actualCreateDefinitionResult);
  }

  /**
   * Method under test:
   * {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, EntityReference)}
   */
  @Test
  void testCreateDefinition7() {
    // Arrange
    AssessmentHelper assessmentHelper = new AssessmentHelper();
    ReflectionTestUtils.setField(assessmentHelper, "ratingService", mock(AssessmentRatingService.class));
    ReflectionTestUtils.setField(assessmentHelper, "dsl", mock(DSLContext.class));
    AssessmentDefinitionService assessmentDefinitionService = mock(AssessmentDefinitionService.class);
    when(assessmentDefinitionService.save(Mockito.<AssessmentDefinition>any())).thenReturn(1L);
    ReflectionTestUtils.setField(assessmentHelper, "definitionService", assessmentDefinitionService);

    // Act
    long actualCreateDefinitionResult = assessmentHelper.createDefinition(1L, "Name", "Permitted Role",
        AssessmentVisibility.PRIMARY, "Definition Group", EntityKind.ALL, null);

    // Assert
    verify(assessmentDefinitionService).save(isA(AssessmentDefinition.class));
    assertEquals(1L, actualCreateDefinitionResult);
  }

  /**
   * Method under test:
   * {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, EntityReference)}
   */
  @Test
  void testCreateDefinition8() {
    // Arrange
    AssessmentHelper assessmentHelper = new AssessmentHelper();
    ReflectionTestUtils.setField(assessmentHelper, "ratingService", mock(AssessmentRatingService.class));
    ReflectionTestUtils.setField(assessmentHelper, "dsl", mock(DSLContext.class));
    AssessmentDefinitionService assessmentDefinitionService = mock(AssessmentDefinitionService.class);
    when(assessmentDefinitionService.save(Mockito.<AssessmentDefinition>any())).thenReturn(1L);
    ReflectionTestUtils.setField(assessmentHelper, "definitionService", assessmentDefinitionService);

    // Act
    long actualCreateDefinitionResult = assessmentHelper.createDefinition(1L, "Name", "", AssessmentVisibility.PRIMARY,
        "Definition Group", EntityKind.ALL, null);

    // Assert
    verify(assessmentDefinitionService).save(isA(AssessmentDefinition.class));
    assertEquals(1L, actualCreateDefinitionResult);
  }

  /**
   * Method under test:
   * {@link AssessmentHelper#createDefinition(long, String, String, AssessmentVisibility, String, EntityKind, EntityReference)}
   */
  @Test
  void testCreateDefinition9() {
    // Arrange
    AssessmentHelper assessmentHelper = new AssessmentHelper();
    ReflectionTestUtils.setField(assessmentHelper, "ratingService", mock(AssessmentRatingService.class));
    ReflectionTestUtils.setField(assessmentHelper, "dsl", mock(DSLContext.class));
    AssessmentDefinitionService assessmentDefinitionService = mock(AssessmentDefinitionService.class);
    when(assessmentDefinitionService.save(Mockito.<AssessmentDefinition>any())).thenReturn(1L);
    ReflectionTestUtils.setField(assessmentHelper, "definitionService", assessmentDefinitionService);

    // Act
    long actualCreateDefinitionResult = assessmentHelper.createDefinition(1L, "Name", "Permitted Role",
        AssessmentVisibility.PRIMARY, "", EntityKind.ALL, null);

    // Assert
    verify(assessmentDefinitionService).save(isA(AssessmentDefinition.class));
    assertEquals(1L, actualCreateDefinitionResult);
  }

  /**
   * Method under test:
   * {@link AssessmentHelper#createAssessment(Long, EntityReference, Long)}
   */
  @Test
  void testCreateAssessment() throws DataAccessException {
    // Arrange
    AssessmentHelper assessmentHelper = new AssessmentHelper();
    ReflectionTestUtils.setField(assessmentHelper, "ratingService", mock(AssessmentRatingService.class));
    AssessmentRatingRecord assessmentRatingRecord = mock(AssessmentRatingRecord.class);
    doNothing().when(assessmentRatingRecord).setDescription(Mockito.<String>any());
    doNothing().when(assessmentRatingRecord).setEntityKind(Mockito.<String>any());
    doNothing().when(assessmentRatingRecord).setIsReadonly(Mockito.<Boolean>any());
    doNothing().when(assessmentRatingRecord).setLastUpdatedAt(Mockito.<Timestamp>any());
    doNothing().when(assessmentRatingRecord).setLastUpdatedBy(Mockito.<String>any());
    doNothing().when(assessmentRatingRecord).setProvenance(Mockito.<String>any());
    doNothing().when(assessmentRatingRecord).setRatingId(Mockito.<Long>any());
    doNothing().when(assessmentRatingRecord).setEntityId(Mockito.<Long>any());
    doNothing().when(assessmentRatingRecord).setAssessmentDefinitionId(Mockito.<Long>any());
    InsertReturningStep<AssessmentRatingRecord> insertReturningStep = mock(InsertReturningStep.class);
    when(insertReturningStep.execute()).thenReturn(1);
    InsertSetMoreStep<AssessmentRatingRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyIgnore()).thenReturn(insertReturningStep);
    InsertSetStep<AssessmentRatingRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    DSLContext dslContext = mock(DSLContext.class);
    when(dslContext.insertInto(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(insertSetStep);
    when(dslContext.newRecord(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(assessmentRatingRecord);
    ReflectionTestUtils.setField(assessmentHelper, "dsl", dslContext);
    ReflectionTestUtils.setField(assessmentHelper, "definitionService", mock(AssessmentDefinitionService.class));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    assessmentHelper.createAssessment(1L, ref, 1L);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(assessmentRatingRecord).setAssessmentDefinitionId(eq(1L));
    verify(assessmentRatingRecord).setDescription(eq("test"));
    verify(assessmentRatingRecord).setEntityId(eq(1L));
    verify(assessmentRatingRecord).setEntityKind(eq("ALL"));
    verify(assessmentRatingRecord).setIsReadonly(eq(false));
    verify(assessmentRatingRecord).setLastUpdatedAt(isA(Timestamp.class));
    verify(assessmentRatingRecord).setLastUpdatedBy(eq("test"));
    verify(assessmentRatingRecord).setProvenance(eq("test"));
    verify(assessmentRatingRecord).setRatingId(eq(1L));
    verify(dslContext).insertInto(isA(Table.class));
    verify(dslContext).newRecord(isA(Table.class));
    verify(insertSetMoreStep).onDuplicateKeyIgnore();
    verify(insertSetStep).set(isA(Record.class));
    verify(insertReturningStep).execute();
  }

  /**
   * Method under test:
   * {@link AssessmentHelper#createAssessment(Long, EntityReference, Long, String)}
   */
  @Test
  void testCreateAssessment2() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingService assessmentRatingService = mock(AssessmentRatingService.class);
    when(assessmentRatingService.store(Mockito.<SaveAssessmentRatingCommand>any(), Mockito.<String>any()))
        .thenReturn(true);
    AssessmentHelper assessmentHelper = new AssessmentHelper();
    ReflectionTestUtils.setField(assessmentHelper, "ratingService", assessmentRatingService);
    ReflectionTestUtils.setField(assessmentHelper, "dsl", mock(DSLContext.class));
    ReflectionTestUtils.setField(assessmentHelper, "definitionService", mock(AssessmentDefinitionService.class));

    // Act
    assessmentHelper.createAssessment(1L, mock(EntityReference.class), 1L, "janedoe");

    // Assert
    verify(assessmentRatingService).store(isA(SaveAssessmentRatingCommand.class), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link AssessmentHelper#createAssessment(Long, EntityReference, Long, String)}
   */
  @Test
  void testCreateAssessment3() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingService assessmentRatingService = mock(AssessmentRatingService.class);
    when(assessmentRatingService.store(Mockito.<SaveAssessmentRatingCommand>any(), Mockito.<String>any()))
        .thenThrow(new InsufficientPrivelegeException("An error occurred"));
    AssessmentHelper assessmentHelper = new AssessmentHelper();
    ReflectionTestUtils.setField(assessmentHelper, "ratingService", assessmentRatingService);
    ReflectionTestUtils.setField(assessmentHelper, "dsl", mock(DSLContext.class));
    ReflectionTestUtils.setField(assessmentHelper, "definitionService", mock(AssessmentDefinitionService.class));

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class,
        () -> assessmentHelper.createAssessment(1L, mock(EntityReference.class), 1L, "janedoe"));
    verify(assessmentRatingService).store(isA(SaveAssessmentRatingCommand.class), eq("janedoe"));
  }

  /**
   * Method under test: {@link AssessmentHelper#updateDefinitionReadOnly(long)}
   */
  @Test
  void testUpdateDefinitionReadOnly() throws DataAccessException {
    // Arrange
    AssessmentHelper assessmentHelper = new AssessmentHelper();
    ReflectionTestUtils.setField(assessmentHelper, "ratingService", mock(AssessmentRatingService.class));
    UpdateConditionStep<AssessmentDefinitionRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<AssessmentDefinitionRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<AssessmentDefinitionRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DSLContext dslContext = mock(DSLContext.class);
    when(dslContext.update(Mockito.<Table<AssessmentDefinitionRecord>>any())).thenReturn(updateSetFirstStep);
    ReflectionTestUtils.setField(assessmentHelper, "dsl", dslContext);
    ReflectionTestUtils.setField(assessmentHelper, "definitionService", mock(AssessmentDefinitionService.class));

    // Act
    assessmentHelper.updateDefinitionReadOnly(1L);

    // Assert
    verify(dslContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Method under test:
   * {@link AssessmentHelper#updateRatingReadOnly(EntityReference, long)}
   */
  @Test
  void testUpdateRatingReadOnly() throws DataAccessException {
    // Arrange
    AssessmentHelper assessmentHelper = new AssessmentHelper();
    ReflectionTestUtils.setField(assessmentHelper, "ratingService", mock(AssessmentRatingService.class));
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DSLContext dslContext = mock(DSLContext.class);
    when(dslContext.update(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(updateSetFirstStep);
    ReflectionTestUtils.setField(assessmentHelper, "dsl", dslContext);
    ReflectionTestUtils.setField(assessmentHelper, "definitionService", mock(AssessmentDefinitionService.class));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    assessmentHelper.updateRatingReadOnly(ref, 1L);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(dslContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Method under test: {@link AssessmentHelper#setDefExtId(long, String)}
   */
  @Test
  void testSetDefExtId() throws DataAccessException {
    // Arrange
    AssessmentHelper assessmentHelper = new AssessmentHelper();
    ReflectionTestUtils.setField(assessmentHelper, "ratingService", mock(AssessmentRatingService.class));
    UpdateConditionStep<AssessmentDefinitionRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<AssessmentDefinitionRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<AssessmentDefinitionRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DSLContext dslContext = mock(DSLContext.class);
    when(dslContext.update(Mockito.<Table<AssessmentDefinitionRecord>>any())).thenReturn(updateSetFirstStep);
    ReflectionTestUtils.setField(assessmentHelper, "dsl", dslContext);
    ReflectionTestUtils.setField(assessmentHelper, "definitionService", mock(AssessmentDefinitionService.class));

    // Act
    assessmentHelper.setDefExtId(1L, "42");

    // Assert
    verify(dslContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }
}
