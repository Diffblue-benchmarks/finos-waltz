package org.finos.waltz.service.taxonomy_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.change_initiative.ChangeInitiativeDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.client_cache_key.ClientCacheKeyDao;
import org.finos.waltz.data.data_type.DataTypeDao;
import org.finos.waltz.data.entity_hierarchy.EntityHierarchyDao;
import org.finos.waltz.data.entity_statistic.EntityStatisticDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable.MeasurableDao;
import org.finos.waltz.data.measurable.search.MeasurableSearchDao;
import org.finos.waltz.data.measurable_category.MeasurableCategoryDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.orgunit.OrganisationalUnitDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.person.search.PersonSearchDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.role.RoleDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.data.taxonomy_management.TaxonomyChangeDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.taxonomy_management.ImmutableTaxonomyChangeCommand;
import org.finos.waltz.model.taxonomy_management.ImmutableTaxonomyChangeCommand.Builder;
import org.finos.waltz.model.taxonomy_management.ImmutableTaxonomyChangePreview;
import org.finos.waltz.model.taxonomy_management.TaxonomyChangeCommand;
import org.finos.waltz.model.taxonomy_management.TaxonomyChangeLifecycleStatus;
import org.finos.waltz.model.taxonomy_management.TaxonomyChangePreview;
import org.finos.waltz.model.taxonomy_management.TaxonomyChangeType;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.client_cache_key.ClientCacheKeyService;
import org.finos.waltz.service.entity_hierarchy.EntityHierarchyService;
import org.finos.waltz.service.measurable.MeasurableService;
import org.finos.waltz.service.measurable_category.MeasurableCategoryService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.person_hierarchy.PersonHierarchyService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.taxonomy_management.processors.AddMeasurableCommandProcessor;
import org.finos.waltz.service.user.UserRoleService;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TaxonomyChangeServiceDiffblueTest {
  @Mock private ClientCacheKeyService clientCacheKeyService;

  @Mock private List<TaxonomyCommandProcessor> list;

  @Mock private TaxonomyChangeDao taxonomyChangeDao;

  @InjectMocks private TaxonomyChangeService taxonomyChangeService;

  @Mock private UserRoleService userRoleService;

  /**
   * Test {@link TaxonomyChangeService#previewById(long)}.
   *
   * <ul>
   *   <li>Then return errorMessage is a string.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyChangeService#previewById(long)}
   */
  @Test
  @DisplayName("Test previewById(long); then return errorMessage is a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TaxonomyChangePreview TaxonomyChangeService.previewById(long)"})
  void testPreviewById_thenReturnErrorMessageIsAString() {
    // Arrange
    TaxonomyChangeDao taxonomyChangeDao = mock(TaxonomyChangeDao.class);

    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    when(taxonomyChangeDao.getDraftCommandById(anyLong()))
        .thenReturn(
            paramsResult
                .primaryReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .status(TaxonomyChangeLifecycleStatus.DRAFT)
                .build());

    ArrayList<TaxonomyCommandProcessor> processors = new ArrayList<>();
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);
    processors.add(new AddMeasurableCommandProcessor(measurableService));
    ClientCacheKeyService clientCacheKeyService =
        new ClientCacheKeyService(mock(ClientCacheKeyDao.class));
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService2, personService, settingsService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService4 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    MeasurableService measurableService2 =
        new MeasurableService(
            measurableDao2, measurableSearchDao2, nameResolver2, changeLogService4);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService3,
            measurableService2,
            settingsService2);
    UserRoleDao userRoleDao2 = mock(UserRoleDao.class);
    RoleDao roleDao2 = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService5 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao3 = mock(SettingsDao.class);
    SettingsService settingsService3 = new SettingsService(settingsDao3, new ArrayList<>());

    UserRoleService userRoleService2 =
        new UserRoleService(
            userRoleDao2,
            roleDao2,
            personDao2,
            changeLogService5,
            personService2,
            settingsService3);
    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao3 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver3 = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService6 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    MeasurableService measurableService3 =
        new MeasurableService(
            measurableDao3, measurableSearchDao3, nameResolver3, changeLogService6);
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao4 = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao3, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao4,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    TaxonomyChangeService taxonomyChangeService =
        new TaxonomyChangeService(
            taxonomyChangeDao,
            clientCacheKeyService,
            measurableCategoryService,
            userRoleService2,
            processors,
            measurableService3,
            entityHierarchyService);

    // Act
    TaxonomyChangePreview actualPreviewByIdResult = taxonomyChangeService.previewById(1L);

    // Assert
    verify(taxonomyChangeDao).getDraftCommandById(1L);
    TaxonomyChangeCommand commandResult = actualPreviewByIdResult.command();
    EntityReference changeDomainResult = commandResult.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    EntityReference primaryReferenceResult = commandResult.primaryReference();
    assertTrue(primaryReferenceResult instanceof ImmutableEntityReference);
    assertTrue(commandResult instanceof ImmutableTaxonomyChangeCommand);
    assertTrue(actualPreviewByIdResult instanceof ImmutableTaxonomyChangePreview);
    assertEquals("2020-03-01", commandResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", commandResult.createdBy());
    assertEquals(
        "Taxonomy change command must be either a [MEASURABLE_CATEGORY] or a [DATA_TYPE], instead is"
            + " is a [ALL]",
        actualPreviewByIdResult.errorMessage());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, commandResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, commandResult.changeType());
    assertTrue(actualPreviewByIdResult.impacts().isEmpty());
    assertTrue(commandResult.params().isEmpty());
    assertEquals(changeDomainResult, primaryReferenceResult);
  }

  /**
   * Test {@link TaxonomyChangeService#previewById(long)}.
   *
   * <ul>
   *   <li>Then return errorMessage is {@code Cannot find processor for type: ADD_PEER}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyChangeService#previewById(long)}
   */
  @Test
  @DisplayName(
      "Test previewById(long); then return errorMessage is 'Cannot find processor for type: ADD_PEER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TaxonomyChangePreview TaxonomyChangeService.previewById(long)"})
  void testPreviewById_thenReturnErrorMessageIsCannotFindProcessorForTypeAddPeer() {
    // Arrange
    TaxonomyChangeDao taxonomyChangeDao = mock(TaxonomyChangeDao.class);

    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    when(taxonomyChangeDao.getDraftCommandById(anyLong()))
        .thenReturn(
            paramsResult
                .primaryReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .status(TaxonomyChangeLifecycleStatus.DRAFT)
                .build());
    ClientCacheKeyService clientCacheKeyService =
        new ClientCacheKeyService(mock(ClientCacheKeyDao.class));
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService2,
            measurableService,
            settingsService2);
    UserRoleDao userRoleDao2 = mock(UserRoleDao.class);
    RoleDao roleDao2 = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService4 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao3 = mock(SettingsDao.class);
    SettingsService settingsService3 = new SettingsService(settingsDao3, new ArrayList<>());

    UserRoleService userRoleService2 =
        new UserRoleService(
            userRoleDao2,
            roleDao2,
            personDao2,
            changeLogService4,
            personService2,
            settingsService3);
    ArrayList<TaxonomyCommandProcessor> processors = new ArrayList<>();
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService5 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    MeasurableService measurableService2 =
        new MeasurableService(
            measurableDao2, measurableSearchDao2, nameResolver2, changeLogService5);
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao3, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao3,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    TaxonomyChangeService taxonomyChangeService =
        new TaxonomyChangeService(
            taxonomyChangeDao,
            clientCacheKeyService,
            measurableCategoryService,
            userRoleService2,
            processors,
            measurableService2,
            entityHierarchyService);

    // Act
    TaxonomyChangePreview actualPreviewByIdResult = taxonomyChangeService.previewById(1L);

    // Assert
    verify(taxonomyChangeDao).getDraftCommandById(1L);
    TaxonomyChangeCommand commandResult = actualPreviewByIdResult.command();
    EntityReference changeDomainResult = commandResult.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    EntityReference primaryReferenceResult = commandResult.primaryReference();
    assertTrue(primaryReferenceResult instanceof ImmutableEntityReference);
    assertTrue(commandResult instanceof ImmutableTaxonomyChangeCommand);
    assertTrue(actualPreviewByIdResult instanceof ImmutableTaxonomyChangePreview);
    assertEquals("2020-03-01", commandResult.lastUpdatedBy());
    assertEquals(
        "Cannot find processor for type: ADD_PEER", actualPreviewByIdResult.errorMessage());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", commandResult.createdBy());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, commandResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, commandResult.changeType());
    assertTrue(actualPreviewByIdResult.impacts().isEmpty());
    assertTrue(commandResult.params().isEmpty());
    assertEquals(changeDomainResult, primaryReferenceResult);
  }

  /**
   * Test {@link TaxonomyChangeService#previewById(long)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyChangeService#previewById(long)}
   */
  @Test
  @DisplayName("Test previewById(long); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TaxonomyChangePreview TaxonomyChangeService.previewById(long)"})
  void testPreviewById_thenThrowRuntimeException() {
    // Arrange
    TaxonomyChangeDao taxonomyChangeDao = mock(TaxonomyChangeDao.class);
    when(taxonomyChangeDao.getDraftCommandById(anyLong())).thenThrow(new RuntimeException());
    ClientCacheKeyService clientCacheKeyService =
        new ClientCacheKeyService(mock(ClientCacheKeyDao.class));
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService2,
            measurableService,
            settingsService2);
    UserRoleDao userRoleDao2 = mock(UserRoleDao.class);
    RoleDao roleDao2 = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService4 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao3 = mock(SettingsDao.class);
    SettingsService settingsService3 = new SettingsService(settingsDao3, new ArrayList<>());

    UserRoleService userRoleService2 =
        new UserRoleService(
            userRoleDao2,
            roleDao2,
            personDao2,
            changeLogService4,
            personService2,
            settingsService3);
    ArrayList<TaxonomyCommandProcessor> processors = new ArrayList<>();
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService5 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    MeasurableService measurableService2 =
        new MeasurableService(
            measurableDao2, measurableSearchDao2, nameResolver2, changeLogService5);
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao3, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao3,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    TaxonomyChangeService taxonomyChangeService =
        new TaxonomyChangeService(
            taxonomyChangeDao,
            clientCacheKeyService,
            measurableCategoryService,
            userRoleService2,
            processors,
            measurableService2,
            entityHierarchyService);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> taxonomyChangeService.previewById(1L));
    verify(taxonomyChangeDao).getDraftCommandById(1L);
  }

  /**
   * Test {@link TaxonomyChangeService#submitDraftChange(TaxonomyChangeCommand, String)}.
   *
   * <p>Method under test: {@link TaxonomyChangeService#submitDraftChange(TaxonomyChangeCommand,
   * String)}
   */
  @Test
  @DisplayName("Test submitDraftChange(TaxonomyChangeCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TaxonomyChangeCommand TaxonomyChangeService.submitDraftChange(TaxonomyChangeCommand, String)"
  })
  void testSubmitDraftChange() {
    // Arrange
    TaxonomyChangeDao taxonomyChangeDao = mock(TaxonomyChangeDao.class);

    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    when(taxonomyChangeDao.createCommand(Mockito.<TaxonomyChangeCommand>any()))
        .thenReturn(
            paramsResult
                .primaryReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .status(TaxonomyChangeLifecycleStatus.DRAFT)
                .build());

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    ClientCacheKeyService clientCacheKeyService =
        new ClientCacheKeyService(mock(ClientCacheKeyDao.class));
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService2 =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService2,
            changeLogService2,
            measurableService,
            settingsService2);
    ArrayList<TaxonomyCommandProcessor> processors = new ArrayList<>();
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService4 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    MeasurableService measurableService2 =
        new MeasurableService(
            measurableDao2, measurableSearchDao2, nameResolver2, changeLogService4);
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao2, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao3,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    TaxonomyChangeService taxonomyChangeService =
        new TaxonomyChangeService(
            taxonomyChangeDao,
            clientCacheKeyService,
            measurableCategoryService,
            userRoleService,
            processors,
            measurableService2,
            entityHierarchyService);

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult2 = lastUpdatedByResult2.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand draftCommand =
        paramsResult2
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act
    TaxonomyChangeCommand actualSubmitDraftChangeResult =
        taxonomyChangeService.submitDraftChange(draftCommand, "42");

    // Assert
    verify(taxonomyChangeDao).createCommand(isA(TaxonomyChangeCommand.class));
    verify(userRoleService).hasRole(eq("42"), (String[]) Mockito.any());
    assertTrue(actualSubmitDraftChangeResult instanceof ImmutableTaxonomyChangeCommand);
    assertEquals(draftCommand, actualSubmitDraftChangeResult);
  }

  /**
   * Test {@link TaxonomyChangeService#submitDraftChange(TaxonomyChangeCommand, String)}.
   *
   * <p>Method under test: {@link TaxonomyChangeService#submitDraftChange(TaxonomyChangeCommand,
   * String)}
   */
  @Test
  @DisplayName("Test submitDraftChange(TaxonomyChangeCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TaxonomyChangeCommand TaxonomyChangeService.submitDraftChange(TaxonomyChangeCommand, String)"
  })
  void testSubmitDraftChange2() {
    // Arrange
    TaxonomyChangeDao taxonomyChangeDao = mock(TaxonomyChangeDao.class);

    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    when(taxonomyChangeDao.createCommand(Mockito.<TaxonomyChangeCommand>any()))
        .thenReturn(
            paramsResult
                .primaryReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .status(TaxonomyChangeLifecycleStatus.DRAFT)
                .build());

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    ClientCacheKeyService clientCacheKeyService =
        new ClientCacheKeyService(mock(ClientCacheKeyDao.class));
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService2 =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService2,
            changeLogService2,
            measurableService,
            settingsService2);
    ArrayList<TaxonomyCommandProcessor> processors = new ArrayList<>();
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService4 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    MeasurableService measurableService2 =
        new MeasurableService(
            measurableDao2, measurableSearchDao2, nameResolver2, changeLogService4);
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao2, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao3,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    TaxonomyChangeService taxonomyChangeService =
        new TaxonomyChangeService(
            taxonomyChangeDao,
            clientCacheKeyService,
            measurableCategoryService,
            userRoleService,
            processors,
            measurableService2,
            entityHierarchyService);

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult2 = lastUpdatedByResult2.params(new HashMap<>());

    // Act
    TaxonomyChangeCommand actualSubmitDraftChangeResult =
        taxonomyChangeService.submitDraftChange(
            paramsResult2
                .primaryReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .status(TaxonomyChangeLifecycleStatus.DRAFT)
                .build(),
            "42");

    // Assert
    verify(taxonomyChangeDao).createCommand(isA(TaxonomyChangeCommand.class));
    verify(userRoleService).hasRole(eq("42"), (String[]) Mockito.any());
    EntityReference changeDomainResult = actualSubmitDraftChangeResult.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    EntityReference primaryReferenceResult = actualSubmitDraftChangeResult.primaryReference();
    assertTrue(primaryReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualSubmitDraftChangeResult instanceof ImmutableTaxonomyChangeCommand);
    assertEquals("2020-03-01", actualSubmitDraftChangeResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualSubmitDraftChangeResult.createdBy());
    assertEquals("The characteristics of someone or something", changeDomainResult.description());
    assertEquals(1L, changeDomainResult.id());
    assertEquals(EntityKind.ALL, changeDomainResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, changeDomainResult.entityLifecycleStatus());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, actualSubmitDraftChangeResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, actualSubmitDraftChangeResult.changeType());
    assertTrue(actualSubmitDraftChangeResult.params().isEmpty());
    assertEquals(changeDomainResult, primaryReferenceResult);
    assertSame(ofResult, actualSubmitDraftChangeResult.createdAt().toLocalDate());
    assertSame(ofResult2, actualSubmitDraftChangeResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link TaxonomyChangeService#submitDraftChange(TaxonomyChangeCommand, String)}.
   *
   * <p>Method under test: {@link TaxonomyChangeService#submitDraftChange(TaxonomyChangeCommand,
   * String)}
   */
  @Test
  @DisplayName("Test submitDraftChange(TaxonomyChangeCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TaxonomyChangeCommand TaxonomyChangeService.submitDraftChange(TaxonomyChangeCommand, String)"
  })
  void testSubmitDraftChange3() {
    // Arrange
    TaxonomyChangeDao taxonomyChangeDao = mock(TaxonomyChangeDao.class);

    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    when(taxonomyChangeDao.createCommand(Mockito.<TaxonomyChangeCommand>any()))
        .thenReturn(
            paramsResult
                .primaryReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .status(TaxonomyChangeLifecycleStatus.DRAFT)
                .build());

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    ClientCacheKeyService clientCacheKeyService =
        new ClientCacheKeyService(mock(ClientCacheKeyDao.class));
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService2 =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService2,
            changeLogService2,
            measurableService,
            settingsService2);
    ArrayList<TaxonomyCommandProcessor> processors = new ArrayList<>();
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService4 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    MeasurableService measurableService2 =
        new MeasurableService(
            measurableDao2, measurableSearchDao2, nameResolver2, changeLogService4);
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao2, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao3,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    TaxonomyChangeService taxonomyChangeService =
        new TaxonomyChangeService(
            taxonomyChangeDao,
            clientCacheKeyService,
            measurableCategoryService,
            userRoleService,
            processors,
            measurableService2,
            entityHierarchyService);

    Builder builderResult2 = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42");

    Builder paramsResult2 = lastUpdatedByResult2.params(new HashMap<>());

    // Act
    TaxonomyChangeCommand actualSubmitDraftChangeResult =
        taxonomyChangeService.submitDraftChange(
            paramsResult2
                .primaryReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .status(TaxonomyChangeLifecycleStatus.DRAFT)
                .build(),
            "42");

    // Assert
    verify(taxonomyChangeDao).createCommand(isA(TaxonomyChangeCommand.class));
    verify(userRoleService).hasRole(eq("42"), (String[]) Mockito.any());
    EntityReference changeDomainResult = actualSubmitDraftChangeResult.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    EntityReference primaryReferenceResult = actualSubmitDraftChangeResult.primaryReference();
    assertTrue(primaryReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualSubmitDraftChangeResult instanceof ImmutableTaxonomyChangeCommand);
    assertEquals("2020-03-01", actualSubmitDraftChangeResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualSubmitDraftChangeResult.createdBy());
    assertEquals("The characteristics of someone or something", changeDomainResult.description());
    assertEquals(1L, changeDomainResult.id());
    assertEquals(EntityKind.ALL, changeDomainResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, changeDomainResult.entityLifecycleStatus());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, actualSubmitDraftChangeResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, actualSubmitDraftChangeResult.changeType());
    assertTrue(actualSubmitDraftChangeResult.params().isEmpty());
    assertEquals(changeDomainResult, primaryReferenceResult);
    assertSame(ofResult, actualSubmitDraftChangeResult.createdAt().toLocalDate());
    assertSame(ofResult2, actualSubmitDraftChangeResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link TaxonomyChangeService#submitDraftChange(TaxonomyChangeCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code Command must be DRAFT} is {@code Command must be
   *       DRAFT}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyChangeService#submitDraftChange(TaxonomyChangeCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test submitDraftChange(TaxonomyChangeCommand, String); given HashMap() 'Command must be DRAFT' is 'Command must be DRAFT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TaxonomyChangeCommand TaxonomyChangeService.submitDraftChange(TaxonomyChangeCommand, String)"
  })
  void testSubmitDraftChange_givenHashMapCommandMustBeDraftIsCommandMustBeDraft() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    when(taxonomyChangeDao.createCommand(Mockito.<TaxonomyChangeCommand>any()))
        .thenReturn(
            paramsResult
                .primaryReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .status(TaxonomyChangeLifecycleStatus.DRAFT)
                .build());
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("Command must be DRAFT", "Command must be DRAFT");

    TaxonomyChangeCommand draftCommand = mock(TaxonomyChangeCommand.class);
    when(draftCommand.params()).thenReturn(stringStringMap);
    Optional<Long> emptyResult = Optional.empty();
    when(draftCommand.id()).thenReturn(emptyResult);
    when(draftCommand.primaryReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(draftCommand.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    when(draftCommand.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(draftCommand.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(draftCommand.lastUpdatedBy()).thenReturn("2020-03-01");
    when(draftCommand.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(draftCommand.status()).thenReturn(TaxonomyChangeLifecycleStatus.DRAFT);
    when(draftCommand.changeDomain())
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
    TaxonomyChangeCommand actualSubmitDraftChangeResult =
        taxonomyChangeService.submitDraftChange(draftCommand, "42");

    // Assert
    verify(taxonomyChangeDao).createCommand(isA(TaxonomyChangeCommand.class));
    verify(draftCommand).createdAt();
    verify(draftCommand).createdBy();
    verify(draftCommand).id();
    verify(draftCommand).lastUpdatedAt();
    verify(draftCommand).lastUpdatedBy();
    verify(draftCommand, atLeast(1)).changeDomain();
    verify(draftCommand).changeType();
    verify(draftCommand).params();
    verify(draftCommand).primaryReference();
    verify(draftCommand, atLeast(1)).status();
    verify(userRoleService).hasRole(eq("42"), (String[]) Mockito.any());
    EntityReference changeDomainResult = actualSubmitDraftChangeResult.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    EntityReference primaryReferenceResult = actualSubmitDraftChangeResult.primaryReference();
    assertTrue(primaryReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualSubmitDraftChangeResult instanceof ImmutableTaxonomyChangeCommand);
    assertEquals("2020-03-01", actualSubmitDraftChangeResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualSubmitDraftChangeResult.createdBy());
    assertEquals("The characteristics of someone or something", changeDomainResult.description());
    assertEquals(1L, changeDomainResult.id());
    assertEquals(EntityKind.ALL, changeDomainResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, changeDomainResult.entityLifecycleStatus());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, actualSubmitDraftChangeResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, actualSubmitDraftChangeResult.changeType());
    assertTrue(actualSubmitDraftChangeResult.params().isEmpty());
    assertEquals(changeDomainResult, primaryReferenceResult);
    assertSame(ofResult, actualSubmitDraftChangeResult.createdAt().toLocalDate());
    assertSame(ofResult2, actualSubmitDraftChangeResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link TaxonomyChangeService#submitDraftChange(TaxonomyChangeCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code instance} is {@code instance}.
   *   <li>Then calls {@link TaxonomyChangeCommand#createdAt()}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyChangeService#submitDraftChange(TaxonomyChangeCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test submitDraftChange(TaxonomyChangeCommand, String); given HashMap() 'instance' is 'instance'; then calls createdAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TaxonomyChangeCommand TaxonomyChangeService.submitDraftChange(TaxonomyChangeCommand, String)"
  })
  void testSubmitDraftChange_givenHashMapInstanceIsInstance_thenCallsCreatedAt() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    when(taxonomyChangeDao.createCommand(Mockito.<TaxonomyChangeCommand>any()))
        .thenReturn(
            paramsResult
                .primaryReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .status(TaxonomyChangeLifecycleStatus.DRAFT)
                .build());
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("instance", "instance");
    stringStringMap.put("Command must be DRAFT", "Command must be DRAFT");

    TaxonomyChangeCommand draftCommand = mock(TaxonomyChangeCommand.class);
    when(draftCommand.params()).thenReturn(stringStringMap);
    Optional<Long> emptyResult = Optional.empty();
    when(draftCommand.id()).thenReturn(emptyResult);
    when(draftCommand.primaryReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(draftCommand.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    when(draftCommand.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(draftCommand.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(draftCommand.lastUpdatedBy()).thenReturn("2020-03-01");
    when(draftCommand.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(draftCommand.status()).thenReturn(TaxonomyChangeLifecycleStatus.DRAFT);
    when(draftCommand.changeDomain())
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
    TaxonomyChangeCommand actualSubmitDraftChangeResult =
        taxonomyChangeService.submitDraftChange(draftCommand, "42");

    // Assert
    verify(taxonomyChangeDao).createCommand(isA(TaxonomyChangeCommand.class));
    verify(draftCommand).createdAt();
    verify(draftCommand).createdBy();
    verify(draftCommand).id();
    verify(draftCommand).lastUpdatedAt();
    verify(draftCommand).lastUpdatedBy();
    verify(draftCommand, atLeast(1)).changeDomain();
    verify(draftCommand).changeType();
    verify(draftCommand).params();
    verify(draftCommand).primaryReference();
    verify(draftCommand, atLeast(1)).status();
    verify(userRoleService).hasRole(eq("42"), (String[]) Mockito.any());
    EntityReference changeDomainResult = actualSubmitDraftChangeResult.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    EntityReference primaryReferenceResult = actualSubmitDraftChangeResult.primaryReference();
    assertTrue(primaryReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualSubmitDraftChangeResult instanceof ImmutableTaxonomyChangeCommand);
    assertEquals("2020-03-01", actualSubmitDraftChangeResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualSubmitDraftChangeResult.createdBy());
    assertEquals("The characteristics of someone or something", changeDomainResult.description());
    assertEquals(1L, changeDomainResult.id());
    assertEquals(EntityKind.ALL, changeDomainResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, changeDomainResult.entityLifecycleStatus());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, actualSubmitDraftChangeResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, actualSubmitDraftChangeResult.changeType());
    assertTrue(actualSubmitDraftChangeResult.params().isEmpty());
    assertEquals(changeDomainResult, primaryReferenceResult);
    assertSame(ofResult, actualSubmitDraftChangeResult.createdAt().toLocalDate());
    assertSame(ofResult2, actualSubmitDraftChangeResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link TaxonomyChangeService#submitDraftChange(TaxonomyChangeCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then calls {@link TaxonomyChangeCommand#createdAt()}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyChangeService#submitDraftChange(TaxonomyChangeCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test submitDraftChange(TaxonomyChangeCommand, String); given HashMap(); then calls createdAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TaxonomyChangeCommand TaxonomyChangeService.submitDraftChange(TaxonomyChangeCommand, String)"
  })
  void testSubmitDraftChange_givenHashMap_thenCallsCreatedAt() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    when(taxonomyChangeDao.createCommand(Mockito.<TaxonomyChangeCommand>any()))
        .thenReturn(
            paramsResult
                .primaryReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .status(TaxonomyChangeLifecycleStatus.DRAFT)
                .build());
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);

    TaxonomyChangeCommand draftCommand = mock(TaxonomyChangeCommand.class);
    when(draftCommand.params()).thenReturn(new HashMap<>());
    Optional<Long> emptyResult = Optional.empty();
    when(draftCommand.id()).thenReturn(emptyResult);
    when(draftCommand.primaryReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(draftCommand.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    when(draftCommand.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(draftCommand.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(draftCommand.lastUpdatedBy()).thenReturn("2020-03-01");
    when(draftCommand.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(draftCommand.status()).thenReturn(TaxonomyChangeLifecycleStatus.DRAFT);
    when(draftCommand.changeDomain())
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
    TaxonomyChangeCommand actualSubmitDraftChangeResult =
        taxonomyChangeService.submitDraftChange(draftCommand, "42");

    // Assert
    verify(taxonomyChangeDao).createCommand(isA(TaxonomyChangeCommand.class));
    verify(draftCommand).createdAt();
    verify(draftCommand).createdBy();
    verify(draftCommand).id();
    verify(draftCommand).lastUpdatedAt();
    verify(draftCommand).lastUpdatedBy();
    verify(draftCommand, atLeast(1)).changeDomain();
    verify(draftCommand).changeType();
    verify(draftCommand).params();
    verify(draftCommand).primaryReference();
    verify(draftCommand, atLeast(1)).status();
    verify(userRoleService).hasRole(eq("42"), (String[]) Mockito.any());
    EntityReference changeDomainResult = actualSubmitDraftChangeResult.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    EntityReference primaryReferenceResult = actualSubmitDraftChangeResult.primaryReference();
    assertTrue(primaryReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualSubmitDraftChangeResult instanceof ImmutableTaxonomyChangeCommand);
    assertEquals("2020-03-01", actualSubmitDraftChangeResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualSubmitDraftChangeResult.createdBy());
    assertEquals("The characteristics of someone or something", changeDomainResult.description());
    assertEquals(1L, changeDomainResult.id());
    assertEquals(EntityKind.ALL, changeDomainResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, changeDomainResult.entityLifecycleStatus());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, actualSubmitDraftChangeResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, actualSubmitDraftChangeResult.changeType());
    assertTrue(actualSubmitDraftChangeResult.params().isEmpty());
    assertEquals(changeDomainResult, primaryReferenceResult);
    assertSame(ofResult, actualSubmitDraftChangeResult.createdAt().toLocalDate());
    assertSame(ofResult2, actualSubmitDraftChangeResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link TaxonomyChangeService#findDraftChangesByDomain(EntityReference)}.
   *
   * <p>Method under test: {@link TaxonomyChangeService#findDraftChangesByDomain(EntityReference)}
   */
  @Test
  @DisplayName("Test findDraftChangesByDomain(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection TaxonomyChangeService.findDraftChangesByDomain(EntityReference)"})
  void testFindDraftChangesByDomain() {
    // Arrange
    TaxonomyChangeDao taxonomyChangeDao = mock(TaxonomyChangeDao.class);
    ArrayList<TaxonomyChangeCommand> taxonomyChangeCommandList = new ArrayList<>();
    when(taxonomyChangeDao.findChangesByDomainAndStatus(
            Mockito.<EntityReference>any(), Mockito.<TaxonomyChangeLifecycleStatus>any()))
        .thenReturn(taxonomyChangeCommandList);
    ClientCacheKeyService clientCacheKeyService =
        new ClientCacheKeyService(mock(ClientCacheKeyDao.class));
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService2,
            measurableService,
            settingsService2);
    UserRoleDao userRoleDao2 = mock(UserRoleDao.class);
    RoleDao roleDao2 = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService4 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao3 = mock(SettingsDao.class);
    SettingsService settingsService3 = new SettingsService(settingsDao3, new ArrayList<>());

    UserRoleService userRoleService2 =
        new UserRoleService(
            userRoleDao2,
            roleDao2,
            personDao2,
            changeLogService4,
            personService2,
            settingsService3);
    ArrayList<TaxonomyCommandProcessor> processors = new ArrayList<>();
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService5 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    MeasurableService measurableService2 =
        new MeasurableService(
            measurableDao2, measurableSearchDao2, nameResolver2, changeLogService5);
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao3, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao3,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    TaxonomyChangeService taxonomyChangeService =
        new TaxonomyChangeService(
            taxonomyChangeDao,
            clientCacheKeyService,
            measurableCategoryService,
            userRoleService2,
            processors,
            measurableService2,
            entityHierarchyService);

    // Act
    Collection<TaxonomyChangeCommand> actualFindDraftChangesByDomainResult =
        taxonomyChangeService.findDraftChangesByDomain(null);

    // Assert
    verify(taxonomyChangeDao)
        .findChangesByDomainAndStatus(isNull(), eq(TaxonomyChangeLifecycleStatus.DRAFT));
    assertTrue(actualFindDraftChangesByDomainResult instanceof List);
    assertTrue(actualFindDraftChangesByDomainResult.isEmpty());
    assertSame(taxonomyChangeCommandList, actualFindDraftChangesByDomainResult);
  }

  /**
   * Test {@link TaxonomyChangeService#findAllChangesByDomain(EntityReference)}.
   *
   * <p>Method under test: {@link TaxonomyChangeService#findAllChangesByDomain(EntityReference)}
   */
  @Test
  @DisplayName("Test findAllChangesByDomain(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection TaxonomyChangeService.findAllChangesByDomain(EntityReference)"})
  void testFindAllChangesByDomain() {
    // Arrange
    TaxonomyChangeDao taxonomyChangeDao = mock(TaxonomyChangeDao.class);
    ArrayList<TaxonomyChangeCommand> taxonomyChangeCommandList = new ArrayList<>();
    when(taxonomyChangeDao.findChangesByDomain(Mockito.<EntityReference>any()))
        .thenReturn(taxonomyChangeCommandList);
    ClientCacheKeyService clientCacheKeyService =
        new ClientCacheKeyService(mock(ClientCacheKeyDao.class));
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService2,
            measurableService,
            settingsService2);
    UserRoleDao userRoleDao2 = mock(UserRoleDao.class);
    RoleDao roleDao2 = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService4 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao3 = mock(SettingsDao.class);
    SettingsService settingsService3 = new SettingsService(settingsDao3, new ArrayList<>());

    UserRoleService userRoleService2 =
        new UserRoleService(
            userRoleDao2,
            roleDao2,
            personDao2,
            changeLogService4,
            personService2,
            settingsService3);
    ArrayList<TaxonomyCommandProcessor> processors = new ArrayList<>();
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService5 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    MeasurableService measurableService2 =
        new MeasurableService(
            measurableDao2, measurableSearchDao2, nameResolver2, changeLogService5);
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao3, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao3,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    TaxonomyChangeService taxonomyChangeService =
        new TaxonomyChangeService(
            taxonomyChangeDao,
            clientCacheKeyService,
            measurableCategoryService,
            userRoleService2,
            processors,
            measurableService2,
            entityHierarchyService);

    // Act
    Collection<TaxonomyChangeCommand> actualFindAllChangesByDomainResult =
        taxonomyChangeService.findAllChangesByDomain(null);

    // Assert
    verify(taxonomyChangeDao).findChangesByDomain(isNull());
    assertTrue(actualFindAllChangesByDomainResult instanceof List);
    assertTrue(actualFindAllChangesByDomainResult.isEmpty());
    assertSame(taxonomyChangeCommandList, actualFindAllChangesByDomainResult);
  }

  /**
   * Test {@link TaxonomyChangeService#removeById(long, String)}.
   *
   * <ul>
   *   <li>Given {@link TaxonomyChangeDao} {@link TaxonomyChangeDao#removeById(long, String)} return
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyChangeService#removeById(long, String)}
   */
  @Test
  @DisplayName(
      "Test removeById(long, String); given TaxonomyChangeDao removeById(long, String) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TaxonomyChangeService.removeById(long, String)"})
  void testRemoveById_givenTaxonomyChangeDaoRemoveByIdReturnFalse_thenReturnFalse() {
    // Arrange
    TaxonomyChangeDao taxonomyChangeDao = mock(TaxonomyChangeDao.class);
    when(taxonomyChangeDao.removeById(anyLong(), Mockito.<String>any())).thenReturn(false);

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    ClientCacheKeyService clientCacheKeyService =
        new ClientCacheKeyService(mock(ClientCacheKeyDao.class));
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService2 =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService2,
            changeLogService2,
            measurableService,
            settingsService2);
    ArrayList<TaxonomyCommandProcessor> processors = new ArrayList<>();
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService4 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    MeasurableService measurableService2 =
        new MeasurableService(
            measurableDao2, measurableSearchDao2, nameResolver2, changeLogService4);
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao2, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao3,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    TaxonomyChangeService taxonomyChangeService =
        new TaxonomyChangeService(
            taxonomyChangeDao,
            clientCacheKeyService,
            measurableCategoryService,
            userRoleService,
            processors,
            measurableService2,
            entityHierarchyService);

    // Act
    boolean actualRemoveByIdResult = taxonomyChangeService.removeById(1L, "42");

    // Assert
    verify(taxonomyChangeDao).removeById(1L, "42");
    verify(userRoleService).hasRole(eq("42"), (String[]) Mockito.any());
    assertFalse(actualRemoveByIdResult);
  }

  /**
   * Test {@link TaxonomyChangeService#removeById(long, String)}.
   *
   * <ul>
   *   <li>Given {@link TaxonomyChangeDao} {@link TaxonomyChangeDao#removeById(long, String)} return
   *       {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyChangeService#removeById(long, String)}
   */
  @Test
  @DisplayName(
      "Test removeById(long, String); given TaxonomyChangeDao removeById(long, String) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TaxonomyChangeService.removeById(long, String)"})
  void testRemoveById_givenTaxonomyChangeDaoRemoveByIdReturnTrue_thenReturnTrue() {
    // Arrange
    TaxonomyChangeDao taxonomyChangeDao = mock(TaxonomyChangeDao.class);
    when(taxonomyChangeDao.removeById(anyLong(), Mockito.<String>any())).thenReturn(true);

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    ClientCacheKeyService clientCacheKeyService =
        new ClientCacheKeyService(mock(ClientCacheKeyDao.class));
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService2 =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService2,
            changeLogService2,
            measurableService,
            settingsService2);
    ArrayList<TaxonomyCommandProcessor> processors = new ArrayList<>();
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService4 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    MeasurableService measurableService2 =
        new MeasurableService(
            measurableDao2, measurableSearchDao2, nameResolver2, changeLogService4);
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao2, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao3,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    TaxonomyChangeService taxonomyChangeService =
        new TaxonomyChangeService(
            taxonomyChangeDao,
            clientCacheKeyService,
            measurableCategoryService,
            userRoleService,
            processors,
            measurableService2,
            entityHierarchyService);

    // Act
    boolean actualRemoveByIdResult = taxonomyChangeService.removeById(1L, "42");

    // Assert
    verify(taxonomyChangeDao).removeById(1L, "42");
    verify(userRoleService).hasRole(eq("42"), (String[]) Mockito.any());
    assertTrue(actualRemoveByIdResult);
  }
}
