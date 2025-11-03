package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.report_grid.ImmutableReportGridMemberUpdateRoleCommand.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridMemberUpdateRoleCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridMemberUpdateRoleCommandDiffblueTest {
  /**
   * Test {@link ImmutableReportGridMemberUpdateRoleCommand#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGridMemberUpdateRoleCommand#builder()}
   *   <li>{@link ImmutableReportGridMemberUpdateRoleCommand#role(ReportGridMemberRole)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableReportGridMemberUpdateRoleCommand Builder.build()",
      "Builder Builder.role(ReportGridMemberRole)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableReportGridMemberUpdateRoleCommand.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.role(ReportGridMemberRole.VIEWER));
  }

  /**
   * Test Builder {@link Builder#from(ReportGridMemberUpdateRoleCommand)}.
   * <ul>
   *   <li>Given {@code VIEWER}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridMemberUpdateRoleCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridMemberUpdateRoleCommand); given 'VIEWER'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridMemberUpdateRoleCommand)"})
  void testBuilderFrom_givenViewer_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridMemberUpdateRoleCommand.builder();
    ReportGridMemberUpdateRoleCommand instance = mock(ReportGridMemberUpdateRoleCommand.class);
    when(instance.role()).thenReturn(ReportGridMemberRole.VIEWER);
    when(instance.userId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).role();
    verify(instance).userId();
    ImmutableReportGridMemberUpdateRoleCommand buildResult = builderResult.build();
    assertEquals("42", buildResult.userId());
    assertEquals(ReportGridMemberRole.VIEWER, buildResult.role());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#userId(String)}.
   * <p>
   * Method under test: {@link Builder#userId(String)}
   */
  @Test
  @DisplayName("Test Builder userId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.userId(String)"})
  void testBuilderUserId() {
    // Arrange
    Builder builderResult = ImmutableReportGridMemberUpdateRoleCommand.builder();

    // Act
    Builder actualUserIdResult = builderResult.userId("42");

    // Assert
    ImmutableReportGridMemberUpdateRoleCommand buildResult = builderResult.build();
    assertEquals("42", buildResult.userId());
    assertEquals(ReportGridMemberRole.VIEWER, buildResult.role());
    assertSame(builderResult, actualUserIdResult);
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setRole(ReportGridMemberRole)}
   *   <li>{@link Json#setUserId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setRole(ReportGridMemberRole)", "void Json.setUserId(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setRole(ReportGridMemberRole.VIEWER);
    actualJson.setUserId("42");

    // Assert
    assertEquals("42", actualJson.userId);
    assertEquals(ReportGridMemberRole.VIEWER, actualJson.role);
  }

  /**
   * Test Json {@link Json#role()}.
   * <p>
   * Method under test: {@link Json#role()}
   */
  @Test
  @DisplayName("Test Json role()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ReportGridMemberRole Json.role()"})
  void testJsonRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).role());
  }

  /**
   * Test Json {@link Json#userId()}.
   * <p>
   * Method under test: {@link Json#userId()}
   */
  @Test
  @DisplayName("Test Json userId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.userId()"})
  void testJsonUserId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).userId());
  }
}
