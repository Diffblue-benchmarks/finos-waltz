package org.finos.waltz.model.reportee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.reportee.ImmutableReportee.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReporteeDiffblueTest {
  /**
   * Test Builder {@link Builder#employeeId(String)}.
   * <p>
   * Method under test: {@link Builder#employeeId(String)}
   */
  @Test
  @DisplayName("Test Builder employeeId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.employeeId(String)"})
  void testBuilderEmployeeId() {
    // Arrange
    Builder builderResult = ImmutableReportee.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.employeeId("42"));
  }

  /**
   * Test Builder {@link Builder#from(Reportee)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then builder build employeeId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Reportee)}
   */
  @Test
  @DisplayName("Test Builder from(Reportee); given one; then builder build employeeId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Reportee)"})
  void testBuilderFrom_givenOne_thenBuilderBuildEmployeeIdIs42() {
    // Arrange
    Builder builderResult = ImmutableReportee.builder();
    Reportee instance = mock(Reportee.class);
    when(instance.level()).thenReturn(1);
    when(instance.managerId()).thenReturn("42");
    when(instance.employeeId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).employeeId();
    verify(instance).level();
    verify(instance).managerId();
    ImmutableReportee buildResult = builderResult.build();
    assertEquals("42", buildResult.employeeId());
    assertEquals("42", buildResult.managerId());
    assertEquals(1, buildResult.level());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Reportee)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Reportee)}
   */
  @Test
  @DisplayName("Test Builder from(Reportee); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Reportee)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableReportee.builder();
    Reportee instance = mock(Reportee.class);
    when(instance.level()).thenThrow(new IllegalStateException("instance"));
    when(instance.managerId()).thenReturn("42");
    when(instance.employeeId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).employeeId();
    verify(instance).level();
    verify(instance).managerId();
  }

  /**
   * Test Builder {@link Builder#level(int)}.
   * <p>
   * Method under test: {@link Builder#level(int)}
   */
  @Test
  @DisplayName("Test Builder level(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.level(int)"})
  void testBuilderLevel() {
    // Arrange
    Builder builderResult = ImmutableReportee.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.level(1));
  }

  /**
   * Test Builder {@link Builder#managerId(String)}.
   * <p>
   * Method under test: {@link Builder#managerId(String)}
   */
  @Test
  @DisplayName("Test Builder managerId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.managerId(String)"})
  void testBuilderManagerId() {
    // Arrange
    Builder builderResult = ImmutableReportee.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.managerId("42"));
  }
}
