package org.finos.waltz.data.legal_entity.search;

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
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions.Builder;
import org.finos.waltz.model.legal_entity.LegalEntity;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.OrderField;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectLimitPercentStep;
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
class LegalEntitySearchDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private LegalEntitySearchDao legalEntitySearchDao;

  /**
   * Test {@link LegalEntitySearchDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link LegalEntitySearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LegalEntitySearchDao.search(EntitySearchOptions)"})
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
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<LegalEntity> actualSearchResult =
        legalEntitySearchDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    verify(dSLContext, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep, atLeast(1)).fetch(isA(RecordMapper.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectSeekStep1, atLeast(1)).limit(40);
    verify(selectConditionStep, atLeast(1)).orderBy(isA(OrderField.class));
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link LegalEntitySearchDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link LegalEntitySearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LegalEntitySearchDao.search(EntitySearchOptions)"})
  void testSearch2() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertTrue(
        legalEntitySearchDao
            .search(
                builderResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .searchQuery("[")
                    .userId("42")
                    .build())
            .isEmpty());
  }

  /**
   * Test {@link LegalEntitySearchDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link LegalEntitySearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LegalEntitySearchDao.search(EntitySearchOptions)"})
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
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<LegalEntity> actualSearchResult =
        legalEntitySearchDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search")
                .userId("42")
                .build());

    // Assert
    verify(dSLContext, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep, atLeast(1)).fetch(isA(RecordMapper.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectSeekStep1, atLeast(1)).limit(40);
    verify(selectConditionStep, atLeast(1)).orderBy(isA(OrderField.class));
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link LegalEntitySearchDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link EntitySearchOptions} {@link EntitySearchOptions#limit()} return one.
   *   <li>Then calls {@link EntitySearchOptions#limit()}.
   * </ul>
   *
   * <p>Method under test: {@link LegalEntitySearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given one; when EntitySearchOptions limit() return one; then calls limit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LegalEntitySearchDao.search(EntitySearchOptions)"})
  void testSearch_givenOne_whenEntitySearchOptionsLimitReturnOne_thenCallsLimit()
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
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<LegalEntity> actualSearchResult = legalEntitySearchDao.search(options);

    // Assert
    verify(options, atLeast(1)).limit();
    verify(options).searchQuery();
    verify(dSLContext, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep, atLeast(1)).fetch(isA(RecordMapper.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectSeekStep1, atLeast(1)).limit(1);
    verify(selectConditionStep, atLeast(1)).orderBy(isA(OrderField.class));
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualSearchResult.isEmpty());
  }
}
