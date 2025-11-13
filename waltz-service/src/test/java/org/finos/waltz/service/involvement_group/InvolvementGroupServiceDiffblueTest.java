package org.finos.waltz.service.involvement_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.involvement_group.InvolvementGroupDao;
import org.finos.waltz.model.involvement_group.InvolvementGroupCreateCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class InvolvementGroupServiceDiffblueTest {
  /**
   * Test {@link InvolvementGroupService#createGroup(InvolvementGroupCreateCommand, String)}.
   *
   * <p>Method under test: {@link InvolvementGroupService#createGroup(InvolvementGroupCreateCommand,
   * String)}
   */
  @Test
  @DisplayName("Test createGroup(InvolvementGroupCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long InvolvementGroupService.createGroup(InvolvementGroupCreateCommand, String)"
  })
  void testCreateGroup() {
    // Arrange
    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any()))
        .thenReturn(1L);

    // Act
    long actualCreateGroupResult =
        new InvolvementGroupService(involvementGroupDao).createGroup(null, "janedoe");

    // Assert
    verify(involvementGroupDao).createInvolvementGroup(isNull());
    assertEquals(1L, actualCreateGroupResult);
  }

  /**
   * Test {@link InvolvementGroupService#updateInvolvements(Long, Set, String)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashSet#HashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementGroupService#updateInvolvements(Long, Set, String)}
   */
  @Test
  @DisplayName("Test updateInvolvements(Long, Set, String); given one; when HashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InvolvementGroupService.updateInvolvements(Long, Set, String)"})
  void testUpdateInvolvements_givenOne_whenHashSetAddOne() {
    // Arrange
    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    doNothing()
        .when(involvementGroupDao)
        .updateInvolvements(Mockito.<Long>any(), Mockito.<Set<Long>>any());
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(involvementGroupDao);

    HashSet<Long> involvementKindIds = new HashSet<>();
    involvementKindIds.add(1L);

    // Act
    involvementGroupService.updateInvolvements(1L, involvementKindIds, "janedoe");

    // Assert
    verify(involvementGroupDao).updateInvolvements(eq(1L), isA(Set.class));
  }

  /**
   * Test {@link InvolvementGroupService#updateInvolvements(Long, Set, String)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link HashSet#HashSet()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementGroupService#updateInvolvements(Long, Set, String)}
   */
  @Test
  @DisplayName("Test updateInvolvements(Long, Set, String); given zero; when HashSet() add zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InvolvementGroupService.updateInvolvements(Long, Set, String)"})
  void testUpdateInvolvements_givenZero_whenHashSetAddZero() {
    // Arrange
    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    doNothing()
        .when(involvementGroupDao)
        .updateInvolvements(Mockito.<Long>any(), Mockito.<Set<Long>>any());
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(involvementGroupDao);

    HashSet<Long> involvementKindIds = new HashSet<>();
    involvementKindIds.add(0L);
    involvementKindIds.add(1L);

    // Act
    involvementGroupService.updateInvolvements(1L, involvementKindIds, "janedoe");

    // Assert
    verify(involvementGroupDao).updateInvolvements(eq(1L), isA(Set.class));
  }

  /**
   * Test {@link InvolvementGroupService#updateInvolvements(Long, Set, String)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementGroupService#updateInvolvements(Long, Set, String)}
   */
  @Test
  @DisplayName("Test updateInvolvements(Long, Set, String); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InvolvementGroupService.updateInvolvements(Long, Set, String)"})
  void testUpdateInvolvements_whenHashSet() {
    // Arrange
    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    doNothing()
        .when(involvementGroupDao)
        .updateInvolvements(Mockito.<Long>any(), Mockito.<Set<Long>>any());
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(involvementGroupDao);

    // Act
    involvementGroupService.updateInvolvements(1L, new HashSet<>(), "janedoe");

    // Assert
    verify(involvementGroupDao).updateInvolvements(eq(1L), isA(Set.class));
  }
}
