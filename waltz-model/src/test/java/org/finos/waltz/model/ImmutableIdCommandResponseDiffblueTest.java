package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.ImmutableIdCommandResponse.Builder;
import org.finos.waltz.model.ImmutableIdCommandResponse.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableIdCommandResponseDiffblueTest {
  /**
   * Test Builder {@link Builder#from(IdCommandResponse)} with {@code IdCommandResponse}.
   *
   * <ul>
   *   <li>Then builder build is builder id one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdCommandResponse)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdCommandResponse) with 'IdCommandResponse'; then builder build is builder id one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdCommandResponse)"})
  void testBuilderFromWithIdCommandResponse_thenBuilderBuildIsBuilderIdOneBuild() {
    // Arrange
    Builder builderResult = ImmutableIdCommandResponse.builder();
    ImmutableIdCommandResponse instance = ImmutableIdCommandResponse.builder().id(1L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableIdCommandResponse actualImmutableIdCommandResponse = builderResult.build();
    assertEquals(instance, actualImmutableIdCommandResponse);
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
    Builder builderResult = ImmutableIdCommandResponse.builder();

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
   *   <li>Given of forty-two.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of forty-two; when IdProvider id() return of forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfFortyTwo_whenIdProviderIdReturnOfFortyTwo() {
    // Arrange
    Builder builderResult = ImmutableIdCommandResponse.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(42L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
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
    Builder builderResult = ImmutableIdCommandResponse.builder();

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
    Builder builderResult = ImmutableIdCommandResponse.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test {@link ImmutableIdCommandResponse#copyOf(IdCommandResponse)}.
   *
   * <ul>
   *   <li>When builder id one build.
   *   <li>Then return id longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdCommandResponse#copyOf(IdCommandResponse)}
   */
  @Test
  @DisplayName(
      "Test copyOf(IdCommandResponse); when builder id one build; then return id longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableIdCommandResponse ImmutableIdCommandResponse.copyOf(IdCommandResponse)"
  })
  void testCopyOf_whenBuilderIdOneBuild_thenReturnIdLongValueIsOne() {
    // Arrange
    ImmutableIdCommandResponse instance = ImmutableIdCommandResponse.builder().id(1L).build();

    // Act and Assert
    Optional<Long> idResult = ImmutableIdCommandResponse.copyOf(instance).id();
    assertEquals(1L, idResult.get().longValue());
    assertTrue(idResult.isPresent());
  }

  /**
   * Test {@link ImmutableIdCommandResponse#equals(Object)}, and {@link
   * ImmutableIdCommandResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableIdCommandResponse#equals(Object)}
   *   <li>{@link ImmutableIdCommandResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableIdCommandResponse.equals(Object)",
    "int ImmutableIdCommandResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableIdCommandResponse immutableIdCommandResponse =
        ImmutableIdCommandResponse.builder().id(1L).build();
    ImmutableIdCommandResponse immutableIdCommandResponse2 =
        ImmutableIdCommandResponse.builder().id(1L).build();

    // Act and Assert
    assertEquals(immutableIdCommandResponse, immutableIdCommandResponse2);
    assertEquals(immutableIdCommandResponse.hashCode(), immutableIdCommandResponse2.hashCode());
  }

  /**
   * Test {@link ImmutableIdCommandResponse#equals(Object)}, and {@link
   * ImmutableIdCommandResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableIdCommandResponse#equals(Object)}
   *   <li>{@link ImmutableIdCommandResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableIdCommandResponse.equals(Object)",
    "int ImmutableIdCommandResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableIdCommandResponse immutableIdCommandResponse =
        ImmutableIdCommandResponse.builder().id(1L).build();

    // Act and Assert
    assertEquals(immutableIdCommandResponse, immutableIdCommandResponse);
    int expectedHashCodeResult = immutableIdCommandResponse.hashCode();
    assertEquals(expectedHashCodeResult, immutableIdCommandResponse.hashCode());
  }

  /**
   * Test {@link ImmutableIdCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableIdCommandResponse.equals(Object)",
    "int ImmutableIdCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableIdCommandResponse immutableIdCommandResponse =
        ImmutableIdCommandResponse.builder().id(2L).build();

    // Act and Assert
    assertNotEquals(
        immutableIdCommandResponse, ImmutableIdCommandResponse.builder().id(1L).build());
  }

  /**
   * Test {@link ImmutableIdCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableIdCommandResponse.equals(Object)",
    "int ImmutableIdCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableIdCommandResponse.builder().id(1L).build(), null);
  }

  /**
   * Test {@link ImmutableIdCommandResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableIdCommandResponse.equals(Object)",
    "int ImmutableIdCommandResponse.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableIdCommandResponse.builder().id(1L).build(),
        "Different type to ImmutableIdCommandResponse");
  }

  /**
   * Test {@link ImmutableIdCommandResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Id is {@code null}.
   *   <li>Then return not id Present.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdCommandResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Id is 'null'; then return not id Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableIdCommandResponse ImmutableIdCommandResponse.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonIdIsNull_thenReturnNotIdPresent() {
    // Arrange
    Json json = new Json();
    json.setId(null);

    // Act
    ImmutableIdCommandResponse actualFromJsonResult = ImmutableIdCommandResponse.fromJson(json);

    // Assert
    assertFalse(actualFromJsonResult.id().isPresent());
  }

  /**
   * Test {@link ImmutableIdCommandResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return not id Present.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdCommandResponse#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return not id Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableIdCommandResponse ImmutableIdCommandResponse.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnNotIdPresent() {
    // Arrange and Act
    ImmutableIdCommandResponse actualFromJsonResult =
        ImmutableIdCommandResponse.fromJson(new Json());

    // Assert
    assertFalse(actualFromJsonResult.id().isPresent());
  }

  /**
   * Test {@link ImmutableIdCommandResponse#id()}.
   *
   * <p>Method under test: {@link ImmutableIdCommandResponse#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableIdCommandResponse.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult = ImmutableIdCommandResponse.builder().id(1L).build().id();

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
    // Arrange, Act and Assert
    assertFalse(new Json().id.isPresent());
  }

  /**
   * Test {@link ImmutableIdCommandResponse#toString()}.
   *
   * <p>Method under test: {@link ImmutableIdCommandResponse#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableIdCommandResponse.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "IdCommandResponse{id=1}", ImmutableIdCommandResponse.builder().id(1L).build().toString());
  }

  /**
   * Test {@link ImmutableIdCommandResponse#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return id is of forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdCommandResponse#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; when of forty-two; then return id is of forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableIdCommandResponse ImmutableIdCommandResponse.withId(Optional)"})
  void testWithIdWithOptional_whenOfFortyTwo_thenReturnIdIsOfFortyTwo() {
    // Arrange
    ImmutableIdCommandResponse immutableIdCommandResponse =
        ImmutableIdCommandResponse.builder().id(1L).build();
    Optional<Long> optional = Optional.of(42L);

    // Act and Assert
    assertEquals(optional, immutableIdCommandResponse.withId(optional).id());
  }

  /**
   * Test {@link ImmutableIdCommandResponse#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of one.
   *   <li>Then return builder id one build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdCommandResponse#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; when of one; then return builder id one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableIdCommandResponse ImmutableIdCommandResponse.withId(Optional)"})
  void testWithIdWithOptional_whenOfOne_thenReturnBuilderIdOneBuild() {
    // Arrange
    ImmutableIdCommandResponse immutableIdCommandResponse =
        ImmutableIdCommandResponse.builder().id(1L).build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableIdCommandResponse actualWithIdResult = immutableIdCommandResponse.withId(optional);

    // Assert
    assertSame(immutableIdCommandResponse, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableIdCommandResponse#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return id longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdCommandResponse#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; when forty-two; then return id longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableIdCommandResponse ImmutableIdCommandResponse.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnIdLongValueIsFortyTwo() {
    // Arrange, Act and Assert
    Optional<Long> idResult = ImmutableIdCommandResponse.builder().id(1L).build().withId(42L).id();
    assertEquals(42L, idResult.get().longValue());
    assertTrue(idResult.isPresent());
  }

  /**
   * Test {@link ImmutableIdCommandResponse#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return builder id one build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdCommandResponse#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when one; then return builder id one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableIdCommandResponse ImmutableIdCommandResponse.withId(long)"})
  void testWithIdWithValue_whenOne_thenReturnBuilderIdOneBuild() {
    // Arrange
    ImmutableIdCommandResponse immutableIdCommandResponse =
        ImmutableIdCommandResponse.builder().id(1L).build();

    // Act
    ImmutableIdCommandResponse actualWithIdResult = immutableIdCommandResponse.withId(1L);

    // Assert
    assertSame(immutableIdCommandResponse, actualWithIdResult);
  }
}
