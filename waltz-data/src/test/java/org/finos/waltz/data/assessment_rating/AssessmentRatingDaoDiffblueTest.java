package org.finos.waltz.data.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.assessment_rating.AssessmentRatingOperations;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRating;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRating.Builder;
import org.finos.waltz.model.assessment_rating.ImmutableRemoveAssessmentRatingCommand;
import org.finos.waltz.model.assessment_rating.ImmutableSaveAssessmentRatingCommand;
import org.finos.waltz.model.assessment_rating.ImmutableUpdateRatingCommand;
import org.finos.waltz.model.assessment_rating.RemoveAssessmentRatingCommand;
import org.finos.waltz.model.assessment_rating.SaveAssessmentRatingCommand;
import org.finos.waltz.model.assessment_rating.UpdateRatingCommand;
import org.finos.waltz.schema.tables.records.AssessmentRatingRecord;
import org.jooq.Batch;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.GroupField;
import org.jooq.Query;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Record4;
import org.jooq.Record5;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectHavingConditionStep;
import org.jooq.SelectHavingStep;
import org.jooq.SelectJoinPartitionByStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.TableRecord;
import org.jooq.UpdatableRecord;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.exception.MappingException;
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
class AssessmentRatingDaoDiffblueTest {
  @InjectMocks private AssessmentRatingDao assessmentRatingDao;

  @Mock private DSLContext dSLContext;

