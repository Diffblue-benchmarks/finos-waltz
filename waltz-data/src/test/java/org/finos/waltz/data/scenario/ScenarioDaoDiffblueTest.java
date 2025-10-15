package org.finos.waltz.data.scenario;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.scenario.Scenario;
import org.finos.waltz.model.scenario.ScenarioType;
import org.finos.waltz.schema.tables.records.ScenarioRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.OrderField;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSeekStep2;
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
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ScenarioDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private ScenarioDao scenarioDao;

  /**
   * Test {@link ScenarioDao#findForRoadmapId(long)}.
   *
   * <p>Method under test: {@link ScenarioDao#findForRoadmapId(long)}
   */
  @Test
  @DisplayName("Test findForRoadmapId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ScenarioDao.findForRoadmapId(long)"})
  void testFindForRoadmapId() throws DataAccessException {
    // Arrange
    SelectSeekStep2<Record, Object, Object> selectSeekStep2 = mock(SelectSeekStep2.class);
    ArrayList<Object> objectList = new ArrayList<>();
    when(selectSeekStep2.fetch(Mockito.<RecordMapper<Record, Object>>any())).thenReturn(objectList);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(
            Mockito.<OrderField<Object>>any(), Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep2);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Collection<Scenario> actualFindForRoadmapIdResult = scenarioDao.findForRoadmapId(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep2).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class), isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForRoadmapIdResult instanceof List);
    assertTrue(actualFindForRoadmapIdResult.isEmpty());
    assertSame(objectList, actualFindForRoadmapIdResult);
  }

  /**
   * Test {@link ScenarioDao#updateName(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioDao#updateName(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String, String); given UpdateConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioDao.updateName(long, String, String)"})
  void testUpdateName_givenUpdateConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<ScenarioRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<ScenarioRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<ScenarioRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    Boolean actualUpdateNameResult = scenarioDao.updateName(1L, "42", "42");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertTrue(actualUpdateNameResult);
  }

  /**
   * Test {@link ScenarioDao#updateName(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioDao#updateName(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String, String); given UpdateConditionStep execute() return zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioDao.updateName(long, String, String)"})
  void testUpdateName_givenUpdateConditionStepExecuteReturnZero_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<ScenarioRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(0);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<ScenarioRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<ScenarioRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    Boolean actualUpdateNameResult = scenarioDao.updateName(1L, "42", "42");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertFalse(actualUpdateNameResult);
  }

  /**
   * Test {@link ScenarioDao#updateDescription(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioDao#updateDescription(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String, String); given UpdateConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioDao.updateDescription(long, String, String)"})
  void testUpdateDescription_givenUpdateConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<ScenarioRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<ScenarioRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<ScenarioRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    Boolean actualUpdateDescriptionResult = scenarioDao.updateDescription(1L, "42", "42");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertTrue(actualUpdateDescriptionResult);
  }

  /**
   * Test {@link ScenarioDao#updateDescription(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioDao#updateDescription(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String, String); given UpdateConditionStep execute() return zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioDao.updateDescription(long, String, String)"})
  void testUpdateDescription_givenUpdateConditionStepExecuteReturnZero_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<ScenarioRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(0);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<ScenarioRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<ScenarioRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    Boolean actualUpdateDescriptionResult = scenarioDao.updateDescription(1L, "42", "42");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertFalse(actualUpdateDescriptionResult);
  }

  /**
   * Test {@link ScenarioDao#updateEffectiveDate(long, LocalDate, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioDao#updateEffectiveDate(long, LocalDate, String)}
   */
  @Test
  @DisplayName(
      "Test updateEffectiveDate(long, LocalDate, String); given UpdateConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioDao.updateEffectiveDate(long, LocalDate, String)"})
  void testUpdateEffectiveDate_givenUpdateConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<ScenarioRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<ScenarioRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<ScenarioRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    Boolean actualUpdateEffectiveDateResult =
        scenarioDao.updateEffectiveDate(1L, LocalDate.of(1970, 1, 1), "42");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertTrue(actualUpdateEffectiveDateResult);
  }

  /**
   * Test {@link ScenarioDao#updateEffectiveDate(long, LocalDate, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioDao#updateEffectiveDate(long, LocalDate, String)}
   */
  @Test
  @DisplayName("Test updateEffectiveDate(long, LocalDate, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioDao.updateEffectiveDate(long, LocalDate, String)"})
  void testUpdateEffectiveDate_thenReturnFalse() throws DataAccessException {
    // Arrange
    UpdateConditionStep<ScenarioRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(0);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<ScenarioRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<ScenarioRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    Boolean actualUpdateEffectiveDateResult =
        scenarioDao.updateEffectiveDate(1L, LocalDate.of(1970, 1, 1), "42");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertFalse(actualUpdateEffectiveDateResult);
  }

  /**
   * Test {@link ScenarioDao#updateEffectiveDate(long, LocalDate, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioDao#updateEffectiveDate(long, LocalDate, String)}
   */
  @Test
  @DisplayName("Test updateEffectiveDate(long, LocalDate, String); when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioDao.updateEffectiveDate(long, LocalDate, String)"})
  void testUpdateEffectiveDate_whenNull_thenReturnTrue() throws DataAccessException {
    // Arrange
    UpdateConditionStep<ScenarioRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<ScenarioRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<ScenarioRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    Boolean actualUpdateEffectiveDateResult = scenarioDao.updateEffectiveDate(1L, null, "42");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertTrue(actualUpdateEffectiveDateResult);
  }

  /**
   * Test {@link ScenarioDao#updateEntityLifecycleStatus(long, EntityLifecycleStatus, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioDao#updateEntityLifecycleStatus(long,
   * EntityLifecycleStatus, String)}
   */
  @Test
  @DisplayName(
      "Test updateEntityLifecycleStatus(long, EntityLifecycleStatus, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ScenarioDao.updateEntityLifecycleStatus(long, EntityLifecycleStatus, String)"
  })
  void testUpdateEntityLifecycleStatus_thenReturnFalse() throws DataAccessException {
    // Arrange
    UpdateConditionStep<ScenarioRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(0);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<ScenarioRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<ScenarioRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    Boolean actualUpdateEntityLifecycleStatusResult =
        scenarioDao.updateEntityLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE, "42");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertFalse(actualUpdateEntityLifecycleStatusResult);
  }

  /**
   * Test {@link ScenarioDao#updateEntityLifecycleStatus(long, EntityLifecycleStatus, String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioDao#updateEntityLifecycleStatus(long,
   * EntityLifecycleStatus, String)}
   */
  @Test
  @DisplayName(
      "Test updateEntityLifecycleStatus(long, EntityLifecycleStatus, String); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ScenarioDao.updateEntityLifecycleStatus(long, EntityLifecycleStatus, String)"
  })
  void testUpdateEntityLifecycleStatus_thenReturnTrue() throws DataAccessException {
    // Arrange
    UpdateConditionStep<ScenarioRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<ScenarioRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<ScenarioRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    Boolean actualUpdateEntityLifecycleStatusResult =
        scenarioDao.updateEntityLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE, "42");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertTrue(actualUpdateEntityLifecycleStatusResult);
  }

  /**
   * Test {@link ScenarioDao#updateReleaseStatus(long, ReleaseLifecycleStatus, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioDao#updateReleaseStatus(long, ReleaseLifecycleStatus,
   * String)}
   */
  @Test
  @DisplayName(
      "Test updateReleaseStatus(long, ReleaseLifecycleStatus, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ScenarioDao.updateReleaseStatus(long, ReleaseLifecycleStatus, String)"
  })
  void testUpdateReleaseStatus_thenReturnFalse() throws DataAccessException {
    // Arrange
    ScenarioRecord scenarioRecord = mock(ScenarioRecord.class);
    when(scenarioRecord.getReleaseStatus()).thenReturn("DRAFT");
    when(dSLContext.fetchOne(Mockito.<Table<ScenarioRecord>>any(), Mockito.<Condition>any()))
        .thenReturn(scenarioRecord);

    // Act
    Boolean actualUpdateReleaseStatusResult =
        scenarioDao.updateReleaseStatus(1L, ReleaseLifecycleStatus.DRAFT, "42");

    // Assert
    verify(scenarioRecord).getReleaseStatus();
    verify(dSLContext).fetchOne(isA(Table.class), isA(Condition.class));
    assertFalse(actualUpdateReleaseStatusResult);
  }

  /**
   * Test {@link ScenarioDao#updateScenarioType(long, ScenarioType, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioDao#updateScenarioType(long, ScenarioType, String)}
   */
  @Test
  @DisplayName(
      "Test updateScenarioType(long, ScenarioType, String); given UpdateConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioDao.updateScenarioType(long, ScenarioType, String)"})
  void testUpdateScenarioType_givenUpdateConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<ScenarioRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<ScenarioRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<ScenarioRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    Boolean actualUpdateScenarioTypeResult =
        scenarioDao.updateScenarioType(1L, ScenarioType.TARGET, "42");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertTrue(actualUpdateScenarioTypeResult);
  }

  /**
   * Test {@link ScenarioDao#updateScenarioType(long, ScenarioType, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioDao#updateScenarioType(long, ScenarioType, String)}
   */
  @Test
  @DisplayName(
      "Test updateScenarioType(long, ScenarioType, String); given UpdateConditionStep execute() return zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioDao.updateScenarioType(long, ScenarioType, String)"})
  void testUpdateScenarioType_givenUpdateConditionStepExecuteReturnZero_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<ScenarioRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(0);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<ScenarioRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<ScenarioRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    Boolean actualUpdateScenarioTypeResult =
        scenarioDao.updateScenarioType(1L, ScenarioType.TARGET, "42");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertFalse(actualUpdateScenarioTypeResult);
  }

  /**
   * Test {@link ScenarioDao#removeScenario(long, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioDao#removeScenario(long, String)}
   */
  @Test
  @DisplayName(
      "Test removeScenario(long, String); given UpdateConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioDao.removeScenario(long, String)"})
  void testRemoveScenario_givenUpdateConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<ScenarioRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetFirstStep<ScenarioRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);
    when(dSLContext.update(Mockito.<Table<ScenarioRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    Boolean actualRemoveScenarioResult = scenarioDao.removeScenario(1L, "42");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertTrue(actualRemoveScenarioResult);
  }

  /**
   * Test {@link ScenarioDao#removeScenario(long, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioDao#removeScenario(long, String)}
   */
  @Test
  @DisplayName(
      "Test removeScenario(long, String); given UpdateConditionStep execute() return zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioDao.removeScenario(long, String)"})
  void testRemoveScenario_givenUpdateConditionStepExecuteReturnZero_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<ScenarioRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(0);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<ScenarioRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetFirstStep<ScenarioRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);
    when(dSLContext.update(Mockito.<Table<ScenarioRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    Boolean actualRemoveScenarioResult = scenarioDao.removeScenario(1L, "42");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertFalse(actualRemoveScenarioResult);
  }
}
