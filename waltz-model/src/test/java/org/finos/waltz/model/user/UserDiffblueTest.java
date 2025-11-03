package org.finos.waltz.model.user;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UserDiffblueTest {
  /**
   * Test {@link User#hasRole(String)}.
   * <ul>
   *   <li>Given {@link UserUtilities#ANONYMOUS_USER}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#hasRole(String)}
   */
  @Test
  @DisplayName("Test hasRole(String); given ANONYMOUS_USER; when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.hasRole(String)"})
  void testHasRole_givenAnonymous_user_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(UserUtilities.ANONYMOUS_USER.hasRole(null));
  }

  /**
   * Test {@link User#hasRole(String)}.
   * <ul>
   *   <li>Given {@link UserUtilities#ANONYMOUS_USER}.</li>
   *   <li>When {@code Role}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link User#hasRole(String)}
   */
  @Test
  @DisplayName("Test hasRole(String); given ANONYMOUS_USER; when 'Role'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean User.hasRole(String)"})
  void testHasRole_givenAnonymous_user_whenRole_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(UserUtilities.ANONYMOUS_USER.hasRole("Role"));
  }
}
