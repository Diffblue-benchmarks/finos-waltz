package org.finos.waltz.model.application;

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
import org.finos.waltz.model.application.ImmutableAppRegistrationResponse.Builder;
import org.finos.waltz.model.application.ImmutableAppRegistrationResponse.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAppRegistrationResponseDiffblueTest {
  /**
   * Test {@link ImmutableAppRegistrationResponse#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAppRegistrationResponse#builder()}
   *   <li>{@link ImmutableAppRegistrationResponse#message(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAppRegistrationResponse Builder.build()", "Builder Builder.message(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualIdResult = ImmutableAppRegistrationResponse.builder().id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualMessageResult = actualIdResult.id(id).message("Not all who wander are lost");
    Optional<String> message = Optional.of("foo");

    // Assert
    assertSame(actualMessageResult, actualMessageResult.message(message));
  }

  /**
   * Test Builder {@link Builder#from(AppRegistrationResponse)}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   *   <li>Then builder build registered.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppRegistrationResponse)}
   */
  @Test
  @DisplayName("Test Builder from(AppRegistrationResponse); given Optional with one; then builder build registered")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppRegistrationResponse)"})
  void testBuilderFrom_givenOptionalWithOne_thenBuilderBuildRegistered() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationResponse.builder();
    AppRegistrationResponse instance = mock(AppRegistrationResponse.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult2);
    ImmutableAppRegistrationRequest.Json json = new ImmutableAppRegistrationRequest.Json();
    when(instance.originalRequest()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).message();
    verify(instance).originalRequest();
    ImmutableAppRegistrationResponse buildResult = builderResult.build();
    assertTrue(buildResult.registered());
    assertSame(json, buildResult.originalRequest());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AppRegistrationResponse)}.
   * <ul>
   *   <li>Then not builder build registered.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppRegistrationResponse)}
   */
  @Test
  @DisplayName("Test Builder from(AppRegistrationResponse); then not builder build registered")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppRegistrationResponse)"})
  void testBuilderFrom_thenNotBuilderBuildRegistered() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationResponse.builder();
    AppRegistrationResponse instance = mock(AppRegistrationResponse.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);
    ImmutableAppRegistrationRequest.Json json = new ImmutableAppRegistrationRequest.Json();
    when(instance.originalRequest()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).message();
    verify(instance).originalRequest();
    ImmutableAppRegistrationResponse buildResult = builderResult.build();
    assertFalse(buildResult.registered());
    assertSame(json, buildResult.originalRequest());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AppRegistrationResponse)}.
   * <ul>
   *   <li>When {@link AppRegistrationResponse} {@link AppRegistrationResponse#message()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppRegistrationResponse)}
   */
  @Test
  @DisplayName("Test Builder from(AppRegistrationResponse); when AppRegistrationResponse message() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppRegistrationResponse)"})
  void testBuilderFrom_whenAppRegistrationResponseMessageReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationResponse.builder();
    AppRegistrationResponse instance = mock(AppRegistrationResponse.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.message()).thenReturn(emptyResult);
    ImmutableAppRegistrationRequest.Json json = new ImmutableAppRegistrationRequest.Json();
    when(instance.originalRequest()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).message();
    verify(instance).originalRequest();
    ImmutableAppRegistrationResponse buildResult = builderResult.build();
    assertTrue(buildResult.registered());
    assertSame(json, buildResult.originalRequest());
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
    Builder builderResult = ImmutableAppRegistrationResponse.builder();

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
    Builder builderResult = ImmutableAppRegistrationResponse.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#message(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#message(Optional)}
   */
  @Test
  @DisplayName("Test Builder message(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.message(Optional)"})
  void testBuilderMessageWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationResponse.builder();
    Optional<String> message = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.message(message));
  }

  /**
   * Test Builder {@link Builder#originalRequest(AppRegistrationRequest)}.
   * <ul>
   *   <li>When {@link ImmutableAppRegistrationRequest.Json} (default constructor).</li>
   *   <li>Then not builder build registered.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#originalRequest(AppRegistrationRequest)}
   */
  @Test
  @DisplayName("Test Builder originalRequest(AppRegistrationRequest); when Json (default constructor); then not builder build registered")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.originalRequest(AppRegistrationRequest)"})
  void testBuilderOriginalRequest_whenJson_thenNotBuilderBuildRegistered() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationResponse.builder();
    ImmutableAppRegistrationRequest.Json originalRequest = new ImmutableAppRegistrationRequest.Json();

    // Act
    Builder actualOriginalRequestResult = builderResult.originalRequest(originalRequest);

    // Assert
    ImmutableAppRegistrationResponse buildResult = builderResult.build();
    assertFalse(buildResult.registered());
    assertSame(originalRequest, buildResult.originalRequest());
    assertSame(builderResult, actualOriginalRequestResult);
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
   * Test Json {@link Json#message()}.
   * <p>
   * Method under test: {@link Json#message()}
   */
  @Test
  @DisplayName("Test Json message()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.message()"})
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
    assertNull(actualJson.originalRequest);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.message.isPresent());
  }

  /**
   * Test Json {@link Json#originalRequest()}.
   * <p>
   * Method under test: {@link Json#originalRequest()}
   */
  @Test
  @DisplayName("Test Json originalRequest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AppRegistrationRequest Json.originalRequest()"})
  void testJsonOriginalRequest() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).originalRequest());
  }

  /**
   * Test Json {@link Json#registered()}.
   * <p>
   * Method under test: {@link Json#registered()}
   */
  @Test
  @DisplayName("Test Json registered()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.registered()"})
  void testJsonRegistered() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).registered());
  }
}
