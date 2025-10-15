package org.finos.waltz.data.software_catalog;

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
import java.util.Collection;
import java.util.List;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions.Builder;
import org.finos.waltz.model.software_catalog.SoftwarePackage;
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
class SoftwarePackageDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private SoftwarePackageDao softwarePackageDao;

  /**
   * Test {@link SoftwarePackageDao#findByIds(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   * </ul>
   *
   * <p>Method under test: {@link SoftwarePackageDao#findByIds(Collection)}
   */
  @Test
  @DisplayName("Test findByIds(Collection) with 'Collection'; given one; when ArrayList() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SoftwarePackageDao.findByIds(Collection)"})
  void testFindByIdsWithCollection_givenOne_whenArrayListAddOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    List<SoftwarePackage> actualFindByIdsResult = softwarePackageDao.findByIds(ids);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link SoftwarePackageDao#findByIds(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link SoftwarePackageDao#findByIds(Collection)}
   */
  @Test
  @DisplayName(
      "Test findByIds(Collection) with 'Collection'; given zero; when ArrayList() add zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SoftwarePackageDao.findByIds(Collection)"})
  void testFindByIdsWithCollection_givenZero_whenArrayListAddZero() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(0L);
    ids.add(1L);

    // Act
    List<SoftwarePackage> actualFindByIdsResult = softwarePackageDao.findByIds(ids);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link SoftwarePackageDao#findByIds(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SoftwarePackageDao#findByIds(Collection)}
   */
  @Test
  @DisplayName("Test findByIds(Collection) with 'Collection'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SoftwarePackageDao.findByIds(Collection)"})
  void testFindByIdsWithCollection_whenArrayList() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<SoftwarePackage> actualFindByIdsResult = softwarePackageDao.findByIds(new ArrayList<>());

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link SoftwarePackageDao#findByIds(Long[])} with {@code Long[]}.
   *
   * <p>Method under test: {@link SoftwarePackageDao#findByIds(Long[])}
   */
  @Test
  @DisplayName("Test findByIds(Long[]) with 'Long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SoftwarePackageDao.findByIds(Long[])"})
  void testFindByIdsWithLong() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<SoftwarePackage> actualFindByIdsResult = softwarePackageDao.findByIds();

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link SoftwarePackageDao#findByIds(Long[])} with {@code Long[]}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link SoftwarePackageDao#findByIds(Long[])}
   */
  @Test
  @DisplayName("Test findByIds(Long[]) with 'Long[]'; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SoftwarePackageDao.findByIds(Long[])"})
  void testFindByIdsWithLong_whenOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<SoftwarePackage> actualFindByIdsResult = softwarePackageDao.findByIds(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link SoftwarePackageDao#findByIds(Long[])} with {@code Long[]}.
   *
   * <ul>
   *   <li>When one and two.
   * </ul>
   *
   * <p>Method under test: {@link SoftwarePackageDao#findByIds(Long[])}
   */
  @Test
  @DisplayName("Test findByIds(Long[]) with 'Long[]'; when one and two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SoftwarePackageDao.findByIds(Long[])"})
  void testFindByIdsWithLong_whenOneAndTwo() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<SoftwarePackage> actualFindByIdsResult = softwarePackageDao.findByIds(1L, 2L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link SoftwarePackageDao#findAll()}.
   *
   * <p>Method under test: {@link SoftwarePackageDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SoftwarePackageDao.findAll()"})
  void testFindAll() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<SoftwarePackage> actualFindAllResult = softwarePackageDao.findAll();

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link SoftwarePackageDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link SoftwarePackageDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SoftwarePackageDao.search(EntitySearchOptions)"})
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
    List<SoftwarePackage> actualSearchResult =
        softwarePackageDao.search(
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
    verify(selectConditionStep, atLeast(1)).orderBy(Mockito.<OrderField<Object>>any());
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link SoftwarePackageDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link SoftwarePackageDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SoftwarePackageDao.search(EntitySearchOptions)"})
  void testSearch2() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertTrue(
        softwarePackageDao
            .search(
                builderResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .searchQuery("[")
                    .userId("42")
                    .build())
            .isEmpty());
  }

  /**
   * Test {@link SoftwarePackageDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link EntitySearchOptions} {@link EntitySearchOptions#searchQuery()} return {@code
   *       foo}.
   *   <li>Then calls {@link EntitySearchOptions#limit()}.
   * </ul>
   *
   * <p>Method under test: {@link SoftwarePackageDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given 'foo'; when EntitySearchOptions searchQuery() return 'foo'; then calls limit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SoftwarePackageDao.search(EntitySearchOptions)"})
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
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("foo");

    // Act
    List<SoftwarePackage> actualSearchResult = softwarePackageDao.search(options);

    // Assert
    verify(options, atLeast(1)).limit();
    verify(options).searchQuery();
    verify(dSLContext, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep, atLeast(1)).fetch(isA(RecordMapper.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectSeekStep1, atLeast(1)).limit(1);
    verify(selectConditionStep, atLeast(1)).orderBy(Mockito.<OrderField<Object>>any());
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link SoftwarePackageDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given {@code Search Query}.
   *   <li>When {@link EntitySearchOptions} {@link EntitySearchOptions#searchQuery()} return {@code
   *       Search Query}.
   * </ul>
   *
   * <p>Method under test: {@link SoftwarePackageDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given 'Search Query'; when EntitySearchOptions searchQuery() return 'Search Query'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SoftwarePackageDao.search(EntitySearchOptions)"})
  void testSearch_givenSearchQuery_whenEntitySearchOptionsSearchQueryReturnSearchQuery()
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
    List<SoftwarePackage> actualSearchResult = softwarePackageDao.search(options);

    // Assert
    verify(options, atLeast(1)).limit();
    verify(options).searchQuery();
    verify(dSLContext, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep, atLeast(1)).fetch(isA(RecordMapper.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectSeekStep1, atLeast(1)).limit(1);
    verify(selectConditionStep, atLeast(1)).orderBy(Mockito.<OrderField<Object>>any());
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualSearchResult.isEmpty());
  }
}
