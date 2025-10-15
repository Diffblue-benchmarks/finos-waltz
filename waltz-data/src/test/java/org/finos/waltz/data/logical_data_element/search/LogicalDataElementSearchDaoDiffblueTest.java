package org.finos.waltz.data.logical_data_element.search;

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
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions.Builder;
import org.finos.waltz.model.logical_data_element.LogicalDataElement;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.OrderField;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectLimitPercentStep;
import org.jooq.SelectOrderByStep;
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
class LogicalDataElementSearchDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private LogicalDataElementSearchDao logicalDataElementSearchDao;

  /**
   * Test {@link LogicalDataElementSearchDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link LogicalDataElementSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalDataElementSearchDao.search(EntitySearchOptions)"})
  void testSearch() throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectOrderByStep<Record> selectOrderByStep = mock(SelectOrderByStep.class);
    when(selectOrderByStep.orderBy(Mockito.<OrderField<Object>>any())).thenReturn(selectSeekStep1);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.union(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<LogicalDataElement> actualSearchResult =
        logicalDataElementSearchDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    verify(dSLContext, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectSeekStep1).limit(40);
    verify(selectOrderByStep).orderBy(isA(OrderField.class));
    verify(selectConditionStep).union(isA(Select.class));
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link LogicalDataElementSearchDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link LogicalDataElementSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalDataElementSearchDao.search(EntitySearchOptions)"})
  void testSearch2() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertTrue(
        logicalDataElementSearchDao
            .search(
                builderResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .searchQuery("[")
                    .userId("42")
                    .build())
            .isEmpty());
  }

  /**
   * Test {@link LogicalDataElementSearchDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link LogicalDataElementSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalDataElementSearchDao.search(EntitySearchOptions)"})
  void testSearch3() throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectOrderByStep<Record> selectOrderByStep = mock(SelectOrderByStep.class);
    when(selectOrderByStep.orderBy(Mockito.<OrderField<Object>>any())).thenReturn(selectSeekStep1);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.union(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<LogicalDataElement> actualSearchResult =
        logicalDataElementSearchDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search")
                .userId("42")
                .build());

    // Assert
    verify(dSLContext, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectSeekStep1).limit(40);
    verify(selectOrderByStep).orderBy(isA(OrderField.class));
    verify(selectConditionStep).union(isA(Select.class));
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link LogicalDataElementSearchDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   *   <li>When builder addEntityLifecycleStatuses {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalDataElementSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given 'ACTIVE'; when builder addEntityLifecycleStatuses 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalDataElementSearchDao.search(EntitySearchOptions)"})
  void testSearch_givenActive_whenBuilderAddEntityLifecycleStatusesActive()
      throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectOrderByStep<Record> selectOrderByStep = mock(SelectOrderByStep.class);
    when(selectOrderByStep.orderBy(Mockito.<OrderField<Object>>any())).thenReturn(selectSeekStep1);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.union(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    Builder builderResult = ImmutableEntitySearchOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    // Act
    List<LogicalDataElement> actualSearchResult =
        logicalDataElementSearchDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    verify(dSLContext, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectSeekStep1).limit(40);
    verify(selectOrderByStep).orderBy(isA(OrderField.class));
    verify(selectConditionStep).union(isA(Select.class));
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link LogicalDataElementSearchDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link EntitySearchOptions#entityLifecycleStatuses()}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalDataElementSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions); given one; then calls entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalDataElementSearchDao.search(EntitySearchOptions)"})
  void testSearch_givenOne_thenCallsEntityLifecycleStatuses() throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectOrderByStep<Record> selectOrderByStep = mock(SelectOrderByStep.class);
    when(selectOrderByStep.orderBy(Mockito.<OrderField<Object>>any())).thenReturn(selectSeekStep1);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.union(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.entityLifecycleStatuses()).thenReturn(new ArrayList<>());
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<LogicalDataElement> actualSearchResult = logicalDataElementSearchDao.search(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options).limit();
    verify(options).searchQuery();
    verify(dSLContext, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectSeekStep1).limit(1);
    verify(selectOrderByStep).orderBy(isA(OrderField.class));
    verify(selectConditionStep).union(isA(Select.class));
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualSearchResult.isEmpty());
  }
}
