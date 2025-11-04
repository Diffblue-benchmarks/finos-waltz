package org.finos.waltz.service.database_information;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.finos.waltz.data.database_information.DatabaseInformationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.database_information.DatabaseInformation;
import org.finos.waltz.model.database_information.DatabaseSummaryStatistics;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DatabaseInformationServiceDiffblueTest {
  /**
   * Method under test:
   * {@link DatabaseInformationService#findByApplicationId(Long)}
   */
  @Test
  void testFindByApplicationId() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    ArrayList<DatabaseInformation> databaseInformationList = new ArrayList<>();
    when(databaseInformationDao.findByApplicationId(anyLong())).thenReturn(databaseInformationList);

    // Act
    List<DatabaseInformation> actualFindByApplicationIdResult = (new DatabaseInformationService(databaseInformationDao))
        .findByApplicationId(1L);

    // Assert
    verify(databaseInformationDao).findByApplicationId(eq(1L));
    assertTrue(actualFindByApplicationIdResult.isEmpty());
    assertSame(databaseInformationList, actualFindByApplicationIdResult);
  }

  /**
   * Method under test:
   * {@link DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByApplicationSelector() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    HashMap<Long, List<DatabaseInformation>> resultLongListMap = new HashMap<>();
    when(databaseInformationDao.findByAppSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(resultLongListMap);
    DatabaseInformationService databaseInformationService = new DatabaseInformationService(databaseInformationDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    Map<Long, List<DatabaseInformation>> actualFindByApplicationSelectorResult = databaseInformationService
        .findByApplicationSelector(options);

    // Assert
    verify(databaseInformationDao).findByAppSelector(isA(Select.class));
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindByApplicationSelectorResult.isEmpty());
    assertSame(resultLongListMap, actualFindByApplicationSelectorResult);
  }

  /**
   * Method under test:
   * {@link DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByApplicationSelector2() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    HashMap<Long, List<DatabaseInformation>> resultLongListMap = new HashMap<>();
    when(databaseInformationDao.findByAppSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(resultLongListMap);
    DatabaseInformationService databaseInformationService = new DatabaseInformationService(databaseInformationDao);
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
    Map<Long, List<DatabaseInformation>> actualFindByApplicationSelectorResult = databaseInformationService
        .findByApplicationSelector(options);

    // Assert
    verify(databaseInformationDao).findByAppSelector(isA(Select.class));
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertTrue(actualFindByApplicationSelectorResult.isEmpty());
    assertSame(resultLongListMap, actualFindByApplicationSelectorResult);
  }

  /**
   * Method under test:
   * {@link DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByApplicationSelector3() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    HashMap<Long, List<DatabaseInformation>> resultLongListMap = new HashMap<>();
    when(databaseInformationDao.findByAppSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(resultLongListMap);
    DatabaseInformationService databaseInformationService = new DatabaseInformationService(databaseInformationDao);
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
    Map<Long, List<DatabaseInformation>> actualFindByApplicationSelectorResult = databaseInformationService
        .findByApplicationSelector(options);

    // Assert
    verify(databaseInformationDao).findByAppSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindByApplicationSelectorResult.isEmpty());
    assertSame(resultLongListMap, actualFindByApplicationSelectorResult);
  }

  /**
   * Method under test:
   * {@link DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByApplicationSelector4() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    HashMap<Long, List<DatabaseInformation>> resultLongListMap = new HashMap<>();
    when(databaseInformationDao.findByAppSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(resultLongListMap);
    DatabaseInformationService databaseInformationService = new DatabaseInformationService(databaseInformationDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    Map<Long, List<DatabaseInformation>> actualFindByApplicationSelectorResult = databaseInformationService
        .findByApplicationSelector(options);

    // Assert
    verify(databaseInformationDao).findByAppSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindByApplicationSelectorResult.isEmpty());
    assertSame(resultLongListMap, actualFindByApplicationSelectorResult);
  }

  /**
   * Method under test:
   * {@link DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByApplicationSelector5() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    HashMap<Long, List<DatabaseInformation>> resultLongListMap = new HashMap<>();
    when(databaseInformationDao.findByAppSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(resultLongListMap);
    DatabaseInformationService databaseInformationService = new DatabaseInformationService(databaseInformationDao);
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
    Map<Long, List<DatabaseInformation>> actualFindByApplicationSelectorResult = databaseInformationService
        .findByApplicationSelector(options);

    // Assert
    verify(databaseInformationDao).findByAppSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindByApplicationSelectorResult.isEmpty());
    assertSame(resultLongListMap, actualFindByApplicationSelectorResult);
  }

  /**
   * Method under test:
   * {@link DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByApplicationSelector6() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    HashMap<Long, List<DatabaseInformation>> resultLongListMap = new HashMap<>();
    when(databaseInformationDao.findByAppSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(resultLongListMap);
    DatabaseInformationService databaseInformationService = new DatabaseInformationService(databaseInformationDao);
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
    Map<Long, List<DatabaseInformation>> actualFindByApplicationSelectorResult = databaseInformationService
        .findByApplicationSelector(options);

    // Assert
    verify(databaseInformationDao).findByAppSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindByApplicationSelectorResult.isEmpty());
    assertSame(resultLongListMap, actualFindByApplicationSelectorResult);
  }

  /**
   * Method under test:
   * {@link DatabaseInformationService#calculateStatsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  void testCalculateStatsForAppIdSelector() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(null);
    DatabaseInformationService databaseInformationService = new DatabaseInformationService(databaseInformationDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    DatabaseSummaryStatistics actualCalculateStatsForAppIdSelectorResult = databaseInformationService
        .calculateStatsForAppIdSelector(options);

    // Assert
    verify(databaseInformationDao).calculateStatsForAppSelector(isA(Select.class));
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertNull(actualCalculateStatsForAppIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link DatabaseInformationService#calculateStatsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  void testCalculateStatsForAppIdSelector2() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(null);
    DatabaseInformationService databaseInformationService = new DatabaseInformationService(databaseInformationDao);
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
    DatabaseSummaryStatistics actualCalculateStatsForAppIdSelectorResult = databaseInformationService
        .calculateStatsForAppIdSelector(options);

    // Assert
    verify(databaseInformationDao).calculateStatsForAppSelector(isA(Select.class));
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertNull(actualCalculateStatsForAppIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link DatabaseInformationService#calculateStatsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  void testCalculateStatsForAppIdSelector3() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(null);
    DatabaseInformationService databaseInformationService = new DatabaseInformationService(databaseInformationDao);
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
    DatabaseSummaryStatistics actualCalculateStatsForAppIdSelectorResult = databaseInformationService
        .calculateStatsForAppIdSelector(options);

    // Assert
    verify(databaseInformationDao).calculateStatsForAppSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertNull(actualCalculateStatsForAppIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link DatabaseInformationService#calculateStatsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  void testCalculateStatsForAppIdSelector4() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(null);
    DatabaseInformationService databaseInformationService = new DatabaseInformationService(databaseInformationDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    DatabaseSummaryStatistics actualCalculateStatsForAppIdSelectorResult = databaseInformationService
        .calculateStatsForAppIdSelector(options);

    // Assert
    verify(databaseInformationDao).calculateStatsForAppSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertNull(actualCalculateStatsForAppIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link DatabaseInformationService#calculateStatsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  void testCalculateStatsForAppIdSelector5() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(null);
    DatabaseInformationService databaseInformationService = new DatabaseInformationService(databaseInformationDao);
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
    DatabaseSummaryStatistics actualCalculateStatsForAppIdSelectorResult = databaseInformationService
        .calculateStatsForAppIdSelector(options);

    // Assert
    verify(databaseInformationDao).calculateStatsForAppSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertNull(actualCalculateStatsForAppIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link DatabaseInformationService#calculateStatsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  void testCalculateStatsForAppIdSelector6() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(null);
    DatabaseInformationService databaseInformationService = new DatabaseInformationService(databaseInformationDao);
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
    DatabaseSummaryStatistics actualCalculateStatsForAppIdSelectorResult = databaseInformationService
        .calculateStatsForAppIdSelector(options);

    // Assert
    verify(databaseInformationDao).calculateStatsForAppSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertNull(actualCalculateStatsForAppIdSelectorResult);
  }

  /**
   * Method under test: {@link DatabaseInformationService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.getById(anyLong())).thenReturn(null);

    // Act
    DatabaseInformation actualById = (new DatabaseInformationService(databaseInformationDao)).getById(1L);

    // Assert
    verify(databaseInformationDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link DatabaseInformationService#getByExternalId(String)}
   */
  @Test
  void testGetByExternalId() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.getByExternalId(Mockito.<String>any())).thenReturn(null);

    // Act
    DatabaseInformation actualByExternalId = (new DatabaseInformationService(databaseInformationDao))
        .getByExternalId("42");

    // Assert
    verify(databaseInformationDao).getByExternalId(eq("42"));
    assertNull(actualByExternalId);
  }

  /**
   * Method under test:
   * {@link DatabaseInformationService#search(EntitySearchOptions)}
   */
  @Test
  void testSearch() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    ArrayList<DatabaseInformation> databaseInformationList = new ArrayList<>();
    when(databaseInformationDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(databaseInformationList);

    // Act
    List<DatabaseInformation> actualSearchResult = (new DatabaseInformationService(databaseInformationDao))
        .search(null);

    // Assert
    verify(databaseInformationDao).search(isNull());
    assertTrue(actualSearchResult.isEmpty());
    assertSame(databaseInformationList, actualSearchResult);
  }

  /**
   * Method under test:
   * {@link DatabaseInformationService#createDatabase(DatabaseInformation)}
   */
  @Test
  void testCreateDatabase() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.createDatabase(Mockito.<DatabaseInformation>any())).thenReturn(1L);

    // Act
    Long actualCreateDatabaseResult = (new DatabaseInformationService(databaseInformationDao)).createDatabase(null);

    // Assert
    verify(databaseInformationDao).createDatabase(isNull());
    assertEquals(1L, actualCreateDatabaseResult.longValue());
  }
}
