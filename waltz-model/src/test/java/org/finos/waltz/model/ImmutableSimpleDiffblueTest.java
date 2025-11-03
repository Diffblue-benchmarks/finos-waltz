package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.ImmutableSimple.Builder;
import org.finos.waltz.model.ImmutableSimple.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSimpleDiffblueTest {
  /**
   * Test {@link ImmutableSimple#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSimple#builder()}
   *   <li>{@link ImmutableSimple#secret(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSimple Builder.build()", "Builder Builder.secret(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualSecretResult = ImmutableSimple.builder().secret("Secret");
    Optional<String> secret = Optional.of("foo");

    // Assert
    assertSame(actualSecretResult, actualSecretResult.secret(secret));
  }

  /**
   * Test Builder {@link Builder#from(Simple)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link Simple} {@link Simple#secret()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Simple)}
   */
  @Test
  @DisplayName("Test Builder from(Simple); given empty; when Simple secret() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Simple)"})
  void testBuilderFrom_givenEmpty_whenSimpleSecretReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableSimple.builder();
    Simple instance = mock(Simple.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.secret()).thenReturn(emptyResult);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).message();
    verify(instance).secret();
    assertEquals("Not all who wander are lost", builderResult.build().message());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Simple)}.
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   *   <li>When {@link Simple} {@link Simple#secret()} return {@link Optional} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Simple)}
   */
  @Test
  @DisplayName("Test Builder from(Simple); given Optional with 'foo'; when Simple secret() return Optional with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Simple)"})
  void testBuilderFrom_givenOptionalWithFoo_whenSimpleSecretReturnOptionalWithFoo() {
    // Arrange
    Builder builderResult = ImmutableSimple.builder();
    Simple instance = mock(Simple.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.secret()).thenReturn(ofResult);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).message();
    verify(instance).secret();
    assertEquals("Not all who wander are lost", builderResult.build().message());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Simple)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Simple)}
   */
  @Test
  @DisplayName("Test Builder from(Simple); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Simple)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSimple.builder();
    Simple instance = mock(Simple.class);
    when(instance.secret()).thenThrow(new IllegalStateException("instance"));
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).message();
    verify(instance).secret();
  }

  /**
   * Test Builder {@link Builder#message(String)}.
   * <p>
   * Method under test: {@link Builder#message(String)}
   */
  @Test
  @DisplayName("Test Builder message(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.message(String)"})
  void testBuilderMessage() {
    // Arrange
    Builder builderResult = ImmutableSimple.builder();

    // Act
    Builder actualMessageResult = builderResult.message("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", builderResult.build().message());
    assertSame(builderResult, actualMessageResult);
  }

  /**
   * Test Builder {@link Builder#secret(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#secret(Optional)}
   */
  @Test
  @DisplayName("Test Builder secret(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.secret(Optional)"})
  void testBuilderSecretWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSimple.builder();
    Optional<String> secret = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.secret(secret));
  }

  /**
   * Test Json {@link Json#message()}.
   * <p>
   * Method under test: {@link Json#message()}
   */
  @Test
  @DisplayName("Test Json message()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.message()"})
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).message());
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
    assertNull(actualJson.message);
    assertFalse(actualJson.secret.isPresent());
  }

  /**
   * Test Json {@link Json#secret()}.
   * <p>
   * Method under test: {@link Json#secret()}
   */
  @Test
  @DisplayName("Test Json secret()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.secret()"})
  void testJsonSecret() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).secret());
  }
}
