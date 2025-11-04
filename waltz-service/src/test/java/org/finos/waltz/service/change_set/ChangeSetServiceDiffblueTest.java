package org.finos.waltz.service.change_set;

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
import java.util.HashSet;
import java.util.List;
import org.finos.waltz.data.change_set.ChangeSetDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.change_set.ChangeSet;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ChangeSetServiceDiffblueTest {
  /**
   * Method under test: {@link ChangeSetService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    ChangeSetDao changeSetDao = mock(ChangeSetDao.class);
    when(changeSetDao.getById(anyLong())).thenReturn(null);

    // Act
    ChangeSet actualById = (new ChangeSetService(changeSetDao)).getById(1L);

    // Assert
    verify(changeSetDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link ChangeSetService#findByParentRef(EntityReference)}
   */
  @Test
  void testFindByParentRef() {
    // Arrange
    ChangeSetDao changeSetDao = mock(ChangeSetDao.class);
    ArrayList<ChangeSet> changeSetList = new ArrayList<>();
    when(changeSetDao.findByParentRef(Mockito.<EntityReference>any())).thenReturn(changeSetList);

    // Act
    List<ChangeSet> actualFindByParentRefResult = (new ChangeSetService(changeSetDao)).findByParentRef(null);

    // Assert
    verify(changeSetDao).findByParentRef(isNull());
    assertTrue(actualFindByParentRefResult.isEmpty());
    assertSame(changeSetList, actualFindByParentRefResult);
  }

  /**
   * Method under test:
   * {@link ChangeSetService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector() {
    // Arrange
    ChangeSetDao changeSetDao = mock(ChangeSetDao.class);
    ArrayList<ChangeSet> changeSetList = new ArrayList<>();
    when(changeSetDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(changeSetList);
    ChangeSetService changeSetService = new ChangeSetService(changeSetDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<ChangeSet> actualFindBySelectorResult = changeSetService.findBySelector(options);

    // Assert
    verify(changeSetDao).findBySelector(isA(Select.class));
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(changeSetList, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeSetService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector2() {
    // Arrange
    ChangeSetDao changeSetDao = mock(ChangeSetDao.class);
    ArrayList<ChangeSet> changeSetList = new ArrayList<>();
    when(changeSetDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(changeSetList);
    ChangeSetService changeSetService = new ChangeSetService(changeSetDao);
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
    List<ChangeSet> actualFindBySelectorResult = changeSetService.findBySelector(options);

    // Assert
    verify(changeSetDao).findBySelector(isA(Select.class));
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(changeSetList, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeSetService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector3() {
    // Arrange
    ChangeSetDao changeSetDao = mock(ChangeSetDao.class);
    ArrayList<ChangeSet> changeSetList = new ArrayList<>();
    when(changeSetDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(changeSetList);
    ChangeSetService changeSetService = new ChangeSetService(changeSetDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<ChangeSet> actualFindBySelectorResult = changeSetService.findBySelector(options);

    // Assert
    verify(changeSetDao).findBySelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(changeSetList, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeSetService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector4() {
    // Arrange
    ChangeSetDao changeSetDao = mock(ChangeSetDao.class);
    ArrayList<ChangeSet> changeSetList = new ArrayList<>();
    when(changeSetDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(changeSetList);
    ChangeSetService changeSetService = new ChangeSetService(changeSetDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<ChangeSet> actualFindBySelectorResult = changeSetService.findBySelector(options);

    // Assert
    verify(changeSetDao).findBySelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(changeSetList, actualFindBySelectorResult);
  }

  /**
   * Method under test: {@link ChangeSetService#findByPerson(String)}
   */
  @Test
  void testFindByPerson() {
    // Arrange
    ChangeSetDao changeSetDao = mock(ChangeSetDao.class);
    ArrayList<ChangeSet> changeSetList = new ArrayList<>();
    when(changeSetDao.findByPerson(Mockito.<String>any())).thenReturn(changeSetList);

    // Act
    List<ChangeSet> actualFindByPersonResult = (new ChangeSetService(changeSetDao)).findByPerson("42");

    // Assert
    verify(changeSetDao).findByPerson(eq("42"));
    assertTrue(actualFindByPersonResult.isEmpty());
    assertSame(changeSetList, actualFindByPersonResult);
  }
}
