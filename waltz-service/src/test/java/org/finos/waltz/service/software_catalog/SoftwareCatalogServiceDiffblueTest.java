package org.finos.waltz.service.software_catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.software_catalog.SoftwarePackageDao;
import org.finos.waltz.data.software_catalog.SoftwareUsageDao;
import org.finos.waltz.data.software_catalog.SoftwareVersionDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplicationIdSelectionOptions;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.software_catalog.ImmutableSoftwareCatalog;
import org.finos.waltz.model.software_catalog.ImmutableSoftwarePackage;
import org.finos.waltz.model.software_catalog.ImmutableSoftwarePackage.Builder;
import org.finos.waltz.model.software_catalog.ImmutableSoftwareSummaryStatistics;
import org.finos.waltz.model.software_catalog.ImmutableSoftwareUsage;
import org.finos.waltz.model.software_catalog.ImmutableSoftwareVersion;
import org.finos.waltz.model.software_catalog.SoftwareCatalog;
import org.finos.waltz.model.software_catalog.SoftwarePackage;
import org.finos.waltz.model.software_catalog.SoftwareSummaryStatistics;
import org.finos.waltz.model.software_catalog.SoftwareUsage;
import org.finos.waltz.model.software_catalog.SoftwareVersion;
import org.finos.waltz.model.tally.ImmutableOrderedTally;
import org.finos.waltz.model.tally.Tally;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SoftwareCatalogServiceDiffblueTest {
  @InjectMocks private SoftwareCatalogService softwareCatalogService;

  @Mock private SoftwarePackageDao softwarePackageDao;

  @Mock private SoftwareUsageDao softwareUsageDao;

  @Mock private SoftwareVersionDao softwareVersionDao;

  /**
   * Test {@link SoftwareCatalogService#makeCatalogForAppIds(List)}.
   *
   * <p>Method under test: {@link SoftwareCatalogService#makeCatalogForAppIds(List)}
   */
  @Test
  @DisplayName("Test makeCatalogForAppIds(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.makeCatalogForAppIds(List)"})
  void testMakeCatalogForAppIds() {
    // Arrange
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(softwareUsageDao.findByAppIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());
    when(softwareVersionDao.findBySoftwarePackageIds(Mockito.<Collection<Long>>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> softwareCatalogService.makeCatalogForAppIds(new ArrayList<>()));
    verify(softwarePackageDao).findByIds(isA(Collection.class));
    verify(softwareUsageDao).findByAppIds(isA(List.class));
    verify(softwareVersionDao).findBySoftwarePackageIds(isA(Collection.class));
  }

  /**
   * Test {@link SoftwareCatalogService#makeCatalogForAppIds(List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then return packages Empty.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#makeCatalogForAppIds(List)}
   */
  @Test
  @DisplayName(
      "Test makeCatalogForAppIds(List); given one; when ArrayList() add one; then return packages Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.makeCatalogForAppIds(List)"})
  void testMakeCatalogForAppIds_givenOne_whenArrayListAddOne_thenReturnPackagesEmpty() {
    // Arrange
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(softwareUsageDao.findByAppIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());
    when(softwareVersionDao.findBySoftwarePackageIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<Long> appIds = new ArrayList<>();
    appIds.add(1L);

    // Act
    SoftwareCatalog actualMakeCatalogForAppIdsResult =
        softwareCatalogService.makeCatalogForAppIds(appIds);

    // Assert
    verify(softwarePackageDao).findByIds(isA(Collection.class));
    verify(softwareUsageDao).findByAppIds(isA(List.class));
    verify(softwareVersionDao).findBySoftwarePackageIds(isA(Collection.class));
    assertTrue(actualMakeCatalogForAppIdsResult instanceof ImmutableSoftwareCatalog);
    List<SoftwarePackage> packagesResult = actualMakeCatalogForAppIdsResult.packages();
    assertTrue(packagesResult.isEmpty());
    assertSame(packagesResult, actualMakeCatalogForAppIdsResult.usages());
    assertSame(packagesResult, actualMakeCatalogForAppIdsResult.versions());
  }

  /**
   * Test {@link SoftwareCatalogService#makeCatalogForAppIds(List)}.
   *
   * <ul>
   *   <li>Given {@link SoftwarePackageDao}.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#makeCatalogForAppIds(List)}
   */
  @Test
  @DisplayName("Test makeCatalogForAppIds(List); given SoftwarePackageDao")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.makeCatalogForAppIds(List)"})
  void testMakeCatalogForAppIds_givenSoftwarePackageDao() {
    // Arrange
    when(softwareUsageDao.findByAppIds(Mockito.<List<Long>>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> softwareCatalogService.makeCatalogForAppIds(new ArrayList<>()));
    verify(softwareUsageDao).findByAppIds(isA(List.class));
  }

  /**
   * Test {@link SoftwareCatalogService#makeCatalogForAppIds(List)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   *   <li>Then return packages Empty.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#makeCatalogForAppIds(List)}
   */
  @Test
  @DisplayName(
      "Test makeCatalogForAppIds(List); given zero; when ArrayList() add zero; then return packages Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.makeCatalogForAppIds(List)"})
  void testMakeCatalogForAppIds_givenZero_whenArrayListAddZero_thenReturnPackagesEmpty() {
    // Arrange
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(softwareUsageDao.findByAppIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());
    when(softwareVersionDao.findBySoftwarePackageIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<Long> appIds = new ArrayList<>();
    appIds.add(0L);
    appIds.add(1L);

    // Act
    SoftwareCatalog actualMakeCatalogForAppIdsResult =
        softwareCatalogService.makeCatalogForAppIds(appIds);

    // Assert
    verify(softwarePackageDao).findByIds(isA(Collection.class));
    verify(softwareUsageDao).findByAppIds(isA(List.class));
    verify(softwareVersionDao).findBySoftwarePackageIds(isA(Collection.class));
    assertTrue(actualMakeCatalogForAppIdsResult instanceof ImmutableSoftwareCatalog);
    List<SoftwarePackage> packagesResult = actualMakeCatalogForAppIdsResult.packages();
    assertTrue(packagesResult.isEmpty());
    assertSame(packagesResult, actualMakeCatalogForAppIdsResult.usages());
    assertSame(packagesResult, actualMakeCatalogForAppIdsResult.versions());
  }

  /**
   * Test {@link SoftwareCatalogService#makeCatalogForAppIds(List)}.
   *
   * <ul>
   *   <li>Then return packages Empty.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#makeCatalogForAppIds(List)}
   */
  @Test
  @DisplayName("Test makeCatalogForAppIds(List); then return packages Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.makeCatalogForAppIds(List)"})
  void testMakeCatalogForAppIds_thenReturnPackagesEmpty() {
    // Arrange
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(softwareUsageDao.findByAppIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());
    when(softwareVersionDao.findBySoftwarePackageIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    SoftwareCatalog actualMakeCatalogForAppIdsResult =
        softwareCatalogService.makeCatalogForAppIds(new ArrayList<>());

    // Assert
    verify(softwarePackageDao).findByIds(isA(Collection.class));
    verify(softwareUsageDao).findByAppIds(isA(List.class));
    verify(softwareVersionDao).findBySoftwarePackageIds(isA(Collection.class));
    assertTrue(actualMakeCatalogForAppIdsResult instanceof ImmutableSoftwareCatalog);
    List<SoftwarePackage> packagesResult = actualMakeCatalogForAppIdsResult.packages();
    assertTrue(packagesResult.isEmpty());
    assertSame(packagesResult, actualMakeCatalogForAppIdsResult.usages());
    assertSame(packagesResult, actualMakeCatalogForAppIdsResult.versions());
  }

  /**
   * Test {@link SoftwareCatalogService#makeCatalogForAppIds(List)}.
   *
   * <ul>
   *   <li>Then return usages Empty.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#makeCatalogForAppIds(List)}
   */
  @Test
  @DisplayName("Test makeCatalogForAppIds(List); then return usages Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.makeCatalogForAppIds(List)"})
  void testMakeCatalogForAppIds_thenReturnUsagesEmpty() {
    // Arrange
    ArrayList<SoftwarePackage> softwarePackageList = new ArrayList<>();

    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    softwarePackageList.add(
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build());
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(softwarePackageList);
    when(softwareUsageDao.findByAppIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());
    when(softwareVersionDao.findBySoftwarePackageIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    SoftwareCatalog actualMakeCatalogForAppIdsResult =
        softwareCatalogService.makeCatalogForAppIds(new ArrayList<>());

    // Assert
    verify(softwarePackageDao).findByIds(isA(Collection.class));
    verify(softwareUsageDao).findByAppIds(isA(List.class));
    verify(softwareVersionDao).findBySoftwarePackageIds(isA(Collection.class));
    assertTrue(actualMakeCatalogForAppIdsResult instanceof ImmutableSoftwareCatalog);
    List<SoftwareUsage> usagesResult = actualMakeCatalogForAppIdsResult.usages();
    assertTrue(usagesResult.isEmpty());
    assertEquals(softwarePackageList, actualMakeCatalogForAppIdsResult.packages());
    assertSame(usagesResult, actualMakeCatalogForAppIdsResult.versions());
  }

  /**
   * Test {@link SoftwareCatalogService#makeCatalogForAppIds(List)}.
   *
   * <ul>
   *   <li>Then return usages Empty.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#makeCatalogForAppIds(List)}
   */
  @Test
  @DisplayName("Test makeCatalogForAppIds(List); then return usages Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.makeCatalogForAppIds(List)"})
  void testMakeCatalogForAppIds_thenReturnUsagesEmpty2() {
    // Arrange
    ArrayList<SoftwarePackage> softwarePackageList = new ArrayList<>();

    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    softwarePackageList.add(
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build());

    Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);
    softwarePackageList.add(
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build());
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(softwarePackageList);
    when(softwareUsageDao.findByAppIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());
    when(softwareVersionDao.findBySoftwarePackageIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    SoftwareCatalog actualMakeCatalogForAppIdsResult =
        softwareCatalogService.makeCatalogForAppIds(new ArrayList<>());

    // Assert
    verify(softwarePackageDao).findByIds(isA(Collection.class));
    verify(softwareUsageDao).findByAppIds(isA(List.class));
    verify(softwareVersionDao).findBySoftwarePackageIds(isA(Collection.class));
    assertTrue(actualMakeCatalogForAppIdsResult instanceof ImmutableSoftwareCatalog);
    List<SoftwareUsage> usagesResult = actualMakeCatalogForAppIdsResult.usages();
    assertTrue(usagesResult.isEmpty());
    assertEquals(softwarePackageList, actualMakeCatalogForAppIdsResult.packages());
    assertSame(usagesResult, actualMakeCatalogForAppIdsResult.versions());
  }

  /**
   * Test {@link SoftwareCatalogService#makeCatalogForAppIds(List)}.
   *
   * <ul>
   *   <li>Then return usages is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#makeCatalogForAppIds(List)}
   */
  @Test
  @DisplayName("Test makeCatalogForAppIds(List); then return usages is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.makeCatalogForAppIds(List)"})
  void testMakeCatalogForAppIds_thenReturnUsagesIsArrayList() {
    // Arrange
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<SoftwareUsage> softwareUsageList = new ArrayList<>();
    softwareUsageList.add(
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build());
    when(softwareUsageDao.findByAppIds(Mockito.<List<Long>>any())).thenReturn(softwareUsageList);
    when(softwareVersionDao.findBySoftwarePackageIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    SoftwareCatalog actualMakeCatalogForAppIdsResult =
        softwareCatalogService.makeCatalogForAppIds(new ArrayList<>());

    // Assert
    verify(softwarePackageDao).findByIds(isA(Collection.class));
    verify(softwareUsageDao).findByAppIds(isA(List.class));
    verify(softwareVersionDao).findBySoftwarePackageIds(isA(Collection.class));
    assertTrue(actualMakeCatalogForAppIdsResult instanceof ImmutableSoftwareCatalog);
    assertEquals(softwareUsageList, actualMakeCatalogForAppIdsResult.usages());
  }

  /**
   * Test {@link SoftwareCatalogService#makeCatalogForAppIds(List)}.
   *
   * <ul>
   *   <li>Then return usages is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#makeCatalogForAppIds(List)}
   */
  @Test
  @DisplayName("Test makeCatalogForAppIds(List); then return usages is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.makeCatalogForAppIds(List)"})
  void testMakeCatalogForAppIds_thenReturnUsagesIsArrayList2() {
    // Arrange
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<SoftwareUsage> softwareUsageList = new ArrayList<>();
    softwareUsageList.add(
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build());
    softwareUsageList.add(
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build());
    when(softwareUsageDao.findByAppIds(Mockito.<List<Long>>any())).thenReturn(softwareUsageList);
    when(softwareVersionDao.findBySoftwarePackageIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    SoftwareCatalog actualMakeCatalogForAppIdsResult =
        softwareCatalogService.makeCatalogForAppIds(new ArrayList<>());

    // Assert
    verify(softwarePackageDao).findByIds(isA(Collection.class));
    verify(softwareUsageDao).findByAppIds(isA(List.class));
    verify(softwareVersionDao).findBySoftwarePackageIds(isA(Collection.class));
    assertTrue(actualMakeCatalogForAppIdsResult instanceof ImmutableSoftwareCatalog);
    assertEquals(softwareUsageList, actualMakeCatalogForAppIdsResult.usages());
  }

  /**
   * Test {@link SoftwareCatalogService#makeCatalogForAppIds(List)}.
   *
   * <ul>
   *   <li>Then return versions is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#makeCatalogForAppIds(List)}
   */
  @Test
  @DisplayName("Test makeCatalogForAppIds(List); then return versions is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.makeCatalogForAppIds(List)"})
  void testMakeCatalogForAppIds_thenReturnVersionsIsArrayList() {
    // Arrange
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(softwareUsageDao.findByAppIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());

    ArrayList<SoftwareVersion> softwareVersionList = new ArrayList<>();

    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    softwareVersionList.add(
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build());
    when(softwareVersionDao.findBySoftwarePackageIds(Mockito.<Collection<Long>>any()))
        .thenReturn(softwareVersionList);

    // Act
    SoftwareCatalog actualMakeCatalogForAppIdsResult =
        softwareCatalogService.makeCatalogForAppIds(new ArrayList<>());

    // Assert
    verify(softwarePackageDao).findByIds(isA(Collection.class));
    verify(softwareUsageDao).findByAppIds(isA(List.class));
    verify(softwareVersionDao).findBySoftwarePackageIds(isA(Collection.class));
    assertTrue(actualMakeCatalogForAppIdsResult instanceof ImmutableSoftwareCatalog);
    assertEquals(softwareVersionList, actualMakeCatalogForAppIdsResult.versions());
  }

  /**
   * Test {@link SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatisticsForAppIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SoftwareSummaryStatistics SoftwareCatalogService.calculateStatisticsForAppIdSelector(IdSelectionOptions)"
  })
  void testCalculateStatisticsForAppIdSelector() {
    // Arrange
    when(softwarePackageDao.toTallies(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Field<String>>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    SoftwareSummaryStatistics actualCalculateStatisticsForAppIdSelectorResult =
        softwareCatalogService.calculateStatisticsForAppIdSelector(options);

    // Assert
    verify(softwarePackageDao, atLeast(1))
        .toTallies(isA(Select.class), Mockito.<Field<String>>any());
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    assertTrue(
        actualCalculateStatisticsForAppIdSelectorResult
            instanceof ImmutableSoftwareSummaryStatistics);
    List<Tally<String>> groupCountsResult =
        actualCalculateStatisticsForAppIdSelectorResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, actualCalculateStatisticsForAppIdSelectorResult.nameCounts());
    assertSame(groupCountsResult, actualCalculateStatisticsForAppIdSelectorResult.vendorCounts());
  }

  /**
   * Test {@link SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatisticsForAppIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SoftwareSummaryStatistics SoftwareCatalogService.calculateStatisticsForAppIdSelector(IdSelectionOptions)"
  })
  void testCalculateStatisticsForAppIdSelector2() {
    // Arrange
    when(softwarePackageDao.toTallies(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Field<String>>any()))
        .thenReturn(new ArrayList<>());

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters immutableSelectionFilters = builderResult.build();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(immutableSelectionFilters);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    SoftwareSummaryStatistics actualCalculateStatisticsForAppIdSelectorResult =
        softwareCatalogService.calculateStatisticsForAppIdSelector(options);

    // Assert
    verify(softwarePackageDao, atLeast(1))
        .toTallies(isA(Select.class), Mockito.<Field<String>>any());
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options, atLeast(1)).filters();
    assertTrue(
        actualCalculateStatisticsForAppIdSelectorResult
            instanceof ImmutableSoftwareSummaryStatistics);
    List<Tally<String>> groupCountsResult =
        actualCalculateStatisticsForAppIdSelectorResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, actualCalculateStatisticsForAppIdSelectorResult.nameCounts());
    assertSame(groupCountsResult, actualCalculateStatisticsForAppIdSelectorResult.vendorCounts());
  }

  /**
   * Test {@link SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatisticsForAppIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SoftwareSummaryStatistics SoftwareCatalogService.calculateStatisticsForAppIdSelector(IdSelectionOptions)"
  })
  void testCalculateStatisticsForAppIdSelector3() {
    // Arrange
    SoftwarePackageDao softwarePackageDao = mock(SoftwarePackageDao.class);
    when(softwarePackageDao.toTallies(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Field<String>>any()))
        .thenReturn(new ArrayList<>());
    SoftwareCatalogService softwareCatalogService =
        new SoftwareCatalogService(
            softwarePackageDao, mock(SoftwareUsageDao.class), mock(SoftwareVersionDao.class));

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    SoftwareSummaryStatistics actualCalculateStatisticsForAppIdSelectorResult =
        softwareCatalogService.calculateStatisticsForAppIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(softwarePackageDao, atLeast(1))
        .toTallies(isA(Select.class), Mockito.<Field<String>>any());
    assertTrue(
        actualCalculateStatisticsForAppIdSelectorResult
            instanceof ImmutableSoftwareSummaryStatistics);
    List<Tally<String>> groupCountsResult =
        actualCalculateStatisticsForAppIdSelectorResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, actualCalculateStatisticsForAppIdSelectorResult.nameCounts());
    assertSame(groupCountsResult, actualCalculateStatisticsForAppIdSelectorResult.vendorCounts());
  }

  /**
   * Test {@link SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatisticsForAppIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SoftwareSummaryStatistics SoftwareCatalogService.calculateStatisticsForAppIdSelector(IdSelectionOptions)"
  })
  void testCalculateStatisticsForAppIdSelector4() {
    // Arrange
    SoftwarePackageDao softwarePackageDao = mock(SoftwarePackageDao.class);
    when(softwarePackageDao.toTallies(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Field<String>>any()))
        .thenReturn(new ArrayList<>());
    SoftwareCatalogService softwareCatalogService =
        new SoftwareCatalogService(
            softwarePackageDao, mock(SoftwareUsageDao.class), mock(SoftwareVersionDao.class));

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    SoftwareSummaryStatistics actualCalculateStatisticsForAppIdSelectorResult =
        softwareCatalogService.calculateStatisticsForAppIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(softwarePackageDao, atLeast(1))
        .toTallies(isA(Select.class), Mockito.<Field<String>>any());
    assertTrue(
        actualCalculateStatisticsForAppIdSelectorResult
            instanceof ImmutableSoftwareSummaryStatistics);
    List<Tally<String>> groupCountsResult =
        actualCalculateStatisticsForAppIdSelectorResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, actualCalculateStatisticsForAppIdSelectorResult.nameCounts());
    assertSame(groupCountsResult, actualCalculateStatisticsForAppIdSelectorResult.vendorCounts());
  }

  /**
   * Test {@link SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test calculateStatisticsForAppIdSelector(IdSelectionOptions); given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SoftwareSummaryStatistics SoftwareCatalogService.calculateStatisticsForAppIdSelector(IdSelectionOptions)"
  })
  void testCalculateStatisticsForAppIdSelector_givenHashSetAddActive() {
    // Arrange
    when(softwarePackageDao.toTallies(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Field<String>>any()))
        .thenReturn(new ArrayList<>());

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    SoftwareSummaryStatistics actualCalculateStatisticsForAppIdSelectorResult =
        softwareCatalogService.calculateStatisticsForAppIdSelector(options);

    // Assert
    verify(softwarePackageDao, atLeast(1))
        .toTallies(isA(Select.class), Mockito.<Field<String>>any());
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    assertTrue(
        actualCalculateStatisticsForAppIdSelectorResult
            instanceof ImmutableSoftwareSummaryStatistics);
    List<Tally<String>> groupCountsResult =
        actualCalculateStatisticsForAppIdSelectorResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, actualCalculateStatisticsForAppIdSelectorResult.nameCounts());
    assertSame(groupCountsResult, actualCalculateStatisticsForAppIdSelectorResult.vendorCounts());
  }

  /**
   * Test {@link SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test calculateStatisticsForAppIdSelector(IdSelectionOptions); given HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SoftwareSummaryStatistics SoftwareCatalogService.calculateStatisticsForAppIdSelector(IdSelectionOptions)"
  })
  void testCalculateStatisticsForAppIdSelector_givenHashSetAddPending() {
    // Arrange
    when(softwarePackageDao.toTallies(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Field<String>>any()))
        .thenReturn(new ArrayList<>());

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    SoftwareSummaryStatistics actualCalculateStatisticsForAppIdSelectorResult =
        softwareCatalogService.calculateStatisticsForAppIdSelector(options);

    // Assert
    verify(softwarePackageDao, atLeast(1))
        .toTallies(isA(Select.class), Mockito.<Field<String>>any());
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    assertTrue(
        actualCalculateStatisticsForAppIdSelectorResult
            instanceof ImmutableSoftwareSummaryStatistics);
    List<Tally<String>> groupCountsResult =
        actualCalculateStatisticsForAppIdSelectorResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, actualCalculateStatisticsForAppIdSelectorResult.nameCounts());
    assertSame(groupCountsResult, actualCalculateStatisticsForAppIdSelectorResult.vendorCounts());
  }

  /**
   * Test {@link SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatisticsForAppIdSelector(IdSelectionOptions); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SoftwareSummaryStatistics SoftwareCatalogService.calculateStatisticsForAppIdSelector(IdSelectionOptions)"
  })
  void testCalculateStatisticsForAppIdSelector_givenInHouse() {
    // Arrange
    SoftwarePackageDao softwarePackageDao = mock(SoftwarePackageDao.class);
    when(softwarePackageDao.toTallies(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Field<String>>any()))
        .thenReturn(new ArrayList<>());
    SoftwareCatalogService softwareCatalogService =
        new SoftwareCatalogService(
            softwarePackageDao, mock(SoftwareUsageDao.class), mock(SoftwareVersionDao.class));

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters filters = builderResult.build();

    ImmutableIdSelectionOptions.Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(filters);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    SoftwareSummaryStatistics actualCalculateStatisticsForAppIdSelectorResult =
        softwareCatalogService.calculateStatisticsForAppIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(softwarePackageDao, atLeast(1))
        .toTallies(isA(Select.class), Mockito.<Field<String>>any());
    assertTrue(
        actualCalculateStatisticsForAppIdSelectorResult
            instanceof ImmutableSoftwareSummaryStatistics);
    List<Tally<String>> groupCountsResult =
        actualCalculateStatisticsForAppIdSelectorResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, actualCalculateStatisticsForAppIdSelectorResult.nameCounts());
    assertSame(groupCountsResult, actualCalculateStatisticsForAppIdSelectorResult.vendorCounts());
  }

  /**
   * Test {@link SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatisticsForAppIdSelector(IdSelectionOptions); then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SoftwareSummaryStatistics SoftwareCatalogService.calculateStatisticsForAppIdSelector(IdSelectionOptions)"
  })
  void testCalculateStatisticsForAppIdSelector_thenCallsScope() {
    // Arrange
    when(softwarePackageDao.toTallies(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Field<String>>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    SoftwareSummaryStatistics actualCalculateStatisticsForAppIdSelectorResult =
        softwareCatalogService.calculateStatisticsForAppIdSelector(options);

    // Assert
    verify(softwarePackageDao, atLeast(1))
        .toTallies(isA(Select.class), Mockito.<Field<String>>any());
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(
        actualCalculateStatisticsForAppIdSelectorResult
            instanceof ImmutableSoftwareSummaryStatistics);
    List<Tally<String>> groupCountsResult =
        actualCalculateStatisticsForAppIdSelectorResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, actualCalculateStatisticsForAppIdSelectorResult.nameCounts());
    assertSame(groupCountsResult, actualCalculateStatisticsForAppIdSelectorResult.vendorCounts());
  }

  /**
   * Test {@link SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatisticsForAppIdSelector(IdSelectionOptions); then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SoftwareSummaryStatistics SoftwareCatalogService.calculateStatisticsForAppIdSelector(IdSelectionOptions)"
  })
  void testCalculateStatisticsForAppIdSelector_thenCallsScope2() {
    // Arrange
    when(softwarePackageDao.toTallies(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Field<String>>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APPLICATION)
                .name("Name")
                .build());

    // Act
    SoftwareSummaryStatistics actualCalculateStatisticsForAppIdSelectorResult =
        softwareCatalogService.calculateStatisticsForAppIdSelector(options);

    // Assert
    verify(softwarePackageDao, atLeast(1))
        .toTallies(isA(Select.class), Mockito.<Field<String>>any());
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(
        actualCalculateStatisticsForAppIdSelectorResult
            instanceof ImmutableSoftwareSummaryStatistics);
    List<Tally<String>> groupCountsResult =
        actualCalculateStatisticsForAppIdSelectorResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, actualCalculateStatisticsForAppIdSelectorResult.nameCounts());
    assertSame(groupCountsResult, actualCalculateStatisticsForAppIdSelectorResult.vendorCounts());
  }

  /**
   * Test {@link SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatisticsForAppIdSelector(IdSelectionOptions); then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SoftwareSummaryStatistics SoftwareCatalogService.calculateStatisticsForAppIdSelector(IdSelectionOptions)"
  })
  void testCalculateStatisticsForAppIdSelector_thenCallsScope3() {
    // Arrange
    when(softwarePackageDao.toTallies(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Field<String>>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    SoftwareSummaryStatistics actualCalculateStatisticsForAppIdSelectorResult =
        softwareCatalogService.calculateStatisticsForAppIdSelector(options);

    // Assert
    verify(softwarePackageDao, atLeast(1))
        .toTallies(isA(Select.class), Mockito.<Field<String>>any());
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(
        actualCalculateStatisticsForAppIdSelectorResult
            instanceof ImmutableSoftwareSummaryStatistics);
    List<Tally<String>> groupCountsResult =
        actualCalculateStatisticsForAppIdSelectorResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, actualCalculateStatisticsForAppIdSelectorResult.nameCounts());
    assertSame(groupCountsResult, actualCalculateStatisticsForAppIdSelectorResult.vendorCounts());
  }

  /**
   * Test {@link SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return groupCounts size is two.
   * </ul>
   *
   * <p>Method under test: {@link
   * SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test calculateStatisticsForAppIdSelector(IdSelectionOptions); then return groupCounts size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SoftwareSummaryStatistics SoftwareCatalogService.calculateStatisticsForAppIdSelector(IdSelectionOptions)"
  })
  void testCalculateStatisticsForAppIdSelector_thenReturnGroupCountsSizeIsTwo() {
    // Arrange
    ArrayList<Tally<String>> tallyList = new ArrayList<>();

    ImmutableOrderedTally.Builder<String> builderResult = ImmutableOrderedTally.builder();
    tallyList.add(builderResult.count(10.0d).id("42").index(1).build());

    ImmutableOrderedTally.Builder<String> builderResult2 = ImmutableOrderedTally.builder();
    tallyList.add(builderResult2.count(10.0d).id("42").index(1).build());
    when(softwarePackageDao.toTallies(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Field<String>>any()))
        .thenReturn(tallyList);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    SoftwareSummaryStatistics actualCalculateStatisticsForAppIdSelectorResult =
        softwareCatalogService.calculateStatisticsForAppIdSelector(options);

    // Assert
    verify(softwarePackageDao, atLeast(1))
        .toTallies(isA(Select.class), Mockito.<Field<String>>any());
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    assertTrue(
        actualCalculateStatisticsForAppIdSelectorResult
            instanceof ImmutableSoftwareSummaryStatistics);
    List<Tally<String>> groupCountsResult =
        actualCalculateStatisticsForAppIdSelectorResult.groupCounts();
    assertEquals(2, groupCountsResult.size());
    Tally<String> getResult = groupCountsResult.get(1);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    List<Tally<String>> nameCountsResult =
        actualCalculateStatisticsForAppIdSelectorResult.nameCounts();
    assertEquals(2, nameCountsResult.size());
    List<Tally<String>> vendorCountsResult =
        actualCalculateStatisticsForAppIdSelectorResult.vendorCounts();
    assertEquals(2, vendorCountsResult.size());
    assertEquals(groupCountsResult.get(0), getResult);
    assertSame(getResult, nameCountsResult.get(1));
    assertSame(getResult, vendorCountsResult.get(1));
  }

  /**
   * Test {@link SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return nameCounts size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test calculateStatisticsForAppIdSelector(IdSelectionOptions); then return nameCounts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SoftwareSummaryStatistics SoftwareCatalogService.calculateStatisticsForAppIdSelector(IdSelectionOptions)"
  })
  void testCalculateStatisticsForAppIdSelector_thenReturnNameCountsSizeIsOne() {
    // Arrange
    ArrayList<Tally<String>> tallyList = new ArrayList<>();

    ImmutableOrderedTally.Builder<String> builderResult = ImmutableOrderedTally.builder();
    tallyList.add(builderResult.count(10.0d).id("42").index(1).build());
    when(softwarePackageDao.toTallies(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Field<String>>any()))
        .thenReturn(tallyList);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    SoftwareSummaryStatistics actualCalculateStatisticsForAppIdSelectorResult =
        softwareCatalogService.calculateStatisticsForAppIdSelector(options);

    // Assert
    verify(softwarePackageDao, atLeast(1))
        .toTallies(isA(Select.class), Mockito.<Field<String>>any());
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    assertTrue(
        actualCalculateStatisticsForAppIdSelectorResult
            instanceof ImmutableSoftwareSummaryStatistics);
    assertEquals(1, actualCalculateStatisticsForAppIdSelectorResult.nameCounts().size());
    assertEquals(1, actualCalculateStatisticsForAppIdSelectorResult.vendorCounts().size());
    assertEquals(tallyList, actualCalculateStatisticsForAppIdSelectorResult.groupCounts());
  }

  /**
   * Test {@link SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test calculateStatisticsForAppIdSelector(IdSelectionOptions); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SoftwareSummaryStatistics SoftwareCatalogService.calculateStatisticsForAppIdSelector(IdSelectionOptions)"
  })
  void testCalculateStatisticsForAppIdSelector_thenThrowUnsupportedOperationException() {
    // Arrange
    when(softwarePackageDao.toTallies(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Field<String>>any()))
        .thenThrow(new UnsupportedOperationException());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> softwareCatalogService.calculateStatisticsForAppIdSelector(options));
    verify(softwarePackageDao).toTallies(isA(Select.class), isA(Field.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
  }

  /**
   * Test {@link SoftwareCatalogService#getByPackageId(long)}.
   *
   * <p>Method under test: {@link SoftwareCatalogService#getByPackageId(long)}
   */
  @Test
  @DisplayName("Test getByPackageId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.getByPackageId(long)"})
  void testGetByPackageId() {
    // Arrange
    when(softwarePackageDao.getById(anyLong())).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> softwareCatalogService.getByPackageId(1L));
    verify(softwarePackageDao).getById(1L);
  }

  /**
   * Test {@link SoftwareCatalogService#getByPackageId(long)}.
   *
   * <p>Method under test: {@link SoftwareCatalogService#getByPackageId(long)}
   */
  @Test
  @DisplayName("Test getByPackageId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.getByPackageId(long)"})
  void testGetByPackageId2() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    when(softwarePackageDao.getById(anyLong()))
        .thenReturn(
            builderResult
                .created(created)
                .description("The characteristics of someone or something")
                .externalId("42")
                .group("Group")
                .id(1L)
                .isNotable(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .vendor("Vendor")
                .build());
    when(softwareUsageDao.findBySoftwarePackageIds((Long[]) Mockito.any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> softwareCatalogService.getByPackageId(1L));
    verify(softwarePackageDao).getById(1L);
    verify(softwareUsageDao).findBySoftwarePackageIds((Long[]) Mockito.any());
  }

  /**
   * Test {@link SoftwareCatalogService#getByPackageId(long)}.
   *
   * <p>Method under test: {@link SoftwareCatalogService#getByPackageId(long)}
   */
  @Test
  @DisplayName("Test getByPackageId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.getByPackageId(long)"})
  void testGetByPackageId3() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    when(softwarePackageDao.getById(anyLong()))
        .thenReturn(
            builderResult
                .created(created)
                .description("The characteristics of someone or something")
                .externalId("42")
                .group("Group")
                .id(1L)
                .isNotable(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .vendor("Vendor")
                .build());
    when(softwareUsageDao.findBySoftwarePackageIds((Long[]) Mockito.any()))
        .thenReturn(new ArrayList<>());
    when(softwareVersionDao.findBySoftwarePackageId(anyLong()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> softwareCatalogService.getByPackageId(1L));
    verify(softwarePackageDao).getById(1L);
    verify(softwareUsageDao).findBySoftwarePackageIds((Long[]) Mockito.any());
    verify(softwareVersionDao).findBySoftwarePackageId(1L);
  }

  /**
   * Test {@link SoftwareCatalogService#getByPackageId(long)}.
   *
   * <ul>
   *   <li>Then return packages size is one.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#getByPackageId(long)}
   */
  @Test
  @DisplayName("Test getByPackageId(long); then return packages size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.getByPackageId(long)"})
  void testGetByPackageId_thenReturnPackagesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    when(softwarePackageDao.getById(anyLong()))
        .thenReturn(
            builderResult
                .created(created)
                .description("The characteristics of someone or something")
                .externalId("42")
                .group("Group")
                .id(1L)
                .isNotable(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .vendor("Vendor")
                .build());
    when(softwareUsageDao.findBySoftwarePackageIds((Long[]) Mockito.any()))
        .thenReturn(new ArrayList<>());
    when(softwareVersionDao.findBySoftwarePackageId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    SoftwareCatalog actualByPackageId = softwareCatalogService.getByPackageId(1L);

    // Assert
    verify(softwarePackageDao).getById(1L);
    verify(softwareUsageDao).findBySoftwarePackageIds((Long[]) Mockito.any());
    verify(softwareVersionDao).findBySoftwarePackageId(1L);
    assertTrue(actualByPackageId instanceof ImmutableSoftwareCatalog);
    List<SoftwarePackage> packagesResult = actualByPackageId.packages();
    assertEquals(1, packagesResult.size());
    SoftwarePackage getResult = packagesResult.get(0);
    assertTrue(getResult instanceof ImmutableSoftwarePackage);
    assertEquals("Group", getResult.group());
    assertEquals("Name", getResult.name());
    assertEquals("Provenance", getResult.provenance());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals("Vendor", getResult.vendor());
    assertEquals(EntityKind.ALL, getResult.kind());
    List<SoftwareUsage> usagesResult = actualByPackageId.usages();
    assertTrue(usagesResult.isEmpty());
    assertTrue(getResult.isNotable());
    assertSame(usagesResult, actualByPackageId.versions());
  }

  /**
   * Test {@link SoftwareCatalogService#getByPackageId(long)}.
   *
   * <ul>
   *   <li>Then return versions Empty.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#getByPackageId(long)}
   */
  @Test
  @DisplayName("Test getByPackageId(long); then return versions Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.getByPackageId(long)"})
  void testGetByPackageId_thenReturnVersionsEmpty() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    when(softwarePackageDao.getById(anyLong()))
        .thenReturn(
            builderResult
                .created(created)
                .description("The characteristics of someone or something")
                .externalId("42")
                .group("Group")
                .id(1L)
                .isNotable(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .vendor("Vendor")
                .build());

    ArrayList<SoftwareUsage> softwareUsageList = new ArrayList<>();
    softwareUsageList.add(
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build());
    when(softwareUsageDao.findBySoftwarePackageIds((Long[]) Mockito.any()))
        .thenReturn(softwareUsageList);
    when(softwareVersionDao.findBySoftwarePackageId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    SoftwareCatalog actualByPackageId = softwareCatalogService.getByPackageId(1L);

    // Assert
    verify(softwarePackageDao).getById(1L);
    verify(softwareUsageDao).findBySoftwarePackageIds((Long[]) Mockito.any());
    verify(softwareVersionDao).findBySoftwarePackageId(1L);
    assertTrue(actualByPackageId instanceof ImmutableSoftwareCatalog);
    assertTrue(actualByPackageId.versions().isEmpty());
    assertEquals(softwareUsageList, actualByPackageId.usages());
  }

  /**
   * Test {@link SoftwareCatalogService#getByPackageId(long)}.
   *
   * <ul>
   *   <li>Then return versions Empty.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#getByPackageId(long)}
   */
  @Test
  @DisplayName("Test getByPackageId(long); then return versions Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.getByPackageId(long)"})
  void testGetByPackageId_thenReturnVersionsEmpty2() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    when(softwarePackageDao.getById(anyLong()))
        .thenReturn(
            builderResult
                .created(created)
                .description("The characteristics of someone or something")
                .externalId("42")
                .group("Group")
                .id(1L)
                .isNotable(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .vendor("Vendor")
                .build());

    ArrayList<SoftwareUsage> softwareUsageList = new ArrayList<>();
    softwareUsageList.add(
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build());
    softwareUsageList.add(
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build());
    when(softwareUsageDao.findBySoftwarePackageIds((Long[]) Mockito.any()))
        .thenReturn(softwareUsageList);
    when(softwareVersionDao.findBySoftwarePackageId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    SoftwareCatalog actualByPackageId = softwareCatalogService.getByPackageId(1L);

    // Assert
    verify(softwarePackageDao).getById(1L);
    verify(softwareUsageDao).findBySoftwarePackageIds((Long[]) Mockito.any());
    verify(softwareVersionDao).findBySoftwarePackageId(1L);
    assertTrue(actualByPackageId instanceof ImmutableSoftwareCatalog);
    assertTrue(actualByPackageId.versions().isEmpty());
    assertEquals(softwareUsageList, actualByPackageId.usages());
  }

  /**
   * Test {@link SoftwareCatalogService#getByPackageId(long)}.
   *
   * <ul>
   *   <li>Then return versions is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#getByPackageId(long)}
   */
  @Test
  @DisplayName("Test getByPackageId(long); then return versions is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.getByPackageId(long)"})
  void testGetByPackageId_thenReturnVersionsIsArrayList() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    when(softwarePackageDao.getById(anyLong()))
        .thenReturn(
            builderResult
                .created(created)
                .description("The characteristics of someone or something")
                .externalId("42")
                .group("Group")
                .id(1L)
                .isNotable(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .vendor("Vendor")
                .build());
    when(softwareUsageDao.findBySoftwarePackageIds((Long[]) Mockito.any()))
        .thenReturn(new ArrayList<>());

    ArrayList<SoftwareVersion> softwareVersionList = new ArrayList<>();

    ImmutableSoftwareVersion.Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);
    softwareVersionList.add(
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build());
    when(softwareVersionDao.findBySoftwarePackageId(anyLong())).thenReturn(softwareVersionList);

    // Act
    SoftwareCatalog actualByPackageId = softwareCatalogService.getByPackageId(1L);

    // Assert
    verify(softwarePackageDao).getById(1L);
    verify(softwareUsageDao).findBySoftwarePackageIds((Long[]) Mockito.any());
    verify(softwareVersionDao).findBySoftwarePackageId(1L);
    assertTrue(actualByPackageId instanceof ImmutableSoftwareCatalog);
    assertEquals(softwareVersionList, actualByPackageId.versions());
  }

  /**
   * Test {@link SoftwareCatalogService#getByVersionId(long)}.
   *
   * <p>Method under test: {@link SoftwareCatalogService#getByVersionId(long)}
   */
  @Test
  @DisplayName("Test getByVersionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.getByVersionId(long)"})
  void testGetByVersionId() {
    // Arrange
    when(softwarePackageDao.getById(anyLong())).thenThrow(new UnsupportedOperationException());

    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    when(softwareVersionDao.getByVersionId(anyLong()))
        .thenReturn(
            builderResult
                .created(created)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .releaseDate(LocalDate.of(1970, 1, 1))
                .softwarePackageId(1L)
                .version("1.0.2")
                .build());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> softwareCatalogService.getByVersionId(1L));
    verify(softwarePackageDao).getById(1L);
    verify(softwareVersionDao).getByVersionId(1L);
  }

  /**
   * Test {@link SoftwareCatalogService#getByVersionId(long)}.
   *
   * <p>Method under test: {@link SoftwareCatalogService#getByVersionId(long)}
   */
  @Test
  @DisplayName("Test getByVersionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.getByVersionId(long)"})
  void testGetByVersionId2() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    when(softwarePackageDao.getById(anyLong()))
        .thenReturn(
            builderResult
                .created(created)
                .description("The characteristics of someone or something")
                .externalId("42")
                .group("Group")
                .id(1L)
                .isNotable(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .vendor("Vendor")
                .build());
    when(softwareUsageDao.findBySoftwareVersionId(anyLong()))
        .thenThrow(new UnsupportedOperationException());

    ImmutableSoftwareVersion.Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);
    when(softwareVersionDao.getByVersionId(anyLong()))
        .thenReturn(
            builderResult2
                .created(created2)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .releaseDate(LocalDate.of(1970, 1, 1))
                .softwarePackageId(1L)
                .version("1.0.2")
                .build());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> softwareCatalogService.getByVersionId(1L));
    verify(softwarePackageDao).getById(1L);
    verify(softwareUsageDao).findBySoftwareVersionId(1L);
    verify(softwareVersionDao).getByVersionId(1L);
  }

  /**
   * Test {@link SoftwareCatalogService#getByVersionId(long)}.
   *
   * <ul>
   *   <li>Given {@link SoftwarePackageDao}.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#getByVersionId(long)}
   */
  @Test
  @DisplayName("Test getByVersionId(long); given SoftwarePackageDao")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.getByVersionId(long)"})
  void testGetByVersionId_givenSoftwarePackageDao() {
    // Arrange
    when(softwareVersionDao.getByVersionId(anyLong()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> softwareCatalogService.getByVersionId(1L));
    verify(softwareVersionDao).getByVersionId(1L);
  }

  /**
   * Test {@link SoftwareCatalogService#getByVersionId(long)}.
   *
   * <ul>
   *   <li>Then return packages size is one.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#getByVersionId(long)}
   */
  @Test
  @DisplayName("Test getByVersionId(long); then return packages size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.getByVersionId(long)"})
  void testGetByVersionId_thenReturnPackagesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    when(softwarePackageDao.getById(anyLong()))
        .thenReturn(
            builderResult
                .created(created)
                .description("The characteristics of someone or something")
                .externalId("42")
                .group("Group")
                .id(1L)
                .isNotable(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .vendor("Vendor")
                .build());
    when(softwareUsageDao.findBySoftwareVersionId(anyLong())).thenReturn(new ArrayList<>());

    ImmutableSoftwareVersion.Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);
    when(softwareVersionDao.getByVersionId(anyLong()))
        .thenReturn(
            builderResult2
                .created(created2)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .releaseDate(LocalDate.of(1970, 1, 1))
                .softwarePackageId(1L)
                .version("1.0.2")
                .build());

    // Act
    SoftwareCatalog actualByVersionId = softwareCatalogService.getByVersionId(1L);

    // Assert
    verify(softwarePackageDao).getById(1L);
    verify(softwareUsageDao).findBySoftwareVersionId(1L);
    verify(softwareVersionDao).getByVersionId(1L);
    assertTrue(actualByVersionId instanceof ImmutableSoftwareCatalog);
    List<SoftwarePackage> packagesResult = actualByVersionId.packages();
    assertEquals(1, packagesResult.size());
    assertTrue(packagesResult.get(0) instanceof ImmutableSoftwarePackage);
    List<SoftwareVersion> versionsResult = actualByVersionId.versions();
    assertEquals(1, versionsResult.size());
    assertTrue(versionsResult.get(0) instanceof ImmutableSoftwareVersion);
    assertTrue(actualByVersionId.usages().isEmpty());
  }

  /**
   * Test {@link SoftwareCatalogService#getByVersionId(long)}.
   *
   * <ul>
   *   <li>Then return usages is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#getByVersionId(long)}
   */
  @Test
  @DisplayName("Test getByVersionId(long); then return usages is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.getByVersionId(long)"})
  void testGetByVersionId_thenReturnUsagesIsArrayList() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    when(softwarePackageDao.getById(anyLong()))
        .thenReturn(
            builderResult
                .created(created)
                .description("The characteristics of someone or something")
                .externalId("42")
                .group("Group")
                .id(1L)
                .isNotable(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .vendor("Vendor")
                .build());

    ArrayList<SoftwareUsage> softwareUsageList = new ArrayList<>();
    softwareUsageList.add(
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build());
    when(softwareUsageDao.findBySoftwareVersionId(anyLong())).thenReturn(softwareUsageList);

    ImmutableSoftwareVersion.Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);
    when(softwareVersionDao.getByVersionId(anyLong()))
        .thenReturn(
            builderResult2
                .created(created2)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .releaseDate(LocalDate.of(1970, 1, 1))
                .softwarePackageId(1L)
                .version("1.0.2")
                .build());

    // Act
    SoftwareCatalog actualByVersionId = softwareCatalogService.getByVersionId(1L);

    // Assert
    verify(softwarePackageDao).getById(1L);
    verify(softwareUsageDao).findBySoftwareVersionId(1L);
    verify(softwareVersionDao).getByVersionId(1L);
    assertTrue(actualByVersionId instanceof ImmutableSoftwareCatalog);
    assertEquals(softwareUsageList, actualByVersionId.usages());
  }

  /**
   * Test {@link SoftwareCatalogService#getByVersionId(long)}.
   *
   * <ul>
   *   <li>Then return usages is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#getByVersionId(long)}
   */
  @Test
  @DisplayName("Test getByVersionId(long); then return usages is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.getByVersionId(long)"})
  void testGetByVersionId_thenReturnUsagesIsArrayList2() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    when(softwarePackageDao.getById(anyLong()))
        .thenReturn(
            builderResult
                .created(created)
                .description("The characteristics of someone or something")
                .externalId("42")
                .group("Group")
                .id(1L)
                .isNotable(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .vendor("Vendor")
                .build());

    ArrayList<SoftwareUsage> softwareUsageList = new ArrayList<>();
    softwareUsageList.add(
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build());
    softwareUsageList.add(
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build());
    when(softwareUsageDao.findBySoftwareVersionId(anyLong())).thenReturn(softwareUsageList);

    ImmutableSoftwareVersion.Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);
    when(softwareVersionDao.getByVersionId(anyLong()))
        .thenReturn(
            builderResult2
                .created(created2)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .releaseDate(LocalDate.of(1970, 1, 1))
                .softwarePackageId(1L)
                .version("1.0.2")
                .build());

    // Act
    SoftwareCatalog actualByVersionId = softwareCatalogService.getByVersionId(1L);

    // Assert
    verify(softwarePackageDao).getById(1L);
    verify(softwareUsageDao).findBySoftwareVersionId(1L);
    verify(softwareVersionDao).getByVersionId(1L);
    assertTrue(actualByVersionId instanceof ImmutableSoftwareCatalog);
    assertEquals(softwareUsageList, actualByVersionId.usages());
  }

  /**
   * Test {@link SoftwareCatalogService#getByLicenceId(long)}.
   *
   * <p>Method under test: {@link SoftwareCatalogService#getByLicenceId(long)}
   */
  @Test
  @DisplayName("Test getByLicenceId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.getByLicenceId(long)"})
  void testGetByLicenceId() {
    // Arrange
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(softwareUsageDao.findByLicenceId(anyLong())).thenReturn(new ArrayList<>());
    when(softwareVersionDao.findByLicenceId(anyLong()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> softwareCatalogService.getByLicenceId(1L));
    verify(softwarePackageDao).findByIds(isA(Collection.class));
    verify(softwareUsageDao).findByLicenceId(1L);
    verify(softwareVersionDao).findByLicenceId(1L);
  }

  /**
   * Test {@link SoftwareCatalogService#getByLicenceId(long)}.
   *
   * <ul>
   *   <li>Given {@link SoftwarePackageDao}.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#getByLicenceId(long)}
   */
  @Test
  @DisplayName("Test getByLicenceId(long); given SoftwarePackageDao")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.getByLicenceId(long)"})
  void testGetByLicenceId_givenSoftwarePackageDao() {
    // Arrange
    when(softwareUsageDao.findByLicenceId(anyLong()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> softwareCatalogService.getByLicenceId(1L));
    verify(softwareUsageDao).findByLicenceId(1L);
  }

  /**
   * Test {@link SoftwareCatalogService#getByLicenceId(long)}.
   *
   * <ul>
   *   <li>Then return packages Empty.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#getByLicenceId(long)}
   */
  @Test
  @DisplayName("Test getByLicenceId(long); then return packages Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.getByLicenceId(long)"})
  void testGetByLicenceId_thenReturnPackagesEmpty() {
    // Arrange
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(softwareUsageDao.findByLicenceId(anyLong())).thenReturn(new ArrayList<>());
    when(softwareVersionDao.findByLicenceId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    SoftwareCatalog actualByLicenceId = softwareCatalogService.getByLicenceId(1L);

    // Assert
    verify(softwarePackageDao).findByIds(isA(Collection.class));
    verify(softwareUsageDao).findByLicenceId(1L);
    verify(softwareVersionDao).findByLicenceId(1L);
    assertTrue(actualByLicenceId instanceof ImmutableSoftwareCatalog);
    List<SoftwarePackage> packagesResult = actualByLicenceId.packages();
    assertTrue(packagesResult.isEmpty());
    assertSame(packagesResult, actualByLicenceId.usages());
    assertSame(packagesResult, actualByLicenceId.versions());
  }

  /**
   * Test {@link SoftwareCatalogService#getByLicenceId(long)}.
   *
   * <ul>
   *   <li>Then return usages Empty.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#getByLicenceId(long)}
   */
  @Test
  @DisplayName("Test getByLicenceId(long); then return usages Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.getByLicenceId(long)"})
  void testGetByLicenceId_thenReturnUsagesEmpty() {
    // Arrange
    ArrayList<SoftwarePackage> softwarePackageList = new ArrayList<>();

    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    softwarePackageList.add(
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build());
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(softwarePackageList);
    when(softwareUsageDao.findByLicenceId(anyLong())).thenReturn(new ArrayList<>());
    when(softwareVersionDao.findByLicenceId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    SoftwareCatalog actualByLicenceId = softwareCatalogService.getByLicenceId(1L);

    // Assert
    verify(softwarePackageDao).findByIds(isA(Collection.class));
    verify(softwareUsageDao).findByLicenceId(1L);
    verify(softwareVersionDao).findByLicenceId(1L);
    assertTrue(actualByLicenceId instanceof ImmutableSoftwareCatalog);
    List<SoftwareUsage> usagesResult = actualByLicenceId.usages();
    assertTrue(usagesResult.isEmpty());
    assertEquals(softwarePackageList, actualByLicenceId.packages());
    assertSame(usagesResult, actualByLicenceId.versions());
  }

  /**
   * Test {@link SoftwareCatalogService#getByLicenceId(long)}.
   *
   * <ul>
   *   <li>Then return usages Empty.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#getByLicenceId(long)}
   */
  @Test
  @DisplayName("Test getByLicenceId(long); then return usages Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.getByLicenceId(long)"})
  void testGetByLicenceId_thenReturnUsagesEmpty2() {
    // Arrange
    ArrayList<SoftwarePackage> softwarePackageList = new ArrayList<>();

    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    softwarePackageList.add(
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build());

    Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);
    softwarePackageList.add(
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build());
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(softwarePackageList);
    when(softwareUsageDao.findByLicenceId(anyLong())).thenReturn(new ArrayList<>());
    when(softwareVersionDao.findByLicenceId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    SoftwareCatalog actualByLicenceId = softwareCatalogService.getByLicenceId(1L);

    // Assert
    verify(softwarePackageDao).findByIds(isA(Collection.class));
    verify(softwareUsageDao).findByLicenceId(1L);
    verify(softwareVersionDao).findByLicenceId(1L);
    assertTrue(actualByLicenceId instanceof ImmutableSoftwareCatalog);
    List<SoftwareUsage> usagesResult = actualByLicenceId.usages();
    assertTrue(usagesResult.isEmpty());
    assertEquals(softwarePackageList, actualByLicenceId.packages());
    assertSame(usagesResult, actualByLicenceId.versions());
  }

  /**
   * Test {@link SoftwareCatalogService#getByLicenceId(long)}.
   *
   * <ul>
   *   <li>Then return usages is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#getByLicenceId(long)}
   */
  @Test
  @DisplayName("Test getByLicenceId(long); then return usages is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.getByLicenceId(long)"})
  void testGetByLicenceId_thenReturnUsagesIsArrayList() {
    // Arrange
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<SoftwareUsage> softwareUsageList = new ArrayList<>();
    softwareUsageList.add(
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build());
    when(softwareUsageDao.findByLicenceId(anyLong())).thenReturn(softwareUsageList);
    when(softwareVersionDao.findByLicenceId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    SoftwareCatalog actualByLicenceId = softwareCatalogService.getByLicenceId(1L);

    // Assert
    verify(softwarePackageDao).findByIds(isA(Collection.class));
    verify(softwareUsageDao).findByLicenceId(1L);
    verify(softwareVersionDao).findByLicenceId(1L);
    assertTrue(actualByLicenceId instanceof ImmutableSoftwareCatalog);
    assertEquals(softwareUsageList, actualByLicenceId.usages());
  }

  /**
   * Test {@link SoftwareCatalogService#getByLicenceId(long)}.
   *
   * <ul>
   *   <li>Then return usages is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#getByLicenceId(long)}
   */
  @Test
  @DisplayName("Test getByLicenceId(long); then return usages is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.getByLicenceId(long)"})
  void testGetByLicenceId_thenReturnUsagesIsArrayList2() {
    // Arrange
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<SoftwareUsage> softwareUsageList = new ArrayList<>();
    softwareUsageList.add(
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build());
    softwareUsageList.add(
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build());
    when(softwareUsageDao.findByLicenceId(anyLong())).thenReturn(softwareUsageList);
    when(softwareVersionDao.findByLicenceId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    SoftwareCatalog actualByLicenceId = softwareCatalogService.getByLicenceId(1L);

    // Assert
    verify(softwarePackageDao).findByIds(isA(Collection.class));
    verify(softwareUsageDao).findByLicenceId(1L);
    verify(softwareVersionDao).findByLicenceId(1L);
    assertTrue(actualByLicenceId instanceof ImmutableSoftwareCatalog);
    assertEquals(softwareUsageList, actualByLicenceId.usages());
  }

  /**
   * Test {@link SoftwareCatalogService#getByLicenceId(long)}.
   *
   * <ul>
   *   <li>Then return versions is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#getByLicenceId(long)}
   */
  @Test
  @DisplayName("Test getByLicenceId(long); then return versions is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.getByLicenceId(long)"})
  void testGetByLicenceId_thenReturnVersionsIsArrayList() {
    // Arrange
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(softwareUsageDao.findByLicenceId(anyLong())).thenReturn(new ArrayList<>());

    ArrayList<SoftwareVersion> softwareVersionList = new ArrayList<>();

    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    softwareVersionList.add(
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build());
    when(softwareVersionDao.findByLicenceId(anyLong())).thenReturn(softwareVersionList);

    // Act
    SoftwareCatalog actualByLicenceId = softwareCatalogService.getByLicenceId(1L);

    // Assert
    verify(softwarePackageDao).findByIds(isA(Collection.class));
    verify(softwareUsageDao).findByLicenceId(1L);
    verify(softwareVersionDao).findByLicenceId(1L);
    assertTrue(actualByLicenceId instanceof ImmutableSoftwareCatalog);
    assertEquals(softwareVersionList, actualByLicenceId.versions());
  }

  /**
   * Test {@link SoftwareCatalogService#getBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link SoftwareCatalogService#getBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.getBySelector(IdSelectionOptions)"})
  void testGetBySelector() {
    // Arrange
    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            softwareCatalogService.getBySelector(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
  }

  /**
   * Test {@link SoftwareCatalogService#getBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link SoftwareCatalogService#getBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.getBySelector(IdSelectionOptions)"})
  void testGetBySelector2() {
    // Arrange
    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.empty();

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            softwareCatalogService.getBySelector(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
  }

  /**
   * Test {@link SoftwareCatalogService#getBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link SoftwareCatalogService#getBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareCatalog SoftwareCatalogService.getBySelector(IdSelectionOptions)"})
  void testGetBySelector3() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Builder builderResult =
        ImmutableApplicationIdSelectionOptions.builder();

    ImmutableApplicationIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableApplicationIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            softwareCatalogService.getBySelector(
                joiningEntityKindResult
                    .addAllApplicationKinds(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
  }

  /**
   * Test {@link SoftwareCatalogService#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given {@link SoftwarePackageDao} {@link SoftwarePackageDao#search(EntitySearchOptions)}
   *       return {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given SoftwarePackageDao search(EntitySearchOptions) return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SoftwareCatalogService.search(EntitySearchOptions)"})
  void testSearch_givenSoftwarePackageDaoSearchReturnArrayList_thenReturnEmpty() {
    // Arrange
    when(softwarePackageDao.search(Mockito.<EntitySearchOptions>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<SoftwarePackage> actualSearchResult = softwareCatalogService.search(null);

    // Assert
    verify(softwarePackageDao).search(isNull());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link SoftwareCatalogService#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareCatalogService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SoftwareCatalogService.search(EntitySearchOptions)"})
  void testSearch_thenThrowUnsupportedOperationException() {
    // Arrange
    when(softwarePackageDao.search(Mockito.<EntitySearchOptions>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> softwareCatalogService.search(null));
    verify(softwarePackageDao).search(isNull());
  }
}
