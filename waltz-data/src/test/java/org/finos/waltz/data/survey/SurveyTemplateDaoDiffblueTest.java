package org.finos.waltz.data.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.survey.ImmutableSurveyTemplate;
import org.finos.waltz.model.survey.ImmutableSurveyTemplateChangeCommand;
import org.finos.waltz.model.survey.SurveyTemplate;
import org.finos.waltz.model.survey.SurveyTemplateChangeCommand;
import org.finos.waltz.schema.tables.records.SurveyTemplateRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.InsertResultStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
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
class SurveyTemplateDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private SurveyTemplateDao surveyTemplateDao;

  /**
   * Test {@link SurveyTemplateDao#getById(long)}.
   *
   * <p>Method under test: {@link SurveyTemplateDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyTemplate SurveyTemplateDao.getById(long)"})
  void testGetById() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(ofResult.atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    SurveyTemplate actualById = new SurveyTemplateDao(dsl).getById(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualById instanceof ImmutableSurveyTemplate);
    LocalDateTime createdAtResult = actualById.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Issuance Role", actualById.issuanceRole());
    assertEquals("Name", actualById.name());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(1L, actualById.ownerId().longValue());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(EntityKind.ALL, actualById.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualById.status());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link SurveyTemplateDao#findForOwner(Long)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateDao#findForOwner(Long)}
   */
  @Test
  @DisplayName("Test findForOwner(Long); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyTemplateDao.findForOwner(Long)"})
  void testFindForOwner_whenNull() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<SurveyTemplate> actualFindForOwnerResult = new SurveyTemplateDao(dsl).findForOwner(null);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForOwnerResult.isEmpty());
  }

  /**
   * Test {@link SurveyTemplateDao#findForOwner(Long)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateDao#findForOwner(Long)}
   */
  @Test
  @DisplayName("Test findForOwner(Long); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyTemplateDao.findForOwner(Long)"})
  void testFindForOwner_whenOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<SurveyTemplate> actualFindForOwnerResult = new SurveyTemplateDao(dsl).findForOwner(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForOwnerResult.isEmpty());
  }

  /**
   * Test {@link SurveyTemplateDao#findAllActive()}.
   *
   * <p>Method under test: {@link SurveyTemplateDao#findAllActive()}
   */
  @Test
  @DisplayName("Test findAllActive()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyTemplateDao.findAllActive()"})
  void testFindAllActive() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<SurveyTemplate> actualFindAllActiveResult = new SurveyTemplateDao(dsl).findAllActive();

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindAllActiveResult.isEmpty());
  }

  /**
   * Test {@link SurveyTemplateDao#findAll()}.
   *
   * <p>Method under test: {@link SurveyTemplateDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection SurveyTemplateDao.findAll()"})
  void testFindAll() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    ArrayList<Object> objectList = new ArrayList<>();
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(objectList);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Collection<SurveyTemplate> actualFindAllResult = new SurveyTemplateDao(dsl).findAll();

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindAllResult instanceof List);
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(objectList, actualFindAllResult);
  }

  /**
   * Test {@link SurveyTemplateDao#findByCondition(Condition)}.
   *
   * <p>Method under test: {@link SurveyTemplateDao#findByCondition(Condition)}
   */
  @Test
  @DisplayName("Test findByCondition(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyTemplateDao.findByCondition(Condition)"})
  void testFindByCondition() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<SurveyTemplate> actualFindByConditionResult =
        new SurveyTemplateDao(dsl).findByCondition(ApplicationDao.IS_ACTIVE);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByConditionResult.isEmpty());
  }

  /**
   * Test {@link SurveyTemplateDao#create(SurveyTemplate)}.
   *
   * <p>Method under test: {@link SurveyTemplateDao#create(SurveyTemplate)}
   */
  @Test
  @DisplayName("Test create(SurveyTemplate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyTemplateDao.create(SurveyTemplate)"})
  void testCreate() throws DataAccessException {
    // Arrange
    SurveyTemplateRecord surveyTemplateRecord = mock(SurveyTemplateRecord.class);
    when(surveyTemplateRecord.getId()).thenReturn(1L);

    InsertResultStep<SurveyTemplateRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(surveyTemplateRecord);

    InsertSetMoreStep<SurveyTemplateRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<SurveyTemplateRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<SurveyTemplateRecord>>any()))
        .thenReturn(insertSetStep);

    // Act
    long actualCreateResult =
        surveyTemplateDao.create(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Assert
    verify(surveyTemplateRecord).getId();
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link SurveyTemplateDao#create(SurveyTemplate)}.
   *
   * <p>Method under test: {@link SurveyTemplateDao#create(SurveyTemplate)}
   */
  @Test
  @DisplayName("Test create(SurveyTemplate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyTemplateDao.create(SurveyTemplate)"})
  void testCreate2() throws DataAccessException {
    // Arrange
    SurveyTemplateRecord surveyTemplateRecord = mock(SurveyTemplateRecord.class);
    when(surveyTemplateRecord.getId()).thenReturn(1L);

    InsertResultStep<SurveyTemplateRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(surveyTemplateRecord);

    InsertSetMoreStep<SurveyTemplateRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<SurveyTemplateRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<SurveyTemplateRecord>>any()))
        .thenReturn(insertSetStep);

    // Act
    long actualCreateResult =
        surveyTemplateDao.create(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole(null)
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Assert
    verify(surveyTemplateRecord).getId();
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link SurveyTemplateDao#create(SurveyTemplate)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link SurveyTemplate} {@link SurveyTemplate#issuanceRole()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateDao#create(SurveyTemplate)}
   */
  @Test
  @DisplayName(
      "Test create(SurveyTemplate); given empty string; when SurveyTemplate issuanceRole() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyTemplateDao.create(SurveyTemplate)"})
  void testCreate_givenEmptyString_whenSurveyTemplateIssuanceRoleReturnEmptyString()
      throws DataAccessException {
    // Arrange
    SurveyTemplateRecord surveyTemplateRecord = mock(SurveyTemplateRecord.class);
    when(surveyTemplateRecord.getId()).thenReturn(1L);

    InsertResultStep<SurveyTemplateRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(surveyTemplateRecord);

    InsertSetMoreStep<SurveyTemplateRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<SurveyTemplateRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<SurveyTemplateRecord>>any())).thenReturn(insertSetStep);
    SurveyTemplateDao surveyTemplateDao = new SurveyTemplateDao(dsl);

    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.issuanceRole()).thenReturn("");
    Optional<String> ofResult = Optional.of("foo");
    when(surveyTemplate.externalId()).thenReturn(ofResult);
    when(surveyTemplate.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(surveyTemplate.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(surveyTemplate.ownerId()).thenReturn(1L);
    when(surveyTemplate.description()).thenReturn("The characteristics of someone or something");
    when(surveyTemplate.name()).thenReturn("Name");
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.ALL);

    // Act
    long actualCreateResult = surveyTemplateDao.create(surveyTemplate);

    // Assert
    verify(surveyTemplate).description();
    verify(surveyTemplate).externalId();
    verify(surveyTemplate).name();
    verify(surveyTemplate).createdAt();
    verify(surveyTemplate).issuanceRole();
    verify(surveyTemplate).ownerId();
    verify(surveyTemplate).status();
    verify(surveyTemplate).targetEntityKind();
    verify(surveyTemplateRecord).getId();
    verify(dsl).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link SurveyTemplateDao#create(SurveyTemplate)}.
   *
   * <ul>
   *   <li>Given {@code Issuance Role}.
   *   <li>When {@link SurveyTemplate} {@link SurveyTemplate#issuanceRole()} return {@code Issuance
   *       Role}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateDao#create(SurveyTemplate)}
   */
  @Test
  @DisplayName(
      "Test create(SurveyTemplate); given 'Issuance Role'; when SurveyTemplate issuanceRole() return 'Issuance Role'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyTemplateDao.create(SurveyTemplate)"})
  void testCreate_givenIssuanceRole_whenSurveyTemplateIssuanceRoleReturnIssuanceRole()
      throws DataAccessException {
    // Arrange
    SurveyTemplateRecord surveyTemplateRecord = mock(SurveyTemplateRecord.class);
    when(surveyTemplateRecord.getId()).thenReturn(1L);

    InsertResultStep<SurveyTemplateRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(surveyTemplateRecord);

    InsertSetMoreStep<SurveyTemplateRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<SurveyTemplateRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<SurveyTemplateRecord>>any())).thenReturn(insertSetStep);
    SurveyTemplateDao surveyTemplateDao = new SurveyTemplateDao(dsl);

    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.issuanceRole()).thenReturn("Issuance Role");
    Optional<String> ofResult = Optional.of("foo");
    when(surveyTemplate.externalId()).thenReturn(ofResult);
    when(surveyTemplate.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(surveyTemplate.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(surveyTemplate.ownerId()).thenReturn(1L);
    when(surveyTemplate.description()).thenReturn("The characteristics of someone or something");
    when(surveyTemplate.name()).thenReturn("Name");
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.ALL);

    // Act
    long actualCreateResult = surveyTemplateDao.create(surveyTemplate);

    // Assert
    verify(surveyTemplate).description();
    verify(surveyTemplate).externalId();
    verify(surveyTemplate).name();
    verify(surveyTemplate).createdAt();
    verify(surveyTemplate).issuanceRole();
    verify(surveyTemplate).ownerId();
    verify(surveyTemplate).status();
    verify(surveyTemplate).targetEntityKind();
    verify(surveyTemplateRecord).getId();
    verify(dsl).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link SurveyTemplateDao#update(SurveyTemplateChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@code command cannot be null}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateDao#update(SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName("Test update(SurveyTemplateChangeCommand); given 'command cannot be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyTemplateDao.update(SurveyTemplateChangeCommand)"})
  void testUpdate_givenCommandCannotBeNull() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyTemplateRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);

    UpdateSetFirstStep<SurveyTemplateRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep5);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyTemplateRecord>>any())).thenReturn(updateSetFirstStep);
    SurveyTemplateDao surveyTemplateDao = new SurveyTemplateDao(dsl);

    SurveyTemplateChangeCommand command = mock(SurveyTemplateChangeCommand.class);
    when(command.issuanceRole()).thenReturn("command cannot be null");
    Optional<Long> ofResult = Optional.of(1L);
    when(command.id()).thenReturn(ofResult);
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.name()).thenReturn("Name");
    Optional<String> ofResult2 = Optional.of("foo");
    when(command.externalId()).thenReturn(ofResult2);
    when(command.targetEntityKind()).thenReturn(EntityKind.ALL);

    // Act
    int actualUpdateResult = surveyTemplateDao.update(command);

    // Assert
    verify(command).description();
    verify(command).externalId();
    verify(command).id();
    verify(command).name();
    verify(command).issuanceRole();
    verify(command).targetEntityKind();
    verify(dsl).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Test {@link SurveyTemplateDao#update(SurveyTemplateChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext} {@link DefaultDSLContext#update(Table)} return {@link
   *       UpdateSetFirstStep}.
   *   <li>Then calls {@link DefaultDSLContext#update(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateDao#update(SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(SurveyTemplateChangeCommand); given DefaultDSLContext update(Table) return UpdateSetFirstStep; then calls update(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyTemplateDao.update(SurveyTemplateChangeCommand)"})
  void testUpdate_givenDefaultDSLContextUpdateReturnUpdateSetFirstStep_thenCallsUpdate()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyTemplateRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);

    UpdateSetFirstStep<SurveyTemplateRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep5);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyTemplateRecord>>any())).thenReturn(updateSetFirstStep);
    SurveyTemplateDao surveyTemplateDao = new SurveyTemplateDao(dsl);

    // Act
    int actualUpdateResult =
        surveyTemplateDao.update(
            ImmutableSurveyTemplateChangeCommand.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole(null)
                .name("Name")
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Test {@link SurveyTemplateDao#update(SurveyTemplateChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateDao#update(SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(SurveyTemplateChangeCommand); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyTemplateDao.update(SurveyTemplateChangeCommand)"})
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsCubrid_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    SurveyTemplateDao surveyTemplateDao = new SurveyTemplateDao(dsl);

    SurveyTemplateChangeCommand command = mock(SurveyTemplateChangeCommand.class);
    when(command.issuanceRole()).thenReturn("");
    Optional<Long> ofResult = Optional.of(1L);
    when(command.id()).thenReturn(ofResult);
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.name()).thenReturn("Name");
    Optional<String> ofResult2 = Optional.of("foo");
    when(command.externalId()).thenReturn(ofResult2);
    when(command.targetEntityKind()).thenReturn(EntityKind.ALL);

    // Act
    int actualUpdateResult = surveyTemplateDao.update(command);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_template\" set \"survey_template\".\"name\" = cast(? as varchar), \"survey_template\".\"description\" = cast(? as varchar), \"survey_template\".\"external_id\" = cast(? as varchar), \"survey_template\".\"target_entity_kind\" = cast(? as varchar), \"survey_template\".\"issuance_role\" = cast(? as varchar) where \"survey_template\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(6, 1L);
    verify(preparedStatement).setNull(5, 12);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(command).description();
    verify(command).externalId();
    verify(command).id();
    verify(command).name();
    verify(command).issuanceRole();
    verify(command).targetEntityKind();
    assertEquals(0, actualUpdateResult);
  }

  /**
   * Test {@link SurveyTemplateDao#update(SurveyTemplateChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateDao#update(SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(SurveyTemplateChangeCommand); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyTemplateDao.update(SurveyTemplateChangeCommand)"})
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsFirebird() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    SurveyTemplateDao surveyTemplateDao = new SurveyTemplateDao(dsl);

    SurveyTemplateChangeCommand command = mock(SurveyTemplateChangeCommand.class);
    when(command.issuanceRole()).thenReturn("");
    Optional<Long> ofResult = Optional.of(1L);
    when(command.id()).thenReturn(ofResult);
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.name()).thenReturn("Name");
    Optional<String> ofResult2 = Optional.of("foo");
    when(command.externalId()).thenReturn(ofResult2);
    when(command.targetEntityKind()).thenReturn(EntityKind.ALL);

    // Act
    int actualUpdateResult = surveyTemplateDao.update(command);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_template\" set \"survey_template\".\"name\" = cast(? as varchar(4)), \"survey_template\".\"description\" = cast(? as varchar(43)), \"survey_template\".\"external_id\" = cast(? as varchar(3)), \"survey_template\".\"target_entity_kind\" = cast(? as varchar(3)), \"survey_template\".\"issuance_role\" = cast(? as varchar(1)) where \"survey_template\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(6, 1L);
    verify(preparedStatement).setNull(5, 12);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(command).description();
    verify(command).externalId();
    verify(command).id();
    verify(command).name();
    verify(command).issuanceRole();
    verify(command).targetEntityKind();
    assertEquals(0, actualUpdateResult);
  }

  /**
   * Test {@link SurveyTemplateDao#update(SurveyTemplateChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateDao#update(SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(SurveyTemplateChangeCommand); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyTemplateDao.update(SurveyTemplateChangeCommand)"})
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsSql99_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    SurveyTemplateDao surveyTemplateDao = new SurveyTemplateDao(dsl);

    SurveyTemplateChangeCommand command = mock(SurveyTemplateChangeCommand.class);
    when(command.issuanceRole()).thenReturn("");
    Optional<Long> ofResult = Optional.of(1L);
    when(command.id()).thenReturn(ofResult);
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.name()).thenReturn("Name");
    Optional<String> ofResult2 = Optional.of("foo");
    when(command.externalId()).thenReturn(ofResult2);
    when(command.targetEntityKind()).thenReturn(EntityKind.ALL);

    // Act
    int actualUpdateResult = surveyTemplateDao.update(command);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_template\" set \"survey_template\".\"name\" = ?, \"survey_template\".\"description\" = ?, \"survey_template\".\"external_id\" = ?, \"survey_template\".\"target_entity_kind\" = ?, \"survey_template\".\"issuance_role\" = ? where \"survey_template\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(6, 1L);
    verify(preparedStatement).setNull(5, 12);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(command).description();
    verify(command).externalId();
    verify(command).id();
    verify(command).name();
    verify(command).issuanceRole();
    verify(command).targetEntityKind();
    assertEquals(0, actualUpdateResult);
  }

  /**
   * Test {@link SurveyTemplateDao#update(SurveyTemplateChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link SurveyTemplateDao#SurveyTemplateDao(DSLContext)} with dsl is {@link
   *       DSLContext}.
   *   <li>Then calls {@link DSLContext#update(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateDao#update(SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(SurveyTemplateChangeCommand); given SurveyTemplateDao(DSLContext) with dsl is DSLContext; then calls update(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyTemplateDao.update(SurveyTemplateChangeCommand)"})
  void testUpdate_givenSurveyTemplateDaoWithDslIsDSLContext_thenCallsUpdate()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyTemplateRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);

    UpdateSetFirstStep<SurveyTemplateRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep5);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyTemplateRecord>>any())).thenReturn(updateSetFirstStep);
    SurveyTemplateDao surveyTemplateDao = new SurveyTemplateDao(dsl);

    SurveyTemplateChangeCommand command = mock(SurveyTemplateChangeCommand.class);
    when(command.issuanceRole()).thenReturn("");
    Optional<Long> ofResult = Optional.of(1L);
    when(command.id()).thenReturn(ofResult);
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.name()).thenReturn("Name");
    Optional<String> ofResult2 = Optional.of("foo");
    when(command.externalId()).thenReturn(ofResult2);
    when(command.targetEntityKind()).thenReturn(EntityKind.ALL);

    // Act
    int actualUpdateResult = surveyTemplateDao.update(command);

    // Assert
    verify(command).description();
    verify(command).externalId();
    verify(command).id();
    verify(command).name();
    verify(command).issuanceRole();
    verify(command).targetEntityKind();
    verify(dsl).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Test {@link SurveyTemplateDao#updateStatus(long, ReleaseLifecycleStatus)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateDao#updateStatus(long, ReleaseLifecycleStatus)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(long, ReleaseLifecycleStatus); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyTemplateDao.updateStatus(long, ReleaseLifecycleStatus)"})
  void testUpdateStatus_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualUpdateStatusResult =
        new SurveyTemplateDao(dsl).updateStatus(1L, ReleaseLifecycleStatus.DRAFT);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_template\" set \"survey_template\".\"status\" = cast(? as varchar) where (\"survey_template\".\"status\" <> cast(? as varchar) and \"survey_template\".\"id\" = cast(? as bigint))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(3, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DRAFT"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateStatusResult);
  }

  /**
   * Test {@link SurveyTemplateDao#updateStatus(long, ReleaseLifecycleStatus)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateDao#updateStatus(long, ReleaseLifecycleStatus)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(long, ReleaseLifecycleStatus); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyTemplateDao.updateStatus(long, ReleaseLifecycleStatus)"})
  void testUpdateStatus_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualUpdateStatusResult =
        new SurveyTemplateDao(dsl).updateStatus(1L, ReleaseLifecycleStatus.DRAFT);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_template\" set \"survey_template\".\"status\" = ? where (\"survey_template\".\"status\" <> ? and \"survey_template\".\"id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(3, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DRAFT"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateStatusResult);
  }

  /**
   * Test {@link SurveyTemplateDao#updateStatus(long, ReleaseLifecycleStatus)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateDao#updateStatus(long, ReleaseLifecycleStatus)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(long, ReleaseLifecycleStatus); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyTemplateDao.updateStatus(long, ReleaseLifecycleStatus)"})
  void testUpdateStatus_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyTemplateRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SurveyTemplateRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyTemplateRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateStatusResult =
        new SurveyTemplateDao(dsl).updateStatus(1L, ReleaseLifecycleStatus.DRAFT);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateStatusResult);
  }

  /**
   * Test {@link SurveyTemplateDao#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateDao#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyTemplateDao.delete(long)"})
  void testDelete_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    boolean actualDeleteResult = new SurveyTemplateDao(dsl).delete(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"survey_template\" where (\"survey_template\".\"id\" = cast(? as bigint) and \"survey_template\".\"status\" = cast(? as varchar))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "DRAFT");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link SurveyTemplateDao#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateDao#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyTemplateDao.delete(long)"})
  void testDelete_givenDefaultDSLContextWithConnectionAndDialectIsFirebird() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);

    // Act
    boolean actualDeleteResult = new SurveyTemplateDao(dsl).delete(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"survey_template\" where (\"survey_template\".\"id\" = cast(? as bigint) and \"survey_template\".\"status\" = cast(? as varchar(5)))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "DRAFT");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link SurveyTemplateDao#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code MARIADB}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateDao#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'MARIADB'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyTemplateDao.delete(long)"})
  void testDelete_givenDefaultDSLContextWithConnectionAndDialectIsMariadb() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.MARIADB);

    // Act
    boolean actualDeleteResult = new SurveyTemplateDao(dsl).delete(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from `survey_template` where (`survey_template`.`id` = ? and `survey_template`.`status` = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "DRAFT");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link SurveyTemplateDao#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code POSTGRES}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateDao#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'POSTGRES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyTemplateDao.delete(long)"})
  void testDelete_givenDefaultDSLContextWithConnectionAndDialectIsPostgres() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    // Act
    boolean actualDeleteResult = new SurveyTemplateDao(dsl).delete(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"survey_template\" where (\"survey_template\".\"id\" = ? and \"survey_template\".\"status\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "DRAFT");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link SurveyTemplateDao#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateDao#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyTemplateDao.delete(long)"})
  void testDelete_givenDefaultDSLContextWithConnectionAndDialectIsSql99_thenReturnFalse()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualDeleteResult = new SurveyTemplateDao(dsl).delete(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"survey_template\" where (\"survey_template\".\"id\" = ? and \"survey_template\".\"status\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "DRAFT");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link SurveyTemplateDao#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQLITE}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateDao#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQLITE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyTemplateDao.delete(long)"})
  void testDelete_givenDefaultDSLContextWithConnectionAndDialectIsSqlite() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    // Act
    boolean actualDeleteResult = new SurveyTemplateDao(dsl).delete(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from survey_template where (survey_template.id = ? and survey_template.status = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "DRAFT");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link SurveyTemplateDao#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateDao#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given DeleteConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyTemplateDao.delete(long)"})
  void testDelete_givenDeleteConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<SurveyTemplateRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<SurveyTemplateRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<SurveyTemplateRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<SurveyTemplateRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    boolean actualDeleteResult = new SurveyTemplateDao(dsl).delete(1L);

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertTrue(actualDeleteResult);
  }

  /**
   * Test {@link SurveyTemplateDao#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getWarnings()} return {@code
   *       null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateDao#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given PreparedStatement getWarnings() return 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyTemplateDao.delete(long)"})
  void testDelete_givenPreparedStatementGetWarningsReturnNull_thenReturnFalse()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(null);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualDeleteResult = new SurveyTemplateDao(dsl).delete(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"survey_template\" where (\"survey_template\".\"id\" = ? and \"survey_template\".\"status\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "DRAFT");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link SurveyTemplateDao#getByQuestionId(long)}.
   *
   * <p>Method under test: {@link SurveyTemplateDao#getByQuestionId(long)}
   */
  @Test
  @DisplayName("Test getByQuestionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyTemplate SurveyTemplateDao.getByQuestionId(long)"})
  void testGetByQuestionId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(ofResult.atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    SurveyTemplate actualByQuestionId = new SurveyTemplateDao(dsl).getByQuestionId(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualByQuestionId instanceof ImmutableSurveyTemplate);
    LocalDateTime createdAtResult = actualByQuestionId.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Issuance Role", actualByQuestionId.issuanceRole());
    assertEquals("Name", actualByQuestionId.name());
    assertEquals("The characteristics of someone or something", actualByQuestionId.description());
    assertEquals(1L, actualByQuestionId.ownerId().longValue());
    assertEquals(EntityKind.ALL, actualByQuestionId.kind());
    assertEquals(EntityKind.ALL, actualByQuestionId.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualByQuestionId.status());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link SurveyTemplateDao#canUserIssueAgainstTemplate(Long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultDSLContext#fetchCount(Select)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateDao#canUserIssueAgainstTemplate(Long, String)}
   */
  @Test
  @DisplayName("Test canUserIssueAgainstTemplate(Long, String); then calls fetchCount(Select)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyTemplateDao.canUserIssueAgainstTemplate(Long, String)"})
  void testCanUserIssueAgainstTemplate_thenCallsFetchCount() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.fetchCount(Mockito.<Select<?>>any())).thenReturn(3);

    // Act
    boolean actualCanUserIssueAgainstTemplateResult =
        new SurveyTemplateDao(dsl).canUserIssueAgainstTemplate(1L, "janedoe");

    // Assert
    verify(dsl).fetchCount(isA(Select.class));
    assertTrue(actualCanUserIssueAgainstTemplateResult);
  }

  /**
   * Test {@link SurveyTemplateDao#canUserIssueAgainstTemplate(Long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#getUpdateCount()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateDao#canUserIssueAgainstTemplate(Long, String)}
   */
  @Test
  @DisplayName("Test canUserIssueAgainstTemplate(Long, String); then calls getUpdateCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyTemplateDao.canUserIssueAgainstTemplate(Long, String)"})
  void testCanUserIssueAgainstTemplate_thenCallsGetUpdateCount() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualCanUserIssueAgainstTemplateResult =
        new SurveyTemplateDao(dsl).canUserIssueAgainstTemplate(1L, "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "select count(*) \"c\" from (select \"survey_template\".\"id\" from \"survey_template\" left outer join \"user_role\" on (\"user_role\".\"role\" in (\"survey_template\".\"issuance_role\", ?) and \"user_role\".\"user_name\" = ?) where (\"survey_template\".\"id\" = ? and \"survey_template\".\"status\" = ? and (\"user_role\".\"role\" is not null or \"survey_template\".\"issuance_role\" is null))) \"q\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(3, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertTrue(actualCanUserIssueAgainstTemplateResult);
  }

  /**
   * Test {@link SurveyTemplateDao#canUserIssueAgainstTemplate(Long, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateDao#canUserIssueAgainstTemplate(Long, String)}
   */
  @Test
  @DisplayName("Test canUserIssueAgainstTemplate(Long, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyTemplateDao.canUserIssueAgainstTemplate(Long, String)"})
  void testCanUserIssueAgainstTemplate_thenReturnFalse() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualCanUserIssueAgainstTemplateResult =
        new SurveyTemplateDao(dsl).canUserIssueAgainstTemplate(1L, "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "select count(*) \"c\" from (select \"survey_template\".\"id\" from \"survey_template\" left outer join \"user_role\" on (\"user_role\".\"role\" in (\"survey_template\".\"issuance_role\", ?) and \"user_role\".\"user_name\" = ?) where (\"survey_template\".\"id\" = ? and \"survey_template\".\"status\" = ? and (\"user_role\".\"role\" is not null or \"survey_template\".\"issuance_role\" is null))) \"q\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(3, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertFalse(actualCanUserIssueAgainstTemplateResult);
  }
}
