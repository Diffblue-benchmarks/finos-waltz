package org.finos.waltz.service.software_catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.data.software_catalog.SoftwarePackageDao;
import org.finos.waltz.data.software_catalog.SoftwareUsageDao;
import org.finos.waltz.data.software_catalog.SoftwareVersionDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.software_catalog.ImmutableSoftwareCatalog;
import org.finos.waltz.model.software_catalog.ImmutableSoftwareSummaryStatistics;
import org.finos.waltz.model.software_catalog.SoftwareCatalog;
import org.finos.waltz.model.software_catalog.SoftwarePackage;
import org.finos.waltz.model.software_catalog.SoftwareSummaryStatistics;
import org.finos.waltz.model.software_catalog.SoftwareUsage;
import org.finos.waltz.model.software_catalog.SoftwareVersion;
import org.finos.waltz.model.tally.Tally;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SoftwareCatalogServiceDiffblueTest {
  /**
   * Method under test: {@link SoftwareCatalogService#makeCatalogForAppIds(List)}
   */
  @Test
  void testMakeCatalogForAppIds() {
    // Arrange
    SoftwarePackageDao softwarePackageDao = mock(SoftwarePackageDao.class);
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    SoftwareUsageDao softwareUsageDao = mock(SoftwareUsageDao.class);
    when(softwareUsageDao.findByAppIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());
    SoftwareVersionDao softwareVersionDao = mock(SoftwareVersionDao.class);
    when(softwareVersionDao.findBySoftwarePackageIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    SoftwareCatalogService softwareCatalogService = new SoftwareCatalogService(softwarePackageDao, softwareUsageDao,
        softwareVersionDao);

    // Act
    SoftwareCatalog actualMakeCatalogForAppIdsResult = softwareCatalogService.makeCatalogForAppIds(new ArrayList<>());

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
   * Method under test: {@link SoftwareCatalogService#makeCatalogForAppIds(List)}
   */
  @Test
  void testMakeCatalogForAppIds2() {
    // Arrange
    SoftwarePackageDao softwarePackageDao = mock(SoftwarePackageDao.class);
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    SoftwareUsageDao softwareUsageDao = mock(SoftwareUsageDao.class);
    when(softwareUsageDao.findByAppIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());
    SoftwareVersionDao softwareVersionDao = mock(SoftwareVersionDao.class);
    when(softwareVersionDao.findBySoftwarePackageIds(Mockito.<Collection<Long>>any()))
        .thenThrow(new UnsupportedOperationException("foo"));
    SoftwareCatalogService softwareCatalogService = new SoftwareCatalogService(softwarePackageDao, softwareUsageDao,
        softwareVersionDao);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> softwareCatalogService.makeCatalogForAppIds(new ArrayList<>()));
    verify(softwarePackageDao).findByIds(isA(Collection.class));
    verify(softwareUsageDao).findByAppIds(isA(List.class));
    verify(softwareVersionDao).findBySoftwarePackageIds(isA(Collection.class));
  }

  /**
   * Method under test: {@link SoftwareCatalogService#makeCatalogForAppIds(List)}
   */
  @Test
  void testMakeCatalogForAppIds3() {
    // Arrange
    ArrayList<SoftwarePackage> softwarePackageList = new ArrayList<>();
    softwarePackageList.add(mock(SoftwarePackage.class));
    SoftwarePackageDao softwarePackageDao = mock(SoftwarePackageDao.class);
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(softwarePackageList);
    SoftwareUsageDao softwareUsageDao = mock(SoftwareUsageDao.class);
    when(softwareUsageDao.findByAppIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());
    SoftwareVersionDao softwareVersionDao = mock(SoftwareVersionDao.class);
    when(softwareVersionDao.findBySoftwarePackageIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    SoftwareCatalogService softwareCatalogService = new SoftwareCatalogService(softwarePackageDao, softwareUsageDao,
        softwareVersionDao);

    // Act
    SoftwareCatalog actualMakeCatalogForAppIdsResult = softwareCatalogService.makeCatalogForAppIds(new ArrayList<>());

    // Assert
    verify(softwarePackageDao).findByIds(isA(Collection.class));
    verify(softwareUsageDao).findByAppIds(isA(List.class));
    verify(softwareVersionDao).findBySoftwarePackageIds(isA(Collection.class));
    assertTrue(actualMakeCatalogForAppIdsResult instanceof ImmutableSoftwareCatalog);
    assertEquals(1, actualMakeCatalogForAppIdsResult.packages().size());
    List<SoftwareUsage> usagesResult = actualMakeCatalogForAppIdsResult.usages();
    assertTrue(usagesResult.isEmpty());
    assertSame(usagesResult, actualMakeCatalogForAppIdsResult.versions());
  }

  /**
   * Method under test: {@link SoftwareCatalogService#makeCatalogForAppIds(List)}
   */
  @Test
  void testMakeCatalogForAppIds4() {
    // Arrange
    ArrayList<SoftwarePackage> softwarePackageList = new ArrayList<>();
    softwarePackageList.add(mock(SoftwarePackage.class));
    softwarePackageList.add(mock(SoftwarePackage.class));
    SoftwarePackageDao softwarePackageDao = mock(SoftwarePackageDao.class);
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(softwarePackageList);
    SoftwareUsageDao softwareUsageDao = mock(SoftwareUsageDao.class);
    when(softwareUsageDao.findByAppIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());
    SoftwareVersionDao softwareVersionDao = mock(SoftwareVersionDao.class);
    when(softwareVersionDao.findBySoftwarePackageIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    SoftwareCatalogService softwareCatalogService = new SoftwareCatalogService(softwarePackageDao, softwareUsageDao,
        softwareVersionDao);

    // Act
    SoftwareCatalog actualMakeCatalogForAppIdsResult = softwareCatalogService.makeCatalogForAppIds(new ArrayList<>());

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
   * Method under test: {@link SoftwareCatalogService#makeCatalogForAppIds(List)}
   */
  @Test
  void testMakeCatalogForAppIds5() {
    // Arrange
    SoftwarePackageDao softwarePackageDao = mock(SoftwarePackageDao.class);
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    SoftwareUsage softwareUsage = mock(SoftwareUsage.class);
    when(softwareUsage.softwarePackageId()).thenReturn(1L);

    ArrayList<SoftwareUsage> softwareUsageList = new ArrayList<>();
    softwareUsageList.add(softwareUsage);
    SoftwareUsageDao softwareUsageDao = mock(SoftwareUsageDao.class);
    when(softwareUsageDao.findByAppIds(Mockito.<List<Long>>any())).thenReturn(softwareUsageList);
    SoftwareVersionDao softwareVersionDao = mock(SoftwareVersionDao.class);
    when(softwareVersionDao.findBySoftwarePackageIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    SoftwareCatalogService softwareCatalogService = new SoftwareCatalogService(softwarePackageDao, softwareUsageDao,
        softwareVersionDao);

    // Act
    SoftwareCatalog actualMakeCatalogForAppIdsResult = softwareCatalogService.makeCatalogForAppIds(new ArrayList<>());

    // Assert
    verify(softwarePackageDao).findByIds(isA(Collection.class));
    verify(softwareUsageDao).findByAppIds(isA(List.class));
    verify(softwareVersionDao).findBySoftwarePackageIds(isA(Collection.class));
    verify(softwareUsage).softwarePackageId();
    assertTrue(actualMakeCatalogForAppIdsResult instanceof ImmutableSoftwareCatalog);
    assertEquals(1, actualMakeCatalogForAppIdsResult.usages().size());
    List<SoftwarePackage> packagesResult = actualMakeCatalogForAppIdsResult.packages();
    assertTrue(packagesResult.isEmpty());
    assertSame(packagesResult, actualMakeCatalogForAppIdsResult.versions());
  }

  /**
   * Method under test:
   * {@link SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  void testCalculateStatisticsForAppIdSelector() {
    // Arrange
    SoftwarePackageDao softwarePackageDao = mock(SoftwarePackageDao.class);
    when(softwarePackageDao.toTallies(Mockito.<Select<Record1<Long>>>any(), Mockito.<Field<String>>any()))
        .thenReturn(new ArrayList<>());
    SoftwareCatalogService softwareCatalogService = new SoftwareCatalogService(softwarePackageDao,
        mock(SoftwareUsageDao.class), mock(SoftwareVersionDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    SoftwareSummaryStatistics actualCalculateStatisticsForAppIdSelectorResult = softwareCatalogService
        .calculateStatisticsForAppIdSelector(options);

    // Assert
    verify(softwarePackageDao, atLeast(1)).toTallies(isA(Select.class), Mockito.<Field<String>>any());
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualCalculateStatisticsForAppIdSelectorResult instanceof ImmutableSoftwareSummaryStatistics);
    List<Tally<String>> groupCountsResult = actualCalculateStatisticsForAppIdSelectorResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, actualCalculateStatisticsForAppIdSelectorResult.nameCounts());
    assertSame(groupCountsResult, actualCalculateStatisticsForAppIdSelectorResult.vendorCounts());
  }

  /**
   * Method under test:
   * {@link SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  void testCalculateStatisticsForAppIdSelector2() {
    // Arrange
    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    SoftwarePackageDao softwarePackageDao = mock(SoftwarePackageDao.class);
    when(softwarePackageDao.toTallies(Mockito.<Select<Record1<Long>>>any(), Mockito.<Field<String>>any()))
        .thenReturn(tallyList);
    SoftwareCatalogService softwareCatalogService = new SoftwareCatalogService(softwarePackageDao,
        mock(SoftwareUsageDao.class), mock(SoftwareVersionDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    SoftwareSummaryStatistics actualCalculateStatisticsForAppIdSelectorResult = softwareCatalogService
        .calculateStatisticsForAppIdSelector(options);

    // Assert
    verify(softwarePackageDao, atLeast(1)).toTallies(isA(Select.class), Mockito.<Field<String>>any());
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualCalculateStatisticsForAppIdSelectorResult instanceof ImmutableSoftwareSummaryStatistics);
    assertEquals(1, actualCalculateStatisticsForAppIdSelectorResult.groupCounts().size());
    assertEquals(1, actualCalculateStatisticsForAppIdSelectorResult.nameCounts().size());
    assertEquals(1, actualCalculateStatisticsForAppIdSelectorResult.vendorCounts().size());
  }

  /**
   * Method under test:
   * {@link SoftwareCatalogService#calculateStatisticsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  void testCalculateStatisticsForAppIdSelector3() {
    // Arrange
    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    tallyList.add(mock(Tally.class));
    SoftwarePackageDao softwarePackageDao = mock(SoftwarePackageDao.class);
    when(softwarePackageDao.toTallies(Mockito.<Select<Record1<Long>>>any(), Mockito.<Field<String>>any()))
        .thenReturn(tallyList);
    SoftwareCatalogService softwareCatalogService = new SoftwareCatalogService(softwarePackageDao,
        mock(SoftwareUsageDao.class), mock(SoftwareVersionDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    SoftwareSummaryStatistics actualCalculateStatisticsForAppIdSelectorResult = softwareCatalogService
        .calculateStatisticsForAppIdSelector(options);

    // Assert
    verify(softwarePackageDao, atLeast(1)).toTallies(isA(Select.class), Mockito.<Field<String>>any());
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualCalculateStatisticsForAppIdSelectorResult instanceof ImmutableSoftwareSummaryStatistics);
    assertEquals(tallyList, actualCalculateStatisticsForAppIdSelectorResult.groupCounts());
    assertEquals(tallyList, actualCalculateStatisticsForAppIdSelectorResult.nameCounts());
    assertEquals(tallyList, actualCalculateStatisticsForAppIdSelectorResult.vendorCounts());
  }

  /**
   * Method under test: {@link SoftwareCatalogService#getByPackageId(long)}
   */
  @Test
  void testGetByPackageId() {
    // Arrange
    SoftwarePackageDao softwarePackageDao = mock(SoftwarePackageDao.class);
    when(softwarePackageDao.getById(anyLong())).thenReturn(null);
    SoftwareUsageDao softwareUsageDao = mock(SoftwareUsageDao.class);
    when(softwareUsageDao.findBySoftwarePackageIds((Long[]) any())).thenReturn(new ArrayList<>());
    SoftwareVersionDao softwareVersionDao = mock(SoftwareVersionDao.class);
    when(softwareVersionDao.findBySoftwarePackageId(anyLong()))
        .thenThrow(new UnsupportedOperationException("packages element"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new SoftwareCatalogService(softwarePackageDao, softwareUsageDao, softwareVersionDao))
            .getByPackageId(1L));
    verify(softwarePackageDao).getById(eq(1L));
    verify(softwareUsageDao).findBySoftwarePackageIds((Long[]) any());
    verify(softwareVersionDao).findBySoftwarePackageId(eq(1L));
  }

  /**
   * Method under test: {@link SoftwareCatalogService#getByPackageId(long)}
   */
  @Test
  void testGetByPackageId2() {
    // Arrange
    SoftwarePackageDao softwarePackageDao = mock(SoftwarePackageDao.class);
    when(softwarePackageDao.getById(anyLong())).thenReturn(mock(SoftwarePackage.class));
    SoftwareUsageDao softwareUsageDao = mock(SoftwareUsageDao.class);
    when(softwareUsageDao.findBySoftwarePackageIds((Long[]) any())).thenReturn(new ArrayList<>());
    SoftwareVersionDao softwareVersionDao = mock(SoftwareVersionDao.class);
    when(softwareVersionDao.findBySoftwarePackageId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    SoftwareCatalog actualByPackageId = (new SoftwareCatalogService(softwarePackageDao, softwareUsageDao,
        softwareVersionDao)).getByPackageId(1L);

    // Assert
    verify(softwarePackageDao).getById(eq(1L));
    verify(softwareUsageDao).findBySoftwarePackageIds((Long[]) any());
    verify(softwareVersionDao).findBySoftwarePackageId(eq(1L));
    assertTrue(actualByPackageId instanceof ImmutableSoftwareCatalog);
    assertEquals(1, actualByPackageId.packages().size());
    List<SoftwareUsage> usagesResult = actualByPackageId.usages();
    assertTrue(usagesResult.isEmpty());
    assertSame(usagesResult, actualByPackageId.versions());
  }

  /**
   * Method under test: {@link SoftwareCatalogService#getByPackageId(long)}
   */
  @Test
  void testGetByPackageId3() {
    // Arrange
    SoftwarePackageDao softwarePackageDao = mock(SoftwarePackageDao.class);
    when(softwarePackageDao.getById(anyLong())).thenReturn(mock(SoftwarePackage.class));
    SoftwareUsageDao softwareUsageDao = mock(SoftwareUsageDao.class);
    when(softwareUsageDao.findBySoftwarePackageIds((Long[]) any())).thenReturn(new ArrayList<>());

    ArrayList<SoftwareVersion> softwareVersionList = new ArrayList<>();
    softwareVersionList.add(mock(SoftwareVersion.class));
    SoftwareVersionDao softwareVersionDao = mock(SoftwareVersionDao.class);
    when(softwareVersionDao.findBySoftwarePackageId(anyLong())).thenReturn(softwareVersionList);

    // Act
    SoftwareCatalog actualByPackageId = (new SoftwareCatalogService(softwarePackageDao, softwareUsageDao,
        softwareVersionDao)).getByPackageId(1L);

    // Assert
    verify(softwarePackageDao).getById(eq(1L));
    verify(softwareUsageDao).findBySoftwarePackageIds((Long[]) any());
    verify(softwareVersionDao).findBySoftwarePackageId(eq(1L));
    assertTrue(actualByPackageId instanceof ImmutableSoftwareCatalog);
    assertEquals(1, actualByPackageId.packages().size());
    assertEquals(1, actualByPackageId.versions().size());
    assertTrue(actualByPackageId.usages().isEmpty());
  }

  /**
   * Method under test: {@link SoftwareCatalogService#getByPackageId(long)}
   */
  @Test
  void testGetByPackageId4() {
    // Arrange
    SoftwarePackageDao softwarePackageDao = mock(SoftwarePackageDao.class);
    when(softwarePackageDao.getById(anyLong())).thenReturn(mock(SoftwarePackage.class));
    SoftwareUsageDao softwareUsageDao = mock(SoftwareUsageDao.class);
    when(softwareUsageDao.findBySoftwarePackageIds((Long[]) any())).thenReturn(new ArrayList<>());

    ArrayList<SoftwareVersion> softwareVersionList = new ArrayList<>();
    softwareVersionList.add(mock(SoftwareVersion.class));
    softwareVersionList.add(mock(SoftwareVersion.class));
    SoftwareVersionDao softwareVersionDao = mock(SoftwareVersionDao.class);
    when(softwareVersionDao.findBySoftwarePackageId(anyLong())).thenReturn(softwareVersionList);

    // Act
    SoftwareCatalog actualByPackageId = (new SoftwareCatalogService(softwarePackageDao, softwareUsageDao,
        softwareVersionDao)).getByPackageId(1L);

    // Assert
    verify(softwarePackageDao).getById(eq(1L));
    verify(softwareUsageDao).findBySoftwarePackageIds((Long[]) any());
    verify(softwareVersionDao).findBySoftwarePackageId(eq(1L));
    assertTrue(actualByPackageId instanceof ImmutableSoftwareCatalog);
    assertEquals(1, actualByPackageId.packages().size());
    assertTrue(actualByPackageId.usages().isEmpty());
    assertEquals(softwareVersionList, actualByPackageId.versions());
  }

  /**
   * Method under test: {@link SoftwareCatalogService#getByVersionId(long)}
   */
  @Test
  void testGetByVersionId() {
    // Arrange
    SoftwareVersionDao softwareVersionDao = mock(SoftwareVersionDao.class);
    when(softwareVersionDao.getByVersionId(anyLong())).thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new SoftwareCatalogService(mock(SoftwarePackageDao.class),
        mock(SoftwareUsageDao.class), softwareVersionDao)).getByVersionId(1L));
    verify(softwareVersionDao).getByVersionId(eq(1L));
  }

  /**
   * Method under test: {@link SoftwareCatalogService#getByVersionId(long)}
   */
  @Test
  void testGetByVersionId2() {
    // Arrange
    SoftwarePackageDao softwarePackageDao = mock(SoftwarePackageDao.class);
    when(softwarePackageDao.getById(anyLong())).thenReturn(mock(SoftwarePackage.class));
    SoftwareUsageDao softwareUsageDao = mock(SoftwareUsageDao.class);
    when(softwareUsageDao.findBySoftwareVersionId(anyLong())).thenReturn(new ArrayList<>());
    SoftwareVersion softwareVersion = mock(SoftwareVersion.class);
    when(softwareVersion.softwarePackageId()).thenReturn(1L);
    SoftwareVersionDao softwareVersionDao = mock(SoftwareVersionDao.class);
    when(softwareVersionDao.getByVersionId(anyLong())).thenReturn(softwareVersion);

    // Act
    SoftwareCatalog actualByVersionId = (new SoftwareCatalogService(softwarePackageDao, softwareUsageDao,
        softwareVersionDao)).getByVersionId(1L);

    // Assert
    verify(softwarePackageDao).getById(eq(1L));
    verify(softwareUsageDao).findBySoftwareVersionId(eq(1L));
    verify(softwareVersionDao).getByVersionId(eq(1L));
    verify(softwareVersion).softwarePackageId();
    assertTrue(actualByVersionId instanceof ImmutableSoftwareCatalog);
    assertEquals(1, actualByVersionId.packages().size());
    assertEquals(1, actualByVersionId.versions().size());
    assertTrue(actualByVersionId.usages().isEmpty());
  }

  /**
   * Method under test: {@link SoftwareCatalogService#getByVersionId(long)}
   */
  @Test
  void testGetByVersionId3() {
    // Arrange
    SoftwarePackageDao softwarePackageDao = mock(SoftwarePackageDao.class);
    when(softwarePackageDao.getById(anyLong())).thenReturn(mock(SoftwarePackage.class));

    ArrayList<SoftwareUsage> softwareUsageList = new ArrayList<>();
    softwareUsageList.add(mock(SoftwareUsage.class));
    softwareUsageList.add(mock(SoftwareUsage.class));
    SoftwareUsageDao softwareUsageDao = mock(SoftwareUsageDao.class);
    when(softwareUsageDao.findBySoftwareVersionId(anyLong())).thenReturn(softwareUsageList);
    SoftwareVersion softwareVersion = mock(SoftwareVersion.class);
    when(softwareVersion.softwarePackageId()).thenReturn(1L);
    SoftwareVersionDao softwareVersionDao = mock(SoftwareVersionDao.class);
    when(softwareVersionDao.getByVersionId(anyLong())).thenReturn(softwareVersion);

    // Act
    SoftwareCatalog actualByVersionId = (new SoftwareCatalogService(softwarePackageDao, softwareUsageDao,
        softwareVersionDao)).getByVersionId(1L);

    // Assert
    verify(softwarePackageDao).getById(eq(1L));
    verify(softwareUsageDao).findBySoftwareVersionId(eq(1L));
    verify(softwareVersionDao).getByVersionId(eq(1L));
    verify(softwareVersion).softwarePackageId();
    assertTrue(actualByVersionId instanceof ImmutableSoftwareCatalog);
    assertEquals(1, actualByVersionId.packages().size());
    assertEquals(1, actualByVersionId.versions().size());
    assertEquals(softwareUsageList, actualByVersionId.usages());
  }

  /**
   * Method under test: {@link SoftwareCatalogService#getByLicenceId(long)}
   */
  @Test
  void testGetByLicenceId() {
    // Arrange
    SoftwarePackageDao softwarePackageDao = mock(SoftwarePackageDao.class);
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    SoftwareUsageDao softwareUsageDao = mock(SoftwareUsageDao.class);
    when(softwareUsageDao.findByLicenceId(anyLong())).thenReturn(new ArrayList<>());
    SoftwareVersionDao softwareVersionDao = mock(SoftwareVersionDao.class);
    when(softwareVersionDao.findByLicenceId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    SoftwareCatalog actualByLicenceId = (new SoftwareCatalogService(softwarePackageDao, softwareUsageDao,
        softwareVersionDao)).getByLicenceId(1L);

    // Assert
    verify(softwarePackageDao).findByIds(isA(Collection.class));
    verify(softwareUsageDao).findByLicenceId(eq(1L));
    verify(softwareVersionDao).findByLicenceId(eq(1L));
    assertTrue(actualByLicenceId instanceof ImmutableSoftwareCatalog);
    List<SoftwarePackage> packagesResult = actualByLicenceId.packages();
    assertTrue(packagesResult.isEmpty());
    assertSame(packagesResult, actualByLicenceId.usages());
    assertSame(packagesResult, actualByLicenceId.versions());
  }

  /**
   * Method under test: {@link SoftwareCatalogService#getByLicenceId(long)}
   */
  @Test
  void testGetByLicenceId2() {
    // Arrange
    SoftwarePackageDao softwarePackageDao = mock(SoftwarePackageDao.class);
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    SoftwareUsageDao softwareUsageDao = mock(SoftwareUsageDao.class);
    when(softwareUsageDao.findByLicenceId(anyLong())).thenReturn(new ArrayList<>());
    SoftwareVersionDao softwareVersionDao = mock(SoftwareVersionDao.class);
    when(softwareVersionDao.findByLicenceId(anyLong())).thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new SoftwareCatalogService(softwarePackageDao, softwareUsageDao, softwareVersionDao))
            .getByLicenceId(1L));
    verify(softwarePackageDao).findByIds(isA(Collection.class));
    verify(softwareUsageDao).findByLicenceId(eq(1L));
    verify(softwareVersionDao).findByLicenceId(eq(1L));
  }

  /**
   * Method under test: {@link SoftwareCatalogService#getByLicenceId(long)}
   */
  @Test
  void testGetByLicenceId3() {
    // Arrange
    ArrayList<SoftwarePackage> softwarePackageList = new ArrayList<>();
    softwarePackageList.add(mock(SoftwarePackage.class));
    SoftwarePackageDao softwarePackageDao = mock(SoftwarePackageDao.class);
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(softwarePackageList);
    SoftwareUsageDao softwareUsageDao = mock(SoftwareUsageDao.class);
    when(softwareUsageDao.findByLicenceId(anyLong())).thenReturn(new ArrayList<>());
    SoftwareVersionDao softwareVersionDao = mock(SoftwareVersionDao.class);
    when(softwareVersionDao.findByLicenceId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    SoftwareCatalog actualByLicenceId = (new SoftwareCatalogService(softwarePackageDao, softwareUsageDao,
        softwareVersionDao)).getByLicenceId(1L);

    // Assert
    verify(softwarePackageDao).findByIds(isA(Collection.class));
    verify(softwareUsageDao).findByLicenceId(eq(1L));
    verify(softwareVersionDao).findByLicenceId(eq(1L));
    assertTrue(actualByLicenceId instanceof ImmutableSoftwareCatalog);
    assertEquals(1, actualByLicenceId.packages().size());
    List<SoftwareUsage> usagesResult = actualByLicenceId.usages();
    assertTrue(usagesResult.isEmpty());
    assertSame(usagesResult, actualByLicenceId.versions());
  }

  /**
   * Method under test: {@link SoftwareCatalogService#getByLicenceId(long)}
   */
  @Test
  void testGetByLicenceId4() {
    // Arrange
    ArrayList<SoftwarePackage> softwarePackageList = new ArrayList<>();
    softwarePackageList.add(mock(SoftwarePackage.class));
    softwarePackageList.add(mock(SoftwarePackage.class));
    SoftwarePackageDao softwarePackageDao = mock(SoftwarePackageDao.class);
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(softwarePackageList);
    SoftwareUsageDao softwareUsageDao = mock(SoftwareUsageDao.class);
    when(softwareUsageDao.findByLicenceId(anyLong())).thenReturn(new ArrayList<>());
    SoftwareVersionDao softwareVersionDao = mock(SoftwareVersionDao.class);
    when(softwareVersionDao.findByLicenceId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    SoftwareCatalog actualByLicenceId = (new SoftwareCatalogService(softwarePackageDao, softwareUsageDao,
        softwareVersionDao)).getByLicenceId(1L);

    // Assert
    verify(softwarePackageDao).findByIds(isA(Collection.class));
    verify(softwareUsageDao).findByLicenceId(eq(1L));
    verify(softwareVersionDao).findByLicenceId(eq(1L));
    assertTrue(actualByLicenceId instanceof ImmutableSoftwareCatalog);
    List<SoftwareUsage> usagesResult = actualByLicenceId.usages();
    assertTrue(usagesResult.isEmpty());
    assertEquals(softwarePackageList, actualByLicenceId.packages());
    assertSame(usagesResult, actualByLicenceId.versions());
  }

  /**
   * Method under test: {@link SoftwareCatalogService#getByLicenceId(long)}
   */
  @Test
  void testGetByLicenceId5() {
    // Arrange
    SoftwarePackageDao softwarePackageDao = mock(SoftwarePackageDao.class);
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    SoftwareUsage softwareUsage = mock(SoftwareUsage.class);
    when(softwareUsage.softwarePackageId()).thenReturn(1L);

    ArrayList<SoftwareUsage> softwareUsageList = new ArrayList<>();
    softwareUsageList.add(softwareUsage);
    SoftwareUsageDao softwareUsageDao = mock(SoftwareUsageDao.class);
    when(softwareUsageDao.findByLicenceId(anyLong())).thenReturn(softwareUsageList);
    SoftwareVersionDao softwareVersionDao = mock(SoftwareVersionDao.class);
    when(softwareVersionDao.findByLicenceId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    SoftwareCatalog actualByLicenceId = (new SoftwareCatalogService(softwarePackageDao, softwareUsageDao,
        softwareVersionDao)).getByLicenceId(1L);

    // Assert
    verify(softwarePackageDao).findByIds(isA(Collection.class));
    verify(softwareUsageDao).findByLicenceId(eq(1L));
    verify(softwareVersionDao).findByLicenceId(eq(1L));
    verify(softwareUsage).softwarePackageId();
    assertTrue(actualByLicenceId instanceof ImmutableSoftwareCatalog);
    assertEquals(1, actualByLicenceId.usages().size());
    List<SoftwarePackage> packagesResult = actualByLicenceId.packages();
    assertTrue(packagesResult.isEmpty());
    assertSame(packagesResult, actualByLicenceId.versions());
  }

  /**
   * Method under test: {@link SoftwareCatalogService#getByLicenceId(long)}
   */
  @Test
  void testGetByLicenceId6() {
    // Arrange
    SoftwarePackageDao softwarePackageDao = mock(SoftwarePackageDao.class);
    when(softwarePackageDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    SoftwareUsage softwareUsage = mock(SoftwareUsage.class);
    when(softwareUsage.softwarePackageId()).thenReturn(1L);
    SoftwareUsage softwareUsage2 = mock(SoftwareUsage.class);
    when(softwareUsage2.softwarePackageId()).thenReturn(1L);

    ArrayList<SoftwareUsage> softwareUsageList = new ArrayList<>();
    softwareUsageList.add(softwareUsage2);
    softwareUsageList.add(softwareUsage);
    SoftwareUsageDao softwareUsageDao = mock(SoftwareUsageDao.class);
    when(softwareUsageDao.findByLicenceId(anyLong())).thenReturn(softwareUsageList);
    SoftwareVersionDao softwareVersionDao = mock(SoftwareVersionDao.class);
    when(softwareVersionDao.findByLicenceId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    SoftwareCatalog actualByLicenceId = (new SoftwareCatalogService(softwarePackageDao, softwareUsageDao,
        softwareVersionDao)).getByLicenceId(1L);

    // Assert
    verify(softwarePackageDao).findByIds(isA(Collection.class));
    verify(softwareUsageDao).findByLicenceId(eq(1L));
    verify(softwareVersionDao).findByLicenceId(eq(1L));
    verify(softwareUsage2).softwarePackageId();
    verify(softwareUsage).softwarePackageId();
    assertTrue(actualByLicenceId instanceof ImmutableSoftwareCatalog);
    List<SoftwarePackage> packagesResult = actualByLicenceId.packages();
    assertTrue(packagesResult.isEmpty());
    assertEquals(softwareUsageList, actualByLicenceId.usages());
    assertSame(packagesResult, actualByLicenceId.versions());
  }

  /**
   * Method under test: {@link SoftwareCatalogService#getByLicenceId(long)}
   */
  @Test
  void testGetByLicenceId7() {
    // Arrange
    SoftwareUsage softwareUsage = mock(SoftwareUsage.class);
    when(softwareUsage.softwarePackageId()).thenReturn(1L);
    SoftwareUsage softwareUsage2 = mock(SoftwareUsage.class);
    when(softwareUsage2.softwarePackageId()).thenReturn(1L);
    SoftwareUsage softwareUsage3 = mock(SoftwareUsage.class);
    when(softwareUsage3.softwarePackageId()).thenThrow(new UnsupportedOperationException("usages element"));

    ArrayList<SoftwareUsage> softwareUsageList = new ArrayList<>();
    softwareUsageList.add(softwareUsage3);
    softwareUsageList.add(softwareUsage2);
    softwareUsageList.add(softwareUsage);
    SoftwareUsageDao softwareUsageDao = mock(SoftwareUsageDao.class);
    when(softwareUsageDao.findByLicenceId(anyLong())).thenReturn(softwareUsageList);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new SoftwareCatalogService(mock(SoftwarePackageDao.class),
        softwareUsageDao, mock(SoftwareVersionDao.class))).getByLicenceId(1L));
    verify(softwareUsageDao).findByLicenceId(eq(1L));
    verify(softwareUsage3).softwarePackageId();
  }

  /**
   * Method under test:
   * {@link SoftwareCatalogService#getBySelector(IdSelectionOptions)}
   */
  @Test
  void testGetBySelector() {
    // Arrange
    SoftwareCatalogService softwareCatalogService = new SoftwareCatalogService(mock(SoftwarePackageDao.class),
        mock(SoftwareUsageDao.class), mock(SoftwareVersionDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> softwareCatalogService.getBySelector(options));
    verify(entityReference).kind();
    verify(options).entityReference();
  }

  /**
   * Method under test: {@link SoftwareCatalogService#search(EntitySearchOptions)}
   */
  @Test
  void testSearch() {
    // Arrange
    SoftwarePackageDao softwarePackageDao = mock(SoftwarePackageDao.class);
    ArrayList<SoftwarePackage> softwarePackageList = new ArrayList<>();
    when(softwarePackageDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(softwarePackageList);

    // Act
    List<SoftwarePackage> actualSearchResult = (new SoftwareCatalogService(softwarePackageDao,
        mock(SoftwareUsageDao.class), mock(SoftwareVersionDao.class))).search(null);

    // Assert
    verify(softwarePackageDao).search(isNull());
    assertTrue(actualSearchResult.isEmpty());
    assertSame(softwarePackageList, actualSearchResult);
  }

  /**
   * Method under test: {@link SoftwareCatalogService#search(EntitySearchOptions)}
   */
  @Test
  void testSearch2() {
    // Arrange
    SoftwarePackageDao softwarePackageDao = mock(SoftwarePackageDao.class);
    when(softwarePackageDao.search(Mockito.<EntitySearchOptions>any()))
        .thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new SoftwareCatalogService(softwarePackageDao,
        mock(SoftwareUsageDao.class), mock(SoftwareVersionDao.class))).search(null));
    verify(softwarePackageDao).search(isNull());
  }
}
