package org.finos.waltz.service.legal_entity;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.legal_entity.LegalEntityRelationshipKindDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.legal_entity.LegalEntityRelKindStat;
import org.finos.waltz.model.legal_entity.LegalEntityRelationshipKind;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LegalEntityRelationshipKindServiceDiffblueTest {
  /**
   * Method under test: {@link LegalEntityRelationshipKindService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    LegalEntityRelationshipKindDao legalEntityRelationshipKindDao = mock(LegalEntityRelationshipKindDao.class);
    when(legalEntityRelationshipKindDao.getById(anyLong())).thenReturn(null);

    // Act
    LegalEntityRelationshipKind actualById = (new LegalEntityRelationshipKindService(legalEntityRelationshipKindDao))
        .getById(1L);

    // Assert
    verify(legalEntityRelationshipKindDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link LegalEntityRelationshipKindService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    LegalEntityRelationshipKindDao legalEntityRelationshipKindDao = mock(LegalEntityRelationshipKindDao.class);
    HashSet<LegalEntityRelationshipKind> legalEntityRelationshipKindSet = new HashSet<>();
    when(legalEntityRelationshipKindDao.findAll()).thenReturn(legalEntityRelationshipKindSet);

    // Act
    Set<LegalEntityRelationshipKind> actualFindAllResult = (new LegalEntityRelationshipKindService(
        legalEntityRelationshipKindDao)).findAll();

    // Assert
    verify(legalEntityRelationshipKindDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(legalEntityRelationshipKindSet, actualFindAllResult);
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipKindService#findUsageStats()}
   */
  @Test
  void testFindUsageStats() {
    // Arrange
    LegalEntityRelationshipKindDao legalEntityRelationshipKindDao = mock(LegalEntityRelationshipKindDao.class);
    HashSet<LegalEntityRelKindStat> legalEntityRelKindStatSet = new HashSet<>();
    when(legalEntityRelationshipKindDao.findUsageStats()).thenReturn(legalEntityRelKindStatSet);

    // Act
    Set<LegalEntityRelKindStat> actualFindUsageStatsResult = (new LegalEntityRelationshipKindService(
        legalEntityRelationshipKindDao)).findUsageStats();

    // Assert
    verify(legalEntityRelationshipKindDao).findUsageStats();
    assertTrue(actualFindUsageStatsResult.isEmpty());
    assertSame(legalEntityRelKindStatSet, actualFindUsageStatsResult);
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipKindService#getUsageStatsByKindAndSelector(Long, IdSelectionOptions)}
   */
  @Test
  void testGetUsageStatsByKindAndSelector() {
    // Arrange
    LegalEntityRelationshipKindDao legalEntityRelationshipKindDao = mock(LegalEntityRelationshipKindDao.class);
    when(legalEntityRelationshipKindDao.getUsageStatsByKindAndSelector(Mockito.<Long>any(),
        Mockito.<Select<Record1<Long>>>any())).thenReturn(null);
    LegalEntityRelationshipKindService legalEntityRelationshipKindService = new LegalEntityRelationshipKindService(
        legalEntityRelationshipKindDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions opts = mock(IdSelectionOptions.class);
    when(opts.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(opts.filters()).thenReturn(selectionFilters);
    when(opts.entityReference()).thenReturn(entityReference);

    // Act
    LegalEntityRelKindStat actualUsageStatsByKindAndSelector = legalEntityRelationshipKindService
        .getUsageStatsByKindAndSelector(1L, opts);

    // Assert
    verify(legalEntityRelationshipKindDao).getUsageStatsByKindAndSelector(eq(1L), isA(Select.class));
    verify(entityReference, atLeast(1)).kind();
    verify(opts).entityLifecycleStatuses();
    verify(opts, atLeast(1)).entityReference();
    verify(opts).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertNull(actualUsageStatsByKindAndSelector);
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipKindService#getUsageStatsByKindAndSelector(Long, IdSelectionOptions)}
   */
  @Test
  void testGetUsageStatsByKindAndSelector2() {
    // Arrange
    LegalEntityRelationshipKindDao legalEntityRelationshipKindDao = mock(LegalEntityRelationshipKindDao.class);
    when(legalEntityRelationshipKindDao.getUsageStatsByKindAndSelector(Mockito.<Long>any(),
        Mockito.<Select<Record1<Long>>>any())).thenReturn(null);
    LegalEntityRelationshipKindService legalEntityRelationshipKindService = new LegalEntityRelationshipKindService(
        legalEntityRelationshipKindDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<ApplicationKind> applicationKindSet = new HashSet<>();
    applicationKindSet.add(ApplicationKind.IN_HOUSE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(applicationKindSet);
    IdSelectionOptions opts = mock(IdSelectionOptions.class);
    when(opts.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(opts.filters()).thenReturn(selectionFilters);
    when(opts.entityReference()).thenReturn(entityReference);

    // Act
    LegalEntityRelKindStat actualUsageStatsByKindAndSelector = legalEntityRelationshipKindService
        .getUsageStatsByKindAndSelector(1L, opts);

    // Assert
    verify(legalEntityRelationshipKindDao).getUsageStatsByKindAndSelector(eq(1L), isA(Select.class));
    verify(entityReference, atLeast(1)).kind();
    verify(opts).entityLifecycleStatuses();
    verify(opts, atLeast(1)).entityReference();
    verify(opts, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertNull(actualUsageStatsByKindAndSelector);
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipKindService#getUsageStatsByKindAndSelector(Long, IdSelectionOptions)}
   */
  @Test
  void testGetUsageStatsByKindAndSelector3() {
    // Arrange
    LegalEntityRelationshipKindDao legalEntityRelationshipKindDao = mock(LegalEntityRelationshipKindDao.class);
    when(legalEntityRelationshipKindDao.getUsageStatsByKindAndSelector(Mockito.<Long>any(),
        Mockito.<Select<Record1<Long>>>any())).thenReturn(null);
    LegalEntityRelationshipKindService legalEntityRelationshipKindService = new LegalEntityRelationshipKindService(
        legalEntityRelationshipKindDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions opts = mock(IdSelectionOptions.class);
    when(opts.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(opts.entityReference()).thenReturn(entityReference);

    // Act
    LegalEntityRelKindStat actualUsageStatsByKindAndSelector = legalEntityRelationshipKindService
        .getUsageStatsByKindAndSelector(1L, opts);

    // Assert
    verify(legalEntityRelationshipKindDao).getUsageStatsByKindAndSelector(eq(1L), isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(opts, atLeast(1)).entityReference();
    verify(opts).scope();
    assertNull(actualUsageStatsByKindAndSelector);
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipKindService#getUsageStatsByKindAndSelector(Long, IdSelectionOptions)}
   */
  @Test
  void testGetUsageStatsByKindAndSelector4() {
    // Arrange
    LegalEntityRelationshipKindDao legalEntityRelationshipKindDao = mock(LegalEntityRelationshipKindDao.class);
    when(legalEntityRelationshipKindDao.getUsageStatsByKindAndSelector(Mockito.<Long>any(),
        Mockito.<Select<Record1<Long>>>any())).thenReturn(null);
    LegalEntityRelationshipKindService legalEntityRelationshipKindService = new LegalEntityRelationshipKindService(
        legalEntityRelationshipKindDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions opts = mock(IdSelectionOptions.class);
    when(opts.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(opts.entityReference()).thenReturn(entityReference);

    // Act
    LegalEntityRelKindStat actualUsageStatsByKindAndSelector = legalEntityRelationshipKindService
        .getUsageStatsByKindAndSelector(1L, opts);

    // Assert
    verify(legalEntityRelationshipKindDao).getUsageStatsByKindAndSelector(eq(1L), isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(opts, atLeast(1)).entityReference();
    verify(opts).scope();
    assertNull(actualUsageStatsByKindAndSelector);
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipKindService#getUsageStatsByKindAndSelector(Long, IdSelectionOptions)}
   */
  @Test
  void testGetUsageStatsByKindAndSelector5() {
    // Arrange
    LegalEntityRelationshipKindDao legalEntityRelationshipKindDao = mock(LegalEntityRelationshipKindDao.class);
    when(legalEntityRelationshipKindDao.getUsageStatsByKindAndSelector(Mockito.<Long>any(),
        Mockito.<Select<Record1<Long>>>any())).thenReturn(null);
    LegalEntityRelationshipKindService legalEntityRelationshipKindService = new LegalEntityRelationshipKindService(
        legalEntityRelationshipKindDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions opts = mock(IdSelectionOptions.class);
    when(opts.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(opts.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(opts.filters()).thenReturn(selectionFilters);
    when(opts.entityReference()).thenReturn(entityReference);

    // Act
    LegalEntityRelKindStat actualUsageStatsByKindAndSelector = legalEntityRelationshipKindService
        .getUsageStatsByKindAndSelector(1L, opts);

    // Assert
    verify(legalEntityRelationshipKindDao).getUsageStatsByKindAndSelector(eq(1L), isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(opts).entityLifecycleStatuses();
    verify(opts, atLeast(1)).entityReference();
    verify(opts).filters();
    verify(opts).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertNull(actualUsageStatsByKindAndSelector);
  }
}
