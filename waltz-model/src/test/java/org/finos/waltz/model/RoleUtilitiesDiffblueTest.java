package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.user.SystemRole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RoleUtilitiesDiffblueTest {
  /**
   * Test {@link RoleUtilities#getRequiredRoleForEntityKind(EntityKind, Operation, EntityKind)} with
   * {@code kind}, {@code op}, {@code additionalKind}.
   *
   * <p>Method under test: {@link RoleUtilities#getRequiredRoleForEntityKind(EntityKind, Operation,
   * EntityKind)}
   */
  @Test
  @DisplayName(
      "Test getRequiredRoleForEntityKind(EntityKind, Operation, EntityKind) with 'kind', 'op', 'additionalKind'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SystemRole RoleUtilities.getRequiredRoleForEntityKind(EntityKind, Operation, EntityKind)"
  })
  void testGetRequiredRoleForEntityKindWithKindOpAdditionalKind() {
    // Arrange, Act and Assert
    assertEquals(
        SystemRole.CHANGE_INITIATIVE_EDITOR,
        RoleUtilities.getRequiredRoleForEntityKind(
            EntityKind.CHANGE_INITIATIVE, Operation.ADD, EntityKind.ALL));
  }

  /**
   * Test {@link RoleUtilities#getRequiredRoleForEntityKind(EntityKind, Operation, EntityKind)} with
   * {@code kind}, {@code op}, {@code additionalKind}.
   *
   * <ul>
   *   <li>Then return {@code ACTOR_ADMIN}.
   * </ul>
   *
   * <p>Method under test: {@link RoleUtilities#getRequiredRoleForEntityKind(EntityKind, Operation,
   * EntityKind)}
   */
  @Test
  @DisplayName(
      "Test getRequiredRoleForEntityKind(EntityKind, Operation, EntityKind) with 'kind', 'op', 'additionalKind'; then return 'ACTOR_ADMIN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SystemRole RoleUtilities.getRequiredRoleForEntityKind(EntityKind, Operation, EntityKind)"
  })
  void testGetRequiredRoleForEntityKindWithKindOpAdditionalKind_thenReturnActorAdmin() {
    // Arrange, Act and Assert
    assertEquals(
        SystemRole.ACTOR_ADMIN,
        RoleUtilities.getRequiredRoleForEntityKind(
            EntityKind.ACTOR, Operation.ADD, EntityKind.ALL));
  }

  /**
   * Test {@link RoleUtilities#getRequiredRoleForEntityKind(EntityKind, Operation, EntityKind)} with
   * {@code kind}, {@code op}, {@code additionalKind}.
   *
   * <ul>
   *   <li>Then return {@code APP_EDITOR}.
   * </ul>
   *
   * <p>Method under test: {@link RoleUtilities#getRequiredRoleForEntityKind(EntityKind, Operation,
   * EntityKind)}
   */
  @Test
  @DisplayName(
      "Test getRequiredRoleForEntityKind(EntityKind, Operation, EntityKind) with 'kind', 'op', 'additionalKind'; then return 'APP_EDITOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SystemRole RoleUtilities.getRequiredRoleForEntityKind(EntityKind, Operation, EntityKind)"
  })
  void testGetRequiredRoleForEntityKindWithKindOpAdditionalKind_thenReturnAppEditor() {
    // Arrange, Act and Assert
    assertEquals(
        SystemRole.APP_EDITOR,
        RoleUtilities.getRequiredRoleForEntityKind(
            EntityKind.APPLICATION, Operation.ADD, EntityKind.ALL));
  }

  /**
   * Test {@link RoleUtilities#getRequiredRoleForEntityKind(EntityKind, Operation, EntityKind)} with
   * {@code kind}, {@code op}, {@code additionalKind}.
   *
   * <ul>
   *   <li>When {@code ALL}.
   *   <li>Then return {@code ADMIN}.
   * </ul>
   *
   * <p>Method under test: {@link RoleUtilities#getRequiredRoleForEntityKind(EntityKind, Operation,
   * EntityKind)}
   */
  @Test
  @DisplayName(
      "Test getRequiredRoleForEntityKind(EntityKind, Operation, EntityKind) with 'kind', 'op', 'additionalKind'; when 'ALL'; then return 'ADMIN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SystemRole RoleUtilities.getRequiredRoleForEntityKind(EntityKind, Operation, EntityKind)"
  })
  void testGetRequiredRoleForEntityKindWithKindOpAdditionalKind_whenAll_thenReturnAdmin() {
    // Arrange, Act and Assert
    assertEquals(
        SystemRole.ADMIN,
        RoleUtilities.getRequiredRoleForEntityKind(EntityKind.ALL, Operation.ADD, EntityKind.ALL));
  }

  /**
   * Test {@link RoleUtilities#getRequiredRoleForEntityKind(EntityKind)} with {@code kind}.
   *
   * <ul>
   *   <li>Then return {@code CHANGE_INITIATIVE_EDITOR}.
   * </ul>
   *
   * <p>Method under test: {@link RoleUtilities#getRequiredRoleForEntityKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test getRequiredRoleForEntityKind(EntityKind) with 'kind'; then return 'CHANGE_INITIATIVE_EDITOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemRole RoleUtilities.getRequiredRoleForEntityKind(EntityKind)"})
  void testGetRequiredRoleForEntityKindWithKind_thenReturnChangeInitiativeEditor() {
    // Arrange, Act and Assert
    assertEquals(
        SystemRole.CHANGE_INITIATIVE_EDITOR,
        RoleUtilities.getRequiredRoleForEntityKind(EntityKind.CHANGE_INITIATIVE));
  }

  /**
   * Test {@link RoleUtilities#getRequiredRoleForEntityKind(EntityKind)} with {@code kind}.
   *
   * <ul>
   *   <li>When {@code ACTOR}.
   *   <li>Then return {@code ACTOR_ADMIN}.
   * </ul>
   *
   * <p>Method under test: {@link RoleUtilities#getRequiredRoleForEntityKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test getRequiredRoleForEntityKind(EntityKind) with 'kind'; when 'ACTOR'; then return 'ACTOR_ADMIN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemRole RoleUtilities.getRequiredRoleForEntityKind(EntityKind)"})
  void testGetRequiredRoleForEntityKindWithKind_whenActor_thenReturnActorAdmin() {
    // Arrange, Act and Assert
    assertEquals(
        SystemRole.ACTOR_ADMIN, RoleUtilities.getRequiredRoleForEntityKind(EntityKind.ACTOR));
  }

  /**
   * Test {@link RoleUtilities#getRequiredRoleForEntityKind(EntityKind)} with {@code kind}.
   *
   * <ul>
   *   <li>When {@code ALL}.
   *   <li>Then return {@code ADMIN}.
   * </ul>
   *
   * <p>Method under test: {@link RoleUtilities#getRequiredRoleForEntityKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test getRequiredRoleForEntityKind(EntityKind) with 'kind'; when 'ALL'; then return 'ADMIN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemRole RoleUtilities.getRequiredRoleForEntityKind(EntityKind)"})
  void testGetRequiredRoleForEntityKindWithKind_whenAll_thenReturnAdmin() {
    // Arrange, Act and Assert
    assertEquals(SystemRole.ADMIN, RoleUtilities.getRequiredRoleForEntityKind(EntityKind.ALL));
  }

  /**
   * Test {@link RoleUtilities#getRequiredRoleForEntityKind(EntityKind)} with {@code kind}.
   *
   * <ul>
   *   <li>When {@code APPLICATION}.
   *   <li>Then return {@code APP_EDITOR}.
   * </ul>
   *
   * <p>Method under test: {@link RoleUtilities#getRequiredRoleForEntityKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test getRequiredRoleForEntityKind(EntityKind) with 'kind'; when 'APPLICATION'; then return 'APP_EDITOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemRole RoleUtilities.getRequiredRoleForEntityKind(EntityKind)"})
  void testGetRequiredRoleForEntityKindWithKind_whenApplication_thenReturnAppEditor() {
    // Arrange, Act and Assert
    assertEquals(
        SystemRole.APP_EDITOR, RoleUtilities.getRequiredRoleForEntityKind(EntityKind.APPLICATION));
  }
}
