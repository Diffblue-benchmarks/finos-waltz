package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableUpdateNameCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableUpdateNameCommand.Builder#from(UpdateNameCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableUpdateNameCommand.Builder builderResult = ImmutableUpdateNameCommand.builder();
    UpdateNameCommand instance = mock(UpdateNameCommand.class);
    when(instance.newName()).thenReturn("New Name");

    // Act
    ImmutableUpdateNameCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).newName();
    assertEquals("New Name", actualFromResult.build().newName());
    assertEquals("New Name", builderResult.build().newName());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableUpdateNameCommand.Builder#newName(String)}
   */
  @Test
  void testBuilderNewName() {
    // Arrange
    ImmutableUpdateNameCommand.Builder builderResult = ImmutableUpdateNameCommand.builder();

    // Act
    ImmutableUpdateNameCommand.Builder actualNewNameResult = builderResult.newName("New Name");

    // Assert
    assertEquals("New Name", actualNewNameResult.build().newName());
    assertEquals("New Name", builderResult.build().newName());
    assertSame(builderResult, actualNewNameResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateNameCommand#copyOf(UpdateNameCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    UpdateNameCommand instance = mock(UpdateNameCommand.class);
    when(instance.newName()).thenReturn("New Name");

    // Act
    ImmutableUpdateNameCommand actualCopyOfResult = ImmutableUpdateNameCommand.copyOf(instance);

    // Assert
    verify(instance).newName();
    assertEquals("New Name", actualCopyOfResult.newName());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateNameCommand#fromJson(ImmutableUpdateNameCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableUpdateNameCommand.Json json = new ImmutableUpdateNameCommand.Json();
    json.setNewName("Json");

    // Act and Assert
    assertEquals("Json", ImmutableUpdateNameCommand.fromJson(json).newName());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableUpdateNameCommand.Json}
   *   <li>{@link ImmutableUpdateNameCommand.Json#setNewName(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableUpdateNameCommand.Json actualJson = new ImmutableUpdateNameCommand.Json();
    actualJson.setNewName("New Name");

    // Assert
    assertEquals("New Name", actualJson.newName);
  }

  /**
   * Method under test: {@link ImmutableUpdateNameCommand.Json#newName()}
   */
  @Test
  void testJsonNewName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUpdateNameCommand.Json()).newName());
  }
}
