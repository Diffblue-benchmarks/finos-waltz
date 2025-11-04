package org.finos.waltz.service.end_user_app;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.end_user_app.EndUserAppDao;
import org.finos.waltz.data.end_user_app.search.EndUserAppSearchDao;
import org.finos.waltz.data.involvement.InvolvementDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.enduserapp.EndUserApplication;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.tally.Tally;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EndUserAppServiceDiffblueTest {
  /**
   * Method under test:
   * {@link EndUserAppService#findByOrganisationalUnitSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByOrganisationalUnitSelector() {
    // Arrange
    EndUserAppDao endUserAppDao = mock(EndUserAppDao.class);
    ArrayList<EndUserApplication> endUserApplicationList = new ArrayList<>();
    when(endUserAppDao.findByOrganisationalUnitSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(endUserApplicationList);
    EndUserAppService endUserAppService = new EndUserAppService(endUserAppDao, mock(ApplicationDao.class),
        mock(ChangeLogDao.class), mock(InvolvementDao.class), mock(EndUserAppSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<EndUserApplication> actualFindByOrganisationalUnitSelectorResult = endUserAppService
        .findByOrganisationalUnitSelector(options);

    // Assert
    verify(endUserAppDao).findByOrganisationalUnitSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindByOrganisationalUnitSelectorResult.isEmpty());
    assertSame(endUserApplicationList, actualFindByOrganisationalUnitSelectorResult);
  }

  /**
   * Method under test:
   * {@link EndUserAppService#findByOrganisationalUnitSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByOrganisationalUnitSelector2() {
    // Arrange
    EndUserAppDao endUserAppDao = mock(EndUserAppDao.class);
    ArrayList<EndUserApplication> endUserApplicationList = new ArrayList<>();
    when(endUserAppDao.findByOrganisationalUnitSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(endUserApplicationList);
    EndUserAppService endUserAppService = new EndUserAppService(endUserAppDao, mock(ApplicationDao.class),
        mock(ChangeLogDao.class), mock(InvolvementDao.class), mock(EndUserAppSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.PARENTS);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<EndUserApplication> actualFindByOrganisationalUnitSelectorResult = endUserAppService
        .findByOrganisationalUnitSelector(options);

    // Assert
    verify(endUserAppDao).findByOrganisationalUnitSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).scope();
    assertTrue(actualFindByOrganisationalUnitSelectorResult.isEmpty());
    assertSame(endUserApplicationList, actualFindByOrganisationalUnitSelectorResult);
  }

  /**
   * Method under test:
   * {@link EndUserAppService#findByOrganisationalUnitSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByOrganisationalUnitSelector3() {
    // Arrange
    EndUserAppDao endUserAppDao = mock(EndUserAppDao.class);
    ArrayList<EndUserApplication> endUserApplicationList = new ArrayList<>();
    when(endUserAppDao.findByOrganisationalUnitSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(endUserApplicationList);
    EndUserAppService endUserAppService = new EndUserAppService(endUserAppDao, mock(ApplicationDao.class),
        mock(ChangeLogDao.class), mock(InvolvementDao.class), mock(EndUserAppSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<EndUserApplication> actualFindByOrganisationalUnitSelectorResult = endUserAppService
        .findByOrganisationalUnitSelector(options);

    // Assert
    verify(endUserAppDao).findByOrganisationalUnitSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).scope();
    assertTrue(actualFindByOrganisationalUnitSelectorResult.isEmpty());
    assertSame(endUserApplicationList, actualFindByOrganisationalUnitSelectorResult);
  }

  /**
   * Method under test: {@link EndUserAppService#countByOrgUnitId()}
   */
  @Test
  void testCountByOrgUnitId() {
    // Arrange
    EndUserAppDao endUserAppDao = mock(EndUserAppDao.class);
    ArrayList<Tally<Long>> tallyList = new ArrayList<>();
    when(endUserAppDao.countByOrganisationalUnit()).thenReturn(tallyList);

    // Act
    Collection<Tally<Long>> actualCountByOrgUnitIdResult = (new EndUserAppService(endUserAppDao,
        mock(ApplicationDao.class), mock(ChangeLogDao.class), mock(InvolvementDao.class),
        mock(EndUserAppSearchDao.class))).countByOrgUnitId();

    // Assert
    verify(endUserAppDao).countByOrganisationalUnit();
    assertTrue(actualCountByOrgUnitIdResult instanceof List);
    assertTrue(actualCountByOrgUnitIdResult.isEmpty());
    assertSame(tallyList, actualCountByOrgUnitIdResult);
  }

  /**
   * Method under test:
   * {@link EndUserAppService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector() {
    // Arrange
    EndUserAppDao endUserAppDao = mock(EndUserAppDao.class);
    ArrayList<EndUserApplication> endUserApplicationList = new ArrayList<>();
    when(endUserAppDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(endUserApplicationList);
    EndUserAppService endUserAppService = new EndUserAppService(endUserAppDao, mock(ApplicationDao.class),
        mock(ChangeLogDao.class), mock(InvolvementDao.class), mock(EndUserAppSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<EndUserApplication> actualFindBySelectorResult = endUserAppService.findBySelector(options);

    // Assert
    verify(endUserAppDao).findBySelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(endUserApplicationList, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link EndUserAppService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector2() {
    // Arrange
    EndUserAppDao endUserAppDao = mock(EndUserAppDao.class);
    ArrayList<EndUserApplication> endUserApplicationList = new ArrayList<>();
    when(endUserAppDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(endUserApplicationList);
    EndUserAppService endUserAppService = new EndUserAppService(endUserAppDao, mock(ApplicationDao.class),
        mock(ChangeLogDao.class), mock(InvolvementDao.class), mock(EndUserAppSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<EndUserApplication> actualFindBySelectorResult = endUserAppService.findBySelector(options);

    // Assert
    verify(endUserAppDao).findBySelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(endUserApplicationList, actualFindBySelectorResult);
  }

  /**
   * Method under test: {@link EndUserAppService#getById(Long)}
   */
  @Test
  void testGetById() {
    // Arrange
    EndUserAppDao endUserAppDao = mock(EndUserAppDao.class);
    when(endUserAppDao.getById(Mockito.<Long>any())).thenReturn(null);

    // Act
    EndUserApplication actualById = (new EndUserAppService(endUserAppDao, mock(ApplicationDao.class),
        mock(ChangeLogDao.class), mock(InvolvementDao.class), mock(EndUserAppSearchDao.class))).getById(1L);

    // Assert
    verify(endUserAppDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link EndUserAppService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    EndUserAppDao endUserAppDao = mock(EndUserAppDao.class);
    ArrayList<EndUserApplication> endUserApplicationList = new ArrayList<>();
    when(endUserAppDao.findAll()).thenReturn(endUserApplicationList);

    // Act
    List<EndUserApplication> actualFindAllResult = (new EndUserAppService(endUserAppDao, mock(ApplicationDao.class),
        mock(ChangeLogDao.class), mock(InvolvementDao.class), mock(EndUserAppSearchDao.class))).findAll();

    // Assert
    verify(endUserAppDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(endUserApplicationList, actualFindAllResult);
  }

  /**
   * Method under test: {@link EndUserAppService#search(EntitySearchOptions)}
   */
  @Test
  void testSearch() {
    // Arrange
    EndUserAppSearchDao endUserAppSearchDao = mock(EndUserAppSearchDao.class);
    ArrayList<EndUserApplication> endUserApplicationList = new ArrayList<>();
    when(endUserAppSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(endUserApplicationList);

    // Act
    Collection<EndUserApplication> actualSearchResult = (new EndUserAppService(mock(EndUserAppDao.class),
        mock(ApplicationDao.class), mock(ChangeLogDao.class), mock(InvolvementDao.class), endUserAppSearchDao))
            .search(null);

    // Assert
    verify(endUserAppSearchDao).search(isNull());
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
    assertSame(endUserApplicationList, actualSearchResult);
  }
}
