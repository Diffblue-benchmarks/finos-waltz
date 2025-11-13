package org.finos.waltz.service.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.EntityAliasPopulator;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.assessment_definition.AssessmentDefinitionDao;
import org.finos.waltz.data.assessment_rating.AssessmentRatingDao;
import org.finos.waltz.data.assessment_rating.AssessmentRatingRippler;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.legal_entity.LegalEntityRelationshipDao;
import org.finos.waltz.data.legal_entity.LegalEntityRelationshipKindDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable.MeasurableDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.rating_scheme.RatingSchemeDAO;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.data.user.UserPreferenceDao;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition.Builder;
import org.finos.waltz.model.bulk_upload.BulkUpdateMode;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.AssessmentHeaderCell;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.BulkUploadLegalEntityRelationshipCommand;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableBulkUploadLegalEntityRelationshipCommand;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.UploadOperation;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelationshipKind;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.finos.waltz.service.assessment_definition.AssessmentDefinitionService;
import org.finos.waltz.service.assessment_rating.AssessmentRatingService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.legal_entity.LegalEntityRelationshipKindService;
import org.finos.waltz.service.legal_entity.LegalEntityRelationshipService;
import org.finos.waltz.service.permission.permission_checker.AssessmentRatingPermissionChecker;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
import org.jooq.DSLContext;
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
class BulkUploadLegalEntityRelationshipServiceDiffblueTest {
  @Mock private AssessmentDefinitionService assessmentDefinitionService;

  @Mock private AssessmentRatingService assessmentRatingService;

  @InjectMocks
  private BulkUploadLegalEntityRelationshipService bulkUploadLegalEntityRelationshipService;

  @Mock private DSLContext dSLContext;

  @Mock private EntityAliasPopulator entityAliasPopulator;

  @Mock private LegalEntityRelationshipKindService legalEntityRelationshipKindService;

  @Mock private LegalEntityRelationshipService legalEntityRelationshipService;

  @Mock private RatingSchemeService ratingSchemeService;

