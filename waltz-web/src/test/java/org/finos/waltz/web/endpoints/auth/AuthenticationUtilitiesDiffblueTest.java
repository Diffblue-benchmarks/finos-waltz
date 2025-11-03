package org.finos.waltz.web.endpoints.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spark.Request;

class AuthenticationUtilitiesDiffblueTest {
  /**
   * Test {@link AuthenticationUtilities#setUserAsAnonymous(Request)}.
   * <p>
   * Method under test: {@link AuthenticationUtilities#setUserAsAnonymous(Request)}
   */
  @Test
  @DisplayName("Test setUserAsAnonymous(Request)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AuthenticationUtilities.setUserAsAnonymous(Request)"})
  void testSetUserAsAnonymous() {
    // Arrange
    Request request = mock(Request.class);
    doNothing().when(request).attribute(Mockito.<String>any(), Mockito.<Object>any());

    // Act
    AuthenticationUtilities.setUserAsAnonymous(request);

    // Assert
    verify(request).attribute(eq("waltz-user"), isA(Object.class));
  }

  /**
   * Test {@link AuthenticationUtilities#setUser(Request, String)}.
   * <p>
   * Method under test: {@link AuthenticationUtilities#setUser(Request, String)}
   */
  @Test
  @DisplayName("Test setUser(Request, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AuthenticationUtilities.setUser(Request, String)"})
  void testSetUser() {
    // Arrange
    Request request = mock(Request.class);
    doNothing().when(request).attribute(Mockito.<String>any(), Mockito.<Object>any());

    // Act
    AuthenticationUtilities.setUser(request, "User");

    // Assert
    verify(request).attribute(eq("waltz-user"), isA(Object.class));
  }

  /**
   * Test {@link AuthenticationUtilities#getUsername(Request)}.
   * <p>
   * Method under test: {@link AuthenticationUtilities#getUsername(Request)}
   */
  @Test
  @DisplayName("Test getUsername(Request)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AuthenticationUtilities.getUsername(Request)"})
  void testGetUsername() {
    // Arrange
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    String actualUsername = AuthenticationUtilities.getUsername(request);

    // Assert
    verify(request).attribute(eq("waltz-user"));
    assertEquals("Attribute", actualUsername);
  }

  /**
   * Test {@link AuthenticationUtilities#isAnonymous(Request)}.
   * <ul>
   *   <li>Given {@code anonymous}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuthenticationUtilities#isAnonymous(Request)}
   */
  @Test
  @DisplayName("Test isAnonymous(Request); given 'anonymous'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuthenticationUtilities.isAnonymous(Request)"})
  void testIsAnonymous_givenAnonymous_thenReturnTrue() {
    // Arrange
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("anonymous");

    // Act
    boolean actualIsAnonymousResult = AuthenticationUtilities.isAnonymous(request);

    // Assert
    verify(request).attribute(eq("waltz-user"));
    assertTrue(actualIsAnonymousResult);
  }

  /**
   * Test {@link AuthenticationUtilities#isAnonymous(Request)}.
   * <ul>
   *   <li>Given {@code Attribute}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuthenticationUtilities#isAnonymous(Request)}
   */
  @Test
  @DisplayName("Test isAnonymous(Request); given 'Attribute'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuthenticationUtilities.isAnonymous(Request)"})
  void testIsAnonymous_givenAttribute_thenReturnFalse() {
    // Arrange
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    boolean actualIsAnonymousResult = AuthenticationUtilities.isAnonymous(request);

    // Assert
    verify(request).attribute(eq("waltz-user"));
    assertFalse(actualIsAnonymousResult);
  }
}
