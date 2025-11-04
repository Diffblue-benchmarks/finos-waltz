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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.bookmark.Bookmark;
import org.finos.waltz.model.entity_named_note.EntityNamedNote;
import org.finos.waltz.model.entity_relationship.EntityRelationship;
import org.finos.waltz.model.flow_diagram.FlowDiagramEntity;
import org.finos.waltz.model.involvement.Involvement;
import org.finos.waltz.model.measurable.Measurable;
import org.finos.waltz.model.measurable_rating.MeasurableRating;
import org.finos.waltz.model.taxonomy_management.ImmutableTaxonomyChangePreview;
import org.finos.waltz.service.assessment_rating.AssessmentRatingService;
import org.finos.waltz.service.bookmark.BookmarkService;
import org.finos.waltz.service.entity_named_note.EntityNamedNoteService;
import org.finos.waltz.service.entity_relationship.EntityRelationshipService;
import org.finos.waltz.service.flow_diagram.FlowDiagramEntityService;
import org.finos.waltz.service.involvement.InvolvementService;
import org.finos.waltz.service.measurable.MeasurableService;
import org.finos.waltz.service.measurable_rating.MeasurableRatingService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TaxonomyManagementHelperDiffblueTest {
  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#previewEntityRelationships(ImmutableTaxonomyChangePreview.Builder, IdSelectionOptions)}
   */
  @Test
  void testPreviewEntityRelationships() {
    // Arrange
    EntityRelationshipService entityRelationshipService = mock(EntityRelationshipService.class);
    when(entityRelationshipService.findForGenericEntitySelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    TaxonomyManagementHelper taxonomyManagementHelper = new TaxonomyManagementHelper(mock(BookmarkService.class),
        entityRelationshipService, mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        mock(MeasurableRatingService.class), mock(MeasurableService.class), mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class));

    // Act
    taxonomyManagementHelper.previewEntityRelationships(ImmutableTaxonomyChangePreview.builder(), null);

    // Assert
    verify(entityRelationshipService).findForGenericEntitySelector(isNull());
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#previewEntityRelationships(ImmutableTaxonomyChangePreview.Builder, IdSelectionOptions)}
   */
  @Test
  void testPreviewEntityRelationships2() {
    // Arrange
    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();
    entityRelationshipList.add(mock(EntityRelationship.class));
    EntityRelationshipService entityRelationshipService = mock(EntityRelationshipService.class);
    when(entityRelationshipService.findForGenericEntitySelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(entityRelationshipList);
    TaxonomyManagementHelper taxonomyManagementHelper = new TaxonomyManagementHelper(mock(BookmarkService.class),
        entityRelationshipService, mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        mock(MeasurableRatingService.class), mock(MeasurableService.class), mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class));

    // Act
    taxonomyManagementHelper.previewEntityRelationships(ImmutableTaxonomyChangePreview.builder(), null);

    // Assert
    verify(entityRelationshipService).findForGenericEntitySelector(isNull());
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#previewFlowDiagramRemovals(ImmutableTaxonomyChangePreview.Builder, IdSelectionOptions)}
   */
  @Test
  void testPreviewFlowDiagramRemovals() {
    // Arrange
    FlowDiagramEntityService flowDiagramEntityService = mock(FlowDiagramEntityService.class);
    when(flowDiagramEntityService.findForEntitySelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    TaxonomyManagementHelper taxonomyManagementHelper = new TaxonomyManagementHelper(mock(BookmarkService.class),
        mock(EntityRelationshipService.class), flowDiagramEntityService, mock(InvolvementService.class),
        mock(MeasurableRatingService.class), mock(MeasurableService.class), mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class));

    // Act
    taxonomyManagementHelper.previewFlowDiagramRemovals(ImmutableTaxonomyChangePreview.builder(), null);

    // Assert
    verify(flowDiagramEntityService).findForEntitySelector(isNull());
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#previewFlowDiagramRemovals(ImmutableTaxonomyChangePreview.Builder, IdSelectionOptions)}
   */
  @Test
  void testPreviewFlowDiagramRemovals2() {
    // Arrange
    ArrayList<FlowDiagramEntity> flowDiagramEntityList = new ArrayList<>();
    flowDiagramEntityList.add(mock(FlowDiagramEntity.class));
    FlowDiagramEntityService flowDiagramEntityService = mock(FlowDiagramEntityService.class);
    when(flowDiagramEntityService.findForEntitySelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(flowDiagramEntityList);
    TaxonomyManagementHelper taxonomyManagementHelper = new TaxonomyManagementHelper(mock(BookmarkService.class),
        mock(EntityRelationshipService.class), flowDiagramEntityService, mock(InvolvementService.class),
        mock(MeasurableRatingService.class), mock(MeasurableService.class), mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class));

    // Act
    taxonomyManagementHelper.previewFlowDiagramRemovals(ImmutableTaxonomyChangePreview.builder(), null);

    // Assert
    verify(flowDiagramEntityService).findForEntitySelector(isNull());
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#previewInvolvementRemovals(ImmutableTaxonomyChangePreview.Builder, IdSelectionOptions)}
   */
  @Test
  void testPreviewInvolvementRemovals() {
    // Arrange
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findByGenericEntitySelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    TaxonomyManagementHelper taxonomyManagementHelper = new TaxonomyManagementHelper(mock(BookmarkService.class),
        mock(EntityRelationshipService.class), mock(FlowDiagramEntityService.class), involvementService,
        mock(MeasurableRatingService.class), mock(MeasurableService.class), mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class));

    // Act
    taxonomyManagementHelper.previewInvolvementRemovals(ImmutableTaxonomyChangePreview.builder(), null);

    // Assert
    verify(involvementService).findByGenericEntitySelector(isNull());
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#previewInvolvementRemovals(ImmutableTaxonomyChangePreview.Builder, IdSelectionOptions)}
   */
  @Test
  void testPreviewInvolvementRemovals2() {
    // Arrange
    ArrayList<Involvement> involvementList = new ArrayList<>();
    involvementList.add(mock(Involvement.class));
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findByGenericEntitySelector(Mockito.<IdSelectionOptions>any())).thenReturn(involvementList);
    TaxonomyManagementHelper taxonomyManagementHelper = new TaxonomyManagementHelper(mock(BookmarkService.class),
        mock(EntityRelationshipService.class), mock(FlowDiagramEntityService.class), involvementService,
        mock(MeasurableRatingService.class), mock(MeasurableService.class), mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class));

    // Act
    taxonomyManagementHelper.previewInvolvementRemovals(ImmutableTaxonomyChangePreview.builder(), null);

    // Assert
    verify(involvementService).findByGenericEntitySelector(isNull());
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#previewEntityNamedNoteRemovals(ImmutableTaxonomyChangePreview.Builder, IdSelectionOptions)}
   */
  @Test
  void testPreviewEntityNamedNoteRemovals() {
    // Arrange
    EntityNamedNoteService entityNamedNoteService = mock(EntityNamedNoteService.class);
    when(entityNamedNoteService.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    TaxonomyManagementHelper taxonomyManagementHelper = new TaxonomyManagementHelper(mock(BookmarkService.class),
        mock(EntityRelationshipService.class), mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        mock(MeasurableRatingService.class), mock(MeasurableService.class), entityNamedNoteService,
        mock(AssessmentRatingService.class));
    ImmutableTaxonomyChangePreview.Builder preview = ImmutableTaxonomyChangePreview.builder();
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(null);

    // Act
    taxonomyManagementHelper.previewEntityNamedNoteRemovals(preview, selectionOptions);

    // Assert
    verify(selectionOptions).entityReference();
    verify(entityNamedNoteService).findByEntityReference(isNull());
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#previewEntityNamedNoteRemovals(ImmutableTaxonomyChangePreview.Builder, IdSelectionOptions)}
   */
  @Test
  void testPreviewEntityNamedNoteRemovals2() {
    // Arrange
    ArrayList<EntityNamedNote> entityNamedNoteList = new ArrayList<>();
    entityNamedNoteList.add(mock(EntityNamedNote.class));
    EntityNamedNoteService entityNamedNoteService = mock(EntityNamedNoteService.class);
    when(entityNamedNoteService.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(entityNamedNoteList);
    TaxonomyManagementHelper taxonomyManagementHelper = new TaxonomyManagementHelper(mock(BookmarkService.class),
        mock(EntityRelationshipService.class), mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        mock(MeasurableRatingService.class), mock(MeasurableService.class), entityNamedNoteService,
        mock(AssessmentRatingService.class));
    ImmutableTaxonomyChangePreview.Builder preview = ImmutableTaxonomyChangePreview.builder();
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(null);

    // Act
    taxonomyManagementHelper.previewEntityNamedNoteRemovals(preview, selectionOptions);

    // Assert
    verify(selectionOptions).entityReference();
    verify(entityNamedNoteService).findByEntityReference(isNull());
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#previewAssessmentRemovals(ImmutableTaxonomyChangePreview.Builder, IdSelectionOptions)}
   */
  @Test
  void testPreviewAssessmentRemovals() {
    // Arrange
    AssessmentRatingService assessmentRatingService = mock(AssessmentRatingService.class);
    when(assessmentRatingService.findByTargetKindForRelatedSelector(Mockito.<EntityKind>any(),
        Mockito.<IdSelectionOptions>any())).thenReturn(new ArrayList<>());
    TaxonomyManagementHelper taxonomyManagementHelper = new TaxonomyManagementHelper(mock(BookmarkService.class),
        mock(EntityRelationshipService.class), mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        mock(MeasurableRatingService.class), mock(MeasurableService.class), mock(EntityNamedNoteService.class),
        assessmentRatingService);

    // Act
    taxonomyManagementHelper.previewAssessmentRemovals(ImmutableTaxonomyChangePreview.builder(), null);

    // Assert
    verify(assessmentRatingService).findByTargetKindForRelatedSelector(eq(EntityKind.MEASURABLE), isNull());
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#previewAssessmentRemovals(ImmutableTaxonomyChangePreview.Builder, IdSelectionOptions)}
   */
  @Test
  void testPreviewAssessmentRemovals2() {
    // Arrange
    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();
    assessmentRatingList.add(mock(AssessmentRating.class));
    AssessmentRatingService assessmentRatingService = mock(AssessmentRatingService.class);
    when(assessmentRatingService.findByTargetKindForRelatedSelector(Mockito.<EntityKind>any(),
        Mockito.<IdSelectionOptions>any())).thenReturn(assessmentRatingList);
    TaxonomyManagementHelper taxonomyManagementHelper = new TaxonomyManagementHelper(mock(BookmarkService.class),
        mock(EntityRelationshipService.class), mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        mock(MeasurableRatingService.class), mock(MeasurableService.class), mock(EntityNamedNoteService.class),
        assessmentRatingService);

    // Act
    taxonomyManagementHelper.previewAssessmentRemovals(ImmutableTaxonomyChangePreview.builder(), null);

    // Assert
    verify(assessmentRatingService).findByTargetKindForRelatedSelector(eq(EntityKind.MEASURABLE), isNull());
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#previewBookmarkRemovals(ImmutableTaxonomyChangePreview.Builder, IdSelectionOptions)}
   */
  @Test
  void testPreviewBookmarkRemovals() {
    // Arrange
    BookmarkService bookmarkService = mock(BookmarkService.class);
    when(bookmarkService.findByBookmarkIdSelector(Mockito.<IdSelectionOptions>any())).thenReturn(new HashSet<>());
    TaxonomyManagementHelper taxonomyManagementHelper = new TaxonomyManagementHelper(bookmarkService,
        mock(EntityRelationshipService.class), mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        mock(MeasurableRatingService.class), mock(MeasurableService.class), mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class));

    // Act
    taxonomyManagementHelper.previewBookmarkRemovals(ImmutableTaxonomyChangePreview.builder(), null);

    // Assert
    verify(bookmarkService).findByBookmarkIdSelector(isNull());
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#previewBookmarkRemovals(ImmutableTaxonomyChangePreview.Builder, IdSelectionOptions)}
   */
  @Test
  void testPreviewBookmarkRemovals2() {
    // Arrange
    HashSet<Bookmark> bookmarkSet = new HashSet<>();
    bookmarkSet.add(mock(Bookmark.class));
    BookmarkService bookmarkService = mock(BookmarkService.class);
    when(bookmarkService.findByBookmarkIdSelector(Mockito.<IdSelectionOptions>any())).thenReturn(bookmarkSet);
    TaxonomyManagementHelper taxonomyManagementHelper = new TaxonomyManagementHelper(bookmarkService,
        mock(EntityRelationshipService.class), mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        mock(MeasurableRatingService.class), mock(MeasurableService.class), mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class));

    // Act
    taxonomyManagementHelper.previewBookmarkRemovals(ImmutableTaxonomyChangePreview.builder(), null);

    // Assert
    verify(bookmarkService).findByBookmarkIdSelector(isNull());
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#previewAppMappingRemovals(ImmutableTaxonomyChangePreview.Builder, IdSelectionOptions)}
   */
  @Test
  void testPreviewAppMappingRemovals() {
    // Arrange
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    TaxonomyManagementHelper taxonomyManagementHelper = new TaxonomyManagementHelper(mock(BookmarkService.class),
        mock(EntityRelationshipService.class), mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        measurableRatingService, mock(MeasurableService.class), mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class));

    // Act
    taxonomyManagementHelper.previewAppMappingRemovals(ImmutableTaxonomyChangePreview.builder(), null);

    // Assert
    verify(measurableRatingService).findByMeasurableIdSelector(isNull());
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#previewAppMappingRemovals(ImmutableTaxonomyChangePreview.Builder, IdSelectionOptions)}
   */
  @Test
  void testPreviewAppMappingRemovals2() {
    // Arrange
    ArrayList<MeasurableRating> measurableRatingList = new ArrayList<>();
    measurableRatingList.add(mock(MeasurableRating.class));
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(measurableRatingList);
    TaxonomyManagementHelper taxonomyManagementHelper = new TaxonomyManagementHelper(mock(BookmarkService.class),
        mock(EntityRelationshipService.class), mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        measurableRatingService, mock(MeasurableService.class), mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class));

    // Act
    taxonomyManagementHelper.previewAppMappingRemovals(ImmutableTaxonomyChangePreview.builder(), null);

    // Assert
    verify(measurableRatingService).findByMeasurableIdSelector(isNull());
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#previewChildNodeRemovals(ImmutableTaxonomyChangePreview.Builder, IdSelectionOptions)}
   */
  @Test
  void testPreviewChildNodeRemovals() {
    // Arrange
    Measurable measurable = mock(Measurable.class);
    when(measurable.entityReference()).thenReturn(null);

    ArrayList<Measurable> measurableList = new ArrayList<>();
    measurableList.add(measurable);
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any())).thenReturn(measurableList);
    TaxonomyManagementHelper taxonomyManagementHelper = new TaxonomyManagementHelper(mock(BookmarkService.class),
        mock(EntityRelationshipService.class), mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        mock(MeasurableRatingService.class), measurableService, mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class));
    ImmutableTaxonomyChangePreview.Builder preview = ImmutableTaxonomyChangePreview.builder();
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(null);

    // Act
    taxonomyManagementHelper.previewChildNodeRemovals(preview, selectionOptions);

    // Assert
    verify(selectionOptions).entityReference();
    verify(measurable).entityReference();
    verify(measurableService).findByMeasurableIdSelector(isA(IdSelectionOptions.class));
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#previewChildNodeRemovals(ImmutableTaxonomyChangePreview.Builder, IdSelectionOptions)}
   */
  @Test
  void testPreviewChildNodeRemovals2() {
    // Arrange
    Measurable measurable = mock(Measurable.class);
    when(measurable.entityReference()).thenReturn(mock(EntityReference.class));

    ArrayList<Measurable> measurableList = new ArrayList<>();
    measurableList.add(measurable);
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any())).thenReturn(measurableList);
    TaxonomyManagementHelper taxonomyManagementHelper = new TaxonomyManagementHelper(mock(BookmarkService.class),
        mock(EntityRelationshipService.class), mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        mock(MeasurableRatingService.class), measurableService, mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class));
    ImmutableTaxonomyChangePreview.Builder preview = ImmutableTaxonomyChangePreview.builder();
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(null);

    // Act
    taxonomyManagementHelper.previewChildNodeRemovals(preview, selectionOptions);

    // Assert
    verify(selectionOptions).entityReference();
    verify(measurable).entityReference();
    verify(measurableService).findByMeasurableIdSelector(isA(IdSelectionOptions.class));
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#previewChildNodeMigrations(ImmutableTaxonomyChangePreview.Builder, IdSelectionOptions)}
   */
  @Test
  void testPreviewChildNodeMigrations() {
    // Arrange
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any())).thenReturn(new ArrayList<>());
    TaxonomyManagementHelper taxonomyManagementHelper = new TaxonomyManagementHelper(mock(BookmarkService.class),
        mock(EntityRelationshipService.class), mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        mock(MeasurableRatingService.class), measurableService, mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class));
    ImmutableTaxonomyChangePreview.Builder preview = ImmutableTaxonomyChangePreview.builder();
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(selectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(mock(SelectionFilters.class));
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(mock(EntityReference.class));

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
   * Method under test:
   * {@link TaxonomyManagementHelper#previewChildNodeMigrations(ImmutableTaxonomyChangePreview.Builder, IdSelectionOptions)}
   */
  @Test
  void testPreviewChildNodeMigrations2() {
    // Arrange
    Measurable measurable = mock(Measurable.class);
    when(measurable.entityReference()).thenReturn(null);

    ArrayList<Measurable> measurableList = new ArrayList<>();
    measurableList.add(measurable);
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any())).thenReturn(measurableList);
    TaxonomyManagementHelper taxonomyManagementHelper = new TaxonomyManagementHelper(mock(BookmarkService.class),
        mock(EntityRelationshipService.class), mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        mock(MeasurableRatingService.class), measurableService, mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class));
    ImmutableTaxonomyChangePreview.Builder preview = ImmutableTaxonomyChangePreview.builder();
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(selectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(mock(SelectionFilters.class));
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    taxonomyManagementHelper.previewChildNodeMigrations(preview, selectionOptions);

    // Assert
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    verify(measurable).entityReference();
    verify(measurableService).findByMeasurableIdSelector(isA(IdSelectionOptions.class));
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#previewChildNodeMigrations(ImmutableTaxonomyChangePreview.Builder, IdSelectionOptions)}
   */
  @Test
  void testPreviewChildNodeMigrations3() {
    // Arrange
    Measurable measurable = mock(Measurable.class);
    when(measurable.entityReference()).thenReturn(null);

    ArrayList<Measurable> measurableList = new ArrayList<>();
    measurableList.add(measurable);
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.findByMeasurableIdSelector(Mockito.<IdSelectionOptions>any())).thenReturn(measurableList);
    TaxonomyManagementHelper taxonomyManagementHelper = new TaxonomyManagementHelper(mock(BookmarkService.class),
        mock(EntityRelationshipService.class), mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        mock(MeasurableRatingService.class), measurableService, mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class));
    ImmutableTaxonomyChangePreview.Builder preview = ImmutableTaxonomyChangePreview.builder();
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(selectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(mock(SelectionFilters.class));
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
    when(selectionOptions.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    taxonomyManagementHelper.previewChildNodeMigrations(preview, selectionOptions);

    // Assert
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    verify(measurable).entityReference();
    verify(measurableService).findByMeasurableIdSelector(isA(IdSelectionOptions.class));
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#previewRatingMigrations(ImmutableTaxonomyChangePreview.Builder, Long, Long)}
   */
  @Test
  void testPreviewRatingMigrations() {
    // Arrange
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.getSharedRatingsCount(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(3);
    TaxonomyManagementHelper taxonomyManagementHelper = new TaxonomyManagementHelper(mock(BookmarkService.class),
        mock(EntityRelationshipService.class), mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        measurableRatingService, mock(MeasurableService.class), mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class));

    // Act
    taxonomyManagementHelper.previewRatingMigrations(ImmutableTaxonomyChangePreview.builder(), 1L, 1L);

    // Assert
    verify(measurableRatingService).getSharedRatingsCount(eq(1L), eq(1L));
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#previewRatingMigrations(ImmutableTaxonomyChangePreview.Builder, Long, Long)}
   */
  @Test
  void testPreviewRatingMigrations2() {
    // Arrange
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.getSharedRatingsCount(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(0);
    TaxonomyManagementHelper taxonomyManagementHelper = new TaxonomyManagementHelper(mock(BookmarkService.class),
        mock(EntityRelationshipService.class), mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        measurableRatingService, mock(MeasurableService.class), mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class));

    // Act
    taxonomyManagementHelper.previewRatingMigrations(ImmutableTaxonomyChangePreview.builder(), 1L, 1L);

    // Assert
    verify(measurableRatingService).getSharedRatingsCount(eq(1L), eq(1L));
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#previewDecommMigrations(ImmutableTaxonomyChangePreview.Builder, Long, Long)}
   */
  @Test
  void testPreviewDecommMigrations() {
    // Arrange
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.getSharedDecommsCount(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(3);
    TaxonomyManagementHelper taxonomyManagementHelper = new TaxonomyManagementHelper(mock(BookmarkService.class),
        mock(EntityRelationshipService.class), mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        measurableRatingService, mock(MeasurableService.class), mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class));

    // Act
    taxonomyManagementHelper.previewDecommMigrations(ImmutableTaxonomyChangePreview.builder(), 1L, 1L);

    // Assert
    verify(measurableRatingService).getSharedDecommsCount(eq(1L), eq(1L));
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#previewDecommMigrations(ImmutableTaxonomyChangePreview.Builder, Long, Long)}
   */
  @Test
  void testPreviewDecommMigrations2() {
    // Arrange
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.getSharedDecommsCount(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(0);
    TaxonomyManagementHelper taxonomyManagementHelper = new TaxonomyManagementHelper(mock(BookmarkService.class),
        mock(EntityRelationshipService.class), mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        measurableRatingService, mock(MeasurableService.class), mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class));

    // Act
    taxonomyManagementHelper.previewDecommMigrations(ImmutableTaxonomyChangePreview.builder(), 1L, 1L);

    // Assert
    verify(measurableRatingService).getSharedDecommsCount(eq(1L), eq(1L));
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#migrateMeasurable(IdSelectionOptions, Long, String)}
   */
  @Test
  void testMigrateMeasurable() {
    // Arrange
    EntityRelationshipService entityRelationshipService = mock(EntityRelationshipService.class);
    doNothing().when(entityRelationshipService)
        .migrateEntityRelationships(Mockito.<EntityReference>any(), Mockito.<EntityReference>any(),
            Mockito.<String>any());
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    doNothing().when(measurableRatingService)
        .migrateRatings(Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any());
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.moveChildren(Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(measurableService.deleteByIdSelector(Mockito.<IdSelectionOptions>any())).thenReturn(1);
    TaxonomyManagementHelper taxonomyManagementHelper = new TaxonomyManagementHelper(mock(BookmarkService.class),
        entityRelationshipService, mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        measurableRatingService, measurableService, mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    taxonomyManagementHelper.migrateMeasurable(selectionOptions, 1L, "42");

    // Assert
    verify(entityReference, atLeast(1)).id();
    verify(selectionOptions).entityReference();
    verify(entityRelationshipService).migrateEntityRelationships(isA(EntityReference.class), isA(EntityReference.class),
        eq("42"));
    verify(measurableService).deleteByIdSelector(isA(IdSelectionOptions.class));
    verify(measurableService).moveChildren(eq(1L), eq(1L), eq("42"));
    verify(measurableRatingService).migrateRatings(eq(1L), eq(1L), eq("42"));
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#removeEntityRelationshipsDiagrams(IdSelectionOptions)}
   */
  @Test
  void testRemoveEntityRelationshipsDiagrams() {
    // Arrange
    EntityRelationshipService entityRelationshipService = mock(EntityRelationshipService.class);
    when(entityRelationshipService.deleteForGenericEntitySelector(Mockito.<IdSelectionOptions>any())).thenReturn(1);

    // Act
    int actualRemoveEntityRelationshipsDiagramsResult = (new TaxonomyManagementHelper(mock(BookmarkService.class),
        entityRelationshipService, mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        mock(MeasurableRatingService.class), mock(MeasurableService.class), mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class))).removeEntityRelationshipsDiagrams(null);

    // Assert
    verify(entityRelationshipService).deleteForGenericEntitySelector(isNull());
    assertEquals(1, actualRemoveEntityRelationshipsDiagramsResult);
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#removeFlowDiagrams(IdSelectionOptions)}
   */
  @Test
  void testRemoveFlowDiagrams() {
    // Arrange
    FlowDiagramEntityService flowDiagramEntityService = mock(FlowDiagramEntityService.class);
    when(flowDiagramEntityService.deleteForEntitySelector(Mockito.<IdSelectionOptions>any())).thenReturn(1);

    // Act
    int actualRemoveFlowDiagramsResult = (new TaxonomyManagementHelper(mock(BookmarkService.class),
        mock(EntityRelationshipService.class), flowDiagramEntityService, mock(InvolvementService.class),
        mock(MeasurableRatingService.class), mock(MeasurableService.class), mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class))).removeFlowDiagrams(null);

    // Assert
    verify(flowDiagramEntityService).deleteForEntitySelector(isNull());
    assertEquals(1, actualRemoveFlowDiagramsResult);
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#removeMeasurables(IdSelectionOptions)}
   */
  @Test
  void testRemoveMeasurables() {
    // Arrange
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.deleteByIdSelector(Mockito.<IdSelectionOptions>any())).thenReturn(1);

    // Act
    int actualRemoveMeasurablesResult = (new TaxonomyManagementHelper(mock(BookmarkService.class),
        mock(EntityRelationshipService.class), mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        mock(MeasurableRatingService.class), measurableService, mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class))).removeMeasurables(null);

    // Assert
    verify(measurableService).deleteByIdSelector(isNull());
    assertEquals(1, actualRemoveMeasurablesResult);
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#removeAppMappings(IdSelectionOptions)}
   */
  @Test
  void testRemoveAppMappings() {
    // Arrange
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.deleteByMeasurableIdSelector(Mockito.<IdSelectionOptions>any())).thenReturn(1);

    // Act
    int actualRemoveAppMappingsResult = (new TaxonomyManagementHelper(mock(BookmarkService.class),
        mock(EntityRelationshipService.class), mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        measurableRatingService, mock(MeasurableService.class), mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class))).removeAppMappings(null);

    // Assert
    verify(measurableRatingService).deleteByMeasurableIdSelector(isNull());
    assertEquals(1, actualRemoveAppMappingsResult);
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#removeInvolvements(IdSelectionOptions)}
   */
  @Test
  void testRemoveInvolvements() {
    // Arrange
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.deleteByGenericEntitySelector(Mockito.<IdSelectionOptions>any())).thenReturn(1);

    // Act
    int actualRemoveInvolvementsResult = (new TaxonomyManagementHelper(mock(BookmarkService.class),
        mock(EntityRelationshipService.class), mock(FlowDiagramEntityService.class), involvementService,
        mock(MeasurableRatingService.class), mock(MeasurableService.class), mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class))).removeInvolvements(null);

    // Assert
    verify(involvementService).deleteByGenericEntitySelector(isNull());
    assertEquals(1, actualRemoveInvolvementsResult);
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#removeBookmarks(IdSelectionOptions)}
   */
  @Test
  void testRemoveBookmarks() {
    // Arrange
    BookmarkService bookmarkService = mock(BookmarkService.class);
    when(bookmarkService.deleteByBookmarkIdSelector(Mockito.<IdSelectionOptions>any())).thenReturn(1);

    // Act
    int actualRemoveBookmarksResult = (new TaxonomyManagementHelper(bookmarkService,
        mock(EntityRelationshipService.class), mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        mock(MeasurableRatingService.class), mock(MeasurableService.class), mock(EntityNamedNoteService.class),
        mock(AssessmentRatingService.class))).removeBookmarks(null);

    // Assert
    verify(bookmarkService).deleteByBookmarkIdSelector(isNull());
    assertEquals(1, actualRemoveBookmarksResult);
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#removeAssessments(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testRemoveAssessments() {
    // Arrange
    AssessmentRatingService assessmentRatingService = mock(AssessmentRatingService.class);
    when(assessmentRatingService.deleteByAssessmentRatingRelatedSelector(Mockito.<EntityKind>any(),
        Mockito.<IdSelectionOptions>any())).thenReturn(1);

    // Act
    int actualRemoveAssessmentsResult = (new TaxonomyManagementHelper(mock(BookmarkService.class),
        mock(EntityRelationshipService.class), mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        mock(MeasurableRatingService.class), mock(MeasurableService.class), mock(EntityNamedNoteService.class),
        assessmentRatingService)).removeAssessments(EntityKind.ALL, null);

    // Assert
    verify(assessmentRatingService).deleteByAssessmentRatingRelatedSelector(eq(EntityKind.ALL), isNull());
    assertEquals(1, actualRemoveAssessmentsResult);
  }

  /**
   * Method under test:
   * {@link TaxonomyManagementHelper#removeNamedNotes(IdSelectionOptions)}
   */
  @Test
  void testRemoveNamedNotes() {
    // Arrange
    EntityNamedNoteService entityNamedNoteService = mock(EntityNamedNoteService.class);
    when(entityNamedNoteService.deleteByNamedNoteParentSelector(Mockito.<IdSelectionOptions>any())).thenReturn(1);

    // Act
    int actualRemoveNamedNotesResult = (new TaxonomyManagementHelper(mock(BookmarkService.class),
        mock(EntityRelationshipService.class), mock(FlowDiagramEntityService.class), mock(InvolvementService.class),
        mock(MeasurableRatingService.class), mock(MeasurableService.class), entityNamedNoteService,
        mock(AssessmentRatingService.class))).removeNamedNotes(null);

    // Assert
    verify(entityNamedNoteService).deleteByNamedNoteParentSelector(isNull());
    assertEquals(1, actualRemoveNamedNotesResult);
  }
}
