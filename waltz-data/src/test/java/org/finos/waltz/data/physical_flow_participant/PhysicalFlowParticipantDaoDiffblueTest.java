package org.finos.waltz.data.physical_flow_participant;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.physical_flow_participant.ParticipationKind;
import org.finos.waltz.schema.tables.records.PhysicalFlowParticipantRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PhysicalFlowParticipantDaoDiffblueTest {
  /**
   * Method under test:
   * {@link PhysicalFlowParticipantDao#remove(long, ParticipationKind, EntityReference)}
   */
  @Test
  void testRemove() throws DataAccessException {
    // Arrange
    DeleteConditionStep<PhysicalFlowParticipantRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<PhysicalFlowParticipantRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteConditionStep<PhysicalFlowParticipantRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DeleteConditionStep<PhysicalFlowParticipantRecord> deleteConditionStep4 = mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    DeleteUsingStep<PhysicalFlowParticipantRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<PhysicalFlowParticipantRecord>>any())).thenReturn(deleteUsingStep);
    PhysicalFlowParticipantDao physicalFlowParticipantDao = new PhysicalFlowParticipantDao(dsl);
    EntityReference participant = mock(EntityReference.class);
    when(participant.id()).thenReturn(1L);
    when(participant.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualRemoveResult = physicalFlowParticipantDao.remove(1L, ParticipationKind.SOURCE, participant);

    // Assert
    verify(participant).id();
    verify(participant).kind();
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowParticipantDao#remove(long, ParticipationKind, EntityReference)}
   */
  @Test
  void testRemove2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<PhysicalFlowParticipantRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);
    DeleteConditionStep<PhysicalFlowParticipantRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteConditionStep<PhysicalFlowParticipantRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DeleteConditionStep<PhysicalFlowParticipantRecord> deleteConditionStep4 = mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    DeleteUsingStep<PhysicalFlowParticipantRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<PhysicalFlowParticipantRecord>>any())).thenReturn(deleteUsingStep);
    PhysicalFlowParticipantDao physicalFlowParticipantDao = new PhysicalFlowParticipantDao(dsl);
    EntityReference participant = mock(EntityReference.class);
    when(participant.id()).thenReturn(1L);
    when(participant.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualRemoveResult = physicalFlowParticipantDao.remove(1L, ParticipationKind.SOURCE, participant);

    // Assert
    verify(participant).id();
    verify(participant).kind();
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowParticipantDao#add(long, ParticipationKind, EntityReference, String)}
   */
  @Test
  void testAdd() throws DataAccessException {
    // Arrange
    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);
    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep);
    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep2);
    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep3);
    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep5 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep4);
    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep6 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep5);
    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep7 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep6);
    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep8 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep7);
    InsertSetStep<PhysicalFlowParticipantRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep8);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<PhysicalFlowParticipantRecord>>any())).thenReturn(insertSetStep);
    PhysicalFlowParticipantDao physicalFlowParticipantDao = new PhysicalFlowParticipantDao(dsl);
    EntityReference participant = mock(EntityReference.class);
    when(participant.id()).thenReturn(1L);
    when(participant.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualAddResult = physicalFlowParticipantDao.add(1L, ParticipationKind.SOURCE, participant, "janedoe");

    // Assert
    verify(participant).id();
    verify(participant).kind();
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep8).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep7).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).execute();
    assertTrue(actualAddResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowParticipantDao#add(long, ParticipationKind, EntityReference, String)}
   */
  @Test
  void testAdd2() throws DataAccessException {
    // Arrange
    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(0);
    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep);
    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep2);
    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep3);
    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep5 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep4);
    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep6 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep5);
    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep7 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep6);
    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep8 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep7);
    InsertSetStep<PhysicalFlowParticipantRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep8);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<PhysicalFlowParticipantRecord>>any())).thenReturn(insertSetStep);
    PhysicalFlowParticipantDao physicalFlowParticipantDao = new PhysicalFlowParticipantDao(dsl);
    EntityReference participant = mock(EntityReference.class);
    when(participant.id()).thenReturn(1L);
    when(participant.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualAddResult = physicalFlowParticipantDao.add(1L, ParticipationKind.SOURCE, participant, "janedoe");

    // Assert
    verify(participant).id();
    verify(participant).kind();
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep8).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep7).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).execute();
    assertFalse(actualAddResult);
  }
}
