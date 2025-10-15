package org.finos.waltz.data.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.survey.ImmutableSurveyQuestion;
import org.finos.waltz.model.survey.ImmutableSurveyQuestion.Builder;
import org.finos.waltz.model.survey.SurveyQuestion;
import org.finos.waltz.model.survey.SurveyQuestionFieldType;
import org.finos.waltz.schema.tables.records.SurveyQuestionRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.InsertResultStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.OrderField;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.Select;
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
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SurveyQuestionDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private SurveyQuestionDao surveyQuestionDao;

  /**
   * Test {@link SurveyQuestionDao#findForTemplate(long)}.
   *
   * <p>Method under test: {@link SurveyQuestionDao#findForTemplate(long)}
   */
  @Test
  @DisplayName("Test findForTemplate(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyQuestionDao.findForTemplate(long)"})
  void testFindForTemplate() throws DataAccessException {
    // Arrange
    SelectSeekStep2<Record, Object, Object> selectSeekStep2 = mock(SelectSeekStep2.class);
    when(selectSeekStep2.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(
            Mockito.<OrderField<Object>>any(), Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<SurveyQuestion> actualFindForTemplateResult = surveyQuestionDao.findForTemplate(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep2).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class), isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForTemplateResult.isEmpty());
  }

  /**
   * Test {@link SurveyQuestionDao#findForSurveyRun(long)}.
   *
   * <p>Method under test: {@link SurveyQuestionDao#findForSurveyRun(long)}
   */
  @Test
  @DisplayName("Test findForSurveyRun(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyQuestionDao.findForSurveyRun(long)"})
  void testFindForSurveyRun() throws DataAccessException {
    // Arrange
    SelectSeekStep2<Record, Object, Object> selectSeekStep2 = mock(SelectSeekStep2.class);
    when(selectSeekStep2.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(
            Mockito.<OrderField<Object>>any(), Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<SurveyQuestion> actualFindForSurveyRunResult = surveyQuestionDao.findForSurveyRun(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep2).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class), isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForSurveyRunResult.isEmpty());
  }

  /**
   * Test {@link SurveyQuestionDao#findForSurveyInstance(long)}.
   *
   * <p>Method under test: {@link SurveyQuestionDao#findForSurveyInstance(long)}
   */
  @Test
  @DisplayName("Test findForSurveyInstance(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyQuestionDao.findForSurveyInstance(long)"})
  void testFindForSurveyInstance() throws DataAccessException {
    // Arrange
    SelectSeekStep2<Record, Object, Object> selectSeekStep2 = mock(SelectSeekStep2.class);
    when(selectSeekStep2.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(
            Mockito.<OrderField<Object>>any(), Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<SurveyQuestion> actualFindForSurveyInstanceResult =
        surveyQuestionDao.findForSurveyInstance(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep2).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class), isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForSurveyInstanceResult.isEmpty());
  }

  /**
   * Test {@link SurveyQuestionDao#create(SurveyQuestion)}.
   *
   * <p>Method under test: {@link SurveyQuestionDao#create(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test create(SurveyQuestion)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyQuestionDao.create(SurveyQuestion)"})
  void testCreate() throws DataAccessException {
    // Arrange
    InsertResultStep<SurveyQuestionRecord> insertResultStep = mock(InsertResultStep.class);
    SurveyQuestionRecord surveyQuestionRecord =
        new SurveyQuestionRecord(
            1L,
            1L,
            "surveyQuestion cannot be null",
            "surveyQuestion cannot be null",
            "surveyQuestion cannot be null",
            1,
            true,
            true,
            "surveyQuestion cannot be null",
            "42",
            "surveyQuestion cannot be null",
            1L,
            "surveyQuestion cannot be null",
            "42",
            "surveyQuestion cannot be null");
    when(insertResultStep.fetchOne()).thenReturn(surveyQuestionRecord);

    InsertSetMoreStep<SurveyQuestionRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<SurveyQuestionRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<SurveyQuestionRecord>>any()))
        .thenReturn(insertSetStep);

    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act
    long actualCreateResult =
        surveyQuestionDao.create(
            positionResult
                .qualifierEntity(qualifierEntity)
                .questionText("Question Text")
                .sectionName("Section Name")
                .surveyTemplateId(1L)
                .build());

    // Assert
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link SurveyQuestionDao#create(SurveyQuestion)}.
   *
   * <p>Method under test: {@link SurveyQuestionDao#create(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test create(SurveyQuestion)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyQuestionDao.create(SurveyQuestion)"})
  void testCreate2() throws DataAccessException {
    // Arrange
    SurveyQuestionRecord surveyQuestionRecord = mock(SurveyQuestionRecord.class);
    when(surveyQuestionRecord.getId()).thenReturn(1L);

    InsertResultStep<SurveyQuestionRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(surveyQuestionRecord);

    InsertSetMoreStep<SurveyQuestionRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<SurveyQuestionRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<SurveyQuestionRecord>>any()))
        .thenReturn(insertSetStep);

    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    Optional<? extends EntityReference> qualifierEntity = Optional.empty();

    // Act
    long actualCreateResult =
        surveyQuestionDao.create(
            positionResult
                .qualifierEntity(qualifierEntity)
                .questionText("Question Text")
                .sectionName("Section Name")
                .surveyTemplateId(1L)
                .build());

    // Assert
    verify(surveyQuestionRecord).getId();
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link SurveyQuestionDao#create(SurveyQuestion)}.
   *
   * <ul>
   *   <li>Given {@link SurveyQuestionRecord} {@link SurveyQuestionRecord#getId()} return one.
   *   <li>Then calls {@link SurveyQuestionRecord#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDao#create(SurveyQuestion)}
   */
  @Test
  @DisplayName(
      "Test create(SurveyQuestion); given SurveyQuestionRecord getId() return one; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyQuestionDao.create(SurveyQuestion)"})
  void testCreate_givenSurveyQuestionRecordGetIdReturnOne_thenCallsGetId()
      throws DataAccessException {
    // Arrange
    SurveyQuestionRecord surveyQuestionRecord = mock(SurveyQuestionRecord.class);
    when(surveyQuestionRecord.getId()).thenReturn(1L);

    InsertResultStep<SurveyQuestionRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(surveyQuestionRecord);

    InsertSetMoreStep<SurveyQuestionRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<SurveyQuestionRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<SurveyQuestionRecord>>any()))
        .thenReturn(insertSetStep);

    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act
    long actualCreateResult =
        surveyQuestionDao.create(
            positionResult
                .qualifierEntity(qualifierEntity)
                .questionText("Question Text")
                .sectionName("Section Name")
                .surveyTemplateId(1L)
                .build());

    // Assert
    verify(surveyQuestionRecord).getId();
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link SurveyQuestionDao#create(SurveyQuestion)}.
   *
   * <ul>
   *   <li>Then calls {@link SurveyQuestion#externalId()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDao#create(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test create(SurveyQuestion); then calls externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyQuestionDao.create(SurveyQuestion)"})
  void testCreate_thenCallsExternalId() throws DataAccessException {
    // Arrange
    InsertResultStep<SurveyQuestionRecord> insertResultStep = mock(InsertResultStep.class);
    SurveyQuestionRecord surveyQuestionRecord =
        new SurveyQuestionRecord(
            1L,
            1L,
            "surveyQuestion cannot be null",
            "surveyQuestion cannot be null",
            "surveyQuestion cannot be null",
            1,
            true,
            true,
            "surveyQuestion cannot be null",
            "42",
            "surveyQuestion cannot be null",
            1L,
            "surveyQuestion cannot be null",
            "42",
            "surveyQuestion cannot be null");
    when(insertResultStep.fetchOne()).thenReturn(surveyQuestionRecord);

    InsertSetMoreStep<SurveyQuestionRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<SurveyQuestionRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<SurveyQuestionRecord>>any()))
        .thenReturn(insertSetStep);

    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<String> ofResult = Optional.of("foo");
    when(surveyQuestion.externalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(surveyQuestion.inclusionPredicate()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(surveyQuestion.label()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(surveyQuestion.parentExternalId()).thenReturn(ofResult4);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult5 = Optional.of(immutableEntityReference);
    when(surveyQuestion.qualifierEntity()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(surveyQuestion.sectionName()).thenReturn(ofResult6);
    when(surveyQuestion.isMandatory()).thenReturn(true);
    when(surveyQuestion.allowComment()).thenReturn(true);
    when(surveyQuestion.position()).thenReturn(1);
    when(surveyQuestion.surveyTemplateId()).thenReturn(1L);
    when(surveyQuestion.questionText()).thenReturn("Question Text");
    Optional<String> ofResult7 = Optional.of("foo");
    when(surveyQuestion.helpText()).thenReturn(ofResult7);
    when(surveyQuestion.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);

    // Act
    long actualCreateResult = surveyQuestionDao.create(surveyQuestion);

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).allowComment();
    verify(surveyQuestion).fieldType();
    verify(surveyQuestion).helpText();
    verify(surveyQuestion).inclusionPredicate();
    verify(surveyQuestion).isMandatory();
    verify(surveyQuestion).label();
    verify(surveyQuestion).parentExternalId();
    verify(surveyQuestion).position();
    verify(surveyQuestion).qualifierEntity();
    verify(surveyQuestion).questionText();
    verify(surveyQuestion).sectionName();
    verify(surveyQuestion).surveyTemplateId();
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link SurveyQuestionDao#update(SurveyQuestion)}.
   *
   * <p>Method under test: {@link SurveyQuestionDao#update(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test update(SurveyQuestion)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionDao.update(SurveyQuestion)"})
  void testUpdate() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyQuestionRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyQuestionRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SurveyQuestionRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Record>any())).thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<SurveyQuestionRecord>>any()))
        .thenReturn(updateSetFirstStep);

    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act
    int actualUpdateResult =
        surveyQuestionDao.update(
            positionResult
                .qualifierEntity(qualifierEntity)
                .questionText("Question Text")
                .sectionName("Section Name")
                .surveyTemplateId(1L)
                .build());

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Record.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Test {@link SurveyQuestionDao#update(SurveyQuestion)}.
   *
   * <p>Method under test: {@link SurveyQuestionDao#update(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test update(SurveyQuestion)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionDao.update(SurveyQuestion)"})
  void testUpdate2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyQuestionRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyQuestionRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SurveyQuestionRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Record>any())).thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<SurveyQuestionRecord>>any()))
        .thenReturn(updateSetFirstStep);

    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    Optional<? extends EntityReference> qualifierEntity = Optional.empty();

    // Act
    int actualUpdateResult =
        surveyQuestionDao.update(
            positionResult
                .qualifierEntity(qualifierEntity)
                .questionText("Question Text")
                .sectionName("Section Name")
                .surveyTemplateId(1L)
                .build());

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Record.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Test {@link SurveyQuestionDao#update(SurveyQuestion)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDao#update(SurveyQuestion)}
   */
  @Test
  @DisplayName(
      "Test update(SurveyQuestion); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionDao.update(SurveyQuestion)"})
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsCubrid_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    SurveyQuestionDao surveyQuestionDao = new SurveyQuestionDao(dsl);

    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<String> ofResult = Optional.of("foo");
    when(surveyQuestion.externalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(surveyQuestion.inclusionPredicate()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(surveyQuestion.label()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(surveyQuestion.parentExternalId()).thenReturn(ofResult4);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult5 = Optional.of(immutableEntityReference);
    when(surveyQuestion.qualifierEntity()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(surveyQuestion.sectionName()).thenReturn(ofResult6);
    when(surveyQuestion.isMandatory()).thenReturn(true);
    when(surveyQuestion.allowComment()).thenReturn(true);
    when(surveyQuestion.position()).thenReturn(1);
    when(surveyQuestion.surveyTemplateId()).thenReturn(1L);
    when(surveyQuestion.questionText()).thenReturn("Question Text");
    Optional<String> ofResult7 = Optional.of("foo");
    when(surveyQuestion.helpText()).thenReturn(ofResult7);
    when(surveyQuestion.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    Optional<Long> ofResult8 = Optional.of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult8);

    // Act
    int actualUpdateResult = surveyQuestionDao.update(surveyQuestion);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_question\" set \"survey_question\".\"survey_template_id\" = cast(? as bigint), \"survey_question\".\"question_text\" = cast(? as varchar), \"survey_question\".\"field_type\" = cast(? as varchar), \"survey_question\".\"section_name\" = cast(? as varchar), \"survey_question\".\"position\" = cast(? as int), \"survey_question\".\"is_mandatory\" = cast(? as bit(1)), \"survey_question\".\"allow_comment\" = cast(? as bit(1)), \"survey_question\".\"help_text\" = cast(? as varchar), \"survey_question\".\"external_id\" = cast(? as varchar), \"survey_question\".\"inclusion_predicate\" = cast(? as varchar), \"survey_question\".\"entity_qualifier_id\" = cast(? as bigint), \"survey_question\".\"entity_qualifier_kind\" = cast(? as varchar), \"survey_question\".\"parent_external_id\" = cast(? as varchar), \"survey_question\".\"label\" = cast(? as varchar) where \"survey_question\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), eq(true));
    verify(preparedStatement).setInt(5, 1);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(surveyQuestion).externalId();
    verify(surveyQuestion, atLeast(1)).id();
    verify(surveyQuestion).allowComment();
    verify(surveyQuestion).fieldType();
    verify(surveyQuestion).helpText();
    verify(surveyQuestion).inclusionPredicate();
    verify(surveyQuestion).isMandatory();
    verify(surveyQuestion).label();
    verify(surveyQuestion).parentExternalId();
    verify(surveyQuestion).position();
    verify(surveyQuestion).qualifierEntity();
    verify(surveyQuestion).questionText();
    verify(surveyQuestion).sectionName();
    verify(surveyQuestion).surveyTemplateId();
    assertEquals(0, actualUpdateResult);
  }

  /**
   * Test {@link SurveyQuestionDao#update(SurveyQuestion)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDao#update(SurveyQuestion)}
   */
  @Test
  @DisplayName(
      "Test update(SurveyQuestion); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionDao.update(SurveyQuestion)"})
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsFirebird() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    SurveyQuestionDao surveyQuestionDao = new SurveyQuestionDao(dsl);

    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<String> ofResult = Optional.of("foo");
    when(surveyQuestion.externalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(surveyQuestion.inclusionPredicate()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(surveyQuestion.label()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(surveyQuestion.parentExternalId()).thenReturn(ofResult4);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult5 = Optional.of(immutableEntityReference);
    when(surveyQuestion.qualifierEntity()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(surveyQuestion.sectionName()).thenReturn(ofResult6);
    when(surveyQuestion.isMandatory()).thenReturn(true);
    when(surveyQuestion.allowComment()).thenReturn(true);
    when(surveyQuestion.position()).thenReturn(1);
    when(surveyQuestion.surveyTemplateId()).thenReturn(1L);
    when(surveyQuestion.questionText()).thenReturn("Question Text");
    Optional<String> ofResult7 = Optional.of("foo");
    when(surveyQuestion.helpText()).thenReturn(ofResult7);
    when(surveyQuestion.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    Optional<Long> ofResult8 = Optional.of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult8);

    // Act
    int actualUpdateResult = surveyQuestionDao.update(surveyQuestion);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_question\" set \"survey_question\".\"survey_template_id\" = cast(? as bigint), \"survey_question\".\"question_text\" = cast(? as varchar(13)), \"survey_question\".\"field_type\" = cast(? as varchar(11)), \"survey_question\".\"section_name\" = cast(? as varchar(3)), \"survey_question\".\"position\" = cast(? as integer), \"survey_question\".\"is_mandatory\" = cast(? as boolean), \"survey_question\".\"allow_comment\" = cast(? as boolean), \"survey_question\".\"help_text\" = cast(? as varchar(3)), \"survey_question\".\"external_id\" = cast(? as varchar(3)), \"survey_question\".\"inclusion_predicate\" = cast(? as varchar(3)), \"survey_question\".\"entity_qualifier_id\" = cast(? as bigint), \"survey_question\".\"entity_qualifier_kind\" = cast(? as varchar(3)), \"survey_question\".\"parent_external_id\" = cast(? as varchar(3)), \"survey_question\".\"label\" = cast(? as varchar(3)) where \"survey_question\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), eq(true));
    verify(preparedStatement).setInt(5, 1);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(surveyQuestion).externalId();
    verify(surveyQuestion, atLeast(1)).id();
    verify(surveyQuestion).allowComment();
    verify(surveyQuestion).fieldType();
    verify(surveyQuestion).helpText();
    verify(surveyQuestion).inclusionPredicate();
    verify(surveyQuestion).isMandatory();
    verify(surveyQuestion).label();
    verify(surveyQuestion).parentExternalId();
    verify(surveyQuestion).position();
    verify(surveyQuestion).qualifierEntity();
    verify(surveyQuestion).questionText();
    verify(surveyQuestion).sectionName();
    verify(surveyQuestion).surveyTemplateId();
    assertEquals(0, actualUpdateResult);
  }

  /**
   * Test {@link SurveyQuestionDao#update(SurveyQuestion)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDao#update(SurveyQuestion)}
   */
  @Test
  @DisplayName(
      "Test update(SurveyQuestion); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionDao.update(SurveyQuestion)"})
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsSql99_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    SurveyQuestionDao surveyQuestionDao = new SurveyQuestionDao(dsl);

    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<String> ofResult = Optional.of("foo");
    when(surveyQuestion.externalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(surveyQuestion.inclusionPredicate()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(surveyQuestion.label()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(surveyQuestion.parentExternalId()).thenReturn(ofResult4);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult5 = Optional.of(immutableEntityReference);
    when(surveyQuestion.qualifierEntity()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(surveyQuestion.sectionName()).thenReturn(ofResult6);
    when(surveyQuestion.isMandatory()).thenReturn(true);
    when(surveyQuestion.allowComment()).thenReturn(true);
    when(surveyQuestion.position()).thenReturn(1);
    when(surveyQuestion.surveyTemplateId()).thenReturn(1L);
    when(surveyQuestion.questionText()).thenReturn("Question Text");
    Optional<String> ofResult7 = Optional.of("foo");
    when(surveyQuestion.helpText()).thenReturn(ofResult7);
    when(surveyQuestion.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    Optional<Long> ofResult8 = Optional.of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult8);

    // Act
    int actualUpdateResult = surveyQuestionDao.update(surveyQuestion);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_question\" set \"survey_question\".\"survey_template_id\" = ?, \"survey_question\".\"question_text\" = ?, \"survey_question\".\"field_type\" = ?, \"survey_question\".\"section_name\" = ?, \"survey_question\".\"position\" = ?, \"survey_question\".\"is_mandatory\" = ?, \"survey_question\".\"allow_comment\" = ?, \"survey_question\".\"help_text\" = ?, \"survey_question\".\"external_id\" = ?, \"survey_question\".\"inclusion_predicate\" = ?, \"survey_question\".\"entity_qualifier_id\" = ?, \"survey_question\".\"entity_qualifier_kind\" = ?, \"survey_question\".\"parent_external_id\" = ?, \"survey_question\".\"label\" = ? where \"survey_question\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), eq(true));
    verify(preparedStatement).setInt(5, 1);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(surveyQuestion).externalId();
    verify(surveyQuestion, atLeast(1)).id();
    verify(surveyQuestion).allowComment();
    verify(surveyQuestion).fieldType();
    verify(surveyQuestion).helpText();
    verify(surveyQuestion).inclusionPredicate();
    verify(surveyQuestion).isMandatory();
    verify(surveyQuestion).label();
    verify(surveyQuestion).parentExternalId();
    verify(surveyQuestion).position();
    verify(surveyQuestion).qualifierEntity();
    verify(surveyQuestion).questionText();
    verify(surveyQuestion).sectionName();
    verify(surveyQuestion).surveyTemplateId();
    assertEquals(0, actualUpdateResult);
  }

  /**
   * Test {@link SurveyQuestionDao#update(SurveyQuestion)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDao#update(SurveyQuestion)}
   */
  @Test
  @DisplayName(
      "Test update(SurveyQuestion); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionDao.update(SurveyQuestion)"})
  void testUpdate_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyQuestionRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyQuestionRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SurveyQuestionRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Record>any())).thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<SurveyQuestionRecord>>any()))
        .thenReturn(updateSetFirstStep);

    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<String> ofResult = Optional.of("foo");
    when(surveyQuestion.externalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(surveyQuestion.inclusionPredicate()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(surveyQuestion.label()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(surveyQuestion.parentExternalId()).thenReturn(ofResult4);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult5 = Optional.of(immutableEntityReference);
    when(surveyQuestion.qualifierEntity()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(surveyQuestion.sectionName()).thenReturn(ofResult6);
    when(surveyQuestion.isMandatory()).thenReturn(true);
    when(surveyQuestion.allowComment()).thenReturn(true);
    when(surveyQuestion.position()).thenReturn(1);
    when(surveyQuestion.surveyTemplateId()).thenReturn(1L);
    when(surveyQuestion.questionText()).thenReturn("Question Text");
    Optional<String> ofResult7 = Optional.of("foo");
    when(surveyQuestion.helpText()).thenReturn(ofResult7);
    when(surveyQuestion.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    Optional<Long> ofResult8 = Optional.of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult8);

    // Act
    int actualUpdateResult = surveyQuestionDao.update(surveyQuestion);

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion, atLeast(1)).id();
    verify(surveyQuestion).allowComment();
    verify(surveyQuestion).fieldType();
    verify(surveyQuestion).helpText();
    verify(surveyQuestion).inclusionPredicate();
    verify(surveyQuestion).isMandatory();
    verify(surveyQuestion).label();
    verify(surveyQuestion).parentExternalId();
    verify(surveyQuestion).position();
    verify(surveyQuestion).qualifierEntity();
    verify(surveyQuestion).questionText();
    verify(surveyQuestion).sectionName();
    verify(surveyQuestion).surveyTemplateId();
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Record.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Test {@link SurveyQuestionDao#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDao#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionDao.delete(long)"})
  void testDelete_givenDefaultDSLContextWithConnectionAndDialectIsCubrid_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualDeleteResult = new SurveyQuestionDao(dsl).delete(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"survey_question\" where \"survey_question\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteResult);
  }

  /**
   * Test {@link SurveyQuestionDao#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code POSTGRES}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDao#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'POSTGRES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionDao.delete(long)"})
  void testDelete_givenDefaultDSLContextWithConnectionAndDialectIsPostgres() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    // Act
    int actualDeleteResult = new SurveyQuestionDao(dsl).delete(1L);

    // Assert
    verify(connection)
        .prepareStatement("delete from \"survey_question\" where \"survey_question\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteResult);
  }

  /**
   * Test {@link SurveyQuestionDao#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDao#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionDao.delete(long)"})
  void testDelete_givenDefaultDSLContextWithConnectionAndDialectIsSql99_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualDeleteResult = new SurveyQuestionDao(dsl).delete(1L);

    // Assert
    verify(connection)
        .prepareStatement("delete from \"survey_question\" where \"survey_question\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteResult);
  }

  /**
   * Test {@link SurveyQuestionDao#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQLITE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDao#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQLITE'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionDao.delete(long)"})
  void testDelete_givenDefaultDSLContextWithConnectionAndDialectIsSqlite_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    // Act
    int actualDeleteResult = new SurveyQuestionDao(dsl).delete(1L);

    // Assert
    verify(connection).prepareStatement("delete from survey_question where survey_question.id = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteResult);
  }

  /**
   * Test {@link SurveyQuestionDao#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDao#delete(long)}
   */
  @Test
  @DisplayName("Test delete(long); given DeleteConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionDao.delete(long)"})
  void testDelete_givenDeleteConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<SurveyQuestionRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<SurveyQuestionRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.delete(Mockito.<Table<SurveyQuestionRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualDeleteResult = surveyQuestionDao.delete(1L);

    // Assert
    verify(dSLContext).delete(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualDeleteResult);
  }

  /**
   * Test {@link SurveyQuestionDao#hasResponses(long)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchExists(Select)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDao#hasResponses(long)}
   */
  @Test
  @DisplayName(
      "Test hasResponses(long); given DSLContext fetchExists(Select) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyQuestionDao.hasResponses(long)"})
  void testHasResponses_givenDSLContextFetchExistsReturnFalse_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(false);

    // Act
    boolean actualHasResponsesResult = surveyQuestionDao.hasResponses(1L);

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    assertFalse(actualHasResponsesResult);
  }

  /**
   * Test {@link SurveyQuestionDao#hasResponses(long)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchExists(Select)} return {@code true}.
   *   <li>Then calls {@link DSLContext#fetchExists(Select)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDao#hasResponses(long)}
   */
  @Test
  @DisplayName(
      "Test hasResponses(long); given DSLContext fetchExists(Select) return 'true'; then calls fetchExists(Select)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyQuestionDao.hasResponses(long)"})
  void testHasResponses_givenDSLContextFetchExistsReturnTrue_thenCallsFetchExists()
      throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    // Act
    boolean actualHasResponsesResult = surveyQuestionDao.hasResponses(1L);

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    assertTrue(actualHasResponsesResult);
  }

  /**
   * Test {@link SurveyQuestionDao#hasResponses(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDao#hasResponses(long)}
   */
  @Test
  @DisplayName(
      "Test hasResponses(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyQuestionDao.hasResponses(long)"})
  void testHasResponses_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    boolean actualHasResponsesResult = new SurveyQuestionDao(dsl).hasResponses(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" from db_root where exists (select \"survey_question_response\".\"survey_instance_id\", \"survey_question_response\".\"question_id\", \"survey_question_response\".\"person_id\", \"survey_question_response\".\"comment\", \"survey_question_response\".\"last_updated_at\", \"survey_question_response\".\"string_response\", \"survey_question_response\".\"number_response\", \"survey_question_response\".\"boolean_response\", \"survey_question_response\".\"entity_response_id\", \"survey_question_response\".\"entity_response_kind\", \"survey_question_response\".\"date_response\", \"survey_question_response\".\"list_response_concat\" from \"survey_question_response\" where \"survey_question_response\".\"question_id\" = cast(? as bigint))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualHasResponsesResult);
  }

  /**
   * Test {@link SurveyQuestionDao#hasResponses(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDao#hasResponses(long)}
   */
  @Test
  @DisplayName(
      "Test hasResponses(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyQuestionDao.hasResponses(long)"})
  void testHasResponses_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualHasResponsesResult = new SurveyQuestionDao(dsl).hasResponses(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" where exists (select \"survey_question_response\".\"survey_instance_id\", \"survey_question_response\".\"question_id\", \"survey_question_response\".\"person_id\", \"survey_question_response\".\"comment\", \"survey_question_response\".\"last_updated_at\", \"survey_question_response\".\"string_response\", \"survey_question_response\".\"number_response\", \"survey_question_response\".\"boolean_response\", \"survey_question_response\".\"entity_response_id\", \"survey_question_response\".\"entity_response_kind\", \"survey_question_response\".\"date_response\", \"survey_question_response\".\"list_response_concat\" from \"survey_question_response\" where \"survey_question_response\".\"question_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualHasResponsesResult);
  }

  /**
   * Test {@link SurveyQuestionDao#deleteForTemplate(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDao#deleteForTemplate(Long)}
   */
  @Test
  @DisplayName(
      "Test deleteForTemplate(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionDao.deleteForTemplate(Long)"})
  void testDeleteForTemplate_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualDeleteForTemplateResult = new SurveyQuestionDao(dsl).deleteForTemplate(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"survey_question\" where \"survey_question\".\"survey_template_id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForTemplateResult);
  }

  /**
   * Test {@link SurveyQuestionDao#deleteForTemplate(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code POSTGRES}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDao#deleteForTemplate(Long)}
   */
  @Test
  @DisplayName(
      "Test deleteForTemplate(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'POSTGRES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionDao.deleteForTemplate(Long)"})
  void testDeleteForTemplate_givenDefaultDSLContextWithConnectionAndDialectIsPostgres()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    // Act
    int actualDeleteForTemplateResult = new SurveyQuestionDao(dsl).deleteForTemplate(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"survey_question\" where \"survey_question\".\"survey_template_id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForTemplateResult);
  }

  /**
   * Test {@link SurveyQuestionDao#deleteForTemplate(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDao#deleteForTemplate(Long)}
   */
  @Test
  @DisplayName(
      "Test deleteForTemplate(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionDao.deleteForTemplate(Long)"})
  void testDeleteForTemplate_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualDeleteForTemplateResult = new SurveyQuestionDao(dsl).deleteForTemplate(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"survey_question\" where \"survey_question\".\"survey_template_id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForTemplateResult);
  }

  /**
   * Test {@link SurveyQuestionDao#deleteForTemplate(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQLITE}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDao#deleteForTemplate(Long)}
   */
  @Test
  @DisplayName(
      "Test deleteForTemplate(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQLITE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionDao.deleteForTemplate(Long)"})
  void testDeleteForTemplate_givenDefaultDSLContextWithConnectionAndDialectIsSqlite()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    // Act
    int actualDeleteForTemplateResult = new SurveyQuestionDao(dsl).deleteForTemplate(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from survey_question where survey_question.survey_template_id = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForTemplateResult);
  }

  /**
   * Test {@link SurveyQuestionDao#deleteForTemplate(Long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDao#deleteForTemplate(Long)}
   */
  @Test
  @DisplayName(
      "Test deleteForTemplate(Long); given DeleteConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionDao.deleteForTemplate(Long)"})
  void testDeleteForTemplate_givenDeleteConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<SurveyQuestionRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<SurveyQuestionRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<SurveyQuestionRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    int actualDeleteForTemplateResult = surveyQuestionDao.deleteForTemplate(1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualDeleteForTemplateResult);
  }

  /**
   * Test {@link SurveyQuestionDao#findForIds(Set)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashSet#HashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDao#findForIds(Set)}
   */
  @Test
  @DisplayName("Test findForIds(Set); given one; when HashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyQuestionDao.findForIds(Set)"})
  void testFindForIds_givenOne_whenHashSetAddOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    HashSet<Long> surveyQuestionsIds = new HashSet<>();
    surveyQuestionsIds.add(1L);

    // Act
    Set<SurveyQuestion> actualFindForIdsResult = surveyQuestionDao.findForIds(surveyQuestionsIds);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForIdsResult.isEmpty());
  }

  /**
   * Test {@link SurveyQuestionDao#findForIds(Set)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link HashSet#HashSet()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDao#findForIds(Set)}
   */
  @Test
  @DisplayName("Test findForIds(Set); given zero; when HashSet() add zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyQuestionDao.findForIds(Set)"})
  void testFindForIds_givenZero_whenHashSetAddZero() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    HashSet<Long> surveyQuestionsIds = new HashSet<>();
    surveyQuestionsIds.add(0L);
    surveyQuestionsIds.add(1L);

    // Act
    Set<SurveyQuestion> actualFindForIdsResult = surveyQuestionDao.findForIds(surveyQuestionsIds);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForIdsResult.isEmpty());
  }

  /**
   * Test {@link SurveyQuestionDao#findForIds(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDao#findForIds(Set)}
   */
  @Test
  @DisplayName("Test findForIds(Set); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyQuestionDao.findForIds(Set)"})
  void testFindForIds_whenHashSet() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<SurveyQuestion> actualFindForIdsResult = surveyQuestionDao.findForIds(new HashSet<>());

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForIdsResult.isEmpty());
  }
}
