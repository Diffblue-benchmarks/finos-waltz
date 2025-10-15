package org.finos.waltz.jobs.generators;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.finos.waltz.schema.tables.records.MeasurableCategoryRecord;
import org.finos.waltz.schema.tables.records.MeasurableRatingRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.SelectWhereStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

class MeasurableGeneratorDiffblueTest {
  /**
   * Test {@link MeasurableGenerator#remove(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetchAny()} return {@code
   *       null}.
   *   <li>Then calls {@link InsertSetMoreStep#set(Field, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableGenerator#remove(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test remove(ApplicationContext); given SelectConditionStep fetchAny() return 'null'; then calls set(Field, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableGenerator.remove(ApplicationContext)"})
  void testRemove_givenSelectConditionStepFetchAnyReturnNull_thenCallsSet()
      throws DataAccessException, BeansException {
    // Arrange
    MeasurableGenerator measurableGenerator = new MeasurableGenerator("Category");

    MeasurableCategoryRecord measurableCategoryRecord = mock(MeasurableCategoryRecord.class);
    when(measurableCategoryRecord.getId()).thenReturn(1L);

    SelectConditionStep<MeasurableCategoryRecord> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchAny()).thenReturn(null);
    when(selectConditionStep.fetchOne()).thenReturn(measurableCategoryRecord);

    SelectWhereStep<MeasurableCategoryRecord> selectWhereStep = mock(SelectWhereStep.class);
    when(selectWhereStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    InsertSetMoreStep<MeasurableCategoryRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);

    InsertSetMoreStep<MeasurableCategoryRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<MeasurableCategoryRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetMoreStep<MeasurableCategoryRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    InsertSetMoreStep<MeasurableCategoryRecord> insertSetMoreStep5 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep4);

    InsertSetStep<MeasurableCategoryRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep5);

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.fetch(Mockito.<Field<Object>>any())).thenReturn(new ArrayList<>());

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<MeasurableRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DefaultDSLContext defaultDSLContext = mock(DefaultDSLContext.class);
    when(defaultDSLContext.deleteFrom(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(deleteUsingStep);
    when(defaultDSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);
    when(defaultDSLContext.insertInto(Mockito.<Table<Record>>any()))
        .thenReturn(mock(InsertSetStep.class));
    when(defaultDSLContext.insertInto(Mockito.<Table<MeasurableCategoryRecord>>any()))
        .thenReturn(insertSetStep);
    when(defaultDSLContext.selectFrom(Mockito.<Table<MeasurableCategoryRecord>>any()))
        .thenReturn(selectWhereStep);

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any())).thenReturn(defaultDSLContext);

    // Act
    boolean actualRemoveResult = measurableGenerator.remove(ctx);

    // Assert
    verify(measurableCategoryRecord).getId();
    verify(deleteUsingStep, atLeast(1)).where(Mockito.<Condition>any());
    verify(insertSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).execute();
    verify(deleteConditionStep, atLeast(1)).execute();
    verify(selectConditionStep2).fetch(isA(Field.class));
    verify(selectConditionStep).fetchAny();
    verify(selectConditionStep).fetchOne();
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(selectWhereStep).where(isA(Condition.class));
    verify(defaultDSLContext, atLeast(1)).deleteFrom(Mockito.<Table<Record>>any());
    verify(defaultDSLContext, atLeast(1)).insertInto(isA(Table.class));
    verify(defaultDSLContext).select(isA(SelectField.class));
    verify(defaultDSLContext).selectFrom(isA(Table.class));
    verify(ctx).getBean(isA(Class.class));
    assertTrue(actualRemoveResult);
  }
}
