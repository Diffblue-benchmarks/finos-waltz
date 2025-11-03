package org.finos.waltz.web.endpoints.api;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.common.exception.NotFoundException;
import org.finos.waltz.model.report_grid.ReportGridDefinition;
import org.finos.waltz.service.report_grid.ReportGridService;
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
  @InjectMocks
  private ReportGridEndpoint reportGridEndpoint;

  @Mock
  private ReportGridService reportGridService;

  /**
   * Test {@link ReportGridEndpoint#getDefinitionByIdRoute(Request, Response)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEndpoint#getDefinitionByIdRoute(Request, Response)}
   */
  @Test
  @DisplayName("Test getDefinitionByIdRoute(Request, Response); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ReportGridDefinition ReportGridEndpoint.getDefinitionByIdRoute(Request, Response)"})
  void testGetDefinitionByIdRoute_thenReturnNull() throws IOException {
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
   * Test {@link ReportGridEndpoint#findDefinitionsForOwnerRoute(Request, Response)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEndpoint#findDefinitionsForOwnerRoute(Request, Response)}
   */
  @Test
  @DisplayName("Test findDefinitionsForOwnerRoute(Request, Response); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReportGridEndpoint.findDefinitionsForOwnerRoute(Request, Response)"})
  void testFindDefinitionsForOwnerRoute_thenReturnEmpty() {
    // Arrange
    when(reportGridService.findDefinitionsForOwner(Mockito.<String>any())).thenReturn(new HashSet<>());
    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    Set<ReportGridDefinition> actualFindDefinitionsForOwnerRouteResult = reportGridEndpoint
        .findDefinitionsForOwnerRoute(req, null);

    // Assert
    verify(reportGridService).findDefinitionsForOwner(eq("Attribute"));
    verify(req).attribute(eq("waltz-user"));
    assertTrue(actualFindDefinitionsForOwnerRouteResult.isEmpty());
  }

  /**
   * Test {@link ReportGridEndpoint#findDefinitionsForOwnerRoute(Request, Response)}.
   * <ul>
   *   <li>Then throw {@link NotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportGridEndpoint#findDefinitionsForOwnerRoute(Request, Response)}
   */
  @Test
  @DisplayName("Test findDefinitionsForOwnerRoute(Request, Response); then throw NotFoundException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ReportGridEndpoint.findDefinitionsForOwnerRoute(Request, Response)"})
  void testFindDefinitionsForOwnerRoute_thenThrowNotFoundException() {
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
