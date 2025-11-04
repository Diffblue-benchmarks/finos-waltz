package org.finos.waltz.model.logical_data_element;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableLogicalDataElementChangeCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableLogicalDataElementChangeCommand.Builder#from(LogicalDataElementChangeCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableLogicalDataElementChangeCommand.Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    LogicalDataElementChangeCommand instance = mock(LogicalDataElementChangeCommand.class);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.newLogicalDataElement()).thenReturn(ofResult);

    // Act
    ImmutableLogicalDataElementChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).newLogicalDataElement();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElementChangeCommand.Builder#from(LogicalDataElementChangeCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableLogicalDataElementChangeCommand.Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    LogicalDataElementChangeCommand instance = mock(LogicalDataElementChangeCommand.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(instance.newLogicalDataElement()).thenReturn(emptyResult);

    // Act
    ImmutableLogicalDataElementChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).newLogicalDataElement();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElementChangeCommand#copyOf(LogicalDataElementChangeCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    LogicalDataElementChangeCommand instance = mock(LogicalDataElementChangeCommand.class);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.newLogicalDataElement()).thenReturn(ofResult);

    // Act
    ImmutableLogicalDataElementChangeCommand actualCopyOfResult = ImmutableLogicalDataElementChangeCommand
        .copyOf(instance);

    // Assert
    verify(instance).newLogicalDataElement();
    assertTrue(actualCopyOfResult.newLogicalDataElement().isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElementChangeCommand#copyOf(LogicalDataElementChangeCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    LogicalDataElementChangeCommand instance = mock(LogicalDataElementChangeCommand.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(instance.newLogicalDataElement()).thenReturn(emptyResult);

    // Act
    ImmutableLogicalDataElementChangeCommand actualCopyOfResult = ImmutableLogicalDataElementChangeCommand
        .copyOf(instance);

    // Assert
    verify(instance).newLogicalDataElement();
    Optional<EntityReference> newLogicalDataElementResult = actualCopyOfResult.newLogicalDataElement();
    assertFalse(newLogicalDataElementResult.isPresent());
    assertSame(emptyResult, newLogicalDataElementResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElementChangeCommand#fromJson(ImmutableLogicalDataElementChangeCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableLogicalDataElementChangeCommand.Json json = new ImmutableLogicalDataElementChangeCommand.Json();

    // Act and Assert
    Optional<EntityReference> newLogicalDataElementResult = ImmutableLogicalDataElementChangeCommand.fromJson(json)
        .newLogicalDataElement();
    assertFalse(newLogicalDataElementResult.isPresent());
    assertSame(json.newLogicalDataElement, newLogicalDataElementResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElementChangeCommand#fromJson(ImmutableLogicalDataElementChangeCommand.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableLogicalDataElementChangeCommand.Json json = new ImmutableLogicalDataElementChangeCommand.Json();
    json.setNewLogicalDataElement(null);

    // Act and Assert
    assertFalse(ImmutableLogicalDataElementChangeCommand.fromJson(json).newLogicalDataElement().isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElementChangeCommand#fromJson(ImmutableLogicalDataElementChangeCommand.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ImmutableLogicalDataElementChangeCommand.Json json = new ImmutableLogicalDataElementChangeCommand.Json();
    Optional<EntityReference> newLogicalDataElement = Optional.of(mock(EntityReference.class));
    json.setNewLogicalDataElement(newLogicalDataElement);

    // Act and Assert
    assertTrue(ImmutableLogicalDataElementChangeCommand.fromJson(json).newLogicalDataElement().isPresent());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableLogicalDataElementChangeCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange, Act and Assert
    assertFalse((new ImmutableLogicalDataElementChangeCommand.Json()).newLogicalDataElement.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElementChangeCommand.Json#newLogicalDataElement()}
   */
  @Test
  void testJsonNewLogicalDataElement() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLogicalDataElementChangeCommand.Json()).newLogicalDataElement());
  }
}
