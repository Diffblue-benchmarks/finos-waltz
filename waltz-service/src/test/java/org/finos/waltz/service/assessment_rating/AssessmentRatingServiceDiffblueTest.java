package org.finos.waltz.service.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.common.exception.InsufficientPrivelegeException;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.assessment_definition.AssessmentDefinitionDao;
import org.finos.waltz.data.assessment_rating.AssessmentRatingDao;
import org.finos.waltz.data.assessment_rating.AssessmentRatingRippler;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.permission.PermissionGroupDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.person.search.PersonSearchDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.rating_scheme.RatingSchemeDAO;
import org.finos.waltz.data.role.RoleDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.AssessmentsView;
import org.finos.waltz.model.application.ImmutableAssessmentsView;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_definition.AssessmentRipplerJobConfiguration;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentRipplerJobConfiguration;
import org.finos.waltz.model.assessment_rating.AssessmentDefinitionRatingOperations;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.assessment_rating.AssessmentRatingSummaryCounts;
import org.finos.waltz.model.assessment_rating.BulkAssessmentRatingCommand;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentDefinitionRatingOperations;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRating;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRatingOperations;
import org.finos.waltz.model.assessment_rating.ImmutableBulkAssessmentRatingCommand;
import org.finos.waltz.model.assessment_rating.ImmutableRemoveAssessmentRatingCommand;
import org.finos.waltz.model.assessment_rating.ImmutableSaveAssessmentRatingCommand;
import org.finos.waltz.model.assessment_rating.RemoveAssessmentRatingCommand;
import org.finos.waltz.model.assessment_rating.SaveAssessmentRatingCommand;
import org.finos.waltz.model.assessment_rating.UpdateRatingCommand;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.involvement.EntityInvolvementChangeCommand;
import org.finos.waltz.model.involvement.ImmutableEntityInvolvementChangeCommand;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.involvement.InvolvementService;
import org.finos.waltz.service.permission.PermissionGroupService;
import org.finos.waltz.service.permission.permission_checker.AssessmentRatingPermissionChecker;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AssessmentRatingServiceDiffblueTest {
  @Mock private AssessmentDefinitionDao assessmentDefinitionDao;

  @Mock private AssessmentRatingDao assessmentRatingDao;

  @Mock private AssessmentRatingPermissionChecker assessmentRatingPermissionChecker;

  @Mock private AssessmentRatingRippler assessmentRatingRippler;

  @InjectMocks private AssessmentRatingService assessmentRatingService;

  @Mock private ChangeLogService changeLogService;

  @Mock private RatingSchemeDAO ratingSchemeDAO;

  /**
   * Test {@link AssessmentRatingService#findForEntity(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingService.findForEntity(EntityReference)"})
  void testFindForEntity_thenReturnEmpty() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    List<AssessmentRating> actualFindForEntityResult =
        assessmentRatingService.findForEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(assessmentRatingDao).findForEntity(isA(EntityReference.class));
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findForEntity(EntityReference)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingService.findForEntity(EntityReference)"})
  void testFindForEntity_thenThrowIllegalArgumentException() {
    // Arrange
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> assessmentRatingService.findForEntity(null));
    verify(assessmentRatingDao).findForEntity(isNull());
  }

  /**
   * Test {@link AssessmentRatingService#findByEntityKind(EntityKind, Optional)} with {@code
   * targetKind}, {@code qualifierReference}.
   *
   * <p>Method under test: {@link AssessmentRatingService#findByEntityKind(EntityKind, Optional)}
   */
  @Test
  @DisplayName(
      "Test findByEntityKind(EntityKind, Optional) with 'targetKind', 'qualifierReference'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingService.findByEntityKind(EntityKind, Optional)"})
  void testFindByEntityKindWithTargetKindQualifierReference() {
    // Arrange
    when(assessmentRatingDao.findByEntityKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenThrow(new IllegalArgumentException());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> assessmentRatingService.findByEntityKind(EntityKind.ALL, qualifierReference));
    verify(assessmentRatingDao).findByEntityKind(eq(EntityKind.ALL), isA(Optional.class));
  }

  /**
   * Test {@link AssessmentRatingService#findByEntityKind(EntityKind, Optional)} with {@code
   * targetKind}, {@code qualifierReference}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#findByEntityKind(EntityKind, Optional)}
   */
  @Test
  @DisplayName(
      "Test findByEntityKind(EntityKind, Optional) with 'targetKind', 'qualifierReference'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingService.findByEntityKind(EntityKind, Optional)"})
  void testFindByEntityKindWithTargetKindQualifierReference_thenReturnEmpty() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByEntityKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new ArrayList<>());
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    // Act
    List<AssessmentRating> actualFindByEntityKindResult =
        assessmentRatingService.findByEntityKind(EntityKind.ALL, qualifierReference);

    // Assert
    verify(assessmentRatingDao).findByEntityKind(eq(EntityKind.ALL), isA(Optional.class));
    assertTrue(actualFindByEntityKindResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findByEntityKind(EntityKind)} with {@code targetKind}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#findByEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test findByEntityKind(EntityKind) with 'targetKind'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingService.findByEntityKind(EntityKind)"})
  void testFindByEntityKindWithTargetKind_thenReturnEmpty() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByEntityKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new ArrayList<>());
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    List<AssessmentRating> actualFindByEntityKindResult =
        assessmentRatingService.findByEntityKind(EntityKind.ALL);

    // Assert
    verify(assessmentRatingDao).findByEntityKind(eq(EntityKind.ALL), isA(Optional.class));
    assertTrue(actualFindByEntityKindResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findByEntityKind(EntityKind)} with {@code targetKind}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#findByEntityKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test findByEntityKind(EntityKind) with 'targetKind'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingService.findByEntityKind(EntityKind)"})
  void testFindByEntityKindWithTargetKind_thenThrowIllegalArgumentException() {
    // Arrange
    when(assessmentRatingDao.findByEntityKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> assessmentRatingService.findByEntityKind(EntityKind.ALL));
    verify(assessmentRatingDao).findByEntityKind(eq(EntityKind.ALL), isA(Optional.class));
  }

  /**
   * Test {@link AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AssessmentRatingService.findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByTargetKindForRelatedSelector() {
    // Arrange
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    List<AssessmentRating> actualFindByTargetKindForRelatedSelectorResult =
        assessmentRatingService.findByTargetKindForRelatedSelector(
            EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    assertTrue(actualFindByTargetKindForRelatedSelectorResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AssessmentRatingService.findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByTargetKindForRelatedSelector2() {
    // Arrange
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters immutableSelectionFilters = builderResult.build();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(immutableSelectionFilters);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    List<AssessmentRating> actualFindByTargetKindForRelatedSelectorResult =
        assessmentRatingService.findByTargetKindForRelatedSelector(
            EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions, atLeast(1)).filters();
    assertTrue(actualFindByTargetKindForRelatedSelectorResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AssessmentRatingService.findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByTargetKindForRelatedSelector3() {
    // Arrange
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    List<AssessmentRating> actualFindByTargetKindForRelatedSelectorResult =
        assessmentRatingService.findByTargetKindForRelatedSelector(
            EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    assertTrue(actualFindByTargetKindForRelatedSelectorResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AssessmentRatingService.findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByTargetKindForRelatedSelector4() {
    // Arrange
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    List<AssessmentRating> actualFindByTargetKindForRelatedSelectorResult =
        assessmentRatingService.findByTargetKindForRelatedSelector(
            EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindByTargetKindForRelatedSelectorResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AssessmentRatingService.findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByTargetKindForRelatedSelector5() {
    // Arrange
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APPLICATION)
                .name("Name")
                .build());

    // Act
    List<AssessmentRating> actualFindByTargetKindForRelatedSelectorResult =
        assessmentRatingService.findByTargetKindForRelatedSelector(
            EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindByTargetKindForRelatedSelectorResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AssessmentRatingService.findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByTargetKindForRelatedSelector6() {
    // Arrange
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    List<AssessmentRating> actualFindByTargetKindForRelatedSelectorResult =
        assessmentRatingService.findByTargetKindForRelatedSelector(
            EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    assertTrue(actualFindByTargetKindForRelatedSelectorResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code CHILDREN}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions); given 'CHILDREN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AssessmentRatingService.findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByTargetKindForRelatedSelector_givenChildren() {
    // Arrange
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(selectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    List<AssessmentRating> actualFindByTargetKindForRelatedSelectorResult =
        assessmentRatingService.findByTargetKindForRelatedSelector(
            EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualFindByTargetKindForRelatedSelectorResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions); given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AssessmentRatingService.findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByTargetKindForRelatedSelector_givenEmpty() {
    // Arrange
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> emptyResult = Optional.empty();
    when(selectionOptions.joiningEntityKind()).thenReturn(emptyResult);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    List<AssessmentRating> actualFindByTargetKindForRelatedSelectorResult =
        assessmentRatingService.findByTargetKindForRelatedSelector(
            EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualFindByTargetKindForRelatedSelectorResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions); given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AssessmentRatingService.findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByTargetKindForRelatedSelector_givenHashSetAddActive() {
    // Arrange
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    List<AssessmentRating> actualFindByTargetKindForRelatedSelectorResult =
        assessmentRatingService.findByTargetKindForRelatedSelector(
            EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    assertTrue(actualFindByTargetKindForRelatedSelectorResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions); given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AssessmentRatingService.findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByTargetKindForRelatedSelector_givenHashSetAddActive2() {
    // Arrange
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    List<AssessmentRating> actualFindByTargetKindForRelatedSelectorResult =
        assessmentRatingService.findByTargetKindForRelatedSelector(
            EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    assertTrue(actualFindByTargetKindForRelatedSelectorResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions); given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AssessmentRatingService.findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByTargetKindForRelatedSelector_givenHashSetAddActive3() {
    // Arrange
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    List<AssessmentRating> actualFindByTargetKindForRelatedSelectorResult =
        assessmentRatingService.findByTargetKindForRelatedSelector(
            EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    assertTrue(actualFindByTargetKindForRelatedSelectorResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions); given HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AssessmentRatingService.findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByTargetKindForRelatedSelector_givenHashSetAddPending() {
    // Arrange
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    List<AssessmentRating> actualFindByTargetKindForRelatedSelectorResult =
        assessmentRatingService.findByTargetKindForRelatedSelector(
            EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    assertTrue(actualFindByTargetKindForRelatedSelectorResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given of {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions); given of 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AssessmentRatingService.findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByTargetKindForRelatedSelector_givenOfAll() {
    // Arrange
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(selectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    List<AssessmentRating> actualFindByTargetKindForRelatedSelectorResult =
        assessmentRatingService.findByTargetKindForRelatedSelector(
            EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualFindByTargetKindForRelatedSelectorResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given of {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions); given of 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AssessmentRatingService.findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByTargetKindForRelatedSelector_givenOfAll2() {
    // Arrange
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(selectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    List<AssessmentRating> actualFindByTargetKindForRelatedSelectorResult =
        assessmentRatingService.findByTargetKindForRelatedSelector(
            EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualFindByTargetKindForRelatedSelectorResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AssessmentRatingService.findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByTargetKindForRelatedSelector_thenThrowIllegalArgumentException() {
    // Arrange
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenThrow(new IllegalArgumentException());

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            assessmentRatingService.findByTargetKindForRelatedSelector(
                EntityKind.APPLICATION, selectionOptions));
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
  }

  /**
   * Test {@link AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_INITIATIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions); when 'CHANGE_INITIATIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AssessmentRatingService.findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByTargetKindForRelatedSelector_whenChangeInitiative() {
    // Arrange
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    List<AssessmentRating> actualFindByTargetKindForRelatedSelectorResult =
        assessmentRatingService.findByTargetKindForRelatedSelector(
            EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindByTargetKindForRelatedSelectorResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_UNIT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions); when 'CHANGE_UNIT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AssessmentRatingService.findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByTargetKindForRelatedSelector_whenChangeUnit() {
    // Arrange
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    List<AssessmentRating> actualFindByTargetKindForRelatedSelectorResult =
        assessmentRatingService.findByTargetKindForRelatedSelector(
            EntityKind.CHANGE_UNIT, selectionOptions);

    // Assert
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    assertTrue(actualFindByTargetKindForRelatedSelectorResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_UNIT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions); when 'CHANGE_UNIT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AssessmentRatingService.findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByTargetKindForRelatedSelector_whenChangeUnit2() {
    // Arrange
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    List<AssessmentRating> actualFindByTargetKindForRelatedSelectorResult =
        assessmentRatingService.findByTargetKindForRelatedSelector(
            EntityKind.CHANGE_UNIT, selectionOptions);

    // Assert
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindByTargetKindForRelatedSelectorResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code FLOW_DIAGRAM}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions); when 'FLOW_DIAGRAM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AssessmentRatingService.findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByTargetKindForRelatedSelector_whenFlowDiagram() {
    // Arrange
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    List<AssessmentRating> actualFindByTargetKindForRelatedSelectorResult =
        assessmentRatingService.findByTargetKindForRelatedSelector(
            EntityKind.FLOW_DIAGRAM, selectionOptions);

    // Assert
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindByTargetKindForRelatedSelectorResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AssessmentRatingService.deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testDeleteByAssessmentRatingRelatedSelector() {
    // Arrange
    when(assessmentRatingDao.deleteByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(1);

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters immutableSelectionFilters = builderResult.build();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(immutableSelectionFilters);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    int actualDeleteByAssessmentRatingRelatedSelectorResult =
        assessmentRatingService.deleteByAssessmentRatingRelatedSelector(
            EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(assessmentRatingDao).deleteByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions, atLeast(1)).filters();
    assertEquals(1, actualDeleteByAssessmentRatingRelatedSelectorResult);
  }

  /**
   * Test {@link AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AssessmentRatingService.deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testDeleteByAssessmentRatingRelatedSelector2() {
    // Arrange
    when(assessmentRatingDao.deleteByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(1);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APPLICATION)
                .name("Name")
                .build());

    // Act
    int actualDeleteByAssessmentRatingRelatedSelectorResult =
        assessmentRatingService.deleteByAssessmentRatingRelatedSelector(
            EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(assessmentRatingDao).deleteByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertEquals(1, actualDeleteByAssessmentRatingRelatedSelectorResult);
  }

  /**
   * Test {@link AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AssessmentRatingService.deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testDeleteByAssessmentRatingRelatedSelector3() {
    // Arrange
    when(assessmentRatingDao.deleteByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(1);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    int actualDeleteByAssessmentRatingRelatedSelectorResult =
        assessmentRatingService.deleteByAssessmentRatingRelatedSelector(
            EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(assessmentRatingDao).deleteByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    assertEquals(1, actualDeleteByAssessmentRatingRelatedSelectorResult);
  }

  /**
   * Test {@link AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AssessmentRatingService.deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testDeleteByAssessmentRatingRelatedSelector4() {
    // Arrange
    when(assessmentRatingDao.deleteByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(1);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    int actualDeleteByAssessmentRatingRelatedSelectorResult =
        assessmentRatingService.deleteByAssessmentRatingRelatedSelector(
            EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(assessmentRatingDao).deleteByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    assertEquals(1, actualDeleteByAssessmentRatingRelatedSelectorResult);
  }

  /**
   * Test {@link AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions); given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AssessmentRatingService.deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testDeleteByAssessmentRatingRelatedSelector_givenHashSetAddActive() {
    // Arrange
    when(assessmentRatingDao.deleteByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(1);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    int actualDeleteByAssessmentRatingRelatedSelectorResult =
        assessmentRatingService.deleteByAssessmentRatingRelatedSelector(
            EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(assessmentRatingDao).deleteByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    assertEquals(1, actualDeleteByAssessmentRatingRelatedSelectorResult);
  }

  /**
   * Test {@link AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions); given HashSet() add 'ACTIVE'; then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AssessmentRatingService.deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testDeleteByAssessmentRatingRelatedSelector_givenHashSetAddActive_thenCallsScope() {
    // Arrange
    when(assessmentRatingDao.deleteByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(1);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    int actualDeleteByAssessmentRatingRelatedSelectorResult =
        assessmentRatingService.deleteByAssessmentRatingRelatedSelector(
            EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(assessmentRatingDao).deleteByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    assertEquals(1, actualDeleteByAssessmentRatingRelatedSelectorResult);
  }

  /**
   * Test {@link AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions); given HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AssessmentRatingService.deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testDeleteByAssessmentRatingRelatedSelector_givenHashSetAddPending() {
    // Arrange
    when(assessmentRatingDao.deleteByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(1);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    int actualDeleteByAssessmentRatingRelatedSelectorResult =
        assessmentRatingService.deleteByAssessmentRatingRelatedSelector(
            EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(assessmentRatingDao).deleteByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    assertEquals(1, actualDeleteByAssessmentRatingRelatedSelectorResult);
  }

  /**
   * Test {@link AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions); then calls entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AssessmentRatingService.deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testDeleteByAssessmentRatingRelatedSelector_thenCallsEntityLifecycleStatuses() {
    // Arrange
    when(assessmentRatingDao.deleteByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(1);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    int actualDeleteByAssessmentRatingRelatedSelectorResult =
        assessmentRatingService.deleteByAssessmentRatingRelatedSelector(
            EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(assessmentRatingDao).deleteByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    assertEquals(1, actualDeleteByAssessmentRatingRelatedSelectorResult);
  }

  /**
   * Test {@link AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions); then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AssessmentRatingService.deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testDeleteByAssessmentRatingRelatedSelector_thenCallsScope() {
    // Arrange
    when(assessmentRatingDao.deleteByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(1);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    int actualDeleteByAssessmentRatingRelatedSelectorResult =
        assessmentRatingService.deleteByAssessmentRatingRelatedSelector(
            EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(assessmentRatingDao).deleteByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    assertEquals(1, actualDeleteByAssessmentRatingRelatedSelectorResult);
  }

  /**
   * Test {@link AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AssessmentRatingService.deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testDeleteByAssessmentRatingRelatedSelector_thenThrowIllegalArgumentException() {
    // Arrange
    when(assessmentRatingDao.deleteByGenericSelector(Mockito.<GenericSelector>any()))
        .thenThrow(new IllegalArgumentException());

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            assessmentRatingService.deleteByAssessmentRatingRelatedSelector(
                EntityKind.APPLICATION, selectionOptions));
    verify(assessmentRatingDao).deleteByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
  }

  /**
   * Test {@link AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_INITIATIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions); when 'CHANGE_INITIATIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AssessmentRatingService.deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testDeleteByAssessmentRatingRelatedSelector_whenChangeInitiative() {
    // Arrange
    when(assessmentRatingDao.deleteByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(1);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    int actualDeleteByAssessmentRatingRelatedSelectorResult =
        assessmentRatingService.deleteByAssessmentRatingRelatedSelector(
            EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(assessmentRatingDao).deleteByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions, atLeast(1)).entityReference();
    assertEquals(1, actualDeleteByAssessmentRatingRelatedSelectorResult);
  }

  /**
   * Test {@link AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_INITIATIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions); when 'CHANGE_INITIATIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AssessmentRatingService.deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testDeleteByAssessmentRatingRelatedSelector_whenChangeInitiative2() {
    // Arrange
    when(assessmentRatingDao.deleteByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(1);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    int actualDeleteByAssessmentRatingRelatedSelectorResult =
        assessmentRatingService.deleteByAssessmentRatingRelatedSelector(
            EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(assessmentRatingDao).deleteByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions, atLeast(1)).entityReference();
    assertEquals(1, actualDeleteByAssessmentRatingRelatedSelectorResult);
  }

  /**
   * Test {@link AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_UNIT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions); when 'CHANGE_UNIT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AssessmentRatingService.deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testDeleteByAssessmentRatingRelatedSelector_whenChangeUnit() {
    // Arrange
    when(assessmentRatingDao.deleteByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(1);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    int actualDeleteByAssessmentRatingRelatedSelectorResult =
        assessmentRatingService.deleteByAssessmentRatingRelatedSelector(
            EntityKind.CHANGE_UNIT, selectionOptions);

    // Assert
    verify(assessmentRatingDao).deleteByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    assertEquals(1, actualDeleteByAssessmentRatingRelatedSelectorResult);
  }

  /**
   * Test {@link AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_UNIT}.
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions); when 'CHANGE_UNIT'; then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AssessmentRatingService.deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testDeleteByAssessmentRatingRelatedSelector_whenChangeUnit_thenCallsScope() {
    // Arrange
    when(assessmentRatingDao.deleteByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(1);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    int actualDeleteByAssessmentRatingRelatedSelectorResult =
        assessmentRatingService.deleteByAssessmentRatingRelatedSelector(
            EntityKind.CHANGE_UNIT, selectionOptions);

    // Assert
    verify(assessmentRatingDao).deleteByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertEquals(1, actualDeleteByAssessmentRatingRelatedSelectorResult);
  }

  /**
   * Test {@link AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code FLOW_DIAGRAM}.
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#deleteByAssessmentRatingRelatedSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions); when 'FLOW_DIAGRAM'; then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AssessmentRatingService.deleteByAssessmentRatingRelatedSelector(EntityKind, IdSelectionOptions)"
  })
  void testDeleteByAssessmentRatingRelatedSelector_whenFlowDiagram_thenCallsScope() {
    // Arrange
    when(assessmentRatingDao.deleteByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(1);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    int actualDeleteByAssessmentRatingRelatedSelectorResult =
        assessmentRatingService.deleteByAssessmentRatingRelatedSelector(
            EntityKind.FLOW_DIAGRAM, selectionOptions);

    // Assert
    verify(assessmentRatingDao).deleteByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertEquals(1, actualDeleteByAssessmentRatingRelatedSelectorResult);
  }

  /**
   * Test {@link AssessmentRatingService#findByDefinitionId(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#findByDefinitionId(long)}
   */
  @Test
  @DisplayName("Test findByDefinitionId(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingService.findByDefinitionId(long)"})
  void testFindByDefinitionId_thenReturnEmpty() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByDefinitionId(anyLong())).thenReturn(new ArrayList<>());
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    List<AssessmentRating> actualFindByDefinitionIdResult =
        assessmentRatingService.findByDefinitionId(1L);

    // Assert
    verify(assessmentRatingDao).findByDefinitionId(1L);
    assertTrue(actualFindByDefinitionIdResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findByDefinitionId(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#findByDefinitionId(long)}
   */
  @Test
  @DisplayName("Test findByDefinitionId(long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AssessmentRatingService.findByDefinitionId(long)"})
  void testFindByDefinitionId_thenThrowIllegalArgumentException() {
    // Arrange
    when(assessmentRatingDao.findByDefinitionId(anyLong()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> assessmentRatingService.findByDefinitionId(1L));
    verify(assessmentRatingDao).findByDefinitionId(1L);
  }

  /**
   * Test {@link AssessmentRatingService#store(SaveAssessmentRatingCommand, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#store(SaveAssessmentRatingCommand,
   * String)}
   */
  @Test
  @DisplayName("Test store(SaveAssessmentRatingCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.store(SaveAssessmentRatingCommand, String)"})
  void testStore() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            assessmentRatingService.store(
                commentResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .provenance("Provenance")
                    .ratingId(1L)
                    .build(),
                "janedoe"));
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
  }

  /**
   * Test {@link AssessmentRatingService#store(SaveAssessmentRatingCommand, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#store(SaveAssessmentRatingCommand,
   * String)}
   */
  @Test
  @DisplayName("Test store(SaveAssessmentRatingCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.store(SaveAssessmentRatingCommand, String)"})
  void testStore2() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doThrow(new IllegalArgumentException())
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            assessmentRatingService.store(
                commentResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .provenance("Provenance")
                    .ratingId(1L)
                    .build(),
                "janedoe"));
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
  }

  /**
   * Test {@link AssessmentRatingService#store(SaveAssessmentRatingCommand, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#store(SaveAssessmentRatingCommand,
   * String)}
   */
  @Test
  @DisplayName("Test store(SaveAssessmentRatingCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.store(SaveAssessmentRatingCommand, String)"})
  void testStore3() throws InsufficientPrivelegeException {
    // Arrange
    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingList.add(
        commentResult
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
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.store(Mockito.<SaveAssessmentRatingCommand>any())).thenReturn(true);
    when(assessmentRatingDao.isUpdate(Mockito.<SaveAssessmentRatingCommand>any())).thenReturn(true);
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(assessmentRatingList);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.getRatingSchemeItemById(anyLong()))
        .thenReturn(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), settingsDao);

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    ImmutableSaveAssessmentRatingCommand.Builder commentResult2 =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act
    boolean actualStoreResult =
        assessmentRatingService.store(
            commentResult2
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).findForEntity(isA(EntityReference.class));
    verify(assessmentRatingDao).isUpdate(isA(SaveAssessmentRatingCommand.class));
    verify(assessmentRatingDao).store(isA(SaveAssessmentRatingCommand.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(ratingSchemeDAO, atLeast(1)).getRatingSchemeItemById(1L);
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertTrue(actualStoreResult);
  }

  /**
   * Test {@link AssessmentRatingService#store(SaveAssessmentRatingCommand, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#store(SaveAssessmentRatingCommand,
   * String)}
   */
  @Test
  @DisplayName("Test store(SaveAssessmentRatingCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.store(SaveAssessmentRatingCommand, String)"})
  void testStore4() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.store(Mockito.<SaveAssessmentRatingCommand>any())).thenReturn(true);
    when(assessmentRatingDao.isUpdate(Mockito.<SaveAssessmentRatingCommand>any())).thenReturn(true);
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.getRatingSchemeItemById(anyLong()))
        .thenReturn(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), settingsDao);

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act
    boolean actualStoreResult =
        assessmentRatingService.store(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).findForEntity(isA(EntityReference.class));
    verify(assessmentRatingDao).isUpdate(isA(SaveAssessmentRatingCommand.class));
    verify(assessmentRatingDao).store(isA(SaveAssessmentRatingCommand.class));
    verify(ratingSchemeDAO).getRatingSchemeItemById(1L);
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertTrue(actualStoreResult);
  }

  /**
   * Test {@link AssessmentRatingService#store(SaveAssessmentRatingCommand, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#store(SaveAssessmentRatingCommand,
   * String)}
   */
  @Test
  @DisplayName("Test store(SaveAssessmentRatingCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.store(SaveAssessmentRatingCommand, String)"})
  void testStore5() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.store(Mockito.<SaveAssessmentRatingCommand>any())).thenReturn(true);
    when(assessmentRatingDao.isUpdate(Mockito.<SaveAssessmentRatingCommand>any())).thenReturn(true);
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.getRatingSchemeItemById(anyLong()))
        .thenReturn(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());

    AssessmentRatingRippler rippler = mock(AssessmentRatingRippler.class);
    when(rippler.findRippleConfig()).thenReturn(new HashSet<>());

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act
    boolean actualStoreResult =
        assessmentRatingService.store(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).findForEntity(isA(EntityReference.class));
    verify(assessmentRatingDao).isUpdate(isA(SaveAssessmentRatingCommand.class));
    verify(assessmentRatingDao).store(isA(SaveAssessmentRatingCommand.class));
    verify(rippler).findRippleConfig();
    verify(ratingSchemeDAO).getRatingSchemeItemById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertTrue(actualStoreResult);
  }

  /**
   * Test {@link AssessmentRatingService#store(SaveAssessmentRatingCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link AssessmentRatingDao} {@link
   *       AssessmentRatingDao#isUpdate(SaveAssessmentRatingCommand)} return {@code false}.
   *   <li>Then calls {@link AssessmentRatingRippler#findRippleConfig()}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#store(SaveAssessmentRatingCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test store(SaveAssessmentRatingCommand, String); given AssessmentRatingDao isUpdate(SaveAssessmentRatingCommand) return 'false'; then calls findRippleConfig()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.store(SaveAssessmentRatingCommand, String)"})
  void testStore_givenAssessmentRatingDaoIsUpdateReturnFalse_thenCallsFindRippleConfig()
      throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.store(Mockito.<SaveAssessmentRatingCommand>any())).thenReturn(true);
    when(assessmentRatingDao.isUpdate(Mockito.<SaveAssessmentRatingCommand>any()))
        .thenReturn(false);
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.getRatingSchemeItemById(anyLong()))
        .thenReturn(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());

    AssessmentRatingRippler rippler = mock(AssessmentRatingRippler.class);
    when(rippler.findRippleConfig()).thenReturn(new HashSet<>());

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act
    boolean actualStoreResult =
        assessmentRatingService.store(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).findForEntity(isA(EntityReference.class));
    verify(assessmentRatingDao).isUpdate(isA(SaveAssessmentRatingCommand.class));
    verify(assessmentRatingDao).store(isA(SaveAssessmentRatingCommand.class));
    verify(rippler).findRippleConfig();
    verify(ratingSchemeDAO).getRatingSchemeItemById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertTrue(actualStoreResult);
  }

  /**
   * Test {@link AssessmentRatingService#store(SaveAssessmentRatingCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link AssessmentRatingDao} {@link
   *       AssessmentRatingDao#store(SaveAssessmentRatingCommand)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#store(SaveAssessmentRatingCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test store(SaveAssessmentRatingCommand, String); given AssessmentRatingDao store(SaveAssessmentRatingCommand) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.store(SaveAssessmentRatingCommand, String)"})
  void testStore_givenAssessmentRatingDaoStoreReturnFalse_thenReturnFalse()
      throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.store(Mockito.<SaveAssessmentRatingCommand>any())).thenReturn(false);
    when(assessmentRatingDao.isUpdate(Mockito.<SaveAssessmentRatingCommand>any())).thenReturn(true);
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.getRatingSchemeItemById(anyLong()))
        .thenReturn(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());

    AssessmentRatingRippler rippler = mock(AssessmentRatingRippler.class);
    when(rippler.findRippleConfig()).thenReturn(new HashSet<>());

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act
    boolean actualStoreResult =
        assessmentRatingService.store(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).findForEntity(isA(EntityReference.class));
    verify(assessmentRatingDao).isUpdate(isA(SaveAssessmentRatingCommand.class));
    verify(assessmentRatingDao).store(isA(SaveAssessmentRatingCommand.class));
    verify(rippler).findRippleConfig();
    verify(ratingSchemeDAO).getRatingSchemeItemById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertFalse(actualStoreResult);
  }

  /**
   * Test {@link AssessmentRatingService#store(SaveAssessmentRatingCommand, String)}.
   *
   * <ul>
   *   <li>Given builder addRatingOperations builder ratingId one build.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#store(SaveAssessmentRatingCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test store(SaveAssessmentRatingCommand, String); given builder addRatingOperations builder ratingId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.store(SaveAssessmentRatingCommand, String)"})
  void testStore_givenBuilderAddRatingOperationsBuilderRatingIdOneBuild()
      throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.store(Mockito.<SaveAssessmentRatingCommand>any())).thenReturn(true);
    when(assessmentRatingDao.isUpdate(Mockito.<SaveAssessmentRatingCommand>any())).thenReturn(true);
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.getRatingSchemeItemById(anyLong()))
        .thenReturn(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    builderResult.addRatingOperations(
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build());
    ImmutableAssessmentDefinitionRatingOperations immutableAssessmentDefinitionRatingOperations =
        builderResult.addAllRatingOperations(new ArrayList<>()).build();

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(immutableAssessmentDefinitionRatingOperations);

    AssessmentRatingRippler rippler = mock(AssessmentRatingRippler.class);
    when(rippler.findRippleConfig()).thenReturn(new HashSet<>());

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act
    boolean actualStoreResult =
        assessmentRatingService.store(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).findForEntity(isA(EntityReference.class));
    verify(assessmentRatingDao).isUpdate(isA(SaveAssessmentRatingCommand.class));
    verify(assessmentRatingDao).store(isA(SaveAssessmentRatingCommand.class));
    verify(rippler).findRippleConfig();
    verify(ratingSchemeDAO).getRatingSchemeItemById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertTrue(actualStoreResult);
  }

  /**
   * Test {@link AssessmentRatingService#store(SaveAssessmentRatingCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#store(SaveAssessmentRatingCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test store(SaveAssessmentRatingCommand, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.store(SaveAssessmentRatingCommand, String)"})
  void testStore_givenChangeLogDaoWriteReturn19088743_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.store(Mockito.<SaveAssessmentRatingCommand>any())).thenReturn(true);
    when(assessmentRatingDao.isUpdate(Mockito.<SaveAssessmentRatingCommand>any())).thenReturn(true);
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.getRatingSchemeItemById(anyLong()))
        .thenReturn(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), settingsDao);

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act
    boolean actualStoreResult =
        assessmentRatingService.store(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).findForEntity(isA(EntityReference.class));
    verify(assessmentRatingDao).isUpdate(isA(SaveAssessmentRatingCommand.class));
    verify(assessmentRatingDao).store(isA(SaveAssessmentRatingCommand.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(ratingSchemeDAO).getRatingSchemeItemById(1L);
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertTrue(actualStoreResult);
  }

  /**
   * Test {@link AssessmentRatingService#store(SaveAssessmentRatingCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#store(SaveAssessmentRatingCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test store(SaveAssessmentRatingCommand, String); given ChangeLogService write(ChangeLog) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.store(SaveAssessmentRatingCommand, String)"})
  void testStore_givenChangeLogServiceWriteThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.isUpdate(Mockito.<SaveAssessmentRatingCommand>any())).thenReturn(true);
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.getRatingSchemeItemById(anyLong()))
        .thenReturn(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException());

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            assessmentRatingService.store(
                commentResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .provenance("Provenance")
                    .ratingId(1L)
                    .build(),
                "janedoe"));
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).findForEntity(isA(EntityReference.class));
    verify(assessmentRatingDao).isUpdate(isA(SaveAssessmentRatingCommand.class));
    verify(ratingSchemeDAO).getRatingSchemeItemById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
  }

  /**
   * Test {@link AssessmentRatingService#store(SaveAssessmentRatingCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code collection must not be null} is {@code collection
   *       must not be null}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#store(SaveAssessmentRatingCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test store(SaveAssessmentRatingCommand, String); given HashMap() 'collection must not be null' is 'collection must not be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.store(SaveAssessmentRatingCommand, String)"})
  void testStore_givenHashMapCollectionMustNotBeNullIsCollectionMustNotBeNull()
      throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.store(Mockito.<SaveAssessmentRatingCommand>any())).thenReturn(true);
    when(assessmentRatingDao.isUpdate(Mockito.<SaveAssessmentRatingCommand>any())).thenReturn(true);
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.getRatingSchemeItemById(anyLong()))
        .thenReturn(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("collection must not be null", "collection must not be null");

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), settingsDao);

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act
    boolean actualStoreResult =
        assessmentRatingService.store(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).findForEntity(isA(EntityReference.class));
    verify(assessmentRatingDao).isUpdate(isA(SaveAssessmentRatingCommand.class));
    verify(assessmentRatingDao).store(isA(SaveAssessmentRatingCommand.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(ratingSchemeDAO).getRatingSchemeItemById(1L);
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertTrue(actualStoreResult);
  }

  /**
   * Test {@link AssessmentRatingService#store(SaveAssessmentRatingCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add builder name {@code Name} build.
   *   <li>Then calls {@link AssessmentRatingRippler#findRippleConfig()}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#store(SaveAssessmentRatingCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test store(SaveAssessmentRatingCommand, String); given HashSet() add builder name 'Name' build; then calls findRippleConfig()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.store(SaveAssessmentRatingCommand, String)"})
  void testStore_givenHashSetAddBuilderNameNameBuild_thenCallsFindRippleConfig()
      throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.store(Mockito.<SaveAssessmentRatingCommand>any())).thenReturn(true);
    when(assessmentRatingDao.isUpdate(Mockito.<SaveAssessmentRatingCommand>any())).thenReturn(true);
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.getRatingSchemeItemById(anyLong()))
        .thenReturn(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());

    HashSet<AssessmentRipplerJobConfiguration> assessmentRipplerJobConfigurationSet =
        new HashSet<>();
    assessmentRipplerJobConfigurationSet.add(
        ImmutableAssessmentRipplerJobConfiguration.builder().name("Name").build());

    AssessmentRatingRippler rippler = mock(AssessmentRatingRippler.class);
    when(rippler.findRippleConfig()).thenReturn(assessmentRipplerJobConfigurationSet);

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act
    boolean actualStoreResult =
        assessmentRatingService.store(
            commentResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .ratingId(1L)
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).findForEntity(isA(EntityReference.class));
    verify(assessmentRatingDao).isUpdate(isA(SaveAssessmentRatingCommand.class));
    verify(assessmentRatingDao).store(isA(SaveAssessmentRatingCommand.class));
    verify(rippler).findRippleConfig();
    verify(ratingSchemeDAO).getRatingSchemeItemById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertTrue(actualStoreResult);
  }

  /**
   * Test {@link AssessmentRatingService#store(SaveAssessmentRatingCommand, String)}.
   *
   * <ul>
   *   <li>Then calls {@link SaveAssessmentRatingCommand#comment()}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#store(SaveAssessmentRatingCommand,
   * String)}
   */
  @Test
  @DisplayName("Test store(SaveAssessmentRatingCommand, String); then calls comment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.store(SaveAssessmentRatingCommand, String)"})
  void testStore_thenCallsComment() throws InsufficientPrivelegeException {
    // Arrange
    when(assessmentRatingDao.store(Mockito.<SaveAssessmentRatingCommand>any())).thenReturn(true);
    when(assessmentRatingDao.isUpdate(Mockito.<SaveAssessmentRatingCommand>any())).thenReturn(true);
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());
    when(ratingSchemeDAO.getRatingSchemeItemById(anyLong()))
        .thenReturn(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());
    when(assessmentRatingRippler.findRippleConfig()).thenThrow(new IllegalArgumentException());

    SaveAssessmentRatingCommand command = mock(SaveAssessmentRatingCommand.class);
    when(command.comment()).thenReturn("Comment");
    when(command.assessmentDefinitionId()).thenReturn(1L);
    when(command.ratingId()).thenReturn(1L);
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> assessmentRatingService.store(command, "janedoe"));
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).findForEntity(isA(EntityReference.class));
    verify(assessmentRatingDao).isUpdate(isA(SaveAssessmentRatingCommand.class));
    verify(assessmentRatingDao).store(isA(SaveAssessmentRatingCommand.class));
    verify(assessmentRatingRippler).findRippleConfig();
    verify(ratingSchemeDAO).getRatingSchemeItemById(1L);
    verify(command).comment();
    verify(command, atLeast(1)).assessmentDefinitionId();
    verify(command, atLeast(1)).entityReference();
    verify(command, atLeast(1)).ratingId();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
  }

  /**
   * Test {@link AssessmentRatingService#lock(EntityReference, long, long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#lock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName("Test lock(EntityReference, long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.lock(EntityReference, long, long, String)"})
  void testLock() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> assessmentRatingService.lock(null, 1L, 1L, "janedoe"));
    verify(assessmentRatingPermissionChecker).getRatingPermissions(isNull(), eq(1L), eq("janedoe"));
  }

  /**
   * Test {@link AssessmentRatingService#lock(EntityReference, long, long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#lock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName("Test lock(EntityReference, long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.lock(EntityReference, long, long, String)"})
  void testLock2() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doThrow(new IllegalArgumentException())
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> assessmentRatingService.lock(null, 1L, 1L, "janedoe"));
    verify(assessmentRatingPermissionChecker).getRatingPermissions(isNull(), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
  }

  /**
   * Test {@link AssessmentRatingService#lock(EntityReference, long, long, String)}.
   *
   * <ul>
   *   <li>Given {@link AssessmentDefinitionDao}.
   *   <li>When two.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#lock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName(
      "Test lock(EntityReference, long, long, String); given AssessmentDefinitionDao; when two; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.lock(EntityReference, long, long, String)"})
  void testLock_givenAssessmentDefinitionDao_whenTwo_thenReturnTrue()
      throws InsufficientPrivelegeException {
    // Arrange
    when(assessmentRatingDao.lock(
            Mockito.<EntityReference>any(), anyLong(), anyLong(), Mockito.<String>any()))
        .thenReturn(true);

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    builderResult.addRatingOperations(
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build());
    ImmutableAssessmentDefinitionRatingOperations immutableAssessmentDefinitionRatingOperations =
        builderResult.addAllRatingOperations(new ArrayList<>()).build();
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(immutableAssessmentDefinitionRatingOperations);

    // Act
    boolean actualLockResult = assessmentRatingService.lock(null, 1L, 2L, "janedoe");

    // Assert
    verify(assessmentRatingDao).lock(isNull(), eq(1L), eq(2L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker).getRatingPermissions(isNull(), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertTrue(actualLockResult);
  }

  /**
   * Test {@link AssessmentRatingService#lock(EntityReference, long, long, String)}.
   *
   * <ul>
   *   <li>Given {@link AssessmentRatingDao} {@link AssessmentRatingDao#lock(EntityReference, long,
   *       long, String)} return {@code false}.
   *   <li>When {@code janedoe}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#lock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName(
      "Test lock(EntityReference, long, long, String); given AssessmentRatingDao lock(EntityReference, long, long, String) return 'false'; when 'janedoe'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.lock(EntityReference, long, long, String)"})
  void testLock_givenAssessmentRatingDaoLockReturnFalse_whenJanedoe_thenReturnFalse()
      throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.lock(
            Mockito.<EntityReference>any(), anyLong(), anyLong(), Mockito.<String>any()))
        .thenReturn(false);

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    boolean actualLockResult = assessmentRatingService.lock(null, 1L, 1L, "janedoe");

    // Assert
    verify(assessmentRatingDao).lock(isNull(), eq(1L), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker).getRatingPermissions(isNull(), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertFalse(actualLockResult);
  }

  /**
   * Test {@link AssessmentRatingService#lock(EntityReference, long, long, String)}.
   *
   * <ul>
   *   <li>Given {@link AssessmentRatingDao} {@link AssessmentRatingDao#lock(EntityReference, long,
   *       long, String)} return {@code true}.
   *   <li>When {@code janedoe}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#lock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName(
      "Test lock(EntityReference, long, long, String); given AssessmentRatingDao lock(EntityReference, long, long, String) return 'true'; when 'janedoe'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.lock(EntityReference, long, long, String)"})
  void testLock_givenAssessmentRatingDaoLockReturnTrue_whenJanedoe_thenReturnTrue()
      throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.lock(
            Mockito.<EntityReference>any(), anyLong(), anyLong(), Mockito.<String>any()))
        .thenReturn(true);

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    boolean actualLockResult = assessmentRatingService.lock(null, 1L, 1L, "janedoe");

    // Assert
    verify(assessmentRatingDao).lock(isNull(), eq(1L), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker).getRatingPermissions(isNull(), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertTrue(actualLockResult);
  }

  /**
   * Test {@link AssessmentRatingService#lock(EntityReference, long, long, String)}.
   *
   * <ul>
   *   <li>Given {@link AssessmentRatingDao} {@link AssessmentRatingDao#lock(EntityReference, long,
   *       long, String)} throw {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#lock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName(
      "Test lock(EntityReference, long, long, String); given AssessmentRatingDao lock(EntityReference, long, long, String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.lock(EntityReference, long, long, String)"})
  void testLock_givenAssessmentRatingDaoLockThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.lock(
            Mockito.<EntityReference>any(), anyLong(), anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> assessmentRatingService.lock(null, 1L, 1L, "janedoe"));
    verify(assessmentRatingDao).lock(isNull(), eq(1L), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker).getRatingPermissions(isNull(), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
  }

  /**
   * Test {@link AssessmentRatingService#lock(EntityReference, long, long, String)}.
   *
   * <ul>
   *   <li>Given builder addRatingOperations builder ratingId one build.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#lock(EntityReference, long, long, String)}
   */
  @Test
  @DisplayName(
      "Test lock(EntityReference, long, long, String); given builder addRatingOperations builder ratingId one build; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.lock(EntityReference, long, long, String)"})
  void testLock_givenBuilderAddRatingOperationsBuilderRatingIdOneBuild_thenReturnTrue()
      throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.lock(
            Mockito.<EntityReference>any(), anyLong(), anyLong(), Mockito.<String>any()))
        .thenReturn(true);

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    builderResult.addRatingOperations(
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build());
    ImmutableAssessmentDefinitionRatingOperations immutableAssessmentDefinitionRatingOperations =
        builderResult.addAllRatingOperations(new ArrayList<>()).build();

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(immutableAssessmentDefinitionRatingOperations);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    boolean actualLockResult = assessmentRatingService.lock(null, 1L, 1L, "janedoe");

    // Assert
    verify(assessmentRatingDao).lock(isNull(), eq(1L), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker).getRatingPermissions(isNull(), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertTrue(actualLockResult);
  }

  /**
   * Test {@link AssessmentRatingService#unlock(EntityReference, long, long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#unlock(EntityReference, long, long,
   * String)}
   */
  @Test
  @DisplayName("Test unlock(EntityReference, long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.unlock(EntityReference, long, long, String)"})
  void testUnlock() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> assessmentRatingService.unlock(null, 1L, 1L, "janedoe"));
    verify(assessmentRatingPermissionChecker).getRatingPermissions(isNull(), eq(1L), eq("janedoe"));
  }

  /**
   * Test {@link AssessmentRatingService#unlock(EntityReference, long, long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#unlock(EntityReference, long, long,
   * String)}
   */
  @Test
  @DisplayName("Test unlock(EntityReference, long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.unlock(EntityReference, long, long, String)"})
  void testUnlock2() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doThrow(new IllegalArgumentException())
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> assessmentRatingService.unlock(null, 1L, 1L, "janedoe"));
    verify(assessmentRatingPermissionChecker).getRatingPermissions(isNull(), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
  }

  /**
   * Test {@link AssessmentRatingService#unlock(EntityReference, long, long, String)}.
   *
   * <ul>
   *   <li>Given {@link AssessmentDefinitionDao}.
   *   <li>When two.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#unlock(EntityReference, long, long,
   * String)}
   */
  @Test
  @DisplayName(
      "Test unlock(EntityReference, long, long, String); given AssessmentDefinitionDao; when two; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.unlock(EntityReference, long, long, String)"})
  void testUnlock_givenAssessmentDefinitionDao_whenTwo_thenReturnTrue()
      throws InsufficientPrivelegeException {
    // Arrange
    when(assessmentRatingDao.unlock(
            Mockito.<EntityReference>any(), anyLong(), anyLong(), Mockito.<String>any()))
        .thenReturn(true);

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    builderResult.addRatingOperations(
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build());
    ImmutableAssessmentDefinitionRatingOperations immutableAssessmentDefinitionRatingOperations =
        builderResult.addAllRatingOperations(new ArrayList<>()).build();
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(immutableAssessmentDefinitionRatingOperations);

    // Act
    boolean actualUnlockResult = assessmentRatingService.unlock(null, 1L, 2L, "janedoe");

    // Assert
    verify(assessmentRatingDao).unlock(isNull(), eq(1L), eq(2L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker).getRatingPermissions(isNull(), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertTrue(actualUnlockResult);
  }

  /**
   * Test {@link AssessmentRatingService#unlock(EntityReference, long, long, String)}.
   *
   * <ul>
   *   <li>Given {@link AssessmentRatingDao} {@link AssessmentRatingDao#unlock(EntityReference,
   *       long, long, String)} return {@code false}.
   *   <li>When {@code janedoe}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#unlock(EntityReference, long, long,
   * String)}
   */
  @Test
  @DisplayName(
      "Test unlock(EntityReference, long, long, String); given AssessmentRatingDao unlock(EntityReference, long, long, String) return 'false'; when 'janedoe'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.unlock(EntityReference, long, long, String)"})
  void testUnlock_givenAssessmentRatingDaoUnlockReturnFalse_whenJanedoe_thenReturnFalse()
      throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.unlock(
            Mockito.<EntityReference>any(), anyLong(), anyLong(), Mockito.<String>any()))
        .thenReturn(false);

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    boolean actualUnlockResult = assessmentRatingService.unlock(null, 1L, 1L, "janedoe");

    // Assert
    verify(assessmentRatingDao).unlock(isNull(), eq(1L), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker).getRatingPermissions(isNull(), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertFalse(actualUnlockResult);
  }

  /**
   * Test {@link AssessmentRatingService#unlock(EntityReference, long, long, String)}.
   *
   * <ul>
   *   <li>Given {@link AssessmentRatingDao} {@link AssessmentRatingDao#unlock(EntityReference,
   *       long, long, String)} return {@code true}.
   *   <li>When {@code janedoe}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#unlock(EntityReference, long, long,
   * String)}
   */
  @Test
  @DisplayName(
      "Test unlock(EntityReference, long, long, String); given AssessmentRatingDao unlock(EntityReference, long, long, String) return 'true'; when 'janedoe'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.unlock(EntityReference, long, long, String)"})
  void testUnlock_givenAssessmentRatingDaoUnlockReturnTrue_whenJanedoe_thenReturnTrue()
      throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.unlock(
            Mockito.<EntityReference>any(), anyLong(), anyLong(), Mockito.<String>any()))
        .thenReturn(true);

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    boolean actualUnlockResult = assessmentRatingService.unlock(null, 1L, 1L, "janedoe");

    // Assert
    verify(assessmentRatingDao).unlock(isNull(), eq(1L), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker).getRatingPermissions(isNull(), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertTrue(actualUnlockResult);
  }

  /**
   * Test {@link AssessmentRatingService#unlock(EntityReference, long, long, String)}.
   *
   * <ul>
   *   <li>Given {@link AssessmentRatingDao} {@link AssessmentRatingDao#unlock(EntityReference,
   *       long, long, String)} throw {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#unlock(EntityReference, long, long,
   * String)}
   */
  @Test
  @DisplayName(
      "Test unlock(EntityReference, long, long, String); given AssessmentRatingDao unlock(EntityReference, long, long, String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.unlock(EntityReference, long, long, String)"})
  void testUnlock_givenAssessmentRatingDaoUnlockThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.unlock(
            Mockito.<EntityReference>any(), anyLong(), anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> assessmentRatingService.unlock(null, 1L, 1L, "janedoe"));
    verify(assessmentRatingDao).unlock(isNull(), eq(1L), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker).getRatingPermissions(isNull(), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
  }

  /**
   * Test {@link AssessmentRatingService#unlock(EntityReference, long, long, String)}.
   *
   * <ul>
   *   <li>Given builder addRatingOperations builder ratingId one build.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#unlock(EntityReference, long, long,
   * String)}
   */
  @Test
  @DisplayName(
      "Test unlock(EntityReference, long, long, String); given builder addRatingOperations builder ratingId one build; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.unlock(EntityReference, long, long, String)"})
  void testUnlock_givenBuilderAddRatingOperationsBuilderRatingIdOneBuild_thenReturnTrue()
      throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.unlock(
            Mockito.<EntityReference>any(), anyLong(), anyLong(), Mockito.<String>any()))
        .thenReturn(true);

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    builderResult.addRatingOperations(
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build());
    ImmutableAssessmentDefinitionRatingOperations immutableAssessmentDefinitionRatingOperations =
        builderResult.addAllRatingOperations(new ArrayList<>()).build();

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(immutableAssessmentDefinitionRatingOperations);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    boolean actualUnlockResult = assessmentRatingService.unlock(null, 1L, 1L, "janedoe");

    // Assert
    verify(assessmentRatingDao).unlock(isNull(), eq(1L), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker).getRatingPermissions(isNull(), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertTrue(actualUnlockResult);
  }

  /**
   * Test {@link AssessmentRatingService#remove(RemoveAssessmentRatingCommand, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#remove(RemoveAssessmentRatingCommand,
   * String)}
   */
  @Test
  @DisplayName("Test remove(RemoveAssessmentRatingCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.remove(RemoveAssessmentRatingCommand, String)"
  })
  void testRemove() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    ImmutableRemoveAssessmentRatingCommand.Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            assessmentRatingService.remove(
                assessmentDefinitionIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .ratingId(1L)
                    .build(),
                "janedoe"));
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
  }

  /**
   * Test {@link AssessmentRatingService#remove(RemoveAssessmentRatingCommand, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#remove(RemoveAssessmentRatingCommand,
   * String)}
   */
  @Test
  @DisplayName("Test remove(RemoveAssessmentRatingCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.remove(RemoveAssessmentRatingCommand, String)"
  })
  void testRemove2() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doThrow(new IllegalArgumentException())
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    ImmutableRemoveAssessmentRatingCommand.Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            assessmentRatingService.remove(
                assessmentDefinitionIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .ratingId(1L)
                    .build(),
                "janedoe"));
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
  }

  /**
   * Test {@link AssessmentRatingService#remove(RemoveAssessmentRatingCommand, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#remove(RemoveAssessmentRatingCommand,
   * String)}
   */
  @Test
  @DisplayName("Test remove(RemoveAssessmentRatingCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.remove(RemoveAssessmentRatingCommand, String)"
  })
  void testRemove3() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.bulkRemove(Mockito.<RemoveAssessmentRatingCommand>any()))
        .thenReturn(true);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(ratingSchemeItemSet);

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), settingsDao);

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    ImmutableRemoveAssessmentRatingCommand.Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act
    boolean actualRemoveResult =
        assessmentRatingService.remove(
            assessmentDefinitionIdResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .ratingId(1L)
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).bulkRemove(isA(RemoveAssessmentRatingCommand.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link AssessmentRatingService#remove(RemoveAssessmentRatingCommand, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#remove(RemoveAssessmentRatingCommand,
   * String)}
   */
  @Test
  @DisplayName("Test remove(RemoveAssessmentRatingCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.remove(RemoveAssessmentRatingCommand, String)"
  })
  void testRemove4() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.bulkRemove(Mockito.<RemoveAssessmentRatingCommand>any()))
        .thenReturn(true);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), settingsDao);

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    ImmutableRemoveAssessmentRatingCommand.Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act
    boolean actualRemoveResult =
        assessmentRatingService.remove(
            assessmentDefinitionIdResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .ratingId(1L)
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).bulkRemove(isA(RemoveAssessmentRatingCommand.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link AssessmentRatingService#remove(RemoveAssessmentRatingCommand, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#remove(RemoveAssessmentRatingCommand,
   * String)}
   */
  @Test
  @DisplayName("Test remove(RemoveAssessmentRatingCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.remove(RemoveAssessmentRatingCommand, String)"
  })
  void testRemove5() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.bulkRemove(Mockito.<RemoveAssessmentRatingCommand>any()))
        .thenReturn(true);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());

    AssessmentRatingRippler rippler = mock(AssessmentRatingRippler.class);
    when(rippler.findRippleConfig()).thenReturn(new HashSet<>());

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    ImmutableRemoveAssessmentRatingCommand.Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act
    boolean actualRemoveResult =
        assessmentRatingService.remove(
            assessmentDefinitionIdResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .ratingId(1L)
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).bulkRemove(isA(RemoveAssessmentRatingCommand.class));
    verify(rippler).findRippleConfig();
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link AssessmentRatingService#remove(RemoveAssessmentRatingCommand, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#remove(RemoveAssessmentRatingCommand,
   * String)}
   */
  @Test
  @DisplayName("Test remove(RemoveAssessmentRatingCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.remove(RemoveAssessmentRatingCommand, String)"
  })
  void testRemove6() throws InsufficientPrivelegeException {
    // Arrange
    when(assessmentRatingDao.bulkRemove(Mockito.<RemoveAssessmentRatingCommand>any()))
        .thenReturn(true);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());
    when(assessmentRatingRippler.findRippleConfig()).thenThrow(new IllegalArgumentException());

    ImmutableRemoveAssessmentRatingCommand.Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            assessmentRatingService.remove(
                assessmentDefinitionIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .ratingId(1L)
                    .build(),
                "janedoe"));
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).bulkRemove(isA(RemoveAssessmentRatingCommand.class));
    verify(assessmentRatingRippler).findRippleConfig();
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
  }

  /**
   * Test {@link AssessmentRatingService#remove(RemoveAssessmentRatingCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link AssessmentRatingDao} {@link
   *       AssessmentRatingDao#bulkRemove(RemoveAssessmentRatingCommand)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#remove(RemoveAssessmentRatingCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test remove(RemoveAssessmentRatingCommand, String); given AssessmentRatingDao bulkRemove(RemoveAssessmentRatingCommand) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.remove(RemoveAssessmentRatingCommand, String)"
  })
  void testRemove_givenAssessmentRatingDaoBulkRemoveReturnFalse_thenReturnFalse()
      throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.bulkRemove(Mockito.<RemoveAssessmentRatingCommand>any()))
        .thenReturn(false);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());

    AssessmentRatingRippler rippler = mock(AssessmentRatingRippler.class);
    when(rippler.findRippleConfig()).thenReturn(new HashSet<>());

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    ImmutableRemoveAssessmentRatingCommand.Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act
    boolean actualRemoveResult =
        assessmentRatingService.remove(
            assessmentDefinitionIdResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .ratingId(1L)
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).bulkRemove(isA(RemoveAssessmentRatingCommand.class));
    verify(rippler).findRippleConfig();
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link AssessmentRatingService#remove(RemoveAssessmentRatingCommand, String)}.
   *
   * <ul>
   *   <li>Given builder addRatingOperations builder ratingId one build.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#remove(RemoveAssessmentRatingCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test remove(RemoveAssessmentRatingCommand, String); given builder addRatingOperations builder ratingId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.remove(RemoveAssessmentRatingCommand, String)"
  })
  void testRemove_givenBuilderAddRatingOperationsBuilderRatingIdOneBuild()
      throws InsufficientPrivelegeException {
    // Arrange
    when(assessmentRatingDao.bulkRemove(Mockito.<RemoveAssessmentRatingCommand>any()))
        .thenReturn(true);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    builderResult.addRatingOperations(
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build());
    ImmutableAssessmentDefinitionRatingOperations immutableAssessmentDefinitionRatingOperations =
        builderResult.addAllRatingOperations(new ArrayList<>()).build();
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(immutableAssessmentDefinitionRatingOperations);
    when(assessmentRatingRippler.findRippleConfig()).thenReturn(new HashSet<>());

    ImmutableRemoveAssessmentRatingCommand.Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act
    boolean actualRemoveResult =
        assessmentRatingService.remove(
            assessmentDefinitionIdResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .ratingId(1L)
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).bulkRemove(isA(RemoveAssessmentRatingCommand.class));
    verify(assessmentRatingRippler).findRippleConfig();
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link AssessmentRatingService#remove(RemoveAssessmentRatingCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#remove(RemoveAssessmentRatingCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test remove(RemoveAssessmentRatingCommand, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.remove(RemoveAssessmentRatingCommand, String)"
  })
  void testRemove_givenChangeLogDaoWriteReturn19088743_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.bulkRemove(Mockito.<RemoveAssessmentRatingCommand>any()))
        .thenReturn(true);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), settingsDao);

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    ImmutableRemoveAssessmentRatingCommand.Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act
    boolean actualRemoveResult =
        assessmentRatingService.remove(
            assessmentDefinitionIdResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .ratingId(1L)
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).bulkRemove(isA(RemoveAssessmentRatingCommand.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link AssessmentRatingService#remove(RemoveAssessmentRatingCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#remove(RemoveAssessmentRatingCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test remove(RemoveAssessmentRatingCommand, String); given ChangeLogService write(ChangeLog) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.remove(RemoveAssessmentRatingCommand, String)"
  })
  void testRemove_givenChangeLogServiceWriteThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException());

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    ImmutableRemoveAssessmentRatingCommand.Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            assessmentRatingService.remove(
                assessmentDefinitionIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .ratingId(1L)
                    .build(),
                "janedoe"));
    verify(assessmentDefinitionDao).getById(1L);
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
  }

  /**
   * Test {@link AssessmentRatingService#remove(RemoveAssessmentRatingCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code collection must not be null} is {@code collection
   *       must not be null}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#remove(RemoveAssessmentRatingCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test remove(RemoveAssessmentRatingCommand, String); given HashMap() 'collection must not be null' is 'collection must not be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.remove(RemoveAssessmentRatingCommand, String)"
  })
  void testRemove_givenHashMapCollectionMustNotBeNullIsCollectionMustNotBeNull()
      throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.bulkRemove(Mockito.<RemoveAssessmentRatingCommand>any()))
        .thenReturn(true);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("collection must not be null", "collection must not be null");

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), settingsDao);

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    ImmutableRemoveAssessmentRatingCommand.Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act
    boolean actualRemoveResult =
        assessmentRatingService.remove(
            assessmentDefinitionIdResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .ratingId(1L)
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).bulkRemove(isA(RemoveAssessmentRatingCommand.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link AssessmentRatingService#remove(RemoveAssessmentRatingCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add builder name {@code Name} build.
   *   <li>Then calls {@link AssessmentRatingRippler#findRippleConfig()}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#remove(RemoveAssessmentRatingCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test remove(RemoveAssessmentRatingCommand, String); given HashSet() add builder name 'Name' build; then calls findRippleConfig()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.remove(RemoveAssessmentRatingCommand, String)"
  })
  void testRemove_givenHashSetAddBuilderNameNameBuild_thenCallsFindRippleConfig()
      throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.bulkRemove(Mockito.<RemoveAssessmentRatingCommand>any()))
        .thenReturn(true);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());

    HashSet<AssessmentRipplerJobConfiguration> assessmentRipplerJobConfigurationSet =
        new HashSet<>();
    assessmentRipplerJobConfigurationSet.add(
        ImmutableAssessmentRipplerJobConfiguration.builder().name("Name").build());

    AssessmentRatingRippler rippler = mock(AssessmentRatingRippler.class);
    when(rippler.findRippleConfig()).thenReturn(assessmentRipplerJobConfigurationSet);

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    ImmutableRemoveAssessmentRatingCommand.Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act
    boolean actualRemoveResult =
        assessmentRatingService.remove(
            assessmentDefinitionIdResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .ratingId(1L)
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).bulkRemove(isA(RemoveAssessmentRatingCommand.class));
    verify(rippler).findRippleConfig();
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[], long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[],
   * long, String)}
   */
  @Test
  @DisplayName("Test bulkStore(BulkAssessmentRatingCommand[], long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.bulkStore(BulkAssessmentRatingCommand[], long, String)"
  })
  void testBulkStore() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.add(Mockito.<Set<AssessmentRating>>any())).thenReturn(2);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());
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
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            assessmentRatingService.bulkStore(new BulkAssessmentRatingCommand[] {}, 1L, "janedoe"));
    verify(assessmentDefinitionDao, atLeast(1)).getById(1L);
    verify(assessmentRatingDao).add(isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForAssessmentDefinition(1L);
  }

  /**
   * Test {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[], long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[],
   * long, String)}
   */
  @Test
  @DisplayName("Test bulkStore(BulkAssessmentRatingCommand[], long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.bulkStore(BulkAssessmentRatingCommand[], long, String)"
  })
  void testBulkStore2() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.add(Mockito.<Set<AssessmentRating>>any())).thenReturn(2);
    when(assessmentRatingDao.bulkUpdateSingleValuedAssessments(
            Mockito.<Set<AssessmentRating>>any()))
        .thenReturn(42);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    boolean actualBulkStoreResult =
        assessmentRatingService.bulkStore(new BulkAssessmentRatingCommand[] {}, 1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao, atLeast(1)).getById(1L);
    verify(assessmentRatingDao).add(isA(Set.class));
    verify(assessmentRatingDao).bulkUpdateSingleValuedAssessments(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForAssessmentDefinition(1L);
    verify(changeLogService, atLeast(1)).write(isA(Collection.class));
    assertTrue(actualBulkStoreResult);
  }

  /**
   * Test {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[], long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[],
   * long, String)}
   */
  @Test
  @DisplayName("Test bulkStore(BulkAssessmentRatingCommand[], long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.bulkStore(BulkAssessmentRatingCommand[], long, String)"
  })
  void testBulkStore3() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.bulkUpdateMultiValuedAssessments(Mockito.<Set<AssessmentRating>>any()))
        .thenReturn(42);
    when(assessmentRatingDao.add(Mockito.<Set<AssessmentRating>>any())).thenReturn(2);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_MANY)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    boolean actualBulkStoreResult =
        assessmentRatingService.bulkStore(new BulkAssessmentRatingCommand[] {}, 1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao, atLeast(1)).getById(1L);
    verify(assessmentRatingDao).add(isA(Set.class));
    verify(assessmentRatingDao).bulkUpdateMultiValuedAssessments(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForAssessmentDefinition(1L);
    verify(changeLogService, atLeast(1)).write(isA(Collection.class));
    assertTrue(actualBulkStoreResult);
  }

  /**
   * Test {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[], long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[],
   * long, String)}
   */
  @Test
  @DisplayName("Test bulkStore(BulkAssessmentRatingCommand[], long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.bulkStore(BulkAssessmentRatingCommand[], long, String)"
  })
  void testBulkStore4() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.bulkUpdateMultiValuedAssessments(Mockito.<Set<AssessmentRating>>any()))
        .thenThrow(new IllegalArgumentException());
    when(assessmentRatingDao.add(Mockito.<Set<AssessmentRating>>any())).thenReturn(2);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_MANY)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            assessmentRatingService.bulkStore(new BulkAssessmentRatingCommand[] {}, 1L, "janedoe"));
    verify(assessmentDefinitionDao, atLeast(1)).getById(1L);
    verify(assessmentRatingDao).add(isA(Set.class));
    verify(assessmentRatingDao).bulkUpdateMultiValuedAssessments(isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForAssessmentDefinition(1L);
    verify(changeLogService).write(isA(Collection.class));
  }

  /**
   * Test {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[], long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[],
   * long, String)}
   */
  @Test
  @DisplayName("Test bulkStore(BulkAssessmentRatingCommand[], long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.bulkStore(BulkAssessmentRatingCommand[], long, String)"
  })
  void testBulkStore5() {
    // Arrange
    when(assessmentRatingDao.bulkUpdateSingleValuedAssessments(
            Mockito.<Set<AssessmentRating>>any()))
        .thenReturn(42);
    when(assessmentRatingDao.add(Mockito.<Set<AssessmentRating>>any())).thenReturn(2);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    ratingSchemeItemList.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(ratingSchemeItemList);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    ImmutableBulkAssessmentRatingCommand.Builder commentResult =
        ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand immutableBulkAssessmentRatingCommand =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    // Act
    boolean actualBulkStoreResult =
        assessmentRatingService.bulkStore(
            new BulkAssessmentRatingCommand[] {immutableBulkAssessmentRatingCommand},
            1L,
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao, atLeast(1)).getById(1L);
    verify(assessmentRatingDao).add(isA(Set.class));
    verify(assessmentRatingDao).bulkUpdateSingleValuedAssessments(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForAssessmentDefinition(1L);
    verify(changeLogService, atLeast(1)).write(Mockito.<Collection<ChangeLog>>any());
    assertTrue(actualBulkStoreResult);
  }

  /**
   * Test {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[], long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[],
   * long, String)}
   */
  @Test
  @DisplayName("Test bulkStore(BulkAssessmentRatingCommand[], long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.bulkStore(BulkAssessmentRatingCommand[], long, String)"
  })
  void testBulkStore6() {
    // Arrange
    when(assessmentRatingDao.bulkUpdateSingleValuedAssessments(
            Mockito.<Set<AssessmentRating>>any()))
        .thenReturn(42);
    when(assessmentRatingDao.add(Mockito.<Set<AssessmentRating>>any())).thenReturn(2);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    ratingSchemeItemList.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(ratingSchemeItemList);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    ImmutableBulkAssessmentRatingCommand.Builder commentResult =
        ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand immutableBulkAssessmentRatingCommand =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    ImmutableBulkAssessmentRatingCommand.Builder commentResult2 =
        ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand immutableBulkAssessmentRatingCommand2 =
        commentResult2
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    // Act
    boolean actualBulkStoreResult =
        assessmentRatingService.bulkStore(
            new BulkAssessmentRatingCommand[] {
              immutableBulkAssessmentRatingCommand, immutableBulkAssessmentRatingCommand2
            },
            1L,
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao, atLeast(1)).getById(1L);
    verify(assessmentRatingDao).add(isA(Set.class));
    verify(assessmentRatingDao).bulkUpdateSingleValuedAssessments(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForAssessmentDefinition(1L);
    verify(changeLogService, atLeast(1)).write(Mockito.<Collection<ChangeLog>>any());
    assertTrue(actualBulkStoreResult);
  }

  /**
   * Test {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[], long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[],
   * long, String)}
   */
  @Test
  @DisplayName("Test bulkStore(BulkAssessmentRatingCommand[], long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.bulkStore(BulkAssessmentRatingCommand[], long, String)"
  })
  void testBulkStore7() {
    // Arrange
    when(assessmentRatingDao.bulkUpdateSingleValuedAssessments(
            Mockito.<Set<AssessmentRating>>any()))
        .thenReturn(42);
    when(assessmentRatingDao.add(Mockito.<Set<AssessmentRating>>any())).thenReturn(2);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    ratingSchemeItemList.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(ratingSchemeItemList);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    ImmutableBulkAssessmentRatingCommand.Builder commentResult =
        ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand immutableBulkAssessmentRatingCommand =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    ImmutableBulkAssessmentRatingCommand.Builder commentResult2 =
        ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand immutableBulkAssessmentRatingCommand2 =
        commentResult2
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    ImmutableBulkAssessmentRatingCommand.Builder commentResult3 =
        ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand immutableBulkAssessmentRatingCommand3 =
        commentResult3
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    // Act
    boolean actualBulkStoreResult =
        assessmentRatingService.bulkStore(
            new BulkAssessmentRatingCommand[] {
              immutableBulkAssessmentRatingCommand,
              immutableBulkAssessmentRatingCommand2,
              immutableBulkAssessmentRatingCommand3
            },
            1L,
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao, atLeast(1)).getById(1L);
    verify(assessmentRatingDao).add(isA(Set.class));
    verify(assessmentRatingDao).bulkUpdateSingleValuedAssessments(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForAssessmentDefinition(1L);
    verify(changeLogService, atLeast(1)).write(Mockito.<Collection<ChangeLog>>any());
    assertTrue(actualBulkStoreResult);
  }

  /**
   * Test {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[], long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[],
   * long, String)}
   */
  @Test
  @DisplayName("Test bulkStore(BulkAssessmentRatingCommand[], long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.bulkStore(BulkAssessmentRatingCommand[], long, String)"
  })
  void testBulkStore8() {
    // Arrange
    when(assessmentRatingDao.bulkUpdateSingleValuedAssessments(
            Mockito.<Set<AssessmentRating>>any()))
        .thenThrow(new IllegalArgumentException());
    when(assessmentRatingDao.add(Mockito.<Set<AssessmentRating>>any())).thenReturn(2);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    ratingSchemeItemList.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(ratingSchemeItemList);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    ImmutableBulkAssessmentRatingCommand.Builder commentResult =
        ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand immutableBulkAssessmentRatingCommand =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            assessmentRatingService.bulkStore(
                new BulkAssessmentRatingCommand[] {immutableBulkAssessmentRatingCommand},
                1L,
                "janedoe"));
    verify(assessmentDefinitionDao, atLeast(1)).getById(1L);
    verify(assessmentRatingDao).add(isA(Set.class));
    verify(assessmentRatingDao).bulkUpdateSingleValuedAssessments(isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForAssessmentDefinition(1L);
    verify(changeLogService).write(isA(Collection.class));
  }

  /**
   * Test {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[], long, String)}.
   *
   * <ul>
   *   <li>Given {@link AssessmentDefinitionDao} {@link AssessmentDefinitionDao#getById(long)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[],
   * long, String)}
   */
  @Test
  @DisplayName(
      "Test bulkStore(BulkAssessmentRatingCommand[], long, String); given AssessmentDefinitionDao getById(long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.bulkStore(BulkAssessmentRatingCommand[], long, String)"
  })
  void testBulkStore_givenAssessmentDefinitionDaoGetByIdThrowIllegalArgumentException() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.getById(anyLong())).thenThrow(new IllegalArgumentException());
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            assessmentRatingService.bulkStore(
                new BulkAssessmentRatingCommand[] {null}, 1L, "janedoe"));
    verify(assessmentDefinitionDao).getById(1L);
  }

  /**
   * Test {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[], long, String)}.
   *
   * <ul>
   *   <li>Given {@link AssessmentRatingDao} {@link AssessmentRatingDao#add(Set)} return {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[],
   * long, String)}
   */
  @Test
  @DisplayName(
      "Test bulkStore(BulkAssessmentRatingCommand[], long, String); given AssessmentRatingDao add(Set) return MIN_VALUE; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.bulkStore(BulkAssessmentRatingCommand[], long, String)"
  })
  void testBulkStore_givenAssessmentRatingDaoAddReturnMin_value_thenReturnFalse() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.add(Mockito.<Set<AssessmentRating>>any()))
        .thenReturn(Integer.MIN_VALUE);
    when(assessmentRatingDao.bulkUpdateSingleValuedAssessments(
            Mockito.<Set<AssessmentRating>>any()))
        .thenReturn(42);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    boolean actualBulkStoreResult =
        assessmentRatingService.bulkStore(new BulkAssessmentRatingCommand[] {}, 1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao, atLeast(1)).getById(1L);
    verify(assessmentRatingDao).add(isA(Set.class));
    verify(assessmentRatingDao).bulkUpdateSingleValuedAssessments(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForAssessmentDefinition(1L);
    verify(changeLogService, atLeast(1)).write(isA(Collection.class));
    assertFalse(actualBulkStoreResult);
  }

  /**
   * Test {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[], long, String)}.
   *
   * <ul>
   *   <li>Given {@link AssessmentRatingDao} {@link AssessmentRatingDao#add(Set)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[],
   * long, String)}
   */
  @Test
  @DisplayName(
      "Test bulkStore(BulkAssessmentRatingCommand[], long, String); given AssessmentRatingDao add(Set) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.bulkStore(BulkAssessmentRatingCommand[], long, String)"
  })
  void testBulkStore_givenAssessmentRatingDaoAddThrowIllegalArgumentException() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.add(Mockito.<Set<AssessmentRating>>any()))
        .thenThrow(new IllegalArgumentException());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            assessmentRatingService.bulkStore(new BulkAssessmentRatingCommand[] {}, 1L, "janedoe"));
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).add(isA(Set.class));
  }

  /**
   * Test {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[], long, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(Collection)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[],
   * long, String)}
   */
  @Test
  @DisplayName(
      "Test bulkStore(BulkAssessmentRatingCommand[], long, String); given ChangeLogService write(Collection) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.bulkStore(BulkAssessmentRatingCommand[], long, String)"
  })
  void testBulkStore_givenChangeLogServiceWriteThrowIllegalArgumentException() {
    // Arrange
    when(assessmentRatingDao.add(Mockito.<Set<AssessmentRating>>any())).thenReturn(2);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    ratingSchemeItemList.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(ratingSchemeItemList);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenThrow(new IllegalArgumentException());

    ImmutableBulkAssessmentRatingCommand.Builder commentResult =
        ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand immutableBulkAssessmentRatingCommand =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            assessmentRatingService.bulkStore(
                new BulkAssessmentRatingCommand[] {immutableBulkAssessmentRatingCommand},
                1L,
                "janedoe"));
    verify(assessmentDefinitionDao, atLeast(1)).getById(1L);
    verify(assessmentRatingDao).add(isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForAssessmentDefinition(1L);
    verify(changeLogService).write(isA(Collection.class));
  }

  /**
   * Test {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[], long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogDao#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[],
   * long, String)}
   */
  @Test
  @DisplayName(
      "Test bulkStore(BulkAssessmentRatingCommand[], long, String); then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.bulkStore(BulkAssessmentRatingCommand[], long, String)"
  })
  void testBulkStore_thenCallsWrite() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.add(Mockito.<Set<AssessmentRating>>any())).thenReturn(2);
    when(assessmentRatingDao.bulkUpdateSingleValuedAssessments(
            Mockito.<Set<AssessmentRating>>any()))
        .thenReturn(42);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    boolean actualBulkStoreResult =
        assessmentRatingService.bulkStore(new BulkAssessmentRatingCommand[] {}, 1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao, atLeast(1)).getById(1L);
    verify(assessmentRatingDao).add(isA(Set.class));
    verify(assessmentRatingDao).bulkUpdateSingleValuedAssessments(isA(Set.class));
    verify(changeLogDao, atLeast(1)).write(isA(Collection.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForAssessmentDefinition(1L);
    assertTrue(actualBulkStoreResult);
  }

  /**
   * Test {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[], long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogDao#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[],
   * long, String)}
   */
  @Test
  @DisplayName(
      "Test bulkStore(BulkAssessmentRatingCommand[], long, String); then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.bulkStore(BulkAssessmentRatingCommand[], long, String)"
  })
  void testBulkStore_thenCallsWrite2() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.add(Mockito.<Set<AssessmentRating>>any())).thenReturn(2);
    when(assessmentRatingDao.bulkUpdateSingleValuedAssessments(
            Mockito.<Set<AssessmentRating>>any()))
        .thenReturn(42);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    ratingSchemeItemList.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(ratingSchemeItemList);

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    boolean actualBulkStoreResult =
        assessmentRatingService.bulkStore(new BulkAssessmentRatingCommand[] {}, 1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao, atLeast(1)).getById(1L);
    verify(assessmentRatingDao).add(isA(Set.class));
    verify(assessmentRatingDao).bulkUpdateSingleValuedAssessments(isA(Set.class));
    verify(changeLogDao, atLeast(1)).write(isA(Collection.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForAssessmentDefinition(1L);
    assertTrue(actualBulkStoreResult);
  }

  /**
   * Test {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[], long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogDao#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#bulkStore(BulkAssessmentRatingCommand[],
   * long, String)}
   */
  @Test
  @DisplayName(
      "Test bulkStore(BulkAssessmentRatingCommand[], long, String); then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.bulkStore(BulkAssessmentRatingCommand[], long, String)"
  })
  void testBulkStore_thenCallsWrite3() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.add(Mockito.<Set<AssessmentRating>>any())).thenReturn(2);
    when(assessmentRatingDao.bulkUpdateSingleValuedAssessments(
            Mockito.<Set<AssessmentRating>>any()))
        .thenReturn(42);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    ratingSchemeItemList.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
    ratingSchemeItemList.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(ratingSchemeItemList);

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    boolean actualBulkStoreResult =
        assessmentRatingService.bulkStore(new BulkAssessmentRatingCommand[] {}, 1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao, atLeast(1)).getById(1L);
    verify(assessmentRatingDao).add(isA(Set.class));
    verify(assessmentRatingDao).bulkUpdateSingleValuedAssessments(isA(Set.class));
    verify(changeLogDao, atLeast(1)).write(isA(Collection.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForAssessmentDefinition(1L);
    assertTrue(actualBulkStoreResult);
  }

  /**
   * Test {@link AssessmentRatingService#bulkDelete(BulkAssessmentRatingCommand[], long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#bulkDelete(BulkAssessmentRatingCommand[],
   * long, String)}
   */
  @Test
  @DisplayName("Test bulkDelete(BulkAssessmentRatingCommand[], long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.bulkDelete(BulkAssessmentRatingCommand[], long, String)"
  })
  void testBulkDelete() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
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
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            assessmentRatingService.bulkDelete(
                new BulkAssessmentRatingCommand[] {}, 1L, "janedoe"));
    verify(assessmentDefinitionDao).getById(1L);
    verify(ratingSchemeDAO).findRatingSchemeItemsForAssessmentDefinition(1L);
  }

  /**
   * Test {@link AssessmentRatingService#bulkDelete(BulkAssessmentRatingCommand[], long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#bulkDelete(BulkAssessmentRatingCommand[],
   * long, String)}
   */
  @Test
  @DisplayName("Test bulkDelete(BulkAssessmentRatingCommand[], long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.bulkDelete(BulkAssessmentRatingCommand[], long, String)"
  })
  void testBulkDelete2() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.bulkRemove(Mockito.<Set<AssessmentRating>>any())).thenReturn(1);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    ratingSchemeItemList.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(ratingSchemeItemList);

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    boolean actualBulkDeleteResult =
        assessmentRatingService.bulkDelete(new BulkAssessmentRatingCommand[] {}, 1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).bulkRemove(isA(Set.class));
    verify(changeLogDao).write(isA(Collection.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForAssessmentDefinition(1L);
    assertFalse(actualBulkDeleteResult);
  }

  /**
   * Test {@link AssessmentRatingService#bulkDelete(BulkAssessmentRatingCommand[], long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#bulkDelete(BulkAssessmentRatingCommand[],
   * long, String)}
   */
  @Test
  @DisplayName("Test bulkDelete(BulkAssessmentRatingCommand[], long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.bulkDelete(BulkAssessmentRatingCommand[], long, String)"
  })
  void testBulkDelete3() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.bulkRemove(Mockito.<Set<AssessmentRating>>any())).thenReturn(1);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    ratingSchemeItemList.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
    ratingSchemeItemList.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(ratingSchemeItemList);

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    boolean actualBulkDeleteResult =
        assessmentRatingService.bulkDelete(new BulkAssessmentRatingCommand[] {}, 1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).bulkRemove(isA(Set.class));
    verify(changeLogDao).write(isA(Collection.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForAssessmentDefinition(1L);
    assertFalse(actualBulkDeleteResult);
  }

  /**
   * Test {@link AssessmentRatingService#bulkDelete(BulkAssessmentRatingCommand[], long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#bulkDelete(BulkAssessmentRatingCommand[],
   * long, String)}
   */
  @Test
  @DisplayName("Test bulkDelete(BulkAssessmentRatingCommand[], long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.bulkDelete(BulkAssessmentRatingCommand[], long, String)"
  })
  void testBulkDelete4() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.bulkRemove(Mockito.<Set<AssessmentRating>>any())).thenReturn(1);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    ImmutableBulkAssessmentRatingCommand.Builder commentResult =
        ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand immutableBulkAssessmentRatingCommand =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    // Act
    boolean actualBulkDeleteResult =
        assessmentRatingService.bulkDelete(
            new BulkAssessmentRatingCommand[] {immutableBulkAssessmentRatingCommand},
            1L,
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).bulkRemove(isA(Set.class));
    verify(changeLogDao).write(isA(Collection.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForAssessmentDefinition(1L);
    assertFalse(actualBulkDeleteResult);
  }

  /**
   * Test {@link AssessmentRatingService#bulkDelete(BulkAssessmentRatingCommand[], long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#bulkDelete(BulkAssessmentRatingCommand[],
   * long, String)}
   */
  @Test
  @DisplayName("Test bulkDelete(BulkAssessmentRatingCommand[], long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.bulkDelete(BulkAssessmentRatingCommand[], long, String)"
  })
  void testBulkDelete5() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.bulkRemove(Mockito.<Set<AssessmentRating>>any())).thenReturn(1);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    ImmutableBulkAssessmentRatingCommand.Builder commentResult =
        ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand immutableBulkAssessmentRatingCommand =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    ImmutableBulkAssessmentRatingCommand.Builder commentResult2 =
        ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand immutableBulkAssessmentRatingCommand2 =
        commentResult2
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    // Act
    boolean actualBulkDeleteResult =
        assessmentRatingService.bulkDelete(
            new BulkAssessmentRatingCommand[] {
              immutableBulkAssessmentRatingCommand, immutableBulkAssessmentRatingCommand2
            },
            1L,
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).bulkRemove(isA(Set.class));
    verify(changeLogDao).write(isA(Collection.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForAssessmentDefinition(1L);
    assertFalse(actualBulkDeleteResult);
  }

  /**
   * Test {@link AssessmentRatingService#bulkDelete(BulkAssessmentRatingCommand[], long, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#bulkDelete(BulkAssessmentRatingCommand[],
   * long, String)}
   */
  @Test
  @DisplayName("Test bulkDelete(BulkAssessmentRatingCommand[], long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.bulkDelete(BulkAssessmentRatingCommand[], long, String)"
  })
  void testBulkDelete6() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.bulkRemove(Mockito.<Set<AssessmentRating>>any())).thenReturn(1);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    boolean actualBulkDeleteResult =
        assessmentRatingService.bulkDelete(new BulkAssessmentRatingCommand[] {}, 1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).bulkRemove(isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForAssessmentDefinition(1L);
    verify(changeLogService).write(isA(Collection.class));
    assertFalse(actualBulkDeleteResult);
  }

  /**
   * Test {@link AssessmentRatingService#bulkDelete(BulkAssessmentRatingCommand[], long, String)}.
   *
   * <ul>
   *   <li>Given {@link AssessmentDefinitionDao} {@link AssessmentDefinitionDao#getById(long)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#bulkDelete(BulkAssessmentRatingCommand[],
   * long, String)}
   */
  @Test
  @DisplayName(
      "Test bulkDelete(BulkAssessmentRatingCommand[], long, String); given AssessmentDefinitionDao getById(long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.bulkDelete(BulkAssessmentRatingCommand[], long, String)"
  })
  void testBulkDelete_givenAssessmentDefinitionDaoGetByIdThrowIllegalArgumentException() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.getById(anyLong())).thenThrow(new IllegalArgumentException());
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            assessmentRatingService.bulkDelete(
                new BulkAssessmentRatingCommand[] {}, 1L, "janedoe"));
    verify(assessmentDefinitionDao).getById(1L);
  }

  /**
   * Test {@link AssessmentRatingService#bulkDelete(BulkAssessmentRatingCommand[], long, String)}.
   *
   * <ul>
   *   <li>Given {@link AssessmentRatingDao} {@link AssessmentRatingDao#bulkRemove(Set)} return two.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#bulkDelete(BulkAssessmentRatingCommand[],
   * long, String)}
   */
  @Test
  @DisplayName(
      "Test bulkDelete(BulkAssessmentRatingCommand[], long, String); given AssessmentRatingDao bulkRemove(Set) return two; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.bulkDelete(BulkAssessmentRatingCommand[], long, String)"
  })
  void testBulkDelete_givenAssessmentRatingDaoBulkRemoveReturnTwo_thenReturnTrue() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.bulkRemove(Mockito.<Set<AssessmentRating>>any())).thenReturn(2);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    boolean actualBulkDeleteResult =
        assessmentRatingService.bulkDelete(new BulkAssessmentRatingCommand[] {}, 1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).bulkRemove(isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForAssessmentDefinition(1L);
    verify(changeLogService).write(isA(Collection.class));
    assertTrue(actualBulkDeleteResult);
  }

  /**
   * Test {@link AssessmentRatingService#bulkDelete(BulkAssessmentRatingCommand[], long, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(Collection)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#bulkDelete(BulkAssessmentRatingCommand[],
   * long, String)}
   */
  @Test
  @DisplayName(
      "Test bulkDelete(BulkAssessmentRatingCommand[], long, String); given ChangeLogService write(Collection) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.bulkDelete(BulkAssessmentRatingCommand[], long, String)"
  })
  void testBulkDelete_givenChangeLogServiceWriteThrowIllegalArgumentException() {
    // Arrange
    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenThrow(new IllegalArgumentException());

    ImmutableBulkAssessmentRatingCommand.Builder commentResult =
        ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand immutableBulkAssessmentRatingCommand =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            assessmentRatingService.bulkDelete(
                new BulkAssessmentRatingCommand[] {immutableBulkAssessmentRatingCommand},
                1L,
                "janedoe"));
    verify(assessmentDefinitionDao).getById(1L);
    verify(ratingSchemeDAO).findRatingSchemeItemsForAssessmentDefinition(1L);
    verify(changeLogService).write(isA(Collection.class));
  }

  /**
   * Test {@link AssessmentRatingService#bulkDelete(BulkAssessmentRatingCommand[], long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogDao#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#bulkDelete(BulkAssessmentRatingCommand[],
   * long, String)}
   */
  @Test
  @DisplayName(
      "Test bulkDelete(BulkAssessmentRatingCommand[], long, String); then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.bulkDelete(BulkAssessmentRatingCommand[], long, String)"
  })
  void testBulkDelete_thenCallsWrite() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.bulkRemove(Mockito.<Set<AssessmentRating>>any())).thenReturn(1);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    boolean actualBulkDeleteResult =
        assessmentRatingService.bulkDelete(new BulkAssessmentRatingCommand[] {}, 1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).bulkRemove(isA(Set.class));
    verify(changeLogDao).write(isA(Collection.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForAssessmentDefinition(1L);
    assertFalse(actualBulkDeleteResult);
  }

  /**
   * Test {@link AssessmentRatingService#getRatingPermissions(EntityReference, long, String)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableAssessmentDefinitionRatingOperations}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#getRatingPermissions(EntityReference,
   * long, String)}
   */
  @Test
  @DisplayName(
      "Test getRatingPermissions(EntityReference, long, String); then return ImmutableAssessmentDefinitionRatingOperations")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentDefinitionRatingOperations AssessmentRatingService.getRatingPermissions(EntityReference, long, String)"
  })
  void testGetRatingPermissions_thenReturnImmutableAssessmentDefinitionRatingOperations() {
    // Arrange
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    AssessmentDefinitionRatingOperations actualRatingPermissions =
        assessmentRatingService.getRatingPermissions(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L,
            "janedoe");

    // Assert
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    assertTrue(actualRatingPermissions instanceof ImmutableAssessmentDefinitionRatingOperations);
    assertTrue(actualRatingPermissions.ratingOperations().isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#getRatingPermissions(EntityReference, long, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#getRatingPermissions(EntityReference,
   * long, String)}
   */
  @Test
  @DisplayName(
      "Test getRatingPermissions(EntityReference, long, String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentDefinitionRatingOperations AssessmentRatingService.getRatingPermissions(EntityReference, long, String)"
  })
  void testGetRatingPermissions_thenThrowIllegalArgumentException() {
    // Arrange
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> assessmentRatingService.getRatingPermissions(null, 1L, "janedoe"));
    verify(assessmentRatingPermissionChecker).getRatingPermissions(isNull(), eq(1L), eq("janedoe"));
  }

  /**
   * Test {@link AssessmentRatingService#updateComment(long, String, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#updateComment(long, String, String)}
   */
  @Test
  @DisplayName("Test updateComment(long, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.updateComment(long, String, String)"})
  void testUpdateComment() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    when(assessmentRatingDao.getById(anyLong()))
        .thenReturn(
            commentResult
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
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> assessmentRatingService.updateComment(1L, "Comment", "janedoe"));
    verify(assessmentRatingDao).getById(1L);
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
  }

  /**
   * Test {@link AssessmentRatingService#updateComment(long, String, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#updateComment(long, String, String)}
   */
  @Test
  @DisplayName("Test updateComment(long, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.updateComment(long, String, String)"})
  void testUpdateComment2() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    when(assessmentRatingDao.getById(anyLong()))
        .thenReturn(
            commentResult
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
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doThrow(new IllegalArgumentException())
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> assessmentRatingService.updateComment(1L, "Comment", "janedoe"));
    verify(assessmentRatingDao).getById(1L);
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
  }

  /**
   * Test {@link AssessmentRatingService#updateComment(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link AssessmentRatingDao} {@link AssessmentRatingDao#getById(long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#updateComment(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateComment(long, String, String); given AssessmentRatingDao getById(long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.updateComment(long, String, String)"})
  void testUpdateComment_givenAssessmentRatingDaoGetByIdThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.getById(anyLong())).thenThrow(new IllegalArgumentException());
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> assessmentRatingService.updateComment(1L, "Comment", "janedoe"));
    verify(assessmentRatingDao).getById(1L);
  }

  /**
   * Test {@link AssessmentRatingService#updateComment(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link AssessmentRatingDao} {@link AssessmentRatingDao#updateComment(long, String,
   *       String)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#updateComment(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateComment(long, String, String); given AssessmentRatingDao updateComment(long, String, String) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.updateComment(long, String, String)"})
  void testUpdateComment_givenAssessmentRatingDaoUpdateCommentReturnTrue_thenReturnTrue()
      throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.updateComment(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    when(assessmentRatingDao.getById(anyLong()))
        .thenReturn(
            commentResult
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
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.getRatingSchemeItemById(anyLong()))
        .thenReturn(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    boolean actualUpdateCommentResult =
        assessmentRatingService.updateComment(1L, "Comment", "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao, atLeast(1)).getById(1L);
    verify(assessmentRatingDao).updateComment(1L, "Comment", "janedoe");
    verify(ratingSchemeDAO).getRatingSchemeItemById(1L);
    verify(changeLogService).write(isA(Collection.class));
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertTrue(actualUpdateCommentResult);
  }

  /**
   * Test {@link AssessmentRatingService#updateComment(long, String, String)}.
   *
   * <ul>
   *   <li>Given builder addRatingOperations builder ratingId one build.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#updateComment(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateComment(long, String, String); given builder addRatingOperations builder ratingId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.updateComment(long, String, String)"})
  void testUpdateComment_givenBuilderAddRatingOperationsBuilderRatingIdOneBuild()
      throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.updateComment(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    when(assessmentRatingDao.getById(anyLong()))
        .thenReturn(
            commentResult
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
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.getRatingSchemeItemById(anyLong()))
        .thenReturn(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    builderResult.addRatingOperations(
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build());
    ImmutableAssessmentDefinitionRatingOperations immutableAssessmentDefinitionRatingOperations =
        builderResult.addAllRatingOperations(new ArrayList<>()).build();

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(immutableAssessmentDefinitionRatingOperations);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    boolean actualUpdateCommentResult =
        assessmentRatingService.updateComment(1L, "Comment", "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao, atLeast(1)).getById(1L);
    verify(assessmentRatingDao).updateComment(1L, "Comment", "janedoe");
    verify(ratingSchemeDAO).getRatingSchemeItemById(1L);
    verify(changeLogService).write(isA(Collection.class));
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertTrue(actualUpdateCommentResult);
  }

  /**
   * Test {@link AssessmentRatingService#updateComment(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(Collection)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#updateComment(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateComment(long, String, String); given ChangeLogService write(Collection) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.updateComment(long, String, String)"})
  void testUpdateComment_givenChangeLogServiceWriteThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    when(assessmentRatingDao.getById(anyLong()))
        .thenReturn(
            commentResult
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
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());
    when(ratingSchemeDAO.getRatingSchemeItemById(anyLong()))
        .thenReturn(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenThrow(new IllegalArgumentException());
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> assessmentRatingService.updateComment(1L, "Comment", "janedoe"));
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao, atLeast(1)).getById(1L);
    verify(ratingSchemeDAO).getRatingSchemeItemById(1L);
    verify(changeLogService).write(isA(Collection.class));
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
  }

  /**
   * Test {@link AssessmentRatingService#updateComment(long, String, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogDao#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#updateComment(long, String, String)}
   */
  @Test
  @DisplayName("Test updateComment(long, String, String); then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.updateComment(long, String, String)"})
  void testUpdateComment_thenCallsWrite() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.updateComment(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    when(assessmentRatingDao.getById(anyLong()))
        .thenReturn(
            commentResult
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
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.getRatingSchemeItemById(anyLong()))
        .thenReturn(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    boolean actualUpdateCommentResult =
        assessmentRatingService.updateComment(1L, "Comment", "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao, atLeast(1)).getById(1L);
    verify(assessmentRatingDao).updateComment(1L, "Comment", "janedoe");
    verify(changeLogDao).write(isA(Collection.class));
    verify(ratingSchemeDAO).getRatingSchemeItemById(1L);
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertTrue(actualUpdateCommentResult);
  }

  /**
   * Test {@link AssessmentRatingService#updateComment(long, String, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#updateComment(long, String, String)}
   */
  @Test
  @DisplayName("Test updateComment(long, String, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.updateComment(long, String, String)"})
  void testUpdateComment_thenReturnFalse() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.updateComment(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(false);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    when(assessmentRatingDao.getById(anyLong()))
        .thenReturn(
            commentResult
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
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.getRatingSchemeItemById(anyLong()))
        .thenReturn(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    boolean actualUpdateCommentResult =
        assessmentRatingService.updateComment(1L, "Comment", "janedoe");

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao, atLeast(1)).getById(1L);
    verify(assessmentRatingDao).updateComment(1L, "Comment", "janedoe");
    verify(ratingSchemeDAO).getRatingSchemeItemById(1L);
    verify(changeLogService).write(isA(Collection.class));
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
    assertFalse(actualUpdateCommentResult);
  }

  /**
   * Test {@link AssessmentRatingService#updateRating(long, UpdateRatingCommand, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#updateRating(long, UpdateRatingCommand,
   * String)}
   */
  @Test
  @DisplayName("Test updateRating(long, UpdateRatingCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.updateRating(long, UpdateRatingCommand, String)"
  })
  void testUpdateRating() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    when(assessmentRatingDao.getById(anyLong()))
        .thenReturn(
            commentResult
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
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.getById(anyLong())).thenThrow(new IllegalArgumentException());
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> assessmentRatingService.updateRating(1L, null, "janedoe"));
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).getById(1L);
  }

  /**
   * Test {@link AssessmentRatingService#updateRating(long, UpdateRatingCommand, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#updateRating(long, UpdateRatingCommand,
   * String)}
   */
  @Test
  @DisplayName("Test updateRating(long, UpdateRatingCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.updateRating(long, UpdateRatingCommand, String)"
  })
  void testUpdateRating2() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    when(assessmentRatingDao.getById(anyLong()))
        .thenReturn(
            commentResult
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
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> assessmentRatingService.updateRating(1L, null, "janedoe"));
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).getById(1L);
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
  }

  /**
   * Test {@link AssessmentRatingService#updateRating(long, UpdateRatingCommand, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#updateRating(long, UpdateRatingCommand,
   * String)}
   */
  @Test
  @DisplayName("Test updateRating(long, UpdateRatingCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.updateRating(long, UpdateRatingCommand, String)"
  })
  void testUpdateRating3() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    when(assessmentRatingDao.getById(anyLong()))
        .thenReturn(
            commentResult
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
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doThrow(new IllegalArgumentException())
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> assessmentRatingService.updateRating(1L, null, "janedoe"));
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).getById(1L);
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
  }

  /**
   * Test {@link AssessmentRatingService#updateRating(long, UpdateRatingCommand, String)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#updateRating(long, UpdateRatingCommand,
   * String)}
   */
  @Test
  @DisplayName("Test updateRating(long, UpdateRatingCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.updateRating(long, UpdateRatingCommand, String)"
  })
  void testUpdateRating4() throws InsufficientPrivelegeException {
    // Arrange
    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    when(assessmentRatingDao.getById(anyLong()))
        .thenReturn(
            commentResult
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
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_MANY)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> assessmentRatingService.updateRating(1L, null, "janedoe"));
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).getById(1L);
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
  }

  /**
   * Test {@link AssessmentRatingService#updateRating(long, UpdateRatingCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link AssessmentRatingDao} {@link AssessmentRatingDao#getById(long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#updateRating(long, UpdateRatingCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test updateRating(long, UpdateRatingCommand, String); given AssessmentRatingDao getById(long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.updateRating(long, UpdateRatingCommand, String)"
  })
  void testUpdateRating_givenAssessmentRatingDaoGetByIdThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.getById(anyLong())).thenThrow(new IllegalArgumentException());
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> assessmentRatingService.updateRating(1L, null, "janedoe"));
    verify(assessmentRatingDao).getById(1L);
  }

  /**
   * Test {@link AssessmentRatingService#updateRating(long, UpdateRatingCommand, String)}.
   *
   * <ul>
   *   <li>Then calls {@link RatingSchemeDAO#getById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#updateRating(long, UpdateRatingCommand,
   * String)}
   */
  @Test
  @DisplayName("Test updateRating(long, UpdateRatingCommand, String); then calls getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssessmentRatingService.updateRating(long, UpdateRatingCommand, String)"
  })
  void testUpdateRating_thenCallsGetById() throws InsufficientPrivelegeException {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    when(assessmentRatingDao.getById(anyLong()))
        .thenReturn(
            commentResult
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
                .provenance("Provenance")
                .ratingId(1L)
                .build());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.getById(anyLong())).thenThrow(new IllegalArgumentException());

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    doNothing()
        .when(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            Mockito.<Set<Operation>>any(),
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityKind>any(),
            Mockito.<String>any());

    ImmutableAssessmentDefinitionRatingOperations.Builder builderResult =
        ImmutableAssessmentDefinitionRatingOperations.builder();
    when(assessmentRatingPermissionChecker.getRatingPermissions(
            Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(builderResult.addAllRatingOperations(new ArrayList<>()).build());
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> assessmentRatingService.updateRating(1L, null, "janedoe"));
    verify(assessmentDefinitionDao).getById(1L);
    verify(assessmentRatingDao).getById(1L);
    verify(ratingSchemeDAO).getById(1L);
    verify(assessmentRatingPermissionChecker)
        .getRatingPermissions(isA(EntityReference.class), eq(1L), eq("janedoe"));
    verify(assessmentRatingPermissionChecker)
        .verifyAnyPerms(
            isA(Set.class), isA(Set.class), eq(EntityKind.ASSESSMENT_DEFINITION), eq("janedoe"));
  }

  /**
   * Test {@link AssessmentRatingService#findRatingSummaryCounts(EntityKind, IdSelectionOptions,
   * Set)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#findRatingSummaryCounts(EntityKind,
   * IdSelectionOptions, Set)}
   */
  @Test
  @DisplayName("Test findRatingSummaryCounts(EntityKind, IdSelectionOptions, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingService.findRatingSummaryCounts(EntityKind, IdSelectionOptions, Set)"
  })
  void testFindRatingSummaryCounts() {
    // Arrange
    when(assessmentRatingDao.findRatingSummaryCounts(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions idSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    Set<AssessmentRatingSummaryCounts> actualFindRatingSummaryCountsResult =
        assessmentRatingService.findRatingSummaryCounts(
            EntityKind.APPLICATION, idSelectionOptions, new HashSet<>());

    // Assert
    verify(assessmentRatingDao).findRatingSummaryCounts(isA(GenericSelector.class), isA(Set.class));
    assertTrue(actualFindRatingSummaryCountsResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findRatingSummaryCounts(EntityKind, IdSelectionOptions,
   * Set)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#findRatingSummaryCounts(EntityKind,
   * IdSelectionOptions, Set)}
   */
  @Test
  @DisplayName("Test findRatingSummaryCounts(EntityKind, IdSelectionOptions, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingService.findRatingSummaryCounts(EntityKind, IdSelectionOptions, Set)"
  })
  void testFindRatingSummaryCounts2() {
    // Arrange
    when(assessmentRatingDao.findRatingSummaryCounts(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions idSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    Set<AssessmentRatingSummaryCounts> actualFindRatingSummaryCountsResult =
        assessmentRatingService.findRatingSummaryCounts(
            EntityKind.APPLICATION, idSelectionOptions, new HashSet<>());

    // Assert
    verify(assessmentRatingDao).findRatingSummaryCounts(isA(GenericSelector.class), isA(Set.class));
    assertTrue(actualFindRatingSummaryCountsResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findRatingSummaryCounts(EntityKind, IdSelectionOptions,
   * Set)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#findRatingSummaryCounts(EntityKind,
   * IdSelectionOptions, Set)}
   */
  @Test
  @DisplayName("Test findRatingSummaryCounts(EntityKind, IdSelectionOptions, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingService.findRatingSummaryCounts(EntityKind, IdSelectionOptions, Set)"
  })
  void testFindRatingSummaryCounts3() {
    // Arrange
    when(assessmentRatingDao.findRatingSummaryCounts(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APPLICATION)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions idSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    Set<AssessmentRatingSummaryCounts> actualFindRatingSummaryCountsResult =
        assessmentRatingService.findRatingSummaryCounts(
            EntityKind.APPLICATION, idSelectionOptions, new HashSet<>());

    // Assert
    verify(assessmentRatingDao).findRatingSummaryCounts(isA(GenericSelector.class), isA(Set.class));
    assertTrue(actualFindRatingSummaryCountsResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findRatingSummaryCounts(EntityKind, IdSelectionOptions,
   * Set)}.
   *
   * <p>Method under test: {@link AssessmentRatingService#findRatingSummaryCounts(EntityKind,
   * IdSelectionOptions, Set)}
   */
  @Test
  @DisplayName("Test findRatingSummaryCounts(EntityKind, IdSelectionOptions, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingService.findRatingSummaryCounts(EntityKind, IdSelectionOptions, Set)"
  })
  void testFindRatingSummaryCounts4() {
    // Arrange
    when(assessmentRatingDao.findRatingSummaryCounts(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APP_GROUP)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions idSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    Set<AssessmentRatingSummaryCounts> actualFindRatingSummaryCountsResult =
        assessmentRatingService.findRatingSummaryCounts(
            EntityKind.APPLICATION, idSelectionOptions, new HashSet<>());

    // Assert
    verify(assessmentRatingDao).findRatingSummaryCounts(isA(GenericSelector.class), isA(Set.class));
    assertTrue(actualFindRatingSummaryCountsResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findRatingSummaryCounts(EntityKind, IdSelectionOptions,
   * Set)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#findRatingSummaryCounts(EntityKind,
   * IdSelectionOptions, Set)}
   */
  @Test
  @DisplayName("Test findRatingSummaryCounts(EntityKind, IdSelectionOptions, Set); given 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingService.findRatingSummaryCounts(EntityKind, IdSelectionOptions, Set)"
  })
  void testFindRatingSummaryCounts_givenActive() {
    // Arrange
    when(assessmentRatingDao.findRatingSummaryCounts(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions idSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    Set<AssessmentRatingSummaryCounts> actualFindRatingSummaryCountsResult =
        assessmentRatingService.findRatingSummaryCounts(
            EntityKind.APPLICATION, idSelectionOptions, new HashSet<>());

    // Assert
    verify(assessmentRatingDao).findRatingSummaryCounts(isA(GenericSelector.class), isA(Set.class));
    assertTrue(actualFindRatingSummaryCountsResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findRatingSummaryCounts(EntityKind, IdSelectionOptions,
   * Set)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#findRatingSummaryCounts(EntityKind,
   * IdSelectionOptions, Set)}
   */
  @Test
  @DisplayName(
      "Test findRatingSummaryCounts(EntityKind, IdSelectionOptions, Set); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingService.findRatingSummaryCounts(EntityKind, IdSelectionOptions, Set)"
  })
  void testFindRatingSummaryCounts_givenInHouse() {
    // Arrange
    when(assessmentRatingDao.findRatingSummaryCounts(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters filters = builderResult.build();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(filters);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions idSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    Set<AssessmentRatingSummaryCounts> actualFindRatingSummaryCountsResult =
        assessmentRatingService.findRatingSummaryCounts(
            EntityKind.APPLICATION, idSelectionOptions, new HashSet<>());

    // Assert
    verify(assessmentRatingDao).findRatingSummaryCounts(isA(GenericSelector.class), isA(Set.class));
    assertTrue(actualFindRatingSummaryCountsResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findRatingSummaryCounts(EntityKind, IdSelectionOptions,
   * Set)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#findRatingSummaryCounts(EntityKind,
   * IdSelectionOptions, Set)}
   */
  @Test
  @DisplayName(
      "Test findRatingSummaryCounts(EntityKind, IdSelectionOptions, Set); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingService.findRatingSummaryCounts(EntityKind, IdSelectionOptions, Set)"
  })
  void testFindRatingSummaryCounts_thenThrowIllegalArgumentException() {
    // Arrange
    when(assessmentRatingDao.findRatingSummaryCounts(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenThrow(new IllegalArgumentException());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions idSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            assessmentRatingService.findRatingSummaryCounts(
                EntityKind.APPLICATION, idSelectionOptions, new HashSet<>()));
    verify(assessmentRatingDao).findRatingSummaryCounts(isA(GenericSelector.class), isA(Set.class));
  }

  /**
   * Test {@link AssessmentRatingService#hasMultiValuedAssessments(long)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#hasMultiValuedAssessments(long)}
   */
  @Test
  @DisplayName("Test hasMultiValuedAssessments(long); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.hasMultiValuedAssessments(long)"})
  void testHasMultiValuedAssessments_thenReturnFalse() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.hasMultiValuedAssessments(anyLong())).thenReturn(false);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    boolean actualHasMultiValuedAssessmentsResult =
        assessmentRatingService.hasMultiValuedAssessments(1L);

    // Assert
    verify(assessmentRatingDao).hasMultiValuedAssessments(1L);
    assertFalse(actualHasMultiValuedAssessmentsResult);
  }

  /**
   * Test {@link AssessmentRatingService#hasMultiValuedAssessments(long)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#hasMultiValuedAssessments(long)}
   */
  @Test
  @DisplayName("Test hasMultiValuedAssessments(long); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.hasMultiValuedAssessments(long)"})
  void testHasMultiValuedAssessments_thenReturnTrue() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.hasMultiValuedAssessments(anyLong())).thenReturn(true);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    boolean actualHasMultiValuedAssessmentsResult =
        assessmentRatingService.hasMultiValuedAssessments(1L);

    // Assert
    verify(assessmentRatingDao).hasMultiValuedAssessments(1L);
    assertTrue(actualHasMultiValuedAssessmentsResult);
  }

  /**
   * Test {@link AssessmentRatingService#hasMultiValuedAssessments(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#hasMultiValuedAssessments(long)}
   */
  @Test
  @DisplayName("Test hasMultiValuedAssessments(long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentRatingService.hasMultiValuedAssessments(long)"})
  void testHasMultiValuedAssessments_thenThrowIllegalArgumentException() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.hasMultiValuedAssessments(anyLong()))
        .thenThrow(new IllegalArgumentException());
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        mock(AssessmentRatingPermissionChecker.class);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            assessmentRatingPermissionChecker,
            rippler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> assessmentRatingService.hasMultiValuedAssessments(1L));
    verify(assessmentRatingDao).hasMultiValuedAssessments(1L);
  }

  /**
   * Test {@link AssessmentRatingService#findBySelectorForDefinitions(GenericSelector, Set)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashSet#HashSet()} add one.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#findBySelectorForDefinitions(GenericSelector, Set)}
   */
  @Test
  @DisplayName(
      "Test findBySelectorForDefinitions(GenericSelector, Set); given one; when HashSet() add one; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingService.findBySelectorForDefinitions(GenericSelector, Set)"
  })
  void testFindBySelectorForDefinitions_givenOne_whenHashSetAddOne_thenReturnEmpty() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.addEntityInvolvement(
            Mockito.<String>any(),
            Mockito.<EntityReference>any(),
            Mockito.<EntityInvolvementChangeCommand>any()))
        .thenReturn(true);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    ImmutableEntityInvolvementChangeCommand.Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);
    involvementService.addEntityInvolvement(
        "42",
        entityReference,
        operationResult
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    AssessmentRatingDao assessmentRatingDao2 = mock(AssessmentRatingDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, mock(PermissionGroupDao.class), null);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService2, settingsService);

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        new AssessmentRatingPermissionChecker(
            assessmentRatingDao2, involvementService, permissionGroupService, userRoleService);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService2,
            assessmentRatingPermissionChecker,
            rippler);

    HashSet<Long> defIds = new HashSet<>();
    defIds.add(1L);

    // Act
    Set<AssessmentRating> actualFindBySelectorForDefinitionsResult =
        assessmentRatingService.findBySelectorForDefinitions(null, defIds);

    // Assert
    verify(assessmentRatingDao).findBySelectorForDefinitions(isNull(), isA(Set.class));
    verify(involvementService)
        .addEntityInvolvement(
            eq("42"), isA(EntityReference.class), isA(EntityInvolvementChangeCommand.class));
    assertTrue(actualFindBySelectorForDefinitionsResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findBySelectorForDefinitions(GenericSelector, Set)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link HashSet#HashSet()} add zero.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#findBySelectorForDefinitions(GenericSelector, Set)}
   */
  @Test
  @DisplayName(
      "Test findBySelectorForDefinitions(GenericSelector, Set); given zero; when HashSet() add zero; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingService.findBySelectorForDefinitions(GenericSelector, Set)"
  })
  void testFindBySelectorForDefinitions_givenZero_whenHashSetAddZero_thenReturnEmpty() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.addEntityInvolvement(
            Mockito.<String>any(),
            Mockito.<EntityReference>any(),
            Mockito.<EntityInvolvementChangeCommand>any()))
        .thenReturn(true);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    ImmutableEntityInvolvementChangeCommand.Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);
    involvementService.addEntityInvolvement(
        "42",
        entityReference,
        operationResult
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    AssessmentRatingDao assessmentRatingDao2 = mock(AssessmentRatingDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, mock(PermissionGroupDao.class), null);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService2, settingsService);

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        new AssessmentRatingPermissionChecker(
            assessmentRatingDao2, involvementService, permissionGroupService, userRoleService);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService2,
            assessmentRatingPermissionChecker,
            rippler);

    HashSet<Long> defIds = new HashSet<>();
    defIds.add(0L);
    defIds.add(1L);

    // Act
    Set<AssessmentRating> actualFindBySelectorForDefinitionsResult =
        assessmentRatingService.findBySelectorForDefinitions(null, defIds);

    // Assert
    verify(assessmentRatingDao).findBySelectorForDefinitions(isNull(), isA(Set.class));
    verify(involvementService)
        .addEntityInvolvement(
            eq("42"), isA(EntityReference.class), isA(EntityInvolvementChangeCommand.class));
    assertTrue(actualFindBySelectorForDefinitionsResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findBySelectorForDefinitions(GenericSelector, Set)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#findBySelectorForDefinitions(GenericSelector, Set)}
   */
  @Test
  @DisplayName(
      "Test findBySelectorForDefinitions(GenericSelector, Set); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingService.findBySelectorForDefinitions(GenericSelector, Set)"
  })
  void testFindBySelectorForDefinitions_thenThrowIllegalArgumentException() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenThrow(new IllegalArgumentException());

    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.addEntityInvolvement(
            Mockito.<String>any(),
            Mockito.<EntityReference>any(),
            Mockito.<EntityInvolvementChangeCommand>any()))
        .thenReturn(true);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    ImmutableEntityInvolvementChangeCommand.Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);
    involvementService.addEntityInvolvement(
        "42",
        entityReference,
        operationResult
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    AssessmentRatingDao assessmentRatingDao2 = mock(AssessmentRatingDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, mock(PermissionGroupDao.class), null);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService2, settingsService);

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        new AssessmentRatingPermissionChecker(
            assessmentRatingDao2, involvementService, permissionGroupService, userRoleService);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService2,
            assessmentRatingPermissionChecker,
            rippler);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> assessmentRatingService.findBySelectorForDefinitions(null, new HashSet<>()));
    verify(assessmentRatingDao).findBySelectorForDefinitions(isNull(), isA(Set.class));
    verify(involvementService)
        .addEntityInvolvement(
            eq("42"), isA(EntityReference.class), isA(EntityInvolvementChangeCommand.class));
  }

  /**
   * Test {@link AssessmentRatingService#findBySelectorForDefinitions(GenericSelector, Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#findBySelectorForDefinitions(GenericSelector, Set)}
   */
  @Test
  @DisplayName(
      "Test findBySelectorForDefinitions(GenericSelector, Set); when HashSet(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingService.findBySelectorForDefinitions(GenericSelector, Set)"
  })
  void testFindBySelectorForDefinitions_whenHashSet_thenReturnEmpty() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.addEntityInvolvement(
            Mockito.<String>any(),
            Mockito.<EntityReference>any(),
            Mockito.<EntityInvolvementChangeCommand>any()))
        .thenReturn(true);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    ImmutableEntityInvolvementChangeCommand.Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);
    involvementService.addEntityInvolvement(
        "42",
        entityReference,
        operationResult
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    AssessmentRatingDao assessmentRatingDao2 = mock(AssessmentRatingDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, mock(PermissionGroupDao.class), null);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService2, settingsService);

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        new AssessmentRatingPermissionChecker(
            assessmentRatingDao2, involvementService, permissionGroupService, userRoleService);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(
            new DefaultDSLContext(SQLDialect.SQL99), mock(SettingsDao.class));

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService2,
            assessmentRatingPermissionChecker,
            rippler);

    // Act
    Set<AssessmentRating> actualFindBySelectorForDefinitionsResult =
        assessmentRatingService.findBySelectorForDefinitions(null, new HashSet<>());

    // Assert
    verify(assessmentRatingDao).findBySelectorForDefinitions(isNull(), isA(Set.class));
    verify(involvementService)
        .addEntityInvolvement(
            eq("42"), isA(EntityReference.class), isA(EntityInvolvementChangeCommand.class));
    assertTrue(actualFindBySelectorForDefinitionsResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentsView AssessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions)"
  })
  void testGetPrimaryAssessmentsViewForKindAndSelector() {
    // Arrange
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    AssessmentsView actualPrimaryAssessmentsViewForKindAndSelector =
        assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualPrimaryAssessmentsViewForKindAndSelector instanceof ImmutableAssessmentsView);
    assertTrue(actualPrimaryAssessmentsViewForKindAndSelector.ratingSchemeItemsById().isEmpty());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualPrimaryAssessmentsViewForKindAndSelector.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(
        assessmentDefinitionsResult,
        actualPrimaryAssessmentsViewForKindAndSelector.assessmentRatings());
    assertSame(
        assessmentDefinitionsResult,
        actualPrimaryAssessmentsViewForKindAndSelector.ratingSchemeItems());
  }

  /**
   * Test {@link AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentsView AssessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions)"
  })
  void testGetPrimaryAssessmentsViewForKindAndSelector2() {
    // Arrange
    HashSet<AssessmentRating> assessmentRatingSet = new HashSet<>();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingSet.add(
        commentResult
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
            .provenance("Provenance")
            .ratingId(1L)
            .build());
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentRatingSet);
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    AssessmentsView actualPrimaryAssessmentsViewForKindAndSelector =
        assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualPrimaryAssessmentsViewForKindAndSelector instanceof ImmutableAssessmentsView);
    assertEquals(1, actualPrimaryAssessmentsViewForKindAndSelector.assessmentRatings().size());
    assertTrue(actualPrimaryAssessmentsViewForKindAndSelector.ratingSchemeItemsById().isEmpty());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualPrimaryAssessmentsViewForKindAndSelector.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(
        assessmentDefinitionsResult,
        actualPrimaryAssessmentsViewForKindAndSelector.ratingSchemeItems());
  }

  /**
   * Test {@link AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentsView AssessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions)"
  })
  void testGetPrimaryAssessmentsViewForKindAndSelector3() {
    // Arrange
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
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
    assessmentDefinitionSet.add(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(assessmentDefinitionSet);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    AssessmentsView actualPrimaryAssessmentsViewForKindAndSelector =
        assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualPrimaryAssessmentsViewForKindAndSelector instanceof ImmutableAssessmentsView);
    assertEquals(1, actualPrimaryAssessmentsViewForKindAndSelector.assessmentDefinitions().size());
    Set<AssessmentRating> assessmentRatingsResult =
        actualPrimaryAssessmentsViewForKindAndSelector.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(
        assessmentRatingsResult,
        actualPrimaryAssessmentsViewForKindAndSelector.ratingSchemeItems());
  }

  /**
   * Test {@link AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentsView AssessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions)"
  })
  void testGetPrimaryAssessmentsViewForKindAndSelector4() {
    // Arrange
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());

    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(ratingSchemeItemSet);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    AssessmentsView actualPrimaryAssessmentsViewForKindAndSelector =
        assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualPrimaryAssessmentsViewForKindAndSelector instanceof ImmutableAssessmentsView);
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult =
        actualPrimaryAssessmentsViewForKindAndSelector.ratingSchemeItemsById();
    assertEquals(1, ratingSchemeItemsByIdResult.size());
    RatingSchemeItem getResult = ratingSchemeItemsByIdResult.get(1L);
    assertTrue(getResult instanceof ImmutableRatingSchemeItem);
    assertEquals("Color", getResult.color());
    assertEquals("Name", getResult.name());
    assertEquals("Rating Group", getResult.ratingGroup());
    assertEquals("Rating", getResult.rating());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(0, getResult.position());
    assertEquals(1, actualPrimaryAssessmentsViewForKindAndSelector.ratingSchemeItems().size());
    assertEquals(1L, getResult.ratingSchemeId());
    assertFalse(getResult.isRestricted());
    assertFalse(getResult.requiresComment());
    assertTrue(getResult.userSelectable());
  }

  /**
   * Test {@link AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentsView AssessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions)"
  })
  void testGetPrimaryAssessmentsViewForKindAndSelector5() {
    // Arrange
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenThrow(new IllegalArgumentException());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(
                EntityKind.APPLICATION,
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
  }

  /**
   * Test {@link AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentsView AssessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions)"
  })
  void testGetPrimaryAssessmentsViewForKindAndSelector6() {
    // Arrange
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    AssessmentsView actualPrimaryAssessmentsViewForKindAndSelector =
        assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualPrimaryAssessmentsViewForKindAndSelector instanceof ImmutableAssessmentsView);
    assertTrue(actualPrimaryAssessmentsViewForKindAndSelector.ratingSchemeItemsById().isEmpty());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualPrimaryAssessmentsViewForKindAndSelector.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(
        assessmentDefinitionsResult,
        actualPrimaryAssessmentsViewForKindAndSelector.assessmentRatings());
    assertSame(
        assessmentDefinitionsResult,
        actualPrimaryAssessmentsViewForKindAndSelector.ratingSchemeItems());
  }

  /**
   * Test {@link AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentsView AssessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions)"
  })
  void testGetPrimaryAssessmentsViewForKindAndSelector7() {
    // Arrange
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APPLICATION)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    AssessmentsView actualPrimaryAssessmentsViewForKindAndSelector =
        assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualPrimaryAssessmentsViewForKindAndSelector instanceof ImmutableAssessmentsView);
    assertTrue(actualPrimaryAssessmentsViewForKindAndSelector.ratingSchemeItemsById().isEmpty());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualPrimaryAssessmentsViewForKindAndSelector.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(
        assessmentDefinitionsResult,
        actualPrimaryAssessmentsViewForKindAndSelector.assessmentRatings());
    assertSame(
        assessmentDefinitionsResult,
        actualPrimaryAssessmentsViewForKindAndSelector.ratingSchemeItems());
  }

  /**
   * Test {@link AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentsView AssessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions)"
  })
  void testGetPrimaryAssessmentsViewForKindAndSelector8() {
    // Arrange
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APP_GROUP)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    AssessmentsView actualPrimaryAssessmentsViewForKindAndSelector =
        assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualPrimaryAssessmentsViewForKindAndSelector instanceof ImmutableAssessmentsView);
    assertTrue(actualPrimaryAssessmentsViewForKindAndSelector.ratingSchemeItemsById().isEmpty());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualPrimaryAssessmentsViewForKindAndSelector.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(
        assessmentDefinitionsResult,
        actualPrimaryAssessmentsViewForKindAndSelector.assessmentRatings());
    assertSame(
        assessmentDefinitionsResult,
        actualPrimaryAssessmentsViewForKindAndSelector.ratingSchemeItems());
  }

  /**
   * Test {@link AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions); given 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentsView AssessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions)"
  })
  void testGetPrimaryAssessmentsViewForKindAndSelector_givenActive() {
    // Arrange
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    AssessmentsView actualPrimaryAssessmentsViewForKindAndSelector =
        assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualPrimaryAssessmentsViewForKindAndSelector instanceof ImmutableAssessmentsView);
    assertTrue(actualPrimaryAssessmentsViewForKindAndSelector.ratingSchemeItemsById().isEmpty());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualPrimaryAssessmentsViewForKindAndSelector.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(
        assessmentDefinitionsResult,
        actualPrimaryAssessmentsViewForKindAndSelector.assessmentRatings());
    assertSame(
        assessmentDefinitionsResult,
        actualPrimaryAssessmentsViewForKindAndSelector.ratingSchemeItems());
  }

  /**
   * Test {@link AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link AssessmentRatingDao}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions); given AssessmentRatingDao")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentsView AssessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions)"
  })
  void testGetPrimaryAssessmentsViewForKindAndSelector_givenAssessmentRatingDao() {
    // Arrange
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenThrow(new IllegalArgumentException());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(
                EntityKind.APPLICATION,
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(Optional.class));
  }

  /**
   * Test {@link AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentsView AssessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions)"
  })
  void testGetPrimaryAssessmentsViewForKindAndSelector_givenInHouse() {
    // Arrange
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters filters = builderResult.build();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(filters);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    AssessmentsView actualPrimaryAssessmentsViewForKindAndSelector =
        assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualPrimaryAssessmentsViewForKindAndSelector instanceof ImmutableAssessmentsView);
    assertTrue(actualPrimaryAssessmentsViewForKindAndSelector.ratingSchemeItemsById().isEmpty());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualPrimaryAssessmentsViewForKindAndSelector.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(
        assessmentDefinitionsResult,
        actualPrimaryAssessmentsViewForKindAndSelector.assessmentRatings());
    assertSame(
        assessmentDefinitionsResult,
        actualPrimaryAssessmentsViewForKindAndSelector.ratingSchemeItems());
  }

  /**
   * Test {@link AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_INITIATIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions); when 'CHANGE_INITIATIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentsView AssessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions)"
  })
  void testGetPrimaryAssessmentsViewForKindAndSelector_whenChangeInitiative() {
    // Arrange
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    AssessmentsView actualPrimaryAssessmentsViewForKindAndSelector =
        assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(
            EntityKind.CHANGE_INITIATIVE,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualPrimaryAssessmentsViewForKindAndSelector instanceof ImmutableAssessmentsView);
    assertTrue(actualPrimaryAssessmentsViewForKindAndSelector.ratingSchemeItemsById().isEmpty());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualPrimaryAssessmentsViewForKindAndSelector.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(
        assessmentDefinitionsResult,
        actualPrimaryAssessmentsViewForKindAndSelector.assessmentRatings());
    assertSame(
        assessmentDefinitionsResult,
        actualPrimaryAssessmentsViewForKindAndSelector.ratingSchemeItems());
  }

  /**
   * Test {@link AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_UNIT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions); when 'CHANGE_UNIT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentsView AssessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions)"
  })
  void testGetPrimaryAssessmentsViewForKindAndSelector_whenChangeUnit() {
    // Arrange
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    AssessmentsView actualPrimaryAssessmentsViewForKindAndSelector =
        assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(
            EntityKind.CHANGE_UNIT,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualPrimaryAssessmentsViewForKindAndSelector instanceof ImmutableAssessmentsView);
    assertTrue(actualPrimaryAssessmentsViewForKindAndSelector.ratingSchemeItemsById().isEmpty());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualPrimaryAssessmentsViewForKindAndSelector.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(
        assessmentDefinitionsResult,
        actualPrimaryAssessmentsViewForKindAndSelector.assessmentRatings());
    assertSame(
        assessmentDefinitionsResult,
        actualPrimaryAssessmentsViewForKindAndSelector.ratingSchemeItems());
  }

  /**
   * Test {@link AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code LICENCE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions); when 'LICENCE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentsView AssessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions)"
  })
  void testGetPrimaryAssessmentsViewForKindAndSelector_whenLicence() {
    // Arrange
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    AssessmentsView actualPrimaryAssessmentsViewForKindAndSelector =
        assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(
            EntityKind.LICENCE,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualPrimaryAssessmentsViewForKindAndSelector instanceof ImmutableAssessmentsView);
    assertTrue(actualPrimaryAssessmentsViewForKindAndSelector.ratingSchemeItemsById().isEmpty());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualPrimaryAssessmentsViewForKindAndSelector.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(
        assessmentDefinitionsResult,
        actualPrimaryAssessmentsViewForKindAndSelector.assessmentRatings());
    assertSame(
        assessmentDefinitionsResult,
        actualPrimaryAssessmentsViewForKindAndSelector.ratingSchemeItems());
  }

  /**
   * Test {@link AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code LOGICAL_DATA_FLOW}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingService#getPrimaryAssessmentsViewForKindAndSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions); when 'LOGICAL_DATA_FLOW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentsView AssessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(EntityKind, IdSelectionOptions)"
  })
  void testGetPrimaryAssessmentsViewForKindAndSelector_whenLogicalDataFlow() {
    // Arrange
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    AssessmentsView actualPrimaryAssessmentsViewForKindAndSelector =
        assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(
            EntityKind.LOGICAL_DATA_FLOW,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    assertTrue(actualPrimaryAssessmentsViewForKindAndSelector instanceof ImmutableAssessmentsView);
    assertTrue(actualPrimaryAssessmentsViewForKindAndSelector.ratingSchemeItemsById().isEmpty());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualPrimaryAssessmentsViewForKindAndSelector.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(
        assessmentDefinitionsResult,
        actualPrimaryAssessmentsViewForKindAndSelector.assessmentRatings());
    assertSame(
        assessmentDefinitionsResult,
        actualPrimaryAssessmentsViewForKindAndSelector.ratingSchemeItems());
  }

  /**
   * Test {@link AssessmentRatingService#rippleAll()}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#setAutoCommit(boolean)} does nothing.
   *   <li>Then return longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#rippleAll()}
   */
  @Test
  @DisplayName(
      "Test rippleAll(); given Connection setAutoCommit(boolean) does nothing; then return longValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AssessmentRatingService.rippleAll()"})
  void testRippleAll_givenConnectionSetAutoCommitDoesNothing_thenReturnLongValueIsZero()
      throws SQLException {
    // Arrange
    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).commit();
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());

    AssessmentRatingRippler rippler = new AssessmentRatingRippler(dsl, settingsDao);
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            mock(AssessmentRatingPermissionChecker.class),
            rippler);

    // Act
    Long actualRippleAllResult = assessmentRatingService.rippleAll();

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    assertEquals(0L, actualRippleAllResult.longValue());
  }

  /**
   * Test {@link AssessmentRatingService#rippleAll()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code job.RIPPLE_ASSESSMENTS.} is {@code
   *       job.RIPPLE_ASSESSMENTS.}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#rippleAll()}
   */
  @Test
  @DisplayName(
      "Test rippleAll(); given HashMap() 'job.RIPPLE_ASSESSMENTS.' is 'job.RIPPLE_ASSESSMENTS.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AssessmentRatingService.rippleAll()"})
  void testRippleAll_givenHashMapJobRippleAssessmentsIsJobRippleAssessments() throws SQLException {
    // Arrange
    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).commit();
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("job.RIPPLE_ASSESSMENTS.", "job.RIPPLE_ASSESSMENTS.");

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);

    AssessmentRatingRippler rippler = new AssessmentRatingRippler(dsl, settingsDao);
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            mock(AssessmentRatingPermissionChecker.class),
            rippler);

    // Act
    Long actualRippleAllResult = assessmentRatingService.rippleAll();

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    assertEquals(0L, actualRippleAllResult.longValue());
  }

  /**
   * Test {@link AssessmentRatingService#rippleAll()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#rippleAll()}
   */
  @Test
  @DisplayName("Test rippleAll(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AssessmentRatingService.rippleAll()"})
  void testRippleAll_thenThrowIllegalArgumentException() {
    // Arrange
    when(assessmentRatingRippler.findRippleConfig()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> assessmentRatingService.rippleAll());
    verify(assessmentRatingRippler).findRippleConfig();
  }

  /**
   * Test {@link AssessmentRatingService#findRippleConfig()}.
   *
   * <p>Method under test: {@link AssessmentRatingService#findRippleConfig()}
   */
  @Test
  @DisplayName("Test findRippleConfig()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingService.findRippleConfig()"})
  void testFindRippleConfig() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.putIfAbsent("job.RIPPLE_ASSESSMENTS.", "job.RIPPLE_ASSESSMENTS.");

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), settingsDao);
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            mock(AssessmentRatingPermissionChecker.class),
            rippler);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult =
        assessmentRatingService.findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findRippleConfig()}.
   *
   * <p>Method under test: {@link AssessmentRatingService#findRippleConfig()}
   */
  @Test
  @DisplayName("Test findRippleConfig()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingService.findRippleConfig()"})
  void testFindRippleConfig2() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("^job.RIPPLE_ASSESSMENTS.", "^job.RIPPLE_ASSESSMENTS.");
    stringStringMap.putIfAbsent("job.RIPPLE_ASSESSMENTS.", "job.RIPPLE_ASSESSMENTS.");

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), settingsDao);
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            mock(AssessmentRatingPermissionChecker.class),
            rippler);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult =
        assessmentRatingService.findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findRippleConfig()}.
   *
   * <ul>
   *   <li>Given {@link AssessmentRatingDao}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#findRippleConfig()}
   */
  @Test
  @DisplayName(
      "Test findRippleConfig(); given AssessmentRatingDao; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingService.findRippleConfig()"})
  void testFindRippleConfig_givenAssessmentRatingDao_thenThrowIllegalArgumentException() {
    // Arrange
    when(assessmentRatingRippler.findRippleConfig()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> assessmentRatingService.findRippleConfig());
    verify(assessmentRatingRippler).findRippleConfig();
  }

  /**
   * Test {@link AssessmentRatingService#findRippleConfig()}.
   *
   * <ul>
   *   <li>Given {@link AssessmentRatingRippler} {@link AssessmentRatingRippler#findRippleConfig()}
   *       return {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#findRippleConfig()}
   */
  @Test
  @DisplayName(
      "Test findRippleConfig(); given AssessmentRatingRippler findRippleConfig() return HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingService.findRippleConfig()"})
  void testFindRippleConfig_givenAssessmentRatingRipplerFindRippleConfigReturnHashSet() {
    // Arrange
    AssessmentRatingRippler rippler = mock(AssessmentRatingRippler.class);
    when(rippler.findRippleConfig()).thenReturn(new HashSet<>());
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            mock(AssessmentRatingPermissionChecker.class),
            rippler);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult =
        assessmentRatingService.findRippleConfig();

    // Assert
    verify(rippler).findRippleConfig();
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findRippleConfig()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} IfAbsent {@code job.RIPPLE_ASSESSMENTS.} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#findRippleConfig()}
   */
  @Test
  @DisplayName(
      "Test findRippleConfig(); given HashMap() IfAbsent 'job.RIPPLE_ASSESSMENTS.' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingService.findRippleConfig()"})
  void testFindRippleConfig_givenHashMapIfAbsentJobRippleAssessmentsIs42() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("^job.RIPPLE_ASSESSMENTS.", "^job.RIPPLE_ASSESSMENTS.");
    stringStringMap.putIfAbsent("job.RIPPLE_ASSESSMENTS.", "42");

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), settingsDao);
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            mock(AssessmentRatingPermissionChecker.class),
            rippler);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult =
        assessmentRatingService.findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findRippleConfig()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} IfAbsent {@code job.RIPPLE_ASSESSMENTS.} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#findRippleConfig()}
   */
  @Test
  @DisplayName(
      "Test findRippleConfig(); given HashMap() IfAbsent 'job.RIPPLE_ASSESSMENTS.' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingService.findRippleConfig()"})
  void testFindRippleConfig_givenHashMapIfAbsentJobRippleAssessmentsIs422() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("^job.RIPPLE_ASSESSMENTS.", "^job.RIPPLE_ASSESSMENTS.");
    stringStringMap.put("^job.RIPPLE_ASSESSMENTS.", "^job.RIPPLE_ASSESSMENTS.");
    stringStringMap.putIfAbsent("job.RIPPLE_ASSESSMENTS.", "42");

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), settingsDao);
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            mock(AssessmentRatingPermissionChecker.class),
            rippler);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult =
        assessmentRatingService.findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findRippleConfig()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} IfAbsent {@code job.RIPPLE_ASSESSMENTS.} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#findRippleConfig()}
   */
  @Test
  @DisplayName(
      "Test findRippleConfig(); given HashMap() IfAbsent 'job.RIPPLE_ASSESSMENTS.' is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingService.findRippleConfig()"})
  void testFindRippleConfig_givenHashMapIfAbsentJobRippleAssessmentsIsEmptyString() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("^job.RIPPLE_ASSESSMENTS.", "^job.RIPPLE_ASSESSMENTS.");
    stringStringMap.putIfAbsent("job.RIPPLE_ASSESSMENTS.", "");

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), settingsDao);
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            mock(AssessmentRatingPermissionChecker.class),
            rippler);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult =
        assessmentRatingService.findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findRippleConfig()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code job.RIPPLE_ASSESSMENTS.} is {@code
   *       job.RIPPLE_ASSESSMENTS.}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#findRippleConfig()}
   */
  @Test
  @DisplayName(
      "Test findRippleConfig(); given HashMap() 'job.RIPPLE_ASSESSMENTS.' is 'job.RIPPLE_ASSESSMENTS.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingService.findRippleConfig()"})
  void testFindRippleConfig_givenHashMapJobRippleAssessmentsIsJobRippleAssessments() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("job.RIPPLE_ASSESSMENTS.", "job.RIPPLE_ASSESSMENTS.");

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), settingsDao);
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            mock(AssessmentRatingPermissionChecker.class),
            rippler);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult =
        assessmentRatingService.findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findRippleConfig()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code jobxRIPPLE_ASSESSMENTSx} is {@code
   *       jobxRIPPLE_ASSESSMENTSx}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#findRippleConfig()}
   */
  @Test
  @DisplayName(
      "Test findRippleConfig(); given HashMap() 'jobxRIPPLE_ASSESSMENTSx' is 'jobxRIPPLE_ASSESSMENTSx'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingService.findRippleConfig()"})
  void testFindRippleConfig_givenHashMapJobxRIPPLEASSESSMENTSxIsJobxRIPPLEASSESSMENTSx() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("jobxRIPPLE_ASSESSMENTSx", "jobxRIPPLE_ASSESSMENTSx");
    stringStringMap.put("^job.RIPPLE_ASSESSMENTS.", "^job.RIPPLE_ASSESSMENTS.");
    stringStringMap.putIfAbsent("job.RIPPLE_ASSESSMENTS.", "job.RIPPLE_ASSESSMENTS.");

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), settingsDao);
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            mock(AssessmentRatingPermissionChecker.class),
            rippler);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult =
        assessmentRatingService.findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingService#findRippleConfig()}.
   *
   * <ul>
   *   <li>Then calls {@link SettingsDao#indexByPrefix(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingService#findRippleConfig()}
   */
  @Test
  @DisplayName("Test findRippleConfig(); then calls indexByPrefix(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingService.findRippleConfig()"})
  void testFindRippleConfig_thenCallsIndexByPrefix() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());
    AssessmentRatingRippler rippler =
        new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), settingsDao);
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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

    AssessmentRatingService assessmentRatingService =
        new AssessmentRatingService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            mock(AssessmentRatingPermissionChecker.class),
            rippler);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult =
        assessmentRatingService.findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }
}
