package org.finos.waltz.service.server_information;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.finos.waltz.data.server_information.ServerInformationDao;
import org.finos.waltz.data.server_information.search.ServerInformationSearchDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.server_information.ServerInformation;
import org.finos.waltz.model.server_information.ServerSummaryBasicStatistics;
import org.finos.waltz.model.server_information.ServerSummaryStatistics;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServerInformationServiceDiffblueTest {
  /**
   * Method under test: {@link ServerInformationService#findByAssetCode(String)}
   */
  @Test
  void testFindByAssetCode() {
    // Arrange
    ServerInformationDao serverInfoDao = mock(ServerInformationDao.class);
    ArrayList<ServerInformation> serverInformationList = new ArrayList<>();
    when(serverInfoDao.findByAssetCode(Mockito.<String>any())).thenReturn(serverInformationList);

    // Act
    List<ServerInformation> actualFindByAssetCodeResult = (new ServerInformationService(serverInfoDao,
        mock(ServerInformationSearchDao.class))).findByAssetCode("Asset Code");

    // Assert
    verify(serverInfoDao).findByAssetCode(eq("Asset Code"));
    assertTrue(actualFindByAssetCodeResult.isEmpty());
    assertSame(serverInformationList, actualFindByAssetCodeResult);
  }

  /**
   * Method under test: {@link ServerInformationService#findByAppId(long)}
   */
  @Test
  void testFindByAppId() {
    // Arrange
    ServerInformationDao serverInfoDao = mock(ServerInformationDao.class);
    ArrayList<ServerInformation> serverInformationList = new ArrayList<>();
    when(serverInfoDao.findByAppId(anyLong())).thenReturn(serverInformationList);

    // Act
    List<ServerInformation> actualFindByAppIdResult = (new ServerInformationService(serverInfoDao,
        mock(ServerInformationSearchDao.class))).findByAppId(1L);

    // Assert
    verify(serverInfoDao).findByAppId(eq(1L));
    assertTrue(actualFindByAppIdResult.isEmpty());
    assertSame(serverInformationList, actualFindByAppIdResult);
  }

  /**
   * Method under test: {@link ServerInformationService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    ServerInformationDao serverInfoDao = mock(ServerInformationDao.class);
    when(serverInfoDao.getById(anyLong())).thenReturn(null);

    // Act
    ServerInformation actualById = (new ServerInformationService(serverInfoDao, mock(ServerInformationSearchDao.class)))
        .getById(1L);

    // Assert
    verify(serverInfoDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link ServerInformationService#getByExternalId(String)}
   */
  @Test
  void testGetByExternalId() {
    // Arrange
    ServerInformationDao serverInfoDao = mock(ServerInformationDao.class);
    when(serverInfoDao.getByExternalId(Mockito.<String>any())).thenReturn(null);

    // Act
    ServerInformation actualByExternalId = (new ServerInformationService(serverInfoDao,
        mock(ServerInformationSearchDao.class))).getByExternalId("42");

    // Assert
    verify(serverInfoDao).getByExternalId(eq("42"));
    assertNull(actualByExternalId);
  }

  /**
   * Method under test: {@link ServerInformationService#getByHostname(String)}
   */
  @Test
  void testGetByHostname() {
    // Arrange
    ServerInformationDao serverInfoDao = mock(ServerInformationDao.class);
    when(serverInfoDao.getByHostname(Mockito.<String>any())).thenReturn(null);

    // Act
    ServerInformation actualByHostname = (new ServerInformationService(serverInfoDao,
        mock(ServerInformationSearchDao.class))).getByHostname("localhost");

    // Assert
    verify(serverInfoDao).getByHostname(eq("localhost"));
    assertNull(actualByHostname);
  }

  /**
   * Method under test:
   * {@link ServerInformationService#calculateStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  void testCalculateStatsForAppSelector() {
    // Arrange
    ServerInformationDao serverInfoDao = mock(ServerInformationDao.class);
    when(serverInfoDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(null);
    ServerInformationService serverInformationService = new ServerInformationService(serverInfoDao,
        mock(ServerInformationSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    ServerSummaryStatistics actualCalculateStatsForAppSelectorResult = serverInformationService
        .calculateStatsForAppSelector(options);

    // Assert
    verify(serverInfoDao).calculateStatsForAppSelector(isA(Select.class));
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertNull(actualCalculateStatsForAppSelectorResult);
  }

  /**
   * Method under test:
   * {@link ServerInformationService#calculateStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  void testCalculateStatsForAppSelector2() {
    // Arrange
    ServerInformationDao serverInfoDao = mock(ServerInformationDao.class);
    when(serverInfoDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(null);
    ServerInformationService serverInformationService = new ServerInformationService(serverInfoDao,
        mock(ServerInformationSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<ApplicationKind> applicationKindSet = new HashSet<>();
    applicationKindSet.add(ApplicationKind.IN_HOUSE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(applicationKindSet);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    ServerSummaryStatistics actualCalculateStatsForAppSelectorResult = serverInformationService
        .calculateStatsForAppSelector(options);

    // Assert
    verify(serverInfoDao).calculateStatsForAppSelector(isA(Select.class));
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertNull(actualCalculateStatsForAppSelectorResult);
  }

  /**
   * Method under test:
   * {@link ServerInformationService#calculateStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  void testCalculateStatsForAppSelector3() {
    // Arrange
    ServerInformationDao serverInfoDao = mock(ServerInformationDao.class);
    when(serverInfoDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(null);
    ServerInformationService serverInformationService = new ServerInformationService(serverInfoDao,
        mock(ServerInformationSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    ServerSummaryStatistics actualCalculateStatsForAppSelectorResult = serverInformationService
        .calculateStatsForAppSelector(options);

    // Assert
    verify(serverInfoDao).calculateStatsForAppSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertNull(actualCalculateStatsForAppSelectorResult);
  }

  /**
   * Method under test:
   * {@link ServerInformationService#calculateStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  void testCalculateStatsForAppSelector4() {
    // Arrange
    ServerInformationDao serverInfoDao = mock(ServerInformationDao.class);
    when(serverInfoDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(null);
    ServerInformationService serverInformationService = new ServerInformationService(serverInfoDao,
        mock(ServerInformationSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    ServerSummaryStatistics actualCalculateStatsForAppSelectorResult = serverInformationService
        .calculateStatsForAppSelector(options);

    // Assert
    verify(serverInfoDao).calculateStatsForAppSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertNull(actualCalculateStatsForAppSelectorResult);
  }

  /**
   * Method under test:
   * {@link ServerInformationService#calculateStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  void testCalculateStatsForAppSelector5() {
    // Arrange
    ServerInformationDao serverInfoDao = mock(ServerInformationDao.class);
    when(serverInfoDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(null);
    ServerInformationService serverInformationService = new ServerInformationService(serverInfoDao,
        mock(ServerInformationSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    ServerSummaryStatistics actualCalculateStatsForAppSelectorResult = serverInformationService
        .calculateStatsForAppSelector(options);

    // Assert
    verify(serverInfoDao).calculateStatsForAppSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertNull(actualCalculateStatsForAppSelectorResult);
  }

  /**
   * Method under test:
   * {@link ServerInformationService#calculateStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  void testCalculateStatsForAppSelector6() {
    // Arrange
    ServerInformationDao serverInfoDao = mock(ServerInformationDao.class);
    when(serverInfoDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(null);
    ServerInformationService serverInformationService = new ServerInformationService(serverInfoDao,
        mock(ServerInformationSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    ServerSummaryStatistics actualCalculateStatsForAppSelectorResult = serverInformationService
        .calculateStatsForAppSelector(options);

    // Assert
    verify(serverInfoDao).calculateStatsForAppSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertNull(actualCalculateStatsForAppSelectorResult);
  }

  /**
   * Method under test:
   * {@link ServerInformationService#calculateBasicStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  void testCalculateBasicStatsForAppSelector() {
    // Arrange
    ServerInformationDao serverInfoDao = mock(ServerInformationDao.class);
    when(serverInfoDao.calculateBasicStatsForAppSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(null);
    ServerInformationService serverInformationService = new ServerInformationService(serverInfoDao,
        mock(ServerInformationSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    ServerSummaryBasicStatistics actualCalculateBasicStatsForAppSelectorResult = serverInformationService
        .calculateBasicStatsForAppSelector(options);

    // Assert
    verify(serverInfoDao).calculateBasicStatsForAppSelector(isA(Select.class));
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertNull(actualCalculateBasicStatsForAppSelectorResult);
  }

  /**
   * Method under test:
   * {@link ServerInformationService#calculateBasicStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  void testCalculateBasicStatsForAppSelector2() {
    // Arrange
    ServerInformationDao serverInfoDao = mock(ServerInformationDao.class);
    when(serverInfoDao.calculateBasicStatsForAppSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(null);
    ServerInformationService serverInformationService = new ServerInformationService(serverInfoDao,
        mock(ServerInformationSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<ApplicationKind> applicationKindSet = new HashSet<>();
    applicationKindSet.add(ApplicationKind.IN_HOUSE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(applicationKindSet);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    ServerSummaryBasicStatistics actualCalculateBasicStatsForAppSelectorResult = serverInformationService
        .calculateBasicStatsForAppSelector(options);

    // Assert
    verify(serverInfoDao).calculateBasicStatsForAppSelector(isA(Select.class));
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertNull(actualCalculateBasicStatsForAppSelectorResult);
  }

  /**
   * Method under test:
   * {@link ServerInformationService#calculateBasicStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  void testCalculateBasicStatsForAppSelector3() {
    // Arrange
    ServerInformationDao serverInfoDao = mock(ServerInformationDao.class);
    when(serverInfoDao.calculateBasicStatsForAppSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(null);
    ServerInformationService serverInformationService = new ServerInformationService(serverInfoDao,
        mock(ServerInformationSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    ServerSummaryBasicStatistics actualCalculateBasicStatsForAppSelectorResult = serverInformationService
        .calculateBasicStatsForAppSelector(options);

    // Assert
    verify(serverInfoDao).calculateBasicStatsForAppSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertNull(actualCalculateBasicStatsForAppSelectorResult);
  }

  /**
   * Method under test:
   * {@link ServerInformationService#calculateBasicStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  void testCalculateBasicStatsForAppSelector4() {
    // Arrange
    ServerInformationDao serverInfoDao = mock(ServerInformationDao.class);
    when(serverInfoDao.calculateBasicStatsForAppSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(null);
    ServerInformationService serverInformationService = new ServerInformationService(serverInfoDao,
        mock(ServerInformationSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    ServerSummaryBasicStatistics actualCalculateBasicStatsForAppSelectorResult = serverInformationService
        .calculateBasicStatsForAppSelector(options);

    // Assert
    verify(serverInfoDao).calculateBasicStatsForAppSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertNull(actualCalculateBasicStatsForAppSelectorResult);
  }

  /**
   * Method under test:
   * {@link ServerInformationService#calculateBasicStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  void testCalculateBasicStatsForAppSelector5() {
    // Arrange
    ServerInformationDao serverInfoDao = mock(ServerInformationDao.class);
    when(serverInfoDao.calculateBasicStatsForAppSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(null);
    ServerInformationService serverInformationService = new ServerInformationService(serverInfoDao,
        mock(ServerInformationSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    ServerSummaryBasicStatistics actualCalculateBasicStatsForAppSelectorResult = serverInformationService
        .calculateBasicStatsForAppSelector(options);

    // Assert
    verify(serverInfoDao).calculateBasicStatsForAppSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertNull(actualCalculateBasicStatsForAppSelectorResult);
  }

  /**
   * Method under test:
   * {@link ServerInformationService#calculateBasicStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  void testCalculateBasicStatsForAppSelector6() {
    // Arrange
    ServerInformationDao serverInfoDao = mock(ServerInformationDao.class);
    when(serverInfoDao.calculateBasicStatsForAppSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(null);
    ServerInformationService serverInformationService = new ServerInformationService(serverInfoDao,
        mock(ServerInformationSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    ServerSummaryBasicStatistics actualCalculateBasicStatsForAppSelectorResult = serverInformationService
        .calculateBasicStatsForAppSelector(options);

    // Assert
    verify(serverInfoDao).calculateBasicStatsForAppSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertNull(actualCalculateBasicStatsForAppSelectorResult);
  }

  /**
   * Method under test: {@link ServerInformationService#search(String)}
   */
  @Test
  void testSearch() {
    // Arrange
    ServerInformationSearchDao serverInformationSearchDao = mock(ServerInformationSearchDao.class);
    ArrayList<ServerInformation> serverInformationList = new ArrayList<>();
    when(serverInformationSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(serverInformationList);

    // Act
    List<ServerInformation> actualSearchResult = (new ServerInformationService(mock(ServerInformationDao.class),
        serverInformationSearchDao)).search("Query");

    // Assert
    verify(serverInformationSearchDao).search(isA(EntitySearchOptions.class));
    assertTrue(actualSearchResult.isEmpty());
    assertSame(serverInformationList, actualSearchResult);
  }

  /**
   * Method under test: {@link ServerInformationService#search(String)}
   */
  @Test
  void testSearch2() {
    // Arrange, Act and Assert
    assertTrue((new ServerInformationService(mock(ServerInformationDao.class), mock(ServerInformationSearchDao.class)))
        .search("")
        .isEmpty());
  }

  /**
   * Method under test:
   * {@link ServerInformationService#search(EntitySearchOptions)}
   */
  @Test
  void testSearch3() {
    // Arrange
    ServerInformationSearchDao serverInformationSearchDao = mock(ServerInformationSearchDao.class);
    ArrayList<ServerInformation> serverInformationList = new ArrayList<>();
    when(serverInformationSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(serverInformationList);

    // Act
    List<ServerInformation> actualSearchResult = (new ServerInformationService(mock(ServerInformationDao.class),
        serverInformationSearchDao)).search((EntitySearchOptions) null);

    // Assert
    verify(serverInformationSearchDao).search(isNull());
    assertTrue(actualSearchResult.isEmpty());
    assertSame(serverInformationList, actualSearchResult);
  }
}
