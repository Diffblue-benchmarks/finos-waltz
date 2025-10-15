package org.finos.waltz.service.permission.permission_checker;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.common.exception.InsufficientPrivelegeException;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.Operation;
import org.finos.waltz.service.involvement.InvolvementService;
import org.finos.waltz.service.permission.PermissionGroupService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PermissionCheckerDiffblueTest {
  @Mock private InvolvementService involvementService;

  @Mock private PermissionGroupService permissionGroupService;

  /**
   * Test {@link PermissionChecker#verifyAnyPerms(Set, Set, EntityKind, String)}.
   *
   * <ul>
   *   <li>Given {@code ADD}.
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionChecker#verifyAnyPerms(Set, Set, EntityKind, String)}
   */
  @Test
  @DisplayName(
      "Test verifyAnyPerms(Set, Set, EntityKind, String); given 'ADD'; then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PermissionChecker.verifyAnyPerms(Set, Set, EntityKind, String)"})
  void testVerifyAnyPerms_givenAdd_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    AllocationPermissionChecker allocationPermissionChecker =
        new AllocationPermissionChecker(
            mock(MeasurableRatingDao.class), permissionGroupService, involvementService);

    HashSet<Operation> possiblePerms = new HashSet<>();
    possiblePerms.add(Operation.ADD);

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () ->
            allocationPermissionChecker.verifyAnyPerms(
                possiblePerms, new HashSet<>(), EntityKind.ALL, "janedoe"));
  }

  /**
   * Test {@link PermissionChecker#verifyAnyPerms(Set, Set, EntityKind, String)}.
   *
   * <ul>
   *   <li>Given {@code ADD}.
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionChecker#verifyAnyPerms(Set, Set, EntityKind, String)}
   */
  @Test
  @DisplayName(
      "Test verifyAnyPerms(Set, Set, EntityKind, String); given 'ADD'; then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PermissionChecker.verifyAnyPerms(Set, Set, EntityKind, String)"})
  void testVerifyAnyPerms_givenAdd_thenThrowInsufficientPrivelegeException2()
      throws InsufficientPrivelegeException {
    // Arrange
    AllocationPermissionChecker allocationPermissionChecker =
        new AllocationPermissionChecker(
            mock(MeasurableRatingDao.class), permissionGroupService, involvementService);
    HashSet<Operation> possiblePerms = new HashSet<>();

    HashSet<Operation> userPerms = new HashSet<>();
    userPerms.add(Operation.ADD);

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () ->
            allocationPermissionChecker.verifyAnyPerms(
                possiblePerms, userPerms, EntityKind.ALL, "janedoe"));
  }

  /**
   * Test {@link PermissionChecker#verifyAnyPerms(Set, Set, EntityKind, String)}.
   *
   * <ul>
   *   <li>Given {@code ATTEST}.
   *   <li>When {@link HashSet#HashSet()} add {@code ATTEST}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionChecker#verifyAnyPerms(Set, Set, EntityKind, String)}
   */
  @Test
  @DisplayName(
      "Test verifyAnyPerms(Set, Set, EntityKind, String); given 'ATTEST'; when HashSet() add 'ATTEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PermissionChecker.verifyAnyPerms(Set, Set, EntityKind, String)"})
  void testVerifyAnyPerms_givenAttest_whenHashSetAddAttest() throws InsufficientPrivelegeException {
    // Arrange
    AllocationPermissionChecker allocationPermissionChecker =
        new AllocationPermissionChecker(
            mock(MeasurableRatingDao.class), permissionGroupService, involvementService);

    HashSet<Operation> possiblePerms = new HashSet<>();
    possiblePerms.add(Operation.ATTEST);
    possiblePerms.add(Operation.ADD);

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () ->
            allocationPermissionChecker.verifyAnyPerms(
                possiblePerms, new HashSet<>(), EntityKind.ALL, "janedoe"));
  }

  /**
   * Test {@link PermissionChecker#verifyAnyPerms(Set, Set, EntityKind, String)}.
   *
   * <ul>
   *   <li>Given {@code ATTEST}.
   *   <li>When {@link HashSet#HashSet()} add {@code ATTEST}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionChecker#verifyAnyPerms(Set, Set, EntityKind, String)}
   */
  @Test
  @DisplayName(
      "Test verifyAnyPerms(Set, Set, EntityKind, String); given 'ATTEST'; when HashSet() add 'ATTEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PermissionChecker.verifyAnyPerms(Set, Set, EntityKind, String)"})
  void testVerifyAnyPerms_givenAttest_whenHashSetAddAttest2()
      throws InsufficientPrivelegeException {
    // Arrange
    AllocationPermissionChecker allocationPermissionChecker =
        new AllocationPermissionChecker(
            mock(MeasurableRatingDao.class), permissionGroupService, involvementService);
    HashSet<Operation> possiblePerms = new HashSet<>();

    HashSet<Operation> userPerms = new HashSet<>();
    userPerms.add(Operation.ATTEST);
    userPerms.add(Operation.ADD);

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () ->
            allocationPermissionChecker.verifyAnyPerms(
                possiblePerms, userPerms, EntityKind.ALL, "janedoe"));
  }

  /**
   * Test {@link PermissionChecker#verifyAnyPerms(Set, Set, EntityKind, String)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionChecker#verifyAnyPerms(Set, Set, EntityKind, String)}
   */
  @Test
  @DisplayName(
      "Test verifyAnyPerms(Set, Set, EntityKind, String); when HashSet(); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PermissionChecker.verifyAnyPerms(Set, Set, EntityKind, String)"})
  void testVerifyAnyPerms_whenHashSet_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    AllocationPermissionChecker allocationPermissionChecker =
        new AllocationPermissionChecker(
            mock(MeasurableRatingDao.class), permissionGroupService, involvementService);
    HashSet<Operation> possiblePerms = new HashSet<>();

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () ->
            allocationPermissionChecker.verifyAnyPerms(
                possiblePerms, new HashSet<>(), EntityKind.ALL, "janedoe"));
  }

  /**
   * Test {@link PermissionChecker#verifyEditPerms(Set, EntityKind, String)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionChecker#verifyEditPerms(Set, EntityKind, String)}
   */
  @Test
  @DisplayName(
      "Test verifyEditPerms(Set, EntityKind, String); when HashSet(); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PermissionChecker.verifyEditPerms(Set, EntityKind, String)"})
  void testVerifyEditPerms_whenHashSet_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    AllocationPermissionChecker allocationPermissionChecker =
        new AllocationPermissionChecker(
            mock(MeasurableRatingDao.class), permissionGroupService, involvementService);

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () ->
            allocationPermissionChecker.verifyEditPerms(
                new HashSet<>(), EntityKind.ALL, "janedoe"));
  }
}
