package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class MeasurableHelperDiffblueTest {
  @Mock
  private DSLContext dSLContext;

  @InjectMocks
  private MeasurableHelper measurableHelper;

  @Mock
  private MeasurableCategoryService measurableCategoryService;

  /**
   * Test {@link MeasurableHelper#createMeasurableCategory(String, String)} with {@code name}, {@code ratingEditorRole}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurableHelper#createMeasurableCategory(String, String)}
   */
  @Test
  @DisplayName("Test createMeasurableCategory(String, String) with 'name', 'ratingEditorRole'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long MeasurableHelper.createMeasurableCategory(String, String)"})
  void testCreateMeasurableCategoryWithNameRatingEditorRole_thenReturnOne() {
    // Arrange
    MeasurableCategory measurableCategory = mock(MeasurableCategory.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(measurableCategory.id()).thenReturn(ofResult);

    HashSet<MeasurableCategory> measurableCategorySet = new HashSet<>();
    measurableCategorySet.add(measurableCategory);
    when(measurableCategoryService.findByExternalId(Mockito.<String>any())).thenReturn(measurableCategorySet);
    when(dSLContext.newRecord(Mockito.<Table<Record>>any())).thenReturn(new AccessLogRecord());
    when(dSLContext.newRecord(Mockito.<Table<MeasurableCategoryRecord>>any()))
        .thenReturn(new MeasurableCategoryRecord());

    // Act
    long actualCreateMeasurableCategoryResult = measurableHelper.createMeasurableCategory("Name", "Rating Editor Role");

    // Assert
    verify(measurableCategory).id();
    verify(measurableCategoryService).findByExternalId(eq("Name"));
    verify(dSLContext).newRecord(Mockito.<Table<Record>>any());
    assertEquals(1L, actualCreateMeasurableCategoryResult);
  }

  /**
   * Test {@link MeasurableHelper#createMeasurableCategory(String)} with {@code name}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurableHelper#createMeasurableCategory(String)}
   */
  @Test
  @DisplayName("Test createMeasurableCategory(String) with 'name'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long MeasurableHelper.createMeasurableCategory(String)"})
  void testCreateMeasurableCategoryWithName_thenReturnOne() {
    // Arrange
    MeasurableCategory measurableCategory = mock(MeasurableCategory.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(measurableCategory.id()).thenReturn(ofResult);

    HashSet<MeasurableCategory> measurableCategorySet = new HashSet<>();
    measurableCategorySet.add(measurableCategory);
    when(measurableCategoryService.findByExternalId(Mockito.<String>any())).thenReturn(measurableCategorySet);
    when(dSLContext.newRecord(Mockito.<Table<Record>>any())).thenReturn(new AccessLogRecord());
    when(dSLContext.newRecord(Mockito.<Table<MeasurableCategoryRecord>>any()))
        .thenReturn(new MeasurableCategoryRecord());

    // Act
    long actualCreateMeasurableCategoryResult = measurableHelper.createMeasurableCategory("Name");

    // Assert
    verify(measurableCategory).id();
    verify(measurableCategoryService).findByExternalId(eq("Name"));
    verify(dSLContext).newRecord(Mockito.<Table<Record>>any());
    assertEquals(1L, actualCreateMeasurableCategoryResult);
  }

  /**
   * Test {@link MeasurableHelper#updateCategoryNotEditable(long)}.
   * <p>
   * Method under test: {@link MeasurableHelper#updateCategoryNotEditable(long)}
   */
  @Test
  @DisplayName("Test updateCategoryNotEditable(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MeasurableHelper.updateCategoryNotEditable(long)"})
  void testUpdateCategoryNotEditable() throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableCategoryRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<MeasurableCategoryRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<MeasurableCategoryRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<MeasurableCategoryRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    measurableHelper.updateCategoryNotEditable(1L);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableHelper#createMeasurable(String, String, long)} with {@code externalId}, {@code name}, {@code categoryId}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurableHelper#createMeasurable(String, String, long)}
   */
  @Test
  @DisplayName("Test createMeasurable(String, String, long) with 'externalId', 'name', 'categoryId'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long MeasurableHelper.createMeasurable(String, String, long)"})
  void testCreateMeasurableWithExternalIdNameCategoryId_thenReturnOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    Optional<Object> ofResult = Optional.<Object>of(1L);
    when(selectConditionStep.fetchOptional(Mockito.<Field<Object>>any())).thenReturn(ofResult);
    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);
    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<Object>>any())).thenReturn(selectJoinStep);
    when(dSLContext.newRecord(Mockito.<Table<Record>>any())).thenReturn(new AccessLogRecord());
    when(dSLContext.newRecord(Mockito.<Table<MeasurableRecord>>any())).thenReturn(new MeasurableRecord());
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    long actualCreateMeasurableResult = measurableHelper.createMeasurable("42", "Name", 1L);

    // Assert
    verify(dSLContext).newRecord(Mockito.<Table<Record>>any());
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep).fetchOptional(isA(Field.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertEquals(1L, actualCreateMeasurableResult);
  }

  /**
   * Test {@link MeasurableHelper#createMeasurable(String, long)} with {@code name}, {@code categoryId}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurableHelper#createMeasurable(String, long)}
   */
  @Test
  @DisplayName("Test createMeasurable(String, long) with 'name', 'categoryId'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long MeasurableHelper.createMeasurable(String, long)"})
  void testCreateMeasurableWithNameCategoryId_thenReturnOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    Optional<Object> ofResult = Optional.<Object>of(1L);
    when(selectConditionStep.fetchOptional(Mockito.<Field<Object>>any())).thenReturn(ofResult);
    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);
    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<Object>>any())).thenReturn(selectJoinStep);
    when(dSLContext.newRecord(Mockito.<Table<Record>>any())).thenReturn(new AccessLogRecord());
    when(dSLContext.newRecord(Mockito.<Table<MeasurableRecord>>any())).thenReturn(new MeasurableRecord());
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    long actualCreateMeasurableResult = measurableHelper.createMeasurable("Name", 1L);

    // Assert
    verify(dSLContext).newRecord(Mockito.<Table<Record>>any());
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep).fetchOptional(isA(Field.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertEquals(1L, actualCreateMeasurableResult);
  }

  /**
   * Test {@link MeasurableHelper#createMeasurable(String, long)} with {@code name}, {@code categoryId}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurableHelper#createMeasurable(String, long)}
   */
  @Test
  @DisplayName("Test createMeasurable(String, long) with 'name', 'categoryId'; when 'null'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long MeasurableHelper.createMeasurable(String, long)"})
  void testCreateMeasurableWithNameCategoryId_whenNull_thenReturnOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    Optional<Object> ofResult = Optional.<Object>of(1L);
    when(selectConditionStep.fetchOptional(Mockito.<Field<Object>>any())).thenReturn(ofResult);
    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);
    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<Object>>any())).thenReturn(selectJoinStep);
    when(dSLContext.newRecord(Mockito.<Table<Record>>any())).thenReturn(new AccessLogRecord());
    when(dSLContext.newRecord(Mockito.<Table<MeasurableRecord>>any())).thenReturn(new MeasurableRecord());
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    long actualCreateMeasurableResult = measurableHelper.createMeasurable(null, 1L);

    // Assert
    verify(dSLContext).newRecord(Mockito.<Table<Record>>any());
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep).fetchOptional(isA(Field.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertEquals(1L, actualCreateMeasurableResult);
  }

  /**
   * Test {@link MeasurableHelper#updateMeasurableReadOnly(EntityReference, long)}.
   * <ul>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurableHelper#updateMeasurableReadOnly(EntityReference, long)}
   */
  @Test
  @DisplayName("Test updateMeasurableReadOnly(EntityReference, long); then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MeasurableHelper.updateMeasurableReadOnly(EntityReference, long)"})
  void testUpdateMeasurableReadOnly_thenCallsId() throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableRatingRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<MeasurableRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<MeasurableRatingRecord>>any())).thenReturn(updateSetFirstStep);
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    measurableHelper.updateMeasurableReadOnly(ref, 1L);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableHelper#updateMeasurableLifecycleStatus(long, EntityLifecycleStatus)}.
   * <p>
   * Method under test: {@link MeasurableHelper#updateMeasurableLifecycleStatus(long, EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test updateMeasurableLifecycleStatus(long, EntityLifecycleStatus)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int MeasurableHelper.updateMeasurableLifecycleStatus(long, EntityLifecycleStatus)"})
  void testUpdateMeasurableLifecycleStatus() throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateMeasurableLifecycleStatusResult = measurableHelper.updateMeasurableLifecycleStatus(1L,
        EntityLifecycleStatus.ACTIVE);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateMeasurableLifecycleStatusResult);
  }
}
