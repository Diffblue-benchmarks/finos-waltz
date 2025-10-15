package org.finos.waltz.data.change_initiative.search;

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
import org.finos.waltz.model.change_initiative.ChangeInitiative;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions.Builder;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.OrderField;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
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
import org.mockito.Mockito;

class ChangeInitiativeSearchDaoDiffblueTest {
  /**
   * Test {@link ChangeInitiativeSearchDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link ChangeInitiativeSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeInitiativeSearchDao.search(EntitySearchOptions)"})
  void testSearch() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.dialect()).thenReturn(SQLDialect.SQL99);
    ChangeInitiativeSearchDao changeInitiativeSearchDao = new ChangeInitiativeSearchDao(dsl);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<ChangeInitiative> actualSearchResult =
        changeInitiativeSearchDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("[")
                .userId("42")
                .build());

    // Assert
    verify(dsl).dialect();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link ChangeInitiativeSearchDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given {@link SelectLimitPercentStep} {@link SelectLimitPercentStep#fetch(RecordMapper)}
   *       return {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link DSLContext#select(SelectFieldOrAsterisk[])}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeInitiativeSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given SelectLimitPercentStep fetch(RecordMapper) return ArrayList(); then calls select(SelectFieldOrAsterisk[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeInitiativeSearchDao.search(EntitySearchOptions)"})
  void testSearch_givenSelectLimitPercentStepFetchReturnArrayList_thenCallsSelect()
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

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    when(dsl.dialect()).thenReturn(SQLDialect.SQL99);
    ChangeInitiativeSearchDao changeInitiativeSearchDao = new ChangeInitiativeSearchDao(dsl);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<ChangeInitiative> actualSearchResult =
        changeInitiativeSearchDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(dsl).dialect();
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSeekStep1).limit(40);
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualSearchResult.isEmpty());
  }
}
