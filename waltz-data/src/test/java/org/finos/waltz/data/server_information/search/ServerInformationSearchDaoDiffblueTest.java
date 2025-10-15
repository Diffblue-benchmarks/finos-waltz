package org.finos.waltz.data.server_information.search;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
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
import org.finos.waltz.model.server_information.ServerInformation;
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

class ServerInformationSearchDaoDiffblueTest {
  /**
   * Test {@link ServerInformationSearchDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link ServerInformationSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ServerInformationSearchDao.search(EntitySearchOptions)"})
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

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    when(dsl.dialect()).thenReturn(SQLDialect.SQL99);
    ServerInformationSearchDao serverInformationSearchDao = new ServerInformationSearchDao(dsl);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<ServerInformation> actualSearchResult =
        serverInformationSearchDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    verify(dsl, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep, atLeast(1)).fetch(isA(RecordMapper.class));
    verify(dsl).dialect();
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectSeekStep1, atLeast(1)).limit(40);
    verify(selectConditionStep, atLeast(1)).orderBy(isA(OrderField.class));
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link ServerInformationSearchDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#dialect()} return {@code SQL99}.
   *   <li>Then calls {@link EntitySearchOptions#limit()}.
   * </ul>
   *
   * <p>Method under test: {@link ServerInformationSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given DSLContext dialect() return 'SQL99'; then calls limit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ServerInformationSearchDao.search(EntitySearchOptions)"})
  void testSearch_givenDSLContextDialectReturnSql99_thenCallsLimit() throws DataAccessException {
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
    ServerInformationSearchDao serverInformationSearchDao = new ServerInformationSearchDao(dsl);

    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<ServerInformation> actualSearchResult = serverInformationSearchDao.search(options);

    // Assert
    verify(options, atLeast(1)).limit();
    verify(options).searchQuery();
    verify(dsl, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep, atLeast(1)).fetch(isA(RecordMapper.class));
    verify(dsl).dialect();
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectSeekStep1, atLeast(1)).limit(1);
    verify(selectConditionStep, atLeast(1)).orderBy(isA(OrderField.class));
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link ServerInformationSearchDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link EntitySearchOptions} {@link EntitySearchOptions#searchQuery()} return {@code
   *       foo}.
   *   <li>Then calls {@link EntitySearchOptions#limit()}.
   * </ul>
   *
   * <p>Method under test: {@link ServerInformationSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given 'foo'; when EntitySearchOptions searchQuery() return 'foo'; then calls limit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ServerInformationSearchDao.search(EntitySearchOptions)"})
  void testSearch_givenFoo_whenEntitySearchOptionsSearchQueryReturnFoo_thenCallsLimit()
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
    ServerInformationSearchDao serverInformationSearchDao = new ServerInformationSearchDao(dsl);

    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("foo");

    // Act
    List<ServerInformation> actualSearchResult = serverInformationSearchDao.search(options);

    // Assert
    verify(options, atLeast(1)).limit();
    verify(options).searchQuery();
    verify(dsl, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep, atLeast(1)).fetch(isA(RecordMapper.class));
    verify(dsl).dialect();
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectSeekStep1, atLeast(1)).limit(1);
    verify(selectConditionStep, atLeast(1)).orderBy(isA(OrderField.class));
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link ServerInformationSearchDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given {@code [}.
   * </ul>
   *
   * <p>Method under test: {@link ServerInformationSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions); given '['")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ServerInformationSearchDao.search(EntitySearchOptions)"})
  void testSearch_givenLeftSquareBracket() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.dialect()).thenReturn(SQLDialect.SQL99);
    ServerInformationSearchDao serverInformationSearchDao = new ServerInformationSearchDao(dsl);

    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.searchQuery()).thenReturn("[");

    // Act
    List<ServerInformation> actualSearchResult = serverInformationSearchDao.search(options);

    // Assert
    verify(options).searchQuery();
    verify(dsl).dialect();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link ServerInformationSearchDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#select(SelectFieldOrAsterisk[])}
   *       return {@link SelectSelectStep}.
   *   <li>Then calls {@link SelectSelectStep#select(SelectFieldOrAsterisk[])}.
   * </ul>
   *
   * <p>Method under test: {@link ServerInformationSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given SelectSelectStep select(SelectFieldOrAsterisk[]) return SelectSelectStep; then calls select(SelectFieldOrAsterisk[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ServerInformationSearchDao.search(EntitySearchOptions)"})
  void testSearch_givenSelectSelectStepSelectReturnSelectSelectStep_thenCallsSelect()
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

    SelectLimitPercentStep<Record> selectLimitPercentStep2 = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep2.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep12 = mock(SelectSeekStep1.class);
    when(selectSeekStep12.limit(anyInt())).thenReturn(selectLimitPercentStep2);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep12);

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    when(dsl.dialect()).thenReturn(SQLDialect.POSTGRES);
    ServerInformationSearchDao serverInformationSearchDao = new ServerInformationSearchDao(dsl);

    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<ServerInformation> actualSearchResult = serverInformationSearchDao.search(options);

    // Assert
    verify(options, atLeast(1)).limit();
    verify(options, atLeast(1)).searchQuery();
    verify(dsl, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep2).fetch(isA(RecordMapper.class));
    verify(selectLimitPercentStep, atLeast(1)).fetch(isA(RecordMapper.class));
    verify(dsl).dialect();
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2, atLeast(1)).from(isA(TableLike.class));
    verify(selectSeekStep12).limit(1);
    verify(selectSeekStep1, atLeast(1)).limit(1);
    verify(selectConditionStep2).orderBy(isA(OrderField.class));
    verify(selectConditionStep, atLeast(1)).orderBy(isA(OrderField.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep2).where(isA(Condition.class));
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link ServerInformationSearchDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link DSLContext#selectDistinct(SelectFieldOrAsterisk[])}.
   * </ul>
   *
   * <p>Method under test: {@link ServerInformationSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); then calls selectDistinct(SelectFieldOrAsterisk[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ServerInformationSearchDao.search(EntitySearchOptions)"})
  void testSearch_thenCallsSelectDistinct() throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectLimitPercentStep<Record> selectLimitPercentStep2 = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep2.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.limit(anyInt())).thenReturn(selectLimitPercentStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<String>any(), (Object[]) Mockito.any()))
        .thenReturn(selectConditionStep2);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectLimitPercentStep<Record> selectLimitPercentStep3 = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep3.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep12 = mock(SelectSeekStep1.class);
    when(selectSeekStep12.limit(anyInt())).thenReturn(selectLimitPercentStep3);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep12);

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    when(dsl.dialect()).thenReturn(SQLDialect.MARIADB);
    ServerInformationSearchDao serverInformationSearchDao = new ServerInformationSearchDao(dsl);

    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<ServerInformation> actualSearchResult = serverInformationSearchDao.search(options);

    // Assert
    verify(options, atLeast(1)).limit();
    verify(options, atLeast(1)).searchQuery();
    verify(dsl, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl, atLeast(1)).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep2).fetch(isA(RecordMapper.class));
    verify(selectLimitPercentStep3, atLeast(1)).fetch(isA(RecordMapper.class));
    verify(selectLimitPercentStep, atLeast(1)).fetch(isA(RecordMapper.class));
    verify(dsl).dialect();
    verify(selectSelectStep2, atLeast(1)).from(isA(TableLike.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectConditionStep2).limit(1);
    verify(selectSeekStep12, atLeast(1)).limit(1);
    verify(selectSeekStep1, atLeast(1)).limit(1);
    verify(selectConditionStep3, atLeast(1)).orderBy(isA(OrderField.class));
    verify(selectConditionStep, atLeast(1)).orderBy(isA(OrderField.class));
    verify(selectJoinStep2, atLeast(1)).where(Mockito.<Condition>any());
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    verify(selectJoinStep)
        .where(
            eq("MATCH(hostname, external_id, operating_system, location) AGAINST (?)"),
            (Object[]) Mockito.any());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link ServerInformationSearchDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link DSLContext#selectDistinct(SelectFieldOrAsterisk[])}.
   * </ul>
   *
   * <p>Method under test: {@link ServerInformationSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); then calls selectDistinct(SelectFieldOrAsterisk[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ServerInformationSearchDao.search(EntitySearchOptions)"})
  void testSearch_thenCallsSelectDistinct2() throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectLimitPercentStep<Record> selectLimitPercentStep2 = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep2.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.limit(anyInt())).thenReturn(selectLimitPercentStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<String>any(), (Object[]) Mockito.any()))
        .thenReturn(selectConditionStep2);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectLimitPercentStep<Record> selectLimitPercentStep3 = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep3.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep12 = mock(SelectSeekStep1.class);
    when(selectSeekStep12.limit(anyInt())).thenReturn(selectLimitPercentStep3);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep12);

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    when(dsl.dialect()).thenReturn(SQLDialect.MARIADB);
    ServerInformationSearchDao serverInformationSearchDao = new ServerInformationSearchDao(dsl);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<ServerInformation> actualSearchResult =
        serverInformationSearchDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    verify(dsl, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl, atLeast(1)).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep2).fetch(isA(RecordMapper.class));
    verify(selectLimitPercentStep3, atLeast(1)).fetch(isA(RecordMapper.class));
    verify(selectLimitPercentStep, atLeast(1)).fetch(isA(RecordMapper.class));
    verify(dsl).dialect();
    verify(selectSelectStep2, atLeast(1)).from(isA(TableLike.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectConditionStep2).limit(40);
    verify(selectSeekStep12, atLeast(1)).limit(40);
    verify(selectSeekStep1, atLeast(1)).limit(40);
    verify(selectConditionStep3, atLeast(1)).orderBy(isA(OrderField.class));
    verify(selectConditionStep, atLeast(1)).orderBy(isA(OrderField.class));
    verify(selectJoinStep2, atLeast(1)).where(Mockito.<Condition>any());
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    verify(selectJoinStep)
        .where(
            eq("MATCH(hostname, external_id, operating_system, location) AGAINST (?)"),
            (Object[]) Mockito.any());
    assertTrue(actualSearchResult.isEmpty());
  }
}
