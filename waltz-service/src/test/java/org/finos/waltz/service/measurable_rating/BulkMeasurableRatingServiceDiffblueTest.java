package org.finos.waltz.service.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.allocation_scheme.AllocationSchemeDao;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable.MeasurableDao;
import org.finos.waltz.data.measurable.search.MeasurableSearchDao;
import org.finos.waltz.data.measurable_category.MeasurableCategoryDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.person.search.PersonSearchDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.rating_scheme.RatingSchemeDAO;
import org.finos.waltz.data.role.RoleDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.allocation_scheme.AllocationScheme;
import org.finos.waltz.model.allocation_scheme.ImmutableAllocationScheme;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.bulk_upload.BulkUpdateMode;
import org.finos.waltz.model.bulk_upload.measurable_rating.BulkMeasurableRatingParseResult;
import org.finos.waltz.model.bulk_upload.measurable_rating.BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError;
import org.finos.waltz.model.bulk_upload.measurable_rating.BulkMeasurableRatingValidationResult;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingParseError;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingValidationResult;
import org.finos.waltz.model.exceptions.NotAuthorizedException;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.measurable.ImmutableMeasurable;
import org.finos.waltz.model.measurable.Measurable;
import org.finos.waltz.model.measurable_category.ImmutableMeasurableCategory;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRating;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRating.Builder;
import org.finos.waltz.model.measurable_rating.MeasurableRating;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RagRating;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.measurable.MeasurableService;
import org.finos.waltz.service.measurable_category.MeasurableCategoryService;
import org.finos.waltz.service.measurable_rating.BulkMeasurableItemParser.InputFormat;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectSelectStep;
import org.jooq.TableLike;
import org.jooq.exception.DataAccessException;
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
class BulkMeasurableRatingServiceDiffblueTest {
  @Mock private AllocationSchemeDao allocationSchemeDao;

  @Mock private ApplicationDao applicationDao;

  @InjectMocks private BulkMeasurableRatingService bulkMeasurableRatingService;

  @Mock private DSLContext dSLContext;

  @Mock private MeasurableCategoryService measurableCategoryService;

  @Mock private MeasurableRatingDao measurableRatingDao;

  @Mock private MeasurableService measurableService;

  @Mock private RatingSchemeService ratingSchemeService;

  @Mock private UserRoleService userRoleService;

