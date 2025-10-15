package org.finos.waltz.service.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
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
import org.finos.waltz.data.assessment_definition.AssessmentDefinitionDao;
import org.finos.waltz.data.assessment_rating.AssessmentRatingDao;
import org.finos.waltz.data.assessment_rating.AssessmentRatingRippler;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.legal_entity.LegalEntityRelationshipDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable.MeasurableDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.person.search.PersonSearchDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.rating_scheme.RatingSchemeDAO;
import org.finos.waltz.data.role.RoleDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.data.user.UserPreferenceDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition.Builder;
import org.finos.waltz.model.assessment_rating.bulk_upload.AssessmentRatingParsedResult;
import org.finos.waltz.model.assessment_rating.bulk_upload.AssessmentRatingParsedResult.AssessmentRatingParseError;
import org.finos.waltz.model.assessment_rating.bulk_upload.AssessmentRatingValidationResult;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmentRatingParseError;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmentRatingValidationResult;
import org.finos.waltz.model.exceptions.NotAuthorizedException;
import org.finos.waltz.service.assessment_definition.AssessmentDefinitionService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.permission.permission_checker.AssessmentRatingPermissionChecker;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record3;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.TableLike;
import org.jooq.exception.DataAccessException;
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
class BulkAssessmentRatingServiceDiffblueTest {
  @Mock private AssessmentDefinitionService assessmentDefinitionService;

  @InjectMocks private BulkAssessmentRatingService bulkAssessmentRatingService;

  @Mock private DSLContext dSLContext;

  @Mock private RatingSchemeService ratingSchemeService;

  @Mock private UserRoleService userRoleService;

