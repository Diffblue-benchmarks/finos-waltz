package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableReportGridMemberCreateCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableReportGridMemberCreateCommand.Builder#from(ReportGridMemberCreateCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableReportGridMemberCreateCommand.Builder builderResult = ImmutableReportGridMemberCreateCommand.builder();
    ReportGridMemberCreateCommand instance = mock(ReportGridMemberCreateCommand.class);
    when(instance.role()).thenReturn(ReportGridMemberRole.VIEWER);
    when(instance.userId()).thenReturn("42");
    when(instance.gridId()).thenReturn(1L);

    // Act
    ImmutableReportGridMemberCreateCommand.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableReportGridMemberCreateCommand.Builder#from(ReportGridMemberCreateCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableReportGridMemberCreateCommand.Builder builderResult = ImmutableReportGridMemberCreateCommand.builder();
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
   * Method under test:
   * {@link ImmutableReportGridMemberCreateCommand.Builder#gridId(long)}
   */
  @Test
  void testBuilderGridId() {
    // Arrange
    ImmutableReportGridMemberCreateCommand.Builder builderResult = ImmutableReportGridMemberCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.gridId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridMemberCreateCommand.Builder#role(ReportGridMemberRole)}
   */
  @Test
  void testBuilderRole() {
    // Arrange
    ImmutableReportGridMemberCreateCommand.Builder builderResult = ImmutableReportGridMemberCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.role(ReportGridMemberRole.VIEWER));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridMemberCreateCommand.Builder#userId(String)}
   */
  @Test
  void testBuilderUserId() {
    // Arrange
    ImmutableReportGridMemberCreateCommand.Builder builderResult = ImmutableReportGridMemberCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridMemberCreateCommand#copyOf(ReportGridMemberCreateCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ReportGridMemberCreateCommand instance = mock(ReportGridMemberCreateCommand.class);
    when(instance.role()).thenReturn(ReportGridMemberRole.VIEWER);
    when(instance.userId()).thenReturn("42");
    when(instance.gridId()).thenReturn(1L);

    // Act
    ImmutableReportGridMemberCreateCommand actualCopyOfResult = ImmutableReportGridMemberCreateCommand.copyOf(instance);

    // Assert
    verify(instance).gridId();
    verify(instance).role();
    verify(instance).userId();
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals(1L, actualCopyOfResult.gridId());
    assertEquals(ReportGridMemberRole.VIEWER, actualCopyOfResult.role());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableReportGridMemberCreateCommand.Json}
   *   <li>
   * {@link ImmutableReportGridMemberCreateCommand.Json#setRole(ReportGridMemberRole)}
   *   <li>{@link ImmutableReportGridMemberCreateCommand.Json#setUserId(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableReportGridMemberCreateCommand.Json actualJson = new ImmutableReportGridMemberCreateCommand.Json();
    actualJson.setRole(ReportGridMemberRole.VIEWER);
    actualJson.setUserId("42");

    // Assert
    assertEquals("42", actualJson.userId);
    assertEquals(0L, actualJson.gridId);
    assertEquals(ReportGridMemberRole.VIEWER, actualJson.role);
    assertFalse(actualJson.gridIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridMemberCreateCommand.Json#gridId()}
   */
  @Test
  void testJsonGridId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridMemberCreateCommand.Json()).gridId());
  }

  /**
   * Method under test: {@link ImmutableReportGridMemberCreateCommand.Json#role()}
   */
  @Test
  void testJsonRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridMemberCreateCommand.Json()).role());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridMemberCreateCommand.Json#setGridId(long)}
   */
  @Test
  void testJsonSetGridId() {
    // Arrange
    ImmutableReportGridMemberCreateCommand.Json json = new ImmutableReportGridMemberCreateCommand.Json();

    // Act
    json.setGridId(1L);

    // Assert
    assertEquals(1L, json.gridId);
    assertTrue(json.gridIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridMemberCreateCommand.Json#userId()}
   */
  @Test
  void testJsonUserId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridMemberCreateCommand.Json()).userId());
  }
}
