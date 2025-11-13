package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestionDropdownEntry Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult = ImmutableSurveyQuestionDropdownEntry.builder().id(1L);
    Optional<Long> id = Optional.of(42L);
    Builder actualQuestionIdResult = actualIdResult.id(id).position(1).questionId(1L);
    Optional<Long> questionId = Optional.of(42L);
    ImmutableSurveyQuestionDropdownEntry actualImmutableSurveyQuestionDropdownEntry =
        actualQuestionIdResult.questionId(questionId).value("42").build();

    // Assert
    assertEquals("42", actualImmutableSurveyQuestionDropdownEntry.value());
    assertEquals(1, actualImmutableSurveyQuestionDropdownEntry.position());
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();
    ImmutableSurveyQuestionDropdownEntry instance =
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableSurveyQuestionDropdownEntry actualImmutableSurveyQuestionDropdownEntry =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyQuestionDropdownEntry);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionDropdownEntry)} with {@code
   * SurveyQuestionDropdownEntry}.
   *
   * <p>Method under test: {@link Builder#from(SurveyQuestionDropdownEntry)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionDropdownEntry) with 'SurveyQuestionDropdownEntry'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionDropdownEntry)"})
  void testBuilderFromWithSurveyQuestionDropdownEntry() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();
    ImmutableSurveyQuestionDropdownEntry instance =
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyQuestionDropdownEntry actualImmutableSurveyQuestionDropdownEntry =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyQuestionDropdownEntry);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#position(int)}.
   *
   * <p>Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPosition() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();

    // Act
    Builder actualPositionResult = builderResult.position(1);

    // Assert
    assertSame(builderResult, actualPositionResult);
  }

  /**
   * Test Builder {@link Builder#questionId(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#questionId(long)}
   */
  @Test
  @DisplayName("Test Builder questionId(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.questionId(long)"})
  void testBuilderQuestionIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();

    // Act
    Builder actualQuestionIdResult = builderResult.questionId(1L);

    // Assert
    assertSame(builderResult, actualQuestionIdResult);
  }

  /**
   * Test Builder {@link Builder#questionId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#questionId(Optional)}
   */
  @Test
  @DisplayName("Test Builder questionId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.questionId(Optional)"})
  void testBuilderQuestionIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();
    Optional<Long> questionId = Optional.of(42L);

    // Act
    Builder actualQuestionIdResult = builderResult.questionId(questionId);

    // Assert
    assertSame(builderResult, actualQuestionIdResult);
  }

  /**
   * Test Builder {@link Builder#value(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#value(String)}
   */
  @Test
  @DisplayName("Test Builder value(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.value(String)"})
  void testBuilderValue_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionDropdownEntry.builder();

    // Act
    Builder actualValueResult = builderResult.value("42");

    // Assert
    assertSame(builderResult, actualValueResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionDropdownEntry#copyOf(SurveyQuestionDropdownEntry)}.
   *
   * <ul>
   *   <li>Then return value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyQuestionDropdownEntry#copyOf(SurveyQuestionDropdownEntry)}
   */
  @Test
  @DisplayName("Test copyOf(SurveyQuestionDropdownEntry); then return value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionDropdownEntry ImmutableSurveyQuestionDropdownEntry.copyOf(SurveyQuestionDropdownEntry)"
  })
  void testCopyOf_thenReturnValueIs42() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry instance =
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build();

    // Act
    ImmutableSurveyQuestionDropdownEntry actualCopyOfResult =
        ImmutableSurveyQuestionDropdownEntry.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.value());
    assertEquals(1, actualCopyOfResult.position());
  }

  /**
   * Test {@link ImmutableSurveyQuestionDropdownEntry#equals(Object)}, and {@link
   * ImmutableSurveyQuestionDropdownEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyQuestionDropdownEntry#equals(Object)}
   *   <li>{@link ImmutableSurveyQuestionDropdownEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionDropdownEntry.equals(Object)",
    "int ImmutableSurveyQuestionDropdownEntry.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry immutableSurveyQuestionDropdownEntry =
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build();
    ImmutableSurveyQuestionDropdownEntry immutableSurveyQuestionDropdownEntry2 =
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build();

    // Act and Assert
    assertEquals(immutableSurveyQuestionDropdownEntry, immutableSurveyQuestionDropdownEntry2);
    assertEquals(
        immutableSurveyQuestionDropdownEntry.hashCode(),
        immutableSurveyQuestionDropdownEntry2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyQuestionDropdownEntry#equals(Object)}, and {@link
   * ImmutableSurveyQuestionDropdownEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyQuestionDropdownEntry#equals(Object)}
   *   <li>{@link ImmutableSurveyQuestionDropdownEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionDropdownEntry.equals(Object)",
    "int ImmutableSurveyQuestionDropdownEntry.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry immutableSurveyQuestionDropdownEntry =
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build();

    // Act and Assert
    assertEquals(immutableSurveyQuestionDropdownEntry, immutableSurveyQuestionDropdownEntry);
    int expectedHashCodeResult = immutableSurveyQuestionDropdownEntry.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyQuestionDropdownEntry.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyQuestionDropdownEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionDropdownEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionDropdownEntry.equals(Object)",
    "int ImmutableSurveyQuestionDropdownEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry immutableSurveyQuestionDropdownEntry =
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(2L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionDropdownEntry,
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionDropdownEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionDropdownEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionDropdownEntry.equals(Object)",
    "int ImmutableSurveyQuestionDropdownEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry immutableSurveyQuestionDropdownEntry =
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(0)
            .questionId(1L)
            .value("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionDropdownEntry,
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionDropdownEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionDropdownEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionDropdownEntry.equals(Object)",
    "int ImmutableSurveyQuestionDropdownEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry immutableSurveyQuestionDropdownEntry =
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(2L)
            .value("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionDropdownEntry,
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionDropdownEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionDropdownEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionDropdownEntry.equals(Object)",
    "int ImmutableSurveyQuestionDropdownEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry immutableSurveyQuestionDropdownEntry =
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("Value")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionDropdownEntry,
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionDropdownEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionDropdownEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionDropdownEntry.equals(Object)",
    "int ImmutableSurveyQuestionDropdownEntry.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyQuestionDropdownEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionDropdownEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionDropdownEntry.equals(Object)",
    "int ImmutableSurveyQuestionDropdownEntry.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build(),
        "Different type to ImmutableSurveyQuestionDropdownEntry");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyQuestionDropdownEntry#position()}
   *   <li>{@link ImmutableSurveyQuestionDropdownEntry#value()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ImmutableSurveyQuestionDropdownEntry.position()",
    "String ImmutableSurveyQuestionDropdownEntry.value()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry immutableSurveyQuestionDropdownEntry =
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build();

    // Act
    int actualPositionResult = immutableSurveyQuestionDropdownEntry.position();

    // Assert
    assertEquals("42", immutableSurveyQuestionDropdownEntry.value());
    assertEquals(1, actualPositionResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionDropdownEntry#id()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionDropdownEntry#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyQuestionDropdownEntry.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().position());
  }

  /**
   * Test Json {@link Json#questionId()}.
   *
   * <p>Method under test: {@link Json#questionId()}
   */
  @Test
  @DisplayName("Test Json questionId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.questionId()"})
  void testJsonQuestionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().questionId());
  }

  /**
   * Test Json {@link Json#setPosition(int)}.
   *
   * <p>Method under test: {@link Json#setPosition(int)}
   */
  @Test
  @DisplayName("Test Json setPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#value()}
   */
  @Test
  @DisplayName("Test Json value()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.value()"})
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().value());
  }

  /**
   * Test {@link ImmutableSurveyQuestionDropdownEntry#questionId()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionDropdownEntry#questionId()}
   */
  @Test
  @DisplayName("Test questionId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyQuestionDropdownEntry.questionId()"})
  void testQuestionId() {
    // Arrange and Act
    Optional<Long> actualQuestionIdResult =
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build()
            .questionId();

    // Assert
    assertEquals(1L, actualQuestionIdResult.get().longValue());
    assertTrue(actualQuestionIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableSurveyQuestionDropdownEntry#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionDropdownEntry#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyQuestionDropdownEntry.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "SurveyQuestionDropdownEntry{id=1, questionId=1, value=42, position=1}",
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyQuestionDropdownEntry#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionDropdownEntry#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionDropdownEntry ImmutableSurveyQuestionDropdownEntry.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry immutableSurveyQuestionDropdownEntry =
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableSurveyQuestionDropdownEntry actualWithIdResult =
        immutableSurveyQuestionDropdownEntry.withId(optional);

    // Assert
    assertSame(immutableSurveyQuestionDropdownEntry, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionDropdownEntry#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionDropdownEntry#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; when of forty-two; then return value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionDropdownEntry ImmutableSurveyQuestionDropdownEntry.withId(Optional)"
  })
  void testWithIdWithOptional_whenOfFortyTwo_thenReturnValueIs42() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry immutableSurveyQuestionDropdownEntry =
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableSurveyQuestionDropdownEntry actualWithIdResult =
        immutableSurveyQuestionDropdownEntry.withId(optional);

    // Assert
    assertEquals("42", actualWithIdResult.value());
    assertEquals(1, actualWithIdResult.position());
  }

  /**
   * Test {@link ImmutableSurveyQuestionDropdownEntry#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then return builder id one position one questionId one value {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionDropdownEntry#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; then return builder id one position one questionId one value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionDropdownEntry ImmutableSurveyQuestionDropdownEntry.withId(long)"
  })
  void testWithIdWithValue_thenReturnBuilderIdOnePositionOneQuestionIdOneValue42Build() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry immutableSurveyQuestionDropdownEntry =
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build();

    // Act
    ImmutableSurveyQuestionDropdownEntry actualWithIdResult =
        immutableSurveyQuestionDropdownEntry.withId(1L);

    // Assert
    assertSame(immutableSurveyQuestionDropdownEntry, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionDropdownEntry#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionDropdownEntry#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionDropdownEntry ImmutableSurveyQuestionDropdownEntry.withId(long)"
  })
  void testWithIdWithValue_whenFortyTwo_thenReturnValueIs42() {
    // Arrange and Act
    ImmutableSurveyQuestionDropdownEntry actualWithIdResult =
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build()
            .withId(42L);

    // Assert
    assertEquals("42", actualWithIdResult.value());
    assertEquals(1, actualWithIdResult.position());
  }

  /**
   * Test {@link ImmutableSurveyQuestionDropdownEntry#withPosition(int)}.
   *
   * <ul>
   *   <li>Then return builder id one position forty-two questionId one value {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionDropdownEntry#withPosition(int)}
   */
  @Test
  @DisplayName(
      "Test withPosition(int); then return builder id one position forty-two questionId one value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionDropdownEntry ImmutableSurveyQuestionDropdownEntry.withPosition(int)"
  })
  void testWithPosition_thenReturnBuilderIdOnePositionFortyTwoQuestionIdOneValue42Build() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry immutableSurveyQuestionDropdownEntry =
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(42)
            .questionId(1L)
            .value("42")
            .build();

    // Act
    ImmutableSurveyQuestionDropdownEntry actualWithPositionResult =
        immutableSurveyQuestionDropdownEntry.withPosition(42);

    // Assert
    assertSame(immutableSurveyQuestionDropdownEntry, actualWithPositionResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionDropdownEntry#withPosition(int)}.
   *
   * <ul>
   *   <li>Then return value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionDropdownEntry#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int); then return value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionDropdownEntry ImmutableSurveyQuestionDropdownEntry.withPosition(int)"
  })
  void testWithPosition_thenReturnValueIs42() {
    // Arrange and Act
    ImmutableSurveyQuestionDropdownEntry actualWithPositionResult =
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build()
            .withPosition(42);

    // Assert
    assertEquals("42", actualWithPositionResult.value());
    assertEquals(42, actualWithPositionResult.position());
  }

  /**
   * Test {@link ImmutableSurveyQuestionDropdownEntry#withQuestionId(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionDropdownEntry#withQuestionId(Optional)}
   */
  @Test
  @DisplayName("Test withQuestionId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionDropdownEntry ImmutableSurveyQuestionDropdownEntry.withQuestionId(Optional)"
  })
  void testWithQuestionIdWithOptional() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry immutableSurveyQuestionDropdownEntry =
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableSurveyQuestionDropdownEntry actualWithQuestionIdResult =
        immutableSurveyQuestionDropdownEntry.withQuestionId(optional);

    // Assert
    assertSame(immutableSurveyQuestionDropdownEntry, actualWithQuestionIdResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionDropdownEntry#withQuestionId(Optional)} with {@code
   * optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionDropdownEntry#withQuestionId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withQuestionId(Optional) with 'optional'; when of forty-two; then return value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionDropdownEntry ImmutableSurveyQuestionDropdownEntry.withQuestionId(Optional)"
  })
  void testWithQuestionIdWithOptional_whenOfFortyTwo_thenReturnValueIs42() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry immutableSurveyQuestionDropdownEntry =
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableSurveyQuestionDropdownEntry actualWithQuestionIdResult =
        immutableSurveyQuestionDropdownEntry.withQuestionId(optional);

    // Assert
    assertEquals("42", actualWithQuestionIdResult.value());
    assertEquals(1, actualWithQuestionIdResult.position());
  }

  /**
   * Test {@link ImmutableSurveyQuestionDropdownEntry#withQuestionId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionDropdownEntry#withQuestionId(long)}
   */
  @Test
  @DisplayName("Test withQuestionId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionDropdownEntry ImmutableSurveyQuestionDropdownEntry.withQuestionId(long)"
  })
  void testWithQuestionIdWithValue() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry immutableSurveyQuestionDropdownEntry =
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build();

    // Act
    ImmutableSurveyQuestionDropdownEntry actualWithQuestionIdResult =
        immutableSurveyQuestionDropdownEntry.withQuestionId(1L);

    // Assert
    assertSame(immutableSurveyQuestionDropdownEntry, actualWithQuestionIdResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionDropdownEntry#withQuestionId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionDropdownEntry#withQuestionId(long)}
   */
  @Test
  @DisplayName("Test withQuestionId(long) with 'value'; when forty-two; then return value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionDropdownEntry ImmutableSurveyQuestionDropdownEntry.withQuestionId(long)"
  })
  void testWithQuestionIdWithValue_whenFortyTwo_thenReturnValueIs42() {
    // Arrange and Act
    ImmutableSurveyQuestionDropdownEntry actualWithQuestionIdResult =
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build()
            .withQuestionId(42L);

    // Assert
    assertEquals("42", actualWithQuestionIdResult.value());
    assertEquals(1, actualWithQuestionIdResult.position());
  }

  /**
   * Test {@link ImmutableSurveyQuestionDropdownEntry#withValue(String)}.
   *
   * <ul>
   *   <li>Then return builder id one position one questionId one value {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionDropdownEntry#withValue(String)}
   */
  @Test
  @DisplayName(
      "Test withValue(String); then return builder id one position one questionId one value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionDropdownEntry ImmutableSurveyQuestionDropdownEntry.withValue(String)"
  })
  void testWithValue_thenReturnBuilderIdOnePositionOneQuestionIdOneValue42Build() {
    // Arrange
    ImmutableSurveyQuestionDropdownEntry immutableSurveyQuestionDropdownEntry =
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build();

    // Act
    ImmutableSurveyQuestionDropdownEntry actualWithValueResult =
        immutableSurveyQuestionDropdownEntry.withValue("42");

    // Assert
    assertSame(immutableSurveyQuestionDropdownEntry, actualWithValueResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionDropdownEntry#withValue(String)}.
   *
   * <ul>
   *   <li>Then return value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionDropdownEntry#withValue(String)}
   */
  @Test
  @DisplayName("Test withValue(String); then return value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionDropdownEntry ImmutableSurveyQuestionDropdownEntry.withValue(String)"
  })
  void testWithValue_thenReturnValueIs42() {
    // Arrange and Act
    ImmutableSurveyQuestionDropdownEntry actualWithValueResult =
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("value")
            .build()
            .withValue("42");

    // Assert
    assertEquals("42", actualWithValueResult.value());
    assertEquals(1, actualWithValueResult.position());
  }
}
