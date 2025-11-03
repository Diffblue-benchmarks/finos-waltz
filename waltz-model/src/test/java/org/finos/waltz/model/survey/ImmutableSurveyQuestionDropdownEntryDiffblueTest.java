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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.survey.ImmutableSurveyQuestionDropdownEntry.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyQuestionDropdownEntry.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyQuestionDropdownEntryDiffblueTest {
  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionDropdownEntry)} with {@code SurveyQuestionDropdownEntry}.
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionDropdownEntry)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionDropdownEntry) with 'SurveyQuestionDropdownEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionDropdownEntry)"})
  void testBuilderFromWithSurveyQuestionDropdownEntry() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();
    SurveyQuestionDropdownEntry instance = mock(SurveyQuestionDropdownEntry.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.questionId()).thenReturn(ofResult2);
    when(instance.value()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(SurveyQuestionDropdownEntry)} with {@code SurveyQuestionDropdownEntry}.
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionDropdownEntry)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionDropdownEntry) with 'SurveyQuestionDropdownEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionDropdownEntry)"})
  void testBuilderFromWithSurveyQuestionDropdownEntry2() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();
    SurveyQuestionDropdownEntry instance = mock(SurveyQuestionDropdownEntry.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.questionId()).thenReturn(ofResult);
    when(instance.value()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(SurveyQuestionDropdownEntry)} with {@code SurveyQuestionDropdownEntry}.
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionDropdownEntry)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionDropdownEntry) with 'SurveyQuestionDropdownEntry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionDropdownEntry)"})
  void testBuilderFromWithSurveyQuestionDropdownEntry3() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();
    SurveyQuestionDropdownEntry instance = mock(SurveyQuestionDropdownEntry.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.questionId()).thenReturn(emptyResult);
    when(instance.value()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(SurveyQuestionDropdownEntry)} with {@code SurveyQuestionDropdownEntry}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionDropdownEntry)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionDropdownEntry) with 'SurveyQuestionDropdownEntry'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionDropdownEntry)"})
  void testBuilderFromWithSurveyQuestionDropdownEntry_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();
    SurveyQuestionDropdownEntry instance = mock(SurveyQuestionDropdownEntry.class);
    when(instance.questionId()).thenThrow(new IllegalStateException("instance"));
    when(instance.value()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).questionId();
    verify(instance).value();
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
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
    Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Test Builder {@link Builder#questionId(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#questionId(long)}
   */
  @Test
  @DisplayName("Test Builder questionId(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.questionId(long)"})
  void testBuilderQuestionIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.questionId(1L));
  }

  /**
   * Test Builder {@link Builder#questionId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#questionId(Optional)}
   */
  @Test
  @DisplayName("Test Builder questionId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.questionId(Optional)"})
  void testBuilderQuestionIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();
    Optional<Long> questionId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.questionId(questionId));
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
    Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.value("42"));
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.value);
    assertEquals(0, actualJson.position);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.questionId.isPresent());
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
   * Test Json {@link Json#questionId()}.
   * <p>
   * Method under test: {@link Json#questionId()}
   */
  @Test
  @DisplayName("Test Json questionId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.questionId()"})
  void testJsonQuestionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).questionId());
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
