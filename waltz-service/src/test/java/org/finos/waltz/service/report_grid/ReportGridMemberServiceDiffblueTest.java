package org.finos.waltz.service.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.common.exception.InsufficientPrivelegeException;
import org.finos.waltz.data.report_grid.ReportGridMemberDao;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.report_grid.ReportGridMember;
import org.finos.waltz.model.report_grid.ReportGridMemberCreateCommand;
import org.finos.waltz.model.report_grid.ReportGridMemberDeleteCommand;
import org.finos.waltz.model.report_grid.ReportGridMemberRole;
import org.finos.waltz.model.report_grid.ReportGridMemberUpdateRoleCommand;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ReportGridMemberServiceDiffblueTest {
  /**
   * Method under test: {@link ReportGridMemberService#findByGridId(Long)}
   */
  @Test
  void testFindByGridId() {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    HashSet<ReportGridMember> reportGridMemberSet = new HashSet<>();
    when(reportGridMemberDao.findByGridId(Mockito.<Long>any())).thenReturn(reportGridMemberSet);

    // Act
    Set<ReportGridMember> actualFindByGridIdResult = (new ReportGridMemberService(reportGridMemberDao))
        .findByGridId(1L);

    // Assert
    verify(reportGridMemberDao).findByGridId(eq(1L));
    assertTrue(actualFindByGridIdResult.isEmpty());
    assertSame(reportGridMemberSet, actualFindByGridIdResult);
  }

  /**
   * Method under test: {@link ReportGridMemberService#findPeopleByGridId(Long)}
   */
  @Test
  void testFindPeopleByGridId() {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    HashSet<Person> personSet = new HashSet<>();
    when(reportGridMemberDao.findPeopleByGridId(Mockito.<Long>any())).thenReturn(personSet);

    // Act
    Set<Person> actualFindPeopleByGridIdResult = (new ReportGridMemberService(reportGridMemberDao))
        .findPeopleByGridId(1L);

    // Assert
    verify(reportGridMemberDao).findPeopleByGridId(eq(1L));
    assertTrue(actualFindPeopleByGridIdResult.isEmpty());
    assertSame(personSet, actualFindPeopleByGridIdResult);
  }

  /**
   * Method under test:
   * {@link ReportGridMemberService#register(long, String, ReportGridMemberRole)}
   */
  @Test
  void testRegister() {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.register(anyLong(), Mockito.<String>any(), Mockito.<ReportGridMemberRole>any()))
        .thenReturn(1);

    // Act
    int actualRegisterResult = (new ReportGridMemberService(reportGridMemberDao)).register(1L, "janedoe",
        ReportGridMemberRole.VIEWER);

    // Assert
    verify(reportGridMemberDao).register(eq(1L), eq("janedoe"), eq(ReportGridMemberRole.VIEWER));
    assertEquals(1, actualRegisterResult);
  }

  /**
   * Method under test: {@link ReportGridMemberService#checkIsOwner(long, String)}
   */
  @Test
  void testCheckIsOwner() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    // Act
    (new ReportGridMemberService(reportGridMemberDao)).checkIsOwner(1L, "42");

    // Assert
    verify(reportGridMemberDao).canUpdate(eq(1L), eq("42"));
  }

  /**
   * Method under test: {@link ReportGridMemberService#checkIsOwner(long, String)}
   */
  @Test
  void testCheckIsOwner2() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class,
        () -> (new ReportGridMemberService(reportGridMemberDao)).checkIsOwner(1L, "42"));
    verify(reportGridMemberDao).canUpdate(eq(1L), eq("42"));
  }

  /**
   * Method under test: {@link ReportGridMemberService#canUpdate(long, String)}
   */
  @Test
  void testCanUpdate() {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualCanUpdateResult = (new ReportGridMemberService(reportGridMemberDao)).canUpdate(1L, "42");

    // Assert
    verify(reportGridMemberDao).canUpdate(eq(1L), eq("42"));
    assertTrue(actualCanUpdateResult);
  }

  /**
   * Method under test: {@link ReportGridMemberService#canUpdate(long, String)}
   */
  @Test
  void testCanUpdate2() {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualCanUpdateResult = (new ReportGridMemberService(reportGridMemberDao)).canUpdate(1L, "42");

    // Assert
    verify(reportGridMemberDao).canUpdate(eq(1L), eq("42"));
    assertFalse(actualCanUpdateResult);
  }

  /**
   * Method under test:
   * {@link ReportGridMemberService#updateUserRole(long, ReportGridMemberUpdateRoleCommand, String)}
   */
  @Test
  void testUpdateUserRole() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.updateUserRole(anyLong(), Mockito.<ReportGridMemberUpdateRoleCommand>any())).thenReturn(1);
    HashSet<ReportGridMember> reportGridMemberSet = new HashSet<>();
    when(reportGridMemberDao.findByGridId(Mockito.<Long>any())).thenReturn(reportGridMemberSet);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    // Act
    Set<ReportGridMember> actualUpdateUserRoleResult = (new ReportGridMemberService(reportGridMemberDao))
        .updateUserRole(1L, null, "janedoe");

    // Assert
    verify(reportGridMemberDao).canUpdate(eq(1L), eq("janedoe"));
    verify(reportGridMemberDao).findByGridId(eq(1L));
    verify(reportGridMemberDao).updateUserRole(eq(1L), isNull());
    assertTrue(actualUpdateUserRoleResult.isEmpty());
    assertSame(reportGridMemberSet, actualUpdateUserRoleResult);
  }

  /**
   * Method under test:
   * {@link ReportGridMemberService#updateUserRole(long, ReportGridMemberUpdateRoleCommand, String)}
   */
  @Test
  void testUpdateUserRole2() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class,
        () -> (new ReportGridMemberService(reportGridMemberDao)).updateUserRole(1L, null, "janedoe"));
    verify(reportGridMemberDao).canUpdate(eq(1L), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link ReportGridMemberService#delete(ReportGridMemberDeleteCommand, String)}
   */
  @Test
  void testDelete() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.delete(Mockito.<ReportGridMemberDeleteCommand>any())).thenReturn(true);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(reportGridMemberDao);
    ReportGridMemberDeleteCommand cmd = mock(ReportGridMemberDeleteCommand.class);
    when(cmd.gridId()).thenReturn(1L);

    // Act
    boolean actualDeleteResult = reportGridMemberService.delete(cmd, "janedoe");

    // Assert
    verify(reportGridMemberDao).canUpdate(eq(1L), eq("janedoe"));
    verify(reportGridMemberDao).delete(isA(ReportGridMemberDeleteCommand.class));
    verify(cmd).gridId();
    assertTrue(actualDeleteResult);
  }

  /**
   * Method under test:
   * {@link ReportGridMemberService#delete(ReportGridMemberDeleteCommand, String)}
   */
  @Test
  void testDelete2() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.delete(Mockito.<ReportGridMemberDeleteCommand>any())).thenReturn(false);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(reportGridMemberDao);
    ReportGridMemberDeleteCommand cmd = mock(ReportGridMemberDeleteCommand.class);
    when(cmd.gridId()).thenReturn(1L);

    // Act
    boolean actualDeleteResult = reportGridMemberService.delete(cmd, "janedoe");

    // Assert
    verify(reportGridMemberDao).canUpdate(eq(1L), eq("janedoe"));
    verify(reportGridMemberDao).delete(isA(ReportGridMemberDeleteCommand.class));
    verify(cmd).gridId();
    assertFalse(actualDeleteResult);
  }

  /**
   * Method under test:
   * {@link ReportGridMemberService#delete(ReportGridMemberDeleteCommand, String)}
   */
  @Test
  void testDelete3() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(reportGridMemberDao);
    ReportGridMemberDeleteCommand cmd = mock(ReportGridMemberDeleteCommand.class);
    when(cmd.gridId()).thenReturn(1L);

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class, () -> reportGridMemberService.delete(cmd, "janedoe"));
    verify(reportGridMemberDao).canUpdate(eq(1L), eq("janedoe"));
    verify(cmd).gridId();
  }

  /**
   * Method under test:
   * {@link ReportGridMemberService#create(ReportGridMemberCreateCommand, String)}
   */
  @Test
  void testCreate() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.register(anyLong(), Mockito.<String>any(), Mockito.<ReportGridMemberRole>any()))
        .thenReturn(1);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(reportGridMemberDao);
    ReportGridMemberCreateCommand cmd = mock(ReportGridMemberCreateCommand.class);
    when(cmd.userId()).thenReturn("42");
    when(cmd.gridId()).thenReturn(1L);
    when(cmd.role()).thenReturn(ReportGridMemberRole.VIEWER);

    // Act
    int actualCreateResult = reportGridMemberService.create(cmd, "janedoe");

    // Assert
    verify(reportGridMemberDao).canUpdate(eq(1L), eq("janedoe"));
    verify(reportGridMemberDao).register(eq(1L), eq("42"), eq(ReportGridMemberRole.VIEWER));
    verify(cmd, atLeast(1)).gridId();
    verify(cmd).role();
    verify(cmd).userId();
    assertEquals(1, actualCreateResult);
  }

  /**
   * Method under test:
   * {@link ReportGridMemberService#create(ReportGridMemberCreateCommand, String)}
   */
  @Test
  void testCreate2() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(reportGridMemberDao);
    ReportGridMemberCreateCommand cmd = mock(ReportGridMemberCreateCommand.class);
    when(cmd.gridId()).thenReturn(1L);

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class, () -> reportGridMemberService.create(cmd, "janedoe"));
    verify(reportGridMemberDao).canUpdate(eq(1L), eq("janedoe"));
    verify(cmd).gridId();
  }

  /**
   * Method under test:
   * {@link ReportGridMemberService#update(ReportGridMemberCreateCommand, String)}
   */
  @Test
  void testUpdate() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.update(Mockito.<ReportGridMemberCreateCommand>any(), Mockito.<String>any())).thenReturn(1);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(reportGridMemberDao);
    ReportGridMemberCreateCommand cmd = mock(ReportGridMemberCreateCommand.class);
    when(cmd.gridId()).thenReturn(1L);

    // Act
    int actualUpdateResult = reportGridMemberService.update(cmd, "janedoe");

    // Assert
    verify(reportGridMemberDao).canUpdate(eq(1L), eq("janedoe"));
    verify(reportGridMemberDao).update(isA(ReportGridMemberCreateCommand.class), eq("janedoe"));
    verify(cmd).gridId();
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Method under test:
   * {@link ReportGridMemberService#update(ReportGridMemberCreateCommand, String)}
   */
  @Test
  void testUpdate2() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(reportGridMemberDao);
    ReportGridMemberCreateCommand cmd = mock(ReportGridMemberCreateCommand.class);
    when(cmd.gridId()).thenReturn(1L);

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class, () -> reportGridMemberService.update(cmd, "janedoe"));
    verify(reportGridMemberDao).canUpdate(eq(1L), eq("janedoe"));
    verify(cmd).gridId();
  }
}
