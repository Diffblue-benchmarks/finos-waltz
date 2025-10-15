package org.finos.waltz.service.licence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.licence.LicenceDao;
import org.finos.waltz.data.licence.search.LicenceSearchDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.licence.ImmutableLicence;
import org.finos.waltz.model.licence.ImmutableLicence.Builder;
import org.finos.waltz.model.licence.Licence;
import org.finos.waltz.model.licence.SaveLicenceCommand;
import org.finos.waltz.model.tally.Tally;
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
class LicenceServiceDiffblueTest {
  @Mock private LicenceDao licenceDao;

  @Mock private LicenceSearchDao licenceSearchDao;

  @InjectMocks private LicenceService licenceService;

  /**
   * Test {@link LicenceService#findAll()}.
   *
   * <p>Method under test: {@link LicenceService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LicenceService.findAll()"})
  void testFindAll() {
    // Arrange
    when(licenceDao.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<Licence> actualFindAllResult = licenceService.findAll();

    // Assert
    verify(licenceDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link LicenceService#getById(long)}.
   *
   * <p>Method under test: {@link LicenceService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Licence LicenceService.getById(long)"})
  void testGetById() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    when(licenceDao.getById(anyLong()))
        .thenReturn(
            idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build());

    // Act
    Licence actualById = licenceService.getById(1L);

    // Assert
    verify(licenceDao).getById(1L);
    assertTrue(actualById instanceof ImmutableLicence);
    assertEquals("Name", actualById.name());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("The characteristics of someone or something", actualById.description());
  }

  /**
   * Test {@link LicenceService#getByExternalId(String)}.
   *
   * <p>Method under test: {@link LicenceService#getByExternalId(String)}
   */
  @Test
  @DisplayName("Test getByExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Licence LicenceService.getByExternalId(String)"})
  void testGetByExternalId() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    when(licenceDao.getByExternalId(Mockito.<String>any()))
        .thenReturn(
            idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build());

    // Act
    Licence actualByExternalId = licenceService.getByExternalId("42");

    // Assert
    verify(licenceDao).getByExternalId("42");
    assertTrue(actualByExternalId instanceof ImmutableLicence);
    assertEquals("Name", actualByExternalId.name());
    assertEquals("Provenance", actualByExternalId.provenance());
    assertEquals("The characteristics of someone or something", actualByExternalId.description());
  }

  /**
   * Test {@link LicenceService#findBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LicenceService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LicenceService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector() {
    // Arrange
    when(licenceDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    List<Licence> actualFindBySelectorResult = licenceService.findBySelector(options);

    // Assert
    verify(licenceDao).findBySelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link LicenceService#findBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LicenceService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LicenceService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector2() {
    // Arrange
    when(licenceDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    List<Licence> actualFindBySelectorResult = licenceService.findBySelector(options);

    // Assert
    verify(licenceDao).findBySelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link LicenceService#findBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LicenceService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LicenceService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector3() {
    // Arrange
    when(licenceDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
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
    List<Licence> actualFindBySelectorResult = licenceService.findBySelector(options);

    // Assert
    verify(licenceDao).findBySelector(isA(Select.class));
    verify(options, atLeast(1)).entityReference();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link LicenceService#findBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LicenceService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LicenceService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector4() {
    // Arrange
    when(licenceDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    List<Licence> actualFindBySelectorResult = licenceService.findBySelector(options);

    // Assert
    verify(licenceDao).findBySelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link LicenceService#findBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LicenceService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LicenceService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector5() {
    // Arrange
    when(licenceDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
                .kind(EntityKind.CHANGE_INITIATIVE)
                .name("Name")
                .build());

    // Act
    List<Licence> actualFindBySelectorResult = licenceService.findBySelector(options);

    // Assert
    verify(licenceDao).findBySelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link LicenceService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions); given builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LicenceService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    when(licenceDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    List<Licence> actualFindBySelectorResult = licenceService.findBySelector(options);

    // Assert
    verify(licenceDao).findBySelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link LicenceService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions); given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LicenceService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenHashSetAddActive() {
    // Arrange
    when(licenceDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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

    // Act
    List<Licence> actualFindBySelectorResult = licenceService.findBySelector(options);

    // Assert
    verify(licenceDao).findBySelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link LicenceService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions); given HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LicenceService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenHashSetAddPending() {
    // Arrange
    when(licenceDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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

    // Act
    List<Licence> actualFindBySelectorResult = licenceService.findBySelector(options);

    // Assert
    verify(licenceDao).findBySelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link LicenceService#countApplications()}.
   *
   * <p>Method under test: {@link LicenceService#countApplications()}
   */
  @Test
  @DisplayName("Test countApplications()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LicenceService.countApplications()"})
  void testCountApplications() {
    // Arrange
    when(licenceDao.countApplications()).thenReturn(new ArrayList<>());

    // Act
    List<Tally<Long>> actualCountApplicationsResult = licenceService.countApplications();

    // Assert
    verify(licenceDao).countApplications();
    assertTrue(actualCountApplicationsResult.isEmpty());
  }

  /**
   * Test {@link LicenceService#save(SaveLicenceCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link LicenceDao} {@link LicenceDao#save(SaveLicenceCommand, String)} return
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceService#save(SaveLicenceCommand, String)}
   */
  @Test
  @DisplayName(
      "Test save(SaveLicenceCommand, String); given LicenceDao save(SaveLicenceCommand, String) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LicenceService.save(SaveLicenceCommand, String)"})
  void testSave_givenLicenceDaoSaveReturnFalse_thenReturnFalse() {
    // Arrange
    when(licenceDao.save(Mockito.<SaveLicenceCommand>any(), Mockito.<String>any()))
        .thenReturn(false);

    // Act
    boolean actualSaveResult = licenceService.save(null, "janedoe");

    // Assert
    verify(licenceDao).save(isNull(), eq("janedoe"));
    assertFalse(actualSaveResult);
  }

  /**
   * Test {@link LicenceService#save(SaveLicenceCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link LicenceDao} {@link LicenceDao#save(SaveLicenceCommand, String)} return
   *       {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceService#save(SaveLicenceCommand, String)}
   */
  @Test
  @DisplayName(
      "Test save(SaveLicenceCommand, String); given LicenceDao save(SaveLicenceCommand, String) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LicenceService.save(SaveLicenceCommand, String)"})
  void testSave_givenLicenceDaoSaveReturnTrue_thenReturnTrue() {
    // Arrange
    when(licenceDao.save(Mockito.<SaveLicenceCommand>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    boolean actualSaveResult = licenceService.save(null, "janedoe");

    // Assert
    verify(licenceDao).save(isNull(), eq("janedoe"));
    assertTrue(actualSaveResult);
  }

  /**
   * Test {@link LicenceService#remove(long, String)}.
   *
   * <ul>
   *   <li>Given {@link LicenceDao} {@link LicenceDao#remove(long)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceService#remove(long, String)}
   */
  @Test
  @DisplayName(
      "Test remove(long, String); given LicenceDao remove(long) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LicenceService.remove(long, String)"})
  void testRemove_givenLicenceDaoRemoveReturnFalse_thenReturnFalse() {
    // Arrange
    when(licenceDao.remove(anyLong())).thenReturn(false);

    // Act
    boolean actualRemoveResult = licenceService.remove(1L, "janedoe");

    // Assert
    verify(licenceDao).remove(1L);
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link LicenceService#remove(long, String)}.
   *
   * <ul>
   *   <li>Given {@link LicenceDao} {@link LicenceDao#remove(long)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceService#remove(long, String)}
   */
  @Test
  @DisplayName(
      "Test remove(long, String); given LicenceDao remove(long) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LicenceService.remove(long, String)"})
  void testRemove_givenLicenceDaoRemoveReturnTrue_thenReturnTrue() {
    // Arrange
    when(licenceDao.remove(anyLong())).thenReturn(true);

    // Act
    boolean actualRemoveResult = licenceService.remove(1L, "janedoe");

    // Assert
    verify(licenceDao).remove(1L);
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link LicenceService#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link LicenceService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection LicenceService.search(EntitySearchOptions)"})
  void testSearch() {
    // Arrange
    ArrayList<Licence> licenceList = new ArrayList<>();
    when(licenceSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(licenceList);

    // Act
    Collection<Licence> actualSearchResult = licenceService.search(null);

    // Assert
    verify(licenceSearchDao).search(isNull());
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
    assertSame(licenceList, actualSearchResult);
  }
}
