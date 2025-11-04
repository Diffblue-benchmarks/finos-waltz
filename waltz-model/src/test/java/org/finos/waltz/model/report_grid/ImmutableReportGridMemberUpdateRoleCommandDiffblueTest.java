package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableReportGridMemberUpdateRoleCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGridMemberUpdateRoleCommand#builder()}
   *   <li>
   * {@link ImmutableReportGridMemberUpdateRoleCommand#role(ReportGridMemberRole)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableReportGridMemberUpdateRoleCommand.Builder actualBuilderResult = ImmutableReportGridMemberUpdateRoleCommand
        .builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.role(ReportGridMemberRole.VIEWER));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridMemberUpdateRoleCommand.Builder#from(ReportGridMemberUpdateRoleCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableReportGridMemberUpdateRoleCommand.Builder builderResult = ImmutableReportGridMemberUpdateRoleCommand
        .builder();
    ReportGridMemberUpdateRoleCommand instance = mock(ReportGridMemberUpdateRoleCommand.class);
    when(instance.role()).thenReturn(ReportGridMemberRole.VIEWER);
    when(instance.userId()).thenReturn("42");

    // Act
    ImmutableReportGridMemberUpdateRoleCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).role();
    verify(instance).userId();
    ImmutableReportGridMemberUpdateRoleCommand buildResult = builderResult.build();
    assertEquals("42", buildResult.userId());
    assertEquals(ReportGridMemberRole.VIEWER, buildResult.role());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridMemberUpdateRoleCommand.Builder#userId(String)}
   */
  @Test
  void testBuilderUserId() {
    // Arrange
    ImmutableReportGridMemberUpdateRoleCommand.Builder builderResult = ImmutableReportGridMemberUpdateRoleCommand
        .builder();

    // Act
    ImmutableReportGridMemberUpdateRoleCommand.Builder actualUserIdResult = builderResult.userId("42");

    // Assert
    ImmutableReportGridMemberUpdateRoleCommand buildResult = builderResult.build();
    assertEquals("42", buildResult.userId());
    assertEquals(ReportGridMemberRole.VIEWER, buildResult.role());
    assertSame(builderResult, actualUserIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridMemberUpdateRoleCommand#copyOf(ReportGridMemberUpdateRoleCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ReportGridMemberUpdateRoleCommand instance = mock(ReportGridMemberUpdateRoleCommand.class);
    when(instance.role()).thenReturn(ReportGridMemberRole.VIEWER);
    when(instance.userId()).thenReturn("42");

    // Act
    ImmutableReportGridMemberUpdateRoleCommand actualCopyOfResult = ImmutableReportGridMemberUpdateRoleCommand
        .copyOf(instance);

    // Assert
    verify(instance).role();
    verify(instance).userId();
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals(ReportGridMemberRole.VIEWER, actualCopyOfResult.role());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridMemberUpdateRoleCommand#fromJson(ImmutableReportGridMemberUpdateRoleCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableReportGridMemberUpdateRoleCommand.Json json = new ImmutableReportGridMemberUpdateRoleCommand.Json();
    json.setUserId("Json");
    json.setRole(null);

    // Act
    ImmutableReportGridMemberUpdateRoleCommand actualFromJsonResult = ImmutableReportGridMemberUpdateRoleCommand
        .fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.userId());
    assertEquals(ReportGridMemberRole.VIEWER, actualFromJsonResult.role());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridMemberUpdateRoleCommand#fromJson(ImmutableReportGridMemberUpdateRoleCommand.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableReportGridMemberUpdateRoleCommand.Json json = new ImmutableReportGridMemberUpdateRoleCommand.Json();
    json.setUserId("Json");
    json.setRole(ReportGridMemberRole.VIEWER);

    // Act
    ImmutableReportGridMemberUpdateRoleCommand actualFromJsonResult = ImmutableReportGridMemberUpdateRoleCommand
        .fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.userId());
    assertEquals(ReportGridMemberRole.VIEWER, actualFromJsonResult.role());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableReportGridMemberUpdateRoleCommand.Json}
   *   <li>
   * {@link ImmutableReportGridMemberUpdateRoleCommand.Json#setRole(ReportGridMemberRole)}
   *   <li>{@link ImmutableReportGridMemberUpdateRoleCommand.Json#setUserId(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableReportGridMemberUpdateRoleCommand.Json actualJson = new ImmutableReportGridMemberUpdateRoleCommand.Json();
    actualJson.setRole(ReportGridMemberRole.VIEWER);
    actualJson.setUserId("42");

    // Assert
    assertEquals("42", actualJson.userId);
    assertEquals(ReportGridMemberRole.VIEWER, actualJson.role);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridMemberUpdateRoleCommand.Json#role()}
   */
  @Test
  void testJsonRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridMemberUpdateRoleCommand.Json()).role());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridMemberUpdateRoleCommand.Json#userId()}
   */
  @Test
  void testJsonUserId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridMemberUpdateRoleCommand.Json()).userId());
  }
}
