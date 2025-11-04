package org.finos.waltz.service.process_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.process_diagram.ProcessDiagramDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.process_diagram.ImmutableProcessDiagramAndEntities;
import org.finos.waltz.model.process_diagram.ProcessDiagram;
import org.finos.waltz.model.process_diagram.ProcessDiagramAndEntities;
import org.finos.waltz.model.process_diagram.ProcessDiagramEntity;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ProcessDiagramServiceDiffblueTest {
  /**
   * Method under test: {@link ProcessDiagramService#getByExternalId(String)}
   */
  @Test
  void testGetByExternalId() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.getDiagramByExternalId(Mockito.<String>any())).thenReturn(null);

    // Act
    ProcessDiagram actualByExternalId = (new ProcessDiagramService(dao)).getByExternalId("42");

    // Assert
    verify(dao).getDiagramByExternalId(eq("42"));
    assertNull(actualByExternalId);
  }

  /**
   * Method under test:
   * {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindByGenericSelector() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    HashSet<ProcessDiagram> processDiagramSet = new HashSet<>();
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(processDiagramSet);
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<ProcessDiagram> actualFindByGenericSelectorResult = processDiagramService
        .findByGenericSelector(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(entityReference).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
    assertSame(processDiagramSet, actualFindByGenericSelectorResult);
  }

  /**
   * Method under test:
   * {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindByGenericSelector2() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    HashSet<ProcessDiagram> processDiagramSet = new HashSet<>();
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(processDiagramSet);
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);
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
    Set<ProcessDiagram> actualFindByGenericSelectorResult = processDiagramService
        .findByGenericSelector(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(entityReference).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
    assertSame(processDiagramSet, actualFindByGenericSelectorResult);
  }

  /**
   * Method under test:
   * {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindByGenericSelector3() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    HashSet<ProcessDiagram> processDiagramSet = new HashSet<>();
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(processDiagramSet);
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);
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
    Set<ProcessDiagram> actualFindByGenericSelectorResult = processDiagramService
        .findByGenericSelector(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
    assertSame(processDiagramSet, actualFindByGenericSelectorResult);
  }

  /**
   * Method under test:
   * {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindByGenericSelector4() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    HashSet<ProcessDiagram> processDiagramSet = new HashSet<>();
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(processDiagramSet);
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<ProcessDiagram> actualFindByGenericSelectorResult = processDiagramService
        .findByGenericSelector(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
    assertSame(processDiagramSet, actualFindByGenericSelectorResult);
  }

  /**
   * Method under test:
   * {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindByGenericSelector5() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    HashSet<ProcessDiagram> processDiagramSet = new HashSet<>();
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(processDiagramSet);
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);
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
    Set<ProcessDiagram> actualFindByGenericSelectorResult = processDiagramService
        .findByGenericSelector(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
    assertSame(processDiagramSet, actualFindByGenericSelectorResult);
  }

  /**
   * Method under test:
   * {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindByGenericSelector6() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    HashSet<ProcessDiagram> processDiagramSet = new HashSet<>();
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(processDiagramSet);
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<ProcessDiagram> actualFindByGenericSelectorResult = processDiagramService
        .findByGenericSelector(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
    assertSame(processDiagramSet, actualFindByGenericSelectorResult);
  }

  /**
   * Method under test:
   * {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindByGenericSelector7() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    HashSet<ProcessDiagram> processDiagramSet = new HashSet<>();
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(processDiagramSet);
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<ProcessDiagram> actualFindByGenericSelectorResult = processDiagramService
        .findByGenericSelector(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
    assertSame(processDiagramSet, actualFindByGenericSelectorResult);
  }

  /**
   * Method under test:
   * {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindByGenericSelector8() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    HashSet<ProcessDiagram> processDiagramSet = new HashSet<>();
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(processDiagramSet);
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);
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
    Set<ProcessDiagram> actualFindByGenericSelectorResult = processDiagramService
        .findByGenericSelector(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
    assertSame(processDiagramSet, actualFindByGenericSelectorResult);
  }

  /**
   * Method under test:
   * {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindByGenericSelector9() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    HashSet<ProcessDiagram> processDiagramSet = new HashSet<>();
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(processDiagramSet);
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);
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
    Set<ProcessDiagram> actualFindByGenericSelectorResult = processDiagramService
        .findByGenericSelector(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
    assertSame(processDiagramSet, actualFindByGenericSelectorResult);
  }

  /**
   * Method under test:
   * {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindByGenericSelector10() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    HashSet<ProcessDiagram> processDiagramSet = new HashSet<>();
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(processDiagramSet);
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);
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
    Set<ProcessDiagram> actualFindByGenericSelectorResult = processDiagramService
        .findByGenericSelector(EntityKind.ATTESTATION, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
    assertSame(processDiagramSet, actualFindByGenericSelectorResult);
  }

  /**
   * Method under test:
   * {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindByGenericSelector11() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    HashSet<ProcessDiagram> processDiagramSet = new HashSet<>();
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(processDiagramSet);
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<ProcessDiagram> actualFindByGenericSelectorResult = processDiagramService
        .findByGenericSelector(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
    assertSame(processDiagramSet, actualFindByGenericSelectorResult);
  }

  /**
   * Method under test:
   * {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindByGenericSelector12() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    HashSet<ProcessDiagram> processDiagramSet = new HashSet<>();
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(processDiagramSet);
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.PARENTS);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<ProcessDiagram> actualFindByGenericSelectorResult = processDiagramService
        .findByGenericSelector(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
    assertSame(processDiagramSet, actualFindByGenericSelectorResult);
  }

  /**
   * Method under test:
   * {@link ProcessDiagramService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    HashSet<ProcessDiagram> processDiagramSet = new HashSet<>();
    when(dao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(processDiagramSet);
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<ProcessDiagram> actualFindBySelectorResult = processDiagramService.findBySelector(selectionOptions);

    // Assert
    verify(dao).findBySelector(isA(Select.class));
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(processDiagramSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ProcessDiagramService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector2() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    HashSet<ProcessDiagram> processDiagramSet = new HashSet<>();
    when(dao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(processDiagramSet);
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);
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
    Set<ProcessDiagram> actualFindBySelectorResult = processDiagramService.findBySelector(selectionOptions);

    // Assert
    verify(dao).findBySelector(isA(Select.class));
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(processDiagramSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ProcessDiagramService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector3() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    HashSet<ProcessDiagram> processDiagramSet = new HashSet<>();
    when(dao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(processDiagramSet);
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<ProcessDiagram> actualFindBySelectorResult = processDiagramService.findBySelector(selectionOptions);

    // Assert
    verify(dao).findBySelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(processDiagramSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ProcessDiagramService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector4() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    HashSet<ProcessDiagram> processDiagramSet = new HashSet<>();
    when(dao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(processDiagramSet);
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<ProcessDiagram> actualFindBySelectorResult = processDiagramService.findBySelector(selectionOptions);

    // Assert
    verify(dao).findBySelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(processDiagramSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ProcessDiagramService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector5() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    HashSet<ProcessDiagram> processDiagramSet = new HashSet<>();
    when(dao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(processDiagramSet);
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<ProcessDiagram> actualFindBySelectorResult = processDiagramService.findBySelector(selectionOptions);

    // Assert
    verify(dao).findBySelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(processDiagramSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ProcessDiagramService#getDiagramAndEntitiesById(long)}
   */
  @Test
  void testGetDiagramAndEntitiesById() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findDiagramEntitiesById(anyLong())).thenReturn(new HashSet<>());
    when(dao.getDiagramById(anyLong())).thenReturn(mock(ProcessDiagram.class));

    // Act
    ProcessDiagramAndEntities actualDiagramAndEntitiesById = (new ProcessDiagramService(dao))
        .getDiagramAndEntitiesById(1L);

    // Assert
    verify(dao).findDiagramEntitiesById(eq(1L));
    verify(dao).getDiagramById(eq(1L));
    assertTrue(actualDiagramAndEntitiesById instanceof ImmutableProcessDiagramAndEntities);
    assertTrue(actualDiagramAndEntitiesById.entities().isEmpty());
  }

  /**
   * Method under test:
   * {@link ProcessDiagramService#getDiagramAndEntitiesById(long)}
   */
  @Test
  void testGetDiagramAndEntitiesById2() {
    // Arrange
    HashSet<ProcessDiagramEntity> processDiagramEntitySet = new HashSet<>();
    processDiagramEntitySet.add(mock(ProcessDiagramEntity.class));
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findDiagramEntitiesById(anyLong())).thenReturn(processDiagramEntitySet);
    when(dao.getDiagramById(anyLong())).thenReturn(mock(ProcessDiagram.class));

    // Act
    ProcessDiagramAndEntities actualDiagramAndEntitiesById = (new ProcessDiagramService(dao))
        .getDiagramAndEntitiesById(1L);

    // Assert
    verify(dao).findDiagramEntitiesById(eq(1L));
    verify(dao).getDiagramById(eq(1L));
    assertTrue(actualDiagramAndEntitiesById instanceof ImmutableProcessDiagramAndEntities);
    assertEquals(1, actualDiagramAndEntitiesById.entities().size());
  }

  /**
   * Method under test:
   * {@link ProcessDiagramService#getDiagramAndEntitiesById(long)}
   */
  @Test
  void testGetDiagramAndEntitiesById3() {
    // Arrange
    HashSet<ProcessDiagramEntity> processDiagramEntitySet = new HashSet<>();
    processDiagramEntitySet.add(mock(ProcessDiagramEntity.class));
    processDiagramEntitySet.add(mock(ProcessDiagramEntity.class));
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findDiagramEntitiesById(anyLong())).thenReturn(processDiagramEntitySet);
    when(dao.getDiagramById(anyLong())).thenReturn(mock(ProcessDiagram.class));

    // Act
    ProcessDiagramAndEntities actualDiagramAndEntitiesById = (new ProcessDiagramService(dao))
        .getDiagramAndEntitiesById(1L);

    // Assert
    verify(dao).findDiagramEntitiesById(eq(1L));
    verify(dao).getDiagramById(eq(1L));
    assertTrue(actualDiagramAndEntitiesById instanceof ImmutableProcessDiagramAndEntities);
    assertEquals(processDiagramEntitySet, actualDiagramAndEntitiesById.entities());
  }
}
