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
   * <ul>
   *   <li>Given builder build.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstancePermissions#isAdmin()}
   */
  @Test
  @DisplayName("Test isAdmin(); given builder build; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstancePermissions.isAdmin()"})
  void testIsAdmin_givenBuilderBuild_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ImmutableSurveyInstancePermissions.builder().build().isAdmin());
  }

  /**
   * Test {@link SurveyInstancePermissions#isOwner()}.
   *
   * <ul>
   *   <li>Given builder build.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstancePermissions#isOwner()}
   */
  @Test
  @DisplayName("Test isOwner(); given builder build; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstancePermissions.isOwner()"})
  void testIsOwner_givenBuilderBuild_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ImmutableSurveyInstancePermissions.builder().build().isOwner());
  }

  /**
   * Test {@link SurveyInstancePermissions#hasOwnerRole()}.
   *
   * <ul>
   *   <li>Given builder build.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstancePermissions#hasOwnerRole()}
   */
  @Test
  @DisplayName("Test hasOwnerRole(); given builder build; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstancePermissions.hasOwnerRole()"})
  void testHasOwnerRole_givenBuilderBuild_thenReturnFalse() {
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
   * <ul>
   *   <li>Given builder build.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstancePermissions#isParticipant()}
   */
  @Test
  @DisplayName("Test isParticipant(); given builder build; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstancePermissions.isParticipant()"})
  void testIsParticipant_givenBuilderBuild_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ImmutableSurveyInstancePermissions.builder().build().isParticipant());
  }

  /**
   * Test {@link SurveyInstancePermissions#isMetaEdit()}.
   *
   * <ul>
   *   <li>Given builder build.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstancePermissions#isMetaEdit()}
   */
  @Test
  @DisplayName("Test isMetaEdit(); given builder build; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstancePermissions.isMetaEdit()"})
  void testIsMetaEdit_givenBuilderBuild_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ImmutableSurveyInstancePermissions.builder().build().isMetaEdit());
  }

  /**
   * Test {@link SurveyInstancePermissions#canEdit()}.
   *
   * <ul>
   *   <li>Given builder build.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstancePermissions#canEdit()}
   */
  @Test
  @DisplayName("Test canEdit(); given builder build; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyInstancePermissions.canEdit()"})
  void testCanEdit_givenBuilderBuild_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ImmutableSurveyInstancePermissions.builder().build().canEdit());
  }
}
