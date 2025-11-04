package org.finos.waltz.service.entity_statistic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.entity_statistic.EntityStatisticDao;
import org.finos.waltz.data.entity_statistic.EntityStatisticDefinitionDao;
import org.finos.waltz.data.entity_statistic.EntityStatisticSummaryDao;
import org.finos.waltz.data.entity_statistic.EntityStatisticValueDao;
import org.finos.waltz.model.Duration;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.entity_statistic.EntityStatistic;
import org.finos.waltz.model.entity_statistic.EntityStatisticDefinition;
import org.finos.waltz.model.entity_statistic.EntityStatisticValue;
import org.finos.waltz.model.entity_statistic.RollupKind;
import org.finos.waltz.model.immediate_hierarchy.ImmediateHierarchy;
import org.finos.waltz.model.immediate_hierarchy.ImmutableImmediateHierarchy;
import org.finos.waltz.model.tally.TallyPack;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityStatisticServiceDiffblueTest {
  /**
   * Method under test:
   * {@link EntityStatisticService#getRelatedStatDefinitions(long, boolean)}
   */
  @Test
  void testGetRelatedStatDefinitions() {
    // Arrange
    EntityStatisticDefinition entityStatisticDefinition = mock(EntityStatisticDefinition.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(entityStatisticDefinition.parentId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(entityStatisticDefinition.id()).thenReturn(ofResult2);

    ArrayList<EntityStatisticDefinition> entityStatisticDefinitionList = new ArrayList<>();
    entityStatisticDefinitionList.add(entityStatisticDefinition);
    EntityStatisticDefinitionDao definitionDao = mock(EntityStatisticDefinitionDao.class);
    when(definitionDao.findRelated(anyLong(), anyBoolean())).thenReturn(entityStatisticDefinitionList);

    // Act
    ImmediateHierarchy<EntityStatisticDefinition> actualRelatedStatDefinitions = (new EntityStatisticService(
        mock(EntityStatisticValueDao.class), definitionDao, mock(EntityStatisticSummaryDao.class),
        mock(EntityStatisticDao.class))).getRelatedStatDefinitions(1L, true);

    // Assert
    verify(definitionDao).findRelated(eq(1L), eq(true));
    verify(entityStatisticDefinition).id();
    verify(entityStatisticDefinition, atLeast(1)).parentId();
    assertTrue(actualRelatedStatDefinitions instanceof ImmutableImmediateHierarchy);
    assertEquals(1, actualRelatedStatDefinitions.children().size());
  }

  /**
   * Method under test:
   * {@link EntityStatisticService#getRelatedStatDefinitions(long, boolean)}
   */
  @Test
  void testGetRelatedStatDefinitions2() {
    // Arrange
    EntityStatisticDefinition entityStatisticDefinition = mock(EntityStatisticDefinition.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(entityStatisticDefinition.parentId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(entityStatisticDefinition.id()).thenReturn(ofResult2);
    EntityStatisticDefinition entityStatisticDefinition2 = mock(EntityStatisticDefinition.class);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(entityStatisticDefinition2.parentId()).thenReturn(ofResult3);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(entityStatisticDefinition2.id()).thenReturn(ofResult4);

    ArrayList<EntityStatisticDefinition> entityStatisticDefinitionList = new ArrayList<>();
    entityStatisticDefinitionList.add(entityStatisticDefinition2);
    entityStatisticDefinitionList.add(entityStatisticDefinition);
    EntityStatisticDefinitionDao definitionDao = mock(EntityStatisticDefinitionDao.class);
    when(definitionDao.findRelated(anyLong(), anyBoolean())).thenReturn(entityStatisticDefinitionList);

    // Act
    ImmediateHierarchy<EntityStatisticDefinition> actualRelatedStatDefinitions = (new EntityStatisticService(
        mock(EntityStatisticValueDao.class), definitionDao, mock(EntityStatisticSummaryDao.class),
        mock(EntityStatisticDao.class))).getRelatedStatDefinitions(1L, true);

    // Assert
    verify(definitionDao).findRelated(eq(1L), eq(true));
    verify(entityStatisticDefinition2).id();
    verify(entityStatisticDefinition).id();
    verify(entityStatisticDefinition2, atLeast(1)).parentId();
    verify(entityStatisticDefinition, atLeast(1)).parentId();
    assertTrue(actualRelatedStatDefinitions instanceof ImmutableImmediateHierarchy);
    assertEquals(entityStatisticDefinitionList, actualRelatedStatDefinitions.children());
  }

  /**
   * Method under test:
   * {@link EntityStatisticService#findStatisticsForEntity(EntityReference, boolean)}
   */
  @Test
  void testFindStatisticsForEntity() {
    // Arrange
    EntityStatisticDao statisticDao = mock(EntityStatisticDao.class);
    ArrayList<EntityStatistic> entityStatisticList = new ArrayList<>();
    when(statisticDao.findStatisticsForEntity(Mockito.<EntityReference>any(), anyBoolean()))
        .thenReturn(entityStatisticList);

    // Act
    List<EntityStatistic> actualFindStatisticsForEntityResult = (new EntityStatisticService(
        mock(EntityStatisticValueDao.class), mock(EntityStatisticDefinitionDao.class),
        mock(EntityStatisticSummaryDao.class), statisticDao)).findStatisticsForEntity(mock(EntityReference.class),
            true);

    // Assert
    verify(statisticDao).findStatisticsForEntity(isA(EntityReference.class), eq(true));
    assertTrue(actualFindStatisticsForEntityResult.isEmpty());
    assertSame(entityStatisticList, actualFindStatisticsForEntityResult);
  }

  /**
   * Method under test:
   * {@link EntityStatisticService#findStatisticsForEntity(EntityReference, boolean)}
   */
  @Test
  void testFindStatisticsForEntity2() {
    // Arrange
    EntityStatisticDao statisticDao = mock(EntityStatisticDao.class);
    when(statisticDao.findStatisticsForEntity(Mockito.<EntityReference>any(), anyBoolean()))
        .thenThrow(new UnsupportedOperationException("ref cannot be null"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new EntityStatisticService(mock(EntityStatisticValueDao.class), mock(EntityStatisticDefinitionDao.class),
            mock(EntityStatisticSummaryDao.class), statisticDao)).findStatisticsForEntity(mock(EntityReference.class),
                true));
    verify(statisticDao).findStatisticsForEntity(isA(EntityReference.class), eq(true));
  }

  /**
   * Method under test:
   * {@link EntityStatisticService#getStatisticValuesForAppIdSelector(long, IdSelectionOptions)}
   */
  @Test
  void testGetStatisticValuesForAppIdSelector() {
    // Arrange
    EntityStatisticValueDao valueDao = mock(EntityStatisticValueDao.class);
    ArrayList<EntityStatisticValue> entityStatisticValueList = new ArrayList<>();
    when(valueDao.getStatisticValuesForAppIdSelector(anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(entityStatisticValueList);
    EntityStatisticService entityStatisticService = new EntityStatisticService(valueDao,
        mock(EntityStatisticDefinitionDao.class), mock(EntityStatisticSummaryDao.class),
        mock(EntityStatisticDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<EntityStatisticValue> actualStatisticValuesForAppIdSelector = entityStatisticService
        .getStatisticValuesForAppIdSelector(1L, options);

    // Assert
    verify(valueDao).getStatisticValuesForAppIdSelector(eq(1L), isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualStatisticValuesForAppIdSelector.isEmpty());
    assertSame(entityStatisticValueList, actualStatisticValuesForAppIdSelector);
  }

  /**
   * Method under test:
   * {@link EntityStatisticService#getStatisticValuesForAppIdSelector(long, IdSelectionOptions)}
   */
  @Test
  void testGetStatisticValuesForAppIdSelector2() {
    // Arrange
    EntityStatisticValueDao valueDao = mock(EntityStatisticValueDao.class);
    when(valueDao.getStatisticValuesForAppIdSelector(anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new UnsupportedOperationException("options cannot be null"));
    EntityStatisticService entityStatisticService = new EntityStatisticService(valueDao,
        mock(EntityStatisticDefinitionDao.class), mock(EntityStatisticSummaryDao.class),
        mock(EntityStatisticDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> entityStatisticService.getStatisticValuesForAppIdSelector(1L, options));
    verify(valueDao).getStatisticValuesForAppIdSelector(eq(1L), isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Method under test:
   * {@link EntityStatisticService#getStatisticAppsForAppIdSelector(long, IdSelectionOptions)}
   */
  @Test
  void testGetStatisticAppsForAppIdSelector() {
    // Arrange
    EntityStatisticValueDao valueDao = mock(EntityStatisticValueDao.class);
    ArrayList<Application> applicationList = new ArrayList<>();
    when(valueDao.getStatisticAppsForAppIdSelector(anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(applicationList);
    EntityStatisticService entityStatisticService = new EntityStatisticService(valueDao,
        mock(EntityStatisticDefinitionDao.class), mock(EntityStatisticSummaryDao.class),
        mock(EntityStatisticDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<Application> actualStatisticAppsForAppIdSelector = entityStatisticService.getStatisticAppsForAppIdSelector(1L,
        options);

    // Assert
    verify(valueDao).getStatisticAppsForAppIdSelector(eq(1L), isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualStatisticAppsForAppIdSelector.isEmpty());
    assertSame(applicationList, actualStatisticAppsForAppIdSelector);
  }

  /**
   * Method under test:
   * {@link EntityStatisticService#getStatisticAppsForAppIdSelector(long, IdSelectionOptions)}
   */
  @Test
  void testGetStatisticAppsForAppIdSelector2() {
    // Arrange
    EntityStatisticValueDao valueDao = mock(EntityStatisticValueDao.class);
    when(valueDao.getStatisticAppsForAppIdSelector(anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new UnsupportedOperationException("options cannot be null"));
    EntityStatisticService entityStatisticService = new EntityStatisticService(valueDao,
        mock(EntityStatisticDefinitionDao.class), mock(EntityStatisticSummaryDao.class),
        mock(EntityStatisticDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> entityStatisticService.getStatisticAppsForAppIdSelector(1L, options));
    verify(valueDao).getStatisticAppsForAppIdSelector(eq(1L), isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Method under test:
   * {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}
   */
  @Test
  void testFindStatTallies() {
    // Arrange
    EntityStatisticDefinitionDao definitionDao = mock(EntityStatisticDefinitionDao.class);
    when(definitionDao.findByIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());
    EntityStatisticSummaryDao summaryDao = mock(EntityStatisticSummaryDao.class);
    when(summaryDao.generateWithAvgByValue(Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithCountByEntity(Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithNoRollup(Mockito.<Collection<Long>>any(), Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithSumByValue(Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    EntityStatisticService entityStatisticService = new EntityStatisticService(mock(EntityStatisticValueDao.class),
        definitionDao, summaryDao, mock(EntityStatisticDao.class));
    ArrayList<Long> statisticIds = new ArrayList<>();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<TallyPack<String>> actualFindStatTalliesResult = entityStatisticService.findStatTallies(statisticIds, options);

    // Assert
    verify(definitionDao).findByIds(isA(List.class));
    verify(summaryDao).generateWithAvgByValue(isA(Collection.class), isA(Select.class));
    verify(summaryDao).generateWithCountByEntity(isA(Collection.class), isA(Select.class));
    verify(summaryDao).generateWithNoRollup(isA(Collection.class), isA(EntityReference.class));
    verify(summaryDao).generateWithSumByValue(isA(Collection.class), isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindStatTalliesResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}
   */
  @Test
  void testFindStatTallies2() {
    // Arrange
    EntityStatisticDefinitionDao definitionDao = mock(EntityStatisticDefinitionDao.class);
    when(definitionDao.findByIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());
    EntityStatisticSummaryDao summaryDao = mock(EntityStatisticSummaryDao.class);
    when(summaryDao.generateWithCountByEntity(Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new UnsupportedOperationException("statisticIds cannot be null"));
    EntityStatisticService entityStatisticService = new EntityStatisticService(mock(EntityStatisticValueDao.class),
        definitionDao, summaryDao, mock(EntityStatisticDao.class));
    ArrayList<Long> statisticIds = new ArrayList<>();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> entityStatisticService.findStatTallies(statisticIds, options));
    verify(definitionDao).findByIds(isA(List.class));
    verify(summaryDao).generateWithCountByEntity(isA(Collection.class), isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Method under test:
   * {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}
   */
  @Test
  void testFindStatTallies3() {
    // Arrange
    EntityStatisticDefinition entityStatisticDefinition = mock(EntityStatisticDefinition.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(entityStatisticDefinition.id()).thenReturn(ofResult);
    when(entityStatisticDefinition.rollupKind()).thenReturn(RollupKind.COUNT_BY_ENTITY);

    ArrayList<EntityStatisticDefinition> entityStatisticDefinitionList = new ArrayList<>();
    entityStatisticDefinitionList.add(entityStatisticDefinition);
    EntityStatisticDefinitionDao definitionDao = mock(EntityStatisticDefinitionDao.class);
    when(definitionDao.findByIds(Mockito.<List<Long>>any())).thenReturn(entityStatisticDefinitionList);
    EntityStatisticSummaryDao summaryDao = mock(EntityStatisticSummaryDao.class);
    when(summaryDao.generateWithAvgByValue(Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithCountByEntity(Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithNoRollup(Mockito.<Collection<Long>>any(), Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithSumByValue(Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    EntityStatisticService entityStatisticService = new EntityStatisticService(mock(EntityStatisticValueDao.class),
        definitionDao, summaryDao, mock(EntityStatisticDao.class));
    ArrayList<Long> statisticIds = new ArrayList<>();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<TallyPack<String>> actualFindStatTalliesResult = entityStatisticService.findStatTallies(statisticIds, options);

    // Assert
    verify(definitionDao).findByIds(isA(List.class));
    verify(summaryDao).generateWithAvgByValue(isA(Collection.class), isA(Select.class));
    verify(summaryDao).generateWithCountByEntity(isA(Collection.class), isA(Select.class));
    verify(summaryDao).generateWithNoRollup(isA(Collection.class), isA(EntityReference.class));
    verify(summaryDao).generateWithSumByValue(isA(Collection.class), isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(entityStatisticDefinition).id();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    verify(entityStatisticDefinition).rollupKind();
    assertTrue(actualFindStatTalliesResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link EntityStatisticService#findStatTallies(List, IdSelectionOptions)}
   */
  @Test
  void testFindStatTallies4() {
    // Arrange
    EntityStatisticDefinition entityStatisticDefinition = mock(EntityStatisticDefinition.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(entityStatisticDefinition.id()).thenReturn(ofResult);
    when(entityStatisticDefinition.rollupKind()).thenReturn(RollupKind.COUNT_BY_ENTITY);
    EntityStatisticDefinition entityStatisticDefinition2 = mock(EntityStatisticDefinition.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(entityStatisticDefinition2.id()).thenReturn(ofResult2);
    when(entityStatisticDefinition2.rollupKind()).thenReturn(RollupKind.COUNT_BY_ENTITY);

    ArrayList<EntityStatisticDefinition> entityStatisticDefinitionList = new ArrayList<>();
    entityStatisticDefinitionList.add(entityStatisticDefinition2);
    entityStatisticDefinitionList.add(entityStatisticDefinition);
    EntityStatisticDefinitionDao definitionDao = mock(EntityStatisticDefinitionDao.class);
    when(definitionDao.findByIds(Mockito.<List<Long>>any())).thenReturn(entityStatisticDefinitionList);
    EntityStatisticSummaryDao summaryDao = mock(EntityStatisticSummaryDao.class);
    when(summaryDao.generateWithAvgByValue(Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithCountByEntity(Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithNoRollup(Mockito.<Collection<Long>>any(), Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    when(summaryDao.generateWithSumByValue(Mockito.<Collection<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    EntityStatisticService entityStatisticService = new EntityStatisticService(mock(EntityStatisticValueDao.class),
        definitionDao, summaryDao, mock(EntityStatisticDao.class));
    ArrayList<Long> statisticIds = new ArrayList<>();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<TallyPack<String>> actualFindStatTalliesResult = entityStatisticService.findStatTallies(statisticIds, options);

    // Assert
    verify(definitionDao).findByIds(isA(List.class));
    verify(summaryDao).generateWithAvgByValue(isA(Collection.class), isA(Select.class));
    verify(summaryDao).generateWithCountByEntity(isA(Collection.class), isA(Select.class));
    verify(summaryDao).generateWithNoRollup(isA(Collection.class), isA(EntityReference.class));
    verify(summaryDao).generateWithSumByValue(isA(Collection.class), isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(entityStatisticDefinition2).id();
    verify(entityStatisticDefinition).id();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    verify(entityStatisticDefinition2).rollupKind();
    verify(entityStatisticDefinition).rollupKind();
    assertTrue(actualFindStatTalliesResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link EntityStatisticService#calculateStatTally(Long, RollupKind, IdSelectionOptions)}
   */
  @Test
  void testCalculateStatTally() {
    // Arrange
    EntityStatisticSummaryDao summaryDao = mock(EntityStatisticSummaryDao.class);
    when(summaryDao.generateWithCountByEntity(Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(null);
    EntityStatisticService entityStatisticService = new EntityStatisticService(mock(EntityStatisticValueDao.class),
        mock(EntityStatisticDefinitionDao.class), summaryDao, mock(EntityStatisticDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    TallyPack<String> actualCalculateStatTallyResult = entityStatisticService.calculateStatTally(1L,
        RollupKind.COUNT_BY_ENTITY, options);

    // Assert
    verify(summaryDao).generateWithCountByEntity(eq(1L), isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertNull(actualCalculateStatTallyResult);
  }

  /**
   * Method under test:
   * {@link EntityStatisticService#calculateStatTally(Long, RollupKind, IdSelectionOptions)}
   */
  @Test
  void testCalculateStatTally2() {
    // Arrange
    EntityStatisticSummaryDao summaryDao = mock(EntityStatisticSummaryDao.class);
    when(summaryDao.generateWithSumByValue(Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any())).thenReturn(null);
    EntityStatisticService entityStatisticService = new EntityStatisticService(mock(EntityStatisticValueDao.class),
        mock(EntityStatisticDefinitionDao.class), summaryDao, mock(EntityStatisticDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    TallyPack<String> actualCalculateStatTallyResult = entityStatisticService.calculateStatTally(1L,
        RollupKind.SUM_BY_VALUE, options);

    // Assert
    verify(summaryDao).generateWithSumByValue(eq(1L), isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertNull(actualCalculateStatTallyResult);
  }

  /**
   * Method under test:
   * {@link EntityStatisticService#calculateStatTally(Long, RollupKind, IdSelectionOptions)}
   */
  @Test
  void testCalculateStatTally3() {
    // Arrange
    EntityStatisticSummaryDao summaryDao = mock(EntityStatisticSummaryDao.class);
    when(summaryDao.generateWithAvgByValue(Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any())).thenReturn(null);
    EntityStatisticService entityStatisticService = new EntityStatisticService(mock(EntityStatisticValueDao.class),
        mock(EntityStatisticDefinitionDao.class), summaryDao, mock(EntityStatisticDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    TallyPack<String> actualCalculateStatTallyResult = entityStatisticService.calculateStatTally(1L,
        RollupKind.AVG_BY_VALUE, options);

    // Assert
    verify(summaryDao).generateWithAvgByValue(eq(1L), isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertNull(actualCalculateStatTallyResult);
  }

  /**
   * Method under test:
   * {@link EntityStatisticService#calculateStatTally(Long, RollupKind, IdSelectionOptions)}
   */
  @Test
  void testCalculateStatTally4() {
    // Arrange
    EntityStatisticSummaryDao summaryDao = mock(EntityStatisticSummaryDao.class);
    when(summaryDao.generateWithNoRollup(Mockito.<Long>any(), Mockito.<EntityReference>any())).thenReturn(null);
    EntityStatisticService entityStatisticService = new EntityStatisticService(mock(EntityStatisticValueDao.class),
        mock(EntityStatisticDefinitionDao.class), summaryDao, mock(EntityStatisticDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    TallyPack<String> actualCalculateStatTallyResult = entityStatisticService.calculateStatTally(1L, RollupKind.NONE,
        options);

    // Assert
    verify(summaryDao).generateWithNoRollup(eq(1L), isA(EntityReference.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertNull(actualCalculateStatTallyResult);
  }

  /**
   * Method under test:
   * {@link EntityStatisticService#calculateStatTally(Long, RollupKind, IdSelectionOptions)}
   */
  @Test
  void testCalculateStatTally5() {
    // Arrange
    EntityStatisticSummaryDao summaryDao = mock(EntityStatisticSummaryDao.class);
    when(summaryDao.generateWithNoRollup(Mockito.<Long>any(), Mockito.<EntityReference>any()))
        .thenThrow(new UnsupportedOperationException("statisticId cannot be null"));
    EntityStatisticService entityStatisticService = new EntityStatisticService(mock(EntityStatisticValueDao.class),
        mock(EntityStatisticDefinitionDao.class), summaryDao, mock(EntityStatisticDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> entityStatisticService.calculateStatTally(1L, RollupKind.NONE, options));
    verify(summaryDao).generateWithNoRollup(eq(1L), isA(EntityReference.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Method under test:
   * {@link EntityStatisticService#calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)}
   */
  @Test
  void testCalculateHistoricStatTally() {
    // Arrange
    EntityStatisticSummaryDao summaryDao = mock(EntityStatisticSummaryDao.class);
    ArrayList<TallyPack<String>> tallyPackList = new ArrayList<>();
    when(summaryDao.generateHistoricWithCountByEntity(Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any(),
        Mockito.<Duration>any())).thenReturn(tallyPackList);
    EntityStatisticService entityStatisticService = new EntityStatisticService(mock(EntityStatisticValueDao.class),
        mock(EntityStatisticDefinitionDao.class), summaryDao, mock(EntityStatisticDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<TallyPack<String>> actualCalculateHistoricStatTallyResult = entityStatisticService
        .calculateHistoricStatTally(1L, RollupKind.COUNT_BY_ENTITY, options, Duration.DAY);

    // Assert
    verify(summaryDao).generateHistoricWithCountByEntity(eq(1L), isA(Select.class), eq(Duration.DAY));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualCalculateHistoricStatTallyResult.isEmpty());
    assertSame(tallyPackList, actualCalculateHistoricStatTallyResult);
  }

  /**
   * Method under test:
   * {@link EntityStatisticService#calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)}
   */
  @Test
  void testCalculateHistoricStatTally2() {
    // Arrange
    EntityStatisticSummaryDao summaryDao = mock(EntityStatisticSummaryDao.class);
    ArrayList<TallyPack<String>> tallyPackList = new ArrayList<>();
    when(summaryDao.generateHistoricWithSumByValue(Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any(),
        Mockito.<Duration>any())).thenReturn(tallyPackList);
    EntityStatisticService entityStatisticService = new EntityStatisticService(mock(EntityStatisticValueDao.class),
        mock(EntityStatisticDefinitionDao.class), summaryDao, mock(EntityStatisticDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<TallyPack<String>> actualCalculateHistoricStatTallyResult = entityStatisticService
        .calculateHistoricStatTally(1L, RollupKind.SUM_BY_VALUE, options, Duration.DAY);

    // Assert
    verify(summaryDao).generateHistoricWithSumByValue(eq(1L), isA(Select.class), eq(Duration.DAY));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualCalculateHistoricStatTallyResult.isEmpty());
    assertSame(tallyPackList, actualCalculateHistoricStatTallyResult);
  }

  /**
   * Method under test:
   * {@link EntityStatisticService#calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)}
   */
  @Test
  void testCalculateHistoricStatTally3() {
    // Arrange
    EntityStatisticSummaryDao summaryDao = mock(EntityStatisticSummaryDao.class);
    ArrayList<TallyPack<String>> tallyPackList = new ArrayList<>();
    when(summaryDao.generateHistoricWithAvgByValue(Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any(),
        Mockito.<Duration>any())).thenReturn(tallyPackList);
    EntityStatisticService entityStatisticService = new EntityStatisticService(mock(EntityStatisticValueDao.class),
        mock(EntityStatisticDefinitionDao.class), summaryDao, mock(EntityStatisticDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<TallyPack<String>> actualCalculateHistoricStatTallyResult = entityStatisticService
        .calculateHistoricStatTally(1L, RollupKind.AVG_BY_VALUE, options, Duration.DAY);

    // Assert
    verify(summaryDao).generateHistoricWithAvgByValue(eq(1L), isA(Select.class), eq(Duration.DAY));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualCalculateHistoricStatTallyResult.isEmpty());
    assertSame(tallyPackList, actualCalculateHistoricStatTallyResult);
  }

  /**
   * Method under test:
   * {@link EntityStatisticService#calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)}
   */
  @Test
  void testCalculateHistoricStatTally4() {
    // Arrange
    EntityStatisticSummaryDao summaryDao = mock(EntityStatisticSummaryDao.class);
    ArrayList<TallyPack<String>> tallyPackList = new ArrayList<>();
    when(summaryDao.generateHistoricWithNoRollup(Mockito.<Long>any(), Mockito.<EntityReference>any(),
        Mockito.<Duration>any())).thenReturn(tallyPackList);
    EntityStatisticService entityStatisticService = new EntityStatisticService(mock(EntityStatisticValueDao.class),
        mock(EntityStatisticDefinitionDao.class), summaryDao, mock(EntityStatisticDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<TallyPack<String>> actualCalculateHistoricStatTallyResult = entityStatisticService
        .calculateHistoricStatTally(1L, RollupKind.NONE, options, Duration.DAY);

    // Assert
    verify(summaryDao).generateHistoricWithNoRollup(eq(1L), isA(EntityReference.class), eq(Duration.DAY));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualCalculateHistoricStatTallyResult.isEmpty());
    assertSame(tallyPackList, actualCalculateHistoricStatTallyResult);
  }

  /**
   * Method under test:
   * {@link EntityStatisticService#calculateHistoricStatTally(Long, RollupKind, IdSelectionOptions, Duration)}
   */
  @Test
  void testCalculateHistoricStatTally5() {
    // Arrange
    EntityStatisticSummaryDao summaryDao = mock(EntityStatisticSummaryDao.class);
    when(summaryDao.generateHistoricWithNoRollup(Mockito.<Long>any(), Mockito.<EntityReference>any(),
        Mockito.<Duration>any())).thenThrow(new UnsupportedOperationException("statisticId cannot be null"));
    EntityStatisticService entityStatisticService = new EntityStatisticService(mock(EntityStatisticValueDao.class),
        mock(EntityStatisticDefinitionDao.class), summaryDao, mock(EntityStatisticDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> entityStatisticService.calculateHistoricStatTally(1L, RollupKind.NONE, options, Duration.DAY));
    verify(summaryDao).generateHistoricWithNoRollup(eq(1L), isA(EntityReference.class), eq(Duration.DAY));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Method under test: {@link EntityStatisticService#getDefinitionById(long)}
   */
  @Test
  void testGetDefinitionById() {
    // Arrange
    EntityStatisticDefinitionDao definitionDao = mock(EntityStatisticDefinitionDao.class);
    when(definitionDao.getById(anyLong())).thenReturn(null);

    // Act
    EntityStatisticDefinition actualDefinitionById = (new EntityStatisticService(mock(EntityStatisticValueDao.class),
        definitionDao, mock(EntityStatisticSummaryDao.class), mock(EntityStatisticDao.class))).getDefinitionById(1L);

    // Assert
    verify(definitionDao).getById(eq(1L));
    assertNull(actualDefinitionById);
  }

  /**
   * Method under test: {@link EntityStatisticService#getDefinitionById(long)}
   */
  @Test
  void testGetDefinitionById2() {
    // Arrange
    EntityStatisticDefinitionDao definitionDao = mock(EntityStatisticDefinitionDao.class);
    when(definitionDao.getById(anyLong())).thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new EntityStatisticService(mock(EntityStatisticValueDao.class), definitionDao,
            mock(EntityStatisticSummaryDao.class), mock(EntityStatisticDao.class))).getDefinitionById(1L));
    verify(definitionDao).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link EntityStatisticService#findAllActiveDefinitions(boolean)}
   */
  @Test
  void testFindAllActiveDefinitions() {
    // Arrange
    EntityStatisticDefinitionDao definitionDao = mock(EntityStatisticDefinitionDao.class);
    ArrayList<EntityStatisticDefinition> entityStatisticDefinitionList = new ArrayList<>();
    when(definitionDao.findAllActiveDefinitions(anyBoolean())).thenReturn(entityStatisticDefinitionList);

    // Act
    List<EntityStatisticDefinition> actualFindAllActiveDefinitionsResult = (new EntityStatisticService(
        mock(EntityStatisticValueDao.class), definitionDao, mock(EntityStatisticSummaryDao.class),
        mock(EntityStatisticDao.class))).findAllActiveDefinitions(true);

    // Assert
    verify(definitionDao).findAllActiveDefinitions(eq(true));
    assertTrue(actualFindAllActiveDefinitionsResult.isEmpty());
    assertSame(entityStatisticDefinitionList, actualFindAllActiveDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link EntityStatisticService#findAllActiveDefinitions(boolean)}
   */
  @Test
  void testFindAllActiveDefinitions2() {
    // Arrange
    EntityStatisticDefinitionDao definitionDao = mock(EntityStatisticDefinitionDao.class);
    when(definitionDao.findAllActiveDefinitions(anyBoolean())).thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new EntityStatisticService(mock(EntityStatisticValueDao.class), definitionDao,
            mock(EntityStatisticSummaryDao.class), mock(EntityStatisticDao.class))).findAllActiveDefinitions(true));
    verify(definitionDao).findAllActiveDefinitions(eq(true));
  }
}
