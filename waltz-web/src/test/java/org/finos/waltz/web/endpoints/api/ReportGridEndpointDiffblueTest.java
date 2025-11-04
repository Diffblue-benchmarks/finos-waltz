package org.finos.waltz.web.endpoints.api;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.common.exception.NotFoundException;
import org.finos.waltz.model.report_grid.ReportGridDefinition;
import org.finos.waltz.service.report_grid.ReportGridService;
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
  @InjectMocks
  private ReportGridEndpoint reportGridEndpoint;

  @Mock
  private ReportGridService reportGridService;

  /**
   * Method under test:
   * {@link ReportGridEndpoint#getDefinitionByIdRoute(Request, Response)}
   */
  @Test
  void testGetDefinitionByIdRoute() throws IOException {
    // Arrange
    when(reportGridService.getGridDefinitionById(anyLong())).thenReturn(null);
    Request req = mock(Request.class);
    when(req.params(Mockito.<String>any())).thenReturn("42");

    // Act
    ReportGridDefinition actualDefinitionByIdRoute = reportGridEndpoint.getDefinitionByIdRoute(req, null);

    // Assert
    verify(reportGridService).getGridDefinitionById(eq(42L));
    verify(req).params(eq("id"));
    assertNull(actualDefinitionByIdRoute);
  }

  /**
   * Method under test:
   * {@link ReportGridEndpoint#findDefinitionsForOwnerRoute(Request, Response)}
   */
  @Test
  void testFindDefinitionsForOwnerRoute() {
    // Arrange
    HashSet<ReportGridDefinition> reportGridDefinitionSet = new HashSet<>();
    when(reportGridService.findDefinitionsForOwner(Mockito.<String>any())).thenReturn(reportGridDefinitionSet);
    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    Set<ReportGridDefinition> actualFindDefinitionsForOwnerRouteResult = reportGridEndpoint
        .findDefinitionsForOwnerRoute(req, null);

    // Assert
    verify(reportGridService).findDefinitionsForOwner(eq("Attribute"));
    verify(req).attribute(eq("waltz-user"));
    assertTrue(actualFindDefinitionsForOwnerRouteResult.isEmpty());
    assertSame(reportGridDefinitionSet, actualFindDefinitionsForOwnerRouteResult);
  }

  /**
   * Method under test:
   * {@link ReportGridEndpoint#findDefinitionsForOwnerRoute(Request, Response)}
   */
  @Test
  void testFindDefinitionsForOwnerRoute2() {
    // Arrange
    when(reportGridService.findDefinitionsForOwner(Mockito.<String>any()))
        .thenThrow(new NotFoundException("waltz-user", "An error occurred"));
    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act and Assert
    assertThrows(NotFoundException.class, () -> reportGridEndpoint.findDefinitionsForOwnerRoute(req, null));
    verify(reportGridService).findDefinitionsForOwner(eq("Attribute"));
    verify(req).attribute(eq("waltz-user"));
  }
}
