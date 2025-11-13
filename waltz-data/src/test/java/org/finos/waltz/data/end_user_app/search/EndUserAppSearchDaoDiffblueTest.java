package org.finos.waltz.data.end_user_app.search;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.enduserapp.EndUserApplication;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions.Builder;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.OrderField;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectLimitPercentStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectSeekStep1;
import org.jooq.SelectSelectStep;
import org.jooq.TableLike;
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
class EndUserAppSearchDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private EndUserAppSearchDao endUserAppSearchDao;

  /**
   * Test {@link EndUserAppSearchDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link EndUserAppSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EndUserAppSearchDao.search(EntitySearchOptions)"})
  void testSearch() throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectLimitPercentStep<Record> selectLimitPercentStep2 = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep2.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep12 = mock(SelectSeekStep1.class);
    when(selectSeekStep12.limit(anyInt())).thenReturn(selectLimitPercentStep2);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep12);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    EndUserAppSearchDao endUserAppSearchDao = new EndUserAppSearchDao(dsl);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<EndUserApplication> actualSearchResult =
        endUserAppSearchDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    verify(dsl, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep2).fetch(isA(RecordMapper.class));
    verify(selectLimitPercentStep, atLeast(1)).fetch(isA(RecordMapper.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectJoinStep2).innerJoin(isA(TableLike.class));
    verify(selectSeekStep12).limit(40);
    verify(selectSeekStep1, atLeast(1)).limit(40);
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectConditionStep2).orderBy(isA(OrderField.class));
    verify(selectConditionStep, atLeast(1)).orderBy(isA(OrderField.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link EndUserAppSearchDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link EndUserAppSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EndUserAppSearchDao.search(EntitySearchOptions)"})
  void testSearch2() {
    // Arrange
    EndUserAppSearchDao endUserAppSearchDao = new EndUserAppSearchDao(mock(DSLContext.class));

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertTrue(
        endUserAppSearchDao
            .search(
                builderResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .searchQuery("[")
                    .userId("42")
                    .build())
            .isEmpty());
  }

  /**
   * Test {@link EndUserAppSearchDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link EndUserAppSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EndUserAppSearchDao.search(EntitySearchOptions)"})
  void testSearch3() throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectLimitPercentStep<Record> selectLimitPercentStep2 = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep2.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep12 = mock(SelectSeekStep1.class);
    when(selectSeekStep12.limit(anyInt())).thenReturn(selectLimitPercentStep2);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep12);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    EndUserAppSearchDao endUserAppSearchDao = new EndUserAppSearchDao(dsl);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<EndUserApplication> actualSearchResult =
        endUserAppSearchDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search")
                .userId("42")
                .build());

    // Assert
    verify(dsl, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep2).fetch(isA(RecordMapper.class));
    verify(selectLimitPercentStep, atLeast(1)).fetch(isA(RecordMapper.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectJoinStep2).innerJoin(isA(TableLike.class));
    verify(selectSeekStep12).limit(40);
    verify(selectSeekStep1, atLeast(1)).limit(40);
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectConditionStep2).orderBy(isA(OrderField.class));
    verify(selectConditionStep, atLeast(1)).orderBy(isA(OrderField.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link EndUserAppSearchDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   *   <li>When builder addEntityLifecycleStatuses {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link EndUserAppSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given 'ACTIVE'; when builder addEntityLifecycleStatuses 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EndUserAppSearchDao.search(EntitySearchOptions)"})
  void testSearch_givenActive_whenBuilderAddEntityLifecycleStatusesActive()
      throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectLimitPercentStep<Record> selectLimitPercentStep2 = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep2.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep12 = mock(SelectSeekStep1.class);
    when(selectSeekStep12.limit(anyInt())).thenReturn(selectLimitPercentStep2);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep12);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    EndUserAppSearchDao endUserAppSearchDao = new EndUserAppSearchDao(dsl);

    Builder builderResult = ImmutableEntitySearchOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    // Act
    List<EndUserApplication> actualSearchResult =
        endUserAppSearchDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    verify(dsl, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep2).fetch(isA(RecordMapper.class));
    verify(selectLimitPercentStep, atLeast(1)).fetch(isA(RecordMapper.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectJoinStep2).innerJoin(isA(TableLike.class));
    verify(selectSeekStep12).limit(40);
    verify(selectSeekStep1, atLeast(1)).limit(40);
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectConditionStep2).orderBy(isA(OrderField.class));
    verify(selectConditionStep, atLeast(1)).orderBy(isA(OrderField.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link EndUserAppSearchDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link EntitySearchOptions#entityLifecycleStatuses()}.
   * </ul>
   *
   * <p>Method under test: {@link EndUserAppSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions); given one; then calls entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EndUserAppSearchDao.search(EntitySearchOptions)"})
  void testSearch_givenOne_thenCallsEntityLifecycleStatuses() throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectLimitPercentStep<Record> selectLimitPercentStep2 = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep2.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep12 = mock(SelectSeekStep1.class);
    when(selectSeekStep12.limit(anyInt())).thenReturn(selectLimitPercentStep2);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep12);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);
    when(dSLContext.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.entityLifecycleStatuses()).thenReturn(new ArrayList<>());
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<EndUserApplication> actualSearchResult = endUserAppSearchDao.search(options);

    // Assert
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).limit();
    verify(options).searchQuery();
    verify(dSLContext, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dSLContext).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep2).fetch(isA(RecordMapper.class));
    verify(selectLimitPercentStep, atLeast(1)).fetch(isA(RecordMapper.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectJoinStep2).innerJoin(isA(TableLike.class));
    verify(selectSeekStep12).limit(1);
    verify(selectSeekStep1, atLeast(1)).limit(1);
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectConditionStep2).orderBy(isA(OrderField.class));
    verify(selectConditionStep, atLeast(1)).orderBy(isA(OrderField.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link EndUserAppSearchDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   *   <li>When builder addEntityLifecycleStatuses {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link EndUserAppSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given 'PENDING'; when builder addEntityLifecycleStatuses 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EndUserAppSearchDao.search(EntitySearchOptions)"})
  void testSearch_givenPending_whenBuilderAddEntityLifecycleStatusesPending()
      throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectLimitPercentStep<Record> selectLimitPercentStep2 = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep2.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep12 = mock(SelectSeekStep1.class);
    when(selectSeekStep12.limit(anyInt())).thenReturn(selectLimitPercentStep2);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep12);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    EndUserAppSearchDao endUserAppSearchDao = new EndUserAppSearchDao(dsl);

    Builder builderResult = ImmutableEntitySearchOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.PENDING);
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    // Act
    List<EndUserApplication> actualSearchResult =
        endUserAppSearchDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    verify(dsl, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep2).fetch(isA(RecordMapper.class));
    verify(selectLimitPercentStep, atLeast(1)).fetch(isA(RecordMapper.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectJoinStep2).innerJoin(isA(TableLike.class));
    verify(selectSeekStep12).limit(40);
    verify(selectSeekStep1, atLeast(1)).limit(40);
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectConditionStep2).orderBy(isA(OrderField.class));
    verify(selectConditionStep, atLeast(1)).orderBy(isA(OrderField.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link EndUserAppSearchDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given {@code REMOVED}.
   *   <li>When builder addEntityLifecycleStatuses {@code REMOVED}.
   * </ul>
   *
   * <p>Method under test: {@link EndUserAppSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given 'REMOVED'; when builder addEntityLifecycleStatuses 'REMOVED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EndUserAppSearchDao.search(EntitySearchOptions)"})
  void testSearch_givenRemoved_whenBuilderAddEntityLifecycleStatusesRemoved()
      throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectLimitPercentStep<Record> selectLimitPercentStep2 = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep2.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep12 = mock(SelectSeekStep1.class);
    when(selectSeekStep12.limit(anyInt())).thenReturn(selectLimitPercentStep2);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep12);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    EndUserAppSearchDao endUserAppSearchDao = new EndUserAppSearchDao(dsl);

    Builder builderResult = ImmutableEntitySearchOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.REMOVED);
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.PENDING);
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    // Act
    List<EndUserApplication> actualSearchResult =
        endUserAppSearchDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    verify(dsl, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep2).fetch(isA(RecordMapper.class));
    verify(selectLimitPercentStep, atLeast(1)).fetch(isA(RecordMapper.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectJoinStep2).innerJoin(isA(TableLike.class));
    verify(selectSeekStep12).limit(40);
    verify(selectSeekStep1, atLeast(1)).limit(40);
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectConditionStep2).orderBy(isA(OrderField.class));
    verify(selectConditionStep, atLeast(1)).orderBy(isA(OrderField.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualSearchResult.isEmpty());
  }
}
