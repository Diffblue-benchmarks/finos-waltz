package org.finos.waltz.web.endpoints.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.common.exception.NotFoundException;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.change_initiative.ChangeInitiativeDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.person.search.PersonSearchDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.rating_scheme.RatingSchemeDAO;
import org.finos.waltz.data.report_grid.ReportGridDao;
import org.finos.waltz.data.report_grid.ReportGridMemberDao;
import org.finos.waltz.data.role.RoleDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.report_grid.ImmutableReportGridDefinition;
import org.finos.waltz.model.report_grid.ReportGridDefinition;
import org.finos.waltz.model.report_grid.ReportGridDerivedColumnDefinition;
import org.finos.waltz.model.report_grid.ReportGridKind;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
import org.finos.waltz.service.report_grid.ReportGridMemberService;
import org.finos.waltz.service.report_grid.ReportGridService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import spark.Request;
import spark.Response;

@ExtendWith(MockitoExtension.class)
class ReportGridEndpointDiffblueTest {
  @InjectMocks private ReportGridEndpoint reportGridEndpoint;

  @Mock private ReportGridService reportGridService;

  /**
   * Test {@link ReportGridEndpoint#getDefinitionByIdRoute(Request, Response)}.
   *
   * <ul>
   *   <li>Then calls {@link ReportGridDao#getGridDefinitionById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridEndpoint#getDefinitionByIdRoute(Request, Response)}
   */
  @Test
  @DisplayName(
      "Test getDefinitionByIdRoute(Request, Response); then calls getGridDefinitionById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridDefinition ReportGridEndpoint.getDefinitionByIdRoute(Request, Response)"
  })
  void testGetDefinitionByIdRoute_thenCallsGetGridDefinitionById() throws IOException {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(mock(ReportGridMemberDao.class));
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

    ReportGridService reportGridService =
        new ReportGridService(
            reportGridDao,
            applicationDao,
            ratingSchemeService,
            reportGridMemberService,
            userRoleService,
            mock(ChangeInitiativeDao.class));
    ReportGridEndpoint reportGridEndpoint = new ReportGridEndpoint(reportGridService);

    Request req = mock(Request.class);
    when(req.params(Mockito.<String>any())).thenReturn("42");

    // Act
    ReportGridDefinition actualDefinitionByIdRoute =
        reportGridEndpoint.getDefinitionByIdRoute(req, null);

    // Assert
    verify(reportGridDao).getGridDefinitionById(42L);
    verify(req).params("id");
    assertTrue(actualDefinitionByIdRoute instanceof ImmutableReportGridDefinition);
    LocalDateTime lastUpdatedAtResult = actualDefinitionByIdRoute.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualDefinitionByIdRoute.lastUpdatedBy());
    assertEquals("Name", actualDefinitionByIdRoute.name());
    assertEquals("Provenance", actualDefinitionByIdRoute.provenance());
    assertEquals(
        "The characteristics of someone or something", actualDefinitionByIdRoute.description());
    assertEquals(EntityKind.ALL, actualDefinitionByIdRoute.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualDefinitionByIdRoute.kind());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        actualDefinitionByIdRoute.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, actualDefinitionByIdRoute.fixedColumnDefinitions());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ReportGridEndpoint#getDefinitionByIdRoute(Request, Response)}.
   *
   * <ul>
   *   <li>Then calls {@link ReportGridService#getGridDefinitionById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridEndpoint#getDefinitionByIdRoute(Request, Response)}
   */
  @Test
  @DisplayName(
      "Test getDefinitionByIdRoute(Request, Response); then calls getGridDefinitionById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridDefinition ReportGridEndpoint.getDefinitionByIdRoute(Request, Response)"
  })
  void testGetDefinitionByIdRoute_thenCallsGetGridDefinitionById2() throws IOException {
    // Arrange
    ReportGridService reportGridService = mock(ReportGridService.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(reportGridService.getGridDefinitionById(anyLong()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());
    ReportGridEndpoint reportGridEndpoint = new ReportGridEndpoint(reportGridService);

    Request req = mock(Request.class);
    when(req.params(Mockito.<String>any())).thenReturn("42");

    // Act
    ReportGridDefinition actualDefinitionByIdRoute =
        reportGridEndpoint.getDefinitionByIdRoute(req, null);

    // Assert
    verify(reportGridService).getGridDefinitionById(42L);
    verify(req).params("id");
    assertTrue(actualDefinitionByIdRoute instanceof ImmutableReportGridDefinition);
    LocalDateTime lastUpdatedAtResult = actualDefinitionByIdRoute.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualDefinitionByIdRoute.lastUpdatedBy());
    assertEquals("Name", actualDefinitionByIdRoute.name());
    assertEquals("Provenance", actualDefinitionByIdRoute.provenance());
    assertEquals(
        "The characteristics of someone or something", actualDefinitionByIdRoute.description());
    assertEquals(EntityKind.ALL, actualDefinitionByIdRoute.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualDefinitionByIdRoute.kind());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        actualDefinitionByIdRoute.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, actualDefinitionByIdRoute.fixedColumnDefinitions());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ReportGridEndpoint#findDefinitionsForOwnerRoute(Request, Response)}.
   *
   * <p>Method under test: {@link ReportGridEndpoint#findDefinitionsForOwnerRoute(Request,
   * Response)}
   */
  @Test
  @DisplayName("Test findDefinitionsForOwnerRoute(Request, Response)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridEndpoint.findDefinitionsForOwnerRoute(Request, Response)"})
  void testFindDefinitionsForOwnerRoute() {
    // Arrange
    ReportGridService reportGridService = mock(ReportGridService.class);
    when(reportGridService.findDefinitionsForOwner(Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    ReportGridEndpoint reportGridEndpoint = new ReportGridEndpoint(reportGridService);

    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    Set<ReportGridDefinition> actualFindDefinitionsForOwnerRouteResult =
        reportGridEndpoint.findDefinitionsForOwnerRoute(req, null);

    // Assert
    verify(reportGridService).findDefinitionsForOwner("Attribute");
    verify(req).attribute("waltz-user");
    assertTrue(actualFindDefinitionsForOwnerRouteResult.isEmpty());
  }

  /**
   * Test {@link ReportGridEndpoint#findDefinitionsForOwnerRoute(Request, Response)}.
   *
   * <ul>
   *   <li>Then calls {@link ReportGridDao#findDefinitionsForOwner(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridEndpoint#findDefinitionsForOwnerRoute(Request,
   * Response)}
   */
  @Test
  @DisplayName(
      "Test findDefinitionsForOwnerRoute(Request, Response); then calls findDefinitionsForOwner(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridEndpoint.findDefinitionsForOwnerRoute(Request, Response)"})
  void testFindDefinitionsForOwnerRoute_thenCallsFindDefinitionsForOwner() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.findDefinitionsForOwner(Mockito.<String>any())).thenReturn(new HashSet<>());
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(mock(ReportGridMemberDao.class));
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

    ReportGridService reportGridService =
        new ReportGridService(
            reportGridDao,
            applicationDao,
            ratingSchemeService,
            reportGridMemberService,
            userRoleService,
            mock(ChangeInitiativeDao.class));
    ReportGridEndpoint reportGridEndpoint = new ReportGridEndpoint(reportGridService);

    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    Set<ReportGridDefinition> actualFindDefinitionsForOwnerRouteResult =
        reportGridEndpoint.findDefinitionsForOwnerRoute(req, null);

    // Assert
    verify(reportGridDao).findDefinitionsForOwner("Attribute");
    verify(req).attribute("waltz-user");
    assertTrue(actualFindDefinitionsForOwnerRouteResult.isEmpty());
  }

  /**
   * Test {@link ReportGridEndpoint#findDefinitionsForOwnerRoute(Request, Response)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridEndpoint#findDefinitionsForOwnerRoute(Request,
   * Response)}
   */
  @Test
  @DisplayName("Test findDefinitionsForOwnerRoute(Request, Response); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridEndpoint.findDefinitionsForOwnerRoute(Request, Response)"})
  void testFindDefinitionsForOwnerRoute_thenThrowNotFoundException() {
    // Arrange
    when(reportGridService.findDefinitionsForOwner(Mockito.<String>any()))
        .thenThrow(new NotFoundException("waltz-user", "An error occurred"));

    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act and Assert
    assertThrows(
        NotFoundException.class, () -> reportGridEndpoint.findDefinitionsForOwnerRoute(req, null));
    verify(reportGridService).findDefinitionsForOwner("Attribute");
    verify(req).attribute("waltz-user");
  }
}
