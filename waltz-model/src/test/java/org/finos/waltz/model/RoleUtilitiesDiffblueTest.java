package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.finos.waltz.model.user.SystemRole;
import org.junit.jupiter.api.Test;

class RoleUtilitiesDiffblueTest {
  /**
   * Method under test:
   * {@link RoleUtilities#getRequiredRoleForEntityKind(EntityKind)}
   */
  @Test
  void testGetRequiredRoleForEntityKind() {
    // Arrange, Act and Assert
    assertEquals(SystemRole.ADMIN, RoleUtilities.getRequiredRoleForEntityKind(EntityKind.ALL));
    assertEquals(SystemRole.ACTOR_ADMIN, RoleUtilities.getRequiredRoleForEntityKind(EntityKind.ACTOR));
    assertEquals(SystemRole.APP_EDITOR, RoleUtilities.getRequiredRoleForEntityKind(EntityKind.APPLICATION));
    assertEquals(SystemRole.CHANGE_INITIATIVE_EDITOR,
        RoleUtilities.getRequiredRoleForEntityKind(EntityKind.CHANGE_INITIATIVE));
    assertEquals(SystemRole.ADMIN,
        RoleUtilities.getRequiredRoleForEntityKind(EntityKind.ALL, Operation.ADD, EntityKind.ALL));
    assertEquals(SystemRole.ACTOR_ADMIN,
        RoleUtilities.getRequiredRoleForEntityKind(EntityKind.ACTOR, Operation.ADD, EntityKind.ALL));
    assertEquals(SystemRole.APP_EDITOR,
        RoleUtilities.getRequiredRoleForEntityKind(EntityKind.APPLICATION, Operation.ADD, EntityKind.ALL));
    assertEquals(SystemRole.CHANGE_INITIATIVE_EDITOR,
        RoleUtilities.getRequiredRoleForEntityKind(EntityKind.CHANGE_INITIATIVE, Operation.ADD, EntityKind.ALL));
  }
}
