package org.finos.waltz.service.complexity_kind;

import static org.junit.jupiter.api.Assertions.assertNull;
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
import org.finos.waltz.data.complexity.ComplexityKindDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.complexity.ComplexityKind;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ComplexityKindServiceDiffblueTest {
  /**
   * Method under test: {@link ComplexityKindService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    HashSet<ComplexityKind> complexityKindSet = new HashSet<>();
    when(complexityKindDao.findAll()).thenReturn(complexityKindSet);

    // Act
    Set<ComplexityKind> actualFindAllResult = (new ComplexityKindService(complexityKindDao)).findAll();

    // Assert
    verify(complexityKindDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(complexityKindSet, actualFindAllResult);
  }

  /**
   * Method under test: {@link ComplexityKindService#getById(Long)}
   */
  @Test
  void testGetById() {
    // Arrange
    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    when(complexityKindDao.getById(Mockito.<Long>any())).thenReturn(null);

    // Act
    ComplexityKind actualById = (new ComplexityKindService(complexityKindDao)).getById(1L);

    // Assert
    verify(complexityKindDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test:
   * {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindBySelector() {
    // Arrange
    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    HashSet<ComplexityKind> complexityKindSet = new HashSet<>();
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(complexityKindSet);
    ComplexityKindService complexityKindService = new ComplexityKindService(complexityKindDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<ComplexityKind> actualFindBySelectorResult = complexityKindService.findBySelector(EntityKind.APPLICATION,
        selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(entityReference).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(complexityKindSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindBySelector2() {
    // Arrange
    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    HashSet<ComplexityKind> complexityKindSet = new HashSet<>();
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(complexityKindSet);
    ComplexityKindService complexityKindService = new ComplexityKindService(complexityKindDao);
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
    Set<ComplexityKind> actualFindBySelectorResult = complexityKindService.findBySelector(EntityKind.APPLICATION,
        selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(entityReference).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(complexityKindSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindBySelector3() {
    // Arrange
    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    HashSet<ComplexityKind> complexityKindSet = new HashSet<>();
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(complexityKindSet);
    ComplexityKindService complexityKindService = new ComplexityKindService(complexityKindDao);
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
    Set<ComplexityKind> actualFindBySelectorResult = complexityKindService.findBySelector(EntityKind.APPLICATION,
        selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(complexityKindSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindBySelector4() {
    // Arrange
    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    HashSet<ComplexityKind> complexityKindSet = new HashSet<>();
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(complexityKindSet);
    ComplexityKindService complexityKindService = new ComplexityKindService(complexityKindDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<ComplexityKind> actualFindBySelectorResult = complexityKindService.findBySelector(EntityKind.APPLICATION,
        selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(complexityKindSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindBySelector5() {
    // Arrange
    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    HashSet<ComplexityKind> complexityKindSet = new HashSet<>();
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(complexityKindSet);
    ComplexityKindService complexityKindService = new ComplexityKindService(complexityKindDao);
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
    Set<ComplexityKind> actualFindBySelectorResult = complexityKindService.findBySelector(EntityKind.APPLICATION,
        selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(complexityKindSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindBySelector6() {
    // Arrange
    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    HashSet<ComplexityKind> complexityKindSet = new HashSet<>();
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(complexityKindSet);
    ComplexityKindService complexityKindService = new ComplexityKindService(complexityKindDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<ComplexityKind> actualFindBySelectorResult = complexityKindService.findBySelector(EntityKind.CHANGE_INITIATIVE,
        selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(complexityKindSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindBySelector7() {
    // Arrange
    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    HashSet<ComplexityKind> complexityKindSet = new HashSet<>();
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(complexityKindSet);
    ComplexityKindService complexityKindService = new ComplexityKindService(complexityKindDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<ComplexityKind> actualFindBySelectorResult = complexityKindService.findBySelector(EntityKind.CHANGE_INITIATIVE,
        selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(complexityKindSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindBySelector8() {
    // Arrange
    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    HashSet<ComplexityKind> complexityKindSet = new HashSet<>();
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(complexityKindSet);
    ComplexityKindService complexityKindService = new ComplexityKindService(complexityKindDao);
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
    Set<ComplexityKind> actualFindBySelectorResult = complexityKindService.findBySelector(EntityKind.CHANGE_INITIATIVE,
        selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(complexityKindSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindBySelector9() {
    // Arrange
    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    HashSet<ComplexityKind> complexityKindSet = new HashSet<>();
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(complexityKindSet);
    ComplexityKindService complexityKindService = new ComplexityKindService(complexityKindDao);
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
    Set<ComplexityKind> actualFindBySelectorResult = complexityKindService.findBySelector(EntityKind.CHANGE_INITIATIVE,
        selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(complexityKindSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindBySelector10() {
    // Arrange
    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    HashSet<ComplexityKind> complexityKindSet = new HashSet<>();
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(complexityKindSet);
    ComplexityKindService complexityKindService = new ComplexityKindService(complexityKindDao);
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
    Set<ComplexityKind> actualFindBySelectorResult = complexityKindService.findBySelector(EntityKind.ATTESTATION,
        selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(complexityKindSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindBySelector11() {
    // Arrange
    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    HashSet<ComplexityKind> complexityKindSet = new HashSet<>();
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(complexityKindSet);
    ComplexityKindService complexityKindService = new ComplexityKindService(complexityKindDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<ComplexityKind> actualFindBySelectorResult = complexityKindService.findBySelector(EntityKind.CHANGE_INITIATIVE,
        selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(complexityKindSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindBySelector12() {
    // Arrange
    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    HashSet<ComplexityKind> complexityKindSet = new HashSet<>();
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(complexityKindSet);
    ComplexityKindService complexityKindService = new ComplexityKindService(complexityKindDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.PARENTS);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<ComplexityKind> actualFindBySelectorResult = complexityKindService.findBySelector(EntityKind.CHANGE_INITIATIVE,
        selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(complexityKindSet, actualFindBySelectorResult);
  }
}