  /**
   * Test {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}.
   *
   * <p>Method under test: {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}
   */
  @Test
  @DisplayName("Test bulkPreview(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingValidationResult BulkAssessmentRatingService.bulkPreview(EntityReference, String)"
  })
  void testBulkPreview() {
    // Arrange
    when(assessmentDefinitionService.getById(anyLong())).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkAssessmentRatingService.bulkPreview(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                "Input Str"));
    verify(assessmentDefinitionService).getById(1L);
  }

  /**
   * Test {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}.
   *
   * <p>Method under test: {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}
   */
  @Test
  @DisplayName("Test bulkPreview(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingValidationResult BulkAssessmentRatingService.bulkPreview(EntityReference, String)"
  })
  void testBulkPreview2() {
    // Arrange
    Builder provenanceResult =
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
    when(assessmentDefinitionService.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());
    when(ratingSchemeService.findRatingSchemeItemsBySchemeIds(Mockito.<Set<Long>>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkAssessmentRatingService.bulkPreview(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                "Input Str"));
    verify(assessmentDefinitionService).getById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsBySchemeIds(isA(Set.class));
  }

  /**
   * Test {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}.
   *
   * <p>Method under test: {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}
   */
  @Test
  @DisplayName("Test bulkPreview(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingValidationResult BulkAssessmentRatingService.bulkPreview(EntityReference, String)"
  })
  void testBulkPreview3() {
    // Arrange and Act
    AssessmentRatingValidationResult actualBulkPreviewResult =
        bulkAssessmentRatingService.bulkPreview(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "#");

    // Assert
    AssessmentRatingParseError errorResult = actualBulkPreviewResult.error();
    assertTrue(errorResult instanceof ImmutableAssessmentRatingParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableAssessmentRatingValidationResult);
    assertEquals(
        "Empty header line: can not bind data\n at [Source: (StringReader); line: UNKNOWN, column: UNKNOWN]",
        errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertEquals(0, actualBulkPreviewResult.removalCount());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
    assertTrue(actualBulkPreviewResult.removals().isEmpty());
  }

  /**
   * Test {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}.
   *
   * <p>Method under test: {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}
   */
  @Test
  @DisplayName("Test bulkPreview(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingValidationResult BulkAssessmentRatingService.bulkPreview(EntityReference, String)"
  })
  void testBulkPreview4() throws DataAccessException {
    // Arrange
    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALLOCATION_SCHEME)
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
    when(assessmentDefinitionService.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());
    when(ratingSchemeService.findRatingSchemeItemsBySchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetch()).thenThrow(new IllegalStateException());

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkAssessmentRatingService.bulkPreview(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                "Input Str"));
    verify(assessmentDefinitionService).getById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsBySchemeIds(isA(Set.class));
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetch();
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}.
   *
   * <p>Method under test: {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}
   */
  @Test
  @DisplayName("Test bulkPreview(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingValidationResult BulkAssessmentRatingService.bulkPreview(EntityReference, String)"
  })
  void testBulkPreview5() throws DataAccessException {
    // Arrange
    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.APPLICATION)
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
    when(assessmentDefinitionService.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());
    when(ratingSchemeService.findRatingSchemeItemsBySchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetch()).thenThrow(new IllegalStateException());

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkAssessmentRatingService.bulkPreview(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                "Input Str"));
    verify(assessmentDefinitionService).getById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsBySchemeIds(isA(Set.class));
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetch();
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}.
   *
   * <p>Method under test: {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}
   */
  @Test
  @DisplayName("Test bulkPreview(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingValidationResult BulkAssessmentRatingService.bulkPreview(EntityReference, String)"
  })
  void testBulkPreview6() throws DataAccessException {
    // Arrange
    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.APP_GROUP)
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
    when(assessmentDefinitionService.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());
    when(ratingSchemeService.findRatingSchemeItemsBySchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetch()).thenThrow(new IllegalStateException());

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkAssessmentRatingService.bulkPreview(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                "Input Str"));
    verify(assessmentDefinitionService).getById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsBySchemeIds(isA(Set.class));
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetch();
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}.
   *
   * <p>Method under test: {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}
   */
  @Test
  @DisplayName("Test bulkPreview(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingValidationResult BulkAssessmentRatingService.bulkPreview(EntityReference, String)"
  })
  void testBulkPreview7() throws DataAccessException {
    // Arrange
    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ASSESSMENT_DEFINITION)
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
    when(assessmentDefinitionService.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());
    when(ratingSchemeService.findRatingSchemeItemsBySchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetch()).thenThrow(new IllegalStateException());

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkAssessmentRatingService.bulkPreview(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                "Input Str"));
    verify(assessmentDefinitionService).getById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsBySchemeIds(isA(Set.class));
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetch();
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectField, SelectField, SelectField)}
   *       throw {@link IllegalStateException#IllegalStateException()}.
   *   <li>Then calls {@link DSLContext#select(SelectField, SelectField, SelectField)}.
   * </ul>
   *
   * <p>Method under test: {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test bulkPreview(EntityReference, String); given DSLContext select(SelectField, SelectField, SelectField) throw IllegalStateException(); then calls select(SelectField, SelectField, SelectField)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingValidationResult BulkAssessmentRatingService.bulkPreview(EntityReference, String)"
  })
  void testBulkPreview_givenDSLContextSelectThrowIllegalStateException_thenCallsSelect() {
    // Arrange
    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ACTOR)
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
    when(assessmentDefinitionService.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());
    when(ratingSchemeService.findRatingSchemeItemsBySchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkAssessmentRatingService.bulkPreview(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                "Input Str"));
    verify(assessmentDefinitionService).getById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsBySchemeIds(isA(Set.class));
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
  }

  /**
   * Test {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#where(Condition)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test bulkPreview(EntityReference, String); given SelectJoinStep where(Condition) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingValidationResult BulkAssessmentRatingService.bulkPreview(EntityReference, String)"
  })
  void testBulkPreview_givenSelectJoinStepWhereThrowIllegalStateException() {
    // Arrange
    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ACTOR)
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
    when(assessmentDefinitionService.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());
    when(ratingSchemeService.findRatingSchemeItemsBySchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenThrow(new IllegalStateException());

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkAssessmentRatingService.bulkPreview(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                "Input Str"));
    verify(assessmentDefinitionService).getById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsBySchemeIds(isA(Set.class));
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#from(TableLike)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test bulkPreview(EntityReference, String); given SelectSelectStep from(TableLike) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingValidationResult BulkAssessmentRatingService.bulkPreview(EntityReference, String)"
  })
  void testBulkPreview_givenSelectSelectStepFromThrowIllegalStateException() {
    // Arrange
    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ACTOR)
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
    when(assessmentDefinitionService.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());
    when(ratingSchemeService.findRatingSchemeItemsBySchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenThrow(new IllegalStateException());
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkAssessmentRatingService.bulkPreview(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                "Input Str"));
    verify(assessmentDefinitionService).getById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsBySchemeIds(isA(Set.class));
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}.
   *
   * <ul>
   *   <li>Then calls {@link SelectConditionStep#fetch()}.
   * </ul>
   *
   * <p>Method under test: {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}
   */
  @Test
  @DisplayName("Test bulkPreview(EntityReference, String); then calls fetch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingValidationResult BulkAssessmentRatingService.bulkPreview(EntityReference, String)"
  })
  void testBulkPreview_thenCallsFetch() throws DataAccessException {
    // Arrange
    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ACTOR)
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
    when(assessmentDefinitionService.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());
    when(ratingSchemeService.findRatingSchemeItemsBySchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetch()).thenThrow(new IllegalStateException());

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkAssessmentRatingService.bulkPreview(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                "Input Str"));
    verify(assessmentDefinitionService).getById(1L);
    verify(ratingSchemeService).findRatingSchemeItemsBySchemeIds(isA(Set.class));
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetch();
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}.
   *
   * <ul>
   *   <li>Then return error message is a string.
   * </ul>
   *
   * <p>Method under test: {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}
   */
  @Test
  @DisplayName("Test bulkPreview(EntityReference, String); then return error message is a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingValidationResult BulkAssessmentRatingService.bulkPreview(EntityReference, String)"
  })
  void testBulkPreview_thenReturnErrorMessageIsAString() {
    // Arrange and Act
    AssessmentRatingValidationResult actualBulkPreviewResult =
        bulkAssessmentRatingService.bulkPreview(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "(\n|\r|\r\n)");

    // Assert
    AssessmentRatingParseError errorResult = actualBulkPreviewResult.error();
    assertTrue(errorResult instanceof ImmutableAssessmentRatingParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableAssessmentRatingValidationResult);
    assertEquals(
        "Cannot construct instance of `org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmen"
            + "tRatingParsedItem`, problem: Cannot build AssessmentRatingParsedItem, some of required attributes are"
            + " not set [externalId, ratingCode]\n"
            + " at [Source: (StringReader); line: 2, column: 1]",
        errorResult.message());
    assertNull(errorResult.column());
    assertNull(errorResult.line());
    assertEquals(0, actualBulkPreviewResult.removalCount());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
    assertTrue(actualBulkPreviewResult.removals().isEmpty());
  }

  /**
   * Test {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}.
   *
   * <ul>
   *   <li>When lf.
   *   <li>Then return error message is {@code Cannot parse an empty string}.
   * </ul>
   *
   * <p>Method under test: {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test bulkPreview(EntityReference, String); when lf; then return error message is 'Cannot parse an empty string'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingValidationResult BulkAssessmentRatingService.bulkPreview(EntityReference, String)"
  })
  void testBulkPreview_whenLf_thenReturnErrorMessageIsCannotParseAnEmptyString() {
    // Arrange and Act
    AssessmentRatingValidationResult actualBulkPreviewResult =
        bulkAssessmentRatingService.bulkPreview(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "\n");

    // Assert
    AssessmentRatingParseError errorResult = actualBulkPreviewResult.error();
    assertTrue(errorResult instanceof ImmutableAssessmentRatingParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableAssessmentRatingValidationResult);
    assertEquals("Cannot parse an empty string", errorResult.message());
    assertEquals(0, errorResult.column().intValue());
    assertEquals(0, errorResult.line().intValue());
    assertEquals(0, actualBulkPreviewResult.removalCount());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
    assertTrue(actualBulkPreviewResult.removals().isEmpty());
  }

  /**
   * Test {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return error message is {@code Cannot parse an empty string}.
   * </ul>
   *
   * <p>Method under test: {@link BulkAssessmentRatingService#bulkPreview(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test bulkPreview(EntityReference, String); when 'null'; then return error message is 'Cannot parse an empty string'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingValidationResult BulkAssessmentRatingService.bulkPreview(EntityReference, String)"
  })
  void testBulkPreview_whenNull_thenReturnErrorMessageIsCannotParseAnEmptyString() {
    // Arrange and Act
    AssessmentRatingValidationResult actualBulkPreviewResult =
        bulkAssessmentRatingService.bulkPreview(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            null);

    // Assert
    AssessmentRatingParseError errorResult = actualBulkPreviewResult.error();
    assertTrue(errorResult instanceof ImmutableAssessmentRatingParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableAssessmentRatingValidationResult);
    assertEquals("Cannot parse an empty string", errorResult.message());
    assertEquals(0, errorResult.column().intValue());
    assertEquals(0, errorResult.line().intValue());
    assertEquals(0, actualBulkPreviewResult.removalCount());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
    assertTrue(actualBulkPreviewResult.removals().isEmpty());
  }

  /**
   * Test {@link BulkAssessmentRatingService#apply(EntityReference,
   * AssessmentRatingValidationResult, String)}.
   *
   * <p>Method under test: {@link BulkAssessmentRatingService#apply(EntityReference,
   * AssessmentRatingValidationResult, String)}
   */
  @Test
  @DisplayName("Test apply(EntityReference, AssessmentRatingValidationResult, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.assessment_rating.bulk_upload.BulkAssessmentRatingApplyResult BulkAssessmentRatingService.apply(EntityReference, AssessmentRatingValidationResult, String)"
  })
  void testApply() {
    // Arrange
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    ImmutableEntityReference assessmentRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    ImmutableAssessmentRatingValidationResult.Builder builderResult =
        ImmutableAssessmentRatingValidationResult.builder();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkAssessmentRatingService.apply(
                assessmentRef,
                builderResult
                    .error(
                        ImmutableAssessmentRatingParseError.builder()
                            .column(1)
                            .line(2)
                            .message("Not all who wander are lost")
                            .build())
                    .build(),
                "42"));
    verify(userRoleService).hasRole(eq("42"), (String[]) Mockito.any());
  }

  /**
   * Test {@link BulkAssessmentRatingService#apply(EntityReference,
   * AssessmentRatingValidationResult, String)}.
   *
   * <ul>
   *   <li>Given builder column one line two message {@code Not all who wander are lost} build.
   * </ul>
   *
   * <p>Method under test: {@link BulkAssessmentRatingService#apply(EntityReference,
   * AssessmentRatingValidationResult, String)}
   */
  @Test
  @DisplayName(
      "Test apply(EntityReference, AssessmentRatingValidationResult, String); given builder column one line two message 'Not all who wander are lost' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.assessment_rating.bulk_upload.BulkAssessmentRatingApplyResult BulkAssessmentRatingService.apply(EntityReference, AssessmentRatingValidationResult, String)"
  })
  void testApply_givenBuilderColumnOneLineTwoMessageNotAllWhoWanderAreLostBuild() {
    // Arrange
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);

    AssessmentRatingValidationResult preview = mock(AssessmentRatingValidationResult.class);
    when(preview.error())
        .thenReturn(
            ImmutableAssessmentRatingParseError.builder()
                .column(1)
                .line(2)
                .message("Not all who wander are lost")
                .build());

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> bulkAssessmentRatingService.apply(null, preview, "42"));
    verify(preview).error();
    verify(userRoleService).hasRole(eq("42"), (String[]) Mockito.any());
  }

  /**
   * Test {@link BulkAssessmentRatingService#apply(EntityReference,
   * AssessmentRatingValidationResult, String)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BulkAssessmentRatingService#apply(EntityReference,
   * AssessmentRatingValidationResult, String)}
   */
  @Test
  @DisplayName(
      "Test apply(EntityReference, AssessmentRatingValidationResult, String); given IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.assessment_rating.bulk_upload.BulkAssessmentRatingApplyResult BulkAssessmentRatingService.apply(EntityReference, AssessmentRatingValidationResult, String)"
  })
  void testApply_givenIllegalStateException() {
    // Arrange
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);

    AssessmentRatingValidationResult preview = mock(AssessmentRatingValidationResult.class);
    when(preview.error()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> bulkAssessmentRatingService.apply(null, preview, "42"));
    verify(preview).error();
    verify(userRoleService).hasRole(eq("42"), (String[]) Mockito.any());
  }

  /**
   * Test {@link BulkAssessmentRatingService#apply(EntityReference,
   * AssessmentRatingValidationResult, String)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleDao} {@link UserRoleDao#getUserRoles(String)} return {@link
   *       HashSet#HashSet()}.
   *   <li>Then calls {@link UserRoleDao#getUserRoles(String)}.
   * </ul>
   *
   * <p>Method under test: {@link BulkAssessmentRatingService#apply(EntityReference,
   * AssessmentRatingValidationResult, String)}
   */
  @Test
  @DisplayName(
      "Test apply(EntityReference, AssessmentRatingValidationResult, String); given UserRoleDao getUserRoles(String) return HashSet(); then calls getUserRoles(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.assessment_rating.bulk_upload.BulkAssessmentRatingApplyResult BulkAssessmentRatingService.apply(EntityReference, AssessmentRatingValidationResult, String)"
  })
  void testApply_givenUserRoleDaoGetUserRolesReturnHashSet_thenCallsGetUserRoles() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            mock(AssessmentDefinitionDao.class),
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            mock(UserPreferenceDao.class));
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
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
            changeLogService2,
            assessmentRatingPermissionChecker,
            rippler);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));

    BulkAssessmentRatingService bulkAssessmentRatingService =
        new BulkAssessmentRatingService(
            assessmentDefinitionService,
            assessmentRatingService,
            ratingSchemeService,
            userRoleService,
            new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class,
        () ->
            bulkAssessmentRatingService.apply(
                null, mock(AssessmentRatingValidationResult.class), "42"));
    verify(userRoleDao).getUserRoles("42");
  }

  /**
   * Test {@link BulkAssessmentRatingService#apply(EntityReference,
   * AssessmentRatingValidationResult, String)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleService} {@link UserRoleService#hasRole(String, String[])} return
   *       {@code false}.
   *   <li>Then throw {@link NotAuthorizedException}.
   * </ul>
   *
   * <p>Method under test: {@link BulkAssessmentRatingService#apply(EntityReference,
   * AssessmentRatingValidationResult, String)}
   */
  @Test
  @DisplayName(
      "Test apply(EntityReference, AssessmentRatingValidationResult, String); given UserRoleService hasRole(String, String[]) return 'false'; then throw NotAuthorizedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.assessment_rating.bulk_upload.BulkAssessmentRatingApplyResult BulkAssessmentRatingService.apply(EntityReference, AssessmentRatingValidationResult, String)"
  })
  void testApply_givenUserRoleServiceHasRoleReturnFalse_thenThrowNotAuthorizedException() {
    // Arrange
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any()))
        .thenReturn(false);

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class,
        () ->
            bulkAssessmentRatingService.apply(
                null, mock(AssessmentRatingValidationResult.class), "42"));
    verify(userRoleService).hasRole(eq("42"), (String[]) Mockito.any());
  }

  /**
   * Test {@link BulkAssessmentRatingService#apply(EntityReference,
   * AssessmentRatingValidationResult, String)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleService} {@link UserRoleService#hasRole(String, String[])} throw
   *       {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BulkAssessmentRatingService#apply(EntityReference,
   * AssessmentRatingValidationResult, String)}
   */
  @Test
  @DisplayName(
      "Test apply(EntityReference, AssessmentRatingValidationResult, String); given UserRoleService hasRole(String, String[]) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.assessment_rating.bulk_upload.BulkAssessmentRatingApplyResult BulkAssessmentRatingService.apply(EntityReference, AssessmentRatingValidationResult, String)"
  })
  void testApply_givenUserRoleServiceHasRoleThrowIllegalStateException() {
    // Arrange
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkAssessmentRatingService.apply(
                null, mock(AssessmentRatingValidationResult.class), "42"));
    verify(userRoleService).hasRole(eq("42"), (String[]) Mockito.any());
  }
}