  /**
   * Test {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, InputFormat,
   * BulkUpdateMode)}.
   *
   * <p>Method under test: {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String,
   * InputFormat, BulkUpdateMode)}
   */
  @Test
  @DisplayName("Test bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkMeasurableRatingValidationResult BulkMeasurableRatingService.bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)"
  })
  void testBulkPreview() {
    // Arrange
    RatingSchemeService ratingSchemeService = mock(RatingSchemeService.class);
    when(ratingSchemeService.findRatingSchemeItemsBySchemeIds(Mockito.<Set<Long>>any()))
        .thenThrow(new IllegalStateException());

    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
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

    MeasurableService measurableService2 =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService2,
            measurableService2,
            settingsService2);

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());

    AllocationSchemeDao allocationSchemeDao = mock(AllocationSchemeDao.class);
    when(allocationSchemeDao.findAll()).thenReturn(new ArrayList<>());
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
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
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
    DefaultDSLContext dsl = new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99);

    BulkMeasurableRatingService bulkMeasurableRatingService =
        new BulkMeasurableRatingService(
            userRoleService2,
            measurableRatingDao,
            ratingSchemeService,
            measurableService,
            changeLogService5,
            measurableCategoryService,
            applicationDao,
            allocationSchemeDao,
            dsl);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkMeasurableRatingService.bulkPreview(
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
    verify(allocationSchemeDao).findAll();
    verify(applicationDao).findAll();
    verify(measurableCategoryDao).getById(1L);
    verify(measurableService).findByCategoryId(1L);
    verify(ratingSchemeService).findRatingSchemeItemsBySchemeIds(isA(Set.class));
  }

  /**
   * Test {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, InputFormat,
   * BulkUpdateMode)}.
   *
   * <p>Method under test: {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String,
   * InputFormat, BulkUpdateMode)}
   */
  @Test
  @DisplayName("Test bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkMeasurableRatingValidationResult BulkMeasurableRatingService.bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)"
  })
  void testBulkPreview2() {
    // Arrange
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
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    RatingSchemeService ratingSchemeService = mock(RatingSchemeService.class);
    MeasurableService measurableService = mock(MeasurableService.class);
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
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AllocationSchemeDao allocationSchemeDao = mock(AllocationSchemeDao.class);
    DefaultDSLContext dsl = new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99);

    BulkMeasurableRatingService bulkMeasurableRatingService =
        new BulkMeasurableRatingService(
            userRoleService,
            measurableRatingDao,
            ratingSchemeService,
            measurableService,
            changeLogService2,
            measurableCategoryService,
            applicationDao,
            allocationSchemeDao,
            dsl);

    // Act
    BulkMeasurableRatingValidationResult actualBulkPreviewResult =
        bulkMeasurableRatingService.bulkPreview(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "(\n|\r|\r\n)",
            InputFormat.CSV,
            BulkUpdateMode.ADD_ONLY);

    // Assert
    BulkMeasurableRatingParseError errorResult = actualBulkPreviewResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkMeasurableRatingValidationResult);
    assertEquals(
        "Cannot construct instance of `org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasu"
            + "rableRatingItem`, problem: Cannot build BulkMeasurableRatingItem, some of required attributes are not"
            + " set [assetCode, taxonomyExternalId, ratingCode, scheme]\n"
            + " at [Source: (StringReader); line: 2, column: 1]",
        errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertEquals(0, actualBulkPreviewResult.removalCount());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
    assertTrue(actualBulkPreviewResult.removals().isEmpty());
  }

  /**
   * Test {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, InputFormat,
   * BulkUpdateMode)}.
   *
   * <p>Method under test: {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String,
   * InputFormat, BulkUpdateMode)}
   */
  @Test
  @DisplayName("Test bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkMeasurableRatingValidationResult BulkMeasurableRatingService.bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)"
  })
  void testBulkPreview3() {
    // Arrange
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
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    RatingSchemeService ratingSchemeService = mock(RatingSchemeService.class);
    MeasurableService measurableService = mock(MeasurableService.class);
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
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AllocationSchemeDao allocationSchemeDao = mock(AllocationSchemeDao.class);
    DefaultDSLContext dsl = new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99);

    BulkMeasurableRatingService bulkMeasurableRatingService =
        new BulkMeasurableRatingService(
            userRoleService,
            measurableRatingDao,
            ratingSchemeService,
            measurableService,
            changeLogService2,
            measurableCategoryService,
            applicationDao,
            allocationSchemeDao,
            dsl);

    // Act
    BulkMeasurableRatingValidationResult actualBulkPreviewResult =
        bulkMeasurableRatingService.bulkPreview(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "#",
            InputFormat.CSV,
            BulkUpdateMode.ADD_ONLY);

    // Assert
    BulkMeasurableRatingParseError errorResult = actualBulkPreviewResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkMeasurableRatingValidationResult);
    assertEquals(
        "Empty header line: can not bind data\n at [Source: (StringReader); line: UNKNOWN, column: UNKNOWN]",
        errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertEquals(0, actualBulkPreviewResult.removalCount());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
    assertTrue(actualBulkPreviewResult.removals().isEmpty());
  }

  /**
   * Test {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, InputFormat,
   * BulkUpdateMode)}.
   *
   * <p>Method under test: {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String,
   * InputFormat, BulkUpdateMode)}
   */
  @Test
  @DisplayName("Test bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkMeasurableRatingValidationResult BulkMeasurableRatingService.bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)"
  })
  void testBulkPreview4() throws DataAccessException {
    // Arrange
    ArrayList<MeasurableRating> measurableRatingList = new ArrayList<>();

    Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    measurableRatingList.add(
        descriptionResult
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build());
    when(measurableRatingDao.findByCategory(anyLong())).thenReturn(measurableRatingList);
    when(ratingSchemeService.findRatingSchemeItemsBySchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    when(allocationSchemeDao.findAll()).thenReturn(new ArrayList<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchGroups(
            Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any()))
        .thenReturn(new HashMap<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record2<Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    BulkMeasurableRatingValidationResult actualBulkPreviewResult =
        bulkMeasurableRatingService.bulkPreview(
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
            BulkUpdateMode.ADD_ONLY);

    // Assert
    verify(allocationSchemeDao).findAll();
    verify(applicationDao).findAll();
    verify(measurableRatingDao).findByCategory(1L);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableCategoryService).getById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsBySchemeIds(isA(Set.class));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetchGroups(isA(Field.class), isA(Field.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkMeasurableRatingValidationResult);
    assertNull(actualBulkPreviewResult.error());
    assertEquals(0, actualBulkPreviewResult.removalCount());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
    assertTrue(actualBulkPreviewResult.removals().isEmpty());
  }

  /**
   * Test {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, InputFormat,
   * BulkUpdateMode)}.
   *
   * <p>Method under test: {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String,
   * InputFormat, BulkUpdateMode)}
   */
  @Test
  @DisplayName("Test bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkMeasurableRatingValidationResult BulkMeasurableRatingService.bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)"
  })
  void testBulkPreview5() throws DataAccessException {
    // Arrange
    ArrayList<MeasurableRating> measurableRatingList = new ArrayList<>();

    Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    measurableRatingList.add(
        descriptionResult
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build());

    Builder descriptionResult2 =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    measurableRatingList.add(
        descriptionResult2
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build());
    when(measurableRatingDao.findByCategory(anyLong())).thenReturn(measurableRatingList);
    when(ratingSchemeService.findRatingSchemeItemsBySchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    when(allocationSchemeDao.findAll()).thenReturn(new ArrayList<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchGroups(
            Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any()))
        .thenReturn(new HashMap<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record2<Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    BulkMeasurableRatingValidationResult actualBulkPreviewResult =
        bulkMeasurableRatingService.bulkPreview(
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
            BulkUpdateMode.ADD_ONLY);

    // Assert
    verify(allocationSchemeDao).findAll();
    verify(applicationDao).findAll();
    verify(measurableRatingDao).findByCategory(1L);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableCategoryService).getById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsBySchemeIds(isA(Set.class));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetchGroups(isA(Field.class), isA(Field.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkMeasurableRatingValidationResult);
    assertNull(actualBulkPreviewResult.error());
    assertEquals(0, actualBulkPreviewResult.removalCount());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
    assertTrue(actualBulkPreviewResult.removals().isEmpty());
  }

  /**
   * Test {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, InputFormat,
   * BulkUpdateMode)}.
   *
   * <p>Method under test: {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String,
   * InputFormat, BulkUpdateMode)}
   */
  @Test
  @DisplayName("Test bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkMeasurableRatingValidationResult BulkMeasurableRatingService.bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)"
  })
  void testBulkPreview6() throws DataAccessException {
    // Arrange
    when(measurableRatingDao.findByCategory(anyLong())).thenReturn(new ArrayList<>());

    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
    when(ratingSchemeService.findRatingSchemeItemsBySchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(ratingSchemeItemSet);
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    when(allocationSchemeDao.findAll()).thenReturn(new ArrayList<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchGroups(
            Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any()))
        .thenReturn(new HashMap<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record2<Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    BulkMeasurableRatingValidationResult actualBulkPreviewResult =
        bulkMeasurableRatingService.bulkPreview(
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
            BulkUpdateMode.ADD_ONLY);

    // Assert
    verify(allocationSchemeDao).findAll();
    verify(applicationDao).findAll();
    verify(measurableRatingDao).findByCategory(1L);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableCategoryService).getById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsBySchemeIds(isA(Set.class));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetchGroups(isA(Field.class), isA(Field.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkMeasurableRatingValidationResult);
    assertNull(actualBulkPreviewResult.error());
    assertEquals(0, actualBulkPreviewResult.removalCount());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
    assertTrue(actualBulkPreviewResult.removals().isEmpty());
  }

  /**
   * Test {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, InputFormat,
   * BulkUpdateMode)}.
   *
   * <p>Method under test: {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String,
   * InputFormat, BulkUpdateMode)}
   */
  @Test
  @DisplayName("Test bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkMeasurableRatingValidationResult BulkMeasurableRatingService.bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)"
  })
  void testBulkPreview7() throws DataAccessException {
    // Arrange
    when(measurableRatingDao.findByCategory(anyLong())).thenReturn(new ArrayList<>());
    when(ratingSchemeService.findRatingSchemeItemsBySchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<Measurable> measurableList = new ArrayList<>();
    measurableList.add(
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(measurableList);
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    when(allocationSchemeDao.findAll()).thenReturn(new ArrayList<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchGroups(
            Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any()))
        .thenReturn(new HashMap<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record2<Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    BulkMeasurableRatingValidationResult actualBulkPreviewResult =
        bulkMeasurableRatingService.bulkPreview(
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
            BulkUpdateMode.ADD_ONLY);

    // Assert
    verify(allocationSchemeDao).findAll();
    verify(applicationDao).findAll();
    verify(measurableRatingDao).findByCategory(1L);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableCategoryService).getById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsBySchemeIds(isA(Set.class));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetchGroups(isA(Field.class), isA(Field.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkMeasurableRatingValidationResult);
    assertNull(actualBulkPreviewResult.error());
    assertEquals(0, actualBulkPreviewResult.removalCount());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
    assertTrue(actualBulkPreviewResult.removals().isEmpty());
  }

  /**
   * Test {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, InputFormat,
   * BulkUpdateMode)}.
   *
   * <p>Method under test: {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String,
   * InputFormat, BulkUpdateMode)}
   */
  @Test
  @DisplayName("Test bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkMeasurableRatingValidationResult BulkMeasurableRatingService.bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)"
  })
  void testBulkPreview8() throws DataAccessException {
    // Arrange
    when(measurableRatingDao.findByCategory(anyLong())).thenReturn(new ArrayList<>());
    when(ratingSchemeService.findRatingSchemeItemsBySchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<Measurable> measurableList = new ArrayList<>();
    measurableList.add(
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());
    measurableList.add(
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(measurableList);
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    when(allocationSchemeDao.findAll()).thenReturn(new ArrayList<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchGroups(
            Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any()))
        .thenReturn(new HashMap<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record2<Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    BulkMeasurableRatingValidationResult actualBulkPreviewResult =
        bulkMeasurableRatingService.bulkPreview(
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
            BulkUpdateMode.ADD_ONLY);

    // Assert
    verify(allocationSchemeDao).findAll();
    verify(applicationDao).findAll();
    verify(measurableRatingDao).findByCategory(1L);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableCategoryService).getById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsBySchemeIds(isA(Set.class));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetchGroups(isA(Field.class), isA(Field.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkMeasurableRatingValidationResult);
    assertNull(actualBulkPreviewResult.error());
    assertEquals(0, actualBulkPreviewResult.removalCount());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
    assertTrue(actualBulkPreviewResult.removals().isEmpty());
  }

  /**
   * Test {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, InputFormat,
   * BulkUpdateMode)}.
   *
   * <p>Method under test: {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String,
   * InputFormat, BulkUpdateMode)}
   */
  @Test
  @DisplayName("Test bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkMeasurableRatingValidationResult BulkMeasurableRatingService.bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)"
  })
  void testBulkPreview9() throws DataAccessException {
    // Arrange
    when(measurableRatingDao.findByCategory(anyLong())).thenReturn(new ArrayList<>());
    when(ratingSchemeService.findRatingSchemeItemsBySchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    ArrayList<Application> applicationList = new ArrayList<>();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    when(applicationDao.findAll()).thenReturn(applicationList);
    when(allocationSchemeDao.findAll()).thenReturn(new ArrayList<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchGroups(
            Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any()))
        .thenReturn(new HashMap<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record2<Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    BulkMeasurableRatingValidationResult actualBulkPreviewResult =
        bulkMeasurableRatingService.bulkPreview(
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
            BulkUpdateMode.ADD_ONLY);

    // Assert
    verify(allocationSchemeDao).findAll();
    verify(applicationDao).findAll();
    verify(measurableRatingDao).findByCategory(1L);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableCategoryService).getById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsBySchemeIds(isA(Set.class));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetchGroups(isA(Field.class), isA(Field.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkMeasurableRatingValidationResult);
    assertNull(actualBulkPreviewResult.error());
    assertEquals(0, actualBulkPreviewResult.removalCount());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
    assertTrue(actualBulkPreviewResult.removals().isEmpty());
  }

  /**
   * Test {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, InputFormat,
   * BulkUpdateMode)}.
   *
   * <p>Method under test: {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String,
   * InputFormat, BulkUpdateMode)}
   */
  @Test
  @DisplayName("Test bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkMeasurableRatingValidationResult BulkMeasurableRatingService.bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)"
  })
  void testBulkPreview10() throws DataAccessException {
    // Arrange
    when(measurableRatingDao.findByCategory(anyLong())).thenReturn(new ArrayList<>());
    when(ratingSchemeService.findRatingSchemeItemsBySchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());

    ArrayList<AllocationScheme> allocationSchemeList = new ArrayList<>();
    allocationSchemeList.add(
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build());
    when(allocationSchemeDao.findAll()).thenReturn(allocationSchemeList);

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchGroups(
            Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any()))
        .thenReturn(new HashMap<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record2<Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    BulkMeasurableRatingValidationResult actualBulkPreviewResult =
        bulkMeasurableRatingService.bulkPreview(
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
            BulkUpdateMode.ADD_ONLY);

    // Assert
    verify(allocationSchemeDao).findAll();
    verify(applicationDao).findAll();
    verify(measurableRatingDao).findByCategory(1L);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableCategoryService).getById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsBySchemeIds(isA(Set.class));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetchGroups(isA(Field.class), isA(Field.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkMeasurableRatingValidationResult);
    assertNull(actualBulkPreviewResult.error());
    assertEquals(0, actualBulkPreviewResult.removalCount());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
    assertTrue(actualBulkPreviewResult.removals().isEmpty());
  }

  /**
   * Test {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, InputFormat,
   * BulkUpdateMode)}.
   *
   * <ul>
   *   <li>Given {@link AllocationSchemeDao} {@link AllocationSchemeDao#findAll()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String,
   * InputFormat, BulkUpdateMode)}
   */
  @Test
  @DisplayName(
      "Test bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode); given AllocationSchemeDao findAll() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkMeasurableRatingValidationResult BulkMeasurableRatingService.bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)"
  })
  void testBulkPreview_givenAllocationSchemeDaoFindAllThrowIllegalStateException() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
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

    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
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

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());

    AllocationSchemeDao allocationSchemeDao = mock(AllocationSchemeDao.class);
    when(allocationSchemeDao.findAll()).thenThrow(new IllegalStateException());
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
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
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

    BulkMeasurableRatingService bulkMeasurableRatingService =
        new BulkMeasurableRatingService(
            userRoleService2,
            measurableRatingDao,
            ratingSchemeService,
            measurableService,
            changeLogService6,
            measurableCategoryService,
            applicationDao,
            allocationSchemeDao,
            new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkMeasurableRatingService.bulkPreview(
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
    verify(allocationSchemeDao).findAll();
    verify(applicationDao).findAll();
    verify(measurableDao).findByCategoryId(1L);
    verify(measurableCategoryDao).getById(1L);
  }

  /**
   * Test {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, InputFormat,
   * BulkUpdateMode)}.
   *
   * <ul>
   *   <li>Given {@link ApplicationDao} {@link ApplicationDao#findAll()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String,
   * InputFormat, BulkUpdateMode)}
   */
  @Test
  @DisplayName(
      "Test bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode); given ApplicationDao findAll() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkMeasurableRatingValidationResult BulkMeasurableRatingService.bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)"
  })
  void testBulkPreview_givenApplicationDaoFindAllThrowIllegalStateException() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
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

    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
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

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findAll()).thenThrow(new IllegalStateException());
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
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
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
    AllocationSchemeDao allocationSchemeDao = mock(AllocationSchemeDao.class);

    BulkMeasurableRatingService bulkMeasurableRatingService =
        new BulkMeasurableRatingService(
            userRoleService2,
            measurableRatingDao,
            ratingSchemeService,
            measurableService,
            changeLogService6,
            measurableCategoryService,
            applicationDao,
            allocationSchemeDao,
            new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkMeasurableRatingService.bulkPreview(
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
    verify(applicationDao).findAll();
    verify(measurableDao).findByCategoryId(1L);
    verify(measurableCategoryDao).getById(1L);
  }

  /**
   * Test {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, InputFormat,
   * BulkUpdateMode)}.
   *
   * <ul>
   *   <li>Given {@link MeasurableCategoryService} {@link MeasurableCategoryService#getById(long)}
   *       throw {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String,
   * InputFormat, BulkUpdateMode)}
   */
  @Test
  @DisplayName(
      "Test bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode); given MeasurableCategoryService getById(long) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkMeasurableRatingValidationResult BulkMeasurableRatingService.bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)"
  })
  void testBulkPreview_givenMeasurableCategoryServiceGetByIdThrowIllegalStateException() {
    // Arrange
    when(measurableCategoryService.getById(anyLong())).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkMeasurableRatingService.bulkPreview(
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
    verify(measurableCategoryService).getById(1L);
  }

  /**
   * Test {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, InputFormat,
   * BulkUpdateMode)}.
   *
   * <ul>
   *   <li>Given {@link MeasurableService} {@link MeasurableService#findByCategoryId(Long)} throw
   *       {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String,
   * InputFormat, BulkUpdateMode)}
   */
  @Test
  @DisplayName(
      "Test bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode); given MeasurableService findByCategoryId(Long) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkMeasurableRatingValidationResult BulkMeasurableRatingService.bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)"
  })
  void testBulkPreview_givenMeasurableServiceFindByCategoryIdThrowIllegalStateException() {
    // Arrange
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.findByCategoryId(Mockito.<Long>any()))
        .thenThrow(new IllegalStateException());

    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
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
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    RatingSchemeService ratingSchemeService = mock(RatingSchemeService.class);
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
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AllocationSchemeDao allocationSchemeDao = mock(AllocationSchemeDao.class);
    DefaultDSLContext dsl = new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99);

    BulkMeasurableRatingService bulkMeasurableRatingService =
        new BulkMeasurableRatingService(
            userRoleService,
            measurableRatingDao,
            ratingSchemeService,
            measurableService,
            changeLogService2,
            measurableCategoryService,
            applicationDao,
            allocationSchemeDao,
            dsl);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkMeasurableRatingService.bulkPreview(
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
    verify(measurableService).findByCategoryId(1L);
    verify(measurableCategoryService).getById(1L);
  }

  /**
   * Test {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, InputFormat,
   * BulkUpdateMode)}.
   *
   * <ul>
   *   <li>Then return error is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String,
   * InputFormat, BulkUpdateMode)}
   */
  @Test
  @DisplayName(
      "Test bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode); then return error is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkMeasurableRatingValidationResult BulkMeasurableRatingService.bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)"
  })
  void testBulkPreview_thenReturnErrorIsNull() throws DataAccessException {
    // Arrange
    when(measurableRatingDao.findByCategory(anyLong())).thenReturn(new ArrayList<>());
    when(ratingSchemeService.findRatingSchemeItemsBySchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    when(allocationSchemeDao.findAll()).thenReturn(new ArrayList<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchGroups(
            Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any()))
        .thenReturn(new HashMap<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record2<Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    BulkMeasurableRatingValidationResult actualBulkPreviewResult =
        bulkMeasurableRatingService.bulkPreview(
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
            BulkUpdateMode.ADD_ONLY);

    // Assert
    verify(allocationSchemeDao).findAll();
    verify(applicationDao).findAll();
    verify(measurableRatingDao).findByCategory(1L);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableCategoryService).getById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsBySchemeIds(isA(Set.class));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetchGroups(isA(Field.class), isA(Field.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkMeasurableRatingValidationResult);
    assertNull(actualBulkPreviewResult.error());
    assertEquals(0, actualBulkPreviewResult.removalCount());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
    assertTrue(actualBulkPreviewResult.removals().isEmpty());
  }

  /**
   * Test {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, InputFormat,
   * BulkUpdateMode)}.
   *
   * <ul>
   *   <li>When {@code JSON}.
   *   <li>Then return error message is a string.
   * </ul>
   *
   * <p>Method under test: {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String,
   * InputFormat, BulkUpdateMode)}
   */
  @Test
  @DisplayName(
      "Test bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode); when 'JSON'; then return error message is a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkMeasurableRatingValidationResult BulkMeasurableRatingService.bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)"
  })
  void testBulkPreview_whenJson_thenReturnErrorMessageIsAString() {
    // Arrange
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
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    RatingSchemeService ratingSchemeService = mock(RatingSchemeService.class);
    MeasurableService measurableService = mock(MeasurableService.class);
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
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AllocationSchemeDao allocationSchemeDao = mock(AllocationSchemeDao.class);
    DefaultDSLContext dsl = new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99);

    BulkMeasurableRatingService bulkMeasurableRatingService =
        new BulkMeasurableRatingService(
            userRoleService,
            measurableRatingDao,
            ratingSchemeService,
            measurableService,
            changeLogService2,
            measurableCategoryService,
            applicationDao,
            allocationSchemeDao,
            dsl);

    // Act
    BulkMeasurableRatingValidationResult actualBulkPreviewResult =
        bulkMeasurableRatingService.bulkPreview(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "Input Str",
            InputFormat.JSON,
            BulkUpdateMode.ADD_ONLY);

    // Assert
    BulkMeasurableRatingParseError errorResult = actualBulkPreviewResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkMeasurableRatingValidationResult);
    assertEquals(
        "Unrecognized token 'Input': was expecting (JSON String, Number, Array, Object or token 'null', 'true'"
            + " or 'false')\n"
            + " at [Source: (String)\"Input Str\"; line: 1, column: 6]",
        errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertEquals(0, actualBulkPreviewResult.removalCount());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
    assertTrue(actualBulkPreviewResult.removals().isEmpty());
  }

  /**
   * Test {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, InputFormat,
   * BulkUpdateMode)}.
   *
   * <ul>
   *   <li>When lf.
   *   <li>Then return error message is {@code Cannot parse an empty string}.
   * </ul>
   *
   * <p>Method under test: {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String,
   * InputFormat, BulkUpdateMode)}
   */
  @Test
  @DisplayName(
      "Test bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode); when lf; then return error message is 'Cannot parse an empty string'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkMeasurableRatingValidationResult BulkMeasurableRatingService.bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)"
  })
  void testBulkPreview_whenLf_thenReturnErrorMessageIsCannotParseAnEmptyString() {
    // Arrange
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
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    RatingSchemeService ratingSchemeService = mock(RatingSchemeService.class);
    MeasurableService measurableService = mock(MeasurableService.class);
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
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AllocationSchemeDao allocationSchemeDao = mock(AllocationSchemeDao.class);
    DefaultDSLContext dsl = new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99);

    BulkMeasurableRatingService bulkMeasurableRatingService =
        new BulkMeasurableRatingService(
            userRoleService,
            measurableRatingDao,
            ratingSchemeService,
            measurableService,
            changeLogService2,
            measurableCategoryService,
            applicationDao,
            allocationSchemeDao,
            dsl);

    // Act
    BulkMeasurableRatingValidationResult actualBulkPreviewResult =
        bulkMeasurableRatingService.bulkPreview(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "\n",
            InputFormat.CSV,
            BulkUpdateMode.ADD_ONLY);

    // Assert
    BulkMeasurableRatingParseError errorResult = actualBulkPreviewResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkMeasurableRatingValidationResult);
    assertEquals("Cannot parse an empty string", errorResult.message());
    assertEquals(0, errorResult.column().intValue());
    assertEquals(0, errorResult.line().intValue());
    assertEquals(0, actualBulkPreviewResult.removalCount());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
    assertTrue(actualBulkPreviewResult.removals().isEmpty());
  }

  /**
   * Test {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, InputFormat,
   * BulkUpdateMode)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return error message is {@code Cannot parse an empty string}.
   * </ul>
   *
   * <p>Method under test: {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String,
   * InputFormat, BulkUpdateMode)}
   */
  @Test
  @DisplayName(
      "Test bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode); when 'null'; then return error message is 'Cannot parse an empty string'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkMeasurableRatingValidationResult BulkMeasurableRatingService.bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)"
  })
  void testBulkPreview_whenNull_thenReturnErrorMessageIsCannotParseAnEmptyString() {
    // Arrange
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
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    RatingSchemeService ratingSchemeService = mock(RatingSchemeService.class);
    MeasurableService measurableService = mock(MeasurableService.class);
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
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AllocationSchemeDao allocationSchemeDao = mock(AllocationSchemeDao.class);
    DefaultDSLContext dsl = new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99);

    BulkMeasurableRatingService bulkMeasurableRatingService =
        new BulkMeasurableRatingService(
            userRoleService,
            measurableRatingDao,
            ratingSchemeService,
            measurableService,
            changeLogService2,
            measurableCategoryService,
            applicationDao,
            allocationSchemeDao,
            dsl);

    // Act
    BulkMeasurableRatingValidationResult actualBulkPreviewResult =
        bulkMeasurableRatingService.bulkPreview(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            null,
            InputFormat.CSV,
            BulkUpdateMode.ADD_ONLY);

    // Assert
    BulkMeasurableRatingParseError errorResult = actualBulkPreviewResult.error();
    assertTrue(errorResult instanceof ImmutableBulkMeasurableRatingParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkMeasurableRatingValidationResult);
    assertEquals("Cannot parse an empty string", errorResult.message());
    assertEquals(0, errorResult.column().intValue());
    assertEquals(0, errorResult.line().intValue());
    assertEquals(0, actualBulkPreviewResult.removalCount());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
    assertTrue(actualBulkPreviewResult.removals().isEmpty());
  }

  /**
   * Test {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, InputFormat,
   * BulkUpdateMode)}.
   *
   * <ul>
   *   <li>When {@code REPLACE}.
   *   <li>Then return error is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String,
   * InputFormat, BulkUpdateMode)}
   */
  @Test
  @DisplayName(
      "Test bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode); when 'REPLACE'; then return error is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkMeasurableRatingValidationResult BulkMeasurableRatingService.bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)"
  })
  void testBulkPreview_whenReplace_thenReturnErrorIsNull() throws DataAccessException {
    // Arrange
    when(measurableRatingDao.findByCategory(anyLong())).thenReturn(new ArrayList<>());
    when(ratingSchemeService.findRatingSchemeItemsBySchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    when(allocationSchemeDao.findAll()).thenReturn(new ArrayList<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchGroups(
            Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any()))
        .thenReturn(new HashMap<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record2<Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    BulkMeasurableRatingValidationResult actualBulkPreviewResult =
        bulkMeasurableRatingService.bulkPreview(
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
            BulkUpdateMode.REPLACE);

    // Assert
    verify(allocationSchemeDao).findAll();
    verify(applicationDao).findAll();
    verify(measurableRatingDao).findByCategory(1L);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableCategoryService).getById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsBySchemeIds(isA(Set.class));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetchGroups(isA(Field.class), isA(Field.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkMeasurableRatingValidationResult);
    assertNull(actualBulkPreviewResult.error());
    assertEquals(0, actualBulkPreviewResult.removalCount());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
    assertTrue(actualBulkPreviewResult.removals().isEmpty());
  }

  /**
   * Test {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String, InputFormat,
   * BulkUpdateMode)}.
   *
   * <ul>
   *   <li>When {@code TSV}.
   * </ul>
   *
   * <p>Method under test: {@link BulkMeasurableRatingService#bulkPreview(EntityReference, String,
   * InputFormat, BulkUpdateMode)}
   */
  @Test
  @DisplayName("Test bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode); when 'TSV'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkMeasurableRatingValidationResult BulkMeasurableRatingService.bulkPreview(EntityReference, String, InputFormat, BulkUpdateMode)"
  })
  void testBulkPreview_whenTsv() {
    // Arrange
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.findByCategoryId(Mockito.<Long>any()))
        .thenThrow(new IllegalStateException());

    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
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
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    RatingSchemeService ratingSchemeService = mock(RatingSchemeService.class);
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
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AllocationSchemeDao allocationSchemeDao = mock(AllocationSchemeDao.class);
    DefaultDSLContext dsl = new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99);

    BulkMeasurableRatingService bulkMeasurableRatingService =
        new BulkMeasurableRatingService(
            userRoleService,
            measurableRatingDao,
            ratingSchemeService,
            measurableService,
            changeLogService2,
            measurableCategoryService,
            applicationDao,
            allocationSchemeDao,
            dsl);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkMeasurableRatingService.bulkPreview(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                "Input Str",
                InputFormat.TSV,
                BulkUpdateMode.ADD_ONLY));
    verify(measurableService).findByCategoryId(1L);
    verify(measurableCategoryService).getById(1L);
  }

  /**
   * Test {@link BulkMeasurableRatingService#apply(EntityReference,
   * BulkMeasurableRatingValidationResult, BulkUpdateMode, String)}.
   *
   * <p>Method under test: {@link BulkMeasurableRatingService#apply(EntityReference,
   * BulkMeasurableRatingValidationResult, BulkUpdateMode, String)}
   */
  @Test
  @DisplayName(
      "Test apply(EntityReference, BulkMeasurableRatingValidationResult, BulkUpdateMode, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.bulk_upload.measurable_rating.BulkMeasurableRatingApplyResult BulkMeasurableRatingService.apply(EntityReference, BulkMeasurableRatingValidationResult, BulkUpdateMode, String)"
  })
  void testApply() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
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
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService2 =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService3, personService, settingsService);
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
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService2,
            changeLogService4,
            measurableService2,
            settingsService2);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AllocationSchemeDao allocationSchemeDao = mock(AllocationSchemeDao.class);

    BulkMeasurableRatingService bulkMeasurableRatingService =
        new BulkMeasurableRatingService(
            userRoleService,
            measurableRatingDao,
            ratingSchemeService,
            measurableService,
            changeLogService2,
            measurableCategoryService,
            applicationDao,
            allocationSchemeDao,
            new DefaultDSLContext(SQLDialect.SQL99));

    BulkMeasurableRatingValidationResult preview = mock(BulkMeasurableRatingValidationResult.class);
    when(preview.error())
        .thenReturn(
            ImmutableBulkMeasurableRatingParseError.builder()
                .column(1)
                .line(2)
                .message("Not all who wander are lost")
                .build());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> bulkMeasurableRatingService.apply(null, preview, BulkUpdateMode.ADD_ONLY, "42"));
    verify(preview).error();
    verify(userRoleService).hasRole(eq("42"), (String[]) Mockito.any());
  }

  /**
   * Test {@link BulkMeasurableRatingService#apply(EntityReference,
   * BulkMeasurableRatingValidationResult, BulkUpdateMode, String)}.
   *
   * <p>Method under test: {@link BulkMeasurableRatingService#apply(EntityReference,
   * BulkMeasurableRatingValidationResult, BulkUpdateMode, String)}
   */
  @Test
  @DisplayName(
      "Test apply(EntityReference, BulkMeasurableRatingValidationResult, BulkUpdateMode, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.bulk_upload.measurable_rating.BulkMeasurableRatingApplyResult BulkMeasurableRatingService.apply(EntityReference, BulkMeasurableRatingValidationResult, BulkUpdateMode, String)"
  })
  void testApply2() {
    // Arrange
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    ImmutableEntityReference categoryRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    ImmutableBulkMeasurableRatingValidationResult.Builder builderResult =
        ImmutableBulkMeasurableRatingValidationResult.builder();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkMeasurableRatingService.apply(
                categoryRef,
                builderResult
                    .error(
                        ImmutableBulkMeasurableRatingParseError.builder()
                            .column(1)
                            .line(2)
                            .message("Not all who wander are lost")
                            .build())
                    .build(),
                BulkUpdateMode.ADD_ONLY,
                "42"));
    verify(userRoleService).hasRole(eq("42"), (String[]) Mockito.any());
  }

  /**
   * Test {@link BulkMeasurableRatingService#apply(EntityReference,
   * BulkMeasurableRatingValidationResult, BulkUpdateMode, String)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BulkMeasurableRatingService#apply(EntityReference,
   * BulkMeasurableRatingValidationResult, BulkUpdateMode, String)}
   */
  @Test
  @DisplayName(
      "Test apply(EntityReference, BulkMeasurableRatingValidationResult, BulkUpdateMode, String); given IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.bulk_upload.measurable_rating.BulkMeasurableRatingApplyResult BulkMeasurableRatingService.apply(EntityReference, BulkMeasurableRatingValidationResult, BulkUpdateMode, String)"
  })
  void testApply_givenIllegalStateException() {
    // Arrange
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);

    BulkMeasurableRatingValidationResult preview = mock(BulkMeasurableRatingValidationResult.class);
    when(preview.error()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> bulkMeasurableRatingService.apply(null, preview, BulkUpdateMode.ADD_ONLY, "42"));
    verify(preview).error();
    verify(userRoleService).hasRole(eq("42"), (String[]) Mockito.any());
  }

  /**
   * Test {@link BulkMeasurableRatingService#apply(EntityReference,
   * BulkMeasurableRatingValidationResult, BulkUpdateMode, String)}.
   *
   * <ul>
   *   <li>Then throw {@link NotAuthorizedException}.
   * </ul>
   *
   * <p>Method under test: {@link BulkMeasurableRatingService#apply(EntityReference,
   * BulkMeasurableRatingValidationResult, BulkUpdateMode, String)}
   */
  @Test
  @DisplayName(
      "Test apply(EntityReference, BulkMeasurableRatingValidationResult, BulkUpdateMode, String); then throw NotAuthorizedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.bulk_upload.measurable_rating.BulkMeasurableRatingApplyResult BulkMeasurableRatingService.apply(EntityReference, BulkMeasurableRatingValidationResult, BulkUpdateMode, String)"
  })
  void testApply_thenThrowNotAuthorizedException() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService2);
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
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
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
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    UserRoleService userRoleService2 =
        new UserRoleService(
            userRoleDao2,
            roleDao2,
            personDao2,
            changeLogService4,
            personService2,
            settingsService2);
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
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService2 =
        new MeasurableService(
            measurableDao2, measurableSearchDao2, nameResolver2, changeLogService6);
    SettingsDao settingsDao3 = mock(SettingsDao.class);
    SettingsService settingsService3 = new SettingsService(settingsDao3, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService2,
            changeLogService5,
            measurableService2,
            settingsService3);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AllocationSchemeDao allocationSchemeDao = mock(AllocationSchemeDao.class);

    BulkMeasurableRatingService bulkMeasurableRatingService =
        new BulkMeasurableRatingService(
            userRoleService,
            measurableRatingDao,
            ratingSchemeService,
            measurableService,
            changeLogService3,
            measurableCategoryService,
            applicationDao,
            allocationSchemeDao,
            new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class,
        () ->
            bulkMeasurableRatingService.apply(
                null,
                mock(BulkMeasurableRatingValidationResult.class),
                BulkUpdateMode.ADD_ONLY,
                "42"));
    verify(userRoleDao).getUserRoles("42");
  }
}
