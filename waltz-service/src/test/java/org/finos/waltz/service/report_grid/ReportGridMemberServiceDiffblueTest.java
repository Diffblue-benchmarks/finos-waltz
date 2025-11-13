package org.finos.waltz.service.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.common.exception.InsufficientPrivelegeException;
import org.finos.waltz.data.report_grid.ReportGridMemberDao;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.report_grid.ImmutableReportGridMemberCreateCommand;
import org.finos.waltz.model.report_grid.ImmutableReportGridMemberDeleteCommand;
import org.finos.waltz.model.report_grid.ReportGridMember;
import org.finos.waltz.model.report_grid.ReportGridMemberCreateCommand;
import org.finos.waltz.model.report_grid.ReportGridMemberDeleteCommand;
import org.finos.waltz.model.report_grid.ReportGridMemberRole;
import org.finos.waltz.model.report_grid.ReportGridMemberUpdateRoleCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ReportGridMemberServiceDiffblueTest {
  /**
   * Test {@link ReportGridMemberService#findByGridId(Long)}.
   *
   * <p>Method under test: {@link ReportGridMemberService#findByGridId(Long)}
   */
  @Test
  @DisplayName("Test findByGridId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridMemberService.findByGridId(Long)"})
  void testFindByGridId() {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.findByGridId(Mockito.<Long>any())).thenReturn(new HashSet<>());

    // Act
    Set<ReportGridMember> actualFindByGridIdResult =
        new ReportGridMemberService(reportGridMemberDao).findByGridId(1L);

    // Assert
    verify(reportGridMemberDao).findByGridId(1L);
    assertTrue(actualFindByGridIdResult.isEmpty());
  }

  /**
   * Test {@link ReportGridMemberService#findPeopleByGridId(Long)}.
   *
   * <p>Method under test: {@link ReportGridMemberService#findPeopleByGridId(Long)}
   */
  @Test
  @DisplayName("Test findPeopleByGridId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridMemberService.findPeopleByGridId(Long)"})
  void testFindPeopleByGridId() {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.findPeopleByGridId(Mockito.<Long>any())).thenReturn(new HashSet<>());

    // Act
    Set<Person> actualFindPeopleByGridIdResult =
        new ReportGridMemberService(reportGridMemberDao).findPeopleByGridId(1L);

    // Assert
    verify(reportGridMemberDao).findPeopleByGridId(1L);
    assertTrue(actualFindPeopleByGridIdResult.isEmpty());
  }

  /**
   * Test {@link ReportGridMemberService#register(long, String, ReportGridMemberRole)}.
   *
   * <p>Method under test: {@link ReportGridMemberService#register(long, String,
   * ReportGridMemberRole)}
   */
  @Test
  @DisplayName("Test register(long, String, ReportGridMemberRole)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ReportGridMemberService.register(long, String, ReportGridMemberRole)"})
  void testRegister() {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.register(
            anyLong(), Mockito.<String>any(), Mockito.<ReportGridMemberRole>any()))
        .thenReturn(1);

    // Act
    int actualRegisterResult =
        new ReportGridMemberService(reportGridMemberDao)
            .register(1L, "janedoe", ReportGridMemberRole.VIEWER);

    // Assert
    verify(reportGridMemberDao).register(1L, "janedoe", ReportGridMemberRole.VIEWER);
    assertEquals(1, actualRegisterResult);
  }

  /**
   * Test {@link ReportGridMemberService#checkIsOwner(long, String)}.
   *
   * <ul>
   *   <li>Given {@link ReportGridMemberDao} {@link ReportGridMemberDao#canUpdate(long, String)}
   *       return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberService#checkIsOwner(long, String)}
   */
  @Test
  @DisplayName(
      "Test checkIsOwner(long, String); given ReportGridMemberDao canUpdate(long, String) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReportGridMemberService.checkIsOwner(long, String)"})
  void testCheckIsOwner_givenReportGridMemberDaoCanUpdateReturnTrue()
      throws InsufficientPrivelegeException {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    // Act
    new ReportGridMemberService(reportGridMemberDao).checkIsOwner(1L, "42");

    // Assert
    verify(reportGridMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link ReportGridMemberService#checkIsOwner(long, String)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberService#checkIsOwner(long, String)}
   */
  @Test
  @DisplayName("Test checkIsOwner(long, String); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReportGridMemberService.checkIsOwner(long, String)"})
  void testCheckIsOwner_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () -> new ReportGridMemberService(reportGridMemberDao).checkIsOwner(1L, "42"));
    verify(reportGridMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link ReportGridMemberService#canUpdate(long, String)}.
   *
   * <ul>
   *   <li>Given {@link ReportGridMemberDao} {@link ReportGridMemberDao#canUpdate(long, String)}
   *       return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberService#canUpdate(long, String)}
   */
  @Test
  @DisplayName(
      "Test canUpdate(long, String); given ReportGridMemberDao canUpdate(long, String) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridMemberService.canUpdate(long, String)"})
  void testCanUpdate_givenReportGridMemberDaoCanUpdateReturnFalse_thenReturnFalse() {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualCanUpdateResult =
        new ReportGridMemberService(reportGridMemberDao).canUpdate(1L, "42");

    // Assert
    verify(reportGridMemberDao).canUpdate(1L, "42");
    assertFalse(actualCanUpdateResult);
  }

  /**
   * Test {@link ReportGridMemberService#canUpdate(long, String)}.
   *
   * <ul>
   *   <li>Given {@link ReportGridMemberDao} {@link ReportGridMemberDao#canUpdate(long, String)}
   *       return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberService#canUpdate(long, String)}
   */
  @Test
  @DisplayName(
      "Test canUpdate(long, String); given ReportGridMemberDao canUpdate(long, String) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridMemberService.canUpdate(long, String)"})
  void testCanUpdate_givenReportGridMemberDaoCanUpdateReturnTrue_thenReturnTrue() {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualCanUpdateResult =
        new ReportGridMemberService(reportGridMemberDao).canUpdate(1L, "42");

    // Assert
    verify(reportGridMemberDao).canUpdate(1L, "42");
    assertTrue(actualCanUpdateResult);
  }

  /**
   * Test {@link ReportGridMemberService#updateUserRole(long, ReportGridMemberUpdateRoleCommand,
   * String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberService#updateUserRole(long,
   * ReportGridMemberUpdateRoleCommand, String)}
   */
  @Test
  @DisplayName(
      "Test updateUserRole(long, ReportGridMemberUpdateRoleCommand, String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ReportGridMemberService.updateUserRole(long, ReportGridMemberUpdateRoleCommand, String)"
  })
  void testUpdateUserRole_thenReturnEmpty() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.updateUserRole(
            anyLong(), Mockito.<ReportGridMemberUpdateRoleCommand>any()))
        .thenReturn(1);
    when(reportGridMemberDao.findByGridId(Mockito.<Long>any())).thenReturn(new HashSet<>());
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    // Act
    Set<ReportGridMember> actualUpdateUserRoleResult =
        new ReportGridMemberService(reportGridMemberDao).updateUserRole(1L, null, "janedoe");

    // Assert
    verify(reportGridMemberDao).canUpdate(1L, "janedoe");
    verify(reportGridMemberDao).findByGridId(1L);
    verify(reportGridMemberDao).updateUserRole(eq(1L), isNull());
    assertTrue(actualUpdateUserRoleResult.isEmpty());
  }

  /**
   * Test {@link ReportGridMemberService#updateUserRole(long, ReportGridMemberUpdateRoleCommand,
   * String)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberService#updateUserRole(long,
   * ReportGridMemberUpdateRoleCommand, String)}
   */
  @Test
  @DisplayName(
      "Test updateUserRole(long, ReportGridMemberUpdateRoleCommand, String); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ReportGridMemberService.updateUserRole(long, ReportGridMemberUpdateRoleCommand, String)"
  })
  void testUpdateUserRole_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () -> new ReportGridMemberService(reportGridMemberDao).updateUserRole(1L, null, "janedoe"));
    verify(reportGridMemberDao).canUpdate(1L, "janedoe");
  }

  /**
   * Test {@link ReportGridMemberService#delete(ReportGridMemberDeleteCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ReportGridMemberDao} {@link
   *       ReportGridMemberDao#delete(ReportGridMemberDeleteCommand)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberService#delete(ReportGridMemberDeleteCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test delete(ReportGridMemberDeleteCommand, String); given ReportGridMemberDao delete(ReportGridMemberDeleteCommand) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReportGridMemberService.delete(ReportGridMemberDeleteCommand, String)"
  })
  void testDelete_givenReportGridMemberDaoDeleteReturnFalse_thenReturnFalse()
      throws InsufficientPrivelegeException {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.delete(Mockito.<ReportGridMemberDeleteCommand>any()))
        .thenReturn(false);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(reportGridMemberDao);

    // Act
    boolean actualDeleteResult =
        reportGridMemberService.delete(
            ImmutableReportGridMemberDeleteCommand.builder().gridId(1L).userId("42").build(),
            "janedoe");

    // Assert
    verify(reportGridMemberDao).canUpdate(1L, "janedoe");
    verify(reportGridMemberDao).delete(isA(ReportGridMemberDeleteCommand.class));
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link ReportGridMemberService#delete(ReportGridMemberDeleteCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ReportGridMemberDao} {@link
   *       ReportGridMemberDao#delete(ReportGridMemberDeleteCommand)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberService#delete(ReportGridMemberDeleteCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test delete(ReportGridMemberDeleteCommand, String); given ReportGridMemberDao delete(ReportGridMemberDeleteCommand) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReportGridMemberService.delete(ReportGridMemberDeleteCommand, String)"
  })
  void testDelete_givenReportGridMemberDaoDeleteReturnTrue_thenReturnTrue()
      throws InsufficientPrivelegeException {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.delete(Mockito.<ReportGridMemberDeleteCommand>any())).thenReturn(true);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(reportGridMemberDao);

    // Act
    boolean actualDeleteResult =
        reportGridMemberService.delete(
            ImmutableReportGridMemberDeleteCommand.builder().gridId(1L).userId("42").build(),
            "janedoe");

    // Assert
    verify(reportGridMemberDao).canUpdate(1L, "janedoe");
    verify(reportGridMemberDao).delete(isA(ReportGridMemberDeleteCommand.class));
    assertTrue(actualDeleteResult);
  }

  /**
   * Test {@link ReportGridMemberService#delete(ReportGridMemberDeleteCommand, String)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberService#delete(ReportGridMemberDeleteCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test delete(ReportGridMemberDeleteCommand, String); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReportGridMemberService.delete(ReportGridMemberDeleteCommand, String)"
  })
  void testDelete_thenThrowInsufficientPrivelegeException() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(reportGridMemberDao);

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () ->
            reportGridMemberService.delete(
                ImmutableReportGridMemberDeleteCommand.builder().gridId(1L).userId("42").build(),
                "janedoe"));
    verify(reportGridMemberDao).canUpdate(1L, "janedoe");
  }

  /**
   * Test {@link ReportGridMemberService#create(ReportGridMemberCreateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ReportGridMemberDao} {@link ReportGridMemberDao#register(long, String,
   *       ReportGridMemberRole)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberService#create(ReportGridMemberCreateCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test create(ReportGridMemberCreateCommand, String); given ReportGridMemberDao register(long, String, ReportGridMemberRole) return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ReportGridMemberService.create(ReportGridMemberCreateCommand, String)"})
  void testCreate_givenReportGridMemberDaoRegisterReturnOne_thenReturnOne()
      throws InsufficientPrivelegeException {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.register(
            anyLong(), Mockito.<String>any(), Mockito.<ReportGridMemberRole>any()))
        .thenReturn(1);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(reportGridMemberDao);

    // Act
    int actualCreateResult =
        reportGridMemberService.create(
            ImmutableReportGridMemberCreateCommand.builder()
                .gridId(1L)
                .role(ReportGridMemberRole.VIEWER)
                .userId("42")
                .build(),
            "janedoe");

    // Assert
    verify(reportGridMemberDao).canUpdate(1L, "janedoe");
    verify(reportGridMemberDao).register(1L, "42", ReportGridMemberRole.VIEWER);
    assertEquals(1, actualCreateResult);
  }

  /**
   * Test {@link ReportGridMemberService#create(ReportGridMemberCreateCommand, String)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberService#create(ReportGridMemberCreateCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test create(ReportGridMemberCreateCommand, String); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ReportGridMemberService.create(ReportGridMemberCreateCommand, String)"})
  void testCreate_thenThrowInsufficientPrivelegeException() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(reportGridMemberDao);

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () ->
            reportGridMemberService.create(
                ImmutableReportGridMemberCreateCommand.builder()
                    .gridId(1L)
                    .role(ReportGridMemberRole.VIEWER)
                    .userId("42")
                    .build(),
                "janedoe"));
    verify(reportGridMemberDao).canUpdate(1L, "janedoe");
  }

  /**
   * Test {@link ReportGridMemberService#update(ReportGridMemberCreateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ReportGridMemberDao} {@link
   *       ReportGridMemberDao#update(ReportGridMemberCreateCommand, String)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberService#update(ReportGridMemberCreateCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test update(ReportGridMemberCreateCommand, String); given ReportGridMemberDao update(ReportGridMemberCreateCommand, String) return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ReportGridMemberService.update(ReportGridMemberCreateCommand, String)"})
  void testUpdate_givenReportGridMemberDaoUpdateReturnOne_thenReturnOne()
      throws InsufficientPrivelegeException {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.update(
            Mockito.<ReportGridMemberCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(reportGridMemberDao);

    // Act
    int actualUpdateResult =
        reportGridMemberService.update(
            ImmutableReportGridMemberCreateCommand.builder()
                .gridId(1L)
                .role(ReportGridMemberRole.VIEWER)
                .userId("42")
                .build(),
            "janedoe");

    // Assert
    verify(reportGridMemberDao).canUpdate(1L, "janedoe");
    verify(reportGridMemberDao).update(isA(ReportGridMemberCreateCommand.class), eq("janedoe"));
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Test {@link ReportGridMemberService#update(ReportGridMemberCreateCommand, String)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberService#update(ReportGridMemberCreateCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test update(ReportGridMemberCreateCommand, String); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ReportGridMemberService.update(ReportGridMemberCreateCommand, String)"})
  void testUpdate_thenThrowInsufficientPrivelegeException() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(reportGridMemberDao);

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () ->
            reportGridMemberService.update(
                ImmutableReportGridMemberCreateCommand.builder()
                    .gridId(1L)
                    .role(ReportGridMemberRole.VIEWER)
                    .userId("42")
                    .build(),
                "janedoe"));
    verify(reportGridMemberDao).canUpdate(1L, "janedoe");
  }
}
