package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableUpdateDescriptionCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableUpdateDescriptionCommand.Builder#build()}
   *   <li>{@link ImmutableUpdateDescriptionCommand.Builder#newDescription(String)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertEquals("New Description",
        ImmutableUpdateDescriptionCommand.builder().newDescription("New Description").build().newDescription());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDescriptionCommand.Builder#from(UpdateDescriptionCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableUpdateDescriptionCommand.Builder builderResult = ImmutableUpdateDescriptionCommand.builder();
    UpdateDescriptionCommand instance = mock(UpdateDescriptionCommand.class);
    when(instance.newDescription()).thenReturn("New Description");

    // Act
    ImmutableUpdateDescriptionCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).newDescription();
    assertEquals("New Description", actualFromResult.build().newDescription());
    assertEquals("New Description", builderResult.build().newDescription());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDescriptionCommand.Builder#from(UpdateDescriptionCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableUpdateDescriptionCommand.Builder builderResult = ImmutableUpdateDescriptionCommand.builder();
    UpdateDescriptionCommand instance = mock(UpdateDescriptionCommand.class);
    when(instance.newDescription()).thenReturn(null);

    // Act
    ImmutableUpdateDescriptionCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).newDescription();
    assertNull(actualFromResult.build().newDescription());
    assertNull(builderResult.build().newDescription());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDescriptionCommand#copyOf(UpdateDescriptionCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    UpdateDescriptionCommand instance = mock(UpdateDescriptionCommand.class);
    when(instance.newDescription()).thenReturn("New Description");

    // Act
    ImmutableUpdateDescriptionCommand actualCopyOfResult = ImmutableUpdateDescriptionCommand.copyOf(instance);

    // Assert
    verify(instance).newDescription();
    assertEquals("New Description", actualCopyOfResult.newDescription());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDescriptionCommand#fromJson(ImmutableUpdateDescriptionCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange, Act and Assert
    assertNull(
        ImmutableUpdateDescriptionCommand.fromJson(new ImmutableUpdateDescriptionCommand.Json()).newDescription());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDescriptionCommand#fromJson(ImmutableUpdateDescriptionCommand.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableUpdateDescriptionCommand.Json json = new ImmutableUpdateDescriptionCommand.Json();
    json.setNewDescription("Json");

    // Act and Assert
    assertEquals("Json", ImmutableUpdateDescriptionCommand.fromJson(json).newDescription());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableUpdateDescriptionCommand.Json}
   *   <li>{@link ImmutableUpdateDescriptionCommand.Json#setNewDescription(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableUpdateDescriptionCommand.Json actualJson = new ImmutableUpdateDescriptionCommand.Json();
    actualJson.setNewDescription("New Description");

    // Assert
    assertEquals("New Description", actualJson.newDescription);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDescriptionCommand.Json#newDescription()}
   */
  @Test
  void testJsonNewDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableUpdateDescriptionCommand.Json()).newDescription());
  }
}
