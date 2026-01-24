package org.finos.waltz.service.cost;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.cost.AllocatedCostDefinitionDao;
import org.finos.waltz.data.cost.CostDao;
import org.finos.waltz.data.cost.CostKindDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.cost.AllocatedCostDefinition;
import org.finos.waltz.model.cost.CostKindWithYears;
import org.finos.waltz.model.cost.EntityCost;
import org.finos.waltz.model.cost.EntityCostKind;
import org.finos.waltz.model.cost.EntityCostsSummary;
import org.finos.waltz.model.cost.ImmutableAllocatedCostDefinition;
import org.finos.waltz.model.cost.ImmutableCostKindWithYears;
import org.finos.waltz.model.cost.ImmutableEntityCost;
import org.finos.waltz.model.cost.ImmutableEntityCostKind;
import org.finos.waltz.model.cost.ImmutableEntityCostsSummary;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CostServiceDiffblueTest {
  /**
   * Test {@link CostService#findByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link CostService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(new HashSet<>());
    CostService costService =
        new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));

    // Act
    Set<EntityCost> actualFindByEntityReferenceResult = costService.findByEntityReference(null);

    // Assert
    verify(costDao).findByEntityReference(isNull());
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}.
   *
   * <p>Method under test: {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions, EntityKind, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostService.findBySelector(IdSelectionOptions, EntityKind, int)"})
  void testFindBySelector() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    CostService costService =
        new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
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
    Set<EntityCost> actualFindBySelectorResult =
        costService.findBySelector(selectionOptions, EntityKind.APPLICATION, 1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}.
   *
   * <p>Method under test: {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions, EntityKind, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostService.findBySelector(IdSelectionOptions, EntityKind, int)"})
  void testFindBySelector2() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    CostService costService =
        new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference())
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
    Set<EntityCost> actualFindBySelectorResult =
        costService.findBySelector(selectionOptions, EntityKind.APPLICATION, 1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}.
   *
   * <p>Method under test: {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions, EntityKind, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostService.findBySelector(IdSelectionOptions, EntityKind, int)"})
  void testFindBySelector3() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    CostService costService =
        new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
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
    Set<EntityCost> actualFindBySelectorResult =
        costService.findBySelector(selectionOptions, EntityKind.APPLICATION, 1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions, EntityKind, int); given builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostService.findBySelector(IdSelectionOptions, EntityKind, int)"})
  void testFindBySelector_givenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    CostService costService =
        new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters immutableSelectionFilters = builderResult.build();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(immutableSelectionFilters);
    when(selectionOptions.entityReference())
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
    Set<EntityCost> actualFindBySelectorResult =
        costService.findBySelector(selectionOptions, EntityKind.APPLICATION, 1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions, atLeast(1)).filters();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions, EntityKind, int); given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostService.findBySelector(IdSelectionOptions, EntityKind, int)"})
  void testFindBySelector_givenHashSetAddActive() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    CostService costService =
        new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
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
    Set<EntityCost> actualFindBySelectorResult =
        costService.findBySelector(selectionOptions, EntityKind.APPLICATION, 1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions, EntityKind, int); given HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostService.findBySelector(IdSelectionOptions, EntityKind, int)"})
  void testFindBySelector_givenHashSetAddPending() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    CostService costService =
        new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
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
    Set<EntityCost> actualFindBySelectorResult =
        costService.findBySelector(selectionOptions, EntityKind.APPLICATION, 1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions, EntityKind, int); given HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostService.findBySelector(IdSelectionOptions, EntityKind, int)"})
  void testFindBySelector_givenHashSetAddPending2() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    CostService costService =
        new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
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
    Set<EntityCost> actualFindBySelectorResult =
        costService.findBySelector(selectionOptions, EntityKind.APPLICATION, 1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code REMOVED}.
   *   <li>When {@code APPLICATION}.
   *   <li>Then calls {@link IdSelectionOptions#filters()}.
   * </ul>
   *
   * <p>Method under test: {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions, EntityKind, int); given HashSet() add 'REMOVED'; when 'APPLICATION'; then calls filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostService.findBySelector(IdSelectionOptions, EntityKind, int)"})
  void testFindBySelector_givenHashSetAddRemoved_whenApplication_thenCallsFilters() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    CostService costService =
        new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.REMOVED);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
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
    Set<EntityCost> actualFindBySelectorResult =
        costService.findBySelector(selectionOptions, EntityKind.APPLICATION, 1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code REMOVED}.
   *   <li>When {@code MEASURABLE}.
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions, EntityKind, int); given HashSet() add 'REMOVED'; when 'MEASURABLE'; then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostService.findBySelector(IdSelectionOptions, EntityKind, int)"})
  void testFindBySelector_givenHashSetAddRemoved_whenMeasurable_thenCallsScope() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    CostService costService =
        new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.REMOVED);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.entityReference())
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
    Set<EntityCost> actualFindBySelectorResult =
        costService.findBySelector(selectionOptions, EntityKind.MEASURABLE, 1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}.
   *
   * <ul>
   *   <li>When {@code APPLICATION}.
   *   <li>Then calls {@link IdSelectionOptions#filters()}.
   * </ul>
   *
   * <p>Method under test: {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions, EntityKind, int); when 'APPLICATION'; then calls filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostService.findBySelector(IdSelectionOptions, EntityKind, int)"})
  void testFindBySelector_whenApplication_thenCallsFilters() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    CostService costService =
        new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
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
    Set<EntityCost> actualFindBySelectorResult =
        costService.findBySelector(selectionOptions, EntityKind.APPLICATION, 1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_INITIATIVE}.
   * </ul>
   *
   * <p>Method under test: {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions, EntityKind, int); when 'CHANGE_INITIATIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostService.findBySelector(IdSelectionOptions, EntityKind, int)"})
  void testFindBySelector_whenChangeInitiative() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    CostService costService =
        new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference())
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
    Set<EntityCost> actualFindBySelectorResult =
        costService.findBySelector(selectionOptions, EntityKind.CHANGE_INITIATIVE, 1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_INITIATIVE}.
   * </ul>
   *
   * <p>Method under test: {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions, EntityKind, int); when 'CHANGE_INITIATIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostService.findBySelector(IdSelectionOptions, EntityKind, int)"})
  void testFindBySelector_whenChangeInitiative2() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    CostService costService =
        new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference())
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
    Set<EntityCost> actualFindBySelectorResult =
        costService.findBySelector(selectionOptions, EntityKind.CHANGE_INITIATIVE, 1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_UNIT}.
   * </ul>
   *
   * <p>Method under test: {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions, EntityKind, int); when 'CHANGE_UNIT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostService.findBySelector(IdSelectionOptions, EntityKind, int)"})
  void testFindBySelector_whenChangeUnit() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    CostService costService =
        new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
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
    Set<EntityCost> actualFindBySelectorResult =
        costService.findBySelector(selectionOptions, EntityKind.CHANGE_UNIT, 1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_UNIT}.
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions, EntityKind, int); when 'CHANGE_UNIT'; then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostService.findBySelector(IdSelectionOptions, EntityKind, int)"})
  void testFindBySelector_whenChangeUnit_thenCallsScope() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    CostService costService =
        new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference())
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
    Set<EntityCost> actualFindBySelectorResult =
        costService.findBySelector(selectionOptions, EntityKind.CHANGE_UNIT, 1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}.
   *
   * <ul>
   *   <li>When {@code FLOW_DIAGRAM}.
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions, EntityKind, int); when 'FLOW_DIAGRAM'; then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostService.findBySelector(IdSelectionOptions, EntityKind, int)"})
  void testFindBySelector_whenFlowDiagram_thenCallsScope() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    CostService costService =
        new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference())
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
    Set<EntityCost> actualFindBySelectorResult =
        costService.findBySelector(selectionOptions, EntityKind.FLOW_DIAGRAM, 1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}.
   *
   * <ul>
   *   <li>When {@code LICENCE}.
   *   <li>Then calls {@link IdSelectionOptions#filters()}.
   * </ul>
   *
   * <p>Method under test: {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions, EntityKind, int); when 'LICENCE'; then calls filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostService.findBySelector(IdSelectionOptions, EntityKind, int)"})
  void testFindBySelector_whenLicence_thenCallsFilters() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    CostService costService =
        new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
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
    Set<EntityCost> actualFindBySelectorResult =
        costService.findBySelector(selectionOptions, EntityKind.LICENCE, 1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}.
   *
   * <ul>
   *   <li>When {@code LOGICAL_DATA_FLOW}.
   * </ul>
   *
   * <p>Method under test: {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions, EntityKind, int); when 'LOGICAL_DATA_FLOW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostService.findBySelector(IdSelectionOptions, EntityKind, int)"})
  void testFindBySelector_whenLogicalDataFlow() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    CostService costService =
        new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
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
    Set<EntityCost> actualFindBySelectorResult =
        costService.findBySelector(selectionOptions, EntityKind.LOGICAL_DATA_FLOW, 1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}.
   *
   * <ul>
   *   <li>When {@code LOGICAL_DATA_FLOW}.
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions, EntityKind, int); when 'LOGICAL_DATA_FLOW'; then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostService.findBySelector(IdSelectionOptions, EntityKind, int)"})
  void testFindBySelector_whenLogicalDataFlow_thenCallsScope() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    CostService costService =
        new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference())
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
    Set<EntityCost> actualFindBySelectorResult =
        costService.findBySelector(selectionOptions, EntityKind.LOGICAL_DATA_FLOW, 1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}.
   *
   * <ul>
   *   <li>When {@code MEASURABLE}.
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link CostService#findBySelector(IdSelectionOptions, EntityKind, int)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions, EntityKind, int); when 'MEASURABLE'; then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostService.findBySelector(IdSelectionOptions, EntityKind, int)"})
  void testFindBySelector_whenMeasurable_thenCallsScope() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.findBySelector(Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    CostService costService =
        new CostService(costDao, mock(CostKindDao.class), mock(AllocatedCostDefinitionDao.class));

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.entityReference())
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
    Set<EntityCost> actualFindBySelectorResult =
        costService.findBySelector(selectionOptions, EntityKind.MEASURABLE, 1);

    // Assert
    verify(costDao).findBySelector(isA(GenericSelector.class), eq(1));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link CostService#summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind,
   * int, int)}.
   *
   * <p>Method under test: {@link CostService#summariseByCostKindAndSelector(Long,
   * IdSelectionOptions, EntityKind, int, int)}
   */
  @Test
  @DisplayName(
      "Test summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityCostsSummary CostService.summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind, int, int)"
  })
  void testSummariseByCostKindAndSelector() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.getTotalForKindAndYearBySelector(
            anyLong(), Mockito.<Integer>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new BigDecimal("2.3"));
    when(costDao.findTopCostsForCostKindAndSelector(
            anyLong(), anyInt(), Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    when(costDao.getMappedAndMissingCountsForKindAndYearBySelector(
            Mockito.<Long>any(), Mockito.<Integer>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new Tuple2<>(1, 1));

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableEntityCostKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .subjectKind(EntityKind.ALL)
                .build());

    CostService costService =
        new CostService(costDao, costKindDao, mock(AllocatedCostDefinitionDao.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    EntityCostsSummary actualSummariseByCostKindAndSelectorResult =
        costService.summariseByCostKindAndSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            EntityKind.APPLICATION,
            1,
            1);

    // Assert
    verify(costDao)
        .findTopCostsForCostKindAndSelector(eq(1L), eq(1), isA(GenericSelector.class), eq(1));
    verify(costDao)
        .getMappedAndMissingCountsForKindAndYearBySelector(
            eq(1L), eq(1), isA(GenericSelector.class));
    verify(costDao).getTotalForKindAndYearBySelector(eq(1L), eq(1), isA(GenericSelector.class));
    verify(costKindDao).getById(1L);
    EntityCostKind costKindResult = actualSummariseByCostKindAndSelectorResult.costKind();
    assertTrue(costKindResult instanceof ImmutableEntityCostKind);
    assertTrue(actualSummariseByCostKindAndSelectorResult instanceof ImmutableEntityCostsSummary);
    assertEquals("Name", costKindResult.name());
    assertEquals("The characteristics of someone or something", costKindResult.description());
    assertEquals(1, actualSummariseByCostKindAndSelectorResult.mappedCount());
    assertEquals(1, actualSummariseByCostKindAndSelectorResult.missingCount());
    assertEquals(1, actualSummariseByCostKindAndSelectorResult.year());
    assertEquals(EntityKind.ALL, costKindResult.kind());
    assertEquals(EntityKind.ALL, costKindResult.subjectKind());
    assertTrue(actualSummariseByCostKindAndSelectorResult.topCosts().isEmpty());
    assertTrue(costKindResult.isDefault());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualSummariseByCostKindAndSelectorResult.total());
  }

  /**
   * Test {@link CostService#summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind,
   * int, int)}.
   *
   * <p>Method under test: {@link CostService#summariseByCostKindAndSelector(Long,
   * IdSelectionOptions, EntityKind, int, int)}
   */
  @Test
  @DisplayName(
      "Test summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityCostsSummary CostService.summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind, int, int)"
  })
  void testSummariseByCostKindAndSelector2() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.getTotalForKindAndYearBySelector(
            anyLong(), Mockito.<Integer>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new BigDecimal("2.3"));
    when(costDao.findTopCostsForCostKindAndSelector(
            anyLong(), anyInt(), Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    when(costDao.getMappedAndMissingCountsForKindAndYearBySelector(
            Mockito.<Long>any(), Mockito.<Integer>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new Tuple2<>(1, 1));

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableEntityCostKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .subjectKind(EntityKind.ALL)
                .build());

    CostService costService =
        new CostService(costDao, costKindDao, mock(AllocatedCostDefinitionDao.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APPLICATION)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    EntityCostsSummary actualSummariseByCostKindAndSelectorResult =
        costService.summariseByCostKindAndSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            EntityKind.APPLICATION,
            1,
            1);

    // Assert
    verify(costDao)
        .findTopCostsForCostKindAndSelector(eq(1L), eq(1), isA(GenericSelector.class), eq(1));
    verify(costDao)
        .getMappedAndMissingCountsForKindAndYearBySelector(
            eq(1L), eq(1), isA(GenericSelector.class));
    verify(costDao).getTotalForKindAndYearBySelector(eq(1L), eq(1), isA(GenericSelector.class));
    verify(costKindDao).getById(1L);
    EntityCostKind costKindResult = actualSummariseByCostKindAndSelectorResult.costKind();
    assertTrue(costKindResult instanceof ImmutableEntityCostKind);
    assertTrue(actualSummariseByCostKindAndSelectorResult instanceof ImmutableEntityCostsSummary);
    assertEquals("Name", costKindResult.name());
    assertEquals("The characteristics of someone or something", costKindResult.description());
    assertEquals(1, actualSummariseByCostKindAndSelectorResult.mappedCount());
    assertEquals(1, actualSummariseByCostKindAndSelectorResult.missingCount());
    assertEquals(1, actualSummariseByCostKindAndSelectorResult.year());
    assertEquals(EntityKind.ALL, costKindResult.kind());
    assertEquals(EntityKind.ALL, costKindResult.subjectKind());
    assertTrue(actualSummariseByCostKindAndSelectorResult.topCosts().isEmpty());
    assertTrue(costKindResult.isDefault());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualSummariseByCostKindAndSelectorResult.total());
  }

  /**
   * Test {@link CostService#summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind,
   * int, int)}.
   *
   * <p>Method under test: {@link CostService#summariseByCostKindAndSelector(Long,
   * IdSelectionOptions, EntityKind, int, int)}
   */
  @Test
  @DisplayName(
      "Test summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityCostsSummary CostService.summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind, int, int)"
  })
  void testSummariseByCostKindAndSelector3() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.getTotalForKindAndYearBySelector(
            anyLong(), Mockito.<Integer>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new BigDecimal("2.3"));
    when(costDao.findTopCostsForCostKindAndSelector(
            anyLong(), anyInt(), Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    when(costDao.getMappedAndMissingCountsForKindAndYearBySelector(
            Mockito.<Long>any(), Mockito.<Integer>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new Tuple2<>(1, 1));

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableEntityCostKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .subjectKind(EntityKind.ALL)
                .build());

    CostService costService =
        new CostService(costDao, costKindDao, mock(AllocatedCostDefinitionDao.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APP_GROUP)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    EntityCostsSummary actualSummariseByCostKindAndSelectorResult =
        costService.summariseByCostKindAndSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            EntityKind.APPLICATION,
            1,
            1);

    // Assert
    verify(costDao)
        .findTopCostsForCostKindAndSelector(eq(1L), eq(1), isA(GenericSelector.class), eq(1));
    verify(costDao)
        .getMappedAndMissingCountsForKindAndYearBySelector(
            eq(1L), eq(1), isA(GenericSelector.class));
    verify(costDao).getTotalForKindAndYearBySelector(eq(1L), eq(1), isA(GenericSelector.class));
    verify(costKindDao).getById(1L);
    EntityCostKind costKindResult = actualSummariseByCostKindAndSelectorResult.costKind();
    assertTrue(costKindResult instanceof ImmutableEntityCostKind);
    assertTrue(actualSummariseByCostKindAndSelectorResult instanceof ImmutableEntityCostsSummary);
    assertEquals("Name", costKindResult.name());
    assertEquals("The characteristics of someone or something", costKindResult.description());
    assertEquals(1, actualSummariseByCostKindAndSelectorResult.mappedCount());
    assertEquals(1, actualSummariseByCostKindAndSelectorResult.missingCount());
    assertEquals(1, actualSummariseByCostKindAndSelectorResult.year());
    assertEquals(EntityKind.ALL, costKindResult.kind());
    assertEquals(EntityKind.ALL, costKindResult.subjectKind());
    assertTrue(actualSummariseByCostKindAndSelectorResult.topCosts().isEmpty());
    assertTrue(costKindResult.isDefault());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualSummariseByCostKindAndSelectorResult.total());
  }

  /**
   * Test {@link CostService#summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind,
   * int, int)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link CostService#summariseByCostKindAndSelector(Long,
   * IdSelectionOptions, EntityKind, int, int)}
   */
  @Test
  @DisplayName(
      "Test summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind, int, int); given 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityCostsSummary CostService.summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind, int, int)"
  })
  void testSummariseByCostKindAndSelector_givenActive() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.getTotalForKindAndYearBySelector(
            anyLong(), Mockito.<Integer>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new BigDecimal("2.3"));
    when(costDao.findTopCostsForCostKindAndSelector(
            anyLong(), anyInt(), Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    when(costDao.getMappedAndMissingCountsForKindAndYearBySelector(
            Mockito.<Long>any(), Mockito.<Integer>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new Tuple2<>(1, 1));

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableEntityCostKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .subjectKind(EntityKind.ALL)
                .build());

    CostService costService =
        new CostService(costDao, costKindDao, mock(AllocatedCostDefinitionDao.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    EntityCostsSummary actualSummariseByCostKindAndSelectorResult =
        costService.summariseByCostKindAndSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            EntityKind.APPLICATION,
            1,
            1);

    // Assert
    verify(costDao)
        .findTopCostsForCostKindAndSelector(eq(1L), eq(1), isA(GenericSelector.class), eq(1));
    verify(costDao)
        .getMappedAndMissingCountsForKindAndYearBySelector(
            eq(1L), eq(1), isA(GenericSelector.class));
    verify(costDao).getTotalForKindAndYearBySelector(eq(1L), eq(1), isA(GenericSelector.class));
    verify(costKindDao).getById(1L);
    EntityCostKind costKindResult = actualSummariseByCostKindAndSelectorResult.costKind();
    assertTrue(costKindResult instanceof ImmutableEntityCostKind);
    assertTrue(actualSummariseByCostKindAndSelectorResult instanceof ImmutableEntityCostsSummary);
    assertEquals("Name", costKindResult.name());
    assertEquals("The characteristics of someone or something", costKindResult.description());
    assertEquals(1, actualSummariseByCostKindAndSelectorResult.mappedCount());
    assertEquals(1, actualSummariseByCostKindAndSelectorResult.missingCount());
    assertEquals(1, actualSummariseByCostKindAndSelectorResult.year());
    assertEquals(EntityKind.ALL, costKindResult.kind());
    assertEquals(EntityKind.ALL, costKindResult.subjectKind());
    assertTrue(actualSummariseByCostKindAndSelectorResult.topCosts().isEmpty());
    assertTrue(costKindResult.isDefault());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualSummariseByCostKindAndSelectorResult.total());
  }

  /**
   * Test {@link CostService#summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind,
   * int, int)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link CostService#summariseByCostKindAndSelector(Long,
   * IdSelectionOptions, EntityKind, int, int)}
   */
  @Test
  @DisplayName(
      "Test summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind, int, int); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityCostsSummary CostService.summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind, int, int)"
  })
  void testSummariseByCostKindAndSelector_givenInHouse() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.getTotalForKindAndYearBySelector(
            anyLong(), Mockito.<Integer>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new BigDecimal("2.3"));
    when(costDao.findTopCostsForCostKindAndSelector(
            anyLong(), anyInt(), Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    when(costDao.getMappedAndMissingCountsForKindAndYearBySelector(
            Mockito.<Long>any(), Mockito.<Integer>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new Tuple2<>(1, 1));

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableEntityCostKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .subjectKind(EntityKind.ALL)
                .build());

    CostService costService =
        new CostService(costDao, costKindDao, mock(AllocatedCostDefinitionDao.class));

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters filters = builderResult.build();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    EntityCostsSummary actualSummariseByCostKindAndSelectorResult =
        costService.summariseByCostKindAndSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            EntityKind.APPLICATION,
            1,
            1);

    // Assert
    verify(costDao)
        .findTopCostsForCostKindAndSelector(eq(1L), eq(1), isA(GenericSelector.class), eq(1));
    verify(costDao)
        .getMappedAndMissingCountsForKindAndYearBySelector(
            eq(1L), eq(1), isA(GenericSelector.class));
    verify(costDao).getTotalForKindAndYearBySelector(eq(1L), eq(1), isA(GenericSelector.class));
    verify(costKindDao).getById(1L);
    EntityCostKind costKindResult = actualSummariseByCostKindAndSelectorResult.costKind();
    assertTrue(costKindResult instanceof ImmutableEntityCostKind);
    assertTrue(actualSummariseByCostKindAndSelectorResult instanceof ImmutableEntityCostsSummary);
    assertEquals("Name", costKindResult.name());
    assertEquals("The characteristics of someone or something", costKindResult.description());
    assertEquals(1, actualSummariseByCostKindAndSelectorResult.mappedCount());
    assertEquals(1, actualSummariseByCostKindAndSelectorResult.missingCount());
    assertEquals(1, actualSummariseByCostKindAndSelectorResult.year());
    assertEquals(EntityKind.ALL, costKindResult.kind());
    assertEquals(EntityKind.ALL, costKindResult.subjectKind());
    assertTrue(actualSummariseByCostKindAndSelectorResult.topCosts().isEmpty());
    assertTrue(costKindResult.isDefault());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualSummariseByCostKindAndSelectorResult.total());
  }

  /**
   * Test {@link CostService#summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind,
   * int, int)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link CostService#summariseByCostKindAndSelector(Long,
   * IdSelectionOptions, EntityKind, int, int)}
   */
  @Test
  @DisplayName(
      "Test summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind, int, int); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityCostsSummary CostService.summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind, int, int)"
  })
  void testSummariseByCostKindAndSelector_givenPending() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.getTotalForKindAndYearBySelector(
            anyLong(), Mockito.<Integer>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new BigDecimal("2.3"));
    when(costDao.findTopCostsForCostKindAndSelector(
            anyLong(), anyInt(), Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    when(costDao.getMappedAndMissingCountsForKindAndYearBySelector(
            Mockito.<Long>any(), Mockito.<Integer>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new Tuple2<>(1, 1));

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableEntityCostKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .subjectKind(EntityKind.ALL)
                .build());

    CostService costService =
        new CostService(costDao, costKindDao, mock(AllocatedCostDefinitionDao.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.PENDING);
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    EntityCostsSummary actualSummariseByCostKindAndSelectorResult =
        costService.summariseByCostKindAndSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            EntityKind.APPLICATION,
            1,
            1);

    // Assert
    verify(costDao)
        .findTopCostsForCostKindAndSelector(eq(1L), eq(1), isA(GenericSelector.class), eq(1));
    verify(costDao)
        .getMappedAndMissingCountsForKindAndYearBySelector(
            eq(1L), eq(1), isA(GenericSelector.class));
    verify(costDao).getTotalForKindAndYearBySelector(eq(1L), eq(1), isA(GenericSelector.class));
    verify(costKindDao).getById(1L);
    EntityCostKind costKindResult = actualSummariseByCostKindAndSelectorResult.costKind();
    assertTrue(costKindResult instanceof ImmutableEntityCostKind);
    assertTrue(actualSummariseByCostKindAndSelectorResult instanceof ImmutableEntityCostsSummary);
    assertEquals("Name", costKindResult.name());
    assertEquals("The characteristics of someone or something", costKindResult.description());
    assertEquals(1, actualSummariseByCostKindAndSelectorResult.mappedCount());
    assertEquals(1, actualSummariseByCostKindAndSelectorResult.missingCount());
    assertEquals(1, actualSummariseByCostKindAndSelectorResult.year());
    assertEquals(EntityKind.ALL, costKindResult.kind());
    assertEquals(EntityKind.ALL, costKindResult.subjectKind());
    assertTrue(actualSummariseByCostKindAndSelectorResult.topCosts().isEmpty());
    assertTrue(costKindResult.isDefault());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualSummariseByCostKindAndSelectorResult.total());
  }

  /**
   * Test {@link CostService#summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind,
   * int, int)}.
   *
   * <ul>
   *   <li>Then costKind return {@link ImmutableEntityCostKind}.
   * </ul>
   *
   * <p>Method under test: {@link CostService#summariseByCostKindAndSelector(Long,
   * IdSelectionOptions, EntityKind, int, int)}
   */
  @Test
  @DisplayName(
      "Test summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind, int, int); then costKind return ImmutableEntityCostKind")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityCostsSummary CostService.summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind, int, int)"
  })
  void testSummariseByCostKindAndSelector_thenCostKindReturnImmutableEntityCostKind() {
    // Arrange
    CostDao costDao = mock(CostDao.class);
    when(costDao.getTotalForKindAndYearBySelector(
            anyLong(), Mockito.<Integer>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new BigDecimal("2.3"));
    when(costDao.findTopCostsForCostKindAndSelector(
            anyLong(), anyInt(), Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    when(costDao.getMappedAndMissingCountsForKindAndYearBySelector(
            Mockito.<Long>any(), Mockito.<Integer>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new Tuple2<>(1, 1));

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableEntityCostKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .subjectKind(EntityKind.ALL)
                .build());

    CostService costService =
        new CostService(costDao, costKindDao, mock(AllocatedCostDefinitionDao.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    EntityCostsSummary actualSummariseByCostKindAndSelectorResult =
        costService.summariseByCostKindAndSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            EntityKind.APPLICATION,
            1,
            1);

    // Assert
    verify(costDao)
        .findTopCostsForCostKindAndSelector(eq(1L), eq(1), isA(GenericSelector.class), eq(1));
    verify(costDao)
        .getMappedAndMissingCountsForKindAndYearBySelector(
            eq(1L), eq(1), isA(GenericSelector.class));
    verify(costDao).getTotalForKindAndYearBySelector(eq(1L), eq(1), isA(GenericSelector.class));
    verify(costKindDao).getById(1L);
    EntityCostKind costKindResult = actualSummariseByCostKindAndSelectorResult.costKind();
    assertTrue(costKindResult instanceof ImmutableEntityCostKind);
    assertTrue(actualSummariseByCostKindAndSelectorResult instanceof ImmutableEntityCostsSummary);
    assertEquals("Name", costKindResult.name());
    assertEquals("The characteristics of someone or something", costKindResult.description());
    assertEquals(1, actualSummariseByCostKindAndSelectorResult.mappedCount());
    assertEquals(1, actualSummariseByCostKindAndSelectorResult.missingCount());
    assertEquals(1, actualSummariseByCostKindAndSelectorResult.year());
    assertEquals(EntityKind.ALL, costKindResult.kind());
    assertEquals(EntityKind.ALL, costKindResult.subjectKind());
    assertTrue(actualSummariseByCostKindAndSelectorResult.topCosts().isEmpty());
    assertTrue(costKindResult.isDefault());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualSummariseByCostKindAndSelectorResult.total());
  }

  /**
   * Test {@link CostService#summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind,
   * int, int)}.
   *
   * <ul>
   *   <li>Then return topCosts size is one.
   * </ul>
   *
   * <p>Method under test: {@link CostService#summariseByCostKindAndSelector(Long,
   * IdSelectionOptions, EntityKind, int, int)}
   */
  @Test
  @DisplayName(
      "Test summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind, int, int); then return topCosts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityCostsSummary CostService.summariseByCostKindAndSelector(Long, IdSelectionOptions, EntityKind, int, int)"
  })
  void testSummariseByCostKindAndSelector_thenReturnTopCostsSizeIsOne() {
    // Arrange
    HashSet<EntityCost> entityCostSet = new HashSet<>();

    ImmutableEntityCost.Builder builderResult = ImmutableEntityCost.builder();

    ImmutableEntityCost.Builder costKindIdResult =
        builderResult.amount(new BigDecimal("2.3")).costKindId(1L);
    entityCostSet.add(
        costKindIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .year(1)
            .build());

    CostDao costDao = mock(CostDao.class);
    when(costDao.getTotalForKindAndYearBySelector(
            anyLong(), Mockito.<Integer>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new BigDecimal("2.3"));
    when(costDao.findTopCostsForCostKindAndSelector(
            anyLong(), anyInt(), Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(entityCostSet);
    when(costDao.getMappedAndMissingCountsForKindAndYearBySelector(
            Mockito.<Long>any(), Mockito.<Integer>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new Tuple2<>(1, 1));

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableEntityCostKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .subjectKind(EntityKind.ALL)
                .build());

    CostService costService =
        new CostService(costDao, costKindDao, mock(AllocatedCostDefinitionDao.class));

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    EntityCostsSummary actualSummariseByCostKindAndSelectorResult =
        costService.summariseByCostKindAndSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            EntityKind.APPLICATION,
            1,
            1);

    // Assert
    verify(costDao)
        .findTopCostsForCostKindAndSelector(eq(1L), eq(1), isA(GenericSelector.class), eq(1));
    verify(costDao)
        .getMappedAndMissingCountsForKindAndYearBySelector(
            eq(1L), eq(1), isA(GenericSelector.class));
    verify(costDao).getTotalForKindAndYearBySelector(eq(1L), eq(1), isA(GenericSelector.class));
    verify(costKindDao).getById(1L);
    List<EntityCost> topCostsResult = actualSummariseByCostKindAndSelectorResult.topCosts();
    assertEquals(1, topCostsResult.size());
    EntityCost getResult = topCostsResult.get(0);
    assertTrue(getResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableEntityCost);
    assertTrue(actualSummariseByCostKindAndSelectorResult instanceof ImmutableEntityCostsSummary);
    assertEquals("2020-03-01", getResult.lastUpdatedBy());
    assertEquals("Provenance", getResult.provenance());
    assertEquals(1, getResult.year());
    assertEquals(1L, getResult.costKindId().longValue());
    assertEquals(EntityKind.ALL, getResult.kind());
    BigDecimal expectedAmountResult = new BigDecimal("2.3");
    assertEquals(expectedAmountResult, getResult.amount());
  }

  /**
   * Test {@link CostService#populateAllocatedCosts()}.
   *
   * <ul>
   *   <li>Given builder addYears two and one.
   * </ul>
   *
   * <p>Method under test: {@link CostService#populateAllocatedCosts()}
   */
  @Test
  @DisplayName("Test populateAllocatedCosts(); given builder addYears two and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CostService.populateAllocatedCosts()"})
  void testPopulateAllocatedCosts_givenBuilderAddYearsTwoAndOne() {
    // Arrange
    ImmutableCostKindWithYears.Builder builderResult = ImmutableCostKindWithYears.builder();
    builderResult.addYears(2, 1, 2, 1);
    ImmutableCostKindWithYears immutableCostKindWithYears =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build();

    HashSet<CostKindWithYears> costKindWithYearsSet = new HashSet<>();
    costKindWithYearsSet.add(immutableCostKindWithYears);

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findAll()).thenReturn(costKindWithYearsSet);

    HashSet<AllocatedCostDefinition> allocatedCostDefinitionSet = new HashSet<>();

    ImmutableAllocatedCostDefinition.Builder builderResult2 =
        ImmutableAllocatedCostDefinition.builder();

    ImmutableAllocatedCostDefinition.Builder idResult =
        builderResult2
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L);

    ImmutableAllocatedCostDefinition.Builder sourceCostKindResult =
        idResult.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    allocatedCostDefinitionSet.add(
        sourceCostKindResult
            .targetCostKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    AllocatedCostDefinitionDao allocatedCostDefinitionDao = mock(AllocatedCostDefinitionDao.class);
    doNothing()
        .when(allocatedCostDefinitionDao)
        .allocateCostsByDefinition(Mockito.<AllocatedCostDefinition>any(), Mockito.<Integer>any());
    when(allocatedCostDefinitionDao.findAll()).thenReturn(allocatedCostDefinitionSet);

    CostService costService =
        new CostService(mock(CostDao.class), costKindDao, allocatedCostDefinitionDao);

    // Act
    costService.populateAllocatedCosts();

    // Assert
    verify(allocatedCostDefinitionDao)
        .allocateCostsByDefinition(isA(AllocatedCostDefinition.class), eq(2));
    verify(allocatedCostDefinitionDao).findAll();
    verify(costKindDao).findAll();
  }

  /**
   * Test {@link CostService#populateAllocatedCosts()}.
   *
   * <ul>
   *   <li>Then calls {@link AllocatedCostDefinitionDao#findAll()}.
   * </ul>
   *
   * <p>Method under test: {@link CostService#populateAllocatedCosts()}
   */
  @Test
  @DisplayName("Test populateAllocatedCosts(); then calls findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CostService.populateAllocatedCosts()"})
  void testPopulateAllocatedCosts_thenCallsFindAll() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findAll()).thenReturn(new HashSet<>());

    AllocatedCostDefinitionDao allocatedCostDefinitionDao = mock(AllocatedCostDefinitionDao.class);
    when(allocatedCostDefinitionDao.findAll()).thenReturn(new HashSet<>());

    CostService costService =
        new CostService(mock(CostDao.class), costKindDao, allocatedCostDefinitionDao);

    // Act
    costService.populateAllocatedCosts();

    // Assert
    verify(allocatedCostDefinitionDao).findAll();
    verify(costKindDao).findAll();
  }

  /**
   * Test {@link CostService#populateAllocatedCosts()}.
   *
   * <ul>
   *   <li>Then calls {@link AllocatedCostDefinitionDao#findAll()}.
   * </ul>
   *
   * <p>Method under test: {@link CostService#populateAllocatedCosts()}
   */
  @Test
  @DisplayName("Test populateAllocatedCosts(); then calls findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CostService.populateAllocatedCosts()"})
  void testPopulateAllocatedCosts_thenCallsFindAll2() {
    // Arrange
    HashSet<CostKindWithYears> costKindWithYearsSet = new HashSet<>();

    ImmutableCostKindWithYears.Builder builderResult = ImmutableCostKindWithYears.builder();
    costKindWithYearsSet.add(
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build());

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findAll()).thenReturn(costKindWithYearsSet);

    AllocatedCostDefinitionDao allocatedCostDefinitionDao = mock(AllocatedCostDefinitionDao.class);
    when(allocatedCostDefinitionDao.findAll()).thenReturn(new HashSet<>());

    CostService costService =
        new CostService(mock(CostDao.class), costKindDao, allocatedCostDefinitionDao);

    // Act
    costService.populateAllocatedCosts();

    // Assert
    verify(allocatedCostDefinitionDao).findAll();
    verify(costKindDao).findAll();
  }

  /**
   * Test {@link CostService#allocateCostsByDefinition(AllocatedCostDefinition, Integer)}.
   *
   * <p>Method under test: {@link CostService#allocateCostsByDefinition(AllocatedCostDefinition,
   * Integer)}
   */
  @Test
  @DisplayName("Test allocateCostsByDefinition(AllocatedCostDefinition, Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CostService.allocateCostsByDefinition(AllocatedCostDefinition, Integer)"
  })
  void testAllocateCostsByDefinition() {
    // Arrange
    AllocatedCostDefinitionDao allocatedCostDefinitionDao = mock(AllocatedCostDefinitionDao.class);
    doNothing()
        .when(allocatedCostDefinitionDao)
        .allocateCostsByDefinition(Mockito.<AllocatedCostDefinition>any(), Mockito.<Integer>any());
    CostService costService =
        new CostService(mock(CostDao.class), mock(CostKindDao.class), allocatedCostDefinitionDao);

    // Act
    costService.allocateCostsByDefinition(null, 1);

    // Assert
    verify(allocatedCostDefinitionDao).allocateCostsByDefinition(isNull(), eq(1));
  }
}
