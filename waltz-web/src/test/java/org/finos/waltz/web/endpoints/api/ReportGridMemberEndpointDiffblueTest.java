package org.finos.waltz.web.endpoints.api;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
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
  @InjectMocks
  private ReportGridMemberEndpoint reportGridMemberEndpoint;

  @Mock
  private ReportGridMemberService reportGridMemberService;

  /**
   * Test {@link ReportGridMemberEndpoint#findForGridIdRoute(Request, Response)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridMemberEndpoint#findForGridIdRoute(Request, Response)}
   */
  @Test
  @DisplayName("Test findForGridIdRoute(Request, Response); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReportGridMemberEndpoint.findForGridIdRoute(Request, Response)"})
  void testFindForGridIdRoute_thenReturnEmpty() throws IOException {
    // Arrange
    when(reportGridMemberService.findByGridId(Mockito.<Long>any())).thenReturn(new HashSet<>());
    Request req = mock(Request.class);
    when(req.params(Mockito.<String>any())).thenReturn("42");

    // Act
    Set<ReportGridMember> actualFindForGridIdRouteResult = reportGridMemberEndpoint.findForGridIdRoute(req, null);

    // Assert
    verify(reportGridMemberService).findByGridId(eq(42L));
    verify(req).params(eq("id"));
    assertTrue(actualFindForGridIdRouteResult.isEmpty());
  }

  /**
   * Test {@link ReportGridMemberEndpoint#findPeopleForGridIdRoute(Request, Response)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridMemberEndpoint#findPeopleForGridIdRoute(Request, Response)}
   */
  @Test
  @DisplayName("Test findPeopleForGridIdRoute(Request, Response); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReportGridMemberEndpoint.findPeopleForGridIdRoute(Request, Response)"})
  void testFindPeopleForGridIdRoute_thenReturnEmpty() throws IOException {
    // Arrange
    when(reportGridMemberService.findPeopleByGridId(Mockito.<Long>any())).thenReturn(new HashSet<>());
    Request req = mock(Request.class);
    when(req.params(Mockito.<String>any())).thenReturn("42");

    // Act
    Set<Person> actualFindPeopleForGridIdRouteResult = reportGridMemberEndpoint.findPeopleForGridIdRoute(req, null);

    // Assert
    verify(reportGridMemberService).findPeopleByGridId(eq(42L));
    verify(req).params(eq("id"));
    assertTrue(actualFindPeopleForGridIdRouteResult.isEmpty());
  }
}
