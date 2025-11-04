package org.finos.waltz.model.user;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

class UserDiffblueTest {
  /**
   * Method under test: {@link User#hasRole(String)}
   */
  @Test
  void testHasRole() {
    // Arrange, Act and Assert
    assertFalse(UserUtilities.ANONYMOUS_USER.hasRole(null));
    assertFalse(UserUtilities.ANONYMOUS_USER.hasRole("Role"));
  }
}