  /**
   * Test {@link AssessmentRatingDao#findForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findForEntity(EntityReference)"})
  void testFindForEntity() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new MappingException("An error occurred"));

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.findForEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link AssessmentRatingDao#findForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findForEntity(EntityReference)"})
  void testFindForEntity2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new MappingException("An error occurred"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.findForEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link AssessmentRatingDao#findForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findForEntity(EntityReference)"})
  void testFindForEntity3() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.findForEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#findForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findForEntity(EntityReference)"})
  void testFindForEntity4() {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.findForEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#findForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findForEntity(EntityReference)"})
  void testFindForEntity5() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.findForEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#findForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findForEntity(EntityReference)"})
  void testFindForEntity6() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(mock(SelectJoinStep.class));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenThrow(new MappingException("An error occurred"));

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.findForEntity(ref));
    verify(ref).kind();
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link AssessmentRatingDao#findForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findForEntity(EntityReference)"})
  void testFindForEntity7() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.findForEntity(ref));
    verify(ref).kind();
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#findForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findForEntity(EntityReference)"})
  void testFindForEntity8() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenThrow(new MappingException("An error occurred"));
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.findForEntity(ref));
    verify(ref).id();
    verify(ref).kind();
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#findForEntity(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(SQLDialect)} with dialect is {@code
   *       SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findForEntity(EntityReference); given DefaultDSLContext(SQLDialect) with dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findForEntity(EntityReference)"})
  void testFindForEntity_givenDefaultDSLContextWithDialectIsSql99() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao =
        new AssessmentRatingDao(new DefaultDSLContext(SQLDialect.SQL99));

    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenThrow(new MappingException("An error occurred"));

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.findForEntity(ref));
    verify(ref).kind();
  }

  /**
   * Test {@link AssessmentRatingDao#findForEntity(EntityReference)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link EntityReference} {@link EntityReference#id()} return one.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findForEntity(EntityReference); given one; when EntityReference id() return one; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findForEntity(EntityReference)"})
  void testFindForEntity_givenOne_whenEntityReferenceIdReturnOne_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    List<AssessmentRating> actualFindForEntityResult = assessmentRatingDao.findForEntity(ref);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingDao#findForEntity(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetch(RecordMapper)} return
   *       {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findForEntity(EntityReference); given SelectConditionStep fetch(RecordMapper) return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findForEntity(EntityReference)"})
  void testFindForEntity_givenSelectConditionStepFetchReturnArrayList_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<AssessmentRating> actualFindForEntityResult =
        assessmentRatingDao.findForEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingDao#getById(long)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentRating AssessmentRatingDao.getById(long)"})
  void testGetById() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new MappingException("An error occurred"));

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link AssessmentRatingDao#getById(long)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentRating AssessmentRatingDao.getById(long)"})
  void testGetById2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new MappingException("An error occurred"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link AssessmentRatingDao#getById(long)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentRating AssessmentRatingDao.getById(long)"})
  void testGetById3() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#getById(long)}.
   *
   * <ul>
   *   <li>Then calls {@link SelectConditionStep#fetchOne(RecordMapper)}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then calls fetchOne(RecordMapper)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentRating AssessmentRatingDao.getById(long)"})
  void testGetById_thenCallsFetchOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#findByEntityKind(EntityKind, Optional)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findByEntityKind(EntityKind, Optional)}
   */
  @Test
  @DisplayName("Test findByEntityKind(EntityKind, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findByEntityKind(EntityKind, Optional)"})
  void testFindByEntityKind() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new MappingException("An error occurred"));
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.findByEntityKind(EntityKind.ALL, qualifierReference));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link AssessmentRatingDao#findByEntityKind(EntityKind, Optional)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findByEntityKind(EntityKind, Optional)}
   */
  @Test
  @DisplayName("Test findByEntityKind(EntityKind, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findByEntityKind(EntityKind, Optional)"})
  void testFindByEntityKind2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new MappingException("An error occurred"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.findByEntityKind(EntityKind.ALL, qualifierReference));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link AssessmentRatingDao#findByEntityKind(EntityKind, Optional)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findByEntityKind(EntityKind, Optional)}
   */
  @Test
  @DisplayName("Test findByEntityKind(EntityKind, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findByEntityKind(EntityKind, Optional)"})
  void testFindByEntityKind3() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.findByEntityKind(EntityKind.ALL, qualifierReference));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link AssessmentRatingDao#findByEntityKind(EntityKind, Optional)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findByEntityKind(EntityKind, Optional)}
   */
  @Test
  @DisplayName("Test findByEntityKind(EntityKind, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findByEntityKind(EntityKind, Optional)"})
  void testFindByEntityKind4() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.findByEntityKind(EntityKind.ALL, qualifierReference));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link AssessmentRatingDao#findByEntityKind(EntityKind, Optional)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findByEntityKind(EntityKind, Optional)}
   */
  @Test
  @DisplayName("Test findByEntityKind(EntityKind, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findByEntityKind(EntityKind, Optional)"})
  void testFindByEntityKind5() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.findByEntityKind(EntityKind.ALL, qualifierReference));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link AssessmentRatingDao#findByEntityKind(EntityKind, Optional)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findByEntityKind(EntityKind, Optional)}
   */
  @Test
  @DisplayName("Test findByEntityKind(EntityKind, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findByEntityKind(EntityKind, Optional)"})
  void testFindByEntityKind6() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.findByEntityKind(EntityKind.ALL, qualifierReference));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link AssessmentRatingDao#findByEntityKind(EntityKind, Optional)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findByEntityKind(EntityKind, Optional)}
   */
  @Test
  @DisplayName("Test findByEntityKind(EntityKind, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findByEntityKind(EntityKind, Optional)"})
  void testFindByEntityKind7() {
    // Arrange
    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.findByEntityKind(EntityKind.ALL, qualifierReference));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link AssessmentRatingDao#findByEntityKind(EntityKind, Optional)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findByEntityKind(EntityKind, Optional)}
   */
  @Test
  @DisplayName("Test findByEntityKind(EntityKind, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findByEntityKind(EntityKind, Optional)"})
  void testFindByEntityKind8() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.findByEntityKind(EntityKind.ALL, qualifierReference));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#findByEntityKind(EntityKind, Optional)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findByEntityKind(EntityKind, Optional)}
   */
  @Test
  @DisplayName("Test findByEntityKind(EntityKind, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findByEntityKind(EntityKind, Optional)"})
  void testFindByEntityKind9() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.findByEntityKind(EntityKind.ALL, qualifierReference));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#findByEntityKind(EntityKind, Optional)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#findByEntityKind(EntityKind, Optional)}
   */
  @Test
  @DisplayName("Test findByEntityKind(EntityKind, Optional); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findByEntityKind(EntityKind, Optional)"})
  void testFindByEntityKind_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    // Act
    List<AssessmentRating> actualFindByEntityKindResult =
        assessmentRatingDao.findByEntityKind(EntityKind.ALL, qualifierReference);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByEntityKindResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingDao#findByEntityKind(EntityKind, Optional)}.
   *
   * <ul>
   *   <li>When empty.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#findByEntityKind(EntityKind, Optional)}
   */
  @Test
  @DisplayName("Test findByEntityKind(EntityKind, Optional); when empty; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findByEntityKind(EntityKind, Optional)"})
  void testFindByEntityKind_whenEmpty_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);
    Optional<EntityReference> qualifierReference = Optional.empty();

    // Act
    List<AssessmentRating> actualFindByEntityKindResult =
        assessmentRatingDao.findByEntityKind(EntityKind.ALL, qualifierReference);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByEntityKindResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingDao#findByDefinitionId(long)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findByDefinitionId(long)}
   */
  @Test
  @DisplayName("Test findByDefinitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findByDefinitionId(long)"})
  void testFindByDefinitionId() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new MappingException("An error occurred"));

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.findByDefinitionId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link AssessmentRatingDao#findByDefinitionId(long)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findByDefinitionId(long)}
   */
  @Test
  @DisplayName("Test findByDefinitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findByDefinitionId(long)"})
  void testFindByDefinitionId2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new MappingException("An error occurred"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.findByDefinitionId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link AssessmentRatingDao#findByDefinitionId(long)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findByDefinitionId(long)}
   */
  @Test
  @DisplayName("Test findByDefinitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findByDefinitionId(long)"})
  void testFindByDefinitionId3() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.findByDefinitionId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link AssessmentRatingDao#findByDefinitionId(long)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findByDefinitionId(long)}
   */
  @Test
  @DisplayName("Test findByDefinitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findByDefinitionId(long)"})
  void testFindByDefinitionId4() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.findByDefinitionId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link AssessmentRatingDao#findByDefinitionId(long)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findByDefinitionId(long)}
   */
  @Test
  @DisplayName("Test findByDefinitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findByDefinitionId(long)"})
  void testFindByDefinitionId5() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.findByDefinitionId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link AssessmentRatingDao#findByDefinitionId(long)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findByDefinitionId(long)}
   */
  @Test
  @DisplayName("Test findByDefinitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findByDefinitionId(long)"})
  void testFindByDefinitionId6() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.findByDefinitionId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link AssessmentRatingDao#findByDefinitionId(long)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findByDefinitionId(long)}
   */
  @Test
  @DisplayName("Test findByDefinitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findByDefinitionId(long)"})
  void testFindByDefinitionId7() {
    // Arrange
    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.findByDefinitionId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link AssessmentRatingDao#findByDefinitionId(long)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findByDefinitionId(long)}
   */
  @Test
  @DisplayName("Test findByDefinitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findByDefinitionId(long)"})
  void testFindByDefinitionId8() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.findByDefinitionId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).and(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link AssessmentRatingDao#findByDefinitionId(long)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findByDefinitionId(long)}
   */
  @Test
  @DisplayName("Test findByDefinitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findByDefinitionId(long)"})
  void testFindByDefinitionId9() throws DataAccessException {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.findByDefinitionId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).and(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link AssessmentRatingDao#findByDefinitionId(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#findByDefinitionId(long)}
   */
  @Test
  @DisplayName("Test findByDefinitionId(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingDao.findByDefinitionId(long)"})
  void testFindByDefinitionId_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);

    // Act
    List<AssessmentRating> actualFindByDefinitionIdResult =
        assessmentRatingDao.findByDefinitionId(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).and(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualFindByDefinitionIdResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test store(SaveAssessmentRatingCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore() {
    // Arrange
    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.entityReference()).thenThrow(new MappingException("An error occurred"));

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.store(command));
    verify(command).entityReference();
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test store(SaveAssessmentRatingCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore2() {
    // Arrange
    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.assessmentDefinitionId()).thenThrow(new MappingException("An error occurred"));
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.store(command));
    verify(command).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test store(SaveAssessmentRatingCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore3() {
    // Arrange
    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.lastUpdatedBy()).thenThrow(new MappingException("An error occurred"));
    when(command.comment()).thenReturn("Comment");
    when(command.assessmentDefinitionId()).thenReturn(1L);
    when(command.ratingId()).thenReturn(1L);
    when(command.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.store(command));
    verify(command).comment();
    verify(command).lastUpdatedAt();
    verify(command).lastUpdatedBy();
    verify(command).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
    verify(command).ratingId();
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test store(SaveAssessmentRatingCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore4() {
    // Arrange
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new MappingException("An error occurred"));
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.lastUpdatedBy()).thenReturn("2020-03-01");
    when(command.isReadOnly()).thenReturn(true);
    when(command.provenance()).thenReturn("Provenance");
    when(command.comment()).thenReturn("Comment");
    when(command.assessmentDefinitionId()).thenReturn(1L);
    when(command.ratingId()).thenReturn(1L);
    when(command.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.store(command));
    verify(command).comment();
    verify(command).isReadOnly();
    verify(command).lastUpdatedAt();
    verify(command).lastUpdatedBy();
    verify(command).provenance();
    verify(command).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
    verify(command).ratingId();
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test store(SaveAssessmentRatingCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore5() {
    // Arrange
    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.lastUpdatedBy()).thenReturn("2020-03-01");
    when(command.isReadOnly()).thenReturn(true);
    when(command.provenance()).thenReturn("Provenance");
    when(command.comment()).thenReturn("Comment");
    when(command.assessmentDefinitionId()).thenReturn(1L);
    when(command.ratingId()).thenReturn(1L);
    when(command.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.store(command));
    verify(command).comment();
    verify(command).isReadOnly();
    verify(command).lastUpdatedAt();
    verify(command).lastUpdatedBy();
    verify(command).provenance();
    verify(command).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
    verify(command).ratingId();
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test store(SaveAssessmentRatingCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore6() {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.lastUpdatedBy()).thenReturn("2020-03-01");
    when(command.isReadOnly()).thenReturn(true);
    when(command.provenance()).thenReturn("Provenance");
    when(command.comment()).thenReturn("Comment");
    when(command.assessmentDefinitionId()).thenReturn(1L);
    when(command.ratingId()).thenReturn(1L);
    when(command.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.store(command));
    verify(command).comment();
    verify(command).isReadOnly();
    verify(command).lastUpdatedAt();
    verify(command).lastUpdatedBy();
    verify(command).provenance();
    verify(command).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
    verify(command).ratingId();
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test store(SaveAssessmentRatingCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore7() {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.lastUpdatedBy()).thenReturn("2020-03-01");
    when(command.isReadOnly()).thenReturn(true);
    when(command.provenance()).thenReturn("Provenance");
    when(command.comment()).thenReturn("Comment");
    when(command.assessmentDefinitionId()).thenReturn(1L);
    when(command.ratingId()).thenReturn(1L);
    when(command.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.store(command));
    verify(command).comment();
    verify(command).isReadOnly();
    verify(command).lastUpdatedAt();
    verify(command).lastUpdatedBy();
    verify(command).provenance();
    verify(command, atLeast(1)).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
    verify(command).ratingId();
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test store(SaveAssessmentRatingCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore8() {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record1<Object>> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.lastUpdatedBy()).thenReturn("2020-03-01");
    when(command.isReadOnly()).thenReturn(true);
    when(command.provenance()).thenReturn("Provenance");
    when(command.comment()).thenReturn("Comment");
    when(command.assessmentDefinitionId()).thenReturn(1L);
    when(command.ratingId()).thenReturn(1L);
    when(command.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.store(command));
    verify(command).comment();
    verify(command).isReadOnly();
    verify(command).lastUpdatedAt();
    verify(command).lastUpdatedBy();
    verify(command).provenance();
    verify(command, atLeast(1)).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
    verify(command, atLeast(1)).ratingId();
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test store(SaveAssessmentRatingCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore9() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record1<Object>> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any()))
        .thenThrow(new MappingException("An error occurred"));
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.lastUpdatedBy()).thenReturn("2020-03-01");
    when(command.isReadOnly()).thenReturn(true);
    when(command.provenance()).thenReturn("Provenance");
    when(command.comment()).thenReturn("Comment");
    when(command.assessmentDefinitionId()).thenReturn(1L);
    when(command.ratingId()).thenReturn(1L);
    when(command.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.store(command));
    verify(command).comment();
    verify(command).isReadOnly();
    verify(command).lastUpdatedAt();
    verify(command).lastUpdatedBy();
    verify(command).provenance();
    verify(command, atLeast(1)).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
    verify(command, atLeast(1)).ratingId();
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test store(SaveAssessmentRatingCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore10() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record1<Object>> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any()))
        .thenThrow(new MappingException("An error occurred"));
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.lastUpdatedBy()).thenReturn("2020-03-01");
    when(command.isReadOnly()).thenReturn(true);
    when(command.provenance()).thenReturn("Provenance");
    when(command.comment()).thenReturn("Comment");
    when(command.assessmentDefinitionId()).thenReturn(1L);
    when(command.ratingId()).thenReturn(1L);
    when(command.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.store(command));
    verify(command).comment();
    verify(command).isReadOnly();
    verify(command).lastUpdatedAt();
    verify(command).lastUpdatedBy();
    verify(command).provenance();
    verify(command, atLeast(1)).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
    verify(command, atLeast(1)).ratingId();
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test store(SaveAssessmentRatingCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore11() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record1<Object>> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.lastUpdatedBy()).thenReturn("2020-03-01");
    when(command.isReadOnly()).thenReturn(true);
    when(command.provenance()).thenReturn("Provenance");
    when(command.comment()).thenReturn("[‐–—-]");
    when(command.assessmentDefinitionId()).thenReturn(1L);
    when(command.ratingId()).thenReturn(1L);
    when(command.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualStoreResult = assessmentRatingDao.store(command);

    // Assert
    verify(command).comment();
    verify(command).isReadOnly();
    verify(command).lastUpdatedAt();
    verify(command).lastUpdatedBy();
    verify(command).provenance();
    verify(command, atLeast(1)).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
    verify(command, atLeast(1)).ratingId();
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualStoreResult);
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test store(SaveAssessmentRatingCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore12() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record1<Object>> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.lastUpdatedBy()).thenReturn("2020-03-01");
    when(command.isReadOnly()).thenReturn(true);
    when(command.provenance()).thenReturn("Provenance");
    when(command.comment()).thenReturn("[”“]");
    when(command.assessmentDefinitionId()).thenReturn(1L);
    when(command.ratingId()).thenReturn(1L);
    when(command.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualStoreResult = assessmentRatingDao.store(command);

    // Assert
    verify(command).comment();
    verify(command).isReadOnly();
    verify(command).lastUpdatedAt();
    verify(command).lastUpdatedBy();
    verify(command).provenance();
    verify(command, atLeast(1)).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
    verify(command, atLeast(1)).ratingId();
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualStoreResult);
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test store(SaveAssessmentRatingCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore13() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record1<Object>> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.lastUpdatedBy()).thenReturn("2020-03-01");
    when(command.isReadOnly()).thenReturn(true);
    when(command.provenance()).thenReturn("Provenance");
    when(command.comment()).thenReturn("[’‘]");
    when(command.assessmentDefinitionId()).thenReturn(1L);
    when(command.ratingId()).thenReturn(1L);
    when(command.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualStoreResult = assessmentRatingDao.store(command);

    // Assert
    verify(command).comment();
    verify(command).isReadOnly();
    verify(command).lastUpdatedAt();
    verify(command).lastUpdatedBy();
    verify(command).provenance();
    verify(command, atLeast(1)).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
    verify(command, atLeast(1)).ratingId();
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualStoreResult);
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <ul>
   *   <li>Given {@code &amp;}.
   *   <li>When {@link SaveAssessmentRatingCommand} {@link SaveAssessmentRatingCommand#comment()}
   *       return {@code &amp;}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test store(SaveAssessmentRatingCommand); given '&amp;'; when SaveAssessmentRatingCommand comment() return '&amp;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore_givenAmp_whenSaveAssessmentRatingCommandCommentReturnAmp()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record1<Object>> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.lastUpdatedBy()).thenReturn("2020-03-01");
    when(command.isReadOnly()).thenReturn(true);
    when(command.provenance()).thenReturn("Provenance");
    when(command.comment()).thenReturn("&amp;");
    when(command.assessmentDefinitionId()).thenReturn(1L);
    when(command.ratingId()).thenReturn(1L);
    when(command.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualStoreResult = assessmentRatingDao.store(command);

    // Assert
    verify(command).comment();
    verify(command).isReadOnly();
    verify(command).lastUpdatedAt();
    verify(command).lastUpdatedBy();
    verify(command).provenance();
    verify(command, atLeast(1)).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
    verify(command, atLeast(1)).ratingId();
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualStoreResult);
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#executeInsert(TableRecord)} return one.
   *   <li>Then calls {@link DSLContext#executeInsert(TableRecord)}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test store(SaveAssessmentRatingCommand); given DSLContext executeInsert(TableRecord) return one; then calls executeInsert(TableRecord)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore_givenDSLContextExecuteInsertReturnOne_thenCallsExecuteInsert()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record1<Object>> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(false);
    when(dSLContext.executeInsert(Mockito.<TableRecord<?>>any())).thenReturn(1);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.lastUpdatedBy()).thenReturn("2020-03-01");
    when(command.isReadOnly()).thenReturn(true);
    when(command.provenance()).thenReturn("Provenance");
    when(command.comment()).thenReturn("Comment");
    when(command.assessmentDefinitionId()).thenReturn(1L);
    when(command.ratingId()).thenReturn(1L);
    when(command.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualStoreResult = assessmentRatingDao.store(command);

    // Assert
    verify(command).comment();
    verify(command).isReadOnly();
    verify(command).lastUpdatedAt();
    verify(command).lastUpdatedBy();
    verify(command).provenance();
    verify(command, atLeast(1)).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
    verify(command, atLeast(1)).ratingId();
    verify(dSLContext).executeInsert(isA(TableRecord.class));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualStoreResult);
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#executeInsert(TableRecord)} return two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test store(SaveAssessmentRatingCommand); given DSLContext executeInsert(TableRecord) return two; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore_givenDSLContextExecuteInsertReturnTwo_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record1<Object>> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(false);
    when(dSLContext.executeInsert(Mockito.<TableRecord<?>>any())).thenReturn(2);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.lastUpdatedBy()).thenReturn("2020-03-01");
    when(command.isReadOnly()).thenReturn(true);
    when(command.provenance()).thenReturn("Provenance");
    when(command.comment()).thenReturn("Comment");
    when(command.assessmentDefinitionId()).thenReturn(1L);
    when(command.ratingId()).thenReturn(1L);
    when(command.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualStoreResult = assessmentRatingDao.store(command);

    // Assert
    verify(command).comment();
    verify(command).isReadOnly();
    verify(command).lastUpdatedAt();
    verify(command).lastUpdatedBy();
    verify(command).provenance();
    verify(command, atLeast(1)).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
    verify(command, atLeast(1)).ratingId();
    verify(dSLContext).executeInsert(isA(TableRecord.class));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertFalse(actualStoreResult);
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#executeUpdate(UpdatableRecord)} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test store(SaveAssessmentRatingCommand); given DSLContext executeUpdate(UpdatableRecord) return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore_givenDSLContextExecuteUpdateReturnOne_thenReturnTrue() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record1<Object>> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.lastUpdatedBy()).thenReturn("2020-03-01");
    when(command.isReadOnly()).thenReturn(true);
    when(command.provenance()).thenReturn("Provenance");
    when(command.comment()).thenReturn("Comment");
    when(command.assessmentDefinitionId()).thenReturn(1L);
    when(command.ratingId()).thenReturn(1L);
    when(command.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualStoreResult = assessmentRatingDao.store(command);

    // Assert
    verify(command).comment();
    verify(command).isReadOnly();
    verify(command).lastUpdatedAt();
    verify(command).lastUpdatedBy();
    verify(command).provenance();
    verify(command, atLeast(1)).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
    verify(command, atLeast(1)).ratingId();
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualStoreResult);
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#executeUpdate(UpdatableRecord)} return two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test store(SaveAssessmentRatingCommand); given DSLContext executeUpdate(UpdatableRecord) return two; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore_givenDSLContextExecuteUpdateReturnTwo_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record1<Object>> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(2);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.lastUpdatedBy()).thenReturn("2020-03-01");
    when(command.isReadOnly()).thenReturn(true);
    when(command.provenance()).thenReturn("Provenance");
    when(command.comment()).thenReturn("Comment");
    when(command.assessmentDefinitionId()).thenReturn(1L);
    when(command.ratingId()).thenReturn(1L);
    when(command.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualStoreResult = assessmentRatingDao.store(command);

    // Assert
    verify(command).comment();
    verify(command).isReadOnly();
    verify(command).lastUpdatedAt();
    verify(command).lastUpdatedBy();
    verify(command).provenance();
    verify(command, atLeast(1)).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
    verify(command, atLeast(1)).ratingId();
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertFalse(actualStoreResult);
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectField)} throw {@link
   *       MappingException#MappingException(String)} with message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test store(SaveAssessmentRatingCommand); given DSLContext select(SelectField) throw MappingException(String) with message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore_givenDSLContextSelectThrowMappingExceptionWithMessageIsAnErrorOccurred() {
    // Arrange
    when(dSLContext.select(Mockito.<SelectField<Object>>any()))
        .thenThrow(new MappingException("An error occurred"));

    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.lastUpdatedBy()).thenReturn("2020-03-01");
    when(command.isReadOnly()).thenReturn(true);
    when(command.provenance()).thenReturn("Provenance");
    when(command.comment()).thenReturn("Comment");
    when(command.assessmentDefinitionId()).thenReturn(1L);
    when(command.ratingId()).thenReturn(1L);
    when(command.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.store(command));
    verify(command).comment();
    verify(command).isReadOnly();
    verify(command).lastUpdatedAt();
    verify(command).lastUpdatedBy();
    verify(command).provenance();
    verify(command).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
    verify(command).ratingId();
    verify(dSLContext).select(isA(SelectField.class));
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <ul>
   *   <li>Given {@code “}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test store(SaveAssessmentRatingCommand); given '“'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore_givenLeftDoubleQuotationMark() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record1<Object>> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.lastUpdatedBy()).thenReturn("2020-03-01");
    when(command.isReadOnly()).thenReturn(true);
    when(command.provenance()).thenReturn("Provenance");
    when(command.comment()).thenReturn("“");
    when(command.assessmentDefinitionId()).thenReturn(1L);
    when(command.ratingId()).thenReturn(1L);
    when(command.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualStoreResult = assessmentRatingDao.store(command);

    // Assert
    verify(command).comment();
    verify(command).isReadOnly();
    verify(command).lastUpdatedAt();
    verify(command).lastUpdatedBy();
    verify(command).provenance();
    verify(command, atLeast(1)).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
    verify(command, atLeast(1)).ratingId();
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualStoreResult);
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <ul>
   *   <li>Given {@code ‘}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test store(SaveAssessmentRatingCommand); given '‘'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore_givenLeftSingleQuotationMark() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record1<Object>> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.lastUpdatedBy()).thenReturn("2020-03-01");
    when(command.isReadOnly()).thenReturn(true);
    when(command.provenance()).thenReturn("Provenance");
    when(command.comment()).thenReturn("‘");
    when(command.assessmentDefinitionId()).thenReturn(1L);
    when(command.ratingId()).thenReturn(1L);
    when(command.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualStoreResult = assessmentRatingDao.store(command);

    // Assert
    verify(command).comment();
    verify(command).isReadOnly();
    verify(command).lastUpdatedAt();
    verify(command).lastUpdatedBy();
    verify(command).provenance();
    verify(command, atLeast(1)).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
    verify(command, atLeast(1)).ratingId();
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualStoreResult);
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <ul>
   *   <li>Given nbsp.
   *   <li>When {@link SaveAssessmentRatingCommand} {@link SaveAssessmentRatingCommand#comment()}
   *       return nbsp.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test store(SaveAssessmentRatingCommand); given nbsp; when SaveAssessmentRatingCommand comment() return nbsp")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore_givenNbsp_whenSaveAssessmentRatingCommandCommentReturnNbsp()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record1<Object>> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.lastUpdatedBy()).thenReturn("2020-03-01");
    when(command.isReadOnly()).thenReturn(true);
    when(command.provenance()).thenReturn("Provenance");
    when(command.comment()).thenReturn(" ");
    when(command.assessmentDefinitionId()).thenReturn(1L);
    when(command.ratingId()).thenReturn(1L);
    when(command.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualStoreResult = assessmentRatingDao.store(command);

    // Assert
    verify(command).comment();
    verify(command).isReadOnly();
    verify(command).lastUpdatedAt();
    verify(command).lastUpdatedBy();
    verify(command).provenance();
    verify(command, atLeast(1)).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
    verify(command, atLeast(1)).ratingId();
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualStoreResult);
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <ul>
   *   <li>Given {@code ​}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test store(SaveAssessmentRatingCommand); given '​'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore_givenZeroWidthSpace() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record1<Object>> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.lastUpdatedBy()).thenReturn("2020-03-01");
    when(command.isReadOnly()).thenReturn(true);
    when(command.provenance()).thenReturn("Provenance");
    when(command.comment()).thenReturn("​");
    when(command.assessmentDefinitionId()).thenReturn(1L);
    when(command.ratingId()).thenReturn(1L);
    when(command.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualStoreResult = assessmentRatingDao.store(command);

    // Assert
    verify(command).comment();
    verify(command).isReadOnly();
    verify(command).lastUpdatedAt();
    verify(command).lastUpdatedBy();
    verify(command).provenance();
    verify(command, atLeast(1)).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
    verify(command, atLeast(1)).ratingId();
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualStoreResult);
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <ul>
   *   <li>Given {@code â€œ}.
   *   <li>When {@link SaveAssessmentRatingCommand} {@link SaveAssessmentRatingCommand#comment()}
   *       return {@code â€œ}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test store(SaveAssessmentRatingCommand); given 'â€œ'; when SaveAssessmentRatingCommand comment() return 'â€œ'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore_given_whenSaveAssessmentRatingCommandCommentReturn_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record1<Object>> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.lastUpdatedBy()).thenReturn("2020-03-01");
    when(command.isReadOnly()).thenReturn(true);
    when(command.provenance()).thenReturn("Provenance");
    when(command.comment()).thenReturn("â€œ");
    when(command.assessmentDefinitionId()).thenReturn(1L);
    when(command.ratingId()).thenReturn(1L);
    when(command.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualStoreResult = assessmentRatingDao.store(command);

    // Assert
    verify(command).comment();
    verify(command).isReadOnly();
    verify(command).lastUpdatedAt();
    verify(command).lastUpdatedBy();
    verify(command).provenance();
    verify(command, atLeast(1)).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
    verify(command, atLeast(1)).ratingId();
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualStoreResult);
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <ul>
   *   <li>Given â€ operating system command.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test store(SaveAssessmentRatingCommand); given â€ operating system command")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore_givenÂ€OperatingSystemCommand() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record1<Object>> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.lastUpdatedBy()).thenReturn("2020-03-01");
    when(command.isReadOnly()).thenReturn(true);
    when(command.provenance()).thenReturn("Provenance");
    when(command.comment()).thenReturn("â€");
    when(command.assessmentDefinitionId()).thenReturn(1L);
    when(command.ratingId()).thenReturn(1L);
    when(command.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualStoreResult = assessmentRatingDao.store(command);

    // Assert
    verify(command).comment();
    verify(command).isReadOnly();
    verify(command).lastUpdatedAt();
    verify(command).lastUpdatedBy();
    verify(command).provenance();
    verify(command, atLeast(1)).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
    verify(command, atLeast(1)).ratingId();
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualStoreResult);
  }

  /**
   * Test {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}.
   *
   * <ul>
   *   <li>Given â€ trade mark sign.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#store(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test store(SaveAssessmentRatingCommand); given â€ trade mark sign")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.store(SaveAssessmentRatingCommand)"})
  void testStore_givenÂ€TradeMarkSign() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record1<Object>> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.lastUpdatedBy()).thenReturn("2020-03-01");
    when(command.isReadOnly()).thenReturn(true);
    when(command.provenance()).thenReturn("Provenance");
    when(command.comment()).thenReturn("â€™");
    when(command.assessmentDefinitionId()).thenReturn(1L);
    when(command.ratingId()).thenReturn(1L);
    when(command.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualStoreResult = assessmentRatingDao.store(command);

    // Assert
    verify(command).comment();
    verify(command).isReadOnly();
    verify(command).lastUpdatedAt();
    verify(command).lastUpdatedBy();
    verify(command).provenance();
    verify(command, atLeast(1)).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
    verify(command, atLeast(1)).ratingId();
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualStoreResult);
  }

  /**
   * Test {@link AssessmentRatingDao#isUpdate(SaveAssessmentRatingCommand)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#isUpdate(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test isUpdate(SaveAssessmentRatingCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.isUpdate(SaveAssessmentRatingCommand)"})
  void testIsUpdate() {
    // Arrange
    when(dSLContext.select(Mockito.<SelectField<Object>>any()))
        .thenThrow(new MappingException("An error occurred"));

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.isUpdate(
                commentResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .provenance("Provenance")
                    .ratingId(1L)
                    .build()));
    verify(dSLContext).select(isA(SelectField.class));
  }

  /**
   * Test {@link AssessmentRatingDao#isUpdate(SaveAssessmentRatingCommand)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#isUpdate(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test isUpdate(SaveAssessmentRatingCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.isUpdate(SaveAssessmentRatingCommand)"})
  void testIsUpdate2() {
    // Arrange
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new MappingException("An error occurred"));
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.isUpdate(
                commentResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .provenance("Provenance")
                    .ratingId(1L)
                    .build()));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link AssessmentRatingDao#isUpdate(SaveAssessmentRatingCommand)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#isUpdate(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test isUpdate(SaveAssessmentRatingCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.isUpdate(SaveAssessmentRatingCommand)"})
  void testIsUpdate3() {
    // Arrange
    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.isUpdate(
                commentResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .provenance("Provenance")
                    .ratingId(1L)
                    .build()));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#isUpdate(SaveAssessmentRatingCommand)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#isUpdate(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test isUpdate(SaveAssessmentRatingCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.isUpdate(SaveAssessmentRatingCommand)"})
  void testIsUpdate4() {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.isUpdate(
                commentResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .provenance("Provenance")
                    .ratingId(1L)
                    .build()));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#isUpdate(SaveAssessmentRatingCommand)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#isUpdate(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test isUpdate(SaveAssessmentRatingCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.isUpdate(SaveAssessmentRatingCommand)"})
  void testIsUpdate5() {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.isUpdate(
                commentResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .provenance("Provenance")
                    .ratingId(1L)
                    .build()));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#isUpdate(SaveAssessmentRatingCommand)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#isUpdate(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test isUpdate(SaveAssessmentRatingCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.isUpdate(SaveAssessmentRatingCommand)"})
  void testIsUpdate6() {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record1<Object>> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.isUpdate(
                commentResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .provenance("Provenance")
                    .ratingId(1L)
                    .build()));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#isUpdate(SaveAssessmentRatingCommand)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#isUpdate(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test isUpdate(SaveAssessmentRatingCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.isUpdate(SaveAssessmentRatingCommand)"})
  void testIsUpdate7() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record1<Object>> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any()))
        .thenThrow(new MappingException("An error occurred"));
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.isUpdate(
                commentResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .provenance("Provenance")
                    .ratingId(1L)
                    .build()));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#isUpdate(SaveAssessmentRatingCommand)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchExists(Select)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#isUpdate(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test isUpdate(SaveAssessmentRatingCommand); given DSLContext fetchExists(Select) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.isUpdate(SaveAssessmentRatingCommand)"})
  void testIsUpdate_givenDSLContextFetchExistsReturnFalse_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record1<Object>> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(false);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act
    boolean actualIsUpdateResult =
        assessmentRatingDao.isUpdate(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertFalse(actualIsUpdateResult);
  }

  /**
   * Test {@link AssessmentRatingDao#isUpdate(SaveAssessmentRatingCommand)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchExists(Select)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#isUpdate(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test isUpdate(SaveAssessmentRatingCommand); given DSLContext fetchExists(Select) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.isUpdate(SaveAssessmentRatingCommand)"})
  void testIsUpdate_givenDSLContextFetchExistsReturnTrue_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectConditionStep<Record1<Object>> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record1<Object>> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act
    boolean actualIsUpdateResult =
        assessmentRatingDao.isUpdate(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualIsUpdateResult);
  }

  /**
   * Test {@link AssessmentRatingDao#isUpdate(SaveAssessmentRatingCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#isUpdate(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test isUpdate(SaveAssessmentRatingCommand); then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.isUpdate(SaveAssessmentRatingCommand)"})
  void testIsUpdate_thenCallsPrepareStatement() throws SQLException {
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
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act
    boolean actualIsUpdateResult =
        assessmentRatingDao.isUpdate(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" where exists (select \"assessment_rating\".\"id\" from \"assessment_rating\" where (\"assessment_rating\".\"entity_kind\" = ? and \"assessment_rating\".\"entity_id\" = ? and \"assessment_rating\".\"assessment_definition_id\" = ? and \"assessment_rating\".\"rating_id\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(1, "ALL");
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualIsUpdateResult);
  }

  /**
   * Test {@link AssessmentRatingDao#bulkRemove(Set)} with {@code assessmentRatings}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkRemove(Set)}
   */
  @Test
  @DisplayName("Test bulkRemove(Set) with 'assessmentRatings'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkRemove(Set)"})
  void testBulkRemoveWithAssessmentRatings() {
    // Arrange
    when(dSLContext.batch(Mockito.<Collection<Query>>any()))
        .thenThrow(new MappingException("An error occurred"));

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.bulkRemove(new HashSet<>()));
    verify(dSLContext).batch(isA(Collection.class));
  }

  /**
   * Test {@link AssessmentRatingDao#bulkRemove(Set)} with {@code assessmentRatings}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkRemove(Set)}
   */
  @Test
  @DisplayName("Test bulkRemove(Set) with 'assessmentRatings'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkRemove(Set)"})
  void testBulkRemoveWithAssessmentRatings2() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    // Act
    int actualBulkRemoveResult = assessmentRatingDao.bulkRemove(new HashSet<>());

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
    assertEquals(4, actualBulkRemoveResult);
  }

  /**
   * Test {@link AssessmentRatingDao#bulkRemove(Set)} with {@code assessmentRatings}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkRemove(Set)}
   */
  @Test
  @DisplayName("Test bulkRemove(Set) with 'assessmentRatings'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkRemove(Set)"})
  void testBulkRemoveWithAssessmentRatings3() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenThrow(new MappingException("An error occurred"));
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.bulkRemove(new HashSet<>()));
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
  }

  /**
   * Test {@link AssessmentRatingDao#bulkRemove(Set)} with {@code assessmentRatings}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkRemove(Set)}
   */
  @Test
  @DisplayName("Test bulkRemove(Set) with 'assessmentRatings'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkRemove(Set)"})
  void testBulkRemoveWithAssessmentRatings4() {
    // Arrange
    when(dSLContext.deleteFrom(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenThrow(new MappingException("An error occurred"));

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();

    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatings.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.bulkRemove(assessmentRatings));
    verify(dSLContext).deleteFrom(isA(Table.class));
  }

  /**
   * Test {@link AssessmentRatingDao#bulkRemove(Set)} with {@code assessmentRatings}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkRemove(Set)}
   */
  @Test
  @DisplayName("Test bulkRemove(Set) with 'assessmentRatings'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkRemove(Set)"})
  void testBulkRemoveWithAssessmentRatings5() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    DeleteUsingStep<AssessmentRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any()))
        .thenReturn(mock(DeleteConditionStep.class));
    when(dSLContext.deleteFrom(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(deleteUsingStep);
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();

    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatings.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    // Act
    int actualBulkRemoveResult = assessmentRatingDao.bulkRemove(assessmentRatings);

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    assertEquals(4, actualBulkRemoveResult);
  }

  /**
   * Test {@link AssessmentRatingDao#bulkRemove(Set)} with {@code assessmentRatings}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkRemove(Set)}
   */
  @Test
  @DisplayName("Test bulkRemove(Set) with 'assessmentRatings'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkRemove(Set)"})
  void testBulkRemoveWithAssessmentRatings6() {
    // Arrange
    DeleteUsingStep<AssessmentRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));
    when(dSLContext.deleteFrom(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(deleteUsingStep);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();

    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatings.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.bulkRemove(assessmentRatings));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#bulkRemove(Set)} with {@code assessmentRatings}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#createStatement()}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkRemove(Set)}
   */
  @Test
  @DisplayName("Test bulkRemove(Set) with 'assessmentRatings'; then calls createStatement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkRemove(Set)"})
  void testBulkRemoveWithAssessmentRatings_thenCallsCreateStatement() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);

    // Act
    int actualBulkRemoveResult = assessmentRatingDao.bulkRemove(new HashSet<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertEquals(4, actualBulkRemoveResult);
  }

  /**
   * Test {@link AssessmentRatingDao#bulkRemove(Set)} with {@code assessmentRatings}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkRemove(Set)}
   */
  @Test
  @DisplayName("Test bulkRemove(Set) with 'assessmentRatings'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkRemove(Set)"})
  void testBulkRemoveWithAssessmentRatings_whenNull() {
    // Arrange
    when(dSLContext.batch(Mockito.<Collection<Query>>any()))
        .thenThrow(new MappingException("An error occurred"));

    // Act and Assert
    assertThrows(
        MappingException.class, () -> assessmentRatingDao.bulkRemove((Set<AssessmentRating>) null));
    verify(dSLContext).batch(isA(Collection.class));
  }

  /**
   * Test {@link AssessmentRatingDao#bulkRemove(RemoveAssessmentRatingCommand)} with {@code rating}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkRemove(RemoveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test bulkRemove(RemoveAssessmentRatingCommand) with 'rating'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.bulkRemove(RemoveAssessmentRatingCommand)"})
  void testBulkRemoveWithRating() {
    // Arrange
    when(dSLContext.deleteFrom(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenThrow(new MappingException("An error occurred"));

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.bulkRemove((RemoveAssessmentRatingCommand) null));
    verify(dSLContext).deleteFrom(isA(Table.class));
  }

  /**
   * Test {@link AssessmentRatingDao#bulkRemove(RemoveAssessmentRatingCommand)} with {@code rating}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkRemove(RemoveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test bulkRemove(RemoveAssessmentRatingCommand) with 'rating'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.bulkRemove(RemoveAssessmentRatingCommand)"})
  void testBulkRemoveWithRating2() {
    // Arrange
    DeleteUsingStep<AssessmentRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));
    when(dSLContext.deleteFrom(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(deleteUsingStep);

    ImmutableRemoveAssessmentRatingCommand.Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.bulkRemove(
                assessmentDefinitionIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .ratingId(1L)
                    .build()));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#bulkRemove(RemoveAssessmentRatingCommand)} with {@code rating}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkRemove(RemoveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test bulkRemove(RemoveAssessmentRatingCommand) with 'rating'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.bulkRemove(RemoveAssessmentRatingCommand)"})
  void testBulkRemoveWithRating3() {
    // Arrange
    DeleteConditionStep<AssessmentRatingRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    DeleteUsingStep<AssessmentRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(deleteUsingStep);

    ImmutableRemoveAssessmentRatingCommand.Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.bulkRemove(
                assessmentDefinitionIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .ratingId(1L)
                    .build()));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#bulkRemove(RemoveAssessmentRatingCommand)} with {@code rating}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkRemove(RemoveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test bulkRemove(RemoveAssessmentRatingCommand) with 'rating'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.bulkRemove(RemoveAssessmentRatingCommand)"})
  void testBulkRemoveWithRating4() {
    // Arrange
    DeleteConditionStep<AssessmentRatingRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    DeleteConditionStep<AssessmentRatingRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<AssessmentRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(deleteUsingStep);

    ImmutableRemoveAssessmentRatingCommand.Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.bulkRemove(
                assessmentDefinitionIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .ratingId(1L)
                    .build()));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteConditionStep).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#bulkRemove(RemoveAssessmentRatingCommand)} with {@code rating}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkRemove(RemoveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test bulkRemove(RemoveAssessmentRatingCommand) with 'rating'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.bulkRemove(RemoveAssessmentRatingCommand)"})
  void testBulkRemoveWithRating5() throws DataAccessException {
    // Arrange
    DeleteConditionStep<AssessmentRatingRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenThrow(new MappingException("An error occurred"));

    DeleteConditionStep<AssessmentRatingRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<AssessmentRatingRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteUsingStep<AssessmentRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    when(dSLContext.deleteFrom(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(deleteUsingStep);

    ImmutableRemoveAssessmentRatingCommand.Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.bulkRemove(
                assessmentDefinitionIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .ratingId(1L)
                    .build()));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
  }

  /**
   * Test {@link AssessmentRatingDao#bulkRemove(RemoveAssessmentRatingCommand)} with {@code rating}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkRemove(RemoveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test bulkRemove(RemoveAssessmentRatingCommand) with 'rating'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.bulkRemove(RemoveAssessmentRatingCommand)"})
  void testBulkRemoveWithRating6() throws SQLException {
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
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);

    ImmutableRemoveAssessmentRatingCommand.Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act
    boolean actualBulkRemoveResult =
        assessmentRatingDao.bulkRemove(
            assessmentDefinitionIdResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .ratingId(1L)
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"assessment_rating\" where (\"assessment_rating\".\"entity_kind\" = cast(? as varchar(3)) and \"assessment_rating\".\"entity_id\" = cast(? as bigint) and \"assessment_rating\".\"assessment_definition_id\" = cast(? as bigint) and \"assessment_rating\".\"rating_id\" = cast(? as bigint))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(1, "ALL");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualBulkRemoveResult);
  }

  /**
   * Test {@link AssessmentRatingDao#bulkRemove(RemoveAssessmentRatingCommand)} with {@code rating}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkRemove(RemoveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test bulkRemove(RemoveAssessmentRatingCommand) with 'rating'; given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.bulkRemove(RemoveAssessmentRatingCommand)"})
  void testBulkRemoveWithRating_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
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
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);

    ImmutableRemoveAssessmentRatingCommand.Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act
    boolean actualBulkRemoveResult =
        assessmentRatingDao.bulkRemove(
            assessmentDefinitionIdResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .ratingId(1L)
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"assessment_rating\" where (\"assessment_rating\".\"entity_kind\" = cast(? as varchar) and \"assessment_rating\".\"entity_id\" = cast(? as bigint) and \"assessment_rating\".\"assessment_definition_id\" = cast(? as bigint) and \"assessment_rating\".\"rating_id\" = cast(? as bigint))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(1, "ALL");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualBulkRemoveResult);
  }

  /**
   * Test {@link AssessmentRatingDao#bulkRemove(RemoveAssessmentRatingCommand)} with {@code rating}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkRemove(RemoveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test bulkRemove(RemoveAssessmentRatingCommand) with 'rating'; given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.bulkRemove(RemoveAssessmentRatingCommand)"})
  void testBulkRemoveWithRating_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
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
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);

    ImmutableRemoveAssessmentRatingCommand.Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act
    boolean actualBulkRemoveResult =
        assessmentRatingDao.bulkRemove(
            assessmentDefinitionIdResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .ratingId(1L)
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"assessment_rating\" where (\"assessment_rating\".\"entity_kind\" = ? and \"assessment_rating\".\"entity_id\" = ? and \"assessment_rating\".\"assessment_definition_id\" = ? and \"assessment_rating\".\"rating_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(1, "ALL");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualBulkRemoveResult);
  }

  /**
   * Test {@link AssessmentRatingDao#bulkRemove(RemoveAssessmentRatingCommand)} with {@code rating}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkRemove(RemoveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test bulkRemove(RemoveAssessmentRatingCommand) with 'rating'; given DeleteConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.bulkRemove(RemoveAssessmentRatingCommand)"})
  void testBulkRemoveWithRating_givenDeleteConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<AssessmentRatingRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<AssessmentRatingRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<AssessmentRatingRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteUsingStep<AssessmentRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    when(dSLContext.deleteFrom(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(deleteUsingStep);

    ImmutableRemoveAssessmentRatingCommand.Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act
    boolean actualBulkRemoveResult =
        assessmentRatingDao.bulkRemove(
            assessmentDefinitionIdResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .ratingId(1L)
                .build());

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertTrue(actualBulkRemoveResult);
  }

  /**
   * Test {@link AssessmentRatingDao#bulkRemove(RemoveAssessmentRatingCommand)} with {@code rating}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkRemove(RemoveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test bulkRemove(RemoveAssessmentRatingCommand) with 'rating'; given DeleteConditionStep execute() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.bulkRemove(RemoveAssessmentRatingCommand)"})
  void testBulkRemoveWithRating_givenDeleteConditionStepExecuteReturnZero()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<AssessmentRatingRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);

    DeleteConditionStep<AssessmentRatingRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<AssessmentRatingRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteUsingStep<AssessmentRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    when(dSLContext.deleteFrom(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(deleteUsingStep);

    ImmutableRemoveAssessmentRatingCommand.Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act
    boolean actualBulkRemoveResult =
        assessmentRatingDao.bulkRemove(
            assessmentDefinitionIdResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .ratingId(1L)
                .build());

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertFalse(actualBulkRemoveResult);
  }

  /**
   * Test {@link AssessmentRatingDao#findGroupedByDefinitionAndOutcome(Condition)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findGroupedByDefinitionAndOutcome(Condition)}
   */
  @Test
  @DisplayName("Test findGroupedByDefinitionAndOutcome(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingDao.findGroupedByDefinitionAndOutcome(Condition)"})
  void testFindGroupedByDefinitionAndOutcome() {
    // Arrange
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenThrow(new MappingException("An error occurred"));

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.findGroupedByDefinitionAndOutcome(ApplicationDao.IS_ACTIVE));
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
  }

  /**
   * Test {@link AssessmentRatingDao#findGroupedByDefinitionAndOutcome(Condition)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findGroupedByDefinitionAndOutcome(Condition)}
   */
  @Test
  @DisplayName("Test findGroupedByDefinitionAndOutcome(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingDao.findGroupedByDefinitionAndOutcome(Condition)"})
  void testFindGroupedByDefinitionAndOutcome2() {
    // Arrange
    SelectSelectStep<Record4<Object, Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new MappingException("An error occurred"));
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.findGroupedByDefinitionAndOutcome(ApplicationDao.IS_ACTIVE));
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link AssessmentRatingDao#findGroupedByDefinitionAndOutcome(Condition)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findGroupedByDefinitionAndOutcome(Condition)}
   */
  @Test
  @DisplayName("Test findGroupedByDefinitionAndOutcome(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingDao.findGroupedByDefinitionAndOutcome(Condition)"})
  void testFindGroupedByDefinitionAndOutcome3() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectSelectStep<Record4<Object, Object, Object, Object>> selectSelectStep2 =
        mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.findGroupedByDefinitionAndOutcome(ApplicationDao.IS_ACTIVE));
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link AssessmentRatingDao#findGroupedByDefinitionAndOutcome(Condition)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findGroupedByDefinitionAndOutcome(Condition)}
   */
  @Test
  @DisplayName("Test findGroupedByDefinitionAndOutcome(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingDao.findGroupedByDefinitionAndOutcome(Condition)"})
  void testFindGroupedByDefinitionAndOutcome4() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record4<Object, Object, Object, Object>> selectSelectStep2 =
        mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.findGroupedByDefinitionAndOutcome(ApplicationDao.IS_ACTIVE));
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link AssessmentRatingDao#findGroupedByDefinitionAndOutcome(Condition)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findGroupedByDefinitionAndOutcome(Condition)}
   */
  @Test
  @DisplayName("Test findGroupedByDefinitionAndOutcome(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingDao.findGroupedByDefinitionAndOutcome(Condition)"})
  void testFindGroupedByDefinitionAndOutcome5() {
    // Arrange
    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record4<Object, Object, Object, Object>> selectSelectStep2 =
        mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.findGroupedByDefinitionAndOutcome(ApplicationDao.IS_ACTIVE));
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link AssessmentRatingDao#findGroupedByDefinitionAndOutcome(Condition)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#findGroupedByDefinitionAndOutcome(Condition)}
   */
  @Test
  @DisplayName("Test findGroupedByDefinitionAndOutcome(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingDao.findGroupedByDefinitionAndOutcome(Condition)"})
  void testFindGroupedByDefinitionAndOutcome6() {
    // Arrange
    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(mock(SelectOnConditionStep.class));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record4<Object, Object, Object, Object>> selectSelectStep2 =
        mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any()))
        .thenThrow(new MappingException("An error occurred"));
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.findGroupedByDefinitionAndOutcome(ApplicationDao.IS_ACTIVE));
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link AssessmentRatingDao#findGroupedByDefinitionAndOutcome(Condition)}.
   *
   * <ul>
   *   <li>Then calls {@link SelectConditionStep#fetch()}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#findGroupedByDefinitionAndOutcome(Condition)}
   */
  @Test
  @DisplayName("Test findGroupedByDefinitionAndOutcome(Condition); then calls fetch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingDao.findGroupedByDefinitionAndOutcome(Condition)"})
  void testFindGroupedByDefinitionAndOutcome_thenCallsFetch() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch()).thenThrow(new MappingException("An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record4<Object, Object, Object, Object>> selectSelectStep2 =
        mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.findGroupedByDefinitionAndOutcome(ApplicationDao.IS_ACTIVE));
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectConditionStep).fetch();
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where("Render Inlined");
  }

  /**
   * Test {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName("Test lock(EntityReference, long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.lock(EntityReference, long, long, String)"})
  void testLock() {
    // Arrange
    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new MappingException("An error occurred"));
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.lock(null, 1L, 1L, "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName("Test lock(EntityReference, long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.lock(EntityReference, long, long, String)"})
  void testLock2() {
    // Arrange
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new MappingException("An error occurred"));

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.lock(null, 1L, 1L, "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName("Test lock(EntityReference, long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.lock(EntityReference, long, long, String)"})
  void testLock3() {
    // Arrange
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new MappingException("An error occurred"));

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.lock(null, 1L, 1L, "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName("Test lock(EntityReference, long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.lock(EntityReference, long, long, String)"})
  void testLock4() {
    // Arrange
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.lock(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L,
                1L,
                "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName("Test lock(EntityReference, long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.lock(EntityReference, long, long, String)"})
  void testLock5() {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.lock(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L,
                1L,
                "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName("Test lock(EntityReference, long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.lock(EntityReference, long, long, String)"})
  void testLock6() {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep2 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.lock(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L,
                1L,
                "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateConditionStep).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName("Test lock(EntityReference, long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.lock(EntityReference, long, long, String)"})
  void testLock7() {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep2 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep3 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep3.and(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep3);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.lock(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L,
                1L,
                "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep3).and(isA(Condition.class));
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateConditionStep).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName("Test lock(EntityReference, long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.lock(EntityReference, long, long, String)"})
  void testLock8() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenThrow(new MappingException("An error occurred"));

    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep2 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep3 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep3.and(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep4 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep4.and(Mockito.<Condition>any())).thenReturn(updateConditionStep3);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep4);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.lock(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L,
                1L,
                "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateConditionStep4).and(isA(Condition.class));
    verify(updateConditionStep3).and(isA(Condition.class));
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#update(Table)} throw {@link
   *       MappingException#MappingException(String)} with message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName(
      "Test lock(EntityReference, long, long, String); given DSLContext update(Table) throw MappingException(String) with message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.lock(EntityReference, long, long, String)"})
  void testLock_givenDSLContextUpdateThrowMappingExceptionWithMessageIsAnErrorOccurred() {
    // Arrange
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenThrow(new MappingException("An error occurred"));

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.lock(null, 1L, 1L, "janedoe"));
    verify(dSLContext).update(isA(Table.class));
  }

  /**
   * Test {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return eight.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName(
      "Test lock(EntityReference, long, long, String); given UpdateConditionStep execute() return eight; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.lock(EntityReference, long, long, String)"})
  void testLock_givenUpdateConditionStepExecuteReturnEight_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(8);

    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep2 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep3 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep3.and(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep4 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep4.and(Mockito.<Condition>any())).thenReturn(updateConditionStep3);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep4);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    boolean actualLockResult =
        assessmentRatingDao.lock(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L,
            1L,
            "janedoe");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateConditionStep4).and(isA(Condition.class));
    verify(updateConditionStep3).and(isA(Condition.class));
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertFalse(actualLockResult);
  }

  /**
   * Test {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#lock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName(
      "Test lock(EntityReference, long, long, String); given UpdateConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.lock(EntityReference, long, long, String)"})
  void testLock_givenUpdateConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep2 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep3 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep3.and(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep4 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep4.and(Mockito.<Condition>any())).thenReturn(updateConditionStep3);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep4);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    boolean actualLockResult =
        assessmentRatingDao.lock(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L,
            1L,
            "janedoe");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateConditionStep4).and(isA(Condition.class));
    verify(updateConditionStep3).and(isA(Condition.class));
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertTrue(actualLockResult);
  }

  /**
   * Test {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName("Test unlock(EntityReference, long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.unlock(EntityReference, long, long, String)"})
  void testUnlock() {
    // Arrange
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenThrow(new MappingException("An error occurred"));

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.unlock(null, 1L, 1L, "janedoe"));
    verify(dSLContext).update(isA(Table.class));
  }

  /**
   * Test {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName("Test unlock(EntityReference, long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.unlock(EntityReference, long, long, String)"})
  void testUnlock2() {
    // Arrange
    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new MappingException("An error occurred"));
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.unlock(null, 1L, 1L, "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName("Test unlock(EntityReference, long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.unlock(EntityReference, long, long, String)"})
  void testUnlock3() {
    // Arrange
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new MappingException("An error occurred"));

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.unlock(null, 1L, 1L, "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName("Test unlock(EntityReference, long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.unlock(EntityReference, long, long, String)"})
  void testUnlock4() {
    // Arrange
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new MappingException("An error occurred"));

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.unlock(null, 1L, 1L, "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName("Test unlock(EntityReference, long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.unlock(EntityReference, long, long, String)"})
  void testUnlock5() {
    // Arrange
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.unlock(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L,
                1L,
                "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName("Test unlock(EntityReference, long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.unlock(EntityReference, long, long, String)"})
  void testUnlock6() {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.unlock(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L,
                1L,
                "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName("Test unlock(EntityReference, long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.unlock(EntityReference, long, long, String)"})
  void testUnlock7() {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep2 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.unlock(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L,
                1L,
                "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateConditionStep).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName("Test unlock(EntityReference, long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.unlock(EntityReference, long, long, String)"})
  void testUnlock8() {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep2 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep3 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep3.and(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep3);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.unlock(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L,
                1L,
                "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep3).and(isA(Condition.class));
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateConditionStep).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName("Test unlock(EntityReference, long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.unlock(EntityReference, long, long, String)"})
  void testUnlock9() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenThrow(new MappingException("An error occurred"));

    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep2 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep3 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep3.and(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep4 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep4.and(Mockito.<Condition>any())).thenReturn(updateConditionStep3);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep4);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.unlock(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L,
                1L,
                "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateConditionStep4).and(isA(Condition.class));
    verify(updateConditionStep3).and(isA(Condition.class));
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return eight.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName(
      "Test unlock(EntityReference, long, long, String); given UpdateConditionStep execute() return eight; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.unlock(EntityReference, long, long, String)"})
  void testUnlock_givenUpdateConditionStepExecuteReturnEight_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(8);

    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep2 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep3 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep3.and(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep4 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep4.and(Mockito.<Condition>any())).thenReturn(updateConditionStep3);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep4);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    boolean actualUnlockResult =
        assessmentRatingDao.unlock(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L,
            1L,
            "janedoe");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateConditionStep4).and(isA(Condition.class));
    verify(updateConditionStep3).and(isA(Condition.class));
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertFalse(actualUnlockResult);
  }

  /**
   * Test {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#unlock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName(
      "Test unlock(EntityReference, long, long, String); given UpdateConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.unlock(EntityReference, long, long, String)"})
  void testUnlock_givenUpdateConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep2 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep3 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep3.and(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep4 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep4.and(Mockito.<Condition>any())).thenReturn(updateConditionStep3);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep4);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    boolean actualUnlockResult =
        assessmentRatingDao.unlock(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L,
            1L,
            "janedoe");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateConditionStep4).and(isA(Condition.class));
    verify(updateConditionStep3).and(isA(Condition.class));
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertTrue(actualUnlockResult);
  }

  /**
   * Test {@link AssessmentRatingDao#calculateAmendedRatingOperations(Set, EntityReference, long,
   * String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#calculateAmendedRatingOperations(Set,
   * EntityReference, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedRatingOperations(Set, EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingDao.calculateAmendedRatingOperations(Set, EntityReference, long, String)"
  })
  void testCalculateAmendedRatingOperations() {
    // Arrange
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenThrow(new MappingException("An error occurred"));

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.calculateAmendedRatingOperations(
                new HashSet<>(), null, 1L, "janedoe"));
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
  }

  /**
   * Test {@link AssessmentRatingDao#calculateAmendedRatingOperations(Set, EntityReference, long,
   * String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#calculateAmendedRatingOperations(Set,
   * EntityReference, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedRatingOperations(Set, EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingDao.calculateAmendedRatingOperations(Set, EntityReference, long, String)"
  })
  void testCalculateAmendedRatingOperations2() {
    // Arrange
    SelectSelectStep<Record5<Object, Object, Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new MappingException("An error occurred"));
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.calculateAmendedRatingOperations(
                new HashSet<>(), null, 1L, "janedoe"));
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link AssessmentRatingDao#calculateAmendedRatingOperations(Set, EntityReference, long,
   * String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#calculateAmendedRatingOperations(Set,
   * EntityReference, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedRatingOperations(Set, EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingDao.calculateAmendedRatingOperations(Set, EntityReference, long, String)"
  })
  void testCalculateAmendedRatingOperations3() {
    // Arrange
    SelectJoinStep<Record5<Object, Object, Object, Object, Object>> selectJoinStep =
        mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectSelectStep<Record5<Object, Object, Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.calculateAmendedRatingOperations(
                new HashSet<>(), null, 1L, "janedoe"));
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
  }

  /**
   * Test {@link AssessmentRatingDao#calculateAmendedRatingOperations(Set, EntityReference, long,
   * String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#calculateAmendedRatingOperations(Set,
   * EntityReference, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedRatingOperations(Set, EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingDao.calculateAmendedRatingOperations(Set, EntityReference, long, String)"
  })
  void testCalculateAmendedRatingOperations4() {
    // Arrange
    SelectJoinPartitionByStep<Record5<Object, Object, Object, Object, Object>>
        selectJoinPartitionByStep = mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectJoinStep<Record5<Object, Object, Object, Object, Object>> selectJoinStep =
        mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record5<Object, Object, Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.calculateAmendedRatingOperations(
                new HashSet<>(), null, 1L, "janedoe"));
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#calculateAmendedRatingOperations(Set, EntityReference, long,
   * String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#calculateAmendedRatingOperations(Set,
   * EntityReference, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedRatingOperations(Set, EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingDao.calculateAmendedRatingOperations(Set, EntityReference, long, String)"
  })
  void testCalculateAmendedRatingOperations5() {
    // Arrange
    SelectOnConditionStep<Record5<Object, Object, Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectJoinPartitionByStep<Record5<Object, Object, Object, Object, Object>>
        selectJoinPartitionByStep = mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record5<Object, Object, Object, Object, Object>> selectJoinStep =
        mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record5<Object, Object, Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    HashSet<Operation> operationsForEntityAssessment = new HashSet<>();

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.calculateAmendedRatingOperations(
                operationsForEntityAssessment,
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L,
                "janedoe"));
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep).and(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#calculateAmendedRatingOperations(Set, EntityReference, long,
   * String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#calculateAmendedRatingOperations(Set,
   * EntityReference, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedRatingOperations(Set, EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingDao.calculateAmendedRatingOperations(Set, EntityReference, long, String)"
  })
  void testCalculateAmendedRatingOperations6() {
    // Arrange
    SelectOnConditionStep<Record5<Object, Object, Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectOnConditionStep<Record5<Object, Object, Object, Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinPartitionByStep<Record5<Object, Object, Object, Object, Object>>
        selectJoinPartitionByStep = mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record5<Object, Object, Object, Object, Object>> selectJoinStep =
        mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record5<Object, Object, Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    HashSet<Operation> operationsForEntityAssessment = new HashSet<>();

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.calculateAmendedRatingOperations(
                operationsForEntityAssessment,
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L,
                "janedoe"));
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).and(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#calculateAmendedRatingOperations(Set, EntityReference, long,
   * String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#calculateAmendedRatingOperations(Set,
   * EntityReference, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedRatingOperations(Set, EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingDao.calculateAmendedRatingOperations(Set, EntityReference, long, String)"
  })
  void testCalculateAmendedRatingOperations7() {
    // Arrange
    SelectJoinPartitionByStep<Record5<Object, Object, Object, Object, Object>>
        selectJoinPartitionByStep = mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectOnConditionStep<Record5<Object, Object, Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnConditionStep<Record5<Object, Object, Object, Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinPartitionByStep<Record5<Object, Object, Object, Object, Object>>
        selectJoinPartitionByStep2 = mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record5<Object, Object, Object, Object, Object>> selectJoinStep =
        mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectSelectStep<Record5<Object, Object, Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    HashSet<Operation> operationsForEntityAssessment = new HashSet<>();

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.calculateAmendedRatingOperations(
                operationsForEntityAssessment,
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L,
                "janedoe"));
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).and(isA(Condition.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#calculateAmendedRatingOperations(Set, EntityReference, long,
   * String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#calculateAmendedRatingOperations(Set,
   * EntityReference, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedRatingOperations(Set, EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingDao.calculateAmendedRatingOperations(Set, EntityReference, long, String)"
  })
  void testCalculateAmendedRatingOperations8() {
    // Arrange
    SelectOnConditionStep<Record5<Object, Object, Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectJoinPartitionByStep<Record5<Object, Object, Object, Object, Object>>
        selectJoinPartitionByStep = mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record5<Object, Object, Object, Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnConditionStep<Record5<Object, Object, Object, Object, Object>> selectOnConditionStep3 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinPartitionByStep<Record5<Object, Object, Object, Object, Object>>
        selectJoinPartitionByStep2 = mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record5<Object, Object, Object, Object, Object>> selectJoinStep =
        mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectSelectStep<Record5<Object, Object, Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    HashSet<Operation> operationsForEntityAssessment = new HashSet<>();

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.calculateAmendedRatingOperations(
                operationsForEntityAssessment,
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L,
                "janedoe"));
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).and(isA(Condition.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#calculateAmendedRatingOperations(Set, EntityReference, long,
   * String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#calculateAmendedRatingOperations(Set,
   * EntityReference, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedRatingOperations(Set, EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingDao.calculateAmendedRatingOperations(Set, EntityReference, long, String)"
  })
  void testCalculateAmendedRatingOperations9() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record5<Object, Object, Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(
            Mockito.<RecordMapper<Record5<Object, Object, Object, Object, Object>, Object>>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectOnConditionStep<Record5<Object, Object, Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record5<Object, Object, Object, Object, Object>>
        selectJoinPartitionByStep = mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record5<Object, Object, Object, Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnConditionStep<Record5<Object, Object, Object, Object, Object>> selectOnConditionStep3 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinPartitionByStep<Record5<Object, Object, Object, Object, Object>>
        selectJoinPartitionByStep2 = mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record5<Object, Object, Object, Object, Object>> selectJoinStep =
        mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectSelectStep<Record5<Object, Object, Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    HashSet<Operation> operationsForEntityAssessment = new HashSet<>();

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.calculateAmendedRatingOperations(
                operationsForEntityAssessment,
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L,
                "janedoe"));
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).and(isA(Condition.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#calculateAmendedRatingOperations(Set, EntityReference, long,
   * String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#calculateAmendedRatingOperations(Set,
   * EntityReference, long, String)}
   */
  @Test
  @DisplayName(
      "Test calculateAmendedRatingOperations(Set, EntityReference, long, String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingDao.calculateAmendedRatingOperations(Set, EntityReference, long, String)"
  })
  void testCalculateAmendedRatingOperations_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record5<Object, Object, Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(
            Mockito.<RecordMapper<Record5<Object, Object, Object, Object, Object>, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectOnConditionStep<Record5<Object, Object, Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record5<Object, Object, Object, Object, Object>>
        selectJoinPartitionByStep = mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record5<Object, Object, Object, Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnConditionStep<Record5<Object, Object, Object, Object, Object>> selectOnConditionStep3 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinPartitionByStep<Record5<Object, Object, Object, Object, Object>>
        selectJoinPartitionByStep2 = mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record5<Object, Object, Object, Object, Object>> selectJoinStep =
        mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectSelectStep<Record5<Object, Object, Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    HashSet<Operation> operationsForEntityAssessment = new HashSet<>();

    // Act
    Set<AssessmentRatingOperations> actualCalculateAmendedRatingOperationsResult =
        assessmentRatingDao.calculateAmendedRatingOperations(
            operationsForEntityAssessment,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L,
            "janedoe");

    // Assert
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).and(isA(Condition.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualCalculateAmendedRatingOperationsResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingDao#updateComment(long, String, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#updateComment(long, String, String)}
   */
  @Test
  @DisplayName("Test updateComment(long, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.updateComment(long, String, String)"})
  void testUpdateComment() {
    // Arrange
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenThrow(new MappingException("An error occurred"));

    // Act and Assert
    assertThrows(
        MappingException.class, () -> assessmentRatingDao.updateComment(1L, "Comment", "janedoe"));
    verify(dSLContext).update(isA(Table.class));
  }

  /**
   * Test {@link AssessmentRatingDao#updateComment(long, String, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#updateComment(long, String, String)}
   */
  @Test
  @DisplayName("Test updateComment(long, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.updateComment(long, String, String)"})
  void testUpdateComment2() {
    // Arrange
    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new MappingException("An error occurred"));
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        MappingException.class, () -> assessmentRatingDao.updateComment(1L, "Comment", "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link AssessmentRatingDao#updateComment(long, String, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#updateComment(long, String, String)}
   */
  @Test
  @DisplayName("Test updateComment(long, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.updateComment(long, String, String)"})
  void testUpdateComment3() {
    // Arrange
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new MappingException("An error occurred"));

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        MappingException.class, () -> assessmentRatingDao.updateComment(1L, "Comment", "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link AssessmentRatingDao#updateComment(long, String, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#updateComment(long, String, String)}
   */
  @Test
  @DisplayName("Test updateComment(long, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.updateComment(long, String, String)"})
  void testUpdateComment4() {
    // Arrange
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new MappingException("An error occurred"));

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        MappingException.class, () -> assessmentRatingDao.updateComment(1L, "Comment", "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link AssessmentRatingDao#updateComment(long, String, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#updateComment(long, String, String)}
   */
  @Test
  @DisplayName("Test updateComment(long, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.updateComment(long, String, String)"})
  void testUpdateComment5() {
    // Arrange
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        MappingException.class, () -> assessmentRatingDao.updateComment(1L, "Comment", "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#updateComment(long, String, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#updateComment(long, String, String)}
   */
  @Test
  @DisplayName("Test updateComment(long, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.updateComment(long, String, String)"})
  void testUpdateComment6() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenThrow(new MappingException("An error occurred"));

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        MappingException.class, () -> assessmentRatingDao.updateComment(1L, "Comment", "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#updateComment(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#updateComment(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateComment(long, String, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.updateComment(long, String, String)"})
  void testUpdateComment_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    boolean actualUpdateCommentResult =
        new AssessmentRatingDao(dsl).updateComment(1L, "Comment", "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"assessment_rating\" set \"assessment_rating\".\"description\" = cast(? as varchar), \"assessment_rating\".\"last_updated_at\" = cast(? as datetime), \"assessment_rating\".\"last_updated_by\" = cast(? as varchar) where \"assessment_rating\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateCommentResult);
  }

  /**
   * Test {@link AssessmentRatingDao#updateComment(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#updateComment(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateComment(long, String, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.updateComment(long, String, String)"})
  void testUpdateComment_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualUpdateCommentResult =
        new AssessmentRatingDao(dsl).updateComment(1L, "Comment", "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"assessment_rating\" set \"assessment_rating\".\"description\" = ?, \"assessment_rating\".\"last_updated_at\" = ?, \"assessment_rating\".\"last_updated_by\" = ? where \"assessment_rating\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateCommentResult);
  }

  /**
   * Test {@link AssessmentRatingDao#updateComment(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#updateComment(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateComment(long, String, String); given UpdateConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.updateComment(long, String, String)"})
  void testUpdateComment_givenUpdateConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    boolean actualUpdateCommentResult = assessmentRatingDao.updateComment(1L, "Comment", "janedoe");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertTrue(actualUpdateCommentResult);
  }

  /**
   * Test {@link AssessmentRatingDao#updateComment(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#updateComment(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateComment(long, String, String); given UpdateConditionStep execute() return zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.updateComment(long, String, String)"})
  void testUpdateComment_givenUpdateConditionStepExecuteReturnZero_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(0);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    boolean actualUpdateCommentResult = assessmentRatingDao.updateComment(1L, "Comment", "janedoe");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertFalse(actualUpdateCommentResult);
  }

  /**
   * Test {@link AssessmentRatingDao#updateRating(long, UpdateRatingCommand, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#updateRating(long, UpdateRatingCommand,
   * String)}
   */
  @Test
  @DisplayName("Test updateRating(long, UpdateRatingCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.updateRating(long, UpdateRatingCommand, String)"})
  void testUpdateRating() {
    // Arrange
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenThrow(new MappingException("An error occurred"));

    // Act and Assert
    assertThrows(
        MappingException.class, () -> assessmentRatingDao.updateRating(1L, null, "janedoe"));
    verify(dSLContext).update(isA(Table.class));
  }

  /**
   * Test {@link AssessmentRatingDao#updateRating(long, UpdateRatingCommand, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#updateRating(long, UpdateRatingCommand,
   * String)}
   */
  @Test
  @DisplayName("Test updateRating(long, UpdateRatingCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.updateRating(long, UpdateRatingCommand, String)"})
  void testUpdateRating2() {
    // Arrange
    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new MappingException("An error occurred"));
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.updateRating(
                1L, ImmutableUpdateRatingCommand.builder().newRatingId(1L).build(), "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link AssessmentRatingDao#updateRating(long, UpdateRatingCommand, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#updateRating(long, UpdateRatingCommand,
   * String)}
   */
  @Test
  @DisplayName("Test updateRating(long, UpdateRatingCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.updateRating(long, UpdateRatingCommand, String)"})
  void testUpdateRating3() {
    // Arrange
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new MappingException("An error occurred"));

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.updateRating(
                1L, ImmutableUpdateRatingCommand.builder().newRatingId(1L).build(), "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link AssessmentRatingDao#updateRating(long, UpdateRatingCommand, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#updateRating(long, UpdateRatingCommand,
   * String)}
   */
  @Test
  @DisplayName("Test updateRating(long, UpdateRatingCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.updateRating(long, UpdateRatingCommand, String)"})
  void testUpdateRating4() {
    // Arrange
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new MappingException("An error occurred"));

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.updateRating(
                1L, ImmutableUpdateRatingCommand.builder().newRatingId(1L).build(), "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link AssessmentRatingDao#updateRating(long, UpdateRatingCommand, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#updateRating(long, UpdateRatingCommand,
   * String)}
   */
  @Test
  @DisplayName("Test updateRating(long, UpdateRatingCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.updateRating(long, UpdateRatingCommand, String)"})
  void testUpdateRating5() {
    // Arrange
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.updateRating(
                1L, ImmutableUpdateRatingCommand.builder().newRatingId(1L).build(), "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#updateRating(long, UpdateRatingCommand, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#updateRating(long, UpdateRatingCommand,
   * String)}
   */
  @Test
  @DisplayName("Test updateRating(long, UpdateRatingCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.updateRating(long, UpdateRatingCommand, String)"})
  void testUpdateRating6() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenThrow(new MappingException("An error occurred"));

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () ->
            assessmentRatingDao.updateRating(
                1L, ImmutableUpdateRatingCommand.builder().newRatingId(1L).build(), "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#updateRating(long, UpdateRatingCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#updateRating(long, UpdateRatingCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test updateRating(long, UpdateRatingCommand, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.updateRating(long, UpdateRatingCommand, String)"})
  void testUpdateRating_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);

    // Act
    boolean actualUpdateRatingResult =
        assessmentRatingDao.updateRating(
            1L, ImmutableUpdateRatingCommand.builder().newRatingId(1L).build(), "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"assessment_rating\" set \"assessment_rating\".\"rating_id\" = cast(? as bigint), \"assessment_rating\".\"last_updated_at\" = cast(? as datetime), \"assessment_rating\".\"last_updated_by\" = cast(? as varchar) where \"assessment_rating\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(3, "janedoe");
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateRatingResult);
  }

  /**
   * Test {@link AssessmentRatingDao#updateRating(long, UpdateRatingCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#updateRating(long, UpdateRatingCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test updateRating(long, UpdateRatingCommand, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.updateRating(long, UpdateRatingCommand, String)"})
  void testUpdateRating_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);

    // Act
    boolean actualUpdateRatingResult =
        assessmentRatingDao.updateRating(
            1L, ImmutableUpdateRatingCommand.builder().newRatingId(1L).build(), "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"assessment_rating\" set \"assessment_rating\".\"rating_id\" = ?, \"assessment_rating\".\"last_updated_at\" = ?, \"assessment_rating\".\"last_updated_by\" = ? where \"assessment_rating\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(3, "janedoe");
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateRatingResult);
  }

  /**
   * Test {@link AssessmentRatingDao#updateRating(long, UpdateRatingCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#updateRating(long, UpdateRatingCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test updateRating(long, UpdateRatingCommand, String); given UpdateConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.updateRating(long, UpdateRatingCommand, String)"})
  void testUpdateRating_givenUpdateConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    boolean actualUpdateRatingResult =
        assessmentRatingDao.updateRating(
            1L, ImmutableUpdateRatingCommand.builder().newRatingId(1L).build(), "janedoe");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertTrue(actualUpdateRatingResult);
  }

  /**
   * Test {@link AssessmentRatingDao#updateRating(long, UpdateRatingCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#updateRating(long, UpdateRatingCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test updateRating(long, UpdateRatingCommand, String); given UpdateConditionStep execute() return zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.updateRating(long, UpdateRatingCommand, String)"})
  void testUpdateRating_givenUpdateConditionStepExecuteReturnZero_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<AssessmentRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(0);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    boolean actualUpdateRatingResult =
        assessmentRatingDao.updateRating(
            1L, ImmutableUpdateRatingCommand.builder().newRatingId(1L).build(), "janedoe");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertFalse(actualUpdateRatingResult);
  }

  /**
   * Test {@link AssessmentRatingDao#hasMultiValuedAssessments(long)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#hasMultiValuedAssessments(long)}
   */
  @Test
  @DisplayName("Test hasMultiValuedAssessments(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.hasMultiValuedAssessments(long)"})
  void testHasMultiValuedAssessments() {
    // Arrange
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenThrow(new MappingException("An error occurred"));

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.hasMultiValuedAssessments(1L));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
  }

  /**
   * Test {@link AssessmentRatingDao#hasMultiValuedAssessments(long)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#hasMultiValuedAssessments(long)}
   */
  @Test
  @DisplayName("Test hasMultiValuedAssessments(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.hasMultiValuedAssessments(long)"})
  void testHasMultiValuedAssessments2() {
    // Arrange
    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new MappingException("An error occurred"));
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.hasMultiValuedAssessments(1L));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link AssessmentRatingDao#hasMultiValuedAssessments(long)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#hasMultiValuedAssessments(long)}
   */
  @Test
  @DisplayName("Test hasMultiValuedAssessments(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.hasMultiValuedAssessments(long)"})
  void testHasMultiValuedAssessments3() {
    // Arrange
    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.hasMultiValuedAssessments(1L));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#hasMultiValuedAssessments(long)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#hasMultiValuedAssessments(long)}
   */
  @Test
  @DisplayName("Test hasMultiValuedAssessments(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.hasMultiValuedAssessments(long)"})
  void testHasMultiValuedAssessments4() {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.hasMultiValuedAssessments(1L));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#hasMultiValuedAssessments(long)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#hasMultiValuedAssessments(long)}
   */
  @Test
  @DisplayName("Test hasMultiValuedAssessments(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.hasMultiValuedAssessments(long)"})
  void testHasMultiValuedAssessments5() {
    // Arrange
    SelectHavingStep<Record2<Object, Object>> selectHavingStep = mock(SelectHavingStep.class);
    when(selectHavingStep.having(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.hasMultiValuedAssessments(1L));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectHavingStep).having(isA(Condition.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#hasMultiValuedAssessments(long)}.
   *
   * <ul>
   *   <li>Then calls {@link SelectHavingConditionStep#fetch()}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#hasMultiValuedAssessments(long)}
   */
  @Test
  @DisplayName("Test hasMultiValuedAssessments(long); then calls fetch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingDao.hasMultiValuedAssessments(long)"})
  void testHasMultiValuedAssessments_thenCallsFetch() throws DataAccessException {
    // Arrange
    SelectHavingConditionStep<Record2<Object, Object>> selectHavingConditionStep =
        mock(SelectHavingConditionStep.class);
    when(selectHavingConditionStep.fetch()).thenThrow(new MappingException("An error occurred"));

    SelectHavingStep<Record2<Object, Object>> selectHavingStep = mock(SelectHavingStep.class);
    when(selectHavingStep.having(Mockito.<Condition>any())).thenReturn(selectHavingConditionStep);

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(MappingException.class, () -> assessmentRatingDao.hasMultiValuedAssessments(1L));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectHavingConditionStep).fetch();
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectHavingStep).having(isA(Condition.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#add(Set)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(SQLDialect)} with dialect is {@code
   *       SQL99}.
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#add(Set)}
   */
  @Test
  @DisplayName(
      "Test add(Set); given DefaultDSLContext(SQLDialect) with dialect is 'SQL99'; when HashSet(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.add(Set)"})
  void testAdd_givenDefaultDSLContextWithDialectIsSql99_whenHashSet_thenReturnZero() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao =
        new AssessmentRatingDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, assessmentRatingDao.add(new HashSet<>()));
  }

  /**
   * Test {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateSingleValuedAssessments(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateSingleValuedAssessments(Set)"})
  void testBulkUpdateSingleValuedAssessments() {
    // Arrange
    when(dSLContext.batch(Mockito.<Collection<Query>>any()))
        .thenThrow(new MappingException("An error occurred"));

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.bulkUpdateSingleValuedAssessments(new HashSet<>()));
    verify(dSLContext).batch(isA(Collection.class));
  }

  /**
   * Test {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateSingleValuedAssessments(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateSingleValuedAssessments(Set)"})
  void testBulkUpdateSingleValuedAssessments2() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    // Act
    int actualBulkUpdateSingleValuedAssessmentsResult =
        assessmentRatingDao.bulkUpdateSingleValuedAssessments(new HashSet<>());

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
    assertEquals(4, actualBulkUpdateSingleValuedAssessmentsResult);
  }

  /**
   * Test {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateSingleValuedAssessments(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateSingleValuedAssessments(Set)"})
  void testBulkUpdateSingleValuedAssessments3() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenThrow(new MappingException("An error occurred"));
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.bulkUpdateSingleValuedAssessments(new HashSet<>()));
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
  }

  /**
   * Test {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateSingleValuedAssessments(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateSingleValuedAssessments(Set)"})
  void testBulkUpdateSingleValuedAssessments4() {
    // Arrange
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenThrow(new MappingException("An error occurred"));

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();

    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatings.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.bulkUpdateSingleValuedAssessments(assessmentRatings));
    verify(dSLContext).update(isA(Table.class));
  }

  /**
   * Test {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateSingleValuedAssessments(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateSingleValuedAssessments(Set)"})
  void testBulkUpdateSingleValuedAssessments5() {
    // Arrange
    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new MappingException("An error occurred"));
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();

    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatings.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.bulkUpdateSingleValuedAssessments(assessmentRatings));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateSingleValuedAssessments(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateSingleValuedAssessments(Set)"})
  void testBulkUpdateSingleValuedAssessments6() {
    // Arrange
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new MappingException("An error occurred"));

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();

    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatings.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.bulkUpdateSingleValuedAssessments(assessmentRatings));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateSingleValuedAssessments(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateSingleValuedAssessments(Set)"})
  void testBulkUpdateSingleValuedAssessments7() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any()))
        .thenReturn(mock(UpdateConditionStep.class));

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();

    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatings.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    // Act
    int actualBulkUpdateSingleValuedAssessmentsResult =
        assessmentRatingDao.bulkUpdateSingleValuedAssessments(assessmentRatings);

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(4, actualBulkUpdateSingleValuedAssessmentsResult);
  }

  /**
   * Test {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateSingleValuedAssessments(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateSingleValuedAssessments(Set)"})
  void testBulkUpdateSingleValuedAssessments8() {
    // Arrange
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();

    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatings.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.bulkUpdateSingleValuedAssessments(assessmentRatings));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateSingleValuedAssessments(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateSingleValuedAssessments(Set)"})
  void testBulkUpdateSingleValuedAssessments9() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any()))
        .thenReturn(mock(UpdateConditionStep.class));

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();

    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatings.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(2L).comment("Comment");
    assessmentRatings.add(
        commentResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    // Act
    int actualBulkUpdateSingleValuedAssessmentsResult =
        assessmentRatingDao.bulkUpdateSingleValuedAssessments(assessmentRatings);

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
    verify(dSLContext, atLeast(1)).update(isA(Table.class));
    verify(updateSetFirstStep, atLeast(1)).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2, atLeast(1)).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep, atLeast(1)).where(Mockito.<Condition>any());
    assertEquals(4, actualBulkUpdateSingleValuedAssessmentsResult);
  }

  /**
   * Test {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}.
   *
   * <ul>
   *   <li>Then calls {@link Statement#addBatch(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateSingleValuedAssessments(Set); then calls addBatch(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateSingleValuedAssessments(Set)"})
  void testBulkUpdateSingleValuedAssessments_thenCallsAddBatch() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    doNothing().when(statement).addBatch(Mockito.<String>any());
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();

    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatings.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    // Act
    int actualBulkUpdateSingleValuedAssessmentsResult =
        assessmentRatingDao.bulkUpdateSingleValuedAssessments(assessmentRatings);

    // Assert
    verify(connection).createStatement();
    verify(statement)
        .addBatch(
            "update \"assessment_rating\" set \"assessment_rating\".\"rating_id\" = 1, \"assessment_rating\".\"description\" = 'Comment' where (\"assessment_rating\".\"assessment_definition_id\" = 1 and \"assessment_rating\".\"entity_kind\" = 'ALL' and \"assessment_rating\".\"entity_id\" = 1)");
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertEquals(4, actualBulkUpdateSingleValuedAssessmentsResult);
  }

  /**
   * Test {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#createStatement()}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkUpdateSingleValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateSingleValuedAssessments(Set); then calls createStatement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateSingleValuedAssessments(Set)"})
  void testBulkUpdateSingleValuedAssessments_thenCallsCreateStatement() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);

    // Act
    int actualBulkUpdateSingleValuedAssessmentsResult =
        assessmentRatingDao.bulkUpdateSingleValuedAssessments(new HashSet<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertEquals(4, actualBulkUpdateSingleValuedAssessmentsResult);
  }

  /**
   * Test {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateMultiValuedAssessments(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateMultiValuedAssessments(Set)"})
  void testBulkUpdateMultiValuedAssessments() {
    // Arrange
    when(dSLContext.batch(Mockito.<Collection<Query>>any()))
        .thenThrow(new MappingException("An error occurred"));

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.bulkUpdateMultiValuedAssessments(new HashSet<>()));
    verify(dSLContext).batch(isA(Collection.class));
  }

  /**
   * Test {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateMultiValuedAssessments(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateMultiValuedAssessments(Set)"})
  void testBulkUpdateMultiValuedAssessments2() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    // Act
    int actualBulkUpdateMultiValuedAssessmentsResult =
        assessmentRatingDao.bulkUpdateMultiValuedAssessments(new HashSet<>());

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
    assertEquals(4, actualBulkUpdateMultiValuedAssessmentsResult);
  }

  /**
   * Test {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateMultiValuedAssessments(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateMultiValuedAssessments(Set)"})
  void testBulkUpdateMultiValuedAssessments3() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenThrow(new MappingException("An error occurred"));
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.bulkUpdateMultiValuedAssessments(new HashSet<>()));
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
  }

  /**
   * Test {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateMultiValuedAssessments(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateMultiValuedAssessments(Set)"})
  void testBulkUpdateMultiValuedAssessments4() {
    // Arrange
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenThrow(new MappingException("An error occurred"));

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();

    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatings.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.bulkUpdateMultiValuedAssessments(assessmentRatings));
    verify(dSLContext).update(isA(Table.class));
  }

  /**
   * Test {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateMultiValuedAssessments(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateMultiValuedAssessments(Set)"})
  void testBulkUpdateMultiValuedAssessments5() {
    // Arrange
    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new MappingException("An error occurred"));
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();

    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatings.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.bulkUpdateMultiValuedAssessments(assessmentRatings));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateMultiValuedAssessments(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateMultiValuedAssessments(Set)"})
  void testBulkUpdateMultiValuedAssessments6() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any()))
        .thenReturn(mock(UpdateConditionStep.class));

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();

    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatings.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    // Act
    int actualBulkUpdateMultiValuedAssessmentsResult =
        assessmentRatingDao.bulkUpdateMultiValuedAssessments(assessmentRatings);

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(4, actualBulkUpdateMultiValuedAssessmentsResult);
  }

  /**
   * Test {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateMultiValuedAssessments(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateMultiValuedAssessments(Set)"})
  void testBulkUpdateMultiValuedAssessments7() {
    // Arrange
    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any()))
        .thenThrow(new MappingException("An error occurred"));

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();

    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatings.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    // Act and Assert
    assertThrows(
        MappingException.class,
        () -> assessmentRatingDao.bulkUpdateMultiValuedAssessments(assessmentRatings));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}.
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateMultiValuedAssessments(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateMultiValuedAssessments(Set)"})
  void testBulkUpdateMultiValuedAssessments8() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    UpdateSetMoreStep<AssessmentRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any()))
        .thenReturn(mock(UpdateConditionStep.class));

    UpdateSetFirstStep<AssessmentRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();

    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatings.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(2L).comment("Comment");
    assessmentRatings.add(
        commentResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    // Act
    int actualBulkUpdateMultiValuedAssessmentsResult =
        assessmentRatingDao.bulkUpdateMultiValuedAssessments(assessmentRatings);

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
    verify(dSLContext, atLeast(1)).update(isA(Table.class));
    verify(updateSetFirstStep, atLeast(1)).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep, atLeast(1)).where(Mockito.<Condition>any());
    assertEquals(4, actualBulkUpdateMultiValuedAssessmentsResult);
  }

  /**
   * Test {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}.
   *
   * <ul>
   *   <li>Then calls {@link Statement#addBatch(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateMultiValuedAssessments(Set); then calls addBatch(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateMultiValuedAssessments(Set)"})
  void testBulkUpdateMultiValuedAssessments_thenCallsAddBatch() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    doNothing().when(statement).addBatch(Mockito.<String>any());
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);

    HashSet<AssessmentRating> assessmentRatings = new HashSet<>();

    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatings.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    // Act
    int actualBulkUpdateMultiValuedAssessmentsResult =
        assessmentRatingDao.bulkUpdateMultiValuedAssessments(assessmentRatings);

    // Assert
    verify(connection).createStatement();
    verify(statement)
        .addBatch(
            "update \"assessment_rating\" set \"assessment_rating\".\"description\" = 'Comment' where (\"assessment_rating\".\"assessment_definition_id\" = 1 and \"assessment_rating\".\"entity_kind\" = 'ALL' and \"assessment_rating\".\"entity_id\" = 1 and \"assessment_rating\".\"rating_id\" = 1)");
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertEquals(4, actualBulkUpdateMultiValuedAssessmentsResult);
  }

  /**
   * Test {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#createStatement()}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingDao#bulkUpdateMultiValuedAssessments(Set)}
   */
  @Test
  @DisplayName("Test bulkUpdateMultiValuedAssessments(Set); then calls createStatement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AssessmentRatingDao.bulkUpdateMultiValuedAssessments(Set)"})
  void testBulkUpdateMultiValuedAssessments_thenCallsCreateStatement() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AssessmentRatingDao assessmentRatingDao = new AssessmentRatingDao(dsl);

    // Act
    int actualBulkUpdateMultiValuedAssessmentsResult =
        assessmentRatingDao.bulkUpdateMultiValuedAssessments(new HashSet<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertEquals(4, actualBulkUpdateMultiValuedAssessmentsResult);
  }
}
