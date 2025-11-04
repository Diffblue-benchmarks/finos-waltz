package org.finos.waltz.service.involvement_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.involvement_group.InvolvementGroupDao;
import org.finos.waltz.model.involvement_group.InvolvementGroupCreateCommand;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class InvolvementGroupServiceDiffblueTest {
  /**
   * Method under test:
   * {@link InvolvementGroupService#createGroup(InvolvementGroupCreateCommand, String)}
   */
  @Test
  void testCreateGroup() {
    // Arrange
    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any())).thenReturn(1L);

    // Act
    long actualCreateGroupResult = (new InvolvementGroupService(involvementGroupDao)).createGroup(null, "janedoe");

    // Assert
    verify(involvementGroupDao).createInvolvementGroup(isNull());
    assertEquals(1L, actualCreateGroupResult);
  }

  /**
   * Method under test:
   * {@link InvolvementGroupService#updateInvolvements(Long, Set, String)}
   */
  @Test
  void testUpdateInvolvements() {
    // Arrange
    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    doNothing().when(involvementGroupDao).updateInvolvements(Mockito.<Long>any(), Mockito.<Set<Long>>any());
    InvolvementGroupService involvementGroupService = new InvolvementGroupService(involvementGroupDao);

    // Act
    involvementGroupService.updateInvolvements(1L, new HashSet<>(), "janedoe");

    // Assert
    verify(involvementGroupDao).updateInvolvements(eq(1L), isA(Set.class));
  }

  /**
   * Method under test:
   * {@link InvolvementGroupService#updateInvolvements(Long, Set, String)}
   */
  @Test
  void testUpdateInvolvements2() {
    // Arrange
    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    doNothing().when(involvementGroupDao).updateInvolvements(Mockito.<Long>any(), Mockito.<Set<Long>>any());
    InvolvementGroupService involvementGroupService = new InvolvementGroupService(involvementGroupDao);

    HashSet<Long> involvementKindIds = new HashSet<>();
    involvementKindIds.add(2L);

    // Act
    involvementGroupService.updateInvolvements(1L, involvementKindIds, "janedoe");

    // Assert
    verify(involvementGroupDao).updateInvolvements(eq(1L), isA(Set.class));
  }

  /**
   * Method under test:
   * {@link InvolvementGroupService#updateInvolvements(Long, Set, String)}
   */
  @Test
  void testUpdateInvolvements3() {
    // Arrange
    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    doNothing().when(involvementGroupDao).updateInvolvements(Mockito.<Long>any(), Mockito.<Set<Long>>any());
    InvolvementGroupService involvementGroupService = new InvolvementGroupService(involvementGroupDao);

    HashSet<Long> involvementKindIds = new HashSet<>();
    involvementKindIds.add(1L);
    involvementKindIds.add(2L);

    // Act
    involvementGroupService.updateInvolvements(1L, involvementKindIds, "janedoe");

    // Assert
    verify(involvementGroupDao).updateInvolvements(eq(1L), isA(Set.class));
  }
}
