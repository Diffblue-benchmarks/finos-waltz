package org.finos.waltz.service.measurable_category;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.measurable_category.MeasurableCategoryAlignmentViewDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.measurable.MeasurableCategoryAlignment;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MeasurableCategoryAlignmentViewServiceDiffblueTest {
  /**
   * Method under test:
   * {@link MeasurableCategoryAlignmentViewService#findAlignmentsByAppSelector(IdSelectionOptions)}
   */
  @Test
  void testFindAlignmentsByAppSelector() {
    // Arrange
    MeasurableCategoryAlignmentViewDao measurableCategoryAlignmentViewDao = mock(
        MeasurableCategoryAlignmentViewDao.class);
    HashSet<MeasurableCategoryAlignment> measurableCategoryAlignmentSet = new HashSet<>();
    when(measurableCategoryAlignmentViewDao.findAlignmentsByAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(measurableCategoryAlignmentSet);
    MeasurableCategoryAlignmentViewService measurableCategoryAlignmentViewService = new MeasurableCategoryAlignmentViewService(
        measurableCategoryAlignmentViewDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    Set<MeasurableCategoryAlignment> actualFindAlignmentsByAppSelectorResult = measurableCategoryAlignmentViewService
        .findAlignmentsByAppSelector(options);

    // Assert
    verify(measurableCategoryAlignmentViewDao).findAlignmentsByAppSelector(isA(Select.class));
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindAlignmentsByAppSelectorResult.isEmpty());
    assertSame(measurableCategoryAlignmentSet, actualFindAlignmentsByAppSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableCategoryAlignmentViewService#findAlignmentsByAppSelector(IdSelectionOptions)}
   */
  @Test
  void testFindAlignmentsByAppSelector2() {
    // Arrange
    MeasurableCategoryAlignmentViewDao measurableCategoryAlignmentViewDao = mock(
        MeasurableCategoryAlignmentViewDao.class);
    HashSet<MeasurableCategoryAlignment> measurableCategoryAlignmentSet = new HashSet<>();
    when(measurableCategoryAlignmentViewDao.findAlignmentsByAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(measurableCategoryAlignmentSet);
    MeasurableCategoryAlignmentViewService measurableCategoryAlignmentViewService = new MeasurableCategoryAlignmentViewService(
        measurableCategoryAlignmentViewDao);
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
    Set<MeasurableCategoryAlignment> actualFindAlignmentsByAppSelectorResult = measurableCategoryAlignmentViewService
        .findAlignmentsByAppSelector(options);

    // Assert
    verify(measurableCategoryAlignmentViewDao).findAlignmentsByAppSelector(isA(Select.class));
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertTrue(actualFindAlignmentsByAppSelectorResult.isEmpty());
    assertSame(measurableCategoryAlignmentSet, actualFindAlignmentsByAppSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableCategoryAlignmentViewService#findAlignmentsByAppSelector(IdSelectionOptions)}
   */
  @Test
  void testFindAlignmentsByAppSelector3() {
    // Arrange
    MeasurableCategoryAlignmentViewDao measurableCategoryAlignmentViewDao = mock(
        MeasurableCategoryAlignmentViewDao.class);
    HashSet<MeasurableCategoryAlignment> measurableCategoryAlignmentSet = new HashSet<>();
    when(measurableCategoryAlignmentViewDao.findAlignmentsByAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(measurableCategoryAlignmentSet);
    MeasurableCategoryAlignmentViewService measurableCategoryAlignmentViewService = new MeasurableCategoryAlignmentViewService(
        measurableCategoryAlignmentViewDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    Set<MeasurableCategoryAlignment> actualFindAlignmentsByAppSelectorResult = measurableCategoryAlignmentViewService
        .findAlignmentsByAppSelector(options);

    // Assert
    verify(measurableCategoryAlignmentViewDao).findAlignmentsByAppSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindAlignmentsByAppSelectorResult.isEmpty());
    assertSame(measurableCategoryAlignmentSet, actualFindAlignmentsByAppSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableCategoryAlignmentViewService#findAlignmentsByAppSelector(IdSelectionOptions)}
   */
  @Test
  void testFindAlignmentsByAppSelector4() {
    // Arrange
    MeasurableCategoryAlignmentViewDao measurableCategoryAlignmentViewDao = mock(
        MeasurableCategoryAlignmentViewDao.class);
    HashSet<MeasurableCategoryAlignment> measurableCategoryAlignmentSet = new HashSet<>();
    when(measurableCategoryAlignmentViewDao.findAlignmentsByAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(measurableCategoryAlignmentSet);
    MeasurableCategoryAlignmentViewService measurableCategoryAlignmentViewService = new MeasurableCategoryAlignmentViewService(
        measurableCategoryAlignmentViewDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    Set<MeasurableCategoryAlignment> actualFindAlignmentsByAppSelectorResult = measurableCategoryAlignmentViewService
        .findAlignmentsByAppSelector(options);

    // Assert
    verify(measurableCategoryAlignmentViewDao).findAlignmentsByAppSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindAlignmentsByAppSelectorResult.isEmpty());
    assertSame(measurableCategoryAlignmentSet, actualFindAlignmentsByAppSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableCategoryAlignmentViewService#findAlignmentsByAppSelector(IdSelectionOptions)}
   */
  @Test
  void testFindAlignmentsByAppSelector5() {
    // Arrange
    MeasurableCategoryAlignmentViewDao measurableCategoryAlignmentViewDao = mock(
        MeasurableCategoryAlignmentViewDao.class);
    HashSet<MeasurableCategoryAlignment> measurableCategoryAlignmentSet = new HashSet<>();
    when(measurableCategoryAlignmentViewDao.findAlignmentsByAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(measurableCategoryAlignmentSet);
    MeasurableCategoryAlignmentViewService measurableCategoryAlignmentViewService = new MeasurableCategoryAlignmentViewService(
        measurableCategoryAlignmentViewDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    Set<MeasurableCategoryAlignment> actualFindAlignmentsByAppSelectorResult = measurableCategoryAlignmentViewService
        .findAlignmentsByAppSelector(options);

    // Assert
    verify(measurableCategoryAlignmentViewDao).findAlignmentsByAppSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindAlignmentsByAppSelectorResult.isEmpty());
    assertSame(measurableCategoryAlignmentSet, actualFindAlignmentsByAppSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableCategoryAlignmentViewService#findAlignmentsByAppSelector(IdSelectionOptions)}
   */
  @Test
  void testFindAlignmentsByAppSelector6() {
    // Arrange
    MeasurableCategoryAlignmentViewDao measurableCategoryAlignmentViewDao = mock(
        MeasurableCategoryAlignmentViewDao.class);
    HashSet<MeasurableCategoryAlignment> measurableCategoryAlignmentSet = new HashSet<>();
    when(measurableCategoryAlignmentViewDao.findAlignmentsByAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(measurableCategoryAlignmentSet);
    MeasurableCategoryAlignmentViewService measurableCategoryAlignmentViewService = new MeasurableCategoryAlignmentViewService(
        measurableCategoryAlignmentViewDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    Set<MeasurableCategoryAlignment> actualFindAlignmentsByAppSelectorResult = measurableCategoryAlignmentViewService
        .findAlignmentsByAppSelector(options);

    // Assert
    verify(measurableCategoryAlignmentViewDao).findAlignmentsByAppSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindAlignmentsByAppSelectorResult.isEmpty());
    assertSame(measurableCategoryAlignmentSet, actualFindAlignmentsByAppSelectorResult);
  }
}
