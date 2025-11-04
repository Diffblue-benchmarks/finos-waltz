package org.finos.waltz.web.endpoints.api;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.report_grid.ReportGridMember;
import org.finos.waltz.service.report_grid.ReportGridMemberService;
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
   * Method under test:
   * {@link ReportGridMemberEndpoint#findForGridIdRoute(Request, Response)}
   */
  @Test
  void testFindForGridIdRoute() throws IOException {
    // Arrange
    HashSet<ReportGridMember> reportGridMemberSet = new HashSet<>();
    when(reportGridMemberService.findByGridId(Mockito.<Long>any())).thenReturn(reportGridMemberSet);
    Request req = mock(Request.class);
    when(req.params(Mockito.<String>any())).thenReturn("42");

    // Act
    Set<ReportGridMember> actualFindForGridIdRouteResult = reportGridMemberEndpoint.findForGridIdRoute(req, null);

    // Assert
    verify(reportGridMemberService).findByGridId(eq(42L));
    verify(req).params(eq("id"));
    assertTrue(actualFindForGridIdRouteResult.isEmpty());
    assertSame(reportGridMemberSet, actualFindForGridIdRouteResult);
  }

  /**
   * Method under test:
   * {@link ReportGridMemberEndpoint#findPeopleForGridIdRoute(Request, Response)}
   */
  @Test
  void testFindPeopleForGridIdRoute() throws IOException {
    // Arrange
    HashSet<Person> personSet = new HashSet<>();
    when(reportGridMemberService.findPeopleByGridId(Mockito.<Long>any())).thenReturn(personSet);
    Request req = mock(Request.class);
    when(req.params(Mockito.<String>any())).thenReturn("42");

    // Act
    Set<Person> actualFindPeopleForGridIdRouteResult = reportGridMemberEndpoint.findPeopleForGridIdRoute(req, null);

    // Assert
    verify(reportGridMemberService).findPeopleByGridId(eq(42L));
    verify(req).params(eq("id"));
    assertTrue(actualFindPeopleForGridIdRouteResult.isEmpty());
    assertSame(personSet, actualFindPeopleForGridIdRouteResult);
  }
}
