package org.finos.waltz.service.cost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.cost.AllocatedCostDefinitionDao;
import org.finos.waltz.data.cost.CostDao;
import org.finos.waltz.data.cost.CostKindDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.cost.AllocatedCostDefinition;
import org.finos.waltz.model.cost.CostKindWithYears;
import org.finos.waltz.model.cost.EntityCost;
import org.finos.waltz.model.cost.EntityCostKind;
import org.finos.waltz.model.cost.EntityCostsSummary;
import org.finos.waltz.model.cost.ImmutableEntityCostsSummary;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CostServiceDiffblueTest {
  /**
   * Method under test: {@link CostService#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    HashSet<EntityCost> entityCostSet = new HashSet<>();
    when(costDao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(entityCostSet);

    // Act
    Set<EntityCost> actualFindByEntityReferenceResult = (new CostService(costDao, mock(CostKindDao.class),
        mock(AllocatedCostDefinitionDao.class))).findByEntityReference(null);

    // Assert
    verify(costDao).findByEntityReference(isNull());
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
    assertSame(entityCostSet, actualFindByEntityReferenceResult);
  }

  /**
   * Method under test:
   * {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  void testFindBySelector() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    HashSet<EntityCost> entityCostSet = new HashSet<>();
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt())).thenReturn(entityCostSet);
    CostService costService = new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<EntityCost> actualFindBySelectorResult = costService.findBySelector(selectionOptions, EntityKind.APPLICATION,
        1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(entityReference).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(entityCostSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  void testFindBySelector2() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    HashSet<EntityCost> entityCostSet = new HashSet<>();
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt())).thenReturn(entityCostSet);
    CostService costService = new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));
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
    Set<EntityCost> actualFindBySelectorResult = costService.findBySelector(selectionOptions, EntityKind.APPLICATION,
        1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(entityReference).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(entityCostSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  void testFindBySelector3() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    HashSet<EntityCost> entityCostSet = new HashSet<>();
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt())).thenReturn(entityCostSet);
    CostService costService = new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));
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
    Set<EntityCost> actualFindBySelectorResult = costService.findBySelector(selectionOptions, EntityKind.APPLICATION,
        1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(entityCostSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  void testFindBySelector4() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    HashSet<EntityCost> entityCostSet = new HashSet<>();
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt())).thenReturn(entityCostSet);
    CostService costService = new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<EntityCost> actualFindBySelectorResult = costService.findBySelector(selectionOptions, EntityKind.APPLICATION,
        1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(entityCostSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  void testFindBySelector5() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    HashSet<EntityCost> entityCostSet = new HashSet<>();
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt())).thenReturn(entityCostSet);
    CostService costService = new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));
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
    Set<EntityCost> actualFindBySelectorResult = costService.findBySelector(selectionOptions, EntityKind.APPLICATION,
        1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(entityCostSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  void testFindBySelector6() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    HashSet<EntityCost> entityCostSet = new HashSet<>();
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt())).thenReturn(entityCostSet);
    CostService costService = new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<EntityCost> actualFindBySelectorResult = costService.findBySelector(selectionOptions,
        EntityKind.CHANGE_INITIATIVE, 1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(entityCostSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  void testFindBySelector7() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    HashSet<EntityCost> entityCostSet = new HashSet<>();
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt())).thenReturn(entityCostSet);
    CostService costService = new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<EntityCost> actualFindBySelectorResult = costService.findBySelector(selectionOptions,
        EntityKind.CHANGE_INITIATIVE, 1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(entityCostSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  void testFindBySelector8() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    HashSet<EntityCost> entityCostSet = new HashSet<>();
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt())).thenReturn(entityCostSet);
    CostService costService = new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));
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
    Set<EntityCost> actualFindBySelectorResult = costService.findBySelector(selectionOptions,
        EntityKind.CHANGE_INITIATIVE, 1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(entityCostSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  void testFindBySelector9() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    HashSet<EntityCost> entityCostSet = new HashSet<>();
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt())).thenReturn(entityCostSet);
    CostService costService = new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));
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
    Set<EntityCost> actualFindBySelectorResult = costService.findBySelector(selectionOptions,
        EntityKind.CHANGE_INITIATIVE, 1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(entityCostSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  void testFindBySelector10() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    HashSet<EntityCost> entityCostSet = new HashSet<>();
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt())).thenReturn(entityCostSet);
    CostService costService = new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));
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
    Set<EntityCost> actualFindBySelectorResult = costService.findBySelector(selectionOptions, EntityKind.ATTESTATION,
        1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(entityCostSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link CostService#summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind, int, int)}
   */
  @Test
  void testSummariseByCostKindAndSelector() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(costDao.getTotalForKindAndYearBySelector(anyLong(), Mockito.<Integer>any(), Mockito.<GenericSelector>any()))
        .thenReturn(bigDecimal);
    when(costDao.findTopCostsForCostKindAndSelector(anyLong(), anyInt(), Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    when(costDao.getMappedAndMissingCountsForKindAndYearBySelector(Mockito.<Long>any(), Mockito.<Integer>any(),
        Mockito.<GenericSelector>any())).thenReturn(new Tuple2<>(1, 1));
    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.getById(Mockito.<Long>any())).thenReturn(mock(EntityCostKind.class));
    CostService costService = new CostService(costDao, costKindDao, mock(AllocatedCostDefinitionDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    EntityCostsSummary actualSummariseByCostKindAndSelectorResult = costService.summariseByCostKindAndSelector(1L,
        selectionOptions, EntityKind.APPLICATION, 1, 1);

    // Assert
    verify(costDao).findTopCostsForCostKindAndSelector(eq(1L), eq(1), isA(GenericSelector.class), eq(1));
    verify(costDao).getMappedAndMissingCountsForKindAndYearBySelector(eq(1L), eq(1), isA(GenericSelector.class));
    verify(costDao).getTotalForKindAndYearBySelector(eq(1L), eq(1), isA(GenericSelector.class));
    verify(costKindDao).getById(eq(1L));
    verify(entityReference).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualSummariseByCostKindAndSelectorResult instanceof ImmutableEntityCostsSummary);
    assertTrue(actualSummariseByCostKindAndSelectorResult.topCosts().isEmpty());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    BigDecimal totalResult = actualSummariseByCostKindAndSelectorResult.total();
    assertEquals(expectedTotalResult, totalResult);
    assertSame(bigDecimal, totalResult);
  }

  /**
   * Method under test:
   * {@link CostService#summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind, int, int)}
   */
  @Test
  void testSummariseByCostKindAndSelector2() {
    // Arrange
    HashSet<EntityCost> entityCostSet = new HashSet<>();
    entityCostSet.add(mock(EntityCost.class));
    CostDao costDao = mock(CostDao.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(costDao.getTotalForKindAndYearBySelector(anyLong(), Mockito.<Integer>any(), Mockito.<GenericSelector>any()))
        .thenReturn(bigDecimal);
    when(costDao.findTopCostsForCostKindAndSelector(anyLong(), anyInt(), Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(entityCostSet);
    when(costDao.getMappedAndMissingCountsForKindAndYearBySelector(Mockito.<Long>any(), Mockito.<Integer>any(),
        Mockito.<GenericSelector>any())).thenReturn(new Tuple2<>(1, 1));
    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.getById(Mockito.<Long>any())).thenReturn(mock(EntityCostKind.class));
    CostService costService = new CostService(costDao, costKindDao, mock(AllocatedCostDefinitionDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    EntityCostsSummary actualSummariseByCostKindAndSelectorResult = costService.summariseByCostKindAndSelector(1L,
        selectionOptions, EntityKind.APPLICATION, 1, 1);

    // Assert
    verify(costDao).findTopCostsForCostKindAndSelector(eq(1L), eq(1), isA(GenericSelector.class), eq(1));
    verify(costDao).getMappedAndMissingCountsForKindAndYearBySelector(eq(1L), eq(1), isA(GenericSelector.class));
    verify(costDao).getTotalForKindAndYearBySelector(eq(1L), eq(1), isA(GenericSelector.class));
    verify(costKindDao).getById(eq(1L));
    verify(entityReference).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualSummariseByCostKindAndSelectorResult instanceof ImmutableEntityCostsSummary);
    assertEquals(1, actualSummariseByCostKindAndSelectorResult.topCosts().size());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    BigDecimal totalResult = actualSummariseByCostKindAndSelectorResult.total();
    assertEquals(expectedTotalResult, totalResult);
    assertSame(bigDecimal, totalResult);
  }

  /**
   * Method under test:
   * {@link CostService#summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind, int, int)}
   */
  @Test
  void testSummariseByCostKindAndSelector3() {
    // Arrange
    HashSet<EntityCost> entityCostSet = new HashSet<>();
    entityCostSet.add(mock(EntityCost.class));
    entityCostSet.add(mock(EntityCost.class));
    CostDao costDao = mock(CostDao.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(costDao.getTotalForKindAndYearBySelector(anyLong(), Mockito.<Integer>any(), Mockito.<GenericSelector>any()))
        .thenReturn(bigDecimal);
    when(costDao.findTopCostsForCostKindAndSelector(anyLong(), anyInt(), Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(entityCostSet);
    when(costDao.getMappedAndMissingCountsForKindAndYearBySelector(Mockito.<Long>any(), Mockito.<Integer>any(),
        Mockito.<GenericSelector>any())).thenReturn(new Tuple2<>(1, 1));
    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.getById(Mockito.<Long>any())).thenReturn(mock(EntityCostKind.class));
    CostService costService = new CostService(costDao, costKindDao, mock(AllocatedCostDefinitionDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    EntityCostsSummary actualSummariseByCostKindAndSelectorResult = costService.summariseByCostKindAndSelector(1L,
        selectionOptions, EntityKind.APPLICATION, 1, 1);

    // Assert
    verify(costDao).findTopCostsForCostKindAndSelector(eq(1L), eq(1), isA(GenericSelector.class), eq(1));
    verify(costDao).getMappedAndMissingCountsForKindAndYearBySelector(eq(1L), eq(1), isA(GenericSelector.class));
    verify(costDao).getTotalForKindAndYearBySelector(eq(1L), eq(1), isA(GenericSelector.class));
    verify(costKindDao).getById(eq(1L));
    verify(entityReference).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualSummariseByCostKindAndSelectorResult instanceof ImmutableEntityCostsSummary);
    assertEquals(2, actualSummariseByCostKindAndSelectorResult.topCosts().size());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    BigDecimal totalResult = actualSummariseByCostKindAndSelectorResult.total();
    assertEquals(expectedTotalResult, totalResult);
    assertSame(bigDecimal, totalResult);
  }

  /**
   * Method under test:
   * {@link CostService#summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind, int, int)}
   */
  @Test
  void testSummariseByCostKindAndSelector4() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(costDao.getTotalForKindAndYearBySelector(anyLong(), Mockito.<Integer>any(), Mockito.<GenericSelector>any()))
        .thenReturn(bigDecimal);
    when(costDao.findTopCostsForCostKindAndSelector(anyLong(), anyInt(), Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    when(costDao.getMappedAndMissingCountsForKindAndYearBySelector(Mockito.<Long>any(), Mockito.<Integer>any(),
        Mockito.<GenericSelector>any())).thenReturn(new Tuple2<>(1, 1));
    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.getById(Mockito.<Long>any())).thenReturn(mock(EntityCostKind.class));
    CostService costService = new CostService(costDao, costKindDao, mock(AllocatedCostDefinitionDao.class));
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
    EntityCostsSummary actualSummariseByCostKindAndSelectorResult = costService.summariseByCostKindAndSelector(1L,
        selectionOptions, EntityKind.APPLICATION, 1, 1);

    // Assert
    verify(costDao).findTopCostsForCostKindAndSelector(eq(1L), eq(1), isA(GenericSelector.class), eq(1));
    verify(costDao).getMappedAndMissingCountsForKindAndYearBySelector(eq(1L), eq(1), isA(GenericSelector.class));
    verify(costDao).getTotalForKindAndYearBySelector(eq(1L), eq(1), isA(GenericSelector.class));
    verify(costKindDao).getById(eq(1L));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualSummariseByCostKindAndSelectorResult instanceof ImmutableEntityCostsSummary);
    assertTrue(actualSummariseByCostKindAndSelectorResult.topCosts().isEmpty());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    BigDecimal totalResult = actualSummariseByCostKindAndSelectorResult.total();
    assertEquals(expectedTotalResult, totalResult);
    assertSame(bigDecimal, totalResult);
  }

  /**
   * Method under test:
   * {@link CostService#summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind, int, int)}
   */
  @Test
  void testSummariseByCostKindAndSelector5() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(costDao.getTotalForKindAndYearBySelector(anyLong(), Mockito.<Integer>any(), Mockito.<GenericSelector>any()))
        .thenReturn(bigDecimal);
    when(costDao.findTopCostsForCostKindAndSelector(anyLong(), anyInt(), Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    when(costDao.getMappedAndMissingCountsForKindAndYearBySelector(Mockito.<Long>any(), Mockito.<Integer>any(),
        Mockito.<GenericSelector>any())).thenReturn(new Tuple2<>(1, 1));
    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.getById(Mockito.<Long>any())).thenReturn(mock(EntityCostKind.class));
    CostService costService = new CostService(costDao, costKindDao, mock(AllocatedCostDefinitionDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    EntityCostsSummary actualSummariseByCostKindAndSelectorResult = costService.summariseByCostKindAndSelector(1L,
        selectionOptions, EntityKind.APPLICATION, 1, 1);

    // Assert
    verify(costDao).findTopCostsForCostKindAndSelector(eq(1L), eq(1), isA(GenericSelector.class), eq(1));
    verify(costDao).getMappedAndMissingCountsForKindAndYearBySelector(eq(1L), eq(1), isA(GenericSelector.class));
    verify(costDao).getTotalForKindAndYearBySelector(eq(1L), eq(1), isA(GenericSelector.class));
    verify(costKindDao).getById(eq(1L));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualSummariseByCostKindAndSelectorResult instanceof ImmutableEntityCostsSummary);
    assertTrue(actualSummariseByCostKindAndSelectorResult.topCosts().isEmpty());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    BigDecimal totalResult = actualSummariseByCostKindAndSelectorResult.total();
    assertEquals(expectedTotalResult, totalResult);
    assertSame(bigDecimal, totalResult);
  }

  /**
   * Method under test:
   * {@link CostService#summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind, int, int)}
   */
  @Test
  void testSummariseByCostKindAndSelector6() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(costDao.getTotalForKindAndYearBySelector(anyLong(), Mockito.<Integer>any(), Mockito.<GenericSelector>any()))
        .thenReturn(bigDecimal);
    when(costDao.findTopCostsForCostKindAndSelector(anyLong(), anyInt(), Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    when(costDao.getMappedAndMissingCountsForKindAndYearBySelector(Mockito.<Long>any(), Mockito.<Integer>any(),
        Mockito.<GenericSelector>any())).thenReturn(new Tuple2<>(1, 1));
    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.getById(Mockito.<Long>any())).thenReturn(mock(EntityCostKind.class));
    CostService costService = new CostService(costDao, costKindDao, mock(AllocatedCostDefinitionDao.class));
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
    EntityCostsSummary actualSummariseByCostKindAndSelectorResult = costService.summariseByCostKindAndSelector(1L,
        selectionOptions, EntityKind.APPLICATION, 1, 1);

    // Assert
    verify(costDao).findTopCostsForCostKindAndSelector(eq(1L), eq(1), isA(GenericSelector.class), eq(1));
    verify(costDao).getMappedAndMissingCountsForKindAndYearBySelector(eq(1L), eq(1), isA(GenericSelector.class));
    verify(costDao).getTotalForKindAndYearBySelector(eq(1L), eq(1), isA(GenericSelector.class));
    verify(costKindDao).getById(eq(1L));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualSummariseByCostKindAndSelectorResult instanceof ImmutableEntityCostsSummary);
    assertTrue(actualSummariseByCostKindAndSelectorResult.topCosts().isEmpty());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    BigDecimal totalResult = actualSummariseByCostKindAndSelectorResult.total();
    assertEquals(expectedTotalResult, totalResult);
    assertSame(bigDecimal, totalResult);
  }

  /**
   * Method under test: {@link CostService#populateAllocatedCosts()}
   */
  @Test
  void testPopulateAllocatedCosts() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findAll()).thenReturn(new HashSet<>());
    AllocatedCostDefinitionDao allocatedCostDefinitionDao = mock(AllocatedCostDefinitionDao.class);
    when(allocatedCostDefinitionDao.findAll()).thenReturn(new HashSet<>());

    // Act
    (new CostService(mock(CostDao.class), costKindDao, allocatedCostDefinitionDao)).populateAllocatedCosts();

    // Assert
    verify(allocatedCostDefinitionDao).findAll();
    verify(costKindDao).findAll();
  }

  /**
   * Method under test: {@link CostService#populateAllocatedCosts()}
   */
  @Test
  void testPopulateAllocatedCosts2() {
    // Arrange
    EntityCostKind entityCostKind = mock(EntityCostKind.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(entityCostKind.id()).thenReturn(ofResult);
    CostKindWithYears costKindWithYears = mock(CostKindWithYears.class);
    when(costKindWithYears.costKind()).thenReturn(entityCostKind);

    HashSet<CostKindWithYears> costKindWithYearsSet = new HashSet<>();
    costKindWithYearsSet.add(costKindWithYears);
    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findAll()).thenReturn(costKindWithYearsSet);
    AllocatedCostDefinitionDao allocatedCostDefinitionDao = mock(AllocatedCostDefinitionDao.class);
    when(allocatedCostDefinitionDao.findAll()).thenReturn(new HashSet<>());

    // Act
    (new CostService(mock(CostDao.class), costKindDao, allocatedCostDefinitionDao)).populateAllocatedCosts();

    // Assert
    verify(allocatedCostDefinitionDao).findAll();
    verify(costKindDao).findAll();
    verify(entityCostKind).id();
    verify(costKindWithYears).costKind();
  }

  /**
   * Method under test:
   * {@link CostService#allocateCostsByDefinition(AllocatedCostDefinition, Integer)}
   */
  @Test
  void testAllocateCostsByDefinition() {
    // Arrange
    AllocatedCostDefinitionDao allocatedCostDefinitionDao = mock(AllocatedCostDefinitionDao.class);
    doNothing().when(allocatedCostDefinitionDao)
        .allocateCostsByDefinition(Mockito.<AllocatedCostDefinition>any(), Mockito.<Integer>any());

    // Act
    (new CostService(mock(CostDao.class), mock(CostKindDao.class), allocatedCostDefinitionDao))
        .allocateCostsByDefinition(null, 1);

    // Assert
    verify(allocatedCostDefinitionDao).allocateCostsByDefinition(isNull(), eq(1));
  }
}
