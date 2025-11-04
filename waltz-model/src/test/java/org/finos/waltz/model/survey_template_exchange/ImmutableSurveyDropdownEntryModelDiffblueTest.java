package org.finos.waltz.model.survey_template_exchange;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableSurveyDropdownEntryModelDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSurveyDropdownEntryModel.Builder#from(SurveyDropdownEntryModel)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyDropdownEntryModel.Builder builderResult = ImmutableSurveyDropdownEntryModel.builder();
    SurveyDropdownEntryModel instance = mock(SurveyDropdownEntryModel.class);
    when(instance.position()).thenReturn(1);
    when(instance.value()).thenReturn("42");

    // Act
    ImmutableSurveyDropdownEntryModel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).position();
    verify(instance).value();
    ImmutableSurveyDropdownEntryModel buildResult = builderResult.build();
    assertEquals("42", buildResult.value());
    assertEquals(1, buildResult.position());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyDropdownEntryModel.Builder#position(int)}
   */
  @Test
  void testBuilderPosition() {
    // Arrange
    ImmutableSurveyDropdownEntryModel.Builder builderResult = ImmutableSurveyDropdownEntryModel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyDropdownEntryModel.Builder#value(String)}
   */
  @Test
  void testBuilderValue() {
    // Arrange
    ImmutableSurveyDropdownEntryModel.Builder builderResult = ImmutableSurveyDropdownEntryModel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.value("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyDropdownEntryModel#copyOf(SurveyDropdownEntryModel)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyDropdownEntryModel instance = mock(SurveyDropdownEntryModel.class);
    when(instance.position()).thenReturn(1);
    when(instance.value()).thenReturn("42");

    // Act
    ImmutableSurveyDropdownEntryModel actualCopyOfResult = ImmutableSurveyDropdownEntryModel.copyOf(instance);

    // Assert
    verify(instance).position();
    verify(instance).value();
    assertEquals("42", actualCopyOfResult.value());
    assertEquals(1, actualCopyOfResult.position());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableSurveyDropdownEntryModel.Json}
   *   <li>{@link ImmutableSurveyDropdownEntryModel.Json#setValue(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableSurveyDropdownEntryModel.Json actualJson = new ImmutableSurveyDropdownEntryModel.Json();
    actualJson.setValue("42");

    // Assert
    assertEquals("42", actualJson.value);
    assertEquals(0, actualJson.position);
    assertFalse(actualJson.positionIsSet);
  }

  /**
   * Method under test: {@link ImmutableSurveyDropdownEntryModel.Json#position()}
   */
  @Test
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyDropdownEntryModel.Json()).position());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyDropdownEntryModel.Json#setPosition(int)}
   */
  @Test
  void testJsonSetPosition() {
    // Arrange
    ImmutableSurveyDropdownEntryModel.Json json = new ImmutableSurveyDropdownEntryModel.Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Method under test: {@link ImmutableSurveyDropdownEntryModel.Json#value()}
   */
  @Test
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyDropdownEntryModel.Json()).value());
  }
}
