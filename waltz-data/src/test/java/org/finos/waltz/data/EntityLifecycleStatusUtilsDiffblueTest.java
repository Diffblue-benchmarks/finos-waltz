package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.application.LifecyclePhase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityLifecycleStatusUtilsDiffblueTest {
  /**
   * Test {@link EntityLifecycleStatusUtils#convertToIsRemovedFlags(Set)}.
   * <ul>
   *   <li>Given {@code ACTIVE}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code ACTIVE}.</li>
   *   <li>Then return not first.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLifecycleStatusUtils#convertToIsRemovedFlags(Set)}
   */
  @Test
  @DisplayName("Test convertToIsRemovedFlags(Set); given 'ACTIVE'; when HashSet() add 'ACTIVE'; then return not first")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List EntityLifecycleStatusUtils.convertToIsRemovedFlags(Set)"})
  void testConvertToIsRemovedFlags_givenActive_whenHashSetAddActive_thenReturnNotFirst() {
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
   * Test {@link EntityLifecycleStatusUtils#convertToIsRemovedFlags(Set)}.
   * <ul>
   *   <li>Given {@code PENDING}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code PENDING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLifecycleStatusUtils#convertToIsRemovedFlags(Set)}
   */
  @Test
  @DisplayName("Test convertToIsRemovedFlags(Set); given 'PENDING'; when HashSet() add 'PENDING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List EntityLifecycleStatusUtils.convertToIsRemovedFlags(Set)"})
  void testConvertToIsRemovedFlags_givenPending_whenHashSetAddPending() {
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
   * Test {@link EntityLifecycleStatusUtils#convertToIsRemovedFlags(Set)}.
   * <ul>
   *   <li>Given {@code PENDING}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code PENDING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLifecycleStatusUtils#convertToIsRemovedFlags(Set)}
   */
  @Test
  @DisplayName("Test convertToIsRemovedFlags(Set); given 'PENDING'; when HashSet() add 'PENDING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List EntityLifecycleStatusUtils.convertToIsRemovedFlags(Set)"})
  void testConvertToIsRemovedFlags_givenPending_whenHashSetAddPending2() {
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
   * Test {@link EntityLifecycleStatusUtils#convertToIsRemovedFlags(Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return first.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLifecycleStatusUtils#convertToIsRemovedFlags(Set)}
   */
  @Test
  @DisplayName("Test convertToIsRemovedFlags(Set); when HashSet(); then return first")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List EntityLifecycleStatusUtils.convertToIsRemovedFlags(Set)"})
  void testConvertToIsRemovedFlags_whenHashSet_thenReturnFirst() {
    // Arrange and Act
    List<Boolean> actualConvertToIsRemovedFlagsResult = EntityLifecycleStatusUtils
        .convertToIsRemovedFlags(new HashSet<>());

    // Assert
    assertEquals(2, actualConvertToIsRemovedFlagsResult.size());
    assertFalse(actualConvertToIsRemovedFlagsResult.get(1));
    assertTrue(actualConvertToIsRemovedFlagsResult.get(0));
  }

  /**
   * Test {@link EntityLifecycleStatusUtils#convertToLifecyclePhases(Collection)}.
   * <ul>
   *   <li>Given {@code ACTIVE}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLifecycleStatusUtils#convertToLifecyclePhases(Collection)}
   */
  @Test
  @DisplayName("Test convertToLifecyclePhases(Collection); given 'ACTIVE'; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List EntityLifecycleStatusUtils.convertToLifecyclePhases(Collection)"})
  void testConvertToLifecyclePhases_givenActive_thenReturnSizeIsTwo() {
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
   * Test {@link EntityLifecycleStatusUtils#convertToLifecyclePhases(Collection)}.
   * <ul>
   *   <li>Given {@code PENDING}.</li>
   *   <li>Then return size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLifecycleStatusUtils#convertToLifecyclePhases(Collection)}
   */
  @Test
  @DisplayName("Test convertToLifecyclePhases(Collection); given 'PENDING'; then return size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List EntityLifecycleStatusUtils.convertToLifecyclePhases(Collection)"})
  void testConvertToLifecyclePhases_givenPending_thenReturnSizeIsThree() {
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
   * Test {@link EntityLifecycleStatusUtils#convertToLifecyclePhases(Collection)}.
   * <ul>
   *   <li>Given {@code REMOVED}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLifecycleStatusUtils#convertToLifecyclePhases(Collection)}
   */
  @Test
  @DisplayName("Test convertToLifecyclePhases(Collection); given 'REMOVED'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List EntityLifecycleStatusUtils.convertToLifecyclePhases(Collection)"})
  void testConvertToLifecyclePhases_givenRemoved_thenReturnSizeIsOne() {
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

  /**
   * Test {@link EntityLifecycleStatusUtils#convertToLifecyclePhases(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLifecycleStatusUtils#convertToLifecyclePhases(Collection)}
   */
  @Test
  @DisplayName("Test convertToLifecyclePhases(Collection); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List EntityLifecycleStatusUtils.convertToLifecyclePhases(Collection)"})
  void testConvertToLifecyclePhases_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<LifecyclePhase> actualConvertToLifecyclePhasesResult = EntityLifecycleStatusUtils
        .convertToLifecyclePhases(new ArrayList<>());

    // Assert
    assertTrue(actualConvertToLifecyclePhasesResult.isEmpty());
  }
}
