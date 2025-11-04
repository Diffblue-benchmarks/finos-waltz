package org.finos.waltz.service.changelog;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.tally.ChangeLogTally;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ChangeLogSummariesServiceDiffblueTest {
  /**
   * Method under test:
   * {@link ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)}
   */
  @Test
  void testFindCountByParentAndChildKindForDateRangeBySelector() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    ArrayList<ChangeLogTally> changeLogTallyList = new ArrayList<>();
    when(changeLogSummariesDao.findCountByParentAndChildKindForDateRangeBySelector(Mockito.<GenericSelector>any(),
        Mockito.<Date>any(), Mockito.<Date>any(), Mockito.<Optional<Integer>>any())).thenReturn(changeLogTallyList);
    ChangeLogSummariesService changeLogSummariesService = new ChangeLogSummariesService(changeLogSummariesDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);
    Date startDate = mock(Date.class);
    Date endDate = mock(Date.class);
    Optional<Integer> limit = Optional.<Integer>of(3);

    // Act
    List<ChangeLogTally> actualFindCountByParentAndChildKindForDateRangeBySelectorResult = changeLogSummariesService
        .findCountByParentAndChildKindForDateRangeBySelector(EntityKind.APPLICATION, options, startDate, endDate,
            limit);

    // Assert
    verify(changeLogSummariesDao).findCountByParentAndChildKindForDateRangeBySelector(isA(GenericSelector.class),
        isA(Date.class), isA(Date.class), isA(Optional.class));
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindCountByParentAndChildKindForDateRangeBySelectorResult.isEmpty());
    assertSame(changeLogTallyList, actualFindCountByParentAndChildKindForDateRangeBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)}
   */
  @Test
  void testFindCountByParentAndChildKindForDateRangeBySelector2() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    ArrayList<ChangeLogTally> changeLogTallyList = new ArrayList<>();
    when(changeLogSummariesDao.findCountByParentAndChildKindForDateRangeBySelector(Mockito.<GenericSelector>any(),
        Mockito.<Date>any(), Mockito.<Date>any(), Mockito.<Optional<Integer>>any())).thenReturn(changeLogTallyList);
    ChangeLogSummariesService changeLogSummariesService = new ChangeLogSummariesService(changeLogSummariesDao);
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
    Date startDate = mock(Date.class);
    Date endDate = mock(Date.class);
    Optional<Integer> limit = Optional.<Integer>of(3);

    // Act
    List<ChangeLogTally> actualFindCountByParentAndChildKindForDateRangeBySelectorResult = changeLogSummariesService
        .findCountByParentAndChildKindForDateRangeBySelector(EntityKind.APPLICATION, options, startDate, endDate,
            limit);

    // Assert
    verify(changeLogSummariesDao).findCountByParentAndChildKindForDateRangeBySelector(isA(GenericSelector.class),
        isA(Date.class), isA(Date.class), isA(Optional.class));
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertTrue(actualFindCountByParentAndChildKindForDateRangeBySelectorResult.isEmpty());
    assertSame(changeLogTallyList, actualFindCountByParentAndChildKindForDateRangeBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)}
   */
  @Test
  void testFindCountByParentAndChildKindForDateRangeBySelector3() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    ArrayList<ChangeLogTally> changeLogTallyList = new ArrayList<>();
    when(changeLogSummariesDao.findCountByParentAndChildKindForDateRangeBySelector(Mockito.<GenericSelector>any(),
        Mockito.<Date>any(), Mockito.<Date>any(), Mockito.<Optional<Integer>>any())).thenReturn(changeLogTallyList);
    ChangeLogSummariesService changeLogSummariesService = new ChangeLogSummariesService(changeLogSummariesDao);
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
    Date startDate = mock(Date.class);
    Date endDate = mock(Date.class);
    Optional<Integer> limit = Optional.<Integer>of(3);

    // Act
    List<ChangeLogTally> actualFindCountByParentAndChildKindForDateRangeBySelectorResult = changeLogSummariesService
        .findCountByParentAndChildKindForDateRangeBySelector(EntityKind.APPLICATION, options, startDate, endDate,
            limit);

    // Assert
    verify(changeLogSummariesDao).findCountByParentAndChildKindForDateRangeBySelector(isA(GenericSelector.class),
        isA(Date.class), isA(Date.class), isA(Optional.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindCountByParentAndChildKindForDateRangeBySelectorResult.isEmpty());
    assertSame(changeLogTallyList, actualFindCountByParentAndChildKindForDateRangeBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)}
   */
  @Test
  void testFindCountByParentAndChildKindForDateRangeBySelector4() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    ArrayList<ChangeLogTally> changeLogTallyList = new ArrayList<>();
    when(changeLogSummariesDao.findCountByParentAndChildKindForDateRangeBySelector(Mockito.<GenericSelector>any(),
        Mockito.<Date>any(), Mockito.<Date>any(), Mockito.<Optional<Integer>>any())).thenReturn(changeLogTallyList);
    ChangeLogSummariesService changeLogSummariesService = new ChangeLogSummariesService(changeLogSummariesDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);
    Date startDate = mock(Date.class);
    Date endDate = mock(Date.class);
    Optional<Integer> limit = Optional.<Integer>of(3);

    // Act
    List<ChangeLogTally> actualFindCountByParentAndChildKindForDateRangeBySelectorResult = changeLogSummariesService
        .findCountByParentAndChildKindForDateRangeBySelector(EntityKind.APPLICATION, options, startDate, endDate,
            limit);

    // Assert
    verify(changeLogSummariesDao).findCountByParentAndChildKindForDateRangeBySelector(isA(GenericSelector.class),
        isA(Date.class), isA(Date.class), isA(Optional.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindCountByParentAndChildKindForDateRangeBySelectorResult.isEmpty());
    assertSame(changeLogTallyList, actualFindCountByParentAndChildKindForDateRangeBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)}
   */
  @Test
  void testFindCountByParentAndChildKindForDateRangeBySelector5() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    ArrayList<ChangeLogTally> changeLogTallyList = new ArrayList<>();
    when(changeLogSummariesDao.findCountByParentAndChildKindForDateRangeBySelector(Mockito.<GenericSelector>any(),
        Mockito.<Date>any(), Mockito.<Date>any(), Mockito.<Optional<Integer>>any())).thenReturn(changeLogTallyList);
    ChangeLogSummariesService changeLogSummariesService = new ChangeLogSummariesService(changeLogSummariesDao);
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
    Date startDate = mock(Date.class);
    Date endDate = mock(Date.class);
    Optional<Integer> limit = Optional.<Integer>of(3);

    // Act
    List<ChangeLogTally> actualFindCountByParentAndChildKindForDateRangeBySelectorResult = changeLogSummariesService
        .findCountByParentAndChildKindForDateRangeBySelector(EntityKind.APPLICATION, options, startDate, endDate,
            limit);

    // Assert
    verify(changeLogSummariesDao).findCountByParentAndChildKindForDateRangeBySelector(isA(GenericSelector.class),
        isA(Date.class), isA(Date.class), isA(Optional.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindCountByParentAndChildKindForDateRangeBySelectorResult.isEmpty());
    assertSame(changeLogTallyList, actualFindCountByParentAndChildKindForDateRangeBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)}
   */
  @Test
  void testFindCountByParentAndChildKindForDateRangeBySelector6() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    ArrayList<ChangeLogTally> changeLogTallyList = new ArrayList<>();
    when(changeLogSummariesDao.findCountByParentAndChildKindForDateRangeBySelector(Mockito.<GenericSelector>any(),
        Mockito.<Date>any(), Mockito.<Date>any(), Mockito.<Optional<Integer>>any())).thenReturn(changeLogTallyList);
    ChangeLogSummariesService changeLogSummariesService = new ChangeLogSummariesService(changeLogSummariesDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);
    Date startDate = mock(Date.class);
    Date endDate = mock(Date.class);
    Optional<Integer> limit = Optional.<Integer>of(3);

    // Act
    List<ChangeLogTally> actualFindCountByParentAndChildKindForDateRangeBySelectorResult = changeLogSummariesService
        .findCountByParentAndChildKindForDateRangeBySelector(EntityKind.CHANGE_INITIATIVE, options, startDate, endDate,
            limit);

    // Assert
    verify(changeLogSummariesDao).findCountByParentAndChildKindForDateRangeBySelector(isA(GenericSelector.class),
        isA(Date.class), isA(Date.class), isA(Optional.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
    assertTrue(actualFindCountByParentAndChildKindForDateRangeBySelectorResult.isEmpty());
    assertSame(changeLogTallyList, actualFindCountByParentAndChildKindForDateRangeBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)}
   */
  @Test
  void testFindCountByParentAndChildKindForDateRangeBySelector7() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    ArrayList<ChangeLogTally> changeLogTallyList = new ArrayList<>();
    when(changeLogSummariesDao.findCountByParentAndChildKindForDateRangeBySelector(Mockito.<GenericSelector>any(),
        Mockito.<Date>any(), Mockito.<Date>any(), Mockito.<Optional<Integer>>any())).thenReturn(changeLogTallyList);
    ChangeLogSummariesService changeLogSummariesService = new ChangeLogSummariesService(changeLogSummariesDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);
    Date startDate = mock(Date.class);
    Date endDate = mock(Date.class);
    Optional<Integer> limit = Optional.<Integer>of(3);

    // Act
    List<ChangeLogTally> actualFindCountByParentAndChildKindForDateRangeBySelectorResult = changeLogSummariesService
        .findCountByParentAndChildKindForDateRangeBySelector(EntityKind.CHANGE_INITIATIVE, options, startDate, endDate,
            limit);

    // Assert
    verify(changeLogSummariesDao).findCountByParentAndChildKindForDateRangeBySelector(isA(GenericSelector.class),
        isA(Date.class), isA(Date.class), isA(Optional.class));
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
    assertTrue(actualFindCountByParentAndChildKindForDateRangeBySelectorResult.isEmpty());
    assertSame(changeLogTallyList, actualFindCountByParentAndChildKindForDateRangeBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)}
   */
  @Test
  void testFindCountByParentAndChildKindForDateRangeBySelector8() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    ArrayList<ChangeLogTally> changeLogTallyList = new ArrayList<>();
    when(changeLogSummariesDao.findCountByParentAndChildKindForDateRangeBySelector(Mockito.<GenericSelector>any(),
        Mockito.<Date>any(), Mockito.<Date>any(), Mockito.<Optional<Integer>>any())).thenReturn(changeLogTallyList);
    ChangeLogSummariesService changeLogSummariesService = new ChangeLogSummariesService(changeLogSummariesDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(mock(SelectionFilters.class));
    when(options.entityReference()).thenReturn(entityReference);
    Date startDate = mock(Date.class);
    Date endDate = mock(Date.class);
    Optional<Integer> limit = Optional.<Integer>of(3);

    // Act
    List<ChangeLogTally> actualFindCountByParentAndChildKindForDateRangeBySelectorResult = changeLogSummariesService
        .findCountByParentAndChildKindForDateRangeBySelector(EntityKind.CHANGE_INITIATIVE, options, startDate, endDate,
            limit);

    // Assert
    verify(changeLogSummariesDao).findCountByParentAndChildKindForDateRangeBySelector(isA(GenericSelector.class),
        isA(Date.class), isA(Date.class), isA(Optional.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
    assertTrue(actualFindCountByParentAndChildKindForDateRangeBySelectorResult.isEmpty());
    assertSame(changeLogTallyList, actualFindCountByParentAndChildKindForDateRangeBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)}
   */
  @Test
  void testFindCountByParentAndChildKindForDateRangeBySelector9() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    ArrayList<ChangeLogTally> changeLogTallyList = new ArrayList<>();
    when(changeLogSummariesDao.findCountByParentAndChildKindForDateRangeBySelector(Mockito.<GenericSelector>any(),
        Mockito.<Date>any(), Mockito.<Date>any(), Mockito.<Optional<Integer>>any())).thenReturn(changeLogTallyList);
    ChangeLogSummariesService changeLogSummariesService = new ChangeLogSummariesService(changeLogSummariesDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(mock(SelectionFilters.class));
    when(options.entityReference()).thenReturn(entityReference);
    Date startDate = mock(Date.class);
    Date endDate = mock(Date.class);
    Optional<Integer> limit = Optional.<Integer>of(3);

    // Act
    List<ChangeLogTally> actualFindCountByParentAndChildKindForDateRangeBySelectorResult = changeLogSummariesService
        .findCountByParentAndChildKindForDateRangeBySelector(EntityKind.CHANGE_INITIATIVE, options, startDate, endDate,
            limit);

    // Assert
    verify(changeLogSummariesDao).findCountByParentAndChildKindForDateRangeBySelector(isA(GenericSelector.class),
        isA(Date.class), isA(Date.class), isA(Optional.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
    assertTrue(actualFindCountByParentAndChildKindForDateRangeBySelectorResult.isEmpty());
    assertSame(changeLogTallyList, actualFindCountByParentAndChildKindForDateRangeBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)}
   */
  @Test
  void testFindCountByParentAndChildKindForDateRangeBySelector10() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    ArrayList<ChangeLogTally> changeLogTallyList = new ArrayList<>();
    when(changeLogSummariesDao.findCountByParentAndChildKindForDateRangeBySelector(Mockito.<GenericSelector>any(),
        Mockito.<Date>any(), Mockito.<Date>any(), Mockito.<Optional<Integer>>any())).thenReturn(changeLogTallyList);
    ChangeLogSummariesService changeLogSummariesService = new ChangeLogSummariesService(changeLogSummariesDao);
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
    Date startDate = mock(Date.class);
    Date endDate = mock(Date.class);
    Optional<Integer> limit = Optional.<Integer>of(3);

    // Act
    List<ChangeLogTally> actualFindCountByParentAndChildKindForDateRangeBySelectorResult = changeLogSummariesService
        .findCountByParentAndChildKindForDateRangeBySelector(EntityKind.ATTESTATION, options, startDate, endDate,
            limit);

    // Assert
    verify(changeLogSummariesDao).findCountByParentAndChildKindForDateRangeBySelector(isA(GenericSelector.class),
        isA(Date.class), isA(Date.class), isA(Optional.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindCountByParentAndChildKindForDateRangeBySelectorResult.isEmpty());
    assertSame(changeLogTallyList, actualFindCountByParentAndChildKindForDateRangeBySelectorResult);
  }
}
