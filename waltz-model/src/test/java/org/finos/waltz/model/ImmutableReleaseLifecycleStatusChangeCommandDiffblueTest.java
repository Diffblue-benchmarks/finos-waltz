package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableReleaseLifecycleStatusChangeCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableReleaseLifecycleStatusChangeCommand.Builder#from(ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableReleaseLifecycleStatusChangeCommand.Builder builderResult = ImmutableReleaseLifecycleStatusChangeCommand
        .builder();
    ReleaseLifecycleStatusChangeCommand instance = mock(ReleaseLifecycleStatusChangeCommand.class);
    when(instance.newStatus()).thenReturn(ReleaseLifecycleStatus.DRAFT);

    // Act
    ImmutableReleaseLifecycleStatusChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).newStatus();
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualFromResult.build().newStatus());
    assertEquals(ReleaseLifecycleStatus.DRAFT, builderResult.build().newStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReleaseLifecycleStatusChangeCommand.Builder#newStatus(ReleaseLifecycleStatus)}
   */
  @Test
  void testBuilderNewStatus() {
    // Arrange
    ImmutableReleaseLifecycleStatusChangeCommand.Builder builderResult = ImmutableReleaseLifecycleStatusChangeCommand
        .builder();

    // Act
    ImmutableReleaseLifecycleStatusChangeCommand.Builder actualNewStatusResult = builderResult
        .newStatus(ReleaseLifecycleStatus.DRAFT);

    // Assert
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualNewStatusResult.build().newStatus());
    assertEquals(ReleaseLifecycleStatus.DRAFT, builderResult.build().newStatus());
    assertSame(builderResult, actualNewStatusResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReleaseLifecycleStatusChangeCommand#copyOf(ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ReleaseLifecycleStatusChangeCommand instance = mock(ReleaseLifecycleStatusChangeCommand.class);
    when(instance.newStatus()).thenReturn(ReleaseLifecycleStatus.DRAFT);

    // Act
    ImmutableReleaseLifecycleStatusChangeCommand actualCopyOfResult = ImmutableReleaseLifecycleStatusChangeCommand
        .copyOf(instance);

    // Assert
    verify(instance).newStatus();
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualCopyOfResult.newStatus());
  }

  /**
   * Method under test:
   * {@link ImmutableReleaseLifecycleStatusChangeCommand#fromJson(ImmutableReleaseLifecycleStatusChangeCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableReleaseLifecycleStatusChangeCommand.Json json = new ImmutableReleaseLifecycleStatusChangeCommand.Json();
    json.setNewStatus(ReleaseLifecycleStatus.DRAFT);

    // Act and Assert
    assertEquals(ReleaseLifecycleStatus.DRAFT, ImmutableReleaseLifecycleStatusChangeCommand.fromJson(json).newStatus());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableReleaseLifecycleStatusChangeCommand.Json}
   *   <li>
   * {@link ImmutableReleaseLifecycleStatusChangeCommand.Json#setNewStatus(ReleaseLifecycleStatus)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableReleaseLifecycleStatusChangeCommand.Json actualJson = new ImmutableReleaseLifecycleStatusChangeCommand.Json();
    actualJson.setNewStatus(ReleaseLifecycleStatus.DRAFT);

    // Assert
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualJson.newStatus);
  }

  /**
   * Method under test:
   * {@link ImmutableReleaseLifecycleStatusChangeCommand.Json#newStatus()}
   */
  @Test
  void testJsonNewStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReleaseLifecycleStatusChangeCommand.Json()).newStatus());
  }
}
