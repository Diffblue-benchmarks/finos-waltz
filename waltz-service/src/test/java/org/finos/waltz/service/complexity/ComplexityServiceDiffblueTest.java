package org.finos.waltz.service.complexity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.complexity.ComplexityDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.complexity.Complexity;
import org.finos.waltz.model.complexity.ComplexitySummary;
import org.finos.waltz.model.complexity.ComplexityTotal;
import org.finos.waltz.model.complexity.ImmutableComplexity;
import org.finos.waltz.model.complexity.ImmutableComplexityKind;
import org.finos.waltz.model.complexity.ImmutableComplexitySummary;
import org.finos.waltz.model.settings.ImmutableSetting;
import org.finos.waltz.service.complexity_kind.ComplexityKindService;
import org.finos.waltz.service.settings.SettingsService;
import org.jooq.lambda.tuple.Tuple2;
import org.jooq.lambda.tuple.Tuple3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ComplexityServiceDiffblueTest {
  @Mock private ComplexityDao complexityDao;

  @Mock private ComplexityKindService complexityKindService;

  @InjectMocks private ComplexityService complexityService;

  @Mock private SettingsService settingsService;

  /**
   * Test {@link ComplexityService#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenReturnEmpty() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

    // Act
    Set<Complexity> actualFindByEntityReferenceResult =
        complexityService.findByEntityReference(null);

    // Assert
    verify(complexityDao).findByEntityReference(isNull());
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenThrowIllegalArgumentException() {
    // Arrange
    when(complexityDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> complexityService.findByEntityReference(null));
    verify(complexityDao).findByEntityReference(isNull());
  }

  /**
   * Test {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    Set<Complexity> actualFindBySelectorResult =
        complexityService.findBySelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(complexityDao).findBySelector(isA(GenericSelector.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector2() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    Set<Complexity> actualFindBySelectorResult =
        complexityService.findBySelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(complexityDao).findBySelector(isA(GenericSelector.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector3() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    Set<Complexity> actualFindBySelectorResult =
        complexityService.findBySelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(complexityDao).findBySelector(isA(GenericSelector.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector4() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    Set<Complexity> actualFindBySelectorResult =
        complexityService.findBySelector(
            EntityKind.CHANGE_INITIATIVE,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(complexityDao).findBySelector(isA(GenericSelector.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   *   <li>When builder addEntityLifecycleStatuses {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(EntityKind, IdSelectionOptions); given 'ACTIVE'; when builder addEntityLifecycleStatuses 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector_givenActive_whenBuilderAddEntityLifecycleStatusesActive() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    Set<Complexity> actualFindBySelectorResult =
        complexityService.findBySelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(complexityDao).findBySelector(isA(GenericSelector.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   *   <li>When builder addEntityLifecycleStatuses {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(EntityKind, IdSelectionOptions); given 'ACTIVE'; when builder addEntityLifecycleStatuses 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector_givenActive_whenBuilderAddEntityLifecycleStatusesActive2() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Set<Complexity> actualFindBySelectorResult =
        complexityService.findBySelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(complexityDao).findBySelector(isA(GenericSelector.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code CHILDREN}.
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#scope()} return {@code
   *       CHILDREN}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(EntityKind, IdSelectionOptions); given 'CHILDREN'; when IdSelectionOptions scope() return 'CHILDREN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector_givenChildren_whenIdSelectionOptionsScopeReturnChildren() {
    // Arrange
    when(complexityDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
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
    Set<Complexity> actualFindBySelectorResult =
        complexityService.findBySelector(EntityKind.CHANGE_INITIATIVE, options);

    // Assert
    verify(complexityDao).findBySelector(isA(GenericSelector.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(EntityKind, IdSelectionOptions); given HashSet() add 'ACTIVE'; then calls entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector_givenHashSetAddActive_thenCallsEntityLifecycleStatuses() {
    // Arrange
    when(complexityDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

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

    // Act
    Set<Complexity> actualFindBySelectorResult =
        complexityService.findBySelector(EntityKind.APPLICATION, options);

    // Assert
    verify(complexityDao).findBySelector(isA(GenericSelector.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   *   <li>When builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(EntityKind, IdSelectionOptions); given 'IN_HOUSE'; when builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector_givenInHouse_whenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    Set<Complexity> actualFindBySelectorResult =
        complexityService.findBySelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(complexityDao).findBySelector(isA(GenericSelector.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given of {@code ALL}.
   *   <li>Then calls {@link IdSelectionOptions#joiningEntityKind()}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(EntityKind, IdSelectionOptions); given of 'ALL'; then calls joiningEntityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector_givenOfAll_thenCallsJoiningEntityKind() {
    // Arrange
    when(complexityDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
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
    Set<Complexity> actualFindBySelectorResult =
        complexityService.findBySelector(EntityKind.CHANGE_INITIATIVE, options);

    // Assert
    verify(complexityDao).findBySelector(isA(GenericSelector.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   *   <li>When builder addEntityLifecycleStatuses {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(EntityKind, IdSelectionOptions); given 'PENDING'; when builder addEntityLifecycleStatuses 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector_givenPending_whenBuilderAddEntityLifecycleStatusesPending() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    Set<Complexity> actualFindBySelectorResult =
        complexityService.findBySelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(complexityDao).findBySelector(isA(GenericSelector.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link SettingsService#SettingsService(SettingsDao, Collection)} with {@link
   *       SettingsDao} and overrides is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(EntityKind, IdSelectionOptions); given SettingsService(SettingsDao, Collection) with SettingsDao and overrides is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector_givenSettingsServiceWithSettingsDaoAndOverridesIsArrayList() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    Set<Complexity> actualFindBySelectorResult =
        complexityService.findBySelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(complexityDao).findBySelector(isA(GenericSelector.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(EntityKind, IdSelectionOptions); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector_thenThrowIllegalArgumentException() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findBySelector(Mockito.<GenericSelector>any()))
        .thenThrow(new IllegalArgumentException());
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
        IllegalArgumentException.class,
        () ->
            complexityService.findBySelector(
                EntityKind.APPLICATION,
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
    verify(complexityDao).findBySelector(isA(GenericSelector.class));
  }

  /**
   * Test {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_INITIATIVE}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(EntityKind, IdSelectionOptions); when 'CHANGE_INITIATIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector_whenChangeInitiative() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    Set<Complexity> actualFindBySelectorResult =
        complexityService.findBySelector(
            EntityKind.CHANGE_INITIATIVE,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(complexityDao).findBySelector(isA(GenericSelector.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_UNIT}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(EntityKind, IdSelectionOptions); when 'CHANGE_UNIT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector_whenChangeUnit() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    Set<Complexity> actualFindBySelectorResult =
        complexityService.findBySelector(
            EntityKind.CHANGE_UNIT,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(complexityDao).findBySelector(isA(GenericSelector.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_UNIT}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(EntityKind, IdSelectionOptions); when 'CHANGE_UNIT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector_whenChangeUnit2() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    Set<Complexity> actualFindBySelectorResult =
        complexityService.findBySelector(
            EntityKind.CHANGE_UNIT,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(complexityDao).findBySelector(isA(GenericSelector.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code FLOW_DIAGRAM}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityService#findBySelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(EntityKind, IdSelectionOptions); when 'FLOW_DIAGRAM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector_whenFlowDiagram() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findBySelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    Set<Complexity> actualFindBySelectorResult =
        complexityService.findBySelector(
            EntityKind.FLOW_DIAGRAM,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(complexityDao).findBySelector(isA(GenericSelector.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#getComplexitySummaryForSelector(Long, EntityKind,
   * IdSelectionOptions, int)}.
   *
   * <p>Method under test: {@link ComplexityService#getComplexitySummaryForSelector(Long,
   * EntityKind, IdSelectionOptions, int)}
   */
  @Test
  @DisplayName("Test getComplexitySummaryForSelector(Long, EntityKind, IdSelectionOptions, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComplexitySummary ComplexityService.getComplexitySummaryForSelector(Long, EntityKind, IdSelectionOptions, int)"
  })
  void testGetComplexitySummaryForSelector() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findTopComplexityScoresForKindAndSelector(
            anyLong(), Mockito.<GenericSelector>any(), anyInt()))
        .thenThrow(new IllegalArgumentException());
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
        IllegalArgumentException.class,
        () ->
            complexityService.getComplexitySummaryForSelector(
                1L,
                EntityKind.APPLICATION,
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build(),
                1));
    verify(complexityDao)
        .findTopComplexityScoresForKindAndSelector(eq(1L), isA(GenericSelector.class), eq(1));
  }

  /**
   * Test {@link ComplexityService#getComplexitySummaryForSelector(Long, EntityKind,
   * IdSelectionOptions, int)}.
   *
   * <p>Method under test: {@link ComplexityService#getComplexitySummaryForSelector(Long,
   * EntityKind, IdSelectionOptions, int)}
   */
  @Test
  @DisplayName("Test getComplexitySummaryForSelector(Long, EntityKind, IdSelectionOptions, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComplexitySummary ComplexityService.getComplexitySummaryForSelector(Long, EntityKind, IdSelectionOptions, int)"
  })
  void testGetComplexitySummaryForSelector2() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.getStandardDeviationAndVariance(
            Mockito.<Long>any(),
            Mockito.<GenericSelector>any(),
            Mockito.<BigDecimal>any(),
            Mockito.<Integer>any()))
        .thenThrow(new IllegalArgumentException());
    when(complexityDao.findTopComplexityScoresForKindAndSelector(
            anyLong(), Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    when(complexityDao.getMappedAndMissingCountsForKindBySelector(
            Mockito.<Long>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new Tuple2<>(1, 1));
    BigDecimal bigDecimal = new BigDecimal("2.3");
    BigDecimal bigDecimal2 = new BigDecimal("2.3");

    Tuple3<BigDecimal, BigDecimal, BigDecimal> tuple3 =
        new Tuple3<>(bigDecimal, bigDecimal2, new BigDecimal("2.3"));
    when(complexityDao.getAverageAndTotalAndMedianScoreByKindAndSelector(
            Mockito.<Long>any(), Mockito.<GenericSelector>any()))
        .thenReturn(tuple3);
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
        IllegalArgumentException.class,
        () ->
            complexityService.getComplexitySummaryForSelector(
                1L,
                EntityKind.APPLICATION,
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build(),
                1));
    verify(complexityDao)
        .findTopComplexityScoresForKindAndSelector(eq(1L), isA(GenericSelector.class), eq(1));
    verify(complexityDao)
        .getAverageAndTotalAndMedianScoreByKindAndSelector(eq(1L), isA(GenericSelector.class));
    verify(complexityDao)
        .getMappedAndMissingCountsForKindBySelector(eq(1L), isA(GenericSelector.class));
    verify(complexityDao)
        .getStandardDeviationAndVariance(
            eq(1L), isA(GenericSelector.class), isA(BigDecimal.class), eq(1));
  }

  /**
   * Test {@link ComplexityService#getComplexitySummaryForSelector(Long, EntityKind,
   * IdSelectionOptions, int)}.
   *
   * <p>Method under test: {@link ComplexityService#getComplexitySummaryForSelector(Long,
   * EntityKind, IdSelectionOptions, int)}
   */
  @Test
  @DisplayName("Test getComplexitySummaryForSelector(Long, EntityKind, IdSelectionOptions, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComplexitySummary ComplexityService.getComplexitySummaryForSelector(Long, EntityKind, IdSelectionOptions, int)"
  })
  void testGetComplexitySummaryForSelector3() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    Tuple2<BigDecimal, BigDecimal> tuple2 = new Tuple2<>(bigDecimal, new BigDecimal("2.3"));
    when(complexityDao.getStandardDeviationAndVariance(
            Mockito.<Long>any(),
            Mockito.<GenericSelector>any(),
            Mockito.<BigDecimal>any(),
            Mockito.<Integer>any()))
        .thenReturn(tuple2);
    when(complexityDao.findTopComplexityScoresForKindAndSelector(
            anyLong(), Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    when(complexityDao.getMappedAndMissingCountsForKindBySelector(
            Mockito.<Long>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new Tuple2<>(1, 1));
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    BigDecimal bigDecimal3 = new BigDecimal("2.3");

    Tuple3<BigDecimal, BigDecimal, BigDecimal> tuple3 =
        new Tuple3<>(bigDecimal2, bigDecimal3, new BigDecimal("2.3"));
    when(complexityDao.getAverageAndTotalAndMedianScoreByKindAndSelector(
            Mockito.<Long>any(), Mockito.<GenericSelector>any()))
        .thenReturn(tuple3);

    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    when(complexityKindService.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    ComplexitySummary actualComplexitySummaryForSelector =
        complexityService.getComplexitySummaryForSelector(
            1L,
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            1);

    // Assert
    verify(complexityDao)
        .findTopComplexityScoresForKindAndSelector(eq(1L), isA(GenericSelector.class), eq(1));
    verify(complexityDao)
        .getAverageAndTotalAndMedianScoreByKindAndSelector(eq(1L), isA(GenericSelector.class));
    verify(complexityDao)
        .getMappedAndMissingCountsForKindBySelector(eq(1L), isA(GenericSelector.class));
    verify(complexityDao)
        .getStandardDeviationAndVariance(
            eq(1L), isA(GenericSelector.class), isA(BigDecimal.class), eq(1));
    verify(complexityKindService).getById(1L);
    assertTrue(
        actualComplexitySummaryForSelector.complexityKind() instanceof ImmutableComplexityKind);
    assertTrue(actualComplexitySummaryForSelector instanceof ImmutableComplexitySummary);
    assertEquals(1, actualComplexitySummaryForSelector.mappedCount());
    assertEquals(1, actualComplexitySummaryForSelector.missingCount());
    assertTrue(actualComplexitySummaryForSelector.topComplexityScores().isEmpty());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualComplexitySummaryForSelector.total());
    BigDecimal expectedAverageResult = new BigDecimal("2.30");
    assertEquals(expectedAverageResult, actualComplexitySummaryForSelector.average());
    BigDecimal expectedMedianResult = new BigDecimal("2.30");
    assertEquals(expectedMedianResult, actualComplexitySummaryForSelector.median());
    BigDecimal expectedStandardDeviationResult = new BigDecimal("2.30");
    assertEquals(
        expectedStandardDeviationResult, actualComplexitySummaryForSelector.standardDeviation());
    BigDecimal expectedVarianceResult = new BigDecimal("2.30");
    assertEquals(expectedVarianceResult, actualComplexitySummaryForSelector.variance());
  }

  /**
   * Test {@link ComplexityService#getComplexitySummaryForSelector(Long, EntityKind,
   * IdSelectionOptions, int)}.
   *
   * <p>Method under test: {@link ComplexityService#getComplexitySummaryForSelector(Long,
   * EntityKind, IdSelectionOptions, int)}
   */
  @Test
  @DisplayName("Test getComplexitySummaryForSelector(Long, EntityKind, IdSelectionOptions, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComplexitySummary ComplexityService.getComplexitySummaryForSelector(Long, EntityKind, IdSelectionOptions, int)"
  })
  void testGetComplexitySummaryForSelector4() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    Tuple2<BigDecimal, BigDecimal> tuple2 = new Tuple2<>(bigDecimal, new BigDecimal("2.3"));
    when(complexityDao.getStandardDeviationAndVariance(
            Mockito.<Long>any(),
            Mockito.<GenericSelector>any(),
            Mockito.<BigDecimal>any(),
            Mockito.<Integer>any()))
        .thenReturn(tuple2);
    when(complexityDao.findTopComplexityScoresForKindAndSelector(
            anyLong(), Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    when(complexityDao.getMappedAndMissingCountsForKindBySelector(
            Mockito.<Long>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new Tuple2<>(1, 1));
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    BigDecimal bigDecimal3 = new BigDecimal("2.3");

    Tuple3<BigDecimal, BigDecimal, BigDecimal> tuple3 =
        new Tuple3<>(bigDecimal2, bigDecimal3, new BigDecimal("2.3"));
    when(complexityDao.getAverageAndTotalAndMedianScoreByKindAndSelector(
            Mockito.<Long>any(), Mockito.<GenericSelector>any()))
        .thenReturn(tuple3);

    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    when(complexityKindService.getById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
        IllegalArgumentException.class,
        () ->
            complexityService.getComplexitySummaryForSelector(
                1L,
                EntityKind.APPLICATION,
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build(),
                1));
    verify(complexityDao)
        .findTopComplexityScoresForKindAndSelector(eq(1L), isA(GenericSelector.class), eq(1));
    verify(complexityDao)
        .getAverageAndTotalAndMedianScoreByKindAndSelector(eq(1L), isA(GenericSelector.class));
    verify(complexityDao)
        .getMappedAndMissingCountsForKindBySelector(eq(1L), isA(GenericSelector.class));
    verify(complexityDao)
        .getStandardDeviationAndVariance(
            eq(1L), isA(GenericSelector.class), isA(BigDecimal.class), eq(1));
    verify(complexityKindService).getById(1L);
  }

  /**
   * Test {@link ComplexityService#getComplexitySummaryForSelector(Long, EntityKind,
   * IdSelectionOptions, int)}.
   *
   * <p>Method under test: {@link ComplexityService#getComplexitySummaryForSelector(Long,
   * EntityKind, IdSelectionOptions, int)}
   */
  @Test
  @DisplayName("Test getComplexitySummaryForSelector(Long, EntityKind, IdSelectionOptions, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComplexitySummary ComplexityService.getComplexitySummaryForSelector(Long, EntityKind, IdSelectionOptions, int)"
  })
  void testGetComplexitySummaryForSelector5() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    Tuple2<BigDecimal, BigDecimal> tuple2 = new Tuple2<>(bigDecimal, new BigDecimal("2.3"));
    when(complexityDao.getStandardDeviationAndVariance(
            Mockito.<Long>any(),
            Mockito.<GenericSelector>any(),
            Mockito.<BigDecimal>any(),
            Mockito.<Integer>any()))
        .thenReturn(tuple2);
    when(complexityDao.findTopComplexityScoresForKindAndSelector(
            anyLong(), Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    when(complexityDao.getMappedAndMissingCountsForKindBySelector(
            Mockito.<Long>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new Tuple2<>(1, 1));
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    BigDecimal bigDecimal3 = new BigDecimal("2.3");

    Tuple3<BigDecimal, BigDecimal, BigDecimal> tuple3 =
        new Tuple3<>(bigDecimal2, bigDecimal3, new BigDecimal("2.3"));
    when(complexityDao.getAverageAndTotalAndMedianScoreByKindAndSelector(
            Mockito.<Long>any(), Mockito.<GenericSelector>any()))
        .thenReturn(tuple3);

    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    when(complexityKindService.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    ComplexitySummary actualComplexitySummaryForSelector =
        complexityService.getComplexitySummaryForSelector(
            1L,
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            1);

    // Assert
    verify(complexityDao)
        .findTopComplexityScoresForKindAndSelector(eq(1L), isA(GenericSelector.class), eq(1));
    verify(complexityDao)
        .getAverageAndTotalAndMedianScoreByKindAndSelector(eq(1L), isA(GenericSelector.class));
    verify(complexityDao)
        .getMappedAndMissingCountsForKindBySelector(eq(1L), isA(GenericSelector.class));
    verify(complexityDao)
        .getStandardDeviationAndVariance(
            eq(1L), isA(GenericSelector.class), isA(BigDecimal.class), eq(1));
    verify(complexityKindService).getById(1L);
    assertTrue(
        actualComplexitySummaryForSelector.complexityKind() instanceof ImmutableComplexityKind);
    assertTrue(actualComplexitySummaryForSelector instanceof ImmutableComplexitySummary);
    assertEquals(1, actualComplexitySummaryForSelector.mappedCount());
    assertEquals(1, actualComplexitySummaryForSelector.missingCount());
    assertTrue(actualComplexitySummaryForSelector.topComplexityScores().isEmpty());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualComplexitySummaryForSelector.total());
    BigDecimal expectedAverageResult = new BigDecimal("2.30");
    assertEquals(expectedAverageResult, actualComplexitySummaryForSelector.average());
    BigDecimal expectedMedianResult = new BigDecimal("2.30");
    assertEquals(expectedMedianResult, actualComplexitySummaryForSelector.median());
    BigDecimal expectedStandardDeviationResult = new BigDecimal("2.30");
    assertEquals(
        expectedStandardDeviationResult, actualComplexitySummaryForSelector.standardDeviation());
    BigDecimal expectedVarianceResult = new BigDecimal("2.30");
    assertEquals(expectedVarianceResult, actualComplexitySummaryForSelector.variance());
  }

  /**
   * Test {@link ComplexityService#getComplexitySummaryForSelector(Long, EntityKind,
   * IdSelectionOptions, int)}.
   *
   * <p>Method under test: {@link ComplexityService#getComplexitySummaryForSelector(Long,
   * EntityKind, IdSelectionOptions, int)}
   */
  @Test
  @DisplayName("Test getComplexitySummaryForSelector(Long, EntityKind, IdSelectionOptions, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComplexitySummary ComplexityService.getComplexitySummaryForSelector(Long, EntityKind, IdSelectionOptions, int)"
  })
  void testGetComplexitySummaryForSelector6() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    Tuple2<BigDecimal, BigDecimal> tuple2 = new Tuple2<>(bigDecimal, new BigDecimal("2.3"));
    when(complexityDao.getStandardDeviationAndVariance(
            Mockito.<Long>any(),
            Mockito.<GenericSelector>any(),
            Mockito.<BigDecimal>any(),
            Mockito.<Integer>any()))
        .thenReturn(tuple2);
    when(complexityDao.findTopComplexityScoresForKindAndSelector(
            anyLong(), Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    when(complexityDao.getMappedAndMissingCountsForKindBySelector(
            Mockito.<Long>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new Tuple2<>(1, 1));
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    BigDecimal bigDecimal3 = new BigDecimal("2.3");

    Tuple3<BigDecimal, BigDecimal, BigDecimal> tuple3 =
        new Tuple3<>(bigDecimal2, bigDecimal3, new BigDecimal("2.3"));
    when(complexityDao.getAverageAndTotalAndMedianScoreByKindAndSelector(
            Mockito.<Long>any(), Mockito.<GenericSelector>any()))
        .thenReturn(tuple3);

    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    when(complexityKindService.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    ComplexitySummary actualComplexitySummaryForSelector =
        complexityService.getComplexitySummaryForSelector(
            1L,
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            1);

    // Assert
    verify(complexityDao)
        .findTopComplexityScoresForKindAndSelector(eq(1L), isA(GenericSelector.class), eq(1));
    verify(complexityDao)
        .getAverageAndTotalAndMedianScoreByKindAndSelector(eq(1L), isA(GenericSelector.class));
    verify(complexityDao)
        .getMappedAndMissingCountsForKindBySelector(eq(1L), isA(GenericSelector.class));
    verify(complexityDao)
        .getStandardDeviationAndVariance(
            eq(1L), isA(GenericSelector.class), isA(BigDecimal.class), eq(1));
    verify(complexityKindService).getById(1L);
    assertTrue(
        actualComplexitySummaryForSelector.complexityKind() instanceof ImmutableComplexityKind);
    assertTrue(actualComplexitySummaryForSelector instanceof ImmutableComplexitySummary);
    assertEquals(1, actualComplexitySummaryForSelector.mappedCount());
    assertEquals(1, actualComplexitySummaryForSelector.missingCount());
    assertTrue(actualComplexitySummaryForSelector.topComplexityScores().isEmpty());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualComplexitySummaryForSelector.total());
    BigDecimal expectedAverageResult = new BigDecimal("2.30");
    assertEquals(expectedAverageResult, actualComplexitySummaryForSelector.average());
    BigDecimal expectedMedianResult = new BigDecimal("2.30");
    assertEquals(expectedMedianResult, actualComplexitySummaryForSelector.median());
    BigDecimal expectedStandardDeviationResult = new BigDecimal("2.30");
    assertEquals(
        expectedStandardDeviationResult, actualComplexitySummaryForSelector.standardDeviation());
    BigDecimal expectedVarianceResult = new BigDecimal("2.30");
    assertEquals(expectedVarianceResult, actualComplexitySummaryForSelector.variance());
  }

  /**
   * Test {@link ComplexityService#getComplexitySummaryForSelector(Long, EntityKind,
   * IdSelectionOptions, int)}.
   *
   * <p>Method under test: {@link ComplexityService#getComplexitySummaryForSelector(Long,
   * EntityKind, IdSelectionOptions, int)}
   */
  @Test
  @DisplayName("Test getComplexitySummaryForSelector(Long, EntityKind, IdSelectionOptions, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComplexitySummary ComplexityService.getComplexitySummaryForSelector(Long, EntityKind, IdSelectionOptions, int)"
  })
  void testGetComplexitySummaryForSelector7() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    Tuple2<BigDecimal, BigDecimal> tuple2 = new Tuple2<>(bigDecimal, new BigDecimal("2.3"));
    when(complexityDao.getStandardDeviationAndVariance(
            Mockito.<Long>any(),
            Mockito.<GenericSelector>any(),
            Mockito.<BigDecimal>any(),
            Mockito.<Integer>any()))
        .thenReturn(tuple2);
    when(complexityDao.findTopComplexityScoresForKindAndSelector(
            anyLong(), Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    when(complexityDao.getMappedAndMissingCountsForKindBySelector(
            Mockito.<Long>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new Tuple2<>(1, 1));
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    BigDecimal bigDecimal3 = new BigDecimal("2.3");

    Tuple3<BigDecimal, BigDecimal, BigDecimal> tuple3 =
        new Tuple3<>(bigDecimal2, bigDecimal3, new BigDecimal("2.3"));
    when(complexityDao.getAverageAndTotalAndMedianScoreByKindAndSelector(
            Mockito.<Long>any(), Mockito.<GenericSelector>any()))
        .thenReturn(tuple3);

    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    when(complexityKindService.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    ComplexitySummary actualComplexitySummaryForSelector =
        complexityService.getComplexitySummaryForSelector(
            1L,
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            1);

    // Assert
    verify(complexityDao)
        .findTopComplexityScoresForKindAndSelector(eq(1L), isA(GenericSelector.class), eq(1));
    verify(complexityDao)
        .getAverageAndTotalAndMedianScoreByKindAndSelector(eq(1L), isA(GenericSelector.class));
    verify(complexityDao)
        .getMappedAndMissingCountsForKindBySelector(eq(1L), isA(GenericSelector.class));
    verify(complexityDao)
        .getStandardDeviationAndVariance(
            eq(1L), isA(GenericSelector.class), isA(BigDecimal.class), eq(1));
    verify(complexityKindService).getById(1L);
    assertTrue(
        actualComplexitySummaryForSelector.complexityKind() instanceof ImmutableComplexityKind);
    assertTrue(actualComplexitySummaryForSelector instanceof ImmutableComplexitySummary);
    assertEquals(1, actualComplexitySummaryForSelector.mappedCount());
    assertEquals(1, actualComplexitySummaryForSelector.missingCount());
    assertTrue(actualComplexitySummaryForSelector.topComplexityScores().isEmpty());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualComplexitySummaryForSelector.total());
    BigDecimal expectedAverageResult = new BigDecimal("2.30");
    assertEquals(expectedAverageResult, actualComplexitySummaryForSelector.average());
    BigDecimal expectedMedianResult = new BigDecimal("2.30");
    assertEquals(expectedMedianResult, actualComplexitySummaryForSelector.median());
    BigDecimal expectedStandardDeviationResult = new BigDecimal("2.30");
    assertEquals(
        expectedStandardDeviationResult, actualComplexitySummaryForSelector.standardDeviation());
    BigDecimal expectedVarianceResult = new BigDecimal("2.30");
    assertEquals(expectedVarianceResult, actualComplexitySummaryForSelector.variance());
  }

  /**
   * Test {@link ComplexityService#getComplexitySummaryForSelector(Long, EntityKind,
   * IdSelectionOptions, int)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityService#getComplexitySummaryForSelector(Long,
   * EntityKind, IdSelectionOptions, int)}
   */
  @Test
  @DisplayName(
      "Test getComplexitySummaryForSelector(Long, EntityKind, IdSelectionOptions, int); given 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComplexitySummary ComplexityService.getComplexitySummaryForSelector(Long, EntityKind, IdSelectionOptions, int)"
  })
  void testGetComplexitySummaryForSelector_givenActive() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    Tuple2<BigDecimal, BigDecimal> tuple2 = new Tuple2<>(bigDecimal, new BigDecimal("2.3"));
    when(complexityDao.getStandardDeviationAndVariance(
            Mockito.<Long>any(),
            Mockito.<GenericSelector>any(),
            Mockito.<BigDecimal>any(),
            Mockito.<Integer>any()))
        .thenReturn(tuple2);
    when(complexityDao.findTopComplexityScoresForKindAndSelector(
            anyLong(), Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    when(complexityDao.getMappedAndMissingCountsForKindBySelector(
            Mockito.<Long>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new Tuple2<>(1, 1));
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    BigDecimal bigDecimal3 = new BigDecimal("2.3");

    Tuple3<BigDecimal, BigDecimal, BigDecimal> tuple3 =
        new Tuple3<>(bigDecimal2, bigDecimal3, new BigDecimal("2.3"));
    when(complexityDao.getAverageAndTotalAndMedianScoreByKindAndSelector(
            Mockito.<Long>any(), Mockito.<GenericSelector>any()))
        .thenReturn(tuple3);

    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    when(complexityKindService.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    ComplexitySummary actualComplexitySummaryForSelector =
        complexityService.getComplexitySummaryForSelector(
            1L,
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            1);

    // Assert
    verify(complexityDao)
        .findTopComplexityScoresForKindAndSelector(eq(1L), isA(GenericSelector.class), eq(1));
    verify(complexityDao)
        .getAverageAndTotalAndMedianScoreByKindAndSelector(eq(1L), isA(GenericSelector.class));
    verify(complexityDao)
        .getMappedAndMissingCountsForKindBySelector(eq(1L), isA(GenericSelector.class));
    verify(complexityDao)
        .getStandardDeviationAndVariance(
            eq(1L), isA(GenericSelector.class), isA(BigDecimal.class), eq(1));
    verify(complexityKindService).getById(1L);
    assertTrue(
        actualComplexitySummaryForSelector.complexityKind() instanceof ImmutableComplexityKind);
    assertTrue(actualComplexitySummaryForSelector instanceof ImmutableComplexitySummary);
    assertEquals(1, actualComplexitySummaryForSelector.mappedCount());
    assertEquals(1, actualComplexitySummaryForSelector.missingCount());
    assertTrue(actualComplexitySummaryForSelector.topComplexityScores().isEmpty());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualComplexitySummaryForSelector.total());
    BigDecimal expectedAverageResult = new BigDecimal("2.30");
    assertEquals(expectedAverageResult, actualComplexitySummaryForSelector.average());
    BigDecimal expectedMedianResult = new BigDecimal("2.30");
    assertEquals(expectedMedianResult, actualComplexitySummaryForSelector.median());
    BigDecimal expectedStandardDeviationResult = new BigDecimal("2.30");
    assertEquals(
        expectedStandardDeviationResult, actualComplexitySummaryForSelector.standardDeviation());
    BigDecimal expectedVarianceResult = new BigDecimal("2.30");
    assertEquals(expectedVarianceResult, actualComplexitySummaryForSelector.variance());
  }

  /**
   * Test {@link ComplexityService#getComplexitySummaryForSelector(Long, EntityKind,
   * IdSelectionOptions, int)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityService#getComplexitySummaryForSelector(Long,
   * EntityKind, IdSelectionOptions, int)}
   */
  @Test
  @DisplayName(
      "Test getComplexitySummaryForSelector(Long, EntityKind, IdSelectionOptions, int); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComplexitySummary ComplexityService.getComplexitySummaryForSelector(Long, EntityKind, IdSelectionOptions, int)"
  })
  void testGetComplexitySummaryForSelector_givenInHouse() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    Tuple2<BigDecimal, BigDecimal> tuple2 = new Tuple2<>(bigDecimal, new BigDecimal("2.3"));
    when(complexityDao.getStandardDeviationAndVariance(
            Mockito.<Long>any(),
            Mockito.<GenericSelector>any(),
            Mockito.<BigDecimal>any(),
            Mockito.<Integer>any()))
        .thenReturn(tuple2);
    when(complexityDao.findTopComplexityScoresForKindAndSelector(
            anyLong(), Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    when(complexityDao.getMappedAndMissingCountsForKindBySelector(
            Mockito.<Long>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new Tuple2<>(1, 1));
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    BigDecimal bigDecimal3 = new BigDecimal("2.3");

    Tuple3<BigDecimal, BigDecimal, BigDecimal> tuple3 =
        new Tuple3<>(bigDecimal2, bigDecimal3, new BigDecimal("2.3"));
    when(complexityDao.getAverageAndTotalAndMedianScoreByKindAndSelector(
            Mockito.<Long>any(), Mockito.<GenericSelector>any()))
        .thenReturn(tuple3);

    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    when(complexityKindService.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    ComplexitySummary actualComplexitySummaryForSelector =
        complexityService.getComplexitySummaryForSelector(
            1L,
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            1);

    // Assert
    verify(complexityDao)
        .findTopComplexityScoresForKindAndSelector(eq(1L), isA(GenericSelector.class), eq(1));
    verify(complexityDao)
        .getAverageAndTotalAndMedianScoreByKindAndSelector(eq(1L), isA(GenericSelector.class));
    verify(complexityDao)
        .getMappedAndMissingCountsForKindBySelector(eq(1L), isA(GenericSelector.class));
    verify(complexityDao)
        .getStandardDeviationAndVariance(
            eq(1L), isA(GenericSelector.class), isA(BigDecimal.class), eq(1));
    verify(complexityKindService).getById(1L);
    assertTrue(
        actualComplexitySummaryForSelector.complexityKind() instanceof ImmutableComplexityKind);
    assertTrue(actualComplexitySummaryForSelector instanceof ImmutableComplexitySummary);
    assertEquals(1, actualComplexitySummaryForSelector.mappedCount());
    assertEquals(1, actualComplexitySummaryForSelector.missingCount());
    assertTrue(actualComplexitySummaryForSelector.topComplexityScores().isEmpty());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualComplexitySummaryForSelector.total());
    BigDecimal expectedAverageResult = new BigDecimal("2.30");
    assertEquals(expectedAverageResult, actualComplexitySummaryForSelector.average());
    BigDecimal expectedMedianResult = new BigDecimal("2.30");
    assertEquals(expectedMedianResult, actualComplexitySummaryForSelector.median());
    BigDecimal expectedStandardDeviationResult = new BigDecimal("2.30");
    assertEquals(
        expectedStandardDeviationResult, actualComplexitySummaryForSelector.standardDeviation());
    BigDecimal expectedVarianceResult = new BigDecimal("2.30");
    assertEquals(expectedVarianceResult, actualComplexitySummaryForSelector.variance());
  }

  /**
   * Test {@link ComplexityService#getComplexitySummaryForSelector(Long, EntityKind,
   * IdSelectionOptions, int)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityService#getComplexitySummaryForSelector(Long,
   * EntityKind, IdSelectionOptions, int)}
   */
  @Test
  @DisplayName(
      "Test getComplexitySummaryForSelector(Long, EntityKind, IdSelectionOptions, int); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComplexitySummary ComplexityService.getComplexitySummaryForSelector(Long, EntityKind, IdSelectionOptions, int)"
  })
  void testGetComplexitySummaryForSelector_givenPending() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    Tuple2<BigDecimal, BigDecimal> tuple2 = new Tuple2<>(bigDecimal, new BigDecimal("2.3"));
    when(complexityDao.getStandardDeviationAndVariance(
            Mockito.<Long>any(),
            Mockito.<GenericSelector>any(),
            Mockito.<BigDecimal>any(),
            Mockito.<Integer>any()))
        .thenReturn(tuple2);
    when(complexityDao.findTopComplexityScoresForKindAndSelector(
            anyLong(), Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(new HashSet<>());
    when(complexityDao.getMappedAndMissingCountsForKindBySelector(
            Mockito.<Long>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new Tuple2<>(1, 1));
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    BigDecimal bigDecimal3 = new BigDecimal("2.3");

    Tuple3<BigDecimal, BigDecimal, BigDecimal> tuple3 =
        new Tuple3<>(bigDecimal2, bigDecimal3, new BigDecimal("2.3"));
    when(complexityDao.getAverageAndTotalAndMedianScoreByKindAndSelector(
            Mockito.<Long>any(), Mockito.<GenericSelector>any()))
        .thenReturn(tuple3);

    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    when(complexityKindService.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    ComplexitySummary actualComplexitySummaryForSelector =
        complexityService.getComplexitySummaryForSelector(
            1L,
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            1);

    // Assert
    verify(complexityDao)
        .findTopComplexityScoresForKindAndSelector(eq(1L), isA(GenericSelector.class), eq(1));
    verify(complexityDao)
        .getAverageAndTotalAndMedianScoreByKindAndSelector(eq(1L), isA(GenericSelector.class));
    verify(complexityDao)
        .getMappedAndMissingCountsForKindBySelector(eq(1L), isA(GenericSelector.class));
    verify(complexityDao)
        .getStandardDeviationAndVariance(
            eq(1L), isA(GenericSelector.class), isA(BigDecimal.class), eq(1));
    verify(complexityKindService).getById(1L);
    assertTrue(
        actualComplexitySummaryForSelector.complexityKind() instanceof ImmutableComplexityKind);
    assertTrue(actualComplexitySummaryForSelector instanceof ImmutableComplexitySummary);
    assertEquals(1, actualComplexitySummaryForSelector.mappedCount());
    assertEquals(1, actualComplexitySummaryForSelector.missingCount());
    assertTrue(actualComplexitySummaryForSelector.topComplexityScores().isEmpty());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualComplexitySummaryForSelector.total());
    BigDecimal expectedAverageResult = new BigDecimal("2.30");
    assertEquals(expectedAverageResult, actualComplexitySummaryForSelector.average());
    BigDecimal expectedMedianResult = new BigDecimal("2.30");
    assertEquals(expectedMedianResult, actualComplexitySummaryForSelector.median());
    BigDecimal expectedStandardDeviationResult = new BigDecimal("2.30");
    assertEquals(
        expectedStandardDeviationResult, actualComplexitySummaryForSelector.standardDeviation());
    BigDecimal expectedVarianceResult = new BigDecimal("2.30");
    assertEquals(expectedVarianceResult, actualComplexitySummaryForSelector.variance());
  }

  /**
   * Test {@link ComplexityService#getComplexitySummaryForSelector(Long, EntityKind,
   * IdSelectionOptions, int)}.
   *
   * <ul>
   *   <li>Then return topComplexityScores size is one.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityService#getComplexitySummaryForSelector(Long,
   * EntityKind, IdSelectionOptions, int)}
   */
  @Test
  @DisplayName(
      "Test getComplexitySummaryForSelector(Long, EntityKind, IdSelectionOptions, int); then return topComplexityScores size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComplexitySummary ComplexityService.getComplexitySummaryForSelector(Long, EntityKind, IdSelectionOptions, int)"
  })
  void testGetComplexitySummaryForSelector_thenReturnTopComplexityScoresSizeIsOne() {
    // Arrange
    HashSet<Complexity> complexitySet = new HashSet<>();

    ImmutableComplexity.Builder complexityKindIdResult =
        ImmutableComplexity.builder().complexityKindId(1L);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    ImmutableComplexity.Builder provenanceResult =
        complexityKindIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    complexitySet.add(provenanceResult.score(new BigDecimal("2.3")).build());

    ComplexityDao complexityDao = mock(ComplexityDao.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    Tuple2<BigDecimal, BigDecimal> tuple2 = new Tuple2<>(bigDecimal, new BigDecimal("2.3"));
    when(complexityDao.getStandardDeviationAndVariance(
            Mockito.<Long>any(),
            Mockito.<GenericSelector>any(),
            Mockito.<BigDecimal>any(),
            Mockito.<Integer>any()))
        .thenReturn(tuple2);
    when(complexityDao.findTopComplexityScoresForKindAndSelector(
            anyLong(), Mockito.<GenericSelector>any(), anyInt()))
        .thenReturn(complexitySet);
    when(complexityDao.getMappedAndMissingCountsForKindBySelector(
            Mockito.<Long>any(), Mockito.<GenericSelector>any()))
        .thenReturn(new Tuple2<>(1, 1));
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    BigDecimal bigDecimal3 = new BigDecimal("2.3");

    Tuple3<BigDecimal, BigDecimal, BigDecimal> tuple3 =
        new Tuple3<>(bigDecimal2, bigDecimal3, new BigDecimal("2.3"));
    when(complexityDao.getAverageAndTotalAndMedianScoreByKindAndSelector(
            Mockito.<Long>any(), Mockito.<GenericSelector>any()))
        .thenReturn(tuple3);

    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    when(complexityKindService.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    ComplexitySummary actualComplexitySummaryForSelector =
        complexityService.getComplexitySummaryForSelector(
            1L,
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            1);

    // Assert
    verify(complexityDao)
        .findTopComplexityScoresForKindAndSelector(eq(1L), isA(GenericSelector.class), eq(1));
    verify(complexityDao)
        .getAverageAndTotalAndMedianScoreByKindAndSelector(eq(1L), isA(GenericSelector.class));
    verify(complexityDao)
        .getMappedAndMissingCountsForKindBySelector(eq(1L), isA(GenericSelector.class));
    verify(complexityDao)
        .getStandardDeviationAndVariance(
            eq(1L), isA(GenericSelector.class), isA(BigDecimal.class), eq(1));
    verify(complexityKindService).getById(1L);
    List<Complexity> topComplexityScoresResult =
        actualComplexitySummaryForSelector.topComplexityScores();
    assertEquals(1, topComplexityScoresResult.size());
    Complexity getResult = topComplexityScoresResult.get(0);
    EntityReference entityReferenceResult = getResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableComplexity);
    assertTrue(actualComplexitySummaryForSelector instanceof ImmutableComplexitySummary);
    assertEquals("2020-03-01", getResult.lastUpdatedBy());
    assertEquals("Provenance", getResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, getResult.complexityKindId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityKind.ALL, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    BigDecimal expectedScoreResult = new BigDecimal("2.3");
    assertEquals(expectedScoreResult, getResult.score());
    assertSame(ofResult, getResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ComplexityService#findTotalsByTargetKindAndSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ComplexityService#findTotalsByTargetKindAndSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findTotalsByTargetKindAndSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ComplexityService.findTotalsByTargetKindAndSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindTotalsByTargetKindAndSelector() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findTotalsByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    Set<ComplexityTotal> actualFindTotalsByTargetKindAndSelectorResult =
        complexityService.findTotalsByTargetKindAndSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(complexityDao).findTotalsByGenericSelector(isA(GenericSelector.class));
    assertTrue(actualFindTotalsByTargetKindAndSelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#findTotalsByTargetKindAndSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ComplexityService#findTotalsByTargetKindAndSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findTotalsByTargetKindAndSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ComplexityService.findTotalsByTargetKindAndSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindTotalsByTargetKindAndSelector2() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findTotalsByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    Set<ComplexityTotal> actualFindTotalsByTargetKindAndSelectorResult =
        complexityService.findTotalsByTargetKindAndSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(complexityDao).findTotalsByGenericSelector(isA(GenericSelector.class));
    assertTrue(actualFindTotalsByTargetKindAndSelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#findTotalsByTargetKindAndSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ComplexityService#findTotalsByTargetKindAndSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findTotalsByTargetKindAndSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ComplexityService.findTotalsByTargetKindAndSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindTotalsByTargetKindAndSelector3() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findTotalsByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    Set<ComplexityTotal> actualFindTotalsByTargetKindAndSelectorResult =
        complexityService.findTotalsByTargetKindAndSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(complexityDao).findTotalsByGenericSelector(isA(GenericSelector.class));
    assertTrue(actualFindTotalsByTargetKindAndSelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#findTotalsByTargetKindAndSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ComplexityService#findTotalsByTargetKindAndSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findTotalsByTargetKindAndSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ComplexityService.findTotalsByTargetKindAndSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindTotalsByTargetKindAndSelector4() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findTotalsByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    Set<ComplexityTotal> actualFindTotalsByTargetKindAndSelectorResult =
        complexityService.findTotalsByTargetKindAndSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(complexityDao).findTotalsByGenericSelector(isA(GenericSelector.class));
    assertTrue(actualFindTotalsByTargetKindAndSelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#findTotalsByTargetKindAndSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ComplexityService#findTotalsByTargetKindAndSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findTotalsByTargetKindAndSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ComplexityService.findTotalsByTargetKindAndSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindTotalsByTargetKindAndSelector5() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findTotalsByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Set<ComplexityTotal> actualFindTotalsByTargetKindAndSelectorResult =
        complexityService.findTotalsByTargetKindAndSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(complexityDao).findTotalsByGenericSelector(isA(GenericSelector.class));
    assertTrue(actualFindTotalsByTargetKindAndSelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#findTotalsByTargetKindAndSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityService#findTotalsByTargetKindAndSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findTotalsByTargetKindAndSelector(EntityKind, IdSelectionOptions); given 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ComplexityService.findTotalsByTargetKindAndSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindTotalsByTargetKindAndSelector_givenActive() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findTotalsByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    Set<ComplexityTotal> actualFindTotalsByTargetKindAndSelectorResult =
        complexityService.findTotalsByTargetKindAndSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(complexityDao).findTotalsByGenericSelector(isA(GenericSelector.class));
    assertTrue(actualFindTotalsByTargetKindAndSelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#findTotalsByTargetKindAndSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityService#findTotalsByTargetKindAndSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findTotalsByTargetKindAndSelector(EntityKind, IdSelectionOptions); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ComplexityService.findTotalsByTargetKindAndSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindTotalsByTargetKindAndSelector_givenInHouse() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findTotalsByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    Set<ComplexityTotal> actualFindTotalsByTargetKindAndSelectorResult =
        complexityService.findTotalsByTargetKindAndSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(complexityDao).findTotalsByGenericSelector(isA(GenericSelector.class));
    assertTrue(actualFindTotalsByTargetKindAndSelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#findTotalsByTargetKindAndSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityService#findTotalsByTargetKindAndSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findTotalsByTargetKindAndSelector(EntityKind, IdSelectionOptions); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ComplexityService.findTotalsByTargetKindAndSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindTotalsByTargetKindAndSelector_givenPending() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findTotalsByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
    Set<ComplexityTotal> actualFindTotalsByTargetKindAndSelectorResult =
        complexityService.findTotalsByTargetKindAndSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(complexityDao).findTotalsByGenericSelector(isA(GenericSelector.class));
    assertTrue(actualFindTotalsByTargetKindAndSelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#findTotalsByTargetKindAndSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code REMOVED}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityService#findTotalsByTargetKindAndSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findTotalsByTargetKindAndSelector(EntityKind, IdSelectionOptions); given 'REMOVED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ComplexityService.findTotalsByTargetKindAndSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindTotalsByTargetKindAndSelector_givenRemoved() {
    // Arrange
    when(complexityDao.findTotalsByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.REMOVED);

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
    Set<ComplexityTotal> actualFindTotalsByTargetKindAndSelectorResult =
        complexityService.findTotalsByTargetKindAndSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(complexityDao).findTotalsByGenericSelector(isA(GenericSelector.class));
    assertTrue(actualFindTotalsByTargetKindAndSelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityService#findTotalsByTargetKindAndSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityService#findTotalsByTargetKindAndSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findTotalsByTargetKindAndSelector(EntityKind, IdSelectionOptions); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ComplexityService.findTotalsByTargetKindAndSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindTotalsByTargetKindAndSelector_thenThrowIllegalArgumentException() {
    // Arrange
    ComplexityDao complexityDao = mock(ComplexityDao.class);
    when(complexityDao.findTotalsByGenericSelector(Mockito.<GenericSelector>any()))
        .thenThrow(new IllegalArgumentException());
    ComplexityKindService complexityKindService = mock(ComplexityKindService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    ComplexityService complexityService =
        new ComplexityService(complexityDao, complexityKindService, settingsService);

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
        IllegalArgumentException.class,
        () ->
            complexityService.findTotalsByTargetKindAndSelector(
                EntityKind.APPLICATION,
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
    verify(complexityDao).findTotalsByGenericSelector(isA(GenericSelector.class));
  }

  /**
   * Test {@link ComplexityService#populateMeasurableComplexities()}.
   *
   * <p>Method under test: {@link ComplexityService#populateMeasurableComplexities()}
   */
  @Test
  @DisplayName("Test populateMeasurableComplexities()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ComplexityService.populateMeasurableComplexities()"})
  void testPopulateMeasurableComplexities() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("42")
                .build());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());
    ComplexityService complexityService =
        new ComplexityService(
            mock(ComplexityDao.class), mock(ComplexityKindService.class), settingsService);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> complexityService.populateMeasurableComplexities());
    verify(settingsDao).getByName("job.COMPLEXITY_REBUILD_MEASURABLE.params");
  }

  /**
   * Test {@link ComplexityService#populateMeasurableComplexities()}.
   *
   * <p>Method under test: {@link ComplexityService#populateMeasurableComplexities()}
   */
  @Test
  @DisplayName("Test populateMeasurableComplexities()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ComplexityService.populateMeasurableComplexities()"})
  void testPopulateMeasurableComplexities2() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("job.%s.params")
                .build());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());
    ComplexityService complexityService =
        new ComplexityService(
            mock(ComplexityDao.class), mock(ComplexityKindService.class), settingsService);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> complexityService.populateMeasurableComplexities());
    verify(settingsDao).getByName("job.COMPLEXITY_REBUILD_MEASURABLE.params");
  }

  /**
   * Test {@link ComplexityService#populateMeasurableComplexities()}.
   *
   * <p>Method under test: {@link ComplexityService#populateMeasurableComplexities()}
   */
  @Test
  @DisplayName("Test populateMeasurableComplexities()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ComplexityService.populateMeasurableComplexities()"})
  void testPopulateMeasurableComplexities3() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("")
                .build());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());
    ComplexityService complexityService =
        new ComplexityService(
            mock(ComplexityDao.class), mock(ComplexityKindService.class), settingsService);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> complexityService.populateMeasurableComplexities());
    verify(settingsDao).getByName("job.COMPLEXITY_REBUILD_MEASURABLE.params");
  }

  /**
   * Test {@link ComplexityService#populateMeasurableComplexities()}.
   *
   * <p>Method under test: {@link ComplexityService#populateMeasurableComplexities()}
   */
  @Test
  @DisplayName("Test populateMeasurableComplexities()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ComplexityService.populateMeasurableComplexities()"})
  void testPopulateMeasurableComplexities4() {
    // Arrange
    SettingsService settingsService = mock(SettingsService.class);
    when(settingsService.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("42Value")
                .build());
    ComplexityService complexityService =
        new ComplexityService(
            mock(ComplexityDao.class), mock(ComplexityKindService.class), settingsService);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> complexityService.populateMeasurableComplexities());
    verify(settingsService).getByName("job.COMPLEXITY_REBUILD_MEASURABLE.params");
  }

  /**
   * Test {@link ComplexityService#populateMeasurableComplexities()}.
   *
   * <ul>
   *   <li>Given {@link ComplexityDao}.
   *   <li>Then calls {@link SettingsService#getByName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityService#populateMeasurableComplexities()}
   */
  @Test
  @DisplayName(
      "Test populateMeasurableComplexities(); given ComplexityDao; then calls getByName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ComplexityService.populateMeasurableComplexities()"})
  void testPopulateMeasurableComplexities_givenComplexityDao_thenCallsGetByName() {
    // Arrange
    when(settingsService.getByName(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> complexityService.populateMeasurableComplexities());
    verify(settingsService).getByName("job.COMPLEXITY_REBUILD_MEASURABLE.params");
  }
}
