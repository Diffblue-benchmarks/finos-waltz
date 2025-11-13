package org.finos.waltz.service.database_information;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.finos.waltz.data.database_information.DatabaseInformationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.LifecycleStatus;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.database_information.DatabaseInformation;
import org.finos.waltz.model.database_information.DatabaseSummaryStatistics;
import org.finos.waltz.model.database_information.ImmutableDatabaseInformation;
import org.finos.waltz.model.database_information.ImmutableDatabaseSummaryStatistics;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.tally.Tally;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DatabaseInformationServiceDiffblueTest {
  /**
   * Test {@link DatabaseInformationService#findByApplicationId(Long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseInformationService#findByApplicationId(Long)}
   */
  @Test
  @DisplayName("Test findByApplicationId(Long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseInformationService.findByApplicationId(Long)"})
  void testFindByApplicationId_thenReturnEmpty() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.findByApplicationId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    List<DatabaseInformation> actualFindByApplicationIdResult =
        new DatabaseInformationService(databaseInformationDao).findByApplicationId(1L);

    // Assert
    verify(databaseInformationDao).findByApplicationId(1L);
    assertTrue(actualFindByApplicationIdResult.isEmpty());
  }

  /**
   * Test {@link DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByApplicationSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DatabaseInformationService.findByApplicationSelector(IdSelectionOptions)"
  })
  void testFindByApplicationSelector() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.findByAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashMap<>());
    DatabaseInformationService databaseInformationService =
        new DatabaseInformationService(databaseInformationDao);

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
    Map<Long, List<DatabaseInformation>> actualFindByApplicationSelectorResult =
        databaseInformationService.findByApplicationSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(databaseInformationDao).findByAppSelector(isA(Select.class));
    assertTrue(actualFindByApplicationSelectorResult.isEmpty());
  }

  /**
   * Test {@link DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByApplicationSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DatabaseInformationService.findByApplicationSelector(IdSelectionOptions)"
  })
  void testFindByApplicationSelector2() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.findByAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashMap<>());
    DatabaseInformationService databaseInformationService =
        new DatabaseInformationService(databaseInformationDao);

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
    Map<Long, List<DatabaseInformation>> actualFindByApplicationSelectorResult =
        databaseInformationService.findByApplicationSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(databaseInformationDao).findByAppSelector(isA(Select.class));
    assertTrue(actualFindByApplicationSelectorResult.isEmpty());
  }

  /**
   * Test {@link DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByApplicationSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DatabaseInformationService.findByApplicationSelector(IdSelectionOptions)"
  })
  void testFindByApplicationSelector3() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.findByAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashMap<>());
    DatabaseInformationService databaseInformationService =
        new DatabaseInformationService(databaseInformationDao);

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
    Map<Long, List<DatabaseInformation>> actualFindByApplicationSelectorResult =
        databaseInformationService.findByApplicationSelector(options);

    // Assert
    verify(databaseInformationDao).findByAppSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    assertTrue(actualFindByApplicationSelectorResult.isEmpty());
  }

  /**
   * Test {@link DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByApplicationSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DatabaseInformationService.findByApplicationSelector(IdSelectionOptions)"
  })
  void testFindByApplicationSelector4() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.findByAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashMap<>());
    DatabaseInformationService databaseInformationService =
        new DatabaseInformationService(databaseInformationDao);

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
    Map<Long, List<DatabaseInformation>> actualFindByApplicationSelectorResult =
        databaseInformationService.findByApplicationSelector(options);

    // Assert
    verify(databaseInformationDao).findByAppSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindByApplicationSelectorResult.isEmpty());
  }

  /**
   * Test {@link DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByApplicationSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DatabaseInformationService.findByApplicationSelector(IdSelectionOptions)"
  })
  void testFindByApplicationSelector5() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.findByAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashMap<>());
    DatabaseInformationService databaseInformationService =
        new DatabaseInformationService(databaseInformationDao);

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
    Map<Long, List<DatabaseInformation>> actualFindByApplicationSelectorResult =
        databaseInformationService.findByApplicationSelector(options);

    // Assert
    verify(databaseInformationDao).findByAppSelector(isA(Select.class));
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindByApplicationSelectorResult.isEmpty());
  }

  /**
   * Test {@link DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByApplicationSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DatabaseInformationService.findByApplicationSelector(IdSelectionOptions)"
  })
  void testFindByApplicationSelector6() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.findByAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashMap<>());
    DatabaseInformationService databaseInformationService =
        new DatabaseInformationService(databaseInformationDao);

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
    Map<Long, List<DatabaseInformation>> actualFindByApplicationSelectorResult =
        databaseInformationService.findByApplicationSelector(options);

    // Assert
    verify(databaseInformationDao).findByAppSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindByApplicationSelectorResult.isEmpty());
  }

  /**
   * Test {@link DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByApplicationSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DatabaseInformationService.findByApplicationSelector(IdSelectionOptions)"
  })
  void testFindByApplicationSelector7() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.findByAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashMap<>());
    DatabaseInformationService databaseInformationService =
        new DatabaseInformationService(databaseInformationDao);

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
    Map<Long, List<DatabaseInformation>> actualFindByApplicationSelectorResult =
        databaseInformationService.findByApplicationSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(databaseInformationDao).findByAppSelector(isA(Select.class));
    assertTrue(actualFindByApplicationSelectorResult.isEmpty());
  }

  /**
   * Test {@link DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByApplicationSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DatabaseInformationService.findByApplicationSelector(IdSelectionOptions)"
  })
  void testFindByApplicationSelector8() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.findByAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashMap<>());
    DatabaseInformationService databaseInformationService =
        new DatabaseInformationService(databaseInformationDao);

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
    Map<Long, List<DatabaseInformation>> actualFindByApplicationSelectorResult =
        databaseInformationService.findByApplicationSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(databaseInformationDao).findByAppSelector(isA(Select.class));
    assertTrue(actualFindByApplicationSelectorResult.isEmpty());
  }

  /**
   * Test {@link DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByApplicationSelector(IdSelectionOptions); given 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DatabaseInformationService.findByApplicationSelector(IdSelectionOptions)"
  })
  void testFindByApplicationSelector_givenActive() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.findByAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashMap<>());
    DatabaseInformationService databaseInformationService =
        new DatabaseInformationService(databaseInformationDao);

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
    Map<Long, List<DatabaseInformation>> actualFindByApplicationSelectorResult =
        databaseInformationService.findByApplicationSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(databaseInformationDao).findByAppSelector(isA(Select.class));
    assertTrue(actualFindByApplicationSelectorResult.isEmpty());
  }

  /**
   * Test {@link DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByApplicationSelector(IdSelectionOptions); given builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DatabaseInformationService.findByApplicationSelector(IdSelectionOptions)"
  })
  void testFindByApplicationSelector_givenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.findByAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashMap<>());
    DatabaseInformationService databaseInformationService =
        new DatabaseInformationService(databaseInformationDao);

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
    Map<Long, List<DatabaseInformation>> actualFindByApplicationSelectorResult =
        databaseInformationService.findByApplicationSelector(options);

    // Assert
    verify(databaseInformationDao).findByAppSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options, atLeast(1)).filters();
    assertTrue(actualFindByApplicationSelectorResult.isEmpty());
  }

  /**
   * Test {@link DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByApplicationSelector(IdSelectionOptions); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DatabaseInformationService.findByApplicationSelector(IdSelectionOptions)"
  })
  void testFindByApplicationSelector_givenInHouse() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.findByAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashMap<>());
    DatabaseInformationService databaseInformationService =
        new DatabaseInformationService(databaseInformationDao);

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
    Map<Long, List<DatabaseInformation>> actualFindByApplicationSelectorResult =
        databaseInformationService.findByApplicationSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(databaseInformationDao).findByAppSelector(isA(Select.class));
    assertTrue(actualFindByApplicationSelectorResult.isEmpty());
  }

  /**
   * Test {@link DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DatabaseInformationService#findByApplicationSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByApplicationSelector(IdSelectionOptions); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DatabaseInformationService.findByApplicationSelector(IdSelectionOptions)"
  })
  void testFindByApplicationSelector_givenPending() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.findByAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashMap<>());
    DatabaseInformationService databaseInformationService =
        new DatabaseInformationService(databaseInformationDao);

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
    Map<Long, List<DatabaseInformation>> actualFindByApplicationSelectorResult =
        databaseInformationService.findByApplicationSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(databaseInformationDao).findByAppSelector(isA(Select.class));
    assertTrue(actualFindByApplicationSelectorResult.isEmpty());
  }

  /**
   * Test {@link DatabaseInformationService#calculateStatsForAppIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * DatabaseInformationService#calculateStatsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatsForAppIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DatabaseSummaryStatistics DatabaseInformationService.calculateStatsForAppIdSelector(IdSelectionOptions)"
  })
  void testCalculateStatsForAppIdSelector() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(ImmutableDatabaseSummaryStatistics.builder().build());
    DatabaseInformationService databaseInformationService =
        new DatabaseInformationService(databaseInformationDao);

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
    DatabaseSummaryStatistics actualCalculateStatsForAppIdSelectorResult =
        databaseInformationService.calculateStatsForAppIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(databaseInformationDao).calculateStatsForAppSelector(isA(Select.class));
    assertTrue(
        actualCalculateStatsForAppIdSelectorResult instanceof ImmutableDatabaseSummaryStatistics);
    List<Tally<String>> endOfLifeStatusCountsResult =
        actualCalculateStatsForAppIdSelectorResult.endOfLifeStatusCounts();
    assertTrue(endOfLifeStatusCountsResult.isEmpty());
    assertSame(
        endOfLifeStatusCountsResult,
        actualCalculateStatsForAppIdSelectorResult.environmentCounts());
    assertSame(
        endOfLifeStatusCountsResult, actualCalculateStatsForAppIdSelectorResult.vendorCounts());
  }

  /**
   * Test {@link DatabaseInformationService#calculateStatsForAppIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * DatabaseInformationService#calculateStatsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatsForAppIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DatabaseSummaryStatistics DatabaseInformationService.calculateStatsForAppIdSelector(IdSelectionOptions)"
  })
  void testCalculateStatsForAppIdSelector2() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(ImmutableDatabaseSummaryStatistics.builder().build());
    DatabaseInformationService databaseInformationService =
        new DatabaseInformationService(databaseInformationDao);

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
    DatabaseSummaryStatistics actualCalculateStatsForAppIdSelectorResult =
        databaseInformationService.calculateStatsForAppIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(databaseInformationDao).calculateStatsForAppSelector(isA(Select.class));
    assertTrue(
        actualCalculateStatsForAppIdSelectorResult instanceof ImmutableDatabaseSummaryStatistics);
    List<Tally<String>> endOfLifeStatusCountsResult =
        actualCalculateStatsForAppIdSelectorResult.endOfLifeStatusCounts();
    assertTrue(endOfLifeStatusCountsResult.isEmpty());
    assertSame(
        endOfLifeStatusCountsResult,
        actualCalculateStatsForAppIdSelectorResult.environmentCounts());
    assertSame(
        endOfLifeStatusCountsResult, actualCalculateStatsForAppIdSelectorResult.vendorCounts());
  }

  /**
   * Test {@link DatabaseInformationService#calculateStatsForAppIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * DatabaseInformationService#calculateStatsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatsForAppIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DatabaseSummaryStatistics DatabaseInformationService.calculateStatsForAppIdSelector(IdSelectionOptions)"
  })
  void testCalculateStatsForAppIdSelector3() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(ImmutableDatabaseSummaryStatistics.builder().build());
    DatabaseInformationService databaseInformationService =
        new DatabaseInformationService(databaseInformationDao);

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
    DatabaseSummaryStatistics actualCalculateStatsForAppIdSelectorResult =
        databaseInformationService.calculateStatsForAppIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(databaseInformationDao).calculateStatsForAppSelector(isA(Select.class));
    assertTrue(
        actualCalculateStatsForAppIdSelectorResult instanceof ImmutableDatabaseSummaryStatistics);
    List<Tally<String>> endOfLifeStatusCountsResult =
        actualCalculateStatsForAppIdSelectorResult.endOfLifeStatusCounts();
    assertTrue(endOfLifeStatusCountsResult.isEmpty());
    assertSame(
        endOfLifeStatusCountsResult,
        actualCalculateStatsForAppIdSelectorResult.environmentCounts());
    assertSame(
        endOfLifeStatusCountsResult, actualCalculateStatsForAppIdSelectorResult.vendorCounts());
  }

  /**
   * Test {@link DatabaseInformationService#calculateStatsForAppIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * DatabaseInformationService#calculateStatsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatsForAppIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DatabaseSummaryStatistics DatabaseInformationService.calculateStatsForAppIdSelector(IdSelectionOptions)"
  })
  void testCalculateStatsForAppIdSelector4() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(ImmutableDatabaseSummaryStatistics.builder().build());
    DatabaseInformationService databaseInformationService =
        new DatabaseInformationService(databaseInformationDao);

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
    DatabaseSummaryStatistics actualCalculateStatsForAppIdSelectorResult =
        databaseInformationService.calculateStatsForAppIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(databaseInformationDao).calculateStatsForAppSelector(isA(Select.class));
    assertTrue(
        actualCalculateStatsForAppIdSelectorResult instanceof ImmutableDatabaseSummaryStatistics);
    List<Tally<String>> endOfLifeStatusCountsResult =
        actualCalculateStatsForAppIdSelectorResult.endOfLifeStatusCounts();
    assertTrue(endOfLifeStatusCountsResult.isEmpty());
    assertSame(
        endOfLifeStatusCountsResult,
        actualCalculateStatsForAppIdSelectorResult.environmentCounts());
    assertSame(
        endOfLifeStatusCountsResult, actualCalculateStatsForAppIdSelectorResult.vendorCounts());
  }

  /**
   * Test {@link DatabaseInformationService#calculateStatsForAppIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DatabaseInformationService#calculateStatsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatsForAppIdSelector(IdSelectionOptions); given 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DatabaseSummaryStatistics DatabaseInformationService.calculateStatsForAppIdSelector(IdSelectionOptions)"
  })
  void testCalculateStatsForAppIdSelector_givenActive() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(ImmutableDatabaseSummaryStatistics.builder().build());
    DatabaseInformationService databaseInformationService =
        new DatabaseInformationService(databaseInformationDao);

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
    DatabaseSummaryStatistics actualCalculateStatsForAppIdSelectorResult =
        databaseInformationService.calculateStatsForAppIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(databaseInformationDao).calculateStatsForAppSelector(isA(Select.class));
    assertTrue(
        actualCalculateStatsForAppIdSelectorResult instanceof ImmutableDatabaseSummaryStatistics);
    List<Tally<String>> endOfLifeStatusCountsResult =
        actualCalculateStatsForAppIdSelectorResult.endOfLifeStatusCounts();
    assertTrue(endOfLifeStatusCountsResult.isEmpty());
    assertSame(
        endOfLifeStatusCountsResult,
        actualCalculateStatsForAppIdSelectorResult.environmentCounts());
    assertSame(
        endOfLifeStatusCountsResult, actualCalculateStatsForAppIdSelectorResult.vendorCounts());
  }

  /**
   * Test {@link DatabaseInformationService#calculateStatsForAppIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DatabaseInformationService#calculateStatsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatsForAppIdSelector(IdSelectionOptions); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DatabaseSummaryStatistics DatabaseInformationService.calculateStatsForAppIdSelector(IdSelectionOptions)"
  })
  void testCalculateStatsForAppIdSelector_givenInHouse() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(ImmutableDatabaseSummaryStatistics.builder().build());
    DatabaseInformationService databaseInformationService =
        new DatabaseInformationService(databaseInformationDao);

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
    DatabaseSummaryStatistics actualCalculateStatsForAppIdSelectorResult =
        databaseInformationService.calculateStatsForAppIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(databaseInformationDao).calculateStatsForAppSelector(isA(Select.class));
    assertTrue(
        actualCalculateStatsForAppIdSelectorResult instanceof ImmutableDatabaseSummaryStatistics);
    List<Tally<String>> endOfLifeStatusCountsResult =
        actualCalculateStatsForAppIdSelectorResult.endOfLifeStatusCounts();
    assertTrue(endOfLifeStatusCountsResult.isEmpty());
    assertSame(
        endOfLifeStatusCountsResult,
        actualCalculateStatsForAppIdSelectorResult.environmentCounts());
    assertSame(
        endOfLifeStatusCountsResult, actualCalculateStatsForAppIdSelectorResult.vendorCounts());
  }

  /**
   * Test {@link DatabaseInformationService#calculateStatsForAppIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DatabaseInformationService#calculateStatsForAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatsForAppIdSelector(IdSelectionOptions); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DatabaseSummaryStatistics DatabaseInformationService.calculateStatsForAppIdSelector(IdSelectionOptions)"
  })
  void testCalculateStatsForAppIdSelector_givenPending() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(ImmutableDatabaseSummaryStatistics.builder().build());
    DatabaseInformationService databaseInformationService =
        new DatabaseInformationService(databaseInformationDao);

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
    DatabaseSummaryStatistics actualCalculateStatsForAppIdSelectorResult =
        databaseInformationService.calculateStatsForAppIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(databaseInformationDao).calculateStatsForAppSelector(isA(Select.class));
    assertTrue(
        actualCalculateStatsForAppIdSelectorResult instanceof ImmutableDatabaseSummaryStatistics);
    List<Tally<String>> endOfLifeStatusCountsResult =
        actualCalculateStatsForAppIdSelectorResult.endOfLifeStatusCounts();
    assertTrue(endOfLifeStatusCountsResult.isEmpty());
    assertSame(
        endOfLifeStatusCountsResult,
        actualCalculateStatsForAppIdSelectorResult.environmentCounts());
    assertSame(
        endOfLifeStatusCountsResult, actualCalculateStatsForAppIdSelectorResult.vendorCounts());
  }

  /**
   * Test {@link DatabaseInformationService#getById(long)}.
   *
   * <p>Method under test: {@link DatabaseInformationService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DatabaseInformation DatabaseInformationService.getById(long)"})
  void testGetById() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);

    ImmutableDatabaseInformation.Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    when(databaseInformationDao.getById(anyLong()))
        .thenReturn(
            dbmsVersionResult
                .endOfLifeDate(
                    Date.from(
                        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .externalId("42")
                .id(1L)
                .instanceName("Instance Name")
                .kind(EntityKind.ALL)
                .lifecycleStatus(LifecycleStatus.ACTIVE)
                .provenance("Provenance")
                .build());

    // Act
    DatabaseInformation actualById =
        new DatabaseInformationService(databaseInformationDao).getById(1L);

    // Assert
    verify(databaseInformationDao).getById(1L);
    assertTrue(actualById instanceof ImmutableDatabaseInformation);
    assertEquals("1.0.2", actualById.dbmsVersion());
    assertEquals("Database Name", actualById.databaseName());
    assertEquals("Dbms Name", actualById.dbmsName());
    assertEquals("Dbms Vendor", actualById.dbmsVendor());
    assertEquals("Instance Name", actualById.instanceName());
    assertEquals("Provenance", actualById.provenance());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualById.lifecycleStatus());
  }

  /**
   * Test {@link DatabaseInformationService#getByExternalId(String)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableDatabaseInformation}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseInformationService#getByExternalId(String)}
   */
  @Test
  @DisplayName("Test getByExternalId(String); then return ImmutableDatabaseInformation")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DatabaseInformation DatabaseInformationService.getByExternalId(String)"})
  void testGetByExternalId_thenReturnImmutableDatabaseInformation() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);

    ImmutableDatabaseInformation.Builder dbmsVersionResult =
        ImmutableDatabaseInformation.builder()
            .databaseName("Database Name")
            .dbmsName("Dbms Name")
            .dbmsVendor("Dbms Vendor")
            .dbmsVersion("1.0.2");
    when(databaseInformationDao.getByExternalId(Mockito.<String>any()))
        .thenReturn(
            dbmsVersionResult
                .endOfLifeDate(
                    Date.from(
                        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .externalId("42")
                .id(1L)
                .instanceName("Instance Name")
                .kind(EntityKind.ALL)
                .lifecycleStatus(LifecycleStatus.ACTIVE)
                .provenance("Provenance")
                .build());

    // Act
    DatabaseInformation actualByExternalId =
        new DatabaseInformationService(databaseInformationDao).getByExternalId("42");

    // Assert
    verify(databaseInformationDao).getByExternalId("42");
    assertTrue(actualByExternalId instanceof ImmutableDatabaseInformation);
    assertEquals("1.0.2", actualByExternalId.dbmsVersion());
    assertEquals("Database Name", actualByExternalId.databaseName());
    assertEquals("Dbms Name", actualByExternalId.dbmsName());
    assertEquals("Dbms Vendor", actualByExternalId.dbmsVendor());
    assertEquals("Instance Name", actualByExternalId.instanceName());
    assertEquals("Provenance", actualByExternalId.provenance());
    assertEquals(EntityKind.ALL, actualByExternalId.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualByExternalId.lifecycleStatus());
  }

  /**
   * Test {@link DatabaseInformationService#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link DatabaseInformationService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseInformationService.search(EntitySearchOptions)"})
  void testSearch() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.search(Mockito.<EntitySearchOptions>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<DatabaseInformation> actualSearchResult =
        new DatabaseInformationService(databaseInformationDao).search(null);

    // Assert
    verify(databaseInformationDao).search(isNull());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link DatabaseInformationService#createDatabase(DatabaseInformation)}.
   *
   * <p>Method under test: {@link DatabaseInformationService#createDatabase(DatabaseInformation)}
   */
  @Test
  @DisplayName("Test createDatabase(DatabaseInformation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DatabaseInformationService.createDatabase(DatabaseInformation)"})
  void testCreateDatabase() {
    // Arrange
    DatabaseInformationDao databaseInformationDao = mock(DatabaseInformationDao.class);
    when(databaseInformationDao.createDatabase(Mockito.<DatabaseInformation>any())).thenReturn(1L);

    // Act
    Long actualCreateDatabaseResult =
        new DatabaseInformationService(databaseInformationDao).createDatabase(null);

    // Assert
    verify(databaseInformationDao).createDatabase(isNull());
    assertEquals(1L, actualCreateDatabaseResult.longValue());
  }
}
