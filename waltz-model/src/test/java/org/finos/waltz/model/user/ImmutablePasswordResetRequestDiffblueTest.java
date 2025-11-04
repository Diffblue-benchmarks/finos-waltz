package org.finos.waltz.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutablePasswordResetRequestDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePasswordResetRequest#builder()}
   *   <li>{@link ImmutablePasswordResetRequest#currentPassword(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutablePasswordResetRequest.Builder actualBuilderResult = ImmutablePasswordResetRequest.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.currentPassword("iloveyou"));
  }

  /**
   * Method under test:
   * {@link ImmutablePasswordResetRequest.Builder#from(PasswordResetRequest)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePasswordResetRequest.Builder builderResult = ImmutablePasswordResetRequest.builder();
    PasswordResetRequest instance = mock(PasswordResetRequest.class);
    when(instance.currentPassword()).thenReturn("iloveyou");
    when(instance.newPassword()).thenReturn("iloveyou");
    when(instance.userName()).thenReturn("janedoe");

    // Act
    ImmutablePasswordResetRequest.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutablePasswordResetRequest.Builder#from(PasswordResetRequest)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePasswordResetRequest.Builder builderResult = ImmutablePasswordResetRequest.builder();
    PasswordResetRequest instance = mock(PasswordResetRequest.class);
    when(instance.currentPassword()).thenThrow(new IllegalStateException("instance"));
    when(instance.userName()).thenReturn("janedoe");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).currentPassword();
    verify(instance).userName();
  }

  /**
   * Method under test:
   * {@link ImmutablePasswordResetRequest.Builder#from(PasswordResetRequest)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutablePasswordResetRequest.Builder builderResult = ImmutablePasswordResetRequest.builder();
    PasswordResetRequest instance = mock(PasswordResetRequest.class);
    when(instance.currentPassword()).thenReturn(null);
    when(instance.newPassword()).thenReturn("iloveyou");
    when(instance.userName()).thenReturn("janedoe");

    // Act
    ImmutablePasswordResetRequest.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutablePasswordResetRequest.Builder#newPassword(String)}
   */
  @Test
  void testBuilderNewPassword() {
    // Arrange
    ImmutablePasswordResetRequest.Builder builderResult = ImmutablePasswordResetRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.newPassword("iloveyou"));
  }

  /**
   * Method under test:
   * {@link ImmutablePasswordResetRequest.Builder#userName(String)}
   */
  @Test
  void testBuilderUserName() {
    // Arrange
    ImmutablePasswordResetRequest.Builder builderResult = ImmutablePasswordResetRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userName("janedoe"));
  }

  /**
   * Method under test:
   * {@link ImmutablePasswordResetRequest#copyOf(PasswordResetRequest)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PasswordResetRequest instance = mock(PasswordResetRequest.class);
    when(instance.currentPassword()).thenReturn("iloveyou");
    when(instance.newPassword()).thenReturn("iloveyou");
    when(instance.userName()).thenReturn("janedoe");

    // Act
    ImmutablePasswordResetRequest actualCopyOfResult = ImmutablePasswordResetRequest.copyOf(instance);

    // Assert
    verify(instance).currentPassword();
    verify(instance).newPassword();
    verify(instance).userName();
    assertEquals("iloveyou", actualCopyOfResult.currentPassword());
    assertEquals("iloveyou", actualCopyOfResult.newPassword());
    assertEquals("janedoe", actualCopyOfResult.userName());
  }

  /**
   * Method under test:
   * {@link ImmutablePasswordResetRequest#fromJson(ImmutablePasswordResetRequest.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutablePasswordResetRequest.Json json = new ImmutablePasswordResetRequest.Json();
    json.setUserName("Json");
    json.setCurrentPassword(null);
    json.setNewPassword("Json");

    // Act
    ImmutablePasswordResetRequest actualFromJsonResult = ImmutablePasswordResetRequest.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.newPassword());
    assertEquals("Json", actualFromJsonResult.userName());
    assertNull(actualFromJsonResult.currentPassword());
  }

  /**
   * Method under test:
   * {@link ImmutablePasswordResetRequest.Json#currentPassword()}
   */
  @Test
  void testJsonCurrentPassword() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePasswordResetRequest.Json()).currentPassword());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutablePasswordResetRequest.Json}
   *   <li>{@link ImmutablePasswordResetRequest.Json#setCurrentPassword(String)}
   *   <li>{@link ImmutablePasswordResetRequest.Json#setNewPassword(String)}
   *   <li>{@link ImmutablePasswordResetRequest.Json#setUserName(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutablePasswordResetRequest.Json actualJson = new ImmutablePasswordResetRequest.Json();
    actualJson.setCurrentPassword("iloveyou");
    actualJson.setNewPassword("iloveyou");
    actualJson.setUserName("janedoe");

    // Assert
    assertEquals("iloveyou", actualJson.currentPassword);
    assertEquals("iloveyou", actualJson.newPassword);
    assertEquals("janedoe", actualJson.userName);
  }

  /**
   * Method under test: {@link ImmutablePasswordResetRequest.Json#newPassword()}
   */
  @Test
  void testJsonNewPassword() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePasswordResetRequest.Json()).newPassword());
  }

  /**
   * Method under test: {@link ImmutablePasswordResetRequest.Json#userName()}
   */
  @Test
  void testJsonUserName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePasswordResetRequest.Json()).userName());
  }
}
