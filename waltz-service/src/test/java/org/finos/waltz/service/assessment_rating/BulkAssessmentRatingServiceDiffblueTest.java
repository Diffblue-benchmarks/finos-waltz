package org.finos.waltz.service.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.assessment_definition.AssessmentDefinitionDao;
import org.finos.waltz.data.assessment_rating.AssessmentRatingDao;
import org.finos.waltz.data.assessment_rating.AssessmentRatingRippler;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.legal_entity.LegalEntityRelationshipDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable.MeasurableDao;
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
import org.finos.waltz.data.user.UserPreferenceDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.assessment_rating.bulk_upload.AssessmentRatingParsedResult;
import org.finos.waltz.model.assessment_rating.bulk_upload.AssessmentRatingValidationResult;
import org.finos.waltz.model.exceptions.NotAuthorizedException;
import org.finos.waltz.service.assessment_definition.AssessmentDefinitionService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.permission.permission_checker.AssessmentRatingPermissionChecker;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BulkAssessmentRatingServiceDiffblueTest {
  /**
   * Method under test:
   * {@link BulkAssessmentRatingService#apply(EntityReference, AssessmentRatingValidationResult, String)}
   */
  @Test
  void testApply() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    AssessmentDefinitionService assessmentDefinitionService = new AssessmentDefinitionService(
        mock(AssessmentDefinitionDao.class), mock(MeasurableDao.class), mock(MeasurableRatingDao.class),
        mock(LegalEntityRelationshipDao.class), mock(UserPreferenceDao.class));

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingService assessmentRatingService = new AssessmentRatingService(assessmentRatingDao,
        assessmentDefinitionDao, ratingSchemeDAO, changeLogService2, assessmentRatingPermissionChecker,
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class)));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));

    // Act and Assert
    assertThrows(NotAuthorizedException.class,
        () -> (new BulkAssessmentRatingService(assessmentDefinitionService, assessmentRatingService,
            ratingSchemeService, userRoleService, new DefaultDSLContext(SQLDialect.SQL99))).apply(null,
                mock(AssessmentRatingValidationResult.class), "42"));
    verify(userRoleDao).getUserRoles(eq("42"));
  }

  /**
   * Method under test:
   * {@link BulkAssessmentRatingService#apply(EntityReference, AssessmentRatingValidationResult, String)}
   */
  @Test
  void testApply2() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) any())).thenReturn(true);
    AssessmentDefinitionService assessmentDefinitionService = new AssessmentDefinitionService(
        mock(AssessmentDefinitionDao.class), mock(MeasurableDao.class), mock(MeasurableRatingDao.class),
        mock(LegalEntityRelationshipDao.class), mock(UserPreferenceDao.class));

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingService assessmentRatingService = new AssessmentRatingService(assessmentRatingDao,
        assessmentDefinitionDao, ratingSchemeDAO, changeLogService, assessmentRatingPermissionChecker,
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class)));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    BulkAssessmentRatingService bulkAssessmentRatingService = new BulkAssessmentRatingService(
        assessmentDefinitionService, assessmentRatingService, ratingSchemeService, userRoleService,
        new DefaultDSLContext(SQLDialect.SQL99));
    AssessmentRatingValidationResult preview = mock(AssessmentRatingValidationResult.class);
    when(preview.error()).thenReturn(mock(AssessmentRatingParsedResult.AssessmentRatingParseError.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> bulkAssessmentRatingService.apply(null, preview, "42"));
    verify(preview).error();
    verify(userRoleService).hasRole(eq("42"), (String[]) any());
  }

  /**
   * Method under test:
   * {@link BulkAssessmentRatingService#apply(EntityReference, AssessmentRatingValidationResult, String)}
   */
  @Test
  void testApply3() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) any())).thenReturn(true);
    AssessmentDefinitionService assessmentDefinitionService = new AssessmentDefinitionService(
        mock(AssessmentDefinitionDao.class), mock(MeasurableDao.class), mock(MeasurableRatingDao.class),
        mock(LegalEntityRelationshipDao.class), mock(UserPreferenceDao.class));

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker = mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingService assessmentRatingService = new AssessmentRatingService(assessmentRatingDao,
        assessmentDefinitionDao, ratingSchemeDAO, changeLogService, assessmentRatingPermissionChecker,
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class)));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    BulkAssessmentRatingService bulkAssessmentRatingService = new BulkAssessmentRatingService(
        assessmentDefinitionService, assessmentRatingService, ratingSchemeService, userRoleService,
        new DefaultDSLContext(SQLDialect.SQL99));
    AssessmentRatingValidationResult preview = mock(AssessmentRatingValidationResult.class);
    when(preview.error()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> bulkAssessmentRatingService.apply(null, preview, "42"));
    verify(preview).error();
    verify(userRoleService).hasRole(eq("42"), (String[]) any());
  }
}
