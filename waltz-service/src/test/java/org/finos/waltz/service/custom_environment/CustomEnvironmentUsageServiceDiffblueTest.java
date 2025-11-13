package org.finos.waltz.service.custom_environment;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.common.exception.InsufficientPrivelegeException;
import org.finos.waltz.data.custom_environment.CustomEnvironmentUsageDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.custom_environment.CustomEnvironmentUsage;
import org.finos.waltz.model.custom_environment.CustomEnvironmentUsageInfo;
import org.finos.waltz.model.custom_environment.ImmutableCustomEnvironment;
import org.finos.waltz.model.custom_environment.ImmutableCustomEnvironment.Builder;
import org.finos.waltz.model.custom_environment.ImmutableCustomEnvironmentUsage;
import org.finos.waltz.model.permission_group.CheckPermissionCommand;
import org.finos.waltz.service.permission.PermissionGroupService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CustomEnvironmentUsageServiceDiffblueTest {
  @Mock private CustomEnvironmentService customEnvironmentService;

  @Mock private CustomEnvironmentUsageDao customEnvironmentUsageDao;

  @InjectMocks private CustomEnvironmentUsageService customEnvironmentUsageService;

  @Mock private PermissionGroupService permissionGroupService;

  /**
   * Test {@link CustomEnvironmentUsageService#findUsagesByOwningEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * CustomEnvironmentUsageService#findUsagesByOwningEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findUsagesByOwningEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set CustomEnvironmentUsageService.findUsagesByOwningEntityRef(EntityReference)"
  })
  void testFindUsagesByOwningEntityRef() {
    // Arrange
    when(customEnvironmentUsageDao.findByOwningEntityRef(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<CustomEnvironmentUsage> actualFindUsagesByOwningEntityRefResult =
        customEnvironmentUsageService.findUsagesByOwningEntityRef(null);

    // Assert
    verify(customEnvironmentUsageDao).findByOwningEntityRef(isNull());
    assertTrue(actualFindUsagesByOwningEntityRefResult.isEmpty());
  }

  /**
   * Test {@link CustomEnvironmentUsageService#addAsset(CustomEnvironmentUsage, String)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomEnvironmentUsageService#addAsset(CustomEnvironmentUsage,
   * String)}
   */
  @Test
  @DisplayName(
      "Test addAsset(CustomEnvironmentUsage, String); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long CustomEnvironmentUsageService.addAsset(CustomEnvironmentUsage, String)"})
  void testAddAsset_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    when(customEnvironmentService.getById(Mockito.<Long>any()))
        .thenReturn(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(permissionGroupService.hasPermission(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(false);

    ImmutableCustomEnvironmentUsage.Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () ->
            customEnvironmentUsageService.addAsset(
                customEnvironmentIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .provenance("Provenance")
                    .build(),
                "Username"));
    verify(customEnvironmentService).getById(1L);
    verify(permissionGroupService).hasPermission(isA(CheckPermissionCommand.class));
  }

  /**
   * Test {@link CustomEnvironmentUsageService#findUsageInfoByOwningEntity(EntityReference)}.
   *
   * <p>Method under test: {@link
   * CustomEnvironmentUsageService#findUsageInfoByOwningEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findUsageInfoByOwningEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set CustomEnvironmentUsageService.findUsageInfoByOwningEntity(EntityReference)"
  })
  void testFindUsageInfoByOwningEntity() {
    // Arrange
    when(customEnvironmentUsageDao.findUsageInfoByOwningRef(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<CustomEnvironmentUsageInfo> actualFindUsageInfoByOwningEntityResult =
        customEnvironmentUsageService.findUsageInfoByOwningEntity(null);

    // Assert
    verify(customEnvironmentUsageDao).findUsageInfoByOwningRef(isNull());
    assertTrue(actualFindUsageInfoByOwningEntityResult.isEmpty());
  }
}
