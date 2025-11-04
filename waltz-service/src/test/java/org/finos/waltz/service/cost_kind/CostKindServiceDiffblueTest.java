package org.finos.waltz.service.cost_kind;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.cost.CostKindDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.cost.CostKindWithYears;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CostKindServiceDiffblueTest {
  /**
   * Method under test: {@link CostKindService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    HashSet<CostKindWithYears> costKindWithYearsSet = new HashSet<>();
    when(costKindDao.findAll()).thenReturn(costKindWithYearsSet);

    // Act
    Set<CostKindWithYears> actualFindAllResult = (new CostKindService(costKindDao)).findAll();

    // Assert
    verify(costKindDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(costKindWithYearsSet, actualFindAllResult);
  }

  /**
   * Method under test:
   * {@link CostKindService#findCostKindsBySubjectKind(EntityKind)}
   */
  @Test
  void testFindCostKindsBySubjectKind() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    HashSet<CostKindWithYears> costKindWithYearsSet = new HashSet<>();
    when(costKindDao.findCostKindsBySubjectKind(Mockito.<EntityKind>any())).thenReturn(costKindWithYearsSet);

    // Act
    Set<CostKindWithYears> actualFindCostKindsBySubjectKindResult = (new CostKindService(costKindDao))
        .findCostKindsBySubjectKind(EntityKind.ALL);

    // Assert
    verify(costKindDao).findCostKindsBySubjectKind(eq(EntityKind.ALL));
    assertTrue(actualFindCostKindsBySubjectKindResult.isEmpty());
    assertSame(costKindWithYearsSet, actualFindCostKindsBySubjectKindResult);
  }

  /**
   * Method under test:
   * {@link CostKindService#findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindCostKindsSelectorRoute() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    HashSet<CostKindWithYears> costKindWithYearsSet = new HashSet<>();
    when(costKindDao.findCostKindsBySelector(Mockito.<GenericSelector>any())).thenReturn(costKindWithYearsSet);
    CostKindService costKindService = new CostKindService(costKindDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<CostKindWithYears> actualFindCostKindsSelectorRouteResult = costKindService
        .findCostKindsSelectorRoute(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(costKindDao).findCostKindsBySelector(isA(GenericSelector.class));
    verify(entityReference).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindCostKindsSelectorRouteResult.isEmpty());
    assertSame(costKindWithYearsSet, actualFindCostKindsSelectorRouteResult);
  }

  /**
   * Method under test:
   * {@link CostKindService#findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindCostKindsSelectorRoute2() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    HashSet<CostKindWithYears> costKindWithYearsSet = new HashSet<>();
    when(costKindDao.findCostKindsBySelector(Mockito.<GenericSelector>any())).thenReturn(costKindWithYearsSet);
    CostKindService costKindService = new CostKindService(costKindDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<ApplicationKind> applicationKindSet = new HashSet<>();
    applicationKindSet.add(ApplicationKind.IN_HOUSE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(applicationKindSet);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<CostKindWithYears> actualFindCostKindsSelectorRouteResult = costKindService
        .findCostKindsSelectorRoute(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(costKindDao).findCostKindsBySelector(isA(GenericSelector.class));
    verify(entityReference).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertTrue(actualFindCostKindsSelectorRouteResult.isEmpty());
    assertSame(costKindWithYearsSet, actualFindCostKindsSelectorRouteResult);
  }

  /**
   * Method under test:
   * {@link CostKindService#findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindCostKindsSelectorRoute3() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    HashSet<CostKindWithYears> costKindWithYearsSet = new HashSet<>();
    when(costKindDao.findCostKindsBySelector(Mockito.<GenericSelector>any())).thenReturn(costKindWithYearsSet);
    CostKindService costKindService = new CostKindService(costKindDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<CostKindWithYears> actualFindCostKindsSelectorRouteResult = costKindService
        .findCostKindsSelectorRoute(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(costKindDao).findCostKindsBySelector(isA(GenericSelector.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindCostKindsSelectorRouteResult.isEmpty());
    assertSame(costKindWithYearsSet, actualFindCostKindsSelectorRouteResult);
  }

  /**
   * Method under test:
   * {@link CostKindService#findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindCostKindsSelectorRoute4() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    HashSet<CostKindWithYears> costKindWithYearsSet = new HashSet<>();
    when(costKindDao.findCostKindsBySelector(Mockito.<GenericSelector>any())).thenReturn(costKindWithYearsSet);
    CostKindService costKindService = new CostKindService(costKindDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<CostKindWithYears> actualFindCostKindsSelectorRouteResult = costKindService
        .findCostKindsSelectorRoute(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(costKindDao).findCostKindsBySelector(isA(GenericSelector.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindCostKindsSelectorRouteResult.isEmpty());
    assertSame(costKindWithYearsSet, actualFindCostKindsSelectorRouteResult);
  }

  /**
   * Method under test:
   * {@link CostKindService#findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindCostKindsSelectorRoute5() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    HashSet<CostKindWithYears> costKindWithYearsSet = new HashSet<>();
    when(costKindDao.findCostKindsBySelector(Mockito.<GenericSelector>any())).thenReturn(costKindWithYearsSet);
    CostKindService costKindService = new CostKindService(costKindDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<CostKindWithYears> actualFindCostKindsSelectorRouteResult = costKindService
        .findCostKindsSelectorRoute(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(costKindDao).findCostKindsBySelector(isA(GenericSelector.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindCostKindsSelectorRouteResult.isEmpty());
    assertSame(costKindWithYearsSet, actualFindCostKindsSelectorRouteResult);
  }

  /**
   * Method under test:
   * {@link CostKindService#findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindCostKindsSelectorRoute6() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    HashSet<CostKindWithYears> costKindWithYearsSet = new HashSet<>();
    when(costKindDao.findCostKindsBySelector(Mockito.<GenericSelector>any())).thenReturn(costKindWithYearsSet);
    CostKindService costKindService = new CostKindService(costKindDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<CostKindWithYears> actualFindCostKindsSelectorRouteResult = costKindService
        .findCostKindsSelectorRoute(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(costKindDao).findCostKindsBySelector(isA(GenericSelector.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindCostKindsSelectorRouteResult.isEmpty());
    assertSame(costKindWithYearsSet, actualFindCostKindsSelectorRouteResult);
  }

  /**
   * Method under test:
   * {@link CostKindService#findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindCostKindsSelectorRoute7() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    HashSet<CostKindWithYears> costKindWithYearsSet = new HashSet<>();
    when(costKindDao.findCostKindsBySelector(Mockito.<GenericSelector>any())).thenReturn(costKindWithYearsSet);
    CostKindService costKindService = new CostKindService(costKindDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<CostKindWithYears> actualFindCostKindsSelectorRouteResult = costKindService
        .findCostKindsSelectorRoute(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(costKindDao).findCostKindsBySelector(isA(GenericSelector.class));
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindCostKindsSelectorRouteResult.isEmpty());
    assertSame(costKindWithYearsSet, actualFindCostKindsSelectorRouteResult);
  }

  /**
   * Method under test:
   * {@link CostKindService#findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindCostKindsSelectorRoute8() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    HashSet<CostKindWithYears> costKindWithYearsSet = new HashSet<>();
    when(costKindDao.findCostKindsBySelector(Mockito.<GenericSelector>any())).thenReturn(costKindWithYearsSet);
    CostKindService costKindService = new CostKindService(costKindDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(selectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(mock(SelectionFilters.class));
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<CostKindWithYears> actualFindCostKindsSelectorRouteResult = costKindService
        .findCostKindsSelectorRoute(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(costKindDao).findCostKindsBySelector(isA(GenericSelector.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualFindCostKindsSelectorRouteResult.isEmpty());
    assertSame(costKindWithYearsSet, actualFindCostKindsSelectorRouteResult);
  }

  /**
   * Method under test:
   * {@link CostKindService#findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindCostKindsSelectorRoute9() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    HashSet<CostKindWithYears> costKindWithYearsSet = new HashSet<>();
    when(costKindDao.findCostKindsBySelector(Mockito.<GenericSelector>any())).thenReturn(costKindWithYearsSet);
    CostKindService costKindService = new CostKindService(costKindDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(selectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(mock(SelectionFilters.class));
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<CostKindWithYears> actualFindCostKindsSelectorRouteResult = costKindService
        .findCostKindsSelectorRoute(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(costKindDao).findCostKindsBySelector(isA(GenericSelector.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualFindCostKindsSelectorRouteResult.isEmpty());
    assertSame(costKindWithYearsSet, actualFindCostKindsSelectorRouteResult);
  }

  /**
   * Method under test:
   * {@link CostKindService#findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindCostKindsSelectorRoute10() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    HashSet<CostKindWithYears> costKindWithYearsSet = new HashSet<>();
    when(costKindDao.findCostKindsBySelector(Mockito.<GenericSelector>any())).thenReturn(costKindWithYearsSet);
    CostKindService costKindService = new CostKindService(costKindDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<CostKindWithYears> actualFindCostKindsSelectorRouteResult = costKindService
        .findCostKindsSelectorRoute(EntityKind.ATTESTATION, selectionOptions);

    // Assert
    verify(costKindDao).findCostKindsBySelector(isA(GenericSelector.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindCostKindsSelectorRouteResult.isEmpty());
    assertSame(costKindWithYearsSet, actualFindCostKindsSelectorRouteResult);
  }

  /**
   * Method under test:
   * {@link CostKindService#findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindCostKindsSelectorRoute11() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    HashSet<CostKindWithYears> costKindWithYearsSet = new HashSet<>();
    when(costKindDao.findCostKindsBySelector(Mockito.<GenericSelector>any())).thenReturn(costKindWithYearsSet);
    CostKindService costKindService = new CostKindService(costKindDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<CostKindWithYears> actualFindCostKindsSelectorRouteResult = costKindService
        .findCostKindsSelectorRoute(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(costKindDao).findCostKindsBySelector(isA(GenericSelector.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindCostKindsSelectorRouteResult.isEmpty());
    assertSame(costKindWithYearsSet, actualFindCostKindsSelectorRouteResult);
  }

  /**
   * Method under test:
   * {@link CostKindService#findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindCostKindsSelectorRoute12() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    HashSet<CostKindWithYears> costKindWithYearsSet = new HashSet<>();
    when(costKindDao.findCostKindsBySelector(Mockito.<GenericSelector>any())).thenReturn(costKindWithYearsSet);
    CostKindService costKindService = new CostKindService(costKindDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.PARENTS);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<CostKindWithYears> actualFindCostKindsSelectorRouteResult = costKindService
        .findCostKindsSelectorRoute(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(costKindDao).findCostKindsBySelector(isA(GenericSelector.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindCostKindsSelectorRouteResult.isEmpty());
    assertSame(costKindWithYearsSet, actualFindCostKindsSelectorRouteResult);
  }
}
