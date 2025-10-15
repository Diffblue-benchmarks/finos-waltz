package org.finos.waltz.service.server_information;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.server_information.ServerInformationDao;
import org.finos.waltz.data.server_information.search.ServerInformationSearchDao;
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
import org.finos.waltz.model.application.ImmutableApplicationIdSelectionOptions;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.server_information.ImmutableServerInformation;
import org.finos.waltz.model.server_information.ImmutableServerSummaryBasicStatistics;
import org.finos.waltz.model.server_information.ImmutableServerSummaryStatistics;
import org.finos.waltz.model.server_information.ServerInformation;
import org.finos.waltz.model.server_information.ServerSummaryBasicStatistics;
import org.finos.waltz.model.server_information.ServerSummaryStatistics;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ServerInformationServiceDiffblueTest {
  @Mock private ServerInformationDao serverInformationDao;

  @Mock private ServerInformationSearchDao serverInformationSearchDao;

  @InjectMocks private ServerInformationService serverInformationService;

  /**
   * Test {@link ServerInformationService#findByAssetCode(String)}.
   *
   * <p>Method under test: {@link ServerInformationService#findByAssetCode(String)}
   */
  @Test
  @DisplayName("Test findByAssetCode(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ServerInformationService.findByAssetCode(String)"})
  void testFindByAssetCode() {
    // Arrange
    when(serverInformationDao.findByAssetCode(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<ServerInformation> actualFindByAssetCodeResult =
        serverInformationService.findByAssetCode("Asset Code");

    // Assert
    verify(serverInformationDao).findByAssetCode("Asset Code");
    assertTrue(actualFindByAssetCodeResult.isEmpty());
  }

  /**
   * Test {@link ServerInformationService#findByAppId(long)}.
   *
   * <p>Method under test: {@link ServerInformationService#findByAppId(long)}
   */
  @Test
  @DisplayName("Test findByAppId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ServerInformationService.findByAppId(long)"})
  void testFindByAppId() {
    // Arrange
    when(serverInformationDao.findByAppId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    List<ServerInformation> actualFindByAppIdResult = serverInformationService.findByAppId(1L);

    // Assert
    verify(serverInformationDao).findByAppId(1L);
    assertTrue(actualFindByAppIdResult.isEmpty());
  }

  /**
   * Test {@link ServerInformationService#getById(long)}.
   *
   * <p>Method under test: {@link ServerInformationService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ServerInformation ServerInformationService.getById(long)"})
  void testGetById() {
    // Arrange
    ImmutableServerInformation.Builder externalIdResult =
        ImmutableServerInformation.builder().country("GB").externalId("42");

    ImmutableServerInformation.Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    when(serverInformationDao.getById(anyLong()))
        .thenReturn(
            operatingSystemResult
                .operatingSystemEndOfLifeDate(
                    Date.from(
                        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .operatingSystemVersion("1.0.2")
                .provenance("Provenance")
                .build());

    // Act
    ServerInformation actualById = serverInformationService.getById(1L);

    // Assert
    verify(serverInformationDao).getById(1L);
    assertTrue(actualById instanceof ImmutableServerInformation);
    assertEquals("1.0.2", actualById.operatingSystemVersion());
    assertEquals("GB", actualById.country());
    assertEquals("Location", actualById.location());
    assertEquals("Operating System", actualById.operatingSystem());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("localhost", actualById.hostname());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualById.lifecycleStatus());
    assertFalse(actualById.virtual());
  }

  /**
   * Test {@link ServerInformationService#getByExternalId(String)}.
   *
   * <p>Method under test: {@link ServerInformationService#getByExternalId(String)}
   */
  @Test
  @DisplayName("Test getByExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ServerInformation ServerInformationService.getByExternalId(String)"})
  void testGetByExternalId() {
    // Arrange
    ImmutableServerInformation.Builder externalIdResult =
        ImmutableServerInformation.builder().country("GB").externalId("42");

    ImmutableServerInformation.Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    when(serverInformationDao.getByExternalId(Mockito.<String>any()))
        .thenReturn(
            operatingSystemResult
                .operatingSystemEndOfLifeDate(
                    Date.from(
                        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .operatingSystemVersion("1.0.2")
                .provenance("Provenance")
                .build());

    // Act
    ServerInformation actualByExternalId = serverInformationService.getByExternalId("42");

    // Assert
    verify(serverInformationDao).getByExternalId("42");
    assertTrue(actualByExternalId instanceof ImmutableServerInformation);
    assertEquals("1.0.2", actualByExternalId.operatingSystemVersion());
    assertEquals("GB", actualByExternalId.country());
    assertEquals("Location", actualByExternalId.location());
    assertEquals("Operating System", actualByExternalId.operatingSystem());
    assertEquals("Provenance", actualByExternalId.provenance());
    assertEquals("localhost", actualByExternalId.hostname());
    assertEquals(EntityKind.ALL, actualByExternalId.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualByExternalId.lifecycleStatus());
    assertFalse(actualByExternalId.virtual());
  }

  /**
   * Test {@link ServerInformationService#getByHostname(String)}.
   *
   * <p>Method under test: {@link ServerInformationService#getByHostname(String)}
   */
  @Test
  @DisplayName("Test getByHostname(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ServerInformation ServerInformationService.getByHostname(String)"})
  void testGetByHostname() {
    // Arrange
    ImmutableServerInformation.Builder externalIdResult =
        ImmutableServerInformation.builder().country("GB").externalId("42");

    ImmutableServerInformation.Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    when(serverInformationDao.getByHostname(Mockito.<String>any()))
        .thenReturn(
            operatingSystemResult
                .operatingSystemEndOfLifeDate(
                    Date.from(
                        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .operatingSystemVersion("1.0.2")
                .provenance("Provenance")
                .build());

    // Act
    ServerInformation actualByHostname = serverInformationService.getByHostname("localhost");

    // Assert
    verify(serverInformationDao).getByHostname("localhost");
    assertTrue(actualByHostname instanceof ImmutableServerInformation);
    assertEquals("1.0.2", actualByHostname.operatingSystemVersion());
    assertEquals("GB", actualByHostname.country());
    assertEquals("Location", actualByHostname.location());
    assertEquals("Operating System", actualByHostname.operatingSystem());
    assertEquals("Provenance", actualByHostname.provenance());
    assertEquals("localhost", actualByHostname.hostname());
    assertEquals(EntityKind.ALL, actualByHostname.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualByHostname.lifecycleStatus());
    assertFalse(actualByHostname.virtual());
  }

  /**
   * Test {@link ServerInformationService#calculateStatsForAppSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ServerInformationService#calculateStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatsForAppSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ServerSummaryStatistics ServerInformationService.calculateStatsForAppSelector(IdSelectionOptions)"
  })
  void testCalculateStatsForAppSelector() {
    // Arrange
    when(serverInformationDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
            ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build());

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
    ServerSummaryStatistics actualCalculateStatsForAppSelectorResult =
        serverInformationService.calculateStatsForAppSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(serverInformationDao).calculateStatsForAppSelector(isA(Select.class));
    assertTrue(
        actualCalculateStatsForAppSelectorResult instanceof ImmutableServerSummaryStatistics);
  }

  /**
   * Test {@link ServerInformationService#calculateStatsForAppSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ServerInformationService#calculateStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatsForAppSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ServerSummaryStatistics ServerInformationService.calculateStatsForAppSelector(IdSelectionOptions)"
  })
  void testCalculateStatsForAppSelector2() {
    // Arrange
    when(serverInformationDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
            ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build());

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
    ServerSummaryStatistics actualCalculateStatsForAppSelectorResult =
        serverInformationService.calculateStatsForAppSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(serverInformationDao).calculateStatsForAppSelector(isA(Select.class));
    assertTrue(
        actualCalculateStatsForAppSelectorResult instanceof ImmutableServerSummaryStatistics);
  }

  /**
   * Test {@link ServerInformationService#calculateStatsForAppSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ServerInformationService#calculateStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatsForAppSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ServerSummaryStatistics ServerInformationService.calculateStatsForAppSelector(IdSelectionOptions)"
  })
  void testCalculateStatsForAppSelector3() {
    // Arrange
    when(serverInformationDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
            ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build());

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
    ServerSummaryStatistics actualCalculateStatsForAppSelectorResult =
        serverInformationService.calculateStatsForAppSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(serverInformationDao).calculateStatsForAppSelector(isA(Select.class));
    assertTrue(
        actualCalculateStatsForAppSelectorResult instanceof ImmutableServerSummaryStatistics);
  }

  /**
   * Test {@link ServerInformationService#calculateStatsForAppSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ServerInformationService#calculateStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatsForAppSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ServerSummaryStatistics ServerInformationService.calculateStatsForAppSelector(IdSelectionOptions)"
  })
  void testCalculateStatsForAppSelector4() {
    // Arrange
    when(serverInformationDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
            ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build());

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
    ServerSummaryStatistics actualCalculateStatsForAppSelectorResult =
        serverInformationService.calculateStatsForAppSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(serverInformationDao).calculateStatsForAppSelector(isA(Select.class));
    assertTrue(
        actualCalculateStatsForAppSelectorResult instanceof ImmutableServerSummaryStatistics);
  }

  /**
   * Test {@link ServerInformationService#calculateStatsForAppSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ServerInformationService#calculateStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatsForAppSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ServerSummaryStatistics ServerInformationService.calculateStatsForAppSelector(IdSelectionOptions)"
  })
  void testCalculateStatsForAppSelector5() {
    // Arrange
    when(serverInformationDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
            ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build());

    ImmutableApplicationIdSelectionOptions.Builder builderResult =
        ImmutableApplicationIdSelectionOptions.builder();

    ImmutableApplicationIdSelectionOptions.Builder filtersResult =
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

    ImmutableApplicationIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ServerSummaryStatistics actualCalculateStatsForAppSelectorResult =
        serverInformationService.calculateStatsForAppSelector(
            joiningEntityKindResult
                .addAllApplicationKinds(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(serverInformationDao).calculateStatsForAppSelector(isA(Select.class));
    assertTrue(
        actualCalculateStatsForAppSelectorResult instanceof ImmutableServerSummaryStatistics);
  }

  /**
   * Test {@link ServerInformationService#calculateStatsForAppSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ServerInformationService#calculateStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatsForAppSelector(IdSelectionOptions); given 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ServerSummaryStatistics ServerInformationService.calculateStatsForAppSelector(IdSelectionOptions)"
  })
  void testCalculateStatsForAppSelector_givenActive() {
    // Arrange
    when(serverInformationDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
            ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build());

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
    ServerSummaryStatistics actualCalculateStatsForAppSelectorResult =
        serverInformationService.calculateStatsForAppSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(serverInformationDao).calculateStatsForAppSelector(isA(Select.class));
    assertTrue(
        actualCalculateStatsForAppSelectorResult instanceof ImmutableServerSummaryStatistics);
  }

  /**
   * Test {@link ServerInformationService#calculateStatsForAppSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ServerInformationService#calculateStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatsForAppSelector(IdSelectionOptions); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ServerSummaryStatistics ServerInformationService.calculateStatsForAppSelector(IdSelectionOptions)"
  })
  void testCalculateStatsForAppSelector_givenInHouse() {
    // Arrange
    when(serverInformationDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
            ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build());

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
    ServerSummaryStatistics actualCalculateStatsForAppSelectorResult =
        serverInformationService.calculateStatsForAppSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(serverInformationDao).calculateStatsForAppSelector(isA(Select.class));
    assertTrue(
        actualCalculateStatsForAppSelectorResult instanceof ImmutableServerSummaryStatistics);
  }

  /**
   * Test {@link ServerInformationService#calculateStatsForAppSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ServerInformationService#calculateStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateStatsForAppSelector(IdSelectionOptions); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ServerSummaryStatistics ServerInformationService.calculateStatsForAppSelector(IdSelectionOptions)"
  })
  void testCalculateStatsForAppSelector_givenPending() {
    // Arrange
    when(serverInformationDao.calculateStatsForAppSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
            ImmutableServerSummaryStatistics.builder().physicalCount(3L).virtualCount(3L).build());

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
    ServerSummaryStatistics actualCalculateStatsForAppSelectorResult =
        serverInformationService.calculateStatsForAppSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(serverInformationDao).calculateStatsForAppSelector(isA(Select.class));
    assertTrue(
        actualCalculateStatsForAppSelectorResult instanceof ImmutableServerSummaryStatistics);
  }

  /**
   * Test {@link ServerInformationService#calculateBasicStatsForAppSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ServerInformationService#calculateBasicStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateBasicStatsForAppSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ServerSummaryBasicStatistics ServerInformationService.calculateBasicStatsForAppSelector(IdSelectionOptions)"
  })
  void testCalculateBasicStatsForAppSelector() {
    // Arrange
    when(serverInformationDao.calculateBasicStatsForAppSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
            ImmutableServerSummaryBasicStatistics.builder()
                .physicalCount(3L)
                .virtualCount(3L)
                .build());

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
    ServerSummaryBasicStatistics actualCalculateBasicStatsForAppSelectorResult =
        serverInformationService.calculateBasicStatsForAppSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(serverInformationDao).calculateBasicStatsForAppSelector(isA(Select.class));
    assertTrue(
        actualCalculateBasicStatsForAppSelectorResult
            instanceof ImmutableServerSummaryBasicStatistics);
    assertEquals(3L, actualCalculateBasicStatsForAppSelectorResult.physicalCount());
    assertEquals(3L, actualCalculateBasicStatsForAppSelectorResult.virtualCount());
    assertEquals(6L, actualCalculateBasicStatsForAppSelectorResult.totalCount());
  }

  /**
   * Test {@link ServerInformationService#calculateBasicStatsForAppSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ServerInformationService#calculateBasicStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateBasicStatsForAppSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ServerSummaryBasicStatistics ServerInformationService.calculateBasicStatsForAppSelector(IdSelectionOptions)"
  })
  void testCalculateBasicStatsForAppSelector2() {
    // Arrange
    when(serverInformationDao.calculateBasicStatsForAppSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
            ImmutableServerSummaryBasicStatistics.builder()
                .physicalCount(3L)
                .virtualCount(3L)
                .build());

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
    ServerSummaryBasicStatistics actualCalculateBasicStatsForAppSelectorResult =
        serverInformationService.calculateBasicStatsForAppSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(serverInformationDao).calculateBasicStatsForAppSelector(isA(Select.class));
    assertTrue(
        actualCalculateBasicStatsForAppSelectorResult
            instanceof ImmutableServerSummaryBasicStatistics);
    assertEquals(3L, actualCalculateBasicStatsForAppSelectorResult.physicalCount());
    assertEquals(3L, actualCalculateBasicStatsForAppSelectorResult.virtualCount());
    assertEquals(6L, actualCalculateBasicStatsForAppSelectorResult.totalCount());
  }

  /**
   * Test {@link ServerInformationService#calculateBasicStatsForAppSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ServerInformationService#calculateBasicStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateBasicStatsForAppSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ServerSummaryBasicStatistics ServerInformationService.calculateBasicStatsForAppSelector(IdSelectionOptions)"
  })
  void testCalculateBasicStatsForAppSelector3() {
    // Arrange
    when(serverInformationDao.calculateBasicStatsForAppSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
            ImmutableServerSummaryBasicStatistics.builder()
                .physicalCount(3L)
                .virtualCount(3L)
                .build());

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
    ServerSummaryBasicStatistics actualCalculateBasicStatsForAppSelectorResult =
        serverInformationService.calculateBasicStatsForAppSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(serverInformationDao).calculateBasicStatsForAppSelector(isA(Select.class));
    assertTrue(
        actualCalculateBasicStatsForAppSelectorResult
            instanceof ImmutableServerSummaryBasicStatistics);
    assertEquals(3L, actualCalculateBasicStatsForAppSelectorResult.physicalCount());
    assertEquals(3L, actualCalculateBasicStatsForAppSelectorResult.virtualCount());
    assertEquals(6L, actualCalculateBasicStatsForAppSelectorResult.totalCount());
  }

  /**
   * Test {@link ServerInformationService#calculateBasicStatsForAppSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ServerInformationService#calculateBasicStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateBasicStatsForAppSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ServerSummaryBasicStatistics ServerInformationService.calculateBasicStatsForAppSelector(IdSelectionOptions)"
  })
  void testCalculateBasicStatsForAppSelector4() {
    // Arrange
    when(serverInformationDao.calculateBasicStatsForAppSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
            ImmutableServerSummaryBasicStatistics.builder()
                .physicalCount(3L)
                .virtualCount(3L)
                .build());

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
    ServerSummaryBasicStatistics actualCalculateBasicStatsForAppSelectorResult =
        serverInformationService.calculateBasicStatsForAppSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(serverInformationDao).calculateBasicStatsForAppSelector(isA(Select.class));
    assertTrue(
        actualCalculateBasicStatsForAppSelectorResult
            instanceof ImmutableServerSummaryBasicStatistics);
    assertEquals(3L, actualCalculateBasicStatsForAppSelectorResult.physicalCount());
    assertEquals(3L, actualCalculateBasicStatsForAppSelectorResult.virtualCount());
    assertEquals(6L, actualCalculateBasicStatsForAppSelectorResult.totalCount());
  }

  /**
   * Test {@link ServerInformationService#calculateBasicStatsForAppSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ServerInformationService#calculateBasicStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateBasicStatsForAppSelector(IdSelectionOptions); given 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ServerSummaryBasicStatistics ServerInformationService.calculateBasicStatsForAppSelector(IdSelectionOptions)"
  })
  void testCalculateBasicStatsForAppSelector_givenActive() {
    // Arrange
    when(serverInformationDao.calculateBasicStatsForAppSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
            ImmutableServerSummaryBasicStatistics.builder()
                .physicalCount(3L)
                .virtualCount(3L)
                .build());

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
    ServerSummaryBasicStatistics actualCalculateBasicStatsForAppSelectorResult =
        serverInformationService.calculateBasicStatsForAppSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(serverInformationDao).calculateBasicStatsForAppSelector(isA(Select.class));
    assertTrue(
        actualCalculateBasicStatsForAppSelectorResult
            instanceof ImmutableServerSummaryBasicStatistics);
    assertEquals(3L, actualCalculateBasicStatsForAppSelectorResult.physicalCount());
    assertEquals(3L, actualCalculateBasicStatsForAppSelectorResult.virtualCount());
    assertEquals(6L, actualCalculateBasicStatsForAppSelectorResult.totalCount());
  }

  /**
   * Test {@link ServerInformationService#calculateBasicStatsForAppSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ServerInformationService#calculateBasicStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateBasicStatsForAppSelector(IdSelectionOptions); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ServerSummaryBasicStatistics ServerInformationService.calculateBasicStatsForAppSelector(IdSelectionOptions)"
  })
  void testCalculateBasicStatsForAppSelector_givenInHouse() {
    // Arrange
    when(serverInformationDao.calculateBasicStatsForAppSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
            ImmutableServerSummaryBasicStatistics.builder()
                .physicalCount(3L)
                .virtualCount(3L)
                .build());

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
    ServerSummaryBasicStatistics actualCalculateBasicStatsForAppSelectorResult =
        serverInformationService.calculateBasicStatsForAppSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(serverInformationDao).calculateBasicStatsForAppSelector(isA(Select.class));
    assertTrue(
        actualCalculateBasicStatsForAppSelectorResult
            instanceof ImmutableServerSummaryBasicStatistics);
    assertEquals(3L, actualCalculateBasicStatsForAppSelectorResult.physicalCount());
    assertEquals(3L, actualCalculateBasicStatsForAppSelectorResult.virtualCount());
    assertEquals(6L, actualCalculateBasicStatsForAppSelectorResult.totalCount());
  }

  /**
   * Test {@link ServerInformationService#calculateBasicStatsForAppSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ServerInformationService#calculateBasicStatsForAppSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test calculateBasicStatsForAppSelector(IdSelectionOptions); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ServerSummaryBasicStatistics ServerInformationService.calculateBasicStatsForAppSelector(IdSelectionOptions)"
  })
  void testCalculateBasicStatsForAppSelector_givenPending() {
    // Arrange
    when(serverInformationDao.calculateBasicStatsForAppSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
            ImmutableServerSummaryBasicStatistics.builder()
                .physicalCount(3L)
                .virtualCount(3L)
                .build());

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
    ServerSummaryBasicStatistics actualCalculateBasicStatsForAppSelectorResult =
        serverInformationService.calculateBasicStatsForAppSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(serverInformationDao).calculateBasicStatsForAppSelector(isA(Select.class));
    assertTrue(
        actualCalculateBasicStatsForAppSelectorResult
            instanceof ImmutableServerSummaryBasicStatistics);
    assertEquals(3L, actualCalculateBasicStatsForAppSelectorResult.physicalCount());
    assertEquals(3L, actualCalculateBasicStatsForAppSelectorResult.virtualCount());
    assertEquals(6L, actualCalculateBasicStatsForAppSelectorResult.totalCount());
  }

  /**
   * Test {@link ServerInformationService#search(EntitySearchOptions)} with {@code options}.
   *
   * <p>Method under test: {@link ServerInformationService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions) with 'options'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ServerInformationService.search(EntitySearchOptions)"})
  void testSearchWithOptions() {
    // Arrange
    when(serverInformationSearchDao.search(Mockito.<EntitySearchOptions>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<ServerInformation> actualSearchResult =
        serverInformationService.search((EntitySearchOptions) null);

    // Assert
    verify(serverInformationSearchDao).search(isNull());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link ServerInformationService#search(String)} with {@code query}.
   *
   * <ul>
   *   <li>Given {@link ServerInformationSearchDao}.
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link ServerInformationService#search(String)}
   */
  @Test
  @DisplayName(
      "Test search(String) with 'query'; given ServerInformationSearchDao; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ServerInformationService.search(String)"})
  void testSearchWithQuery_givenServerInformationSearchDao_whenEmptyString() {
    // Arrange, Act and Assert
    assertTrue(serverInformationService.search("").isEmpty());
  }

  /**
   * Test {@link ServerInformationService#search(String)} with {@code query}.
   *
   * <ul>
   *   <li>Then calls {@link ServerInformationSearchDao#search(EntitySearchOptions)}.
   * </ul>
   *
   * <p>Method under test: {@link ServerInformationService#search(String)}
   */
  @Test
  @DisplayName("Test search(String) with 'query'; then calls search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ServerInformationService.search(String)"})
  void testSearchWithQuery_thenCallsSearch() {
    // Arrange
    when(serverInformationSearchDao.search(Mockito.<EntitySearchOptions>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<ServerInformation> actualSearchResult = serverInformationService.search("Query");

    // Assert
    verify(serverInformationSearchDao).search(isA(EntitySearchOptions.class));
    assertTrue(actualSearchResult.isEmpty());
  }
}
