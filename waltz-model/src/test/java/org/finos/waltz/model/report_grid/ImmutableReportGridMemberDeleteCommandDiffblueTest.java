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
import org.finos.waltz.model.report_grid.ImmutableReportGridMemberDeleteCommand.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridMemberDeleteCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridMemberDeleteCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#from(ReportGridMemberDeleteCommand)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then builder build userId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridMemberDeleteCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridMemberDeleteCommand); given '42'; then builder build userId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridMemberDeleteCommand)"})
  void testBuilderFrom_given42_thenBuilderBuildUserIdIs42() {
    // Arrange
    Builder builderResult = ImmutableReportGridMemberDeleteCommand.builder();
    ReportGridMemberDeleteCommand instance = mock(ReportGridMemberDeleteCommand.class);
    when(instance.userId()).thenReturn("42");
    when(instance.gridId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).gridId();
    verify(instance).userId();
    ImmutableReportGridMemberDeleteCommand buildResult = builderResult.build();
    assertEquals("42", buildResult.userId());
    assertEquals(1L, buildResult.gridId());
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableReportGridMemberDeleteCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.gridId(1L));
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
    Builder builderResult = ImmutableReportGridMemberDeleteCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userId("42"));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setUserId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setUserId(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setUserId("42");

    // Assert
    assertEquals("42", actualJson.userId);
    assertEquals(0L, actualJson.gridId);
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
