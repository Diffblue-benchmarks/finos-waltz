package org.finos.waltz.service.permission.permission_checker;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.measurable.ImmutableMeasurable;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRating;
import org.finos.waltz.model.permission_group.ImmutablePermission;
import org.finos.waltz.model.permission_group.ImmutablePermission.Builder;
import org.finos.waltz.model.permission_group.ImmutableRequiredInvolvementsResult;
import org.finos.waltz.model.permission_group.Permission;
import org.finos.waltz.service.involvement.InvolvementService;
import org.finos.waltz.service.measurable.MeasurableService;
import org.finos.waltz.service.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionService;
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
class MeasurableRatingPermissionCheckerDiffblueTest {
  @Mock private InvolvementService involvementService;

  @Mock private MeasurableRatingDao measurableRatingDao;

  @InjectMocks private MeasurableRatingPermissionChecker measurableRatingPermissionChecker;

  @Mock private MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao;

  @Mock
  private MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService;

  @Mock private MeasurableRatingReplacementDao measurableRatingReplacementDao;

  @Mock private MeasurableService measurableService;

  @Mock private PermissionGroupService permissionGroupService;

  /**
   * Test {@link MeasurableRatingPermissionChecker#findMeasurableRatingDecommPermissions(long,
   * String)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPermissionChecker#findMeasurableRatingDecommPermissions(long, String)}
   */
  @Test
  @DisplayName("Test findMeasurableRatingDecommPermissions(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingPermissionChecker.findMeasurableRatingDecommPermissions(long, String)"
  })
  void testFindMeasurableRatingDecommPermissions() {
    // Arrange
    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingDao.getById(anyLong()))
        .thenReturn(
            descriptionResult
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
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    when(measurableService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());
    when(measurableRatingPlannedDecommissionDao.calculateAmendedDecommOperations(
            Mockito.<Set<Operation>>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<Operation> actualFindMeasurableRatingDecommPermissionsResult =
        measurableRatingPermissionChecker.findMeasurableRatingDecommPermissions(1L, "janedoe");

    // Assert
    verify(measurableRatingDao).getById(1L);
    verify(measurableRatingPlannedDecommissionDao)
        .calculateAmendedDecommOperations(isA(Set.class), eq(1L), eq("janedoe"));
    verify(involvementService)
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(measurableService).getById(1L);
    verify(permissionGroupService)
        .findPermissionsForParentReference(isA(EntityReference.class), eq("janedoe"));
    assertTrue(actualFindMeasurableRatingDecommPermissionsResult.isEmpty());
  }

  /**
   * Test {@link MeasurableRatingPermissionChecker#findMeasurableRatingDecommPermissions(long,
   * String)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPermissionChecker#findMeasurableRatingDecommPermissions(long, String)}
   */
  @Test
  @DisplayName("Test findMeasurableRatingDecommPermissions(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingPermissionChecker.findMeasurableRatingDecommPermissions(long, String)"
  })
  void testFindMeasurableRatingDecommPermissions2() {
    // Arrange
    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingDao.getById(anyLong()))
        .thenReturn(
            descriptionResult
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
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    when(measurableService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());
    when(measurableRatingPlannedDecommissionDao.calculateAmendedDecommOperations(
            Mockito.<Set<Operation>>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    HashSet<Permission> permissionSet = new HashSet<>();

    Builder parentKindResult =
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);
    permissionSet.add(
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(permissionSet);
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<Operation> actualFindMeasurableRatingDecommPermissionsResult =
        measurableRatingPermissionChecker.findMeasurableRatingDecommPermissions(1L, "janedoe");

    // Assert
    verify(measurableRatingDao).getById(1L);
    verify(measurableRatingPlannedDecommissionDao)
        .calculateAmendedDecommOperations(isA(Set.class), eq(1L), eq("janedoe"));
    verify(involvementService)
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(measurableService).getById(1L);
    verify(permissionGroupService)
        .findPermissionsForParentReference(isA(EntityReference.class), eq("janedoe"));
    assertTrue(actualFindMeasurableRatingDecommPermissionsResult.isEmpty());
  }

  /**
   * Test {@link MeasurableRatingPermissionChecker#findMeasurableRatingPermissions(EntityReference,
   * long, String)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPermissionChecker#findMeasurableRatingPermissions(EntityReference, long,
   * String)}
   */
  @Test
  @DisplayName("Test findMeasurableRatingPermissions(EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingPermissionChecker.findMeasurableRatingPermissions(EntityReference, long, String)"
  })
  void testFindMeasurableRatingPermissions() {
    // Arrange
    when(measurableRatingDao.calculateAmendedRatingOperations(
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityReference>any(),
            anyLong(),
            Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    HashSet<Permission> permissionSet = new HashSet<>();

    Builder parentKindResult =
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);
    permissionSet.add(
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(permissionSet);
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<Operation> actualFindMeasurableRatingPermissionsResult =
        measurableRatingPermissionChecker.findMeasurableRatingPermissions(null, 1L, "janedoe");

    // Assert
    verify(measurableRatingDao)
        .calculateAmendedRatingOperations(isA(Set.class), isNull(), eq(1L), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(measurableService).getById(1L);
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindMeasurableRatingPermissionsResult.isEmpty());
  }

  /**
   * Test {@link MeasurableRatingPermissionChecker#findMeasurableRatingPermissions(EntityReference,
   * long, String)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPermissionChecker#findMeasurableRatingPermissions(EntityReference, long,
   * String)}
   */
  @Test
  @DisplayName("Test findMeasurableRatingPermissions(EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingPermissionChecker.findMeasurableRatingPermissions(EntityReference, long, String)"
  })
  void testFindMeasurableRatingPermissions2() {
    // Arrange
    when(measurableRatingDao.calculateAmendedRatingOperations(
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityReference>any(),
            anyLong(),
            Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    HashSet<Permission> permissionSet = new HashSet<>();

    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ATTEST).parentKind(EntityKind.ALL);
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);
    permissionSet.add(
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build());

    Builder parentKindResult2 =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference2 =
        Optional.of(immutableEntityReference2);

    Builder qualifierReferenceResult2 = parentKindResult2.qualifierReference(qualifierReference2);
    permissionSet.add(
        qualifierReferenceResult2
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(permissionSet);
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<Operation> actualFindMeasurableRatingPermissionsResult =
        measurableRatingPermissionChecker.findMeasurableRatingPermissions(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L,
            "");

    // Assert
    verify(measurableRatingDao)
        .calculateAmendedRatingOperations(
            isA(Set.class), isA(EntityReference.class), eq(1L), eq(""));
    verify(involvementService)
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq(""));
    verify(measurableService).getById(1L);
    verify(permissionGroupService)
        .findPermissionsForParentReference(isA(EntityReference.class), eq(""));
    assertTrue(actualFindMeasurableRatingPermissionsResult.isEmpty());
  }

  /**
   * Test {@link MeasurableRatingPermissionChecker#findMeasurableRatingPermissions(EntityReference,
   * long, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingPermissionChecker#findMeasurableRatingPermissions(EntityReference, long,
   * String)}
   */
  @Test
  @DisplayName("Test findMeasurableRatingPermissions(EntityReference, long, String); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingPermissionChecker.findMeasurableRatingPermissions(EntityReference, long, String)"
  })
  void testFindMeasurableRatingPermissions_whenNull() {
    // Arrange
    when(measurableRatingDao.calculateAmendedRatingOperations(
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityReference>any(),
            anyLong(),
            Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<Operation> actualFindMeasurableRatingPermissionsResult =
        measurableRatingPermissionChecker.findMeasurableRatingPermissions(null, 1L, "janedoe");

    // Assert
    verify(measurableRatingDao)
        .calculateAmendedRatingOperations(isA(Set.class), isNull(), eq(1L), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(measurableService).getById(1L);
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindMeasurableRatingPermissionsResult.isEmpty());
  }

  /**
   * Test {@link MeasurableRatingPermissionChecker#findMeasurableRatingReplacementPermissions(long,
   * String)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPermissionChecker#findMeasurableRatingReplacementPermissions(long, String)}
   */
  @Test
  @DisplayName("Test findMeasurableRatingReplacementPermissions(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingPermissionChecker.findMeasurableRatingReplacementPermissions(long, String)"
  })
  void testFindMeasurableRatingReplacementPermissions() {
    // Arrange
    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingDao.getByDecommId(anyLong()))
        .thenReturn(
            descriptionResult
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
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    when(measurableService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());
    when(measurableRatingReplacementDao.calculateAmendedReplacementOperations(
            Mockito.<Set<Operation>>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<Operation> actualFindMeasurableRatingReplacementPermissionsResult =
        measurableRatingPermissionChecker.findMeasurableRatingReplacementPermissions(1L, "janedoe");

    // Assert
    verify(measurableRatingDao).getByDecommId(1L);
    verify(measurableRatingReplacementDao)
        .calculateAmendedReplacementOperations(isA(Set.class), eq(1L), eq("janedoe"));
    verify(involvementService)
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(measurableService).getById(1L);
    verify(permissionGroupService)
        .findPermissionsForParentReference(isA(EntityReference.class), eq("janedoe"));
    assertTrue(actualFindMeasurableRatingReplacementPermissionsResult.isEmpty());
  }

  /**
   * Test {@link MeasurableRatingPermissionChecker#findMeasurableRatingReplacementPermissions(long,
   * String)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPermissionChecker#findMeasurableRatingReplacementPermissions(long, String)}
   */
  @Test
  @DisplayName("Test findMeasurableRatingReplacementPermissions(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingPermissionChecker.findMeasurableRatingReplacementPermissions(long, String)"
  })
  void testFindMeasurableRatingReplacementPermissions2() {
    // Arrange
    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingDao.getByDecommId(anyLong()))
        .thenReturn(
            descriptionResult
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
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    when(measurableService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());
    when(measurableRatingReplacementDao.calculateAmendedReplacementOperations(
            Mockito.<Set<Operation>>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    HashSet<Permission> permissionSet = new HashSet<>();

    Builder parentKindResult =
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

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);
    permissionSet.add(
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(permissionSet);
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<Operation> actualFindMeasurableRatingReplacementPermissionsResult =
        measurableRatingPermissionChecker.findMeasurableRatingReplacementPermissions(1L, "janedoe");

    // Assert
    verify(measurableRatingDao).getByDecommId(1L);
    verify(measurableRatingReplacementDao)
        .calculateAmendedReplacementOperations(isA(Set.class), eq(1L), eq("janedoe"));
    verify(involvementService)
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(measurableService).getById(1L);
    verify(permissionGroupService)
        .findPermissionsForParentReference(isA(EntityReference.class), eq("janedoe"));
    assertTrue(actualFindMeasurableRatingReplacementPermissionsResult.isEmpty());
  }
}
