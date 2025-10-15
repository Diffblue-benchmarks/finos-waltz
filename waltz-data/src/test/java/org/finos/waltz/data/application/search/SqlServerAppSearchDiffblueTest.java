package org.finos.waltz.data.application.search;

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
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions.Builder;
import org.finos.waltz.schema.tables.records.ApplicationRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.RecordMapper;
import org.jooq.SQL;
import org.jooq.SelectConditionStep;
import org.jooq.SelectLimitPercentStep;
import org.jooq.SelectWhereStep;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SqlServerAppSearchDiffblueTest {
  /**
   * Test {@link SqlServerAppSearch#searchFullText(DSLContext, EntitySearchOptions)}.
   *
   * <p>Method under test: {@link SqlServerAppSearch#searchFullText(DSLContext,
   * EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test searchFullText(DSLContext, EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SqlServerAppSearch.searchFullText(DSLContext, EntitySearchOptions)"})
  void testSearchFullText() throws DataAccessException {
    // Arrange
    SqlServerAppSearch sqlServerAppSearch = new SqlServerAppSearch();

    SelectLimitPercentStep<ApplicationRecord> selectLimitPercentStep =
        mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<ApplicationRecord, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<ApplicationRecord> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<ApplicationRecord> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectWhereStep<ApplicationRecord> selectWhereStep = mock(SelectWhereStep.class);
    when(selectWhereStep.where(Mockito.<SQL>any())).thenReturn(selectConditionStep2);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.selectFrom(Mockito.<Table<ApplicationRecord>>any())).thenReturn(selectWhereStep);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<Application> actualSearchFullTextResult =
        sqlServerAppSearch.searchFullText(
            dsl,
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("[")
                .userId("42")
                .build());

    // Assert
    verify(dsl).selectFrom(isA(Table.class));
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).limit(40);
    verify(selectWhereStep).where(isA(SQL.class));
    assertTrue(actualSearchFullTextResult.isEmpty());
  }

  /**
   * Test {@link SqlServerAppSearch#searchFullText(DSLContext, EntitySearchOptions)}.
   *
   * <p>Method under test: {@link SqlServerAppSearch#searchFullText(DSLContext,
   * EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test searchFullText(DSLContext, EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SqlServerAppSearch.searchFullText(DSLContext, EntitySearchOptions)"})
  void testSearchFullText2() throws DataAccessException {
    // Arrange
    SqlServerAppSearch sqlServerAppSearch = new SqlServerAppSearch();

    SelectLimitPercentStep<ApplicationRecord> selectLimitPercentStep =
        mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<ApplicationRecord, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<ApplicationRecord> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<ApplicationRecord> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectWhereStep<ApplicationRecord> selectWhereStep = mock(SelectWhereStep.class);
    when(selectWhereStep.where(Mockito.<SQL>any())).thenReturn(selectConditionStep2);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.selectFrom(Mockito.<Table<ApplicationRecord>>any())).thenReturn(selectWhereStep);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<Application> actualSearchFullTextResult =
        sqlServerAppSearch.searchFullText(
            dsl,
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search")
                .userId("42")
                .build());

    // Assert
    verify(dsl).selectFrom(isA(Table.class));
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).limit(40);
    verify(selectWhereStep).where(isA(SQL.class));
    assertTrue(actualSearchFullTextResult.isEmpty());
  }

  /**
   * Test {@link SqlServerAppSearch#searchFullText(DSLContext, EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   *   <li>When builder addEntityLifecycleStatuses {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link SqlServerAppSearch#searchFullText(DSLContext,
   * EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test searchFullText(DSLContext, EntitySearchOptions); given 'ACTIVE'; when builder addEntityLifecycleStatuses 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SqlServerAppSearch.searchFullText(DSLContext, EntitySearchOptions)"})
  void testSearchFullText_givenActive_whenBuilderAddEntityLifecycleStatusesActive()
      throws DataAccessException {
    // Arrange
    SqlServerAppSearch sqlServerAppSearch = new SqlServerAppSearch();

    SelectLimitPercentStep<ApplicationRecord> selectLimitPercentStep =
        mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<ApplicationRecord, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<ApplicationRecord> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<ApplicationRecord> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectWhereStep<ApplicationRecord> selectWhereStep = mock(SelectWhereStep.class);
    when(selectWhereStep.where(Mockito.<SQL>any())).thenReturn(selectConditionStep2);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.selectFrom(Mockito.<Table<ApplicationRecord>>any())).thenReturn(selectWhereStep);

    Builder builderResult = ImmutableEntitySearchOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    // Act
    List<Application> actualSearchFullTextResult =
        sqlServerAppSearch.searchFullText(
            dsl,
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    verify(dsl).selectFrom(isA(Table.class));
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).limit(40);
    verify(selectWhereStep).where(isA(SQL.class));
    assertTrue(actualSearchFullTextResult.isEmpty());
  }

  /**
   * Test {@link SqlServerAppSearch#searchFullText(DSLContext, EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   *   <li>When builder addEntityLifecycleStatuses {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link SqlServerAppSearch#searchFullText(DSLContext,
   * EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test searchFullText(DSLContext, EntitySearchOptions); given 'PENDING'; when builder addEntityLifecycleStatuses 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SqlServerAppSearch.searchFullText(DSLContext, EntitySearchOptions)"})
  void testSearchFullText_givenPending_whenBuilderAddEntityLifecycleStatusesPending()
      throws DataAccessException {
    // Arrange
    SqlServerAppSearch sqlServerAppSearch = new SqlServerAppSearch();

    SelectLimitPercentStep<ApplicationRecord> selectLimitPercentStep =
        mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<ApplicationRecord, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<ApplicationRecord> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<ApplicationRecord> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectWhereStep<ApplicationRecord> selectWhereStep = mock(SelectWhereStep.class);
    when(selectWhereStep.where(Mockito.<SQL>any())).thenReturn(selectConditionStep2);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.selectFrom(Mockito.<Table<ApplicationRecord>>any())).thenReturn(selectWhereStep);

    Builder builderResult = ImmutableEntitySearchOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.PENDING);
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    // Act
    List<Application> actualSearchFullTextResult =
        sqlServerAppSearch.searchFullText(
            dsl,
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    verify(dsl).selectFrom(isA(Table.class));
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).limit(40);
    verify(selectWhereStep).where(isA(SQL.class));
    assertTrue(actualSearchFullTextResult.isEmpty());
  }

  /**
   * Test {@link SqlServerAppSearch#searchFullText(DSLContext, EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SqlServerAppSearch#searchFullText(DSLContext,
   * EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test searchFullText(DSLContext, EntitySearchOptions); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SqlServerAppSearch.searchFullText(DSLContext, EntitySearchOptions)"})
  void testSearchFullText_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SqlServerAppSearch sqlServerAppSearch = new SqlServerAppSearch();

    SelectLimitPercentStep<ApplicationRecord> selectLimitPercentStep =
        mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<ApplicationRecord, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<ApplicationRecord> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<ApplicationRecord> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectWhereStep<ApplicationRecord> selectWhereStep = mock(SelectWhereStep.class);
    when(selectWhereStep.where(Mockito.<SQL>any())).thenReturn(selectConditionStep2);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.selectFrom(Mockito.<Table<ApplicationRecord>>any())).thenReturn(selectWhereStep);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<Application> actualSearchFullTextResult =
        sqlServerAppSearch.searchFullText(
            dsl,
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    verify(dsl).selectFrom(isA(Table.class));
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectConditionStep).limit(40);
    verify(selectWhereStep).where(isA(SQL.class));
    assertTrue(actualSearchFullTextResult.isEmpty());
  }
}
