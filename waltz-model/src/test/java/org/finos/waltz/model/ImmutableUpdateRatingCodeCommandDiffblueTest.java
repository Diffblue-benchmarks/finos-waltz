package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.ImmutableUpdateRatingCodeCommand.Builder;
import org.finos.waltz.model.ImmutableUpdateRatingCodeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUpdateRatingCodeCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#from(UpdateRatingCodeCommand)}.
   * <ul>
   *   <li>Given {@code New Code}.</li>
   *   <li>Then builder build newCode is {@code New Code}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UpdateRatingCodeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateRatingCodeCommand); given 'New Code'; then builder build newCode is 'New Code'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UpdateRatingCodeCommand)"})
  void testBuilderFrom_givenNewCode_thenBuilderBuildNewCodeIsNewCode() {
    // Arrange
    Builder builderResult = ImmutableUpdateRatingCodeCommand.builder();
    UpdateRatingCodeCommand instance = mock(UpdateRatingCodeCommand.class);
    when(instance.newCode()).thenReturn("New Code");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).newCode();
    assertEquals("New Code", builderResult.build().newCode());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#newCode(String)}.
   * <p>
   * Method under test: {@link Builder#newCode(String)}
   */
  @Test
  @DisplayName("Test Builder newCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.newCode(String)"})
  void testBuilderNewCode() {
    // Arrange
    Builder builderResult = ImmutableUpdateRatingCodeCommand.builder();

    // Act
    Builder actualNewCodeResult = builderResult.newCode("New Code");

    // Assert
    assertEquals("New Code", builderResult.build().newCode());
    assertSame(builderResult, actualNewCodeResult);
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setNewCode(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setNewCode(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setNewCode("New Code");

    // Assert
    assertEquals("New Code", actualJson.newCode);
  }

  /**
   * Test Json {@link Json#newCode()}.
   * <p>
   * Method under test: {@link Json#newCode()}
   */
  @Test
  @DisplayName("Test Json newCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.newCode()"})
  void testJsonNewCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).newCode());
  }
}
