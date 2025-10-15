package org.finos.waltz.web.endpoints.api;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.report_grid.ReportGridMemberDao;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.report_grid.ReportGridMember;
import org.finos.waltz.service.report_grid.ReportGridMemberService;
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
class ReportGridMemberEndpointDiffblueTest {
  @InjectMocks private ReportGridMemberEndpoint reportGridMemberEndpoint;

  @Mock private ReportGridMemberService reportGridMemberService;

  /**
   * Test {@link ReportGridMemberEndpoint#findForGridIdRoute(Request, Response)}.
   *
   * <ul>
   *   <li>Then calls {@link ReportGridMemberService#findByGridId(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberEndpoint#findForGridIdRoute(Request, Response)}
   */
  @Test
  @DisplayName("Test findForGridIdRoute(Request, Response); then calls findByGridId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridMemberEndpoint.findForGridIdRoute(Request, Response)"})
  void testFindForGridIdRoute_thenCallsFindByGridId() throws IOException {
    // Arrange
    when(reportGridMemberService.findByGridId(Mockito.<Long>any())).thenReturn(new HashSet<>());

    Request req = mock(Request.class);
    when(req.params(Mockito.<String>any())).thenReturn("42");

    // Act
    Set<ReportGridMember> actualFindForGridIdRouteResult =
        reportGridMemberEndpoint.findForGridIdRoute(req, null);

    // Assert
    verify(reportGridMemberService).findByGridId(42L);
    verify(req).params("id");
    assertTrue(actualFindForGridIdRouteResult.isEmpty());
  }

  /**
   * Test {@link ReportGridMemberEndpoint#findForGridIdRoute(Request, Response)}.
   *
   * <ul>
   *   <li>Then calls {@link ReportGridMemberDao#findByGridId(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberEndpoint#findForGridIdRoute(Request, Response)}
   */
  @Test
  @DisplayName("Test findForGridIdRoute(Request, Response); then calls findByGridId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridMemberEndpoint.findForGridIdRoute(Request, Response)"})
  void testFindForGridIdRoute_thenCallsFindByGridId2() throws IOException {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.findByGridId(Mockito.<Long>any())).thenReturn(new HashSet<>());
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(reportGridMemberDao);
    ReportGridMemberEndpoint reportGridMemberEndpoint =
        new ReportGridMemberEndpoint(reportGridMemberService);

    Request req = mock(Request.class);
    when(req.params(Mockito.<String>any())).thenReturn("42");

    // Act
    Set<ReportGridMember> actualFindForGridIdRouteResult =
        reportGridMemberEndpoint.findForGridIdRoute(req, null);

    // Assert
    verify(reportGridMemberDao).findByGridId(42L);
    verify(req).params("id");
    assertTrue(actualFindForGridIdRouteResult.isEmpty());
  }

  /**
   * Test {@link ReportGridMemberEndpoint#findPeopleForGridIdRoute(Request, Response)}.
   *
   * <ul>
   *   <li>Then calls {@link ReportGridMemberService#findPeopleByGridId(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberEndpoint#findPeopleForGridIdRoute(Request,
   * Response)}
   */
  @Test
  @DisplayName(
      "Test findPeopleForGridIdRoute(Request, Response); then calls findPeopleByGridId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridMemberEndpoint.findPeopleForGridIdRoute(Request, Response)"})
  void testFindPeopleForGridIdRoute_thenCallsFindPeopleByGridId() throws IOException {
    // Arrange
    when(reportGridMemberService.findPeopleByGridId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());

    Request req = mock(Request.class);
    when(req.params(Mockito.<String>any())).thenReturn("42");

    // Act
    Set<Person> actualFindPeopleForGridIdRouteResult =
        reportGridMemberEndpoint.findPeopleForGridIdRoute(req, null);

    // Assert
    verify(reportGridMemberService).findPeopleByGridId(42L);
    verify(req).params("id");
    assertTrue(actualFindPeopleForGridIdRouteResult.isEmpty());
  }

  /**
   * Test {@link ReportGridMemberEndpoint#findPeopleForGridIdRoute(Request, Response)}.
   *
   * <ul>
   *   <li>Then calls {@link ReportGridMemberDao#findPeopleByGridId(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberEndpoint#findPeopleForGridIdRoute(Request,
   * Response)}
   */
  @Test
  @DisplayName(
      "Test findPeopleForGridIdRoute(Request, Response); then calls findPeopleByGridId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridMemberEndpoint.findPeopleForGridIdRoute(Request, Response)"})
  void testFindPeopleForGridIdRoute_thenCallsFindPeopleByGridId2() throws IOException {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.findPeopleByGridId(Mockito.<Long>any())).thenReturn(new HashSet<>());
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(reportGridMemberDao);
    ReportGridMemberEndpoint reportGridMemberEndpoint =
        new ReportGridMemberEndpoint(reportGridMemberService);

    Request req = mock(Request.class);
    when(req.params(Mockito.<String>any())).thenReturn("42");

    // Act
    Set<Person> actualFindPeopleForGridIdRouteResult =
        reportGridMemberEndpoint.findPeopleForGridIdRoute(req, null);

    // Assert
    verify(reportGridMemberDao).findPeopleByGridId(42L);
    verify(req).params("id");
    assertTrue(actualFindPeopleForGridIdRouteResult.isEmpty());
  }
}
