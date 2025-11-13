package org.finos.waltz.service.taxonomy_management;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.change_initiative.ChangeInitiativeDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
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
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.bulk_upload.BulkUpdateMode;
import org.finos.waltz.model.bulk_upload.ChangeOperation;
import org.finos.waltz.model.bulk_upload.taxonomy.BulkTaxonomyValidatedItem;
import org.finos.waltz.model.bulk_upload.taxonomy.BulkTaxonomyValidationResult;
import org.finos.waltz.model.bulk_upload.taxonomy.ChangedFieldType;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyItem;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyParseError;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyValidatedItem;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyValidatedItem.Builder;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyValidationResult;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.entity_hierarchy.EntityHierarchyService;
import org.finos.waltz.service.measurable.MeasurableService;
import org.finos.waltz.service.measurable_category.MeasurableCategoryService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.person_hierarchy.PersonHierarchyService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.taxonomy_management.BulkTaxonomyItemParser.InputFormat;
import org.finos.waltz.service.user.UserRoleService;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BulkTaxonomyChangeServiceDiffblueTest {
  @InjectMocks private BulkTaxonomyChangeService bulkTaxonomyChangeService;

  /**
   * Test {@link BulkTaxonomyChangeService#previewBulk(EntityReference, String, InputFormat,
   * BulkUpdateMode)}.
   *
   * <p>Method under test: {@link BulkTaxonomyChangeService#previewBulk(EntityReference, String,
   * InputFormat, BulkUpdateMode)}
   */
  @Test
  @DisplayName("Test previewBulk(EntityReference, String, InputFormat, BulkUpdateMode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkTaxonomyValidationResult BulkTaxonomyChangeService.previewBulk(EntityReference, String, InputFormat, BulkUpdateMode)"
  })
  void testPreviewBulk() {
    // Arrange
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

    BulkTaxonomyChangeService bulkTaxonomyChangeService =
        new BulkTaxonomyChangeService(
            measurableCategoryService,
            measurableService2,
            userRoleService2,
            entityHierarchyService,
            new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            bulkTaxonomyChangeService.previewBulk(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                "Input Str",
                InputFormat.CSV,
                BulkUpdateMode.ADD_ONLY));
  }

  /**
   * Test {@link BulkTaxonomyChangeService#previewBulk(EntityReference, String, InputFormat,
   * BulkUpdateMode)}.
   *
   * <p>Method under test: {@link BulkTaxonomyChangeService#previewBulk(EntityReference, String,
   * InputFormat, BulkUpdateMode)}
   */
  @Test
  @DisplayName("Test previewBulk(EntityReference, String, InputFormat, BulkUpdateMode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkTaxonomyValidationResult BulkTaxonomyChangeService.previewBulk(EntityReference, String, InputFormat, BulkUpdateMode)"
  })
  void testPreviewBulk2() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            bulkTaxonomyChangeService.previewBulk(
                ImmutableAppGroupEntry.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .provenance("Provenance")
                    .build(),
                "Input Str",
                InputFormat.CSV,
                BulkUpdateMode.ADD_ONLY));
  }

  /**
   * Test {@link BulkTaxonomyChangeService#applyBulk(EntityReference, BulkTaxonomyValidationResult,
   * String)}.
   *
   * <p>Method under test: {@link BulkTaxonomyChangeService#applyBulk(EntityReference,
   * BulkTaxonomyValidationResult, String)}
   */
  @Test
  @DisplayName("Test applyBulk(EntityReference, BulkTaxonomyValidationResult, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.bulk_upload.taxonomy.BulkTaxonomyApplyResult BulkTaxonomyChangeService.applyBulk(EntityReference, BulkTaxonomyValidationResult, String)"
  })
  void testApplyBulk() {
    // Arrange
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

    BulkTaxonomyChangeService bulkTaxonomyChangeService =
        new BulkTaxonomyChangeService(
            measurableCategoryService,
            measurableService2,
            userRoleService2,
            entityHierarchyService,
            new DefaultDSLContext(SQLDialect.SQL99));
    ImmutableEntityReference taxonomyRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    ImmutableBulkTaxonomyValidationResult.Builder builderResult =
        ImmutableBulkTaxonomyValidationResult.builder();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            bulkTaxonomyChangeService.applyBulk(
                taxonomyRef,
                builderResult
                    .error(
                        ImmutableBulkTaxonomyParseError.builder()
                            .column(1)
                            .line(2)
                            .message("Not all who wander are lost")
                            .build())
                    .build(),
                "42"));
  }

  /**
   * Test {@link BulkTaxonomyChangeService#applyBulk(EntityReference, BulkTaxonomyValidationResult,
   * String)}.
   *
   * <p>Method under test: {@link BulkTaxonomyChangeService#applyBulk(EntityReference,
   * BulkTaxonomyValidationResult, String)}
   */
  @Test
  @DisplayName("Test applyBulk(EntityReference, BulkTaxonomyValidationResult, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.bulk_upload.taxonomy.BulkTaxonomyApplyResult BulkTaxonomyChangeService.applyBulk(EntityReference, BulkTaxonomyValidationResult, String)"
  })
  void testApplyBulk2() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            bulkTaxonomyChangeService.applyBulk(
                ImmutableAppGroupEntry.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .provenance("Provenance")
                    .build(),
                mock(BulkTaxonomyValidationResult.class),
                "42"));
  }

  /**
   * Test {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}.
   *
   * <p>Method under test: {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}
   */
  @Test
  @DisplayName("Test requiresHierarchyRebuild(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkTaxonomyChangeService.requiresHierarchyRebuild(Collection)"})
  void testRequiresHierarchyRebuild() {
    // Arrange
    ArrayList<BulkTaxonomyValidatedItem> items = new ArrayList<>();

    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    items.add(
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build());

    // Act and Assert
    assertTrue(BulkTaxonomyChangeService.requiresHierarchyRebuild(items));
  }

  /**
   * Test {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}.
   *
   * <p>Method under test: {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}
   */
  @Test
  @DisplayName("Test requiresHierarchyRebuild(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkTaxonomyChangeService.requiresHierarchyRebuild(Collection)"})
  void testRequiresHierarchyRebuild2() {
    // Arrange
    ArrayList<BulkTaxonomyValidatedItem> items = new ArrayList<>();

    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    items.add(
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build());

    Builder changeOperationResult2 =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult2 =
        changeOperationResult2.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    items.add(
        existingItemReferenceResult2
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build());

    // Act and Assert
    assertTrue(BulkTaxonomyChangeService.requiresHierarchyRebuild(items));
  }

  /**
   * Test {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}.
   *
   * <p>Method under test: {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}
   */
  @Test
  @DisplayName("Test requiresHierarchyRebuild(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkTaxonomyChangeService.requiresHierarchyRebuild(Collection)"})
  void testRequiresHierarchyRebuild3() {
    // Arrange
    ArrayList<BulkTaxonomyValidatedItem> items = new ArrayList<>();

    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.UPDATE);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    items.add(
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build());

    Builder changeOperationResult2 =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    Builder existingItemReferenceResult2 =
        changeOperationResult2.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    items.add(
        existingItemReferenceResult2
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build());

    // Act and Assert
    assertTrue(BulkTaxonomyChangeService.requiresHierarchyRebuild(items));
  }

  /**
   * Test {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}.
   *
   * <p>Method under test: {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}
   */
  @Test
  @DisplayName("Test requiresHierarchyRebuild(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkTaxonomyChangeService.requiresHierarchyRebuild(Collection)"})
  void testRequiresHierarchyRebuild4() {
    // Arrange
    ArrayList<BulkTaxonomyValidatedItem> items = new ArrayList<>();

    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.NONE);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    items.add(
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build());

    // Act and Assert
    assertFalse(BulkTaxonomyChangeService.requiresHierarchyRebuild(items));
  }

  /**
   * Test {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}.
   *
   * <ul>
   *   <li>Given builder addChangedFields {@code PARENT_EXTERNAL_ID}.
   * </ul>
   *
   * <p>Method under test: {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}
   */
  @Test
  @DisplayName(
      "Test requiresHierarchyRebuild(Collection); given builder addChangedFields 'PARENT_EXTERNAL_ID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkTaxonomyChangeService.requiresHierarchyRebuild(Collection)"})
  void testRequiresHierarchyRebuild_givenBuilderAddChangedFieldsParentExternalId() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidatedItem.builder();
    builderResult.addChangedFields(ChangedFieldType.PARENT_EXTERNAL_ID);

    Builder changeOperationResult = builderResult.changeOperation(ChangeOperation.UPDATE);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkTaxonomyValidatedItem immutableBulkTaxonomyValidatedItem =
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build();

    ArrayList<BulkTaxonomyValidatedItem> items = new ArrayList<>();
    items.add(immutableBulkTaxonomyValidatedItem);

    // Act and Assert
    assertTrue(BulkTaxonomyChangeService.requiresHierarchyRebuild(items));
  }

  /**
   * Test {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}
   */
  @Test
  @DisplayName("Test requiresHierarchyRebuild(Collection); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkTaxonomyChangeService.requiresHierarchyRebuild(Collection)"})
  void testRequiresHierarchyRebuild_thenReturnFalse() {
    // Arrange
    ArrayList<BulkTaxonomyValidatedItem> items = new ArrayList<>();

    Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.UPDATE);

    Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    items.add(
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build());

    // Act and Assert
    assertFalse(BulkTaxonomyChangeService.requiresHierarchyRebuild(items));
  }

  /**
   * Test {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BulkTaxonomyChangeService#requiresHierarchyRebuild(Collection)}
   */
  @Test
  @DisplayName("Test requiresHierarchyRebuild(Collection); when ArrayList(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkTaxonomyChangeService.requiresHierarchyRebuild(Collection)"})
  void testRequiresHierarchyRebuild_whenArrayList_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BulkTaxonomyChangeService.requiresHierarchyRebuild(new ArrayList<>()));
  }
}
