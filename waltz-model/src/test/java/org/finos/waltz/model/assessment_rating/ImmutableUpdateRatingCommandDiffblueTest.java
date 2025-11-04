package org.finos.waltz.model.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableUpdateRatingCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableUpdateRatingCommand.Builder#from(UpdateRatingCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableUpdateRatingCommand.Builder builderResult = ImmutableUpdateRatingCommand.builder();
    UpdateRatingCommand instance = mock(UpdateRatingCommand.class);
    when(instance.newRatingId()).thenReturn(1L);

    // Act
    ImmutableUpdateRatingCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).newRatingId();
    assertEquals(1L, actualFromResult.build().newRatingId().longValue());
    assertEquals(1L, builderResult.build().newRatingId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRatingCommand.Builder#newRatingId(Long)}
   */
  @Test
  void testBuilderNewRatingId() {
    // Arrange
    ImmutableUpdateRatingCommand.Builder builderResult = ImmutableUpdateRatingCommand.builder();

    // Act
    ImmutableUpdateRatingCommand.Builder actualNewRatingIdResult = builderResult.newRatingId(1L);

    // Assert
    assertEquals(1L, actualNewRatingIdResult.build().newRatingId().longValue());
    assertEquals(1L, builderResult.build().newRatingId().longValue());
    assertSame(builderResult, actualNewRatingIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRatingCommand#copyOf(UpdateRatingCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    UpdateRatingCommand instance = mock(UpdateRatingCommand.class);
    when(instance.newRatingId()).thenReturn(1L);

    // Act
    ImmutableUpdateRatingCommand actualCopyOfResult = ImmutableUpdateRatingCommand.copyOf(instance);

    // Assert
    verify(instance).newRatingId();
    assertEquals(1L, actualCopyOfResult.newRatingId().longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRatingCommand#fromJson(ImmutableUpdateRatingCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableUpdateRatingCommand.Json json = new ImmutableUpdateRatingCommand.Json();
    json.setNewRatingId(1L);

    // Act and Assert
    assertEquals(1L, ImmutableUpdateRatingCommand.fromJson(json).newRatingId().longValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableUpdateRatingCommand.Json}
   *   <li>{@link ImmutableUpdateRatingCommand.Json#setNewRatingId(Long)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableUpdateRatingCommand.Json actualJson = new ImmutableUpdateRatingCommand.Json();
    actualJson.setNewRatingId(1L);

    // Assert
    assertEquals(1L, actualJson.newRatingId.longValue());
  }

  /**
   * Method under test: {@link ImmutableUpdateRatingCommand.Json#newRatingId()}
   */
  @Test
  void testJsonNewRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUpdateRatingCommand.Json()).newRatingId());
  }
}
