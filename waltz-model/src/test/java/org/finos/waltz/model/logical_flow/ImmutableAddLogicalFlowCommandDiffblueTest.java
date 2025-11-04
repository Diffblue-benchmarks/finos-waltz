package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableAddLogicalFlowCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAddLogicalFlowCommand.Builder#from(AddLogicalFlowCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAddLogicalFlowCommand.Builder builderResult = ImmutableAddLogicalFlowCommand.builder();
    AddLogicalFlowCommand instance = mock(AddLogicalFlowCommand.class);
    when(instance.target()).thenThrow(new IllegalStateException("instance"));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).source();
    verify(instance).target();
  }

  /**
   * Method under test:
   * {@link ImmutableAddLogicalFlowCommand.Builder#from(AddLogicalFlowCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAddLogicalFlowCommand.Builder builderResult = ImmutableAddLogicalFlowCommand.builder();
    AddLogicalFlowCommand instance = mock(AddLogicalFlowCommand.class);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableAddLogicalFlowCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).source();
    verify(instance).target();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAddLogicalFlowCommand.Builder#source(EntityReference)}
   */
  @Test
  void testBuilderSource() {
    // Arrange
    ImmutableAddLogicalFlowCommand.Builder builderResult = ImmutableAddLogicalFlowCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.source(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableAddLogicalFlowCommand.Builder#target(EntityReference)}
   */
  @Test
  void testBuilderTarget() {
    // Arrange
    ImmutableAddLogicalFlowCommand.Builder builderResult = ImmutableAddLogicalFlowCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.target(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableAddLogicalFlowCommand#copyOf(AddLogicalFlowCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AddLogicalFlowCommand instance = mock(AddLogicalFlowCommand.class);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableAddLogicalFlowCommand.copyOf(instance);

    // Assert
    verify(instance).source();
    verify(instance).target();
  }

  /**
   * Method under test:
   * {@link ImmutableAddLogicalFlowCommand#fromJson(ImmutableAddLogicalFlowCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAddLogicalFlowCommand.Json json = new ImmutableAddLogicalFlowCommand.Json();
    json.setTarget(mock(EntityReference.class));
    json.setSource(mock(EntityReference.class));

    // Act
    ImmutableAddLogicalFlowCommand actualFromJsonResult = ImmutableAddLogicalFlowCommand.fromJson(json);

    // Assert
    EntityReference expectedSourceResult = json.source;
    assertSame(expectedSourceResult, actualFromJsonResult.source());
    EntityReference expectedTargetResult = json.target;
    assertSame(expectedTargetResult, actualFromJsonResult.target());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableAddLogicalFlowCommand.Json}
   *   <li>{@link ImmutableAddLogicalFlowCommand.Json#setSource(EntityReference)}
   *   <li>{@link ImmutableAddLogicalFlowCommand.Json#setTarget(EntityReference)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableAddLogicalFlowCommand.Json actualJson = new ImmutableAddLogicalFlowCommand.Json();
    actualJson.setSource(null);
    actualJson.setTarget(null);

    // Assert
    assertNull(actualJson.source);
    assertNull(actualJson.target);
  }

  /**
   * Method under test: {@link ImmutableAddLogicalFlowCommand.Json#source()}
   */
  @Test
  void testJsonSource() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAddLogicalFlowCommand.Json()).source());
  }

  /**
   * Method under test: {@link ImmutableAddLogicalFlowCommand.Json#target()}
   */
  @Test
  void testJsonTarget() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAddLogicalFlowCommand.Json()).target());
  }
}
