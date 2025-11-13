package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import org.finos.waltz.common.exception.InsufficientPrivelegeException;
import org.finos.waltz.data.app_group.AppGroupMemberDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.AppGroup;
import org.finos.waltz.model.app_group.AppGroupKind;
import org.finos.waltz.model.app_group.AppGroupMemberRole;
import org.finos.waltz.model.app_group.ImmutableAppGroup;
import org.finos.waltz.model.app_group.ImmutableAppGroupDetail;
import org.finos.waltz.model.app_group.ImmutableAppGroupDetail.Builder;
import org.finos.waltz.service.app_group.AppGroupService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AppGroupHelperDiffblueTest {
  @InjectMocks private AppGroupHelper appGroupHelper;

  @Mock private AppGroupMemberDao appGroupMemberDao;

  @Mock private AppGroupService appGroupService;

  /**
   * Test {@link AppGroupHelper#createAppGroupWithAppRefs(String, Collection)}.
   *
   * <p>Method under test: {@link AppGroupHelper#createAppGroupWithAppRefs(String, Collection)}
   */
  @Test
  @DisplayName("Test createAppGroupWithAppRefs(String, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AppGroupHelper.createAppGroupWithAppRefs(String, Collection)"})
  void testCreateAppGroupWithAppRefs() throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupService.createNewGroup(Mockito.<String>any())).thenReturn(1L);
    when(appGroupService.addApplications(
            Mockito.<String>any(),
            anyLong(),
            Mockito.<Collection<Long>>any(),
            Mockito.<Collection<String>>any()))
        .thenReturn(new ArrayList<>());

    Builder builderResult = ImmutableAppGroupDetail.builder();
    when(appGroupService.updateOverview(Mockito.<String>any(), Mockito.<AppGroup>any()))
        .thenReturn(
            builderResult
                .appGroup(
                    ImmutableAppGroup.builder()
                        .appGroupKind(AppGroupKind.PUBLIC)
                        .description("The characteristics of someone or something")
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    ArrayList<EntityReference> appRefs = new ArrayList<>();
    appRefs.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    Long actualCreateAppGroupWithAppRefsResult =
        appGroupHelper.createAppGroupWithAppRefs("Group Name", appRefs);

    // Assert
    verify(appGroupService)
        .addApplications(
            eq("appGroupHelper"), eq(1L), isA(Collection.class), isA(Collection.class));
    verify(appGroupService).createNewGroup("appGroupHelper");
    verify(appGroupService).updateOverview(eq("appGroupHelper"), isA(AppGroup.class));
    assertEquals(1L, actualCreateAppGroupWithAppRefsResult.longValue());
  }

  /**
   * Test {@link AppGroupHelper#createAppGroupWithAppRefs(String, Collection)}.
   *
   * <p>Method under test: {@link AppGroupHelper#createAppGroupWithAppRefs(String, Collection)}
   */
  @Test
  @DisplayName("Test createAppGroupWithAppRefs(String, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AppGroupHelper.createAppGroupWithAppRefs(String, Collection)"})
  void testCreateAppGroupWithAppRefs2() throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupService.createNewGroup(Mockito.<String>any())).thenReturn(1L);
    when(appGroupService.addApplications(
            Mockito.<String>any(),
            anyLong(),
            Mockito.<Collection<Long>>any(),
            Mockito.<Collection<String>>any()))
        .thenReturn(new ArrayList<>());

    Builder builderResult = ImmutableAppGroupDetail.builder();
    when(appGroupService.updateOverview(Mockito.<String>any(), Mockito.<AppGroup>any()))
        .thenReturn(
            builderResult
                .appGroup(
                    ImmutableAppGroup.builder()
                        .appGroupKind(AppGroupKind.PUBLIC)
                        .description("The characteristics of someone or something")
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    ArrayList<EntityReference> appRefs = new ArrayList<>();
    appRefs.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    appRefs.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    Long actualCreateAppGroupWithAppRefsResult =
        appGroupHelper.createAppGroupWithAppRefs("Group Name", appRefs);

    // Assert
    verify(appGroupService)
        .addApplications(
            eq("appGroupHelper"), eq(1L), isA(Collection.class), isA(Collection.class));
    verify(appGroupService).createNewGroup("appGroupHelper");
    verify(appGroupService).updateOverview(eq("appGroupHelper"), isA(AppGroup.class));
    assertEquals(1L, actualCreateAppGroupWithAppRefsResult.longValue());
  }

  /**
   * Test {@link AppGroupHelper#createAppGroupWithAppRefs(String, Collection)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupHelper#createAppGroupWithAppRefs(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test createAppGroupWithAppRefs(String, Collection); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AppGroupHelper.createAppGroupWithAppRefs(String, Collection)"})
  void testCreateAppGroupWithAppRefs_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupService.createNewGroup(Mockito.<String>any())).thenReturn(1L);
    when(appGroupService.updateOverview(Mockito.<String>any(), Mockito.<AppGroup>any()))
        .thenThrow(new InsufficientPrivelegeException("An error occurred"));

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () -> appGroupHelper.createAppGroupWithAppRefs("Group Name", new ArrayList<>()));
    verify(appGroupService).createNewGroup("appGroupHelper");
    verify(appGroupService).updateOverview(eq("appGroupHelper"), isA(AppGroup.class));
  }

  /**
   * Test {@link AppGroupHelper#createAppGroupWithAppRefs(String, Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupHelper#createAppGroupWithAppRefs(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test createAppGroupWithAppRefs(String, Collection); when ArrayList(); then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AppGroupHelper.createAppGroupWithAppRefs(String, Collection)"})
  void testCreateAppGroupWithAppRefs_whenArrayList_thenReturnLongValueIsOne()
      throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupService.createNewGroup(Mockito.<String>any())).thenReturn(1L);
    when(appGroupService.addApplications(
            Mockito.<String>any(),
            anyLong(),
            Mockito.<Collection<Long>>any(),
            Mockito.<Collection<String>>any()))
        .thenReturn(new ArrayList<>());

    Builder builderResult = ImmutableAppGroupDetail.builder();
    when(appGroupService.updateOverview(Mockito.<String>any(), Mockito.<AppGroup>any()))
        .thenReturn(
            builderResult
                .appGroup(
                    ImmutableAppGroup.builder()
                        .appGroupKind(AppGroupKind.PUBLIC)
                        .description("The characteristics of someone or something")
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    // Act
    Long actualCreateAppGroupWithAppRefsResult =
        appGroupHelper.createAppGroupWithAppRefs("Group Name", new ArrayList<>());

    // Assert
    verify(appGroupService)
        .addApplications(
            eq("appGroupHelper"), eq(1L), isA(Collection.class), isA(Collection.class));
    verify(appGroupService).createNewGroup("appGroupHelper");
    verify(appGroupService).updateOverview(eq("appGroupHelper"), isA(AppGroup.class));
    assertEquals(1L, actualCreateAppGroupWithAppRefsResult.longValue());
  }

  /**
   * Test {@link AppGroupHelper#createAppGroupWithAppIds(String, Collection)}.
   *
   * <ul>
   *   <li>Given minus two.
   *   <li>When {@link ArrayList#ArrayList()} add minus two.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupHelper#createAppGroupWithAppIds(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test createAppGroupWithAppIds(String, Collection); given minus two; when ArrayList() add minus two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AppGroupHelper.createAppGroupWithAppIds(String, Collection)"})
  void testCreateAppGroupWithAppIds_givenMinusTwo_whenArrayListAddMinusTwo()
      throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupService.createNewGroup(Mockito.<String>any())).thenReturn(1L);
    when(appGroupService.addApplications(
            Mockito.<String>any(),
            anyLong(),
            Mockito.<Collection<Long>>any(),
            Mockito.<Collection<String>>any()))
        .thenReturn(new ArrayList<>());

    Builder builderResult = ImmutableAppGroupDetail.builder();
    when(appGroupService.updateOverview(Mockito.<String>any(), Mockito.<AppGroup>any()))
        .thenReturn(
            builderResult
                .appGroup(
                    ImmutableAppGroup.builder()
                        .appGroupKind(AppGroupKind.PUBLIC)
                        .description("The characteristics of someone or something")
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    ArrayList<Long> appIds = new ArrayList<>();
    appIds.add(-2L);
    appIds.add(3L);

    // Act
    Long actualCreateAppGroupWithAppIdsResult =
        appGroupHelper.createAppGroupWithAppIds("Group Name", appIds);

    // Assert
    verify(appGroupService)
        .addApplications(
            eq("appGroupHelper"), eq(1L), isA(Collection.class), isA(Collection.class));
    verify(appGroupService).createNewGroup("appGroupHelper");
    verify(appGroupService).updateOverview(eq("appGroupHelper"), isA(AppGroup.class));
    assertEquals(1L, actualCreateAppGroupWithAppIdsResult.longValue());
  }

  /**
   * Test {@link AppGroupHelper#createAppGroupWithAppIds(String, Collection)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>When {@link ArrayList#ArrayList()} add three.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupHelper#createAppGroupWithAppIds(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test createAppGroupWithAppIds(String, Collection); given three; when ArrayList() add three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AppGroupHelper.createAppGroupWithAppIds(String, Collection)"})
  void testCreateAppGroupWithAppIds_givenThree_whenArrayListAddThree()
      throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupService.createNewGroup(Mockito.<String>any())).thenReturn(1L);
    when(appGroupService.addApplications(
            Mockito.<String>any(),
            anyLong(),
            Mockito.<Collection<Long>>any(),
            Mockito.<Collection<String>>any()))
        .thenReturn(new ArrayList<>());

    Builder builderResult = ImmutableAppGroupDetail.builder();
    when(appGroupService.updateOverview(Mockito.<String>any(), Mockito.<AppGroup>any()))
        .thenReturn(
            builderResult
                .appGroup(
                    ImmutableAppGroup.builder()
                        .appGroupKind(AppGroupKind.PUBLIC)
                        .description("The characteristics of someone or something")
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    ArrayList<Long> appIds = new ArrayList<>();
    appIds.add(3L);

    // Act
    Long actualCreateAppGroupWithAppIdsResult =
        appGroupHelper.createAppGroupWithAppIds("Group Name", appIds);

    // Assert
    verify(appGroupService)
        .addApplications(
            eq("appGroupHelper"), eq(1L), isA(Collection.class), isA(Collection.class));
    verify(appGroupService).createNewGroup("appGroupHelper");
    verify(appGroupService).updateOverview(eq("appGroupHelper"), isA(AppGroup.class));
    assertEquals(1L, actualCreateAppGroupWithAppIdsResult.longValue());
  }

  /**
   * Test {@link AppGroupHelper#createAppGroupWithAppIds(String, Collection)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupHelper#createAppGroupWithAppIds(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test createAppGroupWithAppIds(String, Collection); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AppGroupHelper.createAppGroupWithAppIds(String, Collection)"})
  void testCreateAppGroupWithAppIds_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupService.createNewGroup(Mockito.<String>any())).thenReturn(1L);
    when(appGroupService.updateOverview(Mockito.<String>any(), Mockito.<AppGroup>any()))
        .thenThrow(new InsufficientPrivelegeException("An error occurred"));

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () -> appGroupHelper.createAppGroupWithAppIds("Group Name", new ArrayList<>()));
    verify(appGroupService).createNewGroup("appGroupHelper");
    verify(appGroupService).updateOverview(eq("appGroupHelper"), isA(AppGroup.class));
  }

  /**
   * Test {@link AppGroupHelper#createAppGroupWithAppIds(String, Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupHelper#createAppGroupWithAppIds(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test createAppGroupWithAppIds(String, Collection); when ArrayList(); then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AppGroupHelper.createAppGroupWithAppIds(String, Collection)"})
  void testCreateAppGroupWithAppIds_whenArrayList_thenReturnLongValueIsOne()
      throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupService.createNewGroup(Mockito.<String>any())).thenReturn(1L);
    when(appGroupService.addApplications(
            Mockito.<String>any(),
            anyLong(),
            Mockito.<Collection<Long>>any(),
            Mockito.<Collection<String>>any()))
        .thenReturn(new ArrayList<>());

    Builder builderResult = ImmutableAppGroupDetail.builder();
    when(appGroupService.updateOverview(Mockito.<String>any(), Mockito.<AppGroup>any()))
        .thenReturn(
            builderResult
                .appGroup(
                    ImmutableAppGroup.builder()
                        .appGroupKind(AppGroupKind.PUBLIC)
                        .description("The characteristics of someone or something")
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    // Act
    Long actualCreateAppGroupWithAppIdsResult =
        appGroupHelper.createAppGroupWithAppIds("Group Name", new ArrayList<>());

    // Assert
    verify(appGroupService)
        .addApplications(
            eq("appGroupHelper"), eq(1L), isA(Collection.class), isA(Collection.class));
    verify(appGroupService).createNewGroup("appGroupHelper");
    verify(appGroupService).updateOverview(eq("appGroupHelper"), isA(AppGroup.class));
    assertEquals(1L, actualCreateAppGroupWithAppIdsResult.longValue());
  }

  /**
   * Test {@link AppGroupHelper#addOwner(Long, String)}.
   *
   * <p>Method under test: {@link AppGroupHelper#addOwner(Long, String)}
   */
  @Test
  @DisplayName("Test addOwner(Long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupHelper.addOwner(Long, String)"})
  void testAddOwner() {
    // Arrange
    when(appGroupMemberDao.register(
            anyLong(), Mockito.<String>any(), Mockito.<AppGroupMemberRole>any()))
        .thenReturn(1);

    // Act
    appGroupHelper.addOwner(1L, "42");

    // Assert
    verify(appGroupMemberDao).register(1L, "42", AppGroupMemberRole.OWNER);
  }
}
