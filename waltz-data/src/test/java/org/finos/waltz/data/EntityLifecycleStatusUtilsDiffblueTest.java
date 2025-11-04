package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.application.LifecyclePhase;
import org.junit.jupiter.api.Test;

class EntityLifecycleStatusUtilsDiffblueTest {
  /**
   * Method under test:
   * {@link EntityLifecycleStatusUtils#convertToIsRemovedFlags(Set)}
   */
  @Test
  void testConvertToIsRemovedFlags() {
    // Arrange and Act
    List<Boolean> actualConvertToIsRemovedFlagsResult = EntityLifecycleStatusUtils
        .convertToIsRemovedFlags(new HashSet<>());

    // Assert
    assertEquals(2, actualConvertToIsRemovedFlagsResult.size());
    assertFalse(actualConvertToIsRemovedFlagsResult.get(1));
    assertTrue(actualConvertToIsRemovedFlagsResult.get(0));
  }

  /**
   * Method under test:
   * {@link EntityLifecycleStatusUtils#convertToIsRemovedFlags(Set)}
   */
  @Test
  void testConvertToIsRemovedFlags2() {
    // Arrange
    HashSet<EntityLifecycleStatus> entityLifecycleStatuses = new HashSet<>();
    entityLifecycleStatuses.add(EntityLifecycleStatus.ACTIVE);

    // Act
    List<Boolean> actualConvertToIsRemovedFlagsResult = EntityLifecycleStatusUtils
        .convertToIsRemovedFlags(entityLifecycleStatuses);

    // Assert
    assertEquals(2, actualConvertToIsRemovedFlagsResult.size());
    assertFalse(actualConvertToIsRemovedFlagsResult.get(0));
    assertFalse(actualConvertToIsRemovedFlagsResult.get(1));
  }

  /**
   * Method under test:
   * {@link EntityLifecycleStatusUtils#convertToIsRemovedFlags(Set)}
   */
  @Test
  void testConvertToIsRemovedFlags3() {
    // Arrange
    HashSet<EntityLifecycleStatus> entityLifecycleStatuses = new HashSet<>();
    entityLifecycleStatuses.add(EntityLifecycleStatus.PENDING);
    entityLifecycleStatuses.add(EntityLifecycleStatus.ACTIVE);

    // Act
    List<Boolean> actualConvertToIsRemovedFlagsResult = EntityLifecycleStatusUtils
        .convertToIsRemovedFlags(entityLifecycleStatuses);

    // Assert
    assertEquals(2, actualConvertToIsRemovedFlagsResult.size());
    assertFalse(actualConvertToIsRemovedFlagsResult.get(0));
    assertFalse(actualConvertToIsRemovedFlagsResult.get(1));
  }

  /**
   * Method under test:
   * {@link EntityLifecycleStatusUtils#convertToIsRemovedFlags(Set)}
   */
  @Test
  void testConvertToIsRemovedFlags4() {
    // Arrange
    HashSet<EntityLifecycleStatus> entityLifecycleStatuses = new HashSet<>();
    entityLifecycleStatuses.add(EntityLifecycleStatus.PENDING);

    // Act
    List<Boolean> actualConvertToIsRemovedFlagsResult = EntityLifecycleStatusUtils
        .convertToIsRemovedFlags(entityLifecycleStatuses);

    // Assert
    assertEquals(2, actualConvertToIsRemovedFlagsResult.size());
    assertFalse(actualConvertToIsRemovedFlagsResult.get(0));
    assertFalse(actualConvertToIsRemovedFlagsResult.get(1));
  }

  /**
   * Method under test:
   * {@link EntityLifecycleStatusUtils#convertToLifecyclePhases(Collection)}
   */
  @Test
  void testConvertToLifecyclePhases() {
    // Arrange and Act
    List<LifecyclePhase> actualConvertToLifecyclePhasesResult = EntityLifecycleStatusUtils
        .convertToLifecyclePhases(new ArrayList<>());

    // Assert
    assertTrue(actualConvertToLifecyclePhasesResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link EntityLifecycleStatusUtils#convertToLifecyclePhases(Collection)}
   */
  @Test
  void testConvertToLifecyclePhases2() {
    // Arrange
    ArrayList<EntityLifecycleStatus> entityLifecycleStatuses = new ArrayList<>();
    entityLifecycleStatuses.add(EntityLifecycleStatus.ACTIVE);

    // Act
    List<LifecyclePhase> actualConvertToLifecyclePhasesResult = EntityLifecycleStatusUtils
        .convertToLifecyclePhases(entityLifecycleStatuses);

    // Assert
    assertEquals(2, actualConvertToLifecyclePhasesResult.size());
    assertEquals(LifecyclePhase.DEVELOPMENT, actualConvertToLifecyclePhasesResult.get(0));
    assertEquals(LifecyclePhase.PRODUCTION, actualConvertToLifecyclePhasesResult.get(1));
  }

  /**
   * Method under test:
   * {@link EntityLifecycleStatusUtils#convertToLifecyclePhases(Collection)}
   */
  @Test
  void testConvertToLifecyclePhases3() {
    // Arrange
    ArrayList<EntityLifecycleStatus> entityLifecycleStatuses = new ArrayList<>();
    entityLifecycleStatuses.add(EntityLifecycleStatus.PENDING);
    entityLifecycleStatuses.add(EntityLifecycleStatus.ACTIVE);

    // Act
    List<LifecyclePhase> actualConvertToLifecyclePhasesResult = EntityLifecycleStatusUtils
        .convertToLifecyclePhases(entityLifecycleStatuses);

    // Assert
    assertEquals(3, actualConvertToLifecyclePhasesResult.size());
    assertEquals(LifecyclePhase.CONCEPTUAL, actualConvertToLifecyclePhasesResult.get(2));
    assertEquals(LifecyclePhase.DEVELOPMENT, actualConvertToLifecyclePhasesResult.get(0));
    assertEquals(LifecyclePhase.PRODUCTION, actualConvertToLifecyclePhasesResult.get(1));
  }

  /**
   * Method under test:
   * {@link EntityLifecycleStatusUtils#convertToLifecyclePhases(Collection)}
   */
  @Test
  void testConvertToLifecyclePhases4() {
    // Arrange
    ArrayList<EntityLifecycleStatus> entityLifecycleStatuses = new ArrayList<>();
    entityLifecycleStatuses.add(EntityLifecycleStatus.REMOVED);

    // Act
    List<LifecyclePhase> actualConvertToLifecyclePhasesResult = EntityLifecycleStatusUtils
        .convertToLifecyclePhases(entityLifecycleStatuses);

    // Assert
    assertEquals(1, actualConvertToLifecyclePhasesResult.size());
    assertEquals(LifecyclePhase.RETIRED, actualConvertToLifecyclePhasesResult.get(0));
  }
}
