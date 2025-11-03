package org.finos.waltz.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.user.ImmutableUserRegistrationRequest.Builder;
import org.finos.waltz.model.user.ImmutableUserRegistrationRequest.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUserRegistrationRequestDiffblueTest {
  /**
   * Test Builder {@link Builder#from(UserRegistrationRequest)}.
   * <ul>
   *   <li>Given {@code iloveyou}.</li>
   *   <li>Then builder build password is {@code iloveyou}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UserRegistrationRequest)}
   */
  @Test
  @DisplayName("Test Builder from(UserRegistrationRequest); given 'iloveyou'; then builder build password is 'iloveyou'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UserRegistrationRequest)"})
  void testBuilderFrom_givenIloveyou_thenBuilderBuildPasswordIsIloveyou() {
    // Arrange
    Builder builderResult = ImmutableUserRegistrationRequest.builder();
    UserRegistrationRequest instance = mock(UserRegistrationRequest.class);
    when(instance.password()).thenReturn("iloveyou");
    when(instance.userName()).thenReturn("janedoe");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).password();
    verify(instance).userName();
    ImmutableUserRegistrationRequest buildResult = builderResult.build();
    assertEquals("iloveyou", buildResult.password());
    assertEquals("janedoe", buildResult.userName());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UserRegistrationRequest)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UserRegistrationRequest)}
   */
  @Test
  @DisplayName("Test Builder from(UserRegistrationRequest); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UserRegistrationRequest)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableUserRegistrationRequest.builder();
    UserRegistrationRequest instance = mock(UserRegistrationRequest.class);
    when(instance.password()).thenThrow(new IllegalStateException("instance"));
    when(instance.userName()).thenReturn("janedoe");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).password();
    verify(instance).userName();
  }

  /**
   * Test Builder {@link Builder#password(String)}.
   * <p>
   * Method under test: {@link Builder#password(String)}
   */
  @Test
  @DisplayName("Test Builder password(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.password(String)"})
  void testBuilderPassword() {
    // Arrange
    Builder builderResult = ImmutableUserRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.password("iloveyou"));
  }

  /**
   * Test Builder {@link Builder#userName(String)}.
   * <p>
   * Method under test: {@link Builder#userName(String)}
   */
  @Test
  @DisplayName("Test Builder userName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.userName(String)"})
  void testBuilderUserName() {
    // Arrange
    Builder builderResult = ImmutableUserRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userName("janedoe"));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setPassword(String)}
   *   <li>{@link Json#setUserName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setPassword(String)", "void Json.setUserName(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setPassword("iloveyou");
    actualJson.setUserName("janedoe");

    // Assert
    assertEquals("iloveyou", actualJson.password);
    assertEquals("janedoe", actualJson.userName);
  }

  /**
   * Test Json {@link Json#password()}.
   * <p>
   * Method under test: {@link Json#password()}
   */
  @Test
  @DisplayName("Test Json password()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.password()"})
  void testJsonPassword() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).password());
  }

  /**
   * Test Json {@link Json#userName()}.
   * <p>
   * Method under test: {@link Json#userName()}
   */
  @Test
  @DisplayName("Test Json userName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.userName()"})
  void testJsonUserName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).userName());
  }
}
