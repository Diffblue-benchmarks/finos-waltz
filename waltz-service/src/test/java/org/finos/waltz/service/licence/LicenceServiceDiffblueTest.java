package org.finos.waltz.service.licence;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import org.finos.waltz.data.licence.LicenceDao;
import org.finos.waltz.data.licence.search.LicenceSearchDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.licence.Licence;
import org.finos.waltz.model.licence.SaveLicenceCommand;
import org.finos.waltz.model.tally.Tally;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LicenceServiceDiffblueTest {
  /**
   * Method under test: {@link LicenceService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    LicenceDao licenceDao = mock(LicenceDao.class);
    ArrayList<Licence> licenceList = new ArrayList<>();
    when(licenceDao.findAll()).thenReturn(licenceList);

    // Act
    List<Licence> actualFindAllResult = (new LicenceService(licenceDao, mock(LicenceSearchDao.class))).findAll();

    // Assert
    verify(licenceDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(licenceList, actualFindAllResult);
  }

  /**
   * Method under test: {@link LicenceService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    LicenceDao licenceDao = mock(LicenceDao.class);
    when(licenceDao.getById(anyLong())).thenReturn(null);

    // Act
    Licence actualById = (new LicenceService(licenceDao, mock(LicenceSearchDao.class))).getById(1L);

    // Assert
    verify(licenceDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link LicenceService#getByExternalId(String)}
   */
  @Test
  void testGetByExternalId() {
    // Arrange
    LicenceDao licenceDao = mock(LicenceDao.class);
    when(licenceDao.getByExternalId(Mockito.<String>any())).thenReturn(null);

    // Act
    Licence actualByExternalId = (new LicenceService(licenceDao, mock(LicenceSearchDao.class))).getByExternalId("42");

    // Assert
    verify(licenceDao).getByExternalId(eq("42"));
    assertNull(actualByExternalId);
  }

  /**
   * Method under test: {@link LicenceService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector() {
    // Arrange
    LicenceDao licenceDao = mock(LicenceDao.class);
    ArrayList<Licence> licenceList = new ArrayList<>();
    when(licenceDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(licenceList);
    LicenceService licenceService = new LicenceService(licenceDao, mock(LicenceSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<Licence> actualFindBySelectorResult = licenceService.findBySelector(options);

    // Assert
    verify(licenceDao).findBySelector(isA(Select.class));
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(licenceList, actualFindBySelectorResult);
  }

  /**
   * Method under test: {@link LicenceService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector2() {
    // Arrange
    LicenceDao licenceDao = mock(LicenceDao.class);
    ArrayList<Licence> licenceList = new ArrayList<>();
    when(licenceDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(licenceList);
    LicenceService licenceService = new LicenceService(licenceDao, mock(LicenceSearchDao.class));
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
    List<Licence> actualFindBySelectorResult = licenceService.findBySelector(options);

    // Assert
    verify(licenceDao).findBySelector(isA(Select.class));
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(licenceList, actualFindBySelectorResult);
  }

  /**
   * Method under test: {@link LicenceService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector3() {
    // Arrange
    LicenceDao licenceDao = mock(LicenceDao.class);
    ArrayList<Licence> licenceList = new ArrayList<>();
    when(licenceDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(licenceList);
    LicenceService licenceService = new LicenceService(licenceDao, mock(LicenceSearchDao.class));
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
    List<Licence> actualFindBySelectorResult = licenceService.findBySelector(options);

    // Assert
    verify(licenceDao).findBySelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(licenceList, actualFindBySelectorResult);
  }

  /**
   * Method under test: {@link LicenceService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector4() {
    // Arrange
    LicenceDao licenceDao = mock(LicenceDao.class);
    ArrayList<Licence> licenceList = new ArrayList<>();
    when(licenceDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(licenceList);
    LicenceService licenceService = new LicenceService(licenceDao, mock(LicenceSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.REMOVED);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<Licence> actualFindBySelectorResult = licenceService.findBySelector(options);

    // Assert
    verify(licenceDao).findBySelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(licenceList, actualFindBySelectorResult);
  }

  /**
   * Method under test: {@link LicenceService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector5() {
    // Arrange
    LicenceDao licenceDao = mock(LicenceDao.class);
    ArrayList<Licence> licenceList = new ArrayList<>();
    when(licenceDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(licenceList);
    LicenceService licenceService = new LicenceService(licenceDao, mock(LicenceSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<Licence> actualFindBySelectorResult = licenceService.findBySelector(options);

    // Assert
    verify(licenceDao).findBySelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(licenceList, actualFindBySelectorResult);
  }

  /**
   * Method under test: {@link LicenceService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector6() {
    // Arrange
    LicenceDao licenceDao = mock(LicenceDao.class);
    ArrayList<Licence> licenceList = new ArrayList<>();
    when(licenceDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(licenceList);
    LicenceService licenceService = new LicenceService(licenceDao, mock(LicenceSearchDao.class));
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
    List<Licence> actualFindBySelectorResult = licenceService.findBySelector(options);

    // Assert
    verify(licenceDao).findBySelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(licenceList, actualFindBySelectorResult);
  }

  /**
   * Method under test: {@link LicenceService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector7() {
    // Arrange
    LicenceDao licenceDao = mock(LicenceDao.class);
    ArrayList<Licence> licenceList = new ArrayList<>();
    when(licenceDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(licenceList);
    LicenceService licenceService = new LicenceService(licenceDao, mock(LicenceSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<Licence> actualFindBySelectorResult = licenceService.findBySelector(options);

    // Assert
    verify(licenceDao).findBySelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(licenceList, actualFindBySelectorResult);
  }

  /**
   * Method under test: {@link LicenceService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector8() {
    // Arrange
    LicenceDao licenceDao = mock(LicenceDao.class);
    ArrayList<Licence> licenceList = new ArrayList<>();
    when(licenceDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(licenceList);
    LicenceService licenceService = new LicenceService(licenceDao, mock(LicenceSearchDao.class));
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
    List<Licence> actualFindBySelectorResult = licenceService.findBySelector(options);

    // Assert
    verify(licenceDao).findBySelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(licenceList, actualFindBySelectorResult);
  }

  /**
   * Method under test: {@link LicenceService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector9() {
    // Arrange
    LicenceDao licenceDao = mock(LicenceDao.class);
    ArrayList<Licence> licenceList = new ArrayList<>();
    when(licenceDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(licenceList);
    LicenceService licenceService = new LicenceService(licenceDao, mock(LicenceSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<Licence> actualFindBySelectorResult = licenceService.findBySelector(options);

    // Assert
    verify(licenceDao).findBySelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(licenceList, actualFindBySelectorResult);
  }

  /**
   * Method under test: {@link LicenceService#countApplications()}
   */
  @Test
  void testCountApplications() {
    // Arrange
    LicenceDao licenceDao = mock(LicenceDao.class);
    ArrayList<Tally<Long>> tallyList = new ArrayList<>();
    when(licenceDao.countApplications()).thenReturn(tallyList);

    // Act
    List<Tally<Long>> actualCountApplicationsResult = (new LicenceService(licenceDao, mock(LicenceSearchDao.class)))
        .countApplications();

    // Assert
    verify(licenceDao).countApplications();
    assertTrue(actualCountApplicationsResult.isEmpty());
    assertSame(tallyList, actualCountApplicationsResult);
  }

  /**
   * Method under test: {@link LicenceService#save(SaveLicenceCommand, String)}
   */
  @Test
  void testSave() {
    // Arrange
    LicenceDao licenceDao = mock(LicenceDao.class);
    when(licenceDao.save(Mockito.<SaveLicenceCommand>any(), Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualSaveResult = (new LicenceService(licenceDao, mock(LicenceSearchDao.class))).save(null, "janedoe");

    // Assert
    verify(licenceDao).save(isNull(), eq("janedoe"));
    assertTrue(actualSaveResult);
  }

  /**
   * Method under test: {@link LicenceService#save(SaveLicenceCommand, String)}
   */
  @Test
  void testSave2() {
    // Arrange
    LicenceDao licenceDao = mock(LicenceDao.class);
    when(licenceDao.save(Mockito.<SaveLicenceCommand>any(), Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualSaveResult = (new LicenceService(licenceDao, mock(LicenceSearchDao.class))).save(null, "janedoe");

    // Assert
    verify(licenceDao).save(isNull(), eq("janedoe"));
    assertFalse(actualSaveResult);
  }

  /**
   * Method under test: {@link LicenceService#remove(long, String)}
   */
  @Test
  void testRemove() {
    // Arrange
    LicenceDao licenceDao = mock(LicenceDao.class);
    when(licenceDao.remove(anyLong())).thenReturn(true);

    // Act
    boolean actualRemoveResult = (new LicenceService(licenceDao, mock(LicenceSearchDao.class))).remove(1L, "janedoe");

    // Assert
    verify(licenceDao).remove(eq(1L));
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test: {@link LicenceService#remove(long, String)}
   */
  @Test
  void testRemove2() {
    // Arrange
    LicenceDao licenceDao = mock(LicenceDao.class);
    when(licenceDao.remove(anyLong())).thenReturn(false);

    // Act
    boolean actualRemoveResult = (new LicenceService(licenceDao, mock(LicenceSearchDao.class))).remove(1L, "janedoe");

    // Assert
    verify(licenceDao).remove(eq(1L));
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test: {@link LicenceService#search(EntitySearchOptions)}
   */
  @Test
  void testSearch() {
    // Arrange
    LicenceSearchDao licenceSearchDao = mock(LicenceSearchDao.class);
    ArrayList<Licence> licenceList = new ArrayList<>();
    when(licenceSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(licenceList);

    // Act
    Collection<Licence> actualSearchResult = (new LicenceService(mock(LicenceDao.class), licenceSearchDao))
        .search(null);

    // Assert
    verify(licenceSearchDao).search(isNull());
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
    assertSame(licenceList, actualSearchResult);
  }
}
