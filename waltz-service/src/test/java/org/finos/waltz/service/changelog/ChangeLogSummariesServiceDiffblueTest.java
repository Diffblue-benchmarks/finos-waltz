package org.finos.waltz.service.changelog;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.ImmutableSelectionFilters.Builder;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.tally.ChangeLogTally;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ChangeLogSummariesServiceDiffblueTest {
  /**
   * Test {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}.
   *
   * <p>Method under test: {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)"
  })
  void testFindCountByParentAndChildKindForDateRangeBySelector() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByParentAndChildKindForDateRangeBySelector(
            Mockito.<GenericSelector>any(),
            Mockito.<Date>any(),
            Mockito.<Date>any(),
            Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogSummariesService changeLogSummariesService =
        new ChangeLogSummariesService(changeLogSummariesDao);

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
    Date startDate = new Date(1L);
    Date endDate = new Date(1L);
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<ChangeLogTally> actualFindCountByParentAndChildKindForDateRangeBySelectorResult =
        changeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(
            EntityKind.APPLICATION, options, startDate, endDate, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByParentAndChildKindForDateRangeBySelector(
            isA(GenericSelector.class), isA(Date.class), isA(Date.class), isA(Optional.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    assertTrue(actualFindCountByParentAndChildKindForDateRangeBySelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}.
   *
   * <p>Method under test: {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)"
  })
  void testFindCountByParentAndChildKindForDateRangeBySelector2() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByParentAndChildKindForDateRangeBySelector(
            Mockito.<GenericSelector>any(),
            Mockito.<Date>any(),
            Mockito.<Date>any(),
            Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogSummariesService changeLogSummariesService =
        new ChangeLogSummariesService(changeLogSummariesDao);

    Builder builderResult = ImmutableSelectionFilters.builder();
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
    Date startDate = new Date(1L);
    Date endDate = new Date(1L);
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<ChangeLogTally> actualFindCountByParentAndChildKindForDateRangeBySelectorResult =
        changeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(
            EntityKind.APPLICATION, options, startDate, endDate, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByParentAndChildKindForDateRangeBySelector(
            isA(GenericSelector.class), isA(Date.class), isA(Date.class), isA(Optional.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options, atLeast(1)).filters();
    assertTrue(actualFindCountByParentAndChildKindForDateRangeBySelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}.
   *
   * <p>Method under test: {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)"
  })
  void testFindCountByParentAndChildKindForDateRangeBySelector3() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByParentAndChildKindForDateRangeBySelector(
            Mockito.<GenericSelector>any(),
            Mockito.<Date>any(),
            Mockito.<Date>any(),
            Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogSummariesService changeLogSummariesService =
        new ChangeLogSummariesService(changeLogSummariesDao);

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
    Date startDate = new Date(1L);
    Date endDate = new Date(1L);
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<ChangeLogTally> actualFindCountByParentAndChildKindForDateRangeBySelectorResult =
        changeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(
            EntityKind.APPLICATION, options, startDate, endDate, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByParentAndChildKindForDateRangeBySelector(
            isA(GenericSelector.class), isA(Date.class), isA(Date.class), isA(Optional.class));
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindCountByParentAndChildKindForDateRangeBySelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}.
   *
   * <p>Method under test: {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)"
  })
  void testFindCountByParentAndChildKindForDateRangeBySelector4() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByParentAndChildKindForDateRangeBySelector(
            Mockito.<GenericSelector>any(),
            Mockito.<Date>any(),
            Mockito.<Date>any(),
            Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogSummariesService changeLogSummariesService =
        new ChangeLogSummariesService(changeLogSummariesDao);

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
    Date startDate = new Date(1L);
    Date endDate = new Date(1L);
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<ChangeLogTally> actualFindCountByParentAndChildKindForDateRangeBySelectorResult =
        changeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(
            EntityKind.APPLICATION, options, startDate, endDate, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByParentAndChildKindForDateRangeBySelector(
            isA(GenericSelector.class), isA(Date.class), isA(Date.class), isA(Optional.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindCountByParentAndChildKindForDateRangeBySelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional); given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)"
  })
  void testFindCountByParentAndChildKindForDateRangeBySelector_givenHashSetAddActive() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByParentAndChildKindForDateRangeBySelector(
            Mockito.<GenericSelector>any(),
            Mockito.<Date>any(),
            Mockito.<Date>any(),
            Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogSummariesService changeLogSummariesService =
        new ChangeLogSummariesService(changeLogSummariesDao);

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
    Date startDate = new Date(1L);
    Date endDate = new Date(1L);
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<ChangeLogTally> actualFindCountByParentAndChildKindForDateRangeBySelectorResult =
        changeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(
            EntityKind.APPLICATION, options, startDate, endDate, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByParentAndChildKindForDateRangeBySelector(
            isA(GenericSelector.class), isA(Date.class), isA(Date.class), isA(Optional.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    assertTrue(actualFindCountByParentAndChildKindForDateRangeBySelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional); given HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)"
  })
  void testFindCountByParentAndChildKindForDateRangeBySelector_givenHashSetAddPending() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByParentAndChildKindForDateRangeBySelector(
            Mockito.<GenericSelector>any(),
            Mockito.<Date>any(),
            Mockito.<Date>any(),
            Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogSummariesService changeLogSummariesService =
        new ChangeLogSummariesService(changeLogSummariesDao);

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
    Date startDate = new Date(1L);
    Date endDate = new Date(1L);
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<ChangeLogTally> actualFindCountByParentAndChildKindForDateRangeBySelectorResult =
        changeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(
            EntityKind.APPLICATION, options, startDate, endDate, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByParentAndChildKindForDateRangeBySelector(
            isA(GenericSelector.class), isA(Date.class), isA(Date.class), isA(Optional.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    assertTrue(actualFindCountByParentAndChildKindForDateRangeBySelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional); given HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)"
  })
  void testFindCountByParentAndChildKindForDateRangeBySelector_givenHashSetAddPending2() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByParentAndChildKindForDateRangeBySelector(
            Mockito.<GenericSelector>any(),
            Mockito.<Date>any(),
            Mockito.<Date>any(),
            Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogSummariesService changeLogSummariesService =
        new ChangeLogSummariesService(changeLogSummariesDao);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
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
    Date startDate = new Date(1L);
    Date endDate = new Date(1L);
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<ChangeLogTally> actualFindCountByParentAndChildKindForDateRangeBySelectorResult =
        changeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(
            EntityKind.APPLICATION, options, startDate, endDate, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByParentAndChildKindForDateRangeBySelector(
            isA(GenericSelector.class), isA(Date.class), isA(Date.class), isA(Optional.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindCountByParentAndChildKindForDateRangeBySelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code REMOVED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional); given HashSet() add 'REMOVED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)"
  })
  void testFindCountByParentAndChildKindForDateRangeBySelector_givenHashSetAddRemoved() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByParentAndChildKindForDateRangeBySelector(
            Mockito.<GenericSelector>any(),
            Mockito.<Date>any(),
            Mockito.<Date>any(),
            Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogSummariesService changeLogSummariesService =
        new ChangeLogSummariesService(changeLogSummariesDao);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.REMOVED);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
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
    Date startDate = new Date(1L);
    Date endDate = new Date(1L);
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<ChangeLogTally> actualFindCountByParentAndChildKindForDateRangeBySelectorResult =
        changeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(
            EntityKind.APPLICATION, options, startDate, endDate, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByParentAndChildKindForDateRangeBySelector(
            isA(GenericSelector.class), isA(Date.class), isA(Date.class), isA(Optional.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindCountByParentAndChildKindForDateRangeBySelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}.
   *
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional); then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)"
  })
  void testFindCountByParentAndChildKindForDateRangeBySelector_thenCallsScope() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByParentAndChildKindForDateRangeBySelector(
            Mockito.<GenericSelector>any(),
            Mockito.<Date>any(),
            Mockito.<Date>any(),
            Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogSummariesService changeLogSummariesService =
        new ChangeLogSummariesService(changeLogSummariesDao);

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
    Date startDate = new Date(1L);
    Date endDate = new Date(1L);
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<ChangeLogTally> actualFindCountByParentAndChildKindForDateRangeBySelectorResult =
        changeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(
            EntityKind.APPLICATION, options, startDate, endDate, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByParentAndChildKindForDateRangeBySelector(
            isA(GenericSelector.class), isA(Date.class), isA(Date.class), isA(Optional.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindCountByParentAndChildKindForDateRangeBySelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_INITIATIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional); when 'CHANGE_INITIATIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)"
  })
  void testFindCountByParentAndChildKindForDateRangeBySelector_whenChangeInitiative() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByParentAndChildKindForDateRangeBySelector(
            Mockito.<GenericSelector>any(),
            Mockito.<Date>any(),
            Mockito.<Date>any(),
            Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogSummariesService changeLogSummariesService =
        new ChangeLogSummariesService(changeLogSummariesDao);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
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
    Date startDate = new Date(1L);
    Date endDate = new Date(1L);
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<ChangeLogTally> actualFindCountByParentAndChildKindForDateRangeBySelectorResult =
        changeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(
            EntityKind.CHANGE_INITIATIVE, options, startDate, endDate, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByParentAndChildKindForDateRangeBySelector(
            isA(GenericSelector.class), isA(Date.class), isA(Date.class), isA(Optional.class));
    verify(options, atLeast(1)).entityReference();
    assertTrue(actualFindCountByParentAndChildKindForDateRangeBySelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_INITIATIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional); when 'CHANGE_INITIATIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)"
  })
  void testFindCountByParentAndChildKindForDateRangeBySelector_whenChangeInitiative2() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByParentAndChildKindForDateRangeBySelector(
            Mockito.<GenericSelector>any(),
            Mockito.<Date>any(),
            Mockito.<Date>any(),
            Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogSummariesService changeLogSummariesService =
        new ChangeLogSummariesService(changeLogSummariesDao);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
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
    Date startDate = new Date(1L);
    Date endDate = new Date(1L);
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<ChangeLogTally> actualFindCountByParentAndChildKindForDateRangeBySelectorResult =
        changeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(
            EntityKind.CHANGE_INITIATIVE, options, startDate, endDate, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByParentAndChildKindForDateRangeBySelector(
            isA(GenericSelector.class), isA(Date.class), isA(Date.class), isA(Optional.class));
    verify(options, atLeast(1)).entityReference();
    assertTrue(actualFindCountByParentAndChildKindForDateRangeBySelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_UNIT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional); when 'CHANGE_UNIT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)"
  })
  void testFindCountByParentAndChildKindForDateRangeBySelector_whenChangeUnit() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByParentAndChildKindForDateRangeBySelector(
            Mockito.<GenericSelector>any(),
            Mockito.<Date>any(),
            Mockito.<Date>any(),
            Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogSummariesService changeLogSummariesService =
        new ChangeLogSummariesService(changeLogSummariesDao);

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
    Date startDate = new Date(1L);
    Date endDate = new Date(1L);
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<ChangeLogTally> actualFindCountByParentAndChildKindForDateRangeBySelectorResult =
        changeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(
            EntityKind.CHANGE_UNIT, options, startDate, endDate, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByParentAndChildKindForDateRangeBySelector(
            isA(GenericSelector.class), isA(Date.class), isA(Date.class), isA(Optional.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    assertTrue(actualFindCountByParentAndChildKindForDateRangeBySelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_UNIT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional); when 'CHANGE_UNIT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)"
  })
  void testFindCountByParentAndChildKindForDateRangeBySelector_whenChangeUnit2() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByParentAndChildKindForDateRangeBySelector(
            Mockito.<GenericSelector>any(),
            Mockito.<Date>any(),
            Mockito.<Date>any(),
            Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogSummariesService changeLogSummariesService =
        new ChangeLogSummariesService(changeLogSummariesDao);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
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
    Date startDate = new Date(1L);
    Date endDate = new Date(1L);
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<ChangeLogTally> actualFindCountByParentAndChildKindForDateRangeBySelectorResult =
        changeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(
            EntityKind.CHANGE_UNIT, options, startDate, endDate, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByParentAndChildKindForDateRangeBySelector(
            isA(GenericSelector.class), isA(Date.class), isA(Date.class), isA(Optional.class));
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindCountByParentAndChildKindForDateRangeBySelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}.
   *
   * <ul>
   *   <li>When {@code FLOW_DIAGRAM}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeLogSummariesService#findCountByParentAndChildKindForDateRangeBySelector(EntityKind,
   * IdSelectionOptions, Date, Date, Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional); when 'FLOW_DIAGRAM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(EntityKind, IdSelectionOptions, Date, Date, Optional)"
  })
  void testFindCountByParentAndChildKindForDateRangeBySelector_whenFlowDiagram() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByParentAndChildKindForDateRangeBySelector(
            Mockito.<GenericSelector>any(),
            Mockito.<Date>any(),
            Mockito.<Date>any(),
            Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogSummariesService changeLogSummariesService =
        new ChangeLogSummariesService(changeLogSummariesDao);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
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
    Date startDate = new Date(1L);
    Date endDate = new Date(1L);
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<ChangeLogTally> actualFindCountByParentAndChildKindForDateRangeBySelectorResult =
        changeLogSummariesService.findCountByParentAndChildKindForDateRangeBySelector(
            EntityKind.FLOW_DIAGRAM, options, startDate, endDate, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByParentAndChildKindForDateRangeBySelector(
            isA(GenericSelector.class), isA(Date.class), isA(Date.class), isA(Optional.class));
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindCountByParentAndChildKindForDateRangeBySelectorResult.isEmpty());
  }
}
