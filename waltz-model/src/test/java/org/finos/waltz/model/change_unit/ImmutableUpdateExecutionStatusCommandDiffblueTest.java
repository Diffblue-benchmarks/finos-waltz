package org.finos.waltz.model.change_unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.command.EntityChangeCommand;
import org.finos.waltz.model.command.FieldChange;
import org.junit.jupiter.api.Test;

class ImmutableUpdateExecutionStatusCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableUpdateExecutionStatusCommand.Builder#executionStatus(FieldChange)}
   */
  @Test
  void testBuilderExecutionStatus() {
    // Arrange
    ImmutableUpdateExecutionStatusCommand.Builder builderResult = ImmutableUpdateExecutionStatusCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.executionStatus(mock(FieldChange.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateExecutionStatusCommand.Builder#from(UpdateExecutionStatusCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableUpdateExecutionStatusCommand.Builder builderResult = ImmutableUpdateExecutionStatusCommand.builder();
    UpdateExecutionStatusCommand instance = mock(UpdateExecutionStatusCommand.class);
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.lastUpdate()).thenReturn(ofResult);
    when(instance.id()).thenReturn(1L);
    when(instance.executionStatus()).thenReturn(mock(FieldChange.class));

    // Act
    ImmutableUpdateExecutionStatusCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).executionStatus();
    verify(instance).id();
    verify(instance).lastUpdate();
    assertEquals(1L, actualFromResult.build().id());
    assertEquals(1L, builderResult.build().id());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateExecutionStatusCommand.Builder#from(EntityChangeCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableUpdateExecutionStatusCommand.Builder builderResult = ImmutableUpdateExecutionStatusCommand.builder();
    EntityChangeCommand instance = mock(EntityChangeCommand.class);
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.lastUpdate()).thenReturn(ofResult);
    when(instance.id()).thenReturn(1L);

    // Act
    ImmutableUpdateExecutionStatusCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdate();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateExecutionStatusCommand.Builder#from(EntityChangeCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableUpdateExecutionStatusCommand.Builder builderResult = ImmutableUpdateExecutionStatusCommand.builder();
    EntityChangeCommand instance = mock(EntityChangeCommand.class);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.lastUpdate()).thenReturn(emptyResult);
    when(instance.id()).thenReturn(1L);

    // Act
    ImmutableUpdateExecutionStatusCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdate();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateExecutionStatusCommand.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableUpdateExecutionStatusCommand.Builder builderResult = ImmutableUpdateExecutionStatusCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateExecutionStatusCommand.Builder#id(long)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableUpdateExecutionStatusCommand.Builder builderResult = ImmutableUpdateExecutionStatusCommand.builder();
    builderResult.lastUpdate(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateExecutionStatusCommand#copyOf(UpdateExecutionStatusCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    UpdateExecutionStatusCommand instance = mock(UpdateExecutionStatusCommand.class);
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.lastUpdate()).thenReturn(ofResult);
    when(instance.id()).thenReturn(1L);
    when(instance.executionStatus()).thenReturn(mock(FieldChange.class));

    // Act
    ImmutableUpdateExecutionStatusCommand actualCopyOfResult = ImmutableUpdateExecutionStatusCommand.copyOf(instance);

    // Assert
    verify(instance).executionStatus();
    verify(instance).id();
    verify(instance).lastUpdate();
    assertEquals(1L, actualCopyOfResult.id());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateExecutionStatusCommand.Json#executionStatus()}
   */
  @Test
  void testJsonExecutionStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableUpdateExecutionStatusCommand.Json()).executionStatus());
  }

  /**
   * Method under test: {@link ImmutableUpdateExecutionStatusCommand.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUpdateExecutionStatusCommand.Json()).id());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateExecutionStatusCommand.Json#lastUpdate()}
   */
  @Test
  void testJsonLastUpdate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableUpdateExecutionStatusCommand.Json()).lastUpdate());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableUpdateExecutionStatusCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableUpdateExecutionStatusCommand.Json actualJson = new ImmutableUpdateExecutionStatusCommand.Json();

    // Assert
    assertNull(actualJson.executionStatus);
    assertEquals(0L, actualJson.id);
    assertFalse(actualJson.lastUpdate.isPresent());
    assertFalse(actualJson.idIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateExecutionStatusCommand.Json#setId(long)}
   */
  @Test
  void testJsonSetId() {
    // Arrange
    ImmutableUpdateExecutionStatusCommand.Json json = new ImmutableUpdateExecutionStatusCommand.Json();

    // Act
    json.setId(1L);

    // Assert
    assertEquals(1L, json.id);
    assertTrue(json.idIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateExecutionStatusCommand.Json#setId(long)}
   */
  @Test
  void testJsonSetId2() {
    // Arrange
    ImmutableUpdateExecutionStatusCommand.Json json = new ImmutableUpdateExecutionStatusCommand.Json();
    Optional<UserTimestamp> lastUpdate = Optional.of(mock(UserTimestamp.class));
    json.setLastUpdate(lastUpdate);

    // Act
    json.setId(1L);

    // Assert
    assertEquals(1L, json.id);
    assertTrue(json.idIsSet);
  }
}
