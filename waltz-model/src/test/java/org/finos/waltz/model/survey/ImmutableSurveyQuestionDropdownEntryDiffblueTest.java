package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.IdProvider;
import org.junit.jupiter.api.Test;

class ImmutableSurveyQuestionDropdownEntryDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionDropdownEntry.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry.Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableSurveyQuestionDropdownEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionDropdownEntry.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry.Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableSurveyQuestionDropdownEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionDropdownEntry.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry.Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionDropdownEntry.Builder#from(SurveyQuestionDropdownEntry)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry.Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();
    SurveyQuestionDropdownEntry instance = mock(SurveyQuestionDropdownEntry.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.questionId()).thenReturn(ofResult2);
    when(instance.value()).thenReturn("42");

    // Act
    ImmutableSurveyQuestionDropdownEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).position();
    verify(instance).questionId();
    verify(instance).value();
    ImmutableSurveyQuestionDropdownEntry buildResult = builderResult.build();
    assertEquals("42", buildResult.value());
    assertEquals(1, buildResult.position());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionDropdownEntry.Builder#from(SurveyQuestionDropdownEntry)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry.Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();
    SurveyQuestionDropdownEntry instance = mock(SurveyQuestionDropdownEntry.class);
    when(instance.questionId()).thenThrow(new IllegalStateException("instance"));
    when(instance.value()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).questionId();
    verify(instance).value();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionDropdownEntry.Builder#from(SurveyQuestionDropdownEntry)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry.Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();
    SurveyQuestionDropdownEntry instance = mock(SurveyQuestionDropdownEntry.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.questionId()).thenReturn(ofResult);
    when(instance.value()).thenReturn("42");

    // Act
    ImmutableSurveyQuestionDropdownEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).position();
    verify(instance).questionId();
    verify(instance).value();
    ImmutableSurveyQuestionDropdownEntry buildResult = builderResult.build();
    assertEquals("42", buildResult.value());
    assertEquals(1, buildResult.position());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionDropdownEntry.Builder#from(SurveyQuestionDropdownEntry)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry.Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();
    SurveyQuestionDropdownEntry instance = mock(SurveyQuestionDropdownEntry.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.questionId()).thenReturn(emptyResult);
    when(instance.value()).thenReturn("42");

    // Act
    ImmutableSurveyQuestionDropdownEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).position();
    verify(instance).questionId();
    verify(instance).value();
    ImmutableSurveyQuestionDropdownEntry buildResult = builderResult.build();
    assertEquals("42", buildResult.value());
    assertEquals(1, buildResult.position());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionDropdownEntry.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry.Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionDropdownEntry.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry.Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionDropdownEntry.Builder#position(int)}
   */
  @Test
  void testBuilderPosition() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry.Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionDropdownEntry.Builder#questionId(long)}
   */
  @Test
  void testBuilderQuestionId() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry.Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.questionId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionDropdownEntry.Builder#questionId(Optional)}
   */
  @Test
  void testBuilderQuestionId2() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry.Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();
    Optional<Long> questionId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.questionId(questionId));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionDropdownEntry.Builder#value(String)}
   */
  @Test
  void testBuilderValue() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry.Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.value("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionDropdownEntry#copyOf(SurveyQuestionDropdownEntry)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyQuestionDropdownEntry instance = mock(SurveyQuestionDropdownEntry.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.questionId()).thenReturn(ofResult2);
    when(instance.value()).thenReturn("42");

    // Act
    ImmutableSurveyQuestionDropdownEntry actualCopyOfResult = ImmutableSurveyQuestionDropdownEntry.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).position();
    verify(instance).questionId();
    verify(instance).value();
    assertEquals("42", actualCopyOfResult.value());
    assertEquals(1, actualCopyOfResult.position());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionDropdownEntry#copyOf(SurveyQuestionDropdownEntry)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    SurveyQuestionDropdownEntry instance = mock(SurveyQuestionDropdownEntry.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.questionId()).thenReturn(ofResult);
    when(instance.value()).thenReturn("42");

    // Act
    ImmutableSurveyQuestionDropdownEntry actualCopyOfResult = ImmutableSurveyQuestionDropdownEntry.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).position();
    verify(instance).questionId();
    verify(instance).value();
    assertEquals("42", actualCopyOfResult.value());
    assertEquals(1, actualCopyOfResult.position());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionDropdownEntry#copyOf(SurveyQuestionDropdownEntry)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    SurveyQuestionDropdownEntry instance = mock(SurveyQuestionDropdownEntry.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.questionId()).thenReturn(emptyResult);
    when(instance.value()).thenReturn("42");

    // Act
    ImmutableSurveyQuestionDropdownEntry actualCopyOfResult = ImmutableSurveyQuestionDropdownEntry.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).position();
    verify(instance).questionId();
    verify(instance).value();
    assertEquals("42", actualCopyOfResult.value());
    assertEquals(1, actualCopyOfResult.position());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestionDropdownEntry.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestionDropdownEntry.Json()).id());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSurveyQuestionDropdownEntry.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSurveyQuestionDropdownEntry.Json actualJson = new ImmutableSurveyQuestionDropdownEntry.Json();

    // Assert
    assertNull(actualJson.value);
    assertEquals(0, actualJson.position);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.questionId.isPresent());
    assertFalse(actualJson.positionIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionDropdownEntry.Json#position()}
   */
  @Test
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyQuestionDropdownEntry.Json()).position());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionDropdownEntry.Json#questionId()}
   */
  @Test
  void testJsonQuestionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyQuestionDropdownEntry.Json()).questionId());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionDropdownEntry.Json#setPosition(int)}
   */
  @Test
  void testJsonSetPosition() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry.Json json = new ImmutableSurveyQuestionDropdownEntry.Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestionDropdownEntry.Json#value()}
   */
  @Test
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestionDropdownEntry.Json()).value());
  }
}
