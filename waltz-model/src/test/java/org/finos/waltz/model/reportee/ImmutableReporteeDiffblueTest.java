package org.finos.waltz.model.reportee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableReporteeDiffblueTest {
  /**
   * Method under test: {@link ImmutableReportee.Builder#employeeId(String)}
   */
  @Test
  void testBuilderEmployeeId() {
    // Arrange
    ImmutableReportee.Builder builderResult = ImmutableReportee.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.employeeId("42"));
  }

  /**
   * Method under test: {@link ImmutableReportee.Builder#from(Reportee)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableReportee.Builder builderResult = ImmutableReportee.builder();
    Reportee instance = mock(Reportee.class);
    when(instance.level()).thenReturn(1);
    when(instance.managerId()).thenReturn("42");
    when(instance.employeeId()).thenReturn("42");

    // Act
    ImmutableReportee.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableReportee.Builder#from(Reportee)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableReportee.Builder builderResult = ImmutableReportee.builder();
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
   * Method under test: {@link ImmutableReportee.Builder#level(int)}
   */
  @Test
  void testBuilderLevel() {
    // Arrange
    ImmutableReportee.Builder builderResult = ImmutableReportee.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.level(1));
  }

  /**
   * Method under test: {@link ImmutableReportee.Builder#managerId(String)}
   */
  @Test
  void testBuilderManagerId() {
    // Arrange
    ImmutableReportee.Builder builderResult = ImmutableReportee.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.managerId("42"));
  }

  /**
   * Method under test: {@link ImmutableReportee#copyOf(Reportee)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    Reportee instance = mock(Reportee.class);
    when(instance.level()).thenReturn(1);
    when(instance.managerId()).thenReturn("42");
    when(instance.employeeId()).thenReturn("42");

    // Act
    ImmutableReportee actualCopyOfResult = ImmutableReportee.copyOf(instance);

    // Assert
    verify(instance).employeeId();
    verify(instance).level();
    verify(instance).managerId();
    assertEquals("42", actualCopyOfResult.employeeId());
    assertEquals("42", actualCopyOfResult.managerId());
    assertEquals(1, actualCopyOfResult.level());
  }
}
