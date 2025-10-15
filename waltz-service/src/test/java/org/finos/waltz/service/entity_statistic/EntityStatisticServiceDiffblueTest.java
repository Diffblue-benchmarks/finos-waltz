package org.finos.waltz.service.entity_statistic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.entity_statistic.EntityStatisticDao;
import org.finos.waltz.data.entity_statistic.EntityStatisticDefinitionDao;
import org.finos.waltz.data.entity_statistic.EntityStatisticSummaryDao;
import org.finos.waltz.data.entity_statistic.EntityStatisticValueDao;
import org.finos.waltz.model.Duration;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.entity_statistic.EntityStatistic;
import org.finos.waltz.model.entity_statistic.EntityStatisticDefinition;
import org.finos.waltz.model.entity_statistic.EntityStatisticValue;
import org.finos.waltz.model.entity_statistic.ImmutableEntityStatisticDefinition;
import org.finos.waltz.model.entity_statistic.RollupKind;
import org.finos.waltz.model.entity_statistic.StatisticCategory;
import org.finos.waltz.model.entity_statistic.StatisticType;
import org.finos.waltz.model.immediate_hierarchy.ImmediateHierarchy;
import org.finos.waltz.model.immediate_hierarchy.ImmutableImmediateHierarchy;
import org.finos.waltz.model.tally.ImmutableTallyPack;
import org.finos.waltz.model.tally.TallyPack;
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
class EntityStatisticServiceDiffblueTest {
  @Mock private EntityStatisticDao entityStatisticDao;

  @Mock private EntityStatisticDefinitionDao entityStatisticDefinitionDao;

  @InjectMocks private EntityStatisticService entityStatisticService;

  @Mock private EntityStatisticSummaryDao entityStatisticSummaryDao;

  @Mock private EntityStatisticValueDao entityStatisticValueDao;

