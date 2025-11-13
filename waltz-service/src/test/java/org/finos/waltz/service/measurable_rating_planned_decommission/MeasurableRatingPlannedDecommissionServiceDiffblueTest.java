package org.finos.waltz.service.measurable_rating_planned_decommission;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.common.exception.UpdateFailedException;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.application.search.ApplicationSearchDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.entity_alias.EntityAliasDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable.MeasurableDao;
import org.finos.waltz.data.measurable.search.MeasurableSearchDao;
import org.finos.waltz.data.measurable_category.MeasurableCategoryDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.rating_scheme.RatingSchemeDAO;
import org.finos.waltz.data.tag.TagDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.command.DateFieldChange;
import org.finos.waltz.model.command.ImmutableDateFieldChange;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRating;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRating.Builder;
import org.finos.waltz.model.measurable_rating_planned_decommission.ImmutableMeasurableRatingPlannedDecommission;
import org.finos.waltz.model.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommission;
import org.finos.waltz.model.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionInfo;
import org.finos.waltz.model.measurable_rating_replacement.ImmutableMeasurableRatingReplacement;
import org.finos.waltz.model.measurable_rating_replacement.MeasurableRatingReplacement;
import org.finos.waltz.service.application.ApplicationService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.measurable.MeasurableService;
import org.finos.waltz.service.measurable_rating.MeasurableRatingService;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
import org.finos.waltz.service.tag.TagService;
import org.jooq.Record1;
import org.jooq.Select;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MeasurableRatingPlannedDecommissionServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao;

  @InjectMocks
  private MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService;

  @Mock private MeasurableRatingReplacementDao measurableRatingReplacementDao;

  @Mock private MeasurableRatingService measurableRatingService;

  /**
   * Test {@link MeasurableRatingPlannedDecommissionService#findForEntityRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionService#findForEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntityRef(EntityReference); then return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingPlannedDecommissionService.findForEntityRef(EntityReference)"
  })
  void testFindForEntityRef_thenReturnSet() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    HashSet<MeasurableRatingPlannedDecommission> measurableRatingPlannedDecommissionSet =
        new HashSet<>();
    when(measurableRatingPlannedDecommissionDao.findByEntityRef(Mockito.<EntityReference>any()))
        .thenReturn(measurableRatingPlannedDecommissionSet);
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
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
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao2, measurableSearchDao, nameResolver, changeLogService2);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagService tagService = new TagService(mock(TagDao.class), null);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableRatingService measurableRatingService =
        new MeasurableRatingService(
            measurableRatingDao,
            measurableDao,
            measurableCategoryDao,
            changeLogService,
            ratingSchemeService,
            entityReferenceNameResolver,
            measurableService,
            applicationService,
            null,
            mock(ApplicationDao.class));
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

    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService =
        new MeasurableRatingPlannedDecommissionService(
            measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao,
            measurableRatingService,
            changeLogService3);

    // Act
    Collection<MeasurableRatingPlannedDecommission> actualFindForEntityRefResult =
        measurableRatingPlannedDecommissionService.findForEntityRef(null);

    // Assert
    verify(measurableRatingPlannedDecommissionDao).findByEntityRef(isNull());
    assertTrue(actualFindForEntityRefResult instanceof Set);
    assertTrue(actualFindForEntityRefResult.isEmpty());
    assertSame(measurableRatingPlannedDecommissionSet, actualFindForEntityRefResult);
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionService#findForEntityRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then throw {@link UpdateFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionService#findForEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntityRef(EntityReference); then throw UpdateFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingPlannedDecommissionService.findForEntityRef(EntityReference)"
  })
  void testFindForEntityRef_thenThrowUpdateFailedException() {
    // Arrange
    when(measurableRatingPlannedDecommissionDao.findByEntityRef(Mockito.<EntityReference>any()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () -> measurableRatingPlannedDecommissionService.findForEntityRef(null));
    verify(measurableRatingPlannedDecommissionDao).findByEntityRef(isNull());
  }

  /**
   * Test {@link
   * MeasurableRatingPlannedDecommissionService#findForCategoryAndSubjectIdSelector(Select, long)}.
   *
   * <ul>
   *   <li>Then return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionService#findForCategoryAndSubjectIdSelector(Select, long)}
   */
  @Test
  @DisplayName("Test findForCategoryAndSubjectIdSelector(Select, long); then return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingPlannedDecommissionService.findForCategoryAndSubjectIdSelector(Select, long)"
  })
  void testFindForCategoryAndSubjectIdSelector_thenReturnSet() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    HashSet<MeasurableRatingPlannedDecommission> measurableRatingPlannedDecommissionSet =
        new HashSet<>();
    when(measurableRatingPlannedDecommissionDao.findForCategoryAndSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(measurableRatingPlannedDecommissionSet);
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
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
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao2, measurableSearchDao, nameResolver, changeLogService2);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagService tagService = new TagService(mock(TagDao.class), null);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableRatingService measurableRatingService =
        new MeasurableRatingService(
            measurableRatingDao,
            measurableDao,
            measurableCategoryDao,
            changeLogService,
            ratingSchemeService,
            entityReferenceNameResolver,
            measurableService,
            applicationService,
            null,
            mock(ApplicationDao.class));
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

    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService =
        new MeasurableRatingPlannedDecommissionService(
            measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao,
            measurableRatingService,
            changeLogService3);

    // Act
    Collection<MeasurableRatingPlannedDecommission>
        actualFindForCategoryAndSubjectIdSelectorResult =
            measurableRatingPlannedDecommissionService.findForCategoryAndSubjectIdSelector(
                mock(Select.class), 1L);

    // Assert
    verify(measurableRatingPlannedDecommissionDao)
        .findForCategoryAndSelector(isA(Select.class), eq(1L));
    assertTrue(actualFindForCategoryAndSubjectIdSelectorResult instanceof Set);
    assertTrue(actualFindForCategoryAndSubjectIdSelectorResult.isEmpty());
    assertSame(
        measurableRatingPlannedDecommissionSet, actualFindForCategoryAndSubjectIdSelectorResult);
  }

  /**
   * Test {@link
   * MeasurableRatingPlannedDecommissionService#findForCategoryAndSubjectIdSelector(Select, long)}.
   *
   * <ul>
   *   <li>Then throw {@link UpdateFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionService#findForCategoryAndSubjectIdSelector(Select, long)}
   */
  @Test
  @DisplayName(
      "Test findForCategoryAndSubjectIdSelector(Select, long); then throw UpdateFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingPlannedDecommissionService.findForCategoryAndSubjectIdSelector(Select, long)"
  })
  void testFindForCategoryAndSubjectIdSelector_thenThrowUpdateFailedException() {
    // Arrange
    when(measurableRatingPlannedDecommissionDao.findForCategoryAndSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () ->
            measurableRatingPlannedDecommissionService.findForCategoryAndSubjectIdSelector(
                mock(Select.class), 1L));
    verify(measurableRatingPlannedDecommissionDao)
        .findForCategoryAndSelector(isA(Select.class), eq(1L));
  }

  /**
   * Test {@link
   * MeasurableRatingPlannedDecommissionService#findForCategoryAndMeasurableRatingIdSelector(Select,
   * long)}.
   *
   * <ul>
   *   <li>Then return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionService#findForCategoryAndMeasurableRatingIdSelector(Select,
   * long)}
   */
  @Test
  @DisplayName("Test findForCategoryAndMeasurableRatingIdSelector(Select, long); then return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(Select, long)"
  })
  void testFindForCategoryAndMeasurableRatingIdSelector_thenReturnSet() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    HashSet<MeasurableRatingPlannedDecommission> measurableRatingPlannedDecommissionSet =
        new HashSet<>();
    when(measurableRatingPlannedDecommissionDao.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(measurableRatingPlannedDecommissionSet);
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
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
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao2, measurableSearchDao, nameResolver, changeLogService2);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagService tagService = new TagService(mock(TagDao.class), null);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableRatingService measurableRatingService =
        new MeasurableRatingService(
            measurableRatingDao,
            measurableDao,
            measurableCategoryDao,
            changeLogService,
            ratingSchemeService,
            entityReferenceNameResolver,
            measurableService,
            applicationService,
            null,
            mock(ApplicationDao.class));
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

    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService =
        new MeasurableRatingPlannedDecommissionService(
            measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao,
            measurableRatingService,
            changeLogService3);

    // Act
    Collection<MeasurableRatingPlannedDecommission>
        actualFindForCategoryAndMeasurableRatingIdSelectorResult =
            measurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(
                mock(Select.class), 1L);

    // Assert
    verify(measurableRatingPlannedDecommissionDao)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    assertTrue(actualFindForCategoryAndMeasurableRatingIdSelectorResult instanceof Set);
    assertTrue(actualFindForCategoryAndMeasurableRatingIdSelectorResult.isEmpty());
    assertSame(
        measurableRatingPlannedDecommissionSet,
        actualFindForCategoryAndMeasurableRatingIdSelectorResult);
  }

  /**
   * Test {@link
   * MeasurableRatingPlannedDecommissionService#findForCategoryAndMeasurableRatingIdSelector(Select,
   * long)}.
   *
   * <ul>
   *   <li>Then throw {@link UpdateFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionService#findForCategoryAndMeasurableRatingIdSelector(Select,
   * long)}
   */
  @Test
  @DisplayName(
      "Test findForCategoryAndMeasurableRatingIdSelector(Select, long); then throw UpdateFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(Select, long)"
  })
  void testFindForCategoryAndMeasurableRatingIdSelector_thenThrowUpdateFailedException() {
    // Arrange
    when(measurableRatingPlannedDecommissionDao.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () ->
            measurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(
                mock(Select.class), 1L));
    verify(measurableRatingPlannedDecommissionDao)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
  }

  /**
   * Test {@link
   * MeasurableRatingPlannedDecommissionService#findForReplacingEntityRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionService#findForReplacingEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findForReplacingEntityRef(EntityReference); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingPlannedDecommissionService.findForReplacingEntityRef(EntityReference)"
  })
  void testFindForReplacingEntityRef_thenReturnList() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    ArrayList<MeasurableRatingPlannedDecommissionInfo> measurableRatingPlannedDecommissionInfoList =
        new ArrayList<>();
    when(measurableRatingPlannedDecommissionDao.findByReplacingEntityRef(
            Mockito.<EntityReference>any()))
        .thenReturn(measurableRatingPlannedDecommissionInfoList);
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
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
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao2, measurableSearchDao, nameResolver, changeLogService2);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagService tagService = new TagService(mock(TagDao.class), null);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableRatingService measurableRatingService =
        new MeasurableRatingService(
            measurableRatingDao,
            measurableDao,
            measurableCategoryDao,
            changeLogService,
            ratingSchemeService,
            entityReferenceNameResolver,
            measurableService,
            applicationService,
            null,
            mock(ApplicationDao.class));
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

    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService =
        new MeasurableRatingPlannedDecommissionService(
            measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao,
            measurableRatingService,
            changeLogService3);

    // Act
    Collection<MeasurableRatingPlannedDecommissionInfo> actualFindForReplacingEntityRefResult =
        measurableRatingPlannedDecommissionService.findForReplacingEntityRef(null);

    // Assert
    verify(measurableRatingPlannedDecommissionDao).findByReplacingEntityRef(isNull());
    assertTrue(actualFindForReplacingEntityRefResult instanceof List);
    assertTrue(actualFindForReplacingEntityRefResult.isEmpty());
    assertSame(measurableRatingPlannedDecommissionInfoList, actualFindForReplacingEntityRefResult);
  }

  /**
   * Test {@link
   * MeasurableRatingPlannedDecommissionService#findForReplacingEntityRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then throw {@link UpdateFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionService#findForReplacingEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findForReplacingEntityRef(EntityReference); then throw UpdateFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingPlannedDecommissionService.findForReplacingEntityRef(EntityReference)"
  })
  void testFindForReplacingEntityRef_thenThrowUpdateFailedException() {
    // Arrange
    when(measurableRatingPlannedDecommissionDao.findByReplacingEntityRef(
            Mockito.<EntityReference>any()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () -> measurableRatingPlannedDecommissionService.findForReplacingEntityRef(null));
    verify(measurableRatingPlannedDecommissionDao).findByReplacingEntityRef(isNull());
  }

  /**
   * Test {@link
   * MeasurableRatingPlannedDecommissionService#findForReplacingSubjectIdSelectorAndCategory(GenericSelector,
   * long)}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionService#findForReplacingSubjectIdSelectorAndCategory(GenericSelector,
   * long)}
   */
  @Test
  @DisplayName(
      "Test findForReplacingSubjectIdSelectorAndCategory(GenericSelector, long); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(GenericSelector, long)"
  })
  void testFindForReplacingSubjectIdSelectorAndCategory_thenReturnList() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    ArrayList<MeasurableRatingPlannedDecommissionInfo> measurableRatingPlannedDecommissionInfoList =
        new ArrayList<>();
    when(measurableRatingPlannedDecommissionDao.findForReplacingSubjectIdSelectorAndCategory(
            Mockito.<GenericSelector>any(), Mockito.<Long>any()))
        .thenReturn(measurableRatingPlannedDecommissionInfoList);
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
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
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao2, measurableSearchDao, nameResolver, changeLogService2);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagService tagService = new TagService(mock(TagDao.class), null);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableRatingService measurableRatingService =
        new MeasurableRatingService(
            measurableRatingDao,
            measurableDao,
            measurableCategoryDao,
            changeLogService,
            ratingSchemeService,
            entityReferenceNameResolver,
            measurableService,
            applicationService,
            null,
            mock(ApplicationDao.class));
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

    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService =
        new MeasurableRatingPlannedDecommissionService(
            measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao,
            measurableRatingService,
            changeLogService3);

    // Act
    Collection<MeasurableRatingPlannedDecommissionInfo>
        actualFindForReplacingSubjectIdSelectorAndCategoryResult =
            measurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(
                null, 1L);

    // Assert
    verify(measurableRatingPlannedDecommissionDao)
        .findForReplacingSubjectIdSelectorAndCategory(isNull(), eq(1L));
    assertTrue(actualFindForReplacingSubjectIdSelectorAndCategoryResult instanceof List);
    assertTrue(actualFindForReplacingSubjectIdSelectorAndCategoryResult.isEmpty());
    assertSame(
        measurableRatingPlannedDecommissionInfoList,
        actualFindForReplacingSubjectIdSelectorAndCategoryResult);
  }

  /**
   * Test {@link
   * MeasurableRatingPlannedDecommissionService#findForReplacingSubjectIdSelectorAndCategory(GenericSelector,
   * long)}.
   *
   * <ul>
   *   <li>Then throw {@link UpdateFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionService#findForReplacingSubjectIdSelectorAndCategory(GenericSelector,
   * long)}
   */
  @Test
  @DisplayName(
      "Test findForReplacingSubjectIdSelectorAndCategory(GenericSelector, long); then throw UpdateFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(GenericSelector, long)"
  })
  void testFindForReplacingSubjectIdSelectorAndCategory_thenThrowUpdateFailedException() {
    // Arrange
    when(measurableRatingPlannedDecommissionDao.findForReplacingSubjectIdSelectorAndCategory(
            Mockito.<GenericSelector>any(), Mockito.<Long>any()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () ->
            measurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(
                null, 1L));
    verify(measurableRatingPlannedDecommissionDao)
        .findForReplacingSubjectIdSelectorAndCategory(isNull(), eq(1L));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionService#save(long, DateFieldChange, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionService#save(long,
   * DateFieldChange, String)}
   */
  @Test
  @DisplayName("Test save(long, DateFieldChange, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionService.save(long, DateFieldChange, String)"
  })
  void testSave() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao.getByEntityAndMeasurable(
            Mockito.<EntityReference>any(), anyLong()))
        .thenThrow(
            new UpdateFailedException("Added planned decommission date:%s", "An error occurred"));
    when(measurableRatingPlannedDecommissionDao.save(
            anyLong(), Mockito.<DateFieldChange>any(), Mockito.<String>any()))
        .thenReturn(new Tuple2<>(Operation.ADD, true));

    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);

    Builder descriptionResult =
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
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
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
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao2, measurableSearchDao, nameResolver, changeLogService2);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagService tagService = new TagService(mock(TagDao.class), null);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableRatingService measurableRatingService =
        new MeasurableRatingService(
            measurableRatingDao,
            measurableDao,
            measurableCategoryDao,
            changeLogService,
            ratingSchemeService,
            entityReferenceNameResolver,
            measurableService,
            applicationService,
            null,
            mock(ApplicationDao.class));
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
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

    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService =
        new MeasurableRatingPlannedDecommissionService(
            measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao,
            measurableRatingService,
            changeLogService3);

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () -> measurableRatingPlannedDecommissionService.save(1L, null, "janedoe"));
    verify(measurableRatingDao).getById(1L);
    verify(measurableRatingPlannedDecommissionDao)
        .getByEntityAndMeasurable(isA(EntityReference.class), eq(1L));
    verify(measurableRatingPlannedDecommissionDao).save(eq(1L), isNull(), eq("janedoe"));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionService#save(long, DateFieldChange, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionService#save(long,
   * DateFieldChange, String)}
   */
  @Test
  @DisplayName("Test save(long, DateFieldChange, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionService.save(long, DateFieldChange, String)"
  })
  void testSave2() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao.save(
            anyLong(), Mockito.<DateFieldChange>any(), Mockito.<String>any()))
        .thenReturn(new Tuple2<>(Operation.ADD, false));

    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);

    Builder descriptionResult =
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
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
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
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao2, measurableSearchDao, nameResolver, changeLogService2);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagService tagService = new TagService(mock(TagDao.class), null);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableRatingService measurableRatingService =
        new MeasurableRatingService(
            measurableRatingDao,
            measurableDao,
            measurableCategoryDao,
            changeLogService,
            ratingSchemeService,
            entityReferenceNameResolver,
            measurableService,
            applicationService,
            null,
            mock(ApplicationDao.class));
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
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

    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService =
        new MeasurableRatingPlannedDecommissionService(
            measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao,
            measurableRatingService,
            changeLogService3);

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () -> measurableRatingPlannedDecommissionService.save(1L, null, "janedoe"));
    verify(measurableRatingDao).getById(1L);
    verify(measurableRatingPlannedDecommissionDao).save(eq(1L), isNull(), eq("janedoe"));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionService#save(long, DateFieldChange, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionService#save(long,
   * DateFieldChange, String)}
   */
  @Test
  @DisplayName("Test save(long, DateFieldChange, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionService.save(long, DateFieldChange, String)"
  })
  void testSave3() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    LocalDate plannedDecommissionDate = LocalDate.of(1970, 1, 1);
    LocalDate subjectDecommissionDate = LocalDate.of(1970, 1, 1);
    when(measurableRatingPlannedDecommissionDao.getByEntityAndMeasurable(
            Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(ofResult.atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(ofResult2.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(plannedDecommissionDate)
                .subjectDecommissionDate(subjectDecommissionDate)
                .build());
    when(measurableRatingPlannedDecommissionDao.save(
            anyLong(), Mockito.<DateFieldChange>any(), Mockito.<String>any()))
        .thenReturn(new Tuple2<>(Operation.ADD, true));

    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);

    Builder descriptionResult =
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
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
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
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao2, measurableSearchDao, nameResolver, changeLogService2);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagService tagService = new TagService(mock(TagDao.class), null);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableRatingService measurableRatingService =
        new MeasurableRatingService(
            measurableRatingDao,
            measurableDao,
            measurableCategoryDao,
            changeLogService,
            ratingSchemeService,
            entityReferenceNameResolver,
            measurableService,
            applicationService,
            null,
            mock(ApplicationDao.class));

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();

    ImmutableMeasurableRatingReplacement.Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    ImmutableMeasurableRatingReplacement.Builder lastUpdatedByResult =
        decommissionIdResult
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
            .lastUpdatedBy("2020-03-01");
    measurableRatingReplacementSet.add(
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());

    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(measurableRatingReplacementSet);

    MeasurableRatingDao measurableRatingdao = mock(MeasurableRatingDao.class);

    Builder descriptionResult2 =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingdao.getById(anyLong()))
        .thenReturn(
            descriptionResult2
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

    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult3 = Optional.of(immutableEntityReference);
    when(nameResolver2.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult3);

    ChangeLogService changeLogService3 =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            measurableRatingReplacementDao,
            measurableRatingdao,
            mock(MeasurableRatingPlannedDecommissionDao.class),
            nameResolver2);

    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService =
        new MeasurableRatingPlannedDecommissionService(
            measurableRatingPlannedDecommissionDao,
            mock(MeasurableRatingReplacementDao.class),
            measurableRatingService,
            changeLogService3);

    // Act
    MeasurableRatingPlannedDecommission actualSaveResult =
        measurableRatingPlannedDecommissionService.save(1L, null, "janedoe");

    // Assert
    verify(nameResolver2, atLeast(1)).resolve(Mockito.<EntityReference>any());
    verify(changeLogDao).write(isA(Collection.class));
    verify(measurableRatingDao).getById(1L);
    verify(measurableRatingdao).getById(1L);
    verify(measurableRatingPlannedDecommissionDao)
        .getByEntityAndMeasurable(isA(EntityReference.class), eq(1L));
    verify(measurableRatingPlannedDecommissionDao).save(eq(1L), isNull(), eq("janedoe"));
    verify(measurableRatingReplacementDao).fetchByDecommissionId(1L);
    assertTrue(actualSaveResult instanceof ImmutableMeasurableRatingPlannedDecommission);
    LocalDate plannedDecommissionDateResult = actualSaveResult.plannedDecommissionDate();
    assertEquals("1970-01-01", plannedDecommissionDateResult.toString());
    LocalDate subjectDecommissionDateResult = actualSaveResult.subjectDecommissionDate();
    assertEquals("1970-01-01", subjectDecommissionDateResult.toString());
    assertEquals("2020-03-01", actualSaveResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualSaveResult.createdBy());
    assertEquals(1L, actualSaveResult.id().longValue());
    assertEquals(1L, actualSaveResult.measurableRatingId().longValue());
    assertTrue(actualSaveResult.isValid());
    assertSame(ofResult, actualSaveResult.createdAt().toLocalDate());
    assertSame(ofResult2, actualSaveResult.lastUpdatedAt().toLocalDate());
    assertSame(plannedDecommissionDate, plannedDecommissionDateResult);
    assertSame(subjectDecommissionDate, subjectDecommissionDateResult);
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionService#save(long, DateFieldChange, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionService#save(long,
   * DateFieldChange, String)}
   */
  @Test
  @DisplayName("Test save(long, DateFieldChange, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionService.save(long, DateFieldChange, String)"
  })
  void testSave4() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    LocalDate plannedDecommissionDate = LocalDate.of(1970, 1, 1);
    LocalDate subjectDecommissionDate = LocalDate.of(1970, 1, 1);
    when(measurableRatingPlannedDecommissionDao.getByEntityAndMeasurable(
            Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(ofResult.atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(ofResult2.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(plannedDecommissionDate)
                .subjectDecommissionDate(subjectDecommissionDate)
                .build());
    when(measurableRatingPlannedDecommissionDao.save(
            anyLong(), Mockito.<DateFieldChange>any(), Mockito.<String>any()))
        .thenReturn(new Tuple2<>(Operation.ADD, true));

    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);

    Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingService.getById(anyLong()))
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

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<MeasurableRatingPlannedDecommission>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());

    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService =
        new MeasurableRatingPlannedDecommissionService(
            measurableRatingPlannedDecommissionDao,
            mock(MeasurableRatingReplacementDao.class),
            measurableRatingService,
            changeLogService);

    // Act
    MeasurableRatingPlannedDecommission actualSaveResult =
        measurableRatingPlannedDecommissionService.save(1L, null, "janedoe");

    // Assert
    verify(measurableRatingPlannedDecommissionDao)
        .getByEntityAndMeasurable(isA(EntityReference.class), eq(1L));
    verify(measurableRatingPlannedDecommissionDao).save(eq(1L), isNull(), eq("janedoe"));
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(MeasurableRatingPlannedDecommission.class),
            eq("janedoe"),
            eq("Added planned decommission date:1970-01-01"),
            eq(Operation.ADD));
    verify(measurableRatingService).getById(1L);
    assertTrue(actualSaveResult instanceof ImmutableMeasurableRatingPlannedDecommission);
    LocalDate plannedDecommissionDateResult = actualSaveResult.plannedDecommissionDate();
    assertEquals("1970-01-01", plannedDecommissionDateResult.toString());
    LocalDate subjectDecommissionDateResult = actualSaveResult.subjectDecommissionDate();
    assertEquals("1970-01-01", subjectDecommissionDateResult.toString());
    assertEquals("2020-03-01", actualSaveResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualSaveResult.createdBy());
    assertEquals(1L, actualSaveResult.id().longValue());
    assertEquals(1L, actualSaveResult.measurableRatingId().longValue());
    assertTrue(actualSaveResult.isValid());
    assertSame(ofResult, actualSaveResult.createdAt().toLocalDate());
    assertSame(ofResult2, actualSaveResult.lastUpdatedAt().toLocalDate());
    assertSame(plannedDecommissionDate, plannedDecommissionDateResult);
    assertSame(subjectDecommissionDate, subjectDecommissionDateResult);
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionService#save(long, DateFieldChange, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionService#save(long,
   * DateFieldChange, String)}
   */
  @Test
  @DisplayName("Test save(long, DateFieldChange, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionService.save(long, DateFieldChange, String)"
  })
  void testSave5() {
    // Arrange
    when(measurableRatingPlannedDecommissionDao.getByEntityAndMeasurable(
            Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());
    when(measurableRatingPlannedDecommissionDao.save(
            anyLong(), Mockito.<DateFieldChange>any(), Mockito.<String>any()))
        .thenReturn(new Tuple2<>(Operation.ADD, true));

    Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingService.getById(anyLong()))
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
    doThrow(new UpdateFailedException("Added planned decommission date:%s", "An error occurred"))
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<MeasurableRatingPlannedDecommission>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () -> measurableRatingPlannedDecommissionService.save(1L, null, "janedoe"));
    verify(measurableRatingPlannedDecommissionDao)
        .getByEntityAndMeasurable(isA(EntityReference.class), eq(1L));
    verify(measurableRatingPlannedDecommissionDao).save(eq(1L), isNull(), eq("janedoe"));
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(MeasurableRatingPlannedDecommission.class),
            eq("janedoe"),
            eq("Added planned decommission date:1970-01-01"),
            eq(Operation.ADD));
    verify(measurableRatingService).getById(1L);
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionService#save(long, DateFieldChange, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionService#save(long,
   * DateFieldChange, String)}
   */
  @Test
  @DisplayName("Test save(long, DateFieldChange, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionService.save(long, DateFieldChange, String)"
  })
  void testSave6() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    LocalDate plannedDecommissionDate = LocalDate.of(1970, 1, 1);
    LocalDate subjectDecommissionDate = LocalDate.of(1970, 1, 1);
    when(measurableRatingPlannedDecommissionDao.getByEntityAndMeasurable(
            Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(ofResult.atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(ofResult2.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(plannedDecommissionDate)
                .subjectDecommissionDate(subjectDecommissionDate)
                .build());
    when(measurableRatingPlannedDecommissionDao.save(
            anyLong(), Mockito.<DateFieldChange>any(), Mockito.<String>any()))
        .thenReturn(new Tuple2<>(Operation.UPDATE, true));

    Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingService.getById(anyLong()))
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
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<MeasurableRatingPlannedDecommission>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());

    ImmutableDateFieldChange.Builder descriptionResult2 =
        ImmutableDateFieldChange.builder()
            .description("The characteristics of someone or something");

    ImmutableDateFieldChange.Builder newValResult =
        descriptionResult2.newVal(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    MeasurableRatingPlannedDecommission actualSaveResult =
        measurableRatingPlannedDecommissionService.save(
            1L,
            newValResult
                .oldVal(
                    Date.from(
                        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .build(),
            "janedoe");

    // Assert
    verify(measurableRatingPlannedDecommissionDao)
        .getByEntityAndMeasurable(isA(EntityReference.class), eq(1L));
    verify(measurableRatingPlannedDecommissionDao)
        .save(eq(1L), isA(DateFieldChange.class), eq("janedoe"));
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(MeasurableRatingPlannedDecommission.class),
            eq("janedoe"),
            eq(
                "Updated planned decommission date: from Thu Jan 01 00:00:00 UTC 1970 to 1970-01-01"),
            eq(Operation.UPDATE));
    verify(measurableRatingService).getById(1L);
    assertTrue(actualSaveResult instanceof ImmutableMeasurableRatingPlannedDecommission);
    LocalDate plannedDecommissionDateResult = actualSaveResult.plannedDecommissionDate();
    assertEquals("1970-01-01", plannedDecommissionDateResult.toString());
    LocalDate subjectDecommissionDateResult = actualSaveResult.subjectDecommissionDate();
    assertEquals("1970-01-01", subjectDecommissionDateResult.toString());
    assertEquals("2020-03-01", actualSaveResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualSaveResult.createdBy());
    assertEquals(1L, actualSaveResult.id().longValue());
    assertEquals(1L, actualSaveResult.measurableRatingId().longValue());
    assertTrue(actualSaveResult.isValid());
    assertSame(ofResult, actualSaveResult.createdAt().toLocalDate());
    assertSame(ofResult2, actualSaveResult.lastUpdatedAt().toLocalDate());
    assertSame(plannedDecommissionDate, plannedDecommissionDateResult);
    assertSame(subjectDecommissionDate, subjectDecommissionDateResult);
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionService#save(long, DateFieldChange, String)}.
   *
   * <ul>
   *   <li>Given {@link MeasurableRatingPlannedDecommissionDao}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionService#save(long,
   * DateFieldChange, String)}
   */
  @Test
  @DisplayName(
      "Test save(long, DateFieldChange, String); given MeasurableRatingPlannedDecommissionDao")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionService.save(long, DateFieldChange, String)"
  })
  void testSave_givenMeasurableRatingPlannedDecommissionDao() {
    // Arrange
    when(measurableRatingService.getById(anyLong()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () -> measurableRatingPlannedDecommissionService.save(1L, null, "janedoe"));
    verify(measurableRatingService).getById(1L);
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionService#save(long, DateFieldChange, String)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityReferenceNameResolver#resolve(EntityReference)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionService#save(long,
   * DateFieldChange, String)}
   */
  @Test
  @DisplayName("Test save(long, DateFieldChange, String); then calls resolve(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionService.save(long, DateFieldChange, String)"
  })
  void testSave_thenCallsResolve() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    LocalDate plannedDecommissionDate = LocalDate.of(1970, 1, 1);
    LocalDate subjectDecommissionDate = LocalDate.of(1970, 1, 1);
    when(measurableRatingPlannedDecommissionDao.getByEntityAndMeasurable(
            Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(ofResult.atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(ofResult2.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(plannedDecommissionDate)
                .subjectDecommissionDate(subjectDecommissionDate)
                .build());
    when(measurableRatingPlannedDecommissionDao.save(
            anyLong(), Mockito.<DateFieldChange>any(), Mockito.<String>any()))
        .thenReturn(new Tuple2<>(Operation.ADD, true));

    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);

    Builder descriptionResult =
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
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
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
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao2, measurableSearchDao, nameResolver, changeLogService2);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagService tagService = new TagService(mock(TagDao.class), null);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableRatingService measurableRatingService =
        new MeasurableRatingService(
            measurableRatingDao,
            measurableDao,
            measurableCategoryDao,
            changeLogService,
            ratingSchemeService,
            entityReferenceNameResolver,
            measurableService,
            applicationService,
            null,
            mock(ApplicationDao.class));

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());

    MeasurableRatingDao measurableRatingdao = mock(MeasurableRatingDao.class);

    Builder descriptionResult2 =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingdao.getById(anyLong()))
        .thenReturn(
            descriptionResult2
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

    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult3 = Optional.of(immutableEntityReference);
    when(nameResolver2.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult3);

    ChangeLogService changeLogService3 =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            measurableRatingReplacementDao,
            measurableRatingdao,
            mock(MeasurableRatingPlannedDecommissionDao.class),
            nameResolver2);

    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService =
        new MeasurableRatingPlannedDecommissionService(
            measurableRatingPlannedDecommissionDao,
            mock(MeasurableRatingReplacementDao.class),
            measurableRatingService,
            changeLogService3);

    // Act
    MeasurableRatingPlannedDecommission actualSaveResult =
        measurableRatingPlannedDecommissionService.save(1L, null, "janedoe");

    // Assert
    verify(nameResolver2, atLeast(1)).resolve(Mockito.<EntityReference>any());
    verify(changeLogDao).write(isA(Collection.class));
    verify(measurableRatingDao).getById(1L);
    verify(measurableRatingdao).getById(1L);
    verify(measurableRatingPlannedDecommissionDao)
        .getByEntityAndMeasurable(isA(EntityReference.class), eq(1L));
    verify(measurableRatingPlannedDecommissionDao).save(eq(1L), isNull(), eq("janedoe"));
    verify(measurableRatingReplacementDao).fetchByDecommissionId(1L);
    assertTrue(actualSaveResult instanceof ImmutableMeasurableRatingPlannedDecommission);
    LocalDate plannedDecommissionDateResult = actualSaveResult.plannedDecommissionDate();
    assertEquals("1970-01-01", plannedDecommissionDateResult.toString());
    LocalDate subjectDecommissionDateResult = actualSaveResult.subjectDecommissionDate();
    assertEquals("1970-01-01", subjectDecommissionDateResult.toString());
    assertEquals("2020-03-01", actualSaveResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualSaveResult.createdBy());
    assertEquals(1L, actualSaveResult.id().longValue());
    assertEquals(1L, actualSaveResult.measurableRatingId().longValue());
    assertTrue(actualSaveResult.isValid());
    assertSame(ofResult, actualSaveResult.createdAt().toLocalDate());
    assertSame(ofResult2, actualSaveResult.lastUpdatedAt().toLocalDate());
    assertSame(plannedDecommissionDate, plannedDecommissionDateResult);
    assertSame(subjectDecommissionDate, subjectDecommissionDateResult);
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionService#remove(Long, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionService#remove(Long, String)}
   */
  @Test
  @DisplayName("Test remove(Long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean MeasurableRatingPlannedDecommissionService.remove(Long, String)"})
  void testRemove() {
    // Arrange
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenThrow(
            new UpdateFailedException("Removed planned decommission date", "An error occurred"));
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
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
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao2, measurableSearchDao, nameResolver, changeLogService2);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagService tagService = new TagService(mock(TagDao.class), null);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableRatingService measurableRatingService =
        new MeasurableRatingService(
            measurableRatingDao,
            measurableDao,
            measurableCategoryDao,
            changeLogService,
            ratingSchemeService,
            entityReferenceNameResolver,
            measurableService,
            applicationService,
            null,
            mock(ApplicationDao.class));
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

    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService =
        new MeasurableRatingPlannedDecommissionService(
            measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao,
            measurableRatingService,
            changeLogService3);

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () -> measurableRatingPlannedDecommissionService.remove(1L, "janedoe"));
    verify(measurableRatingReplacementDao).fetchByDecommissionId(1L);
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionService#remove(Long, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionService#remove(Long, String)}
   */
  @Test
  @DisplayName("Test remove(Long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean MeasurableRatingPlannedDecommissionService.remove(Long, String)"})
  void testRemove2() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao.remove(Mockito.<Long>any())).thenReturn(true);

    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
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
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao2, measurableSearchDao, nameResolver, changeLogService3);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagService tagService = new TagService(mock(TagDao.class), null);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableRatingService measurableRatingService =
        new MeasurableRatingService(
            measurableRatingDao,
            measurableDao,
            measurableCategoryDao,
            changeLogService2,
            ratingSchemeService,
            entityReferenceNameResolver,
            measurableService,
            applicationService,
            null,
            mock(ApplicationDao.class));

    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService =
        new MeasurableRatingPlannedDecommissionService(
            measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao,
            measurableRatingService,
            changeLogService);

    // Act
    Boolean actualRemoveResult = measurableRatingPlannedDecommissionService.remove(1L, "janedoe");

    // Assert
    verify(measurableRatingPlannedDecommissionDao).remove(1L);
    verify(measurableRatingReplacementDao).fetchByDecommissionId(1L);
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(EntityReference.class),
            eq("janedoe"),
            eq("Removed planned decommission date"),
            eq(Operation.REMOVE));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionService#remove(Long, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionService#remove(Long, String)}
   */
  @Test
  @DisplayName("Test remove(Long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean MeasurableRatingPlannedDecommissionService.remove(Long, String)"})
  void testRemove3() {
    // Arrange
    when(measurableRatingPlannedDecommissionDao.remove(Mockito.<Long>any())).thenReturn(true);

    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();

    ImmutableMeasurableRatingReplacement.Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    ImmutableMeasurableRatingReplacement.Builder lastUpdatedByResult =
        decommissionIdResult
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
            .lastUpdatedBy("2020-03-01");
    measurableRatingReplacementSet.add(
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());

    ImmutableMeasurableRatingReplacement.Builder decommissionIdResult2 =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.now().atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    ImmutableMeasurableRatingReplacement.Builder lastUpdatedByResult2 =
        decommissionIdResult2
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
            .lastUpdatedBy("2020-03-01");
    measurableRatingReplacementSet.add(
        lastUpdatedByResult2
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(measurableRatingReplacementSet);
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());

    // Act
    Boolean actualRemoveResult = measurableRatingPlannedDecommissionService.remove(1L, "janedoe");

    // Assert
    verify(measurableRatingPlannedDecommissionDao).remove(1L);
    verify(measurableRatingReplacementDao).fetchByDecommissionId(1L);
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(EntityReference.class),
            eq("janedoe"),
            eq(
                "Removed planned decommission date and the associated replacement application/s: [Name]"),
            eq(Operation.REMOVE));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionService#remove(Long, String)}.
   *
   * <ul>
   *   <li>Given {@link MeasurableRatingPlannedDecommissionDao}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionService#remove(Long, String)}
   */
  @Test
  @DisplayName("Test remove(Long, String); given MeasurableRatingPlannedDecommissionDao")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean MeasurableRatingPlannedDecommissionService.remove(Long, String)"})
  void testRemove_givenMeasurableRatingPlannedDecommissionDao() {
    // Arrange
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());
    doThrow(new UpdateFailedException("Removed planned decommission date", "An error occurred"))
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () -> measurableRatingPlannedDecommissionService.remove(1L, "janedoe"));
    verify(measurableRatingReplacementDao).fetchByDecommissionId(1L);
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(EntityReference.class),
            eq("janedoe"),
            eq("Removed planned decommission date"),
            eq(Operation.REMOVE));
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionService#remove(Long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityReferenceNameResolver#resolve(EntityReference)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionService#remove(Long, String)}
   */
  @Test
  @DisplayName("Test remove(Long, String); then calls resolve(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean MeasurableRatingPlannedDecommissionService.remove(Long, String)"})
  void testRemove_thenCallsResolve() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao.remove(Mockito.<Long>any())).thenReturn(true);

    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    MeasurableRatingReplacementDao measurableRatingReplacementDao2 =
        mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao2.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());

    MeasurableRatingDao measurableRatingdao = mock(MeasurableRatingDao.class);

    Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingdao.getById(anyLong()))
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

    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao2 =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao2.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            measurableRatingReplacementDao2,
            measurableRatingdao,
            measurableRatingPlannedDecommissionDao2,
            nameResolver);
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
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
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao2, measurableSearchDao, nameResolver2, changeLogService3);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagService tagService = new TagService(mock(TagDao.class), null);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableRatingService measurableRatingService =
        new MeasurableRatingService(
            measurableRatingDao,
            measurableDao,
            measurableCategoryDao,
            changeLogService2,
            ratingSchemeService,
            entityReferenceNameResolver,
            measurableService,
            applicationService,
            null,
            mock(ApplicationDao.class));

    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService =
        new MeasurableRatingPlannedDecommissionService(
            measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao,
            measurableRatingService,
            changeLogService);

    // Act
    Boolean actualRemoveResult = measurableRatingPlannedDecommissionService.remove(1L, "janedoe");

    // Assert
    verify(nameResolver, atLeast(1)).resolve(Mockito.<EntityReference>any());
    verify(changeLogDao).write(isA(Collection.class));
    verify(measurableRatingdao).getById(1L);
    verify(measurableRatingPlannedDecommissionDao2).getById(1L);
    verify(measurableRatingPlannedDecommissionDao).remove(1L);
    verify(measurableRatingReplacementDao).fetchByDecommissionId(1L);
    verify(measurableRatingReplacementDao2).fetchByDecommissionId(1L);
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionService#remove(Long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityReferenceNameResolver#resolve(EntityReference)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionService#remove(Long, String)}
   */
  @Test
  @DisplayName("Test remove(Long, String); then calls resolve(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean MeasurableRatingPlannedDecommissionService.remove(Long, String)"})
  void testRemove_thenCallsResolve2() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao.remove(Mockito.<Long>any())).thenReturn(true);

    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();

    ImmutableMeasurableRatingReplacement.Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    ImmutableMeasurableRatingReplacement.Builder lastUpdatedByResult =
        decommissionIdResult
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
            .lastUpdatedBy("2020-03-01");
    measurableRatingReplacementSet.add(
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());

    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(measurableRatingReplacementSet);

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    MeasurableRatingReplacementDao measurableRatingReplacementDao2 =
        mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao2.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());

    MeasurableRatingDao measurableRatingdao = mock(MeasurableRatingDao.class);

    Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingdao.getById(anyLong()))
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

    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao2 =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao2.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            measurableRatingReplacementDao2,
            measurableRatingdao,
            measurableRatingPlannedDecommissionDao2,
            nameResolver);
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
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
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao2, measurableSearchDao, nameResolver2, changeLogService3);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagService tagService = new TagService(mock(TagDao.class), null);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableRatingService measurableRatingService =
        new MeasurableRatingService(
            measurableRatingDao,
            measurableDao,
            measurableCategoryDao,
            changeLogService2,
            ratingSchemeService,
            entityReferenceNameResolver,
            measurableService,
            applicationService,
            null,
            mock(ApplicationDao.class));

    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService =
        new MeasurableRatingPlannedDecommissionService(
            measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao,
            measurableRatingService,
            changeLogService);

    // Act
    Boolean actualRemoveResult = measurableRatingPlannedDecommissionService.remove(1L, "janedoe");

    // Assert
    verify(nameResolver, atLeast(1)).resolve(Mockito.<EntityReference>any());
    verify(changeLogDao).write(isA(Collection.class));
    verify(measurableRatingdao).getById(1L);
    verify(measurableRatingPlannedDecommissionDao2).getById(1L);
    verify(measurableRatingPlannedDecommissionDao).remove(1L);
    verify(measurableRatingReplacementDao).fetchByDecommissionId(1L);
    verify(measurableRatingReplacementDao2).fetchByDecommissionId(1L);
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionService#remove(Long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityReferenceNameResolver#resolve(EntityReference)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionService#remove(Long, String)}
   */
  @Test
  @DisplayName("Test remove(Long, String); then calls resolve(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean MeasurableRatingPlannedDecommissionService.remove(Long, String)"})
  void testRemove_thenCallsResolve3() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao.remove(Mockito.<Long>any())).thenReturn(true);

    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();

    ImmutableMeasurableRatingReplacement.Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    ImmutableMeasurableRatingReplacement.Builder lastUpdatedByResult =
        decommissionIdResult
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
            .lastUpdatedBy("2020-03-01");
    measurableRatingReplacementSet.add(
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());

    MeasurableRatingReplacementDao measurableRatingReplacementDao2 =
        mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao2.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(measurableRatingReplacementSet);

    MeasurableRatingDao measurableRatingdao = mock(MeasurableRatingDao.class);

    Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingdao.getById(anyLong()))
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

    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao2 =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao2.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            measurableRatingReplacementDao2,
            measurableRatingdao,
            measurableRatingPlannedDecommissionDao2,
            nameResolver);
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
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
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao2, measurableSearchDao, nameResolver2, changeLogService3);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagService tagService = new TagService(mock(TagDao.class), null);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableRatingService measurableRatingService =
        new MeasurableRatingService(
            measurableRatingDao,
            measurableDao,
            measurableCategoryDao,
            changeLogService2,
            ratingSchemeService,
            entityReferenceNameResolver,
            measurableService,
            applicationService,
            null,
            mock(ApplicationDao.class));

    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService =
        new MeasurableRatingPlannedDecommissionService(
            measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao,
            measurableRatingService,
            changeLogService);

    // Act
    Boolean actualRemoveResult = measurableRatingPlannedDecommissionService.remove(1L, "janedoe");

    // Assert
    verify(nameResolver, atLeast(1)).resolve(Mockito.<EntityReference>any());
    verify(changeLogDao).write(isA(Collection.class));
    verify(measurableRatingdao).getById(1L);
    verify(measurableRatingPlannedDecommissionDao2).getById(1L);
    verify(measurableRatingPlannedDecommissionDao).remove(1L);
    verify(measurableRatingReplacementDao).fetchByDecommissionId(1L);
    verify(measurableRatingReplacementDao2).fetchByDecommissionId(1L);
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionService#remove(Long, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionService#remove(Long, String)}
   */
  @Test
  @DisplayName("Test remove(Long, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean MeasurableRatingPlannedDecommissionService.remove(Long, String)"})
  void testRemove_thenReturnFalse() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao.remove(Mockito.<Long>any())).thenReturn(false);

    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
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
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao2, measurableSearchDao, nameResolver, changeLogService3);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagService tagService = new TagService(mock(TagDao.class), null);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableRatingService measurableRatingService =
        new MeasurableRatingService(
            measurableRatingDao,
            measurableDao,
            measurableCategoryDao,
            changeLogService2,
            ratingSchemeService,
            entityReferenceNameResolver,
            measurableService,
            applicationService,
            null,
            mock(ApplicationDao.class));

    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService =
        new MeasurableRatingPlannedDecommissionService(
            measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao,
            measurableRatingService,
            changeLogService);

    // Act
    Boolean actualRemoveResult = measurableRatingPlannedDecommissionService.remove(1L, "janedoe");

    // Assert
    verify(measurableRatingPlannedDecommissionDao).remove(1L);
    verify(measurableRatingReplacementDao).fetchByDecommissionId(1L);
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(EntityReference.class),
            eq("janedoe"),
            eq("Removed planned decommission date"),
            eq(Operation.REMOVE));
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link
   * MeasurableRatingPlannedDecommissionService#getRequiredRatingEditRole(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionService#getRequiredRatingEditRole(EntityReference)}
   */
  @Test
  @DisplayName("Test getRequiredRatingEditRole(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MeasurableRatingPlannedDecommissionService.getRequiredRatingEditRole(EntityReference)"
  })
  void testGetRequiredRatingEditRole() {
    // Arrange
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.getRequiredRatingEditRole(Mockito.<EntityReference>any()))
        .thenReturn("Required Rating Edit Role");
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
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

    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService =
        new MeasurableRatingPlannedDecommissionService(
            measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao,
            measurableRatingService,
            changeLogService);

    // Act
    String actualRequiredRatingEditRole =
        measurableRatingPlannedDecommissionService.getRequiredRatingEditRole(null);

    // Assert
    verify(measurableRatingService).getRequiredRatingEditRole(isNull());
    assertEquals("Required Rating Edit Role", actualRequiredRatingEditRole);
  }

  /**
   * Test {@link
   * MeasurableRatingPlannedDecommissionService#getRequiredRatingEditRole(EntityReference)}.
   *
   * <ul>
   *   <li>Then calls {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionService#getRequiredRatingEditRole(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test getRequiredRatingEditRole(EntityReference); then calls getRequiredRatingEditRole(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MeasurableRatingPlannedDecommissionService.getRequiredRatingEditRole(EntityReference)"
  })
  void testGetRequiredRatingEditRole_thenCallsGetRequiredRatingEditRole() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.getRequiredRatingEditRole(Mockito.<EntityReference>any()))
        .thenReturn("Required Rating Edit Role");
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
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
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao2, measurableSearchDao, nameResolver, changeLogService2);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagService tagService = new TagService(mock(TagDao.class), null);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableRatingService measurableRatingService =
        new MeasurableRatingService(
            measurableRatingDao,
            measurableDao,
            measurableCategoryDao,
            changeLogService,
            ratingSchemeService,
            entityReferenceNameResolver,
            measurableService,
            applicationService,
            null,
            mock(ApplicationDao.class));
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
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

    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService =
        new MeasurableRatingPlannedDecommissionService(
            measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao,
            measurableRatingService,
            changeLogService3);

    // Act
    String actualRequiredRatingEditRole =
        measurableRatingPlannedDecommissionService.getRequiredRatingEditRole(null);

    // Assert
    verify(measurableDao).getRequiredRatingEditRole(isNull());
    assertEquals("Required Rating Edit Role", actualRequiredRatingEditRole);
  }

  /**
   * Test {@link
   * MeasurableRatingPlannedDecommissionService#getRequiredRatingEditRole(EntityReference)}.
   *
   * <ul>
   *   <li>Then throw {@link UpdateFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionService#getRequiredRatingEditRole(EntityReference)}
   */
  @Test
  @DisplayName("Test getRequiredRatingEditRole(EntityReference); then throw UpdateFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MeasurableRatingPlannedDecommissionService.getRequiredRatingEditRole(EntityReference)"
  })
  void testGetRequiredRatingEditRole_thenThrowUpdateFailedException() {
    // Arrange
    when(measurableRatingService.getRequiredRatingEditRole(Mockito.<EntityReference>any()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () -> measurableRatingPlannedDecommissionService.getRequiredRatingEditRole(null));
    verify(measurableRatingService).getRequiredRatingEditRole(isNull());
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionService#getById(Long)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableMeasurableRatingPlannedDecommission}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionService#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long); then return ImmutableMeasurableRatingPlannedDecommission")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionService.getById(Long)"
  })
  void testGetById_thenReturnImmutableMeasurableRatingPlannedDecommission() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    LocalDate plannedDecommissionDate = LocalDate.of(1970, 1, 1);
    LocalDate subjectDecommissionDate = LocalDate.of(1970, 1, 1);
    when(measurableRatingPlannedDecommissionDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(ofResult.atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(ofResult2.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(plannedDecommissionDate)
                .subjectDecommissionDate(subjectDecommissionDate)
                .build());
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
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
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao2, measurableSearchDao, nameResolver, changeLogService2);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagService tagService = new TagService(mock(TagDao.class), null);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableRatingService measurableRatingService =
        new MeasurableRatingService(
            measurableRatingDao,
            measurableDao,
            measurableCategoryDao,
            changeLogService,
            ratingSchemeService,
            entityReferenceNameResolver,
            measurableService,
            applicationService,
            null,
            mock(ApplicationDao.class));
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

    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService =
        new MeasurableRatingPlannedDecommissionService(
            measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao,
            measurableRatingService,
            changeLogService3);

    // Act
    MeasurableRatingPlannedDecommission actualById =
        measurableRatingPlannedDecommissionService.getById(1L);

    // Assert
    verify(measurableRatingPlannedDecommissionDao).getById(1L);
    assertTrue(actualById instanceof ImmutableMeasurableRatingPlannedDecommission);
    LocalDate plannedDecommissionDateResult = actualById.plannedDecommissionDate();
    assertEquals("1970-01-01", plannedDecommissionDateResult.toString());
    LocalDate subjectDecommissionDateResult = actualById.subjectDecommissionDate();
    assertEquals("1970-01-01", subjectDecommissionDateResult.toString());
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualById.createdBy());
    assertEquals(1L, actualById.id().longValue());
    assertEquals(1L, actualById.measurableRatingId().longValue());
    assertTrue(actualById.isValid());
    assertSame(ofResult, actualById.createdAt().toLocalDate());
    assertSame(ofResult2, actualById.lastUpdatedAt().toLocalDate());
    assertSame(plannedDecommissionDate, plannedDecommissionDateResult);
    assertSame(subjectDecommissionDate, subjectDecommissionDateResult);
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionService#getById(Long)}.
   *
   * <ul>
   *   <li>Then throw {@link UpdateFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingPlannedDecommissionService#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long); then throw UpdateFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionService.getById(Long)"
  })
  void testGetById_thenThrowUpdateFailedException() {
    // Arrange
    when(measurableRatingPlannedDecommissionDao.getById(Mockito.<Long>any()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        UpdateFailedException.class, () -> measurableRatingPlannedDecommissionService.getById(1L));
    verify(measurableRatingPlannedDecommissionDao).getById(1L);
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionService#getByMeasurableRatingId(Long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionService#getByMeasurableRatingId(Long)}
   */
  @Test
  @DisplayName("Test getByMeasurableRatingId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionService.getByMeasurableRatingId(Long)"
  })
  void testGetByMeasurableRatingId() {
    // Arrange
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    LocalDate plannedDecommissionDate = LocalDate.of(1970, 1, 1);
    LocalDate subjectDecommissionDate = LocalDate.of(1970, 1, 1);
    when(measurableRatingPlannedDecommissionDao.getByMeasurableRatingId(Mockito.<Long>any()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(ofResult.atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(ofResult2.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(plannedDecommissionDate)
                .subjectDecommissionDate(subjectDecommissionDate)
                .build());
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
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
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao2, measurableSearchDao, nameResolver, changeLogService2);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagService tagService = new TagService(mock(TagDao.class), null);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableRatingService measurableRatingService =
        new MeasurableRatingService(
            measurableRatingDao,
            measurableDao,
            measurableCategoryDao,
            changeLogService,
            ratingSchemeService,
            entityReferenceNameResolver,
            measurableService,
            applicationService,
            null,
            mock(ApplicationDao.class));
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

    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService =
        new MeasurableRatingPlannedDecommissionService(
            measurableRatingPlannedDecommissionDao,
            measurableRatingReplacementDao,
            measurableRatingService,
            changeLogService3);

    // Act
    MeasurableRatingPlannedDecommission actualByMeasurableRatingId =
        measurableRatingPlannedDecommissionService.getByMeasurableRatingId(1L);

    // Assert
    verify(measurableRatingPlannedDecommissionDao).getByMeasurableRatingId(1L);
    assertTrue(actualByMeasurableRatingId instanceof ImmutableMeasurableRatingPlannedDecommission);
    LocalDate plannedDecommissionDateResult = actualByMeasurableRatingId.plannedDecommissionDate();
    assertEquals("1970-01-01", plannedDecommissionDateResult.toString());
    LocalDate subjectDecommissionDateResult = actualByMeasurableRatingId.subjectDecommissionDate();
    assertEquals("1970-01-01", subjectDecommissionDateResult.toString());
    assertEquals("2020-03-01", actualByMeasurableRatingId.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualByMeasurableRatingId.createdBy());
    assertEquals(1L, actualByMeasurableRatingId.id().longValue());
    assertEquals(1L, actualByMeasurableRatingId.measurableRatingId().longValue());
    assertTrue(actualByMeasurableRatingId.isValid());
    assertSame(ofResult, actualByMeasurableRatingId.createdAt().toLocalDate());
    assertSame(ofResult2, actualByMeasurableRatingId.lastUpdatedAt().toLocalDate());
    assertSame(plannedDecommissionDate, plannedDecommissionDateResult);
    assertSame(subjectDecommissionDate, subjectDecommissionDateResult);
  }

  /**
   * Test {@link MeasurableRatingPlannedDecommissionService#getByMeasurableRatingId(Long)}.
   *
   * <ul>
   *   <li>Then throw {@link UpdateFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingPlannedDecommissionService#getByMeasurableRatingId(Long)}
   */
  @Test
  @DisplayName("Test getByMeasurableRatingId(Long); then throw UpdateFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission MeasurableRatingPlannedDecommissionService.getByMeasurableRatingId(Long)"
  })
  void testGetByMeasurableRatingId_thenThrowUpdateFailedException() {
    // Arrange
    when(measurableRatingPlannedDecommissionDao.getByMeasurableRatingId(Mockito.<Long>any()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () -> measurableRatingPlannedDecommissionService.getByMeasurableRatingId(1L));
    verify(measurableRatingPlannedDecommissionDao).getByMeasurableRatingId(1L);
  }
}
