package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.schema.tables.records.AccessLogRecord;
import org.finos.waltz.schema.tables.records.MeasurableRatingRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Select;
import org.jooq.Table;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

class MeasurableRatingHelperDiffblueTest {
  /**
   * Method under test:
   * {@link MeasurableRatingHelper#saveRatingItem(EntityReference, long, String, String)}
   */
  @Test
  void testSaveRatingItem() throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableRatingRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<MeasurableRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DSLContext dslContext = mock(DSLContext.class);
    when(dslContext.newRecord(Mockito.<Table<Record>>any())).thenReturn(new AccessLogRecord());
    when(dslContext.update(Mockito.<Table<MeasurableRatingRecord>>any())).thenReturn(updateSetFirstStep);
    when(dslContext.fetchExists(Mockito.<Select<Object>>any())).thenReturn(true);
    when(dslContext.newRecord(Mockito.<Table<MeasurableRatingRecord>>any())).thenReturn(new MeasurableRatingRecord());
    MeasurableRatingHelper measurableRatingHelper = new MeasurableRatingHelper();
    ReflectionTestUtils.setField(measurableRatingHelper, "dsl", dslContext);
    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);
    when(entityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualSaveRatingItemResult = measurableRatingHelper.saveRatingItem(entityRef, 1L, "Rating Code", "janedoe");

    // Assert
    verify(entityRef, atLeast(1)).id();
    verify(entityRef, atLeast(1)).kind();
    verify(dslContext).fetchExists(isA(Select.class));
    verify(dslContext).newRecord(Mockito.<Table<Record>>any());
    verify(dslContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertTrue(actualSaveRatingItemResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingHelper#saveRatingItem(EntityReference, long, String, String)}
   */
  @Test
  void testSaveRatingItem2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableRatingRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(12);
    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<MeasurableRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DSLContext dslContext = mock(DSLContext.class);
    when(dslContext.newRecord(Mockito.<Table<Record>>any())).thenReturn(new AccessLogRecord());
    when(dslContext.update(Mockito.<Table<MeasurableRatingRecord>>any())).thenReturn(updateSetFirstStep);
    when(dslContext.fetchExists(Mockito.<Select<Object>>any())).thenReturn(true);
    when(dslContext.newRecord(Mockito.<Table<MeasurableRatingRecord>>any())).thenReturn(new MeasurableRatingRecord());
    MeasurableRatingHelper measurableRatingHelper = new MeasurableRatingHelper();
    ReflectionTestUtils.setField(measurableRatingHelper, "dsl", dslContext);
    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);
    when(entityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualSaveRatingItemResult = measurableRatingHelper.saveRatingItem(entityRef, 1L, "Rating Code", "janedoe");

    // Assert
    verify(entityRef, atLeast(1)).id();
    verify(entityRef, atLeast(1)).kind();
    verify(dslContext).fetchExists(isA(Select.class));
    verify(dslContext).newRecord(Mockito.<Table<Record>>any());
    verify(dslContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertFalse(actualSaveRatingItemResult);
  }
}
