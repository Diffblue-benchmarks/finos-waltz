package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableUpdateRatingCodeCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableUpdateRatingCodeCommand.Builder#from(UpdateRatingCodeCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableUpdateRatingCodeCommand.Builder builderResult = ImmutableUpdateRatingCodeCommand.builder();
    UpdateRatingCodeCommand instance = mock(UpdateRatingCodeCommand.class);
    when(instance.newCode()).thenReturn("New Code");

    // Act
    ImmutableUpdateRatingCodeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).newCode();
    assertEquals("New Code", actualFromResult.build().newCode());
    assertEquals("New Code", builderResult.build().newCode());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRatingCodeCommand.Builder#newCode(String)}
   */
  @Test
  void testBuilderNewCode() {
    // Arrange
    ImmutableUpdateRatingCodeCommand.Builder builderResult = ImmutableUpdateRatingCodeCommand.builder();

    // Act
    ImmutableUpdateRatingCodeCommand.Builder actualNewCodeResult = builderResult.newCode("New Code");

    // Assert
    assertEquals("New Code", actualNewCodeResult.build().newCode());
    assertEquals("New Code", builderResult.build().newCode());
    assertSame(builderResult, actualNewCodeResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRatingCodeCommand#copyOf(UpdateRatingCodeCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    UpdateRatingCodeCommand instance = mock(UpdateRatingCodeCommand.class);
    when(instance.newCode()).thenReturn("New Code");

    // Act
    ImmutableUpdateRatingCodeCommand actualCopyOfResult = ImmutableUpdateRatingCodeCommand.copyOf(instance);

    // Assert
    verify(instance).newCode();
    assertEquals("New Code", actualCopyOfResult.newCode());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRatingCodeCommand#fromJson(ImmutableUpdateRatingCodeCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableUpdateRatingCodeCommand.Json json = new ImmutableUpdateRatingCodeCommand.Json();
    json.setNewCode("Json");

    // Act and Assert
    assertEquals("Json", ImmutableUpdateRatingCodeCommand.fromJson(json).newCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableUpdateRatingCodeCommand.Json}
   *   <li>{@link ImmutableUpdateRatingCodeCommand.Json#setNewCode(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableUpdateRatingCodeCommand.Json actualJson = new ImmutableUpdateRatingCodeCommand.Json();
    actualJson.setNewCode("New Code");

    // Assert
    assertEquals("New Code", actualJson.newCode);
  }

  /**
   * Method under test: {@link ImmutableUpdateRatingCodeCommand.Json#newCode()}
   */
  @Test
  void testJsonNewCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUpdateRatingCodeCommand.Json()).newCode());
  }
}
