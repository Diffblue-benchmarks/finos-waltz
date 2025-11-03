package org.finos.waltz.model.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.assessment_rating.ImmutableUpdateRatingCommand.Builder;
import org.finos.waltz.model.assessment_rating.ImmutableUpdateRatingCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUpdateRatingCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#from(UpdateRatingCommand)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then builder build newRatingId longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UpdateRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateRatingCommand); given one; then builder build newRatingId longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UpdateRatingCommand)"})
  void testBuilderFrom_givenOne_thenBuilderBuildNewRatingIdLongValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableUpdateRatingCommand.builder();
    UpdateRatingCommand instance = mock(UpdateRatingCommand.class);
    when(instance.newRatingId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).newRatingId();
    assertEquals(1L, builderResult.build().newRatingId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#newRatingId(Long)}.
   * <p>
   * Method under test: {@link Builder#newRatingId(Long)}
   */
  @Test
  @DisplayName("Test Builder newRatingId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.newRatingId(Long)"})
  void testBuilderNewRatingId() {
    // Arrange
    Builder builderResult = ImmutableUpdateRatingCommand.builder();

    // Act
    Builder actualNewRatingIdResult = builderResult.newRatingId(1L);

    // Assert
    assertEquals(1L, builderResult.build().newRatingId().longValue());
    assertSame(builderResult, actualNewRatingIdResult);
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setNewRatingId(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setNewRatingId(Long)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setNewRatingId(1L);

    // Assert
    assertEquals(1L, actualJson.newRatingId.longValue());
  }

  /**
   * Test Json {@link Json#newRatingId()}.
   * <p>
   * Method under test: {@link Json#newRatingId()}
   */
  @Test
  @DisplayName("Test Json newRatingId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.newRatingId()"})
  void testJsonNewRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).newRatingId());
  }
}