  /**
   * Test {@link
   * BulkUploadLegalEntityRelationshipService#save(BulkUploadLegalEntityRelationshipCommand,
   * String)}.
   *
   * <p>Method under test: {@link
   * BulkUploadLegalEntityRelationshipService#save(BulkUploadLegalEntityRelationshipCommand,
   * String)}
   */
  @Test
  @DisplayName("Test save(BulkUploadLegalEntityRelationshipCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.bulk_upload.legal_entity_relationship.SaveBulkUploadLegalEntityRelationshipResponse BulkUploadLegalEntityRelationshipService.save(BulkUploadLegalEntityRelationshipCommand, String)"
  })
  void testSave() {
    // Arrange
    LegalEntityRelationshipKindDao legalEntityRelationshipKindDao =
        mock(LegalEntityRelationshipKindDao.class);
    when(legalEntityRelationshipKindDao.getById(anyLong()))
        .thenReturn(
            ImmutableLegalEntityRelationshipKind.builder()
                .cardinality(Cardinality.ZERO_ONE)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .requiredRole("Required Role")
                .targetKind(EntityKind.ALL)
                .build());
    LegalEntityRelationshipKindService legalEntityRelationshipKindService =
        new LegalEntityRelationshipKindService(legalEntityRelationshipKindDao);
    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            mock(AssessmentDefinitionDao.class),
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            mock(UserPreferenceDao.class));
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityAliasPopulator entityAliasPopulator = mock(EntityAliasPopulator.class);
    LegalEntityRelationshipService legalEntityRelationshipService =
        new LegalEntityRelationshipService(mock(LegalEntityRelationshipDao.class));
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    BulkUploadLegalEntityRelationshipService bulkUploadLegalEntityRelationshipService =
        new BulkUploadLegalEntityRelationshipService(
            assessmentDefinitionService,
            ratingSchemeService,
            entityAliasPopulator,
            legalEntityRelationshipKindService,
            legalEntityRelationshipService,
            assessmentRatingService,
            new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkUploadLegalEntityRelationshipService.save(
                ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
                    .inputString("[,\\t|]")
                    .legalEntityRelationshipKindId(1L)
                    .updateMode(BulkUpdateMode.ADD_ONLY)
                    .build(),
                "janedoe"));
    verify(legalEntityRelationshipKindDao).getById(1L);
  }

  /**
   * Test {@link
   * BulkUploadLegalEntityRelationshipService#save(BulkUploadLegalEntityRelationshipCommand,
   * String)}.
   *
   * <p>Method under test: {@link
   * BulkUploadLegalEntityRelationshipService#save(BulkUploadLegalEntityRelationshipCommand,
   * String)}
   */
  @Test
  @DisplayName("Test save(BulkUploadLegalEntityRelationshipCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.bulk_upload.legal_entity_relationship.SaveBulkUploadLegalEntityRelationshipResponse BulkUploadLegalEntityRelationshipService.save(BulkUploadLegalEntityRelationshipCommand, String)"
  })
  void testSave2() {
    // Arrange
    when(legalEntityRelationshipKindService.getById(anyLong()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkUploadLegalEntityRelationshipService.save(
                ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
                    .inputString("Input String")
                    .legalEntityRelationshipKindId(1L)
                    .updateMode(BulkUpdateMode.ADD_ONLY)
                    .build(),
                "janedoe"));
    verify(legalEntityRelationshipKindService).getById(1L);
  }

  /**
   * Test {@link
   * BulkUploadLegalEntityRelationshipService#save(BulkUploadLegalEntityRelationshipCommand,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link LegalEntityRelationshipKindDao#getById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BulkUploadLegalEntityRelationshipService#save(BulkUploadLegalEntityRelationshipCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test save(BulkUploadLegalEntityRelationshipCommand, String); then calls getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.bulk_upload.legal_entity_relationship.SaveBulkUploadLegalEntityRelationshipResponse BulkUploadLegalEntityRelationshipService.save(BulkUploadLegalEntityRelationshipCommand, String)"
  })
  void testSave_thenCallsGetById() {
    // Arrange
    LegalEntityRelationshipKindDao legalEntityRelationshipKindDao =
        mock(LegalEntityRelationshipKindDao.class);
    when(legalEntityRelationshipKindDao.getById(anyLong()))
        .thenReturn(
            ImmutableLegalEntityRelationshipKind.builder()
                .cardinality(Cardinality.ZERO_ONE)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .requiredRole("Required Role")
                .targetKind(EntityKind.ALL)
                .build());
    LegalEntityRelationshipKindService legalEntityRelationshipKindService =
        new LegalEntityRelationshipKindService(legalEntityRelationshipKindDao);
    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            mock(AssessmentDefinitionDao.class),
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            mock(UserPreferenceDao.class));
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityAliasPopulator entityAliasPopulator = mock(EntityAliasPopulator.class);
    LegalEntityRelationshipService legalEntityRelationshipService =
        new LegalEntityRelationshipService(mock(LegalEntityRelationshipDao.class));
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    BulkUploadLegalEntityRelationshipService bulkUploadLegalEntityRelationshipService =
        new BulkUploadLegalEntityRelationshipService(
            assessmentDefinitionService,
            ratingSchemeService,
            entityAliasPopulator,
            legalEntityRelationshipKindService,
            legalEntityRelationshipService,
            assessmentRatingService,
            new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkUploadLegalEntityRelationshipService.save(
                ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
                    .inputString("Input String")
                    .legalEntityRelationshipKindId(1L)
                    .updateMode(BulkUpdateMode.ADD_ONLY)
                    .build(),
                "janedoe"));
    verify(legalEntityRelationshipKindDao).getById(1L);
  }

  /**
   * Test {@link
   * BulkUploadLegalEntityRelationshipService#save(BulkUploadLegalEntityRelationshipCommand,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link LegalEntityRelationshipKindService#getById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BulkUploadLegalEntityRelationshipService#save(BulkUploadLegalEntityRelationshipCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test save(BulkUploadLegalEntityRelationshipCommand, String); then calls getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.bulk_upload.legal_entity_relationship.SaveBulkUploadLegalEntityRelationshipResponse BulkUploadLegalEntityRelationshipService.save(BulkUploadLegalEntityRelationshipCommand, String)"
  })
  void testSave_thenCallsGetById2() {
    // Arrange
    when(legalEntityRelationshipKindService.getById(anyLong()))
        .thenReturn(
            ImmutableLegalEntityRelationshipKind.builder()
                .cardinality(Cardinality.ZERO_ONE)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .requiredRole("Required Role")
                .targetKind(EntityKind.ALL)
                .build());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkUploadLegalEntityRelationshipService.save(
                ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
                    .inputString("Input String")
                    .legalEntityRelationshipKindId(1L)
                    .updateMode(BulkUpdateMode.ADD_ONLY)
                    .build(),
                "janedoe"));
    verify(legalEntityRelationshipKindService).getById(1L);
  }

  /**
   * Test {@link
   * BulkUploadLegalEntityRelationshipService#resolve(BulkUploadLegalEntityRelationshipCommand)}.
   *
   * <p>Method under test: {@link
   * BulkUploadLegalEntityRelationshipService#resolve(BulkUploadLegalEntityRelationshipCommand)}
   */
  @Test
  @DisplayName("Test resolve(BulkUploadLegalEntityRelationshipCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.bulk_upload.legal_entity_relationship.ResolveBulkUploadLegalEntityRelationshipResponse BulkUploadLegalEntityRelationshipService.resolve(BulkUploadLegalEntityRelationshipCommand)"
  })
  void testResolve() {
    // Arrange
    LegalEntityRelationshipKindDao legalEntityRelationshipKindDao =
        mock(LegalEntityRelationshipKindDao.class);
    when(legalEntityRelationshipKindDao.getById(anyLong()))
        .thenReturn(
            ImmutableLegalEntityRelationshipKind.builder()
                .cardinality(Cardinality.ZERO_ONE)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .requiredRole("Required Role")
                .targetKind(EntityKind.ALL)
                .build());
    LegalEntityRelationshipKindService legalEntityRelationshipKindService =
        new LegalEntityRelationshipKindService(legalEntityRelationshipKindDao);
    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            mock(AssessmentDefinitionDao.class),
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            mock(UserPreferenceDao.class));
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityAliasPopulator entityAliasPopulator = mock(EntityAliasPopulator.class);
    LegalEntityRelationshipService legalEntityRelationshipService =
        new LegalEntityRelationshipService(mock(LegalEntityRelationshipDao.class));
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    BulkUploadLegalEntityRelationshipService bulkUploadLegalEntityRelationshipService =
        new BulkUploadLegalEntityRelationshipService(
            assessmentDefinitionService,
            ratingSchemeService,
            entityAliasPopulator,
            legalEntityRelationshipKindService,
            legalEntityRelationshipService,
            assessmentRatingService,
            new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkUploadLegalEntityRelationshipService.resolve(
                ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
                    .inputString("[,\\t|]")
                    .legalEntityRelationshipKindId(1L)
                    .updateMode(BulkUpdateMode.ADD_ONLY)
                    .build()));
    verify(legalEntityRelationshipKindDao).getById(1L);
  }

  /**
   * Test {@link
   * BulkUploadLegalEntityRelationshipService#resolve(BulkUploadLegalEntityRelationshipCommand)}.
   *
   * <p>Method under test: {@link
   * BulkUploadLegalEntityRelationshipService#resolve(BulkUploadLegalEntityRelationshipCommand)}
   */
  @Test
  @DisplayName("Test resolve(BulkUploadLegalEntityRelationshipCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.bulk_upload.legal_entity_relationship.ResolveBulkUploadLegalEntityRelationshipResponse BulkUploadLegalEntityRelationshipService.resolve(BulkUploadLegalEntityRelationshipCommand)"
  })
  void testResolve2() {
    // Arrange
    when(legalEntityRelationshipKindService.getById(anyLong()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkUploadLegalEntityRelationshipService.resolve(
                ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
                    .inputString("Input String")
                    .legalEntityRelationshipKindId(1L)
                    .updateMode(BulkUpdateMode.ADD_ONLY)
                    .build()));
    verify(legalEntityRelationshipKindService).getById(1L);
  }

  /**
   * Test {@link
   * BulkUploadLegalEntityRelationshipService#resolve(BulkUploadLegalEntityRelationshipCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link LegalEntityRelationshipKindDao#getById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BulkUploadLegalEntityRelationshipService#resolve(BulkUploadLegalEntityRelationshipCommand)}
   */
  @Test
  @DisplayName("Test resolve(BulkUploadLegalEntityRelationshipCommand); then calls getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.bulk_upload.legal_entity_relationship.ResolveBulkUploadLegalEntityRelationshipResponse BulkUploadLegalEntityRelationshipService.resolve(BulkUploadLegalEntityRelationshipCommand)"
  })
  void testResolve_thenCallsGetById() {
    // Arrange
    LegalEntityRelationshipKindDao legalEntityRelationshipKindDao =
        mock(LegalEntityRelationshipKindDao.class);
    when(legalEntityRelationshipKindDao.getById(anyLong()))
        .thenReturn(
            ImmutableLegalEntityRelationshipKind.builder()
                .cardinality(Cardinality.ZERO_ONE)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .requiredRole("Required Role")
                .targetKind(EntityKind.ALL)
                .build());
    LegalEntityRelationshipKindService legalEntityRelationshipKindService =
        new LegalEntityRelationshipKindService(legalEntityRelationshipKindDao);
    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            mock(AssessmentDefinitionDao.class),
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            mock(UserPreferenceDao.class));
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityAliasPopulator entityAliasPopulator = mock(EntityAliasPopulator.class);
    LegalEntityRelationshipService legalEntityRelationshipService =
        new LegalEntityRelationshipService(mock(LegalEntityRelationshipDao.class));
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    BulkUploadLegalEntityRelationshipService bulkUploadLegalEntityRelationshipService =
        new BulkUploadLegalEntityRelationshipService(
            assessmentDefinitionService,
            ratingSchemeService,
            entityAliasPopulator,
            legalEntityRelationshipKindService,
            legalEntityRelationshipService,
            assessmentRatingService,
            new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkUploadLegalEntityRelationshipService.resolve(
                ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
                    .inputString("Input String")
                    .legalEntityRelationshipKindId(1L)
                    .updateMode(BulkUpdateMode.ADD_ONLY)
                    .build()));
    verify(legalEntityRelationshipKindDao).getById(1L);
  }

  /**
   * Test {@link
   * BulkUploadLegalEntityRelationshipService#resolve(BulkUploadLegalEntityRelationshipCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link LegalEntityRelationshipKindService#getById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BulkUploadLegalEntityRelationshipService#resolve(BulkUploadLegalEntityRelationshipCommand)}
   */
  @Test
  @DisplayName("Test resolve(BulkUploadLegalEntityRelationshipCommand); then calls getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.bulk_upload.legal_entity_relationship.ResolveBulkUploadLegalEntityRelationshipResponse BulkUploadLegalEntityRelationshipService.resolve(BulkUploadLegalEntityRelationshipCommand)"
  })
  void testResolve_thenCallsGetById2() {
    // Arrange
    when(legalEntityRelationshipKindService.getById(anyLong()))
        .thenReturn(
            ImmutableLegalEntityRelationshipKind.builder()
                .cardinality(Cardinality.ZERO_ONE)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .requiredRole("Required Role")
                .targetKind(EntityKind.ALL)
                .build());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkUploadLegalEntityRelationshipService.resolve(
                ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
                    .inputString("Input String")
                    .legalEntityRelationshipKindId(1L)
                    .updateMode(BulkUpdateMode.ADD_ONLY)
                    .build()));
    verify(legalEntityRelationshipKindService).getById(1L);
  }

  /**
   * Test {@link BulkUploadLegalEntityRelationshipService#determineAction(boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code ADD}.
   * </ul>
   *
   * <p>Method under test: {@link BulkUploadLegalEntityRelationshipService#determineAction(boolean,
   * boolean)}
   */
  @Test
  @DisplayName("Test determineAction(boolean, boolean); when 'false'; then return 'ADD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UploadOperation BulkUploadLegalEntityRelationshipService.determineAction(boolean, boolean)"
  })
  void testDetermineAction_whenFalse_thenReturnAdd() {
    // Arrange, Act and Assert
    assertEquals(
        UploadOperation.ADD,
        BulkUploadLegalEntityRelationshipService.determineAction(false, false));
  }

  /**
   * Test {@link BulkUploadLegalEntityRelationshipService#determineAction(boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code REMOVE}.
   * </ul>
   *
   * <p>Method under test: {@link BulkUploadLegalEntityRelationshipService#determineAction(boolean,
   * boolean)}
   */
  @Test
  @DisplayName("Test determineAction(boolean, boolean); when 'true'; then return 'REMOVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UploadOperation BulkUploadLegalEntityRelationshipService.determineAction(boolean, boolean)"
  })
  void testDetermineAction_whenTrue_thenReturnRemove() {
    // Arrange, Act and Assert
    assertEquals(
        UploadOperation.REMOVE,
        BulkUploadLegalEntityRelationshipService.determineAction(true, true));
  }

  /**
   * Test {@link BulkUploadLegalEntityRelationshipService#determineAction(boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code UPDATE}.
   * </ul>
   *
   * <p>Method under test: {@link BulkUploadLegalEntityRelationshipService#determineAction(boolean,
   * boolean)}
   */
  @Test
  @DisplayName("Test determineAction(boolean, boolean); when 'true'; then return 'UPDATE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UploadOperation BulkUploadLegalEntityRelationshipService.determineAction(boolean, boolean)"
  })
  void testDetermineAction_whenTrue_thenReturnUpdate() {
    // Arrange, Act and Assert
    assertEquals(
        UploadOperation.UPDATE,
        BulkUploadLegalEntityRelationshipService.determineAction(true, false));
  }

  /**
   * Test {@link
   * BulkUploadLegalEntityRelationshipService#parseAssessmentsFromHeader(EntityReference, Set)}.
   *
   * <p>Method under test: {@link
   * BulkUploadLegalEntityRelationshipService#parseAssessmentsFromHeader(EntityReference, Set)}
   */
  @Test
  @DisplayName("Test parseAssessmentsFromHeader(EntityReference, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set BulkUploadLegalEntityRelationshipService.parseAssessmentsFromHeader(EntityReference, Set)"
  })
  void testParseAssessmentsFromHeader() {
    // Arrange
    when(assessmentDefinitionService.findByEntityKindAndQualifier(
            Mockito.<EntityKind>any(), Mockito.<EntityReference>any()))
        .thenThrow(new IllegalStateException());

    HashSet<String> headers = new HashSet<>();
    headers.add("");
    headers.add("42");
    headers.add("foo");

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> bulkUploadLegalEntityRelationshipService.parseAssessmentsFromHeader(null, headers));
    verify(assessmentDefinitionService)
        .findByEntityKindAndQualifier(eq(EntityKind.LEGAL_ENTITY_RELATIONSHIP), isNull());
  }

  /**
   * Test {@link
   * BulkUploadLegalEntityRelationshipService#parseAssessmentsFromHeader(EntityReference, Set)}.
   *
   * <p>Method under test: {@link
   * BulkUploadLegalEntityRelationshipService#parseAssessmentsFromHeader(EntityReference, Set)}
   */
  @Test
  @DisplayName("Test parseAssessmentsFromHeader(EntityReference, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set BulkUploadLegalEntityRelationshipService.parseAssessmentsFromHeader(EntityReference, Set)"
  })
  void testParseAssessmentsFromHeader2() {
    // Arrange
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    assessmentDefinitionSet.add(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());
    when(assessmentDefinitionService.findByEntityKindAndQualifier(
            Mockito.<EntityKind>any(), Mockito.<EntityReference>any()))
        .thenReturn(assessmentDefinitionSet);
    when(ratingSchemeService.findAllRatingSchemeItems()).thenReturn(new ArrayList<>());

    HashSet<String> headers = new HashSet<>();
    headers.add("");
    headers.add("42");
    headers.add("foo");

    // Act
    Set<AssessmentHeaderCell> actualParseAssessmentsFromHeaderResult =
        bulkUploadLegalEntityRelationshipService.parseAssessmentsFromHeader(null, headers);

    // Assert
    verify(assessmentDefinitionService)
        .findByEntityKindAndQualifier(eq(EntityKind.LEGAL_ENTITY_RELATIONSHIP), isNull());
    verify(ratingSchemeService).findAllRatingSchemeItems();
    assertEquals(3, actualParseAssessmentsFromHeaderResult.size());
  }

  /**
   * Test {@link
   * BulkUploadLegalEntityRelationshipService#parseAssessmentsFromHeader(EntityReference, Set)}.
   *
   * <p>Method under test: {@link
   * BulkUploadLegalEntityRelationshipService#parseAssessmentsFromHeader(EntityReference, Set)}
   */
  @Test
  @DisplayName("Test parseAssessmentsFromHeader(EntityReference, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set BulkUploadLegalEntityRelationshipService.parseAssessmentsFromHeader(EntityReference, Set)"
  })
  void testParseAssessmentsFromHeader3() {
    // Arrange
    when(assessmentDefinitionService.findByEntityKindAndQualifier(
            Mockito.<EntityKind>any(), Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());

    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    ratingSchemeItemList.add(
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
    when(ratingSchemeService.findAllRatingSchemeItems()).thenReturn(ratingSchemeItemList);

    HashSet<String> headers = new HashSet<>();
    headers.add("");
    headers.add("42");
    headers.add("foo");

    // Act
    Set<AssessmentHeaderCell> actualParseAssessmentsFromHeaderResult =
        bulkUploadLegalEntityRelationshipService.parseAssessmentsFromHeader(null, headers);

    // Assert
    verify(assessmentDefinitionService)
        .findByEntityKindAndQualifier(eq(EntityKind.LEGAL_ENTITY_RELATIONSHIP), isNull());
    verify(ratingSchemeService).findAllRatingSchemeItems();
    assertEquals(3, actualParseAssessmentsFromHeaderResult.size());
  }

  /**
   * Test {@link
   * BulkUploadLegalEntityRelationshipService#parseAssessmentsFromHeader(EntityReference, Set)}.
   *
   * <p>Method under test: {@link
   * BulkUploadLegalEntityRelationshipService#parseAssessmentsFromHeader(EntityReference, Set)}
   */
  @Test
  @DisplayName("Test parseAssessmentsFromHeader(EntityReference, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set BulkUploadLegalEntityRelationshipService.parseAssessmentsFromHeader(EntityReference, Set)"
  })
  void testParseAssessmentsFromHeader4() {
    // Arrange
    when(assessmentDefinitionService.findByEntityKindAndQualifier(
            Mockito.<EntityKind>any(), Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());

    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    ratingSchemeItemList.add(
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
    ratingSchemeItemList.add(
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
    when(ratingSchemeService.findAllRatingSchemeItems()).thenReturn(ratingSchemeItemList);

    HashSet<String> headers = new HashSet<>();
    headers.add("");
    headers.add("42");
    headers.add("foo");

    // Act
    Set<AssessmentHeaderCell> actualParseAssessmentsFromHeaderResult =
        bulkUploadLegalEntityRelationshipService.parseAssessmentsFromHeader(null, headers);

    // Assert
    verify(assessmentDefinitionService)
        .findByEntityKindAndQualifier(eq(EntityKind.LEGAL_ENTITY_RELATIONSHIP), isNull());
    verify(ratingSchemeService).findAllRatingSchemeItems();
    assertEquals(3, actualParseAssessmentsFromHeaderResult.size());
  }

  /**
   * Test {@link
   * BulkUploadLegalEntityRelationshipService#parseAssessmentsFromHeader(EntityReference, Set)}.
   *
   * <p>Method under test: {@link
   * BulkUploadLegalEntityRelationshipService#parseAssessmentsFromHeader(EntityReference, Set)}
   */
  @Test
  @DisplayName("Test parseAssessmentsFromHeader(EntityReference, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set BulkUploadLegalEntityRelationshipService.parseAssessmentsFromHeader(EntityReference, Set)"
  })
  void testParseAssessmentsFromHeader5() {
    // Arrange
    when(assessmentDefinitionService.findByEntityKindAndQualifier(
            Mockito.<EntityKind>any(), Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findAllRatingSchemeItems()).thenThrow(new IllegalStateException());

    HashSet<String> headers = new HashSet<>();
    headers.add("");
    headers.add("42");
    headers.add("foo");

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> bulkUploadLegalEntityRelationshipService.parseAssessmentsFromHeader(null, headers));
    verify(assessmentDefinitionService)
        .findByEntityKindAndQualifier(eq(EntityKind.LEGAL_ENTITY_RELATIONSHIP), isNull());
    verify(ratingSchemeService).findAllRatingSchemeItems();
  }

  /**
   * Test {@link
   * BulkUploadLegalEntityRelationshipService#parseAssessmentsFromHeader(EntityReference, Set)}.
   *
   * <p>Method under test: {@link
   * BulkUploadLegalEntityRelationshipService#parseAssessmentsFromHeader(EntityReference, Set)}
   */
  @Test
  @DisplayName("Test parseAssessmentsFromHeader(EntityReference, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set BulkUploadLegalEntityRelationshipService.parseAssessmentsFromHeader(EntityReference, Set)"
  })
  void testParseAssessmentsFromHeader6() {
    // Arrange
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    assessmentDefinitionSet.add(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());
    when(assessmentDefinitionService.findByEntityKindAndQualifier(
            Mockito.<EntityKind>any(), Mockito.<EntityReference>any()))
        .thenReturn(assessmentDefinitionSet);

    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    ratingSchemeItemList.add(
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
    when(ratingSchemeService.findAllRatingSchemeItems()).thenReturn(ratingSchemeItemList);

    HashSet<String> headers = new HashSet<>();
    headers.add("");
    headers.add("42");
    headers.add("foo");

    // Act
    Set<AssessmentHeaderCell> actualParseAssessmentsFromHeaderResult =
        bulkUploadLegalEntityRelationshipService.parseAssessmentsFromHeader(null, headers);

    // Assert
    verify(assessmentDefinitionService)
        .findByEntityKindAndQualifier(eq(EntityKind.LEGAL_ENTITY_RELATIONSHIP), isNull());
    verify(ratingSchemeService).findAllRatingSchemeItems();
    assertEquals(3, actualParseAssessmentsFromHeaderResult.size());
  }

  /**
   * Test {@link
   * BulkUploadLegalEntityRelationshipService#parseAssessmentsFromHeader(EntityReference, Set)}.
   *
   * <ul>
   *   <li>Given {@link AssessmentDefinitionService}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * BulkUploadLegalEntityRelationshipService#parseAssessmentsFromHeader(EntityReference, Set)}
   */
  @Test
  @DisplayName(
      "Test parseAssessmentsFromHeader(EntityReference, Set); given AssessmentDefinitionService; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set BulkUploadLegalEntityRelationshipService.parseAssessmentsFromHeader(EntityReference, Set)"
  })
  void testParseAssessmentsFromHeader_givenAssessmentDefinitionService_thenReturnEmpty() {
    // Arrange
    HashSet<String> headers = new HashSet<>();
    headers.add("42");
    headers.add("foo");

    // Act and Assert
    assertTrue(
        bulkUploadLegalEntityRelationshipService
            .parseAssessmentsFromHeader(null, headers)
            .isEmpty());
  }

  /**
   * Test {@link
   * BulkUploadLegalEntityRelationshipService#parseAssessmentsFromHeader(EntityReference, Set)}.
   *
   * <ul>
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link
   * BulkUploadLegalEntityRelationshipService#parseAssessmentsFromHeader(EntityReference, Set)}
   */
  @Test
  @DisplayName("Test parseAssessmentsFromHeader(EntityReference, Set); then return size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set BulkUploadLegalEntityRelationshipService.parseAssessmentsFromHeader(EntityReference, Set)"
  })
  void testParseAssessmentsFromHeader_thenReturnSizeIsThree() {
    // Arrange
    when(assessmentDefinitionService.findByEntityKindAndQualifier(
            Mockito.<EntityKind>any(), Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findAllRatingSchemeItems()).thenReturn(new ArrayList<>());

    HashSet<String> headers = new HashSet<>();
    headers.add("");
    headers.add("42");
    headers.add("foo");

    // Act
    Set<AssessmentHeaderCell> actualParseAssessmentsFromHeaderResult =
        bulkUploadLegalEntityRelationshipService.parseAssessmentsFromHeader(null, headers);

    // Assert
    verify(assessmentDefinitionService)
        .findByEntityKindAndQualifier(eq(EntityKind.LEGAL_ENTITY_RELATIONSHIP), isNull());
    verify(ratingSchemeService).findAllRatingSchemeItems();
    assertEquals(3, actualParseAssessmentsFromHeaderResult.size());
  }

  /**
   * Test {@link
   * BulkUploadLegalEntityRelationshipService#parseAssessmentsFromHeader(EntityReference, Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * BulkUploadLegalEntityRelationshipService#parseAssessmentsFromHeader(EntityReference, Set)}
   */
  @Test
  @DisplayName(
      "Test parseAssessmentsFromHeader(EntityReference, Set); when HashSet(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set BulkUploadLegalEntityRelationshipService.parseAssessmentsFromHeader(EntityReference, Set)"
  })
  void testParseAssessmentsFromHeader_whenHashSet_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        bulkUploadLegalEntityRelationshipService
            .parseAssessmentsFromHeader(null, new HashSet<>())
            .isEmpty());
  }

  /**
   * Test {@link
   * BulkUploadLegalEntityRelationshipService#parseAssessmentsFromHeader(EntityReference, Set)}.
   *
   * <ul>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add empty string.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * BulkUploadLegalEntityRelationshipService#parseAssessmentsFromHeader(EntityReference, Set)}
   */
  @Test
  @DisplayName(
      "Test parseAssessmentsFromHeader(EntityReference, Set); when LinkedHashSet() add empty string; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set BulkUploadLegalEntityRelationshipService.parseAssessmentsFromHeader(EntityReference, Set)"
  })
  void testParseAssessmentsFromHeader_whenLinkedHashSetAddEmptyString_thenReturnEmpty() {
    // Arrange
    LinkedHashSet<String> headers = new LinkedHashSet<>();
    headers.add("");

    // Act and Assert
    assertTrue(
        bulkUploadLegalEntityRelationshipService
            .parseAssessmentsFromHeader(null, headers)
            .isEmpty());
  }
}
