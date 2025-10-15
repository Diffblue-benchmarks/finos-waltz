package org.finos.waltz.data.physical_specification.search;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions.Builder;
import org.finos.waltz.model.physical_specification.PhysicalSpecification;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.OrderField;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinPartitionByStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectLimitPercentStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectQuery;
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
class PhysicalSpecificationSearchDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private PhysicalSpecificationSearchDao physicalSpecificationSearchDao;

  /**
   * Test {@link PhysicalSpecificationSearchDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link PhysicalSpecificationSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalSpecificationSearchDao.search(EntitySearchOptions)"})
  void testSearch() throws DataAccessException {
    // Arrange
    SelectQuery<Record> selectQuery = mock(SelectQuery.class);
    when(selectQuery.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.getQuery()).thenReturn(selectQuery);

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftOuterJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftOuterJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<PhysicalSpecification> actualSearchResult =
        physicalSpecificationSearchDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    verify(dSLContext).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectQuery).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectLimitPercentStep).getQuery();
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftOuterJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftOuterJoin(isA(TableLike.class));
    verify(selectSeekStep1).limit(40);
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link PhysicalSpecificationSearchDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link PhysicalSpecificationSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalSpecificationSearchDao.search(EntitySearchOptions)"})
  void testSearch2() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertTrue(
        physicalSpecificationSearchDao
            .search(
                builderResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .searchQuery("[")
                    .userId("42")
                    .build())
            .isEmpty());
  }

  /**
   * Test {@link PhysicalSpecificationSearchDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link PhysicalSpecificationSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalSpecificationSearchDao.search(EntitySearchOptions)"})
  void testSearch3() throws DataAccessException {
    // Arrange
    SelectQuery<Record> selectQuery = mock(SelectQuery.class);
    when(selectQuery.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.getQuery()).thenReturn(selectQuery);

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftOuterJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftOuterJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<PhysicalSpecification> actualSearchResult =
        physicalSpecificationSearchDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search")
                .userId("42")
                .build());

    // Assert
    verify(dSLContext).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectQuery).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectLimitPercentStep).getQuery();
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftOuterJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftOuterJoin(isA(TableLike.class));
    verify(selectSeekStep1).limit(40);
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link PhysicalSpecificationSearchDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link EntitySearchOptions} {@link EntitySearchOptions#limit()} return one.
   *   <li>Then calls {@link EntitySearchOptions#limit()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given one; when EntitySearchOptions limit() return one; then calls limit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalSpecificationSearchDao.search(EntitySearchOptions)"})
  void testSearch_givenOne_whenEntitySearchOptionsLimitReturnOne_thenCallsLimit()
      throws DataAccessException {
    // Arrange
    SelectQuery<Record> selectQuery = mock(SelectQuery.class);
    when(selectQuery.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.getQuery()).thenReturn(selectQuery);

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftOuterJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftOuterJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<PhysicalSpecification> actualSearchResult = physicalSpecificationSearchDao.search(options);

    // Assert
    verify(options).limit();
    verify(options).searchQuery();
    verify(dSLContext).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectQuery).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectLimitPercentStep).getQuery();
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftOuterJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftOuterJoin(isA(TableLike.class));
    verify(selectSeekStep1).limit(1);
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualSearchResult.isEmpty());
  }
}
