package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SurveyInstancePermissionsDiffblueTest {
  /**
   * Test {@link SurveyInstancePermissions#isAdmin()}.
   *
   * <p>Method under test: {@link SurveyInstancePermissions#isAdmin()}
   */
  @Test
  @DisplayName("Test isAdmin()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstancePermissions.isAdmin()"})
  void testIsAdmin() {
    // Arrange, Act and Assert
    assertFalse(ImmutableSurveyInstancePermissions.builder().build().isAdmin());
  }

  /**
   * Test {@link SurveyInstancePermissions#isOwner()}.
   *
   * <p>Method under test: {@link SurveyInstancePermissions#isOwner()}
   */
  @Test
  @DisplayName("Test isOwner()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstancePermissions.isOwner()"})
  void testIsOwner() {
    // Arrange, Act and Assert
    assertFalse(ImmutableSurveyInstancePermissions.builder().build().isOwner());
  }

  /**
   * Test {@link SurveyInstancePermissions#hasOwnerRole()}.
   *
   * <p>Method under test: {@link SurveyInstancePermissions#hasOwnerRole()}
   */
  @Test
  @DisplayName("Test hasOwnerRole()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstancePermissions.hasOwnerRole()"})
  void testHasOwnerRole() {
    // Arrange, Act and Assert
    assertFalse(ImmutableSurveyInstancePermissions.builder().build().hasOwnerRole());
  }

  /**
   * Test {@link SurveyInstancePermissions#hasOwnership()}.
   *
   * <ul>
   *   <li>Given builder build.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstancePermissions#hasOwnership()}
   */
  @Test
  @DisplayName("Test hasOwnership(); given builder build; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstancePermissions.hasOwnership()"})
  void testHasOwnership_givenBuilderBuild_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ImmutableSurveyInstancePermissions.builder().build().hasOwnership());
  }

  /**
   * Test {@link SurveyInstancePermissions#isParticipant()}.
   *
   * <p>Method under test: {@link SurveyInstancePermissions#isParticipant()}
   */
  @Test
  @DisplayName("Test isParticipant()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstancePermissions.isParticipant()"})
  void testIsParticipant() {
    // Arrange, Act and Assert
    assertFalse(ImmutableSurveyInstancePermissions.builder().build().isParticipant());
  }

  /**
   * Test {@link SurveyInstancePermissions#isMetaEdit()}.
   *
   * <p>Method under test: {@link SurveyInstancePermissions#isMetaEdit()}
   */
  @Test
  @DisplayName("Test isMetaEdit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstancePermissions.isMetaEdit()"})
  void testIsMetaEdit() {
    // Arrange, Act and Assert
    assertFalse(ImmutableSurveyInstancePermissions.builder().build().isMetaEdit());
  }

  /**
   * Test {@link SurveyInstancePermissions#canEdit()}.
   *
   * <p>Method under test: {@link SurveyInstancePermissions#canEdit()}
   */
  @Test
  @DisplayName("Test canEdit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstancePermissions.canEdit()"})
  void testCanEdit() {
    // Arrange, Act and Assert
    assertFalse(ImmutableSurveyInstancePermissions.builder().build().canEdit());
  }
}