  /**
   * Test {@link EntityStatisticService#getRelatedStatDefinitions(long, boolean)}.
   *
   * <p>Method under test: {@link EntityStatisticService#getRelatedStatDefinitions(long, boolean)}
   */
  @Test
  @DisplayName("Test getRelatedStatDefinitions(long, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmediateHierarchy EntityStatisticService.getRelatedStatDefinitions(long, boolean)"
  })
  void testGetRelatedStatDefinitions() {
    // Arrange
    ArrayList<EntityStatisticDefinition> entityStatisticDefinitionList = new ArrayList<>();
    entityStatisticDefinitionList.add(
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build());
    entityStatisticDefinitionList.add(
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(2L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build());
    when(entityStatisticDefinitionDao.findRelated(anyLong(), anyBoolean()))
        .thenReturn(entityStatisticDefinitionList);

    // Act
    ImmediateHierarchy<EntityStatisticDefinition> actualRelatedStatDefinitions =
        entityStatisticService.getRelatedStatDefinitions(1L, true);

    // Assert
    verify(entityStatisticDefinitionDao).findRelated(1L, true);
    List<EntityStatisticDefinition> childrenResult = actualRelatedStatDefinitions.children();
    assertEquals(1, childrenResult.size());
    EntityStatisticDefinition getResult = childrenResult.get(0);
    assertTrue(getResult instanceof ImmutableEntityStatisticDefinition);
    assertTrue(actualRelatedStatDefinitions instanceof ImmutableImmediateHierarchy);
    assertEquals("Historic Renderer", getResult.historicRenderer());
    assertEquals("Name", getResult.name());
    assertEquals("Provenance", getResult.provenance());
    assertEquals("Renderer", getResult.renderer());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(EntityKind.ALL, getResult.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, getResult.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, getResult.category());
    assertEquals(StatisticType.BOOLEAN, getResult.type());
    assertTrue(getResult.active());
    assertTrue(getResult.entityVisibility());
    assertTrue(getResult.rollupVisibility());
  }

  /**
   * Test {@link EntityStatisticService#getRelatedStatDefinitions(long, boolean)}.
   *
   * <ul>
   *   <li>Then return children Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#getRelatedStatDefinitions(long, boolean)}
   */
  @Test
  @DisplayName("Test getRelatedStatDefinitions(long, boolean); then return children Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmediateHierarchy EntityStatisticService.getRelatedStatDefinitions(long, boolean)"
  })
  void testGetRelatedStatDefinitions_thenReturnChildrenEmpty() {
    // Arrange
    ArrayList<EntityStatisticDefinition> entityStatisticDefinitionList = new ArrayList<>();
    entityStatisticDefinitionList.add(
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(2L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build());
    when(entityStatisticDefinitionDao.findRelated(anyLong(), anyBoolean()))
        .thenReturn(entityStatisticDefinitionList);

    // Act
    ImmediateHierarchy<EntityStatisticDefinition> actualRelatedStatDefinitions =
        entityStatisticService.getRelatedStatDefinitions(2L, true);

    // Assert
    verify(entityStatisticDefinitionDao).findRelated(2L, true);
    EntityStatisticDefinition selfResult = actualRelatedStatDefinitions.self();
    assertTrue(selfResult instanceof ImmutableEntityStatisticDefinition);
    assertTrue(actualRelatedStatDefinitions instanceof ImmutableImmediateHierarchy);
    assertEquals("Historic Renderer", selfResult.historicRenderer());
    assertEquals("Name", selfResult.name());
    assertEquals("Provenance", selfResult.provenance());
    assertEquals("Renderer", selfResult.renderer());
    assertEquals("The characteristics of someone or something", selfResult.description());
    assertEquals(EntityKind.ALL, selfResult.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, selfResult.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, selfResult.category());
    assertEquals(StatisticType.BOOLEAN, selfResult.type());
    assertTrue(actualRelatedStatDefinitions.children().isEmpty());
    assertTrue(selfResult.active());
    assertTrue(selfResult.entityVisibility());
    assertTrue(selfResult.rollupVisibility());
  }

  /**
   * Test {@link EntityStatisticService#getRelatedStatDefinitions(long, boolean)}.
   *
   * <ul>
   *   <li>Then return children first is self.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#getRelatedStatDefinitions(long, boolean)}
   */
  @Test
  @DisplayName("Test getRelatedStatDefinitions(long, boolean); then return children first is self")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmediateHierarchy EntityStatisticService.getRelatedStatDefinitions(long, boolean)"
  })
  void testGetRelatedStatDefinitions_thenReturnChildrenFirstIsSelf() {
    // Arrange
    ArrayList<EntityStatisticDefinition> entityStatisticDefinitionList = new ArrayList<>();
    entityStatisticDefinitionList.add(
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build());
    when(entityStatisticDefinitionDao.findRelated(anyLong(), anyBoolean()))
        .thenReturn(entityStatisticDefinitionList);

    // Act
    ImmediateHierarchy<EntityStatisticDefinition> actualRelatedStatDefinitions =
        entityStatisticService.getRelatedStatDefinitions(1L, true);

    // Assert
    verify(entityStatisticDefinitionDao).findRelated(1L, true);
    EntityStatisticDefinition selfResult = actualRelatedStatDefinitions.self();
    assertTrue(selfResult instanceof ImmutableEntityStatisticDefinition);
    assertTrue(actualRelatedStatDefinitions instanceof ImmutableImmediateHierarchy);
    assertEquals("Historic Renderer", selfResult.historicRenderer());
    assertEquals("Name", selfResult.name());
    assertEquals("Provenance", selfResult.provenance());
    assertEquals("Renderer", selfResult.renderer());
    assertEquals("The characteristics of someone or something", selfResult.description());
    List<EntityStatisticDefinition> childrenResult = actualRelatedStatDefinitions.children();
    assertEquals(1, childrenResult.size());
    assertEquals(EntityKind.ALL, selfResult.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, selfResult.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, selfResult.category());
    assertEquals(StatisticType.BOOLEAN, selfResult.type());
    assertTrue(selfResult.active());
    assertTrue(selfResult.entityVisibility());
    assertTrue(selfResult.rollupVisibility());
    assertSame(selfResult, childrenResult.get(0));
  }

  /**
   * Test {@link EntityStatisticService#getRelatedStatDefinitions(long, boolean)}.
   *
   * <ul>
   *   <li>Then return children is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#getRelatedStatDefinitions(long, boolean)}
   */
  @Test
  @DisplayName("Test getRelatedStatDefinitions(long, boolean); then return children is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmediateHierarchy EntityStatisticService.getRelatedStatDefinitions(long, boolean)"
  })
  void testGetRelatedStatDefinitions_thenReturnChildrenIsArrayList() {
    // Arrange
    ArrayList<EntityStatisticDefinition> entityStatisticDefinitionList = new ArrayList<>();
    entityStatisticDefinitionList.add(
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build());
    entityStatisticDefinitionList.add(
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build());
    when(entityStatisticDefinitionDao.findRelated(anyLong(), anyBoolean()))
        .thenReturn(entityStatisticDefinitionList);

    // Act
    ImmediateHierarchy<EntityStatisticDefinition> actualRelatedStatDefinitions =
        entityStatisticService.getRelatedStatDefinitions(1L, true);

    // Assert
    verify(entityStatisticDefinitionDao).findRelated(1L, true);
    assertTrue(actualRelatedStatDefinitions instanceof ImmutableImmediateHierarchy);
    assertEquals(entityStatisticDefinitionList, actualRelatedStatDefinitions.children());
  }

  /**
   * Test {@link EntityStatisticService#findStatisticsForEntity(EntityReference, boolean)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#findStatisticsForEntity(EntityReference,
   * boolean)}
   */
  @Test
  @DisplayName("Test findStatisticsForEntity(EntityReference, boolean); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.findStatisticsForEntity(EntityReference, boolean)"
  })
  void testFindStatisticsForEntity_thenReturnEmpty() {
    // Arrange
    when(entityStatisticDao.findStatisticsForEntity(Mockito.<EntityReference>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityStatistic> actualFindStatisticsForEntityResult =
        entityStatisticService.findStatisticsForEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            true);

    // Assert
    verify(entityStatisticDao).findStatisticsForEntity(isA(EntityReference.class), eq(true));
    assertTrue(actualFindStatisticsForEntityResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#findStatisticsForEntity(EntityReference, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#findStatisticsForEntity(EntityReference,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test findStatisticsForEntity(EntityReference, boolean); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.findStatisticsForEntity(EntityReference, boolean)"
  })
  void testFindStatisticsForEntity_thenThrowUnsupportedOperationException() {
    // Arrange
    when(entityStatisticDao.findStatisticsForEntity(Mockito.<EntityReference>any(), anyBoolean()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            entityStatisticService.findStatisticsForEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                true));
    verify(entityStatisticDao).findStatisticsForEntity(isA(EntityReference.class), eq(true));
  }

  /**
   * Test {@link EntityStatisticService#getStatisticValuesForAppIdSelector(long,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link EntityStatisticService#getStatisticValuesForAppIdSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getStatisticValuesForAppIdSelector(long, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.getStatisticValuesForAppIdSelector(long, IdSelectionOptions)"
  })
  void testGetStatisticValuesForAppIdSelector() {
    // Arrange
    when(entityStatisticValueDao.getStatisticValuesForAppIdSelector(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
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
    List<EntityStatisticValue> actualStatisticValuesForAppIdSelector =
        entityStatisticService.getStatisticValuesForAppIdSelector(1L, options);

    // Assert
    verify(entityStatisticValueDao).getStatisticValuesForAppIdSelector(eq(1L), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    assertTrue(actualStatisticValuesForAppIdSelector.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#getStatisticValuesForAppIdSelector(long,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link EntityStatisticService#getStatisticValuesForAppIdSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getStatisticValuesForAppIdSelector(long, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.getStatisticValuesForAppIdSelector(long, IdSelectionOptions)"
  })
  void testGetStatisticValuesForAppIdSelector2() {
    // Arrange
    when(entityStatisticValueDao.getStatisticValuesForAppIdSelector(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
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
    List<EntityStatisticValue> actualStatisticValuesForAppIdSelector =
        entityStatisticService.getStatisticValuesForAppIdSelector(1L, options);

    // Assert
    verify(entityStatisticValueDao).getStatisticValuesForAppIdSelector(eq(1L), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options, atLeast(1)).filters();
    assertTrue(actualStatisticValuesForAppIdSelector.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#getStatisticValuesForAppIdSelector(long,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link EntityStatisticService#getStatisticValuesForAppIdSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getStatisticValuesForAppIdSelector(long, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.getStatisticValuesForAppIdSelector(long, IdSelectionOptions)"
  })
  void testGetStatisticValuesForAppIdSelector3() {
    // Arrange
    EntityStatisticValueDao valueDao = mock(EntityStatisticValueDao.class);
    when(valueDao.getStatisticValuesForAppIdSelector(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    EntityStatisticService entityStatisticService =
        new EntityStatisticService(
            valueDao,
            mock(EntityStatisticDefinitionDao.class),
            mock(EntityStatisticSummaryDao.class),
            mock(EntityStatisticDao.class));

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
    List<EntityStatisticValue> actualStatisticValuesForAppIdSelector =
        entityStatisticService.getStatisticValuesForAppIdSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(valueDao).getStatisticValuesForAppIdSelector(eq(1L), isA(Select.class));
    assertTrue(actualStatisticValuesForAppIdSelector.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#getStatisticValuesForAppIdSelector(long,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link EntityStatisticService#getStatisticValuesForAppIdSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getStatisticValuesForAppIdSelector(long, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.getStatisticValuesForAppIdSelector(long, IdSelectionOptions)"
  })
  void testGetStatisticValuesForAppIdSelector4() {
    // Arrange
    EntityStatisticValueDao valueDao = mock(EntityStatisticValueDao.class);
    when(valueDao.getStatisticValuesForAppIdSelector(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    EntityStatisticService entityStatisticService =
        new EntityStatisticService(
            valueDao,
            mock(EntityStatisticDefinitionDao.class),
            mock(EntityStatisticSummaryDao.class),
            mock(EntityStatisticDao.class));

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
    List<EntityStatisticValue> actualStatisticValuesForAppIdSelector =
        entityStatisticService.getStatisticValuesForAppIdSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(valueDao).getStatisticValuesForAppIdSelector(eq(1L), isA(Select.class));
    assertTrue(actualStatisticValuesForAppIdSelector.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#getStatisticValuesForAppIdSelector(long,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#getStatisticValuesForAppIdSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getStatisticValuesForAppIdSelector(long, IdSelectionOptions); given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.getStatisticValuesForAppIdSelector(long, IdSelectionOptions)"
  })
  void testGetStatisticValuesForAppIdSelector_givenHashSetAddActive() {
    // Arrange
    when(entityStatisticValueDao.getStatisticValuesForAppIdSelector(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
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
    List<EntityStatisticValue> actualStatisticValuesForAppIdSelector =
        entityStatisticService.getStatisticValuesForAppIdSelector(1L, options);

    // Assert
    verify(entityStatisticValueDao).getStatisticValuesForAppIdSelector(eq(1L), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    assertTrue(actualStatisticValuesForAppIdSelector.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#getStatisticValuesForAppIdSelector(long,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#getStatisticValuesForAppIdSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getStatisticValuesForAppIdSelector(long, IdSelectionOptions); given HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.getStatisticValuesForAppIdSelector(long, IdSelectionOptions)"
  })
  void testGetStatisticValuesForAppIdSelector_givenHashSetAddPending() {
    // Arrange
    when(entityStatisticValueDao.getStatisticValuesForAppIdSelector(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
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
    List<EntityStatisticValue> actualStatisticValuesForAppIdSelector =
        entityStatisticService.getStatisticValuesForAppIdSelector(1L, options);

    // Assert
    verify(entityStatisticValueDao).getStatisticValuesForAppIdSelector(eq(1L), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    assertTrue(actualStatisticValuesForAppIdSelector.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#getStatisticValuesForAppIdSelector(long,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#getStatisticValuesForAppIdSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getStatisticValuesForAppIdSelector(long, IdSelectionOptions); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.getStatisticValuesForAppIdSelector(long, IdSelectionOptions)"
  })
  void testGetStatisticValuesForAppIdSelector_givenInHouse() {
    // Arrange
    EntityStatisticValueDao valueDao = mock(EntityStatisticValueDao.class);
    when(valueDao.getStatisticValuesForAppIdSelector(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    EntityStatisticService entityStatisticService =
        new EntityStatisticService(
            valueDao,
            mock(EntityStatisticDefinitionDao.class),
            mock(EntityStatisticSummaryDao.class),
            mock(EntityStatisticDao.class));

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
    List<EntityStatisticValue> actualStatisticValuesForAppIdSelector =
        entityStatisticService.getStatisticValuesForAppIdSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(valueDao).getStatisticValuesForAppIdSelector(eq(1L), isA(Select.class));
    assertTrue(actualStatisticValuesForAppIdSelector.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#getStatisticValuesForAppIdSelector(long,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#getStatisticValuesForAppIdSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getStatisticValuesForAppIdSelector(long, IdSelectionOptions); then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.getStatisticValuesForAppIdSelector(long, IdSelectionOptions)"
  })
  void testGetStatisticValuesForAppIdSelector_thenCallsScope() {
    // Arrange
    when(entityStatisticValueDao.getStatisticValuesForAppIdSelector(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
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
    List<EntityStatisticValue> actualStatisticValuesForAppIdSelector =
        entityStatisticService.getStatisticValuesForAppIdSelector(1L, options);

    // Assert
    verify(entityStatisticValueDao).getStatisticValuesForAppIdSelector(eq(1L), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualStatisticValuesForAppIdSelector.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#getStatisticValuesForAppIdSelector(long,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#getStatisticValuesForAppIdSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getStatisticValuesForAppIdSelector(long, IdSelectionOptions); then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.getStatisticValuesForAppIdSelector(long, IdSelectionOptions)"
  })
  void testGetStatisticValuesForAppIdSelector_thenCallsScope2() {
    // Arrange
    when(entityStatisticValueDao.getStatisticValuesForAppIdSelector(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
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
    List<EntityStatisticValue> actualStatisticValuesForAppIdSelector =
        entityStatisticService.getStatisticValuesForAppIdSelector(1L, options);

    // Assert
    verify(entityStatisticValueDao).getStatisticValuesForAppIdSelector(eq(1L), isA(Select.class));
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualStatisticValuesForAppIdSelector.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#getStatisticValuesForAppIdSelector(long,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#getStatisticValuesForAppIdSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getStatisticValuesForAppIdSelector(long, IdSelectionOptions); then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.getStatisticValuesForAppIdSelector(long, IdSelectionOptions)"
  })
  void testGetStatisticValuesForAppIdSelector_thenCallsScope3() {
    // Arrange
    when(entityStatisticValueDao.getStatisticValuesForAppIdSelector(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
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
    List<EntityStatisticValue> actualStatisticValuesForAppIdSelector =
        entityStatisticService.getStatisticValuesForAppIdSelector(1L, options);

    // Assert
    verify(entityStatisticValueDao).getStatisticValuesForAppIdSelector(eq(1L), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualStatisticValuesForAppIdSelector.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#getStatisticValuesForAppIdSelector(long,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#getStatisticValuesForAppIdSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getStatisticValuesForAppIdSelector(long, IdSelectionOptions); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.getStatisticValuesForAppIdSelector(long, IdSelectionOptions)"
  })
  void testGetStatisticValuesForAppIdSelector_thenThrowUnsupportedOperationException() {
    // Arrange
    when(entityStatisticValueDao.getStatisticValuesForAppIdSelector(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
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
        () -> entityStatisticService.getStatisticValuesForAppIdSelector(1L, options));
    verify(entityStatisticValueDao).getStatisticValuesForAppIdSelector(eq(1L), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
  }

  /**
   * Test {@link EntityStatisticService#getStatisticAppsForAppIdSelector(long, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link EntityStatisticService#getStatisticAppsForAppIdSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getStatisticAppsForAppIdSelector(long, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.getStatisticAppsForAppIdSelector(long, IdSelectionOptions)"
  })
  void testGetStatisticAppsForAppIdSelector() {
    // Arrange
    when(entityStatisticValueDao.getStatisticAppsForAppIdSelector(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
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
    List<Application> actualStatisticAppsForAppIdSelector =
        entityStatisticService.getStatisticAppsForAppIdSelector(1L, options);

    // Assert
    verify(entityStatisticValueDao).getStatisticAppsForAppIdSelector(eq(1L), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    assertTrue(actualStatisticAppsForAppIdSelector.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#getStatisticAppsForAppIdSelector(long, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link EntityStatisticService#getStatisticAppsForAppIdSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getStatisticAppsForAppIdSelector(long, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.getStatisticAppsForAppIdSelector(long, IdSelectionOptions)"
  })
  void testGetStatisticAppsForAppIdSelector2() {
    // Arrange
    EntityStatisticValueDao valueDao = mock(EntityStatisticValueDao.class);
    when(valueDao.getStatisticAppsForAppIdSelector(anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    EntityStatisticService entityStatisticService =
        new EntityStatisticService(
            valueDao,
            mock(EntityStatisticDefinitionDao.class),
            mock(EntityStatisticSummaryDao.class),
            mock(EntityStatisticDao.class));

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
    List<Application> actualStatisticAppsForAppIdSelector =
        entityStatisticService.getStatisticAppsForAppIdSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(valueDao).getStatisticAppsForAppIdSelector(eq(1L), isA(Select.class));
    assertTrue(actualStatisticAppsForAppIdSelector.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#getStatisticAppsForAppIdSelector(long, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link EntityStatisticService#getStatisticAppsForAppIdSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getStatisticAppsForAppIdSelector(long, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.getStatisticAppsForAppIdSelector(long, IdSelectionOptions)"
  })
  void testGetStatisticAppsForAppIdSelector3() {
    // Arrange
    EntityStatisticValueDao valueDao = mock(EntityStatisticValueDao.class);
    when(valueDao.getStatisticAppsForAppIdSelector(anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    EntityStatisticService entityStatisticService =
        new EntityStatisticService(
            valueDao,
            mock(EntityStatisticDefinitionDao.class),
            mock(EntityStatisticSummaryDao.class),
            mock(EntityStatisticDao.class));

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
    List<Application> actualStatisticAppsForAppIdSelector =
        entityStatisticService.getStatisticAppsForAppIdSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(valueDao).getStatisticAppsForAppIdSelector(eq(1L), isA(Select.class));
    assertTrue(actualStatisticAppsForAppIdSelector.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#getStatisticAppsForAppIdSelector(long, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#getStatisticAppsForAppIdSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getStatisticAppsForAppIdSelector(long, IdSelectionOptions); given builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.getStatisticAppsForAppIdSelector(long, IdSelectionOptions)"
  })
  void testGetStatisticAppsForAppIdSelector_givenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    when(entityStatisticValueDao.getStatisticAppsForAppIdSelector(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
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
    List<Application> actualStatisticAppsForAppIdSelector =
        entityStatisticService.getStatisticAppsForAppIdSelector(1L, options);

    // Assert
    verify(entityStatisticValueDao).getStatisticAppsForAppIdSelector(eq(1L), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options, atLeast(1)).filters();
    assertTrue(actualStatisticAppsForAppIdSelector.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#getStatisticAppsForAppIdSelector(long, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#getStatisticAppsForAppIdSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getStatisticAppsForAppIdSelector(long, IdSelectionOptions); given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.getStatisticAppsForAppIdSelector(long, IdSelectionOptions)"
  })
  void testGetStatisticAppsForAppIdSelector_givenHashSetAddActive() {
    // Arrange
    when(entityStatisticValueDao.getStatisticAppsForAppIdSelector(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
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
    List<Application> actualStatisticAppsForAppIdSelector =
        entityStatisticService.getStatisticAppsForAppIdSelector(1L, options);

    // Assert
    verify(entityStatisticValueDao).getStatisticAppsForAppIdSelector(eq(1L), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    assertTrue(actualStatisticAppsForAppIdSelector.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#getStatisticAppsForAppIdSelector(long, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#getStatisticAppsForAppIdSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getStatisticAppsForAppIdSelector(long, IdSelectionOptions); given HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.getStatisticAppsForAppIdSelector(long, IdSelectionOptions)"
  })
  void testGetStatisticAppsForAppIdSelector_givenHashSetAddPending() {
    // Arrange
    when(entityStatisticValueDao.getStatisticAppsForAppIdSelector(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
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
    List<Application> actualStatisticAppsForAppIdSelector =
        entityStatisticService.getStatisticAppsForAppIdSelector(1L, options);

    // Assert
    verify(entityStatisticValueDao).getStatisticAppsForAppIdSelector(eq(1L), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    assertTrue(actualStatisticAppsForAppIdSelector.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#getStatisticAppsForAppIdSelector(long, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#getStatisticAppsForAppIdSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getStatisticAppsForAppIdSelector(long, IdSelectionOptions); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.getStatisticAppsForAppIdSelector(long, IdSelectionOptions)"
  })
  void testGetStatisticAppsForAppIdSelector_givenInHouse() {
    // Arrange
    EntityStatisticValueDao valueDao = mock(EntityStatisticValueDao.class);
    when(valueDao.getStatisticAppsForAppIdSelector(anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    EntityStatisticService entityStatisticService =
        new EntityStatisticService(
            valueDao,
            mock(EntityStatisticDefinitionDao.class),
            mock(EntityStatisticSummaryDao.class),
            mock(EntityStatisticDao.class));

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
    List<Application> actualStatisticAppsForAppIdSelector =
        entityStatisticService.getStatisticAppsForAppIdSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(valueDao).getStatisticAppsForAppIdSelector(eq(1L), isA(Select.class));
    assertTrue(actualStatisticAppsForAppIdSelector.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#getStatisticAppsForAppIdSelector(long, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#getStatisticAppsForAppIdSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getStatisticAppsForAppIdSelector(long, IdSelectionOptions); then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.getStatisticAppsForAppIdSelector(long, IdSelectionOptions)"
  })
  void testGetStatisticAppsForAppIdSelector_thenCallsScope() {
    // Arrange
    when(entityStatisticValueDao.getStatisticAppsForAppIdSelector(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
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
    List<Application> actualStatisticAppsForAppIdSelector =
        entityStatisticService.getStatisticAppsForAppIdSelector(1L, options);

    // Assert
    verify(entityStatisticValueDao).getStatisticAppsForAppIdSelector(eq(1L), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualStatisticAppsForAppIdSelector.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#getStatisticAppsForAppIdSelector(long, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#getStatisticAppsForAppIdSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getStatisticAppsForAppIdSelector(long, IdSelectionOptions); then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.getStatisticAppsForAppIdSelector(long, IdSelectionOptions)"
  })
  void testGetStatisticAppsForAppIdSelector_thenCallsScope2() {
    // Arrange
    when(entityStatisticValueDao.getStatisticAppsForAppIdSelector(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
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
    List<Application> actualStatisticAppsForAppIdSelector =
        entityStatisticService.getStatisticAppsForAppIdSelector(1L, options);

    // Assert
    verify(entityStatisticValueDao).getStatisticAppsForAppIdSelector(eq(1L), isA(Select.class));
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualStatisticAppsForAppIdSelector.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#getStatisticAppsForAppIdSelector(long, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#getStatisticAppsForAppIdSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getStatisticAppsForAppIdSelector(long, IdSelectionOptions); then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.getStatisticAppsForAppIdSelector(long, IdSelectionOptions)"
  })
  void testGetStatisticAppsForAppIdSelector_thenCallsScope3() {
    // Arrange
    when(entityStatisticValueDao.getStatisticAppsForAppIdSelector(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
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
    List<Application> actualStatisticAppsForAppIdSelector =
        entityStatisticService.getStatisticAppsForAppIdSelector(1L, options);

    // Assert
    verify(entityStatisticValueDao).getStatisticAppsForAppIdSelector(eq(1L), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualStatisticAppsForAppIdSelector.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#getStatisticAppsForAppIdSelector(long, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#getStatisticAppsForAppIdSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getStatisticAppsForAppIdSelector(long, IdSelectionOptions); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.getStatisticAppsForAppIdSelector(long, IdSelectionOptions)"
  })
  void testGetStatisticAppsForAppIdSelector_thenThrowUnsupportedOperationException() {
    // Arrange
    when(entityStatisticValueDao.getStatisticAppsForAppIdSelector(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
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
        () -> entityStatisticService.getStatisticAppsForAppIdSelector(1L, options));
    verify(entityStatisticValueDao).getStatisticAppsForAppIdSelector(eq(1L), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
  }

  /**
   * Test {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findStatTallies(List, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticService.findStatTallies(List, IdSelectionOptions)"})
  void testFindStatTallies() {
    // Arrange
    when(entityStatisticDefinitionDao.findByIds(Mockito.<List<Long>>any()))
        .thenThrow(new UnsupportedOperationException());
    ArrayList<Long> statisticIds = new ArrayList<>();

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
        () -> entityStatisticService.findStatTallies(statisticIds, options));
    verify(entityStatisticDefinitionDao).findByIds(isA(List.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
  }

  /**
   * Test {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findStatTallies(List, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticService.findStatTallies(List, IdSelectionOptions)"})
  void testFindStatTallies2() {
    // Arrange
    when(entityStatisticDefinitionDao.findByIds(Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithAvgByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithCountByEntity(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithNoRollup(
            Mockito.<Collection<Long>>any(), Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithSumByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    ArrayList<Long> statisticIds = new ArrayList<>();

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
    List<TallyPack<String>> actualFindStatTalliesResult =
        entityStatisticService.findStatTallies(statisticIds, options);

    // Assert
    verify(entityStatisticDefinitionDao).findByIds(isA(List.class));
    verify(entityStatisticSummaryDao)
        .generateWithAvgByValue(isA(Collection.class), isA(Select.class));
    verify(entityStatisticSummaryDao)
        .generateWithCountByEntity(isA(Collection.class), isA(Select.class));
    verify(entityStatisticSummaryDao)
        .generateWithNoRollup(isA(Collection.class), isA(EntityReference.class));
    verify(entityStatisticSummaryDao)
        .generateWithSumByValue(isA(Collection.class), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    assertTrue(actualFindStatTalliesResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findStatTallies(List, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticService.findStatTallies(List, IdSelectionOptions)"})
  void testFindStatTallies3() {
    // Arrange
    when(entityStatisticDefinitionDao.findByIds(Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithCountByEntity(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new UnsupportedOperationException());
    ArrayList<Long> statisticIds = new ArrayList<>();

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
        () -> entityStatisticService.findStatTallies(statisticIds, options));
    verify(entityStatisticDefinitionDao).findByIds(isA(List.class));
    verify(entityStatisticSummaryDao)
        .generateWithCountByEntity(isA(Collection.class), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
  }

  /**
   * Test {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findStatTallies(List, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticService.findStatTallies(List, IdSelectionOptions)"})
  void testFindStatTallies4() {
    // Arrange
    ArrayList<EntityStatisticDefinition> entityStatisticDefinitionList = new ArrayList<>();
    entityStatisticDefinitionList.add(
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build());
    when(entityStatisticDefinitionDao.findByIds(Mockito.<List<Long>>any()))
        .thenReturn(entityStatisticDefinitionList);
    when(entityStatisticSummaryDao.generateWithAvgByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithCountByEntity(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithNoRollup(
            Mockito.<Collection<Long>>any(), Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithSumByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    ArrayList<Long> statisticIds = new ArrayList<>();

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
    List<TallyPack<String>> actualFindStatTalliesResult =
        entityStatisticService.findStatTallies(statisticIds, options);

    // Assert
    verify(entityStatisticDefinitionDao).findByIds(isA(List.class));
    verify(entityStatisticSummaryDao)
        .generateWithAvgByValue(isA(Collection.class), isA(Select.class));
    verify(entityStatisticSummaryDao)
        .generateWithCountByEntity(isA(Collection.class), isA(Select.class));
    verify(entityStatisticSummaryDao)
        .generateWithNoRollup(isA(Collection.class), isA(EntityReference.class));
    verify(entityStatisticSummaryDao)
        .generateWithSumByValue(isA(Collection.class), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    assertTrue(actualFindStatTalliesResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findStatTallies(List, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticService.findStatTallies(List, IdSelectionOptions)"})
  void testFindStatTallies5() {
    // Arrange
    ArrayList<EntityStatisticDefinition> entityStatisticDefinitionList = new ArrayList<>();
    entityStatisticDefinitionList.add(
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build());
    entityStatisticDefinitionList.add(
        ImmutableEntityStatisticDefinition.builder()
            .active(true)
            .category(StatisticCategory.COMPLIANCE)
            .description("The characteristics of someone or something")
            .entityVisibility(true)
            .historicRenderer("Historic Renderer")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .provenance("Provenance")
            .renderer("Renderer")
            .rollupKind(RollupKind.COUNT_BY_ENTITY)
            .rollupVisibility(true)
            .type(StatisticType.BOOLEAN)
            .build());
    when(entityStatisticDefinitionDao.findByIds(Mockito.<List<Long>>any()))
        .thenReturn(entityStatisticDefinitionList);
    when(entityStatisticSummaryDao.generateWithAvgByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithCountByEntity(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithNoRollup(
            Mockito.<Collection<Long>>any(), Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithSumByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    ArrayList<Long> statisticIds = new ArrayList<>();

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
    List<TallyPack<String>> actualFindStatTalliesResult =
        entityStatisticService.findStatTallies(statisticIds, options);

    // Assert
    verify(entityStatisticDefinitionDao).findByIds(isA(List.class));
    verify(entityStatisticSummaryDao)
        .generateWithAvgByValue(isA(Collection.class), isA(Select.class));
    verify(entityStatisticSummaryDao)
        .generateWithCountByEntity(isA(Collection.class), isA(Select.class));
    verify(entityStatisticSummaryDao)
        .generateWithNoRollup(isA(Collection.class), isA(EntityReference.class));
    verify(entityStatisticSummaryDao)
        .generateWithSumByValue(isA(Collection.class), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    assertTrue(actualFindStatTalliesResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findStatTallies(List, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticService.findStatTallies(List, IdSelectionOptions)"})
  void testFindStatTallies6() {
    // Arrange
    EntityStatisticDefinitionDao definitionDao = mock(EntityStatisticDefinitionDao.class);
    when(definitionDao.findByIds(Mockito.<List<Long>>any()))
        .thenThrow(new UnsupportedOperationException());
    EntityStatisticService entityStatisticService =
        new EntityStatisticService(
            mock(EntityStatisticValueDao.class),
            definitionDao,
            mock(EntityStatisticSummaryDao.class),
            mock(EntityStatisticDao.class));
    ArrayList<Long> statisticIds = new ArrayList<>();

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

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            entityStatisticService.findStatTallies(
                statisticIds,
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
    verify(definitionDao).findByIds(isA(List.class));
  }

  /**
   * Test {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findStatTallies(List, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticService.findStatTallies(List, IdSelectionOptions)"})
  void testFindStatTallies7() {
    // Arrange
    EntityStatisticDefinitionDao definitionDao = mock(EntityStatisticDefinitionDao.class);
    when(definitionDao.findByIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());

    EntityStatisticSummaryDao summaryDao = mock(EntityStatisticSummaryDao.class);
    when(summaryDao.generateWithAvgByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithCountByEntity(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithNoRollup(
            Mockito.<Collection<Long>>any(), Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithSumByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    EntityStatisticService entityStatisticService =
        new EntityStatisticService(
            mock(EntityStatisticValueDao.class),
            definitionDao,
            summaryDao,
            mock(EntityStatisticDao.class));
    ArrayList<Long> statisticIds = new ArrayList<>();

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
    List<TallyPack<String>> actualFindStatTalliesResult =
        entityStatisticService.findStatTallies(
            statisticIds,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(definitionDao).findByIds(isA(List.class));
    verify(summaryDao).generateWithAvgByValue(isA(Collection.class), isA(Select.class));
    verify(summaryDao).generateWithCountByEntity(isA(Collection.class), isA(Select.class));
    verify(summaryDao).generateWithNoRollup(isA(Collection.class), isA(EntityReference.class));
    verify(summaryDao).generateWithSumByValue(isA(Collection.class), isA(Select.class));
    assertTrue(actualFindStatTalliesResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findStatTallies(List, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticService.findStatTallies(List, IdSelectionOptions)"})
  void testFindStatTallies8() {
    // Arrange
    EntityStatisticDefinitionDao definitionDao = mock(EntityStatisticDefinitionDao.class);
    when(definitionDao.findByIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());

    EntityStatisticSummaryDao summaryDao = mock(EntityStatisticSummaryDao.class);
    when(summaryDao.generateWithAvgByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithCountByEntity(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithNoRollup(
            Mockito.<Collection<Long>>any(), Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithSumByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    EntityStatisticService entityStatisticService =
        new EntityStatisticService(
            mock(EntityStatisticValueDao.class),
            definitionDao,
            summaryDao,
            mock(EntityStatisticDao.class));
    ArrayList<Long> statisticIds = new ArrayList<>();

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
    List<TallyPack<String>> actualFindStatTalliesResult =
        entityStatisticService.findStatTallies(
            statisticIds,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(definitionDao).findByIds(isA(List.class));
    verify(summaryDao).generateWithAvgByValue(isA(Collection.class), isA(Select.class));
    verify(summaryDao).generateWithCountByEntity(isA(Collection.class), isA(Select.class));
    verify(summaryDao).generateWithNoRollup(isA(Collection.class), isA(EntityReference.class));
    verify(summaryDao).generateWithSumByValue(isA(Collection.class), isA(Select.class));
    assertTrue(actualFindStatTalliesResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findStatTallies(List, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticService.findStatTallies(List, IdSelectionOptions)"})
  void testFindStatTallies9() {
    // Arrange
    EntityStatisticDefinitionDao definitionDao = mock(EntityStatisticDefinitionDao.class);
    when(definitionDao.findByIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());

    EntityStatisticSummaryDao summaryDao = mock(EntityStatisticSummaryDao.class);
    when(summaryDao.generateWithAvgByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithCountByEntity(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithNoRollup(
            Mockito.<Collection<Long>>any(), Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithSumByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    EntityStatisticService entityStatisticService =
        new EntityStatisticService(
            mock(EntityStatisticValueDao.class),
            definitionDao,
            summaryDao,
            mock(EntityStatisticDao.class));
    ArrayList<Long> statisticIds = new ArrayList<>();

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
    List<TallyPack<String>> actualFindStatTalliesResult =
        entityStatisticService.findStatTallies(
            statisticIds,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(definitionDao).findByIds(isA(List.class));
    verify(summaryDao).generateWithAvgByValue(isA(Collection.class), isA(Select.class));
    verify(summaryDao).generateWithCountByEntity(isA(Collection.class), isA(Select.class));
    verify(summaryDao).generateWithNoRollup(isA(Collection.class), isA(EntityReference.class));
    verify(summaryDao).generateWithSumByValue(isA(Collection.class), isA(Select.class));
    assertTrue(actualFindStatTalliesResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findStatTallies(List, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticService.findStatTallies(List, IdSelectionOptions)"})
  void testFindStatTallies10() {
    // Arrange
    EntityStatisticDefinitionDao definitionDao = mock(EntityStatisticDefinitionDao.class);
    when(definitionDao.findByIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());

    EntityStatisticSummaryDao summaryDao = mock(EntityStatisticSummaryDao.class);
    when(summaryDao.generateWithAvgByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithCountByEntity(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithNoRollup(
            Mockito.<Collection<Long>>any(), Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithSumByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    EntityStatisticService entityStatisticService =
        new EntityStatisticService(
            mock(EntityStatisticValueDao.class),
            definitionDao,
            summaryDao,
            mock(EntityStatisticDao.class));
    ArrayList<Long> statisticIds = new ArrayList<>();

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
    List<TallyPack<String>> actualFindStatTalliesResult =
        entityStatisticService.findStatTallies(
            statisticIds,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(definitionDao).findByIds(isA(List.class));
    verify(summaryDao).generateWithAvgByValue(isA(Collection.class), isA(Select.class));
    verify(summaryDao).generateWithCountByEntity(isA(Collection.class), isA(Select.class));
    verify(summaryDao).generateWithNoRollup(isA(Collection.class), isA(EntityReference.class));
    verify(summaryDao).generateWithSumByValue(isA(Collection.class), isA(Select.class));
    assertTrue(actualFindStatTalliesResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findStatTallies(List, IdSelectionOptions); given builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticService.findStatTallies(List, IdSelectionOptions)"})
  void testFindStatTallies_givenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    when(entityStatisticDefinitionDao.findByIds(Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithAvgByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithCountByEntity(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithNoRollup(
            Mockito.<Collection<Long>>any(), Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithSumByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    ArrayList<Long> statisticIds = new ArrayList<>();

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
    List<TallyPack<String>> actualFindStatTalliesResult =
        entityStatisticService.findStatTallies(statisticIds, options);

    // Assert
    verify(entityStatisticDefinitionDao).findByIds(isA(List.class));
    verify(entityStatisticSummaryDao)
        .generateWithAvgByValue(isA(Collection.class), isA(Select.class));
    verify(entityStatisticSummaryDao)
        .generateWithCountByEntity(isA(Collection.class), isA(Select.class));
    verify(entityStatisticSummaryDao)
        .generateWithNoRollup(isA(Collection.class), isA(EntityReference.class));
    verify(entityStatisticSummaryDao)
        .generateWithSumByValue(isA(Collection.class), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    assertTrue(actualFindStatTalliesResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findStatTallies(List, IdSelectionOptions); given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticService.findStatTallies(List, IdSelectionOptions)"})
  void testFindStatTallies_givenHashSetAddActive() {
    // Arrange
    when(entityStatisticDefinitionDao.findByIds(Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithAvgByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithCountByEntity(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithNoRollup(
            Mockito.<Collection<Long>>any(), Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithSumByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    ArrayList<Long> statisticIds = new ArrayList<>();

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
    List<TallyPack<String>> actualFindStatTalliesResult =
        entityStatisticService.findStatTallies(statisticIds, options);

    // Assert
    verify(entityStatisticDefinitionDao).findByIds(isA(List.class));
    verify(entityStatisticSummaryDao)
        .generateWithAvgByValue(isA(Collection.class), isA(Select.class));
    verify(entityStatisticSummaryDao)
        .generateWithCountByEntity(isA(Collection.class), isA(Select.class));
    verify(entityStatisticSummaryDao)
        .generateWithNoRollup(isA(Collection.class), isA(EntityReference.class));
    verify(entityStatisticSummaryDao)
        .generateWithSumByValue(isA(Collection.class), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    assertTrue(actualFindStatTalliesResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findStatTallies(List, IdSelectionOptions); given HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticService.findStatTallies(List, IdSelectionOptions)"})
  void testFindStatTallies_givenHashSetAddPending() {
    // Arrange
    when(entityStatisticDefinitionDao.findByIds(Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithAvgByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithCountByEntity(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithNoRollup(
            Mockito.<Collection<Long>>any(), Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithSumByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    ArrayList<Long> statisticIds = new ArrayList<>();

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
    List<TallyPack<String>> actualFindStatTalliesResult =
        entityStatisticService.findStatTallies(statisticIds, options);

    // Assert
    verify(entityStatisticDefinitionDao).findByIds(isA(List.class));
    verify(entityStatisticSummaryDao)
        .generateWithAvgByValue(isA(Collection.class), isA(Select.class));
    verify(entityStatisticSummaryDao)
        .generateWithCountByEntity(isA(Collection.class), isA(Select.class));
    verify(entityStatisticSummaryDao)
        .generateWithNoRollup(isA(Collection.class), isA(EntityReference.class));
    verify(entityStatisticSummaryDao)
        .generateWithSumByValue(isA(Collection.class), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    assertTrue(actualFindStatTalliesResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   *   <li>When builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findStatTallies(List, IdSelectionOptions); given 'IN_HOUSE'; when builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticService.findStatTallies(List, IdSelectionOptions)"})
  void testFindStatTallies_givenInHouse_whenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    EntityStatisticDefinitionDao definitionDao = mock(EntityStatisticDefinitionDao.class);
    when(definitionDao.findByIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());

    EntityStatisticSummaryDao summaryDao = mock(EntityStatisticSummaryDao.class);
    when(summaryDao.generateWithAvgByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithCountByEntity(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithNoRollup(
            Mockito.<Collection<Long>>any(), Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithSumByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    EntityStatisticService entityStatisticService =
        new EntityStatisticService(
            mock(EntityStatisticValueDao.class),
            definitionDao,
            summaryDao,
            mock(EntityStatisticDao.class));
    ArrayList<Long> statisticIds = new ArrayList<>();

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
    List<TallyPack<String>> actualFindStatTalliesResult =
        entityStatisticService.findStatTallies(
            statisticIds,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(definitionDao).findByIds(isA(List.class));
    verify(summaryDao).generateWithAvgByValue(isA(Collection.class), isA(Select.class));
    verify(summaryDao).generateWithCountByEntity(isA(Collection.class), isA(Select.class));
    verify(summaryDao).generateWithNoRollup(isA(Collection.class), isA(EntityReference.class));
    verify(summaryDao).generateWithSumByValue(isA(Collection.class), isA(Select.class));
    assertTrue(actualFindStatTalliesResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findStatTallies(List, IdSelectionOptions); given one; when ArrayList() add one; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticService.findStatTallies(List, IdSelectionOptions)"})
  void testFindStatTallies_givenOne_whenArrayListAddOne_thenReturnEmpty() {
    // Arrange
    EntityStatisticDefinitionDao definitionDao = mock(EntityStatisticDefinitionDao.class);
    when(definitionDao.findByIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());

    EntityStatisticSummaryDao summaryDao = mock(EntityStatisticSummaryDao.class);
    when(summaryDao.generateWithAvgByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithCountByEntity(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithNoRollup(
            Mockito.<Collection<Long>>any(), Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithSumByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    EntityStatisticService entityStatisticService =
        new EntityStatisticService(
            mock(EntityStatisticValueDao.class),
            definitionDao,
            summaryDao,
            mock(EntityStatisticDao.class));

    ArrayList<Long> statisticIds = new ArrayList<>();
    statisticIds.add(1L);

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
    List<TallyPack<String>> actualFindStatTalliesResult =
        entityStatisticService.findStatTallies(
            statisticIds,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(definitionDao).findByIds(isA(List.class));
    verify(summaryDao).generateWithAvgByValue(isA(Collection.class), isA(Select.class));
    verify(summaryDao).generateWithCountByEntity(isA(Collection.class), isA(Select.class));
    verify(summaryDao).generateWithNoRollup(isA(Collection.class), isA(EntityReference.class));
    verify(summaryDao).generateWithSumByValue(isA(Collection.class), isA(Select.class));
    assertTrue(actualFindStatTalliesResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ArrayList#ArrayList()} add two.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findStatTallies(List, IdSelectionOptions); given two; when ArrayList() add two; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticService.findStatTallies(List, IdSelectionOptions)"})
  void testFindStatTallies_givenTwo_whenArrayListAddTwo_thenReturnEmpty() {
    // Arrange
    EntityStatisticDefinitionDao definitionDao = mock(EntityStatisticDefinitionDao.class);
    when(definitionDao.findByIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());

    EntityStatisticSummaryDao summaryDao = mock(EntityStatisticSummaryDao.class);
    when(summaryDao.generateWithAvgByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithCountByEntity(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithNoRollup(
            Mockito.<Collection<Long>>any(), Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithSumByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    EntityStatisticService entityStatisticService =
        new EntityStatisticService(
            mock(EntityStatisticValueDao.class),
            definitionDao,
            summaryDao,
            mock(EntityStatisticDao.class));

    ArrayList<Long> statisticIds = new ArrayList<>();
    statisticIds.add(2L);
    statisticIds.add(1L);

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
    List<TallyPack<String>> actualFindStatTalliesResult =
        entityStatisticService.findStatTallies(
            statisticIds,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(definitionDao).findByIds(isA(List.class));
    verify(summaryDao).generateWithAvgByValue(isA(Collection.class), isA(Select.class));
    verify(summaryDao).generateWithCountByEntity(isA(Collection.class), isA(Select.class));
    verify(summaryDao).generateWithNoRollup(isA(Collection.class), isA(EntityReference.class));
    verify(summaryDao).generateWithSumByValue(isA(Collection.class), isA(Select.class));
    assertTrue(actualFindStatTalliesResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findStatTallies(List, IdSelectionOptions); then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticService.findStatTallies(List, IdSelectionOptions)"})
  void testFindStatTallies_thenCallsScope() {
    // Arrange
    when(entityStatisticDefinitionDao.findByIds(Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithAvgByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithCountByEntity(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithNoRollup(
            Mockito.<Collection<Long>>any(), Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithSumByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    ArrayList<Long> statisticIds = new ArrayList<>();

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
    List<TallyPack<String>> actualFindStatTalliesResult =
        entityStatisticService.findStatTallies(statisticIds, options);

    // Assert
    verify(entityStatisticDefinitionDao).findByIds(isA(List.class));
    verify(entityStatisticSummaryDao)
        .generateWithAvgByValue(isA(Collection.class), isA(Select.class));
    verify(entityStatisticSummaryDao)
        .generateWithCountByEntity(isA(Collection.class), isA(Select.class));
    verify(entityStatisticSummaryDao)
        .generateWithNoRollup(isA(Collection.class), isA(EntityReference.class));
    verify(entityStatisticSummaryDao)
        .generateWithSumByValue(isA(Collection.class), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindStatTalliesResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findStatTallies(List, IdSelectionOptions); then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticService.findStatTallies(List, IdSelectionOptions)"})
  void testFindStatTallies_thenCallsScope2() {
    // Arrange
    when(entityStatisticDefinitionDao.findByIds(Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithAvgByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithCountByEntity(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithNoRollup(
            Mockito.<Collection<Long>>any(), Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithSumByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    ArrayList<Long> statisticIds = new ArrayList<>();

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
    List<TallyPack<String>> actualFindStatTalliesResult =
        entityStatisticService.findStatTallies(statisticIds, options);

    // Assert
    verify(entityStatisticDefinitionDao).findByIds(isA(List.class));
    verify(entityStatisticSummaryDao)
        .generateWithAvgByValue(isA(Collection.class), isA(Select.class));
    verify(entityStatisticSummaryDao)
        .generateWithCountByEntity(isA(Collection.class), isA(Select.class));
    verify(entityStatisticSummaryDao)
        .generateWithNoRollup(isA(Collection.class), isA(EntityReference.class));
    verify(entityStatisticSummaryDao)
        .generateWithSumByValue(isA(Collection.class), isA(Select.class));
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindStatTalliesResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findStatTallies(List, IdSelectionOptions); then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticService.findStatTallies(List, IdSelectionOptions)"})
  void testFindStatTallies_thenCallsScope3() {
    // Arrange
    when(entityStatisticDefinitionDao.findByIds(Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithAvgByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithCountByEntity(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithNoRollup(
            Mockito.<Collection<Long>>any(), Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    when(entityStatisticSummaryDao.generateWithSumByValue(
            Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    ArrayList<Long> statisticIds = new ArrayList<>();

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
    List<TallyPack<String>> actualFindStatTalliesResult =
        entityStatisticService.findStatTallies(statisticIds, options);

    // Assert
    verify(entityStatisticDefinitionDao).findByIds(isA(List.class));
    verify(entityStatisticSummaryDao)
        .generateWithAvgByValue(isA(Collection.class), isA(Select.class));
    verify(entityStatisticSummaryDao)
        .generateWithCountByEntity(isA(Collection.class), isA(Select.class));
    verify(entityStatisticSummaryDao)
        .generateWithNoRollup(isA(Collection.class), isA(EntityReference.class));
    verify(entityStatisticSummaryDao)
        .generateWithSumByValue(isA(Collection.class), isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindStatTalliesResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#calculateStatTally(Long, RollupKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link EntityStatisticService#calculateStatTally(Long, RollupKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatTally(Long, RollupKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TallyPack EntityStatisticService.calculateStatTally(Long, RollupKind, IdSelectionOptions)"
  })
  void testCalculateStatTally() {
    // Arrange
    when(entityStatisticSummaryDao.generateWithCountByEntity(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new UnsupportedOperationException());

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

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            entityStatisticService.calculateStatTally(
                1L,
                RollupKind.COUNT_BY_ENTITY,
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
    verify(entityStatisticSummaryDao).generateWithCountByEntity(eq(1L), isA(Select.class));
  }

  /**
   * Test {@link EntityStatisticService#calculateStatTally(Long, RollupKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link EntityStatisticService#calculateStatTally(Long, RollupKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatTally(Long, RollupKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TallyPack EntityStatisticService.calculateStatTally(Long, RollupKind, IdSelectionOptions)"
  })
  void testCalculateStatTally2() {
    // Arrange
    when(entityStatisticSummaryDao.generateWithSumByValue(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new UnsupportedOperationException());

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

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            entityStatisticService.calculateStatTally(
                1L,
                RollupKind.SUM_BY_VALUE,
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
    verify(entityStatisticSummaryDao).generateWithSumByValue(eq(1L), isA(Select.class));
  }

  /**
   * Test {@link EntityStatisticService#calculateStatTally(Long, RollupKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link EntityStatisticService#calculateStatTally(Long, RollupKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatTally(Long, RollupKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TallyPack EntityStatisticService.calculateStatTally(Long, RollupKind, IdSelectionOptions)"
  })
  void testCalculateStatTally3() {
    // Arrange
    when(entityStatisticSummaryDao.generateWithAvgByValue(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new UnsupportedOperationException());

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

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            entityStatisticService.calculateStatTally(
                1L,
                RollupKind.AVG_BY_VALUE,
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
    verify(entityStatisticSummaryDao).generateWithAvgByValue(eq(1L), isA(Select.class));
  }

  /**
   * Test {@link EntityStatisticService#calculateStatTally(Long, RollupKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link EntityStatisticService#calculateStatTally(Long, RollupKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatTally(Long, RollupKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TallyPack EntityStatisticService.calculateStatTally(Long, RollupKind, IdSelectionOptions)"
  })
  void testCalculateStatTally4() {
    // Arrange
    ImmutableTallyPack.Builder<String> builderResult = ImmutableTallyPack.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(entityStatisticSummaryDao.generateWithAvgByValue(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
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
                .lastUpdatedAt(ofResult.atStartOfDay())
                .build());

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult2
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
    TallyPack<String> actualCalculateStatTallyResult =
        entityStatisticService.calculateStatTally(
            1L,
            RollupKind.AVG_BY_VALUE,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(entityStatisticSummaryDao).generateWithAvgByValue(eq(1L), isA(Select.class));
    EntityReference entityReferenceResult = actualCalculateStatTallyResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualCalculateStatTallyResult instanceof ImmutableTallyPack);
    LocalDateTime lastUpdatedAtResult = actualCalculateStatTallyResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(actualCalculateStatTallyResult.tallies().isEmpty());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link EntityStatisticService#calculateStatTally(Long, RollupKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link EntityStatisticService#calculateStatTally(Long, RollupKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatTally(Long, RollupKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TallyPack EntityStatisticService.calculateStatTally(Long, RollupKind, IdSelectionOptions)"
  })
  void testCalculateStatTally5() {
    // Arrange
    ImmutableTallyPack.Builder<String> builderResult = ImmutableTallyPack.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(entityStatisticSummaryDao.generateWithNoRollup(
            Mockito.<Long>any(), Mockito.<EntityReference>any()))
        .thenReturn(
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
                .lastUpdatedAt(ofResult.atStartOfDay())
                .build());

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
    TallyPack<String> actualCalculateStatTallyResult =
        entityStatisticService.calculateStatTally(
            1L,
            RollupKind.NONE,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(entityStatisticSummaryDao).generateWithNoRollup(eq(1L), isA(EntityReference.class));
    EntityReference entityReferenceResult = actualCalculateStatTallyResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualCalculateStatTallyResult instanceof ImmutableTallyPack);
    LocalDateTime lastUpdatedAtResult = actualCalculateStatTallyResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(actualCalculateStatTallyResult.tallies().isEmpty());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link EntityStatisticService#calculateStatTally(Long, RollupKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link EntityStatisticService#calculateStatTally(Long, RollupKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatTally(Long, RollupKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TallyPack EntityStatisticService.calculateStatTally(Long, RollupKind, IdSelectionOptions)"
  })
  void testCalculateStatTally6() {
    // Arrange
    when(entityStatisticSummaryDao.generateWithNoRollup(
            Mockito.<Long>any(), Mockito.<EntityReference>any()))
        .thenThrow(new UnsupportedOperationException());

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

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            entityStatisticService.calculateStatTally(
                1L,
                RollupKind.NONE,
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
    verify(entityStatisticSummaryDao).generateWithNoRollup(eq(1L), isA(EntityReference.class));
  }

  /**
   * Test {@link EntityStatisticService#calculateStatTally(Long, RollupKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   *   <li>When builder addEntityLifecycleStatuses {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#calculateStatTally(Long, RollupKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test calculateStatTally(Long, RollupKind, IdSelectionOptions); given 'ACTIVE'; when builder addEntityLifecycleStatuses 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TallyPack EntityStatisticService.calculateStatTally(Long, RollupKind, IdSelectionOptions)"
  })
  void testCalculateStatTally_givenActive_whenBuilderAddEntityLifecycleStatusesActive() {
    // Arrange
    ImmutableTallyPack.Builder<String> builderResult = ImmutableTallyPack.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(entityStatisticSummaryDao.generateWithAvgByValue(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
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
                .lastUpdatedAt(ofResult.atStartOfDay())
                .build());

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();
    builderResult2.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

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
    TallyPack<String> actualCalculateStatTallyResult =
        entityStatisticService.calculateStatTally(
            1L,
            RollupKind.AVG_BY_VALUE,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(entityStatisticSummaryDao).generateWithAvgByValue(eq(1L), isA(Select.class));
    EntityReference entityReferenceResult = actualCalculateStatTallyResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualCalculateStatTallyResult instanceof ImmutableTallyPack);
    LocalDateTime lastUpdatedAtResult = actualCalculateStatTallyResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(actualCalculateStatTallyResult.tallies().isEmpty());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link EntityStatisticService#calculateStatTally(Long, RollupKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   *   <li>When builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#calculateStatTally(Long, RollupKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test calculateStatTally(Long, RollupKind, IdSelectionOptions); given 'IN_HOUSE'; when builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TallyPack EntityStatisticService.calculateStatTally(Long, RollupKind, IdSelectionOptions)"
  })
  void testCalculateStatTally_givenInHouse_whenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    ImmutableTallyPack.Builder<String> builderResult = ImmutableTallyPack.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(entityStatisticSummaryDao.generateWithAvgByValue(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
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
                .lastUpdatedAt(ofResult.atStartOfDay())
                .build());

    ImmutableSelectionFilters.Builder builderResult2 = ImmutableSelectionFilters.builder();
    builderResult2.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters filters = builderResult2.build();

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult3
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
    TallyPack<String> actualCalculateStatTallyResult =
        entityStatisticService.calculateStatTally(
            1L,
            RollupKind.AVG_BY_VALUE,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(entityStatisticSummaryDao).generateWithAvgByValue(eq(1L), isA(Select.class));
    EntityReference entityReferenceResult = actualCalculateStatTallyResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualCalculateStatTallyResult instanceof ImmutableTallyPack);
    LocalDateTime lastUpdatedAtResult = actualCalculateStatTallyResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(actualCalculateStatTallyResult.tallies().isEmpty());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link EntityStatisticService#calculateStatTally(Long, RollupKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   *   <li>When builder addEntityLifecycleStatuses {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#calculateStatTally(Long, RollupKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test calculateStatTally(Long, RollupKind, IdSelectionOptions); given 'PENDING'; when builder addEntityLifecycleStatuses 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TallyPack EntityStatisticService.calculateStatTally(Long, RollupKind, IdSelectionOptions)"
  })
  void testCalculateStatTally_givenPending_whenBuilderAddEntityLifecycleStatusesPending() {
    // Arrange
    ImmutableTallyPack.Builder<String> builderResult = ImmutableTallyPack.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(entityStatisticSummaryDao.generateWithAvgByValue(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
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
                .lastUpdatedAt(ofResult.atStartOfDay())
                .build());

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();
    builderResult2.addEntityLifecycleStatuses(EntityLifecycleStatus.PENDING);
    builderResult2.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

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
    TallyPack<String> actualCalculateStatTallyResult =
        entityStatisticService.calculateStatTally(
            1L,
            RollupKind.AVG_BY_VALUE,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(entityStatisticSummaryDao).generateWithAvgByValue(eq(1L), isA(Select.class));
    EntityReference entityReferenceResult = actualCalculateStatTallyResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualCalculateStatTallyResult instanceof ImmutableTallyPack);
    LocalDateTime lastUpdatedAtResult = actualCalculateStatTallyResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(actualCalculateStatTallyResult.tallies().isEmpty());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link EntityStatisticService#calculateStatTally(Long, RollupKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityStatisticSummaryDao#generateWithAvgByValue(Long, Select)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#calculateStatTally(Long, RollupKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test calculateStatTally(Long, RollupKind, IdSelectionOptions); then calls generateWithAvgByValue(Long, Select)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TallyPack EntityStatisticService.calculateStatTally(Long, RollupKind, IdSelectionOptions)"
  })
  void testCalculateStatTally_thenCallsGenerateWithAvgByValue() {
    // Arrange
    ImmutableTallyPack.Builder<String> builderResult = ImmutableTallyPack.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(entityStatisticSummaryDao.generateWithAvgByValue(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
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
                .lastUpdatedAt(ofResult.atStartOfDay())
                .build());

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
    TallyPack<String> actualCalculateStatTallyResult =
        entityStatisticService.calculateStatTally(
            1L,
            RollupKind.AVG_BY_VALUE,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(entityStatisticSummaryDao).generateWithAvgByValue(eq(1L), isA(Select.class));
    EntityReference entityReferenceResult = actualCalculateStatTallyResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualCalculateStatTallyResult instanceof ImmutableTallyPack);
    LocalDateTime lastUpdatedAtResult = actualCalculateStatTallyResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(actualCalculateStatTallyResult.tallies().isEmpty());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link EntityStatisticService#calculateStatTally(Long, RollupKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityStatisticSummaryDao#generateWithCountByEntity(Long, Select)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#calculateStatTally(Long, RollupKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test calculateStatTally(Long, RollupKind, IdSelectionOptions); then calls generateWithCountByEntity(Long, Select)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TallyPack EntityStatisticService.calculateStatTally(Long, RollupKind, IdSelectionOptions)"
  })
  void testCalculateStatTally_thenCallsGenerateWithCountByEntity() {
    // Arrange
    ImmutableTallyPack.Builder<String> builderResult = ImmutableTallyPack.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(entityStatisticSummaryDao.generateWithCountByEntity(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
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
                .lastUpdatedAt(ofResult.atStartOfDay())
                .build());

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
    TallyPack<String> actualCalculateStatTallyResult =
        entityStatisticService.calculateStatTally(
            1L,
            RollupKind.COUNT_BY_ENTITY,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(entityStatisticSummaryDao).generateWithCountByEntity(eq(1L), isA(Select.class));
    EntityReference entityReferenceResult = actualCalculateStatTallyResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualCalculateStatTallyResult instanceof ImmutableTallyPack);
    LocalDateTime lastUpdatedAtResult = actualCalculateStatTallyResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(actualCalculateStatTallyResult.tallies().isEmpty());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link EntityStatisticService#calculateStatTally(Long, RollupKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityStatisticSummaryDao#generateWithSumByValue(Long, Select)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#calculateStatTally(Long, RollupKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test calculateStatTally(Long, RollupKind, IdSelectionOptions); then calls generateWithSumByValue(Long, Select)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TallyPack EntityStatisticService.calculateStatTally(Long, RollupKind, IdSelectionOptions)"
  })
  void testCalculateStatTally_thenCallsGenerateWithSumByValue() {
    // Arrange
    ImmutableTallyPack.Builder<String> builderResult = ImmutableTallyPack.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(entityStatisticSummaryDao.generateWithSumByValue(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
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
                .lastUpdatedAt(ofResult.atStartOfDay())
                .build());

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
    TallyPack<String> actualCalculateStatTallyResult =
        entityStatisticService.calculateStatTally(
            1L,
            RollupKind.SUM_BY_VALUE,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(entityStatisticSummaryDao).generateWithSumByValue(eq(1L), isA(Select.class));
    EntityReference entityReferenceResult = actualCalculateStatTallyResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualCalculateStatTallyResult instanceof ImmutableTallyPack);
    LocalDateTime lastUpdatedAtResult = actualCalculateStatTallyResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(actualCalculateStatTallyResult.tallies().isEmpty());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link EntityStatisticService#calculateHistoricStatTally(Long, RollupKind,
   * IdSelectionOptions, Duration)}.
   *
   * <p>Method under test: {@link EntityStatisticService#calculateHistoricStatTally(Long,
   * RollupKind, IdSelectionOptions, Duration)}
   */
  @Test
  @DisplayName("Test calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)"
  })
  void testCalculateHistoricStatTally() {
    // Arrange
    when(entityStatisticSummaryDao.generateHistoricWithCountByEntity(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any(), Mockito.<Duration>any()))
        .thenThrow(new UnsupportedOperationException());

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

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            entityStatisticService.calculateHistoricStatTally(
                1L,
                RollupKind.COUNT_BY_ENTITY,
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build(),
                Duration.DAY));
    verify(entityStatisticSummaryDao)
        .generateHistoricWithCountByEntity(eq(1L), isA(Select.class), eq(Duration.DAY));
  }

  /**
   * Test {@link EntityStatisticService#calculateHistoricStatTally(Long, RollupKind,
   * IdSelectionOptions, Duration)}.
   *
   * <p>Method under test: {@link EntityStatisticService#calculateHistoricStatTally(Long,
   * RollupKind, IdSelectionOptions, Duration)}
   */
  @Test
  @DisplayName("Test calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)"
  })
  void testCalculateHistoricStatTally2() {
    // Arrange
    when(entityStatisticSummaryDao.generateHistoricWithSumByValue(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any(), Mockito.<Duration>any()))
        .thenThrow(new UnsupportedOperationException());

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

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            entityStatisticService.calculateHistoricStatTally(
                1L,
                RollupKind.SUM_BY_VALUE,
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build(),
                Duration.DAY));
    verify(entityStatisticSummaryDao)
        .generateHistoricWithSumByValue(eq(1L), isA(Select.class), eq(Duration.DAY));
  }

  /**
   * Test {@link EntityStatisticService#calculateHistoricStatTally(Long, RollupKind,
   * IdSelectionOptions, Duration)}.
   *
   * <p>Method under test: {@link EntityStatisticService#calculateHistoricStatTally(Long,
   * RollupKind, IdSelectionOptions, Duration)}
   */
  @Test
  @DisplayName("Test calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)"
  })
  void testCalculateHistoricStatTally3() {
    // Arrange
    when(entityStatisticSummaryDao.generateHistoricWithAvgByValue(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any(), Mockito.<Duration>any()))
        .thenThrow(new UnsupportedOperationException());

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

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            entityStatisticService.calculateHistoricStatTally(
                1L,
                RollupKind.AVG_BY_VALUE,
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build(),
                Duration.DAY));
    verify(entityStatisticSummaryDao)
        .generateHistoricWithAvgByValue(eq(1L), isA(Select.class), eq(Duration.DAY));
  }

  /**
   * Test {@link EntityStatisticService#calculateHistoricStatTally(Long, RollupKind,
   * IdSelectionOptions, Duration)}.
   *
   * <p>Method under test: {@link EntityStatisticService#calculateHistoricStatTally(Long,
   * RollupKind, IdSelectionOptions, Duration)}
   */
  @Test
  @DisplayName("Test calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)"
  })
  void testCalculateHistoricStatTally4() {
    // Arrange
    when(entityStatisticSummaryDao.generateHistoricWithAvgByValue(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any(), Mockito.<Duration>any()))
        .thenReturn(new ArrayList<>());

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
    List<TallyPack<String>> actualCalculateHistoricStatTallyResult =
        entityStatisticService.calculateHistoricStatTally(
            1L,
            RollupKind.AVG_BY_VALUE,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            Duration.DAY);

    // Assert
    verify(entityStatisticSummaryDao)
        .generateHistoricWithAvgByValue(eq(1L), isA(Select.class), eq(Duration.DAY));
    assertTrue(actualCalculateHistoricStatTallyResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#calculateHistoricStatTally(Long, RollupKind,
   * IdSelectionOptions, Duration)}.
   *
   * <p>Method under test: {@link EntityStatisticService#calculateHistoricStatTally(Long,
   * RollupKind, IdSelectionOptions, Duration)}
   */
  @Test
  @DisplayName("Test calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)"
  })
  void testCalculateHistoricStatTally5() {
    // Arrange
    when(entityStatisticSummaryDao.generateHistoricWithNoRollup(
            Mockito.<Long>any(), Mockito.<EntityReference>any(), Mockito.<Duration>any()))
        .thenThrow(new UnsupportedOperationException());

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

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            entityStatisticService.calculateHistoricStatTally(
                1L,
                RollupKind.NONE,
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build(),
                Duration.DAY));
    verify(entityStatisticSummaryDao)
        .generateHistoricWithNoRollup(eq(1L), isA(EntityReference.class), eq(Duration.DAY));
  }

  /**
   * Test {@link EntityStatisticService#calculateHistoricStatTally(Long, RollupKind,
   * IdSelectionOptions, Duration)}.
   *
   * <p>Method under test: {@link EntityStatisticService#calculateHistoricStatTally(Long,
   * RollupKind, IdSelectionOptions, Duration)}
   */
  @Test
  @DisplayName("Test calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)"
  })
  void testCalculateHistoricStatTally6() {
    // Arrange
    when(entityStatisticSummaryDao.generateHistoricWithNoRollup(
            Mockito.<Long>any(), Mockito.<EntityReference>any(), Mockito.<Duration>any()))
        .thenReturn(new ArrayList<>());

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
    List<TallyPack<String>> actualCalculateHistoricStatTallyResult =
        entityStatisticService.calculateHistoricStatTally(
            1L,
            RollupKind.NONE,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            Duration.DAY);

    // Assert
    verify(entityStatisticSummaryDao)
        .generateHistoricWithNoRollup(eq(1L), isA(EntityReference.class), eq(Duration.DAY));
    assertTrue(actualCalculateHistoricStatTallyResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#calculateHistoricStatTally(Long, RollupKind,
   * IdSelectionOptions, Duration)}.
   *
   * <p>Method under test: {@link EntityStatisticService#calculateHistoricStatTally(Long,
   * RollupKind, IdSelectionOptions, Duration)}
   */
  @Test
  @DisplayName("Test calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)"
  })
  void testCalculateHistoricStatTally7() {
    // Arrange
    when(entityStatisticSummaryDao.generateHistoricWithNoRollup(
            Mockito.<Long>any(), Mockito.<EntityReference>any(), Mockito.<Duration>any()))
        .thenReturn(new ArrayList<>());

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
    List<TallyPack<String>> actualCalculateHistoricStatTallyResult =
        entityStatisticService.calculateHistoricStatTally(
            1L,
            RollupKind.NONE,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            Duration.DAY);

    // Assert
    verify(entityStatisticSummaryDao)
        .generateHistoricWithNoRollup(eq(1L), isA(EntityReference.class), eq(Duration.DAY));
    assertTrue(actualCalculateHistoricStatTallyResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#calculateHistoricStatTally(Long, RollupKind,
   * IdSelectionOptions, Duration)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#calculateHistoricStatTally(Long,
   * RollupKind, IdSelectionOptions, Duration)}
   */
  @Test
  @DisplayName(
      "Test calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration); given 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)"
  })
  void testCalculateHistoricStatTally_givenActive() {
    // Arrange
    when(entityStatisticSummaryDao.generateHistoricWithAvgByValue(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any(), Mockito.<Duration>any()))
        .thenReturn(new ArrayList<>());

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
    List<TallyPack<String>> actualCalculateHistoricStatTallyResult =
        entityStatisticService.calculateHistoricStatTally(
            1L,
            RollupKind.AVG_BY_VALUE,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            Duration.DAY);

    // Assert
    verify(entityStatisticSummaryDao)
        .generateHistoricWithAvgByValue(eq(1L), isA(Select.class), eq(Duration.DAY));
    assertTrue(actualCalculateHistoricStatTallyResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#calculateHistoricStatTally(Long, RollupKind,
   * IdSelectionOptions, Duration)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#calculateHistoricStatTally(Long,
   * RollupKind, IdSelectionOptions, Duration)}
   */
  @Test
  @DisplayName(
      "Test calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)"
  })
  void testCalculateHistoricStatTally_givenInHouse() {
    // Arrange
    when(entityStatisticSummaryDao.generateHistoricWithAvgByValue(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any(), Mockito.<Duration>any()))
        .thenReturn(new ArrayList<>());

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
    List<TallyPack<String>> actualCalculateHistoricStatTallyResult =
        entityStatisticService.calculateHistoricStatTally(
            1L,
            RollupKind.AVG_BY_VALUE,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            Duration.DAY);

    // Assert
    verify(entityStatisticSummaryDao)
        .generateHistoricWithAvgByValue(eq(1L), isA(Select.class), eq(Duration.DAY));
    assertTrue(actualCalculateHistoricStatTallyResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#calculateHistoricStatTally(Long, RollupKind,
   * IdSelectionOptions, Duration)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#calculateHistoricStatTally(Long,
   * RollupKind, IdSelectionOptions, Duration)}
   */
  @Test
  @DisplayName(
      "Test calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)"
  })
  void testCalculateHistoricStatTally_givenPending() {
    // Arrange
    when(entityStatisticSummaryDao.generateHistoricWithAvgByValue(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any(), Mockito.<Duration>any()))
        .thenReturn(new ArrayList<>());

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
    List<TallyPack<String>> actualCalculateHistoricStatTallyResult =
        entityStatisticService.calculateHistoricStatTally(
            1L,
            RollupKind.AVG_BY_VALUE,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            Duration.DAY);

    // Assert
    verify(entityStatisticSummaryDao)
        .generateHistoricWithAvgByValue(eq(1L), isA(Select.class), eq(Duration.DAY));
    assertTrue(actualCalculateHistoricStatTallyResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#calculateHistoricStatTally(Long, RollupKind,
   * IdSelectionOptions, Duration)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityStatisticSummaryDao#generateHistoricWithAvgByValue(Long, Select,
   *       Duration)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#calculateHistoricStatTally(Long,
   * RollupKind, IdSelectionOptions, Duration)}
   */
  @Test
  @DisplayName(
      "Test calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration); then calls generateHistoricWithAvgByValue(Long, Select, Duration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)"
  })
  void testCalculateHistoricStatTally_thenCallsGenerateHistoricWithAvgByValue() {
    // Arrange
    when(entityStatisticSummaryDao.generateHistoricWithAvgByValue(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any(), Mockito.<Duration>any()))
        .thenReturn(new ArrayList<>());

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
    List<TallyPack<String>> actualCalculateHistoricStatTallyResult =
        entityStatisticService.calculateHistoricStatTally(
            1L,
            RollupKind.AVG_BY_VALUE,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            Duration.DAY);

    // Assert
    verify(entityStatisticSummaryDao)
        .generateHistoricWithAvgByValue(eq(1L), isA(Select.class), eq(Duration.DAY));
    assertTrue(actualCalculateHistoricStatTallyResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#calculateHistoricStatTally(Long, RollupKind,
   * IdSelectionOptions, Duration)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityStatisticSummaryDao#generateHistoricWithCountByEntity(Long,
   *       Select, Duration)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#calculateHistoricStatTally(Long,
   * RollupKind, IdSelectionOptions, Duration)}
   */
  @Test
  @DisplayName(
      "Test calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration); then calls generateHistoricWithCountByEntity(Long, Select, Duration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)"
  })
  void testCalculateHistoricStatTally_thenCallsGenerateHistoricWithCountByEntity() {
    // Arrange
    when(entityStatisticSummaryDao.generateHistoricWithCountByEntity(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any(), Mockito.<Duration>any()))
        .thenReturn(new ArrayList<>());

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
    List<TallyPack<String>> actualCalculateHistoricStatTallyResult =
        entityStatisticService.calculateHistoricStatTally(
            1L,
            RollupKind.COUNT_BY_ENTITY,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            Duration.DAY);

    // Assert
    verify(entityStatisticSummaryDao)
        .generateHistoricWithCountByEntity(eq(1L), isA(Select.class), eq(Duration.DAY));
    assertTrue(actualCalculateHistoricStatTallyResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#calculateHistoricStatTally(Long, RollupKind,
   * IdSelectionOptions, Duration)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityStatisticSummaryDao#generateHistoricWithNoRollup(Long,
   *       EntityReference, Duration)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#calculateHistoricStatTally(Long,
   * RollupKind, IdSelectionOptions, Duration)}
   */
  @Test
  @DisplayName(
      "Test calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration); then calls generateHistoricWithNoRollup(Long, EntityReference, Duration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)"
  })
  void testCalculateHistoricStatTally_thenCallsGenerateHistoricWithNoRollup() {
    // Arrange
    when(entityStatisticSummaryDao.generateHistoricWithNoRollup(
            Mockito.<Long>any(), Mockito.<EntityReference>any(), Mockito.<Duration>any()))
        .thenReturn(new ArrayList<>());

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
    List<TallyPack<String>> actualCalculateHistoricStatTallyResult =
        entityStatisticService.calculateHistoricStatTally(
            1L,
            RollupKind.NONE,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            Duration.DAY);

    // Assert
    verify(entityStatisticSummaryDao)
        .generateHistoricWithNoRollup(eq(1L), isA(EntityReference.class), eq(Duration.DAY));
    assertTrue(actualCalculateHistoricStatTallyResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#calculateHistoricStatTally(Long, RollupKind,
   * IdSelectionOptions, Duration)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityStatisticSummaryDao#generateHistoricWithSumByValue(Long, Select,
   *       Duration)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#calculateHistoricStatTally(Long,
   * RollupKind, IdSelectionOptions, Duration)}
   */
  @Test
  @DisplayName(
      "Test calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration); then calls generateHistoricWithSumByValue(Long, Select, Duration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityStatisticService.calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)"
  })
  void testCalculateHistoricStatTally_thenCallsGenerateHistoricWithSumByValue() {
    // Arrange
    when(entityStatisticSummaryDao.generateHistoricWithSumByValue(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any(), Mockito.<Duration>any()))
        .thenReturn(new ArrayList<>());

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
    List<TallyPack<String>> actualCalculateHistoricStatTallyResult =
        entityStatisticService.calculateHistoricStatTally(
            1L,
            RollupKind.SUM_BY_VALUE,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            Duration.DAY);

    // Assert
    verify(entityStatisticSummaryDao)
        .generateHistoricWithSumByValue(eq(1L), isA(Select.class), eq(Duration.DAY));
    assertTrue(actualCalculateHistoricStatTallyResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#getDefinitionById(long)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableEntityStatisticDefinition}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#getDefinitionById(long)}
   */
  @Test
  @DisplayName("Test getDefinitionById(long); then return ImmutableEntityStatisticDefinition")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityStatisticDefinition EntityStatisticService.getDefinitionById(long)"})
  void testGetDefinitionById_thenReturnImmutableEntityStatisticDefinition() {
    // Arrange
    when(entityStatisticDefinitionDao.getById(anyLong()))
        .thenReturn(
            ImmutableEntityStatisticDefinition.builder()
                .active(true)
                .category(StatisticCategory.COMPLIANCE)
                .description("The characteristics of someone or something")
                .entityVisibility(true)
                .historicRenderer("Historic Renderer")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .provenance("Provenance")
                .renderer("Renderer")
                .rollupKind(RollupKind.COUNT_BY_ENTITY)
                .rollupVisibility(true)
                .type(StatisticType.BOOLEAN)
                .build());

    // Act
    EntityStatisticDefinition actualDefinitionById = entityStatisticService.getDefinitionById(1L);

    // Assert
    verify(entityStatisticDefinitionDao).getById(1L);
    assertTrue(actualDefinitionById instanceof ImmutableEntityStatisticDefinition);
    assertEquals("Historic Renderer", actualDefinitionById.historicRenderer());
    assertEquals("Name", actualDefinitionById.name());
    assertEquals("Provenance", actualDefinitionById.provenance());
    assertEquals("Renderer", actualDefinitionById.renderer());
    assertEquals("The characteristics of someone or something", actualDefinitionById.description());
    assertEquals(EntityKind.ALL, actualDefinitionById.kind());
    assertEquals(RollupKind.COUNT_BY_ENTITY, actualDefinitionById.rollupKind());
    assertEquals(StatisticCategory.COMPLIANCE, actualDefinitionById.category());
    assertEquals(StatisticType.BOOLEAN, actualDefinitionById.type());
    assertTrue(actualDefinitionById.active());
    assertTrue(actualDefinitionById.entityVisibility());
    assertTrue(actualDefinitionById.rollupVisibility());
  }

  /**
   * Test {@link EntityStatisticService#getDefinitionById(long)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#getDefinitionById(long)}
   */
  @Test
  @DisplayName("Test getDefinitionById(long); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityStatisticDefinition EntityStatisticService.getDefinitionById(long)"})
  void testGetDefinitionById_thenThrowUnsupportedOperationException() {
    // Arrange
    when(entityStatisticDefinitionDao.getById(anyLong()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> entityStatisticService.getDefinitionById(1L));
    verify(entityStatisticDefinitionDao).getById(1L);
  }

  /**
   * Test {@link EntityStatisticService#findAllActiveDefinitions(boolean)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#findAllActiveDefinitions(boolean)}
   */
  @Test
  @DisplayName("Test findAllActiveDefinitions(boolean); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticService.findAllActiveDefinitions(boolean)"})
  void testFindAllActiveDefinitions_thenReturnEmpty() {
    // Arrange
    when(entityStatisticDefinitionDao.findAllActiveDefinitions(anyBoolean()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityStatisticDefinition> actualFindAllActiveDefinitionsResult =
        entityStatisticService.findAllActiveDefinitions(true);

    // Assert
    verify(entityStatisticDefinitionDao).findAllActiveDefinitions(true);
    assertTrue(actualFindAllActiveDefinitionsResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticService#findAllActiveDefinitions(boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticService#findAllActiveDefinitions(boolean)}
   */
  @Test
  @DisplayName("Test findAllActiveDefinitions(boolean); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticService.findAllActiveDefinitions(boolean)"})
  void testFindAllActiveDefinitions_thenThrowUnsupportedOperationException() {
    // Arrange
    when(entityStatisticDefinitionDao.findAllActiveDefinitions(anyBoolean()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> entityStatisticService.findAllActiveDefinitions(true));
    verify(entityStatisticDefinitionDao).findAllActiveDefinitions(true);
  }
}
