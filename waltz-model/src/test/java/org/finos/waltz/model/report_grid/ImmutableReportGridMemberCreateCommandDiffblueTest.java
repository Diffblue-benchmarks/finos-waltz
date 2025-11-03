package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.report_grid.ImmutableReportGridMemberCreateCommand.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridMemberCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridMemberCreateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#from(ReportGridMemberCreateCommand)}.
   * <ul>
   *   <li>Given {@code VIEWER}.</li>
   *   <li>Then builder build userId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridMemberCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridMemberCreateCommand); given 'VIEWER'; then builder build userId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridMemberCreateCommand)"})
  void testBuilderFrom_givenViewer_thenBuilderBuildUserIdIs42() {
    // Arrange
    Builder builderResult = ImmutableReportGridMemberCreateCommand.builder();
    ReportGridMemberCreateCommand instance = mock(ReportGridMemberCreateCommand.class);
    when(instance.role()).thenReturn(ReportGridMemberRole.VIEWER);
    when(instance.userId()).thenReturn("42");
    when(instance.gridId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).gridId();
    verify(instance).role();
    verify(instance).userId();
    ImmutableReportGridMemberCreateCommand buildResult = builderResult.build();
    assertEquals("42", buildResult.userId());
    assertEquals(1L, buildResult.gridId());
    assertEquals(ReportGridMemberRole.VIEWER, buildResult.role());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridMemberCreateCommand)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridMemberCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridMemberCreateCommand); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridMemberCreateCommand)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableReportGridMemberCreateCommand.builder();
    ReportGridMemberCreateCommand instance = mock(ReportGridMemberCreateCommand.class);
    when(instance.role()).thenThrow(new IllegalStateException("instance"));
    when(instance.userId()).thenReturn("42");
    when(instance.gridId()).thenReturn(1L);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).gridId();
    verify(instance).role();
    verify(instance).userId();
  }

  /**
   * Test Builder {@link Builder#gridId(long)}.
   * <p>
   * Method under test: {@link Builder#gridId(long)}
   */
  @Test
  @DisplayName("Test Builder gridId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.gridId(long)"})
  void testBuilderGridId() {
    // Arrange
    Builder builderResult = ImmutableReportGridMemberCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.gridId(1L));
  }

  /**
   * Test Builder {@link Builder#role(ReportGridMemberRole)}.
   * <p>
   * Method under test: {@link Builder#role(ReportGridMemberRole)}
   */
  @Test
  @DisplayName("Test Builder role(ReportGridMemberRole)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.role(ReportGridMemberRole)"})
  void testBuilderRole() {
    // Arrange
    Builder builderResult = ImmutableReportGridMemberCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.role(ReportGridMemberRole.VIEWER));
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
    Builder builderResult = ImmutableReportGridMemberCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userId("42"));
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
    assertEquals(0L, actualJson.gridId);
    assertEquals(ReportGridMemberRole.VIEWER, actualJson.role);
    assertFalse(actualJson.gridIdIsSet);
  }

  /**
   * Test Json {@link Json#gridId()}.
   * <p>
   * Method under test: {@link Json#gridId()}
   */
  @Test
  @DisplayName("Test Json gridId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.gridId()"})
  void testJsonGridId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).gridId());
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
   * Test Json {@link Json#setGridId(long)}.
   * <p>
   * Method under test: {@link Json#setGridId(long)}
   */
  @Test
  @DisplayName("Test Json setGridId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setGridId(long)"})
  void testJsonSetGridId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setGridId(1L);

    // Assert
    assertEquals(1L, json.gridId);
    assertTrue(json.gridIdIsSet);
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
