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
   * <ul>
   *   <li>Then builder build is builder id one build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdCommandResponse)}
   */
  @Test
  @DisplayName("Test Builder from(IdCommandResponse) with 'IdCommandResponse'; then builder build is builder id one build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdCommandResponse)"})
  void testBuilderFromWithIdCommandResponse_thenBuilderBuildIsBuilderIdOneBuild() {
    // Arrange
    Builder builderResult = ImmutableIdCommandResponse.builder();
    ImmutableIdCommandResponse instance = ImmutableIdCommandResponse.builder().id(1L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

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
    Builder builderResult = ImmutableIdCommandResponse.builder();
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
    Builder builderResult = ImmutableIdCommandResponse.builder();

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
    Builder builderResult = ImmutableIdCommandResponse.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test {@link ImmutableIdCommandResponse#copyOf(IdCommandResponse)}.
   * <ul>
   *   <li>When builder id one build.</li>
   *   <li>Then return id longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableIdCommandResponse#copyOf(IdCommandResponse)}
   */
  @Test
  @DisplayName("Test copyOf(IdCommandResponse); when builder id one build; then return id longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableIdCommandResponse ImmutableIdCommandResponse.copyOf(IdCommandResponse)"})
  void testCopyOf_whenBuilderIdOneBuild_thenReturnIdLongValueIsOne() {
    // Arrange
    ImmutableIdCommandResponse instance = ImmutableIdCommandResponse.builder().id(1L).build();

    // Act and Assert
    Optional<Long> idResult = ImmutableIdCommandResponse.copyOf(instance).id();
    assertEquals(1L, idResult.get().longValue());
    assertTrue(idResult.isPresent());
  }

  /**
   * Test {@link ImmutableIdCommandResponse#equals(Object)}, and {@link ImmutableIdCommandResponse#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableIdCommandResponse#equals(Object)}
   *   <li>{@link ImmutableIdCommandResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableIdCommandResponse.equals(Object)", "int ImmutableIdCommandResponse.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableIdCommandResponse buildResult = ImmutableIdCommandResponse.builder().id(1L).build();
    ImmutableIdCommandResponse buildResult2 = ImmutableIdCommandResponse.builder().id(1L).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableIdCommandResponse#equals(Object)}, and {@link ImmutableIdCommandResponse#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableIdCommandResponse#equals(Object)}
   *   <li>{@link ImmutableIdCommandResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableIdCommandResponse.equals(Object)", "int ImmutableIdCommandResponse.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableIdCommandResponse buildResult = ImmutableIdCommandResponse.builder().id(1L).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableIdCommandResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableIdCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableIdCommandResponse.equals(Object)", "int ImmutableIdCommandResponse.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableIdCommandResponse buildResult = ImmutableIdCommandResponse.builder().id(2L).build();
    ImmutableIdCommandResponse buildResult2 = ImmutableIdCommandResponse.builder().id(1L).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableIdCommandResponse#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableIdCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableIdCommandResponse.equals(Object)", "int ImmutableIdCommandResponse.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableIdCommandResponse buildResult = ImmutableIdCommandResponse.builder().id(1L).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableIdCommandResponse#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableIdCommandResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableIdCommandResponse.equals(Object)", "int ImmutableIdCommandResponse.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableIdCommandResponse buildResult = ImmutableIdCommandResponse.builder().id(1L).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableIdCommandResponse");
  }

  /**
   * Test {@link ImmutableIdCommandResponse#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) Id is {@code null}.</li>
   *   <li>Then return not id Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableIdCommandResponse#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) Id is 'null'; then return not id Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableIdCommandResponse ImmutableIdCommandResponse.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonIdIsNull_thenReturnNotIdPresent() {
    // Arrange
    Json json = new Json();
    json.setId(null);

    // Act and Assert
    assertFalse(ImmutableIdCommandResponse.fromJson(json).id().isPresent());
  }

  /**
   * Test {@link ImmutableIdCommandResponse#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return not id Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableIdCommandResponse#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return not id Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableIdCommandResponse ImmutableIdCommandResponse.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnNotIdPresent() {
    // Arrange, Act and Assert
    assertFalse(ImmutableIdCommandResponse.fromJson(new Json()).id().isPresent());
  }

  /**
   * Test {@link ImmutableIdCommandResponse#id()}.
   * <p>
   * Method under test: {@link ImmutableIdCommandResponse#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional ImmutableIdCommandResponse.id()"})
  void testId() {
    // Arrange
    ImmutableIdCommandResponse buildResult = ImmutableIdCommandResponse.builder().id(1L).build();

    // Act
    Optional<Long> actualIdResult = buildResult.id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
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
    // Arrange, Act and Assert
    assertFalse((new Json()).id.isPresent());
  }

  /**
   * Test {@link ImmutableIdCommandResponse#withId(Optional)} with {@code optional}.
   * <ul>
   *   <li>Given builder id one build.</li>
   *   <li>Then return builder id one build.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableIdCommandResponse#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; given builder id one build; then return builder id one build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableIdCommandResponse ImmutableIdCommandResponse.withId(Optional)"})
  void testWithIdWithOptional_givenBuilderIdOneBuild_thenReturnBuilderIdOneBuild() {
    // Arrange
    ImmutableIdCommandResponse buildResult = ImmutableIdCommandResponse.builder().id(1L).build();
    Optional<Long> optional = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(buildResult, buildResult.withId(optional));
  }

  /**
   * Test {@link ImmutableIdCommandResponse#withId(Optional)} with {@code optional}.
   * <ul>
   *   <li>Given builder id two build.</li>
   *   <li>Then return id is {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableIdCommandResponse#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; given builder id two build; then return id is Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableIdCommandResponse ImmutableIdCommandResponse.withId(Optional)"})
  void testWithIdWithOptional_givenBuilderIdTwoBuild_thenReturnIdIsOptionalWithOne() {
    // Arrange
    ImmutableIdCommandResponse buildResult = ImmutableIdCommandResponse.builder().id(2L).build();
    Optional<Long> optional = Optional.<Long>of(1L);

    // Act and Assert
    assertEquals(optional, buildResult.withId(optional).id());
  }

  /**
   * Test {@link ImmutableIdCommandResponse#withId(long)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return id longValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableIdCommandResponse#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return id longValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableIdCommandResponse ImmutableIdCommandResponse.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnIdLongValueIsFortyTwo() {
    // Arrange
    ImmutableIdCommandResponse buildResult = ImmutableIdCommandResponse.builder().id(1L).build();

    // Act and Assert
    Optional<Long> idResult = buildResult.withId(42L).id();
    assertEquals(42L, idResult.get().longValue());
    assertTrue(idResult.isPresent());
  }

  /**
   * Test {@link ImmutableIdCommandResponse#withId(long)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return builder id one build.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableIdCommandResponse#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when one; then return builder id one build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableIdCommandResponse ImmutableIdCommandResponse.withId(long)"})
  void testWithIdWithValue_whenOne_thenReturnBuilderIdOneBuild() {
    // Arrange
    ImmutableIdCommandResponse buildResult = ImmutableIdCommandResponse.builder().id(1L).build();

    // Act and Assert
    assertSame(buildResult, buildResult.withId(1L));
  }
}
