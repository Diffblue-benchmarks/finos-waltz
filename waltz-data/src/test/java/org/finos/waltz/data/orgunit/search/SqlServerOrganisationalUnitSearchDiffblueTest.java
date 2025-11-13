package org.finos.waltz.data.orgunit.search;

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
import org.finos.waltz.model.orgunit.OrganisationalUnit;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQL;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectLimitPercentStep;
import org.jooq.SelectSelectStep;
import org.jooq.TableLike;
import org.jooq.exception.DataAccessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SqlServerOrganisationalUnitSearchDiffblueTest {
  /**
   * Test {@link SqlServerOrganisationalUnitSearch#searchFullText(DSLContext, EntitySearchOptions)}.
   *
   * <p>Method under test: {@link SqlServerOrganisationalUnitSearch#searchFullText(DSLContext,
   * EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test searchFullText(DSLContext, EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SqlServerOrganisationalUnitSearch.searchFullText(DSLContext, EntitySearchOptions)"
  })
  void testSearchFullText() throws DataAccessException {
    // Arrange
    SqlServerOrganisationalUnitSearch sqlServerOrganisationalUnitSearch =
        new SqlServerOrganisationalUnitSearch();

    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<SQL>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<OrganisationalUnit> actualSearchFullTextResult =
        sqlServerOrganisationalUnitSearch.searchFullText(
            dsl,
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("[")
                .userId("42")
                .build());

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).limit(40);
    verify(selectJoinStep).where(isA(SQL.class));
    assertTrue(actualSearchFullTextResult.isEmpty());
  }

  /**
   * Test {@link SqlServerOrganisationalUnitSearch#searchFullText(DSLContext, EntitySearchOptions)}.
   *
   * <p>Method under test: {@link SqlServerOrganisationalUnitSearch#searchFullText(DSLContext,
   * EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test searchFullText(DSLContext, EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SqlServerOrganisationalUnitSearch.searchFullText(DSLContext, EntitySearchOptions)"
  })
  void testSearchFullText2() throws DataAccessException {
    // Arrange
    SqlServerOrganisationalUnitSearch sqlServerOrganisationalUnitSearch =
        new SqlServerOrganisationalUnitSearch();

    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<SQL>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<OrganisationalUnit> actualSearchFullTextResult =
        sqlServerOrganisationalUnitSearch.searchFullText(
            dsl,
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search")
                .userId("42")
                .build());

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).limit(40);
    verify(selectJoinStep).where(isA(SQL.class));
    assertTrue(actualSearchFullTextResult.isEmpty());
  }

  /**
   * Test {@link SqlServerOrganisationalUnitSearch#searchFullText(DSLContext, EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SqlServerOrganisationalUnitSearch#searchFullText(DSLContext,
   * EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test searchFullText(DSLContext, EntitySearchOptions); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SqlServerOrganisationalUnitSearch.searchFullText(DSLContext, EntitySearchOptions)"
  })
  void testSearchFullText_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SqlServerOrganisationalUnitSearch sqlServerOrganisationalUnitSearch =
        new SqlServerOrganisationalUnitSearch();

    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<SQL>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<OrganisationalUnit> actualSearchFullTextResult =
        sqlServerOrganisationalUnitSearch.searchFullText(
            dsl,
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).limit(40);
    verify(selectJoinStep).where(isA(SQL.class));
    assertTrue(actualSearchFullTextResult.isEmpty());
  }
}
