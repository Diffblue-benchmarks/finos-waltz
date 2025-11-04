package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import org.finos.waltz.common.exception.InsufficientPrivelegeException;
import org.finos.waltz.data.app_group.AppGroupMemberDao;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.app_group.AppGroup;
import org.finos.waltz.model.app_group.AppGroupMemberRole;
import org.finos.waltz.service.app_group.AppGroupService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

class AppGroupHelperDiffblueTest {
  /**
   * Method under test:
   * {@link AppGroupHelper#createAppGroupWithAppRefs(String, Collection)}
   */
  @Test
  void testCreateAppGroupWithAppRefs() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupService appGroupService = mock(AppGroupService.class);
    when(appGroupService.createNewGroup(Mockito.<String>any())).thenReturn(1L);
    when(appGroupService.addApplications(Mockito.<String>any(), anyLong(), Mockito.<Collection<Long>>any(),
        Mockito.<Collection<String>>any())).thenReturn(new ArrayList<>());
    when(appGroupService.updateOverview(Mockito.<String>any(), Mockito.<AppGroup>any())).thenReturn(null);
    AppGroupHelper appGroupHelper = new AppGroupHelper();
    ReflectionTestUtils.setField(appGroupHelper, "appGroupService", appGroupService);
    ReflectionTestUtils.setField(appGroupHelper, "appGroupMemberDao", mock(AppGroupMemberDao.class));

    // Act
    Long actualCreateAppGroupWithAppRefsResult = appGroupHelper.createAppGroupWithAppRefs("Group Name",
        new ArrayList<>());

