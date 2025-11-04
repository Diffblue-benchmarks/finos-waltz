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

class ImmutableReportGridMemberDeleteCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableReportGridMemberDeleteCommand.Builder#from(ReportGridMemberDeleteCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableReportGridMemberDeleteCommand.Builder builderResult = ImmutableReportGridMemberDeleteCommand.builder();
    ReportGridMemberDeleteCommand instance = mock(ReportGridMemberDeleteCommand.class);
    when(instance.userId()).thenReturn("42");
    when(instance.gridId()).thenReturn(1L);

    // Act
    ImmutableReportGridMemberDeleteCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).gridId();
    verify(instance).userId();
    ImmutableReportGridMemberDeleteCommand buildResult = builderResult.build();
    assertEquals("42", buildResult.userId());
    assertEquals(1L, buildResult.gridId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridMemberDeleteCommand.Builder#gridId(long)}
   */
  @Test
  void testBuilderGridId() {
    // Arrange
    ImmutableReportGridMemberDeleteCommand.Builder builderResult = ImmutableReportGridMemberDeleteCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.gridId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridMemberDeleteCommand.Builder#userId(String)}
   */
  @Test
  void testBuilderUserId() {
    // Arrange
    ImmutableReportGridMemberDeleteCommand.Builder builderResult = ImmutableReportGridMemberDeleteCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridMemberDeleteCommand#copyOf(ReportGridMemberDeleteCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ReportGridMemberDeleteCommand instance = mock(ReportGridMemberDeleteCommand.class);
    when(instance.userId()).thenReturn("42");
    when(instance.gridId()).thenReturn(1L);

    // Act
    ImmutableReportGridMemberDeleteCommand actualCopyOfResult = ImmutableReportGridMemberDeleteCommand.copyOf(instance);

    // Assert
    verify(instance).gridId();
    verify(instance).userId();
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals(1L, actualCopyOfResult.gridId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableReportGridMemberDeleteCommand.Json}
   *   <li>{@link ImmutableReportGridMemberDeleteCommand.Json#setUserId(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableReportGridMemberDeleteCommand.Json actualJson = new ImmutableReportGridMemberDeleteCommand.Json();
    actualJson.setUserId("42");

    // Assert
    assertEquals("42", actualJson.userId);
    assertEquals(0L, actualJson.gridId);
    assertFalse(actualJson.gridIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridMemberDeleteCommand.Json#gridId()}
   */
  @Test
  void testJsonGridId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridMemberDeleteCommand.Json()).gridId());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridMemberDeleteCommand.Json#setGridId(long)}
   */
  @Test
  void testJsonSetGridId() {
    // Arrange
    ImmutableReportGridMemberDeleteCommand.Json json = new ImmutableReportGridMemberDeleteCommand.Json();

    // Act
    json.setGridId(1L);

    // Assert
    assertEquals(1L, json.gridId);
    assertTrue(json.gridIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridMemberDeleteCommand.Json#userId()}
   */
  @Test
  void testJsonUserId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridMemberDeleteCommand.Json()).userId());
  }
}
