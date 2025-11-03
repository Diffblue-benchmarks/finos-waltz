package org.finos.waltz.model.survey_template_exchange;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.survey_template_exchange.ImmutableSurveyDropdownEntryModel.Builder;
import org.finos.waltz.model.survey_template_exchange.ImmutableSurveyDropdownEntryModel.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyDropdownEntryModelDiffblueTest {
  /**
   * Test Builder {@link Builder#from(SurveyDropdownEntryModel)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then builder build value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyDropdownEntryModel)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyDropdownEntryModel); given one; then builder build value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyDropdownEntryModel)"})
  void testBuilderFrom_givenOne_thenBuilderBuildValueIs42() {
    // Arrange
    Builder builderResult = ImmutableSurveyDropdownEntryModel.builder();
    SurveyDropdownEntryModel instance = mock(SurveyDropdownEntryModel.class);
    when(instance.position()).thenReturn(1);
    when(instance.value()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).position();
    verify(instance).value();
    ImmutableSurveyDropdownEntryModel buildResult = builderResult.build();
    assertEquals("42", buildResult.value());
    assertEquals(1, buildResult.position());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#position(int)}.
   * <p>
   * Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPosition() {
    // Arrange
    Builder builderResult = ImmutableSurveyDropdownEntryModel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Test Builder {@link Builder#value(String)}.
   * <p>
   * Method under test: {@link Builder#value(String)}
   */
  @Test
  @DisplayName("Test Builder value(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.value(String)"})
  void testBuilderValue() {
    // Arrange
    Builder builderResult = ImmutableSurveyDropdownEntryModel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.value("42"));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setValue(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setValue(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setValue("42");

    // Assert
    assertEquals("42", actualJson.value);
    assertEquals(0, actualJson.position);
    assertFalse(actualJson.positionIsSet);
  }

  /**
   * Test Json {@link Json#position()}.
   * <p>
   * Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).position());
  }

  /**
   * Test Json {@link Json#setPosition(int)}.
   * <p>
   * Method under test: {@link Json#setPosition(int)}
   */
  @Test
  @DisplayName("Test Json setPosition(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setPosition(int)"})
  void testJsonSetPosition() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Test Json {@link Json#value()}.
   * <p>
   * Method under test: {@link Json#value()}
   */
  @Test
  @DisplayName("Test Json value()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.value()"})
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).value());
  }
}
