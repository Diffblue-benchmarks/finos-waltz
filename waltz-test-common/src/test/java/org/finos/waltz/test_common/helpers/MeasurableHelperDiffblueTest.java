package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.measurable_category.MeasurableCategory;
import org.finos.waltz.schema.tables.records.AccessLogRecord;
import org.finos.waltz.schema.tables.records.MeasurableCategoryRecord;
import org.finos.waltz.schema.tables.records.MeasurableRatingRecord;
import org.finos.waltz.schema.tables.records.MeasurableRecord;
import org.finos.waltz.service.measurable_category.MeasurableCategoryService;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

class MeasurableHelperDiffblueTest {
  /**
   * Method under test: {@link MeasurableHelper#createMeasurableCategory(String)}
   */
  @Test
  void testCreateMeasurableCategory() {
    // Arrange
    MeasurableHelper measurableHelper = new MeasurableHelper();
    ReflectionTestUtils.setField(measurableHelper, "ratingSchemeHelper", mock(RatingSchemeHelper.class));
    DSLContext dslContext = mock(DSLContext.class);
    when(dslContext.newRecord(Mockito.<Table<Record>>any())).thenReturn(new AccessLogRecord());
    when(dslContext.newRecord(Mockito.<Table<MeasurableCategoryRecord>>any()))
        .thenReturn(mock(MeasurableCategoryRecord.class));
    ReflectionTestUtils.setField(measurableHelper, "dsl", dslContext);
    MeasurableCategory measurableCategory = mock(MeasurableCategory.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(measurableCategory.id()).thenReturn(ofResult);

    HashSet<MeasurableCategory> measurableCategorySet = new HashSet<>();
    measurableCategorySet.add(measurableCategory);
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    when(measurableCategoryService.findByExternalId(Mockito.<String>any())).thenReturn(measurableCategorySet);
    ReflectionTestUtils.setField(measurableHelper, "categoryService", measurableCategoryService);

    // Act
    long actualCreateMeasurableCategoryResult = measurableHelper.createMeasurableCategory("Name");

    // Assert
    verify(measurableCategory).id();
    verify(measurableCategoryService).findByExternalId(eq("Name"));
    verify(dslContext).newRecord(Mockito.<Table<Record>>any());
    assertEquals(1L, actualCreateMeasurableCategoryResult);
  }

  /**
   * Method under test:
   * {@link MeasurableHelper#createMeasurableCategory(String, String)}
   */
  @Test
  void testCreateMeasurableCategory2() {
    // Arrange
    MeasurableHelper measurableHelper = new MeasurableHelper();
    ReflectionTestUtils.setField(measurableHelper, "ratingSchemeHelper", mock(RatingSchemeHelper.class));
    DSLContext dslContext = mock(DSLContext.class);
    when(dslContext.newRecord(Mockito.<Table<Record>>any())).thenReturn(new AccessLogRecord());
    when(dslContext.newRecord(Mockito.<Table<MeasurableCategoryRecord>>any()))
        .thenReturn(mock(MeasurableCategoryRecord.class));
    ReflectionTestUtils.setField(measurableHelper, "dsl", dslContext);
    MeasurableCategory measurableCategory = mock(MeasurableCategory.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(measurableCategory.id()).thenReturn(ofResult);

    HashSet<MeasurableCategory> measurableCategorySet = new HashSet<>();
    measurableCategorySet.add(measurableCategory);
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    when(measurableCategoryService.findByExternalId(Mockito.<String>any())).thenReturn(measurableCategorySet);
    ReflectionTestUtils.setField(measurableHelper, "categoryService", measurableCategoryService);

    // Act
    long actualCreateMeasurableCategoryResult = measurableHelper.createMeasurableCategory("Name", "Rating Editor Role");

    // Assert
    verify(measurableCategory).id();
    verify(measurableCategoryService).findByExternalId(eq("Name"));
    verify(dslContext).newRecord(Mockito.<Table<Record>>any());
    assertEquals(1L, actualCreateMeasurableCategoryResult);
  }

  /**
   * Method under test: {@link MeasurableHelper#updateCategoryNotEditable(long)}
   */
  @Test
  void testUpdateCategoryNotEditable() throws DataAccessException {
    // Arrange
    MeasurableHelper measurableHelper = new MeasurableHelper();
    ReflectionTestUtils.setField(measurableHelper, "ratingSchemeHelper", mock(RatingSchemeHelper.class));
    UpdateConditionStep<MeasurableCategoryRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<MeasurableCategoryRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<MeasurableCategoryRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DSLContext dslContext = mock(DSLContext.class);
    when(dslContext.update(Mockito.<Table<MeasurableCategoryRecord>>any())).thenReturn(updateSetFirstStep);
    ReflectionTestUtils.setField(measurableHelper, "dsl", dslContext);
    ReflectionTestUtils.setField(measurableHelper, "categoryService", mock(MeasurableCategoryService.class));

    // Act
    measurableHelper.updateCategoryNotEditable(1L);

    // Assert
    verify(dslContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Method under test: {@link MeasurableHelper#createMeasurable(String, long)}
   */
  @Test
  void testCreateMeasurable() throws DataAccessException {
    // Arrange
    MeasurableHelper measurableHelper = new MeasurableHelper();
    ReflectionTestUtils.setField(measurableHelper, "ratingSchemeHelper", mock(RatingSchemeHelper.class));
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    Optional<Object> ofResult = Optional.<Object>of(1L);
    when(selectConditionStep.fetchOptional(Mockito.<Field<Object>>any())).thenReturn(ofResult);
    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);
    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<Object>>any())).thenReturn(selectJoinStep);
    DSLContext dslContext = mock(DSLContext.class);
    when(dslContext.newRecord(Mockito.<Table<Record>>any())).thenReturn(new AccessLogRecord());
    when(dslContext.newRecord(Mockito.<Table<MeasurableRecord>>any())).thenReturn(new MeasurableRecord());
    when(dslContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);
    ReflectionTestUtils.setField(measurableHelper, "dsl", dslContext);
    ReflectionTestUtils.setField(measurableHelper, "categoryService", mock(MeasurableCategoryService.class));

    // Act
    long actualCreateMeasurableResult = measurableHelper.createMeasurable("Name", 1L);

    // Assert
    verify(dslContext).newRecord(Mockito.<Table<Record>>any());
    verify(dslContext).select(isA(SelectField.class));
    verify(selectConditionStep).fetchOptional(isA(Field.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertEquals(1L, actualCreateMeasurableResult);
  }

  /**
   * Method under test:
   * {@link MeasurableHelper#createMeasurable(String, String, long)}
   */
  @Test
  void testCreateMeasurable2() throws DataAccessException {
    // Arrange
    MeasurableHelper measurableHelper = new MeasurableHelper();
    ReflectionTestUtils.setField(measurableHelper, "ratingSchemeHelper", mock(RatingSchemeHelper.class));
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    Optional<Object> ofResult = Optional.<Object>of(1L);
    when(selectConditionStep.fetchOptional(Mockito.<Field<Object>>any())).thenReturn(ofResult);
    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);
    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<Object>>any())).thenReturn(selectJoinStep);
    DSLContext dslContext = mock(DSLContext.class);
    when(dslContext.newRecord(Mockito.<Table<Record>>any())).thenReturn(new AccessLogRecord());
    when(dslContext.newRecord(Mockito.<Table<MeasurableRecord>>any())).thenReturn(new MeasurableRecord());
    when(dslContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);
    ReflectionTestUtils.setField(measurableHelper, "dsl", dslContext);
    ReflectionTestUtils.setField(measurableHelper, "categoryService", mock(MeasurableCategoryService.class));

    // Act
    long actualCreateMeasurableResult = measurableHelper.createMeasurable("42", "Name", 1L);

    // Assert
    verify(dslContext).newRecord(Mockito.<Table<Record>>any());
    verify(dslContext).select(isA(SelectField.class));
    verify(selectConditionStep).fetchOptional(isA(Field.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertEquals(1L, actualCreateMeasurableResult);
  }

  /**
   * Method under test:
   * {@link MeasurableHelper#updateMeasurableReadOnly(EntityReference, long)}
   */
  @Test
  void testUpdateMeasurableReadOnly() throws DataAccessException {
    // Arrange
    MeasurableHelper measurableHelper = new MeasurableHelper();
    ReflectionTestUtils.setField(measurableHelper, "ratingSchemeHelper", mock(RatingSchemeHelper.class));
    UpdateConditionStep<MeasurableRatingRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<MeasurableRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DSLContext dslContext = mock(DSLContext.class);
    when(dslContext.update(Mockito.<Table<MeasurableRatingRecord>>any())).thenReturn(updateSetFirstStep);
    ReflectionTestUtils.setField(measurableHelper, "dsl", dslContext);
    ReflectionTestUtils.setField(measurableHelper, "categoryService", mock(MeasurableCategoryService.class));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    measurableHelper.updateMeasurableReadOnly(ref, 1L);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(dslContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Method under test:
   * {@link MeasurableHelper#updateMeasurableLifecycleStatus(long, EntityLifecycleStatus)}
   */
  @Test
  void testUpdateMeasurableLifecycleStatus() throws DataAccessException {
    // Arrange
    MeasurableHelper measurableHelper = new MeasurableHelper();
    ReflectionTestUtils.setField(measurableHelper, "ratingSchemeHelper", mock(RatingSchemeHelper.class));
    UpdateConditionStep<MeasurableRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DSLContext dslContext = mock(DSLContext.class);
    when(dslContext.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);
    ReflectionTestUtils.setField(measurableHelper, "dsl", dslContext);
    ReflectionTestUtils.setField(measurableHelper, "categoryService", mock(MeasurableCategoryService.class));

    // Act
    int actualUpdateMeasurableLifecycleStatusResult = measurableHelper.updateMeasurableLifecycleStatus(1L,
        EntityLifecycleStatus.ACTIVE);

    // Assert
    verify(dslContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateMeasurableLifecycleStatusResult);
  }
}
