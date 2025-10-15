package org.finos.waltz.service.taxonomy_management.processors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.application.ImmutableApplicationIdSelectionOptions;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRating;
import org.finos.waltz.model.bookmark.Bookmark;
import org.finos.waltz.model.bookmark.BookmarkKindValue;
import org.finos.waltz.model.bookmark.ImmutableBookmark;
import org.finos.waltz.model.entity_named_note.EntityNamedNote;
import org.finos.waltz.model.entity_named_note.ImmutableEntityNamedNote;
import org.finos.waltz.model.entity_relationship.EntityRelationship;
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationship;
import org.finos.waltz.model.flow_diagram.FlowDiagramEntity;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagramEntity;
import org.finos.waltz.model.involvement.ImmutableInvolvement;
import org.finos.waltz.model.involvement.Involvement;
import org.finos.waltz.model.measurable.ImmutableMeasurable;
import org.finos.waltz.model.measurable.Measurable;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRating;
import org.finos.waltz.model.measurable_rating.MeasurableRating;
import org.finos.waltz.model.taxonomy_management.ImmutableTaxonomyChangePreview;
import org.finos.waltz.model.taxonomy_management.ImmutableTaxonomyChangePreview.Builder;
import org.finos.waltz.service.assessment_rating.AssessmentRatingService;
import org.finos.waltz.service.bookmark.BookmarkService;
import org.finos.waltz.service.entity_named_note.EntityNamedNoteService;
import org.finos.waltz.service.entity_relationship.EntityRelationshipService;
import org.finos.waltz.service.flow_diagram.FlowDiagramEntityService;
import org.finos.waltz.service.involvement.InvolvementService;
import org.finos.waltz.service.measurable.MeasurableService;
import org.finos.waltz.service.measurable_rating.MeasurableRatingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TaxonomyManagementHelperDiffblueTest {
  @Mock private AssessmentRatingService assessmentRatingService;

  @Mock private BookmarkService bookmarkService;

  @Mock private EntityNamedNoteService entityNamedNoteService;

  @Mock private EntityRelationshipService entityRelationshipService;

  @Mock private FlowDiagramEntityService flowDiagramEntityService;

  @Mock private InvolvementService involvementService;

  @Mock private MeasurableRatingService measurableRatingService;

  @Mock private MeasurableService measurableService;

  @InjectMocks private TaxonomyManagementHelper taxonomyManagementHelper;

  /**
   * Test {@link TaxonomyManagementHelper#previewEntityRelationships(Builder, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       EntityRelationshipService#findForGenericEntitySelector(IdSelectionOptions)}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewEntityRelationships(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test previewEntityRelationships(Builder, IdSelectionOptions); then calls findForGenericEntitySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewEntityRelationships(Builder, IdSelectionOptions)"
  })
  void testPreviewEntityRelationships_thenCallsFindForGenericEntitySelector() {
    // Arrange
    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();

    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();

    ImmutableEntityRelationship.Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());
    when(entityRelationshipService.findForGenericEntitySelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(entityRelationshipList);

    // Act
    taxonomyManagementHelper.previewEntityRelationships(
        ImmutableTaxonomyChangePreview.builder(), null);

    // Assert
    verify(entityRelationshipService).findForGenericEntitySelector(isNull());
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewEntityRelationships(Builder, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When builder.
   *   <li>Then calls {@link
   *       EntityRelationshipService#findForGenericEntitySelector(IdSelectionOptions)}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewEntityRelationships(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test previewEntityRelationships(Builder, IdSelectionOptions); when builder; then calls findForGenericEntitySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewEntityRelationships(Builder, IdSelectionOptions)"
  })
  void testPreviewEntityRelationships_whenBuilder_thenCallsFindForGenericEntitySelector() {
    // Arrange
    when(entityRelationshipService.findForGenericEntitySelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());

    // Act
    taxonomyManagementHelper.previewEntityRelationships(
        ImmutableTaxonomyChangePreview.builder(), null);

    // Assert
    verify(entityRelationshipService).findForGenericEntitySelector(isNull());
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewFlowDiagramRemovals(Builder, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link FlowDiagramEntityService#findForEntitySelector(IdSelectionOptions)}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewFlowDiagramRemovals(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test previewFlowDiagramRemovals(Builder, IdSelectionOptions); then calls findForEntitySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewFlowDiagramRemovals(Builder, IdSelectionOptions)"
  })
  void testPreviewFlowDiagramRemovals_thenCallsFindForEntitySelector() {
    // Arrange
    ArrayList<FlowDiagramEntity> flowDiagramEntityList = new ArrayList<>();

    ImmutableFlowDiagramEntity.Builder diagramIdResult =
        ImmutableFlowDiagramEntity.builder().diagramId(1L);
    flowDiagramEntityList.add(
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    when(flowDiagramEntityService.findForEntitySelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(flowDiagramEntityList);

    // Act
    taxonomyManagementHelper.previewFlowDiagramRemovals(
        ImmutableTaxonomyChangePreview.builder(), null);

    // Assert
    verify(flowDiagramEntityService).findForEntitySelector(isNull());
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewFlowDiagramRemovals(Builder, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When builder.
   *   <li>Then calls {@link FlowDiagramEntityService#findForEntitySelector(IdSelectionOptions)}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewFlowDiagramRemovals(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test previewFlowDiagramRemovals(Builder, IdSelectionOptions); when builder; then calls findForEntitySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewFlowDiagramRemovals(Builder, IdSelectionOptions)"
  })
  void testPreviewFlowDiagramRemovals_whenBuilder_thenCallsFindForEntitySelector() {
    // Arrange
    when(flowDiagramEntityService.findForEntitySelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());

    // Act
    taxonomyManagementHelper.previewFlowDiagramRemovals(
        ImmutableTaxonomyChangePreview.builder(), null);

    // Assert
    verify(flowDiagramEntityService).findForEntitySelector(isNull());
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewInvolvementRemovals(Builder, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementService#findByGenericEntitySelector(IdSelectionOptions)}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewInvolvementRemovals(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test previewInvolvementRemovals(Builder, IdSelectionOptions); then calls findByGenericEntitySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewInvolvementRemovals(Builder, IdSelectionOptions)"
  })
  void testPreviewInvolvementRemovals_thenCallsFindByGenericEntitySelector() {
    // Arrange
    ArrayList<Involvement> involvementList = new ArrayList<>();

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    involvementList.add(
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build());
    when(involvementService.findByGenericEntitySelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(involvementList);

    // Act
    taxonomyManagementHelper.previewInvolvementRemovals(
        ImmutableTaxonomyChangePreview.builder(), null);

    // Assert
    verify(involvementService).findByGenericEntitySelector(isNull());
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewInvolvementRemovals(Builder, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When builder.
   *   <li>Then calls {@link InvolvementService#findByGenericEntitySelector(IdSelectionOptions)}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewInvolvementRemovals(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test previewInvolvementRemovals(Builder, IdSelectionOptions); when builder; then calls findByGenericEntitySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewInvolvementRemovals(Builder, IdSelectionOptions)"
  })
  void testPreviewInvolvementRemovals_whenBuilder_thenCallsFindByGenericEntitySelector() {
    // Arrange
    when(involvementService.findByGenericEntitySelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());

    // Act
    taxonomyManagementHelper.previewInvolvementRemovals(
        ImmutableTaxonomyChangePreview.builder(), null);

    // Assert
    verify(involvementService).findByGenericEntitySelector(isNull());
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewEntityNamedNoteRemovals(Builder,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewEntityNamedNoteRemovals(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test previewEntityNamedNoteRemovals(Builder, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewEntityNamedNoteRemovals(Builder, IdSelectionOptions)"
  })
  void testPreviewEntityNamedNoteRemovals() {
    // Arrange
    ArrayList<EntityNamedNote> entityNamedNoteList = new ArrayList<>();

    ImmutableEntityNamedNote.Builder builderResult = ImmutableEntityNamedNote.builder();
    entityNamedNoteList.add(
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .namedNoteTypeId(1L)
            .noteText("Note Text")
            .provenance("Provenance")
            .build());
    when(entityNamedNoteService.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(entityNamedNoteList);
    Builder preview = ImmutableTaxonomyChangePreview.builder();

    ImmutableIdSelectionOptions.Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    taxonomyManagementHelper.previewEntityNamedNoteRemovals(
        preview,
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());

    // Assert
    verify(entityNamedNoteService).findByEntityReference(isA(EntityReference.class));
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewEntityNamedNoteRemovals(Builder,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewEntityNamedNoteRemovals(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test previewEntityNamedNoteRemovals(Builder, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewEntityNamedNoteRemovals(Builder, IdSelectionOptions)"
  })
  void testPreviewEntityNamedNoteRemovals2() {
    // Arrange
    when(entityNamedNoteService.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    Builder preview = ImmutableTaxonomyChangePreview.builder();

    ImmutableApplicationIdSelectionOptions.Builder builderResult =
        ImmutableApplicationIdSelectionOptions.builder();

    ImmutableApplicationIdSelectionOptions.Builder filtersResult =
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

    ImmutableApplicationIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    taxonomyManagementHelper.previewEntityNamedNoteRemovals(
        preview,
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());

    // Assert
    verify(entityNamedNoteService).findByEntityReference(isA(EntityReference.class));
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewEntityNamedNoteRemovals(Builder,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityNamedNoteService#findByEntityReference(EntityReference)}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewEntityNamedNoteRemovals(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test previewEntityNamedNoteRemovals(Builder, IdSelectionOptions); then calls findByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewEntityNamedNoteRemovals(Builder, IdSelectionOptions)"
  })
  void testPreviewEntityNamedNoteRemovals_thenCallsFindByEntityReference() {
    // Arrange
    when(entityNamedNoteService.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    Builder preview = ImmutableTaxonomyChangePreview.builder();

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    taxonomyManagementHelper.previewEntityNamedNoteRemovals(
        preview,
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());

    // Assert
    verify(entityNamedNoteService).findByEntityReference(isA(EntityReference.class));
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewAssessmentRemovals(Builder, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind,
   *       IdSelectionOptions)}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewAssessmentRemovals(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test previewAssessmentRemovals(Builder, IdSelectionOptions); then calls findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewAssessmentRemovals(Builder, IdSelectionOptions)"
  })
  void testPreviewAssessmentRemovals_thenCallsFindByTargetKindForRelatedSelector() {
    // Arrange
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());

    // Act
    taxonomyManagementHelper.previewAssessmentRemovals(
        ImmutableTaxonomyChangePreview.builder(), null);

    // Assert
    verify(assessmentRatingService)
        .findByTargetKindForRelatedSelector(eq(EntityKind.MEASURABLE), isNull());
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewAssessmentRemovals(Builder, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link AssessmentRatingService#findByTargetKindForRelatedSelector(EntityKind,
   *       IdSelectionOptions)}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewAssessmentRemovals(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test previewAssessmentRemovals(Builder, IdSelectionOptions); then calls findByTargetKindForRelatedSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewAssessmentRemovals(Builder, IdSelectionOptions)"
  })
  void testPreviewAssessmentRemovals_thenCallsFindByTargetKindForRelatedSelector2() {
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
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(assessmentRatingList);

    // Act
    taxonomyManagementHelper.previewAssessmentRemovals(
        ImmutableTaxonomyChangePreview.builder(), null);

    // Assert
    verify(assessmentRatingService)
        .findByTargetKindForRelatedSelector(eq(EntityKind.MEASURABLE), isNull());
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewBookmarkRemovals(Builder, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link BookmarkService#findByBookmarkIdSelector(IdSelectionOptions)}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewBookmarkRemovals(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test previewBookmarkRemovals(Builder, IdSelectionOptions); then calls findByBookmarkIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewBookmarkRemovals(Builder, IdSelectionOptions)"
  })
  void testPreviewBookmarkRemovals_thenCallsFindByBookmarkIdSelector() {
    // Arrange
    HashSet<Bookmark> bookmarkSet = new HashSet<>();

    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();

    ImmutableBookmark.Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    bookmarkSet.add(
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build());
    when(bookmarkService.findByBookmarkIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(bookmarkSet);

    // Act
    taxonomyManagementHelper.previewBookmarkRemovals(
        ImmutableTaxonomyChangePreview.builder(), null);

    // Assert
    verify(bookmarkService).findByBookmarkIdSelector(isNull());
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewBookmarkRemovals(Builder, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When builder.
   *   <li>Then calls {@link BookmarkService#findByBookmarkIdSelector(IdSelectionOptions)}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewBookmarkRemovals(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test previewBookmarkRemovals(Builder, IdSelectionOptions); when builder; then calls findByBookmarkIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewBookmarkRemovals(Builder, IdSelectionOptions)"
  })
  void testPreviewBookmarkRemovals_whenBuilder_thenCallsFindByBookmarkIdSelector() {
    // Arrange
    when(bookmarkService.findByBookmarkIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new HashSet<>());

    // Act
    taxonomyManagementHelper.previewBookmarkRemovals(
        ImmutableTaxonomyChangePreview.builder(), null);

    // Assert
    verify(bookmarkService).findByBookmarkIdSelector(isNull());
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewAppMappingRemovals(Builder, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       MeasurableRatingService#findByMeasurableIdSelector(IdSelectionOptions)}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewAppMappingRemovals(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test previewAppMappingRemovals(Builder, IdSelectionOptions); then calls findByMeasurableIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewAppMappingRemovals(Builder, IdSelectionOptions)"
  })
  void testPreviewAppMappingRemovals_thenCallsFindByMeasurableIdSelector() {
    // Arrange
    ArrayList<MeasurableRating> measurableRatingList = new ArrayList<>();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    measurableRatingList.add(
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
    when(measurableRatingService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(measurableRatingList);

    // Act
    taxonomyManagementHelper.previewAppMappingRemovals(
        ImmutableTaxonomyChangePreview.builder(), null);

    // Assert
    verify(measurableRatingService).findByMeasurableIdSelector(isNull());
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewAppMappingRemovals(Builder, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When builder.
   *   <li>Then calls {@link
   *       MeasurableRatingService#findByMeasurableIdSelector(IdSelectionOptions)}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewAppMappingRemovals(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test previewAppMappingRemovals(Builder, IdSelectionOptions); when builder; then calls findByMeasurableIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewAppMappingRemovals(Builder, IdSelectionOptions)"
  })
  void testPreviewAppMappingRemovals_whenBuilder_thenCallsFindByMeasurableIdSelector() {
    // Arrange
    when(measurableRatingService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());

    // Act
    taxonomyManagementHelper.previewAppMappingRemovals(
        ImmutableTaxonomyChangePreview.builder(), null);

    // Assert
    verify(measurableRatingService).findByMeasurableIdSelector(isNull());
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewChildNodeRemovals(Builder, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewChildNodeRemovals(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test previewChildNodeRemovals(Builder, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewChildNodeRemovals(Builder, IdSelectionOptions)"
  })
  void testPreviewChildNodeRemovals() {
    // Arrange
    ArrayList<Measurable> measurableList = new ArrayList<>();
    measurableList.add(
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
    measurableList.add(
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(-2L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());
    when(measurableService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(measurableList);
    Builder preview = ImmutableTaxonomyChangePreview.builder();

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
    taxonomyManagementHelper.previewChildNodeRemovals(preview, selectionOptions);

    // Assert
    verify(selectionOptions).entityReference();
    verify(measurableService).findByMeasurableIdSelector(isA(IdSelectionOptions.class));
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewChildNodeRemovals(Builder, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewChildNodeRemovals(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test previewChildNodeRemovals(Builder, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewChildNodeRemovals(Builder, IdSelectionOptions)"
  })
  void testPreviewChildNodeRemovals2() {
    // Arrange
    when(measurableService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    Builder preview = ImmutableTaxonomyChangePreview.builder();

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    taxonomyManagementHelper.previewChildNodeRemovals(
        preview,
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());

    // Assert
    verify(measurableService).findByMeasurableIdSelector(isA(IdSelectionOptions.class));
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewChildNodeRemovals(Builder, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#entityReference()}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewChildNodeRemovals(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test previewChildNodeRemovals(Builder, IdSelectionOptions); then calls entityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewChildNodeRemovals(Builder, IdSelectionOptions)"
  })
  void testPreviewChildNodeRemovals_thenCallsEntityReference() {
    // Arrange
    when(measurableService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    Builder preview = ImmutableTaxonomyChangePreview.builder();

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
    taxonomyManagementHelper.previewChildNodeRemovals(preview, selectionOptions);

    // Assert
    verify(selectionOptions).entityReference();
    verify(measurableService).findByMeasurableIdSelector(isA(IdSelectionOptions.class));
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewChildNodeRemovals(Builder, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#entityReference()}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewChildNodeRemovals(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test previewChildNodeRemovals(Builder, IdSelectionOptions); then calls entityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewChildNodeRemovals(Builder, IdSelectionOptions)"
  })
  void testPreviewChildNodeRemovals_thenCallsEntityReference2() {
    // Arrange
    ArrayList<Measurable> measurableList = new ArrayList<>();
    measurableList.add(
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
    when(measurableService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(measurableList);
    Builder preview = ImmutableTaxonomyChangePreview.builder();

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
    taxonomyManagementHelper.previewChildNodeRemovals(preview, selectionOptions);

    // Assert
    verify(selectionOptions).entityReference();
    verify(measurableService).findByMeasurableIdSelector(isA(IdSelectionOptions.class));
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewChildNodeRemovals(Builder, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#entityReference()}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewChildNodeRemovals(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test previewChildNodeRemovals(Builder, IdSelectionOptions); then calls entityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewChildNodeRemovals(Builder, IdSelectionOptions)"
  })
  void testPreviewChildNodeRemovals_thenCallsEntityReference3() {
    // Arrange
    ArrayList<Measurable> measurableList = new ArrayList<>();
    measurableList.add(
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
    measurableList.add(
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
    when(measurableService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(measurableList);
    Builder preview = ImmutableTaxonomyChangePreview.builder();

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
    taxonomyManagementHelper.previewChildNodeRemovals(preview, selectionOptions);

    // Assert
    verify(selectionOptions).entityReference();
    verify(measurableService).findByMeasurableIdSelector(isA(IdSelectionOptions.class));
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewChildNodeMigrations(Builder, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewChildNodeMigrations(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test previewChildNodeMigrations(Builder, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewChildNodeMigrations(Builder, IdSelectionOptions)"
  })
  void testPreviewChildNodeMigrations() {
    // Arrange
    ArrayList<Measurable> measurableList = new ArrayList<>();
    measurableList.add(
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
    when(measurableService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(measurableList);
    Builder preview = ImmutableTaxonomyChangePreview.builder();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> emptyResult = Optional.empty();
    when(selectionOptions.joiningEntityKind()).thenReturn(emptyResult);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
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
    taxonomyManagementHelper.previewChildNodeMigrations(preview, selectionOptions);

    // Assert
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    verify(measurableService).findByMeasurableIdSelector(isA(IdSelectionOptions.class));
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewChildNodeMigrations(Builder, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewChildNodeMigrations(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test previewChildNodeMigrations(Builder, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewChildNodeMigrations(Builder, IdSelectionOptions)"
  })
  void testPreviewChildNodeMigrations2() {
    // Arrange
    ArrayList<Measurable> measurableList = new ArrayList<>();
    measurableList.add(
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
    measurableList.add(
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
    when(measurableService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(measurableList);
    Builder preview = ImmutableTaxonomyChangePreview.builder();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> emptyResult = Optional.empty();
    when(selectionOptions.joiningEntityKind()).thenReturn(emptyResult);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
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
    taxonomyManagementHelper.previewChildNodeMigrations(preview, selectionOptions);

    // Assert
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    verify(measurableService).findByMeasurableIdSelector(isA(IdSelectionOptions.class));
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewChildNodeMigrations(Builder, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewChildNodeMigrations(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test previewChildNodeMigrations(Builder, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewChildNodeMigrations(Builder, IdSelectionOptions)"
  })
  void testPreviewChildNodeMigrations3() {
    // Arrange
    ArrayList<Measurable> measurableList = new ArrayList<>();
    measurableList.add(
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
    measurableList.add(
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(-2L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());
    when(measurableService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(measurableList);
    Builder preview = ImmutableTaxonomyChangePreview.builder();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> emptyResult = Optional.empty();
    when(selectionOptions.joiningEntityKind()).thenReturn(emptyResult);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
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
    taxonomyManagementHelper.previewChildNodeMigrations(preview, selectionOptions);

    // Assert
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    verify(measurableService).findByMeasurableIdSelector(isA(IdSelectionOptions.class));
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewChildNodeMigrations(Builder, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewChildNodeMigrations(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test previewChildNodeMigrations(Builder, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewChildNodeMigrations(Builder, IdSelectionOptions)"
  })
  void testPreviewChildNodeMigrations4() {
    // Arrange
    when(measurableService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    Builder preview = ImmutableTaxonomyChangePreview.builder();

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    taxonomyManagementHelper.previewChildNodeMigrations(
        preview,
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());

    // Assert
    verify(measurableService).findByMeasurableIdSelector(isA(IdSelectionOptions.class));
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewChildNodeMigrations(Builder, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code CHILDREN}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewChildNodeMigrations(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test previewChildNodeMigrations(Builder, IdSelectionOptions); given 'CHILDREN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewChildNodeMigrations(Builder, IdSelectionOptions)"
  })
  void testPreviewChildNodeMigrations_givenChildren() {
    // Arrange
    when(measurableService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    Builder preview = ImmutableTaxonomyChangePreview.builder();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> emptyResult = Optional.empty();
    when(selectionOptions.joiningEntityKind()).thenReturn(emptyResult);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
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
    taxonomyManagementHelper.previewChildNodeMigrations(preview, selectionOptions);

    // Assert
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    verify(measurableService).findByMeasurableIdSelector(isA(IdSelectionOptions.class));
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewChildNodeMigrations(Builder, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewChildNodeMigrations(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test previewChildNodeMigrations(Builder, IdSelectionOptions); given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewChildNodeMigrations(Builder, IdSelectionOptions)"
  })
  void testPreviewChildNodeMigrations_givenEmpty() {
    // Arrange
    when(measurableService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    Builder preview = ImmutableTaxonomyChangePreview.builder();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> emptyResult = Optional.empty();
    when(selectionOptions.joiningEntityKind()).thenReturn(emptyResult);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
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
    taxonomyManagementHelper.previewChildNodeMigrations(preview, selectionOptions);

    // Assert
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    verify(measurableService).findByMeasurableIdSelector(isA(IdSelectionOptions.class));
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewChildNodeMigrations(Builder, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewChildNodeMigrations(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test previewChildNodeMigrations(Builder, IdSelectionOptions); given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewChildNodeMigrations(Builder, IdSelectionOptions)"
  })
  void testPreviewChildNodeMigrations_givenHashSetAddActive() {
    // Arrange
    when(measurableService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    Builder preview = ImmutableTaxonomyChangePreview.builder();

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> emptyResult = Optional.empty();
    when(selectionOptions.joiningEntityKind()).thenReturn(emptyResult);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
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
    taxonomyManagementHelper.previewChildNodeMigrations(preview, selectionOptions);

    // Assert
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    verify(measurableService).findByMeasurableIdSelector(isA(IdSelectionOptions.class));
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewChildNodeMigrations(Builder, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given of {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewChildNodeMigrations(Builder,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test previewChildNodeMigrations(Builder, IdSelectionOptions); given of 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.previewChildNodeMigrations(Builder, IdSelectionOptions)"
  })
  void testPreviewChildNodeMigrations_givenOfAll() {
    // Arrange
    when(measurableService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    Builder preview = ImmutableTaxonomyChangePreview.builder();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(selectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
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
    taxonomyManagementHelper.previewChildNodeMigrations(preview, selectionOptions);

    // Assert
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    verify(measurableService).findByMeasurableIdSelector(isA(IdSelectionOptions.class));
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewRatingMigrations(Builder, Long, Long)}.
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewRatingMigrations(Builder, Long,
   * Long)}
   */
  @Test
  @DisplayName("Test previewRatingMigrations(Builder, Long, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TaxonomyManagementHelper.previewRatingMigrations(Builder, Long, Long)"})
  void testPreviewRatingMigrations() {
    // Arrange
    when(measurableRatingService.getSharedRatingsCount(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(0);

    // Act
    taxonomyManagementHelper.previewRatingMigrations(
        ImmutableTaxonomyChangePreview.builder(), 1L, 1L);

    // Assert
    verify(measurableRatingService).getSharedRatingsCount(1L, 1L);
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewRatingMigrations(Builder, Long, Long)}.
   *
   * <ul>
   *   <li>Then calls {@link MeasurableRatingService#getSharedRatingsCount(Long, Long)}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewRatingMigrations(Builder, Long,
   * Long)}
   */
  @Test
  @DisplayName(
      "Test previewRatingMigrations(Builder, Long, Long); then calls getSharedRatingsCount(Long, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TaxonomyManagementHelper.previewRatingMigrations(Builder, Long, Long)"})
  void testPreviewRatingMigrations_thenCallsGetSharedRatingsCount() {
    // Arrange
    when(measurableRatingService.getSharedRatingsCount(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(3);

    // Act
    taxonomyManagementHelper.previewRatingMigrations(
        ImmutableTaxonomyChangePreview.builder(), 1L, 1L);

    // Assert
    verify(measurableRatingService).getSharedRatingsCount(1L, 1L);
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewDecommMigrations(Builder, Long, Long)}.
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewDecommMigrations(Builder, Long,
   * Long)}
   */
  @Test
  @DisplayName("Test previewDecommMigrations(Builder, Long, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TaxonomyManagementHelper.previewDecommMigrations(Builder, Long, Long)"})
  void testPreviewDecommMigrations() {
    // Arrange
    when(measurableRatingService.getSharedDecommsCount(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(0);

    // Act
    taxonomyManagementHelper.previewDecommMigrations(
        ImmutableTaxonomyChangePreview.builder(), 1L, 1L);

    // Assert
    verify(measurableRatingService).getSharedDecommsCount(1L, 1L);
  }

  /**
   * Test {@link TaxonomyManagementHelper#previewDecommMigrations(Builder, Long, Long)}.
   *
   * <ul>
   *   <li>Then calls {@link MeasurableRatingService#getSharedDecommsCount(Long, Long)}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#previewDecommMigrations(Builder, Long,
   * Long)}
   */
  @Test
  @DisplayName(
      "Test previewDecommMigrations(Builder, Long, Long); then calls getSharedDecommsCount(Long, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TaxonomyManagementHelper.previewDecommMigrations(Builder, Long, Long)"})
  void testPreviewDecommMigrations_thenCallsGetSharedDecommsCount() {
    // Arrange
    when(measurableRatingService.getSharedDecommsCount(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(3);

    // Act
    taxonomyManagementHelper.previewDecommMigrations(
        ImmutableTaxonomyChangePreview.builder(), 1L, 1L);

    // Assert
    verify(measurableRatingService).getSharedDecommsCount(1L, 1L);
  }

  /**
   * Test {@link TaxonomyManagementHelper#migrateMeasurable(IdSelectionOptions, Long, String)}.
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#migrateMeasurable(IdSelectionOptions,
   * Long, String)}
   */
  @Test
  @DisplayName("Test migrateMeasurable(IdSelectionOptions, Long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.migrateMeasurable(IdSelectionOptions, Long, String)"
  })
  void testMigrateMeasurable() {
    // Arrange
    doNothing()
        .when(entityRelationshipService)
        .migrateEntityRelationships(
            Mockito.<EntityReference>any(), Mockito.<EntityReference>any(), Mockito.<String>any());
    doNothing()
        .when(measurableRatingService)
        .migrateRatings(Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any());
    when(measurableService.moveChildren(
            Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(measurableService.deleteByIdSelector(Mockito.<IdSelectionOptions>any())).thenReturn(1);

    ImmutableApplicationIdSelectionOptions.Builder builderResult =
        ImmutableApplicationIdSelectionOptions.builder();

    ImmutableApplicationIdSelectionOptions.Builder filtersResult =
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

    ImmutableApplicationIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    taxonomyManagementHelper.migrateMeasurable(
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build(),
        1L,
        "42");

    // Assert
    verify(entityRelationshipService)
        .migrateEntityRelationships(
            isA(EntityReference.class), isA(EntityReference.class), eq("42"));
    verify(measurableService).deleteByIdSelector(isA(IdSelectionOptions.class));
    verify(measurableService).moveChildren(1L, 1L, "42");
    verify(measurableRatingService).migrateRatings(1L, 1L, "42");
  }

  /**
   * Test {@link TaxonomyManagementHelper#migrateMeasurable(IdSelectionOptions, Long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityRelationshipService#migrateEntityRelationships(EntityReference,
   *       EntityReference, String)}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#migrateMeasurable(IdSelectionOptions,
   * Long, String)}
   */
  @Test
  @DisplayName(
      "Test migrateMeasurable(IdSelectionOptions, Long, String); then calls migrateEntityRelationships(EntityReference, EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaxonomyManagementHelper.migrateMeasurable(IdSelectionOptions, Long, String)"
  })
  void testMigrateMeasurable_thenCallsMigrateEntityRelationships() {
    // Arrange
    doNothing()
        .when(entityRelationshipService)
        .migrateEntityRelationships(
            Mockito.<EntityReference>any(), Mockito.<EntityReference>any(), Mockito.<String>any());
    doNothing()
        .when(measurableRatingService)
        .migrateRatings(Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any());
    when(measurableService.moveChildren(
            Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(measurableService.deleteByIdSelector(Mockito.<IdSelectionOptions>any())).thenReturn(1);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    taxonomyManagementHelper.migrateMeasurable(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build(),
        1L,
        "42");

    // Assert
    verify(entityRelationshipService)
        .migrateEntityRelationships(
            isA(EntityReference.class), isA(EntityReference.class), eq("42"));
    verify(measurableService).deleteByIdSelector(isA(IdSelectionOptions.class));
    verify(measurableService).moveChildren(1L, 1L, "42");
    verify(measurableRatingService).migrateRatings(1L, 1L, "42");
  }

  /**
   * Test {@link TaxonomyManagementHelper#removeEntityRelationshipsDiagrams(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * TaxonomyManagementHelper#removeEntityRelationshipsDiagrams(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test removeEntityRelationshipsDiagrams(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int TaxonomyManagementHelper.removeEntityRelationshipsDiagrams(IdSelectionOptions)"
  })
  void testRemoveEntityRelationshipsDiagrams() {
    // Arrange
    when(entityRelationshipService.deleteForGenericEntitySelector(
            Mockito.<IdSelectionOptions>any()))
        .thenReturn(1);

    // Act
    int actualRemoveEntityRelationshipsDiagramsResult =
        taxonomyManagementHelper.removeEntityRelationshipsDiagrams(null);

    // Assert
    verify(entityRelationshipService).deleteForGenericEntitySelector(isNull());
    assertEquals(1, actualRemoveEntityRelationshipsDiagramsResult);
  }

  /**
   * Test {@link TaxonomyManagementHelper#removeFlowDiagrams(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#removeFlowDiagrams(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test removeFlowDiagrams(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TaxonomyManagementHelper.removeFlowDiagrams(IdSelectionOptions)"})
  void testRemoveFlowDiagrams() {
    // Arrange
    when(flowDiagramEntityService.deleteForEntitySelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(1);

    // Act
    int actualRemoveFlowDiagramsResult = taxonomyManagementHelper.removeFlowDiagrams(null);

    // Assert
    verify(flowDiagramEntityService).deleteForEntitySelector(isNull());
    assertEquals(1, actualRemoveFlowDiagramsResult);
  }

  /**
   * Test {@link TaxonomyManagementHelper#removeMeasurables(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#removeMeasurables(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test removeMeasurables(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TaxonomyManagementHelper.removeMeasurables(IdSelectionOptions)"})
  void testRemoveMeasurables() {
    // Arrange
    when(measurableService.deleteByIdSelector(Mockito.<IdSelectionOptions>any())).thenReturn(1);

    // Act
    int actualRemoveMeasurablesResult = taxonomyManagementHelper.removeMeasurables(null);

    // Assert
    verify(measurableService).deleteByIdSelector(isNull());
    assertEquals(1, actualRemoveMeasurablesResult);
  }

  /**
   * Test {@link TaxonomyManagementHelper#removeAppMappings(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#removeAppMappings(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test removeAppMappings(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TaxonomyManagementHelper.removeAppMappings(IdSelectionOptions)"})
  void testRemoveAppMappings() {
    // Arrange
    when(measurableRatingService.deleteByMeasurableIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(1);

    // Act
    int actualRemoveAppMappingsResult = taxonomyManagementHelper.removeAppMappings(null);

    // Assert
    verify(measurableRatingService).deleteByMeasurableIdSelector(isNull());
    assertEquals(1, actualRemoveAppMappingsResult);
  }

  /**
   * Test {@link TaxonomyManagementHelper#removeInvolvements(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#removeInvolvements(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test removeInvolvements(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TaxonomyManagementHelper.removeInvolvements(IdSelectionOptions)"})
  void testRemoveInvolvements() {
    // Arrange
    when(involvementService.deleteByGenericEntitySelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(1);

    // Act
    int actualRemoveInvolvementsResult = taxonomyManagementHelper.removeInvolvements(null);

    // Assert
    verify(involvementService).deleteByGenericEntitySelector(isNull());
    assertEquals(1, actualRemoveInvolvementsResult);
  }

  /**
   * Test {@link TaxonomyManagementHelper#removeBookmarks(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#removeBookmarks(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test removeBookmarks(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TaxonomyManagementHelper.removeBookmarks(IdSelectionOptions)"})
  void testRemoveBookmarks() {
    // Arrange
    when(bookmarkService.deleteByBookmarkIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(1);

    // Act
    int actualRemoveBookmarksResult = taxonomyManagementHelper.removeBookmarks(null);

    // Assert
    verify(bookmarkService).deleteByBookmarkIdSelector(isNull());
    assertEquals(1, actualRemoveBookmarksResult);
  }

  /**
   * Test {@link TaxonomyManagementHelper#removeAssessments(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#removeAssessments(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test removeAssessments(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int TaxonomyManagementHelper.removeAssessments(EntityKind, IdSelectionOptions)"
  })
  void testRemoveAssessments() {
    // Arrange
    when(assessmentRatingService.deleteByAssessmentRatingRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(1);

    // Act
    int actualRemoveAssessmentsResult =
        taxonomyManagementHelper.removeAssessments(EntityKind.ALL, null);

    // Assert
    verify(assessmentRatingService)
        .deleteByAssessmentRatingRelatedSelector(eq(EntityKind.ALL), isNull());
    assertEquals(1, actualRemoveAssessmentsResult);
  }

  /**
   * Test {@link TaxonomyManagementHelper#removeNamedNotes(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link TaxonomyManagementHelper#removeNamedNotes(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test removeNamedNotes(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TaxonomyManagementHelper.removeNamedNotes(IdSelectionOptions)"})
  void testRemoveNamedNotes() {
    // Arrange
    when(entityNamedNoteService.deleteByNamedNoteParentSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(1);

    // Act
    int actualRemoveNamedNotesResult = taxonomyManagementHelper.removeNamedNotes(null);

    // Assert
    verify(entityNamedNoteService).deleteByNamedNoteParentSelector(isNull());
    assertEquals(1, actualRemoveNamedNotesResult);
  }
}