    // Assert
    verify(appGroupService).addApplications(eq("appGroupHelper"), eq(1L), isA(Collection.class), isA(Collection.class));
    verify(appGroupService).createNewGroup(eq("appGroupHelper"));
    verify(appGroupService).updateOverview(eq("appGroupHelper"), isA(AppGroup.class));
    assertEquals(1L, actualCreateAppGroupWithAppRefsResult.longValue());
  }

  /**
   * Method under test:
   * {@link AppGroupHelper#createAppGroupWithAppRefs(String, Collection)}
   */
  @Test
  void testCreateAppGroupWithAppRefs2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupService appGroupService = mock(AppGroupService.class);
    when(appGroupService.createNewGroup(Mockito.<String>any())).thenReturn(1L);
    when(appGroupService.addApplications(Mockito.<String>any(), anyLong(), Mockito.<Collection<Long>>any(),
        Mockito.<Collection<String>>any())).thenReturn(new ArrayList<>());
    when(appGroupService.updateOverview(Mockito.<String>any(), Mockito.<AppGroup>any())).thenReturn(null);
    AppGroupHelper appGroupHelper = new AppGroupHelper();
    ReflectionTestUtils.setField(appGroupHelper, "appGroupService", appGroupService);
    ReflectionTestUtils.setField(appGroupHelper, "appGroupMemberDao", mock(AppGroupMemberDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);

    ArrayList<EntityReference> appRefs = new ArrayList<>();
    appRefs.add(entityReference);

    // Act
    Long actualCreateAppGroupWithAppRefsResult = appGroupHelper.createAppGroupWithAppRefs("Group Name", appRefs);

    // Assert
    verify(entityReference).id();
    verify(appGroupService).addApplications(eq("appGroupHelper"), eq(1L), isA(Collection.class), isA(Collection.class));
    verify(appGroupService).createNewGroup(eq("appGroupHelper"));
    verify(appGroupService).updateOverview(eq("appGroupHelper"), isA(AppGroup.class));
    assertEquals(1L, actualCreateAppGroupWithAppRefsResult.longValue());
  }

  /**
   * Method under test:
   * {@link AppGroupHelper#createAppGroupWithAppRefs(String, Collection)}
   */
  @Test
  void testCreateAppGroupWithAppRefs3() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupService appGroupService = mock(AppGroupService.class);
    when(appGroupService.createNewGroup(Mockito.<String>any())).thenReturn(1L);
    when(appGroupService.addApplications(Mockito.<String>any(), anyLong(), Mockito.<Collection<Long>>any(),
        Mockito.<Collection<String>>any())).thenReturn(new ArrayList<>());
    when(appGroupService.updateOverview(Mockito.<String>any(), Mockito.<AppGroup>any())).thenReturn(null);
    AppGroupHelper appGroupHelper = new AppGroupHelper();
    ReflectionTestUtils.setField(appGroupHelper, "appGroupService", appGroupService);
    ReflectionTestUtils.setField(appGroupHelper, "appGroupMemberDao", mock(AppGroupMemberDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);

    ArrayList<EntityReference> appRefs = new ArrayList<>();
    appRefs.add(entityReference2);
    appRefs.add(entityReference);

    // Act
    Long actualCreateAppGroupWithAppRefsResult = appGroupHelper.createAppGroupWithAppRefs("Group Name", appRefs);

    // Assert
    verify(entityReference2).id();
    verify(entityReference).id();
    verify(appGroupService).addApplications(eq("appGroupHelper"), eq(1L), isA(Collection.class), isA(Collection.class));
    verify(appGroupService).createNewGroup(eq("appGroupHelper"));
    verify(appGroupService).updateOverview(eq("appGroupHelper"), isA(AppGroup.class));
    assertEquals(1L, actualCreateAppGroupWithAppRefsResult.longValue());
  }

  /**
   * Method under test:
   * {@link AppGroupHelper#createAppGroupWithAppIds(String, Collection)}
   */
  @Test
  void testCreateAppGroupWithAppIds() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupService appGroupService = mock(AppGroupService.class);
    when(appGroupService.createNewGroup(Mockito.<String>any())).thenReturn(1L);
    when(appGroupService.addApplications(Mockito.<String>any(), anyLong(), Mockito.<Collection<Long>>any(),
        Mockito.<Collection<String>>any())).thenReturn(new ArrayList<>());
    when(appGroupService.updateOverview(Mockito.<String>any(), Mockito.<AppGroup>any())).thenReturn(null);
    AppGroupHelper appGroupHelper = new AppGroupHelper();
    ReflectionTestUtils.setField(appGroupHelper, "appGroupService", appGroupService);
    ReflectionTestUtils.setField(appGroupHelper, "appGroupMemberDao", mock(AppGroupMemberDao.class));

    // Act
    Long actualCreateAppGroupWithAppIdsResult = appGroupHelper.createAppGroupWithAppIds("Group Name",
        new ArrayList<>());

    // Assert
    verify(appGroupService).addApplications(eq("appGroupHelper"), eq(1L), isA(Collection.class), isA(Collection.class));
    verify(appGroupService).createNewGroup(eq("appGroupHelper"));
    verify(appGroupService).updateOverview(eq("appGroupHelper"), isA(AppGroup.class));
    assertEquals(1L, actualCreateAppGroupWithAppIdsResult.longValue());
  }

  /**
   * Method under test:
   * {@link AppGroupHelper#createAppGroupWithAppIds(String, Collection)}
   */
  @Test
  void testCreateAppGroupWithAppIds2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupService appGroupService = mock(AppGroupService.class);
    when(appGroupService.createNewGroup(Mockito.<String>any())).thenReturn(1L);
    when(appGroupService.addApplications(Mockito.<String>any(), anyLong(), Mockito.<Collection<Long>>any(),
        Mockito.<Collection<String>>any())).thenReturn(new ArrayList<>());
    when(appGroupService.updateOverview(Mockito.<String>any(), Mockito.<AppGroup>any())).thenReturn(null);
    AppGroupHelper appGroupHelper = new AppGroupHelper();
    ReflectionTestUtils.setField(appGroupHelper, "appGroupService", appGroupService);
    ReflectionTestUtils.setField(appGroupHelper, "appGroupMemberDao", mock(AppGroupMemberDao.class));

    ArrayList<Long> appIds = new ArrayList<>();
    appIds.add(1L);

    // Act
    Long actualCreateAppGroupWithAppIdsResult = appGroupHelper.createAppGroupWithAppIds("Group Name", appIds);

    // Assert
    verify(appGroupService).addApplications(eq("appGroupHelper"), eq(1L), isA(Collection.class), isA(Collection.class));
    verify(appGroupService).createNewGroup(eq("appGroupHelper"));
    verify(appGroupService).updateOverview(eq("appGroupHelper"), isA(AppGroup.class));
    assertEquals(1L, actualCreateAppGroupWithAppIdsResult.longValue());
  }

  /**
   * Method under test:
   * {@link AppGroupHelper#createAppGroupWithAppIds(String, Collection)}
   */
  @Test
  void testCreateAppGroupWithAppIds3() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupService appGroupService = mock(AppGroupService.class);
    when(appGroupService.createNewGroup(Mockito.<String>any())).thenReturn(1L);
    when(appGroupService.addApplications(Mockito.<String>any(), anyLong(), Mockito.<Collection<Long>>any(),
        Mockito.<Collection<String>>any())).thenReturn(new ArrayList<>());
    when(appGroupService.updateOverview(Mockito.<String>any(), Mockito.<AppGroup>any())).thenReturn(null);
    AppGroupHelper appGroupHelper = new AppGroupHelper();
    ReflectionTestUtils.setField(appGroupHelper, "appGroupService", appGroupService);
    ReflectionTestUtils.setField(appGroupHelper, "appGroupMemberDao", mock(AppGroupMemberDao.class));

    ArrayList<Long> appIds = new ArrayList<>();
    appIds.add(3L);
    appIds.add(1L);

    // Act
    Long actualCreateAppGroupWithAppIdsResult = appGroupHelper.createAppGroupWithAppIds("Group Name", appIds);

    // Assert
    verify(appGroupService).addApplications(eq("appGroupHelper"), eq(1L), isA(Collection.class), isA(Collection.class));
    verify(appGroupService).createNewGroup(eq("appGroupHelper"));
    verify(appGroupService).updateOverview(eq("appGroupHelper"), isA(AppGroup.class));
    assertEquals(1L, actualCreateAppGroupWithAppIdsResult.longValue());
  }

  /**
   * Method under test:
   * {@link AppGroupHelper#createAppGroupWithAppIds(String, Collection)}
   */
  @Test
  void testCreateAppGroupWithAppIds4() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupService appGroupService = mock(AppGroupService.class);
    when(appGroupService.createNewGroup(Mockito.<String>any())).thenReturn(1L);
    when(appGroupService.updateOverview(Mockito.<String>any(), Mockito.<AppGroup>any()))
        .thenThrow(new InsufficientPrivelegeException("An error occurred"));
    AppGroupHelper appGroupHelper = new AppGroupHelper();
    ReflectionTestUtils.setField(appGroupHelper, "appGroupService", appGroupService);
    ReflectionTestUtils.setField(appGroupHelper, "appGroupMemberDao", mock(AppGroupMemberDao.class));

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class,
        () -> appGroupHelper.createAppGroupWithAppIds("Group Name", new ArrayList<>()));
    verify(appGroupService).createNewGroup(eq("appGroupHelper"));
    verify(appGroupService).updateOverview(eq("appGroupHelper"), isA(AppGroup.class));
  }

  /**
   * Method under test: {@link AppGroupHelper#addOwner(Long, String)}
   */
  @Test
  void testAddOwner() {
    // Arrange
    AppGroupHelper appGroupHelper = new AppGroupHelper();
    ReflectionTestUtils.setField(appGroupHelper, "appGroupService", mock(AppGroupService.class));
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.register(anyLong(), Mockito.<String>any(), Mockito.<AppGroupMemberRole>any())).thenReturn(1);
    ReflectionTestUtils.setField(appGroupHelper, "appGroupMemberDao", appGroupMemberDao);

    // Act
    appGroupHelper.addOwner(1L, "42");

    // Assert
    verify(appGroupMemberDao).register(eq(1L), eq("42"), eq(AppGroupMemberRole.OWNER));
  }
}
