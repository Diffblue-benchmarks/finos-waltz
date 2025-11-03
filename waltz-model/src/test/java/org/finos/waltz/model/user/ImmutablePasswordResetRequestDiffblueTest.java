package org.finos.waltz.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.user.ImmutablePasswordResetRequest.Builder;
import org.finos.waltz.model.user.ImmutablePasswordResetRequest.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePasswordResetRequestDiffblueTest {
  /**
   * Test {@link ImmutablePasswordResetRequest#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePasswordResetRequest#builder()}
   *   <li>{@link ImmutablePasswordResetRequest#currentPassword(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutablePasswordResetRequest Builder.build()", "Builder Builder.currentPassword(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutablePasswordResetRequest.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.currentPassword("iloveyou"));
  }

  /**
   * Test Builder {@link Builder#from(PasswordResetRequest)}.
   * <ul>
   *   <li>Then builder build currentPassword is {@code iloveyou}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PasswordResetRequest)}
   */
  @Test
  @DisplayName("Test Builder from(PasswordResetRequest); then builder build currentPassword is 'iloveyou'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PasswordResetRequest)"})
  void testBuilderFrom_thenBuilderBuildCurrentPasswordIsIloveyou() {
    // Arrange
    Builder builderResult = ImmutablePasswordResetRequest.builder();
    PasswordResetRequest instance = mock(PasswordResetRequest.class);
    when(instance.currentPassword()).thenReturn("iloveyou");
    when(instance.newPassword()).thenReturn("iloveyou");
    when(instance.userName()).thenReturn("janedoe");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).currentPassword();
    verify(instance).newPassword();
    verify(instance).userName();
    ImmutablePasswordResetRequest buildResult = builderResult.build();
    assertEquals("iloveyou", buildResult.currentPassword());
    assertEquals("iloveyou", buildResult.newPassword());
    assertEquals("janedoe", buildResult.userName());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PasswordResetRequest)}.
   * <ul>
   *   <li>Then builder build currentPassword is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PasswordResetRequest)}
   */
  @Test
  @DisplayName("Test Builder from(PasswordResetRequest); then builder build currentPassword is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PasswordResetRequest)"})
  void testBuilderFrom_thenBuilderBuildCurrentPasswordIsNull() {
    // Arrange
    Builder builderResult = ImmutablePasswordResetRequest.builder();
    PasswordResetRequest instance = mock(PasswordResetRequest.class);
    when(instance.currentPassword()).thenReturn(null);
    when(instance.newPassword()).thenReturn("iloveyou");
    when(instance.userName()).thenReturn("janedoe");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).currentPassword();
    verify(instance).newPassword();
    verify(instance).userName();
    ImmutablePasswordResetRequest buildResult = builderResult.build();
    assertEquals("iloveyou", buildResult.newPassword());
    assertEquals("janedoe", buildResult.userName());
    assertNull(buildResult.currentPassword());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PasswordResetRequest)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PasswordResetRequest)}
   */
  @Test
  @DisplayName("Test Builder from(PasswordResetRequest); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PasswordResetRequest)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePasswordResetRequest.builder();
    PasswordResetRequest instance = mock(PasswordResetRequest.class);
    when(instance.currentPassword()).thenThrow(new IllegalStateException("instance"));
    when(instance.userName()).thenReturn("janedoe");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).currentPassword();
    verify(instance).userName();
  }

  /**
   * Test Builder {@link Builder#newPassword(String)}.
   * <p>
   * Method under test: {@link Builder#newPassword(String)}
   */
  @Test
  @DisplayName("Test Builder newPassword(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.newPassword(String)"})
  void testBuilderNewPassword() {
    // Arrange
    Builder builderResult = ImmutablePasswordResetRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.newPassword("iloveyou"));
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
    Builder builderResult = ImmutablePasswordResetRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userName("janedoe"));
  }

  /**
   * Test Json {@link Json#currentPassword()}.
   * <p>
   * Method under test: {@link Json#currentPassword()}
   */
  @Test
  @DisplayName("Test Json currentPassword()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.currentPassword()"})
  void testJsonCurrentPassword() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).currentPassword());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCurrentPassword(String)}
   *   <li>{@link Json#setNewPassword(String)}
   *   <li>{@link Json#setUserName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setCurrentPassword(String)", "void Json.setNewPassword(String)",
      "void Json.setUserName(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCurrentPassword("iloveyou");
    actualJson.setNewPassword("iloveyou");
    actualJson.setUserName("janedoe");

    // Assert
    assertEquals("iloveyou", actualJson.currentPassword);
    assertEquals("iloveyou", actualJson.newPassword);
    assertEquals("janedoe", actualJson.userName);
  }

  /**
   * Test Json {@link Json#newPassword()}.
   * <p>
   * Method under test: {@link Json#newPassword()}
   */
  @Test
  @DisplayName("Test Json newPassword()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.newPassword()"})
  void testJsonNewPassword() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).newPassword());
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
