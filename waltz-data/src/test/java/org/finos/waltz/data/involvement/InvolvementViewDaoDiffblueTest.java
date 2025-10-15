package org.finos.waltz.data.involvement;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyDirection;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.involvement.InvolvementDetail;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectOrderByStep;
import org.jooq.SelectSelectStep;
import org.jooq.TableLike;
import org.jooq.exception.MappingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class InvolvementViewDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private InvolvementViewDao involvementViewDao;

  /**
   * Test {@link InvolvementViewDao#findAllInvolvements(EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementViewDao#findAllInvolvements(EntityReference)}
   */
  @Test
  @DisplayName("Test findAllInvolvements(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InvolvementViewDao.findAllInvolvements(EntityReference)"})
  void testFindAllInvolvements() throws MappingException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchGroups(
            Mockito.<RecordMapper<Record, Object>>any(),
            Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Map<HierarchyDirection, ? extends Collection<InvolvementDetail>>
        actualFindAllInvolvementsResult =
            involvementViewDao.findAllInvolvements(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build());

    // Assert
    verify(dSLContext).select(isA(Collection.class));
    verify(selectConditionStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep3).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindAllInvolvementsResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewDao#findAllInvolvements(EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementViewDao#findAllInvolvements(EntityReference)}
   */
  @Test
  @DisplayName("Test findAllInvolvements(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InvolvementViewDao.findAllInvolvements(EntityReference)"})
  void testFindAllInvolvements2() throws MappingException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchGroups(
            Mockito.<RecordMapper<Record, Object>>any(),
            Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Map<HierarchyDirection, ? extends Collection<InvolvementDetail>>
        actualFindAllInvolvementsResult =
            involvementViewDao.findAllInvolvements(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALLOCATION_SCHEME)
                    .name("Name")
                    .build());

    // Assert
    verify(dSLContext).select(isA(Collection.class));
    verify(selectConditionStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep3).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindAllInvolvementsResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewDao#findAllInvolvements(EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementViewDao#findAllInvolvements(EntityReference)}
   */
  @Test
  @DisplayName("Test findAllInvolvements(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InvolvementViewDao.findAllInvolvements(EntityReference)"})
  void testFindAllInvolvements3() throws MappingException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchGroups(
            Mockito.<RecordMapper<Record, Object>>any(),
            Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Map<HierarchyDirection, ? extends Collection<InvolvementDetail>>
        actualFindAllInvolvementsResult =
            involvementViewDao.findAllInvolvements(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APPLICATION)
                    .name("Name")
                    .build());

    // Assert
    verify(dSLContext).select(isA(Collection.class));
    verify(selectConditionStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep3).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindAllInvolvementsResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewDao#findAllInvolvements(EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementViewDao#findAllInvolvements(EntityReference)}
   */
  @Test
  @DisplayName("Test findAllInvolvements(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InvolvementViewDao.findAllInvolvements(EntityReference)"})
  void testFindAllInvolvements4() throws MappingException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchGroups(
            Mockito.<RecordMapper<Record, Object>>any(),
            Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Map<HierarchyDirection, ? extends Collection<InvolvementDetail>>
        actualFindAllInvolvementsResult =
            involvementViewDao.findAllInvolvements(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APP_GROUP)
                    .name("Name")
                    .build());

    // Assert
    verify(dSLContext).select(isA(Collection.class));
    verify(selectConditionStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep3).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindAllInvolvementsResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewDao#findAllInvolvements(EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementViewDao#findAllInvolvements(EntityReference)}
   */
  @Test
  @DisplayName("Test findAllInvolvements(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InvolvementViewDao.findAllInvolvements(EntityReference)"})
  void testFindAllInvolvements5() throws MappingException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchGroups(
            Mockito.<RecordMapper<Record, Object>>any(),
            Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Map<HierarchyDirection, ? extends Collection<InvolvementDetail>>
        actualFindAllInvolvementsResult =
            involvementViewDao.findAllInvolvements(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ASSESSMENT_DEFINITION)
                    .name("Name")
                    .build());

    // Assert
    verify(dSLContext).select(isA(Collection.class));
    verify(selectConditionStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep3).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindAllInvolvementsResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewDao#findAllInvolvements(EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementViewDao#findAllInvolvements(EntityReference)}
   */
  @Test
  @DisplayName("Test findAllInvolvements(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InvolvementViewDao.findAllInvolvements(EntityReference)"})
  void testFindAllInvolvements6() throws MappingException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchGroups(
            Mockito.<RecordMapper<Record, Object>>any(),
            Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Map<HierarchyDirection, ? extends Collection<InvolvementDetail>>
        actualFindAllInvolvementsResult =
            involvementViewDao.findAllInvolvements(
                ImmutableAppGroupEntry.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .provenance("Provenance")
                    .build());

    // Assert
    verify(dSLContext).select(isA(Collection.class));
    verify(selectConditionStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep3).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindAllInvolvementsResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewDao#mkInvolvementApiQuery(DSLContext, EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementViewDao#mkInvolvementApiQuery(DSLContext,
   * EntityReference)}
   */
  @Test
  @DisplayName("Test mkInvolvementApiQuery(DSLContext, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Select InvolvementViewDao.mkInvolvementApiQuery(DSLContext, EntityReference)"
  })
  void testMkInvolvementApiQuery() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .build();

    // Act
    InvolvementViewDao.mkInvolvementApiQuery(dSLContext, ref);

    // Assert
    verify(dSLContext).select(isA(Collection.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep3).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementViewDao#mkInvolvementApiQuery(DSLContext, EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementViewDao#mkInvolvementApiQuery(DSLContext,
   * EntityReference)}
   */
  @Test
  @DisplayName("Test mkInvolvementApiQuery(DSLContext, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Select InvolvementViewDao.mkInvolvementApiQuery(DSLContext, EntityReference)"
  })
  void testMkInvolvementApiQuery2() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALLOCATION_SCHEME)
            .name("Name")
            .build();

    // Act
    InvolvementViewDao.mkInvolvementApiQuery(dSLContext, ref);

    // Assert
    verify(dSLContext).select(isA(Collection.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep3).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementViewDao#mkInvolvementApiQuery(DSLContext, EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementViewDao#mkInvolvementApiQuery(DSLContext,
   * EntityReference)}
   */
  @Test
  @DisplayName("Test mkInvolvementApiQuery(DSLContext, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Select InvolvementViewDao.mkInvolvementApiQuery(DSLContext, EntityReference)"
  })
  void testMkInvolvementApiQuery3() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.APPLICATION)
            .name("Name")
            .build();

    // Act
    InvolvementViewDao.mkInvolvementApiQuery(dSLContext, ref);

    // Assert
    verify(dSLContext).select(isA(Collection.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep3).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementViewDao#mkInvolvementApiQuery(DSLContext, EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementViewDao#mkInvolvementApiQuery(DSLContext,
   * EntityReference)}
   */
  @Test
  @DisplayName("Test mkInvolvementApiQuery(DSLContext, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Select InvolvementViewDao.mkInvolvementApiQuery(DSLContext, EntityReference)"
  })
  void testMkInvolvementApiQuery4() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.APP_GROUP)
            .name("Name")
            .build();

    // Act
    InvolvementViewDao.mkInvolvementApiQuery(dSLContext, ref);

    // Assert
    verify(dSLContext).select(isA(Collection.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep3).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementViewDao#mkInvolvementApiQuery(DSLContext, EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementViewDao#mkInvolvementApiQuery(DSLContext,
   * EntityReference)}
   */
  @Test
  @DisplayName("Test mkInvolvementApiQuery(DSLContext, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Select InvolvementViewDao.mkInvolvementApiQuery(DSLContext, EntityReference)"
  })
  void testMkInvolvementApiQuery5() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ASSESSMENT_DEFINITION)
            .name("Name")
            .build();

    // Act
    InvolvementViewDao.mkInvolvementApiQuery(dSLContext, ref);

    // Assert
    verify(dSLContext).select(isA(Collection.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep3).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementViewDao#mkInvolvementApiQuery(DSLContext, EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementViewDao#mkInvolvementApiQuery(DSLContext,
   * EntityReference)}
   */
  @Test
  @DisplayName("Test mkInvolvementApiQuery(DSLContext, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Select InvolvementViewDao.mkInvolvementApiQuery(DSLContext, EntityReference)"
  })
  void testMkInvolvementApiQuery6() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep);
    ImmutableAppGroupEntry ref =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    InvolvementViewDao.mkInvolvementApiQuery(dSLContext, ref);

    // Assert
    verify(dSLContext).select(isA(Collection.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep3).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementViewDao#mkInvolvementApiQuery(DSLContext, EntityReference)}.
   *
   * <ul>
   *   <li>Then calls {@link SelectConditionStep#union(Select)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementViewDao#mkInvolvementApiQuery(DSLContext,
   * EntityReference)}
   */
  @Test
  @DisplayName("Test mkInvolvementApiQuery(DSLContext, EntityReference); then calls union(Select)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Select InvolvementViewDao.mkInvolvementApiQuery(DSLContext, EntityReference)"
  })
  void testMkInvolvementApiQuery_thenCallsUnion() {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.union(Mockito.<Select<Record>>any()))
        .thenReturn(mock(SelectOrderByStep.class));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectOnConditionStep<Record> selectOnConditionStep4 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep4.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectOnStep<Record> selectOnStep4 = mock(SelectOnStep.class);
    when(selectOnStep4.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep4);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep4);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.CHANGE_INITIATIVE)
            .name("Name")
            .build();

    // Act
    InvolvementViewDao.mkInvolvementApiQuery(dSLContext, ref);

    // Assert
    verify(dSLContext, atLeast(1)).select(isA(Collection.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectJoinStep, atLeast(1)).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep4, atLeast(1)).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3, atLeast(1)).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2, atLeast(1)).innerJoin(isA(TableLike.class));
    verify(selectOnStep4, atLeast(1)).on(Mockito.<Condition>any());
    verify(selectOnStep3, atLeast(1)).on(isA(Condition.class));
    verify(selectOnStep2, atLeast(1)).on(isA(Condition.class));
    verify(selectOnStep, atLeast(1)).on(isA(Condition.class));
    verify(selectConditionStep).union(isA(Select.class));
    verify(selectOnConditionStep, atLeast(1)).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementViewDao#mkInvolvementExtractorQuery(DSLContext, EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementViewDao#mkInvolvementExtractorQuery(DSLContext,
   * EntityReference)}
   */
  @Test
  @DisplayName("Test mkInvolvementExtractorQuery(DSLContext, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Select InvolvementViewDao.mkInvolvementExtractorQuery(DSLContext, EntityReference)"
  })
  void testMkInvolvementExtractorQuery() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .build();

    // Act
    InvolvementViewDao.mkInvolvementExtractorQuery(dSLContext, ref);

    // Assert
    verify(dSLContext).select(isA(Collection.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep3).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementViewDao#mkInvolvementExtractorQuery(DSLContext, EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementViewDao#mkInvolvementExtractorQuery(DSLContext,
   * EntityReference)}
   */
  @Test
  @DisplayName("Test mkInvolvementExtractorQuery(DSLContext, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Select InvolvementViewDao.mkInvolvementExtractorQuery(DSLContext, EntityReference)"
  })
  void testMkInvolvementExtractorQuery2() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALLOCATION_SCHEME)
            .name("Name")
            .build();

    // Act
    InvolvementViewDao.mkInvolvementExtractorQuery(dSLContext, ref);

    // Assert
    verify(dSLContext).select(isA(Collection.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep3).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementViewDao#mkInvolvementExtractorQuery(DSLContext, EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementViewDao#mkInvolvementExtractorQuery(DSLContext,
   * EntityReference)}
   */
  @Test
  @DisplayName("Test mkInvolvementExtractorQuery(DSLContext, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Select InvolvementViewDao.mkInvolvementExtractorQuery(DSLContext, EntityReference)"
  })
  void testMkInvolvementExtractorQuery3() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.APPLICATION)
            .name("Name")
            .build();

    // Act
    InvolvementViewDao.mkInvolvementExtractorQuery(dSLContext, ref);

    // Assert
    verify(dSLContext).select(isA(Collection.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep3).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementViewDao#mkInvolvementExtractorQuery(DSLContext, EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementViewDao#mkInvolvementExtractorQuery(DSLContext,
   * EntityReference)}
   */
  @Test
  @DisplayName("Test mkInvolvementExtractorQuery(DSLContext, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Select InvolvementViewDao.mkInvolvementExtractorQuery(DSLContext, EntityReference)"
  })
  void testMkInvolvementExtractorQuery4() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.APP_GROUP)
            .name("Name")
            .build();

    // Act
    InvolvementViewDao.mkInvolvementExtractorQuery(dSLContext, ref);

    // Assert
    verify(dSLContext).select(isA(Collection.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep3).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementViewDao#mkInvolvementExtractorQuery(DSLContext, EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementViewDao#mkInvolvementExtractorQuery(DSLContext,
   * EntityReference)}
   */
  @Test
  @DisplayName("Test mkInvolvementExtractorQuery(DSLContext, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Select InvolvementViewDao.mkInvolvementExtractorQuery(DSLContext, EntityReference)"
  })
  void testMkInvolvementExtractorQuery5() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ASSESSMENT_DEFINITION)
            .name("Name")
            .build();

    // Act
    InvolvementViewDao.mkInvolvementExtractorQuery(dSLContext, ref);

    // Assert
    verify(dSLContext).select(isA(Collection.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep3).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementViewDao#mkInvolvementExtractorQuery(DSLContext, EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementViewDao#mkInvolvementExtractorQuery(DSLContext,
   * EntityReference)}
   */
  @Test
  @DisplayName("Test mkInvolvementExtractorQuery(DSLContext, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Select InvolvementViewDao.mkInvolvementExtractorQuery(DSLContext, EntityReference)"
  })
  void testMkInvolvementExtractorQuery6() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep);
    ImmutableAppGroupEntry ref =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    InvolvementViewDao.mkInvolvementExtractorQuery(dSLContext, ref);

    // Assert
    verify(dSLContext).select(isA(Collection.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep3).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementViewDao#mkInvolvementExtractorQuery(DSLContext, EntityReference)}.
   *
   * <ul>
   *   <li>Then calls {@link SelectConditionStep#union(Select)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementViewDao#mkInvolvementExtractorQuery(DSLContext,
   * EntityReference)}
   */
  @Test
  @DisplayName(
      "Test mkInvolvementExtractorQuery(DSLContext, EntityReference); then calls union(Select)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Select InvolvementViewDao.mkInvolvementExtractorQuery(DSLContext, EntityReference)"
  })
  void testMkInvolvementExtractorQuery_thenCallsUnion() {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.union(Mockito.<Select<Record>>any()))
        .thenReturn(mock(SelectOrderByStep.class));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectOnConditionStep<Record> selectOnConditionStep4 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep4.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectOnStep<Record> selectOnStep4 = mock(SelectOnStep.class);
    when(selectOnStep4.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep4);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep4);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.CHANGE_INITIATIVE)
            .name("Name")
            .build();

    // Act
    InvolvementViewDao.mkInvolvementExtractorQuery(dSLContext, ref);

    // Assert
    verify(dSLContext, atLeast(1)).select(isA(Collection.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectJoinStep, atLeast(1)).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep4, atLeast(1)).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3, atLeast(1)).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2, atLeast(1)).innerJoin(isA(TableLike.class));
    verify(selectOnStep4, atLeast(1)).on(Mockito.<Condition>any());
    verify(selectOnStep3, atLeast(1)).on(isA(Condition.class));
    verify(selectOnStep2, atLeast(1)).on(isA(Condition.class));
    verify(selectOnStep, atLeast(1)).on(isA(Condition.class));
    verify(selectConditionStep).union(isA(Select.class));
    verify(selectOnConditionStep, atLeast(1)).where(isA(Condition.class));
  }
}
