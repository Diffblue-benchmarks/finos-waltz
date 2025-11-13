package org.finos.waltz.service.end_user_app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.end_user_app.EndUserAppDao;
import org.finos.waltz.data.end_user_app.search.EndUserAppSearchDao;
import org.finos.waltz.data.involvement.InvolvementDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.enduserapp.EndUserApplication;
import org.finos.waltz.model.enduserapp.ImmutableEndUserApplication;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.physical_flow.CriticalityValue;
import org.finos.waltz.model.tally.Tally;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EndUserAppServiceDiffblueTest {
  /**
   * Test {@link EndUserAppService#findByOrganisationalUnitSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * EndUserAppService#findByOrganisationalUnitSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByOrganisationalUnitSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EndUserAppService.findByOrganisationalUnitSelector(IdSelectionOptions)"})
  void testFindByOrganisationalUnitSelector() {
    // Arrange
    EndUserAppDao endUserAppDao = mock(EndUserAppDao.class);
    when(endUserAppDao.findByOrganisationalUnitSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    EndUserAppService endUserAppService =
        new EndUserAppService(
            endUserAppDao,
            mock(ApplicationDao.class),
            mock(ChangeLogDao.class),
            mock(InvolvementDao.class),
            mock(EndUserAppSearchDao.class));

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
    List<EndUserApplication> actualFindByOrganisationalUnitSelectorResult =
        endUserAppService.findByOrganisationalUnitSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(endUserAppDao).findByOrganisationalUnitSelector(isA(Select.class));
    assertTrue(actualFindByOrganisationalUnitSelectorResult.isEmpty());
  }

  /**
   * Test {@link EndUserAppService#findByOrganisationalUnitSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * EndUserAppService#findByOrganisationalUnitSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByOrganisationalUnitSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EndUserAppService.findByOrganisationalUnitSelector(IdSelectionOptions)"})
  void testFindByOrganisationalUnitSelector2() {
    // Arrange
    EndUserAppDao endUserAppDao = mock(EndUserAppDao.class);
    when(endUserAppDao.findByOrganisationalUnitSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    EndUserAppService endUserAppService =
        new EndUserAppService(
            endUserAppDao,
            mock(ApplicationDao.class),
            mock(ChangeLogDao.class),
            mock(InvolvementDao.class),
            mock(EndUserAppSearchDao.class));

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
    List<EndUserApplication> actualFindByOrganisationalUnitSelectorResult =
        endUserAppService.findByOrganisationalUnitSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.PARENTS)
                .build());

    // Assert
    verify(endUserAppDao).findByOrganisationalUnitSelector(isA(Select.class));
    assertTrue(actualFindByOrganisationalUnitSelectorResult.isEmpty());
  }

  /**
   * Test {@link EndUserAppService#findByOrganisationalUnitSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * EndUserAppService#findByOrganisationalUnitSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByOrganisationalUnitSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EndUserAppService.findByOrganisationalUnitSelector(IdSelectionOptions)"})
  void testFindByOrganisationalUnitSelector3() {
    // Arrange
    EndUserAppDao endUserAppDao = mock(EndUserAppDao.class);
    when(endUserAppDao.findByOrganisationalUnitSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    EndUserAppService endUserAppService =
        new EndUserAppService(
            endUserAppDao,
            mock(ApplicationDao.class),
            mock(ChangeLogDao.class),
            mock(InvolvementDao.class),
            mock(EndUserAppSearchDao.class));

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
    List<EndUserApplication> actualFindByOrganisationalUnitSelectorResult =
        endUserAppService.findByOrganisationalUnitSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.CHILDREN)
                .build());

    // Assert
    verify(endUserAppDao).findByOrganisationalUnitSelector(isA(Select.class));
    assertTrue(actualFindByOrganisationalUnitSelectorResult.isEmpty());
  }

  /**
   * Test {@link EndUserAppService#findByOrganisationalUnitSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code CHILDREN}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EndUserAppService#findByOrganisationalUnitSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByOrganisationalUnitSelector(IdSelectionOptions); given 'CHILDREN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EndUserAppService.findByOrganisationalUnitSelector(IdSelectionOptions)"})
  void testFindByOrganisationalUnitSelector_givenChildren() {
    // Arrange
    EndUserAppDao endUserAppDao = mock(EndUserAppDao.class);
    when(endUserAppDao.findByOrganisationalUnitSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    EndUserAppService endUserAppService =
        new EndUserAppService(
            endUserAppDao,
            mock(ApplicationDao.class),
            mock(ChangeLogDao.class),
            mock(InvolvementDao.class),
            mock(EndUserAppSearchDao.class));

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
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
    List<EndUserApplication> actualFindByOrganisationalUnitSelectorResult =
        endUserAppService.findByOrganisationalUnitSelector(options);

    // Assert
    verify(endUserAppDao).findByOrganisationalUnitSelector(isA(Select.class));
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).scope();
    assertTrue(actualFindByOrganisationalUnitSelectorResult.isEmpty());
  }

  /**
   * Test {@link EndUserAppService#findByOrganisationalUnitSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code EXACT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EndUserAppService#findByOrganisationalUnitSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByOrganisationalUnitSelector(IdSelectionOptions); given 'EXACT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EndUserAppService.findByOrganisationalUnitSelector(IdSelectionOptions)"})
  void testFindByOrganisationalUnitSelector_givenExact() {
    // Arrange
    EndUserAppDao endUserAppDao = mock(EndUserAppDao.class);
    when(endUserAppDao.findByOrganisationalUnitSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    EndUserAppService endUserAppService =
        new EndUserAppService(
            endUserAppDao,
            mock(ApplicationDao.class),
            mock(ChangeLogDao.class),
            mock(InvolvementDao.class),
            mock(EndUserAppSearchDao.class));

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
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
    List<EndUserApplication> actualFindByOrganisationalUnitSelectorResult =
        endUserAppService.findByOrganisationalUnitSelector(options);

    // Assert
    verify(endUserAppDao).findByOrganisationalUnitSelector(isA(Select.class));
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindByOrganisationalUnitSelectorResult.isEmpty());
  }

  /**
   * Test {@link EndUserAppService#findByOrganisationalUnitSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code PARENTS}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EndUserAppService#findByOrganisationalUnitSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByOrganisationalUnitSelector(IdSelectionOptions); given 'PARENTS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EndUserAppService.findByOrganisationalUnitSelector(IdSelectionOptions)"})
  void testFindByOrganisationalUnitSelector_givenParents() {
    // Arrange
    EndUserAppDao endUserAppDao = mock(EndUserAppDao.class);
    when(endUserAppDao.findByOrganisationalUnitSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    EndUserAppService endUserAppService =
        new EndUserAppService(
            endUserAppDao,
            mock(ApplicationDao.class),
            mock(ChangeLogDao.class),
            mock(InvolvementDao.class),
            mock(EndUserAppSearchDao.class));

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.PARENTS);
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
    List<EndUserApplication> actualFindByOrganisationalUnitSelectorResult =
        endUserAppService.findByOrganisationalUnitSelector(options);

    // Assert
    verify(endUserAppDao).findByOrganisationalUnitSelector(isA(Select.class));
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).scope();
    assertTrue(actualFindByOrganisationalUnitSelectorResult.isEmpty());
  }

  /**
   * Test {@link EndUserAppService#countByOrgUnitId()}.
   *
   * <p>Method under test: {@link EndUserAppService#countByOrgUnitId()}
   */
  @Test
  @DisplayName("Test countByOrgUnitId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection EndUserAppService.countByOrgUnitId()"})
  void testCountByOrgUnitId() {
    // Arrange
    EndUserAppDao endUserAppDao = mock(EndUserAppDao.class);
    ArrayList<Tally<Long>> tallyList = new ArrayList<>();
    when(endUserAppDao.countByOrganisationalUnit()).thenReturn(tallyList);
    EndUserAppService endUserAppService =
        new EndUserAppService(
            endUserAppDao,
            mock(ApplicationDao.class),
            mock(ChangeLogDao.class),
            mock(InvolvementDao.class),
            mock(EndUserAppSearchDao.class));

    // Act
    Collection<Tally<Long>> actualCountByOrgUnitIdResult = endUserAppService.countByOrgUnitId();

    // Assert
    verify(endUserAppDao).countByOrganisationalUnit();
    assertTrue(actualCountByOrgUnitIdResult instanceof List);
    assertTrue(actualCountByOrgUnitIdResult.isEmpty());
    assertSame(tallyList, actualCountByOrgUnitIdResult);
  }

  /**
   * Test {@link EndUserAppService#findBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link EndUserAppService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EndUserAppService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector() {
    // Arrange
    EndUserAppDao endUserAppDao = mock(EndUserAppDao.class);
    when(endUserAppDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    EndUserAppService endUserAppService =
        new EndUserAppService(
            endUserAppDao,
            mock(ApplicationDao.class),
            mock(ChangeLogDao.class),
            mock(InvolvementDao.class),
            mock(EndUserAppSearchDao.class));

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
    List<EndUserApplication> actualFindBySelectorResult =
        endUserAppService.findBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(endUserAppDao).findBySelector(isA(Select.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link EndUserAppService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code CHILDREN}.
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#scope()} return {@code
   *       CHILDREN}.
   * </ul>
   *
   * <p>Method under test: {@link EndUserAppService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions); given 'CHILDREN'; when IdSelectionOptions scope() return 'CHILDREN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EndUserAppService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenChildren_whenIdSelectionOptionsScopeReturnChildren() {
    // Arrange
    EndUserAppDao endUserAppDao = mock(EndUserAppDao.class);
    when(endUserAppDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    EndUserAppService endUserAppService =
        new EndUserAppService(
            endUserAppDao,
            mock(ApplicationDao.class),
            mock(ChangeLogDao.class),
            mock(InvolvementDao.class),
            mock(EndUserAppSearchDao.class));

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
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
    List<EndUserApplication> actualFindBySelectorResult = endUserAppService.findBySelector(options);

    // Assert
    verify(endUserAppDao).findBySelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link EndUserAppService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code EXACT}.
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#scope()} return {@code EXACT}.
   * </ul>
   *
   * <p>Method under test: {@link EndUserAppService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions); given 'EXACT'; when IdSelectionOptions scope() return 'EXACT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EndUserAppService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenExact_whenIdSelectionOptionsScopeReturnExact() {
    // Arrange
    EndUserAppDao endUserAppDao = mock(EndUserAppDao.class);
    when(endUserAppDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    EndUserAppService endUserAppService =
        new EndUserAppService(
            endUserAppDao,
            mock(ApplicationDao.class),
            mock(ChangeLogDao.class),
            mock(InvolvementDao.class),
            mock(EndUserAppSearchDao.class));

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
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
    List<EndUserApplication> actualFindBySelectorResult = endUserAppService.findBySelector(options);

    // Assert
    verify(endUserAppDao).findBySelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link EndUserAppService#getById(Long)}.
   *
   * <p>Method under test: {@link EndUserAppService#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EndUserApplication EndUserAppService.getById(Long)"})
  void testGetById() {
    // Arrange
    EndUserAppDao endUserAppDao = mock(EndUserAppDao.class);

    ImmutableEndUserApplication.Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    CriticalityValue riskRating = CriticalityValue.of("42");
    when(endUserAppDao.getById(Mockito.<Long>any()))
        .thenReturn(provenanceResult.riskRating(riskRating).build());
    EndUserAppService endUserAppService =
        new EndUserAppService(
            endUserAppDao,
            mock(ApplicationDao.class),
            mock(ChangeLogDao.class),
            mock(InvolvementDao.class),
            mock(EndUserAppSearchDao.class));

    // Act
    EndUserApplication actualById = endUserAppService.getById(1L);

    // Assert
    verify(endUserAppDao).getById(1L);
    assertTrue(actualById instanceof ImmutableEndUserApplication);
    CriticalityValue riskRatingResult = actualById.riskRating();
    assertEquals("42", riskRatingResult.value());
    assertEquals("Application Kind", actualById.applicationKind());
    assertEquals("Name", actualById.name());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(1L, actualById.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualById.lifecyclePhase());
    assertTrue(actualById.isPromoted());
    assertSame(riskRating, riskRatingResult);
  }

  /**
   * Test {@link EndUserAppService#findAll()}.
   *
   * <p>Method under test: {@link EndUserAppService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EndUserAppService.findAll()"})
  void testFindAll() {
    // Arrange
    EndUserAppDao endUserAppDao = mock(EndUserAppDao.class);
    when(endUserAppDao.findAll()).thenReturn(new ArrayList<>());
    EndUserAppService endUserAppService =
        new EndUserAppService(
            endUserAppDao,
            mock(ApplicationDao.class),
            mock(ChangeLogDao.class),
            mock(InvolvementDao.class),
            mock(EndUserAppSearchDao.class));

    // Act
    List<EndUserApplication> actualFindAllResult = endUserAppService.findAll();

    // Assert
    verify(endUserAppDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link EndUserAppService#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link EndUserAppService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection EndUserAppService.search(EntitySearchOptions)"})
  void testSearch() {
    // Arrange
    EndUserAppSearchDao endUserAppSearchDao = mock(EndUserAppSearchDao.class);
    ArrayList<EndUserApplication> endUserApplicationList = new ArrayList<>();
    when(endUserAppSearchDao.search(Mockito.<EntitySearchOptions>any()))
        .thenReturn(endUserApplicationList);
    EndUserAppService endUserAppService =
        new EndUserAppService(
            mock(EndUserAppDao.class),
            mock(ApplicationDao.class),
            mock(ChangeLogDao.class),
            mock(InvolvementDao.class),
            endUserAppSearchDao);

    // Act
    Collection<EndUserApplication> actualSearchResult = endUserAppService.search(null);

    // Assert
    verify(endUserAppSearchDao).search(isNull());
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
    assertSame(endUserApplicationList, actualSearchResult);
  }
}
