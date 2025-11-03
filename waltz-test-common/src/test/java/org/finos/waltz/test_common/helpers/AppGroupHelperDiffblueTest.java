package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import org.finos.waltz.common.exception.InsufficientPrivelegeException;
import org.finos.waltz.data.app_group.AppGroupMemberDao;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.app_group.AppGroup;
import org.finos.waltz.model.app_group.AppGroupMemberRole;
import org.finos.waltz.service.app_group.AppGroupService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class AppGroupHelperDiffblueTest {
  @InjectMocks
  private AppGroupHelper appGroupHelper;

  @Mock
  private AppGroupMemberDao appGroupMemberDao;

  @Mock
  private AppGroupService appGroupService;

  /**
   * Test {@link AppGroupHelper#createAppGroupWithAppRefs(String, Collection)}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#id()} return one.</li>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppGroupHelper#createAppGroupWithAppRefs(String, Collection)}
   */
  @Test
  @DisplayName("Test createAppGroupWithAppRefs(String, Collection); given EntityReference id() return one; then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long AppGroupHelper.createAppGroupWithAppRefs(String, Collection)"})
  void testCreateAppGroupWithAppRefs_givenEntityReferenceIdReturnOne_thenCallsId()
      throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupService.createNewGroup(Mockito.<String>any())).thenReturn(1L);
    when(appGroupService.addApplications(Mockito.<String>any(), anyLong(), Mockito.<Collection<Long>>any(),
        Mockito.<Collection<String>>any())).thenReturn(new ArrayList<>());
    when(appGroupService.updateOverview(Mockito.<String>any(), Mockito.<AppGroup>any())).thenReturn(null);
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
   * Test {@link AppGroupHelper#createAppGroupWithAppRefs(String, Collection)}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#id()} return one.</li>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppGroupHelper#createAppGroupWithAppRefs(String, Collection)}
   */
  @Test
  @DisplayName("Test createAppGroupWithAppRefs(String, Collection); given EntityReference id() return one; then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long AppGroupHelper.createAppGroupWithAppRefs(String, Collection)"})
  void testCreateAppGroupWithAppRefs_givenEntityReferenceIdReturnOne_thenCallsId2()
      throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupService.createNewGroup(Mockito.<String>any())).thenReturn(1L);
    when(appGroupService.addApplications(Mockito.<String>any(), anyLong(), Mockito.<Collection<Long>>any(),
        Mockito.<Collection<String>>any())).thenReturn(new ArrayList<>());
    when(appGroupService.updateOverview(Mockito.<String>any(), Mockito.<AppGroup>any())).thenReturn(null);
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
   * Test {@link AppGroupHelper#createAppGroupWithAppRefs(String, Collection)}.
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppGroupHelper#createAppGroupWithAppRefs(String, Collection)}
   */
  @Test
  @DisplayName("Test createAppGroupWithAppRefs(String, Collection); then throw InsufficientPrivelegeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long AppGroupHelper.createAppGroupWithAppRefs(String, Collection)"})
  void testCreateAppGroupWithAppRefs_thenThrowInsufficientPrivelegeException() throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupService.createNewGroup(Mockito.<String>any())).thenReturn(1L);
    when(appGroupService.updateOverview(Mockito.<String>any(), Mockito.<AppGroup>any()))
        .thenThrow(new InsufficientPrivelegeException("An error occurred"));

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class,
        () -> appGroupHelper.createAppGroupWithAppRefs("Group Name", new LinkedList<>()));
    verify(appGroupService).createNewGroup(eq("appGroupHelper"));
    verify(appGroupService).updateOverview(eq("appGroupHelper"), isA(AppGroup.class));
  }

  /**
   * Test {@link AppGroupHelper#createAppGroupWithAppRefs(String, Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppGroupHelper#createAppGroupWithAppRefs(String, Collection)}
   */
  @Test
  @DisplayName("Test createAppGroupWithAppRefs(String, Collection); when ArrayList(); then return longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long AppGroupHelper.createAppGroupWithAppRefs(String, Collection)"})
  void testCreateAppGroupWithAppRefs_whenArrayList_thenReturnLongValueIsOne() throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupService.createNewGroup(Mockito.<String>any())).thenReturn(1L);
    when(appGroupService.addApplications(Mockito.<String>any(), anyLong(), Mockito.<Collection<Long>>any(),
        Mockito.<Collection<String>>any())).thenReturn(new ArrayList<>());
    when(appGroupService.updateOverview(Mockito.<String>any(), Mockito.<AppGroup>any())).thenReturn(null);

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
   * Test {@link AppGroupHelper#createAppGroupWithAppIds(String, Collection)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link ArrayList#ArrayList()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppGroupHelper#createAppGroupWithAppIds(String, Collection)}
   */
  @Test
  @DisplayName("Test createAppGroupWithAppIds(String, Collection); given one; when ArrayList() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long AppGroupHelper.createAppGroupWithAppIds(String, Collection)"})
  void testCreateAppGroupWithAppIds_givenOne_whenArrayListAddOne() throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupService.createNewGroup(Mockito.<String>any())).thenReturn(1L);
    when(appGroupService.addApplications(Mockito.<String>any(), anyLong(), Mockito.<Collection<Long>>any(),
        Mockito.<Collection<String>>any())).thenReturn(new ArrayList<>());
    when(appGroupService.updateOverview(Mockito.<String>any(), Mockito.<AppGroup>any())).thenReturn(null);

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
   * Test {@link AppGroupHelper#createAppGroupWithAppIds(String, Collection)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>When {@link ArrayList#ArrayList()} add three.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppGroupHelper#createAppGroupWithAppIds(String, Collection)}
   */
  @Test
  @DisplayName("Test createAppGroupWithAppIds(String, Collection); given three; when ArrayList() add three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long AppGroupHelper.createAppGroupWithAppIds(String, Collection)"})
  void testCreateAppGroupWithAppIds_givenThree_whenArrayListAddThree() throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupService.createNewGroup(Mockito.<String>any())).thenReturn(1L);
    when(appGroupService.addApplications(Mockito.<String>any(), anyLong(), Mockito.<Collection<Long>>any(),
        Mockito.<Collection<String>>any())).thenReturn(new ArrayList<>());
    when(appGroupService.updateOverview(Mockito.<String>any(), Mockito.<AppGroup>any())).thenReturn(null);

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
   * Test {@link AppGroupHelper#createAppGroupWithAppIds(String, Collection)}.
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppGroupHelper#createAppGroupWithAppIds(String, Collection)}
   */
  @Test
  @DisplayName("Test createAppGroupWithAppIds(String, Collection); then throw InsufficientPrivelegeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long AppGroupHelper.createAppGroupWithAppIds(String, Collection)"})
  void testCreateAppGroupWithAppIds_thenThrowInsufficientPrivelegeException() throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupService.createNewGroup(Mockito.<String>any())).thenReturn(1L);
    when(appGroupService.updateOverview(Mockito.<String>any(), Mockito.<AppGroup>any()))
        .thenThrow(new InsufficientPrivelegeException("An error occurred"));

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class,
        () -> appGroupHelper.createAppGroupWithAppIds("Group Name", new ArrayList<>()));
    verify(appGroupService).createNewGroup(eq("appGroupHelper"));
    verify(appGroupService).updateOverview(eq("appGroupHelper"), isA(AppGroup.class));
  }

  /**
   * Test {@link AppGroupHelper#createAppGroupWithAppIds(String, Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppGroupHelper#createAppGroupWithAppIds(String, Collection)}
   */
  @Test
  @DisplayName("Test createAppGroupWithAppIds(String, Collection); when ArrayList(); then return longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long AppGroupHelper.createAppGroupWithAppIds(String, Collection)"})
  void testCreateAppGroupWithAppIds_whenArrayList_thenReturnLongValueIsOne() throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupService.createNewGroup(Mockito.<String>any())).thenReturn(1L);
    when(appGroupService.addApplications(Mockito.<String>any(), anyLong(), Mockito.<Collection<Long>>any(),
        Mockito.<Collection<String>>any())).thenReturn(new ArrayList<>());
    when(appGroupService.updateOverview(Mockito.<String>any(), Mockito.<AppGroup>any())).thenReturn(null);

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
   * Test {@link AppGroupHelper#addOwner(Long, String)}.
   * <p>
   * Method under test: {@link AppGroupHelper#addOwner(Long, String)}
   */
  @Test
  @DisplayName("Test addOwner(Long, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AppGroupHelper.addOwner(Long, String)"})
  void testAddOwner() {
    // Arrange
    when(appGroupMemberDao.register(anyLong(), Mockito.<String>any(), Mockito.<AppGroupMemberRole>any())).thenReturn(1);

    // Act
    appGroupHelper.addOwner(1L, "42");

    // Assert
    verify(appGroupMemberDao).register(eq(1L), eq("42"), eq(AppGroupMemberRole.OWNER));
  }
}
