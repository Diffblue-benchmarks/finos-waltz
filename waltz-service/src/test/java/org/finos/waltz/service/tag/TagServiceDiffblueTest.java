package org.finos.waltz.service.tag;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.tag.TagDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.tag.Tag;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TagServiceDiffblueTest {
  /**
   * Method under test:
   * {@link TagService#findTagsForEntityReference(EntityReference)}
   */
  @Test
  void testFindTagsForEntityReference() {
    // Arrange
    TagDao tagDao = mock(TagDao.class);
    ArrayList<Tag> tagList = new ArrayList<>();
    when(tagDao.findTagsForEntityReference(Mockito.<EntityReference>any())).thenReturn(tagList);

    // Act
    List<Tag> actualFindTagsForEntityReferenceResult = (new TagService(tagDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findTagsForEntityReference(null);

    // Assert
    verify(tagDao).findTagsForEntityReference(isNull());
    assertTrue(actualFindTagsForEntityReferenceResult.isEmpty());
    assertSame(tagList, actualFindTagsForEntityReferenceResult);
  }

  /**
   * Method under test: {@link TagService#findTagsForEntityKind(EntityKind)}
   */
  @Test
  void testFindTagsForEntityKind() {
    // Arrange
    TagDao tagDao = mock(TagDao.class);
    ArrayList<Tag> tagList = new ArrayList<>();
    when(tagDao.findTagsForEntityKind(Mockito.<EntityKind>any())).thenReturn(tagList);

    // Act
    List<Tag> actualFindTagsForEntityKindResult = (new TagService(tagDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findTagsForEntityKind(EntityKind.ALL);

    // Assert
    verify(tagDao).findTagsForEntityKind(eq(EntityKind.ALL));
    assertTrue(actualFindTagsForEntityKindResult.isEmpty());
    assertSame(tagList, actualFindTagsForEntityKindResult);
  }

  /**
   * Method under test:
   * {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindTagsForEntityKindAndTargetSelector() {
    // Arrange
    TagDao tagDao = mock(TagDao.class);
    ArrayList<Tag> tagList = new ArrayList<>();
    when(tagDao.findTagsForEntityKindAndTargetSelector(Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(tagList);
    TagService tagService = new TagService(tagDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions targetEntityIdSelectionOptions = mock(IdSelectionOptions.class);
    when(targetEntityIdSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(targetEntityIdSelectionOptions.filters()).thenReturn(selectionFilters);
    when(targetEntityIdSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    List<Tag> actualFindTagsForEntityKindAndTargetSelectorResult = tagService
        .findTagsForEntityKindAndTargetSelector(EntityKind.APPLICATION, targetEntityIdSelectionOptions);

    // Assert
    verify(tagDao).findTagsForEntityKindAndTargetSelector(eq(EntityKind.APPLICATION), isA(Select.class));
    verify(entityReference).kind();
    verify(targetEntityIdSelectionOptions).entityLifecycleStatuses();
    verify(targetEntityIdSelectionOptions).entityReference();
    verify(targetEntityIdSelectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindTagsForEntityKindAndTargetSelectorResult.isEmpty());
    assertSame(tagList, actualFindTagsForEntityKindAndTargetSelectorResult);
  }

  /**
   * Method under test:
   * {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindTagsForEntityKindAndTargetSelector2() {
    // Arrange
    TagDao tagDao = mock(TagDao.class);
    ArrayList<Tag> tagList = new ArrayList<>();
    when(tagDao.findTagsForEntityKindAndTargetSelector(Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(tagList);
    TagService tagService = new TagService(tagDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<ApplicationKind> applicationKindSet = new HashSet<>();
    applicationKindSet.add(ApplicationKind.IN_HOUSE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(applicationKindSet);
    IdSelectionOptions targetEntityIdSelectionOptions = mock(IdSelectionOptions.class);
    when(targetEntityIdSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(targetEntityIdSelectionOptions.filters()).thenReturn(selectionFilters);
    when(targetEntityIdSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    List<Tag> actualFindTagsForEntityKindAndTargetSelectorResult = tagService
        .findTagsForEntityKindAndTargetSelector(EntityKind.APPLICATION, targetEntityIdSelectionOptions);

    // Assert
    verify(tagDao).findTagsForEntityKindAndTargetSelector(eq(EntityKind.APPLICATION), isA(Select.class));
    verify(entityReference).kind();
    verify(targetEntityIdSelectionOptions).entityLifecycleStatuses();
    verify(targetEntityIdSelectionOptions).entityReference();
    verify(targetEntityIdSelectionOptions, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertTrue(actualFindTagsForEntityKindAndTargetSelectorResult.isEmpty());
    assertSame(tagList, actualFindTagsForEntityKindAndTargetSelectorResult);
  }

  /**
   * Method under test:
   * {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindTagsForEntityKindAndTargetSelector3() {
    // Arrange
    TagDao tagDao = mock(TagDao.class);
    ArrayList<Tag> tagList = new ArrayList<>();
    when(tagDao.findTagsForEntityKindAndTargetSelector(Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(tagList);
    TagService tagService = new TagService(tagDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions targetEntityIdSelectionOptions = mock(IdSelectionOptions.class);
    when(targetEntityIdSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(targetEntityIdSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(targetEntityIdSelectionOptions.filters()).thenReturn(selectionFilters);
    when(targetEntityIdSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    List<Tag> actualFindTagsForEntityKindAndTargetSelectorResult = tagService
        .findTagsForEntityKindAndTargetSelector(EntityKind.APPLICATION, targetEntityIdSelectionOptions);

    // Assert
    verify(tagDao).findTagsForEntityKindAndTargetSelector(eq(EntityKind.APPLICATION), isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(targetEntityIdSelectionOptions).entityLifecycleStatuses();
    verify(targetEntityIdSelectionOptions, atLeast(1)).entityReference();
    verify(targetEntityIdSelectionOptions).filters();
    verify(targetEntityIdSelectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindTagsForEntityKindAndTargetSelectorResult.isEmpty());
    assertSame(tagList, actualFindTagsForEntityKindAndTargetSelectorResult);
  }

  /**
   * Method under test:
   * {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindTagsForEntityKindAndTargetSelector4() {
    // Arrange
    TagDao tagDao = mock(TagDao.class);
    ArrayList<Tag> tagList = new ArrayList<>();
    when(tagDao.findTagsForEntityKindAndTargetSelector(Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(tagList);
    TagService tagService = new TagService(tagDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions targetEntityIdSelectionOptions = mock(IdSelectionOptions.class);
    when(targetEntityIdSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(targetEntityIdSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    List<Tag> actualFindTagsForEntityKindAndTargetSelectorResult = tagService
        .findTagsForEntityKindAndTargetSelector(EntityKind.APPLICATION, targetEntityIdSelectionOptions);

    // Assert
    verify(tagDao).findTagsForEntityKindAndTargetSelector(eq(EntityKind.APPLICATION), isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(targetEntityIdSelectionOptions, atLeast(1)).entityReference();
    verify(targetEntityIdSelectionOptions).scope();
    assertTrue(actualFindTagsForEntityKindAndTargetSelectorResult.isEmpty());
    assertSame(tagList, actualFindTagsForEntityKindAndTargetSelectorResult);
  }

  /**
   * Method under test:
   * {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindTagsForEntityKindAndTargetSelector5() {
    // Arrange
    TagDao tagDao = mock(TagDao.class);
    ArrayList<Tag> tagList = new ArrayList<>();
    when(tagDao.findTagsForEntityKindAndTargetSelector(Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(tagList);
    TagService tagService = new TagService(tagDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions targetEntityIdSelectionOptions = mock(IdSelectionOptions.class);
    when(targetEntityIdSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(targetEntityIdSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(targetEntityIdSelectionOptions.filters()).thenReturn(selectionFilters);
    when(targetEntityIdSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    List<Tag> actualFindTagsForEntityKindAndTargetSelectorResult = tagService
        .findTagsForEntityKindAndTargetSelector(EntityKind.APPLICATION, targetEntityIdSelectionOptions);

    // Assert
    verify(tagDao).findTagsForEntityKindAndTargetSelector(eq(EntityKind.APPLICATION), isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference).kind();
    verify(targetEntityIdSelectionOptions).entityLifecycleStatuses();
    verify(targetEntityIdSelectionOptions, atLeast(1)).entityReference();
    verify(targetEntityIdSelectionOptions).filters();
    verify(targetEntityIdSelectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindTagsForEntityKindAndTargetSelectorResult.isEmpty());
    assertSame(tagList, actualFindTagsForEntityKindAndTargetSelectorResult);
  }

  /**
   * Method under test:
   * {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindTagsForEntityKindAndTargetSelector6() {
    // Arrange
    TagDao tagDao = mock(TagDao.class);
    ArrayList<Tag> tagList = new ArrayList<>();
    when(tagDao.findTagsForEntityKindAndTargetSelector(Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(tagList);
    TagService tagService = new TagService(tagDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions targetEntityIdSelectionOptions = mock(IdSelectionOptions.class);
    when(targetEntityIdSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(targetEntityIdSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(targetEntityIdSelectionOptions.filters()).thenReturn(selectionFilters);
    when(targetEntityIdSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    List<Tag> actualFindTagsForEntityKindAndTargetSelectorResult = tagService
        .findTagsForEntityKindAndTargetSelector(EntityKind.ATTESTATION, targetEntityIdSelectionOptions);

    // Assert
    verify(tagDao).findTagsForEntityKindAndTargetSelector(eq(EntityKind.ATTESTATION), isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(targetEntityIdSelectionOptions).entityLifecycleStatuses();
    verify(targetEntityIdSelectionOptions, atLeast(1)).entityReference();
    verify(targetEntityIdSelectionOptions).filters();
    verify(targetEntityIdSelectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindTagsForEntityKindAndTargetSelectorResult.isEmpty());
    assertSame(tagList, actualFindTagsForEntityKindAndTargetSelectorResult);
  }

  /**
   * Method under test:
   * {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindTagsForEntityKindAndTargetSelector7() {
    // Arrange
    TagDao tagDao = mock(TagDao.class);
    ArrayList<Tag> tagList = new ArrayList<>();
    when(tagDao.findTagsForEntityKindAndTargetSelector(Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(tagList);
    TagService tagService = new TagService(tagDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions targetEntityIdSelectionOptions = mock(IdSelectionOptions.class);
    when(targetEntityIdSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    List<Tag> actualFindTagsForEntityKindAndTargetSelectorResult = tagService
        .findTagsForEntityKindAndTargetSelector(EntityKind.CHANGE_INITIATIVE, targetEntityIdSelectionOptions);

    // Assert
    verify(tagDao).findTagsForEntityKindAndTargetSelector(eq(EntityKind.CHANGE_INITIATIVE), isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(targetEntityIdSelectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindTagsForEntityKindAndTargetSelectorResult.isEmpty());
    assertSame(tagList, actualFindTagsForEntityKindAndTargetSelectorResult);
  }

  /**
   * Method under test:
   * {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindTagsForEntityKindAndTargetSelector8() {
    // Arrange
    TagDao tagDao = mock(TagDao.class);
    ArrayList<Tag> tagList = new ArrayList<>();
    when(tagDao.findTagsForEntityKindAndTargetSelector(Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(tagList);
    TagService tagService = new TagService(tagDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions targetEntityIdSelectionOptions = mock(IdSelectionOptions.class);
    when(targetEntityIdSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    List<Tag> actualFindTagsForEntityKindAndTargetSelectorResult = tagService
        .findTagsForEntityKindAndTargetSelector(EntityKind.CHANGE_INITIATIVE, targetEntityIdSelectionOptions);

    // Assert
    verify(tagDao).findTagsForEntityKindAndTargetSelector(eq(EntityKind.CHANGE_INITIATIVE), isA(Select.class));
    verify(entityReference, atLeast(1)).kind();
    verify(targetEntityIdSelectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindTagsForEntityKindAndTargetSelectorResult.isEmpty());
    assertSame(tagList, actualFindTagsForEntityKindAndTargetSelectorResult);
  }

  /**
   * Method under test:
   * {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindTagsForEntityKindAndTargetSelector9() {
    // Arrange
    TagDao tagDao = mock(TagDao.class);
    ArrayList<Tag> tagList = new ArrayList<>();
    when(tagDao.findTagsForEntityKindAndTargetSelector(Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(tagList);
    TagService tagService = new TagService(tagDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions targetEntityIdSelectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(targetEntityIdSelectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(targetEntityIdSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(targetEntityIdSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(targetEntityIdSelectionOptions.filters()).thenReturn(mock(SelectionFilters.class));
    when(targetEntityIdSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    List<Tag> actualFindTagsForEntityKindAndTargetSelectorResult = tagService
        .findTagsForEntityKindAndTargetSelector(EntityKind.CHANGE_INITIATIVE, targetEntityIdSelectionOptions);

    // Assert
    verify(tagDao).findTagsForEntityKindAndTargetSelector(eq(EntityKind.CHANGE_INITIATIVE), isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(targetEntityIdSelectionOptions).entityLifecycleStatuses();
    verify(targetEntityIdSelectionOptions, atLeast(1)).entityReference();
    verify(targetEntityIdSelectionOptions).filters();
    verify(targetEntityIdSelectionOptions).joiningEntityKind();
    verify(targetEntityIdSelectionOptions).scope();
    assertTrue(actualFindTagsForEntityKindAndTargetSelectorResult.isEmpty());
    assertSame(tagList, actualFindTagsForEntityKindAndTargetSelectorResult);
  }

  /**
   * Method under test:
   * {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindTagsForEntityKindAndTargetSelector10() {
    // Arrange
    TagDao tagDao = mock(TagDao.class);
    ArrayList<Tag> tagList = new ArrayList<>();
    when(tagDao.findTagsForEntityKindAndTargetSelector(Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(tagList);
    TagService tagService = new TagService(tagDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions targetEntityIdSelectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(targetEntityIdSelectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(targetEntityIdSelectionOptions.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
    when(targetEntityIdSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(targetEntityIdSelectionOptions.filters()).thenReturn(mock(SelectionFilters.class));
    when(targetEntityIdSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    List<Tag> actualFindTagsForEntityKindAndTargetSelectorResult = tagService
        .findTagsForEntityKindAndTargetSelector(EntityKind.CHANGE_INITIATIVE, targetEntityIdSelectionOptions);

    // Assert
    verify(tagDao).findTagsForEntityKindAndTargetSelector(eq(EntityKind.CHANGE_INITIATIVE), isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(targetEntityIdSelectionOptions).entityLifecycleStatuses();
    verify(targetEntityIdSelectionOptions, atLeast(1)).entityReference();
    verify(targetEntityIdSelectionOptions).filters();
    verify(targetEntityIdSelectionOptions).joiningEntityKind();
    verify(targetEntityIdSelectionOptions).scope();
    assertTrue(actualFindTagsForEntityKindAndTargetSelectorResult.isEmpty());
    assertSame(tagList, actualFindTagsForEntityKindAndTargetSelectorResult);
  }

  /**
   * Method under test: {@link TagService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    TagDao tagDao = mock(TagDao.class);
    when(tagDao.getById(anyLong())).thenReturn(null);

    // Act
    Tag actualById = (new TagService(tagDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))).getById(1L);

    // Assert
    verify(tagDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test:
   * {@link TagService#updateTags(EntityReference, Collection, String)}
   */
  @Test
  void testUpdateTags() {
    // Arrange
    Tag tag = mock(Tag.class);
    when(tag.name()).thenReturn("Name");
    Tag tag2 = mock(Tag.class);
    when(tag2.name()).thenReturn("Name");
    Tag tag3 = mock(Tag.class);
    when(tag3.name()).thenReturn("Name");
    Tag tag4 = mock(Tag.class);
    when(tag4.name()).thenReturn("Name");
    Tag tag5 = mock(Tag.class);
    when(tag5.name()).thenReturn("Name");
    Tag tag6 = mock(Tag.class);
    when(tag6.name()).thenReturn("Name");
    Tag tag7 = mock(Tag.class);
    when(tag7.name()).thenReturn("Name");
    Tag tag8 = mock(Tag.class);
    when(tag8.name()).thenReturn("Name");
    Tag tag9 = mock(Tag.class);
    when(tag9.name()).thenReturn("Name");
    Tag tag10 = mock(Tag.class);
    when(tag10.name()).thenReturn("Name");
    Tag tag11 = mock(Tag.class);
    when(tag11.name()).thenReturn("Name");
    Tag tag12 = mock(Tag.class);
    when(tag12.name()).thenReturn("Name");
    Tag tag13 = mock(Tag.class);
    when(tag13.name()).thenReturn("Name");
    Tag tag14 = mock(Tag.class);
    when(tag14.name()).thenReturn("Name");
    Tag tag15 = mock(Tag.class);
    when(tag15.name()).thenReturn("Name");
    Tag tag16 = mock(Tag.class);
    when(tag16.name()).thenReturn("Name");
    Tag tag17 = mock(Tag.class);
    when(tag17.name()).thenReturn("Name");
    Tag tag18 = mock(Tag.class);
    when(tag18.name()).thenReturn("Name");
    Tag tag19 = mock(Tag.class);
    when(tag19.name()).thenReturn("Name");
    Tag tag20 = mock(Tag.class);
    when(tag20.name()).thenReturn("Name");
    Tag tag21 = mock(Tag.class);
    when(tag21.name()).thenReturn("Name");
    Tag tag22 = mock(Tag.class);
    when(tag22.name()).thenReturn("Name");
    Tag tag23 = mock(Tag.class);
    when(tag23.name()).thenReturn("Name");
    Tag tag24 = mock(Tag.class);
    when(tag24.name()).thenReturn("Name");
    Tag tag25 = mock(Tag.class);
    when(tag25.name()).thenReturn("Name");
    Tag tag26 = mock(Tag.class);
    when(tag26.name()).thenReturn("Name");
    Tag tag27 = mock(Tag.class);
    when(tag27.name()).thenReturn("Name");
    Tag tag28 = mock(Tag.class);
    when(tag28.name()).thenReturn("Name");
    Tag tag29 = mock(Tag.class);
    when(tag29.name()).thenReturn("Name");
    Tag tag30 = mock(Tag.class);
    when(tag30.name()).thenReturn("Name");
    Tag tag31 = mock(Tag.class);
    when(tag31.name()).thenReturn("Name");
    Tag tag32 = mock(Tag.class);
    when(tag32.name()).thenReturn("Name");
    Tag tag33 = mock(Tag.class);
    when(tag33.name()).thenReturn("Name");
    Tag tag34 = mock(Tag.class);
    when(tag34.name()).thenReturn("Name");
    Tag tag35 = mock(Tag.class);
    when(tag35.name()).thenReturn("Name");
    Tag tag36 = mock(Tag.class);
    when(tag36.name()).thenReturn("Name");
    Tag tag37 = mock(Tag.class);
    when(tag37.name()).thenReturn("Name");
    Tag tag38 = mock(Tag.class);
    when(tag38.name()).thenReturn("Name");
    Tag tag39 = mock(Tag.class);
    when(tag39.name()).thenReturn("Name");
    Tag tag40 = mock(Tag.class);
    when(tag40.name()).thenReturn("Name");
    Tag tag41 = mock(Tag.class);
    when(tag41.name()).thenReturn("Name");
    Tag tag42 = mock(Tag.class);
    when(tag42.name()).thenReturn("Name");
    Tag tag43 = mock(Tag.class);
    when(tag43.name()).thenReturn("Name");
    Tag tag44 = mock(Tag.class);
    when(tag44.name()).thenReturn("Name");
    Tag tag45 = mock(Tag.class);
    when(tag45.name()).thenReturn("Name");
    Tag tag46 = mock(Tag.class);
    when(tag46.name()).thenReturn("Name");
    Tag tag47 = mock(Tag.class);
    when(tag47.name()).thenReturn("Name");
    Tag tag48 = mock(Tag.class);
    when(tag48.name()).thenReturn("Name");
    Tag tag49 = mock(Tag.class);
    when(tag49.name()).thenReturn("Name");
    Tag tag50 = mock(Tag.class);
    when(tag50.name()).thenReturn("Name");
    Tag tag51 = mock(Tag.class);
    when(tag51.name()).thenReturn("Name");
    Tag tag52 = mock(Tag.class);
    when(tag52.name()).thenReturn("Name");
    Tag tag53 = mock(Tag.class);
    when(tag53.name()).thenReturn("Name");
    Tag tag54 = mock(Tag.class);
    when(tag54.name()).thenReturn("Name");
    Tag tag55 = mock(Tag.class);
    when(tag55.name()).thenReturn("Name");
    Tag tag56 = mock(Tag.class);
    when(tag56.name()).thenReturn("Name");
    Tag tag57 = mock(Tag.class);
    when(tag57.name()).thenReturn("Name");
    Tag tag58 = mock(Tag.class);
    when(tag58.name()).thenReturn("Name");
    Tag tag59 = mock(Tag.class);
    when(tag59.name()).thenReturn("Name");
    Tag tag60 = mock(Tag.class);
    when(tag60.name()).thenReturn("Name");
    Tag tag61 = mock(Tag.class);
    when(tag61.name()).thenReturn("Name");
    Tag tag62 = mock(Tag.class);
    when(tag62.name()).thenReturn("Name");
    Tag tag63 = mock(Tag.class);
    when(tag63.name()).thenReturn("Name");
    Tag tag64 = mock(Tag.class);
    when(tag64.name()).thenReturn("Name");
    Tag tag65 = mock(Tag.class);
    when(tag65.name()).thenReturn("Name");
    Tag tag66 = mock(Tag.class);
    when(tag66.name()).thenReturn("Name");
    Tag tag67 = mock(Tag.class);
    when(tag67.name()).thenReturn("Name");
    Tag tag68 = mock(Tag.class);
    when(tag68.name()).thenReturn("Name");
    Tag tag69 = mock(Tag.class);
    when(tag69.name()).thenReturn("Name");
    Tag tag70 = mock(Tag.class);
    when(tag70.name()).thenReturn("Name");
    Tag tag71 = mock(Tag.class);
    when(tag71.name()).thenReturn("Name");
    Tag tag72 = mock(Tag.class);
    when(tag72.name()).thenReturn("Name");
    Tag tag73 = mock(Tag.class);
    when(tag73.name()).thenReturn("Name");
    Tag tag74 = mock(Tag.class);
    when(tag74.name()).thenReturn("Name");
    Tag tag75 = mock(Tag.class);
    when(tag75.name()).thenReturn("Name");
    Tag tag76 = mock(Tag.class);
    when(tag76.name()).thenReturn("Name");
    Tag tag77 = mock(Tag.class);
    when(tag77.name()).thenReturn("Name");
    Tag tag78 = mock(Tag.class);
    when(tag78.name()).thenReturn("Name");
    Tag tag79 = mock(Tag.class);
    when(tag79.name()).thenReturn("Name");
    Tag tag80 = mock(Tag.class);
    when(tag80.name()).thenReturn("Name");
    Tag tag81 = mock(Tag.class);
    when(tag81.name()).thenReturn("Name");
    Tag tag82 = mock(Tag.class);
    when(tag82.name()).thenReturn("Name");
    Tag tag83 = mock(Tag.class);
    when(tag83.name()).thenReturn("Name");
    Tag tag84 = mock(Tag.class);
    when(tag84.name()).thenReturn("Name");
    Tag tag85 = mock(Tag.class);
    when(tag85.name()).thenReturn("Name");
    Tag tag86 = mock(Tag.class);
    when(tag86.name()).thenReturn("Name");
    Tag tag87 = mock(Tag.class);
    when(tag87.name()).thenReturn("Name");
    Tag tag88 = mock(Tag.class);
    when(tag88.name()).thenReturn("Name");
    Tag tag89 = mock(Tag.class);
    when(tag89.name()).thenReturn("Name");
    Tag tag90 = mock(Tag.class);
    when(tag90.name()).thenReturn("Name");
    Tag tag91 = mock(Tag.class);
    when(tag91.name()).thenReturn("Name");
    Tag tag92 = mock(Tag.class);
    when(tag92.name()).thenReturn("Name");
    Tag tag93 = mock(Tag.class);
    when(tag93.name()).thenReturn("Name");
    Tag tag94 = mock(Tag.class);
    when(tag94.name()).thenReturn("Name");
    Tag tag95 = mock(Tag.class);
    when(tag95.name()).thenReturn("Name");

    ArrayList<Tag> tagList = new ArrayList<>();
    tagList.add(tag95);
    tagList.add(tag94);
    tagList.add(tag93);
    tagList.add(tag92);
    tagList.add(tag91);
    tagList.add(tag90);
    tagList.add(tag89);
    tagList.add(tag88);
    tagList.add(tag87);
    tagList.add(tag86);
    tagList.add(tag85);
    tagList.add(tag84);
    tagList.add(tag83);
    tagList.add(tag82);
    tagList.add(tag81);
    tagList.add(tag80);
    tagList.add(tag79);
    tagList.add(tag78);
    tagList.add(tag77);
    tagList.add(tag76);
    tagList.add(tag75);
    tagList.add(tag74);
    tagList.add(tag73);
    tagList.add(tag72);
    tagList.add(tag71);
    tagList.add(tag70);
    tagList.add(tag69);
    tagList.add(tag68);
    tagList.add(tag67);
    tagList.add(tag66);
    tagList.add(tag65);
    tagList.add(tag64);
    tagList.add(tag63);
    tagList.add(tag62);
    tagList.add(tag61);
    tagList.add(tag60);
    tagList.add(tag59);
    tagList.add(tag58);
    tagList.add(tag57);
    tagList.add(tag56);
    tagList.add(tag55);
    tagList.add(tag54);
    tagList.add(tag53);
    tagList.add(tag52);
    tagList.add(tag51);
    tagList.add(tag50);
    tagList.add(tag49);
    tagList.add(tag48);
    tagList.add(tag47);
    tagList.add(tag46);
    tagList.add(tag45);
    tagList.add(tag44);
    tagList.add(tag43);
    tagList.add(tag42);
    tagList.add(tag41);
    tagList.add(tag40);
    tagList.add(tag39);
    tagList.add(tag38);
    tagList.add(tag37);
    tagList.add(tag36);
    tagList.add(tag35);
    tagList.add(tag34);
    tagList.add(tag33);
    tagList.add(tag32);
    tagList.add(tag31);
    tagList.add(tag30);
    tagList.add(tag29);
    tagList.add(tag28);
    tagList.add(tag27);
    tagList.add(tag26);
    tagList.add(tag25);
    tagList.add(tag24);
    tagList.add(tag23);
    tagList.add(tag22);
    tagList.add(tag21);
    tagList.add(tag20);
    tagList.add(tag19);
    tagList.add(tag18);
    tagList.add(tag17);
    tagList.add(tag16);
    tagList.add(tag15);
    tagList.add(tag14);
    tagList.add(tag13);
    tagList.add(tag12);
    tagList.add(tag11);
    tagList.add(tag10);
    tagList.add(tag9);
    tagList.add(tag8);
    tagList.add(tag7);
    tagList.add(tag6);
    tagList.add(tag5);
    tagList.add(tag4);
    tagList.add(tag3);
    tagList.add(tag2);
    tagList.add(tag);
    TagDao tagDao = mock(TagDao.class);
    doNothing().when(tagDao).removeTagUsage(Mockito.<EntityReference>any(), Mockito.<String>any());
    when(tagDao.findTagsForEntityReference(Mockito.<EntityReference>any())).thenReturn(tagList);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    doNothing().when(changeLogService)
        .writeChangeLogEntries(Mockito.<EntityReference>any(), Mockito.<String>any(), Mockito.<String>any(),
            Mockito.<Operation>any());
    TagService tagService = new TagService(tagDao, changeLogService);

    // Act
    List<Tag> actualUpdateTagsResult = tagService.updateTags(null, new ArrayList<>(), "janedoe");

    // Assert
    verify(tagDao, atLeast(1)).findTagsForEntityReference(isNull());
    verify(tagDao).removeTagUsage(isNull(), eq("Name"));
    verify(tag95).name();
    verify(tag94).name();
    verify(tag93).name();
    verify(tag92).name();
    verify(tag91).name();
    verify(tag90).name();
    verify(tag89).name();
    verify(tag88).name();
    verify(tag87).name();
    verify(tag86).name();
    verify(tag85).name();
    verify(tag84).name();
    verify(tag83).name();
    verify(tag82).name();
    verify(tag81).name();
    verify(tag80).name();
    verify(tag79).name();
    verify(tag78).name();
    verify(tag77).name();
    verify(tag76).name();
    verify(tag75).name();
    verify(tag74).name();
    verify(tag73).name();
    verify(tag72).name();
    verify(tag71).name();
    verify(tag70).name();
    verify(tag69).name();
    verify(tag68).name();
    verify(tag67).name();
    verify(tag66).name();
    verify(tag65).name();
    verify(tag64).name();
    verify(tag63).name();
    verify(tag62).name();
    verify(tag61).name();
    verify(tag60).name();
    verify(tag59).name();
    verify(tag58).name();
    verify(tag57).name();
    verify(tag56).name();
    verify(tag55).name();
    verify(tag54).name();
    verify(tag53).name();
    verify(tag52).name();
    verify(tag51).name();
    verify(tag50).name();
    verify(tag49).name();
    verify(tag48).name();
    verify(tag47).name();
    verify(tag46).name();
    verify(tag45).name();
    verify(tag44).name();
    verify(tag43).name();
    verify(tag42).name();
    verify(tag41).name();
    verify(tag40).name();
    verify(tag39).name();
    verify(tag38).name();
    verify(tag37).name();
    verify(tag36).name();
    verify(tag35).name();
    verify(tag34).name();
    verify(tag33).name();
    verify(tag32).name();
    verify(tag31).name();
    verify(tag30).name();
    verify(tag29).name();
    verify(tag28).name();
    verify(tag27).name();
    verify(tag26).name();
    verify(tag25).name();
    verify(tag24).name();
    verify(tag23).name();
    verify(tag22).name();
    verify(tag21).name();
    verify(tag20).name();
    verify(tag19).name();
    verify(tag18).name();
    verify(tag17).name();
    verify(tag16).name();
    verify(tag15).name();
    verify(tag14).name();
    verify(tag13).name();
    verify(tag12).name();
    verify(tag11).name();
    verify(tag10).name();
    verify(tag9).name();
    verify(tag8).name();
    verify(tag7).name();
    verify(tag6).name();
    verify(tag5).name();
    verify(tag4).name();
    verify(tag3).name();
    verify(tag2).name();
    verify(tag).name();
    verify(changeLogService).writeChangeLogEntries((EntityReference) isNull(), eq("janedoe"),
        eq("Removed tags: [Name]. "), eq(Operation.UPDATE));
    assertSame(tagList, actualUpdateTagsResult);
  }

  /**
   * Method under test:
   * {@link TagService#updateTags(EntityReference, Collection, String)}
   */
  @Test
  void testUpdateTags2() {
    // Arrange
    Tag tag = mock(Tag.class);
    when(tag.name()).thenReturn("Name");
    Tag tag2 = mock(Tag.class);
    when(tag2.name()).thenReturn("Name");
    Tag tag3 = mock(Tag.class);
    when(tag3.name()).thenReturn("Name");
    Tag tag4 = mock(Tag.class);
    when(tag4.name()).thenReturn("Name");
    Tag tag5 = mock(Tag.class);
    when(tag5.name()).thenReturn("Name");
    Tag tag6 = mock(Tag.class);
    when(tag6.name()).thenReturn("Name");
    Tag tag7 = mock(Tag.class);
    when(tag7.name()).thenReturn("Name");
    Tag tag8 = mock(Tag.class);
    when(tag8.name()).thenReturn("Name");
    Tag tag9 = mock(Tag.class);
    when(tag9.name()).thenReturn("Name");
    Tag tag10 = mock(Tag.class);
    when(tag10.name()).thenReturn("Name");
    Tag tag11 = mock(Tag.class);
    when(tag11.name()).thenReturn("Name");
    Tag tag12 = mock(Tag.class);
    when(tag12.name()).thenReturn("Name");
    Tag tag13 = mock(Tag.class);
    when(tag13.name()).thenReturn("Name");
    Tag tag14 = mock(Tag.class);
    when(tag14.name()).thenReturn("Name");
    Tag tag15 = mock(Tag.class);
    when(tag15.name()).thenReturn("Name");
    Tag tag16 = mock(Tag.class);
    when(tag16.name()).thenReturn("Name");
    Tag tag17 = mock(Tag.class);
    when(tag17.name()).thenReturn("Name");
    Tag tag18 = mock(Tag.class);
    when(tag18.name()).thenReturn("Name");
    Tag tag19 = mock(Tag.class);
    when(tag19.name()).thenReturn("Name");
    Tag tag20 = mock(Tag.class);
    when(tag20.name()).thenReturn("Name");
    Tag tag21 = mock(Tag.class);
    when(tag21.name()).thenReturn("Name");
    Tag tag22 = mock(Tag.class);
    when(tag22.name()).thenReturn("Name");
    Tag tag23 = mock(Tag.class);
    when(tag23.name()).thenReturn("Name");
    Tag tag24 = mock(Tag.class);
    when(tag24.name()).thenReturn("Name");
    Tag tag25 = mock(Tag.class);
    when(tag25.name()).thenReturn("Name");
    Tag tag26 = mock(Tag.class);
    when(tag26.name()).thenReturn("Name");
    Tag tag27 = mock(Tag.class);
    when(tag27.name()).thenReturn("Name");
    Tag tag28 = mock(Tag.class);
    when(tag28.name()).thenReturn("Name");
    Tag tag29 = mock(Tag.class);
    when(tag29.name()).thenReturn("Name");
    Tag tag30 = mock(Tag.class);
    when(tag30.name()).thenReturn("Name");
    Tag tag31 = mock(Tag.class);
    when(tag31.name()).thenReturn("Name");
    Tag tag32 = mock(Tag.class);
    when(tag32.name()).thenReturn("Name");
    Tag tag33 = mock(Tag.class);
    when(tag33.name()).thenReturn("Name");
    Tag tag34 = mock(Tag.class);
    when(tag34.name()).thenReturn("Name");
    Tag tag35 = mock(Tag.class);
    when(tag35.name()).thenReturn("Name");
    Tag tag36 = mock(Tag.class);
    when(tag36.name()).thenReturn("Name");
    Tag tag37 = mock(Tag.class);
    when(tag37.name()).thenReturn("Name");
    Tag tag38 = mock(Tag.class);
    when(tag38.name()).thenReturn("Name");
    Tag tag39 = mock(Tag.class);
    when(tag39.name()).thenReturn("Name");
    Tag tag40 = mock(Tag.class);
    when(tag40.name()).thenReturn("Name");
    Tag tag41 = mock(Tag.class);
    when(tag41.name()).thenReturn("Name");
    Tag tag42 = mock(Tag.class);
    when(tag42.name()).thenReturn("Name");
    Tag tag43 = mock(Tag.class);
    when(tag43.name()).thenReturn("Name");
    Tag tag44 = mock(Tag.class);
    when(tag44.name()).thenReturn("Name");
    Tag tag45 = mock(Tag.class);
    when(tag45.name()).thenReturn("Name");
    Tag tag46 = mock(Tag.class);
    when(tag46.name()).thenReturn("Name");
    Tag tag47 = mock(Tag.class);
    when(tag47.name()).thenReturn("Name");
    Tag tag48 = mock(Tag.class);
    when(tag48.name()).thenReturn("Name");
    Tag tag49 = mock(Tag.class);
    when(tag49.name()).thenReturn("Name");
    Tag tag50 = mock(Tag.class);
    when(tag50.name()).thenReturn("Name");
    Tag tag51 = mock(Tag.class);
    when(tag51.name()).thenReturn("Name");
    Tag tag52 = mock(Tag.class);
    when(tag52.name()).thenReturn("Name");
    Tag tag53 = mock(Tag.class);
    when(tag53.name()).thenReturn("Name");
    Tag tag54 = mock(Tag.class);
    when(tag54.name()).thenReturn("Name");
    Tag tag55 = mock(Tag.class);
    when(tag55.name()).thenReturn("Name");
    Tag tag56 = mock(Tag.class);
    when(tag56.name()).thenReturn("Name");
    Tag tag57 = mock(Tag.class);
    when(tag57.name()).thenReturn("Name");
    Tag tag58 = mock(Tag.class);
    when(tag58.name()).thenReturn("Name");
    Tag tag59 = mock(Tag.class);
    when(tag59.name()).thenReturn("Name");
    Tag tag60 = mock(Tag.class);
    when(tag60.name()).thenReturn("Name");
    Tag tag61 = mock(Tag.class);
    when(tag61.name()).thenReturn("Name");
    Tag tag62 = mock(Tag.class);
    when(tag62.name()).thenReturn("Name");
    Tag tag63 = mock(Tag.class);
    when(tag63.name()).thenReturn("Name");
    Tag tag64 = mock(Tag.class);
    when(tag64.name()).thenReturn("Name");
    Tag tag65 = mock(Tag.class);
    when(tag65.name()).thenReturn("Name");
    Tag tag66 = mock(Tag.class);
    when(tag66.name()).thenReturn("Name");
    Tag tag67 = mock(Tag.class);
    when(tag67.name()).thenReturn("Name");
    Tag tag68 = mock(Tag.class);
    when(tag68.name()).thenReturn("Name");
    Tag tag69 = mock(Tag.class);
    when(tag69.name()).thenReturn("Name");
    Tag tag70 = mock(Tag.class);
    when(tag70.name()).thenReturn("Name");
    Tag tag71 = mock(Tag.class);
    when(tag71.name()).thenReturn("Name");
    Tag tag72 = mock(Tag.class);
    when(tag72.name()).thenReturn("Name");
    Tag tag73 = mock(Tag.class);
    when(tag73.name()).thenReturn("Name");
    Tag tag74 = mock(Tag.class);
    when(tag74.name()).thenReturn("Name");
    Tag tag75 = mock(Tag.class);
    when(tag75.name()).thenReturn("Name");
    Tag tag76 = mock(Tag.class);
    when(tag76.name()).thenReturn("Name");
    Tag tag77 = mock(Tag.class);
    when(tag77.name()).thenReturn("Name");
    Tag tag78 = mock(Tag.class);
    when(tag78.name()).thenReturn("Name");
    Tag tag79 = mock(Tag.class);
    when(tag79.name()).thenReturn("Name");
    Tag tag80 = mock(Tag.class);
    when(tag80.name()).thenReturn("Name");
    Tag tag81 = mock(Tag.class);
    when(tag81.name()).thenReturn("Name");
    Tag tag82 = mock(Tag.class);
    when(tag82.name()).thenReturn("Name");
    Tag tag83 = mock(Tag.class);
    when(tag83.name()).thenReturn("Name");
    Tag tag84 = mock(Tag.class);
    when(tag84.name()).thenReturn("Name");
    Tag tag85 = mock(Tag.class);
    when(tag85.name()).thenReturn("Name");
    Tag tag86 = mock(Tag.class);
    when(tag86.name()).thenReturn("Name");
    Tag tag87 = mock(Tag.class);
    when(tag87.name()).thenReturn("Name");
    Tag tag88 = mock(Tag.class);
    when(tag88.name()).thenReturn("Name");
    Tag tag89 = mock(Tag.class);
    when(tag89.name()).thenReturn("Name");
    Tag tag90 = mock(Tag.class);
    when(tag90.name()).thenReturn("Name");
    Tag tag91 = mock(Tag.class);
    when(tag91.name()).thenReturn("Name");
    Tag tag92 = mock(Tag.class);
    when(tag92.name()).thenReturn("Name");
    Tag tag93 = mock(Tag.class);
    when(tag93.name()).thenReturn("Name");
    Tag tag94 = mock(Tag.class);
    when(tag94.name()).thenReturn("Name");
    Tag tag95 = mock(Tag.class);
    when(tag95.name()).thenReturn("Name");
    Tag tag96 = mock(Tag.class);
    when(tag96.name()).thenReturn("Name");
    Tag tag97 = mock(Tag.class);
    when(tag97.name()).thenReturn("foo");

    ArrayList<Tag> tagList = new ArrayList<>();
    tagList.add(tag97);
    tagList.add(tag96);
    tagList.add(tag95);
    tagList.add(tag94);
    tagList.add(tag93);
    tagList.add(tag92);
    tagList.add(tag91);
    tagList.add(tag90);
    tagList.add(tag89);
    tagList.add(tag88);
    tagList.add(tag87);
    tagList.add(tag86);
    tagList.add(tag85);
    tagList.add(tag84);
    tagList.add(tag83);
    tagList.add(tag82);
    tagList.add(tag81);
    tagList.add(tag80);
    tagList.add(tag79);
    tagList.add(tag78);
    tagList.add(tag77);
    tagList.add(tag76);
    tagList.add(tag75);
    tagList.add(tag74);
    tagList.add(tag73);
    tagList.add(tag72);
    tagList.add(tag71);
    tagList.add(tag70);
    tagList.add(tag69);
    tagList.add(tag68);
    tagList.add(tag67);
    tagList.add(tag66);
    tagList.add(tag65);
    tagList.add(tag64);
    tagList.add(tag63);
    tagList.add(tag62);
    tagList.add(tag61);
    tagList.add(tag60);
    tagList.add(tag59);
    tagList.add(tag58);
    tagList.add(tag57);
    tagList.add(tag56);
    tagList.add(tag55);
    tagList.add(tag54);
    tagList.add(tag53);
    tagList.add(tag52);
    tagList.add(tag51);
    tagList.add(tag50);
    tagList.add(tag49);
    tagList.add(tag48);
    tagList.add(tag47);
    tagList.add(tag46);
    tagList.add(tag45);
    tagList.add(tag44);
    tagList.add(tag43);
    tagList.add(tag42);
    tagList.add(tag41);
    tagList.add(tag40);
    tagList.add(tag39);
    tagList.add(tag38);
    tagList.add(tag37);
    tagList.add(tag36);
    tagList.add(tag35);
    tagList.add(tag34);
    tagList.add(tag33);
    tagList.add(tag32);
    tagList.add(tag31);
    tagList.add(tag30);
    tagList.add(tag29);
    tagList.add(tag28);
    tagList.add(tag27);
    tagList.add(tag26);
    tagList.add(tag25);
    tagList.add(tag24);
    tagList.add(tag23);
    tagList.add(tag22);
    tagList.add(tag21);
    tagList.add(tag20);
    tagList.add(tag19);
    tagList.add(tag18);
    tagList.add(tag17);
    tagList.add(tag16);
    tagList.add(tag15);
    tagList.add(tag14);
    tagList.add(tag13);
    tagList.add(tag12);
    tagList.add(tag11);
    tagList.add(tag10);
    tagList.add(tag9);
    tagList.add(tag8);
    tagList.add(tag7);
    tagList.add(tag6);
    tagList.add(tag5);
    tagList.add(tag4);
    tagList.add(tag3);
    tagList.add(tag2);
    tagList.add(tag);
    TagDao tagDao = mock(TagDao.class);
    doNothing().when(tagDao).removeTagUsage(Mockito.<EntityReference>any(), Mockito.<String>any());
    when(tagDao.findTagsForEntityReference(Mockito.<EntityReference>any())).thenReturn(tagList);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    doNothing().when(changeLogService)
        .writeChangeLogEntries(Mockito.<EntityReference>any(), Mockito.<String>any(), Mockito.<String>any(),
            Mockito.<Operation>any());
    TagService tagService = new TagService(tagDao, changeLogService);

    // Act
    List<Tag> actualUpdateTagsResult = tagService.updateTags(null, new ArrayList<>(), "janedoe");

    // Assert
    verify(tagDao, atLeast(1)).findTagsForEntityReference(isNull());
    verify(tagDao, atLeast(1)).removeTagUsage(isNull(), Mockito.<String>any());
    verify(tag97).name();
    verify(tag96).name();
    verify(tag95).name();
    verify(tag94).name();
    verify(tag93).name();
    verify(tag92).name();
    verify(tag91).name();
    verify(tag90).name();
    verify(tag89).name();
    verify(tag88).name();
    verify(tag87).name();
    verify(tag86).name();
    verify(tag85).name();
    verify(tag84).name();
    verify(tag83).name();
    verify(tag82).name();
    verify(tag81).name();
    verify(tag80).name();
    verify(tag79).name();
    verify(tag78).name();
    verify(tag77).name();
    verify(tag76).name();
    verify(tag75).name();
    verify(tag74).name();
    verify(tag73).name();
    verify(tag72).name();
    verify(tag71).name();
    verify(tag70).name();
    verify(tag69).name();
    verify(tag68).name();
    verify(tag67).name();
    verify(tag66).name();
    verify(tag65).name();
    verify(tag64).name();
    verify(tag63).name();
    verify(tag62).name();
    verify(tag61).name();
    verify(tag60).name();
    verify(tag59).name();
    verify(tag58).name();
    verify(tag57).name();
    verify(tag56).name();
    verify(tag55).name();
    verify(tag54).name();
    verify(tag53).name();
    verify(tag52).name();
    verify(tag51).name();
    verify(tag50).name();
    verify(tag49).name();
    verify(tag48).name();
    verify(tag47).name();
    verify(tag46).name();
    verify(tag45).name();
    verify(tag44).name();
    verify(tag43).name();
    verify(tag42).name();
    verify(tag41).name();
    verify(tag40).name();
    verify(tag39).name();
    verify(tag38).name();
    verify(tag37).name();
    verify(tag36).name();
    verify(tag35).name();
    verify(tag34).name();
    verify(tag33).name();
    verify(tag32).name();
    verify(tag31).name();
    verify(tag30).name();
    verify(tag29).name();
    verify(tag28).name();
    verify(tag27).name();
    verify(tag26).name();
    verify(tag25).name();
    verify(tag24).name();
    verify(tag23).name();
    verify(tag22).name();
    verify(tag21).name();
    verify(tag20).name();
    verify(tag19).name();
    verify(tag18).name();
    verify(tag17).name();
    verify(tag16).name();
    verify(tag15).name();
    verify(tag14).name();
    verify(tag13).name();
    verify(tag12).name();
    verify(tag11).name();
    verify(tag10).name();
    verify(tag9).name();
    verify(tag8).name();
    verify(tag7).name();
    verify(tag6).name();
    verify(tag5).name();
    verify(tag4).name();
    verify(tag3).name();
    verify(tag2).name();
    verify(tag).name();
    verify(changeLogService).writeChangeLogEntries((EntityReference) isNull(), eq("janedoe"),
        eq("Removed tags: [foo, Name]. "), eq(Operation.UPDATE));
    assertSame(tagList, actualUpdateTagsResult);
  }
}
