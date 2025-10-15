package org.finos.waltz.service.permission.permission_checker;

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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.involvement.InvolvementDao;
import org.finos.waltz.data.involvement_kind.InvolvementKindDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.permission.PermissionGroupDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.person.search.PersonSearchDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.role.RoleDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlow;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlow.Builder;
import org.finos.waltz.model.permission_group.ImmutablePermission;
import org.finos.waltz.model.permission_group.ImmutableRequiredInvolvementsResult;
import org.finos.waltz.model.permission_group.Permission;
import org.finos.waltz.model.person.ImmutablePerson;
import org.finos.waltz.model.person.PersonKind;
import org.finos.waltz.model.physical_specification.DataFormatKindValue;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecification;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.involvement.InvolvementService;
import org.finos.waltz.service.involvement_kind.InvolvementKindService;
import org.finos.waltz.service.permission.PermissionGroupService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FlowPermissionCheckerDiffblueTest {
  @InjectMocks private FlowPermissionChecker flowPermissionChecker;

  @Mock private InvolvementService involvementService;

  @Mock private LogicalFlowDao logicalFlowDao;

  @Mock private PermissionGroupService permissionGroupService;

  @Mock private PhysicalSpecificationDao physicalSpecificationDao;

  @Mock private UserRoleService userRoleService;

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference, String)}.
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findPermissionsForDecorator(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findPermissionsForDecorator(EntityReference, String)"
  })
  void testFindPermissionsForDecorator() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            flowPermissionChecker.findPermissionsForDecorator(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                "janedoe"));
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference, String)}.
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findPermissionsForDecorator(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findPermissionsForDecorator(EntityReference, String)"
  })
  void testFindPermissionsForDecorator2() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> flowPermissionChecker.findPermissionsForDecorator(entityReference, "janedoe"));
    verify(entityReference).kind();
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference, String)}.
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findPermissionsForDecorator(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findPermissionsForDecorator(EntityReference, String)"
  })
  void testFindPermissionsForDecorator3() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenThrow(new UnsupportedOperationException());
    when(entityReference.kind()).thenReturn(EntityKind.LOGICAL_DATA_FLOW);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> flowPermissionChecker.findPermissionsForDecorator(entityReference, "janedoe"));
    verify(entityReference).id();
    verify(entityReference).kind();
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference, String)}.
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findPermissionsForDecorator(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findPermissionsForDecorator(EntityReference, String)"
  })
  void testFindPermissionsForDecorator4() {
    // Arrange
    when(logicalFlowDao.getByFlowId(anyLong())).thenThrow(new UnsupportedOperationException());

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.LOGICAL_DATA_FLOW);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> flowPermissionChecker.findPermissionsForDecorator(entityReference, "janedoe"));
    verify(logicalFlowDao).getByFlowId(1L);
    verify(entityReference).id();
    verify(entityReference).kind();
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference, String)}.
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findPermissionsForDecorator(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findPermissionsForDecorator(EntityReference, String)"
  })
  void testFindPermissionsForDecorator5() {
    // Arrange
    when(logicalFlowDao.calculateAmendedFlowOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.LOGICAL_DATA_FLOW);

    // Act
    Set<Operation> actualFindPermissionsForDecoratorResult =
        flowPermissionChecker.findPermissionsForDecorator(entityReference, "janedoe");

    // Assert
    verify(logicalFlowDao, atLeast(1))
        .calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(logicalFlowDao).getByFlowId(1L);
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(involvementService, atLeast(1))
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(permissionGroupService, atLeast(1))
        .findPermissionsForParentReference(isA(EntityReference.class), eq("janedoe"));
    assertTrue(actualFindPermissionsForDecoratorResult.isEmpty());
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference, String)}.
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findPermissionsForDecorator(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findPermissionsForDecorator(EntityReference, String)"
  })
  void testFindPermissionsForDecorator6() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.LOGICAL_DATA_FLOW);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> flowPermissionChecker.findPermissionsForDecorator(entityReference, "janedoe"));
    verify(logicalFlowDao).getByFlowId(1L);
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(involvementService)
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference, String)}.
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findPermissionsForDecorator(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findPermissionsForDecorator(EntityReference, String)"
  })
  void testFindPermissionsForDecorator7() {
    // Arrange
    when(logicalFlowDao.calculateAmendedFlowOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    HashSet<Permission> permissionSet = new HashSet<>();

    ImmutablePermission.Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    ImmutablePermission.Builder qualifierReferenceResult =
        parentKindResult.qualifierReference(qualifierReference);
    permissionSet.add(
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(permissionSet);

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.LOGICAL_DATA_FLOW);

    // Act
    Set<Operation> actualFindPermissionsForDecoratorResult =
        flowPermissionChecker.findPermissionsForDecorator(entityReference, "janedoe");

    // Assert
    verify(logicalFlowDao, atLeast(1))
        .calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(logicalFlowDao).getByFlowId(1L);
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(involvementService, atLeast(1))
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(permissionGroupService, atLeast(1))
        .findPermissionsForParentReference(isA(EntityReference.class), eq("janedoe"));
    assertTrue(actualFindPermissionsForDecoratorResult.isEmpty());
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference, String)}.
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findPermissionsForDecorator(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findPermissionsForDecorator(EntityReference, String)"
  })
  void testFindPermissionsForDecorator8() {
    // Arrange
    when(logicalFlowDao.calculateAmendedFlowOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.LOGICAL_DATA_FLOW);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> flowPermissionChecker.findPermissionsForDecorator(entityReference, "janedoe"));
    verify(logicalFlowDao).calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(logicalFlowDao).getByFlowId(1L);
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(involvementService)
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(permissionGroupService)
        .findPermissionsForParentReference(isA(EntityReference.class), eq("janedoe"));
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference, String)}.
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findPermissionsForDecorator(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findPermissionsForDecorator(EntityReference, String)"
  })
  void testFindPermissionsForDecorator9() {
    // Arrange
    when(physicalSpecificationDao.getById(anyLong()))
        .thenThrow(new UnsupportedOperationException());

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.PHYSICAL_SPECIFICATION);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> flowPermissionChecker.findPermissionsForDecorator(entityReference, "janedoe"));
    verify(physicalSpecificationDao).getById(1L);
    verify(entityReference).id();
    verify(entityReference).kind();
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference, String)}.
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findPermissionsForDecorator(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findPermissionsForDecorator(EntityReference, String)"
  })
  void testFindPermissionsForDecorator10() {
    // Arrange
    when(physicalSpecificationDao.calculateAmendedSpecOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(physicalSpecificationDao.getById(anyLong()))
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
                .provenance("Provenance")
                .build());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.PHYSICAL_SPECIFICATION);

    // Act
    Set<Operation> actualFindPermissionsForDecoratorResult =
        flowPermissionChecker.findPermissionsForDecorator(entityReference, "janedoe");

    // Assert
    verify(physicalSpecificationDao).calculateAmendedSpecOperations(isA(Set.class), eq("janedoe"));
    verify(physicalSpecificationDao).getById(1L);
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(involvementService)
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(permissionGroupService)
        .findPermissionsForParentReference(isA(EntityReference.class), eq("janedoe"));
    assertTrue(actualFindPermissionsForDecoratorResult.isEmpty());
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference, String)}.
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findPermissionsForDecorator(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findPermissionsForDecorator(EntityReference, String)"
  })
  void testFindPermissionsForDecorator11() {
    // Arrange
    when(physicalSpecificationDao.calculateAmendedSpecOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(physicalSpecificationDao.getById(anyLong()))
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
                .provenance("Provenance")
                .build());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.PHYSICAL_SPECIFICATION);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> flowPermissionChecker.findPermissionsForDecorator(entityReference, "janedoe"));
    verify(physicalSpecificationDao).calculateAmendedSpecOperations(isA(Set.class), eq("janedoe"));
    verify(physicalSpecificationDao).getById(1L);
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(involvementService)
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(permissionGroupService)
        .findPermissionsForParentReference(isA(EntityReference.class), eq("janedoe"));
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference, String)}.
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findPermissionsForDecorator(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findPermissionsForDecorator(EntityReference, String)"
  })
  void testFindPermissionsForDecorator12() {
    // Arrange
    when(physicalSpecificationDao.calculateAmendedSpecOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(physicalSpecificationDao.getById(anyLong()))
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
                .provenance("Provenance")
                .build());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    HashSet<Permission> permissionSet = new HashSet<>();

    ImmutablePermission.Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    ImmutablePermission.Builder qualifierReferenceResult =
        parentKindResult.qualifierReference(qualifierReference);
    permissionSet.add(
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(permissionSet);

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.PHYSICAL_SPECIFICATION);

    // Act
    Set<Operation> actualFindPermissionsForDecoratorResult =
        flowPermissionChecker.findPermissionsForDecorator(entityReference, "janedoe");

    // Assert
    verify(physicalSpecificationDao).calculateAmendedSpecOperations(isA(Set.class), eq("janedoe"));
    verify(physicalSpecificationDao).getById(1L);
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(involvementService)
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(permissionGroupService)
        .findPermissionsForParentReference(isA(EntityReference.class), eq("janedoe"));
    assertTrue(actualFindPermissionsForDecoratorResult.isEmpty());
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference, String)}.
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findPermissionsForDecorator(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findPermissionsForDecorator(EntityReference, String)"
  })
  void testFindPermissionsForDecorator13() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            flowPermissionChecker.findPermissionsForDecorator(
                ImmutableEntityReference.builder()
                    .description("Entity reference cannot be null")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                "janedoe"));
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference, String)}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>When {@link EntityReference} {@link EntityReference#kind()} return {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findPermissionsForDecorator(EntityReference, String); given 'ALL'; when EntityReference kind() return 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findPermissionsForDecorator(EntityReference, String)"
  })
  void testFindPermissionsForDecorator_givenAll_whenEntityReferenceKindReturnAll() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> flowPermissionChecker.findPermissionsForDecorator(entityReference, "janedoe"));
    verify(entityReference, atLeast(1)).kind();
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference, String)}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementDao#findExistingInvolvementKindIdsForUser(EntityReference,
   *       String)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findPermissionsForDecorator(EntityReference, String); then calls findExistingInvolvementKindIdsForUser(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findPermissionsForDecorator(EntityReference, String)"
  })
  void testFindPermissionsForDecorator_thenCallsFindExistingInvolvementKindIdsForUser() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.calculateAmendedFlowOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao2,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    PersonDao personDao3 = mock(PersonDao.class);
    when(personDao3.getByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    PersonService personService2 = new PersonService(personDao3, mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    when(permissionGroupDao.findPermissionsForParentEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao2 = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao3 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao2 = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService2 =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService2 =
        new InvolvementService(
            changeLogService3,
            dao2,
            logicalFlowDao3,
            physicalFlowDao2,
            entityReferenceNameResolver2,
            involvementKindService2,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService2, permissionGroupDao, involvementService2);
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    UserRoleDao userRoleDao2 = mock(UserRoleDao.class);
    RoleDao roleDao2 = mock(RoleDao.class);
    PersonDao personDao4 = mock(PersonDao.class);
    ChangeLogService changeLogService4 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService3 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    UserRoleService userRoleService2 =
        new UserRoleService(
            userRoleDao2,
            roleDao2,
            personDao4,
            changeLogService4,
            personService3,
            settingsService2);

    FlowPermissionChecker flowPermissionChecker =
        new FlowPermissionChecker(
            logicalFlowDao,
            physicalSpecificationDao,
            involvementService,
            permissionGroupService,
            userRoleService2);

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.LOGICAL_DATA_FLOW);

    // Act
    Set<Operation> actualFindPermissionsForDecoratorResult =
        flowPermissionChecker.findPermissionsForDecorator(entityReference, "janedoe");

    // Assert
    verify(dao, atLeast(1))
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(logicalFlowDao, atLeast(1))
        .calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(logicalFlowDao).getByFlowId(1L);
    verify(permissionGroupDao, atLeast(1))
        .findPermissionsForParentEntityReference(isA(EntityReference.class));
    verify(personDao3, atLeast(1)).getByUserEmail("janedoe");
    verify(entityReference).id();
    verify(entityReference).kind();
    assertTrue(actualFindPermissionsForDecoratorResult.isEmpty());
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForSpec(long, String)}.
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForSpec(long, String)}
   */
  @Test
  @DisplayName("Test findPermissionsForSpec(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowPermissionChecker.findPermissionsForSpec(long, String)"})
  void testFindPermissionsForSpec() {
    // Arrange
    when(physicalSpecificationDao.getById(anyLong()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> flowPermissionChecker.findPermissionsForSpec(1L, "janedoe"));
    verify(physicalSpecificationDao).getById(1L);
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForSpec(long, String)}.
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForSpec(long, String)}
   */
  @Test
  @DisplayName("Test findPermissionsForSpec(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowPermissionChecker.findPermissionsForSpec(long, String)"})
  void testFindPermissionsForSpec2() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(physicalSpecificationDao.getById(anyLong()))
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
                .provenance("Provenance")
                .build());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> flowPermissionChecker.findPermissionsForSpec(1L, "janedoe"));
    verify(physicalSpecificationDao).getById(1L);
    verify(involvementService)
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForSpec(long, String)}.
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForSpec(long, String)}
   */
  @Test
  @DisplayName("Test findPermissionsForSpec(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowPermissionChecker.findPermissionsForSpec(long, String)"})
  void testFindPermissionsForSpec3() {
    // Arrange
    when(physicalSpecificationDao.calculateAmendedSpecOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(physicalSpecificationDao.getById(anyLong()))
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
                .provenance("Provenance")
                .build());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    HashSet<Permission> permissionSet = new HashSet<>();

    ImmutablePermission.Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    ImmutablePermission.Builder qualifierReferenceResult =
        parentKindResult.qualifierReference(qualifierReference);
    permissionSet.add(
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(permissionSet);

    // Act
    Set<Operation> actualFindPermissionsForSpecResult =
        flowPermissionChecker.findPermissionsForSpec(1L, "janedoe");

    // Assert
    verify(physicalSpecificationDao).calculateAmendedSpecOperations(isA(Set.class), eq("janedoe"));
    verify(physicalSpecificationDao).getById(1L);
    verify(involvementService)
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(permissionGroupService)
        .findPermissionsForParentReference(isA(EntityReference.class), eq("janedoe"));
    assertTrue(actualFindPermissionsForSpecResult.isEmpty());
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForSpec(long, String)}.
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForSpec(long, String)}
   */
  @Test
  @DisplayName("Test findPermissionsForSpec(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowPermissionChecker.findPermissionsForSpec(long, String)"})
  void testFindPermissionsForSpec4() {
    // Arrange
    when(physicalSpecificationDao.calculateAmendedSpecOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(physicalSpecificationDao.getById(anyLong()))
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
                .provenance("Provenance")
                .build());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> flowPermissionChecker.findPermissionsForSpec(1L, "janedoe"));
    verify(physicalSpecificationDao).calculateAmendedSpecOperations(isA(Set.class), eq("janedoe"));
    verify(physicalSpecificationDao).getById(1L);
    verify(involvementService)
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(permissionGroupService)
        .findPermissionsForParentReference(isA(EntityReference.class), eq("janedoe"));
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForSpec(long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementDao#findExistingInvolvementKindIdsForUser(EntityReference,
   *       String)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForSpec(long, String)}
   */
  @Test
  @DisplayName(
      "Test findPermissionsForSpec(long, String); then calls findExistingInvolvementKindIdsForUser(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowPermissionChecker.findPermissionsForSpec(long, String)"})
  void testFindPermissionsForSpec_thenCallsFindExistingInvolvementKindIdsForUser() {
    // Arrange
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    when(physicalSpecificationDao.calculateAmendedSpecOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(physicalSpecificationDao.getById(anyLong()))
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
                .provenance("Provenance")
                .build());

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    PersonDao personDao3 = mock(PersonDao.class);
    when(personDao3.getByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    PersonService personService2 = new PersonService(personDao3, mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    when(permissionGroupDao.findPermissionsForParentEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao2 = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao2 = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService2 =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService2 =
        new InvolvementService(
            changeLogService3,
            dao2,
            logicalFlowDao2,
            physicalFlowDao2,
            entityReferenceNameResolver2,
            involvementKindService2,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService2, permissionGroupDao, involvementService2);
    LogicalFlowDao logicalFlowDao3 = mock(LogicalFlowDao.class);
    UserRoleDao userRoleDao2 = mock(UserRoleDao.class);
    RoleDao roleDao2 = mock(RoleDao.class);
    PersonDao personDao4 = mock(PersonDao.class);
    ChangeLogService changeLogService4 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService3 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    UserRoleService userRoleService2 =
        new UserRoleService(
            userRoleDao2,
            roleDao2,
            personDao4,
            changeLogService4,
            personService3,
            settingsService2);

    FlowPermissionChecker flowPermissionChecker =
        new FlowPermissionChecker(
            logicalFlowDao3,
            physicalSpecificationDao,
            involvementService,
            permissionGroupService,
            userRoleService2);

    // Act
    Set<Operation> actualFindPermissionsForSpecResult =
        flowPermissionChecker.findPermissionsForSpec(1L, "janedoe");

    // Assert
    verify(dao).findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(permissionGroupDao).findPermissionsForParentEntityReference(isA(EntityReference.class));
    verify(personDao3).getByUserEmail("janedoe");
    verify(physicalSpecificationDao).calculateAmendedSpecOperations(isA(Set.class), eq("janedoe"));
    verify(physicalSpecificationDao).getById(1L);
    assertTrue(actualFindPermissionsForSpecResult.isEmpty());
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForSpec(long, String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForSpec(long, String)}
   */
  @Test
  @DisplayName("Test findPermissionsForSpec(long, String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowPermissionChecker.findPermissionsForSpec(long, String)"})
  void testFindPermissionsForSpec_thenReturnEmpty() {
    // Arrange
    when(physicalSpecificationDao.calculateAmendedSpecOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(physicalSpecificationDao.getById(anyLong()))
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
                .provenance("Provenance")
                .build());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<Operation> actualFindPermissionsForSpecResult =
        flowPermissionChecker.findPermissionsForSpec(1L, "janedoe");

    // Assert
    verify(physicalSpecificationDao).calculateAmendedSpecOperations(isA(Set.class), eq("janedoe"));
    verify(physicalSpecificationDao).getById(1L);
    verify(involvementService)
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(permissionGroupService)
        .findPermissionsForParentReference(isA(EntityReference.class), eq("janedoe"));
    assertTrue(actualFindPermissionsForSpecResult.isEmpty());
  }

  /**
   * Test {@link FlowPermissionChecker#findFlowPermissionsForParentEntity(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * FlowPermissionChecker#findFlowPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findFlowPermissionsForParentEntity(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findFlowPermissionsForParentEntity(EntityReference, String)"
  })
  void testFindFlowPermissionsForParentEntity() {
    // Arrange
    when(logicalFlowDao.calculateAmendedFlowOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<Operation> actualFindFlowPermissionsForParentEntityResult =
        flowPermissionChecker.findFlowPermissionsForParentEntity(null, "janedoe");

    // Assert
    verify(logicalFlowDao).calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindFlowPermissionsForParentEntityResult.isEmpty());
  }

  /**
   * Test {@link FlowPermissionChecker#findFlowPermissionsForParentEntity(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * FlowPermissionChecker#findFlowPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findFlowPermissionsForParentEntity(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findFlowPermissionsForParentEntity(EntityReference, String)"
  })
  void testFindFlowPermissionsForParentEntity2() {
    // Arrange
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> flowPermissionChecker.findFlowPermissionsForParentEntity(null, "janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
  }

  /**
   * Test {@link FlowPermissionChecker#findFlowPermissionsForParentEntity(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * FlowPermissionChecker#findFlowPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findFlowPermissionsForParentEntity(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findFlowPermissionsForParentEntity(EntityReference, String)"
  })
  void testFindFlowPermissionsForParentEntity3() {
    // Arrange
    when(logicalFlowDao.calculateAmendedFlowOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    HashSet<Permission> permissionSet = new HashSet<>();

    ImmutablePermission.Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    ImmutablePermission.Builder qualifierReferenceResult =
        parentKindResult.qualifierReference(qualifierReference);
    permissionSet.add(
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(permissionSet);

    // Act
    Set<Operation> actualFindFlowPermissionsForParentEntityResult =
        flowPermissionChecker.findFlowPermissionsForParentEntity(null, "janedoe");

    // Assert
    verify(logicalFlowDao).calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindFlowPermissionsForParentEntityResult.isEmpty());
  }

  /**
   * Test {@link FlowPermissionChecker#findFlowPermissionsForParentEntity(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * FlowPermissionChecker#findFlowPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findFlowPermissionsForParentEntity(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findFlowPermissionsForParentEntity(EntityReference, String)"
  })
  void testFindFlowPermissionsForParentEntity4() {
    // Arrange
    when(logicalFlowDao.calculateAmendedFlowOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> flowPermissionChecker.findFlowPermissionsForParentEntity(null, "janedoe"));
    verify(logicalFlowDao).calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
  }

  /**
   * Test {@link FlowPermissionChecker#findFlowPermissionsForParentEntity(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * FlowPermissionChecker#findFlowPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findFlowPermissionsForParentEntity(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findFlowPermissionsForParentEntity(EntityReference, String)"
  })
  void testFindFlowPermissionsForParentEntity5() {
    // Arrange
    when(logicalFlowDao.calculateAmendedFlowOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    HashSet<Permission> permissionSet = new HashSet<>();

    ImmutablePermission.Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    ImmutablePermission.Builder qualifierReferenceResult =
        parentKindResult.qualifierReference(qualifierReference);
    permissionSet.add(
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build());

    ImmutablePermission.Builder parentKindResult2 =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
    Optional<? extends EntityReference> qualifierReference2 = Optional.empty();

    ImmutablePermission.Builder qualifierReferenceResult2 =
        parentKindResult2.qualifierReference(qualifierReference2);
    permissionSet.add(
        qualifierReferenceResult2
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(permissionSet);

    // Act
    Set<Operation> actualFindFlowPermissionsForParentEntityResult =
        flowPermissionChecker.findFlowPermissionsForParentEntity(null, "janedoe");

    // Assert
    verify(logicalFlowDao).calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindFlowPermissionsForParentEntityResult.isEmpty());
  }

  /**
   * Test {@link FlowPermissionChecker#findFlowPermissionsForParentEntity(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * FlowPermissionChecker#findFlowPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findFlowPermissionsForParentEntity(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findFlowPermissionsForParentEntity(EntityReference, String)"
  })
  void testFindFlowPermissionsForParentEntity6() {
    // Arrange
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            flowPermissionChecker.findFlowPermissionsForParentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                "janedoe"));
    verify(involvementService)
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(permissionGroupService)
        .findPermissionsForParentReference(isA(EntityReference.class), eq("janedoe"));
  }

  /**
   * Test {@link FlowPermissionChecker#findFlowPermissionsForParentEntity(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * FlowPermissionChecker#findFlowPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findFlowPermissionsForParentEntity(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findFlowPermissionsForParentEntity(EntityReference, String)"
  })
  void testFindFlowPermissionsForParentEntity7() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.calculateAmendedFlowOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao2,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    PersonDao personDao3 = mock(PersonDao.class);
    when(personDao3.getByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    PersonService personService2 = new PersonService(personDao3, mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    when(permissionGroupDao.findPermissionsForParentEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao2 = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao3 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao2 = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService2 =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService2 =
        new InvolvementService(
            changeLogService3,
            dao2,
            logicalFlowDao3,
            physicalFlowDao2,
            entityReferenceNameResolver2,
            involvementKindService2,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService2, permissionGroupDao, involvementService2);
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    UserRoleDao userRoleDao2 = mock(UserRoleDao.class);
    RoleDao roleDao2 = mock(RoleDao.class);
    PersonDao personDao4 = mock(PersonDao.class);
    ChangeLogService changeLogService4 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService3 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    UserRoleService userRoleService2 =
        new UserRoleService(
            userRoleDao2,
            roleDao2,
            personDao4,
            changeLogService4,
            personService3,
            settingsService2);

    FlowPermissionChecker flowPermissionChecker =
        new FlowPermissionChecker(
            logicalFlowDao,
            physicalSpecificationDao,
            involvementService,
            permissionGroupService,
            userRoleService2);

    // Act
    Set<Operation> actualFindFlowPermissionsForParentEntityResult =
        flowPermissionChecker.findFlowPermissionsForParentEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(dao).findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(logicalFlowDao).calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(permissionGroupDao).findPermissionsForParentEntityReference(isA(EntityReference.class));
    verify(personDao3).getByUserEmail("janedoe");
    assertTrue(actualFindFlowPermissionsForParentEntityResult.isEmpty());
  }

  /**
   * Test {@link FlowPermissionChecker#findFlowPermissionsForParentEntity(EntityReference, String)}.
   *
   * <ul>
   *   <li>Then calls {@link PersonService#getPersonByUserId(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowPermissionChecker#findFlowPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test findFlowPermissionsForParentEntity(EntityReference, String); then calls getPersonByUserId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findFlowPermissionsForParentEntity(EntityReference, String)"
  })
  void testFindFlowPermissionsForParentEntity_thenCallsGetPersonByUserId() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.calculateAmendedFlowOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    PersonService personService = mock(PersonService.class);
    when(personService.getPersonByUserId(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    when(permissionGroupDao.findPermissionsForParentEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService2 =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao2,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService2);
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService2, personService2, settingsService);

    FlowPermissionChecker flowPermissionChecker =
        new FlowPermissionChecker(
            logicalFlowDao,
            physicalSpecificationDao,
            involvementService,
            permissionGroupService,
            userRoleService);

    // Act
    Set<Operation> actualFindFlowPermissionsForParentEntityResult =
        flowPermissionChecker.findFlowPermissionsForParentEntity(null, null);

    // Assert
    verify(logicalFlowDao).calculateAmendedFlowOperations(isA(Set.class), isNull());
    verify(permissionGroupDao).findPermissionsForParentEntityReference(isNull());
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), isNull());
    verify(personService).getPersonByUserId(null);
    assertTrue(actualFindFlowPermissionsForParentEntityResult.isEmpty());
  }

  /**
   * Test {@link FlowPermissionChecker#findSpecPermissionsForParentEntity(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * FlowPermissionChecker#findSpecPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findSpecPermissionsForParentEntity(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findSpecPermissionsForParentEntity(EntityReference, String)"
  })
  void testFindSpecPermissionsForParentEntity() {
    // Arrange
    when(physicalSpecificationDao.calculateAmendedSpecOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<Operation> actualFindSpecPermissionsForParentEntityResult =
        flowPermissionChecker.findSpecPermissionsForParentEntity(null, "janedoe");

    // Assert
    verify(physicalSpecificationDao).calculateAmendedSpecOperations(isA(Set.class), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindSpecPermissionsForParentEntityResult.isEmpty());
  }

  /**
   * Test {@link FlowPermissionChecker#findSpecPermissionsForParentEntity(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * FlowPermissionChecker#findSpecPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findSpecPermissionsForParentEntity(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findSpecPermissionsForParentEntity(EntityReference, String)"
  })
  void testFindSpecPermissionsForParentEntity2() {
    // Arrange
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> flowPermissionChecker.findSpecPermissionsForParentEntity(null, "janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
  }

  /**
   * Test {@link FlowPermissionChecker#findSpecPermissionsForParentEntity(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * FlowPermissionChecker#findSpecPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findSpecPermissionsForParentEntity(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findSpecPermissionsForParentEntity(EntityReference, String)"
  })
  void testFindSpecPermissionsForParentEntity3() {
    // Arrange
    when(physicalSpecificationDao.calculateAmendedSpecOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    HashSet<Permission> permissionSet = new HashSet<>();

    ImmutablePermission.Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    ImmutablePermission.Builder qualifierReferenceResult =
        parentKindResult.qualifierReference(qualifierReference);
    permissionSet.add(
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(permissionSet);

    // Act
    Set<Operation> actualFindSpecPermissionsForParentEntityResult =
        flowPermissionChecker.findSpecPermissionsForParentEntity(null, "janedoe");

    // Assert
    verify(physicalSpecificationDao).calculateAmendedSpecOperations(isA(Set.class), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindSpecPermissionsForParentEntityResult.isEmpty());
  }

  /**
   * Test {@link FlowPermissionChecker#findSpecPermissionsForParentEntity(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * FlowPermissionChecker#findSpecPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findSpecPermissionsForParentEntity(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findSpecPermissionsForParentEntity(EntityReference, String)"
  })
  void testFindSpecPermissionsForParentEntity4() {
    // Arrange
    when(physicalSpecificationDao.calculateAmendedSpecOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> flowPermissionChecker.findSpecPermissionsForParentEntity(null, "janedoe"));
    verify(physicalSpecificationDao).calculateAmendedSpecOperations(isA(Set.class), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
  }

  /**
   * Test {@link FlowPermissionChecker#findSpecPermissionsForParentEntity(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * FlowPermissionChecker#findSpecPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findSpecPermissionsForParentEntity(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findSpecPermissionsForParentEntity(EntityReference, String)"
  })
  void testFindSpecPermissionsForParentEntity5() {
    // Arrange
    when(physicalSpecificationDao.calculateAmendedSpecOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    HashSet<Permission> permissionSet = new HashSet<>();

    ImmutablePermission.Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    ImmutablePermission.Builder qualifierReferenceResult =
        parentKindResult.qualifierReference(qualifierReference);
    permissionSet.add(
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build());

    ImmutablePermission.Builder parentKindResult2 =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
    Optional<? extends EntityReference> qualifierReference2 = Optional.empty();

    ImmutablePermission.Builder qualifierReferenceResult2 =
        parentKindResult2.qualifierReference(qualifierReference2);
    permissionSet.add(
        qualifierReferenceResult2
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(permissionSet);

    // Act
    Set<Operation> actualFindSpecPermissionsForParentEntityResult =
        flowPermissionChecker.findSpecPermissionsForParentEntity(null, "janedoe");

    // Assert
    verify(physicalSpecificationDao).calculateAmendedSpecOperations(isA(Set.class), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindSpecPermissionsForParentEntityResult.isEmpty());
  }

  /**
   * Test {@link FlowPermissionChecker#findSpecPermissionsForParentEntity(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * FlowPermissionChecker#findSpecPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findSpecPermissionsForParentEntity(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findSpecPermissionsForParentEntity(EntityReference, String)"
  })
  void testFindSpecPermissionsForParentEntity6() {
    // Arrange
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            flowPermissionChecker.findSpecPermissionsForParentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                "janedoe"));
    verify(involvementService)
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(permissionGroupService)
        .findPermissionsForParentReference(isA(EntityReference.class), eq("janedoe"));
  }

  /**
   * Test {@link FlowPermissionChecker#findSpecPermissionsForParentEntity(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * FlowPermissionChecker#findSpecPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findSpecPermissionsForParentEntity(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findSpecPermissionsForParentEntity(EntityReference, String)"
  })
  void testFindSpecPermissionsForParentEntity7() {
    // Arrange
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    when(physicalSpecificationDao.calculateAmendedSpecOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    PersonDao personDao3 = mock(PersonDao.class);
    when(personDao3.getByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    PersonService personService2 = new PersonService(personDao3, mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    when(permissionGroupDao.findPermissionsForParentEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao2 = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao2 = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService2 =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService2 =
        new InvolvementService(
            changeLogService3,
            dao2,
            logicalFlowDao2,
            physicalFlowDao2,
            entityReferenceNameResolver2,
            involvementKindService2,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService2, permissionGroupDao, involvementService2);
    LogicalFlowDao logicalFlowDao3 = mock(LogicalFlowDao.class);
    UserRoleDao userRoleDao2 = mock(UserRoleDao.class);
    RoleDao roleDao2 = mock(RoleDao.class);
    PersonDao personDao4 = mock(PersonDao.class);
    ChangeLogService changeLogService4 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService3 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    UserRoleService userRoleService2 =
        new UserRoleService(
            userRoleDao2,
            roleDao2,
            personDao4,
            changeLogService4,
            personService3,
            settingsService2);

    FlowPermissionChecker flowPermissionChecker =
        new FlowPermissionChecker(
            logicalFlowDao3,
            physicalSpecificationDao,
            involvementService,
            permissionGroupService,
            userRoleService2);

    // Act
    Set<Operation> actualFindSpecPermissionsForParentEntityResult =
        flowPermissionChecker.findSpecPermissionsForParentEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(dao).findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(permissionGroupDao).findPermissionsForParentEntityReference(isA(EntityReference.class));
    verify(personDao3).getByUserEmail("janedoe");
    verify(physicalSpecificationDao).calculateAmendedSpecOperations(isA(Set.class), eq("janedoe"));
    assertTrue(actualFindSpecPermissionsForParentEntityResult.isEmpty());
  }

  /**
   * Test {@link FlowPermissionChecker#findSpecPermissionsForParentEntity(EntityReference, String)}.
   *
   * <ul>
   *   <li>Then calls {@link PersonService#getPersonByUserId(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowPermissionChecker#findSpecPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test findSpecPermissionsForParentEntity(EntityReference, String); then calls getPersonByUserId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findSpecPermissionsForParentEntity(EntityReference, String)"
  })
  void testFindSpecPermissionsForParentEntity_thenCallsGetPersonByUserId() {
    // Arrange
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    when(physicalSpecificationDao.calculateAmendedSpecOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    PersonService personService = mock(PersonService.class);
    when(personService.getPersonByUserId(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    when(permissionGroupDao.findPermissionsForParentEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService2 =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService2);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService2, personService2, settingsService);

    FlowPermissionChecker flowPermissionChecker =
        new FlowPermissionChecker(
            logicalFlowDao2,
            physicalSpecificationDao,
            involvementService,
            permissionGroupService,
            userRoleService);

    // Act
    Set<Operation> actualFindSpecPermissionsForParentEntityResult =
        flowPermissionChecker.findSpecPermissionsForParentEntity(null, null);

    // Assert
    verify(permissionGroupDao).findPermissionsForParentEntityReference(isNull());
    verify(physicalSpecificationDao).calculateAmendedSpecOperations(isA(Set.class), isNull());
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), isNull());
    verify(personService).getPersonByUserId(null);
    assertTrue(actualFindSpecPermissionsForParentEntityResult.isEmpty());
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForFlow(Long, String)}.
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForFlow(Long, String)}
   */
  @Test
  @DisplayName("Test findPermissionsForFlow(Long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowPermissionChecker.findPermissionsForFlow(Long, String)"})
  void testFindPermissionsForFlow() {
    // Arrange
    when(logicalFlowDao.getByFlowId(anyLong())).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> flowPermissionChecker.findPermissionsForFlow(1L, "janedoe"));
    verify(logicalFlowDao).getByFlowId(1L);
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForFlow(Long, String)}.
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForFlow(Long, String)}
   */
  @Test
  @DisplayName("Test findPermissionsForFlow(Long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowPermissionChecker.findPermissionsForFlow(Long, String)"})
  void testFindPermissionsForFlow2() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> flowPermissionChecker.findPermissionsForFlow(1L, "janedoe"));
    verify(logicalFlowDao).getByFlowId(1L);
    verify(involvementService)
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForFlow(Long, String)}.
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForFlow(Long, String)}
   */
  @Test
  @DisplayName("Test findPermissionsForFlow(Long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowPermissionChecker.findPermissionsForFlow(Long, String)"})
  void testFindPermissionsForFlow3() {
    // Arrange
    when(logicalFlowDao.calculateAmendedFlowOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    HashSet<Permission> permissionSet = new HashSet<>();

    ImmutablePermission.Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    ImmutablePermission.Builder qualifierReferenceResult =
        parentKindResult.qualifierReference(qualifierReference);
    permissionSet.add(
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(permissionSet);

    // Act
    Set<Operation> actualFindPermissionsForFlowResult =
        flowPermissionChecker.findPermissionsForFlow(1L, "janedoe");

    // Assert
    verify(logicalFlowDao, atLeast(1))
        .calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(logicalFlowDao).getByFlowId(1L);
    verify(involvementService, atLeast(1))
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(permissionGroupService, atLeast(1))
        .findPermissionsForParentReference(isA(EntityReference.class), eq("janedoe"));
    assertTrue(actualFindPermissionsForFlowResult.isEmpty());
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForFlow(Long, String)}.
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForFlow(Long, String)}
   */
  @Test
  @DisplayName("Test findPermissionsForFlow(Long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowPermissionChecker.findPermissionsForFlow(Long, String)"})
  void testFindPermissionsForFlow4() {
    // Arrange
    when(logicalFlowDao.calculateAmendedFlowOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> flowPermissionChecker.findPermissionsForFlow(1L, "janedoe"));
    verify(logicalFlowDao).calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(logicalFlowDao).getByFlowId(1L);
    verify(involvementService)
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(permissionGroupService)
        .findPermissionsForParentReference(isA(EntityReference.class), eq("janedoe"));
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForFlow(Long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementDao#findExistingInvolvementKindIdsForUser(EntityReference,
   *       String)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForFlow(Long, String)}
   */
  @Test
  @DisplayName(
      "Test findPermissionsForFlow(Long, String); then calls findExistingInvolvementKindIdsForUser(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowPermissionChecker.findPermissionsForFlow(Long, String)"})
  void testFindPermissionsForFlow_thenCallsFindExistingInvolvementKindIdsForUser() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.calculateAmendedFlowOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao2,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    PersonDao personDao3 = mock(PersonDao.class);
    when(personDao3.getByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    PersonService personService2 = new PersonService(personDao3, mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    when(permissionGroupDao.findPermissionsForParentEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao2 = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao3 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao2 = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService2 =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService2 =
        new InvolvementService(
            changeLogService3,
            dao2,
            logicalFlowDao3,
            physicalFlowDao2,
            entityReferenceNameResolver2,
            involvementKindService2,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService2, permissionGroupDao, involvementService2);
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    UserRoleDao userRoleDao2 = mock(UserRoleDao.class);
    RoleDao roleDao2 = mock(RoleDao.class);
    PersonDao personDao4 = mock(PersonDao.class);
    ChangeLogService changeLogService4 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService3 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    UserRoleService userRoleService2 =
        new UserRoleService(
            userRoleDao2,
            roleDao2,
            personDao4,
            changeLogService4,
            personService3,
            settingsService2);

    FlowPermissionChecker flowPermissionChecker =
        new FlowPermissionChecker(
            logicalFlowDao,
            physicalSpecificationDao,
            involvementService,
            permissionGroupService,
            userRoleService2);

    // Act
    Set<Operation> actualFindPermissionsForFlowResult =
        flowPermissionChecker.findPermissionsForFlow(1L, "janedoe");

    // Assert
    verify(dao, atLeast(1))
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(logicalFlowDao, atLeast(1))
        .calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(logicalFlowDao).getByFlowId(1L);
    verify(permissionGroupDao, atLeast(1))
        .findPermissionsForParentEntityReference(isA(EntityReference.class));
    verify(personDao3, atLeast(1)).getByUserEmail("janedoe");
    assertTrue(actualFindPermissionsForFlowResult.isEmpty());
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForFlow(Long, String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FlowPermissionChecker#findPermissionsForFlow(Long, String)}
   */
  @Test
  @DisplayName("Test findPermissionsForFlow(Long, String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowPermissionChecker.findPermissionsForFlow(Long, String)"})
  void testFindPermissionsForFlow_thenReturnEmpty() {
    // Arrange
    when(logicalFlowDao.calculateAmendedFlowOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<Operation> actualFindPermissionsForFlowResult =
        flowPermissionChecker.findPermissionsForFlow(1L, "janedoe");

    // Assert
    verify(logicalFlowDao, atLeast(1))
        .calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(logicalFlowDao).getByFlowId(1L);
    verify(involvementService, atLeast(1))
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(permissionGroupService, atLeast(1))
        .findPermissionsForParentReference(isA(EntityReference.class), eq("janedoe"));
    assertTrue(actualFindPermissionsForFlowResult.isEmpty());
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForSourceAndTarget(EntityReference,
   * EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * FlowPermissionChecker#findPermissionsForSourceAndTarget(EntityReference, EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findPermissionsForSourceAndTarget(EntityReference, EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findPermissionsForSourceAndTarget(EntityReference, EntityReference, String)"
  })
  void testFindPermissionsForSourceAndTarget() {
    // Arrange
    when(logicalFlowDao.calculateAmendedFlowOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<Operation> actualFindPermissionsForSourceAndTargetResult =
        flowPermissionChecker.findPermissionsForSourceAndTarget(null, null, "janedoe");

    // Assert
    verify(logicalFlowDao, atLeast(1))
        .calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(involvementService, atLeast(1))
        .findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService, atLeast(1))
        .findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindPermissionsForSourceAndTargetResult.isEmpty());
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForSourceAndTarget(EntityReference,
   * EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * FlowPermissionChecker#findPermissionsForSourceAndTarget(EntityReference, EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findPermissionsForSourceAndTarget(EntityReference, EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findPermissionsForSourceAndTarget(EntityReference, EntityReference, String)"
  })
  void testFindPermissionsForSourceAndTarget2() {
    // Arrange
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> flowPermissionChecker.findPermissionsForSourceAndTarget(null, null, "janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForSourceAndTarget(EntityReference,
   * EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * FlowPermissionChecker#findPermissionsForSourceAndTarget(EntityReference, EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findPermissionsForSourceAndTarget(EntityReference, EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findPermissionsForSourceAndTarget(EntityReference, EntityReference, String)"
  })
  void testFindPermissionsForSourceAndTarget3() {
    // Arrange
    when(logicalFlowDao.calculateAmendedFlowOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    HashSet<Permission> permissionSet = new HashSet<>();

    ImmutablePermission.Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    ImmutablePermission.Builder qualifierReferenceResult =
        parentKindResult.qualifierReference(qualifierReference);
    permissionSet.add(
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(permissionSet);

    // Act
    Set<Operation> actualFindPermissionsForSourceAndTargetResult =
        flowPermissionChecker.findPermissionsForSourceAndTarget(null, null, "janedoe");

    // Assert
    verify(logicalFlowDao, atLeast(1))
        .calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(involvementService, atLeast(1))
        .findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService, atLeast(1))
        .findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindPermissionsForSourceAndTargetResult.isEmpty());
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForSourceAndTarget(EntityReference,
   * EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * FlowPermissionChecker#findPermissionsForSourceAndTarget(EntityReference, EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findPermissionsForSourceAndTarget(EntityReference, EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findPermissionsForSourceAndTarget(EntityReference, EntityReference, String)"
  })
  void testFindPermissionsForSourceAndTarget4() {
    // Arrange
    when(logicalFlowDao.calculateAmendedFlowOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> flowPermissionChecker.findPermissionsForSourceAndTarget(null, null, "janedoe"));
    verify(logicalFlowDao).calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForSourceAndTarget(EntityReference,
   * EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * FlowPermissionChecker#findPermissionsForSourceAndTarget(EntityReference, EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findPermissionsForSourceAndTarget(EntityReference, EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findPermissionsForSourceAndTarget(EntityReference, EntityReference, String)"
  })
  void testFindPermissionsForSourceAndTarget5() {
    // Arrange
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    ImmutableEntityReference source =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            flowPermissionChecker.findPermissionsForSourceAndTarget(
                source,
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                "janedoe"));
    verify(involvementService)
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(permissionGroupService)
        .findPermissionsForParentReference(isA(EntityReference.class), eq("janedoe"));
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForSourceAndTarget(EntityReference,
   * EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * FlowPermissionChecker#findPermissionsForSourceAndTarget(EntityReference, EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findPermissionsForSourceAndTarget(EntityReference, EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findPermissionsForSourceAndTarget(EntityReference, EntityReference, String)"
  })
  void testFindPermissionsForSourceAndTarget6() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.calculateAmendedFlowOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao2,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    PersonDao personDao3 = mock(PersonDao.class);
    when(personDao3.getByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    PersonService personService2 = new PersonService(personDao3, mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    when(permissionGroupDao.findPermissionsForParentEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao2 = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao3 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao2 = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService2 =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService2 =
        new InvolvementService(
            changeLogService3,
            dao2,
            logicalFlowDao3,
            physicalFlowDao2,
            entityReferenceNameResolver2,
            involvementKindService2,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService2, permissionGroupDao, involvementService2);
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    UserRoleDao userRoleDao2 = mock(UserRoleDao.class);
    RoleDao roleDao2 = mock(RoleDao.class);
    PersonDao personDao4 = mock(PersonDao.class);
    ChangeLogService changeLogService4 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService3 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    UserRoleService userRoleService2 =
        new UserRoleService(
            userRoleDao2,
            roleDao2,
            personDao4,
            changeLogService4,
            personService3,
            settingsService2);

    FlowPermissionChecker flowPermissionChecker =
        new FlowPermissionChecker(
            logicalFlowDao,
            physicalSpecificationDao,
            involvementService,
            permissionGroupService,
            userRoleService2);
    ImmutableEntityReference source =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Set<Operation> actualFindPermissionsForSourceAndTargetResult =
        flowPermissionChecker.findPermissionsForSourceAndTarget(
            source,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(dao, atLeast(1))
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(logicalFlowDao, atLeast(1))
        .calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(permissionGroupDao, atLeast(1))
        .findPermissionsForParentEntityReference(isA(EntityReference.class));
    verify(personDao3, atLeast(1)).getByUserEmail("janedoe");
    assertTrue(actualFindPermissionsForSourceAndTargetResult.isEmpty());
  }

  /**
   * Test {@link FlowPermissionChecker#findPermissionsForSourceAndTarget(EntityReference,
   * EntityReference, String)}.
   *
   * <ul>
   *   <li>Then calls {@link PersonService#getPersonByUserId(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowPermissionChecker#findPermissionsForSourceAndTarget(EntityReference, EntityReference,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findPermissionsForSourceAndTarget(EntityReference, EntityReference, String); then calls getPersonByUserId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set FlowPermissionChecker.findPermissionsForSourceAndTarget(EntityReference, EntityReference, String)"
  })
  void testFindPermissionsForSourceAndTarget_thenCallsGetPersonByUserId() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.calculateAmendedFlowOperations(
            Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    PersonService personService = mock(PersonService.class);
    when(personService.getPersonByUserId(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    when(permissionGroupDao.findPermissionsForParentEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService2 =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao2,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService2);
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService2, personService2, settingsService);

    FlowPermissionChecker flowPermissionChecker =
        new FlowPermissionChecker(
            logicalFlowDao,
            physicalSpecificationDao,
            involvementService,
            permissionGroupService,
            userRoleService);

    // Act
    Set<Operation> actualFindPermissionsForSourceAndTargetResult =
        flowPermissionChecker.findPermissionsForSourceAndTarget(
            null, mock(EntityReference.class), "janedoe");

    // Assert
    verify(logicalFlowDao, atLeast(1))
        .calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(permissionGroupDao, atLeast(1))
        .findPermissionsForParentEntityReference(Mockito.<EntityReference>any());
    verify(involvementService, atLeast(1))
        .findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), eq("janedoe"));
    verify(personService, atLeast(1)).getPersonByUserId("janedoe");
    assertTrue(actualFindPermissionsForSourceAndTargetResult.isEmpty());
  }
}
