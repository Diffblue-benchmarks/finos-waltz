package org.finos.waltz.service.measurable_rating_replacement;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.common.exception.UpdateFailedException;
import org.finos.waltz.data.EntityReferenceNameResolver;
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
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRating;
import org.finos.waltz.model.measurable_rating_planned_decommission.ImmutableMeasurableRatingPlannedDecommission;
import org.finos.waltz.model.measurable_rating_replacement.ImmutableMeasurableRatingReplacement;
import org.finos.waltz.model.measurable_rating_replacement.ImmutableMeasurableRatingReplacement.Builder;
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
class MeasurableRatingReplacementServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private EntityReferenceNameResolver entityReferenceNameResolver;

  @Mock private MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao;

  @Mock private MeasurableRatingReplacementDao measurableRatingReplacementDao;

  @InjectMocks private MeasurableRatingReplacementService measurableRatingReplacementService;

  @Mock private MeasurableRatingService measurableRatingService;

  /**
   * Test {@link MeasurableRatingReplacementService#findForEntityRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingReplacementService#findForEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntityRef(EntityReference); then return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingReplacementService.findForEntityRef(EntityReference)"
  })
  void testFindForEntityRef_thenReturnSet() {
    // Arrange
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();
    when(measurableRatingReplacementDao.fetchByEntityRef(Mockito.<EntityReference>any()))
        .thenReturn(measurableRatingReplacementSet);
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

    MeasurableRatingReplacementService measurableRatingReplacementService =
        new MeasurableRatingReplacementService(
            measurableRatingReplacementDao,
            measurableRatingPlannedDecommissionDao,
            measurableRatingService,
            nameResolver2,
            changeLogService3);

    // Act
    Collection<MeasurableRatingReplacement> actualFindForEntityRefResult =
        measurableRatingReplacementService.findForEntityRef(null);

    // Assert
    verify(measurableRatingReplacementDao).fetchByEntityRef(isNull());
    assertTrue(actualFindForEntityRefResult instanceof Set);
    assertTrue(actualFindForEntityRefResult.isEmpty());
    assertSame(measurableRatingReplacementSet, actualFindForEntityRefResult);
  }

  /**
   * Test {@link MeasurableRatingReplacementService#findForEntityRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then throw {@link UpdateFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingReplacementService#findForEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntityRef(EntityReference); then throw UpdateFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingReplacementService.findForEntityRef(EntityReference)"
  })
  void testFindForEntityRef_thenThrowUpdateFailedException() {
    // Arrange
    when(measurableRatingReplacementDao.fetchByEntityRef(Mockito.<EntityReference>any()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () -> measurableRatingReplacementService.findForEntityRef(null));
    verify(measurableRatingReplacementDao).fetchByEntityRef(isNull());
  }

  /**
   * Test {@link MeasurableRatingReplacementService#findForCategoryAndSubjectIdSelector(Select,
   * long)}.
   *
   * <ul>
   *   <li>Then return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingReplacementService#findForCategoryAndSubjectIdSelector(Select, long)}
   */
  @Test
  @DisplayName("Test findForCategoryAndSubjectIdSelector(Select, long); then return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingReplacementService.findForCategoryAndSubjectIdSelector(Select, long)"
  })
  void testFindForCategoryAndSubjectIdSelector_thenReturnSet() {
    // Arrange
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();
    when(measurableRatingReplacementDao.findForCategoryAndSubjectIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(measurableRatingReplacementSet);
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

    MeasurableRatingReplacementService measurableRatingReplacementService =
        new MeasurableRatingReplacementService(
            measurableRatingReplacementDao,
            measurableRatingPlannedDecommissionDao,
            measurableRatingService,
            nameResolver2,
            changeLogService3);

    // Act
    Collection<MeasurableRatingReplacement> actualFindForCategoryAndSubjectIdSelectorResult =
        measurableRatingReplacementService.findForCategoryAndSubjectIdSelector(
            mock(Select.class), 1L);

    // Assert
    verify(measurableRatingReplacementDao)
        .findForCategoryAndSubjectIdSelector(isA(Select.class), eq(1L));
    assertTrue(actualFindForCategoryAndSubjectIdSelectorResult instanceof Set);
    assertTrue(actualFindForCategoryAndSubjectIdSelectorResult.isEmpty());
    assertSame(measurableRatingReplacementSet, actualFindForCategoryAndSubjectIdSelectorResult);
  }

  /**
   * Test {@link MeasurableRatingReplacementService#findForCategoryAndSubjectIdSelector(Select,
   * long)}.
   *
   * <ul>
   *   <li>Then throw {@link UpdateFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingReplacementService#findForCategoryAndSubjectIdSelector(Select, long)}
   */
  @Test
  @DisplayName(
      "Test findForCategoryAndSubjectIdSelector(Select, long); then throw UpdateFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRatingReplacementService.findForCategoryAndSubjectIdSelector(Select, long)"
  })
  void testFindForCategoryAndSubjectIdSelector_thenThrowUpdateFailedException() {
    // Arrange
    when(measurableRatingReplacementDao.findForCategoryAndSubjectIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () ->
            measurableRatingReplacementService.findForCategoryAndSubjectIdSelector(
                mock(Select.class), 1L));
    verify(measurableRatingReplacementDao)
        .findForCategoryAndSubjectIdSelector(isA(Select.class), eq(1L));
  }

  /**
   * Test {@link
   * MeasurableRatingReplacementService#findForCategoryAndMeasurableRatingIdSelector(Select, long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingReplacementService#findForCategoryAndMeasurableRatingIdSelector(Select, long)}
   */
  @Test
  @DisplayName("Test findForCategoryAndMeasurableRatingIdSelector(Select, long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(Select, long)"
  })
  void testFindForCategoryAndMeasurableRatingIdSelector_thenReturnEmpty() {
    // Arrange
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
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

    MeasurableRatingReplacementService measurableRatingReplacementService =
        new MeasurableRatingReplacementService(
            measurableRatingReplacementDao,
            measurableRatingPlannedDecommissionDao,
            measurableRatingService,
            nameResolver2,
            changeLogService3);

    // Act
    Set<MeasurableRatingReplacement> actualFindForCategoryAndMeasurableRatingIdSelectorResult =
        measurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(
            mock(Select.class), 1L);

    // Assert
    verify(measurableRatingReplacementDao)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    assertTrue(actualFindForCategoryAndMeasurableRatingIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * MeasurableRatingReplacementService#findForCategoryAndMeasurableRatingIdSelector(Select, long)}.
   *
   * <ul>
   *   <li>Then throw {@link UpdateFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingReplacementService#findForCategoryAndMeasurableRatingIdSelector(Select, long)}
   */
  @Test
  @DisplayName(
      "Test findForCategoryAndMeasurableRatingIdSelector(Select, long); then throw UpdateFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(Select, long)"
  })
  void testFindForCategoryAndMeasurableRatingIdSelector_thenThrowUpdateFailedException() {
    // Arrange
    when(measurableRatingReplacementDao.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () ->
            measurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(
                mock(Select.class), 1L));
    verify(measurableRatingReplacementDao)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
  }

  /**
   * Test {@link MeasurableRatingReplacementService#save(long, EntityReference, Date, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingReplacementService#save(long, EntityReference,
   * Date, String)}
   */
  @Test
  @DisplayName("Test save(long, EntityReference, Date, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingReplacementService.save(long, EntityReference, Date, String)"
  })
  void testSave() {
    // Arrange
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.save(
            anyLong(), Mockito.<EntityReference>any(), Mockito.<Date>any(), Mockito.<String>any()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));
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

    MeasurableRatingReplacementService measurableRatingReplacementService =
        new MeasurableRatingReplacementService(
            measurableRatingReplacementDao,
            measurableRatingPlannedDecommissionDao,
            measurableRatingService,
            nameResolver2,
            changeLogService3);

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () ->
            measurableRatingReplacementService.save(
                1L,
                null,
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()),
                "janedoe"));
    verify(measurableRatingReplacementDao).save(eq(1L), isNull(), isA(Date.class), eq("janedoe"));
  }

  /**
   * Test {@link MeasurableRatingReplacementService#save(long, EntityReference, Date, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingReplacementService#save(long, EntityReference,
   * Date, String)}
   */
  @Test
  @DisplayName("Test save(long, EntityReference, Date, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingReplacementService.save(long, EntityReference, Date, String)"
  })
  void testSave2() {
    // Arrange
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());

    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
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
    when(measurableRatingReplacementDao.fetchByDecommissionIdAndEntityRef(
            Mockito.<Long>any(), Mockito.<EntityReference>any()))
        .thenReturn(
            lastUpdatedByResult
                .plannedCommissionDate(
                    Date.from(
                        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .build());
    when(measurableRatingReplacementDao.save(
            anyLong(), Mockito.<EntityReference>any(), Mockito.<Date>any(), Mockito.<String>any()))
        .thenReturn(new Tuple2<>(Operation.ATTEST, true));

    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);

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

    MeasurableRatingDao measurableRatingdao = mock(MeasurableRatingDao.class);

    ImmutableMeasurableRating.Builder descriptionResult2 =
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

    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao.getById(Mockito.<Long>any()))
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
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver2.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ChangeLogService changeLogService3 =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            measurableRatingdao,
            measurableRatingPlannedDecommissionDao,
            nameResolver2);

    MeasurableRatingReplacementService measurableRatingReplacementService =
        new MeasurableRatingReplacementService(
            measurableRatingReplacementDao,
            mock(MeasurableRatingPlannedDecommissionDao.class),
            measurableRatingService,
            mock(EntityReferenceNameResolver.class),
            changeLogService3);

    // Act
    Set<MeasurableRatingReplacement> actualSaveResult =
        measurableRatingReplacementService.save(
            1L,
            null,
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()),
            "janedoe");

    // Assert
    verify(nameResolver2, atLeast(1)).resolve(Mockito.<EntityReference>any());
    verify(changeLogDao).write(isA(Collection.class));
    verify(measurableRatingDao).getByDecommId(1L);
    verify(measurableRatingdao).getById(1L);
    verify(measurableRatingPlannedDecommissionDao).getById(1L);
    verify(measurableRatingReplacementDao).fetchByDecommissionId(1L);
    verify(measurableRatingReplacementDao).fetchByDecommissionIdAndEntityRef(eq(1L), isNull());
    verify(measurableRatingReplacementDao).save(eq(1L), isNull(), isA(Date.class), eq("janedoe"));
    assertTrue(actualSaveResult.isEmpty());
  }

  /**
   * Test {@link MeasurableRatingReplacementService#save(long, EntityReference, Date, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingReplacementService#save(long, EntityReference,
   * Date, String)}
   */
  @Test
  @DisplayName("Test save(long, EntityReference, Date, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingReplacementService.save(long, EntityReference, Date, String)"
  })
  void testSave3() {
    // Arrange
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);

    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
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
    when(measurableRatingReplacementDao.fetchByDecommissionIdAndEntityRef(
            Mockito.<Long>any(), Mockito.<EntityReference>any()))
        .thenReturn(
            lastUpdatedByResult
                .plannedCommissionDate(
                    Date.from(
                        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .build());
    when(measurableRatingReplacementDao.save(
            anyLong(), Mockito.<EntityReference>any(), Mockito.<Date>any(), Mockito.<String>any()))
        .thenReturn(new Tuple2<>(Operation.ADD, false));

    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);

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
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
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

    MeasurableRatingReplacementService measurableRatingReplacementService =
        new MeasurableRatingReplacementService(
            measurableRatingReplacementDao,
            measurableRatingPlannedDecommissionDao,
            measurableRatingService,
            nameResolver2,
            changeLogService3);

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () ->
            measurableRatingReplacementService.save(
                1L,
                null,
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()),
                "janedoe"));
    verify(measurableRatingDao).getByDecommId(1L);
    verify(measurableRatingReplacementDao).fetchByDecommissionIdAndEntityRef(eq(1L), isNull());
    verify(measurableRatingReplacementDao).save(eq(1L), isNull(), isA(Date.class), eq("janedoe"));
  }

  /**
   * Test {@link MeasurableRatingReplacementService#save(long, EntityReference, Date, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingReplacementService#save(long, EntityReference,
   * Date, String)}
   */
  @Test
  @DisplayName("Test save(long, EntityReference, Date, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingReplacementService.save(long, EntityReference, Date, String)"
  })
  void testSave4() {
    // Arrange
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());

    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
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
    when(measurableRatingReplacementDao.fetchByDecommissionIdAndEntityRef(
            Mockito.<Long>any(), Mockito.<EntityReference>any()))
        .thenReturn(
            lastUpdatedByResult
                .plannedCommissionDate(
                    Date.from(
                        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .build());
    when(measurableRatingReplacementDao.save(
            anyLong(), Mockito.<EntityReference>any(), Mockito.<Date>any(), Mockito.<String>any()))
        .thenReturn(new Tuple2<>(Operation.ADD, true));

    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);

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

    ChangeLogService changeLogService3 = mock(ChangeLogService.class);
    doNothing()
        .when(changeLogService3)
        .writeChangeLogEntries(
            Mockito.<MeasurableRatingReplacement>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());

    MeasurableRatingReplacementService measurableRatingReplacementService =
        new MeasurableRatingReplacementService(
            measurableRatingReplacementDao,
            mock(MeasurableRatingPlannedDecommissionDao.class),
            measurableRatingService,
            mock(EntityReferenceNameResolver.class),
            changeLogService3);

    // Act
    Set<MeasurableRatingReplacement> actualSaveResult =
        measurableRatingReplacementService.save(
            1L,
            null,
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()),
            "janedoe");

    // Assert
    verify(measurableRatingDao).getByDecommId(1L);
    verify(measurableRatingReplacementDao).fetchByDecommissionId(1L);
    verify(measurableRatingReplacementDao).fetchByDecommissionIdAndEntityRef(eq(1L), isNull());
    verify(measurableRatingReplacementDao).save(eq(1L), isNull(), isA(Date.class), eq("janedoe"));
    verify(changeLogService3)
        .writeChangeLogEntries(
            isA(MeasurableRatingReplacement.class),
            eq("janedoe"),
            eq("Added with planned commission date: Thu Jan 01 00:00:00 UTC 1970"),
            eq(Operation.ADD));
    assertTrue(actualSaveResult.isEmpty());
  }

  /**
   * Test {@link MeasurableRatingReplacementService#save(long, EntityReference, Date, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingReplacementService#save(long, EntityReference,
   * Date, String)}
   */
  @Test
  @DisplayName("Test save(long, EntityReference, Date, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingReplacementService.save(long, EntityReference, Date, String)"
  })
  void testSave5() {
    // Arrange
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());

    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
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
    when(measurableRatingReplacementDao.fetchByDecommissionIdAndEntityRef(
            Mockito.<Long>any(), Mockito.<EntityReference>any()))
        .thenReturn(
            lastUpdatedByResult
                .plannedCommissionDate(
                    Date.from(
                        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .build());
    when(measurableRatingReplacementDao.save(
            anyLong(), Mockito.<EntityReference>any(), Mockito.<Date>any(), Mockito.<String>any()))
        .thenReturn(new Tuple2<>(Operation.ADD, true));

    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingService.getByDecommId(anyLong()))
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
            Mockito.<MeasurableRatingReplacement>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());

    MeasurableRatingReplacementService measurableRatingReplacementService =
        new MeasurableRatingReplacementService(
            measurableRatingReplacementDao,
            mock(MeasurableRatingPlannedDecommissionDao.class),
            measurableRatingService,
            mock(EntityReferenceNameResolver.class),
            changeLogService);

    // Act
    Set<MeasurableRatingReplacement> actualSaveResult =
        measurableRatingReplacementService.save(
            1L,
            null,
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()),
            "janedoe");

    // Assert
    verify(measurableRatingReplacementDao).fetchByDecommissionId(1L);
    verify(measurableRatingReplacementDao).fetchByDecommissionIdAndEntityRef(eq(1L), isNull());
    verify(measurableRatingReplacementDao).save(eq(1L), isNull(), isA(Date.class), eq("janedoe"));
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(MeasurableRatingReplacement.class),
            eq("janedoe"),
            eq("Added with planned commission date: Thu Jan 01 00:00:00 UTC 1970"),
            eq(Operation.ADD));
    verify(measurableRatingService).getByDecommId(1L);
    assertTrue(actualSaveResult.isEmpty());
  }

  /**
   * Test {@link MeasurableRatingReplacementService#save(long, EntityReference, Date, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingReplacementService#save(long, EntityReference,
   * Date, String)}
   */
  @Test
  @DisplayName("Test save(long, EntityReference, Date, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingReplacementService.save(long, EntityReference, Date, String)"
  })
  void testSave6() {
    // Arrange
    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
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
    when(measurableRatingReplacementDao.fetchByDecommissionIdAndEntityRef(
            Mockito.<Long>any(), Mockito.<EntityReference>any()))
        .thenReturn(
            lastUpdatedByResult
                .plannedCommissionDate(
                    Date.from(
                        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .build());
    when(measurableRatingReplacementDao.save(
            anyLong(), Mockito.<EntityReference>any(), Mockito.<Date>any(), Mockito.<String>any()))
        .thenReturn(new Tuple2<>(Operation.ADD, true));
    when(measurableRatingService.getByDecommId(anyLong()))
        .thenThrow(
            new UpdateFailedException("%s with planned commission date: %s", "An error occurred"));

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () ->
            measurableRatingReplacementService.save(
                1L,
                null,
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()),
                "janedoe"));
    verify(measurableRatingReplacementDao).fetchByDecommissionIdAndEntityRef(eq(1L), isNull());
    verify(measurableRatingReplacementDao).save(eq(1L), isNull(), isA(Date.class), eq("janedoe"));
    verify(measurableRatingService).getByDecommId(1L);
  }

  /**
   * Test {@link MeasurableRatingReplacementService#save(long, EntityReference, Date, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingReplacementService#save(long, EntityReference,
   * Date, String)}
   */
  @Test
  @DisplayName("Test save(long, EntityReference, Date, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingReplacementService.save(long, EntityReference, Date, String)"
  })
  void testSave7() {
    // Arrange
    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
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
    when(measurableRatingReplacementDao.fetchByDecommissionIdAndEntityRef(
            Mockito.<Long>any(), Mockito.<EntityReference>any()))
        .thenReturn(
            lastUpdatedByResult
                .plannedCommissionDate(
                    Date.from(
                        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .build());
    when(measurableRatingReplacementDao.save(
            anyLong(), Mockito.<EntityReference>any(), Mockito.<Date>any(), Mockito.<String>any()))
        .thenReturn(new Tuple2<>(Operation.ADD, true));

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingService.getByDecommId(anyLong()))
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
    doThrow(new UpdateFailedException("%s with planned commission date: %s", "An error occurred"))
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<MeasurableRatingReplacement>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () ->
            measurableRatingReplacementService.save(
                1L,
                null,
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()),
                "janedoe"));
    verify(measurableRatingReplacementDao).fetchByDecommissionIdAndEntityRef(eq(1L), isNull());
    verify(measurableRatingReplacementDao).save(eq(1L), isNull(), isA(Date.class), eq("janedoe"));
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(MeasurableRatingReplacement.class),
            eq("janedoe"),
            eq("Added with planned commission date: Thu Jan 01 00:00:00 UTC 1970"),
            eq(Operation.ADD));
    verify(measurableRatingService).getByDecommId(1L);
  }

  /**
   * Test {@link MeasurableRatingReplacementService#save(long, EntityReference, Date, String)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityReferenceNameResolver#resolve(EntityReference)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingReplacementService#save(long, EntityReference,
   * Date, String)}
   */
  @Test
  @DisplayName(
      "Test save(long, EntityReference, Date, String); then calls resolve(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingReplacementService.save(long, EntityReference, Date, String)"
  })
  void testSave_thenCallsResolve() {
    // Arrange
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());

    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
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
    when(measurableRatingReplacementDao.fetchByDecommissionIdAndEntityRef(
            Mockito.<Long>any(), Mockito.<EntityReference>any()))
        .thenReturn(
            lastUpdatedByResult
                .plannedCommissionDate(
                    Date.from(
                        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .build());
    when(measurableRatingReplacementDao.save(
            anyLong(), Mockito.<EntityReference>any(), Mockito.<Date>any(), Mockito.<String>any()))
        .thenReturn(new Tuple2<>(Operation.ADD, true));

    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);

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

    MeasurableRatingDao measurableRatingdao = mock(MeasurableRatingDao.class);

    ImmutableMeasurableRating.Builder descriptionResult2 =
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

    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao.getById(Mockito.<Long>any()))
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
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver2.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ChangeLogService changeLogService3 =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            measurableRatingdao,
            measurableRatingPlannedDecommissionDao,
            nameResolver2);

    MeasurableRatingReplacementService measurableRatingReplacementService =
        new MeasurableRatingReplacementService(
            measurableRatingReplacementDao,
            mock(MeasurableRatingPlannedDecommissionDao.class),
            measurableRatingService,
            mock(EntityReferenceNameResolver.class),
            changeLogService3);

    // Act
    Set<MeasurableRatingReplacement> actualSaveResult =
        measurableRatingReplacementService.save(
            1L,
            null,
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()),
            "janedoe");

    // Assert
    verify(nameResolver2, atLeast(1)).resolve(Mockito.<EntityReference>any());
    verify(changeLogDao).write(isA(Collection.class));
    verify(measurableRatingDao).getByDecommId(1L);
    verify(measurableRatingdao).getById(1L);
    verify(measurableRatingPlannedDecommissionDao).getById(1L);
    verify(measurableRatingReplacementDao).fetchByDecommissionId(1L);
    verify(measurableRatingReplacementDao).fetchByDecommissionIdAndEntityRef(eq(1L), isNull());
    verify(measurableRatingReplacementDao).save(eq(1L), isNull(), isA(Date.class), eq("janedoe"));
    assertTrue(actualSaveResult.isEmpty());
  }

  /**
   * Test {@link MeasurableRatingReplacementService#remove(long, long, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingReplacementService#remove(long, long, String)}
   */
  @Test
  @DisplayName("Test remove(long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableRatingReplacementService.remove(long, long, String)"})
  void testRemove() {
    // Arrange
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.remove(anyLong(), anyLong())).thenReturn(true);
    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(measurableRatingReplacementSet);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
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

    MeasurableRatingReplacementService measurableRatingReplacementService =
        new MeasurableRatingReplacementService(
            measurableRatingReplacementDao,
            measurableRatingPlannedDecommissionDao,
            measurableRatingService,
            mock(EntityReferenceNameResolver.class),
            changeLogService);

    // Act
    Collection<MeasurableRatingReplacement> actualRemoveResult =
        measurableRatingReplacementService.remove(1L, 1L, "janedoe");

    // Assert
    verify(measurableRatingReplacementDao).fetchByDecommissionId(1L);
    verify(measurableRatingReplacementDao).remove(1L, 1L);
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(EntityReference.class), eq("janedoe"), eq("Removed"), eq(Operation.REMOVE));
    assertTrue(actualRemoveResult instanceof Set);
    assertTrue(actualRemoveResult.isEmpty());
    assertSame(measurableRatingReplacementSet, actualRemoveResult);
  }

  /**
   * Test {@link MeasurableRatingReplacementService#remove(long, long, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingReplacementService#remove(long, long, String)}
   */
  @Test
  @DisplayName("Test remove(long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableRatingReplacementService.remove(long, long, String)"})
  void testRemove2() {
    // Arrange
    when(measurableRatingReplacementDao.remove(anyLong(), anyLong()))
        .thenThrow(new UpdateFailedException("kind", "An error occurred"));
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () -> measurableRatingReplacementService.remove(1L, 1L, "janedoe"));
    verify(measurableRatingReplacementDao).remove(1L, 1L);
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(EntityReference.class), eq("janedoe"), eq("Removed"), eq(Operation.REMOVE));
  }

  /**
   * Test {@link MeasurableRatingReplacementService#remove(long, long, String)}.
   *
   * <ul>
   *   <li>Given {@link MeasurableRatingReplacementDao}.
   *   <li>Then throw {@link UpdateFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingReplacementService#remove(long, long, String)}
   */
  @Test
  @DisplayName(
      "Test remove(long, long, String); given MeasurableRatingReplacementDao; then throw UpdateFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableRatingReplacementService.remove(long, long, String)"})
  void testRemove_givenMeasurableRatingReplacementDao_thenThrowUpdateFailedException() {
    // Arrange
    doThrow(new UpdateFailedException("kind", "An error occurred"))
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () -> measurableRatingReplacementService.remove(1L, 1L, "janedoe"));
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(EntityReference.class), eq("janedoe"), eq("Removed"), eq(Operation.REMOVE));
  }

  /**
   * Test {@link MeasurableRatingReplacementService#remove(long, long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityReferenceNameResolver#resolve(EntityReference)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingReplacementService#remove(long, long, String)}
   */
  @Test
  @DisplayName("Test remove(long, long, String); then calls resolve(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableRatingReplacementService.remove(long, long, String)"})
  void testRemove_thenCallsResolve() {
    // Arrange
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.remove(anyLong(), anyLong())).thenReturn(true);
    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(measurableRatingReplacementSet);

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    MeasurableRatingReplacementDao measurableRatingReplacementDao2 =
        mock(MeasurableRatingReplacementDao.class);

    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
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
    when(measurableRatingReplacementDao2.getById(Mockito.<Long>any()))
        .thenReturn(
            lastUpdatedByResult
                .plannedCommissionDate(
                    Date.from(
                        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .build());

    MeasurableRatingDao measurableRatingdao = mock(MeasurableRatingDao.class);

    ImmutableMeasurableRating.Builder descriptionResult =
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

    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao.getById(Mockito.<Long>any()))
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
            measurableRatingPlannedDecommissionDao,
            nameResolver);
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao2 =
        mock(MeasurableRatingPlannedDecommissionDao.class);
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

    MeasurableRatingReplacementService measurableRatingReplacementService =
        new MeasurableRatingReplacementService(
            measurableRatingReplacementDao,
            measurableRatingPlannedDecommissionDao2,
            measurableRatingService,
            mock(EntityReferenceNameResolver.class),
            changeLogService);

    // Act
    Collection<MeasurableRatingReplacement> actualRemoveResult =
        measurableRatingReplacementService.remove(1L, 1L, "janedoe");

    // Assert
    verify(nameResolver, atLeast(1)).resolve(Mockito.<EntityReference>any());
    verify(changeLogDao).write(isA(Collection.class));
    verify(measurableRatingdao).getById(1L);
    verify(measurableRatingPlannedDecommissionDao).getById(1L);
    verify(measurableRatingReplacementDao).fetchByDecommissionId(1L);
    verify(measurableRatingReplacementDao2).getById(1L);
    verify(measurableRatingReplacementDao).remove(1L, 1L);
    assertTrue(actualRemoveResult instanceof Set);
    assertTrue(actualRemoveResult.isEmpty());
    assertSame(measurableRatingReplacementSet, actualRemoveResult);
  }

  /**
   * Test {@link MeasurableRatingReplacementService#getRequiredRatingEditRole(EntityReference)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingReplacementService#getRequiredRatingEditRole(EntityReference)}
   */
  @Test
  @DisplayName("Test getRequiredRatingEditRole(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MeasurableRatingReplacementService.getRequiredRatingEditRole(EntityReference)"
  })
  void testGetRequiredRatingEditRole() {
    // Arrange
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.getRequiredRatingEditRole(Mockito.<EntityReference>any()))
        .thenReturn("Required Rating Edit Role");
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableRatingReplacementService measurableRatingReplacementService =
        new MeasurableRatingReplacementService(
            measurableRatingReplacementDao,
            measurableRatingPlannedDecommissionDao,
            measurableRatingService,
            nameResolver,
            changeLogService);

    // Act
    String actualRequiredRatingEditRole =
        measurableRatingReplacementService.getRequiredRatingEditRole(null);

    // Assert
    verify(measurableRatingService).getRequiredRatingEditRole(isNull());
    assertEquals("Required Rating Edit Role", actualRequiredRatingEditRole);
  }

  /**
   * Test {@link MeasurableRatingReplacementService#getRequiredRatingEditRole(EntityReference)}.
   *
   * <ul>
   *   <li>Then calls {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingReplacementService#getRequiredRatingEditRole(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test getRequiredRatingEditRole(EntityReference); then calls getRequiredRatingEditRole(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MeasurableRatingReplacementService.getRequiredRatingEditRole(EntityReference)"
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
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
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

    MeasurableRatingReplacementService measurableRatingReplacementService =
        new MeasurableRatingReplacementService(
            measurableRatingReplacementDao,
            measurableRatingPlannedDecommissionDao,
            measurableRatingService,
            nameResolver2,
            changeLogService3);

    // Act
    String actualRequiredRatingEditRole =
        measurableRatingReplacementService.getRequiredRatingEditRole(null);

    // Assert
    verify(measurableDao).getRequiredRatingEditRole(isNull());
    assertEquals("Required Rating Edit Role", actualRequiredRatingEditRole);
  }

  /**
   * Test {@link MeasurableRatingReplacementService#getRequiredRatingEditRole(EntityReference)}.
   *
   * <ul>
   *   <li>Then throw {@link UpdateFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingReplacementService#getRequiredRatingEditRole(EntityReference)}
   */
  @Test
  @DisplayName("Test getRequiredRatingEditRole(EntityReference); then throw UpdateFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MeasurableRatingReplacementService.getRequiredRatingEditRole(EntityReference)"
  })
  void testGetRequiredRatingEditRole_thenThrowUpdateFailedException() {
    // Arrange
    when(measurableRatingService.getRequiredRatingEditRole(Mockito.<EntityReference>any()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () -> measurableRatingReplacementService.getRequiredRatingEditRole(null));
    verify(measurableRatingService).getRequiredRatingEditRole(isNull());
  }

  /**
   * Test {@link MeasurableRatingReplacementService#findByDecommId(Long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingReplacementService#findByDecommId(Long)}
   */
  @Test
  @DisplayName("Test findByDecommId(Long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableRatingReplacementService.findByDecommId(Long)"})
  void testFindByDecommId_thenReturnEmpty() {
    // Arrange
    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());
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

    MeasurableRatingReplacementService measurableRatingReplacementService =
        new MeasurableRatingReplacementService(
            measurableRatingReplacementDao,
            measurableRatingPlannedDecommissionDao,
            measurableRatingService,
            nameResolver2,
            changeLogService3);

    // Act
    Set<MeasurableRatingReplacement> actualFindByDecommIdResult =
        measurableRatingReplacementService.findByDecommId(1L);

    // Assert
    verify(measurableRatingReplacementDao).fetchByDecommissionId(1L);
    assertTrue(actualFindByDecommIdResult.isEmpty());
  }

  /**
   * Test {@link MeasurableRatingReplacementService#findByDecommId(Long)}.
   *
   * <ul>
   *   <li>Then throw {@link UpdateFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingReplacementService#findByDecommId(Long)}
   */
  @Test
  @DisplayName("Test findByDecommId(Long); then throw UpdateFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableRatingReplacementService.findByDecommId(Long)"})
  void testFindByDecommId_thenThrowUpdateFailedException() {
    // Arrange
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        UpdateFailedException.class, () -> measurableRatingReplacementService.findByDecommId(1L));
    verify(measurableRatingReplacementDao).fetchByDecommissionId(1L);
  }
}
