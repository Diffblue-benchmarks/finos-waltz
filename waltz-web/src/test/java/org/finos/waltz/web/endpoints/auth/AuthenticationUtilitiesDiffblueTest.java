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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spark.Request;

class AuthenticationUtilitiesDiffblueTest {
  /**
   * Method under test:
   * {@link AuthenticationUtilities#setUserAsAnonymous(Request)}
   */
  @Test
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
   * Method under test: {@link AuthenticationUtilities#setUser(Request, String)}
   */
  @Test
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
   * Method under test: {@link AuthenticationUtilities#getUsername(Request)}
   */
  @Test
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
   * Method under test: {@link AuthenticationUtilities#isAnonymous(Request)}
   */
  @Test
  void testIsAnonymous() {
    // Arrange
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    boolean actualIsAnonymousResult = AuthenticationUtilities.isAnonymous(request);

    // Assert
    verify(request).attribute(eq("waltz-user"));
    assertFalse(actualIsAnonymousResult);
  }

  /**
   * Method under test: {@link AuthenticationUtilities#isAnonymous(Request)}
   */
  @Test
  void testIsAnonymous2() {
    // Arrange
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("anonymous");

    // Act
    boolean actualIsAnonymousResult = AuthenticationUtilities.isAnonymous(request);

    // Assert
    verify(request).attribute(eq("waltz-user"));
    assertTrue(actualIsAnonymousResult);
  }
}
